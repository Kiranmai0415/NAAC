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
public class UniversityCriteria11Report2 {
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
	
	
    @Autowired 
    Criteria1Service service1;
	
	List<Criteria1_FieldInfo> criteria1List =null;

	Criteria1_FieldInfo criteria1Record =null;
	
	
	List<Criteria1_FileUpload> criteria1file = null;
	
	
	public String generateReport( Criteria1_FieldInfo criteria1Fieldinfo) throws DocumentException, IOException {
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
				System.out.println("is empty===>"+ criteria1List.get(0));
			//System.out.println("criteria1Record.getCriteria1FileUpload()======>"+criteria1Record.getCriteria1FileUpload().size());
				criteria1Record = criteria1List.get(0);
				criteria1file = criteria1Record.getCriteria1FileUpload();
			} else {
				criteria1Record = new Criteria1_FieldInfo();
				criteria1file = new ArrayList<Criteria1_FileUpload>();
			}
			
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "UniversityCriteria1Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
	
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
			
			
			
			Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
			paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph);

			Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font2);
			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph1);
			Paragraph paragraph2 = new Paragraph("1.1 Curriculum Design and Development\r\n", font3);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph2);

		
//
//			Paragraph paragraph3 = new Paragraph(
//					"1.1.1 Curricula developed and implemented have relevance to the local, national, regional and global developmental needs which is reflected in Programme outcomes (POs), Programme Specific Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered by the Institution.\r\n",
//					font3);
//			paragraph3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph3);
//			
			

			PdfPTable table111criteria1 = new PdfPTable(1);
//			System.out.println("criteria1Record=========>"+criteria1Record.getCriteria1FieldInfoQl());
		

			table111criteria1.setWidthPercentage(100);
//			PdfPCell cell111criteria1 = new PdfPCell(
//					new Paragraph("1.1.1 Curricula developed and implemented have relevance to the local, "
//							+ "national, regional and global developmental needs which is reflected in Programme outcomes (POs), "
//							+ "Programme Specific Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered by the Institution.\r\n"
//							+ "Response:"+(criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQl().get(0).getResponse111()
//									: ""), font3));
//
//			table111criteria1.addCell(cell111criteria1);

			table111criteria1.setSpacingBefore(20f);
			table111criteria1.setSpacingAfter(20f);
			document.add(table111criteria1);
			
			// creating table
						PdfPTable table = new PdfPTable(2);

						table.setWidthPercentage(100);

						// create table for header
						PdfPCell cell1 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font3));
						PdfPCell cell2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
						PdfPCell cell3 = new PdfPCell(new Paragraph("\r\nAny Upload aditional information\r\n\r\n", font5));
						PdfPCell cell4 = new PdfPCell(
								new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
						PdfPCell cell5 = new PdfPCell(new Paragraph("\r\nLink for Aditional information\r\n\r\n", font5));
						PdfPCell cell6 = new PdfPCell(new Paragraph(" "));
						
						table.addCell(cell1);
						table.addCell(cell2);
						table.addCell(cell3);
						table.addCell(cell4);
						table.addCell(cell5);
						table.addCell(cell6);
						document.add(table);	
						
						
						
//				Paragraph paragraph34 = new Paragraph(
//						"1.1.2 Percentage of Programmes where syllabus revision was carried out during the last five years.\r\n"
//										+"Response\r\n"
//												+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse112()
//														: ""),
//								font3);
//						paragraph34.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//						
//		  	document.add(paragraph34);			
	//////////////////////////////////////////////////////////	  	
			Paragraph paragraph36 = new Paragraph(
					"1.1.2.1 How many Programmes were revised out of total number of Programmes offered during the last five years.\r\n\r\n"
							+ "",
					font3);
			paragraph36.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			document.add(paragraph36);

		
//			Paragraph paragraph37 = new Paragraph("Response:"
//					+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1121t1() : ""),
//					font5);
//			paragraph37.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			
//			document.add(paragraph37);

			Paragraph paragraph38 = new Paragraph(
					"1.1.2.2 Number of all Programmes offered by the institution during the last five years",
					font5);
			paragraph38.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			document.add(paragraph38);

//			Paragraph paragraph39 = new Paragraph("Response:"
//					+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1122t1() : ""),
//					font5);
//			paragraph39.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//	document.add(paragraph39);
	
	
	

	PdfPTable table1 = new PdfPTable(2);
	table1.setWidthPercentage(100);
	PdfPCell cell11 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font3));
	PdfPCell cell12 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font3));
	PdfPCell cell13 = new PdfPCell(new Paragraph("\r\nMinutes of relevant Academic Council/BOS meeting\r\n\r\n", font3));
	PdfPCell cell14 = new PdfPCell(
			new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
	PdfPCell cell19 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n"));
	PdfPCell cell20 = new PdfPCell(new Paragraph(""));
	PdfPCell cell17 = new PdfPCell(new Paragraph("\r\nDetails of program syllabus revision in last 5 years(Data Template)"));
	PdfPCell cell18 = new PdfPCell(
			new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : ""));
	

	
	table1.addCell(cell11);
	table1.addCell(cell12);
	table1.addCell(cell13);
	table1.addCell(cell14);
	table1.addCell(cell19);
	table1.addCell(cell20);
	table1.addCell(cell17);
	table1.addCell(cell18);

	document.add(table1);
	
	PdfPTable table31 = new PdfPTable(1);
	table31.setWidthPercentage(100);
