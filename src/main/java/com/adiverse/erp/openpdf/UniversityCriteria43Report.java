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
//public class UniversityCriteria43Report {
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
//			
//
//			Paragraph paragraph38criteria4 = new Paragraph("4.3 IT Infrastructure\r\n\r\n", font2);
//			paragraph38criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph35 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph35.setSize(12);
//			 */
//
//			Paragraph paragraph39criteria4 = new Paragraph(
//					"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n\r\n",font3);
//			paragraph39criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			
//
//
//			document.add(paragraph38criteria4);
//			document.add(paragraph39criteria4);
//			
//			// Creating a table of 3 columns
//
//			
//			PdfPTable table17criteria4 = new PdfPTable(2);
//			PdfPTable table16criteria4 = new PdfPTable(1);
//			table17criteria4.setWidthPercentage(100);
//			table16criteria4.setWidthPercentage(100);
//			// Setting width of table, its columns and spacing
//			
//		
//
//			PdfPCell cell0091 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			table17criteria4.addCell(cell0091);
//			PdfPCell cell0092 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			table17criteria4.addCell(cell0092);
//			PdfPCell cell0093 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			table17criteria4.addCell(cell0093);
//		
//			PdfPCell cell0094 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//			table17criteria4.addCell(cell0094);
//		
//			PdfPCell cell0095 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell0096 = new PdfPCell(new Paragraph(" "));
//
//			
//			
//			
//			
//			table17criteria4.addCell(cell0095);
//			table17criteria4.addCell(cell0096);
//
//			PdfPCell cell431criteria4 = new PdfPCell(new Paragraph(
//					"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse431()
//									: "")));
//			PdfPCell cell4311criteria4 = new PdfPCell(new Paragraph(
//					"4.3.1.1 Number of classrooms and seminar halls with ICT facilities\r\n"
//					+ "Response:"
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getInput431t1()
//									: "")));
//			table16criteria4.addCell(cell431criteria4);
//			table16criteria4.addCell(cell4311criteria4);
//			
//			
//			table16criteria4.addCell(table17criteria4);
//			
//			document.add(table16criteria4);
//
//			// Creating a table of 3 columns
//			PdfPTable table18criteria4 = new PdfPTable(2);
//			PdfPTable table19criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table18criteria4.setWidthPercentage(100);
//			table19criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0097 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table18criteria4.addCell(cell0097);
//			PdfPCell cell0098 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			table18criteria4.addCell(cell0098);
//			PdfPCell cell0099 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			table18criteria4.addCell(cell0099);
//		
//			PdfPCell cell00100 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//			table18criteria4.addCell(cell00100);
//			
//
//			PdfPCell cell00991 = new PdfPCell(new Paragraph("4.3.2 Institution has an IT policy, makes appropriate budgetary provision and updates its IT\r\n"
//					+ "facilities including Wi-Fi facility\r\n"+ "\r\n\r\n" + "Response:"
//					+ (criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse432()
//							: ""),font3));
//			
//
//			table19criteria4.addCell(cell00991);
//			table19criteria4.addCell(table18criteria4);
//
//			table19criteria4.setSpacingBefore(20f);
//			table19criteria4.setSpacingAfter(20f);
//
//			document.add(table19criteria4);
//
//			// Creating a table of 3 columns
//
//			PdfPTable table20criteria4 = new PdfPTable(2);
//			PdfPTable table21criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table20criteria4.setWidthPercentage(100);
//			table21criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00103 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table20criteria4.addCell(cell00103);
//			PdfPCell cell00104 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table20criteria4.addCell(cell00104);
//			PdfPCell cell00105 = new PdfPCell(new Paragraph("Upload any additional information	"));
//			table20criteria4.addCell(cell00105);
//			
//			PdfPCell cell00106 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//             table20criteria4.addCell(cell00106);
//             
//             PdfPCell cell0106 = new PdfPCell(new Paragraph("Student - computer ratio"));
//             table20criteria4.addCell(cell0106);
//             
//             PdfPCell cell01106 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//             table20criteria4.addCell(cell01106);
//	
//
//			PdfPCell cell001040 = new PdfPCell(new Paragraph("4.3.3 Bandwidth of internet connection in the Institution.\r\n" + "\r\n" + "Response:"
//					+ (criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse433()
//							: ""),font3));
//
//			
//
//			table21criteria4.addCell(cell001040);
//			
//			table21criteria4.addCell(table20criteria4);
//			document.add(table21criteria4);
//			
//			
//			PdfPTable table434criteria4 = new PdfPTable(2);
//			PdfPTable table4341criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table434criteria4.setWidthPercentage(100);
//			table4341criteria4.setWidthPercentage(100);
//
//			PdfPCell cell001031 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			table434criteria4.addCell(cell001031);
//			PdfPCell cell001042 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			table434criteria4.addCell(cell001042);
//			PdfPCell cell001053 = new PdfPCell(
//					new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			table434criteria4.addCell(cell001053);
//			
//			PdfPCell cell001064 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//			table434criteria4.addCell(cell001064);
//
//			PdfPCell cell0010531 = new PdfPCell(
//					new Paragraph("Details of available bandwidth of internet connection in the Institution\r\n\r\n\r\n"));
//			table434criteria4.addCell(cell0010531);
//			
//			PdfPCell cell0010641 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//
//			table434criteria4.addCell(cell0010641);
//		
//			PdfPCell cell0010421 = new PdfPCell(new Paragraph("4.3.4 Available bandwidth of internet connection in the Institution (Leased line)\r\n"
//				 + "\r\n" + "Response:"
//					+ (criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse434()
//							: ""),font3));
//
//			// table21criteria4.addCell(criteria4List.get(0).getResponseValue433());
//			
//			table4341criteria4.addCell(cell0010421);
//			table4341criteria4.addCell(table434criteria4);
//			document.add(table4341criteria4);
//
//			// Creating a table of 3 columns
//
//			PdfPTable table22criteria4 = new PdfPTable(2);
//			PdfPTable table23criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table22criteria4.setWidthPercentage(100);
//			table23criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00107 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			table22criteria4.addCell(cell00107);
//			PdfPCell cell00108 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			table22criteria4.addCell(cell00108);
//			PdfPCell cell00109 = new PdfPCell(new Paragraph("Upload any additional information	"));
//			table22criteria4.addCell(cell00109);
//		
//			PdfPCell cell00110 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//			table22criteria4.addCell(cell00110);
//	
//			PdfPCell cell00111 = new PdfPCell(new Paragraph("Provide links to the photographs"));
//			table22criteria4.addCell(cell00111);
//		
//			PdfPCell cell00112 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//			table22criteria4.addCell(cell00112);
//		
//			PdfPCell cell001111 = new PdfPCell(new Paragraph("Facilities for e-content development such as Media Centre, Recording facility, LCS etc (Data Templates as in 3.4.7)"));
//			table22criteria4.addCell(cell001111);
//			PdfPCell cell0013 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//			table22criteria4.addCell(cell0013);
//			
//
//			
//
//			PdfPCell cell001110 = new PdfPCell(new Paragraph("4.3.5	Institution has the following Facilities for e-content development\r\n" + "\r\n"
//					+ "1.	Media centre\r\n" + "2.	Audio visual centre\r\n" + "3.	Lecture Capturing System(LCS)\r\n"
//					+ "4.	Mixing equipments and softwares for editing\r\n" + "\r\n" + "\r\n" + "\r\n" + "Response: "
//					+ (criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse434()
//							: ""),font3));
//
//			// table23criteria4.addCell(criteria4List.get(0).getResponseValue434());
//			table23criteria4.addCell(cell001110);
//			table23criteria4.addCell(table22criteria4);
//
//			table23criteria4.setSpacingBefore(20f);
//			table23criteria4.setSpacingAfter(20f);
//
//			document.add(table23criteria4);
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