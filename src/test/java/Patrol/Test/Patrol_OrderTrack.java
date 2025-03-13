package Patrol.Test;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.Patrol_OrderTracker;
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

@Epic("OrderTracker")
@Feature("Verify OrderTracke")
public class Patrol_OrderTrack extends NewBaseTest {
	

	@Test(description = "Verify OrderTracker")
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("This test verifies when click on OrderTracker open successfully")

	
	
	public void verifyordertracker() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();

		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		
		Patrol_OrderTracker track= new Patrol_OrderTracker(driver);
		track.checkordertrack();
		
		if (!Library.errorUrls.isEmpty()) {
            System.out.println("OrderTracker Page Verification Failed!");
            AllureListeners.captureScreenshot(driver, "OrderTracker Page Error");
            Assert.fail("Test Case Failed: OrderTracker Page contains errors.");
        } else {
            System.out.println("OrderTracker Page Verified Successfully!");
        }
    }

    @AfterTest
    public void sendEmailAfterExecution() throws MessagingException {
        if (!Library.errorUrls.isEmpty()) {
            String message = "Please check the OrderTracker. issue is coming while open OrderTracker  , See the attached url for details.";
            String subject = "Company Name: " + Library.companyName + " - Invoice";

            // Send email with failed URLs and screenshots
            EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
        } else {
            System.out.println("OrderTracker Page opened successfully, no errors found.");
        }
    }
	}
	
	

