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
//import org.springframework.stereotype.Service;
//
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
//@Component
//public class AutonomousCriteria41Report {
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//	@Autowired
//	Criteria4Service service4;
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
//	List<Criteria4_FieldInfo> criteria4List = null;
//	Criteria4_FieldInfo criteria4Record = null;
//	List<Criteria4_FileUpload> criteria4file = null;
//	
//
//public String generateReport(Criteria4_FieldInfo criteria4Fieldinfo) throws DocumentException, IOException {
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
//
//			criteria4List = service4.getAllCriteria4Data();
//			if (CollectionUtils.isNotEmpty(criteria4List)) {
//				criteria4Record = criteria4List.get(0);
//				criteria4file = criteria4Record.getCriteria4FileUpload();
//			} else {
//				criteria4Record = new Criteria4_FieldInfo();
//				criteria4file = new ArrayList<>();
//			}
//
//
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AuthonomousCriteria4Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//				
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
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse411()
//									: ""),
//					font3));
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
//		
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
//		
//
//			/*
//			 * Font font4criteria4 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * font4criteria4.setSize(12);
//			 */
//
////			Paragraph paragraph5criteria4 = new Paragraph(
////					"Mother Teresa has a lush green campus of 13.5 acres, with aesthetically designed buildings, which has been providing notable academic ambience, conducive for Quality Teaching-Learning. The college has adequate infrastructure facilities for Instructional delivery and services as denoted below",
////					font5);
////			paragraph5criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			document.add(paragraph5criteria4);
//
//			/*
//			 * Font font5criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font5criteria4.setSize(12);
//			 */
//
////			Paragraph paragraph6criteria4 = new Paragraph("Infrastructure facilities available for Teaching-Learning",
////					font3);
////			paragraph6criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			document.add(paragraph6criteria4);
//
//			// creating table
////			PdfPTable tablecriteria4 = new PdfPTable(4);
////
////			tablecriteria4.setWidthPercentage(100);
////
////			Font font6criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			font6criteria4.setColor(CMYKColor.BLACK);
////
////			PdfPCell cell1criteria4 = new PdfPCell(new Paragraph("Physical Facilities", font3));
////			PdfPCell cell2criteria4 = new PdfPCell(new Paragraph("Total Number Area", font3));
////			PdfPCell cell3criteria4 = new PdfPCell(new Paragraph("Area (in Sqm.)", font3));
////			PdfPCell cell4criteria4 = new PdfPCell(new Paragraph("No. added during the ensuing A/A period", font3));
////			PdfPCell cell5criteria4 = new PdfPCell(new Paragraph("Classrooms"));
////			PdfPCell cell6criteria4 = new PdfPCell(new Paragraph("70"));
////			PdfPCell cell7criteria4 = new PdfPCell(new Paragraph("5098"));
////			PdfPCell cell8criteria4 = new PdfPCell(new Paragraph("12"));
////			PdfPCell cell9criteria4 = new PdfPCell(new Paragraph("Laboratories"));
////			PdfPCell cell10criteria4 = new PdfPCell(new Paragraph("87"));
////			PdfPCell cell11criteria4 = new PdfPCell(new Paragraph("7019"));
////			PdfPCell cell12criteria4 = new PdfPCell(new Paragraph("19"));
////			PdfPCell cell13criteria4 = new PdfPCell(new Paragraph("Workshops"));
////			PdfPCell cell14criteria4 = new PdfPCell(new Paragraph("06"));
////			PdfPCell cell15criteria4 = new PdfPCell(new Paragraph("1469"));
////			PdfPCell cell16criteria4 = new PdfPCell(new Paragraph("01"));
////			PdfPCell cell17criteria4 = new PdfPCell(new Paragraph("Computer Centres"));
////			PdfPCell cell18criteria4 = new PdfPCell(new Paragraph("02"));
////			PdfPCell cell19criteria4 = new PdfPCell(new Paragraph("326"));
////			PdfPCell cell20criteria4 = new PdfPCell(new Paragraph("01"));
////			PdfPCell cell21criteria4 = new PdfPCell(new Paragraph("Drawing Hall"));
////			PdfPCell cell22criteria4 = new PdfPCell(new Paragraph("02"));
////			PdfPCell cell23criteria4 = new PdfPCell(new Paragraph("343"));
////			PdfPCell cell24criteria4 = new PdfPCell(new Paragraph("-"));
////			PdfPCell cell25criteria4 = new PdfPCell(new Paragraph("Seminar Rooms"));
////			PdfPCell cell26criteria4 = new PdfPCell(new Paragraph("03"));
////			PdfPCell cell27criteria4 = new PdfPCell(new Paragraph("687"));
////			PdfPCell cell28criteria4 = new PdfPCell(new Paragraph("-"));
////			PdfPCell cell29criteria4 = new PdfPCell(new Paragraph("Library"));
////			PdfPCell cell30criteria4 = new PdfPCell(new Paragraph("01"));
////			PdfPCell cell31criteria4 = new PdfPCell(new Paragraph("1064"));
////			PdfPCell cell32criteria4 = new PdfPCell(new Paragraph("-"));
////			PdfPCell cell33criteria4 = new PdfPCell(new Paragraph("Language Laboratories"));
////			PdfPCell cell34criteria4 = new PdfPCell(new Paragraph("02"));
////			PdfPCell cell35criteria4 = new PdfPCell(new Paragraph("137"));
////			PdfPCell cell36criteria4 = new PdfPCell(new Paragraph("-"));
////			PdfPCell cell37criteria4 = new PdfPCell(new Paragraph("Research Laboratories"));
////			PdfPCell cell38criteria4 = new PdfPCell(new Paragraph("03"));
////			PdfPCell cell39criteria4 = new PdfPCell(new Paragraph("323"));
////			PdfPCell cell40criteria4 = new PdfPCell(new Paragraph("01"));
////			PdfPCell cell41criteria4 = new PdfPCell(new Paragraph("Examination Center"));
////			PdfPCell cell42criteria4 = new PdfPCell(new Paragraph("01"));
////			PdfPCell cell43criteria4 = new PdfPCell(new Paragraph("280"));
////			PdfPCell cell44criteria4 = new PdfPCell(new Paragraph("-"));
////
////			tablecriteria4.addCell(cell1criteria4);
////			tablecriteria4.addCell(cell2criteria4);
////			tablecriteria4.addCell(cell3criteria4);
////			tablecriteria4.addCell(cell4criteria4);
////			tablecriteria4.addCell(cell5criteria4);
////			tablecriteria4.addCell(cell6criteria4);
////			tablecriteria4.addCell(cell7criteria4);
////			tablecriteria4.addCell(cell8criteria4);
////			tablecriteria4.addCell(cell9criteria4);
////			tablecriteria4.addCell(cell10criteria4);
////			tablecriteria4.addCell(cell11criteria4);
////			tablecriteria4.addCell(cell12criteria4);
////			tablecriteria4.addCell(cell13criteria4);
////			tablecriteria4.addCell(cell14criteria4);
////			tablecriteria4.addCell(cell15criteria4);
////			tablecriteria4.addCell(cell16criteria4);
////			tablecriteria4.addCell(cell17criteria4);
////			tablecriteria4.addCell(cell18criteria4);
////			tablecriteria4.addCell(cell19criteria4);
////			tablecriteria4.addCell(cell20criteria4);
////			tablecriteria4.addCell(cell21criteria4);
////			tablecriteria4.addCell(cell22criteria4);
////			tablecriteria4.addCell(cell23criteria4);
////			tablecriteria4.addCell(cell24criteria4);
////			tablecriteria4.addCell(cell25criteria4);
////			tablecriteria4.addCell(cell26criteria4);
////			tablecriteria4.addCell(cell27criteria4);
////			tablecriteria4.addCell(cell28criteria4);
////			tablecriteria4.addCell(cell29criteria4);
////			tablecriteria4.addCell(cell30criteria4);
////			tablecriteria4.addCell(cell31criteria4);
////			tablecriteria4.addCell(cell32criteria4);
////			tablecriteria4.addCell(cell33criteria4);
////			tablecriteria4.addCell(cell34criteria4);
////			tablecriteria4.addCell(cell35criteria4);
////			tablecriteria4.addCell(cell36criteria4);
////			tablecriteria4.addCell(cell37criteria4);
////			tablecriteria4.addCell(cell38criteria4);
////			tablecriteria4.addCell(cell39criteria4);
////			tablecriteria4.addCell(cell40criteria4);
////			tablecriteria4.addCell(cell41criteria4);
////			tablecriteria4.addCell(cell42criteria4);
////			tablecriteria4.addCell(cell43criteria4);
////			tablecriteria4.addCell(cell44criteria4);
////
////			tablecriteria4.setSpacingBefore(20f);
////			tablecriteria4.setSpacingAfter(20f);
////
////			document.add(tablecriteria4);
//
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
////			// Creating a table of columns
////			PdfPTable table1criteria4 = new PdfPTable(3);
////
////			// Setting width of table, its columns and spacing
////			table1criteria4.setWidthPercentage(100);
////
////			PdfPCell cell01criteria4 = new PdfPCell(new Paragraph("Description", font3));
////			PdfPCell cell02criteria4 = new PdfPCell(new Paragraph("Available Number", font3));
////			PdfPCell cell03criteria4 = new PdfPCell(
////					new Paragraph("Till 2020-21	Added during the ensuing A/A du	ratio", font3));
////			PdfPCell cell04criteria4 = new PdfPCell(new Paragraph(" Desktop Computers"));
////			PdfPCell cell05criteria4 = new PdfPCell(new Paragraph("1818 "));
////			PdfPCell cell06criteria4 = new PdfPCell(new Paragraph("1547*"));
////			PdfPCell cell07criteria4 = new PdfPCell(new Paragraph(" Servers"));
////			PdfPCell cell08criteria4 = new PdfPCell(new Paragraph("05 "));
////			PdfPCell cell09criteria4 = new PdfPCell(new Paragraph(" 01"));
////			PdfPCell cell010criteria4 = new PdfPCell(new Paragraph("Laptops"));
////			PdfPCell cell011criteria4 = new PdfPCell(new Paragraph("14"));
////			PdfPCell cell012criteria4 = new PdfPCell(new Paragraph("02"));
////			PdfPCell cell013criteria4 = new PdfPCell(new Paragraph("Printers"));
////			PdfPCell cell014criteria4 = new PdfPCell(new Paragraph("84"));
////			PdfPCell cell015criteria4 = new PdfPCell(new Paragraph("26"));
////			PdfPCell cell016criteria4 = new PdfPCell(new Paragraph(" LCD Projector"));
////			PdfPCell cell017criteria4 = new PdfPCell(new Paragraph("48"));
////			PdfPCell cell018criteria4 = new PdfPCell(new Paragraph("27"));
////			PdfPCell cell019criteria4 = new PdfPCell(new Paragraph("Exclusive Scanners "));
////			PdfPCell cell020criteria4 = new PdfPCell(new Paragraph("	02 "));
////			PdfPCell cell021criteria4 = new PdfPCell(new Paragraph("--"));
////			PdfPCell cell022criteria4 = new PdfPCell(new Paragraph("Internet"));
////			PdfPCell cell023criteria4 = new PdfPCell(new Paragraph("1000 Mbps "));
////			PdfPCell cell024criteria4 = new PdfPCell(new Paragraph("952 Mbps"));
////			PdfPCell cell025criteria4 = new PdfPCell(new Paragraph(" WiFi"));
////			PdfPCell cell026criteria4 = new PdfPCell(new Paragraph(" Reliance Jio and Stand-alone Devices"));
////			PdfPCell cell027criteria4 = new PdfPCell(new Paragraph("Reliance Jio and Stand-alone Dev	ices "));
////			PdfPCell cell028criteria4 = new PdfPCell(new Paragraph("Firewall"));
////			PdfPCell cell029criteria4 = new PdfPCell(new Paragraph("02"));
////			PdfPCell cell030criteria4 = new PdfPCell(new Paragraph("--"));
////			PdfPCell cell031criteria4 = new PdfPCell(new Paragraph("Writing Pads for Online classes"));
////			PdfPCell cell032criteria4 = new PdfPCell(new Paragraph("46"));
////			PdfPCell cell033criteria4 = new PdfPCell(new Paragraph("46 "));
////
////			table1criteria4.addCell(cell01criteria4);
////			table1criteria4.addCell(cell02criteria4);
////			table1criteria4.addCell(cell03criteria4);
////			table1criteria4.addCell(cell04criteria4);
////			table1criteria4.addCell(cell05criteria4);
////			table1criteria4.addCell(cell06criteria4);
////			table1criteria4.addCell(cell07criteria4);
////			table1criteria4.addCell(cell08criteria4);
////			table1criteria4.addCell(cell09criteria4);
////			table1criteria4.addCell(cell010criteria4);
////			table1criteria4.addCell(cell011criteria4);
////			table1criteria4.addCell(cell012criteria4);
////			table1criteria4.addCell(cell013criteria4);
////			table1criteria4.addCell(cell014criteria4);
////			table1criteria4.addCell(cell015criteria4);
////			table1criteria4.addCell(cell016criteria4);
////			table1criteria4.addCell(cell017criteria4);
////			table1criteria4.addCell(cell018criteria4);
////			table1criteria4.addCell(cell019criteria4);
////			table1criteria4.addCell(cell020criteria4);
////			table1criteria4.addCell(cell021criteria4);
////			table1criteria4.addCell(cell022criteria4);
////			table1criteria4.addCell(cell023criteria4);
////			table1criteria4.addCell(cell024criteria4);
////			table1criteria4.addCell(cell025criteria4);
////			table1criteria4.addCell(cell026criteria4);
////			table1criteria4.addCell(cell027criteria4);
////			table1criteria4.addCell(cell028criteria4);
////			table1criteria4.addCell(cell029criteria4);
////			table1criteria4.addCell(cell030criteria4);
////			table1criteria4.addCell(cell031criteria4);
////			table1criteria4.addCell(cell032criteria4);
////			table1criteria4.addCell(cell033criteria4);
////
////			table1criteria4.setSpacingBefore(10f);
////			table1criteria4.setSpacingAfter(20f);
////
////			document.add(table1criteria4);
//
////			Paragraph paragraph12criteria4 = new Paragraph("* 1276 old desktop computers were written off", font5);
////			paragraph12criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			document.add(paragraph12criteria4);
//
//			PdfPTable table2 = new PdfPTable(2);
//			table2.setWidthPercentage(100);
//
//			PdfPCell cell001criteria4 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			table2.addCell(cell001criteria4);
//			PdfPCell cell002criteria4 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table2.addCell(cell002criteria4);
//			PdfPCell cell003criteria4 = new PdfPCell(new Paragraph("Upload Any additional information\r\n\r\n "));
//			
//			table2.addCell(cell003criteria4);
//			
//			if(criteria4file.size() > 0)
//			{
//			PdfPCell cell004criteria4 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table2.addCell(cell004criteria4);
//		}
//			PdfPCell cell005criteria4 = new PdfPCell(new Paragraph("paste link for additional information\r\n\r\n"));
//			PdfPCell cell006criteria4 = new PdfPCell(new Paragraph(""));
//
//			
//			
//		
//			
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
////
//			Paragraph paragraph14criteria4 = new Paragraph("Response:"
//					+ (criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse412()
//							: ""),
//					font3);
//			paragraph14criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
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
//////			document.add(paragraph14criteria4);
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
//
//			// Creating a table of columns
//			PdfPTable table3criteria4 = new PdfPTable(4);
//
//			// Setting width of table, its columns and spacing
////			table3criteria4.setWidthPercentage(100);
////
////			PdfPCell cell101criteria4 = new PdfPCell(new Paragraph("Facility", font3));
////			PdfPCell cell102criteria4 = new PdfPCell(new Paragraph("Year of creation", font3));
////			PdfPCell cell103criteria4 = new PdfPCell(new Paragraph("Area in Sqm", font3));
////			PdfPCell cell104criteria4 = new PdfPCell(new Paragraph(" Year facility enhanced", font3));
////			PdfPCell cell105criteria4 = new PdfPCell(new Paragraph("Volleyball "));
////			PdfPCell cell106criteria4 = new PdfPCell(new Paragraph(" 2005"));
////			PdfPCell cell107criteria4 = new PdfPCell(new Paragraph("162	"));
////			PdfPCell cell108criteria4 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell109 = new PdfPCell(new Paragraph("Basketball"));
////			PdfPCell cell1010 = new PdfPCell(new Paragraph("2005"));
////			PdfPCell cell1011 = new PdfPCell(new Paragraph("436  "));
////			PdfPCell cell1012 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell1013 = new PdfPCell(new Paragraph("Throwball "));
////			PdfPCell cell1014 = new PdfPCell(new Paragraph("	2005 "));
////			PdfPCell cell1015 = new PdfPCell(new Paragraph("	222	"));
////			PdfPCell cell1016 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell1017 = new PdfPCell(new Paragraph("Cricket	"));
////			PdfPCell cell1018 = new PdfPCell(new Paragraph("2005 "));
////			PdfPCell cell1019 = new PdfPCell(new Paragraph("3600 "));
////			PdfPCell cell1020 = new PdfPCell(new Paragraph("2016  "));
////			PdfPCell cell1021 = new PdfPCell(new Paragraph("Kabaddi "));
////			PdfPCell cell1022 = new PdfPCell(new Paragraph("	2005"));
////			PdfPCell cell1023 = new PdfPCell(new Paragraph("130"));
////			PdfPCell cell1024 = new PdfPCell(new Paragraph("2020 "));
////			PdfPCell cell1025 = new PdfPCell(new Paragraph("Cricket-net practice"));
////			PdfPCell cell1026 = new PdfPCell(new Paragraph("2020 "));
////			PdfPCell cell1027 = new PdfPCell(new Paragraph("74 "));
////			PdfPCell cell1028 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell1029 = new PdfPCell(new Paragraph("Indoor Sports (Carroms Table-Tennis, Chess etc.)"));
////			PdfPCell cell1030 = new PdfPCell(new Paragraph("2005 "));
////			PdfPCell cell1031 = new PdfPCell(new Paragraph("219"));
////			PdfPCell cell1032 = new PdfPCell(new Paragraph("2020"));
////			PdfPCell cell1033 = new PdfPCell(new Paragraph("Yoga center"));
////			PdfPCell cell1034 = new PdfPCell(new Paragraph("2016 "));
////			PdfPCell cell1035 = new PdfPCell(new Paragraph("89 "));
////			PdfPCell cell1036 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell1037 = new PdfPCell(new Paragraph("Open-air Auditorium	"));
////			PdfPCell cell1038 = new PdfPCell(new Paragraph("2005 "));
////			PdfPCell cell1039 = new PdfPCell(new Paragraph("3310  "));
////			PdfPCell cell1040 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell1041 = new PdfPCell(new Paragraph("Block -1 (II-floor) Air conditioned Seminar Hall)"));
////			PdfPCell cell1042 = new PdfPCell(new Paragraph("	2006 "));
////			PdfPCell cell1043 = new PdfPCell(new Paragraph("263	 "));
////			PdfPCell cell1044 = new PdfPCell(new Paragraph("	2019 (Modernized) "));
////			PdfPCell cell1045 = new PdfPCell(new Paragraph("Auditorium Air-conditioned"));
////			PdfPCell cell1046 = new PdfPCell(new Paragraph("2019 "));
////			PdfPCell cell1047 = new PdfPCell(new Paragraph("287 "));
////			PdfPCell cell1048 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell1049 = new PdfPCell(new Paragraph("Block -3 Seminar Hall "));
////			PdfPCell cell1050 = new PdfPCell(new Paragraph("2018 "));
////			PdfPCell cell1051 = new PdfPCell(new Paragraph("	137"));
////			PdfPCell cell1052 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell1053 = new PdfPCell(new Paragraph("Foot Ball Ground"));
////			PdfPCell cell1054 = new PdfPCell(new Paragraph("2005 "));
////			PdfPCell cell1055 = new PdfPCell(new Paragraph("	4050 "));
////			PdfPCell cell1056 = new PdfPCell(new Paragraph("2020 "));
////
////			table3criteria4.addCell(cell101criteria4);
////			table3criteria4.addCell(cell102criteria4);
////			table3criteria4.addCell(cell103criteria4);
////			table3criteria4.addCell(cell104criteria4);
////			table3criteria4.addCell(cell105criteria4);
////			table3criteria4.addCell(cell106criteria4);
////			table3criteria4.addCell(cell107criteria4);
////			table3criteria4.addCell(cell108criteria4);
////			table3criteria4.addCell(cell109);
////			table3criteria4.addCell(cell1010);
////			table3criteria4.addCell(cell1011);
////			table3criteria4.addCell(cell1012);
////			table3criteria4.addCell(cell1013);
////			table3criteria4.addCell(cell1014);
////			table3criteria4.addCell(cell1015);
////			table3criteria4.addCell(cell1016);
////			table3criteria4.addCell(cell1017);
////			table3criteria4.addCell(cell1018);
////			table3criteria4.addCell(cell1019);
////			table3criteria4.addCell(cell1020);
////			table3criteria4.addCell(cell1021);
////			table3criteria4.addCell(cell1022);
////			table3criteria4.addCell(cell1023);
////			table3criteria4.addCell(cell1024);
////			table3criteria4.addCell(cell1025);
////			table3criteria4.addCell(cell1026);
////			table3criteria4.addCell(cell1027);
////			table3criteria4.addCell(cell1028);
////			table3criteria4.addCell(cell1029);
////			table3criteria4.addCell(cell1030);
////			table3criteria4.addCell(cell1031);
////			table3criteria4.addCell(cell1032);
////			table3criteria4.addCell(cell1033);
////			table3criteria4.addCell(cell1034);
////			table3criteria4.addCell(cell1035);
////			table3criteria4.addCell(cell1036);
////			table3criteria4.addCell(cell1037);
////			table3criteria4.addCell(cell1038);
////			table3criteria4.addCell(cell1039);
////			table3criteria4.addCell(cell1040);
////			table3criteria4.addCell(cell1041);
////			table3criteria4.addCell(cell1042);
////			table3criteria4.addCell(cell1043);
////			table3criteria4.addCell(cell1044);
////			table3criteria4.addCell(cell1045);
////			table3criteria4.addCell(cell1046);
////			table3criteria4.addCell(cell1047);
////			table3criteria4.addCell(cell1048);
////			table3criteria4.addCell(cell1049);
////			table3criteria4.addCell(cell1050);
////			table3criteria4.addCell(cell1051);
////			table3criteria4.addCell(cell1052);
////			table3criteria4.addCell(cell1053);
////			table3criteria4.addCell(cell1054);
////			table3criteria4.addCell(cell1055);
////			table3criteria4.addCell(cell1056);
////
////			table3criteria4.setSpacingBefore(20f);
////			table3criteria4.setSpacingAfter(20f);
////
////			document.add(table3criteria4);
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
//			table4criteria4.addCell(cell007);
//			
//			PdfPCell cell008 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table4criteria4.addCell(cell008);
//			PdfPCell cell0009 = new PdfPCell(new Paragraph(" Upload Any additional information\r\n\r\n"));
//			table4criteria4.addCell(cell0009);
//			if(criteria4file.size() >0)
//			{
//			PdfPCell cell0010 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//			table4criteria4.addCell(cell0010);
//			}
//			PdfPCell cell0011 = new PdfPCell(new Paragraph("Geotagged pictures\r\n\r\n"));
//			table4criteria4.addCell(cell0011);
//			if(criteria4file.size() >0)
//			{
//			PdfPCell cell0012 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//			table4criteria4.addCell(cell0012);
//			}
//			PdfPCell cell0013 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			PdfPCell cell0014 = new PdfPCell(new Paragraph(""));
//
//			
//			
//			
//		
//			
//			
//			table4criteria4.addCell(cell0013);
//			table4criteria4.addCell(cell0014);
//
//			PdfPCell cell412criteria4 = new PdfPCell(new Paragraph(
//					"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse412()
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
//			table5criteria4.addCell(cell0015);
//			PdfPCell cell0016 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table5criteria4.addCell(cell0016);
//			PdfPCell cell0017 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n"));
//			table5criteria4.addCell(cell0017);
//			if(criteria4file.size() >0)
//			{
//			PdfPCell cell0018 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table5criteria4.addCell(cell0018);
//			}
////			PdfPCell cell0019 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
////			table5criteria4.addCell(cell0019);
////			if(criteria4file.size() >0)
////			{
////			PdfPCell cell0020 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
////			table5criteria4.addCell(cell0020);
////			}
////			PdfPCell cell0021 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
////			PdfPCell cell0022 = new PdfPCell(new Paragraph());
//
////			table5criteria4.addCell(cell0021);
////			table5criteria4.addCell(cell0022);
//
//			table51.addCell(
//					"4.1.3 Percentage of classrooms and seminar halls with ICT- enabled facilities such as smart class, LMS, etc. (Data for the latest completed academic year)\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse413()
//									: ""));
//
//			table51.addCell("4.1.3.1 Number of classrooms and seminar halls with ICT facilities\r\n" + "\r\n\r\n"
//					+ (criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getInput4131t1() : ""));
//			
//			table51.addCell("4.1.3.12: Number of classrooms and seminar halls in the Institution\r\n" + "\r\n\r\n"
//					+ (criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getInput4131t2() : ""));
//			
//			
//			
//
//		
//			table51.addCell(table5criteria4);
//
//			table51.setSpacingBefore(20f);
//			table51.setSpacingAfter(20f);
//
//			document.add(table51);
//
//			// Creating a table of 3 columns
////			PdfPTable table6criteria4 = new PdfPTable(5);
//		PdfPTable table61criteria4 = new PdfPTable(1);
//		table61criteria4.setWidthPercentage(100);
//		
////
////			// Setting width of table, its columns and spacing
////			table6criteria4.setWidthPercentage(100);
////			
////
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
////
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
//			table61criteria4.addCell(
//					"4.1.4 Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)\r\n"
//							+ "\r\n" + "Response: "
//							+ (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse414()
//									: ""));
//
//			
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
//			if (criteria4Fieldinfo != null) {
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
//			
//
//			if (criteria4Fieldinfo != null) {
//
//				Table table41412 = new Table(criteria4Fieldinfo.getYearTable41412().size(), 2);
//
//				table41412.setPadding(10);
//				table41412.setWidth(100f);
//
//				for (int i = 0; i < criteria4Fieldinfo.getYearTable41412().size(); i++) {
//					table41412.addCell(criteria4Fieldinfo.getYearTable41412().get(i).getInput41412y());
//
//				}
//				for (int i = 0; i < criteria4Fieldinfo.getYearTable41412().size(); i++) {
//					table41412.addCell(criteria4Fieldinfo.getYearTable41412().get(i).getInput41412v());
//
//				}
//
//				document.add(table41412);
//			}
//			
//			
//			
//			
//			
//
//			// Creating a table of 3 columns
//			PdfPTable table7criteria4 = new PdfPTable(2);
//
//			// Setting width of table, its columns and spacing
//			table7criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0033 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
//			table7criteria4.addCell(cell0033);
//			
//			PdfPCell cell0034 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table7criteria4.addCell(cell0034);
//			PdfPCell cell0035 = new PdfPCell(
//					new Paragraph("Upload Details of Expenditure , excluding salary during the last five years\r\n\r\n "));
//			
//			table7criteria4.addCell(cell0035);
//            if(criteria4file.size() >0)
//            {
//			PdfPCell cell0036 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table7criteria4.addCell(cell0036);
//            }
//			PdfPCell cell0037 = new PdfPCell(new Paragraph("Upload audited utilization statements\r\n\r\n"));
//			table7criteria4.addCell(cell0037);
//			 if(criteria4file.size() >0)
//	            {
//			PdfPCell cell0038 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table7criteria4.addCell(cell0038);
//	            }
//			PdfPCell cell0039 = new PdfPCell(new Paragraph(" Link for any additional information\r\n\r\n"));
//			table7criteria4.addCell(cell0039);
//			PdfPCell cell0040 = new PdfPCell(new Paragraph(" "));
//
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
