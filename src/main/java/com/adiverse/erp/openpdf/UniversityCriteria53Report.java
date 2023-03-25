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
//	public class UniversityCriteria53Report {
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
//					reportPath = "UniversityCriteria5Report-" + strDate + ".pdf";
//					file = root.resolve(reportPath);
//				}
//				System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//				Document document = new Document(PageSize.A4);
//				
//				PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//				
//				document.open();
//				System.out.println("open the document==========>");
//				
//				Paragraph paragraph0 = new Paragraph("Criterion 5 - Student Support and Progression\r\n\r\n", font1);
//				paragraph0.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//	
//		document.add(paragraph0);
//		
//	
//				Paragraph paragraph04 = new Paragraph("5.3 Student Participation and Activities", font2);
//				paragraph04.setAlignment(Paragraph.ALIGN_LEFT);
//	
//				document.add(paragraph04);
//				
//				
//				PdfPTable table91criteria5 = new PdfPTable(1);	
//				table91criteria5.setWidthPercentage(100);
//				
//				
//				PdfPCell cell0116 = new PdfPCell(new Paragraph(
//						"5.3.1 Number of awards/medals won by students for outstanding performance in sports/cultural activities at inter-university/state/national / international level (award for a team event should be counted as one) during the last five years.\r\n"
//								+ "Response:"
//								+ (criteria5Fieldinfo != null
//										? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse531()
//										: ""),
//						font3));
//				PdfPCell cell0117 = new PdfPCell(new Paragraph(
//						"5.3.1.1 Number of awards/medals won by students for outstanding performance in sports / cultural activities at inter-university / state / national / international events (award for a team event should be counted as one) year - wise during the last five years.",
//						font3));
//				
//				
//
//				table91criteria5.addCell(cell0116);
//				table91criteria5.addCell(cell0117);
//				table91criteria5.setSpacingBefore(20f);
//				table91criteria5.setSpacingAfter(20f);
//	
//				document.add(table91criteria5);
//				
//				
//				
//				if(criteria5Fieldinfo.getYearTable5311() !=null)
//				{
//							Table table5311 = new Table(criteria5Fieldinfo.getYearTable5311().size(), 2);
//				
//							table5311.setPadding(10);
//							table5311.setWidth(100f);
//				
//							for (int i = 0; i < criteria5Fieldinfo.getYearTable5311().size(); i++) {
//								table5311.addCell(criteria5Fieldinfo.getYearTable5311().get(i).getInput5311y());
//				
//							}
//							for (int i = 0; i < criteria5Fieldinfo.getYearTable5311().size(); i++) {
//								table5311.addCell(criteria5Fieldinfo.getYearTable5311().get(i).getInput5311v());
//				
//							}
//				
//							document.add(table5311);
//						}	
//				
//				
//
//				PdfPTable table09criteria5 = new PdfPTable(2);
//				table09criteria5.setWidthPercentage(100);
//			
//	
//				PdfPCell cell67criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//				PdfPCell cell68criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//				PdfPCell cell69criteria5 = new PdfPCell(new Paragraph(
//						                                                "e-copies of award letters and certificates"));
//				PdfPCell cell70criteria5 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : ""));
//				PdfPCell cell71criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//				PdfPCell cell72criteria5 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(1).getCriteria5FilePath() : ""));
//				PdfPCell cell73criteria5 = new PdfPCell(new Paragraph("Number of awards/medals for outstanding performance in sports/ cultural activities at inter-university / state / national / international level during the last five years(Data Template)\r\n\r\n\r\n"));
//				PdfPCell cell74criteria5 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(2).getCriteria5FilePath() : ""));
//	
//				table09criteria5.addCell(cell67criteria5);
//				table09criteria5.addCell(cell68criteria5);
//				table09criteria5.addCell(cell69criteria5);
//				table09criteria5.addCell(cell70criteria5);
//				table09criteria5.addCell(cell71criteria5);
//				table09criteria5.addCell(cell72criteria5);
//				table09criteria5.addCell(cell73criteria5);
//				table09criteria5.addCell(cell74criteria5);
//	
//				document.add(table09criteria5)	;	
//				
//				
//				
//				PdfPTable table101criteria5 = new PdfPTable(1);
//				
//				table101criteria5.setWidthPercentage(100);
//				if(criteria5Fieldinfo.getCriteria5FieldInfoQl() !=null)
//				{
//				PdfPCell cell0119 = new PdfPCell(new Paragraph(
//						"5.3.2 Presence of an active Student Council & representation of students on academic & administrative bodies/committees of the institution\r\n"
//								+ "\r\n\r\n" + "Response:"
//								+ (criteria5Fieldinfo != null
//										? criteria5Fieldinfo.getCriteria5FieldInfoQl().get(0).getResponse532()
//										: ""),
//						font3));
//				
//				table101criteria5.addCell(cell0119);
//				}
//				
//				table101criteria5.setSpacingBefore(20f);
//				table101criteria5.setSpacingAfter(20f);
//	
//				document.add(table101criteria5);
//				
//				PdfPTable table010criteria5 = new PdfPTable(2);
//				
//				table010criteria5.setWidthPercentage(100);
//				
//	
//				PdfPCell cell75criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//				PdfPCell cell76criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//				PdfPCell cell77criteria5 = new PdfPCell(new Paragraph("Paste link for Additional Information"));
//				PdfPCell cell78criteria5 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(3).getCriteria5FilePath() : ""));
//				
//				PdfPCell cell77criteria51 = new PdfPCell(new Paragraph("Upload any Additional Information"));
//				PdfPCell cell78criteria51 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(4).getCriteria5FilePath() : ""));
//				
//
//	
//				table010criteria5.addCell(cell75criteria5);
//				table010criteria5.addCell(cell76criteria5);
//				table010criteria5.addCell(cell77criteria5);
//				table010criteria5.addCell(cell78criteria5);	
//				table010criteria5.addCell(cell77criteria51);
//				table010criteria5.addCell(cell78criteria51);	
//				
//				document.add(table010criteria5);
//				
//				PdfPTable table121criteria5 = new PdfPTable(1);		
//				
//				table121criteria5.setWidthPercentage(100);
//				
//				PdfPCell cell0121 = new PdfPCell(new Paragraph(
//						"5.3.3 Average number of sports and cultural events / competitions organised by the institution per year\r\n"
//								+ "\r\n\r\n" + "Response: "
//								+ (criteria5Fieldinfo != null
//										? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse533()
//										: ""),
//						font3));
//				PdfPCell cell0122 = new PdfPCell(new Paragraph(
//						"5.3.3.1 Number of sports and cultural events / competitions organised by the institution year - wise during the last five years.",
//						font3));
//	
//				table121criteria5.addCell(cell0121);
//				table121criteria5.addCell(cell0122);
//	
//		
//	
//				table121criteria5.setSpacingBefore(20f);
//				table121criteria5.setSpacingAfter(20f);
//	
//				document.add(table121criteria5);	
//				
//				
//				if(criteria5Fieldinfo.getYearTable5331() !=null)
//				{
//				Table table5331 = new Table(criteria5Fieldinfo.getYearTable5331().size(), 2);
//	
//				table5331.setPadding(10);
//				table5331.setWidth(100f);
//	
//				for (int i = 0; i < criteria5Fieldinfo.getYearTable5331().size(); i++) {
//					table5331.addCell(criteria5Fieldinfo.getYearTable5331().get(i).getInput5331y());
//	
//				}
//				for (int i = 0; i < criteria5Fieldinfo.getYearTable5331().size(); i++) {
//					table5331.addCell(criteria5Fieldinfo.getYearTable5331().get(i).getInput5331v());
//	
//				}
//	
//				document.add(table5331);
//				
//				}
//				
//				PdfPTable table012criteria5 = new PdfPTable(2);
//			
//	
//				// Setting width of table, its columns and spacing
//				table012criteria5.setWidthPercentage(100);
//			
//	
//				PdfPCell cell81criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//				PdfPCell cell82criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			
//				PdfPCell cell85criteria5 = new PdfPCell(new Paragraph("Report of the event\r\n\r\n\r\n"));
//				PdfPCell cell86criteria5 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(5).getCriteria5FilePath() : ""));
//				PdfPCell cell87criteria5 = new PdfPCell(
//						new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//				PdfPCell cell88criteria5 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(6).getCriteria5FilePath() : ""));
//				PdfPCell cell871criteria5 = new PdfPCell(
//						new Paragraph("Number of sports and cultural events / competitions organised per year (Data Template\r\n\r\n\r\n"));
//				PdfPCell cell881criteria5 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(7).getCriteria5FilePath() : ""));
//				table012criteria5.addCell(cell81criteria5);
//				table012criteria5.addCell(cell82criteria5);
//			
//				table012criteria5.addCell(cell85criteria5);
//				table012criteria5.addCell(cell86criteria5);
//				table012criteria5.addCell(cell87criteria5);
//				table012criteria5.addCell(cell88criteria5);
//				table012criteria5.addCell(cell871criteria5);
//				table012criteria5.addCell(cell881criteria5);
//	
//		document.add(table012criteria5);
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