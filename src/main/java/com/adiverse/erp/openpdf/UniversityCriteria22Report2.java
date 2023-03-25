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
//public class UniversityCriteria22Report2 {
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
//
//			document.add(paragraph2criteria2);
//
//	
//
//			Paragraph paragraph4criteria2 = new Paragraph("2.2 Catering to Student Diversity\r\n\r\n", font3);
//			document.add(paragraph4criteria2);
//
//			PdfPTable table01 = new PdfPTable(1);
//			table01.setWidthPercentage(100f);
//			PdfPCell cell120criteria2 = new PdfPCell(new Paragraph(
//					"2.2.1	The institution assesses the learning levels of the students and organises special Programmes for advanced learners and slow learners),\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse221()
//									: "")));
//			
//			table01.addCell(cell120criteria2);
//			
//			document.add(table01);
//
//			PdfPTable table8criteria2 = new PdfPTable(2);
//
//			table8criteria2.setWidthPercentage(100f);
//			table8criteria2.setWidths(new int[] { 3, 3 });
//			table8criteria2.setSpacingBefore(5);
//
//			PdfPCell cell13criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font3));
//			table8criteria2.addCell(cell13criteria2);
//
//			PdfPCell cell14criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			table8criteria2.addCell(cell14criteria2);
//
//			PdfPCell cell15criteria2 = new PdfPCell(new Paragraph("\r\nPaste link for Additional Information\r\n"));
//			table8criteria2.addCell(cell15criteria2);
//
//			PdfPCell cell16criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table8criteria2.addCell(cell16criteria2);
//			
//			PdfPCell cell17criteria2 = new PdfPCell(new Paragraph("Upload any Additional Information"));
//			table8criteria2.addCell(cell17criteria2);
//			PdfPCell cell18criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table8criteria2.addCell(cell18criteria2);
//
//			document.add(table8criteria2);
//
//			PdfPTable table02 = new PdfPTable(1);
//			table02.setWidthPercentage(100f);
//			PdfPCell cell150criteria2 = new PdfPCell(new Paragraph("2.2.2 Student - Full time teacher ratio (Data for the latest completed academic year)\r\n"
//					+ "\r\n" + "Response:"
//					+ (criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse222()
//							: "")));
//			PdfPCell cell151criteria2 = new PdfPCell(new Paragraph("A.Total Number of students enrolled in the institution.\r\n"
//					+ "\r\n" 
//					+ (criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getInput222t1()
//							: "")));
//			PdfPCell cell152criteria2 = new PdfPCell(new Paragraph("B.Total number of full time teachers in the institution.\r\n"
//					+ "\r\n" 
//					+ (criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getInput2221t1()
//							: "")));
//			
//			table02.addCell(cell150criteria2);
//			table02.addCell(cell151criteria2);
//			table02.addCell(cell152criteria2);
//			document.add(table02);
//
//			PdfPTable table9criteria2 = new PdfPTable(2);
//
//			table9criteria2.setWidthPercentage(100f);
//			table9criteria2.setWidths(new int[] { 3, 3 });
//			table9criteria2.setSpacingBefore(5);
//
//			PdfPCell cell107criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font3));
//			table9criteria2.addCell(cell107criteria2);
//
//			PdfPCell cell108criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			table9criteria2.addCell(cell108criteria2);
//
//			PdfPCell cell19criteria2 = new PdfPCell(new Paragraph("\r\n Additional Information\r\n\r\n"));
//			table9criteria2.addCell(cell19criteria2);
//
//			PdfPCell cell20criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table9criteria2.addCell(cell20criteria2);
//
//			document.add(table9criteria2);
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
