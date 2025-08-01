package orangehrm;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.*;


public class Login_05_Page_Factory extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(Login_05_Page_Factory.class);
    private WebDriver driver;

    String employeeID, adminUsername, adminPassword, employeeFirstName, employeeLastName;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        // khi mới mở url thì trang xuất hiện là login
        loginPage = new LoginPageFactory(driver);

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
        dashboardPage = new DashboardPageFactory(driver);
        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear());
        dashboardPage.clickToPIMModule();

        // Action of Eployee List
        employeeListPage = new EmployeeListPageFactory(driver);
        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear());
        employeeListPage.clickToAddEmployeeButton();

        // Action of Add employee
        addEmployeePage = new AddEmployeePageFactory(driver);
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear());
        addEmployeePage.enterToFirstNameTextbox(employeeFirstName);
        addEmployeePage.enterToLastNameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSaveButton();
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear());

        // Action of Personal detail
        personalDetalPage = new PersonalDetalPageFactory(driver);
        Assert.assertTrue(personalDetalPage.isLoadingSpinnerDisappear());
        Assert.assertEquals(personalDetalPage.getFirstNameTextboxValue(),employeeFirstName);
        Assert.assertEquals(personalDetalPage.getLastNameTextboxValue(),employeeLastName);
        Assert.assertEquals(personalDetalPage.getEmployeeIDTextboxValue(), employeeID);
    }

    private LoginPageFactory loginPage;
    private DashboardPageFactory dashboardPage;
    private AddEmployeePageFactory addEmployeePage;
    private EmployeeListPageFactory employeeListPage;
    private PersonalDetalPageFactory personalDetalPage;

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
