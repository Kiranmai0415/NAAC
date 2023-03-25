package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

@Service
public class Criteria2UniversityReport {

	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	
	
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
//			allParams.put("financialYear", criteria2Fieldinfo.getCriteriaId().getFinancialYear());
//
//			allParams.put("typeofInstitution", criteria2Fieldinfo.getCriteriaId().getTypeofInstitution() );

			criteria2List = service2.getAllCriteria2Data(allParams);
			if (CollectionUtils.isNotEmpty(criteria2List)) {
				criteria2Record = criteria2List.get(0);
				criteria2file = criteria2Record.getCriteria2FileUpload();
			} else {
				criteria2Record = new Criteria2_FieldInfo();
				criteria2file = new ArrayList<Criteria2_FileUpload>();
			}

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "Criteria2UniversityReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

			
			Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
			
			
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph);
			
			
			
			
			
			// 2.1
			PdfPTable tablecriteria2 = new PdfPTable(1);
			PdfPTable table1criteria2 = new PdfPTable(1);

			

		
			

			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font2);
		    paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		    paragraph2criteria2.setSpacingBefore(3f);
			
			document.add(paragraph2criteria2);
			
			

			Paragraph paragraph2criteria11112 = new Paragraph("___________________________________________________________________________");
			paragraph2criteria11112.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			
			document.add(paragraph2criteria11112);
			
			
			
			Paragraph paragraph3criteria2 = new Paragraph("2.1 Student Enrollment and Profile\r\n", font2);

			paragraph3criteria2.setSpacingAfter(9f);
			paragraph3criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);


			document.add(paragraph3criteria2);

			tablecriteria2.setWidthPercentage(100f);
			
			PdfPCell cell100criteria2 = new PdfPCell(new Paragraph("2.1.1 Enrollment Percentage\r\n"
						 + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria21Qn().get(0).getResponse211()
									: ""),font4));
			
			cell100criteria2.setExtraParagraphSpace(5f);
			
			tablecriteria2.addCell(cell100criteria2);
			
			PdfPCell cell100criteria2222222222 = new PdfPCell(new Paragraph("2.1.1.1:Number of Sanctioned seats year-wise during the last five years\r\n\r\n ",font4));
			tablecriteria2.addCell(cell100criteria2222222222);
			
			
			PdfPCell cell100criteria2000 = new PdfPCell(new Paragraph("2.1.1.2:  Number of seats filled year-wise during the last five years,\r\n\r\n ",font4));
			tablecriteria2.addCell(cell100criteria2000);
			
			
			document.add(tablecriteria2);

		
			Table table2111 = new Table(criteria2Record.getYearTable2111().size(), 2);

			table2111.setPadding(5f);
			table2111.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
				Cell cell1=new Cell(new Paragraph(criteria2Record.getYearTable2111().get(i).getInput2111y(),font5));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2111.addCell(cell1);
				
				
			
			
			}
			for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria2Record.getYearTable2111().get(i).getInput2111v(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2111.addCell(cell2);
				
			}
			
			for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria2Record.getYearTable2111().get(i).getInput2111v(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2111.addCell(cell2);
				
			}
			
			

		//	document.add(table2111);

		Table table2112 = new Table(criteria2Record.getYearTable2112().size(), 2);

			table2112.setPadding(5f);
			table2112.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
				Cell cell3=new Cell(new Paragraph(criteria2Record.getYearTable2112().get(i).getInput2112y(),font5));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2111.addCell(cell3);
			
			
			}
			for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
				Cell cell5=new Cell(new Paragraph(criteria2Record.getYearTable2112().get(i).getInput2112v()));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2111.addCell(cell5);
			}
			
			for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
				Cell cell5=new Cell(new Paragraph(criteria2Record.getYearTable2112().get(i).getInput2112n()));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2111.addCell(cell5);
			}
			

		document.add(table2112);
			
			

			PdfPTable table3criteria2 = new PdfPTable(2);
			table3criteria2.setWidthPercentage(100);
			

			PdfPCell cell1criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
			cell1criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell1criteria2);

			PdfPCell cell2criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
			cell2criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table3criteria2.addCell(cell2criteria2);

			PdfPCell cell3criteria2 = new PdfPCell(new Paragraph("\r\nDemand Ratio (Average of Last five years) based on Data Template upload the document\r\n",font5));
			cell3criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table3criteria2.addCell(cell3criteria2);

			PdfPCell cell4criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			
			cell4criteria2.setExtraParagraphSpace(5f);
			cell4criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table3criteria2.addCell(cell4criteria2);

			PdfPCell cell5criteria2 = new PdfPCell(new Paragraph("\r\nAny additional informatio\r\n",font5));
			cell5criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table3criteria2.addCell(cell5criteria2);

			PdfPCell cell6criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell6criteria2.setExtraParagraphSpace(5f);
			cell6criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table3criteria2.addCell(cell6criteria2);
			
			table3criteria2.setSpacingAfter(20f);
			table3criteria2.setSpacingBefore(20f);

			document.add(table3criteria2);
			
		
			
			table1criteria2.setWidthPercentage(100f);

			PdfPCell cell600criteria2 = new PdfPCell(
					new Paragraph(
					"2.1.2 Percentage of seats filled against reserved categories (SC, ST, OBC,\r\n"
					+ "etc.) as per applicable reservation policy for the first year admission\r\n"
					+ "year-wise during the last five years"
//					 +"Response: "
//							+ (criteria2Record != null
//									? criteria2Record.getCriteria21Qn().get(0).getResponse212()
//									: "")
							,font4));
			
			cell600criteria2.setExtraParagraphSpace(5f);
			PdfPCell cell601criteria2 = new PdfPCell(new Paragraph(("2.1.2.1  Number of actual students admitted against the reserved \r\n"
					+ "categories year-wise during the last five years\r\n\r\n" ),font4));
			PdfPCell cell602criteria2 = new PdfPCell(new Paragraph("2.1.2.2: Total number of seats earmarked for reserved category as per \r\n"
					+ "GOI or State Government rule year-wise during the last five years\r\n\r\n",font4));

			table1criteria2.addCell(cell600criteria2);
			table1criteria2.addCell(cell601criteria2);
			table1criteria2.addCell(cell602criteria2);
			document.add(table1criteria2);
			
			
			
			Table table2121 = new Table(criteria2Record.getYearTable2121().size(), 2);

			table2121.setPadding(5f);
			table2121.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
				Cell cell4=new Cell(new Paragraph((criteria2Record.getYearTable2121().get(i).getInput2121y()),font4));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2121.addCell(cell4);
				
			
			}
			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
				Cell cell5=new Cell(new Paragraph((criteria2Record.getYearTable2121().get(i).getInput2121v()),font4));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2121.addCell(cell5);
				
			}
			
			

		//	document.add(table2121);

			
			Table table21212 = new Table(criteria2Record.getYearTable21212().size(), 2);

			table21212.setPadding(5f);
			table21212.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable21212().size(); i++) {
				Cell cell6=new Cell(new Paragraph((criteria2Record.getYearTable21212().get(i).getInput21212y())));
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				table21212.addCell(cell6);
				
			}
			for (int i = 0; i < criteria2Record.getYearTable21212().size(); i++) {
				Cell cell7=new Cell(new Paragraph((criteria2Record.getYearTable21212().get(i).getInput21212v())));
				cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
				table21212.addCell(cell7);
				
				
			}
			
	
		for (int i = 0; i < criteria2Record.getYearTable21212().size(); i++) {
			Cell cell7=new Cell(new Paragraph((criteria2Record.getYearTable21212().get(i).getInput21212n())));
			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21212.addCell(cell7);	
		}

		document.add(table21212);

			PdfPTable table07criteria2 = new PdfPTable(2);
            table07criteria2.setWidthPercentage(100);
			PdfPCell cell07criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
			cell07criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			table07criteria2.addCell(cell07criteria2);

			PdfPCell cell08criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
			
			cell08criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			table07criteria2.addCell(cell08criteria2);

			PdfPCell cell09criteria2 = new PdfPCell(new Paragraph("\r\nAverage percentage of seats filled against seats\r\n"
					+ "reserved (Data Template)\r\n",font5));
			cell09criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table07criteria2.addCell(cell09criteria2);

			PdfPCell cell10criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell10criteria2.setExtraParagraphSpace(5f);
			
			cell10criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table07criteria2.addCell(cell10criteria2);

			PdfPCell cell11criteria2 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell11criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table07criteria2.addCell(cell11criteria2);

			PdfPCell cell12criteria2 = new PdfPCell(new Paragraph("",font5));
			cell12criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table07criteria2.addCell(cell12criteria2);
			
			table07criteria2.setSpacingAfter(20f);
			
			table07criteria2.setSpacingBefore(20f);

			document.add(table07criteria2);

			
			// 2.2 
			
			Paragraph paragraph4criteria2 = new Paragraph("2.2 Catering to Student Diversity\r\n", font2);
			paragraph4criteria2.setSpacingAfter(5f);
			document.add(paragraph4criteria2);

			PdfPTable table01 = new PdfPTable(1);
			table01.setWidthPercentage(100f);
			PdfPCell cell120criteria2 = new PdfPCell(new Paragraph(
					"2.2.1	The institution assesses the learning levels of the students and \r\n"
					+ "organises special Programmes to cater to differential learning needs \r\n"
					+ "of the student"
						 + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria22Qn().get(0).getResponse221()
									: ""),font4));
			
			cell120criteria2.setExtraParagraphSpace(5f);
			
			table01.addCell(cell120criteria2);
			
			document.add(table01);

			PdfPTable table8criteria2 = new PdfPTable(2);

			table8criteria2.setWidthPercentage(100f);
			table8criteria2.setWidths(new int[] { 3, 3 });
			table8criteria2.setSpacingBefore(5);

			PdfPCell cell13criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
			cell13criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table8criteria2.addCell(cell13criteria2);

			PdfPCell cell14criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
			
			cell14criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
			table8criteria2.addCell(cell14criteria2);

			PdfPCell cell15criteria2 = new PdfPCell(new Paragraph("\r\nPaste link for Additional Information\r\n",font5));
			cell15criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
			
			table8criteria2.addCell(cell15criteria2);

			PdfPCell cell16criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell16criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
			cell16criteria2.setExtraParagraphSpace(5f);
			
			table8criteria2.addCell(cell16criteria2);
			
			PdfPCell cell17criteria2 = new PdfPCell(new Paragraph("Upload any Additional Information",font5));
			cell17criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
			table8criteria2.addCell(cell17criteria2);
			
			
			PdfPCell cell18criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell18criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
			cell18criteria2.setExtraParagraphSpace(5f);
			
			table8criteria2.addCell(cell18criteria2);
			
			table8criteria2.setSpacingAfter(20f);
			table8criteria2.setSpacingBefore(20f);

			document.add(table8criteria2);

			PdfPTable table02 = new PdfPTable(1);
			table02.setWidthPercentage(100f);
			PdfPCell cell150criteria2 = new PdfPCell(new Paragraph("2.2.2 Student - Full time teacher ratio (Data for the latest completed academic year)\r\n"
				 + "Response:"
					+ (criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getResponse222()
							: ""),font4));
			
			cell150criteria2.setExtraParagraphSpace(5f);
			
			cell150criteria2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			
			
			PdfPCell cell151criteria2 = new PdfPCell(new Paragraph("A.Total Number of students enrolled in the institution.\r\n"
			
					+ (criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getInput222t1()
							: ""),font4));
			
			cell151criteria2.setExtraParagraphSpace(5f);
			
			cell151criteria2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			PdfPCell cell152criteria2 = new PdfPCell(new Paragraph("B.Total number of full time teachers in the institution.\r\n"
					+ "\r\n" 
					+ (criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getInput2221t2()
							: ""),font4));
			
			cell152criteria2.setExtraParagraphSpace(5f);
			
			cell152criteria2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			
			table02.addCell(cell150criteria2);
		//	table02.addCell(cell151criteria2);
		//	table02.addCell(cell152criteria2);
			document.add(table02);

			PdfPTable table9criteria2 = new PdfPTable(2);

			table9criteria2.setWidthPercentage(100f);
			table9criteria2.setWidths(new int[] { 3, 3 });
			table9criteria2.setSpacingBefore(5);

			PdfPCell cell107criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
			cell107criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table9criteria2.addCell(cell107criteria2);

			PdfPCell cell108criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell108criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table9criteria2.addCell(cell108criteria2);

			PdfPCell cell19criteria2 = new PdfPCell(new Paragraph("\r\n Additional Information\r\n\r\n",font5));
			cell19criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table9criteria2.addCell(cell19criteria2);

			PdfPCell cell20criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell20criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell20criteria2.setExtraParagraphSpace(5f);
			
			table9criteria2.addCell(cell20criteria2);
			table9criteria2.setSpacingAfter(20f);
			table9criteria2.setSpacingBefore(20f);

			document.add(table9criteria2);

			
			// 2.3 
			Paragraph paragraph5criteria2 = new Paragraph("2.3	Teaching- Learning Process", font2);
			paragraph5criteria2.setSpacingAfter(5f);
			document.add(paragraph5criteria2);

			PdfPTable table03 = new PdfPTable(1);
			table03.setWidthPercentage(100f);

			
			PdfPCell cell001 = new PdfPCell(new Paragraph(
					"2.3.1 Student centric methods, such as experiential learning, participative\r\n"
					+ "learning and problem solving methodologies are used for enhancing\r\n"
					+ "learning experience and teachers use ICT-enabled tools including\r\n"
					+ "online resources for effective teaching learning process"
							+ "\r\n" + "" + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria23Ql().get(0).getResponse231()
									: "")
							+

							 "",font4));
			
			
			
			
			cell001.setExtraParagraphSpace(5f);

			table03.addCell(cell001);

			document.add(table03);

			PdfPTable table10criteria2 = new PdfPTable(2);

			table10criteria2.setWidthPercentage(100f);
			table10criteria2.setWidths(new int[] { 3, 3 });
