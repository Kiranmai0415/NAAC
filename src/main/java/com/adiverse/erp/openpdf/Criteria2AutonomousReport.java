package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.Criteria2_FileUpload;
import com.adiverse.erp.service.Criteria2Service;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@Component

public class Criteria2AutonomousReport {
	
	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
   @Autowired
   Criteria2Service service2;
   
   
	List<Criteria2_FieldInfo> criteria2List = null;
	Criteria2_FieldInfo criteria2Record = null;
	List<Criteria2_FileUpload> criteria2file = null;
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;

	public String generateReport(Map<String, String> allParams) throws DocumentException, IOException {
		String reportPath = "";
		Path root = Paths.get(reportGeneratePath);
		Path file = null;
		Date date = new Date();
		try {
			font1.setSize(16);
			font2.setSize(14);
			font3.setSize(14);
			font4.setSize(12);
			font5.setSize(12);

//			Map<String, String> allParams = new HashMap<String, String>();
//			allParams.put("collegeId",criteria2Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear",criteria2Fieldinfo.getCriteriaId().getFinancialYear() );
//
//			allParams.put("typeofInstitution", criteria2Fieldinfo.getCriteriaId().getTypeofInstitution());

			criteria2List = service2.getAllCriteria2Data(allParams);
			if (CollectionUtils.isNotEmpty(criteria2List)) {
				criteria2Record = criteria2List.get(0);
				criteria2file = criteria2Record.getCriteria2FileUpload();
			} else {
				criteria2Record = new Criteria2_FieldInfo();
			}

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "Criteria2AutonomousReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
			paragraph2criteria2.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph2criteria2);

			Paragraph paragraph2linecriteria2 = new Paragraph("____________________________________________________________________________");
			paragraph2criteria2.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph2linecriteria2);

			Paragraph paragraph3criteria2 = new Paragraph("2.1 Student Enrollment and Profile\r\n\r\n", font2);

			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			paragraph3criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			
			document.add(paragraph3criteria2);
			
			PdfPTable tablecriteria2 = new PdfPTable(1);
//			PdfPTable table1criteria2 = new PdfPTable(1);
			
			tablecriteria2.setWidthPercentage(100f);
			PdfPCell cell321criteria2 = new PdfPCell(new Paragraph("2.1.1 Enrolment percentage\r\n" + "\r\n" + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria21Qn().get(0).getResponse211()
								:  "")+"\r\n\r\n",font4));	

			// Paragraph paragraph6 = new Paragraph("2.1.1.1 Number of students admitted
			// year-wise during last five years ", font3);
			PdfPCell cell3212criteria2 = new PdfPCell(new Paragraph("2.1.1.1 Number of seats filled year wise during last five years\r\n"
					+ "(Only first year admissions to be considered)\r\n\r\n ",font4));

			tablecriteria2.addCell(cell321criteria2);
			tablecriteria2.addCell(cell3212criteria2);
			
			
			document.add(tablecriteria2);
//			document.add(table1criteria2);
			

			Table table2111 = new Table(criteria2Record.getYearTable2111().size(), 2);

			table2111.setPadding(5);
			table2111.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
				
				Cell cell120criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2111().get(i).getInput2111y()+"\r\n\r\n",font5));
				
				cell120criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2111.addCell(cell120criteria2);
				
				
			}
			for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
				Cell cell120criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2111().get(i).getInput2111v()+"\r\n\r\n",font5));
				cell120criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2111.addCell(cell120criteria2);
				
			}

			document.add(table2111);
			
			PdfPTable tablecriteria2112 = new PdfPTable(1);
//			PdfPTable table1criteria2 = new PdfPTable(1);
			
			tablecriteria2112.setWidthPercentage(100f);
			tablecriteria2112.setSpacingAfter(20f);
			tablecriteria2112.setSpacingBefore(20f);

			PdfPCell cell32121criteria2 = new PdfPCell(new Paragraph(" 2.1.1.2 Number of sanctioned seats year wise during last five years\r\n\r\n",font4));
			tablecriteria2112.addCell(cell32121criteria2);
			
			document.add(tablecriteria2112);
			
			
			Table table2112 = new Table(criteria2Record.getYearTable2112().size(), 2);

			table2112.setPadding(5);
			table2112.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
				Cell cell12criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2112().get(i).getInput2112y()+"\r\n\r\n",font5));
				cell12criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2111.addCell(cell12criteria2);
				
			}
			for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
				Cell cell121criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2112().get(i).getInput2112v()+"\r\n\r\n",font5));
				cell121criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2111.addCell(cell121criteria2);
				
			}

			document.add(table2112);

			

			PdfPTable table3criteria2 = new PdfPTable(2);
			table3criteria2.setWidthPercentage(100f);
			table3criteria2.setWidths(new int[] { 3, 3 });
			
