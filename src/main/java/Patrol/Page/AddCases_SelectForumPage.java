package Patrol.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class AddCases_SelectForumPage extends BasePage {
	
	public AddCases_SelectForumPage(WebDriver driver ) {
		super(driver);
	
	}
	
	@FindBy (how=How.XPATH, using="//a[@class='fw-semibold fs-14 text-decoration-none d-inline-flex align-items-center']")
	private WebElement TOTAL_CASES_VIEW_ALL;
	
	@FindBy (how=How.XPATH, using=" //a[@class='btn btn-primary text-nowrap me-2 h-100 px-3 d-flex align-items-center']")
	private WebElement ADD_CASES;
	
	@FindBy (how=How.XPATH, using="(//img[@class='position-absolute w-100 h-100 start-0 top-0'])[1]")
	private WebElement SUPREME_COURT;
	
	@FindBy (how=How.XPATH, using="(//img[@class='position-absolute w-100 h-100 start-0 top-0'])[2]")
	private WebElement HIGH_COURT;
	
	@FindBy (how=How.XPATH, using="(//img[@class='position-absolute w-100 h-100 start-0 top-0'])[3]")
	private WebElement TRIBUNALS_COURT;
	
	@FindBy (how=How.XPATH, using="(//img[@class='position-absolute w-100 h-100 start-0 top-0'])[4]")
	private WebElement DISTRICT_COURT;
	
	
	public void verifyCourts() {
		Library.click(driver, TOTAL_CASES_VIEW_ALL, "Clicked on- Total Cases");
		Library.click(driver, ADD_CASES, "Clicked on- Add Cases");
		Library.verifyText(driver, SUPREME_COURT, "Supreme Court");
		Library.verifyText(driver, HIGH_COURT, "High Courts");
		Library.verifyText(driver, TRIBUNALS_COURT, "Tribunals");
		Library.verifyText(driver, DISTRICT_COURT, "District Courts");
		Library.threadSleep(3);
		
	}
	
	

}
