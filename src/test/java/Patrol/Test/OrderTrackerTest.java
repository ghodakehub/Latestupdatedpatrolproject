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
import Patrol.Page.OrderTracker;
import Patrol.Page.Patrol_OrderTracker;
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

@Epic("OrderTracker")
@Feature("Verify OrderTracker")
public class OrderTrackerTest extends NewBaseTest{

	 @Test(description = "Verify Order Tracker ")
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("This test verifies adding and validating keywords in the Order Tracker")
    public void verifyordertracker() throws IOException, MessagingException, InterruptedException {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.setEmail(ConfingData_provider.Email);
        loginpage.setPassword(ConfingData_provider.Password);
        loginpage.performAction();
        Allure.step("Login Successfully");

        DashBoardPage dashBoardpage = new DashBoardPage(driver);
        dashBoardpage.clickOncompany("Legitquest");
        Allure.step("Selected Company");
        
        Patrol_OrderTracker track= new Patrol_OrderTracker(driver);
        track.checkordertrack();
        
        Allure.step("Selected order Tracker and add keyword");
        OrderTracker order= new OrderTracker(driver);
        order.addkeywordin_Ordertracker();
	 
     // Error Handling
        if (!Library.errorUrls.isEmpty()) {
            System.out.println("OrderTracker add Keywords failed");
            
            AllureListeners.captureScreenshot(driver, "Error on ordertracker");
            Assert.fail("Test Case Failed: OrderTracker add Keywords");
        } else {
            System.out.println("OrderTracker Verified Successfully!");
        }
    }
    
    @AfterTest
    public void sendEmailAfterExecution() throws MessagingException {
    if (!Library.errorUrls.isEmpty()) {
       // String subject = "All cases -Patrol Automation";
        String message = "please check OrderTracker issue coming to add keywords. Please check the attached report.";
        String subject = "Company Name: " + Library.companyName + ":- OrderTracker";
        
        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
    } else {
        System.out.println("Notification tabs opened successfully");
    }
    }
    }


