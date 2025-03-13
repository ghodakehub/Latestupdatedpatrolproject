package Patrol.Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class OrderTracker extends BasePage{

	
	public OrderTracker(WebDriver driver) {
		super(driver);
			
	}
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/button/a")
	private WebElement settingbutton;
	@FindBy(xpath="//*[@id=\"order-setting\"]/div/form/div/div[2]/div[1]/button/i")
	private WebElement addbtn;
	@FindBy(xpath="//*[@id=\"newRow1\"]/td[1]/select")
	private WebElement selectoptions;

	@FindBy(xpath="//*[@id=\"newRow1\"]/td[2]/input")
	private WebElement checkbox;
	
	@FindBy(xpath="//*[@id=\"order-setting\"]/div/form/div/div[3]/button[2]")
	private WebElement savechangesbtn;

	public void addkeywordin_Ordertracker() {
		Library.click(driver, settingbutton, "click on settings");
		Library.threadSleep(2000);
		
		Library.click(driver, addbtn, "click on add button");
		Library.threadSleep(3000);
	
		Library.scrollTillElementDisplay(driver, selectoptions);
		Library.selectDropDown(selectoptions, "Additional Affidavits");
		Library.threadSleep(2000);
		
		Library.click(driver, checkbox, "click on checkbox");
		Library.threadSleep(2000);
		
		Library.click(driver,savechangesbtn , "click on savechanges button");
		Library.threadSleep(2000);
	}
		
		}
	

	
	

