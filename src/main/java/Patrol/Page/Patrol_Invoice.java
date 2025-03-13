package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class Patrol_Invoice extends BasePage {
	
	public Patrol_Invoice(WebDriver driver) {
		super(driver);
	}

	
	
	 public void checkinvoice()
	 {
		 
		  Library.threadSleep(3000);
		 
		    WebElement invoice  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[5]/a/span"));
		    invoice.click();

		     Library.threadSleep(2000);
            // Verify if the title is displayed
            WebElement InvoiceTitle = driver.findElement(By.xpath("//h1[contains(text(),'Invoice')]"));
            
            Library.threadSleep(2000);
           
            
		    boolean errorFound = Library.verifyText2(driver,"Stack trace","Error on Invoice page");

		    if (errorFound) {
		        System.out.println("Error Found in Invoice Page!");
		        AllureListeners.captureScreenshot(driver, "Invoice Page Error");
		        Assert.fail("error found while opening Invoice Page.");
		    } else {
		        System.out.println("Invoice Page Opened Successfully!");
		    }
		}
		 
	 }


