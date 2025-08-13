package pageObjects.jquery;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.jquery.TablePageUI;

public class TablePO extends BasePage {
    WebDriver driver;

    public TablePO(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageNumber(String pageNumber) {
        waitElementClickable(driver, TablePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        clickToElement(driver, TablePageUI.DYNAMIC_PAGE_LINK, pageNumber);
    }

    public boolean isPageNumberDisplayed(String pageNumber) {
        waitElementVisible(driver, TablePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        return getElementDOMAttribute(driver, TablePageUI.DYNAMIC_PAGE_LINK, "class", pageNumber).endsWith("active");
    }

    public void enterToTextboxByHeaderName(String headerName, String valueToSendKey) {
        waitElementVisible(driver, TablePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, headerName);
        sendKeyToElement(driver, TablePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, valueToSendKey, headerName);
        sendKeyBoardToElement(driver, TablePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, headerName);

    }

    public boolean isRowDataValueDisplayed(String females, String country, String males, String total) {
        waitElementVisible(driver, TablePageUI.DYNAMIC_ROW_DATA_VALUE, females, country, males, total);
        return isElementDisplayed(driver, TablePageUI.DYNAMIC_ROW_DATA_VALUE, females, country, males, total);
    }

    public void removeRowByCountryName(String countryName) {
        waitElementClickable(driver, TablePageUI.DYNAMIC_REMOVE_BUTTON_BY_COUNTTRY_NAME, countryName);
        clickToElement(driver, TablePageUI.DYNAMIC_REMOVE_BUTTON_BY_COUNTTRY_NAME, countryName);
    }

    public Object listRowNumber(String countryName) {
        return getListElementNumber(driver, TablePageUI.DYNAMIC_REMOVE_BUTTON_BY_COUNTTRY_NAME, countryName);
    }

    public void editRowByCountryName(String countryName) {
        waitElementClickable(driver, TablePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTTRY_NAME, countryName);
        clickToElement(driver, TablePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTTRY_NAME, countryName);
    }

    public boolean isEditPopupDisplay() {
        sleepInSecond(1);
        // waitElementPresence(driver, TablePageUI.EDIT_POPUP);
        return isElementDisplayed(driver, TablePageUI.EDIT_POPUP);
    }

    public void clickToLoadDataButton() {
        waitElementClickable(driver, TablePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, TablePageUI.LOAD_DATA_BUTTON);
    }

    public void enterToTextboxByIndex(String rowIndex, String columnName, String valueToSendkey) {
        // lay column index
        int columnIndexNumber = getListElementNumber(driver, TablePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName) + 1;

        // convert index qua text (String)
        String columnIndex = String.valueOf(columnIndexNumber);

        // truyền 2 giá trị rowIndex/ columnIndex vào locator để tương tác
        sendKeyToElement(driver, TablePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, valueToSendkey, rowIndex, columnIndex);
    }

    public void selectToDropdownByIndex(String rowIndex, String columnName, String valueToSelect) {
        int columnIndexNumber = getListElementNumber(driver, TablePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName) + 1;
        String columnIndex = String.valueOf(columnIndexNumber);
        selectItemInDropdown(driver, TablePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX, valueToSelect, rowIndex, columnIndex);
    }

    public void checkToCheckboxByIndex(String rowIndex, String columnName, boolean checkOrUncheck) {
        int columnIndexNumber = getListElementNumber(driver, TablePageUI.DYNAMIC_PRECEDING_SIBLING_COLUMN_NUMBER, columnName) + 1;
        String columnIndex = String.valueOf(columnIndexNumber);
        checkToCheckbox(driver, TablePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        if(checkOrUncheck) {
            checkToCheckbox(driver, TablePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        } else {
            uncheckToCheckbox(driver, TablePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        }
    }

    public void clickToIconByIndex(String rowIndex, String iconName) {
        waitElementClickable(driver, TablePageUI.DYNAMIC_ICON_BY_ROW_AND_COLUMN_INDEX, rowIndex, iconName);
        clickToElement(driver, TablePageUI.DYNAMIC_ICON_BY_ROW_AND_COLUMN_INDEX, rowIndex, iconName);
    }
}
