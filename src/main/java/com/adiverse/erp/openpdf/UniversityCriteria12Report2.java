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
//@Service
//public class UniversityCriteria12Report2 {
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
//			Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
//			paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph);
//
//			
//
//
//			Paragraph paragraph43 = new Paragraph("1.2 Academic Flexibility\r\n", font2);
//			paragraph43.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph43);
//			
//			
//
//			PdfPTable table31 = new PdfPTable(1);
//			table31.setWidthPercentage(100);
//			table31.addCell(
//					"1.2.1: Percentage of new courses introduced of the total number of courses across all programs offered during the last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse121()
//									: ""));
//			table31.addCell(
//					"1.2.1.1: How many new courses are introduced within the last five years.\r\n"
//							+ "\r\n" 
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1211t1()
//									: ""));
//			table31.addCell(
//					"1.2.1.2: Number of courses offered by the institution across all programmes during the last five years.\r\n"
//							+ "\r\n" 
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1212t2()
//									: ""));
//			
//			
//			document.add(table31);
//			
//			
//			
//
//			// creating tabl4
//
//			PdfPTable table4 = new PdfPTable(2);
//			table4.setWidthPercentage(100);
//			PdfPTable table41 = new PdfPTable(1);
//			table41.setWidthPercentage(100);
//
//			/*
//			 * com.lowagie.text.Font font4 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//			 * font4.setColor(CMYKColor.BLACK);
//			 */
//			PdfPCell cell411 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell412 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell413 = new PdfPCell(new Paragraph("\r\nMinutes of relevant Academic Council/BOS meetings\r\n"));
//			PdfPCell cell414 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
//			PdfPCell cell415 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n"));
//			PdfPCell cell416 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : ""));
//			PdfPCell cell417 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"));
//			PdfPCell cell418 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(3).getCriteria1FilePath() : ""));
//			PdfPCell cell419 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n"));
//			PdfPCell cell420 = new PdfPCell(new Paragraph(""));
//			
//			table4.addCell(cell411);
//			table4.addCell(cell412);
//			table4.addCell(cell413);
//			table4.addCell(cell414);
//			table4.addCell(cell415);
//			table4.addCell(cell416);
//			table4.addCell(cell417);
//			table4.addCell(cell418);
//			table4.addCell(cell419);
//			table4.addCell(cell420);
//			document.add(table4);
//			
//			
//			
//			
//			PdfPTable table22 = new PdfPTable(1);
//			table22.setWidthPercentage(100);
//			table22.addCell(
//					"1.2.2: Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year).\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse122()
//									: ""));
//			table22.addCell(
//					"1.2.2.1: Number of Programmes in which CBCS / Elective course system implemented.\r\n"
//							+ "\r\n" 
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1221t1()
//									: ""));
//			table22.addCell(
//					"1.2.2.1: Total number of Programmes offered\r\n"
//							+ "\r\n" 
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1221t2()
//									: ""));
//			
//			
//			document.add(table22);
//			
//			
//			
//			
//			
//
//			PdfPTable table5 = new PdfPTable(2);
//			table5.setWidthPercentage(100);
//		    PdfPCell cell511 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell512 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell513 = new PdfPCell(new Paragraph("\r\n\r\nMinutes of relevant Academic Council/BOS meetings\r\n"));
//			PdfPCell cell514 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : ""));
//			PdfPCell cell515 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n"));
//			PdfPCell cell516 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : ""));
//			PdfPCell cell517 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"));
//			PdfPCell cell518 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : ""));
//			PdfPCell cell519 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n"));
//			PdfPCell cell520 = new PdfPCell(new Paragraph(""));
//			
//			
//
//			table5.addCell(cell511);
//			table5.addCell(cell512);
//			table5.addCell(cell513);
//			table5.addCell(cell514);
//			table5.addCell(cell515);
//			table5.addCell(cell516);
//			table5.addCell(cell517);
//			table5.addCell(cell518);
//			table5.addCell(cell519);
//			table5.addCell(cell520);
//			document.add(table5);
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
