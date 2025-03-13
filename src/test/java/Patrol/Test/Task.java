package Patrol.Test;

import javax.mail.MessagingException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.TaskPage;

import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Task")
@Feature("Verify Task Module")
public class Task extends 	NewBaseTest{

	

	@Test(description = "Verify task")
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("This test verifies can we add new task successfully")
	
	

	
	public void verifyaddnewtask() throws InterruptedException {
		try {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(ConfingData_provider.Email);
		loginpage.setPassword(ConfingData_provider.Password);
		loginpage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		TaskPage task= new TaskPage(driver);
		task.clickOnTaskViewAll("Pending");
		
		  }  catch (Exception e) {                                                                            
        	  Library.addScreenshotToList(driver, "Failure Screenshot");
        	    Library.errorUrls.add(driver.getCurrentUrl());
        	   System.out.println("Issue in add task");                                          
	    }                                                                                                  
		}                                                                                               
	                                                                                                       
 @AfterTest
 public void sendEmailAfterExecution() throws MessagingException {
     if (!Library.errorUrls.isEmpty()) {
        // String subject = "All cases -Patrol Automation";
         String message = "please check Issue coming in task. Please check the attached report.";
         String subject = "Company Name: " + Library.companyName + ":-Task";
         
         EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
     } else {
         System.out.println("Add task successfully");
     }
 }

		
	}
	


