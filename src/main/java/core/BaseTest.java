package core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Random;


public class BaseTest {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    protected final Logger log;

    public BaseTest() {
        this.log = LogManager.getLogger(getClass());
    }

    protected WebDriver getBrowserDriver(String webUrl, String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxDriver();

//                FirefoxOptions fOptions = new FirefoxOptions();
//                // disable notification popup of browser
////                fOptions.addPreference("dom.webnotifications.enabled", false);
//
//                // disable location popup
//                fOptions.addPreference("geo.enabled", false);
//                fOptions.addPreference("geo.provider.use_corelocation", false);
//
//                driver = new FirefoxDriver(fOptions);

                break;
            case CHROME:
                driver = new ChromeDriver();

//                ChromeOptions cOptions = new ChromeOptions();
////                // đổi ngôn ngữ của browser
//////                cOptions.addArguments("--lang=vi");
////
////                // disable notification popup of browser
////                cOptions.addArguments("--disable-notification");
//
//                // disable location popup
////                cOptions.addArguments("--disable-geolocation");
//
//                // disable automation infor bar
//                cOptions.setExperimentalOption("useAutomationExtension", false);
//                cOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//                driver = new ChromeDriver(cOptions);

                break;
            case EDGE:
                driver = new EdgeDriver();

//                EdgeOptions eOptions = new EdgeOptions();
////
////                // đổi ngôn ngữ của browser
//////                eOptions.addArguments("--lang=vi");
////
////                // disable notification popup of browser
////                eOptions.addArguments("--disable-notification");
//
//                // disable location popup
////                eOptions.addArguments("--disable-geolocation");
//
//                // disable automation infor bar
//                eOptions.setExperimentalOption("useAutomationExtension", false);
//                eOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
////
//                driver = new EdgeDriver(eOptions);

                break;
            case COCCOC:
                ChromeOptions ccOptions = new ChromeOptions();
                ccOptions.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
                driver = new ChromeDriver(ccOptions);
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Browser name is invalid");
        }

        // 1 file xml cho nhiều môi trường
//        driver.get(getEnvironment(webUrl));
        driver.get(webUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        log.info("================== INIT BROWSER & DRIVER ==================");
        return driver;
    }

    private String getEnvironment(String envName) {
        String webUrl = null;
        switch (envName) {
            case "local":
                webUrl = "http://localhost:88/orangehrm/web";
                break;
            case "test":
                webUrl = "http://test/orangehrm/web";
                break;
            case "product":
                webUrl = "https://opensource-demo.orangehrmlive.com/";
                break;
            default:
                throw new RuntimeException("Environment is not value");
        }
        return webUrl;
    }

    protected void closeBrowser() {
        String cmd = null;
        try {
            String osName = GlobalConstants.OS_NAME.toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else {
                throw new RuntimeException("Driver instance is not support");
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("================== CLOSE BROWSER & DRIVER ==================");
    }

    protected void closeBrowser(WebDriver driver) {
        if (!(null == driver)) {
            driver.quit();
        }
        log.info("================== CLOSE BROWSER & DRIVER ==================");
    }

    protected int getRandomNumber() {
        return new Random().nextInt(9999);
    }


    // verify
    protected boolean verifyTrue(boolean condition) {
        boolean status = true;
        try {
            Assert.assertTrue(condition);
            log.info("----------------- PASSED -----------------");
        } catch (Throwable e) {
            status = false;
            log.info("----------------- FAILED -----------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean status = true;
        try {
            Assert.assertFalse(condition);
            log.info("----------------- PASSED -----------------");
        } catch (Throwable e) {
            status = false;
            log.info("----------------- FAILED -----------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean status = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("----------------- PASSED -----------------");
        } catch (Throwable e) {
            status = false;
            log.info("----------------- FAILED -----------------");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
//            log.info("OS name = " + osName);
            String driverInstanceName = driver.toString().toLowerCase();
//            log.info("Driver instance name = " + driverInstanceName);
            String browserDriverName = null;
            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else {
                browserDriverName = "safaridriver";
            }
            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
//            log.info(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("htmlAllure");
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
