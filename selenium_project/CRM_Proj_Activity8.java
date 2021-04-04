package project_CRM;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CRM_Proj_Activity8 {

	WebDriver driver;
	Actions actions;
	WebDriverWait wait;

	@BeforeTest
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void f() throws InterruptedException {
		WebElement firstName = driver.findElement(By.id("user_name"));
		WebElement lastName = driver.findElement(By.id("username_password"));
		firstName.sendKeys("admin");
		lastName.sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();

		WebElement element1 = driver.findElement(By.id("grouptab_0"));
		actions.moveToElement(element1);
		actions.click(element1).build().perform();
		WebElement element2 = driver.findElement(By.id("moduleTab_9_Accounts"));
		element2.click();

		//wait to load next page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list-view-rounded-corners']")));
		Reporter.log("Accounts table is visible |");
		
		//Get the list of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-responsive')]/tbody/tr"));
		String name;
		for(int i = 1; i < rows.size() && i < 10; ) {
			name = driver.findElement(By.xpath("//table[contains(@class, 'table-responsive')]/tbody/tr["+i+"]/td[3]")).getText();
			Reporter.log("Row no is : "+i+" Account Name is: "+name+"", true);
			i = i +2;
		}
	}
	
	@AfterClass
	public void afterClass() {
		//close browser
		driver.close();
	}
}