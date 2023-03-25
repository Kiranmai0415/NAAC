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
//import com.adiverse.erp.service.Criteria3Service;
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
//@Service
//public class UniversityCriteria34Report2 {
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
//   Criteria3Service service3;
//	
//	List<Criteria3_FieldInfo> criteria3FieldInfoList = null;
//	Criteria3_FieldInfo criteria3_FieldInfoQl = null;
//	List<Criteria3_FileUpload> criteria3file = null;
//	List<Criteria3_FieldInfoQn> criteria3_FieldInfoQnList=null;
//	List<Criteria3_FieldInfoQl> criteria3_FieldInfoQlList=null;
//	
//
//	public String generateReport(Criteria3_FieldInfo criteria3Fieldinfo ) throws DocumentException, IOException {
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
//			criteria3FieldInfoList = service3.getAllCriteria3Data();
//			if (CollectionUtils.isNotEmpty(criteria3FieldInfoList)) {
//				criteria3_FieldInfoQnList = criteria3FieldInfoList.get(0).getCriteria3FieldInfoQn();
//				criteria3_FieldInfoQlList = criteria3FieldInfoList.get(0).getCriteria3FieldInfoQl();
//				criteria3file = criteria3FieldInfoList.get(0).getCriteria3FileUpload();
//			} else {
//				criteria3_FieldInfoQnList = new ArrayList<>();
//				criteria3_FieldInfoQlList = new ArrayList<>();
//				criteria3file = new ArrayList<>();
//			}
//			
//			System.out.println("sfasdfdasdfasfdasdfasdfasdfasdfasdf"+criteria3_FieldInfoQnList);
//			System.out.println("999999999999999999999999999"+criteria3_FieldInfoQlList);
//			System.out.println("criteria3file==>"+criteria3file);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "UniversityCriteria3Report-" + strDate + ".pdf";
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
//			Paragraph paragraph1criteria3 = new Paragraph("Criterion 3 - Research, Innovations and Extension\r\n\r\n",
//					font1);
//			paragraph1criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph1criteria3);
//		
//			Paragraph paragraph5criteria3 = new Paragraph("3.4	Research Publications and Awards\r\n\r\n", font2);
//			paragraph5criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph5criteria3);
//			// create table 10 ///
//			PdfPTable table10criteria3 = new PdfPTable(2);
//			PdfPTable table101criteria31 = new PdfPTable(1);
//			table10criteria3.setWidthPercentage(100f);
//			table101criteria31.setWidthPercentage(100f);
//			PdfPCell cell101criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n\r\n", font3));
//			PdfPCell cell102criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell103criteria3 = new PdfPCell(new Paragraph("Code of ethics for Research document, Research\r\n"
//					+ "Advisory committee and ethics committee\r\n"
//					+ "constitution and list of members on these\r\n"
//					+ "committees, software used for Plagiarism check,\r\n"
//					+ "link to Website\r\n"
//					));
//			PdfPCell cell104criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell105criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n"));
//			PdfPCell cell106criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			table10criteria3.addCell(cell101criteria3);
//			table10criteria3.addCell(cell102criteria3);
//			table10criteria3.addCell(cell103criteria3);
//			table10criteria3.addCell(cell104criteria3);
//			table10criteria3.addCell(cell105criteria3);
//			table10criteria3.addCell(cell106criteria3);
//			PdfPCell cell341criteria3 = new PdfPCell(new Paragraph(
//					" 3.4.1 The Institution ensures implementation of its stated Code of Ethics for research through the following: 1. Inclusion of research ethics in the research methodology course work 2. Presence ofEthics committee 3. Plagiarism check through software 4. Research Advisory Committee\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse341()
//									: ""),
//					font3));
//			table101criteria31.addCell(cell341criteria3);
//			table101criteria31.addCell(table10criteria3);
//			// document.add(cell341criteria3);
//			table101criteria31.setSpacingBefore(20f);
//			table101criteria31.setSpacingAfter(20f);
//			document.add(table101criteria31);
//
//			/// create table 11 ////
//			PdfPTable table11criteria3 = new PdfPTable(2);
//			PdfPTable table111criteria31 = new PdfPTable(1);
//
//			table11criteria3.setWidthPercentage(100f);
//			table111criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell111criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell112criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell113criteria3 = new PdfPCell(new Paragraph(
//					"List of PhD scholars and their details like name of the guide , title of thesis, year of award etc\r\n\r\n\r\n"));
//			PdfPCell cell114criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(2).getCriteria3FilePath() : ""));
//			PdfPCell cell115criteria3 = new PdfPCell(new Paragraph("\r\nURL to the research page on HEI web site\r\n\r\n"));
//			PdfPCell cell116criteria3 = new PdfPCell(new Paragraph(""));
//			table11criteria3.addCell(cell111criteria3);
//			table11criteria3.addCell(cell112criteria3);
//			table11criteria3.addCell(cell113criteria3);
//			table11criteria3.addCell(cell114criteria3);
//			table11criteria3.addCell(cell115criteria3);
//			table11criteria3.addCell(cell116criteria3);
//			PdfPCell cell342criteria3 = new PdfPCell(new Paragraph(
//					"3.4.2 The institution provides incentives to teachers who receive state, national and international\r\n"
//					+ "recognitions/awards 1.Commendation and monetary incentive at a University function\r\n"
//					+ "2.Commendation and medal at a University function 3. Certificate of honor 4.Announcement in the\r\n"
//					+ "Newsletter / website\r\n"
//					+ "Response:"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse342()
//									: ""),
//					font3));
//
//			table111criteria31.addCell(cell342criteria3);
////			// document.add(cell342criteria3);
////			PdfPCell cell3421criteria3 = new PdfPCell(
////					new Paragraph("3.4.2.1 How many Ph.Ds are registered within last 5 years" + "\r\n\r\n\r\n", font2));
////			PdfPCell cell3422criteria3 = new PdfPCell(new Paragraph(
////					"3.4.2.2 Number of teachers recognized as guides during the last five years\r\n" + "\r\n\r\n\r\n" + "Response:"
////							+ (criteria3_FieldInfoQnList != null
////									? criteria3_FieldInfoQnList.get(0).getInput3422t1()
////									: ""),
////					font2));
////			table111criteria31.addCell(cell3421criteria3);
////			table111criteria31.addCell(cell3422criteria3);
//			table111criteria31.addCell(table11criteria3);
//
//			// document.add(cell3421criteria3);
//			// document.add(cell3422criteria3);
//			table111criteria31.setSpacingAfter(20f);
//			table111criteria31.setSpacingAfter(20f);
//
//			document.add(table111criteria31);
//			/// create table 12 /////
//			PdfPTable table12criteria3 = new PdfPTable(2);
//			PdfPTable table123criteria31 = new PdfPTable(1);
//
//			table12criteria3.setWidthPercentage(100f);
//			table123criteria31.setWidthPercentage(100f);
//			
//			PdfPCell cell121criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell122criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n\r\n", font3));
//			PdfPCell cell123criteria3 = new PdfPCell(new Paragraph(
//					"\r\nInstitutional data in prescribed format\r\n\r\n",
//					font2));
//			PdfPCell cell124criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(3).getCriteria3FilePath() : ""));
//			PdfPCell cell125criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n", font3));
//			PdfPCell cell126criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(4).getCriteria3FilePath() : ""));
//			table12criteria3.addCell(cell121criteria3);
//			table12criteria3.addCell(cell122criteria3);
//			table12criteria3.addCell(cell123criteria3);
//			table12criteria3.addCell(cell124criteria3);
//			table12criteria3.addCell(cell125criteria3);
//			table12criteria3.addCell(cell126criteria3);
//			PdfPCell cell343criteria3 = new PdfPCell(new Paragraph(
//					" 3.4.3 Number of Patents published / awarded during the last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse343()
//									: ""),
//					font2));
//			PdfPCell cell3431criteria3 = new PdfPCell(new Paragraph(
//					"3.4.3.1 Total number of Patents published / awarded year-wise during the last five years.\r\n\r\n"
//							+ "",
//					font2));
//			table123criteria31.addCell(cell343criteria3);
//			table123criteria31.addCell(cell3431criteria3);
//			table123criteria31.addCell(table12criteria3);
//
//			// document.add(cell343criteria3);
//			// document.add(cell3431criteria3);
//			table123criteria31.setSpacingBefore(20f);
//			table123criteria31.setSpacingAfter(20f);
//
//			document.add(table123criteria31);
//			/// create table 3431 ////
//
//			if (criteria3Fieldinfo.getUniversityYearTable3431() !=null) {
//				Table table3431criteria3 = new Table(criteria3Fieldinfo.getUniversityYearTable3431().size(), 2);
//
//				table3431criteria3.setPadding(10);
//				table3431criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3431().size(); i++) {
//					table3431criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3431().get(i).getInput3431y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3431().size(); i++) {
//					table3431criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3431().get(i).getInput3431v());
//
//				}
//
//				document.add(table3431criteria3);
//			}
//			/// create table 13 //
//			PdfPTable table13criteria3 = new PdfPTable(2);
//			PdfPTable table131criteria31 = new PdfPTable(1);
//
//			table13criteria3.setWidthPercentage(100f);
//			table131criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell131criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell132criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell133criteria3 = new PdfPCell(
//					new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell134criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(5).getCriteria3FilePath() : ""));
//			PdfPCell cell135criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n\r\n"));
//			PdfPCell cell136criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(6).getCriteria3FilePath() : ""));
//			
//			PdfPCell cell1351criteria3 = new PdfPCell(new Paragraph("\r\nURL to the research page on HEI web site\r\n\r\n"));
//			PdfPCell cell1361criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(7).getCriteria3FilePath() : ""));
//			
//			table13criteria3.addCell(cell131criteria3);
//			table13criteria3.addCell(cell132criteria3);
//			table13criteria3.addCell(cell133criteria3);
//			table13criteria3.addCell(cell134criteria3);
//			table13criteria3.addCell(cell135criteria3);
//			table13criteria3.addCell(cell136criteria3);
//			table13criteria3.addCell(cell1351criteria3);
//			table13criteria3.addCell(cell1361criteria3);
//			
//			PdfPCell cell3444criteria3 = new PdfPCell(new Paragraph(
//					"3.4.4 Number of Ph.D’s awarded per teacher during the last five years."
//							+ " \r\n" + "\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse344()
//									: ""),
//					font3));
//			PdfPCell cell3441criteria3 = new PdfPCell(new Paragraph(
//					"3.4.4.1 How many Ph.D’s are awarded within last five years.\r\n"
//					+ "Response:"
//							+ (criteria3Fieldinfo != null
//							? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3441t1()
//							: ""),
//					font3));
//			PdfPCell cell3442criteria3 = new PdfPCell(new Paragraph(
//					"3.4.4.2 Number of teachers recognized as guides during the last five years\r\n"
//				+ "Response:"
//					+ (criteria3Fieldinfo != null
//					? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3422t1()
//					: ""),
//					font3));
//			table131criteria31.addCell(cell3444criteria3);
//			table131criteria31.addCell(cell3441criteria3);
//			table131criteria31.addCell(cell3442criteria3);
//
//			// document.add(cell344criteria3);
//			// document.add(cell3441criteria3);
//			table131criteria31.setSpacingBefore(20f);
//			table131criteria31.setSpacingAfter(20f);
//
//			document.add(table131criteria31);
//			// create table 3441 //
//
//			if (criteria3Fieldinfo.getYearTable3441() !=null) {
//				Table table3441criteria3 = new Table(criteria3Fieldinfo.getYearTable3441().size(), 2);
//
//				table3441criteria3.setPadding(10);
//				table3441criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3441().size(); i++) {
//					table3441criteria3.addCell(criteria3Fieldinfo.getYearTable3441().get(i).getInput3441y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3441().size(); i++) {
//					table3441criteria3.addCell(criteria3Fieldinfo.getYearTable3441().get(i).getInput3441v());
//
//				}
//
//				document.add(table3441criteria3);
//			}
//			
//			if (criteria3Fieldinfo.getUniversityYearTable3442() != null) {
//				Table table3442criteria3 = new Table(criteria3Fieldinfo .getUniversityYearTable3442().size(), 2);
//	
//				table3442criteria3.setPadding(10);
//				table3442criteria3.setWidth(100f);
//	
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3442().size(); i++) {
//					table3442criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3442().get(i).getInput3442y());
//	
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3442().size(); i++) {
//					table3442criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3442().get(i).getInput3442v());
//	
//				}
//	
//				document.add(table3442criteria3);
//			}
//
//			// create table 14 //
//			PdfPTable table14criteria3 = new PdfPTable(2);
//			PdfPTable table141criteria31 = new PdfPTable(1);
//
//			table14criteria3.setWidthPercentage(100f);
//			table141criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell141criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell142criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell143criteria3 = new PdfPCell(
//					new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell144criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(7).getCriteria3FilePath() : ""));
//			PdfPCell cell145criteria3 = new PdfPCell(
//					new Paragraph("\r\nAny additional information\r\n\r\n"));
//			PdfPCell cell146criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(8).getCriteria3FilePath() : ""));
//			
//			table14criteria3.addCell(cell141criteria3);
//			table14criteria3.addCell(cell142criteria3);
//			table14criteria3.addCell(cell143criteria3);
//			table14criteria3.addCell(cell144criteria3);
//			table14criteria3.addCell(cell145criteria3);
//			table14criteria3.addCell(cell146criteria3);
//
//			PdfPCell cell3451criteria3 = new PdfPCell(new Paragraph(
//					"3.4.5 Number of research papers per teachers in the Journals notified on UGC website during the\r\n"
//					+ "last five years\r\n"
//					+ "Response: "
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse345()
//									: ""),
//					font3));
//			PdfPCell cell34512criteria3 = new PdfPCell(new Paragraph("3.4.5.1 Number of research papers per teachers in the Journals notified on UGC website during the last five years",font3));
//							
//			
//			table141criteria31.addCell(cell3451criteria3);
//			table141criteria31.addCell(cell34512criteria3);
//			
//			table141criteria31.addCell(table14criteria3);
//			table141criteria31.setSpacingBefore(20f);
//			table141criteria31.setSpacingAfter(20f);
//			document.add(table141criteria31);
//			
//			if (criteria3Fieldinfo.getUniversityYearTable3451()!=null) {
//				Table table3451criteria3 = new Table(criteria3Fieldinfo.getUniversityYearTable3451().size(), 2);
//
//				table3451criteria3.setPadding(10);
//				table3451criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3451().size(); i++) {
//					table3451criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3451().get(i).getInput3451y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3451().size(); i++) {
//					table3451criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3451().get(i).getInput3451v());
//
//				}
//
//				document.add(table3451criteria3);
//			}
//			
//			
//			
//			
//			// create table 15 //
//			
//			PdfPCell cell346criteria3 = new PdfPCell(new Paragraph(
//					"3.4.6 Number of books and chapters in edited volumes/books published and papers published in\r\n"
//					+ "national/ international conference proceedings per teacher during last five years\r\n"
//					+ "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse346()
//									: ""),
//					font2));
//			document.add(cell346criteria3);
//			PdfPCell cell3461criteria3 = new PdfPCell(new Paragraph(
//					"3.4.6.1 Total number of books and chapters in edited volumes/books published and papers in\r\n"
//					+ "national/ international conference proceedings year-wise during last five years"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3461t1()
//									: ""),
//					font2));
//			document.add(cell3461criteria3);
//			
//			PdfPTable table15criteria3 = new PdfPTable(2);
//			PdfPTable table153criteria31 = new PdfPTable(1);
//
//			table15criteria3.setWidthPercentage(100f);
//			table153criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell151criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell152criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell153criteria3 = new PdfPCell(new Paragraph(
//					"\r\nInstitutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell154criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(9).getCriteria3FilePath() : ""));
//			PdfPCell cell1531criteria3 = new PdfPCell(new Paragraph(
//					"\r\nAny additional information\r\n\r\n"));
//			PdfPCell cell1542criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(10).getCriteria3FilePath() : ""));
//			
//			table15criteria3.addCell(cell151criteria3);
//			table15criteria3.addCell(cell152criteria3);
//			table15criteria3.addCell(cell153criteria3);
//			table15criteria3.addCell(cell154criteria3);
//			table15criteria3.addCell(cell1531criteria3);
//			table15criteria3.addCell(cell1542criteria3);
//			
//			table153criteria31.addCell(table15criteria3);
//
//			// document.add(cell346criteria3);
//			table153criteria31.setSpacingBefore(20f);
//			table153criteria31.setSpacingAfter(20f);
//			document.add(table153criteria31);
//			
//			
//			if (criteria3Fieldinfo.getUniversityYearTable3461() !=null) {
//				Table table3461criteria3 = new Table(criteria3Fieldinfo.getUniversityYearTable3461().size(), 2);
//
//				table3461criteria3.setPadding(10);
//				table3461criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3461().size(); i++) {
//					table3461criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3461().get(i).getInput3461y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3461().size(); i++) {
//					table3461criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3461().get(i).getInput3461v());
//
//				}
//
//				document.add(table3461criteria3);
//			}
//			
//			
//			
//			
//			Paragraph paragraph1criteria311 = new Paragraph("3.4.6.1: Average number of full time teachers during the last five years");
//			document.add(paragraph1criteria311);
//				
//				if (criteria3Fieldinfo.getUniversityYearTable34612()!= null) {
//					Table table34612criteria3 = new Table(criteria3Fieldinfo.getUniversityYearTable34612().size(), 2);
//	
//					table34612criteria3.setPadding(10);
//					table34612criteria3.setWidth(100f);
//	
//					for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable34612().size(); i++) {
//						table34612criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable34612().get(i).getInput34612y());
//	
//					}
//					for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable34612().size(); i++) {
//						table34612criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable34612().get(i).getInput34612v());
//	
//					}
//	
//					document.add(table34612criteria3);
//				}
//			
//			
//			PdfPTable table347criteria3 = new PdfPTable(2);
//			PdfPTable table3471criteria31 = new PdfPTable(1);
//
//			table347criteria3.setWidthPercentage(100f);
//			table3471criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell1517criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell1527criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell1537criteria3 = new PdfPCell(new Paragraph(
//					"\r\nInstitutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell1547criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(11).getCriteria3FilePath() : ""));
//			PdfPCell cell15317criteria3 = new PdfPCell(new Paragraph(
//					"\r\nGive links or upload document of e-content\r\n"
//					+ "developed\r\n\r\n"));
//			PdfPCell cell15427criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(12).getCriteria3FilePath() : ""));
//			
//			table347criteria3.addCell(cell1517criteria3);
//			table347criteria3.addCell(cell1527criteria3);
//			table347criteria3.addCell(cell1537criteria3);
//			table347criteria3.addCell(cell1547criteria3);
//			table347criteria3.addCell(cell15317criteria3);
//			table347criteria3.addCell(cell15427criteria3);
//			PdfPCell cell3467criteria3 = new PdfPCell(new Paragraph(
//					"3.4.7 E-content is developed by teachers :\r\n"
//					+ "1.For e-PG-Pathshala\r\n"
//					+ "2.For CEC (Under Graduate) \r\n"
//					+ "3.For SWAYAM\r\n"
//					+ "4.For other MOOCs platform\r\n"
//					+ "5.Any other Government Initiatives\r\n"
//					+ "6.For Institutional LMS\r\n"
//					+ "Response: "
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse347()
//									: ""),
//					font3));
//		
//			table3471criteria31.addCell(cell3467criteria3);
//		
//			
//			table3471criteria31.addCell(table347criteria3);
//
//			// document.add(cell346criteria3);
//			table3471criteria31.setSpacingBefore(20f);
//			table3471criteria31.setSpacingAfter(20f);
//			document.add(table3471criteria31);
//			
//			PdfPTable table348criteria3 = new PdfPTable(1);
//			
//
//			table348criteria3.setWidthPercentage(100f);
//		
//			
//			PdfPCell cell348criteria3 = new PdfPCell(new Paragraph(
//					"3.4.8 Bibliometrics of the publications during the last five years based on average citation index in\r\n"
//					+ "Scopus/ Web of Science or PubMed\r\n"
//					+ "Response:  "
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse348()
//									: ""),
//					font3));
//		
//			table348criteria3.addCell(cell348criteria3);
//		
//			
//		
//			// document.add(cell346criteria3);
//			table348criteria3.setSpacingBefore(20f);
//			table348criteria3.setSpacingAfter(20f);
//			document.add(table348criteria3);
//			Paragraph paragraph1criteria322= new Paragraph("3.4.8.1: Total Number of Citations in Scopus in 5 years\r\n");
//			document.add(paragraph1criteria322);
//			Paragraph paragraph1criteria323= new Paragraph((criteria3Fieldinfo != null
//					? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3481t1()
//					: ""));
//				document.add(paragraph1criteria323);
//				Paragraph paragraph1criteria3223= new Paragraph("Total Number of Citations in Web of Science in 5 years\r\n");
//				document.add(paragraph1criteria3223);
//				Paragraph paragraph1criteria3224= new Paragraph((criteria3Fieldinfo != null
//						? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3481t2()
//						: ""));
//					document.add(paragraph1criteria3224);
//					
//					
//					Paragraph paragraph1criteria32211= new Paragraph("3.4.8.2: Total number of Publications in Scopus in 5 years\r\n");
//					document.add(paragraph1criteria32211);
//					Paragraph paragraph1criteria32311= new Paragraph((criteria3Fieldinfo != null
//							? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3482t1()
//							: ""));
//						document.add(paragraph1criteria32311);
//						Paragraph paragraph1criteria322311= new Paragraph("Total number of Publications in Web of Science in 5 years\r\n");
//						document.add(paragraph1criteria322311);
//						Paragraph paragraph1criteria322411= new Paragraph((criteria3Fieldinfo != null
//								? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3482t2()
//								: ""));
//							document.add(paragraph1criteria322411);
//							
//							PdfPTable table3407criteria311 = new PdfPTable(2);
//
//
//							table3407criteria311.setWidthPercentage(100f);
//
//
//							PdfPCell cell1518criteria31 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//							PdfPCell cell1528criteria31 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//							PdfPCell cell1538criteria31 = new PdfPCell(new Paragraph(
//									"\r\nBibiliometrics of publications based on Scopus/ Web of Science - h-index of the Institution\r\n\r\n"));
//							PdfPCell cell1548criteria31 = new PdfPCell(
//									new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(13).getCriteria3FilePath() : ""));
//							PdfPCell cell15318criteria31 = new PdfPCell(new Paragraph(
//									"\r\nAny additional information\r\n"
//									+ "developed\r\n\r\n"));
//							PdfPCell cell15428criteria31 = new PdfPCell(
//									new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(14).getCriteria3FilePath() : ""));
//							
//							table3407criteria311.addCell(cell1518criteria31);
//							table3407criteria311.addCell(cell1528criteria31);
//							
//							table3407criteria311.addCell(cell15318criteria31);
//							table3407criteria311.addCell(cell15428criteria31);
//							table3407criteria311.addCell(cell1538criteria31);
//							table3407criteria311.addCell(cell1548criteria31);
//							document.add(table3407criteria311);
//						
//							
//							
//							
//							
//							
//					
//					
//					
//		PdfPTable table349criteria3 = new PdfPTable(1);
//			
//
//		table349criteria3.setWidthPercentage(100f);
//		
//			
//			PdfPCell cell349criteria3 = new PdfPCell(new Paragraph(
//					"3.4.9 Bibliometrics of the publications during the last five years based on Scopus/ Web of Science - hindex of the Institution\r\n"
//					+ "Response: "
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse349(): ""),font3));
//		
//			table349criteria3.addCell(cell349criteria3);
//			document.add(table349criteria3);
//			PdfPCell cell349criteria321 = new PdfPCell(new Paragraph(
//					"3.4.9.1: h-index of Scopus during the last five years\r\n"
//					+ "Response: "
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3491t1()
//									: "")));
//		
//			table349criteria3.addCell(cell349criteria321);
//			document.add(table349criteria3);
//			PdfPCell cell349criteria323 = new PdfPCell(new Paragraph(
//					"h-index of Web of Science during the last five years\r\n"
//					+ "Response: "
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3491t2()
//									: ""),
//					font3));
//			document.add(cell349criteria323);
////		do
////			table349criteria3.addCell(cell349criteria323);
////			document.add(table349criteria3);
////		
//			PdfPTable table3407criteria3 = new PdfPTable(2);
//
//
//			table3407criteria3.setWidthPercentage(100f);
//
//
//			PdfPCell cell1518criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell1528criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell1538criteria3 = new PdfPCell(new Paragraph(
//					"\r\nBibiliometrics of publications based on Scopus/ Web of Science - h-index of the Institution\r\n\r\n"));
//			PdfPCell cell1548criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(13).getCriteria3FilePath() : ""));
//			PdfPCell cell15318criteria3 = new PdfPCell(new Paragraph(
//					"\r\nAny additional information\r\n"
//					+ "developed\r\n\r\n"));
//			PdfPCell cell15428criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(14).getCriteria3FilePath() : ""));
//			
//			table3407criteria3.addCell(cell1518criteria3);
//			table3407criteria3.addCell(cell1528criteria3);
//			table3407criteria3.addCell(cell1538criteria3);
//			table3407criteria3.addCell(cell1548criteria3);
//			table3407criteria3.addCell(cell15318criteria3);
//			table3407criteria3.addCell(cell15428criteria3);
//		
//			
//			document.add(table3407criteria3);
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