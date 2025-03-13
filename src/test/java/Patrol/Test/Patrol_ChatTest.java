package Patrol.Test;


import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.Patrol_ChatPage;
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

@Epic("AI_CHAT")
@Feature("Verify AI-CHAT")
public class Patrol_ChatTest extends NewBaseTest {
	

	@Test(description = "Verify AIChat")
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("This test verifies AIChat open successfully")

	
	public void verifychat() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();

		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		
		Patrol_ChatPage chat= new Patrol_ChatPage(driver);
		chat.CheckAI_Chat();
		
		
		if (!Library.errorUrls.isEmpty()) {
            System.out.println("Chat Page Verification Failed!");
            AllureListeners.captureScreenshot(driver, "Chat Page Error");
            Assert.fail("Test Case Failed: Chat Page contains errors.");
        } else {
            System.out.println("Chat Page Verified Successfully!");
        }
    }

    @AfterTest
    public void sendEmailAfterExecution() throws MessagingException {
        if (!Library.errorUrls.isEmpty()) {
            String message = "Please check the AI chat. issue is coming while open my casuelist  , See the attached url for details.";
            String subject = "Company Name: " + Library.companyName + " - AIchat";

            // Send email with failed URLs and screenshots
            EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
        } else {
            System.out.println("AI chat Page opened successfully, no errors found.");
        }
    }

	}
	

