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
//public class AffiliatedCriteria26Report2 {
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
//	public String generateReport(Criteria2_FieldInfo criteria2Fieldinfo ) throws DocumentException, IOException {
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
//			
//		
//
//			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			
//
//			document.add(paragraph2criteria2);
//		
//			tablecriteria2.setWidthPercentage(100f);
//
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
//			Paragraph paragraph8criteria23 = new Paragraph(
//					"2.6.1 Programme and course outcomes for all Programmes offered by the institution are stated and displayed on website and communicated to teachers and students.Mothertherisa has adequate measures to communicate the COs, both to the teachers and students well in time ahead of the beginning of the Course work, in the following manner:"
//							+ "\r\n" + "" + "Response:");
//			
//			document.add(paragraph8criteria23);
//			
//			if(criteria2Fieldinfo.getCriteria2FieldInfoQl() !=null)
//			{
//			Paragraph paragraph8criteria24 = new Paragraph(criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse261()
//									: "");
//			
//			document.add(paragraph8criteria24);
//			}
//			
////			PdfPCell cell0012 = new PdfPCell(new Paragraph(
////					 (criteria2Record != null
////									? criteria2Record.getCriteria2FieldInfoQl().get(0).getInput261t1()
////									: "")));
////			
////			
////			
////
////			table27.addCell(cell012);
////
////			table27.addCell(cell0012);
////			
////
////			table27.addCell("Following are sample Course Outcomes of UG program of each department:\r\n" + "\r\n"
////					+ "1.	B. Tech Civil Engineering and B. Tech Mechanical Engineering:\r\n" + "\r\n"
////					+ "Course: Engineering Mechanics-I\r\n" + "\r\n"
////					+ "1.	Describe position, forces, and moments in terms of vector notation in two and three dimensions.\r\n"
////					+ "2.	Draw free body diagrams accurately and write appropriate equilibrium equations from the free body diagram, including support reactions.\r\n"
////					+ "3.	Apply concepts of equilibrium to analyse systems that include frictional forces.\r\n"
////					+ "4.	Calculate centroids and centres of mass for discrete particles.\r\n"
////					+ "5.	Calculate moments of Inertia for standard sections and composite sections.\r\n" + "\r\n"
////					+ "2.	B. Tech Electrical and Electronics Engineering and B. Tech Electronics and Communication Engineering\r\n"
////					+ "\r\n" + "Course: Digital Design\r\n" + "\r\n"
////					+ "CO1. Perform conversions from one number system to another.\r\n" + "\r\n" + "\r\n"
////					+ "CO2. Simplify switching functions using Boolean minimization theorems, map method and tabulation method.\r\n"
////					+ "\r\n" + "/r/n"
////					+ "CO3. Analyze and design combinational logic circuits and the effect of Static Hazards on these circuits.+\r\n"
////					+ "CO4. Synthesize symmetric functions using relay contact networks.\r\n" + "\r\n"
////					+ "CO5. Design switching circuits using threshold elements.+\r\n" + "\r\n"
////					+ " CO6. Analyze and Design Sequential logic Circuits\r\n" + "\r\n"
////					+ "B.Tech Computer Science and Engineering, B.Tech Computer Science and Engineering (Emerging Areas of Specializations) and B. Tech Information Technology\r\n"
////					+ "\r\n" + "\r\n" + "Course: Data Structures\r\n" + "\r\n"
////					+ "CO1. Explain the basic concepts of Abstract Data Types, Linear and Non-Linear Data structures.+\r\n"
////					+ "\r\n" + "CO2. Calculate the performance of the different algorithms in terms of time and space.\r\n"
////					+ "CO3. Write programs in C for different data structures like stacks, queues, linked lists (singly and doubly).\r\n"
////					+ " \r\n" + "CO4. Select appropriate data structure for a given problem.\r\n" + "\r\n"
////					+ "CO5. Write C programs for various searching algorithms, sorting algorithms and nonlinear data structures such as trees and graphs.\r\n"
////					+ "\r\n" + "3.	M. Tech Computer Science and Engineering\r\n" + "\r\n" + "Course: Machine Learning\r\n"
////					+ "\r\n" + "CO1: Understand the concepts of computational intelligence like machine learning\r\n"
////					+ "\r\n"
////					+ "CO2: Ability to get the skill to apply machine learning techniques to address the real time problems in different areas\r\n"
////					+ "\r\n" + "CO3: Understand the Neural Networks and its usage in machine learning application.\r\n"
////					+ "\r\n"
////					+ "CO4: Student should be able to understand the basic concepts such decision tree and neural networks. CO5: Ability to formulate machine learning techniques to respective problems.\r\n"
////					+ "4.	MBA\r\n" + "\r\n" + "Course: Marketing Management\r\n" + "\r\n"
////					+ "CO1: Understanding the concepts of Marketing Management. CO2: Analyze markets.\r\n" + "\r\n"
////					+ "CO3: Design customer driven strategies.\r\n" + "\r\n"
////					+ "CO4: Communicate the decisions towards business development with superior customer value. CO5: Know the concepts of pricing decisions and concepts of personal communication.\r\n"
////					+ "");
////			document.add(table27);
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
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table28.addCell(cell82criteria2);
//
//			PdfPCell cell83criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
//			table28.addCell(cell83criteria2);
//
//			PdfPCell cell84criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() :""));
//			table28.addCell(cell84criteria2);
//			
//			PdfPCell cell830criteria2 = new PdfPCell(new Paragraph("Upload COs for all courses (exemplars from Glossary)\r\n\r\n"));
//			table28.addCell(cell830criteria2);
//
//			PdfPCell cell840criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() :""));
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
////			
////			PdfPCell cell013 = new PdfPCell(new Paragraph(
////				"2.6.2 Attainment of programme outcomes and course outcomes are evaluated by the institution." + "\r\n"
////						+ "" + "" + "Response:"
////						+ (criteria2Record != null
////								? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse262()
////								: ""),font3));
////			
////			
////			PdfPCell cell0013 = new PdfPCell(new Paragraph(
////					(criteria2Record != null
////									? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput262t1()
////									: "")));
////			
////			
////			
////			
////
////			table29.addCell(cell013);
////			table29.addCell(cell0013);
////			document.add(table29);
////
////			PdfPTable table30 = new PdfPTable(2);
////			
////	        table30.setWidthPercentage(100f);
////	        
////	        PdfPTable table300 = new PdfPTable(1);
////	        table300.setWidthPercentage(100f);
////			table30.setWidths(new int[] { 3, 3 });
////			
////
////			PdfPCell cell85criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
////			table30.addCell(cell85criteria2);
////
////			PdfPCell cell86criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
////			table30.addCell(cell86criteria2);
////
////			PdfPCell cell87criteria2 = new PdfPCell(new Paragraph("upload for any additional information\r\n\r\n"));
////			table30.addCell(cell87criteria2);
////
////			PdfPCell cell88criteria2 = new PdfPCell(
////					new Paragraph(criteria2Record != null ? criteria2file.get(28).getCriteria2FilePath() : ""));
////			table30.addCell(cell88criteria2);
////			
////			PdfPCell cell870criteria2 = new PdfPCell(new Paragraph("Paste link for any additional information\r\n\r\n"));
////			table30.addCell(cell870criteria2);
////
////			PdfPCell cell880criteria2 = new PdfPCell(
////					new Paragraph(criteria2Record != null ? criteria2file.get(29).getCriteria2FilePath() : ""));
////			table30.addCell(cell880criteria2);
//			
////			table300.addCell("Mother Teresa follows all the norms of the Statutory Regulatory Authorities in evaluating/measuring the\"\r\n"
////					+ "attainment of both Program Outcomes (POs) and Course Outcomes (COs):\\r\\n\" + \"\\r\\n\"\r\n"
////					+ "Procedure for measuring attainment of COs:\\r\\n\" + \"\\r\\n\"\r\n"
////					+ "	1.	CO attainments are calculated by considering marks obtained in each question of all the students who attend mid-term (CIE) and semester end examinations (SEE).\\r\\n\"\r\n"
////					+ "	2.	For Objective Paper of mid-term examinations, Assignments and Tutorials, overall CO attainment is calculated, which is made applicable to all COs.\\r\\n\"\r\n"
////					+ "	3.	For measuring the attainments of COs of a theory course, the targets fixed are:\\r\\n\"\r\n"
////							
////					+ "	Mid-Term Subjective: 60% of maximum marks related to each CO Assignments and Tutorials (if any): 60% of maximum marks\\r\\n\"\r\n"
////					+ "	Mid-Term Objective: 60% of maximum marks\\r\\n\"\r\n"
////					+ "	Semester End Examination: 60% of maximum marks related to each CO\\r\\n\" + \"\\r\\n\"\r\n"
////					+ "	1.Attainment levels are calculated as follows:\\r\\n\" + \"\\r\\n\"\r\n"
////					+ "	Semester End Examination (SEE)\\r\\n\" + \"Levels for CO attainment measurement\\r\\n\"\r\n"
////					+ "Level 1	> or = 40% and <50% of Students attain the target Marks\\r\\n\"\r\n"
////					+ "	Level 2	> or = 50% and <60% of Students attain the target Marks\\r\\n\"\r\n"
////					+ "	Level 3	> or = 60% of Students attain the target Marks\\r\\n\" + \"\\r\\n\" + \"\\r\\n\" + \"\\r\\n\"\r\n"
////					+ "	Mid-term Exams � Subjective, Objective, Assignments and Tutorials (CIE)\\r\\n\"\r\n"
////					+ "	Levels for CO attainment measurement\\r\\n\" + \"\\r\\n\"\r\n"
////					+ "	Level 1	> or = 60% and <70% of students attain the target\\r\\n\"\r\n"
////					+ "	Level 2	> or = 70% to <80% of students attain the target\\r\\n\"\r\n"
////					+ "	Level 3	> or = 80% of students attain the target\\r\\n\" + \"\\r\\n\" + \"\\r\\n\" + \"\\r\\n\"\r\n"
////					+ "	Indirect attainment � Course End Survey, CRC and TLP feedback\\r\\n\" + \"\\r\\n\"\r\n"
////					+ "	Levels for CO attainment measurement\\r\\n\"\r\n"
////					+ "	Level 1	> or = 60% and <70% of feedback score\\r\\n\"\r\n"
////					+ "	Level 2	> or = 70% and <80% of feedback score\\r\\n\"\r\n"
////					+ "	Level 3	> or = 80% of feedback score\\r\\n\"\r\n"
////					+ "	1.	In the case of �Either-or� question, maximum marks scored by student is considered for CO attainment.\\r\\n\"\r\n"
////					+ "	2.	Direct and indirect measurements for CO attainment:\\r\\n\"\r\n"
////					+ "	2.1	Weightage for Direct measurement: 60% for SEE , 40% for CIE\\r\\n\"\r\n"
////					+ "2.2	Direct Attainment of CO = 0.2* Mid-term Subjective + 0.1* Mid-term Objective + 0.05*\\r\\n\"\r\n"
////					+ "	Assignment + 0.05* Tutorial + 0.6* SEE.\\r\\n\" + \" \\r\\n\"\r\n"
////					+ "2.3	Indirect Attainment of COs through feedback = 0.4* TLP+ 0.4* CRC + 0.2* CES\\r\\n\"\r\n"
////					+ "2.4	Overall CO Attainment = 0.75* Direct Attainment Level + 0.25* Indirect Attainment Level\\r\\n\"\r\n"
////					+ "3.	For practical examinations (CIE and SEE), 60% of maximum marks are kept as target for attainment. Distribution of marks: SEE-70, CIE-30(Mid-Term-15, Day to day-15)\\r\\n\"\r\n"
////					+ "3.1	CO attainment levels:\\r\\n\" + \"80% for Level3, 70% for Level2 and 60% for Level1\"\r\n"
////					+ "	3.2	Overall CO Attainment = 0.75* Direct Attainment Level + 0.25* Indirect Attainment\"\r\n"
////					+ "3.3	Similar procedure is adopted for Projects, Seminars, Mini Projects, and Internships.\"\r\n"
////					+ "\r\n"
////					+ "	Procedure for measuring the attainments of POs and PSOs");
////			
////			
////			
////
////			document.add(table30);
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
//			Paragraph paragraph8criteria24 = new Paragraph("2.6.2 Pass Percentage of students(Data for the latest completed academic year)\r\n"
//					+ "\r\n" + "\"Response:");
//			
//			document.add(paragraph8criteria24);
//			
//			if(criteria2Fieldinfo.getCriteria2FieldInfoQn() !=null)
//			{
//			Paragraph paragraph8criteria25 = new Paragraph (criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse262()
//							: "");
//			document.add(paragraph8criteria25);
//	
//			}
//			
//			Paragraph paragraph8criteria26 = new Paragraph("2.6.2.1: Total number of final year students who passed the examination conducted by Institution.");
//			document.add(paragraph8criteria26);
//			if(criteria2Fieldinfo.getCriteria2FieldInfoQl() !=null)
//			{
//			Paragraph paragraph8criteria27= new Paragraph (criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getInput262t1()
//					: "");
//			document.add(paragraph8criteria27);
//			}
//			
//			Paragraph paragraph8criteria299 = new Paragraph("\r\n");
//			document.add(paragraph8criteria299);
//			Paragraph paragraph8criteria28= new Paragraph("2.6.2.2: Total number of final year students who passed the examination conducted by Institution.");
//			document.add(paragraph8criteria28);
//			if(criteria2Fieldinfo.getCriteria2FieldInfoQl() !=null)
//			{
//			Paragraph paragraph8criteria29= new Paragraph (criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getInput262t2()
//					: "");
//			document.add(paragraph8criteria29);
//			}
//			
//			
//			
//			
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
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table32.addCell(cell92criteria2);
//
//			PdfPCell cell93criteria2 = new PdfPCell(new Paragraph("Upload any  the annual report\r\n\r\n"));
//			table32.addCell(cell93criteria2);
//
//			PdfPCell cell94criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table32.addCell(cell94criteria2);
//			PdfPCell cell930criteria2 = new PdfPCell(new Paragraph("Paste link for annual report\r\n\r\n"));
//			table32.addCell(cell930criteria2);
//
//			PdfPCell cell940criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table32.addCell(cell940criteria2);
//			document.add(table32);
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
