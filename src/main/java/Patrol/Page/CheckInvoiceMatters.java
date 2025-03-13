package Patrol.Page;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;
import Patrol.Utility.UtilityClass;

public class CheckInvoiceMatters extends BasePage{

	List<String> errorUrls = new ArrayList<>();
    String screenshotPath = null;
	public CheckInvoiceMatters(WebDriver driver) {
		super(driver);
			
	}
	
	@FindBy (xpath = "(//span[text()='View All'])[6]")
	private WebElement INVOICES_VIEW_ALL;
	
	public void verifyInvoiceMatters() throws IOException, MessagingException, InterruptedException {
	    try {
	        Library.click(driver, INVOICES_VIEW_ALL, "Clicked on invoices of dashboard page.");
	        Library.threadSleep(2000);

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, 400)");
	        Library.threadSleep(2000);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='invoiceTable']/tbody/tr")));

	        List<WebElement> pagination = driver.findElements(By.xpath("//li[@class='page-item']/a"));
	        System.out.println("Total Pages Found: " + pagination.size());

	        for (int p = 0; p < pagination.size(); p++) {
	            System.out.println("Checking Matters on Page: " + (p + 1));

	           

	        
	            List<WebElement> matterLinks = driver.findElements(By.xpath("//*[@id='invoiceTable']/tbody/tr/td[4]/a"));
	            System.out.println("Total Matters found on Page " + (p + 1) + ": " + matterLinks.size());

	            for (int i = 0; i < matterLinks.size(); i++) {
	                try {
	                    // Re-fetch matter links every time to avoid StaleElementReferenceException
	                    matterLinks = driver.findElements(By.xpath("//*[@id='invoiceTable']/tbody/tr/td[4]/a"));
	                    WebElement matter = matterLinks.get(i);
	                    js.executeScript("arguments[0].click();", matter);
	                    Library.threadSleep(2000);

	                    // Verify for Stack Trace Error
	                    Library.verifyText(driver, "Stack trace", "Error coming in invoice for this matters " + i);
	                    Library.threadSleep(2000);

 
	                    driver.navigate().back();
	                    Library.threadSleep(2000);
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='invoiceTable']/tbody/tr")));

	                } catch (Exception e) {
	                	System.out.println("Error while clicking on Matter in Row " + (i + 1) + " on Page " + (p + 1));
	  
	                    AllureListeners.captureScreenshot(driver, "Error_Page_" + (i + 1) + "_Row_" + (i + 1));
	                 
	                }
	            }
	        
	            // Move to the next page if available
	            if (p < pagination.size() - 1) {
	                pagination = driver.findElements(By.xpath("//li[@class='page-item']/a")); // Refresh Pagination List
	                if (pagination.size() > p + 1) { // Check if index exists
	                    WebElement nextPage = pagination.get(p + 1);
	                   // JavascriptExecutor js3 = (JavascriptExecutor) driver;
	                    js.executeScript("arguments[0].scrollIntoView(true);", nextPage);
	                    Library.threadSleep(1000);

	                    if (nextPage.isDisplayed() && nextPage.isEnabled()) {
	                        js.executeScript("arguments[0].click();", nextPage);
	                        Library.threadSleep(3000);
	                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='invoiceTable']/tbody/tr")));
	                    } else {
	                        System.out.println("Next Page Button is not Clickable");
	                    }
	                } else {
	                    System.out.println("No More Pages Available");
	                }
	            }
	    } 
	  	}finally {
	  		//syso
	  	}
	}
}


