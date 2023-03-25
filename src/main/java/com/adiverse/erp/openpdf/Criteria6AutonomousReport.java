package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class Criteria6AutonomousReport {

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

//			Map<String, String> allParams = new HashMap<String, String>();
//			allParams.put("collegeId",criteria6Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear",criteria6Fieldinfo.getCriteriaId().getFinancialYear() );
//			allParams.put("typeofInstitution", criteria6Fieldinfo.getCriteriaId().getTypeofInstitution());
//			

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
				reportPath = "Criteria6AutonomousReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

			Paragraph paragraph1criteria6 = new Paragraph("Criterion 6 - Governance, Leadership and Management\r\n",
					font1);
			paragraph1criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			document.add(paragraph1criteria6);
			
			Paragraph paragraphlinecriteria6 = new Paragraph("___________________________________________________________________________");
			paragraphlinecriteria6.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraphlinecriteria6);

			// 6.1

			Paragraph paragraph2criteria6 = new Paragraph("6.1	Institutional Vision and Leadership\r\n", font2);
			paragraph2criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph2criteria6);

			// create a table 1
			PdfPTable table1criteria6 = new PdfPTable(2);
			table1criteria6.setWidthPercentage(100);
			PdfPTable table11 = new PdfPTable(1);
			table11.setWidthPercentage(100);
			PdfPCell cell1criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell1criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell2criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell2criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell3criteria6 = new PdfPCell(new Paragraph("Any aditional information", font5));
			cell3criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell4criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
			cell4criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1criteria6.addCell(cell1criteria6);
			table1criteria6.addCell(cell2criteria6);
			table1criteria6.addCell(cell3criteria6);
			table1criteria6.addCell(cell4criteria6);

			
			table1criteria6.setSpacingBefore(20f);
			table1criteria6.setSpacingAfter(20f);

			
			PdfPCell cell410criteria6 = new PdfPCell(new Paragraph(
					"6.1.1: The institutional governance and leadership are in accordance with \r\n"
					+ "the vision and mission of the Institution and it is visible in various \r\n"
					+ "institutional practices such as NEP implementation, sustained \r\n"
					+ "institutional growth, decentralization, participation in the \r\n"
					+ "institutional governance and in their short term and long term \r\n"
					+ "Institutional Perspective Plan. .\r\n\r\n",
					font4));

			PdfPCell cell4120criteria6 = new PdfPCell(new Paragraph("Response"+
					(criteria6Record != null ? criteria6Record.getCriteria61Ql().get(0).getResponse611() : "")+"\r\n\r\n", font5));

			table11.addCell(cell410criteria6);

			table11.addCell(cell4120criteria6);

			table11.setSpacingBefore(20f);
			table11.setSpacingAfter(20f);

			document.add(table11);
			document.add(table1criteria6);

//		
//			PdfPTable table1criteria611 = new PdfPTable(2);
//			table1criteria611.setWidthPercentage(100);
//			

			PdfPTable table2criteria6 = new PdfPTable(2);
			table2criteria6.setWidthPercentage(100);
			PdfPTable table21criteria6 = new PdfPTable(1);
			table21criteria6.setWidthPercentage(100);

			PdfPCell cell21criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell21criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell22criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell22criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell23criteria6 = new PdfPCell(new Paragraph("Any aditional information\r\n\r\n", font4));
			cell23criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell24criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")+"\r\n\r\n", font5));
			cell24criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell25criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n", font5));
			cell25criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell26criteria6 = new PdfPCell(new Paragraph());
			cell26criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell27criteria6 = new PdfPCell(
					new Paragraph("Link for strategic plan and deployment documents on the website\r\n\r\n", font5));
			cell27criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell28criteria6 = new PdfPCell(new Paragraph(""));
			cell28criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2criteria6.addCell(cell21criteria6);
			table2criteria6.addCell(cell22criteria6);
			table2criteria6.addCell(cell23criteria6);
			table2criteria6.addCell(cell24criteria6);
			table2criteria6.addCell(cell25criteria6);
			table2criteria6.addCell(cell26criteria6);
			table2criteria6.addCell(cell27criteria6);
			table2criteria6.addCell(cell28criteria6);

			PdfPCell cell2701criteria6 = new PdfPCell(new Paragraph(
					"6.1.2: The effective leadership is reflected in various institutional practices such as decentralization and participative management.\r\nResponse",
					font4));

			PdfPCell cell271criteria6 = new PdfPCell(new Paragraph(
					(criteria6Record != null ? criteria6Record.getCriteria61Ql().get(0).getResponse612() : ""), font5));

		//	table21criteria6.addCell(cell2701criteria6);
		//	table21criteria6.addCell(cell271criteria6);
			
			table21criteria6.setSpacingAfter(20f);
			table21criteria6.setSpacingBefore(20f);

			document.add(table21criteria6);
			document.add(table2criteria6);

			// 6.2

			Paragraph paragraph11criteria6 = new Paragraph("6.2 Strategy Development and Deployment\r\n\r\n", font2);
			paragraph11criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph11criteria6);
			// create a table 3
			PdfPTable table3criteria6 = new PdfPTable(2);
			table3criteria6.setWidthPercentage(100);
			PdfPTable table31criteria6 = new PdfPTable(1);
			table31criteria6.setWidthPercentage(100);

			PdfPCell cell31criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell31criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell32criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font5));
			cell32criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell33criteria6 = new PdfPCell(
					new Paragraph("Link for Strategic Plan and deployment documents on the website\r\n\r\n", font5));
			cell33criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell34criteria6 = new PdfPCell(new Paragraph(""));
			cell34criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell35criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n", font5));
			cell35criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell36criteria6 = new PdfPCell(new Paragraph(""));
			cell36criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria6.addCell(cell31criteria6);
			table3criteria6.addCell(cell32criteria6);
			table3criteria6.addCell(cell33criteria6);
			table31criteria6.addCell(cell34criteria6);
			table3criteria6.addCell(cell35criteria6);
			table3criteria6.addCell(cell36criteria6);

			PdfPCell cell312 = new PdfPCell(new Paragraph(
					"6.2.1	The institutional perspective plan is effectively deployed and \r\n"
					+ "functioning of the institutional bodies is effective and efficient as \r\n"
					+ "visible from policies, administrative setup, appointment, service \r\n"
					+ "rules, and procedures, etc\r\n\r\n" 
							+ "Response:"
							+ (criteria6Record != null ? criteria6Record.getCriteria62Ql().get(0).getResponse621()
												: "")+"\r\n\r\n",
					font4));
			table31criteria6.addCell(cell312);

