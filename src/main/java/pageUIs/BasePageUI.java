package pageUIs;

public class BasePageUI {
    // orangehrm
    public static final String SPINNER_ICON = "xpath=//div[@class='oxd-loading-spinner']";
    public static final String USER_DROPDOWN = "CSS=span.oxd-userdropdown-tab";
    public static final String LOGOUT_LINK = "xpath=//ul[@class='oxd-dropdown-menu']//a[text()='Logout']";

    // component
    public static final String TEXTBOX_BY_NAME = "CSS=input[name='%s']";
    public static final String TEXTBOX_BY_LABEL = "xpath=//label[text()=\"%s\"]/parent::div/following-sibling::div//input";
    public static final String BUTTON_BY_CONTAINS_TEXT = "xpath=//button[contains(.,'%s')]";
    public static final String LINK_MODULE_BY_TEXT = "xpath=//span[text()='%s']/parent::a";
    public static final String TAB_BY_TEXT = "xpath=//a[text()='%s']";
    public static final String RADIO_BY_LABEL = "xpath=//label[contains(.,'%s')]/input[@type='radio']";
    public static final String CHECKBOX_BY_LABEL = "xpath=//p[text()='%s']/following-sibling::div//input[@type='checkbox']";
    public static final String PARENT_DROPDOWN_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div/div[@class='oxd-select-wrapper']";
    public static final String CHILDREN_DROPDOWN_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div//div[@class='oxd-select-option']//span";
    public static final String DATEPICKER_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div//input[@placeholder='yyyy-mm-dd']";
    public static final String DROPDOWN_VALUE_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String TOAST_MESSAGE_BY_TEXT = "xpath=//p[contains(@class,'oxd-text--toast-message') and text()='%s']";


    // opencart
    public static final String USER_HOME_LOGO = "css=div#logo>a";

    // nopcommerce
    public static final String ADMIN_NOPCOMMERCE_LOGOUT_LINK = "xpath=//a[text()='Logout']";
    public static final String USER_NOPCOMMERCE_LOGIN_LINK = "xpath=//a[@class='ico-login']";
    public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
    public static final String NOPCOMMERCE_LOGO = "css=div.header-logo>a";

        // component
    public static final String TEXTBOX_BY_ID = "css=input#%s";
    public static final String BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
    public static final String LINK_BY_TEXT = "xpath=//a[text()='%s']";
    public static final String CHECKBOX_BY_ID = "css=input#%s";
    public static final String RADIO_BY_ID = "css=input#%s";

    // jquery
    public static final String UPLOAD_FILE_TYPE = "css=input[type='file']";


}
