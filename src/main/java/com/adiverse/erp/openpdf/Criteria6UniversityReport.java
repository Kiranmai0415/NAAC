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

import com.adiverse.erp.model.Criteria6_FieldInfo;
import com.adiverse.erp.model.Criteria6_FileUpload;
import com.adiverse.erp.service.Criteria6Service;
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
public class Criteria6UniversityReport {

	@Value("${upload.files.path}")
	private String reportGeneratePath;


	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);

	@Autowired
	Criteria6Service service6;

	List<Criteria6_FieldInfo> criteria6List = null;
	Criteria6_FieldInfo criteria6Record = null;
	List<Criteria6_FileUpload> criteria6file = null;

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
//			allParams.put("collegeId",criteria6Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear", criteria6Fieldinfo.getCriteriaId().getFinancialYear());
//
//			allParams.put("typeofInstitution", criteria6Fieldinfo.getCriteriaId().getTypeofInstitution() );

			criteria6List = service6.getAllCriteria6Data(allParams);
			if (CollectionUtils.isNotEmpty(criteria6List)) {
				criteria6Record = criteria6List.get(0);
				criteria6file = criteria6Record.getCriteria6FileUpload();
			} else {
				criteria6Record = new Criteria6_FieldInfo();
				criteria6file = new ArrayList<Criteria6_FileUpload>();
			}

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "Criteria6UniversityReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

			// 6.1
			
		Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
			
			
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph);
			

			Paragraph paragraph1criteria6 = new Paragraph("Criterion 6 - Governance, Leadership and Management\r\n",
					font2);
			paragraph1criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			paragraph1criteria6.setSpacingBefore(2f);
			document.add(paragraph1criteria6);
			
			
			Paragraph paragraph1criteria00006 = new Paragraph("________________________________________________________________\r\n",
					font1);
			paragraph1criteria00006.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph1criteria00006);
			
			
			

			Paragraph paragraph2criteria6 = new Paragraph("6.1	Institutional Vision and Leadership\r\n\r\n", font2);
			paragraph2criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph2criteria6);
			
			
			PdfPTable table1criteria0000006 = new PdfPTable(1);
			table1criteria0000006.setWidthPercentage(100);	
			
			
			
			
			PdfPCell cell1criteria1111116 = new PdfPCell(new Paragraph(
					"6.1.1 The Institutional governance and leadership are in accordance with \r\n"
					+ "Vision and mission of the institution and it is visible in various \r\n"
					+ "institutional practices such as NEP implementation, sustained \r\n"
					+ "institutional growth, de-centralization, participation in the institutional \r\n"
					+ "governance and in their Short term/ Long term institutional perspective \r\n"
					+ "plan. "
							+ (criteria6Record != null
									? criteria6Record.getCriteria61Ql().get(0).getResponse611()
									: ""),
					font4));
			
			cell1criteria1111116.setExtraParagraphSpace(10f);
			
			table1criteria0000006.addCell(cell1criteria1111116);
			
			document.add(table1criteria0000006);
	

			com.lowagie.text.Font font0Title1 = FontFactory.getFont(FontFactory.HELVETICA);
			font0Title1.setSize(12);

		

			PdfPTable table1criteria6 = new PdfPTable(2);
			table1criteria6.setWidthPercentage(100);
			PdfPCell cell1criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
			cell1criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell2criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell2criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell3criteria6 = new PdfPCell(new Paragraph("Paste link for additional Information",font5));
			cell3criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell4criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
			cell4criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell4criteria6.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell5criteria6 = new PdfPCell(new Paragraph("Upload any additional information",font5));
			cell5criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell6criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
			cell6criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell6criteria6.setExtraParagraphSpace(10f);
			
			
			
			table1criteria6.addCell(cell1criteria6);
			table1criteria6.addCell(cell2criteria6);
			table1criteria6.addCell(cell3criteria6);
			table1criteria6.addCell(cell4criteria6);
			table1criteria6.addCell(cell5criteria6);
			table1criteria6.addCell(cell6criteria6);
			table1criteria6.setSpacingBefore(20f);
			table1criteria6.setSpacingAfter(20f);
			document.add(table1criteria6);
			

			
			PdfPTable table1criteria6000 = new PdfPTable(1);
			table1criteria6000.setWidthPercentage(100);
			
			
//			PdfPCell cell6criteria6111 = new PdfPCell(		new Paragraph(
//					"6.1.2: The effective leadership is reflected in various institutional practices such as decentralization and participative management.",font4));
//			cell6criteria6111.setExtraParagraphSpace(10F);
//			
//			table1criteria6000.addCell(cell6criteria6111);
//
//			if (criteria6Record.getCriteria61Ql() != null) {
//				PdfPCell cell6criteria611001 = new PdfPCell(		new Paragraph(
//						criteria6Record != null ? criteria6Record.getCriteria61Ql().get(0).getInput612t1()
//								: ""));
//				
//				cell6criteria611001.setExtraParagraphSpace(10f);
//				
//				table1criteria6000.addCell(cell6criteria611001);
//	
//
//			}
//			
//			document.add(table1criteria6000);
//			
			

//			Paragraph paragraph3criteria613 = new Paragraph("\r\n");
//			document.add(paragraph3criteria613);
//			PdfPTable table11criteria6 = new PdfPTable(2);
//			table11criteria6.setWidthPercentage(100);
//			PdfPCell cell11criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
//			cell11criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell21criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
//			cell21criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell31criteria6 = new PdfPCell(new Paragraph("Paste link for additional Information",font5));
//			cell31criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell41criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
//			cell41criteria6.setExtraParagraphSpace(10f);
//			cell41criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell51criteria6 = new PdfPCell(new Paragraph("Upload any additional information"));
//			cell51criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell61criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
//			cell61criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell61criteria6.setExtraParagraphSpace(10f);
//			
//			table11criteria6.addCell(cell11criteria6);
//			table11criteria6.addCell(cell21criteria6);
//			table11criteria6.addCell(cell31criteria6);
//			table11criteria6.addCell(cell41criteria6);
//			table11criteria6.addCell(cell51criteria6);
//			table11criteria6.addCell(cell61criteria6);
//			document.add(table11criteria6);

			// 6.2

			Paragraph paragraph11criteria6 = new Paragraph("6.2 Strategy Development and Deployment(10)\r\n\r\n\r\n",
					font2);
			paragraph11criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph11criteria6);
			// create a table 3
			PdfPTable table3criteria6 = new PdfPTable(2);
			table3criteria6.setWidthPercentage(100);
			PdfPTable table31criteria6 = new PdfPTable(1);
			table31criteria6.setWidthPercentage(100);
