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
//public class UniversityCriteria25Report2 {
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
//			tablecriteria2.setWidthPercentage(100f);
//			
//			Paragraph paragraph7criteria2 = new Paragraph("2.5	Evaluation Process and Reforms\r\n\r\n", font3);
//
//			paragraph7criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph7criteria2);
//
//			PdfPTable table22 = new PdfPTable(1);
//			table22.setWidthPercentage(100f);
//
//			PdfPCell cell010 = new PdfPCell(new Paragraph(
//					"2.5.1 Average number of days from the date of last semester-end/ year- end examination till the declaration of results year-wise during the last five years"
//							+ "\r\n" + "Response:"
////							+ (criteria2Fieldinfo != null
////									? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse251()
////									: ""),
//					+font3));
//
//			table22.addCell(cell010);
//			
//
//
//
//			table22.addCell(
//					"2.5.1.1 Number of days from the date of last semester-end/ year- end examination till the declaration of results year wise during the last five years\r\n"
//							+ "\r\n" + " ");
//			document.add(table22);
//			Table table2511 = new Table(criteria2Fieldinfo.getYearTable2511().size(), 2);
//
//			table2511.setPadding(10);
//			table2511.setWidth(100f);
//
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2511().size(); i++) {
//				table2511.addCell(criteria2Fieldinfo.getYearTable2511().get(i).getInput2511y());
//			}
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2511().size(); i++) {
//				table2511.addCell(criteria2Fieldinfo.getYearTable2511().get(i).getInput2511v());
//			}
//
//			document.add(table2511);
//
//			
//
//			PdfPTable table24 = new PdfPTable(2);
//
//			table24.setWidthPercentage(100f);
//			table24.setWidths(new int[] { 3, 3 });
//			table24.setSpacingBefore(5);
//
//			PdfPCell cell69criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table24.addCell(cell69criteria2);
//
//			PdfPCell cell70criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table24.addCell(cell70criteria2);
//
//			PdfPCell cell71criteria2 = new PdfPCell(
//					new Paragraph("List of Programmes and date of last semester and\r\n"
//							+ "date of declaration of results\r\n\r\n"));
//			table24.addCell(cell71criteria2);
//if(criteria2file.size()>0) {
//			PdfPCell cell72criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table24.addCell(cell72criteria2);
//}
//			PdfPCell cell73criteria2 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n"));
//			table24.addCell(cell73criteria2);
//
//			PdfPCell cell74criteria2 = new PdfPCell(new Paragraph("", font3));
//			table24.addCell(cell74criteria2);
//
//			document.add(table24);
//
//			PdfPTable table09 = new PdfPTable(1);
//			table09.setWidthPercentage(100f);
//			if(criteria2Fieldinfo.getCriteria2FieldInfoQn() !=null)
//			{
//			PdfPCell cell006 = new PdfPCell(new Paragraph(
//					"2.5.2 Average percentage of student complaints/grievances about evaluation against total number appeared in the examinations during the last five years"
//							+ "\r\n" + "" + "" + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse252()
//									: ""),
//					font3));
//
//			table09.addCell(cell006);
//			
//			}
//
//			table09.addCell(
//					"2.5.2.1 Number of complaints/grievances about evaluation year wise during the last five years\r\n"
//							+ "\r\n" + " ");
//			document.add(table09);
//			Table table2521 = new Table(criteria2Fieldinfo.getYearTable2521().size(), 2);
//
//			table2521.setPadding(10);
//			table2521.setWidth(100f);
//
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2521().size(); i++) {
//				table2521.addCell(criteria2Fieldinfo.getYearTable2521().get(i).getInput2521y());
//			}
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2521().size(); i++) {
//				table2521.addCell(criteria2Fieldinfo.getYearTable2521().get(i).getInput2521v());
//			}
//
//			document.add(table2521);
//			Table table25212 = new Table(criteria2Fieldinfo.getYearTable25212().size(), 2);
//
//			table25212.setPadding(10);
//			table25212.setWidth(100f);
//
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable25212().size(); i++) {
//				table25212.addCell(criteria2Fieldinfo.getYearTable25212().get(i).getInput25212y());
//			}
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable25212().size(); i++) {
//				table25212.addCell(criteria2Fieldinfo.getYearTable25212().get(i).getInput25212v());
//			}
//
//			document.add(table25212);
//
//		
//
//			PdfPTable table18 = new PdfPTable(2);
//
//			table18.setWidthPercentage(100f);
//			table18.setWidths(new int[] { 3, 3 });
//			table18.setSpacingBefore(5);
//
//			PdfPCell cell57 = new PdfPCell(new Paragraph("File Description", font3));
//			table18.addCell(cell57);
//
//			PdfPCell cell58 = new PdfPCell(new Paragraph("Document", font3));
//			table18.addCell(cell58);
//
//			PdfPCell cell59 = new PdfPCell(
//					new Paragraph("Number of complaints and total number of students appeared year wise"));
//			table18.addCell(cell59);
//
//			PdfPCell cell60 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table18.addCell(cell60);
//			
//			PdfPCell cell75criteria2 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n"));
//			table18.addCell(cell75criteria2);
//
//			PdfPCell cell76criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table18.addCell(cell76criteria2);
//
//
//			document.add(table18);
//
//			PdfPTable table25 = new PdfPTable(1);
//			table25.setWidthPercentage(100f);
//
//			PdfPCell cell011 = new PdfPCell(new Paragraph(
//					"2.5.3 IT integration and reforms in the examination procedures and processes including Continuous Internal Assessment (CIA) have brought in considerable improvement in Examination Management System (EMS) of the Institution"
//							+ "\r\n" + "" + "" + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse253()
//									: ""), font3));
//
//			table25.addCell(cell011);
//
//
//
//			document.add(table25);
//
//			PdfPTable table26 = new PdfPTable(2);
//
//			table26.setWidthPercentage(100f);
//			table26.setWidths(new int[] { 3, 3 });
//			table26.setSpacingBefore(5);
//
//			PdfPCell cell751criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table26.addCell(cell751criteria2);
//
//			PdfPCell cell761criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table26.addCell(cell761criteria2);
//
//			PdfPCell cell77criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n"));
//			table26.addCell(cell77criteria2);
//
//			PdfPCell cell78criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table26.addCell(cell78criteria2);
//			
//			PdfPCell cell79criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n"));
//			table26.addCell(cell79criteria2);
//
//			PdfPCell cell7008criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table26.addCell(cell7008criteria2);
//
//			document.add(table26);
//			
//
//			
//			PdfPTable table2611 = new PdfPTable(1);
//			table2611.setWidthPercentage(100f);
//			PdfPCell cell708criteria2 = new PdfPCell(
//					new Paragraph("2.5.4: Status of automation of Examination division along with approved Examination Manual\r\n"
//							+ "A. 100% automation of entire division & implementation of Examination Management System (EMS)\r\n"
//							+ "B. Only student registration, Hall ticket issue & Result Processing\r\n"
//							+ "C. Only student registration and result processing\r\n"
//							+ "D. Only result processing\r\n"
//							+ "\r\n"
//							+ "E. Only manual methodology\r\n"
//							+ ""));
//			table2611.addCell(cell708criteria2);
//
//			document.add(table2611);
//			
//
//			PdfPTable table261 = new PdfPTable(2);
//			table261.setWidthPercentage(100f);
//			PdfPCell cell7511criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table261.addCell(cell7511criteria2);
//
//			PdfPCell cell7611criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table261.addCell(cell7611criteria2);
//
//			PdfPCell cell771criteria2 = new PdfPCell(new Paragraph("Upload any additional information\r\n"));
//			table261.addCell(cell771criteria2);
//
//			PdfPCell cell781criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table261.addCell(cell781criteria2);
//			
//			PdfPCell cell7711criteria2 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n"));
//			table261.addCell(cell7711criteria2);
//
//			PdfPCell cell7811criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table261.addCell(cell7811criteria2);
//
//			
//			PdfPCell cell7721criteria2 = new PdfPCell(new Paragraph("Institutional data in prescribed format	\r\n"));
//			table261.addCell(cell7721criteria2);
//
//			PdfPCell cell7821criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table261.addCell(cell7821criteria2);
//
//			PdfPCell cell7731criteria2 = new PdfPCell(new Paragraph("Institutional data in prescribed format and\r\n"));
//			table26.addCell(cell7731criteria2);
//
//			PdfPCell cell7841criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table261.addCell(cell7841criteria2);
//
//			document.add(table261);
//
//			document.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//	}
//	
//}
