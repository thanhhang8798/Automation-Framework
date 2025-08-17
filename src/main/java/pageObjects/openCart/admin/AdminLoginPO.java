package pageObjects.openCart.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.openCart.user.UserHomePO;
import pageUIs.openCart.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    private WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUserNameTextbox(String userName) {
        waitElementVisible(driver, AdminLoginPageUI.ADMIN_USERNAME_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.ADMIN_USERNAME_TEXTBOX, userName);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD_TEXTBOX, password);
    }

    public AdminDashboardPO clickToLoginButton() {
        waitElementVisible(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.ADMIN_LOGIN_BUTTON);
        return PageGenerator.getPage(AdminDashboardPO.class, driver);
    }


}
