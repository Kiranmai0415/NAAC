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
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.pdf.CMYKColor;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//@Service
//public class AffiliatedCriteria72Report {
//
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//	
//
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//
//	@Autowired
//	Criteria7Service service7;
//	
//
//	
//	List<Criteria7_FieldInfo> criteria7List = null;
//	Criteria7_FieldInfo criteria7Record = null;
//	List<Criteria7_FileUpload> criteria7file = null;
//	
//	public String generateReport(Criteria7_FieldInfo criteria7Fieldinfo ) throws DocumentException, IOException {
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
//			criteria7List = service7.getAllCriteria7Data();
//			if (CollectionUtils.isNotEmpty(criteria7List)) {
//				criteria7Record = criteria7List.get(0);
//				criteria7file = criteria7Record.getCriteria7FileUpload();
//			} else {
//				criteria7Record = new Criteria7_FieldInfo();
//				criteria7file = new ArrayList<>();
//
//			}
//			
//
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AffiliatedCriteria7Report-" + strDate + ".pdf";
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
//			Paragraph paragraphcriteria7 = new Paragraph("Criterion 7 - Institutional Values and Best Practices\r\n\r\n",
//					font1);
//			paragraphcriteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			PdfPCell cell5criteria7 = new PdfPCell();
//			cell5criteria7.setPadding(5);
//			document.add(cell5criteria7);
//
//		
//			document.add(paragraphcriteria7);
//			
//
//			// 7.2 Best Practices
//			/*
//			 * Font fontParagraph2157 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2157.setSize(13);
//			 */
//			Paragraph paragraph46criteria7 = new Paragraph("7.2 Best Practices\r\n", font3);
//			document.add(paragraph46criteria7);
//
//			PdfPTable table721criteria7 = new PdfPTable(1);
//			table721criteria7.setWidthPercentage(100f);
//
//			
//
//			PdfPCell cell721criteria7 = new PdfPCell(new Paragraph(
//					"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format provided in the Manual.\r\n"
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse721()
//									: ""),
//					font3));
//			PdfPCell cell7210criteria7 = new PdfPCell(new Paragraph(
//					 (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getInput721t1()
//									: ""),
//					font3));
//			
//			
//
//			table721criteria7.addCell(cell721criteria7);
//			table721criteria7.addCell(cell7210criteria7);
//			
//			table721criteria7.setSpacingBefore(20);
//			table721criteria7.setSpacingAfter(20);
//	        document.add(table721criteria7);
//
//			// 7.2.1
//			/*
//			 * Font fontParagraph2159 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2159.setSize(12);
////			 */
////			Paragraph paragraph48criteria7 = new Paragraph(
////					"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format\r\n"
////							+ "provided in the Manual.\r\n" + "\r\n" + "Response: \r\n" + "\r\n"
////							+ "Best Practice No. I:\r\n" + "\r\n" + "Title of the practice:\r\n" + "\r\n"
////							+ "“Reduced class strength for improved student learning and employability”\r\n" + "\r\n"
////							+ "Objectives of the Practice" + "Response:"
////							+ (criteria7Record != null
////									? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse721()
////									: ""),
////					
////							
////							font3);
//			//document.add(paragraph48criteria7);
//			
////			PdfPCell cell7301criteria7 = new PdfPCell(new Paragraph(
////					"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC form atprovided in the Manual.Reduced class strength for improved student learning and employability Objectives of the Practice \r\n"
////							+ "\r\n" + "Response:"
////							+ (criteria7Record != null
////									? criteria7Record.getCriteria7FieldInfoQl().get(0).getResponse721()
////									: ""),
////					font3));
////			
////			document.add(cell7301criteria7);
////			
////			
////			PdfPCell cell73001criteria7 = new PdfPCell(new Paragraph(
////					"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC form atprovided in the Manual.Reduced class strength for improved student learning and employability Objectives of the Practice \r\n"
////							+ "\r\n" + "Response:"
////							+ (criteria7Record != null
////									? criteria7Record.getCriteria7FieldInfoQl().get(0).getInput721t1()
////									: ""),
////					font3));
////			
////			document.add(cell73001criteria7);
////			
//	//	
//			
//			
//			
//			/*
//			 * Font fontParagraph2160 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2160.setSize(12);
//			 */
////			Paragraph paragraph49criteria7 = new Paragraph("Enhance student-teacher interactions in labs/classes\r\n"
////					+ "Quicker feedback as faculty devote more time assessing students’ assignments, laboratory/project work/tutorials for improved performance.\r\n"
////
////					+ "Enhanced learning experience through increased one to one participation among students and with faculty, especially in labs/tutorial sessions\r\n"
////					+ "More opportunities to learn from peers, augmenting collaborative and cooperative learning\r\n"
////					+ "More discipline and control over the class leading to increased student engagement With increased interaction among classmates, students gain quality learning experience."
////
////					, font5);
////			document.add(paragraph49criteria7);
//////							
////			/*
////			 * Font fontParagraph2165 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph2165.setSize(12);
////			 */
////
////			Paragraph paragraph51criteria7 = new Paragraph("Facilitate:", font3);
////			document.add(paragraph51criteria7);
////
////			/*
////			 * Font fontParagraph2167 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph2167.setSize(12);
////			 */
////
////			Paragraph paragraph52criteria7 = new Paragraph(
////					"Comfortable seating arrangements\r\n" + "Improved Elbow-room to better manoeuvrability\r\n"
////							+ "Improved personal space\r\n" + "Better Student to Faculty ratio\r\n"
////							+ "enabling higher levels of student focus, eventually leading to improved performance.",
////					font5);
////			document.add(paragraph52criteria7);
////
////			/*
////			 * Font fontParagraph2166 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph2166.setSize(12);
////			 */
////
////			Paragraph paragraph53criteria7 = new Paragraph("The Context" + "/r/n", font3);
////			document.add(paragraph53criteria7);
////
////			/*
////			 * Font fontParagraph2168 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph2168.setSize(12);
////			 */
////
////			Paragraph paragraph54criteria7 = new Paragraph(
////					"“When classes are small enough to allow individual student-teacher interaction, a minor miracle\r\n"
////							+ "occurs: Teachers teach and students learn”",
////					font3);
////			document.add(paragraph54criteria7);
////
////			/*
////			 * Font fontParagraph2169 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph2169.setSize(12);
////			 */
////
////			Paragraph paragraph55 = new Paragraph("– Lou Anne Johnson, teacher whose life inspired the movie,\r\n"
////					+ "“Dangerous Minds”\r\n"
////					+ "Of late, it has been observed that students’ focus and attention span is waning due to various factors:\r\n"
////					+ "digital media/technology, nuclear families leading to majority of students needing personal attention and many such others.\r\n"
////					+ "Further, adolescence, acting as a catalyst, has necessitated need for ebhanced individual attention.\r\n"
////					+ "In this context, faculty need to understand student psychology, enable learning through close monitoring,\r\n"
////					+ "actively engaging, promoting originality/creativity, innovation, inculcating high-level analytical/logical\r\n"
////					+ "thinking skills, leading a path to exploration and providing quicker feedback on learning. This also\r\n"
////					+ "facilitates learner-centric approach, can be better put into practice, with smaller class sizes than larger ones.\r\n"
////					+ "Incidentally, effective mentoring of student can be conducted making student realize his/her true potential\r\n"
////					+ "leading to higher levels of performance." + "r/n", font5);
////
////			document.add(paragraph55);
////
////			/*
////			 * Font fontParagraph2170 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph2170.setSize(12);
////			 */
////
////			Paragraph paragraph56 = new Paragraph("The Practice" + "/r/n", font3);
////			document.add(paragraph56);
////			/*
////			 * Font fontParagraph2171 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph2171.setSize(12);
////			 */
////
////			Paragraph paragraph57 = new Paragraph(
////					"A few of our faculty who have studied and worked in universities abroad, have experienced that\r\n"
////							+ "coursework in a class with smaller number of students is congenial for reaching out to the needs of\r\n"
////							+ "students, ensuring greater individualization of instruction, better classroom control and, thus, better\r\n"
////							+ "learning ambience. Instructors have individual interactions with students, consulting with parents, giving\r\n"
////							+ "greater attention to students’ work. Class size is an important determinant of student outcomes.\r\n"
////							+ "Keeping this in view, in CSE and ECE classes, each section having 240 students, we have reduced the\r\n"
////							+ "class strength to 45-48 students per section instead of the normal 60 -66 students.\r\n"
////							+ "Towards this, departments have identified the requirement of additional faculty and infrastructure facilities.\r\n"
////							+ "Accordingly, the institution has recruited more faculty, and increased infrastructure facilities. This practice\r\n"
////							+ "has been adopted starting with the admitted batch of 2016-17 academic year soon after the college was\r\n"
////
////							+ "granted autonomous status.\r\n"
////							+ "Our classes have three-seater benches with six rows and four columns, capable of accommodating 72\r\n"
////							+ "students. However, we have ensured that the middle seat in each bench is kept vacant ensuring that\r\n"
////							+ "students have a more comfortable seating comfort needed since students spend nearly 6/7 hours a day. This\r\n"
////							+ "also ensures adequate social distancing, especially required during the pandemic and beyond. It also\r\n"
////							+ "reduces cross-talk, thereby noise in the classroom, thereby ensuring better class-room\r\n"
////							+ "management. Reduced class size also benefits slow learners and disadvantaged students hailing from rural\r\n"
////							+ "background" + "/r/n",
////					font5);
////			document.add(paragraph57);
////
////			/*
////			 * Font fontParagraph2172 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph2172.setSize(12);
////			 */
////
////			Paragraph paragraph58 = new Paragraph("Consequences:" + "/r/n", font3);
////			document.add(paragraph58);
////
////			/*
////			 * Font fontParagraph2173 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph2173.setSize(12);
////			 */
////
////			Paragraph paragraph59 = new Paragraph(
////					"Nearly 25% of faculty have been increased in CSE and ECE departments and the expenditure on salaries\r\n"
////							+ "also have increased by 1.5 crore rupees/year. Over and above, operational expenditure on labs, in terms of\r\n"
////							+ "consumables, equipment maintenance and repair, and electricity charges has increased.Expenditure on\r\n"
////							+ "civil infrastructure and class room furniture also increased, for which budgetary provisions have been made\r\n"
////							+ "and approved by the college." + "\r\n",
////					font5);
////			document.add(paragraph59);
////
////			/*
////			 * Font fontParagraph2175 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph2175.setSize(12);
////			 */
////
////			Paragraph paragraph60 = new Paragraph("Evidence of Success \r\n"
////					+ "Ever since the academic year 2016-17, class size kept as 45-48, our graduate outcomes have\r\n"
////					+ "improved. More students have been participating in co-curricular activities, namely,\r\n"
////					+ "Project/Problem-based learning, paper/poster presentations, creative/innovative activities,\r\n"
////					+ "Hackathons, programming contests and student club activities leading to increased campus\r\n"
////					+ "placements with higher pay package. \r\n"
////					+ "Students have designed and built several prototypes, developing", font5);
////			document.add(paragraph60);
////
////			/*
////			 * Font fontParagraph2176 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph2176.setSize(12);
////			 */
////
////			Paragraph paragraph61 = new Paragraph("collaborative/cooperative learning in\r\n"
////					+ "groups, discussing ideas, exchanging views/thoughts and listening to ideas of others with open mind\r\n"
////					+ "resulted in Mother Teresa securing a rank of 4 STAR in MHRD-IIC, EXCELLENT band in ARIIA and few\r\n"
////					+ "start-ups.", font5);
////			document.add(paragraph61);
////
////			/*
////			 * Font fontParagraph2177 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph2177.setSize(12);
////			 */
////
////			Paragraph paragraph62 = new Paragraph(
////					"Reduction in class size also facilitated reduced workload on teachers as they need to mentor, assess\r\n"
////							+ "lesser number of students’ work, resulting in teacher spending quality time ensuring better and\r\n"
////							+ "improved learning experience for students leading to enhanced graduate outcomes and\r\n"
////							+ "employability. \r\n" + "\r\n" + "Problems Encountered and Resources Required",
////					font5);
////			document.add(paragraph62);
////
////			/*
////			 * Font fontParagraph2178 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph2178.setSize(12);
////			 */
////
//////			Paragraph paragraph63 = new Paragraph(
//////					"Implemented smaller class sizes in CE, EEE and ME, also for one academic year. Unfortunately,\r\n"
//////							+ "admissions in these are low in first year. However, lateral entry students join in second year, filling vacant\r\n"
//////							+ "seats of first year. While reducing class size, increasing sections in second year, distribution of students in\r\n"
//////							+ "order of merit/skills into another section needed students grouped earlier to be divided further. Parents and\r\n"
//////							+ "students complained as students by then have developed rapport/friendship with some and were reluctant\r\n"
//////							+ "to move. Hence, discontinued this in these disciplines.\r\n"
//////							+ "Identifying and recruiting senior teachers, especially, domain experts in emerging areas of CSE, as several\r\n"
//////							+ "colleges simultaneously started the same. Requires extensive training of existing faculty as well\r\n"
//////							+ "as recruiting faculty available. \r\n" + "Page 115/129 13-08-2022 02:30:33\r\n"
//////							+ "More Infrastructure, more faculty required, especially, senior teachers for second- and third-year classes\r\n"
//////							+ "requiring more financial resources. Unfortunately, additional faculty salary is not considered while fixing\r\n"
//////							+ "tuition fee by Government." + "/r/n",
//////					font5);
//////			document.add(paragraph63);
//////
////		/*
////			 * Font fontParagraph2179 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph2179.setSize(12);
////			 */
////
////			Paragraph paragraph64 = new Paragraph("Notes (Optional)\r\n" + "", font3);
////			document.add(paragraph64);
//
//			/*
//			 * Font fontParagraph2180 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2180.setSize(12);
//			 */
//
////			Paragraph paragraph65 = new Paragraph(
////					"It is suggested that other colleges may choose to adopt this practice in a stepwise manner, initially in the\r\n"
////							+ "departments in which strong faculty are available, carving a niche for the department, and then extend it to\r\n"
////							+ "other departments as this practice not only enhances overall skill set of students but also promotes a culture\r\n"
////							+ "of innovative spirit which in the long run may result in the establishment of many start-ups for promoting\r\n"
////							+ "Atmanirbhar/Make in India movement for sustainable development." + "/r/n" + "/r/n",
////					font5);
////			document.add(paragraph65);
////
////			/*
////			 * Font fontParagraph2181 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph2181.setSize(12);
////			 */
////
////			Paragraph paragraph66 = new Paragraph("Best practice No. II:\r\n" + "Title of the practice\r\n"
////					+ "Decentralized departmental administration for improved scholarly academic/research\r\n"
////					+ "Objectives of the Practice" + "/r/n", font5);
////			document.add(paragraph66);
//
//			/*
//			 * Font fontParagraph2185 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2185.setSize(12);
//			 */
//
////			Paragraph paragraph67criteria7 = new Paragraph(
////					"Mother Teresa passionately believes that faculty is at the heart of all its Teaching-learning operations.\r\n"
////							+ "Attitudes of the teachers lie at the epicenter of significant innovation in education. The beliefs,\r\n"
////							+ "assumptions, and feelings of our teachers are the crux of our learning environment, thereby determining the\r\n"
////							+ "quality of life for students:"
////							// bullet
////							+ "Faculty development through a healthy mentor-mentee relationship\r\n"
////							+ "More learning opportunities for faculty, facilitating career progression\r\n"
////							+ "Ease of administration and functioning of department through decentralization\r\n"
////							+ "Establishment of second rung leadership in various specializations\r\n"
////							+ "Quality learning experience for students and faculty with satisfaction\r\n"
////							+ "Better resource managemen\r\n",
////					font5);
////			document.add(paragraph67criteria7);
//
//			/*
//			 * Font fontParagraph2186 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2186.setSize(12);
//			 */
//
////			Paragraph paragraph68 = new Paragraph("The Context\r\n");
////			document.add(paragraph68);
////
//		/*
//			 * Font fontParagraph2187 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2187.setSize(12);
////			 */
////
////			Paragraph paragraph69 = new Paragraph(
////					"Higher pay packages in industry luring the cream of young talent resulting mostly in less talented\r\n"
////							+ "professionals opting for teaching. Further, enormous increase in number of institutions, increased\r\n"
////							+ "divergency in many fields, resulting in more super specializations due to fast changing technological\r\n"
////							+ "advancements, lead to requirement for creation of good talent among professionals opting for teaching, by\r\n"
////							+ "nurturing them on nuances of teaching, being creative, innovative and updating themselves through\r\n"
////							+ "research. Meeting these challenges, Mother Teresa has structured each department into four/five\r\n"
////							+ "specializations with one senior faculty, a few more middle level faculty as mentors and four/five junior\r\n"
////							+ "faculty as mentees. In doing so, addressed a few teething problems.\r\n"
////							+ "Time constraint: Each faculty member has fixed workload. Fruitful discussions between mentormentee, call for allotted common free time during/after working hours making this an onerous task.\r\n"
////							+ "Apprehensions of faculty regarding exposure of their weaknesses, if any:");
////			document.add(paragraph69);
//
//			/*
//			 * Font fontParagraph2188 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2188.setSize(12);
//			 */
//
////			Paragraph paragraph70 = new Paragraph("The Practice", font3);
////			document.add(paragraph70);
//
//			/*
//			 * Font fontParagraph2189 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2188.setSize(12);
//			 */
////
////			Paragraph paragraph71 = new Paragraph(
////					"Each department is structured into four/five groups as per specializations.\r\n"
////							+ "Each group is led by a professor (Group Head) in the corresponding specialization, with 2/3 well\r\n"
////							+ "experienced faculty identified as lead faculty.\r\n"
////							+ "Group Head along with lead faculty act as Mentors for other faculty of the group, interacting closely,\r\n"
////							+ "guiding them in their academic and research pursuits.\r\n",
////					font5);
////			document.add(paragraph71);
////
////			/*
////			 * Font fontParagraph2190 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph2190.setSize(12);
////			 */
////
////			Paragraph paragraph72 = new Paragraph("Facilitating quality teaching/r/n", font3);
////			document.add(paragraph72);
//
//			/*
//			 * Font fontParagraph2191 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2191.setSize(12);
//			 */
//
////			Paragraph paragraph73 = new Paragraph(
////					"Group head along with lead faculty meets mentee faculty at least twice a week and discusses with them on\r\n"
////							+ "preparation of a good lesson plan, establishing creative and innovative experiments, projects, giving handson exposure to students, conduct of student mentoring and use of modern tools, to name a few. Group head\r\n"
////							+ "also suggests faculty to attend FDPs/FIPs/workshops, Lectures of eminent teachers within/outside the\r\n"
////							+ "college in order to understand and practice various pedagogies.\r\n" + "",
////					font5);
////			document.add(paragraph73);
//
//			/*
//			 * Font fontParagraph2192 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2192.setSize(12);
//			 */
//
////			Paragraph paragraph74 = new Paragraph("Curricular development", font3);
////			document.add(paragraph74);
//
//			/*
//			 * Font fontParagraph2193 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2193.setSize(12);
//			 */
//
////			Paragraph paragraph75 = new Paragraph(
////					"Group head and lead faculty during their close interaction, identify overlapping components in the curriculum pertaining to their group and recommend for merger of courses, if any, as well as introduction\r\n"
////
////							+ "of new courses including electives in emerging areas to the Board of Studies. Identify emerging trends in industry, propose value-added courses for students to improve their skills."
////							+ "",
////					font5);
////			document.add(paragraph75);
////
////			/*
////			 * Font fontParagraph2194 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph2194.setSize(12);
////			 */
////
////			Paragraph paragraph76 = new Paragraph("Inculcating an improved research culture" + "\r\n", font3);
////			document.add(paragraph76);
//
//			/*
//			 * Font fontParagraph2195 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2195.setSize(12);
//			 */
//
////			Paragraph paragraph77 = new Paragraph(
////					"Group head motivates junior faculty to pursue research, connects them to a network of researchers encourages to present seminars on research topics pertaining to the group by updating themselves, thereby,\r\n"
////
////							+ "facilitating in the identification of research guides, platforms for publication of research and establishment of research culture within the group\r\n"
////
////							+ "Group head helps faculty in implementing group’s long range plan in the development of \"Courses with diversity/multidisciplinary competence.\r\n"
////							+ "Global awareness and predicting technological advances, if any.Also suggests mentees to conform to international standards of all course offerings pertaining to the\r\n"
////
////							+ "division. Helps them in the identification of high-end equipment, hardware/software for procurement.\r\n"
////							+ "",
////					font5);
////			document.add(paragraph77);
//
//			/*
//			 * Font fontParagraph2196 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2196.setSize(12);
//			 */
//
////			Paragraph paragraph78 = new Paragraph("Identifying talent and development of leadership qualities");
////			document.add(paragraph78);
//
//			/*
//			 * Font fontParagraph2197 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2197.setSize(12);
//			 */
//
////			Paragraph paragraph79 = new Paragraph(
////					"It has also been facilitating in the creation of a fairly good talent pool and establishment of a second rung\r\n"
////							+ "leadership in various specializations of the department providing value added teaching learning process\r\n"
////							+ "and inculcating research culture, also enabling smooth administration/functioning of the department.\r\n"
////							+ "Junior faculty have also been able to associate themselves with all departmental/college’s cultural, and\r\n"
////							+ "other activities promoting a healthy collegial spirit among themselves, thereby facilitating the\r\n"
////
////							+ "administration in the development of potential leaders and identification of talent\r\n");
////			document.add(paragraph79);
//
//			/*
//			 * Font fontParagraph2199 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2199.setSize(12);
//			 */
//
////			Paragraph paragraph80 = new Paragraph("Evidence of Success\r\n" + "");
////			document.add(paragraph80);
//
//			/*
//			 * Font fontParagraph2100 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2100.setSize(12);
//			 */
//
////			Paragraph paragraph81 = new Paragraph(
////					"The above structure, kept in place since January 2017, has been bringing incremental improvements in the\r\n"
////							+ "teaching-learning process of theory courses, laboratory instruction, project/problem-based learning, student\r\n"
////							+ "participation in coding competitions, Hackathons and project exhibitions leading to development of prototypes. Faculty research publications and patents filed also improved.\r\n"
////
////							+ "This structure has been promoting a healthy mentor-mentee relationship among faculty, providing more learning opportunities for junior faculty\r\n"
////
////							+ "/r/n",
////					font5);
//		//	document.add(paragraph81);
//			/*PdfPTable table33criteria7 = new PdfPTable(6);
//			table33criteria7.setWidthPercentage(100);
//
//			com.lowagie.text.Font font41 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font41.setColor(CMYKColor.BLACK);
//			PdfPCell cell191 = new PdfPCell(new Paragraph("S.No."));
//			PdfPCell cell201 = new PdfPCell(new Paragraph("Item/AY"));
//			PdfPCell cell211 = new PdfPCell(new Paragraph("2016-17"));
//
//			PdfPCell cell221 = new PdfPCell(new Paragraph("2017-18 "));
//
//			PdfPCell cell231 = new PdfPCell(new Paragraph("2018-19"));
//			PdfPCell cell124criteria7 = new PdfPCell(new Paragraph("2019-20"));
//
//			table33criteria7.addCell(cell191);
//			table33criteria7.addCell(cell201);
//			table33criteria7.addCell(cell211);
//			table33criteria7.addCell(cell221);
//			table33criteria7.addCell(cell231);
//			table33criteria7.addCell(cell124criteria7);
//
//			document.add(table33criteria7);*/
//
//			/*
//			 * Font fontParagraph2101 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2101.setSize(12);
//			 */
//			// table118
////			Paragraph paragraph82 = new Paragraph("Problems Encountered and Resources Required" + "/r/n");
////			document.add(paragraph82);
//
//			/*
//			 * Font fontParagraph2102 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2101.setSize(12);
//			 */
//
////			Paragraph paragraph83 = new Paragraph(
////					"No takers for certain specializations and few specializations have high demand.Attaching mentees to mentors based on research interests/specializations is increasingly becoming a tough\r\n"
////
////							+ "task, making some faculty members feeling jittery.Also sometimes resulting in unavailability of mentors in some specific areas/specializations, although more\r\n"
////
////							+ "junior faculty showing keen interest to pursue their research/offering courses in those specializations. It’s\r\n"
////							+ "because research areas of some mentors are not in emerging areas. Also, many group heads/senior faculty are bogged down with administrative responsibilities.\r\n",
////					font5);
////			document.add(paragraph83);
//			/*
//			 * Font fontParagraph2103 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2103.setSize(12);
//			 */
//
////			Paragraph paragraph84 = new Paragraph("Resources required\r\n", font3);
////			document.add(paragraph84);
//
//			/*
//			 * Font fontParagraph2104 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph2104.setSize(12);
//			 */
//
////			Paragraph paragraph85 = new Paragraph("Competent faculty working in emerging areas\r\n"
////					+ "Adequate discussion rooms for each department\r\n"
////					+ "Seminar halls and research labs for each specialization/department\r\n"
////					+ "Adequate transportation facilities for faculty working late hours.\r\n"
////					+ "Recruitment of faculty and staff with administrative experience involving accreditations/affiliations\r\n"
////					+ "to reduce administrative load on group heads for increased mentor-mentee interaction for further\r\n"
////					+ "improvement of publications, patents and quality learning experience for all" + "\r\n", font5);
////			document.add(paragraph85);
////			document.add(paragraph85);
//
//			// document
//
//			/*
//			 * Font fontParagraph2105 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2105.setSize(12);
//			 */
//
////			Paragraph paragraph86 = new Paragraph("Notes (Optional)" + "\r\n", font5);
////			document.add(paragraph86);
//
//			/*
//			 * Font fontParagraph98 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph98.setSize(12);
//			 */
////			Paragraph paragraph87 = new Paragraph(
////					"This practice adopted by Mother Teresa can be replicated in other institutions as well. \r\n"
////							+ "Whenever parent institution finds itself relatively weak in some areas,may choose networking with other institutions where strong mentors with proven credentials are available.\r\n"
////
////							+ "This facilitates organization of FDPs/FIPs, collaborative research proposals, doctoral research guidance,creative and innovative projects by students and sharing of resources for a mutually beneficial outcome.\r\n"
////
////							+ "When this sort of networking takes place between institutions it can also facilitate several other activities,adoption of procedures and other institution’s best practices making both the institutions flourish. A group\r\n"
////
////							+ "of institutions may also come forward by networking together forming a consortium of institutions for enhancing faculty competences\r\n",
////					font5);
////			document.add(paragraph87);
//			// table5
//			PdfPTable table5criteria7 = new PdfPTable(2);
//			table5criteria7.setWidthPercentage(100);
//
//			PdfPCell cell1110 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n",font3));
//			PdfPCell cell1134 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n",font3));
//			PdfPCell cell1135 = new PdfPCell(new Paragraph("Best practices in the Institutional web site\r\n\r\n\r\n "));
//			PdfPCell cell1136 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//			PdfPCell cell1137 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n "));
//			PdfPCell cell1138 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
//
//			table5criteria7.addCell(cell1110);
//			table5criteria7.addCell(cell1134);
//			table5criteria7.addCell(cell1135);
//			table5criteria7.addCell(cell1136);
//			table5criteria7.addCell(cell1137);
//			table5criteria7.addCell(cell1138);
//			table5criteria7.setSpacingBefore(20f);
//			table5criteria7.setSpacingAfter(20f);
//
//			document.add(table5criteria7);
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
//		
//	}
//	
//
