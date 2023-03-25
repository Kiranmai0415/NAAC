package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.Criteria1_FileUpload;
import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.Criteria2_FileUpload;
import com.adiverse.erp.service.Criteria2Service;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
@Service
public class AutonomousCriteria23Report2 {
	
	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
	
   @Autowired
   Criteria2Service service2;
   
   
	List<Criteria2_FieldInfo> criteria2List = null;
	Criteria2_FieldInfo criteria2Record = null;
	List<Criteria2_FileUpload> criteria2file = null;
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;

public String generateReport(Criteria2_FieldInfo criteria2Fieldinfo) throws DocumentException, IOException {
		String reportPath = "";
		Path root = Paths.get(reportGeneratePath);
		Path file = null;
		Date date = new Date();
		try {
			font1.setSize(16);
			font2.setSize(14);
			font3.setSize(12);
			font4.setSize(14);
			font5.setSize(12);

			

			criteria2List = service2.getAllCriteria2Data();
			if (CollectionUtils.isNotEmpty(criteria2List)) {
				criteria2Record = criteria2List.get(0);
				criteria2file = criteria2Record.getCriteria2FileUpload();
			} else {
				criteria2Record = new Criteria2_FieldInfo();
			}
			
			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AuthonomousCriteria2Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
		
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
	
			
			
			
			PdfPTable tablecriteria2 = new PdfPTable(1);
			PdfPTable table1criteria2 = new PdfPTable(1);
	// PdfPTable table4criteria2 = new PdfPTable(5);

	// PdfPTable table5criteria2= new PdfPTable(5);

			PdfPTable table3criteria2 = new PdfPTable(2);

			PdfPTable table6criteria2 = new PdfPTable(5);
			PdfPTable table7criteria2 = new PdfPTable(2);

			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
		
			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
	
			document.add(paragraph2criteria2);

			tablecriteria2.setWidthPercentage(100f);
		

			Paragraph paragraph5criteria2 = new Paragraph("2.3	Teaching- Learning Process\r\n\r\n", font3);
			document.add(paragraph5criteria2);

			PdfPTable table03 = new PdfPTable(1);
			table03.setWidthPercentage(100f);

			PdfPCell cell001 = new PdfPCell(new Paragraph(
					"2.3.1 Student centric methods, such as experiential learning, participative learning and problem solving methodologies are used for enhancing learning experiences"
							+ "\r\n" + "" + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse231()
//									: "")
							+

							"Mother Teresa is committed to enhance the learning experience of its students, and follows a rigorous system of student-centric learning methods to inculcate and augment various skills among the students. Curricula of all programs include 30% of practicals, hands-on and activity-oriented courses.\r\n"
							+ "\r\n"
							+ "Experiential Learning: The college practices the Learn as you do method of learning through laboratory exercises, mini and major projects, design thinking, activity-oriented courses/internships/industry visits and Hackathons which facilitate the development of Problem-Solving Skills, through Project-Based Learning, in which various abilities such as creative designing of a system, applying an abstract concept or idea to a real-world problem, visualization of product design and realizing it, preparing an appropriate technical report and presenting it to a technical audience are achieved.\r\n"
							+ "\r\n"
							+ "In a few cases (02), emanating from such experiential learning, prototypes were developed by students and submitted for patenting or published as a patent. In few other cases (20), the ideations and applications\r\n"
							+ "were presented at Hackathons, which have won them laurels and awards/prizes (17). Every year, projects are exhibited at Exhibitions organized by the college and elsewhere, wherein, invited industry experts assess and identify some as suitable for product development, and reward them (03).\r\n"
							+ "\r\n"
							+ "Collaborative and Cooperative Learning is facilitated through peers wherein students discuss ideas with classmates, engage in subject-specific discussions and get feedback from classmates thereby augmenting mutual teaching-learning, assimilating multiple views to deepen the knowledge, promoting critical thinking and mitigating learner isolation. This has also led to inculcating effective teamwork and communication (including interpersonal and cross-cultural awareness), skills fostering individual accountability within the team, resulting in developing independent learning strategies.\r\n"
							+ "\r\n"
							+ "Group and participative learning towards development of Professional Competencies:\r\n"
							+ "\r\n"
							+ "Students take up course-based group projects, discuss ideas and develop ways to solve identified problems for specific applications, develop prototypes for further recognition and incentivization.\r\n"
							+ "\r\n"
							+ "Students discuss topics on emerging trends, innovative business ideas, prepare technical articles, business reports, present them at seminars/symposia. This promotes students� sensitivity towards the feelings of other team members in the group, help to develop listening skills, to be open to others� ideas, and look for opportunities to work collaboratively thus adding value to their profession and person, both, academically and socially.\r\n"
							+ "\r\n"
							+ "Learning through value added courses: Students develop hands on skills on advanced/emerging tools gaining adequate exposure to modern tool usage. During the last five years 43 value added courses have been offered and 5437 students have been the beneficiaries.\r\n"
							+ "\r\n"
							+ "Interactions with various external experts: Students are exposed to elite Guest Lectures, Industrial Visits, and Field trips, making them familiar with occupational environment, develop an ability to understand: what engineers do, the language and process of engineering design, and its economical aspects. They also understand the non-technical yet essential other side of engineering: its importance and impact on societal development and environmental issues for sustainability.\r\n"
							+ "\r\n"
							+ "Aside of the above, during the last five years, our students have taken up several Massive Open Online Courses (MOOCS) and such others (776).\r\n"
							+ "\r\n" + "\r\n" + ""));

			table03.addCell(cell001);

			document.add(table03);

			PdfPTable table10criteria2 = new PdfPTable(2);

			table10criteria2.setWidthPercentage(100f);
			table10criteria2.setWidths(new int[] { 3, 3 });
			table10criteria2.setSpacingBefore(5);

			PdfPCell cell21criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
			table10criteria2.addCell(cell21criteria2);

			PdfPCell cell22criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
			table10criteria2.addCell(cell22criteria2);

			PdfPCell cell23criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
			table10criteria2.addCell(cell23criteria2);

			PdfPCell cell24criteria2 = new PdfPCell(new Paragraph(" "));
			table10criteria2.addCell(cell24criteria2);

			document.add(table10criteria2);

			PdfPTable table04 = new PdfPTable(1);
			table04.setWidthPercentage(100f);

			PdfPCell cell002 = new PdfPCell(new Paragraph(
					"2.3.2 Teachers use ICT enabled tools including online resources for effective teaching and learning process."
							+ "" + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse232()
//									: "")
							+ "Faculty at Mother Teresa use appropriate ICT-enabled tools for effective teaching-learning and evaluation processes in the following ways: "
							+ "ICT-enabled tools used for Teaching-Learning:\r\n" + "\r\n"
							+ "Our faculty is quite savvy with the use of ICT-enabled tools for Classroom teaching-learning practices. Using Digital writing pads, preparing relevant power point presentations and videos, augment student learning experiences. Real time simulation exercises and virtual lab exercises adopted by teachers help in student-friendly demonstrations of complex concepts so that students comprehend/demystify them with ease and are able to understand the nuances of the exercises better. Such efforts have borne fruit in terms of not only better understanding by the Learners but also enhanced their long-term knowledge retention abilities. Students and Faculty have unlimited access to the institutional Wi-Fi network and digital library, for protracted ICT-enabled teaching-learning.\r\n"
							+ "\r\n"
							+ "Apart from the above-mentioned classroom and laboratory practices, our teachers are proficient in engaging the students through virtual modes using several platforms such as Google Suite, GoToMeeting, Microsoft Teams, Zoom and Cisco Webex. Need-based online teaching-learning practices which was mandated during the recent pandemics has now become a dual mode of teaching-learning apart from regular classroom practices. Guest lectures, Remedial classes, value added courses, orientation/induction programs, and a few virtual industry visits (held only during the pandemic), has widened the academic horizon of both the faculty and the students.\r\n"
							+ "\r\n"
							+ "WhatsApp/Telegram groups, Gmail groups, and email groups with Mother Teresa�s domain name have been shared amongst the faculty and students, to ensure interactive and collaborative work as also exchange of content between teachers and students. Such interactive sessions are closely monitored by the respective mentors, for surety of academic exchanges and discussions.\r\n"
							+ "\r\n"
							+ "Learners have been able to get an opportunity to work on live projects with other learners in and beyond/outside the college, interact with experts from other Institutions/organizations, resulting in not only a qualitative improvement of the Teaching�Learning Process but also ushering an awareness and abilities for collaborative working and mitigating learner isolation.\r\n"
							+ "\r\n" + "Use of ICT in Remedial Teaching\r\n" + "\r\n"
							+ "Remedial Teaching using ICT through video lectures (144) prepared by teachers, facilitates flexibility to learners to learn at their own pace and seek help from the teacher as and when required. URLs of animated videos and faculty lectures captured are uploaded onto YouTube (144).\r\n"
							+ "\r\n"
							+ "Use of ICT in Evaluation has facilitated quicker assessment and feedback within a short duration of administering the tests/examinations.\r\n"
							+ "\r\n"
							+ "Virtual Laboratories available on MHRD website, extensively used both by teachers and students provides better insight, experience and real time value addition to the academics, especially while studying the influence of a variable or a component on the performance of a system.\r\n"
							+ "\r\n"
							+ "Use of ICT for enhancing soft skills among students through video lectures, remote live sessions on programming skills, value added courses, aptitude skills (Quantitative, logical, reading comprehension, vocabulary, situational writing etc.) has enhanced their Thinking and Reasoning, improved comprehension capabilities, speed of reading and vocabulary, thus helping in their career progression and employability.\r\n"
							+ "\r\n"));

			table04.addCell(cell002);

			document.add(table04);

			PdfPTable table11criteria2 = new PdfPTable(2);

			table11criteria2.setWidthPercentage(100f);
			table11criteria2.setWidths(new int[] { 3, 3 });
			table11criteria2.setSpacingBefore(5);

			PdfPCell cell25criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
			table11criteria2.addCell(cell25criteria2);

			PdfPCell cell26criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
			table11criteria2.addCell(cell26criteria2);

			PdfPCell cell27criteria2 = new PdfPCell(new Paragraph(
					"Provide link for webpage describing ICT enabled tools including online resources for effective teaching and learning process"));
			table11criteria2.addCell(cell27criteria2);

			PdfPCell cell28criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : ""));
			table11criteria2.addCell(cell28criteria2);

