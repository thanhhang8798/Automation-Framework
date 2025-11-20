package techpanda;


import core.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.techpanda.MyAccountPO;
import pageObjects.techpanda.HomePO;
import pageObjects.techpanda.LoginPO;
import pageObjects.techpanda.RegisterAccountPO;
import techpanda.common.LoginInformation;

import java.util.Set;

public class Topic_01_Cookie extends BaseTest {
    private WebDriver driver;

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        this.cookies = LoginInformation.cookies;

        homePage = PageGenerator.getPage(HomePO.class, driver);
        loginPage = homePage.openLoginPage();
        loginPage.setPageCookies(driver, this.cookies);
    }

    @Test
    public void TC_01_Cookies() {

    }


    @AfterClass
    public void afterClass() {
        closeBrowser(driver);
    }


    private LoginPO loginPage;
    private HomePO homePage;
    private RegisterAccountPO registerAccountPage;
    private MyAccountPO myAccountPage;
    private Set<Cookie> cookies;
}
