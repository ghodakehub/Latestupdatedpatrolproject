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

public class MatterDetailsPage extends BasePage{
	
	public MatterDetailsPage(WebDriver driver) {
		super(driver);	
	}

	@FindBy (xpath = "(//span[@class='me-2'])[4]")
	private WebElement MATTERS_VIEW_ALL;
	
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/div/table/tbody/tr[1]/td[2]/p/a")
	private WebElement ClickOnFirstMatter;
	
	
	@FindBy (xpath = "//*[@id=\"nav-tab\"]/button[2]")
	private WebElement Task;
	
	@FindBy (xpath ="//*[@id=\"tab1-task\"]/div[1]/button")
	private WebElement createTask;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[1]/div/div[1]/div/input")
	private WebElement TaskName;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[1]/div/div[3]/div/input")
	private WebElement duedate;
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[1]/div/div[4]/div/select")
	private WebElement selectstatus;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[1]/div/div[5]/div/input")
	private WebElement taskdescription;

	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[1]/div/div[6]/span/span[1]/span/span")
	private WebElement selectassignuser1;                                                                   
	
	@FindBy (id = "priority3")
	private WebElement highpriority;
	
	@FindBy (id = "priority2")
	private WebElement lowpriority;
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/button[2]")
	private WebElement savechanges;
	
	public void clickOnMatterViewAll() {
		Library.click(driver, MATTERS_VIEW_ALL, "Clicked on matters of dashboard page.");
		Library.threadSleep(1000);
		 Library.click(driver, ClickOnFirstMatter, "Clicked on matter first .");
	
	}
     public void ClickonTask(String assignuser ,String status)
     {
    	 Library.click(driver, Task, "Clicked on task.");
    	 Library.threadSleep(1000);
    	 String parentwindowid = driver.getWindowHandle();
    	 System.out.println(parentwindowid);
    	 
    	 JavascriptExecutor js1 = (JavascriptExecutor)driver;
 		js1.executeScript("arguments[0].scrollIntoView(true);",createTask );
 		createTask.click();
 		
 		Set<String> allwindows = driver.getWindowHandles();
 		for(String childwin:allwindows)
 		{
    	if(childwin.equalsIgnoreCase(parentwindowid))
    	{
    		driver.switchTo().window(childwin);
    		 Library.threadSleep(2000);
    	WebElement TaskName1 = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[1]/div/div[1]/div/input"));
    	TaskName1.sendKeys("NewTask");
    	
    	Library.threadSleep(2000);
    	WebElement duedate1 = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[1]/div/div[3]/div/input"));
    	duedate1.sendKeys("20/11/2024");
    	 
    	Library.threadSleep(2000);
    	
    	
    	Library.selectDropDown(selectstatus,status);
		System.out.println("Selected Status is: "+status);
		Library.threadSleep(2000);
		
    	WebElement discreption = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[1]/div/div[5]/div/input"));
    	discreption.sendKeys("testing task on matter details page");
    	
    	Library.threadSleep(2000);
    	
    	WebElement selectassignuser = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[1]/div/div[6]/span/span[1]/span"));
    	selectassignuser.click();
    	selectassignuser.sendKeys(assignuser);
        selectassignuser.sendKeys(Keys.ARROW_DOWN);
		selectassignuser.sendKeys(Keys.ENTER);
		Library.threadSleep(2000);
 		Library.click(driver, highpriority, "Clicked on high priority radio button.");
 		
			Library.threadSleep(2000);
			Library.click(driver, savechanges, "Clicked on savchanges button.");
			Library.threadSleep(2000);
			driver.switchTo().window(parentwindowid);
			
    	}
 		}
    	}
    	

			
 		
    	
     
     }
     

 