//			table10criteria2.setSpacingBefore(20);
//			table10criteria2.setSpacingAfter(20);

			PdfPCell cell21criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell21criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table10criteria2.addCell(cell21criteria2);

			PdfPCell cell22criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell22criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table10criteria2.addCell(cell22criteria2);

			PdfPCell cell23criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell23criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table10criteria2.addCell(cell23criteria2);

			PdfPCell cell24criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell24criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell24criteria2.setExtraParagraphSpace(5f);
			
			table10criteria2.addCell(cell24criteria2);
			
			
			PdfPCell cell25criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n",font5));
			cell25criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table10criteria2.addCell(cell25criteria2);
			PdfPCell cell26criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell26criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell26criteria2.setExtraParagraphSpace(5f);
			
			
			table10criteria2.addCell(cell26criteria2);
			
			
			table10criteria2.setSpacingAfter(20f);
			table10criteria2.setSpacingBefore(20f);


			document.add(table10criteria2);
			
			

			PdfPTable table04 = new PdfPTable(1);
			table04.setWidthPercentage(100f);

			PdfPCell cell002 = new PdfPCell(new Paragraph(
					"2.3.2 The institution adopts effective Mentor-Mentee Schemes to address\r\n"
					+ "academics and student-psychological issues."
					 + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria23Ql().get(0).getResponse232()
									: ""),font4 ));
			
			cell002.setExtraParagraphSpace(5f);

			table04.addCell(cell002);

			document.add(table04);

			PdfPTable table11criteria2 = new PdfPTable(2);

			table11criteria2.setWidthPercentage(100f);
			table11criteria2.setWidths(new int[] { 3, 3 });
			table11criteria2.setSpacingBefore(5);

			PdfPCell cell205criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell205criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table11criteria2.addCell(cell205criteria2);

			PdfPCell cell206criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell206criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table11criteria2.addCell(cell206criteria2);

			PdfPCell cell27criteria2 = new PdfPCell(new Paragraph(
					"Upload any additional information",font5));
			cell27criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table11criteria2.addCell(cell27criteria2);

			PdfPCell cell28criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell28criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell28criteria2.setExtraParagraphSpace(5f);
			
			table11criteria2.addCell(cell28criteria2);

			PdfPCell cell29criteria2 = new PdfPCell(new Paragraph("Provide link for webpage describing the \" LMS/\r\n"
					+ "Academic management system",font5));
			cell29criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table11criteria2.addCell(cell29criteria2);

			PdfPCell cell30criteria2 = new PdfPCell(new Paragraph("",font5));
			cell30criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table11criteria2.addCell(cell30criteria2);
			
			
			table11criteria2.setSpacingAfter(20F);
			table11criteria2.setSpacingBefore(20F);
			
			document.add(table11criteria2);
			
			

			PdfPTable table05 = new PdfPTable(1);
			table05.setWidthPercentage(100f);

			PdfPCell cell1500criteria2 = new PdfPCell(new Paragraph(
					"2.3.3 Ratio of students to mentor for academic and other related issues (Data for the latest completed academic year )\r\n"
							 + "\"Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria23Qn().get(0).getResponse233()
									: ""),font4));
			
			cell1500criteria2.setExtraParagraphSpace(5f);
			

			PdfPCell cell1501criteria2 = new PdfPCell(new Paragraph("2.3.3.1 Number of mentors \r\n" 
					+ (criteria2Record != null ? criteria2Record.getCriteria23Qn().get(0).getInput2331t1() : ""),font4));
			cell1501criteria2.setExtraParagraphSpace(5f);
			PdfPCell cell1502criteria2 = new PdfPCell(new Paragraph("2.3.3.1Number of students assigned to each Mentor"
					+ (criteria2Record != null ? criteria2Record.getCriteria23Qn().get(0).getInput2331t2() : ""),font4));
			cell1502criteria2.setExtraParagraphSpace(5f);
			
			table05.addCell(cell1500criteria2);
			table05.addCell(cell1501criteria2);
			table05.addCell(cell1502criteria2);
			
		//	document.add(table05);

			PdfPTable table13criteria2 = new PdfPTable(2);

			table13criteria2.setWidthPercentage(100f);
			table13criteria2.setWidths(new int[] { 3, 3 });
			
			table13criteria2.setSpacingBefore(20f);
			table13criteria2.setSpacingAfter(20f);

			PdfPCell cell31criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell31criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table13criteria2.addCell(cell31criteria2);

			PdfPCell cell32criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell31criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table13criteria2.addCell(cell32criteria2);

			PdfPCell cell33criteria2 = new PdfPCell(
					new Paragraph("Upload year wise, number of students enrolled and full time teachers on roll\r\n\r\n",font5));
			cell33criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table13criteria2.addCell(cell33criteria2);

			PdfPCell cell34criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell34criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell34criteria2.setExtraParagraphSpace(5f);
			
			
			table13criteria2.addCell(cell34criteria2);

			PdfPCell cell35criteria2 = new PdfPCell(new Paragraph("\r\nmentor/mentee ratio",font5));
			cell35criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table13criteria2.addCell(cell35criteria2);

			PdfPCell cell36criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell36criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell36criteria2.setExtraParagraphSpace(5f);
			
			
			table13criteria2.addCell(cell36criteria2);

			PdfPCell cell37criteria2 = new PdfPCell(new Paragraph("Circulars pertaining to assigning mentors to mentees\r\n\r\n",font5));
			cell37criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell37criteria2.setExtraParagraphSpace(5f);
			table13criteria2.addCell(cell37criteria2);

			PdfPCell cell38criteria2 = new PdfPCell(new Paragraph("",font5));
			cell38criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table13criteria2.addCell(cell38criteria2);
			
			table13criteria2.setSpacingAfter(20f);
			table13criteria2.setSpacingBefore(20f);

	//		document.add(table13criteria2);

			
			 // 2.4 
			
			Paragraph paragraph6criteria2 = new Paragraph(" 2.4 Teacher Profile and Quality\r\n", font2);
			paragraph6criteria2.setSpacingAfter(4f);
			paragraph6criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph6criteria2);

			PdfPTable table07 = new PdfPTable(1);
			table07.setWidthPercentage(100f);

			PdfPCell cell37criteria2111 = new PdfPCell( new Paragraph(
					"2.4.1 Percentage of full time teachers appointed against the number of\r\n"
					+ "sanctioned posts during the last five years"
							+ "\r\n" + "" + "",font4));
			cell37criteria2111.setExtraParagraphSpace(5f);
			
			table07.addCell(cell37criteria2111);
			
			
			
			PdfPCell cell37criteria21101 = new PdfPCell( new Paragraph(
					"2.4.1.1: Total Number of Sanctioned posts during last five years\r\n"
				
						+ "",font4));
			cell37criteria21101.setExtraParagraphSpace(5f);
			
			table07.addCell(cell37criteria21101);
			
			
			
			
			if(criteria2Record.getCriteria24Qn() !=null)
			{
				PdfPCell cell371criteria2111 = new PdfPCell(new Paragraph(criteria2Record != null
									? criteria2Record.getCriteria24Qn().get(0).getResponse241()
									: "",font4));
				
				cell371criteria2111.setExtraParagraphSpace(5f);
				table07.addCell(cell371criteria2111);
			}
			
			document.add(table07);
			
			
			PdfPTable table14 = new PdfPTable(2);

			table14.setWidthPercentage(100f);
			

			PdfPCell cell43 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell43.setHorizontalAlignment(Element.ALIGN_CENTER);
			table14.addCell(cell43);

			PdfPCell cell44 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table14.addCell(cell44);

			PdfPCell cell45 = new PdfPCell(
					new Paragraph("Year wise full time teachers and sanctioned posts for 5 years(Data Template)\r\n\r\n",font5));
			cell45.setHorizontalAlignment(Element.ALIGN_CENTER);
			table14.addCell(cell45);

			PdfPCell cell46 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell46.setExtraParagraphSpace(5f);
			
			table14.addCell(cell46);

			PdfPCell cell47 = new PdfPCell(new Paragraph("List of the faculty members authenticated by the Head of HEI\r\n\r\n",font5));
			cell47.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell47.setExtraParagraphSpace(5f);
			
			table14.addCell(cell47);

			PdfPCell cell48 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell48.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell48.setExtraParagraphSpace(5f);
			table14.addCell(cell48);

			PdfPCell cell49 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n",font5));
			cell49.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table14.addCell(cell49);

			PdfPCell cell50 = new PdfPCell(new Paragraph("",font5));
			cell50.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table14.setSpacingAfter(20f);
			table14.setSpacingBefore(20f);
			table14.addCell(cell50);

		//	document.add(table14);
			
			
			if(criteria2Record.getYearTable2411().size() >0)
			{
			Table table2411 = new Table(criteria2Record.getYearTable2411().size(), 2);

			table2411.setPadding(5f);
			table2411.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
				Cell cell21=new Cell(new Paragraph(criteria2Record.getYearTable2411().get(i).getInput2411y(),font5));
				cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2411.addCell(cell21);
			
			}
			for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
				Cell cell22=new Cell(new Paragraph(criteria2Record.getYearTable2411().get(i).getInput2411v(),font5));
				cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2411.addCell(cell22);
			
			
			}

		//	document.add(table2411);
		}
			if(criteria2Record.getYearTable24112().size()>0)
			{
			
			Table table24112 = new Table(criteria2Record.getYearTable24112().size(), 2);

			table24112.setPadding(5f);
			table24112.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable24112().size(); i++) {
				Cell cell23=new Cell(new Paragraph(criteria2Record.getYearTable24112().get(i).getInput24112y(),font5));
				cell23.setHorizontalAlignment(Element.ALIGN_CENTER);
				table24112.addCell(cell23);
			
			}
			for (int i = 0; i < criteria2Record.getYearTable24112().size(); i++) {
				Cell cell24=new Cell(new Paragraph(criteria2Record.getYearTable24112().get(i).getInput24112v(),font5));
				cell24.setHorizontalAlignment(Element.ALIGN_CENTER);
				table24112.addCell(cell24);
			
			}
		//	table24112.setSpacingAfter(2f);
		//	document.add(table24112);
			
			
			}


			PdfPTable table08 = new PdfPTable(1);
			table08.setWidthPercentage(100f);

			PdfPCell cell005 = new PdfPCell(new Paragraph(
					"2.4.2 Percentage of full time teachers with Ph.D./D.M/M.Ch./D.N.B/\r\n"
					+ "Superspeciality/L.L.D/D.S.C/D.Litt. during the last five years"
							+ "\r\n" 
							,
					font4));
			
			table08.setSpacingBefore(5f);
			
			cell005.setExtraParagraphSpace(5f);
			
			table08.setSpacingBefore(5f);

			table08.addCell(cell005);

			PdfPCell cell15010criteria2 = new PdfPCell(new Paragraph(
					" 2.4.2.1 Number of full time teachers with Ph.D./D.M/M.Ch./D.N.B Superspeciality/D.Sc./D�Lit. year wise during the last five years\r\n"
							+ (criteria2Record != null
							? criteria2Record.getCriteria24Qn().get(0).getResponse242()
							: ""),font4));
			
			cell15010criteria2.setExtraParagraphSpace(5f);
			table08.addCell(cell15010criteria2);
			
			
			
			
			document.add(table08);
			
			Table table2421 = new Table(criteria2Record.getYearTable2421().size(), 2);

			table2421.setPadding(5f);
			table2421.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
				Cell cell25=new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421y(),font5));
				cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell25);
			
			}
			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
				Cell cell26=new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421v(),font5));
				cell26.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell26);
			
				
				
				
			}

			document.add(table2421);
			
			
			Table table24212 = new Table(criteria2Record.getYearTable24212().size(), 2);

			table24212.setPadding(5f);
			table24212.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable24212().size(); i++) {
				Cell cell27=new Cell(new Paragraph(criteria2Record.getYearTable24212().get(i).getInput24212y(),font5));
				cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell27);
			
			
			}
			for (int i = 0; i < criteria2Record.getYearTable24212().size(); i++) {
				Cell cell28=new Cell(new Paragraph(criteria2Record.getYearTable24212().get(i).getInput24212v()));
				cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell28);
				
				
			
			}

		//	document.add(table24212);


			PdfPTable table17 = new PdfPTable(2);

			table17.setWidthPercentage(100f);
			table17.setWidths(new int[] { 3, 3 });
			table17.setSpacingBefore(20f);
			table17.setSpacingAfter(20f);

			PdfPCell cell51 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
			table17.addCell(cell51);

			PdfPCell cell52 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell52.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table17.addCell(cell52);

			PdfPCell cell53 = new PdfPCell(new Paragraph("List of number of full time teachers with Ph D/D\r\n"
					+ "M/M Ch/D N B Superspeciality/DSc/D Lit and\r\n"
					+ "number of full time teachers for 5 years\r\n\r\n",font5));
			cell53.setExtraParagraphSpace(5f);
			
			cell53.setHorizontalAlignment(Element.ALIGN_CENTER);
			table17.addCell(cell53);

			PdfPCell cell54 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell54.setExtraParagraphSpace(5f);
			
			cell54.setHorizontalAlignment(Element.ALIGN_CENTER);
			table17.addCell(cell54);

			PdfPCell cell55 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n",font5));
			cell55.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table17.addCell(cell55);

			PdfPCell cell56 = new PdfPCell(new Paragraph("",font5));
			cell56.setHorizontalAlignment(Element.ALIGN_CENTER);
			table17.addCell(cell56);
			
			table17.setSpacingAfter(20f);
			table17.setSpacingBefore(20f);

	//		document.add(table17);

			PdfPTable table20 = new PdfPTable(1);
			table20.setWidthPercentage(100f);

			PdfPCell cell009 = new PdfPCell(new Paragraph(
					"2.4.3 Average teaching experience of full time teachers in the same institution (Data for the latest completed academic year in number of years)"

							,
					font4));
			
			cell009.setExtraParagraphSpace(5f);

			table20.addCell(cell009);
			
			document.add(table20);
			if( criteria2Record.getCriteria24Qn() !=null)
			{

			PdfPCell cell0090 = new PdfPCell(new Paragraph(" 2.4.3.1: Total teaching experience of full-time teachers (for the latest\r\n"
					+ "completed academic year\r\n"  + "Response:"
					+ (criteria2Record != null ? criteria2Record.getCriteria24Qn().get(0).getInput2431t1() : ""),font4));
			cell0090.setExtraParagraphSpace(5f);
			table20.addCell(cell0090);
			
			document.add(table20);
			}
			
			

			PdfPTable table21 = new PdfPTable(2);

			table21.setWidthPercentage(100f);
			table21.setWidths(new int[] { 3, 3 });
			table21.setSpacingBefore(20f);
			table21.setSpacingAfter(20f);

			PdfPCell cell61 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table21.addCell(cell61);

			PdfPCell cell62 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell62);

			PdfPCell cell63 = new PdfPCell(new Paragraph("List of Teachers including their PAN, designation,\r\n"
					+ "dept and experience details\r\n"
					+ "\r\n\r\n",font5));
			
			cell63.setExtraParagraphSpace(5f);
			cell63.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table21.addCell(cell63);

			PdfPCell cell64 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell64.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell64.setExtraParagraphSpace(5f);
			
			table21.addCell(cell64);
			

			table21.setSpacingAfter(20f);
			table21.setSpacingBefore(20f);
			document.add(table21);
			
			PdfPTable table201 = new PdfPTable(1);
			table201.setWidthPercentage(100f);

			PdfPCell cell0091 = new PdfPCell(new Paragraph(
					" 2.4.4 Average percentage of full time teachers who received awards, recognition, fellowships at State,\r\n"
					+ "National, International level from Government/Govt. recognised bodies during the last five years\r\n"
					+ "Response: "
							+ (criteria2Record != null
									? criteria2Record.getCriteria24Qn().get(0).getResponse244()
									: ""),
					font4));
			
			cell0091.setExtraParagraphSpace(5f);
		//	table201.addCell(cell0091);
			
			
