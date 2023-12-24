package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        features = "src/main/resources/features",
        glue = {"test.steps",
                "test.hooks",},
        tags = "@Run"
)
public class TestRunner {
}