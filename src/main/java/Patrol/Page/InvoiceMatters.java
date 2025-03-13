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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;
import Patrol.Utility.UtilityClass;

public class InvoiceMatters extends BasePage{

	List<String> errorUrls = new ArrayList<>();
    String screenshotPath = null;
	public InvoiceMatters(WebDriver driver) {
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

		        WebElement matterTab = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[3]/div/nav/a[2]"));
		        matterTab.click();
		        Library.threadSleep(2000);

		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"matterTabData\"]/table/tbody/tr/td")));

		        List<WebElement> matterLinks = driver.findElements(By.xpath("//*[@id=\"matterTabData\"]/table/tbody/tr/td/a"));
		        System.out.println("Total Matters found: " + matterLinks.size());

		        for (int i = 0; i < matterLinks.size(); i++) {
		            try {
		                // Re-fetch the Matter Links to avoid StaleElementReferenceException
		                List<WebElement> updatedMatterLinks = driver.findElements(By.xpath("//*[@id=\"matterTabData\"]/table/tbody/tr/td/a"));
		                WebElement matter = updatedMatterLinks.get(i);

		                js.executeScript("arguments[0].scrollIntoView(true);", matter);
		                js.executeScript("window.scrollBy(0, -100);");
		                Library.threadSleep(1000);

		                Actions actions = new Actions(driver);
		                actions.moveToElement(matter).click().perform();

		                Library.threadSleep(2000);

		                // Verify Stack trace error
		                verifyStackTraceError();

		                driver.navigate().back();  // Go back to previous page
		                Library.threadSleep(2000);

		                // Click on Matter Tab Again
		                matterTab = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[3]/div/nav/a[2]"));
		                js.executeScript("arguments[0].scrollIntoView(true);", matterTab);
		                js.executeScript("window.scrollBy(0, -200);");
		                matterTab.click();
		                Library.threadSleep(2000);
		                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"matterTabData\"]/table/tbody/tr/td/a")));

		            } catch (Exception e) {
		                System.out.println("Error while clicking on Matter " + (i + 1) );
		                AllureListeners.captureScreenshot(driver, "Error on page this"+ (i + 1));
		            }
		        }
		   

	    } finally {
	        sendSummaryEmail();
	    }
	}

	private void verifyStackTraceError() throws IOException {
	    try {
	        WebElement errorElement = driver.findElement(By.xpath("//button[contains(text(), 'Stack trace')]"));
	        if (errorElement.isDisplayed()) {
	            String url = driver.getCurrentUrl();
	            errorUrls.add(url);
	            System.out.println("Error found on: " + url);

	            // Capture only one screenshot for the first error
	            if (screenshotPath == null) {
	                screenshotPath = UtilityClass.Capaturescreenshot(driver, "MatterError");
	            }
	        }
	    } catch (NoSuchElementException e) {
	        // No error found
	    }
	}

	private void sendSummaryEmail() throws MessagingException {
	    if (!errorUrls.isEmpty()) {
	        StringBuilder emailBody = new StringBuilder("Invoice Matters Errors:\n\n");
	        for (String url : errorUrls) {
	            emailBody.append(url).append("\n");
	        }

	        Patrol.Utility.ForMultiplemailReceipent.sendEmail(
	                driver,
	                new String[]{"ghodake6896@gmail.com"},
	                "Invoice Matters Error Report",
	                emailBody.toString(),
	                screenshotPath,
	                null);
	        System.out.println("Email Sent with Error Details!");
	    } else {
	        System.out.println("No Errors Found.");
	    }
	}
}


