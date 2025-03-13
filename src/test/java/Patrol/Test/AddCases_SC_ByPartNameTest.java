package Patrol.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ExtentReportBasic.ExtentReportManager;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.AddCases_SC_ByPartyNamePage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.UtilityClass;

public class AddCases_SC_ByPartNameTest extends BaseTest{
	
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
	
	public void verifyAddCase_SC_ByPartyType() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();

		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Alembic");

		AddCases_SC_ByDiaryNumberPage byCaseType = new AddCases_SC_ByDiaryNumberPage(driver);
		byCaseType.clickOnTotalcases();
		byCaseType.clickOnAddCases();
		byCaseType.clickOnSupremeCourt();
		
		AddCases_SC_ByPartyNamePage byPartyType = new AddCases_SC_ByPartyNamePage(driver);
		byPartyType.clickOnPatyName();
		byPartyType.enterValueOnPartyNameTab("icici");
		byPartyType.selectYear("2023");
		byPartyType.clickOnSearchCases();
		byPartyType.selectCases(5);
		
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
