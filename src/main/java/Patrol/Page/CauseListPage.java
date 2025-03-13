package Patrol.Page;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;

public class CauseListPage extends BasePage {
	
	public CauseListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//*[@id=\"accordionSidebar\"]/div[3]/li[4]/a/span")
	private WebElement MY_CAUSE_LIST;
	
	@FindBy (xpath = "(//h3[@class='fs-20 fw-bold text-dark mb-0'])[1]")
	private WebElement DAILY_TABLE_HEADING;
	
	@FindBy (xpath = "//table//tr//th")
	private WebElement TABLES;
	
	
	public void clickOnCauseList() {
		Library.click(driver, MY_CAUSE_LIST, "Clicked on 'My Cause List' successfully.");
		Library.threadSleep(5000);
		
		//String titleofpage = driver.getTitle();
		//System.out.println("title:"+titleofpage);
		
		
		 String pageTitle = driver.getTitle();
         System.out.println("Page Title: " + pageTitle);
         
  
  	}
 


	public void getHeading() {
//		Library.getText(DAILY_TABLE_HEADING, "The text is:- ");
		
		List<WebElement> Table=driver.findElements(By.xpath("//h3[@class='fs-20 fw-bold text-dark mb-0']"));
		System.out.println("Number of List of Business available on page - "+ Table.size());
		
		
		for (int i=1; i<=Table.size(); i++) {
		//	Library.threadSleep(1000);
			WebElement Heading=driver.findElement(By.xpath("(//h3[@class='fs-20 fw-bold text-dark mb-0'])["+i+"]"));
			System.out.println(Heading.getText());
			  
						
		}
	}
	
	public void getTableData() {
		
//		int row= driver.findElements(By.xpath("//table//tbody//tr")).size();
//		System.out.println("The number of row available on page:- "+row);
		
		int column= driver.findElements(By.xpath("html//body//table//tbody//tr//td")).size();
		System.out.println("The number of column available on page:- "+column);
		
		int head= driver.findElements(By.xpath("//table//thead//tr//th")).size();
		System.out.println("The number of heading availableon on page:- "+ head);
		
//		for (int th=1; th<=4; th++) {
//			System.out.println(driver.findElement(By.xpath("//table//thead//tr//th["+th+"]")).getText()+" ");
		
		
		for(int j=1; j<=20; j++) {
			for(int c=1; c<=4; c++) {
 
				System.out.println(driver.findElement(By.xpath("//table//tbody//tr["+j+"]//td["+c+"]")).getText()+" ");
			}
			System.out.println();
		}
		//}
		
	}
	
}
