package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;

public class AddCase_HC_ByCasePage extends BasePage {

	public AddCase_HC_ByCasePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//span[@class='position-relative'])[2]")
	private WebElement HIGH_COURT;

	@FindBy(xpath = "(//select[@class='form-select'])[1]")
	private WebElement COURT;

	@FindBy(xpath = "(//select[@class='form-select'])[2]")
	private WebElement BENCH;

	@FindBy(xpath = "(//select[@class='form-select'])[3]")
	private WebElement CASE_TYPE;

	@FindBy(xpath = "//input[@id='case_no']")
	private WebElement CASE_NO;

	@FindBy(xpath = "(//select[@class='form-select'])[4]")
	private WebElement YEAR;

	@FindBy(xpath = "(//button[@class='btn btn-primary fs-14 '])[1]")
	private WebElement SEARCH_FOR_CASE;

	@FindBy(xpath = "//*[@id=\"content\"]/div/div[5]/div/div/div/div/div[1]/div/label/span")
	private WebElement CHECK_BOX;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm ms-auto']")
	private WebElement ADD_CASES;
	
	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	private WebElement OK_BUTTON;
	
	
	
	

	public void clickOnHighCourt() {
		Library.click(driver, HIGH_COURT, "Clicked on high court successfully.");
		Library.implicitWait(driver, 20);
	}

	public void selectCourt(String LogCourt) {
		Library.selectDropDown(COURT, LogCourt);
	}

	public void selectBench(String LogBench) {
		Library.selectDropDown(BENCH, LogBench);
	}

	public void selectCaseType(String LogCasetype) {
		Library.selectDropDown(CASE_TYPE, LogCasetype);
	}

	public void enterCaseNo(String LogCaseNo) {
		Library.sendKeys(driver, CASE_NO, "Case Number sent successfully.", LogCaseNo);
	}

	public void selectYear(String LogYear) {
		Library.selectDropDown(YEAR, LogYear);
	}

	public void clickOnSearchForCase() {
		Library.click(driver, SEARCH_FOR_CASE, "Clicked on search button successfully.");
		Library.threadSleep(5000);
	}

	public void clickOnCheckBox() {
		
		WebElement checkbox = driver.findElement(By.xpath("//label//span"));
		Actions actions = new Actions(driver);

		// Scroll down using the mouse wheel
		actions.scrollByAmount(0, 300).perform(); // 
		//String casename1 = casename.getText();
		Library.threadSleep(1000);
		Library.click(driver, checkbox,"click on cases");
		
	}
	
	public void clickOnAddCases() {
		Library.click(driver, ADD_CASES, "Clicked on add cases.");
		Library.threadSleep(5000);
	}	
	
	public void clickOnOkButton() {
		Library.click(driver, OK_BUTTON, "Click on Ok button.");
	}
	

}
