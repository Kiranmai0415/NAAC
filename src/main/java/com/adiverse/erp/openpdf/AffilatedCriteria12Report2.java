package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class AffilatedCriteria12Report2 {

	@Value("${upload.files.path}")
	private String reportGeneratePath;

	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);

	public String generateReport(Criteria1_FieldInfo criteria1Fieldinfo) throws DocumentException, IOException {
		String reportPath = "";
		Path root = Paths.get(reportGeneratePath);
		Path file = null;
		Date date = new Date();
		try {
			font1.setSize(16);
			font2.setSize(14);
			font3.setSize(12);
			font4.setSize(14);
			font5.setSize(12);

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AffilatedCriteria1Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

			Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
			paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph);

			Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font2);
			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph1);
			
			Paragraph paragraph2 = new Paragraph("1.1  1.2: Academic Flexibility \r\n", font3);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph2);
			
			PdfPTable table111criteria1 = new PdfPTable(1);
			table111criteria1.setWidthPercentage(100);
//			
//			PdfPCell cell111criteria1 = new PdfPCell(new Paragraph(
//					"1.2.1: Number of Add on /Certificate/Value added programs offered during the last five years"
//							+ "Response:"
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse121()
//									: font3)));
			
			
//			PdfPCell cell1101criteria1 = new PdfPCell(new Paragraph(
//					"1.2.1.1: How many new courses are introduced within the last five years"
//							+ "Response:"
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1211t1()
//									: font3)));
//			
//			PdfPCell cell11001criteria1 = new PdfPCell(new Paragraph(
//					"\r\n"
//					+ "1.2.1.2: : Number of Add on /Certificate /Value added programs offered during the last five years"
//							+ "Response:"
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1212t1()
//									: font3)));
			
			
			
			
			

	//		table111criteria1.addCell(cell111criteria1);
		//	table111criteria1.addCell(cell1101criteria1);
		//	table111criteria1.addCell(cell11001criteria1);

			table111criteria1.setSpacingBefore(20);
			table111criteria1.setSpacingAfter(20);
			document.add(table111criteria1);

			// 112
			PdfPTable table112 = new PdfPTable(2);
			table112.setWidthPercentage(100);
			
			PdfPCell cell1121 = new PdfPCell(new Paragraph("File Description", font3));
			PdfPCell cell1122 = new PdfPCell(new Paragraph("Document", font3));
			PdfPCell cell1123 = new PdfPCell(new Paragraph("Any additional information"));
			PdfPCell cell1124 = new PdfPCell(new Paragraph((criteria1Fieldinfo.getCriteria1FileUpload().get(0).getCriteria1FileName())));
			PdfPCell cell1125 = new PdfPCell(new Paragraph("Link for Additional information"));
			PdfPCell cell1126 = new PdfPCell(new Paragraph((criteria1Fieldinfo.getCriteria1FileUpload().get(0).getCriteria1FileName())));
			table112.addCell(cell1121);
			table112.addCell(cell1122);
			table112.addCell(cell1123);
			table112.addCell(cell1124);
			table112.addCell(cell1125);
			table112.addCell(cell1126);

			document.add(table112);
			
			
			
			PdfPTable table12criteria1 = new PdfPTable(1);
			table12criteria1.setWidthPercentage(100);
			
			PdfPCell cell1criteria1 = new PdfPCell(new Paragraph(
					"1.2.2: Percentage of students enrolled in Certificate/ Add-on/Value added programs as against the total number of students during the last five years"
							+ "Response:"
							+ (criteria1Fieldinfo != null
									? criteria1Fieldinfo.getCriteria12Qn().get(0).getResponse122()
									: font3)));
			
			PdfPCell cell2criteria1 = new PdfPCell(new Paragraph(
					"1.2.2.1: Number of students enrolled in subject related Certificate/ Add-on/Value added programs year wise during last five years"
							,font3));
			
			table12criteria1.addCell(cell1criteria1);
			table12criteria1.addCell(cell2criteria1);
			
			document.add(table12criteria1);
			
			
			PdfPTable table2 = new PdfPTable(2);
			table2.setWidthPercentage(100);
			
			PdfPCell cell10 = new PdfPCell(new Paragraph("File Description", font3));
			PdfPCell cell11 = new PdfPCell(new Paragraph("Document", font3));
			PdfPCell cell12 = new PdfPCell(new Paragraph("Institutional data in prescribed format"));
			PdfPCell cell13 = new PdfPCell(new Paragraph((criteria1Fieldinfo.getCriteria1FileUpload().get(0).getCriteria1FileName())));
			PdfPCell cell14 = new PdfPCell(new Paragraph("Upload supported document"));
			PdfPCell cell15 = new PdfPCell(new Paragraph((criteria1Fieldinfo.getCriteria1FileUpload().get(0).getCriteria1FileName())));
			table112.addCell(cell10);
			table112.addCell(cell11);
			table112.addCell(cell12);
			table112.addCell(cell13);
			table112.addCell(cell14);
			table112.addCell(cell15);
			
			document.add(table112);
			
			
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