//			table31criteria6.addCell(table3criteria6);
			table31criteria6.setSpacingAfter(20f);
			document.add(table31criteria6);
			document.add(table3criteria6);

			// create table 4
			PdfPTable table4criteria6 = new PdfPTable(2);
			table4criteria6.setWidthPercentage(100);
			PdfPTable table41criteria6 = new PdfPTable(1);
			table41criteria6.setWidthPercentage(100);

			PdfPCell cell41criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell41criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell42criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell42criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell43criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell43criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell44criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : ""),font5));  cell44criteria6.setExtraParagraphSpace(15f);
			cell44criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell45criteria6 = new PdfPCell(
					new Paragraph("Link to Organogram of the Institution webpage\r\n\r\n",font5));
			cell45criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell46criteria6 = new PdfPCell(new Paragraph(""));
			cell46criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell47criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n",font5));
			cell47criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell48criteria6 = new PdfPCell(new Paragraph(""));
			cell48criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4criteria6.addCell(cell41criteria6);
			table4criteria6.addCell(cell42criteria6);
			table4criteria6.addCell(cell43criteria6);
			table4criteria6.addCell(cell44criteria6);
			table4criteria6.addCell(cell45criteria6);
			table4criteria6.addCell(cell46criteria6);
			table4criteria6.addCell(cell47criteria6);
			table4criteria6.addCell(cell48criteria6);
			table4criteria6.setSpacingAfter(20f);
			table4criteria6.setSpacingBefore(20f);
			PdfPCell cell41x = new PdfPCell(new Paragraph(
					"6.2.2	Institution implements e-governance in its operations \r\n"
					+ "6.2.2.1 e-governance is implemented covering the following areas of \r\n"
					+ "operations:\r\n"
					+ "1. Administration including complaint management\r\n"
					+ "2. Finance and Accounts\r\n"
					+ "3. Student Admission and Support\r\n"
					+ "4. Examinations A. All of the above\r\n"
					+ "B. Any3 of the above\r\n"
					+ "C. Any2 of the above \r\n"
					+ "D. Any1 of the above\r\n"
					+ "E. None of the above "
					+ "Response:"
							+ (criteria6Record != null ? criteria6Record.getCriteria62Ql().get(0).getResponse622()
												: "")+"\r\n\r\n",
					font4));
			table41criteria6.addCell(cell41x);

//			table41criteria6.addCell(table4criteria6);
			table41criteria6.setSpacingAfter(20f);
			table41criteria6.setSpacingBefore(20f);

			document.add(table41criteria6);
			document.add(table4criteria6);

			// create table5
			PdfPTable table5criteria6 = new PdfPTable(2);
			table5criteria6.setWidthPercentage(100);
			PdfPTable table51criteria6 = new PdfPTable(1);
			table51criteria6.setWidthPercentage(100);

			PdfPCell cell51criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell51criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell52criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell52criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell53criteria6 = new PdfPCell(new Paragraph("Screen shots of user interfaces\r\n\r\n", font5));
			cell53criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell54criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(3).getCriteria6FilePath() : ""), font5));
			cell54criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell54criteria6.setBackgroundColor(Align:);
			PdfPCell cell55criteria6 = new PdfPCell(
					new Paragraph("Institutional data in prescribed format\r\n\r\n", font5));
			cell55criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell56criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(4).getCriteria6FilePath() : ""), font5));
			cell56criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell57criteria6 = new PdfPCell(
					new Paragraph("ERP (Enterprise Resource Planning) Document\r\n\r\n", font5));
			cell57criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell58criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(5).getCriteria6FilePath() : ""), font5));
			cell58criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell59criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n", font5));
			cell59criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell60criteria6 = new PdfPCell(new Paragraph(""));
			cell60criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5criteria6.addCell(cell51criteria6);
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
									+ "3.	Student Admission and Support\r\n" + "4.Examination\r\n" + "\r\n" + "",
							font4));
			//table51criteria6.addCell(cell51x);
			//table51criteria6.addCell("Response: A. All of the above\r\n\r\n");
			
			table51criteria6.setSpacingAfter(20f);
			table51criteria6.setSpacingBefore(20f);
			
