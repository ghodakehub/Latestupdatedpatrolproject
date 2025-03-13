package Patrol.Test;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.DocumentPage;
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

@Epic("Document")
@Feature("Verify Document")

public class DocumentTest  extends NewBaseTest{


	@Test(description = "Verify Document")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies can we add new Document successfully")
	public void VerifyCreateNewDocuments() {
		
		 Allure.step("Step 1:Login by valid credentials");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(ConfingData_provider.Email);
		loginpage.setPassword(ConfingData_provider.Password);
		loginpage.performAction();
		 Allure.step("Step 2:  Select Company and Navigate to Dashboard ");
		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		 Allure.step("Step 2: Click on doucment");
		DocumentPage doc = new DocumentPage(driver);
		doc.VerifyDoc();
		doc.ClickonNote();
		
		
		// Error Handling
	    if (!Library.errorUrls.isEmpty()) {
	        System.out.println("Issue coming in documents");
	        
	        AllureListeners.captureScreenshot(driver, "Error while create document");
	        Assert.fail("Test Case Failed: Documents");
	    } else {
	        System.out.println(" Documents page verified Successfully!");
	    }
	}

	@AfterTest
	public void sendEmailAfterExecution() throws MessagingException {
	    if (!Library.errorUrls.isEmpty()) {
	       // String subject = "All cases -Patrol Automation";
	        String message = "please check Issue coming while create new doucment. Please check the attached url.";
	        String subject = "Company Name: " + Library.companyName + " Documents";
	        
	        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
	    } else {
	        System.out.println(" Create Documents successfully");
	    }
	}
	

	}
	
	
	

