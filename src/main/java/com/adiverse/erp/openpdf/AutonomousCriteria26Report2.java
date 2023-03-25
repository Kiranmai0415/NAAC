//package com.adiverse.erp.openpdf;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import org.apache.commons.collections4.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.adiverse.erp.model.Criteria1_FileUpload;
//import com.adiverse.erp.model.Criteria2_FieldInfo;
//import com.adiverse.erp.model.Criteria2_FileUpload;
//import com.adiverse.erp.service.Criteria2Service;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//@Service
//public class AutonomousCriteria26Report2 {
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//   @Autowired
//   Criteria2Service service2;
//   
//   
//	List<Criteria2_FieldInfo> criteria2List = null;
//	Criteria2_FieldInfo criteria2Record = null;
//	List<Criteria2_FileUpload> criteria2file = null;
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//
//public String generateReport(Criteria2_FieldInfo criteria2Fieldinfo) throws DocumentException, IOException {
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
//			
//
//			criteria2List = service2.getAllCriteria2Data();
//			if (CollectionUtils.isNotEmpty(criteria2List)) {
//				criteria2Record = criteria2List.get(0);
//				criteria2file = criteria2Record.getCriteria2FileUpload();
//			} else {
//				criteria2Record = new Criteria2_FieldInfo();
//			}
//			
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AuthonomousCriteria2Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//			
//		
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
//	// PdfPTable table4criteria2 = new PdfPTable(5);
//
//	// PdfPTable table5criteria2= new PdfPTable(5);
//
//			PdfPTable table3criteria2 = new PdfPTable(2);
//
//			PdfPTable table6criteria2 = new PdfPTable(5);
//			PdfPTable table7criteria2 = new PdfPTable(2);
//
//			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
//		
//			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		
//			document.add(paragraph2criteria2);
//	
//
//			tablecriteria2.setWidthPercentage(100f);
//
//
//			Paragraph paragraph8criteria2 = new Paragraph("2.6 Student Performance and Learning Outcomes\r\r\n\n", font2);
//
//			paragraph8criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph8criteria2);
//			
//			
//
//			PdfPTable table27 = new PdfPTable(1);
//
//			PdfPCell cell012 = new PdfPCell(new Paragraph(
//					"2.6.1 Programme and course outcomes for all Programmes offered by the institution are stated and displayed on website and communicated to teachers and students."
//							 + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse261()
//									: "")
//							+"" ));
//
//			table27.addCell(cell012);
//			document.add(cell012);
//			
//			PdfPTable table28 = new PdfPTable(2);
//
//			table28.setWidthPercentage(100f);
//			table28.setWidths(new int[] { 3, 3 });
//			table28.setSpacingBefore(5);
//
//			PdfPCell cell79criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table28.addCell(cell79criteria2);
//
//			PdfPCell cell80criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table28.addCell(cell80criteria2);
//
//			PdfPCell cell81criteria2 = new PdfPCell(new Paragraph("Upload COs for all courses (exemplars from Glossary)\r\n\r\n"));
//			table28.addCell(cell81criteria2);
//
//			PdfPCell cell82criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : ""));
//			table28.addCell(cell82criteria2);
//
//			PdfPCell cell83criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
//			table28.addCell(cell83criteria2);
//
//			PdfPCell cell84criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(2).getCriteria2FilePath() :""));
//			table28.addCell(cell84criteria2);
//			
//			PdfPCell cell83criteria21 = new PdfPCell(new Paragraph("Upload COs for all courses (exemplars from Glossary)\r\n\r\n"));
//			table28.addCell(cell83criteria21);
//
//			PdfPCell cell84criteria21 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : ""));
//			table28.addCell(cell84criteria21);
//			
//			
//
//			document.add(table28);
//			
//			
//
//			PdfPTable table29 = new PdfPTable(1);
//			table29.setWidthPercentage(100f);
//
//			PdfPCell cell013 = new PdfPCell(new Paragraph(
//					"2.6.2 Attainment of programme outcomes and course outcomes are evaluated by the institution." + "\r\n"
//							+ "" + "" + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse262()
//									: "")));
//						
//			table29.addCell(cell013);
//			document.add(table29);
//			
//
//			PdfPTable table30 = new PdfPTable(2);
//
//			table30.setWidthPercentage(100f);
//			table30.setWidths(new int[] { 3, 3 });
//			table30.setSpacingBefore(5);
//
//			PdfPCell cell85criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table30.addCell(cell85criteria2);
//
//			PdfPCell cell86criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table30.addCell(cell86criteria2);
//
//			PdfPCell cell87criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			table30.addCell(cell87criteria2);
//
//			PdfPCell cell88criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : ""));
//			table30.addCell(cell88criteria2);
//			
//			PdfPCell cell87criteria21 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n"));
//			table30.addCell(cell87criteria21);
//
//			PdfPCell cell88criteria21 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(2).getCriteria2FilePath() : ""));
//			table30.addCell(cell88criteria21);
//
//			document.add(table30);
//			
//			PdfPTable table31criteria2 = new PdfPTable(1);
//			table31criteria2.addCell("2.6.3 Pass Percentage of students(Data for the latest completed academic year)\r\n"
//					+ "\r\n" + "\"Response:"
//					+ (criteria2Record != null ? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse263()
//							: ""));
//			document.add(cell88criteria21);
//			
//			PdfPTable table31criteria21 = new PdfPTable(1);
//			  table31criteria21.
//			  addCell("2.6.3.1 Total number of final year students who passed the examination conducted by Institution. \r\n"
//			  + "\r\n" + "" + "\"Response:"+criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getInput2631t1());
//			  table31criteria21.
//			  addCell("2.6.3.2 Total number of final year students who appeared for the examination conducted by the Institution. \r\n"
//			  + "\r\n" + "" + "\"Response:"+criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getInput2632t2());
//			 
//
//			document.add(table31criteria21);
//		
//			PdfPTable table32 = new PdfPTable(2);
//
//			table32.setWidthPercentage(100f);
//			table32.setWidths(new int[] { 3, 3 });
//			table32.setSpacingBefore(5);
//
//			PdfPCell cell89criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table32.addCell(cell89criteria2);
//
//			PdfPCell cell90criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table32.addCell(cell90criteria2);
//
//			PdfPCell cell91criteria2 = new PdfPCell(new Paragraph(
//					"Upload List of Programmes and number of students passed and appeared in the final year examination(Data Template)\r\n\r\n"));
//			table32.addCell(cell91criteria2);
//
//			PdfPCell cell92criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : ""));
//			table32.addCell(cell92criteria2);
//
//			PdfPCell cell93criteria2 = new PdfPCell(new Paragraph("Paste Link for the annual report\r\n\r\n"));
//			table32.addCell(cell93criteria2);
//
//			PdfPCell cell94criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath():""));
//			table32.addCell(cell94criteria2);
//
//			document.add(table32);
//
//			document.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//	}
//
//		
//
//}
//
