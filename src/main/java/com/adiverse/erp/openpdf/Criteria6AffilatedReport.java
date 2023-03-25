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
public class Criteria6AffilatedReport {

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
				reportPath = "Criteria6AffilatedReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

			// 6.1
			
			Paragraph paragraphcriteria06 = new Paragraph("Criterion 6 - Governance, Leadership and Management\r\n\r\n",
					font1);
			paragraphcriteria06.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraphcriteria06);
			
			
			Paragraph paragraph2criteria6 = new Paragraph("6.1	Institutional Vision and Leadership\r\n\r\n", font2);
			paragraph2criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph2criteria6);

			PdfPTable table611criteria6 = new PdfPTable(1);
			table611criteria6.setWidthPercentage(100);
			PdfPCell cell01criteria6 = new PdfPCell(new Paragraph(
					"6.1.1: The governance and leadership is in accordance with vision and mission of the institution and it is visible in various institutional practices such as decentralization and participation in the institutional governance.\r\n\r\n"
					+"Response: "
							+(criteria6Record != null ? criteria6Record.getCriteria61Ql().get(0).getResponse611()
									: "")+"\r\n\r\n",font4));
		//	cell1criteria6.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			table611criteria6.addCell(cell01criteria6);
			document.add(table611criteria6);

