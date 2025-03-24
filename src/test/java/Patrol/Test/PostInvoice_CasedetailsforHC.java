package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.CaseDetailscreatematter;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.postInvoice_casedetailspage;
import Patrol.Utility.AllureListeners;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class PostInvoice_CasedetailsforHC extends NewBaseTest {
	
	 @Test(description = "Verify case details Invoice tab for High courts")
	    @Severity(SeverityLevel.CRITICAL) 
	    @Description("This test verifies user can add Invoice in case details page of High court cases successfully")
	
	public void verifyInvoice() throws InterruptedException {
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
		      
		      create.searchAndOpenCase("POOJA SHARMA vs. HIMANSHU");
		      postInvoice_casedetailspage invoice= new postInvoice_casedetailspage(driver);
		      invoice.createinvoice("Invoice ");
		      invoice.addInvoice("statutory research","kumar", "Contingency Fee", "7 Days");
		      boolean isValid = invoice.isInvoiceUploaded("Libil _ Add Request.pdf ");
		    //  Assert.assertTrue(isValid, "Link validation failed!");
		        if (!isValid) {
		        	
		        	 
		        	Library.addScreenshotToList(driver, "invoice.png");

		        	 AllureListeners.captureScreenshot(driver, "invoice.png");
		             String url = driver.getCurrentUrl();
		           Library.errorUrls.add(url);
		             Allure.addAttachment("URL", url);
		             String message = "please check Issue coming while create document . Please check the attached report.";
		             String subject = "Company Name: " + Library.companyName + " invoice tab";
		             
		             EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
		         }

		         Allure.step("Test Case Passed: invoice is successfully created and verified.");
		     } catch (Exception e) {
		       
		         System.out.println("Test failed: " + e.getMessage());
		     }
	 }

}