//
//			PdfPCell cell301criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
//			cell301criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			
//			PdfPCell cell302criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
//			cell302criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell303criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
//			cell303criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell304criteria6 = new PdfPCell(new Paragraph("",font5));
//			cell304criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			
//			PdfPCell cell305criteria6 = new PdfPCell(
//					new Paragraph("Strategic Plan and deployment documents on the\r\n" + "website\r\n\r\n\r\n",font5));
//			cell305criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			
//			PdfPCell cell306criteria6 = new PdfPCell(new Paragraph("",font5));
//			cell306criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			
//			table3criteria6.addCell(cell301criteria6);
//			table3criteria6.addCell(cell302criteria6);
//			table3criteria6.addCell(cell303criteria6);
//			table3criteria6.addCell(cell304criteria6);
//
//			table3criteria6.addCell(cell305criteria6);
//			table3criteria6.addCell(cell306criteria6);

			PdfPCell cell312 = new PdfPCell(new Paragraph(
					"6.2.1	The institutional perspective plan is effectively deployed and function of \r\n"
					+ "the Institutional bodies are effective and efficient as visible from policies, \r\n"
					+ "administrative set-up, appointment, service rules, procedures etc.\r\n"
				 + ""
							+ "Response:"
							+ (criteria6Record != null
									? criteria6Record.getCriteria62Ql().get(0).getResponse621()
									: ""),
							
					font4));
			
			cell312.setExtraParagraphSpace(10f);
			table31criteria6.addCell(cell312);

		//	table31criteria6.addCell(table3criteria6);

			document.add(table31criteria6);
			
			table3criteria6.setSpacingBefore(20f);
			table3criteria6.setSpacingAfter(20f);
			document.add(table3criteria6);
			

			// create table 4
			PdfPTable table4criteria6 = new PdfPTable(2);
			table4criteria6.setWidthPercentage(100);
			PdfPTable table41criteria6 = new PdfPTable(1);
			table41criteria6.setWidthPercentage(100);

			PdfPCell cell401criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
			cell401criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell42criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell42criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell43criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n",font5));
			cell43criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell44criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : ""),font5));
			cell44criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell44criteria6.setExtraParagraphSpace(10f);
			
			PdfPCell cell45criteria6 = new PdfPCell(
					new Paragraph("Link to Organogram of the Institution webpage\r\n\r\n\r\n",font5));
			cell45criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell46criteria6 = new PdfPCell(new Paragraph("",font5));
			cell46criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell47criteria6 = new PdfPCell(new Paragraph("Link for additional information",font5));
			cell47criteria6.setExtraParagraphSpace(10);
			cell47criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell48criteria6 = new PdfPCell(new Paragraph("",font5));
			cell48criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table4criteria6.addCell(cell401criteria6);
			table4criteria6.addCell(cell42criteria6);
			table4criteria6.addCell(cell43criteria6);
			table4criteria6.addCell(cell44criteria6);
			table4criteria6.addCell(cell45criteria6);
			table4criteria6.addCell(cell46criteria6);
			table4criteria6.addCell(cell47criteria6);
			table4criteria6.addCell(cell48criteria6);
			PdfPCell cell41x = new PdfPCell(new Paragraph(
					"6.2.2	Institution Implements e-governance in its operations"
					+ "6.2.2.1 e-governance is implemented covering the following areas of \r\n"
					+ "operations:\r\n"
					+ "1. Administration including complaint management\r\n"
					+ "2. Finance and Accounts\r\n"
					+ "3. Student Admission and Support\r\n"
					+ "4. Examinations\r\n"
					+ "Options:\r\n"
					+ "A. All of the above\r\n"
					+ "B. Any3 of the above\r\n"
					+ "C. Any2 of the above \r\n"
					+ "D. Any1 of the above\r\n"
					+ "E. None of the above .\r\n"
					+ "Response:"
							+ (criteria6Record != null
									? criteria6Record.getCriteria62Ql().get(0).getInput622t1()
									: ""),
					font4));
			cell41x.setExtraParagraphSpace(10f);
			
			table41criteria6.addCell(cell41x);

		//	table41criteria6.addCell(table4criteria6);
	
			document.add(table41criteria6);
			table4criteria6.setSpacingBefore(20f);
			table4criteria6.setSpacingAfter(20f);
			document.add(table4criteria6);
			
			
			// create table5
			PdfPTable table5criteria6 = new PdfPTable(2);
			table5criteria6.setWidthPercentage(100);
			PdfPTable table51criteria6 = new PdfPTable(1);
			table51criteria6.setWidthPercentage(100);

			PdfPCell cell501criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
			
			cell501criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell52criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			
			cell52criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell53criteria6 = new PdfPCell(new Paragraph("Screen shots of user interfaces\r\n\r\n\r\n",font5));
		
			cell53criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell53criteria6.setExtraParagraphSpace(10f);
			
			PdfPCell cell54criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(3).getCriteria6FilePath() : ""),font5));
			cell54criteria6.setExtraParagraphSpace(10f);
			cell54criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell54criteria6.setBackgroundColor(Align:);
			PdfPCell cell55criteria6 = new PdfPCell(
					new Paragraph("ERP (Enterprise Resource Planning) Document\r\n\r\n\r\n",font5));
			
			cell55criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell56criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(4).getCriteria6FilePath() : ""),font5));
			
			cell56criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell56criteria6.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell57criteria6 = new PdfPCell(
					new Paragraph("Details of implementation of e-governance in areas\r\n"
							+ "of operation, Administration etc (Data Template)\r\n" + "\r\n\r\n\r\n",font5));
			cell57criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell58criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(5).getCriteria6FilePath() : ""),font5));
			cell58criteria6.setExtraParagraphSpace(10f);
			cell58criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell59criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n",font5));
			
			cell59criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell59criteria6.setExtraParagraphSpace(10f);
			
			PdfPCell cell60criteria6 = new PdfPCell(new Paragraph("",font5));
			
			cell60criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table5criteria6.addCell(cell501criteria6);
			table5criteria6.addCell(cell52criteria6);
			table5criteria6.addCell(cell53criteria6);
			table5criteria6.addCell(cell54criteria6);
			table5criteria6.addCell(cell55criteria6);
			table5criteria6.addCell(cell56criteria6);
			table5criteria6.addCell(cell57criteria6);
			table5criteria6.addCell(cell58criteria6);
			table5criteria6.addCell(cell59criteria6);
			table5criteria6.addCell(cell60criteria6);
			
			
			PdfPCell cell51x = new PdfPCell(
					new Paragraph(
							"6.2.3	Implementation of e-governance in areas of operation\r\n" + "\r\n"
									+ "1.	Administration\r\n" + "2.	Finance and Accounts\r\n"
									+ "3.	Student Admission and Support\r\n" + "4.	Examination\r\n" + "\r\n" + "",
							font4));
		//	table51criteria6.addCell(cell51x);
		//	table51criteria6.addCell("Response: A. All of the above");
		//	table51criteria6.addCell(table5criteria6);
			document.add(table51criteria6);
			
			
			table5criteria6.setSpacingAfter(20f);
			table5criteria6.setSpacingBefore(20f);
			document.add(table5criteria6);

			// 6.3

			Paragraph paragraph12criteria6 = new Paragraph("6.3  Faculty Empowerment Strategies\r\n", font2);
			paragraph12criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			paragraph12criteria6.setSpacingAfter(2f);
			document.add(paragraph12criteria6);
			// create table6
			PdfPTable table6criteria6 = new PdfPTable(2);
			table6criteria6.setWidthPercentage(100);
	

			PdfPCell cell601criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
			cell601criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell62criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell62criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
