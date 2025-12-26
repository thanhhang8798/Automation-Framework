package orangehrm;

import core.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
import pageObjects.orangeHRM.pim.addEmployee.PersonalDetailPageObject;

@Epic("OrangeHrm auto test")
@Feature("Login")
public class Login_14_Override_Timeout extends BaseTest {

    private WebDriver driver;
    String employeeID, adminUsername, adminPassword, employeeFirstName, employeeLastName, employeeUsername, employeePassword, employeeConfirmPassword;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        loginPage = PageGenerator.getPage(LoginPageObject.class, driver);

        adminUsername = "automationfc";
        adminPassword = "Auto222@@@";
        employeeFirstName = "Bui";
        employeeLastName = "Hang";
        employeeUsername = "hang.test" + getRandomNumber();
        employeePassword = "Auto222@@@";
        employeeConfirmPassword = "Auto222@@@";
    }

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Employee_01_AdminPermissions() {
        // Action of login
        loginPage.enterToTextboxByName(driver, "username", adminUsername);
        loginPage.enterToTextboxByName(driver, "password", adminPassword);
        loginPage.clickToButtonByContainsText(driver, "Login");

        dashboardPage = PageGenerator.getPage(DashboardPageObject.class, driver);
        verifyTrue(dashboardPage.isLoadingSpinnerDisappear(driver));

        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Admin"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "PIM"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Leave"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Time"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Recruitment"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "My Info"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Performance"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Dashboard"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Directory"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Maintenance"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Claim"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Buzz"));
    }

    @Test
    public void Employee_02_CreateNewEmployee() {
        dashboardPage.clickToLinkModuleByText(driver, "PIM");

        employeeListPage = PageGenerator.getPage(EmployeeListPageObject.class, driver);
        verifyTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        employeeListPage.clickToTabByText(driver, "Add Employee");

        addEmployeePage = PageGenerator.getPage(AddEmployeePageObject.class, driver);
        verifyTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));
        addEmployeePage.enterToTextboxByName(driver, "firstName", employeeFirstName);
        addEmployeePage.enterToTextboxByName(driver, "lastName", employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();

        addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");
        verifyTrue(addEmployeePage.isCheckboxByLabelSelected(driver, "Create Login Details"));
        addEmployeePage.enterToTextboxByLabel(driver, "Username", employeeUsername);
        addEmployeePage.enterToTextboxByLabel(driver, "Password", employeePassword);
        addEmployeePage.enterToTextboxByLabel(driver, "Confirm Password", employeeConfirmPassword);

        addEmployeePage.clickToButtonByContainsText(driver, "Save");
        verifyTrue(addEmployeePage.isToastMassageDisplayed(driver, "Successfully Saved"));

        personalDetailPage = PageGenerator.getPage(PersonalDetailPageObject.class, driver);
        // Assert.assertTrue(personalDetalPage.isLoadingSpinnerDisappear(driver));
        verifyTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
        verifyEquals(personalDetailPage.getTextboxValueByName(driver, "firstName"),employeeFirstName);
        verifyEquals(personalDetailPage.getTextboxValueByName(driver, "lastName"),employeeLastName);
        verifyEquals(personalDetailPage.getTextboxValueByLabel(driver, "Employee Id"), employeeID);
    }

    @Test
    public void Employee_03_EditEmployee() {
        personalDetailPage.checkToRadioByText(driver, "Female");
        personalDetailPage.selectDropdownByLabelAndText(driver, "Nationality", "American");
        personalDetailPage.selectDropdownByLabelAndText(driver, "Marital Status", "Married");
        personalDetailPage.enterToDatePickerByLabel(driver, "Date of Birth", "1999-09-09");
        personalDetailPage.clickToButtonByContainsText(driver, "Save");

        verifyTrue(personalDetailPage.isToastMassageDisplayed(driver, "Successfully Updated"));
        verifyTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));

        verifyEquals(personalDetailPage.getDropdownValueByLabel(driver, "Nationality"), "American");
        verifyEquals(personalDetailPage.getDropdownValueByLabel(driver, "Marital Status"), "Married");
        verifyEquals(personalDetailPage.getTextboxValueByLabel(driver, "Date of Birth"), "1999-09-09");
        verifyTrue(personalDetailPage.isRadioSelectedByText(driver, "Female"));
    }

    @Test
    public void Employee_04_EmployeePermissions() {
        loginPage = personalDetailPage.clickToLogoutLink(driver);

        loginPage.enterToTextboxByName(driver, "username", employeeUsername);
        loginPage.enterToTextboxByName(driver, "password", employeePassword);
        loginPage.clickToButtonByContainsText(driver, "Login");

        dashboardPage = PageGenerator.getPage(DashboardPageObject.class, driver);
        verifyTrue(dashboardPage.isLoadingSpinnerDisappear(driver));


        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Leave"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Time"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "My Info"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Performance"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Dashboard"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Directory"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Claim"));
        verifyTrue(dashboardPage.isModuleByTextInMenuDisplayed(driver, "Buzz"));


        verifyTrue(dashboardPage.isModuleByTextInMenuUnDisplayed(driver, "Admin"));
        verifyTrue(dashboardPage.isModuleByTextInMenuUnDisplayed(driver, "PIM"));
        verifyTrue(dashboardPage.isModuleByTextInMenuUnDisplayed(driver, "Recruitment"));
        verifyTrue(dashboardPage.isModuleByTextInMenuUnDisplayed(driver, "Maintenance"));
    }

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private AddEmployeePageObject addEmployeePage;
    private EmployeeListPageObject employeeListPage;
    private PersonalDetailPageObject personalDetailPage;
    private ContactDetailPageObject contactDetailPage;

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}