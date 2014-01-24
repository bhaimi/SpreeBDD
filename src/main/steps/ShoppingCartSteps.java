package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import resources.Pages.ProductDetailsPage;
import resources.Pages.SearchPage;
import resources.Pages.ShoppingCartPage;
import resources.TestData.Product;
import steps.SearchSteps;

import java.util.List;

/**
 * Created by Admin on 13/01/14.
 */
public class ShoppingCartSteps {

    private SearchPage searchPage;
    private SearchSteps searchSteps;

    public ShoppingCartSteps() {
        this.searchPage = LoginSteps.searchPage;
        this.searchSteps = new SearchSteps();

    }

    @When("^I add the following products$")
    public void I_add_the_following_products(List<Product> products) throws Throwable {
        for (Product product : products) {
             searchSteps.I_search_for_a_product_with_category(product.productName, product.category)
                    .setQuantity(product.quantity)
                    .addToCart()
                    .verifyProductDetails(product.productName, product.quantity)
                    .continueShopping();
        }
    }

    @Then("^I should see \"([^\"]*)\" Items in the Cart of Price \"([^\"]*)\"$")
    public void I_should_see_Items_in_the_Cart_of_Price(String totalItemQuantity, String price) throws Throwable {
        searchPage.verifyCartItemsAndAmount(totalItemQuantity, price);
    }

    @And("^I should be able to checkout as Guest$")
    public void I_should_be_able_to_checkout_as_Guest() throws Throwable {
        searchPage.clickOnCartLink().checkoutFromCart();
    }
}
