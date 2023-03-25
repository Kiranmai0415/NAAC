package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria1_FileUpload;
import com.adiverse.erp.service.Criteria1Service;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class AffilatedCriteria1Report 
{
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	
	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
	
	@Autowired
	Criteria1Service service1;
	
	List<Criteria1_FieldInfo> criteria1List = null;
	Criteria1_FieldInfo criteria1Record = null;
	List<Criteria1_FileUpload> criteria1file = null;
	
	
	public String generateReport() throws DocumentException, IOException {
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

			criteria1List = service1.getAllCriteria1Data();
			if (CollectionUtils.isNotEmpty(criteria1List)) {
				criteria1Record = criteria1List.get(0);
				criteria1file = criteria1Record.getCriteria1FileUpload();
			} else {
				criteria1Record = new Criteria1_FieldInfo();
				criteria1file = new ArrayList<Criteria1_FileUpload>();
			}
			
			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AffilatedCriteria1Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
			

			Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
			paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph);

			Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font2);
			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph1);
			Paragraph paragraph2 = new Paragraph("1.1  Curricular Planning and Implementation\r\n", font3);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph2);

			/*
			 * com.lowagie.text.Font fontTitle3 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle3.setSize(12);
			 */

			Paragraph paragraph3 = new Paragraph(
					" 1.1.1 The Institution ensures effective curriculum delivery through a well planned and documented process\r\n",
					
					font3);
			paragraph3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph3);

			PdfPTable table111criteria1 = new PdfPTable(1);

			table111criteria1.setWidthPercentage(100);
			PdfPCell cell111criteria1 = new PdfPCell(
					new Paragraph("1.1.1 Curricula developed and implemented have relevance to the local, "
							+ "national, regional and global developmental needs which is reflected in Programme outcomes (POs), "
							+ "Programme Specific Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered by the Institution.\r\n"
//					+ "Response:"+criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQl().get(0).getResponse111()
//									: "\r\n\r\n",
,font3));

			table111criteria1.addCell(cell111criteria1);

			table111criteria1.setSpacingBefore(20);
			table111criteria1.setSpacingAfter(20);
			document.add(table111criteria1);

			Paragraph paragraph5 = new Paragraph(
					"Mother Teresa being an autonomous HEI, has ensured a systematic procedure for the design, development, implementation and revision of its curricula as aligned to the institution�s vision and mission. All departments with their respective vision and mission have established their corresponding Program Educational Objectives (PEOs), defined Program Specific Outcomes (PSOs) and using the Program Outcomes (POs) of NBA, prepared PO-PEO matrix to ensure that POs facilitate realization of PEOs. Selected the number of credits for the program based on AICTE and UGC norms and decided distribution of credits. Identified the courses and defined respective course outcomes (COs), in line with Bloom�s Taxonomy levels, in particular, the Higher Order Thinking Skills (HOTS), meeting the stated POs and PSOs and prepared PO/PSO-CO matrix:",
					font5);
			paragraph5.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * com.lowagie.text.Font fontTitle6 =
			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle6.setSize(12);
			 */

			Paragraph paragraph6 = new Paragraph(
					"While preparing the curriculum and subsequent revisions (once in two years), each BoS gathers extensive inputs from all stakeholders, namely, industry, R&D establishments, members of professional bodies, alumni, faculty, government and community. Each BoS also considers impetus given to infrastructure sector, GDP earned from various sectors along with the manpower requirements, and Government�s directives towards \"Make in India\" as also �Aatma Nirbhar Bharath�.\r\n"
							+ "\r\n" + "\r\n",
					font5);
			paragraph6.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			
			Paragraph paragraph7 = new Paragraph(
					"Curricula are approved by the Academic Council, with due deliberations on their relevance, for further revision, if any, so that Institution's vision and mission are reflected in each program offered by the institution.",
					font5);
			paragraph7.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph8 = new Paragraph("Courses are broadly classified into:\r\n" + "\r\n", font5);
			paragraph8.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			
			Paragraph paragraph9 = new Paragraph("", font5);
			paragraph9.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			Chunk bullet1 = new Chunk("\u2022", font5);
			paragraph9.add(bullet1);
			paragraph9
					.add(new Phrase("Core: Basic/Engineering Sciences, Humanities, Social Sciences and Engineering.\r\n"));

			
			Paragraph paragraph10 = new Paragraph(" ", font5);
			paragraph10.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			Chunk bullet2 = new Chunk("\u2022", font5);
			paragraph10.add(bullet2);
			paragraph10.add(new Phrase(
					"Electives: Professional Electives which enrich students with technological advancements, and Open Electives which promote philosophy of liberal education."));

			
			Paragraph paragraph11 = new Paragraph(" ", font5);
			Chunk bullet3 = new Chunk("\u2022", font5);
			paragraph11.add(bullet3);
			paragraph11.add(new Phrase(
					"Value added courses: to enhance employability, creativity, innovation, team-work, communication, problem solving ability, Logical reasoning, environmental aspects for sustainability, professional ethics and integrity, Project management and finance, Design Thinking, Internship, projects/ seminars, entrepreneurship insights, value education, citizenship roles, catering to the local, regional and global needs.\r\n\r\n"));
			paragraph11.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			
			Paragraph paragraph12 = new Paragraph(
					"All the above provide the students with liberal and holistic education with experimental and experiential learning through simulation and hands-on operations, to be globally competitive:\r\n"
							+ "\r\n",
					font5);
			paragraph12.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph13 = new Paragraph(
					"As per NEP 2020, multi-disciplinary choices are available for learners, through a plethora of courses across departments, under the Choice Based Credit system (CBCS) and value added courses on usage of\r\n"
							+ " \r\n"
							+ "modern tools as adopted by industry, promoting analytical thinking, creativity and innovation, and building a culture of innovative spirit, thereby transforming the learners to be industry-ready, relevant and build an attitude of serving the society towards sustainable development:\r\n"
							+ "\r\n",
					font5);
			paragraph13.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			
			Paragraph paragraph14 = new Paragraph(
					"The following are some notable courses introduced in the corresponding revisions:\r\n" + "\r\n",
					font5);
			paragraph14.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			
			Paragraph paragraph15 = new Paragraph("2016-18:\r\n", font3);
			paragraph15.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		
			Paragraph paragraph16 = new Paragraph("", font5);
			paragraph16.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			Chunk bullet4 = new Chunk("\u2022", font5);
			paragraph16.add(bullet4);
			paragraph16.add(new Phrase("Computational Mathematics with lab\r\n"));

			
			Paragraph paragraph17 = new Paragraph("", font5);
			paragraph17.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			Chunk bullet5 = new Chunk("\u2022", font5);
			paragraph17.add(bullet5);
			paragraph17.add(new Phrase("Actuarial Statistics\r\n"));

			
			Paragraph paragraph18 = new Paragraph("", font5);
			paragraph18.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Chunk bullet6 = new Chunk("\u2022", font5);
			paragraph18.add(bullet6);
			paragraph18.add(new Phrase("Banking and Insurance\r\n"));

			
			Paragraph paragraph19 = new Paragraph("", font5);
			paragraph19.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			Chunk bullet7 = new Chunk("\u2022", font5);
			paragraph19.add(bullet7);
			paragraph19.add(new Phrase("Foreign Language\r\n"));

			/*
			 * com.lowagie.text.Font fontTitle20 =
			 * FontFactory.getFont(FontFactory.HELVETICA); font3.setSize(12);
			 */
			Paragraph paragraph20 = new Paragraph("", font5);
			paragraph20.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			Chunk bullet8 = new Chunk("\u2022", font5);
			paragraph20.add(bullet8);
			paragraph20.add(new Phrase("Hybrid Electric Vehicles\r\n"));

			/*
			 * com.lowagie.text.Font fontTitle21 =
			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle21.setSize(12);
			 */
			Paragraph paragraph21 = new Paragraph("", font5);
			paragraph21.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			Chunk bullet9 = new Chunk("\u2022", font5);
			paragraph21.add(bullet9);
			paragraph21.add(new Phrase("Nano-materials and Technology\r\n"));

			/*
			 * com.lowagie.text.Font fontTitle22 =
			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle22.setSize(12);
			 */
			Paragraph paragraph22 = new Paragraph("", font5);
			paragraph22.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			Chunk bullet10 = new Chunk("\u2022", font5);
			paragraph22.add(bullet10);
			paragraph22.add(new Phrase("Pavement analysis and design with lab\r\n"));

			/*
			 * com.lowagie.text.Font fontTitle23 =
			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle23.setSize(12)
			 */
			Paragraph paragraph23 = new Paragraph("", font5);
			paragraph23.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			Chunk bullet11 = new Chunk("\u2022", font5);
			paragraph23.add(bullet11);
			paragraph23.add(new Phrase("Earth Retaining Structures\r\n\r\n"));

			/*
			 * com.lowagie.text.Font fontTitle24 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle24.setSize(12);
			 */
			Paragraph paragraph24 = new Paragraph("2018-20\r\n", font3);
			paragraph24.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * com.lowagie.text.Font fontTitle25 =
			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle25.setSize(12);
			 */
			Paragraph paragraph25 = new Paragraph(" ", font5);
			paragraph25.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			Chunk bullet12 = new Chunk("\u2022", font5);
			paragraph25.add(bullet12);
			paragraph25.add(new Phrase("Deep learning\r\n"));

			/*
			 * com.lowagie.text.Font fontTitle26 =
			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle26.setSize(12);
			 */
			Paragraph paragraph26 = new Paragraph(" ", font5);
			paragraph26.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			Chunk bullet13 = new Chunk("\u2022", font5);
			paragraph26.add(bullet13);
			paragraph26.add(new Phrase("Electronic Sensors\r\n"));

			/*
			 * com.lowagie.text.Font fontTitle27 =
			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle27.setSize(12);
			 */
			Paragraph paragraph27 = new Paragraph(" ", font5);
			Chunk bullet14 = new Chunk("\u2022", font5);
			paragraph27.add(bullet14);
			paragraph27.add(new Phrase("IoT\r\n"));

			paragraph27.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * com.lowagie.text.Font fontTitle28 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle28.setSize(12);
			 */
			Paragraph paragraph28 = new Paragraph("Courses with hands on lab exercises:\r\n ", font3);
			paragraph28.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * com.lowagie.text.Font fontTitle29 =
			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle29.setSize(12);
			 */

			Paragraph paragraph29 = new Paragraph("", font5);
			Chunk bullet15 = new Chunk("\u2022", font5);
			paragraph29.add(bullet15);
			paragraph29.add(new Phrase("Artificial Intelligence\r\n", font5));

			Paragraph paragraph291 = new Paragraph("", font5);
			Chunk bullet16 = new Chunk("\u2022", font5);
			paragraph291.add(bullet16);
			paragraph291.add(new Phrase("Machine Learning\r\n"));

			Paragraph paragraph292 = new Paragraph("", font5);
			Chunk bullet17 = new Chunk("\u2022", font5);
			paragraph292.add(bullet17);
			paragraph292.add(new Phrase("Operations Research\r\n", font5));
			paragraph292.setAlignment(Element.ALIGN_JUSTIFIED);

			Paragraph paragraph293 = new Paragraph("", font5);
			Chunk bullet18 = new Chunk("\u2022", font5);
			paragraph293.add(bullet18);
			paragraph293.add(new Phrase("Blockchain Technologies\r\n", font5));
			paragraph293.setAlignment(Element.ALIGN_JUSTIFIED);

			Paragraph paragraph294 = new Paragraph("", font5);
			Chunk bullet19 = new Chunk("\u2022", font5);
			paragraph294.add(bullet19);
			paragraph294.add(new Phrase("Data Analytic\r\n", font5));
			paragraph294.setAlignment(Element.ALIGN_JUSTIFIED);

			Paragraph paragraph295 = new Paragraph("", font5);
			Chunk bullet20 = new Chunk("\u2022", font5);
			paragraph295.setAlignment(Element.ALIGN_JUSTIFIED);
			paragraph295.add(bullet20);
			paragraph295.add(new Phrase("Project-orientation\r\n", font5));

			Paragraph paragraph296 = new Paragraph("", font5);
			Chunk bullet21 = new Chunk("\u2022", font5);
			paragraph296.add(bullet21);
			paragraph296.add(new Phrase("IT workshop including Sci-lab\r\n\r\n", font5));
			paragraph296.setAlignment(Element.ALIGN_JUSTIFIED);

			/*
			 * com.lowagie.text.Font fontTitle30 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle30.setSize(12);
			 */
			Paragraph paragraph30 = new Paragraph("2020-21\r\n ", font3);
			paragraph30.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * com.lowagie.text.Font fontTitle31 =
			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle31.setSize(12);
			 */
			Paragraph paragraph31 = new Paragraph(" ", font5);
			Chunk bullet22 = new Chunk("\u2022", font5);
			paragraph31.add(bullet22);
			paragraph31.add(new Phrase("5G mobile communications\r\n\r\n", font5));
			paragraph31.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph311 = new Paragraph(" ", font5);
			Chunk bullet23 = new Chunk("\u2022", font5);
			paragraph311.add(bullet23);
			paragraph311.add(new Phrase("Six English courses (Three new)\r\n\r\n", font5));
			paragraph311.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph312 = new Paragraph(" ", font5);
			Chunk bullet24 = new Chunk("\u2022", font5);
			paragraph312.add(bullet24);
			paragraph312.add(new Phrase("IoT analytics\r\n\r\n", font5));
			paragraph312.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph313 = new Paragraph(" ", font5);
			Chunk bullet25 = new Chunk("\u2022", font5);
			paragraph313.add(bullet25);
			paragraph313.add(new Phrase("Six English courses (Three new) \r\n\r\n", font5));
			paragraph313.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph314 = new Paragraph(" ", font5);
			Chunk bullet26 = new Chunk("\u2022", font5);
			paragraph314.add(bullet26);
			paragraph314.add(new Phrase("Computational Intelligence\r\n\r\n", font5));
			paragraph314.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph315 = new Paragraph(" ", font5);
			Chunk bullet27 = new Chunk("\u2022", font5);
			paragraph315.add(bullet27);
			paragraph315.add(new Phrase("Quantum Computing and Cryptography\r\n\r\n", font5));
			paragraph315.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * com.lowagie.text.Font fontTitle32 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle32.setSize(12);
			 */
			Paragraph paragraph32 = new Paragraph("Courses with hands on lab exercises:\r\n\r\n", font3);
			paragraph32.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * com.lowagie.text.Font fontTitle33 =
			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle33.setSize(12);
			 */
			Paragraph paragraph33 = new Paragraph("", font5);
			Chunk bullet28 = new Chunk("\u2022", font5);
			paragraph33.add(bullet28);
			paragraph33.add(new Phrase("Statistics for Machine Learning \r\n\r\n", font5));
			paragraph33.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph331 = new Paragraph("", font5);
			Chunk bullet29 = new Chunk("\u2022", font5);
			paragraph33.add(bullet29);
			paragraph33.add(new Phrase("Digital Forensics \r\n\r\n", font5));
			paragraph33.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph332 = new Paragraph("", font5);
			Chunk bullet30 = new Chunk("\u2022", font5);
			paragraph332.add(bullet30);
			paragraph332.add(new Phrase("Wireless sensor networks \r\n\r\n", font5));
			paragraph332.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph333 = new Paragraph("", font5);
			Chunk bullet31 = new Chunk("\u2022", font5);
			paragraph333.add(bullet31);
			paragraph333.add(new Phrase("Smart Sensors and Instrumentation\r\n\r\n", font5));
			paragraph333.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph334 = new Paragraph("", font5);
			Chunk bullet32 = new Chunk("\u2022", font5);
			paragraph334.add(bullet32);
			paragraph334.add(new Phrase("Design Thinking \r\n\r\n", font5));
			paragraph334.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph3);
			//document.add(paragraph4);
			document.add(paragraph5);
			document.add(paragraph6);
			document.add(paragraph7);
			document.add(paragraph8);
			document.add(paragraph9);
			document.add(paragraph10);
			document.add(paragraph11);
			document.add(paragraph12);
			document.add(paragraph13);
			document.add(paragraph14);
			document.add(paragraph15);
			document.add(paragraph16);
			document.add(paragraph17);
			document.add(paragraph18);
			document.add(paragraph19);
			document.add(paragraph20);
			document.add(paragraph21);
			document.add(paragraph22);
			document.add(paragraph23);
			document.add(paragraph24);
			document.add(paragraph25);
			document.add(paragraph26);
			document.add(paragraph27);
			document.add(paragraph28);
			document.add(paragraph29);

			document.add(paragraph291);
			document.add(paragraph292);
			document.add(paragraph293);
			document.add(paragraph294);
			document.add(paragraph295);
			document.add(paragraph296);
		

			document.add(paragraph30);
			document.add(paragraph31);
			document.add(paragraph311);
			document.add(paragraph312);
			document.add(paragraph313);
			document.add(paragraph314);
			document.add(paragraph315);

			document.add(paragraph32);
			document.add(paragraph33);
			document.add(paragraph331);
			document.add(paragraph332);
			document.add(paragraph333);
			document.add(paragraph334);
			//111
			
			PdfPTable table111= new PdfPTable(2);
			PdfPTable table0111= new PdfPTable(1);
		    table111.setWidthPercentage(100);
		    table0111.setWidthPercentage(100);
			 PdfPCell cell1111= new PdfPCell(new Paragraph("File Description",font3));
			 PdfPCell cell1112 = new PdfPCell(new Paragraph("Document",font3));
			 PdfPCell cell1113= new PdfPCell(new Paragraph("Upload Additional information"));
			 PdfPCell cell1114 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :""));
			 PdfPCell cell1115= new PdfPCell(new Paragraph("Link for Additional information"));
			 PdfPCell cell1116 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() :""));
			 table111.addCell(cell1111);
			 table111.addCell(cell1112);
			 table111.addCell(cell1113);
			 table111.addCell(cell1114);
			 table111.addCell(cell1115);
			 table111.addCell(cell1116);
			 table111.setSpacingAfter(20);
			 table111.setSpacingBefore(20);
			 table0111.addCell("The college follows a curriculum prepared by the university. The APJ Abdul Kalam Technological\r\n"
			 		+ "University to which the college is affiliated practices a significant degree of decentralization and its\r\n"
			 		+ "academic administration is organised in the form of clusters. The college is under the Palakkad cluster of\r\n"
			 		+ "KTU. Each cluster has significant autonomy in designing and developing curriculum subject to the\r\n"
			 		+ "approval of the KTU central Academic Committee. \r\n"
			 		+ "The University, typically at the end of every academic year, requests the teachers in the affiliated colleges\r\n"
			 		+ "for feedback on the existing courses and the need for revision as well as the introduction of new\r\n"
			 		+ "courses. This college has devised various strategies to ensure outcome based learning and for strengthening\r\n"
			 		+ "our teaching learning process. These are mentioned below.");
			 
			 
			 table0111.addCell(" * Subject/course allocation based on faculty preference, competence /experience and university syllabus is done through a formal staff meeting chaired by the HOD well before the semester starts.\r\n"
			 		+ " * The academic calendar, semester plan and time table are circulated and lesson plans are prepared Lesson plans are made with well defined course outcomes, subject notes and learning materials like PPTs and manuals for conducting laboratory experiments.\r\n"
			 		+ " * Course team meetings are conducted in the presence of Principal, HOD, and faculty members handling the classes, to check the availability of Lesson plan and Assignments.\r\n"
			 		+ "Class / Course / Advisory Committee meetings for students are conducted twice each semester\r\n"
			 		+ "before the internal exams.\r\n"
			 		+ "Continuous assessment for laboratory work is done on the basis of viva questions and real time performance through well defined rubrics.\r\n"
			 		+ "Course delivery as per lesson plan and completion of syllabus is monitored by HOD.\r\n"
			 		+ "To maintain quality, the internal exam question papers are approved by the IQAC before sending it to the exam cell.\r\n"
			 		+ "Student’s feedback is taken twice each semester for the teaching learning process.\r\n"
			 		+ "PTA meetings are held class wise, after the internal examinations and the university examination\r\n"
			 		+ "result analysis of every semester, to discuss student academic progress and other matters.\r\n"
			 		+ "Progress reports for the internal and university exams are dispatched to the guardians to appraisethem about their wards’ performance.\r\n"
			 		+ "Course files prepared by the faculty are audited by KTU internal and external auditors at least twice in a semester.\r\n"
			 		+ "The central library, department libraries, digital library with e-books is available to both students\r\n");
			 
			 table0111.addCell("The Teaching and learning process has been enhanced by various Faculty Development Programs onrecent updates in technology conducted by eminent experts from the academic and industrial fields. Addon courses and invited talks help the students to meet experts in specific areas. Through NPTEL videosMOOC courses and webinars, students get sound information about the recent activities in the world andcan thus improve their skills.");
			 table0111.addCell(table111);
			 table0111.setSpacingAfter(20);
			 table0111.setSpacingBefore(20);
			 document.add(table0111);
			 
			
			
			
			
			
			//112
			PdfPTable table112= new PdfPTable(2);
			table112.setWidthPercentage(100);
			PdfPTable table1120 = new PdfPTable(1);
			table1120.setWidthPercentage(100);
			 PdfPCell cell1121= new PdfPCell(new Paragraph("File Description",font3));
			 PdfPCell cell1122 = new PdfPCell(new Paragraph("Document",font3));
			 PdfPCell cell1123= new PdfPCell(new Paragraph("Upload Additional information"));
			 PdfPCell cell1124 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() :""));
			 PdfPCell cell1125= new PdfPCell(new Paragraph("Link for Additional information"));
			 PdfPCell cell1126 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(3).getCriteria1FilePath() :""));
			 table112.addCell(cell1121);
			 table112.addCell(cell1122);
			 table112.addCell(cell1123);
			 table112.addCell(cell1124);
			 table112.addCell(cell1125);
			 table112.addCell(cell1126);
		
