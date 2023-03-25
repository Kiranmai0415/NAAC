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
//import com.adiverse.erp.model.Criteria2_FieldInfo;
//import com.adiverse.erp.model.Criteria2_FileUpload;
//import com.adiverse.erp.model.Criteria3_FieldInfo;
//import com.adiverse.erp.model.Criteria3_FieldInfoQl;
//import com.adiverse.erp.model.Criteria3_FieldInfoQn;
//import com.adiverse.erp.model.Criteria3_FileUpload;
//
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
//@Service
//public class AutonomousCriteria34Report2 {
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//	@Autowired
//	Criteria3Service service3;
//	
//
//	List<Criteria2_FieldInfo> criteria2List = null;
//	Criteria2_FieldInfo criteria2Record = null;
//	List<Criteria2_FileUpload> criteria2file = null;
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//	
//	
//	List<Criteria3_FieldInfo> criteria3FieldInfoList = null;
//
//	Criteria3_FieldInfo criteria3_FieldInfoQl = null;
//	List<Criteria3_FileUpload> criteria3file = null;
//	List<Criteria3_FieldInfoQn> criteria3_FieldInfoQnList=null;
//	List<Criteria3_FieldInfoQl> criteria3_FieldInfoQlList=null;
//
//public String generateReport(Criteria3_FieldInfo criteria3Fieldinfo) throws DocumentException, IOException {
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
//			System.out.println("sfasdfdasdfasfdasdfasdfasdfasdfasdf"+criteria3_FieldInfoQnList);
//			System.out.println("999999999999999999999999999"+criteria3_FieldInfoQlList);
//			System.out.println("criteria3file==>"+criteria3file);
//
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AuthonomousCriteria3Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//				
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
//			Font font0 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font0.setSize(16);
//
//			Font font1criteria3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font1criteria3.setSize(14);
//
//			Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font2.setSize(12);
//
//			Paragraph paragraph1criteria3 = new Paragraph("Criterion 3 - Research, Innovations and Extension\r\n" + "\r\n",
//					font0);
//			paragraph1criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph1criteria3);
//		
//
//			Paragraph paragraph5criteria3 = new Paragraph("3.4	Research Publications and Awards\r\n\r\n", font2);
//			paragraph5criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph5criteria3);
//			// create table 10 ///
//			PdfPTable table10criteria3 = new PdfPTable(2);
//			PdfPTable table101criteria31 = new PdfPTable(1);
//			table10criteria3.setWidthPercentage(100f);
//			table101criteria31.setWidthPercentage(100f);
//			PdfPCell cell101criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell102criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
//			PdfPCell cell103criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell104criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell105criteria3 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n"));
//			PdfPCell cell106criteria3 = new PdfPCell(new Paragraph(""));
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
//					font2));
//			table101criteria31.addCell(cell341criteria3);
//			table101criteria31.addCell(table10criteria3);
//			document.add(cell341criteria3);
//			table10criteria3.setSpacingBefore(20f);
//			table10criteria3.setSpacingAfter(20f);
//			document.add(table101criteria31);
//
//			/// create table 11 ////
//			PdfPTable table11criteria3 = new PdfPTable(2);
//			PdfPTable table111criteria31 = new PdfPTable(1);
//
//			table11criteria3.setWidthPercentage(100f);
//			table111criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell111criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell112criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell113criteria3 = new PdfPCell(new Paragraph(
//					"List of PhD scholars and their details like name of the guide , title of thesis, year of award etc\r\n\r\n\r\n"));
//			PdfPCell cell114criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell115criteria3 = new PdfPCell(new Paragraph("URL to the research page on HEI web site\r\n\r\n\r\n"));
//			PdfPCell cell116criteria3 = new PdfPCell(new Paragraph(""));
//			table11criteria3.addCell(cell111criteria3);
//			table11criteria3.addCell(cell112criteria3);
//			table11criteria3.addCell(cell113criteria3);
//			table11criteria3.addCell(cell114criteria3);
//			table11criteria3.addCell(cell115criteria3);
//			table11criteria3.addCell(cell116criteria3);
//			PdfPCell cell342criteria3 = new PdfPCell(new Paragraph(
//					"3.4.2 Number of Ph.D’s registered per teacher (as per the data given w.r.t recognized Ph.D guides/ supervisors provided at 3.2.3 metric) during the last five years\r\n"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse342()
//									: ""),
//					font2));
//
//			table111criteria31.addCell(cell342criteria3);
//			 document.add(cell342criteria3);
//			PdfPCell cell3421criteria3 = new PdfPCell(
//					new Paragraph("3.4.2.1 How many Ph.Ds are registered within last 5 years" + "\r\n\r\n\r\n", font2));
//			PdfPCell cell3422criteria3 = new PdfPCell(new Paragraph(
//					"3.4.2.2 Number of teachers recognized as guides during the last five years\r\n" + "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3422t1()
//									: ""),
//					font2));
//			table111criteria31.addCell(cell3421criteria3);
//			table111criteria31.addCell(cell3422criteria3);
//			table111criteria31.addCell(table11criteria3);
//
//			 document.add(cell3421criteria3);
//			 document.add(cell3422criteria3);
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
//			PdfPCell cell121criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell122criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell123criteria3 = new PdfPCell(new Paragraph(
//					"List of PhD scholars and their details like name of the guide , title of thesis, year of award etc\r\n\r\n\\r\n",
//					font2));
//			PdfPCell cell124criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell125criteria3 = new PdfPCell(new Paragraph("URL to the research page on HEI web site\r\n\r\n\r\n", font2));
//			PdfPCell cell126criteria3 = new PdfPCell(new Paragraph(""));
//			table12criteria3.addCell(cell121criteria3);
//			table12criteria3.addCell(cell122criteria3);
//			table12criteria3.addCell(cell123criteria3);
//			table12criteria3.addCell(cell124criteria3);
//			table12criteria3.addCell(cell125criteria3);
//			table12criteria3.addCell(cell126criteria3);
//			PdfPCell cell343criteria3 = new PdfPCell(new Paragraph(
//					"3.4.3 Number of research papers per teachers in the Journals notified on UGC website during the last five years\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse343()
//									: ""),
//					font2));
//			PdfPCell cell3431criteria3 = new PdfPCell(new Paragraph(
//					"3.4.3.1 Number of research papers in the Journals notified on UGC website during the last five years\r\n\r\n"
//							+ "",
//					font2));
//			table123criteria31.addCell(cell343criteria3);
//			table123criteria31.addCell(cell3431criteria3);
//			table123criteria31.addCell(table12criteria3);
//
//			document.add(cell343criteria3);
//			document.add(cell3431criteria3);
//			table123criteria31.setSpacingBefore(20f);
//			table123criteria31.setSpacingAfter(20f);
//
//			document.add(table123criteria31);
//			/// create table 3431 ////
//
//			if (criteria3Fieldinfo.getYearTable3431() != null) {
//				Table table3431criteria3 = new Table(criteria3Fieldinfo.getYearTable3431().size(), 2);
//
//				table3431criteria3.setPadding(10);
//				table3431criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3431().size(); i++) {
//					table3431criteria3.addCell(criteria3Fieldinfo.getYearTable3431().get(i).getInput3431y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3431().size(); i++) {
//					table3431criteria3.addCell(criteria3Fieldinfo.getYearTable3431().get(i).getInput3431v());
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
//			PdfPCell cell131criteria3 = new PdfPCell(new Paragraph("\r\n\r\n\r\n", font2));
//			PdfPCell cell132criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell133criteria3 = new PdfPCell(
//					new Paragraph("List books and chapters in edited volumes / books published\r\n\r\n\r\n"));
//			PdfPCell cell134criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell135criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell136criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			table13criteria3.addCell(cell131criteria3);
//			table13criteria3.addCell(cell132criteria3);
//			table13criteria3.addCell(cell133criteria3);
//			table13criteria3.addCell(cell134criteria3);
//			table13criteria3.addCell(cell135criteria3);
//			table13criteria3.addCell(cell136criteria3);
//			PdfPCell cell344criteria3 = new PdfPCell(new Paragraph(
//					"3.4.4 Number of books and chapters in edited volumes / books published per teacher during the last five years\r\n"
//							+ " \r\n" + "\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse344()
//									: ""),
//					font2));
//			PdfPCell cell3441criteria3 = new PdfPCell(new Paragraph(
//					"3.4.4.1 Total number of books and chapters in edited volumes/books published and papers in national/ international conference proceedings year-wise during last five years"
//							+ "\r\n\r\n\r\n",
//					font2));
//			table131criteria31.addCell(cell344criteria3);
//			table131criteria31.addCell(cell3441criteria3);
//			table131criteria31.addCell(table13criteria3);
//
//			 document.add(cell344criteria3);
//			 document.add(cell3441criteria3);
//			table131criteria31.setSpacingBefore(20f);
//			table131criteria31.setSpacingAfter(20f);
//
//			document.add(table131criteria31);
//			// create table 3441 //
//
//			if (criteria3Fieldinfo.getCriteria3FieldInfoQn().size() >0) {
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
//			// create table 14 //
//			PdfPTable table14criteria3 = new PdfPTable(2);
//			PdfPTable table141criteria31 = new PdfPTable(1);
//
//			table14criteria3.setWidthPercentage(100f);
//			table141criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell141criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell142criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell143criteria3 = new PdfPCell(
//					new Paragraph("Bibliometrics of the publications during the last five years\r\n\r\n\r\n"));
//			PdfPCell cell144criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			table14criteria3.addCell(cell141criteria3);
//			table14criteria3.addCell(cell142criteria3);
//			table14criteria3.addCell(cell143criteria3);
//			table14criteria3.addCell(cell144criteria3);
//
//			PdfPCell cell345criteria3 = new PdfPCell(new Paragraph(
//					"3.4.5 Bibliometrics of the publications during the last five years based on average citation index in Scopus/ Web of Science or PubMed\r\n"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse345()
//									: ""),
//					font2));
//			table141criteria31.addCell(cell345criteria3);
//			table141criteria31.addCell(table14criteria3);
//			table141criteria31.setSpacingBefore(20f);
//			table141criteria31.setSpacingAfter(20f);
//			document.add(table141criteria31);
//			// create table 15 //
//			PdfPTable table15criteria3 = new PdfPTable(2);
//			PdfPTable table153criteria31 = new PdfPTable(1);
//
//			table15criteria3.setWidthPercentage(100f);
//			table153criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell151criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell152criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell153criteria3 = new PdfPCell(new Paragraph(
//					"Bibiliometrics of publications based on Scopus/ Web of Science - h-index of the Institution\r\n\r\n\r\n"));
//			PdfPCell cell154criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			table15criteria3.addCell(cell151criteria3);
//			table15criteria3.addCell(cell152criteria3);
//			table15criteria3.addCell(cell153criteria3);
//			table15criteria3.addCell(cell154criteria3);
//			PdfPCell cell346criteria3 = new PdfPCell(new Paragraph(
//					"3.4.6 Bibliometrics of the publications during the last five years based on Scopus/ Web of Science - h- index of the Institution\r\n"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse346()
//									: ""),
//					font2));
//			table153criteria31.addCell(cell346criteria3);
//			table153criteria31.addCell(table15criteria3);
//
//			 document.add(cell346criteria3);
//			table153criteria31.setSpacingBefore(20f);
//			table153criteria31.setSpacingAfter(20f);
//			document.add(table153criteria31);
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
//
//
