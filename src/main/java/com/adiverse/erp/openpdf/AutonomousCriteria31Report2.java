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
//@Component
//public class AutonomousCriteria31Report2 {
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
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
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
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getResponse311()
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
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse312()
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
//
//			if (criteria3Fieldinfo.getYearTable3121() != null) {
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
//			if (criteria3Fieldinfo.getYearTable3131()!= null) {
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
//		
//
//}	
//
//
//
