package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class Patrol_Reports extends BasePage {
	
	public Patrol_Reports(WebDriver driver) {
		super(driver);
	}
	
	 public void testNavigationOptions() {

		   Library.threadSleep(3000);
             WebElement reports  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[3]/a/span"));
             reports.click();
             Library.threadSleep(1000);
             // Verify if the title is displayed
             WebElement reportsTitle = driver.findElement(By.xpath("//h1[contains(text(),'Report')]"));
             Library.threadSleep(1000);
             boolean errorFound = Library.verifyText2(driver,"Stack trace","Error on Report page");

             
             if (errorFound) {
 		        System.out.println("Error Found in Report Page!");
 		        AllureListeners.captureScreenshot(driver, "Reports Page Error");
 		        Assert.fail("error found while opening Reports Page.");
 		    } else {
 		        System.out.println("Reports Page Opened Successfully!");
 		    }
 		}
 		 
        
	 }

		


