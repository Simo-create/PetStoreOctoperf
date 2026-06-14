package octoperfPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    private By enterStoreLink = By.xpath("//a[contains(@href,'actions/Catalog.action')]");
    private By signInLink = By.xpath("//a[text()='Sign In']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnEnterStore() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(enterStoreLink)).click();
    }

    public void clickOnSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInLink));
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
     }
}
