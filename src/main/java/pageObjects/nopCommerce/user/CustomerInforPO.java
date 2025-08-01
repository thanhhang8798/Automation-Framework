package pageObjects.nopCommerce.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.CustomerInforPageUI;

public class CustomerInforPO extends BasePage {
    private WebDriver driver;

    public CustomerInforPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstNameTextboxValue() {
        waitElementVisible(driver, pageUIs.nopCommerce.user.CustomerInforPageUI.FIRST_NAME_TEXTBOX);
        return getElementDOMProperty(driver, pageUIs.nopCommerce.user.CustomerInforPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitElementVisible(driver, pageUIs.nopCommerce.user.CustomerInforPageUI.LAST_NAME_TEXTBOX);
        return getElementDOMProperty(driver, pageUIs.nopCommerce.user.CustomerInforPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getEmailTextboxValue() {
        waitElementVisible(driver, pageUIs.nopCommerce.user.CustomerInforPageUI.EMAIL_TEXTBOX);
        return getElementDOMProperty(driver, pageUIs.nopCommerce.user.CustomerInforPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getDateDropdownSelecctedValue() {
        waitElementVisible(driver, pageUIs.nopCommerce.user.CustomerInforPageUI.DAY_DROPDOWN);
        return getElementDOMProperty(driver, pageUIs.nopCommerce.user.CustomerInforPageUI.DAY_DROPDOWN, "value");
    }

    public String getMonthDropdownSelecctedValue() {
        waitElementVisible(driver, pageUIs.nopCommerce.user.CustomerInforPageUI.MONTH_DROPDOWN);
        return getElementDOMProperty(driver, pageUIs.nopCommerce.user.CustomerInforPageUI.MONTH_DROPDOWN, "value");
    }

    public String getYearDropdownSelecctedValue() {
        waitElementVisible(driver, pageUIs.nopCommerce.user.CustomerInforPageUI.YEAR_DROPDOWN);
        return getElementDOMProperty(driver, pageUIs.nopCommerce.user.CustomerInforPageUI.YEAR_DROPDOWN, "value");
    }

}
