package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@data-testid='register-button']")
    private WebElement registerLink;

    @FindBy(id = "usercentrics-root")
    private WebElement cookieShadowRootHost;

    @FindBy(xpath = "//a[@data-testid='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//font[text()='Wieder einloggen']")
    private List<WebElement> loggedOutText;



    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        closeCookiePopUp();
    }

    public void clickRegister() {
        registerLink.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }


    public void verifyLoggedOutText() {
        Assert.assertTrue(!loggedOutText.isEmpty(),"Logout text Is not present");
    }






}