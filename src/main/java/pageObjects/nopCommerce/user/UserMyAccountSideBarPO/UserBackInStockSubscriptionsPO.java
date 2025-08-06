package pageObjects.nopCommerce.user.UserMyAccountSideBarPO;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class UserBackInStockSubscriptionsPO extends UserMyAccountSideBarPO {
    private WebDriver driver;

    public UserBackInStockSubscriptionsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
