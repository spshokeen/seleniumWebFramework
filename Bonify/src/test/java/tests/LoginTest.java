package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;
import utils.ConstantHelpers;

public class LoginTest extends BaseTest {

    @Test(description = "Verify Login Function")
    public void login() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConstantHelpers.EMAIL,ConstantHelpers.PASSWORD);
        TwoFactorAuthenticationPage twoFactorAuthenticationPage = new TwoFactorAuthenticationPage(driver);
        twoFactorAuthenticationPage.clickLogoutButton();
        homePage.verifyLoggedOutText();


    }
}
