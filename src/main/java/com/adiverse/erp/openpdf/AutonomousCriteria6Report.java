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
//import com.adiverse.erp.model.Criteria6_FieldInfo;
//import com.adiverse.erp.model.Criteria6_FileUpload;
//import com.adiverse.erp.service.Criteria6Service;
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
//@Service
//public class AutonomousCriteria6Report {
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//	@Autowired
//	Criteria6Service service6;
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
//	List<Criteria6_FieldInfo> criteria6List = null;
//	Criteria6_FieldInfo criteria6Record = null;
//	List<Criteria6_FileUpload> criteria6file = null;
//	
//
//public String generateReport() throws DocumentException, IOException {
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
//			criteria6List = service6.getAllCriteria6Data();
//			if (CollectionUtils.isNotEmpty(criteria6List)) {
//				criteria6Record = criteria6List.get(0);
//				criteria6file = criteria6Record.getCriteria6FileUpload();
//			} else {
//				criteria6Record = new Criteria6_FieldInfo();
//				criteria6file = new ArrayList<>();
//			}
//
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AutonomousCriteria6Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
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
//			Paragraph paragraph1criteria6 = new Paragraph("Criterion 6 - Governance, Leadership and Management\r\n\r\n", font1);
//			paragraph1criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph1criteria6);
//
//			/*
//			 * com.lowagie.text.Font fontTitle0 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle0.setSize(12);
//			 */
//
//			Paragraph paragraph2criteria6 = new Paragraph("6.1	Institutional Vision and Leadership\r\n\r\n", font2);
//			paragraph2criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph2criteria6);
//			Paragraph paragraph3criteria6 = new Paragraph(
//					"6.1.1	The governance of the institution is reflective of an effective leadership in tune with the vision and mission of the Institution\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria6FieldInfoQl().get(0).getResponse611()
//									: ""),
//					font3);
//			paragraph3criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			com.lowagie.text.Font font0Title1 = FontFactory.getFont(FontFactory.HELVETICA);
//			font0Title1.setSize(12);
//
//			document.add(paragraph3criteria6);
//			Paragraph paragraph4criteria6 = new Paragraph(
//					"Mother Teresa has an Organizational Structure ensuring good governance, reflective of both, an Effective Leadership as also in tune with the Institutional Vision and Mission.\r\n"
//							+ "\r\n" + "",
//					font3);
//			paragraph4criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph4criteria6);
//
//			/*
//			 * com.lowagie.text.Font font0Title2 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); font0Title2.setSize(12);
//			 */
//			Paragraph paragraph5criteria6 = new Paragraph("Vision:", font3);
//			paragraph5criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph5criteria6);
//
//			/*
//			 * com.lowagie.text.Font font0Title3 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); font0Title3.setSize(12);
//			 */
//			Paragraph paragraph6criteria6 = new Paragraph(
//					"Mother Teresa visualizes dissemination of knowledge and skills to students, who would eventually contribute to the wellbeing of the people of the nation and global community.\r\n"
//							+ "\r\n"
//
//							+ "",
//					font3);
//			paragraph6criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph6criteria6);
//
//			/*
//			 * com.lowagie.text.Font font0Title4 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); font0Title4.setSize(12);
//			 */
//			Paragraph paragraph7criteria6 = new Paragraph("Mission:" + "", font3);
//			paragraph7criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph7criteria6);
//
//			Paragraph paragraph8criteria6 = new Paragraph(
//					"To impart adequate fundamental knowledge in all basic sciences and engineering, technical and inter-personal skills to students.\r\n"
//							+ "To bring out creativity in students that would promote innovation, research and entrepreneurship"
//							+ "\r\n"
//							+ " To preserve and promote cultural heritage, humanistic and spiritual values promoting peace and harmony in society.\r\n"
//							+ "\r\n" + "" + "",
//					font5);
//			paragraph8criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph8criteria6);
//
//			Paragraph paragraph9criteria6 = new Paragraph(
//					"College�s vision envisages that its graduating students contribute to national development and to the well- being of the global community.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "The mission is to produce graduates possessing sound knowledge in basic sciences and technical skills, human values, a strong zeal to serve community, leading to realization of the institution�s vision, which calls for good governance, requiring establishment of structures and processes, designed to ensure accountability, transparency, responsiveness, equity, empowerment, and participation. In line with these, and as per UGC guidelines for autonomous colleges, following statutory committees, namely, Governing Body, Academic Council, Boards of Studies, Finance Committee, and Women Protection Cell (now renamed as Internal Compliance Committee), are constituted, ensuring participation of teachers in decision making, proper management of academic, financial, and administrative matters of the college.\r\n"
//							+ "\r\n" + "" + "",
//					font5);
//			paragraph9criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph9criteria6);
//			Paragraph paragraph10criteria6 = new Paragraph(
//					"Further, several non-statutory committees comprising faculty, staff and students are also operative, assisting in the overall governance of the college. College promotes a culture of decentralized and participative management, extending down to Assistant Professor.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "The Principal, as head of the institution is vested with overall responsibility to plan, organize, and control all activities, empowering Deans, Heads of Departments (HoDs), committees and in-charges of sections, carrying out institution�s day to day functions by delegating authority. Duties and responsibilities of Principal and other personnel are well laid and spelt out clearly in �Roles and Responsibilities� handbook of the institution.\r\n"
//							+ "\r\n"
//							+ "College organized its structure into departments/sections, and groups/divisions within departments. To\r\n"
//							+ " \r\n"
//							+ "assist Principal, Deans and HoDs, in the performance of their functions, many committees, namely, Planning and Monitoring Board, Grievance Redressal Committee, Admissions Committee, Examinations Committee, Student Welfare Committee, Anti-ragging committee, Library Committee, Extra-curricular activities Committee, Academic Audit Committee etc. are formed at institutional and department level, comprising faculty/staff at all levels. Committees are empowered to deliberate independently, investigate, and recommend actions on various issues, referred to them.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Institution�s perspective (Strategic) plan is developed by the Planning and Monitoring Board, in consultation with the Governing Body. Strategic plan is aimed at achieving short, medium and long-term goals of the college, aligning with its Vision and Mission. The strategic plan is translated into operational goals and plans for departments, facilitating achievement of targets giving a detail of time schedules along with resources required over the plan period.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "All the above clearly ensure participative management at every level of the institution facilitating development of potential leaders in the college, a clear reflection and demonstration of effective leadership of college.\r\n"
//							+ "" + "",
//					font5);
//			paragraph10criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph10criteria6);
//	//create a table 1
//			PdfPTable table1criteria6 = new PdfPTable(2);
//			table1criteria6.setWidthPercentage(100);
//	//PdfPTable table11=new PdfPTable(2);
//	//table11.setWidthPercentage(100);
//			PdfPCell cell1criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell2criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell3criteria6 = new PdfPCell(new Paragraph("Any aditional information"));
//			PdfPCell cell4criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			table1criteria6.addCell(cell1criteria6);
//			table1criteria6.addCell(cell2criteria6);
//			table1criteria6.addCell(cell3criteria6);
//			table1criteria6.addCell(cell4criteria6);
//			table1criteria6.setSpacingBefore(20f);
//			table1criteria6.setSpacingAfter(20f);
//			document.add(table1criteria6);
//
//	//create table 2
//			PdfPTable table2criteria6 = new PdfPTable(2);
//			table2criteria6.setWidthPercentage(100);
//			PdfPTable table21criteria6 = new PdfPTable(1);
//			table21criteria6.setWidthPercentage(100);
//
//			PdfPCell cell21criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell22criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell23criteria6 = new PdfPCell(new Paragraph("Any aditional information\r\n\r\n\r\n"));
//			PdfPCell cell24criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")));
//			PdfPCell cell25criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell26criteria6 = new PdfPCell(new Paragraph());
//			PdfPCell cell27criteria6 = new PdfPCell(
//					new Paragraph("Link for strategic plan and deployment documents on the website\r\n\r\n\r\n"));
//			PdfPCell cell28criteria6 = new PdfPCell(new Paragraph(""));
//			table2criteria6.addCell(cell21criteria6);
//			table2criteria6.addCell(cell22criteria6);
//			table2criteria6.addCell(cell23criteria6);
//			table2criteria6.addCell(cell24criteria6);
//			table2criteria6.addCell(cell25criteria6);
//			table2criteria6.addCell(cell26criteria6);
//			table2criteria6.addCell(cell27criteria6);
//			table2criteria6.addCell(cell28criteria6);
//			table21criteria6.addCell(
//					"6.1.2	The effective leadership is reflected in various institutional practices such as decentralization and participative management.\r\n"
//							+ "\r\n" + "Response:\r\n" + "\r\n"
//							+ "Mother Teresa College of Engineering and Technology has a well laid practice of decentralization and participative management. Different committees, councils and cells are constituted viz., College Academic Council, Board of studies, Program Assessment Committee, College Academic committee, Research Committee and IQAC Cell etc. The roles and responsibilities of each committee/cell bearers and authorities and the structure of such organisational units are defined at the time of formation. A case study showcasing the practice of decentralization and participative management in the development of Course Outcomes, Course delivery methodology, Course attainments and Program Assessment is discussed below:\r\n"
//							+ "\r\n"
//							+ "The objectives are accomplished with the participation and coordinated functioning of the faculty at different levels, their roles being as follows:\r\n"
//							+ "\r\n" + "1.	Program Assessment Committee (PAC)\r\n" + "\r\n"
//							+ "PAC consists of Head of the Department (Program Coordinator unless the department offers more than one program) as the chairperson and Senior faculty members. The committee meets at least once in each semester to review the progress of the program.\r\n"
//							+ " \r\n"
//							+ "The committee monitors attainment of Course Outcomes (COs), Program Outcomes (POs) and Program Specific Outcomes (PSOs) with the major focus being the cumulative learning of the students undergoing the program.\r\n"
//							+ "\r\n"
//							+ "1.	Program Coordinator- In association with senior faculty, oversees all the courses offered by the department;\r\n"
//							+ "   *  Appoints Course Coordinators for each course offered and administered by the department;  Reviews the performance of students undertaking courses offered by the department;  o Ensures Institution's quality assurance processes for assessment in courses along with Academic Regulations, are implemented;\r\n"
//							+ "2.	Course coordinators - Discusses the course and its relationship to other courses within the program with the Program Coordinator\r\n"
//							+ "   *   Develops course outcomes for the course\r\n"
//							+ "   *   Schedules and conducts an orientation to the course for faculty, particularly who are new to the course.\r\n"
//							+ "   *   Develops a meaningful and well-connected topic sequence and schedules the same in consultation with other course instructors involved in the course and ensures adhering to the same.\r\n"
//							+ "   *   Develops valid and reliable methods to evaluate student learning outcomes\r\n\r\n"
//							+ "3.	Class Advisers (Section Advisor) - Discusses all potentially significant issues and establishes good communication with the students thereby making them fully aware of their responsibility to meet performance standards.\r\n"
//							+ "   *    Conducts weekly reviews with Counsellors, monitors student progress and documents reviews to establish a record of trends in overall class performance.\r\n\rn"
//							+ "4.	Question Paper Evaluation Committee � It consists of HoD, a few senior Professors Department IQAC representative and an invitee from other department. Chaired by the HoD, the committee examines the following:\r\n"
//							+ "   *    Mapping of course outcomes to Program outcomes vis-�-vis the questions Bloom�s Taxonomy level\r\n\r\n"
//							+ "   *    Discriminating power to distinguish bright and average student\r\n"
//							+ "   *  Specific and precise nature of questions as well as uniform coverage of the content.\r\n"
//							+ "\r\n" + "\r\n" + "\r\n"
//							+ "All the above clearly indicate decentralization at the department, wherein, faculty members participate not only in administering, monitoring the Teaching-Learning process, but also, in the evaluation and assessment of COs, POs and PSOs.\r\n"
//							+ "");
//
//			table2criteria6.setSpacingBefore(20f);
//			table2criteria6.setSpacingAfter(20f);
//			table21criteria6.addCell(table2criteria6);
//			document.add(table21criteria6);
//
//			Paragraph paragraph11criteria6 = new Paragraph("6.2 Strategy Development and Deployment\r\n\r\n\r\n", font2);
//			paragraph11criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph11criteria6);
//	//create a table 3
//			PdfPTable table3criteria6 = new PdfPTable(2);
//			table3criteria6.setWidthPercentage(100);
//			PdfPTable table31criteria6 = new PdfPTable(1);
//			table31criteria6.setWidthPercentage(100);
//
//			PdfPCell cell31criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
//			PdfPCell cell32criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell33criteria6 = new PdfPCell(
//					new Paragraph("Link for Strategic Plan and deployment documents on the website\r\n\r\n"));
//			PdfPCell cell34criteria6 = new PdfPCell(new Paragraph(""));
//			PdfPCell cell35criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell36criteria6 = new PdfPCell(new Paragraph(""));
//			table3criteria6.addCell(cell31criteria6);
//			table3criteria6.addCell(cell32criteria6);
//			table3criteria6.addCell(cell33criteria6);
//			table31criteria6.addCell(cell34criteria6);
//
//			table3criteria6.addCell(cell35criteria6);
//			table3criteria6.addCell(cell36criteria6);
//
//			PdfPCell cell312 = new PdfPCell(
//					new Paragraph("6.2.1	The institutional Strategic / Perspective plan is effectively deployed\r\n\r\n" + ""
//							+ "" + "Response:"
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria6FieldInfoQl().get(0).getResponse621()
//									: ""),
//							font3));
//			table31criteria6.addCell(cell312);
//
//	//table31.addCell("6.2.1	The institutional Strategic / Perspective plan is effectively deployed\r\n\r\n"+" Response:\r\n\r\n");
//			table31criteria6.addCell(
//					"A progressive institution is always one that has its Perspective Strategic Plan effectively designed, and deployed. Mother Teresa has put in place a feasible Institutional Perspective Strategic Plan and out of which one academic activity -Problem/Project Based Learning (PBL) is presented below as an example:\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Mother Teresa strongly believes in what Benjamin Franklin has said, �Tell me, I forget; teach me I may remember; involve me, I learn�. Our conviction is that perceivable learning happens only by doing, which is etched for eternity. Since personal experiences are far more interesting, enjoyable and involved, they are long-lasting and of utmost satisfaction. Mother Teresa visualized that Project-Based-Learning is a significant feature of Education 4.0, to make the students get deeply involved in their learning. This significant �learning while doing� is invaluable in providing economically-feasible solutions to imminent societal problems leading to and thereby ensuring environmentally-sustainable development.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Keeping this in view, Mother Teresa deputed 16 teachers from various departments to KLE Technological University, Hubli for a period of three days in November 2019 facilitating them towards PBL. Thereafter, Mother Teresa entered into an MoU with the Viswanekathan Group of Institutions, Khalapur, Maharashtra, for training faculty at Mother Teresa on �PBL�.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Step I: Introductory workshop on PBL was conducted during January 04-05, 2020. Fifty-five faculty drawn from different departments attended were trained to get sensitized in the identification of problems for a given course. Faculty prepared a problem canvas categorizing different aspects of the identified problem and presented their work.\r\n"
//							+ "\r\n"
//							+ "Step II: Course level PBL orientation Workshop, was conducted for same faculty during January 24-26, 2020. Aspects of implementation of PBL for a particular course were introduced; faculty of each department identified two courses for PBL implementation, learnt the concept of storyboard for a course. Course-level PBL canvas helped faculty to identify and create a clothes-line model for a particular problem.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Subsequently, resource persons interacted with students of first/second/third year, oriented them to adapt PBL into their learning and enabled them to be future ready.\r\n"
//							+ "\r\n" + "");
//			PdfPCell cell31x = new PdfPCell(
//					new Paragraph("Step III: Course Level PBL (CLPBL) implementation" + "" + "", font5));
//			table31criteria6.addCell(cell31x);
//			table31criteria6.addCell(
//					"In continuation to the first two PBL workshops, all departments identified the courses and the respective faculty for implementation of PBL. During March 04-05, 2020, resource persons from Vishwaniketan interacted with our faculty, CLPBL presentations were reviewed, feedbacks were received and incorporated into action plans for implementing the same. Resource persons also reviewed final year projects for business viability through bootcamp, had another interaction with students to orient them towards PBL.");
//
//			PdfPCell cell31y = new PdfPCell(
//					new Paragraph("OUTCOME: Tutorial on IEEE HYDCON on PBL and Course level PBL" + "" + "", font5));
//			table31criteria6.addCell(cell31y);
//			table31criteria6.addCell(
//					"The IEEE Hyderabad section organized a conference �Industry 4.0��, with emphasis on PBL as the\r\n"
//							+ " \r\n"
//							+ "educational approach for students to be industry-ready, conducted tutorial session on PBL for the participants, and our faculty demonstrated our strategically developed CLPBL as a feasible example for implementation, and this was highly appreciated.\r\n"
//							+ "\r\n"
//							+ "This experience and strategic action plan have rendered Mother Teresa to successfully implement PBL, in eighteen courses across various departments culminating in the development of critical thinking and interpersonal skills in students.\r\n"
//							+ "");
//
//			table31criteria6.addCell(table3criteria6);
//			table31criteria6.setSpacingAfter(20f);
//			document.add(table31criteria6);
//
//	//create table 4
//			PdfPTable table4criteria6 = new PdfPTable(2);
//			table4criteria6.setWidthPercentage(100);
//			PdfPTable table41criteria6 = new PdfPTable(1);
//			table41criteria6.setWidthPercentage(100);
//
//			PdfPCell cell41criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell42criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell43criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell44criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : "")));
//			PdfPCell cell45criteria6 = new PdfPCell(new Paragraph("Link to Organogram of the Institution webpage\r\n\r\n\r\n"));
//			PdfPCell cell46criteria6 = new PdfPCell(new Paragraph(""));
//			PdfPCell cell47criteria6 = new PdfPCell(new Paragraph("Link for additional information"));
//			PdfPCell cell48criteria6 = new PdfPCell(new Paragraph(""));
//			table4criteria6.addCell(cell41criteria6);
//			table4criteria6.addCell(cell42criteria6);
//			table4criteria6.addCell(cell43criteria6);
//			table4criteria6.addCell(cell44criteria6);
//			table4criteria6.addCell(cell45criteria6);
//			table4criteria6.addCell(cell46criteria6);
//			table4criteria6.addCell(cell47criteria6);
//			table4criteria6.addCell(cell48criteria6);
//			PdfPCell cell41x = new PdfPCell(new Paragraph(
//					"6.2.2	The functioning of the institutional bodies is effective and efficient as visible from policies, administrative setup, appointment, service rules and procedures, etc.\r\n"
//							+ "\r\n" + "\r\n" + "Response:"
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria6FieldInfoQl().get(0).getResponse622()
//									: ""),
//					font3));
//			table41criteria6.addCell(cell41x);
//			table41criteria6.addCell("Mother Teresa�s organogram depicts its organizational structure");
//			table41criteria6.addCell(
//					"Governing Body, the apex statutory body, monitors the reflection of the institution�s Vision, Mission and quality policy in all activities of the HEI, gives direction to various constituents and monitors its performance.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "The institution is organized into Academic, Examinations and Administrative units with Principal as Head of the Institution. Other statutory bodies of the college include, Academic Council (AC), Boards of Studies (BoS), and Finance committee, while, non-statutory committees, Planning & Monitoring Board, Library,\r\n"
//							+ " \r\n" + "\r\n"
//							+ "Examinations, Grievance Redressal, IQAC, Internal compliance committee (Women Protection Cell), Anti- Ragging, and Canteen, constituted as per the norms of the Autonomous status of the college.\r\n\r\n"
//							+ "");
//			table41criteria6.addCell(
//					"Dean, Academic, Prepares Academic Calendar detailing various activities, monitors progress of class work, student counseling/mentoring, directing and supervising student activity programs.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "The Registrar, along with Dean, Academic and college academic committee assists Principal in administering and leading the college within the policy framework developed by AC.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Controller of Examinations coordinates with external examiners, affiliating university officials and with all concerned in the college, ensures smooth conduct of all examinations evaluation and timely declaration of results.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Dean, RD&C formulates research and consultancy policies of the institution, processes research and patent proposals submitted by faculty, recommends internal seed money and other assistance for projects, if any, and identifies areas/institutions for collaborative purposes and rendering consultancy services.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Dean, Students Affairs facilitates/coordinates student council formation, maintains discipline, supervises anti-ragging committee and arranges to conduct extracurricular activities.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Coordinator, Industry Institute Interaction, develops industry linkage, facilitates MoUs.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Coordinator, computing services, oversees and facilitates IT infrastructure requirements, arranges for smooth conduct of IT activities of the institution.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Coordinator, IQAC, initiates and administers quality initiatives of the college. Arranges conduct of internal/external academic and administrative audit.\r\n"
//							+ "\r\n"
//							+ "Dean, TPCP, oversees/administers career guidance and development programs facilitating students acquire employability and career progression skills.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Coordinator, EDC, conducts entrepreneurial development programs., promoting entrepreneurship.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Coordinator, IC, nurtures seed of creativity and innovation, fostering a culture of product development through prototypes, resulting in entrepreneurship through a start-up, inviting and involving venture capitalists.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Dean, School of Computer Science and Informatics, oversees smooth functioning of CSE/IT/ CSE (Emerging Areas) departments ensuring optimal utilization of their resources.\r\n"
//							+ "Dean, School of Electrical and Communication Engineering, oversees smooth functioning of ECE and EEE departments, ensuring development of quality initiative measures for improving employability of students in core sectors.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "HoD, administers smooth conduct of academic and administrative activities of the department. In association with senior faculty members promotes scholarly activities of faculty and students.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "AO, assists Registrar in all administrative activities including operations, maintenance of facilities, safety\r\n"
//							+ "and security of all. Also maintains AICTE/UGC/Government correspondence.\r\n" + "\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Accounts Officer, in association with Registrar, assists Principal in the preparation of budget and maintaining records of all accounts, and facilitating audit of the same.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Establishment section, maintains personal files of all employees of the college updates their leave status from time to time\r\n"
//							+ "");
//			table41criteria6.addCell(table4criteria6);
//			table41criteria6.setSpacingAfter(20f);
//			document.add(table41criteria6);
//	//create table5
//			PdfPTable table5criteria6 = new PdfPTable(2);
//			table5criteria6.setWidthPercentage(100);
//			PdfPTable table51criteria6 = new PdfPTable(1);
//			table51criteria6.setWidthPercentage(100);
//
//			PdfPCell cell51criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			
//			PdfPCell cell52criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			
//			PdfPCell cell53criteria6 = new PdfPCell(new Paragraph("Screen shots of user interfaces\r\n\r\n\r\n"));
//			PdfPCell cell54criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(3).getCriteria6FilePath() : "")));
//			//cell54criteria6.setBackgroundColor(Align:);
//			PdfPCell cell55criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell56criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(4).getCriteria6FilePath() : "")));
//			PdfPCell cell57criteria6 = new PdfPCell(new Paragraph("ERP (Enterprise Resource Planning) Document\r\n\r\n\r\n"));
//			PdfPCell cell58criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(5).getCriteria6FilePath() : "")));
//			PdfPCell cell59criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell60criteria6 = new PdfPCell(new Paragraph(""));
//			table5criteria6.addCell(cell51criteria6);
//			table5criteria6.addCell(cell52criteria6);
//			table5criteria6.addCell(cell53criteria6);
//			table5criteria6.addCell(cell54criteria6);
//			table5criteria6.addCell(cell55criteria6);
//			table5criteria6.addCell(cell56criteria6);
//			table5criteria6.addCell(cell57criteria6);
//			table5criteria6.addCell(cell58criteria6);
//			table5criteria6.addCell(cell59criteria6);
//			table5criteria6.addCell(cell60criteria6);
//			PdfPCell cell51x = new PdfPCell(
//					new Paragraph(
//							"6.2.3	Implementation of e-governance in areas of operation\r\n" + "\r\n"
//									+ "1.	Administration\r\n" + "2.	Finance and Accounts\r\n"
//									+ "3.	Student Admission and Support\r\n" + "4.	Examination\r\n" + "\r\n" + "",
//							font3));
//			table51criteria6.addCell(cell51x);
//			table51criteria6.addCell("Response: A. All of the above");
//			table51criteria6.addCell(table5criteria6);
//			document.add(table51criteria6);
//
//	//paragraph 6.3
//			Paragraph paragraph12criteria6 = new Paragraph("6.3  Faculty Empowerment Strategies\r\n\r\n\r\n", font3);
//			paragraph12criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph12criteria6);
//	// create table6
//			PdfPTable table6criteria6 = new PdfPTable(2);
//			table6criteria6.setWidthPercentage(100);
//			PdfPTable table61criteria6 = new PdfPTable(1);
//			table61criteria6.setWidthPercentage(100);
//
//			PdfPCell cell61criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell62criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell63criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell64criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(6).getCriteria6FilePath() : "")));
//			PdfPCell cell65criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell66criteria6 = new PdfPCell(new Paragraph(""));
//			table6criteria6.addCell(cell61criteria6);
//			table6criteria6.addCell(cell62criteria6);
//			table6criteria6.addCell(cell63criteria6);
//			table6criteria6.addCell(cell64criteria6);
//			table6criteria6.addCell(cell65criteria6);
//			table6criteria6.addCell(cell66criteria6);
//			PdfPCell cell61x = new PdfPCell(new Paragraph(
//					"6.3.1 The institution has effective welfare measures for teaching and non-teaching staff and avenues for career development/ progression\r\n"
//							+ "\r\n" + "\r\n" + "Response:"
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria6FieldInfoQl().get(0).getResponse631()
//									: ""),
//					font3));
//			table61criteria6.addCell(cell61x);
//			table61criteria6.addCell(
//					"Mother Teresa is more than sensitive to reaching out welfare measures to both, our Faculty and the administrative/support Staff. The following welfare schemes/benefits are offered by the institution:\r\n"
//							+ "\r\n" + "");
//			table61criteria6.addCell(
//					" *  Financial incentives are given for faculty for research publications and Books/Book chapters :\r\n"
//							+ "\r\n" + " *  Full financial support for filing patents\r\n"
//							+ " *  Free Medical facility at the institution\r\n"
//							+ " *  Free transport to administrative staff.\r\n"
//							+ " *  Vehicles, and bus passes to Messengers.\r\n"
//							+ " *  Public transport bus passes to all drivers.\r\n"
//							+ " *  Need Based financial assistance to staff.\r\n"
//							+ " *  Cell-Phones and Laptops to HoDs for better connectivity and networking.\r\n"
//							+ " *  CLs, HPLs, CCL, Medical Leave and Examination Leaves as per their eligibility.\r\n"
//							+ " *  Paid Maternity Leave for female employees.\r\n"
//							+ " *  Special leave to staff on the occasion of their marriage.\r\n"
//							+ " *  Health Awareness camps within campus and Free Medical Check-ups.\r\n"
//							+ " *  Uniforms, washing allowance for Attendants, Ayahs and Drivers.\r\n"
//							+ " *  Paid leave @ one day/Week as incentive to faculty pursuing part-time Ph.D and conducting consultancy\r\n"
//							+ " *  Study/sabbatical leave for faculty pursuing full-time Ph.D.\r\n"
//							+ " *  Paid leave for faculty attending MOOCs certification examination and reimbursement of examination fee.\r\n"
//							+ " *  Paid leave with registration fee to attend FDPs/Conferences.\r\n"
//							+ " *  Supporting faculty pursuing research through Creation of required facilities as per their request.\r\n"
//							+ " *  ESI benefit to attenders, Ayahs, drivers, gardeners, and admin assistants.\r\n"
//							+ " *  Salary advances for faculty and staff in times of need." + "");
//
//			table61criteria6.addCell(table6criteria6);
//			document.add(table61criteria6);
//
//	//create a table7
//			PdfPTable table7criteria6 = new PdfPTable(1);
//			table7criteria6.setWidthPercentage(100);
//			PdfPTable table71criteria6 = new PdfPTable(2);
//			table71criteria6.setWidthPercentage(100);
//			PdfPCell cell71criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell72criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell73criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell74criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(7).getCriteria6FilePath() : "")));
//			PdfPCell cell75criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell76criteria6 = new PdfPCell(new Paragraph(""));
//			table71criteria6.addCell(cell71criteria6);
//			table71criteria6.addCell(cell72criteria6);
//			table71criteria6.addCell(cell73criteria6);
//			table71criteria6.addCell(cell74criteria6);
//			table71criteria6.addCell(cell75criteria6);
//			table71criteria6.addCell(cell76criteria6);
//
//			PdfPCell cell7x = new PdfPCell(new Paragraph(
//					"6.3.2 Average percentage of teachers provided with financial support to attend conferences / workshops and towards membership fee of professional bodies during the last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria6FieldInfoQn().get(0).getResponse632()
//									: ""),
//					font3));
//			PdfPCell cell7y = new PdfPCell(new Paragraph(
//					"6.3.2.1 Number of teachers provided with financial support to attend conferences/workshops and towards membership fee of professional bodies year wise during the last five years"
//							+ "",
//					font3));
//
//			table7criteria6.addCell(cell7x);
//			table7criteria6.addCell(cell7y);
//			document.add(table7criteria6);
//
//	//cretae table 6321
//
//			/*
//			 * Table table6321criteria6 = new
//			 * Table(criteria6Record.getYearTable6321().size(), 2);
//			 * 
//			 * table6321criteria6.setPadding(10); table6321criteria6.setWidth(100f);
//			 * 
//			 * for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
//			 * table6321criteria6.addCell(criteria6Record.getYearTable6321().get(i).
//			 * getInput6321y()); } for (int i = 0; i <
//			 * criteria6Record.getYearTable6331().size(); i++) {
//			 * table6321criteria6.addCell(criteria6Record.getYearTable6321().get(i).
//			 * getInput6321v()); }
//			 * 
//			 * document.add(table6321criteria6);
//			 */
//			table71criteria6.setSpacingAfter(10f);
//
//	//create table 8
//			PdfPTable table8criteria6 = new PdfPTable(1);
//			table8criteria6.setWidthPercentage(100);
//			PdfPTable table81criteria6 = new PdfPTable(2);
//			table81criteria6.setWidthPercentage(100);
//			PdfPCell cell81criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n\r\n", font3));
//			PdfPCell cell82criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell83criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell84criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(8).getCriteria6FilePath() : "")));
//			PdfPCell cell85criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell86criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(9).getCriteria6FilePath() : "")));
//			table81criteria6.addCell(cell81criteria6);
//			table81criteria6.addCell(cell82criteria6);
//			table81criteria6.addCell(cell83criteria6);
//			table81criteria6.addCell(cell84criteria6);
//			table81criteria6.addCell(cell85criteria6);
//			table81criteria6.addCell(cell86criteria6);
//
//			PdfPCell cell8x = new PdfPCell(new Paragraph(
//					"6.3.3 Average number of professional development / administrative training Programmes organized by the institution for teaching and non-teaching staff during the last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria6FieldInfoQn().get(0).getResponse633()
//									: ""),
//					font3));
//
//			PdfPCell cell8y = new PdfPCell(new Paragraph(
//					"6.3.3.1 Total number of professional development /administrative training Programmes organized by the institution for teaching and non teaching staff year-wise during the last five years"
//							+ "",
//					font3));
//
//			table8criteria6.addCell(cell8x);
//			table8criteria6.addCell(cell8y);
//			document.add(table8criteria6);
//	//create year table 6331
//			if (criteria6Record != null) {
//
//				Table table6331criteria6 = new Table(criteria6Record.getYearTable6331().size(), 2);
//
//				table6331criteria6.setPadding(10);
//				table6331criteria6.setWidth(100f);
//
//				for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
//					table6331criteria6.addCell(criteria6Record.getYearTable6331().get(i).getInput6331y());
//				}
//				for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
//					table6331criteria6.addCell(criteria6Record.getYearTable6331().get(i).getInput6331v());
//				}
//
//				document.add(table6331criteria6);
//			}
//			table81criteria6.setSpacingAfter(10f);
//			document.add(table81criteria6);
//	//cretae table 9
//			PdfPTable table9criteria6 = new PdfPTable(1);
//			table9criteria6.setWidthPercentage(100);
//			PdfPTable table91criteria6 = new PdfPTable(2);
//			table91criteria6.setWidthPercentage(100);
//			PdfPCell cell91criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell92criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell93criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell94criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(10).getCriteria6FilePath() : "")));
//			PdfPCell cell95criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell96criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(11).getCriteria6FilePath() : "")));
//			PdfPCell cell97criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell98criteria6 = new PdfPCell(new Paragraph(""));
//			table91criteria6.addCell(cell91criteria6);
//			table91criteria6.addCell(cell92criteria6);
//			table91criteria6.addCell(cell93criteria6);
//			table91criteria6.addCell(cell94criteria6);
//			table91criteria6.addCell(cell95criteria6);
//			table91criteria6.addCell(cell96criteria6);
//			table91criteria6.addCell(cell97criteria6);
//			table91criteria6.addCell(cell98criteria6);
//
//			PdfPCell cell9x = new PdfPCell(new Paragraph(
//					"6.3.4 Average percentage of teachers undergoing online/ face-to-face Faculty Development Programmes (FDP)during the last five years (Professional Development Programmes, Orientation / Induction Programmes, Refresher Course, Short Term Course ).\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria6FieldInfoQn().get(0).getResponse634()
//									: ""),
//					font3));
//			PdfPCell cell9y = new PdfPCell(new Paragraph(
//					"6.3.4.1 Total number of teachers attending professional development Programmes, viz., Orientation Programme, Refresher Course, Short Term Course, Faculty Development Programmes year wise during last five years"
//							+ "",
//					font3));
//			table9criteria6.addCell(cell9x);
//			table9criteria6.addCell(cell9y);
//			document.add(table9criteria6);
//	//create table 6341
//			if (criteria6Record != null) {
//
//				Table table6341criteria6 = new Table(criteria6Record.getYearTable6341().size(), 2);
//
//				table6341criteria6.setPadding(10);
//				table6341criteria6.setWidth(100f);
//
//				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
//					table6341criteria6.addCell(criteria6Record.getYearTable6341().get(i).getInput6341y());
//				}
//				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
//					table6341criteria6.addCell(criteria6Record.getYearTable6341().get(i).getInput6341v());
//				}
//
//				document.add(table6341criteria6);
//			}
//			table91criteria6.setSpacingAfter(10f);
//			document.add(table91criteria6);
//
//	//create 6.4
//			Paragraph paragraph13criteria6 = new Paragraph("6.4	Financial Management and Resource Mobilization\r\n\r\n\r\n\r\n", font3);
//			paragraph13criteria6.setAlignment(Paragraph.ALIGN_LEFT);
//			document.add(paragraph13criteria6);
//	//create table10
//			PdfPTable table10criteria6 = new PdfPTable(2);
//			table10criteria6.setWidthPercentage(100);
//
//			com.lowagie.text.Font fontTitle5criteria6 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			fontTitle5criteria6.setSize(10);
//
//			PdfPTable table101criteria6 = new PdfPTable(1);
//			table101criteria6.setWidthPercentage(100);
//
//			PdfPCell cell10x = new PdfPCell(new Paragraph(
//					"6.4.1	Institution conducts internal and external financial audits regularly\r\n\r\n Response:" + "", font3));
//			table101criteria6.addCell(cell10x);
//
//			PdfPCell cell101criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell102criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell103criteria6 = new PdfPCell(new Paragraph("Any additional information"));
//			PdfPCell cell104criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(12).getCriteria6FilePath() : "")));
//			table10criteria6.addCell(cell101criteria6);
//			table10criteria6.addCell(cell102criteria6);
//			table10criteria6.addCell(cell103criteria6);
//			table10criteria6.addCell(cell104criteria6);
//			table101criteria6.addCell(
//					"A: Internal financial audit: The college constitutes an internal committee for conducting verification of assets/capital equipment as well as financial audit. The committee checks financial reporting compliance with policies as well as compliance with respect to legal aspects including applicability of the trust/society. The internal audit also verifies the achievement of operational goals and objectives, safe guarding of assets, effective and efficient use of resources.\r\n"
//							+ "\r\n"
//							+ "Audit of assets and capital equipment are conducted through stock verification by the committee and based on shortages reported, if any, action for write-off is taken with the approval of the competent authority and such items are removed from the asset registers. Similar action is taken in respect of books/journals/documents.\r\n"
//							+ "\r\n"
//							+ "The internal audit committee, besides inspecting the books of account and records maintained by the finance department, evaluates internal control system, particularly, in respect of purchases, scholarships etc. The audit report is submitted to Principal/Chairman and subsequently Principal directs departments to take follow up action for closing the deficiencies and making changes in systems and procedures as called for.\r\n"
//							+ "\r\n"
//							+ "B: External financial audit: Mother Teresa arranges to conduct external financial audit every year by an external auditing agency named Haribabu and Associates, a registered financial auditing company, located in Hyderabad. The same auditing agency has been conducting external audit since the inception of our college, i.e.,2005. The auditors verify the financial statements and books of accounts to certify the truth and fairness of the financial position and operating system prevalent. The auditors employ internal check by verifying arithmetical accuracy of books of accounts, authentication and validation of transaction and also checking the proper distinction between capital and revenue nature of transactions. Except for transactions involving petty amounts, all other payments are made by way of issuing account payee cheques, demand drafts and using the fund transfer facility of banks such as NEFT/RTGS, to maintain transparency and to minimize errors may likely to occur due to cash transactions. This makes the job of our auditor simple and more easy. The audit observations submitted to the management by the audit company are examined carefully and corrective actions taken, if any, wherever required. At the end of every financial year, IT returns are filed to income tax department. These include, income and expenditure statements audited by a chartered accountant.\r\n"
//							+ "\r\n"
//							+ "All the audit reports have been found to be in order. However, prior to external audit an internal audit is conducted through a Chartered Accountant (CA). In case of any errors. identified by CA, they will be rectified by the internal accounts staff as per the suggestion by the CA. These minor errors, if and when crept in, due to any oversight by accounting personnel, is verified and rectified, resulting in strengthening of the financial accounting and budgetary control systems.\r\n"
//							+ " \r\n" + "");
//			table101criteria6.addCell(table10criteria6);
//			table101criteria6.setSpacingAfter(10f);
//			document.add(table101criteria6);
//	//create table 11
//			PdfPTable table11criteria6 = new PdfPTable(1);
//			table11criteria6.setWidthPercentage(100);
//			PdfPCell cell11x = new PdfPCell(new Paragraph(
//					"6.4.2 Funds / Grants received from non-government bodies, individuals, philanthropists during the last five years (not covered in Criterion III and V) (INR in Lakhs)\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria6FieldInfoQn().get(0).getResponse642()
//									: ""),
//					font3));
//			PdfPCell cell11y = new PdfPCell(new Paragraph(
//					"6.4.2.1 Total Grants received from non-government bodies, individuals, Philanthropers year-wise during the last five years (INR in Lakhs)"
//							+ "",
//					font3));
//			table11criteria6.addCell(cell11x);
//			table11criteria6.addCell(cell11y);
//			document.add(table11criteria6);
//	//create table 6421
//
//			if (criteria6Record != null) {
//
//				Table table6421 = new Table(criteria6Record.getYearTable6421().size(), 2);
//
//				table6421.setPadding(10);
//				table6421.setWidth(100f);
//
//				for (int i = 0; i < criteria6Record.getYearTable6421().size(); i++) {
//					table6421.addCell(criteria6Record.getYearTable6421().get(i).getInput6421y());
//				}
//				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
//					table6421.addCell(criteria6Record.getYearTable6421().get(i).getInput6421v());
//				}
//
//				document.add(table6421);
//			}
//
//			PdfPTable table111criteria6 = new PdfPTable(2);
//			table111criteria6.setWidthPercentage(100);
//			PdfPCell cell111criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n\r\n", font3));
//			PdfPCell cell112criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n\r\n", font3));
//			PdfPCell cell113criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n\r\n"));
//			PdfPCell cell114criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(13).getCriteria6FilePath() : "")));
//			PdfPCell cell115criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell116criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(14).getCriteria6FilePath() : "")));
//			PdfPCell cell117criteria6 = new PdfPCell(new Paragraph("Annual statements of accounts\r\n\r\n\r\n"));
//			PdfPCell cell118criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(15).getCriteria6FilePath() : "")));
//			PdfPCell cell119criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell120criteria6 = new PdfPCell(new Paragraph(""));
//			table111criteria6.addCell(cell111criteria6);
//			table111criteria6.addCell(cell112criteria6);
//			table111criteria6.addCell(cell113criteria6);
//			table111criteria6.addCell(cell114criteria6);
//			table111criteria6.addCell(cell115criteria6);
//			table111criteria6.addCell(cell116criteria6);
//			table111criteria6.addCell(cell117criteria6);
//			table111criteria6.addCell(cell118criteria6);
//			table111criteria6.addCell(cell119criteria6);
//			table111criteria6.addCell(cell120criteria6);
//			document.add(table111criteria6);
//	//CREATE TABLE12
//			PdfPTable table12criteria6 = new PdfPTable(1);
//			table12criteria6.setWidthPercentage(100);
//			PdfPTable table121x = new PdfPTable(1);
//			table121x.setWidthPercentage(100);
//
//			PdfPCell cell12Y = new PdfPCell(new Paragraph(
//					"6.4.3 Institutional strategies for mobilisation of funds and the optimal utilisation of resources Response:\r\n"
//							+ "Resource Mobilization Policy and Procedures\r\n" + "\r\n" + "\r\n"
//							+ "The policy of Mother Teresa with regard to mobilization of funds is as follows:\r\n" + "\r\n"
//							+ "\r\n"
//							+ "Internal: Tuition fee, NBA fee, Training fee, transport fee and other miscellaneous fees collected from students.\r\n"
//							+ "\r\n" + "\r\n" + "External:\r\n" + "",
//					font3));
//			table12criteria6.addCell(cell12Y);
//			document.add(table12criteria6);
//			table121x.addCell(
//					"Procedure: The accounts section of the college prepares, month-wise cash flow statements, at least two months in advance. The cash outflow statement is based on institutional budget estimates and additional inputs form departments for unanticipated major expenses, and contingency expenses. The cash inflow (income) statement is prepared based on the schedules for admissions, commencement of classes indicated in the Academic calendar, and examination time tables. The Accounts department notifies the fee payment schedules to students to align with cash requirements as per projected cash inflow statement. If there are indications of fee collection being short of estimates, vigorous efforts are made through academic department staff and fee counselor to increase the receipts. The gap between the actual income and the estimated expenses is bridged through loans from banks/non-bank financial institutions as per the policy guidelines.\r\n"
//							+ "\r\n"
//							+ "Periodically, a review of the adequacy of limits for term and operational loans sanctioned by banks is carried out by the college management and the Principal. If the sanctioned limits are found to be inadequate, the banks are approached for enhancement of the sanctioned limits, with proper justification.\r\n"
//							+ "");
//			table121x.addCell(table12criteria6);
//			document.add(table121x);
//
//	//create table 121
//			PdfPTable table121criteria6 = new PdfPTable(2);
//			table121criteria6.setWidthPercentage(100);
//			PdfPCell cell121criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell122criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell123criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell124criteria6 = new PdfPCell(new Paragraph(""));
//			table121criteria6.addCell(cell121criteria6);
//			table121criteria6.addCell(cell122criteria6);
//			table121criteria6.addCell(cell123criteria6);
//			table121criteria6.addCell(cell124criteria6);
//			document.add(table121criteria6);
//
//	//create a 6.5
//			Paragraph paragraph14criteria6 = new Paragraph("6.5	Internal Quality Assurance System\r\n\r\n\r\n", font2);
//			paragraph14criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph14criteria6);
//	//cretae table 13
//			PdfPTable table13criteria6 = new PdfPTable(1);
//			table13criteria6.setWidthPercentage(100);
//
//			PdfPCell cell13x = new PdfPCell(new Paragraph(
//					"6.5.1 Internal Quality Assurance Cell (IQAC) has contributed significantly for institutionalizing the quality assurance strategies and processes visible in terms of � Incremental improvements made for the preceding five years with regard to quality (in case of first cycle) Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives (second and subsequent cycles)\r\n"
//							+ "\r\n\r\n" + "Response"
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria6FieldInfoQl().get(0).getResponse651()
//									: ""),
//					font3));
//			table13criteria6.addCell(cell13x);
//			document.add(table13criteria6);
//	//create table 2reforms
//			PdfPTable table131criteria6 = new PdfPTable(2);
//			table131criteria6.setWidthPercentage(100);
//
//			PdfPTable table130criteria6 = new PdfPTable(1);
//			table130criteria6.setWidthPercentage(100);
//
//			PdfPCell cell131criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
//			PdfPCell cell132criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell133criteria6 = new PdfPCell(new Paragraph("Any additional information"));
//			PdfPCell cell134criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(16).getCriteria6FilePath() : "")));
//			table131criteria6.addCell(cell131criteria6);
//			table131criteria6.addCell(cell132criteria6);
//			table131criteria6.addCell(cell133criteria6);
//			table131criteria6.addCell(cell134criteria6);
//			table130criteria6.addCell(
//					"Internal Quality Assurance Cell (IQAC) of Mother Teresa has been in operation since 2012, initiating and conducting several activities to improve quality of both academic and administrative functions, in order to provide quality educational and service and experience for students, faculty and staff. During the last 5 years it has had 20 meetings and 80 resolutions. Among the practices initiated by IQAC, the following two have contributed to the quality enhancement.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Practice No. 1: Promoting research culture among faculty leading to increase in number and quality of publications/Patents:\r\n"
//							+ "\r\n" + "\r\n"
//							+ "IQAC in association with the R&D Cell, has been organizing FDPs/Seminars/Webinars/workshops on research methodology, IPR, creativity and innovation (during the last five years, 12 events were held), as well as encouraging faculty to attend such events conducted elsewhere (all put together 129 faculty participated). College also has been giving one day off per week for faculty to work on their PhD, based on the progress of their work.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Senior and experienced faculty with doctorate degree discuss with junior faculty, on the importance of obtaining doctorate for their career development, AICTE and UGC mandates for PhD degree, and subject- related research ideas and methodologies.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "As a result of these initiatives of IQAC, during the last five years, 71 faculty members have registered for part time PhD. In addition, 8 more have registered for full time PhD. Faculty pursuing PhD as well as others about to register for PhD, have been working actively, on identified areas of research and this has paved way for an increase in the number of publications from 321 to 734 and Patents published from zero to 55. Eight teachers have obtained Ph.D degrees while working in the college.\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Practice No. 2: Reforms in the Midterm examination question papers and assessment as per the Blooms Taxonomy levels:\r\n"
//							+ "\r\n" + "\r\n"
//							+ "Towards this, IQAC has initiated a process to assess the quality of midterm examination question papers and made significant improvements in the assessment of students aligning with the teaching-learning process and outcomes. Each department constituted a committee comprising the HoD/Program Coordinator, three senior faculty, course coordinator and one senior faculty from outside the department to look at various parameters in order to ensure that balanced question papers were prepared facilitating appropriate measurement of outcomes. IQAC designed a structured questionnaire in the form of a checklist (attached as additional document), and oriented faculty on the preparation of question paper and assess students� performance in fitment to the levels of Bloom�s Taxonomy. Guidelines were also given in regard to these levels for each of the four years of the BTech program as well as the PG programs. This has improved the quality of question papers and faculty are well acquainted on the appropriate implementation of OBE with usage of appropriate verbs vis-�-vis Bloom�s Taxonomy levels. This entire process has enabled better assessment of course outcomes, resulting in improvement of program outcomes, which is perceivable in the performance of graduates pursuing higher education and securing placements with higher pay packages.\r\n"
//							+ "");
//			table130criteria6.addCell(table131criteria6);
//			document.add(table130criteria6);
//			PdfPTable table14criteria6 = new PdfPTable(1);
//			table14criteria6.setWidthPercentage(100);
//			PdfPCell cell14x = new PdfPCell(new Paragraph(
//					"6.5.2 The institution reviews its teaching learning process, structures & methodologies of operations and learning outcomes at periodic intervals through IQAC set up as per norms and recorded the incremental improvement in various activities ( For first cycle - Incremental improvements made for the preceding five years with regard to quality For second and subsequent cycles - Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives )\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria6FieldInfoQl().get(0).getResponse652()
//									: ""),
//					font3));
//			table14criteria6.addCell(cell14x);
//			document.add(table14criteria6);
//	//create a table 141
//			PdfPTable table140criteria6 = new PdfPTable(1);
//			table140criteria6.setWidthPercentage(100);
//			table140criteria6.addCell(
//					"A detailed academic calendar that includes all academic activities is prepared much before commencement of each semester. Course allocation is done based on the expertise of the faculty. Timetables are prepared with dedicated time slots for regular class work/tutorials/remedial classes/seminars/mentoring/Training and Placement activities, and such others.\r\n"
//							+ "\r\n"
//							+ "Faculty prepare Teaching plan indicating topics with correlation to Course Outcomes (COs), Program Outcomes (POs) and Program Specific Outcomes (PSOs).\r\n"
//							+ "\r\n"
//							+ "All faculty submit Course files detailing various aspects including Lesson and Laboratory plan for conduct of theory and laboratory sessions in a well-defined format as specified by IQAC.\r\n"
//							+ "\r\n" + "I.	Implementation of Teaching-Learning reforms as initiated by the IQAC\r\n"
//							+ "\r\n"
//							+ "Mother Teresa�s conviction is that the course purpose induces students to deeply involve in their learning, which would lead to quality educational experiences, that would pave way in their professional career development. Towards this, IQAC prepared a detailed questionnaire for improving the quality of course file, giving utmost importance about the purpose of the course.\r\n"
//							+ "\r\n" + "Accordingly, IQAC has ensured that the following are described in course files:\r\n"
//							+ "\r\n"
//							+ " *  The role course plays within the Program, its uniqueness vis-�-vis other courses.\r\n"
//							+ " *  Essential knowledge/skills student gains from the course that would help to perform well in future classes/Higher Education progression/Jobs.\r\n"
//							+ " *  Prerequisite(s) for the course and specific knowledge/skills students need to know for their future career progression.\r\n"
//							+ " *  Unique contributions of the course to students� learning experience there by enriching the quality of the program, in particular, how student�s attitudes and higher-order thinking skills are developed.\r\n"
//							+ "\r\n"
//							+ "In the laboratory course, scientific enquiry and problem-solving skills are developed, which include:\r\n"
//							+ "\r\n" + " *  Defining a problem Formulating hypotheses\r\n"
//							+ " *  Designing, conducting experiments Collecting, interpreting data Testing hypotheses, if any,\r\n"
//							+ " *  Drawing inferences from conclusions\r\n"
//							+ " *  Communicating processes, outcomes and their implications\r\n" + " \r\n" + "");
//			table140criteria6.addCell(
//					"Prepared lesson plans are discussed with other faculty teaching the same course during Course Coordinator�s meetings. Curriculum is enriched with guest lectures, industrial visits and Internships. Students attendance and performance, continuously monitored by class adviser, mentor and faculty teaching various courses and students are apprised of the same during lectures, lab sessions, mentored and cautioned, whenever necessary.\r\n"
//							+ "\r\n" + "IQAC verifies the above through minutes of meetings of:\r\n" + "\r\n"
//							+ " *  CRC, Course Coordinator with faculty, Mentor-Mentee.\r\n"
//							+ " *  Quality of Guest Lectures etc.\r\n" + "\r\n"
//							+ "A continuous internal examination and evaluation system is in place.\r\n" + "\r\n"
//							+ "In tune with the outcome-based education approach, the question papers for the internal class tests prepared are evaluated by a question paper evaluation committee, following Bloom�s taxonomy, uniform distribution of questions vis-a-vis syllabus, enabling assessment of the attainment of Course Outcomes for each course.\r\n"
//							+ "\r\n"
//							+ "Parents are informed about their ward�s attendance on a daily basis and performance in examinations.\r\n"
//							+ "\r\n"
//							+ "Student feedback on TLP is taken twice a Semester, one immediately after three weeks of commencement of semester, final, just before conclusion of semester by IQAC through a structured questionnaire. It is reviewed by HoD, Dean, Academics and Principal, communicated to faculty. Faculty member with <70% feedback is counseled for improvement. On an average, 35-40 faculty have been mentored in each semester.\r\n"
//							+ "\r\n"
//							+ "II.	Institutional review - Internal and External Academic and Administrative Audit\r\n"
//							+ "\r\n"
//							+ "Mother Teresa strongly believes that peer review of our programs through feedback and audit (internal and external) help in strengthening our programs. Hence, feedback on several aspects is collected, analyzed and appropriate measures taken. Institution also conduct audit of our programs at the end of each academic year to sustain quality.\r\n"
//							+ "\r\n"
//							+ "Towards this, our IQAC has designed a meticulously planned framework detailing various processes starting from course allocation, preparing course file, teaching diary that contains record of classes conducted, topics discussed, student attendance record, mentoring book, weekly reports, class review meetings, and course coordinator�s meetings with faculty teaching same course to various other sections, guidelines for designing experiments, conduct of laboratory sessions, allocation of student projects and preparing question paper, minutes of Question Paper Evaluation Committee, Program Assessment Committee, etc.\r\n"
//							+ "\r\n"
//							+ "College Academic Committee periodically evaluates the effectiveness of TLP, pedagogical practices and processes outlined by IQAC. Students� learning in the form of knowledge absorption and content assimilation is regularly monitored by IQAC through an internal audit process:\r\n"
//							+ "\r\n" + "A. Internal Academic Audit\r\n" + "\r\n"
//							+ "All faculty members maintain academic record book (attendance register of students) and record daily\r\n"
//							+ " \r\n"
//							+ "lectures delivered, tutorial sessions, if any, practical/laboratory sessions conducted and other such activities performed. The academic record is periodically monitored by Course Coordinator/Group Head/HoDs by checking topics covered by faculty member. On the basis of this report, if syllabus coverage is not progressing satisfactorily as per schedule, the concerned faculty is advised to take extra classes to cover syllabus in time, which is ensured. The Head of the Department reviews various academic activities during department meetings, guides faculty members accordingly.\r\n"
//							+ "\r\n"
//							+ "IQAC has prepared a format to conduct internal academic audit across various departments after the conclusion of each academic year. The internal audit is conducted through senior faculty drawn from cross/ inter-departmental to evaluate efficacy of institution�s TLP and associated administrative aspects and reports on the findings of the committee are submitted, which are forwarded to the departments for taking necessary action. Departments subsequently submit Action Taken Report (ATR) to IQAC, which verifies against the findings submitted earlier, and if found satisfactory, files it, or else, departments are informed to take appropriate corrective measures.\r\n"
//							+ "\r\n" + "\r\n" + "B. External Academic Audit\r\n" + "\r\n" + "\r\n"
//							+ "The college�s IQAC has started administering external audit since the academic year 2018-19 by inviting senior academicians, with one for each department from other autonomous reputed colleges. Over and above, a former Principal/Dean of a reputed college is invited as the chairperson of the external audit team. External expert team visits all departments conducts audit for one complete day on the performance of the college�s TLP and associated administrative aspects as per the given format, shared at least a few weeks prior to the visit of the team. The team submits its report and departments take appropriate action on the findings of the report by submitting compliance.\r\n"
//							+ "" + "");
//			table140criteria6.addCell(table14criteria6);
//			document.add(table140criteria6);
//			PdfPTable table141criteria6 = new PdfPTable(2);
//			table141criteria6.setWidthPercentage(100);
//			PdfPCell cell141criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell142criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell143criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell144criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(17).getCriteria6FilePath() : "")));
//			table141criteria6.addCell(cell141criteria6);
//			table141criteria6.addCell(cell142criteria6);
//			table141criteria6.addCell(cell143criteria6);
//			table141criteria6.addCell(cell144criteria6);
//			document.add(table141criteria6);
//
//			// create table 15
//			PdfPTable table15criterion6 = new PdfPTable(1);
//			table15criterion6.setWidthPercentage(100);
//			PdfPCell cell15x = new PdfPCell(
//					new Paragraph("6.5.3	Quality assurance initiatives of the institution include:\r\n" + "\r\n"
//							+ "1.	Regular meeting of Internal Quality Assurance Cell (IQAC); Feedback collected, analysed and used for improvements\r\n"
//							+ "2.	Collaborative quality initiatives with other institution(s)\r\n"
//							+ "3.	Participation in NIRF\r\n"
//							+ "4.	Any other quality audit recognized by state, national or international agencies (ISO Certification\r\n"
//							+ "Response:"
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria6FieldInfoQn().get(0).getResponse653()
//									: ""),
//							font3));
//			table15criterion6.addCell(cell15x);
//			document.add(table15criterion6);
//			// cretae653
//			PdfPTable table151criterion6 = new PdfPTable(2);
//			table151criterion6.setWidthPercentage(100);
//			PdfPCell cell151 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//		
//			PdfPCell cell152 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell153 = new PdfPCell(new Paragraph("Upload e-copies of the accreditations and certifications\r\n\r\n\r\n\r\n"));
//			PdfPCell cell154 = new PdfPCell(
//					new Paragraph(criteria6Record != null ? criteria6file.get(18).getCriteria6FilePath() : ""));
//			PdfPCell cell155 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell156 = new PdfPCell(
//					new Paragraph(criteria6Record != null ? criteria6file.get(19).getCriteria6FilePath() : ""));
//			PdfPCell cell157 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell158 = new PdfPCell(
//					new Paragraph(criteria6Record != null ? criteria6file.get(20).getCriteria6FilePath() : ""));
//			PdfPCell cell159 = new PdfPCell(new Paragraph("Paste web link of Annual reports of Institution\r\n\r\n\r\n"));
//			PdfPCell cell160 = new PdfPCell(new Paragraph(""));
//			PdfPCell cell161 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell162 = new PdfPCell(new Paragraph(""));
//
//			table151criterion6.addCell(cell151);
//			table151criterion6.addCell(cell152);
//			table151criterion6.addCell(cell153);
//			table151criterion6.addCell(cell154);
//			table151criterion6.addCell(cell155);
//			table151criterion6.addCell(cell156);
//			table151criterion6.addCell(cell157);
//			table151criterion6.addCell(cell158);
//			table151criterion6.addCell(cell159);
//			table151criterion6.addCell(cell160);
//			table151criterion6.addCell(cell161);
//			table151criterion6.addCell(cell162);
//			table151criterion6.setSpacingBefore(10f);
//			document.add(table151criterion6);
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
