package orangehrm;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.DataJsonArray;
import utilities.PropertiesConfig;

public class Login_23_Multiple_Environment_Properties extends BaseTest {
    private WebDriver driver;
    private PropertiesConfig propertiesConfig;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environment) {
        driver = getBrowserDriver(PropertiesConfig.getProperties(environment).getApplicationUrl(), browserName);
        System.out.println("url: " + propertiesConfig.getProperties(environment).getApplicationUrl());
    }

    @Test
    public void Employee_01_CreateNewEmployedd() {
    }


    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}