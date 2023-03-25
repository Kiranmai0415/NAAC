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
//public class UniversityCriteria32Report2 {
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
//			
//			Paragraph paragraph3criteria3 = new Paragraph("3.2	Resource Mobilization for Research\r\n\r\n", font3);
//			paragraph3criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph3criteria3);
//
//			/// create table 4//
//			Paragraph paragraph3criteria311 = new Paragraph("3.2.1: Extramural funding for Research (Grants sponsored by non-government sources such as industry, corporate houses, international bodies for research projects), endowments, Chairs in the University during the last five years (INR in Lakhs).\r\n");
//			document.add(paragraph3criteria311);
//			PdfPCell cell321criteria3 = new PdfPCell(new Paragraph(""
//					+ "Response"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse321()
//									: ""),
//					font3));
//			document.add(cell321criteria3);
//			PdfPCell cell3211criteria3 = new PdfPCell(new Paragraph(
//					"3.2.1.1 Total Grants from Government and non-governmental agencies for research projects , endowments, Chairs in the institution during the last five years (INR in Lakhs)"
//							+ "\r\n\r\n"));
//			document.add(cell3211criteria3);
//
//			if (criteria3Fieldinfo.getYearTable3221() !=null) 
//			{
//				Table table3211criteria3 = new Table(criteria3Fieldinfo.getYearTable3221().size(), 2);
//
//				table3211criteria3.setPadding(10);
//				table3211criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3221().size(); i++) {
//					table3211criteria3.addCell(criteria3Fieldinfo.getYearTable3221().get(i).getInput3221y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3221().size(); i++) {
//					table3211criteria3.addCell(criteria3Fieldinfo.getYearTable3221().get(i).getInput3221v());
//
//				}
//
//				document.add(table3211criteria3);
//			}
//			PdfPTable table4criteria3 = new PdfPTable(2);
//			PdfPTable table43criteria31 = new PdfPTable(1);
//
//			table4criteria3.setWidthPercentage(100f);
//			table43criteria31.setWidthPercentage(100f);
//			
//			PdfPCell cell41criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			PdfPCell cell42criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell43criteria3 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell44criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(14).getCriteria3FilePath() : ""));
//			PdfPCell cell45criteria3 = new PdfPCell(new Paragraph(
//					"e-copies of the grant award letters for research projects sponsored by government and non- government\r\n\r\n"));
//			PdfPCell cell46criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(8).getCriteria3FilePath() : ""));
//			PdfPCell cell47criteria3 = new PdfPCell(new Paragraph("Provide the List of project and grant details (Data Template as of 3.1.6)\r\n"));
//			PdfPCell cell48criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(9).getCriteria3FilePath() : ""));
//			
////			table43criteria31.addCell(cell321criteria3);
////			table43criteria31.addCell(cell3211criteria3);
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
//
//			// create table 5 //////
//			
//			PdfPCell cell322criteria3 = new PdfPCell(
//					new Paragraph("3.2.2 Grants for research projects sponsored by the government agencies during the last five years\r\n"
//							+ "(INR in Lakhs).\r\n"
//							+ "Response\r\n"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse322()
//									: ""),
//							font3));
//			document.add(cell322criteria3);
//			PdfPCell cell3221criteria3 = new PdfPCell(new Paragraph(
//					"3.2.2.1 Total Grants for research projects sponsored by the government agencies year-wise during\r\n"
//					+ "the last five years (INR in Lakhs).\r\n\r\n",font3));
//			document.add(cell3221criteria3);
//			
//			// create table 3221 //////
//
//			if (criteria3Fieldinfo.getYearTable3221()!=null) {
//				Table table3221criteria3 = new Table(criteria3Fieldinfo.getYearTable3221().size(), 2);
//
//				table3221criteria3.setPadding(10);
//				table3221criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3221().size(); i++) {
//					table3221criteria3.addCell(criteria3Fieldinfo.getYearTable3221().get(i).getInput3221y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3221().size(); i++) {
//					table3221criteria3.addCell(criteria3Fieldinfo.getYearTable3221().get(i).getInput3221v());
//
//				}
//
//				document.add(table3221criteria3);
//			}
//			PdfPTable table5criteria3 = new PdfPTable(2);
//			PdfPTable table53criteria31 = new PdfPTable(1);
//
//			table5criteria3.setWidthPercentage(100f);
//			table53criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell51criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font3));
//			PdfPCell cell52criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell53criteria3 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n"));
//			PdfPCell cell54criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(15).getCriteria3FilePath() : ""));
//			PdfPCell cell55criteria3 = new PdfPCell(new Paragraph("\r\ne-copies of the grant award letters for research\r\n"
//					+ "projects sponsored by government\r\n"
//					+ "\r\n\r\n"));
//			PdfPCell cell56criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(16).getCriteria3FilePath() : ""));
////			table53criteria31.addCell(cell322criteria3);
////			table53criteria31.addCell(cell3221criteria3);
//			table5criteria3.addCell(cell51criteria3);
//			table5criteria3.addCell(cell52criteria3);
//			table5criteria3.addCell(cell53criteria3);
//			table5criteria3.addCell(cell54criteria3);
//			table5criteria3.addCell(cell55criteria3);
//			table5criteria3.addCell(cell56criteria3);
//			
//
//			table53criteria31.addCell(table5criteria3);
//			// document.add(cell322criteria3);
//			// document.add(cell3221criteria3);
//			table53criteria31.setSpacingBefore(20f);
//			table53criteria31.setSpacingAfter(20f);
//
//			document.add(table53criteria31);
//
//			// create table 6////
//			
//			
//			Paragraph paragraph1criteria311 = new Paragraph("3.2.3 Number of research projects per teacher funded by government and non-government agencies\r\n"
//							+ "during the last five years\r\n"
//							+ "Response:\r\n" + "\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse323()
//									: ""),
//							font3);
//			document.add(paragraph1criteria311);
//			Paragraph paragraph1criteria312 = new Paragraph(
//					new Paragraph("3.2.3.1 Number of research projects funded by government and non-government agencies during the last five years.\r\n"
//							+ "Response\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3231t1()
//									: ""),
//							font3));
//			document.add(paragraph1criteria312);
//			Paragraph paragraph1criteria313 = new Paragraph(
//					new Paragraph("3.2.3.2 Number of full time teachers worked in the institution year-wise during the last five years..\r\n"
//							+ "Response"
//							  + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3232t2()
//									: ""),
//							font3));
//			document.add(paragraph1criteria313);
//			
//			//3231
//			if (criteria3Fieldinfo.getUniversityYearTable3231( ) !=null) {
//				Table table3231criteria3 = new Table(criteria3Fieldinfo.getUniversityYearTable3231().size(), 2);
//	
//				table3231criteria3.setPadding(10);
//				table3231criteria3.setWidth(100f);
//	
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3231().size(); i++) {
//					table3231criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3231().get(i).getInput3231y());
//	
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3231().size(); i++) {
//					table3231criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3231().get(i).getInput3231v());
//	
//				}
//	
//				document.add(table3231criteria3);
//			}
//			// 3231
//			
//			
//			PdfPCell cell3232criteria311 = new PdfPCell(
//					new Paragraph("3.2.3.2 Number of full time teachers worked in the institution year-wise during the last five years..\r\n"
//							+ "Response"
//							 + "\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput3232t2()
//									: ""),
//							font3));
//			document.add(cell3232criteria311);
//			
//			if (criteria3Fieldinfo.getUniversityYearTable3232() !=null) {
//				Table table3232criteria3 = new Table(criteria3Fieldinfo.getUniversityYearTable3232().size(), 2);
//	
//				table3232criteria3.setPadding(10);
//				table3232criteria3.setWidth(100f);
//	
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3232().size(); i++) {
//					table3232criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3232().get(i).getInput3232y());
//	
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3231().size(); i++) {
//					table3232criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3232().get(i).getInput3232v());
//	
//				}
//	
//				document.add(table3232criteria3);
//			}
//			
//			PdfPTable table6criteria3 = new PdfPTable(2);
//			PdfPTable table63criteria31 = new PdfPTable(1);
//
//			table6criteria3.setWidthPercentage(100f);
//			table63criteria31.setWidthPercentage(100f);
//			
//			PdfPCell cell61criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell62criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell63criteria3 = new PdfPCell(
//					new Paragraph("\r\nProvide the List of research projects and funding details (Data Templateas of 3.1.6)\r\n"));
//			PdfPCell cell64criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(16).getCriteria3FilePath() : ""));
//			PdfPCell cell65criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			PdfPCell cell66criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(17).getCriteria3FilePath() : ""));
//			PdfPCell cell67criteria3 = new PdfPCell(new Paragraph("Supporting document from the Funding Agency\r\n\r\n"));
//			PdfPCell cell68criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(18).getCriteria3FilePath() : ""));
//			PdfPCell cell69criteria3 = new PdfPCell(new Paragraph("Supporting document from the Funding Agency\r\n\r\n"));
//			PdfPCell cell70criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(19).getCriteria3FilePath() : ""));
//			
//			
//			
//			table6criteria3.addCell(cell61criteria3);
//			table6criteria3.addCell(cell62criteria3);
//			table6criteria3.addCell(cell63criteria3);
//			table6criteria3.addCell(cell64criteria3);
//			table6criteria3.addCell(cell65criteria3);
//			table6criteria3.addCell(cell66criteria3);
//			table6criteria3.addCell(cell67criteria3);
//			table6criteria3.addCell(cell68criteria3);
//			table6criteria3.addCell(cell69criteria3);
//			table6criteria3.addCell(cell70criteria3);
//			document.add(table6criteria3);
//			
//			
////			
////			/// create table 7 ///
////			PdfPTable table7criteria3 = new PdfPTable(2);
////			PdfPTable table73criteria31 = new PdfPTable(1);
//	//
////			table7criteria3.setWidthPercentage(100f);
////			table73criteria31.setWidthPercentage(100f);
//	//
////			PdfPCell cell71criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
////			PdfPCell cell72criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
////			PdfPCell cell73criteria3 = new PdfPCell(new Paragraph("Supporting document from Funding Agency\r\n\r\n\r\n"));
////			PdfPCell cell74criteria3 = new PdfPCell(
////					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(18).getCriteria3FilePath() : ""));
////			PdfPCell cell75criteria3 = new PdfPCell(new Paragraph("List of research projects and funding details\r\n\r\n\r\n"));
////			PdfPCell cell76criteria3 = new PdfPCell(
////					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(19).getCriteria3FilePath() : ""));
////			PdfPCell cell77criteria3 = new PdfPCell(new Paragraph("Paste link to funding agency website\r\n\r\n\r\n"));
////			PdfPCell cell78criteria3 = new PdfPCell(new Paragraph(""));
////			table7criteria3.addCell(cell71criteria3);
////			table7criteria3.addCell(cell72criteria3);
////			table7criteria3.addCell(cell73criteria3);
////			table7criteria3.addCell(cell74criteria3);
////			table7criteria3.addCell(cell75criteria3);
////			table7criteria3.addCell(cell76criteria3);
////			table7criteria3.addCell(cell77criteria3);
////			table7criteria3.addCell(cell78criteria3);
////			PdfPCell cell3241criteria3 = new PdfPCell(new Paragraph(
////					"3.2.4 Average percentage of departments having Research projects funded by government and non- government agencies during the last five years\r\n"
////							+ "\r\n" + "Response:"
////							+ (criteria3_FieldInfoQnList != null
////									? criteria3_FieldInfoQnList.get(0).getResponse324()
////									: ""),
////					font2));
////			PdfPCell cell32412criteria3 = new PdfPCell(new Paragraph(
////					"3.2.4.1 Number of departments having Research projects funded by government and non- government agencies during the last five years\r\n"
////							+ "\r\n\r\n",
////					font2));
//	//
////			PdfPCell cell3242criteria3 = new PdfPCell(new Paragraph(
////					"3.2.4.1 Number of departments having Research projects funded by government and non- government agencies during the last five years\r\n"
////							+ "\r\n\r\n",
////					font2));
//	//
////			table73criteria31.addCell(cell3241criteria3);
////			table73criteria31.addCell(cell32412criteria3);
////			table73criteria31.addCell(cell3242criteria3);
//	//
////			table73criteria31.addCell(table7criteria3);
////			// document.add(cell324criteria3);
////			// document.add(cell3241criteria3);
////			// document.add(cell3242criteria3);
////			table73criteria31.setSpacingBefore(20f);
////			table73criteria31.setSpacingAfter(20f);
//	//
////			document.add(table73criteria31);
////			/// create table 3241 ///
//	//
////			if (criteria3_FieldInfoQnList != null) {
////				Table table3241criteria3 = new Table(criteria3FieldInfoList.get(0).getYearTable3241().size(), 2);
//	//
////				table3241criteria3.setPadding(10);
////				table3241criteria3.setWidth(100f);
//	//
////				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3241().size(); i++) {
////					table3241criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3241().get(i).getInput3241y());
//	//
////				}
////				for (int i = 0; i < criteria3FieldInfoList.get(0).getYearTable3241().size(); i++) {
////					table3241criteria3.addCell(criteria3FieldInfoList.get(0).getYearTable3241().get(i).getInput3241v());
//	//
////				}
//	//
////				document.add(table3241criteria3);
////			}
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