//			Paragraph paragraph30criteria6 = new Paragraph(
//					(criteria6Record != null ? criteria6Record.getCriteria61Ql().get(0).getResponse611()
//							: "")+"\r\n\r\n",
//					font5);

		//	document.add(paragraph30criteria6);

			// create a table 1
			PdfPTable table1criteria6 = new PdfPTable(2);
			table1criteria6.setWidthPercentage(100);
			PdfPTable table110criteria6 = new PdfPTable(1);
			table110criteria6.setWidthPercentage(100);
			PdfPCell cell1criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell1criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell1criteria6.setExtraParagraphSpace(10);
			PdfPCell cell2criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell2criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell2criteria6.setExtraParagraphSpace(10);
			PdfPCell cell3criteria6 = new PdfPCell(new Paragraph("\r\nUpload Any aditional information\r\n\r\n",font5));
			cell3criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell3criteria6.setExtraParagraphSpace(10);
			PdfPCell cell4criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell4criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell4criteria6.setExtraParagraphSpace(10);
			PdfPCell cell5criteria6 = new PdfPCell(new Paragraph("\r\nPaste link for Any aditional information\r\n\r\n",font5));
			cell5criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell5criteria6.setExtraParagraphSpace(10);
			PdfPCell cell6criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell6criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell6criteria6.setExtraParagraphSpace(10);
			table1criteria6.addCell(cell1criteria6);
			table1criteria6.addCell(cell2criteria6);
			table1criteria6.addCell(cell5criteria6);
			table1criteria6.addCell(cell6criteria6);
			table1criteria6.addCell(cell3criteria6);
			table1criteria6.addCell(cell4criteria6);
			table1criteria6.setSpacingAfter(20);
			table1criteria6.setSpacingBefore(20);

			document.add(table1criteria6);
			
			// 6.2 
			
			
			Paragraph paragraph11criteria6 = new Paragraph("6.2  Strategy Development and Deployment\r\n\r\n",font2);
			paragraph11criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph11criteria6);
	
			PdfPTable table3criteria6 = new PdfPTable(2);
			table3criteria6.setWidthPercentage(100);
			PdfPTable table31criteria6 = new PdfPTable(1);
			table31criteria6.setWidthPercentage(100);

			PdfPCell cell31criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell31criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell31criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell32criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell32criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell32criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell33criteria6 = new PdfPCell(
					new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell33criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell33criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell34criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(5).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
			cell34criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell34criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell35criteria6 = new PdfPCell(new Paragraph("\r\nStrategic Plan and deployment documents on the website"
					+ "\r\n\r\n",font5));
			cell35criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell35criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell36criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(6).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
			cell36criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell36criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell37criteria6 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
			cell37criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell37criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell38criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(7).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
			cell38criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell38criteria6.setExtraParagraphSpace(10);
			
			
			table3criteria6.addCell(cell31criteria6);
			table3criteria6.addCell(cell32criteria6);
			table3criteria6.addCell(cell33criteria6);

			table3criteria6.addCell(cell34criteria6);
			table3criteria6.addCell(cell35criteria6);

			table3criteria6.addCell(cell36criteria6);
			table3criteria6.addCell(cell37criteria6);

			table3criteria6.addCell(cell38criteria6);

		//	table31criteria6.addCell(cell34criteria6);
			

		//	table3criteria6.addCell(cell35criteria6);
		//	table3criteria6.addCell(cell36criteria6);

			PdfPCell cell312 = new PdfPCell(
					new Paragraph("6.2.1	The functioning of the institutional bodies is effective and efficient as visible from policies, administrative setup, appointment and service rules, procedures, deployment of institutional Strategicperspective/development plan etc\r\n\r\n" + ""
							+ "" + "Response: "
							+ (criteria6Record != null
							? criteria6Record.getCriteria62Ql().get(0).getResponse621()
							: "")+"\r\n\r\n",
							font4));
			
//			PdfPCell cell3120 = new PdfPCell(
//					new Paragraph((criteria6Record != null
//									? criteria6Record.getCriteria62Ql().get(0).getInput621t1()
//									: ""),
//							font5));
			
			table31criteria6.addCell(cell312);
//			table31criteria6.addCell(cell3120);



		//	table31criteria6.addCell(table3criteria6);
		//	table31criteria6.setSpacingAfter(20f);
			
			document.add(table31criteria6);
			table3criteria6.setSpacingBefore(20);
			table3criteria6.setSpacingAfter(20);
			document.add(table3criteria6);
			

	//create table 4
			PdfPTable table4criteria6 = new PdfPTable(2);
			table4criteria6.setWidthPercentage(100);
			PdfPTable table41criteria6 = new PdfPTable(1);
			table41criteria6.setWidthPercentage(100);

			PdfPCell cell41criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell41criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell41criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell42criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell42criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell42criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell43criteria6 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell43criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell43criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell44criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(8).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell44criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell44criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell45criteria6 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
			cell45criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell45criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell46criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(9).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
			cell46criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell46criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell47criteria6 = new PdfPCell(new Paragraph("\r\nLink to Organogram of the Institution webpage\r\n\r\n ",font5));
			cell47criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell47criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell48criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(10).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
			cell48criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell48criteria6.setExtraParagraphSpace(10);
			
			table4criteria6.addCell(cell41criteria6);
			table4criteria6.addCell(cell42criteria6);
			table4criteria6.addCell(cell43criteria6);
			table4criteria6.addCell(cell44criteria6);
			table4criteria6.addCell(cell45criteria6);
			table4criteria6.addCell(cell46criteria6);
			table4criteria6.addCell(cell47criteria6);
			table4criteria6.addCell(cell48criteria6);
			PdfPCell cell41x = new PdfPCell(new Paragraph(
					"6.2.2	Implementation of e-governance in areas of operation\r\n"
					+ "1. Administration \r\n"
					+ "2. Finance and Accounts \r\n"
					+ "3. Student Admission and Support \r\n"
					+ "4. Examination"
							+ "\r\n" + "\r\n" + "Response:"
							+ (criteria6Record != null
									? criteria6Record.getCriteria62Ql().get(0).getInput622t1()
									: "")+"\r\n\r\n",
					font4));
//			PdfPCell cell410 = new PdfPCell(new Paragraph(
//					(criteria6Record != null
//									? criteria6Record.getCriteria62Ql().get(0).getInput622t1()
//									: ""),
//					font5));
			
			
			table41criteria6.addCell(cell41x);
//			table41criteria6.addCell(cell410);
			

		//	table41criteria6.addCell(table4criteria6);
		//	table41criteria6.setSpacingAfter(20f);
			document.add(table41criteria6);
			
			table4criteria6.setSpacingAfter(20);
			table4criteria6.setSpacingBefore(20);
		//	document.add(table4criteria6);
			
	//create table5
			PdfPTable table5criteria6 = new PdfPTable(2);
			table5criteria6.setWidthPercentage(100);
			PdfPTable table51criteria6 = new PdfPTable(1);
			table51criteria6.setWidthPercentage(100);

			PdfPCell cell51criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell51criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell51criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell52criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell52criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell52criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell53criteria6 = new PdfPCell(new Paragraph("\r\nScreen shots of user interfaces\r\n\r\n",font5));
			cell53criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell53criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell54criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(11).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell54criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell54criteria6.setExtraParagraphSpace(10);
			
			//cell54criteria6.setBackgroundColor(Align:);
			PdfPCell cell55criteria6 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n",font5));
			cell55criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell55criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell56criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(12).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell56criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell56criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell57criteria6 = new PdfPCell(new Paragraph("\r\nERP (Enterprise Resource Planning) Document\r\n\r\n",font5));
			cell57criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell57criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell58criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(13).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell58criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell58criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell59criteria6 = new PdfPCell(new Paragraph("\r\nLink for additional information\r\n\r\n",font5));
			cell59criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell59criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell60criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(14).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
			cell60criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell60criteria6.setExtraParagraphSpace(10);
			
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
			
			document.add(table51criteria6);
			table5criteria6.setSpacingAfter(20);
			table5criteria6.setSpacingBefore(20);
			
			document.add(table5criteria6);

			// 6.3 
			Paragraph paragraph12criteria6 = new Paragraph("6.3 Faculty Empowerment Strategies\r\n\r\n", font2);
			paragraph12criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph12criteria6);
			
			
			PdfPTable table631criteria6 = new PdfPTable(1);
			table631criteria6.setWidthPercentage(100f);

			PdfPCell cell631criteria6 = new PdfPCell(new Paragraph(
					"6.3.1 The institution has effective welfare measures for teaching and non-teaching staff\r\n"
					+ "\r\n"
					+ "Response: "
					+(criteria6Record != null
					? criteria6Record.getCriteria63Ql().get(0).getResponse631()
					:"")+"\r\n\r\n",font4));
			table631criteria6.addCell(cell631criteria6);
			document.add(table631criteria6);
			
			
