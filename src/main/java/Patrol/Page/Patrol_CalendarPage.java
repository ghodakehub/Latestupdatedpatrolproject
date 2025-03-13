package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class Patrol_CalendarPage extends BasePage {
	
	public Patrol_CalendarPage(WebDriver driver) {
		super(driver);
	}

	
	
	 public void CheckCalendar()
	 {
		 
		  Library.threadSleep(3000);
		  
		  
		 
		    WebElement ManageCases  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[2]/a/span"));
		    ManageCases.click();
		    Library.threadSleep(2000);
		    
		    
		    
		    WebElement calendar  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[2]/ul/li[3]/a/span"));
		   
		    JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 		js1.executeScript("arguments[0].scrollIntoView(true);",calendar);
	 		calendar.click();
	 		
		    Library.threadSleep(2000);
		    
		    boolean errorFound = Library.verifyText2(driver,"Stack trace","Error on calendar page");

		    if (errorFound) {
		        System.out.println("Error Found in Calendar Page!");
		        AllureListeners.captureScreenshot(driver, "Calendar Page Error");
		        Assert.fail("error found while opening Calendar Page.");
		    } else {
		        System.out.println("Calendar Page Opened Successfully!");
		    }
		}
		 
	 }


