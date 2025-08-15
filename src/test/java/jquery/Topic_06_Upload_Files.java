package jquery;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jquery.HomePO;

public class Topic_06_Upload_Files extends BaseTest {

    @Parameters({"webUrl", "browser"})
    @BeforeClass
    public void beforeClass(String webUrl, String browserName) {
        driver = getBrowserDriver(webUrl, browserName);
        homePage = PageGenerator.getPage(HomePO.class, driver);
        firstImage = "lshopping.png";
        secondImage = "ScreenshotAnime.jpg";
    }

    @Test
    public void Table_01_() {
        // upload 1 file
        homePage.uploadMultipleFiles(driver, firstImage);
        homePage.refreshPage(driver);

        // upload nhiều file
        homePage.uploadMultipleFiles(driver, firstImage, secondImage);

        // verify sau khi tải file lên
        homePage.isFileLoadedByName(firstImage);
        homePage.isFileLoadedByName(secondImage);

        // click button start để upload file
        homePage.clickToStartButton();

        // verify sau khi tải file lên thành công
        homePage.isFileUploadedByName(firstImage);
        homePage.isFileUploadedByName(secondImage);
    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private WebDriver driver;

    private HomePO homePage;

    private String firstImage, secondImage, thirdImage;
}