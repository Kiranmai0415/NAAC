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
public class AffilatedCriteria11Report2 {

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
			Paragraph paragraph2 = new Paragraph("1.1  Curricular Planning and Implementation\r\n", font3);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph2);
			PdfPTable table111criteria1 = new PdfPTable(1);

			table111criteria1.setWidthPercentage(100);
//			PdfPCell cell111criteria1 = new PdfPCell(new Paragraph(
//					"1.1.1: The Institution ensures effective curriculum planning and delivery through a well-planned and documented process including Academic calendar and conduct of continuous internal Assessment\r\n"
//							+ "Response:"
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQl().get(0).getResponse111()
//									: font3)));

			//table111criteria1.addCell(cell111criteria1);

			table111criteria1.setSpacingBefore(20);
			table111criteria1.setSpacingAfter(20);
			document.add(table111criteria1);

			// 112
			PdfPTable table112 = new PdfPTable(2);
			table112.setWidthPercentage(100);
			PdfPTable table1120 = new PdfPTable(1);
			table1120.setWidthPercentage(100);
			PdfPCell cell1121 = new PdfPCell(new Paragraph("File Description", font3));
			PdfPCell cell1122 = new PdfPCell(new Paragraph("Document", font3));
			PdfPCell cell1123 = new PdfPCell(new Paragraph("Any additional information"));
			PdfPCell cell1124 = new PdfPCell(
					new Paragraph((criteria1Fieldinfo.getCriteria1FileUpload().get(0).getCriteria1FileName())));
			PdfPCell cell1125 = new PdfPCell(new Paragraph("Link for Additional information"));
			PdfPCell cell1126 = new PdfPCell(
					new Paragraph((criteria1Fieldinfo.getCriteria1FileUpload().get(0).getCriteria1FileName())));
			table112.addCell(cell1121);
			table112.addCell(cell1122);
			table112.addCell(cell1123);
			table112.addCell(cell1124);
			table112.addCell(cell1125);
			table112.addCell(cell1126);

			document.add(table112);
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