//			Paragraph paragraph14criteria6=new Paragraph(criteria6Record != null
//									? criteria6Record.getCriteria63Ql().get(0).getResponse631()
//									:"",font5);
//			document.add(paragraph14criteria6);

			
			
	// create table6
			PdfPTable table6criteria6 = new PdfPTable(2);
			table6criteria6.setWidthPercentage(100);
			PdfPTable table61criteria6 = new PdfPTable(1);
			table61criteria6.setWidthPercentage(100);

			PdfPCell cell61criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell61criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell61criteria6.setExtraParagraphSpace(10);	
			
				
			PdfPCell cell62criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell62criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell62criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell63criteria6 = new PdfPCell(new Paragraph("\r\nStrategic Plan and deployment documents on the website\r\n\r\n",font5));
			cell63criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell63criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell64criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell64criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell64criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell65criteria6 = new PdfPCell(new Paragraph("\r\nPaste Link for additional information\r\n\r\n",font5));
			cell65criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell65criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell66criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell66criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell66criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell67criteria6 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell67criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell67criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell68criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell68criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell68criteria6.setExtraParagraphSpace(10);
			
			table6criteria6.addCell(cell61criteria6);
			table6criteria6.addCell(cell62criteria6);
			table6criteria6.addCell(cell63criteria6);
			table6criteria6.addCell(cell64criteria6);
			table6criteria6.addCell(cell65criteria6);
			table6criteria6.addCell(cell66criteria6);
			table6criteria6.addCell(cell67criteria6);
			table6criteria6.addCell(cell68criteria6);
			table6criteria6.setSpacingAfter(20);
			table6criteria6.setSpacingBefore(20);
			document.add(table6criteria6);
			


			PdfPTable table632criteria6 = new PdfPTable(1);
			table632criteria6.setWidthPercentage(100f);

			PdfPCell cell632criteria6 = new PdfPCell(new Paragraph(
					"6.3.2 Average percentage of teachers provided with financial support to attend conferences / workshops and towards membership fee of professional bodies during the last five years.\r\n\r\n"
						 + "Response: "
							+(criteria6Record != null
							? criteria6Record.getCriteria63Qn().get(0).getResponse632()
							: "")+"\r\n\r\n",font4));
			
			table632criteria6.addCell(cell632criteria6);
			document.add(table632criteria6);
			
//			if(criteria6Record.getCriteria63Qn().size()>0)
//			{
//			Paragraph paragraph16criteria6=new Paragraph(criteria6Record != null
//									? criteria6Record.getCriteria63Qn().get(0).getResponse632()
//									: "");
//			
//			document.add(paragraph16criteria6);
//			}
			if(criteria6Record.getCriteria63Qn().size()>0)
			{
			PdfPCell cell70 = new PdfPCell(new Paragraph(
					 (criteria6Record != null
									? criteria6Record.getCriteria63Qn().get(0).getInput632t1()
									: ""),
					font3));
			document.add(cell70);
		}
			
//			PdfPTable table6321criteria6 = new PdfPTable(1);
//			table6321criteria6.setWidthPercentage(100f);

			Paragraph paragraph6321Lcriteria6=new Paragraph(
					"6.3.2.1 Number of teachers provided with financial support to attend conferences/workshops and towards membership fee of professional bodies year wise during the last five years"
						+"\r\n\r\n",
					font4);
			
			document.add(paragraph6321Lcriteria6);
		
			
			Paragraph paragraph116criteria6=new Paragraph("\r\n");
			document.add(paragraph116criteria6);
			
			if (criteria6Record.getYearTable6321().size()>0) {

				Table table6321criteria6 = new Table(criteria6Record.getYearTable6321().size(), 2);

				table6321criteria6.setPadding(5);
				table6321criteria6.setWidth(100f);
			//	table6321criteria6.addCell("year");
				for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
					Cell cell1criteria63210 = new Cell (criteria6Record.getYearTable6321().get(i).getInput6321y());
					cell1criteria63210.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6321criteria6.addCell(cell1criteria63210);
					
				}
		//		table6321criteria6.addCell("Number");
				for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
					Cell cell2criteria63210 = new Cell (criteria6Record.getYearTable6321().get(i).getInput6321v());
					cell2criteria63210.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6321criteria6.addCell(cell2criteria63210);
					
				}

				document.add(table6321criteria6);
			}
			
			
			
			Paragraph paragraph26criteria6=new Paragraph("\r\n");
			document.add(paragraph26criteria6);
			
			
			
