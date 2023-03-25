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
import org.springframework.stereotype.Component;

import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria1_FileUpload;
import com.adiverse.erp.service.Criteria1Service;
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
public class Criteria1UniversityReport {

	@Value("${upload.files.path}")
	private String reportGeneratePath;

	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);


	@Autowired
	Criteria1Service service1;

	List<Criteria1_FieldInfo> criteria1List = null;
	Criteria1_FieldInfo criteria1Record = null;
	List<Criteria1_FileUpload> criteria1file = null;

	public String generateReport(Map<String, String> allParams ) throws DocumentException, IOException {
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
//
//			Map<String, String> allParams = new HashMap<String, String>();
//			allParams.put("collegeId",criteria1Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear", criteria1Fieldinfo.getCriteriaId().getFinancialYear());
//
//			allParams.put("typeofInstitution", criteria1Fieldinfo.getCriteriaId().getTypeofInstitution() );

			criteria1List = service1.getAllCriteria1Data(allParams);
			if (CollectionUtils.isNotEmpty(criteria1List)) {
				criteria1Record = criteria1List.get(0);
				criteria1file = criteria1Record.getCriteria1FileUpload();
			} else {
				criteria1Record = new Criteria1_FieldInfo();
				criteria1file = new ArrayList<Criteria1_FileUpload>();
			}

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "universityCriteria1Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

			// 1.1 
			Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
			
			
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph);

			Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font2);
			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			paragraph1.setSpacingBefore(3f);
			document.add(paragraph1);
			
			Paragraph paragraph0001 = new Paragraph("__________________________________________________________________________");
			paragraph0001.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph0001);
			
			
		
			Paragraph paragraph2 = new Paragraph(""
					+ "1.1 Curriculum Design and Development", font2);
			paragraph2.setSpacingAfter(8f);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph2);

				
			PdfPTable table11111= new PdfPTable(1);

			table11111.setWidthPercentage(100);

			
			PdfPCell cell1222222222222 = new PdfPCell( new Paragraph(

					new Paragraph(
						"	1.1.1  Curricula developed and implemented have relevance to the local,"
						+"	national, regional and global developmental needs, which is"
						+"	reflected in the Programme outcomes (POs), and Course"
						+	"Outcomes(COs) of the Programmes offered by the University"
							+ ""
							+ ""
							+ "\r\n"
						
							+ "Response:"+(criteria1Record != null
							? criteria1Record.getCriteria11Ql().get(0).getResponse111()
							: ""
							+ "\r\n"
						
									), font4)));
			cell1222222222222.setExtraParagraphSpace(5f);

			table11111.addCell(cell1222222222222);
			
	    document.add(table11111);
			

			
			// creating table
						PdfPTable table = new PdfPTable(2);

						table.setWidthPercentage(100);

						// create table for header
						PdfPCell cell1 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
						cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
						PdfPCell cell2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
						cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
						
						PdfPCell cell3 = new PdfPCell(new Paragraph("\r\nAny Upload aditional information\r\n\r\n", font5));
						cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
						
						PdfPCell cell4 = new PdfPCell(
								new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "", font5));
						
						cell4.setExtraParagraphSpace(10F);
						cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
						
						PdfPCell cell5 = new PdfPCell(new Paragraph("\r\nLink for Aditional information\r\n\r\n", font5));
						cell5.setExtraParagraphSpace(5f);
						cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
						
						PdfPCell cell6 = new PdfPCell(new Paragraph(" "));
						cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
						
						
						table.addCell(cell1);
						table.addCell(cell2);
						table.addCell(cell3);
						table.addCell(cell4);
						table.addCell(cell5);
						table.addCell(cell6);
						
						table.setSpacingBefore(20f);
						table.setSpacingAfter(20f);
						
						document.add(table);	
						
						
						
						
						PdfPTable table000 = new PdfPTable(1);

						table000.setWidthPercentage(100);		
						
						PdfPCell cell00005 = new PdfPCell(new Paragraph(
						""
						+ "1.1.2 The Programmes offered by the institution focus on employability/\r\n"
						+ "entrepreneurship/ skill development and their course syllabi are\r\n"
						+ "adequately revised to incorporate contemporary requirements.\r\n"
						+ ""
						+ ""
										+"Response:"
												+ (criteria1Record != null
												? criteria1Record.getCriteria11Qn().get(0).getResponse112()
														: ""
														+ "\r\n" ),
								font4));
						
						cell00005.setExtraParagraphSpace(10f);
						table000.addCell(cell00005);
						
				
	//////////////////////////////////////////////////////////	  	
						PdfPCell cell000051 = new PdfPCell( new Paragraph(
					""
					+ "1.1.2.1 How many Programmes were revised out of total number of Programmes offered during the last five years.\r\n\r\n"
							+ ""
						+"\r\n",
					font4));
						
						
		
						table000.addCell(cell000051);
						
			
		

		
						PdfPCell cell0000510 = new PdfPCell(new Paragraph(""
								+ "Response:"
					+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1121t1() : ""
							+ "\r\n" ),
					font4));
						cell0000510.setExtraParagraphSpace(10f);
						table000.addCell(cell0000510);
		
			
		

						PdfPCell cell01000510 = new PdfPCell( new Paragraph(
					""
					+ "1.1.2.2 Number of all Programmes offered by the institution during the last five years"			+"\r\n\r\n",
					font4));

						table000.addCell(cell01000510);
	

						PdfPCell cell010005101 = new PdfPCell(new Paragraph(""
								+ "Response:"
					+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1122t1() : ""	+"\r\n\r\n"),
					font4));
						cell010005101.setExtraParagraphSpace(10f);
						table000.addCell(cell010005101);
	
	     document.add(table000);

	PdfPTable table1 = new PdfPTable(2);
	table1.setWidthPercentage(100);
	
	
	PdfPCell cell11 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
	cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	PdfPCell cell12 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
	cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	PdfPCell cell13 = new PdfPCell(new Paragraph("\r\nMinutes of relevant Academic Council/BOS meeting\r\n\r\n", font5));
	cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	PdfPCell cell14 = new PdfPCell(
			new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "", font5));
	cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	cell14.setExtraParagraphSpace(10f);
	
	PdfPCell cell19 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n", font5));
	cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	PdfPCell cell20 = new PdfPCell(new Paragraph("", font5));
	cell20.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	PdfPCell cell17 = new PdfPCell(new Paragraph("\r\nDetails of program syllabus revision in last 5 years(Data Template)"
			+ ""
			+ "\r\n"
			
			, font5));
	cell17.setExtraParagraphSpace(10F);
	
	cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	
	PdfPCell cell18 = new PdfPCell(
			new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : "", font5));
	cell18.setExtraParagraphSpace(10f);
	
	cell18.setHorizontalAlignment(Element.ALIGN_CENTER);

	
	table1.addCell(cell11);
	table1.addCell(cell12);
	table1.addCell(cell13);
	table1.addCell(cell14);
	table1.addCell(cell19);
	table1.addCell(cell20);
	table1.addCell(cell17);
	table1.addCell(cell18);

	table1.setSpacingBefore(20f);
	table1.setSpacingAfter(20);
	document.add(table1);
	
	PdfPTable table31 = new PdfPTable(1);
	table31.setWidthPercentage(100);
	
	
	PdfPCell cell00017 = new PdfPCell(new Paragraph(
			"1.1.3 Average percentage of courses having focus on employability/ entrepreneurship/ skill development offered by the institution during the last five years"
					+"\r\n\r\n"
					+ "\r\n" + "Response:"
					+ (criteria1Record != null
					? criteria1Record.getCriteria11Qn().get(0).getResponse113()
					: ""	+"\r\n\r\n"),font4));
	cell00017.setExtraParagraphSpace(5f);
	table31.addCell(cell00017);
	
	PdfPCell cell00018 = new PdfPCell(new Paragraph(
			"1.1.3.1 Number of courses having focus on employability/ entrepreneurship/ skill development year- wise during the last five years"
			+ "\r\n\r\n",font4));

	table31.addCell(cell00018);
	
	// table31.addCell(table113_1);


	document.add(table31);
	
	
	
	if(criteria1Record.getYearTable1131().size() >0)
	{
	Table table1131 = new Table(criteria1Record.getYearTable1131().size(), 2);

	table1131.setPadding(5f);
	table1131.setWidth(100f);

	for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
		Cell cell000001=new Cell(new Paragraph(criteria1Record.getYearTable1131().get(i).getInput1131y(),font5));
		cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1131.addCell(cell000001);
	
	}
	for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
		Cell cell000003=new Cell(new Paragraph(criteria1Record.getYearTable1131().get(i).getInput1131v(),font5));
		cell000003.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1131.addCell(cell000003);
	
	
	}

 document.add(table1131);
	}
	
	if(criteria1Record.getYearTable1131().size() >0)
	{
 
 Table table11312 = new Table(criteria1Record.getYearTable11312().size(), 2);

 table11312.setPadding(5f);
 table11312.setWidth(100f);

	for (int i = 0; i < criteria1Record.getYearTable11312().size(); i++) {
		Cell cell000005=new Cell(new Paragraph(criteria1Record.getYearTable11312().get(i).getInput11312y(),font5));
		cell000005.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11312.addCell(cell000005);
	}
	for (int i = 0; i < criteria1Record.getYearTable11312().size(); i++) {
		Cell cell0000025=new Cell(new Paragraph(criteria1Record.getYearTable11312().get(i).getInput11312v(),font5));
		cell0000025.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11312.addCell(cell0000025);
		
	}

  document.add(table11312);
	}
 
 
  	

		

			PdfPTable table3 = new PdfPTable(2);
			table3.setWidthPercentage(100);

			PdfPCell cell31 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell32 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
			cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell33 = new PdfPCell(new Paragraph("\r\nProgramme / Curriculum/ Syllabus of the courses\r\n\r\n", font5));
			cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell34 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : "", font5));
			
			cell34.setExtraParagraphSpace(10f);
			
			cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell35 = new PdfPCell(new Paragraph("\r\nMoU's with relevant organizations for these courses, if any\r\n\r\n", font5));
			cell35.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell36 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : "", font5));
			cell36.setExtraParagraphSpace(10f);
			cell36.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell37 = new PdfPCell(new Paragraph(
					"\r\nMinutes of the Boards of Studies/ Academic Council meetings with approvals for these courses\r\n\r\n", font5));
			cell37.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell38 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : "",font5));
			cell38.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell38.setExtraParagraphSpace(10f);
			
			
			//cell31.setHorizontalAlignment(Element.ALIGN_CENTER); 
			PdfPCell cell39 = new PdfPCell(new Paragraph(
					"\r\nAverage percentage of courses having focus on employability/ entrepreneurship(Data Template)\r\n\r\n",font5));
			cell39.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell40 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
			cell40.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell40.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell41 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n",font5));
			cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell42 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
			cell42.setHorizontalAlignment(Element.ALIGN_CENTER); 
			cell42.setExtraParagraphSpace(10f);
			
			
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
			
			
			table3.setSpacingBefore(20f);
			table3.setSpacingAfter(20F);
			document.add(table3);
			
			// 1.2 
			Paragraph paragraph43 = new Paragraph("1.2 Academic Flexibility\r\n", font2);
			paragraph43.setSpacingAfter(5f);
			
			paragraph43.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph43);
			
			//+"\r\n\r\n"

			PdfPTable table301 = new PdfPTable(1);
			table301.setWidthPercentage(100);
			PdfPCell cell44444442 = new PdfPCell(new Paragraph(
					"1.2.1: Percentage of new courses introduced of the total number of courses across all programs offered during the last five years"
						
							+ "\r\n" + "Response:"
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getResponse121()
									: ""
									+"\r\n\r\n"),font4));
			cell44444442.setExtraParagraphSpace(10f);
			
			table301.addCell(cell44444442)	;				
									
									
			PdfPCell cell444444421 = new PdfPCell(new Paragraph(
					"1.2.1.1: How many new courses are introduced within the last five years.\r\n"
				
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getInput1211t1()
									: ""
									+ "\r\n" ),font4));
			cell444444421.setExtraParagraphSpace(10f);
			table301.addCell(cell444444421)	;	
			
			PdfPCell cell44444421 = new PdfPCell(new Paragraph(
					"1.2.1.2: Consolidated number of courses offered by the institution\r\n"
					+ "across all Programmes (without repeat count) during the last five years"
							+"\r\n"
						 ,font4));
			
			
