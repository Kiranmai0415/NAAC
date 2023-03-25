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
//import com.adiverse.erp.model.Criteria2_FieldInfo;
//import com.adiverse.erp.model.Criteria2_FileUpload;
//import com.adiverse.erp.model.Criteria4_FieldInfo;
//import com.adiverse.erp.model.Criteria4_FileUpload;
//import com.adiverse.erp.service.Criteria2Service;
//import com.adiverse.erp.service.Criteria4Service;
//import com.lowagie.text.Chunk;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.Image;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.CMYKColor;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//@Service
//public class AffiliatedCriteria44Report {
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
//	Criteria4Service service4;
//	
//	List<Criteria4_FieldInfo> criteria4List = null;
//	Criteria4_FieldInfo criteria4Record = null;
//	List<Criteria4_FileUpload> criteria4file = null;
//	
//	
//	public String generateReport(Criteria4_FieldInfo criteria4Fieldinfo) throws DocumentException, IOException {
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
//			criteria4List = service4.getAllCriteria4Data();
//			if (CollectionUtils.isNotEmpty(criteria4List)) {
//				criteria4Record = criteria4List.get(0);
//				criteria4file = criteria4Record.getCriteria4FileUpload();
//			} else {
//				criteria4Record = new Criteria4_FieldInfo();
//				criteria4file = new ArrayList<>();
//			}
//			  if (root != null) {
//					SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//					String strDate = formatter.format(date);
//					reportPath = "AffiliatedCriteria4Report-" + strDate + ".pdf";
//					file = root.resolve(reportPath);
//				}
//			
//			Document document = new Document(PageSize.A4);
//			// PdfWriter.getInstance(document, response.getOutputStream());
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>");
//			
//			Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources", font1);
//			paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph1criteria4);
//
//
//			
/////////////////////////////////////////////////////////////////////////		
//
//			Paragraph paragraph50 = new Paragraph("4.4 Maintenance of Campus Infrastructure\r\n\r\n\r\n" + "", font2);
//			paragraph50.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph50);
//
//			
//			
//			PdfPTable table25criteria4 = new PdfPTable(1);
//			table25criteria4.setWidthPercentage(100);
//			
//			
//			
//
//
//
////			table25criteria4.addCell(
////					"4.4.1 Average percentage of expenditure incurred on maintenance of infrastructure (physical and\r\n"
////					+ "academic support facilities) excluding salary component during the last five years(INR in Lakhs)\r\n\r\n"
////							+ " Response: "
////							+ (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse441()
////									: ""));
//			Paragraph paragraph51 = new Paragraph(
//					"4.4.1 Average percentage of expenditure incurred on maintenance of infrastructure (physical and"
//					+"academic support facilities) excluding salary component during the last five years(INR in Lakhs) \r\n\r\n" + "Response:");
//			document.add(paragraph51);
//			
//			
//			Paragraph paragraph52 = new Paragraph(criteria4Record != null
//							? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse441(): "");
//			document.add(paragraph52);
//			
//			Paragraph paragraph53 = new Paragraph("4.4.1.1: Expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component year wise during the last five years (INR in lakhs)");
//					
//				document.add(paragraph53);
//				
//				
//				
//				if (criteria4Fieldinfo.getYearTable4411() != null) {
//
//					Table table4411 = new Table(criteria4Fieldinfo.getYearTable4411().size(), 2);
//
//					table4411.setPadding(10);
//					table4411.setWidth(100f);
//
//					for (int i = 0; i < criteria4Fieldinfo.getYearTable4411().size(); i++) {
//						table4411.addCell(criteria4Fieldinfo.getYearTable4411().get(i).getInput4411y());
//
//					}
//					for (int i = 0; i < criteria4Fieldinfo.getYearTable4411().size(); i++) {
//						table4411.addCell(criteria4Fieldinfo.getYearTable4411().get(i).getInput4411v());
//
//					}
//
//					document.add(table4411);
//
//				}
//				
//				
//				if (criteria4Fieldinfo.getYearTable4411() != null) {
//
//					Table table4411 = new Table(criteria4Fieldinfo.getYearTable4411().size(), 2);
//
//					table4411.setPadding(10);
//					table4411.setWidth(100f);
//
//					for (int i = 0; i < criteria4Fieldinfo.getYearTable4411().size(); i++) {
//						table4411.addCell(criteria4Fieldinfo.getYearTable4411().get(i).getInput4411y());
//
//					}
//					for (int i = 0; i < criteria4Fieldinfo.getYearTable4411().size(); i++) {
//						table4411.addCell(criteria4Fieldinfo.getYearTable4411().get(i).getInput4411v());
//
//					}
//
//					document.add(table4411);
//
//				}
//				
//				
//				
//				
//				PdfPTable table26criteria4 = new PdfPTable(2);
//				table26criteria4.setWidthPercentage(100);
//
//				PdfPCell cell00123 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//				PdfPCell cell00124 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//				PdfPCell cell00125 = new PdfPCell(new Paragraph(
//						"Upload any additional information\r\n "));
//				PdfPCell cell00126 = new PdfPCell(
//						new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//				PdfPCell cell00127 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n "));
//				PdfPCell cell00128 = new PdfPCell(
//						new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//				PdfPCell cell00129 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n "));
//				PdfPCell cell00130 = new PdfPCell(
//						new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//
//				table26criteria4.addCell(cell00123);
//				table26criteria4.addCell(cell00124);
//				table26criteria4.addCell(cell00125);
//				table26criteria4.addCell(cell00126);
//				table26criteria4.addCell(cell00127);
//				table26criteria4.addCell(cell00128);
//				table26criteria4.addCell(cell00129);
//				table26criteria4.addCell(cell00130);
//				
//				
//
//				document.add(table26criteria4);
//				
//				document.close();
//				
//				
//				
//				
//					
////			
////			table25criteria4.addCell(cell43001criteria4);
////			table25criteria4.addCell(
////					 (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQn().get(0).getInput441t1()
////									: ""));
////
////			table25criteria4.addCell(
////					"4.4.1.1 Expenditure incurred on maintenance of infrastructure (physical facilities and academic\r\n"
////					+ "support facilities) excluding salary component year-wise during the last five years (INR in lakhs)\r\n\r\n");
////
////			// table25.addCell(table24);
////
////			table25criteria4.setSpacingBefore(20f);
////			table25criteria4.setSpacingAfter(20f);
////
////			document.add(table25criteria4);
////			
////			//YEAR TABLE 4411
////
////			if (criteria4Record != null) {
////
////				Table table4411 = new Table(criteria4Record.getYearTable4411().size(), 2);
////
////				table4411.setPadding(10);
////				table4411.setWidth(100f);
////
////				for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
////					table4411.addCell(criteria4Record.getYearTable4411().get(i).getInput4411y());
////
////				}
////				for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
////					table4411.addCell(criteria4Record.getYearTable4411().get(i).getInput4411v());
////
////				}
////
////				document.add(table4411);
////
////			}
////
////			PdfPTable table26criteria4 = new PdfPTable(2);
////			table26criteria4.setWidthPercentage(100);
////
////			PdfPCell cell00123 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
////			PdfPCell cell00124 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
////			PdfPCell cell00125 = new PdfPCell(new Paragraph(
////					"Details about assigned budget and expenditure on physical facilities and academic facilities\r\n\r\n\r\n "));
////			PdfPCell cell00126 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(23).getCriteria4FilePath() : ""));
////			PdfPCell cell00127 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n\r\n "));
////			PdfPCell cell00128 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(24).getCriteria4FilePath() : ""));
////
////			table26criteria4.addCell(cell00123);
////			table26criteria4.addCell(cell00124);
////			table26criteria4.addCell(cell00125);
////			table26criteria4.addCell(cell00126);
////			table26criteria4.addCell(cell00127);
////			table26criteria4.addCell(cell00128);
////
////			document.add(table26criteria4);
////
////			/*
////			 * Font fontParagraph47 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph47.setSize(12);
////			 
////
////			Paragraph paragraph51 = new Paragraph(
////					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\r\n"
////							+ "\r\n" + "Response:"
////							+ (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse442()
////									: ""),
////					font2);
////
////			PdfPTable table442criteria4 = new PdfPTable(1);
////
////			// Setting width of table, its columns and spacing
////			table442criteria4.setWidthPercentage(100);
////
////			table442criteria4.addCell(
////					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\\r\\n\"\r\n"
////							+ "\r\n\r\n" + "Response:"
////							+ (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse442()
////									: ""));
////			// table442criteria4.addCell(criteria4List.get(0).getResponseValue442());
////			document.add(table442criteria4);
////
////			table442criteria4.setSpacingBefore(20f);
////			table442criteria4.setSpacingAfter(20f);
////
////			paragraph51.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			/*
////			 * Font fontParagraph48 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph48.setSize(12);
////			 
////
////			Paragraph paragraph52 = new Paragraph(
////					" The Maintenance Cell of the college ensures proper functioning of all civil, electrical, water, sewage, environment, and other facilities through frequent inspections and need-based maintenance works. A central complaint register is maintained, and the maintenance cell attends to those complaints on a priority basis. A vast majority of minor and major repairs are carried out internally, while some major repairs are outsourced. The maintenance cell is headed by the Registrar/Dean-Administration. The other members of the cell include Administrative Maintenance in-charge, Head of EEE department, and two senior faculty members, one each from Civil Engineering and Mechanical Engineering departments. The members of the cell meet based on the need and review the requirements to chalk out further action to be taken. The cell also arranges to conduct energy audit. Staff belonging to the maintenance cell perform routine cleaning of the water tanks, water coolers, filters, etc. as per schedule. Preventive maintenance of the equipment is a regular practice in all laboratories apart from breakdown maintenance. Gardeners and janitors conduct regular cleaning of the campus premises and restrooms twice a day.\r\n"
////							+ "\r\n"
////							+ "The regular maintenance of all the seminar halls of the institution, Open air auditorium, Portico of Block-2, open air grounds, playground etc. are supervised by the Administrative Officer. The Faculty/students put a letter in the prescribed format (mentioning the date and time of requirement) seeking the allocation of the required physical facility for the respective events to be organized. After the allocation as per the availability, such information is entered in a register kept with the Administrative officer.\r\n"
////							+ "\r\n"
////							+ "All OHP/LCD projectors in the institution, furniture available in the classroom, faculty/staff rooms are regularly monitored on a fortnightly basis for maintenance.\r\n"
////							+ "\r\n"
////							+ "Each laboratory maintains a stock register for detailing the proper lab records. The lab stock register holds\r\n"
////							+ " \r\n"
////							+ "the complete details of lab equipment, new arrivals, replacements of old equipment, maintenance details, license details etc. Each lab is associated with a qualified Technical Staff for maintenance of all lab equipment. Any major repair of equipment beyond the scope of technical staff is outsourced. Obsolete and irreparable equipment is weeded out on regular basis. A register for �Lab equipment Repair/ Maintenance� is kept in each lab to track the breakdown time of equipment and the maintenance details. A minimum of 20% to 30% of unutilized lab slots per week are allotted for regular maintenance works of the laboratories.\r\n"
////							+ "\r\n"
////							+ "The college has a central computing facility located in the library building, which is also used for browsing and accessing electronic content of learning resources.\r\n"
////							+ "\r\n"
////							+ "The institution has established a separate maintenance cell, responsible for the maintenance works of computers, Hardware and software installations/up-gradations, wi-fi and internet maintenance. The cell is chaired by a senior faculty from Computer Science Engineering department who supervises the supporting staff required for this purpose.\r\n"
////							+ "",
////					font5);
////			paragraph52.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			document.add(paragraph51);
////			document.add(paragraph52);*/
////
////			PdfPTable table27criteria4 = new PdfPTable(2);
////			table27criteria4.setWidthPercentage(100);
////			PdfPTable table270criteria4 = new PdfPTable(1);
////			table270criteria4.setWidthPercentage(100);
////
////			PdfPCell cell00129 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
////			PdfPCell cell00130 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
////			PdfPCell cell00131 = new PdfPCell(new Paragraph("upload any additional information\r\n\r\n\r\n"));
////			PdfPCell cell00132 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(25).getCriteria4FilePath() : ""));
////
////			table27criteria4.addCell(cell00129);
////			table27criteria4.addCell(cell00130);
////			table27criteria4.addCell(cell00131);
////			table27criteria4.addCell(cell00132);
////			table270criteria4.addCell("4.4.2 There are established systems and procedures for maintaining and\r\n"
////					+ "utilizing physical, academic and support facilities - laboratory, library, sports\r\n"
////					+ "complex, computers, classrooms etc.\r\n"
////					+ "Response:"+(criteria4Record != null
////					? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse442()
////					:""));
////			
////			table270criteria4.addCell("The Maintenance Cell of the college ensures proper functioning of all civil, electrical, water,\r\n"
////					+ "sewage, environment, and other facilities through frequent inspections and need-based\r\n"
////					+ "maintenance works. A central complaint register is maintained, and the maintenance cell attends\r\n"
////					+ "to those complaints on a priority basis. A vast majority of minor and major repairs are carried out\r\n"
////					+ "internally, while some major repairs are outsourced. The maintenance cell is headed by the\r\n"
////					+ "Registrar/Dean-Administration. The other members of the cell include Administrative Maintenance\r\n"
////					+ "in-charge, Head of EEE department, and two senior faculty members, one each from Civil\r\n"
////					+ "Engineering and Mechanical Engineering departments. The members of the cell meet based on\r\n"
////					+ "the need and review the requirements to chalk out further action to be taken. The cell also\r\n"
////					+ "arranges to conduct energy audit. Staff belonging to the maintenance cell perform routine cleaning\r\n"
////					+ "of the water tanks, water coolers, filters, etc. as per schedule. Preventive maintenance of the\r\n"
////					+ "equipment is a regular practice in all laboratories apart from breakdown maintenance. Gardeners\r\n"
////					+ "and janitors conduct regular cleaning of the campus premises and restrooms twice a day.\r\n"
////					+ "The regular maintenance of all the seminar halls of the institution, Open air auditorium, Portico of\r\n"
////					+ "Block-2, open air grounds, playground etc. are supervised by the Administrative Officer. The\r\n"
////					+ "Faculty/students put a letter in the prescribed format (mentioning the date and time of\r\n"
////					+ "requirement) seeking the allocation of the required physical facility for the respective events to be\r\n"
////					+ "organized. After the allocation as per the availability, such information is entered in a register kept\r\n"
////					+ "with the Administrative officer.All OHP/LCD projectors in the institution, furniture available in the classroom, faculty/staff rooms\r\n"
////					+ "are regularly monitored on a fortnightly basis for maintenance.\r\n"
////					+ "Each laboratory maintains a stock register for detailing the proper lab records. The lab stock\r\n"
////					+ "register holds\r\n"
////					+ "the complete details of lab equipment, new arrivals, replacements of old equipment, maintenance\r\n"
////					+ "details, license details etc. Each lab is associated with a qualified Technical Staff for maintenance\r\n"
////					+ "of all lab equipment. Any major repair of equipment beyond the scope of technical staff is\r\n"
////					+ "outsourced. Obsolete and irreparable equipment is weeded out on regular basis. A register for Lab\r\n"
////					+ "equipment Repair/ Maintenance is kept in each lab to track the breakdown time of equipment and\r\n"
////					+ "the maintenance details. A minimum of 20% to 30% of unutilized lab slots per week are allotted for\r\n"
////					+ "regular maintenance works of the laboratories.\r\n"
////					+ "The college has a central computing facility located in the library building, which is also used for\r\n"
////					+ "browsing and accessing electronic content of learning resources.\r\n"
////					+ "The institution has established a separate maintenance cell, responsible for the maintenance\r\n"
////					+ "works of computers, Hardware and software installations/up-gradations, wi-fi and internet\r\n"
////					+ "maintenance. The cell is chaired by a senior faculty from Computer Science Engineering\r\n"
////					+ "department who supervises the supporting staff required for this purpose.\r\n"
////					+ "");
////			
////			table270criteria4.addCell(table27criteria4);
////
////			table270criteria4.setSpacingBefore(20f);
////			table270criteria4.setSpacingAfter(20f);
////
////			document.add(table270criteria4);
////			
////       document.close();
////		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//	}
//	
//
//
//}
