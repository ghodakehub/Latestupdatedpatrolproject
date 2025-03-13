package Patrol.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.itextpdf.text.DocumentException;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.Notification_Page;
import Patrol.Utility.AllureListeners;
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
import io.qameta.allure.model.Status;

@Epic("Notification")
@Feature("Verify Notification")

public class Notification_Test extends NewBaseTest {
	

	
    @Test(description = "Verify Notification tabs")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Notification Bar Elements")
    public void verifyNotificationtabs() throws IOException, MessagingException {
    	
    	LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(ConfingData_provider.Email);
		loginpage.setPassword(ConfingData_provider.Password);
		loginpage.performAction();
        DashBoardPage dashBoardpage = new DashBoardPage(driver);
        dashBoardpage.clickOncompany("Legitquest");

        Notification_Page notificationPage = new Notification_Page(driver);
        notificationPage.clickOnNotification();
        notificationPage.verifyNotificationBarElement();
    
    	// Error Handling
        if (!Library.errorUrls.isEmpty()) {
            System.out.println("Notification tabs verifications failed");
            
            AllureListeners.captureScreenshot(driver, "Error on this tab");
            Assert.fail("Test Case Failed: Notification tabs");
        } else {
            System.out.println("All tabs of notification Verified Successfully!");
        }
    }
    
    @AfterTest
    public void sendEmailAfterExecution() throws MessagingException {
    if (!Library.errorUrls.isEmpty()) {
       // String subject = "All cases -Patrol Automation";
        String message = "please check Notification , issue coming to open the tabs. Please check the attached report.";
        String subject = "Company Name: " + Library.companyName + ":- Notification Tabs";
        
        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
    } else {
        System.out.println("Notification tabs opened successfully");
    }
    }
    }


		
	

