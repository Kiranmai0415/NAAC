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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class Criteria1AutonomousReport {

	@Value("${upload.files.path}")
	private String reportGeneratePath;

	public Image headerImage;

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
//			
//			Map<String, String> allParams = new HashMap<String, String>();
//			allParams.put("collegeId",criteria1Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear",criteria1Fieldinfo.getCriteriaId().getFinancialYear() );
//
//			allParams.put("typeofInstitution", criteria1Fieldinfo.getCriteriaId().getTypeofInstitution());

			criteria1List = service1.getAllCriteria1Data(allParams);
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("criteria1List" + mapper.writeValueAsString(criteria1List));

			if (CollectionUtils.isNotEmpty(criteria1List)) {
				criteria1Record = criteria1List.get(0);
				criteria1file = criteria1Record.getCriteria1FileUpload();
			} else {
				System.out.println("new");
				criteria1Record = new Criteria1_FieldInfo();
				// criteria1file = new ArrayList<Criteria1_FileUpload>();
			}

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AuthonomousCriteria1Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

/////////////////////////////////////////////////////////////////////////////////
///////////////////// criteria 1 starts hear.....
////////////////////////////////////////////////////////////////////////////////

			/*
			 * Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontTitle.setSize(16);
			 * 
			 * Font fontTitle1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontTitle1.setSize(14);
			 * 
			 * Font fontTitle2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontTitle2.setSize(12);
			 */

			Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
			paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
//			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph);

			Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font1);
			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			document.add(paragraph1);
			

			Paragraph paragraph1line = new Paragraph("______________________________________________________________________________");
			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			document.add(paragraph1line);
//cr1.1
			Paragraph paragraph2 = new Paragraph("1.1 Curriculum Design and Development\r\n", font2);
//			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			document.add(paragraph2);

			PdfPTable table111criteria1 = new PdfPTable(1);

			table111criteria1.setWidthPercentage(100);
			
			PdfPCell cell111criteria1 = new PdfPCell(
					new Paragraph("1.1.1 Curricula developed and implemented have relevance to the local, "
							+ "national, regional and global developmental needs which is reflected in Programme outcomes (POs), "
							+ "Programme Specific Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered by the Institution.\r\n\r\n"
					,font4));
			
			PdfPCell cell1110criteria1 = new PdfPCell(
					new Paragraph("Response:\r\n"
							+ (criteria1Record != null ? criteria1Record.getCriteria11Ql().get(0).getResponse111()
									: "")+"\r\n\r\n",font5));
			
			

			table111criteria1.addCell(cell111criteria1);
			table111criteria1.addCell(cell1110criteria1);
			
			cell111criteria1.setHorizontalAlignment(Element.ALIGN_LEFT);
			table111criteria1.setSpacingBefore(20f);
			table111criteria1.setSpacingAfter(20f);
			
			document.add(table111criteria1);

//
//if(criteria1Record.getCriteria1FieldInfoQl().get(0).getResponse111() !=null)
//{

//paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//document.add(paragraph4);
//}

			PdfPTable table6 = new PdfPTable(2);
			table6.setWidthPercentage(100);

