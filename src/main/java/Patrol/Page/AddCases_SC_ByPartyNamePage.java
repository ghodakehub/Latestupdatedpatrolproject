package Patrol.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Patrol.Utility.Library;

public class AddCases_SC_ByPartyNamePage extends BasePage {

	public AddCases_SC_ByPartyNamePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//button[@class='nav-link   fs-14 py-4 fw-bold'])[1]")
	private WebElement BY_PARTY_NAME;

	@FindBy(xpath = "//input[@id='party_name']")
	private WebElement PARTY_NAME_TAB;

	@FindBy(xpath = "(//select[@class='form-select'])[5]")
	private WebElement YEAR3;

	@FindBy(xpath = "(//button[@class='btn btn-primary fs-14 '])[3]")
	private WebElement SEARCH_FOR_CASE;

	@FindBy(xpath = "//label//span")
	private WebElement CHECK_BOX;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm ms-auto']")
	private WebElement ADD_CASES_BUTTON;

	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	private WebElement OK_BUTTON;

	
	
	public void clickOnPatyName() {
		Library.click(driver, BY_PARTY_NAME, "Click on By Party Name successfully.");
	}

	public void enterValueOnPartyNameTab(String LogValue) {
		Library.sendKeys(driver, PARTY_NAME_TAB, "Value sent in Party Name Tab", LogValue);
	}

	public void selectYear(String enterYear) {
		Library.selectDropDown(YEAR3, enterYear);
	}

	public void clickOnSearchCases() {
		Library.click(driver, SEARCH_FOR_CASE, "Click on search cases Successfully");
	}

	public void selectCases(int enterNoOfcase) {

		List<WebElement> checkBox = null;
		
			checkBox = driver.findElements(By.xpath("//label//span"));
			System.out.println(checkBox.size());

			for (int i = 1; i <= enterNoOfcase; i++) {
				WebElement check_Box = driver.findElement(By.xpath("(//label//span)[" + i + "]"));
				
				Actions actions = new Actions(driver);

				// Scroll down using the mouse wheel
				actions.scrollByAmount(0, 200).perform(); // 
				//String casename1 = casename.getText();
				Library.threadSleep(1000);
				Library.click(driver, check_Box, "Click on case - " + check_Box.getText());
			}
                     Library.threadSleep(2000);
			
			WebElement button = driver.findElement(By.xpath("//button[@onclick='addCase()']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", button);
		
			
			Library.threadSleep(2000);

			
	}
	
	public void clickOnOkButton() {
		Library.click(driver, OK_BUTTON, "Clicked on OK Boutton successfully.");
		Library.threadSleep(5000);

	}
}
