package opencart;

import core.BaseTest;
import core.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.openCart.admin.AdminCustomerPO;
import pageObjects.openCart.admin.AdminDashboardPO;
import pageObjects.openCart.admin.AdminLoginPO;
import pageObjects.openCart.user.UserHomePO;
import pageObjects.openCart.user.UserLoginPO;
import pageObjects.openCart.user.UserMyAccountPO;
import pageObjects.openCart.user.UserRegisterPO;

public class Level_11_Multiple_Driver extends BaseTest {
    @Parameters({"userUrl", "adminUrl", "browser"})
    @BeforeClass
    public void beforeClass(String userUrl, String adminUrl, String browserName) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;

        firstName = "Bui";
        lastName = "Hang";
        email = "buihang" + getRandomNumber() + "@gmail.com";
        userPassword = "Auto111@@@";

        userDriver = getBrowserDriver(userUrl, browserName);
        userHomePage = PageGenerator.getPage(UserHomePO.class, userDriver);

        adminDriver = getBrowserDriver(adminUrl, browserName);
        adminLoginPage = PageGenerator.getPage(AdminLoginPO.class, adminDriver);
    }

    @Test
    public void TC_01_Multiple_Tab() {
        userHomePage.clickToMyAccountLink();
        userLoginPage = PageGenerator.getPage(UserLoginPO.class, userDriver);
        userRegisterPage = userLoginPage.clickToContinueButton();
        userRegisterPage.EnterToFirstNameTextbox(firstName);
        userRegisterPage.EnterToLastNameTextbox(lastName);
        userRegisterPage.EnterToEmailTextbox(email);
        userRegisterPage.EnterToPasswordTextbox(userPassword);
        userRegisterPage.clickToPolicyTogle();
        userRegisterPage.ClickToContinueButton();
        Assert.assertTrue(userRegisterPage.isRegisterSuccessMassage());

        // user >> admin: không can thao tác switch
        adminLoginPage.enterToUserNameTextbox(GlobalConstants.ADMIN_OPENCART_USERNAME);
        adminLoginPage.enterToPasswordTextbox(GlobalConstants.ADMIN_OPENCART_PASSWORD);
        adminDashboardPage = adminLoginPage.clickToLoginButton();
        Assert.assertTrue(adminDashboardPage.isDashboardBreadcrumbDisplayed());

        // admin >> user: không can thao tác switch
        userHomePage = userRegisterPage.openUserOpenCartHomeLogo(userDriver);
        userHomePage.clickToMyAccountLink();
        userMyAccountPage = PageGenerator.getPage(UserMyAccountPO.class, userDriver);
        Assert.assertTrue(userMyAccountPage.isMyAccountPageDisplay());

        // user >> admin: không can thao tác switch
        adminCustomerPage = adminDashboardPage.openCustomerPage();
        Assert.assertTrue(adminCustomerPage.isCustomerBreadcrumbDisplayed());
    }


    @AfterClass
    public void afterClass() {
        closeBrowser(userDriver);
        closeBrowser(adminDriver);
    }

    private WebDriver userDriver;
    private WebDriver adminDriver;
    private String userUrl, adminUrl;
    private String firstName, lastName, email, userPassword;

    private UserHomePO userHomePage;
    private UserLoginPO userLoginPage;
    private UserRegisterPO userRegisterPage;
    private UserMyAccountPO userMyAccountPage;
    private AdminCustomerPO adminCustomerPage;
    private AdminDashboardPO adminDashboardPage;
    private AdminLoginPO adminLoginPage;

}