package pageObjects.jquery;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.HomePageUI;

import java.util.ArrayList;
import java.util.List;

public class HomePO extends BasePage {
    WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageNumber(String pageNumber) {
        waitElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK_BY_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.DYNAMIC_PAGE_LINK_BY_NUMBER, pageNumber);
    }

    public boolean isPageNumberDisplayed(String pageNumber) {
        waitElementVisible(driver, HomePageUI.DYNAMIC_PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
    }

    public void enterToTextboxByHeaderName(String headerName, String valueToSendKey) {
        waitElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, headerName);
        sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, valueToSendKey, headerName);
        sendKeyBoardToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, headerName);

    }

    public boolean isRowDataValueDisplayed(String females, String country, String males, String total) {
        waitElementVisible(driver, HomePageUI.DYNAMIC_ROW_DATA_VALUE, females, country, males, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_DATA_VALUE, females, country, males, total);
    }

    public void removeRowByCountryName(String countryName) {
        waitElementClickable(driver, HomePageUI.DYNAMIC_REMOVE_BUTTON_BY_COUNTTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_REMOVE_BUTTON_BY_COUNTTRY_NAME, countryName);
    }

    public Object listRowNumber(String countryName) {
        return getListElementNumber(driver, HomePageUI.DYNAMIC_REMOVE_BUTTON_BY_COUNTTRY_NAME, countryName);
    }

    public void editRowByCountryName(String countryName) {
        waitElementClickable(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTTRY_NAME, countryName);
        clickToElement(driver, HomePageUI.DYNAMIC_EDIT_BUTTON_BY_COUNTTRY_NAME, countryName);
    }

    public boolean isEditPopupDisplay() {
        waitElementVisible(driver, HomePageUI.EDIT_POPUP);
        return isElementDisplayed(driver, HomePageUI.EDIT_POPUP);
    }

    public void clickToLoadDataButton() {
        waitElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
        clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
    }

    public void enterToTextboxByIndex(String rowIndex, String columnName, String valueToSendkey) {
        waitListElementVisible(driver, HomePageUI.DYNAMIC_COLUMN_NUMBER_BY_PRECEDING_SIBLING, columnName);
        // lay column index
        int columnIndexNumber = getListElementNumber(driver, HomePageUI.DYNAMIC_COLUMN_NUMBER_BY_PRECEDING_SIBLING, columnName) + 1;

        // convert index qua text (String)
        String columnIndex = String.valueOf(columnIndexNumber);

        // truyền 2 giá trị rowIndex/ columnIndex vào locator để tương tác
        waitElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, valueToSendkey, rowIndex, columnIndex);
        sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_AND_COLUMN_INDEX, valueToSendkey, rowIndex, columnIndex);
    }

    public void selectToDropdownByIndex(String rowIndex, String columnName, String valueToSelect) {
        waitListElementVisible(driver, HomePageUI.DYNAMIC_COLUMN_NUMBER_BY_PRECEDING_SIBLING, columnName);
        int columnIndexNumber = getListElementNumber(driver, HomePageUI.DYNAMIC_COLUMN_NUMBER_BY_PRECEDING_SIBLING, columnName) + 1;
        // gộp hàm convert index
        waitElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX, valueToSelect, rowIndex, String.valueOf(columnIndexNumber));
        selectItemInDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_AND_COLUMN_INDEX, valueToSelect, rowIndex, String.valueOf(columnIndexNumber));
    }

    public void checkToCheckboxByIndex(String rowIndex, String columnName, boolean checkOrUncheck) {
        waitListElementVisible(driver, HomePageUI.DYNAMIC_COLUMN_NUMBER_BY_PRECEDING_SIBLING, columnName);
        int columnIndexNumber = getListElementNumber(driver, HomePageUI.DYNAMIC_COLUMN_NUMBER_BY_PRECEDING_SIBLING, columnName) + 1;

        String columnIndex = String.valueOf(columnIndexNumber);
        waitElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
        checkToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
//        if(checkOrUncheck) {
//            checkToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
//        } else {
//            uncheckToCheckboxRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_AND_COLUMN_INDEX, rowIndex, columnIndex);
//        }
    }

    public void clickToIconByIndex(String rowIndex, String iconName) {
        waitElementClickable(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_AND_COLUMN_INDEX, rowIndex, iconName);
        clickToElement(driver, HomePageUI.DYNAMIC_ICON_BY_ROW_AND_COLUMN_INDEX, rowIndex, iconName);
    }

    // upload file
    public void isFileLoadedByName(String fileName) {
        waitElementVisible(driver, HomePageUI.DYNAMIC_UPLOAD_LOADED_BY_FILE_NAME, fileName);
        isElementDisplayed(driver, HomePageUI.DYNAMIC_UPLOAD_LOADED_BY_FILE_NAME, fileName);
    }

    public void clickToStartButton() {
        List<WebElement> startButtons = getListElement(driver, HomePageUI.START_BUTTON);
        for(WebElement button : startButtons) {
            waitElementClickable(driver, button);
            button.click();
            sleepInSecond(3);
        }
    }

    public boolean isFileUploadedByName(String fileName) {
        waitElementVisible(driver, HomePageUI.DYNAMIC_FILE_UPLOADED_SUCCESS_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_FILE_UPLOADED_SUCCESS_BY_FILE_NAME, fileName);
    }

    public List<String> getAllValueByColumnName(String columnName) {
        // Lấy ra all page và all value từng cột lưu vào 1 list
        List<WebElement> allPage = getListElement(driver, HomePageUI.ALL_PAGE);
        List<String> columnAllValue = new ArrayList<String>();

        waitListElementVisible(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName);
        int columnIndex = getListElementNumber(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

        // dùng vòng lặp chuyển qua từng page và lấy ra giá trị
        for (WebElement page : allPage) {
            page.click();

            // lấy ra all giá trị của từng page
            List<WebElement> columnAllValueElement = getListElement(driver, HomePageUI.DYNAMIC_COLUMN_INDEX, String.valueOf(columnIndex));
            for (WebElement value : columnAllValueElement) {
                // get data trong 1 cột rồi lưu và list
                columnAllValue.add(value.getText());
            }
        }
        return columnAllValue;
    }

    public List<String> getAllValuesByAttribute(String columnAttribute) {
        // Lấy ra all page và all value từng cột lưu vào list
        List<WebElement> allPage = getListElement(driver, HomePageUI.ALL_PAGE);
        List<String> columnAllValue = new ArrayList<String>();

        waitListElementVisible(driver, HomePageUI.DYNAMIC_ALL_VALUE_BY_ATTRIBUTE, columnAttribute);

        // dùng vòng lặp chuyển qua từng page và lấy ra giá trị
        for (WebElement page : allPage) {
            page.click();

            // lấy ra all giá trị của từng page
            List<WebElement> columnAllValueElement = getListElement(driver, HomePageUI.DYNAMIC_ALL_VALUE_BY_ATTRIBUTE, columnAttribute);
            for (WebElement value : columnAllValueElement) {
                // get data trong 1 cột rồi lưu và list
                columnAllValue.add(value.getText());
            }
        }
        return columnAllValue;
    }
}
