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
//public class UniversityCriteria21Report2 {
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
//			
//
//		
//			
//
//			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
//			Paragraph paragraph3criteria2 = new Paragraph("2.1 Student Enrollment and Profile\r\n\r\n", font2);
//
//			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			paragraph3criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph2criteria2);
//			document.add(paragraph3criteria2);
//
//			tablecriteria2.setWidthPercentage(100f);
//			PdfPCell cell100criteria2 = new PdfPCell(new Paragraph("2.1.1 Demand Ratio (Average of last five years)\r\n"
//						 + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse211()
//									: "")));
//			tablecriteria2.addCell(cell100criteria2);
//			
//			tablecriteria2.addCell("2.1.1.1: Number of seats available year wise during the last five years\r\n\r\n ");
//			tablecriteria2.addCell("2.1.1.2: Total number of eligible applications received\r\n\r\n ");
//
//			document.add(tablecriteria2);
//
//			Table table2111 = new Table(criteria2Fieldinfo.getYearTable2111().size(), 2);
//
//			table2111.setPadding(10);
//			table2111.setWidth(100f);
//
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2111().size(); i++) {
//				table2111.addCell(criteria2Fieldinfo.getYearTable2111().get(i).getInput2111y());
//			}
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2111().size(); i++) {
//				table2111.addCell(criteria2Fieldinfo.getYearTable2111().get(i).getInput2111v());
//			}
//
//			document.add(table2111);
//
//		Table table2112 = new Table(criteria2Fieldinfo.getYearTable2112().size(), 2);
//
//			table2112.setPadding(10);
//			table2112.setWidth(100f);
//
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2112().size(); i++) {
//				table2112.addCell(criteria2Fieldinfo.getYearTable2112().get(i).getInput2112y());
//			}
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2112().size(); i++) {
//				table2112.addCell(criteria2Fieldinfo.getYearTable2112().get(i).getInput2112v());
//			}
//
//			document.add(table2112);
//
//			PdfPTable table3criteria2 = new PdfPTable(2);
//			table3criteria2.setWidthPercentage(100);
//			
//
//			PdfPCell cell1criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font3));
//			table3criteria2.addCell(cell1criteria2);
//
//			PdfPCell cell2criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			table3criteria2.addCell(cell2criteria2);
//
//			PdfPCell cell3criteria2 = new PdfPCell(new Paragraph("\r\nDemand Ratio (Average of Last five years) based on Data Template upload the document\r\n"));
//			table3criteria2.addCell(cell3criteria2);
//
//			PdfPCell cell4criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table3criteria2.addCell(cell4criteria2);
//
//			PdfPCell cell5criteria2 = new PdfPCell(new Paragraph("\r\nAny additional informatio\r\n"));
//			table3criteria2.addCell(cell5criteria2);
//
//			PdfPCell cell6criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table3criteria2.addCell(cell6criteria2);
//
//
//			document.add(table3criteria2);
//			table3criteria2.setSpacingAfter(20);
//			table3criteria2.setSpacingBefore(20);
//			
//			table1criteria2.setWidthPercentage(100f);
//
//			PdfPCell cell600criteria2 = new PdfPCell(
//					new Paragraph(
//					"2.1.2 Average percentage of seats filled against reserved categories (SC, ST, OBC, Divyangjan, etc. as per applicable reservation policy ) during the last five years ( exclusive of supernumerary seats)\r\n"
//					 +"Response: "
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse212()
//									: "")));
//			PdfPCell cell601criteria2 = new PdfPCell(new Paragraph(("2.1.2.1 Number of actual students admitted from the reserved categories year wise during last five \r\n\r\n" )));
//			PdfPCell cell602criteria2 = new PdfPCell(new Paragraph("2.1.2.1: Number of seats earmarked for reserved category as per GOI or state Government rule"));
//
//			table1criteria2.addCell(cell600criteria2);
//			table1criteria2.addCell(cell601criteria2);
//			table1criteria2.addCell(cell602criteria2);
//			document.add(table1criteria2);
//			
//			
//			
//			Table table2121 = new Table(criteria2Fieldinfo.getYearTable2121().size(), 2);
//
//			table2121.setPadding(10);
//			table2121.setWidth(100f);
//
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2121().size(); i++) {
//				table2121.addCell(criteria2Fieldinfo.getYearTable2121().get(i).getInput2121y());
//			}
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2121().size(); i++) {
//				table2121.addCell(criteria2Fieldinfo.getYearTable2121().get(i).getInput2121v());
//			}
//
//			document.add(table2121);
//
//			
//			Table table21212 = new Table(criteria2Fieldinfo.getYearTable21212().size(), 2);
//
//			table21212.setPadding(10);
//			table21212.setWidth(100f);
//
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable21212().size(); i++) {
//				table21212.addCell(criteria2Fieldinfo.getYearTable21212().get(i).getInput21212y());
//			}
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable21212().size(); i++) {
//				table21212.addCell(criteria2Fieldinfo.getYearTable21212().get(i).getInput21212v());
//			}
//
//			document.add(table21212);
//
//			PdfPTable table07criteria2 = new PdfPTable(2);
//            table07criteria2.setWidthPercentage(100);
//			PdfPCell cell07criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font3));
//			table07criteria2.addCell(cell07criteria2);
//
//			PdfPCell cell08criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			table07criteria2.addCell(cell08criteria2);
//
//			PdfPCell cell09criteria2 = new PdfPCell(new Paragraph("\r\nAverage percentage of seats filled against seats\r\n"
//					+ "reserved (Data Template)\r\n+\r\n"));
//			table07criteria2.addCell(cell09criteria2);
//
//			PdfPCell cell10criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table07criteria2.addCell(cell10criteria2);
//
//			PdfPCell cell11criteria2 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n"));
//			table07criteria2.addCell(cell11criteria2);
//
//			PdfPCell cell12criteria2 = new PdfPCell(new Paragraph(""));
//			table07criteria2.addCell(cell12criteria2);
//
//			document.add(table07criteria2);
//
//			
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
