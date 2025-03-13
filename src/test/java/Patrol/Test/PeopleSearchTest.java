package Patrol.Test;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;

import Patrol.Page.PeopleSearch;
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

@Epic("Contact")
@Feature("Verify Contact")
public class PeopleSearchTest extends NewBaseTest{
	

	@Test(description = "Verify contactSearch Bar and paginations")
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("This test verifies can we search contact successfully")
	
	public void ContactSearchAndPaginations() throws InterruptedException {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(ConfingData_provider.Email);
		loginpage.setPassword(ConfingData_provider.Password);
		loginpage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		
		PeopleSearch people  = new PeopleSearch(driver);
		people.clickonpeople();
		people.verifyPaginationAndErrors2();
		people.enterSearchKeyword("NTPC_COMAPNY AutomationTest");
		
		
		  
        if (!Library.errorUrls.isEmpty()) {
            System.out.println(" Errors Found in Search Results!");
            AllureListeners.captureScreenshot(driver, "Search Error");
            Assert.fail("Test Case Failed: Errors in search results pagination.");
        } else {
            System.out.println("Search and Pagination Verified Successfully!");
        }
    }

    @AfterTest
    public void sendEmailAfterExecution() throws MessagingException {
        if (!Library.errorUrls.isEmpty()) {
            String message = "Please check Contact. Errors founds on pagination. See attached report.";
            String subject = "Company Name: " + Library.companyName + " - Contact Paginations";

            // Send email with failed URLs and screenshots
            EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
        } else {
            System.out.println(" Search and Pagination executed successfully without errors.");
        }
    }
	}
	


