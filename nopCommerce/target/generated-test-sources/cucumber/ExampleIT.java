import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
features = {"D:/4th year first term/java installer/Workspace/nopCommerce/nopCommerce/src/test/resources/features/example.feature:8"},
plugin = {"json:target/cucumber-reports/1.json"},
monochrome = false,
glue = { "Demo" })
public class ExampleIT {
}
