package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class Patrol_ChatPage extends BasePage {
	
	public Patrol_ChatPage(WebDriver driver) {
		super(driver);
	}

	
	
	 public void CheckAI_Chat()
	 {
		 
		  Library.threadSleep(3000);
		 
		    WebElement chat  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[9]/a/span"));
		    Library.threadSleep(500);
		    JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 		js1.executeScript("arguments[0].scrollIntoView(true);",chat );
	 		chat.click();
	 		
		     Library.threadSleep(2000);
            // Verify if the title is displayed
            WebElement ChatTitle = driver.findElement(By.xpath("//h4[contains(text(),'Your GPT-Powered AI assistant with unmatched legal knowledge!')]"));
            
            Library.threadSleep(2000);
           
            
		    boolean errorFound = Library.verifyText2(driver,"Stack trace","Error on AIchat page");

		    if (errorFound) {
		        System.out.println("Error Found in AIChat Page!");
		        AllureListeners.captureScreenshot(driver, "AI Chat Page Error");
		        Assert.fail("error found while opening chat Page.");
		    } else {
		        System.out.println("AI chat  Page Opened Successfully!");
		    }
		}
		 
		 
	 }


