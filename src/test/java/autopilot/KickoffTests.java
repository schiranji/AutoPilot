package autopilot;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/com/event/cucumber/features/pages/"},
        tags = "@Regression",
        plugin = {"pretty", "json:target/report.json", "html:target/selenium.html"},
        glue = {"com.techsavy.selenium"})
public class KickoffTests {

}
