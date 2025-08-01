package pageObjects.openCart.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.user.HomePageObject;
import pageObjects.openCart.user.UserHomePO;
import pageUIs.openCart.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    private WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUserNameTextbox(String userName) {
        waitElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, userName);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public AdminDashboardPO clickToLoginButton() {
        waitElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getPage(AdminDashboardPO.class, driver);
    }

    public UserHomePO openUserSite(String userUrl) {
        openPageUrl(driver, userUrl);
        return PageGenerator.getPage(UserHomePO.class, driver);
    }
}
