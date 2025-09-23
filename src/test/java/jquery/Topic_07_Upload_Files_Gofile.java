package jquery;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jquery.GoFilePO;
import pageObjects.jquery.HomePO;

public class Topic_07_Upload_Files_Gofile extends BaseTest {

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);
        goFilePage = PageGenerator.getPage(GoFilePO.class, driver);
        firstImage = "lshopping.png";
        secondImage = "ScreenshotAnime.jpg";
    }

    @Test
    public void Table_01_() {
        Assert.assertTrue(goFilePage.isLoadingSpinnerDispeared());

        goFilePage.uploadMultipleFiles(driver, firstImage, secondImage);

        Assert.assertTrue(goFilePage.isLoadingSpinnerDispeared());
        Assert.assertTrue(goFilePage.isProgressBarDisappeared());

        goFilePage.clickToFileLink();

        Assert.assertTrue(goFilePage.isLoadingSpinnerDispeared());

        Assert.assertTrue(goFilePage.isFileUploadedByName(firstImage));
        Assert.assertTrue(goFilePage.isFileUploadedByName(secondImage));
    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;

    private GoFilePO goFilePage;

    private String firstImage, secondImage, thirdImage;
}