//			table51criteria6.addCell(table5criteria6);
			document.add(table51criteria6);
			document.add(table5criteria6);

			// 6.3

			Paragraph paragraph12criteria6 = new Paragraph("6.3  Faculty Empowerment Strategies\r\n", font2);
			paragraph12criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph12criteria6);
			
			PdfPTable table6criteria61 = new PdfPTable(2);
			table6criteria61.setWidthPercentage(100);
			PdfPTable table61criteria61 = new PdfPTable(1);
			table61criteria61.setWidthPercentage(100);

			PdfPCell cell61criteria61 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell61criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell62criteria61 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell62criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell63criteria61 = new PdfPCell(
					new Paragraph("Strategic Plan and deployment documents on the website\r\n\r\n", font5));
			cell63criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell64criteria61 = new PdfPCell(
					new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
			cell64criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell65criteria61 = new PdfPCell(
					new Paragraph("Paste link for additional Information\n\r\n", font5));
			cell65criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell66criteria61 = new PdfPCell(
					new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
			cell66criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell65criteria611 = new PdfPCell(new Paragraph("Upload any additional information\n\r\n"));
			cell65criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell66criteria611 = new PdfPCell(
					new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
			cell66criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
			table6criteria61.addCell(cell61criteria61);
			table6criteria61.addCell(cell62criteria61);
			table6criteria61.addCell(cell63criteria61);
			table6criteria61.addCell(cell64criteria61);
			table6criteria61.addCell(cell65criteria61);
			table6criteria61.addCell(cell65criteria611);
			table6criteria61.addCell(cell66criteria611);

			table6criteria61.addCell(cell66criteria61);
//			table6criteria61.addCell(cell66criteria61);
			
			PdfPCell cell6611criteria611 = new PdfPCell(
					new Paragraph(
					"6.3.1: The institution has performance appraisal system, effective welfare \r\n"
					+ "measures for teaching and non-teaching staff and avenues for \r\n"
					+ "career development/progression \r\n\r\n",font4));
				
			table61criteria61.addCell(cell6611criteria611);
			
			table61criteria61.setSpacingAfter(20f);
			table61criteria61.setSpacingBefore(20f);
					
			document.add(table61criteria61);

			document.add(table6criteria61);

			// create table6
			PdfPTable table6criteria6 = new PdfPTable(2);
			table6criteria6.setWidthPercentage(100);
			PdfPTable table61criteria6 = new PdfPTable(1);
			table61criteria6.setWidthPercentage(100);

			PdfPCell cell61criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell61criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell62criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell62criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell63criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n", font5));
			cell63criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell64criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
			cell64criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell65criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n", font5));
			cell65criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell66criteria6 = new PdfPCell(
					new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "", font5));
			cell66criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table6criteria6.addCell(cell61criteria6);
			table6criteria6.addCell(cell62criteria6);
			table6criteria6.addCell(cell63criteria6);
			table6criteria6.addCell(cell64criteria6);
			table6criteria6.addCell(cell65criteria6);
			table6criteria6.addCell(cell66criteria6);

			table61criteria6.setSpacingAfter(20f);
			table61criteria6.setSpacingBefore(20f);
			
			document.add(table61criteria6);

			// create a table7
			PdfPTable table7criteria6 = new PdfPTable(2);
			table7criteria6.setWidthPercentage(100);
			PdfPTable table71criteria6 = new PdfPTable(1);
			table71criteria6.setWidthPercentage(100);
			PdfPCell cell71criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			
			PdfPCell cell72criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			PdfPCell cell73criteria6 = new PdfPCell(
					new Paragraph("Institutional data in prescribed format\r\n\r\n", font5));
			PdfPCell cell74criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
			PdfPCell cell75criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n", font5));
			PdfPCell cell76criteria6 = new PdfPCell(new Paragraph(""));
			table7criteria6.addCell(cell71criteria6);
			table7criteria6.addCell(cell72criteria6);
			table7criteria6.addCell(cell73criteria6);
			table7criteria6.addCell(cell74criteria6);
			table7criteria6.addCell(cell75criteria6);
			table7criteria6.addCell(cell76criteria6);

			PdfPCell cell741criteria6 = new PdfPCell(
					new Paragraph(
					"Percentage of teachers provided financial support to attend \r\n"
					+ "conferences/workshops and towards membership fee of professional \r\n"
					+ "bodies during the last five years"
							+ (criteria6Record != null ? criteria6Record.getCriteria63Qn().get(0).getResponse632()
												: "")+"\r\n\r\n"+"\r\n\r\n",font4));
			
			PdfPCell cell74111criteria6 = new PdfPCell(
					new Paragraph(
					"6.3.2.1 Number of teachers provided with financial support to attend \r\n"
					+ "conferences/workshops and towards membership fee of professional \r\n"
					+ "bodies year-wise during the last five years"
							+ "",font4));
	
			table71criteria6.addCell(cell741criteria6);
			table71criteria6.addCell(cell74111criteria6);
			
			document.add(table71criteria6);
			
			
			
			table7criteria6.setSpacingBefore(20f);
			table7criteria6.setSpacingAfter(20f);
			
			
			document.add(table7criteria6);
					
					
			if (criteria6Record.getYearTable6321() != null) {

				Table table6331criteria6 = new Table(criteria6Record.getYearTable6321().size(), 2);

				table6331criteria6.setPadding(5);
				table6331criteria6.setWidth(100f);

				for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
					
				Cell cell121criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6321().get(i).getInput6321y(),font5));
					
				cell121criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6331criteria6.addCell(cell121criteria6);
				}
				for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
					
					
					Cell cell1210criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6321().get(i).getInput6321v(),font5));
					cell1210criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6331criteria6.addCell(cell1210criteria6);
				}

				document.add(table6331criteria6);
			}

			table71criteria6.setSpacingAfter(10f);

			// create table 8
			PdfPTable table8criteria6 = new PdfPTable(1);
			table8criteria6.setWidthPercentage(100);
			PdfPTable table81criteria6 = new PdfPTable(2);
			table81criteria6.setWidthPercentage(100);
			PdfPCell cell81criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell81criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell82criteria6 = new PdfPCell(new Paragraph("Document\r\n\r", font4));
			cell82criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell83criteria6 = new PdfPCell(
					new Paragraph("Institutional data in prescribed format\r\n\r\n", font5));
			cell83criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell84criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
			cell84criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell85criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n", font5));
			cell85criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell86criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
			cell86criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table81criteria6.addCell(cell81criteria6);
			table81criteria6.addCell(cell82criteria6);
			table81criteria6.addCell(cell83criteria6);
			table81criteria6.addCell(cell84criteria6);
			table81criteria6.addCell(cell85criteria6);
			table81criteria6.addCell(cell86criteria6);
