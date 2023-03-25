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
//import com.adiverse.erp.model.Criteria1_FileUpload;
//import com.adiverse.erp.model.Criteria2_FieldInfo;
//import com.adiverse.erp.model.Criteria2_FileUpload;
//import com.adiverse.erp.service.Criteria2Service;
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
//public class AutonomousCriteria22Report2 {
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//   @Autowired
//   Criteria2Service service2;
//   
//   
//	List<Criteria2_FieldInfo> criteria2List = null;
//	Criteria2_FieldInfo criteria2Record = null;
//	List<Criteria2_FileUpload> criteria2file = null;
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//
//public String generateReport(Criteria2_FieldInfo criteria2Fieldinfo) throws DocumentException, IOException {
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
//
//			criteria2List = service2.getAllCriteria2Data();
//			if (CollectionUtils.isNotEmpty(criteria2List)) {
//				criteria2Record = criteria2List.get(0);
//				criteria2file = criteria2Record.getCriteria2FileUpload();
//			} else {
//				criteria2Record = new Criteria2_FieldInfo();
//			}
//			
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AuthonomousCriteria2Report-" + strDate + ".pdf";
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
//			PdfPTable tablecriteria2 = new PdfPTable(1);
//			PdfPTable table1criteria2 = new PdfPTable(1);
//	// PdfPTable table4criteria2 = new PdfPTable(5);
//
//	// PdfPTable table5criteria2= new PdfPTable(5);
//
//			PdfPTable table3criteria2 = new PdfPTable(2);
//
//			PdfPTable table6criteria2 = new PdfPTable(5);
//			PdfPTable table7criteria2 = new PdfPTable(2);
//			
//
//			table1criteria2.addCell(table6criteria2);
//			document.add(table1criteria2);
//			
//
//			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
//
//			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph2criteria2);
//
//			tablecriteria2.setWidthPercentage(100f);
//
//			Paragraph paragraph4criteria2 = new Paragraph("2.2 Catering to Student Diversity\r\n\r\n", font3);
//			document.add(paragraph4criteria2);
//
//			PdfPTable table01 = new PdfPTable(1);
//			table01.setWidthPercentage(100f);
//			table01.addCell(
//					"2.2.1	The institution assesses the learning levels of the students and organises special Programmes for advanced learners and slow learners),\r\n"
//							+ "\r\n" + "Response:"
////							+ ( criteria2Fieldinfo != null
////									? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse221()
////									: "")
//							+ "Mother Teresa understands that most obvious characteristic of a slow learner, a limited attention span compared to other learners. To keep these slow learners actively engaged in the learning process, requires more than the usual variation in presentation methods (direct, indirect), classroom climate (co-operative, competitive), and instructional materials (videos, workbooks, co-operative activities, simulations, etc). Other immediately noticeable characteristics of slow learners are their deficiencies in basic skills (reading, writing, and mathematics), difficulty in comprehending abstract ideas, and most disconcerting is, unsystematic and less careful work habits.\r\n"
//							+ "\r\n"
//							+ "Keeping these in view, our faculty monitor students� performance during regular class activities, lab work, tutorials, assignments, mentoring, midterm and results of semester end examinations.\r\n"
//							+ "\r\n"
//							+ "In addition, of late, we have been administering psychometric tests. Students secured <50% of marks in midterm examinations, not able to participate enthusiastically in tutorials, unable to submit assignments in time, showing lack of interest with irregular attendance, not coping up with laboratory exercises are identified as slow learners. This exercise is carried out course-wise.\r\n"
//							+ "\r\n"
//							+ "Remedial Teaching: In addition to the regular classroom teaching, remedial teaching is conducted for slow learners through the use of activities, techniques and practices to eliminate weaknesses or deficiencies that the slow learner is known to have. For example, deficiencies in basic mathematical skills are reduced or eliminated by re-teaching the content that was not learned earlier. Sub-divide topics by reordering them so that students get multiple exposure of the topics facilitating better learning. Conventional instructional techniques such as drill and practice are also employed.\r\n"
//							+ "\r\n"
//							+ "Slow Learners are given separate learning materials through reinforcement of small segments of learning and are associated with a peer who is an advanced learner. Further, emphasizing on frequent assessment of the student progress, mentoring with close monitoring is conducted, parents are informed, is found to be reasonably effective.\r\n"
//							+ "\r\n"
//							+ "Additionally, based on the content of courses, faculty provide compensatory teaching, use ICT methodologies (pictures/animations/videos) and supplements it with additional learning resources and activities (through laboratory exercises and simulations, group discussions and co-operative learning, mini and major projects by forming a group of students, one each of advanced learner and slow learner).\r\n"
//							+ "\r\n"
//							+ "Advanced learners are encouraged to take up more challenging tasks. They are given additional training on value added courses ranging from advanced to highly advanced programming skills, Business English\r\n"
//							+ " \r\n"
//							+ "Certificate, additional training to participate in Hackathons, project exhibitions, facilitating them to build prototypes, participate in coding competitions, etc.\r\n"
//							+ "\r\n"
//							+ "All learners are given training on �Logical Reasoning, improving Vocabulary, Verbal Reasoning, and Quantitative aptitude, situational writing etc.� to get through preliminary test conducted by various companies for placements as well as preparation towards CAT/GRE/IELTS/TOEFL and other Public Sector Undertakings.\r\n"
//							+ "\r\n"
//							+ "In addition, 14 student professional bodies and 07 student clubs conducted several co-curricular activities wherein, all learners participated, which is a regular exercise.\r\n"
//							+ "\r\n"
//							+ "All learners are given career guidance, creating awareness on plethora of opportunities in terms of medium to highly paid jobs, pursue post-graduation etc.\r\n"
//							+ "\r\n" + "\r\n" + "");
//
//			document.add(table01);
//
//			PdfPTable table8criteria2 = new PdfPTable(2);
//
//			table8criteria2.setWidthPercentage(100f);
//			table8criteria2.setWidths(new int[] { 3, 3 });
//			table8criteria2.setSpacingBefore(5);
//
//			PdfPCell cell13criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table8criteria2.addCell(cell13criteria2);
//
//			PdfPCell cell14criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table8criteria2.addCell(cell14criteria2);
//
//			PdfPCell cell15criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
//			table8criteria2.addCell(cell15criteria2);
//
//			PdfPCell cell16criteria2 = new PdfPCell(new Paragraph(""));
//			table8criteria2.addCell(cell16criteria2);
//
//			document.add(table8criteria2);
//
//			PdfPTable table02 = new PdfPTable(1);
//			table02.setWidthPercentage(100f);
//			table02.addCell("2.2.2 Student - Full time teacher ratio (Data for the latest completed academic year)\r\n"
//					+ "\r\n" + "Response:"
//					+ (criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse222()
//							: ""));
//			document.add(table02);
//
//			PdfPTable table9criteria2 = new PdfPTable(2);
//
//			table9criteria2.setWidthPercentage(100f);
//			table9criteria2.setWidths(new int[] { 3, 3 });
//			table9criteria2.setSpacingBefore(5);
//
//			PdfPCell cell17criteria2 = new PdfPCell(new Paragraph("File Description\r\n", font3));
//			table9criteria2.addCell(cell17criteria2);
//
//			PdfPCell cell18criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table9criteria2.addCell(cell18criteria2);
//
//			PdfPCell cell19criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
//			table9criteria2.addCell(cell19criteria2);
//
//			PdfPCell cell20criteria2 = new PdfPCell(new Paragraph(""));
//			table9criteria2.addCell(cell20criteria2);
//
//			document.add(table9criteria2);
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
