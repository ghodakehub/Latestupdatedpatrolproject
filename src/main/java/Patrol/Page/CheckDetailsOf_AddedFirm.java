package Patrol.Page;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;
import Patrol.Utility.UtilityClass;

public class CheckDetailsOf_AddedFirm extends BasePage {
	
	public CheckDetailsOf_AddedFirm(WebDriver driver) {
		super(driver);
	}
		
		@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div[3]/a")
		private WebElement ViewCompany;
		
		
		
		public void clickOnCauseList() {
			Library.click(driver, ViewCompany, "click on view company button");
		}

        	 
        	 public void verifyFirmsInTable() throws IOException, MessagingException 
        	 {
        		 for (int page = 1; page <= 2; page++) {
     	            System.out.println("Testing firms on page: " + page);

     	            // Get all firms on the current page
     	            List<WebElement> firmElements = driver.findElements(By.xpath("//*[@id=\"tab1\"]/div[1]/table/tbody/tr/td[2]/a")); 

     	            for (int i = 1; i <= firmElements.size(); i++) {
     	                try {
     	                    WebElement firm = driver.findElement(By.xpath("(//*[@id=\"tab1\"]/div[1]/table/tbody/tr/td[2]/a)[" + i + "]")); 
     	                    String firmName = firm.getText();
     	                    System.out.println("Clicking on firm: " + firmName);
     	                   JavascriptExecutor js = (JavascriptExecutor) driver;
     	                   js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", firm);
     			            Thread.sleep(500); 
     	                    firm.click();
     	                    Thread.sleep(1000);

     	                    // Check for errors
     	                   // Verify for Stack Trace Error
     	                   Library.verifyText(driver, "Stack trace", "Error throw while open this company");
     	                   Library.threadSleep(1000);

     	                    driver.navigate().back();
     	                    Thread.sleep(1000);
     	                } catch (Exception e) {
     	                	 AllureListeners.captureScreenshot(driver,"Error coming when check details of added firm");
     	                   
     	                }
     	            }

     	            // Click next page button
     	            try {
     	                WebElement nextPage = driver.findElement(By.xpath("//*[@id=\"tab1\"]/div[2]/div/nav/div[1]/a")); // Update with correct XPath
     	                if (nextPage.isDisplayed()) {
     	                    nextPage.click();
     	                   Library.verifyText(driver, "Stack trace", "Error coming when click on this page");
     	                    Thread.sleep(3000);
     	                }
     	            } catch (Exception e) {
     	                System.out.println("No more pages available.");
     	                break;
     	            }
     	        }
     	    }

     	
         }
	
	
	
	
	
	
	
	
	
	
	
	
	
	

