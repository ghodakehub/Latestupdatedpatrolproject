package Patrol.Utility;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Allure;

public class Library {
	
	public static List<String> errorUrls = new ArrayList<>();
	public static List<String> screenshotPaths = new ArrayList<>();
	public static List<byte[]> screenshotBytesList = new ArrayList<>();
	public static String companyName = "";  // Global Company Name Variable

	
	public static WebElement waitForVisibilityOf(WebDriver driver, WebElement element) {
		Library.scrollByPixelSize(driver, 100);
		Library.threadSleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public static void scrollTillElementDisplay(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void scrollByPixelSize(WebDriver driver, int PixelSize) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + PixelSize + ")", "");
	}

	public static void click(WebDriver driver, WebElement element, String LogMessege) {
		try {
			scrollTillElementDisplay(driver, element);
			waitForVisibilityOf(driver, element);
			element.click();
			System.out.println(LogMessege);
		} catch (Exception e) {
			element.click();
			System.out.println("Test failed at step : " + element);

		}
	}

	public static void sendKeys(WebDriver driver, WebElement element, String LogMessege, String enterValue) {
		try {
			scrollTillElementDisplay(driver, element);
			waitForVisibilityOf(driver, element);
			element.clear();
			element.sendKeys(enterValue);
			System.out.println(LogMessege);
		} catch (Exception e) {
			element.sendKeys(enterValue);
			System.out.println("Test failed at step : " + LogMessege);
		}
	}

	public static void performEnterAction(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}

	public static void threadSleep(int MiliSeconds) {
		try {
			Thread.sleep(MiliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getConfigueData(String key) {
		Properties pro = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Config_Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			pro.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = pro.getProperty(key);
		return value;
	}

	public static void WindowHandle(WebDriver driver, WebElement element) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);

			System.out.println("Child window: " + driver.getTitle());
		}
	}

	public static void implicitWait(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void verifyText(WebDriver driver, WebElement element, String TextOnWebPage) {
		String extectedText = TextOnWebPage;
		if (element.isDisplayed() && element.getText().equals(extectedText)) {
			System.out.println("Text Verification successful on page.");
		} else {
			System.out.println("Text veificaton failed on page.");
		}
	}

	public static void selectDropDown(WebElement element, String EnterValue) {
		Select select = new Select(element);
		select.selectByVisibleText(EnterValue);
		//select.selectByValue(EnterValue1);
	}


	public static void verifyText(WebDriver driver, String searchText, String message) {
	    try {
	        List<WebElement> errorElements = driver.findElements(By.xpath("//*[contains(text(),'" + searchText + "')]"));
	        if (!errorElements.isEmpty()) {
	            String url = driver.getCurrentUrl();
	            errorUrls.add(url);
	            
	            byte[] screenshot = AllureListeners.captureScreenshot(driver, message); // Capture Screenshot Path
	            screenshotBytesList.add(screenshot);// Store Screenshot Path
	            
	            Allure.addAttachment("URL", url);
	      
	            System.out.println("Error found on URL: " + url);
	        }
	    } catch (Exception e) {
	        System.out.println("No error found: " + e.getMessage());
	    }
	}

    
	
	public static boolean verifyText2(WebDriver driver, String searchText, String message) {
	    try {
	        List<WebElement> errorElements = driver.findElements(By.xpath("//*[contains(text(),'" + searchText + "')]"));
	        if (!errorElements.isEmpty()) {
	            String url = driver.getCurrentUrl();
	            errorUrls.add(url);
	            Allure.addAttachment("URL", url);
	           
	            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	            System.out.println(" Error Found: " + searchText + " on URL: " + url);
	            return true; // Return true if error is found
	        }
	    } catch (Exception e) {
	        System.out.println("No error found: " + e.getMessage());
	    }
	    return false; // Return false if no error
	}

	
	public static void addScreenshotToList(WebDriver driver, String screenshotName) {
	    byte[] screenshot = AllureListeners.captureScreenshot(driver, screenshotName);
	    if (screenshot != null) {
	        screenshotBytesList.add(screenshot);
	        System.out.println("Screenshot added to list for email.");
	    }
	}

	public static void verifyPagination(WebDriver driver ,String pageXPath, Runnable actionOnEachPage) {
	    List<WebElement> paginationLinks = driver.findElements(By.xpath(pageXPath));

	    if (paginationLinks.size() > 0) {
	        for (int i = 1; i <= paginationLinks.size(); i++) {
	            try {
	                WebElement pageLink = driver.findElement(By.xpath(pageXPath + "[" + i + "]"));
	                if (pageLink.isDisplayed() && pageLink.isEnabled()) {
	                    Allure.step("Navigating to Page: " + pageLink.getText());
	                    pageLink.click();
	                 WaitUtility.waitForPageLoad(driver, 6); 

	                    // Perform Action on Each Page
	                    actionOnEachPage.run();
	                }
	            } catch (Exception e) {
	                AllureListeners.captureScreenshot(driver, "Pagination_Error_Page_" + i);
	                Assert.fail("Pagination failed on Page: " + i);
	            }
	        }
	    } else {
	        Allure.step("No Pagination Found");
	    }
	}
	
	public static void setCompanyName(String name) {
	    if (name != null && !name.isEmpty()) {
	        companyName = name;
	        System.out.println("Company Name Set: " + companyName);
	    } else {
	        System.out.println(" Company Name is Empty or Null");
	    }
	}
}
 

	

