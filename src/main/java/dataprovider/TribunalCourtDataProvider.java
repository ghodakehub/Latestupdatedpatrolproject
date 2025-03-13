package dataprovider;

import org.testng.annotations.DataProvider;

public class TribunalCourtDataProvider {

	@DataProvider(name = "ByCaseNCLTDataProvider")
    public static Object[][] provideDataExternal() {
        return new Object[][] {
        	// Bench, Case Type
        	{"Principal Bench","Transfer Application (IBC)"},
        	
        	
        	{"New Delhi Bench Court-II","Transfer Application (IBC)"},
        	
        	
        	{"New Delhi Bench Court-III","Transfer Application (IBC)"},
        	
        	
        	{"New Delhi Bench Court-IV","Transfer Application (IBC)"},
        	
        	
        	{"New Delhi Bench Court-V","Transfer Application (IBC)"},
        	
        	
        	{"New Delhi Bench Court-VI","Transfer Application (IBC)"},
        	
        	
        	{"Ahmedabad","Transfer Application (IBC)"},
        	
        	
        	{"Allahabad","Transfer Application (IBC)"},
        	
        	
        	{"Amravati","Transfer Application (IBC)"},
        	
        	
        	{"Bengaluru","Transfer Application (IBC)"},
        	
        	
        	{"Chandigarh","Transfer Application (IBC)"},
        	
        	
        	{"Chennai","Transfer Application (IBC)"},
        	
        	
        	{"Guwahati","Transfer Application (IBC)"},
        	
        	
        	{"Hyderabad","Transfer Application (IBC)"},
        	
        	{"Indore","Transfer Application (IBC)"},
        	
        	
        	{"Jaipur","Transfer Application (IBC)"},
        	
        	{"Kochi","Transfer Application (IBC)"},
        	
        	
        	{"Kolkata","Transfer Application (IBC)"},
        	
        	
        	{"Mumbai","Transfer Application (IBC)"},
        	
        	
        	{"Cuttack","Transfer Application (IBC)"},
        	

        };
    }
	
	@DataProvider(name = "ByCaseNCLATDataProvider")
    public static Object[][] provideDataExternal2() {
        return new Object[][] {
        	// Court, Bench, Case Type 
        	{"Chennai","Interlocutory Application"},
        	{"Chennai","Transfer Original Petition (MRTP-AT)"},
        	
        	
        	{"New Delhi","Interlocutory Application"},
        	{"New Delhi","Transfer Original Petition (MRTP-AT)"},
        	

        };
    }
	
