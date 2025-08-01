package orangehrm;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_03_Multiple_Browser extends BaseTest {
    private WebDriver driver;
    private BasePage basePage;
    private String webUrl;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        this.webUrl = webUrl;
        basePage= BasePage.getInstance();
        driver = getBrowserDriver(webUrl, browserName);
    }

    @Test
    public void Login_01_Empty() {
        basePage.openPageUrl(driver, webUrl);
        basePage.sendKeyToElement(driver, "//input[@name='username']", "");
        basePage.sendKeyToElement(driver, "//input[@name='password']", "");
        basePage.clickToElement(driver,"//button[@type='submit']");

        Assert.assertEquals(basePage.getElementText(driver,"//input[@name='username']/parent::div/following-sibling::span"), "Required");
        Assert.assertEquals(basePage.getElementText(driver,"//input[@name='password']/parent::div/following-sibling::span"), "Required");
    }

    @Test
    public void Login_02_Invalid_Username() {
        basePage.openPageUrl(driver, webUrl);
        basePage.sendKeyToElement(driver, "//input[@name='username']", "hang@gmail.com");
        basePage.sendKeyToElement(driver, "//input[@name='password']", "123456");
        basePage.clickToElement(driver,"//button[@type='submit']");

        Assert.assertEquals(basePage.getElementText(driver,"//div[@role='alert']//p"), "Invalid credentials");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