//			table61criteria6.addCell(table6criteria6);
//			document.add(table61criteria6);

	//create a table7
			PdfPTable table7criteria6 = new PdfPTable(1);
			table7criteria6.setWidthPercentage(100);
			PdfPTable table71criteria6 = new PdfPTable(2);
			table71criteria6.setWidthPercentage(100);
			
			PdfPCell cell71criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell71criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell71criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell72criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell72criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell72criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell73criteria6 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell73criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell73criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell74criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell74criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell74criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell75criteria6 = new PdfPCell(new Paragraph("\r\nDetails of teachers provided with financial support to attend conference, workshops etc during the last five years\r\n\r\n",font5));
			cell75criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell75criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell76criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
			cell76criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell76criteria6.setExtraParagraphSpace(10);
			
			
			
			table71criteria6.addCell(cell71criteria6);
			table71criteria6.addCell(cell72criteria6);
			table71criteria6.addCell(cell73criteria6);
			table71criteria6.addCell(cell74criteria6);
			table71criteria6.addCell(cell75criteria6);
			table71criteria6.addCell(cell76criteria6);
			table71criteria6.setSpacingAfter(20);
			table71criteria6.setSpacingBefore(20);
			
			document.add(table71criteria6);
			
			
			
			PdfPTable table633criteria6 = new PdfPTable(1);
			table633criteria6.setWidthPercentage(100f);

			PdfPCell cell633criteria6 = new PdfPCell(new Paragraph(
					"6.3.3: Percentage of teaching and non-teaching staff participating in Faculty development Programmes (FDP), professional development administrative training programs during the last five years\r\n\r\n"
			+ "Response: "
			+(criteria6Record != null
			? criteria6Record.getCriteria63Ql().get(0).getResponse633()
			: "")+"\r\n\r\n",font4));
			
			table633criteria6.addCell(cell633criteria6);
			table633criteria6.setSpacingAfter(20);
			table633criteria6.setSpacingBefore(20);
			document.add(table633criteria6);
			
			
//			if(criteria6Record.getCriteria63Ql().size()>0)
//			{
//			Paragraph paragraph136criteria6=new Paragraph((criteria6Record != null
//									? criteria6Record.getCriteria63Ql().get(0).getResponse633()
//									: ""),
//					font5); 
//			document.add(paragraph136criteria6);
//			
//			}

			Paragraph paragraph146criteria6=new Paragraph(
					"6.3.3.1 Total number of teaching and non-teaching staff participating in Faculty development Programmes (FDP), professional development /administrative training programs during the last five years"
							+ ""+"\r\n",
					font4);
			document.add(paragraph146criteria6);
