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
import Patrol.Page.MatterPage;
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

@Epic("Matters")
@Feature("Verify Matters")
public class MatterforDrat  extends NewBaseTest{
	

	@Test(description = "Verify New Matter Creation for Tribunal drat court")
    @Severity(SeverityLevel.CRITICAL) // Critical Priority
    @Description("This test verifies that user is able to create a new matter for drat court with all required fields.")
    
    public void CreateMattersforDratCourts() {
        LoginPage loginpage = new LoginPage(driver);
        
            Allure.step("Step 1: Enter Email Address");
            loginpage.setEmail(ConfingData_provider.Email);

            Allure.step("Step 2: Enter Password");
            loginpage.setPassword(ConfingData_provider.Password);

            Allure.step("Step 3: Perform Login Action");
            loginpage.performAction();

            DashBoardPage dashBoardpage = new DashBoardPage(driver);
            Allure.step("Step 4: Click on Company Legitquest");
            dashBoardpage.clickOncompany("Legitquest");

            MatterPage matterPage = new MatterPage(driver);
            Allure.step("Step 5: Navigate to Matter View All Page");
            matterPage.clickOnMatterViewAll();

            Allure.step("Step 6: Verify Task Bar of Matters");
            matterPage.verifyTaskBarOfMatters();

            Allure.step("Step 7: Click on New Matter Button");
            matterPage.clickOnNewMatterButton();

            Allure.step("Step 8: Select Tribunal Court");
            matterPage.selectCourt("Tribunals");

            Allure.step("Step 9: Select Sub Court DRAT");
            matterPage.selectSubCourt("DRAT");

            Allure.step("Step 10: Select Case from Dropdown");
            matterPage.selectSearchCaseDropDown("B S RAVISHANKAR vs CORPORATION BANK");

            Allure.step("Step 11: Click Yes to Change Button");
            matterPage.clickOnYesChangeButton();

            Allure.step("Step 12: Click Next Button");
            matterPage.clickOnNextButton();

            Allure.step("Step 13: Select People");
            matterPage.selecpeople("Vikas");

            Allure.step("Step 14: Select Organisation");
            matterPage.selectOrganisation("test2");

            Allure.step("Step 15: Select Practice Area");
            matterPage.selectpracticearea("Tax");

            Allure.step("Step 16: Select Assign User");
            matterPage.selecassinguser("pratiksha shinde");

            Allure.step("Step 17: Select Department");
            matterPage.selectdept("testing department");

            Allure.step("Step 18: Enter Data");
            matterPage.enterdata();

            Allure.step("Step 19: Enter Status - Open");
            matterPage.enterstatus("Open");

            Allure.step("Step 20: Select Flat Rate Button");
            matterPage.clickbtn("Flat Rate");

            Allure.step("Step 21: Verify Error Message if any");
            matterPage.getErrorMessage();

            // Call the error message check method
            boolean errorFound = matterPage.getErrorMessage();

            // Fail the test in Allure if an error is found
            if (errorFound) {
                Assert.fail(" Test Failed: Error message found on the Matter Detail Page.");
            } else {
                System.out.println("Test Passed: No error message found.");
            }

        }                                                                                   
                                                                                                     
	@AfterTest
	public void sendEmailAfterExecution() throws MessagingException {
	    if (!Library.errorUrls.isEmpty()) {
	       // String subject = "All cases -Patrol Automation";
	        String message = "please check matters issue coming after create matters for Drat courts. Please check the attached screenshot.";
	        String subject = "Company Name: " + Library.companyName + " :- Mattersc(For Drat cases)";
	        
	        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
	    } else {
	        System.out.println("Matter create for drat courts successfully");
	    }
    }
}





	
