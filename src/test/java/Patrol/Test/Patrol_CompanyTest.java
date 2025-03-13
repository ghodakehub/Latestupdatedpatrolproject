package Patrol.Test;


import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;

import Patrol.Page.Patrol_Company;
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

@Epic("COMPANY")
@Feature("Verify Company")

public class Patrol_CompanyTest extends NewBaseTest {
	

	

	@Test(description = "Verify Company")
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("This test verifies company open successfully")


	
	public void verifycompany() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();

		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		
		Patrol_Company company= new Patrol_Company(driver);
		company.CheckSwitchCompany();
		
		if (!Library.errorUrls.isEmpty()) {
            System.out.println("company Page Verification Failed!");
            AllureListeners.captureScreenshot(driver, "Company Page Error");
            Assert.fail("Test Case Failed: company Page contains errors.");
        } else {
            System.out.println("company Page Verified Successfully!");
        }
    }

    @AfterTest
    public void sendEmailAfterExecution() throws MessagingException {
        if (!Library.errorUrls.isEmpty()) {
            String message = "Please check the comapy. issue is coming while open company  , See the attached url for details.";
            String subject = "Company Name: " + Library.companyName + " - Company";

            // Send email with failed URLs and screenshots
            EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
        } else {
            System.out.println("Company Page opened successfully, no errors found.");
        }
    }

	}
	
	