//			PdfPCell cell63criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell64criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(6).getCriteria6FilePath() : "")));
			PdfPCell cell65criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n",font5));
			cell65criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell66criteria6 = new PdfPCell(new Paragraph("",font5));
			cell66criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
//			table6criteria6.addCell(cell601criteria6);
//			table6criteria6.addCell(cell62criteria6);
////			table6criteria6.addCell(cell63criteria6);
////			table6criteria6.addCell(cell64criteria6);
//			table6criteria6.addCell(cell65criteria6);
//			table6criteria6.addCell(cell66criteria6);
//			
			
			PdfPTable table61criteria6 = new PdfPTable(1);
			table61criteria6.setWidthPercentage(100);

			PdfPCell cell66criteria0006 = new PdfPCell(new Paragraph(
					"6.3.1 The institution has a performance appraisal system, promotional \r\n"
					+ "avenues and effective welfare measures for teaching and non-teaching \r\n"
					+ "staff\r\n",font4));
			cell66criteria0006.setExtraParagraphSpace(10);
			table61criteria6.addCell(cell66criteria0006);
			
			
			if (criteria6Record.getCriteria63Ql() != null) {
				PdfPCell cell66criteria00106 = new PdfPCell(new Paragraph(
						criteria6Record != null ? criteria6Record.getCriteria63Ql().get(0).getResponse631()
								: "",font4));
				cell66criteria00106.setExtraParagraphSpace(10f);
				table61criteria6.addCell(cell66criteria00106);
			}
			
			document.add(table61criteria6);

			// create a table7

			Paragraph paragraph12criteria671 = new Paragraph("\r\n");
			document.add(paragraph12criteria671);

			PdfPTable table71criteria6 = new PdfPTable(2);
			table71criteria6.setWidthPercentage(100);
			
			
			PdfPCell cell71criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n", font4));
			cell71criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell72criteria6 = new PdfPCell(new Paragraph("Document\r\n", font4));
			cell72criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell73criteria6 = new PdfPCell(
					new Paragraph("Strategic Plan and deployment documents on the website\r\n",font5));
			cell73criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell74criteria6 = new PdfPCell(
					new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
			cell74criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell74criteria6.setExtraParagraphSpace(10f);
			
			PdfPCell cell75criteria6 = new PdfPCell(new Paragraph("Paste link for additional Information\r\n",font5));
			
			cell75criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell76criteria6 = new PdfPCell(new Paragraph(
					new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5)));
			cell76criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell76criteria6.setExtraParagraphSpace(10f);
			
			PdfPCell cell77criteria6 = new PdfPCell(new Paragraph("Upload any additional information\r\n",font5));
			
			cell77criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell78criteria6 = new PdfPCell(new Paragraph(
					new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5)));

			cell78criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell78criteria6.setExtraParagraphSpace(10f);
			
			table71criteria6.addCell(cell71criteria6);
			table71criteria6.addCell(cell72criteria6);
			table71criteria6.addCell(cell73criteria6);
			table71criteria6.addCell(cell74criteria6);
			table71criteria6.addCell(cell75criteria6);
			table71criteria6.addCell(cell76criteria6);
			table71criteria6.addCell(cell77criteria6);
			table71criteria6.addCell(cell78criteria6);
			
			table71criteria6.setSpacingAfter(20f);
			table71criteria6.setSpacingBefore(20f);
			
			
			document.add(table71criteria6);
			
			

			PdfPTable table7criteria6 = new PdfPTable(1);
			table7criteria6.setWidthPercentage(100);
			
			
			PdfPCell cell00078criteria6 = new PdfPCell(new Paragraph(
					"6.3.2 Percentage of teachers provided with financial support to attend \r\n"
					+ "conferences/workshops and towards membership fee of professional \r\n"
					+ "bodies during the last five years.\r\n"
					 ,font4));
			
			cell00078criteria6.setExtraParagraphSpace(10f);
			
			table7criteria6.addCell(cell00078criteria6);
		
			
			

			if (criteria6Record.getCriteria63Qn() != null) {

				PdfPCell cell0001178criteria6 = new PdfPCell( new Paragraph(
						(criteria6Record != null ? criteria6Record.getCriteria63Qn().get(0).getResponse632()
								: ""),font4));
				cell0001178criteria6.setExtraParagraphSpace(10f);
				
				

				table7criteria6.addCell(cell0001178criteria6);
				
				

			}
			PdfPCell cell7y = new PdfPCell(new Paragraph(
					"6.3.2.1 Number of teachers provided with financial support to attend conferences/workshops and towards membership fee of professional bodies year wise during the last five years"
							+ "",
					font4));
			cell7y.setExtraParagraphSpace(10f);

			table7criteria6.addCell(cell7y);
			document.add(table7criteria6);

			if (criteria6Record.getYearTable6321().size()>0) {

				Table table6331criteria6 = new Table(criteria6Record.getYearTable6321().size() + 1, 2);

				table6331criteria6.setPadding(5);
				table6331criteria6.setWidth(100f);
				table6331criteria6.addCell("year");
				for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
					Cell cell1111=new Cell(new Paragraph(criteria6Record.getYearTable6331().get(i).getInput6331y(),font5));
					cell1111.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6331criteria6.addCell(cell1111);
				
				
				}
				table6331criteria6.addCell("number");
				for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
					Cell cell11110=new Cell(new Paragraph(criteria6Record.getYearTable6331().get(i).getInput6331v(),font5));
					cell11110.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6331criteria6.addCell(cell11110);
				
				}

				document.add(table6331criteria6);
			}

			if (criteria6Record.getYearTable6321().size()>0) {

				Table table6331criteria6 = new Table(criteria6Record.getYearTable6321().size() + 1, 2);

				table6331criteria6.setPadding(5);
				table6331criteria6.setWidth(100f);
				table6331criteria6.addCell("year");
				for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
					Cell cell111101=new Cell(new Paragraph(criteria6Record.getYearTable6331().get(i).getInput6331y(),font5));
					cell111101.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6331criteria6.addCell(cell111101);
					
				}
				table6331criteria6.addCell("number");
				for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
					Cell cell111103=new Cell(new Paragraph(criteria6Record.getYearTable6331().get(i).getInput6331v(),font5));
					cell111103.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6331criteria6.addCell(cell111103);
				
				}

	//			document.add(table6331criteria6);
			}

			table71criteria6.setSpacingAfter(10f);

			// create table 8

			PdfPTable table81criteria6 = new PdfPTable(2);
			table81criteria6.setWidthPercentage(100);
			PdfPCell cell81criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n", font4));
			cell81criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell81criteria6.setExtraParagraphSpace(10f);
			
			
			
			PdfPCell cell82criteria6 = new PdfPCell(new Paragraph("Document\r\n", font4));
			cell82criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell82criteria6.setExtraParagraphSpace(10f);
			
			PdfPCell cell83criteria6 = new PdfPCell(
					new Paragraph("Upload any additional information\r\n" + "centers\r\n",font5));
			cell83criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			cell83criteria6.setExtraParagraphSpace(10f);
			
			PdfPCell cell84criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
			cell84criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell84criteria6.setExtraParagraphSpace(10f);
			
			PdfPCell cell85criteria6 = new PdfPCell(new Paragraph(
					"Details of teachers provided with financial support to attend conferences, workshops etc. during the last five years\r\n",font5));
			cell85criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell86criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
			table71criteria6.setSpacingAfter(10f);
			cell86criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell86criteria6.setExtraParagraphSpace(10f);
			
			//			PdfPCell cell851criteria6 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n\r\n"));