//			Paragraph paragraph156criteria6=new Paragraph("\r\n");
//			document.add(paragraph156criteria6);
			
			
			
			if (criteria6Record.getYearTable6331().size()>0) {

				Table table6331criteria6 = new Table(criteria6Record.getYearTable6331().size(), 2);

				table6331criteria6.setPadding(5);
				table6331criteria6.setWidth(100f);

				for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
					Cell cell1criteria63310 = new Cell (criteria6Record.getYearTable6331().get(i).getInput6331y());
					cell1criteria63310.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6331criteria6.addCell(cell1criteria63310);
					
				}
				for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
					Cell cell2criteria63310 = new Cell (criteria6Record.getYearTable6331().get(i).getInput6331v());
					cell2criteria63310.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6331criteria6.addCell(cell2criteria63310);
			
				}

				document.add(table6331criteria6);
			}
			
			
			Paragraph paragraph1406criteria6=new Paragraph(
					"6.3.3.2 Total number of teaching and non-teaching staff participating in Faculty development Programmes (FDP), professional development /administrative training programs during the last five years"
							+ ""+"\r\n",
					font4);
			document.add(paragraph1406criteria6);
			
			if (criteria6Record.getAffiliated_YearTable6332().size()>0) {

				Table table6332tb2criteria6 = new Table(criteria6Record.getAffiliated_YearTable6332().size(), 2);

				table6332tb2criteria6.setPadding(5);
				table6332tb2criteria6.setWidth(100f);

				for (int i = 0; i < criteria6Record.getAffiliated_YearTable6332().size(); i++) {
					Cell cell1criteria633101 = new Cell (criteria6Record.getAffiliated_YearTable6332().get(i).getInput6332y());
					cell1criteria633101.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6332tb2criteria6.addCell(cell1criteria633101);
					
				}
				for (int i = 0; i < criteria6Record.getAffiliated_YearTable6332().size(); i++) {
					Cell cell2criteria633101 = new Cell (criteria6Record.getAffiliated_YearTable6332().get(i).getInput6332v());
					cell2criteria633101.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6332tb2criteria6.addCell(cell2criteria633101);
					
				}

				document.add(table6332tb2criteria6);
			}
			
			
			

	//create table 8
			PdfPTable table8criteria6 = new PdfPTable(1);
			table8criteria6.setWidthPercentage(100);
			
			PdfPTable table81criteria6 = new PdfPTable(2);
			table81criteria6.setWidthPercentage(100);
			PdfPCell cell81criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell81criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell81criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell82criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell82criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell82criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell83criteria6 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell83criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell83criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell84criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell84criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell84criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell85criteria6 = new PdfPCell(new Paragraph("\r\nMinutes of the relevant bodies of the Institution\r\n\r\n",font5));
			cell85criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell85criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell86criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell86criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell86criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell87criteria6 = new PdfPCell(new Paragraph("\r\nBudget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n",font5));
			cell87criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell87criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell88criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell88criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell88criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell89criteria6 = new PdfPCell(new Paragraph("\r\nList of teachers receiving grant and details of grant received (Data Template)\r\n\r\n",font5));
			cell89criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell89criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell810criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell810criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell810criteria6.setExtraParagraphSpace(10);
			
			table81criteria6.addCell(cell81criteria6);
			table81criteria6.addCell(cell82criteria6);
			table81criteria6.addCell(cell83criteria6);
			table81criteria6.addCell(cell84criteria6);
			table81criteria6.addCell(cell85criteria6);
			table81criteria6.addCell(cell86criteria6);
			table81criteria6.addCell(cell87criteria6);
			table81criteria6.addCell(cell88criteria6);
			table81criteria6.addCell(cell89criteria6);
			table81criteria6.addCell(cell810criteria6);
			table81criteria6.setSpacingAfter(20);
			table81criteria6.setSpacingBefore(20);
			
		
			
           // 6.4
			
			Paragraph paragraph103criteria6 = new Paragraph("6.4 Financial Management and Resource Mobilization\r\n\r\n", font2);
			paragraph103criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph103criteria6);
	//create table10
			

			com.lowagie.text.Font fontTitle5criteria6 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			fontTitle5criteria6.setSize(10);

			PdfPTable table101criteria6 = new PdfPTable(1);
			table101criteria6.setWidthPercentage(100);

			PdfPCell cell10x = new PdfPCell(new Paragraph(
					"6.4.1	Institution has strategies for mobilization and optimal utilization of resources and funds from various sources (government/ nongovernment organizations) and it conducts financial audits regularly (internal and external)"
					+ ""+"\r\n\r\n"
			+"Response: "
			+ (criteria6Record != null
					? criteria6Record.getCriteria64Qn().get(0).getResponse642():"")+"\r\n\r\n", font4));
			table101criteria6.addCell(cell10x);
			document.add(table101criteria6);
			document.add(table81criteria6);


//			PdfPCell cell100= new PdfPCell(new Paragraph(criteria6Record != null? criteria6Record.getCriteria64Qn().get(0).getInput641t1():"", font3));
//			table101criteria6.addCell(cell100);
			
			PdfPTable table10criteria6 = new PdfPTable(2);
			table10criteria6.setWidthPercentage(100);
			

			PdfPCell cell101criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell101criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell101criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell102criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell102criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell102criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell103criteria6 = new PdfPCell(new Paragraph(" \r\nUpload Any additional information\r\n\r\n",font5));
			cell103criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell103criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell104criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell104criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell104criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell105criteria6 = new PdfPCell(new Paragraph("\r\nPaste link for additional information/r/n/r/n",font5));
			cell105criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell105criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell106criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell106criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell106criteria6.setExtraParagraphSpace(10);
			
			
			table10criteria6.addCell(cell101criteria6);
			table10criteria6.addCell(cell102criteria6);
			table10criteria6.addCell(cell103criteria6);
			table10criteria6.addCell(cell104criteria6);
			table10criteria6.addCell(cell105criteria6);
			table10criteria6.addCell(cell106criteria6);
			
