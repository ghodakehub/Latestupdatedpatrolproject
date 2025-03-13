package Patrol.Page;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.qameta.allure.Allure;

public class Addcasepage extends BasePage {
	
	public Addcasepage(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath = "//*[@id=\"tab1\"]/div[1]/div[1]/div/div[2]/a/span")
	private WebElement totalcase;
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[3]/div/nav/ul/li[3]/a")
	private WebElement page2;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 public void brokenLink() throws MalformedURLException 
	 { 
		 
		 try {
	            
	                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	                // Find all case links on the current page
	                List<WebElement> caseLinks = driver.findElements((
	                        By.xpath("//table//a[contains(@href, 'case')]"))); // Adjust XPath //*[@id="tableBody"]/tr/td/a

	                // Check each case link
	                for (int i = 0; i < caseLinks.size(); i++) {
	                	driver.findElements((
		                        By.xpath("//table//a[contains(@href, 'case')]")));
	                    WebElement caseLink = caseLinks.get(i);
	                    String caseName = caseLink.getText();
	                  //  String caseUrl = caseLink.getAttribute("href");
	                    Allure.step("Opening case: " + caseName);
	                    String caseUrl = caseLink.getAttribute("href");

	                    try {
	                    	driver.findElements((
	    	                        By.xpath("//table//a[contains(@href, 'case')]")));
	                        System.out.println("Opening case: " + caseName);
	                        JavascriptExecutor js = (JavascriptExecutor) driver;
	                        js.executeScript("arguments[0].click();", caseLink);
	                       // caseLink.click();

	                        // Wait for the page to load
	                        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

	                       

	                        // Check for any error elements
	                        boolean isError = driver.findElements(By.cssSelector(".ErrorException")).size() > 0; // Replace with the actual error selector
	                        if (isError) {
	                            System.out.println("Error detected for case: " + caseName + " URL: " + caseUrl);
	                           // Thread.sleep(1000);
	                        }

	                        // Navigate back to the main page
	                        driver.navigate().back();
	                        Thread.sleep(1000);
	                        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	                                By.xpath("//table//a[contains(@href, 'case')]")));

	                    } catch (Exception e) {
	                        System.out.println("Exception while processing case: " + e.getMessage());
	                    }
	                }

		 }finally {
			 
		 }
	 }
}    
	
     
	 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

 
		
		 
		 
		 
		 
		 
		 
		 
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	    
		 
		 
		 
		 

		 
	 
	 
	  
		 
		 
		 
		 
	            	 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 
	                        
	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        	
	                        
		 
		 
		 
		 
		 
	            
		 
	            

		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		  
		 
		 
	 

	 
	
	
	

