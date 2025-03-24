package Patrol.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;
import io.qameta.allure.Allure;

public class CreateDocuments_CaseDetailsPage extends BasePage {

	public CreateDocuments_CaseDetailsPage (WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//*[@id=\"document\"]")
	private WebElement choosefile;

	
	@FindBy (xpath = "(//*[@id=\"addForm\"]/div[2]/button[2])[6]")
	private WebElement savebtn;
	public void Createdoc(String tabName) throws InterruptedException
	{
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(
 	            By.xpath("//a[contains(@class,'nav-link') and contains(text(),'" + tabName + "')]")));
 	    tab.click();
 	    Thread.sleep(2000);
     WebElement createButton = driver.findElement(By.xpath("//*[@id=\"tab1-document\"]/div/div[1]/a"));
     createButton.click();
     Thread.sleep(3000);
     
     WebElement DocName = driver.findElement(By.xpath("(//*[@id=\"addForm\"]/div[1]/div/div[2]/div/input)[11]"));
     DocName.sendKeys("CreateDocumentByAutomation");
	   
	   	Library.threadSleep(2000);
		
	WebElement selectdate = driver.findElement(By.xpath("//*[@id=\"document_date\"]"));
	selectdate.sendKeys("02/03/2025");

	 Library.threadSleep(2000);
	choosefile.sendKeys("D:\\MyPatrolProject-main\\TestDataExelSheet\\Screenshot (196).png");
	Library.threadSleep(3000);
	WebElement documentdisc = driver.findElement(By.xpath("(//*[@id=\"addForm\"]/div[1]/div/div[5]/div/input)[3]"));
	documentdisc.sendKeys("Create document descriptions by Automations");
	Library.threadSleep(2000);
	
	savebtn.click();
	Library.threadSleep(2000);

}
	
	public boolean verifydoc(String docName) {
		
		 
	           
	            try {
	            	 WebElement docTab = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div/nav/a[4]"));
	 	            docTab.click();
	 	            Library.threadSleep(3000);
	                String xpath = "//tbody//tr//td//p//a[contains(@href, '" + docName + "')]";
	                WebElement docLink = driver.findElement(By.xpath(xpath));
	                
	                if (docLink.isDisplayed()) {
	                    System.out.println(" Document link found: " + docLink.getAttribute("href"));
	                    Allure.step("Validation Passed: Document link is present.");
	                    return true;
	                }
	            } catch (NoSuchElementException e) {
	                System.out.println("❌ Document link not found.");
	                Allure.step("Validation Failed: Document link is missing.");
	            }
	            return false;
	        }
}
