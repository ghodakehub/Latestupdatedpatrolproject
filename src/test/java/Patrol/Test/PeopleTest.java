package Patrol.Test;

import javax.mail.MessagingException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.PeoplePage;

import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
@Epic("Contact")
@Feature("Verify Contact")
public class PeopleTest extends NewBaseTest{
	

	@Test(description = "Verify contact")
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("This test verifies can we add new contact successfully")
	
	
	public void makeNewMatter() {
		try {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(ConfingData_provider.Email);
		loginpage.setPassword(ConfingData_provider.Password);
		loginpage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		
		PeoplePage people  = new PeoplePage(driver);
		people.ClickOnPeopleviewAll("NTPC_COMAPNY AutomationTest", "Company" ,"9678979089","Automation@gmail.com","Testing info for individual","Amravati");
		
	  }  catch (Exception e) {                                                                            
    	  Library.addScreenshotToList(driver, "Failure Screenshot");
    	    Library.errorUrls.add(driver.getCurrentUrl());
    	   System.out.println("Issue in add contacts");                                          
    }                                                                                                  
	}                                                                                               
                                                                                                       
@AfterTest
public void sendEmailAfterExecution() throws MessagingException {
 if (!Library.errorUrls.isEmpty()) {
    // String subject = "All cases -Patrol Automation";
     String message = "please check Issue coming to create contact Please check the attached screenshot.";
     String subject = "Company Name: " + Library.companyName + ":-Task";
     
     EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
 } else {
     System.out.println("create people successfully");
 }
}

		
	}
	

