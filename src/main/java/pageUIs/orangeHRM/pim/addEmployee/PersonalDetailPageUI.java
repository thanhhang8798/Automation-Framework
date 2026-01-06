package pageUIs.orangeHRM.pim.addEmployee;

public class PersonalDetailPageUI {
    public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@name='firstName']";
    public static final String LAST_NAME_TEXTBOX = "xpath=//input[@name='lastName']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[@class='oxd-label']/parent::div/following-sibling::div/input";

    public static final String EMPLOYEE_IMAGE = "CSS=img.employee-image";
    public static final String SAVE_BUTTON_AT_PROFILE_CONTAINER ="CSS=div.orangehrm-edit-employee-content button[type='submit']";

    public static final String DRIVER_LICENSE_NUMBER_TEXTBOX = "XPATH=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div//input";
    public static final String LICENSE_EXPIRY_DATE_TEXTBOX ="XPATH=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";
    public static final String NATIONALITY_DROPDOWN_PARENT = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']";
    public static final String NATIONALITY_DROPDOWN_CHILD = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']//span";
    public static final String MARITAL_STATUS_DROPDOWN_PARENT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']";
    public static final String MARITAL_STATUS_DROPDOWN_CHILD = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']//span";
    public static final String DATE_OF_BIRTH_TEXTBOX = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
    public static final String GENDER_RADIO = "xpath=//label[text()='Gender']/parent::div/following-sibling::div//label[text()='%s']/input";
    public static final String NATIONALITY_SELECTED_DROPDOWN = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String MARITAL_STATUS_SELECTED_DROPDOWN = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
}
