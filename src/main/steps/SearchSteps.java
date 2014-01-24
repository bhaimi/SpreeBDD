package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.Pages.ProductDetailsPage;
import resources.Pages.SearchPage;

public class SearchSteps {

    private SearchPage searchPage;
    public static ProductDetailsPage productDetailsPage;

    public SearchSteps() {
        this.searchPage = LoginSteps.searchPage;
    }

    @When("^I search for product \"([^\"]*)\"$")
    public void I_search_for_product(String product) throws Throwable {
        searchPage.selectForProduct(product);

    }

    @Then(value = "^I should see product with name \"([^\"]*)\" in the results with the count of \"([^\"]*)\"$")
    public void I_should_see_item_in_the_results_with_the_count_of(String productName, String productCount) throws Throwable {
        searchPage.verifySearchResultsCount(Integer.parseInt(productCount));
        searchPage.verifySearchResults(productName);
    }


    @When("^I click on Product Category \"([^\"]*)\"$")
    public void I_click_on_Product_Category(String productCategory) throws Throwable {
        searchPage.selectCategory(productCategory);

    }

    @Then("^I should see all Products with Category \"([^\"]*)\" in the results with the count of \"([^\"]*)\"$")
    public void I_should_see_all_Products_with_Category_in_the_results_with_the_count_of(String categoryName, String productsCount) throws Throwable {
        searchPage.verifyCategoryNameCountInSearchResults(1);
        searchPage.verifySearchResultsCount(Integer.parseInt(productsCount));
        searchPage.verifyCategoryNameInSearchResults(categoryName);
    }

    @And("^I search for a product \"([^\"]*)\" with category \"([^\"]*)\"$")
    public ProductDetailsPage I_search_for_a_product_with_category(String product, String category) throws Throwable {
        this.productDetailsPage =  searchPage
                .selectCategory(category)
                .selectProduct(product);
        return productDetailsPage;
    }

    @Then("^I see the price as \"([^\"]*)\"$")
    public void I_see_the_price_as(String price) throws Throwable {
        productDetailsPage.verifyProductPrice(price);
    }
}