//			 table1120.addCell("1.1.2 The institution adheres to the academic calendar including for the conduct of CIE\r\n"
//			 		+ "Response: "+"(criteria1Record != null\r\n"
//			 				+ "? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse112()\r\n"

				PdfPCell cell1criteria1 = new PdfPCell(new Paragraph(
						"1.1.2 The institution adheres to the academic calendar including for the conduct of CIE "+ "Response:"
								+ (criteria1Record != null
										? criteria1Record.getCriteria11Qn().get(0).getResponse112()
										: ""),font3));
				table112.addCell(cell1criteria1);
				document.add(cell1criteria1);
			 
			 table1120.addCell("IQAC will facilitate / contribute\r\n"
			 		+ " * Heightened level of clarity and focus in institutional functioning towards quality enhancement.\r\n"
			 		+ " * Enhancement and coordination among various activities of the institution and institutionalize all good practices;\r\n"
			 		+ " * A sound basis for decision-making to improve institutional functioning;\r\n"
			 		+ " * Act as a dynamic system for quality changes in HEIs\r\n"
			 		+ " * Development of an organized methodology of documentation and internal communication\r\n"
			 		+ " * Availability of student attendance and feedback through Campus Book\r\n"
			 		+ " * Meetings with students to make them aware of the need of feedback on teachers which is done online.\r\n"
			 		+ " * Designing and arranging of a Teachers Diary which is helpful for them to prepare the teaching plan and record daily events and meetings.\r\n"
			 		+ " * Conduct a statistical analysis of admitted students based on gender, marks, category and admitted course and made a report.\r\n"
			 		+ " * The training on ICT enabled teaching using online platforms for teachers and students to motivate them to use it.\r\n"
			 		+ " * Conducting a need analysis after which, the IQAC proposed starting new undergraduate and postgraduate programmes.\r\n"
			 		+ " * IQAC preparation of the academic calendar along with the exam schedule and its distribution to Departments\r\n"
			 		+ " * A feedback by graduands about their teachers collected online. The Principal intimated teachers about their feedback and a plan of action was suggested to improve required areas.\r\n"
			 		+ " * The Time table committee made the general time table well ahead of the academic year.\r\n"
			 		+ " * As per plan the academic activities and the examinations were conducted smoothly as scheduled in the academic calendar\r\n"
			 		+ " * Wi-Fi internet facilities were provided to all Departments for accessing the Digital Library.\r\n"
			 		+ " * PG and Research candidates are provided with extra computer terminals in library.");
			 
			 table1120.addCell(table112);
			 table1120.setSpacingAfter(20);
			 table1120.setSpacingBefore(20);
			 document.add(table1120);
			 
			 
			
			
			
			
			
			
			
			
			
			// 113
			PdfPTable table113 = new PdfPTable(2);
			table113.setWidthPercentage(100);
			PdfPTable table1130 = new PdfPTable(1);
			table1130.setWidthPercentage(100);
			 PdfPCell cell1131= new PdfPCell(new Paragraph("File Description",font3));
			 PdfPCell cell1132 = new PdfPCell(new Paragraph("Document",font3));
			 PdfPCell cell1133= new PdfPCell(new Paragraph("Institutional data in prescribed format"));
			 PdfPCell cell1134 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() :""));
			 PdfPCell cell1135= new PdfPCell(new Paragraph("Details of participation of teachers in various bodies/activities provided as a response to the metric"));
			 PdfPCell cell1136 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() :""));
			 PdfPCell cell1137= new PdfPCell(new Paragraph("Any additional information"));
			 PdfPCell cell1138 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() :""));
			 PdfPCell cell1139= new PdfPCell(new Paragraph("Link for Additional information"));
			 PdfPCell cell11310 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(7).getCriteria1FilePath() :""));
			 
			 table113.addCell(cell1131);
			 table113.addCell(cell1132);
			 table113.addCell(cell1133);
			 table113.addCell(cell1134);
			 table113.addCell(cell1135);
			 table113.addCell(cell1136);
			 table113.addCell(cell1137);
			 table113.addCell(cell1138);
			 table113.addCell(cell1139);
			 table113.addCell(cell11310);
