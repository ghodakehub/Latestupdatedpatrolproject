package Patrol.Page;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class PeoplePage extends BasePage {

	public PeoplePage(WebDriver driver) {
		super(driver);		
	}

	@FindBy (xpath = "//*[@id=\"tab1-content\"]/div[1]/div[2]/div/div[2]/a/span")
	private WebElement People_ViewAll;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/nav/a[2]")
	private WebElement Individuals;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/nav/a[3]")
	private WebElement Companies;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/button")
	private WebElement NewPopeple;
	
	
	@FindBy (xpath = "//input[@id='name']")
	private WebElement EnterpopelName;
	
	@FindBy (xpath = "//input[@id='phone']")
	private WebElement PhoneNumber;
	
	@FindBy (xpath = "//input[@id='email']")
	private WebElement EnterMail;
	
	@FindBy (xpath = "//input[@id='other_info']")
	private WebElement OtherInfo;                                  
	  
	
	@FindBy (xpath = "//input[@id='address']")
	private WebElement Address;
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[3]/button[2]")
	private WebElement saveChanges;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/div[2]/div[2]/div/select")
	private WebElement selectPeopleType;
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[3]/div[1]/div/div[1]/form/input")
	private WebElement Filterkeyword;
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/nav/a[1]")
	private WebElement All;
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/nav/ul/li[3]/a")
	private WebElement pageno2;                   //textarea[@id='description']
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/nav/ul/li[2]/a")
	private WebElement pageno1;
	
	public void ClickOnPeopleviewAll(String name,String selecttype , String phoneno, String mail,String info ,String enteraddress ) {
		Library.click(driver,People_ViewAll , "Clicked on peopel view all button");
		Library.threadSleep(2000);
		
		Library.click(driver,Individuals , "Clicked on Individual");
		Library.threadSleep(2000);
		
	
		Library.click(driver, Companies, "Clicked on companies");
		Library.threadSleep(2000);
		
		 String parentwindowid = driver.getWindowHandle();
    	 System.out.println(parentwindowid);
    	 
    	 JavascriptExecutor js1 = (JavascriptExecutor)driver;
 		js1.executeScript("arguments[0].scrollIntoView(true);",NewPopeple );
 		NewPopeple.click();
 		
 		
 		
 		Set<String> allwindows = driver.getWindowHandles();
 		for(String childwin:allwindows)
 		{
    	if(childwin.equalsIgnoreCase(parentwindowid))
    	{
    		driver.switchTo().window(childwin);
    		 Library.threadSleep(2000);
    		 Library.sendKeys(driver, EnterpopelName, "Enter people name :", name);
    		 Library.threadSleep(2000);
    		 
    		 
    		 selectPeopleType.click();
    		 selectPeopleType.sendKeys(selecttype);
    		 selectPeopleType.sendKeys(Keys.ARROW_DOWN);
    		 selectPeopleType.sendKeys(Keys.ENTER);
    			Library.threadSleep(2000);
    				
    		 Library.sendKeys(driver, PhoneNumber,  "Enter phone number :" ,phoneno);
    		 Library.threadSleep(2000);
    		 
    		 Library.sendKeys(driver, EnterMail, "Enter mail id :", mail);
    		 Library.threadSleep(2000);
    		 
    		 Library.sendKeys(driver, OtherInfo, "Enter other info :", info);
    		 Library.threadSleep(2000);
    		 
    		 Library.sendKeys(driver, Address, "Enter address :", enteraddress);
    		 Library.threadSleep(2000);
    		 
    		 Library.click(driver,saveChanges , "Clicked saveChanges button");
    			Library.threadSleep(2000);
    			
    			
        		 
	}
 		}}
	

}
