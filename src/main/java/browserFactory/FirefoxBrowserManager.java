package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowserManager implements BrowserFactory {
    @Override
    public WebDriver getDriver() {
        FirefoxOptions ffOptions = new FirefoxOptions();
        // config capabilities
        return new FirefoxDriver(ffOptions);
    }
}