//			 table1130.addCell("1.1.3 Teachers of the Institution participate in following activities related to curriculum \r\n"
//			 		+ "development and assessment of the affiliating University and/are represented on the following\r\n"
//			 		+ "academic bodies during the last five years");
//			 
			 

				PdfPCell cell2criteria1 = new PdfPCell(new Paragraph(
						"1.1.3 Teachers of the Institution participate in following activities related to curriculum \\r\\n\"\r\n"
						+ "development and assessment of the affiliating University and/are represented on the following\\r\\n\"\r\n"
						+ "academic bodies during the last five years"+ "Response:"
								+ (criteria1Record != null
										? criteria1Record.getCriteria11Qn().get(0).getResponse113()
										: ""),font3));
				table113.addCell(cell2criteria1);
				document.add(cell2criteria1);
			 
			 
			 
			 table1130.addCell("1.Academic council/BoS of Affiliating university\r\n"
			 		+ "2.Setting of question papers for UG/PG programs \r\n"
			 		+ "3.Design and Development of Curriculum for Add on/ certificate/ Diploma Courses \r\n"
			 		+ "4.Assessment /evaluation process of the affiliating University\r\n"
			 		+ "Response: "+"(criteria1Record != null\r\n"+ "? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse121()\r\n"+ ":");
			 
			 table1130.addCell(table113);
			 table1130.setSpacingAfter(20);
			 table1130.setSpacingBefore(20);
			 document.add(table1130);
			
			
			
			 
			
			
			

		
	     
			
			
			
			//12
			Paragraph paragraph1221 = new Paragraph("1.2  Academic Flexibility\r\n"+ "",font3);
			document.add(paragraph1221);
			PdfPTable table120 = new PdfPTable(2);
			table120.setWidthPercentage(100);
			PdfPTable table1200 = new PdfPTable(1);
			table1200.setWidthPercentage(100);  
		     PdfPCell cell1221= new PdfPCell(new Paragraph("File Description",font3));
			 PdfPCell cell1222 = new PdfPCell(new Paragraph("Document",font3));
			 PdfPCell cell1223= new PdfPCell(new Paragraph("Minutes of relevant Academic Council/ BOS meetings"));
			 PdfPCell cell1224 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(8).getCriteria1FilePath() :""));
			 PdfPCell cell1225= new PdfPCell(new Paragraph("Institutional data in prescribed format"));
			 PdfPCell cell1226 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(9).getCriteria1FilePath() :""));
			 PdfPCell cell1227= new PdfPCell(new Paragraph("Any additional information"));
			 PdfPCell cell1228 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(10).getCriteria1FilePath() :""));
			 PdfPCell cell1229= new PdfPCell(new Paragraph("Link for Additional information"));
			 PdfPCell cell1230 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(11).getCriteria1FilePath() :""));
			 table120.addCell(cell1221);
			 table120.addCell(cell1222);
			 table120.addCell(cell1223);
			 table120.addCell(cell1224);
			 table120.addCell(cell1225);
			 table120.addCell(cell1226);
			 table120.addCell(cell1227);
			 table120.addCell(cell1228);
			 table120.addCell(cell1229);
			 table120.addCell(cell1230);
