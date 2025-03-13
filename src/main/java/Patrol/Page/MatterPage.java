package Patrol.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class MatterPage extends BasePage{
	
	public MatterPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy (xpath = "(//span[@class='me-2'])[4]")
	private WebElement MATTERS_VIEW_ALL;
	
	@FindBy (xpath = "(//a[@class='nav-link py-3  '])[1]")
	private WebElement OPEN;
	
	@FindBy (xpath = "//a[@class=' btn bg-primary text-white btn-sm btn--icon-text mr-4 ms-auto rounded-3 fs-14 py-2 px-3']")
	private WebElement NEW_MATTER_BUTTON;
	
	@FindBy (xpath = "(//select[@class='form-select'])[1]")
	private WebElement COURT_DROPDOWN;
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div/div/div[2]/div[1]/div[1]/div[2]/div/select")  
	private WebElement SUB_COURT_DROPDOWN;
	
	@FindBy (id = "search_case_filter")
	private WebElement SEARCH_CASE_DROPDOWN;
	
	@FindBy (xpath = "/html/body/div[5]/div/div[6]/button[1]")
	private WebElement YES_CHANGE_BUTTON;
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div/div/button[2]")
	private WebElement NEXT_BUTTON;
	
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div/div/div[2]/div[2]/div/div[2]/div[1]/select")
	private WebElement SELECT_ORGANISATION;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div/div/div[2]/div[2]/div/div[1]/div[1]/span/span[1]/span")
	private WebElement selectpeoplebox;
	
	@FindBy (xpath = "/html/body/span/span/span[1]/input")
	private WebElement enterpeople;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div/div/div[2]/div[2]/div/div[1]/div[2]/span/span[1]/span")
	private WebElement selecassignuser;
	
	@FindBy (xpath = "//select[@name='department']")
	private WebElement DEPARTMENT;
	
	@FindBy (xpath = "//select[@name='practice_area']")
	private WebElement Selectpraticearea;
	
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div/div/div[2]/div[2]/div/div[2]/div[2]/textarea")
	private WebElement ENTERADVOCATE;
	@FindBy (xpath = "//*[@id=\"addForm\"]/div/div/div[2]/div[2]/div/div[1]/div[4]/textarea")
	private WebElement MATTERDISCEPTION;
	@FindBy (xpath = "//*[@id=\"addForm\"]/div/div/div[2]/div[2]/div/div[1]/div[5]/textarea")
	private WebElement FIANCIALRISK;
	@FindBy (xpath = "//*[@id=\"addForm\"]/div/div/div[2]/div[2]/div/div[1]/div[6]/textarea")
	private WebElement RISKASSIGNMENT;
	@FindBy (xpath = "//*[@id=\"addForm\"]/div/div/div[2]/div[2]/div/div[1]/div[8]/input")
	private WebElement LOCATION;
	
	@FindBy (xpath = "//select[@name='status']")
	private WebElement STATUS;
	
	//calendar
	@FindBy (xpath = "//input[@name='open_date']")
	private WebElement opendate;
	
	@FindBy (xpath = "//input[@name='close_date']")
	private WebElement closedate;
	
	@FindBy (xpath = "//input[@name='pending_date']")
	private WebElement pendingdate;
	
	
	@FindBy (xpath = "/html/body/div[2]/main/div/div[1]/div/form/div/div/button[2]")
	private WebElement nextbtn;
	
	@FindBy (xpath = "//*[@id='matter-billable-check']")
	private WebElement matterbillable;
	
	
	@FindBy (xpath = "//select[@name='billable_type']")
	private WebElement houlry;
	
	@FindBy (xpath ="//*[@id=\"billable_div\"]/div[2]/div/div/div/input")
	private WebElement entervalue;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div/div/button[3]")
	private WebElement submitbtn;
	
	
	public void clickOnMatterViewAll() {
		Library.click(driver, MATTERS_VIEW_ALL, "Clicked on matters of dashboard page.");
		//wLibrary.threadSleep(1000);
	}
	
	public void verifyTaskBarOfMatters() {
		List<WebElement> bar=driver.findElements(By.xpath("(//a[@class='nav-link py-3  '])"));
		System.out.println(bar.size());
		
		for(int i=1; i<=bar.size(); i++) {
			Library.threadSleep(1000);
			WebElement taskBar=driver.findElement(By.xpath("(//a[@class='nav-link py-3  '])["+i+"]"));
			String text=taskBar.getText();
			System.out.println("Element available on matter task bar is:- "+taskBar.getText());
			taskBar.click();
			System.out.println("Successfully clicked on "+text);
			Library.threadSleep(1000);
			driver.navigate().back();
		}
	}
	
	public void clickOnNewMatterButton() {
		Library.click(driver, NEW_MATTER_BUTTON, "Click on new matter button on Matters page");
		//Library.threadSleep(2000);
	}
	
	public void selectCourt(String LogCourt) {
		Library.selectDropDown(COURT_DROPDOWN, LogCourt);
		System.out.println("Selected Court is: "+ LogCourt);
	}
	
	public void selectSubCourt(String LogSubCourt) {
		Library.selectDropDown(SUB_COURT_DROPDOWN, LogSubCourt);
		System.out.println("Selected SubCourt is: "+LogSubCourt);
	}
	
	public void selectSearchCaseDropDown(String CaseName) {
		Library.selectDropDown(SEARCH_CASE_DROPDOWN, CaseName);
    	Library.threadSleep(10000);
    	System.out.println("The Case selected for matter using search case dropdown is: "+CaseName);
	}
	
	public void clickOnYesChangeButton() {
		Library.click(driver, YES_CHANGE_BUTTON, "Clicked on Yes Change button successfully.");
	}
	
	public void clickOnNextButton() {
		Library.click(driver, NEXT_BUTTON, "Clicked on Next button for step 2.");
		//Library.threadSleep(2000);
	}
	
	
public void selecpeople(String people)

{
	
	selectpeoplebox.click();
	Library.threadSleep(2000);
	enterpeople.sendKeys(people);
	Library.threadSleep(2000);
	enterpeople.sendKeys(Keys.ARROW_DOWN);
	Library.threadSleep(2000);
	enterpeople.sendKeys(Keys.ENTER);
	System.out.println("Selected people is: "+people);
	
}
	
	public void selectOrganisation(String organasaiton) {
		Library.selectDropDown(SELECT_ORGANISATION, organasaiton);
		System.out.println("Selected organasaiton is: "+organasaiton);
		Library.threadSleep(2000);
	}
	
	public void selecassinguser(String assignuser) {
		
		selecassignuser.sendKeys(assignuser);
		selecassignuser.sendKeys(Keys.ARROW_DOWN);
		Library.threadSleep(2000);
		selecassignuser.sendKeys(Keys.ENTER);
		System.out.println("Selected assinguser is: "+assignuser);
		Library.threadSleep(2000);
	}
	
	public void selectdept(String dept) {
		Library.selectDropDown(DEPARTMENT, dept);
		System.out.println("Selected department is: "+dept);
		Library.threadSleep(2000);
	}
	
	
	
	public void selectpracticearea(String area) {
		Library.selectDropDown(Selectpraticearea,area);
		System.out.println("Selected Selectpraticearea is: "+area);
		Library.threadSleep(2000);
	}
	
	
	public void enterdata() {
		
		
		ENTERADVOCATE.sendKeys("RAMESH");
		Library.threadSleep(2000);
		MATTERDISCEPTION.sendKeys("create new matter");
		Library.threadSleep(2000);
		FIANCIALRISK.sendKeys("testing finacial");
		
		Library.threadSleep(2000);
		RISKASSIGNMENT.sendKeys("testing riskassignment");

		
	}
		public void enterstatus(String status)
		{
			
			Library.selectDropDown(STATUS,status);
			System.out.println("Selected Status is: "+status);
			Library.threadSleep(2000);
			opendate.sendKeys("2/6/2024");
			Library.threadSleep(2000);
			closedate.sendKeys("5/6/2024");
			
			Library.threadSleep(2000);
			LOCATION.sendKeys("DELHI");
			Library.threadSleep(2000);
			Library.scrollTillElementDisplay(driver,nextbtn );
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", nextbtn);
			Library.threadSleep(2000);
			nextbtn.click(); 
			
			
				
	}
	 public void clickbtn(String hours)
	 {
		 matterbillable.click();
			Library.threadSleep(1000);
			
			Library.selectDropDown(houlry,hours);
			System.out.println("Selected billable options: "+hours);
			Library.threadSleep(2000);
			
			entervalue.sendKeys("3000");
			Library.threadSleep(2000);
     
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeScript("arguments[0].click();", submitbtn);
	
	 }
		
	
	 public boolean getErrorMessage() {
		    // Navigate to the target page
		    driver.get("http://patrol.legitquest.com/matters/detail/67501063f3ccc8dbac054f02");

		    // Check for the error message
		    List<WebElement> errorElements = driver.findElements(By.xpath("//*[contains(text(), 'InvalidArgumentException') or contains(text(), 'View [cases.tribunals.detail_drat] not found')]"));

		    if (!errorElements.isEmpty()) {
		        System.out.println("❌ Error found: " + errorElements.get(0).getText());
		        
		        // Capture Screenshot for Allure
		        AllureListeners.captureScreenshot(driver, "Error Found in Matter Detail Page");

		        return true;  // Indicate that an error was found
		    } else {
		        System.out.println("✅ No error message found on the page.");
		        return false; // No error found
		    }
		}
}
