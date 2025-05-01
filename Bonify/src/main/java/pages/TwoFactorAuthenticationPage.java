package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwoFactorAuthenticationPage extends BasePage {


    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logOutButton;


    public TwoFactorAuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        closeCookiePopUp();
    }

    public void clickLogoutButton() {
        logOutButton.click();
    }

}
