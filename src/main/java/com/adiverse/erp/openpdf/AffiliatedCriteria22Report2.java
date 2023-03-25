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
//public class AffiliatedCriteria22Report2 {
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
//			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			paragraph2criteria2.setAlignment(Paragraph.ALIGN_CENTER);
//			document.add(paragraph2criteria2);
//		
//			tablecriteria2.setWidthPercentage(100f);
////			tablecriteria2
////					.addCell("2.1.1 Average Enrolment percentage (Average of last five years)\r\n" + "\r\n" + "Response:"
////							+ (criteria2Record != null
////									? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse211()
////									: ""));
////			
////			tablecriteria2
////			.addCell("2.1.1 Average Enrolment percentage (Average of last five years)\r\n" + "\r\n" + "Response:"
////					+ (criteria2Record != null
////							? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput2112t11()
////							: ""));
//	//
//	//	
//	
//
//			Paragraph paragraph4criteria2 = new Paragraph("2.2 Student Teacher Ratio\r\n\r\n", font3);
//			document.add(paragraph4criteria2);
//			//new table
//			/*Paragraph paragraph4criteria2x = new Paragraph(" The institution assesses the learning levels of the students and organises\r\n"
//					+ "special Programmes for advanced learners and slow learners\r\n\r\n", font3);
//			document.add(paragraph4criteria2x);*/
//			
//			
//
//			PdfPTable table01 = new PdfPTable(1);
//			table01.setWidthPercentage(100f);
//			
//			Paragraph paragraph4criteria21 = new Paragraph(
//					"2.2.1: Student - Full time teacher ratio (Data for the latest completed academic year)"
//					+ "Response:");
//			document.add(paragraph4criteria21);
//			
//					
//				if(criteria2Fieldinfo.getCriteria2FieldInfoQn() !=null)
//				{
//			Paragraph paragraph4criteria22= new Paragraph(criteria2Fieldinfo != null
//					? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse221()
//					: "");
//			document.add(paragraph4criteria22);
//			
//				}
//				else
//				{
//					Paragraph paragraph4criteria2244 = new Paragraph("-");
//					document.add(paragraph4criteria2244);
//				}
//			Paragraph paragraph4criteria222 = new Paragraph(
//					"A.Total Number of students enrolled in the institution."
//					+ "Response:");
//			document.add(paragraph4criteria222);
//			
//					if(criteria2Fieldinfo.getCriteria2FieldInfoQn() !=null)
//					{	
//			Paragraph paragraph4criteria223= new Paragraph(criteria2Fieldinfo != null
//					? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse221()
//					: "");
//			document.add(paragraph4criteria223);
//			
//		}
//		else
//		{
//			Paragraph paragraph4criteria2244 = new Paragraph("-");
//			document.add(paragraph4criteria2244);
//		}
//			Paragraph paragraph4criteria224 = new Paragraph(
//					"B.Total number of full time teachers in the institution."
//					+ "Response:");
//			document.add(paragraph4criteria224);
//			
//					
//
//			if(criteria2Fieldinfo.getCriteria2FieldInfoQn() !=null)
//			{			
//			Paragraph paragraph4criteria225= new Paragraph(criteria2Fieldinfo != null
//					? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse221()
//					: "");
//			document.add(paragraph4criteria225);
//			
//		}
//		else
//		{
//			Paragraph paragraph4criteria2244 = new Paragraph("-");
//			document.add(paragraph4criteria2244);
//		}
//			
//			
//			
//			
////			table01.addCell(cell0002criteria2);
////			document.add(table01);
//			
////			table01.addCell("9Mother Teresa understands that most obvious characteristic of a slow learner, a\r\n"
////					+ "limited attention span compared to other learners. To keep these slow learners actively engaged\r\n"
////					+ "in the learning process, requires more than the usual variation in presentation methods (direct,\r\n"
////					+ "indirect), classroom climate (co-operative, competitive), and instructional materials (videos,\r\n"
////					+ "workbooks, co-operative activities, simulations, etc). Other immediately noticeable characteristics\r\n"
////					+ "of slow learners are their deficiencies in basic skills (reading, writing, and mathematics), difficulty\r\n"
////					+ "in comprehending abstract ideas, and most disconcerting is, unsystematic and less careful work\r\n"
////					+ "habits.\r\n"
////					+ "Keeping these in view, our faculty monitor students performance during regular class activities,\r\n"
////					+ "lab work, tutorials, assignments, mentoring, midterm and results of semester end examinations.\r\n"
////					+ "In addition, of late, we have been administering psychometric tests. Students secured <50% of\r\n"
////					+ "marks in midterm examinations, not able to participate enthusiastically in tutorials, unable to\r\n"
////					+ "submit assignments in time, showing lack of interest with irregular attendance, not coping up with\r\n"
////					+ "laboratory exercises are identified as slow learners. This exercise is carried out course-wise.\r\n"
////					+ "Remedial Teaching: In addition to the regular classroom teaching, remedial teaching is conducted\r\n"
////					+ "for slow learners through the use of activities, techniques and practices to eliminate weaknesses\r\n"
////					+ "or deficiencies that the slow learner is known to have. For example, deficiencies in basic\r\n"
////					+ "mathematical skills are reduced or eliminated by re-teaching the content that was not learned\r\n"
////					+ "earlier. Sub-divide topics by reordering them so that students get multiple exposure of the topics\r\n"
////					+ "facilitating better learning. Conventional instructional techniques such as drill and practice are\r\n"
////					+ "also employed.\r\n"
////					+ "Slow Learners are given separate learning materials through reinforcement of small segments of\r\n"
////					+ "learning and are associated with a peer who is an advanced learner. Further, emphasizing on\r\n"
////					+ "frequent assessment of the student progress, mentoring with close monitoring is conducted,\r\n"
////					+ "parents are informed, is found to be reasonably effective.\r\n"
////					+ "Additionally, based on the content of courses, faculty provide compensatory teaching, use ICT\r\n"
////					+ "methodologies (pictures/animations/videos) and supplements it with additional learning resources\r\n"
////					+ "and activities (through laboratory exercises and simulations, group discussions and co-operative\r\n"
////					+ "learning, mini and major projects by forming a group of students, one each of advanced learner\r\n"
////					+ "and slow learner).\r\n"
////					+ "Advanced learners are encouraged to take up more challenging tasks. They are given additional\r\n"
////					+ "training on value added courses ranging from advanced to highly advanced programming skills,\r\n"
////					+ "Business English\r\n"
////					+ "Certificate, additional training to participate in Hackathons, project exhibitions, facilitating them to\r\n"
////					+ "build prototypes, participate in coding competitions, etc.\r\n"
////					+ "All learners are given training on Logical Reasoning, improving Vocabulary, Verbal Reasoning,\r\n"
////					+ "and Quantitative aptitude, situational writing etc. to get through preliminary test conducted by\r\n"
////					+ "various companies for placements as well as preparation towards CAT/GRE/IELTS/TOEFL and\r\n"
////					+ "other Public Sector Undertakings.\r\n"
////					+ "In addition, 14 student professional bodies and 07 student clubs conducted several co-curricular\r\n"
////					+ "activities wherein, all learners participated, which is a regular exercise.\r\n"
////					+ "All learners are given career guidance, creating awareness on plethora of opportunities in terms\r\n"
////					+ "of medium to highly paid jobs, pursue post-graduation etc");
//////			
////			
////			table01.addCell((criteria2Record != null
////					? criteria2Record.getCriteria2FieldInfoQn().get(0).getInput221t1()
////					:""));
////
////			document.add(table01);
//
////			PdfPTable table8criteria2 = new PdfPTable(2);
////
////			table8criteria2.setWidthPercentage(100);
////			table8criteria2.setWidths(new int[] { 3, 3 });
////			table8criteria2.setSpacingBefore(5);
////
////			PdfPCell cell13criteria2 = new PdfPCell(new Paragraph("File Description\r\n+\r\n", font3));
////			table8criteria2.addCell(cell13criteria2);
////
////			PdfPCell cell14criteria2 = new PdfPCell(new Paragraph("Document\r\n+\r\n", font3));
////			table8criteria2.addCell(cell14criteria2);
////
////			PdfPCell cell15criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n"));
////			table8criteria2.addCell(cell15criteria2);
////
////			PdfPCell cell16criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : ""));
////			table8criteria2.addCell(cell16criteria2);
////			
////			PdfPCell cell17xcriteria2 = new PdfPCell(new Paragraph("Uplaod any additional information"));
////			table8criteria2.addCell(cell17xcriteria2);
////
////			PdfPCell cell18xcriteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : ""));
////			table8criteria2.addCell(cell18xcriteria2);
////			document.add(table8criteria2);
////			
////			//222
////
////			PdfPTable table02 = new PdfPTable(1);
////			table02.setWidthPercentage(100f);
////			table02.addCell("2.2.2   Student- Full time teacher ratio (Data for the latest completed academic year))\r\n"
////					+ "\r\n" + "Response:"
////					+ (criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse222()
////							: ""));
////			
////			table02.addCell((criteria2Fieldinfo != null ? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getInput231t1()
////					:"" ));
////			
////			document.add(table02);
////			//231
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
//			PdfPCell cell19criteria2 = new PdfPCell(new Paragraph("Uplaod any additional information\r\n\r\n"));
//			table9criteria2.addCell(cell19criteria2);
//
//			PdfPCell cell20criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(5).getCriteria2FilePath() : ""));
//			table9criteria2.addCell(cell20criteria2);
//
//			document.add(table9criteria2);
//			
//		   document.close();
//
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
