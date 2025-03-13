package Patrol.Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.Library;

public class Details_OfAddedFirm extends BasePage {
	
	public Details_OfAddedFirm(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div[3]/a")
	private WebElement ViewCompany;
	
	
	
	public void clickOnCauseList() {
		Library.click(driver, ViewCompany, "click on view company button");
	}
	
	public void checkingfirmname()
	{
		
		try {
		    driver.get("https://patrol.legitquest.com/company");

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    JavascriptExecutor js = (JavascriptExecutor) driver;

		    List<WebElement> firmLinks = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
		            By.xpath("//*[@id=\"tab1\"]/div[1]/table/tbody/tr/td[2]/a")));

		    for (int i = 0; i < firmLinks.size(); i++) {
		        try {
		            // Re-fetch the firmLinks to avoid stale elements
		            firmLinks = driver.findElements(By.xpath("//*[@id=\"tab1\"]/div[1]/table/tbody/tr/td[2]/a"));
		            WebElement firmLink = firmLinks.get(i);
		            String firmName = firmLink.getText();

		            // Scroll to element
		            js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", firmLink);
		            Thread.sleep(500); // Allow time for scrolling

		            // Click the element
		            firmLink.click();

		            // Wait for the next page to load and check for the company name
		            try {
		                WebElement companyNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(
		                		By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"))); 
                 // Replace with the correct selector

		                String displayedCompanyName = companyNameElement.getText();
		                if (displayedCompanyName.equals(firmName)) {
		                    System.out.println("Company name matches for: " + firmName);
		                } else {
		                    System.out.println("Mismatch for: " + firmName);
		                }
		            } catch (Exception innerException) {
		                System.out.println("Error while checking company name for: " + firmName);
		                System.out.println("Exception: " + innerException.getMessage());
		            }

		            // Navigate back
		            driver.navigate().back();

		            // Wait for the table to reload
		            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
		                    By.xpath("//*[@id=\"tab1\"]/div[1]/table/tbody/tr/td[2]/a")));
		        } catch (Exception e) {
		            System.out.println("Error for firm: " + firmLinks.get(i).getText());
		            System.out.println("Exception: " + e.getMessage());

		            // Navigate back to the main page if an error occurs
		            try {
		                driver.navigate().back();
		                // Wait for the table to reload
		                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
		                        By.xpath("//*[@id=\"tab1\"]/div[1]/table/tbody/tr/td[2]/a")));
		            } catch (Exception backNavigationException) {
		                System.out.println("Failed to navigate back: " + backNavigationException.getMessage());
		            }
		        }
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    driver.quit();
		}
		
		
		
		
		
		
		
		
    }
   }

	   
	   
	   
	   
   

