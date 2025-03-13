package Patrol.Page;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class Matters_CheckAllMatters extends BasePage{
	
	 List<String> errorUrls = new ArrayList<>(); // Collect Failed URLs
	    String screenshotPath;
	    
	public Matters_CheckAllMatters(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy (xpath = "(//span[@class='me-2'])[4]")
	private WebElement MATTERS_VIEW_ALL;
	
	public void verifyMatters() throws IOException, MessagingException, InterruptedException {
	    try {
	        Library.click(driver, MATTERS_VIEW_ALL, "Clicked on matters of dashboard page.");
	        Library.threadSleep(2000);

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

	        while (true) {
	            List<WebElement> matterLinks = driver.findElements(By.xpath("//*[@id=\"tab1\"]/div/table/tbody/tr/td[2]/p/a"));
	            System.out.println("Total Matters found on this page: " + matterLinks.size());

	            for (int i = 0; i < matterLinks.size(); i++) {
	                try {
	                    List<WebElement> refreshedMatters = driver.findElements(By.xpath("//*[@id=\"tab1\"]/div/table/tbody/tr/td[2]/p/a"));
	                    WebElement matter = refreshedMatters.get(i);
	                   // js.executeScript("arguments[0].scrollIntoView(true);", matter);
	                    js.executeScript("arguments[0].click();", matter);

	                    Library.threadSleep(2000);
	                    if (Library.verifyText2(driver, "Stack trace", "Error on Matter page")) {
	                        System.out.println("Stack trace error found on Matter " + (i + 1));
	                        errorUrls.add(driver.getCurrentUrl());
	                        AllureListeners.captureScreenshot(driver, "Error on Matter " + (i + 1));
	                    }
	                    Library.threadSleep(2000);

	                    driver.navigate().back();
	                    Library.threadSleep(2000);

	                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tab1\"]/div/table/tbody/tr/td[2]/p/a")));
	                } catch (Exception e) {
	                    System.out.println("Error while clicking on Matter " + (i + 1));
	                }
	            }

	            try {
	                WebElement nextPage = driver.findElement(By.xpath("//a[contains(@aria-label,'Next')]"));
	                if (nextPage.isDisplayed()) {
	                    js.executeScript("arguments[0].click();", nextPage);
	                    Library.threadSleep(2000);
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tab1\"]/div/table/tbody/tr/td[2]/p/a")));
	                } else {
	                    System.out.println("No more pages available");
	                    break;
	                }
	            } catch (Exception e) {
	                System.out.println("Pagination Error: No next page found.");
	                break;
	            }
	        }
	    } finally {
	        // Email and summary report logic here
	    }
	}
	}