//			table3criteria2.setSpacingBefore(20f);
//			table3criteria2.setSpacingBefore(20f);


			
//			PdfPTable table7criteria2 = new PdfPTable(2);
			PdfPCell cell1criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell1criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell1criteria2);

			PdfPCell cell2criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell2criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell2criteria2);

			PdfPCell cell3criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"+"\r\n\r\n",font5));
			cell3criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell3criteria2);

			PdfPCell cell4criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell4criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell4criteria2);

			PdfPCell cell5criteria2 = new PdfPCell(new Paragraph(
					"Demand Ratio (Average of Last five years) based on Data Template upload the documentAny\r\n"+"\r\n\r\n",font5));
			cell5criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell5criteria2);

			PdfPCell cell6criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell6criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell6criteria2);

			document.add(table3criteria2);

			
			
			PdfPTable table1criteria2 = new PdfPTable(2);
			PdfPTable table1criteria21 = new PdfPTable(1);

			table1criteria2.setWidthPercentage(100f);
			table1criteria21.setWidthPercentage(100f);
			
			table1criteria2.setSpacingAfter(20f);
			table1criteria2.setSpacingBefore(20f);
			
			table1criteria21.setSpacingAfter(20f);
			table1criteria21.setSpacingBefore(20f);
			
			
			
			PdfPCell cell07criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell07criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1criteria2.addCell(cell07criteria2);

			PdfPCell cell08criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell08criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1criteria2.addCell(cell08criteria2);

			PdfPCell cell09criteria2 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n"+"\r\n\r\n",font5));
			cell09criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1criteria2.addCell(cell09criteria2);

			PdfPCell cell10criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(2).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell10criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1criteria2.addCell(cell10criteria2);

			PdfPCell cell11criteria2 = new PdfPCell(
					new Paragraph("Average percentage of seats filled against seats reserved\r\n\r\n"+"\r\n\r\n",font5));
			cell11criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1criteria2.addCell(cell11criteria2);

			PdfPCell cell12criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell12criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table1criteria2.addCell(cell12criteria2);

			PdfPCell cell60criteria2 = new PdfPCell(
					new Paragraph(
					"2.1.2 Percentage of seats filled against reserved categories (SC, ST, OBC \r\n"
					+ "etc.) as per applicable reservation policy for the first year admission\r\n"
					+ "during the last five years\r\n"
					+ "Response: "
							+ (criteria2Record != null ? criteria2Record.getCriteria21Qn().get(0).getResponse212()
									: "")+"\r\n\r\n",font4));
			table1criteria21.addCell(cell60criteria2);

			PdfPCell cell600criteria2 = new PdfPCell(
					new Paragraph(
					"2.1.2.1 Number of actual students admitted from the reserved \r\n"
					+ "categories year wise during the last five years \r\n"
							+ "\r\n\r\n" ,font4));
			table1criteria21.addCell(cell600criteria2);
			
			PdfPCell cell6000criteria2 = new PdfPCell(
					new Paragraph(
					"2.1.2.1: Number of seats earmarked for reserved category as per GOI or state Government rule\r\n\r\n",font4));
			table1criteria21.addCell(cell6000criteria2);
			
			document.add(table1criteria21);
			document.add(table1criteria2);
			
			if (criteria2Record.getYearTable2121() != null) {

				Table table2121 = new Table(criteria2Record.getYearTable2121().size(), 2);

				table2121.setPadding(5);
				table2121.setWidth(100f);

				for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
					
					
					Cell cell100criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2121().get(i).getInput2121y()+"\r\n\r\n",font5));
					cell100criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2121.addCell(cell100criteria2);
				}
				for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
					Cell cell110criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2121().get(i).getInput2121v()+"\r\n\r\n",font5));
					cell110criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2121.addCell(cell110criteria2);
					
				}

				document.add(table2121);
			
			}

		

			if (criteria2Record.getYearTable21212().size() > 0) {

				Table table21212 = new Table(criteria2Record.getYearTable21212().size(), 2);

				table21212.setPadding(5);
				table21212.setWidth(100f);

				for (int i = 0; i < criteria2Record.getYearTable21212().size(); i++) {
					
					Cell cell110criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable21212().get(i).getInput21212y()+"\r\n\r\n",font5));
					cell110criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table21212.addCell(cell110criteria2);
					
				}
				for (int i = 0; i < criteria2Record.getYearTable21212().size(); i++) {
					Cell cell120criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable21212().get(i).getInput21212v()+"\r\n\r\n",font5));
					cell120criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table21212.addCell(cell120criteria2);
					
				}

				document.add(table21212);
			
			}