//							+ (criteria1Record != null
//									? criteria1Record.getCriteria1FieldInfoQn().get(0).getInput1212t2()
//									: ""));
			table301.addCell(cell44444421)	;	
			
			document.add(table301);
			
			
			

			// creating tabl4

			PdfPTable table4 = new PdfPTable(2);
			table4.setWidthPercentage(100);
			PdfPTable table41 = new PdfPTable(1);
			table41.setWidthPercentage(100);

			/*
			 * com.lowagie.text.Font font4 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			 * font4.setColor(CMYKColor.BLACK);
			 */
			PdfPCell cell411 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font4));
			cell411.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell411.setExtraParagraphSpace(10f);
			
			PdfPCell cell412 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
			cell412.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell412.setExtraParagraphSpace(10f);
			
			PdfPCell cell413 = new PdfPCell(new Paragraph("\r\nMinutes of relevant Academic Council/BOS meetings\r\n\r\n",font5));
			cell413.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell414 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell414.setExtraParagraphSpace(10f);
			
			cell414.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell415 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n",font5));
			
			
			cell415.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell416 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : "",font5));
			cell416.setExtraParagraphSpace(10f);
			
			cell416.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell417 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n",font5));
	
			
			cell417.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell418 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(3).getCriteria1FilePath() : "",font5));
			
			cell418.setExtraParagraphSpace(10f);
			cell418.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell419 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n",font5));
			cell419.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell420 = new PdfPCell(new Paragraph("",font5));
			
			cell420.setExtraParagraphSpace(10f);
			cell420.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table4.addCell(cell411);
			table4.addCell(cell412);
			table4.addCell(cell413);
			table4.addCell(cell414);
			table4.addCell(cell415);
			table4.addCell(cell416);
			table4.addCell(cell417);
			table4.addCell(cell418);
			table4.addCell(cell419);
			table4.addCell(cell420);
			table4.setSpacingAfter(20f);
			table4.setSpacingAfter(20f);
			
			document.add(table4);
			
			//+"\r\n\r\n"
			
			
			PdfPTable table22 = new PdfPTable(1);
			table22.setWidthPercentage(100);
			PdfPCell cell11420 = new PdfPCell(new Paragraph(
					"1.2.2: Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year).\r\n"
							+ "\r\n" + "Response:"
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getResponse122()
									: ""
									+ "\r\n" ),font4));
			
			cell11420.setExtraParagraphSpace(10f);
			table22.addCell(cell11420);
			
			PdfPCell cell11422220 = new PdfPCell(new Paragraph(
					"1.2.2.1: Number of Programmes in which CBCS / Elective course system implemented.\r\n"
				
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getInput1221t1()
									: ""
									+ "\r\n" ),font4));
			cell11422220.setExtraParagraphSpace(10f);
			table22.addCell(cell11422220);
			
			PdfPCell cell1142220 = new PdfPCell(new Paragraph(
					"1.2.2.1: Total number of Programmes offered\r\n"
				
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getInput1221t2()
									: ""
									+ "\r\n" ),font4));
			
			
			cell1142220.setExtraParagraphSpace(10f);
			table22.addCell(cell1142220);
			
			
			document.add(table22);
			
			
			
			
			

			PdfPTable table5 = new PdfPTable(2);
			table5.setWidthPercentage(100);
		    PdfPCell cell511 = new PdfPCell(new Paragraph("\r\n\r\nFileDiscription\r\n\r\n", font4));
		    cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
		    
			PdfPCell cell512 = new PdfPCell(new Paragraph("\r\n\r\nDocument\r\n\r\n", font4));
			cell512.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell513 = new PdfPCell(new Paragraph("\r\n\r\nMinutes of relevant Academic Council/BOS meetings\r\n",font5));
			cell513.setExtraParagraphSpace(8f);
			cell513.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell514 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : "",font5));
			cell514.setExtraParagraphSpace(10f);
			
			cell514.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell515 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n",font5));
			cell515.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell516 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : "",font5));
			
			cell516.setExtraParagraphSpace(10f);
			cell516.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell517 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n",font5));
			cell517.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell518 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : "",font5));
			
			cell518.setExtraParagraphSpace(10f);
			cell518.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell519 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n",font5));
			cell519.setExtraParagraphSpace(10f);
			cell519.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell520 = new PdfPCell(new Paragraph("",font5));
			cell520.setHorizontalAlignment(Element.ALIGN_CENTER);
			

			table5.addCell(cell511);
			table5.addCell(cell512);
			table5.addCell(cell513);
			table5.addCell(cell514);
			table5.addCell(cell515);
			table5.addCell(cell516);
			table5.addCell(cell517);
			table5.addCell(cell518);
			table5.addCell(cell519);
			table5.addCell(cell520);
			table5.setSpacingAfter(20f);
			table5.setSpacingBefore(20f);
			
			document.add(table5);
			
			//+"\r\n\r\n"
			// ,1.3 
			Paragraph paragraph54 = new Paragraph("\r\n 1.3 Curriculum Enrichment\r\n", font2);
			paragraph54.setSpacingAfter(5f);
			
			paragraph54.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph54);
			
			PdfPTable table61 = new PdfPTable(1);
			table61.setWidthPercentage(100);
			
			
			PdfPCell cell000519 = new PdfPCell( new Paragraph(
					"1.3.1: Institution integrates cross-cutting issues relevant to Professional\r\n"
					+ "Ethics, Gender, Human Values, Environment & Sustainability and\r\n"
					+ "other value framework enshrined in Sustainable Development\r\n"
					+ "goals and National Education Policy – 2020 into the Curriculum\r\n"
					 + "Response:"
							+ (criteria1Record != null
									? criteria1Record.getCriteria13Ql().get(0).getResponse131()
									: ""
									+ "\r\n" ),font4));
			
			cell000519.setExtraParagraphSpace(10f);
			table61.addCell(cell000519);
			
			document.add(table61);

			// create table6

			PdfPTable table6 = new PdfPTable(2);
			table6.setWidthPercentage(100);
			

			

			PdfPCell cell611 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font4));
			cell611.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell612 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n\r\n", font4));
			cell612.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell613 = new PdfPCell(new Paragraph(
					"\r\nUpload the list and description of the courses which address the Gender, Environment and Sustainability, Human Values and Professional Ethics into the Curriculum\r\n\r\n",font5));
			cell613.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell614 = new PdfPCell(
					new Paragraph((
							criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""
								+"\r\n",font5));
			cell614.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell614.setExtraParagraphSpace(10f);
			PdfPCell cell615 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n",font5));
			cell615.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell616 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell616.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell616.setExtraParagraphSpace(10f);
			
			
			table6.addCell(cell611);
			table6.addCell(cell612);
			
			table6.addCell(cell615);
			table6.addCell(cell616);
			table6.addCell(cell613);
			table6.addCell(cell614);
			table6.setSpacingBefore(20f);
			table6.setSpacingBefore(20f);
			
			document.add(table6);

			
			

			PdfPTable table81 = new PdfPTable(1);
			table81.setWidthPercentage(100);

			PdfPCell cell000613 = new PdfPCell(new Paragraph(
					"1.3.2: Number of certificate / value-added courses / Diploma Programme/\r\n"
					+ "online courses of MOOCS / SWAYAM / e_Pathshala/ NPTEL etc.\r\n"
					+ "where the students of the institution have enrolled and successfully\r\n"
					+ "completed"
							+ "\r\n" + "Response:"
							+ (criteria1Record != null
									? criteria1Record.getCriteria13Qn().get(0).getResponse133()
									: ""
									+ "\r\n" 
									+ "\r\n" ),font4));
			cell000613.setExtraParagraphSpace(10f);
			
			table81.addCell(cell000613);
			
			
			PdfPCell cell0006113 = new PdfPCell(new Paragraph(
					"1.3.2.1: How many certificate/value added courses/Diploma\r\n"
					+ "Programme/ online courses of MOOCS/SWAYAM/e Pathshala/\r\n"
					+ "NPTEL etc (without repeat count) where the students of the institution\r\n"
					+ "have enrolled and successfully completed."
							+ "\r\n",font4));
			
			cell0006113.setExtraParagraphSpace(10f);
			table81.addCell(cell0006113);
			
			document.add(table81);
		
			// year table 1321
			if(criteria1Record.getYearTable1321() !=null)
			{

			Table table1321 = new Table(criteria1Record.getYearTable1321().size(), 2);

			table1321.setPadding(5f);
			table1321.setWidth(100f);

			for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {
				Cell cell10000=new Cell(new Paragraph(criteria1Record.getYearTable1321().get(i).getInput1321y(),font5));
				cell10000.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1321.addCell(cell10000);
			
			}
			for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {
				Cell cell100090=new Cell(new Paragraph(criteria1Record.getYearTable1321().get(i).getInput1321v(),font5));
				cell100090.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1321.addCell(cell100090);
			
			}

		 document.add(table1321);
			}
		 
		 

		

			PdfPTable table8 = new PdfPTable(2);
			table8.setWidthPercentage(100);
		
			PdfPCell cell81 = new PdfPCell(new Paragraph("\r\n\r\nFileDiscription\r\n", font4));
			cell81.setExtraParagraphSpace(5f);
			cell81.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell81.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell82 = new PdfPCell(new Paragraph("\r\n\r\nDocument\r\n", font4));
			cell82.setExtraParagraphSpace(5f);
			cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell83 = new PdfPCell(new Paragraph("\r\nList of value added courses (Data Template)\r\n",font5));
			cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell84 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : "",font5));
			cell84.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell84.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell85 = new PdfPCell(new Paragraph("\r\nBrochure or any other document relating to value added courses\r\n\r\n",font5));
			cell85.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell86 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : "",font5));
			cell86.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell86.setExtraParagraphSpace(10f);
			
			PdfPCell cell87 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell87.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell88 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(3).getCriteria1FilePath() : "",font5));
			cell88.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell88.setExtraParagraphSpace(10f);
			PdfPCell cell89 = new PdfPCell(new Paragraph("\r\n Link for Additional Information\r\n\r\n",font5));
			cell89.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell90 = new PdfPCell(new Paragraph("",font5));
			cell90.setHorizontalAlignment(Element.ALIGN_CENTER);
			table8.addCell(cell81);
			table8.addCell(cell82);
			table8.addCell(cell83);
			table8.addCell(cell84);
			table8.addCell(cell85);
			table8.addCell(cell86);
			table8.addCell(cell87);
			table8.addCell(cell88);
			table8.addCell(cell89);
			table8.addCell(cell90);
			
			table8.setSpacingAfter(20f);
			table8.setSpacingBefore(20f);
			document.add(table8);
			
			
			// create table9
		
			PdfPTable table91 = new PdfPTable(1);
			table91.setWidthPercentage(100);
			
			PdfPCell cell80008 = new PdfPCell(	new Paragraph(
					"1.3.3: Percentage of Programmes that have components of field projects /\r\n"
					+ "research projects / internships during last five years"
							+ "\r\n"
						 + "Response:"
							+ (criteria1Record != null
									? criteria1Record.getCriteria13Qn().get(0).getResponse133()
									: ""
									+ "\r\n"	),font4));
			
			cell80008.setExtraParagraphSpace(10f);
			table91.addCell(cell80008);
			
			
			
			PdfPCell cell800081 = new PdfPCell(new Paragraph(
					"1.3.3.1: Number of programmes that have components of field\r\n"
					+ "projects/research projects/internships (without repeat count) during last five\r\n"
					+ "years"
					+ (criteria1Record != null
					? criteria1Record.getCriteria13Qn().get(0).getResponse133()
					: ""
					
							+ "\r\n"
							+ "\r\n"),font4 ));
			
			cell800081.setExtraParagraphSpace(10f);
			
	    table91.addCell(cell800081);
	    
	    
	    
		PdfPCell cell8000821 = new PdfPCell(new Paragraph(
				"1.3.3.2: Number of programmes offered (without repeat count) during last\r\n"
				+ "five years"
				+ (criteria1Record != null
				? criteria1Record.getCriteria13Qn().get(0).getResponse133()
				: ""
				
						+ "\r\n"
						+ "\r\n"),font4 ));
		
		cell8000821.setExtraParagraphSpace(10f);
		
    table91.addCell(cell8000821);
	    
	    
			
			document.add(table91);
			
			
			if(criteria1Record.getYearTable1331()!=null)
			{
						Table table1331 = new Table(criteria1Record.getYearTable1331().size(), 2);

						table1331.setPadding(5);
						table1331.setWidth(100f);

						for (int i = 0; i < criteria1Record.getYearTable1331().size(); i++) {
							Cell cell100001=new Cell(new Paragraph((criteria1Record.getYearTable1331().get(i).getInput1331y()),font5));
							cell100001.setHorizontalAlignment(Element.ALIGN_CENTER);
							table1331.addCell(cell100001);
						
						}
						for (int i = 0; i < criteria1Record.getYearTable1331().size(); i++) {
							Cell cell100002=new Cell(new Paragraph(criteria1Record.getYearTable1331().get(i).getInput1331v(),font5));
							cell100002.setHorizontalAlignment(Element.ALIGN_CENTER);
							table1331.addCell(cell100002);
						
						}

					    document.add(table1331);
			}
			

			PdfPTable table900001 = new PdfPTable(1);
			table900001.setWidthPercentage(100);
			
			
			PdfPCell cell80008122 = new PdfPCell(new Paragraph(
					"1.3.3.1: Number of students enrolled in subject related Certificate or Add-on programs year wise during last five years"
							+ "\r\n"
							+ "\r\n",font4));
			
			cell80008122.setExtraParagraphSpace(10f);
            
			table900001.addCell(cell80008122);
			
			document.add(table900001);
			
			
			
			
