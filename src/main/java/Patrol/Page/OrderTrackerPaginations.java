package Patrol.Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Patrol.Utility.AllureListeners;

public class OrderTrackerPaginations  extends BasePage{

	
	public OrderTrackerPaginations(WebDriver driver) {
		super(driver);
			
	}

	
	public void verifyOrdertrackerPaginations() {
		  
		  try {
			  
			
			  WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"filterTable_paginate\"]/span")));
	            scrollToBottom();
	            List<WebElement> paginationLinks = driver.findElements(By.xpath("//*[@id=\"filterTable_paginate\"]/span/a"));

	            if (paginationLinks.size() > 0) {
	                for (int i = 1; i <=4; i++) {
	                    try {
	                        WebElement pageButton = driver.findElement(By.xpath("//a[text()='" + i + "']"));
	                        
	                 
	                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pageButton);
	                        Thread.sleep(2000);

	                        List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id=\"filterTable\"]/tbody/tr"));

	                        if (tableRows.isEmpty()) {
	                        	AllureListeners.captureScreenshot(driver,"NoData_Page_" + i);
	                            Assert.fail("Page " + i + " contains no data.");
	                        }
	                    } catch (Exception e) {
	                    	System.out.println("Error coming on pages");
	                    }
	                }
	            } else {
	               System.out.println("pagination button not found");
	            }
	        } catch (Exception e) {
	        	
	        	System.out.println("Pagination Test Failed: " + e.getMessage());
	        }
	    }

	    private void scrollToBottom() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	    }

	    

}
