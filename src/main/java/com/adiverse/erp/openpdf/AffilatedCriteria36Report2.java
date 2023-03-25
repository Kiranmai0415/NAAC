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
//public class AffilatedCriteria36Report2 
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
//			// 3.6 //
//			Paragraph paragraph7criteria3 = new Paragraph("3.6	Extension Activities\r\n\r\n\r\n", font2);
//			paragraph7criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph7criteria3);
//			// create table 18 //
//
//			
//			
//			Paragraph paragraph71112criteria3 = new Paragraph("3.6.1: Extension activities are carried out in the neighbourhood community, sensitising students to social issues, for their holistic development, and impact thereof during the last five years");
//			
//			document.add(paragraph71112criteria3);
//			
//			Paragraph paragraph71113criteria3 = new Paragraph((criteria3Fieldinfo != null
//					? criteria3Fieldinfo.getCriteria3FieldInfoQl().get(0).getResponse361():""));
//			document.add(paragraph71113criteria3);
//			
//			Paragraph paragraph71142criteria3 = new Paragraph("\r\n");
//			
//			document.add(paragraph71142criteria3);
//
//			PdfPTable table19121criteria3 = new PdfPTable(2);
//			PdfPTable table1902criteria3 = new PdfPTable(1);
//
//			table19121criteria3.setWidthPercentage(100f);
//			table1902criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell19112criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell19212criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell19312criteria3 = new PdfPCell(
//					new Paragraph("Upload any additional information\r\n"));
//			PdfPCell cell19412criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell19512criteria3 = new PdfPCell(new Paragraph("Paste link for additional information\r\n"));
//			PdfPCell cell19612criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
////			PdfPCell cell1971criteria3 = new PdfPCell(new Paragraph("e-copy of the award letters\r\n"));
////			PdfPCell cell1981criteria3 = new PdfPCell(
////					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			table19121criteria3.addCell(cell19112criteria3);
//			table19121criteria3.addCell(cell19212criteria3);
//			table19121criteria3.addCell(cell19312criteria3);
//			table19121criteria3.addCell(cell19412criteria3);
//			table19121criteria3.addCell(cell19512criteria3);
//			table19121criteria3.addCell(cell19612criteria3);
////			table1911criteria3.addCell(cell1971criteria3);
////			table1911criteria3.addCell(cell1981criteria3);
//			document.add(table19121criteria3);
//			
//			
//			
//			
//			
//			// create table 3721 //
//			//////////////////////////////
//			
//			Paragraph paragraph7112criteria3 = new Paragraph(
//					"3.6.2: Number of awards and recognition received by the Institution, its teachers and students for extension activities from Government / Government recognised bodies during last five years" + "Response:");
//			document.add(paragraph7112criteria3);
//			
//			if(criteria3Fieldinfo.getCriteria3FieldInfoQn() !=null)
//			{
//			Paragraph paragraph7212criteria3 = new Paragraph(criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse362()
//									: "");
//			document.add(paragraph7212criteria3);
//			}
//			Paragraph paragraph731criteria3 = new Paragraph(
//					"3.6.2.1: Total number of awards and recognition received for extension activities from Government/ Government recognised bodies year-wise during the last five years"
//							);
//			document.add(paragraph731criteria3);
//			document.add(paragraph71142criteria3);
//
////			table191criteria3.addCell(cell362criteria3);
////			table191criteria3.addCell(cell3621criteria3);
////			// document.add(cell362criteria3);
////			// document.add(cell3621criteria3);
////			table191criteria3.setSpacingBefore(20f);
////			table191criteria3.setSpacingAfter(20f);
////			document.add(table191criteria3);
//
//			
//			
//			
//			
//			
//			
//
//			if (criteria3Fieldinfo.getYearTable3621() != null) {
//				Table table3721criteria3 = new Table(criteria3Fieldinfo.getYearTable3621().size(), 2);
//
//				table3721criteria3.setPadding(10);
//				table3721criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3621().size(); i++) {
//					table3721criteria3.addCell(criteria3Fieldinfo.getYearTable3621().get(i).getInput3621y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3621().size(); i++) {
//					table3721criteria3.addCell(criteria3Fieldinfo.getYearTable3621().get(i).getInput3621v());
//
//				}
//
//				document.add(table3721criteria3);
//			}
//			document.add(paragraph71142criteria3);
//			document.add(paragraph71142criteria3);
//			
//			PdfPTable table1911criteria3 = new PdfPTable(2);
//			PdfPTable table190criteria3 = new PdfPTable(1);
//
//			table1911criteria3.setWidthPercentage(100f);
//			table190criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell1911criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell1921criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell1931criteria3 = new PdfPCell(
//					new Paragraph("Any additional information\r\n"));
//			PdfPCell cell1941criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell1951criteria3 = new PdfPCell(new Paragraph("Number of awards for extension activities in last 5 year\r\n"));
//			PdfPCell cell1961criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell1971criteria3 = new PdfPCell(new Paragraph("e-copy of the award letters\r\n"));
//			PdfPCell cell1981criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			table1911criteria3.addCell(cell1911criteria3);
//			table1911criteria3.addCell(cell1921criteria3);
//			table1911criteria3.addCell(cell1931criteria3);
//			table1911criteria3.addCell(cell1941criteria3);
//			table1911criteria3.addCell(cell1951criteria3);
//			table1911criteria3.addCell(cell1961criteria3);
//			table1911criteria3.addCell(cell1971criteria3);
//			table1911criteria3.addCell(cell1981criteria3);
//			document.add(table1911criteria3);
//			
//			
//			
//			
//			/////////////////////
//			
//			Paragraph paragraph711criteria3 = new Paragraph(
//					"3.6.3: Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years" + "Response:");
//			document.add(paragraph711criteria3);
//			
//			if(criteria3Fieldinfo.getCriteria3FieldInfoQn() !=null)
//			{
//			Paragraph paragraph721criteria3 = new Paragraph(criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse363()
//									: "");
//			document.add(paragraph721criteria3);
//			}
//	
//			Paragraph paragraph7311criteria3 = new Paragraph(
//					"3.6.3.1: Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years."
//							);
//			document.add(paragraph7311criteria3);
//
////			table191criteria3.addCell(cell362criteria3);
////			table191criteria3.addCell(cell3621criteria3);
////			// document.add(cell362criteria3);
////			// document.add(cell3621criteria3);
////			table191criteria3.setSpacingBefore(20f);
////			table191criteria3.setSpacingAfter(20f);
////			document.add(table191criteria3);
//
//			
//			
//			
//			document.add(paragraph71142criteria3);
//			
//			
//
//			if (criteria3Fieldinfo.getYearTable3641() != null) {
//				Table table3721criteria3 = new Table(criteria3Fieldinfo.getYearTable3641().size(), 2);
//
//				table3721criteria3.setPadding(10);
//				table3721criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3641().size(); i++) {
//					table3721criteria3.addCell(criteria3Fieldinfo.getYearTable3641().get(i).getInput3641y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3641().size(); i++) {
//					table3721criteria3.addCell(criteria3Fieldinfo.getYearTable3641().get(i).getInput3641v());
//
//				}
//
//				document.add(table3721criteria3);
//			}
//			
//			
//			PdfPTable table19111criteria3 = new PdfPTable(2);
//			PdfPTable table1901criteria3 = new PdfPTable(1);
//
//			table1911criteria3.setWidthPercentage(100f);
//			table190criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell19111criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell19211criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell19311criteria3 = new PdfPCell(
//					new Paragraph("Reports of the event organized\r\n"));
//			PdfPCell cell19411criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell19511criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n"));
//			PdfPCell cell19611criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			PdfPCell cell19711criteria3 = new PdfPCell(new Paragraph("Number of extension and outreach Programmes conducted with industry, community etc for the last five years\r\n"));
//			PdfPCell cell19811criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
//			table19111criteria3.addCell(cell19111criteria3);
//			table19111criteria3.addCell(cell19211criteria3);
//			table19111criteria3.addCell(cell19311criteria3);
//			table19111criteria3.addCell(cell19411criteria3);
//			table19111criteria3.addCell(cell19511criteria3);
//			table19111criteria3.addCell(cell19611criteria3);
//			table19111criteria3.addCell(cell19711criteria3);
//			table19111criteria3.addCell(cell19811criteria3);
//			document.add(table19111criteria3);
//			
//			
//			
//			//////////////
//			Paragraph paragraph71criteria3 = new Paragraph(
//					"3.6.4: Average percentage of students participating in extension activities listed at 3.6.3 above during the last five years" + "Response:");
//			document.add(paragraph71criteria3);
//			
//			if(criteria3Fieldinfo.getCriteria3FieldInfoQn() !=null)
//			{
//			Paragraph paragraph72criteria3 = new Paragraph(criteria3Fieldinfo != null
//									? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse364()
//									: "");
//			document.add(paragraph72criteria3);
//			}
//	
//			Paragraph paragraph73criteria3 = new Paragraph(
//					"3.6.2.1 Total number of awards and recognition received for extension activities from Government/ Government recognised bodies year-wise during the last five years."
//							);
//			document.add(paragraph73criteria3);
//
////			table191criteria3.addCell(cell362criteria3);
////			table191criteria3.addCell(cell3621criteria3);
////			// document.add(cell362criteria3);
////			// document.add(cell3621criteria3);
////			table191criteria3.setSpacingBefore(20f);
////			table191criteria3.setSpacingAfter(20f);
////			document.add(table191criteria3);
//
//			
//			
//			
//			
//			
//			
//
//			if (criteria3Fieldinfo.getYearTable3641() != null) {
//				Table table3721criteria3 = new Table(criteria3Fieldinfo.getYearTable3641().size(), 2);
//
//				table3721criteria3.setPadding(10);
//				table3721criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3641().size(); i++) {
//					table3721criteria3.addCell(criteria3Fieldinfo.getYearTable3641().get(i).getInput3641y());
//
//				}
//				for (int i = 0; i < criteria3Fieldinfo.getYearTable3641().size(); i++) {
//					table3721criteria3.addCell(criteria3Fieldinfo.getYearTable3641().get(i).getInput3641v());
//
//				}
//
//				document.add(table3721criteria3);
//			}
//			
//			document.add(paragraph71142criteria3);
//			PdfPTable table19113criteria3 = new PdfPTable(2);
//			PdfPTable table1903criteria3 = new PdfPTable(1);
//
//			table19113criteria3.setWidthPercentage(100f);
//			table1903criteria3.setWidthPercentage(100f);
//
//			PdfPCell cell19113criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			PdfPCell cell19213criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			PdfPCell cell19313criteria3 = new PdfPCell(
//					new Paragraph("Number of awards for extension activities in last 5 year\r\n\r\n\r\n"));
//			PdfPCell cell19413criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(46).getCriteria3FilePath() : ""));
//			PdfPCell cell19513criteria3 = new PdfPCell(new Paragraph("e-copy of the award letters\r\n\r\n\r\n"));
//			PdfPCell cell19613criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(47).getCriteria3FilePath() : ""));
//			PdfPCell cell19713criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell19813criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(48).getCriteria3FilePath() : ""));
//			table19113criteria3.addCell(cell19113criteria3);
//			table19113criteria3.addCell(cell19213criteria3);
//			table19113criteria3.addCell(cell19313criteria3);
//			table19113criteria3.addCell(cell19413criteria3);
//			table19113criteria3.addCell(cell19513criteria3);
//			table19113criteria3.addCell(cell19613criteria3);
//			table19113criteria3.addCell(cell19713criteria3);
//			table19113criteria3.addCell(cell19813criteria3);
//			document.add(table19113criteria3);
//			
//			
//			
//			document.close();
//			}
//			catch(Exception e) {
//	      e.printStackTrace();
//			}
//			
//			
//		
//		return file.toAbsolutePath().toString();
//	}
//	
//
//			
//}