//			table101criteria6.addCell(
//					"A: Internal financial audit: The college constitutes an internal committee for conducting verification of assets/capital equipment as well as financial audit. The committee checks financial reporting compliance with policies as well as compliance with respect to legal aspects including applicability of the trust/society. The internal audit also verifies the achievement of operational goals and objectives, safe guarding of assets, effective and efficient use of resources.\r\n"
//							+ "\r\n"
//							+ "Audit of assets and capital equipment are conducted through stock verification by the committee and based on shortages reported, if any, action for write-off is taken with the approval of the competent authority and such items are removed from the asset registers. Similar action is taken in respect of books/journals/documents.\r\n"
//							+ "\r\n"
//							+ "The internal audit committee, besides inspecting the books of account and records maintained by the finance department, evaluates internal control system, particularly, in respect of purchases, scholarships etc. The audit report is submitted to Principal/Chairman and subsequently Principal directs departments to take follow up action for closing the deficiencies and making changes in systems and procedures as called for.\r\n"
//							+ "\r\n"
//							+ "B: External financial audit: Mother Teresa arranges to conduct external financial audit every year by an external auditing agency named Haribabu and Associates, a registered financial auditing company, located in Hyderabad. The same auditing agency has been conducting external audit since the inception of our college, i.e.,2005. The auditors verify the financial statements and books of accounts to certify the truth and fairness of the financial position and operating system prevalent. The auditors employ internal check by verifying arithmetical accuracy of books of accounts, authentication and validation of transaction and also checking the proper distinction between capital and revenue nature of transactions. Except for transactions involving petty amounts, all other payments are made by way of issuing account payee cheques, demand drafts and using the fund transfer facility of banks such as NEFT/RTGS, to maintain transparency and to minimize errors may likely to occur due to cash transactions. This makes the job of our auditor simple and more easy. The audit observations submitted to the management by the audit company are examined carefully and corrective actions taken, if any, wherever required. At the end of every financial year, IT returns are filed to income tax department. These include, income and expenditure statements audited by a chartered accountant.\r\n"
//							+ "\r\n"
//							+ "All the audit reports have been found to be in order. However, prior to external audit an internal audit is conducted through a Chartered Accountant (CA). In case of any errors. identified by CA, they will be rectified by the internal accounts staff as per the suggestion by the CA. These minor errors, if and when crept in, due to any oversight by accounting personnel, is verified and rectified, resulting in strengthening of the financial accounting and budgetary control systems.\r\n"
//							+ " \r\n" + "");
		//	table101criteria6.addCell(table10criteria6);
			table10criteria6.setSpacingAfter(20);
			table10criteria6.setSpacingBefore(20);
		//	document.add(table10criteria6);
			
			
	//create table 11
