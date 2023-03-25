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
//public class AutonomousCriteria21Report2 {
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
//		
//		
//			
//			
//
//			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
//			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph2criteria2);
//			
//			Paragraph paragraph3criteria2 = new Paragraph("2.1 Student Enrollment and Profile\r\n\r\n", font2);
//		
//			paragraph3criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);	
//			document.add(paragraph3criteria2);
//
//			PdfPTable tablecriteria2 = new PdfPTable(1);
//			tablecriteria2.setWidthPercentage(100f);
//			
//			Paragraph paragraph3criteria200 = new Paragraph("2.1.1 Average Enrolment percentage (Average of last five years)\r\n" + "\r\n" + "Response:"
//						+ (criteria2Record != null
//								? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse211()
//									: ""));
//			document.add(paragraph3criteria200);
//			
//			
//			Paragraph paragraph3criteria2000 = new Paragraph("2.1.1.1 Number of students admitted year-wise during last five years\r\n\r\n ");
//
//			document.add(paragraph3criteria2000);
//			
//			
//             if(criteria2Fieldinfo.getYearTable2111() !=null)
//       {
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
//           }
//             
//             
//   
// 			
// 			Paragraph paragraph3criteria11112 = new Paragraph(" 2.1.1.2 Number of sanctioned seats year wise during last five years\r\n" + "\r\n" + " ");
//
// 			document.add(paragraph3criteria11112);
//          
//			
//			if(criteria2Fieldinfo.getYearTable2112() !=null)
//			{
//			Table table2112 = new Table(criteria2Fieldinfo.getYearTable2112().size(), 2);
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
//			}
//			
//			
//			
//			
//			PdfPTable table3criteria2 = new PdfPTable(2);
//			table3criteria2.setWidthPercentage(100f);
//			table3criteria2.setWidths(new int[] { 3, 3 });
//			table3criteria2.setSpacingBefore(5);
//
//			
//			PdfPTable table7criteria2 = new PdfPTable(2);
//			PdfPCell cell1criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table3criteria2.addCell(cell1criteria2);
//
//			PdfPCell cell2criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table3criteria2.addCell(cell2criteria2);
//
//			PdfPCell cell3criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			table3criteria2.addCell(cell3criteria2);
//
//			PdfPCell cell4criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table3criteria2.addCell(cell4criteria2);
//
//			PdfPCell cell5criteria2 = new PdfPCell(new Paragraph("Demand Ratio (Average of Last five years) based on Data Template upload the documentAny\r\n\r\n"));
//			table3criteria2.addCell(cell5criteria2);
//
//			PdfPCell cell6criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : ""));
//			table3criteria2.addCell(cell6criteria2);
//		
//
//			document.add(table3criteria2);
//		
//			
//
//			
//			PdfPTable table1criteria2 = new PdfPTable(1);
//
//			table1criteria2.setWidthPercentage(100f);
//
//			Paragraph paragraph3criteria1111200 = new Paragraph(					"2.1.2 Average percentage of seats filled against reserved categories (SC, ST, OBC, Divyangjan, etc. as per applicable reservation policy ) during the last five years ( exclusive of supernumerary seats)\r\n"
//							+ "\r\n" + "\"Response: "
//						+ (criteria2Fieldinfo != null
//								? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse212()
//								: ""));
//			document.add(paragraph3criteria1111200);
//			
//			
//			Paragraph paragraph3criteria1111299 = new Paragraph(
//					"2.1.2.1 Number of actual students admitted from the reserved categories year wise during last five \r\n"
//							+ "\r\n" + "");
//	
//			document.add(paragraph3criteria1111299);
//			
//			
//
//			if(criteria2Fieldinfo.getYearTable2121() !=null)
//			{
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
//			}
//			
//			
//			
//			
//			Paragraph paragraph2criteria21 = new Paragraph("2.1.2.2: Number of seats earmarked for reserved category as per GOI or state Government rule", font1);
//			paragraph2criteria21.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph2criteria21);	
//			
//
//			if(criteria2Fieldinfo.getYearTable21212() !=null)
//			{
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
//			
//			}
//
//		
//
//			table7criteria2.setWidthPercentage(100f);
//			table7criteria2.setWidths(new int[] { 3, 3 });
//			table7criteria2.setSpacingBefore(5);
//
//			PdfPCell cell07criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table7criteria2.addCell(cell07criteria2);
//
//			PdfPCell cell08criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table7criteria2.addCell(cell08criteria2);
//
//			PdfPCell cell09criteria2 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n"));
//			table7criteria2.addCell(cell09criteria2);
//
//			PdfPCell cell10criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(2).getCriteria2FilePath() : ""));
//			table7criteria2.addCell(cell10criteria2);
//
//			PdfPCell cell11criteria2 = new PdfPCell(new Paragraph("Average percentage of seats filled against seats reserved\r\n\r\n"));
//			table7criteria2.addCell(cell11criteria2);
//
//			PdfPCell cell12criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : ""));
//			table7criteria2.addCell(cell12criteria2);
//
//			document.add(table7criteria2);
//
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
