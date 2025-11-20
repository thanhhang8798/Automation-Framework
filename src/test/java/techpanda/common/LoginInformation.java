package techpanda.common;

import core.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.PageGenerator;
import pageObjects.techpanda.HomePO;
import pageObjects.techpanda.LoginPO;
import pageObjects.techpanda.MyAccountPO;
import pageObjects.techpanda.RegisterAccountPO;

import java.util.Set;

public class LoginInformation extends BaseTest {
    private WebDriver driver;
    String firstName, lastName, emailAddress, password, confirmPassword;

    @Parameters({"webUrl", "browser"})
    @BeforeTest
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        homePage = PageGenerator.getPage(HomePO.class, driver);

        firstName = "Hang";
        lastName = "Thanh";
        emailAddress = "abc.hang" + getRandomNumber() + "@gmail.com";
        password = "Auto222@@@";
        confirmPassword = "Auto222@@@";

        loginPage = homePage.openLoginPage();

        registerAccountPage = loginPage.clickToCreatAnAccountButton();
        registerAccountPage.inputToTextboxByName(driver, "firstname", firstName);
        registerAccountPage.inputToTextboxByName(driver, "lastname", lastName);
        registerAccountPage.inputToTextboxByName(driver, "email", emailAddress);
        registerAccountPage.inputToTextboxByName(driver, "password", password);
        registerAccountPage.inputToTextboxByName(driver, "confirmation", confirmPassword);
        registerAccountPage.clickToRegisterButton();

        myAccountPage = registerAccountPage.acceptContinueAlert();
        verifyTrue(myAccountPage.isRegisterSuccessMessageDisplayed());

        cookies = myAccountPage.getPageCookies(driver);

        closeBrowser();
    }

    @Test
    public void Login() {

    }


    @AfterClass
    public void afterClass() {

    }


    private LoginPO loginPage;
    private HomePO homePage;
    private RegisterAccountPO registerAccountPage;
    private MyAccountPO myAccountPage;
    public static Set<Cookie> cookies;
}
