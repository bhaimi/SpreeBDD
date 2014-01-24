package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import resources.Pages.BasePage;
import resources.Pages.LoginPage;
import resources.Pages.SearchPage;

/**
 * Created by Admin on 21/01/14.
 */
public class LoginSteps{
    protected BasePage basePage;
    protected LoginPage loginPage;
    public static SearchPage searchPage;

    @Given("^I launch the app$")
    public void I_launch_the_app() throws Throwable {
        basePage = new BasePage();
        searchPage = BasePage.launchApp();
    }

    @When("^I click on the Login Link$")
    public void I_click_on_the_Login_Link() throws Throwable {
        loginPage = basePage.NavigateToLogin();
    }

    @Then("^I should be navigated to Login Page$")
    public void I_should_be_navigated_to_Login_Page() throws Throwable {
        loginPage.VerifyLoginPage();
    }

    @And("^I enter credentials and continue$")
    public void I_enter_credentials_and_continue() throws Throwable {
        loginPage.EnterEmailId().EnterPassword().ClickLogin();
    }

    @Then("^I should be able to Login$")
    public void I_should_be_able_to_Login() throws Throwable {
        loginPage.VerifySuccessfulLogin();
    }


    @After()
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = basePage.captureScreenshot();
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
        basePage.closeBrowser();
    }

}
