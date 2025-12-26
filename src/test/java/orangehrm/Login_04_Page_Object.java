package orangehrm;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.*;
import pageObjects.orangeHRM.pim.addEmployee.AddEmployeePageObject;
import pageObjects.orangeHRM.pim.employeeList.EmployeeListPageObject;
import pageObjects.orangeHRM.pim.addEmployee.PersonalDetailPageObject;

public class Login_04_Page_Object extends BaseTest {
    private WebDriver driver;
    String employeeID, adminUsername, adminPassword, employeeFirstName, employeeLastName;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        // khi mới mở url thì trang xuất hiện là login
        loginPage = new LoginPageObject(driver);

        adminUsername = "automationfc";
        adminPassword = "Auto222@@@";
        employeeFirstName = "Bui";
        employeeLastName = "Hang";
    }

    @Test
    public void Employee_01_CreateNewEmployedd() {
        // Action of login
        loginPage.enterToUsernameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);
        loginPage.clickToLoginButton();

        // Action of Dashboard
        dashboardPage = new DashboardPageObject(driver);
        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));
        dashboardPage.clickToPIMModule();

        // Action of Eployee List
        employeeListPage = new EmployeeListPageObject(driver);
        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        employeeListPage.clickToAddEmployeeButton();

        // Action of Add employee
        addEmployeePage = new AddEmployeePageObject(driver);
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));
        addEmployeePage.enterToFirstNameTextbox(employeeFirstName);
        addEmployeePage.enterToLastNameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSaveButton();
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        // Action of Personal detail
        personalDetalPage = new PersonalDetailPageObject(driver);
        Assert.assertTrue(personalDetalPage.isLoadingSpinnerDisappear(driver));
        Assert.assertEquals(personalDetalPage.getFirstNameTextboxValue(),employeeFirstName);
        Assert.assertEquals(personalDetalPage.getLastNameTextboxValue(),employeeLastName);
        Assert.assertEquals(personalDetalPage.getEmployeeIDTextboxValue(), employeeID);
    }

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private AddEmployeePageObject addEmployeePage;
    private EmployeeListPageObject employeeListPage;
    private PersonalDetailPageObject personalDetalPage;

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}