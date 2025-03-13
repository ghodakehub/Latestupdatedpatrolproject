package Patrol.Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class testaddcasepage extends BasePage {
	
	public testaddcasepage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/div[1]/div[1]/div/div[2]/a/span")
	private WebElement totalcase;
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[3]/div/nav/ul/li[3]/a")
	private WebElement page2;
	
	public void tste() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
            // Navigate to the main page
            driver.get("https://patrol.legitquest.com/cases");

            // Get total pages
            int totalPages = getTotalPages(driver, wait);

            // Iterate through each page
            for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
                System.out.println("Processing Page: " + currentPage);

                if (currentPage > 1) {
             
                     Thread.sleep(2000);
                    navigateToPage(driver, wait, currentPage);
                }

                // Find all case links on the current page
                List<WebElement> caseLinks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//*[@id=\"tableBody\"]/tr/td/a"))); // Adjust XPath //*[@id="tableBody"]/tr/td/a

                // Check each case link
                for (int i = 0; i < caseLinks.size(); i++) {
                    WebElement caseLink = caseLinks.get(i);
                    String caseName = caseLink.getText();
                    
                    String caseUrl = caseLink.getAttribute("href");

                    try {
                        System.out.println("Opening case: " + caseName);
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("arguments[0].click();", caseLink);
                       // caseLink.click();
                        
                        // Wait for the page to load
                        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

                        // Check for error indicators
                        try {
                            WebElement caseDetails = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1[text()='Cases Detail']")); // Update XPath for "Case Details" text
                            if (caseDetails.isDisplayed()) {
                            	  Thread.sleep(3000);

                                System.out.println(caseName + ": Case details page loaded successfully");
                                
                               
                            }
                        } catch (NoSuchElementException e) {
                        	 Thread.sleep(2000);

                            System.out.println(caseName + ": Error occurred. Case details not displayed");
                           
                        }

                        // Navigate back to the main page
                        driver.navigate().back();
                        Thread.sleep(2000);

                        // Refresh the case links list
                        caseLinks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                                By.xpath("//*[@id=\"tableBody\"]/tr/td/a")));

                    } catch (Exception e) {
                       
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

   

    /**
     * Get total number of pages in pagination.
     * @throws InterruptedException 
     */
    private static int getTotalPages(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        List<WebElement> paginationButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//ul[contains(@class, 'pagination')]//li/a")));
        Thread.sleep(5000);
        return paginationButtons.size();
    }

    /**
     * Navigate to a specific page using pagination.
     */
    private static void navigateToPage(WebDriver driver, WebDriverWait wait, int pageNumber) {
        WebElement pageButton = wait.until(ExpectedConditions.elementToBeClickable(
        		
        		
                By.xpath("//ul[contains(@class, 'pagination')]//li/a[text()='" + pageNumber + "']")));
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pageButton);
      //  pageButton.click();

        // Wait for the page content to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='casesTable']")));
    }

	
	}
	



