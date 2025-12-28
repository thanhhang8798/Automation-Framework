package pageUIs.orangeHRM.pim.addEmployee;

public class PersonalDetailPageUI {
    public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@name='firstName']";
    public static final String LAST_NAME_TEXTBOX = "xpath=//input[@name='lastName']";
    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[@class='oxd-label']/parent::div/following-sibling::div/input";

    public static final String EMPLOYEE_IMAGE = "CSS=img.employee-image";
    public static final String SAVE_BUTTON_AT_PROFILE_CONTAINER ="CSS=div.orangehrm-edit-employee-content button[type='submit']";
    public static final String UPLOAD_IMAGE_SUCCESS_MESSAGE ="CSS=div.oxd-toast-content--success";
}
