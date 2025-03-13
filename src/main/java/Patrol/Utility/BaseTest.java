package Patrol.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseTest extends ConfingData_provider {

	public WebDriver driver;
	
	
	@BeforeClass
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", BaseTest.driverpath);
		ChromeOptions opt= new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
	
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		 driver.get(BaseTest.URL);
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@AfterClass
	
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
	
	
	
}
