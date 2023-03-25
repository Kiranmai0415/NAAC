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
//import com.adiverse.erp.model.Criteria7_FieldInfo;
//import com.adiverse.erp.model.Criteria7_FileUpload;
//import com.adiverse.erp.service.Criteria7Service;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.pdf.CMYKColor;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//@Service
//public class AutonomousCriteria71Report {
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//	@Autowired
//	Criteria7Service service7;
//	
//	
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//	
//	
//	List<Criteria7_FieldInfo> criteria7List = null;
//	Criteria7_FieldInfo criteria7Record = null;
//	List<Criteria7_FileUpload> criteria7file = null;
//	
//
//public String generateReport(Criteria7_FieldInfo criteria7Fieldinfo) throws DocumentException, IOException {
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
//			criteria7List = service7.getAllCriteria7Data();
//			if (CollectionUtils.isNotEmpty(criteria7List)) {
//				criteria7Record = criteria7List.get(0);
//				criteria7file = criteria7Record.getCriteria7FileUpload();
//			} else {
//				criteria7Record = new Criteria7_FieldInfo();
//				criteria7file = new ArrayList<>();
//
//			}
//
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AuthonomousCriteria7Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//				
//			
//		
//			Document document = new Document(PageSize.A4);
//
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>");
//	
//			
//
//			Paragraph paragraphcriteria7 = new Paragraph("Criterion 7 - Institutional Values and Best Practices\r\n\r\n",
//					font1);
//			paragraphcriteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			PdfPCell cell5criteria7 = new PdfPCell();
//			cell5criteria7.setPadding(5);
//			document.add(cell5criteria7);
//
//		
//			document.add(paragraphcriteria7);
//			Paragraph paragraph2criteria7 = new Paragraph("7.1 Institutional Values and Social Responsibilities\r\n\r\n", font2);
//			paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			
//			document.add(paragraph2criteria7);
////			Paragraph paragraph3criteria7 = new Paragraph(
////					"7.1.1 Measures initiated by the Institution for the promotion of gender equity during the last five years.\r\n",
////					font3);
////			paragraph3criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			PdfPTable table711criteria7 = new PdfPTable(1);
//			table711criteria7.setWidthPercentage(100f);
//
////
//			PdfPCell cell711criteria7 = new PdfPCell(new Paragraph(
//					"7.1.1	Measures initiated by the Institution for the promotion of gender equity during the last five years.\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse711()
//									: ""),
//					font3));
//
//		table711criteria7.addCell(cell711criteria7);
//			table711criteria7.setSpacingBefore(20f);
//			table711criteria7.setSpacingAfter(20f);
//
//			document.add(table711criteria7);
//
//			// paragaph3
//			//document.add(paragraph3criteria7);
//			/*
//			 * Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph.setSize(12);
//			 */
////
////			Paragraph paragraph4criteria7 = new Paragraph("Response:"
////					+ (criteria7Fieldinfo != null ? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse711()
////							: ""),
////					font3);
////			paragraph4criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			
////			document.add(paragraph4criteria7);
//			// paragraph 4
//
//		
//
//			/*
//			 * Font fontParagraph4criteria7 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph4criteria7.setSize(12);
//			 */
////			Paragraph paragraph5criteria7 = new Paragraph(
////					"Mother Teresa has zero tolerance to any kind of discrimination and follows an inclusive policy in all its endeavors, without any bias to gender, caste, religion, language and any such others.\r\n",
////					font5);
////			paragraph5criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			PdfPCell cell1criteria7 = new PdfPCell();
////			document.add(paragraph5criteria7);
//			//cell1criteria7.setPadding(5);
//			// paragraph5
//			/*
//			 * Font fontParagraph2criteria7 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2criteria7.setSize(12);
//			 */
////			Paragraph paragraph6criteria7 = new Paragraph(
////					"A. Activities to promote Gender Equity and gender sensitization:\r\n", font3);
////			PdfPCell cell11criteria7 = new PdfPCell();
////			cell11criteria7.setPadding(5);
////			paragraph6criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph6criteria7);
//			// paragraph6
////
////			Font fontParagraph3criteria7 = FontFactory.getFont(FontFactory.HELVETICA);
////			fontParagraph3criteria7.setSize(12);
////			Paragraph paragraph7criteria7 = new Paragraph(
////					"The Institution has defined procedures for promoting gender equity and sensitization both, in curricular, cocurricular and extra-curricular activities. Towards this, annually, several programs/activities are conducted:\r\n",
////					fontParagraph3criteria7);
////			paragraph7criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph7criteria7);
//			// paragraph7
//			/*
//			 * Font fontParagraph21criteria7 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph21criteria7.setSize(12);
//			 */
//		
//			// paragraph8
//
//			/*
//			 * Font fontParagraph31criteria7 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph31criteria7.setSize(12);
//			 */
////			Paragraph paragraph9criteria7 = new Paragraph(
////					"a. During their entire programme, students are sensitized to the behavioral nuances of working with the opposite gender. Girl students are empowered by taking up additional responsibilities as class representatives as well as executive members in the Student Council. About 4000 students including girls and boys have been sensitized on gender issues through these activities and are advised to maintain a healthy relationship so that women are not embarrassed at any point of time. Further, students are also counseled not to discuss topics that may have gender bias leading to any untoward/unpleasant situations\r\n"
////							+ "b. 'Gender Sensitization' has been introduced as a mandatory audit course to all undergraduate students and is a part of our curriculum. Interactive sessions of this course spreading over an entire semester, amply emphasize the theme and promote the goal. As part of our academic requirement and practice, being a coeducational institution, students of both the genders participate in various curricular, namely, laboratory work, internships, mini and major projects, technical and project seminar, wherein, they cooperatively and collaboratively work together. The institution treats their participation with due consideration for gender equity and equality.\r\n",
////					font5);
////
////			paragraph9criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph9criteria7);
//			// p9
//			/*
//			 * Font fontParagraph211 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph211.setSize(12);
//			 */
//			
//			// p10
//
//			/*
//			 * Font fontParagraph311 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph311.setSize(12);
//			 */
////			Paragraph paragraph11criteria7 = new Paragraph(
////					"Students participate in various extracurricular activities such as 36-hour Hackathons, IEEE’s 24-hour programming contest, project exhibitions, paper and poster presentations etc. In all these activities,students form groups involving both genders, which facilitates them in understanding the sensitivities of working together and without any bias to the opposite gender",
////					font5);
////
////			paragraph11criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph11criteria7);
//			// p11
//			/*
//			 * Font fontParagraph2111 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2111.setSize(12);
//			 */
////			Paragraph paragraph12criteria7 = new Paragraph("3. Activities under other gender-specific bodies:", font3);
////			// p12
////			document.add(paragraph12criteria7);
//
//			/*
//			 * Font fontParagraph3111 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * 
//			 * fontParagraph3111.setSize(12);
//			 */
////			Paragraph paragraph13criteria7 = new Paragraph(
////					"a. IEEE Women in Engineering (WiE), an affinity group established in the college in 2016. Through\r\n"
////							+ "WiE, college is promoting Gender equity and sensitization, and has organized twelve (12) awareness programs since 2016-17.\r\n"
////
////							+ "b. Women Protection Cell (WPC): WPC, a UGC mandate, has been in existence since 2015.WPC comprises twelve faculty members with a Presiding Officer, one external member and ten members, with\r\n"
////							+ "representation from all departments of college and is reconstituted every two years.WPC periodically\r\n"
////							+ "meets and reviews the complaints received from Lady faculty and students (if any), in particular, cases\r\n"
////							+ "involving harassment of women and addresses such cases, if any, as per statutory norms. WPC also\r\n"
////							+ "conducts awareness workshops on preventive measures and has conducted sixteen (16) programs including\r\n"
////							+ "eight (08) on preventive measures since 2016-17.c. Safety and Security of women: Women security personnel are recruited to support women faculty, staff\r\n"
////
////							+ "and students. All prominent locations of the campus are under CCTV surveillance. Women have been provided with separate waiting rooms/sick rooms and telephone numbers of SHE-TEAMS of Hyderabad\r\n"
////							+ "police, supporting them to instant/necessary help as and when needed." + " ",
////					font5);
////			// p13
////			paragraph13criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph13criteria7);
//
//			PdfPCell cell8 = new PdfPCell();
//			cell8.setPadding(8);
//			document.add(cell8);
//			// table
//			PdfPTable tablecriteria7 = new PdfPTable(2);
//			tablecriteria7.setWidthPercentage(100f);
//
//			/*
//			 * com.lowagie.text.Font fontcriteria7 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontcriteria7.setColor(CMYKColor.BLACK);
//			 */
//
//			PdfPCell cell111criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell112criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell1113criteria7 = new PdfPCell(new Paragraph("Annual gender sensitization action plan\r\n\r\n\r\n"));
//			PdfPCell cell1114criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//			PdfPCell cell115criteria7 = new PdfPCell(new Paragraph("Specific facilities provided for women in terms\r\n"
//					+ "of: a.Safety and security b.Counselling c.Common\r\n"
//					+ "Rooms d. Day care center for young children e.\r\n" + "Any other relevant information/r/n/r/n"));
//			PdfPCell cell116criteria7 = new PdfPCell(new Paragraph(""));
//
//			tablecriteria7.addCell(cell111criteria7);
//			tablecriteria7.addCell(cell112criteria7);
//			tablecriteria7.addCell(cell1113criteria7);
//			tablecriteria7.addCell(cell1114criteria7);
//			tablecriteria7.addCell(cell115criteria7);
//			tablecriteria7.addCell(cell116criteria7);
//			tablecriteria7.setSpacingBefore(20f);
//			tablecriteria7.setSpacingAfter(20f);
//
//			document.add(tablecriteria7);
//
//			// paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
//
//			// 7.1.2
//			/*
//			 * Font fontParagraph2112 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2111.setSize(12);
//			 */
//			/*
//			 * Paragraph paragraph14criteria7 = new Paragraph(
//			 * "7.1.2 The Institution has facilities for alternate sources of energy and energy conservation measures\r\n"
//			 * , font3); PdfPCell cell3criteria7 = new PdfPCell();
//			 * cell1criteria7.setPadding(10); document.add(cell3criteria7);
//			 * document.add(paragraph14criteria7); /*Font fontParagraph2113 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2111.setSize(12);
//			 */
//			/*
//			 * Paragraph paragraph15criteria7 = new Paragraph( "1.Solar energy \r\n" +
//			 * "2.Biogas plant\r\n" + "3.Wheeling to the Grid \r\n" +
//			 * "4.Sensor-based energy conservation\r\n" +
//			 * "5.Use of LED bulbs/ power efficient equipment\r\n" + "Response:" +
//			 * (criteria7Record != null ? criteria7Record.getResponseValue712() : ""),
//			 * font3); document.add(paragraph15criteria7);
//			 */
//
//			PdfPCell cell4criteria7 = new PdfPCell();
//
//			//cell1criteria7.setPadding(5);
//			document.add(cell4criteria7);
//
//			// table1
//			PdfPTable table1criteria7 = new PdfPTable(2);
//			PdfPTable table1criteria71 = new PdfPTable(1);
//
//			table1criteria7.setWidthPercentage(100f);
//			table1criteria71.setWidthPercentage(100f);
//
//			// com.lowagie.text.Font font1 =FontFactory.getFont(FontFactory.TIMES_ROMAN);
//			// font1.setColor(CMYKColor.BLACK);
//
//			PdfPCell cell113criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell114criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell11104criteria7 = new PdfPCell(new Paragraph("Geotagged Photographs\r\n\r\n\r\n"));
//			PdfPCell cell1117criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell1190criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//			PdfPCell cell1191criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			table1criteria7.addCell(cell113criteria7);
//			table1criteria7.addCell(cell114criteria7);
//			// table1.addCell(cell1113);
//			table1criteria7.addCell(cell11104criteria7);
//			table1criteria7.addCell(cell1117criteria7);
//			table1criteria7.addCell(cell1190criteria7);
//			table1criteria7.addCell(cell1191criteria7);
//
//			PdfPCell cell071 = new PdfPCell(new Paragraph(
//					"7.1.2	The Institution has facilities for alternate sources of energy and energy conservation measures\r\n"
//							+ "\r\n" + "1.	Solar energy\r\n" + "2.	Biogas plant\r\n" + "3.	Wheeling to the Grid\r\n"
//							+ "4.	Sensor-based energy conservation\r\n"
//							+ "5.	Use of LED bulbs/ power efficient equipment\r\n" + "\r\n" + "Response:"
//							+ (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQn().get(0).getResponse712()
//									: ""),
//					font3));
//
//			table1criteria71.addCell(cell071);
//
//			table1criteria71.addCell(table1criteria7);
//
//			table1criteria71.setSpacingBefore(20f);
//			table1criteria71.setSpacingAfter(20f);
//
//			document.add(table1criteria71);
//
//			PdfPCell cell6criteria7 = new PdfPCell();
//			cell6criteria7.setPadding(5);
//			document.add(cell6criteria7);
//
//			// 7.1.3
//			/*
//			 * Font fontParagraph2114 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2114.setSize(12);
//			 */
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
//			
//			PdfPTable table2criteria7 = new PdfPTable(2);
//			PdfPTable table20criteria7 = new PdfPTable(1);
//			
//			table2criteria7.setWidthPercentage(100);
//			table20criteria7.setWidthPercentage(100);
//
//			com.lowagie.text.Font font11 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font11.setColor(CMYKColor.BLACK);
//		
//			PdfPCell cell51criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell52criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell0 = new PdfPCell();
//			cell0.setPadding(5);
//			PdfPCell cell53criteria7 = new PdfPCell(new Paragraph(
//					"Relevant documents like agreements/MoUs with Government and other approved agencies\r\n\r\n\r\n"));
//			PdfPCell cell54criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell55criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n\r\n "));
//			PdfPCell cell56criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell57criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//			PdfPCell cell58criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			
//			table2criteria7.addCell(cell51criteria7);
//			table2criteria7.addCell(cell52criteria7);
//			table2criteria7.addCell(cell53criteria7);
//			table2criteria7.addCell(cell54criteria7);
//			table2criteria7.addCell(cell55criteria7);
//			table2criteria7.addCell(cell56criteria7);
//			table2criteria7.addCell(cell57criteria7);
//			table2criteria7.addCell(cell58criteria7);
//			
//			
//			
//			PdfPCell cell0071 = new PdfPCell(new Paragraph(
//					"7.1.3 Describe the facilities in the Institution for the management of the following types of\r\n\"\r\n"
//					+ "degradable and non-degradable waste (within 500 words) "+ "Response:"+ (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQn().get(0).getResponse713()
//									: ""),
//					font3));
//			
//			table20criteria7.addCell(cell0071);
//			table20criteria7.addCell(table2criteria7);
//			table20criteria7.setSpacingBefore(20f);
//			table20criteria7.setSpacingAfter(20f);
//
//			document.add(table20criteria7);
//
//			
//
//		
//
//			PdfPTable table3criteria7 = new PdfPTable(2);
//			PdfPTable table3criteria71 = new PdfPTable(1);
//			table3criteria7.setWidthPercentage(100f);
//			table3criteria71.setWidthPercentage(100f);
//
//			
//			
//
//			PdfPCell cell61criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell62criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//
//			PdfPCell cell63criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n\r\n"));
//			PdfPCell cell64criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			PdfPCell cell65criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//			PdfPCell cell66criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			table3criteria7.addCell(cell61criteria7);
//			table3criteria7.addCell(cell62criteria7);
//			table3criteria7.addCell(cell63criteria7);
//			table3criteria7.addCell(cell64criteria7);
//			table3criteria7.addCell(cell65criteria7);
//			table3criteria7.addCell(cell66criteria7);
//			
//			
//			
//			
//			PdfPCell cell0073 = new PdfPCell(new Paragraph("7.1.4: Water conservation facilities available in the Institution:\r\n"
//					+ "1. Rain water harvesting\r\n"
//					+ "2. Borewell /Open well recharge\r\n"
//					+ "3. Construction of tanks and bunds\r\n"
//					+ "4. Waste water recycling\r\n"
//					+ "5. Maintenance of water bodies and distribution system in the campus\r\n"+ "Response:"
//					+ (criteria7Fieldinfo != null ? criteria7Fieldinfo.getCriteria7FieldInfoQn().get(0).getResponse714()
//							: ""),
//					font3));
//			table3criteria71.addCell(cell0073);
//			table3criteria71.addCell(table3criteria7);
//
//			table3criteria71.setSpacingBefore(20f);
//			table3criteria71.setSpacingAfter(20f);
//
//			document.add(table3criteria71);
//
//			// 7.15
//			/*
//			 * Font fontParagraph2139 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2139.setSize(12);
//			 */
//			/*
//			 * Paragraph paragraph28criteria7 = new
//			 * Paragraph("7.1.5 Green campus initiatives include: \r\n" +
//			 * "1.Restricted entry of automobiles \r\n" +
//			 * "2.Use of Bicycles/ Battery powered vehicles\r\n" +
//			 * "3.Pedestrian Friendly pathways\r\n" + "4.Ban on use of Plastic\r\n" +
//			 * "5.landscaping with trees and plants\r\n" + "Response: " + (criteria7Record
//			 * != null ? criteria7Record.getResponseValue715() : ""), font3);
//			 * 
//			 * document.add(paragraph28criteria7);
//			 */
//
//			// 7.15 table
//			PdfPTable table6criteria7 = new PdfPTable(2);
//			PdfPTable table6criteria72 = new PdfPTable(1);
//
//			table6criteria7.setWidthPercentage(100f);
//			table6criteria72.setWidthPercentage(100f);
//
//			/*
//			 * com.lowagie.text.Font font13 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font13.setColor(CMYKColor.BLACK);
//			 */
//			PdfPCell cell67criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell68criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell69criteria7 = new PdfPCell(
//					new Paragraph("Geotagged photos / videos of the facilities\r\n\r\n\r\n"));
//			PdfPCell cell70criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell71criteria7 = new PdfPCell(new Paragraph("Various policy documents / decisions circulated for implementation\r\n\r\n"));
//			PdfPCell cell72criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			PdfPCell cell73criteria7 = new PdfPCell(new Paragraph("Any other relevant documents\r\n\r\n"));
//			PdfPCell cell74criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			table6criteria7.addCell(cell67criteria7);
//			table6criteria7.addCell(cell68criteria7);
//			table6criteria7.addCell(cell69criteria7);
//			table6criteria7.addCell(cell70criteria7);
//			table6criteria7.addCell(cell71criteria7);
//			table6criteria7.addCell(cell72criteria7);
//			table6criteria7.addCell(cell73criteria7);
//			table6criteria7.addCell(cell74criteria7);
//
//			PdfPCell cell073 = new PdfPCell(new Paragraph("7.1.5	Green campus initiatives include:\r\n" + "\r\n"
//					+ "1.	Restricted entry of automobiles\r\n" + "2.	Use of Bicycles/ Battery powered vehicles\r\n"
//					+ "3.	Pedestrian Friendly pathways\r\n" + "4.	Ban on use of Plastic\r\n"
//					+ "5.	landscaping with trees and plants\r\n" + "\r\n" + "Response:"
//					+ (criteria7Fieldinfo != null ? criteria7Fieldinfo.getCriteria7FieldInfoQn().get(0).getResponse715()
//							: ""),
//					font3));
//
//		table6criteria72.addCell(cell073);
//
//			table6criteria72.addCell(table6criteria7);
//
//			table6criteria72.setSpacingBefore(20f);
//			table6criteria72.setSpacingAfter(20f);
//
//			document.add(table6criteria72);
//
//			// 7.16
//			// 7.16 table
//			/*
//			 * Font fontParagraph2140 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2140.setSize(12);
//			 */
//			/*
//			 * Paragraph paragraph29criteria7 = new Paragraph(
//			 * "7.1.6 Quality audits on environment and energy are regularly undertaken by the Institution and any\r\n"
//			 * + "awards received for such green campus initiatives:\r\n" +
//			 * "1.Green audit\r\n" + "2.Energy audit\r\n" + "3.Environment audit\r\n" +
//			 * "4.Clean and green campus recognitions / awards\r\n" +
//			 * "5.Beyond the campus environmental promotion activities \r\n" + "Response: "
//			 * + (criteria7Record != null ? criteria7Record.getResponseValue716() : ""),
//			 * font3); document.add(paragraph29criteria7);
//			 */
//
//			PdfPTable table15criteria7 = new PdfPTable(2);
//			PdfPTable table15criteria73 = new PdfPTable(1);
//
//			table15criteria7.setWidthPercentage(100f);
//			table15criteria73.setWidthPercentage(100f);
//
//			com.lowagie.text.Font font131 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font131.setColor(CMYKColor.BLACK);
//			PdfPCell cell75criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n"));
//			PdfPCell cell76criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n"));
//			PdfPCell cell77criteria7 = new PdfPCell(
//					new Paragraph("Reports on environment and energy audits\r\n" + "submitted by the auditing agency\r\n\r\n\r\n"));
//			PdfPCell cell78criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell79criteria7 = new PdfPCell(new Paragraph("Certification by the auditing agency\r\n\r\n\r\n"));
//			PdfPCell cell80criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell81criteria7 = new PdfPCell(new Paragraph("Certificates of the awards received\r\n\r\n\r\n"));
//			PdfPCell cell82criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell83criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//			PdfPCell cell84criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			table15criteria7.addCell(cell75criteria7);
//			table15criteria7.addCell(cell76criteria7);
//			table15criteria7.addCell(cell77criteria7);
//			table15criteria7.addCell(cell78criteria7);
//			table15criteria7.addCell(cell79criteria7);
//			table15criteria7.addCell(cell80criteria7);
//			table15criteria7.addCell(cell81criteria7);
//			table15criteria7.addCell(cell82criteria7);
//			table15criteria7.addCell(cell83criteria7);
//			table15criteria7.addCell(cell84criteria7);
//
//			PdfPCell cell074 = new PdfPCell(new Paragraph(
//					"7.1.6	Quality audits on environment and energy are regularly undertaken by the Institution and any awards received for such green campus initiatives:\r\n"
//							+ "\r\n" + "1.	Green audit\r\n" + "2.	Energy audit\r\n" + "3.	Environment audit\r\n"
//							+ "4.	Clean and green campus recognitions / awards\r\n"
//							+ "5.	Beyond the campus environmental promotion activities\r\n" + "\r\n" + "Response:"
//							+ (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQn().get(0).getResponse716()
//									: ""),
//					font3));
//
//			table15criteria73.addCell(cell074);
//
//			table15criteria73.addCell(table15criteria7);
//
//			table15criteria73.setSpacingBefore(20f);
//			table15criteria73.setSpacingAfter(20f);
//
//			document.add(table15criteria73);
//
//			// 7.1.7
//			/*
//			 * Font fontParagraph2141 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2141.setSize(12);
//			 */
//			/*
//			 * Paragraph paragraph30criteria7 = new Paragraph(
//			 * "7.1.7 The Institution has disabled-friendly, barrier free environment \r\n"
//			 * + "1.Built environment with ramps/lifts for easy access to classrooms.\r\n" +
//			 * "2.Divyangjan friendly washrooms\r\n" +
//			 * "3.Signage including tactile path, lights, display boards and signposts\r\n"
//			 * +
//			 * "4.Assistive technology and facilities for Divyangjan accessible website, screen-reading software,\r\n"
//			 * + "mechanized equipment\r\n" +
//			 * "5.Provision for enquiry and information : Human assistance, reader, scribe, soft copies of\r\n"
//			 * + "reading material, screen reading\r\n" + "Response:" + (criteria7Record !=
//			 * null ? criteria7Record.getResponseValue717() : ""), font3);
//			 * document.add(paragraph30criteria7);
//			 */
//			// 7.1.7 table
//			PdfPTable table17criteria7 = new PdfPTable(2);
//			PdfPTable table17criteria73 = new PdfPTable(1);
//
//			table17criteria7.setWidthPercentage(100f);
//			table17criteria73.setWidthPercentage(100f);
//			com.lowagie.text.Font font132 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font132.setColor(CMYKColor.BLACK);
//			PdfPCell cell85criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n"));
//			PdfPCell cell86criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n"));
//			PdfPCell cell87criteria7 = new PdfPCell(
//					new Paragraph("Geotagged photographs / videos of the facilities\r\n"));
//			PdfPCell cell88criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell89criteria7 = new PdfPCell(new Paragraph("Policy documents and information brochures on the support to be provided\r\n\r\n\r\n"));
//			PdfPCell cell90criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell91criteria7 = new PdfPCell(
//					new Paragraph("Details of the Software procured for providing the assistance\r\n\r\n\r\n"));
//			PdfPCell cell92criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell93criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//			PdfPCell cell94criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			table17criteria7.addCell(cell85criteria7);
//			table17criteria7.addCell(cell86criteria7);
//			table17criteria7.addCell(cell87criteria7);
//			table17criteria7.addCell(cell88criteria7);
//			table17criteria7.addCell(cell89criteria7);
//			table17criteria7.addCell(cell90criteria7);
//			table17criteria7.addCell(cell91criteria7);
//			table17criteria7.addCell(cell92criteria7);
//			table17criteria7.addCell(cell93criteria7);
//			table17criteria7.addCell(cell94criteria7);
//
//			PdfPCell cell075 = new PdfPCell(
//					new Paragraph("7.1.7	The Institution has disabled-friendly, barrier free environment\r\n" + "\r\n"
//							+ "1.	Built environment with ramps/lifts for easy access to classrooms.\r\n"
//							+ "2.	Divyangjan friendly washrooms\r\n"
//							+ "3.	Signage including tactile path, lights, display boards and signposts\r\n"
//							+ "4.	Assistive technology and facilities for Divyangjan accessible website, screen-reading software, mechanized equipment\r\n"
//							+ "5.	Provision for enquiry and information : Human assistance, reader, scribe, soft copies of reading material, screen reading\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQn().get(0).getResponse717()
//									: ""),
//							font3));
//
//			table17criteria73.addCell(cell075);
//
//			table17criteria73.addCell(table17criteria7);
//
//			table17criteria73.setSpacingBefore(20f);
//			table17criteria73.setSpacingAfter(20f);
//
//			document.add(table17criteria73);
//
//
//			// 7.1.8 table
//			
//			
//
//
//			PdfPTable table18criteria7 = new PdfPTable(2);
//			PdfPTable table108criteria7 = new PdfPTable(1);
//			
//			table18criteria7.setWidthPercentage(100f);
//			table108criteria7.setWidthPercentage(100f);
//			
//			com.lowagie.text.Font font133 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font133.setColor(CMYKColor.BLACK);
//			PdfPCell cell95criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			PdfPCell cell96criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell97criteria7 = new PdfPCell(
//					new Paragraph("Policy documents and information brochures on the\r\n" + "support to be provided"));
//			PdfPCell cell98criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell99criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities"));
//			PdfPCell cell100criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell101criteria7 = new PdfPCell(
//					new Paragraph("Details of the Software procured for providing the" + "assistance\r\n\r\n\r\n"));
//			PdfPCell cell102criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell103criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//			PdfPCell cell104criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			table18criteria7.addCell(cell95criteria7);
//			table18criteria7.addCell(cell96criteria7);
//			table18criteria7.addCell(cell97criteria7);
//			table18criteria7.addCell(cell98criteria7);
//			table18criteria7.addCell(cell99criteria7);
//			table18criteria7.addCell(cell100criteria7);
//			table18criteria7.addCell(cell101criteria7);
//			table18criteria7.addCell(cell102criteria7);
//			table18criteria7.addCell(cell103criteria7);
//			table18criteria7.addCell(cell104criteria7);
//			
//
//			PdfPCell cell0075 = new PdfPCell(
//					new Paragraph("7.1.8: Describe the Institutional efforts/initiatives in providing an inclusive environment i.e., tolerance and harmony towards cultural, regional, linguistic, communal socioeconomic and other diversities (within 500 words)." + "Response:"
//							+ (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse718()
//									: ""),
//							font3));
//			table108criteria7.addCell(cell0075);
//			table108criteria7.addCell(table18criteria7);
//		
//			table108criteria7.setSpacingBefore(20f);
//			table108criteria7.setSpacingAfter(20f);
//
//			document.add(table108criteria7);
//
//		
//			
//			/*
//			 * Font fontParagraph2147 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2147.setSize(12);
//			 */
//			
//			
//			// 7.1.1.9 table
//			
//			PdfPTable table19criteria7 = new PdfPTable(2);
//			PdfPTable table109criteria7 = new PdfPTable(1);
//			
//			table19criteria7.setWidthPercentage(100f);
//			table109criteria7.setWidthPercentage(100f);
//			
//			com.lowagie.text.Font font134 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font134.setColor(CMYKColor.BLACK);
//			PdfPCell cell105criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell106criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell107criteria7 = new PdfPCell(new Paragraph("Details of activities that inculcate values; necessary to render students in to responsible citizens\r\n\r\n"));
//			PdfPCell cell108criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			PdfPCell cell109criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//			PdfPCell cell110criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			table19criteria7.addCell(cell105criteria7);
//			table19criteria7.addCell(cell106criteria7);
//			table19criteria7.addCell(cell107criteria7);
//			table19criteria7.addCell(cell107criteria7);
//			table19criteria7.addCell(cell108criteria7);
//			table19criteria7.addCell(cell109criteria7);
//			table19criteria7.addCell(cell110criteria7);
//			
//			PdfPCell cell00075 = new PdfPCell(
//					new Paragraph(" 7.1.9: Sensitization of students and employees of the Institution to the constitutional obligations: values, rights, duties and responsibilities of citizens (within 500 words).." + "Response:"
//							+ (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse719()
//									: ""),
//							font3));
//			
//			table109criteria7.addCell(cell00075);
//			table109criteria7.addCell(table19criteria7);
//			
//			table109criteria7.setSpacingBefore(20f);
//			table109criteria7.setSpacingAfter(20f);
//			document.add(table109criteria7);
//
//		
//			// 7.1.10 table
//
//			PdfPTable table31criteria7 = new PdfPTable(2);
//			PdfPTable table31criteria74 = new PdfPTable(1);
//
//			table31criteria7.setWidthPercentage(100);
//			table31criteria74.setWidthPercentage(100);
//
//			com.lowagie.text.Font font112 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font112.setColor(CMYKColor.BLACK);
//			PdfPCell cell1111 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n"));
//			PdfPCell cell1112 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n"));
//			PdfPCell cell11113 = new PdfPCell(new Paragraph(
//					" Code of ethics policy document\r\n\r\n\r\n"));
//			PdfPCell cell11114 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			PdfPCell cell1115 = new PdfPCell(new Paragraph("Details of the monitoring committee composition and minutes of the committee meeting, number of programmes organized, reports on the various programs etc., in support of the claims\r\n\r\n\r\n"));
//			PdfPCell cell1116 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			PdfPCell cell11117 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//			PdfPCell cell1118 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			table31criteria7.addCell(cell1111);// 7.1.10 table
//			table31criteria7.addCell(cell1112);
//			table31criteria7.addCell(cell11113);
//			table31criteria7.addCell(cell11114);
//			table31criteria7.addCell(cell1115);
//			table31criteria7.addCell(cell1116);
//			table31criteria7.addCell(cell11117);
//			table31criteria7.addCell(cell1118);
//
//			PdfPCell cell076 = new PdfPCell(new Paragraph(
//					"7.1.10 The Institution has a prescribed code of conduct for students, teachers, administrators and other staff and conducts periodic programmes in this regard.\r\n"
//							+ "\r\n" + "1.	The Code of Conduct is displayed on the website\r\n"
//							+ "2.	There is a committee to monitor adherence to the Code of Conduct\r\n"
//							+ "3.	Institution organizes professional ethics programmes for students, teachers, administrators and other staff\r\n"
//							+ "4.	Annual awareness programmes on Code of Conduct are organized\r\n" + "\r\n"
//							+ "Response:\r\n"
//							+ (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQn().get(0).getResponse7110()
//									: ""),
//					font3));
//
//		table31criteria74.addCell(cell076);
//
//			table31criteria74.addCell(table31criteria7);
//
//			table31criteria74.setSpacingBefore(20f);
//			table31criteria74.setSpacingAfter(20f);
//
//			document.add(table31criteria74);
//
//		
//			PdfPTable table7111criteria7 = new PdfPTable(1);
//			table7111criteria7.setWidthPercentage(100f);
//
//
//			PdfPCell cell7111criteria7 = new PdfPCell(new Paragraph(
//					"7.1.11 Institution celebrates / organizes national and international commemorative days, events and festivals (within 500 words).\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse7111()
//									: ""),
//					font3));
//			table7111criteria7.addCell(cell7111criteria7);
//			table7111criteria7.setSpacingBefore(20f);
//			table7111criteria7.setSpacingAfter(20f);
//
//			document.add(table7111criteria7);
//			
//			
//
//			
//		
//		
//		
//			
//			// table 4
//			PdfPTable table4criteria7 = new PdfPTable(2);
//			table4criteria7.setWidthPercentage(100);
//
//			com.lowagie.text.Font font14 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font14.setColor(CMYKColor.BLACK);
//			PdfPCell cell1119criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell1120criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell1121criteria7 = new PdfPCell(new Paragraph("Annual report of the celebrations and commemorative events for the last five years\r\n\r\n\r\n"));
//			PdfPCell cell1122criteria7 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			PdfPCell cell1123criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of some of the events\r\n\r\n\r\n"));
//			PdfPCell cell1124criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//			PdfPCell cell1125criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//			PdfPCell cell1126criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//			
//			table4criteria7.addCell(cell1119criteria7);
//			table4criteria7.addCell(cell1120criteria7);
//			table4criteria7.addCell(cell1121criteria7);
//			table4criteria7.addCell(cell1122criteria7);
//			table4criteria7.addCell(cell1123criteria7);
//			table4criteria7.addCell(cell1124criteria7);
//			table4criteria7.addCell(cell1125criteria7);
//			table4criteria7.addCell(cell1126criteria7);
//
//			table4criteria7.setSpacingBefore(20f);
//			table4criteria7.setSpacingAfter(20f);
//
//			document.add(table4criteria7);
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
//
//
//
