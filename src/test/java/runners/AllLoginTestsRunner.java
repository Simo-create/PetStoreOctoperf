package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions","utils", "hooks"},
        plugin = {"pretty", "html:target/AllLoginTestsReport.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        }
)

public class AllLoginTestsRunner {
}
