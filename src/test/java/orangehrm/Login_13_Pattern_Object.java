package orangehrm;

import core.BaseTest;
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
import pageObjects.orangeHRM.editEmployeeNavigation.PersonalDetailPageObject;

@Epic("OrangeHrm auto test")
@Feature("Login")
public class Login_13_Pattern_Object extends BaseTest {

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

    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Employee_01_CreateNewEmployee() {
        // Action of login
        loginPage.enterToTextboxByName(driver, "username", adminUsername);
        loginPage.enterToTextboxByName(driver, "password", adminPassword);
        loginPage.clickToButtonByContainsText(driver, "Login");

        dashboardPage = PageGenerator.getPage(DashboardPageObject.class, driver);
        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));
        dashboardPage.clickToLinkModuleByText(driver, "PIM");

        employeeListPage = PageGenerator.getPage(EmployeeListPageObject.class, driver);
        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        employeeListPage.clickToTabByText(driver, "Add Employee");

        addEmployeePage = PageGenerator.getPage(AddEmployeePageObject.class, driver);
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));
        addEmployeePage.enterToTextboxByName(driver, "firstName", employeeFirstName);
        addEmployeePage.enterToTextboxByName(driver, "lastName", employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToButtonByContainsText(driver, "Save");
        Assert.assertTrue(addEmployeePage.isToastMassageDisplayed(driver, "Successfully Saved"));


        personalDetailPage = PageGenerator.getPage(PersonalDetailPageObject.class, driver);
        // Assert.assertTrue(personalDetalPage.isLoadingSpinnerDisappear(driver));
        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
        Assert.assertEquals(personalDetailPage.getTextboxValueByName(driver, "firstName"),employeeFirstName);
        Assert.assertEquals(personalDetailPage.getTextboxValueByName(driver, "lastName"),employeeLastName);
        Assert.assertEquals(personalDetailPage.getTextboxValueByLabel(driver, "Employee Id"), employeeID);
    }

    @Test
    public void Employee_02_EditEmployee() {
        personalDetailPage.checkToRadioByText(driver, "Female");
        personalDetailPage.selectDropdownByLabelAndText(driver, "Nationality", "American");
        personalDetailPage.selectDropdownByLabelAndText(driver, "Marital Status", "Married");
        personalDetailPage.enterToDatePickerByLabel(driver, "Date of Birth", "1999-09-09");
        personalDetailPage.clickToButtonByContainsText(driver, "Save");

        Assert.assertTrue(personalDetailPage.isToastMassageDisplayed(driver, "Successfully Updated"));
        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));

        Assert.assertEquals(personalDetailPage.getDropdownValueByLabel(driver, "Nationality"), "American");
        Assert.assertEquals(personalDetailPage.getDropdownValueByLabel(driver, "Marital Status"), "Married");
        Assert.assertEquals(personalDetailPage.getTextboxValueByLabel(driver, "Date of Birth"), "1999-09-09");
        Assert.assertTrue(personalDetailPage.isRadioSelectedByText(driver, "Female"));
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