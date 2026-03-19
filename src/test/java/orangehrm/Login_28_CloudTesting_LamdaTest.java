package orangehrm;

import core.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.EnvironmentConfig;

public class Login_28_CloudTesting_LamdaTest extends BaseTest {
    private WebDriver driver;
    private EnvironmentConfig environmentConfig;

    @Parameters({"environment", "platformName", "browserName", "browserVer"})
    @BeforeClass
    public void beforeClass(String environment, String platformName, String browserName, String browserVer) {
        // gán giá trị environment ở file xml vào biến động env
        ConfigFactory.setProperty("env", environment);

        // khởi tạo instance cho interface EnvironmentConfig
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);

        driver = getBrowserDriverByLamdaTest(environmentConfig.getAppUrl(), platformName, browserName, browserVer);
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