package Patrol.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

public class suggestionalert extends BasePage{
	
	public suggestionalert(WebDriver driver) {
		super(driver);
			
	}

	@FindBy (xpath = "//*[@id=\"tab1-content\"]/div[1]/div[2]/div/div[2]/a/span")
	private WebElement People_ViewAll;
	
	
	
}
