package pageObjects.swaglabs;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.swaglabs.ProductPUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPO extends BasePage {
    private WebDriver driver;

    public ProductPO(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSortDropdown(String sortItem) {
        waitElementClickable(driver, ProductPUI.PRODUCT_SORT_DROPDOWN);
        selectItemInDropdown(driver, ProductPUI.PRODUCT_SORT_DROPDOWN, sortItem);
    }

    // java 7-
    public boolean isNameSortAscending() {
        // khai báo 1 list element để lưu trữ element product name
        List<WebElement> productNameElements = getListElement(driver, ProductPUI.PRODUCT_NAME);

        // khai báo 1 list String để lưu trữ text product name
        List<String> productNameTexts = new ArrayList<String>();

        // dùng vòng lặp lấy hết các element product name để thêm vào list productName text
        for (WebElement productNames : productNameElements) {
            productNameTexts.add(productNames.getText());
        }

        // sao chép toàn bộ text từ product name text qua 1 list mới
        List<String> productNameTextClone = new ArrayList<>(productNameTexts);

        // sort list clone
        Collections.sort(productNameTextClone);

        // kiểm tra 2 list bằng nhau
        return productNameTextClone.equals(productNameTexts);
    }

    // java 8+
    public boolean isProductNameSortAscending() {
        List<WebElement> productNameElements = getListElement(driver, ProductPUI.PRODUCT_NAME);
        List<String> productNameTexts = productNameElements.stream()
                .map(n -> n.getText()).collect(Collectors.toList());

        List<String> productNameTextClone = new ArrayList<>(productNameTexts);
        Collections.sort(productNameTextClone);
        return productNameTextClone.equals(productNameTexts);
    }

    // java 16+
    public boolean isProductNameSortAsc() {
        var elementList = getListElement(driver, ProductPUI.PRODUCT_NAME);
        var names = elementList.stream().map(WebElement::getText).toList();
        var sortednames = names.stream().sorted().toList();
        return names.equals(sortednames);
    }

    public boolean isNameSortDescending() {
        var elementList = getListElement(driver, ProductPUI.PRODUCT_NAME);
        var names = elementList.stream().map(WebElement::getText).toList();
        var sortednames = names.stream().sorted().toList();
        sortednames.reversed();
        return names.equals(sortednames);
    }

    public boolean isPriceSortAsc() {
        List<WebElement> productNameElements = getListElement(driver, ProductPUI.PRODUCT_PRICE);
        List<Float> productPriceTexts = new ArrayList<Float>();
        for (WebElement productNames : productNameElements) {
            productPriceTexts.add(Float.valueOf(productNames.getText().replace("$","")));
        }
        List<Float> productFriceTextClone = new ArrayList<>(productPriceTexts);
        Collections.sort(productFriceTextClone);
        return productFriceTextClone.equals(productPriceTexts);
    }

    public boolean isPriceSortDescending() {
        List<WebElement> productNameElements = getListElement(driver, ProductPUI.PRODUCT_PRICE);
        List<Float> productPriceTexts = new ArrayList<Float>();
        for (WebElement productNames : productNameElements) {
            productPriceTexts.add(Float.valueOf(productNames.getText().replace("$","")));
        }
        List<Float> productFriceTextClone = new ArrayList<>(productPriceTexts);
        Collections.sort(productFriceTextClone);
        Collections.reverse(productFriceTextClone);
        return productFriceTextClone.equals(productPriceTexts);
    }
}
