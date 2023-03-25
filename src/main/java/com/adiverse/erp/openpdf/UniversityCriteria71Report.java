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
//import org.springframework.web.multipart.MultipartFile;
//
//import com.adiverse.erp.model.Criteria7_FieldInfo;
//import com.adiverse.erp.model.Criteria7_FileUpload;
//import com.adiverse.erp.service.Criteria7Service;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.Image;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.pdf.CMYKColor;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//@Service
//public class UniversityCriteria71Report {
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
//	Criteria7Service serivice7;
//	
//List<Criteria7_FieldInfo> criteria7List = null;
//Criteria7_FieldInfo  criteria7Record = null;
//List<Criteria7_FileUpload> criteria7file = null;
////1
//public  String generateReport(Criteria7_FieldInfo criteria7Fieldinfo,MultipartFile[] uploadfile7) throws DocumentException, IOException {
//	
//	String reportPath = "";
//	Path root = Paths.get(reportGeneratePath);
//	Path file = null;
//	Date date = new Date();
//	try {
//		font1.setSize(16);
//		font2.setSize(14);
//		font3.setSize(12);
//		font4.setSize(14);
//		font5.setSize(12);
//		
//		
//		criteria7List = serivice7.getAllCriteria7Data();
//		if (CollectionUtils.isNotEmpty(criteria7List)) {
//			criteria7Record = criteria7List.get(0);
//			criteria7file = criteria7Record.getCriteria7FileUpload();
//		} else {
//			criteria7Record = new Criteria7_FieldInfo();
//			criteria7file = new ArrayList<>();
//
//		}
//		System.out.println("report generation path from property file ==>" + reportGeneratePath);
//		if (root != null) {
//			SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//			String strDate = formatter.format(date);
//			reportPath = "UniversityCriteria7Report-" + strDate + ".pdf";
//			file = root.resolve(reportPath);
//		}
//		System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//		
//		Document document = new Document(PageSize.A4);
//		// PdfWriter.getInstance(document, response.getOutputStream());
//		PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//		
//		document.open();
//		System.out.println("open the document==========>");
//		
//		Paragraph paragraphcriteria7 = new Paragraph("Criterion 7 - Institutional Values and Best Practices\r\n\r\n",
//				font1);
//		paragraphcriteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		PdfPCell cell5criteria7 = new PdfPCell();
//		cell5criteria7.setPadding(5);
//		document.add(cell5criteria7);
//
//		/*
//		 * Font fontTitle1criteria7 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontTitle1criteria7.setSize(14);
//		 */
//		// document
//		document.add(paragraphcriteria7);
//		Paragraph paragraph2criteria7 = new Paragraph("7.1 Institutional Values and Social Responsibilities\r\n\r\n", font2);
//		paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		/*
//		 * Font fontTitle2criteria7 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontTitle2criteria7.setSize(12);
//		 */
//		// document2
//		document.add(paragraph2criteria7);
//		Paragraph paragraph3criteria7 = new Paragraph(
//				"7.1.1 Measures initiated by the Institution for the promotion of gender equity during the last five years.\r\n\r\n",
//				font3);
//		paragraph3criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		PdfPTable table711criteria7 = new PdfPTable(1);
//		table711criteria7.setWidthPercentage(100f);
//
//		/*
//		 * com.lowagie.text.Font fontcriteria7 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontcriteria7.setColor(CMYKColor.BLACK);
//		 */
//
//		PdfPCell cell711criteria7 = new PdfPCell(new Paragraph(
//				"7.1.1	Measures initiated by the Institution for the promotion of gender equity during the last five years.\r\n"
//						+ "\r\n\r\n" + "Response:"
//						+ (criteria7Fieldinfo != null
//								? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse711()
//								: ""),
//				font3));
//
//		table711criteria7.addCell(cell711criteria7);
//		table711criteria7.setSpacingBefore(20f);
//		table711criteria7.setSpacingAfter(20f);
//
//		document.add(table711criteria7);
//
//		// paragaph3
//		document.add(paragraph3criteria7);
//		/*
//		 * Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph.setSize(12);
//		 */
//
////		Paragraph paragraph4criteria7 = new Paragraph("Response:"
////				+ (criteria7Record != null ? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse711()
////						: ""),
////				font3);
////		paragraph4criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////		PdfPCell cellcriteria7 = new PdfPCell();
////		cellcriteria7.setPadding(5);
////		document.add(paragraph4criteria7);
//		// paragraph 4
//
//		Font fontParagraph1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontParagraph1.setSize(12);
//
//		/*
//		 * Font fontParagraph4criteria7 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph4criteria7.setSize(12);
//		 */
//		Paragraph paragraph5criteria7 = new Paragraph(
//				"Mother Teresa has zero tolerance to any kind of discrimination and follows an inclusive policy in all its endeavors, without any bias to gender, caste, religion, language and any such others.\r\n",
//				font5);
//		paragraph5criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		PdfPCell cell1criteria7 = new PdfPCell();
//		document.add(paragraph5criteria7);
//		cell1criteria7.setPadding(5);
//		// paragraph5
//		/*
//		 * Font fontParagraph2criteria7 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2criteria7.setSize(12);
//		 */
//		Paragraph paragraph6criteria7 = new Paragraph(
//				"A. Activities to promote Gender Equity and gender sensitization:\r\n", font3);
//		PdfPCell cell11criteria7 = new PdfPCell();
//		cell11criteria7.setPadding(5);
//		paragraph6criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph6criteria7);
//		// paragraph6
//
//		Font fontParagraph3criteria7 = FontFactory.getFont(FontFactory.HELVETICA);
//		fontParagraph3criteria7.setSize(12);
//		Paragraph paragraph7criteria7 = new Paragraph(
//				"The Institution has defined procedures for promoting gender equity and sensitization both, in curricular, cocurricular and extra-curricular activities. Towards this, annually, several programs/activities are conducted:\r\n",
//				fontParagraph3criteria7);
//		paragraph7criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph7criteria7);
//		// paragraph7
//		/*
//		 * Font fontParagraph21criteria7 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph21criteria7.setSize(12);
//		 */
//		Paragraph paragraph8criteria7 = new Paragraph("1. Curricular and Co-curricular activities: \r\n", font3);
//		paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph8criteria7);
//		// paragraph8
//
//		/*
//		 * Font fontParagraph31criteria7 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph31criteria7.setSize(12);
//		 */
//		Paragraph paragraph9criteria7 = new Paragraph(
//				"a. During their entire programme, students are sensitized to the behavioral nuances of working with the opposite gender. Girl students are empowered by taking up additional responsibilities as class representatives as well as executive members in the Student Council. About 4000 students including girls and boys have been sensitized on gender issues through these activities and are advised to maintain a healthy relationship so that women are not embarrassed at any point of time. Further, students are also counseled not to discuss topics that may have gender bias leading to any untoward/unpleasant situations\r\n"
//						+ "b. 'Gender Sensitization' has been introduced as a mandatory audit course to all undergraduate students and is a part of our curriculum. Interactive sessions of this course spreading over an entire semester, amply emphasize the theme and promote the goal. As part of our academic requirement and practice, being a coeducational institution, students of both the genders participate in various curricular, namely, laboratory work, internships, mini and major projects, technical and project seminar, wherein, they cooperatively and collaboratively work together. The institution treats their participation with due consideration for gender equity and equality.\r\n",
//				font5);
//
//		paragraph9criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph9criteria7);
//		// p9
//		/*
//		 * Font fontParagraph211 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph211.setSize(12);
//		 */
//		Paragraph paragraph10criteria7 = new Paragraph("2. Extra-curricular activities:\r\n", font3);
//		document.add(paragraph10criteria7);
//		// p10
//
//		/*
//		 * Font fontParagraph311 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph311.setSize(12);
//		 */
//		Paragraph paragraph11criteria7 = new Paragraph(
//				"Students participate in various extracurricular activities such as 36-hour Hackathons, IEEE’s 24-hour programming contest, project exhibitions, paper and poster presentations etc. In all these activities,students form groups involving both genders, which facilitates them in understanding the sensitivities of working together and without any bias to the opposite gender",
//				font5);
//
//		paragraph11criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph11criteria7);
//		// p11
//		/*
//		 * Font fontParagraph2111 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2111.setSize(12);
//		 */
//		Paragraph paragraph12criteria7 = new Paragraph("3. Activities under other gender-specific bodies:", font3);
//		// p12
//		document.add(paragraph12criteria7);
//
//		/*
//		 * Font fontParagraph3111 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * 
//		 * fontParagraph3111.setSize(12);
//		 */
//		Paragraph paragraph13criteria7 = new Paragraph(
//				"a. IEEE Women in Engineering (WiE), an affinity group established in the college in 2016. Through\r\n"
//						+ "WiE, college is promoting Gender equity and sensitization, and has organized twelve (12) awareness programs since 2016-17.\r\n"
//
//						+ "b. Women Protection Cell (WPC): WPC, a UGC mandate, has been in existence since 2015.WPC comprises twelve faculty members with a Presiding Officer, one external member and ten members, with\r\n"
//						+ "representation from all departments of college and is reconstituted every two years.WPC periodically\r\n"
//						+ "meets and reviews the complaints received from Lady faculty and students (if any), in particular, cases\r\n"
//						+ "involving harassment of women and addresses such cases, if any, as per statutory norms. WPC also\r\n"
//						+ "conducts awareness workshops on preventive measures and has conducted sixteen (16) programs including\r\n"
//						+ "eight (08) on preventive measures since 2016-17.c. Safety and Security of women: Women security personnel are recruited to support women faculty, staff\r\n"
//
//						+ "and students. All prominent locations of the campus are under CCTV surveillance. Women have been provided with separate waiting rooms/sick rooms and telephone numbers of SHE-TEAMS of Hyderabad\r\n"
//						+ "police, supporting them to instant/necessary help as and when needed." + " ",
//				font5);
//		// p13
//		paragraph13criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph13criteria7);
//
//		PdfPCell cell8 = new PdfPCell();
//		cell8.setPadding(8);
//		document.add(cell8);
//		// table
//		PdfPTable tablecriteria7 = new PdfPTable(2);
//		tablecriteria7.setWidthPercentage(100f);
//
//		/*
//		 * com.lowagie.text.Font fontcriteria7 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontcriteria7.setColor(CMYKColor.BLACK);
//		 */
//
//		PdfPCell cell111criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//		PdfPCell cell112criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//		PdfPCell cell1113criteria7 = new PdfPCell(new Paragraph("Specific facilities provided for women in terms\\r\\n\"\r\n"
//				+ "				+ \"of: a.Safety and security b.Counselling c.Common\\r\\n\"\r\n"
//				+ "				+ \"Rooms d. Day care center for young children e.\\r\\n\" + \"Any other relevant information/r/n/r/n "));
//		PdfPCell cell1114criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//		PdfPCell cell115criteria7 = new PdfPCell(new Paragraph("  Annual gender sensitization action plan\\r\\n\\r\\n\\r\\n"));
//		PdfPCell cell116criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
//
//		tablecriteria7.addCell(cell111criteria7);
//		tablecriteria7.addCell(cell112criteria7);
//		tablecriteria7.addCell(cell1113criteria7);
//		tablecriteria7.addCell(cell1114criteria7);
//		tablecriteria7.addCell(cell115criteria7);
//		tablecriteria7.addCell(cell116criteria7);
//		tablecriteria7.setSpacingBefore(20f);
//		tablecriteria7.setSpacingAfter(20f);
//
//		document.add(tablecriteria7);
//
//		// paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
//
//		// 7.1.2
//		/*
//		 * Font fontParagraph2112 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2111.setSize(12);
//		 */
//		/*
//		 * Paragraph paragraph14criteria7 = new Paragraph(
//		 * "7.1.2 The Institution has facilities for alternate sources of energy and energy conservation measures\r\n"
//		 * , font3); PdfPCell cell3criteria7 = new PdfPCell();
//		 * cell1criteria7.setPadding(10); document.add(cell3criteria7);
//		 * document.add(paragraph14criteria7); /*Font fontParagraph2113 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2111.setSize(12);
//		 */
//		/*
//		 * Paragraph paragraph15criteria7 = new Paragraph( "1.Solar energy \r\n" +
//		 * "2.Biogas plant\r\n" + "3.Wheeling to the Grid \r\n" +
//		 * "4.Sensor-based energy conservation\r\n" +
//		 * "5.Use of LED bulbs/ power efficient equipment\r\n" + "Response:" +
//		 * (criteria7Record != null ? criteria7Record.getResponseValue712() : ""),
//		 * font3); document.add(paragraph15criteria7);
//		 */
//
//		PdfPCell cell4criteria7 = new PdfPCell();
//
//		cell1criteria7.setPadding(5);
//		document.add(cell4criteria7);
//
//		// table1
//		PdfPTable table1criteria7 = new PdfPTable(2);
//		PdfPTable table1criteria71 = new PdfPTable(1);
//
//		table1criteria7.setWidthPercentage(100f);
//		table1criteria71.setWidthPercentage(100f);
//
//		// com.lowagie.text.Font font1 =FontFactory.getFont(FontFactory.TIMES_ROMAN);
//		// font1.setColor(CMYKColor.BLACK);
//
//		PdfPCell cell113criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//		PdfPCell cell114criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell11104criteria7 = new PdfPCell(new Paragraph("Geotagged Photographs\r\n\r\n\r\n"));
//		PdfPCell cell1117criteria7 = new PdfPCell(
//				new Paragraph((criteria7file != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//		PdfPCell cell1190criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//		PdfPCell cell1191criteria7 = new PdfPCell(
//				new Paragraph((criteria7file != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//
//		table1criteria7.addCell(cell113criteria7);
//		table1criteria7.addCell(cell114criteria7);
//		// table1.addCell(cell1113);
//		table1criteria7.addCell(cell11104criteria7);
//		table1criteria7.addCell(cell1117criteria7);
//		table1criteria7.addCell(cell1190criteria7);
//		table1criteria7.addCell(cell1191criteria7);
//
//		PdfPCell cell071 = new PdfPCell(new Paragraph(
//				"7.1.2	The Institution has facilities for alternate sources of energy and energy conservation measures\r\n"
//						+ "\r\n" + "1.	Solar energy\r\n" + "2.	Biogas plant\r\n" + "3.	Wheeling to the Grid\r\n"
//						+ "4.	Sensor-based energy conservation\r\n"
//						+ "5.	Use of LED bulbs/ power efficient equipment\r\n" + "\r\n" + "Response:"
//						+ (criteria7Fieldinfo != null
//								? criteria7Fieldinfo.getCriteria7FieldInfoQn().get(0).getResponse712()
//								: ""),
//				font3));
//
//		table1criteria71.addCell(cell071);
//
//		table1criteria71.addCell(table1criteria7);
//
//		table1criteria71.setSpacingBefore(20f);
//		table1criteria71.setSpacingAfter(20f);
//
//		document.add(table1criteria71);
//
//		PdfPCell cell6criteria7 = new PdfPCell();
//		cell6criteria7.setPadding(5);
//		document.add(cell6criteria7);
//
//		// 7.1.3
//		/*
//		 * Font fontParagraph2114 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2114.setSize(12);
//		 */
//		Paragraph paragraph16criteria7 = new Paragraph(
//				"7.1.3 Describe the facilities in the Institution for the management of the following types of\r\n"
//						+ "degradable and non-degradable waste (within 500 words)\r\n",
//				font3);
//		document.add(paragraph16criteria7);
//
//		PdfPCell cell10 = new PdfPCell();
//		cell10.setPadding(10);
//
//		PdfPTable table713criteria7 = new PdfPTable(1);
//		table713criteria7.setWidthPercentage(100f);
//
//		/*
//		 * com.lowagie.text.Font fontcriteria7 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontcriteria7.setColor(CMYKColor.BLACK);
//		 */
//
//		PdfPCell cell713criteria7 = new PdfPCell(new Paragraph(
//				"7.1.3 Describe the facilities in the Institution for the management of the following types of degradable and non-degradable waste (within 500 words)\r\n"
//						+ "\r\n"
//						+ "Solid waste management Liquid waste management Biomedical waste management E-waste management\r\n"
//						+ "Waste recycling system\r\n" + "Hazardous chemicals and radioactive waste management\r\n"
//						+ "Response:"
//						+ (criteria7Fieldinfo != null
//								? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse713()
//								: ""),
//				font3));
//
//		table713criteria7.addCell(cell713criteria7);
//		table713criteria7.setSpacingBefore(20f);
//		table713criteria7.setSpacingAfter(20f);
//
//		document.add(table713criteria7);
//
//		/*
//		 * Font fontParagraph2115 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2115.setSize(12);
//		 */
//		Paragraph paragraph17criteria7 = new Paragraph("Solid waste management\r\n" + "Liquid waste management\r\n"
//				+ "Biomedical waste management\r\n" + "E-waste management\r\n" + "Waste recycling system\r\n"
//				+ "Hazardous chemicals and radioactive waste management\r\n" + "\r\n" + "Response: "
//				+ (criteria7Fieldinfo != null ? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse713()
//						: ""),
//				font3);
//		document.add(paragraph17criteria7);
//
//		/*
//		 * Font fontParagraph2116 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2116.setSize(12);
//		 */
//		Paragraph paragraph18criteria7 = new Paragraph(
//				"Mother Teresa college of Engineering & Technology (GCET) believes in “Let’s go green and keep our\r\n"
//						+ "campus clean”. GCET’s essential operations are highly sustainable and its efficient waste management\r\n"
//						+ "processes ensure that generation of waste is kept to a minimum. Environment consciousness is embodied\r\n"
//						+ "in the heart of the College by activities such as tree plantations from NSS/ NCC/Environmental Club\r\n"
//						+ "volunteers every year. It not only maintains the aesthetics of the college but also promotes the vital motive\r\n"
//						+ "of the management to provide a friendly atmosphere for the academic and non-academic activity.\r\n"
//						+ "GCET is aware of and sensitive to segregating waste and proper disposal as per the mandated norms.\r\n"
//						+ "The institute’s operations result in the generation of waste which can be broadly classified as:"
//						+ "",
//				font5);
//
//		paragraph18criteria7.setAlignment(Paragraph.ALIGN_LEFT);
//		PdfPCell cell13criteria7 = new PdfPCell();
//		cell13criteria7.setPadding(5);
//		document.add(paragraph18criteria7);
//		/*
//		 * Font fontParagraph2117 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2117.setSize(12);
//		 */
//		Paragraph paragraph19criteria7 = new Paragraph("1.Solid Waste\r\n" + "2.Liquid Waste \r\n" + "3.E-Waste",
//				font3);
//		document.add(paragraph19criteria7);
//		/*
//		 * Font fontParagraph2119 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2119.setSize(12);
//		 */
//		Paragraph paragraph20criteria7 = new Paragraph(
//				"There is no generation of Hazardous chemicals and radioactive waste.\r\n"
//						+ "Sanitary Incinerators are installed inside the campus to promote hygiene. \r\n"
//						+ "The institution’s practices with regard to storage and disposal of waste are described below:"
//						+ "\r\n",
//				font5);
//		paragraph20criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph20criteria7);
//
//		// solid waste management
//		/*
//		 * Font fontParagraph2127 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2127.setSize(12);
//		 */
//		Paragraph paragraph21criteria7 = new Paragraph("Solid Waste Management:", font3);
//		document.add(paragraph21criteria7);
//		/*
//		 * Font fontParagraph2129 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2129.setSize(12);
//		 */
//		Paragraph paragraph22criteria7 = new Paragraph(
//				"The solid waste generated in the institution includes rubber tyres, metal scrap, paper, old newspapers, used\r\n"
//						+ "papers and journal files: These are segregated, stored separately and given away to scrap\r\n"
//						+ "dealers/vendors/recyclers. Apart from dry solid waste, food waste from canteens is collected by authorized\r\n"
//						+ "agents for use as cattle feed. All the waste is disposed off in a safe and eco-friendly manner.Color coded\r\n"
//						+ "waste collection Bins are placed on the college premises to collect solid waste." + "\r\n",
//				font5);
//		paragraph22criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph22criteria7);
//		// liquidManagement
//		/*
//		 * Font fontParagraph2128 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2128.setSize(12);
//		 */
//		Paragraph paragraph23criteria7 = new Paragraph("Liquid Waste Management:", font3);
//		document.add(paragraph23criteria7);
//		/*
//		 * Font fontParagraph2130 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2130.setSize(12);
//		 */
//		Paragraph paragraph24criteria7 = new Paragraph(
//				"The liquid waste generated in the institution includes laboratory, and canteen effluent wastes. These are\r\n"
//						+ "drained to a pit in distant open land. The laboratory waste water does not contain any hazardous chemicals.\r\n"
//						+ "E-Waste Management: Electronic waste as created when an electronic product is discarded after the end\r\n"
//						+ "of its useful life, which includes obsolete electronic devices, such as computer systems, servers, monitors,\r\n"
//						+ "compact discs (CDs), printers, scanners, copiers, calculators, fax machines, battery cells etc.is handed over\r\n"
//						+ "to an agency. The institution has adopted the following with the objective of creating an eco-friendly\r\n"
//						+ "environment in the campus:\r\n"
//						+ "1.Major E-waste such as written off computers, CRTs, printers are to be collected for safe disposal.\r\n"
//						+ "2.All the miscellaneous e-waste such as CDs, batteries, PCBs, mice, key boards, printer cartridges are\r\n"
//						+ "also collected for safe disposal.\r\n"
//						+ "3.Re-filling of printer cartridges is carried out in a safe manner.\r\n"
//						+ "4.UPS batteries are periodically inspected and recharged or repaired as necessary. Once they are\r\n"
//						+ "dead, they are collected for safe disposal.",
//				font5);
//		paragraph24criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph24criteria7);
//
//		// waste
//		/*
//		 * Font fontParagraph2131 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2131.setSize(12);
//		 */
//		Paragraph paragraph25criteria7 = new Paragraph("Waste Recycling", font3);
//		document.add(paragraph25criteria7);
//		paragraph25criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		/*
//		 * Font fontParagraph2132 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2132.setSize(12);
//		 */
//		Paragraph paragraph26criteria7 = new Paragraph(
//				"Old newspapers, used papers, journal files are collected by an agency which in turn recycles the waste\r\n"
//						+ "paper for further use.",
//				font5);
//		document.add(paragraph26criteria7);
//		// 7.1.4
//
//		// creating table
//		PdfPTable table2criteria7 = new PdfPTable(2);
//		table2criteria7.setWidthPercentage(100);
//
//		com.lowagie.text.Font font11 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		font11.setColor(CMYKColor.BLACK);
//		// Create table for header pdfcell cell= new pdf cell
//		PdfPCell cell51criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//		PdfPCell cell52criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell0 = new PdfPCell();
//		cell0.setPadding(5);
//		PdfPCell cell53criteria7 = new PdfPCell(new Paragraph(
//				"Relevant documents like agreements/MoUs with\r\n" + "Government and other approved agencies\r\n\r\n\r\n"));
//		PdfPCell cell54criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//		PdfPCell cell55criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n\r\n "));
//		PdfPCell cell56criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//		PdfPCell cell57criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n\r\n"));
//		PdfPCell cell58criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//		PdfPCell cell59criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//		PdfPCell cell60criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//
//		table2criteria7.addCell(cell51criteria7);
//		table2criteria7.addCell(cell52criteria7);
//		table2criteria7.addCell(cell53criteria7);
//		table2criteria7.addCell(cell54criteria7);
//		table2criteria7.addCell(cell55criteria7);
//		table2criteria7.addCell(cell56criteria7);
//		table2criteria7.addCell(cell57criteria7);
//		table2criteria7.addCell(cell58criteria7);
//		table2criteria7.addCell(cell59criteria7);
//		table2criteria7.addCell(cell60criteria7);
//		table2criteria7.setSpacingBefore(20f);
//		table2criteria7.setSpacingAfter(20f);
//
//		document.add(table2criteria7);
//
//		paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		// 7.14
//		/*
//		 * Font fontParagraph2138 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2138.setSize(12);
//		 */
//		/*
//		 * Paragraph paragraph27criteria7 = new Paragraph(
//		 * "7.1.4 Water conservation facilities available in the Institution: \r\n" +
//		 * "1.Rain water harvesting\r\n" + "2.Borewell /Open well recharge\r\n" +
//		 * "3.Construction of tanks and bunds\r\n" + "4.Waste water recycling\r\n" +
//		 * "5.Maintenance of water bodies and distribution system in the campus" +
//		 * "Reesponse:" + (criteria7Record != null ?
//		 * criteria7Record.getResponseValue714() : ""), font3);
//		 * document.add(paragraph27criteria7);
//		 */
//
//		PdfPTable table3criteria7 = new PdfPTable(2);
//		PdfPTable table3criteria71 = new PdfPTable(1);
//		table3criteria7.setWidthPercentage(100f);
//		table3criteria71.setWidthPercentage(100f);
//
//		/*
//		 * com.lowagie.text.Font font12 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * font12.setColor(CMYKColor.BLACK);
//		 */
//
//		PdfPCell cell61criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//		PdfPCell cell62criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//
//		PdfPCell cell63criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n\r\n"));
//		PdfPCell cell64criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//
//		PdfPCell cell65criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//		PdfPCell cell66criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//
//		table3criteria7.addCell(cell61criteria7);
//		table3criteria7.addCell(cell62criteria7);
//		table3criteria7.addCell(cell63criteria7);
//		table3criteria7.addCell(cell64criteria7);
//		table3criteria7.addCell(cell65criteria7);
//		table3criteria7.addCell(cell66criteria7);
//
//		PdfPCell cell072 = new PdfPCell(
//				new Paragraph("7.1.4	Water conservation facilities available in the Institution:\r\n" + "\r\n"
//						+ "1.	Rain water harvesting\r\n" + "2.	Borewell /Open well recharge\r\n"
//						+ "3.	Construction of tanks and bunds\r\n" + "4.	Waste water recycling\r\n"
//						+ "5.	Maintenance of water bodies and distribution system in the campus\r\n" + "Response:"
//						+ (criteria7Fieldinfo != null
//								? criteria7Fieldinfo.getCriteria7FieldInfoQn().get(0).getResponse714()
//								: ""),
//						font3));
//
//		table3criteria71.addCell(cell072);
//
//		table3criteria71.addCell(table3criteria7);
//
//		table3criteria71.setSpacingBefore(20f);
//		table3criteria71.setSpacingAfter(20f);
//
//		document.add(table3criteria71);
//
//		// 7.15
//		/*
//		 * Font fontParagraph2139 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2139.setSize(12);
//		 */
//		/*
//		 * Paragraph paragraph28criteria7 = new
//		 * Paragraph("7.1.5 Green campus initiatives include: \r\n" +
//		 * "1.Restricted entry of automobiles \r\n" +
//		 * "2.Use of Bicycles/ Battery powered vehicles\r\n" +
//		 * "3.Pedestrian Friendly pathways\r\n" + "4.Ban on use of Plastic\r\n" +
//		 * "5.landscaping with trees and plants\r\n" + "Response: " + (criteria7Record
//		 * != null ? criteria7Record.getResponseValue715() : ""), font3);
//		 * 
//		 * document.add(paragraph28criteria7);
//		 */
//
//		// 7.15 table
//		PdfPTable table6criteria7 = new PdfPTable(2);
//		PdfPTable table6criteria72 = new PdfPTable(1);
//
//		table6criteria7.setWidthPercentage(100f);
//		table6criteria72.setWidthPercentage(100f);
//
//		/*
//		 * com.lowagie.text.Font font13 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * font13.setColor(CMYKColor.BLACK);
//		 */
//		PdfPCell cell67criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//		PdfPCell cell68criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell69criteria7 = new PdfPCell(
//				new Paragraph("Various policy documents / decisions circulated for\r\n\r\n\r\n" + "implementation"));
//		PdfPCell cell70criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//		PdfPCell cell71criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n"));
//		PdfPCell cell72criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//
////		PdfPCell cell73criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n"));
////		PdfPCell cell74criteria7 = new PdfPCell(
////				new Paragraph((criteria7Record != null ? criteria7file.get(11).getCriteria7FilePath() : "")));
//
//		table6criteria7.addCell(cell67criteria7);
//		table6criteria7.addCell(cell68criteria7);
//		table6criteria7.addCell(cell69criteria7);
//		table6criteria7.addCell(cell70criteria7);
//		table6criteria7.addCell(cell71criteria7);
//		table6criteria7.addCell(cell72criteria7);
////		table6criteria7.addCell(cell73criteria7);
////		table6criteria7.addCell(cell74criteria7);
//
//		PdfPCell cell073 = new PdfPCell(new Paragraph("7.1.5	Green campus initiatives include:\r\n" + "\r\n"
//				+ "1.	Restricted entry of automobiles\r\n" + "2.	Use of Bicycles/ Battery powered vehicles\r\n"
//				+ "3.	Pedestrian Friendly pathways\r\n" + "4.	Ban on use of Plastic\r\n"
//				+ "5.	landscaping with trees and plants\r\n" + "\r\n" + "Response:"
//				+ (criteria7Fieldinfo != null ? criteria7Fieldinfo.getCriteria7FieldInfoQn().get(0).getResponse715()
//						: ""),
//				font3));
//
//		table6criteria72.addCell(cell073);
//
//		table6criteria72.addCell(table6criteria7);
//
//		table6criteria72.setSpacingBefore(20f);
//		table6criteria72.setSpacingAfter(20f);
//
//		document.add(table6criteria72);
//
//		// 7.16
//		// 7.16 table
//		/*
//		 * Font fontParagraph2140 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2140.setSize(12);
//		 */
//		/*
//		 * Paragraph paragraph29criteria7 = new Paragraph(
//		 * "7.1.6 Quality audits on environment and energy are regularly undertaken by the Institution and any\r\n"
//		 * + "awards received for such green campus initiatives:\r\n" +
//		 * "1.Green audit\r\n" + "2.Energy audit\r\n" + "3.Environment audit\r\n" +
//		 * "4.Clean and green campus recognitions / awards\r\n" +
//		 * "5.Beyond the campus environmental promotion activities \r\n" + "Response: "
//		 * + (criteria7Record != null ? criteria7Record.getResponseValue716() : ""),
//		 * font3); document.add(paragraph29criteria7);
//		 */
//
//		PdfPTable table15criteria7 = new PdfPTable(2);
//		PdfPTable table15criteria73 = new PdfPTable(1);
//
//		table15criteria7.setWidthPercentage(100f);
//		table15criteria73.setWidthPercentage(100f);
//
//		com.lowagie.text.Font font131 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		font131.setColor(CMYKColor.BLACK);
//		PdfPCell cell75criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n"));
//		PdfPCell cell76criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n"));
//		PdfPCell cell77criteria7 = new PdfPCell(
//				new Paragraph("Reports on environment and energy audits\r\n" + "submitted by the auditing agency\r\n\r\n\r\n"));
//		PdfPCell cell78criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//		PdfPCell cell79criteria7 = new PdfPCell(new Paragraph("Certification by the auditing agency\r\n\r\n\r\n"));
//		PdfPCell cell80criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(13).getCriteria7FilePath() : "")));
//		PdfPCell cell81criteria7 = new PdfPCell(new Paragraph("Certificates of the awards received\r\n\r\n\r\n"));
//		PdfPCell cell82criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(14).getCriteria7FilePath() : "")));
////		PdfPCell cell83criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
////		PdfPCell cell84criteria7 = new PdfPCell(
////				new Paragraph((criteria7Record != null ? criteria7file.get(15).getCriteria7FilePath() : "")));
//
//		table15criteria7.addCell(cell75criteria7);
//		table15criteria7.addCell(cell76criteria7);
//		table15criteria7.addCell(cell77criteria7);
//		table15criteria7.addCell(cell78criteria7);
//		table15criteria7.addCell(cell79criteria7);
//		table15criteria7.addCell(cell80criteria7);
//		table15criteria7.addCell(cell81criteria7);
//		table15criteria7.addCell(cell82criteria7);
////		table15criteria7.addCell(cell83criteria7);
////		table15criteria7.addCell(cell84criteria7);
//
//		PdfPCell cell074 = new PdfPCell(new Paragraph(
//				"7.1.6	Quality audits on environment and energy are regularly undertaken by the Institution and any awards received for such green campus initiatives:\r\n"
//						+ "\r\n" + "1.	Green audit\r\n" + "2.	Energy audit\r\n" + "3.	Environment audit\r\n"
//						+ "4.	Clean and green campus recognitions / awards\r\n"
//						+ "5.	Beyond the campus environmental promotion activities\r\n" + "\r\n" + "Response:"
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQn().get(0).getResponse716()
//								: ""),
//				font3));
//
//		table15criteria73.addCell(cell074);
//
//		table15criteria73.addCell(table15criteria7);
//
//		table15criteria73.setSpacingBefore(20f);
//		table15criteria73.setSpacingAfter(20f);
//
//		document.add(table15criteria73);
//
//		// 7.1.7
//		/*
//		 * Font fontParagraph2141 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2141.setSize(12);
//		 */
//		/*
//		 * Paragraph paragraph30criteria7 = new Paragraph(
//		 * "7.1.7 The Institution has disabled-friendly, barrier free environment \r\n"
//		 * + "1.Built environment with ramps/lifts for easy access to classrooms.\r\n" +
//		 * "2.Divyangjan friendly washrooms\r\n" +
//		 * "3.Signage including tactile path, lights, display boards and signposts\r\n"
//		 * +
//		 * "4.Assistive technology and facilities for Divyangjan accessible website, screen-reading software,\r\n"
//		 * + "mechanized equipment\r\n" +
//		 * "5.Provision for enquiry and information : Human assistance, reader, scribe, soft copies of\r\n"
//		 * + "reading material, screen reading\r\n" + "Response:" + (criteria7Record !=
//		 * null ? criteria7Record.getResponseValue717() : ""), font3);
//		 * document.add(paragraph30criteria7);
//		 */
//		// 7.1.7 table
//		PdfPTable table17criteria7 = new PdfPTable(2);
//		PdfPTable table17criteria73 = new PdfPTable(1);
//
//		table17criteria7.setWidthPercentage(100f);
//		table17criteria73.setWidthPercentage(100f);
//		com.lowagie.text.Font font132 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		font132.setColor(CMYKColor.BLACK);
//		PdfPCell cell85criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n"));
//		PdfPCell cell86criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n"));
//		PdfPCell cell87criteria7 = new PdfPCell(
//				new Paragraph("Policy documents and information brochures on the\r\n" + "support to be provided"));
//		PdfPCell cell88criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(15).getCriteria7FilePath() : "")));
//		PdfPCell cell89criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n\r\n"));
//		PdfPCell cell90criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(16).getCriteria7FilePath() : "")));
//		PdfPCell cell91criteria7 = new PdfPCell(
//				new Paragraph("Details of the Software procured for providing the\r\n" + "assistance\r\n\r\n\r\n"));
//		PdfPCell cell92criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(17).getCriteria7FilePath() : "")));
////		PdfPCell cell93criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
////		PdfPCell cell94criteria7 = new PdfPCell(
////				new Paragraph((criteria7Record != null ? criteria7file.get(19).getCriteria7FilePath() : "")));
//
//		table17criteria7.addCell(cell85criteria7);
//		table17criteria7.addCell(cell86criteria7);
//		table17criteria7.addCell(cell87criteria7);
//		table17criteria7.addCell(cell88criteria7);
//		table17criteria7.addCell(cell89criteria7);
//		table17criteria7.addCell(cell90criteria7);
//		table17criteria7.addCell(cell91criteria7);
//		table17criteria7.addCell(cell92criteria7);
////		table17criteria7.addCell(cell93criteria7);
////		table17criteria7.addCell(cell94criteria7);
//
//		PdfPCell cell075 = new PdfPCell(
//				new Paragraph("7.1.7	The Institution has disabled-friendly, barrier free environment\r\n" + "\r\n"
//						+ "1.	Built environment with ramps/lifts for easy access to classrooms.\r\n"
//						+ "2.	Divyangjan friendly washrooms\r\n"
//						+ "3.	Signage including tactile path, lights, display boards and signposts\r\n"
//						+ "4.	Assistive technology and facilities for Divyangjan accessible website, screen-reading software, mechanized equipment\r\n"
//						+ "5.	Provision for enquiry and information : Human assistance, reader, scribe, soft copies of reading material, screen reading\r\n"
//						+ "\r\n" + "Response:"
//						+ (criteria7Record != null
//								? criteria7Fieldinfo.getCriteria7FieldInfoQn().get(0).getResponse717()
//								: ""),
//						font3));
//
//		table17criteria73.addCell(cell075);
//
//		table17criteria73.addCell(table17criteria7);
//
//		table17criteria73.setSpacingBefore(20f);
//		table17criteria73.setSpacingAfter(20f);
//
//		document.add(table17criteria73);
//
//		// 7.1.8
//		/*
//		 * Font fontParagraph2142 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2142.setSize(12);
//		 */
//		Paragraph paragraph31criteria7 = new Paragraph(
//				"7.1.8 Describe the Institutional efforts/initiatives in providing an inclusive environment i.e., tolerance\r\n"
//						+ "and harmony towards cultural, regional, linguistic, communal socioeconomic and other diversities\r\n"
//						+ "(within 500 words)." + "Response: "
//						+ (criteria7Fieldinfo != null
//								? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse718()
//								: ""),
//				font3);
//		document.add(paragraph31criteria7);
//
//		PdfPTable table718criteria7 = new PdfPTable(1);
//		table718criteria7.setWidthPercentage(100f);
//
//		/*
//		 * com.lowagie.text.Font fontcriteria7 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontcriteria7.setColor(CMYKColor.BLACK);
//		 */
//
//		PdfPCell cell718criteria7 = new PdfPCell(new Paragraph(
//				"7.1.8 Describe the Institutional efforts/initiatives in providing an inclusive environment i.e., tolerance and harmony towards cultural, regional, linguistic, communal socioeconomic and other diversities (within 500 words)."
//						+ "Response:"
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse718()
//								: ""),
//				font3));
//
//		table718criteria7.addCell(cell718criteria7);
//		table718criteria7.setSpacingBefore(20f);
//		table718criteria7.setSpacingAfter(20f);
//
//		document.add(table718criteria7);
//
//		/*
//		 * Font fontParagraph2143 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2143.setSize(12);
//		 */
//		Paragraph paragraph32criteria7 = new Paragraph(
//				"It is our conviction that curricular, co-curricular and extra-curricular (Games, sports, and cultural) activities\r\n"
//						+ "play an important role in the emotional, cognitive and social development of the student community.\r\n"
//						+ "Towards this end, Mother Teresa organizes several such events to promote various skills among students,\r\n"
//						+ "awareness and importance of empathy-oriented compassion, cultural, regional, religious, linguistic and\r\n"
//						+ "communal tolerance needed for practicing in a highly pluralistic society which ultimately has widespread\r\n"
//						+ "socio-economic ramifications. Despite the individual characteristics and reservations that students may\r\n"
//						+ "have, such events organized by the institution, strengthen unity among students and help in developing a\r\n"
//						+ "spirit of consensus and cooperation through dialogue and team-activities.\r\n"
//						+ "Mother Teresa has established several student clubs which have been promoting various activities to sensitize\r\n"
//						+ "and play a vital role in promoting and building an inclusive environment in the institution.\r\n"
//						+ "Fine arts club of Mother Teresa conducts Music competitions (both vocal and instrumental) for students.\r\n"
//						+ "Music lovers among students with proficiency in Western, Classical (Carnatic and Hindustani) participate\r\n"
//						+ "in these events, which facilitate harmony among students, respecting each other, also curates their\r\n"
//						+ "associated culture. Students play skits and enact dramas with various themes such as mythological,\r\n"
//						+ "historical and social. These activities conducted in different languages, and themes have been facilitating\r\n"
//						+ "students to be aware of Indian, Western and other mythologies, history and socio-economic aspects,\r\n"
//						+ "thereby developing a sense of tolerance towards various cultures across the globe.\r\n"
//						+ "Students of Photography club of Mother Teresa exhibit their skills and talent displaying photos they have\r\n"
//						+ "shot, depicting not only nature, but also the socio-economic divide between rural and urban India, as well\r\n"
//						+ "as the huge chasm among people living in under-developed and developed countries. Such photographs\r\n"
//						+ "and interactions facilitate students to enhance their emotional quotient and compassion leading to selfactualization. \r\n"
//						+ "Mandatory courses in the curriculum, namely, Environmental science, Human Values and Professional\r\n"
//						+ "Ethics (HVPE) help students in understanding the importance of environmental awareness, a deep rooted\r\n"
//						+ "commiseration towards underprivileged sections of society leading to strong empathy facilitating\r\n"
//						+ "sustainable development.\r\n"
//						+ "Environmental club of the institution has been acting as a catalyst in furthering and promoting protection\r\n"
//						+ "of environment, leading to peace, harmony and prosperity in the immediate society.\r\n"
//						+ "Traditional days are observed in celebration of India’s diverse culture, wherein, faculty, staff and students\r\n"
//						+ "wear traditional attire, symbolizing their home state, promote awareness of various cultures prevalent in\r\n"
//						+ "Indian society and thus promote tolerance, inclusivity and cooperative living.\r\n"
//						+ "Through its NSS unit, Mother Teresa celebrates National Festivals, Independence Day, Republic Day and\r\n"
//						+ "commemoration days of eminent personalities by conducting Blood Donation camps, Orientation\r\n"
//						+ "Programs, explaining the importance and benefits of community service involving faculty, staff and\r\n"
//						+ "students. College also conducts several games, sports, debates, essay writing competitions on important\r\n"
//						+ "National days, signifying their importance, wherein students participate in large numbers.\r\n"
//						+ "Through all these activities, students are nurtured to exhibit tolerance and harmony towards various\r\n"
//
//						+ "cultural, regional, linguistic, and communal diversities, and develop esprit de corps with compassion on\r\n"
//						+ "socio-economic factors for a harmonious, peaceful and prosperous society, paving way for sustainable\r\n"
//						+ "development",
//				font5);
//		paragraph32criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph32criteria7);
//
//		// 7.1.8 table
//
//		PdfPTable table18criteria7 = new PdfPTable(2);
//		table18criteria7.setWidthPercentage(100f);
//		com.lowagie.text.Font font133 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		font133.setColor(CMYKColor.BLACK);
//		PdfPCell cell95criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//		PdfPCell cell96criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell97criteria7 = new PdfPCell(
//				new Paragraph("Policy documents and information brochures on the\r\n" + "support to be provided"));
//		PdfPCell cell98criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(18).getCriteria7FilePath() : "")));
////		PdfPCell cell99criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities"));
////		PdfPCell cell100criteria7 = new PdfPCell(
////				new Paragraph((criteria7Record != null ? criteria7file.get(21).getCriteria7FilePath() : "")));
////		PdfPCell cell101criteria7 = new PdfPCell(
////				new Paragraph("Details of the Software procured for providing the" + "assistance\r\n\r\n\r\n"));
////		PdfPCell cell102criteria7 = new PdfPCell(
////				new Paragraph((criteria7Record != null ? criteria7file.get(22).getCriteria7FilePath() : "")));
////		PdfPCell cell103criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
////		PdfPCell cell104criteria7 = new PdfPCell(
////				new Paragraph((criteria7Record != null ? criteria7file.get(23).getCriteria7FilePath() : "")));
//
//		table18criteria7.addCell(cell95criteria7);
//		table18criteria7.addCell(cell96criteria7);
//		table18criteria7.addCell(cell97criteria7);
//		table18criteria7.addCell(cell98criteria7);
////		table18criteria7.addCell(cell99criteria7);
////		table18criteria7.addCell(cell100criteria7);
////		table18criteria7.addCell(cell101criteria7);
////		table18criteria7.addCell(cell102criteria7);
////		table18criteria7.addCell(cell103criteria7);
////		table18criteria7.addCell(cell104criteria7);
//		table18criteria7.setSpacingBefore(20f);
//		table18criteria7.setSpacingAfter(20f);
//
//		document.add(table18criteria7);
//
//		/*
//		 * // 7.1.9 Font fontParagraph2144 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2144.setSize(12);
//		 */
//		Paragraph paragraph33criteria7 = new Paragraph(
//				"7.1.9 Sensitization of students and employees of the Institution to the constitutional obligations:\r\n"
//						+ "values, rights, duties and responsibilities of citizens (within 500 words).\r\n"
//
//						+ "Response: "
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse719()
//								: ""),
//				font3);
//		document.add(paragraph33criteria7);
//
//		PdfPTable table719criteria7 = new PdfPTable(1);
//		table719criteria7.setWidthPercentage(100f);
//
//		/*
//		 * com.lowagie.text.Font fontcriteria7 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontcriteria7.setColor(CMYKColor.BLACK);
//		 */
//
//		PdfPCell cell719criteria7 = new PdfPCell(new Paragraph(
//				"7.1.9 Sensitization of students and employees of the Institution to the constitutional obligations: values, rights, duties and responsibilities of citizens (within 500 words).\r\n"
//						+ "\r\n" + "Response:"
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse719()
//								: ""),
//				font3));
//
//		table719criteria7.addCell(cell719criteria7);
//		table719criteria7.setSpacingBefore(20f);
//		table719criteria7.setSpacingAfter(20f);
//
//		document.add(table719criteria7);
//
//		/*
//		 * Font fontParagraph2145 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2145.setSize(12);
//		 */
//		Paragraph paragraph34criteria7 = new Paragraph(
//				"Mother Teresa strongly believes in Maslow’s theory of motivation, which at its highest level of pyramid\r\n"
//						+ "specifies “Self-Actualization”, that the purpose of human existence is to serve mankind. Towards this, we\r\n"
//						+ "consider education in general, higher education in particular, should facilitate realization of human\r\n"
//						+ "potential by making students, teachers, and higher educational administrators, conscious of human values\r\n"
//						+ "and societal development, so as to transform them into future ready global citizens.\r\n"
//						+ "Mother Teresa involves students in activities pertaining to strengthening core values, making them aware of\r\n"
//						+ "their rights, duties and responsibilities and help them in becoming responsible citizens.\r\n"
//						+ "/r/n",
//				font5);
//		document.add(paragraph34criteria7);
//		/*
//		 * Font fontParagraph2146 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2146.setSize(12);
//		 */
//		Paragraph paragraph35criteria7 = new Paragraph("Values: " + "/r/n", font3);
//		document.add(paragraph35criteria7);
//		/*
//		 * Font fontParagraph2147 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2147.setSize(12);
//		 */
//		Paragraph paragraph36criteria7 = new Paragraph(
//				"Towards this, Mother Teresa has been organizing blood donation (611units of Blood), free vaccination and\r\n"
//						+ "medical camps through student volunteers, giving infrastructural support for the physically challenged\r\n"
//						+ "(through ramps, lifts, large washrooms, wheel chair facility etc).\r\n"
//						+ "We believe that human values may be innate as well as acquired. When we have love, compassion and a\r\n"
//						+ "willingness to sacrifice our interests for others, it becomes a service. Values are to be learnt through\r\n"
//						+ "practices. Hence, Mother Teresates are made to remind that they are being watched and observed by peers and\r\n"
//						+ "conduct themselves as role models for others. Inculcation of Human Values is demonstrated first by\r\n"
//						+ "teacher, later imbibed by students. Faculty participate in Universal Human Values programs sponsored by\r\n"
//						+ "AICTE.\r\n"
//						+ "Courses on “Human Values and Professional Ethics” and “Indian Ethos” delivered through YouTube\r\n"
//						+ "videos, real life examples, case studies and anecdotes are presented giving rise to various perspectives on\r\n"
//						+ "situations in life, creating an everlasting impression on student’s mind, touching student’s heart, bringing\r\n"
//						+ "a paradigm shift in their thought process towards life. They are largely instrumental in bringing integrity,\r\n"
//						+ "competence and building a stronger character",
//				font5);
//		document.add(paragraph36criteria7);
//		/*
//		 * Font fontParagraph2148 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2148.setSize(12);
//		 */
//		Paragraph paragraph37criteria7 = new Paragraph(
//				"Rights, Duties and responsibilities of citizens:\r\n" + " " + "/r/n", font5);
//		document.add(paragraph37criteria7);
//		Font fontParagraph2149 = FontFactory.getFont(FontFactory.HELVETICA);
//		fontParagraph2149.setSize(12);
//		Paragraph paragraph38criteria7 = new Paragraph(
//				"The college offers a mandatory audit course on Indian Constitution which deals with fundamental rights\r\n"
//						+ " and responsibilities of citizens. College organizes programs which drives home the point that rights are\r\n"
//						+ "always associated with responsibilities and are mutually linked to one another.\r\n"
//						+ "Formal and informal, co-curricular and extra-curricular activities facilitate students to assume higher\r\n"
//						+ "responsibility, thereby rising to the occasion with goals oriented towards societal development. Students\r\n"
//						+ "develop an attitude to look at every challenge as an opportunity to improve or innovate for societal\r\n"
//						+ "benefits. \r\n"
//						+ "Student mentoring is a well-designed and planned activity wherein the student is continuously supported\r\n"
//						+ "and guided focusing on building student’s character, with an objective of making student behave as a\r\n"
//						+ "responsible citizen. \r\n"
//						+ "The college has been facilitating holistic development of students towards a more balanced life, profession\r\n"
//						+ "and happiness, by encouraging them to interact with a galaxy of personalities from various walks of life.\r\n"
//						+ "We have been organizing technical symposia, project exhibitions, activities through student clubs,\r\n"
//						+ "celebrations of national and international commemorative days, events and festivals promoting holistic\r\n"
//						+ "development of students thereby making them become not only technically sound professionals\r\n"
//						+ "contributing to technological advancements, and growth of the economy, but also become “Good Global\r\n"
//						+ "Citizens” promoting peace and harmony in the Society for sustainable development of mankind"
//						+ " " + "/r/n",
//				font5);
//		paragraph38criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph38criteria7);
//		// 7.1.1.9 table
//		PdfPTable table19criteria7 = new PdfPTable(2);
//		table19criteria7.setWidthPercentage(100f);
//		com.lowagie.text.Font font134 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		font134.setColor(CMYKColor.BLACK);
//		PdfPCell cell105criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//		PdfPCell cell106criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell107criteria7 = new PdfPCell(new Paragraph(" Details of activities that inculcate values;\r\n"
//				+ "necessary to render students in to responsible\r\n" + "citizens\r\n\r\n"));
//		PdfPCell cell108criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(19).getCriteria7FilePath() : "")));
//
//		PdfPCell cell109criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//		PdfPCell cell110criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(20).getCriteria7FilePath() : "")));
//
//		table19criteria7.addCell(cell105criteria7);
//		table19criteria7.addCell(cell106criteria7);
//		table19criteria7.addCell(cell107criteria7);
//		table19criteria7.addCell(cell107criteria7);
//		table19criteria7.addCell(cell108criteria7);
//		table19criteria7.addCell(cell109criteria7);
//		table19criteria7.addCell(cell110criteria7);
//		table19criteria7.setSpacingBefore(20f);
//		table19criteria7.setSpacingAfter(20f);
//		document.add(table19criteria7);
//
//		// 7.1.10
//		/*
//		 * Font fontParagraph2150 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2150.setSize(12);
//		 */
//		/*
//		 * Paragraph paragraph39criteria7 = new Paragraph(
//		 * "7.1.10 The Institution has a prescribed code of conduct for students, teachers, administrators and\r\n"
//		 * + "other staff and conducts periodic programmes in this regard. \r\n" +
//		 * "1.The Code of Conduct is displayed on the website\r\n" +
//		 * "2.There is a committee to monitor adherence to the Code of Conduct\r\n" +
//		 * "3.Institution organizes professional ethics programmes for students, teachers, administrators\r\n"
//		 * + "and other staff\r\n" +
//		 * "4.Annual awareness programmes on Code of Conduct are organized\r\n" +
//		 * "Response:" + (criteria7Record != null ?
//		 * criteria7Record.getResponseValue7110() : ""), font3);
//		 * 
//		 * document.add(paragraph39criteria7);
//		 */// 7.1.10
//
//		// 7.1.10 table
//
//		PdfPTable table31criteria7 = new PdfPTable(2);
//		PdfPTable table31criteria74 = new PdfPTable(1);
//
//		table31criteria7.setWidthPercentage(100);
//		table31criteria74.setWidthPercentage(100);
//
//		com.lowagie.text.Font font112 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		font112.setColor(CMYKColor.BLACK);
//		PdfPCell cell1111 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n"));
//		PdfPCell cell1112 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n"));
//		PdfPCell cell11113 = new PdfPCell(new Paragraph(
//				" Details of the monitoring committee composition and minutes of the committee meeting, number of\r\n"
//
//						+ "programmes organized, reports on the various\r\n"
//						+ "programs etc., in support of the claims\r\n\r\n\r\n"));
//		PdfPCell cell11114 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(21).getCriteria7FilePath() : "")));
//
//		PdfPCell cell1115 = new PdfPCell(new Paragraph("Code of ethics policy document\r\n\r\n\r\n"));
//		PdfPCell cell1116 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(22).getCriteria7FilePath() : "")));
//
//		PdfPCell cell11117 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//		PdfPCell cell1118 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(23).getCriteria7FilePath() : "")));
//
//		table31criteria7.addCell(cell1111);// 7.1.10 table
//		table31criteria7.addCell(cell1112);
//		table31criteria7.addCell(cell11113);
//		table31criteria7.addCell(cell11114);
//		table31criteria7.addCell(cell1115);
//		table31criteria7.addCell(cell1116);
//		table31criteria7.addCell(cell11117);
//		table31criteria7.addCell(cell1118);
//
//		PdfPCell cell076 = new PdfPCell(new Paragraph(
//				"7.1.10 The Institution has a prescribed code of conduct for students, teachers, administrators and other staff and conducts periodic programmes in this regard.\r\n"
//						+ "\r\n" + "1.	The Code of Conduct is displayed on the website\r\n"
//						+ "2.	There is a committee to monitor adherence to the Code of Conduct\r\n"
//						+ "3.	Institution organizes professional ethics programmes for students, teachers, administrators and other staff\r\n"
//						+ "4.	Annual awareness programmes on Code of Conduct are organized\r\n" + "\r\n"
//						+ "Response:\r\n"
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQn().get(0).getResponse7110()
//								: ""),
//				font3));
//
//		table31criteria74.addCell(cell076);
//
//		table31criteria74.addCell(table31criteria7);
//
//		table31criteria74.setSpacingBefore(20f);
//		table31criteria74.setSpacingAfter(20f);
//
//		document.add(table31criteria74);
//
//		// paragraph //7.1.11
//		/*
//		 * Font fontParagraph2151 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2151.setSize(12);
//		 */
//		Paragraph paragraph40criteria7 = new Paragraph(
//				"7.1.11 Institution celebrates / organizes national and international commemorative days, events and\r\n"
//						+ "festivals (within 500 words).\r\n" + "" + "Response: "
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse7111()
//								: ""),
//				font3);
//		//
//		document.add(paragraph40criteria7);
//
//		PdfPTable table7111criteria7 = new PdfPTable(1);
//		table7111criteria7.setWidthPercentage(100f);
//
//		/*
//		 * com.lowagie.text.Font fontcriteria7 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontcriteria7.setColor(CMYKColor.BLACK);
//		 */
//
//		PdfPCell cell7111criteria7 = new PdfPCell(new Paragraph(
//				"7.1.11 Institution celebrates / organizes national and international commemorative days, events and festivals (within 500 words).\r\n"
//						+ "\r\n" + "Response:"
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse7111()
//								: ""),
//				font3));
//
//		table7111criteria7.addCell(cell7111criteria7);
//		table7111criteria7.setSpacingBefore(20f);
//		table7111criteria7.setSpacingAfter(20f);
//
//		document.add(table7111criteria7);
//
//		// paragraph //
//		/*
//		 * Font fontParagraph2152 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2152.setSize(12);
//		 */
//		Paragraph paragraph41criteria7 = new Paragraph(
//				"The vibrant student clubs, and other units of the college celebrate several National and International\r\n"
//						+ "commemorative days, events and festivals. The gaiety of all Festivals, both National and International are\r\n"
//						+ "celebrated enthusiastically keeping in mind the traditions of the Indian Diaspora and Environmental\r\n"
//						+ "Protection. The jubilations encourage in sensitizing the young minds to foster a spirit of Multiculturalism.\r\n"
//						+ "Snippets of a few events celebrated are given hereunder:",
//				font5);
//		document.add(paragraph41criteria7);
//		// a.int
//		/*
//		 * Font fontParagraph2153 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2153.setSize(12);
//		 */
//		Paragraph paragraph42criteria7 = new Paragraph("A: International-level commemorative days celebrated:\r\n",
//				font3);
//		document.add(paragraph42criteria7);
//		// paragraph
//		/*
//		 * Font fontParagraph2154 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2154.setSize(12);
//		 */
//		Paragraph paragraph43criteria7 = new Paragraph(
//				"World Environmental Day(June 5). The Environmental Club of the college systematically hosts\r\n"
//						+ "programs to enlighten the students about restoration and protection of Nature for environmental\r\n"
//						+ "sustainability through Tree Plantations and “Save Energy” campaign. Special drives, namely, Haritha\r\n"
//						+ "Haram, making Eco-friendly Vinayaks, Earth Day etc. are organized. Young engineers share their thoughts\r\n"
//						+ "in Debates, Essay Writing, Group Discussions, Poster Presentation and Slogan Writing Competitions held\r\n"
//						+ "during these celebrations.\r\n"
//						+ "International Women’s Day(March 8). The tremendous Women Power is honored on International\r\n"
//						+ "Women’s Day in tune with the global celebrations. Students are sensitized to “Gender equality” through\r\n"
//						+ "some short video presentations. Successful women from all fields are invited to inspire the young minds.\r\n"
//						+ "International Yoga Day(June 21). Students are motivated to live up to the legacy of our culture. Eminent\r\n"
//						+ "Yoga instructors are invited to guide the participants to practice the asanas and lead healthy and joyful life.\r\n"
//						+ "Yoga competitions are conducted for faculty and students. \r\n"
//						+ "World Photography Day(August 19). The Photography Club of the college plays an active role in\r\n"
//						+ "organizing this day annually. The budding engineers share their best photographic shots and celebrate this\r\n"
//						+ "day by exhibiting the same.",
//				font5);
//		document.add(paragraph43criteria7);
//		// B: National-level commemorative days celebrated:
//		/*
//		 * Font fontParagraph2155 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2155.setSize(12);
//		 */
//		Paragraph paragraph44criteria7 = new Paragraph("B: National-level commemorative days celebrated:\r\n" + "\r\n",
//				font5);
//		document.add(paragraph44criteria7);
//		// paragraph
//		/*
//		 * Font fontParagraph2156 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2156.setSize(12);
//		 */
//		Paragraph paragraph45criteria7 = new Paragraph(
//				"Independence Day(August 15) and Republic Day(January 26). The campus echoes with music\r\n"
//						+ "professing the sacrifices made by our freedom fighters to instill and ignite a spirit of patriotism in the\r\n"
//						+ "young minds. Tributes are paid to people behind the framing of our Constitution and its ethos are shared\r\n"
//						+ "Page 112/129 13-08-2022 02:30:33\r\n"
//						+ "through some inspiring speeches and celebrations. We conduct events commemorating sacrifices of great\r\n"
//						+ "personalities.\r\n"
//						+ "National Science Day (February 28). Vaisheshika - Science Day is celebrated to pay homage of our\r\n"
//						+ "country’s first Nobel laureate in Science, Sir CV Raman, to inculcate the scientific temper in young minds.\r\n"
//						+ "To this end, an exhibition is conducted, wherein, students participate in large numbers and demonstrate\r\n"
//						+ "Working/Demo Models, Poster Presentations, etc.\r\n"
//						+ "National Mathematics Day (December 22). Commemorating the birth anniversary of mathematical\r\n"
//						+ "legend Sri Srinivasa Ramanujan to promote analytical and logical reasoning skills, quizzes, Advanced\r\n"
//						+ "Sudoku, Rubik’s Cube competitions are conducted.\r\n"
//						+ "Teacher’s Day (September 5). The Birth Anniversary of Dr. S. Radhakrishnan, is celebrated as Teacher’s\r\n"
//						+ "Day, with great enthusiasm. Students express their deep sense of gratitude on Teachers’ contribution for\r\n"
//						+ "the cause of education through anecdotes.\r\n"
//						+ "Engineer’s Day (September 15). The Birth Anniversary of Sir Mokshagundam Vishveswaraya is\r\n"
//						+ "celebrated as Engineer’s Day. Various competitions are held for students offering an opportunity to\r\n"
//						+ "showcase their Engineering Skills through the Projects they have executed. The philosophy is to motivate\r\n"
//						+ "young budding Engineers to emulate Sir Vishveswaraya, lauding his service to our city-Hyderabad"
//						+ "/r/n",
//				font5);
//		document.add(paragraph45criteria7);
//
//		// table 4
//		PdfPTable table4criteria7 = new PdfPTable(2);
//		table4criteria7.setWidthPercentage(100);
//
//		com.lowagie.text.Font font14 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		font14.setColor(CMYKColor.BLACK);
//		PdfPCell cell1119criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//		PdfPCell cell1120criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell1121criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of some of the events\r\n\r\n\r\n"));
//		PdfPCell cell1122criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(24).getCriteria7FilePath() : "")));
//
//		PdfPCell cell1123criteria7 = new PdfPCell(new Paragraph(
//				"Annual report of the celebrations and\r\n" + "commemorative events for the last five years\r\n\r\n\r\n"));
//		PdfPCell cell1124criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(25).getCriteria7FilePath() : "")));
//
//		table4criteria7.addCell(cell1119criteria7);
//		table4criteria7.addCell(cell1120criteria7);
//		table4criteria7.addCell(cell1121criteria7);
//		table4criteria7.addCell(cell1122criteria7);
//		table4criteria7.addCell(cell1123criteria7);
//		table4criteria7.addCell(cell1124criteria7);
//
//		table4criteria7.setSpacingBefore(20f);
//		table4criteria7.setSpacingAfter(20f);
//
//		document.add(table4criteria7);
//
//		// 7.2 Best Practices
//		/*
//		 * Font fontParagraph2157 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2157.setSize(13);
//		 */
//		
//		
//		document.close();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return file.toAbsolutePath().toString();
//}
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
//}
//
//
//	
//	
//	
//	
//
//