//			table7criteria2.setWidthPercentage(100f);
//			table7criteria2.setWidths(new int[] { 3, 3 });
//			table7criteria2.setSpacingBefore(15);
//			table7criteria2.setSpacingAfter(15);

		
			/////// cr2.2

			Paragraph paragraph4criteria2 = new Paragraph("2.2  Catering to Student Diversity\r\n\r\n", font2);
		
			document.add(paragraph4criteria2);

			PdfPTable table01 = new PdfPTable(1);
			table01.setWidthPercentage(100f);

			PdfPCell cell120criteria2 = new PdfPCell(
					new Paragraph(
					"2.2.1: The institution assesses the learning levels of the students and \r\n"
					+ "organises special Programmes to cater to differential learning \r\n"
					+ "needs of the student\r\n\r\n"
							+ "Response:" + criteria2Record.getCriteria22Qn().get(0).getResponse221()
					+"\r\n\r\n",font4));
			
			table01.addCell(cell120criteria2);
			document.add(table01);

			PdfPTable table9criteria0000000000002 = new PdfPTable(2);
			table9criteria0000000000002.setSpacingAfter(20);
			table9criteria0000000000002.setSpacingBefore(20);

			table9criteria0000000000002.setWidthPercentage(100f);
			table9criteria0000000000002.setWidths(new int[] { 3, 3 });
			table9criteria0000000000002.setSpacingBefore(5);

			PdfPCell cell17criteria2 = new PdfPCell(new Paragraph("File Description\r\n", font4));
			cell17criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria0000000000002.addCell(cell17criteria2);

			PdfPCell cell18criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell18criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria0000000000002.addCell(cell18criteria2);

			PdfPCell cell19criteria2 = new PdfPCell(new Paragraph("Uplaod any additional information\r\n\r\n"+"\r\n\r\n",font5));
			cell19criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria0000000000002.addCell(cell19criteria2);

			PdfPCell cell20criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(5).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell20criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria0000000000002.addCell(cell20criteria2);

			PdfPCell cell19criteria21 = new PdfPCell(new Paragraph("Uplaod any additional information\r\n\r\n"+"\r\n\r\n",font5));
			cell19criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria0000000000002.addCell(cell19criteria21);

			PdfPCell cell20criteria21 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(5).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell20criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table9criteria0000000000002.addCell(cell20criteria21);
			
			table9criteria0000000000002.setSpacingAfter(20f);

			table9criteria0000000000002.setSpacingBefore(20f);
			

			document.add(table9criteria0000000000002);

			////////////////////////

			
			PdfPTable table9criteria2 = new PdfPTable(2);
			PdfPTable table9criteria21 = new PdfPTable(1);
			

			table9criteria2.setWidthPercentage(100f);
			table9criteria21.setWidthPercentage(100f);
			
			table9criteria2.setWidths(new int[] { 3, 3 });
			table9criteria2.setSpacingBefore(5);
			table9criteria21.setSpacingAfter(20f);
			table9criteria21.setSpacingBefore(20f);

			PdfPCell cell17criteria21 = new PdfPCell(new Paragraph("File Description\r\n", font4));
			cell17criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria2.addCell(cell17criteria21);

			PdfPCell cell18criteria21 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell18criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria2.addCell(cell18criteria21);

			PdfPCell cell19criteria211 = new PdfPCell(new Paragraph("Uplaod any additional information\r\n\r\n"+"\r\n\r\n",font5));
			cell19criteria211.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria2.addCell(cell19criteria211);

			PdfPCell cell20criteria211 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(5).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell20criteria211.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria2.addCell(cell20criteria211);
			
			
			PdfPCell cell200criteria211 = new PdfPCell(
					new Paragraph(
					"2.2.2: Student - Full time teacher ratio (Data for the latest completed\r\n"
					+ "academic year)\r\n\r\n,)"
							,font4));
			table9criteria21.addCell(cell200criteria211);
			
		
			if (criteria2Record.getCriteria22Qn() != null) {
				PdfPCell cell2001criteria211 = new PdfPCell(
						new Paragraph("Response:"+
						criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getResponse221() : ""+"\r\n\r\n",font5));
						table9criteria21.addCell(cell2001criteria211);
			} else {
				Paragraph paragraph4criteria2244 = new Paragraph("");
				document.add(paragraph4criteria2244);
			}
			PdfPCell cell2001criteria211 = new PdfPCell(
					new Paragraph(
					"A.Total Number of students enrolled in the institution.\r\n\r\n" ,font4));
			table9criteria21.addCell(cell2001criteria211);

			if (criteria2Record.getCriteria22Qn() != null) {
				PdfPCell cell20012criteria211 = new PdfPCell(
						new Paragraph("Response:"+
						criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getResponse221() : ""+"\r\n\r\n",font4));
				table9criteria21.addCell(cell20012criteria211);
			} else {
				Paragraph paragraph4criteria2244 = new Paragraph("");
				document.add(paragraph4criteria2244);
			}
			PdfPCell cell200122criteria211 = new PdfPCell(
					new Paragraph(
					"B.Total number of full time teachers in the institution\r\n\r\n",font4));
					table9criteria21.addCell(cell200122criteria211);

			if (criteria2Record.getCriteria22Qn() != null) {
				PdfPCell cell2001221criteria211 = new PdfPCell(
						new Paragraph(  "Response:"+
						criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getResponse221() : ""+"\r\n\r\n",font4));
						table9criteria21.addCell(cell2001221criteria211);

			} else {
				Paragraph paragraph4criteria2244 = new Paragraph("");
				document.add(paragraph4criteria2244);
			}

			
			document.add(table9criteria21);

			document.add(table9criteria2);


			//////////////// cr2.3

			Paragraph paragraph5criteria2 = new Paragraph("2.3	Teaching- Learning Process\r\n\r\n", font2);
			document.add(paragraph5criteria2);

			PdfPTable table03 = new PdfPTable(1);
			table03.setWidthPercentage(100f);

			PdfPCell cell001 = new PdfPCell(new Paragraph(
					"2.3.1 Student centric methods, such as experiential learning, \r\n"
					+ "participative learning and problem solving methodologies are used \r\n"
					+ "for enhancing learning experience and teachers use ICT- enabled \r\n"
					+ "tools including online resources for effective teaching and learning process"
							+ "\r\n\r\n" + "" + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria23Ql().get(0).getResponse231()
									: "")
							+"\r\n\r\n",font4));

			table03.addCell(cell001);

			document.add(table03);

			PdfPTable table10criteria2 = new PdfPTable(2);

			table10criteria2.setWidthPercentage(100f);
			table10criteria2.setWidths(new int[] { 3, 3 });
			table10criteria2.setSpacingBefore(20f);
			table10criteria2.setSpacingAfter(20f);

			PdfPCell cell21criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell21criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10criteria2.addCell(cell21criteria2);

			PdfPCell cell22criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell22criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10criteria2.addCell(cell22criteria2);

			PdfPCell cell23criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"+"\r\n\r\n",font5));
			cell23criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10criteria2.addCell(cell23criteria2);

			PdfPCell cell24criteria2 = new PdfPCell(new Paragraph(" "+"\r\n\r\n",font5));
			cell24criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10criteria2.addCell(cell24criteria2);

			document.add(table10criteria2);

			PdfPTable table04 = new PdfPTable(1);
			table04.setWidthPercentage(100f);
			
			table04.setSpacingAfter(20f);
			table04.setSpacingBefore(20f);

			PdfPCell cell002 = new PdfPCell(new Paragraph(
					"2.3.2 The institution adopts effective Mentor-Mentee Schemes to address \r\n"
					+ "academics and student-psychological issues.\r\n\r\n"
							+ "" + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria23Ql().get(0).getResponse232()
								:  "")+"\r\n\r\n",font4));	

			table04.addCell(cell002);

			document.add(table04);

			PdfPTable table11criteria2 = new PdfPTable(2);

			table11criteria2.setWidthPercentage(100f);
			table11criteria2.setWidths(new int[] { 3, 3 });
			table11criteria2.setSpacingBefore(5);

			PdfPCell cell25criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell25criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table11criteria2.addCell(cell25criteria2);

			PdfPCell cell26criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell26criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table11criteria2.addCell(cell26criteria2);

			PdfPCell cell27criteria2 = new PdfPCell(new Paragraph(
					"Provide link for webpage describing ICT enabled tools including online resources for effective teaching and learning process"+"\r\n\r\n",font5));
			cell27criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table11criteria2.addCell(cell27criteria2);

			PdfPCell cell28criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell28criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table11criteria2.addCell(cell28criteria2);

			PdfPCell cell29criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n", font5));
			cell29criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table11criteria2.addCell(cell29criteria2);

			PdfPCell cell30criteria2 = new PdfPCell(new Paragraph(""+"\r\n\r\n",font5));
			cell30criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table11criteria2.addCell(cell30criteria2);

			document.add(table11criteria2);

			PdfPTable table05 = new PdfPTable(1);
			table05.setWidthPercentage(100f);
			
			table05.setSpacingAfter(20f);
			table05.setSpacingBefore(20f);
			
			PdfPCell cell290criteria2 = new PdfPCell(new Paragraph(
					"2.3.3 Preparation and adherence of Academic Calendar and Teaching \r\n"
					+ "plans by the institution\r\n"
							+ "\r\n" + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria23Qn().get(0).getResponse233()
									: "")+"\r\n\r\n",font4));

			table05.addCell(cell290criteria2);
			PdfPCell cell2900criteria2 = new PdfPCell(new Paragraph("2.3.3.1 Number of mentors \r\nResponse:"
					+ (criteria2Record != null ? criteria2Record.getCriteria23Qn().get(0).getInput2331t1() : "")+"\r\n\r\n",font5));
			
	//		table05.addCell(cell2900criteria2);
			
			document.add(table05);

			PdfPTable table13criteria2 = new PdfPTable(2);

			table13criteria2.setWidthPercentage(100f);
			table13criteria2.setWidths(new int[] { 3, 3 });
			table13criteria2.setSpacingBefore(5);

			PdfPCell cell31criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell31criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table13criteria2.addCell(cell31criteria2);

			PdfPCell cell32criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell32criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table13criteria2.addCell(cell32criteria2);

			PdfPCell cell33criteria2 = new PdfPCell(
					new Paragraph("Upload year wise, number of students enrolled and full time teachers on roll\r\n\r\n"+"\r\n\r\n",font5));
			cell33criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table13criteria2.addCell(cell33criteria2);

			PdfPCell cell34criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(4).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell34criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table13criteria2.addCell(cell34criteria2);

			PdfPCell cell35criteria2 = new PdfPCell(new Paragraph("Circulars pertaining to assigning mentors to mentees\r\n\r\n"+"\r\n\r\n",font5));
			cell35criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table13criteria2.addCell(cell35criteria2);

			PdfPCell cell36criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(5).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell36criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table13criteria2.addCell(cell36criteria2);

			PdfPCell cell37criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"+"\r\n\r\n",font5));
			cell37criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table13criteria2.addCell(cell37criteria2);

			PdfPCell cell38criteria2 = new PdfPCell(new Paragraph(""+"\r\n\r\n",font5));
			cell38criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table13criteria2.addCell(cell38criteria2);

			document.add(table13criteria2);

			PdfPTable table06 = new PdfPTable(1);
			table06.setWidthPercentage(100f);
			
			table06.setSpacingBefore(20f);
			table06.setSpacingAfter(20f);

			PdfPCell cell003 = new PdfPCell(new Paragraph(
					"2.3.4 Preparation and adherence of Academic Calendar and Teaching plans by the institution\r\n\r\n" + ""
							+ "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria23Ql().get(0).getResponse234()
								:  "")+"\r\n\r\n",font4));	

		//	table06.addCell(cell003);
			document.add(table06);

			PdfPTable table15criteria2 = new PdfPTable(2);

			table15criteria2.setWidthPercentage(100f);
			table15criteria2.setWidths(new int[] { 3, 3 });
			table15criteria2.setSpacingBefore(20f);
			table15criteria2.setSpacingAfter(20f);

			PdfPCell cell39criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell39criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table15criteria2.addCell(cell39criteria2);

			PdfPCell cell40criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell40criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table15criteria2.addCell(cell40criteria2);

			PdfPCell cell41criteria2 = new PdfPCell(
					new Paragraph("Upload Academic Calendar and Teaching plans for five years\r\n\r\n"+"\r\n\r\n",font5));
			cell41criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table15criteria2.addCell(cell41criteria2);

			PdfPCell cell42criteria2 = new PdfPCell(new Paragraph(criteria2file.get(3).getCriteria2FilePath()+"\r\n\r\n",font5));
			cell42criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table15criteria2.addCell(cell42criteria2);

			document.add(table15criteria2);
			////////// cr24

			Paragraph paragraph6criteria2 = new Paragraph(" 2.4 Teacher Profile and Quality\r\n\r\n", font2);

			paragraph6criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph6criteria2);

			PdfPTable table07 = new PdfPTable(1);
			table07.setWidthPercentage(100f);

			PdfPCell cell3810criteria2 = new PdfPCell(
					new Paragraph(
					"2.4.1: Percentage of full-time teachers against sanctioned posts during the last five years\r\n\r\n"
							,font4));
					table07.addCell(cell3810criteria2);
					
			if (criteria2Record.getCriteria24Qn() != null) {
				PdfPCell cell38100criteria2 = new PdfPCell(
						new Paragraph("Response:"+
						(criteria2Record != null ? criteria2Record.getCriteria24Qn().get(0).getResponse241() : "")+"\r\n\r\n",font4));
				table07.addCell(cell38100criteria2);
			}

			Paragraph paragraph6criteria23 = new Paragraph(
					"2.4.1.1 Number of Sanctioned posts / required positions for teaching staff/ full time teachers year wise during the last five years:");

			document.add(paragraph6criteria23);

			if (criteria2Record.getCriteria24Qn() != null) {
				Paragraph paragraph6criteria24 = new Paragraph(
						criteria2Record != null ? criteria2Record.getCriteria24Qn().get(0).getResponse241() : "");
				document.add(paragraph6criteria24);
			}
			
			document.add(table07);

			if (criteria2Record.getYearTable2421() != null) {
				Table table2421 = new Table(criteria2Record.getYearTable2421().size(), 2);

				table2421.setPadding(5);
				table2421.setWidth(100f);
		
				for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
			
					Cell cell1110criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421y()+"\r\n\r\n",font5));
					cell1110criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2421.addCell(cell1110criteria2);
					
				}
			
				for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
					Cell cell110criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421v()+"\r\n\r\n",font5));
					
					cell110criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2421.addCell(cell110criteria2);
					
					
				}

				document.add(table2421);
				

			}

