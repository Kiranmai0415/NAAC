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
//public class UniversityCriteria37Report2 {
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
//			Paragraph paragraph8criteria3 = new Paragraph("3.7	Collaboration\r\n\r\n", font3);
//			paragraph8criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph8criteria3);
//			// create table 22 //
//			
//
//			Paragraph paragraph1criteria31 = new Paragraph(
//					"3.7.1 Number of Collaborative activities per year for research/ faculty exchange/ student exchange/ internship/ on –the-job training/ project work\r\n"
//							 + "Response: \r\n"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse371()
//									: ""));
//			
//			document.add(paragraph1criteria31);
//			Paragraph paragraph1criteria312= new Paragraph(
//					"3.7.1.1 Total number of Collaborative activities with other institutions / research establishment /\r\n"
//					+ "industry for research and academic development of faculty and students year-wise during the last\r\n"
//					+ "five years.");
//			document.add(paragraph1criteria312);
//			if (criteria3Fieldinfo.getYearTable3711() != null) {
//				Table table3711criteria3 = new Table(criteria3Fieldinfo.getYearTable3711().size(), 2);
//
//				table3711criteria3.setPadding(10);
//				table3711criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3711().size(); i++) {
//					table3711criteria3.addCell(criteria3Fieldinfo.getYearTable3711().get(i).getInput3711y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3711().size(); i++) {
//					table3711criteria3.addCell(criteria3Fieldinfo.getYearTable3711().get(i).getInput3711v());
//
//				}
//
//				document.add(table3711criteria3);
//				
//			}
//			
//			
//			PdfPTable table22criteria3 = new PdfPTable(2);
//			PdfPTable table221criteria3 = new PdfPTable(1);
//			table22criteria3.setWidthPercentage(100f);
//			table221criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell221criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell222criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell223criteria3 = new PdfPCell(
//					new Paragraph("Copies of collaboration\r\n"));
//			PdfPCell cell224criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell225criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n"));
//			PdfPCell cell226criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell225criteria31 = new PdfPCell(new Paragraph("Number of Collaborative activities for research, faculty etc\r\n\r\n"));
//			PdfPCell cell226criteria31 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			table22criteria3.addCell(cell221criteria3);
//			table22criteria3.addCell(cell222criteria3);
//			table22criteria3.addCell(cell223criteria3);
//			table22criteria3.addCell(cell224criteria3);
//			table22criteria3.addCell(cell225criteria3);
//			table22criteria3.addCell(cell226criteria3);
//			table22criteria3.addCell(cell225criteria31);
//			table22criteria3.addCell(cell226criteria31);
//		
////			table221criteria3.addCell(cell371criteria3);
////			table221criteria3.addCell(cell3711criteria3);
//			table221criteria3.addCell(table22criteria3);
////			 document.add(cell371criteria3);
////			 document.add(cell3711criteria3);
//			table221criteria3.setSpacingBefore(20f);
//			table221criteria3.setSpacingAfter(20f);
//			document.add(table221criteria3);
//			
//			
//			
//			
//			
//			// create tablle 3711 //
//
////		
////			 * if(criteria3_FieldInfoQn!= null) { Table table3711criteria3 = new
////			 * Table(criteria3_FieldInfoQn.getCriteria3FieldInfoQn().get(0).getYearTable3711
////			 * ().size(), 2);
////			 * 
////			 * table3711criteria3.setPadding(10); table3711criteria3.setWidth(100f);
////			 * 
////			 * for (int i = 0; i <
////			 * criteria3_FieldInfoQn.getCriteria3FieldInfoQn().get(0).getYearTable3711().
////			 * size(); i++) {
////			 * table3711criteria3.addCell(criteria3_FieldInfoQn.getCriteria3FieldInfoQn().
////			 * get(0).getYearTable3711().get(i).getInput3711y());
////			 * 
////			 * } for (int i = 0; i <
////			 * criteria3_FieldInfoQn.getCriteria3FieldInfoQn().get(0).getYearTable3711().
////			 * size(); i++) {
////			 * table3711criteria3.addCell(criteria3_FieldInfoQn.getCriteria3FieldInfoQn().
////			 * get(0).getYearTable3711().get(i).getInput3711v());
////			 * 
////			 * }
////			 * 
////			 * document.add(table3711criteria3); }
////			 */
//
//			// create table 23 //
//			
//			Paragraph paragraph1criteria3122 = new Paragraph(
//					"3.7.2 Number of functional MoUs with institutions of national, international importance, other institutions, industries, corporate houses etc. during the last five years (only functional MoUs with ongoing activities to be considered)\r\n"
//						 + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse372()
//									: ""));
//			document.add(paragraph1criteria3122);
//			Paragraph paragraph1criteria3123 = new Paragraph(
//					"3.7.2.1 Number of functional MoUs with institutions of national, international importance, other Institutions, industries, corporate houses etc. year wise during last five years"
//							+ "\r\n");
//			document.add(paragraph1criteria3123);
//			if (criteria3Fieldinfo.getYearTable3721() != null) {
//				Table table3721criteria3 = new Table(criteria3Fieldinfo.getYearTable3721().size(), 2);
//
//				table3721criteria3.setPadding(10);
//				table3721criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3721().size(); i++) {
//					table3721criteria3.addCell(criteria3Fieldinfo.getYearTable3721().get(i).getInput3721y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3721().size(); i++) {
//					table3721criteria3.addCell(criteria3Fieldinfo.getYearTable3721().get(i).getInput3721v());
//
//				}
//
//				document.add(table3721criteria3);
//				
//			}
//			PdfPTable table23criteria3 = new PdfPTable(2);
//			PdfPTable table231criteria3 = new PdfPTable(1);
//
//			table23criteria3.setWidthPercentage(100f);
//			table231criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell231criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell232criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell233criteria3 = new PdfPCell(
//					new Paragraph("\r\ne-copies of the MoUs with institution/ industry/ corporate house\r\n\r\n"));
//			PdfPCell cell234criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell235criteria3 = new PdfPCell(new Paragraph(
//					"Details of functional MoUs with institutions of national, international importance, other Institutions etc during the last five years\r\n\r\n"));
//			PdfPCell cell236criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(2).getCriteria3FilePath() : ""));
//			PdfPCell cell237criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			PdfPCell cell238criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(3).getCriteria3FilePath() : ""));
//			table23criteria3.addCell(cell231criteria3);
//			table23criteria3.addCell(cell232criteria3);
//			table23criteria3.addCell(cell233criteria3);
//			table23criteria3.addCell(cell234criteria3);
//			table23criteria3.addCell(cell235criteria3);
//			table23criteria3.addCell(cell236criteria3);
//			table23criteria3.addCell(cell237criteria3);
//			table23criteria3.addCell(cell238criteria3);
//			table231criteria3.addCell(table23criteria3);
//			table231criteria3.setSpacingBefore(20f);
//			table231criteria3.setSpacingAfter(20f);
//			document.add(table231criteria3);
//			// create table 3721 //
//			
//			document.close();
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//			
//		}
//				
//			
//		}