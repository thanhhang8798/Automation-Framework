package pageObjects.nopCommerce.user.UserMyAccountSideBarPO;

import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.UserMyAccountSideBarPageUI.UserCustomerInforPageUI;

public class UserCustomerInforPO extends UserMyAccountSideBarPO {
    private WebDriver driver;

    public UserCustomerInforPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstNameTextboxValue() {
        waitElementVisible(driver, UserCustomerInforPageUI.FIRST_NAME_TEXTBOX);
        return getElementDOMProperty(driver, UserCustomerInforPageUI.FIRST_NAME_TEXTBOX, "value");
    }

    public String getLastNameTextboxValue() {
        waitElementVisible(driver, UserCustomerInforPageUI.LAST_NAME_TEXTBOX);
        return getElementDOMProperty(driver, UserCustomerInforPageUI.LAST_NAME_TEXTBOX, "value");
    }

    public String getEmailTextboxValue() {
        waitElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
        return getElementDOMProperty(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getDateDropdownSelecctedValue() {
        waitElementVisible(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
        return getElementDOMProperty(driver, UserCustomerInforPageUI.DAY_DROPDOWN, "value");
    }

    public String getMonthDropdownSelecctedValue() {
        waitElementVisible(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
        return getElementDOMProperty(driver, UserCustomerInforPageUI.MONTH_DROPDOWN, "value");
    }

    public String getYearDropdownSelecctedValue() {
        waitElementVisible(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
        return getElementDOMProperty(driver, UserCustomerInforPageUI.YEAR_DROPDOWN, "value");
    }


}
