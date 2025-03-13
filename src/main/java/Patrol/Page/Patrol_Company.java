package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class Patrol_Company  extends BasePage {
	
	public Patrol_Company(WebDriver driver) {
		super(driver);
	}

	
	
	 public void CheckSwitchCompany()
	 {
		 
		  Library.threadSleep(3000);
		  
		  
		 
		    WebElement switchCompany  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[8]/a/span"));
		   // notification.click();
		    
		    JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 		js1.executeScript("arguments[0].scrollIntoView(true);",switchCompany );
	 		switchCompany.click();
	 		

		     Library.threadSleep(2000);
            // Verify if the title is displayed
            WebElement Activefirm = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1"));
            
            Library.threadSleep(2000);
           
            
		    boolean errorFound = Library.verifyText2(driver,"Stack trace","Error while switching company");

		    if (errorFound) {
		        System.out.println("Error Found in switching company!");
		        AllureListeners.captureScreenshot(driver, "company Page Error");
		        Assert.fail("error found while opening company Page.");
		    } else {
		        System.out.println("company Page Opened Successfully!");
		    }
		}
		 

}
