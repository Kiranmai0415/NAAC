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
//import org.springframework.stereotype.Component;
//
//import com.adiverse.erp.model.Criteria5_FieldInfo;
//import com.adiverse.erp.model.Criteria5_FileUpload;
//import com.adiverse.erp.service.Criteria5Service;
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
//
//
//@Component
//public class AutonomousCriteria52Report 
//{
//	
//
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//	
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//	
//	@Autowired
//	Criteria5Service service5;
//
//
//
//		///////////////////////////////////////////////////////////////////////////////////////////
//		// criteria 5 start here
//		//////////////////////////////////////////////////////////////////////////////////////////
//
//		//java.util.List<Criteria5_FieldInfo> criteria5List1 = service5.getAllCriteria5Data();
//
//		// criteria5Record1 = criteria5List1.get(0);
//
//		//java.util.List<Criteria5_FileUpload> criteria5file = criteria5Record1.getCriteria5FileUpload();
//
//		/*
//		 * Font font0 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * font0.setSize(16);
//		 * 
//		 * Font font1criteria5 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * font1criteria5.setSize(14);
//		 * 
//		 * Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * font2.setSize(12);
//		 * 
//		 * // Font font3=FontFactory.getFont(FontFactory.HELVETICA); //
//		 * font.setSize(16);
//		 * 
//		 * // Font font4=FontFactory.getFont(FontFactory.HELVETICA); //
//		 * font1.setSize(14);
//		 * 
//		 * Font font5criteria5 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * font5criteria5.setSize(12);
//		 */
//
//		
//		
//		
//		
//		
//		List<Criteria5_FieldInfo> criteria5List = null;
//		Criteria5_FieldInfo criteria5Record = null;
//		List<Criteria5_FileUpload> criterai5file = null;
//		
//		
//		public String generateReport(Criteria5_FieldInfo criteria5Fieldinfo) throws DocumentException, IOException {
//			
//			System.out.println("cr 5.2");
//			String reportPath = "";
//			Path root = Paths.get(reportGeneratePath);
//			Path file = null;
//			Date date = new Date();
//			try {
//				font1.setSize(16);
//				font2.setSize(14);
//				font3.setSize(12);
//				font4.setSize(14);
//				font5.setSize(12);
//				criteria5List = service5.getAllCriteria5Data();
//				if (CollectionUtils.isNotEmpty(criteria5List)) {
//					criteria5Record = criteria5List.get(0);
//					criterai5file = criteria5Record.getCriteria5FileUpload();
//				} else {
//					criteria5Record = new Criteria5_FieldInfo();
//					criterai5file = new ArrayList<>();
//				}
//				System.out.println("report generation path from property file ==>" + reportGeneratePath);
//				if (root != null) {
//					SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//					String strDate = formatter.format(date);
//					reportPath = "AuthonomousCriteria5Report-" + strDate + ".pdf";
//					file = root.resolve(reportPath);
//				}
//				System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//				
//				
//				Document document = new Document(PageSize.A4);
//				// PdfWriter.getInstance(document, response.getOutputStream());
//				PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//				
//				document.open();
//				System.out.println("open the document==========>");
//		
//		
//		Paragraph paragraph0 = new Paragraph("Criterion 5 - Student Support and Progression\r\n\r\n", font1);
//		paragraph0.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//	document.add(paragraph0);
//
//		Paragraph paragraph03 = new Paragraph("5.2	Student Progression\r\n\r\n\r\n", font2);
//		paragraph03.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		document.add(paragraph03);
//
//		
//
//		Paragraph paragraph030 = new Paragraph(
//				"5.2.1 Average percentage of placement of outgoing students during the last five years\r\n" + "\r\n\r\n"
//						+ "Response: "
//						+ (criteria5Fieldinfo != null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse521()
//								: ""));
//		document.add(paragraph030);
//		Paragraph paragraph031 = new Paragraph(
//				"5.2.1.1 Number of outgoing students placed year - wise during the last five years.", font3);
//        document.add(paragraph031);
////		table061.addCell(cell00009);
////		table061.addCell(cell00010);
////
////		table061.addCell(table06criteria5);
////
////		table061.setSpacingBefore(20f);
////		table061.setSpacingAfter(20f);
////
////		document.add(table061);
//if(criteria5Fieldinfo.getYearTable5211() !=null)
//{
//		Table table5211 = new Table(criteria5Fieldinfo.getYearTable5211().size(), 2);
//
//		table5211.setPadding(10);
//		table5211.setWidth(100f);
//
//		for (int i = 0; i < criteria5Fieldinfo.getYearTable5211().size(); i++) {
//			table5211.addCell(criteria5Fieldinfo.getYearTable5211().get(i).getInput5211y());
//
//		}
//		for (int i = 0; i < criteria5Fieldinfo.getYearTable5211().size(); i++) {
//			table5211.addCell(criteria5Fieldinfo.getYearTable5211().get(i).getInput5211v());
//
//		}
//
//		document.add(table5211);
//			}
//
//PdfPTable table06criteria5 = new PdfPTable(2);
//PdfPTable table061 = new PdfPTable(1);
//
//// Setting width of table, its columns and spacing
//table06criteria5.setWidthPercentage(100);
//table061.setWidthPercentage(100);
//
//PdfPCell cell00043 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//PdfPCell cell00044 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//PdfPCell cell00045 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//PdfPCell cell00046 = new PdfPCell(
//		new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : ""));
//PdfPCell cell00047 = new PdfPCell(new Paragraph("Self attested list of students placed\r\n\r\n\r\n"));
//PdfPCell cell00048 = new PdfPCell(
//		new Paragraph(criteria5Record != null ? criterai5file.get(1).getCriteria5FilePath() : ""));
//PdfPCell cell00049 = new PdfPCell(new Paragraph("Details of student placement during the last five years\r\n\r\n\r\n"));
//PdfPCell cell00050 = new PdfPCell(
//		new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : ""));
//
//table06criteria5.addCell(cell00043);
//table06criteria5.addCell(cell00044);
//table06criteria5.addCell(cell00045);
//table06criteria5.addCell(cell00046);
//table06criteria5.addCell(cell00047);
//table06criteria5.addCell(cell00048);
//table06criteria5.addCell(cell00049);
//table06criteria5.addCell(cell00050);
//
////table061.addCell(cell00009);
////table061.addCell(cell00010);
//
//table061.addCell(table06criteria5);
//
//table061.setSpacingBefore(20f);
//table061.setSpacingAfter(20f);
//document.add(table061);
//
////document.add(table061);
//		PdfPCell cell0111 = new PdfPCell(new Paragraph(
//				"5.2.2 Percentage of student progression to higher education (previous graduating batch).\r\n" + "\r\n"
//						+ "Response:"
//						+ (criteria5Fieldinfo != null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse522()
//								: ""),
//				font3));
//		document.add(cell0111);
//
//		PdfPCell cell0112 = new PdfPCell(new Paragraph(
//				"5.2.2.1 Number of outgoing student progressing to higher education.\r\n" + "\r\n" + "Response: "
//						+ (criteria5Fieldinfo != null ? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getInput5221t1()
//								: ""),
//				font3));
//		document.add(cell0112);
//		PdfPCell cell01131 = new PdfPCell(new Paragraph(
//				"5.2.2.1: Total number of final year students who passed the examination conducted by Institution..\r\n" + "\r\n" + "Response: "
//						+ (criteria5Fieldinfo != null ? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getInput5221t1()
//								: ""),
//				font3));
//document.add(cell01131);
//		
//		PdfPTable table07criteria5 = new PdfPTable(2);
//		PdfPTable table71criteria5 = new PdfPTable(1);
//
//		// Setting width of table, its columns and spacing
//		table07criteria5.setWidthPercentage(100);
//		table71criteria5.setWidthPercentage(100);
//
//		PdfPCell cell51criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell52criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell53criteria5 = new PdfPCell(new Paragraph("Upload supporting data for student/alumni\r\n\r\n\r\n"));
//		PdfPCell cell54criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : ""));
//		PdfPCell cell55criteria5 = new PdfPCell(new Paragraph("Details of student progression to higher education\r\n\r\n\r\n"));
//		PdfPCell cell56criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(1).getCriteria5FilePath() : ""));
//		PdfPCell cell57criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//		PdfPCell cell58criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(2).getCriteria5FilePath() : ""));
//
//		table07criteria5.addCell(cell51criteria5);
//		table07criteria5.addCell(cell52criteria5);
//		table07criteria5.addCell(cell53criteria5);
//		table07criteria5.addCell(cell54criteria5);
//		table07criteria5.addCell(cell55criteria5);
//		table07criteria5.addCell(cell56criteria5);
//		table07criteria5.addCell(cell57criteria5);
//		table07criteria5.addCell(cell58criteria5);
//
//		table71criteria5.setSpacingBefore(20f);
//		table71criteria5.setSpacingAfter(20f);
//
//		document.add(table71criteria5);
//
//		
//
//		PdfPCell cell0113 = new PdfPCell(new Paragraph(
//				"5.2.3 Average percentage of students qualifying in state/national/ international level examinations during the last five years (eg: IIT-JAM/CLAT/ NET/SLET/GATE/ GMAT/CAT/GRE/ TOEFL/ Civil Services/State government examinations, etc.)\r\n"
//						+ "\r\n" + "Response:"
//						+ (criteria5Fieldinfo != null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse523()
//								: ""),
//				font3));
//		document.add(cell0113);
//		PdfPCell cell0114 = new PdfPCell(new Paragraph(
//				"5.2.3.1 Number of students qualifying in state/ national/ international level examinations (eg: IIT/JAM/ NET/ SLET/ GATE/ GMAT/CAT/GRE/ TOEFL/ Civil Services/ State government examinations, etc.)) year-wise during last five years",
//				font3));
//		document.add(cell0114);
//		
//		if(criteria5Fieldinfo.getYearTable5231() !=null)
//		{
//		Table table5231 = new Table(criteria5Fieldinfo.getYearTable5231().size(), 2);
//
//		table5231.setPadding(10);
//		table5231.setWidth(100f);
//
//		for (int i = 0; i < criteria5Fieldinfo.getYearTable5231().size(); i++) {
//			table5231.addCell(criteria5Fieldinfo.getYearTable5231().get(i).getInput5231y());
//
//		}
//		for (int i = 0; i < criteria5Fieldinfo.getYearTable5231().size(); i++) {
//			table5231.addCell(criteria5Fieldinfo.getYearTable5231().get(i).getInput5231v());
//
//		}
//
//		document.add(table5231);
//		}
//
//		PdfPCell cell0115 = new PdfPCell(new Paragraph(
//				"5.2.3.2 Number of students appearing in state/ national/ international level examinations (eg: IIT/JAM/ NET / SLET/ GATE/ GMAT/CAT,GRE/ TOEFL/ Civil Services/ State government examinations) year-wise during last five years"
//						+ "",
//				font3));
//
//		
//		
//document.add(cell0115);
//		
//		
//		if(criteria5Fieldinfo.getYearTable5232() !=null)
//		{
//		Table table5232 = new Table(criteria5Fieldinfo.getYearTable5232().size(), 2);
//
//		table5232.setPadding(10);
//		table5232.setWidth(100f);
//
//		for (int i = 0; i < criteria5Fieldinfo.getYearTable5232().size(); i++) {
//			table5232.addCell(criteria5Fieldinfo.getYearTable5232().get(i).getInput5232y());
//
//		}
//		for (int i = 0; i < criteria5Fieldinfo.getYearTable5232().size(); i++) {
//			table5232.addCell(criteria5Fieldinfo.getYearTable5232().get(i).getInput5232v());
//
//		}
//
//		document.add(table5232);
//
//		}
//		
//		PdfPTable table08criteria5 = new PdfPTable(2);
//		PdfPTable table81criteria5 = new PdfPTable(1);
//
//		// Setting width of table, its columns and spacing
//		table08criteria5.setWidthPercentage(100);
//		table81criteria5.setWidthPercentage(100);
//
//		PdfPCell cell59criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell60criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell61criteria5 = new PdfPCell(new Paragraph("Upload supporting data for student/alumni\r\n\r\n\r\n"));
//		PdfPCell cell62criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : ""));
//		PdfPCell cell63criteria5 = new PdfPCell(new Paragraph(
//				"Number of students qualifying in state/ national/ international level examinations during the last five years\r\n\r\n\r\n"));
//		PdfPCell cell64criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : ""));
//		PdfPCell cell65criteria5 = new PdfPCell(new Paragraph("Any additional information"));
//		PdfPCell cell66criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : ""));
//
//		table08criteria5.addCell(cell59criteria5);
//		table08criteria5.addCell(cell60criteria5);
//		table08criteria5.addCell(cell61criteria5);
//		table08criteria5.addCell(cell62criteria5);
//		table08criteria5.addCell(cell63criteria5);
//		table08criteria5.addCell(cell64criteria5);
//		table08criteria5.addCell(cell65criteria5);
//		table08criteria5.addCell(cell66criteria5);
////		table81criteria5.addCell(cell0113);
////		table81criteria5.addCell(cell0114);
////		table81criteria5.addCell(cell0115);
//
//		table81criteria5.addCell(table08criteria5);
//
//		table81criteria5.setSpacingBefore(20f);
//		table81criteria5.setSpacingAfter(20f);
//
//		document.add(table81criteria5);
//		document.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return file.toAbsolutePath().toString();
//		}
//
//}
