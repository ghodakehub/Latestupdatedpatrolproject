package Patrol.Page;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.UtilityClass;

public class addActiveFrim extends BasePage {

	public addActiveFrim (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"dashboardTitle\"]/text()")
	private WebElement dasbhoard;
	


	public void checkCompany() throws InterruptedException {
		
		 for (int page = 1; page <= 2; page++) {
	            System.out.println("Testing firms on page: " + page);

	            // Get all firms on the current page
	            List<WebElement> firmElements = driver.findElements(By.xpath("//*[@id=\"companyList\"]/div[1]/div/div/a")); 

	            for (int i = 1; i <= firmElements.size(); i++) {
	                try {
	                    WebElement firm = driver.findElement(By.xpath("(//*[@id=\"companyList\"]/div[1]/div/div/a)[" + i + "]")); 
	                    String firmName = firm.getText();
	                    System.out.println("Clicking on firm: " + firmName);
	                    firm.click();
	                    Thread.sleep(2000);

	                    // Check for errors
	                    verifyTextOnPage(driver, "Stack trace");

	                    driver.navigate().back();
	                    Thread.sleep(2000);
	                } catch (Exception e) {
	                	 AllureListeners.captureScreenshot(driver,"Error comin in added firm");
	                	 System.out.println("screenshot attached in allure");
	                }
	            }

	            // Click next page button
	            try {
	                WebElement nextPage = driver.findElement(By.xpath("//*[@id=\"companyList\"]/div[2]/nav/ul/li[3]/a")); // Update with correct XPath
	                if (nextPage.isDisplayed()) {
	                    nextPage.click();
	                    Thread.sleep(3000);
	                }
	            } catch (Exception e) {
	                System.out.println("No more pages available.");
	                break;
	            }
	        }
	    }

	    private static void verifyTextOnPage(WebDriver driver, String searchText) throws IOException, MessagingException {
	        try {
	            WebElement errorElement = driver.findElement(By.xpath("//button[contains(text(), 'Stack trace')]"));
	            if (errorElement.isDisplayed()) {
	                System.out.println("Error coming on above Company");
	                String screenshotPath = UtilityClass.Capaturescreenshot(driver, "Error_Screenshot");
	               
	    			String testUrl = driver.getCurrentUrl();  
	   			 Patrol.Utility.ForMultiplemailReceipent.sendEmail(
	   	            	   driver, new String[]{"ghodake6896@gmail.com"},
	   	            	    "Patrol- AddCompany ",
	   	            	    "Please check issue coming while click on Comapny please check below urlLink, please find the attached screenshot for details." ,
	   	            	 screenshotPath,testUrl
	   	            	   
	   	            	);

	    			return;
	                
	            }
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	            return;
	        }
	    }
    }
	          


