package Patrol.Page;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class testcasuselsit extends BasePage {
	
	public testcasuselsit(WebDriver driver) {
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
		Library.threadSleep(2000);
	             
      
       

        boolean isError = false;

        // Check if any business list is empty
      
        
        List<WebElement> rows = driver.findElements(By.xpath("//h3[@class='fs-20 fw-bold text-dark mb-0']")); 
        	
        	

             
             for (WebElement section : rows) {
          

             
           //List<WebElement> rows = section.findElements(By.xpath(".//table/tbody/tr")); 

            WebElement courtNo = section.findElement(By.xpath("//*[@id=\"tab1\"]/div/div[1]/div/table/tbody/tr[1]/td[1]"));
            WebElement itemNo = section.findElement(By.xpath("//*[@id=\"tab1\"]/div/div[1]/div//table/tbody/tr[1]/td[2]"));
            WebElement causeTitle = section.findElement(By.xpath("//*[@id=\"tab1\"]/div/div[1]/div//table/tbody/tr[1]/td[3]"));

            if (courtNo.getText().isEmpty() || itemNo.getText().isEmpty() || causeTitle.getText().isEmpty()) {
                isError = true;
               
                System.out.println ("Error in business data: Court No: " + courtNo.getText() +
                        ", Item No: " + itemNo.getText() + ", Cause Title: " + causeTitle.getText());
            }
        }

        if (!isError) {
        	System.out.println("All business data is displayed correctly.");
        }

    } catch (Exception e) {
    	System.out.println("Test failed with exception: " + e.getMessage());
    } finally {
        // Close the browser
        driver.quit();

        // Generate the report
       // extent.flush();
    }
	}
}
