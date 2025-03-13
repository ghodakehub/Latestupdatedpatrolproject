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

import Patrol.Page.OrderTrackerPaginations;
import Patrol.Page.Patrol_OrderTracker;
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

@Epic("OrderTracker")
@Feature("Verify OrderTracker")
public class OrderTrackerPaginationsTest extends NewBaseTest{

	
	@Test(description = "Verify Order Tracker Paginations")
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("This test verifies paginations in order tracker open successfully")
	public void verifypaginations() throws IOException, MessagingException, InterruptedException {
	    
	        LoginPage loginpage = new LoginPage(driver);
	        loginpage.setEmail(ConfingData_provider.Email);
	        loginpage.setPassword(ConfingData_provider.Password);
	        loginpage.performAction();
	        Allure.step("Login Successfully");

	        DashBoardPage dashBoardpage = new DashBoardPage(driver);
	        dashBoardpage.clickOncompany("Pharma limited");
	        Allure.step("Selected Company");

	        Patrol_OrderTracker track = new Patrol_OrderTracker(driver);
	        track.checkordertrack();
	        Allure.step("Checked Order Tracker");

	        OrderTrackerPaginations tracker = new OrderTrackerPaginations(driver);
	        tracker.verifyOrdertrackerPaginations();
	        Allure.step("Verified Order Tracker Paginations");
	       

	     // Error Handling
	        if (!Library.errorUrls.isEmpty()) {
	            System.out.println("OrderTracker paginations verifications failed");
	            
	            AllureListeners.captureScreenshot(driver, "Error on this page");
	            Assert.fail("Test Case Failed: OrderTrackerPaginations");
	        } else {
	            System.out.println("All paginations of ordertracker Verified Successfully!");
	        }
	    }
	    
	    @AfterTest
	    public void sendEmailAfterExecution() throws MessagingException {
	    if (!Library.errorUrls.isEmpty()) {
	       // String subject = "All cases -Patrol Automation";
	        String message = "please check OrderTracker , issue coming on this page. Please check the attached urls.";
	        String subject = "Company Name: " + Library.companyName + ":- OrderTracker Paginations";
	        
	        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
	    } else {
	        System.out.println("Ordertracker paginaitons opened successfully");
	    }
	    }
}