//			Paragraph paragraph6criteria25 = new Paragraph("B. Number of Sanctioned Posts");
//			document.add(paragraph6criteria25);

			if (criteria2Record.getYearTable2421() != null) {
				Table table2421 = new Table(criteria2Record.getYearTable2421().size(), 2);

				table2421.setPadding(5);
				table2421.setWidth(100f);
			
				for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
					
					Cell cell110criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421y()+"\r\n\r\n",font5));
					
					cell110criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2421.addCell(cell110criteria2);
				}
			
				for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
					Cell cell1100criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421v()+"\r\n\r\n",font5));
					cell1100criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2421.addCell(cell1100criteria2);
					
				}

				document.add(table2421);

			}

//			table07.addCell(cell004);
//			table07.addCell(cell0004);
//			document.add(table07);

			// YEAR TABLE1
//			Table table2411 = new Table(criteria2Record.getYearTable2411().size(), 2);
			//
//			table2411.setPadding(10);
//			table2411.setWidth(100f);
			//
//			for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
//				table2411.addCell(criteria2Record.getYearTable2411().get(i).getInput2411y());
//			}
//			for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
//				table2411.addCell(criteria2Record.getYearTable2411().get(i).getInput2411v());
//			}
//			document.add(table2411);

			PdfPTable table14 = new PdfPTable(2);

			table14.setWidthPercentage(100f);
			table14.setWidths(new int[] { 3, 3 });
			table14.setSpacingBefore(20f);
			table14.setSpacingAfter(20f);

			PdfPCell cell43 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell43.setHorizontalAlignment(Element.ALIGN_CENTER);
			table14.addCell(cell43);

			PdfPCell cell44 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
			table14.addCell(cell44);

			PdfPCell cell45 = new PdfPCell(new Paragraph(
					"Year wise full time teachers and sanctioned posts for 5 years(Data Template)\r\n\r\n"+"\r\n\r\n",font5));
			cell45.setHorizontalAlignment(Element.ALIGN_CENTER);
			table14.addCell(cell45);

			PdfPCell cell46 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(13).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
			table14.addCell(cell46);
			
			document.add(table14);

			
			

