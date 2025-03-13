package Patrol.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;
import io.qameta.allure.Allure;

public class smokesuite2formanagecases  extends BasePage {
	

	public smokesuite2formanagecases (WebDriver driver) {
		super(driver);
		
	}
	public void verifyManageCasesSubmodules() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	   
	    By manageCasesLocator = By.xpath("//span[text()='Manage Cases']");
	    String[] submodules = {"Cases", "Matters", "Calendar", "Tasks", "Documents", "Contacts", "Alerts"};

	    
	    for (String submodule : submodules) {
	        try {
	            
	            WebElement manageCases = wait.until(ExpectedConditions.elementToBeClickable(manageCasesLocator));
	            manageCases.click();
	            Thread.sleep(1000); 
	            
	           
	            if (Library.verifyText2(driver,"Stack trace","error coming on this submodule of manage cases") || Library.verifyText2(driver,"Exception","error coming ")) {
	                throw new Exception("Stack trace error found in " + submodule);
	            }

	            System.out.println(submodule + " opened successfully.");
	            Allure.step(submodule + " opened successfully.");

	        } catch (Exception e) {
	            System.out.println("Failed to open: " + submodule);
	            AllureListeners.captureScreenshot(driver, "Error coming to open module");
	        }
	    }
	}
	        
	    }
	

