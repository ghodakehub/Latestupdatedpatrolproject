package Patrol.Test;


import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.AllureListeners;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Dashboard")
@Feature("Verify Dashboard page")
public class DashBoardTest extends NewBaseTest{
	

	

	@Test(description = "Verify Dashboard")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies dashboard open successfully")
	
	public void verifyDashBoard() {
		 Allure.step("Step 1: Login by valid credentials ");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();
		 Allure.step("Step 2:  Select Company and Navigate to Dashboard ");
		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		
		// Error Handling
		    if (!Library.errorUrls.isEmpty()) {
		        System.out.println("Issue coming on dashboard page");
		        
		        AllureListeners.captureScreenshot(driver, "Error On Dashboard page");
		        Assert.fail("Test Case Failed: Dashboard page");
		    } else {
		        System.out.println(" Dashboard page erified Successfully!");
		    }
		}

		@AfterTest
		public void sendEmailAfterExecution() throws MessagingException {
		    if (!Library.errorUrls.isEmpty()) {
		       // String subject = "All cases -Patrol Automation";
		        String message = "please check Issue coming on dashboard page. Please check the attached screenshot.";
		        String subject = "Company Name: " + Library.companyName + " All Cases";
		        
		        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
		    } else {
		        System.out.println("Dashboard open opened successfully");
		    }
		}
		
	}



