package Patrol.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.itextpdf.text.DocumentException;

import Patrol.Page.DashBoardPage;
import Patrol.Page.InvoicesPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.AllureListeners;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.ForMultiplemailReceipent;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Invoice Module")
@Feature("Post New Invoice")
public class InvoiceTest  extends NewBaseTest{



	
	    @Test(description = "Verify invoice")
	    @Severity(SeverityLevel.CRITICAL)
	    @Description("This test verifies post or add new invoice successfully ")
	
	public void verifyInvoice() {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(ConfingData_provider.Email);
		loginpage.setPassword(ConfingData_provider.Password);
		loginpage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		
		InvoicesPage invo= new InvoicesPage(driver);
		invo.ClickOnInvoices();
		invo.selectCourt("Case law research","NANAK SINGH vs. GURDIP SINGH","Yashoda mahajan","Contingency Fee","7 Days");
		
		 if (!invo.isInvoiceUploaded()) {
			 Library.addScreenshotToList(driver, "FailedStep");
			    Library.errorUrls.add(driver.getCurrentUrl());
		        Assert.fail("Test Case Failed: ");          
			
	            Assert.fail("Invoice was NOT uploaded successfully!");
	            
	        } else {
	            System.out.println("Invoice uploaded successfully!");
	        }
	    }
	    @AfterTest
    	public void sendEmailAfterExecution() throws MessagingException {
    	    if (!Library.errorUrls.isEmpty()) {
    	       // String subject = "All cases -Patrol Automation";
    	        String message = "please check Invoice , issue coming while add invoice. Please check the attached screenshot.";
    	        String subject = "Company Name: " + Library.companyName + " :- Add Invoice";
    	        
    	        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
    	    } else {
    	        System.out.println("Invoice create successfully");
    	    }
        }
	}

