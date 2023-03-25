//	package com.adiverse.erp.openpdf;
//	
//	import java.io.FileOutputStream;
//	import java.io.IOException;
//	import java.nio.file.Path;
//	import java.nio.file.Paths;
//	import java.text.SimpleDateFormat;
//	import java.util.ArrayList;
//	import java.util.Date;
//	import java.util.List;
//	
//	import org.apache.commons.collections4.CollectionUtils;
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.beans.factory.annotation.Value;
//	import org.springframework.stereotype.Service;
//	
//	import com.adiverse.erp.model.Criteria4_FieldInfo;
//	import com.adiverse.erp.model.Criteria4_FileUpload;
//	import com.adiverse.erp.model.Criteria5_FieldInfo;
//	import com.adiverse.erp.model.Criteria5_FileUpload;
//	import com.adiverse.erp.service.Criteria5Service;
//	import com.lowagie.text.Chunk;
//	import com.lowagie.text.Document;
//	import com.lowagie.text.DocumentException;
//	import com.lowagie.text.Font;
//	import com.lowagie.text.FontFactory;
//	import com.lowagie.text.PageSize;
//	import com.lowagie.text.Paragraph;
//	import com.lowagie.text.Phrase;
//	import com.lowagie.text.Table;
//	import com.lowagie.text.pdf.CMYKColor;
//	import com.lowagie.text.pdf.PdfPCell;
//	import com.lowagie.text.pdf.PdfPTable;
//	import com.lowagie.text.pdf.PdfWriter;
//	
//	@Service
//	public class UniversityCriteria54Report {
//		
//		@Value("${upload.files.path}")
//		private String reportGeneratePath;      //file upload path
//		
//		public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//		public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//		
//		
//	  @Autowired
//	  Criteria5Service service5;
//	  
//	  List<Criteria5_FieldInfo> criteria5List = null;
//		Criteria5_FieldInfo criteria5Record = null;
//		List<Criteria5_FileUpload> criterai5file = null;
//		
//	   
//	
//		public String generateReport(Criteria5_FieldInfo criteria5Fieldinfo) throws DocumentException, IOException {
//			String reportPath = "";
//			Path root = Paths.get(reportGeneratePath);
//			Path file = null;
//			Date date = new Date();
//			try {
//				font1.setSize(16);
//				font2.setSize(14);
//				font3.setSize(12);
//				font4.setSize(14);
//				font5.setSize(12);
//	
//				criteria5List = service5.getAllCriteria5Data();
//				if (CollectionUtils.isNotEmpty(criteria5List)) {
//					criteria5Record = criteria5List.get(0);
//					criterai5file = criteria5Record.getCriteria5FileUpload();
//				} else {
//					criteria5Record = new Criteria5_FieldInfo();
//					criterai5file = new ArrayList<>();
//				}
//				if (root != null) {
//					SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//					String strDate = formatter.format(date);
//					reportPath = "UniversityCriteria54Report-" + strDate + ".pdf";
//					file = root.resolve(reportPath);
//				}
//				System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//				Document document = new Document(PageSize.A4);
//				PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//				
//				document.open();
//				System.out.println("open the document==========>");
//				
//				Paragraph paragraph0 = new Paragraph("Criterion 5 - Student Support and Progression\r\n\r\n", font1);
//				paragraph0.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//	            document.add(paragraph0);
//
//				Paragraph paragraph05 = new Paragraph("5.4 Alumni Engagement\r\n\r\n\r\n", font3);
//				paragraph05.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//	
//				document.add(paragraph05);
//				
//
//				PdfPTable table131 = new PdfPTable(1);
//				table131.setWidthPercentage(100);
//				if( criteria5Fieldinfo.getCriteria5FieldInfoQl() !=null)
//				{
//				
//				PdfPCell cell0244 = new PdfPCell(new Paragraph(
//						"5.4.1 The Alumni Association / Chapters (registered and functional) contributes significantly to the development of the institution through financial and other support services.\r\n"
//								+ "\r\n\r\n" + "Response:"
//								+ (criteria5Fieldinfo != null
//										? criteria5Fieldinfo.getCriteria5FieldInfoQl().get(0).getResponse541()
//										: ""),
//						font3));
//				table131.addCell(cell0244);
//				table131.setSpacingBefore(20f);
//				table131.setSpacingAfter(20f);
//	
//				document.add(table131);
//				}
//		
//	
//				PdfPTable table013 = new PdfPTable(2);
//				table013.setWidthPercentage(100);
//			
//	
//				PdfPCell cell89criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//				PdfPCell cell90criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//				PdfPCell cell91criteria5 = new PdfPCell(new Paragraph("Paste link for Additional Information\r\n\r\n\r\n"));
//				PdfPCell cell92criteria5 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : ""));
//				PdfPCell cell93criteria5 = new PdfPCell(new Paragraph("Upload any Additional Informatio\r\n\r\n\r\n"));
//				PdfPCell cell94criteria5 = new PdfPCell(new Paragraph(criteria5Record != null ? criterai5file.get(1).getCriteria5FilePath() : ""));
//	
//				table013.addCell(cell89criteria5);
//				table013.addCell(cell90criteria5);
//				table013.addCell(cell91criteria5);
//				table013.addCell(cell92criteria5);
//				table013.addCell(cell93criteria5);
//				table013.addCell(cell94criteria5);
//	
//				document.add(table013);
//				
//		
//	
//				
//				PdfPTable table0141 = new PdfPTable(1);
//				table0141.setWidthPercentage(100);
//				if(criteria5Fieldinfo.getCriteria5FieldInfoQn() !=null)
//				{
//				PdfPCell cell0266 = new PdfPCell(new Paragraph(
//						"5.4.2 Alumni contribution during the last five years (INR in Lakhs)\r\n"
//						+ "Response:"
//								+ (criteria5Fieldinfo != null
//										? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse542()
//										: ""),
//						font3));
//				
//				table0141.addCell(cell0266);
//				
//				table0141.setSpacingBefore(20f);
//				table0141.setSpacingAfter(20f);
//	
//				document.add(table0141);
//				}
//				
//				
//				PdfPTable table014 = new PdfPTable(2);
//				table014.setWidthPercentage(100);
//			
//	
//				
//				
//				PdfPCell cell891criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//				PdfPCell cell902criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//				PdfPCell cell913criteria5 = new PdfPCell(new Paragraph("Upload any Additional Information\r\n\r\n\r\n"));
//				PdfPCell cell924criteria5 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(1).getCriteria5FilePath() : ""));
//				PdfPCell cell935criteria5 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//				PdfPCell cell946criteria5 = new PdfPCell(new Paragraph());
//	
//				table014.addCell(cell891criteria5);
//				table014.addCell(cell902criteria5);
//				table014.addCell(cell913criteria5);
//				table014.addCell(cell924criteria5);
////				table014.addCell(cell935criteria5);
////				table014.addCell(cell946criteria5);
//			document.add(table014);
//			
//			     document.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			return file.toAbsolutePath().toString();
//				
//				
//			}
//	}
//			