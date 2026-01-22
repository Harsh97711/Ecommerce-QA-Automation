package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
       return ExcelUtils.getTestData(
        "LoginData.xlsx",
        "Sheet1"
);

    }

    @Test(dataProvider = "loginData")
    public void verifyLogin(String username, String password) {

        LoginPage login = new LoginPage(driver);
        login.login(username, password);

        if (password.equals("SuperSecretPassword!")) {
            Assert.assertTrue(login.isLoginSuccess(),
                    "Login should be successful");
        } else {
            Assert.assertTrue(login.isLoginErrorDisplayed(),
                    "Login should fail");
        }
    }
}
