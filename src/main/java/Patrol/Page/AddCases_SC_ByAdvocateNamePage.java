package Patrol.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;

public class AddCases_SC_ByAdvocateNamePage extends BasePage {
	
	public AddCases_SC_ByAdvocateNamePage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "(//button[@class='nav-link   fs-14 py-4 fw-bold'])[2]")
	private WebElement 	BY_ADVOCATE_NAME;
	
	@FindBy (xpath = "//span[@class='select2-selection select2-selection--single']")
	private WebElement ADVOCATE_ON_RECORD;
	
	@FindBy (xpath = "//input[@class='select2-search__field']")
	private WebElement SEARCH_TAB;
	
	@FindBy (xpath = "(//select[@class='form-select'])[7]")
	private WebElement YEAR4;
	
	
	
	public void clickOnByAdvocateName() {
		Library.click(driver, BY_ADVOCATE_NAME, "Clicked on By Advocate Name successfully.");
	}
	
	public void clickOnAdvocateOnRecord() {
		Library.click(driver, ADVOCATE_ON_RECORD, "Clicked on advocate on record successfully.");
	}
	
	public void enterAdvocateOnRecords(String LogName) {
		Library.sendKeys(driver, SEARCH_TAB, LogName, "Sent search key - "+LogName);
		
		Library.selectDropDown(YEAR4, "2015");
		Library.threadSleep(5000);

		}
	
	
}
