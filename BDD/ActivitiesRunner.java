package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\KushalKumar\\eclipse-workspace\\Cucumber_practice\\Features\\Activity1_1.feature",
    glue = {"src/stepDefinitions"},
	tags = "@activity1_1"
	)

public class ActivitiesRunner {
    //empty
}