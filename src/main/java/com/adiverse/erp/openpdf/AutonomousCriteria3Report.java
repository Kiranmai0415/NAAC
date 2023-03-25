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
//public class AutonomousCriteria3Report {
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
//public String generateReport() throws DocumentException, IOException {
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
//			Paragraph paragraph2criteria3 = new Paragraph("3.1	Promotion of Research and Facilities\r\n", font1criteria3);
//			paragraph1criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph2criteria3);
//			// create table1
//			PdfPTable table1criteria3 = new PdfPTable(2);
//			PdfPTable table13criteria31 = new PdfPTable(1);
//
//			table1criteria3.setWidthPercentage(100f);
//			table13criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell1criteria3 = new PdfPCell(new Paragraph("File Description", font2));
//			PdfPCell cell2criteria3 = new PdfPCell(new Paragraph("Document", font2));
//			PdfPCell cell3criteria3 = new PdfPCell(new Paragraph(
//					"Minutes of the Governing Council/ Syndicate/Board of Management related to research promotion policy adoption"));
//			PdfPCell cell4criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell5criteria3 = new PdfPCell(new Paragraph("Any additional information"));
//			PdfPCell cell6criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell7criteria3 = new PdfPCell(
//					new Paragraph("URL of Policy document on promotion of research uploaded on website"));
//			PdfPCell cell8criteria3 = new PdfPCell(new Paragraph(""));
//			table1criteria3.addCell(cell1criteria3);
//			table1criteria3.addCell(cell2criteria3);
//			table1criteria3.addCell(cell3criteria3);
//			table1criteria3.addCell(cell4criteria3);
//			table1criteria3.addCell(cell5criteria3);
//			table1criteria3.addCell(cell6criteria3);
//			table1criteria3.addCell(cell7criteria3);
//			table1criteria3.addCell(cell8criteria3);
//
//			PdfPCell cell311criteria3 = new PdfPCell(new Paragraph(
//					"3.1.1	The institution's Research facilities are frequently updated and there is a well defined policy for promotion of research which is uploaded on the institutional website and implemented.\r\n"
//							+ "Response:"
//							+ (criteria3_FieldInfoQl != null
//									? criteria3_FieldInfoQl.getCriteria3FieldInfoQl().get(0).getResponse311()
//									: ""),
//					font2));
//			table13criteria31.addCell(cell311criteria3);
//			table13criteria31.addCell(table1criteria3);
//
//			table1criteria3.setSpacingBefore(20f);
//			table1criteria3.setSpacingAfter(20f);
//			document.add(table13criteria31);
//
//			// create table 2////
//			PdfPTable table2criteria3 = new PdfPTable(2);
//			PdfPTable table23criteria31 = new PdfPTable(1);
//			table2criteria3.setWidthPercentage(100f);
//			table23criteria31.setWidthPercentage(100f);
//			PdfPCell cell21criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell22criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell23criteria3 = new PdfPCell(new Paragraph("Minutes of the relevant bodies of the Institution\r\n\r\n\r\n"));
//			PdfPCell cell24criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(2).getCriteria3FilePath() : ""));
//			PdfPCell cell25criteria3 = new PdfPCell(
//					new Paragraph("List of teachers receiving grant and details of grant received\r\n\r\n\r\n"));
//			PdfPCell cell26criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(3).getCriteria3FilePath() : ""));
//			PdfPCell cell27criteria3 = new PdfPCell(new Paragraph(
//					"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n\r\n"));
//			PdfPCell cell28criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(4).getCriteria3FilePath() : ""));
//			table2criteria3.addCell(cell21criteria3);
//			table2criteria3.addCell(cell22criteria3);
//			table2criteria3.addCell(cell23criteria3);
//			table2criteria3.addCell(cell24criteria3);
//			table2criteria3.addCell(cell25criteria3);
//			table2criteria3.addCell(cell26criteria3);
//			table2criteria3.addCell(cell27criteria3);
//			table2criteria3.addCell(cell28criteria3);
//			PdfPCell cell312criteria3 = new PdfPCell(new Paragraph(
//					"3.1.2 The institution provides seed money to its teachers for research (average per year, INR in Lakhs)\r\n\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse312()
//									: ""),
//					font2));
//			PdfPCell cell3121criteria3 = new PdfPCell(new Paragraph(
//					"3.1.2.1 The amount of seed money provided by institution to its faculty year-wise during the last five years (INR in lakhs).",
//					font2));
//
//			table23criteria31.addCell(cell312criteria3);
//			table23criteria31.addCell(cell3121criteria3);
//			table23criteria31.setSpacingAfter(10f);
//			table23criteria31.setSpacingAfter(10f);
//
//			document.add(table23criteria31);
//			// create table 3121///
//			System.out.println("criteria3FieldInfoQnList.get(0) == >" + criteria3_FieldInfoQnList);
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3121criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3121().size());
//
//				table3121criteria3.setPadding(10);
//				table3121criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3121().size(); i++) {
//					table3121criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3121().get(i).getInput3121y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3121().size(); i++) {
//					table3121criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3121().get(i).getInput3121v());
//
//				}
//
//				document.add(table3121criteria3);
//			}
//
//			// create table 3 //////
//			PdfPTable table3criteria3 = new PdfPTable(2);
//			PdfPTable table33criteria31 = new PdfPTable(1);
//
//			table3criteria3.setWidthPercentage(100f);
//			table33criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell31criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell32criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell33criteria3 = new PdfPCell(
//					new Paragraph("List of teachers and their international fellowship details\r\n\r\n\r\n"));
//			PdfPCell cell34criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(5).getCriteria3FilePath() : ""));
//			PdfPCell cell35criteria3 = new PdfPCell(new Paragraph("e-copies of the award letters of the teachers"));
//			PdfPCell cell36criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(6).getCriteria3FilePath() : ""));
//			table3criteria3.addCell(cell31criteria3);
//			table3criteria3.addCell(cell32criteria3);
//			table3criteria3.addCell(cell33criteria3);
//			table3criteria3.addCell(cell34criteria3);
//			table3criteria3.addCell(cell35criteria3);
//			table3criteria3.addCell(cell36criteria3);
//			PdfPCell cell313criteria3 = new PdfPCell(new Paragraph(
//					"3.1.3 Percentage of teachers awarded national / international fellowship for advanced studies/research during the last five years\r\n"
//							+ "\r\n" + "Response"
//							+ (criteria3_FieldInfoQl != null
//									? criteria3_FieldInfoQl.getCriteria3FieldInfoQl().get(0).getResponse311()
//									: ""),
//					font2));
//			PdfPCell cell3131criteria3 = new PdfPCell(new Paragraph(
//					"3.1.3.1 The number of teachers awarded national / international fellowship for advanced studies / research year wise during last five years"
//							+ "\r\n\r\n",
//					font2));
//			table33criteria31.addCell(cell313criteria3);
//			table33criteria31.addCell(cell3131criteria3);
//			table33criteria31.addCell(table3criteria3);
//			// document.add(cell313criteria3);
//			// document.add(cell3131criteria3);
//			table33criteria31.setSpacingBefore(20f);
//			table33criteria31.setSpacingAfter(20f);
//			document.add(table33criteria31);
//			// create table 3131 ///
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3131criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3131().size(), 2);
//
//				table3131criteria3.setPadding(10);
//				table3131criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3131().size(); i++) {
//					table3131criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3131().get(i).getInput3131y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3131().size(); i++) {
//					table3131criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3131().get(i).getInput3131v());
//
//				}
//
//				document.add(table3131criteria3);
//			}
//
//			Paragraph paragraph3criteria3 = new Paragraph("3.2	Resource Mobilization for Research\r\n\r\n", font1criteria3);
//			paragraph3criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph3criteria3);
//
//			/// create table 4//
//			PdfPTable table4criteria3 = new PdfPTable(2);
//			PdfPTable table43criteria31 = new PdfPTable(1);
//
//			table4criteria3.setWidthPercentage(100f);
//			PdfPCell cell41criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell42criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell43criteria3 = new PdfPCell(new Paragraph("List of project and grant details\r\n\r\n\r\n"));
//			PdfPCell cell44criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(7).getCriteria3FilePath() : ""));
//			PdfPCell cell45criteria3 = new PdfPCell(new Paragraph(
//					"e-copies of the grant award letters for research projects sponsored by government and non- government\r\n\r\n"));
//			PdfPCell cell46criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(8).getCriteria3FilePath() : ""));
//			PdfPCell cell47criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			PdfPCell cell48criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(9).getCriteria3FilePath() : ""));
//			PdfPCell cell321criteria3 = new PdfPCell(new Paragraph(
//					"3.2.1 Grants received from Government and non-governmental agencies for research projects, endowments, Chairs in the institution during the last five years (INR in Lakhs)\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse321()
//									: ""),
//					font2));
//			PdfPCell cell3211criteria3 = new PdfPCell(new Paragraph(
//					"3.2.1.1 Total Grants from Government and non-governmental agencies for research projects , endowments, Chairs in the institution during the last five years (INR in Lakhs)"
//							+ "\r\n\r\n",
//					font2));
//			table43criteria31.addCell(cell321criteria3);
//			table43criteria31.addCell(cell3211criteria3);
//
//			table4criteria3.addCell(cell41criteria3);
//			table4criteria3.addCell(cell42criteria3);
//			table4criteria3.addCell(cell43criteria3);
//			table4criteria3.addCell(cell44criteria3);
//			table4criteria3.addCell(cell45criteria3);
//			table4criteria3.addCell(cell46criteria3);
//			table4criteria3.addCell(cell47criteria3);
//			table4criteria3.addCell(cell48criteria3);
//
//			table43criteria31.addCell(table4criteria3);
//
//			table43criteria31.setSpacingBefore(20f);
//			table43criteria31.setSpacingAfter(20f);
//
//			document.add(table43criteria31);
//			// create table 3211/////
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3211criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3121().size(), 2);
//
//				table3211criteria3.setPadding(10);
//				table3211criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3211().size(); i++) {
//					table3211criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3211().get(i).getInput3211y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3211().size(); i++) {
//					table3211criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3211().get(i).getInput3211v());
//
//				}
//
//				document.add(table3211criteria3);
//			}
//
//			// create table 5 //////
//			PdfPTable table5criteria3 = new PdfPTable(2);
//			PdfPTable table53criteria31 = new PdfPTable(1);
//
//			table5criteria3.setWidthPercentage(100f);
//			PdfPCell cell51criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell52criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\\r\n", font2));
//			PdfPCell cell53criteria3 = new PdfPCell(new Paragraph("Names of teachers having research projects"));
//			PdfPCell cell54criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(10).getCriteria3FilePath() : ""));
//			PdfPCell cell55criteria3 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell56criteria3 = new PdfPCell(new Paragraph(""));
//			table5criteria3.addCell(cell51criteria3);
//			table5criteria3.addCell(cell52criteria3);
//			table5criteria3.addCell(cell53criteria3);
//			table5criteria3.addCell(cell54criteria3);
//			table5criteria3.addCell(cell55criteria3);
//			table5criteria3.addCell(cell56criteria3);
//			PdfPCell cell322criteria3 = new PdfPCell(
//					new Paragraph("3.2.2 Percentage of teachers having research projects during the last five years\r\n"
//							+ "\r\n\r\n" + "Response: \r\n\r\n"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse322()
//									: ""),
//							font1criteria3));
//			PdfPCell cell3221criteria3 = new PdfPCell(new Paragraph(
//					"3.2.2.1 Number of teachers having research projects during the last five years" + "\r\n\r\n", font1criteria3));
//			table53criteria31.addCell(cell322criteria3);
//			table53criteria31.addCell(cell3221criteria3);
//
//			table5criteria3.addCell(table53criteria31);
//			// document.add(cell322criteria3);
//			// document.add(cell3221criteria3);
//			table53criteria31.setSpacingBefore(20f);
//			table53criteria31.setSpacingAfter(20f);
//
//			document.add(table53criteria31);
//			// create table 3221 //////
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3221criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3221().size(), 2);
//
//				table3221criteria3.setPadding(10);
//				table3221criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3221().size(); i++) {
//					table3221criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3221().get(i).getInput3221y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3221().size(); i++) {
//					table3221criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3221().get(i).getInput3221v());
//
//				}
//
//				document.add(table3221criteria3);
//			}
//
//			// create table 6////
//			PdfPTable table6criteria3 = new PdfPTable(2);
//			PdfPTable table63criteria31 = new PdfPTable(1);
//
//			table6criteria3.setWidthPercentage(100f);
//			PdfPCell cell61criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell62criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell63criteria3 = new PdfPCell(
//					new Paragraph("Upload copies of the letter of the university recognizing faculty as research guides\r\n\r\n\r\n"));
//			PdfPCell cell64criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(11).getCriteria3FilePath() : ""));
//			PdfPCell cell65criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			PdfPCell cell66criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(12).getCriteria3FilePath() : ""));
//			PdfPCell cell67criteria3 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell68criteria3 = new PdfPCell(new Paragraph(""));
//			table6criteria3.addCell(cell61criteria3);
//			table6criteria3.addCell(cell62criteria3);
//			table6criteria3.addCell(cell63criteria3);
//			table6criteria3.addCell(cell64criteria3);
//			table6criteria3.addCell(cell65criteria3);
//			table6criteria3.addCell(cell66criteria3);
//			table6criteria3.addCell(cell67criteria3);
//			table6criteria3.addCell(cell68criteria3);
//			PdfPCell cell323criteria3 = new PdfPCell(
//					new Paragraph("3.2.3 Percentage of teachers recognised as research guides\r\n" + "\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse323()
//									: ""),
//							font2));
//			PdfPCell cell3231criteria3 = new PdfPCell(
//					new Paragraph("3.2.3.1 Number of teachers recognized as research guides\r\n" + "\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getInput3231t1()
//									: ""),
//							font2));
//			table6criteria3.addCell(cell323criteria3);
//			table6criteria3.addCell(cell3231criteria3);
//			table63criteria31.addCell(table6criteria3);
//
//			// document.add(cell323criteria3);
//			// document.add(cell3231criteria3);
//			table63criteria31.setSpacingBefore(10f);
//			table63criteria31.setSpacingAfter(10f);
//
//			document.add(table63criteria31);
//			/// create table 7 ///
//			PdfPTable table7criteria3 = new PdfPTable(2);
//			PdfPTable table73criteria31 = new PdfPTable(1);
//
//			table7criteria3.setWidthPercentage(100f);
//			table73criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell71criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell72criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
//			PdfPCell cell73criteria3 = new PdfPCell(new Paragraph("Supporting document from Funding Agency\r\n\r\n\r\n"));
//			PdfPCell cell74criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(13).getCriteria3FilePath() : ""));
//			PdfPCell cell75criteria3 = new PdfPCell(new Paragraph("List of research projects and funding details\r\n\r\n\r\n"));
//			PdfPCell cell76criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(14).getCriteria3FilePath() : ""));
//			PdfPCell cell77criteria3 = new PdfPCell(new Paragraph("Paste link to funding agency website\r\n\r\n\r\n"));
//			PdfPCell cell78criteria3 = new PdfPCell(new Paragraph(""));
//			table7criteria3.addCell(cell71criteria3);
//			table7criteria3.addCell(cell72criteria3);
//			table7criteria3.addCell(cell73criteria3);
//			table7criteria3.addCell(cell74criteria3);
//			table7criteria3.addCell(cell75criteria3);
//			table7criteria3.addCell(cell76criteria3);
//			table7criteria3.addCell(cell77criteria3);
//			table7criteria3.addCell(cell78criteria3);
//			PdfPCell cell324criteria3 = new PdfPCell(new Paragraph(
//					"3.2.4 Average percentage of departments having Research projects funded by government and non- government agencies during the last five years\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse324()
//									: ""),
//					font2));
//			PdfPCell cell3241criteria3 = new PdfPCell(new Paragraph(
//					"3.2.4.1 Number of departments having Research projects funded by government and non- government agencies during the last five years\r\n"
//							+ "\r\n\r\n",
//					font2));
//
//			PdfPCell cell3242criteria3 = new PdfPCell(new Paragraph(
//					"3.2.4.1 Number of departments having Research projects funded by government and non- government agencies during the last five years\r\n"
//							+ "\r\n\r\n",
//					font2));
//
//			table73criteria31.addCell(cell324criteria3);
//			table73criteria31.addCell(cell3241criteria3);
//			table73criteria31.addCell(cell3242criteria3);
//
//			table73criteria31.addCell(table7criteria3);
//			// document.add(cell324criteria3);
//			// document.add(cell3241criteria3);
//			// document.add(cell3242criteria3);
//			table73criteria31.setSpacingBefore(20f);
//			table73criteria31.setSpacingAfter(20f);
//
//			document.add(table73criteria31);
//			/// create table 3241 ///
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3241criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3241().size(), 2);
//
//				table3241criteria3.setPadding(10);
//				table3241criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3241().size(); i++) {
//					table3241criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3241().get(i).getInput3241y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3241().size(); i++) {
//					table3241criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3241().get(i).getInput3241v());
//
//				}
//
//				document.add(table3241criteria3);
//			}
//
//			/// create table 3242
//			/*
//			 * Table table3242criteria3=new
//			 * Table(criteria3FieldInfoQnList.get(0).getYearTable3242(). size(),2);
//			 * 
//			 * table3242criteria3.setPadding(10); table3242criteria3.setWidth(100f); for(int
//			 * i=0; i< criteria3FieldInfoQnList.get(0).getYearTable3242().size() ;i++) {
//			 * table3242criteria3.addCell(criteria3FieldInfoQnList.get(0
//			 * ).getYearTable3242().get(i).getInput3242y());
//			 * 
//			 * } for(int i=0; i< criteria3FieldInfoQnList.get(0).getYearTable3242().size()
//			 * ;i++) { table3242criteria3.addCell(criteria3FieldInfoQnList.get(0
//			 * ).getYearTable3242().get(i).getInput3242v());
//			 * 
//			 * }
//			 * 
//			 * document.add(table3242criteria3);
//			 */
//
//			////// 3.3//
//			Paragraph paragraph4criteria3 = new Paragraph("3.3	Innovation Ecosystem\r\n\r\n\r\n", font1criteria3);
//			paragraph4criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph4criteria3);
//			// create table 8 ///
//			PdfPTable table8criteria3 = new PdfPTable(2);
//			PdfPTable table81criteria31 = new PdfPTable(1);
//
//			table8criteria3.setWidthPercentage(100f);
//			table81criteria31.setWidthPercentage(100f);
//			PdfPCell cell81criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font2));
//			PdfPCell cell82criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
//			PdfPCell cell83criteria3 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n"));
//			PdfPCell cell84criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(15).getCriteria3FilePath() : ""));
//			PdfPCell cell85criteria3 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			PdfPCell cell86criteria3 = new PdfPCell(new Paragraph(""));
//			table8criteria3.addCell(cell81criteria3);
//			table8criteria3.addCell(cell82criteria3);
//			table8criteria3.addCell(cell83criteria3);
//			table8criteria3.addCell(cell84criteria3);
//			table8criteria3.addCell(cell85criteria3);
//			table8criteria3.addCell(cell86criteria3);
//			PdfPCell cell331criteria3 = new PdfPCell(new Paragraph(
//					"3.3.1	Institution has created an eco system for innovations, creation and transfer of knowledge supported by dedicated centers for research, entrepreneurship, community orientation, Incubation etc.\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse313()
//									: ""),
//					font2));
//			table81criteria31.addCell(cell331criteria3);
//			table81criteria31.addCell(table8criteria3);
//
//			// document.add(cell331criteria3);
//
//			table81criteria31.setSpacingBefore(20f);
//			table81criteria31.setSpacingAfter(20f);
//
//			document.add(table81criteria31);
//			/// create table 9 ////
//			PdfPTable table9criteria3 = new PdfPTable(2);
//			PdfPTable table91criteria31 = new PdfPTable(1);
//
//			table9criteria3.setWidthPercentage(100f);
//			table91criteria31.setWidthPercentage(100f);
//			PdfPCell cell91criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell92criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell93criteria3 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell94criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(16).getCriteria3FilePath() : ""));
//			PdfPCell cell95criteria3 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell96criteria3 = new PdfPCell(new Paragraph(""));
//			table9criteria3.addCell(cell91criteria3);
//			table9criteria3.addCell(cell92criteria3);
//			table9criteria3.addCell(cell93criteria3);
//			table9criteria3.addCell(cell94criteria3);
//			table9criteria3.addCell(cell95criteria3);
//			table9criteria3.addCell(cell96criteria3);
//			PdfPCell cell332criteria3 = new PdfPCell(new Paragraph(
//					"3.3.2 Number of workshops/seminars conducted on Research methodology, Intellectual Property Rights (IPR),entrepreneurship, skill development during the last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse332()
//									: ""),
//					font2));
//			PdfPCell cell3321criteria3 = new PdfPCell(new Paragraph(
//					"3.3.2.1 Total number of workshops/seminars conducted on Research methodology, Intellectual Property Rights (IPR),entrepreneurship, skill development year-wise during the last five years.\r\n"
//							+ "\r\n\r\n",
//					font2));
//			table91criteria31.addCell(cell332criteria3);
//			table91criteria31.addCell(cell3321criteria3);
//			table91criteria31.addCell(table9criteria3);
//
//			// document.add(cell332criteria3);
//			// document.add(cell3321criteria3);
//			table91criteria31.setSpacingBefore(20f);
//			table91criteria31.setSpacingAfter(20f);
//			document.add(table91criteria31);
//			// create a table 3321 //
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3321criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3221().size(), 2);
//
//				table3321criteria3.setPadding(10);
//				table3321criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3321().size(); i++) {
//					table3321criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3321().get(i).getInput3321y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3321().size(); i++) {
//					table3321criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3321().get(i).getInput3321v());
//
//				}
//
//				document.add(table3321criteria3);
//			}
//
//			// 3.4 ///
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
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(17).getCriteria3FilePath() : ""));
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
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse341()
//									: ""),
//					font2));
//			table101criteria31.addCell(cell341criteria3);
//			table101criteria31.addCell(table10criteria3);
//			// document.add(cell341criteria3);
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
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(18).getCriteria3FilePath() : ""));
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
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse342()
//									: ""),
//					font2));
//
//			table111criteria31.addCell(cell342criteria3);
//			// document.add(cell342criteria3);
//			PdfPCell cell3421criteria3 = new PdfPCell(
//					new Paragraph("3.4.2.1 How many Ph.Ds are registered within last 5 years" + "\r\n\r\n\r\n", font2));
//			PdfPCell cell3422criteria3 = new PdfPCell(new Paragraph(
//					"3.4.2.2 Number of teachers recognized as guides during the last five years\r\n" + "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getInput3422t1()
//									: ""),
//					font2));
//			table111criteria31.addCell(cell3421criteria3);
//			table111criteria31.addCell(cell3422criteria3);
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
//			PdfPCell cell121criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell122criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell123criteria3 = new PdfPCell(new Paragraph(
//					"List of PhD scholars and their details like name of the guide , title of thesis, year of award etc\r\n\r\n\\r\n",
//					font2));
//			PdfPCell cell124criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(19).getCriteria3FilePath() : ""));
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
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse343()
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
//			// document.add(cell343criteria3);
//			// document.add(cell3431criteria3);
//			table123criteria31.setSpacingBefore(20f);
//			table123criteria31.setSpacingAfter(20f);
//
//			document.add(table123criteria31);
//			/// create table 3431 ////
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3431criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3431().size(), 2);
//
//				table3431criteria3.setPadding(10);
//				table3431criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3431().size(); i++) {
//					table3431criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3431().get(i).getInput3431y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3431().size(); i++) {
//					table3431criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3431().get(i).getInput3431v());
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
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(20).getCriteria3FilePath() : ""));
//			PdfPCell cell135criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell136criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(21).getCriteria3FilePath() : ""));
//			table13criteria3.addCell(cell131criteria3);
//			table13criteria3.addCell(cell132criteria3);
//			table13criteria3.addCell(cell133criteria3);
//			table13criteria3.addCell(cell134criteria3);
//			table13criteria3.addCell(cell135criteria3);
//			table13criteria3.addCell(cell136criteria3);
//			PdfPCell cell344criteria3 = new PdfPCell(new Paragraph(
//					"3.4.4 Number of books and chapters in edited volumes / books published per teacher during the last five years\r\n"
//							+ " \r\n" + "\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse344()
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
//			// document.add(cell344criteria3);
//			// document.add(cell3441criteria3);
//			table131criteria31.setSpacingBefore(20f);
//			table131criteria31.setSpacingAfter(20f);
//
//			document.add(table131criteria31);
//			// create table 3441 //
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3441criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3441().size(), 2);
//
//				table3441criteria3.setPadding(10);
//				table3441criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3441().size(); i++) {
//					table3441criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3441().get(i).getInput3441y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3441().size(); i++) {
//					table3441criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3441().get(i).getInput3441v());
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
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(22).getCriteria3FilePath() : ""));
//			table14criteria3.addCell(cell141criteria3);
//			table14criteria3.addCell(cell142criteria3);
//			table14criteria3.addCell(cell143criteria3);
//			table14criteria3.addCell(cell144criteria3);
//
//			PdfPCell cell345criteria3 = new PdfPCell(new Paragraph(
//					"3.4.5 Bibliometrics of the publications during the last five years based on average citation index in Scopus/ Web of Science or PubMed\r\n"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse345()
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
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(23).getCriteria3FilePath() : ""));
//			table15criteria3.addCell(cell151criteria3);
//			table15criteria3.addCell(cell152criteria3);
//			table15criteria3.addCell(cell153criteria3);
//			table15criteria3.addCell(cell154criteria3);
//			PdfPCell cell346criteria3 = new PdfPCell(new Paragraph(
//					"3.4.6 Bibliometrics of the publications during the last five years based on Scopus/ Web of Science - h- index of the Institution\r\n"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse346()
//									: ""),
//					font2));
//			table153criteria31.addCell(cell346criteria3);
//			table153criteria31.addCell(table15criteria3);
//
//			// document.add(cell346criteria3);
//			table153criteria31.setSpacingBefore(20f);
//			table153criteria31.setSpacingAfter(20f);
//			document.add(table153criteria31);
//			// 3.5 //
//			Paragraph paragraph6criteria3 = new Paragraph("3.5	Consultancy\r\n\r\n\r\n", font2);
//			paragraph6criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph6criteria3);
//			// create table 16 //
//			PdfPTable table16criteria3 = new PdfPTable(2);
//			PdfPTable table161criteria31 = new PdfPTable(1);
//
//			table16criteria3.setWidthPercentage(100f);
//			table16criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell161criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell162criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
//			PdfPCell cell163criteria3 = new PdfPCell(new Paragraph("List of consultants and revenue generated by them\r\n\r\n\r\n"));
//			PdfPCell cell164criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(24).getCriteria3FilePath() : ""));
//			PdfPCell cell165criteria3 = new PdfPCell(new Paragraph(
//					"Audited statements of accounts indicating the revenue generated through consultancy and corporate training\r\n\r\n\r\n"));
//			PdfPCell cell166criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(25).getCriteria3FilePath() : ""));
//			PdfPCell cell167criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell168criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(26).getCriteria3FilePath() : ""));
//			table16criteria3.addCell(cell161criteria3);
//			table16criteria3.addCell(cell162criteria3);
//			table16criteria3.addCell(cell163criteria3);
//			table16criteria3.addCell(cell164criteria3);
//			table16criteria3.addCell(cell165criteria3);
//			table16criteria3.addCell(cell166criteria3);
//			table16criteria3.addCell(cell167criteria3);
//			table16criteria3.addCell(cell168criteria3);
//			PdfPCell cell351criteria3 = new PdfPCell(new Paragraph(
//					"3.5.1 Revenue generated from consultancy and corporate training during the last five years (INR in Lakhs).\r\n"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse351()
//									: ""),
//					font2));
//			PdfPCell cell3511criteria3 = new PdfPCell(new Paragraph(
//					"3.5.1.1 Total amount generated from consultancy and corporate training year-wise during the last five years (INR in lakhs).\r\n"
//							+ "\r\n\r\n",
//					font2));
//
//			table161criteria31.addCell(cell351criteria3);
//			table161criteria31.addCell(cell3511criteria3);
//			table161criteria31.addCell(table16criteria3);
//
//			// document.add(cell351criteria3);
//			// document.add(cell3511criteria3);
//			table16criteria3.setSpacingBefore(20f);
//			table16criteria3.setSpacingAfter(20f);
//			document.add(table161criteria31);
//			// create table 3511 ///
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3511criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3511().size(), 2);
//
//				table3511criteria3.setPadding(10);
//				table3511criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3511().size(); i++) {
//					table3511criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3511().get(i).getInput3511y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3511().size(); i++) {
//					table3511criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3511().get(i).getInput3511v());
//
//				}
//
//				document.add(table3511criteria3);
//			}
//
//			// create table 17 ///
//
//			PdfPTable table17criteria3 = new PdfPTable(2);
//			PdfPTable table173criteria31 = new PdfPTable(1);
//
//			table17criteria3.setWidthPercentage(100f);
//			table173criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell171criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell172criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell173criteria3 = new PdfPCell(
//					new Paragraph("List of training programmes, teachers and staff trained for undertaking consultancy\r\n\r\n\r\n"));
//			PdfPCell cell174criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(27).getCriteria3FilePath() : ""));
//			PdfPCell cell175criteria3 = new PdfPCell(
//					new Paragraph("List of facilities and staff available for undertaking consultancy\rn\r\n\r\n"));
//			PdfPCell cell176criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(28).getCriteria3FilePath() : ""));
//			PdfPCell cell177criteria3 = new PdfPCell(new Paragraph(
//					"Audited statements of accounts indicating the expenditure incurred on developing facilities and training teachers and staff for undertaking consultancy"));
//			PdfPCell cell178criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(29).getCriteria3FilePath() : ""));
//			PdfPCell cell179criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\r\n"));
//			PdfPCell cell180criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(30).getCriteria3FilePath() : ""));
//			table17criteria3.addCell(cell171criteria3);
//			table17criteria3.addCell(cell172criteria3);
//			table17criteria3.addCell(cell173criteria3);
//			table17criteria3.addCell(cell174criteria3);
//			table17criteria3.addCell(cell175criteria3);
//			table17criteria3.addCell(cell176criteria3);
//			table17criteria3.addCell(cell177criteria3);
//			table17criteria3.addCell(cell178criteria3);
//			table17criteria3.addCell(cell179criteria3);
//			table17criteria3.addCell(cell180criteria3);
//			PdfPCell cell352criteria3 = new PdfPCell(new Paragraph(
//					"3.5.2 Total amount spent on developing facilities, training teachers and staff for undertaking consultancy during the last five years (INR in Lakhs).\r\n"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse352()
//									: ""),
//					font2));
//			PdfPCell cell3521criteria3 = new PdfPCell(new Paragraph(
//					"3.5.2.1 Total amount spent on developing facilities, training teachers and staff for undertaking consultancy during the last five years (INR in Lakhs)\r\n"
//							+ "\r\n\r\n",
//					font2));
//			table173criteria31.addCell(cell352criteria3);
//			table173criteria31.addCell(cell3521criteria3);
//			table173criteria31.addCell(table17criteria3);
//			// document.add(cell352criteria3);
//			// document.add(cell3521criteria3);
//			table173criteria31.setSpacingBefore(20f);
//			table173criteria31.setSpacingAfter(20f);
//
//			document.add(table173criteria31);
//			// create table 3521//
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3521criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3521().size(), 2);
//
//				table3521criteria3.setPadding(10);
//				table3521criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3521().size(); i++) {
//					table3521criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3521().get(i).getInput3521y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3521().size(); i++) {
//					table3521criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3521().get(i).getInput3521v());
//
//				}
//
//				document.add(table3521criteria3);
//			}
//			// 3.6 //
//			Paragraph paragraph7criteria3 = new Paragraph("3.6	Extension Activities\r\n\r\n\r\n", font2);
//			paragraph7criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph7criteria3);
//			// create table 18 //
//			PdfPTable table18criteria3 = new PdfPTable(2);
//			PdfPTable table183criteria3 = new PdfPTable(1);
//
//			table18criteria3.setWidthPercentage(100f);
//			table183criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell181criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font2));
//			PdfPCell cell182criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell183criteria3 = new PdfPCell(new Paragraph("Upload Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell184criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(31).getCriteria3FilePath() : ""));
//			PdfPCell cell185criteria3 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell186criteria3 = new PdfPCell(new Paragraph(""));
//			table18criteria3.addCell(cell181criteria3);
//			table18criteria3.addCell(cell182criteria3);
//			table18criteria3.addCell(cell183criteria3);
//			table18criteria3.addCell(cell184criteria3);
//			table18criteria3.addCell(cell185criteria3);
//			table18criteria3.addCell(cell186criteria3);
//			PdfPCell cell361criteria3 = new PdfPCell(new Paragraph(
//					"3.6.1 Extension activities are carried out in the neighbourhood community, sensitising students to social issues, for their holistic development, and impact thereof during the last five years\r\n"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQl != null
//									? criteria3_FieldInfoQl.getCriteria3FieldInfoQl().get(0).getResponse361()
//									: ""),
//					font2));
//			table183criteria3.addCell(cell361criteria3);
//			table183criteria3.addCell(table18criteria3);
//			// document.add(cell361criteria3);
//			table183criteria3.setSpacingBefore(20f);
//			table18criteria3.setSpacingAfter(20f);
//			document.add(table183criteria3);
//
//			// create table 19 //
//			PdfPTable table19criteria3 = new PdfPTable(2);
//			PdfPTable table191criteria3 = new PdfPTable(1);
//
//			table19criteria3.setWidthPercentage(100f);
//			table191criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell191criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell192criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell193criteria3 = new PdfPCell(
//					new Paragraph("Number of awards for extension activities in last 5 year\r\n\r\n\r\n"));
//			PdfPCell cell194criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(32).getCriteria3FilePath() : ""));
//			PdfPCell cell195criteria3 = new PdfPCell(new Paragraph("e-copy of the award letters\r\n\r\n\r\n"));
//			PdfPCell cell196criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(33).getCriteria3FilePath() : ""));
//			PdfPCell cell197criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell198criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(34).getCriteria3FilePath() : ""));
//			table19criteria3.addCell(cell191criteria3);
//			table19criteria3.addCell(cell192criteria3);
//			table19criteria3.addCell(cell193criteria3);
//			table19criteria3.addCell(cell194criteria3);
//			table19criteria3.addCell(cell195criteria3);
//			table19criteria3.addCell(cell196criteria3);
//			table19criteria3.addCell(cell197criteria3);
//			table19criteria3.addCell(cell198criteria3);
//			PdfPCell cell362criteria3 = new PdfPCell(new Paragraph(
//					"3.6.2 Number of awards and recognition received by the Institution, its teachers and students for extension activities from Government / Government recognised bodies during last five years\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse362()
//									: ""),
//					font2));
//			PdfPCell cell3621criteria3 = new PdfPCell(new Paragraph(
//					"3.6.2.1 Total number of awards and recognition received for extension activities from Government/ Government recognised bodies year-wise during the last five years."
//							+ "\r\n\r\n",
//					font2));
//
//			table191criteria3.addCell(cell362criteria3);
//			table191criteria3.addCell(cell3621criteria3);
//			// document.add(cell362criteria3);
//			// document.add(cell3621criteria3);
//			table191criteria3.setSpacingBefore(20f);
//			table191criteria3.setSpacingAfter(20f);
//			document.add(table191criteria3);
//
//			// create table 3621 //
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3621criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3621().size(), 2);
//
//				table3621criteria3.setPadding(10);
//				table3621criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3621().size(); i++) {
//					table3621criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3621().get(i).getInput3621y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3621().size(); i++) {
//					table3621criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3621().get(i).getInput3621v());
//
//				}
//
//				document.add(table3621criteria3);
//			}
//
//			// create table 20 //
//			PdfPTable table20criteria3 = new PdfPTable(2);
//			PdfPTable table201criteria31 = new PdfPTable(1);
//
//			table20criteria3.setWidthPercentage(100f);
//			table201criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell201criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font2));
//			PdfPCell cell202criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
//			PdfPCell cell203criteria3 = new PdfPCell(new Paragraph("Reports of the event organized\r\n\r\n"));
//			PdfPCell cell204criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(35).getCriteria3FilePath() : ""));
//			PdfPCell cell205criteria3 = new PdfPCell(new Paragraph(
//					"Number of extension and outreach Programmes conducted with industry, community etc for the last five years\r\n\r\n"));
//			PdfPCell cell206criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(36).getCriteria3FilePath() : ""));
//			table20criteria3.addCell(cell201criteria3);
//			table20criteria3.addCell(cell202criteria3);
//			table20criteria3.addCell(cell203criteria3);
//			table20criteria3.addCell(cell204criteria3);
//			table20criteria3.addCell(cell205criteria3);
//			table20criteria3.addCell(cell206criteria3);
//			PdfPCell cell363criteria3 = new PdfPCell(new Paragraph(
//					"3.6.3 Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years\r\n"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse363()
//									: ""),
//					font2));
//			PdfPCell cell3631criteria3 = new PdfPCell(new Paragraph(
//					"3.6.3.1 Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years"
//							+ "\r\n\r\n",
//					font2));
//			table201criteria31.addCell(cell363criteria3);
//			table201criteria31.addCell(cell3631criteria3);
//			table201criteria31.addCell(table20criteria3);
//			// document.add(cell363criteria3);
//			// document.add(cell3631criteria3);
//			table201criteria31.setSpacingBefore(20f);
//			table201criteria31.setSpacingAfter(20f);
//			document.add(table201criteria31);
//			// create table 3631 //
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3631criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3631().size(), 2);
//
//				table3631criteria3.setPadding(10);
//				table3631criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3631().size(); i++) {
//					table3631criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3631().get(i).getInput3631y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3631().size(); i++) {
//					table3631criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3631().get(i).getInput3631v());
//
//				}
//
//				document.add(table3631criteria3);
//			}
//
//			// create a table 21 //
//			PdfPTable table21criteria3 = new PdfPTable(2);
//			PdfPTable table211criteria3 = new PdfPTable(1);
//			table21criteria3.setWidthPercentage(100f);
//			table211criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell211criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell212criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell213criteria3 = new PdfPCell(new Paragraph("Reports of the event\r\n\r\n\r\n"));
//			PdfPCell cell214criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(37).getCriteria3FilePath() : ""));
//			PdfPCell cell215criteria3 = new PdfPCell(new Paragraph(
//					"Average percentage of students participating in extension activities with Govt or NGO etc\r\n\r\n\r\n"));
//			PdfPCell cell216criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(38).getCriteria3FilePath() : ""));
//			table21criteria3.addCell(cell211criteria3);
//			table21criteria3.addCell(cell212criteria3);
//			table21criteria3.addCell(cell213criteria3);
//			table21criteria3.addCell(cell214criteria3);
//			table21criteria3.addCell(cell215criteria3);
//			table21criteria3.addCell(cell216criteria3);
//			PdfPCell cell364criteria3 = new PdfPCell(new Paragraph(
//					"3.6.4 Average percentage of students participating in extension activities listed at 3.6.3 above during the last five years\r\n"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse364()
//									: "")));
//			PdfPCell cell3641criteria3 = new PdfPCell(new Paragraph(
//					"3.6.4.1 Total number of students participating in extension activities listed at 3.6.3 above year-wise during the last five years."
//							+ "\r\n\r\n",
//					font2));
//			table211criteria3.addCell(cell364criteria3);
//			table211criteria3.addCell(cell3641criteria3);
//			table211criteria3.addCell(table21criteria3);
//			// document.add(cell364criteria3);
//			// document.add(cell3641criteria3);
//			table211criteria3.setSpacingBefore(20f);
//			table211criteria3.setSpacingAfter(20f);
//			document.add(table211criteria3);
//			// create table 3641 //
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3641criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3641().size(), 2);
//
//				table3641criteria3.setPadding(10);
//				table3641criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3641().size(); i++) {
//					table3641criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3641().get(i).getInput3641y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3641().size(); i++) {
//					table3641criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3641().get(i).getInput3641v());
//
//				}
//
//				document.add(table3641criteria3);
//			}
//			// 3.7//
//			Paragraph paragraph8criteria3 = new Paragraph("3.7	Collaboration\r\n\r\n", font2);
//			paragraph8criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph8criteria3);
//			// create table 22 //
//			PdfPTable table22criteria3 = new PdfPTable(2);
//			PdfPTable table221criteria3 = new PdfPTable(1);
//			table22criteria3.setWidthPercentage(100f);
//			table221criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell221criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell222criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell223criteria3 = new PdfPCell(
//					new Paragraph("Number of Collaborative activities for research, faculty etc \r\n\r\n\r\n"));
//			PdfPCell cell224criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(39).getCriteria3FilePath() : ""));
//			PdfPCell cell225criteria3 = new PdfPCell(new Paragraph("Copies of collaboration\r\n\r\n\r\n"));
//			PdfPCell cell226criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(40).getCriteria3FilePath() : ""));
//			table22criteria3.addCell(cell221criteria3);
//			table22criteria3.addCell(cell222criteria3);
//			table22criteria3.addCell(cell223criteria3);
//			table22criteria3.addCell(cell224criteria3);
//			table22criteria3.addCell(cell225criteria3);
//			table22criteria3.addCell(cell226criteria3);
//			PdfPCell cell371criteria3 = new PdfPCell(new Paragraph(
//					"3.7.1 Number of Collaborative activities per year for research/ faculty exchange/ student exchange/ internship/ on –the-job training/ project work\r\n"
//							+ "\r\n\r\n\r\n" + "Response: \r\n"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse371()
//									: ""),
//					font2));
//			PdfPCell cell3711criteria3 = new PdfPCell(new Paragraph("" + "", font2));
//			table221criteria3.addCell(cell371criteria3);
//			table221criteria3.addCell(cell3711criteria3);
//			table221criteria3.addCell(table22criteria3);
//			// document.add(cell371criteria3);
//			// document.add(cell3711criteria3);
//			table221criteria3.setSpacingBefore(20f);
//			table221criteria3.setSpacingAfter(20f);
//			document.add(table221criteria3);
//			// create tablle 3711 //
//
//			/*
//			 * if(criteria3_FieldInfoQn!= null) { Table table3711criteria3 = new
//			 * Table(criteria3_FieldInfoQn.getCriteria3FieldInfoQn().get(0).getYearTable3711
//			 * ().size(), 2);
//			 * 
//			 * table3711criteria3.setPadding(10); table3711criteria3.setWidth(100f);
//			 * 
//			 * for (int i = 0; i <
//			 * criteria3_FieldInfoQn.getCriteria3FieldInfoQn().get(0).getYearTable3711().
//			 * size(); i++) {
//			 * table3711criteria3.addCell(criteria3_FieldInfoQn.getCriteria3FieldInfoQn().
//			 * get(0).getYearTable3711().get(i).getInput3711y());
//			 * 
//			 * } for (int i = 0; i <
//			 * criteria3_FieldInfoQn.getCriteria3FieldInfoQn().get(0).getYearTable3711().
//			 * size(); i++) {
//			 * table3711criteria3.addCell(criteria3_FieldInfoQn.getCriteria3FieldInfoQn().
//			 * get(0).getYearTable3711().get(i).getInput3711v());
//			 * 
//			 * }
//			 * 
//			 * document.add(table3711criteria3); }
//			 */
//
//			// create table 23 //
//			PdfPTable table23criteria3 = new PdfPTable(2);
//			PdfPTable table231criteria3 = new PdfPTable(1);
//
//			table23criteria3.setWidthPercentage(100f);
//			table231criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell231criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell232criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell233criteria3 = new PdfPCell(
//					new Paragraph("e-copies of the MoUs with institution/ industry/ corporate house\r\n\r\n\r\n"));
//			PdfPCell cell234criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(41).getCriteria3FilePath() : ""));
//			PdfPCell cell235criteria3 = new PdfPCell(new Paragraph(
//					"Details of functional MoUs with institutions of national, international importance, other Institutions etc during the last five years\r\n\r\n"));
//			PdfPCell cell236criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(42).getCriteria3FilePath() : ""));
//			PdfPCell cell237criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			PdfPCell cell238criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(43).getCriteria3FilePath() : ""));
//			table23criteria3.addCell(cell231criteria3);
//			table23criteria3.addCell(cell232criteria3);
//			table23criteria3.addCell(cell233criteria3);
//			table23criteria3.addCell(cell234criteria3);
//			table23criteria3.addCell(cell235criteria3);
//			table23criteria3.addCell(cell236criteria3);
//			table23criteria3.addCell(cell237criteria3);
//			table23criteria3.addCell(cell238criteria3);
//			PdfPCell cell372criteria3 = new PdfPCell(new Paragraph(
//					"3.7.2 Number of functional MoUs with institutions of national, international importance, other institutions, industries, corporate houses etc. during the last five years (only functional MoUs with ongoing activities to be considered)\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse372()
//									: ""),
//					font2));
//			PdfPCell cell3721criteria3 = new PdfPCell(new Paragraph(
//					"3.7.2.1 Number of functional MoUs with institutions of national, international importance, other Institutions, industries, corporate houses etc. year wise during last five years"
//							+ "\r\n\r\n",
//					font2));
//			table231criteria3.addCell(cell372criteria3);
//			table231criteria3.addCell(cell3721criteria3);
//			table231criteria3.addCell(table23criteria3);
//			// document.add(cell372criteria3);
//			// document.add(cell3721criteria3);
//			table231criteria3.setSpacingBefore(20f);
//			table231criteria3.setSpacingAfter(20f);
//			document.add(table231criteria3);
//			// create table 3721 //
//
//			if (criteria3_FieldInfoQnList != null) {
//				Table table3721criteria3 = new Table(criteria3FieldInfoList.size(), 2);
//
//				table3721criteria3.setPadding(10);
//				table3721criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3721().size(); i++) {
//					table3721criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3721().get(i).getInput3721y());
//
//				}
//				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3721().size(); i++) {
//					table3721criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3721().get(i).getInput3721v());
//
//				}
//
//				document.add(table3721criteria3);
//			}
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
//
//
