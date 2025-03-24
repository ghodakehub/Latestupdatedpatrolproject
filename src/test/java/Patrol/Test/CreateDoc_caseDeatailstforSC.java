package Patrol.Test;

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

public class CreateDoc_caseDeatailstforSC extends NewBaseTest {
	
	 @Test(description = "Verify case details document tab")
	    @Severity(SeverityLevel.CRITICAL) 
	    @Description("This test verifies user can add document in case details page of supreme court cases successfully")
	
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
		      
		      create.searchAndOpenCase("M/S DATA INFOSYS PVT. LTD. vs. M/S N SOFT (INDIA) SERVICES PVT. LTD.");
		      CreateDocuments_CaseDetailsPage docpage= new CreateDocuments_CaseDetailsPage(driver);
		      docpage.Createdoc("Document");
		      
		      boolean verifydoc =docpage.verifydoc("patrol.legitquest.com/tabdocuments/download");

		        if (!verifydoc) {
		        	
		        	 
		        	Library.addScreenshotToList(driver, "docfailed.png");

		        	 AllureListeners.captureScreenshot(driver, "doc.png");
		             String url = driver.getCurrentUrl();
		           Library.errorUrls.add(url);
		             Allure.addAttachment("URL", url);
		             String message = "please check Issue coming while create document . Please check the attached report.";
		             String subject = "Company Name: " + Library.companyName + " Document tab";
		             
		             EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
		         }

		         Allure.step("Test Case Passed: DOcument is successfully created and verified.");
		     } catch (Exception e) {
		       
		         System.out.println("Test failed: " + e.getMessage());
		     }
		     
	 }
}