// create table for header
			table6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell3 = new PdfPCell(new Paragraph("Any aditional information\r\n\r\n", font5));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell4 = new PdfPCell(
					new Paragraph(criteria1Record != null ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell5 = new PdfPCell(new Paragraph("Link for Aditional information\r\n\r\n", font5));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell6 = new PdfPCell(
					new Paragraph(criteria1Record != null ? criteria1file.get(0).getCriteria1FilePath() : " ",font5));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);

			table6.addCell(cell1);
			table6.addCell(cell2);
			table6.addCell(cell3);
			table6.addCell(cell4);
			table6.addCell(cell5);
			table6.addCell(cell6);
			document.add(table6);

		

			

			PdfPTable table1 = new PdfPTable(2);
			PdfPTable table11 = new PdfPTable(1);
			
			
			table1.setWidthPercentage(100);
			table11.setWidthPercentage(100);

//PdfPCell cell58criteria5 = new PdfPCell(
//		new Paragraph(criteria5Record != null ? criterai5file.get(15).getCriteria5FilePath() : ""));
			table1.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell12 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell13 = new PdfPCell(new Paragraph("Minutes of relevant Academic Council/BOS meeting\r\n\r\n",font5));
			cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell14 = new PdfPCell(
					new Paragraph(criteria1Record != null ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
			cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell17 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			 cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell18 = new PdfPCell(
					new Paragraph(criteria1Record != null ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell15 = new PdfPCell(
					new Paragraph("Details of program syllabus revision in last 5 years(Data Template)\r\n\r\n",font5));
			cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell16 = new PdfPCell(
					new Paragraph(criteria1Record != null ? criteria1file.get(2).getCriteria1FilePath() : "",font5));
			cell16.setHorizontalAlignment(Element.ALIGN_CENTER);

			table1.addCell(cell11);
			table1.addCell(cell12);
			table1.addCell(cell13);
			table1.addCell(cell14);
			table1.addCell(cell17);
			table1.addCell(cell18);
			table1.addCell(cell15);
			table1.addCell(cell16);
			
			
			
			PdfPCell cell160 = new PdfPCell(
					new Paragraph(
					"1.1.2 The programmes offered by the institution focus on employability/ \r\n"
					+ "entrepreneurship/ skill development and their course syllabi are \r\n"
					+ "adequately revised to incorporate contemporary requirements"
					,font4));
			table11.addCell(cell160);
			
			if (criteria1Record.getCriteria11Qn().get(0).getResponse112() != null) {
				PdfPCell cell1601 = new PdfPCell(
						new Paragraph("Response:"
						+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getResponse112() : "")+"\r\n\r\n",
						font5));
				table11.addCell(cell1601);
			}

			PdfPCell cell164 = new PdfPCell(
					new Paragraph(
					"1.1.2.1 Number of all Programmes offered by the institution during the last five years.\r\n\r\n",
					font4));
	//		table11.addCell(cell164);

			PdfPCell cell16411 = new PdfPCell(
					new Paragraph("Response:"
					+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1121t1() : "")+"\r\n\r\n",
					font5));
		//	table11.addCell(cell16411);

			PdfPCell cell16412 = new PdfPCell(
					new Paragraph(
					"1.1.2.2 How many Programmes were revised out of total number of Programmes offered during the last five years\r\n\r\n",
					font4));
	//		table11.addCell(cell16412);

			if (criteria1Record.getCriteria11Qn() != null) {
				PdfPCell cell16413 = new PdfPCell(
						new Paragraph("Response:"
						+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1122t1() : "")+"\r\n\r\n",
						font5));
			//	table11.addCell(cell16413);

			}
			
			table11.setSpacingBefore(20f);
			table11.setSpacingAfter(20f);
			
			document.add(table11);
			document.add(table1);
		
			
			

			if (criteria1Record.getYearTable1131() != null) {
				Table table1131 = new Table(criteria1Record.getYearTable1131().size(), 2);
				System.out.println(criteria1Record.getYearTable1131());

				table1131.setPadding(5);
				table1131.setWidth(100f);

				for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
					
					
					Cell cell1000criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1131().get(i).getInput1131y(),font5));
					
					cell1000criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1131.addCell(cell1000criteria1);
				}
				for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
					Cell cell1000criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1131().get(i).getInput1131v(),font5));
					
					cell1000criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1131.addCell(cell1000criteria1);
				}
				
		//		document.add(table1131);
			
			}

			PdfPTable table3 = new PdfPTable(2);
			table3.setWidthPercentage(100);
			
			PdfPTable table31 = new PdfPTable(1);
			table31.setWidthPercentage(100);
			
			table3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table31.setSpacingAfter(20);
			table31.setSpacingBefore(20);
			
			PdfPCell cell31 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell32 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell33 = new PdfPCell(new Paragraph("Programme / Curriculum/ Syllabus of the courses\r\n\r\n",font5));
			cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell34 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : "",font5));
			cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell35 = new PdfPCell(
					new Paragraph("MoU's with relevant organizations for these courses, if any\r\n\r\n",font5));
			cell35.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell36 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : "",font5));
			cell36.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell37 = new PdfPCell(new Paragraph(
					"Minutes of the Boards of Studies/ Academic Council meetings with approvals for these coursesBudget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n",font5));
			cell37.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell38 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : "",font5));
			cell38.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell39 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell39.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell40 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(7).getCriteria1FilePath() : "",font5));
			cell40.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell41 = new PdfPCell(new Paragraph(
					"Average percentage of courses having focus on employability/ entrepreneurship(Data Template)\r\n\r\n",font5));
			cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell42 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(7).getCriteria1FilePath() : "",font5));
			cell42.setHorizontalAlignment(Element.ALIGN_CENTER);

			/*
			 * com.lowagie.text.Font fontTitle43 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle43.setSize(16)
			 */

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
			
		
			PdfPCell cell421 = new PdfPCell(
					new Paragraph(
					"1.1.3 Average percentage of courses having focus on employability/ entrepreneurship/ skill development offered by the institution during the last five years\r\n"
							+ "\r\n",font4));
			
			PdfPCell cell4210 = new PdfPCell(
					new Paragraph(
					 "Response:"
							+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getResponse113()
									: "")+"\r\n\r\n",font5));
			
			
			//table31.addCell(cell421);
	//		table31.addCell(cell4210);
			PdfPCell cell4211 = new PdfPCell(
							new Paragraph(
					"1.1.3.1 Number of courses having focus on employability/ entrepreneurship/ skill development year- wise during the last five years\r\n\r\n",font4));

		//	table31.addCell(cell4211);

			table31.setSpacingBefore(20f);
			table31.setSpacingAfter(20f);

			document.add(table31);

		//	document.add(table3);
			
			if (criteria1Record.getYearTable1131().size()>0) {
				Table table1131 = new Table(criteria1Record.getYearTable1131().size(), 2);

				table1131.setPadding(5);
				table1131.setWidth(100f);

				for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
					Cell cell1002criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1131().get(i).getInput1131y(),font5));
					cell1002criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1131.addCell(cell1002criteria1);
				}
				for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
					Cell cell101criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1131().get(i).getInput1131v(),font5));
					cell101criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1131.addCell(cell101criteria1);
					
				}

		//		document.add(table1131);
			}


