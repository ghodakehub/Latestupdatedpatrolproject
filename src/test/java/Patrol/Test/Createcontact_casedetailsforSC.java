package Patrol.Test;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Patrol.Page.CaseDetailscreatematter;
import Patrol.Page.CreateContact_CaseDetailspage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.AllureListeners;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.EmailUtility;
import Patrol.Utility.Library;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class Createcontact_casedetailsforSC extends NewBaseTest{
	
@Test(description = "Verify All Contact tab on case details page for Supreme court Cases")
@Severity(SeverityLevel.CRITICAL)
@Description("This test verifies can we add contact in case details page successfully")
public void allcasedetails() throws InterruptedException, IOException, MessagingException {
	try {
    LoginPage loginpage = new LoginPage(driver);
    loginpage.setEmail(ConfingData_provider.Email);
    loginpage.setPassword(ConfingData_provider.Password);
    loginpage.performAction();
    DashBoardPage dashBoardpage = new DashBoardPage(driver);
    dashBoardpage.clickOncompany("Pharma limited");
    Allure.step("Step 5: Click on contact tab fill up required fields");
    CaseDetailscreatematter create = new CaseDetailscreatematter(driver);
    create.searchAndOpenCase("SHANI @ MAHENDRA vs. THE STATE OF UTTAR PRADESH");
    CreateContact_CaseDetailspage contact= new CreateContact_CaseDetailspage(driver);
    contact.createcontact("Contact", "Create Contact");
    contact.createcontacts2("Company","HCL", "8867907763", "XYZ@gmail.com", "Manufacturing", "Buldhana");
    
    boolean verifycontact =contact.verifyaddcontact("HCL");

    if (!verifycontact) {
    	
    	Library.addScreenshotToList(driver, "contactfailed.png");

    	
        AllureListeners.captureScreenshot(driver, "contact.png");
        String url = driver.getCurrentUrl();
      Library.errorUrls.add(url);
        Allure.addAttachment("URL", url);
        
        String message = "please check Issue coming while create contact . Please check the attached report.";
        String subject = "Company Name: " + Library.companyName + " contact tab";
        
        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
        Assert.fail(" Test Failed: Contact creation verification failed!");
    }

    Allure.step("Test Case Passed: contact is successfully created and verified.");
} catch (Exception e) {
  
    System.out.println("Test failed: " + e.getMessage());
}
}



}
