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
import pageObjects.orangeHRM.pim.addEmployee.ContactDetailPageObject;
import pageObjects.orangeHRM.pim.employeeList.EmployeeListPageObject;
import pageObjects.orangeHRM.pim.addEmployee.PersonalDetailPageObject;

public class Login_06_Page_Manage_II extends BaseTest {
    // cách 3: Page generator manager class

    private WebDriver driver;
    String employeeID, adminUsername, adminPassword, employeeFirstName, employeeLastName;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        loginPage = PageGeneratorManager.getLoginPage(driver);

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
        dashboardPage = loginPage.clickToLoginButton();

        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));
        employeeListPage = dashboardPage.clickToPIMModule();

        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));
        addEmployeePage.enterToFirstNameTextbox(employeeFirstName);
        addEmployeePage.enterToLastNameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();
        personalDetalPage = addEmployeePage.clickToSaveButton();
        // Assert.assertTrue(personalDetalPage.isLoadingSpinnerDisappear(driver));

        Assert.assertTrue(personalDetalPage.isLoadingSpinnerDisappear(driver));
        Assert.assertEquals(personalDetalPage.getFirstNameTextboxValue(),employeeFirstName);
        Assert.assertEquals(personalDetalPage.getLastNameTextboxValue(),employeeLastName);
        Assert.assertEquals(personalDetalPage.getEmployeeIDTextboxValue(), employeeID);
    }

    @Test
    public void Employee_02_ContactDetail() {
        contactDetailPage = personalDetalPage.clickContactDetailButton();
    }
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private AddEmployeePageObject addEmployeePage;
    private EmployeeListPageObject employeeListPage;
    private PersonalDetailPageObject personalDetalPage;
    private ContactDetailPageObject contactDetailPage;

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}