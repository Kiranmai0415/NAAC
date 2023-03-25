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
//public class UniversityCriteria33Report2 {
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
//			Paragraph paragraph4criteria3 = new Paragraph("3.3	Innovation Ecosystem\r\n\r\n", font3);
//			paragraph4criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph4criteria3);
//			// create table 8 ///
//			PdfPTable table8criteria3 = new PdfPTable(2);
//			PdfPTable table81criteria31 = new PdfPTable(1);
//
//			table8criteria3.setWidthPercentage(100f);
//			table81criteria31.setWidthPercentage(100f);
//			
//			PdfPCell cell81criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell82criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell83criteria3 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n"));
//			PdfPCell cell84criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(18).getCriteria3FilePath() : ""));
//			PdfPCell cell85criteria3 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n"));
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
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getResponse331()
//									: ""),
//					font3));
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
//			Paragraph paragraph4criteria322 = new Paragraph(
//					"3.3.2 Number of workshops/seminars conducted on Research methodology, Intellectual Property Rights (IPR),entrepreneurship, skill development during the last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse332()
//									: ""));
//			document.add(paragraph4criteria322);
//			Paragraph paragraph4criteria321 = new Paragraph(
//					"3.3.2.1 Total number of workshops/seminars conducted on Research methodology, Intellectual Property Rights (IPR),entrepreneurship, skill development year-wise during the last five years.\r\n"
//							+ "\r\n");
//			document.add(paragraph4criteria321);
//			
////			
//			// create a table 3321 //
//
//			if (criteria3Fieldinfo.getYearTable3321() != null) {
//				Table table3321criteria3 = new Table(criteria3Fieldinfo.getYearTable3321().size(), 2);
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
//			PdfPTable table9criteria3 = new PdfPTable(2);
//			PdfPTable table91criteria31 = new PdfPTable(1);
//
//			table9criteria3.setWidthPercentage(100f);
//			table91criteria31.setWidthPercentage(100f);
//			PdfPCell cell91criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell92criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n\r\n", font3));
//			PdfPCell cell93criteria3 = new PdfPCell(new Paragraph("\r\nReport of the event\r\n\r\n"));
//			PdfPCell cell94criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell95criteria3 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell96criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			PdfPCell cell951criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n"));
//			PdfPCell cell961criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
//			
//			
//			table9criteria3.addCell(cell91criteria3);
//			table9criteria3.addCell(cell92criteria3);
//			table9criteria3.addCell(cell93criteria3);
//			table9criteria3.addCell(cell94criteria3);
//			table9criteria3.addCell(cell95criteria3);
//			table9criteria3.addCell(cell96criteria3);
//			table9criteria3.addCell(cell951criteria3);
//			table9criteria3.addCell(cell961criteria3);
////			table91criteria31.addCell(cell332criteria3);
////			table91criteria31.addCell(cell3321criteria3);
//			table91criteria31.addCell(table9criteria3);
//
//			// document.add(cell332criteria3);
//			// document.add(cell3321criteria3);
//			table91criteria31.setSpacingBefore(20f);
//			table91criteria31.setSpacingAfter(20f);
//			document.add(table91criteria31);
//			
//			
//			
//			PdfPTable table333criteria3 = new PdfPTable(2);
//			PdfPTable table3331criteria31 = new PdfPTable(1);
//
//			table333criteria3.setWidthPercentage(100f);
//			table3331criteria31.setWidthPercentage(100f);
//			PdfPCell cell911criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font3));
//			PdfPCell cell922criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
////			PdfPCell cell933criteria3 = new PdfPCell(new Paragraph("Report of the event\r\n\r\n\r\n"));
////			PdfPCell cell944criteria3 = new PdfPCell(
////					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(16).getCriteria3FilePath() : ""));
//			PdfPCell cell955criteria3 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell966criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(22).getCriteria3FilePath() : ""));
//			PdfPCell cell9511criteria3 = new PdfPCell(new Paragraph("\r\ne-copies of award letters\r\n\r\n"));
//			PdfPCell cell9611criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(23).getCriteria3FilePath() : ""));
//			
//			
//			table333criteria3.addCell(cell911criteria3);
//			table333criteria3.addCell(cell922criteria3);
////			table333criteria3.addCell(cell933criteria3);
////			table333criteria3.addCell(cell944criteria3);
//			table333criteria3.addCell(cell955criteria3);
//			table333criteria3.addCell(cell966criteria3);
//			table333criteria3.addCell(cell9511criteria3);
//			table333criteria3.addCell(cell9611criteria3);
//			PdfPCell cell333criteria3 = new PdfPCell(new Paragraph(
//					"3.3.3 Number of awards / recognitions received for research/innovations by the institution / teachers\r\n"
//					+ "/ research scholars / students during the last five years.\r\n"
//					+ "Response:"
//							+ (criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse333()
//									: ""),
//					font3));
//			PdfPCell cell3331criteria3 = new PdfPCell(new Paragraph(
//					"3.3.3.1 Total number of awards / recognitions received for research / innovations won by institution /\r\n"
//					+ "teachers / research scholars / students year-wise during the last five years."
//							+ "\r\n\r\n",
//					font3));
//			table3331criteria31.addCell(cell333criteria3);
//			table3331criteria31.addCell(cell3331criteria3);
//			table3331criteria31.addCell(table333criteria3);
//
//			// document.add(cell332criteria3);
//			// document.add(cell3321criteria3);
//			table3331criteria31.setSpacingBefore(20f);
//			table3331criteria31.setSpacingAfter(20f);
//			document.add(table3331criteria31);
//			// create a table 3321 //
//
//			if (criteria3Fieldinfo.getUniversityYearTable3331() != null) {
//				Table table3331criteria3 = new Table(criteria3Fieldinfo.getUniversityYearTable3331().size(), 2);
//
//				table3331criteria3.setPadding(10);
//				table3331criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3331().size(); i++) {
//					table3331criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3331().get(i).getInput3331y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getUniversityYearTable3331().size(); i++) {
//					table3331criteria3.addCell(criteria3Fieldinfo.getUniversityYearTable3331().get(i).getInput3331v());
//
//				}
//
//				document.add(table3331criteria3);
//			}
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