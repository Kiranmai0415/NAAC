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
//import com.adiverse.erp.model.Criteria1_FieldInfo;
//import com.adiverse.erp.model.Criteria1_FileUpload;
//import com.adiverse.erp.service.Criteria1Service;
//import com.lowagie.text.Chunk;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Element;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//@Service
//public class UniversityCriteria1Report {
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//	
//    @Autowired 
//    Criteria1Service service1;
//	
//	List<Criteria1_FieldInfo> criteria1List = null;
//	Criteria1_FieldInfo criteria1Record = null;
//	List<Criteria1_FileUpload> criteria1file = null;
//	
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
//			criteria1List = service1.getAllCriteria1Data();
//			if (CollectionUtils.isNotEmpty(criteria1List)) {
//				criteria1Record = criteria1List.get(0);
//				criteria1file = criteria1Record.getCriteria1FileUpload();
//			} else {
//				criteria1Record = new Criteria1_FieldInfo();
//				criteria1file = new ArrayList<Criteria1_FileUpload>();
//			}
//			
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "UniversityCriteria1Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//
//			Document document = new Document(PageSize.A4);
//	
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>");
//			
//			
//			
//			Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
//			paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph);
//
//			Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font2);
//			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph1);
//			Paragraph paragraph2 = new Paragraph("1.1 Curriculum Design and Development\r\n", font3);
//			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph2);
//
//		
//
//			Paragraph paragraph3 = new Paragraph(
//					"1.1.1 Curricula developed and implemented have relevance to the local, national, regional and global developmental needs which is reflected in Programme outcomes (POs), Programme Specific Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered by the Institution.\r\n",
//					font3);
//			paragraph3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			PdfPTable table111criteria1 = new PdfPTable(1);
//
//			table111criteria1.setWidthPercentage(100);
//			PdfPCell cell111criteria1 = new PdfPCell(
//					new Paragraph("1.1.1 Curricula developed and implemented have relevance to the local, "
//							+ "national, regional and global developmental needs which is reflected in Programme outcomes (POs), "
//							+ "Programme Specific Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered by the Institution.\r\n"
//							+ "Response:"+(criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQl().get(0).getResponse111()
//									: ""), font3));
//
//			table111criteria1.addCell(cell111criteria1);
//
//			table111criteria1.setSpacingBefore(20f);
//			table111criteria1.setSpacingAfter(20f);
//			document.add(table111criteria1);
//
//			
//
//			Paragraph paragraph4 = new Paragraph("Response:"
//					+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQl().get(0).getResponse111()
//							: ""),
//					font3);
//			paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			
//
//			Paragraph paragraph5 = new Paragraph(
//					"Mother Teresa being an autonomous HEI, has ensured a systematic procedure for the design, development, implementation and revision of its curricula as aligned to the institution�s vision and mission. All departments with their respective vision and mission have established their corresponding Program Educational Objectives (PEOs), defined Program Specific Outcomes (PSOs) and using the Program Outcomes (POs) of NBA, prepared PO-PEO matrix to ensure that POs facilitate realization of PEOs. Selected the number of credits for the program based on AICTE and UGC norms and decided distribution of credits. Identified the courses and defined respective course outcomes (COs), in line with Bloom�s Taxonomy levels, in particular, the Higher Order Thinking Skills (HOTS), meeting the stated POs and PSOs and prepared PO/PSO-CO matrix:",
//					font5);
//			paragraph5.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		
//
//			Paragraph paragraph6 = new Paragraph(
//					"While preparing the curriculum and subsequent revisions (once in two years), each BoS gathers extensive inputs from all stakeholders, namely, industry, R&D establishments, members of professional bodies, alumni, faculty, government and community. Each BoS also considers impetus given to infrastructure sector, GDP earned from various sectors along with the manpower requirements, and Government�s directives towards \"Make in India\" as also �Aatma Nirbhar Bharath�.\r\n"
//							+ "\r\n" + "\r\n",
//					font5);
//			paragraph6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			
//			Paragraph paragraph7 = new Paragraph(
//					"Curricula are approved by the Academic Council, with due deliberations on their relevance, for further revision, if any, so that Institution's vision and mission are reflected in each program offered by the institution.",
//					font5);
//			paragraph7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			
//			Paragraph paragraph8 = new Paragraph("Courses are broadly classified into:\r\n" + "\r\n", font5);
//			paragraph8.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			
//			Paragraph paragraph9 = new Paragraph("", font5);
//			paragraph9.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet1 = new Chunk("\u2022", font5);
//			paragraph9.add(bullet1);
//			paragraph9
//					.add(new Phrase("Core: Basic/Engineering Sciences, Humanities, Social Sciences and Engineering.\r\n"));
//
//			/*
//			 * com.lowagie.text.Font fontTitle10 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle10.setSize(12);
//			 */
//			Paragraph paragraph10 = new Paragraph(" ", font5);
//			paragraph10.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet2 = new Chunk("\u2022", font5);
//			paragraph10.add(bullet2);
//			paragraph10.add(new Phrase(
//					"Electives: Professional Electives which enrich students with technological advancements, and Open Electives which promote philosophy of liberal education."));
//
//			/*
//			 * com.lowagie.text.Font fontTitle11 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle11.setSize(12);
//			 */
//			Paragraph paragraph11 = new Paragraph(" ", font5);
//			Chunk bullet3 = new Chunk("\u2022", font5);
//			paragraph11.add(bullet3);
//			paragraph11.add(new Phrase(
//					"Value added courses: to enhance employability, creativity, innovation, team-work, communication, problem solving ability, Logical reasoning, environmental aspects for sustainability, professional ethics and integrity, Project management and finance, Design Thinking, Internship, projects/ seminars, entrepreneurship insights, value education, citizenship roles, catering to the local, regional and global needs.\r\n\r\n"));
//			paragraph11.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle12 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle12.setSize(12);
//			 */
//			Paragraph paragraph12 = new Paragraph(
//					"All the above provide the students with liberal and holistic education with experimental and experiential learning through simulation and hands-on operations, to be globally competitive:\r\n"
//							+ "\r\n",
//					font5);
//			paragraph12.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle13 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle13.setSize(12);
//			 */
//			Paragraph paragraph13 = new Paragraph(
//					"As per NEP 2020, multi-disciplinary choices are available for learners, through a plethora of courses across departments, under the Choice Based Credit system (CBCS) and value added courses on usage of\r\n"
//							+ " \r\n"
//							+ "modern tools as adopted by industry, promoting analytical thinking, creativity and innovation, and building a culture of innovative spirit, thereby transforming the learners to be industry-ready, relevant and build an attitude of serving the society towards sustainable development:\r\n"
//							+ "\r\n",
//					font5);
//			paragraph13.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle14 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle14.setSize(12);
//			 */
//			Paragraph paragraph14 = new Paragraph(
//					"The following are some notable courses introduced in the corresponding revisions:\r\n" + "\r\n",
//					font5);
//			paragraph14.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle15 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle15.setSize(12);
//			 */
//			Paragraph paragraph15 = new Paragraph("2016-18:\r\n", font3);
//			paragraph15.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle16 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle16.setSize(12);
//			 */
//			Paragraph paragraph16 = new Paragraph("", font5);
//			paragraph16.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet4 = new Chunk("\u2022", font5);
//			paragraph16.add(bullet4);
//			paragraph16.add(new Phrase("Computational Mathematics with lab\r\n"));
//
//			/*
//			 * com.lowagie.text.Font fontTitle17 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle17.setSize(12);
//			 */
//			Paragraph paragraph17 = new Paragraph("", font5);
//			paragraph17.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet5 = new Chunk("\u2022", font5);
//			paragraph17.add(bullet5);
//			paragraph17.add(new Phrase("Actuarial Statistics\r\n"));
//
//			/*
//			 * com.lowagie.text.Font fontTitle18 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle18.setSize(12);
//			 */
//			Paragraph paragraph18 = new Paragraph("", font5);
//			paragraph18.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Chunk bullet6 = new Chunk("\u2022", font5);
//			paragraph18.add(bullet6);
//			paragraph18.add(new Phrase("Banking and Insurance\r\n"));
//
//			/*
//			 * com.lowagie.text.Font fontTitle19 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle19.setSize(12);
//			 */
//			Paragraph paragraph19 = new Paragraph("", font5);
//			paragraph19.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet7 = new Chunk("\u2022", font5);
//			paragraph19.add(bullet7);
//			paragraph19.add(new Phrase("Foreign Language\r\n"));
//
//			/*
//			 * com.lowagie.text.Font fontTitle20 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); font3.setSize(12);
//			 */
//			Paragraph paragraph20 = new Paragraph("", font5);
//			paragraph20.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet8 = new Chunk("\u2022", font5);
//			paragraph20.add(bullet8);
//			paragraph20.add(new Phrase("Hybrid Electric Vehicles\r\n"));
//
//			/*
//			 * com.lowagie.text.Font fontTitle21 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle21.setSize(12);
//			 */
//			Paragraph paragraph21 = new Paragraph("", font5);
//			paragraph21.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet9 = new Chunk("\u2022", font5);
//			paragraph21.add(bullet9);
//			paragraph21.add(new Phrase("Nano-materials and Technology\r\n"));
//
//			/*
//			 * com.lowagie.text.Font fontTitle22 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle22.setSize(12);
//			 */
//			Paragraph paragraph22 = new Paragraph("", font5);
//			paragraph22.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet10 = new Chunk("\u2022", font5);
//			paragraph22.add(bullet10);
//			paragraph22.add(new Phrase("Pavement analysis and design with lab\r\n"));
//
//			/*
//			 * com.lowagie.text.Font fontTitle23 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle23.setSize(12)
//			 */
//			Paragraph paragraph23 = new Paragraph("", font5);
//			paragraph23.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet11 = new Chunk("\u2022", font5);
//			paragraph23.add(bullet11);
//			paragraph23.add(new Phrase("Earth Retaining Structures\r\n\r\n"));
//
//			/*
//			 * com.lowagie.text.Font fontTitle24 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle24.setSize(12);
//			 */
//			Paragraph paragraph24 = new Paragraph("2018-20\r\n", font3);
//			paragraph24.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle25 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle25.setSize(12);
//			 */
//			Paragraph paragraph25 = new Paragraph(" ", font5);
//			paragraph25.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet12 = new Chunk("\u2022", font5);
//			paragraph25.add(bullet12);
//			paragraph25.add(new Phrase("Deep learning\r\n"));
//
//			/*
//			 * com.lowagie.text.Font fontTitle26 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle26.setSize(12);
//			 */
//			Paragraph paragraph26 = new Paragraph(" ", font5);
//			paragraph26.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet13 = new Chunk("\u2022", font5);
//			paragraph26.add(bullet13);
//			paragraph26.add(new Phrase("Electronic Sensors\r\n"));
//
//			/*
//			 * com.lowagie.text.Font fontTitle27 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle27.setSize(12);
//			 */
//			Paragraph paragraph27 = new Paragraph(" ", font5);
//			Chunk bullet14 = new Chunk("\u2022", font5);
//			paragraph27.add(bullet14);
//			paragraph27.add(new Phrase("IoT\r\n"));
//
//			paragraph27.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle28 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle28.setSize(12);
//			 */
//			Paragraph paragraph28 = new Paragraph("Courses with hands on lab exercises:\r\n ", font3);
//			paragraph28.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle29 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle29.setSize(12);
//			 */
//
//			Paragraph paragraph29 = new Paragraph("", font5);
//			Chunk bullet15 = new Chunk("\u2022", font5);
//			paragraph29.add(bullet15);
//			paragraph29.add(new Phrase("Artificial Intelligence\r\n", font5));
//
//			Paragraph paragraph291 = new Paragraph("", font5);
//			Chunk bullet16 = new Chunk("\u2022", font5);
//			paragraph291.add(bullet16);
//			paragraph291.add(new Phrase("Machine Learning\r\n"));
//
//			Paragraph paragraph292 = new Paragraph("", font5);
//			Chunk bullet17 = new Chunk("\u2022", font5);
//			paragraph292.add(bullet17);
//			paragraph292.add(new Phrase("Operations Research\r\n", font5));
//			paragraph292.setAlignment(Element.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph293 = new Paragraph("", font5);
//			Chunk bullet18 = new Chunk("\u2022", font5);
//			paragraph293.add(bullet18);
//			paragraph293.add(new Phrase("Blockchain Technologies\r\n", font5));
//			paragraph293.setAlignment(Element.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph294 = new Paragraph("", font5);
//			Chunk bullet19 = new Chunk("\u2022", font5);
//			paragraph294.add(bullet19);
//			paragraph294.add(new Phrase("Data Analytic\r\n", font5));
//			paragraph294.setAlignment(Element.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph295 = new Paragraph("", font5);
//			Chunk bullet20 = new Chunk("\u2022", font5);
//			paragraph295.setAlignment(Element.ALIGN_JUSTIFIED);
//			paragraph295.add(bullet20);
//			paragraph295.add(new Phrase("Project-orientation\r\n", font5));
//
//			Paragraph paragraph296 = new Paragraph("", font5);
//			Chunk bullet21 = new Chunk("\u2022", font5);
//			paragraph296.add(bullet21);
//			paragraph296.add(new Phrase("IT workshop including Sci-lab\r\n\r\n", font5));
//			paragraph296.setAlignment(Element.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle30 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle30.setSize(12);
//			 */
//			Paragraph paragraph30 = new Paragraph("2020-21\r\n ", font3);
//			paragraph30.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle31 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle31.setSize(12);
//			 */
//			Paragraph paragraph31 = new Paragraph(" ", font5);
//			Chunk bullet22 = new Chunk("\u2022", font5);
//			paragraph31.add(bullet22);
//			paragraph31.add(new Phrase("5G mobile communications\r\n\r\n", font5));
//			paragraph31.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph311 = new Paragraph(" ", font5);
//			Chunk bullet23 = new Chunk("\u2022", font5);
//			paragraph311.add(bullet23);
//			paragraph311.add(new Phrase("Six English courses (Three new)\r\n\r\n", font5));
//			paragraph311.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph312 = new Paragraph(" ", font5);
//			Chunk bullet24 = new Chunk("\u2022", font5);
//			paragraph312.add(bullet24);
//			paragraph312.add(new Phrase("IoT analytics\r\n+\r\n", font5));
//			paragraph312.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph313 = new Paragraph(" ", font5);
//			Chunk bullet25 = new Chunk("\u2022", font5);
//			paragraph313.add(bullet25);
//			paragraph313.add(new Phrase("Six English courses (Three new) \r\n\r\n", font5));
//			paragraph313.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph314 = new Paragraph(" ", font5);
//			Chunk bullet26 = new Chunk("\u2022", font5);
//			paragraph314.add(bullet26);
//			paragraph314.add(new Phrase("Computational Intelligence\r\n\r\n", font5));
//			paragraph314.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph315 = new Paragraph(" ", font5);
//			Chunk bullet27 = new Chunk("\u2022", font5);
//			paragraph315.add(bullet27);
//			paragraph315.add(new Phrase("Quantum Computing and Cryptography\r\n\r\n", font5));
//			paragraph315.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle32 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle32.setSize(12);
//			 */
//			Paragraph paragraph32 = new Paragraph("Courses with hands on lab exercises:\r\n\r\n", font3);
//			paragraph32.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle33 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle33.setSize(12);
//			 */
//			Paragraph paragraph33 = new Paragraph("", font5);
//			Chunk bullet28 = new Chunk("\u2022", font5);
//			paragraph33.add(bullet28);
//			paragraph33.add(new Phrase("Statistics for Machine Learning \r\n\r\n", font5));
//			paragraph33.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph331 = new Paragraph("", font5);
//			Chunk bullet29 = new Chunk("\u2022", font5);
//			paragraph33.add(bullet29);
//			paragraph33.add(new Phrase("Digital Forensics \r\n\r\n", font5));
//			paragraph33.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph332 = new Paragraph("", font5);
//			Chunk bullet30 = new Chunk("\u2022", font5);
//			paragraph332.add(bullet30);
//			paragraph332.add(new Phrase("Wireless sensor networks \r\n\r\n", font5));
//			paragraph332.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph333 = new Paragraph("", font5);
//			Chunk bullet31 = new Chunk("\u2022", font5);
//			paragraph333.add(bullet31);
//			paragraph333.add(new Phrase("Smart Sensors and Instrumentation\r\n\r\n", font5));
//			paragraph333.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph334 = new Paragraph("", font5);
//			Chunk bullet32 = new Chunk("\u2022", font5);
//			paragraph334.add(bullet32);
//			paragraph334.add(new Phrase("Design Thinking \r\n\r\n", font5));
//			paragraph334.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph3);
//			document.add(paragraph4);
//			document.add(paragraph5);
//			document.add(paragraph6);
//			document.add(paragraph7);
//			document.add(paragraph8);
//			document.add(paragraph9);
//			document.add(paragraph10);
//			document.add(paragraph11);
//			document.add(paragraph12);
//			document.add(paragraph13);
//			document.add(paragraph14);
//			document.add(paragraph15);
//			document.add(paragraph16);
//			document.add(paragraph17);
//			document.add(paragraph18);
//			document.add(paragraph19);
//			document.add(paragraph20);
//			document.add(paragraph21);
//			document.add(paragraph22);
//			document.add(paragraph23);
//			document.add(paragraph24);
//			document.add(paragraph25);
//			document.add(paragraph26);
//			document.add(paragraph27);
//			document.add(paragraph28);
//			document.add(paragraph29);
//
//			document.add(paragraph291);
//			document.add(paragraph292);
//			document.add(paragraph293);
//			document.add(paragraph294);
//			document.add(paragraph295);
//			document.add(paragraph296);
//			// document.add(paragraph297);
//
//			document.add(paragraph30);
//			document.add(paragraph31);
//			document.add(paragraph311);
//			document.add(paragraph312);
//			document.add(paragraph313);
//			document.add(paragraph314);
//			document.add(paragraph315);
//
//			document.add(paragraph32);
//			document.add(paragraph33);
//			document.add(paragraph331);
//			document.add(paragraph332);
//			document.add(paragraph333);
//			document.add(paragraph334);
//
//			// creating table
//			PdfPTable table = new PdfPTable(2);
//
//			table.setWidthPercentage(100);
//
//			/*
//			 * com.lowagie.text.Font headerFont =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * headerFont.setColor(CMYKColor.BLACK);
//			 */
//
//			// create table for header
//			PdfPCell cell1 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font3));
//			PdfPCell cell2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell3 = new PdfPCell(new Paragraph("\r\nUpload aditional information\r\n\r\n", font5));
//			PdfPCell cell4 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
//			PdfPCell cell5 = new PdfPCell(new Paragraph("\r\nLink for Aditional information\r\n\r\n", font5));
//			PdfPCell cell6 = new PdfPCell(new Paragraph(" "));
//
//			/*
//			 * com.lowagie.text.Font fontTitle34 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle34.setSize(12);
//			 */
//			Paragraph paragraph34 = new Paragraph(
//					"1.1.2 Percentage of Programmes where syllabus revision was carried out during the last five years.\r\n"
//							+"Response\r\n"
//									+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse112()
//											: ""),
//					font3);
//			paragraph34.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle35 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle35.setSize(12);
//			 */
//			Paragraph paragraph35 = new Paragraph("Response\r\n"
//					+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse112()
//							: ""),
//					font3);
//			paragraph35.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle36 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle36.setSize(12);
//			 */
//			Paragraph paragraph36 = new Paragraph(
//					"1.1.2.1 How many Programmes were revised out of total number of Programmes offered during the last five years.\r\n\r\n"
//							+ "",
//					font3);
//			paragraph36.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle37 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle37.setSize(12);
//			 */
//			Paragraph paragraph37 = new Paragraph("Response:"
//					+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQn().get(0).getInput1121t1() : ""),
//					font5);
//			paragraph37.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle38 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle38.setSize(12);
//			 */
//			Paragraph paragraph38 = new Paragraph(
//					"1.1.2.2 Number of all Programmes offered by the institution during the last five years",
//					font5);
//			paragraph38.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * com.lowagie.text.Font fontTitle39 =
//			 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle39.setSize(12);
//			 */
//			Paragraph paragraph39 = new Paragraph("Response:"
//					+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQn().get(0).getInput1122t1() : ""),
//					font5);
//			paragraph39.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			PdfPTable table1 = new PdfPTable(2);
//			table1.setWidthPercentage(100);
//
//			PdfPTable table11 = new PdfPTable(1);
//			table11.setWidthPercentage(100);
//
//			/*
//			 * com.lowagie.text.Font font1 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//			 * font1.setColor(CMYKColor.BLACK);
//			 */
//			PdfPCell cell11 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font3));
//			PdfPCell cell12 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell13 = new PdfPCell(new Paragraph("\r\nMinutes of relevant Academic Council/BOS meeting\r\n\r\n", font3));
//			PdfPCell cell14 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
//			PdfPCell cell15 = new PdfPCell(
//					new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n"));
//			PdfPCell cell16 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : ""));
//			PdfPCell cell17 = new PdfPCell(new Paragraph("\r\nDetails of program syllabus revision in last 5 years(Data Template)"));
//			PdfPCell cell18 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(3).getCriteria1FilePath() : ""));
//			PdfPCell cell19 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n"));
//			PdfPCell cell20 = new PdfPCell(new Paragraph(""));
//
//			PdfPTable table3 = new PdfPTable(2);
//			table3.setWidthPercentage(100);
//
//			PdfPCell cell31 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font3));
//			PdfPCell cell32 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell33 = new PdfPCell(new Paragraph("\r\nProgramme / Curriculum/ Syllabus of the courses\r\n\r\n"));
//			PdfPCell cell34 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : ""));
//			PdfPCell cell35 = new PdfPCell(new Paragraph("\r\nMoU's with relevant organizations for these courses, if any\r\n\r\n"));
//			PdfPCell cell36 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : ""));
//
//			PdfPCell cell37 = new PdfPCell(new Paragraph(
//					"\r\nMinutes of the Boards of Studies/ Academic Council meetings with approvals for these courses\r\n\r\n"));
//			PdfPCell cell38 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : ""));
//			PdfPCell cell39 = new PdfPCell(new Paragraph(
//					"\r\nAverage percentage of courses having focus on employability/ entrepreneurship(Data Template\r\n\r\n)"));
//			PdfPCell cell40 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(7).getCriteria1FilePath() : ""));
//			PdfPCell cell41 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n"));
//			PdfPCell cell42 = new PdfPCell(new Paragraph(""));
//
//			/*
//			 * com.lowagie.text.Font fontTitle43 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle43.setSize(16)
//			 */
//
//			Paragraph paragraph43 = new Paragraph("1.2 Academic Flexibility\r\n", font2);
//			paragraph43.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			// creating tabl4
//
//			PdfPTable table4 = new PdfPTable(2);
//			table4.setWidthPercentage(100);
//			PdfPTable table41 = new PdfPTable(1);
//			table41.setWidthPercentage(100);
//
//			/*
//			 * com.lowagie.text.Font font4 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//			 * font4.setColor(CMYKColor.BLACK);
//			 */
//			PdfPCell cell411 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell412 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell413 = new PdfPCell(new Paragraph("\r\nMinutes of relevant Academic Council/BOS meetings\r\n"));
//			PdfPCell cell414 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(8).getCriteria1FilePath() : ""));
//			PdfPCell cell415 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n"));
//			PdfPCell cell416 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(9).getCriteria1FilePath() : ""));
//			PdfPCell cell417 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"));
//			PdfPCell cell418 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(10).getCriteria1FilePath() : ""));
//			PdfPCell cell419 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n"));
//			PdfPCell cell420 = new PdfPCell(new Paragraph(""));
//
//			PdfPTable table5 = new PdfPTable(2);
//			table5.setWidthPercentage(100);
//			/*
//			 * com.lowagie.text.Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//			 * font5.setColor(CMYKColor.BLACK);
//			 */
//
//			PdfPTable table5a = new PdfPTable(1);
//			table5a.setWidthPercentage(100);
//			/*
//			 * com.lowagie.text.Font font5a = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//			 * font5a.setColor(CMYKColor.BLACK)
//			 */
//
//			PdfPCell cell511 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell512 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell513 = new PdfPCell(new Paragraph("\r\n\r\nMinutes of relevant Academic Council/BOS meetings\r\n"));
//			PdfPCell cell514 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(11).getCriteria1FilePath() : ""));
//			PdfPCell cell515 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n"));
//			PdfPCell cell516 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(12).getCriteria1FilePath() : ""));
//			PdfPCell cell517 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"));
//			PdfPCell cell518 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(13).getCriteria1FilePath() : ""));
//			PdfPCell cell519 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n"));
//			PdfPCell cell520 = new PdfPCell(new Paragraph(""));
//			// 3.1
//
//			/*
//			 * com.lowagie.text.Font fontTitle54 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle54.setSize(16);
//			 */
//
//			Paragraph paragraph54 = new Paragraph("\r\n 1.3 Curriculum Enrichment\r\n", font3);
//			paragraph54.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			// create table6
//
//			PdfPTable table6 = new PdfPTable(2);
//			table6.setWidthPercentage(100);
//			/*
//			 * com.lowagie.text.Font font6 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//			 * font6.setColor(CMYKColor.BLACK);
//			 */
//
//			PdfPTable table61 = new PdfPTable(1);
//			table61.setWidthPercentage(100);
//			/*
//			 * com.lowagie.text.Font font61 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font61.setColor(CMYKColor.BLACK);
//			 */
//
//			PdfPCell cell611 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell612 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n\r\n", font3));
//			PdfPCell cell613 = new PdfPCell(new Paragraph(
//					"\r\n\r\nUpload the list and description of the courses which address the Gender, Environment and Sustainability, Human Values and Professional Ethics into the Curriculum\r\n\r\n"));
//			PdfPCell cell614 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(14).getCriteria1FilePath() : ""));
//			PdfPCell cell615 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"));
//			PdfPCell cell616 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(15).getCriteria1FilePath() : ""));
//			PdfPCell cell617 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n"));
//			PdfPCell cell618 = new PdfPCell(new Paragraph(""));
//
//			// create table7
//			PdfPTable table7 = new PdfPTable(5);
//			table7.setWidthPercentage(100);
//			/*
//			 * com.lowagie.text.Font font7 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//			 * font61.setColor(CMYKColor.BLACK);
//			 */
//			PdfPTable table71 = new PdfPTable(5);
//			table71.setWidthPercentage(100);
//	//
////			PdfPCell cell71 = new PdfPCell(new Paragraph("2020-21"));
////			PdfPCell cell72 = new PdfPCell(new Paragraph("2019-20"));
////			PdfPCell cell73 = new PdfPCell(new Paragraph("2018-19"));
////			PdfPCell cell74 = new PdfPCell(new Paragraph("2017-18"));
////			PdfPCell cell75 = new PdfPCell(new Paragraph("2016-17"));
////			PdfPCell cell76 = new PdfPCell(new Paragraph("  "));
////			PdfPCell cell77 = new PdfPCell(new Paragraph("  "));
////			PdfPCell cell78 = new PdfPCell(new Paragraph("  "));
////			PdfPCell cell79 = new PdfPCell(new Paragraph("  "));
////			PdfPCell cell80 = new PdfPCell(new Paragraph("  "));
////			// create 8
//
//			PdfPTable table81 = new PdfPTable(1);
//			table81.setWidthPercentage(100);
//
//			/*
//			 * com.lowagie.text.Font font81 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font81.setColor(CMYKColor.BLACK);
//			 */
//
//			PdfPTable table82 = new PdfPTable(5);
//			table82.setWidthPercentage(100);
//			/*
//			 * com.lowagie.text.Font font82 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font82.setColor(CMYKColor.BLACK);
//			 */
//			// create table82
////			PdfPCell cell821 = new PdfPCell(new Paragraph("2020-21"));
////			PdfPCell cell822 = new PdfPCell(new Paragraph("2019-20"));
////			PdfPCell cell823 = new PdfPCell(new Paragraph("2018-19"));
////			PdfPCell cell824 = new PdfPCell(new Paragraph("2017-18"));
////			PdfPCell cell825 = new PdfPCell(new Paragraph("2016-17"));
////			PdfPCell cell826 = new PdfPCell(new Paragraph("  "));
////			PdfPCell cell827 = new PdfPCell(new Paragraph("  "));
////			PdfPCell cell828 = new PdfPCell(new Paragraph("  "));
////			PdfPCell cell829 = new PdfPCell(new Paragraph("  "));
////			PdfPCell cell8230 = new PdfPCell(new Paragraph("  "));
//
//			// create table8
//
//			PdfPTable table8 = new PdfPTable(2);
//			table8.setWidthPercentage(100);
//			/*
//			 * com.lowagie.text.Font font8 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font8.setColor(CMYKColor.BLACK);
//			 */
//			PdfPCell cell81 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell82 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell83 = new PdfPCell(new Paragraph("\r\nList of value added courses (Data Template)\r\n"));
//			PdfPCell cell84 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(15).getCriteria1FilePath() : ""));
//			PdfPCell cell85 = new PdfPCell(new Paragraph("\r\nBrochure or any other document relating to value added courses\r\n\r\n"));
//			PdfPCell cell86 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(16).getCriteria1FilePath() : ""));
//			PdfPCell cell87 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n"));
//			PdfPCell cell88 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(17).getCriteria1FilePath() : ""));
//			PdfPCell cell89 = new PdfPCell(new Paragraph("\r\n Link for Additional Information\r\n\r\n"));
//			PdfPCell cell90 = new PdfPCell(new Paragraph(""));
//
//			// create table9
//			PdfPTable table9 = new PdfPTable(5);
//			PdfPTable table91 = new PdfPTable(1);
//			// PdfPTable table92=new PdfPTable(2);
//
//			table9.setWidthPercentage(100);
//			table91.setWidthPercentage(100);
//			// table92.setWidthPercentage(100);
//
//			/*
//			 * com.lowagie.text.Font font9 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//			 * font9.setColor(CMYKColor.BLACK);
//			 */
////			PdfPCell cell91 = new PdfPCell(new Paragraph("2020-21"));
////			PdfPCell cell92 = new PdfPCell(new Paragraph("2019-20"));
////			PdfPCell cell93 = new PdfPCell(new Paragraph("2018-19"));
////			PdfPCell cell94 = new PdfPCell(new Paragraph("2017-18"));
////			PdfPCell cell95 = new PdfPCell(new Paragraph("2016-17"));
////			PdfPCell cell96 = new PdfPCell(new Paragraph("  "));
////			PdfPCell cell97 = new PdfPCell(new Paragraph("  "));
////			PdfPCell cell98 = new PdfPCell(new Paragraph("  "));
////			PdfPCell cell99 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell100 = new PdfPCell(new Paragraph("  "));
//
//			PdfPTable table92 = new PdfPTable(2);
//
//			table92.setWidthPercentage(100);
//
//			PdfPCell cell921 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell922 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell923 = new PdfPCell(new Paragraph("\r\n List of students enrolled\r\n"));
//			PdfPCell cell924 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(18).getCriteria1FilePath() : ""));
//			PdfPCell cell925 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n"));
//			PdfPCell cell926 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(19).getCriteria1FilePath() : ""));
//			PdfPCell cell927 = new PdfPCell(new Paragraph("\r\n\r\nLink for Additional Information\r\n"));
//			PdfPCell cell928 = new PdfPCell(new Paragraph(""));
//
//			// create table10
//			PdfPTable table10 = new PdfPTable(2);
//			table10.setWidthPercentage(100);
//
//			PdfPTable table101 = new PdfPTable(1);
//			table101.setWidthPercentage(100);
//
//			PdfPCell cell101 = new PdfPCell(new Paragraph("\r\n\r\nFileDiscription\r\n", font3));
//			PdfPCell cell102 = new PdfPCell(new Paragraph("\r\n\r\nDocument\r\n\r\n", font3));
//			PdfPCell cell103 = new PdfPCell(new Paragraph(
//					"\r\n\r\nList of programs and number of students undertaking field projects / internships / student projects (Data Template)\r\n\r\n"));
//			PdfPCell cell104 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(20).getCriteria1FilePath() : ""));
//			PdfPCell cell105 = new PdfPCell(new Paragraph("\r\n\r\nAny additional information\r\n"));
//			PdfPCell cell106 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(21).getCriteria1FilePath() : ""));
//			PdfPCell cell107 = new PdfPCell(new Paragraph("Link for Additional Information\r\n"));
//			PdfPCell cell108 = new PdfPCell(new Paragraph(""));
//
//			/*
//			 * com.lowagie.text.Font fontTitle67 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle67.setSize(16);
//			 */
//
//			Paragraph paragraph67 = new Paragraph("\r\n1.4  Feedback System\r\n", font3);
//			paragraph67.setAlignment(Paragraph.ALIGN_LEFT);
//
//			PdfPTable table111 = new PdfPTable(2);
//			table111.setWidthPercentage(100);
//
//			PdfPTable table110 = new PdfPTable(1);
//			table110.setWidthPercentage(100);
//
//			PdfPCell cell111 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell112 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell113 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"));
//			PdfPCell cell114 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(22).getCriteria1FilePath() : ""));
//			PdfPCell cell115 = new PdfPCell(new Paragraph(
//					"\r\n\r\nAction taken report of the Institution on feedback report as minuted by the Governing Council, Syndicate, Board of Management\r\n\r\n"));
//			PdfPCell cell116 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(23).getCriteria1FilePath() : ""));
//			PdfPCell cell117 = new PdfPCell(new Paragraph("\r\nURL for stakeholder feedback report\r\n"));
//			PdfPCell cell118 = new PdfPCell(new Paragraph((criteria1file.size() > 0 && criteria1file.get(24) != null)
//					? criteria1file.get(23).getCriteria1FilePath()
//					: ""));
//			PdfPCell cell119 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n"));
//			PdfPCell cell1120 = new PdfPCell(new Paragraph(""));
//
//			// create table12
//			PdfPTable table12 = new PdfPTable(2);
//			table12.setWidthPercentage(100);
//
//			PdfPTable table121 = new PdfPTable(1);
//			table121.setWidthPercentage(100);
//
//			PdfPCell cell121 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell122 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell123 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"));
//			PdfPCell cell124 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(25).getCriteria1FilePath() : ""));
//			PdfPCell cell125 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n"));
//			PdfPCell cell126 = new PdfPCell(new Paragraph(
//					(criteria1file.size() > 0 && criteria1file.contains(26)) ? criteria1file.get(26).getCriteria1FilePath()
//							: ""));
//			PdfPCell cell127 = new PdfPCell(new Paragraph("\r\n URL for stakeholder feedback report\r\n"));
//			PdfPCell cell128 = new PdfPCell(new Paragraph(""));
//
//			table.addCell(cell1);
//			table.addCell(cell2);
//			table.addCell(cell3);
//			table.addCell(cell4);
//			table.addCell(cell5);
//			table.addCell(cell6);
//			
//			table.setSpacingAfter(20f);
//			table.setSpacingAfter(20f);
//			
//			document.add(table);
//
//			table1.addCell(cell11);
//			table1.addCell(cell12);
//			table1.addCell(cell13);
//			table1.addCell(cell14);
//			table1.addCell(cell15);
//			table1.addCell(cell16);
//			table1.addCell(cell17);
//			table1.addCell(cell18);
//			table1.addCell(cell19);
//			table1.addCell(cell20);
//
//			table11.addCell(
//					"1.1.2 Percentage of Programmes where syllabus revision was carried out during the last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Record != null
//									? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse112()
//									: ""));
//
//			table11.addCell("1.1.2.1 Number of all Programmes offered by the institution during the last five years.\r\n"
//					+ "\r\n" + "Response:"
//					+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQn().get(0).getInput1121t1() : ""));
//			table11.addCell(
//					"1.1.2.2 How many Programmes were revised out of total number of Programmes offered during the last five years\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQn().get(0).getInput1122t1()
//									: ""));
//
//			table11.addCell(table1);
//			table11.setSpacingAfter(25);
//			document.add(table11);
//
//			Table table1131 = new Table(criteria1Record.getYearTable1131().size(), 2);
//
//			table1131.setPadding(10);
//			table1131.setWidth(100f);
//
//			for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
//				table1131.addCell(criteria1Record.getYearTable1131().get(i).getInput1131y());
//			}
//			for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
//				table1131.addCell(criteria1Record.getYearTable1131().get(i).getInput1131v());
//			}
//
//			// document.add(table1131);
//
//			PdfPTable table31 = new PdfPTable(1);
//			table31.setWidthPercentage(100);
//
//			PdfPTable table113_1 = new PdfPTable(5);
//			table113_1.setWidthPercentage(100);
//
//			/*
//			 * com.lowagie.text.Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//			 * headerFont.setColor(CMYKColor.BLACK);
//			 */
//
//			PdfPCell cell21 = new PdfPCell(new Paragraph("2020-21"));
//			PdfPCell cell22 = new PdfPCell(new Paragraph("2019-20"));
//			PdfPCell cell23 = new PdfPCell(new Paragraph("2018-19"));
//
//			PdfPCell cell24 = new PdfPCell(new Paragraph("2017-18"));
//			PdfPCell cell25 = new PdfPCell(new Paragraph("2016-17"));
//			PdfPCell cell26 = new PdfPCell(new Paragraph("  "));
//			PdfPCell cell27 = new PdfPCell(new Paragraph("  "));
//			PdfPCell cell28 = new PdfPCell(new Paragraph("  "));
//			PdfPCell cell29 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell30 = new PdfPCell(new Paragraph("  "));
//
//			table113_1.addCell(cell21);
//			table113_1.addCell(cell22);
//			table113_1.addCell(cell23);
//			table113_1.addCell(cell24);
//			table113_1.addCell(cell25);
//			table113_1.addCell(cell26);
//			table113_1.addCell(cell27);
//			table113_1.addCell(cell28);
//			table113_1.addCell(cell29);
//			table113_1.addCell(cell30);
//			table31.addCell(
//					"1.1.3 Average percentage of courses having focus on employability/ entrepreneurship/ skill development offered by the institution during the last five years\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Record != null
//									? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse113()
//									: ""));
//			table31.addCell(
//					"1.1.3.1 Number of courses having focus on employability/ entrepreneurship/ skill development year- wise during the last five years\r\n+\r\n");
//
//			// table31.addCell(table113_1);
//
//			table31.setSpacingBefore(25);
//			table31.setSpacingAfter(25);
//
//			document.add(table31);
//			document.add(table1131);
//
//			table3.addCell(cell31);
//			table3.addCell(cell32);
//			table3.addCell(cell33);
//			table3.addCell(cell34);
//			table3.addCell(cell35);
//			table3.addCell(cell36);
//			table3.addCell(cell37);
//			table3.addCell(cell38);
//			table3.addCell(cell39);
//			table3.addCell(cell40);
//			table3.addCell(cell41);
//			table3.addCell(cell42);
//
//			document.add(table3);
//			document.add(paragraph43);
//
//			table4.addCell(cell411);
//			table4.addCell(cell412);
//			table4.addCell(cell413);
//			table4.addCell(cell414);
//			table4.addCell(cell415);
//			table4.addCell(cell416);
//			table4.addCell(cell417);
//			table4.addCell(cell418);
//			table4.addCell(cell419);
//			table4.addCell(cell420);
//			table41.addCell(
//					"1.2.1 Percentage of new courses introduced of the total number of courses across all programs offered during the last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Record != null
//									? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse121()
//									: ""));
//			table41.addCell("1.2.1.1 How many new courses are introduced within the last five years\r\n" + "\r\n"
//					+ "Response:"
//					+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQn().get(0).getInput1211t1() : ""));
//			table41.addCell(
//					"1.2.1.2 Number of courses offered by the institution across all programmes during the last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQn().get(0).getInput1212t1()
//									: ""));
//
//			table41.addCell(table4);
//
//			table41.setSpacingBefore(25);
//			table41.setSpacingAfter(25);
//
//			document.add(table41);
//
//			table5.addCell(cell511);
//			table5.addCell(cell512);
//			table5.addCell(cell513);
//			table5.addCell(cell514);
//			table5.addCell(cell515);
//			table5.addCell(cell516);
//			table5.addCell(cell517);
//			table5.addCell(cell518);
//			table5.addCell(cell519);
//			table5.addCell(cell520);
//
//			table5a.addCell(
//					"1.2.2 Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year).\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Record != null
//									? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse122()
//									: ""));
//			table5a.addCell("1.2.2.1 Number of Programmes in which CBCS / Elective course system implemented.\r\n" + "\r\n"
//					+ "Response:"
//					+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQn().get(0).getInput1221t1() : ""));
//
//			table5a.addCell(table5);
//			table5a.setSpacingAfter(25f);
//			document.add(table5a);
//
//			document.add(paragraph54);
//
//			table6.addCell(cell611);
//			table6.addCell(cell612);
//			table6.addCell(cell613);
//			table6.addCell(cell614);
//			table6.addCell(cell615);
//			table6.addCell(cell616);
//			table6.addCell(cell617);
//			table6.addCell(cell618);
//			table61.addCell(
//					"1.3.1	Institution integrates crosscutting issues relevant to Professional Ethics ,Gender, Human Values ,Environment and Sustainability into the Curriculum\r\n");
//			table61.addCell("Response:"
//					+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQl().get(0).getResponse131()
//							: ""));
//			
//			table61.addCell("Human Values and Professional Ethics\r\n" + "");
//			
//			
//			table61.addCell(
//					"Mother Teresa believes that its graduates/post-graduates have a responsibility to their Profession and the Organization that they serve. Every employer expects a certain set of skills, knowledge, inputs and attitude in an employee. Attitude normally gets reinforced through the three Es�: Education, Environment, and Experience. Therefore, our Institution takes adequate care to infuse a positive attitude in our learners by giving relevant inputs, which touch human lives at large. Courses such as �Human Values and Professional Ethics�, �Business Ethics�, Construction Management, Estimation and Costing, Engineering Economics and Accountancy facilitate development of a holistic perspective among students towards life, profession, empathy and happiness, based on the right understanding of the purpose of human existence, inculcating self-actualization, the highest of the Maslow�s pyramid of hierarchy of needs. Such a holistic perspective forms the basis of value-based education and quality of college life provided at Mother Teresa.\r\n"
//							+ "\r\n"
//							+ "Students are sensitized to Professional Ethics, through various activities organized under the students� clubs so that as they graduate, they are able to discharge their professional responsibilities with integrity, dignity, fairness and courtesy. They are also sensitized to avoid activities which may lead to conflict with colleagues and/or organizations, not accept any financial/contractual obligation on behalf of his/her employer/client without due authority, treat colleagues and co-workers fairly and not misuse the advantage of their hierarchical position\r\n\r\n"
//							+ "Gender equality and Sensitization:\r\n\r\n" + "\r\n"
//							+ "For students to demonstrate sensitivity with regard to gender issues, particularly on biological changes with age, showing empathy and practicing healthy socialization is imminent for both the genders.A course on �Gender Sensitization� introduced in the curriculum is implemented through activity-based learning. Gender issues are also discussed in courses, namely, �Human Resource Management� and �Indian Constitution�. For promoting Gender Sensitization, several activities are organized in the institution which include, �Gender Equality - Its importance�, �Women in Nation Building�, �Training on self-defense techniques�, �Health and Hygiene� and �Impact of gender violence on society�. They are also sensitized to respect women and their contribution to the economy and development of the society and practice\r\n"
//							+ "gender equality by sharing domestic duties and the like.\r\n" + "\r\n"
//							+ "Environment and Sustainability:\r\n" + "\r\n"
//							+ "To create awareness about the environmental impact on society due to urbanization and industrialization, courses on �Environmental Studies�, �Green Buildings�, �Global Warming and Climate Change�, �Renewable Energy Sources�, �Energy Conservation Management�, �Environmental Engineering�, �Air Pollution and Control� are included in the curriculum, which facilitates students to understand the ecosystem, its functions, and acquire knowledge about the different types of natural resources, namely, land, water, minerals, non-renewable energy, their excessive usage leads to detrimental effects on the environment is realized by understanding the different types of pollution, their impact on global environment and ways of controlling them. Campaigns on �Dust and Pollution Free Environment�, �Haritha Haram� (tree plantation), �Swachh Bharath�, are conducted with participation of students to promote ecological balance for sustainable development.\r\n\r\n"
//							+ "");
//
//			// PdfPTable cell700= new pdfpTable()
//			table61.addCell(table6);
//			table.setSpacingAfter(25);
//			document.add(table61);
//
//			// document.add(paragraph64);
//			// document.add(paragraph65);
//
//			// document.add(paragraph66);
////			table7.addCell(cell71);
////			table7.addCell(cell72);
////			table7.addCell(cell73);
////			table7.addCell(cell74);
////			table7.addCell(cell75);
////			table7.addCell(cell76);
////			table7.addCell(cell77);
////			table7.addCell(cell78);
////			table7.addCell(cell79);
////			table7.addCell(cell80);
//			table71.addCell(
//					"1.3.2 Number of value-added courses for imparting transferable and life skills offered during last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Record != null
//									? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponseValue132()
//									: ""));
//			table71.addCell("1.3.2.1 How many new value-added courses are added within the last five years");
//
//			table71.setSpacingBefore(25f);
//			table71.setSpacingAfter(25f);
//
//			Table table1321 = new Table(criteria1Record.getYearTable1321().size(), 2);
//
//			table1321.setPadding(10);
//			table1321.setWidth(100f);
//			for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {
//				table1321.addCell(criteria1Record.getYearTable1321().get(i).getInput1321y());
//			}
//			for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {
//				table1321.addCell(criteria1Record.getYearTable1321().get(i).getInput1321v());
//			}
//
//			document.add(table71);
//			// document.add(table1321);
//			table71.addCell(table7);
//
////			table82.addCell(cell821);
////			table82.addCell(cell822);
////			table82.addCell(cell823);
////			table82.addCell(cell824);
////			table82.addCell(cell825);
////			table82.addCell(cell826);
////			table82.addCell(cell827);
////			table82.addCell(cell828);
////			table82.addCell(cell829);
////			table82.addCell(cell8230);
//			table81.addCell(
//					"1.3.2 Number of value-added courses for imparting transferable and life skills offered during last five years.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Record != null
//									? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponseValue132()
//									: ""));
//
//			table81.addCell("1.3.2.1 How many new value-added courses are added within the last five years\r\n");
//
//			// table81.addCell(table82);
//
//			document.add(table81);
//			// document.add(table1321);
//
//			table8.addCell(cell81);
//			table8.addCell(cell82);
//			table8.addCell(cell83);
//			table8.addCell(cell84);
//			table8.addCell(cell85);
//			table8.addCell(cell86);
//			table8.addCell(cell87);
//			table8.addCell(cell88);
//			table8.addCell(cell89);
//			table8.addCell(cell90);
//
//			table8.setSpacingAfter(25f);
//			document.add(table1321);
//			document.add(table8);
//
////			table9.addCell(cell91);
////			table9.addCell(cell92);
////			table9.addCell(cell93);
////			table9.addCell(cell94);
////			table9.addCell(cell95);
////			table9.addCell(cell96);
////			table9.addCell(cell97);
////			table9.addCell(cell98);
////			table9.addCell(cell99);
////			table9.addCell(cell100);
//			table91.addCell("1.3.3 Average Percentage of students enrolled in the courses under 1.3.2 above.\r\n" + "\r\n"
//					+ "Response:"
//					+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse133()
//							: ""));
//
//			table91.addCell("\r\n\r\n 1.3.3.1 Number of students enrolled in subject related Certificate or Add-on programs year wise during last five years");
//			// table91.addCell(table9);
//			table9.setSpacingAfter(25f);
//
//			Table table1331 = new Table(criteria1Record.getYearTable1331().size(), 2);
//
//			table1331.setPadding(10);
//			table1331.setWidth(100f);
//			for (int i = 0; i < criteria1Record.getYearTable1331().size(); i++) {
//				table1331.addCell(criteria1Record.getYearTable1331().get(i).getInput1331y());
//			}
//			for (int i = 0; i < criteria1Record.getYearTable1331().size(); i++) {
//				table1331.addCell(criteria1Record.getYearTable1331().get(i).getInput1331v());
//			}
//			// document.add(table1331);
//
//			document.add(table91);
//
//			table92.addCell(cell921);
//			table92.addCell(cell922);
//			table92.addCell(cell923);
//			table92.addCell(cell924);
//			table92.addCell(cell925);
//			table92.addCell(cell926);
//			table92.addCell(cell927);
//			table92.addCell(cell928);
//
//			document.add(table1331);
//			// table92.addCell(table9);
//			document.add(table92);
//
//			table10.addCell(cell101);
//			table10.addCell(cell102);
//			table10.addCell(cell103);
//			table10.addCell(cell104);
//			table10.addCell(cell105);
//			table10.addCell(cell106);
//			table10.addCell(cell107);
//			table10.addCell(cell108);
//
//			table101.addCell(
//					"1.3.4 Percentage of students undertaking field projects/ internships / student projects (Data for the latest completed academic year)\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Record != null
//									? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse134()
//									: ""));
//			table101.addCell("1.3.4.1 Number of students undertaking field projects / internships / student projects\r\n"
//					+ "\r\n" + "Response:"
//					+ (criteria1Record != null ? criteria1Record.getCriteria1FieldInfoQn().get(0).getInput1341t1() : ""));
//			table101.addCell(table10);
//
//			table101.setSpacingBefore(25f);
//			table101.setSpacingAfter(25f);
//			document.add(table101);
//			document.add(paragraph67);
//
//			table111.addCell(cell111);
//			table111.addCell(cell112);
//			table111.addCell(cell113);
//			table111.addCell(cell114);
//			table111.addCell(cell115);
//			table111.addCell(cell116);
//			table111.addCell(cell117);
//			table111.addCell(cell118);
//			table111.addCell(cell119);
//			table111.addCell(cell1120);
//			table110.addCell(
//					"1.4.1 Structured feedback for design and review of syllabus � semester-wise / year-wise is received from 1) Students, 2) Teachers, 3) Employers, 4) Alumni\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Record != null
//									? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse141()
//									: ""));
//
//			table110.addCell(table111);
//			document.add(table110);
//
//			table12.addCell(cell121);
//			table12.addCell(cell122);
//			table12.addCell(cell123);
//			table12.addCell(cell124);
//			table12.addCell(cell125);
//			table12.addCell(cell126);
//			table12.addCell(cell127);
//			table12.addCell(cell128);
//			table121.addCell(
//					"1.4.2 The feedback system of the Institution comprises of the following :\r\n" + "\r\n" + "Response:"
//							+ (criteria1Record != null
//									? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse142()
//									: ""));
//
//			table121.addCell(table12);
//			table121.setSpacingBefore(25f);
//			table121.setSpacingAfter(25f);
//
//			document.add(table121);
//	
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
//}
