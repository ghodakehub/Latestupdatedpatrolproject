package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;

public class AddCases_Tribunal_ByCasePage extends BasePage {

	public AddCases_Tribunal_ByCasePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//span[@class='position-relative'])[3]")
	private WebElement TRIBUNALS;

	@FindBy(xpath = "(//select[@class='form-select'])[1]")
	private WebElement COURT;

	@FindBy(xpath = "(//select[@class='form-select'])[2]")  
	private WebElement STATEorBench;
	
	@FindBy(xpath = "(//label[@class='form-label fw-bold fs-14'])[3]")
	private WebElement STATE;

	@FindBy(xpath = "(//select[@class='form-select'])[4]")
	private WebElement YEAR;
	
	@FindBy(xpath = "(//select[@class='form-select'])[3]")
	private WebElement YEAR1;
	
	@FindBy(xpath = "(//select[@class='form-select'])[6]")
	private WebElement YEAR2;
	
	@FindBy(xpath = "(//select[@class='form-select'])[5]")
	private WebElement YEAR3;

	@FindBy(xpath = "(//input[@class='form-control'])[3]")
	private WebElement PARTY_NAME;

	@FindBy(xpath = "(//button[@class='btn btn-primary fs-14 '])[1]")
	private WebElement SEARCH_FOR_CASE_BUTTON;

	public void clickOnTribunals() {
		Library.click(driver, TRIBUNALS, "Clicked on tribunals on select forum page.");
	}

	public void selectCourt(String LogCourt, String LogStateOrBench, String LogState) {
		
		Library.selectDropDown(COURT, LogCourt);
		System.out.println("Tribunals Court selected successfully.");
		
				
		try {
			Library.selectDropDown(STATEorBench, LogStateOrBench);
			System.out.println("State selected as "+LogStateOrBench);
		} catch (Exception e) {

			System.out.println("In " + LogCourt + " Court bench/state dropdown not available.");
		}
		
		try {
			Library.selectDropDown(STATE, LogState);
			System.out.println("State selected as "+LogState);
		}catch(Exception e){
			System.out.println("In "+LogCourt+" Court state dropdown not available.");
		}
		
	}

//	public void selectState(String LogState) {
//		Library.selectDropDown(COURT, LogState);
//	}



	public void enterPartyName(String LogPartyName) {
		Library.sendKeys(driver, PARTY_NAME, "Party Name sent successfully.", LogPartyName);
	}

	public void clickOnSearchButton() {
		Library.click(driver, SEARCH_FOR_CASE_BUTTON, "Clicked on search button successfully.");
		Library.threadSleep(5000);
	}


	
	
	public void selectYear(String LogYear) {
		WebElement Year= driver.findElement(By.xpath("(//label[text()='Year *'])"));
		
		Library.selectDropDown(YEAR, LogYear);
		
		
		
//		if(Year.isDisplayed()) {
//			Library.selectDropDown(YEAR, LogYear);
//			System.out.println("Year selcted successfully.");
//		if(Year.isDisplayed()) {
//			Library.selectDropDown(YEAR1, LogYear);
//		}else {
//			Library.selectDropDown(YEAR2, LogYear);
//		}
//		
//		}	
//		else {
//			Library.selectDropDown(YEAR3, LogYear);
//		}
	}
	
	
	
	
	
}
