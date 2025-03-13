package Patrol.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.itextpdf.text.DocumentException;

import Patrol.Page.CheckInvoiceMatters;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.AllureListeners;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.ForMultiplemailReceipent;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Epic("Invoice")
@Feature("Verify Invoice")
public class CheckAll_InvoicesMatters extends NewBaseTest{

	                                      
	@Test(description = "Verify all added matters on Invoice Page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify All Added Matters in Invoices Open Successfylly")
    public void verifyMattersOnInvoicePage() throws Exception {
       
            Allure.step("Step 1: Perform Login with valid credentials");
            LoginPage loginpage = new LoginPage(driver);
            loginpage.setEmail(ConfingData_provider.Email);
            loginpage.setPassword(ConfingData_provider.Password);
            loginpage.performAction();

            Allure.step("Step 2: Navigate to Dashboard and Select Company");
            DashBoardPage dashBoardpage = new DashBoardPage(driver);
            dashBoardpage.clickOncompany("Pharma limited");

            Allure.step("Step 3: Verify Matters In Inovices");
            CheckInvoiceMatters invo = new CheckInvoiceMatters(driver);
            invo.verifyInvoiceMatters();
            
	         // Error Handling
	            if (!Library.errorUrls.isEmpty()) {
	                System.out.println("Matters verification failed on Invoice page");
	                
	                AllureListeners.captureScreenshot(driver, "Error coming while open this invoice matter");
	                Assert.fail("Test Case Failed: Invoices Matters");
	            } else {
	                System.out.println("Matters on Invoice page is Verified Successfully!");
	            }
        }

	        @AfterTest
	        public void sendEmailAfterExecution() throws MessagingException {
	            if (!Library.errorUrls.isEmpty()) {
	               // String subject = "All cases -Patrol Automation";
	                String message = "please check Issue coming while open the Matters in Invoice. Please check the attached Urls.";
	                String subject = "Company Name: " + Library.companyName + ":-Invoice Matters";
	                
	                EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
	            } else {
	                System.out.println("All Matters of doucments are opened successfully");
	            }
	        }
	        
	

}


