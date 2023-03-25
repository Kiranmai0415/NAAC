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
//import com.adiverse.erp.model.Criteria1_FieldInfo;
//import com.adiverse.erp.model.Criteria1_FileUpload;
//import com.adiverse.erp.model.Criteria2_FieldInfo;
//import com.adiverse.erp.model.Criteria2_FileUpload;
//import com.adiverse.erp.service.Criteria1Service;
//import com.adiverse.erp.service.Criteria2Service;
//import com.lowagie.text.Chunk;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Element;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//@Service
//public class UniversityCriteria23Report2 {
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;      //file upload path
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//	@Autowired
//	Criteria2Service service2;
//	
//	List<Criteria2_FieldInfo> criteria2List = null;
//	Criteria2_FieldInfo criteria2Record = null;
//	List<Criteria2_FileUpload> criteria2file = null;
//	
//	public String generateReport(Criteria2_FieldInfo criteria2Fieldinfo) throws DocumentException, IOException {
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
//			criteria2List = service2.getAllCriteria2Data();
//			if (CollectionUtils.isNotEmpty(criteria2List)) {
//				criteria2Record = criteria2List.get(0);
//				criteria2file = criteria2Record.getCriteria2FileUpload();
//			} else {
//				criteria2Record = new Criteria2_FieldInfo();
//			}
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "UniversityCriteria2Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//			Document document = new Document(PageSize.A4);
//			// PdfWriter.getInstance(document, response.getOutputStream());
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>");
//			
//			
//			
//			
//			PdfPTable tablecriteria2 = new PdfPTable(1);
//			PdfPTable table1criteria2 = new PdfPTable(1);
//
//			PdfPTable table3criteria2 = new PdfPTable(2);
//
//			PdfPTable table6criteria2 = new PdfPTable(5);
//			PdfPTable table7criteria2 = new PdfPTable(2);
//
//			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
//
//			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph2criteria2);
//
//			tablecriteria2.setWidthPercentage(100f);
//	
//			Paragraph paragraph5criteria2 = new Paragraph("2.3	Teaching- Learning Process", font3);
//			document.add(paragraph5criteria2);
//
//			PdfPTable table03 = new PdfPTable(1);
//			table03.setWidthPercentage(100f);
//
//			
//			PdfPCell cell001 = new PdfPCell(new Paragraph(
//					"2.3.1 Student centric methods, such as experiential learning, participative learning and problem solving methodologies are used for enhancing learning experiences"
//							+ "\r\n" + "" + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse231()
//									: "")
//							+
//
//							 ""));
//
//			table03.addCell(cell001);
//
//			document.add(table03);
//
//			PdfPTable table10criteria2 = new PdfPTable(2);
//
//			table10criteria2.setWidthPercentage(100f);
//			table10criteria2.setWidths(new int[] { 3, 3 });
////			table10criteria2.setSpacingBefore(20);
////			table10criteria2.setSpacingAfter(20);
//
//			PdfPCell cell21criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table10criteria2.addCell(cell21criteria2);
//
//			PdfPCell cell22criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table10criteria2.addCell(cell22criteria2);
//
//			PdfPCell cell23criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			table10criteria2.addCell(cell23criteria2);
//
//			PdfPCell cell24criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table10criteria2.addCell(cell24criteria2);
//			
//			
//			PdfPCell cell25criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
//			table10criteria2.addCell(cell25criteria2);
//			PdfPCell cell26criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table10criteria2.addCell(cell26criteria2);
//			
//
//
//			document.add(table10criteria2);
//
//			PdfPTable table04 = new PdfPTable(1);
//			table04.setWidthPercentage(100f);
//
//			PdfPCell cell002 = new PdfPCell(new Paragraph(
//					"2.3.2 Teachers use ICT enabled tools including online resources for effective teaching and learning process."
//							+ "" + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse232()
//									: "") ));
//
//			table04.addCell(cell002);
//
//			document.add(table04);
//
//			PdfPTable table11criteria2 = new PdfPTable(2);
//
//			table11criteria2.setWidthPercentage(100f);
//			table11criteria2.setWidths(new int[] { 3, 3 });
//			table11criteria2.setSpacingBefore(5);
//
//			PdfPCell cell205criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table11criteria2.addCell(cell205criteria2);
//
//			PdfPCell cell206criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table11criteria2.addCell(cell206criteria2);
//
//			PdfPCell cell27criteria2 = new PdfPCell(new Paragraph(
//					"Upload any additional information"));
//			table11criteria2.addCell(cell27criteria2);
//
//			PdfPCell cell28criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table11criteria2.addCell(cell28criteria2);
//
//			PdfPCell cell29criteria2 = new PdfPCell(new Paragraph("Provide link for webpage describing the \" LMS/\r\n"
//					+ "Academic management system"));
//			table11criteria2.addCell(cell29criteria2);
//
//			PdfPCell cell30criteria2 = new PdfPCell(new Paragraph(""));
//			table11criteria2.addCell(cell30criteria2);
//
//			document.add(table11criteria2);
//
//			PdfPTable table05 = new PdfPTable(1);
//			table05.setWidthPercentage(100f);
//
//			PdfPCell cell1500criteria2 = new PdfPCell(new Paragraph(
//					"2.3.3 Ratio of students to mentor for academic and other related issues (Data for the latest completed academic year )\r\n"
//							+ "\r\n" + "\"Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse233()
//									: "")));
//
//			PdfPCell cell1501criteria2 = new PdfPCell(new Paragraph("2.3.3.1 Number of mentors \r\n" + "\r\n" 
//					+ (criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getInput2331t1() : "")));
//
//			PdfPCell cell1502criteria2 = new PdfPCell(new Paragraph("2.3.3.1Number of students assigned to each Mentor" + "\r\n" 
//					+ (criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getInput2331t2() : "")));
//
//			
//			table05.addCell(cell1500criteria2);
//			table05.addCell(cell1501criteria2);
//			table05.addCell(cell1502criteria2);
//			
//			document.add(table05);
//
//			PdfPTable table13criteria2 = new PdfPTable(2);
//
//			table13criteria2.setWidthPercentage(100f);
//			table13criteria2.setWidths(new int[] { 3, 3 });
//			
//			table13criteria2.setSpacingBefore(20f);
//			table13criteria2.setSpacingAfter(20f);
//
//			PdfPCell cell31criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table13criteria2.addCell(cell31criteria2);
//
//			PdfPCell cell32criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table13criteria2.addCell(cell32criteria2);
//
//			PdfPCell cell33criteria2 = new PdfPCell(
//					new Paragraph("Upload year wise, number of students enrolled and full time teachers on roll\r\n\r\n"));
//			table13criteria2.addCell(cell33criteria2);
//
//			PdfPCell cell34criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table13criteria2.addCell(cell34criteria2);
//
//			PdfPCell cell35criteria2 = new PdfPCell(new Paragraph("mentor/mentee ratio"));
//			table13criteria2.addCell(cell35criteria2);
//
//			PdfPCell cell36criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table13criteria2.addCell(cell36criteria2);
//
//			PdfPCell cell37criteria2 = new PdfPCell(new Paragraph("Circulars pertaining to assigning mentors to mentees\r\n\r\n"));
//			table13criteria2.addCell(cell37criteria2);
//
//			PdfPCell cell38criteria2 = new PdfPCell(new Paragraph(""));
//			table13criteria2.addCell(cell38criteria2);
//
//			document.add(table13criteria2);
//
//
//
//			document.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//	}
//	
//}
