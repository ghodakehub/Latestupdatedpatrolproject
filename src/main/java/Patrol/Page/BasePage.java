package Patrol.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class BasePage {
	
	public WebDriver driver;
	
	 public BasePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this); // Initialize the WebElements
	        
	    }

}
