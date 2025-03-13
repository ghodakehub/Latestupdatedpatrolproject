package ExtentReportBasic;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
	public static ExtentReports getReports()
	
	{
		
		if(extent==null)
		
		{
			extent = new ExtentReports();
			System.out.println(System.getProperty("user.dir"));
			extent= new ExtentReports();
			spark= new ExtentSparkReporter(System.getProperty("user.dir")+"\\extentreport\\"+getCurrentTime());
			spark.config().setReportName(" Extent Report For PatrolWebSite");
			extent.setSystemInfo("OS","window 10");
			extent.setSystemInfo("Browser:", "Chrome");
			extent.setSystemInfo("Created By :", "Pratiksha Ghodake");
			extent.setSystemInfo("Reproting Manager:", "Rajan Batra sir");
			
			spark.config().setTimeStampFormat("EEEE,MMMM,dd,yyyy,hh:mm a'('zzz')'");
			spark.config().setDocumentTitle("ExtentReport");
			spark.config().setTheme(Theme.DARK);
			spark.config().setEncoding("utf-8");
			
			extent.attachReporter(spark);	
			
			
		}
		return extent;
		
	}
	
	
	 public static ExtentTest createTest(String testName) {
		  ExtentTest test = extent.createTest("Case Error Checker", "Check for error cases and log details");

	        if (extent == null) {
	            throw new IllegalStateException("ExtentReports is not initialized. Call initializeExtentReports() first.");
	        }
	        test = extent.createTest(testName);
	        return test;
	    }
 
 public static ExtentReports getExtent() {
     return extent;
 }
 
 public static ExtentTest getTest() {
     return test;
 }
	
	
	public static String getCurrentTime()
	
	{
		String currentDate= new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
		
	}
	

}
