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
//public class AffilatedCriteria35Report2 
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
//			
//			
//		
//			Paragraph paragraph6criteria3 = new Paragraph("3.5	 Collaboration\r\n"+ "\r\n\r\n\r\n", font2);
//			paragraph6criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph6criteria3);
//
//							
//			Paragraph paragraph612criteria3 = new Paragraph("3.5.1: Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years");		
//			
//			document.add(paragraph612criteria3);
//			
//			Paragraph paragraph613criteria3 = new Paragraph
//					(criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getInput351t1()
//									: "");
//			document.add(paragraph613criteria3);
//			
//			
//							
//			Paragraph paragraph61criteria3 = new Paragraph("3.5.1.1: Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years");
//			
//			document.add(paragraph61criteria3);
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
//			if (criteria3Fieldinfo.getYearTable3521() != null) {
//				Table table3521criteria3 = new Table(criteria3Fieldinfo.getYearTable3521().size(), 2);
//
//				table3521criteria3.setPadding(10);
//				table3521criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3521().size(); i++) {
//					table3521criteria3.addCell(criteria3Fieldinfo.getYearTable3521().get(i).getInput3521y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3521().size(); i++) {
//					table3521criteria3.addCell(criteria3Fieldinfo.getYearTable3521().get(i).getInput3521v());
//
//				}
//			
//
//				document.add(table3521criteria3);
//				
//			}
//			
//			PdfPTable table17criteria3 = new PdfPTable(2);
//			PdfPTable table173criteria31 = new PdfPTable(1);
//
//			table17criteria3.setWidthPercentage(100f);
//			table173criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell171criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell172criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell173criteria3 = new PdfPCell(
//					new Paragraph("Reports of the event organized\r\n"));
//			PdfPCell cell174criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell175criteria3 = new PdfPCell(
//					new Paragraph("Any additional information\r\n"));
//			PdfPCell cell176criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell177criteria3 = new PdfPCell(new Paragraph(
//					"Number of extension and outreach Programmes conducted with industry, community etc for the last five years"));
//			PdfPCell cell178criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			
//			table17criteria3.addCell(cell171criteria3);
//			table17criteria3.addCell(cell172criteria3);
//			table17criteria3.addCell(cell173criteria3);
//			table17criteria3.addCell(cell174criteria3);
//			table17criteria3.addCell(cell175criteria3);
//			table17criteria3.addCell(cell176criteria3);
//			table17criteria3.addCell(cell177criteria3);
//			table17criteria3.addCell(cell178criteria3);
//			
//document.add(table17criteria3);
//			
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
