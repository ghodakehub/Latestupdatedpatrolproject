package Patrol.Test;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.CheckAllMatters_Onmatterpage;
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
@Epic("Matters")
@Feature("Verify Matters")
public class CheckAllMatters extends NewBaseTest {
	
	    @Test(description = "Verify all added matters ")
	    @Severity(SeverityLevel.CRITICAL)
	    @Description(" This test case Verify All Added Matters  Open Successfully")
	    public void verifymatters() {
	      
	            Allure.step("Step 1: Perform Login with valid credentials");
	            LoginPage loginPage = new LoginPage(driver);
	            loginPage.setEmail(ConfingData_provider.Email);
	            loginPage.setPassword(ConfingData_provider.Password);
	            loginPage.performAction();

	            Allure.step("Step 2: Navigate to Dashboard and Select Company");
	            DashBoardPage dashboard = new DashBoardPage(driver);
	            dashboard.clickOncompany("Pharma limited");

	            Allure.step("Step 3: Start Verification of Matters");
	            CheckAllMatters_Onmatterpage matters = new CheckAllMatters_Onmatterpage(driver);
	            matters.clickonmatter();
	            matters.checkmatters();
	            // Error Handling
	            if (!Library.errorUrls.isEmpty()) {
	                System.out.println("Matters verification failed");
	                
	                AllureListeners.captureScreenshot(driver, "Error coming while open this matters");
	                Assert.fail("Test Case Failed: Invoices Matters");
	            } else {
	                System.out.println("Matters is Verified Successfully!");
	            }
        }

	        @AfterTest
	        public void sendEmailAfterExecution() throws MessagingException {
	            if (!Library.errorUrls.isEmpty()) {
	               // String subject = "All cases -Patrol Automation";
	                String message = "please check Issue coming while open the Matters. Please check the attached Urls.";
	                String subject = "Company Name: " + Library.companyName + " :- Matters";
	                
	                EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
	            } else {
	                System.out.println("All Matters are opened successfully");
	            }
	        }
}