//			PdfPTable table642criteria6 = new PdfPTable(1);
//			table642criteria6.setWidthPercentage(100);
//			PdfPCell cell11x = new PdfPCell(new Paragraph(
//					"6.4.2 Funds / Grants received from non-government bodies, individuals, philanthropists during the last five years (not covered in Criterion III and V) (INR in Lakhs)\r\n"
//							+ "\r\n" + "Response: "
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria64Qn().get(0).getResponse642()
//									: "")+"\r\n\r\n",
//					font4));
//			table642criteria6.addCell(cell11x);
//			document.add(table642criteria6);
//			
//			
////			PdfPTable table6421criteria6 = new PdfPTable(1);
////			table6421criteria6.setWidthPercentage(100);
//			
//			Paragraph paragraph6421criteria6 = new Paragraph(
//					"6.4.2.1 Total Grants received from non-government bodies, individuals, Philanthropers year-wise during the last five years (INR in Lakhs)"
//							+"\r\n\r\n",
//					font4);
//			document.add(paragraph6421criteria6);
//		//	table6421criteria6.addCell(paragraph6421criteria6);
//	//		document.add(table6421criteria6);
//	//create table 6421
//
//			if (criteria6Record.getYearTable6421().size()>0) {
//
//				Table table6421 = new Table(criteria6Record.getYearTable6421().size(), 2);
//
//				table6421.setPadding(5);
//				table6421.setWidth(100f);
//
//				for (int i = 0; i < criteria6Record.getYearTable6421().size(); i++) {
//					Cell cell1criteria64210 = new Cell (criteria6Record.getYearTable6421().get(i).getInput6421y());
//					cell1criteria64210.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table6421.addCell(cell1criteria64210);
//					
//				}
//				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
//					Cell cell2criteria64210 = new Cell (criteria6Record.getYearTable6421().get(i).getInput6421v());
//					cell2criteria64210.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table6421.addCell(cell2criteria64210);
//					
//				}
//
//				document.add(table6421);
//			}
//
//			PdfPTable table111criteria6 = new PdfPTable(2);
//			table111criteria6.setWidthPercentage(100);
//			
//			PdfPCell cell111criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
//			cell111criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell111criteria6.setExtraParagraphSpace(10);
//			
//			PdfPCell cell112criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//			cell112criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell112criteria6.setExtraParagraphSpace(10);
//			
//			PdfPCell cell113criteria6 = new PdfPCell(new Paragraph("\r\nDetails of Funds / Grants received from of the nongovernment bodies, individuals, Philanthropers during the last five years\r\n\r\n",font5));
//			cell113criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell113criteria6.setExtraParagraphSpace(10);
//			
//			PdfPCell cell114criteria6 = new PdfPCell(
//					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
//			cell114criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell114criteria6.setExtraParagraphSpace(10);
//			
//			PdfPCell cell115criteria6 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
//			cell115criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell115criteria6.setExtraParagraphSpace(10);
//			
//			PdfPCell cell116criteria6 = new PdfPCell(
//					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
//			cell116criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell116criteria6.setExtraParagraphSpace(10);
//			
//			PdfPCell cell117criteria6 = new PdfPCell(new Paragraph("\r\nAnnual statements of accounts\r\n\r\n",font5));
//			cell117criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell117criteria6.setExtraParagraphSpace(10);
//			
//			PdfPCell cell118criteria6 = new PdfPCell(
//					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
//			cell118criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell118criteria6.setExtraParagraphSpace(10);
//			
//			table111criteria6.addCell(cell111criteria6);
//			table111criteria6.addCell(cell112criteria6);
//			table111criteria6.addCell(cell113criteria6);
//			table111criteria6.addCell(cell114criteria6);
//			table111criteria6.addCell(cell115criteria6);
//			table111criteria6.addCell(cell116criteria6);
//			table111criteria6.addCell(cell117criteria6);
//			table111criteria6.addCell(cell118criteria6);
//			table111criteria6.setSpacingAfter(20);
//			table111criteria6.setSpacingBefore(20);
//			
//			document.add(table111criteria6);
//			
//			
//			
//	//CREATE TABLE12
//			PdfPTable table12criteria6 = new PdfPTable(1);
//			table12criteria6.setWidthPercentage(100);
//			PdfPTable table121x = new PdfPTable(1);
//			table121x.setWidthPercentage(100);
//
//			PdfPCell cell12Y = new PdfPCell(new Paragraph(
//					"6.4.3 Institutional strategies for mobilisation of funds and the optimal utilisation of resources."+"\r\n\r\n"+ "Response:\r\n"
//							+ "Resource Mobilization Policy and Procedures\r\n" 
//							+ "The policy of Mother Teresa with regard to mobilization of funds is as follows:\r\n" 
//							+ "Internal: Tuition fee, NBA fee, Training fee, transport fee and other miscellaneous fees collected from students.\r\n"
//						  + "External: "+"\r\n\r\n" ,
//					font4));
//			table12criteria6.addCell(cell12Y);
//			table12criteria6.setSpacingAfter(20);
//			table12criteria6.setSpacingBefore(20);
//			document.add(table12criteria6);
//			
////			table121x.addCell(
////					"Procedure: The accounts section of the college prepares, month-wise cash flow statements, at least two months in advance. The cash outflow statement is based on institutional budget estimates and additional inputs form departments for unanticipated major expenses, and contingency expenses. The cash inflow (income) statement is prepared based on the schedules for admissions, commencement of classes indicated in the Academic calendar, and examination time tables. The Accounts department notifies the fee payment schedules to students to align with cash requirements as per projected cash inflow statement. If there are indications of fee collection being short of estimates, vigorous efforts are made through academic department staff and fee counselor to increase the receipts. The gap between the actual income and the estimated expenses is bridged through loans from banks/non-bank financial institutions as per the policy guidelines.\r\n"
////							+ "\r\n"
////							+ "Periodically, a review of the adequacy of limits for term and operational loans sanctioned by banks is carried out by the college management and the Principal. If the sanctioned limits are found to be inadequate, the banks are approached for enhancement of the sanctioned limits, with proper justification.\r\n"
////							+ "");
//		//	table121x.addCell(table12criteria6);
//			document.add(table121x);
//
//	//create table 121
//			PdfPTable table121criteria6 = new PdfPTable(2);
//			table121criteria6.setWidthPercentage(100);
//			PdfPCell cell121criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
//			cell121criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell121criteria6.setExtraParagraphSpace(10);
//			
//			PdfPCell cell122criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//			cell122criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell122criteria6.setExtraParagraphSpace(10);
//			
//			PdfPCell cell123criteria6 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
//			cell123criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell123criteria6.setExtraParagraphSpace(10);
//			
//			PdfPCell cell124criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
//			cell124criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell124criteria6.setExtraParagraphSpace(10);
//			
//			PdfPCell cell125criteria6 = new PdfPCell(new Paragraph("\r\nPaste link for additional information \r\n\r\n",font5));
//			cell125criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell125criteria6.setExtraParagraphSpace(10);
//			
//			PdfPCell cell126criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
//			cell126criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell126criteria6.setExtraParagraphSpace(10);
//			
//			table121criteria6.addCell(cell121criteria6);
//			table121criteria6.addCell(cell122criteria6);
//			table121criteria6.addCell(cell123criteria6);
//			table121criteria6.addCell(cell124criteria6);
//			table121criteria6.addCell(cell125criteria6);
//			table121criteria6.addCell(cell126criteria6);
//			table121criteria6.setSpacingAfter(20);
//			table121criteria6.setSpacingBefore(20);
//			
//			
//			document.add(table121criteria6);

			
			// 6.5
			Paragraph paragraph104criteria6 = new Paragraph("6.5 Internal Quality Assurance System\r\n\r\n", font2);
			paragraph104criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph104criteria6);
	//cretae table 13
			PdfPTable table13criteria6 = new PdfPTable(1);
			table13criteria6.setWidthPercentage(100);

			PdfPTable table651criteria6 = new PdfPTable(1);
			table651criteria6.setWidthPercentage(100f);


			PdfPCell cell651criteria6 = new PdfPCell(new Paragraph(
					"6.5.1Internal Quality Assurance Cell (IQAC) has contributed significantly for institutionalizing the quality assurance strategies and processes. It reviews teaching learning process, structures & 	methodologies of operations and learning outcomes at periodic intervals and records the incremental improvement in various activities\r\n\r\n"
							 + "Response: "
							+(criteria6Record != null
							? criteria6Record.getCriteria65Qn().get(0).getResponse651():" " )+"\r\n\r\n",font4));
			
			table651criteria6.addCell(cell651criteria6);
			document.add(table651criteria6);
			

			
	//create table 2reforms
			PdfPTable table131criteria6 = new PdfPTable(2);
			table131criteria6.setWidthPercentage(100);

			PdfPTable table130criteria6 = new PdfPTable(1);
			table130criteria6.setWidthPercentage(100);

			PdfPCell cell131criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell131criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell131criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell132criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell132criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell132criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell133criteria6 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell133criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell133criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell134criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell134criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell134criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell135criteria6 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
			cell135criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell135criteria6.setExtraParagraphSpace(10);
			
			PdfPCell cell136criteria6 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell136criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell136criteria6.setExtraParagraphSpace(10);
			
			
			table131criteria6.addCell(cell131criteria6);
			table131criteria6.addCell(cell132criteria6);
			table131criteria6.addCell(cell133criteria6);
			table131criteria6.addCell(cell134criteria6);
			table131criteria6.addCell(cell135criteria6);
			table131criteria6.addCell(cell136criteria6);
			table131criteria6.setSpacingAfter(20);
			table131criteria6.setSpacingBefore(20);
			document.add(table131criteria6);

			
			PdfPTable table653criteria6 = new PdfPTable(1);
			table653criteria6.setWidthPercentage(100f);


			PdfPCell cell653criteria6 = new PdfPCell(new Paragraph(
					new Paragraph("6.5.2	Quality assurance initiatives of the institution include:\r\n"
							+ "1.	Regular meeting of Internal Quality Assurance Cell (IQAC); Feedback collected, analysed and used for improvements\r\n"
							+ "2.	Collaborative quality initiatives with other institution(s)\r\n"
							+ "3.	Participation in NIRF\r\n"
							+ "4.	Any other quality audit recognized by state, national or international agencies (ISO Certification\r\n\r\n"
							+ "Response: "
							+(criteria6Record != null
							? criteria6Record.getCriteria65Ql().get(0).getResponse652():"")+"\r\n\r\n",font4)));
			table653criteria6.addCell(cell653criteria6);
			table653criteria6.setSpacingAfter(20);
			table653criteria6.setSpacingBefore(20);
					document.add(table653criteria6);
					
					
