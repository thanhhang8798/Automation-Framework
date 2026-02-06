package pageObjects.orangeHRM.pim.addEmployee;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.addEmployee.PersonalDetailPageUI;
import testdata.UserDataLombok;
import testdata.UserDataLombok;
import testdata.UserInfo;

public class PersonalDetailPageObject extends EditEmployeeNavigationPO {
    private WebDriver driver;

    public PersonalDetailPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Get first name attribute value")
    public String getFirstNameTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    @Step("Get Last name attribute value")
    public String getLastNameTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX, "value");
    }

    @Step("Get Employee ID attribute value")
    public String getEmployeeIDTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void clickToEmployeeImage() {
        waitElementClickable(driver, PersonalDetailPageUI.EMPLOYEE_IMAGE);
        clickToElement(driver, PersonalDetailPageUI.EMPLOYEE_IMAGE);
    }

    public Dimension getEmployeeSize() {
        return getElementSize(driver, PersonalDetailPageUI.EMPLOYEE_IMAGE);
    }

    public void clickToSaveButtonAtProfileContainer() {
        waitElementClickable(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_PROFILE_CONTAINER);
        clickToElement(driver, PersonalDetailPageUI.SAVE_BUTTON_AT_PROFILE_CONTAINER);
    }

    public boolean isUploadEmployeeImageSuccess(Dimension beforeUpload) {
        Dimension afterUpload = getEmployeeSize();
        return !beforeUpload.equals(afterUpload);
    }

    @Step("Input to First name textbox")
    public void enterToFirstNameTextbox(String firstName) {
        waitElementVisible(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElementByKeyboard(driver, PersonalDetailPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    @Step("Input to Last name textbox")
    public void enterToLastNameTextbox(String lastName) {
        waitElementVisible(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElementByKeyboard(driver, PersonalDetailPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void enterToDriverLicenseNumberTextbox(String driverLicenseNumber) {
        waitElementVisible(driver, PersonalDetailPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX, driverLicenseNumber);
    }

    public void enterToLicenseExpiryDateTextbox(String licenseExpiryDate) {
        waitElementVisible(driver, PersonalDetailPageUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailPageUI.LICENSE_EXPIRY_DATE_TEXTBOX, licenseExpiryDate);
    }

    public void selectNationalityDropdown(String nationality) {
        waitElementClickable(driver, PersonalDetailPageUI.NATIONALITY_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailPageUI.NATIONALITY_DROPDOWN_PARENT, PersonalDetailPageUI.NATIONALITY_DROPDOWN_CHILD, nationality);
    }

    public void selectMaritalStatusDropdown(String maritalStatus) {
        waitElementClickable(driver, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_PARENT, PersonalDetailPageUI.MARITAL_STATUS_DROPDOWN_CHILD, maritalStatus);
    }

    public void enterToDateOfBirthTextbox(String dateOfBirth) {
        waitElementVisible(driver, PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX);
        sendKeyToElement(driver, PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
    }

    public void selectToGenderRadio(String gender) {
        clickToElementByJS(driver, PersonalDetailPageUI.GENDER_RADIO, gender);
    }

    public String getDriverLicenseNumberTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX, "value");
    }

    public String getLicenseExpiryDateTexboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.LICENSE_EXPIRY_DATE_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.LICENSE_EXPIRY_DATE_TEXTBOX, "value");
    }

    public String getNationalityDropdownValue() {
        waitElementVisible(driver, PersonalDetailPageUI.NATIONALITY_SELECTED_DROPDOWN);
        return getElementText(driver, PersonalDetailPageUI.NATIONALITY_SELECTED_DROPDOWN);
    }

    public String getMaritalStatusDropdownValue() {
        waitElementVisible(driver, PersonalDetailPageUI.MARITAL_STATUS_SELECTED_DROPDOWN);
        return getElementText(driver, PersonalDetailPageUI.MARITAL_STATUS_SELECTED_DROPDOWN);
    }

    @Step("Verify date of birth")
    public String getDateOfBirthTextboxValue() {
        waitElementVisible(driver, PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX);
        return getElementDOMProperty(driver, PersonalDetailPageUI.DATE_OF_BIRTH_TEXTBOX, "value");
    }

    @Step("Verify gender is {0}")
    public boolean isGenderRadioSelected(String gender) {
        waitElementSelected(driver, PersonalDetailPageUI.GENDER_RADIO, gender);
        return isElementSelected(driver, PersonalDetailPageUI.GENDER_RADIO, gender);
    }

    public String getUploadFileErrorMessage() {
        waitElementVisible(driver, PersonalDetailPageUI.UPLOAD_FILE_ERROR_MESSAGE);
        return getElementText(driver, PersonalDetailPageUI.UPLOAD_FILE_ERROR_MESSAGE);
    }

    public void editEmployeeInfor(UserInfo userInfo) {
        enterToFirstNameTextbox(userInfo.getEditFirstName());
        enterToLastNameTextbox(userInfo.getEditLastName());
        enterToDriverLicenseNumberTextbox(userInfo.getDriverLicenseNumber());
        enterToLicenseExpiryDateTextbox(userInfo.getLicenseExpiryDate());
        enterToDateOfBirthTextbox(userInfo.getDateOfBirth());
        clickToSaveButtonAtProfileContainer();
    }

    public void editEmployeeInforByLambok(UserDataLombok userInfo) {
        enterToFirstNameTextbox(userInfo.getEditFirstName());
        enterToLastNameTextbox(userInfo.getEditLastName());
        enterToDriverLicenseNumberTextbox(userInfo.getDriverLicenseNumber());
        enterToLicenseExpiryDateTextbox(userInfo.getLicenseExpiryDate());
        enterToDateOfBirthTextbox(userInfo.getDateOfBirth());
        clickToSaveButtonAtProfileContainer();
    }
}