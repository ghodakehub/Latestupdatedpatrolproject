package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;
import Patrol.Utility.SwitchWindow;

public class DocumentPage extends BasePage {
	
	public DocumentPage(WebDriver driver) {
		super(driver);
				
	}

	@FindBy (xpath = "//*[@id=\"tab1-content\"]/div[1]/div[3]/div/div[2]/a/span")
	private WebElement DocumentViewAll;
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/a")
	private WebElement Newdocument;
	
	
	@FindBy (xpath = "//*[@id=\"basic-addon2\"]")
	private WebElement SelectMatter;
	
	
	@FindBy (id = "673b2b60a19f30a5c40fa892")
	private WebElement Selectcheckbox;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/div[1]/div[2]/input")
	private WebElement DocumentName;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/div[2]/div[1]/input")
	private WebElement DocumentDate;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/div[2]/div[2]/textarea")
	private WebElement DocumentDiscreption;
	
	@FindBy (xpath = "//input[@name='document']")
	private WebElement Documentfile;

	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[3]/button")
	private WebElement savebtn;

	public void VerifyDoc()
	{
	
			Library.click(driver,DocumentViewAll , "Clicked on document of dashboard page.");
			Library.threadSleep(1000);
			 
		
		}
	     public void ClickonNote()
	     {
	    	 Library.click(driver, Newdocument, "Clicked on Newdocument.");
	    	 Library.threadSleep(1000);
	    	 String parentwindowid = driver.getWindowHandle();
	    	 System.out.println(parentwindowid);
	    	 
	    	 JavascriptExecutor js1 = (JavascriptExecutor)driver;
	 		js1.executeScript("arguments[0].scrollIntoView(true);",SelectMatter );
	 		SelectMatter.click();
	 		
	 		SwitchWindow.switchWindowByIndex(driver, 1);
	 		Library.threadSleep(1000);
	 		
	 		
	 	 	WebElement selectCheckbox = driver.findElement(By.xpath("//*[@id=\"tab1\"]/div/table/tbody/tr[1]/td[1]/label/input"));
	 	 	selectCheckbox.click();
		
	 	 	Library.threadSleep(2000);
	 	 	
	    	SwitchWindow.switchWindowByIndex(driver, 0);
	 		Library.threadSleep(2000);
	 		
		
		WebElement docname = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[2]/div[1]/div[2]/input"));
		docname.sendKeys("TestDoc1");
	   
	   	Library.threadSleep(2000);
		
   	WebElement selectdate = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[2]/div[2]/div[1]/input"));
   	selectdate.sendKeys("02/08/2024");
   
  	 Library.threadSleep(2000);
		
  	WebElement documentdisc = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[2]/div[2]/div[2]/textarea"));
  	documentdisc.sendKeys("Testing document by automation");
  	Library.threadSleep(2000);
  	
  	Library.threadSleep(2000);
  	Documentfile.sendKeys("D:\\MyPatrolProject-main\\TestDataExelSheet\\Screenshot (196).png");
  	Library.threadSleep(3000);
		
  	savebtn.click();
  	Library.threadSleep(2000);
		
	}
	
	 		
	
	
	
	

}
