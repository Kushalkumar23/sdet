package stepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertTestSteps {
	   WebDriver driver;
	    WebDriverWait wait;
	    Alert alert;
	    
	    @Given("^User is on the page$")
	    public void openPage() throws Throwable {
	        //Create a new instance of the Firefox driver
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, 15);
	                
	        //Open the browser
	        driver.get("https://www.training-support.net/selenium/javascript-alerts");
	    
	    }
	    
	    @When("^User clicks the Simple Alert button$")
	    public void openSimpleAlert() throws Throwable {
	        driver.findElement(By.cssSelector("#simple")).click();
	    }
	    
	    @When("^User clicks the Confirm Alert button$")
	    public void openConfirmAlert() throws Throwable {
	        driver.findElement(By.cssSelector("#confirm")).click();
	    }
	    
	    @When("^User clicks the Prompt Alert button$")
	    public void openPromptAlert() throws Throwable {
	        driver.findElement(By.cssSelector("#prompt")).click();
	    }
	    
	    @Then("^Alert opens$")
	    public void switchFocus() throws Throwable {
	    	alert= driver.switchTo().alert();
	    }
	    
	    @And("^Read the text from it and print it$")
	    public void readAlert() throws Throwable {
	    	System.out.println("Alert says: " + alert.getText());
	    }  
	    
	    @And("^Write a custom message in it$")
	    public void writeToPrompt() {
	        alert.sendKeys("Custom Message");
	    }
	    
	    @And("^Close the alert$")
	    public void closeAlert() {
	        alert.accept();
	    }
	    
	    @And("^Close the alert with Cancel$")
	    public void dismissAlert() throws Throwable {
	    	alert.dismiss();
	    }

	    @And("^Close Browser$")
	    public void closeBrowser() {
	        driver.close();
	    }
	    
}
	    
