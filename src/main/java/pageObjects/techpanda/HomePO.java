package pageObjects.techpanda;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.techpanda.HomePageUI;

public class HomePO extends BasePage {
    private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPO openLoginPage() {
        waitElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK_AT_FOOTER);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK_AT_FOOTER);
        return PageGenerator.getPage(LoginPO.class, driver);
    }
}
