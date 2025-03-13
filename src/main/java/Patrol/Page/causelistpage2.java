package Patrol.Page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentTest;
import Patrol.Utility.Library;

public class causelistpage2 extends BasePage {
	
	public causelistpage2(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//*[@id=\"accordionSidebar\"]/div[3]/li[4]/a/span")
	private WebElement MY_CAUSE_LIST;
	
	@FindBy (xpath = "(//h3[@class='fs-20 fw-bold text-dark mb-0'])[1]")
	private WebElement DAILY_TABLE_HEADING;
	
	@FindBy (xpath = "//table//tr//th")
	private WebElement TABLES;
	
	
	public void clickOnCauseList() {
		
		try {
		Library.click(driver, MY_CAUSE_LIST, "Clicked on 'My Cause List' successfully.");
		Library.threadSleep(5000);
		
		
		
		
		 String pageTitle = driver.getTitle();
         System.out.println("Page Title: " + pageTitle);
  
        
        List<WebElement> listOfBusinessSections = driver.findElements(By.xpath("//*[@id=\"tab1\"]/div/div/div")); 

        
        for (WebElement section : listOfBusinessSections) {
            
            String courtName = section.findElement(By.xpath("//span[@class='fw-semibold']")).getText(); 

             
             List<WebElement> rows = section.findElements(By.xpath(".//table/tbody/tr")); 

             
             
             
         
             
             // Check if the "List of Business" is blank
             if (rows.isEmpty()) {
                 System.out.println("Blank List of Business for Court: " + courtName);
                 
             } else {
                System.out.println("List of Business for Court: " + courtName);
               
                for (WebElement row : rows) {
                     System.out.println(row.getText());
                 }
            }
         }
     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         // Close the browser
         driver.quit();
     }
 }
 }
     


