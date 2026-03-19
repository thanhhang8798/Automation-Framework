package environmentFactory;

import browserFactory.*;
import core.GlobalConstants;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LocalEnvManager implements EnvironmentFactory {
    private WebDriver driver;
    private String browserName;

    public LocalEnvManager(String browserName) {
        this.browserName = browserName;
    }

    @Override
    public WebDriver createDriver() {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case FIREFOX:
                driver = new FirefoxBrowserManager().getDriver();
                break;
            case CHROME:
                driver = new ChromeBrowserManager().getDriver();
                break;
            case EDGE:
                driver = new EdgeBrowserManager().getDriver();
                break;
            case SAFARI:
                driver = new SafariBrowserManager().getDriver();
                break;
            case COCCOC:
                driver = new CoccocBrowserManager().getDriver();
                break;
            default:
                throw new RuntimeException("Browser name is invalid");
        }
        return driver;
    }
}
