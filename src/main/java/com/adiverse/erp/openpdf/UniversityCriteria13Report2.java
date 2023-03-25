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
//import com.adiverse.erp.model.Criteria1_FieldInfo;
//import com.adiverse.erp.model.Criteria1_FileUpload;
//import com.adiverse.erp.service.Criteria1Service;
//import com.lowagie.text.Chunk;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Element;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//@Component
//public class UniversityCriteria13Report2 {
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//	
//    @Autowired 
//    Criteria1Service service1;
//	
//	List<Criteria1_FieldInfo> criteria1List =null;
//
//	Criteria1_FieldInfo criteria1Record =null;
//	
//	
//	List<Criteria1_FileUpload> criteria1file = null;
//	
//	
//	public String generateReport( Criteria1_FieldInfo criteria1Fieldinfo) throws DocumentException, IOException {
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
//			criteria1List = service1.getAllCriteria1Data();
//			if (CollectionUtils.isNotEmpty(criteria1List)) {
//				System.out.println("is empty===>"+ criteria1List.get(0));
//			//System.out.println("criteria1Record.getCriteria1FileUpload()======>"+criteria1Record.getCriteria1FileUpload().size());
//				criteria1Record = criteria1List.get(0);
//				criteria1file = criteria1Record.getCriteria1FileUpload();
//			} else {
//				criteria1Record = new Criteria1_FieldInfo();
//				criteria1file = new ArrayList<Criteria1_FileUpload>();
//			}
//			
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "UniversityCriteria1Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//
//			Document document = new Document(PageSize.A4);
//	
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>");
//			
//			
//			
////			Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
////			paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph);
//
//			Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font2);
//			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph1);
//
//			Paragraph paragraph54 = new Paragraph("\r\n 1.3 Curriculum Enrichment\r\n", font3);
//			paragraph54.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph54);
//			
//			PdfPTable table61 = new PdfPTable(1);
//			table61.setWidthPercentage(100);
//			
//			
//			table61.addCell(
//					"1.3.1: Institution integrates crosscutting issues relevant to Professional Ethics ,Gender, Human Values ,Environment and Sustainability into the Curriculum\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQl().get(0).getResponse131()
//									: ""));
//			document.add(table61);
//
//			// create table6
//
//			PdfPTable table6 = new PdfPTable(2);
//			table6.setWidthPercentage(100);
//			
//
//			
//
//			PdfPCell cell611 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell612 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n\r\n", font3));
//			PdfPCell cell613 = new PdfPCell(new Paragraph(
//					"\r\n\r\nUpload the list and description of the courses which address the Gender, Environment and Sustainability, Human Values and Professional Ethics into the Curriculum\r\n\r\n"));
//			PdfPCell cell614 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
//			PdfPCell cell615 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"));
//			PdfPCell cell616 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
//			
//			table6.addCell(cell611);
//			table6.addCell(cell612);
//			
//			table6.addCell(cell615);
//			table6.addCell(cell616);
//			table6.addCell(cell613);
//			table6.addCell(cell614);
//			document.add(table6);
//
//			
//			
//
//			PdfPTable table81 = new PdfPTable(1);
//			table81.setWidthPercentage(100);
//
//			table81.addCell(
//					"1.3.2: Number of value-added courses for imparting transferable and life skills offered during last five years"
//							+ "\r\n" + "Response:"
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse133()
//									: ""));
//			table81.addCell(
//					"1.3.2.1: How many new value-added courses are added within the last five years"
//							+ "\r\n");
//			
//			document.add(table81);
//		
//			// year table 1321
//			if(criteria1Fieldinfo.getYearTable1321() !=null)
//			{
//
//			Table table1321 = new Table(criteria1Fieldinfo.getYearTable1321().size(), 2);
//
//			table1321.setPadding(10);
//			table1321.setWidth(100f);
//
//			for (int i = 0; i < criteria1Fieldinfo.getYearTable1321().size(); i++) {
//				table1321.addCell(criteria1Fieldinfo.getYearTable1321().get(i).getInput1321y());
//			}
//			for (int i = 0; i < criteria1Fieldinfo.getYearTable1321().size(); i++) {
//				table1321.addCell(criteria1Fieldinfo.getYearTable1321().get(i).getInput1321v());
//			}
//
//		 document.add(table1321);
//			}
//		 
//		 
//
//		
//
//			PdfPTable table8 = new PdfPTable(2);
//			table8.setWidthPercentage(100);
//		
//			PdfPCell cell81 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell82 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell83 = new PdfPCell(new Paragraph("\r\nList of value added courses (Data Template)\r\n"));
//			PdfPCell cell84 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : ""));
//			PdfPCell cell85 = new PdfPCell(new Paragraph("\r\nBrochure or any other document relating to value added courses\r\n\r\n"));
//			PdfPCell cell86 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : ""));
//			PdfPCell cell87 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n"));
//			PdfPCell cell88 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(3).getCriteria1FilePath() : ""));
//			PdfPCell cell89 = new PdfPCell(new Paragraph("\r\n Link for Additional Information\r\n\r\n"));
//			PdfPCell cell90 = new PdfPCell(new Paragraph(""));
//			
//			table8.addCell(cell81);
//			table8.addCell(cell82);
//			table8.addCell(cell83);
//			table8.addCell(cell84);
//			table8.addCell(cell85);
//			table8.addCell(cell86);
//			table8.addCell(cell87);
//			table8.addCell(cell88);
//			table8.addCell(cell89);
//			table8.addCell(cell90);
//			
//			document.add(table8);
//			
//			
//			// create table9
//		
//			PdfPTable table91 = new PdfPTable(1);
//			table91.setWidthPercentage(100);
//			
//			table91.addCell(
//					"1.3.3: Average Percentage of students enrolled in the courses under 1.3.2 above."
//							+ "\r\n" + "Response:"
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse133()
//									: ""));
//			
//			table91.addCell(
//					"1.3.3.1: Number of students enrolled in subject related Certificate or Add-on programs year wise during last five years"
//							+ "\r\n" );
//			document.add(table91);
//			if(criteria1Fieldinfo.getYearTable1331()!=null)
//			{
//						Table table1331 = new Table(criteria1Fieldinfo.getYearTable1331().size(), 2);
//
//						table1331.setPadding(10);
//						table1331.setWidth(100f);
//
//						for (int i = 0; i < criteria1Fieldinfo.getYearTable1331().size(); i++) {
//							table1331.addCell(criteria1Fieldinfo.getYearTable1331().get(i).getInput1331y());
//						}
//						for (int i = 0; i < criteria1Fieldinfo.getYearTable1331().size(); i++) {
//							table1331.addCell(criteria1Fieldinfo.getYearTable1331().get(i).getInput1331v());
//						}
//
//					    document.add(table1331);
//			}
//
//			Paragraph paragraph10 = new Paragraph(
//					"1.3.3.1: Number of students enrolled in subject related Certificate or Add-on programs year wise during last five years"
//							+ "\r\n" );
//            
//		document.add(paragraph10);
//			
//			
//			
//if(criteria1Fieldinfo.getYearTable13312() !=null)
//{
//		    Table table13312 = new Table(criteria1Fieldinfo.getYearTable13312().size(), 2);
//
//		    table13312.setPadding(10);
//		    table13312.setWidth(100f);
//
//			for (int i = 0; i < criteria1Fieldinfo.getYearTable13312().size(); i++) {
//				table13312.addCell(criteria1Fieldinfo.getYearTable13312().get(i).getInput13312y());
//			}
//			for (int i = 0; i < criteria1Fieldinfo.getYearTable13312().size(); i++) {
//				table13312.addCell(criteria1Fieldinfo.getYearTable13312().get(i).getInput13312v());
//			}
//
//		    document.add(table13312);
//		 
//}
//		    
//		    
//		    
//		    
//		    
//
//			PdfPTable table92 = new PdfPTable(2);
//
//			table92.setWidthPercentage(100);
//
//			PdfPCell cell921 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell922 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell923 = new PdfPCell(new Paragraph("\r\n  Any additional information\r\n"));
//			PdfPCell cell924 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : ""));
//			PdfPCell cell925 = new PdfPCell(new Paragraph("\r\nList of students enrolled(Data template)\r\n\r\n"));
//			PdfPCell cell926 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : ""));
//			
//			
//			table92.addCell(cell921);
//			table92.addCell(cell922);
//			table92.addCell(cell923);
//			table92.addCell(cell924);
//			table92.addCell(cell925);
//			table92.addCell(cell926);
//			document.add(table92);
//			
//			
//			
//			PdfPTable table101 = new PdfPTable(1);
//			table101.setWidthPercentage(100);
//
//			table101.addCell(
//					"1.3.4: Percentage of students undertaking field projects/ internships / student projects (Data for the latest completed academic year)."
//							+ "\r\n" + "Response:"
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse134()
//									: ""));
//			
//			table101.addCell(
//					"1.3.4.1: Number of students undertaking field projects / internships / student projects"
//							+ "\r\n" 
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1341t1()
//									: ""));
//			table101.addCell(
//					"1.3.4.1: Number of students undertaking field projects / internships / student projects"
//							+ "\r\n" 
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1341t2()
//									: ""));
//			document.add(table101);
//			
//			
//			// create table10
//			PdfPTable table10 = new PdfPTable(2);
//			table10.setWidthPercentage(100);
//
//			
//
//			PdfPCell cell101 = new PdfPCell(new Paragraph("\r\n\r\nFileDiscription\r\n", font3));
//			PdfPCell cell102 = new PdfPCell(new Paragraph("\r\n\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell103 = new PdfPCell(new Paragraph(
//					"\r\n\r\n Any additional information\r\n\r\n"));
//			PdfPCell cell104 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : ""));
//			PdfPCell cell105 = new PdfPCell(new Paragraph("\r\n\r\nList of programs and number of students undertaking field projects / internships / student projects (Data Template)\r\n"));
//			PdfPCell cell106 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
//			
//			
//			
//			table10.addCell(cell101);
//			table10.addCell(cell102);
//			table10.addCell(cell103);
//			table10.addCell(cell104);
//			table10.addCell(cell105);
//			table10.addCell(cell106);
//			
//            document.add(table10);
//			
//			
//
//			/*
//			 * com.lowagie.text.Font fontTitle67 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle67.setSize(16);
//			 */
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
//}
