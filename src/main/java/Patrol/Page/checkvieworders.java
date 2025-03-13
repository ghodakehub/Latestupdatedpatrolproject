package Patrol.Page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;
import Patrol.Utility.WaitUtility;

public class checkvieworders extends BasePage{

	
	public checkvieworders(WebDriver driver) {
		super(driver);
			
	}
	 List<String> errorUrls = new ArrayList<>(); // Collect Failed URLs
	    String screenshotPath;
	    
	   
	    public void verifyOrderPages2() {
	        try {
	        	 Library.threadSleep(15000);
	 	        WebElement orderTracker = driver.findElement(By.xpath("//*[@id='accordionSidebar']/div[3]/li[6]/a/span"));
	 	        orderTracker.click();
	 	        Library.threadSleep(9000);

	            List<WebElement> viewOrders = driver.findElements(By.xpath("//a[contains(text(),'View Order')]"));
	            String parentWindow = driver.getWindowHandle();

	            for (WebElement order : viewOrders) {
	                try {
	                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", order);
	                    WaitUtility.waitForWindows(driver, 2, 40); // Wait for new window to open

	                    Set<String> allWindows = driver.getWindowHandles();
	                    String childWindow = "";

	                    for (String window : allWindows) {
	                        if (!window.equals(parentWindow)) {
	                            childWindow = window;
	                            break;
	                        }
	                    }

	                    if (!childWindow.isEmpty()) {
	                        driver.switchTo().window(childWindow);
	                        String currentUrl = driver.getCurrentUrl();
	                        System.out.println("Opened URL: " + currentUrl);

	                        boolean errorFound = Library.verifyText2(driver, "404", "404 Error Found on Page: " + currentUrl)
	                                || Library.verifyText2(driver, "Stack trace", "Stack Trace Error Found on Page: " + currentUrl);

	                        if (errorFound) {
	                            errorUrls.add(currentUrl);
	                            AllureListeners.captureScreenshot(driver, "ViewOrder_Error_Page");
	                            System.out.println("Error Captured on: " + currentUrl);
	                        }

	                        // Close Child Window with Exception Handling
	                        try {
	                            driver.close();
	                            System.out.println("Closed Window: " + currentUrl);
	                            WaitUtility.waitForWindows(driver, 1, 20);
	                        } catch (Exception e) {
	                            System.out.println("Window Close Timeout: " + currentUrl);
	                        }

	                        // Switch Back to Parent Window
	                        Library.threadSleep(2000);
	                        driver.switchTo().window(parentWindow);
	                        WaitUtility.waitForPageLoad(driver, 30);
	                    }

	                } catch (Exception e) {
	                    AllureListeners.captureScreenshot(driver, "ViewOrder_Click_Error");
	                    System.out.println("Exception on View Order Click: " + e.getMessage());
	                }
	            }

	        } catch (Exception e) {
	            AllureListeners.captureScreenshot(driver, "Order_Tracker_Error");
	            Assert.fail("Order Tracker Verification Failed: " + e.getMessage());
	        }
	    }
	    	
	    }

