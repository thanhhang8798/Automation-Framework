package orangehrm;

import core.BaseTest;
import core.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.pim.addEmployee.AddEmployeePageObject;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.pim.employeeList.EmployeeListPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.pim.addEmployee.ContactDetailPageObject;
import pageObjects.orangeHRM.pim.addEmployee.DependentsPageObject;
import pageObjects.orangeHRM.pim.addEmployee.JobPageObject;
import pageObjects.orangeHRM.pim.addEmployee.PersonalDetailPageObject;

public class Login_10_Log4j extends BaseTest {
    private WebDriver driver;
    String employeeID, employeeFirstName, employeeLastName;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        loginPage = PageGenerator.getPage(LoginPageObject.class, driver);

        employeeFirstName = "Bui";
        employeeLastName = "Hang";
    }

    @Test
    public void Employee_01_CreateNewEmployedd() {
        // Action of login
        log.info("New employee - STEP 01: Enter to Username and Password: " + GlobalConstants.ADMIN_ORANGEHRM_USERNAME + " | " + GlobalConstants.ADMIN_ORANGEHRM_PASSWORD);
        loginPage.enterToUsernameTextbox(GlobalConstants.ADMIN_ORANGEHRM_USERNAME);
        loginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_ORANGEHRM_PASSWORD);

        log.info("New employee - STEP 02: Navigate to Dashboard page");
        dashboardPage = loginPage.clickToLoginButton();
        verifyTrue(dashboardPage.isLoadingSpinnerDisappear(driver));

        log.info("New employee - STEP 03: Navigate to Employee list page");
        employeeListPage = dashboardPage.clickToPIMModule();
        verifyTrue(employeeListPage.isLoadingSpinnerDisappear(driver));

        log.info("New employee - STEP 04: Navigate to Add Employee page");
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();
        verifyTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        log.info("New employee - STEP 05: Enter to Username and Password: " + employeeFirstName + " | " + employeeLastName);
        addEmployeePage.enterToFirstNameTextbox(employeeFirstName);
        addEmployeePage.enterToLastNameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();

        log.info("New employee - STEP 06: Navigate to Personal detail page");
        personalDetailPage = addEmployeePage.clickToSaveButton();
        // Assert.assertTrue(personalDetalPage.isLoadingSpinnerDisappear(driver));
        verifyTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));

        log.info("New employee - STEP 07: Verify employee first name infor: " + employeeFirstName);
        verifyEquals(personalDetailPage.getFirstNameTextboxValue(), employeeLastName);

        log.info("New employee - STEP 08: Verify employee last name infor: " + employeeLastName);
        verifyEquals(personalDetailPage.getLastNameTextboxValue(), employeeLastName);

        log.info("New employee - STEP 09: Verify employee ID infor: " + employeeID);
        verifyEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }


    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private AddEmployeePageObject addEmployeePage;
    private EmployeeListPageObject employeeListPage;
    private PersonalDetailPageObject personalDetailPage;
    private ContactDetailPageObject contactDetailPage;
    private JobPageObject jobPage;
    private DependentsPageObject dependentsPage;

    @AfterClass
    public void afterClass() {
        closeBrowser(driver);
    }
}