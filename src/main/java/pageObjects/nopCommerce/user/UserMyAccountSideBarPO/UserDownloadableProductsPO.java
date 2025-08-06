package pageObjects.nopCommerce.user.UserMyAccountSideBarPO;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class UserDownloadableProductsPO extends UserMyAccountSideBarPO {
    private WebDriver driver;

    public UserDownloadableProductsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
