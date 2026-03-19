package core;

public class GlobalConstants {
    // wait infor
    public static final int LONG_TIMEOUT = 10;
    public static final int SHORT_TIMEOUT = 5;

    // system infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");
        // hoặc viết ngắn gọn thành: public static final String SEPARATOR = "file.seperator";

    // download/ upload file
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;
    public static final String DATA_FILE_PATH = PROJECT_PATH + SEPARATOR + "src" + SEPARATOR + "test" + SEPARATOR + "resources" + SEPARATOR + "testdata" + SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR + "src" + SEPARATOR + "test" + SEPARATOR + "resources" + SEPARATOR + "config" + SEPARATOR;

    // nopcommerce
    public static final String ADMIN_NOPCOMMERCE_EMAIL = "thanhhang8798@gmail.com";
    public static final String ADMIN_NOPCOMMERCE_PASSWORD = "Auto222@@@";

    // opencart
    public static final String ADMIN_OPENCART_USERNAME = "automationfc";
    public static final String ADMIN_OPENCART_PASSWORD = "Auto222@@@";

    // orangehrm
    public static final String ADMIN_ORANGEHRM_USERNAME = "automationfc";
    public static final String ADMIN_ORANGEHRM_PASSWORD = "Auto222@@@";

    // HTML report folder
    public static final String REPORTING_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;

    // Jira
    public static final String JIRA_SITE_URL = "https://thanhhang8798.atlassian.net/";
    public static final String JIRA_USERNAME = "thanhhang8798@gmail.com";
    public static final String JIRA_API_KEY = "ATATT3xFfGF0Y3q2hGLu1PmfSVFLnXXa_LpR29cN9s0rUZk0PaZP-4p8ARV_2EXFe66SkhmY6u061UMG7Sk0UarqfgLgQE8GB3LjovK8YcqMl6Sv-OqrAgStjEjQ3y2i0rridG6wKckQ-2njkN7OOTwuRcg25GTKzMWcKOalWNHiCtq9dMkWhqk=D7A4C934";
    public static final String JIRA_PROJECT_KEY = "FRAMEWORK";

    // BrowserStack
    public static final String BROWSER_STACK_USERNAME = "thanhhng_mdsCJY";
    public static final String BROWSER_STACK_AUTOMATE_KEY = "qxwJRUZVTHAqJhZNTAhf";
    public static final String BROWSER_STACK_URL = "https://" + BROWSER_STACK_USERNAME + ":" + BROWSER_STACK_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    // SauceLabs
    public static final String SAUCELABS_USERNAME = "oauth-thanhhang8798-ac7b8";
    public static final String SAUCELABS_AUTOMATE_KEY = "2452615a-a0fc-4bd8-8aa1-63a22bd7c434";
    public static final String SAUCELABS_URL = "https://" + SAUCELABS_USERNAME + ":" + SAUCELABS_AUTOMATE_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    // LamdaTest
    public static final String LAMDATEST_USERNAME = "thanhhang8798";
    public static final String LAMDATEST_AUTOMATE_KEY = "LT_CBhb7j0fMK7FVzT0hqShuEG9vYFVXU0HjcyRDevM1hKPP66";
    public static final String LAMDATEST_URL = "https://" + LAMDATEST_USERNAME + ":" + LAMDATEST_AUTOMATE_KEY + "@hub.lambdatest.com/wd/hub";
}
