package pageObjects.openCart.user;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.openCart.admin.AdminLoginPO;
import pageUIs.openCart.user.UserHomePageUI;
import pageUIs.openCart.user.UserLoginPageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public UserLoginPO clickToMyAccountLink() {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
//                driver.findElement(By.cssSelector("ul.tabstrip-items")));
        waitElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElementByJS(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getPage(UserLoginPO.class, driver);
    }

    public AdminLoginPO openAdminSite(String adminUrl) {
        openPageUrl(driver, adminUrl);
        return PageGenerator.getPage(AdminLoginPO.class, driver);
    }
}
