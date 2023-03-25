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
//public class AutonomousCriteria25Report2 {
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
//			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
//		
//			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		
//			document.add(paragraph2criteria2);
//	
//			tablecriteria2.setWidthPercentage(100f);
//		
//			Paragraph paragraph7criteria2 = new Paragraph("2.5	Evaluation Process and Reforms\r\n", font3);
//
//			paragraph7criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph7criteria2);
//
//			PdfPTable table22 = new PdfPTable(1);
//			table22.setWidthPercentage(100f);
//
////			PdfPCell cell010 = new PdfPCell(new Paragraph(
////					"2.5.1 Average number of days from the date of last semester-end/ year- end examination till the declaration of results year-wise during the last five years"
////							+ "\r\n" + "Response:"
////							+ ( criteria2Fieldinfo != null
////									? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse251()
////									: ""),
////					font3));
//
////			table22.addCell(cell010);
//
//			table22.addCell(
//					"2.5.1.1 Number of days from the date of last semester-end/ year- end examination till the declaration of results year wise during the last five years\r\n"
//							+ "\r\n" + " ");
//if(criteria2Fieldinfo.getYearTable2511() !=null)
//{
//			Table table2511 = new Table(criteria2Fieldinfo.getYearTable2511().size(), 2);
//
//			table2511.setPadding(10);
//			table2511.setWidth(100f);
//
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2511().size(); i++) {
//				table2511.addCell(criteria2Fieldinfo.getYearTable2511().get(i).getInput2511y());
//			}
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2511().size(); i++) {
//				table2511.addCell(criteria2Fieldinfo.getYearTable2511().get(i).getInput2511v());
//			}
//
//			document.add(table2511);
//}
//
//			/*
//			 * PdfPTable table23= new PdfPTable(5); table23.setWidthPercentage(100f);
//			 * table23.setWidths(new int[] {3, 3, 3, 3, 3}); table23.setSpacingBefore(5);
//			 * 
//			 * 
//			 * cell.setPhrase(new Phrase("    ")); table23.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table23.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table23.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table23.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table23.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table23.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table23.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table23.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table23.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table23.addCell(cell);
//			 * 
//			 * table22.addCell(table23);
//			 * 
//			 * 
//			 * document.add(table22);
//			 */
//
//			PdfPTable table24 = new PdfPTable(2);
//
//			table24.setWidthPercentage(100f);
//			table24.setWidths(new int[] { 3, 3 });
//			table24.setSpacingBefore(5);
//
//			PdfPCell cell69criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table24.addCell(cell69criteria2);
//
//			PdfPCell cell70criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table24.addCell(cell70criteria2);
//
//			PdfPCell cell71criteria2 = new PdfPCell(
//					new Paragraph("Institutional data in prescribed format (Data Template)\r\n\r\n"));
//			table24.addCell(cell71criteria2);
//
//			PdfPCell cell72criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(9).getCriteria2FilePath() : ""));
//			table24.addCell(cell72criteria2);
//
//			PdfPCell cell73criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
//			table24.addCell(cell73criteria2);
//
//			PdfPCell cell74criteria2 = new PdfPCell(new Paragraph("", font3));
//			table24.addCell(cell74criteria2);
//
//			document.add(table24);
//
//			PdfPTable table09 = new PdfPTable(1);
//			table09.setWidthPercentage(100f);
//
//			PdfPCell cell006 = new PdfPCell(new Paragraph(
//					"2.5.2 Average percentage of student complaints/grievances about evaluation against total number appeared in the examinations during the last five years"
//							+ "\r\n" + "" + "" + "Response:"
//							+ (criteria2Fieldinfo != null
//									? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse252()
//									: ""),
//					font3));
//
//			table09.addCell(cell006);
//
//			table09.addCell(
//					"2.5.2.1 Number of complaints/grievances about evaluation year wise during the last five years\r\n"
//							+ "\r\n" + " ");
//
//			if(criteria2Fieldinfo.getYearTable2521() !=null)
//			{
//			Table table2521 = new Table(criteria2Fieldinfo.getYearTable2521().size(), 2);
//
//			table2521.setPadding(10);
//			table2521.setWidth(100f);
//
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2521().size(); i++) {
//				table2521.addCell(criteria2Fieldinfo.getYearTable2521().get(i).getInput2521y());
//			}
//			for (int i = 0; i < criteria2Fieldinfo.getYearTable2521().size(); i++) {
//				table2521.addCell(criteria2Fieldinfo.getYearTable2521().get(i).getInput2521v());
//			}
//
//			document.add(table2521);
//			}
//
//			/*
//			 * PdfPTable table19= new PdfPTable(5); table19.setWidthPercentage(100f);
//			 * table19.setWidths(new int[] {3, 3, 3, 3, 3}); table19.setSpacingBefore(5);
//			 * 
//			 * 
//			 * cell.setPhrase(new Phrase("    ")); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell); cell.setPhrase(new
//			 * Phrase("    ", font1)); table19.addCell(cell);
//			 * 
//			 * table09.addCell(table19);
//			 * 
//			 * 
//			 * document.add(table09);
//			 */
//
//			PdfPTable table18 = new PdfPTable(2);
//
//			table18.setWidthPercentage(100f);
//			table18.setWidths(new int[] { 3, 3 });
//			table18.setSpacingBefore(5);
//
//			PdfPCell cell57 = new PdfPCell(new Paragraph("File Description", font3));
//			table18.addCell(cell57);
//
//			PdfPCell cell58 = new PdfPCell(new Paragraph("Document", font3));
//			table18.addCell(cell58);
//
//			PdfPCell cell59 = new PdfPCell(
//					new Paragraph("Number of complaints and total number of students appeared year wise"));
//			table18.addCell(cell59);
//
//			PdfPCell cell60 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
//			table18.addCell(cell60);
//
//			document.add(table18);
//
//			PdfPTable table25 = new PdfPTable(1);
//			table25.setWidthPercentage(100f);
//
//			PdfPCell cell011 = new PdfPCell(new Paragraph(
//					"2.5.3 IT integration and reforms in the examination procedures and processes including Continuous Internal Assessment (CIA) have brought in considerable improvement in Examination Management System (EMS) of the Institution"
//							+ "\r\n" + "" + "" + "Response:"
////							+ (criteria2Fieldinfo != null
////									? criteria2Fieldinfo.getCriteria2FieldInfoQl().get(0).getResponse253()
////									: "")
//							+ "\r\n" + ""
//							+ "Mother Teresa has adopted a comprehensive EMS facilitated through IT integration and backed by a state-of-the-art hardware and software systems. This has tremendously reformed the examination procedures and processes including the CIA."
//
//					, font3));
//
//			table25.addCell(cell011);
//
//			table25.addCell(
//					"As per the academic calendar exam branch issues notifications related to Midterm examinations, Semester end examinations through college portal, WhatsApp groups and group mail.\r\n"
//							+ "\r\n" + "The following operations pertaining to conduct of examinations are automated\r\n"
//							+ "\r\n" + "Comprehensive student profile database\r\n"
//							+ "Sending appointment orders to external examiners\r\n"
//							+ "Student registrations for semester end (Regular & Supplementary) examinations Generation of hall tickets\r\n"
//							+ "Student seating plan generation\r\n"
//							+ "Barcoded answer booklet generation and printing with student photo and signature for end semester exams\r\n"
//							+ "Attendance sheet generation\r\n" + "Scanning, coding and decoding of answer booklets\r\n"
//							+ "Digital evaluation facilitating remote evaluation for both CIE and SEE\r\n"
//							+ "Result processing (with built-in Grafting and Moderation as per affiliating university guidelines) Publication of results\r\n"
//							+ "Generation of\r\n"
//							+ "Memorandum of marks with SGPA and intermittent CGPA up to the end of corresponding semester\r\n"
//							+ "Consolidated memorandum of marks with SGPA and CGPA Provisional Certificate with student photo\r\n"
//							+ "Transcripts\r\n" + "Result analysis, branch wise, year wise, course wise and overall\r\n"
//							+ "\r\n" + "Examination Procedure\r\n" + "\r\n"
//							+ "Midterm examinations: Two midterm examinations and one make-up test are conducted For each theory course there is an internal evaluation for 30 marks.\r\n"
//							+ "Reforms in midterm examination:\r\n" + "\r\n"
//							+ "1.Two sets of question papers, are set by a team of internal examiners, headed by the course coordinator. The question paper is then evaluated by a department question paper evaluation committee comprising senior faculty members of the department and a member from other department to verify whether\r\n"
//							+ "The question paper tests student�s higher order thinking skills, wherever feasible Balanced question paper covering all outcomes is given\r\n"
//							+ "Question paper is adhering to various levels of Bloom�s taxonomy, with more questions pertaining to higher levels for third and final year courses, and lesser number of questions for second and first year courses.\r\n"
//							+ "\r\n"
//							+ "Proforma for evaluating quality of the question paper in midterm examination is enclosed as additional document.\r\n"
//							+ "\r\n"
//							+ "Semester End Examination: Panel of examiners for preparation of question papers and evaluation of the answer scripts, chosen from various autonomous colleges and universities of repute, duly approved by the\r\n"
//							+ " \r\n" + "Board of studies of the concerned department.\r\n" + "\r\n"
//							+ "Guidelines are given to examiners with regard to the levels of Bloom�s taxonomy that shall be used in the preparation of question papers.\r\n"
//							+ "\r\n"
//							+ "Examiners are also provided the syllabus copy along with the structure of the question paper. Multiple question papers are elicited and the best question paper in terms of adherence to quality, higher order thinking levels and highly balanced one is selected for the examination purpose through scrutiny of the Question paper which shall be carried out by the Chairperson of Board of Studies, along with a senior faculty member/chief examiner (subject expert/course coordinator).\r\n"
//							+ "\r\n" + "Evaluation:\r\n" + "\r\n"
//							+ "1.	For the purpose of evaluation of semester end examination answer books, evaluators who have taught the course for a minimum of 5 times are invited and chief examiner conducts a meeting with them, explains scheme of evaluation.\r\n"
//							+ "2.	The chief examiner randomly verifies at least ten percent of the evaluated answer books for consistency and correctness of evaluation, choosing a third each from the ten percent of the highest, moderately and least scored respectively. If the chief examiner is not satisfied with the evaluation methodology adopted by the evaluator, another 10% of the scripts are again evaluated by the chief examiner in manner similar described above. If the chief examiner is still not satisfied with the evaluation, the matter is escalated to the controller of examinations for further action. The controller of examinations shall then arrange re-evaluation of the scripts either by the same evaluator or a different evaluator.\r\n"
//							+ "3.	No evaluator shall be given more than a bundle (60 answer booklets) in a day.\r\n"
//							+ "\r\n"
//							+ "All the above reforms have resulted in improving quality of the examination system, ensuring confidentiality in evaluation and bringing transparency in the process.\r\n"
//							+ "");
//
//			document.add(table25);
//
//			PdfPTable table26 = new PdfPTable(2);
//
//			table26.setWidthPercentage(100f);
//			table26.setWidths(new int[] { 3, 3 });
//			table26.setSpacingBefore(5);
//
//			PdfPCell cell75criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
//			table26.addCell(cell75criteria2);
//
//			PdfPCell cell76criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//			table26.addCell(cell76criteria2);
//
//			PdfPCell cell77criteria2 = new PdfPCell(
//					new Paragraph("Number of complaints and total number of students appeared year wise\r\n\r\n"));
//			table26.addCell(cell77criteria2);
//
//			PdfPCell cell78criteria2 = new PdfPCell(
//					new Paragraph(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : ""));
//			table26.addCell(cell78criteria2);
//
//			document.add(table26);
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
//
//}
//
