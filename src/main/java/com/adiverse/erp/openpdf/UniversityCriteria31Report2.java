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
//public class UniversityCriteria31Report2 {
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
//			Paragraph paragraph2criteria3 = new Paragraph("3.1	Promotion of Research and Facilities\r\n\r\n", font2);
//			paragraph1criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph2criteria3);
//			// create table1
//			PdfPTable table1criteria3 = new PdfPTable(2);
//			PdfPTable table13criteria31 = new PdfPTable(1);
//
//			table1criteria3.setWidthPercentage(100f);
//			table13criteria31.setWidthPercentage(100f);
//			
//			table1criteria3.setSpacingAfter(20f);
//			table13criteria31.setSpacingBefore(20f);
//
//			PdfPCell cell1criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			PdfPCell cell2criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell3criteria3 = new PdfPCell(new Paragraph(
//					"Minutes of the Governing Council/ Syndicate/Board of Management related to research promotion policy adoption\r\n\r\n"));
//			PdfPCell cell4criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell5criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			PdfPCell cell6criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell7criteria3 = new PdfPCell(
//					new Paragraph("URL of Policy document on promotion of research uploaded on website\r\n\r\n"));
//			PdfPCell cell8criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			table1criteria3.addCell(cell1criteria3);
//			table1criteria3.addCell(cell2criteria3);
//			table1criteria3.addCell(cell5criteria3);
//			table1criteria3.addCell(cell6criteria3);
//			table1criteria3.addCell(cell3criteria3);
//			table1criteria3.addCell(cell4criteria3);
//			
//			table1criteria3.addCell(cell7criteria3);
//			table1criteria3.addCell(cell8criteria3);
//
//			PdfPCell cell311criteria3 = new PdfPCell(new Paragraph(
//					"3.1.1	The institution's Research facilities are frequently updated and there is a well defined policy for promotion of research which is uploaded on the institutional website and implemented.\r\n\r\n"
//							+ "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getResponse311()
//									: ""),
//					font3));
//			table13criteria31.addCell(cell311criteria3);
//			table13criteria31.addCell(table1criteria3);
//
//			table1criteria3.setSpacingBefore(20f);
//			table1criteria3.setSpacingAfter(20f);
//			document.add(table13criteria31);
//
//			// create table 2////
//			
//			
//			Paragraph paragraph2criteria311 = new Paragraph(
//					"3.1.2 The institution provides seed money to its teachers for research (average per year, INR in Lakhs)\r\n"
//							 + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse312()
//									: ""));
//			document.add(paragraph2criteria311);
//			Paragraph paragraph2criteria312 = new Paragraph(
//					"3.1.2.1 The amount of seed money provided by institution to its faculty year-wise during the last five years (INR in lakhs)");
//			document.add(paragraph2criteria312);
//
//			
//			// create table 3121///
//			//System.out.println("criteria3FieldInfoQnList.get(0) == >" + criteria3_FieldInfoQnList);
//
//			if (criteria3Fieldinfo.getYearTable3121().size() >0) {
//				Table table3121criteria3 = new Table(criteria3Fieldinfo.getYearTable3121().size());
//
//				table3121criteria3.setPadding(10);
//				table3121criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3121().size(); i++) {
//					table3121criteria3.addCell(criteria3Fieldinfo.getYearTable3121().get(i).getInput3121y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3121().size(); i++) {
//					table3121criteria3.addCell(criteria3Fieldinfo.getYearTable3121().get(i).getInput3121v());
//
//				}
//
//				document.add(table3121criteria3);
//			}
//
//			
//			
//			PdfPTable table2criteria3 = new PdfPTable(2);
//			PdfPTable table23criteria31 = new PdfPTable(1);
//			table2criteria3.setWidthPercentage(100f);
//			table23criteria31.setWidthPercentage(100f);
//			PdfPCell cell21criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			PdfPCell cell22criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell23criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n"));
//			PdfPCell cell24criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(2).getCriteria3FilePath() : ""));
//			PdfPCell cell25criteria3 = new PdfPCell(
//					new Paragraph("Any additional information"));
//			PdfPCell cell26criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(3).getCriteria3FilePath() : ""));
//			PdfPCell cell27criteria3 = new PdfPCell(new Paragraph(
//					"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n"));
//			PdfPCell cell28criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(4).getCriteria3FilePath() : ""));
//			
//			PdfPCell cell271criteria3 = new PdfPCell(new Paragraph(
//					"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n"));
//			PdfPCell cell281criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(5).getCriteria3FilePath() : ""));
//			
//			table2criteria3.addCell(cell21criteria3);
//			table2criteria3.addCell(cell22criteria3);
//			table2criteria3.addCell(cell23criteria3);
//			table2criteria3.addCell(cell24criteria3);
//			table2criteria3.addCell(cell25criteria3);
//			table2criteria3.addCell(cell26criteria3);
//			table2criteria3.addCell(cell27criteria3);
//			table2criteria3.addCell(cell28criteria3);
//			table2criteria3.addCell(cell271criteria3);
//			table2criteria3.addCell(cell281criteria3);
//			
//			
//			table23criteria31.setSpacingBefore(20f);
//			table23criteria31.setSpacingAfter(20f);
//
//			document.add(table2criteria3);
//			
//			
//			
//			
//			
//			
//			
//			// create table 3 //////
//			
//			PdfPCell cell313criteria3 = new PdfPCell(new Paragraph(
//					"3.1.3 Percentage of teachers awarded national / international fellowship for advanced studies/research during the last five years\r\n"
//							+ "\r\n" + "Response"
//							+ (criteria3Fieldinfo != null
//							? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse313()
//							: ""),
//							font3));
//			document.add(cell313criteria3);
//			PdfPCell cell3131criteria3 = new PdfPCell(new Paragraph(
//					"3.1.3.1 The number of teachers awarded national / international fellowship for advanced studies / research year wise during last five years"
//							+ "\r\n\r\n",
//							font3));
//			
//document.add(cell3131criteria3);
//			if (criteria3Fieldinfo.getYearTable3131().size() > 0) {
//				Table table3131criteria3 = new Table(criteria3Fieldinfo.getYearTable3131().size(), 2);
//
//				table3131criteria3.setPadding(10);
//				table3131criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3131().size(); i++) {
//					table3131criteria3.addCell(criteria3Fieldinfo.getYearTable3131().get(i).getInput3131y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3131().size(); i++) {
//					table3131criteria3.addCell(criteria3Fieldinfo.getYearTable3131().get(i).getInput3131v());
//
//				}
//
//				document.add(table3131criteria3);
//			}
//			
//			Paragraph paragraph2criteria313 = new Paragraph("Total number of full time teachers during the last five years");
//			document.add(paragraph2criteria313);
//			
//			Paragraph paragraph2criteria314= new Paragraph((criteria3Fieldinfo != null
//					? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3131t11()
//					: ""));
//			
//			
//			document.add(paragraph2criteria314);
//			
//			PdfPTable table3criteria3 = new PdfPTable(2);
//			PdfPTable table33criteria31 = new PdfPTable(1);
//
//			table3criteria3.setWidthPercentage(100f);
//			table33criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell31criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			PdfPCell cell32criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell33criteria3 = new PdfPCell(
//					new Paragraph("Any additional information\r\n   "));
//			PdfPCell cell34criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(6).getCriteria3FilePath() : ""));
//			PdfPCell cell35criteria3 = new PdfPCell(new Paragraph("e-copies of the award letters of the teachers"));
//			PdfPCell cell36criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(7).getCriteria3FilePath() : ""));
//			PdfPCell cell33criteria32= new PdfPCell(
//					new Paragraph("List of teachers and their international fellowship details (Data Template)\r\n   "));
//			PdfPCell cell34criteria32 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(6).getCriteria3FilePath() : ""));
//			table3criteria3.addCell(cell31criteria3);
//			table3criteria3.addCell(cell32criteria3);
//			table3criteria3.addCell(cell33criteria3);
//			table3criteria3.addCell(cell34criteria3);
//			table3criteria3.addCell(cell35criteria3);
//			table3criteria3.addCell(cell36criteria3);
//			table3criteria3.addCell(cell33criteria32);
//			table3criteria3.addCell(cell34criteria32);
//			
//table33criteria31.addCell(table3criteria3);
//			
//			table33criteria31.setSpacingBefore(20f);
//			table33criteria31.setSpacingAfter(20f);
//			document.add(table33criteria31);
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			PdfPTable table314criteria3 = new PdfPTable(2);
//			PdfPTable table3314criteria31 = new PdfPTable(1);
//
//			table314criteria3.setWidthPercentage(100f);
//			table3314criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell314criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			PdfPCell cell324criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell334criteria3 = new PdfPCell(
//					new Paragraph("Institutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell344criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(8).getCriteria3FilePath() : ""));
//			PdfPCell cell354criteria3 = new PdfPCell(new Paragraph("Any additional information"));
//			PdfPCell cell364criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(9).getCriteria3FilePath() : ""));
//			table314criteria3.addCell(cell314criteria3);
//			table314criteria3.addCell(cell324criteria3);
//			table314criteria3.addCell(cell334criteria3);
//			table314criteria3.addCell(cell344criteria3);
//			table314criteria3.addCell(cell354criteria3);
//			table314criteria3.addCell(cell364criteria3);
//		
//			PdfPCell cell3134criteria3 = new PdfPCell(new Paragraph(
//					"3.1.4 Number of JRFs, SRFs, Post Doctoral Fellows, Research Associates and other research fellows\r\n"
//					+ "enrolled in the institution during the last five years.\r\n"
//					+ "Response:"
//							+ (criteria3Fieldinfo != null
//							? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse314()
//							: ""),
//					font3));
//			PdfPCell cell31314criteria3 = new PdfPCell(new Paragraph(
//					"3.1.4.1 The Number of JRFs, SRFs, Post Doctoral Fellows, Research Associates and other research\r\n\r\n"
//					+ "fellows enrolled in the institution year-wise during the last five years."
//							+ "\r\n\r\n",
//					font3));
//			table3314criteria31.addCell(cell3134criteria3);
//			
//			table3314criteria31.addCell(cell31314criteria3);
//			
//			table3314criteria31.addCell(table314criteria3);
//			// document.add(cell313criteria3);
//			// document.add(cell3131criteria3);
//			table3314criteria31.setSpacingBefore(20f);
//			table3314criteria31.setSpacingAfter(20f);
//			document.add(table3314criteria31);
//			
//			PdfPTable table101criteria31 = new PdfPTable(1);
//			table101criteria31.setWidthPercentage(100f);
//			
//			PdfPCell cell341criteria3 = new PdfPCell(new Paragraph(
//					" 3.4.1 The Institution ensures implementation of its stated Code of Ethics for research through the following: 1. Inclusion of research ethics in the research methodology course work 2. Presence ofEthics committee 3. Plagiarism check through software 4. Research Advisory Committee\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getResponse341()
//									: ""),
//					font3));
//			table101criteria31.addCell(cell341criteria3);
//		
//		    document.add(table101criteria31);
//		    
//
//			if (criteria3Fieldinfo.getUniversityYearTable3141() !=null ) {
//				Table table3141criteria3 = new Table(criteria3Fieldinfo.getUniversityYearTable3141().size(), 2);
//
//				table3141criteria3.setPadding(10);
//				table3141criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3141().size(); i++) {
//					table3141criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3141().get(i).getInput3141y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3141().size(); i++) {
//					table3141criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3141().get(i).getInput3141v());
//
//				}
//
//				document.add(table3141criteria3);
//			}
//			
//			
//			
//			PdfPTable table315criteria3 = new PdfPTable(2);
//			PdfPTable table3151criteria31 = new PdfPTable(1);
//
//			table315criteria3.setWidthPercentage(100f);
//			table3151criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell315criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			PdfPCell cell325criteria3 = new PdfPCell(new Paragraph("Document\r\n\r", font3));
//			PdfPCell cell335criteria3 = new PdfPCell(
//					new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell345criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(10).getCriteria3FilePath() : ""));
//			PdfPCell cell355criteria3 = new PdfPCell(new Paragraph("Any additional information"));
//			PdfPCell cell365criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(11).getCriteria3FilePath() : ""));
//			table315criteria3.addCell(cell315criteria3);
//			table315criteria3.addCell(cell325criteria3);
//			table315criteria3.addCell(cell335criteria3);
//			table315criteria3.addCell(cell345criteria3);
//			table315criteria3.addCell(cell355criteria3);
//			table315criteria3.addCell(cell365criteria3);
//			PdfPCell cell31345criteria3 = new PdfPCell(new Paragraph(
//					"3.1.5 Institution has the following facilities to support research\r\n"
//					+ "1.Central Instrumentation Centre \r\n"
//					+ "2.Animal House/Green House \r\n"
//					+ "3. Museum\r\n"
//					+ "4.Media laboratory/Studios\r\n"
//					+ "5.Business Lab\r\n"
//					+ "6.Research/Statistical Databases\r\n"
//					+ "7.Mootcourt\r\n"
//					+ "8.Theatre\r\n"
//					+ "9.Art Gallery\r\n"
//					+ "10.Any other facility to support research\r\n"
//					+ "Response:"
//							+ (criteria3_FieldInfoQnList != null
//							? criteria3_FieldInfoQnList.get(0).getResponse315()
//							: ""),
//					font3));
//			
//			table3151criteria31.addCell(cell31345criteria3);
//			
//		
//			table3151criteria31.addCell(table315criteria3);
//		
//			table3151criteria31.setSpacingBefore(20f);
//			table3151criteria31.setSpacingAfter(20f);
//			document.add(table315criteria3);
//			
//			PdfPTable table316criteria3 = new PdfPTable(2);
//			PdfPTable table3161criteria31 = new PdfPTable(1);
//
//			table316criteria3.setWidthPercentage(100f);
//			table3161criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell3156criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			PdfPCell cell3256criteria3 = new PdfPCell(new Paragraph("Document\r\n\r", font3));
//			PdfPCell cell3356criteria3 = new PdfPCell(
//					new Paragraph("Institutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell3456criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(12).getCriteria3FilePath() : ""));
//			PdfPCell cell3556criteria3 = new PdfPCell(new Paragraph("Any additional information"));
//			PdfPCell cell3656criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(13).getCriteria3FilePath() : ""));
//			table316criteria3.addCell(cell3156criteria3);
//			table316criteria3.addCell(cell3256criteria3);
//			table316criteria3.addCell(cell3356criteria3);
//			table316criteria3.addCell(cell3456criteria3);
//			table316criteria3.addCell(cell3556criteria3);
//			table316criteria3.addCell(cell3656criteria3);
//			PdfPCell cell313456criteria3 = new PdfPCell(new Paragraph(
//					"3.1.6 Percentage of departments with UGC-SAP, CAS, DST-FIST, DBT, ICSSR and other\r\n"
//					+ "recognitions by national and international agencies (Data for the latest completed academic year)\r\n"
//					+ "Response: "
//							+ (criteria3Fieldinfo != null
//							? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse316()
//							: ""),
//					font3));
//			document.add(cell313456criteria3);
//			
//			PdfPCell cell3134566criteria3 = new PdfPCell(new Paragraph(
//					"3.1.6.1 The Number of departments with UGC-SAP, CAS, DST-FIST , DBT, ICSSR and other\r\n"
//					+ "similar recognitions by national and international agencies.\r\n"
//					+ "Response: "
//							+ (criteria3Fieldinfo != null
//							? criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getInput361t1()
//							: ""),
//					font3));
//			document.add(cell3134566criteria3);
//			
//			PdfPCell cell3134566criteria31 = new PdfPCell(new Paragraph(
//					"3.1.6.1: Total number of departments offering academic programmes"
//					+ "Response: "
//							+ (criteria3Fieldinfo != null
//							? criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getInput361t2()
//							: ""),
//					font3));
//			
//			table3161criteria31.addCell(cell313456criteria3);
//			table3161criteria31.addCell(cell3134566criteria3);
//			table3161criteria31.addCell(cell3134566criteria31);
//		
//			table3161criteria31.addCell(table316criteria3);
//			// document.add(cell313criteria3);
//			// document.add(cell3131criteria3);
//			table3161criteria31.setSpacingBefore(20f);
//			table3161criteria31.setSpacingAfter(20f);
//			document.add(table3161criteria31);
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