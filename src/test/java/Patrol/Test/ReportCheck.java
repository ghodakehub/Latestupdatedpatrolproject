package Patrol.Test;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.Notification_Page;
import Patrol.Page.ReportsCheck;
import Patrol.Utility.AllureListeners;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class ReportCheck  extends NewBaseTest {
	

	
    @Test(description = "Verify Reports tabs")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify all Reports")
    public void verifyreportstabs() throws IOException, MessagingException {
    	Allure.step("Step 1: Perform Login with valid credentials");
    	LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(ConfingData_provider.Email);
		loginpage.setPassword(ConfingData_provider.Password);
		loginpage.performAction();
		Allure.step("Step 2: select company navigate to Dashboard");
        DashBoardPage dashBoardpage = new DashBoardPage(driver);
        dashBoardpage.clickOncompany("Pharma limited");
        Allure.step("Step 3: Verify reports tabs");
        ReportsCheck report =new ReportsCheck(driver);
        report.ClickOnReports();
        report.VerifyAllReports();
    
    	if (!Library.errorUrls.isEmpty()) {
            System.out.println("Reports Page Verification Failed!");
            AllureListeners.captureScreenshot(driver, "Reports tabs Error");
            Assert.fail("Test Case Failed: Reports contains errors.");
        } else {
            System.out.println("Reports tabs Verified Successfully!");
        }
    }

    @AfterTest
    public void sendEmailAfterExecution() throws MessagingException {
        if (!Library.errorUrls.isEmpty()) {
            String message = "Please check the Reports. issue is coming while open ReportsTabs  , See the attached url for details.";
            String subject = "Company Name: " + Library.companyName + " - Reports";

            // Send email with failed URLs and screenshots
            EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
        } else {
            System.out.println("Reports tabs Page opened successfully, no errors found.");
        }
    }}



		


