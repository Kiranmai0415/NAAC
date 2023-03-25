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
//public class AffiliatedCriteria4Report {
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
//	public String generateReport() throws DocumentException, IOException {
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
//			Paragraph paragraph2criteria4 = new Paragraph("4.1 Physical Facilities", font2);
//			paragraph2criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph2criteria4);
//
//			/*
//			 * Font font2criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font2criteria4.setSize(12);
//			 */
//
//			PdfPTable table01criteria4 = new PdfPTable(1);
//
//			table01criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0criteria4 = new PdfPCell(new Paragraph(
//					"4.1.1 The Institution has adequate infrastructure and physical facilities for teaching- learning. viz., classrooms, laboratories, computing equipment etc.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse411()
//									: ""),
//					font3));
//			
//			PdfPCell cell00criteria4 = new PdfPCell(new Paragraph(
//					 (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getInput411t1()
//									: ""),
//					font3));
//			table01criteria4.addCell(cell0criteria4);
//
//			table01criteria4.addCell(cell00criteria4);
//
//			table01criteria4.setSpacingBefore(20f);
//			table01criteria4.setSpacingAfter(20f);
//
//			document.add(table01criteria4);
//
//		
//
//		
//
//			PdfPTable table411criteria4 = new PdfPTable(1);
//
//			
//			table411criteria4.setWidthPercentage(100);
//
//			
//			document.add(table411criteria4);
//
//			table411criteria4.setSpacingBefore(20f);
//			table411criteria4.setSpacingAfter(20f);
//
//			
//			
//
//		Paragraph paragraph5criteria4 = new Paragraph(
//					"Mother Teresa has a lush green campus of 13.5 acres, with aesthetically designed buildings, which has been providing notable academic ambience, conducive for Quality Teaching-Learning. The college has adequate infrastructure facilities for Instructional delivery and services as denoted below",
//					font5);
//			paragraph5criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph5criteria4);
//
//			
//			// creating table
//			PdfPTable tablecriteria4 = new PdfPTable(4);
//
//			tablecriteria4.setWidthPercentage(100);
//
//			Font font6criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font6criteria4.setColor(CMYKColor.BLACK);
//
//			PdfPCell cell1criteria4 = new PdfPCell(new Paragraph("File Description", font3));
//			PdfPCell cell2criteria4 = new PdfPCell(new Paragraph("Document", font3));
//			PdfPCell cell3criteria4 = new PdfPCell(new Paragraph("", font3));
//			PdfPCell cell4criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() :""));
//			PdfPCell cell5criteria4 = new PdfPCell(new Paragraph("Upload any additional information"));
//			PdfPCell cell6criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() :""));
//		
//			tablecriteria4.addCell(cell1criteria4);
//			tablecriteria4.addCell(cell2criteria4);
//			tablecriteria4.addCell(cell3criteria4);
//			tablecriteria4.addCell(cell4criteria4);
//			tablecriteria4.addCell(cell5criteria4);
//			tablecriteria4.addCell(cell6criteria4);
//			
//			tablecriteria4.setSpacingBefore(20f);
//			tablecriteria4.setSpacingAfter(20f);
//
//			document.add(tablecriteria4);
//
//			Paragraph paragraph7criteria4 = new Paragraph("* Expanded Examination center", font5);
//			paragraph7criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph8criteria4 = new Paragraph(
//					"All the classrooms are equipped with LCD Projectors, and have Wi-Fi connectivity. In addition, air- conditioned seminar halls have public address systems for optimum acoustics. College provides special facilities for differently-abled persons, viz., Lifts, Ramp/ Rails, and wheel chairs. College has adequate power backup and UPS facilities. Electrical load of the college supported through two transformers of 200kVA and 125kVA with contract load of 160kVA and 100kVA respectively. Backup is provided through two Kirloskar diesel generators of 200kVA and 380kVA, to ensure un-interrupted power, for academic activities. Personal cabins for Deans, HoDs, Professors and Associate Professors with computer and printer facilities are available. Additional Discussion rooms and Meeting rooms are available for anytime interactions with the students.",
//					font5);
//			paragraph8criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph9criteria4 = new Paragraph(
//					"Laboratories are adequately equipped and many have been established with industrial collaborations, viz., IBM, Redpine signals, Smartbridge and CDAC at a cost of Rs 53.98 lakhs. Centre of Excellence with Virtusa is established in specialized areas to provide domain-specific training to students. All the laboratories are supported through UPS with a total capacity of 680kVA. College also has installed a Solar power plant with a capacity of 250kw which is connected to the grid. Fire extinguishers are placed in each floor of every high-rise building for the safety of students and faculty. All laboratories are provided with required operating manuals for their smooth functioning. Laboratories are also kept open beyond working hours as per the requirement.",
//					font5);
//			paragraph9criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph10criteria4 = new Paragraph(
//					"In addition to the central Library which has a rich knowledge resource, of the institution, each department has a separate library with good collection of textbooks. Digital Library resources are accessible on LAN (Intranet) to all students and faculty. Library server has a large collection of learning material.",
//					font5);
//			paragraph10criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph11criteria4 = new Paragraph("Computing Equipment\r\n" + " ", font3);
//			paragraph11criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph7criteria4);
//			document.add(paragraph8criteria4);
//			document.add(paragraph9criteria4);
//			document.add(paragraph10criteria4);
//			document.add(paragraph11criteria4);
//
//			
//
//			Paragraph paragraph12criteria4 = new Paragraph("* 1276 old desktop computers were written off", font5);
//			paragraph12criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph12criteria4);
//
//			PdfPTable table2 = new PdfPTable(2);
//			table2.setWidthPercentage(100);
//
//			PdfPCell cell001criteria4 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell002criteria4 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell003criteria4 = new PdfPCell(new Paragraph("Upload Any additional information\r\n\r\n "));
//			PdfPCell cell004criteria4 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : ""));
//			PdfPCell cell005criteria4 = new PdfPCell(new Paragraph("paste link for additional information\r\n\r\n"));
//			PdfPCell cell006criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(3).getCriteria4FilePath() :""));
//
//			table2.addCell(cell001criteria4);
//			table2.addCell(cell002criteria4);
//			table2.addCell(cell003criteria4);
//			table2.addCell(cell004criteria4);
//			table2.addCell(cell005criteria4);
//			table2.addCell(cell006criteria4);
//
//			table2.setSpacingBefore(20f);
//			table2.setSpacingAfter(20f);
//
//			document.add(table2);
//
//			Paragraph paragraph13criteria4 = new Paragraph(
//					"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)",
//					font3);
//			paragraph13criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph14criteria4 = new Paragraph("Response:"
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse412()
//							: ""),
//					font3);
//			
//			
//			Paragraph paragraph140criteria4 = new Paragraph("Response:"
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getInput412t1()
//							: ""),
//					font3);
//			paragraph14criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph15criteria4 = new Paragraph(
//					"Mother Teresa�s conviction is, the college years are crucial in students� cognitive, emotional, moral, and social development. Their involvement with peers in various co-curricular and extra-curricular, sports and cultural activities, influence development of their cognitive skills, identity, self-concept, self-esteem, values and attitudes, behavior patterns, and personality. They come across people who see the world differently than themselves and hear a lot of ideas/perceptions, contrary to their own, which they may not agree with. This experience enables them to keep an open mind, respect others� views and try to understand, even if one does not agree with them.\r\n"
//							+ "\r\n"
//							+ "Towards the above, college with its sprawling, lush green open-air Auditorium having 3000 seating capacity provides abundant space, facilitates a number of events. Notable among them are: Graduation Day, Traditional Day, Orientation Day for First Year students, Bathukamma, a flower festival, Earth Day, College Day celebrations, Music, Singing, Dance, Rangoli, Skits, and Photo Exhibitions. Active participation of students in various events, facilitate development of Creativity, Innovative thinking, Leadership, and Emotional Quotient in them.\r\n"
//							+ "\r\n"
//							+ "The college has six blocks for instructional purposes and associated co-curricular, extra-curricular and cultural activities.\r\n"
//							+ "\r\n"
//							+ "Block-I has a 250-seater, Air-conditioned Seminar Hall, used for practicing singing, skits, dancing etc.\r\n"
//							+ "\r\n"
//							+ "The portico of Block II, overlooking an aesthetically laid out garden is the stage for smaller events, namely, Fashion Shows, Dance Competitions, Painting Exhibitions etc.\r\n"
//							+ "\r\n"
//							+ "In Block III, the 100-seat Seminar Hall facilitates conduct of cultural events with limited gathering. The grounds in front of Block-III houses Basketball Court.\r\n"
//							+ "\r\n"
//							+ "Block-IV is furnished with a 400-seat Air-conditioned Seminar Hall, used for performing dance, musical programs, etc.,\r\n"
//							+ "\r\n"
//							+ "Table-tennis, carroms and chess games are facilitated in the games room of Block V. To the right of Block V, houses Cricket net practice sessions.\r\n"
//							+ "\r\n"
//							+ "Yoga sessions are conducted on the lawns of the Open Auditorium and Seminar Halls. \r\n"
//							+ " ",
//					font5);
//			paragraph15criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph24criteria4 = new Paragraph("The open lawns facilitate the following:", font5);
//			paragraph24criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph241 = new Paragraph(" ", font5);
//			paragraph241.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet1criteria4 = new Chunk("\u2022", font5);
//			paragraph241.add(bullet1criteria4);
//
//			paragraph241.add(new Phrase("College day: VIBGYOR, VIBES\r\n" + "\r\n", font5));
//			paragraph241.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph242 = new Paragraph(" ", font5);
//			paragraph242.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet2criteria4 = new Chunk("\u2022", font5);
//			paragraph242.add(bullet2criteria4);
//
//			paragraph242.add(new Phrase("Yoga\r\n" + "\r\n", font5));
//
//			paragraph242.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph243 = new Paragraph(" ", font5);
//			paragraph243.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet3criteria4 = new Chunk("\u2022", font5);
//			paragraph243.add(bullet3criteria4);
//
//			paragraph243.add(new Phrase("Regional and National festivals of importance\r\n", font5));
//
//			paragraph243.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph244 = new Paragraph(" ", font5);
//			paragraph244.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet4criteria4 = new Chunk("\u2022", font5);
//			paragraph244.add(bullet4criteria4);
//
//			paragraph244.add(new Phrase(" Alumni association meet\r\n", font5));
//
//			paragraph244.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph245 = new Paragraph(" ", font5);
//			paragraph245.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet5criteria4 = new Chunk("\u2022", font5);
//			paragraph245.add(bullet5criteria4);
//
//			paragraph245.add(new Phrase("Mother Teresa family get together\r\n" + "\r\n", font5));
//
//			paragraph245.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph246 = new Paragraph(" ", font5);
//			paragraph246.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet6criteria4 = new Chunk("\u2022", font5);
//			paragraph246.add(bullet6criteria4);
//
//			paragraph246.add(new Phrase("Football practice\r\n" + "\r\n", font5));
//
//			paragraph246.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph21 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph21.setSize(12);
//			 */
//
//			Paragraph paragraph25criteria4 = new Paragraph(
//					"Institution allocates one/two-hour time slots in Timetable encouraging students participation in sports thereby inculcating sporting spirit in them and they understand that winning & losing are part of life. Transportation is arranged for students participating in sports and games beyond working hours to reach their homes. It�s the institution�s conviction that holistic development of a student is only possible, when students participate in several cultural, literary and sports activities over and above their academics. Mother Teresates won several laurels in State Under-19 competitions in many sports events in the past few years. ",
//					font5);
//			paragraph25criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph22criteria4 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph22criteria4.setSize(12);
//			 */
//
//			Paragraph paragraph26criteria4 = new Paragraph("Details of the facility created/r/n ", font3);
//			paragraph26criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph13criteria4);
//			document.add(paragraph14criteria4);
//			document.add(paragraph140criteria4);
//			document.add(paragraph15criteria4);
//			document.add(paragraph24criteria4);
//			document.add(paragraph241);
//			document.add(paragraph242);
//			document.add(paragraph243);
//			document.add(paragraph244);
//			document.add(paragraph245);
//			document.add(paragraph246);
//			document.add(paragraph25criteria4);
//			document.add(paragraph26criteria4);
//
//		
//
//			// Creating a table of 3 columns
//			PdfPTable table4criteria4 = new PdfPTable(2);
//			PdfPTable table412criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table4criteria4.setWidthPercentage(100);
//			table412criteria4.setWidthPercentage(100);
//
//			PdfPCell cell007 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//			PdfPCell cell008 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell0009 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n"));
//			PdfPCell cell0010 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(4).getCriteria4FilePath() : ""));
//			PdfPCell cell0011 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			/*PdfPCell cell0012 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : ""));
//			PdfPCell cell0013 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			PdfPCell cell0014 = new PdfPCell(new Paragraph(""));*/
//
//			table4criteria4.addCell(cell007);
//			table4criteria4.addCell(cell008);
//			table4criteria4.addCell(cell0009);
//			table4criteria4.addCell(cell0010);
//			table4criteria4.addCell(cell0011);
//			//table4criteria4.addCell(cell0012);
//			//table4criteria4.addCell(cell0013);
//			//table4criteria4.addCell(cell0014);
//
//			PdfPCell cell412criteria4 = new PdfPCell(new Paragraph(
//					"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse412()
//									: ""),
//					font3));
//
//			table412criteria4.addCell(cell412criteria4);
//			table412criteria4.addCell(table4criteria4);
//			table412criteria4.setSpacingBefore(20f);
//			table412criteria4.setSpacingAfter(20f);
//
//			document.add(table412criteria4);
//			
//			//YEAR TABLE 4121
////			if (criteria4Record != null) {
//	//
////				Table table4121 = new Table(criteria4Record.getAffiliated_YearTable4121().size(), 2);
//	//
////				table4121.setPadding(10);
////				table4121.setWidth(100f);
//	//
////				for (int i = 0; i < criteria4Record.getAffiliated_YearTable4121().size(); i++) {
////					table4121.addCell(criteria4Record.getAffiliated_YearTable4121().get(i).getInput4121y());
//	//
////				}
////				for (int i = 0; i < criteria4Record.getAffiliated_YearTable4121().size(); i++) {
////					table4121.addCell(criteria4Record.getAffiliated_YearTable4121().get(i).getInput4121v());
//	//
////				}
//	//
////				document.add(table4121);
////			}
//
//			
//
//			// Creating a table of columns
//			PdfPTable table5criteria4 = new PdfPTable(2);
//			PdfPTable table51 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table5criteria4.setWidthPercentage(100);
//			table51.setWidthPercentage(100);
//
//			PdfPCell cell0015 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//			PdfPCell cell0016 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell0017 = new PdfPCell(new Paragraph("Upload Number of classrooms and seminar halls\r\n"
//					+ "with ICT enabled facilities (Data Template)\r\n\r\n"));
//			PdfPCell cell0018 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(5).getCriteria4FilePath() : ""));
//			PdfPCell cell0019 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell0020 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(6).getCriteria4FilePath() : ""));
//			/*PdfPCell cell0021 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			PdfPCell cell0022 = new PdfPCell(new Paragraph());*/
//
//			table5criteria4.addCell(cell0015);
//			table5criteria4.addCell(cell0016);
//			table5criteria4.addCell(cell0017);
//			table5criteria4.addCell(cell0018);
//			table5criteria4.addCell(cell0019);
//			table5criteria4.addCell(cell0020);
//			//table5criteria4.addCell(cell0021);
//			//table5criteria4.addCell(cell0022);
//
//			table51.addCell(
//					"4.1.3 Percentage of classrooms and seminar halls with ICT- enabled facilities such as smart class, LMS, etc. (Data for the latest completed academic year)\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse413()
//									: ""));
//
//			table51.addCell("4.1.3.1 Number of classrooms and seminar halls with ICT facilities\r\n" + "\r\n\r\n" + "Response: "
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getInput4131t1() : ""));
//
//			// table51.addCell(criteria4List.get(0).getResponseValue413());
//
//			table51.addCell(table5criteria4);
//
//			table51.setSpacingBefore(20f);
//			table51.setSpacingAfter(20f);
//
//			document.add(table51);
//
//			// Creating a table of 3 columns
//			PdfPTable table6criteria4 = new PdfPTable(5);
//			PdfPTable table61criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table6criteria4.setWidthPercentage(100);
//			table61criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0023 = new PdfPCell(new Paragraph("File Description",font3));
//			PdfPCell cell0024 = new PdfPCell(new Paragraph("Documen",font3));
//			PdfPCell cell0025 = new PdfPCell(new Paragraph(" Upload Details of budget allocation, excluding\r\n"
//					+ "salary during the last five years (Data Template)"));
//			PdfPCell cell0026 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(7).getCriteria4FilePath():""));
//			PdfPCell cell0027 = new PdfPCell(new Paragraph("Upload audited utilization statements"));
//			PdfPCell cell0028 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(8).getCriteria4FilePath():""));
//		
//			table6criteria4.addCell(cell0023);
//			table6criteria4.addCell(cell0024);
//			table6criteria4.addCell(cell0025);
//			table6criteria4.addCell(cell0026);
//			table6criteria4.addCell(cell0027);
//			table6criteria4.addCell(cell0028);
//			
//			table61criteria4.addCell(
//					"4.1.4 Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)\r\n"
//							+ "\r\n" + "Response: "
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse414()
//									: ""));
//
//			// table61criteria4.addCell(criteria4List.get(0).getResponseValue414());
//
//			table61criteria4.addCell(
//					"4.1.4.1 Expenditure for infrastructure augmentation, excluding salary year-wise during last five years (INR in lakhs)\r\n\r\n");
//
//			// table61.addCell(table6);
//
//			table61criteria4.setSpacingBefore(20f);
//			table61criteria4.setSpacingAfter(20f);
//
//			document.add(table61criteria4);
//
//			if (criteria4Record != null) {
//
//				Table table4141 = new Table(criteria4Record.getYearTable4141().size(), 2);
//
//				table4141.setPadding(10);
//				table4141.setWidth(100f);
//
//				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
//					table4141.addCell(criteria4Record.getYearTable4141().get(i).getInput4141y());
//
//				}
//				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
//					table4141.addCell(criteria4Record.getYearTable4141().get(i).getInput4141v());
//
//				}
//
//				document.add(table4141);
//			}
//
//			// Creating a table of 3 columns
//			PdfPTable table7criteria4 = new PdfPTable(2);
//
//			// Setting width of table, its columns and spacing
//			table7criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0033 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font6criteria4));
//			PdfPCell cell0034 = new PdfPCell(new Paragraph("Document\r\n\r\n", font6criteria4));
//			PdfPCell cell0035 = new PdfPCell(
//					new Paragraph("Upload Details of Expenditure , excluding salary during the last five years\r\n\r\n "));
//			PdfPCell cell0036 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(9).getCriteria4FilePath() : ""));
//			PdfPCell cell0037 = new PdfPCell(new Paragraph("Upload audited utilization statements\r\n\r\n"));
//			PdfPCell cell0038 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(10).getCriteria4FilePath() : ""));
//			PdfPCell cell0039 = new PdfPCell(new Paragraph(" Link for any additional information\r\n\r\n"));
//			PdfPCell cell0040 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(11).getCriteria4FilePath() :""));
//
//			table7criteria4.addCell(cell0033);
//			table7criteria4.addCell(cell0034);
//			table7criteria4.addCell(cell0035);
//			table7criteria4.addCell(cell0036);
//			table7criteria4.addCell(cell0037);
//			table7criteria4.addCell(cell0038);
//			table7criteria4.addCell(cell0039);
//			table7criteria4.addCell(cell0040);
//
//			table7criteria4.setSpacingBefore(20f);
//			table7criteria4.setSpacingAfter(20f);
//
//			document.add(table7criteria4);
//
//			/*
//			 * Font fontParagraph27 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph27.setSize(12);
//			 */
//
//			
//			// 4.2
//			
//			Paragraph paragraph31criteria4 = new Paragraph("4.2 Library as a Learning Resource\r\n\r\n\r\n", font1);
//			paragraph31criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//	        Paragraph paragraph32criteria4 = new Paragraph(
//					"4.2.1	Library is automated using Integrated Library Management System (ILMS)\r\n" + "Response",
//					font2);
//			paragraph32criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			PdfPTable table421criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table421criteria4.setWidthPercentage(100);
//
//			table421criteria4.addCell(
//					"4.2.1 Library is automated using Integrated Library Management System (ILMS)\r\n\r\n+ Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse421()
//									: ""));
//			table421criteria4.addCell(
//					(criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getInput421t1()
//									: ""));
//			
//			
//			
//			// table421criteria4.addCell(criteria4List.get(3).getResponseValue421());
//			document.add(table421criteria4);
//
//			table421criteria4.setSpacingBefore(20f);
//			table421criteria4.setSpacingAfter(20f);
//			document.add(table421criteria4);
//
//			/*
//			 * Font fontParagraph29 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph29.setSize(12);
//			 */
//
//			Paragraph paragraph33criteria4 = new Paragraph("4.2 Response:"
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse421()
//							: ""),
//					font3);
//			paragraph33criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph30 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph30.setSize(12);
//			 */
//
//			Paragraph paragraph34criteria4 = new Paragraph(
//					"Mother Teresa has a spacious central library in an independent building with an area of 1064 Sqm. spread over two floors. Ground Floor is accommodating OPAC, periodicals, News Papers, digital library, thesis, reprography and special reference. First floor is accommodating circulation, references, periodical back volumes, computer centre etc. It is having a modern infrastructure with a seating capacity of 250 students. ",
//					font5);
//			paragraph34criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph31 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph31.setSize(12);
//			 */
//
//			Paragraph paragraph35criteria4 = new Paragraph(
//					"Central Library is fully automated with Integrated Library Management Software, Ez School version\r\n"
//							+ "10.0.9.22 and On Edu software used for circulation, procurement, Online Public Access Catalogue (OPAC). All library documents are bar-coded and books are issued to users by scanning the barcode of the document\r\n"
//							+ " ",
//					font5);
//			paragraph35criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph32 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph32.setSize(12);
//			 */
//
//			Paragraph paragraph36criteria4 = new Paragraph(
//					"Library & Information Centre provides uncompromising information and intellectual requirements to its students and faculty with user-friendly approach. It offers a fully integrated and dynamic environment for conducting academic study. Library is fully computerized with bar-coding system\r\n",
//					font5);
//			paragraph36criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph361 = new Paragraph(" ", font5);
//			paragraph361.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet7criteria4 = new Chunk("\u2022", font5);
//			paragraph361.add(bullet7criteria4);
//
//			paragraph361.add(new Phrase("Name of the ILMS software: Ez School Software and OnEdu Software\r\n", font5));
//
//			Paragraph paragraph362 = new Paragraph(" ", font5);
//			paragraph362.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet8criteria4 = new Chunk("\u2022", font5);
//			paragraph362.add(bullet8criteria4);
//
//			paragraph362.add(new Phrase("Nature of automation (full or partial): Fully Automated/r/n", font5));
//
//			Paragraph paragraph363 = new Paragraph(" ", font5);
//			paragraph363.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet9criteria4 = new Chunk("\u2022", font5);
//			paragraph363.add(bullet9criteria4);
//
//			paragraph363.add(new Phrase("Version: Ez School software 10.0.9.22 and OnEdu software/r/n", font5));
//
//			Paragraph paragraph364 = new Paragraph(" ", font5);
//			paragraph364.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet10criteria4 = new Chunk("\u2022", font5);
//			paragraph364.add(bullet10criteria4);
//
//			paragraph364.add(new Phrase("Year of automation :2009", font5));
//
//			/*
//			 * Font fontParagraph33 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph33.setSize(12);
//			 */
//
//			Paragraph paragraph37criteria4 = new Paragraph(
//					"The College has a Digital Library with 100 systems, connected to the college�s intranet, providing services, such as digitalized versions of question papers, syllabus, Articles of National and International standards, e-lectures of faculty of IITs, NPTEL, Textbooks, CD/DVDs, videos of Spoken English, video Films, Britannica Encyclopaedia, books for preparing towards GATE, GRE, TOFEL, CAT etc.\r\n"
//							+ "\r\n"
//							+ "Reference Section has various books including Personality Development Books and other books useful for student professional and career development.\r\n"
//							+ "\r\n"
//							+ "The Library has an Electronic Resource Centre (ERC) which provides access to vast stores of electronic information of IEEE, DELNET and unlimited number of digital, online open resource journals of Engineering, Applied Sciences, Management and other Internet-based service to its readers.\r\n"
//							+ "",
//					font5);
//			paragraph37criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph31criteria4);
//			document.add(paragraph32criteria4);
//			document.add(paragraph33criteria4);
//			document.add(paragraph34criteria4);
//			document.add(paragraph35criteria4);
//			document.add(paragraph36criteria4);
//			document.add(paragraph361);
//			document.add(paragraph362);
//			document.add(paragraph363);
//			document.add(paragraph364);
//			document.add(paragraph37criteria4);
//
//			// Creating a table of 3 columns
//			PdfPTable table8criteria4 = new PdfPTable(2);
//
//			// Setting width of table, its columns and spacing
//			table8criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0041 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font6criteria4));
//			PdfPCell cell0042 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
//			PdfPCell cell0043 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell0044 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(12).getCriteria4FilePath() : ""));
//			/*PdfPCell cell0045 = new PdfPCell(new Paragraph("Paste Link for additional information\r\n\r\n\r\n "));
//			PdfPCell cell0046 = new PdfPCell(new Paragraph(" "));*/
//
//			table8criteria4.addCell(cell0041);
//			table8criteria4.addCell(cell0042);
//			table8criteria4.addCell(cell0043);
//			table8criteria4.addCell(cell0044);
//			//table8criteria4.addCell(cell0045);
//			//table8criteria4.addCell(cell0046);
//
//			table8criteria4.setSpacingBefore(20f);
//			table8criteria4.setSpacingAfter(20f);
//			document.add(table8criteria4);
//
//			// Creating a table of 3 columns
//			PdfPTable table9criteria4 = new PdfPTable(2);
//			PdfPTable table10criteria4 = new PdfPTable(1);
//	        table9criteria4.setWidthPercentage(100);
//			table10criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0047 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font6criteria4));
//			PdfPCell cell0048 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
//			PdfPCell cell0049 = new PdfPCell(new Paragraph("Details of subscriptions like e-journals, eShodhSindhu, Shodhganga Membership , Remote\r\n"
//					+ "access to library resources, Web interface etc (Data\r\n"
//					+ "Template)\r\n\r\n\r\n"));
//			PdfPCell cell0050 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(13).getCriteria4FilePath() : ""));
//			/*PdfPCell cell0051 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell0052 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(9).getCriteria4FilePath() : ""));
//			PdfPCell cell0053 = new PdfPCell(new Paragraph(
//					"Details of subscriptions like e-journals, e-books , e- ShodhSindhu, Shodhganga Membership etc\r\n\r\n\r\n"));
//			PdfPCell cell0054 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(10).getCriteria4FilePath() : ""));*/
//
//			table9criteria4.addCell(cell0047);
//			table9criteria4.addCell(cell0048);
//			table9criteria4.addCell(cell0049);
//			table9criteria4.addCell(cell0050);
//			/*table9criteria4.addCell(cell0051);
//			table9criteria4.addCell(cell0052);
//			table9criteria4.addCell(cell0053);
//			table9criteria4.addCell(cell0054);*/
//
//			table10criteria4.addCell(
//					"4.2.2  The institution has subscription for the following e-resources\r\n\r\n"+"1.e-journals \r\n"
//							+ "2.e-ShodhSindhu\r\n"
//							+ "3.Shodhganga Membership\r\n"
//							+ "4.e-books\r\n"
//							+ "5.Databases\r\n"
//							+ "6.Remote access to e-resources"
//							+ "\r\n\r\n\r\n" + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse422()
//									: ""));
//			
//			table10criteria4.addCell(table9criteria4);
//
//			table10criteria4.setSpacingBefore(20f);
//			table10criteria4.setSpacingAfter(20f);
//
//			document.add(table10criteria4);
//
////			// Creating a table of 3 columns
////			PdfPTable table11criteria4 = new PdfPTable(5);
////			PdfPTable table12criteria4 = new PdfPTable(1);
////			table11criteria4.setWidthPercentage(100);
////			table12criteria4.setWidthPercentage(100);
//	//
//	//
//	//
////			table12criteria4.addCell(
////					"4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n"
////							+ "\r\n\r\n" + "Response: "
////							+ (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse423()
////									: ""));
////			// table12criteria4.addCell(criteria4List.get(4).getResponseValue423());
//	//
////			table12criteria4.addCell(
////					"4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)"
////							+ "\r\n\r\n\r\n");
//	//
////			
////			table12criteria4.setSpacingBefore(20f);
////			table12criteria4.setSpacingAfter(20f);
////	         document.add(table12criteria4);
////	         
//			//Year table 4231
//
//			if (criteria4Record != null) {
//
//				Table table4231 = new Table(criteria4Record.getYearTable4231().size(), 2);
//
//				table4231.setPadding(10);
//				table4231.setWidth(100f);
//
//				for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
//					table4231.addCell(criteria4Record.getYearTable4231().get(i).getInput4231y());
//
//				}
//				for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
//					table4231.addCell(criteria4Record.getYearTable4231().get(i).getInput4231v());
//
//				}
//
//				document.add(table4231);
//			}
//
//			// Creating a table of 3 columns
//
//			PdfPTable table13 = new PdfPTable(2);
//			PdfPTable table12criteria4 = new PdfPTable(1);
//
//			table13.setWidthPercentage(100);
//			table12criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0065 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font6criteria4));
//			PdfPCell cell0066 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
//			PdfPCell cell0067 = new PdfPCell(new Paragraph(
//					"Details of annual expenditure for purchase of and subscription to journals/e-journals during the last five years\r\n\r\n\r\n"));
//			PdfPCell cell0068 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(14).getCriteria4FilePath() : ""));
//			PdfPCell cell0069 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n\r\n"));
//			PdfPCell cell0070 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(15).getCriteria4FilePath() : ""));
//			table13.addCell(cell0065);
//			table13.addCell(cell0066);
//			table13.addCell(cell0067);
//			table13.addCell(cell0068);
//			table13.addCell(cell0069);
//			table13.addCell(cell0070);
//			table12criteria4.addCell("4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n"
//					+ "Response:"+(criteria4Record != null
//				? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse423()
//				: ""));
//			
//			table12criteria4.addCell("4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)");
//			table12criteria4.addCell(table13);
//			table12criteria4.setSpacingBefore(20f);
//			table12criteria4.setSpacingAfter(20f);
//	        document.add(table12criteria4);
//
//			
//			PdfPTable table14criteria4 = new PdfPTable(2);
//			PdfPTable table15 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table14criteria4.setWidthPercentage(100);
//			table15.setWidthPercentage(100);
//
//			PdfPCell cell0075 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font6criteria4));
//			PdfPCell cell0076 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
//			PdfPCell cell0077 = new PdfPCell(new Paragraph("Details of library usage by teachers and students\r\n\r\n\r\n"));
//			PdfPCell cell0078 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(16).getCriteria4FilePath() : ""));
//			PdfPCell cell0079 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell0080 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(17).getCriteria4FilePath() : ""));
//
//			table14criteria4.addCell(cell0075);
//			table14criteria4.addCell(cell0076);
//			table14criteria4.addCell(cell0077);
//			table14criteria4.addCell(cell0078);
//			table14criteria4.addCell(cell0079);
//			table14criteria4.addCell(cell0080);
//
//			table15.addCell(
//					"4.2.4  Percentage per day usage of library by teachers and students ( foot falls and login data for\r\n"
//					+ "online access) during the latest completed academic year\r\n"
//							+ "\r\n\r\n\r\n" + "Response: "
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse424()
//									: ""));
//
//			// table15.addCell(criteria4List.get(0).getResponseValue424());
//
//			table15.addCell("4.2.4.1  Number of teachers and students using library per day over last one year\r\n" + "\r\n"
//					+ "Response: "
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getInput4241t1() : ""));
//
//			table15.addCell(table14criteria4);
//
//			table15.setSpacingBefore(20f);
//			table15.setSpacingAfter(20f);
//
//			document.add(table15);
//
//		
//
//			Paragraph paragraph38criteria4 = new Paragraph("4.3 Infrastructure\r\n\rn", font1);
//			paragraph38criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//	         document.add(paragraph38criteria4);
//
//			Paragraph paragraph41 = new Paragraph(
//					"Mother Teresa considers that in the current information age no organization can survive without extensive use of IT. Towards this, the college has developed an IT policy encompassing all IT/IT enabled services used in the campus, ensuring smooth functioning with adequate security to all users connected to the campus network.\r\n"
//							+ "\r\n"
//							+ "Based on the laboratory and other requirements, every year college allocates budget for updating its IT facilities for procurement of computer systems and other IT related equipment including software.\r\n"
//							+ "\r\n"
//							+ "Every user in the campus is provided access to the campus network as well as internet.\r\n"
//							+ "\r\n"
//							+ "48 LCD projectors have been installed in class rooms and labs with wi-fi/internet connectivity.\r\n"
//							+ "\r\n"
//							+ "All students and faculty are given email accounts with college domain name through GSuite. The college has installed two firewalls in order to protect all its internal systems from cyber attacks.\r\n"
//							+ " \r\n"
//							+ "The college also installed CISCO switches for monitoring traffic in the campus network.\r\n"
//							+ "",
//					font5);
//			paragraph41.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph38 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph38.setSize(12);
//			 */
//
//			Paragraph paragraph42 = new Paragraph("The details of up-dation as follows:", font2);
//			paragraph42.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph39 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph39.setSize(12);
//			 */
//
//			Paragraph paragraph43criteria4 = new Paragraph("AY 2020-21\r\n" + "\r\n"
//					+ "1.	Procured 320 Lenovo computers of core i5 of 16GB RAM, 1TB HDD.\r\n"
//					+ "2.	Provided ICT Facilities in 06 class rooms\r\n"
//					+ "3.	Internet facility was upgraded from 210 Mbps to 1000 Mbps with two distinct service providers.\r\n"
//					+ "4.	ACT (Atria Convergence Technologies Ltd) Fibre (500Mbps).\r\n"
//					+ "5.D-Vios Communications Pvt Ltd.(500Mbps).\r\n" + " ", font5);
//			paragraph43criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph40 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph40.setSize(12);
//			 */
//
//			Paragraph paragraph44 = new Paragraph("AY 2019-20\r\n" + "\r\n"
//					+ "1.	Provided ICT Facilities in 04 class rooms\r\n"
//					+ "2.	Established Robotics Learning and Development Centre Lab in collaboration with Smart Bridge Educational Services Pvt. Ltd.\r\n"
//					+ "3.	Procured 256 Acer computers of core i5 of 8GB RAM, 1TB HDD.\r\n"
//					+ "4.	Installed Firewall �Sophos XG Firewall� for exam branch.\r\n" + " ", font5);
//			paragraph44.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph41 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph41.setSize(12);
//			 */
//
//			Paragraph paragraph45 = new Paragraph("AY 2019-20\r\n" + "\r\n"
//					+ "1.	Provided ICT Facilities in 04 class rooms\r\n"
//					+ "2.	Established Robotics Learning and Development Centre Lab in collaboration with Smart Bridge Educational Services Pvt. Ltd.\r\n"
//					+ "3.	Procured 256 Acer computers of core i5 of 8GB RAM, 1TB HDD.\r\n"
//					+ "4.	Installed Firewall �Sophos XG Firewall� for exam branch.\r\n" + " ", font5);
//			paragraph45.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph42 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph42.setSize(12);
//			 */
//
//			Paragraph paragraph46 = new Paragraph("AY 2018-19\r\n" + "\r\n"
//					+ "1.	Installed Firewall \"Sonicwall NSA 3600� for securing campus network.\r\n"
//					+ "2.	Provided ICT Facilities in 09 class rooms\r\n"
//					+ "3.	Established one more Computing centre with 100 systems each.\r\n"
//					+ "4.	Increased number of computer systems in existing Computing centre from 48 to 100.\r\n"
//					+ "5.	Anti-virus: Quick Heal Seqrite EPS antivirus software (500 Users) has been installed for all the systems with Windows OS.\r\n"
//					+ "6.	Procured 216 Acer computers of core i3 with 4GB RAM, 1TB HDD and 60 Lenovo Computers of core i3 with 4GB RAM, 1TB HDD.\r\n"
//					+ "7.	Internet facility was upgraded from 132 Mbps to 210 Mbps with two distinct service providers.\r\n"
//					+ "\r\n"
//
//					+ " ", font5);
//			paragraph46.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph43 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph43.setSize(12);
//			 */
//
//			Paragraph paragraph47 = new Paragraph("AY 2017-18\r\n" + "\r\n"
//					+ "1.	Procured 72 Acer computers of core i5 with 4GB RAM and 1TB HDD, 151 Acer computers of core i3 with 4GB RAM, 1 TB HDD and 170 Assembled computers of Dual Core with 4GB RAM, 1 TB HDD.\r\n"
//					+ "2.	Internet facility was upgraded from 48 Mbps to 132 Mbps with two distinct service providers.\r\n"
//
//					+ ":", font5);
//			paragraph47.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph44 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph44.setSize(12);
//			 */
//
//			Paragraph paragraph48 = new Paragraph("AY 2016-17\r\n" + "\r\n"
//					+ "1.	Intra-net connectivity is provided on the campus with 20 Gbps fibre-optic cable over and above the Reliance Jio campus wi-fi for daily usage of 1GB/User.\r\n"
//					+ "2.	Established IBM Software Lab for Emerging Technologies in collaboration with IBM.\r\n"
//					+ "3.	Procured 302 Assembled computers of Dual Core with 2GB RAM, 500GB HDD.\r\n" + "", font5);
//			paragraph48.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph45 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph45.setSize(12);
//			 */
//
//			Paragraph paragraph49 = new Paragraph("Year wise Allocated Budget for IT facilities:" + "", font3);
//			paragraph49.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			//document.add(paragraph38criteria4);
//			//document.add(paragraph39criteria4);
//			//document.add(paragraph40);
//			document.add(paragraph41);
//			document.add(paragraph42);
//			document.add(paragraph43criteria4);
//			document.add(paragraph44);
//			document.add(paragraph45);
//			document.add(paragraph46);
//			document.add(paragraph47);
//			document.add(paragraph48);
//			document.add(paragraph49);
//
//		
//			PdfPTable table17criteria4 = new PdfPTable(2);
//			PdfPCell cell0091 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell0092 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell0093 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell0094 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(18).getCriteria4FilePath() : ""));
//			
//			table17criteria4.addCell(cell0091);
//			table17criteria4.addCell(cell0092);
//			table17criteria4.addCell(cell0093);
//			table17criteria4.addCell(cell0094);
//			
//
//			PdfPCell cell431criteria4 = new PdfPCell(new Paragraph(
//					"4.3.1	 Institution frequently updates its IT facilities including Wi-Fi\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse431()
//									: ""),font3));
//			PdfPCell cell4310criteria4 = new PdfPCell(new Paragraph(
//					 (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getInput431t1()
//									: "")));
//			
//			table17criteria4.addCell(cell431criteria4);
//			table17criteria4.addCell(cell4310criteria4);
//			
//			document.add(table17criteria4);
//
//		
//			PdfPTable table18criteria4 = new PdfPTable(2);
//			PdfPTable table19criteria4 = new PdfPTable(1);
//
//			
//			table18criteria4.setWidthPercentage(100);
//			table19criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0097 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell0098 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell0099 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell00100 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(19).getCriteria4FilePath() : ""));
//			PdfPCell cell00101 = new PdfPCell(new Paragraph("Student - computer ratio\r\n\r\n\r\n"));
//			PdfPCell cell00102 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(20).getCriteria4FilePath() : ""));
//
//			table18criteria4.addCell(cell0097);
//			table18criteria4.addCell(cell0098);
//			table18criteria4.addCell(cell0099);
//			table18criteria4.addCell(cell00100);
//			table18criteria4.addCell(cell00101);
//			table18criteria4.addCell(cell00102);
//
////			table19criteria4.addCell("4.3.2 Student - Computer ratio (Data for the latest completed academic year)\r\n"
////					+ "\r\n\r\n" + "Response:"
////					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse432()
////							: ""));
//			
//			
//			PdfPCell cell4301criteria4 = new PdfPCell(new Paragraph(
//					"4.3.2 Student - Computer ratio (Data for the latest completed academic year)\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse432()
//								: ""),font3));
//			table18criteria4.addCell(cell4301criteria4);
//			table19criteria4.addCell( (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getInput432t2()
//							: ""));
//			
//
//			table19criteria4.addCell(table18criteria4);
//
//			table19criteria4.setSpacingBefore(20f);
//			table19criteria4.setSpacingAfter(20f);
//
//			document.add(table19criteria4);
//
//			// Creating a table of 3 columns
//
//			PdfPTable table20criteria4 = new PdfPTable(2);
//			PdfPTable table21criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table20criteria4.setWidthPercentage(100);
//			table21criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00103 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell00104 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00105 = new PdfPCell(
//					new Paragraph("Upload any additional Information\r\n\r\n\r\n"));
//			PdfPCell cell00106 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(21).getCriteria4FilePath() : ""));
//			
//			
//			PdfPCell cell00107 = new PdfPCell(
//					new Paragraph("Details of available bandwidth of internet connection in the Institution\r\n\r\n\r\n"));
//			PdfPCell cell00108 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(22).getCriteria4FilePath() : ""));
//
//			table20criteria4.addCell(cell00103);
//			table20criteria4.addCell(cell00104);
//			table20criteria4.addCell(cell00105);
//			table20criteria4.addCell(cell00106);
//			table20criteria4.addCell(cell00107);
//			table20criteria4.addCell(cell00108);
//			
//
//			table21criteria4.addCell("4.3.3 Bandwidth of internet connection in the Institution.\r\n" + "\r\n" + "Response:"
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse433()
//							: ""));
//
//			// table21criteria4.addCell(criteria4List.get(0).getResponseValue433());
//
//			table21criteria4.addCell(table20criteria4);
//			document.add(table21criteria4);
//
//
//			
//		
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
//			PdfPCell cell43001criteria4 = new PdfPCell(new Paragraph(
//					"4.4.1 Average percentage of expenditure incurred on maintenance of infrastructure (physical and"
//					+"academic support facilities) excluding salary component during the last five years(INR in Lakhs) \r\n\r\n" + "Response:"
//							+  (criteria4Record != null
//							? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse441(): ""),font3));
//			
//			table25criteria4.addCell(cell43001criteria4);
//			table25criteria4.addCell(
//					 (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQn().get(0).getInput441t1()
//									: ""));
//
//			table25criteria4.addCell(
//					"4.4.1.1 Expenditure incurred on maintenance of infrastructure (physical facilities and academic\r\n"
//					+ "support facilities) excluding salary component year-wise during the last five years (INR in lakhs)\r\n\r\n");
//
//			// table25.addCell(table24);
//
//			table25criteria4.setSpacingBefore(20f);
//			table25criteria4.setSpacingAfter(20f);
//
//			document.add(table25criteria4);
//			
//			//YEAR TABLE 4411
//
//			if (criteria4Record != null) {
//
//				Table table4411 = new Table(criteria4Record.getYearTable4411().size(), 2);
//
//				table4411.setPadding(10);
//				table4411.setWidth(100f);
//
//				for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
//					table4411.addCell(criteria4Record.getYearTable4411().get(i).getInput4411y());
//
//				}
//				for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
//					table4411.addCell(criteria4Record.getYearTable4411().get(i).getInput4411v());
//
//				}
//
//				document.add(table4411);
//
//			}
//
//			PdfPTable table26criteria4 = new PdfPTable(2);
//			table26criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00123 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell00124 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00125 = new PdfPCell(new Paragraph(
//					"Details about assigned budget and expenditure on physical facilities and academic facilities\r\n\r\n\r\n "));
//			PdfPCell cell00126 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(23).getCriteria4FilePath() : ""));
//			PdfPCell cell00127 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n\r\n "));
//			PdfPCell cell00128 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(24).getCriteria4FilePath() : ""));
//
//			table26criteria4.addCell(cell00123);
//			table26criteria4.addCell(cell00124);
//			table26criteria4.addCell(cell00125);
//			table26criteria4.addCell(cell00126);
//			table26criteria4.addCell(cell00127);
//			table26criteria4.addCell(cell00128);
//
//			document.add(table26criteria4);
//
//			/*
//			 * Font fontParagraph47 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph47.setSize(12);
//			 
//
//			Paragraph paragraph51 = new Paragraph(
//					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse442()
//									: ""),
//					font2);
//
//			PdfPTable table442criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table442criteria4.setWidthPercentage(100);
//
//			table442criteria4.addCell(
//					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\\r\\n\"\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse442()
//									: ""));
//			// table442criteria4.addCell(criteria4List.get(0).getResponseValue442());
//			document.add(table442criteria4);
//
//			table442criteria4.setSpacingBefore(20f);
//			table442criteria4.setSpacingAfter(20f);
//
//			paragraph51.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph48 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph48.setSize(12);
//			 
//
//			Paragraph paragraph52 = new Paragraph(
//					" The Maintenance Cell of the college ensures proper functioning of all civil, electrical, water, sewage, environment, and other facilities through frequent inspections and need-based maintenance works. A central complaint register is maintained, and the maintenance cell attends to those complaints on a priority basis. A vast majority of minor and major repairs are carried out internally, while some major repairs are outsourced. The maintenance cell is headed by the Registrar/Dean-Administration. The other members of the cell include Administrative Maintenance in-charge, Head of EEE department, and two senior faculty members, one each from Civil Engineering and Mechanical Engineering departments. The members of the cell meet based on the need and review the requirements to chalk out further action to be taken. The cell also arranges to conduct energy audit. Staff belonging to the maintenance cell perform routine cleaning of the water tanks, water coolers, filters, etc. as per schedule. Preventive maintenance of the equipment is a regular practice in all laboratories apart from breakdown maintenance. Gardeners and janitors conduct regular cleaning of the campus premises and restrooms twice a day.\r\n"
//							+ "\r\n"
//							+ "The regular maintenance of all the seminar halls of the institution, Open air auditorium, Portico of Block-2, open air grounds, playground etc. are supervised by the Administrative Officer. The Faculty/students put a letter in the prescribed format (mentioning the date and time of requirement) seeking the allocation of the required physical facility for the respective events to be organized. After the allocation as per the availability, such information is entered in a register kept with the Administrative officer.\r\n"
//							+ "\r\n"
//							+ "All OHP/LCD projectors in the institution, furniture available in the classroom, faculty/staff rooms are regularly monitored on a fortnightly basis for maintenance.\r\n"
//							+ "\r\n"
//							+ "Each laboratory maintains a stock register for detailing the proper lab records. The lab stock register holds\r\n"
//							+ " \r\n"
//							+ "the complete details of lab equipment, new arrivals, replacements of old equipment, maintenance details, license details etc. Each lab is associated with a qualified Technical Staff for maintenance of all lab equipment. Any major repair of equipment beyond the scope of technical staff is outsourced. Obsolete and irreparable equipment is weeded out on regular basis. A register for �Lab equipment Repair/ Maintenance� is kept in each lab to track the breakdown time of equipment and the maintenance details. A minimum of 20% to 30% of unutilized lab slots per week are allotted for regular maintenance works of the laboratories.\r\n"
//							+ "\r\n"
//							+ "The college has a central computing facility located in the library building, which is also used for browsing and accessing electronic content of learning resources.\r\n"
//							+ "\r\n"
//							+ "The institution has established a separate maintenance cell, responsible for the maintenance works of computers, Hardware and software installations/up-gradations, wi-fi and internet maintenance. The cell is chaired by a senior faculty from Computer Science Engineering department who supervises the supporting staff required for this purpose.\r\n"
//							+ "",
//					font5);
//			paragraph52.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph51);
//			document.add(paragraph52);*/
//
//			PdfPTable table27criteria4 = new PdfPTable(2);
//			table27criteria4.setWidthPercentage(100);
//			PdfPTable table270criteria4 = new PdfPTable(1);
//			table270criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00129 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell00130 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00131 = new PdfPCell(new Paragraph("upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell00132 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(25).getCriteria4FilePath() : ""));
//
//			table27criteria4.addCell(cell00129);
//			table27criteria4.addCell(cell00130);
//			table27criteria4.addCell(cell00131);
//			table27criteria4.addCell(cell00132);
//			table270criteria4.addCell("4.4.2 There are established systems and procedures for maintaining and\r\n"
//					+ "utilizing physical, academic and support facilities - laboratory, library, sports\r\n"
//					+ "complex, computers, classrooms etc.\r\n"
//					+ "Response:"+(criteria4Record != null
//					? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse442()
//					:""));
//			
//			table270criteria4.addCell("The Maintenance Cell of the college ensures proper functioning of all civil, electrical, water,\r\n"
//					+ "sewage, environment, and other facilities through frequent inspections and need-based\r\n"
//					+ "maintenance works. A central complaint register is maintained, and the maintenance cell attends\r\n"
//					+ "to those complaints on a priority basis. A vast majority of minor and major repairs are carried out\r\n"
//					+ "internally, while some major repairs are outsourced. The maintenance cell is headed by the\r\n"
//					+ "Registrar/Dean-Administration. The other members of the cell include Administrative Maintenance\r\n"
//					+ "in-charge, Head of EEE department, and two senior faculty members, one each from Civil\r\n"
//					+ "Engineering and Mechanical Engineering departments. The members of the cell meet based on\r\n"
//					+ "the need and review the requirements to chalk out further action to be taken. The cell also\r\n"
//					+ "arranges to conduct energy audit. Staff belonging to the maintenance cell perform routine cleaning\r\n"
//					+ "of the water tanks, water coolers, filters, etc. as per schedule. Preventive maintenance of the\r\n"
//					+ "equipment is a regular practice in all laboratories apart from breakdown maintenance. Gardeners\r\n"
//					+ "and janitors conduct regular cleaning of the campus premises and restrooms twice a day.\r\n"
//					+ "The regular maintenance of all the seminar halls of the institution, Open air auditorium, Portico of\r\n"
//					+ "Block-2, open air grounds, playground etc. are supervised by the Administrative Officer. The\r\n"
//					+ "Faculty/students put a letter in the prescribed format (mentioning the date and time of\r\n"
//					+ "requirement) seeking the allocation of the required physical facility for the respective events to be\r\n"
//					+ "organized. After the allocation as per the availability, such information is entered in a register kept\r\n"
//					+ "with the Administrative officer.All OHP/LCD projectors in the institution, furniture available in the classroom, faculty/staff rooms\r\n"
//					+ "are regularly monitored on a fortnightly basis for maintenance.\r\n"
//					+ "Each laboratory maintains a stock register for detailing the proper lab records. The lab stock\r\n"
//					+ "register holds\r\n"
//					+ "the complete details of lab equipment, new arrivals, replacements of old equipment, maintenance\r\n"
//					+ "details, license details etc. Each lab is associated with a qualified Technical Staff for maintenance\r\n"
//					+ "of all lab equipment. Any major repair of equipment beyond the scope of technical staff is\r\n"
//					+ "outsourced. Obsolete and irreparable equipment is weeded out on regular basis. A register for Lab\r\n"
//					+ "equipment Repair/ Maintenance is kept in each lab to track the breakdown time of equipment and\r\n"
//					+ "the maintenance details. A minimum of 20% to 30% of unutilized lab slots per week are allotted for\r\n"
//					+ "regular maintenance works of the laboratories.\r\n"
//					+ "The college has a central computing facility located in the library building, which is also used for\r\n"
//					+ "browsing and accessing electronic content of learning resources.\r\n"
//					+ "The institution has established a separate maintenance cell, responsible for the maintenance\r\n"
//					+ "works of computers, Hardware and software installations/up-gradations, wi-fi and internet\r\n"
//					+ "maintenance. The cell is chaired by a senior faculty from Computer Science Engineering\r\n"
//					+ "department who supervises the supporting staff required for this purpose.\r\n"
//					+ "");
//			
//			table270criteria4.addCell(table27criteria4);
//
//			table270criteria4.setSpacingBefore(20f);
//			table270criteria4.setSpacingAfter(20f);
//
//			document.add(table270criteria4);
//			
//       document.close();
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
