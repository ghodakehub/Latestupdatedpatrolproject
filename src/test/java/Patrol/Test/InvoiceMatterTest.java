package Patrol.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.itextpdf.text.DocumentException;

import Patrol.Page.DashBoardPage;
import Patrol.Page.InvoiceMatters;
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
@Feature("Invoice Matters Verification")
public class InvoiceMatterTest extends NewBaseTest{
	 
	@Test(description = "Verify All Invoice Matters")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies invoice matters one by one and captures errors with screenshots")
    public void verifyInvoice() throws IOException, MessagingException, InterruptedException {
		 Allure.step("Step 1: Perform Login with valid credentials");
        LoginPage loginpage = new LoginPage(driver);
        loginpage.setEmail(ConfingData_provider.Email);
        loginpage.setPassword(ConfingData_provider.Password);
        loginpage.performAction();
        Allure.step("Login Successfully");
        Allure.step("Step 2: Select company and navigate to dashboard page ");
        DashBoardPage dashBoardpage = new DashBoardPage(driver);
        dashBoardpage.clickOncompany("Legitquest");
       
        Allure.step("Step 3: verify Invoices Matters");
        InvoiceMatters matter = new InvoiceMatters(driver);
      
            matter.verifyInvoiceMatters();
            Allure.step("Invoice - Matters Verified");
           if (!Library.errorUrls.isEmpty()) {
	        System.out.println("Issue coming in invoices matters");
	        
	        AllureListeners.captureScreenshot(driver, "Error while create document");
	        Assert.fail("Test Case Failed: invoice Matters");
	    } else {
	        System.out.println(" Invoice Matters page verified Successfully!");
	    }
	}

	@AfterTest
	public void sendEmailAfterExecution() throws MessagingException {
	    if (!Library.errorUrls.isEmpty()) {
	       // String subject = "All cases -Patrol Automation";
	        String message = "please check Invoice Matters issue coming in below  matters. Please check the attached screenshot.";
	        String subject = "Company Name: " + Library.companyName + " :- Invoice- Matters";
	        
	        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
	    } else {
	        System.out.println("Invoice Matters open opened successfully");
	    }
    }
}

    



