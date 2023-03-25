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
//public class AffilatedCriteria32Report2 
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
//			Font font1criteria3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font1criteria3.setSize(14);
//			
//			
//			Paragraph paragraph3criteria3 = new Paragraph("3.2	 Innovation Ecosystem\r\n\r\n", font1criteria3);
//			paragraph3criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph3criteria3);
//
//			Paragraph paragraph31criteria3 = new Paragraph("3.2: Resource Mobilization for Research");
//			document.add(paragraph31criteria3);
//			
//				Paragraph paragraph32criteria3 = new Paragraph(
//					"3.2.1 Institution has created an ecosystem for innovations and has initiatives for creation and\r\n"
//					+ "transfer of knowledg\r\n"
//							 + "Response:");
//			document.add(paragraph32criteria3);
//			
//			Paragraph paragraph33criteria3 = new Paragraph(criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse321()
//									: "");
//			document.add(paragraph33criteria3);
//			
//			
//
//			
//			
//			
//			
//
//			// create table 5 //////
//			PdfPTable table5criteria3 = new PdfPTable(2);
//			PdfPTable table53criteria31 = new PdfPTable(1);
//	      table5criteria3.setWidthPercentage(100f);
//	      table53criteria31.setWidthPercentage(100f);
//	      
//			PdfPCell cell51criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell52criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\\r\n", font2));
//			PdfPCell cell53criteria3 = new PdfPCell(new Paragraph("Upload any additional information"));
//			PdfPCell cell54criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(11).getCriteria3FilePath() : ""));
//			PdfPCell cell55criteria3 = new PdfPCell(
//					new Paragraph("Paste link for additional information\r\n"));
//			PdfPCell cell56criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(12).getCriteria3FilePath() :""));
//			
//		
//			
//			
//			
//			
//			table5criteria3.addCell(cell51criteria3);
//			table5criteria3.addCell(cell52criteria3);
//			table5criteria3.addCell(cell53criteria3);
//			table5criteria3.addCell(cell54criteria3);
//			table5criteria3.addCell(cell55criteria3);
//			table5criteria3.addCell(cell56criteria3);
//			document.add(table5criteria3);
//			
//			Paragraph paragraph34criteria3 = new Paragraph(
//					"3.2.2 Number of workshops/seminars conducted on Research Methodology, Intellectual Property\r\n"
//							+ "Rights (IPR) and entrepreneurship during the last five years\r\n"
//							 + "Response: ");
//			
//			document.add(paragraph34criteria3);
//			
//			
//			Paragraph paragraph35criteria3 = new Paragraph(criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse322()
//									: "");
//			document.add(paragraph35criteria3);
//			
//			
//			
//			
//			
//			Paragraph paragraph36criteria3 = new Paragraph(
//					"3.2.2.1 Total number of workshops/seminars conducted on Research Methodology, Intellectual\r\n"
//					+ "Property Rights (IPR) and entrepreneurship year-wise during last five years" + "\r\n\r\n");
//			document.add(paragraph36criteria3);
//			
//			
////			// year table 3221
//
//			if (criteria3Fieldinfo.getYearTable3221()!= null) {
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
//
//			// create table 6////
//			PdfPTable table6criteria3 = new PdfPTable(2);
//			PdfPTable table63criteria31 = new PdfPTable(1);
//	       table6criteria3.setWidthPercentage(100f);
//	       table63criteria31.setWidthPercentage(100f);
//			PdfPCell cell61criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell62criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell63criteria3 = new PdfPCell(
//					new Paragraph("Report of the event\r\n"));
//			PdfPCell cell64criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell65criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			PdfPCell cell66criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell67criteria3 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell68criteria3 = new PdfPCell(new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath():""));
//			table6criteria3.addCell(cell61criteria3);
//			table6criteria3.addCell(cell62criteria3);
//			table6criteria3.addCell(cell63criteria3);
//			table6criteria3.addCell(cell64criteria3);
//			table6criteria3.addCell(cell65criteria3);
//			table6criteria3.addCell(cell66criteria3);
//			table6criteria3.addCell(cell67criteria3);
//			table6criteria3.addCell(cell68criteria3);
//			
//			document.add(table6criteria3);
//			
//			
//			document.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//	}
//	
//
//			
//}
