package Patrol.Page;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;
import io.qameta.allure.Allure;

public class CreateContact_CaseDetailspage extends BasePage {

	public CreateContact_CaseDetailspage (WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/nav/a[2]")
	private WebElement Individuals;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/nav/a[3]")
	private WebElement Companies;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/button")
	private WebElement NewPopeple;
	
	@FindBy (xpath = "//*[@id=\"addContactForm\"]/div[2]/div[2]/div[1]/div/select")
	private WebElement selectPeopleType;
	
	
	@FindBy (xpath = "(//*[@id=\"name\"])[2]")
	private WebElement EnterpopelName;
	
	@FindBy (xpath = "//*[@id=\"phone\"]")
	private WebElement PhoneNumber;
	
	@FindBy (xpath = "//*[@id=\"email\"]")
	private WebElement EnterMail;
	
	@FindBy (xpath = "//*[@id=\"other_info\"]")
	private WebElement OtherInfo;                                  
	  
	
	@FindBy (xpath = "//input[@id='address']")
	private WebElement Address;
	
	@FindBy (xpath = "//*[@id=\"addContactForm\"]/div[3]/button[2]")
	private WebElement saveChanges;
	public void createcontact(String tabName ,String option) throws InterruptedException
	{
	
    	 
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(
 	            By.xpath("//a[contains(@class,'nav-link') and contains(text(),'" + tabName + "')]")));
 	    tab.click();
 	    Thread.sleep(2000);
     WebElement createButton = driver.findElement(By.xpath("//*[@id=\"contactDropdown\"]"));
     createButton.click();
     Thread.sleep(3000);  

    	    String dynamicXPath = String.format("//ul[contains(@class, 'dropdown-menu')]//a[text()='%s']", option);
    	    
    	    WebElement contactButton = driver.findElement(By.xpath(dynamicXPath));
    	    contactButton.click();
    	}
    

	public void createcontacts2(String selecttype,String name,String phoneno, String mail, String info, String enteraddress) {
		 String parentwindowid = driver.getWindowHandle();
    	 System.out.println(parentwindowid);
    	 
		
		Set<String> allwindows = driver.getWindowHandles();
 		for(String childwin:allwindows)
 		{
    	if(childwin.equalsIgnoreCase(parentwindowid))
    	{
    		driver.switchTo().window(childwin);
    		 
    		 selectPeopleType.click();
    		 selectPeopleType.sendKeys(selecttype);
    		 selectPeopleType.sendKeys(Keys.ARROW_DOWN);
    		 selectPeopleType.sendKeys(Keys.ENTER);
    			Library.threadSleep(2000);
    			
    			 Library.threadSleep(2000);
        		 Library.sendKeys(driver, EnterpopelName, "Enter people name :", name);
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
	
	public void existingcontact(String SelectcontactFromdropdown) {
		 WebElement selectexstingcontact = driver.findElement(By.xpath("//*[@id=\"existingContact\"]"));
		 selectexstingcontact.click();
		 Library.threadSleep(5000);
		 Library.selectDropDown(selectexstingcontact, SelectcontactFromdropdown);
		 Library.threadSleep(2000);
		 WebElement savebtn = driver.findElement(By.xpath("//*[@id=\"addTabExistingContact\"]"));
		 savebtn.click();
		 Library.threadSleep(2000);
	}

		
public boolean verifyaddcontact(String contactName) {
    try {
        String xpath = "//table//tr[td[text()='" + contactName + "']]";
        WebElement contactRow = driver.findElement(By.xpath(xpath));
        
        if (contactRow.isDisplayed()) {
            System.out.println("Contact " + contactName + " is successfully created.");
            Allure.step("Validation Passed: Contact " + contactName + " is present in the table.");
            return true;
        }
    } catch (NoSuchElementException e) {
        System.out.println("Validation Failed: Contact " + contactName + " not found in table.");
        Allure.step("Validation Failed: Contact " + contactName + " is missing from the table.");
        return false;
    }
    return false;
}

    		 
}
		

