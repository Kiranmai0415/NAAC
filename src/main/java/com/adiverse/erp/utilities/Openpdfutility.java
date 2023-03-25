package com.adiverse.erp.utilities;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
public class Openpdfutility {

	
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;
	//private List<model> valueList;

//	public void generate(HttpServletResponse response,List<OpenPdfModel> valueList) throws DocumentException, IOException {
	
	
public	String generateReport() throws DocumentException, IOException {
		 String reportPath = "";
			Path root = Paths.get(reportGeneratePath);
			Path file = null;
			Date date = new Date();
		// Creating the Object of Document
		 
			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AuthonomousCriteria7Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
				
			
		
		Document document = new Document(PageSize.A4);

		// Getting instance of PdfWriter
	//	PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

		// Opening the created document to modify it
		document.open();

		// Creating font
		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(16);
		Font fontTiltle1 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle1.setSize(14);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("2.PROFILE", fontTiltle);
		Paragraph paragraph1 = new Paragraph("2.1 BASIC INFORMATION", fontTiltle1);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_LEFT);
		paragraph1.setAlignment(Paragraph.ALIGN_LEFT);

		// Adding the created paragraph in document
		document.add(paragraph);
		document.add(paragraph1);
		
		// Creating a table of 3 columns
		PdfPTable table = new PdfPTable(2);

		// Setting width of table, its columns and spacing
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 3, 3 });
		table.setSpacingBefore(5);

		// Create Table Cells for table header
		PdfPCell cell = new PdfPCell();

		// Setting the background color and padding
		//cell.setBackgroundColor(CMYKColor.MAGENTA);
		cell.setPadding(5);

		// Creating font
		// Setting font style and size
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		// Adding headings in the created table cell/ header
		// Adding Cell to table
		/*cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);*/
		cell.setPhrase(new Phrase("Name and Address of the College", font));
		table.addCell(cell);


		// Iterating over the list of students
		//for (model model1 : valueList) {
			// Adding student id

			table.addCell("Name");
			table.addCell("Address");
			table.addCell("City");
			table.addCell("State");
			table.addCell("Pin");
			table.addCell("Website");
			// Adding student section
			//table.addCell(model1.getType());
		// Adding the created table to document
		document.add(table);

		// Closing the document
		document.close();
		return reportPath;

	}
}