/////////cr1.2

			Paragraph paragraph43 = new Paragraph("\r\n1.2 Academic Flexibility\r\n", font2);
			paragraph43.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			document.add(paragraph43);

//creating tabl4

//PdfPTable table4 = new PdfPTable(2);
//table4.setWidthPercentage(100);
//PdfPTable table41 = new PdfPTable(1);
//table41.setWidthPercentage(100);

			/*
			 * com.lowagie.text.Font font4 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			 * font4.setColor(CMYKColor.BLACK);
			 * 
			 */

		
			

			PdfPTable table4 = new PdfPTable(2);
			PdfPTable table41 = new PdfPTable(1);
			table41.setWidthPercentage(100);
			table4.setWidthPercentage(100);
			table41.setSpacingAfter(20f);
			table41.setSpacingBefore(20f);

			
			PdfPCell cell411 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell411.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell412 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell412.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell413 = new PdfPCell(new Paragraph("Minutes of relevant Academic Council/BOS meetings",font5));
			cell413.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell414 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell414.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell415 = new PdfPCell(new Paragraph("Institutional data in prescribed format",font5));
			cell415.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell416 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell416.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell417 = new PdfPCell(new Paragraph("Any additional information",font5));
			cell417.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell418 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell418.setHorizontalAlignment(Element.ALIGN_CENTER);

			table4.addCell(cell411);
			table4.addCell(cell412);
			table4.addCell(cell413);
			table4.addCell(cell414);
			table4.addCell(cell417);

			table4.addCell(cell416);
			table4.addCell(cell415);
			table4.addCell(cell418);
			
			PdfPCell cell4181 = new PdfPCell(
					new Paragraph(
					"1.2.1 Percentage of new courses introduced out of the total number of \r\n"
					+ "courses across all programmes offered during the last five years",font4));
		
			table41.addCell(cell4181);
			
			PdfPCell cell41810 = new PdfPCell(
							new Paragraph(
					"1.2.1.1: Number of new courses introduced during the last five years:.\r\n\r\n"
							,font4));
			
			
			PdfPCell cell4181011 = new PdfPCell(
							new Paragraph("Response"
							+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1121t1()
									: "")+"\r\n\r\n",font5));
			
			
			table41.addCell(cell41810);
			table41.addCell(cell4181011);
					
			
			PdfPCell cell418101 = new PdfPCell(
					new Paragraph(
					"1.2.1.2:  Number of courses offered by the institution across all \r\n"
					+ "Programmes during the last five years:.\r\n\r\n",font4));
			table41.addCell(cell418101);
			
		
			
			document.add(table41);
			document.add(table4);


		
			PdfPTable table5 = new PdfPTable(2);
			table5.setWidthPercentage(100);
			/*
			 * com.lowagie.text.Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			 * font5.setColor(CMYKColor.BLACK);
			 */

			PdfPTable table5a = new PdfPTable(1);
			table5a.setWidthPercentage(100);
			
			table5a.setSpacingAfter(20f);
			table5a.setSpacingBefore(20f);
			/*
			 * com.lowagie.text.Font font5a = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			 * font5a.setColor(CMYKColor.BLACK)
			 */

			

			
			PdfPCell cell511 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell512 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell512.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell513 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell513.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell514 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell514.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell515 = new PdfPCell(new Paragraph("Minutes of relevant Academic Council/BOS meetings\r\n\r\n",font5));
			cell515.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell516 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell516.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell517 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n",font5));
			cell517.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell518 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell518.setHorizontalAlignment(Element.ALIGN_CENTER);
