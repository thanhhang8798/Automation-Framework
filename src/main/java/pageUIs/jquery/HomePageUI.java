package pageUIs.jquery;

public class HomePageUI {
    public static final String DYNAMIC_PAGE_LINK = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_BY_HEADER_NAME = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_ROW_DATA_VALUE = "xpath=//td[@data-key='females' and text()='%s']"
            + "/following-sibling::td[@data-key='country' and text()='%s']"
            + "/following-sibling::td[@data-key='males' and text()='%s']"
            + "/following-sibling::td[@data-key='total' and text()='%s']";

    public static final String DYNAMIC_REMOVE_BUTTON_BY_COUNTTRY_NAME = "XPATH=//td[@data-key='country' and text()='%s']"
            + "//preceding-sibling::td//button[@class='qgrd-remove-row-btn']";
    public static final String DYNAMIC_EDIT_BUTTON_BY_COUNTTRY_NAME = "XPATH=//td[@data-key='country' and text()='%s']"
            + "//preceding-sibling::td//button[@class='qgrd-edit-row-btn']";

    public static final String EDIT_POPUP = "class=qgrd-modal-container";

    public static final String LOAD_DATA_BUTTON = "id=load";
    public static final String DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER = "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//input";
    public static final String DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//select";
    public static final String DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]/td[%s]//input[@type='checkbox']";
    public static final String DYNAMIC_ICON_BY_ROW_AND_COLUMN_INDEX = "xpath=//tr[%s]//button[@title='%s']";

    public static final String DYNAMIC_UPLOAD_LOADED_BY_FILE_NAME = "xpath=//p[@class='name' and text()='%s']";
    public static final String START_BUTTON = "css=td>button.start";
    public static final String DYNAMIC_FILE_UPLOADED_SUCCESS_BY_FILE_NAME = "css=p.name>a[title='%s']";
}