	@DataProvider(name = "ByCaseITATDataProvider")
    public static Object[][] provideDataExternal3() {
        return new Object[][] {
        	// Court, Bench, Case Type, Case No, Year, Case Status, Party Name 
        	 
        	// Agra
       	 
        	{"Agra","Black Money Appeal"},
        	
        	
        	 
        	// Ahmedabad
        	 
        	{"Ahmedabad","Black Money Appeal"},
        	 
        	
        	 
        	// Allahabad
        	 
        	{"Allahabad","Black Money Appeal"},
        	 
        	
        	 
        	// Amritsar
        	 
        	{"Amritsar","Black Money Appeal"},
        	 
        	
        	 
        	// Bangalore
        	 
        	{"Bangalore","Black Money Appeal"},
        	 
        	
        	 
        	// Chandigarh
        	 
        	{"Chandigarh","Black Money Appeal"},
        	 
        	
        	 
        	// Chennai
        	 
        	{"Chennai","Black Money Appeal"},
        	 
        	
        	 
        	// Cochin
        	 
        	{"Cochin","Black Money Appeal"},
        	 
        	
        	 
        	// Cuttack
        	 
        	{"Cuttack","Black Money Appeal"},
        	 
        	
        	 
        	// Dehradun
        	 
        	{"Dehradun","Black Money Appeal"},
        	 
        	
        	 
        	// Delhi
        	 
        	{"Delhi","Black Money Appeal"},
        	 
        	
        	 
        	// Guwahati
        	 
        	{"Guwahati","Black Money Appeal"},
        	 
        	
        	 
        	// Hyderabad
        	 
        	{"Hyderabad","Black Money Appeal"},
        	 
        	
        	 
        	// Indore
        	 
        	{"Indore","Black Money Appeal"},
        	 
        	
        	 
        	// Jabalpur
        	 
        	{"Jabalpur","Black Money Appeal"},
        	 
        	
        	 
        	{"Jabalpur","Wealth Tax Appeal"},
        	 
        	// Jaipur
        	 
        	{"Jaipur","Black Money Appeal"},
        	 
        	
        	 
        	// Jodhpur
        	 
        	{"Jodhpur","Black Money Appeal"},
        	 
        	
        	 
        	// Kolkata
        	 
        	{"Kolkata","Black Money Appeal"},
        	 
        	
        	 
        	// Lucknow
        	 
        	{"Lucknow","Black Money Appeal"},
        	 
        	
        	 
        	// Mumbai
        	 
        	{"Mumbai","Black Money Appeal"},
        	 
        	
        	 
        	// Nagpur
        	 
        	{"Nagpur","Black Money Appeal"},
        	 
        	
        	 
        	// Panaji
        	 
        	{"Panaji","Black Money Appeal"},
        	 
        	
        	 
        	// Patna
        	 
        	{"Patna","Black Money Appeal"},
        	 
        	
        	 
        	// Pune
        	 
        	{"Pune","Black Money Appeal"},
        	 
        	
        	 
        	// Raipur
        	 
        	{"Raipur","Black Money Appeal"},
        	 
        	
        	 
        	// Rajkot
        	 
        	{"Rajkot","Black Money Appeal"},
        	 
        	
        	 
        	// Ranchi
        	 
        	{"Ranchi","Black Money Appeal"},
        	 
        	
        	 
        	// Surat
        	 
        	{"Surat","Black Money Appeal"},
        	 
        	
        	 
        	// Varanasi
        	 
        	{"Varanasi","Black Money Appeal"},
        	 
        	
        	 
        	// Vishakha Pattnam
        	 
        	{"Visakhapatnam","Black Money Appeal"},
        	 
        	
        	 
        	
         };
    }
	
	@DataProvider(name = "ByCaseAPTELDataProvider")
    public static Object[][] provideDataExternal4() {
        return new Object[][] {
        	// Court, Bench, Case Type, Case No, Year, Case Status, Party Name 
        	{"APL"},
        	{"OSP"},
        	
        	
        };
    }
	
//	@DataProvider(name = "ByCaseConsumerCourtDataProvider")
  //  public static Object[][] provideDataExternal5() {
   //     return new Object[][] {
   //     	//  Court, Bench, State, District, Case Type
 //       };
//    }
	
	@DataProvider(name = "ByCaseDRTDataProvider")
    public static Object[][] provideDataExternal6() {
        return new Object[][] {
        	// Court, Bench, State, Case Type
        	{"DRAT","DEBT RECOVERY APPELLATE TRIBUNAL - ALLAHABAD","REVIEW APPLICATION"},
        	{"DRAT","DEBT RECOVERY APPELLATE TRIBUNAL - ALLAHABAD","MISC APPLICATION"},
        	{"DRT","DEBTS RECOVERY TRIBUNAL AHMEDABAD(DRT 1)","Review Application"},
        	{"DRT","DEBTS RECOVERY TRIBUNAL AHMEDABAD(DRT 1)","Misc Application"},


        };
    }
	
	@DataProvider(name = "ByCaseCATDataProvider")
    public static Object[][] provideDataExternal7() {
        return new Object[][] {
        	// Court, Bench, Case Type
        	{"Delhi","Original Application"},
        	{"Ahmedabad","Transfer Application"},
        	{"Allahabad","Misc Application"},
        	{"Bangalore","Contempt Petiton"},
        	{"Chandigarh","Petition for Transfer"},
        	{"Chennai","Criminal Contempt Petition"},
        	{"Cuttack","Oa Obj"},
        	{"Patna","Original Application"},
        	{"Srinagar","Original Application"},
        	{"Mumbai","Misc Application"},

        	









        };
    }
	
