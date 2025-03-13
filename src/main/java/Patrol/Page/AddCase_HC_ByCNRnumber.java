package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;

public class AddCase_HC_ByCNRnumber extends BasePage {
	
	public AddCase_HC_ByCNRnumber (WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//button[@class='nav-link   fs-14 py-4 fw-bold']")
	private WebElement BY_CNR_NUMBER;
	
	@FindBy (xpath = "//input[@class='form-control ']")
	private WebElement CNR_NUMBER;
	
	@FindBy (xpath = "(//button[@class='btn btn-primary fs-14 '])[2]")
	private WebElement SEARCH_FOR_CASE_BUTTON;
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[5]/div/div/div/div/div[1]/div/label/span")
	private WebElement CHECK_BOX;
	
	@FindBy (xpath = "//button[@class='btn btn-primary btn-sm ms-auto']")
	private WebElement ADD_CASES_BUTTON;
	
	
	
	
	public void clickByCNRNumber() {
		Library.click(driver, BY_CNR_NUMBER, "Clicked on By CNR Number successfully.");
	}
	
	public void enterCNRNumber(String LogCNRNumber) {
		Library.sendKeys(driver, CNR_NUMBER, "CNR Number entered successfully.", LogCNRNumber);
	}
	
	public void clickOnSearchForCase () {
		Library.click(driver, SEARCH_FOR_CASE_BUTTON, "Clicked on Search For Case button successfully.");
	}
	
	public void clickOnCkeckBox() {
		
		WebElement checkbox = driver.findElement(By.xpath("//label//span"));
		Actions actions = new Actions(driver);

		// Scroll down using the mouse wheel
		actions.scrollByAmount(0, 300).perform(); // 
		//String casename1 = casename.getText();
		Library.threadSleep(1000);
		Library.click(driver, checkbox,"click on cases");
		
	}
	
	public void clickOnAddCases() {
		Library.click(driver, ADD_CASES_BUTTON, "Clicked on Add Cases button successfully.");
		Library.threadSleep(5000);
	}
	
	
}
