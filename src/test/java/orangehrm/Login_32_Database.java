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
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.pim.addEmployee.*;
import pageObjects.orangeHRM.pim.employeeList.EmployeeListPageObject;

public class Login_32_Database extends BaseTest {
    private WebDriver driver;
    String employeeID, employeeFirstName, employeeLastName;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowser(webUrl, browserName);

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

        dashboardPage.isLoadingSpinnerDisappear(driver);
        employeeListPage = dashboardPage.clickToPIMModule();

        employeeListPage.isLoadingSpinnerDisappear(driver);
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        addEmployeePage.isLoadingSpinnerDisappear(driver);
        addEmployeePage.enterToFirstNameTextbox(employeeFirstName);
        addEmployeePage.enterToLastNameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();
        personalDetailPage = addEmployeePage.clickToSaveButton();
        // Assert.assertTrue(personalDetalPage.isLoadingSpinnerDisappear(driver));

        personalDetailPage.isLoadingSpinnerDisappear(driver);
        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(),employeeFirstName);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(),employeeLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }

    @Test
    public void Employee_02_CheckTotalEmployeeInList() {
        employeeListPage = personalDetailPage.clickToEmployeeListLink();
        employeeListPage.isLoadingSpinnerDisappear(driver);

        int employeeIdOnUI = employeeListPage.getAllEmployeeIdOnUI();
        int employeeIdInDB = employeeListPage.getAllEmployeeIdInDB();
        Assert.assertEquals(employeeIdInDB, employeeIdOnUI);
    }

    @Test
    public void Employee_03_CheckNewEmployeeInList() {
        employeeListPage.enterToEmployeeIdTextboxSearch(employeeID);
        employeeListPage.clickToSearchButton();
        employeeListPage.isLoadingSpinnerDisappear(driver);
        Assert.assertTrue(employeeListPage.isEmployeeInDB(employeeID));
    }


    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private AddEmployeePageObject addEmployeePage;
    private EmployeeListPageObject employeeListPage;
    private PersonalDetailPageObject personalDetailPage;


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}