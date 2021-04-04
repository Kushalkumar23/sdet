package stepDefinition;

import java.awt.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostJobSteps {
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

	@Then("^user Go to Post a Job page$")
	public void postJob() {
		driver.findElement(By.linkText("Post a Job")).click();
	}

	@When("^user enters the Job details \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")

	public void user_input(String Email, String JobTitle, String Description, String ApplicationEmail,
			String CompanyName) {

		driver.findElement(By.id("create_account_email")).sendKeys(Email);
		driver.findElement(By.id("job_title")).sendKeys(JobTitle);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,450)");

		// Thread.sleep(10000);
		driver.switchTo().frame("job_description_ifr");
		driver.findElement(By.id("tinymce")).sendKeys(Description);
		driver.switchTo().parentFrame();
		driver.findElement(By.id("application")).sendKeys(ApplicationEmail);
		driver.findElement(By.id("company_name")).sendKeys(CompanyName);
		js.executeScript("javascript:window.scrollBy(250,4000)");


	}

	@And("^Submit the Job$")
	public void submitJob() {
	    driver.findElement(By.xpath("//input[contains(@name, 'submit_job')]")).click();
	    driver.findElement(By.id("job_preview_submit_button")).click();
	}
	
	@Then("^Verify the \"(.*)\" listed on Jobs page$")
	public void validation(String JobTitle) throws Throwable {
		driver.findElement(By.linkText("Jobs")).click();
		driver.findElement(By.id("search_keywords")).sendKeys(JobTitle);
		driver.findElement(By.className("search_submit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//article/div/div/ul/li[1]/a/div[1]/h3")));
		String jobName = driver.findElement(By.xpath("//article/div/div/ul/li[1]/a/div[1]/h3")).getText();
			Assert.assertEquals(jobName, JobTitle);
	}

}
