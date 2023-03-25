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
//import org.springframework.stereotype.Component;
//
//import com.adiverse.erp.model.Criteria5_FieldInfo;
//import com.adiverse.erp.model.Criteria5_FileUpload;
//import com.adiverse.erp.service.Criteria5Service;
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
//
//@Component
//public class AutonomousCriteria53Report 
//{
//	
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
//	
//	@Autowired
//	Criteria5Service service5;
//
//
//
//		///////////////////////////////////////////////////////////////////////////////////////////
//		// criteria 5 start here
//		//////////////////////////////////////////////////////////////////////////////////////////
//
//		//java.util.List<Criteria5_FieldInfo> criteria5List1 = service5.getAllCriteria5Data();
//
//		// criteria5Record1 = criteria5List1.get(0);
//
//		//java.util.List<Criteria5_FileUpload> criteria5file = criteria5Record1.getCriteria5FileUpload();
//
//		/*
//		 * Font font0 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * font0.setSize(16);
//		 * 
//		 * Font font1criteria5 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * font1criteria5.setSize(14);
//		 * 
//		 * Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * font2.setSize(12);
//		 * 
//		 * // Font font3=FontFactory.getFont(FontFactory.HELVETICA); //
//		 * font.setSize(16);
//		 * 
//		 * // Font font4=FontFactory.getFont(FontFactory.HELVETICA); //
//		 * font1.setSize(14);
//		 * 
//		 * Font font5criteria5 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * font5criteria5.setSize(12);
//		 */
//
//		
//		
//		
//		
//		
//		List<Criteria5_FieldInfo> criteria5List = null;
//		Criteria5_FieldInfo criteria5Record = null;
//		List<Criteria5_FileUpload> criterai5file = null;
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
//				criteria5List = service5.getAllCriteria5Data();
//				if (CollectionUtils.isNotEmpty(criteria5List)) {
//					criteria5Record = criteria5List.get(0);
//					criterai5file = criteria5Record.getCriteria5FileUpload();
//				} else {
//					criteria5Record = new Criteria5_FieldInfo();
//					criterai5file = new ArrayList<>();
//				}
//				System.out.println("report generation path from property file ==>" + reportGeneratePath);
//				if (root != null) {
//					SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//					String strDate = formatter.format(date);
//					reportPath = "AuthonomousCriteria5Report-" + strDate + ".pdf";
//					file = root.resolve(reportPath);
//				}
//				System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//				
//				
//				Document document = new Document(PageSize.A4);
//				// PdfWriter.getInstance(document, response.getOutputStream());
//				PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//				
//				document.open();
//				System.out.println("open the document==========>");
//		
//		
//		Paragraph paragraph0 = new Paragraph("Criterion 5 - Student Support and Progression\r\n\r\n", font1);
//		paragraph0.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//	
//document.add(paragraph0);
//		Paragraph paragraph04 = new Paragraph("5.3 Student Participation and Activities", font2);
//		paragraph04.setAlignment(Paragraph.ALIGN_LEFT);
//
//		document.add(paragraph04);
//
//		
//
//		Paragraph paragraph011 = new Paragraph(
//				"5.3.1 Number of awards/medals won by students for outstanding performance in sports/cultural activities at inter-university/state/national / international level (award for a team event should be counted as one) during the last five years.\r\n"
//						+ "Response:"
//						+ (criteria5Fieldinfo != null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse531()
//								: ""));
//		document.add(paragraph011);
//		Paragraph paragraph012 = new Paragraph(
//				"5.3.1.1 Number of awards/medals won by students for outstanding performance in sports / cultural activities at inter-university / state / national / international events (award for a team event should be counted as one) year - wise during the last five years.");
//
//		document.add(paragraph012);
//		if(criteria5Fieldinfo.getYearTable5311() !=null)
//		{
//
//		Table table5311 = new Table(criteria5Fieldinfo.getYearTable5311().size(), 2);
//
//		table5311.setPadding(10);
//		table5311.setWidth(100f);
//
//		for (int i = 0; i < criteria5Fieldinfo.getYearTable5311().size(); i++) {
//			table5311.addCell(criteria5Fieldinfo.getYearTable5311().get(i).getInput5311y());
//
//		}
//		for (int i = 0; i < criteria5Fieldinfo.getYearTable5311().size(); i++) {
//			table5311.addCell(criteria5Fieldinfo.getYearTable5311().get(i).getInput5311v());
//
//		}
//
//		document.add(table5311);
//			}
//
//		
//		PdfPTable table09criteria5 = new PdfPTable(2);
//		PdfPTable table91criteria5 = new PdfPTable(1);
//
//		// Setting width of table, its columns and spacing
//		table09criteria5.setWidthPercentage(100);
//		table91criteria5.setWidthPercentage(100);
//
//		PdfPCell cell67criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell68criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell69criteria5 = new PdfPCell(new Paragraph(
//				"Number of awards/medals for outstanding performance in sports/ cultural activities at inter- university / state / national / international level during the last five years\r\n\r\n\r\n"));
//		PdfPCell cell70criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : ""));
//		PdfPCell cell71criteria5 = new PdfPCell(new Paragraph("e-copies of award letters and certificates\r\n\r\n\r\n"));
//		PdfPCell cell72criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(1).getCriteria5FilePath() : ""));
//		PdfPCell cell73criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//		PdfPCell cell74criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(2).getCriteria5FilePath() : ""));
//
//		table09criteria5.addCell(cell67criteria5);
//		table09criteria5.addCell(cell68criteria5);
//		table09criteria5.addCell(cell69criteria5);
//		table09criteria5.addCell(cell70criteria5);
//		table09criteria5.addCell(cell71criteria5);
//		table09criteria5.addCell(cell72criteria5);
//		table09criteria5.addCell(cell73criteria5);
//		table09criteria5.addCell(cell74criteria5);
//		table09criteria5.setSpacingBefore(20f);
//		table09criteria5.setSpacingAfter(20f);
//		document.add(table09criteria5);
//		
//		
//		Paragraph paragraph0133 = new Paragraph(
//				"5.3.2 Presence of an active Student Council & representation of students on academic & administrative bodies/committees of the institution\r\n"
//						+ "\r\n\r\n" + "Response:"
//						+ (criteria5Fieldinfo!= null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQl().get(0).getResponse532()
//								: ""));
//		document.add(paragraph0133);
////		PdfPCell cell0120 = new PdfPCell(new Paragraph(
////				"Mother Teresa has a Student Council (SC) comprising nine members. In addition, various bodies constituted by the College also has student representatives. The SC under aegis of Dean, students affairs plans and organizes various co-curricular and extra-curricular activities of the college in association with the college academic committee. Towards this end, various designated committees, viz., Organizing committee, Reception committee, Hospitality committee, Technical Events committee, Campaigning/Public Relations committee, Discipline committee, Cultural programmes committee, Sports committee, Prize Distribution committee, Magazine committee and such others are involved in the organization of Orientation programmes, Fresher�s Day, Alphamatica, Bhaswara, Vaisheshika, Vibgyor and Vibes. In each committee, at least two student representatives/volunteers attend meetings as and when called for. In addition, Mother Teresa celebrates regional, national and international commemoration days and festivals wherein, SC members are involved in the smooth conduct of the events.\r\n"
////						+ "\r\n"
////						+ "SC also contributes to the enhancement of the learning experiences of students through various clubs, namely, Literary, Science, Coding, Mathematical, Fine arts, Photography, Solar, Robotics, Environment, and Srujanastra. Each club is managed by students with the help of a faculty advisor. Various events pertaining to the concerned club are organized after the college hours on regular working days, as well as on Saturdays. In addition, it also facilitates organization of various technical activities through professional bodies namely, Computer Society of India (CSI), Institute of Electrical and Electronic Engineers (IEEE), Institute of Electronics and Telecommunication Engineering (IETE), Indian Society for Technical Education (ISTE) and Society for Automotive Engineering (SAE).\r\n"
////						+ " \r\n"
////						+ "The SC assists in organizing NSS activities of the college, which include conducting various health camps, distribution of school uniforms, books etc for needy children of nearby villages, distribution of various items at old-age homes, facilitating training for development of vocational skills in the people in nearby places, etc.\r\n"
////						+ "\r\n"
////						+ "In addition to the above-mentioned activities, the SC provides necessary help by reaching out appropriate tutorials to the students studying in nearby schools. It also organizes awareness programmes on health, education and environment. In association with NGOs, the SC facilitates conduct of cataract surgeries, organizes blood donation, health/dental camps and distributes medicines. As part of environment campaign, Handmade paper bags were made and distributed, making them aware of the hazards of plastic usage and its consequent disastrous effects on environment. Towards the promotion of Green revolution, every year, SC organizes tree plantation programmes in the nearby villages.\r\n"
////						+ "\r\n"
////						+ "Student representatives are also nominated on the anti-ragging committee, grievance redressal cell and women protection cell. The Entrepreneurship development cell also has SC members with a faculty advisor, to organize various events under the National Entrepreneurship Network (NEN).\r\n"
////						+ "\r\n"
////						+ "IQAC has a representative each from students and alumni. BoS of each department consists of Alumni members.\r\n"
////						+ "Class Review Committees also have student representatives for obtaining feedback on the Teaching- Learning process.\r\n"
////						+ "\r\n"
////						+ "On the whole, the Students Council is a dynamic Body that contributes a great deal to the development of students and institution alike."
////						+ "",
////				font5));
//
////		table101criteria5.addCell(cell0119);
////		table101criteria5.addCell(cell0120);
//		
//		PdfPTable table010criteria5 = new PdfPTable(2);
//		PdfPTable table101criteria5 = new PdfPTable(1);
//
//		// Setting width of table, its columns and spacing
//		table010criteria5.setWidthPercentage(100);
//		table101criteria5.setWidthPercentage(100);
//
//		PdfPCell cell75criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell76criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell77criteria5 = new PdfPCell(new Paragraph("Upload any additional information"));
//		PdfPCell cell78criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(3).getCriteria5FilePath() : ""));
//		PdfPCell cell79criteria5 = new PdfPCell(new Paragraph("Paste link for Additional Information\r\n\r\n\r\n"));
//		PdfPCell cell80criteria5 = new PdfPCell(new Paragraph());
//
//		table010criteria5.addCell(cell75criteria5);
//		table010criteria5.addCell(cell76criteria5);
//		table010criteria5.addCell(cell77criteria5);
//		table010criteria5.addCell(cell78criteria5);
//		table010criteria5.addCell(cell79criteria5);
//		table010criteria5.addCell(cell80criteria5);
//
//
//		table010criteria5.setSpacingBefore(20f);
//		table010criteria5.setSpacingAfter(20f);
//
//		document.add(table010criteria5);
//		
//		
//		
//		
//
//
//		Paragraph paragraph0134 = new Paragraph(
//				"5.3.3 Average number of sports and cultural events / competitions organised by the institution per year\r\n"
//						+ "\r\n\r\n" + "Response: "
//						+ (criteria5Fieldinfo != null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse533()
//								: ""));
//		document.add(paragraph0134);
//		Paragraph paragraph0135 = new Paragraph(
//				"5.3.3.1 Number of sports and cultural events / competitions organised by the institution year - wise during the last five years.");
//		document.add(paragraph0135);
//
////		table121criteria5.addCell(cell0121);
////		table121criteria5.addCell(cell0122);
//
////		table121criteria5.addCell(table012criteria5);
//
//		
//		if(criteria5Fieldinfo.getYearTable5331() !=null)
//		{
//
//		Table table5331 = new Table(criteria5Fieldinfo.getYearTable5331().size(), 2);
//
//		table5331.setPadding(10);
//		table5331.setWidth(100f);
//
//		for (int i = 0; i < criteria5Fieldinfo.getYearTable5331().size(); i++) {
//			table5331.addCell(criteria5Fieldinfo.getYearTable5331().get(i).getInput5331y());
//
//		}
//		for (int i = 0; i < criteria5Fieldinfo.getYearTable5331().size(); i++) {
//			table5331.addCell(criteria5Fieldinfo.getYearTable5331().get(i).getInput5331v());
//
//		}
//
//		document.add(table5331);
//			}
//
//		
//
//		PdfPTable table012criteria5 = new PdfPTable(2);
//		PdfPTable table121criteria5 = new PdfPTable(1);
//
//		// Setting width of table, its columns and spacing
//		table012criteria5.setWidthPercentage(100);
//		table121criteria5.setWidthPercentage(100);
//
//		PdfPCell cell81criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//		PdfPCell cell82criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell83criteria5 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//		PdfPCell cell84criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(4).getCriteria5FilePath() : ""));
//		PdfPCell cell85criteria5 = new PdfPCell(new Paragraph("Report of the event\r\n\r\n\r\n"));
//		PdfPCell cell86criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(5).getCriteria5FilePath() : ""));
//		PdfPCell cell87criteria5 = new PdfPCell(
//				new Paragraph("Number of sports and cultural events / competitions organised per year\r\n\r\n\r\n"));
//		PdfPCell cell88criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(6).getCriteria5FilePath() : ""));
//
//		table012criteria5.addCell(cell81criteria5);
//		table012criteria5.addCell(cell82criteria5);
//		table012criteria5.addCell(cell83criteria5);
//		table012criteria5.addCell(cell84criteria5);
//		table012criteria5.addCell(cell85criteria5);
//		table012criteria5.addCell(cell86criteria5);
//		table012criteria5.addCell(cell87criteria5);
//		table012criteria5.addCell(cell88criteria5);
//		table012criteria5.setSpacingBefore(20f);
//		table012criteria5.setSpacingAfter(20f);
//
//		document.add(table012criteria5);
//		
//		document.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return file.toAbsolutePath().toString();
//		}
//
//}
