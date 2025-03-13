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
import Patrol.Page.checkvieworders;
import Patrol.Page.newordertrackerorderview;
import Patrol.Utility.AllureListeners;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.ForMultiplemailReceipent;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Check_OrderTracker_viewOrder extends NewBaseTest{

	 List<String> errorUrls = new ArrayList<>(); // Collect Failed URLs    
	    String screenshotPath;                                             
	                                                                       
	@Test(description = "Verify all orders on Ordertracker page")
 @Severity(SeverityLevel.CRITICAL)
 @Description("Verify All orders open Successfully")
 public void verifyMattersOnInvoicePage() {
     try {
         Allure.step("Step 1: Perform Login with valid credentials");
         LoginPage loginpage = new LoginPage(driver);
         loginpage.setEmail(ConfingData_provider.Email);
         loginpage.setPassword(ConfingData_provider.Password);
         loginpage.performAction();

         Allure.step("Step 2: Navigate to Dashboard and Select Company");
         DashBoardPage dashBoardpage = new DashBoardPage(driver);
         dashBoardpage.clickOncompany("Legitquest");
         
         Allure.step("Step 4: Verify all view orders");
         newordertrackerorderview order= new newordertrackerorderview(driver);
         order.verifyOrderPages2();

     }                                                                                                         
     catch (Exception e) {                                                                            
     	  Library.addScreenshotToList(driver, "Failure Screenshot");
 	    Library.errorUrls.add(driver.getCurrentUrl());
 	    throw e;                                            
 }                                                                                                  
	}                                                                                               
                                                                                                    
@AfterTest
 public void sendEmailAfterExecution() throws MessagingException {
     if (!Library.errorUrls.isEmpty()) {
         String subject = "OrderTracker (Orders) - Patrol Automation";
         String message = "Please check orderTracker, below attachecd url of orders issue coming on it";
         EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
     } else {
         System.out.println("All tabs open successfully");
     }
 }           
	
	    }    