//PdfPCell cell519 = new PdfPCell(new Paragraph("Link for Additional Information\r\n"));
//PdfPCell cell520 = new PdfPCell(new Paragraph(""));
//3.1

			/*
			 * com.lowagie.text.Font fontTitle54 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle54.setSize(16);
			 */

			table5.addCell(cell511);
			table5.addCell(cell512);
			table5.addCell(cell513);
			table5.addCell(cell514);
			table5.addCell(cell515);
			table5.addCell(cell516);
			table5.addCell(cell517);
			table5.addCell(cell518);
			
			
			PdfPCell cell5180 = new PdfPCell(
					new Paragraph(
					"1.2.2: Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year).\r\n"
							+ (criteria1Record != null ? criteria1Record.getCriteria12Qn().get(0).getResponse122()
									: "")+"\r\n\r\n",font4));
			
			
		//	table5a.addCell(cell5180);

			PdfPCell cell51801 = new PdfPCell(
					new Paragraph(
					"1.2.2.1: Number of Programmes in which CBCS / Elective course system implemented.\r\n\r\n"
							,font4));
			
			PdfPCell cell518010 = new PdfPCell(
					new Paragraph(
					"Response"
							+ (criteria1Record != null ? criteria1Record.getCriteria12Qn().get(0).getInput1221t1()
									: "")+"\r\n\r\n",font5));
			
			
		//	table5a.addCell(cell51801);
	//		table5a.addCell(cell518010);

//			Paragraph paragraph437 = new Paragraph("1.2.2.1: Total number of Programmes offered\r\n");
//	+ (criteria1Record != null
//			? criteria1Record.getCriteria1FieldInfoQn().get(0).getInput122t1()
//			: ""));

//			document.add(paragraph437);
			document.add(table5a);
		//	document.add(table5);

//////cr 3.1

			Paragraph paragraph54 = new Paragraph("1.3 Curriculum Enrichment\r\n", font2);
			paragraph54.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			

// create table6
			document.add(paragraph54);
//			PdfPTable table61 = new PdfPTable(2);
//			table61.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table61.setWidthPercentage(100);
//			/*
//			 * com.lowagie.text.Font font6 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//			 * font6.setColor(CMYKColor.BLACK);
//			 */

			PdfPTable table611 = new PdfPTable(2);
			PdfPTable table6110 = new PdfPTable(1);
			
			table611.setWidthPercentage(100);
			
			table6110.setWidthPercentage(100);
			table6110.setSpacingAfter(20f);
			table6110.setSpacingBefore(20f);
			/*
			 * com.lowagie.text.Font font61 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * font61.setColor(CMYKColor.BLACK);
			 */

			

			PdfPCell cell611 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell611.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell612 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell612.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell613 = new PdfPCell(new Paragraph(
					"Upload the list and description of the courses which address the Gender, Environment and Sustainability, Human Values and Professional Ethics into the Curriculum\r\n\r\n",font5));
			cell613.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell614 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell614.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell615 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell615.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell616 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell616.setHorizontalAlignment(Element.ALIGN_CENTER);

			table611.addCell(cell611);
			table611.addCell(cell612);
			table611.addCell(cell615);
			table611.addCell(cell616);
			table611.addCell(cell613);
			table611.addCell(cell614);
			
			PdfPCell cell61612 = new PdfPCell(
					new Paragraph(
					"1.3.1: Institution integrates cross-cutting issues relevant to Professional \r\n"
					+ "Ethics, Gender, Human Values, Environment and Sustainability \r\n"
					+ "and other value framework enshrined in Sustainable Development \r\n"
					+ "Goals and National Education Policy – 2020 into the Curriculum\r\n"
					+ "\r\n\r\n"
							,font4));
			table6110.addCell(cell61612);

			PdfPCell cell6161212 = new PdfPCell(
					new Paragraph("Response:"+
					criteria1Record != null ? criteria1Record.getCriteria13Ql().get(0).getResponse131() : ""+"\r\n\r\n",font4));

			table6110.addCell(cell6161212);
			table611.setSpacingAfter(20f);
			table611.setSpacingBefore(20f);

			document.add(table6110);
			document.add(table611);

			

