package Patrol.Test;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.Patrol_CalendarPage;
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
@Epic("Calendar")
@Feature("Verify Calendar")


public class Patrol_CalendarTest extends NewBaseTest {
	

	

	  @Test(description = "Verify Calendar Page Opens Successfully")
	    @Severity(SeverityLevel.CRITICAL)
	    @Description("Verifies if the Calendar page opens without any errors.")
	    public void verifyCalendarPage() throws IOException, MessagingException {
	        // Login
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.setEmail(ConfingData_provider.Email);
	        loginPage.setPassword(ConfingData_provider.Password);
	        loginPage.performAction();

	        // Navigate to Dashboard & Click on Company
	        DashBoardPage dashBoardPage = new DashBoardPage(driver);
	        dashBoardPage.clickOncompany("Legitquest");

	        // Open Calendar Page
	        Patrol_CalendarPage calendarPage = new Patrol_CalendarPage(driver);
	        calendarPage.CheckCalendar();  // Calls the updated CheckCalendar method

	        
	        if (!Library.errorUrls.isEmpty()) {
	            System.out.println("Calendar Page Verification Failed!");
	            AllureListeners.captureScreenshot(driver, "Calendar Page Error");
	            Assert.fail("Test Case Failed: Calendar Page contains errors.");
	        } else {
	            System.out.println("Calendar Page Verified Successfully!");
	        }
	    }

	    @AfterTest
	    public void sendEmailAfterExecution() throws MessagingException {
	        if (!Library.errorUrls.isEmpty()) {
	            String message = "Please check the Calendar page. An issue detected , See the attached url for details.";
	            String subject = "Company Name: " + Library.companyName + " - Calendar";

	            // Send email with failed URLs and screenshots
	            EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
	        } else {
	            System.out.println("Calendar Page opened successfully, no errors found.");
	        }
	    }
	}


