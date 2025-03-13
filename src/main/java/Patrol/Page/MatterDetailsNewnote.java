package Patrol.Page;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class MatterDetailsNewnote extends BasePage{


	public MatterDetailsNewnote(WebDriver driver) {
		super(driver);
			
	}

	@FindBy (xpath = "(//span[@class='me-2'])[4]")
	private WebElement MATTERS_VIEW_ALL;
	
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/div/table/tbody/tr[1]/td[2]/p/a")
	private WebElement ClickOnFirstMatter;
	
	
	@FindBy (xpath = "//*[@id=\"nav-tab\"]/button[4]")
	private WebElement note;
	
	@FindBy (xpath ="//*[@id=\"tab5-5\"]/div[1]/button")
	private WebElement createnewnote;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[1]/div/div[1]/div/input")
	private WebElement entername;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[1]/div/div[3]/div/input")
	private WebElement duedate;
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[1]/div/div[4]/div/input")
	private WebElement notediscreption;
	
	
	@FindBy (xpath = "(//*[@id=\"addForm\"]/div[2]/button[2])[2]")
	private WebElement savechanges;

	
	public void clickOnMatterViewAll() {
		Library.click(driver, MATTERS_VIEW_ALL, "Clicked on matters of dashboard page.");
		Library.threadSleep(1000);
		 Library.click(driver, ClickOnFirstMatter, "Clicked on matter first .");
	
	}
     public void ClickonNote()
     {
    	 Library.click(driver,note , "Clicked on note.");
    	 Library.threadSleep(1000);
    	 String parentwindowid = driver.getWindowHandle();
    	 System.out.println(parentwindowid);
    	 
    	 JavascriptExecutor js1 = (JavascriptExecutor)driver;
 		js1.executeScript("arguments[0].scrollIntoView(true);",createnewnote );
 		createnewnote.click();
 		
 		Set<String> allwindows = driver.getWindowHandles();
 		for(String childwin:allwindows)
 		{
    	if(childwin.equalsIgnoreCase(parentwindowid))
    	{
    		driver.switchTo().window(childwin);
    		 Library.threadSleep(2000);
    	WebElement EnterNoteName = driver.findElement(By.xpath("(//*[@id=\"addForm\"]/div[1]/div/div[1]/div/input)[2]"));
    	EnterNoteName.sendKeys("NewNote");
    	
    	Library.threadSleep(2000);
    	WebElement duedate1 = driver.findElement(By.xpath("(//*[@id=\"addForm\"]/div[1]/div/div[3]/div/input)[2]"));
    	duedate1.sendKeys("20/11/2024");
    	 
    	Library.threadSleep(2000);
    	WebElement discreption = driver.findElement(By.xpath("(//*[@id=\"addForm\"]/div[1]/div/div[4]/div/input)[1]"));
    	discreption.sendKeys("testing note on matter details page");
    	
    	Library.threadSleep(2000);
    	
    	savechanges.click();
    	Library.threadSleep(2000);
    	driver.switchTo().window(parentwindowid);
    	Library.threadSleep(2000);
    	
}
}}}