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
//public class UniversityCriteria36Report2 {
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
//			Paragraph paragraph7criteria3 = new Paragraph("3.6	Extension Activities\r\n\r\n", font3);
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
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell185criteria3 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell186criteria3 = new PdfPCell(new Paragraph(""));
//			table18criteria3.addCell(cell181criteria3);
//			table18criteria3.addCell(cell182criteria3);
//			table18criteria3.addCell(cell183criteria3);
//			table18criteria3.addCell(cell184criteria3);
//			table18criteria3.addCell(cell185criteria3);
//			table18criteria3.addCell(cell186criteria3);
//		
//			
//			
//			
//			
//			
//			
//			Paragraph paragraph1criteria31 = new Paragraph(	"3.6.1 Extension activities are carried out in the neighbourhood community, sensitising students to social issues, for their holistic development, and impact thereof during the last five years\r\n"
//					+"Response:");
//			document.add(paragraph1criteria31);
//			
//			if( criteria3Fieldinfo.getCriteria3FieldInfoQl() !=null)
//			{
//			
//				Paragraph paragraph1criteria32 = new Paragraph (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getResponse361()
//									: "");
//				document.add(paragraph1criteria32);
//			}
//			document.add(table18criteria3);
////			table183criteria3.addCell(cell361criteria3);
////			table183criteria3.addCell(table18criteria3);
////			document.add(cell361criteria3);
////			}
////			table183criteria3.setSpacingBefore(20f);
////			table18criteria3.setSpacingAfter(20f);
////			document.add(table183criteria3);
//
//			// create table 19 //
//			
//			Paragraph paragraph1criteria321 = new Paragraph (
//					"3.6.2 Number of awards and recognition received by the Institution, its teachers and students for extension activities from Government / Government recognised bodies during last five years\r\n"
//						 + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse362()
//									: ""));
//			document.add(paragraph1criteria321);
//			
//			Paragraph paragraph1criteria322 = new Paragraph (
//					"3.6.2.1 Total number of awards and recognition received for extension activities from Government/ Government recognised bodies year-wise during the last five years."
//							);
//			document.add(paragraph1criteria322);
//			if (criteria3Fieldinfo.getYearTable3621() != null) {
//				Table table3621criteria3 = new Table(criteria3Fieldinfo.getYearTable3621().size(), 2);
//
//				table3621criteria3.setPadding(10);
//				table3621criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3621().size(); i++) {
//					table3621criteria3.addCell(criteria3Fieldinfo.getYearTable3621().get(i).getInput3621y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3621().size(); i++) {
//					table3621criteria3.addCell(criteria3Fieldinfo.getYearTable3621().get(i).getInput3621v());
//
//				}
//
//				document.add(table3621criteria3);
//			}
//			PdfPTable table19criteria3 = new PdfPTable(2);
//			PdfPTable table191criteria3 = new PdfPTable(1);
//
//			table19criteria3.setWidthPercentage(100f);
//			table191criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell191criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell192criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell193criteria3 = new PdfPCell(
//					new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell194criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell195criteria3 = new PdfPCell(new Paragraph("\r\ne-copy of the award letters\r\n\r\n"));
//			PdfPCell cell196criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(2).getCriteria3FilePath() : ""));
//			PdfPCell cell197criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell198criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(3).getCriteria3FilePath() : ""));
//			table19criteria3.addCell(cell191criteria3);
//			table19criteria3.addCell(cell192criteria3);
//			table19criteria3.addCell(cell193criteria3);
//			table19criteria3.addCell(cell194criteria3);
//			table19criteria3.addCell(cell195criteria3);
//			table19criteria3.addCell(cell196criteria3);
//			table19criteria3.addCell(cell197criteria3);
//			table19criteria3.addCell(cell198criteria3);
//
//			table191criteria3.addCell(table19criteria3);
//			table191criteria3.setSpacingBefore(20f);
//			table191criteria3.setSpacingAfter(20f);
//			document.add(table191criteria3);
//
//			// create table 3621 //
//
//			
//
//			// create table 20 //
////			PdfPTable table20criteria3 = new PdfPTable(2);
////			PdfPTable table201criteria31 = new PdfPTable(1);
////
////			table20criteria3.setWidthPercentage(100f);
////			table201criteria31.setWidthPercentage(100f);
////
////			PdfPCell cell201criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
////			PdfPCell cell202criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
////			PdfPCell cell203criteria3 = new PdfPCell(new Paragraph("Reports of the event organized\r\n\r\n"));
////			PdfPCell cell204criteria3 = new PdfPCell(
////					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(4).getCriteria3FilePath() : ""));
////			PdfPCell cell205criteria3 = new PdfPCell(new Paragraph(
////					"Any additional information"));
////			PdfPCell cell206criteria3 = new PdfPCell(
////					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(5).getCriteria3FilePath() : ""));
////			
////			PdfPCell cell207criteria3 = new PdfPCell(new Paragraph(
////					"Number of extension and outreach Programmes conducted with industry, community etc for the last five years"));
////			PdfPCell cell208criteria3 = new PdfPCell(
////					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(6).getCriteria3FilePath() : ""));
////			
////			
////			
////			table20criteria3.addCell(cell201criteria3);
////			table20criteria3.addCell(cell202criteria3);
////			table20criteria3.addCell(cell203criteria3);
////			table20criteria3.addCell(cell204criteria3);
////			table20criteria3.addCell(cell205criteria3);
////			table20criteria3.addCell(cell206criteria3);
////			table20criteria3.addCell(cell207criteria3);
////			table20criteria3.addCell(cell208criteria3);
////			document.add(table20criteria3);
//			
//			Paragraph paragraph1criteria3286 = new Paragraph (
//					"3.6.3 Number of extension and outreach programs conducted by the institution through NSS/NCC,\r\n"
//					+ "Government and Government recognised bodies during the last five years\r\n"
//					+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse363()
//									: ""));
//			document.add(paragraph1criteria3286);
//			Paragraph paragraph1criteria3289 = new Paragraph (
//					"3.6.3.1 Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years"
//							+ "\r\n\r\n");
//			document.add(paragraph1criteria3289);
//					
//					if (criteria3Fieldinfo.getYearTable3631() != null) {
//						Table table3631criteria3 = new Table(criteria3Fieldinfo.getYearTable3631().size(), 2);
//
//						table3631criteria3.setPadding(10);
//						table3631criteria3.setWidth(100f);
//
//						for (int i = 0; i < criteria3Fieldinfo.getYearTable3631().size(); i++) {
//							table3631criteria3.addCell(criteria3Fieldinfo.getYearTable3631().get(i).getInput3631y());
//
//						}
//						for (int i = 0; i < criteria3Fieldinfo.getYearTable3631().size(); i++) {
//							table3631criteria3.addCell(criteria3Fieldinfo.getYearTable3631().get(i).getInput3631v());
//
//						}
//
//						document.add(table3631criteria3);
//					}
////			table201criteria31.addCell(table20criteria3);
//			// document.add(cell363criteria3);
//			// document.add(cell3631criteria3);
////			table201criteria31.setSpacingBefore(20f);
////			table201criteria31.setSpacingAfter(20f);
////			document.add(table201criteria31);
//			// create table 3631 //
//
//		
//
//			// create a table 21 //
//			PdfPTable table21criteria3 = new PdfPTable(2);
//			PdfPTable table211criteria3 = new PdfPTable(1);
//			table21criteria3.setWidthPercentage(100f);
//			table211criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell211criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell212criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell213criteria3 = new PdfPCell(new Paragraph("\r\nReports of the event\r\n\r\n"));
//			PdfPCell cell214criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(7).getCriteria3FilePath() : ""));
//			PdfPCell cell215criteria3 = new PdfPCell(new Paragraph(
//					"\r\nInstitutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell216criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(8).getCriteria3FilePath() : ""));
//			
//			PdfPCell cell217criteria3 = new PdfPCell(new Paragraph(
//					"\r\nAverage percentage of students participating in extension activities with Govt or NGO etc\r\n\r\n"));
//			PdfPCell cell218criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(9).getCriteria3FilePath() : ""));
//			
//			table21criteria3.addCell(cell211criteria3);
//			table21criteria3.addCell(cell212criteria3);
//			table21criteria3.addCell(cell213criteria3);
//			table21criteria3.addCell(cell214criteria3);
//			table21criteria3.addCell(cell215criteria3);
//			table21criteria3.addCell(cell216criteria3);
//			table21criteria3.addCell(cell217criteria3);
//			table21criteria3.addCell(cell218criteria3);
//			
//			document.add(table21criteria3);
//			Paragraph paragraph1criteria3221 = new Paragraph (
//					"3.6.4 Average percentage of students participating in extension activities listed at 3.6.3 above during the last five years\r\n"
//						 + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse364()
//									: ""));
//			document.add(paragraph1criteria3221);
//									Paragraph paragraph1criteria3232 = new Paragraph (
//					"3.6.4.1 Total number of students participating in extension activities listed at 3.6.3 above year-wise during the last five years."
//							+ "\r\n\r\n");
//									document.add(paragraph1criteria3232);
//			if (criteria3Fieldinfo.getYearTable3641() != null) {
//				Table table3641criteria3 = new Table(criteria3Fieldinfo.getYearTable3641().size(), 2);
//
//				table3641criteria3.setPadding(10);
//				table3641criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3641().size(); i++) {
//					table3641criteria3.addCell(criteria3Fieldinfo.getYearTable3641().get(i).getInput3641y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3641().size(); i++) {
//					table3641criteria3.addCell(criteria3Fieldinfo.getYearTable3641().get(i).getInput3641v());
//
//				}
//
//				document.add(table3641criteria3);
//			}
//			table211criteria3.addCell(table21criteria3);
//			// document.add(cell364criteria3);
//			// document.add(cell3641criteria3);
//			table211criteria3.setSpacingBefore(20f);
//			table211criteria3.setSpacingAfter(20f);
//			document.add(table211criteria3);
//			// create table 3641 //
//
//		
//		
//			//3642
//			
//			
////			if (criteria3Fieldinfo.getYearTable3641() != null) {
////				Table table36412criteria3 = new Table(criteria3Fieldinfo.getYearTable36412().size(), 2);
////
////				table36412criteria3.setPadding(10);
////				table36412criteria3.setWidth(100f);
////
////				for (int i = 0; i < criteria3Fieldinfo.getYearTable36412().size(); i++) {
////					table36412criteria3.addCell(criteria3Fieldinfo.getYearTable36412().get(i).getInput36412y());
////
////				}
////				for (int i = 0; i < criteria3Fieldinfo.getYearTable36412().size(); i++) {
////					table36412criteria3.addCell(criteria3Fieldinfo.getYearTable36412().get(i).getInput36412v());
////
////				}
////
////				document.add(table36412criteria3);
////			}
////		
//			
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