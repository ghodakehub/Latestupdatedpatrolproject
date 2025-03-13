package Patrol.Utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;




public class NewPdfUtilityClass {
	
	 public static void generateReport(List<TestResults> testResults, List<byte[]> screenshots) {
	        Document document = new Document();
	        try {
	            PdfWriter.getInstance(document, new FileOutputStream("Test_Report.pdf"));
	            document.open();

	            // ✅ Add Company Logo
	            Image logo = Image.getInstance("company_logo.png");
	            document.add(logo);

	            // ✅ Add Summary
	            document.add(new Paragraph("Automation Test Report"));
	            document.add(new Paragraph("Total Cases: " + testResults.size()));

	            for (TestResults result : testResults) {
	                document.add(new Paragraph("Test Case: " + result.getTestCaseName()));
	                document.add(new Paragraph("Status: " + result.getStatus()));

	                // ✅ Safe Check for Error Message
	                if (result.getErrorMessage() != null && !result.getErrorMessage().isEmpty()) {
	                    document.add(new Paragraph("Error: " + result.getErrorMessage()));
	                }
	                document.add(new Paragraph("\n---------------------------------\n"));
	            
	            }
	            document.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