//
			PdfPCell cell8x = new PdfPCell(new Paragraph(
					"6.3.3 Percentage of teachers undergoing online/ face-to-face Faculty \r\n"
					+ "Development Programmes (FDPs)/ Management Development \r\n"
					+ "Programmes (MDPs) during the last five years\r\n"
							+ "\r\n\r\n" + ""
							+ (criteria6Record != null ? criteria6Record.getCriteria63Ql().get(0).getResponse633()
												: "")+"\r\n\r\n",
					font4));
//			PdfPCell cell21y = new PdfPCell(
//					new Paragraph("6.3.3: The institution provides seed money to its teachers for research."));
//			document.add(cell21y);
//			PdfPCell cell22y = new PdfPCell(new Paragraph((criteria6Record != null
//					? criteria6Record.getCriteria63Ql().get(0).getInput633t1()
//								: "")+"\r\n\r\n"));
//			document.add(cell22y);

			PdfPCell cell8y = new PdfPCell(new Paragraph(
					"6.3.3.1: 6.3.3.1: Total number of teachers who have undergone online/ faceto-face Faculty Development Programmes (FDP)/ Management \r\n"
					+ "Development Programs (MDP) during the last five years"
							+ ""+"\r\n\r\n",
					font4));

			// table8criteria6.addCell(cell8x);
			table8criteria6.addCell(cell8x);
			table8criteria6.addCell(cell8y);
			
			table8criteria6.setSpacingAfter(20f);
			table8criteria6.setSpacingBefore(20f);
		
