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
//import javax.print.Doc;
//
//import org.apache.commons.collections4.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.adiverse.erp.model.Criteria6_FieldInfo;
//import com.adiverse.erp.model.Criteria6_FileUpload;
//import com.adiverse.erp.service.Criteria6Service;
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
//public class AutonomousCriteria63Report {
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//	@Autowired
//	Criteria6Service service6;
//	
//	
//	
//	
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//	
//	
//
//	List<Criteria6_FieldInfo> criteria6List = null;
//	Criteria6_FieldInfo criteria6Record = null;
//	List<Criteria6_FileUpload> criteria6file = null;
//	
//
//public String generateReport(Criteria6_FieldInfo criteria6Fieldinfo) throws DocumentException, IOException {
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
//			criteria6List = service6.getAllCriteria6Data();
//			if (CollectionUtils.isNotEmpty(criteria6List)) {
//				criteria6Record = criteria6List.get(0);
//				criteria6file = criteria6Record.getCriteria6FileUpload();
//			} else {
//				criteria6Record = new Criteria6_FieldInfo();
//				criteria6file = new ArrayList<>();
//			}
//
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AutonomousCriteria6Report-" + strDate + ".pdf";
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
//			Paragraph paragraph1criteria6 = new Paragraph("Criterion 6 - Governance, Leadership and Management\r\n", font1);
//			paragraph1criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph1criteria6);
//
//			/*
//			 * com.lowagie.text.Font fontTitle0 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle0.setSize(12);
//			 */
//
//
//	//paragraph 6.3
//			Paragraph paragraph12criteria6 = new Paragraph("6.3  Faculty Empowerment Strategies\r\n", font3);
//			paragraph12criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph12criteria6);
//			Paragraph paragraph12criteria611 = new Paragraph("6.3.1: The institutional Strategic/ Perspective plan is effectively deployed"+"Response:");
//			document.add(paragraph12criteria611);
//			PdfPTable table6criteria61 = new PdfPTable(2);
//			table6criteria61.setWidthPercentage(100);
//			PdfPTable table61criteria61 = new PdfPTable(1);
//			table61criteria61.setWidthPercentage(100);
//
//			PdfPCell cell61criteria61 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell62criteria61 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell63criteria61 = new PdfPCell(new Paragraph("Strategic Plan and deployment documents on the website\r\n\r\n"));
//			PdfPCell cell64criteria61 = new PdfPCell(
//					new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell65criteria61 = new PdfPCell(new Paragraph("Paste link for additional Information\n\r\n"));
//			PdfPCell cell66criteria61 = new PdfPCell(new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell65criteria611 = new PdfPCell(new Paragraph("Upload any additional information\n\r\n"));
//			PdfPCell cell66criteria611= new PdfPCell(new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			table6criteria61.addCell(cell61criteria61);
//			table6criteria61.addCell(cell62criteria61);
//			table6criteria61.addCell(cell63criteria61);
//			table6criteria61.addCell(cell64criteria61);
//			table6criteria61.addCell(cell65criteria61);
//			table6criteria61.addCell(cell65criteria611);
//			table6criteria61.addCell(cell66criteria611);
//			
//			table6criteria61.addCell(cell66criteria61);
//			table6criteria61.addCell(cell66criteria61);
//			document.add(table6criteria61);
//			
//			
//			
//			
//	// create table6
//			PdfPTable table6criteria6 = new PdfPTable(2);
//			table6criteria6.setWidthPercentage(100);
//			PdfPTable table61criteria6 = new PdfPTable(1);
//			table61criteria6.setWidthPercentage(100);
//
//			PdfPCell cell61criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell62criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell63criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell64criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell65criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell66criteria6 = new PdfPCell(new Paragraph(""));
//			table6criteria6.addCell(cell61criteria6);
//			table6criteria6.addCell(cell62criteria6);
//			table6criteria6.addCell(cell63criteria6);
//			table6criteria6.addCell(cell64criteria6);
//			table6criteria6.addCell(cell65criteria6);
//			table6criteria6.addCell(cell66criteria6);
////			PdfPCell cell61x = new PdfPCell(new Paragraph(
////					"6.3.1 The institution has effective welfare measures for teaching and non-teaching staff and avenues for career development/ progression\r\n"
////							+ "\r\n" + "\r\n" + "Response:"
////							+ (criteria6Fieldinfo != null
////									? criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse631()
////									: ""),
////					font3));
////			table61criteria6.addCell(cell61x);
////			table61criteria6.addCell(
////					"Mother Teresa is more than sensitive to reaching out welfare measures to both, our Faculty and the administrative/support Staff. The following welfare schemes/benefits are offered by the institution:\r\n"
////							+ "\r\n" + "");
////			table61criteria6.addCell(
////					" *  Financial incentives are given for faculty for research publications and Books/Book chapters :\r\n"
////							+ "\r\n" + " *  Full financial support for filing patents\r\n"
////							+ " *  Free Medical facility at the institution\r\n"
////							+ " *  Free transport to administrative staff.\r\n"
////							+ " *  Vehicles, and bus passes to Messengers.\r\n"
////							+ " *  Public transport bus passes to all drivers.\r\n"
////							+ " *  Need Based financial assistance to staff.\r\n"
////							+ " *  Cell-Phones and Laptops to HoDs for better connectivity and networking.\r\n"
////							+ " *  CLs, HPLs, CCL, Medical Leave and Examination Leaves as per their eligibility.\r\n"
////							+ " *  Paid Maternity Leave for female employees.\r\n"
////							+ " *  Special leave to staff on the occasion of their marriage.\r\n"
////							+ " *  Health Awareness camps within campus and Free Medical Check-ups.\r\n"
////							+ " *  Uniforms, washing allowance for Attendants, Ayahs and Drivers.\r\n"
////							+ " *  Paid leave @ one day/Week as incentive to faculty pursuing part-time Ph.D and conducting consultancy\r\n"
////							+ " *  Study/sabbatical leave for faculty pursuing full-time Ph.D.\r\n"
////							+ " *  Paid leave for faculty attending MOOCs certification examination and reimbursement of examination fee.\r\n"
////							+ " *  Paid leave with registration fee to attend FDPs/Conferences.\r\n"
////							+ " *  Supporting faculty pursuing research through Creation of required facilities as per their request.\r\n"
////							+ " *  ESI benefit to attenders, Ayahs, drivers, gardeners, and admin assistants.\r\n"
////							+ " *  Salary advances for faculty and staff in times of need." + "");
////
////			table61criteria6.addCell(table6criteria6);
//			document.add(table61criteria6);
//
//	//create a table7
//			PdfPTable table7criteria6 = new PdfPTable(2);
//			table7criteria6.setWidthPercentage(100);
//			PdfPTable table71criteria6 = new PdfPTable(2);
//			table71criteria6.setWidthPercentage(100);
//			PdfPCell cell71criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell72criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell73criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell74criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell75criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell76criteria6 = new PdfPCell(new Paragraph(""));
//			table7criteria6.addCell(cell71criteria6);
//			table7criteria6.addCell(cell72criteria6);
//			table7criteria6.addCell(cell73criteria6);
//			table7criteria6.addCell(cell74criteria6);
//			table7criteria6.addCell(cell75criteria6);
//			table7criteria6.addCell(cell76criteria6);
//
//			Paragraph paragraph1criteria611 = new Paragraph(
//					"6.3.2 Average percentage of teachers provided with financial support to attend conferences / workshops and towards membership fee of professional bodies during the last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria6Fieldinfo != null
//									? criteria6Fieldinfo.getCriteria6FieldInfoQn().get(0).getResponse632()
//									: ""));
//			document.add(paragraph1criteria611);
//			Paragraph paragraph1criteria612 = new Paragraph(
//					"6.3.2.1 Number of teachers provided with financial support to attend conferences/workshops and towards membership fee of professional bodies year wise during the last five years"
//							+ "");
//document.add(paragraph1criteria612);
//
//if (criteria6Fieldinfo.getYearTable6321() != null) {
//
//	Table table6331criteria6 = new Table(criteria6Fieldinfo.getYearTable6321().size(), 2);
//
//	table6331criteria6.setPadding(10);
//	table6331criteria6.setWidth(100f);
//
//	for (int i = 0; i < criteria6Fieldinfo.getYearTable6321().size(); i++) {
//		table6331criteria6.addCell(criteria6Fieldinfo.getYearTable6321().get(i).getInput6321y());
//	}
//	for (int i = 0; i < criteria6Fieldinfo.getYearTable6321().size(); i++) {
//		table6331criteria6.addCell(criteria6Fieldinfo.getYearTable6321().get(i).getInput6321v());
//	}
//
//	document.add(table6331criteria6);
//}
////			table7criteria6.addCell(cell7x);
////			table7criteria6.addCell(cell7y);
//			document.add(table7criteria6);
//
//	//cretae table 6321
//
//			/*
//			 * Table table6321criteria6 = new
//			 * Table(criteria6Record.getYearTable6321().size(), 2);
//			 * 
//			 * table6321criteria6.setPadding(10); table6321criteria6.setWidth(100f);
//			 * 
//			 * for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
//			 * table6321criteria6.addCell(criteria6Record.getYearTable6321().get(i).
//			 * getInput6321y()); } for (int i = 0; i <
//			 * criteria6Record.getYearTable6331().size(); i++) {
//			 * table6321criteria6.addCell(criteria6Record.getYearTable6321().get(i).
//			 * getInput6321v()); }
//			 * 
//			 * document.add(table6321criteria6);
//			 */
//			table71criteria6.setSpacingAfter(10f);
//
//	//create table 8
//			PdfPTable table8criteria6 = new PdfPTable(1);
//			table8criteria6.setWidthPercentage(100);
//			PdfPTable table81criteria6 = new PdfPTable(2);
//			table81criteria6.setWidthPercentage(100);
//			PdfPCell cell81criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n\r\n", font3));
//			PdfPCell cell82criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell83criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell84criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell85criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell86criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			table81criteria6.addCell(cell81criteria6);
//			table81criteria6.addCell(cell82criteria6);
//			table81criteria6.addCell(cell83criteria6);
//			table81criteria6.addCell(cell84criteria6);
//			table81criteria6.addCell(cell85criteria6);
//			table81criteria6.addCell(cell86criteria6);
////
////			PdfPCell cell8x = new PdfPCell(new Paragraph(
////					"6.3.3 Average number of professional development / administrative training Programmes organized by the institution for teaching and non-teaching staff during the last five years.\r\n"
////							+ "\r\n" + "Response:"
////							+ (criteria6Fieldinfo != null
////									? criteria6Fieldinfo.getCriteria6FieldInfoQn().get(0).getResponse633()
////									: ""),
////					font3));
//			PdfPCell cell21y = new PdfPCell(new Paragraph("6.3.3: The institution provides seed money to its teachers for research."));
//			document.add(cell21y);
//			PdfPCell cell22y = new PdfPCell(new Paragraph((criteria6Fieldinfo != null
//					? criteria6Fieldinfo.getCriteria6FieldInfoQn().get(0).getResponse633()
//					: "")));
//			document.add(cell22y);
//
//			PdfPCell cell8y = new PdfPCell(new Paragraph(
//					"6.3.3.1: The amount of seed money provided by institution to its teachers for research year wise during last five years (INR in lakhs"
//							+ "",
//					font3));
//
//		//table8criteria6.addCell(cell8x);
//			table8criteria6.addCell(cell8y);
//			document.add(cell8y);
//			document.add(table8criteria6);
//	//create year table 6331
//			if (criteria6Fieldinfo != null) {
//
//				Table table6331criteria6 = new Table(criteria6Record.getYearTable6331().size(), 2);
//
//				table6331criteria6.setPadding(10);
//				table6331criteria6.setWidth(100f);
//
//				for (int i = 0; i < criteria6Fieldinfo.getYearTable6331().size(); i++) {
//					table6331criteria6.addCell(criteria6Fieldinfo.getYearTable6331().get(i).getInput6331y());
//				}
//				for (int i = 0; i < criteria6Fieldinfo.getYearTable6331().size(); i++) {
//					table6331criteria6.addCell(criteria6Fieldinfo.getYearTable6331().get(i).getInput6331v());
//				}
//
//				document.add(table6331criteria6);
//			}
//			table81criteria6.setSpacingAfter(10f);
//			document.add(table81criteria6);
//	//cretae table 9
//			PdfPTable table9criteria6 = new PdfPTable(1);
//			table9criteria6.setWidthPercentage(100);
//			PdfPTable table91criteria6 = new PdfPTable(2);
//			table91criteria6.setWidthPercentage(100);
//			PdfPCell cell91criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell92criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell93criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell94criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell95criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell96criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell97criteria6 = new PdfPCell(new Paragraph("Minutes of the relevant bodies of the Institution\r\n"));
//			PdfPCell cell98criteria6 = new PdfPCell(new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell97criteria61 = new PdfPCell(new Paragraph("Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n"));
//			PdfPCell cell98criteria61 = new PdfPCell(new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell97criteria611 = new PdfPCell(new Paragraph("List of teachers receiving grant and details of grant received (Data Template)\r\n"));
//			PdfPCell cell98criteria611 = new PdfPCell(new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			table91criteria6.addCell(cell91criteria6);
//			table91criteria6.addCell(cell92criteria6);
//			table91criteria6.addCell(cell93criteria6);
//			table91criteria6.addCell(cell94criteria6);
//			table91criteria6.addCell(cell95criteria6);
//			table91criteria6.addCell(cell96criteria6);
//			table91criteria6.addCell(cell97criteria6);
//			table91criteria6.addCell(cell98criteria6);
//			table91criteria6.addCell(cell97criteria61);
//			table91criteria6.addCell(cell98criteria61);
//			table91criteria6.addCell(cell97criteria611);
//			table91criteria6.addCell(cell98criteria611);
//
////			PdfPCell cell9x = new PdfPCell(new Paragraph(
////					"6.3.4 Average percentage of teachers undergoing online/ face-to-face Faculty Development Programmes (FDP)during the last five years (Professional Development Programmes, Orientation / Induction Programmes, Refresher Course, Short Term Course ).\r\n"
////							+ "\r\n" + "Response:"
////							+ (criteria6Fieldinfo != null
////									? criteria6Fieldinfo.getCriteria6FieldInfoQn().get(0).getResponse634()
////									: ""),
////					font3));
//			Paragraph paragraph1criteria613= new Paragraph("6.3.4: The institution provides seed money to its teachers for research.\r\n");
//			document.add(paragraph1criteria613);
//			Paragraph paragraph1criteria614= new Paragraph((criteria6Fieldinfo != null
//					? criteria6Fieldinfo.getCriteria6FieldInfoQn().get(0).getResponse634()
//					: ""));
//			document.add(paragraph1criteria614);
//			
//			
//			Paragraph paragraph1criteria615= new Paragraph(
//					"6.3.4.1: The amount of seed money provided by institution to its teachers for research year wise during last five years (INR in lakhs)"
//							+ "",
//					font3);
//			document.add(paragraph1criteria615);
//			
////			table9criteria6.addCell(cell9x);
////			table9criteria6.addCell(cell9y);
////			document.add(table9criteria6);
//	//create table 6341
//			if (criteria6Fieldinfo != null) {
//
//				Table table6341criteria6 = new Table(criteria6Fieldinfo.getYearTable6341().size(), 2);
//
//				table6341criteria6.setPadding(10);
//				table6341criteria6.setWidth(100f);
//
//				for (int i = 0; i < criteria6Fieldinfo.getYearTable6341().size(); i++) {
//					table6341criteria6.addCell(criteria6Fieldinfo.getYearTable6341().get(i).getInput6341y());
//				}
//				for (int i = 0; i < criteria6Fieldinfo.getYearTable6341().size(); i++) {
//					table6341criteria6.addCell(criteria6Fieldinfo.getYearTable6341().get(i).getInput6341v());
//				}
//
//				document.add(table6341criteria6);
//			}
//			table91criteria6.setSpacingAfter(10f);
//			document.add(table91criteria6);
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
//
//
