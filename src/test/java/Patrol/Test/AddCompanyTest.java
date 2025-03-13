package Patrol.Test;

import java.net.MalformedURLException;


import org.testng.annotations.Test;
import Patrol.Page.AddCompany;
import Patrol.Page.LoginPage;

import Patrol.Utility.ConfingData_provider;
import Patrol.Utility.NewBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Add Firm")
@Feature("Verification of Added Firm ")

public class AddCompanyTest  extends NewBaseTest{

	
	


	@Test(description = "Verify All Added Firm ")
	@Severity(SeverityLevel.CRITICAL)
	@Description("This test verifies Added Firm one by one is open successfully")
	
	public void documentpage() throws InterruptedException, MalformedURLException {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(ConfingData_provider.Email);
		loginpage.setPassword(ConfingData_provider.Password);
		loginpage.performAction();
		
		
		AddCompany company = new AddCompany(driver);
		company.CheckCompanies();
		
	}
	
		

}
