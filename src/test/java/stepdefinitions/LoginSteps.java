package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import octoperfPageObjectModel.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import octoperfPageObjectModel.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

//import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utils.DriverFactory;

public class LoginSteps {
    private static final Logger logger = LogManager.getLogger(LoginSteps.class);
    //WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    WebDriver driver = DriverFactory.getDriver();
  //  WebDriver driver;
    private By signInLink = By.xpath("//a[text()='Sign In']");

    @When("Click on Enter the Store")
    public void clickOnEnterStore() {
        logger.info("Clicking on Enter the Store");
        homePage.clickOnEnterStore();
    }

    @Then("The JPetStore page is displayed")
    public void theJPetStorePageIsDisplayed() {
        System.out.println("JPetStore page is displayed");
    }

    @Given("Open the JPetHomePage")
    public void open_the_j_pet_home_page() {
        driver.get("https://petstore.octoperf.com/");
        homePage = new HomePage(driver);
        System.out.println("Opened JPet Home Page");
        logger.info("Opened JPet Home Page");
    }

    @And("Click on Sign In")
    public void clickOnSignIn() {
        logger.info("Clicking on Sign In");
        homePage.clickOnSignIn();
    }

    @Then("Login page is displayed")
    public void loginPageIsDisplayed() {

    }

    @Given("User is on Login page")
    public void userIsOnLoginPage() {
        driver = DriverFactory.getDriver();
        driver.get("https://petstore.octoperf.com/");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver); // Initialize loginPage

        homePage.clickOnEnterStore();
        homePage.clickOnSignIn();
        logger.info("User navigated to Login page. Current URL: " + driver.getCurrentUrl());

        System.out.println(driver.getCurrentUrl());

    }

    @When("Enter username {string}")
    public void enterUsername(String username) {
        logger.info("Entering username: " + username);
        loginPage.enterUsername(username);
    }

    @And("Enter password {string}")
    public void enterPassword(String password) {
        logger.info("Entering password");
        loginPage.enterPassword(password);
    }

    @And("Click on Login")
    public void clickOnLogin() {
        loginPage.clickOnLogin();
    }

    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        
    }

    @Then("Validation message is displayed")
    public void validationMessageIsDisplayed() {
        String url = driver.getCurrentUrl();
        System.out.println("URL curent: " + url);

        Assert.assertTrue(url.contains("Account.action"));
        WebElement loginBtn = driver.findElement(By.cssSelector("input[value='Login']"));
        Assert.assertTrue(loginBtn.isDisplayed());

    }
}
