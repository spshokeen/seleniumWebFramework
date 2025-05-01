package pages;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EmailConfirmationPage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//h2[@data-testid='CONFIRM_EMAIL_TITLE']")
    private WebElement activateAccountElement;


    public EmailConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        closeCookiePopUp();
    }

    public void verifyActiveAccountPage() {
        webBrowserWaiter.waitForVisibilityOf(activateAccountElement);
        Assert.assertTrue(activateAccountElement.getText().contains("Activate your account!"),"Activate your account! text not present");

    }
}