//			PdfPCell cell862criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));

			table81criteria6.addCell(cell81criteria6);
			table81criteria6.addCell(cell82criteria6);
			table81criteria6.addCell(cell83criteria6);
			table81criteria6.addCell(cell84criteria6);
			table81criteria6.addCell(cell85criteria6);
			table81criteria6.addCell(cell86criteria6);
			
			
			table81criteria6.setSpacingAfter(20f);
			table81criteria6.setSpacingBefore(20f);
			document.add(table81criteria6);

//			table81criteria6.addCell(cell851criteria6);
//			table81criteria6.addCell(cell862criteria6);

			PdfPTable table8criteria6 = new PdfPTable(1);
			table8criteria6.setWidthPercentage(100);
			
			
			
			PdfPCell cell86criteria1116 = new PdfPCell(new Paragraph(
					"6.3.3: Percentage of teachers undergoing online/ face-to-face Faculty \r\n"
					+ "Development Programmes (FDP)/ Management Development \r\n"
					+ "Programs (MDP) during the last five years .\r\n" 
							+ "Response:"
							+ "\r\n",font4));
			cell86criteria1116.setExtraParagraphSpace(10);
			
			table8criteria6.addCell(cell86criteria1116);

			if (criteria6Record.getCriteria63Ql() != null) {

				PdfPCell cell86criteria1110006 = new PdfPCell( new Paragraph(
						criteria6Record != null ? criteria6Record.getCriteria63Ql().get(0).getResponse633()
								: ""));
				cell86criteria1110006.setExtraParagraphSpace(10f);
				table8criteria6.addCell(cell86criteria1110006);

			}
			PdfPCell cell8y = new PdfPCell(new Paragraph(
					"6.3.3.1 Total number of professional development /administrative training Programmes organized by the institution for teaching and non teaching staff year-wise during the last five years"
							+ "",
					font4));
			cell8y.setExtraParagraphSpace(10f);

			table8criteria6.addCell(cell8y);
			document.add(table8criteria6);
			// create year table 6331

			if (criteria6Record.getYearTable6331().size()>0) {

				Table table6331criteria6 = new Table(criteria6Record.getYearTable6331().size() + 1, 2);

				table6331criteria6.setPadding(5);
				table6331criteria6.setWidth(100f);
				table6331criteria6.addCell("year");
				for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
					Cell cell11111=new Cell(new Paragraph((criteria6Record.getYearTable6331().get(i).getInput6331y()),font4));
					cell11111.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6331criteria6.addCell(cell11111);
				
				}
				table6331criteria6.addCell("number");
				for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
					Cell cell11112=new Cell(new Paragraph((criteria6Record.getYearTable6331().get(i).getInput6331v()),font4));
			
					cell11112.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6331criteria6.addCell(cell11112);
				}

				document.add(table6331criteria6);
			}
			
			// cretae table 9

	
			PdfPTable table91criteria6 = new PdfPTable(2);
			table91criteria6.setWidthPercentage(100);
			
			PdfPCell cell91criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
			cell91criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell92criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell92criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell93criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell93criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell94criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
			cell94criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell94criteria6.setExtraParagraphSpace(10f);
			
			PdfPCell cell95criteria6 = new PdfPCell(
					new Paragraph("Minutes of the relevant bodies of the Institution\r\n",font5));
			cell95criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell96criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
			cell96criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell96criteria6.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell97criteria6 = new PdfPCell(new Paragraph(
					"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n",font5));
			cell97criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);	
			cell97criteria6.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell98criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
			cell98criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell98criteria6.setExtraParagraphSpace(10f);
			cell98criteria6.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell99criteria6 = new PdfPCell(new Paragraph(
					"List of teachers receiving grant and details of grant received (Data Template)\r\n",font5));
			cell99criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell10criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));

			cell10criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell10criteria6.setExtraParagraphSpace(10f);
			
			
			table91criteria6.addCell(cell91criteria6);
			table91criteria6.addCell(cell92criteria6);
			table91criteria6.addCell(cell93criteria6);
			table91criteria6.addCell(cell94criteria6);
			table91criteria6.addCell(cell95criteria6);
			table91criteria6.addCell(cell96criteria6);
			table91criteria6.addCell(cell97criteria6);
			table91criteria6.addCell(cell98criteria6);
			table91criteria6.addCell(cell99criteria6);
			table91criteria6.addCell(cell10criteria6);
			table91criteria6.setSpacingAfter(20f);
			table91criteria6.setSpacingBefore(20f);
			
			document.add(table91criteria6);
			
			
			
			PdfPTable table9criteria6 = new PdfPTable(1);
			table9criteria6.setWidthPercentage(100);
			
			PdfPCell cell10criteria1116 = new PdfPCell((new Paragraph(
					"6.3.4: The institution provides seed money to its teachers for research."  + "Response:"
							+ "\r\n",font4)));
			cell10criteria1116.setExtraParagraphSpace(10f);
		
			table9criteria6.addCell(cell10criteria1116);
			
			if (criteria6Record.getCriteria63Qn() != null) {

				PdfPCell cell10criteria11116 = new PdfPCell(new Paragraph(
						criteria6Record != null ? criteria6Record.getCriteria63Qn().get(0).getResponse634()
								: "",font4));
				cell10criteria11116.setExtraParagraphSpace(10f);
				
				table9criteria6.addCell(cell10criteria11116);

			}

			PdfPCell cell10criteria101116 = new PdfPCell( new Paragraph(
					"6.3.4.1: The amount of seed money provided by institution to its teachers for research year wise during last five years (INR in lakhs)"+ "\r\n",font4));
			cell10criteria101116.setExtraParagraphSpace(10f);
			table9criteria6.addCell(cell10criteria101116);
			
		//	document.add(table9criteria6);

			// create table 6341

			if (criteria6Record.getYearTable6341() != null) {

				Table table6341criteria6 = new Table(criteria6Record.getYearTable6341().size() + 1, 2);

				table6341criteria6.setPadding(5);
				table6341criteria6.setWidth(100f);
			//	table6341criteria6.addCell("year");
				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
					Cell cell11=new Cell(new Paragraph((criteria6Record.getYearTable6341().get(i).getInput6341y()),font5));
					cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6341criteria6.addCell(cell11);
				
				}
			//	table6341criteria6.addCell("number");
				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
					Cell cell21=new Cell(new Paragraph((criteria6Record.getYearTable6341().get(i).getInput6341v()),font5));
					cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6341criteria6.addCell(cell21);
				
				}

			//	document.add(table6341criteria6);
			}

			if (criteria6Record.getYearTable6341().size()>0) {

				Table table6341criteria6 = new Table(criteria6Record.getYearTable6341().size() + 1, 2);

				table6341criteria6.setPadding(5);
				table6341criteria6.setWidth(100f);
				table6341criteria6.addCell("year");
				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
					Cell cell221=new Cell(new Paragraph((criteria6Record.getYearTable6341().get(i).getInput6341y()),font5));
					cell221.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6341criteria6.addCell(cell221);
				
				}
				table6341criteria6.addCell("number");
				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
					Cell cell22221=new Cell(new Paragraph((criteria6Record.getYearTable6341().get(i).getInput6341v())));
					cell22221.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6341criteria6.addCell(cell22221);
				
				
				}

			//	document.add(table6341criteria6);
			}
			

			Paragraph paragraph12criteria67111 = new Paragraph("\r\n");
			document.add(paragraph12criteria67111);

			PdfPTable table911criteria6 = new PdfPTable(2);
			table911criteria6.setWidthPercentage(100);
			
			
			PdfPCell cell911criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
			cell911criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell921criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n",  font4));
			cell921criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell931criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell931criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell941criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
			cell941criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell941criteria6.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell951criteria6 = new PdfPCell(
					new Paragraph("Minutes of the relevant bodies of the Institution\r\n",font5));
			cell951criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell961criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
			cell961criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell961criteria6.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell971criteria6 = new PdfPCell(new Paragraph(
					"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n",font5));
			cell971criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell981criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
			cell981criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell981criteria6.setExtraParagraphSpace(10f);
			
			
			
			PdfPCell cell991criteria6 = new PdfPCell(new Paragraph(
					"List of teachers receiving grant and details of grant received (Data Template)\r\n",font5));
			cell991criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell101criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
			cell101criteria6.setExtraParagraphSpace(10f);
			cell101criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell101criteria6.setExtraParagraphSpace(10f);
			
			
			table911criteria6.addCell(cell911criteria6);
			table911criteria6.addCell(cell921criteria6);
			table911criteria6.addCell(cell931criteria6);
			table911criteria6.addCell(cell941criteria6);
			table911criteria6.addCell(cell951criteria6);
			table911criteria6.addCell(cell961criteria6);
			table911criteria6.addCell(cell971criteria6);
			table911criteria6.addCell(cell981criteria6);
			table911criteria6.addCell(cell991criteria6);
			table911criteria6.addCell(cell101criteria6);
			table911criteria6.setSpacingAfter(20f);
			table911criteria6.setSpacingBefore(20f);
	//		document.add(table911criteria6);

			// 6.4

			Paragraph paragraph13criteria6 = new Paragraph(
					"6.4	Financial Management and Resource Mobilization\r\n", font2);
			paragraph13criteria6.setSpacingAfter(3F);
			paragraph13criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph13criteria6);
			
			
			
			
			// create table10
			PdfPTable table10criteria6 = new PdfPTable(2);
			table10criteria6.setWidthPercentage(100);

			com.lowagie.text.Font fontTitle5criteria6 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			fontTitle5criteria6.setSize(10);

			PdfPTable table101criteria6 = new PdfPTable(1);
			table101criteria6.setWidthPercentage(100);

			PdfPCell cell10x = new PdfPCell(new Paragraph(
					"6.4.1Institutional strategies for mobilisation of funds other than salary and fees \r\n"
					+ "and the optimal utilisation of resources\r\n"
							+ "Response:"+ ""
							+ (criteria6Record != null
							? criteria6Record.getCriteria64Ql().get(0).getResponse641()
							: ""),
					font4));
			cell10x.setExtraParagraphSpace(10);
			
			
			
			table101criteria6.addCell(cell10x);

			PdfPCell cell1001criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
			cell1001criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell102criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell102criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell103criteria6 = new PdfPCell(
					new Paragraph("\r\n\r\nDetails of Funds / Grants received from government\r\n"
							+ "bodies during the last five years (Data Template)\r\n" + "", font5));
			cell103criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell104criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(13).getCriteria6FilePath() : ""), font5));
			cell104criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell104criteria6.setExtraParagraphSpace(10F);
			PdfPCell cell1031criteria6 = new PdfPCell(new Paragraph("Annual statements of accounts"));
			cell1031criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1042criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(14).getCriteria6FilePath() : ""), font5));
			cell1042criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1042criteria6.setExtraParagraphSpace(10F);
			
			table10criteria6.addCell(cell1001criteria6);
			table10criteria6.addCell(cell102criteria6);
			table10criteria6.addCell(cell103criteria6);
			table10criteria6.addCell(cell104criteria6);
			table10criteria6.addCell(cell1031criteria6);
			table10criteria6.addCell(cell1042criteria6);

			//table101criteria6.addCell(table10criteria6);
		
			document.add(table101criteria6);
			
			table10criteria6.setSpacingAfter(10f);
			table10criteria6.setSpacingBefore(10f);
			
			document.add(table10criteria6);
			
			// create table 11
			PdfPTable table1001criteria6 = new PdfPTable(1);
			table1001criteria6.setWidthPercentage(100);
			PdfPCell cell11x = new PdfPCell(new Paragraph(
					"6.4.2 Funds / Grants received from non-government bodies, individuals, philanthropists during the last five years (not covered in Criterion III and V) (INR in Lakhs)\r\n"
							 + "Response:"
							+ (criteria6Record != null
									? criteria6Record.getCriteria64Qn().get(0).getResponse642()
									: ""),
					font4));
			
			cell11x.setExtraParagraphSpace(10F);
			PdfPCell cell11y = new PdfPCell(new Paragraph(
					"6.4.2.1: Total Grants received from government and non-government bodies\r\n"
					+ "and philanthropists for development and maintenance of infrastructure (not \r\n"
					+ "covered under Criteria III and V) year-wise during the last five years (INR in \r\n"
					+ "Lakhs)"
							+ "",
					font4));
			cell11y.setExtraParagraphSpace(10);
			table1001criteria6.addCell(cell11x);
			table1001criteria6.addCell(cell11y);
			document.add(table1001criteria6);
			// create table 6421

			if (criteria6Record.getYearTable6421().size()>0) {

				Table table6421 = new Table(criteria6Record.getYearTable6421().size(), 2);

				table6421.setPadding(5);
				table6421.setWidth(100f);

				for (int i = 0; i < criteria6Record.getYearTable6421().size(); i++) {
					Cell cell100=new Cell(new Paragraph(criteria6Record.getYearTable6421().get(i).getInput6421y(),font5));
					cell100.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6421.addCell(cell100);
				
				}
				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
					Cell cell1001=new Cell(new Paragraph(criteria6Record.getYearTable6421().get(i).getInput6421v(),font5));
					cell1001.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6421.addCell(cell1001);
					
					
				}

				document.add(table6421);
			}

			PdfPTable table111criteria6 = new PdfPTable(2);
			table111criteria6.setWidthPercentage(100);
			
			
			PdfPCell cell111criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n\r\n", font4));
			cell111criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell112criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n\r\n", font4));
			cell112criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell113criteria6 = new PdfPCell(
					new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n\r\n",font5));
			cell113criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell114criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(15).getCriteria6FilePath() : ""),font5));
			cell114criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell114criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell115criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n",font5));
			cell115criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell116criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(16).getCriteria6FilePath() : ""),font5));
			cell116criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell116criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell117criteria6 = new PdfPCell(new Paragraph("Annual statements of accounts\r\n\r\n\r\n",font5));
			cell117criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell118criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(17).getCriteria6FilePath() : ""),font5));
			cell118criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell118criteria6.setExtraParagraphSpace(10);
			
			//			PdfPCell cell119criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell120criteria6 = new PdfPCell(new Paragraph(""));
			table111criteria6.addCell(cell111criteria6);
			table111criteria6.addCell(cell112criteria6);
			table111criteria6.addCell(cell113criteria6);
			table111criteria6.addCell(cell114criteria6);
			table111criteria6.addCell(cell115criteria6);
			table111criteria6.addCell(cell116criteria6);
			table111criteria6.addCell(cell117criteria6);
			table111criteria6.addCell(cell118criteria6);
