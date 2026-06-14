package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import utils.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {
       // DriverFactory.initializeDriver();
        DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}