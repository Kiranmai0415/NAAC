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
//public class UniversityCriteria41Report {
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
//				System.out.println("utile");
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
//			Paragraph paragraph2criteria4 = new Paragraph("4.1 Physical Facilities", font2);
//			paragraph2criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph2criteria4);
//
//			/*
//			 * Font font2criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font2criteria4.setSize(12);
//			 */
//
//			PdfPTable table01criteria4 = new PdfPTable(1);
//
//			table01criteria4.setWidthPercentage(100);
//			PdfPCell cell0criteria4 = new PdfPCell(new Paragraph(
//					"4.1.1 The Institution has adequate infrastructure and physical facilities for teaching- learning. viz., classrooms, laboratories, computing equipment etc.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse411()
//									: ""),
//					font3));
//
//			table01criteria4.addCell(cell0criteria4);
//
//		
//
//			table01criteria4.setSpacingBefore(20f);
//			table01criteria4.setSpacingAfter(20f);
//
//			document.add(table01criteria4);
//
//
//			
//			PdfPTable table2 = new PdfPTable(2);
//			table2.setWidthPercentage(100);
//
//			PdfPCell cell001criteria4 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			table2.addCell(cell001criteria4);
//			PdfPCell cell002criteria4 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table2.addCell(cell002criteria4);
//			PdfPCell cell003criteria4 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n "));
//			table2.addCell(cell003criteria4);
//			PdfPCell cell004criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table2.addCell(cell004criteria4);
//	
//			PdfPCell cell005criteria4 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			table2.addCell(cell005criteria4);
//			PdfPCell cell006criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table2.addCell(cell006criteria4);
//			
//
//			table2.setSpacingBefore(20f);
//			table2.setSpacingAfter(20f);
//
//			document.add(table2);
//
//	
//			// Creating a table of 3 columns
//			PdfPTable table4criteria4 = new PdfPTable(2);
//			PdfPTable table412criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table4criteria4.setWidthPercentage(100);
//			table412criteria4.setWidthPercentage(100);
//
//			PdfPCell cell007 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//			table4criteria4.addCell(cell007);
//			PdfPCell cell008 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table4criteria4.addCell(cell008);
//			PdfPCell cell0009 = new PdfPCell(new Paragraph(" Upload Any additional information\r\n\r\n"));
//			table4criteria4.addCell(cell0009);
//
//			PdfPCell cell0010 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table4criteria4.addCell(cell0010);
//	
//			PdfPCell cell0011 = new PdfPCell(new Paragraph("Geotagged pictures\r\n\r\n"));
//			
//			table4criteria4.addCell(cell0011);
//			PdfPCell cell0012 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table4criteria4.addCell(cell0012);
//		
//			PdfPCell cell0013 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			table4criteria4.addCell(cell0013);
//			PdfPCell cell0014 = new PdfPCell(new Paragraph(""));
//			table4criteria4.addCell(cell0014);
//
//			PdfPCell cell412criteria4 = new PdfPCell(new Paragraph(
//					"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria4Fieldinfo != null
//							? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse412()
//									: ""),
//					font3));
//
//			table412criteria4.addCell(cell412criteria4);
//			document.add(table412criteria4);
//			document.add(table4criteria4);
//			
//			// Creating a table of columns
//			PdfPTable table5criteria4 = new PdfPTable(2);
//			PdfPTable table51 = new PdfPTable(1);
//			table5criteria4.setWidthPercentage(100);
//			table51.setWidthPercentage(100);
//		
//			PdfPCell cell0015 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//			table5criteria4.addCell(cell0015);
//			
//			PdfPCell cell0016 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table5criteria4.addCell(cell0016);
//			
//			PdfPCell cell0017 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n"));
//			table5criteria4.addCell(cell0017);
//	
//			PdfPCell cell0018 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table5criteria4.addCell(cell0018);
//	
//			PdfPCell cell0019 = new PdfPCell(new Paragraph("Provide the link for additional informationt\r\n\r\n\r\n"));
//			table5criteria4.addCell(cell0019);
//		
//			PdfPCell cell0020 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table5criteria4.addCell(cell0020);
//		
//			PdfPCell cell0021 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			table5criteria4.addCell(cell0021);
//			PdfPCell cell0022 = new PdfPCell(new Paragraph());
//			table5criteria4.addCell(cell0022);
//		
//           
//		
//			PdfPCell cell4120criteria4 = new PdfPCell(new Paragraph(
//					"4.1.3 Availability of general campus facilities and overall ambience\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria4Fieldinfo != null
//							? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse413()
//									: ""),font3));
//			table51.addCell(cell4120criteria4);
//
//
//
//		
//			PdfPCell cell41200criteria4 = new PdfPCell(new Paragraph("4.1.3.1 Number of classrooms and seminar halls with ICT facilities\r\n Response: "
//					+ (criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getInput4131t1() : ""),font3));
//			 table51.addCell(cell41200criteria4);
//			
//
//			table51.setSpacingBefore(20f);
//			table51.setSpacingAfter(20f);
//
//			document.add(table51);
//			document.add(table5criteria4);
//			// Creating a table of 3 columns
//			
//
//			
//			PdfPTable table6criteria4 = new PdfPTable(2);
//			PdfPTable table61criteria4 = new PdfPTable(1);
//			table61criteria4.setWidthPercentage(100);
//			if(criteria4Record.getCriteria4FieldInfoQn().size() >0) {
//			PdfPCell cell41201criteria4 = new PdfPCell(new Paragraph(
//					"4.1.4 Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)\r\n"
//							+ "\r\n" + "Response: "
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse414()
//									: ""),font3));
//			table61criteria4.addCell(cell41201criteria4);
//			}
//			
//			PdfPCell cell41202criteria4 = new PdfPCell(new Paragraph(
//					"4.1.4.1 Expenditure for infrastructure augmentation, excluding salary year-wise during last five years (INR in lakhs)\r\n\r\n",font3));
//
//			
//			
//			table61criteria4.addCell(cell41202criteria4);
//			
//			table61criteria4.addCell(table6criteria4);
//
//			table61criteria4.setSpacingBefore(20f);
//			table61criteria4.setSpacingAfter(20f);
//
//			document.add(table61criteria4);
//
//			if (criteria4Record.getYearTable4141().size() >0) {
//
//				Table table4141 = new Table(criteria4Record.getYearTable4141().size(), 2);
//
//				table4141.setPadding(10);
//				table4141.setWidth(100f);
//
//				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
//					table4141.addCell(criteria4Record.getYearTable4141().get(i).getInput4141y());
//
//				}
//				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
//					table4141.addCell(criteria4Record.getYearTable4141().get(i).getInput4141v());
//
//				}
//
//				document.add(table4141);
//			}
//
//			
//			
//
//			if (criteria4Record.getYearTable41412().size() >0) {
//
//				Table table41412 = new Table(criteria4Record.getYearTable41412().size(), 2);
//
//				table41412.setPadding(10);
//				table41412.setWidth(100f);
//
//				for (int i = 0; i < criteria4Record.getYearTable41412().size(); i++) {
//					table41412.addCell(criteria4Record.getYearTable41412().get(i).getInput41412y());
//
//				}
//				for (int i = 0; i < criteria4Record.getYearTable41412().size(); i++) {
//					table41412.addCell(criteria4Record.getYearTable41412().get(i).getInput41412v());
//
//				}
//
//				document.add(table41412);
//			}
//			
//			
//			// Creating a table of 3 columns
//			PdfPTable table7criteria4 = new PdfPTable(2);
//
//			// Setting width of table, its columns and spacing
//			table7criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0033 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//			table7criteria4.addCell(cell0033);
//		
//			PdfPCell cell0034 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table7criteria4.addCell(cell0034);
//			PdfPCell cell0035 = new PdfPCell(
//					new Paragraph("Upload any additional information\r\n\r\n "));
//			table7criteria4.addCell(cell0035);
//		
//		
//			PdfPCell cell0036 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(4).getCriteria4FilePath() : ""));
//			table7criteria4.addCell(cell0036);
//
//			PdfPCell cell0037 = new PdfPCell(new Paragraph("Upload audited utilization statements\r\n\r\n"));
//			table7criteria4.addCell(cell0037);
//	
//			PdfPCell cell0038 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(5).getCriteria4FilePath() : ""));
//			table7criteria4.addCell(cell0038);
//			
//			PdfPCell cell0039 = new PdfPCell(new Paragraph("Upload Details of Expenditure, excluding salary during the last five years\r\n\r\n"));
//			table7criteria4.addCell(cell0039);
//	
//			PdfPCell cell0040 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table7criteria4.addCell(cell0040);
//	
//			
//			
//
//			table7criteria4.setSpacingBefore(20f);
//			table7criteria4.setSpacingAfter(20f);
//
//			document.add(table7criteria4);
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