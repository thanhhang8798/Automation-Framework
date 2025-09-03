package orangehrm;

import core.BaseTest;
import core.GlobalConstants;
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

public class Login_09_Dynamic_Locator extends BaseTest {
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
        loginPage.enterToUsernameTextbox(GlobalConstants.ADMIN_ORANGEHRM_USERNAME);
        loginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_ORANGEHRM_PASSWORD);
        dashboardPage = loginPage.clickToLoginButton();

        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));
        employeeListPage = dashboardPage.clickToPIMModule();

        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));
        addEmployeePage.enterToFirstNameTextbox(employeeFirstName);
        addEmployeePage.enterToLastNameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();
        personalDetailPage = addEmployeePage.clickToSaveButton();
        // Assert.assertTrue(personalDetalPage.isLoadingSpinnerDisappear(driver));

        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(),employeeFirstName);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(),employeeLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }

    @Test
    public void Employee_02_Dynamic_Locator() {
        // từ personal qua contact
        contactDetailPage = (ContactDetailPageObject) personalDetailPage.openEditNavigatorByName("Contact Details");

        // từ contact qua job
        jobPage = (JobPageObject) contactDetailPage.openEditNavigatorByName("Job");

        // từ job qua dependent
        dependentsPage = (DependentsPageObject) jobPage.openEditNavigatorByName("Dependents");

        // từ dependent qua personal
        personalDetailPage = (PersonalDetailPageObject) dependentsPage.openEditNavigatorByName("Personal Details");

        // từ personal qua job
        jobPage = (JobPageObject) personalDetailPage.openEditNavigatorByName("Job");
    }

    @Test
    public void Employee_03_Dynamic_Locator() {
        jobPage.openEditNavigatorByNames("Dependents");
        dependentsPage = PageGenerator.getPage(DependentsPageObject.class, driver);

        dependentsPage.openEditNavigatorByNames("Personal Details");
        personalDetailPage = PageGenerator.getPage(PersonalDetailPageObject.class, driver);

        personalDetailPage.openEditNavigatorByNames("Job");
        jobPage = PageGenerator.getPage(JobPageObject.class, driver);

        jobPage.openEditNavigatorByNames("Contact Details");
        contactDetailPage = PageGenerator.getPage(ContactDetailPageObject.class, driver);
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