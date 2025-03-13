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
import Patrol.Page.LoginPage;
import Patrol.Page.MatterDetailsDocument;
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

@Epic("Matters")
@Feature("Verify Matter")

public class Documents_OnMattersDetailsPage  extends NewBaseTest{
	
	 @Test(description = "Verify Adding document on Matter Page")
	    @Severity(SeverityLevel.CRITICAL) 
	    @Description("This test verifies that the user can add a document on the Matter page.")
	
	public void verifydocumentonmatterpage() throws InterruptedException {

		 LoginPage loginpage = new LoginPage(driver);
		 try {
	            Allure.step("Step 1: Enter Email Address");
	            
	            loginpage.setEmail(ConfingData_provider.Email);

	            Allure.step("Step 2: Enter Password");
	            loginpage.setPassword(ConfingData_provider.Password);

	            Allure.step("Step 3: click on Login button");
	            loginpage.performAction();

	            DashBoardPage dashBoardpage = new DashBoardPage(driver);
	            Allure.step("Step 4: Click on Company Legitquest");
	            dashBoardpage.clickOncompany("Legitquest");

	            MatterDetailsDocument matterdoc = new MatterDetailsDocument(driver);
	            Allure.step("Step 5: Navigate to Matter View All Page");
	            matterdoc.clickOnMatterViewAll();

	            Allure.step("Step 6: Add doc details");
	            matterdoc.Clickondoc();
	          

	        }  catch (Exception e) {                                                                            
	        	  Library.addScreenshotToList(driver, "Failure Screenshot");
	        	    Library.errorUrls.add(driver.getCurrentUrl());
	        	  System.out.println("Issue to create add documents");                                           
		    }                                                                                                  
			}                                                                                               
		                                                                                                       
	 @AfterTest
	 public void sendEmailAfterExecution() throws MessagingException {
	     if (!Library.errorUrls.isEmpty()) {
	        // String subject = "All cases -Patrol Automation";
	         String message = "please check Issue coming to create document on matters details page. Please check the attached report.";
	         String subject = "Company Name: " + Library.companyName + ":- Add Documents On Matters details page";
	         
	         EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
	     } else {
	         System.out.println("add documents on matter detials page successfully");
	     }
	 }
}


