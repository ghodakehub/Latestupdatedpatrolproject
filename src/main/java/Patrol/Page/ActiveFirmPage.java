package Patrol.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Patrol.Utility.Library;

public class ActiveFirmPage extends BasePage {

	public ActiveFirmPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//h1[@class='h4 mb-0 text-dark fw-bold']")
	private WebElement ACTIVE_FIRM;
	
	
	
	public void verifyText() {
		Library.waitForVisibilityOf(driver, ACTIVE_FIRM);
		Library.threadSleep(5000);
	}
	
	
	
}
