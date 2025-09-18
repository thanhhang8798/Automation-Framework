package nopcommerce;

import core.BaseTest;
import core.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountSideBarPO.*;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Topic_09_Share_State_Cookies extends BaseTest{
    @Parameters({"userUrl", "adminUrl", "browser"})
    @BeforeClass
    public void beforeClass(String userUrl, String adminUrl, String browserName) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;

        driver = getBrowserDriver(userUrl, browserName);
        userHomePage = PageGenerator.getPage(UserHomePageObject.class, driver);

        // pre-condition: login by cookie
        userHomePage.setCookies(driver, Common_Login.nopCommerceCookies);
        userHomePage.refreshPage(driver);
    }

    @Test
    public void TC_01_MyAccount() {
        userHomePage.clickToLinkByText(driver, "My account");
        userCustomerInforPage = PageGenerator.getPage(UserCustomerInforPO.class, driver);

        Assert.assertEquals(userCustomerInforPage.getTextboxValueByID(driver,"FirstName"), firstName);
        Assert.assertEquals(userCustomerInforPage.getTextboxValueByID(driver,"LastName"), lastName);
        Assert.assertEquals(userCustomerInforPage.getTextboxValueByID(driver,"Email"), userEmail);
        Assert.assertTrue(userCustomerInforPage.isCheckboxSelectedByID(driver, "Newsletter"));
    }

//    @Test
    public void TC_02_Dynamic_Locator() {
        userOrdersPage = userCustomerInforPage.openUserOrderPage();
        userBackInStockSubscriptionsPage = userOrdersPage.openUserBackInStockPage();
        userAddressesPage = userBackInStockSubscriptionsPage.openUserAddressesPage();
        userDownloadableProductsPage = userAddressesPage.openUserDownloadableProductPage();

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;
    private String userUrl, adminUrl;
    String firstName, lastName, userEmail, userPassword, confirmPassword;

    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserCustomerInforPO userCustomerInforPage;
    private UserLoginPageObject userLoginPage;
    private UserOrdersPO userOrdersPage;
    private UserBackInStockSubscriptionsPO userBackInStockSubscriptionsPage;
    private UserDownloadableProductsPO userDownloadableProductsPage;
    private UserAddressesPO userAddressesPage;

    private AdminDashboardPO adminDashbpardPage;
    private AdminLoginPO adminLoginPage;
}

