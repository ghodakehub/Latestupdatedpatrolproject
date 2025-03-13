package Patrol.Page;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;

public class ReportsCheck extends BasePage {
	

	public ReportsCheck (WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath = "//*[@id=\"accordionSidebar\"]/div[3]/li[3]/a/span")
	private WebElement Reports;
	
	
	@FindBy (xpath = "//a[@class='nav-link py-3   ']")
	private WebElement NOTIFICATION_BAR;
	
	
	public void ClickOnReports() {
		
		 Library.threadSleep(3000);
		  
		    WebElement Reports  = driver.findElement(By.xpath("//*[@id=\"accordionSidebar\"]/div[3]/li[3]/a/span"));
		   // notification.click();
		    
		    JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 		js1.executeScript("arguments[0].scrollIntoView(true);",Reports );
	 		Reports.click();
	 
		     Library.threadSleep(2000);
	}
	
	public void VerifyAllReports() throws MessagingException, IOException {
	List<WebElement> barElements= driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div/div/a"));
	barElements.size();
		for (int i=1; i<=barElements.size();i++) {
			Library.threadSleep(1000);
			WebElement bar = driver.findElement(By.xpath("(//*[@id='content']/div/div[2]/div/div/div/div/a)[" + i + "]"));
			String text=bar.getText();
			System.out.println("Reports" +text);
			bar.click();
            System.out.println("Succesfully clicked on "+text);	
			Library.implicitWait(driver, 20);
			
			Library.verifyText(driver, "Stack trace", "ERROR ON Reports");
			Library.threadSleep(2000);
			driver.navigate().back();
			Library.threadSleep(2000);
		}
	}
	

}