//					Paragraph paragraph215criteria6 = new Paragraph(criteria6Record != null
//									? criteria6Record.getCriteria65Qn().get(0).getResponse653()
//									: "",font5);
					
//					document.add(paragraph215criteria6);
	// cretae653
			PdfPTable table151criterion6 = new PdfPTable(2);
			table151criterion6.setWidthPercentage(100);
			PdfPCell cell151 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell151.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell151.setExtraParagraphSpace(10);
		
			PdfPCell cell152 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell152.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell152.setExtraParagraphSpace(10);
			
			PdfPCell cell153 = new PdfPCell(new Paragraph("\r\nPaste web link of Annual reports of Institution\r\n\r\n",font5));
			cell153.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell153.setExtraParagraphSpace(10);
			
			PdfPCell cell154 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell154.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell154.setExtraParagraphSpace(10);
			
			PdfPCell cell155 = new PdfPCell(new Paragraph("\r\nUpload e-copies of the accreditations and certifications\r\n\r\n",font5));
			cell155.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell155.setExtraParagraphSpace(10);
			
			PdfPCell cell156 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell156.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell156.setExtraParagraphSpace(10);
			
			PdfPCell cell157 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell157.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell157.setExtraParagraphSpace(10);
		
			PdfPCell cell158 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell158.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell158.setExtraParagraphSpace(10);
			
			PdfPCell cell159 = new PdfPCell(new Paragraph("\r\nUpload details of quality assurance initiatives of the institution\r\n\r\n",font5));
			cell159.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell159.setExtraParagraphSpace(10);
			
			PdfPCell cell160 = new PdfPCell(
					new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
			cell160.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell160.setExtraParagraphSpace(10);
			

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
		    table151criterion6.setSpacingAfter(10f);
			document.add(table151criterion6);
			
			document.close();
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
