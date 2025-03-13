package Patrol.Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ExtentReportBasic.ExtentReportManager;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.AddCases_Tribunal_ByCasePage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;
import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.UtilityClass;

public class AddCases_Tribunal_ByCaseTest extends BaseTest{

	
	
	
	
	
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
	
//	@DataProvider(name = "excelData")
//	public Object[][] testExcel() throws IOException {
//
//		String filepath = System.getProperty("user.dir") + "\\TestData\\Data.xlsx";
////		String filepath = System.getProperty("user.dir") + "\\TestData\\YTP_Reprice.xlsx";
//		FileInputStream fis = new FileInputStream(filepath);
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet = wb.getSheet("YTP");
//		int rowCount = sheet.getLastRowNum();
//		int colCount = 63;
//		Object[][] dataObj = new Object[rowCount][colCount];
//
//		for (int i = 1; i <= rowCount; i++) {
//			Row row = sheet.getRow(i);
//			for (int j = 0; j < colCount; j++) {
//				int rowNum = i;
//				rowNum--;
//				dataObj[rowNum][j] = row.getCell(j).toString();
//			}
//		}
//		return dataObj;
//	}
//	
	
	@Test
	
	public void verifyTribunals() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();
		
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOncompany("Legiteye");
		
		AddCases_SC_ByDiaryNumberPage byDiaryNumber = new AddCases_SC_ByDiaryNumberPage(driver);
		byDiaryNumber.clickOnTotalcases();
		byDiaryNumber.clickOnAddCases();
		
		
		AddCases_Tribunal_ByCasePage byCase = new AddCases_Tribunal_ByCasePage(driver);
		byCase.clickOnTribunals();
		byCase.selectCourt("NCLT","Chennai","Maharshtra" );
	//	byCase.selectCourt("NCLT");
		byCase.selectYear("2021");
		byCase.enterPartyName("State");
		byCase.clickOnSearchButton();
		
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
