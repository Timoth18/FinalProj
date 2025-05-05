package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"api.stepdefinitions", "web.stepdefinitions"},
        plugin = {"pretty", "json:build/reports/cucumber-report.json", "html:build/reports/cucumber-report.html"},
        tags = "@api or @web"
)
public class CucumberTestRunner {
}