package orangehrm;

import core.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.EnvironmentConfig;

public class Login_30_Factory_Environment extends BaseTest {
    private WebDriver driver;
    private EnvironmentConfig serverConfig;

    @Parameters({"serverName", "envName", "osName", "osVersion", "browserName", "browserVersion"})
    @BeforeClass
    public void beforeClass(@Optional("product") String serverName, @Optional("local") String envName, @Optional("window") String osName, @Optional("11") String osVersion, @Optional("chrome") String browserName, @Optional("latest") String browserVersion) {
        // gán giá trị environment ở file xml vào biến động env
        ConfigFactory.setProperty("env", serverName);

        // khởi tạo instance cho interface EnvironmentConfig
        serverConfig = ConfigFactory.create(EnvironmentConfig.class);

        driver = getBrowserDriver(serverConfig.getAppUrl(), envName, osName, osVersion, browserName, browserVersion);
        System.out.println("url: " + serverConfig.getAppUrl());
    }

    @Test
    public void Employee_01_CreateNewEmployedd() {
    }


    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}