package Patrol.Utility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	
	 public static void waitForElementVisibility(WebDriver driver, WebElement element, int timeout) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	            wait.until(ExpectedConditions.visibilityOf(element));
	        } catch (Exception e) {
	            System.out.println("Element not visible within timeout: " + timeout + " seconds");
	        }
	    }

	    // Wait for Element to be Clickable
	    public static void waitForElementClickable(WebDriver driver, WebElement element, int timeout) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	        } catch (Exception e) {
	            System.out.println("Element not clickable within timeout: " + timeout + " seconds");
	        }
	    }

	    public static void waitForWindows(WebDriver driver, int windowCount, int timeoutInSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(timeoutInSeconds));
	        try {
	            wait.until(driver1 -> driver.getWindowHandles().size() == windowCount);
	            System.out.println("Window opened successfully");
	        } catch (TimeoutException e) {
	            System.out.println("Window did not open within timeout: " + e.getMessage());
	        }
	    }

	    // Wait for Loader to Disappear
	    public static void waitForLoader(WebDriver driver, By locator, int timeout) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	        } catch (Exception e) {
	            System.out.println("Loader did not disappear within timeout");
	        }
	    }

	    // Click with JS Executor and Wait
	    public static void clickElementWithJS(WebDriver driver, WebElement element, int timeout) {
	        try {
	            waitForElementClickable(driver, element, timeout);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	        } catch (Exception e) {
	            System.out.println("Failed to click element with JS");
	        }
	    }
	    
	    
	    public static void waitForPageLoad(WebDriver driver, int timeoutSeconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
	        try {
	            wait.until(new ExpectedCondition<Boolean>() {
	                public Boolean apply(WebDriver driver) {
	                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	                }
	            });
	            System.out.println("Page Loaded Successfully");
	        } catch (Exception e) {
	            System.out.println("Page Load Timeout after " + timeoutSeconds + " seconds: " + e.getMessage());
	        }
	    }
	

	    // Switch to Child Window and Verify Text
	    public static void switchToChildWindow(WebDriver driver, String parentWindow, int timeout) {
	        Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(parentWindow)) {
	                driver.switchTo().window(window);
	                System.out.println("Opened URL: " + driver.getCurrentUrl());
	                try {
	                    Library.verifyText(driver, "404", "404 Error Found on Page");
	                    Library.verifyText(driver, "Stack trace", "Stack Trace Found on Page");
	                } catch (Exception e) {
	                    AllureListeners.captureScreenshot(driver, "ViewOrder_Page");
	                    System.out.println("Exception Occurred on View Order Link: " + driver.getCurrentUrl());
	                }
	                driver.close();
	                waitForWindows(driver, 2, timeout);
	                driver.switchTo().window(parentWindow);
	            }
	        }
	    }
	    
	    public static void waitForPageLoad2(WebDriver driver, By locator, int i) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(i));
	            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	            System.out.println("Page opened successfully: " + element.getText());
	        } catch (Exception e) {
	            System.out.println("Orders page not opened: " + e.getMessage());
	            AllureListeners.captureScreenshot(driver, "Order_Page_Not_Opened");
	        }
	    }
	}
