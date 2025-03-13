package Patrol.Utility;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class PdfUtility {

	public static String generatePdfReport(List<String> failedUrls, String directoryPath, String allureUrl) throws IOException, DocumentException {
	    // Create directory if it doesn't exist
	    File directory = new File(directoryPath);
	    if (!directory.exists()) {
	        directory.mkdirs(); // Create directories if not present
	        System.out.println("Directory created: " + directoryPath);
	    }

	    // Define PDF file path
	    String pdfPath = directoryPath + File.separator + "Patrol_Automation_Report.pdf";
	    Document document = new Document();

	    try {
	        PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
	        document.open();

	        // Title
	        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLACK);
	        Paragraph title = new Paragraph("Patrol Automation Test Report", titleFont);
	        title.setAlignment(Element.ALIGN_CENTER);
	        document.add(title);
	        document.add(new Paragraph("\n"));

	        document.add(new Paragraph("Test Execution Details:\n"));

	        if (failedUrls.isEmpty()) {
	            document.add(new Paragraph("✅ No errors found. All test cases passed successfully."));
	        } else {
	            document.add(new Paragraph("❌ Failed Test Cases:"));
	            for (String url : failedUrls) {
	                document.add(new Paragraph("URL: " + url));
	            }
	        }

	        // Add Allure Report Link
	        document.add(new Paragraph("\nAllure Report Link:"));
	        Anchor anchor = new Anchor(allureUrl);
	        anchor.setReference(allureUrl);
	        document.add(anchor);

	        System.out.println("PDF report generated successfully: " + pdfPath);

	    } finally {
	        document.close();
	    }

	    return pdfPath;
	}
	     
}
