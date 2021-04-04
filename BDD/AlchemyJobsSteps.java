package stepDefinition;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlchemyJobsSteps {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	List cols;

	@Given("^User Navigate to Alchemy Job page$")
	public void AlchemyJobPage() {
		// Setup instances
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		// Open browser
		driver.get("https://alchemy.hguy.co/jobs/jobs/");
	}

	@When("^User Search for full time job$")
		public void searchJob() {
		driver.findElement(By.xpath("//*[@id=\"search_keywords\"]")).sendKeys("Testing");
		driver.findElement(By.xpath("//*[@id=\"job_type_freelance\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"job_type_internship\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"job_type_part-time\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"job_type_temporary\"]")).click();
		driver.findElement(By.className("search_submit")).click();
	}
	
	 @Then ("^Find a job listing using XPath and it to see job details$")
	 public void jobDetails() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Testing Cucumber 09")));
		 driver.findElement(By.partialLinkText("Testing Cucumber 09")).click();
		 String title=driver.findElement(By.xpath("//header/div/h1[contains(@class,'entry-title')]")).getText();
		   System.out.println("Job title is "+ title);
	 }
	
	 @And("^Find and Click on the Apply for job button$") 	
		public void applyJob()	{
			driver.findElement(By.xpath("//div[3]/input")).click();	
		}
	 @And("^Close the browser$") 
	    public void Close() {
	    	driver.close();
	    }
}
