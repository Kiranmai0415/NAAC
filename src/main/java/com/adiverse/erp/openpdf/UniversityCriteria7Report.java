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
//import com.lowagie.text.Image;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.pdf.CMYKColor;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//@Service
//public class UniversityCriteria7Report {
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
//
//public  String generateReport() throws DocumentException, IOException {
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
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse711()
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
//				new Paragraph((criteria7Record != null ? criteria7file.get(2).getCriteria7FilePath() : "")));
//		PdfPCell cell1190criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//		PdfPCell cell1191criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(3).getCriteria7FilePath() : "")));
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
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQn().get(0).getResponse712()
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
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse713()
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
//				+ (criteria7Record != null ? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse713()
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
//				new Paragraph((criteria7Record != null ? criteria7file.get(4).getCriteria7FilePath() : "")));
//		PdfPCell cell55criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n\r\n "));
//		PdfPCell cell56criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(5).getCriteria7FilePath() : "")));
//		PdfPCell cell57criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n\r\n"));
//		PdfPCell cell58criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(6).getCriteria7FilePath() : "")));
//		PdfPCell cell59criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//		PdfPCell cell60criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(7).getCriteria7FilePath() : "")));
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
//				new Paragraph((criteria7Record != null ? criteria7file.get(8).getCriteria7FilePath() : "")));
//
//		PdfPCell cell65criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//		PdfPCell cell66criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(9).getCriteria7FilePath() : "")));
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
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQn().get(0).getResponse714()
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
//				new Paragraph((criteria7Record != null ? criteria7file.get(10).getCriteria7FilePath() : "")));
//		PdfPCell cell71criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n"));
//		PdfPCell cell72criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(11).getCriteria7FilePath() : "")));
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
//				+ (criteria7Record != null ? criteria7Record.getCriteria7FieldInfoQn().get(0).getResponse715()
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
//				new Paragraph((criteria7Record != null ? criteria7file.get(12).getCriteria7FilePath() : "")));
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
//								? criteria7Record.getCriteria7FieldInfoQn().get(0).getResponse717()
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
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse718()
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
//		Paragraph paragraph46criteria7 = new Paragraph("7.2 Best Practices\r\n"
//
//				, font3);
//		document.add(paragraph46criteria7);
//
//		PdfPTable table721criteria7 = new PdfPTable(1);
//		table721criteria7.setWidthPercentage(100f);
//
//		/*
//		 * com.lowagie.text.Font fontcriteria7 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontcriteria7.setColor(CMYKColor.BLACK);
//		 */
//
//		PdfPCell cell721criteria7 = new PdfPCell(new Paragraph(
//				"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format provided in the Manual.\r\n"
//						+ "\r\n\r\n" + "Response:"
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse721()
//								: ""),
//				font3));
//
//		table721criteria7.addCell(cell721criteria7);
//		table721criteria7.setSpacingBefore(20f);
//		table721criteria7.setSpacingAfter(20f);
//
//		document.add(table721criteria7);
//
//		// 7.2.1
//		/*
//		 * Font fontParagraph2159 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2159.setSize(12);
//		 */
//		Paragraph paragraph48criteria7 = new Paragraph(
//				"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format\r\n"
//						+ "provided in the Manual.\r\n" + "\r\n" + "Response: \r\n" + "\r\n"
//						+ "Best Practice No. I:\r\n" + "\r\n" + "Title of the practice:\r\n" + "\r\n"
//						+ "“Reduced class strength for improved student learning and employability”\r\n" + "\r\n"
//						+ "Objectives of the Practice" + "Response:"
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse721()
//								: ""),
//				font3);
//		document.add(paragraph48criteria7);
//		/*
//		 * Font fontParagraph2160 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2160.setSize(12);
//		 */
//		Paragraph paragraph49criteria7 = new Paragraph("Enhance student-teacher interactions in labs/classes\r\n"
//				+ "Quicker feedback as faculty devote more time assessing students’ assignments, laboratory/project\r\n"
//				+ "work/tutorials for improved performance.\r\n"
//
//				+ "Enhanced learning experience through increased one to one participation among students and with\r\n"
//				+ "faculty, especially in labs/tutorial sessions\r\n"
//				+ "More opportunities to learn from peers, augmenting collaborative and cooperative learning\r\n"
//				+ "More discipline and control over the class leading to increased student engagement\r\n"
//				+ "With increased interaction among classmates, students gain quality learning experience."
//
//				, font5);
//		document.add(paragraph49criteria7);
////						
//		/*
//		 * Font fontParagraph2165 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2165.setSize(12);
//		 */
//
//		Paragraph paragraph51criteria7 = new Paragraph("Facilitate:", font3);
//		document.add(paragraph51criteria7);
//
//		/*
//		 * Font fontParagraph2167 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2167.setSize(12);
//		 */
//
//		Paragraph paragraph52criteria7 = new Paragraph(
//				"Comfortable seating arrangements\r\n" + "Improved Elbow-room to better manoeuvrability\r\n"
//						+ "Improved personal space\r\n" + "Better Student to Faculty ratio\r\n"
//						+ "enabling higher levels of student focus, eventually leading to improved performance.",
//				font5);
//		document.add(paragraph52criteria7);
//
//		/*
//		 * Font fontParagraph2166 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2166.setSize(12);
//		 */
//
//		Paragraph paragraph53criteria7 = new Paragraph("The Context" + "/r/n", font3);
//		document.add(paragraph53criteria7);
//
//		/*
//		 * Font fontParagraph2168 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2168.setSize(12);
//		 */
//
//		Paragraph paragraph54criteria7 = new Paragraph(
//				"“When classes are small enough to allow individual student-teacher interaction, a minor miracle\r\n"
//						+ "occurs: Teachers teach and students learn”",
//				font3);
//		document.add(paragraph54criteria7);
//
//		/*
//		 * Font fontParagraph2169 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2169.setSize(12);
//		 */
//
//		Paragraph paragraph55 = new Paragraph("– Lou Anne Johnson, teacher whose life inspired the movie,\r\n"
//				+ "“Dangerous Minds”\r\n"
//				+ "Of late, it has been observed that students’ focus and attention span is waning due to various factors:\r\n"
//				+ "digital media/technology, nuclear families leading to majority of students needing personal attention and\r\n"
//				+ "many such others.\r\n"
//				+ "Further, adolescence, acting as a catalyst, has necessitated need for ebhanced individual attention.\r\n"
//				+ "In this context, faculty need to understand student psychology, enable learning through close monitoring,\r\n"
//				+ "actively engaging, promoting originality/creativity, innovation, inculcating high-level analytical/logical\r\n"
//				+ "thinking skills, leading a path to exploration and providing quicker feedback on learning. This also\r\n"
//				+ "facilitates learner-centric approach, can be better put into practice, with smaller class sizes than larger ones.\r\n"
//				+ "Incidentally, effective mentoring of student can be conducted making student realize his/her true potential\r\n"
//				+ "leading to higher levels of performance." + "r/n", font5);
//
//		document.add(paragraph55);
//
//		/*
//		 * Font fontParagraph2170 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2170.setSize(12);
//		 */
//
//		Paragraph paragraph56 = new Paragraph("The Practice" + "/r/n", font3);
//		document.add(paragraph56);
//		/*
//		 * Font fontParagraph2171 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2171.setSize(12);
//		 */
//
//		Paragraph paragraph57 = new Paragraph(
//				"A few of our faculty who have studied and worked in universities abroad, have experienced that\r\n"
//						+ "coursework in a class with smaller number of students is congenial for reaching out to the needs of\r\n"
//						+ "students, ensuring greater individualization of instruction, better classroom control and, thus, better\r\n"
//						+ "learning ambience. Instructors have individual interactions with students, consulting with parents, giving\r\n"
//						+ "greater attention to students’ work. Class size is an important determinant of student outcomes.\r\n"
//						+ "Keeping this in view, in CSE and ECE classes, each section having 240 students, we have reduced the\r\n"
//						+ "class strength to 45-48 students per section instead of the normal 60 -66 students.\r\n"
//						+ "Towards this, departments have identified the requirement of additional faculty and infrastructure facilities.\r\n"
//						+ "Accordingly, the institution has recruited more faculty, and increased infrastructure facilities. This practice\r\n"
//						+ "has been adopted starting with the admitted batch of 2016-17 academic year soon after the college was\r\n"
//
//						+ "granted autonomous status.\r\n"
//						+ "Our classes have three-seater benches with six rows and four columns, capable of accommodating 72\r\n"
//						+ "students. However, we have ensured that the middle seat in each bench is kept vacant ensuring that\r\n"
//						+ "students have a more comfortable seating comfort needed since students spend nearly 6/7 hours a day. This\r\n"
//						+ "also ensures adequate social distancing, especially required during the pandemic and beyond. It also\r\n"
//						+ "reduces cross-talk, thereby noise in the classroom, thereby ensuring better class-room\r\n"
//						+ "management. Reduced class size also benefits slow learners and disadvantaged students hailing from rural\r\n"
//						+ "background" + "/r/n",
//				font5);
//		document.add(paragraph57);
//
//		/*
//		 * Font fontParagraph2172 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2172.setSize(12);
//		 */
//
//		Paragraph paragraph58 = new Paragraph("Consequences:" + "/r/n", font3);
//		document.add(paragraph58);
//
//		/*
//		 * Font fontParagraph2173 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2173.setSize(12);
//		 */
//
//		Paragraph paragraph59 = new Paragraph(
//				"Nearly 25% of faculty have been increased in CSE and ECE departments and the expenditure on salaries\r\n"
//						+ "also have increased by 1.5 crore rupees/year. Over and above, operational expenditure on labs, in terms of\r\n"
//						+ "consumables, equipment maintenance and repair, and electricity charges has increased.Expenditure on\r\n"
//						+ "civil infrastructure and class room furniture also increased, for which budgetary provisions have been made\r\n"
//						+ "and approved by the college." + "\r\n",
//				font5);
//		document.add(paragraph59);
//
//		/*
//		 * Font fontParagraph2175 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2175.setSize(12);
//		 */
//
//		Paragraph paragraph60 = new Paragraph("Evidence of Success \r\n"
//				+ "Ever since the academic year 2016-17, class size kept as 45-48, our graduate outcomes have\r\n"
//				+ "improved. More students have been participating in co-curricular activities, namely,\r\n"
//				+ "Project/Problem-based learning, paper/poster presentations, creative/innovative activities,\r\n"
//				+ "Hackathons, programming contests and student club activities leading to increased campus\r\n"
//				+ "placements with higher pay package. \r\n"
//				+ "Students have designed and built several prototypes, developing", font5);
//		document.add(paragraph60);
//
//		/*
//		 * Font fontParagraph2176 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2176.setSize(12);
//		 */
//
//		Paragraph paragraph61 = new Paragraph("collaborative/cooperative learning in\r\n"
//				+ "groups, discussing ideas, exchanging views/thoughts and listening to ideas of others with open mind\r\n"
//				+ "resulted in Mother Teresa securing a rank of 4 STAR in MHRD-IIC, EXCELLENT band in ARIIA and few\r\n"
//				+ "start-ups.", font5);
//		document.add(paragraph61);
//
//		/*
//		 * Font fontParagraph2177 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2177.setSize(12);
//		 */
//
//		Paragraph paragraph62 = new Paragraph(
//				"Reduction in class size also facilitated reduced workload on teachers as they need to mentor, assess\r\n"
//						+ "lesser number of students’ work, resulting in teacher spending quality time ensuring better and\r\n"
//						+ "improved learning experience for students leading to enhanced graduate outcomes and\r\n"
//						+ "employability. \r\n" + "\r\n" + "Problems Encountered and Resources Required",
//				font5);
//		document.add(paragraph62);
//
//		/*
//		 * Font fontParagraph2178 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2178.setSize(12);
//		 */
//
//		Paragraph paragraph63 = new Paragraph(
//				"Implemented smaller class sizes in CE, EEE and ME, also for one academic year. Unfortunately,\r\n"
//						+ "admissions in these are low in first year. However, lateral entry students join in second year, filling vacant\r\n"
//						+ "seats of first year. While reducing class size, increasing sections in second year, distribution of students in\r\n"
//						+ "order of merit/skills into another section needed students grouped earlier to be divided further. Parents and\r\n"
//						+ "students complained as students by then have developed rapport/friendship with some and were reluctant\r\n"
//						+ "to move. Hence, discontinued this in these disciplines.\r\n"
//						+ "Identifying and recruiting senior teachers, especially, domain experts in emerging areas of CSE, as several\r\n"
//						+ "colleges simultaneously started the same. Requires extensive training of existing faculty as well\r\n"
//						+ "as recruiting faculty available. \r\n" + "Page 115/129 13-08-2022 02:30:33\r\n"
//						+ "More Infrastructure, more faculty required, especially, senior teachers for second- and third-year classes\r\n"
//						+ "requiring more financial resources. Unfortunately, additional faculty salary is not considered while fixing\r\n"
//						+ "tuition fee by Government." + "/r/n",
//				font5);
//		document.add(paragraph63);
//
//		/*
//		 * Font fontParagraph2179 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2179.setSize(12);
//		 */
//
//		Paragraph paragraph64 = new Paragraph("Notes (Optional)\r\n" + "", font3);
//		document.add(paragraph64);
//
//		/*
//		 * Font fontParagraph2180 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2180.setSize(12);
//		 */
//
//		Paragraph paragraph65 = new Paragraph(
//				"It is suggested that other colleges may choose to adopt this practice in a stepwise manner, initially in the\r\n"
//						+ "departments in which strong faculty are available, carving a niche for the department, and then extend it to\r\n"
//						+ "other departments as this practice not only enhances overall skill set of students but also promotes a culture\r\n"
//						+ "of innovative spirit which in the long run may result in the establishment of many start-ups for promoting\r\n"
//						+ "Atmanirbhar/Make in India movement for sustainable development." + "/r/n" + "/r/n",
//				font5);
//		document.add(paragraph65);
//
//		/*
//		 * Font fontParagraph2181 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2181.setSize(12);
//		 */
//
//		Paragraph paragraph66 = new Paragraph("Best practice No. II:\r\n" + "Title of the practice\r\n"
//				+ "Decentralized departmental administration for improved scholarly academic/research\r\n"
//				+ "Objectives of the Practice" + "/r/n", font5);
//		document.add(paragraph66);
//
//		/*
//		 * Font fontParagraph2185 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2185.setSize(12);
//		 */
//
//		Paragraph paragraph67criteria7 = new Paragraph(
//				"Mother Teresa passionately believes that faculty is at the heart of all its Teaching-learning operations.\r\n"
//						+ "Attitudes of the teachers lie at the epicenter of significant innovation in education. The beliefs,\r\n"
//						+ "assumptions, and feelings of our teachers are the crux of our learning environment, thereby determining the\r\n"
//						+ "quality of life for students:"
//						// bullet
//						+ "Faculty development through a healthy mentor-mentee relationship\r\n"
//						+ "More learning opportunities for faculty, facilitating career progression\r\n"
//						+ "Ease of administration and functioning of department through decentralization\r\n"
//						+ "Establishment of second rung leadership in various specializations\r\n"
//						+ "Quality learning experience for students and faculty with satisfaction\r\n"
//						+ "Better resource managemen\r\n",
//				font5);
//		document.add(paragraph67criteria7);
//
//		/*
//		 * Font fontParagraph2186 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2186.setSize(12);
//		 */
//
//		Paragraph paragraph68 = new Paragraph("The Context\r\n");
//		document.add(paragraph68);
//
//		/*
//		 * Font fontParagraph2187 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2187.setSize(12);
//		 */
//
//		Paragraph paragraph69 = new Paragraph(
//				"Higher pay packages in industry luring the cream of young talent resulting mostly in less talented\r\n"
//						+ "professionals opting for teaching. Further, enormous increase in number of institutions, increased\r\n"
//						+ "divergency in many fields, resulting in more super specializations due to fast changing technological\r\n"
//						+ "advancements, lead to requirement for creation of good talent among professionals opting for teaching, by\r\n"
//						+ "nurturing them on nuances of teaching, being creative, innovative and updating themselves through\r\n"
//						+ "research. Meeting these challenges, Mother Teresa has structured each department into four/five\r\n"
//						+ "specializations with one senior faculty, a few more middle level faculty as mentors and four/five junior\r\n"
//						+ "faculty as mentees. In doing so, addressed a few teething problems.\r\n"
//						+ "Time constraint: Each faculty member has fixed workload. Fruitful discussions between mentormentee, call for allotted common free time during/after working hours making this an onerous task.\r\n"
//						+ "Apprehensions of faculty regarding exposure of their weaknesses, if any:");
//		document.add(paragraph69);
//
//		/*
//		 * Font fontParagraph2188 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2188.setSize(12);
//		 */
//
//		Paragraph paragraph70 = new Paragraph("The Practice", font3);
//		document.add(paragraph70);
//
//		/*
//		 * Font fontParagraph2189 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2188.setSize(12);
//		 */
//
//		Paragraph paragraph71 = new Paragraph(
//				"Each department is structured into four/five groups as per specializations.\r\n"
//						+ "Each group is led by a professor (Group Head) in the corresponding specialization, with 2/3 well\r\n"
//						+ "experienced faculty identified as lead faculty.\r\n"
//						+ "Group Head along with lead faculty act as Mentors for other faculty of the group, interacting closely,\r\n"
//						+ "guiding them in their academic and research pursuits.\r\n",
//				font5);
//		document.add(paragraph71);
//
//		/*
//		 * Font fontParagraph2190 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2190.setSize(12);
//		 */
//
//		Paragraph paragraph72 = new Paragraph("Facilitating quality teaching/r/n", font3);
//		document.add(paragraph72);
//
//		/*
//		 * Font fontParagraph2191 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2191.setSize(12);
//		 */
//
//		Paragraph paragraph73 = new Paragraph(
//				"Group head along with lead faculty meets mentee faculty at least twice a week and discusses with them on\r\n"
//						+ "preparation of a good lesson plan, establishing creative and innovative experiments, projects, giving handson exposure to students, conduct of student mentoring and use of modern tools, to name a few. Group head\r\n"
//						+ "also suggests faculty to attend FDPs/FIPs/workshops, Lectures of eminent teachers within/outside the\r\n"
//						+ "college in order to understand and practice various pedagogies.\r\n" + "",
//				font5);
//		document.add(paragraph73);
//
//		/*
//		 * Font fontParagraph2192 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2192.setSize(12);
//		 */
//
//		Paragraph paragraph74 = new Paragraph("Curricular development", font3);
//		document.add(paragraph74);
//
//		/*
//		 * Font fontParagraph2193 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2193.setSize(12);
//		 */
//
//		Paragraph paragraph75 = new Paragraph(
//				"Group head and lead faculty during their close interaction, identify overlapping components in the curriculum pertaining to their group and recommend for merger of courses, if any, as well as introduction\r\n"
//
//						+ "of new courses including electives in emerging areas to the Board of Studies. Identify emerging trends in industry, propose value-added courses for students to improve their skills."
//						+ "",
//				font5);
//		document.add(paragraph75);
//
//		/*
//		 * Font fontParagraph2194 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2194.setSize(12);
//		 */
//
//		Paragraph paragraph76 = new Paragraph("Inculcating an improved research culture" + "\r\n", font3);
//		document.add(paragraph76);
//
//		/*
//		 * Font fontParagraph2195 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2195.setSize(12);
//		 */
//
//		Paragraph paragraph77 = new Paragraph(
//				"Group head motivates junior faculty to pursue research, connects them to a network of researchers encourages to present seminars on research topics pertaining to the group by updating themselves, thereby,\r\n"
//
//						+ "facilitating in the identification of research guides, platforms for publication of research and establishment of research culture within the group\r\n"
//
//						+ "Group head helps faculty in implementing group’s long range plan in the development of \"Courses with diversity/multidisciplinary competence.\r\n"
//						+ "Global awareness and predicting technological advances, if any.Also suggests mentees to conform to international standards of all course offerings pertaining to the\r\n"
//
//						+ "division. Helps them in the identification of high-end equipment, hardware/software for procurement.\r\n"
//						+ "",
//				font5);
//		document.add(paragraph77);
//
//		/*
//		 * Font fontParagraph2196 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2196.setSize(12);
//		 */
//
//		Paragraph paragraph78 = new Paragraph("Identifying talent and development of leadership qualities");
//		document.add(paragraph78);
//
//		/*
//		 * Font fontParagraph2197 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2197.setSize(12);
//		 */
//
//		Paragraph paragraph79 = new Paragraph(
//				"It has also been facilitating in the creation of a fairly good talent pool and establishment of a second rung\r\n"
//						+ "leadership in various specializations of the department providing value added teaching learning process\r\n"
//						+ "and inculcating research culture, also enabling smooth administration/functioning of the department.\r\n"
//						+ "Junior faculty have also been able to associate themselves with all departmental/college’s cultural, and\r\n"
//						+ "other activities promoting a healthy collegial spirit among themselves, thereby facilitating the\r\n"
//
//						+ "administration in the development of potential leaders and identification of talent\r\n");
//		document.add(paragraph79);
//
//		/*
//		 * Font fontParagraph2199 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2199.setSize(12);
//		 */
//
//		Paragraph paragraph80 = new Paragraph("Evidence of Success\r\n" + "");
//		document.add(paragraph80);
//
//		/*
//		 * Font fontParagraph2100 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2100.setSize(12);
//		 */
//
//		Paragraph paragraph81 = new Paragraph(
//				"The above structure, kept in place since January 2017, has been bringing incremental improvements in the\r\n"
//						+ "teaching-learning process of theory courses, laboratory instruction, project/problem-based learning, student\r\n"
//						+ "participation in coding competitions, Hackathons and project exhibitions leading to development of prototypes. Faculty research publications and patents filed also improved.\r\n"
//
//						+ "This structure has been promoting a healthy mentor-mentee relationship among faculty, providing more learning opportunities for junior faculty\r\n"
//
//						+ "/r/n",
//				font5);
//		document.add(paragraph81);
//		PdfPTable table33criteria7 = new PdfPTable(6);
//		table33criteria7.setWidthPercentage(100);
//
//		com.lowagie.text.Font font41 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		font41.setColor(CMYKColor.BLACK);
//		PdfPCell cell191 = new PdfPCell(new Paragraph("S.No."));
//		PdfPCell cell201 = new PdfPCell(new Paragraph("Item/AY"));
//		PdfPCell cell211 = new PdfPCell(new Paragraph("2016-17"));
//
//		PdfPCell cell221 = new PdfPCell(new Paragraph("2017-18 "));
//
//		PdfPCell cell231 = new PdfPCell(new Paragraph("2018-19"));
//		PdfPCell cell124criteria7 = new PdfPCell(new Paragraph("2019-20"));
//
//		table33criteria7.addCell(cell191);
//		table33criteria7.addCell(cell201);
//		table33criteria7.addCell(cell211);
//		table33criteria7.addCell(cell221);
//		table33criteria7.addCell(cell231);
//		table33criteria7.addCell(cell124criteria7);
//
//		document.add(table33criteria7);
//
//		/*
//		 * Font fontParagraph2101 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2101.setSize(12);
//		 */
//		// table118
//		Paragraph paragraph82 = new Paragraph("Problems Encountered and Resources Required" + "/r/n");
//		document.add(paragraph82);
//
//		/*
//		 * Font fontParagraph2102 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2101.setSize(12);
//		 */
//
//		Paragraph paragraph83 = new Paragraph(
//				"No takers for certain specializations and few specializations have high demand.Attaching mentees to mentors based on research interests/specializations is increasingly becoming a tough\r\n"
//
//						+ "task, making some faculty members feeling jittery.Also sometimes resulting in unavailability of mentors in some specific areas/specializations, although more\r\n"
//
//						+ "junior faculty showing keen interest to pursue their research/offering courses in those specializations. It’s\r\n"
//						+ "because research areas of some mentors are not in emerging areas. Also, many group heads/senior faculty are bogged down with administrative responsibilities.\r\n",
//				font5);
//		document.add(paragraph83);
//		/*
//		 * Font fontParagraph2103 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2103.setSize(12);
//		 */
//
//		Paragraph paragraph84 = new Paragraph("Resources required" + "\r\n", font3);
//		document.add(paragraph84);
//
//		/*
//		 * Font fontParagraph2104 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph2104.setSize(12);
//		 */
//
//		Paragraph paragraph85 = new Paragraph("Competent faculty working in emerging areas\r\n"
//				+ "Adequate discussion rooms for each department\r\n"
//				+ "Seminar halls and research labs for each specialization/department\r\n"
//				+ "Adequate transportation facilities for faculty working late hours.\r\n"
//				+ "Recruitment of faculty and staff with administrative experience involving accreditations/affiliations\r\n"
//				+ "to reduce administrative load on group heads for increased mentor-mentee interaction for further\r\n"
//				+ "improvement of publications, patents and quality learning experience for all" + "\r\n", font5);
//		document.add(paragraph85);
//		document.add(paragraph85);
//
//		// document
//
//		/*
//		 * Font fontParagraph2105 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2105.setSize(12);
//		 */
//
//		Paragraph paragraph86 = new Paragraph("Notes (Optional)" + "\r\n", font5);
//		document.add(paragraph86);
//
//		/*
//		 * Font fontParagraph98 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph98.setSize(12);
//		 */
//		Paragraph paragraph87 = new Paragraph(
//				"This practice adopted by Mother Teresa can be replicated in other institutions as well. \r\n"
//						+ "Whenever parent institution finds itself relatively weak in some areas,may choose networking with other institutions where strong mentors with proven credentials are available.\r\n"
//
//						+ "This facilitates organization of FDPs/FIPs, collaborative research proposals, doctoral research guidance,creative and innovative projects by students and sharing of resources for a mutually beneficial outcome.\r\n"
//
//						+ "When this sort of networking takes place between institutions it can also facilitate several other activities,adoption of procedures and other institution’s best practices making both the institutions flourish. A group\r\n"
//
//						+ "of institutions may also come forward by networking together forming a consortium of institutions for enhancing faculty competences\r\n",
//				font5);
//		document.add(paragraph87);
//		// table5
//		PdfPTable table5criteria7 = new PdfPTable(2);
//		table5criteria7.setWidthPercentage(100);
//
//		PdfPCell cell1110 = new PdfPCell(new Paragraph("File Description\r\n\r\n"));
//		PdfPCell cell1134 = new PdfPCell(new Paragraph("Document\r\n\r\n"));
//		PdfPCell cell1135 = new PdfPCell(new Paragraph("Best practices in the Institutional web site\r\n\r\n "));
//		PdfPCell cell1136 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(26).getCriteria7FilePath() : "")));
//
//		table5criteria7.addCell(cell1110);
//		table5criteria7.addCell(cell1134);
//		table5criteria7.addCell(cell1135);
//		table5criteria7.addCell(cell1136);
//		table5criteria7.setSpacingBefore(20f);
//		table5criteria7.setSpacingAfter(20f);
//
//		document.add(table5criteria7);
//		// 7.3
//		/*
//		 * Font fontParagraph2106 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2106.setSize(12);
//		 */
//
//		Paragraph paragraph88 = new Paragraph("7.3 Institutional Distinctiveness\r\n", font3);
//		document.add(paragraph88);
//
//		// 7.3.1
//		/*
//		 * Font fontParagraph2107 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph2107.setSize(11);
//		 */
//
//		Paragraph paragraph89 = new Paragraph(
//				"7.3.1 Portray the performance of the Institution in one area distinctive to its priority and thrust\r\n"
//						+ "within 1000 words\r\n" + "\r\n" + "Response: \r\n" + "\r\n"
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse731()
//								: "")
//						+ "\r\nFacilitating training for improved Placements:",
//				font3);
//		document.add(paragraph89);
//
//		PdfPTable table731criteria7 = new PdfPTable(1);
//		table731criteria7.setWidthPercentage(100f);
//
//		/*
//		 * com.lowagie.text.Font fontcriteria7 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontcriteria7.setColor(CMYKColor.BLACK);
//		 */
//
//		PdfPCell cell731criteria7 = new PdfPCell(new Paragraph(
//				"7.3.1 Portray the performance of the Institution in one area distinctive to its priority and thrust within 1000 words\r\n"
//						+ "\r\n" + "Response:"
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse731()
//								: ""),
//				font3));
//
//		table731criteria7.addCell(cell731criteria7);
//		table731criteria7.setSpacingBefore(20f);
//		table731criteria7.setSpacingAfter(20f);
//
//		document.add(table731criteria7);
//
//		// paragraph
//
//		/*
//		 * Font fontParagraph324 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph324.setSize(12);
//		 */
//
//		Paragraph paragraph90 = new Paragraph(
//				"The first PEO of all programs of Mother Teresa is gainful employment or pursuit of higher education.Gainful employment is essentially facilitating students in securing a good job while studying in college, which we\r\n"
//
//						+ "are coining it as ‘Campus Placements’. This is an area of utmost priority for any professional college and so is the priority for Mother Teresa. In this context, Mother Teresa has been doing exceedingly well in terms of\r\n"
//
//						+ "getting the students placed in many IT and IT-enabled service (ITES) companies, namely, TCS, Wipro,Cognizant, Accenture, and others.\r\n"
//						+ ""
//						+ "Any parent and his/her ward always look for quality education coupled with a good placement. Mother Teresahas, therefore, designed its curricula, adopted teaching learning process, has been executing a meticulouslyplanned and structured training program, with a sharp focus on improving not only the number ofplacements but also quality of placements, particularly in terms of the salary package and reputation of thecompany, which is, Mother Teresa’s thirst and thrust.\r\n"
//						+ "Keeping this in view, skills namely, problem-solving, critical-thinking, logical-reasoning, programming,creativity, innovation communication and interpersonal skills, which employers look for in freshengineering graduates. College has undertaken several initiatives to impart these skills to students. Apartfrom strengthening the core teaching-learning process, which is the backbone of any college, Mother Teresahas been continuously striving in facilitating and supporting in the honing of the following skills among\r\n"
//						+ "students:\r\n" + "Basic programming skills\r\n" + "Advanced programming skills\r\n"
//						+ "Quantitative aptitude development\r\n" + "Critical thinking and logical reasoning\r\n"
//						+ "Verbal ability, creative and situational writing\r\n" + "Soft skills\r\n"
//						+ "Even though students of all engineering branches study Programing and Problem-solving using C language during their first year of engineering, non-CSE (ECE, EEE, ME, CE) students tend to lose touch with programming as they progress in their respective branch of engineering since they do not apply and use programming to solve problems pertaining to their engineering courses. As programming is now considered not only a necessary skill to be employable, but also a life skill, Mother Teresa has been encouraging faculty and students of all engineering branches to integrate programming into their regularlaboratory work and assignments in various courses, wherever possible.Mother Teresa has associated with professional third-party vendors to facilitate students with the necessary programming skills, mainly planned for targeted improvement of their employability opportunities.\r\n"
//						+ "Students from all branches of engineering, eligible for placements, are given training to refresh and enhance their programming skills. This usually takes place during the sixth (6th) semester and following summer vacation, just before the placement season begins in the first semester of their final year.It is observed that focused training in programming, sometimes designing and scheduling a mock placement drive for a specific company, has immensely helped students to get placed in higher numbers.\r\n"
//						+ "It is heartening to note that Mother Teresa has consistently done well in terms of placements in IT and ITES companies, with pay packages varying between 3.6 LPA and 4.5 LPA. However, the number of placements with product-based companies, wherein the pay packages are 5LPA – 10LPA and above is viewed as the hallmark of any good college. Keeping this in view, and with the strong placement record in IT and ITES companies, the next logical step is to aim at helping the students to develop the necessary skills to get selected in such companies that offer much higher pay packages. Most product-based companies, in addition to testing the students in their aptitude, also examine their higher order programming and problem-solving skills. Consequent to this thought process, we roped in\r\n"
//						+ "another third party premier training organization with proven track record, to impart necessary skills to get a job in product-based companies such as Amazon, Microsoft, DE Shaw etc., to train around 150 students, selected out of nearly 800, and started enhancing their advanced data structures, algorithms and problem solving skills since the academic 2020-21. The impact of this advanced training program is clearly visible in the increased number of placements for the 2021 and outgoing batches in product-based companies. For the 2023 outgoing batch of students, the training has commenced in their Third year second semester in order to provide ample time to hone their skills and also practice a large number of problems long before the placements season begins in July, 2022.\r\n"
//						+ "Some companies like Cognizant and Virtusa for example, have started hiring fresh engineering graduates in specialized roles such as Data Scientist, IoT Engineer, full Stack Developer and UI developer, Cloud Engineer etc. The students are expected to demonstrate significant skills in those areas at the time of recruitment.\r\n"
//						+ "Even though the current curriculum of CSE and IT branches provide for these areas, it is felt that PBL as a co-curricular activity would also help the students in enhancing their skills in emerging areas such as AI &\r\n"
//						+ "ML, Data Science, Cloud Computing, IoT and Cyber Security. We have entered into an association withSmartBridge and Cantilever labs, who offer externship programs designed to provide skills matching the needs of IT companies to our students at the end of their second year itself",
//				font5);
//		document.add(paragraph90);
//
//		// table6
//		PdfPTable table60 = new PdfPTable(5);
//		table60.setWidthPercentage(100);
//		// inside inside table6
//		/*
//		 * com.lowagie.text.Font font15 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//		 * font15.setColor(CMYKColor.BLACK);
//		 */
//		PdfPCell cell09criteria7 = new PdfPCell(new Paragraph("Batch"));
//		PdfPCell cell010criteria7 = new PdfPCell(new Paragraph("2018-22"));
//		PdfPCell cell011criteria7 = new PdfPCell(new Paragraph("2017-21 "));
//		PdfPCell cell012criteria7 = new PdfPCell(new Paragraph("2016-20"));
//		PdfPCell cell013criteria7 = new PdfPCell(new Paragraph("2015-19"));
//
//		table60.addCell(cell09criteria7);
//		table60.addCell(cell010criteria7);
//		table60.addCell(cell011criteria7);
//		table60.addCell(cell012criteria7);
//		table60.addCell(cell013criteria7);
//		table60.setSpacingBefore(20f);
//		table60.setSpacingAfter(20f);
//
//		document.add(table60);
//
//		/*
//		 * Font fontParagraph09 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph09.setSize(12);
//		 */
//
//		Paragraph paragraph190 = new Paragraph(
//				"As can be seen from the table, the total number of offers has increased from 547 to 1400, in the last threeyears (2018-19 to 2021-22). This significant growth, has resulted in a quantum jump in the number ofoffers in the Rs.4-5 LPA range as well as Rs.6 LPA and above. In the context of this perceptibly large improvement in the total number of offers over the years, this can be construed and even attributed to the training program imparted, which in our perception is not only highly desirable but also a distinctive practice of this growing institution.",
//				font3);
//		document.add(paragraph190);
//
//		PdfPTable table7criteria7 = new PdfPTable(2);
//		table4criteria7.setWidthPercentage(100);
//
//		/*
//		 * com.lowagie.text.Font font17 = FontFactory.getFont(FontFactory.TIMES_BOLD);
//		 * font17.setColor(CMYKColor.BLACK);
//		 */
//		PdfPCell cell22criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n,font3"));
//		PdfPCell cell23criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n,font3"));
//		PdfPCell cell24criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n"));
//		PdfPCell cell25criteria7 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(27).getCriteria7FilePath() : "")));
//		PdfPCell cell26criteria7 = new PdfPCell(new Paragraph("Appropriate web in the Institutional website\r\n\r\n"));
//
//		table7criteria7.addCell(cell22criteria7);
//		table7criteria7.addCell(cell23criteria7);
//		table7criteria7.addCell(cell24criteria7);
//		table7criteria7.addCell(cell25criteria7);
//		table7criteria7.addCell(cell26criteria7);
//		table7criteria7.setSpacingBefore(20f);
//		table7criteria7.setSpacingAfter(20f);
//
//		document.add(table7criteria7);
//
//		/*
//		 * Font fontParagraph008 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph008.setSize(12);
//		 */
//
//		Paragraph paragraph1901 = new Paragraph("5. CONCLUSION\r\n", font2);
//		document.add(paragraph1901);
//
//		/*
//		 * Font fontParagraph009 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph009.setSize(12);
//		 */
//
//		Paragraph paragraph1902 = new Paragraph("Additional Information:\r\n", font3);
//		document.add(paragraph1902);
//
//		/*
//		 * Font fontParagraph0010 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph0010.setSize(12);
//		 */
//
//		Paragraph paragraph1903 = new Paragraph(
//				"Mother Teresa, started administering UG programs in CSE with specializations in emerging areas (EA), namely,AIML, CS, DS, and IoT from the academic year 2020-21, in addition to the UG programs in CSE, ECE, EEE,IT, ME and CE. Currently, student intake in CSE, CSE(EA) and IT stands at 660 and for 2022-23 it is likely to go up to 780. Keeping this in view, and more than 90% of the recruitment happening in IT/ITES companies,Mother Teresa feels the necessity to have an increased tie-up with IT industry. To this end, in the academic year2021-22, institution has reconstituted its Governing body, Academic Council and Board of Studies of variousdepartments by inviting experts working at senior positions from IT industries, to guide the institution in-termsof curricular design, strengthening the training of students, in particular, with skill set requirements of IT/ITES companies, emphasizing in EA. \r\n"
//						+ "Further, Institution has organized faculty development programs in CSE(EA), to improve faculty competencies and about 60 faculty of CSE/IT/CSE(EA) have attended the same. Institution has also entered into MoUs for student and faculty training and student internships. About 10 senior faculty with specialization in CSE(EA) have joined the institution on invitation.\r\n"
//						+ "Non-CSE/IT discipline students are also given training on Programming skills to enhance their employability.\r\n"
//						+ "Further, students solve assignments in core engineering and mathematics courses using C-programming. \r\n"
//						+ "Emphasizing on multidisciplinary education and research, institution’s incubation centre tied-up with R&D organizations, and MSMEs, resulting in 20 prototype:",
//				font5);
//		document.add(paragraph1903);
//
//		/*
//		 * Font fontParagraph0011 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph0011.setSize(12);
//		 */
//
//		Paragraph paragraph1900 = new Paragraph(
//				"Institution has been invited to present a talk on “Best Practices in Technical Education-Financial Sustainability in Universities” at the All-India Conference of Vice-Chancellors of Universities offering Engineering and Technology programs held at the Jawaharlal Nehru Technological University Hyderabad, during April 8-9, 2022.\r\n"
//						+ "Institution has conducted two webinars on NEP-20.\r\n"
//						+ "With all the above additional efforts, to further improve the quality of professional education and to enhance its core capabilities, Mother Teresa is determined to not only reach out to the imminent employability and skill needs of our Learners, but has already been administering the same, to render our learners, a cut above the rest, facilitating them to perform much better",
//				font5);
//		document.add(paragraph1900);
//
//		/*
//		 * Font fontParagraph0012 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph0012.setSize(13);
//		 */
//
//		Paragraph paragraph19011 = new Paragraph("Concluding Remarks:\r\n", font3);
//		document.add(paragraph19011);
//
//		/*
//		 * Font fontParagraph0017 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph0017.setSize(12);
//		 */
//
//		Paragraph paragraph19018 = new Paragraph(
//				"Consequent to this, the institution has been getting its eligible UG programs duly accredited by NBA regularly since July 2012, and the institution itself is accredited by NAAC with “A” grade in June 2017. Currently, all its  2011, 4-star by IIC, ARIIA ranking in Excellent Band, MHRD and NIRF rank in 251-300 Band in 2021. eligible UG programs are accredited by NBA. Institution has also been recognized as SIRO, by DSIR, since Institution’s faculty have been publishing research papers and patents. Executed sponsored projects worth about Rs.1.15 crores Student placements have been continuously increasing, as also the highest pay package and median salary.  Although institutional effectiveness can be measured in many ways, one of the most fundamental measures is the success it has achieved in contributing to the achievement of its students’ goals, which is, ensuring students’ placements and/or facilitating them to pursue higher education, which is the first of the PEOs of all our UG Programs. As a matter of fact, it is also our institutional distinctiveness, giving priority and thrust. To this end, institution feels that it has been doing quite well, although it believes that there is much more that can be achieved in the years to come",
//				font5);
//		document.add(paragraph19018);
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
