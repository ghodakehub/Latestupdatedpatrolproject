package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class Patrol_OrderTracker extends BasePage {
	
	public Patrol_OrderTracker(WebDriver driver) {
		super(driver);
	}

	
	
	 public void checkordertrack()
	 {
		 
		 Library.threadSleep(3000);
		    WebElement ordertracker  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[6]/a/span"));
		    ordertracker.click();

		     //Library.threadSleep(2000);
            // Verify if the title is displayed
            WebElement ordertrack = driver.findElement(By.xpath("//h1[contains(text(),'Order Tracker')]"));
            
            Library.threadSleep(2000);
            boolean errorFound = Library.verifyText2(driver,"Stack trace","Error on OrderTracker page");

           
            if (errorFound) {
		        System.out.println("Error Found in OrderTracker Page!");
		        AllureListeners.captureScreenshot(driver, "OrderTracker Page Error");
		        Assert.fail("error found while opening OrderTracker Page.");
		    } else {
		        System.out.println("OrderTracker Page Opened Successfully!");
		    }
		}
		 


	 }