//			document.add(cell8y);
			document.add(table8criteria6);
			document.add(table81criteria6);
			
			// create year table 6331
			if (criteria6Record != null) {

				Table table6331criteria6 = new Table(criteria6Record.getYearTable6331().size(), 2);

				table6331criteria6.setPadding(5);
				table6331criteria6.setWidth(100f);

				for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
					
					
					Cell cell121criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6331().get(i).getInput6331y(),font5));
					cell121criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6331criteria6.addCell(cell121criteria6);
				}
				for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
					
					Cell cell021criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6331().get(i).getInput6331v(),font5));
					cell021criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6331criteria6.addCell(cell021criteria6);
					
				}

			//	document.add(table6331criteria6);
			}
			
			// cretae table 9
			PdfPTable table9criteria6 = new PdfPTable(1);
			table9criteria6.setWidthPercentage(100);
			PdfPTable table91criteria6 = new PdfPTable(2);
			table91criteria6.setWidthPercentage(100);
			PdfPCell cell91criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell91criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell92criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell92criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell93criteria6 = new PdfPCell(
					new Paragraph("Institutional data in prescribed format\r\n\r\n",font5));
			cell93criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell94criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));  cell94criteria6.setExtraParagraphSpace(15f);
			cell94criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell95criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell95criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell96criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));  cell96criteria6.setExtraParagraphSpace(15f);
			cell96criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell97criteria6 = new PdfPCell(
					new Paragraph("Minutes of the relevant bodies of the Institution\r\n\r\n",font5));
			cell97criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell98criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));  cell98criteria6.setExtraParagraphSpace(15f);
			cell98criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell97criteria61 = new PdfPCell(new Paragraph(
					"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n",font5));
			cell97criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell98criteria61 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));  cell98criteria61.setExtraParagraphSpace(15f);
			cell98criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell97criteria611 = new PdfPCell(new Paragraph(
					"List of teachers receiving grant and details of grant received (Data Template)\r\n",font5));
			cell97criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell98criteria611 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));  cell98criteria611.setExtraParagraphSpace(15f);
			cell98criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
			table91criteria6.addCell(cell91criteria6);
			table91criteria6.addCell(cell92criteria6);
			table91criteria6.addCell(cell93criteria6);
			table91criteria6.addCell(cell94criteria6);
			table91criteria6.addCell(cell95criteria6);
			table91criteria6.addCell(cell96criteria6);
			table91criteria6.addCell(cell97criteria6);
			table91criteria6.addCell(cell98criteria6);
			table91criteria6.addCell(cell97criteria61);
			table91criteria6.addCell(cell98criteria61);
			table91criteria6.addCell(cell97criteria611);
			table91criteria6.addCell(cell98criteria611);

			PdfPCell cell9x = new PdfPCell(new Paragraph(
					"6.3.4 Average percentage of teachers undergoing online/ face-to-face Faculty Development Programmes (FDP)during the last five years (Professional Development Programmes, Orientation / Induction Programmes, Refresher Course, Short Term Course ).\r\n"
							+ "\r\n\r\n" + "Response:"
							+ (criteria6Record != null ? criteria6Record.getCriteria63Qn().get(0).getResponse634()
												: "")+"\r\n\r\n"+"\r\n\r\n",
					font4));
			
			PdfPCell cell9y = new PdfPCell(new Paragraph(
					"6.3.4.1 Total number of teachers attending professional development Programmes, viz., Orientation Programme, Refresher Course, Short Term Course, Faculty Development Programmes year wise during last five years"
							+ ""+"\r\n\r\n",
					font4));
		//	table9criteria6.addCell(cell9x);
	//		table9criteria6.addCell(cell9y);

			table9criteria6.setSpacingAfter(20f);
			table9criteria6.setSpacingBefore(20f);
			
			
			
			document.add(table9criteria6);
			document.add(table91criteria6);

//			Paragraph paragraph1criteria613 = new Paragraph(
//					"6.3.4: The institution provides seed money to its teachers for research.\r\n");
//			document.add(paragraph1criteria613);
////			Paragraph paragraph1criteria614= new Paragraph((criteria6Record != null
////					? criteria6Record.getCriteria63Qn().get(0).getin()
////								: "")+"\r\n\r\n");
////			document.add(paragraph1criteria614);
//
//			Paragraph paragraph1criteria615 = new Paragraph(
//					"6.3.4.1: The amount of seed money provided by institution to its teachers for research year wise during last five years (INR in lakhs)"
//							+ "",
//					font3);
//			document.add(paragraph1criteria615);

			// create table 6341
			if (criteria6Record != null) {

				Table table6341criteria6 = new Table(criteria6Record.getYearTable6341().size(), 2);

				table6341criteria6.setPadding(5);
				table6341criteria6.setWidth(100f);

				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
				
					Cell cell101criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6341().get(i).getInput6341y(),font5));
					cell101criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6341criteria6.addCell(cell101criteria6);
				}
				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
					Cell cell1010criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6341().get(i).getInput6341v(),font5));
					cell1010criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6341criteria6.addCell(cell1010criteria6);
				}

	//			document.add(table6341criteria6);
			}
	

			// 6.4

			Paragraph paragraph13criteria6 = new Paragraph(
					"6.4	Financial Management and Resource Mobilization\r\n\r\n", font2);
			paragraph13criteria6.setAlignment(Paragraph.ALIGN_LEFT);
			document.add(paragraph13criteria6);
			// create table10
			PdfPTable table10criteria6 = new PdfPTable(2);
			table10criteria6.setWidthPercentage(100);
			PdfPTable table101criteria6 = new PdfPTable(1);
			table101criteria6.setWidthPercentage(100);

			PdfPCell cell101criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell101criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell102criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell102criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell103criteria6 = new PdfPCell(
					new Paragraph("Strategic Plan and deployment documents on the website",font5));
			cell103criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell104criteria6 = new PdfPCell(
					new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));  cell104criteria6.setExtraParagraphSpace(15f);
			cell104criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell103criteria61 = new PdfPCell(new Paragraph("Paste link for additional Information",font5));
			cell103criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell104criteria61 = new PdfPCell(
					new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5)); cell104criteria61 .setExtraParagraphSpace(15f);
			cell98criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell103criteria611 = new PdfPCell(new Paragraph("Upload any additional information",font5));
			cell103criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell104criteria611 = new PdfPCell(
					new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));  cell104criteria611.setExtraParagraphSpace(15f);
			cell104criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10criteria6.addCell(cell101criteria6);
			table10criteria6.addCell(cell102criteria6);
			table10criteria6.addCell(cell103criteria6);
			table10criteria6.addCell(cell104criteria6);
			table10criteria6.addCell(cell103criteria61);
			table10criteria6.addCell(cell104criteria61);
			table10criteria6.addCell(cell103criteria611);
			table10criteria6.addCell(cell104criteria611);
