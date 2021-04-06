package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
   features = "Feature",
    glue = "stepDefinition",
    tags = "@OrangeHRMActivities",
    plugin = {"pretty", "html: target/cucumber-reports/Project3-reports"},
	monochrome= true
)

public class ActivitiesRunner {
    //empty
}
