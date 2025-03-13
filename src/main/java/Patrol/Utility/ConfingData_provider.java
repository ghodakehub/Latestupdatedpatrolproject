package Patrol.Utility;

public class ConfingData_provider {
	public static String  driverpath="D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
	public static String excelsheet="C:\\Users\\Super\\Downloads\\Patrol\\TestDataExelSheet\\TestData.xlsx";
	
	public static String URL= Library.getConfigueData("URL");
	public static String Email= Library.getConfigueData("Email");
	public static String Password = Library.getConfigueData("Password");
	public static String screenshot = "C:\\Users\\Super\\Downloads\\Patrol\\Screenshot";
	public static String Browser = Library.getConfigueData("Browser");
	public static String Headless = Library.getConfigueData("Headless");

}
