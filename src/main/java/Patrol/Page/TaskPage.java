package Patrol.Page;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;
import Patrol.Utility.SwitchWindow;

public class TaskPage extends BasePage{

	
	public TaskPage(WebDriver driver) {
		super(driver);
			
	}

	@FindBy (xpath = "//*[@id=\"tab1-content\"]/div[1]/div[5]/div/div[2]/a/span")
	private WebElement TASK_VIEW_ALL;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/div/nav/a[2]")
	private WebElement completedtab;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/div/nav/a[3]")
	private WebElement cancled;
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/div/nav/a[1]")
	private WebElement upcoming;
	
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/nav/a[2]")                   
	private WebElement duethisweek;
	
	
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/nav/a[3]")
	private WebElement duetomarrow;
	
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/nav/a[1]")
	private WebElement All;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/div/button")
	private WebElement addtask;
	
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/div/table/tbody/tr[1]/td[1]/label/input")                   
	private WebElement selectcheckbox;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[1]/div/div[4]/div/select")                   
	private WebElement selectstatus;
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[1]/div/div[5]/div/input")                   
	private WebElement discreption;
	
	@FindBy (xpath = "//*[@id=\"priority2\"]")                   
	private WebElement radiolowprioritybtn;
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/button[2]")                   
	private WebElement savechangesbtn;
	
	public void clickOnTaskViewAll(String status) {
		Library.click(driver, TASK_VIEW_ALL, "Clicked on TASK of dashboard page.");
		Library.threadSleep(2000);
		
		 Library.click(driver,completedtab , "Clicked on completedtab .");
		 Library.threadSleep(2000);
		 
		 Library.click(driver,cancled , "Clicked on cancled .");
		 Library.threadSleep(2000);
		 
		 
		 
		 Library.click(driver,upcoming , "Clicked on upcoming .");
		 Library.threadSleep(2000);
		 
		 Library.click(driver,duethisweek , "Clicked on duethisweek .");
		 Library.threadSleep(2000);
		 
		 
		 Library.click(driver, duetomarrow, "Clicked on duetomarrow .");
		 Library.threadSleep(2000);
		 
		 Library.click(driver,All , "Clicked on All .");
		 Library.threadSleep(2000);
		 
		// Library.click(driver,addtask , "Clicked on createnewtask .");
		// Library.threadSleep(2000);
	
		 
		 
		 
		 String parentwindowid = driver.getWindowHandle();
    	 System.out.println(parentwindowid);
    	 
    	 JavascriptExecutor js1 = (JavascriptExecutor)driver;
 		js1.executeScript("arguments[0].scrollIntoView(true);",addtask );
 		addtask.click();
 		
 		Set<String> allwindows = driver.getWindowHandles();
 		for(String childwin:allwindows)
 		{
    	if(childwin.equalsIgnoreCase(parentwindowid))
    	{
    		driver.switchTo().window(childwin);
    		 Library.threadSleep(2000);
    	WebElement EntertaskName = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[1]/div/div[1]/div/input"));
    	EntertaskName.sendKeys("NewAutomationtask");
    	Library.threadSleep(2000);
    	
    	WebElement EnterNoteName = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[1]/div/div[3]/div/input"));
    	EnterNoteName.sendKeys("20/11/2024");
    	
    	Library.threadSleep(2000);
    	
    	WebElement selectmatter = driver.findElement(By.xpath("//*[@id=\"basic-addon2\"]"));
    	selectmatter.click();
    	
    	Library.threadSleep(2000);
    	
    	
    	SwitchWindow.switchWindowByIndex(driver, 1);
    	Library.threadSleep(2000);
		
    	
    	
    	 JavascriptExecutor js2 = (JavascriptExecutor)driver;
  		js2.executeScript("arguments[0].scrollIntoView(true);",selectcheckbox );
  		selectcheckbox.click();
		
		Library.threadSleep(2000); 
		
		SwitchWindow.switchWindowByIndex(driver, 0);
    	Library.threadSleep(2000);
    	
    	
    	Library.selectDropDown(selectstatus,status);
		System.out.println("Selected Status is: "+status);
		Library.threadSleep(2000);
		
    	WebElement discreption = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[1]/div/div[5]/div/input"));
    	discreption.sendKeys("testing task on matter details page");
    	
    	Library.threadSleep(2000);
    
 		Library.click(driver,radiolowprioritybtn , "Clicked on low priority radio button.");
 		
			Library.threadSleep(2000);
			Library.click(driver,savechangesbtn , "Clicked on savchanges button.");
			Library.threadSleep(2000);
			driver.switchTo().window(parentwindowid);
		
			Library.threadSleep(2000);
    	}
 		}
	}
    
}
