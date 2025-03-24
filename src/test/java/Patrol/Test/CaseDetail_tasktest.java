package Patrol.Test;

import javax.mail.MessagingException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.CaseDetails_TaskTab;
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

public class CaseDetail_tasktest extends NewBaseTest {
	
	 @Test(description = "Verify case details tabs")
	    @Severity(SeverityLevel.CRITICAL) 
	    @Description("This test verifies that check all tabs in case details open successfully")
	
	public void VerifyaddTask_oncasedetailpage() throws InterruptedException {
		
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
		        create.searchAndOpenCase("MOSHIN ABDUL SAYYED vs. THE STATE OF MAHARASTRA THROUGH MAHARASHTRA ELECTRICITY REGULATORY COMMISSION GOVERNMENT AUTHORITY");
		        CaseDetails_TaskTab task= new CaseDetails_TaskTab(driver);
		        task.createtask("Task ", "Pending");
		       
		        // Verify if matter is added successfully
		        boolean cratedtask = create.verifyMatter("CreateTaskByAutomation");

		        if (!cratedtask) {
		            throw new AssertionError("task verification failed!");
		        }

		        Allure.step("Test Case Passed: Task was successfully created and verified.");
		    } catch (Exception e) {
		        AllureListeners.captureScreenshot(driver, "taskfiailed.png");

		        System.out.println("Test failed: " + e.getMessage());
		    }
	 }
		    
		        @AfterTest
		        public void sendEmailAfterExecution() throws MessagingException {
		            if (!Library.errorUrls.isEmpty()) {
		                String message = "Please check task issue coming to add task on case details page , See the attached url for details.";
		                String subject = "Company Name: " + Library.companyName + "Case details - MatterTab";

		                // Send email with failed URLs and screenshots
		                EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
		            } else {
		                System.out.println("create task successfully, no errors found.");
		            }
		        }
		    	


}
