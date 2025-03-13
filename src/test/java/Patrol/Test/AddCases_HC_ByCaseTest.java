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
import Patrol.Page.AddCase_HC_ByCasePage;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.UtilityClass;

public class AddCases_HC_ByCaseTest extends BaseTest {

	
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
	
	public void verifyAddCases_HC_ByCase() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();
		
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOncompany("Legitquest");
		
		AddCases_SC_ByDiaryNumberPage byDiaryNumber = new AddCases_SC_ByDiaryNumberPage(driver);
		byDiaryNumber.clickOnTotalcases();
		byDiaryNumber.clickOnAddCases();
		
		AddCase_HC_ByCasePage byCasePage = new AddCase_HC_ByCasePage(driver);
		byCasePage.clickOnHighCourt();
		byCasePage.selectCourt("High Court of Karnataka");
		byCasePage.selectBench("Principal Bench at Bengaluru");
		byCasePage.selectCaseType("WP(Writ Petition)-144");
		byCasePage.enterCaseNo("1");
		byCasePage.selectYear("2013");
		byCasePage.clickOnSearchForCase();
		byCasePage.clickOnCheckBox();
		byCasePage.clickOnAddCases();
		byCasePage.clickOnOkButton();		
		
		
		
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
