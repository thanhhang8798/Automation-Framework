package orangehrm;

import core.BaseTest;
import core.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.pim.addEmployee.*;
import pageObjects.orangeHRM.pim.employeeList.EmployeeListPageObject;
import testdata.DataJson;

public class Login_18_Data_Json extends BaseTest {
    private WebDriver driver;
    String employeeID, nationality, maritalStatus, gender;


    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);
        userInfor = DataJson.getUser();

        loginPage = PageGenerator.getPage(LoginPageObject.class, driver);

        nationality = "Vietnamese";
        maritalStatus = "Single";
        gender = "Female";

        loginPage.enterToUsernameTextbox(GlobalConstants.ADMIN_ORANGEHRM_USERNAME);
        loginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_ORANGEHRM_PASSWORD);
        dashboardPage = loginPage.clickToLoginButton();
        dashboardPage.isLoadingSpinnerDisappear(driver);
    }

    @Test
    public void Employee_01_CreateNewEmployedd() {
        employeeListPage = dashboardPage.clickToPIMModule();

        verifyTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        verifyTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));
        addEmployeePage.enterToFirstNameTextbox(userInfor.getEmployeeFirstName());
        addEmployeePage.enterToLastNameTextbox(userInfor.getEmployeeLastName());
        employeeID = addEmployeePage.getEmployeeID();
        personalDetailPage = addEmployeePage.clickToSaveButton();

        verifyTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
        verifyEquals(personalDetailPage.getFirstNameTextboxValue(), userInfor.getEmployeeFirstName());
        verifyEquals(personalDetailPage.getLastNameTextboxValue(), userInfor.getEmployeeLastName());
        verifyEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }

    @Test
    public void Employee_02_Edit_Information() {
        personalDetailPage.openEditNavigatorByNames("Personal Details");
        personalDetailPage.isLoadingSpinnerDisappear(driver);

        personalDetailPage.enterToFirstNameTextbox(userInfor.getEditFirstName());
        personalDetailPage.enterToLastNameTextbox(userInfor.getEditLastName());
        personalDetailPage.enterToDriverLicenseNumberTextbox(userInfor.getDriverLicenseNumber());
        personalDetailPage.enterToLicenseExpiryDateTextbox(userInfor.getLicenseExpiryDate());
        personalDetailPage.selectNationalityDropdown(nationality);
        personalDetailPage.selectMaritalStatusDropdown(maritalStatus);
        personalDetailPage.enterToDateOfBirthTextbox(userInfor.getDateOfBirth());
        personalDetailPage.selectToGenderRadio(gender);
        personalDetailPage.clickToSaveButtonAtProfileContainer();

        personalDetailPage.isSuccessToastMessageDisplayed(driver);
        personalDetailPage.isLoadingSpinnerDisappear(driver);

        verifyEquals(personalDetailPage.getFirstNameTextboxValue(), userInfor.getEditFirstName());
        verifyEquals(personalDetailPage.getLastNameTextboxValue(), userInfor.getEditLastName());
        verifyEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
        verifyEquals(personalDetailPage.getDriverLicenseNumberTextboxValue(), userInfor.getDriverLicenseNumber());
        verifyEquals(personalDetailPage.getLicenseExpiryDateTexboxValue(), userInfor.getLicenseExpiryDate());
        verifyEquals(personalDetailPage.getNationalityDropdownValue(), nationality);
        verifyEquals(personalDetailPage.getMaritalStatusDropdownValue(), maritalStatus);
        verifyEquals(personalDetailPage.getDateOfBirthTextboxValue(), userInfor.getDateOfBirth());
        verifyTrue(personalDetailPage.isGenderRadioSelected(gender));
    }

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private AddEmployeePageObject addEmployeePage;
    private EmployeeListPageObject employeeListPage;
    private PersonalDetailPageObject personalDetailPage;
    private DataJson userInfor;

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}