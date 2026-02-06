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
import testdata.DataFakerConfig;

public class Login_16_Data_Faker extends BaseTest {
    private WebDriver driver;
    String employeeID, employeeFirstName, employeeLastName, editFirstName, editLastName;
    String driverLicenseNumber, licenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);
        faker = DataFakerConfig.getFaker();

        loginPage = PageGenerator.getPage(LoginPageObject.class, driver);

        employeeFirstName = faker.getFirstName();
        employeeLastName = faker.getLastName();

        editFirstName = faker.getFirstName();
        editLastName = faker.getLastName();
        driverLicenseNumber = faker.getNumberTenDigits();
        licenseExpiryDate = faker.getDate();
        nationality = "Vietnamese";
        maritalStatus = "Single";
        dateOfBirth = faker.getDateOfBirth();
        gender = "Female";

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

        verifyTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
        verifyEquals(personalDetailPage.getFirstNameTextboxValue(),employeeFirstName);
        verifyEquals(personalDetailPage.getLastNameTextboxValue(),employeeLastName);
        verifyEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }

    @Test
    public void Employee_02_Edit_Information() {
        personalDetailPage.openEditNavigatorByNames("Personal Details");
        personalDetailPage.isLoadingSpinnerDisappear(driver);

        personalDetailPage.enterToFirstNameTextbox(editFirstName);
        personalDetailPage.enterToLastNameTextbox(editLastName);
        personalDetailPage.enterToDriverLicenseNumberTextbox(driverLicenseNumber);
        personalDetailPage.enterToLicenseExpiryDateTextbox(licenseExpiryDate);
        personalDetailPage.selectNationalityDropdown(nationality);
        personalDetailPage.selectMaritalStatusDropdown(maritalStatus);
        personalDetailPage.enterToDateOfBirthTextbox(dateOfBirth);
        personalDetailPage.selectToGenderRadio(gender);
        personalDetailPage.clickToSaveButtonAtProfileContainer();

        personalDetailPage.isSuccessToastMessageDisplayed(driver);
        personalDetailPage.isLoadingSpinnerDisappear(driver);

        verifyEquals(personalDetailPage.getFirstNameTextboxValue(), editFirstName);
        verifyEquals(personalDetailPage.getLastNameTextboxValue(), editLastName);
        verifyEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
        verifyEquals(personalDetailPage.getDriverLicenseNumberTextboxValue(), driverLicenseNumber);
        verifyEquals(personalDetailPage.getLicenseExpiryDateTexboxValue(), licenseExpiryDate);
        verifyEquals(personalDetailPage.getNationalityDropdownValue(), nationality);
        verifyEquals(personalDetailPage.getMaritalStatusDropdownValue(), maritalStatus);
        verifyEquals(personalDetailPage.getDateOfBirthTextboxValue(), dateOfBirth);
        verifyTrue(personalDetailPage.isGenderRadioSelected(gender));
    }

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private AddEmployeePageObject addEmployeePage;
    private EmployeeListPageObject employeeListPage;
    private PersonalDetailPageObject personalDetailPage;
    private ContactDetailPageObject contactDetailPage;
    private JobPageObject jobPage;
    private DependentsPageObject dependentsPage;
    private DataFakerConfig faker;

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}