package projectActivity2;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
  
	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "ddf0aa38");
        caps.setCapability("deviceName", "Redmi Note 5 Pro");
        caps.setCapability("platformName", "android");
        //caps.setCapability("browserName", "Chrome");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        
    }

    @Test(dataProvider = "Credentials")
    public void testSearchAppium(String UserName,String password,String Confirmation) throws InterruptedException {
      
        driver.get("https://www.training-support.net/selenium");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]")));
        String pageTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]").getText();
        System.out.println("Title on Homepage: " + pageTitle);
        driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")).click();
        
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollIntoView(textStartsWith(\"Login Form\"))"));

		//driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).flingForward().getChildByText(UiSelector().className(\"android.widget.TextView\"),\"Login Form\")")).click();
        Thread.sleep(4000);
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='Login Form']")).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='Log in']")));
        Thread.sleep(4000);

		driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys(UserName);
		driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys(password);
        
        driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
        Thread.sleep(2000);
        String actualText = driver.findElement(MobileBy.xpath("//android.view.View[@resource-id='action-confirmation']")).getText();

		System.out.println(actualText);

		Assert.assertEquals(actualText, Confirmation);
        
        
    }
    
    @DataProvider(name = "Credentials")
    public String[][] authenticationMethod(){

		String[][] data=new String[2][3];

		data[0][0]="admin";
		data[0][1]="password";
		data[0][2]="Welcome Back, admin";

		data[1][0]="admin";
		data[1][1]="admin123";
		data[1][2]="Invalid Credentials";

		return data;	

	}
	
   

	@AfterTest
    public void tearDown() {
        driver.quit();
    }
	
}
