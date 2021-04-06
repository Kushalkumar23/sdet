package projectActivity1;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class Activity1 {
	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_4_Device");
        caps.setCapability("platformName", "android");
        //caps.setCapability("browserName", "Chrome");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        
    }

  @Test
  public void addingTaskOnAPP() throws InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/tasks_fab")));
	  ArrayList<String> tasklist = new ArrayList<String>();
	  tasklist.add("Complete Activity with Google Tasks");
	  tasklist.add("Complete Activity with Google Keep");
	  tasklist.add("Complete the second Activity Google Keep");
	  
	  for (String f : tasklist) { 
	  driver.findElementById("com.google.android.apps.tasks:id/tasks_fab").click();
	  MobileElement button = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
	  button.sendKeys(f);
	  driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	  Thread.sleep(3000);
	  }
	  
	  
	  List<MobileElement> elementList = driver.findElementsById("com.google.android.apps.tasks:id/task_name");
	  for (MobileElement f: elementList) {
		  System.out.println(f.getText());
	  }
	  
	  assertEquals(elementList.get(2).getText(), "Complete Activity with Google Tasks");
	  assertEquals(elementList.get(1).getText(), "Complete Activity with Google Keep");
	  assertEquals(elementList.get(0).getText(), "Complete the second Activity Google Keep");
	  
  }
  
  @AfterTest
  public void tearDown() {
      driver.quit();
  }
}
