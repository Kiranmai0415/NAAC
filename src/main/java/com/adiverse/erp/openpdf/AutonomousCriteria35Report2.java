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
//public class AutonomousCriteria35Report2 {
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
//			Paragraph paragraph6criteria3 = new Paragraph("3.5	Consultancy\r\n\r\n\r\n", font2);
//			paragraph6criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph6criteria3);
//			// create table 16 //
//			PdfPTable table16criteria3 = new PdfPTable(2);
//			PdfPTable table161criteria31 = new PdfPTable(1);
//
//			table16criteria3.setWidthPercentage(100f);
//			table161criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell161criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell162criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
//			PdfPCell cell163criteria3 = new PdfPCell(new Paragraph("List of consultants and revenue generated by them\r\n\r\n\r\n"));
//			PdfPCell cell164criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell165criteria3 = new PdfPCell(new Paragraph(
//					"Audited statements of accounts indicating the revenue generated through consultancy and corporate training\r\n\r\n\r\n"));
//			PdfPCell cell166criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell167criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell168criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
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
//							+ "\r\n\r\n\r\n" + "Response:"));
//			table161criteria31.addCell(cell351criteria3);
//			if(criteria3Fieldinfo.getCriteria3FieldInfoQn() !=null)
//			{
//			PdfPCell cell351criteria31= new PdfPCell(new Paragraph(criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse351()
//									: ""));
//			table161criteria31.addCell(cell351criteria31);
//			}
//			PdfPCell cell3511criteria3 = new PdfPCell(new Paragraph(
//					"3.5.1.1 Total amount generated from consultancy and corporate training year-wise during the last five years (INR in lakhs).\r\n"
//							+ "\r\n\r\n",
//					font2));
//
//			
//			table161criteria31.addCell(cell3511criteria3);
//			table161criteria31.addCell(table16criteria3);
//
//			 document.add(cell351criteria3);
//			document.add(cell3511criteria3);
//			table16criteria3.setSpacingBefore(20f);
//			table16criteria3.setSpacingAfter(20f);
//			document.add(table161criteria31);
//			// create table 3511 ///
//
//			if (criteria3Fieldinfo.getYearTable3511() != null) {
//				Table table3511criteria3 = new Table(criteria3Fieldinfo.getYearTable3511().size(), 2);
//
//				table3511criteria3.setPadding(10);
//				table3511criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3511().size(); i++) {
//					table3511criteria3.addCell(criteria3Fieldinfo.getYearTable3511().get(i).getInput3511y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3511().size(); i++) {
//					table3511criteria3.addCell(criteria3Fieldinfo.getYearTable3511().get(i).getInput3511v());
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
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell175criteria3 = new PdfPCell(
//					new Paragraph("List of facilities and staff available for undertaking consultancy\rn\r\n\r\n"));
//			PdfPCell cell176criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell177criteria3 = new PdfPCell(new Paragraph(
//					"Audited statements of accounts indicating the expenditure incurred on developing facilities and training teachers and staff for undertaking consultancy"));
//			PdfPCell cell178criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell179criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\r\n"));
//			PdfPCell cell180criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
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
//							+ "\r\n\r\n\r\n" + "Response:",font2));
//			if(criteria3Fieldinfo.getCriteria3FieldInfoQn() !=null)
//			{
//				PdfPCell cell3501criteria31= new PdfPCell(new Paragraph(criteria3Fieldinfo != null
//										? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse352()
//										: ""));
//				table173criteria31.addCell(cell3501criteria31);
//				}
//			
//			
//			
//			PdfPCell cell3521criteria3 = new PdfPCell(new Paragraph(
//					"3.5.2.1 Total amount spent on developing facilities, training teachers and staff for undertaking consultancy during the last five years (INR in Lakhs)\r\n"
//							+ "\r\n\r\n",
//					font2));
//			table173criteria31.addCell(cell352criteria3);
//			table173criteria31.addCell(cell3521criteria3);
//			table173criteria31.addCell(table17criteria3);
//			 document.add(cell352criteria3);
//			 document.add(cell3521criteria3);
//			table173criteria31.setSpacingBefore(20f);
//			table173criteria31.setSpacingAfter(20f);
//
//			document.add(table173criteria31);
//			// create table 3521//
//
//			if (criteria3Fieldinfo.getYearTable3521() != null) {
//				Table table3521criteria3 = new Table(criteria3Fieldinfo.getYearTable3521().size(), 2);
//
//				table3521criteria3.setPadding(10);
//				table3521criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3521().size(); i++) {
//					table3521criteria3.addCell(criteria3Fieldinfo.getYearTable3521().get(i).getInput3521y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3521().size(); i++) {
//					table3521criteria3.addCell(criteria3Fieldinfo.getYearTable3521().get(i).getInput3521v());
//
//				}
//
//				document.add(table3521criteria3);
//			}
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
