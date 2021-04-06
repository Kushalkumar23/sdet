package projectActivity1;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
        caps.setCapability("deviceName", "Pixel_4_Device");
        caps.setCapability("platformName", "android");
        //caps.setCapability("browserName", "Chrome");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        
    }
    
    @Test
    public void settingNotesOnKeepApp() throws InterruptedException {
  	  
  	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	  wait = new WebDriverWait(driver, 10);
  	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/new_note_button")));
  	 
  	  driver.findElementById("com.google.android.keep:id/new_note_button").click();
  	  String Title = "Jo Birthday";
  	  String Note = "Wife Birthday";
  	  
  	  
  	  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys(Note);
  	  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys(Title);
  	  
  	driver.findElementByAccessibilityId("Open navigation drawer").click();

    

    String title = driver.findElementByXPath("//android.widget.TextView[1][@text='Jo Birthday']").getText();
    System.out.println(title);
    assertEquals(title, "Jo Birthday");

    

    String description = driver.findElementByXPath("//android.widget.TextView[2][@text='Wife Birthday']").getText();
    System.out.println(description);
    assertEquals(description, "Wife Birthday");
  	  
  	  }
  	  
  	  
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
  
}