//			PdfPCell cell47 = new PdfPCell(new Paragraph("List of the faculty members authenticated by the Head of HEI\r\n\r\n"));
//			table14.addCell(cell47);
//
//			PdfPCell cell48 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(14).getCriteria2FilePath() : ""));
//			table14.addCell(cell48);
//
//			PdfPCell cell49 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n"));
//			table14.addCell(cell49);
//
//			PdfPCell cell50 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(15).getCriteria2FilePath() : ""));
//			table14.addCell(cell50);

			// 242

			PdfPTable table08 = new PdfPTable(1);
			table08.setWidthPercentage(100f);

			PdfPCell cell460 = new PdfPCell(
					new Paragraph(
					"2.4.2  Percentage of full time teachers with Ph.D./D.Sc. / D.Litt./ L.L.D \r\n"
					+ "during the last five years\r\n\r\n"
							+ "\r\n" ,font4));
					table08.addCell(cell460);
			if (criteria2Record.getCriteria24Qn() != null) {

				PdfPCell cell4600 = new PdfPCell(
						new Paragraph( "Response:"+
						(criteria2Record != null ? criteria2Record.getCriteria24Qn().get(0).getResponse242() : ""+"\r\n\r\n")+"\r\n\r\n",font5));
						table08.addCell(cell4600);
			}

			PdfPCell cell4601 = new PdfPCell(
					new Paragraph(
					"2.4.2.1: Number of full time teachers with Ph.D./D.Sc. / D.Litt./ \r\n"
					+ "L.L.D year wise during last five years",font4));
		
	//		table08.addCell(cell4601);
			
			PdfPCell cell460110 = new PdfPCell(
					new Paragraph(
					"2.4.3 Average teaching experience of full time teachers (Data to be \r\n"
					+ "provided only for the latest completed academic year, in number of \r\n"
					+ "years)"+"\r\n\r\n",font4));
		
			table08.addCell(cell460110);
			

			PdfPCell cell4601101 = new PdfPCell(
					new Paragraph(
					"2.4.3.1 Total teaching experience of full-time teachers as of latest completed academic year",font4));
		
			table08.addCell(cell4601101);
			