//			 table1200.addCell(
//					"1.2.1 Percentage of new courses introduced of the total number of courses across all programs offered during the last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Record != null
//									? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse121()
//									: ""));
//			 
				PdfPCell cell3criteria1 = new PdfPCell(new Paragraph(
						"1.2.1 Percentage of new courses introduced of the total number of courses across all programs offered during the last five years."+ "Response:"
								+ (criteria1Record != null? criteria1Record.getCriteria12Qn().get(0).getResponse121()
					: ""),font3));
				table120.addCell(cell3criteria1);
				document.add(cell3criteria1);
			 
			 
			 table1200.addCell("1.2.1.1 How many new courses are introduced within the last five years\r\n" + "\r\n"
					+ "Response:"
					+ (criteria1Record != null ? criteria1Record.getCriteria12Qn().get(0).getInput1211t1() : ""));
			 table1200.addCell(
					"1.2.1.2 Number of courses offered by the institution across all programmes during the last five years.\r\n"
							+ "\r\n" + "Response:"
							+ (criteria1Record != null ? criteria1Record.getCriteria12Qn().get(0).getInput1212t1()
									: ""));

			 table1200.addCell(table120);
			 table1200.setSpacingAfter(20);
			 table1200.setSpacingBefore(20);
			 document.add(table1200);
			
		// YEAR TABLE 1221
