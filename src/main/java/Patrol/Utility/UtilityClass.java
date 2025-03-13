package Patrol.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class UtilityClass {
	
	
	public String getTestData(int row , int coloumn) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(BaseTest.excelsheet);
		 Sheet sh = WorkbookFactory.create(file).getSheet("Sheet2");
		String value = sh.getRow(row).getCell(coloumn).getStringCellValue();
		return value;
		
	}
	
 /*	public  static void Capaturescreenshot(WebDriver driver , String tcid) throws IOException 
	{
		
		Date currentdate=new Date();
		//System.out.println(currentdate);
		String screenshotfilename=currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotfilename);
		 File screenshotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile, new File(".//Screenshot//"+screenshotfilename+".png"));
		
		
		
	}*/
	
	public  static String Capaturescreenshot(WebDriver driver , String screenshots) throws IOException 
	{
		
		 String dateName= new SimpleDateFormat("yyyy/MMddhmmss").format(new Date());
		 
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File source=ts.getScreenshotAs(OutputType.FILE);
		 String destination= System.getProperty("user.dir")+"/FailedTestScreenshots/" +screenshots +dateName+".png";
		 
		 File finalDestination =new File(destination);
		FileUtils.copyFile(source, finalDestination);
		 
		 return destination;
		
	}

		
	
	
	
	
	
	

}
