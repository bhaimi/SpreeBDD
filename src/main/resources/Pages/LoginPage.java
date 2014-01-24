package resources.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Admin on 21/01/14.
 */
public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final String emailTextBoxId = "spree_user_email";
    private final String passwordTextboxId = "spree_user_password";
    private final String loginButtonName = "commit";
    private final String loginSuccessMessageDiv = "//div[contains(.,'Logged in successfully')]";

    public LoginPage EnterEmailId() {
        WebElement emailTextBox = getElementById(emailTextBoxId);
        emailTextBox.sendKeys("kokila@tw.com");
        return this;
    }

    public LoginPage EnterPassword() {
        WebElement passwordTextbox = getElementById(passwordTextboxId);
        passwordTextbox.sendKeys("password1");
        return this;
    }

    public void ClickLogin() {
        getElementByName(loginButtonName).click();
    }

    public void VerifySuccessfulLogin() {
        WebElement successfulLoginMessage = getElementByXpath(loginSuccessMessageDiv);
        assertTrue("Success message not found", successfulLoginMessage.isDisplayed());
    }

    public void VerifyLoginPage() {
        WebElement emailTextBox = getElementById("spree_user_email");
        assertTrue("Email Id textbox not found", emailTextBox.isDisplayed());
    }
}
