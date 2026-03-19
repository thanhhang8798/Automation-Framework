package orangehrm;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testdata.EmployeeListJson;

public class Login_21_Data_Json_EmployeeList extends BaseTest {
    private WebDriver driver;
    private EmployeeListJson employeeListInfo;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowser(webUrl, browserName);
        employeeListInfo = EmployeeListJson.getEmployeeList();

        for (EmployeeListJson.Employee employee : employeeListInfo.getEmployees()) {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
            System.out.println(employee.getEmail());
        }
    }

    @Test
    public void Employee_01_CreateNewEmployedd() {
    }





    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}