//			table101criteria6.addCell(table10criteria6);
			
			
			PdfPCell cell10x = new PdfPCell(new Paragraph(
					"6.4.1	Institutional strategies for mobilisation of funds other than salary \r\n"
					+ "and fees and the optimal utilisation of resources" + "", font4));
			table101criteria6.addCell(cell10x);

			
			table101criteria6.setSpacingAfter(20f);
			table101criteria6.setSpacingBefore(20f);
			
			table10criteria6.setSpacingAfter(20f);
			table10criteria6.setSpacingBefore(20f);
			
			
			document.add(table101criteria6);
			document.add(table10criteria6);
			
			
			// create table 11

//			Paragraph paragraph13criteria624 = new Paragraph(
//					"6.4.2: Funds / Grants received from non-government bodies, individuals, philanthropists during the last five years (not covered in Criterion III and V) (INR in Lakhs)"
//							+ "\r\n");
//			document.add(paragraph13criteria624);
//			Paragraph paragraph13criteria625 = new Paragraph(
//					criteria6Record != null ? criteria6Record.getCriteria64Qn().get(0).getResponse642() : "");
//			document.add(paragraph13criteria625);

			PdfPTable table11criteria6 = new PdfPTable(1);
			table11criteria6.setWidthPercentage(100);
			PdfPCell cell11x = new PdfPCell(new Paragraph(
					"6.4.2 Funds / Grants received from government bodies, non-government \r\n"
					+ "bodies, and philanthropists during the last five years (not covered in \r\n"
					+ "Criterion III and V) " + ""
							+ (criteria6Record != null ? criteria6Record.getCriteria64Qn().get(0).getInput642t1() : ""),
					font4));
			PdfPCell cell11y = new PdfPCell(new Paragraph(
					"6.4.2.1 Total Grants received from non-government bodies, individuals, Philanthropers year-wise during the last five years (INR in Lakhs)"
							+ ""+"\r\n\r\n",
					font4));
			table11criteria6.addCell(cell11x);
			table11criteria6.addCell(cell11y);
			document.add(table11criteria6);
			// create table 6421

			if (criteria6Record.getYearTable6421() != null) {

				Table table6421 = new Table(criteria6Record.getYearTable6421().size(), 2);

				table6421.setPadding(5);
				table6421.setWidth(100f);

				for (int i = 0; i < criteria6Record.getYearTable6421().size(); i++) {
					
					Cell cell100criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6421().get(i).getInput6421y(),font5));
					
					cell100criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6421.addCell(cell100criteria6);
				}
				if (criteria6Record.getYearTable6341() != null) {
					for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
						
						Cell cell12criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6421().get(i).getInput6421v(),font5));
						cell12criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
						table6421.addCell(cell12criteria6);
						
					}
				} else {

					for (int i = 0; i < criteria6Record.getYearTable6421().size(); i++) {
						table6421.addCell("-");
					}
				}

				document.add(table6421);
			}

			PdfPTable table111criteria6 = new PdfPTable(2);
			table111criteria6.setWidthPercentage(100);
			PdfPCell cell111criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell111criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell112criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell112criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell113criteria6 = new PdfPCell(
					new Paragraph("Institutional data in prescribed format\r\n\r\n\r", font5));
			cell113criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell114criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
			cell114criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell115criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n", font5));
			cell115criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell116criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
			cell116criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell117criteria6 = new PdfPCell(new Paragraph("Annual statements of accounts\r\n\r\n", font5));
			cell117criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell118criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
			cell118criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell119criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n", font5));
			cell119criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell120criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
			cell120criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table111criteria6.addCell(cell111criteria6);
			table111criteria6.addCell(cell112criteria6);
			table111criteria6.addCell(cell113criteria6);
			table111criteria6.addCell(cell114criteria6);
			table111criteria6.addCell(cell115criteria6);
			table111criteria6.addCell(cell116criteria6);
			table111criteria6.addCell(cell117criteria6);
			table111criteria6.addCell(cell118criteria6);
			table111criteria6.addCell(cell119criteria6);
			table111criteria6.addCell(cell120criteria6);
			
			table111criteria6.setSpacingAfter(20f);
			table111criteria6.setSpacingBefore(20f);
			
			document.add(table111criteria6);
			// CREATE TABLE12
			PdfPTable table12criteria6 = new PdfPTable(1);
			table12criteria6.setWidthPercentage(100);
			PdfPTable table121x = new PdfPTable(1);
			table121x.setWidthPercentage(100);

			PdfPCell cell12Y = new PdfPCell(new Paragraph(
					"6.4.3 Institution conducts internal and external financial audits regularly\r\n\r\n",
					font4));
			table12criteria6.addCell(cell12Y);
			document.add(table12criteria6);
