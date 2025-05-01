package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.EmailConfirmationPage;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test(description = "Verify Registration Function")
    public void completeRegistration() {
        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        String email = testData.generateEmail();
        String password = testData.generatePassword();
        registrationPage.completeRegistration(email, password);

        EmailConfirmationPage emailConfirmationPage = new EmailConfirmationPage(driver);
        emailConfirmationPage.verifyActiveAccountPage();
    }
}