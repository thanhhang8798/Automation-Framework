package jquery;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jquery.GoFilePO;

public class Topic_08_Config_Browser extends BaseTest {

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

    }

    @Test
    public void Table_01_() throws InterruptedException {
        Thread.sleep(3000);
    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;

}