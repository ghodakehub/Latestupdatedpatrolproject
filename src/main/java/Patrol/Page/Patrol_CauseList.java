package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class Patrol_CauseList extends BasePage {
	
	public Patrol_CauseList(WebDriver driver) {
		super(driver);
	}

	
	
	 public void CheckCauselist()
	 {
		 
		  Library.threadSleep(3000);
		 
		    WebElement causeList  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[4]/a/span"));
		    causeList.click();

		     Library.threadSleep(2000);
            // Verify if the title is displayed
            WebElement causelistTitle = driver.findElement(By.xpath("//h1[contains(text(),'Causelist')]"));
            
            Library.threadSleep(2000);
           
            
		    boolean errorFound = Library.verifyText2(driver,"Stack trace","Error on Causelist page");

		    if (errorFound) {
		        System.out.println("Error Found in MyCauseList Page!");
		        AllureListeners.captureScreenshot(driver, "CauseList Page Error");
		        Assert.fail("error found while opening MyCauseList Page.");
		    } else {
		        System.out.println("My causelist Page Opened Successfully!");
		    }
		}
		 
		 
	 }

