package Patrol.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Patrol.Utility.Library;

public class searchcasehc extends BasePage {
	

	public searchcasehc (WebDriver driver) {
		super(driver);
		
	}
	
	

	@FindBy (xpath = "(//*[@id=\"content\"]/div/form/div/div/div/div[2]/button")
	private WebElement filter;
	
	@FindBy (id = "forum")
	private WebElement selectfourm;
	
	
	@FindBy (id = "court")
	private WebElement selectcourt;
	
	
	@FindBy (xpath = "//*[@id=\"filterDataForm\"]/div[2]/div/div/button[1]")
	private WebElement searchtbn;
	
	
	@FindBy (xpath = "//table[@id='tableBody']//tr/td/a")
	private WebElement firstlink;
	
  
	    public void applyHighCourtFilter() {
            
    
	    	filter.click();
          
           
            Select forumDropdown = new Select(selectfourm);
            forumDropdown.selectByVisibleText("High Court");

            Select courtDropdown = new Select(selectcourt);
            courtDropdown.selectByVisibleText("Sub Courts");

           
            searchtbn. click();
        }

      

		public void openFirstCase() {
           
			firstlink.click();
        }
    }

	    