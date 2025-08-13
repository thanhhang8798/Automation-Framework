package jquery;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jquery.TablePO;

public class Topic_04_Data_Table extends BaseTest {



    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);

        tablePage = PageGenerator.getPage(TablePO.class, driver);
    }

    @Test
    public void Table_01_Paging() {
        tablePage.openPageNumber("2");
        Assert.assertTrue(tablePage.isPageNumberDisplayed("2"));

        tablePage.openPageNumber("8");
        Assert.assertTrue(tablePage.isPageNumberDisplayed("8"));

        tablePage.openPageNumber("1");
        Assert.assertTrue(tablePage.isPageNumberDisplayed("1"));
    }

    //@Test
    public void Table_02_Search() {
        tablePage.enterToTextboxByHeaderName("Country", "AFRICA");
        Assert.assertTrue(tablePage.isRowDataValueDisplayed("12253515", "AFRICA", "12599691", "24853148"));
        tablePage.refreshPage(driver);

        tablePage.enterToTextboxByHeaderName("Females","338282");
        Assert.assertTrue(tablePage.isRowDataValueDisplayed("338282", "Argentina", "349238", "687522"));
        tablePage.refreshPage(driver);
    }

    @Test
    public void Table_03_Edit_Remove() {
        tablePage.removeRowByCountryName("Argentina");
        Assert.assertEquals(tablePage.listRowNumber("Argentina"),0);

        tablePage.editRowByCountryName("AFRICA");
        Assert.assertTrue(tablePage.isEditPopupDisplay());
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;

    private TablePO tablePage;
}