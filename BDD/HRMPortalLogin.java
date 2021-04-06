package stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HRMPortalLogin {
	
	WebDriver driver;
    WebDriverWait wait;
    String value;
    
	@Before
	public void beforeAll() throws InterruptedException {
		driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        
        //Open browser
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(5000);
	}
	
	
	@After
	public void afterAll() {
		driver.close();
	}
	
	@Given("^Navigate to the \"Recruitment\" page$")
    public void openJobSite() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]")));
    	driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]")).click();
        Thread.sleep(3000);
        
    }
	
	@Given("^Navigate to the PIM page$")
    public void openPIMPage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]")));
    	driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]")).click();
        Thread.sleep(3000);
        
    }
	
	@When("^Click on the \"Add\" button to navigate to the employee information form$")
	public void addEmployeeInfoPage() {
		driver.findElement(By.id("btnAdd")).click();
	}
	
	
	
	@And("^Fill out \"(.*)\" and \"(.*)\" and \"(.*)\" and Create Login Details checkbox is checked$")
	public void enterEmployeeInfo(String firstName, String lastName, String username) {
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		value = driver.findElement(By.id("employeeId")).getAttribute("value");
		System.out.println(value);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("chkLogin")));
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys("passW0rd");
		driver.findElement(By.id("re_password")).sendKeys("passW0rd");
	}
	
	@Then("^Navigate back to the employee page to confirm employee \"(.*)\" entry$")
	public void verifyTheemployeeId(String firstName) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu_pim_viewEmployeeList\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("empsearch_id")).sendKeys(value);
		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(3000);
		String actualEmployeeName = driver.findElement(By.xpath("//a[text()="+"'"+firstName+"'"+"]")).getText();
		System.out.println(actualEmployeeName);
	}
	
	@And("^Click on the \"Vacancies\" menu item to navigate to the vacancies page$")
	public void navigatetoVacancyPage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewJobVacancy\"]")).click();
        Thread.sleep(3000);	
	}

	@When("^Click on the \"Add\" button to navigate to the \"Add Job Vacancy\" form$")
	public void addJobVacancy() throws InterruptedException {
		driver.findElement(By.id("btnAdd")).click();
		Select jobselect = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
		jobselect.selectByIndex(2);
		driver.findElement(By.id("addJobVacancy_name")).sendKeys("Developer Job");
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("Test Tester");
		driver.findElement(By.id("addJobVacancy_noOfPositions")).sendKeys("2");
	}
	
	@When("^Click on the \"Add\" button to navigate to Add Job Vacancy form$")
	public void addJobVacancies() throws InterruptedException {
		
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(3000);
		
	}
	
	
	@And("^Fill out \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and Click the \"Save\" button$")
	public void fillJobVancancyDetails(int Job_Title, String JobVacancy_name, String hiringManager, String noOfPositions) throws InterruptedException {
		Select jobselect = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
		jobselect.selectByIndex(Job_Title);
		driver.findElement(By.id("addJobVacancy_name")).sendKeys(JobVacancy_name);
		driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(hiringManager);
		driver.findElement(By.id("addJobVacancy_noOfPositions")).sendKeys(noOfPositions);
		driver.findElement(By.id("btnSave")).click();
        Thread.sleep(3000);
		
	}
	
	@When("^Click on the \"Add\" button to navigate to the candidate information form$")
	public void addCandidateInfo() throws InterruptedException {
		driver.findElement(By.id("btnAdd")).click();
		Thread.sleep(2000);
	}
	
	@And("^Fill out the necessary details and Click the \"Save\" button$")
	public void saveJobVacancy() throws InterruptedException {
		driver.findElement(By.id("btnSave")).click();
        Thread.sleep(3000);
		
	}
	
	@And("^Fill out the necessary details and Upload a resume to the form$")
	public void addDetailsOfCandidate() throws InterruptedException {
		driver.findElement(By.id("addCandidate_firstName")).sendKeys("Jagadish");
		driver.findElement(By.id("addCandidate_lastName")).sendKeys("BR");
		driver.findElement(By.id("addCandidate_email")).sendKeys("john406@test123.com");
		driver.findElement(By.id("addCandidate_contactNo")).sendKeys("7424888403");
		WebElement selectItem = driver.findElement(By.id("addCandidate_vacancy"));
		Select item = new Select(selectItem);
		item.selectByValue("450");
		WebElement uploadElement = driver.findElement(By.id("addCandidate_resume"));
		uploadElement.sendKeys("C:\\Users\\JagadishBR\\Downloads\\CRM_project requirement.pdf");
		Thread.sleep(3000);
		
	}
	
	@Then("^Verify that the vacancy was created$")
	public void verifyJobDetails() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewJobVacancy\"]")).click();
        Thread.sleep(3000);
        WebElement vacancy = driver.findElement(By.id("vacancySearch_jobVacancy"));
        Select input = new Select(vacancy);
        input.selectByVisibleText("Developer Job");
		String jobTitle = driver.findElement(By.xpath("//a[contains(text(),'Developer Job')]")).getText();
		System.out.println("New Job Vacancy title:"+jobTitle);
	}
	
	@Then("^Verify that the vacancy \"(.*)\" was created$")
	public void verifyJobVacancyCreated(String JobVacancy_name) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewJobVacancy\"]")).click();
        Thread.sleep(3000);
        WebElement vacancy = driver.findElement(By.id("vacancySearch_jobVacancy"));
        Select input = new Select(vacancy);
        input.selectByVisibleText(JobVacancy_name);
        driver.findElement(By.id("btnSrch")).click();
        Thread.sleep(3000);
		WebElement JobVacancy = driver.findElement(By.xpath("//a[contains(text(),'"+JobVacancy_name+"')]"));
		String jobTitle = JobVacancy.getText();
		System.out.println("New Job Vacancy title:"+jobTitle);
	}
	
	@Then("^Navigate back to the Recruitments page to confirm candidate entry$")
	public void verifyCandidateAdd() throws InterruptedException {
		driver.findElement(By.id("btnBack")).click();
		Thread.sleep(3000);
		String Candidate = driver.findElement(By.xpath("//a[text()='Jagadish  BR']")).getText();
		assertEquals("Jagadish BR", Candidate);
	}
}
