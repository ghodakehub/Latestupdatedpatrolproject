package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class Patrol_Notification extends BasePage {
	
	public Patrol_Notification(WebDriver driver) {
		super(driver);
	}

	
	
	 public void checknotification()
	 {
		 
		  Library.threadSleep(3000);
		  
		  
		 
		    WebElement notification  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[7]/a/span"));
		   // notification.click();
		    
		    JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 		js1.executeScript("arguments[0].scrollIntoView(true);",notification );
	 		notification.click();
	 		

		     Library.threadSleep(2000);
            // Verify if the title is displayed
            WebElement notificationTitle = driver.findElement(By.xpath("//h1[contains(text(),'Notification')]"));
            
            Library.threadSleep(2000);
            
		    boolean errorFound = Library.verifyText2(driver,"Stack trace","Error on Notifications page");

		    if (errorFound) {
		        System.out.println("Error Found in Notifications Page!");
		        AllureListeners.captureScreenshot(driver, "Notifications Page Error");
		        Assert.fail("error found while opening Notifications Page.");
		    } else {
		        System.out.println("Notifications Page Opened Successfully!");
		    }
		}
		 
	 }


