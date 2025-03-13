package Patrol.Page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class VeiwOrder_OrderTracker extends BasePage {
	
	
	 List<String> errorUrls = new ArrayList<>(); // Collect Failed URLs
	    String screenshotPath;
	    
	public VeiwOrder_OrderTracker(WebDriver driver) {
		super(driver);
	}
	
	public void verifyOrderPages() {
	    try {
	        Library.threadSleep(3000);
	        WebElement orderTracker = driver.findElement(By.xpath("//*[@id='accordionSidebar']/div[3]/li[6]/a/span"));
	        orderTracker.click();
	        Library.threadSleep(2000);
	                List<WebElement> pages = driver.findElements(By.xpath("//*[@id=\"filterTable_paginate\"]/span/a")); // Replace with actual pagination locator

	                for (int i = 0; i < pages.size(); i++) {
	                    try {
	                        // Click on Pagination Page
	                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pages.get(i));
	                        Thread.sleep(3000); // Wait for page load

	                        List<WebElement> viewOrders = driver.findElements(By.xpath("//a[contains(text(),'View Order')]"));

	                        if (viewOrders.size() > 0) {
	                            for (int j = 0; j < viewOrders.size(); j++) {
	                                try {
	                                    WebElement order = viewOrders.get(j);
	                                    String currentUrl = driver.getCurrentUrl();
	                                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", order);
	                                    Thread.sleep(3000); // Wait for page load

	                                    // ✅ Calling verifyText() for 404 Error
	                                    Library.verifyText(driver, "404", "404 Error Found on Page: " + currentUrl);
	                                    
	                                    // ✅ Calling verifyText() for Stack Trace Error
	                                    Library.verifyText(driver, "Stack trace", "Stack Trace Error Found on Page: " + currentUrl);

	                                    Patrol.Utility.SwitchWindow.switchWindowByIndex(driver, 0);
	                                    Thread.sleep(2000);
	                                } catch (Exception e) {
	                                    AllureListeners.captureScreenshot(driver, "ViewOrder_Error_Page");
	                                    errorUrls.add(driver.getCurrentUrl());
	                                    System.out.println("Exception Occurred on View Order Link: " + driver.getCurrentUrl());
	                                }
	                            }
	                        } else {
	                            System.out.println("No 'View Order' Buttons Found on Page: " + (i + 1));
	                        }
	                    } catch (Exception e) {
	                        AllureListeners.captureScreenshot(driver, "Pagination_Error_Page_" + (i + 1));
	                        System.out.println("Failed to Verify Pagination Page: " + (i + 1));
	                    }
	                }
	            } catch (Exception e) {
	                AllureListeners.captureScreenshot(driver, "Order_Tracker_Error");
	                Assert.fail("Order Tracker Pagination Verification Failed: " + e.getMessage());
	            }
	        }

}
