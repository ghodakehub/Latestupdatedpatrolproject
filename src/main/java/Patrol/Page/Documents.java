package Patrol.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Documents extends BasePage{

	
	public Documents(WebDriver driver) {
		super(driver);
			
	}

	@FindBy (xpath = "(//span[@class='me-2'])[3]")
	private WebElement MATTERS_VIEW_ALL;
	
	@FindBy (xpath = "//*[@id=\"content\"]/div/div[2]/a/text()")
	private WebElement Newdocument;
	
	
	@FindBy (id = "basic-addon2")
	private WebElement SelectMatter;
	
	
	@FindBy (xpath = "//*[@id=\"tab1\"]/div/table/tbody/tr[1]/td[1]/label/input")
	private WebElement Selectcheckbox;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/div[1]/div[2]/input")
	private WebElement DocumentName;
	
	
	@FindBy (xpath = "//input[@name='document_date']")
	private WebElement DocumentDate;
	
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/div[2]/div[2]/textarea")
	private WebElement DocumentDiscreption;
	
	@FindBy (xpath = "//*[@id=\"addForm\"]/div[2]/div[1]/div[3]/input")
	private WebElement Documentfile;
}
