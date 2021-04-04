package stepDefinition;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CreateUserSteps {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	List cols;

	@Given("^User is on Login page$")
	public void loginPage() {
		// Setup instances
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);

		// Open browser
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	}

	@When("^User enters username and password$")
	public void enterCredentials() {
		// Enter username
		driver.findElement(By.id("user_login")).sendKeys("root");
		// Enter password
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		// Click Login
		driver.findElement(By.xpath("//*[@id=\"wp-submit\"]")).click();

	}

	@And("^Locate the AddNew button and click it$")
	public void LocateAddNew() {
		actions = new Actions(driver);
		WebElement ActivityMenuLink = driver
				.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/ul[1]/li[6]/a/span[2]"));
		actions.moveToElement(ActivityMenuLink).build().perform();
//	      WebElement addnew= driver.findElement(By.id("wp-admin-bar-new-user"));
		wait = new WebDriverWait(driver, 15);
//	      java.util.List<WebElement> cols = driver.findElements(By.className("ab-sub-wrapper"));
//	      for(WebElement column : cols) {
//	    	    System.out.println(column.getText());   
//	    	}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("User")));
		driver.findElement(By.linkText("User")).click();
	}

	@When("^User enters new user details$")
	public void addNewUser() {
		driver.getTitle();
		driver.findElement(By.id("user_login")).sendKeys("KushalTest5");
		driver.findElement(By.id("email")).sendKeys("test5@tester.com");
		driver.findElement(By.id("first_name")).sendKeys("KushalK");
		driver.findElement(By.id("last_name")).sendKeys("Kumar");
		driver.findElement(By.id("url")).sendKeys("test.com");
		driver.findElement(By.id("createusersub")).click();
	}
	
	//"New user created. "

	@And("^Verify new user has been created$")
	public void userCreated() {
		String	user = driver.findElement(By.xpath("//*[text()[contains(., 'New user created. ')]]")).getText();
		System.out.println(user);
		 Assert.assertEquals("New user created. Edit user", user);
	}
	
	
	@And("^Close the Browser$")
	public void closeBrowser() {
		// Close browser
		driver.close();
	}
}
