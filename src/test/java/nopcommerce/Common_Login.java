package nopcommerce;

import core.BaseTest;
import core.GlobalConstants;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.PageGenerator;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountSideBarPO.*;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import java.util.Set;

public class Common_Login extends BaseTest{
    @Parameters({"userUrl", "adminUrl", "browser"})
    @BeforeTest
    public void beforeClass(String userUrl, String adminUrl, String browserName) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;

        driver = getBrowserDriver(userUrl, browserName);
        userHomePage = PageGenerator.getPage(UserHomePageObject.class, driver);

        firstName = "Bui";
        lastName = "Hang";
        userEmail = "buihang" + getRandomNumber() + "@gmail.com";
        userPassword = "Auto222@@@";
        confirmPassword = "Auto222@@@";

        userRegisterPage = userHomePage.openRegisterPage(driver);
        userRegisterPage.enterToTextboxByID(driver,"FirstName", firstName);
        userRegisterPage.enterToTextboxByID(driver,"LastName", lastName);
        userRegisterPage.enterToTextboxByID(driver,"Email", userEmail);
        userRegisterPage.clickToCheckboxByID(driver, "Newsletter");
        userRegisterPage.enterToTextboxByID(driver,"Password", userPassword);
        userRegisterPage.enterToTextboxByID(driver,"ConfirmPassword", confirmPassword);
        userRegisterPage.clickToButtonByText(driver, "Register");

        Assert.assertEquals(userRegisterPage.getRegisterResultMassage(), "Your registration completed");

        userRegisterPage.clickToLinkByText(driver, "Log out");;
        userHomePage = PageGenerator.getPage(UserHomePageObject.class, driver);

        userLoginPage = userHomePage.clickToLoginLinkAtUserSite(driver);
        userLoginPage.enterToTextboxByID(driver,"Email", userEmail);
        userLoginPage.enterToTextboxByID(driver,"Password", userPassword);
        userLoginPage.clickToButtonByText(driver, "Log in");

        userHomePage = PageGenerator.getPage(UserHomePageObject.class, driver);

        // get cookies
        nopCommerceCookies = userHomePage.getPageCookies(driver);
        System.out.println(nopCommerceCookies);

        driver.quit();
    }


    private WebDriver driver;
    private String userUrl, adminUrl;
    String firstName, lastName, confirmPassword;
    public static String userEmail, userPassword;

    private UserHomePageObject userHomePage;
    private UserRegisterPageObject userRegisterPage;
    private UserLoginPageObject userLoginPage;
    public static Set<Cookie> nopCommerceCookies;
}