//			Table table1221 = new Table(criteria1Record.getAffiliated_YearTable1221().size(), 2);
	//
//			table1221.setPadding(10);
//			table1221.setWidth(100f);
	//
//			for (int i = 0; i < criteria1Record.getAffiliated_YearTable1221().size(); i++) {
//				table1221.addCell(criteria1Record.getAffiliated_YearTable1221().get(i).getInput1221y());
//			}
//			for (int i = 0; i < criteria1Record.getAffiliated_YearTable1221().size(); i++) {
//				table1221.addCell(criteria1Record.getAffiliated_YearTable1221().get(i).getInput1221v());
//			}
	//
//			 document.add(table1221);
//			 

			
			
			
			

			//122
			
			PdfPTable table1222 = new PdfPTable(2);
			table1222.setWidthPercentage(100);
			 PdfPTable table1220 = new PdfPTable(1);
			 table1220.setWidthPercentage(100); 
		     PdfPCell cell12221= new PdfPCell(new Paragraph("File Description",font3));
			 PdfPCell cell12222 = new PdfPCell(new Paragraph("Document",font3));
			 PdfPCell cell12223= new PdfPCell(new Paragraph("List of Add on /Certificate programs"));
			 PdfPCell cell12224 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(12).getCriteria1FilePath() :""));
			 PdfPCell cell12225= new PdfPCell(new Paragraph("Brochure or any other document relating to Add on\r\n"
			 		+ "/Certificate programs"));
			 PdfPCell cell12226 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(13).getCriteria1FilePath() :""));
			 PdfPCell cell12227= new PdfPCell(new Paragraph("Any additional information",font3));
			 PdfPCell cell12228 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(14).getCriteria1FilePath() :""));
			 PdfPCell cell12229= new PdfPCell(new Paragraph("Link for Additional information"));
			 PdfPCell cell12230 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(15).getCriteria1FilePath() :""));
			 table1222.addCell(cell12221);
			 table1222.addCell(cell12222);
			 table1222.addCell(cell12223);
			 table1222.addCell(cell12224);
			 table1222.addCell(cell12225);
			 table1222.addCell(cell12226);
			 table1222.addCell(cell12227);
			 table1222.addCell(cell12228);
			 table1222.addCell(cell12229);
			 table1222.addCell(cell12230);
