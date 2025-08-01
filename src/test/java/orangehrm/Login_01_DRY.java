package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_01_DRY {
    private WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void Login_01_Empty() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='username']/parent::div/following-sibling::span"))
                .getText(),"Required");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='password']/parent::div/following-sibling::span"))
                .getText(),"Required");
    }

    @Test
    public void Login_02_Invalid_Username() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hang@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']//p"))
                .getText(),"Invalid credentials");
    }

    @Test
    public void Login_03_Invalid_Password() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']//p"))
                .getText(),"Invalid credentials");
    }

    @Test
    public void Login_04_Valid_Username_Password() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions
                .invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='oxd-loading-spinner']"))));
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6"))
                .getText(),"Dashboard");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
