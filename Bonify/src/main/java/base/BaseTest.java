package base;

import config.ConfigReader;
import drivers.DriverFactory;
import listeners.TestListener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestDataGenerator;
import utils.WebBrowserWaiter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@Listeners(TestListener.class)
public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected TestDataGenerator testData;
    protected WebBrowserWaiter webBrowserWaiter;


    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        webBrowserWaiter = new WebBrowserWaiter(driver, 60);
        testData = new TestDataGenerator();
        driver.get(ConfigReader.getProperty("base.url"));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            DriverFactory.removeDriver();
        }
    }

    public static String captureScreenshot(String screenshotName) {
        try {
            WebDriver driver = DriverFactory.getDriver();
            File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshots/" + screenshotName + "_" + timestamp + ".png";

            FileUtils.copyFile(source, new File(screenshotPath));
            return screenshotPath;
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
            return "";
        }
    }


}