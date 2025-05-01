package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    @FindBy(id = "loginId")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        closeCookiePopUp();
    }

    public void login(String email, String password) {
        webBrowserWaiter.waitForElementToBeClickable(loginField);
        loginField.sendKeys(email);
        webBrowserWaiter.waitForElementToBeClickable(passwordField);
        passwordField.sendKeys(password);
        webBrowserWaiter.waitForElementToBeClickable(loginButton);
        loginButton.click();
    }

}
