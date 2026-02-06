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
import pageObjects.orangeHRM.pim.addEmployee.AddEmployeePageObject;
import pageObjects.orangeHRM.pim.addEmployee.PersonalDetailPageObject;
import pageObjects.orangeHRM.pim.employeeList.EmployeeListPageObject;
import testdata.DataJson;
import testdata.ExcelConfig;

public class Login_22_Data_Excel extends BaseTest {
    private WebDriver driver;
    String employeeID, nationality, maritalStatus, gender;


    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);
        excelConfig = ExcelConfig.getExcelData();
        excelConfig.switchToSheet("data");

        loginPage = PageGenerator.getPage(LoginPageObject.class, driver);

        nationality = "Vietnamese";
        maritalStatus = "Single";
        gender = "Female";

        loginPage.enterToUsernameTextbox(GlobalConstants.ADMIN_ORANGEHRM_USERNAME);
        loginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_ORANGEHRM_PASSWORD);
        dashboardPage = loginPage.clickToLoginButton();
        verifyTrue(dashboardPage.isLoadingSpinnerDisappear(driver));
    }

    @Test
    public void Employee_01_CreateNewEmployedd() {
        employeeListPage = dashboardPage.clickToPIMModule();

        verifyTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        verifyTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));
        addEmployeePage.enterToFirstNameTextbox(excelConfig.getCellData("firstName", 1));
        addEmployeePage.enterToLastNameTextbox(excelConfig.getCellData("laseName", 1));
        employeeID = addEmployeePage.getEmployeeID();
        personalDetailPage = addEmployeePage.clickToSaveButton();

        verifyTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
        verifyEquals(personalDetailPage.getFirstNameTextboxValue(), excelConfig.getCellData("firstName", 1));
        verifyEquals(personalDetailPage.getLastNameTextboxValue(), excelConfig.getCellData("laseName", 1));
        verifyEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }

    @Test
    public void Employee_02_Edit_Information() {
        personalDetailPage.openEditNavigatorByNames("Personal Details");
        personalDetailPage.isLoadingSpinnerDisappear(driver);

        personalDetailPage.enterToFirstNameTextbox(excelConfig.getCellData("editFirsName", 1));
        personalDetailPage.enterToLastNameTextbox(excelConfig.getCellData("editLastName", 1));
        personalDetailPage.enterToDriverLicenseNumberTextbox(excelConfig.getCellData("driverLicenseNumber", 1));
        personalDetailPage.enterToLicenseExpiryDateTextbox(excelConfig.getCellData("licenseExpiryDate", 1));
        personalDetailPage.selectNationalityDropdown(nationality);
        personalDetailPage.selectMaritalStatusDropdown(maritalStatus);
        personalDetailPage.enterToDateOfBirthTextbox(excelConfig.getCellData("dateOfBirth",1));
        personalDetailPage.selectToGenderRadio(gender);
        personalDetailPage.clickToSaveButtonAtProfileContainer();

        personalDetailPage.isSuccessToastMessageDisplayed(driver);
        personalDetailPage.isLoadingSpinnerDisappear(driver);

        verifyEquals(personalDetailPage.getFirstNameTextboxValue(), excelConfig.getCellData("editFirsName", 1));
        verifyEquals(personalDetailPage.getLastNameTextboxValue(), excelConfig.getCellData("editLastName", 1));
        verifyEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
        verifyEquals(personalDetailPage.getDriverLicenseNumberTextboxValue(), excelConfig.getCellData("driverLicenseNumber", 1));
        verifyEquals(personalDetailPage.getLicenseExpiryDateTexboxValue(), excelConfig.getCellData("licenseExpiryDate", 1));
        verifyEquals(personalDetailPage.getNationalityDropdownValue(), nationality);
        verifyEquals(personalDetailPage.getMaritalStatusDropdownValue(), maritalStatus);
        verifyEquals(personalDetailPage.getDateOfBirthTextboxValue(), excelConfig.getCellData("dateOfBirth",1));
        verifyTrue(personalDetailPage.isGenderRadioSelected(gender));
    }

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private AddEmployeePageObject addEmployeePage;
    private EmployeeListPageObject employeeListPage;
    private PersonalDetailPageObject personalDetailPage;
    private ExcelConfig excelConfig;

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}