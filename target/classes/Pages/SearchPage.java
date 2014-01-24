package resources.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Admin on 13/01/14.
 */
public class SearchPage extends BasePage {

    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private String categoryLink = "//ul[contains(@class,'list')]/li/a[contains(.,'%s')]";
    private String productLink = "//ul[@id='products']/li/a[contains(.,'%s')]";
    private String cartLinkWithItemAndPrice = "//li[@id='link-to-cart']/a[contains(normalize-space(.),'Cart: (%s)')]/span[contains(.,'$%s')]";
    private String cartLink = "//li[@id='link-to-cart']/a";


    public SearchPage selectCategory(String category){
        String categoryLinkLocator = String.format(categoryLink, category);
        getElementByXpath(categoryLinkLocator).click();
        return this;
    }

    public SearchPage selectForProduct(String product){
        getElementById("keywords").sendKeys(product);
        getElementByXpath("//input[@type='submit']").click();
        return this;
    }

    public ProductDetailsPage selectProduct(String productName){
        String productLinkLocator = String.format(productLink, productName);
        getElementByXpath(productLinkLocator).click();
        return new ProductDetailsPage(webDriver);
    }

    public ProductDetailsPage verifyCartItemsAndAmount(String numberOfItems, String amount){
        String cartLocator = String.format(cartLinkWithItemAndPrice, numberOfItems, amount);
        WebElement element = getElementByXpath(cartLocator);
        assertTrue("Cart Link incorrect",null != element);
        return new ProductDetailsPage(webDriver);
    }


    public ShoppingCartPage clickOnCartLink() {
        getElementByXpath(cartLink).click();
        return new ShoppingCartPage(webDriver);
    }

    public SearchPage  verifySearchResults(String productName)
    {
        List<WebElement> products = getElementListByXpath("//li[starts-with(@id,'product_')]");
        // Assert product name
        for (WebElement p : products)
            assertTrue("PRODUCT NAME" + p.getText() + " is not matching", p.findElement(By.className("info")).getText().toLowerCase().contains(productName));
        return this;

    }

    public SearchPage  verifySearchResultsCount(int productCount)
    {
        List<WebElement> products = getElementListByXpath("//li[starts-with(@id,'product_')]");
        // Assert product count
        assertTrue("Product count is not matching",products.size()==productCount);
        return this;

    }

    public SearchPage verifyCategoryNameInSearchResults(String categoryName){

        assertTrue("Category Name is not matching", getElementListByXpath("//h1[@class='taxon-title']").get(0).getText().equals(categoryName));
        return this;
    }

    public SearchPage verifyCategoryNameCountInSearchResults(int categoryCount){

        assertTrue("Category count is not matching", getElementListByXpath("//h1[@class='taxon-title']").size()==categoryCount);
        return this;
    }

    public SearchPage verifyExpectedItemsDisplayed(String categoryName){
        List<String> actualItems = getProductsDisplayed();
        List<String> expectedItems = new ArrayList<String>();
        if (categoryName.equals("Bags")) {
            expectedItems = asList("Ruby on Rails Tote", "Ruby on Rails Bag", "Spree Tote", "Spree Bag");
        }
        else if (categoryName.equals("Mugs")){
            expectedItems = asList("Ruby on Rails Mug", "Ruby on Rails Stein", "Spree Stein", "Spree Mug");
        }

        else if (categoryName.equals("Clothing")){
            expectedItems = asList("Ruby on Rails Baseball Jersey","Ruby on Rails Jr. Spaghetti","Ruby on Rails Ringer T-Shirt","Ruby Baseball Jersey","Apache Baseball Jersey","Spree Baseball Jersey","Spree Jr. Spaghetti","Spree Ringer T-Shirt","Ruby on Rails Jr. Spaghetti","Ruby on Rails Jr. Spaghetti","Spree Jr. Spaghetti","Spree Jr. Spaghetti","Ruby on Rails Baseball Jersey","Ruby on Rails Baseball Jersey","Ruby on Rails Ringer T-Shirt","Ruby on Rails Ringer T-Shirt");
        }

        for (int i=0; i < actualItems.size();i++) {
            assertEquals("Filter By Category:", actualItems.get(i), expectedItems.get(i));
        }
        return this;
    }

    public SearchPage VerifyPriceRangeDisplayed(){
        assertTrue("Price range section is not displayed", null != webDriver.findElement(By.className("filter_choices")));
        return this;

    }

    public SearchPage verifyBreadCrumb(String category){
        String lastBreadCrumb = webDriver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li[4]")).getText();
        assertTrue(lastBreadCrumb==category);
        return this;
    }

    public List<String> getProductsDisplayed(){
        ArrayList<WebElement> resultList = (ArrayList<WebElement>) getElementListByXpath("//*[@id='products']/li/a");
        List<String> productNames = new ArrayList<String>();
        for (int i=0; i<resultList.size();i++) {
            productNames.add(resultList.get(i).getText());
        }
        return productNames;

    }


}



