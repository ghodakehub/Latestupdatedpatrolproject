package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.MatterPage;

import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Matters")
@Feature("Verify Matter")
public class MattersTest extends NewBaseTest{

	@Test(description = "Verify new Matters")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies can we add matters successfully")
	public void makeNewMatter() {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(ConfingData_provider.Email);
		loginpage.setPassword(ConfingData_provider.Password);
		loginpage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Legitquest");
		
		MatterPage matterPage = new MatterPage(driver);
		matterPage.clickOnMatterViewAll();
		matterPage.verifyTaskBarOfMatters();
		matterPage.clickOnNewMatterButton();
		matterPage.selectCourt("District Case");
		matterPage.selectSearchCaseDropDown("NANAK SINGH vs GURDIP SINGH");
		matterPage.clickOnYesChangeButton();
		matterPage.clickOnNextButton();
		matterPage.selecpeople("Yashoda");
		matterPage.selectOrganisation("test1");
		matterPage.selectpracticearea("Criminal");
		matterPage.selecassinguser("pratiksha shinde");
		matterPage.selectdept("testing department");
		matterPage.enterdata();
		matterPage.enterstatus("Pending");
		matterPage.clickbtn("Flat Rate");
		
		
		
	}


	
	
}
