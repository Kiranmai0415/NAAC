//
//
//
//
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
//import com.adiverse.erp.model.Criteria6_FieldInfo;
//import com.adiverse.erp.model.Criteria6_FileUpload;
//import com.adiverse.erp.service.Criteria2Service;
//import com.adiverse.erp.service.Criteria4Service;
//import com.adiverse.erp.service.Criteria6Service;
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
//public class AffiliatedCriteria65Report {
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
//	Criteria6Service service6;
//	
//	
//	List<Criteria6_FieldInfo> criteria6List = null;
//	Criteria6_FieldInfo criteria6Record = null;
//	List<Criteria6_FileUpload> criteria6file = null;
//	
//	
//	public String generateReport(Criteria6_FieldInfo criteria6Fieldinfo) throws DocumentException, IOException {
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
//				reportPath = "AffiliatedCriteria6Report-" + strDate + ".pdf";
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
//			Paragraph paragraph1criteria6 = new Paragraph("Criterion 6 - Governance, Leadership and Management\r\n\r\n", font1);
//			paragraph1criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph1criteria6);
//
//			/*
//			 * com.lowagie.text.Font fontTitle0 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle0.setSize(12);
//			 */
//
//
//
//	//create a 6.5
//			Paragraph paragraph14criteria6 = new Paragraph("6.5	Internal Quality Assurance System\r\n\r\n\r\n", font2);
//			paragraph14criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph14criteria6);
//	//cretae table 13
//			PdfPTable table13criteria6 = new PdfPTable(1);
//			table13criteria6.setWidthPercentage(100);
//
//			Paragraph paragraph15criteria6 = new Paragraph(
//					"6.5.1 Internal Quality Assurance Cell (IQAC) has contributed significantly for institutionalizing the quality assurance strategies and processes visible in terms of � Incremental improvements made for the preceding five years with regard to quality (in case of first cycle) Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives (second and subsequent cycles)\r\n"
//							 + "Response");
//			
//			document.add(paragraph15criteria6);
//			
//			if(criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse651() !=null)
//			{
//			Paragraph paragraph16criteria6 = new Paragraph(criteria6Fieldinfo != null
//									? criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse651()
//									: "");
//			document.add(paragraph16criteria6);
//					
//		}
////			
////			PdfPCell cell130= new PdfPCell(new Paragraph(
////					(criteria6Record != null
////									? criteria6Record.getCriteria6FieldInfoQl().get(0).getInput651t1()
////									: ""),
////					font3));
//			
//			
////			table13criteria6.addCell(cell13x);
////	        table13criteria6.addCell(cell130);
////			document.add(table13criteria6);
//			
//	//create table 2reforms
//			PdfPTable table131criteria6 = new PdfPTable(2);
//			table131criteria6.setWidthPercentage(100);
//
//			PdfPTable table130criteria6 = new PdfPTable(1);
//			table130criteria6.setWidthPercentage(100);
//
//			PdfPCell cell131criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
//			PdfPCell cell132criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell133criteria6 = new PdfPCell(new Paragraph("Upload any additional information"));
//			PdfPCell cell134criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell135criteria6 = new PdfPCell(new Paragraph("Paste link for additional information"));
//			PdfPCell cell136criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")));
//			
//			table131criteria6.addCell(cell131criteria6);
//			table131criteria6.addCell(cell132criteria6);
//			table131criteria6.addCell(cell133criteria6);
//			table131criteria6.addCell(cell134criteria6);
//			table131criteria6.addCell(cell135criteria6);
//			table131criteria6.addCell(cell136criteria6);
//			document.add(table131criteria6);
////			table130criteria6.addCell(
////					"Internal Quality Assurance Cell (IQAC) of Mother Teresa has been in operation since 2012, initiating and conducting several activities to improve quality of both academic and administrative functions, in order to provide quality educational and service and experience for students, faculty and staff. During the last 5 years it has had 20 meetings and 80 resolutions. Among the practices initiated by IQAC, the following two have contributed to the quality enhancement.\r\n"
////							+ "\r\n" + "\r\n"
////							+ "Practice No. 1: Promoting research culture among faculty leading to increase in number and quality of publications/Patents:\r\n"
////							+ "\r\n" + "\r\n"
////							+ "IQAC in association with the R&D Cell, has been organizing FDPs/Seminars/Webinars/workshops on research methodology, IPR, creativity and innovation (during the last five years, 12 events were held), as well as encouraging faculty to attend such events conducted elsewhere (all put together 129 faculty participated). College also has been giving one day off per week for faculty to work on their PhD, based on the progress of their work.\r\n"
////							+ "\r\n" + "\r\n"
////							+ "Senior and experienced faculty with doctorate degree discuss with junior faculty, on the importance of obtaining doctorate for their career development, AICTE and UGC mandates for PhD degree, and subject- related research ideas and methodologies.\r\n"
////							+ "\r\n" + "\r\n"
////							+ "As a result of these initiatives of IQAC, during the last five years, 71 faculty members have registered for part time PhD. In addition, 8 more have registered for full time PhD. Faculty pursuing PhD as well as others about to register for PhD, have been working actively, on identified areas of research and this has paved way for an increase in the number of publications from 321 to 734 and Patents published from zero to 55. Eight teachers have obtained Ph.D degrees while working in the college.\r\n"
////							+ "\r\n" + "\r\n"
////							+ "Practice No. 2: Reforms in the Midterm examination question papers and assessment as per the Blooms Taxonomy levels:\r\n"
////							+ "\r\n" + "\r\n"
////							+ "Towards this, IQAC has initiated a process to assess the quality of midterm examination question papers and made significant improvements in the assessment of students aligning with the teaching-learning process and outcomes. Each department constituted a committee comprising the HoD/Program Coordinator, three senior faculty, course coordinator and one senior faculty from outside the department to look at various parameters in order to ensure that balanced question papers were prepared facilitating appropriate measurement of outcomes. IQAC designed a structured questionnaire in the form of a checklist (attached as additional document), and oriented faculty on the preparation of question paper and assess students� performance in fitment to the levels of Bloom�s Taxonomy. Guidelines were also given in regard to these levels for each of the four years of the BTech program as well as the PG programs. This has improved the quality of question papers and faculty are well acquainted on the appropriate implementation of OBE with usage of appropriate verbs vis-�-vis Bloom�s Taxonomy levels. This entire process has enabled better assessment of course outcomes, resulting in improvement of program outcomes, which is perceivable in the performance of graduates pursuing higher education and securing placements with higher pay packages.\r\n"
////							+ "");
////			table130criteria6.addCell(table131criteria6);
////			document.add(table130criteria6);
////			PdfPTable table14criteria6 = new PdfPTable(1);
////			table14criteria6.setWidthPercentage(100);
////			PdfPCell cell14x = new PdfPCell(new Paragraph(
////					"6.5.2 The institution reviews its teaching learning process, structures & methodologies of operations\r\n"
////					+ "and learning outcomes at periodic intervals through IQAC set up as per norms and recorded the\r\n"
////					+ "incremental improvement in various activities ( For first cycle - Incremental improvements made\r\n"
////					+ "for the preceding five years with regard to quality For second and subsequent cycles - Incremental\r\n"
////					+ "improvements made for the preceding five years with regard to quality and post accreditation\r\n"
////					+ "quality initiatives )\r\n"
////							+ "\r\n\r\n" + "Response:"
////							+ (criteria6Record != null
////									? criteria6Record.getCriteria6FieldInfoQn().get(0).getResponse652()
////									: ""),
////					font3));
////			
////			PdfPCell cell140 = new PdfPCell(new Paragraph(
////					(criteria6Record != null
////									? criteria6Record.getCriteria6FieldInfoQn().get(0).getInput652t1()
////									: ""),
////					font3));
////			
////			table14criteria6.addCell(cell14x);
////	        table14criteria6.addCell(cell140);
////			document.add(table14criteria6);
////	//create a table 141
////			PdfPTable table140criteria6 = new PdfPTable(1);
////			table140criteria6.setWidthPercentage(100);
////			table140criteria6.addCell(
////					"A detailed academic calendar that includes all academic activities is prepared much before commencement of each semester. Course allocation is done based on the expertise of the faculty. Timetables are prepared with dedicated time slots for regular class work/tutorials/remedial classes/seminars/mentoring/Training and Placement activities, and such others.\r\n"
////							+ "\r\n"
////							+ "Faculty prepare Teaching plan indicating topics with correlation to Course Outcomes (COs), Program Outcomes (POs) and Program Specific Outcomes (PSOs).\r\n"
////							+ "\r\n"
////							+ "All faculty submit Course files detailing various aspects including Lesson and Laboratory plan for conduct of theory and laboratory sessions in a well-defined format as specified by IQAC.\r\n"
////							+ "\r\n" + "I.	Implementation of Teaching-Learning reforms as initiated by the IQAC\r\n"
////							+ "\r\n"
////							+ "Mother Teresa�s conviction is that the course purpose induces students to deeply involve in their learning, which would lead to quality educational experiences, that would pave way in their professional career development. Towards this, IQAC prepared a detailed questionnaire for improving the quality of course file, giving utmost importance about the purpose of the course.\r\n"
////							+ "\r\n" + "Accordingly, IQAC has ensured that the following are described in course files:\r\n"
////							+ "\r\n"
////							+ " *  The role course plays within the Program, its uniqueness vis-�-vis other courses.\r\n"
////							+ " *  Essential knowledge/skills student gains from the course that would help to perform well in future classes/Higher Education progression/Jobs.\r\n"
////							+ " *  Prerequisite(s) for the course and specific knowledge/skills students need to know for their future career progression.\r\n"
////							+ " *  Unique contributions of the course to students� learning experience there by enriching the quality of the program, in particular, how student�s attitudes and higher-order thinking skills are developed.\r\n"
////							+ "\r\n"
////							+ "In the laboratory course, scientific enquiry and problem-solving skills are developed, which include:\r\n"
////							+ "\r\n" + " *  Defining a problem Formulating hypotheses\r\n"
////							+ " *  Designing, conducting experiments Collecting, interpreting data Testing hypotheses, if any,\r\n"
////							+ " *  Drawing inferences from conclusions\r\n"
////							+ " *  Communicating processes, outcomes and their implications\r\n" + " \r\n" + "");
////			table140criteria6.addCell(
////					"Prepared lesson plans are discussed with other faculty teaching the same course during Course Coordinator�s meetings. Curriculum is enriched with guest lectures, industrial visits and Internships. Students attendance and performance, continuously monitored by class adviser, mentor and faculty teaching various courses and students are apprised of the same during lectures, lab sessions, mentored and cautioned, whenever necessary.\r\n"
////							+ "\r\n" + "IQAC verifies the above through minutes of meetings of:\r\n" + "\r\n"
////							+ " *  CRC, Course Coordinator with faculty, Mentor-Mentee.\r\n"
////							+ " *  Quality of Guest Lectures etc.\r\n" + "\r\n"
////							+ "A continuous internal examination and evaluation system is in place.\r\n" + "\r\n"
////							+ "In tune with the outcome-based education approach, the question papers for the internal class tests prepared are evaluated by a question paper evaluation committee, following Bloom�s taxonomy, uniform distribution of questions vis-a-vis syllabus, enabling assessment of the attainment of Course Outcomes for each course.\r\n"
////							+ "\r\n"
////							+ "Parents are informed about their ward�s attendance on a daily basis and performance in examinations.\r\n"
////							+ "\r\n"
////							+ "Student feedback on TLP is taken twice a Semester, one immediately after three weeks of commencement of semester, final, just before conclusion of semester by IQAC through a structured questionnaire. It is reviewed by HoD, Dean, Academics and Principal, communicated to faculty. Faculty member with <70% feedback is counseled for improvement. On an average, 35-40 faculty have been mentored in each semester.\r\n"
////							+ "\r\n"
////							+ "II.	Institutional review - Internal and External Academic and Administrative Audit\r\n"
////							+ "\r\n"
////							+ "Mother Teresa strongly believes that peer review of our programs through feedback and audit (internal and external) help in strengthening our programs. Hence, feedback on several aspects is collected, analyzed and appropriate measures taken. Institution also conduct audit of our programs at the end of each academic year to sustain quality.\r\n"
////							+ "\r\n"
////							+ "Towards this, our IQAC has designed a meticulously planned framework detailing various processes starting from course allocation, preparing course file, teaching diary that contains record of classes conducted, topics discussed, student attendance record, mentoring book, weekly reports, class review meetings, and course coordinator�s meetings with faculty teaching same course to various other sections, guidelines for designing experiments, conduct of laboratory sessions, allocation of student projects and preparing question paper, minutes of Question Paper Evaluation Committee, Program Assessment Committee, etc.\r\n"
////							+ "\r\n"
////							+ "College Academic Committee periodically evaluates the effectiveness of TLP, pedagogical practices and processes outlined by IQAC. Students� learning in the form of knowledge absorption and content assimilation is regularly monitored by IQAC through an internal audit process:\r\n"
////							+ "\r\n" + "A. Internal Academic Audit\r\n" + "\r\n"
////							+ "All faculty members maintain academic record book (attendance register of students) and record daily\r\n"
////							+ " \r\n"
////							+ "lectures delivered, tutorial sessions, if any, practical/laboratory sessions conducted and other such activities performed. The academic record is periodically monitored by Course Coordinator/Group Head/HoDs by checking topics covered by faculty member. On the basis of this report, if syllabus coverage is not progressing satisfactorily as per schedule, the concerned faculty is advised to take extra classes to cover syllabus in time, which is ensured. The Head of the Department reviews various academic activities during department meetings, guides faculty members accordingly.\r\n"
////							+ "\r\n"
////							+ "IQAC has prepared a format to conduct internal academic audit across various departments after the conclusion of each academic year. The internal audit is conducted through senior faculty drawn from cross/ inter-departmental to evaluate efficacy of institution�s TLP and associated administrative aspects and reports on the findings of the committee are submitted, which are forwarded to the departments for taking necessary action. Departments subsequently submit Action Taken Report (ATR) to IQAC, which verifies against the findings submitted earlier, and if found satisfactory, files it, or else, departments are informed to take appropriate corrective measures.\r\n"
////							+ "\r\n" + "\r\n" + "B. External Academic Audit\r\n" + "\r\n" + "\r\n"
////							+ "The college�s IQAC has started administering external audit since the academic year 2018-19 by inviting senior academicians, with one for each department from other autonomous reputed colleges. Over and above, a former Principal/Dean of a reputed college is invited as the chairperson of the external audit team. External expert team visits all departments conducts audit for one complete day on the performance of the college�s TLP and associated administrative aspects as per the given format, shared at least a few weeks prior to the visit of the team. The team submits its report and departments take appropriate action on the findings of the report by submitting compliance.\r\n"
////							+ "" + "");
////			table140criteria6.addCell(table14criteria6);
////			document.add(table140criteria6);
////			PdfPTable table141criteria6 = new PdfPTable(2);
////			table141criteria6.setWidthPercentage(100);
////			PdfPCell cell141criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
////			PdfPCell cell142criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
////			PdfPCell cell143criteria6 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
////			PdfPCell cell144criteria6 = new PdfPCell(
////					new Paragraph((criteria6Record != null ? criteria6file.get(35).getCriteria6FilePath() : "")));
////			PdfPCell cell145criteria6 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
////			PdfPCell cell146criteria6 = new PdfPCell(
////					new Paragraph((criteria6Record != null ? criteria6file.get(36).getCriteria6FilePath() : "")));
////			
////			table141criteria6.addCell(cell141criteria6);
////			table141criteria6.addCell(cell142criteria6);
////			table141criteria6.addCell(cell143criteria6);
////			table141criteria6.addCell(cell144criteria6);
////			table141criteria6.addCell(cell145criteria6);
////			table141criteria6.addCell(cell146criteria6);
////			
////			document.add(table141criteria6);
////
////			// create table 15
////			PdfPTable table15criterion6 = new PdfPTable(1);
////			table15criterion6.setWidthPercentage(100);
//			Paragraph paragraph225criteria6 = new Paragraph(
//					new Paragraph("6.5.3	Quality assurance initiatives of the institution include:\r\n" + "\r\n"
//							+ "1.	Regular meeting of Internal Quality Assurance Cell (IQAC); Feedback collected, analysed and used for improvements\r\n"
//							+ "2.	Collaborative quality initiatives with other institution(s)\r\n"
//							+ "3.	Participation in NIRF\r\n"
//							+ "4.	Any other quality audit recognized by state, national or international agencies (ISO Certification\r\n"
//							+ "Response:"));
//					document.add(paragraph225criteria6);
//					
//					
//					Paragraph paragraph215criteria6 = new Paragraph(criteria6Fieldinfo != null
//									? criteria6Fieldinfo.getCriteria6FieldInfoQn().get(0).getResponse653()
//									: "");
//					
//					document.add(paragraph215criteria6);
////			table15criterion6.addCell(cell15x);
////			document.add(table15criterion6);
//			// cretae653
//			PdfPTable table151criterion6 = new PdfPTable(2);
//			table151criterion6.setWidthPercentage(100);
//			PdfPCell cell151 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//		
//			PdfPCell cell152 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell153 = new PdfPCell(new Paragraph("Paste web link of Annual reports of Institution\r\n"));
//			PdfPCell cell154 = new PdfPCell(
//					new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""));
//			PdfPCell cell155 = new PdfPCell(new Paragraph("Upload e-copies of the accreditations and certifications\r\n"));
//			PdfPCell cell156 = new PdfPCell(
//					new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""));
//			PdfPCell cell157 = new PdfPCell(new Paragraph("Any additional information\r\n"));
//			PdfPCell cell158 = new PdfPCell(
//					new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""));
//			PdfPCell cell159 = new PdfPCell(new Paragraph("Upload details of quality assurance initiatives of the institution\r\n"));
//			PdfPCell cell160 = new PdfPCell(
//					new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""));
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
//			//table151criterion6.addCell(cell161);
//			//table151criterion6.addCell(cell162);
//			table151criterion6.setSpacingBefore(10f);
//			document.add(table151criterion6);
//
//		
//			
//			
//			
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
