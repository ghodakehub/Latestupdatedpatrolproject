package Patrol.Test;

import javax.mail.MessagingException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.CaseDetailscreatematter;
import Patrol.Page.CreateDocuments_CaseDetailsPage;
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

public class CaseDetails_CreateDoc extends NewBaseTest {
	
	 @Test(description = "Verify case details tabs")
	    @Severity(SeverityLevel.CRITICAL) 
	    @Description("This test verifies that check all tabs in case details open successfully")
	
	public void VerifyCreateDoc_oncasedetailpage() throws InterruptedException {
		
		try {
		        Allure.step("Step 1: Login with Valid credentails");
		        LoginPage loginpage = new LoginPage(driver);
		        loginpage.setEmail(ConfingData_provider.Email);
		        loginpage.setPassword(ConfingData_provider.Password);
		        loginpage.performAction();
		        Allure.step("Step 2: Click on Company Navigate to dashboard");
		        DashBoardPage dashBoardpage = new DashBoardPage(driver);
		       
		        dashBoardpage.clickOncompany("Pharma limited");
		        Allure.step("Step 5: Click on Notes tab fill up required fields");
		        CaseDetailscreatematter create = new CaseDetailscreatematter(driver);
		      
		      create.searchAndOpenCase("MOSHIN ABDUL SAYYED vs. THE STATE OF MAHARASTRA THROUGH MAHARASHTRA ELECTRICITY REGULATORY COMMISSION GOVERNMENT AUTHORITY");
		      CreateDocuments_CaseDetailsPage docpage= new CreateDocuments_CaseDetailsPage(driver);
		      docpage.Createdoc("Document");
		      
		      boolean verifyNotes =docpage.verifydoc("CreatedDocumentByAutomation");

		        if (!verifyNotes) {
		            throw new AssertionError("document verification failed!");
		        }

		        Allure.step("Test Case Passed: Document is successfully created and verified.");
		    } catch (Exception e) {
		        AllureListeners.captureScreenshot(driver, "docfailed.png");

		        System.out.println("Test failed: " + e.getMessage());
		    }
	 }


		        @AfterTest
		        public void sendEmailAfterExecution() throws MessagingException {
		            if (!Library.errorUrls.isEmpty()) {
		                String message = "Please check Documents issue coming to add doucment on case details page , See the attached url for details.";
		                String subject = "Company Name: " + Library.companyName + "Case details - DocumentTab";

		                // Send email with failed URLs and screenshots
		                EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
		            } else {
		                System.out.println("create doc successfully, no errors found.");
		            }
		        }
		    	


		      
		 }
	 
 
		      




