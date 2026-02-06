package orangehrm;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.DataJsonArray;
import testdata.DataMultipleLevels;

public class Login_19_Data_Json_Multiple extends BaseTest {
    private WebDriver driver;
    private DataMultipleLevels userInfo;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);
        userInfo = DataMultipleLevels.getUser();

        System.out.println("fullname: " + userInfo.getFullName());
        System.out.println("username: " + userInfo.getUsername());
        System.out.println("password: " + userInfo.getPassword());
        System.out.println("firstname: " + userInfo.getFirstname());
        System.out.println("lasname: " + userInfo.getLasname());
    }

    @Test
    public void Employee_01_CreateNewEmployedd() {
    }





    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}