//			
//				Paragraph paragraph6criteria222 = new Paragraph(" 2.4.4 Average percentage of full time teachers who received awards, recognition, fellowships at State,\r\n"
//					+ "National, International level from Government/Govt. recognised bodies during the last five years\r\n"
//					+ "Response:" );
//				document.add(paragraph6criteria222);

				if( criteria2Record.getCriteria24Qn() !=null)
				{

					PdfPCell cell000091 = new PdfPCell( new Paragraph(criteria2Record != null ? criteria2Record.getCriteria24Qn().get(0).getResponse241() : "",font4));
					//table201.addCell(cell000091);

			
			}
				
				document.add(table201);
			
			if(criteria2Record.getUniversityYearTable2441() .size()>0)
			{
			Table table2441 = new Table(criteria2Record.getUniversityYearTable2441().size(), 2);

			table2441.setPadding(5f);
			table2441.setWidth(100f);

			for (int i = 0; i < criteria2Record.getUniversityYearTable2441().size(); i++) {
				Cell cell26667=new Cell(new Paragraph(criteria2Record.getUniversityYearTable2441().get(i).getInput2441y(),font5));
				cell26667.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2441.addCell(cell26667);
			
			}
			for (int i = 0; i < criteria2Record.getUniversityYearTable2441().size(); i++) {
				table2441.addCell(criteria2Record.getUniversityYearTable2441().get(i).getInput2441v());
			}

	//		document.add(table2441);

			}
			
			
			
			// 2.5 
			
			Paragraph paragraph7criteria2 = new Paragraph("2.5	Evaluation Process and Reforms\r\n", font2);
			paragraph7criteria2.setSpacingAfter(4f);
			paragraph7criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph7criteria2);

			PdfPTable table22 = new PdfPTable(1);
			table22.setWidthPercentage(100f);

			PdfPCell cell010 = new PdfPCell(new Paragraph(
					"2.5.1  Average number of days from the date of last semester-end/ year- end\r\n"
					+ "examination till the last date of declaration of results year-wise during\r\n"
					+ "the last five years"
						,font4));

			
			cell010.setExtraParagraphSpace(5f);
			table22.addCell(cell010);
			
			PdfPCell cell01111110 = new PdfPCell(new Paragraph(
					"2.5.1.1 Number of days from the date of last semester-end/ year- end examination till the declaration of results year wise during the last five years\r\n"
							+ "\r\n" + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria25Qn().get(0).getInput251t1(): "")+ " ",font4));
			cell01111110.setExtraParagraphSpace(5f);
			table22.addCell(cell01111110);
			
			document.add(table22);
			
