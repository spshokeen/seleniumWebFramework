package base;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.WebBrowserWaiter;

public abstract class BasePage {

    protected WebDriver driver;

    protected WebBrowserWaiter webBrowserWaiter;


    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        webBrowserWaiter = new WebBrowserWaiter(this.driver, 20);

    }

    public void closeCookiePopUp() {
        SearchContext shadowRoot = driver.findElement(By.id("usercentrics-root")).getShadowRoot();
        WebElement innerElement = shadowRoot.findElement(By.cssSelector("button[data-testid='uc-accept-all-button']"));
        innerElement.click();

    }

}
