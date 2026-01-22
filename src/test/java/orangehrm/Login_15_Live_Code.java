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
    String employeeID, employeeFirstName, employeeLastName, employeeImage, editFirstName, editLastName;
    String driverLicenseNumber, licenseExpiryDate, nationality, maritalStatus, dateOfBirth, gender;
    String pdfFile, docsFile, excelFile, overLimitedImg;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        loginPage = PageGenerator.getPage(LoginPageObject.class, driver);

        employeeFirstName = "Bui";
        employeeLastName = "Hang";

        employeeImage = "lshopping.png";
        pdfFile = "Doraemon_Long_Stories_v07.PDF";
        docsFile = "Don_de_nghi_sat_hach.docx";
        excelFile = "Bai_test.xlsx";
        overLimitedImg = "4MB_img.jpg";

        editFirstName = "Le";
        editLastName = "Mai";
        driverLicenseNumber = "12345678";
        licenseExpiryDate = "2030-09-09";
        nationality = "Vietnamese";
        maritalStatus = "Single";
        dateOfBirth = "2000-09-09";
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
    public void Employee_02_Upload_Image() {
        personalDetailPage.clickToEmployeeImage();

        // upload file type not allow
        personalDetailPage.uploadMultipleFiles(driver, excelFile);
        verifyEquals(personalDetailPage.getUploadFileErrorMessage(), "File type not allowed");
        personalDetailPage.uploadMultipleFiles(driver, docsFile);
        verifyEquals(personalDetailPage.getUploadFileErrorMessage(), "File type not allowed");
        personalDetailPage.uploadMultipleFiles(driver, pdfFile);
        verifyEquals(personalDetailPage.getUploadFileErrorMessage(), "File type not allowed");

        // upload file over maximum
        personalDetailPage.uploadMultipleFiles(driver, overLimitedImg);
        verifyEquals(personalDetailPage.getUploadFileErrorMessage(), "Attachment Size Exceeded");

        // upload success
        Dimension beforeUpload = personalDetailPage.getEmployeeSize();

        personalDetailPage.uploadMultipleFiles(driver, employeeImage);
        personalDetailPage.clickToSaveButtonAtProfileContainer();

        verifyTrue(personalDetailPage.isSuccessToastMessageDisplayed(driver));
        personalDetailPage.isLoadingSpinnerDisappear(driver);
        verifyTrue(personalDetailPage.isUploadEmployeeImageSuccess(beforeUpload));
    }

    @Test
    public void Employee_03_Edit_Information() {
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

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}