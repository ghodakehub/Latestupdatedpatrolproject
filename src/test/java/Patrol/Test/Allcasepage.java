package Patrol.Test;


import java.net.MalformedURLException;

import org.testng.annotations.Test;

import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.Addcasepage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;

import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("All case Page")
@Feature("Verify All cases on page")
public class Allcasepage extends NewBaseTest{


	@Test(description = "Verify All case details page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies all cases details open successfully")
	public void verifyAllCaseDetials() throws InterruptedException, MalformedURLException {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(ConfingData_provider.Email);
		loginpage.setPassword(ConfingData_provider.Password);
		loginpage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Alembic");
		
		AddCases_SC_ByDiaryNumberPage byDiaryNumber = new AddCases_SC_ByDiaryNumberPage(driver);
		byDiaryNumber.clickOnTotalcases();
		
		Addcasepage page = new Addcasepage(driver);
		//page.clickonaddcase();
		page.brokenLink();
		
		
	}
	
	

}
