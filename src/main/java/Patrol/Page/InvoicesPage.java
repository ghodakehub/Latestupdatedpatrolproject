package Patrol.Page;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class InvoicesPage extends BasePage {

	
	public InvoicesPage(WebDriver driver) {
		super(driver);
			
	}

	@FindBy (xpath = "(//span[text()='View All'])[6]")
	private WebElement INVOICES_VIEW_ALL;
	
	
	@FindBy (xpath = "//a[@onclick='getMattersInTab();']")
	private WebElement ClickOntMatter;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div[1]/div/div[3]/div/nav/a[3]")
	private WebElement InvoicesPendingForApproval;
	
	
	@FindBy (xpath = "//button[@id='addInvoiceBtn']")
	private WebElement postInvoicebtn;
	
	
	@FindBy (xpath = "//select[@id='category_name']")
	private WebElement SelectActivityCategory;
	
	@FindBy (xpath = "//select[@id='matter_name']")
	private WebElement SelectMatter;
	
	@FindBy (xpath = "//input[@id='date']")
	private WebElement CategoryDate;
	
	@FindBy (xpath = "//select[@id='firm_user']")
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
	
	public void ClickOnInvoices() {
		Library.click(driver, INVOICES_VIEW_ALL, "Clicked on invoices of dashboard page.");
		Library.threadSleep(1000);
	}
	
	
	
	public void clickOnNewMatterButton() {
		Library.click(driver,ClickOntMatter , "Click on new matter button on Matters page");
		Library.threadSleep(2000);
		
		
		Library.click(driver,InvoicesPendingForApproval , "Click on InvoicesPendingForApproval tab on Matters page");
		Library.threadSleep(2000);
	}
	
	public void selectCourt(String category , String matter, String people,  String Flaterate,  String datedue) {
		
	//	postInvoicebtn.click();
		WebElement element = driver.findElement(By.xpath("//button[@id='addInvoiceBtn']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 500)");
		Library.threadSleep(2000);
	//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		//Library.threadSleep(2000);
		element.click();
		
		
		
		String parentwindowid = driver.getWindowHandle();
   	 System.out.println(parentwindowid);
		
	 		
	 		Set<String> allwindows = driver.getWindowHandles();
	 		for(String childwin:allwindows)
	 		{
	    	if(childwin.equalsIgnoreCase(parentwindowid))
	    	{
	    		driver.switchTo().window(childwin);
	    		 Library.threadSleep(2000);
		Library.threadSleep(2000);
		Library.selectDropDown(SelectActivityCategory, category);
		System.out.println("Selected SelectActivityCategory is: "+ category);
		 Library.threadSleep(2000);
		 CategoryDate.sendKeys("3/12/2024");
		 Library.threadSleep(2000);
		
		 Library.selectDropDown(SelectMatter, matter);
			System.out.println("Selected selectmatter is: "+ matter);
		Library.threadSleep(2000);
		
		
		 Library.selectDropDown(PeoplesClients, people);
			System.out.println("Selected PeoplesClients is: "+ people);
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
		Library.sendKeys(driver,discrepetion , "test discreption", "Enter discrepetion ");
		Library.threadSleep(1000);
		WebElement saveinvoice = driver.findElement(By.xpath("//*[@id=\"addInvoice\"]"));
		saveinvoice.click();
		Library.threadSleep(2000);
	}
	}
	 		
	}
	 		public boolean isInvoiceUploaded() {
	 	        try {
	 	        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	          //  WebElement successMsg = driver.findElement(By.xpath("//*[@id=\"successmsg\"]"));
	 	           WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successmsg")));

	 	          String messageText = successMessage.getText();
	 	          System.out.println("Success Message: " + messageText);
	 	          

	 	            return successMessage.isDisplayed();
	 	  		
	 	        } catch (NoSuchElementException e) {
	 	            return false;
	 	        }
	 	    }
	
}


