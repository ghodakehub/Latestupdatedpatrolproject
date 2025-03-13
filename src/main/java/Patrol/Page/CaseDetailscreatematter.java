package Patrol.Page;

import java.time.Duration;

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

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class CaseDetailscreatematter extends BasePage {

	public CaseDetailscreatematter (WebDriver driver) {
		super(driver);
	}
	

	@FindBy (xpath = "//*[@id=\"organisation_id\"]")
	private WebElement selectorgnaization;
	@FindBy (xpath = "(//span[@class='select2-search select2-search--inline'])[4]")
	private WebElement assignuser;
	@FindBy (xpath = "//*[@id=\"adv_detail\"]")
	private WebElement addadvocate;
	@FindBy (xpath = "//*[@id=\"department\"]")
	private WebElement department;
	@FindBy (xpath = "//*[@id=\"practice_area\"]")
	private WebElement practicearea;
	@FindBy (xpath = "//*[@id=\"client_ref_number\"]")
	private WebElement referenceno;
	
	@FindBy (xpath = "(//*[@id=\"description\"])[2]")
	private WebElement matterdescription;
	@FindBy (xpath = "//*[@id=\"riskAssessment\"]")
	private WebElement riskassignment;
	@FindBy (xpath = "//*[@id=\"status\"]")
	private WebElement selectstatus;
	@FindBy (xpath = "//*[@id=\"location\"]")   
	private WebElement locations;
	@FindBy (xpath = "//*[@id=\"open_date\"]")   
	private WebElement opendate;
	@FindBy (xpath = "//*[@id=\"limitation_date\"]")   
	private WebElement limitationdate;
	@FindBy (xpath = "//*[@id=\"matter-billable-check\"]")   
	private WebElement matterbilablecheckbox;
	@FindBy (xpath = "//*[@id=\"billable_type\"]")         
	private WebElement selecbillabletype;
	
	@FindBy (xpath = "(//*[@id=\"rate\"])[2]")          //*[@id="content"]/div[1]/div[2]/div/nav/a[2]
	private WebElement enterrate;
	@FindBy (xpath = "(//*[@id=\"addForm\"]/div[2]/button[2])[5]")         
	private WebElement savebtn;
	
	@FindBy (xpath = "//*[@id=\"content\"]/div[1]/div[2]/div/nav/a[2]")          //*[@id="content"]/div[1]/div[2]/div/nav/a[2]
	private WebElement mattertab;
    public void searchAndOpenCase(String caseName) throws InterruptedException {
    	 WebElement totalcase = driver.findElement(By.xpath("//*[@id=\"matter_view\"]/div[1]/div/div[2]/a/span"));
    	 totalcase.click();
    	 Thread.sleep(2000);
    	
         try {
            
             WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
           
             searchBox.sendKeys(caseName);
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
             
             WebElement caseLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                 By.xpath("//*[@id=\"tableBody\"]/tr/td/a[contains(text(),'" + caseName + "')]")
             ));
             JavascriptExecutor js = (JavascriptExecutor) driver;
             js.executeScript("arguments[0].click();", caseLink);

             System.out.println("Successfully opened case: " + caseName);

         } catch (TimeoutException e) {
             System.out.println("Case not found: " + caseName);
         } catch (NoSuchElementException e) {
             System.out.println("Search box or case link not found.");
         }
     }
 
    
    

    // Method to click a tab and verify elements
    public void openTabAndVerify(String tabName, String createButtonText) throws InterruptedException {
       
        	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	    WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(
        	            By.xpath("//a[contains(@class,'nav-link') and contains(text(),'" + tabName + "')]")));
        	    tab.click();
        	    Thread.sleep(2000);
            WebElement createButton = driver.findElement(By.xpath("//a[contains(text(),'Create')] | //button[contains(text(),'Create')]"));
            createButton.click();
            Thread.sleep(3000);
			
            
        }
    
     public void createMatter(String organasaiton,String dept,String area ,String status,String hours)
     {
    	 Library.selectDropDown(selectorgnaization, organasaiton);
 		System.out.println("Selected organasaiton is: "+organasaiton);
 		Library.threadSleep(3000);
 		//WebElement assignuser1 = driver.findElement(By.xpath("//*[@id=\"addForm\"]/div[1]/div[2]/div[2]/div[1]/span/span[1]/span/span"));
 		//assignuser1.sendKeys(assinguser);
 	//	assignuser1.sendKeys(Keys.ARROW_DOWN);
	//	Library.threadSleep(3000);
	//	assignuser1.sendKeys(Keys.ENTER);
		//System.out.println("Selected assinguser is: "+assinguser);
	//	Library.threadSleep(2000);
 		
 		addadvocate.sendKeys("RAMESH");
		Library.threadSleep(2000);
		Library.selectDropDown(department, dept);
		System.out.println("Selected department is: "+dept);
		Library.threadSleep(2000);
		
		Library.selectDropDown(practicearea,area);
		System.out.println("Selected Selectpraticearea is: "+area);
		Library.threadSleep(2000);
		
          Library.scrollTillElementDisplay(driver, matterdescription);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", matterdescription);
		matterdescription.sendKeys("create new matter for high court case");
		Library.threadSleep(2000);
		referenceno.clear();
		referenceno.sendKeys("101");
		
		Library.threadSleep(2000);
		riskassignment.clear();
		riskassignment.sendKeys("testing riskassignment");

		Library.threadSleep(2000);
		Library.selectDropDown(selectstatus,status);
		System.out.println("Selected Status is: "+status);
		Library.threadSleep(2000);
		opendate.sendKeys("2/6/2025");
		Library.threadSleep(2000);
		
		 Library.scrollTillElementDisplay(driver, locations);
			
			JavascriptExecutor js2 = (JavascriptExecutor)driver;
			js2.executeScript("arguments[0].scrollIntoView(true);", locations);
		locations.sendKeys("DELHI");
		Library.threadSleep(2000);
	
		Library.threadSleep(2000);
		limitationdate.sendKeys("2/8/2025");
		Library.threadSleep(2000);
		matterbilablecheckbox .click();
			Library.threadSleep(2000);
			matterbilablecheckbox.click();
			Library.threadSleep(1000);
			Library.selectDropDown(selecbillabletype,hours);
			System.out.println("Selected billable options: "+hours);
			Library.threadSleep(2000);
			enterrate.clear();
			enterrate.sendKeys("3000");
			Library.threadSleep(2000);
  
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeScript("arguments[0].click();", savebtn);
			Library.threadSleep(2000);
			  
			
     }	
			public boolean verifymatters(String matterName) {
				
				WebElement mattertabs = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div/nav/a[2]"));
				mattertabs.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
	        WebElement createdMatter = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[@id=\"tab1\"]/div[1]/div/div[1]/h6")));

	        if (createdMatter.isDisplayed()) {
	            System.out.println("Matter created successfully and is visible.");
	            return true;
	        }
	     else 
	     {
	        System.out.println("Failed to create and verify matter!");
	        AllureListeners.captureScreenshot(driver, "CreateMatter_Error.png");
	        return false;
	    }
	   
	
	
	 }
     }
    