//			table121x.addCell(table12criteria6);
//			document.add(table121x);


			// create table 121

//			Paragraph paragraph13criteria626 = new Paragraph(
//					"6.4.3: Institutional strategies for mobilisation of funds and the optimal utilisation of resources"
//							+ "\r\n" + "Response:");
//			document.add(paragraph13criteria626);
//			Paragraph paragraph13criteria627 = new Paragraph(
//					criteria6Record != null ? criteria6Record.getCriteria64Ql().get(0).getResponse643() : "");
//			document.add(paragraph13criteria627);

			PdfPTable table121criteria6 = new PdfPTable(2);
			table121criteria6.setWidthPercentage(100);
			PdfPCell cell121criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell121criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell122criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell122criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell123criteria6 = new PdfPCell(
					new Paragraph("Strategic Plan and deployment documents on the website\r\n",font5));
			cell123criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell124criteria6 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));  cell124criteria6.setExtraParagraphSpace(15f);
			cell124criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell123criteria61 = new PdfPCell(new Paragraph("Paste link for additional Information\r\n",font5));
			cell123criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell124criteria61 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));  cell124criteria61.setExtraParagraphSpace(15f);
			cell124criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell123criteria611 = new PdfPCell(new Paragraph("Upload any additional information\r\n",font5));
			cell123criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell124criteria611 = new PdfPCell(
					new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5)); cell124criteria611 .setExtraParagraphSpace(15f);
			cell124criteria611.setExtraParagraphSpace(15f);
			cell124criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
			table121criteria6.addCell(cell121criteria6);
			table121criteria6.addCell(cell122criteria6);
			table121criteria6.addCell(cell123criteria6);
			table121criteria6.addCell(cell124criteria6);
			table121criteria6.addCell(cell123criteria61);
			table121criteria6.addCell(cell124criteria61);
			table121criteria6.addCell(cell123criteria611);
			table121criteria6.addCell(cell124criteria611);
			
			table121criteria6.setSpacingAfter(20f);
			table121criteria6.setSpacingBefore(20f);
			document.add(table121criteria6);

			// 6.5

			Paragraph paragraph14criteria6 = new Paragraph("6.5	Internal Quality Assurance System\r\n\r\n", font2);
			paragraph14criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph14criteria6);
			// cretae table 13
			PdfPTable table13criteria6 = new PdfPTable(1);
			table13criteria6.setWidthPercentage(100);
//
			PdfPCell cell13x = new PdfPCell(new Paragraph(
					"6.5.1 Internal Quality Assurance Cell (IQAC) has contributed significantly for institutionalizing the quality assurance strategies and processes visible in terms of � Incremental improvements made for the preceding five years with regard to quality (in case of first cycle) Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives (second and subsequent cycles)\r\n"
							+ "\r\n\r\n" + "Response"
							+ (criteria6Record != null ? criteria6Record.getCriteria65Qn().get(0).getResponse651()
												: "")+"\r\n\r\n"+"\r\n\r\n",
					font4));
			table13criteria6.addCell(cell13x);
			document.add(table13criteria6);
			// create table 2reforms
			PdfPTable table131criteria6 = new PdfPTable(2);
			table131criteria6.setWidthPercentage(100);

			PdfPTable table130criteria6 = new PdfPTable(1);
			table130criteria6.setWidthPercentage(100);

			PdfPCell cell131criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell131criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell132criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell132criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell133criteria6 = new PdfPCell(new Paragraph("Any additional information",font5));
			cell133criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell134criteria6 = new PdfPCell(
					new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));  cell134criteria6.setExtraParagraphSpace(15f);
			cell134criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell133criteria61 = new PdfPCell(new Paragraph("Any additional information",font5));
//			cell133criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell134criteria61 = new PdfPCell(
//					new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));  .setExtraParagraphSpace(15f);
//			cell134criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
			table131criteria6.addCell(cell131criteria6);
			table131criteria6.addCell(cell132criteria6);
			table131criteria6.addCell(cell133criteria6);
			table131criteria6.addCell(cell134criteria6);
