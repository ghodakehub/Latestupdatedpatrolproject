package Patrol.Test;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.CheckDetailsOf_AddedFirm;
import Patrol.Page.LoginPage;
import Patrol.Utility.AllureListeners;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Add Firm")
@Feature("Verify all added firms")
public class CheckAll_AddedFirms extends NewBaseTest {

	
	@Test(description = "Verify Added Firms")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies user can open added firms sucessfully")
	
	public void verifyCauseList() throws IOException, MessagingException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();
		
		CheckDetailsOf_AddedFirm firm= new CheckDetailsOf_AddedFirm(driver);
		firm.clickOnCauseList();
		firm.verifyFirmsInTable();
		   
        // Error Handling
           if (!Library.errorUrls.isEmpty()) {
               System.out.println("Add firms verification failed");
               
               AllureListeners.captureScreenshot(driver, "Error coming while open this Firms");
               Assert.fail("Test Case Failed: Add firms");
           } else {
               System.out.println("All add firms open Successfully!");
           }
	 }

       @AfterTest
       public void sendEmailAfterExecution() throws MessagingException {
           if (!Library.errorUrls.isEmpty()) {
              // String subject = "All cases -Patrol Automation";
               String message = "please check Issue coming while open this company. Please check the attached Urls.";
               String subject = "Company Name: " + Library.companyName + " Add firms";
               
               EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
           } else {
               System.out.println("All Firms are opened successfully");
           }
       }
       }

	




