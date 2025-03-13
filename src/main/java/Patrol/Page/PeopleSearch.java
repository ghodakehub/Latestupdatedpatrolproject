package Patrol.Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class PeopleSearch extends BasePage{
	
	public PeopleSearch(WebDriver driver) {
		super(driver);
			
	}

	@FindBy (xpath = "//*[@id=\"tab1-content\"]/div[1]/div[2]/div/div[2]/a/span")
	private WebElement People_ViewAll;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/nav/a[2]")
	private WebElement Individuals;
	
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[3]/div[1]/div/div[1]/form/input")
	private WebElement Filterkeyword;
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/nav/a[1]")
	private WebElement All;
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/nav/ul/li[3]/a")
	private WebElement pageno2;                   //textarea[@id='description']
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/nav/ul/li[2]/a")
	private WebElement pageno1;
	
	
	public void clickonpeople() {
		Library.click(driver, People_ViewAll, "click on contact");
		Library.threadSleep(2000);
	}
	
		public void enterSearchKeyword(String keyword) {
	        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='filter by keyword']"));
	        searchBox.sendKeys(keyword);
	        searchBox.sendKeys(Keys.RETURN);
	        Library.threadSleep(1000);
	    }

		 public void verifyPaginationAndErrors2() {
		        List<WebElement> pages = driver.findElements(By.xpath("//*[@id=\"tab1\"]/nav/ul/li/a"));
		        int totalPages = pages.size();

		        for (int i = 1; i <= totalPages; i++) {
		            try {
		                WebElement pageLink = driver.findElement(By.xpath("//*[@id=\"tab1\"]/nav/ul/li/a[text()='" + i + "']"));
		                JavascriptExecutor js = (JavascriptExecutor) driver;
		                js.executeScript("arguments[0].click();", pageLink);  
		                Library.threadSleep(2000); 
		               
		               
		                Library.verifyText(driver, "Stack trace", "Error found on Page " + i);

		            } catch (NoSuchElementException e) {
		                System.out.println("Pagination link not found for page: " + i);
		            }
		        }
		    }
}
