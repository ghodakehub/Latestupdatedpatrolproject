package Patrol.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.itextpdf.text.DocumentException;

import Patrol.Page.CheckPaginationofInvoices;
import Patrol.Page.DashBoardPage;
import Patrol.Page.InvoicePaginations;
import Patrol.Page.LoginPage;
import Patrol.Utility.AllureListeners;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.ForMultiplemailReceipent;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("Invoice")
@Feature("Verify Invoice")

public class checkpagesinvoice  extends NewBaseTest{

	@Test(description = "Verify Invoice Pagination with Data Validation")
    @Story("Invoice Pagination Functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Verify Pagination Content of Invoice Page")
    public void verifyInvoice() throws IOException, MessagingException {
        
            Allure.step("Step 1: Perform Login with valid credentials");
            LoginPage loginpage = new LoginPage(driver);
            loginpage.setEmail(ConfingData_provider.Email);
            loginpage.setPassword(ConfingData_provider.Password);
            loginpage.performAction();

            Allure.step("Step 2:  Select Company and Navigate to Dashboard ");
            DashBoardPage dashBoardpage = new DashBoardPage(driver);
            dashBoardpage.clickOncompany("Pharma limited");

            Allure.step("Step 3: Verify Invoice Pagination with Data Validation");
            CheckPaginationofInvoices invo = new CheckPaginationofInvoices(driver);
            invo.verifyInvoicePagination();

 
    
        // Error Handling
        if (!Library.errorUrls.isEmpty()) {
            System.out.println("Invoice paginations verification failed");
            
            AllureListeners.captureScreenshot(driver, "Error coming on this page");
            Assert.fail("Test Case Failed: Verification of ivoice paginations");
        } else {
            System.out.println("All pages Verified Successfully!");
        }
}

    @AfterTest
    public void sendEmailAfterExecution() throws MessagingException {
        if (!Library.errorUrls.isEmpty()) {
           // String subject = "All cases -Patrol Automation";
            String message = "please check Invoice , Issue coming while open this page. Please check the attached report.";
            String subject = "Company Name: " + Library.companyName + " - InvoicePaginations";
            
            EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
        } else {
            System.out.println("All pages opened successfully");
        }
  	
  	    

    }
    }