// create table7
//			PdfPTable table7 = new PdfPTable(5);
//			table7.setWidthPercentage(100);
			/*
			 * com.lowagie.text.Font font7 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			 * font61.setColor(CMYKColor.BLACK);
			 */
//PdfPTable table71 = new PdfPTable(5);
//table71.setWidthPercentage(100);
//
//PdfPCell cell71 = new PdfPCell(new Paragraph("2020-21"));
//PdfPCell cell72 = new PdfPCell(new Paragraph("2019-20"));
//PdfPCell cell73 = new PdfPCell(new Paragraph("2018-19"));
//PdfPCell cell74 = new PdfPCell(new Paragraph("2017-18"));
//PdfPCell cell75 = new PdfPCell(new Paragraph("2016-17"));
//PdfPCell cell76 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell77 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell78 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell79 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell80 = new PdfPCell(new Paragraph("  "));
//
//
//table7.addCell(cell71);
//table7.addCell(cell72);
//table7.addCell(cell73);
//table7.addCell(cell74);
//table7.addCell(cell75);
//table7.addCell(cell76);
//table7.addCell(cell77);
//table7.addCell(cell78);
//table7.addCell(cell79);
//table7.addCell(cell80);
//
//document.add(table7);

// create 8

////			PdfPTable table81 = new PdfPTable(1);
////			table81.setWidthPercentage(100);
////			table81.setHorizontalAlignment(Element.ALIGN_CENTER);
////			/*
//			 * com.lowagie.text.Font font81 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font81.setColor(CMYKColor.BLACK);
//			 */
////
//PdfPTable table82 = new PdfPTable(5);
//table82.setWidthPercentage(100);
///*
//* com.lowagie.text.Font font82 =
//* FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//* font82.setColor(CMYKColor.BLACK);
//*/
//// create table82
//PdfPCell cell821 = new PdfPCell(new Paragraph("2020-21"));
//PdfPCell cell822 = new PdfPCell(new Paragraph("2019-20"));
//PdfPCell cell823 = new PdfPCell(new Paragraph("2018-19"));
//PdfPCell cell824 = new PdfPCell(new Paragraph("2017-18"));
//PdfPCell cell825 = new PdfPCell(new Paragraph("2016-17"));
//PdfPCell cell826 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell827 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell828 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell829 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell8230 = new PdfPCell(new Paragraph("  "));
//
//table82.addCell(cell821);
//table82.addCell(cell822);
//table82.addCell(cell823);
//table82.addCell(cell824);
//table82.addCell(cell825);
//table82.addCell(cell826);
//table82.addCell(cell827);
//table82.addCell(cell828);
//table82.addCell(cell829);
//table82.addCell(cell8230);
//document.add(table82);

