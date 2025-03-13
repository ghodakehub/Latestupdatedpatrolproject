package Patrol.Test;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.SmokeSuite;
import Patrol.Page.smokesuite2formanagecases;
import Patrol.Utility.AllureListeners;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class smokesuiteofmanagecase extends NewBaseTest {
	

	@Test(description = "Verify SmokeSuite")
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("This test verifies when click on submodules of Mange Cases are open successfully")

	
	
	public void verifyordertracker() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();

		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		
		smokesuite2formanagecases suite= new smokesuite2formanagecases(driver);
		suite.verifyManageCasesSubmodules();
		
		if (!Library.errorUrls.isEmpty()) {
            System.out.println("Smoketest Verification Failed!");
            AllureListeners.captureScreenshot(driver, "Error coming to open module");
            Assert.fail("Test Case Failed: smoke suite errors.");
        } else {
            System.out.println("smoke suite Verified Successfully!");
        }
    }

    @AfterTest
    public void sendEmailAfterExecution() throws MessagingException {
        if (!Library.errorUrls.isEmpty()) {
            String message = "Please check issue coming to open this module , See the attached url for details.";
            String subject = "Company Name: " + Library.companyName + "SmokeSuite";

            // Send email with failed URLs and screenshots
            EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
        } else {
            System.out.println("All modules open successfully, no errors found.");
        }
    }
	}
	





