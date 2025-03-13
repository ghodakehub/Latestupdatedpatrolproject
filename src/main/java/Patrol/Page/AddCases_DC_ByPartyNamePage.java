package Patrol.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;

public class AddCases_DC_ByPartyNamePage extends BasePage{
	
	
	public AddCases_DC_ByPartyNamePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "(//button[@class='nav-link   fs-14 py-4 fw-bold'])[1]")
	private WebElement BY_PARTY_NAME;
	
	@FindBy (xpath = "(//select[@class='form-select'])[6]")
	private WebElement STATE_DROPDOWN;
	
	@FindBy (xpath = "(//select[@class='form-select'])[7]")
	private WebElement DISTRICT_DROPDOWN;
	
	@FindBy (xpath = "(//select[@class='form-select'])[8]")
	private WebElement CASE_STATUS_DROPDOWN;
	
	@FindBy (xpath = "(//select[@class='form-select'])[9]")
	private WebElement YEAR_DROPDOWN;
	
	@FindBy (xpath = "(//input[@class='form-control'])[7]")
	private WebElement SEARCH_BY_PARTY;
	
	@FindBy (xpath = "(//button[@class='btn btn-primary fs-14 '])[2]")
	private WebElement SEARCH_FOR_CASE_BUTTON;
	
	@FindBy (xpath = "//label//span")
	private WebElement CHECK_BOX;
	
	@FindBy (xpath = "//button[@class='btn btn-primary btn-sm ms-auto']")
	private WebElement ADD_CASES_BUTTON;
	
	@FindBy (xpath = "//button[@class='swal2-confirm swal2-styled']")
	private WebElement OK_BUTTON;
	
	@FindBy (xpath = "//a[@class='h6 d-block mb-0 fw-bold me-2 text-primary']")
	private WebElement casename;
	
	
	public void clickOnByPartyName() {
		Library.click(driver, BY_PARTY_NAME, "Clicked on By Party Name successfully.");
	}
	
	public void selectState(String LogState) {
		Library.selectDropDown(STATE_DROPDOWN, LogState);
	}
	
	public void selectDistrict(String LogDistrict) {
		Library.selectDropDown(DISTRICT_DROPDOWN, LogDistrict);
	}
	
	public void selectCaseStatus(String LogCaseStatus) {
		Library.selectDropDown(CASE_STATUS_DROPDOWN, LogCaseStatus);
	}
	
	public void selectYear(String LogYear) {
		Library.selectDropDown(YEAR_DROPDOWN, LogYear);
	}
	
	public void enterPartyName(String LogPartyName) {
		Library.sendKeys(driver, SEARCH_BY_PARTY, "Party Name sent successfully.", LogPartyName);
		Library.threadSleep(5000);
	}
	
	public void clickOnSearch() {
		Library.click(driver, SEARCH_FOR_CASE_BUTTON, "Clicked on search button successfully.");
	}
	
	public void selectCasesByCheckBox(int enterNoOfcase) {
		List<WebElement> checkBox = null;
		try {
			checkBox = driver.findElements(By.xpath("//label//span"));
			System.out.println(checkBox.size());
              
			for (int i = 1; i <= enterNoOfcase; i++) {
				WebElement check_Box = driver.findElement(By.xpath("(//label//span)[" + i + "]"));
				Actions actions = new Actions(driver);

				// Scroll down using the mouse wheel
				actions.scrollByAmount(0, 100).perform(); // 
				//String casename1 = casename.getText();
				Library.threadSleep(1000);
				Library.click(driver, check_Box,"click on cases");
			
			}
			Library.threadSleep(3000);
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.bodyscrollTop)");
			Library.threadSleep(3000);
			Library.click(driver, ADD_CASES_BUTTON, "Clicked on Add Cases Button successfully.");

		} catch (Exception e) {
			String ExpectedText = "Currenly This searched case is not available. you can request for this case and will be add and notified once available";
			String ActualText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[5]/div[1]/div/div/p")).getText();
			if (ExpectedText.contains(ActualText)) {
				System.out.println("Webpage text verified successfully, No case available. ");
				Library.threadSleep(2000);
			} else {
				System.out.println("Webpage text not as expected.");
			}

		} 
	}
	
	
	public void clickOnOkButton() {
		Library.click(driver, OK_BUTTON, "Clicked on OK button successfully.");
	}

}