// create table8

			PdfPTable table8 = new PdfPTable(2);
			table8.setWidthPercentage(100);
			/*
			 * com.lowagie.text.Font font8 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * font8.setColor(CMYKColor.BLACK);
			 */

			PdfPTable table33 = new PdfPTable(1);
			table33.setWidthPercentage(100);
			PdfPCell cell61612120 = new PdfPCell(
					new Paragraph(
					"1.3.2: Number of certificate/value added courses/Diploma Programmes \r\n"
					+ "offered by the institutions and online courses of MOOCs, \r\n"
					+ "SWAYAM/e-PG Pathshala/ NPTEL etc. where the students of the \r\n"
					+ "institution have enrolled and successfully completed during the last \r\n"
					+ "five years.\r\n\r\n"
							+ "\r\n"
							+ (criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getResponse133()
									: "")+"\r\n\r\n",font4));
			table33.addCell(cell61612120);
			
			PdfPCell cell6161212010 = new PdfPCell(
					new Paragraph("1.3.2.1: Number of certificate/value added courses/Diploma \r\n"
							+ "Programmes offered by the institutions and online courses of \r\n"
							+ "MOOCs, SWAYAM/e-PG Pathshala/ NPTEL etc. where the \r\n"
							+ "students of the institution have enrolled and successfully completed \r\n"
							+ "during the last five years\r\n\r\n"
											,font4));
			
			table33.addCell(cell6161212010);

			document.add(table33);

//  if( criteria2Record.getYearTable2121() !=null)
//{
//Table table2122 = new Table(criteria2Record.getYearTable2121().size()+1, 2);

		
	
			PdfPCell cell81 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell81.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell82 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell83 = new PdfPCell(new Paragraph("List of value added courses (Data Template)\r\n\r\n",font5));
			cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell84 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell84.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell85 = new PdfPCell(
					new Paragraph("Brochure or any other document relating to value added courses\r\n\r\n",font5));
			cell85.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell86 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell86.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell87 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell87.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell88 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell88.setHorizontalAlignment(Element.ALIGN_CENTER);

			table8.addCell(cell81);
			table8.addCell(cell82);
			table8.addCell(cell83);
			table8.addCell(cell84);
			table8.addCell(cell85);
			table8.addCell(cell86);
			table8.addCell(cell87);
			table8.addCell(cell88);
			table8.setSpacingAfter(20f);
			table8.setSpacingBefore(20f);
			
			document.add(table8);
			
			if (criteria1Record.getYearTable1321() != null) {
				Table table1321 = new Table(criteria1Record.getYearTable1321().size() + 1, 2);

				table1321.setPadding(5);
				table1321.setWidth(100f);

				table1321.addCell("year");

				for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {
					Cell cell102criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1321().get(i).getInput1321y(),font5));
					cell102criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1321.addCell(cell102criteria1);
					
					
				}

				table1321.addCell("number");
				for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {

					Cell cell12criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1321().get(i).getInput1321v(),font5));
					cell12criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1321.addCell(cell12criteria1);
					
					
				}
		//		document.add(table1321);
				
			
			}

			
			
			
// create table9
//PdfPTable table9 = new PdfPTable(5);
//PdfPTable table91 = new PdfPTable(1);
//// PdfPTable table92=new PdfPTable(2);

