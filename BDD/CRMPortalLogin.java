package stepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRMPortalLogin {
	
	WebDriver driver;
    WebDriverWait wait;
    
    @Given("^I navigate to the login page$")
    public void navigateToLoginPage() throws Throwable {
    	driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @When("^I submit username and password$")
    public void submitLogin() throws Throwable {
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        Thread.sleep(5000);
    }

    @Then("^I should be logged in$")
    public void i_should_be_logged_in() throws Throwable {
        System.out.println("I am logged on to the website");
    }
    
    @Given("^Navigate to Create Lead page$")
    public void navigateToLeadPage() throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("dashlet-title")));
    	WebElement salesLink = driver.findElement(By.id("grouptab_0"));
    	WebElement leadLink = driver.findElement(By.id("moduleTab_9_Leads"));
    	Actions actions = new Actions(driver);
    	actions.moveToElement(salesLink);
        Thread.sleep(3000);
        actions.moveToElement(leadLink);
        actions.click().build().perform();
        Thread.sleep(5000);
        
    }
    
    @When("^Fill in the necessary details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void fillDetailsOfLead(String head, String firstName, String LastName) throws InterruptedException {
    	driver.findElement(By.xpath("//li[1]//a[1]//div[2]")).click();
    	Thread.sleep(2000);
    	WebElement header = driver.findElement(By.id("salutation"));
    	Select input = new Select(header);
    	input.selectByValue(head);
    	driver.findElement(By.id("first_name")).sendKeys(firstName);
    	driver.findElement(By.id("last_name")).sendKeys(LastName);
    	
    }
    
    @Then("^Click Save to finish$")
    public void saveLeadDetails() throws InterruptedException {
    	driver.findElement(By.id("SAVE")).click();
    	Thread.sleep(3000);
    	
    }
    
    @And("^Navigate to the View Leads page to see \"(.*)\"$")
    public void verifyLeadName(String leadName) throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='View Leads']")));
    	driver.findElement(By.xpath("//div[text()='View Leads']")).click();
    	Thread.sleep(3000);
    	String leadname = driver.findElement(By.xpath("//a[contains(text(),'"+leadName+"')]")).getText();
    	System.out.println(leadname);
    	
    }
    
    @Given("^Login to CRM Site$")
    public void loggedInCRM() {
    	System.out.println("User logged into CRM");
    }
    
    @Given("^Navigate to Meeting setup page$")
    public void navigateToMeetingPage() throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("dashlet-title")));
    	WebElement ActivityLink = driver.findElement(By.id("grouptab_3"));
    	WebElement MeetingLink = driver.findElement(By.id("moduleTab_9_Meetings"));
    	Actions actions = new Actions(driver);
    	actions.moveToElement(ActivityLink);
        Thread.sleep(3000);
        actions.moveToElement(MeetingLink);
        actions.click().build().perform();
        Thread.sleep(5000);
    }
    
    
    @When("^Enter the details of the meeting$")
    public void enterMeetingDetails() throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Schedule Meeting')]")));
    	driver.findElement(By.xpath("//div[contains(text(),'Schedule Meeting')]")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Sample Meeting1");
    	
    }
    
    @Then("^The names \"(.*)\" and \"(.*)\" and \"(.*)\" and Click Save$")
    public void addingInvitees(String invitee1, String invitee2, String invitee3) throws InterruptedException {
    	List<String> List1 = new ArrayList<String>();
    	List1.add(invitee1);
    	List1.add(invitee2);
    	List1.add(invitee3);
    	
    	for(String item: List1) {
    		driver.findElement(By.id("search_first_name")).clear();
    		driver.findElement(By.id("search_first_name")).sendKeys(item);
    		driver.findElement(By.id("invitees_search")).click();
    		Thread.sleep(3000);
    		driver.findElement(By.id("invitees_add_1")).click();
    	}
    	
    	driver.findElement(By.id("SAVE_HEADER")).click();
    	Thread.sleep(3000);
    }
    
    @And("^Navigate to View Meetings page and confirm creation of the meeting$")
    public void verifytheMeeting() throws InterruptedException {
    	driver.findElement(By.xpath("//div[contains(text(),'View Meetings')]")).click();
    	Thread.sleep(3000);
    	String name = driver.findElement(By.xpath("//a[contains(text(),'Sample Meeting1')]")).getText();
    	System.out.println("Meeting name is : "+name);
    }
    
    
    @Given("^Navigate to Create product page$")
    public void navigateToProductPage() throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("dashlet-title")));
    	driver.findElement(By.xpath("//a[text()='All']")).click();
    	WebElement productlink = driver.findElement(By.xpath("//a[text()='Products']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",productlink);
        Thread.sleep(5000);
    }
    
    @When("^Enter the details of the product \"(.*)\" and \"(.*)\"$")
    public void enterProductDetails(String name, String price) throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Create Product')]")));
    	driver.findElement(By.xpath("//div[contains(text(),'Create Product')]")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.id("name")).sendKeys(name);
    	driver.findElement(By.id("price")).sendKeys(price);
    }
    
    @Then("^Click Save$")
    public void clickSave() throws InterruptedException {
    	driver.findElement(By.id("SAVE")).click();
    	Thread.sleep(3000);
    }
    
    @And("^Go to the \"View Products\" page to see product \"(.*)\" listed$")
    public void viewProductsPage(String name) throws InterruptedException {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'View Products')]")));
    	driver.findElement(By.xpath("//div[contains(text(),'View Products')]")).click();
    	Thread.sleep(3000);
    	String productName = driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).getText();
    	System.out.println("Name of the product is : "+productName);
    }
    
    @When("^main page is displayed$")
    public void onTheMainPage() {
    	System.out.println("User is on Main Page");
    }
    
    @Then("^Count the number of Dashlets on the homepage$")
    public void countNumberOfDashlets() {
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("dashlet-title")));
    	List<WebElement> List1 = driver.findElements(By.className("dashlet-title"));
    	System.out.println("Number of Dashlets on Main Page : "+List1.size());
    }
    
    @And("^Print the number and title of each Dashlet into the console$")
    public void getDashlet() {
    	List<WebElement> List1 = driver.findElements(By.className("dashlet-title"));
    	for(int i=0;i<List1.size();i++) {
    		String name = List1.get(i).getText();
    		int i2 = i + 1;
        	System.out.println("Number "+i2+" dashlet name: "+name);
    	}
    	
    }
    
    @And("^Close the browser$")
    public void afterall() {
    	driver.close();
    }

}
