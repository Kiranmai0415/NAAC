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
//public class AffiliatedCriteria73Report {
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
//			// 7.3
//			/*
//			 * Font fontParagraph2106 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph2106.setSize(12);
//			 */
//
//			Paragraph paragraph88 = new Paragraph("7.3 Institutional Distinctiveness \r\n", font3);
//			document.add(paragraph88);
//
//		
//
//			PdfPTable table731criteria7 = new PdfPTable(1);
//			table731criteria7.setWidthPercentage(100f);
//
//			/*
//			 * com.lowagie.text.Font fontcriteria7 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontcriteria7.setColor(CMYKColor.BLACK);
//			 */
//
//			PdfPCell cell731criteria7 = new PdfPCell(new Paragraph(
//					"7.3.1 Portray the performance of the Institution in one area distinctive to its priority and thrust within 1000 words\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getResponse731()
//									: ""),
//					font3));
//			
//			
//			PdfPCell cell7310criteria7 = new PdfPCell(new Paragraph(
//					 (criteria7Fieldinfo != null
//									? criteria7Fieldinfo.getCriteria7FieldInfoQl().get(0).getInput731t1()
//									: ""),
//					font3));
//			
//			
//			
//
//			table731criteria7.addCell(cell731criteria7);
//			table731criteria7.addCell(cell7310criteria7);
//			table731criteria7.setSpacingBefore(20);
//			table731criteria7.setSpacingAfter(20);
//	        document.add(table731criteria7);
//
//			// paragraph
//
//			/*
//			 * Font fontParagraph324 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph324.setSize(12);
//			 */
//
////			Paragraph paragraph90 = new Paragraph(
////					"The first PEO of all programs of Mother Teresa is gainful employment or pursuit of higher education.Gainful employment is essentially facilitating students in securing a good job while studying in college, which we\r\n"
//	//
////							+ "are coining it as ‘Campus Placements’. This is an area of utmost priority for any professional college and so is the priority for Mother Teresa. In this context, Mother Teresa has been doing exceedingly well in terms of\r\n"
//	//
////							+ "getting the students placed in many IT and IT-enabled service (ITES) companies, namely, TCS, Wipro,Cognizant, Accenture, and others.\r\n"
////							+ ""
////							+ "Any parent and his/her ward always look for quality education coupled with a good placement. Mother Teresahas, therefore, designed its curricula, adopted teaching learning process, has been executing a meticulouslyplanned and structured training program, with a sharp focus on improving not only the number ofplacements but also quality of placements, particularly in terms of the salary package and reputation of thecompany, which is, Mother Teresa’s thirst and thrust.\r\n"
////							+ "Keeping this in view, skills namely, problem-solving, critical-thinking, logical-reasoning, programming,creativity, innovation communication and interpersonal skills, which employers look for in freshengineering graduates. College has undertaken several initiatives to impart these skills to students. Apartfrom strengthening the core teaching-learning process, which is the backbone of any college, Mother Teresahas been continuously striving in facilitating and supporting in the honing of the following skills among\r\n"
////							+ "students:\r\n" + "Basic programming skills\r\n" + "Advanced programming skills\r\n"
////							+ "Quantitative aptitude development\r\n" + "Critical thinking and logical reasoning\r\n"
////							+ "Verbal ability, creative and situational writing\r\n" + "Soft skills\r\n"
////							+ "Even though students of all engineering branches study Programing and Problem-solving using C language during their first year of engineering, non-CSE (ECE, EEE, ME, CE) students tend to lose touch with programming as they progress in their respective branch of engineering since they do not apply and use programming to solve problems pertaining to their engineering courses. As programming is now considered not only a necessary skill to be employable, but also a life skill, Mother Teresa has been encouraging faculty and students of all engineering branches to integrate programming into their regularlaboratory work and assignments in various courses, wherever possible.Mother Teresa has associated with professional third-party vendors to facilitate students with the necessary programming skills, mainly planned for targeted improvement of their employability opportunities.\r\n"
////							+ "Students from all branches of engineering, eligible for placements, are given training to refresh and enhance their programming skills. This usually takes place during the sixth (6th) semester and following summer vacation, just before the placement season begins in the first semester of their final year.It is observed that focused training in programming, sometimes designing and scheduling a mock placement drive for a specific company, has immensely helped students to get placed in higher numbers.\r\n"
////							+ "It is heartening to note that Mother Teresa has consistently done well in terms of placements in IT and ITES companies, with pay packages varying between 3.6 LPA and 4.5 LPA. However, the number of placements with product-based companies, wherein the pay packages are 5LPA – 10LPA and above is viewed as the hallmark of any good college. Keeping this in view, and with the strong placement record in IT and ITES companies, the next logical step is to aim at helping the students to develop the necessary skills to get selected in such companies that offer much higher pay packages. Most product-based companies, in addition to testing the students in their aptitude, also examine their higher order programming and problem-solving skills. Consequent to this thought process, we roped in\r\n"
////							+ "another third party premier training organization with proven track record, to impart necessary skills to get a job in product-based companies such as Amazon, Microsoft, DE Shaw etc., to train around 150 students, selected out of nearly 800, and started enhancing their advanced data structures, algorithms and problem solving skills since the academic 2020-21. The impact of this advanced training program is clearly visible in the increased number of placements for the 2021 and outgoing batches in product-based companies. For the 2023 outgoing batch of students, the training has commenced in their Third year second semester in order to provide ample time to hone their skills and also practice a large number of problems long before the placements season begins in July, 2022.\r\n"
////							+ "Some companies like Cognizant and Virtusa for example, have started hiring fresh engineering graduates in specialized roles such as Data Scientist, IoT Engineer, full Stack Developer and UI developer, Cloud Engineer etc. The students are expected to demonstrate significant skills in those areas at the time of recruitment.\r\n"
////							+ "Even though the current curriculum of CSE and IT branches provide for these areas, it is felt that PBL as a co-curricular activity would also help the students in enhancing their skills in emerging areas such as AI &\r\n"
////							+ "ML, Data Science, Cloud Computing, IoT and Cyber Security. We have entered into an association withSmartBridge and Cantilever labs, who offer externship programs designed to provide skills matching the needs of IT companies to our students at the end of their second year itself",
////					font5);
////			document.add(paragraph90);
//	//
//	//	
//	//	
////			Paragraph paragraph190 = new Paragraph(
////					"As can be seen from the table, the total number of offers has increased from 547 to 1400, in the last threeyears (2018-19 to 2021-22). This significant growth, has resulted in a quantum jump in the number ofoffers in the Rs.4-5 LPA range as well as Rs.6 LPA and above. In the context of this perceptibly large improvement in the total number of offers over the years, this can be construed and even attributed to the training program imparted, which in our perception is not only highly desirable but also a distinctive practice of this growing institution.",
////					font3);
////			document.add(paragraph190);
//
//			PdfPTable table7criteria7 = new PdfPTable(2);
//			table7criteria7.setWidthPercentage(100);
//
//			PdfPTable table70criteria7 = new PdfPTable(2);
//			table70criteria7.setWidthPercentage(100);
//
//			
//			PdfPCell cell22criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n"));
//			PdfPCell cell23criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n"));
//			PdfPCell cell24criteria7 = new PdfPCell(new Paragraph("Appropriate web in the Institutional website\r\n\r\n\r\n"));
//			PdfPCell cell25criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(28 ).getCriteria7FilePath() : "")));
//			PdfPCell cell26criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
//			PdfPCell cell27criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(28 ).getCriteria7FilePath() : "")));
//			
//			table7criteria7.addCell(cell22criteria7);
//			table7criteria7.addCell(cell23criteria7);
//			table7criteria7.addCell(cell24criteria7);
//			table7criteria7.addCell(cell25criteria7);
//			table7criteria7.addCell(cell26criteria7);
//			table7criteria7.addCell(cell27criteria7);
//			document.add(table7criteria7);
//			
////			table70criteria7.addCell("The first PEO of all programs of Mother Teresa is gainful employment or pursuit of higher\r\n"
////					+ "education.Gainful employment is essentially facilitating students in securing a good job while\r\n"
////					+ "studying in college, which we\r\n"
////					+ "are coining it as ‘Campus Placements’. This is an area of utmost priority for any professional\r\n"
////					+ "college and so is the priority for Mother Teresa. In this context, Mother Teresa has been doing\r\n"
////					+ "exceedingly well in terms of\r\n"
////					+ "getting the students placed in many IT and IT-enabled service (ITES) companies, namely, TCS,\r\n"
////					+ "Wipro,Cognizant, Accenture, and others.\r\n"
////					+ "Any parent and his/her ward always look for quality education coupled with a good placement.\r\n"
////					+ "Mother Teresahas, therefore, designed its curricula, adopted teaching learning process, has been\r\n"
////					+ "executing a meticulouslyplanned and structured training program, with a sharp focus on improving\r\n"
////					+ "not only the number ofplacements but also quality of placements, particularly in terms of the salary\r\n"
////					+ "package and reputation of thecompany, which is, Mother Teresa’s thirst and thrust.\r\n"
////					+ "Keeping this in view, skills namely, problem-solving, critical-thinking, logical-reasoning,\r\n"
////					+ "programming,creativity, innovation communication and interpersonal skills, which employers look\r\n"
////					+ "for in freshengineering graduates. College has undertaken several initiatives to impart these skills\r\n"
////					+ "to students. Apartfrom strengthening the core teaching-learning process, which is the backbone of\r\n"
////					+ "any college, Mother Teresahas been continuously striving in facilitating and supporting in the\r\n"
////					+ "honing of the following skills among\r\n"
////					+ "students");
////			
////			
////			table70criteria7.addCell("Basic programming skills\r\n"
////					+ "File Description Document\r\n"
////					+ "Best practices in the Institutional web site file:///C:/Users/my%20pc/Downloads/pdf_2022-\r\n"
////					+ "10-11_12_37_44.pdf\r\n"
////					+ "7.3.1 Portray the performance of the Institution in one area distinctive to its priority and\r\n"
////					+ "thrust within 1000 words\r\n"
////					+ "Response:242\r\n"
////					+ "242\r\n"
////					+ "Advanced programming skills\r\n"
////					+ "Quantitative aptitude development\r\n"
////					+ "Critical thinking and logical reasoning\r\n"
////					+ "Verbal ability, creative and situational writing\r\n"
////					+ "Soft skills\r\n"
////					+ "Even though students of all engineering branches study Programing and Problem-solving using Clanguage during their first year of engineering, non-CSE (ECE, EEE, ME, CE) students tend to lose touch with programming as they progress in their respective branch of engineering since theydo not apply and use programming to solve problems pertaining to their engineering courses. As\r\n"
////					+ "programming is now considered not only a necessary skill to be employable, but also a life skill,\r\n"
////					+ "Mother Teresa has been encouraging faculty and students of all engineering branches to integrate\r\n"
////					+ "programming into their regularlaboratory work and assignments in various courses, wherever\r\n"
////					+ "possible.Mother Teresa has associated with professional third-party vendors to facilitate students\r\n"
////					+ "with the necessary programming skills, mainly planned for targeted improvement of their\r\n"
////					+ "employability opportunities.\r\n"
////					+ "Students from all branches of engineering, eligible for placements, are given training to refresh\r\n"
////					+ "and enhance their programming skills. This usually takes place during the sixth (6th) semester and\r\n"
////					+ "following summer vacation, just before the placement season begins in the first semester of their\r\n"
////					+ "final year.It is observed that focused training in programming, sometimes designing and\r\n"
////					+ "scheduling a mock placement drive for a specific company, has immensely helped students to get\r\n"
////					+ "placed in higher numbers.\r\n"
////					+ "It is heartening to note that Mother Teresa has consistently done well in terms of placements in IT\r\n"
////					+ "and ITES companies, with pay packages varying between 3.6 LPA and 4.5 LPA. However, the\r\n"
////					+ "number of placements with product-based companies, wherein the pay packages are 5LPA –\r\n"
////					+ "10LPA and above is viewed as the hallmark of any good college. Keeping this in view, and with\r\n"
////					+ "the strong placement record in IT and ITES companies, the next logical step is to aim at helping\r\n"
////					+ "the students to develop the necessary skills to get selected in such companies that offer much\r\n"
////					+ "higher pay packages. Most product-based companies, in addition to testing the students in their\r\n"
////					+ "aptitude, also examine their higher order programming and problem-solving skills. Consequent to\r\n"
////					+ "this thought process, we roped in\r\n"
////					+ "another third party premier training organization with proven track record, to impart necessary\r\n"
////					+ "skills to get a job in product-based companies such as Amazon, Microsoft, DE Shaw etc., to train\r\n"
////					+ "around 150 students, selected out of nearly 800, and started enhancing their advanced data\r\n"
////					+ "structures, algorithms and problem solving skills since the academic 2020-21. The impact of this\r\n"
////					+ "advanced training program is clearly visible in the increased number of placements for the 2021\r\n"
////					+ "and outgoing batches in product-based companies. For the 2023 outgoing batch of students, the\r\n"
////					+ "training has commenced in their Third year second semester in order to provide ample time to\r\n"
////					+ "hone their skills and also practice a large number of problems long before the placements season\r\n"
////					+ "begins in July, 2022.\r\n"
////					+ "Some companies like Cognizant and Virtusa for example, have started hiring fresh engineering\r\n"
////					+ "graduates in specialized roles such as Data Scientist, IoT Engineer, full Stack Developer and UI\r\n"
////					+ "developer, Cloud Engineer etc. The students are expected to demonstrate significant skills in\r\n"
////					+ "those areas at the time of recruitment.\r\n"
////					+ "Even though the current curriculum of CSE and IT branches provide for these areas, it is felt that\r\n"
////					+ "PBL as a co-curricular activity would also help the students in enhancing their skills in emerging\r\n"
////					+ "areas such as AI &\r\n"
////					+ "ML, Data Science, Cloud Computing, IoT and Cyber Security. We have entered into an\r\n"
////					+ "association withSmartBridge and Cantilever labs, who offer externship programs designed to\r\n"
////					+ "provide skills matching the needs of IT companies to our students at the end of their second year\r\n"
////					+ "itself\r\n"
////					+ "As can be seen from the table, the total number of offers has increased from 547 to 1400, in\r\n"
////					+ "the last threeyears (2018-19 to 2021-22). This significant growth, has resulted in a quantum\r\n"
////					+ "jump in the number ofoffers in the Rs.4-5 LPA range as well as Rs.6 LPA and above. In the\r\n"
////					+ "context of this perceptibly large improvement in the total number of offers over the years,\r\n"
////					+ "this can be construed and even attributed to the training program imparted, which in our\r\n"
////					+ "perception is not only highly desirable but also a distinctive practice of this growing\r\n"
////					+ "institution.");
////			
////			
////			table70criteria7.addCell(table7criteria7);
////			table70criteria7.setSpacingBefore(20);
////			table70criteria7.setSpacingAfter(20);
////	        document.add(table70criteria7);
////
////			Paragraph paragraph1901 = new Paragraph("5. CONCLUSION\r\n\r\n", font3);
////			document.add(paragraph1901);
////
////			/*
////			 * Font fontParagraph009 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph009.setSize(12);
////			 */
////
////			Paragraph paragraph1902 = new Paragraph("Additional Information\r\n\r\n :", font3);
////			document.add(paragraph1902);
////
////			/*
////			 * Font fontParagraph0010 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph0010.setSize(12);
////			 */
////
////			Paragraph paragraph1903 = new Paragraph(
////					"Mother Teresa, started administering UG programs in CSE with specializations in emerging areas (EA), namely,AIML, CS, DS, and IoT from the academic year 2020-21, in addition to the UG programs in CSE, ECE, EEE,IT, ME and CE. Currently, student intake in CSE, CSE(EA) and IT stands at 660 and for 2022-23 it is likely to go up to 780. Keeping this in view, and more than 90% of the recruitment happening in IT/ITES companies,Mother Teresa feels the necessity to have an increased tie-up with IT industry. To this end, in the academic year2021-22, institution has reconstituted its Governing body, Academic Council and Board of Studies of variousdepartments by inviting experts working at senior positions from IT industries, to guide the institution in-termsof curricular design, strengthening the training of students, in particular, with skill set requirements of IT/ITES companies, emphasizing in EA. \r\n"
////							+ "Further, Institution has organized faculty development programs in CSE(EA), to improve faculty competencies and about 60 faculty of CSE/IT/CSE(EA) have attended the same. Institution has also entered into MoUs for student and faculty training and student internships. About 10 senior faculty with specialization in CSE(EA) have joined the institution on invitation.\r\n"
////							+ "Non-CSE/IT discipline students are also given training on Programming skills to enhance their employability.\r\n"
////							+ "Further, students solve assignments in core engineering and mathematics courses using C-programming. \r\n"
////							+ "Emphasizing on multidisciplinary education and research, institution’s incubation centre tied-up with R&D organizations, and MSMEs, resulting in 20 prototype:",
////					font5);
////			document.add(paragraph1903);
////
////			/*
////			 * Font fontParagraph0011 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph0011.setSize(12);
////			 */
////
////			Paragraph paragraph1900 = new Paragraph(
////					"Institution has been invited to present a talk on “Best Practices in Technical Education-Financial Sustainability in Universities” at the All-India Conference of Vice-Chancellors of Universities offering Engineering and Technology programs held at the Jawaharlal Nehru Technological University Hyderabad, during April 8-9, 2022.\r\n"
////							+ "Institution has conducted two webinars on NEP-20.\r\n"
////							+ "With all the above additional efforts, to further improve the quality of professional education and to enhance its core capabilities, Mother Teresa is determined to not only reach out to the imminent employability and skill needs of our Learners, but has already been administering the same, to render our learners, a cut above the rest, facilitating them to perform much better",
////					font5);
////			document.add(paragraph1900);
////
////			/*
////			 * Font fontParagraph0012 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph0012.setSize(13);
////			 */
////
////			Paragraph paragraph19011 = new Paragraph("Concluding Remarks\r\n\r\n :", font3);
////			document.add(paragraph19011);
////
////			/*
////			 * Font fontParagraph0017 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph0017.setSize(12);
////			 */
////
////			Paragraph paragraph19018 = new Paragraph(
////					"Consequent to this, the institution has been getting its eligible UG programs duly accredited by NBA regularly since July 2012, and the institution itself is accredited by NAAC with “A” grade in June 2017. Currently, all its  2011, 4-star by IIC, ARIIA ranking in Excellent Band, MHRD and NIRF rank in 251-300 Band in 2021. eligible UG programs are accredited by NBA. Institution has also been recognized as SIRO, by DSIR, since Institution’s faculty have been publishing research papers and patents. Executed sponsored projects worth about Rs.1.15 crores Student placements have been continuously increasing, as also the highest pay package and median salary.  Although institutional effectiveness can be measured in many ways, one of the most fundamental measures is the success it has achieved in contributing to the achievement of its students’ goals, which is, ensuring students’ placements and/or facilitating them to pursue higher education, which is the first of the PEOs of all our UG Programs. As a matter of fact, it is also our institutional distinctiveness, giving priority and thrust. To this end, institution feels that it has been doing quite well, although it believes that there is much more that can be achieved in the years to come",
////					font5);
////			document.add(paragraph19018);
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
