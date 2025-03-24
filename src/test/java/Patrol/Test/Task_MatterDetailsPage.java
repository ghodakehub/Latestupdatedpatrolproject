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
import Patrol.Page.MatterDetailsPage;
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
@Feature("Verify Matter page")

public class Task_MatterDetailsPage extends NewBaseTest {
	
	 @Test(description = "Verify Adding Task on Matter Page")
	    @Severity(SeverityLevel.CRITICAL) 
	    @Description("This test verifies that the user can add a task on the Matter page.")
	
	public void VerifyaddTaskonMatterPage() throws MessagingException {
		
		
		 try {
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

	            MatterDetailsPage matterPage1 = new MatterDetailsPage(driver);
	            Allure.step("Step 5: Navigate to Matter View All Page");
	            matterPage1.clickOnMatterViewAll();

	            Allure.step("Step 6: Add Task details");
	            matterPage1.ClickonTask("pratiksha shinde", "Pending");

	          

	        }  catch (Exception e) {                                                                            
	        	  Library.addScreenshotToList(driver, "Failure Screenshot");
	        	    Library.errorUrls.add(driver.getCurrentUrl());
	        	   System.out.println("Issue in add task");  
	        	   String message = "please check Issue coming to create task on matters details page. Please check the attached report.";
	  	         String subject = "Company Name: " + Library.companyName + ":- Task ON Matters details page";
	  	         
	  	         EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
		    }                                                                                                  
			}                                                                                               
		                                                                                                       
	
	

}
