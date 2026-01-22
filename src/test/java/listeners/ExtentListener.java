package listeners;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.testng.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtentListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    static {
        ExtentSparkReporter reporter =
                new ExtentSparkReporter("target/ExtentReport.html");
        reporter.config().setReportName("Automation Test Report");
        reporter.config().setDocumentTitle("Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    private ExtentTest getTest(ITestResult result) {
        if (test.get() == null) {
            ExtentTest extentTest =
                    extent.createTest(result.getMethod().getMethodName());
            test.set(extentTest);
        }
        return test.get();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTest(result).pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest extentTest = getTest(result);
        extentTest.fail(result.getThrowable());

        try {
            Object testClass = result.getInstance();
            WebDriver driver =
                    (WebDriver) result.getTestClass()
                            .getRealClass()
                            .getField("driver")
                            .get(testClass);

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String path = "target/screenshots/" +
                    result.getMethod().getMethodName() + ".png";

            Files.copy(src.toPath(), Paths.get(path));
            extentTest.addScreenCaptureFromPath(path);

        } catch (Exception e) {
            extentTest.warning("Screenshot capture failed");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
