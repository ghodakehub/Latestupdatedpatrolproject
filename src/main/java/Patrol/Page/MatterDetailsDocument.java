package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;
import Patrol.Utility.SwitchWindow;

public class MatterDetailsDocument extends BasePage{

		public MatterDetailsDocument(WebDriver driver) {
			super(driver);
					
		}

		@FindBy (xpath = "(//span[@class='me-2'])[4]")
		private WebElement MATTERS_VIEW_ALL;
		
		
		@FindBy (xpath = "//*[@id=\"tab1\"]/div/table/tbody/tr[1]/td[2]/p/a")
		private WebElement ClickOnFirstMatter;
		
		
		@FindBy (xpath = "//*[@id=\"nav-tab\"]/button[3]")
		private WebElement document;
		
		@FindBy (xpath ="//*[@id=\"tab3-3\"]/div[1]/a")
		private WebElement createdoc;
		
		
		@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/div[1]/div[2]/input")
		private WebElement DcoName;
		
		
		@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/div[2]/div[1]/input")
		private WebElement duedate;
		
		@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/div[2]/div[2]/textarea")
		private WebElement docdiscreption;
		
		
		@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/div[1]/div[3]/input")
		private WebElement selectdoc;

		
		@FindBy (xpath = "//*[@id=\"addForm\"]/div[3]/button[1]")
		private WebElement savebtn;                                                                   
		
	
		
		public void clickOnMatterViewAll() {
			Library.click(driver, MATTERS_VIEW_ALL, "Clicked on matters of dashboard page.");
			Library.threadSleep(1000);
			 Library.click(driver, ClickOnFirstMatter, "Clicked on matter first .");
		
		}
	     public void Clickondoc() throws InterruptedException
	     {
	    	 Library.click(driver,document , "Clicked on document.");
	    	 Library.threadSleep(1000);
	    	 
	    	 JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 		js1.executeScript("arguments[0].scrollIntoView(true);",createdoc );
	 		createdoc.click();
	 		
	 		SwitchWindow.switchWindowByIndex(driver, 1);
			Thread.sleep(3000);
			
	    	WebElement docname = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[2]/div[1]/div[2]/input"));
	    	docname.sendKeys("Newdoc1");
	    	
	    	Library.threadSleep(2000);
	    	WebElement duedate1 = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[2]/div[2]/div[1]/input"));
	    	duedate1.sendKeys("2/11/2024");
	    	 
	    	Library.threadSleep(2000);
	    	
	    	docdiscreption.sendKeys("testing document on matter details page");
	    	
	    	Library.threadSleep(1000);
	    	selectdoc.sendKeys("D:\\MyPatrolProject-main\\TestDataExelSheet\\Screenshot (196).png");
	    	
	    	Library.threadSleep(2000);
	    	savebtn.click();
	    	Library.threadSleep(2000);
				//driver.switchTo().window(parentwindowid);
				
	    	
	 		
	    	}
	    	
}
