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
//import com.adiverse.erp.model.Criteria2_FieldInfo;
//import com.adiverse.erp.model.Criteria2_FileUpload;
//import com.adiverse.erp.service.Criteria2Service;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.Image;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//@Service
//public class AffiliatedCriteria27Report2 {
//	
//	
//
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//
//	public Image headerImage;
//
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//
//	
//	@Autowired
//	Criteria2Service service2;
//	
//	
//	List<Criteria2_FieldInfo> criteria2List = null;
//	Criteria2_FieldInfo criteria2Record = null;
//	List<Criteria2_FileUpload> criteria2file = null;
//	
//	public String generateReport(Criteria2_FieldInfo criteria2Fieldinfo ) throws DocumentException, IOException {
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
//			criteria2List = service2.getAllCriteria2Data();
//			if (CollectionUtils.isNotEmpty(criteria2List)) {
//				criteria2Record = criteria2List.get(0);
//				criteria2file = criteria2Record.getCriteria2FileUpload();
//			} else {
//				criteria2Record = new Criteria2_FieldInfo();
//			}
//			  
//            if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AffilatedCriteria2Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			Document document = new Document(PageSize.A4);
//			// PdfWriter.getInstance(document, response.getOutputStream());
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>");
//			
//			PdfPTable tablecriteria2 = new PdfPTable(1);
//			tablecriteria2.setWidthPercentage(100);
//			PdfPTable table1criteria2 = new PdfPTable(1);
//			table1criteria2.setWidthPercentage(100);
//			PdfPTable table6criteria2 = new PdfPTable(5);
//			table6criteria2.setWidthPercentage(100);
//
////			PdfPTable table7criteria2 = new PdfPTable(2);
////			table7criteria2.setWidthPercentage(100);
//
//
//			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
//		
//
//			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		
//			document.add(paragraph2criteria2);
//		
//			tablecriteria2.setWidthPercentage(100f);
//
//
//			Paragraph paragraph9criteria2 = new Paragraph("2.7	Student Satisfaction Survey \r\n\r\n", font2);
//
//			paragraph9criteria2.setAlignment(Paragraph.ALIGN_LEFT);
//
//			document.add(paragraph9criteria2);
//			PdfPTable table33 = new PdfPTable(1);
//			table33.setWidthPercentage(100f);
//
////			table33.addCell("2.7.1 Online student satisfaction survey regarding teaching learning process\r\n" + "\r\n"
////					+ "Response:"
////					+ (criteria2Record != null ? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse271()
////							: ""));
////			
//			
//			
////			PdfPCell cell0003criteria2 = new PdfPCell(new Paragraph(
////					"student satisfaction survey regarding teaching learning process\r\n"
////					+ "Response:"
////							+ (criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse271()
////							: ""),font3));
////			
////			
////			table33.addCell(cell0003criteria2);
////			
////			table33.addCell((criteria2Record != null ? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput271t1()
////							: ""));
////			
////			
////
////			document.add(table33);
//			
//			
//			Paragraph paragraph9criteria23= new Paragraph("2.7.1: Online student satisfaction survey regarding to teaching learning process.");
//document.add(paragraph9criteria23);
//      Paragraph paragraph9criteria24= new Paragraph("\r\n");
//      document.add(paragraph9criteria24);
//			PdfPTable table34 = new PdfPTable(2);
//
//			table34.setWidthPercentage(100f);
//			table34.setWidths(new int[] { 3, 3 });
//			table34.setSpacingBefore(5);
//
//			PdfPCell cell95criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table34.addCell(cell95criteria2);
//
//			PdfPCell cell96criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table34.addCell(cell96criteria2);
//
//			PdfPCell cell97criteria2 = new PdfPCell(new Paragraph("Upload any additional information"));
//			table34.addCell(cell97criteria2);
//
//			PdfPCell cell98criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table34.addCell(cell98criteria2);
//			
//			
//			
//			PdfPCell cell97criteria21 = new PdfPCell(new Paragraph("Upload database of all currently enrolled students"));
//			table34.addCell(cell97criteria21);
//
//			PdfPCell cell98criteria21 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table34.addCell(cell98criteria21);
//
//			
//
//			document.add(table34);
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
