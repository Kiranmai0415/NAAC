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
//public class AutonomousCriteria51Report 
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
//		Paragraph paragraph02 = new Paragraph("5.1 Student Support\r\n\r\n", font1);
//		paragraph02.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		document.add(paragraph0);
//		document.add(paragraph02);
//
//		
//		Paragraph paragraph021 = new Paragraph(
//				"5.1.1 Average percentage of students benefited by scholarships and freeships provided by the Government during last five years\r\n"
//						+ "\r\n\r\n" + "Response: "
//						+ (criteria5Fieldinfo != null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse511()
//								: ""));
//		document.add(paragraph021);
//		Paragraph paragraph022 = new Paragraph(
//				"5.1.1.1 Number of students benefited by scholarships and free ships provided by the institution, Government and non-government bodies, industries, individuals, philanthropists during the last five years (other than students receiving scholarships under the government schemes for reserved categories)\r\n\r\n");
//		document.add(paragraph022);
//		
//		
//		if(criteria5Fieldinfo.getYearTable5111() !=null) {
//			Table table5111 = new Table(criteria5Fieldinfo.getYearTable5111().size(), 2);
//
//			table5111.setPadding(10);
//			table5111.setWidth(100f);
//
//			for (int i = 0; i < criteria5Fieldinfo.getYearTable5111().size(); i++) {
//				table5111.addCell(criteria5Fieldinfo.getYearTable5111().get(i).getInput5111y());
//
//			}
//			for (int i = 0; i < criteria5Fieldinfo.getYearTable5111().size(); i++) {
//				table5111.addCell(criteria5Fieldinfo.getYearTable5111().get(i).getInput5111v());
//
//			}
//
//			document.add(table5111);
//			}
//
//		PdfPTable table01criteria5 = new PdfPTable(2);
//		PdfPTable table011 = new PdfPTable(1);
//
//		// Setting width of table, its columns and spacing
//		table01criteria5.setWidthPercentage(100);
//		table011.setWidthPercentage(100);
//
//		PdfPCell cell1001 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell1002 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell1003 = new PdfPCell(
//				new Paragraph("upload self attested letter with the list of students sanctioned scholarships\r\n\r\n\r\n"));
//		PdfPCell cell1004 = new PdfPCell(
//				new Paragraph(criterai5file.size()>0 ? criterai5file.get(0).getCriteria5FilePath() : ""));
//		PdfPCell cell1005 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//		PdfPCell cell1006 = new PdfPCell(
//				new Paragraph(criterai5file.size()>0 ? criterai5file.get(1).getCriteria5FilePath() : ""));
//		PdfPCell cell1007 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		PdfPCell cell1008 = new PdfPCell(
//				new Paragraph(criterai5file.size()>0? criterai5file.get(2).getCriteria5FilePath() : ""));
//		PdfPCell cell1009 = new PdfPCell(new Paragraph(
//				"Average percentage of students benefited by scholarships and freeships provided by the Government during the last five years\r\n\r\n\r\n"));
//		PdfPCell cell10010 = new PdfPCell(
//				new Paragraph(criterai5file.size()>0? criterai5file.get(3).getCriteria5FilePath() : ""));
//
//		table01criteria5.addCell(cell1001);
//		table01criteria5.addCell(cell1002);
//		table01criteria5.addCell(cell1003);
//		table01criteria5.addCell(cell1004);
//		table01criteria5.addCell(cell1005);
//		table01criteria5.addCell(cell1006);
//		table01criteria5.addCell(cell1007);
//		table01criteria5.addCell(cell1008);
//		table01criteria5.addCell(cell1009);
//		table01criteria5.addCell(cell10010);
//		table011.addCell(table01criteria5);
//
//		table011.setSpacingBefore(20f);
//		table011.setSpacingAfter(20f);
//
//		document.add(table011);
//
//		
//
//		
//
//		Paragraph paragraph023 = new Paragraph(
//				"5.1.2 Average percentage of students benefited by scholarships, freeships, etc. provided by the institution and non-government agencies during the last five years\r\n"
//						+ "\r\n\r\n" + "Response:"
//						+ (criteria5Fieldinfo != null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse512()
//								: ""));
//		document.add(paragraph023);
//
//		Paragraph paragraph024 = new Paragraph(
//				"5.1.2.1 Number of students benefited by scholarships and free ships provided by the institution, Government and non-government bodies, industries, individuals, philanthropists during the last five years (other than students receiving scholarships under the government schemes for reserved categories)");
//		document.add(paragraph024);
//		
//
//		
//		if(criteria5Fieldinfo.getYearTable5121() !=null)
//		{
//				Table table5121 = new Table(criteria5Fieldinfo.getYearTable5121().size(), 2);
//
//				table5121.setPadding(10);
//				table5121.setWidth(100f);
//
//				for (int i = 0; i < criteria5Fieldinfo.getYearTable5121().size(); i++) {
//					table5121.addCell(criteria5Fieldinfo.getYearTable5121().get(i).getInput5121y());
//
//				}
//				for (int i = 0; i < criteria5Fieldinfo.getYearTable5121().size(); i++) {
//					table5121.addCell(criteria5Fieldinfo.getYearTable5121().get(i).getInput5121v());
//
//				}
//
//				document.add(table5121);
//		}
//		
//		PdfPCell cell00044= new PdfPCell(new Paragraph("B. Number of Sanctioned Posts"));
//		document.add(cell00044);
//		
//		
//		
//		if(criteria5Fieldinfo.getYearTable5121() !=null)
//		{
//				Table table5121 = new Table(criteria5Fieldinfo.getYearTable5121().size(), 2);
//
//				table5121.setPadding(10);
//				table5121.setWidth(100f);
//
//				for (int i = 0; i < criteria5Fieldinfo.getYearTable5121().size(); i++) {
//					table5121.addCell(criteria5Fieldinfo.getYearTable5121().get(i).getInput5121y());
//
//				}
//				for (int i = 0; i < criteria5Fieldinfo.getYearTable5121().size(); i++) {
//					table5121.addCell(criteria5Fieldinfo.getYearTable5121().get(i).getInput5121v());
//
//				}
//
//				document.add(table5121);
//		}
//		
//		
//		// Creating table
//				PdfPTable table02criteria5 = new PdfPTable(2);
//				PdfPTable table021 = new PdfPTable(1);
//
//				// Setting width of table, its columns and spacing
//				table02criteria5.setWidthPercentage(100);
//				table021.setWidthPercentage(100);
//
//				PdfPCell cell00001 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//				PdfPCell cell00002 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//				PdfPCell cell00003 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//				PdfPCell cell00004 = new PdfPCell(
//						new Paragraph(criterai5file.size()>0? criterai5file.get(4).getCriteria5FilePath() : ""));
//				PdfPCell cell00005 = new PdfPCell(new Paragraph(
//						"Number of students benefited by scholarships and freeships besides government schemes in last 5 years\r\n\r\n\r\n"));
//				PdfPCell cell00006 = new PdfPCell(
//						new Paragraph(criterai5file.size()>0? criterai5file.get(5).getCriteria5FilePath() : ""));
//				PdfPCell cell00007 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//				PdfPCell cell00008 = new PdfPCell(
//						new Paragraph(criterai5file.size()>0 ? criterai5file.get(6).getCriteria5FilePath() : ""));
//
//				table02criteria5.addCell(cell00001);
//				table02criteria5.addCell(cell00002);
//				table02criteria5.addCell(cell00003);
//				table02criteria5.addCell(cell00004);
//				table02criteria5.addCell(cell00005);
//				table02criteria5.addCell(cell00006);
//				table02criteria5.addCell(cell00007);
//				table02criteria5.addCell(cell00008);
//
//		table021.addCell(table02criteria5);
//
//		table021.setSpacingBefore(20f);
//		table021.setSpacingAfter(20f);
//
//		document.add(table021);
//
//
//		PdfPTable table03criteria5 = new PdfPTable(2);
//		PdfPTable table31criteria5 = new PdfPTable(1);
//
//		// Setting width of table, its columns and spacing
//		table03criteria5.setWidthPercentage(100);
//		table31criteria5.setWidthPercentage(100);
//
//		PdfPCell cell00019 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell00020 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell00021 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//		PdfPCell cell00022 = new PdfPCell(
//				new Paragraph(criterai5file.size()>0? criterai5file.get(7).getCriteria5FilePath() : ""));
//		PdfPCell cell00023 = new PdfPCell(new Paragraph(
//				"Number of students benefited by scholarships and freeships besides government schemes in last 5 years\r\n\r\n\r\n"));
//		PdfPCell cell00024 = new PdfPCell(
//				new Paragraph(criterai5file.size()>0? criterai5file.get(8).getCriteria5FilePath() : ""));
//		PdfPCell cell00025 = new PdfPCell(new Paragraph("Institutional data in prescribed format"));
//		PdfPCell cell00026 = new PdfPCell(
//				new Paragraph(criterai5file.size()>0? criterai5file.get(9).getCriteria5FilePath() : ""));
//
//		table03criteria5.addCell(cell00019);
//		table03criteria5.addCell(cell00020);
//		table03criteria5.addCell(cell00021);
//		table03criteria5.addCell(cell00022);
//		table03criteria5.addCell(cell00023);
//		table03criteria5.addCell(cell00024);
//		table03criteria5.addCell(cell00025);
//		table03criteria5.addCell(cell00026);
//
//		PdfPCell cell0005 = new PdfPCell(new Paragraph(
//				"5.1.3 Following Capacity development and skills enhancement activities are organised for improving students capability 1. Soft skills 2. Language and communication skills 3. Life skills (Yoga, physical fitness, health and hygiene) 4. Awareness of trends in technology\r\n"
//						+ "\r\n\r\n" + "Response: "
//						+ (criteria5Fieldinfo != null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse513()
//								: ""),
//				font3));
//		table31criteria5.addCell(cell0005);
//
//		table31criteria5.addCell(table03criteria5);
//
//		table31criteria5.setSpacingBefore(20f);
//		table31criteria5.setSpacingAfter(20f);
//
//		document.add(table31criteria5);
//
//		
//
//		PdfPCell cell0006 = new PdfPCell(new Paragraph(
//				"5.1.4 Average percentage of students benefited by career counseling and guidance for competitive examinations as offered by the Institution during the last five years.\r\n"
//						+ "\r\n\r\n" + "Response: "
//						+ (criteria5Fieldinfo != null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse514()
//								: ""),
//				font3));
//		document.add(cell0006);
//
//		PdfPCell cell0007 = new PdfPCell(new Paragraph(
//				"5.1.4.1 Number of students benefitted by guidance for competitive examinations and career counselling offered by the institution year wise during last five years",
//				font3));
//document.add(cell0007);
//
//		
//		if(criteria5Fieldinfo.getYearTable5141() !=null)
//		{
//				Table table5141 = new Table(criteria5Fieldinfo.getYearTable5141().size(), 2);
//
//				table5141.setPadding(10);
//				table5141.setWidth(100f);
//
//				for (int i = 0; i < criteria5Fieldinfo.getYearTable5141().size(); i++) {
//					table5141.addCell(criteria5Fieldinfo.getYearTable5141().get(i).getInput5141y());
//
//				}
//				for (int i = 0; i < criteria5Fieldinfo.getYearTable5141().size(); i++) {
//					table5141.addCell(criteria5Fieldinfo.getYearTable5141().get(i).getInput5141v());
//
//				}
//
//				document.add(table5141);
//		}
//		if(criteria5Fieldinfo.getYearTable5141() !=null)
//		{
//				Table table5141 = new Table(criteria5Fieldinfo.getYearTable5141().size(), 2);
//
//				table5141.setPadding(10);
//				table5141.setWidth(100f);
//
//				for (int i = 0; i < criteria5Fieldinfo.getYearTable5141().size(); i++) {
//					table5141.addCell(criteria5Fieldinfo.getYearTable5141().get(i).getInput5141y());
//
//				}
//				for (int i = 0; i < criteria5Fieldinfo.getYearTable5141().size(); i++) {
//					table5141.addCell(criteria5Fieldinfo.getYearTable5141().get(i).getInput5141v());
//
//				}
//
//				document.add(table5141);
//		}
//		
//		
//		PdfPTable table04criteria5 = new PdfPTable(2);
//		PdfPTable table41criteria5 = new PdfPTable(1);
//
//		// Setting width of table, its columns and spacing
//		table04criteria5.setWidthPercentage(100);
//		table41criteria5.setWidthPercentage(100);
//
//		PdfPCell cell00027 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell00028 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell00029 = new PdfPCell(new Paragraph(
//				"Number of students benefited by guidance for competitive examinations and career counselling during the last five years\r\n\r\n\r\n"));
//		PdfPCell cell00030 = new PdfPCell(
//				new Paragraph(criterai5file.size()>0? criterai5file.get(10).getCriteria5FilePath() : ""));
//		PdfPCell cell00031 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//		PdfPCell cell00032 = new PdfPCell(
//				new Paragraph(criterai5file.size()>0? criterai5file.get(11).getCriteria5FilePath() : ""));
//
//		table04criteria5.addCell(cell00027);
//		table04criteria5.addCell(cell00028);
//		table04criteria5.addCell(cell00029);
//		table04criteria5.addCell(cell00030);
//		table04criteria5.addCell(cell00031);
//		table04criteria5.addCell(cell00032);
//
//		table41criteria5.addCell(table04criteria5);
//
//		table41criteria5.setSpacingBefore(20f);
//		table41criteria5.setSpacingAfter(20f);
//
//		document.add(table41criteria5);
//
//
//		PdfPTable table05criteria5 = new PdfPTable(2);
//		PdfPTable table051criteria5 = new PdfPTable(1);
//
//		// Setting width of table, its columns and spacing
//		table05criteria5.setWidthPercentage(100);
//		table051criteria5.setWidthPercentage(100);
//
//		PdfPCell cell00035 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell00036 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell00037 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//		PdfPCell cell00038 = new PdfPCell(
//				new Paragraph(criterai5file.size()>0? criterai5file.get(12).getCriteria5FilePath() : ""));
//		PdfPCell cell00039 = new PdfPCell(new Paragraph(
//				"Minutes of the meetings of student redressal committee, prevention of sexual harassment committee and Anti Ragging committee\r\n\r\n\r\n"));
//		PdfPCell cell00040 = new PdfPCell(
//				new Paragraph(criterai5file.size()>0? criterai5file.get(1).getCriteria5FilePath() : ""));
//		PdfPCell cell00041 = new PdfPCell(
//				new Paragraph("Details of student grievances including sexual harassment and ragging cases"));
//		PdfPCell cell00042 = new PdfPCell(
//				new Paragraph(criterai5file.size()>0? criterai5file.get(1).getCriteria5FilePath() : ""));
//
//		table05criteria5.addCell(cell00035);
//		table05criteria5.addCell(cell00036);
//		table05criteria5.addCell(cell00037);
//		table05criteria5.addCell(cell00038);
//		table05criteria5.addCell(cell00039);
//		table05criteria5.addCell(cell00040);
//		table05criteria5.addCell(cell00041);
//		table05criteria5.addCell(cell00042);
//
//		PdfPCell cell0008 = new PdfPCell(new Paragraph(
//				"5.1.5 The institution adopts the following for redressal of student grievances including sexual harassment and ragging cases 1. Implementation of guidelines of statutory/regulatory bodies 2.	Organisation wide awareness and undertakings on policies with zero tolerance\r\n"
//						+ "3.	Mechanisms for submission of online/offline students� grievances\r\n"
//						+ "4.	Timely redressal of the grievances through appropriate committees\r\n" + "\r\n"
//						+ "Response: "
//						+ (criteria5Fieldinfo != null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse515()
//								: ""),
//				font3));
//
//		table051criteria5.addCell(cell0008);
//
//		table051criteria5.addCell(table05criteria5);
//
//		table051criteria5.setSpacingBefore(20f);
//		table051criteria5.setSpacingAfter(20f);
//
//		document.add(table051criteria5);
//
//	
//		document.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return file.toAbsolutePath().toString();
//		}
//
//}
