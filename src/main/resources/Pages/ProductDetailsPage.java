package resources.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.Assert.assertTrue;


/**
 * Created by Admin on 13/01/14.
 */
public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private String addToCartButton = "add-to-cart-button";
    private String quantityTextbox = "//input[contains(@id,'variants')]";

    public ProductDetailsPage setQuantity(String quantity) {
        WebElement quantityLocator = getElementByXpath(quantityTextbox);
        quantityLocator.clear();
        quantityLocator.sendKeys(quantity);
        return this;
    }

    public ShoppingCartPage addToCart() {
        getElementById(addToCartButton).click();
        return new ShoppingCartPage(webDriver);
    }

    public ProductDetailsPage verifyProductPrice(String price) {
        String priceElementlocator = String.format("//div[@id='product-price']/div/span[contains(.,'%s')]", price);
        WebElement priceElement = webDriver.findElement(By.xpath(priceElementlocator));
        assertTrue("Price is not matching",null != priceElement);
        return this;
    }
}
