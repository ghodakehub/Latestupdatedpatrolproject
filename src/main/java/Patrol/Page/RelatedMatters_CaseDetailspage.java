package Patrol.Page;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Patrol.Utility.Library;
import io.qameta.allure.Allure;

public class RelatedMatters_CaseDetailspage extends BasePage {

	public RelatedMatters_CaseDetailspage (WebDriver driver) {
		super(driver);
	}

	

	public void createinvoice(String tabName ) throws InterruptedException
	{
	
    	 
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	    WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(
 	            By.xpath("//a[contains(@class,'nav-link') and contains(text(),'" + tabName + "')]")));
 	    tab.click();
 	    Thread.sleep(2000);
 	   WebElement relatebmatterbtn = driver.findElement(By.xpath("//*[@id=\"tab1-relatedMatters\"]/div/div[1]/button"));
 	  relatebmatterbtn.click();
 	     Thread.sleep(4000);
    	}
	
    public void addInvoice(String court,String subcourt ,String casename) {
    	
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    	  WebElement courtDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='court']")));
          Select court1 = new Select(courtDropdown);
          court1.selectByVisibleText(court);  // Select court by text

          // 3. Select Subcourt
          WebElement subcourtDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='subcourt']")));
          Select subcourt1 = new Select(subcourtDropdown);
          subcourt1.selectByVisibleText(subcourt);  // Select subcourt by text

          WebElement caseDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                  By.xpath("//*[@id='select2-search_case_filter-container']")));
          caseDropdown.click();

          // Wait for the dropdown options to appear
          List<WebElement> caseOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                  By.xpath("//*[@id='select2-search_case_filter-results']/li")));

          boolean caseFound = false;
          for (WebElement option : caseOptions) {
              if (option.getText().equalsIgnoreCase(casename)) {
                  option.click();
                  System.out.println("Selected case: " + casename);
                  caseFound = true;
                  break;
              }
          }

          if (!caseFound) {
              System.out.println("Case not found: " + casename);
          }
          

         
          Library.threadSleep(1000);
          WebElement yesChangeButton = driver.findElement( By.xpath("/html/body/div[7]/div/div[6]/button[1]"));
                 
          yesChangeButton.click();
          Library.threadSleep(2000);
          
          WebElement saveChangesButton = driver.findElement( By.xpath("(//*[@id=\"addRelatedCase\"]/div[3]/button[2])[1]"));
          saveChangesButton.click();
          Library.threadSleep(3000);
      }
    
    // Reusable validation method
    public boolean validateCaseDetails(String expectedCaseName) {
    	
    	 WebElement relatedmatters = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div/nav/a[9]"));
    	 relatedmatters.click();
	     Library.threadSleep(3000);
        try {
            // Locate the table elements
            WebElement caseName = driver.findElement(By.xpath("//td[contains(text(),'" + expectedCaseName + "')]"));
           
            // Validate case name and date
            boolean isCaseNameCorrect = caseName.getText().equals(expectedCaseName);
            Library.threadSleep(1000);
            if (isCaseNameCorrect) {
                Allure.step(" Validation passed: Case name and date are correct.");
                return true;
            } else {
                Allure.step("Validation failed: Case name or date is incorrect.");
              
                return false;
            }
        } catch (NoSuchElementException e) {
            Allure.step(" Validation failed: Elements not found.");
            System.out.println("error in related matters not display added matters");
            return false;
        }
    }
    }





