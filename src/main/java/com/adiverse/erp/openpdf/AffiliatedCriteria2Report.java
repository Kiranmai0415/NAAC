//package com.adiverse.erp.openpdf;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
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
//import com.adiverse.erp.service.Criteria2Service;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.Image;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//@Service
//public class AffiliatedCriteria2Report {
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
//	Criteria2Service service2;
//	
//	
//	List<Criteria2_FieldInfo> criteria2List = null;
//	Criteria2_FieldInfo criteria2Record = null;
//	List<Criteria2_FileUpload> criteria2file = null;
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
//			criteria2List = service2.getAllCriteria2Data();
//			if (CollectionUtils.isNotEmpty(criteria2List)) {
//				criteria2Record = criteria2List.get(0);
//				criteria2file = criteria2Record.getCriteria2FileUpload();
//			} else {
//				criteria2Record = new Criteria2_FieldInfo();
//			}
//			  
//            if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AffilatedCriteria2Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			Document document = new Document(PageSize.A4);
//			// PdfWriter.getInstance(document, response.getOutputStream());
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>");
//			
//			PdfPTable tablecriteria2 = new PdfPTable(1);
//			tablecriteria2.setWidthPercentage(100);
//			PdfPTable table1criteria2 = new PdfPTable(1);
//			table1criteria2.setWidthPercentage(100);
//			PdfPTable table6criteria2 = new PdfPTable(5);
//			table6criteria2.setWidthPercentage(100);
//
////			PdfPTable table7criteria2 = new PdfPTable(2);
////			table7criteria2.setWidthPercentage(100);
//
//
//			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
//			Paragraph paragraph3criteria2 = new Paragraph("2.1 Student Enrollment and Profile\r\n\r\n", font2);
//			Paragraph paragraph300criteria2 = new Paragraph("211 Enrolment percentage\r\n\r\n", font3);
//
//			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			paragraph3criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph2criteria2);
//			document.add(paragraph3criteria2);
//			document.add(paragraph300criteria2);
//			tablecriteria2.setWidthPercentage(100f);
////			tablecriteria2
////					.addCell("2.1.1 Average Enrolment percentage (Average of last five years)\r\n" + "\r\n" + "Response:"
////							+ (criteria2Record != null
////									? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse211()
////									: ""));
////			
////			tablecriteria2
////			.addCell("2.1.1 Average Enrolment percentage (Average of last five years)\r\n" + "\r\n" + "Response:"
////					+ (criteria2Record != null
////							? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput2112t11()
////							: ""));
//	//
//	//	
//			PdfPTable tablecriteria02 = new PdfPTable(1);
//			tablecriteria02.setWidthPercentage(100);
//			
//			 PdfPCell cell001criteria2 = new PdfPCell(new Paragraph(
//						"2.1.1.1 Number of students admitted year-wise during last five years"+ "Response:"
//								+(criteria2Record != null
//							? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse211()
//							: ""),font3));
//			 
//			 tablecriteria02.addCell(cell001criteria2);
//			 
//			 PdfPCell cell002criteria2 = new PdfPCell(new Paragraph(
//						"2.1.1.2 Number of students admitted year-wise during last five years"+ (criteria2Record != null
//							? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput2112t11()
//							: ""),font3));
//			 
//			 tablecriteria02.addCell(cell002criteria2);
//			
//			document.add(tablecriteria02);
//			
//			//YEAR TABLE 2111
//
//			Table table2111 = new Table(criteria2Record.getYearTable2111().size(), 2);
//
//			table2111.setPadding(10);
//			table2111.setWidth(100f);
//
//			for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
//				table2111.addCell(criteria2Record.getYearTable2111().get(i).getInput2111y());
//			}
//			for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
//				table2111.addCell(criteria2Record.getYearTable2111().get(i).getInput2111v());
//			}
//
//			document.add(table2111);
//
//			
//			// YEAR TABLE 2112
//
//			Table table2112 = new Table(criteria2Record.getYearTable2112().size(), 2);
//
//			table2112.setPadding(10);
//			table2112.setWidth(100f);
//
//			for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
//				table2112.addCell(criteria2Record.getYearTable2112().get(i).getInput2112y());
//			}
//			for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
//				table2112.addCell(criteria2Record.getYearTable2112().get(i).getInput2112v());
//			}
//
//			document.add(table2112);
//
//			PdfPTable table3criteria2 = new PdfPTable(2);
//			table3criteria2.setWidthPercentage(100);
//	        table3criteria2.setWidths(new int[] { 3, 3 });
//			table3criteria2.setSpacingBefore(20);
//
//			PdfPCell cell1criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table3criteria2.addCell(cell1criteria2);
//
//			PdfPCell cell2criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table3criteria2.addCell(cell2criteria2);
//
//			PdfPCell cell3criteria2 = new PdfPCell(new Paragraph("Institutional data in prescribed format(Data Template)\r\n+\r\n"));
//			table3criteria2.addCell(cell3criteria2);
//
//			PdfPCell cell4criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : ""));
//			table3criteria2.addCell(cell4criteria2);
//
//			PdfPCell cell5criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n+\r\n"));
//			table3criteria2.addCell(cell5criteria2);
//
//			PdfPCell cell6criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(2).getCriteria2FilePath() : ""));
//			table3criteria2.addCell(cell6criteria2);
//	        document.add(table3criteria2);
//
//		
//
////			table1criteria2.addCell(
////					"2.1.2 Average percentage of seats filled against reserved categories (SC, ST, OBC, Divyangjan, etc. as per applicable reservation policy ) during the last five years ( exclusive of supernumerary seats)\r\n"
////							+ "\r\n" + "\"Response: "
////							+ (criteria2Record != null
////									? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse212()
////									: ""));
//	        
//	        PdfPCell cell0001criteria2 = new PdfPCell(new Paragraph(
//					"2.1.2 Average percentage of seats filled against reserved categories (SC, ST, OBC, Divyangjan etc. as per applicable reservation policy ) during the last five years ( exclusive of supernumerar seats"+ "Response:"
//							+(criteria2Record != null
//					? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse212()
//					: ""),font3));
//	        table3criteria2.addCell(cell0001criteria2);
//	        document.add(table3criteria2);
//			
//			table1criteria2.addCell((criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput2121t21()
//									: ""));
//			
//			
//			
//			
//			table1criteria2.addCell(
//					"2.1.2.1 Number of actual students admitted from the reserved categories year wise during last\r\n"
//					+ "five \r\n"
//							+ "\r\n" + "");
//			
//			table1criteria2.addCell(
//					"2.1.2.1 Number of actual students admitted from the reserved categories year wise during last five \r\n"
//							+ "\r\n" + "");
//			table1criteria2.addCell(table6criteria2);
//			document.add(table1criteria2);
//			
//			
//			
//			
//			
//			//YEAR TABLE 2121
//			
//			
//
//			Table table2121 = new Table(criteria2Record.getYearTable2121().size(), 2);
//
//			table2121.setPadding(10);
//			table2121.setWidth(100f);
//
//			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
//				table2121.addCell(criteria2Record.getYearTable2121().get(i).getInput2121y());
//			}
//			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
//				table2121.addCell(criteria2Record.getYearTable2121().get(i).getInput2121v());
//			}
//
//			document.add(table2121);
//			
//			
//			//Yeartable 2122
//			
//			
//			Table table2122 = new Table(criteria2Record.getYearTable2121().size(), 2);
//
//			table2122.setPadding(10);
//			table2122.setWidth(100f);
//
//			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
//				table2122.addCell(criteria2Record.getYearTable2121().get(i).getInput2121y());
//			}
//			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
//				table2122.addCell(criteria2Record.getYearTable2121().get(i).getInput2121v());
//			}
//
//			document.add(table2122);
//			
//
//			
//			
//			
//			
//
//			
////			table1criteria2.addCell(table6criteria2);
////			document.add(table1criteria2);
//			PdfPTable table7criteria2 = new PdfPTable(2);
//			table7criteria2.setWidthPercentage(100);
//	       table7criteria2.setWidths(new int[] { 3, 3 });
//			
//
//			PdfPCell cell07criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table7criteria2.addCell(cell07criteria2);
//
//			PdfPCell cell08criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table7criteria2.addCell(cell08criteria2);
//
//			PdfPCell cell09criteria2 = new PdfPCell(new Paragraph("Average percentage of seats vfilled against seats reserved\r\n\r\n"));
//			table7criteria2.addCell(cell09criteria2);
//
//			PdfPCell cell10criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : ""));
//			table7criteria2.addCell(cell10criteria2);
//
//			PdfPCell cell11criteria2 = new PdfPCell(new Paragraph(" Additional Information\r\n+\r\n"));
//			table7criteria2.addCell(cell11criteria2);
//
//			PdfPCell cell12criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(4).getCriteria2FilePath() : ""));
//			table7criteria2.addCell(cell12criteria2);
//			
//			table7criteria2.setSpacingAfter(20);
//			table7criteria2.setSpacingBefore(20);
//			document.add(table7criteria2);
//			
//			
//
//			Paragraph paragraph4criteria2 = new Paragraph("2.2 Student Teacher Ratio\r\n\r\n", font3);
//			document.add(paragraph4criteria2);
//			//new table
//			/*Paragraph paragraph4criteria2x = new Paragraph(" The institution assesses the learning levels of the students and organises\r\n"
//					+ "special Programmes for advanced learners and slow learners\r\n\r\n", font3);
//			document.add(paragraph4criteria2x);*/
//			
//			
//
//			PdfPTable table01 = new PdfPTable(1);
//			table01.setWidthPercentage(100f);
//			
//			PdfPCell cell0002criteria2 = new PdfPCell(new Paragraph(
//					"2.2.1 The institution assesses the learning levels of the students and organises\r\n"
//					+ "special Programmes for advanced learners and slow learners),\r\n"
//					+ "Response:"
//							+(criteria2Record != null
//					? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse221()
//					: ""),font3));
//			table01.addCell(cell0002criteria2);
//			document.add(table01);
//			
//			table01.addCell("9Mother Teresa understands that most obvious characteristic of a slow learner, a\r\n"
//					+ "limited attention span compared to other learners. To keep these slow learners actively engaged\r\n"
//					+ "in the learning process, requires more than the usual variation in presentation methods (direct,\r\n"
//					+ "indirect), classroom climate (co-operative, competitive), and instructional materials (videos,\r\n"
//					+ "workbooks, co-operative activities, simulations, etc). Other immediately noticeable characteristics\r\n"
//					+ "of slow learners are their deficiencies in basic skills (reading, writing, and mathematics), difficulty\r\n"
//					+ "in comprehending abstract ideas, and most disconcerting is, unsystematic and less careful work\r\n"
//					+ "habits.\r\n"
//					+ "Keeping these in view, our faculty monitor students performance during regular class activities,\r\n"
//					+ "lab work, tutorials, assignments, mentoring, midterm and results of semester end examinations.\r\n"
//					+ "In addition, of late, we have been administering psychometric tests. Students secured <50% of\r\n"
//					+ "marks in midterm examinations, not able to participate enthusiastically in tutorials, unable to\r\n"
//					+ "submit assignments in time, showing lack of interest with irregular attendance, not coping up with\r\n"
//					+ "laboratory exercises are identified as slow learners. This exercise is carried out course-wise.\r\n"
//					+ "Remedial Teaching: In addition to the regular classroom teaching, remedial teaching is conducted\r\n"
//					+ "for slow learners through the use of activities, techniques and practices to eliminate weaknesses\r\n"
//					+ "or deficiencies that the slow learner is known to have. For example, deficiencies in basic\r\n"
//					+ "mathematical skills are reduced or eliminated by re-teaching the content that was not learned\r\n"
//					+ "earlier. Sub-divide topics by reordering them so that students get multiple exposure of the topics\r\n"
//					+ "facilitating better learning. Conventional instructional techniques such as drill and practice are\r\n"
//					+ "also employed.\r\n"
//					+ "Slow Learners are given separate learning materials through reinforcement of small segments of\r\n"
//					+ "learning and are associated with a peer who is an advanced learner. Further, emphasizing on\r\n"
//					+ "frequent assessment of the student progress, mentoring with close monitoring is conducted,\r\n"
//					+ "parents are informed, is found to be reasonably effective.\r\n"
//					+ "Additionally, based on the content of courses, faculty provide compensatory teaching, use ICT\r\n"
//					+ "methodologies (pictures/animations/videos) and supplements it with additional learning resources\r\n"
//					+ "and activities (through laboratory exercises and simulations, group discussions and co-operative\r\n"
//					+ "learning, mini and major projects by forming a group of students, one each of advanced learner\r\n"
//					+ "and slow learner).\r\n"
//					+ "Advanced learners are encouraged to take up more challenging tasks. They are given additional\r\n"
//					+ "training on value added courses ranging from advanced to highly advanced programming skills,\r\n"
//					+ "Business English\r\n"
//					+ "Certificate, additional training to participate in Hackathons, project exhibitions, facilitating them to\r\n"
//					+ "build prototypes, participate in coding competitions, etc.\r\n"
//					+ "All learners are given training on Logical Reasoning, improving Vocabulary, Verbal Reasoning,\r\n"
//					+ "and Quantitative aptitude, situational writing etc. to get through preliminary test conducted by\r\n"
//					+ "various companies for placements as well as preparation towards CAT/GRE/IELTS/TOEFL and\r\n"
//					+ "other Public Sector Undertakings.\r\n"
//					+ "In addition, 14 student professional bodies and 07 student clubs conducted several co-curricular\r\n"
//					+ "activities wherein, all learners participated, which is a regular exercise.\r\n"
//					+ "All learners are given career guidance, creating awareness on plethora of opportunities in terms\r\n"
//					+ "of medium to highly paid jobs, pursue post-graduation etc");
//			
//			
//			table01.addCell((criteria2Record != null
//					? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput221t1()
//					:""));
//
//			document.add(table01);
//
//			PdfPTable table8criteria2 = new PdfPTable(2);
//
//			table8criteria2.setWidthPercentage(100);
//			table8criteria2.setWidths(new int[] { 3, 3 });
//			table8criteria2.setSpacingBefore(5);
//
//			PdfPCell cell13criteria2 = new PdfPCell(new Paragraph("File Description\r\n+\r\n", font3));
//			table8criteria2.addCell(cell13criteria2);
//
//			PdfPCell cell14criteria2 = new PdfPCell(new Paragraph("Document\r\n+\r\n", font3));
//			table8criteria2.addCell(cell14criteria2);
//
//			PdfPCell cell15criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n+\r\n"));
//			table8criteria2.addCell(cell15criteria2);
//
//			PdfPCell cell16criteria2 = new PdfPCell(new Paragraph("criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : "));
//			table8criteria2.addCell(cell16criteria2);
//			
//			PdfPCell cell17xcriteria2 = new PdfPCell(new Paragraph("Past link for additional Information"));
//			table8criteria2.addCell(cell17xcriteria2);
//
//			PdfPCell cell18xcriteria2 = new PdfPCell(new Paragraph("criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : "));
//			table8criteria2.addCell(cell18xcriteria2);
//			document.add(table8criteria2);
//			
//			//222
//
//			PdfPTable table02 = new PdfPTable(1);
//			table02.setWidthPercentage(100f);
//			table02.addCell("2.2.2   Student- Full time teacher ratio (Data for the latest completed academic year))\r\n"
//					+ "\r\n" + "Response:"
//					+ (criteria2Record != null ? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse222()
//							: ""));
//			
//			table02.addCell((criteria2Record != null ? criteria2Record.getCriteria2FieldInfoQl().get(0).getInput231t1()
//					:"" ));
//			
//			document.add(table02);
//			//231
//
//			PdfPTable table9criteria2 = new PdfPTable(2);
//
//			table9criteria2.setWidthPercentage(100f);
//			table9criteria2.setWidths(new int[] { 3, 3 });
//			table9criteria2.setSpacingBefore(5);
//
//			PdfPCell cell17criteria2 = new PdfPCell(new Paragraph("File Description\r\n", font3));
//			table9criteria2.addCell(cell17criteria2);
//
//			PdfPCell cell18criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table9criteria2.addCell(cell18criteria2);
//
//			PdfPCell cell19criteria2 = new PdfPCell(new Paragraph("Additional Information\r\n\r\n"));
//			table9criteria2.addCell(cell19criteria2);
//
//			PdfPCell cell20criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(5).getCriteria2FilePath() : ""));
//			table9criteria2.addCell(cell20criteria2);
//
//			document.add(table9criteria2);
//			
//			//2.3
//
//			Paragraph paragraph5criteria2 = new Paragraph("2.3	Teaching- Learning Process\r\n\r\n", font3);
//			document.add(paragraph5criteria2);
//
//			PdfPTable table03 = new PdfPTable(1);
//			table03.setWidthPercentage(100f);
//
//			PdfPCell cell001 = new PdfPCell(new Paragraph(
//					"2.3.1 Student centric methods, such as experiential learning, participative learning and problem solving methodologies are used for enhancing learning experiences"
//							+ "\r\n" + "" + "Response:"
//							+ (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQl().get(0).getResponse231()
//									: "")+"Mother Teresa is committed to enhance the learning experience of its students, and follows a rigorous system of student-centric learning methods to inculcate and augment various skills among the students. Curricula of all programs include 30% of practicals, hands-on and activity-oriented courses.\r\n"
//							+ "\r\n"
//							+ "Experiential Learning: The college practices the Learn as you do method of learning through laboratory exercises, mini and major projects, design thinking, activity-oriented courses/internships/industry visits and Hackathons which facilitate the development of Problem-Solving Skills, through Project-Based Learning, in which various abilities such as creative designing of a system, applying an abstract concept or idea to a real-world problem, visualization of product design and realizing it, preparing an appropriate technical report and presenting it to a technical audience are achieved.\r\n"
//							+ "\r\n"
//							+ "In a few cases (02), emanating from such experiential learning, prototypes were developed by students and submitted for patenting or published as a patent. In few other cases (20), the ideations and applications\r\n"
//							+ "were presented at Hackathons, which have won them laurels and awards/prizes (17). Every year, projects are exhibited at Exhibitions organized by the college and elsewhere, wherein, invited industry experts assess and identify some as suitable for product development, and reward them (03).\r\n"
//							+ "\r\n"
//							+ "Collaborative and Cooperative Learning is facilitated through peers wherein students discuss ideas with classmates, engage in subject-specific discussions and get feedback from classmates thereby augmenting mutual teaching-learning, assimilating multiple views to deepen the knowledge, promoting critical thinking and mitigating learner isolation. This has also led to inculcating effective teamwork and communication (including interpersonal and cross-cultural awareness), skills fostering individual accountability within the team, resulting in developing independent learning strategies.\r\n"
//							+ "\r\n"
//							+ "Group and participative learning towards development of Professional Competencies:\r\n"
//							+ "\r\n"
//							+ "Students take up course-based group projects, discuss ideas and develop ways to solve identified problems for specific applications, develop prototypes for further recognition and incentivization.\r\n"
//							+ "\r\n"
//							+ "Students discuss topics on emerging trends, innovative business ideas, prepare technical articles, business reports, present them at seminars/symposia. This promotes students� sensitivity towards the feelings of other team members in the group, help to develop listening skills, to be open to others� ideas, and look for opportunities to work collaboratively thus adding value to their profession and person, both, academically and socially.\r\n"
//							+ "\r\n"
//							+ "Learning through value added courses: Students develop hands on skills on advanced/emerging tools gaining adequate exposure to modern tool usage. During the last five years 43 value added courses have been offered and 5437 students have been the beneficiaries.\r\n"
//							+ "\r\n"
//							+ "Interactions with various external experts: Students are exposed to elite Guest Lectures, Industrial Visits, and Field trips, making them familiar with occupational environment, develop an ability to understand: what engineers do, the language and process of engineering design, and its economical aspects. They also understand the non-technical yet essential other side of engineering: its importance and impact on societal development and environmental issues for sustainability.\r\n"
//							+ "\r\n"
//							+ "Aside of the above, during the last five years, our students have taken up several Massive Open Online Courses (MOOCS) and such others (776).\r\n"
//							+ "\r\n" + "\r\n" + "",font3));
//
//			table03.addCell(cell001);
//			
//			
//			table03.addCell((criteria2Record != null
//					? criteria2Record.getCriteria2FieldInfoQl().get(0).getInput231t1()
//					:""));
//			
//			document.add(table03);
//
//			PdfPTable table10criteria2 = new PdfPTable(2);
//
//			table10criteria2.setWidthPercentage(100f);
//			table10criteria2.setWidths(new int[] { 3, 3 });
//			table10criteria2.setSpacingBefore(5);
//
//			PdfPCell cell21criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table10criteria2.addCell(cell21criteria2);
//
//			PdfPCell cell22criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table10criteria2.addCell(cell22criteria2);
//
//			PdfPCell cell23criteria2 = new PdfPCell(new Paragraph("Upload for any Additional Information\r\n\r\n"));
//			table10criteria2.addCell(cell23criteria2);
//
//			PdfPCell cell24criteria2 = new PdfPCell(new Paragraph( criteria2Record != null ? criteria2file.get(6).getCriteria2FilePath() : ""));
//			table10criteria2.addCell(cell24criteria2);
//			
//			PdfPCell cell23xcriteria2 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n"));
//			table10criteria2.addCell(cell23xcriteria2);
//
//			PdfPCell cell24xcriteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(7).getCriteria2FilePath() :  ""));
//			table10criteria2.addCell(cell24xcriteria2);
//			document.add(table10criteria2);
//			
//			
//			//2.3.2
//
//			PdfPTable table04 = new PdfPTable(1);
//			table04.setWidthPercentage(100f);
//
//			PdfPCell cell002 = new PdfPCell(new Paragraph(
//					"2.3.2 Teachers use ICT enabled tools including online resources for effective teaching and learning process."
//							+ "" + "Response:"
//							+ (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQl().get(0).getResponse232()
//									: "")
//							+ "Faculty at Mother Teresa use appropriate ICT-enabled tools for effective teaching-learning and evaluation processes in the following ways: "
//							+ "ICT-enabled tools used for Teaching-Learning:\r\n" + "\r\n"
//							+ "Our faculty is quite savvy with the use of ICT-enabled tools for Classroom teaching-learning practices. Using Digital writing pads, preparing relevant power point presentations and videos, augment student learning experiences. Real time simulation exercises and virtual lab exercises adopted by teachers help in student-friendly demonstrations of complex concepts so that students comprehend/demystify them with ease and are able to understand the nuances of the exercises better. Such efforts have borne fruit in terms of not only better understanding by the Learners but also enhanced their long-term knowledge retention abilities. Students and Faculty have unlimited access to the institutional Wi-Fi network and digital library, for protracted ICT-enabled teaching-learning.\r\n"
//							+ "\r\n"
//							+ "Apart from the above-mentioned classroom and laboratory practices, our teachers are proficient in engaging the students through virtual modes using several platforms such as Google Suite, GoToMeeting, Microsoft Teams, Zoom and Cisco Webex. Need-based online teaching-learning practices which was mandated during the recent pandemics has now become a dual mode of teaching-learning apart from regular classroom practices. Guest lectures, Remedial classes, value added courses, orientation/induction programs, and a few virtual industry visits (held only during the pandemic), has widened the academic horizon of both the faculty and the students.\r\n"
//							+ "\r\n"
//							+ "WhatsApp/Telegram groups, Gmail groups, and email groups with Mother Teresa�s domain name have been shared amongst the faculty and students, to ensure interactive and collaborative work as also exchange of content between teachers and students. Such interactive sessions are closely monitored by the respective mentors, for surety of academic exchanges and discussions.\r\n"
//							+ "\r\n"
//							+ "Learners have been able to get an opportunity to work on live projects with other learners in and beyond/outside the college, interact with experts from other Institutions/organizations, resulting in not only a qualitative improvement of the Teaching�Learning Process but also ushering an awareness and abilities for collaborative working and mitigating learner isolation.\r\n"
//							+ "\r\n" + "Use of ICT in Remedial Teaching\r\n" + "\r\n"
//							+ "Remedial Teaching using ICT through video lectures (144) prepared by teachers, facilitates flexibility to learners to learn at their own pace and seek help from the teacher as and when required. URLs of animated videos and faculty lectures captured are uploaded onto YouTube (144).\r\n"
//							+ "\r\n"
//							+ "Use of ICT in Evaluation has facilitated quicker assessment and feedback within a short duration of administering the tests/examinations.\r\n"
//							+ "\r\n"
//							+ "Virtual Laboratories available on MHRD website, extensively used both by teachers and students provides better insight, experience and real time value addition to the academics, especially while studying the influence of a variable or a component on the performance of a system.\r\n"
//							+ "\r\n"
//							+ "Use of ICT for enhancing soft skills among students through video lectures, remote live sessions on programming skills, value added courses, aptitude skills (Quantitative, logical, reading comprehension, vocabulary, situational writing etc.) has enhanced their Thinking and Reasoning, improved comprehension capabilities, speed of reading and vocabulary, thus helping in their career progression and employability.\r\n"
//							+ "\r\n"));
//			
//		
//
//			table04.addCell(cell002);
//
//			document.add(table04);
//
//			PdfPTable table11criteria2 = new PdfPTable(2);
//
//			table11criteria2.setWidthPercentage(100f);
//			table11criteria2.setWidths(new int[] { 3, 3 });
//			table11criteria2.setSpacingBefore(5);
//
//			PdfPCell cell25criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table11criteria2.addCell(cell25criteria2);
//
//			PdfPCell cell26criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table11criteria2.addCell(cell26criteria2);
//
//			PdfPCell cell27criteria2 = new PdfPCell(new Paragraph(
//					"Provide link for webpage describing ICT enabled tools including online resources for effective teaching and learning process"));
//			table11criteria2.addCell(cell27criteria2);
//
//			PdfPCell cell28criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(8).getCriteria2FilePath() : ""));
//			table11criteria2.addCell(cell28criteria2);
//
//			PdfPCell cell29criteria2 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n", font3));
//			table11criteria2.addCell(cell29criteria2);
//
//			PdfPCell cell30criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(9).getCriteria2FilePath() : ""));
//			table11criteria2.addCell(cell30criteria2);
//			table11criteria2.addCell(cell27criteria2);
//			document.add(table11criteria2);
//			
//			//233
//			
//			
//
//			PdfPTable table05 = new PdfPTable(1);
//			table05.setWidthPercentage(100f);
//
//			table05.addCell(
//					"2.3.3 Ratio of students to mentor for academic and other related issues (Data for the latest completed academic year )\r\n"
//							+ "\r\n" + "\"Response:"
//							+ (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse233()
//									: ""));
//
//			table05.addCell("2.3.3.1 Number of mentors \r\n" + "\r\n" + "Response:"
//					+ (criteria2Record != null ? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput2331t1() : ""));
//
//			document.add(table05);
//
//			PdfPTable table13criteria2 = new PdfPTable(2);
//
//			table13criteria2.setWidthPercentage(100f);
//			table13criteria2.setWidths(new int[] { 3, 3 });
//			table13criteria2.setSpacingBefore(20);
//
//			PdfPCell cell31criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table13criteria2.addCell(cell31criteria2);
//
//			PdfPCell cell32criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table13criteria2.addCell(cell32criteria2);
//
//			PdfPCell cell33criteria2 = new PdfPCell(
//					new Paragraph("Upload year wise, number of students enrolled and full time teachers on roll\r\n\r\n"));
//			table13criteria2.addCell(cell33criteria2);
//
//			PdfPCell cell34criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(10).getCriteria2FilePath() : ""));
//			table13criteria2.addCell(cell34criteria2);
//
//			PdfPCell cell35criteria2 = new PdfPCell(new Paragraph(" mentors to mentees ratio\r\n\r\n"));
//			table13criteria2.addCell(cell35criteria2);
//
//			PdfPCell cell36criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(11).getCriteria2FilePath() : ""));
//			table13criteria2.addCell(cell36criteria2);
//
//			PdfPCell cell37criteria2 = new PdfPCell(new Paragraph("Circulars pertaining to assigning mentors to mentees \r\n\r\n"));
//			table13criteria2.addCell(cell37criteria2);
//
//			PdfPCell cell38criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(12).getCriteria2FilePath() : ""));
//			table13criteria2.addCell(cell38criteria2);
//
//			document.add(table13criteria2);
//		
//			
//			// 2.4
//
//			Paragraph paragraph6criteria2 = new Paragraph(" 2.4 Teacher Profile and Quality\r\n\r\n", font2);
//
//			paragraph6criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph6criteria2);
//
//			PdfPTable table07 = new PdfPTable(1);
//			table07.setWidthPercentage(100f);
//
//			PdfPCell cell004 = new PdfPCell(new Paragraph(
//					"2.4.1 Average percentage of full time teachers against sanctioned posts during the last five years"
//							+ "\r\n" + "" + "Response:"
//							+ (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse241()
//									: ""),
//					font3));
//			
//
//			PdfPCell cell0004 = new PdfPCell(new Paragraph(
//					 (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput241t21()
//									: ""),
//					font3));
//			
//			
//			table07.addCell(cell004);
//			table07.addCell(cell0004);
//			document.add(table07);
//			
//			//YEAR TABLE 2411
////			Table table2411 = new Table(criteria2Record.getYearTable2411().size(), 2);
//	//
////			table2411.setPadding(10);
////			table2411.setWidth(100f);
//	//
////			for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
////				table2411.addCell(criteria2Record.getYearTable2411().get(i).getInput2411y());
////			}
////			for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
////				table2411.addCell(criteria2Record.getYearTable2411().get(i).getInput2411v());
////			}
////			document.add(table2411);
//
//			
//			
//			
//
//			PdfPTable table14 = new PdfPTable(2);
//
//			table14.setWidthPercentage(100f);
//			table14.setWidths(new int[] { 3, 3 });
//			table14.setSpacingBefore(5);
//
//			PdfPCell cell43 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table14.addCell(cell43);
//
//			PdfPCell cell44 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table14.addCell(cell44);
//
//			PdfPCell cell45 = new PdfPCell(
//					new Paragraph("Year wise full time teachers and sanctioned posts for 5 years(Data Template)\r\n\r\n"));
//			table14.addCell(cell45);
//
//			PdfPCell cell46 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(13).getCriteria2FilePath() : ""));
//			table14.addCell(cell46);
//
//			PdfPCell cell47 = new PdfPCell(new Paragraph("List of the faculty members authenticated by the Head of HEI\r\n\r\n"));
//			table14.addCell(cell47);
//
//			PdfPCell cell48 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(14).getCriteria2FilePath() : ""));
//			table14.addCell(cell48);
//
//			PdfPCell cell49 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n"));
//			table14.addCell(cell49);
//
//			PdfPCell cell50 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(15).getCriteria2FilePath() : ""));
//			table14.addCell(cell50);
//
//			document.add(table14);
//			
//			//242
//
//			PdfPTable table08 = new PdfPTable(1);
//			table08.setWidthPercentage(100f);
//
//			PdfPCell cell005 = new PdfPCell(new Paragraph(
//					"2.4.2 Average percentage of full time teachers with Ph. D. / D.M. / M.Ch. / D.N.B Superspeciality / D.Sc. / D.Litt. during the last five years (consider only highest degree for count)"
//							+ "\r\n" + "" + "" + "Response:"
//							+ (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse242()
//									: ""),
//					font3));
//			
//			
//			
//			PdfPCell cell0005 = new PdfPCell(new Paragraph(
//					 (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput2421t21()
//									: ""),
//					font3));
//
//			table08.addCell(cell005);
//			table08.addCell(cell0005);
//			document.add(table08);
//
//			table08.addCell(
//					" 2.4.2.1 Number of full time teachers with Ph.D./D.M/M.Ch./D.N.B Superspeciality/D.Sc./D�Lit. year wise during the last five years\r\n"
//							+ "\r\n" + " ");
//			
//			//YEAR TABLE 2421
//
//			Table table2421 = new Table(criteria2Record.getYearTable2421().size(), 2);
//
//			table2421.setPadding(10);
//			table2421.setWidth(100f);
//
//			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
//				table2421.addCell(criteria2Record.getYearTable2421().get(i).getInput2421y());
//			}
//			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
//				table2421.addCell(criteria2Record.getYearTable2421().get(i).getInput2421v());
//			}
//
//			document.add(table2421);
//
//
//			PdfPTable table17 = new PdfPTable(2);
//
//			table17.setWidthPercentage(100f);
//			table17.setWidths(new int[] { 3, 3 });
//			table17.setSpacingBefore(5);
//
//			PdfPCell cell51 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table17.addCell(cell51);
//
//			PdfPCell cell52 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table17.addCell(cell52);
//
//			PdfPCell cell53 = new PdfPCell(new Paragraph("List of number of full time teachers with Ph. D. /\r\n"
//					+ "D.M. / M.Ch. / D.N.B Superspeciality / D.Sc. /\r\n"
//					+ "D.Litt. and number of full time teachers for 5 years\r\n"
//					+ "(Data Template)\r\n\r\n"));
//			table17.addCell(cell53);
//
//			PdfPCell cell54 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(16).getCriteria2FilePath() : ""));
//			table17.addCell(cell54);
//
//			PdfPCell cell55 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			table17.addCell(cell55);
//
//			PdfPCell cell56 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(17).getCriteria2FilePath() : ""));
//			table17.addCell(cell56);
//
//			document.add(table17);
//			
//			//2.4.3
//
//			PdfPTable table20 = new PdfPTable(1);
//			table20.setWidthPercentage(100f);
//
//			PdfPCell cell009 = new PdfPCell(new Paragraph(
//					"2.4.3 Average teaching experience of full time teachers in the same institution (Data for the latest completed academic year in number of years)"
//							+ "\r\n" + "" + "" + "Response:"
//							+ (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse243()
//									: ""),
//					font3));
//
//			table20.addCell(cell009);
//
//			table20.addCell(" 2.4.3.1 Total experience of full-time teachers\r\n" + "\r\n" + " " + "Response:"
//					+ (criteria2Record != null ? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput2431t1() : ""));
//
//			document.add(table20);
//
//			PdfPTable table21 = new PdfPTable(2);
//
//			table21.setWidthPercentage(100f);
//			table21.setWidths(new int[] { 3, 3 });
//			table21.setSpacingBefore(5);
//
//			PdfPCell cell61 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table21.addCell(cell61);
//
//			PdfPCell cell62 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table21.addCell(cell62);
//
//			PdfPCell cell63 = new PdfPCell(new Paragraph("List of Teachers including their PAN, designation,\r\n"
//					+ "dept and experience details(Data Template)\r\n\r\n"));
//			table21.addCell(cell63);
//
//			PdfPCell cell64 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(18).getCriteria2FilePath() : ""));
//			table21.addCell(cell64);
//
//			PdfPCell cell65 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			table21.addCell(cell65);
//
//			PdfPCell cell66 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(19).getCriteria2FilePath() : ""));
//			table21.addCell(cell66);
//
//
//			document.add(table21);
//			
//			//2.5
//
//			Paragraph paragraph7criteria2 = new Paragraph("2.5	Evaluation Process and Reforms\r\n\r\n", font3);
//
//			paragraph7criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph7criteria2);
//
//			PdfPTable table22 = new PdfPTable(1);
//			table22.setWidthPercentage(100f);
//
//			PdfPCell cell010 = new PdfPCell(new Paragraph(
//					"2.5.1  Mechanism of internal assessment is transparent and robust in terms of frequency and modE"
//							+ "\r\n" + "Response:"
//							+ (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQl().get(0).getResponseValue251()
//									: ""),
//					font3));
//
//			PdfPCell cell0010 = new PdfPCell(new Paragraph(
//				 (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQl().get(0).getInput251t1()
//									: ""),
//					font3));
//			
//			
//
//			table22.addCell(cell010);
//			table22.addCell(cell0010);
//			
//
//			table22.addCell(
//					"2.5.1.1 Number of days from the date of last semester-end/ year- end examination till the declaration of results year wise during the last five years\r\n"
//							+ "\r\n" + " ");
//			 document.add(table22);
//
//			/*Table table2511 = new Table(criteria2Record.getYearTable2511().size(), 2);
//
//			table2511.setPadding(10);
//			table2511.setWidth(100f);
//
//			for (int i = 0; i < criteria2Record.getYearTable2511().size(); i++) {
//				table2511.addCell(criteria2Record.getYearTable2511().get(i).getInput2511y());
//			}
//			for (int i = 0; i < criteria2Record.getYearTable2511().size(); i++) {
//				table2511.addCell(criteria2Record.getYearTable2511().get(i).getInput2511v());
//			}
//
//			document.add(table2511);*/
//
//
//			PdfPTable table24 = new PdfPTable(2);
//
//			table24.setWidthPercentage(100f);
//			table24.setWidths(new int[] { 3, 3 });
//			table24.setSpacingBefore(20);
//
//			PdfPCell cell69criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table24.addCell(cell69criteria2);
//
//			PdfPCell cell70criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table24.addCell(cell70criteria2);
//
//			PdfPCell cell71criteria2 = new PdfPCell(
//					new Paragraph("Any additional information\r\n\r\n"));
//			table24.addCell(cell71criteria2);
//
//			PdfPCell cell72criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(20).getCriteria2FilePath() : ""));
//			table24.addCell(cell72criteria2);
//
//			PdfPCell cell73criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
//			table24.addCell(cell73criteria2);
//
//			PdfPCell cell74criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(21).getCriteria2FilePath() : ""));
//			table24.addCell(cell74criteria2);
//
//			document.add(table24);
//			
//			// 252
//
//			PdfPTable table09 = new PdfPTable(1);
//			table09.setWidthPercentage(100f);
//
//			PdfPCell cell006 = new PdfPCell(new Paragraph(
//					"2.5.2  Mechanism to deal with internal/external examination related grievances is transparent, timebound and efficie"
//							+ "\r\n" + "" + "" + "Response:"
//							+ (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse252()
//									: ""),
//					font3));
//
//			table09.addCell(cell006);
//
//			/*table09.addCell(
//					"2.5.2.1 Number of complaints/grievances about evaluation year wise during the last five years\r\n"
//							+ "\r\n" + " ");*/
//
//		/*	Table table2521 = new Table(criteria2Record.getYearTable2521().size(), 2);
//
//			table2521.setPadding(10);
//			table2521.setWidth(100f);
//
//			for (int i = 0; i < criteria2Record.getYearTable2521().size(); i++) {
//				table2521.addCell(criteria2Record.getYearTable2521().get(i).getInput2521y());
//			}
//			for (int i = 0; i < criteria2Record.getYearTable2521().size(); i++) {
//				table2521.addCell(criteria2Record.getYearTable2521().get(i).getInput2521v());
//			}
//
//			document.add(table2521);*/
//
//			/*
//			 * PdfPTable table19= new PdfPTable(5); table19.setWidthPercentage(100f);
//			 * table19.setWidths(new int[] {3, 3, 3, 3, 3}); table19.setSpacingBefore(5);
//			 * 
//			 * 
//			 * cell.setPhrase(new Phrase("    ")); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell);
//			 * 
//			 * table09.addCell(table19);
//			 * 
//			 * 
//			 * document.add(table09);
//			 */
//
//			PdfPTable table18 = new PdfPTable(2);
//
//			table18.setWidthPercentage(100f);
//			table18.setWidths(new int[] { 3, 3 });
//			table18.setSpacingBefore(5);
//
//			PdfPCell cell57 = new PdfPCell(new Paragraph("File Description", font3));
//			table18.addCell(cell57);
//
//			PdfPCell cell58 = new PdfPCell(new Paragraph("Document", font3));
//			table18.addCell(cell58);
//
//			PdfPCell cell59 = new PdfPCell(
//					new Paragraph("Any additional information"));
//			table18.addCell(cell59);
//
//			PdfPCell cell60 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(22).getCriteria2FilePath() : ""));
//			table18.addCell(cell60);
//			PdfPCell cell59X = new PdfPCell(
//					new Paragraph("Link for additional information"));
//			table18.addCell(cell59X);
//
//			PdfPCell cell60X = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(23).getCriteria2FilePath() : ""));
//			table18.addCell(cell60X);
//			document.add(table18);
//			
//
//			PdfPTable table25 = new PdfPTable(1);
//			table25.setWidthPercentage(100f);
//
//			PdfPCell cell011 = new PdfPCell(new Paragraph(
//					"2.5.3 IT integration and reforms in the examination procedures and processes including Continuous Internal Assessment (CIA) have brought in considerable improvement in Examination Management System (EMS) of the Institution"
//							+ "\r\n" + "" + "" + "Response:"
//							+ (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQl().get(0).getResponse253()
//									: "")
//							+ "\r\n" + ""
//							+ "Mother Teresa has adopted a comprehensive EMS facilitated through IT integration and backed by a state-of-the-art hardware and software systems. This has tremendously reformed the examination procedures and processes including the CIA."
//
//					, font5));
//
//			table25.addCell(cell011);
//
//			table25.addCell(
//					"As per the academic calendar exam branch issues notifications related to Midterm examinations, Semester end examinations through college portal, WhatsApp groups and group mail.\r\n"
//							+ "\r\n" + "The following operations pertaining to conduct of examinations are automated\r\n"
//							+ "\r\n" + "Comprehensive student profile database\r\n"
//							+ "Sending appointment orders to external examiners\r\n"
//							+ "Student registrations for semester end (Regular & Supplementary) examinations Generation of hall tickets\r\n"
//							+ "Student seating plan generation\r\n"
//							+ "Barcoded answer booklet generation and printing with student photo and signature for end semester exams\r\n"
//							+ "Attendance sheet generation\r\n" + "Scanning, coding and decoding of answer booklets\r\n"
//							+ "Digital evaluation facilitating remote evaluation for both CIE and SEE\r\n"
//							+ "Result processing (with built-in Grafting and Moderation as per affiliating university guidelines) Publication of results\r\n"
//							+ "Generation of\r\n"
//							+ "Memorandum of marks with SGPA and intermittent CGPA up to the end of corresponding semester\r\n"
//							+ "Consolidated memorandum of marks with SGPA and CGPA Provisional Certificate with student photo\r\n"
//							+ "Transcripts\r\n" + "Result analysis, branch wise, year wise, course wise and overall\r\n"
//							+ "\r\n" + "Examination Procedure\r\n" + "\r\n"
//							+ "Midterm examinations: Two midterm examinations and one make-up test are conducted For each theory course there is an internal evaluation for 30 marks.\r\n"
//							+ "Reforms in midterm examination:\r\n" + "\r\n"
//							+ "1.Two sets of question papers, are set by a team of internal examiners, headed by the course coordinator. The question paper is then evaluated by a department question paper evaluation committee comprising senior faculty members of the department and a member from other department to verify whether\r\n"
//							+ "The question paper tests student�s higher order thinking skills, wherever feasible Balanced question paper covering all outcomes is given\r\n"
//							+ "Question paper is adhering to various levels of Bloom�s taxonomy, with more questions pertaining to higher levels for third and final year courses, and lesser number of questions for second and first year courses.\r\n"
//							+ "\r\n"
//							+ "Proforma for evaluating quality of the question paper in midterm examination is enclosed as additional document.\r\n"
//							+ "\r\n"
//							+ "Semester End Examination: Panel of examiners for preparation of question papers and evaluation of the answer scripts, chosen from various autonomous colleges and universities of repute, duly approved by the\r\n"
//							+ " \r\n" + "Board of studies of the concerned department.\r\n" + "\r\n"
//							+ "Guidelines are given to examiners with regard to the levels of Bloom�s taxonomy that shall be used in the preparation of question papers.\r\n"
//							+ "\r\n"
//							+ "Examiners are also provided the syllabus copy along with the structure of the question paper. Multiple question papers are elicited and the best question paper in terms of adherence to quality, higher order thinking levels and highly balanced one is selected for the examination purpose through scrutiny of the Question paper which shall be carried out by the Chairperson of Board of Studies, along with a senior faculty member/chief examiner (subject expert/course coordinator).\r\n"
//							+ "\r\n" + "Evaluation:\r\n" + "\r\n"
//							+ "1.	For the purpose of evaluation of semester end examination answer books, evaluators who have taught the course for a minimum of 5 times are invited and chief examiner conducts a meeting with them, explains scheme of evaluation.\r\n"
//							+ "2.	The chief examiner randomly verifies at least ten percent of the evaluated answer books for consistency and correctness of evaluation, choosing a third each from the ten percent of the highest, moderately and least scored respectively. If the chief examiner is not satisfied with the evaluation methodology adopted by the evaluator, another 10% of the scripts are again evaluated by the chief examiner in manner similar described above. If the chief examiner is still not satisfied with the evaluation, the matter is escalated to the controller of examinations for further action. The controller of examinations shall then arrange re-evaluation of the scripts either by the same evaluator or a different evaluator.\r\n"
//							+ "3.	No evaluator shall be given more than a bundle (60 answer booklets) in a day.\r\n"
//							+ "\r\n"
//							+ "All the above reforms have resulted in improving quality of the examination system, ensuring confidentiality in evaluation and bringing transparency in the process.\r\n"
//							+ "");
//
//			document.add(table25);
//			
//			
//
//			PdfPTable table26 = new PdfPTable(2);
//
//			table26.setWidthPercentage(100f);
//			table26.setWidths(new int[] { 3, 3 });
//			table26.setSpacingBefore(5);
//
//			PdfPCell cell75criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table26.addCell(cell75criteria2);
//
//			PdfPCell cell76criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table26.addCell(cell76criteria2);
//
//			PdfPCell cell77criteria2 = new PdfPCell(
//					new Paragraph("Number of complaints and total number of students appeared year wise\r\n\r\n"));
//			table26.addCell(cell77criteria2);
//
//			PdfPCell cell78criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(24).getCriteria2FilePath() : ""));
//			table26.addCell(cell78criteria2);
//
//			document.add(table26);
//			
//			//26
//			
//
//			Paragraph paragraph8criteria2 = new Paragraph("2.6 Student Performance and Learning Outcome\r\r\n\n", font2);
//
//			paragraph8criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph8criteria2);
//
//			PdfPTable table27 = new PdfPTable(1);
//			table27.setWidthPercentage(100f);
//
//			PdfPCell cell012 = new PdfPCell(new Paragraph(
//					"2.6.1 Programme and course outcomes for all Programmes offered by the institution are stated and displayed on website and communicated to teachers and students.Mothertherisa has adequate measures to communicate the COs, both to the teachers and students well in time ahead of the beginning of the Course work, in the following manner:"
//							+ "\r\n" + "" + "Response:"
//							+ (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQl().get(0).getResponse261()
//									: ""),font3));
//			
//			
//			PdfPCell cell0012 = new PdfPCell(new Paragraph(
//					 (criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQl().get(0).getInput261t1()
//									: "")));
//			
//			
//			
//
//			table27.addCell(cell012);
//
//			table27.addCell(cell0012);
//			
//
//			table27.addCell("Following are sample Course Outcomes of UG program of each department:\r\n" + "\r\n"
//					+ "1.	B. Tech Civil Engineering and B. Tech Mechanical Engineering:\r\n" + "\r\n"
//					+ "Course: Engineering Mechanics-I\r\n" + "\r\n"
//					+ "1.	Describe position, forces, and moments in terms of vector notation in two and three dimensions.\r\n"
//					+ "2.	Draw free body diagrams accurately and write appropriate equilibrium equations from the free body diagram, including support reactions.\r\n"
//					+ "3.	Apply concepts of equilibrium to analyse systems that include frictional forces.\r\n"
//					+ "4.	Calculate centroids and centres of mass for discrete particles.\r\n"
//					+ "5.	Calculate moments of Inertia for standard sections and composite sections.\r\n" + "\r\n"
//					+ "2.	B. Tech Electrical and Electronics Engineering and B. Tech Electronics and Communication Engineering\r\n"
//					+ "\r\n" + "Course: Digital Design\r\n" + "\r\n"
//					+ "CO1. Perform conversions from one number system to another.\r\n" + "\r\n" + "\r\n"
//					+ "CO2. Simplify switching functions using Boolean minimization theorems, map method and tabulation method.\r\n"
//					+ "\r\n" + "/r/n"
//					+ "CO3. Analyze and design combinational logic circuits and the effect of Static Hazards on these circuits.+\r\n"
//					+ "CO4. Synthesize symmetric functions using relay contact networks.\r\n" + "\r\n"
//					+ "CO5. Design switching circuits using threshold elements.+\r\n" + "\r\n"
//					+ " CO6. Analyze and Design Sequential logic Circuits\r\n" + "\r\n"
//					+ "B.Tech Computer Science and Engineering, B.Tech Computer Science and Engineering (Emerging Areas of Specializations) and B. Tech Information Technology\r\n"
//					+ "\r\n" + "\r\n" + "Course: Data Structures\r\n" + "\r\n"
//					+ "CO1. Explain the basic concepts of Abstract Data Types, Linear and Non-Linear Data structures.+\r\n"
//					+ "\r\n" + "CO2. Calculate the performance of the different algorithms in terms of time and space.\r\n"
//					+ "CO3. Write programs in C for different data structures like stacks, queues, linked lists (singly and doubly).\r\n"
//					+ " \r\n" + "CO4. Select appropriate data structure for a given problem.\r\n" + "\r\n"
//					+ "CO5. Write C programs for various searching algorithms, sorting algorithms and nonlinear data structures such as trees and graphs.\r\n"
//					+ "\r\n" + "3.	M. Tech Computer Science and Engineering\r\n" + "\r\n" + "Course: Machine Learning\r\n"
//					+ "\r\n" + "CO1: Understand the concepts of computational intelligence like machine learning\r\n"
//					+ "\r\n"
//					+ "CO2: Ability to get the skill to apply machine learning techniques to address the real time problems in different areas\r\n"
//					+ "\r\n" + "CO3: Understand the Neural Networks and its usage in machine learning application.\r\n"
//					+ "\r\n"
//					+ "CO4: Student should be able to understand the basic concepts such decision tree and neural networks. CO5: Ability to formulate machine learning techniques to respective problems.\r\n"
//					+ "4.	MBA\r\n" + "\r\n" + "Course: Marketing Management\r\n" + "\r\n"
//					+ "CO1: Understanding the concepts of Marketing Management. CO2: Analyze markets.\r\n" + "\r\n"
//					+ "CO3: Design customer driven strategies.\r\n" + "\r\n"
//					+ "CO4: Communicate the decisions towards business development with superior customer value. CO5: Know the concepts of pricing decisions and concepts of personal communication.\r\n"
//					+ "");
//			document.add(table27);
//
//			PdfPTable table28 = new PdfPTable(2);
//	        table28.setWidthPercentage(100f);
//			table28.setWidths(new int[] { 3, 3 });
//			table28.setSpacingBefore(5);
//
//			PdfPCell cell79criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table28.addCell(cell79criteria2);
//
//			PdfPCell cell80criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table28.addCell(cell80criteria2);
//
//			PdfPCell cell81criteria2 = new PdfPCell(new Paragraph("Upload COs for all courses (exemplars from Glossary)\r\n\r\n"));
//			table28.addCell(cell81criteria2);
//
//			PdfPCell cell82criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(25).getCriteria2FilePath() : ""));
//			table28.addCell(cell82criteria2);
//
//			PdfPCell cell83criteria2 = new PdfPCell(new Paragraph("upload Additional Information\r\n\r\n"));
//			table28.addCell(cell83criteria2);
//
//			PdfPCell cell84criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(26).getCriteria2FilePath() :""));
//			table28.addCell(cell84criteria2);
//			
//			PdfPCell cell830criteria2 = new PdfPCell(new Paragraph("Past link for Additional information\r\n\r\n"));
//			table28.addCell(cell830criteria2);
//
//			PdfPCell cell840criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(27).getCriteria2FilePath() :""));
//			table28.addCell(cell840criteria2);
//			
//
//			document.add(table28);
//
//			PdfPTable table29 = new PdfPTable(1);
//			table29.setWidthPercentage(100f);
//	//
////			PdfPCell cell013 = new PdfPCell(new Paragraph(
////					"2.6.2 Attainment of programme outcomes and course outcomes are evaluated by the institution." + "\r\n"
////							+ "" + "" + "Response:"
////							+ (criteria2Record != null
////									? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse262()
////									: "")
////							+ "\r\n" + "" + " \r\n"
////							+ "Mother Teresa follows all the norms of the Statutory Regulatory Authorities in evaluating/measuring the"
////							+ "attainment of both Program Outcomes (POs) and Course Outcomes (COs):\r\n" + "\r\n"
////							+ "Procedure for measuring attainment of COs:\r\n" + "\r\n"
////							+ "1.	CO attainments are calculated by considering marks obtained in each question of all the students who attend mid-term (CIE) and semester end examinations (SEE).\r\n"
////							+ "2.	For Objective Paper of mid-term examinations, Assignments and Tutorials, overall CO attainment is calculated, which is made applicable to all COs.\r\n"
////							+ "3.	For measuring the attainments of COs of a theory course, the targets fixed are:\r\n"
////							+ "\r\n"
////							+ "Mid-Term Subjective: 60% of maximum marks related to each CO Assignments and Tutorials (if any): 60% of maximum marks\r\n"
////							+ "Mid-Term Objective: 60% of maximum marks\r\n"
////							+ "Semester End Examination: 60% of maximum marks related to each CO\r\n" + "\r\n"
////							+ "1.Attainment levels are calculated as follows:\r\n" + "\r\n"
////							+ "Semester End Examination (SEE)\r\n" + "Levels for CO attainment measurement\r\n"
////							+ "Level 1	> or = 40% and <50% of Students attain the target Marks\r\n"
////							+ "Level 2	> or = 50% and <60% of Students attain the target Marks\r\n"
////							+ "Level 3	> or = 60% of Students attain the target Marks\r\n" + "\r\n" + "\r\n" + "\r\n"
////							+ "Mid-term Exams � Subjective, Objective, Assignments and Tutorials (CIE)\r\n"
////							+ "Levels for CO attainment measurement\r\n" + "\r\n"
////							+ "Level 1	> or = 60% and <70% of students attain the target\r\n"
////							+ "Level 2	> or = 70% to <80% of students attain the target\r\n"
////							+ "Level 3	> or = 80% of students attain the target\r\n" + "\r\n" + "\r\n" + "\r\n"
////							+ "Indirect attainment � Course End Survey, CRC and TLP feedback\r\n" + "\r\n"
////							+ "Levels for CO attainment measurement\r\n"
////							+ "Level 1	> or = 60% and <70% of feedback score\r\n"
////							+ "Level 2	> or = 70% and <80% of feedback score\r\n"
////							+ "Level 3	> or = 80% of feedback score\r\n"
////							+ "1.	In the case of �Either-or� question, maximum marks scored by student is considered for CO attainment.\r\n"
////							+ "2.	Direct and indirect measurements for CO attainment:\r\n"
////							+ "2.1	Weightage for Direct measurement: 60% for SEE , 40% for CIE\r\n"
////							+ "2.2	Direct Attainment of CO = 0.2* Mid-term Subjective + 0.1* Mid-term Objective + 0.05*\r\n"
////							+ "Assignment + 0.05* Tutorial + 0.6* SEE.\r\n" + " \r\n"
////							+ "2.3	Indirect Attainment of COs through feedback = 0.4* TLP+ 0.4* CRC + 0.2* CES\r\n"
////							+ "2.4	Overall CO Attainment = 0.75* Direct Attainment Level + 0.25* Indirect Attainment Level\r\n"
////							+ "3.	For practical examinations (CIE and SEE), 60% of maximum marks are kept as target for attainment. Distribution of marks: SEE-70, CIE-30(Mid-Term-15, Day to day-15)\r\n"
////							+ "3.1	CO attainment levels:\r\n" + "80% for Level3, 70% for Level2 and 60% for Level1"
////							+ "3.2	Overall CO Attainment = 0.75* Direct Attainment Level + 0.25* Indirect Attainment"
////							+ "3.3	Similar procedure is adopted for Projects, Seminars, Mini Projects, and Internships."
//	//
////							+ "Procedure for measuring the attainments of POs and PSOs:"
//	//
////							+ "75% of weightage is given for the Direct attainment of that PO/PSO obtained in terms of Levels 1,2 and 3, which is the weighted average of all the COs related to that PO/PSO and"
////							+ "25% of weightage for Indirect measurement includes:"
//	//
////							+ "Exit feedback on POs/ PSOs (10%) Alumni Survey on POs/ PSOs (10%) and"
////							+ "Co-curricular and Extra-curricular activities (5%)."));
////			
//			
//			
//			PdfPCell cell013 = new PdfPCell(new Paragraph(
//				"2.6.2 Attainment of programme outcomes and course outcomes are evaluated by the institution." + "\r\n"
//						+ "" + "" + "Response:"
//						+ (criteria2Record != null
//								? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse262()
//								: ""),font3));
//			
//			
//			PdfPCell cell0013 = new PdfPCell(new Paragraph(
//					(criteria2Record != null
//									? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput262t1()
//									: "")));
//			
//			
//			
//			
//
//			table29.addCell(cell013);
//			table29.addCell(cell0013);
//			document.add(table29);
//
//			PdfPTable table30 = new PdfPTable(2);
//			
//	        table30.setWidthPercentage(100f);
//	        
//	        PdfPTable table300 = new PdfPTable(1);
//	        table300.setWidthPercentage(100f);
//			table30.setWidths(new int[] { 3, 3 });
//			
//
//			PdfPCell cell85criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table30.addCell(cell85criteria2);
//
//			PdfPCell cell86criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table30.addCell(cell86criteria2);
//
//			PdfPCell cell87criteria2 = new PdfPCell(new Paragraph("upload for any additional information\r\n\r\n"));
//			table30.addCell(cell87criteria2);
//
//			PdfPCell cell88criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(28).getCriteria2FilePath() : ""));
//			table30.addCell(cell88criteria2);
//			
//			PdfPCell cell870criteria2 = new PdfPCell(new Paragraph("Paste link for any additional information\r\n\r\n"));
//			table30.addCell(cell870criteria2);
//
//			PdfPCell cell880criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(29).getCriteria2FilePath() : ""));
//			table30.addCell(cell880criteria2);
//			
//			table300.addCell("Mother Teresa follows all the norms of the Statutory Regulatory Authorities in evaluating/measuring the\"\r\n"
//					+ "attainment of both Program Outcomes (POs) and Course Outcomes (COs):\\r\\n\" + \"\\r\\n\"\r\n"
//					+ "Procedure for measuring attainment of COs:\\r\\n\" + \"\\r\\n\"\r\n"
//					+ "	1.	CO attainments are calculated by considering marks obtained in each question of all the students who attend mid-term (CIE) and semester end examinations (SEE).\\r\\n\"\r\n"
//					+ "	2.	For Objective Paper of mid-term examinations, Assignments and Tutorials, overall CO attainment is calculated, which is made applicable to all COs.\\r\\n\"\r\n"
//					+ "	3.	For measuring the attainments of COs of a theory course, the targets fixed are:\\r\\n\"\r\n"
//							
//					+ "	Mid-Term Subjective: 60% of maximum marks related to each CO Assignments and Tutorials (if any): 60% of maximum marks\\r\\n\"\r\n"
//					+ "	Mid-Term Objective: 60% of maximum marks\\r\\n\"\r\n"
//					+ "	Semester End Examination: 60% of maximum marks related to each CO\\r\\n\" + \"\\r\\n\"\r\n"
//					+ "	1.Attainment levels are calculated as follows:\\r\\n\" + \"\\r\\n\"\r\n"
//					+ "	Semester End Examination (SEE)\\r\\n\" + \"Levels for CO attainment measurement\\r\\n\"\r\n"
//					+ "Level 1	> or = 40% and <50% of Students attain the target Marks\\r\\n\"\r\n"
//					+ "	Level 2	> or = 50% and <60% of Students attain the target Marks\\r\\n\"\r\n"
//					+ "	Level 3	> or = 60% of Students attain the target Marks\\r\\n\" + \"\\r\\n\" + \"\\r\\n\" + \"\\r\\n\"\r\n"
//					+ "	Mid-term Exams � Subjective, Objective, Assignments and Tutorials (CIE)\\r\\n\"\r\n"
//					+ "	Levels for CO attainment measurement\\r\\n\" + \"\\r\\n\"\r\n"
//					+ "	Level 1	> or = 60% and <70% of students attain the target\\r\\n\"\r\n"
//					+ "	Level 2	> or = 70% to <80% of students attain the target\\r\\n\"\r\n"
//					+ "	Level 3	> or = 80% of students attain the target\\r\\n\" + \"\\r\\n\" + \"\\r\\n\" + \"\\r\\n\"\r\n"
//					+ "	Indirect attainment � Course End Survey, CRC and TLP feedback\\r\\n\" + \"\\r\\n\"\r\n"
//					+ "	Levels for CO attainment measurement\\r\\n\"\r\n"
//					+ "	Level 1	> or = 60% and <70% of feedback score\\r\\n\"\r\n"
//					+ "	Level 2	> or = 70% and <80% of feedback score\\r\\n\"\r\n"
//					+ "	Level 3	> or = 80% of feedback score\\r\\n\"\r\n"
//					+ "	1.	In the case of �Either-or� question, maximum marks scored by student is considered for CO attainment.\\r\\n\"\r\n"
//					+ "	2.	Direct and indirect measurements for CO attainment:\\r\\n\"\r\n"
//					+ "	2.1	Weightage for Direct measurement: 60% for SEE , 40% for CIE\\r\\n\"\r\n"
//					+ "2.2	Direct Attainment of CO = 0.2* Mid-term Subjective + 0.1* Mid-term Objective + 0.05*\\r\\n\"\r\n"
//					+ "	Assignment + 0.05* Tutorial + 0.6* SEE.\\r\\n\" + \" \\r\\n\"\r\n"
//					+ "2.3	Indirect Attainment of COs through feedback = 0.4* TLP+ 0.4* CRC + 0.2* CES\\r\\n\"\r\n"
//					+ "2.4	Overall CO Attainment = 0.75* Direct Attainment Level + 0.25* Indirect Attainment Level\\r\\n\"\r\n"
//					+ "3.	For practical examinations (CIE and SEE), 60% of maximum marks are kept as target for attainment. Distribution of marks: SEE-70, CIE-30(Mid-Term-15, Day to day-15)\\r\\n\"\r\n"
//					+ "3.1	CO attainment levels:\\r\\n\" + \"80% for Level3, 70% for Level2 and 60% for Level1\"\r\n"
//					+ "	3.2	Overall CO Attainment = 0.75* Direct Attainment Level + 0.25* Indirect Attainment\"\r\n"
//					+ "3.3	Similar procedure is adopted for Projects, Seminars, Mini Projects, and Internships.\"\r\n"
//					+ "\r\n"
//					+ "	Procedure for measuring the attainments of POs and PSOs");
//			
//			
//			
//
//			document.add(table30);
//			
//			
//			//YEAR TABLE 2621
////			Table table2621 = new Table(criteria2Record.getAffiliated_YearTable2621().size(), 2);
//	//
////			table2621.setPadding(10);
////			table2621.setWidth(100f);
//	//
////			for (int i = 0; i < criteria2Record.getAffiliated_YearTable2621().size(); i++) {
////				table2621.addCell(criteria2Record.getAffiliated_YearTable2621().get(i).getInput2621y());
////			}
////			for (int i = 0; i < criteria2Record.getAffiliated_YearTable2621().size(); i++) {
////				table2621.addCell(criteria2Record.getAffiliated_YearTable2621().get(i).getInput2621v());
////			}
//	//
////			document.add(table2621);
//	//
////			//2622
////			
////			Table table2622 = new Table(criteria2Record.getAffiliated_YearTable2622().size(), 2);
//	//
////			table2622.setPadding(10);
////			table2622.setWidth(100f);
//	//
////			for (int i = 0; i < criteria2Record.getAffiliated_YearTable2622().size(); i++) {
////				table2622.addCell(criteria2Record.getAffiliated_YearTable2622().get(i).getInput2622y());
////			}
////			for (int i = 0; i < criteria2Record.getAffiliated_YearTable2622().size(); i++) {
////				table2622.addCell(criteria2Record.getAffiliated_YearTable2622().get(i).getInput2622v());
////			}
//	//
////			document.add(table2622);
////			
//
//			//263
//			
//
//			PdfPTable table31criteria2 = new PdfPTable(1);
//			table31criteria2.setWidthPercentage(100f);
//
//			table31criteria2.addCell("2.6.3 Pass Percentage of students(Data for the latest completed academic year)\r\n"
//					+ "\r\n" + "\"Response:"
//					+ (criteria2Record != null ? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse263()
//							: ""));
//			/*
//			 * table31criteria2.
//			 * addCell("2.6.3.1 Total number of final year students who passed the examination conducted by Institution. \r\n"
//			 * + "\r\n" + "" + "\"Response:"+criteria2Record.getResponseValue2631());
//			 * table31criteria2.
//			 * addCell("2.6.3.2 Total number of final year students who appeared for the examination conducted by the Institution. \r\n"
//			 * + "\r\n" + "" + "\"Response:"+criteria2Record.getResponseValue2632());
//			 */
//
//			document.add(table31criteria2);
//
//			PdfPTable table32 = new PdfPTable(2);
//
//			table32.setWidthPercentage(100f);
//			table32.setWidths(new int[] { 3, 3 });
//			table32.setSpacingBefore(5);
//
//			PdfPCell cell89criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table32.addCell(cell89criteria2);
//
//			PdfPCell cell90criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table32.addCell(cell90criteria2);
//
//			PdfPCell cell91criteria2 = new PdfPCell(new Paragraph(
//					"Upload List of Programmes and number of students passed and appeared in the final year examination(Data Template)\r\n\r\n"));
//			table32.addCell(cell91criteria2);
//
//			PdfPCell cell92criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(30).getCriteria2FilePath() : ""));
//			table32.addCell(cell92criteria2);
//
//			PdfPCell cell93criteria2 = new PdfPCell(new Paragraph("Upload any  the annual report\r\n\r\n"));
//			table32.addCell(cell93criteria2);
//
//			PdfPCell cell94criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(31).getCriteria2FilePath() : ""));
//			table32.addCell(cell94criteria2);
//			PdfPCell cell930criteria2 = new PdfPCell(new Paragraph("Paste link for annual report\r\n\r\n"));
//			table32.addCell(cell930criteria2);
//
//			PdfPCell cell940criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(32).getCriteria2FilePath() : ""));
//			table32.addCell(cell940criteria2);
//			document.add(table32);
//			
//			// 2.7
//
//			Paragraph paragraph9criteria2 = new Paragraph("2.7	Student Satisfaction Survey \r\n\r\n", font2);
//
//			paragraph9criteria2.setAlignment(Paragraph.ALIGN_LEFT);
//
//			document.add(paragraph9criteria2);
//			PdfPTable table33 = new PdfPTable(1);
//			table33.setWidthPercentage(100f);
//
////			table33.addCell("2.7.1 Online student satisfaction survey regarding teaching learning process\r\n" + "\r\n"
////					+ "Response:"
////					+ (criteria2Record != null ? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse271()
////							: ""));
////			
//			
//			
//			PdfPCell cell0003criteria2 = new PdfPCell(new Paragraph(
//					"student satisfaction survey regarding teaching learning process\r\n"
//					+ "Response:"
//							+ (criteria2Record != null ? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse271()
//							: ""),font3));
//			
//			
//			table33.addCell(cell0003criteria2);
//			
//			table33.addCell((criteria2Record != null ? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput271t1()
//							: ""));
//			
//			
//
//			document.add(table33);
//
//			PdfPTable table34 = new PdfPTable(2);
//
//			table34.setWidthPercentage(100f);
//			table34.setWidths(new int[] { 3, 3 });
//			table34.setSpacingBefore(5);
//
//			PdfPCell cell95criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table34.addCell(cell95criteria2);
//
//			PdfPCell cell96criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table34.addCell(cell96criteria2);
//
//			PdfPCell cell97criteria2 = new PdfPCell(new Paragraph("Upload database of all currently enrolled students"));
//			table34.addCell(cell97criteria2);
//
//			PdfPCell cell98criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(33).getCriteria2FilePath() : ""));
//			table34.addCell(cell98criteria2);
//
//			document.add(table34);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//	}
//	
//
//
//}
