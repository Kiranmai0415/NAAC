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
//public class AffiliatedCriteria61Report {
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
//			
//			Paragraph paragraph2criteria61 = new Paragraph("Governance, Leadership and Management");
//			paragraph2criteria61.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			paragraph2criteria61.setAlignment(Paragraph.ALIGN_CENTER);
//			document.add(paragraph2criteria61);
//			
//			Paragraph paragraph2criteria6 = new Paragraph("6.1	Institutional Vision and Leadership\r\n\r\n", font2);
//			paragraph2criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph2criteria6);
//			
//			
//			Paragraph paragraph1criteria6 = new Paragraph("6.1.1: The governance of the institution is reflective of an effective leadership in tune with the vision and mission of the Institution.\r\n", font1);
//			paragraph1criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph1criteria6);
//			
//			
//			
//			Paragraph paragraph30criteria6 = new Paragraph(
//					 (criteria6Fieldinfo != null
//									? criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse611()
//									: ""),
//					font3);
//
//document.add(paragraph30criteria6);
//			
//			
//			
//Paragraph paragraph30criteria612 = new Paragraph("\r\n");
//
//			
//			document.add(paragraph30criteria612);
//			
//			
//			
//			
//
//			/*
//			 * com.lowagie.text.Font fontTitle0 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle0.setSize(12);
//			 */
//
//			
//			
////			Paragraph paragraph3criteria6 = new Paragraph(
////					"6.1.1	The governance of the institution is reflective of an effective leadership in tune with the vision and mission of the Institution\r\n"
////							+ "\r\n\r\n" + "Response:"
////							+ (criteria6Record != null
////									? criteria6Record.getCriteria6FieldInfoQl().get(0).getResponse611()
////									: ""),
////					font3);
//			
//			
////			PdfPCell cell0266 = new PdfPCell(new Paragraph(
////					"5.4.2 Alumni financial contribution during the last five years (in INR).\r\n" + "\r\n" + "Response:"
////							+ (criteria6Fieldinfo != null
////						? criteria6Fieldinfo.getCriteria6FieldInfoQl().get(0).getResponse611()
////						: ""),
////					font3));
////			document.add(cell0266);
//			
//			
//			
//		
//
////			com.lowagie.text.Font font0Title1 = FontFactory.getFont(FontFactory.HELVETICA);
////			font0Title1.setSize(12);
////
////			
////			document.add(paragraph30criteria6);
//			
//			
//	//create a table 1
//			PdfPTable table1criteria6 = new PdfPTable(2);
//			table1criteria6.setWidthPercentage(100);
//	        PdfPTable table110criteria6=new PdfPTable(1);
//	        table110criteria6.setWidthPercentage(100);
//			PdfPCell cell1criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell2criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			PdfPCell cell3criteria6 = new PdfPCell(new Paragraph("Upload Any aditional information"));
//			PdfPCell cell4criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
//			PdfPCell cell5criteria6 = new PdfPCell(new Paragraph("Paste link for Any aditional information"));
//			PdfPCell cell6criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")));
//			table1criteria6.addCell(cell1criteria6);
//			table1criteria6.addCell(cell2criteria6);
//			table1criteria6.addCell(cell5criteria6);
//			table1criteria6.addCell(cell6criteria6);
//			table1criteria6.addCell(cell3criteria6);
//			table1criteria6.addCell(cell4criteria6);
//			
//			
//			document.add(table1criteria6);
//			
////			table110criteria6.addCell("Mother Teresa has an Organizational Structure ensuring good governance, reflective of\r\n"
////					+ "both, an Effective Leadership as also in tune with the Institutional Vision and Mission.\r\n"
////					+ "Vision:\r\n"
////					+ "Mother Teresa visualizes dissemination of knowledge and skills to students, who would\r\n"
////					+ "eventually contribute to the wellbeing of the people of the nation and global community.\r\n"
////					+ "Mission:\r\n"
////					+ "To impart adequate fundamental knowledge in all basic sciences and engineering, technical and\r\n"
////					+ "inter-personal skills to students.\r\n"
////					+ "To bring out creativity in students that would promote innovation, research and entrepreneurship\r\n"
////					+ "To preserve and promote cultural heritage, humanistic and spiritual values promoting peace and\r\n"
////					+ "harmony in society.\r\n"
////					+ "Colleges vision envisages that its graduating students contribute to national development and to\r\n"
////					+ "the well- being of the global community.\r\n"
////					+ "The mission is to produce graduates possessing sound knowledge in basic sciences and technical\r\n"
////					+ "skills, human values, a strong zeal to serve community, leading to realization of the institutions\r\n"
////					+ "vision, which calls for good governance, requiring establishment of structures and processes,\r\n"
////					+ "designed to ensure accountability, transparency, responsiveness, equity, empowerment, and\r\n"
////					+ "participation. In line with these, and as per UGC guidelines for autonomous colleges, following\r\n"
////					+ "statutory committees, namely, Governing Body, Academic Council, Boards of Studies, Finance\r\n"
////					+ "Committee, and Women Protection Cell (now renamed as Internal Compliance Committee), are\r\n"
////					+ "constituted, ensuring participation of teachers in decision making, proper management of\r\n"
////					+ "academic, financial, and administrative matters of the college.\r\n"
////					+ "Further, several non-statutory committees comprising faculty, staff and students are also\r\n"
////					+ "operative, assisting in the overall governance of the college. College promotes a culture of\r\n"
////					+ "decentralized and participative management, extending down to Assistant Professor.\r\n"
////					+ "The Principal, as head of the institution is vested with overall responsibility to plan, organize, and\r\n"
////					+ "control all activities, empowering Deans, Heads of Departments (HoDs), committees and incharges of sections, carrying out institutions day to day functions by delegating authority. Duties\r\n"
////					+ "and responsibilities of Principal and other personnel are well laid and spelt out clearly in Roles and\r\n"
////					+ "Responsibilities handbook of the institution.\r\n"
////					+ "College organized its structure into departments/sections, and groups/divisions within\r\n"
////					+ "departments. To\r\n"
////					+ "assist Principal, Deans and HoDs, in the performance of their functions, many committees,\r\n"
////					+ "namely, Planning and Monitoring Board, Grievance Redressal Committee, Admissions Committee,\r\n"
////					+ "Examinations Committee, Student Welfare Committee, Anti-ragging committee, Library\r\n"
////					+ "Committee, Extra-curricular activities Committee, Academic Audit Committee etc. are formed at\r\n"
////					+ "institutional and department level, comprising faculty/staff at all levels. Committees are\r\n"
////					+ "empowered to deliberate independently, investigate, and recommend actions on various issues,\r\n"
////					+ "referred to them.\r\n"
////					+ "Institutions perspective (Strategic) plan is developed by the Planning and Monitoring Board, in\r\n"
////					+ "consultation with the Governing Body. Strategic plan is aimed at achieving short, medium and\r\n"
////					+ "long-term goals of the college, aligning with its Vision and Mission. The strategic plan is translated\r\n"
////					+ "into operational goals and plans for departments, facilitating achievement of targets giving a detail\r\n"
////					+ "of time schedules along with resources required over the plan period.\r\n"
////					+ "All the above clearly ensure participative management at every level of the institution facilitating\r\n"
////					+ "development of potential leaders in the college, a clear reflection and demonstration of effective\r\n"
////					+ "leadership of college");
////			
////			
////			
////			table110criteria6.addCell(table1criteria6);
////			table110criteria6.setSpacingBefore(20);
////			table110criteria6.setSpacingAfter(20);
////		    document.add(table110criteria6);
//
//	//create table 2
////			PdfPTable table2criteria6 = new PdfPTable(2);
////			table2criteria6.setWidthPercentage(100);
////			PdfPTable table21criteria6 = new PdfPTable(1);
////			table21criteria6.setWidthPercentage(100);
////
////			PdfPCell cell21criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
////			PdfPCell cell22criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
////			PdfPCell cell23criteria6 = new PdfPCell(new Paragraph("Upload any  aditional information\r\n\r\n\r\n"));
////			PdfPCell cell24criteria6 = new PdfPCell(
////					new Paragraph((criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : "")));
////			PdfPCell cell25criteria6 = new PdfPCell(new Paragraph("paste Link for additional information\r\n\r\n\r\n"));
////			PdfPCell cell26criteria6 = new PdfPCell(new Paragraph(criteria6Record != null ? criteria6file.get(3).getCriteria6FilePath() :"" ));
////			PdfPCell cell27criteria6 = new PdfPCell(
////					new Paragraph("Link for strategic plan and deployment documents on the website\r\n\r\n\r\n"));
////			PdfPCell cell28criteria6 = new PdfPCell(new Paragraph(criteria6Record != null ? criteria6file.get(4).getCriteria6FilePath() : ""));
////			table2criteria6.addCell(cell21criteria6);
////			table2criteria6.addCell(cell22criteria6);
////			table2criteria6.addCell(cell23criteria6);
////			table2criteria6.addCell(cell24criteria6);
////			table2criteria6.addCell(cell25criteria6);
////			table2criteria6.addCell(cell26criteria6);
////			table2criteria6.addCell(cell27criteria6);
////			table2criteria6.addCell(cell28criteria6);
//////			table21criteria6.addCell(
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
//
////			table2criteria6.setSpacingBefore(20f);
////			table2criteria6.setSpacingAfter(20f);
////			table21criteria6.addCell(table2criteria6);
////			document.add(table21criteria6);
//
//			
//			
//       document.close();
//       System.out.println("close");
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