//			PdfPCell cell46011 = new PdfPCell(
//					new Paragraph(
//					"A: Total number of full time teachers with such qualifications during last five years\r\n\r\n",font4));
//		   table08.addCell(cell46011);
		   
		  document.add(table08);

			if (criteria2Record.getYearTable2421() != null) {
				Table table2421 = new Table(criteria2Record.getYearTable2421().size(), 2);

				table2421.setPadding(5);
				table2421.setWidth(100f);
				
				for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
				
					Cell cell01criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421y()+"\r\n\r\n",font5));
					cell01criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2421.addCell(cell01criteria2);
					
				}
				
				for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
					Cell cell02criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421v()+"\r\n\r\n",font5));
					cell02criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2421.addCell(cell02criteria2);
					
				}

			//	document.add(table2421);
			
			}
//
//			Paragraph paragraph6criteria31 = new Paragraph(
//					"B: Total number of full time teachers year wise during last five years"+"\r\n\r\n",font4);
//			document.add(paragraph6criteria31);

			if (criteria2Record.getYearTable2421() != null)

			{
//				System.out.println(criteria2Record.getYearTable2421());
				Table table2421 = new Table(criteria2Record.getYearTable2421().size() , 2);

				table2421.setPadding(5);
				table2421.setWidth(100f);
				
				for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
					
					Cell cell02criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421y()+"\r\n\r\n",font5));
					cell02criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2421.addCell(cell02criteria2);
					
					
//					table2421.addCell(criteria2Record.getYearTable2421().get(i).getInput2421y());
				}
			
				for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
					Cell cell03criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421v()+"\r\n\r\n",font5));
					cell03criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2421.addCell(cell03criteria2);
					
					
				}

		//		document.add(table2421);

			}

			PdfPTable table21 = new PdfPTable(2);

			table21.setWidthPercentage(100f);
			table21.setWidths(new int[] { 3, 3 });
			table21.setSpacingBefore(15);
			table21.setSpacingAfter(15);

			PdfPCell cell61 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell61);

			PdfPCell cell62 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell62);

			PdfPCell cell63 = new PdfPCell(new Paragraph("List of Teachers including their PAN, designation,\r\n"
					+ "dept and experience details(Data Template)\r\n\r\n"+"\r\n\r\n",font5));
			cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell63);

			PdfPCell cell64 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell64.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell64);

			PdfPCell cell65 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"+"\r\n\r\n",font5));
			cell65.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell65);

			PdfPCell cell66 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell66);

			document.add(table21);
			
			
			////////////
			

			PdfPTable table2221 = new PdfPTable(2);

			table2221.setWidthPercentage(100f);
			table2221.setWidths(new int[] { 3, 3 });
			table2221.setSpacingBefore(15);
			table2221.setSpacingAfter(15);
			
			PdfPCell cell46110110 = new PdfPCell(
					new Paragraph(
					"Average teaching experience of full time teachers in the same \r\n"
					+ "institution (Data to be provided only for the latest completed \r\n"
					+ "academic year, in number of years)"
					+ ""
					+ ""
					+ "",font4));
			
			table2221.addCell(cell46110110);
		
		
			

			PdfPCell cell460110001 = new PdfPCell(
					new Paragraph(
					"2.4.4.1: Total teaching experience of full time teachers in the same \r\n"
					+ "institution  "
					+ (criteria2Record != null
					? criteria2Record.getCriteria24Qn().get(0).getResponse241()
				 : "")+"\r\n\r\n",font4));			
				
		
			table2221.addCell(cell460110001);

			
			//////////////
			
			
			
			
			
			
			
			
			
			
			
			
			

			///////////// cr2.5

			Paragraph paragraph7criteria2 = new Paragraph("2.5	Evaluation Process and Reforms\r\n\r\n", font2);

			paragraph7criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph7criteria2);

			PdfPTable table22 = new PdfPTable(1);
			table22.setWidthPercentage(100f);

			PdfPCell cell6611 = new PdfPCell(
					new Paragraph(
					"2.5.1 Number of days from the date of last semester-end/ year- end  examination till the last date of declaration of results year wise during \r\n"
					+ "the last five years \r\n"
					+ "last five years"
							+ "\r\n\r\n" ,font4));
			table22.addCell(cell6611);
			
			PdfPCell cell661101 = new PdfPCell(
					new Paragraph(
					"2.5.1.1 Average number of days from the date of last semester-end/ yearend examination till the last date of declaration of results during the \r\n"
					+ "last five years"
							+ "\r\n\r\n" ,font4));
			table22.addCell(cell661101);
			
			
			
			

			if (criteria2Record.getCriteria25Qn() != null) {
				PdfPCell cell66110 = new PdfPCell(
						new Paragraph( "Response:"+
						(criteria2Record != null ? criteria2Record.getCriteria25Qn().get(0).getResponse251() : "")+"\r\n\r\n",font5));
						table22.addCell(cell66110);
			}
			document.add(table22);

			PdfPTable table24 = new PdfPTable(2);

			table24.setWidthPercentage(100f);
			table24.setWidths(new int[] { 3, 3 });
			table24.setSpacingBefore(15);
			table24.setSpacingBefore(15);

			PdfPCell cell69criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell69criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24.addCell(cell69criteria2);

			PdfPCell cell70criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell70criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24.addCell(cell70criteria2);

			PdfPCell cell71criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"+"\r\n\r\n",font5));
			cell71criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24.addCell(cell71criteria2);

			PdfPCell cell72criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell72criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24.addCell(cell72criteria2);

			PdfPCell cell73criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"+"\r\n\r\n",font5));
			cell73criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24.addCell(cell73criteria2);

			PdfPCell cell74criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n\r\n\r\n\r\n",font5));
			cell74criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24.addCell(cell74criteria2);

			document.add(table24);
			
			
			///2.5.2
			PdfPTable table221 = new PdfPTable(1);
			table221.setWidthPercentage(100f);

			PdfPCell cell66111 = new PdfPCell(
					new Paragraph(
					"2.5.2 Percentage of student complaints/grievances about evaluation \r\n"
					+ "against total number appeared in the examinations during the last \r\n"
					+ "five years"
							+ "\r\n\r\n" ,font4));
			table221.addCell(cell66111);
			
			PdfPCell cell6611011 = new PdfPCell(
					new Paragraph(
					"2.5.2.1: Number of complaints/grievances about evaluation year wise \r\n"
					+ "during last five years"
							+ "\r\n\r\n" ,font4));
			table221.addCell(cell6611011);
			
			
			if (criteria2Record.getYearTable2521() != null)

			{
//				System.out.println(criteria2Record.getYearTable2421());
				Table table2421 = new Table(criteria2Record.getYearTable2521().size() , 2);

				table2421.setPadding(5);
				table2421.setWidth(100f);
				
				for (int i = 0; i < criteria2Record.getYearTable2521().size(); i++) {
					
					Cell cell02criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2521().get(i).getInput2521y()+"\r\n\r\n",font5));
					cell02criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2421.addCell(cell02criteria2);
					
					
