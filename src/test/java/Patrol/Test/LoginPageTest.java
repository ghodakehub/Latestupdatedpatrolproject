package Patrol.Test;



import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.LoginPage;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Login Website")
@Feature("Login page")
public class LoginPageTest extends NewBaseTest {
	

	   @Test(description = "Verify Login Page Functionality with Valid Credentials")
	    @Severity(SeverityLevel.CRITICAL)
	    @Description("This test verifies if the user is able to log in with valid email and password.")
	   
	    public void Verifyloginpage() {
		   try {
	        Allure.step("Step 1: Enter Email Address");
	        LoginPage loginpage = new LoginPage(driver);
	        loginpage.setEmail(ConfingData_provider.Email);

	        Allure.step("Step 2: Enter Password");
	        loginpage.setPassword(ConfingData_provider.Password);

	        Allure.step("Step 3: Click on Login button");
	        loginpage.performAction();

	        Allure.step("Step 4: Verify Successful Login");
	        Assert.assertEquals(driver.getCurrentUrl(), "https://patrol.legitquest.com/home", "Login Verification Failed");
	    }
		   catch (Exception e) {                                                                            
	        	  Library.addScreenshotToList(driver, "Failure Screenshot");
	        	    Library.errorUrls.add(driver.getCurrentUrl());
	        	    System.out.println("Issue in login page");                                           
		    }                                                                                                  
			}                                                                                               
		                                                                                                       
	   @AfterTest
   	public void sendEmailAfterExecution() throws MessagingException {
   	    if (!Library.errorUrls.isEmpty()) {
   	       // String subject = "All cases -Patrol Automation";
   	        String message = "please check Patrol website is not working. Please check the attached screenshot.";
   	        String subject = "Patrol :- Login Page";
   	        
   	        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
   	    } else {
   	        System.out.println("Login  successfully");
   	    }
       }
	}

