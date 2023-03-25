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
//import com.adiverse.erp.model.Criteria5_FieldInfo;
//import com.adiverse.erp.model.Criteria5_FileUpload;
//import com.adiverse.erp.service.Criteria5Service;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.Image;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//@Service
//public class AffiliatedCriteria5Report {
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//	
//	@Autowired
//	Criteria5Service service5;
//	
//	
//	public Image headerImage;
//
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//	
//
//	List<Criteria5_FieldInfo> criteria5List = null;
//	Criteria5_FieldInfo criteria5Record = null;
//	List<Criteria5_FileUpload> criterai5file = null;
//	
//	public String generateReport() throws DocumentException, IOException {
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
//			criteria5List = service5.getAllCriteria5Data();
//			if (CollectionUtils.isNotEmpty(criteria5List)) {
//				criteria5Record = criteria5List.get(0);
//				criterai5file = criteria5Record.getCriteria5FileUpload();
//			} else {
//				criteria5Record = new Criteria5_FieldInfo();
//				criterai5file = new ArrayList<>();
//			}
//
//			
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AffiliatedCriteria5Report-" + strDate + ".pdf";
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
//			Paragraph paragraph0 = new Paragraph("Criterion 5 - Student Support and Progression\r\n\r\n", font1);
//			paragraph0.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph02 = new Paragraph("5.1 Student Support\r\n\r\n", font1);
//			paragraph02.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph0);
//			document.add(paragraph02);
//
//			PdfPTable table01criteria5 = new PdfPTable(2);
//			PdfPTable table011 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table01criteria5.setWidthPercentage(100);
//			table011.setWidthPercentage(100);
//
//			PdfPCell cell1001 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell1002 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell1003 = new PdfPCell(
//					new Paragraph("upload self attested letter with the list of students sanctioned scholarships\r\n\r\n\r\n"));
//			PdfPCell cell1004 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : ""));
//			PdfPCell cell1005 = new PdfPCell(new Paragraph("Upload any additional information Average percentage of students benefited by scholarships and freeships provided by the Government during the last five years (Data Template \r\n\r\n\r\n"));
//			PdfPCell cell1006 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(1).getCriteria5FilePath() : ""));
//			
//
//			table01criteria5.addCell(cell1001);
//			table01criteria5.addCell(cell1002);
//			table01criteria5.addCell(cell1003);
//			table01criteria5.addCell(cell1004);
//			table01criteria5.addCell(cell1005);
//			table01criteria5.addCell(cell1006);
//			
//
//			PdfPCell cell0001 = new PdfPCell(new Paragraph(
//					"5.1.1 Average percentage of students benefited by scholarships and freeships provided by the Government during last five years\r\n"
//							+ "\r\n\r\n" + "Response: "
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getResponse511()
//									: ""),
//					font3));
//			
//			PdfPCell cell00010 = new PdfPCell(new Paragraph(
//					 (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getInput511t1()
//									: ""),
//					font3));
//			
//			PdfPCell cell0002 = new PdfPCell(new Paragraph(
//					"5.1.1.1 Number of students benefited by scholarships and free ships provided by the institution, Government and non-government bodies, industries, individuals, philanthropists during the last five years (other than students receiving scholarships under the government schemes for reserved categories)\r\n\r\n",
//					font3));
//			table011.addCell(cell0001);
//			table011.addCell(cell00010);
//			
//			table011.addCell(cell0002);
//
//			table011.addCell(table01criteria5);
//
//			table011.setSpacingBefore(20f);
//			table011.setSpacingAfter(20f);
//			document.add(table011);
//			
//	         //YEAR TABLE 5111
//			
//			Table table5111 = new Table(criteria5Record.getYearTable5111().size(), 2);
//
//			table5111.setPadding(10);
//			table5111.setWidth(100f);
//
//			for (int i = 0; i < criteria5Record.getYearTable5111().size(); i++) {
//				table5111.addCell(criteria5Record.getYearTable5111().get(i).getInput5111y());
//
//			}
//			for (int i = 0; i < criteria5Record.getYearTable5111().size(); i++) {
//				table5111.addCell(criteria5Record.getYearTable5111().get(i).getInput5111v());
//
//			}
//
//			document.add(table5111);
//
//			// Creating table
//			PdfPTable table02criteria5 = new PdfPTable(2);
//			PdfPTable table021 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table02criteria5.setWidthPercentage(100);
//			table021.setWidthPercentage(100);
//
//			PdfPCell cell00001 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell00002 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00003 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell00004 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(2).getCriteria5FilePath() : ""));
//			PdfPCell cell00005 = new PdfPCell(new Paragraph(
//					"Number of students benefited by scholarships and freeships besides government schemes in last 5 years(Date Template)\r\n\r\n\r\n"));
//			PdfPCell cell00006 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(3).getCriteria5FilePath() : ""));
//			
//			table02criteria5.addCell(cell00001);
//			table02criteria5.addCell(cell00002);
//			table02criteria5.addCell(cell00003);
//			table02criteria5.addCell(cell00004);
//			table02criteria5.addCell(cell00005);
//			table02criteria5.addCell(cell00006);
//		
//			PdfPCell cell0003 = new PdfPCell(new Paragraph(
//					"5.1.2 Average percentage of students benefitted by scholarships, freeships etc. provided by the\r\n"
//					+ "institution / non- government agencies during the last five year"+"1.Soft skills \r\n"
//							+ "2.Language and communication skills \r\n"
//							+ "3.Life skills (Yoga, physical fitness, health and hygiene)\r\n"
//							+ "4.ICT/computing skills"
//					+ "\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getResponse512()
//									: ""),
//					font3));
//			
//			PdfPCell cell00030 = new PdfPCell(new Paragraph(
//					 (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getInput512t1()
//									: ""),
//					font3));
//			
//			
//			
//			
//			
//			PdfPCell cell0004 = new PdfPCell(new Paragraph(
//					"5.1.2.1 Number of students benefited by scholarships and free ships provided by the institution,\r\n"
//					+ "Government and non-government bodies, industries, individuals, philanthropists during the last five\r\n"
//					+ "years (other than students receiving scholarships under the government schemes for reserved\r\n"
//					+ "categories)",
//					font3));
//
//			table021.addCell(cell0003);
//			table021.addCell(cell0004);
//
//			table021.addCell(table02criteria5);
//
//			table021.setSpacingBefore(20f);
//			table021.setSpacingAfter(20f);
//			
//			//year table 5121
//
//			document.add(table021);
//
//			Table table5121 = new Table(criteria5Record.getYearTable5121().size(), 2);
//
//			table5121.setPadding(10);
//			table5121.setWidth(100f);
//
//			for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
//				table5121.addCell(criteria5Record.getYearTable5121().get(i).getInput5121y());
//
//			}
//			for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
//				table5121.addCell(criteria5Record.getYearTable5121().get(i).getInput5121v());
//
//			}
//
//			document.add(table5121);
//
//			PdfPTable table03criteria5 = new PdfPTable(2);
//			PdfPTable table31criteria5 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table03criteria5.setWidthPercentage(100);
//			table31criteria5.setWidthPercentage(100);
//
//			PdfPCell cell00019 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell00020 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00021 = new PdfPCell(new Paragraph("Details of capability building and skills enhancement initiatives (Data Template)\r\n\r\n\r\n"));
//			PdfPCell cell00022 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(4).getCriteria5FilePath() : ""));
//			PdfPCell cell00023 = new PdfPCell(new Paragraph(
//					"Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell00024 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(5).getCriteria5FilePath() : ""));
//			PdfPCell cell00025 = new PdfPCell(new Paragraph("Link to Institutional website"));
//			PdfPCell cell00026 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(6).getCriteria5FilePath() : ""));
//
//			table03criteria5.addCell(cell00019);
//			table03criteria5.addCell(cell00020);
//			table03criteria5.addCell(cell00021);
//			table03criteria5.addCell(cell00022);
//			table03criteria5.addCell(cell00023);
//			table03criteria5.addCell(cell00024);
//			table03criteria5.addCell(cell00025);
//			table03criteria5.addCell(cell00026);
//
//			PdfPCell cell0005 = new PdfPCell(new Paragraph(
//					"5.1.3 Following Capacity development and skills enhancement activities are organised for improving students capability 1. Soft skills 2. Language and communication skills 3. Life skills (Yoga, physical fitness, health and hygiene) 4. Awareness of trends in technology\r\n"
//							+ "\r\n\r\n" + "Response: "
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getResponse513()
//									: ""),
//					font3));
//			PdfPCell cell00050 = new PdfPCell(new Paragraph(
//					 (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getInput513t1()
//									: ""),
//					font3));
//			
//			
//			table31criteria5.addCell(cell0005);
//			table31criteria5.addCell(cell00050);
//	        table31criteria5.addCell(table03criteria5);
//
//			table31criteria5.setSpacingBefore(20);
//			table31criteria5.setSpacingAfter(20);
//
//			document.add(table31criteria5);
//			//Year table5131
//			
////			Table table5131 = new Table(criteria5Record.getAffiliated_YearTable5131().size(), 2);
//	//
////			table5131.setPadding(10);
////			table5131.setWidth(100f);
//	//
////			for (int i = 0; i < criteria5Record.getAffiliated_YearTable5131().size(); i++) {
////				table5131.addCell(criteria5Record.getAffiliated_YearTable5131().get(i).getInput5131y());
//	//
////			}
////			for (int i = 0; i < criteria5Record.getAffiliated_YearTable5131().size(); i++) {
////				table5131.addCell(criteria5Record.getAffiliated_YearTable5131().get(i).getInput5131v());
//	//
////			}
//	//
////			document.add(table5131);
//
//			
//
//			PdfPTable table04criteria5 = new PdfPTable(2);
//			PdfPTable table41criteria5 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table04criteria5.setWidthPercentage(100);
//			table41criteria5.setWidthPercentage(100);
//
//			PdfPCell cell00027 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell00028 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00029 = new PdfPCell(new Paragraph(
//					"Number of students benefited by guidance for competitive examinations and career counselling during the last five years\r\n\r\n\r\n"));
//			PdfPCell cell000300 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(7).getCriteria5FilePath() : ""));
//			PdfPCell cell00031 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell00032 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(8).getCriteria5FilePath() : ""));
//
//			table04criteria5.addCell(cell00027);
//			table04criteria5.addCell(cell00028);
//			table04criteria5.addCell(cell00029);
//			table04criteria5.addCell(cell000300);
//			table04criteria5.addCell(cell00031);
//			table04criteria5.addCell(cell00032);
//
//			PdfPCell cell0006 = new PdfPCell(new Paragraph(
//					"5.1.4 Average percentage of students benefited by career counseling and guidance for competitive examinations as offered by the Institution during the last five years.\r\n"
//							+ "\r\n\r\n" + "Response: "
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getResponse514()
//									: ""),
//					font3));
//			
//			PdfPCell cell00060 = new PdfPCell(new Paragraph(
//					(criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getInput514t1()
//									: ""),
//					font3));
//			
//
//			PdfPCell cell0007 = new PdfPCell(new Paragraph(
//					"5.1.4.1 Number of students benefitted by guidance for competitive examinations and career counselling offered by the institution year wise during last five years",
//					font3));
//
//			table41criteria5.addCell(cell0006);
//			table41criteria5.addCell(cell00060);
//			table41criteria5.addCell(cell0007);
//
//			table41criteria5.addCell(table04criteria5);
//
//			table41criteria5.setSpacingBefore(20f);
//			table41criteria5.setSpacingAfter(20f);
//
//			document.add(table41criteria5);
//			//year table 5141
//
//			Table table5141 = new Table(criteria5Record.getYearTable5141().size(), 2);
//
//			table5141.setPadding(10);
//			table5141.setWidth(100f);
//
//			for (int i = 0; i < criteria5Record.getYearTable5141().size(); i++) {
//				table5141.addCell(criteria5Record.getYearTable5141().get(i).getInput5141y());
//
//			}
//			for (int i = 0; i < criteria5Record.getYearTable5141().size(); i++) {
//				table5141.addCell(criteria5Record.getYearTable5141().get(i).getInput5141v());
//
//			}
//
//			document.add(table5141);
//
//			PdfPTable table05criteria5 = new PdfPTable(2);
//			PdfPTable table051criteria5 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table05criteria5.setWidthPercentage(100);
//			table051criteria5.setWidthPercentage(100);
//
//			PdfPCell cell00035 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell00036 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00037 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell00038 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(9).getCriteria5FilePath() : ""));
//			PdfPCell cell00039 = new PdfPCell(new Paragraph(
//					"Minutes of the meetings of student redressal committee, prevention of sexual harassment committee and Anti Ragging committee\r\n\r\n\r\n"));
//			PdfPCell cell00040 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(10).getCriteria5FilePath() : ""));
//			PdfPCell cell00041 = new PdfPCell(
//					new Paragraph("Details of student grievances including sexual harassment and ragging cases"));
//			PdfPCell cell00042 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(11).getCriteria5FilePath() : ""));
//
//			table05criteria5.addCell(cell00035);
//			table05criteria5.addCell(cell00036);
//			table05criteria5.addCell(cell00037);
//			table05criteria5.addCell(cell00038);
//			table05criteria5.addCell(cell00039);
//			table05criteria5.addCell(cell00040);
//			table05criteria5.addCell(cell00041);
//			table05criteria5.addCell(cell00042);
//
//			PdfPCell cell0008 = new PdfPCell(new Paragraph(
//					"5.1.5 The institution adopts the following for redressal of student grievances including sexual harassment and ragging cases 1. Implementation of guidelines of statutory/regulatory bodies 2.	Organisation wide awareness and undertakings on policies with zero tolerance\r\n"
//							+ "3.	Mechanisms for submission of online/offline students� grievances\r\n"
//							+ "4.	Timely redressal of the grievances through appropriate committees\r\n" + "\r\n"
//							+ "Response: "
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getResponse515()
//									: ""),
//					font3));
//
//			table051criteria5.addCell(cell0008);
//
//			table051criteria5.addCell(table05criteria5);
//
//			table051criteria5.setSpacingBefore(20f);
//			table051criteria5.setSpacingAfter(20f);
//	        document.add(table051criteria5);
//	        
//	        //5.2
//
//			Paragraph paragraph03 = new Paragraph("5.2	Student Progression\r\n\r\n\r\n", font2);
//			paragraph03.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//	        document.add(paragraph03);
//
//			PdfPTable table06criteria5 = new PdfPTable(2);
//			PdfPTable table061 = new PdfPTable(1);
//
//		
//			table06criteria5.setWidthPercentage(100);
//			table061.setWidthPercentage(100);
//
//			PdfPCell cell00043 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell00044 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00045 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell00046 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(12).getCriteria5FilePath() : ""));
//			PdfPCell cell00047 = new PdfPCell(new Paragraph("Self attested list of students placed\r\n\r\n\r\n"));
//			PdfPCell cell00048 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(13).getCriteria5FilePath() : ""));
//			PdfPCell cell00049 = new PdfPCell(new Paragraph("Details of student placement during the last five years\r\n\r\n\r\n"));
//			PdfPCell cell000500= new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(14).getCriteria5FilePath() : ""));
//
//			table06criteria5.addCell(cell00043);
//			table06criteria5.addCell(cell00044);
//			table06criteria5.addCell(cell00045);
//			table06criteria5.addCell(cell00046);
//			table06criteria5.addCell(cell00047);
//			table06criteria5.addCell(cell00048);
//			table06criteria5.addCell(cell00049);
//			table06criteria5.addCell(cell000500);
//
//			PdfPCell cell00009 = new PdfPCell(new Paragraph(
//					"5.2.1 Average percentage of placement of outgoing students during the last five years\r\n" + "\r\n\r\n"
//							+ "Response: "
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getResponse521()
//									: ""),
//					font3));
//			
//			PdfPCell cell000009 = new PdfPCell(new Paragraph(
//					 (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getInput5212t1()
//									: ""),
//					font3));
//			
//			
//			
//			
//			
//			PdfPCell cell000100 = new PdfPCell(new Paragraph(
//					"5.2.1.1 Number of outgoing students placed year - wise during the last five years.", font3));
//			PdfPCell cell0001100 = new PdfPCell(new Paragraph(
//					"5.2.1.2 Number of outgoing students year wise during the last five years", font3));
//			
//
//			table061.addCell(cell00009);
//			table061.addCell(cell000009);
//			table061.addCell(cell000100);
//			table061.addCell(cell0001100); 
//			table061.addCell(table06criteria5);
//
//			table061.setSpacingBefore(20f);
//			table061.setSpacingAfter(20f);
//
//			document.add(table061);
//			//year table 5211
//
//			Table table5211 = new Table(criteria5Record.getYearTable5211().size(), 2);
//
//			table5211.setPadding(10);
//			table5211.setWidth(100f);
//
//			for (int i = 0; i < criteria5Record.getYearTable5211().size(); i++) {
//				table5211.addCell(criteria5Record.getYearTable5211().get(i).getInput5211y());
//
//			}
//			for (int i = 0; i < criteria5Record.getYearTable5211().size(); i++) {
//				table5211.addCell(criteria5Record.getYearTable5211().get(i).getInput5211v());
//
//			}
//
//			document.add(table5211);
//			
////			//year table 5212
////			Table table5212 = new Table(criteria5Record.getAffiliated_YearTable5212().size(), 2);
//	//
////			table5212.setPadding(10);
////			table5212.setWidth(100f);
//	//
////			for (int i = 0; i < criteria5Record.getAffiliated_YearTable5212().size(); i++) {
////				table5212.addCell(criteria5Record.getAffiliated_YearTable5212().get(i).getInput5212y());
//	//
////			}
////			for (int i = 0; i < criteria5Record.getAffiliated_YearTable5212().size(); i++) {
////				table5212.addCell(criteria5Record.getAffiliated_YearTable5212().get(i).getInput5212v());
//	//
////			}
//	//
////			document.add(table5212);
//			
//
//			PdfPTable table07criteria5 = new PdfPTable(2);
//			PdfPTable table71criteria5 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table07criteria5.setWidthPercentage(100);
//			table71criteria5.setWidthPercentage(100);
//
//			PdfPCell cell51criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell52criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell53criteria5 = new PdfPCell(new Paragraph("Upload supporting data for student/alumni\r\n\r\n\r\n"));
//			PdfPCell cell54criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(15).getCriteria5FilePath() : ""));
//			PdfPCell cell55criteria5 = new PdfPCell(new Paragraph("Details of student progression to higher education\r\n"
//					+ "(Data Template)\r\n\r\n\r\n"));
//			PdfPCell cell56criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(16).getCriteria5FilePath() : ""));
//			PdfPCell cell57criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell58criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(17).getCriteria5FilePath() : ""));
//
//			table07criteria5.addCell(cell51criteria5);
//			table07criteria5.addCell(cell52criteria5);
//			table07criteria5.addCell(cell53criteria5);
//			table07criteria5.addCell(cell54criteria5);
//			table07criteria5.addCell(cell55criteria5);
//			table07criteria5.addCell(cell56criteria5);
//			table07criteria5.addCell(cell57criteria5);
//			table07criteria5.addCell(cell58criteria5);
//
//			PdfPCell cell0111 = new PdfPCell(new Paragraph(
//					"5.2.2 Percentage of student progression to higher education (previous graduating batch).\r\n" + "\r\n"
//							+ "Response:"
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getResponse522()
//									: ""),
//					font3));
//
//			PdfPCell cell0112 = new PdfPCell(new Paragraph(
//					"5.2.2.1 Number of outgoing student progressing to higher education.\r\n" + "\r\n" 
//							+ (criteria5Record != null ? criteria5Record.getCriteria5FieldInfoQn().get(0).getInput5221t1()
//									: ""),
//					font3));
//			
//			PdfPCell cell01102 = new PdfPCell(new Paragraph(
//					"5.2.2.2 Number of outgoing student progressing to higher education.\r\n" + "\r\n" 
//							+ (criteria5Record != null ? criteria5Record.getCriteria5FieldInfoQn().get(0).getInput5221t1()
//									: ""),
//					font3));
//			
//
//			table71criteria5.addCell(cell0111);
//			table71criteria5.addCell(cell0112);
//			table71criteria5.addCell(cell01102);
//
//			table71criteria5.addCell(table07criteria5);
//
//			table71criteria5.setSpacingBefore(20f);
//			table71criteria5.setSpacingAfter(20f);
//
//			document.add(table71criteria5);
////			//year table 5221
////			Table table5221 = new Table(criteria5Record.getAffiliated_YearTable5221().size(), 2);
//	//
////			table5221.setPadding(10);
////			table5221.setWidth(100f);
//	//
////			for (int i = 0; i < criteria5Record.getAffiliated_YearTable5221().size(); i++) {
////				table5221.addCell(criteria5Record.getAffiliated_YearTable5221().get(i).getInput5221y());
//	//
////			}
////			for (int i = 0; i < criteria5Record.getAffiliated_YearTable5221().size(); i++) {
////				table5221.addCell(criteria5Record.getAffiliated_YearTable5221().get(i).getInput5221v());
//	//
////			}
//	//
////			document.add(table5221);
//			//year table 5222
//			
////			Table table5222 = new Table(criteria5Record.getAffiliated_YearTable5222().size(), 2);
//	//
////			table5222.setPadding(10);
////			table5222.setWidth(100f);
//	//
////			for (int i = 0; i < criteria5Record.getAffiliated_YearTable5222().size(); i++) {
////				table5222.addCell(criteria5Record.getAffiliated_YearTable5222().get(i).getInput5222y());
//	//
////			}
////			for (int i = 0; i < criteria5Record.getAffiliated_YearTable5222().size(); i++) {
////				table5222.addCell(criteria5Record.getAffiliated_YearTable5222().get(i).getInput5222v());
//	//
////			}
//	//
////			document.add(table5222);
////			
//			
//
//			PdfPTable table08criteria5 = new PdfPTable(2);
//			PdfPTable table81criteria5 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table08criteria5.setWidthPercentage(100);
//			table81criteria5.setWidthPercentage(100);
//
//			PdfPCell cell59criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell60criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell61criteria5 = new PdfPCell(new Paragraph("Upload supporting data for student/alumni\r\n\r\n\r\n"));
//			PdfPCell cell62criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(18).getCriteria5FilePath() : ""));
//			PdfPCell cell63criteria5 = new PdfPCell(new Paragraph(
//					"Number of students qualifying in state/ national/ international level examinations during the last five years\r\n\r\n\r\n"));
//			PdfPCell cell64criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(19).getCriteria5FilePath() : ""));
//			PdfPCell cell65criteria5 = new PdfPCell(new Paragraph("Any additional information"));
//			PdfPCell cell66criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(20).getCriteria5FilePath() : ""));
//
//			table08criteria5.addCell(cell59criteria5);
//			table08criteria5.addCell(cell60criteria5);
//			table08criteria5.addCell(cell61criteria5);
//			table08criteria5.addCell(cell62criteria5);
//			table08criteria5.addCell(cell63criteria5);
//			table08criteria5.addCell(cell64criteria5);
//			table08criteria5.addCell(cell65criteria5);
//			table08criteria5.addCell(cell66criteria5);
//
//			PdfPCell cell0113 = new PdfPCell(new Paragraph(
//					"5.2.3  Average percentage of students qualifying in state/national/ international level examinations\r\n"
//					+ "during the last five years (eg: IIT-JAM/CLAT/ NET/SLET/GATE/ GMAT/CAT/GRE/ TOEFL/\r\n"
//					+ "Civil Services/State government examinations, etc.)\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getResponse523()
//									: ""),
//					font3));
//			
//			
//			
//			PdfPCell cell0114 = new PdfPCell(new Paragraph(
//					"5.2.3.1 Number of students qualifying in state/ national/ international level examinations (eg:\r\n"
//					+ "IIT/JAM/ NET/ SLET/ GATE/ GMAT/CAT/GRE/ TOEFL/ Civil Services/ State government\r\n"
//					+ "examinations, etc.)) year-wise during last five years",
//					font3));
//
//			PdfPCell cell0115 = new PdfPCell(new Paragraph(
//					"5.2.3.2 Number of students appearing in state/ national/ international level examinations (eg:\r\n"
//					+ "JAM/CLAT/NET/ SLET/ GATE/ GMAT/CAT,GRE/ TOFEL/ Civil Services/ State government\r\n"
//					+ "examinations) year-wise during last five years"
//							+ "",
//					font3));
//
//			table81criteria5.addCell(cell0113);
//		
//			table81criteria5.addCell(cell0114);
//			table81criteria5.addCell(cell0115);
//
//			table81criteria5.addCell(table08criteria5);
//
//			table81criteria5.setSpacingBefore(20f);
//			table81criteria5.setSpacingAfter(20f);
//	        document.add(table81criteria5);
//	        //year table 5231
//
//			Table table5231 = new Table(criteria5Record.getYearTable5231().size(), 2);
//
//			table5231.setPadding(10);
//			table5231.setWidth(100f);
//
//			for (int i = 0; i < criteria5Record.getYearTable5231().size(); i++) {
//				table5231.addCell(criteria5Record.getYearTable5231().get(i).getInput5231y());
//
//			}
//			for (int i = 0; i < criteria5Record.getYearTable5231().size(); i++) {
//				table5231.addCell(criteria5Record.getYearTable5231().get(i).getInput5231v());
//
//			}
//
//			document.add(table5231);
//			
//			//year table 5232
//
//			Table table5232 = new Table(criteria5Record.getYearTable5232().size(), 2);
//
//			table5232.setPadding(10);
//			table5232.setWidth(100f);
//
//			for (int i = 0; i < criteria5Record.getYearTable5232().size(); i++) {
//				table5232.addCell(criteria5Record.getYearTable5232().get(i).getInput5232y());
//
//			}
//			for (int i = 0; i < criteria5Record.getYearTable5232().size(); i++) {
//				table5232.addCell(criteria5Record.getYearTable5232().get(i).getInput5232v());
//
//			}
//
//			document.add(table5232);
//			
//			//5.3
//
//			Paragraph paragraph04 = new Paragraph("5.3 Student Participation and Activities", font2);
//			paragraph04.setAlignment(Paragraph.ALIGN_LEFT);
//
//			document.add(paragraph04);
//
//			PdfPTable table09criteria5 = new PdfPTable(2);
//			PdfPTable table91criteria5 = new PdfPTable(1);
//
//		
//			table09criteria5.setWidthPercentage(100);
//			table91criteria5.setWidthPercentage(100);
//
//			PdfPCell cell67criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell68criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell69criteria5 = new PdfPCell(new Paragraph(
//					"Number of awards/medals for outstanding performance in sports/ cultural activities at inter- university / state / national / international level during the last five years\r\n\r\n\r\n"));
//			PdfPCell cell70criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(21).getCriteria5FilePath() : ""));
//			PdfPCell cell71criteria5 = new PdfPCell(new Paragraph("e-copies of award letters and certificates\r\n\r\n\r\n"));
//			PdfPCell cell72criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(22).getCriteria5FilePath() : ""));
//			PdfPCell cell73criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell74criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(23).getCriteria5FilePath() : ""));
//
//			table09criteria5.addCell(cell67criteria5);
//			table09criteria5.addCell(cell68criteria5);
//			table09criteria5.addCell(cell69criteria5);
//			table09criteria5.addCell(cell70criteria5);
//			table09criteria5.addCell(cell71criteria5);
//			table09criteria5.addCell(cell72criteria5);
//			table09criteria5.addCell(cell73criteria5);
//			table09criteria5.addCell(cell74criteria5);
//
//			PdfPCell cell0116 = new PdfPCell(new Paragraph(
//					"5.3.1 Number of awards/medals won by students for outstanding performance in sports/cultural\r\n"
//					+ "activities at inter-university/state/national / international level (award for a team event should be\r\n"
//					+ "counted as one) during the last five years.\r\n"
//							+ "Response:"
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getResponse531()
//									: ""),
//					font3));
//			
//
//			PdfPCell cell01160 = new PdfPCell(new Paragraph(
//					(criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getInput531t1()
//									: ""),
//					font3));
//			
//			
//			PdfPCell cell0117 = new PdfPCell(new Paragraph(
//					"5.3.1.1 Number of awards/medals for outstanding performance in sports/cultural activities at\r\n"
//					+ "university/state/national / international level (award for a team event should be counted as one) yearwise during the last five yea",
//					font3));
//
//			table91criteria5.addCell(cell0116);
//			table91criteria5.addCell(cell01160);
//			table91criteria5.addCell(cell0117);
//
//			table91criteria5.addCell(table09criteria5);
//
//			table91criteria5.setSpacingBefore(20f);
//			table91criteria5.setSpacingAfter(20f);
//
//			document.add(table91criteria5);
//			//year table 5311
//
//			Table table5311 = new Table(criteria5Record.getYearTable5311().size(), 2);
//
//			table5311.setPadding(10);
//			table5311.setWidth(100f);
//
//			for (int i = 0; i < criteria5Record.getYearTable5311().size(); i++) {
//				table5311.addCell(criteria5Record.getYearTable5311().get(i).getInput5311y());
//
//			}
//			for (int i = 0; i < criteria5Record.getYearTable5311().size(); i++) {
//				table5311.addCell(criteria5Record.getYearTable5311().get(i).getInput5311v());
//
//			}
//
//			document.add(table5311);
//
//			PdfPTable table010criteria5 = new PdfPTable(2);
//			PdfPTable table101criteria5 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table010criteria5.setWidthPercentage(100);
//			table101criteria5.setWidthPercentage(100);
//
//			PdfPCell cell75criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell76criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell77criteria5 = new PdfPCell(new Paragraph("Upload any additional information"));
//			PdfPCell cell78criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(24).getCriteria5FilePath() : ""));
//			PdfPCell cell79criteria5 = new PdfPCell(new Paragraph("Paste link for Additional Information\r\n\r\n\r\n"));
//			PdfPCell cell80criteria5 = new PdfPCell(new Paragraph(criteria5Record != null ? criterai5file.get(25).getCriteria5FilePath() : ""));
//
//			table010criteria5.addCell(cell75criteria5);
//			table010criteria5.addCell(cell76criteria5);
//			table010criteria5.addCell(cell77criteria5);
//			table010criteria5.addCell(cell78criteria5);
//			table010criteria5.addCell(cell79criteria5);
//			table010criteria5.addCell(cell80criteria5);
//
//			PdfPCell cell0119 = new PdfPCell(new Paragraph(
//					"5.3.2 Presence of an active Student Council & representation of students on academic & administrative bodies/committees of the institution\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getResponse532()
//									: ""),
//					font3));
//			
//			PdfPCell cell01190 = new PdfPCell(new Paragraph(
//					"5.3.2 Presence of an active Student Council & representation of students on academic & administrative bodies/committees of the institution\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getInput532t1()
//									: ""),
//					font3));
//			
//			PdfPCell cell0120 = new PdfPCell(new Paragraph(
//					"Mother Teresa has a Student Council (SC) comprising nine members. In addition, various bodies constituted by the College also has student representatives. The SC under aegis of Dean, students affairs plans and organizes various co-curricular and extra-curricular activities of the college in association with the college academic committee. Towards this end, various designated committees, viz., Organizing committee, Reception committee, Hospitality committee, Technical Events committee, Campaigning/Public Relations committee, Discipline committee, Cultural programmes committee, Sports committee, Prize Distribution committee, Magazine committee and such others are involved in the organization of Orientation programmes, Fresher�s Day, Alphamatica, Bhaswara, Vaisheshika, Vibgyor and Vibes. In each committee, at least two student representatives/volunteers attend meetings as and when called for. In addition, Mother Teresa celebrates regional, national and international commemoration days and festivals wherein, SC members are involved in the smooth conduct of the events.\r\n"
//							+ "\r\n"
//							+ "SC also contributes to the enhancement of the learning experiences of students through various clubs, namely, Literary, Science, Coding, Mathematical, Fine arts, Photography, Solar, Robotics, Environment, and Srujanastra. Each club is managed by students with the help of a faculty advisor. Various events pertaining to the concerned club are organized after the college hours on regular working days, as well as on Saturdays. In addition, it also facilitates organization of various technical activities through professional bodies namely, Computer Society of India (CSI), Institute of Electrical and Electronic Engineers (IEEE), Institute of Electronics and Telecommunication Engineering (IETE), Indian Society for Technical Education (ISTE) and Society for Automotive Engineering (SAE).\r\n"
//							+ " \r\n"
//							+ "The SC assists in organizing NSS activities of the college, which include conducting various health camps, distribution of school uniforms, books etc for needy children of nearby villages, distribution of various items at old-age homes, facilitating training for development of vocational skills in the people in nearby places, etc.\r\n"
//							+ "\r\n"
//							+ "In addition to the above-mentioned activities, the SC provides necessary help by reaching out appropriate tutorials to the students studying in nearby schools. It also organizes awareness programmes on health, education and environment. In association with NGOs, the SC facilitates conduct of cataract surgeries, organizes blood donation, health/dental camps and distributes medicines. As part of environment campaign, Handmade paper bags were made and distributed, making them aware of the hazards of plastic usage and its consequent disastrous effects on environment. Towards the promotion of Green revolution, every year, SC organizes tree plantation programmes in the nearby villages.\r\n"
//							+ "\r\n"
//							+ "Student representatives are also nominated on the anti-ragging committee, grievance redressal cell and women protection cell. The Entrepreneurship development cell also has SC members with a faculty advisor, to organize various events under the National Entrepreneurship Network (NEN).\r\n"
//							+ "\r\n"
//							+ "IQAC has a representative each from students and alumni. BoS of each department consists of Alumni members.\r\n"
//							+ "Class Review Committees also have student representatives for obtaining feedback on the Teaching- Learning process.\r\n"
//							+ "\r\n"
//							+ "On the whole, the Students Council is a dynamic Body that contributes a great deal to the development of students and institution alike."
//							+ "",
//					font5));
//
//			table101criteria5.addCell(cell0119);
//			table101criteria5.addCell(cell01190);
//			
//			table101criteria5.addCell(cell0120);
//
//			table101criteria5.addCell(table010criteria5);
//
//			table101criteria5.setSpacingBefore(20f);
//			table101criteria5.setSpacingAfter(20f);
//	        document.add(table101criteria5);
//	        
//	        //year table 5321
////	        Table table5321 = new Table(criteria5Record.getAffiliated_YearTable5321().size(), 2);
//	//
////	        table5321.setPadding(10);
////	        table5321.setWidth(100f);
//	//
////			for (int i = 0; i < criteria5Record.getAffiliated_YearTable5321().size(); i++) {
////				table5321.addCell(criteria5Record.getAffiliated_YearTable5321().get(i).getInput5321y());
//	//
////			}
////			for (int i = 0; i < criteria5Record.getAffiliated_YearTable5321().size(); i++) {
////				table5321.addCell(criteria5Record.getAffiliated_YearTable5321().get(i).getInput5321v());
//	//
////			}
//	//
////			document.add(table5321);
//
//	        
//
//			PdfPTable table012criteria5 = new PdfPTable(2);
//			PdfPTable table121criteria5 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table012criteria5.setWidthPercentage(100);
//			table121criteria5.setWidthPercentage(100);
//
//			PdfPCell cell81criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//			PdfPCell cell82criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell83criteria5 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell84criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(26).getCriteria5FilePath() : ""));
//			PdfPCell cell85criteria5 = new PdfPCell(new Paragraph("Report of the event\r\n\r\n\r\n"));
//			PdfPCell cell86criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(27).getCriteria5FilePath() : ""));
//			PdfPCell cell87criteria5 = new PdfPCell(
//					new Paragraph("Number of sports and cultural events/competitions\r\n"
//							+ "in which students of the Institution participated\r\n"
//							+ "during last five years (organised by the\r\n"
//							+ "institution/other institutions (Data Template)\r\n\r\n\r\n"));
//			PdfPCell cell88criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(28).getCriteria5FilePath() : ""));
//
//			table012criteria5.addCell(cell81criteria5);
//			table012criteria5.addCell(cell82criteria5);
//			table012criteria5.addCell(cell83criteria5);
//			table012criteria5.addCell(cell84criteria5);
//			table012criteria5.addCell(cell85criteria5);
//			table012criteria5.addCell(cell86criteria5);
//			table012criteria5.addCell(cell87criteria5);
//			table012criteria5.addCell(cell88criteria5);
//
//			PdfPCell cell0121 = new PdfPCell(new Paragraph(
//					"5.3.3  Average number of sports and cultural events/competitions in which students of the Institution\r\n"
//					+ "participated during last five years (organised by the institution/other institutions)\r\n"
//					+ "\r\n"
//							+ "\r\n\r\n" + "Response: "
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getResponse533()
//									: ""),
//					font3));
//			PdfPCell cell0122 = new PdfPCell(new Paragraph(
//					"5.3.3.1  Number of sports and cultural events/competitions in which students of the Institution\r\n"
//					+ "participated year-wise during last five years",
//					font3));
//
//			table121criteria5.addCell(cell0121);
//			table121criteria5.addCell(cell0122);
//
//			table121criteria5.addCell(table012criteria5);
//
//			table121criteria5.setSpacingBefore(20f);
//			table121criteria5.setSpacingAfter(20f);
//	        document.add(table121criteria5);
//	        
//	        //year table 5331
//
//			Table table5331 = new Table(criteria5Record.getYearTable5331().size(), 2);
//
//			table5331.setPadding(10);
//			table5331.setWidth(100f);
//
//			for (int i = 0; i < criteria5Record.getYearTable5331().size(); i++) {
//				table5311.addCell(criteria5Record.getYearTable5331().get(i).getInput5331y());
//
//			}
//			for (int i = 0; i < criteria5Record.getYearTable5331().size(); i++) {
//				table5231.addCell(criteria5Record.getYearTable5331().get(i).getInput5331v());
//
//			}
//
//			document.add(table5331);
//
//			Paragraph paragraph05 = new Paragraph("5.4 Alumni Engagement\r\n\r\n\r\n", font3);
//			paragraph05.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph05);
//
//			PdfPTable table013 = new PdfPTable(2);
//			PdfPTable table131 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table013.setWidthPercentage(100);
//			table131.setWidthPercentage(100);
//
//			PdfPCell cell89criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//			PdfPCell cell90criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell91criteria5 = new PdfPCell(new Paragraph(" Upload Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell92criteria5 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(29).getCriteria5FilePath() : ""));
//			PdfPCell cell93criteria5 = new PdfPCell(new Paragraph("Paste Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell94criteria5 = new PdfPCell(new Paragraph(criteria5Record != null ? criterai5file.get(30).getCriteria5FilePath() : ""));
//
//			table013.addCell(cell89criteria5);
//			table013.addCell(cell90criteria5);
//			table013.addCell(cell91criteria5);
//			table013.addCell(cell92criteria5);
//			table013.addCell(cell93criteria5);
//			table013.addCell(cell94criteria5);
//
//			// PdfPCell cell023 = new PdfPCell(new Paragraph(" ",font2));
//			// cell023.setAlignment(PdfCell.ALIGN_LEFT);
//
//			PdfPCell cell0244 = new PdfPCell(new Paragraph(
//					"5.4.1 The Alumni Association / Chapters (registered and functional) contributes significantly to the development of the institution through financial and other support services.\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQl().get(0).getResponse541()
//									: ""),
//					font3));
//			
//			PdfPCell cell02440 = new PdfPCell(new Paragraph(
//					(criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQl().get(0).getInput541t1()
//									: ""),
//					font3));
//			
//			
//
//			PdfPCell cell0255 = new PdfPCell(new Paragraph(
//					"* Alumni members are made members of Boards of Studies of various departments. They contribute in the curriculum design. They examine the current curriculum and give suggestions vis-a-vis the industry-institution interface requirements.\r\n"
//							+ "* They also give advice on the establishment of laboratories, which involve experiments using modern tools for improved employability of students.\r\n"
//							+ "* Alumni members are invited to deliver technical talks and provide career guidance to the students. Alumni members help the students in establishing a network of support for their professional career progression, namely, higher education in India and abroad, internships and placements.\r\n"
//							+ "* Alumni working in various industries connect the placement cell of the college to their respective industries, thereby, facilitate the college with opportunities for internships and placements of students.\r\n"
//							+ "* In addition, they also connect the industry-institute interaction cell of the college, facilitating industrial visits, internships for students and resource persons for student development and faculty development programs.\r\n"
//							+ "* Alumni promote the college at various fora, thereby serving as brand ambassadors of the college, by making the audience aware about the salient features of the college as well as important developments that have been taking place in the college over the years.\r\n"
//							+ "* Alumni working in various R & D establishments connect the faculty of the college to their professional seniors, facilitating testing requirements of, as part of research carried out by faculty, and also in the preparation of research proposals being submitted by the college for various funding agencies.\r\n"
//							+ "* Alumni, who pursued higher education abroad, help the students in securing admissions in the universities, where they have studied, through preparation of statement of purpose, research projects and funds available with various professors in universities. This information is extremely useful for students, since, they can approach the professors by explicitly mentioning their research interests, which may perhaps improve their chances of securing scholarship with full or partial tuition fee waiver.\r\n"
//							+ "* Alumni of the college have donated certain resources/facilities to college for students use.\r\n"
//							+ "",
//					font5));
//			
//			
//
//			table131.addCell(cell0244);
//			table131.addCell(cell02440);
//			table131.addCell(cell0255);
//
//			table131.addCell(table013);
//
//			table131.setSpacingBefore(20f);
//			table131.setSpacingAfter(20f);
//
//			document.add(table131);
//
//			PdfPTable table014 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table014.setWidthPercentage(100);
//
//			PdfPCell cell0266 = new PdfPCell(new Paragraph(
//					"5.4.2 Alumni financial contribution during the last five years (in INR).\r\n" + "\r\n" + "Response:"
//							+ (criteria5Record != null
//									? criteria5Record.getCriteria5FieldInfoQn().get(0).getResponse542()
//									: ""),
//					font3));
//			table014.addCell(cell0266);
//
//			table014.setSpacingBefore(20f);
//			table014.setSpacingAfter(20f);
//
//			document.add(table014);
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
//			////////////////////////////////////////////////////////////////////////////////////
//			// criteria 5 ends here
//			/////////////////////////////////////////////////////////////////////////////
//
//		
//
//			
//			
//			
//			
//			
//			
//		}
//
//
//	
//	
//
//