//			 table1220.addCell(
//					"1.2.2 Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year).\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Record != null
//									? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse122()
//									: ""));
			 
			 PdfPCell cell4criteria1 = new PdfPCell(new Paragraph(
						"1.2.2 Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year)."+ "Response:"
								+ (criteria1Record != null? criteria1Record.getCriteria12Qn().get(0).getResponse122()
					: ""),font3));
			 table1222.addCell(cell4criteria1);
			 
			 
			 
			 table1220.addCell("1.2.2.1 Number of Programmes in which CBCS / Elective course system implemented.\r\n" + "\r\n"
					+ "Response:"
					+ (criteria1Record != null ? criteria1Record.getCriteria12Qn().get(0).getInput1221t1() : ""));

			 table1220.addCell(table1222);
			 table1220.setSpacingAfter(25f);
			document.add(table1220);
			
			//year table 1221
			Table table1221 = new Table(criteria1Record.getAffiliatedYearTable1221().size(), 2);

			table1221.setPadding(10);
			table1221.setWidth(100f);

			for (int i = 0; i < criteria1Record.getAffiliatedYearTable1221().size(); i++) {
				table1221.addCell(criteria1Record.getAffiliatedYearTable1221().get(i).getInput1221y());
			}
			for (int i = 0; i < criteria1Record.getAffiliatedYearTable1221().size(); i++) {
				table1221.addCell(criteria1Record.getAffiliatedYearTable1221().get(i).getInput1221v());
			}

			 document.add(table1221);
			 

			
			
			//123
			 PdfPTable table123 = new PdfPTable(2);
			 table123.setWidthPercentage(100);
			PdfPTable table1230 = new PdfPTable(1);
			table1230.setWidthPercentage(100);

					PdfPCell cell1231= new PdfPCell(new Paragraph("File Description",font3));
					PdfPCell cell1232 = new PdfPCell(new Paragraph("Document",font3));
					PdfPCell cell1233 = new PdfPCell(new Paragraph("Details of the students enrolled in Subjects related to certificate/Add-on programs"));
					PdfPCell cell1234 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(16).getCriteria1FilePath() :""));
					PdfPCell cell1235 = new PdfPCell(new Paragraph("Any additional information"));
					PdfPCell cell1236 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(17).getCriteria1FilePath() :""));
					table123.addCell(cell1231);
					table123.addCell(cell1232);
					table123.addCell(cell1233);
					table123.addCell(cell1234);
					table123.addCell(cell1235);
					table123.addCell(cell1236);
					table1230.addCell("1.2.3 Average percentage of students enrolled in Certificate/ Add-on programs as against the total\r\n"
							+ "number of students during the last five years\r\n");
							//+ "Response:"+ (criteria1Record != null? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse123():""));
					
					
					
					table1230.addCell("1.2.3.1 Number of students enrolled in subject related Certificate or Add-on programs year wise\r\n"
							+ "during last five years");
					
					table1230.addCell(table123);
					table1230.setSpacingAfter(20);
					table1230.setSpacingBefore(20);
					document.add(table1230);
					
					//year table 1231
					
				/*	Table table1231 = new Table(criteria1Record.getAffiliated_YearTable1231().size(), 2);

					table1231.setPadding(10);
					table1231.setWidth(100f);

					for (int i = 0; i < criteria1Record.getAffiliated_YearTable1231().size(); i++) {
						table1231.addCell(criteria1Record.getAffiliated_YearTable1231().get(i).getInput1231y());
					}
					for (int i = 0; i < criteria1Record.getAffiliated_YearTable1231().size(); i++) {
						table1231.addCell(criteria1Record.getAffiliated_YearTable1231().get(i).getInput1231v());
					}

					 document.add(table1231);*/
					 

					
					
					
			
			
	 
	        
	        
	        
	        //131
	        Paragraph paragraph1331 = new Paragraph("1.3  Curriculum Enrichment",font3);
			document.add(paragraph1331);
			
	        
	        PdfPTable table131 = new PdfPTable(2);
			table131.setWidthPercentage(100);
			 PdfPTable table1310 = new PdfPTable(1);
			 table1310.setWidthPercentage(100);
			
			PdfPCell cell131= new PdfPCell(new Paragraph("File Description",font3));
			PdfPCell cell132 = new PdfPCell(new Paragraph("Document",font3));
			
			PdfPCell cell133 = new PdfPCell(new Paragraph("Upload the list and description of courses which address the Professional Ethics, Gender, Human Values, Environment and Sustainability into theCurriculum.\r\n"
					+ ""));
			PdfPCell cell134 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(18).getCriteria1FilePath() :""));
			PdfPCell cell135 = new PdfPCell(new Paragraph("Any additional information"));
			PdfPCell cell136= new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(19).getCriteria1FilePath() :""));
			table131.addCell(cell131);
			table131.addCell(cell132);
			table131.addCell(cell133);
			table131.addCell(cell134);
			table131.addCell(cell135);
			table131.addCell(cell136);
			
