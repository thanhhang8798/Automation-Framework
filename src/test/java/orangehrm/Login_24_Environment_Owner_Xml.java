package orangehrm;

import core.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.EnvironmentConfig;

public class Login_24_Environment_Owner_Xml extends BaseTest {
    private WebDriver driver;
    private EnvironmentConfig environmentConfig;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environment) {
        // gán giá trị environment ở file xml vào biến động env
        ConfigFactory.setProperty("env", environment);

        // khởi tạo instance cho interface EnvironmentConfig
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
        driver = getBrowserDriver(environmentConfig.getAppUrl(), browserName);
        System.out.println("url: " + environmentConfig.getAppUrl());
    }

    @Test
    public void Employee_01_CreateNewEmployedd() {
    }


    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}