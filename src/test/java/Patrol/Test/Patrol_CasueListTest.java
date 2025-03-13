package Patrol.Test;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.Patrol_CauseList;
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
public class Patrol_CasueListTest extends NewBaseTest {

	
	@Test(description = "Verify MyCasueList")
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("This test verifies MyCauseList open successfully")

	
	public void verifycauselist() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();

		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		
		Patrol_CauseList cause= new Patrol_CauseList(driver);
		cause.CheckCauselist();
		  if (!Library.errorUrls.isEmpty()) {
	            System.out.println("Causelist Page Verification Failed!");
	            AllureListeners.captureScreenshot(driver, "Causelist Page Error");
	            Assert.fail("Test Case Failed: causelist Page contains errors.");
	        } else {
	            System.out.println("CauseList Page Verified Successfully!");
	        }
	    }

	    @AfterTest
	    public void sendEmailAfterExecution() throws MessagingException {
	        if (!Library.errorUrls.isEmpty()) {
	            String message = "Please check the CauseLsit page. issue is coming while open my casuelist  , See the attached url for details.";
	            String subject = "Company Name: " + Library.companyName + " - MyCasuelist";

	            // Send email with failed URLs and screenshots
	            EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
	        } else {
	            System.out.println("Casuelist Page opened successfully, no errors found.");
	        }
	    }
	
	

}
