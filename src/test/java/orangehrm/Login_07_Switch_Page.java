package orangehrm;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.*;
import pageObjects.orangeHRM.pim.addEmployee.*;
import pageObjects.orangeHRM.pim.employeeList.*;

public class Login_07_Switch_Page extends BaseTest {
    private WebDriver driver;
    String employeeID, adminUsername, adminPassword, employeeFirstName, employeeLastName;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        loginPage = PageGenerator.getPage(LoginPageObject.class, driver);

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
        personalDetailPage = addEmployeePage.clickToSaveButton();
        // Assert.assertTrue(personalDetalPage.isLoadingSpinnerDisappear(driver));

        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(),employeeFirstName);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(),employeeLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }

//    @Test
//    public void Employee_02_Switch_Page() {
//        // từ personal qua contact
//        contactDetailPage = personalDetailPage.clickContactDetailButton(driver);
//
//        // từ contact qua job
//        jobPage = contactDetailPage.openJobPage(driver);
//
//        // từ job qua dependent
//        dependentsPage = jobPage.openDependentsPage(driver);
//
//        // từ dependent qua personal
//        personalDetailPage = dependentsPage.openPersonalDetailPage(driver);
//
//        // từ personal qua job
//        jobPage = personalDetailPage.openJobPage(driver);
//    }


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