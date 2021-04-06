package projectActivity2;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
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
import junit.framework.Assert;

public class Activity1 {
	
	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_4_Device");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        
        
    }

    @Test
    public void testSearchAppium() throws InterruptedException {
      
        driver.get("https://www.training-support.net/selenium");
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]")));
        String pageTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]").getText();
        System.out.println("Title on Homepage: " + pageTitle);
        driver.findElement(MobileBy.xpath("//android.widget.Button[@text='Get Started!']")).click();
        //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).flingForward().getChildByText(UiSelector().className(\"android.widget.TextView\"), \"To-Do List\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).flingForward().scrollIntoView(textStartsWith(\"To-Do List\"))"));
        Thread.sleep(4000);
        driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.Button[@text='Add Task']")));
        
        MobileElement inputField = driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']");
        MobileElement taskButton = driver.findElementByXPath("//android.widget.Button[@text='Add Task']");
    
      
        inputField.sendKeys("Add tasks to list");
        taskButton.click();
        Thread.sleep(2000);
        inputField.sendKeys("Get number of tasks");
        taskButton.click();
        Thread.sleep(2000);
        inputField.sendKeys("Clear the list");
        taskButton.click();
        Thread.sleep(2000);
        
        List<MobileElement> list1 = driver.findElementsByXPath("//android.view.View[2]/android.view.View");
        System.out.println("Size of the List is: "+list1.size());
		driver.findElement(MobileBy.xpath("//android.view.View[@text='Add tasks to list']")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath("//android.view.View[@text='Get number of tasks']")).click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath("//android.view.View[@text='Clear the list']")).click();
		Thread.sleep(2000);
        driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]").click();
        
        //verifying list is empty
       Assert.assertEquals(false, list1.contains(MobileBy.xpath("//android.view.View[@text='Add tasks to list']")));
       Assert.assertEquals(false, list1.contains(MobileBy.xpath("//android.view.View[@text='Get number of tasks']")));
       Assert.assertEquals(false, list1.contains(MobileBy.xpath("//android.view.View[@text='Clear the list']")));
    }
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
  
}
