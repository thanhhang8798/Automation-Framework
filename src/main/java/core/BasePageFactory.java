package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePageFactory {
    public static BasePageFactory getInstance() {
        return new BasePageFactory();
    }


    private final int LONG_TIMEOUT = 30;
    private final int SHORT_TIMEOUT = 10;


    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }


    private Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public void sendkeyToAlert(WebDriver driver, String keyToSend) {
        waitAlertPresence(driver).sendKeys(keyToSend);
    }

    public String getAlertText(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }



    public void sleepInSecond(int timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void switchToWindowByID(WebDriver driver, String windowID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(windowID)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    private void closeWindow(WebDriver driver, String windowID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(windowID)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }
        driver.switchTo().window(windowID);
    }


    private void switchToWindowByTitle (WebDriver driver, String expectedTitle) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
            String pageTitle = driver.getTitle();
            if (pageTitle.equals(expectedTitle)) {
                break;
            }
        }
        sleepInSecond(2);
    }




    public  void clickToElement(WebElement element) {
        element.click();
    }

    public void sendKeyToElement(WebElement element, String keyToSend) {
        element.clear();
        element.sendKeys(keyToSend);
    }

    public void selectItemInDropdown(WebElement element, String valueItem) {
        new Select(element).selectByVisibleText(valueItem);
    }

    public String getSelectItemInDropdown(WebElement element) {
        return new Select(element).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebElement element) {
        return new Select(element).isMultiple();
    }

//    public void selectItemInDropdown(WebDriver driver, String parentLocator, String childLocator, String textItem) {
//        clickToElement(driver, parentLocator);
//
//        new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
//                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));
//
//        List<WebElement> allItems = getListElement(driver, childLocator);
//
//        for (WebElement item : allItems) {
//            if (item.getText().equals(textItem)) {
//                item.click();
//                sleepInSecond(1);
//                break;
//            }
//        }
//    }

    public String getElementDOMAttribute(WebElement element, String attributeName) {
        return element.getDomAttribute(attributeName);
    }

    public String getElementDOMProperty(WebElement element, String propertyName) {
        return element.getDomProperty(propertyName);
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public String getElementCss(WebElement element, String propertyName) {
        return element.getCssValue(propertyName);
    }

    public String getHexaByRGBA(String rgbaColor) {
        return Color.fromString(rgbaColor).asHex().toUpperCase();
    }

//    public int getListElementNumber(WebDriver driver, WebElement element) {
//        return getListElement(driver, locator).size();
//    }

//    public void checkToCheckbox(WebElement element) {
//        if (!isElementSelected(element)) {
//            clickToElement(element);
//        }
//    }

//    public void uncheckToCheckbox(WebDriver driver, WebElement element) {
//        if (isElementDisplayed(driver, element)) {
//            clickToElement(driver, element);
//        }
//    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    public boolean isElementEnable(WebElement element) {
        return element.isEnabled();
    }

    public void switchToFrame(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void doubleClick(WebDriver driver, WebElement element) {
        new Actions(driver).doubleClick(element).perform();
    }

    public void rightClick(WebDriver driver, WebElement element) {
        new Actions(driver).contextClick(element).perform();
    }

//    public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
//        new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
//    }

    public void sendKeyBoardToElement(WebDriver driver, WebElement element, Keys keys) {
        new Actions(driver).sendKeys(element, keys).perform();
    }




    public Object executeForBrowser(WebDriver driver, String javaScript) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

//    public void hightlightElement(WebDriver driver, WebElement element) {
//        WebElement element = getWebElement(driver, locator);
//        String originalStyle = getElementAttribute(driver, locator, "style");
//        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
//        sleepInSecond(2);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
//    }

    public void clickToElementByJS(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        sleepInSecond(3);
    }

    public String getElementTextByJS(WebDriver driver, WebElement element) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", element);
    }

    public void scrollToElementOnTop(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToElementOnDown(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public String getAttributeInDOM(WebDriver driver, WebElement element, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", element);
    }

    public String getElementValidationMessage(WebDriver driver, WebElement element) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", element);
    }

    public boolean isImageLoaded(WebDriver driver, WebElement element) {
        return (boolean) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", element);
    }


    public WebElement waitElementVisible(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitListElementVisible(WebDriver driver, List<WebElement> elements) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public boolean waitElementSelected(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(element));
    }

    public WebElement waitElementClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitElementInvisible(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean waitListElementInvisible(WebDriver driver, List<WebElement> elements) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfAllElements(elements));
    }
}