	@DataProvider(name = "ByCaseTDSATDataProvider")
    public static Object[][] provideDataExternal8() {
        return new Object[][] {
        	// Court, Bench, Case Type
        	
        	{"Delhi","Broadcasting Petition"},
        	{"Delhi","Telecom Petition"},
        	
        };
    }
	
	@DataProvider(name = "ByCaseNGTDataProvider")
    public static Object[][] provideDataExternal9() {
        return new Object[][] {
        	// Court, Bench, Case Type, Case No, Year, Case Status, Party Name 
        	{"Principal Bench","Original Application"},
        	{"Eastern Zone","Review Application"},
        	{"Central Zone","Misc Application in disposed of cases"},
        	{"Western Zone","Appeal"},
        	{"Southern Zone","Execution Application"},
        	{"Southern Zone","IA"},





        	
        };
    }
	
	@DataProvider(name = "ByCaseSATDataProvider")
    public static Object[][] provideDataExternal10() {
        return new Object[][] {
        	// Court, Bench, Case Type, Case No, Year, Case Status, Party Name 
        	{"SEBI","2025"},
        	
        	
        	{"IRDAI","2025"},
        	
        	
        	{"PFRDA","2025"},
        	
        };
    }
	
	@DataProvider(name = "ByCaseRERADataProvider")
    public static Object[][] provideDataExternal11() {
        return new Object[][] {
        	// Court, Bench, Case Type, Case No, Year, Case Status, Party Name 
        	{"Assam","Assam"},
        	{"Delhi","Delhi"},
        	{"Goa","Goa"},
        	
        	{"Haryana","H-REAT"},
        	{"Himachal_Pradesh","Himachal_Pradesh"},
        	{"Kerala","Kerala"},
        	{"Odisa","Odisa"},
        	{"Punjab","Punjab"},
        	{"Tamil Nadu","Tamil Nadu"},
        	{"Maharastra","Maharastra"},
        	{"Karnataka","Karnataka"},
        	{"Gujarat","Gujarat"},
        	{"Jharkhand","Jharkhand"},

        };
    }
	
	@DataProvider(name = "ByCaseCESTATDataProvider")
    public static Object[][] provideDataExternal12() {
        return new Object[][] {
        	// Court, Bench, Case Type
        	{"Delhi","CUSTOMS"},
        	
        	
        	{"Chandigarh","EXCISE"},
        	
        	
        	{"Mumbai","SERVICE TAX"},
        	
        	
        	{"Ahmedabad","ANTIDUMPING"},
        	
        	
        	{"Bangalore","CENTRAL SALE TAX"},
        	
        	
        	{"Allahabad","CUSTOMS"},
        	
        	
        	{"Kolkata","ANTIDUMPING"},
        	
        	
        	{"Chennai","EXCISE"},
        	
        	
        	{"Hyderabad","CUSTOMS"},
        	
        };
    }
	
	@DataProvider(name = "ByCaseElectricityCommissionDataProvider")
    public static Object[][] provideDataExternal13() {
        return new Object[][] {
        	// Court, Bench, Case Type, Case No, Year, Case Status, Party Name 
        	{"CERC","Petition"},
        	{"MERC","Petition"},
        	{"DERC","Misc-Petition"},
        	{"GERC","Licence"},
        	{"UPERC","Adoption"},
        	{"HPERC","Adjudicate"},
        	{"CSERC","DP"},
        	{"HERC","Power Exchange"},
        	{"MPERC","Transmission Licence"},
        	{"UERC","CT"},
        	{"KSERC","Tariff Petition"},
        	{"ORIERC","Transmission Licence"},
        	{"APSERC","OA"},













        };
    }
}
