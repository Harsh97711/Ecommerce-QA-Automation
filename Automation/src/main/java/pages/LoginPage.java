package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.cssSelector("button[type='submit']"); // FIXED

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginErrorDisplayed() {
        return driver.findElement(By.id("flash")).isDisplayed();
    }

    //  METHOD FOR SUCCESS
    public boolean isLoginSuccess() {
        return driver.getCurrentUrl().contains("/secure");
    }
}
