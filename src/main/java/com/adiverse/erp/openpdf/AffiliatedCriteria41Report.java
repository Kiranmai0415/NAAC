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
//import com.fasterxml.jackson.databind.ObjectMapper;
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
//public class AffiliatedCriteria41Report {
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
//		
//		ObjectMapper mapper=new ObjectMapper();
//		
//		System.out.println("mapper==."+mapper.writeValueAsString(criteria4Fieldinfo));
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
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse411()
//									: ""),
//					font3));
//			
//			PdfPCell cell00criteria4 = new PdfPCell(new Paragraph(
//					 (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getInput411t1()
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
//			PdfPTable tablecriteria4 = new PdfPTable(2);
//
//			tablecriteria4.setWidthPercentage(100);
//
//			Font font6criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font6criteria4.setColor(CMYKColor.BLACK);
//
//			PdfPCell cell1criteria4 = new PdfPCell(new Paragraph("File Description", font3));
//			PdfPCell cell2criteria4 = new PdfPCell(new Paragraph("Document", font3));
//			PdfPCell cell3criteria4 = new PdfPCell(new Paragraph("Upload any additional information", font3));
//			PdfPCell cell4criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() :""));
//			PdfPCell cell5criteria4 = new PdfPCell(new Paragraph("Paste link for additional information"));
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
//			
//			
//			Paragraph paragraph2criteria41 = new Paragraph("4.1.4: Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)");
//			
//			document.add(paragraph2criteria41);
//			
//			if(criteria4Record.getCriteria4FieldInfoQn() !=null)
//			{
//			Paragraph paragraph2criteria42 = new Paragraph(criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getInput412t1()
//					: "");
//			document.add(paragraph2criteria42);
//			}
//						
//			
//		
//			
//			
//			
//			if (criteria4Fieldinfo.getYearTable4141()!= null) {
//
//				Table table4141 = new Table(criteria4Fieldinfo.getYearTable4141().size(), 2);
//
//				table4141.setPadding(10);
//				table4141.setWidth(100f);
//
//				for (int i = 0; i < criteria4Fieldinfo.getYearTable4141().size(); i++) {
//					table4141.addCell(criteria4Fieldinfo.getYearTable4141().get(i).getInput4141y());
//
//				}
//				for (int i = 0; i < criteria4Fieldinfo.getYearTable4141().size(); i++) {
//					table4141.addCell(criteria4Fieldinfo.getYearTable4141().get(i).getInput4141v());
//
//				}
//
//				document.add(table4141);
//			}
//			Paragraph paragraph2criteria44 = new Paragraph("\r\n");
//			document.add(paragraph2criteria44);
//
//			if (criteria4Fieldinfo.getYearTable4141() != null) {
//
//				Table table4141 = new Table(criteria4Fieldinfo.getYearTable4141().size(), 2);
//
//				table4141.setPadding(10);
//				table4141.setWidth(100f);
//
//				for (int i = 0; i < criteria4Fieldinfo.getYearTable4141().size(); i++) {
//					table4141.addCell(criteria4Fieldinfo.getYearTable4141().get(i).getInput4141y());
//
//				}
//				for (int i = 0; i < criteria4Fieldinfo.getYearTable4141().size(); i++) {
//					table4141.addCell(criteria4Fieldinfo.getYearTable4141().get(i).getInput4141v());
//
//				}
//
//				document.add(table4141);
//			}
//			
//			
//			document.add(paragraph2criteria44);
//
//			
//			
//			
//			
//			PdfPTable tablecriteria41 = new PdfPTable(2);
//
//			tablecriteria41.setWidthPercentage(100);
//
//			Font font6criteria41 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font6criteria41.setColor(CMYKColor.BLACK);
//
//			PdfPCell cell1criteria41 = new PdfPCell(new Paragraph("File Description", font3));
//			PdfPCell cell2criteria41= new PdfPCell(new Paragraph("Document", font3));
//			PdfPCell cell3criteria41 = new PdfPCell(new Paragraph("Upload any additional information", font3));
//			PdfPCell cell4criteria41 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() :""));
//			PdfPCell cell5criteria41 = new PdfPCell(new Paragraph("Paste link for additional information"));
//			PdfPCell cell6criteria41 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() :""));
//		
//			tablecriteria41.addCell(cell1criteria41);
//			tablecriteria41.addCell(cell2criteria41);
//			tablecriteria41.addCell(cell3criteria41);
//			tablecriteria41.addCell(cell4criteria41);
//			tablecriteria41.addCell(cell5criteria41);
//			tablecriteria41.addCell(cell6criteria41);
//			
//			tablecriteria41.setSpacingBefore(20f);
//			tablecriteria41.setSpacingAfter(20f);
//
//			document.add(tablecriteria41);
//			
//			
//			document.close();
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
//		
////
////			PdfPTable table411criteria4 = new PdfPTable(1);
////
////			
////			table411criteria4.setWidthPercentage(100);
////
////			
////			document.add(table411criteria4);
////
////			table411criteria4.setSpacingBefore(20f);
////			table411criteria4.setSpacingAfter(20f);
////
////			
////			
//////
//////		Paragraph paragraph5criteria4 = new Paragraph(
//////					"Mother Teresa has a lush green campus of 13.5 acres, with aesthetically designed buildings, which has been providing notable academic ambience, conducive for Quality Teaching-Learning. The college has adequate infrastructure facilities for Instructional delivery and services as denoted below",
//////					font5);
//////			paragraph5criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//////
//////			document.add(paragraph5criteria4);
////
////			
////			// creating table
////			PdfPTable tablecriteria4 = new PdfPTable(4);
////
////			tablecriteria4.setWidthPercentage(100);
////
////			Font font6criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			font6criteria4.setColor(CMYKColor.BLACK);
////
////			PdfPCell cell1criteria4 = new PdfPCell(new Paragraph("File Description", font3));
////			PdfPCell cell2criteria4 = new PdfPCell(new Paragraph("Document", font3));
////			PdfPCell cell3criteria4 = new PdfPCell(new Paragraph("", font3));
////			PdfPCell cell4criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() :""));
////			PdfPCell cell5criteria4 = new PdfPCell(new Paragraph("Upload any additional information"));
////			PdfPCell cell6criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() :""));
////		
////			tablecriteria4.addCell(cell1criteria4);
////			tablecriteria4.addCell(cell2criteria4);
////			tablecriteria4.addCell(cell3criteria4);
////			tablecriteria4.addCell(cell4criteria4);
////			tablecriteria4.addCell(cell5criteria4);
////			tablecriteria4.addCell(cell6criteria4);
////			
////			tablecriteria4.setSpacingBefore(20f);
////			tablecriteria4.setSpacingAfter(20f);
////
////			document.add(tablecriteria4);
////
////			Paragraph paragraph7criteria4 = new Paragraph("* Expanded Examination center", font5);
////			paragraph7criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph8criteria4 = new Paragraph(
////					"All the classrooms are equipped with LCD Projectors, and have Wi-Fi connectivity. In addition, air- conditioned seminar halls have public address systems for optimum acoustics. College provides special facilities for differently-abled persons, viz., Lifts, Ramp/ Rails, and wheel chairs. College has adequate power backup and UPS facilities. Electrical load of the college supported through two transformers of 200kVA and 125kVA with contract load of 160kVA and 100kVA respectively. Backup is provided through two Kirloskar diesel generators of 200kVA and 380kVA, to ensure un-interrupted power, for academic activities. Personal cabins for Deans, HoDs, Professors and Associate Professors with computer and printer facilities are available. Additional Discussion rooms and Meeting rooms are available for anytime interactions with the students.",
////					font5);
////			paragraph8criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph9criteria4 = new Paragraph(
////					"Laboratories are adequately equipped and many have been established with industrial collaborations, viz., IBM, Redpine signals, Smartbridge and CDAC at a cost of Rs 53.98 lakhs. Centre of Excellence with Virtusa is established in specialized areas to provide domain-specific training to students. All the laboratories are supported through UPS with a total capacity of 680kVA. College also has installed a Solar power plant with a capacity of 250kw which is connected to the grid. Fire extinguishers are placed in each floor of every high-rise building for the safety of students and faculty. All laboratories are provided with required operating manuals for their smooth functioning. Laboratories are also kept open beyond working hours as per the requirement.",
////					font5);
////			paragraph9criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph10criteria4 = new Paragraph(
////					"In addition to the central Library which has a rich knowledge resource, of the institution, each department has a separate library with good collection of textbooks. Digital Library resources are accessible on LAN (Intranet) to all students and faculty. Library server has a large collection of learning material.",
////					font5);
////			paragraph10criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph11criteria4 = new Paragraph("Computing Equipment\r\n" + " ", font3);
////			paragraph11criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			document.add(paragraph7criteria4);
////			document.add(paragraph8criteria4);
////			document.add(paragraph9criteria4);
////			document.add(paragraph10criteria4);
////			document.add(paragraph11criteria4);
////
////			
////
////			Paragraph paragraph12criteria4 = new Paragraph("* 1276 old desktop computers were written off", font5);
////			paragraph12criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			document.add(paragraph12criteria4);
////
////			PdfPTable table2 = new PdfPTable(2);
////			table2.setWidthPercentage(100);
////
////			PdfPCell cell001criteria4 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
////			PdfPCell cell002criteria4 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
////			PdfPCell cell003criteria4 = new PdfPCell(new Paragraph("Upload Any additional information\r\n\r\n "));
////			PdfPCell cell004criteria4 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : ""));
////			PdfPCell cell005criteria4 = new PdfPCell(new Paragraph("paste link for additional information\r\n\r\n"));
////			PdfPCell cell006criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(3).getCriteria4FilePath() :""));
////
////			table2.addCell(cell001criteria4);
////			table2.addCell(cell002criteria4);
////			table2.addCell(cell003criteria4);
////			table2.addCell(cell004criteria4);
////			table2.addCell(cell005criteria4);
////			table2.addCell(cell006criteria4);
////
////			table2.setSpacingBefore(20f);
////			table2.setSpacingAfter(20f);
////
////			document.add(table2);
////
////			Paragraph paragraph13criteria4 = new Paragraph(
////					"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)",
////					font3);
////			paragraph13criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph14criteria4 = new Paragraph("Response:"
////					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse412()
////							: ""),
////					font3);
////			
////			
////			Paragraph paragraph140criteria4 = new Paragraph("Response:"
////					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getInput412t1()
////							: ""),
////					font3);
////			paragraph14criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph15criteria4 = new Paragraph(
////					"Mother Teresa�s conviction is, the college years are crucial in students� cognitive, emotional, moral, and social development. Their involvement with peers in various co-curricular and extra-curricular, sports and cultural activities, influence development of their cognitive skills, identity, self-concept, self-esteem, values and attitudes, behavior patterns, and personality. They come across people who see the world differently than themselves and hear a lot of ideas/perceptions, contrary to their own, which they may not agree with. This experience enables them to keep an open mind, respect others� views and try to understand, even if one does not agree with them.\r\n"
////							+ "\r\n"
////							+ "Towards the above, college with its sprawling, lush green open-air Auditorium having 3000 seating capacity provides abundant space, facilitates a number of events. Notable among them are: Graduation Day, Traditional Day, Orientation Day for First Year students, Bathukamma, a flower festival, Earth Day, College Day celebrations, Music, Singing, Dance, Rangoli, Skits, and Photo Exhibitions. Active participation of students in various events, facilitate development of Creativity, Innovative thinking, Leadership, and Emotional Quotient in them.\r\n"
////							+ "\r\n"
////							+ "The college has six blocks for instructional purposes and associated co-curricular, extra-curricular and cultural activities.\r\n"
////							+ "\r\n"
////							+ "Block-I has a 250-seater, Air-conditioned Seminar Hall, used for practicing singing, skits, dancing etc.\r\n"
////							+ "\r\n"
////							+ "The portico of Block II, overlooking an aesthetically laid out garden is the stage for smaller events, namely, Fashion Shows, Dance Competitions, Painting Exhibitions etc.\r\n"
////							+ "\r\n"
////							+ "In Block III, the 100-seat Seminar Hall facilitates conduct of cultural events with limited gathering. The grounds in front of Block-III houses Basketball Court.\r\n"
////							+ "\r\n"
////							+ "Block-IV is furnished with a 400-seat Air-conditioned Seminar Hall, used for performing dance, musical programs, etc.,\r\n"
////							+ "\r\n"
////							+ "Table-tennis, carroms and chess games are facilitated in the games room of Block V. To the right of Block V, houses Cricket net practice sessions.\r\n"
////							+ "\r\n"
////							+ "Yoga sessions are conducted on the lawns of the Open Auditorium and Seminar Halls. \r\n"
////							+ " ",
////					font5);
////			paragraph15criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph24criteria4 = new Paragraph("The open lawns facilitate the following:", font5);
////			paragraph24criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph241 = new Paragraph(" ", font5);
////			paragraph241.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			Chunk bullet1criteria4 = new Chunk("\u2022", font5);
////			paragraph241.add(bullet1criteria4);
////
////			paragraph241.add(new Phrase("College day: VIBGYOR, VIBES\r\n" + "\r\n", font5));
////			paragraph241.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph242 = new Paragraph(" ", font5);
////			paragraph242.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			Chunk bullet2criteria4 = new Chunk("\u2022", font5);
////			paragraph242.add(bullet2criteria4);
////
////			paragraph242.add(new Phrase("Yoga\r\n" + "\r\n", font5));
////
////			paragraph242.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph243 = new Paragraph(" ", font5);
////			paragraph243.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			Chunk bullet3criteria4 = new Chunk("\u2022", font5);
////			paragraph243.add(bullet3criteria4);
////
////			paragraph243.add(new Phrase("Regional and National festivals of importance\r\n", font5));
////
////			paragraph243.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph244 = new Paragraph(" ", font5);
////			paragraph244.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			Chunk bullet4criteria4 = new Chunk("\u2022", font5);
////			paragraph244.add(bullet4criteria4);
////
////			paragraph244.add(new Phrase(" Alumni association meet\r\n", font5));
////
////			paragraph244.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph245 = new Paragraph(" ", font5);
////			paragraph245.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			Chunk bullet5criteria4 = new Chunk("\u2022", font5);
////			paragraph245.add(bullet5criteria4);
////
////			paragraph245.add(new Phrase("Mother Teresa family get together\r\n" + "\r\n", font5));
////
////			paragraph245.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph246 = new Paragraph(" ", font5);
////			paragraph246.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			Chunk bullet6criteria4 = new Chunk("\u2022", font5);
////			paragraph246.add(bullet6criteria4);
////
////			paragraph246.add(new Phrase("Football practice\r\n" + "\r\n", font5));
////
////			paragraph246.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			/*
////			 * Font fontParagraph21 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph21.setSize(12);
////			 */
////
////			Paragraph paragraph25criteria4 = new Paragraph(
////					"Institution allocates one/two-hour time slots in Timetable encouraging students participation in sports thereby inculcating sporting spirit in them and they understand that winning & losing are part of life. Transportation is arranged for students participating in sports and games beyond working hours to reach their homes. It�s the institution�s conviction that holistic development of a student is only possible, when students participate in several cultural, literary and sports activities over and above their academics. Mother Teresates won several laurels in State Under-19 competitions in many sports events in the past few years. ",
////					font5);
////			paragraph25criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			/*
////			 * Font fontParagraph22criteria4 =
////			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph22criteria4.setSize(12);
////			 */
////
////			Paragraph paragraph26criteria4 = new Paragraph("Details of the facility created/r/n ", font3);
////			paragraph26criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			document.add(paragraph13criteria4);
////			document.add(paragraph14criteria4);
////			document.add(paragraph140criteria4);
////			document.add(paragraph15criteria4);
////			document.add(paragraph24criteria4);
////			document.add(paragraph241);
////			document.add(paragraph242);
////			document.add(paragraph243);
////			document.add(paragraph244);
////			document.add(paragraph245);
////			document.add(paragraph246);
////			document.add(paragraph25criteria4);
////			document.add(paragraph26criteria4);
////
////		
////
////			// Creating a table of 3 columns
////			PdfPTable table4criteria4 = new PdfPTable(2);
////			PdfPTable table412criteria4 = new PdfPTable(1);
////
////			// Setting width of table, its columns and spacing
////			table4criteria4.setWidthPercentage(100);
////			table412criteria4.setWidthPercentage(100);
////
////			PdfPCell cell007 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
////			PdfPCell cell008 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
////			PdfPCell cell0009 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n"));
////			PdfPCell cell0010 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(4).getCriteria4FilePath() : ""));
////			PdfPCell cell0011 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
////			/*PdfPCell cell0012 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : ""));
////			PdfPCell cell0013 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
////			PdfPCell cell0014 = new PdfPCell(new Paragraph(""));*/
////
////			table4criteria4.addCell(cell007);
////			table4criteria4.addCell(cell008);
////			table4criteria4.addCell(cell0009);
////			table4criteria4.addCell(cell0010);
////			table4criteria4.addCell(cell0011);
////			//table4criteria4.addCell(cell0012);
////			//table4criteria4.addCell(cell0013);
////			//table4criteria4.addCell(cell0014);
////
////			PdfPCell cell412criteria4 = new PdfPCell(new Paragraph(
////					"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)\r\n"
////							+ "\r\n\r\n" + "Response:"
////							+ (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse412()
////									: ""),
////					font3));
////
////			table412criteria4.addCell(cell412criteria4);
////			table412criteria4.addCell(table4criteria4);
////			table412criteria4.setSpacingBefore(20f);
////			table412criteria4.setSpacingAfter(20f);
////
////			document.add(table412criteria4);
////			
////			//YEAR TABLE 4121
//////			if (criteria4Record != null) {
////	//
//////				Table table4121 = new Table(criteria4Record.getAffiliated_YearTable4121().size(), 2);
////	//
//////				table4121.setPadding(10);
//////				table4121.setWidth(100f);
////	//
//////				for (int i = 0; i < criteria4Record.getAffiliated_YearTable4121().size(); i++) {
//////					table4121.addCell(criteria4Record.getAffiliated_YearTable4121().get(i).getInput4121y());
////	//
//////				}
//////				for (int i = 0; i < criteria4Record.getAffiliated_YearTable4121().size(); i++) {
//////					table4121.addCell(criteria4Record.getAffiliated_YearTable4121().get(i).getInput4121v());
////	//
//////				}
////	//
//////				document.add(table4121);
//////			}
////
////			
////
////			// Creating a table of columns
////			PdfPTable table5criteria4 = new PdfPTable(2);
////			PdfPTable table51 = new PdfPTable(1);
////
////			// Setting width of table, its columns and spacing
////			table5criteria4.setWidthPercentage(100);
////			table51.setWidthPercentage(100);
////
////			PdfPCell cell0015 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
////			PdfPCell cell0016 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
////			PdfPCell cell0017 = new PdfPCell(new Paragraph("Upload Number of classrooms and seminar halls\r\n"
////					+ "with ICT enabled facilities (Data Template)\r\n\r\n"));
////			PdfPCell cell0018 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(5).getCriteria4FilePath() : ""));
////			PdfPCell cell0019 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
////			PdfPCell cell0020 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(6).getCriteria4FilePath() : ""));
////			/*PdfPCell cell0021 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
////			PdfPCell cell0022 = new PdfPCell(new Paragraph());*/
////
////			table5criteria4.addCell(cell0015);
////			table5criteria4.addCell(cell0016);
////			table5criteria4.addCell(cell0017);
////			table5criteria4.addCell(cell0018);
////			table5criteria4.addCell(cell0019);
////			table5criteria4.addCell(cell0020);
////			//table5criteria4.addCell(cell0021);
////			//table5criteria4.addCell(cell0022);
////
////			table51.addCell(
////					"4.1.3 Percentage of classrooms and seminar halls with ICT- enabled facilities such as smart class, LMS, etc. (Data for the latest completed academic year)\r\n"
////							+ "\r\n" + "Response:"
////							+ (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse413()
////									: ""));
////
////			table51.addCell("4.1.3.1 Number of classrooms and seminar halls with ICT facilities\r\n" + "\r\n\r\n" + "Response: "
////					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getInput4131t1() : ""));
////
////			// table51.addCell(criteria4List.get(0).getResponseValue413());
////
////			table51.addCell(table5criteria4);
////
////			table51.setSpacingBefore(20f);
////			table51.setSpacingAfter(20f);
////
////			document.add(table51);
////
////			// Creating a table of 3 columns
////			PdfPTable table6criteria4 = new PdfPTable(5);
////			PdfPTable table61criteria4 = new PdfPTable(1);
////
////			// Setting width of table, its columns and spacing
////			table6criteria4.setWidthPercentage(100);
////			table61criteria4.setWidthPercentage(100);
////
////			PdfPCell cell0023 = new PdfPCell(new Paragraph("File Description",font3));
////			PdfPCell cell0024 = new PdfPCell(new Paragraph("Documen",font3));
////			PdfPCell cell0025 = new PdfPCell(new Paragraph(" Upload Details of budget allocation, excluding\r\n"
////					+ "salary during the last five years (Data Template)"));
////			PdfPCell cell0026 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(7).getCriteria4FilePath():""));
////			PdfPCell cell0027 = new PdfPCell(new Paragraph("Upload audited utilization statements"));
////			PdfPCell cell0028 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(8).getCriteria4FilePath():""));
////		
////			table6criteria4.addCell(cell0023);
////			table6criteria4.addCell(cell0024);
////			table6criteria4.addCell(cell0025);
////			table6criteria4.addCell(cell0026);
////			table6criteria4.addCell(cell0027);
////			table6criteria4.addCell(cell0028);
////			
////			table61criteria4.addCell(
////					"4.1.4 Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)\r\n"
////							+ "\r\n" + "Response: "
////							+ (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse414()
////									: ""));
////
////			// table61criteria4.addCell(criteria4List.get(0).getResponseValue414());
////
////			table61criteria4.addCell(
////					"4.1.4.1 Expenditure for infrastructure augmentation, excluding salary year-wise during last five years (INR in lakhs)\r\n\r\n");
////
////			// table61.addCell(table6);
////
////			table61criteria4.setSpacingBefore(20f);
////			table61criteria4.setSpacingAfter(20f);
////
////			document.add(table61criteria4);
////
////			if (criteria4Record != null) {
////
////				Table table4141 = new Table(criteria4Record.getYearTable4141().size(), 2);
////
////				table4141.setPadding(10);
////				table4141.setWidth(100f);
////
////				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
////					table4141.addCell(criteria4Record.getYearTable4141().get(i).getInput4141y());
////
////				}
////				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
////					table4141.addCell(criteria4Record.getYearTable4141().get(i).getInput4141v());
////
////				}
////
////				document.add(table4141);
////			}
////
////			// Creating a table of 3 columns
////			PdfPTable table7criteria4 = new PdfPTable(2);
////
////			// Setting width of table, its columns and spacing
////			table7criteria4.setWidthPercentage(100);
////
////			PdfPCell cell0033 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font6criteria4));
////			PdfPCell cell0034 = new PdfPCell(new Paragraph("Document\r\n\r\n", font6criteria4));
////			PdfPCell cell0035 = new PdfPCell(
////					new Paragraph("Upload Details of Expenditure , excluding salary during the last five years\r\n\r\n "));
////			PdfPCell cell0036 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(9).getCriteria4FilePath() : ""));
////			PdfPCell cell0037 = new PdfPCell(new Paragraph("Upload audited utilization statements\r\n\r\n"));
////			PdfPCell cell0038 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(10).getCriteria4FilePath() : ""));
////			PdfPCell cell0039 = new PdfPCell(new Paragraph(" Link for any additional information\r\n\r\n"));
////			PdfPCell cell0040 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(11).getCriteria4FilePath() :""));
////
////			table7criteria4.addCell(cell0033);
////			table7criteria4.addCell(cell0034);
////			table7criteria4.addCell(cell0035);
////			table7criteria4.addCell(cell0036);
////			table7criteria4.addCell(cell0037);
////			table7criteria4.addCell(cell0038);
////			table7criteria4.addCell(cell0039);
////			table7criteria4.addCell(cell0040);
////
////			table7criteria4.setSpacingBefore(20f);
////			table7criteria4.setSpacingAfter(20f);
////
////			document.add(table7criteria4);
////
////			/*
////			 * Font fontParagraph27 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph27.setSize(12);
////			 */
////
////			
////			// 4.2
////		
////			
////       document.close();
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
