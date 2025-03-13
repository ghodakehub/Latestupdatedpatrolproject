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
import Patrol.Page.AddCases_SC_ByAdvocateNamePage;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.UtilityClass;

public class AddCases_SC_ByAdvocateNameTest extends BaseTest {
	
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
	
	
	public void verifyAddCases_SC_ByAdvocateName() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();

		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legiteye");

		AddCases_SC_ByDiaryNumberPage byCaseType = new AddCases_SC_ByDiaryNumberPage(driver);
		byCaseType.clickOnTotalcases();
		byCaseType.clickOnAddCases();
		byCaseType.clickOnSupremeCourt();
		
		AddCases_SC_ByAdvocateNamePage byAdvocateName = new AddCases_SC_ByAdvocateNamePage(driver);
		byAdvocateName.clickOnByAdvocateName();
		byAdvocateName.clickOnAdvocateOnRecord();
		byAdvocateName.enterAdvocateOnRecords("Aashish Gupta");
		
		
		
		
		//// pending work ////
		
		
		
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