//					table2421.addCell(criteria2Record.getYearTable2421().get(i).getInput2421y());
				}
			
				for (int i = 0; i < criteria2Record.getYearTable2521().size(); i++) {
					Cell cell03criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2521().get(i).getInput2521v()+"\r\n\r\n",font5));
					cell03criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2421.addCell(cell03criteria2);
					
					
				}

		document.add(table2421);

			}
			
			
			PdfPCell cell66110111 = new PdfPCell(
					new Paragraph(
					"2.5.2.2: Number of students appeared in the examination conducted \r\n"
					+ "by the institution year wise during the last five years"
							+ "\r\n\r\n" ,font4));
			table221.addCell(cell66110111);
			
			document.add(table221);
			
			
			
			if (criteria2Record.getYearTable25212() != null)

			{
//				System.out.println(criteria2Record.getYearTable2421());
				Table table2421 = new Table(criteria2Record.getYearTable25212().size() , 2);

				table2421.setPadding(5);
				table2421.setWidth(100f);
				
				for (int i = 0; i < criteria2Record.getYearTable25212().size(); i++) {
					
					Cell cell02criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable25212().get(i).getInput25212y()+"\r\n\r\n",font5));
					cell02criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2421.addCell(cell02criteria2);
					
					
//					table2421.addCell(criteria2Record.getYearTable2421().get(i).getInput2421y());
				}
			
				for (int i = 0; i < criteria2Record.getYearTable25212().size(); i++) {
					Cell cell03criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable25212().get(i).getInput25212v()+"\r\n\r\n",font5));
					cell03criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2421.addCell(cell03criteria2);
					
					
				}

		document.add(table2421);

			}
			
		//	2.5.3
			
			PdfPTable table2211 = new PdfPTable(1);
			table2211.setWidthPercentage(100f);

			PdfPCell cell661111 = new PdfPCell(
					new Paragraph(
					"\r\n"
					+ "IT integration and reforms in the examination procedures and \r\n"
					+ "processes including Continuous Internal Assessment \r\n"
					+ "(CIA)/Formative Assessment have brought in considerable \r\n"
					+ "improvement in Examination Management System (EMS) of the \r\n"
					+ "Institution"
					+ (criteria2Record != null
					? criteria2Record.getCriteria25Qn().get(0).getResponse251()
					: "")+"\r\n\r\n",font4));
				
			table2211.addCell(cell661111);
			

			
			document.add(table2211);
			

			/////// cr2.6

			Paragraph paragraph8criteria2 = new Paragraph("2.6 Student Performance and Learning Outcome\r\r",
					font2);

			paragraph8criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph8criteria2);

			PdfPTable table27 = new PdfPTable(1);
			table27.setWidthPercentage(100f);

			PdfPCell cell740criteria2 = new PdfPCell(
					new Paragraph(
					"2.6.1 The institution has stated learning outcomes (programme and \r\n"
					+ "course outcome)/graduate attributes which are integrated into the \r\n"
					+ "assessment process and widely publicized through the website and \r\n"
					+ "other documents and the attainment of the same are evaluated by \r\n"
					+ "the institution"
							+ "\r\n\r\n"  ,font4));
			table27.addCell(cell740criteria2);
			
			
		
			if (criteria2Record.getCriteria26Ql() != null) {
				PdfPCell cell7400criteria2 = new PdfPCell(
						new Paragraph("Response:"+
						criteria2Record != null ? criteria2Record.getCriteria26Ql().get(0).getResponse261() : ""+"\r\n\r\n",font5));

						table27.addCell(cell7400criteria2);
			}
			
			document.add(table27);


			PdfPTable table28 = new PdfPTable(2);
			table28.setWidthPercentage(100f);
			table28.setWidths(new int[] { 3, 3 });
			table28.setSpacingBefore(20f);
			table28.setSpacingAfter(20f);

			PdfPCell cell79criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell79criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell79criteria2);

			PdfPCell cell80criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell80criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell80criteria2);

			PdfPCell cell81criteria2 = new PdfPCell(
					new Paragraph("Upload COs for all courses (exemplars from Glossary)\r\n\r\n"+"\r\n\r\n",font5));
			cell81criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell81criteria2);

			PdfPCell cell82criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell82criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell82criteria2);

			PdfPCell cell83criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"+"\r\n\r\n",font5));
			cell83criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell83criteria2);

			PdfPCell cell84criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell84criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell84criteria2);

			PdfPCell cell830criteria2 = new PdfPCell(
					new Paragraph("Upload COs for all courses (exemplars from Glossary)\r\n\r\n"+"\r\n\r\n",font5));
			cell830criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell830criteria2);

			PdfPCell cell840criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			
			cell840criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell840criteria2);

			document.add(table28);

			PdfPTable table31criteria2 = new PdfPTable(1);
			table31criteria2.setWidthPercentage(100f);
			table31criteria2.setSpacingBefore(20);
			table31criteria2.setSpacingAfter(20);
			

			PdfPCell cell8405criteria2 = new PdfPCell(
					new Paragraph(
					"2.6.2 Pass percentage of students (excluding backlog students) (Data for \r\n"
					+ "the latest completed academic year)"
					+ "\r\n\r\n",font4));

			table31criteria2.addCell(cell8405criteria2);

			if (criteria2Record.getCriteria26Ql() != null) {
				PdfPCell cell8404criteria2 = new PdfPCell(
						new Paragraph("Response:"+
						criteria2Record != null ? criteria2Record.getCriteria26Ql().get(0).getResponse262() : ""+"\r\n\r\n",font4));
				
				table31criteria2.addCell(cell8404criteria2);
			}

			PdfPCell cell8403criteria2 = new PdfPCell(
					new Paragraph(
					"2.6.2.1: Total number of final year students who passed the \r\n"
					+ "examination conducted by Institution during the latest completed \r\n"
					+ "academic year: \r\n\r\n",font4));
			table31criteria2.addCell(cell8403criteria2);
			
			if (criteria2Record.getCriteria26Ql() != null) {
				PdfPCell cell8402criteria2 = new PdfPCell(
						new Paragraph("Response"+
						criteria2Record != null ? criteria2Record.getCriteria26Ql().get(0).getInput262t1() : ""+"\r\n\r\n",font5));
				table31criteria2.addCell(cell8402criteria2);
			}

		
			PdfPCell cell8401criteria2 = new PdfPCell(
					new Paragraph("Response"+
					"2.6.2.2: Total number of final year students who appeared for the \r\n"
					+ "examination during the latest completed academic year:\r\n\r\n",font4));
			table31criteria2.addCell(cell8401criteria2);
			
			
			if (criteria2Record.getCriteria26Ql() != null) {
				PdfPCell cell8400criteria2 = new PdfPCell(
						new Paragraph(
						criteria2Record != null ? criteria2Record.getCriteria26Ql().get(0).getInput262t1() : ""+"\r\n\r\n",font5));
				table31criteria2.addCell(cell8400criteria2);
			}

			document.add(table31criteria2);

			PdfPTable table32 = new PdfPTable(2);

			table32.setWidthPercentage(100f);
			table32.setWidths(new int[] { 3, 3 });
			table32.setSpacingBefore(5);

			PdfPCell cell89criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell89criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell89criteria2);

			PdfPCell cell90criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell90criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell90criteria2);

			PdfPCell cell91criteria2 = new PdfPCell(new Paragraph(
					"Upload List of Programmes and number of students passed and appeared in the final year examination(Data Template)\r\n\r\n"+"\r\n\r\n",font5));
			cell91criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell91criteria2);

			PdfPCell cell92criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell92criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell92criteria2);

			PdfPCell cell93criteria2 = new PdfPCell(new Paragraph("Upload any  the annual report\r\n\r\n"+"\r\n\r\n",font5));
			cell93criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell93criteria2);

			PdfPCell cell94criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell94criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell94criteria2);
			PdfPCell cell930criteria2 = new PdfPCell(new Paragraph("Paste link for annual report\r\n\r\n"+"\r\n\r\n",font5));
			cell930criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell930criteria2);

			PdfPCell cell940criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell940criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell940criteria2);
			document.add(table32);

			///////////// cr2.7

			Paragraph paragraph9criteria2 = new Paragraph("2.7 Student Satisfaction Survey\r\n\r\n", font2);

			paragraph9criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph9criteria2);

		
			PdfPTable table34 = new PdfPTable(2);
			PdfPTable table341 = new PdfPTable(1);

			table34.setWidthPercentage(100f);
			table341.setWidthPercentage(100f);
			
			table34.setWidths(new int[] { 3, 3 });
			table341.setSpacingBefore(20f);
			table341.setSpacingAfter(20f);

			PdfPCell cell95criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell95criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell95criteria2);

			PdfPCell cell96criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell96criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell96criteria2);

			PdfPCell cell97criteria2 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n"+"\r\n\r\n",font5));
			cell97criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell97criteria2);

			PdfPCell cell98criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell98criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell98criteria2);

			PdfPCell cell97criteria21 = new PdfPCell(
					new Paragraph("Upload database of all currently enrolled students\r\n\r\n"+"\r\n\r\n",font5));
			cell97criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell97criteria21);

			PdfPCell cell98criteria21 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
			cell98criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell98criteria21);
			
			
			PdfPCell cell980criteria21 = new PdfPCell(
					new Paragraph(
					"2.7.1: Online student satisfaction survey regarding the teaching learning \r\n"
					+ "process.\r\n"
					+ "(Online survey will be conducted)\r\n\r\n"
					+ (criteria2Record != null
					? criteria2Record.getCriteria27Ql().get(0).getResponse271()
					: "")+"\r\n\r\n",font4));		
				
			
		
			table341.addCell(cell980criteria21);

			document.add(table341);
			document.add(table34);

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

	
	
	

}
