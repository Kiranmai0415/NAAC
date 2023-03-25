//package com.adiverse.erp.openpdf;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import org.apache.commons.collections4.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.adiverse.erp.model.Criteria1_FileUpload;
//import com.adiverse.erp.model.Criteria2_FieldInfo;
//import com.adiverse.erp.model.Criteria2_FileUpload;
//import com.adiverse.erp.service.Criteria2Service;
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
//public class AutonomousCriteria24Report2 {
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//   @Autowired
//   Criteria2Service service2;
//   
//   
//	List<Criteria2_FieldInfo> criteria2List = null;
//	Criteria2_FieldInfo criteria2Record = null;
//	List<Criteria2_FileUpload> criteria2file = null;
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//
//public String generateReport(Criteria2_FieldInfo criteria2Fieldinfo) throws DocumentException, IOException {
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
//
//			criteria2List = service2.getAllCriteria2Data();
//			if (CollectionUtils.isNotEmpty(criteria2List)) {
//				criteria2Record = criteria2List.get(0);
//				criteria2file = criteria2Record.getCriteria2FileUpload();
//			} else {
//				criteria2Record = new Criteria2_FieldInfo();
//			}
//			
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AuthonomousCriteria2Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
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
//			PdfPTable tablecriteria2 = new PdfPTable(1);
//			PdfPTable table1criteria2 = new PdfPTable(1);
//	// PdfPTable table4criteria2 = new PdfPTable(5);
//
//	// PdfPTable table5criteria2= new PdfPTable(5);
//
//			PdfPTable table3criteria2 = new PdfPTable(2);
//
//			PdfPTable table6criteria2 = new PdfPTable(5);
//			PdfPTable table7criteria2 = new PdfPTable(2);
//
//			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
//			
//			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph2criteria2);
//
//			tablecriteria2.setWidthPercentage(100f);
//
//			Paragraph paragraph6criteria2 = new Paragraph(" 2.4 Teacher Profile and Quality\r\n\r\n", font2);
//
//			paragraph6criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph6criteria2);
//
//			PdfPTable table07 = new PdfPTable(1);
//			table07.setWidthPercentage(100f);
//
//			PdfPCell cell004 = new PdfPCell(new Paragraph(
//					"2.4.1 Average percentage of full time teachers against sanctioned posts during the last five years"
//							+ "\r\n" + "" + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse241()
//									: ""),
//					font3));
//			table07.addCell(cell004);
//			document.add(table07);
//
//			PdfPTable table14 = new PdfPTable(2);
//
//			table14.setWidthPercentage(100f);
//			table14.setWidths(new int[] { 3, 3 });
//			table14.setSpacingBefore(5);
//
//			PdfPCell cell43 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table14.addCell(cell43);
//
//			PdfPCell cell44 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table14.addCell(cell44);
//
//			PdfPCell cell45 = new PdfPCell(
//					new Paragraph("Year wise full time teachers and sanctioned posts for 5 years(Data Template)\r\n\r\n"));
//			table14.addCell(cell45);
//
//			PdfPCell cell46 = new PdfPCell(new Paragraph(criteria2file.get(4).getCriteria2FilePath()));
//			table14.addCell(cell46);
//
//			PdfPCell cell47 = new PdfPCell(new Paragraph("List of the faculty members authenticated by the Head of HEI\r\n\r\n"));
//			table14.addCell(cell47);
//
//			PdfPCell cell48 = new PdfPCell(new Paragraph(criteria2file.get(4).getCriteria2FilePath()));
//			table14.addCell(cell48);
//
//			PdfPCell cell49 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
//			table14.addCell(cell49);
//
//			PdfPCell cell50 = new PdfPCell(new Paragraph(""));
//			table14.addCell(cell50);
//
//			document.add(table14);
//
//			PdfPTable table08 = new PdfPTable(1);
//			table08.setWidthPercentage(100f);
//
//			PdfPCell cell005 = new PdfPCell(new Paragraph(
//					"2.4.2 Average percentage of full time teachers with Ph. D. / D.M. / M.Ch. / D.N.B Superspeciality / D.Sc. / D.Litt. during the last five years (consider only highest degree for count)"
//							+ "\r\n" + "" + "" + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse242()
//									: ""),
//					font3));
//
//			table08.addCell(cell005);
//
//			table08.addCell(
//					" 2.4.2.1 Number of full time teachers with Ph.D./D.M/M.Ch./D.N.B Superspeciality/D.Sc./D�Lit. year wise during the last five years\r\n"
//							+ "\r\n" + " ");
//if(criteria2Fieldinfo.getYearTable2421() !=null)
//{
//			Table table2421 = new Table(criteria2Fieldinfo.getYearTable2421().size(), 2);
//
//			table2421.setPadding(10);
//			table2421.setWidth(100f);
//
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2421().size(); i++) {
//				table2421.addCell(criteria2Fieldinfo.getYearTable2421().get(i).getInput2421y());
//			}
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2421().size(); i++) {
//				table2421.addCell(criteria2Fieldinfo.getYearTable2421().get(i).getInput2421v());
//			}
//
//			document.add(table2421);
//}
//
//			/*
//			 * PdfPTable table16= new PdfPTable(5); table16.setWidthPercentage(100f);
//			 * table16.setWidths(new int[] {3, 3, 3, 3, 3}); table16.setSpacingBefore(5);
//			 * 
//			 * 
//			 * cell.setPhrase(new Phrase("    ")); table16.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table16.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table16.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table16.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table16.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table16.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table16.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table16.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table16.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table16.addCell(cell);
//			 * 
//			 * table08.addCell(table16);
//			 * 
//			 * 
//			 * document.add(table08);
//			 */
//
//			PdfPTable table17 = new PdfPTable(2);
//
//			table17.setWidthPercentage(100f);
//			table17.setWidths(new int[] { 3, 3 });
//			table17.setSpacingBefore(5);
//
//			PdfPCell cell51 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table17.addCell(cell51);
//
//			PdfPCell cell52 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table17.addCell(cell52);
//
//			PdfPCell cell53 = new PdfPCell(new Paragraph("Institutional data in prescribed format (Data Template)\r\n\r\n"));
//			table17.addCell(cell53);
//
//			PdfPCell cell54 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(6).getCriteria2FilePath() : ""));
//			table17.addCell(cell54);
//
//			PdfPCell cell55 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
//			table17.addCell(cell55);
//
//			PdfPCell cell56 = new PdfPCell(new Paragraph(""));
//			table17.addCell(cell56);
//
//			document.add(table17);
//
//			PdfPTable table20 = new PdfPTable(1);
//			table20.setWidthPercentage(100f);
//
////			PdfPCell cell009 = new PdfPCell(new Paragraph(
////					"2.4.3 Average teaching experience of full time teachers in the same institution (Data for the latest completed academic year in number of years)"
////							+ "\r\n" + "" + "" + "Response:"
////							+ (criteria2Fieldinfo != null
////									? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse243()
////									: ""),
////					font3));
//
////			table20.addCell(cell009);
//
//			table20.addCell(" 2.4.3.1 Total experience of full-time teachers\r\n" + "\r\n" + " " + "Response:"
//					+ (criteria2Fieldinfo!= null ? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getInput2431t1() : ""));
//
//			document.add(table20);
//
//			PdfPTable table21 = new PdfPTable(2);
//
//			table21.setWidthPercentage(100f);
//			table21.setWidths(new int[] { 3, 3 });
//			table21.setSpacingBefore(5);
//
//			PdfPCell cell61 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table21.addCell(cell61);
//
//			PdfPCell cell62 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table21.addCell(cell62);
//
//			PdfPCell cell63 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n"));
//			table21.addCell(cell63);
//
//			PdfPCell cell64 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(7).getCriteria2FilePath() : ""));
//			table21.addCell(cell64);
//
//			PdfPCell cell65 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			table21.addCell(cell65);
//
//			PdfPCell cell66 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(8).getCriteria2FilePath() : ""));
//			table21.addCell(cell66);
//
//			PdfPCell cell67 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
//			table21.addCell(cell67);
//
//			PdfPCell cell68 = new PdfPCell(new Paragraph());
//			table21.addCell(cell68);
//
//			document.add(table21);
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
