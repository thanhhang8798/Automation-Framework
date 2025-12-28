package orangehrm;

import core.BaseTest;
import core.GlobalConstants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

public class Login_15_Live_Code extends BaseTest {
    private WebDriver driver;
    String employeeID, employeeFirstName, employeeLastName, employeeImage;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        loginPage = PageGenerator.getPage(LoginPageObject.class, driver);

        employeeFirstName = "Bui";
        employeeLastName = "Hang";
        employeeImage = "lshopping.png";

        loginPage.enterToUsernameTextbox(GlobalConstants.ADMIN_ORANGEHRM_USERNAME);
        loginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_ORANGEHRM_PASSWORD);
        dashboardPage = loginPage.clickToLoginButton();
        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));
    }

    @Test
    public void Employee_01_CreateNewEmployedd() {
        employeeListPage = dashboardPage.clickToPIMModule();

        verifyTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        verifyTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));
        addEmployeePage.enterToFirstNameTextbox(employeeFirstName);
        addEmployeePage.enterToLastNameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();
        personalDetailPage = addEmployeePage.clickToSaveButton();
        // Assert.assertTrue(personalDetalPage.isLoadingSpinnerDisappear(driver));

        verifyTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
        verifyEquals(personalDetailPage.getFirstNameTextboxValue(),employeeFirstName);
        verifyEquals(personalDetailPage.getLastNameTextboxValue(),employeeLastName);
        verifyEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }

    @Test
    public void Employee_02_Upload_Image() {
        personalDetailPage.clickToEmployeeImage();
        Dimension beforeUpload = personalDetailPage.getEmployeeSize();

        personalDetailPage.uploadMultipleFiles(driver, employeeImage);
        personalDetailPage.clickToSaveButtonAtProfileContainer();

        verifyTrue(personalDetailPage.isUploadImageSuccessMessageDisplayed());
        personalDetailPage.isLoadingSpinnerDisappear(driver);
        verifyTrue(personalDetailPage.isUploadEmployeeImageSuccess(beforeUpload));
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
        closeBrowser();
    }
}