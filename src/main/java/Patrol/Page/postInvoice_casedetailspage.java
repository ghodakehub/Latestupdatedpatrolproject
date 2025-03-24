package Patrol.Page;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.Library;
import io.qameta.allure.Allure;

public class postInvoice_casedetailspage extends BasePage {

	public postInvoice_casedetailspage (WebDriver driver) {
		super(driver);
	}

	
	
	@FindBy (xpath = "//button[@id='addInvoiceBtn']")
	private WebElement postInvoicebtn;
	
	
	@FindBy (xpath = "//select[@id='category_name']")
	private WebElement SelectActivityCategory;
	
	@FindBy (xpath = "//input[@id='date']")
	private WebElement CategoryDate;
	
	@FindBy (xpath = "//*[@id=\"submitBtn\"]/div/div[2]/div[3]/div[4]/div/span/span[1]/span/span")
	private WebElement PeoplesClients;                                  
	  
	
	@FindBy (xpath = "//select[@id='rate']")
	private WebElement FlateRate;
	
	@FindBy (xpath = "//input[@id='amount']")
	private WebElement Amount;
	
	
	@FindBy (xpath = "//*[@id=\"contract_file\"]")
	private WebElement ChooseFile;
	
	@FindBy (xpath = "/*[@id=\"file-uploder\"]/div[1]/span/span")
	private WebElement uploadFile1;
	
	@FindBy (xpath = "//input[@id='invoice_date']")
	private WebElement InvoiceDate;
	
	@FindBy (xpath = "//select[@id='due_days']")
	private WebElement dueDate;                   //textarea[@id='description']
	
	@FindBy (xpath = "//textarea[@id='description']")
	private WebElement discrepetion;
	public void createinvoice(String tabName ) throws InterruptedException
	{
	
    	 
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(
 	            By.xpath("//a[contains(@class,'nav-link') and contains(text(),'" + tabName + "')]")));
 	    tab.click();
 	    Thread.sleep(2000);
 	   WebElement createpostbtn = driver.findElement(By.xpath("//*[@id=\"addInvoiceBtn\"]"));
 	  createpostbtn.click();
 	     Thread.sleep(2000);
    	}
	
    public void addInvoice(String category,String userName,String Flaterate,  String datedue) {

		String parentwindowid = driver.getWindowHandle();
   	 System.out.println(parentwindowid);
		
	 		
	 		Set<String> allwindows = driver.getWindowHandles();
	 		for(String childwin:allwindows)
	 		{
	    	if(childwin.equalsIgnoreCase(parentwindowid))
	    	{
	    		driver.switchTo().window(childwin);
	    		 Library.threadSleep(2000);
		Library.selectDropDown(SelectActivityCategory, category);
		System.out.println("Selected SelectActivityCategory is: "+ category);
		 Library.threadSleep(2000);
		 CategoryDate.sendKeys("3/03/2025");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Click the dropdown to open the list
	        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[contains(@class, 'select2-selection')]")));
	        dropdown.click();

	        // Wait for the dropdown options to load
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='select2-firm_user-results']")));

	        // Select the desired user by visible text
	        WebElement user = driver.findElement(By.xpath("//li[contains(text(),'" + userName + "')]"));
	        user.click();

	        System.out.println("Selected user: " + userName);
	    
	        Library.threadSleep(2000);
	    	
		Library.selectDropDown(FlateRate, Flaterate);
    	Library.threadSleep(1000);
    	System.out.println("The FlateRate is : "+Flaterate);
    	Library.threadSleep(1000);
    	
    	Amount.sendKeys("3000");
    	Library.threadSleep(3000);
    	
    	WebElement fileUpload = driver.findElement(By.xpath("//input[@id='contract_file']"));
        fileUpload.sendKeys("D:\\MyPatrolProject-main\\TestDataExelSheet\\Libil _ Add Request.pdf");
    	Library.threadSleep(2000);
    	
    	
    	WebElement uploadFile = driver.findElement(By.xpath("//input[@id='invoice_files']"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadFile);
    	uploadFile.sendKeys("D:\\MyPatrolProject-main\\TestDataExelSheet\\Libil _ Add Request.pdf");
    	Library.threadSleep(3000);
    	
    	WebElement InvoiceDate1 = driver.findElement(By.xpath("//*[@id=\"invoice_date\"]"));
    	InvoiceDate1.sendKeys("02/27/2025");
		Library.threadSleep(2000);
		Library.selectDropDown(dueDate, datedue);
		System.out.println("Selected duedate is: "+datedue);
		Library.threadSleep(1000);
		Library.sendKeys(driver,discrepetion , "Enter Description", "Enter discrepetion ");
		Library.threadSleep(3000);
		WebElement saveinvoice = driver.findElement(By.xpath("//*[@id=\"addTabInvoice\"]"));
		saveinvoice.click();
		Library.threadSleep(5000);
	}
	}
	 		
    }
	 		public boolean isInvoiceUploaded(String linkText) {
	 			
	 			 WebElement invoiceTab = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div/nav/a[8]"));
	                
	 		        invoiceTab.click();

	 		        Library.threadSleep(3000); 
	 			 
	 					 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 				    String xpath = "//a[contains(@class, 'text-decoration-none') and contains(text(), '" + linkText + "')]";

	 				    try {
	 				        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	 				        return link.isDisplayed();
	 				    } catch (TimeoutException e) {
	 				        System.out.println("Link not found: " + linkText);
	 				        return false;
	 				    }
	 		     
	 		}
}
