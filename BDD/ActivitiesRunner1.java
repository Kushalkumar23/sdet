package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\KushalKumar\\eclipse-workspace\\Cucumber_practice\\Features\\Activity1_2.feature",
    glue = {"stepDefinitions"},
    tags = "@activity1_2"
)

public class ActivitiesRunner1 {
    //empty
}