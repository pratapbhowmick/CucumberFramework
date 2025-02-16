package runners;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions","base"},monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
