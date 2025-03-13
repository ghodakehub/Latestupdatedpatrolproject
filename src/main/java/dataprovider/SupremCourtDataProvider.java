package dataprovider;

import org.testng.annotations.DataProvider;

public class SupremCourtDataProvider {
    @DataProvider(name = "ByCaseTypeSupremCourtDataProvider")
    public static Object[][] provideDataExternal() {
        return new Object[][] {
        	// case type,case  number,year
            {"ARBITRATION PETITION", "9", "2024"},
            {"CIVIL APPEAL", "18", "2023"},
            {"CONTEMPT PETITION (CIVIL)", "27", "2022"},
            {"CONTEMPT PETITION (CRIMINAL)", "36","2021"},
            {"CRIMINAL APPEAL", "45",""},
            {"CURATIVE PETITION(CIVIL)", "54","2020"},
            {"CURATIVE PETITION(CRL)", "63","2019"},
            {"DEATH REFERENCE CASE", "72","2018"},
            {"DIARY", "","2017"},
            {"DIARYNO AND DIARYYR", "81","2016"},
            {"ELECTION PETITION (CIVIL)", "90","2015"},
            {"FILE NUMBER", "","2013"},
            {"MISCELLANEOUS APPLICATION", "99","2014"},
            {"MOTION(CRL)", "100","2012"},
            {"ORIGINAL SUIT", "109","2011"},
            {"REF. U/A 317(1)", "118","2010"},
            {"REF. U/S 14 RTI", "127","2009"},
            {"REF. U/S 143", "136","2008"},
            {"REF. U/S 17 RTI", "145","2007"},
            {"REVIEW PETITION (CIVIL)", "154","2006"},
            {"REVIEW PETITION (CRIMINAL)", "163","2005"},
            {"SPECIAL LEAVE PETITION (CIVIL)", "172","2004"},
            {"SPECIAL LEAVE PETITION (CRIMINAL)", "181","2003"},
            {"SPECIAL LEAVE TO PETITION (CIVIL)...", "190","2002"},
            {"SPECIAL LEAVE TO PETITION (CRIMINAL)...", "199","2001"},
            {"SPECIAL REFERENCE CASE", "",""},
            {"SUO MOTO CONTEMPT PETITION(CIVIL)", "208","2000"},
            {"SUO MOTO CONTEMPT PETITION(CRIMINAL)", "217","1999"},
            {"SUO MOTO TRANSFER PETITION(CIVIL)", "87","1998"},
            {"SUO MOTO TRANSFER PETITION(CRIMINAL)", "65","1997"},
            {"SUO MOTO WRIT PETITION(CIVIL)", "49","1996"},
            {"SUO MOTO WRIT PETITION(CRIMINAL)", "55","1995"},
            {"TAX REFERENCE CASE", "","1994"},
            {"TRANSFER PETITION (CIVIL)", "96","1993"},
            {"TRANSFER PETITION (CRIMINAL)", "75","1992"},
            {"TRANSFERRED CASE (CIVIL)", "23","1991"},
            {"TRANSFERRED CASE (CRIMINAL)", "226","1990"},
            {"WRIT PETITION (CIVIL)", "235","2025"},
            {"WRIT PETITION(CRIMINAL)", "244","2024"},
            {"WRIT TO PETITION (CIVIL)...", "253","2023"},
            {"WRIT TO PETITION (CRIMINAL)...", "262","2022"},
            
            
        };
    }
    @DataProvider(name = "ByDairyNumberSupremCourtDataProvider")
    public static Object[][] provideDataExternal2() {
        return new Object[][] {
        	// Dairy No, Year
        	{"32","2000"},
        	{"142","2001"},
        	{"353","2002"},
        	{"100","2003"},
        	{"469","2004"},
        	{"789","2005"},
        	{"999","2006"},
        	{"1000","2007"},
        	{"1259","2008"},
        	{"1598","2009"},
        	{"1987","2010"},
        	{"2000","2011"},
        	{"2999","2012"},
        	{"2100","2013"},
        	{"2389","2014"},
        	{"2668","2015"},
        	{"2834","2016"},
        	{"3102","2017"},
        	{"3643","2018"},
        	{"3849","2019"},
        	{"0","2020"},
        	{"3999","2021"},
        	{"4396","2022"},
        	{"5301","2023"},
        	{"6921","2024"},
        	{"8999","2025"},
        };
    }
    
    @DataProvider(name = "ByPartyNameSupremCourtDataProvider")
    public static Object[][] provideDataExternal3() {
        return new Object[][] {
        	// Party Name , Year
        	{"Shashank", "2025"},
        	{"Ram", "2024"},
        	{"Shyam", "2023"},
        	{"Mohan", "2022"},
        	{"Sita", "2021"},
        	{"Gopal", "2020"},
        	{"Radha", "2019"},
        	{"Krishna", "2018"},
        	{"Amit", "2017"},
        	{"Rahul", "2016"},
        	{"Pooja", "2015"},
        	{"Arun", "2014"},
        	{"Vikram", "2013"},
        	{"Sanjay", "2012"},
        	{"Anjali", "2011"},
        	{"Rajesh", "2010"},
        	{"Manoj", "2009"},
        	{"Neha", "2008"},
        	{"Deepak", "2007"},
        	{"Priya", "2006"},
        	{"Anil", "2005"},
        	{"Sunita", "2004"},
        	{"Vikas", "2003"},
        	{"Alok", "2002"},
        	{"Rakesh", "2001"},
        	{"Meera", "2000"}

        };
    }
      // By Advocate Name Pending...............
    @DataProvider(name = "ByAdvocateNameSupremCourtDataProvider")
    public static Object[][] provideDataExternal4() {
        return new Object[][] {
        	// Advocate Name , Year
        	{"", ""}
         	
    };
}
    
}