			PdfPCell cell29criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n", font3));
			table11criteria2.addCell(cell29criteria2);

			PdfPCell cell30criteria2 = new PdfPCell(new Paragraph(""));
			table11criteria2.addCell(cell30criteria2);

			document.add(table11criteria2);

			PdfPTable table05 = new PdfPTable(1);
			table05.setWidthPercentage(100f);

//			table05.addCell(
//					"2.3.3 Ratio of students to mentor for academic and other related issues (Data for the latest completed academic year )\r\n"
//							+ "\r\n" + "\"Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse233()
//									: ""));

//			table05.addCell("2.3.3.1 Number of mentors \r\n" + "\r\n" + "Response:"
//					+ (criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getInput2331t1() : ""));

			document.add(table05);

			PdfPTable table13criteria2 = new PdfPTable(2);

			table13criteria2.setWidthPercentage(100f);
			table13criteria2.setWidths(new int[] { 3, 3 });
			table13criteria2.setSpacingBefore(5);

			PdfPCell cell31criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
			table13criteria2.addCell(cell31criteria2);

			PdfPCell cell32criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
			table13criteria2.addCell(cell32criteria2);

			PdfPCell cell33criteria2 = new PdfPCell(
					new Paragraph("Upload year wise, number of students enrolled and full time teachers on roll\r\n\r\n"));
			table13criteria2.addCell(cell33criteria2);