//			table131criteria6.addCell(cell133criteria61);
//			table131criteria6.addCell(cell134criteria61);
//			table130criteria6.addCell(table131criteria6);
			table130criteria6.setSpacingAfter(20f);
			table130criteria6.setSpacingBefore(20f);
			
			
			document.add(table130criteria6);
			
			
			
			PdfPTable table14criteria6 = new PdfPTable(1);
			table14criteria6.setWidthPercentage(100);
			PdfPCell cell14x = new PdfPCell(new Paragraph(
					"6.5.2 The institution reviews its teaching learning process, structures & methodologies of operations and learning outcomes at periodic intervals through IQAC set up as per norms and recorded the incremental improvement in various activities ( For first cycle - Incremental improvements made for the preceding five years with regard to quality For second and subsequent cycles - Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives )\r\n"
							+ "\r\n\r\n" + "Response:"
							+ (criteria6Record != null ? criteria6Record.getCriteria65Ql().get(0).getResponse652()
												: "")+"\r\n\r\n"+"\r\n\r\n",
					font4));
			table14criteria6.addCell(cell14x);
			
			table14criteria6.setSpacingBefore(20f);
			table14criteria6.setSpacingAfter(20f);
			
			
			document.add(table14criteria6);
			// create a table 141
			PdfPTable table140criteria6 = new PdfPTable(1);
			table140criteria6.setWidthPercentage(100);

			document.add(table140criteria6);
			PdfPTable table141criteria6 = new PdfPTable(2);
			table141criteria6.setWidthPercentage(100);
			PdfPCell cell141criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell141criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell142criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell142criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell143criteria6 = new PdfPCell(
					new Paragraph("Strategic Plan and deployment documents on the website\r\n",font5));
			cell143criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell144criteria6 = new PdfPCell(
					new Paragraph((criteria6file != null ? criteria6file.get(17).getCriteria6FilePath() : ""),font5));  cell144criteria6.setExtraParagraphSpace(15f);
			cell144criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell143criteria622 = new PdfPCell(new Paragraph("Upload any additional information\r\n",font5));
			cell143criteria622.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell144criteria622 = new PdfPCell(
					new Paragraph((criteria6file != null ? criteria6file.get(17).getCriteria6FilePath() : ""),font5));  cell144criteria622.setExtraParagraphSpace(15f);
			cell144criteria622.setHorizontalAlignment(Element.ALIGN_CENTER);
			table141criteria6.addCell(cell141criteria6);
			table141criteria6.addCell(cell142criteria6);
			table141criteria6.addCell(cell143criteria6);
			table141criteria6.addCell(cell144criteria6);
			table141criteria6.addCell(cell143criteria622);
			table141criteria6.addCell(cell144criteria622);
			
			table141criteria6.setSpacingAfter(20f);
			table141criteria6.setSpacingBefore(20f);
			
			
			document.add(table141criteria6);

			// create table 15
			PdfPTable table15criterion6 = new PdfPTable(1);
			table15criterion6.setWidthPercentage(100);
			PdfPCell cell15x = new PdfPCell(
					new Paragraph("6.5.3	Quality assurance initiatives of the institution include: 1. Regular meeting of Internal Quality Assurance Cell (IQAC); \r\n"
							+ "quality improvement initiatives identified and implemented\r\n"
							+ "2. Academic and Administrative Audit (AAA) and follow-up \r\n"
							+ "action taken\r\n"
							+ "3. Collaborative quality initiatives with other institution(s)\r\n"
							+ "4. Participation in NIRF and other recognized rankings\r\n"
							+ "5. Any other quality audit recognized by state, national or \r\n"
							+ "international agencies  Options:\r\n"
							+ "A. Any 4 or more of the above\r\n"
							+ "B. Any 3 of the above\r\n"
							+ "C. Any 2 of the above"
							+ " D. Any 1 of the above\r\n"
							+ "E. None of the above\r\n" + "\r\n"
							
							+ (criteria6Record != null ? criteria6Record.getCriteria65Qn().get(0).getResponse653()
												: "")+"\r\n\r\n"+"\r\n\r\n",
							font4));
			table15criterion6.addCell(cell15x);
			document.add(table15criterion6);
			// cretae653
			PdfPTable table151criterion6 = new PdfPTable(2);
			table151criterion6.setWidthPercentage(100);
			PdfPCell cell151 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell151.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell152 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell152.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell153 = new PdfPCell(new Paragraph("Paste web link of Annual reports of Institution\r\n",font5));
			cell153.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell154 = new PdfPCell(
					new Paragraph(criteria6file != null ? criteria6file.get(1).getCriteria6FilePath() : "",font5));
			cell154.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell155 = new PdfPCell(
					new Paragraph("Upload e-copies of the accreditations and certifications\r\n",font5));
			cell155.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell156 = new PdfPCell(
					new Paragraph(criteria6file != null ? criteria6file.get(1).getCriteria6FilePath() : "",font5));
			cell156.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell157 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n",font5));
			cell157.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell158 = new PdfPCell(
					new Paragraph(criteria6file != null ? criteria6file.get(1).getCriteria6FilePath() : "",font5));
			cell158.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell159 = new PdfPCell(
					new Paragraph("Upload details of quality assurance initiatives of the institution\r\n",font5));
			cell159.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell160 = new PdfPCell(
					new Paragraph(criteria6file != null ? criteria6file.get(1).getCriteria6FilePath() : "",font5));
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
			table151criterion6.setSpacingBefore(10f);
			document.add(table151criterion6);
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
