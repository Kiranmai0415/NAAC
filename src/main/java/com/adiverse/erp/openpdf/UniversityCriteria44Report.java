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
//public class UniversityCriteria44Report {
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
//			Paragraph paragraph50 = new Paragraph("4.4 Maintenance of Campus Infrastructure\r\n\r\n\r\n" + "", font2);
//			paragraph50.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph50);
//
//			// Creating a table of 3 columns
//
//			
//			PdfPTable table25criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			
//			table25criteria4.setWidthPercentage(100);
//
//			PdfPCell cell001091 = new PdfPCell(new Paragraph(
//					"4.4.1 Average percentage expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component during the last five years\r\n\r\n"
//							+ " Response: "
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse441()
//									: ""),font3));
//
//			// table25criteria4.addCell(criteria4List.get(0).getResponseValue441());
//
//			PdfPCell cell0010911 = new PdfPCell(new Paragraph(
//					"4.4.1.1 Expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component year wise during the last five years (INR in lakhs)\r\n\r\n",font3));
//
//			table25criteria4.addCell(cell001091);
//			table25criteria4.addCell(cell0010911);
//			
//			table25criteria4.setSpacingBefore(20f);
//			table25criteria4.setSpacingAfter(20f);
//
//			document.add(table25criteria4);
//
//			if (criteria4Fieldinfo != null) {
//
//				Table table4411 = new Table(criteria4Fieldinfo.getYearTable4411().size(), 2);
//
//				table4411.setPadding(10);
//				table4411.setWidth(100f);
//
//				for (int i = 0; i < criteria4Fieldinfo.getYearTable4411().size(); i++) {
//					table4411.addCell(criteria4Fieldinfo.getYearTable4411().get(i).getInput4411y());
//
//				}
//				for (int i = 0; i < criteria4Fieldinfo.getYearTable4411().size(); i++) {
//					table4411.addCell(criteria4Fieldinfo.getYearTable4411().get(i).getInput4411v());
//
//				}
//
//				document.add(table4411);
//
//			}
//			
//
//			if (criteria4Fieldinfo != null) {
//
//				Table table44112 = new Table(criteria4Fieldinfo.getYearTable44112().size(), 2);
//
//				table44112.setPadding(10);
//				table44112.setWidth(100f);
//
//				for (int i = 0; i < criteria4Fieldinfo.getYearTable44112().size(); i++) {
//					table44112.addCell(criteria4Fieldinfo.getYearTable44112().get(i).getInput44112y());
//
//				}
//				for (int i = 0; i < criteria4Fieldinfo.getYearTable44112().size(); i++) {
//					table44112.addCell(criteria4Fieldinfo.getYearTable44112().get(i).getInput44112v());
//
//				}
//
//				document.add(table44112);
//
//			}
//
//			PdfPTable table26criteria4 = new PdfPTable(2);
//			table26criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00123 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			table26criteria4.addCell(cell00123);
//			PdfPCell cell00124 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			table26criteria4.addCell(cell00124);
//			PdfPCell cell00125 = new PdfPCell(new Paragraph("Upload any additional information	"));
//			table26criteria4.addCell(cell00125);
//		
//			PdfPCell cell00126 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table26criteria4.addCell(cell00126);
//	
//			PdfPCell cell00127 = new PdfPCell(new Paragraph("Audited statements of accounts"));
//			table26criteria4.addCell(cell00127);
//		
//			PdfPCell cell00128 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table26criteria4.addCell(cell00128);
//		
//			PdfPCell cell000127 = new PdfPCell(new Paragraph("Details about assigned budget and expenditure on physical facilities and academic facilities"));
//			table26criteria4.addCell(cell000127);
//		
//			PdfPCell cell000128 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table26criteria4.addCell(cell000128);
//		
//			
//			
//			
//			
//			
//			
//			document.add(table26criteria4);
//
//			/*
//			 * Font fontParagraph47 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph47.setSize(12);
//			 */
//
//			Paragraph paragraph51 = new Paragraph(
//					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse442()
//									: ""),
//					font2);
//
//			PdfPTable table442criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table442criteria4.setWidthPercentage(100);
//
//			PdfPCell cell001271 = new PdfPCell(new Paragraph(
//					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\\r\\n\"\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse442()
//									: ""),font3));
//			// table442criteria4.addCell(criteria4List.get(0).getResponseValue442());
//			table442criteria4.addCell(cell001271);
//
//			document.add(table442criteria4);
//
//		
//
//			
//
//			PdfPTable table27criteria4 = new PdfPTable(2);
//			table27criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00129 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			table27criteria4.addCell(cell00129);
//			PdfPCell cell00130 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			table27criteria4.addCell(cell00130);
//			PdfPCell cell00131 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			table27criteria4.addCell(cell00131);
//			if(criteria4file.size()>0) {
//			PdfPCell cell00132 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table27criteria4.addCell(cell00132);
//			}
//			PdfPCell cell00133 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell00134 = new PdfPCell(new Paragraph(" "));
//
//			
//			table27criteria4.addCell(cell00133);
//			table27criteria4.addCell(cell00134);
//
//			table27criteria4.setSpacingBefore(20f);
//			table27criteria4.setSpacingAfter(20f);
//
//			document.add(table27criteria4);
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