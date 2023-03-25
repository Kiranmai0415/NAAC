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
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import com.adiverse.erp.model.Criteria6_FieldInfo;
//import com.adiverse.erp.model.Criteria6_FileUpload;
//import com.adiverse.erp.service.Criteria6Service;
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
//
//@Component
//public class UniversityCriteria61Report {
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
//				reportPath = "UniversityCriteria6Report-" + strDate + ".pdf";
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
//					"6.1.1 The institution has a clearly stated vision and mission which are reflected in its academic and\r\n"
//					+ "administrative governance."
//							+ "\r\n\r\n" + "Response:"
//							+ (criteria6Fieldinfo != null
//									? criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse611()
//									: ""),
//					font3);
//			paragraph3criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			com.lowagie.text.Font font0Title1 = FontFactory.getFont(FontFactory.HELVETICA);
//			font0Title1.setSize(12);
//
//			document.add(paragraph3criteria6);
////			Paragraph paragraph4criteria6 = new Paragraph(
////					"Mother Teresa has an Organizational Structure ensuring good governance, reflective of both, an Effective Leadership as also in tune with the Institutional Vision and Mission.\r\n"
////							+ "\r\n" + "",
////					font3);
////			paragraph4criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph4criteria6);
////
////			/*
////			 * com.lowagie.text.Font font0Title2 =
////			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); font0Title2.setSize(12);
////			 */
////			Paragraph paragraph5criteria6 = new Paragraph("Vision:", font3);
////			paragraph5criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph5criteria6);
////
////			/*
////			 * com.lowagie.text.Font font0Title3 =
////			 * FontFactory.getFont(FontFactory.HELVETICA); font0Title3.setSize(12);
////			 */
////			Paragraph paragraph6criteria6 = new Paragraph(
////					"Mother Teresa visualizes dissemination of knowledge and skills to students, who would eventually contribute to the wellbeing of the people of the nation and global community.\r\n"
////							+ "\r\n"
////
////							+ "",
////					font3);
////			paragraph6criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph6criteria6);
////
////			/*
////			 * com.lowagie.text.Font font0Title4 =
////			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); font0Title4.setSize(12);
////			 */
////			Paragraph paragraph7criteria6 = new Paragraph("Mission:" + "", font3);
////			paragraph7criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph7criteria6);
////
////			Paragraph paragraph8criteria6 = new Paragraph(
////					"To impart adequate fundamental knowledge in all basic sciences and engineering, technical and inter-personal skills to students.\r\n"
////							+ "To bring out creativity in students that would promote innovation, research and entrepreneurship"
////							+ "\r\n"
////							+ " To preserve and promote cultural heritage, humanistic and spiritual values promoting peace and harmony in society.\r\n"
////							+ "\r\n" + "" + "",
////					font5);
////			paragraph8criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph8criteria6);
////
////			Paragraph paragraph9criteria6 = new Paragraph(
////					"College�s vision envisages that its graduating students contribute to national development and to the well- being of the global community.\r\n"
////							+ "\r\n" + "\r\n"
////							+ "The mission is to produce graduates possessing sound knowledge in basic sciences and technical skills, human values, a strong zeal to serve community, leading to realization of the institution�s vision, which calls for good governance, requiring establishment of structures and processes, designed to ensure accountability, transparency, responsiveness, equity, empowerment, and participation. In line with these, and as per UGC guidelines for autonomous colleges, following statutory committees, namely, Governing Body, Academic Council, Boards of Studies, Finance Committee, and Women Protection Cell (now renamed as Internal Compliance Committee), are constituted, ensuring participation of teachers in decision making, proper management of academic, financial, and administrative matters of the college.\r\n"
////							+ "\r\n" + "" + "",
////					font5);
////			paragraph9criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph9criteria6);
////			Paragraph paragraph10criteria6 = new Paragraph(
////					"Further, several non-statutory committees comprising faculty, staff and students are also operative, assisting in the overall governance of the college. College promotes a culture of decentralized and participative management, extending down to Assistant Professor.\r\n"
////							+ "\r\n" + "\r\n"
////							+ "The Principal, as head of the institution is vested with overall responsibility to plan, organize, and control all activities, empowering Deans, Heads of Departments (HoDs), committees and in-charges of sections, carrying out institution�s day to day functions by delegating authority. Duties and responsibilities of Principal and other personnel are well laid and spelt out clearly in �Roles and Responsibilities� handbook of the institution.\r\n"
////							+ "\r\n"
////							+ "College organized its structure into departments/sections, and groups/divisions within departments. To\r\n"
////							+ " \r\n"
////							+ "assist Principal, Deans and HoDs, in the performance of their functions, many committees, namely, Planning and Monitoring Board, Grievance Redressal Committee, Admissions Committee, Examinations Committee, Student Welfare Committee, Anti-ragging committee, Library Committee, Extra-curricular activities Committee, Academic Audit Committee etc. are formed at institutional and department level, comprising faculty/staff at all levels. Committees are empowered to deliberate independently, investigate, and recommend actions on various issues, referred to them.\r\n"
////							+ "\r\n" + "\r\n"
////							+ "Institution�s perspective (Strategic) plan is developed by the Planning and Monitoring Board, in consultation with the Governing Body. Strategic plan is aimed at achieving short, medium and long-term goals of the college, aligning with its Vision and Mission. The strategic plan is translated into operational goals and plans for departments, facilitating achievement of targets giving a detail of time schedules along with resources required over the plan period.\r\n"
////							+ "\r\n" + "\r\n"
////							+ "All the above clearly ensure participative management at every level of the institution facilitating development of potential leaders in the college, a clear reflection and demonstration of effective leadership of college.\r\n"
////							+ "" + "",
////					font5);
////			paragraph10criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph10criteria6);
////	//create a table 1
////			PdfPTable table1criteria6 = new PdfPTable(2);
////			table1criteria6.setWidthPercentage(100);
////	//PdfPTable table11=new PdfPTable(2);
//	//table11.setWidthPercentage(100);
//			
//			PdfPTable table1criteria6 = new PdfPTable(2);
//			table1criteria6.setWidthPercentage(100);
//			PdfPCell cell1criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell2criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell3criteria6 = new PdfPCell(new Paragraph("Paste link for additional Information"));
//			PdfPCell cell4criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell5criteria6 = new PdfPCell(new Paragraph("Upload any additional information"));
//			PdfPCell cell6criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			table1criteria6.addCell(cell1criteria6);
//			table1criteria6.addCell(cell2criteria6);
//			table1criteria6.addCell(cell3criteria6);
//			table1criteria6.addCell(cell4criteria6);
//			table1criteria6.addCell(cell5criteria6);
//			table1criteria6.addCell(cell6criteria6);
//			table1criteria6.setSpacingBefore(20f);
//			table1criteria6.setSpacingAfter(20f);
//			document.add(table1criteria6);
//
//	//create table 2
////			PdfPTable table2criteria6 = new PdfPTable(2);
////			table2criteria6.setWidthPercentage(100);
////			PdfPTable table21criteria6 = new PdfPTable(1);
////			table21criteria6.setWidthPercentage(100);
////
////			PdfPCell cell21criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
////			PdfPCell cell22criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
////			PdfPCell cell23criteria6 = new PdfPCell(new Paragraph("Any aditional information\r\n\r\n\r\n"));
////			PdfPCell cell24criteria6 = new PdfPCell(
////					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")));
//////			PdfPCell cell25criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//////			PdfPCell cell26criteria6 = new PdfPCell(new Paragraph());
//////			PdfPCell cell27criteria6 = new PdfPCell(
//////					new Paragraph("Link for strategic plan and deployment documents on the website\r\n\r\n\r\n"));
//////			PdfPCell cell28criteria6 = new PdfPCell(new Paragraph(""));
////			table2criteria6.addCell(cell21criteria6);
////			table2criteria6.addCell(cell22criteria6);
////			table2criteria6.addCell(cell23criteria6);
////			table2criteria6.addCell(cell24criteria6);
////			table2criteria6.addCell(cell25criteria6);
////			table2criteria6.addCell(cell26criteria6);
////			table2criteria6.addCell(cell27criteria6);
////			table2criteria6.addCell(cell28criteria6);
////			table21criteria6.addCell(
////					"6.1.2	The effective leadership is reflected in various institutional practices such as decentralization and participative management.\r\n"
////							+ "\r\n" + "Response:\r\n" + "\r\n"
////							+ "Mother Teresa College of Engineering and Technology has a well laid practice of decentralization and participative management. Different committees, councils and cells are constituted viz., College Academic Council, Board of studies, Program Assessment Committee, College Academic committee, Research Committee and IQAC Cell etc. The roles and responsibilities of each committee/cell bearers and authorities and the structure of such organisational units are defined at the time of formation. A case study showcasing the practice of decentralization and participative management in the development of Course Outcomes, Course delivery methodology, Course attainments and Program Assessment is discussed below:\r\n"
////							+ "\r\n"
////							+ "The objectives are accomplished with the participation and coordinated functioning of the faculty at different levels, their roles being as follows:\r\n"
////							+ "\r\n" + "1.	Program Assessment Committee (PAC)\r\n" + "\r\n"
////							+ "PAC consists of Head of the Department (Program Coordinator unless the department offers more than one program) as the chairperson and Senior faculty members. The committee meets at least once in each semester to review the progress of the program.\r\n"
////							+ " \r\n"
////							+ "The committee monitors attainment of Course Outcomes (COs), Program Outcomes (POs) and Program Specific Outcomes (PSOs) with the major focus being the cumulative learning of the students undergoing the program.\r\n"
////							+ "\r\n"
////							+ "1.	Program Coordinator- In association with senior faculty, oversees all the courses offered by the department;\r\n"
////							+ "   *  Appoints Course Coordinators for each course offered and administered by the department;  Reviews the performance of students undertaking courses offered by the department;  o Ensures Institution's quality assurance processes for assessment in courses along with Academic Regulations, are implemented;\r\n"
////							+ "2.	Course coordinators - Discusses the course and its relationship to other courses within the program with the Program Coordinator\r\n"
////							+ "   *   Develops course outcomes for the course\r\n"
////							+ "   *   Schedules and conducts an orientation to the course for faculty, particularly who are new to the course.\r\n"
////							+ "   *   Develops a meaningful and well-connected topic sequence and schedules the same in consultation with other course instructors involved in the course and ensures adhering to the same.\r\n"
////							+ "   *   Develops valid and reliable methods to evaluate student learning outcomes\r\n\r\n"
////							+ "3.	Class Advisers (Section Advisor) - Discusses all potentially significant issues and establishes good communication with the students thereby making them fully aware of their responsibility to meet performance standards.\r\n"
////							+ "   *    Conducts weekly reviews with Counsellors, monitors student progress and documents reviews to establish a record of trends in overall class performance.\r\n\rn"
////							+ "4.	Question Paper Evaluation Committee � It consists of HoD, a few senior Professors Department IQAC representative and an invitee from other department. Chaired by the HoD, the committee examines the following:\r\n"
////							+ "   *    Mapping of course outcomes to Program outcomes vis-�-vis the questions Bloom�s Taxonomy level\r\n\r\n"
////							+ "   *    Discriminating power to distinguish bright and average student\r\n"
////							+ "   *  Specific and precise nature of questions as well as uniform coverage of the content.\r\n"
////							+ "\r\n" + "\r\n" + "\r\n"
////							+ "All the above clearly indicate decentralization at the department, wherein, faculty members participate not only in administering, monitoring the Teaching-Learning process, but also, in the evaluation and assessment of COs, POs and PSOs.\r\n"
////							+ "");
////
////			table2criteria6.setSpacingBefore(20f);
////			table2criteria6.setSpacingAfter(20f);
////			table21criteria6.addCell(table2criteria6);
////			document.add(table21criteria6);
//			
//			
//			Paragraph paragraph3criteria612 = new Paragraph("6.1.2: The effective leadership is reflected in various institutional practices such as decentralization and participative management.");
//			
//            document.add(paragraph3criteria612);
//            
//            
//            if(criteria6Fieldinfo.getCriteria6FieldInfoQl() !=null)
//            		{
//            Paragraph paragraph3criteria613 = new Paragraph(criteria6Fieldinfo != null
//					? criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse611():"");
//            document.add(paragraph3criteria613);
//            
//            
//            		}
//            
//            Paragraph paragraph3criteria613 = new Paragraph("\r\n");
//            document.add(paragraph3criteria613);
//            PdfPTable table11criteria6 = new PdfPTable(2);
//			table1criteria6.setWidthPercentage(100);
//			PdfPCell cell11criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell21criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell31criteria6 = new PdfPCell(new Paragraph("Paste link for additional Information"));
//			PdfPCell cell41criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell51criteria6 = new PdfPCell(new Paragraph("Upload any additional information"));
//			PdfPCell cell61criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			table11criteria6.addCell(cell11criteria6);
//			table11criteria6.addCell(cell21criteria6);
//			table11criteria6.addCell(cell31criteria6);
//			table11criteria6.addCell(cell41criteria6);
//			table11criteria6.addCell(cell51criteria6);
//			table11criteria6.addCell(cell61criteria6);
////			table11criteria6.setSpacingBefore(20f);
////			table11criteria6.setSpacingAfter(20f);
//			document.add(table11criteria6);
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
//		}
//
//
//			
//			
//			
//	
//
//