//table9.setWidthPercentage(100);
//table91.setWidthPercentage(100);
//// table92.setWidthPercentage(100);
//
///*
//* com.lowagie.text.Font font9 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//* font9.setColor(CMYKColor.BLACK);
//*/
//PdfPCell cell91 = new PdfPCell(new Paragraph("2020-21"));
//PdfPCell cell92 = new PdfPCell(new Paragraph("2019-20"));
//PdfPCell cell93 = new PdfPCell(new Paragraph("2018-19"));
//PdfPCell cell94 = new PdfPCell(new Paragraph("2017-18"));
//PdfPCell cell95 = new PdfPCell(new Paragraph("2016-17"));
//PdfPCell cell96 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell97 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell98 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell99 = new PdfPCell(new Paragraph(" "));
//PdfPCell cell100 = new PdfPCell(new Paragraph("  "));
//
//table9.addCell(cell91);
//table9.addCell(cell92);
//table9.addCell(cell93);
//table9.addCell(cell94);
//table9.addCell(cell95);
//table9.addCell(cell96);
//table9.addCell(cell97);
//table9.addCell(cell98);
//table9.addCell(cell99);
//table9.addCell(cell100);
//document.add(table9);


			PdfPTable table92 = new PdfPTable(2);
			PdfPTable table920 = new PdfPTable(1);
			
			
			table92.setWidthPercentage(100);
			table920.setWidthPercentage(100);
			table920.setSpacingAfter(20f);
			table920.setSpacingBefore(20f);

			PdfPCell cell921 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell921.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell922 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell922.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell923 = new PdfPCell(new Paragraph("List of students enrolled\r\n\r\n",font5));
			cell923.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell924 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell924.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell925 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell925.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell926 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell926.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell927 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n",font5));
			cell927.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell928 = new PdfPCell(new Paragraph("",font5));
			cell928.setHorizontalAlignment(Element.ALIGN_CENTER);

			table92.addCell(cell921);
			table92.addCell(cell922);
			table92.addCell(cell923);
			table92.addCell(cell924);
			table92.addCell(cell925);
			table92.addCell(cell926);
			table92.addCell(cell927);
			table92.addCell(cell928);
			
			PdfPCell cell106 = new PdfPCell(
					new Paragraph(
					"1.3.3: Percentage of programmes that have components of field projects  \r\n"
					+ "research projects / internships during the last five years\r\n\r\n"
							+ "Response",font4));
			
			
			
			table920.addCell(cell106);
			
			
			
			PdfPCell cell1060 = new PdfPCell(
					new Paragraph(
					"1.3.3.1: Number of programmes that have components of field \r\n"
					+ "projects / research projects / internships during the last five years:\r\n"
					+ "\r\n\r\n",font4));
			
			table920.addCell(cell1060);
		
			PdfPCell cell1063 = new PdfPCell(
					new Paragraph(  "Response:"+
					criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getResponse133() : ""+"\r\n\r\n",font5));
			table920.addCell(cell1063);
			
			PdfPCell cell10601 = new PdfPCell(
					new Paragraph(
					"1.3.3.2: Number of programmes offered by the institution during the \r\n"
					+ "last five years:"
					+ "\r\n\r\n",font4));
			
			table920.addCell(cell10601);
		
		
		
			document.add(table920);

			document.add(table92);


			if (criteria1Record.getYearTable1331() != null) {
				Table table1331 = new Table(criteria1Record.getYearTable1331().size(), 2);
				System.out.println(criteria1Record.getYearTable1331());

				table1331.setPadding(5);
				table1331.setWidth(100f);

				for (int i = 0; i < criteria1Record.getYearTable1331().size(); i++) {
					Cell cell1201criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1331().get(i).getInput1331y(),font5));
					cell1201criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1331.addCell(cell1201criteria1);
				}
				for (int i = 0; i < criteria1Record.getYearTable1331().size(); i++) {
					Cell cell1202criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1331().get(i).getInput1331v(),font5));
					cell1202criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1331.addCell(cell1202criteria1);
				}

			//	document.add(table1331);
				
			}

		
			

// create table10
			PdfPTable table10 = new PdfPTable(2);
			table10.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10.setWidthPercentage(100);

			PdfPTable table101 = new PdfPTable(1);
			table101.setWidthPercentage(100);

			PdfPCell cell101 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell101.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell102 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell102.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell103 = new PdfPCell(new Paragraph(
					"List of programs and number of students undertaking field projects / internships / student projects (Data Template)",font5));
			cell103.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell104 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell104.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell105 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell105.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1061 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
			cell1061.setHorizontalAlignment(Element.ALIGN_CENTER);

			table10.addCell(cell101);
			table10.addCell(cell102);
			table10.addCell(cell103);
			table10.addCell(cell104);
			table10.addCell(cell105);
			table10.addCell(cell1061);
			
			PdfPCell cell10611 = new PdfPCell(
					new Paragraph(
					"1.3.4: Percentage of students undertaking field projects/ internships / student projects (Data for the latest completed academic year)"
							+ (criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getResponse134()
									: "")+"\r\n\r\n",font4));
	//		table101.addCell(cell10611);

			PdfPCell cell1061100 = new PdfPCell(
					new Paragraph(
					"1.3.4.1: Number of students undertaking field projects / internships / student projects.\r\n"
							+ (criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getInput1341t1()
									: "")+"\r\n\r\n",font4));
			
			PdfPCell cell10611000 = new PdfPCell(
					new Paragraph(
					"Response"
							+ (criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getInput1341t1()
									: "")+"\r\n\r\n",font4));
			
		//	table101.addCell(cell1061100);
		//	table101.addCell(cell10611000);

//			PdfPCell cell10611001 = new PdfPCell(
//					new Paragraph("1.3.4.1: Total number of students\r\n"
//					+ (criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getInput1341t1() : ""),font5));
//			table101.addCell(cell10611001);
//			
			table101.setSpacingAfter(20f);
			table101.setSpacingBefore(20f);
	//		document.add(table101);

			document.add(table10);

