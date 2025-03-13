package Patrol.Page;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;
import Patrol.Utility.SwitchWindow;

public class CaseDetails_TaskTab extends BasePage {

	public CaseDetails_TaskTab (WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//*[@id=\"tab1\"]/div/table/tbody/tr[1]/td[1]/label/input")                   
	private WebElement selectcheckbox;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[1]/div/div[4]/div/select")                   
	private WebElement selectstatus;
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[1]/div/div[5]/div/input")                   
	private WebElement discreption;
	
	@FindBy (xpath = "(//*[@id=\"priority3\"])[1]")                   
	private WebElement radiolowprioritybtn;
	
	@FindBy (xpath = "(//*[@id=\"addForm\"]/div[2]/button[2])[1]")                   
	private WebElement savechangesbtn;
	
	public void createtask(String tabName,String status) throws InterruptedException
	{
		 String parentwindowid = driver.getWindowHandle();
    	 System.out.println(parentwindowid);
    	 
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(
 	            By.xpath("//a[contains(@class,'nav-link') and contains(text(),'" + tabName + "')]")));
 	    tab.click();
 	    Thread.sleep(2000);
     WebElement createButton = driver.findElement(By.xpath("//*[@id=\"tab1-task\"]/div/div[1]/button"));
     createButton.click();
     Thread.sleep(3000);
 		
 		Set<String> allwindows = driver.getWindowHandles();
 		for(String childwin:allwindows)
 		{
    	if(childwin.equalsIgnoreCase(parentwindowid))
    	{
    		driver.switchTo().window(childwin);
    		 Library.threadSleep(2000);
    	WebElement EntertaskName = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[1]/div/div[1]/div/input"));
    	EntertaskName.sendKeys("CreateTaskByAutomation");
    	Library.threadSleep(2000);
    	
    	WebElement date = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[1]/div/div[3]/div/input"));
    	date.sendKeys("03/05/2025");
    	
    	Library.threadSleep(2000);
    
    	Library.selectDropDown(selectstatus,status);
		System.out.println("Selected Status is: "+status);
		Library.threadSleep(2000);
		
    	WebElement discreption = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[1]/div/div[5]/div/input"));
    	discreption.sendKeys("testing task on matter details page");
    	Library.threadSleep(2000);
		
          
    	
        Actions actions= new Actions(driver);
        WebElement assignUserInput = driver.findElement(By.xpath("(//*[@id='addForm']/div[1]/div/div[6]/span/span[1]/span/span)[1]"));
        assignUserInput.click();
        Thread.sleep(1000); 
        actions.sendKeys(Keys.ARROW_DOWN).perform(); 
        Thread.sleep(500); // Small delay
        actions.sendKeys(Keys.ENTER).perform(); 

    
 		Library.click(driver,radiolowprioritybtn , "Clicked on low priority radio button.");
 		
			Library.threadSleep(2000);
			Library.click(driver,savechangesbtn , "Clicked on savchanges button.");
			Library.threadSleep(2000);
			driver.switchTo().window(parentwindowid);
		
			Library.threadSleep(2000);
    	}
 		}
	}
	public boolean verifytask(String taskname) {
		
		WebElement tasktab = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div/nav/a[3]"));
		tasktab.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
    WebElement cratedtask = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[@id=\"tab1-task\"]/div/div[3]/table/tbody/tr/td[1]")));

    if (cratedtask.isDisplayed()) {
        System.out.println("Task created successfully and is visible.");
        return true;
    }
 else 
 {
    System.out.println("Failed to create and verify task!");
    AllureListeners.captureScreenshot(driver, "Taskfailed.png");
    return false;
}




	}
	}

