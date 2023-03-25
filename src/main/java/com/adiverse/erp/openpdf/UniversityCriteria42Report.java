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
//import com.adiverse.erp.model.Criteria3_FieldInfo;
//import com.adiverse.erp.model.Criteria3_FieldInfoQl;
//import com.adiverse.erp.model.Criteria3_FieldInfoQn;
//import com.adiverse.erp.model.Criteria3_FileUpload;
//import com.adiverse.erp.model.Criteria4_FieldInfo;
//import com.adiverse.erp.model.Criteria4_FileUpload;
//import com.adiverse.erp.service.Criteria4Service;
//import com.lowagie.text.Chunk;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.CMYKColor;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//@Service
//public class UniversityCriteria42Report {
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
//	
//   @Autowired
//   Criteria4Service service4;
//	
//   List<Criteria4_FieldInfo> criteria4List = null;
//	Criteria4_FieldInfo criteria4Record = null;
//	List<Criteria4_FileUpload> criteria4file = null;
//
//	public String generateReport(Criteria4_FieldInfo criteria4Fieldinfo) throws DocumentException, IOException {
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
//			criteria4List = service4.getAllCriteria4Data();
//			if (CollectionUtils.isNotEmpty(criteria4List)) {
//				criteria4Record = criteria4List.get(0);
//				criteria4file = criteria4Record.getCriteria4FileUpload();
//			} else {
//				criteria4Record = new Criteria4_FieldInfo();
//				criteria4file = new ArrayList<>();
//			}
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "UniversityCriteria4Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//			
//			Document document = new Document(PageSize.A4);
//			// PdfWriter.getInstance(document, response.getOutputStream());
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>");
//	
//
//			Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources", font1);
//			paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph1criteria4);
//
//			/*
//			 * Font font1criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font1criteria4.setSize(14);
//			 */
//
//
//			Paragraph paragraph31criteria4 = new Paragraph("4.2 Library as a Learning Resource\r\n\r\n\r\n", font1);
//			paragraph31criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph31criteria4);
//			
//
//			PdfPTable table421criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table421criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00400 = new PdfPCell(new Paragraph(
//					"4.2.1 Library is automated using Integrated Library Management System (ILMS)\r\n\r\n+ Response:"
//					+(criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse421()
//									: ""),font3));
//			
//			table421criteria4.addCell(cell00400);
//			// table421criteria4.addCell(criteria4List.get(3).getResponseValue421());
//			
//
//			table421criteria4.setSpacingBefore(20f);
//			table421criteria4.setSpacingAfter(20f);
//			document.add(table421criteria4);
//
//			
//
//			
//			
//
//
//		
//
//			// Creating a table of 3 columns
//			PdfPTable table8criteria4 = new PdfPTable(2);
//
//			// Setting width of table, its columns and spacing
//			table8criteria4.setWidthPercentage(100);
//			
//			Font font6criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font6criteria4.setColor(CMYKColor.BLACK);
//
//			PdfPCell cell0041 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font6criteria4));
//			table8criteria4.addCell(cell0041);
//			PdfPCell cell0042 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
//			table8criteria4.addCell(cell0042);
//			PdfPCell cell0043 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			table8criteria4.addCell(cell0043);
//			if(criteria4file.size() >0) {
//			PdfPCell cell0044 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table8criteria4.addCell(cell0044);
//		}
//			PdfPCell cell0045 = new PdfPCell(new Paragraph("Paste Link for additional information\r\n\r\n\r\n "));
//			PdfPCell cell0046 = new PdfPCell(new Paragraph(" "));
//
//			
//			
//			
//			
//			table8criteria4.addCell(cell0045);
//			table8criteria4.addCell(cell0046);
//
//			table8criteria4.setSpacingBefore(20f);
//			table8criteria4.setSpacingAfter(20f);
//			document.add(table8criteria4);
//
//			// Creating a table of 3 columns
//			PdfPTable table9criteria4 = new PdfPTable(2);
//			PdfPTable table10criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table9criteria4.setWidthPercentage(100);
//			table10criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0047 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font6criteria4));
//			table9criteria4.addCell(cell0047);
//			PdfPCell cell0048 = new PdfPCell(new Paragraph("Document\r\n\r\n", font6criteria4));
//			table9criteria4.addCell(cell0048);
//			PdfPCell cell0049 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			table9criteria4.addCell(cell0049);
//			if(criteria4file.size() >0) {
//			PdfPCell cell0050 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : ""));
//			table9criteria4.addCell(cell0050);
//			}
//			PdfPCell cell0051 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			table9criteria4.addCell(cell0051);
//			if(criteria4file.size()>0)
//			{
//			PdfPCell cell0052 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : ""));
//			table9criteria4.addCell(cell0052);
//			}
//
//			
//			
//		
//			
//			
//			
//
//			PdfPCell cell00510 = new PdfPCell(new Paragraph(
//					"4.2.2 Institution has access to the following: 1. e-journals 2. e-ShodhSindhu 3. Shodhganga Membership 4. e-books 5. Databases 6. Remote access to e-resources\r\n"
//						 + "Response:"
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse422()
//									: ""),font3));
//			
//			table10criteria4.addCell(cell00510);
//			table10criteria4.addCell(table9criteria4);
//
//			table10criteria4.setSpacingBefore(20f);
//			table10criteria4.setSpacingAfter(20f);
//
//			document.add(table10criteria4);
//
//			// Creating a table of 3 columns
//			PdfPTable table11criteria4 = new PdfPTable(2);
//			PdfPTable table12criteria4 = new PdfPTable(1);
//
//			table11criteria4.setWidthPercentage(100);
//			table12criteria4.setWidthPercentage(100);
//			PdfPCell cell0065 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font6criteria4));
//			table11criteria4.addCell(cell0065);
//			PdfPCell cell0066 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
//			table11criteria4.addCell(cell0066);
//			PdfPCell cell0067 = new PdfPCell(new Paragraph(
//					"Institutional data in prescribed format\r\n\r\n"));
//			table11criteria4.addCell(cell0067);
//			if(criteria4file.size() >0)
//			{
//			PdfPCell cell0068 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//			table11criteria4.addCell(cell0068);
//			}
//			PdfPCell cell0069 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n"));
//			table11criteria4.addCell(cell0069);
//			if(criteria4file.size() >0)
//			{
//			PdfPCell cell0070 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//			table11criteria4.addCell(cell0070);
//			
//			}
//			
//		
//if(criteria4Record.getCriteria4FieldInfoQn().size() >0)
//{
//			PdfPCell cell005101 = new PdfPCell(new Paragraph(
//					"4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n"
//							+ "\r\n\r\n" + "Response: "
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse423()
//									: ""),font3));
//			
//			table12criteria4.addCell(cell005101);
//}
//			
//			PdfPCell cell0051011 = new PdfPCell(new Paragraph(
//					"4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)"
//							+ "\r\n\r\n",font3));
//			
//			
//			table12criteria4.addCell(cell0051011);
//			
//			table12criteria4.addCell(table11criteria4);
//
//			table12criteria4.setSpacingBefore(20f);
//			table12criteria4.setSpacingAfter(20f);
//
//			document.add(table12criteria4);
//
//			if (criteria4Fieldinfo != null) {
//
//				Table table4231 = new Table(criteria4Fieldinfo.getYearTable4231().size(), 2);
//
//				table4231.setPadding(10);
//				table4231.setWidth(100f);
//
//				for (int i = 0; i < criteria4Fieldinfo.getYearTable4231().size(); i++) {
//					table4231.addCell(criteria4Fieldinfo.getYearTable4231().get(i).getInput4231y());
//
//				}
//				for (int i = 0; i < criteria4Fieldinfo.getYearTable4231().size(); i++) {
//					table4231.addCell(criteria4Fieldinfo.getYearTable4231().get(i).getInput4231v());
//
//				}
//
//				document.add(table4231);
//			}
//
//			// Creating a table of 3 columns
//
//			PdfPTable table13 = new PdfPTable(2);
//
//			// Setting width of table, its columns and spacing
//			table13.setWidthPercentage(100);
//
//		
//
//			table13.setSpacingBefore(20f);
//			table13.setSpacingAfter(20f);
//
//			document.add(table13);
//
//			// Creating a table of 3 columns
//			PdfPTable table14criteria4 = new PdfPTable(2);
//			PdfPTable table15 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table14criteria4.setWidthPercentage(100);
//			table15.setWidthPercentage(100);
//
//			PdfPCell cell0075 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font6criteria4));
//			table14criteria4.addCell(cell0075);
//			PdfPCell cell0076 = new PdfPCell(new Paragraph("Document\r\n\r\n", font6criteria4));
//			table14criteria4.addCell(cell0076);
//			PdfPCell cell0077 = new PdfPCell(new Paragraph("Details of library usage by teachers and students\r\n\r\n"));
//			table14criteria4.addCell(cell0077);
//			if(criteria4file .size()>0) {
//			PdfPCell cell0078 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table14criteria4.addCell(cell0078);
//			}
//			PdfPCell cell0079 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			table14criteria4.addCell(cell0079);
//			if(criteria4file.size()>0) {
//			PdfPCell cell0080 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//
//			table14criteria4.addCell(cell0080);
//			}
//			PdfPCell cell00770 = new PdfPCell(new Paragraph(
//					"4.2.4 Percentage per day usage of library by teachers and students ( foot falls and login data for online access) during the latest completed academic year\r\n"
//							+ "\r\n\r\n\r\n" + "Response: "
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse424()
//									: ""),font3));
//			
//			table15.addCell(cell00770);
//
//
//			PdfPCell cell007701 = new PdfPCell(new Paragraph(("4.2.4.1 Number of teachers and students using library per day over last one year\r\n" + "\r\n"
//					+ "Response: "
//					+ (criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getInput4241t1() : "")),font3));
//
//			table15.addCell(cell007701);
//			table15.addCell(table14criteria4);
//
//			table15.setSpacingBefore(20f);
//			table15.setSpacingAfter(20f);
//
//			document.add(table15);
//
//		
//		
//				
//		
//			document.close();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//			
//		}
//				
//			
//		}