if(criteria1Record.getYearTable13312() !=null)
{
		    Table table13312 = new Table(criteria1Record.getYearTable13312().size(), 2);

		    table13312.setPadding(5);
		    table13312.setWidth(100f);

			for (int i = 0; i < criteria1Record.getYearTable13312().size(); i++) {
				Cell cell1000011=new Cell(new Paragraph(criteria1Record.getYearTable13312().get(i).getInput13312y(),font5));
				cell1000011.setHorizontalAlignment(Element.ALIGN_CENTER);
				table13312.addCell(cell1000011);
				
			}
			for (int i = 0; i < criteria1Record.getYearTable13312().size(); i++) {
				Cell cell100011011=new Cell(new Paragraph(criteria1Record.getYearTable13312().get(i).getInput13312v(),font5));
				
				cell100011011.setHorizontalAlignment(Element.ALIGN_CENTER);
				table13312.addCell(cell100011011);
				
			}

		    document.add(table13312);
		 
}
		    
		    
		    ///////////////////
		    
		    

			PdfPTable table92 = new PdfPTable(2);

			table92.setWidthPercentage(100);

			PdfPCell cell921 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font4));
			cell921.setExtraParagraphSpace(5f);
			cell921.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell922 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
			cell922.setExtraParagraphSpace(5f);
			cell922.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell923 = new PdfPCell(new Paragraph("\r\n  Any additional information\r\n", font5));
			cell923.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell924 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : "", font5));
			cell924.setExtraParagraphSpace(10f);
			cell924.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell925 = new PdfPCell(new Paragraph("\r\nList of students enrolled(Data template)\r\n\r\n", font5));
			cell925.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell926 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : ""
					+ "\r\n" , font5));
			cell926.setExtraParagraphSpace(10f);
			cell926.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table92.addCell(cell921);
			table92.addCell(cell922);
			table92.addCell(cell923);
			table92.addCell(cell924);
			table92.addCell(cell925);
			table92.addCell(cell926);
			table92.setSpacingBefore(20F);
			table92.setSpacingAfter(20F);
			document.add(table92);
			
			
			
			PdfPTable table101 = new PdfPTable(1);
			table101.setWidthPercentage(100);

			PdfPCell cell92611 = new PdfPCell(new Paragraph(
					"1.3.4: Percentage of students undertaking field projects/ internships / student projects (Data for the latest completed academic year)."
							+ "\r\n" + "Response:"
							+ (criteria1Record != null
									? criteria1Record.getCriteria13Qn().get(0).getResponse134()
									: ""
									+ "\r\n" 		),font4));
			
			cell92611.setExtraParagraphSpace(10f);
			table101.addCell(cell92611);
			
			
			
			PdfPCell cell926111 = new PdfPCell(new Paragraph(
					"1.3.4.1: Number of students undertaking field projects / internships / student projects"
							+ "\r\n" 
							+ (criteria1Record != null
									? criteria1Record.getCriteria13Qn().get(0).getInput1341t1()
									: ""
									+ "\r\n" ),font4));
			
			cell926111.setExtraParagraphSpace(10f);
			
			table101.addCell(cell926111);
			
			PdfPCell cell9261111 = new PdfPCell(new Paragraph(
					"1.3.4.1: Number of students undertaking field projects / internships / student projects"
							+ "\r\n" 
							+ (criteria1Record != null
									? criteria1Record.getCriteria13Qn().get(0).getInput1341t2()
									: ""
									+ "\r\n" ),font4));
			
			cell9261111.setExtraParagraphSpace(10f);
			table101.addCell(cell9261111);
			
			
			document.add(table101);
			
			
			// create table10
			PdfPTable table10 = new PdfPTable(2);
			table10.setWidthPercentage(100);

			

			PdfPCell cell101 = new PdfPCell(new Paragraph("\r\n\r\nFileDiscription\r\n", font4));
			cell101.setExtraParagraphSpace(5f);
			cell101.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell102 = new PdfPCell(new Paragraph("\r\n\r\nDocument\r\n\r\n", font4));
			cell102.setExtraParagraphSpace(5f);
			cell102.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell103 = new PdfPCell(new Paragraph(
					"\r\n\r\n Any additional information\r\n\r\n"));
			cell103.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell104 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : "",font5));
			cell104.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell104.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell105 = new PdfPCell(new Paragraph("\r\n\r\nList of programs and number of students undertaking field projects / internships / student projects (Data Template)\r\n",font5));
			cell105.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell106 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
			cell106.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell106.setExtraParagraphSpace(10f);
			
			table10.addCell(cell101);
			table10.addCell(cell102);
			table10.addCell(cell103);
			table10.addCell(cell104);
			table10.addCell(cell105);
			table10.addCell(cell106);
			table10.setSpacingBefore(20f);
			table10.setSpacingAfter(20f);
            document.add(table10);

			// 1.4 
            
            
            
            Paragraph paragraph67 = new Paragraph("\r\n 1.4  Feedback System\r\n", font2);
            
            paragraph67.setSpacingAfter(5F);
			paragraph67.setAlignment(Paragraph.ALIGN_LEFT);
			document.add(paragraph67);

			PdfPTable table110 = new PdfPTable(1);
			table110.setWidthPercentage(100);
			
			
			PdfPCell cell10511 = new PdfPCell(new Paragraph(
					"1.4.1 Structured feedback for design and review of syllabus � semester-wise / year-wise is received from 1) Students, 2) Teachers, 3) Employers, 4) Alumni\r\n"
						
							+ "Response:"
							+ (criteria1Record != null
									? criteria1Record.getCriteria14Qn().get(0).getResponse141()
									: ""
									+ "\r\n" ),font4));
			cell10511.setExtraParagraphSpace(10f);
			table110.addCell(cell10511);

			document.add(table110);

			PdfPTable table111 = new PdfPTable(2);
			table111.setWidthPercentage(100);

			PdfPCell cell111 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell112 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell113 = new PdfPCell(new Paragraph("\r\nURL for stakeholder feedback report\r\n",font5));
			cell113.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell114 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell114.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell114.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell115 = new PdfPCell(new Paragraph(
					"Action taken report of the Institution on feedback report as minuted by the Governing Council,Syndicate, Board of Management",font5));
			cell115.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell115.setExtraParagraphSpace(10f);
			
			PdfPCell cell116 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell116.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell116.setExtraParagraphSpace(10f);
			
			PdfPCell cell117 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n",font5));
			cell117.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell118 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""
							+ "\r\n" ,font5));
			cell118.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell118.setExtraParagraphSpace(10f);
			
			
			table111.addCell(cell111);
			table111.addCell(cell112);
			table111.addCell(cell113);
			table111.addCell(cell114);
			table111.addCell(cell115);
			table111.addCell(cell116);
			table111.addCell(cell117);
			table111.addCell(cell118);
			document.add(table111);
			table111.setSpacingBefore(20);
			table111.setSpacingAfter(20);

			

			// create table12

			PdfPTable table11 = new PdfPTable(1);
			table11.setWidthPercentage(100);

			PdfPCell cell0000121 = new PdfPCell(new Paragraph(
					"1.4.2: The feedback system of the Institution comprises of the following :\r\n"
					+ "A.Feedback collected, analysed and action taken and report made available on website\r\n"
					+ "B. Feedback collected, analysed and action taken\r\n"
					+ "C. Feedback collected and analysed\r\n"
					+ "D. Feedback collected\r\n"
					+ "E. Feedback not obtained\r\n"
							+ "\r\n" + "Response:"
							+ (criteria1Record != null
									? criteria1Record.getCriteria14Qn().get(0).getResponse142()
									: ""
									+ "\r\n" ),font4));
			
			cell0000121.setExtraParagraphSpace(10f);

			table11.addCell(cell0000121);
			
		//	document.add(table11);

			PdfPTable table12 = new PdfPTable(2);
			table12.setWidthPercentage(100);

			PdfPCell cell121 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell121.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell122 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell122.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell123 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n",font5));
			cell123.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell124 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell124.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell124.setExtraParagraphSpace(10f);

			
			PdfPCell cell125 = new PdfPCell(new Paragraph("\r\n URL for stakeholder feedback report\r\n"));
			cell125.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell126 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""
					+ "\r\n" ,font5));
			cell126.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell126.setExtraParagraphSpace(10f);
			
			table12.addCell(cell121);
			table12.addCell(cell122);
			table12.addCell(cell123);
			table12.addCell(cell124);
			table12.addCell(cell125);
			table12.addCell(cell126);

			table12.setSpacingAfter(20f);
			table12.setSpacingAfter(20f);

		//	document.add(table12);
			
			
			

			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