//	table31.addCell(
//			"1.1.3 Average percentage of courses having focus on employability/ entrepreneurship/ skill development offered by the institution during the last five years\r\n"
//					+ "\r\n" + "Response:"
//					+ (criteria1Fieldinfo != null
//							? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse113()
//							: ""));
//	table31.addCell(
//			"1.1.3.1 Number of courses having focus on employability/ entrepreneurship/ skill development year- wise during the last five years\r\n+\r\n");

	// table31.addCell(table113_1);

	table31.setSpacingBefore(25);
	table31.setSpacingAfter(25);

	document.add(table31);
	
	
	Table table1131 = new Table(criteria1Record.getYearTable1131().size(), 2);

	table1131.setPadding(10);
	table1131.setWidth(100f);

	for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
		table1131.addCell(criteria1Record.getYearTable1131().get(i).getInput1131y());
	}
	for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
		table1131.addCell(criteria1Record.getYearTable1131().get(i).getInput1131v());
	}

 document.add(table1131);
 
 Table table11312 = new Table(criteria1Record.getYearTable11312().size(), 2);

 table11312.setPadding(10);
 table11312.setWidth(100f);

	for (int i = 0; i < criteria1Record.getYearTable11312().size(); i++) {
		table11312.addCell(criteria1Record.getYearTable11312().get(i).getInput11312y());
	}
	for (int i = 0; i < criteria1Record.getYearTable11312().size(); i++) {
		table11312.addCell(criteria1Record.getYearTable11312().get(i).getInput11312v());
	}

document.add(table11312);

 
 
  	
  	/////////////////////////////////////////////////////

			
	
//
//			Paragraph paragraph4 = new Paragraph("Response:"
//					+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQl().get(0).getResponse111()
//							: ""),
//					font3);
//			paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			
//			
//			Paragraph paragraph9 = new Paragraph("", font5);
//			paragraph9.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet1 = new Chunk("\u2022", font5);
//			paragraph9.add(bullet1);
//			paragraph9
//					.add(new Phrase("Core: Basic/Engineering Sciences, Humanities, Social Sciences and Engineering.\r\n"));
//
//			
//			Paragraph paragraph10 = new Paragraph(" ", font5);
//			paragraph10.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet2 = new Chunk("\u2022", font5);
//			paragraph10.add(bullet2);
//			paragraph10.add(new Phrase(
//					"Electives: Professional Electives which enrich students with technological advancements, and Open Electives which promote philosophy of liberal education."));
//
//			
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
//		
//			document.add(paragraph4);
////			document.add(paragraph5);
////			document.add(paragraph6);
////			document.add(paragraph7);
////			document.add(paragraph8);
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
//			
//			
//	
//			Paragraph paragraph35 = new Paragraph("Response\r\n"
//					+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse112()
//							: ""),
//					font3);
//			paragraph35.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			
		

			PdfPTable table3 = new PdfPTable(2);
			table3.setWidthPercentage(100);

			PdfPCell cell31 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font3));
			PdfPCell cell32 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
			PdfPCell cell33 = new PdfPCell(new Paragraph("\r\nProgramme / Curriculum/ Syllabus of the courses\r\n\r\n"));
			PdfPCell cell34 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : ""));
			PdfPCell cell35 = new PdfPCell(new Paragraph("\r\nMoU's with relevant organizations for these courses, if any\r\n\r\n"));
			PdfPCell cell36 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : ""));

			PdfPCell cell37 = new PdfPCell(new Paragraph(
					"\r\nMinutes of the Boards of Studies/ Academic Council meetings with approvals for these courses\r\n\r\n"));
			PdfPCell cell38 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : ""));
			PdfPCell cell39 = new PdfPCell(new Paragraph(
					"\r\nAverage percentage of courses having focus on employability/ entrepreneurship(Data Template\r\n\r\n)"));
			PdfPCell cell40 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
			PdfPCell cell41 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n"));
			PdfPCell cell42 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
			
			table3.addCell(cell31);
			table3.addCell(cell32);
			table3.addCell(cell33);
			table3.addCell(cell34);
			table3.addCell(cell35);
			table3.addCell(cell36);
			table3.addCell(cell37);
			table3.addCell(cell38);
			table3.addCell(cell39);
			table3.addCell(cell40);
			table3.addCell(cell41);
			table3.addCell(cell42);
			
			document.add(table3);
			

			/*
			 * com.lowagie.text.Font fontTitle43 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle43.setSize(16)
			 */


			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}
	
}