//			table1310.addCell("1.3.1 Institution integrates crosscutting issues relevant to Professional Ethics ,Gender, Human\r\n"
//					+ "Values ,Environment and Sustainability into the Curriculum\r\n"
//					+ "Response: "+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQl().get(0).getResponse131():""));
			
			 
			 PdfPCell cell5criteria1 = new PdfPCell(new Paragraph(
						" 1.3.1 Institution integrates crosscutting issues relevant to Professional Ethics ,Gender, Human Values ,Environment and Sustainability into the Curriculum"+ "Response:"
								+ (criteria1Record != null ? criteria1Record.getCriteria13Ql().get(0).getResponse131():""),font3));
			 table131.addCell(cell5criteria1);
			 document.add(cell5criteria1);
			
			
			
			
			table1310.addCell("Jyothi Engineering College has taken impressive efforts to integrate cross cutting issues such as Gender,\r\n"
					+ "Environment and Sustainability, Human values and Professional Ethics wherever possible into the\r\n"
					+ "curriculum and more often by other indirect means.");
			
			table1310.addCell("* Jyothi ensures that equal opportunity is given to both genders in terms of admissions. Self Study\r\n"
					+ "Report of Jyothi Engineering College employment, and training programmes as a result of which\r\n"
					+ "gender issues generally do not arise.\r\n"
					+ " * Women’s Day Celebration has been conducted in association with WDC JEC.\r\n"
					+ "*  Institution ensures equal representation of students (both genders) in students union, course\r\n"
					+ "committee, class committee.");
			
			table1310.addCell("Natura Club of the college is functioning with a vision to make the college campus green and Ecofriendly. There are more than 30 species of trees including a wide range of traditional medicinal\r\n"
					+ "herbal plants in the campus based on Indian Knowledge System (IKS).\r\n"
					+ "We have various projects and publication related to sustainable development.\r\n"
					+ " An approved water testing laboratory Centre for Water Research and Education(CWRE) provides\r\n"
					+ "services to the people on remediation of various water issues such as water quality, water shortage,\r\n"
					+ "rain water harvesting, water treatment and with special focus on maintenance of domestic water\r\n"
					+ "sources of Kerala. \r\n"
					+ "Rain water harvesting facility with a pond of size 50m x 20m x 10m storage capacity.\r\n"
					+ "Grid connected Solar roof panel of 63.7kW power supply. This takes care of major part of the\r\n"
					+ "power supply we need.\r\n"
					+ "");
			table1310.addCell("* Introduction to sustainable engineering\r\n"
					+ " * Humanities\r\n"
					+ "* Engineering Geology\r\n"
					+ "* Economics and Business Management\r\n"
					+ " * Environmental Engineering and Disaster Management\r\n"
					+ " * Environmental Engineering 1\r\n"
					+ " * Geotechnical Engineering 1 & 2\r\n"
					+ "* Energy Conservation\r\n"
					+ "* Business Economics/Life Skills\r\n"
					+ "* Energy Management and auditing\r\n"
					+ "* Environmental Engineering");
			
			
			table1310.addCell(table131);
			table1310.setSpacingAfter(20);
			document.add(table1310);
			
			//132
			
			PdfPTable table1320 = new PdfPTable(2);
			table1320.setWidthPercentage(100);
			PdfPTable table13200 = new PdfPTable(1);
			table13200.setWidthPercentage(100);

			PdfPCell cell1321= new PdfPCell(new Paragraph("File Description",font3));
			PdfPCell cell1322 = new PdfPCell(new Paragraph("Document",font3));
			
			PdfPCell cell1323 = new PdfPCell(new Paragraph("Programme / Curriculum/ Syllabus of the courses\r\n"));
			PdfPCell cell1324 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(20).getCriteria1FilePath() :""));
			PdfPCell cell1325 = new PdfPCell(new Paragraph("MoU's with relevant organizations for these courses,\r\n"
					+ "if any Average percentage of courses that include\r\n"
					+ "experiential learning through project work/field\r\n"
					+ "work/internship\r\n"
					+ ""));
			PdfPCell cell1326= new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(21).getCriteria1FilePath() :""));
			PdfPCell cell1327 = new PdfPCell(new Paragraph("Minutes of the Boards of Studies/ Academic\r\n"
					+ "Council meetings with approvals for these courses\r\n"));
			PdfPCell cell1328 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(22).getCriteria1FilePath() :""));
			PdfPCell cell1329 = new PdfPCell(new Paragraph("Any additional information\r\n"));
			PdfPCell cell1330 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(23).getCriteria1FilePath() :""));
			
			table1320.addCell(cell1321);
			table1320.addCell(cell1322);
			table1320.addCell(cell1323);
			table1320.addCell(cell1324);
			table1320.addCell(cell1325);
			table1320.addCell(cell1326);
			table1320.addCell(cell1327);
			table1320.addCell(cell1328);
			table1320.addCell(cell1329);
			table1320.addCell(cell1330);
//			table13200.addCell("1.3.2 Average percentage of courses that include experiential learning through project work/field\r\n"
//					+ "work/internship during last five years\r\n"
//					+ "Response:"+(criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponseValue132(): ""));
			 
