package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import Patrol.Utility.Library;

public class AddCases_SC_ByDiaryNumberPage extends BasePage {

	public AddCases_SC_ByDiaryNumberPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"accordionSidebar\"]/div[3]/li[2]/a/span")
	private WebElement ManageCases;
	
	@FindBy(xpath = "//*[@id=\"accordionSidebar\"]/div[3]/li[2]/ul/li[1]/a/span")
	private WebElement Cases;
	@FindBy(xpath= " //a[@class='btn btn-primary text-nowrap me-2 h-100 px-3 d-flex align-items-center']")
	private WebElement ADD_CASES;
	@FindBy(xpath = "(//span[@class='position-relative'])[1]")
	private WebElement SUPREME_COURT;
	@FindBy(xpath = "//button[@class='nav-link fs-14 fw-bold py-4     active  px-4']")
	private WebElement BY_DIARY_NUMBER;
	@FindBy(xpath = "//input[@id='diary_no']")
	private WebElement DIARY_NO;
	@FindBy(xpath = "(//select[@class='form-select'])[1]")
	private WebElement YEAR;
	@FindBy(xpath = "(//button[@class='btn btn-primary fs-14 '])[1]")
	private WebElement SEARCH_FOR_CASE_BUTTON;
	@FindBy (xpath= "//*[@id=\"content\"]/div/div[5]/div/div/div/div/div[1]/div/label/span")
	private WebElement CHECK_BOX;
	@FindBy (xpath = "//button[@class='btn btn-primary btn-sm ms-auto']")
	private WebElement ADD_CASES_BUTTON;
	@FindBy (xpath = "(//button[@type='button'])[14]")
	private WebElement OK_BUTTON;
	
	
	
	
	public void clickOnTotalcases() {
		Library.threadSleep(2000);
		Library.click(driver, ManageCases, "Cliked on Total cases.");
		Library.implicitWait(driver, 20);
		
		Library.click(driver,Cases , "Cliked on Total cases.");
		Library.implicitWait(driver, 10);
	}

	public void clickOnAddCases() {
		Library.click(driver, ADD_CASES, "Clicked on Add cases.");
		Library.implicitWait(driver, 20);
	}

	public void clickOnSupremeCourt() {
		Library.click(driver, SUPREME_COURT, "Clicked on supreme court");
		Library.implicitWait(driver, 20);
	}

	public void enterDiaryNumber(String LogValue) {
		Library.sendKeys(driver, DIARY_NO, "Diary no entered", LogValue);
		Library.implicitWait(driver, 20);
	}

	public void selectYear(String LogValue) {
		Library.selectDropDown(YEAR, LogValue);
		Library.implicitWait(driver, 20);
	}

	public void performAction() {
		Library.click(driver, SEARCH_FOR_CASE_BUTTON, "Clicked on search case button.");
		//Library.threadSleep(5000);
		Library.implicitWait(driver, 20);
	}
	
	public void verifyAvailableCase() {
		
		WebElement checkbox = driver.findElement(By.xpath("//label//span"));
		Actions actions = new Actions(driver);

		// Scroll down using the mouse wheel
		actions.scrollByAmount(0, 200).perform(); // 
		//String casename1 = casename.getText();
		Library.threadSleep(1000);
			Library.threadSleep(2000);
			Library.click(driver, ADD_CASES_BUTTON, "Clicked ok AddCases Button successfully.");
			Library.click(driver, OK_BUTTON, "Clicked on Ok Button successfully.");
			System.out.println("Cases added successfully.");
		
			
		}
		
	}
	

	
	
	
	
	

