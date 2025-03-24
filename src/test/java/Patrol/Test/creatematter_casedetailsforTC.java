package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.CaseDetailscreatematter;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.AllureListeners;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class creatematter_casedetailsforTC extends NewBaseTest {
	
	 @Test(description = "Verify Matter tab on case details page for Tribunalcourts")
	    @Severity(SeverityLevel.CRITICAL) 
	    @Description("This test verifies create matters for Tribunalcourts in case details page successfully")
	
	public void verifycreatematterforsc() throws InterruptedException {
		
		 try {
		        Allure.step("Step 1: Login with Valid credentails");
		        LoginPage loginpage = new LoginPage(driver);
		        loginpage.setEmail(ConfingData_provider.Email);
		        loginpage.setPassword(ConfingData_provider.Password);
		        loginpage.performAction();
		        Allure.step("Step 2: Click on Company Navigate to dashboard");
		        DashBoardPage dashBoardpage = new DashBoardPage(driver);
		       
		        dashBoardpage.clickOncompany("Pharma limited");
		        Allure.step("Step 5: Click on Matter tab fill up required fields");
		        CaseDetailscreatematter create = new CaseDetailscreatematter(driver);
		        create.searchAndOpenCase("BANK OF BARODA AND ANR vs. Transform Steel Pvt Ltd");
		        create.openTabAndVerify("Matter", "Create Matter");
		        create.createMatter("pharma1", "testing department", "Civil Litigation", "Pending", "Hourly");

		        // Verify if matter is added successfully
		        boolean isMatterAdded = create.verifyMatter("BANK OF BARODA AND ANR vs. Transform Steel Pvt Ltd");

		        if (!isMatterAdded) {
		        	
		        	Library.addScreenshotToList(driver, "failed.png");
		            AllureListeners.captureScreenshot(driver, "contact.png");
		            String url = driver.getCurrentUrl();
		          Library.errorUrls.add(url);
		            Allure.addAttachment("URL", url);
		            
		            String message = "please check Issue coming while create matter . Please check the attached report.";
		            String subject = "Company Name: " + Library.companyName + "MatterTab";
		            
		            EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
		        }

		        Allure.step("Test Case Passed: contact is successfully created and verified.");
		    } catch (Exception e) {
		      
		        System.out.println("Test failed: " + e.getMessage());
		    }
		    }
}