//			 PdfPCell cell6criteria1 = new PdfPCell(new Paragraph(
//						"1.3.2 Average percentage of courses that include experiential learning through project work/field work/internship during last five years"+ "Response:"
//								+ (criteria1Record != null ? criteria1Record.getCriteria13Ql().get(0).getResponseValue132(): ""),font3));
//			 table1320.addCell(cell6criteria1);
			 document.add(table1320);
			
			
			
			table13200.addCell("1.3.2.1 Number of courses that include experiential learning through project work/field\r\n"
					+ "work/internship year-wise during last five years");
			
			
			table13200.addCell(table1320);

			table13200.setSpacingAfter(20);
			
			document.add(table13200);
			
			
			
			//year table 1321

			Table table1321 = new Table(criteria1Record.getYearTable1321().size(), 2);

			table1321.setPadding(10);
			table1321.setWidth(100f);

			for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {
				table1321.addCell(criteria1Record.getYearTable1321().get(i).getInput1321y());
			}
			for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {
				table1321.addCell(criteria1Record.getYearTable1321().get(i).getInput1321v());
			}
			document.add(table1321);
			
			//133
			PdfPTable table133 = new PdfPTable(2);
			table133.setWidthPercentage(100);
			PdfPTable table1330 = new PdfPTable(1);
			table1330.setWidthPercentage(100);
			PdfPCell cell1331= new PdfPCell(new Paragraph("File Description",font3));
			PdfPCell cell1332 = new PdfPCell(new Paragraph("Document",font3));
			
			PdfPCell cell1333 = new PdfPCell(new Paragraph("List of programmes and number of students undertaking project work/field work/ /internships\r\n"
					+ "\r\n"));
			PdfPCell cell1334 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(24).getCriteria1FilePath() :""));
			
			PdfPCell cell1335 = new PdfPCell(new Paragraph("Any additional information\r\n"));
			PdfPCell cell1336 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(25).getCriteria1FilePath() :""));
			
			table133.addCell(cell1331);
			table133.addCell(cell1332);
			table133.addCell(cell1333);
			table133.addCell(cell1334);
			table133.addCell(cell1335);
			table133.addCell(cell1336);
			
			table1330.addCell("1.3.3 Percentage of students undertaking project work/field work/ internships (Data for the latest\r\n"
					+ "completed academic year\r\n"
					+ "Response: "+(criteria1Record != null ? criteria1Record.getCriteria12Qn().get(0).getInput1221t1() :""));
			
			table1330.addCell("1.3.3.1 Number of students undertaking project work/field work / internships\r\n"
					+ "Response:"+(criteria1Record != null ? criteria1Record.getCriteria12Qn().get(0).getInput1221t1():""));
			table1330.addCell(table133);
			table1330.setSpacingAfter(20);
			document.add(table1330);
			
			
			
			
			
			
			

			

		

			
			//141
			Paragraph paragraph1441 = new Paragraph("1.4 Feedback System",font3);
			document.add(paragraph1441);
			
			
			PdfPTable table141 = new PdfPTable(2);
			table141.setWidthPercentage(100);
			PdfPTable table1410 = new PdfPTable(1);
			table1410.setWidthPercentage(100);
			
			PdfPCell cell141 = new PdfPCell(new Paragraph("File Description",font3));
			PdfPCell cell142= new PdfPCell(new Paragraph("Document",font3));
			PdfPCell cell143= new PdfPCell(new Paragraph("Any additional information (Upload)"));
			PdfPCell cell144= new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(26).getCriteria1FilePath() :""));
			PdfPCell cell145 = new PdfPCell(new Paragraph("Action taken report of the Institution on feedbackreport as stated in the minutes of the Governing Council, Syndicate, Board of Management (Upload)"));
			PdfPCell cell146= new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(27).getCriteria1FilePath() :""));
			PdfPCell cell147 = new PdfPCell(new Paragraph("URL for stakeholder feedback report"));
			PdfPCell cell148 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(28).getCriteria1FilePath() :""));
			table141.addCell(cell141);
			table141.addCell(cell142);
			table141.addCell(cell143);
			table141.addCell(cell144);
			table141.addCell(cell145);
			table141.addCell(cell146);
			table141.addCell(cell147);
			table141.addCell(cell148);
			
//			table1410.addCell("1.4.1 Institution obtains feedback on the syllabus and its transaction at the institution from thfollowing stakeholders 1) Students 2)Teachers 3)Employers 4)Alumni\r\n"+"Response :" 
//			+(criteria1Record != null	? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse141():""));
			
			
			 PdfPCell cell7criteria1 = new PdfPCell(new Paragraph(
						"1.4.1 Institution obtains feedback on the syllabus and its transaction at the institution from thfollowing stakeholders 1) Students 2)Teachers 3)Employers 4)Alumni"+ "Response:"
								+(criteria1Record != null	? criteria1Record.getCriteria14Qn().get(0).getResponse141():""),font3));
			 table141.addCell(cell7criteria1);
			document.add(table141);
			
			
			
			
			table1410.addCell(table141);
			document.add(table1410);
			
			PdfPTable table142 = new PdfPTable(2);
			table142.setWidthPercentage(100);
			
			PdfPCell cell1421 = new PdfPCell(new Paragraph("File Description",font3));
			PdfPCell cell1422= new PdfPCell(new Paragraph("Document",font3));
			PdfPCell cell1423= new PdfPCell(new Paragraph("Upload any additional information"));
			PdfPCell cell1424= new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(29).getCriteria1FilePath() :""));
			PdfPCell cell1425= new PdfPCell(new Paragraph("URL for feedback report"));
			PdfPCell cell1426= new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(30).getCriteria1FilePath() :""));
			table142.addCell(cell1421);
			table142.addCell(cell1422);
			table142.addCell(cell1423);
			table142.addCell(cell1424);
			table142.addCell(cell1425);
			table142.addCell(cell1426);
			PdfPTable table14100 = new PdfPTable(1);
			table14100.setWidthPercentage(100);
			
			table14100.addCell("1.4.2 Feedback process of the Institution may be classified as follows: Options:\r\n"
					+ "1.Feedback collected, analysed and action taken and feedback available on website\r\n"
					+ "2.Feedback collected, analysed and action has been taken\r\n"
					+ "3.Feedback collected and analysed\r\n"
					+ "4.Feedback collected\r\n"
					+ "5. Feedback not collecte");
			
			table14100.addCell(table142);
			document.add(table14100);
			
			
			

			
			

			

			/*table12.addCell(cell121);
			table12.addCell(cell122);
			table12.addCell(cell123);
			table12.addCell(cell124);
			table12.addCell(cell125);
			table12.addCell(cell126);
			table12.addCell(cell127);
			table12.addCell(cell128);
			table121.addCell(
					"1.4.2 The feedback system of the Institution comprises of the following :\r\n" + "\r\n" + "Response:"
							+ (criteria1Record != null
									? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse142()
									: ""));

			table121.addCell(table12);
			table121.setSpacingBefore(25f);
			table121.setSpacingAfter(25f);

			document.add(table121);*/
			
			
			
			
			
			
			

	////////////////////////////////////////////////////
	///////////////////criteria 1 end..............
	/////////////////////////////////////////

		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}
	
	
	

}
