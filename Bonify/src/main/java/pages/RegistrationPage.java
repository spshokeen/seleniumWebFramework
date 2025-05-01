package pages;


import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegistrationPage extends BasePage {

    @FindBy(id = "user_email")
    private WebElement emailField;

    @FindBy(id = "user_password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='registration_data_consent']/../span")
    private WebElement termsCheckbox;

    @FindBy(id = "form-submit")
    private WebElement submitButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        closeCookiePopUp();
    }

    public void completeRegistration(String email, String password) {
        webBrowserWaiter.waitForElementToBeClickable(emailField);
        emailField.sendKeys(email);
        webBrowserWaiter.waitForElementToBeClickable(passwordField);
        passwordField.sendKeys(password);
        webBrowserWaiter.waitForElementToBeClickable(termsCheckbox);
        termsCheckbox.click();
        webBrowserWaiter.waitForElementToBeClickable(submitButton);
        submitButton.click();
    }
}
