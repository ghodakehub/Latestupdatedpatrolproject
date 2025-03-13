package Patrol.Test;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.CheckAllDocument;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.MatterDetailsPage;
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
@Epic("Documents")
@Feature("Verify All Documents on page")
public class AllDocumentTest extends NewBaseTest {
	
	 @Test(description = "Verify all matters in documents")
	    @Severity(SeverityLevel.CRITICAL) 
	    @Description("This test verifies that check all added matters open successfully")
	
	public void VerifyaddTaskonMatterPage() {
		
	            Allure.step("Step 1: Enter Email Address");
	            LoginPage loginpage = new LoginPage(driver);
	            loginpage.setEmail(ConfingData_provider.Email);

	            Allure.step("Step 2: Enter Password");
	            loginpage.setPassword(ConfingData_provider.Password);

	            Allure.step("Step 3: Perform Login Action");
	            loginpage.performAction();

	            DashBoardPage dashBoardpage = new DashBoardPage(driver);
	            Allure.step("Step 4: Click on Company Legitquest");
	            dashBoardpage.clickOncompany("Legitquest");

	            CheckAllDocument doc= new CheckAllDocument(driver);
	            Allure.step("Step 5: Navigate to Document View All Page");
	            doc.VerifyDoc();

	            Allure.step("Step 6: check all matters on document page");
	            doc.VerifyDoc2();

	          
	         // Error Handling
	            if (!Library.errorUrls.isEmpty()) {
	                System.out.println("Matters verification failed on Document pages");
	                
	                AllureListeners.captureScreenshot(driver, "Error coming while open this matter");
	                Assert.fail("Test Case Failed: All matters on document page");
	            } else {
	                System.out.println("All Matters on document page is Verified Successfully!");
	            }
		 }

	        @AfterTest
	        public void sendEmailAfterExecution() throws MessagingException {
	            if (!Library.errorUrls.isEmpty()) {
	               // String subject = "All cases -Patrol Automation";
	                String message = "please check Issue coming while open the Matters in documents. Please check the attached Urls.";
	                String subject = "Company Name: " + Library.companyName + " Documents";
	                
	                EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
	            } else {
	                System.out.println("All Matters of doucments are opened successfully");
	            }
	        }
	        }
	



