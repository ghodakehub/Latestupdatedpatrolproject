package Patrol.Test;


import org.testng.annotations.Test;

import Patrol.Page.CauseListPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;

import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class CauseListTest extends NewBaseTest {



	@Test(description = "Verify My casueList")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies My Casuelist")
	
	public void verifyCauseList() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(ConfingData_provider.Email);
		loginPage.setPassword(ConfingData_provider.Password);
		loginPage.performAction();

		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");

		CauseListPage causeList = new CauseListPage(driver);
		causeList.clickOnCauseList();
		causeList.getHeading();
		causeList.getTableData();
		
		
	}
	
}