//			Table table2511 = new Table(criteria2Record.getYearTable2511().size(), 2);
//
//			table2511.setPadding(5f);
//			table2511.setWidth(100f);
//
//			for (int i = 0; i < criteria2Record.getYearTable2511().size(); i++) {
//				table2511.addCell(criteria2Record.getYearTable2511().get(i).getInput2511y());
//			}
//			for (int i = 0; i < criteria2Record.getYearTable2511().size(); i++) {
//				table2511.addCell(criteria2Record.getYearTable2511().get(i).getInput2511v());
//			}
//
//			document.add(table2511);
			
			
			//////
			
			
			if(criteria2Record.getYearTable2511() .size()>0)
			{
			Table table2511 = new Table(criteria2Record.getYearTable2511().size(), 2);

			table2511.setPadding(5f);
			table2511.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable2511().size(); i++) {
				Cell cell26667=new Cell(new Paragraph(criteria2Record.getYearTable2511().get(i).getInput2511y(),font5));
				cell26667.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2511.addCell(cell26667);
			
			}
			for (int i = 0; i < criteria2Record.getYearTable2511().size(); i++) {
				table2511.addCell(criteria2Record.getYearTable2511().get(i).getInput2511v());
			}

			document.add(table2511);

			}
			
			
			////
			

			

			PdfPTable table24 = new PdfPTable(2);

			table24.setWidthPercentage(100f);
			table24.setWidths(new int[] { 3, 3 });
			table24.setSpacingBefore(5);

			PdfPCell cell69criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell69criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
			table24.addCell(cell69criteria2);

			PdfPCell cell70criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell69criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
			
			table24.addCell(cell70criteria2);

			PdfPCell cell71criteria2 = new PdfPCell(
					new Paragraph("List of Programmes and date of last semester and\r\n"
							+ "date of declaration of results\r\n\r\n"));
			cell71criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
			table24.addCell(cell71criteria2);
			
			
