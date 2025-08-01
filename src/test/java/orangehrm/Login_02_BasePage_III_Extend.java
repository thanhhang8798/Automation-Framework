package orangehrm;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_02_BasePage_III_Extend extends BasePage {
    private WebDriver driver;
    private String webUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void Login_01_Empty() {
        openPageUrl(driver, webUrl);
        sendKeyToElement(driver, "//input[@name='username']", "");
        sendKeyToElement(driver, "//input[@name='password']", "");
        clickToElement(driver,"//button[@type='submit']");

        Assert.assertEquals(getElementText(driver,"//input[@name='username']/parent::div/following-sibling::span"), "Required");
        Assert.assertEquals(getElementText(driver,"//input[@name='password']/parent::div/following-sibling::span"), "Required");
    }

    @Test
    public void Login_02_Invalid_Username() {
        openPageUrl(driver, webUrl);
        sendKeyToElement(driver, "//input[@name='username']", "hang@gmail.com");
        sendKeyToElement(driver, "//input[@name='password']", "123456");
        clickToElement(driver,"//button[@type='submit']");

        Assert.assertEquals(getElementText(driver,"//div[@role='alert']//p"), "Invalid credentials");
    }

    @Test
    public void Login_03_Invalid_Password() {
        openPageUrl(driver, webUrl);
        sendKeyToElement(driver, "//input[@name='username']", "Admin");
        sendKeyToElement(driver, "//input[@name='password']", "123456");
        clickToElement(driver,"//button[@type='submit']");

        Assert.assertEquals(getElementText(driver,"//div[@role='alert']//p"), "Invalid credentials");;
    }

    @Test
    public void Login_04_Valid_Username_Password() {
        openPageUrl(driver, webUrl);
        sendKeyToElement(driver, "//input[@name='username']", "Admin");
        sendKeyToElement(driver, "//input[@name='password']", "admin123");
        clickToElement(driver,"//button[@type='submit']");

        waitListElementInvisible(driver,"//div[@class='oxd-loading-spinner']");
        Assert.assertEquals(getElementText(driver,"//span[@class='oxd-topbar-header-breadcrumb']/h6"),"Dashboard");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