//			table111criteria6.addCell(cell119criteria6);
//			table111criteria6.addCell(cell120criteria6);
			table111criteria6.setSpacingAfter(20);
			table111criteria6.setSpacingBefore(20);
			document.add(table111criteria6);
			// CREATE TABLE12
			PdfPTable table12criteria6 = new PdfPTable(1);
			table12criteria6.setWidthPercentage(100);
			PdfPTable table121x = new PdfPTable(1);
			table121x.setWidthPercentage(100);

			PdfPCell cell12Y = new PdfPCell(new Paragraph(
					"6.4.3  Institution regularly conducts internal and external financial audits\r\n"
							,
					font4));
			cell12Y.setExtraParagraphSpace(10F);
			table12criteria6.addCell(cell12Y);
			document.add(table12criteria6);
			PdfPCell cell121Y = new PdfPCell(new Paragraph(
					"6.4.3.1 Total Grants received from non-government bodies, individuals, Philanthropers year wise during\r\n"
							+ "the last five years (INR in Lakhs)" + "\r\n" + "",font4));
			cell121Y.setExtraParagraphSpace(10);
		//	table12criteria6.addCell(cell121Y);
		//.addCell(table12criteria6);
			document.add(table12criteria6);

			// create table 121
			PdfPTable table121criteria6 = new PdfPTable(2);
			PdfPTable table1211criteria6 = new PdfPTable(2);

			table121criteria6.setWidthPercentage(100);
			PdfPCell cell121criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
			cell121criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell122criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell122criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell123criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n",font5));
			cell123criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell124criteria6 = new PdfPCell(new Paragraph("",font5));
			cell124criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table121criteria6.addCell(cell121criteria6);
			table121criteria6.addCell(cell122criteria6);
			table121criteria6.addCell(cell123criteria6);
			table121criteria6.addCell(cell124criteria6);
			
			table121criteria6.setSpacingBefore(20f);
			table121criteria6.setSpacingAfter(20f);
			
			document.add(table121criteria6);
			
			
			PdfPCell cell121 = new PdfPCell(new Paragraph(
					"6.4.4 Institution conducts internal and external financial audits regularly\r\n" + " ", font4));
			//table12criteria6.addCell(cell121);
		///	table12criteria6.addCell(table121criteria6);
		//	document.add(table1211criteria6);

			// 6.5
			
			
			
			Paragraph paragraph14criteria6 = new Paragraph("6.5	Internal Quality Assurance System\r\n", font2);
			paragraph14criteria6.setSpacingAfter(3f);
			paragraph14criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph14criteria6);

			PdfPTable table1211criteria6111 = new PdfPTable(1);

			table1211criteria6111.setWidthPercentage(100);
			
			
			
			PdfPCell cell121111 = new PdfPCell(new Paragraph(new Paragraph(
					"6.5.1 Internal Quality Assurance Cell (IQAC)/ Internal Quality Assurance System\r\n"
					+ "(IQAS) has contributed significantly for institutionalizing the quality \r\n"
					+ "assurance strategies and processes, by constantly reviewing the teachinglearning process, structures & methodologies of operations and learning \r\n"
					+ "outcomes, at periodic intervals\r\n"
							+ "Response",font4)));
			
			cell121111.setExtraParagraphSpace(10F);
			table1211criteria6111.addCell(cell121111);

			if (criteria6Record.getCriteria65Ql() != null) {

				PdfPCell cell12111111 = new PdfPCell( new Paragraph(
						criteria6Record != null ? criteria6Record.getCriteria65Ql().get(0).getInput651t1()
								: "",font4));
				cell12111111.setExtraParagraphSpace(10F);
				table1211criteria6111.addCell(cell12111111);

			}
			
			
			document.add(table1211criteria6111);
			
			
			Paragraph paragraph14criteria651 = new Paragraph("\r\n");
			document.add(paragraph14criteria651);
			// create table 

			
			PdfPTable table131criteria6 = new PdfPTable(2);
			table131criteria6.setWidthPercentage(100);


			PdfPCell cell131criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell131criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell132criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell132criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell133criteria6 = new PdfPCell(
					new Paragraph("Upload e-copies of the accreditations and\r\n" + "certifications",font5));
			cell133criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell134criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
			cell134criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell134criteria6.setExtraParagraphSpace(10F);
			
			PdfPCell cell1331criteria6 = new PdfPCell(new Paragraph(
					"Upload details of Quality assurance initiatives of the\r\n" + "institution (Data Template)",font5));
			cell1331criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1341criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
			cell1341criteria6.setExtraParagraphSpace(10F);
			cell1341criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table131criteria6.addCell(cell131criteria6);
			table131criteria6.addCell(cell132criteria6);
			table131criteria6.addCell(cell133criteria6);
			table131criteria6.addCell(cell134criteria6);
			table131criteria6.addCell(cell1331criteria6);
			table131criteria6.addCell(cell1341criteria6);
			
			table131criteria6.setSpacingAfter(20F);
			table131criteria6.setSpacingBefore(20F);
			
			
			document.add(table131criteria6);
			
			

			PdfPTable table130criteria6 = new PdfPTable(1);
			table130criteria6.setWidthPercentage(100);
			
			
			PdfPCell cell1341criteria611 = new PdfPCell(new Paragraph(
					"6.5.2: Institution has adopted the following for Quality assurance: \r\n"
					+ "1. Academic and Administrative Audit (AAA) and follow up action taken\r\n"
					+ "2.Conferences, Seminars, Workshops on quality conducted \r\n"
					+ "3. Collaborative quality initiatives with other institution(s)\r\n"
					+ "4.Orientation programme on quality issues for teachers and students\r\n"
					+ "5. Participation in NIRF and other recognized ranking like Shanghai \r\n"
					+ "Ranking, QS Ranking Times Ranking etc "
					+ "6.Any other quality audit recognized by state, national or international \r\n"
					+ "agencies \r\n"
					+ "Options:\r\n"
					+ "A. Any 5 or more of the above \r\n"
					+ "B. Any4 of the above\r\n"
					+ "C. Any3 of the above \r\n"
					+ "D. Any2 of the above\r\n"
					+ "E. Any1of the above )"
							+ "",font4));
			
			cell1341criteria611.setExtraParagraphSpace(10F);
			table130criteria6.addCell(cell1341criteria611);

			if (criteria6Record.getCriteria65Ql() != null) {
				PdfPCell cell1341criteria00611 = new PdfPCell(new Paragraph(
						criteria6Record != null ? criteria6Record.getCriteria65Ql().get(0).getResponse652()
								: "",font4));
				
				cell1341criteria00611.setExtraParagraphSpace(10F);
				table130criteria6.addCell(cell1341criteria00611);
			}
			
			document.add(table130criteria6);
			
			Paragraph paragraph14criteria64 = new Paragraph("\r\n");
			document.add(paragraph14criteria64);

			PdfPTable table141criteria6 = new PdfPTable(2);
			table141criteria6.setWidthPercentage(100);
			PdfPCell cell141criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
			cell141criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell141criteria6.setExtraParagraphSpace(10f);
			
			PdfPCell cell142criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell142criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell142criteria6.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell143criteria6 = new PdfPCell(
					new Paragraph("Strategic Plan and deployment documents on the website\r\n",font5));
			cell143criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell143criteria6.setExtraParagraphSpace(10f);
			
			PdfPCell cell144criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
			cell144criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell144criteria6.setExtraParagraphSpace(10f);
			
			PdfPCell cell145criteria6 = new PdfPCell(new Paragraph("Upload any additional information\r\n",font5));
			cell145criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell146criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
			cell146criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell146criteria6.setExtraParagraphSpace(10f);
			
			table141criteria6.addCell(cell141criteria6);
			table141criteria6.addCell(cell142criteria6);
			table141criteria6.addCell(cell143criteria6);
			table141criteria6.addCell(cell144criteria6);
			table141criteria6.addCell(cell145criteria6);
			table141criteria6.addCell(cell146criteria6);
			
			
			table141criteria6.setSpacingAfter(20F);
			table141criteria6.setSpacingBefore(20F);
			
			document.add(table141criteria6);

			// create table 15

			PdfPTable table141criteria60000 = new PdfPTable(1);
			table141criteria60000.setWidthPercentage(100);
			
			
			PdfPCell cell146criteria006 = new PdfPCell(new Paragraph(
					"6.5.3	Incremental improvements made for the preceding five years with regard to \r\n"
					+ "quality (in case of first cycle NAAC A/A)",font4));
			cell146criteria006.setExtraParagraphSpace(10F);
			table141criteria60000.addCell(cell146criteria006);
			
			

			if (criteria6Record.getCriteria65Qn() != null) {
				PdfPCell cell146criteria0061 = new PdfPCell(new Paragraph(
						criteria6Record != null ? criteria6Record.getCriteria65Qn().get(0).getResponse653()
								: "",font4));
				cell146criteria006.setExtraParagraphSpace(10F);
				cell146criteria0061.setExtraParagraphSpace(10F);
				
				table141criteria60000.addCell(cell146criteria0061);

			}
			document.add(table141criteria60000);
			
			// cretae653
			PdfPTable table151criterion6 = new PdfPTable(2);
			table151criterion6.setWidthPercentage(100);
			PdfPCell cell151 = new PdfPCell(new Paragraph("FileDiscription\r\n", font4));
			cell151.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			
			PdfPCell cell152 = new PdfPCell(new Paragraph("Document\r\n", font4));
			cell152.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell153 = new PdfPCell(new Paragraph("Paste web link of Annual reports of Institution\r\n",font5));
			
			cell153.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell154 = new PdfPCell(
					new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "",font5));
			cell154.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell154.setExtraParagraphSpace(10F);
			
			PdfPCell cell155 = new PdfPCell(
					new Paragraph("Upload e-copies of the accreditations and certifications\r\n",font5));
			
			cell155.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell156 = new PdfPCell(
					new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "",font5));
			cell156.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell156.setExtraParagraphSpace(10F);
			
			PdfPCell cell157 = new PdfPCell(new Paragraph("Any additional information\r\n"));
			
			cell157.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell158 = new PdfPCell(
					new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "",font5));
			cell158.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell158.setExtraParagraphSpace(10F);
			PdfPCell cell159 = new PdfPCell(
					new Paragraph("Upload details of quality assurance initiatives of the institution\r\n",font5));
			cell159.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell160 = new PdfPCell(
					new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""));
			cell160.setExtraParagraphSpace(10F);
			cell160.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table151criterion6.addCell(cell151);
			table151criterion6.addCell(cell152);
			table151criterion6.addCell(cell153);
			table151criterion6.addCell(cell154);
			table151criterion6.addCell(cell155);
			table151criterion6.addCell(cell156);
			table151criterion6.addCell(cell157);
			table151criterion6.addCell(cell158);
			table151criterion6.addCell(cell159);
			table151criterion6.addCell(cell160);
			table151criterion6.setSpacingBefore(20f);
			table151criterion6.setSpacingAfter(20f);
			
			document.add(table151criterion6);
			

			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
