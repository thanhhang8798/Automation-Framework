package core;


import browserFactory.*;
import environmentFactory.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;


public class BaseTestParallelTesting {
    // parallel testing
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
    public WebDriver getDriver() {
        return threadDriver.get();
    }

    protected final Logger log;

    public BaseTestParallelTesting() {
        this.log = LogManager.getLogger(getClass());
    }

    protected WebDriver getBrowserDriver(String webUrl, String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                threadDriver.set(new FirefoxDriver());
                break;
            case CHROME:
                threadDriver.set(new ChromeDriver());
                break;
            case EDGE:
                threadDriver.set(new EdgeDriver());
                break;
            case SAFARI:
                threadDriver.set(new SafariDriver());
                break;
            default:
                throw new RuntimeException("Browser name is invalid");
        }

        // 1 file xml cho nhiều môi trường
//        driver.get(getEnvironment(webUrl));
        threadDriver.get().get(webUrl);
//        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        threadDriver.get().manage().window().maximize();
        return threadDriver.get();
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
            String driverInstanceName = threadDriver.toString().toLowerCase();
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
            if (threadDriver != null) {
                threadDriver.get().manage().deleteAllCookies();
                threadDriver.get().quit();
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
}
