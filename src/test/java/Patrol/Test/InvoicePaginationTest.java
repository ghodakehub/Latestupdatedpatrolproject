package Patrol.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.itextpdf.text.DocumentException;

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
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Invoice Module")
@Feature("Invoice AddedMatters Verification")
public class InvoicePaginationTest  extends NewBaseTest{

	    @Test(description = "Verify added matters in invoices with Data Validation")
	    @Severity(SeverityLevel.CRITICAL)
	    @Description("Verify All Added Matters in Invoices Open Successfully")
	    public void verifyInvoice() {
	       
	            Allure.step("Step 1: Perform Login with valid credentials");
	            LoginPage loginPage = new LoginPage(driver);
	            loginPage.setEmail(ConfingData_provider.Email);
	            loginPage.setPassword(ConfingData_provider.Password);
	            loginPage.performAction();

	            Allure.step("Step 2: Select Company Navigate to Dashboard");
	            DashBoardPage dashBoardPage = new DashBoardPage(driver);
	            dashBoardPage.clickOncompany("Pharma limited");

	            Allure.step("Step 3: Verify Invoice Pagination with Data Validation");
	            InvoicePaginations invoicePagination = new InvoicePaginations(driver);
	            invoicePagination.verifyPaginationContent();

	            if (!Library.errorUrls.isEmpty()) {
	    	        System.out.println("Issue coming in invoices paginations");
	    	        
	    	        AllureListeners.captureScreenshot(driver, "Error coming on this page");
	    	        Assert.fail("Test Case Failed: invoice paginations");
	    	    } else {
	    	        System.out.println(" Invoice paginaitons verified Successfully!");
	    	    }
	    	}

	    	@AfterTest
	    	public void sendEmailAfterExecution() throws MessagingException {
	    	    if (!Library.errorUrls.isEmpty()) {
	    	       // String subject = "All cases -Patrol Automation";
	    	        String message = "please check Invoice , issue coming on paginations. Please check the attached screenshot.";
	    	        String subject = "Company Name: " + Library.companyName + " :- Invoice Paginations";
	    	        
	    	        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
	    	    } else {
	    	        System.out.println("Invoice paginations opened successfully");
	    	    }
	        }
	    }

	