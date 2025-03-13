package Patrol.Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import io.qameta.allure.Allure;

public class AddCompany extends BasePage {

	public AddCompany (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"dashboardTitle\"]/text()")
	private WebElement dasbhoard;
	


	public void CheckCompanies() throws InterruptedException {
	
		
		 try {
		        // Locate all active firms
		        List<WebElement> firms = driver.findElements(By.xpath("//a[@class='fw-bold text-dark fs-14 stretched-link text-decoration-none']"));
		        int totalFirms = firms.size();
		        Allure.step("Total active firms found: " + totalFirms);
		        System.out.println("Total active firms found: " + totalFirms);
		        Thread.sleep(1000);            

		        for (int i = 0; i < firms.size(); i++) {
		            try {
		                // Refresh the list of companies (important when navigating back)
		                firms = driver.findElements(By.xpath("//a[@class='fw-bold text-dark fs-14 stretched-link text-decoration-none']"));

		                // Click on the company link
		                WebElement company = firms.get(i);
		                String companyName = company.getText();
		                System.out.println("Opening company: " + companyName);
		               
		                JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		                // Scroll to the element
		                js.executeScript("arguments[0].scrollIntoView(true);", company);
		                company.click();

		                // Wait for the company page to load
		                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
		                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

		                // Boolean flag to track if the success condition is met
		                boolean isDashboardDisplayed = false;

		                // Check for "Master Dashboard" text
		                try {
		                    WebElement masterDashboard = driver.findElement(By.xpath("(//*[contains(text(),'Master Dashboard')])[1]"));
		                    if (masterDashboard.isDisplayed()) {
		                        isDashboardDisplayed = true; // Mark as success
		                    }
		                } catch (NoSuchElementException e) {
		                    System.out.println(companyName + ": Error is thrown when we select the company");
		                    
		                }

		                // Print success message if no errors occurred
		                if (isDashboardDisplayed) {
		                    System.out.println(companyName + ": Open company successfull");
		                    
		                }

		                // Navigate back to the main page
		                driver.navigate().back();
		                Thread.sleep(2000);

		            } catch (Exception e) {
		               
		            }
		        }
		    } catch (Exception e) {
		        System.out.println("Test failed due to an unexpected error: " + e.getMessage());
		       
		    }
		}
		
		
		
	}
		
	
	
	
	      
		
		
		
		
		
		





