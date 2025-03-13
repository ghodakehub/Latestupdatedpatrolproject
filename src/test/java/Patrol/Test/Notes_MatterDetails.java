package Patrol.Test;

import javax.mail.MessagingException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;

import Patrol.Page.MatterDetailsNewnote;

import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Matters")
@Feature("Verify Matter")
public class Notes_MatterDetails extends NewBaseTest {

	@Test(description = "Verify Notes on Matter detail page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies can we add Notes on matter details page successfully")
	
	
	public void makeNewMatterforHC() throws InterruptedException {
		try {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(ConfingData_provider.Email);
		loginpage.setPassword(ConfingData_provider.Password);
		loginpage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		
		MatterDetailsNewnote matternote = new MatterDetailsNewnote(driver);
		matternote.clickOnMatterViewAll();
		matternote.ClickonNote();
		
		
	 }  catch (Exception e) {                                                                            
   	  Library.addScreenshotToList(driver, "Failure Screenshot");
   	    Library.errorUrls.add(driver.getCurrentUrl());
   	   System.out.println("Issue in add notes");                                          
   }                                                                                                  
	}                                                                                               
                                                                                                      
@AfterTest
public void sendEmailAfterExecution() throws MessagingException {
if (!Library.errorUrls.isEmpty()) {
   // String subject = "All cases -Patrol Automation";
    String message = "please check Issue coming to create Notes on matters details page. Please check the attached report.";
    String subject = "Company Name: " + Library.companyName + ":- Create Notes ON Matters details page";
    
    EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
} else {
    System.out.println("Add notes in matters details successfully");
}
}


		
	}
	

