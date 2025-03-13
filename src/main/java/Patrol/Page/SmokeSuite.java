package Patrol.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class SmokeSuite  extends BasePage {
	

	public SmokeSuite (WebDriver driver) {
		super(driver);
		
	}
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
	  // List of modules and submodules to verify
    String[] modules = {"Dashboard","Manage Cases", "Reports", "My Cause List","Invoice","Order Tracker","Notification","Company", "Chat", 
                         };

    public void runSmokeTest() {
        for (String module : modules) {
            verifyModule(module);
        }
    }

    public void verifyModule(String moduleName) {
        try {
            WebElement moduleElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + moduleName + "']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", moduleElement);
            Thread.sleep(1000);  // Small delay
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", moduleElement);
    
            Thread.sleep(2000); 

            // Verify text to check for errors
            if (Library.verifyText2(driver,"Stack trace","error on this module") ||Library.verifyText2(driver,"404","404 error")) {
                System.out.println("Error detected in: " + moduleName);
                AllureListeners.captureScreenshot(driver,moduleName);  
                Thread.sleep(2000); 
               
            } else {
                System.out.println(moduleName + " opened successfully.");
            }

        } catch (Exception e) {
            System.out.println("Failed to open: " + moduleName);
            e.printStackTrace();
        }
    }

}
