package Patrol.Test;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;

import Patrol.Page.LoginPage;
import Patrol.Page.casedetailpage;
import Patrol.Page.newcasedetailscheck;
import Patrol.Page.testaddcasepage;
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
@Epic("All cases")
@Feature("Verify All cases")
public class checkCaseDetails extends NewBaseTest{
	
@Test(description = "Verify All Added Cases")
@Severity(SeverityLevel.CRITICAL)
@Description("This test verifies all added cases open successfully")
public void allcasedetails() throws InterruptedException, IOException, MessagingException {
    LoginPage loginpage = new LoginPage(driver);
    loginpage.setEmail(ConfingData_provider.Email);
    loginpage.setPassword(ConfingData_provider.Password);
    loginpage.performAction();

    DashBoardPage dashBoardpage = new DashBoardPage(driver);
    dashBoardpage.clickOncompany("Alembic");

    newcasedetailscheck page = new newcasedetailscheck(driver);
    page.checkcases();

    // Error Handling
    if (!Library.errorUrls.isEmpty()) {
        System.out.println("Case verification failed on some pages");
        
        AllureListeners.captureScreenshot(driver, "Error in this case");
        Assert.fail("Test Case Failed: Some cases threw errors");
    } else {
        System.out.println("All Cases Verified Successfully!");
    }
}

@AfterTest
public void sendEmailAfterExecution() throws MessagingException {
    if (!Library.errorUrls.isEmpty()) {
       // String subject = "All cases -Patrol Automation";
        String message = "please check Issue coming while open these cases. Please check the attached report.";
        String subject = "Company Name: " + Library.companyName + " All Cases";
        
        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
    } else {
        System.out.println("All cases opened successfully");
    }
}
}


