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
import testdata.UserDataLombok;

public class Login_17_Data_POJO extends BaseTest {
    private WebDriver driver;
    String employeeID, nationality, maritalStatus, gender;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);
//        userInfo = testdata.UserInfo.getUserData();
        userInfo = UserDataLombok.getUserData();

        loginPage = PageGenerator.getPage(LoginPageObject.class, driver);

        userInfo.setEmployeeFirstName("Thanh");
        userInfo.setEmployeeLastName("Hang");

        userInfo.setEditFirstName("Mai");
        userInfo.setEditLastName("Trang");
        userInfo.setDriverLicenseNumber("123456789");
        userInfo.setLicenseExpiryDate("2020-09-09");
        nationality = "Vietnamese";
        maritalStatus = "Single";
        userInfo.setDateOfBirth("1999-09-09");
        gender = "Female";

        loginPage.enterToUsernameTextbox(GlobalConstants.ADMIN_ORANGEHRM_USERNAME);
        loginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_ORANGEHRM_PASSWORD);
        dashboardPage = loginPage.clickToLoginButton();
        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));
    }

    @Test
    public void Employee_01_CreateNewEmployee() {
        employeeListPage = dashboardPage.clickToPIMModule();

        verifyTrue(employeeListPage.isLoadingSpinnerDisappear(driver));
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        verifyTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));
        employeeID = addEmployeePage.getEmployeeID();

//        personalDetailPage = addEmployeePage.createNewEmployee(userInfo);
        personalDetailPage = addEmployeePage.createNewEmployeeByLambok(userInfo);

        verifyTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
        verifyEquals(personalDetailPage.getFirstNameTextboxValue(), userInfo.getEmployeeFirstName());
        verifyEquals(personalDetailPage.getLastNameTextboxValue(), userInfo.getEmployeeLastName());
        verifyEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }

    @Test
    public void Employee_02_Edit_Information() {
        personalDetailPage.openEditNavigatorByNames("Personal Details");
        personalDetailPage.isLoadingSpinnerDisappear(driver);


        personalDetailPage.selectNationalityDropdown(nationality);
        personalDetailPage.selectMaritalStatusDropdown(maritalStatus);
        personalDetailPage.selectToGenderRadio(gender);

//        personalDetailPage.editEmployeeInfor(userInfo);
        personalDetailPage.editEmployeeInforByLambok(userInfo);

        personalDetailPage.isSuccessToastMessageDisplayed(driver);
        personalDetailPage.isLoadingSpinnerDisappear(driver);

        verifyEquals(personalDetailPage.getFirstNameTextboxValue(), userInfo.getEditFirstName());
        verifyEquals(personalDetailPage.getLastNameTextboxValue(), userInfo.getEditLastName());
        verifyEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
        verifyEquals(personalDetailPage.getDriverLicenseNumberTextboxValue(), userInfo.getDriverLicenseNumber());
        verifyEquals(personalDetailPage.getLicenseExpiryDateTexboxValue(), userInfo.getLicenseExpiryDate());
        verifyEquals(personalDetailPage.getNationalityDropdownValue(), nationality);
        verifyEquals(personalDetailPage.getMaritalStatusDropdownValue(), maritalStatus);
        verifyEquals(personalDetailPage.getDateOfBirthTextboxValue(), userInfo.getDateOfBirth());
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
//    private testdata.UserInfo userInfo;
    private testdata.UserDataLombok userInfo;

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}