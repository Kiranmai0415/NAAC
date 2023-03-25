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
//import com.adiverse.erp.model.Criteria4_FieldInfo;
//import com.adiverse.erp.model.Criteria4_FileUpload;
//import com.adiverse.erp.service.Criteria4Service;
//import com.lowagie.text.Chunk;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.CMYKColor;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//@Service
//public class UniversityCriteria4Report {
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;      //file upload path
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//	
//   @Autowired
//   Criteria4Service service4;
//	
//   List<Criteria4_FieldInfo> criteria4List = null;
//	Criteria4_FieldInfo criteria4Record = null;
//	List<Criteria4_FileUpload> criteria4file = null;
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
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "UniversityCriteria4Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//			
//			Document document = new Document(PageSize.A4);
//			// PdfWriter.getInstance(document, response.getOutputStream());
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>");
//	
//
//			Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources", font1);
//			paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph1criteria4);
//
//			/*
//			 * Font font1criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font1criteria4.setSize(14);
//			 */
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
//			table01criteria4.addCell(cell0criteria4);
//
//			// table101criteria5.addCell(table010criteria5);
//
//			table01criteria4.setSpacingBefore(20f);
//			table01criteria4.setSpacingAfter(20f);
//
//			document.add(table01criteria4);
//
//			/*
//			 * Paragraph paragraph3criteria4 = new Paragraph(
//			 * "4.1.1 The Institution has adequate infrastructure and physical facilities for teaching- learning. viz., classrooms, laboratories, computing equipment etc."
//			 * , font3); paragraph3criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			 * 
//			 * document.add(paragraph3criteria4);
//			 */
//
//			/*
//			 * Font font3criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font3criteria4.setSize(12);
//			 */
//
//			Paragraph paragraph4criteria4 = new Paragraph("Response:", font3);
//
//			PdfPTable table411criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table411criteria4.setWidthPercentage(100);
//
//			/*
//			 * able411criteria4.addCell(
//			 * "4.1.1 The Institution has adequate infrastructure and physical facilities for teaching- learning. viz., classrooms, laboratories, computing equipment etc."
//			 * + "\r\n" + "Response: " + (criteria4Record != null ?
//			 * criteria4Record.getResponseValue411() : ""));
//			 */
//			// table411criteria4.addCell(criteria4List.get(0).getResponseValue411());
//			document.add(table411criteria4);
//
//			table411criteria4.setSpacingBefore(20f);
//			table411criteria4.setSpacingAfter(20f);
//
//			paragraph4criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph4criteria4);
//
//			/*
//			 * Font font4criteria4 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * font4criteria4.setSize(12);
//			 */
//
//			Paragraph paragraph5criteria4 = new Paragraph(
//					"Mother Teresa has a lush green campus of 13.5 acres, with aesthetically designed buildings, which has been providing notable academic ambience, conducive for Quality Teaching-Learning. The college has adequate infrastructure facilities for Instructional delivery and services as denoted below",
//					font5);
//			paragraph5criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph5criteria4);
//
//			/*
//			 * Font font5criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font5criteria4.setSize(12);
//			 */
//
//			Paragraph paragraph6criteria4 = new Paragraph("Infrastructure facilities available for Teaching-Learning",
//					font3);
//			paragraph6criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph6criteria4);
//
//			// creating table
//			PdfPTable tablecriteria4 = new PdfPTable(4);
//
//			tablecriteria4.setWidthPercentage(100);
//
//			Font font6criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font6criteria4.setColor(CMYKColor.BLACK);
//
//			PdfPCell cell1criteria4 = new PdfPCell(new Paragraph("Physical Facilities", font3));
//			PdfPCell cell2criteria4 = new PdfPCell(new Paragraph("Total Number Area", font3));
//			PdfPCell cell3criteria4 = new PdfPCell(new Paragraph("Area (in Sqm.)", font3));
//			PdfPCell cell4criteria4 = new PdfPCell(new Paragraph("No. added during the ensuing A/A period", font3));
//			PdfPCell cell5criteria4 = new PdfPCell(new Paragraph("Classrooms"));
//			PdfPCell cell6criteria4 = new PdfPCell(new Paragraph("70"));
//			PdfPCell cell7criteria4 = new PdfPCell(new Paragraph("5098"));
//			PdfPCell cell8criteria4 = new PdfPCell(new Paragraph("12"));
//			PdfPCell cell9criteria4 = new PdfPCell(new Paragraph("Laboratories"));
//			PdfPCell cell10criteria4 = new PdfPCell(new Paragraph("87"));
//			PdfPCell cell11criteria4 = new PdfPCell(new Paragraph("7019"));
//			PdfPCell cell12criteria4 = new PdfPCell(new Paragraph("19"));
//			PdfPCell cell13criteria4 = new PdfPCell(new Paragraph("Workshops"));
//			PdfPCell cell14criteria4 = new PdfPCell(new Paragraph("06"));
//			PdfPCell cell15criteria4 = new PdfPCell(new Paragraph("1469"));
//			PdfPCell cell16criteria4 = new PdfPCell(new Paragraph("01"));
//			PdfPCell cell17criteria4 = new PdfPCell(new Paragraph("Computer Centres"));
//			PdfPCell cell18criteria4 = new PdfPCell(new Paragraph("02"));
//			PdfPCell cell19criteria4 = new PdfPCell(new Paragraph("326"));
//			PdfPCell cell20criteria4 = new PdfPCell(new Paragraph("01"));
//			PdfPCell cell21criteria4 = new PdfPCell(new Paragraph("Drawing Hall"));
//			PdfPCell cell22criteria4 = new PdfPCell(new Paragraph("02"));
//			PdfPCell cell23criteria4 = new PdfPCell(new Paragraph("343"));
//			PdfPCell cell24criteria4 = new PdfPCell(new Paragraph("-"));
//			PdfPCell cell25criteria4 = new PdfPCell(new Paragraph("Seminar Rooms"));
//			PdfPCell cell26criteria4 = new PdfPCell(new Paragraph("03"));
//			PdfPCell cell27criteria4 = new PdfPCell(new Paragraph("687"));
//			PdfPCell cell28criteria4 = new PdfPCell(new Paragraph("-"));
//			PdfPCell cell29criteria4 = new PdfPCell(new Paragraph("Library"));
//			PdfPCell cell30criteria4 = new PdfPCell(new Paragraph("01"));
//			PdfPCell cell31criteria4 = new PdfPCell(new Paragraph("1064"));
//			PdfPCell cell32criteria4 = new PdfPCell(new Paragraph("-"));
//			PdfPCell cell33criteria4 = new PdfPCell(new Paragraph("Language Laboratories"));
//			PdfPCell cell34criteria4 = new PdfPCell(new Paragraph("02"));
//			PdfPCell cell35criteria4 = new PdfPCell(new Paragraph("137"));
//			PdfPCell cell36criteria4 = new PdfPCell(new Paragraph("-"));
//			PdfPCell cell37criteria4 = new PdfPCell(new Paragraph("Research Laboratories"));
//			PdfPCell cell38criteria4 = new PdfPCell(new Paragraph("03"));
//			PdfPCell cell39criteria4 = new PdfPCell(new Paragraph("323"));
//			PdfPCell cell40criteria4 = new PdfPCell(new Paragraph("01"));
//			PdfPCell cell41criteria4 = new PdfPCell(new Paragraph("Examination Center"));
//			PdfPCell cell42criteria4 = new PdfPCell(new Paragraph("01"));
//			PdfPCell cell43criteria4 = new PdfPCell(new Paragraph("280"));
//			PdfPCell cell44criteria4 = new PdfPCell(new Paragraph("-"));
//
//			tablecriteria4.addCell(cell1criteria4);
//			tablecriteria4.addCell(cell2criteria4);
//			tablecriteria4.addCell(cell3criteria4);
//			tablecriteria4.addCell(cell4criteria4);
//			tablecriteria4.addCell(cell5criteria4);
//			tablecriteria4.addCell(cell6criteria4);
//			tablecriteria4.addCell(cell7criteria4);
//			tablecriteria4.addCell(cell8criteria4);
//			tablecriteria4.addCell(cell9criteria4);
//			tablecriteria4.addCell(cell10criteria4);
//			tablecriteria4.addCell(cell11criteria4);
//			tablecriteria4.addCell(cell12criteria4);
//			tablecriteria4.addCell(cell13criteria4);
//			tablecriteria4.addCell(cell14criteria4);
//			tablecriteria4.addCell(cell15criteria4);
//			tablecriteria4.addCell(cell16criteria4);
//			tablecriteria4.addCell(cell17criteria4);
//			tablecriteria4.addCell(cell18criteria4);
//			tablecriteria4.addCell(cell19criteria4);
//			tablecriteria4.addCell(cell20criteria4);
//			tablecriteria4.addCell(cell21criteria4);
//			tablecriteria4.addCell(cell22criteria4);
//			tablecriteria4.addCell(cell23criteria4);
//			tablecriteria4.addCell(cell24criteria4);
//			tablecriteria4.addCell(cell25criteria4);
//			tablecriteria4.addCell(cell26criteria4);
//			tablecriteria4.addCell(cell27criteria4);
//			tablecriteria4.addCell(cell28criteria4);
//			tablecriteria4.addCell(cell29criteria4);
//			tablecriteria4.addCell(cell30criteria4);
//			tablecriteria4.addCell(cell31criteria4);
//			tablecriteria4.addCell(cell32criteria4);
//			tablecriteria4.addCell(cell33criteria4);
//			tablecriteria4.addCell(cell34criteria4);
//			tablecriteria4.addCell(cell35criteria4);
//			tablecriteria4.addCell(cell36criteria4);
//			tablecriteria4.addCell(cell37criteria4);
//			tablecriteria4.addCell(cell38criteria4);
//			tablecriteria4.addCell(cell39criteria4);
//			tablecriteria4.addCell(cell40criteria4);
//			tablecriteria4.addCell(cell41criteria4);
//			tablecriteria4.addCell(cell42criteria4);
//			tablecriteria4.addCell(cell43criteria4);
//			tablecriteria4.addCell(cell44criteria4);
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
//			// Creating a table of columns
//			PdfPTable table1criteria4 = new PdfPTable(3);
//
//			// Setting width of table, its columns and spacing
//			table1criteria4.setWidthPercentage(100);
//
//			PdfPCell cell01criteria4 = new PdfPCell(new Paragraph("Description", font3));
//			PdfPCell cell02criteria4 = new PdfPCell(new Paragraph("Available Number", font3));
//			PdfPCell cell03criteria4 = new PdfPCell(
//					new Paragraph("Till 2020-21	Added during the ensuing A/A du	ratio", font3));
//			PdfPCell cell04criteria4 = new PdfPCell(new Paragraph(" Desktop Computers"));
//			PdfPCell cell05criteria4 = new PdfPCell(new Paragraph("1818 "));
//			PdfPCell cell06criteria4 = new PdfPCell(new Paragraph("1547*"));
//			PdfPCell cell07criteria4 = new PdfPCell(new Paragraph(" Servers"));
//			PdfPCell cell08criteria4 = new PdfPCell(new Paragraph("05 "));
//			PdfPCell cell09criteria4 = new PdfPCell(new Paragraph(" 01"));
//			PdfPCell cell010criteria4 = new PdfPCell(new Paragraph("Laptops"));
//			PdfPCell cell011criteria4 = new PdfPCell(new Paragraph("14"));
//			PdfPCell cell012criteria4 = new PdfPCell(new Paragraph("02"));
//			PdfPCell cell013criteria4 = new PdfPCell(new Paragraph("Printers"));
//			PdfPCell cell014criteria4 = new PdfPCell(new Paragraph("84"));
//			PdfPCell cell015criteria4 = new PdfPCell(new Paragraph("26"));
//			PdfPCell cell016criteria4 = new PdfPCell(new Paragraph(" LCD Projector"));
//			PdfPCell cell017criteria4 = new PdfPCell(new Paragraph("48"));
//			PdfPCell cell018criteria4 = new PdfPCell(new Paragraph("27"));
//			PdfPCell cell019criteria4 = new PdfPCell(new Paragraph("Exclusive Scanners "));
//			PdfPCell cell020criteria4 = new PdfPCell(new Paragraph("	02 "));
//			PdfPCell cell021criteria4 = new PdfPCell(new Paragraph("--"));
//			PdfPCell cell022criteria4 = new PdfPCell(new Paragraph("Internet"));
//			PdfPCell cell023criteria4 = new PdfPCell(new Paragraph("1000 Mbps "));
//			PdfPCell cell024criteria4 = new PdfPCell(new Paragraph("952 Mbps"));
//			PdfPCell cell025criteria4 = new PdfPCell(new Paragraph(" WiFi"));
//			PdfPCell cell026criteria4 = new PdfPCell(new Paragraph(" Reliance Jio and Stand-alone Devices"));
//			PdfPCell cell027criteria4 = new PdfPCell(new Paragraph("Reliance Jio and Stand-alone Dev	ices "));
//			PdfPCell cell028criteria4 = new PdfPCell(new Paragraph("Firewall"));
//			PdfPCell cell029criteria4 = new PdfPCell(new Paragraph("02"));
//			PdfPCell cell030criteria4 = new PdfPCell(new Paragraph("--"));
//			PdfPCell cell031criteria4 = new PdfPCell(new Paragraph("Writing Pads for Online classes"));
//			PdfPCell cell032criteria4 = new PdfPCell(new Paragraph("46"));
//			PdfPCell cell033criteria4 = new PdfPCell(new Paragraph("46 "));
//
//			table1criteria4.addCell(cell01criteria4);
//			table1criteria4.addCell(cell02criteria4);
//			table1criteria4.addCell(cell03criteria4);
//			table1criteria4.addCell(cell04criteria4);
//			table1criteria4.addCell(cell05criteria4);
//			table1criteria4.addCell(cell06criteria4);
//			table1criteria4.addCell(cell07criteria4);
//			table1criteria4.addCell(cell08criteria4);
//			table1criteria4.addCell(cell09criteria4);
//			table1criteria4.addCell(cell010criteria4);
//			table1criteria4.addCell(cell011criteria4);
//			table1criteria4.addCell(cell012criteria4);
//			table1criteria4.addCell(cell013criteria4);
//			table1criteria4.addCell(cell014criteria4);
//			table1criteria4.addCell(cell015criteria4);
//			table1criteria4.addCell(cell016criteria4);
//			table1criteria4.addCell(cell017criteria4);
//			table1criteria4.addCell(cell018criteria4);
//			table1criteria4.addCell(cell019criteria4);
//			table1criteria4.addCell(cell020criteria4);
//			table1criteria4.addCell(cell021criteria4);
//			table1criteria4.addCell(cell022criteria4);
//			table1criteria4.addCell(cell023criteria4);
//			table1criteria4.addCell(cell024criteria4);
//			table1criteria4.addCell(cell025criteria4);
//			table1criteria4.addCell(cell026criteria4);
//			table1criteria4.addCell(cell027criteria4);
//			table1criteria4.addCell(cell028criteria4);
//			table1criteria4.addCell(cell029criteria4);
//			table1criteria4.addCell(cell030criteria4);
//			table1criteria4.addCell(cell031criteria4);
//			table1criteria4.addCell(cell032criteria4);
//			table1criteria4.addCell(cell033criteria4);
//
//			table1criteria4.setSpacingBefore(10f);
//			table1criteria4.setSpacingAfter(20f);
//
//			document.add(table1criteria4);
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
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			PdfPCell cell005criteria4 = new PdfPCell(new Paragraph("paste link for additional information\r\n\r\n"));
//			PdfPCell cell006criteria4 = new PdfPCell(new Paragraph(""));
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
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse412()
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
//			// Creating a table of columns
//			PdfPTable table3criteria4 = new PdfPTable(4);
//
//			// Setting width of table, its columns and spacing
//			table3criteria4.setWidthPercentage(100);
//
//			PdfPCell cell101criteria4 = new PdfPCell(new Paragraph("Facility", font3));
//			PdfPCell cell102criteria4 = new PdfPCell(new Paragraph("Year of creation", font3));
//			PdfPCell cell103criteria4 = new PdfPCell(new Paragraph("Area in Sqm", font3));
//			PdfPCell cell104criteria4 = new PdfPCell(new Paragraph(" Year facility enhanced", font3));
//			PdfPCell cell105criteria4 = new PdfPCell(new Paragraph("Volleyball "));
//			PdfPCell cell106criteria4 = new PdfPCell(new Paragraph(" 2005"));
//			PdfPCell cell107criteria4 = new PdfPCell(new Paragraph("162	"));
//			PdfPCell cell108criteria4 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell109 = new PdfPCell(new Paragraph("Basketball"));
//			PdfPCell cell1010 = new PdfPCell(new Paragraph("2005"));
//			PdfPCell cell1011 = new PdfPCell(new Paragraph("436  "));
//			PdfPCell cell1012 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1013 = new PdfPCell(new Paragraph("Throwball "));
//			PdfPCell cell1014 = new PdfPCell(new Paragraph("	2005 "));
//			PdfPCell cell1015 = new PdfPCell(new Paragraph("	222	"));
//			PdfPCell cell1016 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1017 = new PdfPCell(new Paragraph("Cricket	"));
//			PdfPCell cell1018 = new PdfPCell(new Paragraph("2005 "));
//			PdfPCell cell1019 = new PdfPCell(new Paragraph("3600 "));
//			PdfPCell cell1020 = new PdfPCell(new Paragraph("2016  "));
//			PdfPCell cell1021 = new PdfPCell(new Paragraph("Kabaddi "));
//			PdfPCell cell1022 = new PdfPCell(new Paragraph("	2005"));
//			PdfPCell cell1023 = new PdfPCell(new Paragraph("130"));
//			PdfPCell cell1024 = new PdfPCell(new Paragraph("2020 "));
//			PdfPCell cell1025 = new PdfPCell(new Paragraph("Cricket-net practice"));
//			PdfPCell cell1026 = new PdfPCell(new Paragraph("2020 "));
//			PdfPCell cell1027 = new PdfPCell(new Paragraph("74 "));
//			PdfPCell cell1028 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1029 = new PdfPCell(new Paragraph("Indoor Sports (Carroms Table-Tennis, Chess etc.)"));
//			PdfPCell cell1030 = new PdfPCell(new Paragraph("2005 "));
//			PdfPCell cell1031 = new PdfPCell(new Paragraph("219"));
//			PdfPCell cell1032 = new PdfPCell(new Paragraph("2020"));
//			PdfPCell cell1033 = new PdfPCell(new Paragraph("Yoga center"));
//			PdfPCell cell1034 = new PdfPCell(new Paragraph("2016 "));
//			PdfPCell cell1035 = new PdfPCell(new Paragraph("89 "));
//			PdfPCell cell1036 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1037 = new PdfPCell(new Paragraph("Open-air Auditorium	"));
//			PdfPCell cell1038 = new PdfPCell(new Paragraph("2005 "));
//			PdfPCell cell1039 = new PdfPCell(new Paragraph("3310  "));
//			PdfPCell cell1040 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1041 = new PdfPCell(new Paragraph("Block -1 (II-floor) Air conditioned Seminar Hall)"));
//			PdfPCell cell1042 = new PdfPCell(new Paragraph("	2006 "));
//			PdfPCell cell1043 = new PdfPCell(new Paragraph("263	 "));
//			PdfPCell cell1044 = new PdfPCell(new Paragraph("	2019 (Modernized) "));
//			PdfPCell cell1045 = new PdfPCell(new Paragraph("Auditorium Air-conditioned"));
//			PdfPCell cell1046 = new PdfPCell(new Paragraph("2019 "));
//			PdfPCell cell1047 = new PdfPCell(new Paragraph("287 "));
//			PdfPCell cell1048 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1049 = new PdfPCell(new Paragraph("Block -3 Seminar Hall "));
//			PdfPCell cell1050 = new PdfPCell(new Paragraph("2018 "));
//			PdfPCell cell1051 = new PdfPCell(new Paragraph("	137"));
//			PdfPCell cell1052 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1053 = new PdfPCell(new Paragraph("Foot Ball Ground"));
//			PdfPCell cell1054 = new PdfPCell(new Paragraph("2005 "));
//			PdfPCell cell1055 = new PdfPCell(new Paragraph("	4050 "));
//			PdfPCell cell1056 = new PdfPCell(new Paragraph("2020 "));
//
//			table3criteria4.addCell(cell101criteria4);
//			table3criteria4.addCell(cell102criteria4);
//			table3criteria4.addCell(cell103criteria4);
//			table3criteria4.addCell(cell104criteria4);
//			table3criteria4.addCell(cell105criteria4);
//			table3criteria4.addCell(cell106criteria4);
//			table3criteria4.addCell(cell107criteria4);
//			table3criteria4.addCell(cell108criteria4);
//			table3criteria4.addCell(cell109);
//			table3criteria4.addCell(cell1010);
//			table3criteria4.addCell(cell1011);
//			table3criteria4.addCell(cell1012);
//			table3criteria4.addCell(cell1013);
//			table3criteria4.addCell(cell1014);
//			table3criteria4.addCell(cell1015);
//			table3criteria4.addCell(cell1016);
//			table3criteria4.addCell(cell1017);
//			table3criteria4.addCell(cell1018);
//			table3criteria4.addCell(cell1019);
//			table3criteria4.addCell(cell1020);
//			table3criteria4.addCell(cell1021);
//			table3criteria4.addCell(cell1022);
//			table3criteria4.addCell(cell1023);
//			table3criteria4.addCell(cell1024);
//			table3criteria4.addCell(cell1025);
//			table3criteria4.addCell(cell1026);
//			table3criteria4.addCell(cell1027);
//			table3criteria4.addCell(cell1028);
//			table3criteria4.addCell(cell1029);
//			table3criteria4.addCell(cell1030);
//			table3criteria4.addCell(cell1031);
//			table3criteria4.addCell(cell1032);
//			table3criteria4.addCell(cell1033);
//			table3criteria4.addCell(cell1034);
//			table3criteria4.addCell(cell1035);
//			table3criteria4.addCell(cell1036);
//			table3criteria4.addCell(cell1037);
//			table3criteria4.addCell(cell1038);
//			table3criteria4.addCell(cell1039);
//			table3criteria4.addCell(cell1040);
//			table3criteria4.addCell(cell1041);
//			table3criteria4.addCell(cell1042);
//			table3criteria4.addCell(cell1043);
//			table3criteria4.addCell(cell1044);
//			table3criteria4.addCell(cell1045);
//			table3criteria4.addCell(cell1046);
//			table3criteria4.addCell(cell1047);
//			table3criteria4.addCell(cell1048);
//			table3criteria4.addCell(cell1049);
//			table3criteria4.addCell(cell1050);
//			table3criteria4.addCell(cell1051);
//			table3criteria4.addCell(cell1052);
//			table3criteria4.addCell(cell1053);
//			table3criteria4.addCell(cell1054);
//			table3criteria4.addCell(cell1055);
//			table3criteria4.addCell(cell1056);
//
//			table3criteria4.setSpacingBefore(20f);
//			table3criteria4.setSpacingAfter(20f);
//
//			document.add(table3criteria4);
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
//			PdfPCell cell0009 = new PdfPCell(new Paragraph(" Upload Any additional information\r\n\r\n"));
//			PdfPCell cell0010 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//			PdfPCell cell0011 = new PdfPCell(new Paragraph("Geotagged pictures\r\n\r\n"));
//			PdfPCell cell0012 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : ""));
//			PdfPCell cell0013 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			PdfPCell cell0014 = new PdfPCell(new Paragraph(""));
//
//			table4criteria4.addCell(cell007);
//			table4criteria4.addCell(cell008);
//			table4criteria4.addCell(cell0009);
//			table4criteria4.addCell(cell0010);
//			table4criteria4.addCell(cell0011);
//			table4criteria4.addCell(cell0012);
//			table4criteria4.addCell(cell0013);
//			table4criteria4.addCell(cell0014);
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
//			PdfPCell cell0017 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n"));
//			PdfPCell cell0018 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(3).getCriteria4FilePath() : ""));
//			PdfPCell cell0019 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell0020 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(4).getCriteria4FilePath() : ""));
//			PdfPCell cell0021 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			PdfPCell cell0022 = new PdfPCell(new Paragraph());
//
//			table5criteria4.addCell(cell0015);
//			table5criteria4.addCell(cell0016);
//			table5criteria4.addCell(cell0017);
//			table5criteria4.addCell(cell0018);
//			table5criteria4.addCell(cell0019);
//			table5criteria4.addCell(cell0020);
//			table5criteria4.addCell(cell0021);
//			table5criteria4.addCell(cell0022);
//
//			PdfPCell cell4120criteria4 = new PdfPCell(new Paragraph(
//					"4.1.3 Availability of general campus facilities and overall ambience\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse413()
//									: ""),font3));
//
//			PdfPCell cell41200criteria4 = new PdfPCell(new Paragraph("4.1.3.1 Number of classrooms and seminar halls with ICT facilities\r\n Response: "
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getInput4131t1() : ""),font3));
//
//			 table51.addCell(cell4120criteria4);
//			 table51.addCell(cell41200criteria4);
//			 
//			 table51.addCell(table5criteria4);
//
//			table51.addCell(table5criteria4);
//
//			table51.setSpacingBefore(20f);
//			table51.setSpacingAfter(20f);
//
//			document.add(table51);
//
//			// Creating a table of 3 columns
//			PdfPTable table6criteria4 = new PdfPTable(2);
//			PdfPTable table61criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table6criteria4.setWidthPercentage(100);
//			table61criteria4.setWidthPercentage(100);
//
////			PdfPCell cell0023 = new PdfPCell(new Paragraph("2020-21"));
////			PdfPCell cell0024 = new PdfPCell(new Paragraph("2019-20"));
////			PdfPCell cell0025 = new PdfPCell(new Paragraph(" 2018-19"));
////			PdfPCell cell0026 = new PdfPCell(new Paragraph("2017-18 "));
////			PdfPCell cell0027 = new PdfPCell(new Paragraph("2016-17"));
////			PdfPCell cell0028 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell0029 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell0030 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell0031 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell0032 = new PdfPCell(new Paragraph(" "));
//	//
////			table6criteria4.addCell(cell0023);
////			table6criteria4.addCell(cell0024);
////			table6criteria4.addCell(cell0025);
////			table6criteria4.addCell(cell0026);
////			table6criteria4.addCell(cell0027);
////			table6criteria4.addCell(cell0028);
////			table6criteria4.addCell(cell0029);
////			table6criteria4.addCell(cell0030);
////			table6criteria4.addCell(cell0031);
////			table6criteria4.addCell(cell0032);
//
//			PdfPCell cell41201criteria4 = new PdfPCell(new Paragraph(
//					"4.1.4 Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)\r\n"
//							+ "\r\n" + "Response: "
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse414()
//									: ""),font3));
//
//			// table61criteria4.addCell(criteria4List.get(0).getResponseValue414());
//
//			PdfPCell cell41202criteria4 = new PdfPCell(new Paragraph(
//					"4.1.4.1 Expenditure for infrastructure augmentation, excluding salary year-wise during last five years (INR in lakhs)\r\n\r\n",font3));
//
//			
//			table61criteria4.addCell(cell41201criteria4);
//			table61criteria4.addCell(cell41202criteria4);
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
//			PdfPCell cell0033 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//			PdfPCell cell0034 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell0035 = new PdfPCell(
//					new Paragraph("Upload audited utilization statements\r\n\r\n "));
//			PdfPCell cell0036 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(5).getCriteria4FilePath() : ""));
//			PdfPCell cell0037 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n"));
//			PdfPCell cell0038 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(6).getCriteria4FilePath() : ""));
//			PdfPCell cell0039 = new PdfPCell(new Paragraph(" Institutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell0040 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(7).getCriteria4FilePath() : ""));
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
//			Paragraph paragraph31criteria4 = new Paragraph("4.2 Library as a Learning Resource\r\n\r\n\r\n", font1);
//			paragraph31criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph28 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph28.setSize(12);
//			 */
//
//			Paragraph paragraph32criteria4 = new Paragraph(
//					"4.2.1	Library is automated using Integrated Library Management System (ILMS)\r\n" + "Response",
//					font2);
//			paragraph32criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			PdfPTable table421criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table421criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00400 = new PdfPCell(new Paragraph(
//					"4.2.1 Library is automated using Integrated Library Management System (ILMS)\r\n\r\n+ Response:"
//					+(criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse421()
//									: ""),font3));
//			
//			table421criteria4.addCell(cell00400);
//			// table421criteria4.addCell(criteria4List.get(3).getResponseValue421());
//			
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
//					new Paragraph(criteria4Record != null ? criteria4file.get(7).getCriteria4FilePath() : ""));
//			PdfPCell cell0045 = new PdfPCell(new Paragraph("Paste Link for additional information\r\n\r\n\r\n "));
//			PdfPCell cell0046 = new PdfPCell(new Paragraph(" "));
//
//			table8criteria4.addCell(cell0041);
//			table8criteria4.addCell(cell0042);
//			table8criteria4.addCell(cell0043);
//			table8criteria4.addCell(cell0044);
//			table8criteria4.addCell(cell0045);
//			table8criteria4.addCell(cell0046);
//
//			table8criteria4.setSpacingBefore(20f);
//			table8criteria4.setSpacingAfter(20f);
//			document.add(table8criteria4);
//
//			// Creating a table of 3 columns
//			PdfPTable table9criteria4 = new PdfPTable(2);
//			PdfPTable table10criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table9criteria4.setWidthPercentage(100);
//			table10criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0047 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font6criteria4));
//			PdfPCell cell0048 = new PdfPCell(new Paragraph("Document\r\n\r\n", font6criteria4));
//			PdfPCell cell0049 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell0050 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(8).getCriteria4FilePath() : ""));
//			PdfPCell cell0051 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell0052 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(9).getCriteria4FilePath() : ""));
////			PdfPCell cell0053 = new PdfPCell(new Paragraph(
////					"Details of subscriptions like e-journals, e-books , e- ShodhSindhu, Shodhganga Membership etc\r\n\r\n\r\n"));
////			PdfPCell cell0054 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(10).getCriteria4FilePath() : ""));
//
//			table9criteria4.addCell(cell0047);
//			table9criteria4.addCell(cell0048);
//			table9criteria4.addCell(cell0049);
//			table9criteria4.addCell(cell0050);
//			table9criteria4.addCell(cell0051);
//			table9criteria4.addCell(cell0052);
////			table9criteria4.addCell(cell0053);
////			table9criteria4.addCell(cell0054);
//
//			PdfPCell cell00510 = new PdfPCell(new Paragraph(
//					"4.2.2 Institution has access to the following: 1. e-journals 2. e-ShodhSindhu 3. Shodhganga Membership 4. e-books 5. Databases 6. Remote access to e-resources\r\n"
//						 + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse422()
//									: ""),font3));
//			// table10criteria4.addCell(criteria4List.get(0).getResponseValue422());
//			
//			table10criteria4.addCell(cell00510);
//			table10criteria4.addCell(table9criteria4);
//
//			table10criteria4.setSpacingBefore(20f);
//			table10criteria4.setSpacingAfter(20f);
//
//			document.add(table10criteria4);
//
//			// Creating a table of 3 columns
//			PdfPTable table11criteria4 = new PdfPTable(2);
//			PdfPTable table12criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table11criteria4.setWidthPercentage(100);
//			table12criteria4.setWidthPercentage(100);
//	//
////			PdfPCell cell0055 = new PdfPCell(new Paragraph("2020-21"));
////			PdfPCell cell0056 = new PdfPCell(new Paragraph("2019-20"));
////			PdfPCell cell0057 = new PdfPCell(new Paragraph("2018-19"));
////			PdfPCell cell0058 = new PdfPCell(new Paragraph("2017-18"));
////			PdfPCell cell0059 = new PdfPCell(new Paragraph("2016-17"));
////			PdfPCell cell0060 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell0061 = new PdfPCell(new Paragraph(""));
////			PdfPCell cell0062 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell0063 = new PdfPCell(new Paragraph(""));
////			PdfPCell cell0064 = new PdfPCell(new Paragraph(" "));
//	//
////			table11criteria4.addCell(cell0055);
////			table11criteria4.addCell(cell0056);
////			table11criteria4.addCell(cell0057);
////			table11criteria4.addCell(cell0058);
////			table11criteria4.addCell(cell0059);
////			table11criteria4.addCell(cell0060);
////			table11criteria4.addCell(cell0061);
////			table11criteria4.addCell(cell0062);
////			table11criteria4.addCell(cell0063);
////			table11criteria4.addCell(cell0064);
//			
//			PdfPCell cell0065 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font6criteria4));
//			PdfPCell cell0066 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
//			PdfPCell cell0067 = new PdfPCell(new Paragraph(
//					"Institutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell0068 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(10).getCriteria4FilePath() : ""));
//			PdfPCell cell0069 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n"));
//			PdfPCell cell0070 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(11).getCriteria4FilePath() : ""));
////			PdfPCell cell0071 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
////			PdfPCell cell0072 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(13).getCriteria4FilePath() : ""));
//
//			table11criteria4.addCell(cell0065);
//			table11criteria4.addCell(cell0066);
//			table11criteria4.addCell(cell0067);
//			table11criteria4.addCell(cell0068);
//			table11criteria4.addCell(cell0069);
//			table11criteria4.addCell(cell0070);
////			table13.addCell(cell0071);
////			table13.addCell(cell0072);
////			
//
//			PdfPCell cell005101 = new PdfPCell(new Paragraph(
//					"4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n"
//							+ "\r\n\r\n" + "Response: "
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse423()
//									: ""),font3));
//			// table12criteria4.addCell(criteria4List.get(4).getResponseValue423());
//
//			PdfPCell cell0051011 = new PdfPCell(new Paragraph(
//					"4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)"
//							+ "\r\n\r\n",font3));
//			
//			table12criteria4.addCell(cell005101);
//			table12criteria4.addCell(cell0051011);
//			
//			table12criteria4.addCell(table11criteria4);
//
//			table12criteria4.setSpacingBefore(20f);
//			table12criteria4.setSpacingAfter(20f);
//
//			document.add(table12criteria4);
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
//
//			// Setting width of table, its columns and spacing
//			table13.setWidthPercentage(100);
//
//		
//
//			table13.setSpacingBefore(20f);
//			table13.setSpacingAfter(20f);
//
//			document.add(table13);
//
//			// Creating a table of 3 columns
//			PdfPTable table14criteria4 = new PdfPTable(2);
//			PdfPTable table15 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table14criteria4.setWidthPercentage(100);
//			table15.setWidthPercentage(100);
//
//			PdfPCell cell0075 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font6criteria4));
//			PdfPCell cell0076 = new PdfPCell(new Paragraph("Document\r\n\r\n", font6criteria4));
//			PdfPCell cell0077 = new PdfPCell(new Paragraph("Details of library usage by teachers and students\r\n\r\n"));
//			PdfPCell cell0078 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(12).getCriteria4FilePath() : ""));
//			PdfPCell cell0079 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			PdfPCell cell0080 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(13).getCriteria4FilePath() : ""));
//
//			table14criteria4.addCell(cell0075);
//			table14criteria4.addCell(cell0076);
//			table14criteria4.addCell(cell0077);
//			table14criteria4.addCell(cell0078);
//			table14criteria4.addCell(cell0079);
//			table14criteria4.addCell(cell0080);
//
//			PdfPCell cell00770 = new PdfPCell(new Paragraph(
//					"4.2.4 Percentage per day usage of library by teachers and students ( foot falls and login data for online access) during the latest completed academic year\r\n"
//							+ "\r\n\r\n\r\n" + "Response: "
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse424()
//									: ""),font3));
//			
//			table15.addCell(cell00770);
//
//			// table15.addCell(criteria4List.get(0).getResponseValue424());
//
//			PdfPCell cell007701 = new PdfPCell(new Paragraph(("4.2.4.1 Number of teachers and students using library per day over last one year\r\n" + "\r\n"
//					+ "Response: "
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getInput4241t1() : "")),font3));
//
//			table15.addCell(cell007701);
//			table15.addCell(table14criteria4);
//
//			table15.setSpacingBefore(20f);
//			table15.setSpacingAfter(20f);
//
//			document.add(table15);
//
//			/*
//			 * Font fontParagraph34 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph34.setSize(12);
//			 */
//
//			Paragraph paragraph38criteria4 = new Paragraph("4.3 IT Infrastructure\r\n\r\n", font2);
//			paragraph38criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph35 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph35.setSize(12);
//			 */
//
//			Paragraph paragraph39criteria4 = new Paragraph(
//					"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n\r\n",font3);
//			paragraph39criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph36 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph36.setSize(12);
//			 */
//
//			Paragraph paragraph40 = new Paragraph("Response:\r\n\r\n", font3);
//			paragraph40.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph37 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph37.setSize(12);
//			 */
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
//			document.add(paragraph38criteria4);
//			document.add(paragraph39criteria4);
//			document.add(paragraph40);
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
//			// Creating a table of 3 columns
//
//			PdfPTable table16criteria4 = new PdfPTable(5);
//			PdfPTable table17criteria4 = new PdfPTable(2);
//
//			// Setting width of table, its columns and spacing
//			table16criteria4.setWidthPercentage(100);
//			table17criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0081 = new PdfPCell(new Paragraph("Budget allocated for IT facilities"));
//			PdfPCell cell0082 = new PdfPCell(new Paragraph("2016-17"));
//			PdfPCell cell0083 = new PdfPCell(new Paragraph("2017-2018"));
//			PdfPCell cell0084 = new PdfPCell(new Paragraph("2018-2019"));
//			PdfPCell cell0085 = new PdfPCell(new Paragraph("2019-2020"));
//			PdfPCell cell0086 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell0087 = new PdfPCell(new Paragraph("50,45,018"));
//			PdfPCell cell0088 = new PdfPCell(new Paragraph("96,97,574 "));
//			PdfPCell cell0089 = new PdfPCell(new Paragraph("79,75,787"));
//			PdfPCell cell0090 = new PdfPCell(new Paragraph("89,95,799 "));
//
//			table16criteria4.addCell(cell0081);
//			table16criteria4.addCell(cell0082);
//			table16criteria4.addCell(cell0083);
//			table16criteria4.addCell(cell0084);
//			table16criteria4.addCell(cell0085);
//			table16criteria4.addCell(cell0086);
//			table16criteria4.addCell(cell0087);
//			table16criteria4.addCell(cell0088);
//			table16criteria4.addCell(cell0089);
//			table16criteria4.addCell(cell0090);
//
//			table16criteria4.setSpacingBefore(20f);
//			table16criteria4.setSpacingAfter(20f);
//
//			document.add(table16criteria4);
//
//			PdfPCell cell0091 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell0092 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell0093 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell0094 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(14).getCriteria4FilePath() : ""));
//			PdfPCell cell0095 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell0096 = new PdfPCell(new Paragraph(" "));
//
//			table17criteria4.addCell(cell0091);
//			table17criteria4.addCell(cell0092);
//			table17criteria4.addCell(cell0093);
//			table17criteria4.addCell(cell0094);
//			table17criteria4.addCell(cell0095);
//			table17criteria4.addCell(cell0096);
//
//			PdfPCell cell431criteria4 = new PdfPCell(new Paragraph(
//					"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse431()
//									: "")));
//			PdfPCell cell4311criteria4 = new PdfPCell(new Paragraph(
//					"4.3.1.1 Number of classrooms and seminar halls with ICT facilities\r\n"
//					+ "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse431()
//									: "")));
//			table17criteria4.addCell(cell431criteria4);
//			table17criteria4.addCell(cell4311criteria4);
//			
//			
//			table17criteria4.addCell(table16criteria4);
//			
//			document.add(table17criteria4);
//
//			// Creating a table of 3 columns
//			PdfPTable table18criteria4 = new PdfPTable(2);
//			PdfPTable table19criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table18criteria4.setWidthPercentage(100);
//			table19criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0097 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			PdfPCell cell0098 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell0099 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			PdfPCell cell00100 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(15).getCriteria4FilePath() : ""));
////			PdfPCell cell00101 = new PdfPCell(new Paragraph("Student - computer ratio\r\n\r\n\r\n"));
////			PdfPCell cell00102 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(18).getCriteria4FilePath() : ""));
//
//			table18criteria4.addCell(cell0097);
//			table18criteria4.addCell(cell0098);
//			table18criteria4.addCell(cell0099);
//			table18criteria4.addCell(cell00100);
////			table18criteria4.addCell(cell00101);
////			table18criteria4.addCell(cell00102);
//
//			PdfPCell cell00991 = new PdfPCell(new Paragraph("4.3.2 Institution has an IT policy, makes appropriate budgetary provision and updates its IT\r\n"
//					+ "facilities including Wi-Fi facility\r\n"+ "\r\n\r\n" + "Response:"
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse432()
//							: ""),font3));
//			// table19criteria4.addCell(criteria4List.get(0).getResponseValue432());
//
//			table19criteria4.addCell(cell00991);
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
//			PdfPCell cell00103 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			PdfPCell cell00104 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell00105 = new PdfPCell(
//					new Paragraph("Details of available bandwidth of internet connection in the Institution\r\n\r\n"));
//			PdfPCell cell00106 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(16).getCriteria4FilePath() : ""));
//
//			table20criteria4.addCell(cell00103);
//			table20criteria4.addCell(cell00104);
//			table20criteria4.addCell(cell00105);
//			table20criteria4.addCell(cell00106);
//
//			PdfPCell cell001040 = new PdfPCell(new Paragraph("4.3.3 Bandwidth of internet connection in the Institution.\r\n" + "\r\n" + "Response:"
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse433()
//							: ""),font3));
//
//			// table21criteria4.addCell(criteria4List.get(0).getResponseValue433());
//
//			table21criteria4.addCell(cell001040);
//			
//			table21criteria4.addCell(table20criteria4);
//			document.add(table21criteria4);
//			
//			
//			PdfPTable table434criteria4 = new PdfPTable(2);
//			PdfPTable table4341criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table434criteria4.setWidthPercentage(100);
//			table4341criteria4.setWidthPercentage(100);
//
//			PdfPCell cell001031 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell001042 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			
//			PdfPCell cell001053 = new PdfPCell(
//					new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell001064 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(17).getCriteria4FilePath() : ""));
//
//			
//			PdfPCell cell0010531 = new PdfPCell(
//					new Paragraph("Details of available bandwidth of internet connection in the Institution\r\n\r\n\r\n"));
//			PdfPCell cell0010641 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(19).getCriteria4FilePath() : ""));
//
//			table434criteria4.addCell(cell001031);
//			table434criteria4.addCell(cell001042);
//			table434criteria4.addCell(cell001053);
//			table434criteria4.addCell(cell001064);
//			table434criteria4.addCell(cell0010531);
//			table434criteria4.addCell(cell0010641);
//
//			PdfPCell cell0010421 = new PdfPCell(new Paragraph("4.3.4 Available bandwidth of internet connection in the Institution (Leased line)\r\n"
//				 + "\r\n" + "Response:"
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse434()
//							: ""),font3));
//
//			// table21criteria4.addCell(criteria4List.get(0).getResponseValue433());
//			
//			table4341criteria4.addCell(cell0010421);
//			table4341criteria4.addCell(table434criteria4);
//			document.add(table4341criteria4);
//
//			// Creating a table of 3 columns
//
//			PdfPTable table22criteria4 = new PdfPTable(2);
//			PdfPTable table23criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table22criteria4.setWidthPercentage(100);
//			table23criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00107 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell00108 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00109 = new PdfPCell(new Paragraph("Upload Additional information\r\n\r\n\r\n"));
//			PdfPCell cell00110 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(18).getCriteria4FilePath() : ""));
//			PdfPCell cell00111 = new PdfPCell(new Paragraph(" Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell00112 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(19).getCriteria4FilePath() : ""));
//			
//			PdfPCell cell001111 = new PdfPCell(new Paragraph(" Links of photographs\r\n\r\n\r\n"));
//			PdfPCell cell001121 = new PdfPCell(
//					new Paragraph());
//
//			table22criteria4.addCell(cell00107);
//			table22criteria4.addCell(cell00108);
//			table22criteria4.addCell(cell00109);
//			table22criteria4.addCell(cell00110);
//			table22criteria4.addCell(cell00111);
//			table22criteria4.addCell(cell00112);
//			table22criteria4.addCell(cell001111);
//			table22criteria4.addCell(cell001121);
//
//			PdfPCell cell001110 = new PdfPCell(new Paragraph("4.3.5	Institution has the following Facilities for e-content development\r\n" + "\r\n"
//					+ "1.	Media centre\r\n" + "2.	Audio visual centre\r\n" + "3.	Lecture Capturing System(LCS)\r\n"
//					+ "4.	Mixing equipments and softwares for editing\r\n" + "\r\n" + "\r\n" + "\r\n" + "Response: "
//					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse434()
//							: ""),font3));
//
//			// table23criteria4.addCell(criteria4List.get(0).getResponseValue434());
//			table23criteria4.addCell(cell001110);
//			table23criteria4.addCell(table22criteria4);
//
//			table23criteria4.setSpacingBefore(20f);
//			table23criteria4.setSpacingAfter(20f);
//
//			document.add(table23criteria4);
//
//			/*
//			 * Font fontParagraph46 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph46.setSize(12);
//			 */
//
//			Paragraph paragraph50 = new Paragraph("4.4 Maintenance of Campus Infrastructure\r\n\r\n\r\n" + "", font2);
//			paragraph50.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph50);
//
//			// Creating a table of 3 columns
//
//			PdfPTable table24criteria4 = new PdfPTable(5);
//			PdfPTable table25criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table24criteria4.setWidthPercentage(100);
//			table25criteria4.setWidthPercentage(100);
//
////			PdfPCell cell00113 = new PdfPCell(new Paragraph("2020-21"));
////			PdfPCell cell00114 = new PdfPCell(new Paragraph("2019-20"));
////			PdfPCell cell00115 = new PdfPCell(new Paragraph("2018-19"));
////			PdfPCell cell00116 = new PdfPCell(new Paragraph("2017-18"));
////			PdfPCell cell00117 = new PdfPCell(new Paragraph("2016-17"));
////			PdfPCell cell00118 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell00119 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell00120 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell00121 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell00122 = new PdfPCell(new Paragraph(" "));
//	//
////			table24criteria4.addCell(cell00113);
////			table24criteria4.addCell(cell00114);
////			table24criteria4.addCell(cell00115);
////			table24criteria4.addCell(cell00116);
////			table24criteria4.addCell(cell00117);
////			table24criteria4.addCell(cell00118);
////			table24criteria4.addCell(cell00119);
////			table24criteria4.addCell(cell00120);
////			table24criteria4.addCell(cell00121);
////			table24criteria4.addCell(cell00122);
//
//			PdfPCell cell001091 = new PdfPCell(new Paragraph(
//					"4.4.1 Average percentage expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component during the last five years\r\n\r\n"
//							+ " Response: "
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse441()
//									: ""),font3));
//
//			// table25criteria4.addCell(criteria4List.get(0).getResponseValue441());
//
//			PdfPCell cell0010911 = new PdfPCell(new Paragraph(
//					"4.4.1.1 Expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component year wise during the last five years (INR in lakhs)\r\n\r\n",font3));
//
//			table25criteria4.addCell(cell001091);
//			table25criteria4.addCell(cell0010911);
//			table25criteria4.addCell(table24criteria4);
//
//			table25criteria4.setSpacingBefore(20f);
//			table25criteria4.setSpacingAfter(20f);
//
//			document.add(table25criteria4);
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
//					"Institutional data in prescribed format\r\n\r\n\r\n "));
//			PdfPCell cell00126 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(20).getCriteria4FilePath() : ""));
//			PdfPCell cell00127 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n\r\n "));
//			PdfPCell cell00128 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(21).getCriteria4FilePath() : ""));
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
//			 */
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
//			PdfPCell cell001271 = new PdfPCell(new Paragraph(
//					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\\r\\n\"\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse442()
//									: ""),font3));
//			// table442criteria4.addCell(criteria4List.get(0).getResponseValue442());
//			table442criteria4.addCell(cell001271);
//
//			document.add(table442criteria4);
//
//		
//
//			paragraph51.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph48 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph48.setSize(12);
//			 */
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
//			document.add(paragraph52);
//
//			PdfPTable table27criteria4 = new PdfPTable(2);
//			table27criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00129 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell00130 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00131 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell00132 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(22).getCriteria4FilePath() : ""));
//			PdfPCell cell00133 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell00134 = new PdfPCell(new Paragraph(" "));
//
//			table27criteria4.addCell(cell00129);
//			table27criteria4.addCell(cell00130);
//			table27criteria4.addCell(cell00131);
//			table27criteria4.addCell(cell00132);
//			table27criteria4.addCell(cell00133);
//			table27criteria4.addCell(cell00134);
//
//			table27criteria4.setSpacingBefore(20f);
//			table27criteria4.setSpacingAfter(20f);
//
//			document.add(table27criteria4);
//
//				
//		
//			document.close();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//			
//		}
//				
//			
//		}