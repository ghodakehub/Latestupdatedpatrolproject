package Patrol.Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.AllureListeners;
import Patrol.Utility.Library;

public class CheckAllMatters_Onmatterpage extends BasePage {
	
	public CheckAllMatters_Onmatterpage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy (xpath = "//*[@id=\"matter_view\"]/div[4]/div/div[2]/a/span")
	private WebElement matterviewall;
	public void clickonmatter()
	{
	
			Library.click(driver,matterviewall , "Clicked on mmatter of dashboard page.");
			Library.threadSleep(1000);
			 
		
		}
	public void checkmatters() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	  List<WebElement> pagination = driver.findElements(By.xpath("//li[@class='page-item']/a"));
      System.out.println("Total Pages Found: " + pagination.size());

      for (int p = 0; p < pagination.size(); p++) {
          System.out.println("Checking Matters on Page: " + (p + 1));

          List<WebElement> matterLinks = driver.findElements(By.xpath("//*[@id=\"tab1\"]/div/table/tbody/tr/td/p/a"));
          System.out.println("Total Matters found on Page " + (p + 1) + ": " + matterLinks.size());

          for (int i = 0; i < matterLinks.size(); i++) {
              try {
                  // Re-fetch matter links every time to avoid StaleElementReferenceException
                  matterLinks = driver.findElements(By.xpath("//*[@id=\"tab1\"]/div/table/tbody/tr/td/p/a"));
                  WebElement matter = matterLinks.get(i);
                  JavascriptExecutor js = (JavascriptExecutor) driver;
                  js.executeScript("arguments[0].click();", matter);
                  Library.threadSleep(2000);

                  // Verify for Stack Trace Error
                  Library.verifyText(driver, "Stack trace", "Error Found on Page: " + i);
                  Library.threadSleep(1000);

                  driver.navigate().back();
                  Library.threadSleep(2000);
                  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tab1\"]/div/table/tbody/tr/td/p/a")));

              } catch (Exception e) {
              	System.out.println("Error while clicking on Matter in Row " + (i + 1) + " on Page " + (p + 1));

                  AllureListeners.captureScreenshot(driver, "Error_Page_" + (i + 1) + "_Row_" + (i + 1));
               
              }
          }

       // Move to the next page if available
          if (p < pagination.size() - 1) {
              pagination = driver.findElements(By.xpath("//li[@class='page-item']/a")); // Refresh Pagination List
              if (pagination.size() > p + 1) { // Check if index exists
                  WebElement nextPage = pagination.get(p + 1);
                  JavascriptExecutor js = (JavascriptExecutor) driver;
                  js.executeScript("arguments[0].scrollIntoView(true);", nextPage);
                  Library.threadSleep(1000);

                  if (nextPage.isDisplayed() && nextPage.isEnabled()) {
                      js.executeScript("arguments[0].click();", nextPage);
                      Library.threadSleep(3000);
                      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tab1']/div/table/tbody/tr")));
                  } else {
                      System.out.println("Next Page Button is not Clickable");
                  }
              } else {
                  System.out.println("No More Pages Available");
              }
          }
  } 
	}}

