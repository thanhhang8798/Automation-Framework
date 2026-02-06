package orangehrm;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.DataJsonArray;

public class Login_20_Data_Json_Array extends BaseTest {
    private WebDriver driver;
    private DataJsonArray employeeInfo;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);
        employeeInfo = DataJsonArray.getEmployee();

        System.out.println("name: " + employeeInfo.getName());
        System.out.println("position: " + employeeInfo.getPosition());
        System.out.println("skilltree: " + employeeInfo.getSkilltree().get(1));
        System.out.println("address: " + employeeInfo.getAddress().getStreet());
        System.out.println("addressNo: " + employeeInfo.getAddress().getStreetNo());
    }

    @Test
    public void Employee_01_CreateNewEmployedd() {
    }





    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}