//////////////////cr 4.1

			Paragraph paragraph6741 = new Paragraph("1.4  Feedback System\r\n\r\n", font2);
			paragraph6741.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph6741);


			PdfPTable table111141 = new PdfPTable(2);
			table111141.setWidthPercentage(100);
			PdfPTable table1111410 = new PdfPTable(1);
			table1111410.setWidthPercentage(100);
			table1111410.setSpacingAfter(20f);
			table1111410.setSpacingBefore(20f);

			PdfPCell cell1111 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell1111.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1121 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell1121.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1131 = new PdfPCell(new Paragraph("URL for stakeholder feedback report\r\n\r\n",font5));
			cell1131.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1141 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
			cell1141.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1151 = new PdfPCell(new Paragraph(
					"Action taken report of the Institution on feedback report as minuted by the Governing Council,Syndicate, Board of Management\r\n\r\n",font5));
			cell1151.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1161 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
			cell1161.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1171 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
			cell1171.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1181 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
			cell1181.setHorizontalAlignment(Element.ALIGN_CENTER);

			table111141.addCell(cell1111);
			table111141.addCell(cell1121);
			table111141.addCell(cell1131);
			table111141.addCell(cell1141);
			table111141.addCell(cell1151);
			table111141.addCell(cell1161);
			table111141.addCell(cell1171);
			table111141.addCell(cell1181);
			
			
			PdfPCell cell11810 = new PdfPCell(
					new Paragraph(
					"1.4.1: Structured feedback for curriculum and its transaction is regularly \r\n"
					+ "obtained from stakeholders like Students, Teachers, Employers, \r\n"
					+ "Alumni, Academic peers etc., and Feedback processes of the \r\n"
					+ "institution may be classified as follows:\r\n"
					+ "A. Feedback collected, analysed, action taken& communicated to \r\n"
					+ "the relevant bodies and feedback hosted on the institutional \r\n"
					+ "website\r\n"
					+ "B. Feedback collected, analysed, action has been taken and \r\n"
					+ "communicated to the relevant bodies\r\n"
					+ "C. Feedback collected and analysed\r\n"
					+ "D. Feedback collected\r\n"
					+ "E. Feedback not collecte\r\n\r\n"
							,font4));
			table1111410.addCell(cell11810);
		
			if (criteria1Record.getCriteria11Ql() != null) {
				PdfPCell cell118101 = new PdfPCell(
						new Paragraph("Response\r\n"+
						criteria1Record != null ? criteria1Record.getCriteria14Qn().get(0).getResponse141() : ""+"\r\n\r\n",font5));
				table1111410.addCell(cell118101);
			
			}

			document.add(table1111410);
			document.add(table111141);

			

			PdfPTable table111241 = new PdfPTable(2);
			table111241.setWidthPercentage(100);
			
			PdfPTable table1112410 = new PdfPTable(1);
			table1112410.setWidthPercentage(100);
			
			table1112410.setSpacingAfter(20f);
			table1112410.setSpacingBefore(20f);

			PdfPCell cell1211 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell1211.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1221 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell1221.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1231 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell1231.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1241 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
			cell1241.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1251 = new PdfPCell(new Paragraph("URL for stakeholder feedback report\r\n\r\n",font5));
			cell1251.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1261 = new PdfPCell(
					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
			cell1261.setHorizontalAlignment(Element.ALIGN_CENTER);

			table111241.addCell(cell1211);
			table111241.addCell(cell1221);
			table111241.addCell(cell1231);
			table111241.addCell(cell1241);
			table111241.addCell(cell1251);
			table111241.addCell(cell1261);
			
			
			PdfPCell cell126112 = new PdfPCell(
					new Paragraph(
					"1.4.2: The feedback system of the Institution comprises of the following :\r\n\r\n",font4));
		
//			table1112410.addCell(cell126112);
			
			PdfPCell cell126111 = new PdfPCell(
							new Paragraph("Response\r\n"+
					criteria1Record != null ? criteria1Record.getCriteria14Qn().get(0).getResponse142() : ""+"\r\n\r\n",font5));
			cell126111.setExtraParagraphSpace(10f);
//
		//	table1112410.addCell(cell126111);

			document.add(table1112410);
	//		document.add(table111241);

			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}
}
