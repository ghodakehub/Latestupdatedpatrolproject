package Patrol.Test;

import Patrol.Page.Patrol_Reports;

import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;

import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Reports")
@Feature("Verify Reports")
public class Patro_ReportTest extends NewBaseTest {
	
	
	


	 @Test(description = "Verify all Reports")
	 @Severity(SeverityLevel.CRITICAL)
	 @Description("This test verifies all Reports tabs open successfully")
	public void verifyreport() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();

		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		
		Patrol_Reports opt= new Patrol_Reports(driver);
		opt.testNavigationOptions();
	}
	
	
}

