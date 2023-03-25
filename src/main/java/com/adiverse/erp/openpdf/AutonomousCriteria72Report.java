//package com.adiverse.erp.openpdf;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.apache.commons.collections4.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.adiverse.erp.model.Criteria7_FieldInfo;
//import com.adiverse.erp.model.Criteria7_FileUpload;
//import com.adiverse.erp.service.Criteria7Service;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.pdf.CMYKColor;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//@Service
//public class AutonomousCriteria72Report {
//
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//
//	@Autowired
//	Criteria7Service service7;
//
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//
//	List<Criteria7_FieldInfo> criteria7List = null;
//	Criteria7_FieldInfo criteria7Record = null;
//	List<Criteria7_FileUpload> criteria7file = null;
//
//	public String generateReport(Criteria7_FieldInfo criteria7Fieldinfo) throws DocumentException, IOException {
//		String reportPath = "";
//		Path root = Paths.get(reportGeneratePath);
//		Path file = null;
//		Date date = new Date();
//		try {
//			font1.setSize(16);
//			font2.setSize(14);
//			font3.setSize(12);
//			font4.setSize(14);
//			font5.setSize(12);
//
//			criteria7List = service7.getAllCriteria7Data();
//			if (CollectionUtils.isNotEmpty(criteria7List)) {
//				criteria7Record = criteria7List.get(0);
//				criteria7file = criteria7Record.getCriteria7FileUpload();
//			} else {
//				criteria7Record = new Criteria7_FieldInfo();
//				criteria7file = new ArrayList<>();
//
//			}
//
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AuthonomousCriteria7Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//
//			Document document = new Document(PageSize.A4);
//
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//
//			document.open();
//			System.out.println("open the document==========>");
//
//			Paragraph paragraphcriteria7 = new Paragraph(
//					"Criterion 7 - Institutional Values and Best Practices\r\n\r\n", font1);
//			paragraphcriteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			
//			document.add(paragraphcriteria7);
//			
//			PdfPCell cell5criteria7 = new PdfPCell();
//			cell5criteria7.setPadding(5);
//			document.add(cell5criteria7);
//
//			PdfPTable table721criteria7 = new PdfPTable(1);
//			table721criteria7.setWidthPercentage(100f);
//
//			PdfPCell cell721criteria7 = new PdfPCell(new Paragraph(
//					"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format provided in the Manual.\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse721()
//									: ""),
//					font3));
//			table721criteria7.addCell(cell721criteria7);
//			table721criteria7.setSpacingBefore(20f);
//			table721criteria7.setSpacingAfter(20f);
//
//			document.add(table721criteria7);
//
//			PdfPTable table5criteria7 = new PdfPTable(2);
//			table5criteria7.setWidthPercentage(100);
//
//			PdfPCell cell1110 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell1134 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell1135 = new PdfPCell(
//					new Paragraph("Best practices in the Institutional web site\r\n\r\n\r\n "));
//			PdfPCell cell1136 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//			PdfPCell cell1137 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n "));
//			PdfPCell cell1138 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//
//			table5criteria7.addCell(cell1110);
//			table5criteria7.addCell(cell1134);
//			table5criteria7.addCell(cell1135);
//			table5criteria7.addCell(cell1136);
//			table5criteria7.addCell(cell1137);
//			table5criteria7.addCell(cell1138);
//
//			table5criteria7.setSpacingBefore(20f);
//			table5criteria7.setSpacingAfter(20f);
//
//			document.add(table5criteria7);
//
//			document.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//	}
//
//}
