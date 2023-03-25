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
//public class AffilatedCriteria33Report2 
//{
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
//	@Autowired
//	Criteria3Service service3;
//	
//	List<Criteria3_FieldInfo> criteria3FieldInfoList = null;
//	// Criteria3_FieldInfo criteria3_FieldInfoQn = null;
//	Criteria3_FieldInfo criteria3_FieldInfoQl = null;
//	List<Criteria3_FileUpload> criteria3file = null;
//	List<Criteria3_FieldInfoQn> criteria3_FieldInfoQnList=null;
//	List<Criteria3_FieldInfoQl> criteria3_FieldInfoQlList=null;
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
//           
//             
//             if (root != null) {
// 				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
// 				String strDate = formatter.format(date);
// 				reportPath = "AffilatedCriteria3Report-" + strDate + ".pdf";
// 				file = root.resolve(reportPath);
// 			}
// 			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//			Document document = new Document(PageSize.A4);
//			// PdfWriter.getInstance(document, response.getOutputStream());
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>"); 
//			
//			Font font1criteria3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font1criteria3.setSize(14);
//		
//
//			////// 3.3//
//			Paragraph paragraph4criteria3 = new Paragraph("3.3	Research Publications and Awards\r\n\r\n\r\n", font1criteria3);
//			paragraph4criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph4criteria3);
//			
//			
//			
//			Paragraph paragraph41criteria3 = new Paragraph(
//					"3.3.1: Number of research papers per teachers in the Journals notified on UGC website during the last five years"+ "Response:");
//			document.add(paragraph41criteria3);
//			
//			if( criteria3Fieldinfo.getCriteria3FieldInfoQl() !=null)
//			{
//			Paragraph paragraph42criteria3 = new Paragraph(criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getResponse331()
//									: "");
//			document.add(paragraph42criteria3);
//			}
//			
//			
//			Paragraph paragraph43criteria3 = new Paragraph("	Paragraph paragraph41criteria3 = new Paragraph(");
//			document.add(paragraph43criteria3);
//			
//			if (criteria3Fieldinfo.getAffiliated_YearTable3311() != null) {
//				Table table3321criteria3 = new Table(criteria3Fieldinfo.getAffiliated_YearTable3311().size(), 2);
//
//				table3321criteria3.setPadding(10);
//				table3321criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getAffiliated_YearTable3311().size(); i++) {
//					table3321criteria3.addCell(criteria3Fieldinfo.getAffiliated_YearTable3311().get(i).getInput3311y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getAffiliated_YearTable3311().size(); i++) {
//					table3321criteria3.addCell(criteria3Fieldinfo.getAffiliated_YearTable3311().get(i).getInput3311v());
//
//				}
//
//				document.add(table3321criteria3);
//			}
//
//			PdfPTable table9criteria3 = new PdfPTable(2);
//			PdfPTable table91criteria31 = new PdfPTable(1);
//	        table9criteria3.setWidthPercentage(100f);
//			table91criteria31.setWidthPercentage(100f);
//			
//			PdfPCell cell91criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell92criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell93criteria3 = new PdfPCell(new Paragraph("List of research papers by title, author, department,\r\n"
//					+ "name and year of publicatio\r\n\r\n\r\n"));
//			PdfPCell cell94criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(23).getCriteria3FilePath() : ""));
//			PdfPCell cell95criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell96criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(24).getCriteria3FilePath() :""));
//			table9criteria3.addCell(cell91criteria3);
//			table9criteria3.addCell(cell92criteria3);
//			table9criteria3.addCell(cell95criteria3);
//			table9criteria3.addCell(cell96criteria3);
//			table9criteria3.addCell(cell93criteria3);
//			table9criteria3.addCell(cell94criteria3);
//			document.add(table9criteria3);
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
//			// create table 8 ///
////			PdfPTable table8criteria3 = new PdfPTable(2);
////			PdfPTable table81criteria31 = new PdfPTable(1);
////
////			table8criteria3.setWidthPercentage(100f);
////			table81criteria31.setWidthPercentage(100f);
////			PdfPCell cell81criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font2));
////			PdfPCell cell82criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
////			PdfPCell cell83criteria3 = new PdfPCell(new Paragraph("List of PhD scholars and their details like name of\r\n"
////					+ "the guide , title of thesis, year of award etc\r\n\r\n"));
////			PdfPCell cell84criteria3 = new PdfPCell(
////					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(20).getCriteria3FilePath() : ""));
////			PdfPCell cell85criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
////			PdfPCell cell86criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(21).getCriteria3FilePath() :""));
////			PdfPCell cell87criteria3 = new PdfPCell(new Paragraph("URL to the research page on HEI website \r\n\r\n"));
////			PdfPCell cell88criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(22).getCriteria3FilePath() :""));
////			
////			
////			
////			table8criteria3.addCell(cell81criteria3);
////			
////			table8criteria3.addCell(cell82criteria3);
////			table8criteria3.addCell(cell83criteria3);
////			table8criteria3.addCell(cell84criteria3);
////			table8criteria3.addCell(cell85criteria3);
////			table8criteria3.addCell(cell86criteria3);
////			table8criteria3.addCell(cell87criteria3);
////			table8criteria3.addCell(cell88criteria3);
////			
////			PdfPCell cell331criteria3 = new PdfPCell(new Paragraph(
////					"3.3.1 Number of Ph.Ds registered per eligible teacher during the last five year\r\n"
////							+ "\r\n\r\n" + "Response:"
////							+ (criteria3Fieldinfo != null
////									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse313()
////									: ""),
////					font2));
////			PdfPCell cell3310criteria3 = new PdfPCell(new Paragraph(
////					 (criteria3Fieldinfo != null
////									? criteria3_FieldInfoQnList.get(0).getInput3311t1(): ""),font2));
////			
////			
////			PdfPCell cell3311criteria3 = new PdfPCell(new Paragraph(
////					"3.3.1.1 How many Ph.Ds registered per eligible teacher within last five year\r\n"
////							+ "\r\n\r\n" + "Response:"
////							+ (criteria3_FieldInfoQnList != null
////									? criteria3_FieldInfoQnList.get(0).getResponse313()
////									: ""),
////					font2));
////			PdfPCell cell3312criteria3 = new PdfPCell(new Paragraph(
////					"3.3.1.2 Number of teachers recognized as guides during the last five year\r\n"
////							+ "\r\n\r\n" + "Response:"
////							+ (criteria3_FieldInfoQnList != null
////									? criteria3_FieldInfoQnList.get(0).getResponse313()
////									: ""),
////					font2));
////			
////			
////			table81criteria31.addCell(cell331criteria3);
////			table81criteria31.addCell(cell3310criteria3);
////			table81criteria31.addCell(cell3311criteria3);
////			table81criteria31.addCell(cell3312criteria3);
////			table81criteria31.addCell(table8criteria3);
//			//Year table 3311
////			if (criteria3_FieldInfoQnList != null) {
////				Table table3311criteria3 = new Table(criteria3FieldInfoList.get(0).getAffiliated_YearTable3311().size(), 2);
//	//
////				table3311criteria3.setPadding(10);
////				table3311criteria3.setWidth(100f);
//	//
////				for (int i = 0; i < criteria3FieldInfoList.get(0).getAffiliated_YearTable3311().size(); i++) {
////					table3311criteria3.addCell(criteria3FieldInfoList.get(0).getAffiliated_YearTable3311().get(i).getInput3311y());
//	//
////				}
////				for (int i = 0; i < criteria3FieldInfoList.get(0).getAffiliated_YearTable3311().size(); i++) {
////					table3311criteria3.addCell(criteria3FieldInfoList.get(0).getAffiliated_YearTable3311().get(i).getInput3311v());
//	//
////				}
//	//
////				document.add(table3311criteria3);
////			}
//
//			
//
//			// document.add(cell331criteria3);
//
////			table81criteria31.setSpacingBefore(20f);
////			table81criteria31.setSpacingAfter(20f);
////
////			document.add(table81criteria31);
////			/// create table 9 ////
//			
//			Paragraph paragraph411criteria3 = new Paragraph(
//					"3.3.2  Number of research papers per teachers in the Journals notified on UGC website during the last five years"+ "Response:");
//			document.add(paragraph411criteria3);
//			
//			if( criteria3Fieldinfo.getCriteria3FieldInfoQl() !=null)
//			{
//			Paragraph paragraph421criteria3 = new Paragraph(criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse332()
//									: "");
//			document.add(paragraph421criteria3);
//			
//			}
//			
//			Paragraph paragraph431criteria3 = new Paragraph("	Paragraph paragraph41criteria3 = new Paragraph(");
//			document.add(paragraph431criteria3);
//			
//			if (criteria3Fieldinfo.getYearTable3221() != null) {
//				Table table3321criteria3 = new Table(criteria3Fieldinfo.getYearTable3221().size(), 2);
//
//				table3321criteria3.setPadding(10);
//				table3321criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3321().size(); i++) {
//					table3321criteria3.addCell(criteria3Fieldinfo.getYearTable3321().get(i).getInput3321y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3321().size(); i++) {
//					table3321criteria3.addCell(criteria3Fieldinfo.getYearTable3321().get(i).getInput3321v());
//
//				}
//
//				document.add(table3321criteria3);
//			}
//
//			PdfPTable table91criteria3 = new PdfPTable(2);
//			PdfPTable table911criteria31 = new PdfPTable(1);
//	        table91criteria3.setWidthPercentage(100f);
//			table911criteria31.setWidthPercentage(100f);
//			
//			PdfPCell cell911criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell921criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell931criteria3 = new PdfPCell(new Paragraph("List of research papers by title, author, department,\r\n"
//					+ "name and year of publicatio\r\n\r\n\r\n"));
//			PdfPCell cell941criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(23).getCriteria3FilePath() : ""));
//			PdfPCell cell951criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell961criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(24).getCriteria3FilePath() :""));
//			table91criteria3.addCell(cell911criteria3);
//			table91criteria3.addCell(cell921criteria3);
//			table91criteria3.addCell(cell951criteria3);
//			table91criteria3.addCell(cell961criteria3);
//			table91criteria3.addCell(cell931criteria3);
//			table91criteria3.addCell(cell941criteria3);
//			document.add(table91criteria3);
//			
//			
//			
////			
////			PdfPCell cell3320criteria3 = new PdfPCell(new Paragraph(
////					 (criteria3_FieldInfoQnList != null
////									? criteria3_FieldInfoQnList.get(0).getInput332t1()
////									: ""),
////					font2));
////			
////			
////			PdfPCell cell3321criteria3 = new PdfPCell(new Paragraph(
////					"3.3.2.1 Number of research papers in the Journals notified on UGC website during the last five\r\n"
////					+ "years.\r\n"
////					+ "\r\n"
////							+ "\r\n\r\n",
////					font2));
////			table91criteria31.addCell(cell332criteria3);
////			table91criteria31.addCell(cell3320criteria3);
////			table91criteria31.addCell(cell3321criteria3);
////			table91criteria31.addCell(table9criteria3);
////
////			// document.add(cell332criteria3);
////			// document.add(cell3321criteria3);
////			table91criteria31.setSpacingBefore(20f);
////			table91criteria31.setSpacingAfter(20f);
////			document.add(table91criteria31);
//			
//			
//			// create a table 3321 
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