if(criteria2file.size()>0) {
			PdfPCell cell72criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
			cell72criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
			cell72criteria2.setExtraParagraphSpace(5f);
			table24.addCell(cell72criteria2);
}
			PdfPCell cell73criteria2 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n"));
			cell73criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
			table24.addCell(cell73criteria2);

			PdfPCell cell74criteria2 = new PdfPCell(new Paragraph("", font4));
			cell74criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
			
			table24.addCell(cell74criteria2);

			table24.setSpacingAfter(20f);
			table24.setSpacingBefore(20f);
			
			document.add(table24);

			PdfPTable table09 = new PdfPTable(1);
			table09.setWidthPercentage(100f);
			if(criteria2Record.getCriteria25Qn() !=null)
			{
			PdfPCell cell006 = new PdfPCell(new Paragraph(
					"2.5.2 Percentage of student complaints/grievances about evaluation against\r\n"
					+ "total number of students appeared in the examinations during the last\r\n"
					+ "five years"
							+ "\r\n" + ""
					+ "" + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria25Qn().get(0).getResponse252()
									: "")
,font4));
			cell006.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);	
			
			
			cell006.setExtraParagraphSpace(5f);

			table09.addCell(cell006);
			
			}

			PdfPCell cell005556 = new PdfPCell(new Paragraph(
					"2.5.2.1 Number of complaints/grievances about evaluation year wise during the last five years\r\n"
							+ "\r\n" + " ",font4));
			
			table09.addCell(cell005556);
			
			
			PdfPCell cell005511156 = new PdfPCell(new Paragraph(
					"2.5.2.2 Total number of students appeared in the examinations year-wise \r\n"
					+ "during the last five years\r\n"
							+ "\r\n" + " ",font4));
			
			table09.addCell(cell005511156);
			
			
			document.add(table09);
			
			
			if(criteria2Record.getYearTable2521().size() >0) {
			Table table2521 = new Table(criteria2Record.getYearTable2521().size(), 2);

			table2521.setPadding(5f);
			table2521.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable2521().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria2Record.getYearTable2521().get(i).getInput2521y(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2521.addCell(cell2);
				
			}
			for (int i = 0; i < criteria2Record.getYearTable2521().size(); i++) {
				Cell cell11112=new Cell(new Paragraph(criteria2Record.getYearTable2521().get(i).getInput2521v(),font5));
				cell11112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2521.addCell(cell11112);
				
			}
			for (int i = 0; i < criteria2Record.getYearTable25212().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria2Record.getYearTable2521().get(i).getInput2521n(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2521.addCell(cell2);
				
			}
			
			

			document.add(table2521);
			
			}
			
			
			
			if(criteria2Record.getYearTable2521().size() >0) {
				
			
			Table table25212 = new Table(criteria2Record.getYearTable25212().size(), 2);

			table25212.setPadding(5f);
			table25212.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable25212().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria2Record.getYearTable25212().get(i).getInput25212y(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table25212.addCell(cell2);
				
			}
			for (int i = 0; i < criteria2Record.getYearTable25212().size(); i++) {
				Cell cell21111=new Cell(new Paragraph(criteria2Record.getYearTable25212().get(i).getInput25212v(),font5));
				cell21111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table25212.addCell(cell21111);
				
			}

		//	document.add(table25212);

		}

			PdfPTable table18 = new PdfPTable(2);

			table18.setWidthPercentage(100f);
			table18.setWidths(new int[] { 3, 3 });
			table18.setSpacingBefore(5);

			PdfPCell cell57 = new PdfPCell(new Paragraph("File Description", font4));
			cell57.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table18.addCell(cell57);

			PdfPCell cell58 = new PdfPCell(new Paragraph("Document", font4));
			cell58.setHorizontalAlignment(Element.ALIGN_CENTER);
			table18.addCell(cell58);

			PdfPCell cell59 = new PdfPCell(
					new Paragraph("Number of complaints and total number of students appeared year wise",font5));
			cell59.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table18.addCell(cell59);

			PdfPCell cell60 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell60.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell60.setExtraParagraphSpace(5f);
			table18.addCell(cell60);
			
			PdfPCell cell75criteria2 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n",font5));
			cell75criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table18.addCell(cell75criteria2);

			PdfPCell cell76criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
			cell76criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell76criteria2.setExtraParagraphSpace(5f);
			table18.addCell(cell76criteria2);

			table18.setSpacingAfter(20f);
			table18.setSpacingBefore(20f);

			document.add(table18);

			PdfPTable table25 = new PdfPTable(1);
			table25.setWidthPercentage(100f);

			PdfPCell cell011 = new PdfPCell(new Paragraph(
					"2.5.3 IT integration and reforms in the examination procedures and processes including Continuous Internal Assessment (CIA) have brought in considerable improvement in Examination Management System (EMS) of the Institution"
							+ "\r\n" + "" + "" + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria25Ql().get(0).getResponse253()
									: ""), font4));
			cell011.setExtraParagraphSpace(5f);
		//	table25.addCell(cell011);



			document.add(table25);

			PdfPTable table26 = new PdfPTable(2);

			table26.setWidthPercentage(100f);
			table26.setWidths(new int[] { 3, 3 });
			table26.setSpacingBefore(5);

			PdfPCell cell751criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell751criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table26.addCell(cell751criteria2);

			PdfPCell cell761criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell761criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table26.addCell(cell761criteria2);

			PdfPCell cell77criteria2 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"));
			cell77criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table26.addCell(cell77criteria2);

			PdfPCell cell78criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
			cell78criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell78criteria2.setExtraParagraphSpace(5f);
			table26.addCell(cell78criteria2);
			
			PdfPCell cell79criteria2 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n"));
			cell79criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table26.addCell(cell79criteria2);

			PdfPCell cell7008criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
			cell7008criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell7008criteria2.setExtraParagraphSpace(5f);
			
			table26.addCell(cell7008criteria2);

			
			table26.setSpacingAfter(20f);
			table26.setSpacingBefore(20f);
		//	document.add(table26);
			

			
			PdfPTable table2611 = new PdfPTable(1);
			table2611.setWidthPercentage(100f);
			PdfPCell cell708criteria2 = new PdfPCell(
					new Paragraph("2.5.3: Status of automation of Examination division along with approved Examination Manual\r\n"
							+ "A. 100% automation of entire division & implementation of Examination Management System (EMS)\r\n"
							+ "B. Only student registration, Hall ticket issue & Result Processing\r\n"
							+ "C. Only student registration and result processing\r\n"
							+ "D. Only result processing\r\n"
			
							+ "E. Only manual methodology\r\n"
							+ (criteria2Record != null
							? criteria2Record.getCriteria25Ql().get(0).getInput254t1()
							: ""), font4));
			cell708criteria2.setExtraParagraphSpace(5f);
			table2611.addCell(cell708criteria2);

			document.add(table2611);
			

			PdfPTable table261 = new PdfPTable(2);
			table261.setWidthPercentage(100f);
			
			PdfPCell cell7511criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell7511criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell7511criteria2.setExtraParagraphSpace(5f);
			
			table261.addCell(cell7511criteria2);

			PdfPCell cell7611criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell7611criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell7611criteria2.setExtraParagraphSpace(5f);
			table261.addCell(cell7611criteria2);

			PdfPCell cell771criteria2 = new PdfPCell(new Paragraph("Upload any additional information\r\n",font5));
			cell771criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell771criteria2.setExtraParagraphSpace(5f);
			table261.addCell(cell771criteria2);

			PdfPCell cell781criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell781criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell781criteria2.setExtraParagraphSpace(5f);
			table261.addCell(cell781criteria2);
			
			PdfPCell cell7711criteria2 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n",font5));
			cell7711criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell7711criteria2.setExtraParagraphSpace(5f);
			table261.addCell(cell7711criteria2);

			PdfPCell cell7811criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell7811criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell7811criteria2.setExtraParagraphSpace(5f);
			table261.addCell(cell7811criteria2);

			
			PdfPCell cell7721criteria2 = new PdfPCell(new Paragraph("Institutional data in prescribed format	\r\n",font5));
			cell7721criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell7721criteria2.setExtraParagraphSpace(5f);
			table261.addCell(cell7721criteria2);

			PdfPCell cell7821criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell7821criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell7821criteria2.setExtraParagraphSpace(5f);
			table261.addCell(cell7821criteria2);

			PdfPCell cell7731criteria2 = new PdfPCell(new Paragraph("Institutional data in prescribed format and\r\n",font5));
			
			cell7731criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell7731criteria2.setExtraParagraphSpace(5f);
			table26.addCell(cell7731criteria2);

			PdfPCell cell7841criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell7841criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell7841criteria2.setExtraParagraphSpace(5f);
			
			table261.addCell(cell7841criteria2);
			table261.setSpacingAfter(20f);
			table261.setSpacingBefore(20f);
			document.add(table261);
			
			
			// 2.6 
			Paragraph paragraph8criteria2 = new Paragraph("2.6 Student Performance and Learning Outcomes", font2);
			paragraph8criteria2.setSpacingAfter(4f);
			paragraph8criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph8criteria2);

			PdfPTable table27 = new PdfPTable(1);
			table27.setWidthPercentage(100f);

			PdfPCell cell012 = new PdfPCell(new Paragraph(
					"2.6.1 he institution has stated learning outcomes (Program and Course \r\n"
					+ "outcomes)/graduate attributes which are integrated into the assessment \r\n"
					+ "process and widely publicized through the website and other documents\r\n"
					+ "and the attainment of the same are evaluated by the institution\r\n"
					+ ""
							+ "\r\n" + "" + "" + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria26Ql().get(0).getResponse261()
									: ""),font4));
			cell012.setExtraParagraphSpace(5f);

			table27.addCell(cell012);

		
			document.add(table27);

			PdfPTable table28 = new PdfPTable(2);

			table28.setWidthPercentage(100f);
			table28.setWidths(new int[] { 3, 3 });
			table28.setSpacingBefore(5);

			PdfPCell cell709criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell709criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell709criteria2);

			PdfPCell cell80criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell80criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table28.addCell(cell80criteria2);

			PdfPCell cell81criteria2 = new PdfPCell(new Paragraph("Upload COs for all courses (exemplars from Glossary)",font5));
			cell81criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table28.addCell(cell81criteria2);

			PdfPCell cell82criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell82criteria2.setExtraParagraphSpace(5f);
			cell82criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table28.addCell(cell82criteria2);
			
			PdfPCell cell83criteria2 = new PdfPCell(new Paragraph("Upload Any Additional Information",font5));
			
			cell83criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell83criteria2);

			PdfPCell cell84criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell84criteria2.setExtraParagraphSpace(5f);
		//	cell84criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell84criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table28.addCell(cell84criteria2);

			PdfPCell cell831criteria2 = new PdfPCell(new Paragraph("Paste for Additional Information",font5));
			cell831criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell831criteria2);

			PdfPCell cell841criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell841criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell841criteria2.setExtraParagraphSpace(5f);
			table28.addCell(cell841criteria2);

			table28.setSpacingAfter(20f);
			table28.setSpacingBefore(20f);
			document.add(table28);

			PdfPTable table29 = new PdfPTable(1);
			table29.setWidthPercentage(100f);

			PdfPCell cell013 = new PdfPCell(new Paragraph(
					"2.6.2 Pass percentage of students (excluding backlog students) (Data to be \r\n"
					+ "provided only for the latest completed academic year) ." + "\r\n"
							+ "" + "" + "Response:"
							+ (criteria2Record != null
									? criteria2Record.getCriteria26Ql().get(0).getResponse262()
									: ""),font4));
			cell013.setExtraParagraphSpace(5f);
			table29.addCell(cell013);
			
			
			PdfPCell cell01322 = new PdfPCell(new Paragraph(
					"2.6.2.1  Total number of final year students who passed the examination \r\n"
					+ "conducted by Institution ." + "\r\n"
							
							+ (criteria2Record != null
									? criteria2Record.getCriteria26Ql().get(0).getInput262t1()
									: ""),font4));
			cell01322.setExtraParagraphSpace(5f);
			table29.addCell(cell01322);
			
			
			
			document.add(table29);

			PdfPTable table30 = new PdfPTable(2);

			table30.setWidthPercentage(100f);
			table30.setWidths(new int[] { 3, 3 });
			table30.setSpacingBefore(5);

			PdfPCell cell85criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell85criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table30.addCell(cell85criteria2);

			PdfPCell cell86criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell86criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table30.addCell(cell86criteria2);

			PdfPCell cell87criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell87criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table30.addCell(cell87criteria2);

			PdfPCell cell88criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell88criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell88criteria2.setExtraParagraphSpace(5f);
			
			table30.addCell(cell88criteria2);
			
			PdfPCell cell871criteria2 = new PdfPCell(new Paragraph("Paste link Additional information\r\n\r\n",font5));
			cell871criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table30.addCell(cell871criteria2);

			PdfPCell cell881criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell881criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell881criteria2.setExtraParagraphSpace(5f);
			
			table30.addCell(cell881criteria2);


			table30.setSpacingAfter(20f);
			table30.setSpacingBefore(20f);
			document.add(table30);

			PdfPTable table31criteria2 = new PdfPTable(1);
			table31criteria2.setWidthPercentage(100f);
			
			PdfPCell cell881criteria111111112 = new PdfPCell(
					new Paragraph("2.6.3 Pass Percentage of students(Data for the latest completed academic year)\r\n"
							+ "\r\n" + "Response:"
							+ (criteria2Record != null ? criteria2Record.getCriteria26Qn().get(0).getResponse263(): ""),font5));
			cell881criteria111111112.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell881criteria111111112.setExtraParagraphSpace(5f);
			
		//	table31criteria2.addCell(cell881criteria111111112);
			
			
	
	//	table31criteria2.setExtraParagraphSpace(5f);
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
					"Upload List of Programmes and number of students passed and appeared in the final year examination(Data Template)\r\n\r\n",font5));
			cell91criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table32.addCell(cell91criteria2);

			PdfPCell cell92criteria2 = new PdfPCell(
					new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell92criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table32.addCell(cell92criteria2);

			PdfPCell cell93criteria2 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
			cell93criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table32.addCell(cell93criteria2);

			PdfPCell cell94criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
			cell94criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell94criteria2);

			
			PdfPCell cell931criteria2 = new PdfPCell(new Paragraph("Link for the annual report\r\n\r\n",font5));
			cell931criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table32.addCell(cell931criteria2);

			PdfPCell cell941criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
			cell941criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell941criteria2.setExtraParagraphSpace(5f);
			
			
			table32.addCell(cell941criteria2);
			
			PdfPCell cell932criteria2 = new PdfPCell(new Paragraph("Link fo any additional information\r\n\r\n"));
			cell932criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell932criteria2.setExtraParagraphSpace(5f);
			
			table32.addCell(cell932criteria2);

			PdfPCell cell943criteria2 = new PdfPCell(new Paragraph(""));
			cell943criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table32.addCell(cell943criteria2);

			table32.setSpacingAfter(20f);
			table32.setSpacingBefore(20f);

		//	document.add(table32);
			
			
			
			// 2.7 
			
			Paragraph paragraph9criteria2 = new Paragraph("2.7	Student Satisfaction Survey\r\n\r\n", font2);
			
			
			paragraph9criteria2.setSpacingAfter(4f);
			paragraph9criteria2.setAlignment(Paragraph.ALIGN_LEFT);

			document.add(paragraph9criteria2);
			PdfPTable table33 = new PdfPTable(1);
			table33.setWidthPercentage(100f);
			PdfPCell cell905criteria2 = new PdfPCell(new Paragraph("2.7.1 Online student satisfaction survey regarding teaching learning process\r\n" + "\r\n",font4));
