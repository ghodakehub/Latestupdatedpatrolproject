 package dataprovider;

import org.testng.annotations.DataProvider;

public class HighCourtDataProvider {
	

    @DataProvider(name = "HighCourtCasesDataProvider")
    public static Object[][] provideHighCourtData() {
        return new Object[][]{
        	{"Allahabad High Court"},
        	{"Bombay High Court" },
        	{"Calcutta High Court"},
        	{"Delhi High Court"},
        	{"Gauhati High Court"},
        	{"High Court for State of Telangana"},
        	{"High Court Of Chhattisgarh"},
        	{"High Court Of Rajasthan"},
        	{"High Court Of Uttarakhand"},
        	{"High Court of Andhra Pradesh"},
        	{"High Court of Gujarat", "Pending"},
        	{"High Court of Himachal Pradesh"},
        	{"High Court of Jammu and Kashmir"},
        	{"High Court of Jharkhand"},
        	{"High Court of Karnataka"},
        	{"High Court of Kerala"},
        	{"High Court of Madhya Pradesh"},
        	{"High Court of Manipur"},
        	{"High Court of Meghalaya"},
        	{"High Court of Orissa"},
        	{"High Court of Punjab and Haryana"},
        	{"High Court of Sikkim"},
        	{"High Court of Tripura"},
        	{"Madras High Court"},
        	{"Patna High Court"}

        	
        };
	}
        
    }
