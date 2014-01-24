package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.Pages.SearchPage;


public class FilterSteps {
    private SearchPage searchPage;

    public FilterSteps() {
        this.searchPage = LoginSteps.searchPage;
    }


    @When("^I filter by category \"([^\"]*)\"$")
    public void I_filter_by_category(String category) {
        searchPage.selectCategory(category);
    }

    @Then("^I should see products belong to Category \"([^\"]*)\" in the results$")
    public void I_should_see_products_with_category_in_the_results(String categoryName) throws Throwable {
        searchPage.verifyExpectedItemsDisplayed(categoryName);
    }

    @Then("^I should see the category as \"([^\"]*)\" in the bread crumb in results$")
    public void I_should_see_the_category_in_bread_crumb(String category) {
        searchPage.verifyBreadCrumb(category);
    }


    @Then("^I should see the filter for price range$")
    public void I_should_see_the_filter_for_price_range() throws Throwable {
        searchPage.VerifyPriceRangeDisplayed();
    }

    @And("^I should see products belonging to the selected price range.$")
    public void I_should_see_products_belonging_to_the_selected_price_range() throws Throwable {
    }
}


