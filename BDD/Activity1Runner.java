package testRunner;

	import org.junit.runner.RunWith;
	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
	    features = "Feature",
	    glue = "stepDefinition",
		tags = "@activity1",
		plugin= {"pretty"},
		monochrome= true
		
		)

	public class Activity1Runner {
	    //empty
	}