//					+ "Response:"
//					+ ( criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse271() != null ? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse271()
//							: "")));
	
			table33.addCell(cell905criteria2);
			document.add(table33);
			PdfPTable table34 = new PdfPTable(2);

			table34.setWidthPercentage(100f);
			table34.setWidths(new int[] { 3, 3 });
			table34.setSpacingBefore(5);

			PdfPCell cell95criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			
			cell95criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell95criteria2);

			PdfPCell cell96criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell96criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table34.addCell(cell96criteria2);

			PdfPCell cell97criteria2 = new PdfPCell(new Paragraph("Upload any additional information	", font5));
			cell97criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table34.addCell(cell97criteria2);

			PdfPCell cell98criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "", font5));
			
			cell98criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell98criteria2.setExtraParagraphSpace(5f);
			table34.addCell(cell98criteria2);

			
			PdfPCell cell908criteria2 = new PdfPCell(new Paragraph("Upload database of all currently enrolled students(Data Template)	", font5));
			cell908criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table34.addCell(cell908criteria2);

			PdfPCell cell980criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "", font5));
			cell980criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell980criteria2.setExtraParagraphSpace(5f);
			
			
			table34.addCell(cell980criteria2);

			
			table34.setSpacingAfter(20f);
			table34.setSpacingBefore(20f);
			document.add(table34);
			

			

			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
