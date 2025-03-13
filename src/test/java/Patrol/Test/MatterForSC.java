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

public class MatterForSC extends  NewBaseTest {

	 List<String> errorUrls = new ArrayList<>();     
	    String screenshotPath;
		

	@Test(description = "Verify Add New Matter For Supreme Court")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test verifies can we add matters for Suprme court successfully")
	public void verifycreatematterfor_SC() {
	    LoginPage loginpage = new LoginPage(driver);
	    try {
	        Allure.step("Step 1: Enter Email Address");
	        loginpage.setEmail(ConfingData_provider.Email);

	        Allure.step("Step 2: Enter Password");
	        loginpage.setPassword(ConfingData_provider.Password);

	        Allure.step("Step 3: Perform Login Action");
	        loginpage.performAction();

	        DashBoardPage dashBoardpage = new DashBoardPage(driver);
	        Allure.step("Step 4: Click on Company");
	        dashBoardpage.clickOncompany("Legitquest");

	        MatterPage matterPage = new MatterPage(driver);
	        Allure.step("Step 5: Navigate to Matter View All Page");
	        matterPage.clickOnMatterViewAll();

	        Allure.step("Step 6: Verify Task Bar of Matters");
	        matterPage.verifyTaskBarOfMatters();

	        Allure.step("Step 7: Click on New Matter Button");
	        matterPage.clickOnNewMatterButton();

	        Allure.step("Step 8: Select Supreme Court");
	        matterPage.selectCourt("Supreme Court");
	        
	        Allure.step("Step 10: Select Case from Dropdown");
	        matterPage.selectSearchCaseDropDown("LT. COL. D. K. HAVANOOR (RETD.) vs. UNION OF INDIA");

	        Allure.step("Step 11: Click Yes to Change Button");
	        matterPage.clickOnYesChangeButton();

	        Allure.step("Step 12: Click Next Button");
	        matterPage.clickOnNextButton();

	        Allure.step("Step 13: Select People from dropdown");
	        matterPage.selecpeople("Hashreen");

	        Allure.step("Step 14: Select Organisation");
	        matterPage.selectOrganisation("test2");

	        Allure.step("Step 15: Select Practice Area");
	        matterPage.selectpracticearea("Bankruptcy");

	        Allure.step("Step 16: Select Assign User");
	        matterPage.selecassinguser("pratiksha shinde");

	        Allure.step("Step 17: Select Department");
	        matterPage.selectdept("production department");

	        Allure.step("Step 18: Enter Data");
	        matterPage.enterdata();

	        Allure.step("Step 19: Enter Status ");
	        matterPage.enterstatus("Pending");

	        Allure.step("Step 20: Select Flat Rate Button");
	        matterPage.clickbtn("Flat Rate");

	        Assert.assertTrue(driver.getCurrentUrl().contains("matters"), "Matter Creation Failed");

	    } catch (Exception e) {                                                                            
	      	  Library.addScreenshotToList(driver, "Failure Screenshot");
	    	    Library.errorUrls.add(driver.getCurrentUrl());
	    	    System.out.println("issue coming to create matter for supreme courts cases");                                          
	    }                                                                                                  
	  	}                                                                                               
	                                                                                                       
	@AfterTest
	public void sendEmailAfterExecution() throws MessagingException {
	    if (!Library.errorUrls.isEmpty()) {
	       // String subject = "All cases -Patrol Automation";
	        String message = "please check Matters , issue coming to create matters for supreme courts. Please check the attached screenshot.";
	        String subject = "Company Name: " + Library.companyName + " :- Matters for Supreme courts";
	        
	        EmailUtility.sendSummaryEmailWithScreenshots(driver, subject, message, Library.errorUrls, Library.screenshotBytesList);
	    } else {
	        System.out.println("matters create for supreme courts successfully");
	    }
    }
}

	  	
	  	    
	    

