package jquery;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jquery.HomePO;

public class Topic_04_Data_Table extends BaseTest {



    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        homePage = PageGenerator.getPage(HomePO.class, driver);
    }

    @Test
    public void Table_01_Paging() {
        homePage.openPageNumber("2");
        Assert.assertTrue(homePage.isPageNumberDisplayed("2"));

        homePage.openPageNumber("8");
        Assert.assertTrue(homePage.isPageNumberDisplayed("8"));

        homePage.openPageNumber("1");
        Assert.assertTrue(homePage.isPageNumberDisplayed("1"));
    }

    //@Test
    public void Table_02_Search() {
        homePage.enterToTextboxByHeaderName("Country", "AFRICA");
        Assert.assertTrue(homePage.isRowDataValueDisplayed("12253515", "AFRICA", "12599691", "24853148"));
        homePage.refreshPage(driver);

        homePage.enterToTextboxByHeaderName("Females","338282");
        Assert.assertTrue(homePage.isRowDataValueDisplayed("338282", "Argentina", "349238", "687522"));
        homePage.refreshPage(driver);
    }

    @Test
    public void Table_03_Edit_Remove() {
        homePage.removeRowByCountryName("Argentina");
        Assert.assertEquals(homePage.listRowNumber("Argentina"),0);

        homePage.editRowByCountryName("AFRICA");
        Assert.assertTrue(homePage.isEditPopupDisplay());
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;

    private HomePO homePage;
}