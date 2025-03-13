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
import org.testng.Assert;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;
import Patrol.Utility.UtilityClass;

public class CheckPaginationofInvoices extends BasePage{

	
	 List<String> errorUrls = new ArrayList<>();
	 String screenshotPath = null;
	public CheckPaginationofInvoices(WebDriver driver) {
		super(driver);
			
	}
	
	@FindBy (xpath = "(//span[text()='View All'])[6]")
	private WebElement INVOICES_VIEW_ALL;

	public void verifyInvoicePagination() throws IOException, MessagingException {
        try {
        	
        	 Library.click(driver, INVOICES_VIEW_ALL, "Clicked on invoices of dashboard page.");
				Library.threadSleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'pagination')]")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            List<WebElement> paginationLinks = driver.findElements(By.xpath("//*[@id=\"tab1\"]/nav/ul/li/a"));

            if (paginationLinks.size() > 0) {
                for (int i = 1; i <= 5; i++) {
                    try {
                        WebElement pageButton = driver.findElement(By.xpath("//a[text()='" + i + "']"));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pageButton);
                        Thread.sleep(2000);

                        List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
                        if (tableRows.isEmpty()) {
                        	AllureListeners.captureScreenshot(driver,"NoData_Page_" + i);
                            Assert.fail("Page " + i + " contains no data.");
                        } else {
                        	 Library.verifyText(driver, "Stack trace", "Error Found on Page: " + i);
                        }
                    } catch (Exception e) {
                        System.out.println("Error on page: " + i);
                    }
                }
            } else {
                System.out.println("No pagination links found.");
            }
        } catch(Exception e) {
            
        }
    }

 
    }
		  


