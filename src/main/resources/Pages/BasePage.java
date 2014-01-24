package resources.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by Admin on 21/01/14.
 */
public class BasePage {
    protected static WebDriver webDriver;
    public static String SpreeHostName ="http://localhost:3000";

    public static SearchPage launchApp() {
        webDriver = new FirefoxDriver();
        webDriver.navigate().to(SpreeHostName);
        return new SearchPage(webDriver);
    }

    public WebElement getElementById(String Id) {
        return webDriver.findElement(By.id(Id));
    }

    public WebElement getElementByName(String name) {
        return webDriver.findElement(By.name(name));
    }

    public WebElement getElementByXpath(String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }

    public List<WebElement> getElementListByXpath(String xpath) {
        return webDriver.findElements(By.xpath(xpath));
    }

    public LoginPage NavigateToLogin() {
        webDriver.findElement(By.linkText("LOGIN")).click();
        return new LoginPage(webDriver);
    }

    public byte[] captureScreenshot() {
        final byte[] screenshot = ((TakesScreenshot) webDriver)
                .getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public void closeBrowser() {
        webDriver.close();
        webDriver.close();
    }
}
