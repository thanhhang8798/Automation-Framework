package core;

public class GlobalConstants {
    // wait infor
    public static final int LONG_TIMEOUT = 20;
    public static final int SHORT_TIMEOUT = 10;

    // system infor
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");
        // hoặc viết ngắn gọn thành: public static final String SEPARATOR = "file.seperator";

    // download/ upload file
    public static final String UPLOAD_PATH = PROJECT_PATH  + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH  + SEPARATOR + "downloadFiles" + SEPARATOR;

    // nopcommerce
    public static final String ADMIN_NOPCOMMERCE_EMAIL = "thanhhang8798@gmail.com";
    public static final String ADMIN_NOPCOMMERCE_PASSWORD = "Auto222@@@";

    // opencart
    public static final String ADMIN_OPENCART_USERNAME = "automationfc";
    public static final String ADMIN_OPENCART_PASSWORD = "Auto222@@@";

    // orangehrm
    public static final String ADMIN_ORANGEHRM_USERNAME = "automationfc";
    public static final String ADMIN_ORANGEHRM_PASSWORD = "Auto222@@@";
}
