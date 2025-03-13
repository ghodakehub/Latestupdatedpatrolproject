package Patrol.Test;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ExtentReportBasic.ExtentReportManager;
import Patrol.Page.AddCases_DC_ByCasePage;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.UtilityClass;

public class AddCases_DC_ByCaseTest extends BaseTest {
	UtilityClass utility;
	String tcid;
	
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
	
	@BeforeMethod
	public void initialize()
	{
	  extent=ExtentReportManager.getReports();
	  test= extent.createTest("Verify document module"); 
		
	}
	
	@Test
	
	public void verifyByCase() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();
		
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOncompany("Legiteye");
		
		AddCases_SC_ByDiaryNumberPage byDiaryNumber = new AddCases_SC_ByDiaryNumberPage(driver);
		byDiaryNumber.clickOnTotalcases();
		byDiaryNumber.clickOnAddCases();
		
		AddCases_DC_ByCasePage byCasePage = new AddCases_DC_ByCasePage(driver);
		byCasePage.clickOnDistrictCourts();
		byCasePage.selectState("Karnataka");
		byCasePage.selectDistrict("Bengaluru");
		byCasePage.selectForum("CHIEF METROPOLITAN MAGISTRATE COURT, BENGALURU");
		byCasePage.selectCaseType("C.C. - CRIMINAL CASES");
		byCasePage.enterCaseNo("2");
		byCasePage.selectYear("2023");
		byCasePage.clickOnsearchButton();
		byCasePage.clickOnCheckBox();
		byCasePage.clickOnAddCases();
		
	}
	@AfterMethod()
	public void aftermethod(ITestResult result) throws  IOException
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test case is failed"+result.getName());
			test.log(Status.FAIL, "test case is failed"+result.getThrowable());
			String screenshot=  UtilityClass.Capaturescreenshot(driver,result.getName() );
		
			test.log(Status.FAIL,"test"+ test.addScreenCaptureFromPath(screenshot));
		
		}
		
		else if(result.getStatus()== ITestResult.SKIP){
			
			
			test.log(Status.SKIP, "test case is skipped"+result.getName());
			

		}extent.flush();
		driver.quit();	
		}

}
