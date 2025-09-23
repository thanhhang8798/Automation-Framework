package pageObjects.jquery;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.jquery.GoFilePageUI;
import pageUIs.jquery.HomePageUI;

public class GoFilePO extends BasePage {
    WebDriver driver;

    public GoFilePO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoadingSpinnerDispeared() {
        return waitListElementInvisible(driver, GoFilePageUI.SPINNER_ICON);
    }

    public boolean isProgressBarDisappeared() {
        return waitListElementInvisible(driver, GoFilePageUI.PROGRESS_BAR);
    }

    public void clickToFileLink() {
        waitElementClickable(driver, GoFilePageUI.FILE_lINK);
        clickToElement(driver, GoFilePageUI.FILE_lINK);
    }

    public boolean isFileUploadedByName(String fileName) {
        waitElementVisible(driver, GoFilePageUI.DYNAMIC_FILE_UPLOADED_SUCCESS_BY_FILE_NAME, fileName);
        return isElementDisplayed(driver, GoFilePageUI.DYNAMIC_FILE_UPLOADED_SUCCESS_BY_FILE_NAME, fileName);
    }
}