			PdfPCell cell34criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(4).getCriteria2FilePath() : ""));
			table13criteria2.addCell(cell34criteria2);

			PdfPCell cell35criteria2 = new PdfPCell(new Paragraph("Circulars pertaining to assigning mentors to mentees\r\n\r\n"));
			table13criteria2.addCell(cell35criteria2);

			PdfPCell cell36criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(5).getCriteria2FilePath() : ""));
			table13criteria2.addCell(cell36criteria2);

			PdfPCell cell37criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
			table13criteria2.addCell(cell37criteria2);

			PdfPCell cell38criteria2 = new PdfPCell(new Paragraph(""));
			table13criteria2.addCell(cell38criteria2);

			document.add(table13criteria2);

			PdfPTable table06 = new PdfPTable(1);
			table06.setWidthPercentage(100f);

			PdfPCell cell003 = new PdfPCell(new Paragraph(
					"2.3.4 Preparation and adherence of Academic Calendar and Teaching plans by the institution" + ""
							+ "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse234()
//									: "")
							+

							"Mother Teresa meticulously plans and executes all academic, co-curricular and extra-curricular activities through a well-conceived and executed academic calendar.\r\n"
							+ "\r\n"
							+ "The Academic calendar for each program is prepared by the Dean, Academics in consultation with HoDs, Controller of Examinations and Principal. Based on this each HoD in consultation with in- charges/coordinators enumerates various academic, co-curricular and extra-curricular activities in each semester/year. These are collated into a detailed academic calendar, reviewed by the College Academic Committee, and presented to the Academic Council, which approves with or without modifications. This is then circulated to all concerned well in advance and hosted on the website.\r\n"
							+ "\r\n"
							+ "Six to Eight weeks prior to the commencement of each semester, HoDs elicit course options from the faculty members which they would like to teach in the ensuing semester. The course options are given in such a way that each faculty member has at least one course with an associated laboratory component. Courses are allocated to the faculty based on their experience and expertise. When the number of sections is more, the senior most among the faculty teaching the particular course is designated as the course coordinator, who in association with others teaching the same course prepares the lesson plans for the course, specifying the array of activities, for the particular semester. They also prepare a course file by specifying the objectives of the course along with expected Learning Outcomes (LOs) and methods for assessing the Course Outcomes (COs).\r\n"
							+ " \r\n"
							+ "The course objectives specify the role it plays within each Program, its uniqueness within the Program and its relationship with other courses, as also the essential knowledge or skills likely to be gained from pursuing it, prerequisites for this course and its outcomes.\r\n"
							+ "\r\n"
							+ "Laboratory instructions are planned such that students acquire a thorough understanding of scientific methods/inquiries through problem solving, which include identifying and defining a problem, formulating the hypotheses, designing relevant experiments, collecting data through observations and experimentation, interpreting data and drawing conclusions. Subsequently, a report on the outcomes and their implications is prepared.\r\n"
							+ "\r\n"
							+ "Tutorial sessions are conducted by both teachers handling the course, through involved discussions and interactions with Learners and achieving solutions to problems.\r\n"
							+ "\r\n"
							+ "Teaching diary is maintained by each teacher detailing the topics discussed during each session, along with the record of students� attendance.\r\n"
							+ "\r\n"
							+ "Weekly report is maintained by each department for each section with track of the number of sessions engaged for each course along with the topics discussed and this is monitored by the Head of the Department and Dean, Academics.\r\n"
							+ "\r\n"
							+ "Course Coordinator monitors the progress of the course from time to time during each semester and communicates the same to the programme coordinator who advises other teachers teaching the same course appropriately.\r\n"
							+ "\r\n"
							+ "Programme Assessment Committee (PAC) reviews the progress of various courses and suggests appropriate revisionary measures.\r\n"
							+ "\r\n"
							+ "Various committees (both statutory and non-statutory) constituted for periodical reviews monitor the progress of curricular, co-curricular and extra-curricular activities. Academic committee, Academic council and Governing Body meet at stipulated intervals and review the activities at the institutional level.\r\n"
							+ "\r\n"));

			table06.addCell(cell003);
			document.add(table06);

			PdfPTable table15criteria2 = new PdfPTable(2);

			table15criteria2.setWidthPercentage(100f);
			table15criteria2.setWidths(new int[] { 3, 3 });
			table15criteria2.setSpacingBefore(5);

			PdfPCell cell39criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
			table15criteria2.addCell(cell39criteria2);

			PdfPCell cell40criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
			table15criteria2.addCell(cell40criteria2);

			PdfPCell cell41criteria2 = new PdfPCell(
					new Paragraph("Upload Academic Calendar and Teaching plans for five years\r\n\r\n"));
			table15criteria2.addCell(cell41criteria2);

			PdfPCell cell42criteria2 = new PdfPCell(new Paragraph(criteria2file.get(3).getCriteria2FilePath()));
			table15criteria2.addCell(cell42criteria2);

			document.add(table15criteria2);

		
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

		

}

