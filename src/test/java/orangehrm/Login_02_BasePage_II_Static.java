package orangehrm;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_02_BasePage_II_Static {
    private WebDriver driver;
    private BasePage basePage;
    private String webUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        basePage= BasePage.getInstance();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
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

    @Test
    public void Login_03_Invalid_Password() {
        basePage.openPageUrl(driver, webUrl);
        basePage.sendKeyToElement(driver, "//input[@name='username']", "Admin");
        basePage.sendKeyToElement(driver, "//input[@name='password']", "123456");
        basePage.clickToElement(driver,"//button[@type='submit']");

        Assert.assertEquals(basePage.getElementText(driver,"//div[@role='alert']//p"), "Invalid credentials");;
    }

    @Test
    public void Login_04_Valid_Username_Password() {
        basePage.openPageUrl(driver, webUrl);
        basePage.sendKeyToElement(driver, "//input[@name='username']", "Admin");
        basePage.sendKeyToElement(driver, "//input[@name='password']", "admin123");
        basePage.clickToElement(driver,"//button[@type='submit']");

        basePage.waitListElementInvisible(driver,"//div[@class='oxd-loading-spinner']");
        Assert.assertEquals(basePage.getElementText(driver,"//span[@class='oxd-topbar-header-breadcrumb']/h6"),"Dashboard");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
