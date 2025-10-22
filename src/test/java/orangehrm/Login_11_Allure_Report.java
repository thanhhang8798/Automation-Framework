package orangehrm;

import core.BaseTest;
import core.GlobalConstants;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.AddEmployeePageObject;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.EmployeeListPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.editEmployeeNavigation.ContactDetailPageObject;
import pageObjects.orangeHRM.editEmployeeNavigation.DependentsPageObject;
import pageObjects.orangeHRM.editEmployeeNavigation.JobPageObject;
import pageObjects.orangeHRM.editEmployeeNavigation.PersonalDetailPageObject;

@Epic("OrangeHrm auto test")
@Feature("Login")
public class Login_11_Allure_Report extends BaseTest {
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

    @Description("Create new Employee")
    @Story("Login")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Employee_01_Login() {
        // Action of login
        loginPage.enterToUsernameTextbox(GlobalConstants.ADMIN_ORANGEHRM_USERNAME);
        loginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_ORANGEHRM_PASSWORD);
        dashboardPage = loginPage.clickToLoginButton();

        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));
        employeeListPage = dashboardPage.clickToPIMModule();

        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));
    }

    @Description("Create new Employee")
    @Story("Save new employee")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Employee_02_AddNewEmployee() {
        addEmployeePage.enterToFirstNameTextbox(employeeFirstName);
        addEmployeePage.enterToLastNameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();
        personalDetailPage = addEmployeePage.clickToSaveButton();
        // Assert.assertTrue(personalDetalPage.isLoadingSpinnerDisappear(driver));

        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
    }

    @Description("Create new Employee")
    @Story("Verify new employee")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Employee_03_VerifyNewEmployee() {
        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(),employeeFirstName);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(),employeeFirstName);
        Assert.assertEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
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
        driver.quit();
    }
}