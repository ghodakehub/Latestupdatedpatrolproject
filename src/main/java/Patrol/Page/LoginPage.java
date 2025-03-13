package Patrol.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

import Patrol.Utility.Library;



public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver ) {
		super(driver);
		
	}

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	private WebElement email;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	private WebElement password;
	@FindBy(how = How.XPATH, using = "//button[@name='submit']")
	private WebElement Login;

	public void setEmail(String EmailID) {
		Library.sendKeys(driver, email, "setEmail", EmailID);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void setPassword(String usrPass) {
		Library.sendKeys(driver, password, "setPass", usrPass);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void performAction() {
		Library.click(driver, Login, "ClickedOnLoginBtn");
		Library.threadSleep(5000);
	}

	public void login(String EmailId, String userPass) {
		setEmail(EmailId);
		setPassword(userPass);
		performAction();
	}
	
}
