package Patrol.Page;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;
import io.qameta.allure.Allure;

public class CreateNote_Casedetail extends BasePage {

	public CreateNote_Casedetail (WebDriver driver) {
		super(driver);
	}


	public void createNote(String tabName) throws InterruptedException
	{
		
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(
 	            By.xpath("//a[contains(@class,'nav-link') and contains(text(),'" + tabName + "')]")));
 	    tab.click();
 	    Thread.sleep(2000);
    
    	 String parentwindowid = driver.getWindowHandle();
    	 System.out.println(parentwindowid);
    	 
    	 WebElement createButton = driver.findElement(By.xpath("//*[@id=\"tab1-notes\"]/div/div[1]/button"));
         createButton.click();
         Thread.sleep(3000);
     
   
 		Set<String> allwindows = driver.getWindowHandles();
 		for(String childwin:allwindows)
 		{
    	if(childwin.equalsIgnoreCase(parentwindowid))
    	{
    		driver.switchTo().window(childwin);
    		 Library.threadSleep(2000);
    	WebElement EnterNoteName = driver.findElement(By.xpath("(//*[@id=\"addForm\"]/div[1]/div/div[1]/div/input)[2]"));
    	EnterNoteName.sendKeys("CreateNotesByAutomation");
    	
    	Library.threadSleep(2000);
    	WebElement duedate1 = driver.findElement(By.xpath("(//*[@id=\"addForm\"]/div[1]/div/div[3]/div/input)[2]"));
    	duedate1.sendKeys("20/11/2024");
    	 
    	Library.threadSleep(2000);
    	WebElement discreption = driver.findElement(By.xpath("(//*[@id=\"addForm\"]/div[1]/div/div[4]/div/input)[1]"));
    	discreption.sendKeys("testing note on matter details page");
    	
    	Library.threadSleep(2000);
    	WebElement savechanges = driver.findElement(By.xpath("(//*[@id=\"addForm\"]/div[2]/button[2])[2]"));
    	savechanges.click();
    	Library.threadSleep(2000);
    	driver.switchTo().window(parentwindowid);
    	Library.threadSleep(2000);
    	
}
 		}
	}
    	public boolean verifyNote(String taskname) {
    		
    		WebElement NoteTab = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div/nav/a[5]"));
    		NoteTab.click();
    		  try {
    		        String xpath = "//table//tr[td[text()='" + taskname + "']]";
    		        WebElement contactRow = driver.findElement(By.xpath(xpath));
    		        
    		        if (contactRow.isDisplayed()) {
    		            System.out.println("Tasks : " + taskname + " is successfully created.");
    		            Allure.step("Validation Passed: task " + taskname + " is present in the table.");
    		            return true;
    		        }
    		    } catch (NoSuchElementException e) {
    		        System.out.println("Validation Failed: task " + taskname + " not found in table.");
    		        Allure.step("Validation Failed: task " + taskname + " is missing from the table.");
    		        return false;
    		    }
    		  return false;
    		}
}
	

