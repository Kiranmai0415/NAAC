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

import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.Criteria3_FileUpload;
import com.adiverse.erp.service.Criteria3Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class Criteria3UniversityReport {

	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	
	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	


	@Autowired
	Criteria3Service service3;

	List<Criteria3_FieldInfo> criteria3List = null;
	Criteria3_FieldInfo criteria3Record = null;
	List<Criteria3_FileUpload> criteria3file = null;

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
//			allParams.put("collegeId",criteria3Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear", criteria3Fieldinfo.getCriteriaId().getFinancialYear());
//
//			allParams.put("typeofInstitution", criteria3Fieldinfo.getCriteriaId().getTypeofInstitution() );


			criteria3List = service3.getAllCriteria3Data( allParams);
			if (CollectionUtils.isNotEmpty(criteria3List)) {
				System.out.println("aaaa");
				criteria3Record = criteria3List.get(0);
				criteria3file = criteria3Record.getCriteria3FileUpload();
			} else {
				criteria3Record = new Criteria3_FieldInfo();
				criteria3file = new ArrayList<Criteria3_FileUpload>();
			}
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("mapperr==>"+mapper.writeValueAsString(criteria3Record));

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "Criteria3UniversityReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

			// 3.1
			
		Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
			
			
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph);
			
			
			Paragraph paragraph1criteria3 = new Paragraph("Criterion 3 - Research, Innovations and Extension\r\n",
					font2);
			paragraph1criteria3.setSpacingBefore(3f);
			paragraph1criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph1criteria3);
			
			Paragraph paragraph0001 = new Paragraph("__________________________________________________________________________");
	
			paragraph0001.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph0001);
			
			Paragraph paragraph2criteria3 = new Paragraph("3.1	Promotion of Research and Facilities"
					+ "\r\n"	+ "\r\n", font2);
			paragraph2criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			paragraph2criteria3.setSpacingBefore(2F);
			document.add(paragraph2criteria3);
			
	
			
			// create table1
			PdfPTable table1criteria3 = new PdfPTable(2);
			PdfPTable table13criteria31 = new PdfPTable(1);

			table1criteria3.setWidthPercentage(100f);
			table13criteria31.setWidthPercentage(100f);
			
			table1criteria3.setSpacingAfter(20f);
			table1criteria3.setSpacingBefore(20f);

			PdfPCell cell1criteria3 = new PdfPCell(new Paragraph("File Description\r\n", font4));
			cell1criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell2criteria3 = new PdfPCell(new Paragraph("Document\r\n", font4));
			cell2criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell3criteria3 = new PdfPCell(new Paragraph(
					"Minutes of the Governing Council/ Syndicate/Board of Management related to research promotion policy adoption\r\n",font5));
			cell3criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell4criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
			cell4criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4criteria3.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell5criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n",font5));
			cell5criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell6criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
			cell6criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6criteria3.setExtraParagraphSpace(10f);
			PdfPCell cell7criteria3 = new PdfPCell(
					new Paragraph("URL of Policy document on promotion of research uploaded on website\r\n",font5));
			cell7criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell8criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
			cell8criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell8criteria3.setExtraParagraphSpace(5f);
			
			table1criteria3.addCell(cell1criteria3);
			table1criteria3.addCell(cell2criteria3);
			table1criteria3.addCell(cell5criteria3);
			table1criteria3.addCell(cell6criteria3);
			table1criteria3.addCell(cell3criteria3);
			table1criteria3.addCell(cell4criteria3);
			
			table1criteria3.addCell(cell7criteria3);
			table1criteria3.addCell(cell8criteria3);

			PdfPCell cell311criteria3 = new PdfPCell(new Paragraph(
					"3.1.1	The institution's Research facilities are frequently updated and there is a well defined policy for promotion of research which is uploaded on the institutional website and implemented.\r\n"
							+ "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria31Ql().get(0).getResponse311()
									: ""),
					font4));
			
			cell311criteria3.setExtraParagraphSpace(5f);
			
			cell311criteria3.setExtraParagraphSpace(5f);
			table13criteria31.addCell(cell311criteria3);
			document.add(table13criteria31);
			
		//	table13criteria31.addCell(table1criteria3);


			document.add(table1criteria3);
			
	
			
			
			

			// create table 2////
			PdfPTable table1criteria003 = new PdfPTable(1);
			table1criteria003.setWidthPercentage(100f);
			
			
			PdfPCell cell311criteria03 = new PdfPCell(new Paragraph(
					"3.1.2 The institution provides seed money to its teachers for research (average per year, INR in Lakhs)\r\n"
							 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria31Qn().get(0).getResponse312()
									: ""),font4));
			
			cell311criteria03.setExtraParagraphSpace(5f);
			
			table1criteria003.addCell(cell311criteria03);
		
			PdfPCell cell311criteria003 = new PdfPCell(new Paragraph(
					"3.1.2.1 The amount of seed money provided by institution to its faculty year-wise during the last five years (INR in lakhs)",font4));

			cell311criteria003.setExtraParagraphSpace(10F);
			table1criteria003.addCell(cell311criteria003);
		
			document.add(table1criteria003);
			

			if (criteria3Record.getYearTable3121().size() >0) {
				Table table3121criteria3 = new Table(criteria3Record.getYearTable3121().size());

				table3121criteria3.setPadding(5);
				table3121criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3121().size(); i++) {
					Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3121().get(i).getInput3121y(),font5));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3121criteria3.addCell(cell2);
					

				}
				for (int i = 0; i < criteria3Record.getYearTable3121().size(); i++) {
					Cell cell21=new Cell(new Paragraph(criteria3Record.getYearTable3121().get(i).getInput3121v(),font5));
					cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3121criteria3.addCell(cell21);
					

				}

				document.add(table3121criteria3);
			}
		
			
			PdfPTable table2criteria3 = new PdfPTable(2);

			table2criteria3.setWidthPercentage(100f);

			PdfPCell cell21criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell21criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell22criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell22criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell23criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n",font5));
			cell23criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell24criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "",font5));
			cell24criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell24criteria3.setExtraParagraphSpace(10F);
//			
//			PdfPCell cell25criteria3 = new PdfPCell(
//					new Paragraph("Any additional information",font5));
//			cell25criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell26criteria3 = new PdfPCell(
//					new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "",font5));
//			cell26criteria3.setExtraParagraphSpace(10F);
//			cell26criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell27criteria3 = new PdfPCell(new Paragraph(
					"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n",font5));
			cell27criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell27criteria3.setExtraParagraphSpace(5f);
			PdfPCell cell28criteria3 = new PdfPCell(
					
					new Paragraph(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "",font5));
			
			cell28criteria3.setExtraParagraphSpace(5f);
			cell28criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell271criteria3 = new PdfPCell(new Paragraph(
					"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n",font5));
			cell271criteria3.setExtraParagraphSpace(5f);
			cell271criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell281criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "",font5));
			cell281criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell281criteria3.setExtraParagraphSpace(5f);
			
			
			table2criteria3.addCell(cell21criteria3);
			table2criteria3.addCell(cell22criteria3);
			table2criteria3.addCell(cell23criteria3);
			table2criteria3.addCell(cell24criteria3);
//			table2criteria3.addCell(cell25criteria3);
//			table2criteria3.addCell(cell26criteria3);
			table2criteria3.addCell(cell27criteria3);
			table2criteria3.addCell(cell28criteria3);
			table2criteria3.addCell(cell271criteria3);
			table2criteria3.addCell(cell281criteria3);
			
			
//			table23criteria31.setSpacingBefore(20f);
//			table23criteria31.setSpacingAfter(20f);
			
			
			table2criteria3.setSpacingBefore(20f);
			table2criteria3.setSpacingAfter(20f);

			document.add(table2criteria3);
			
			
			
			PdfPTable table23criteria31 = new PdfPTable(1);
			table23criteria31.setWidthPercentage(100f);
			
	
			PdfPCell cell271criteria003 = new PdfPCell(new Paragraph(
					"3.1.3 Percentage of teachers receiving national/ international \r\n"
					+ "fellowship/financial support by various agencies for advanced studies/ \r\n"
					+ "research during the last five years\r\n"
						 + "Response"
							+ (criteria3Record != null
							? criteria3Record.getCriteria31Qn().get(0).getResponse313()
							: ""),font4));
			cell271criteria003.setExtraParagraphSpace(5f);
			table23criteria31.addCell(cell271criteria003)	;
			

			
			PdfPCell cell271criteria0003 = new PdfPCell(new Paragraph(
					"3.1.3.1 Number of teachers who received national/ international \r\n"
					+ "fellowship/financial support from various agencies, for advanced studies / \r\n"
					+ "research; year-wise during the last five years "
							+ "\r\n\r\n",font4));
			
			cell271criteria0003.setExtraParagraphSpace(5f);
			
			table23criteria31.addCell(cell271criteria0003);
			
			
			document.add(table23criteria31);
			
			
			
            
			if (criteria3Record.getYearTable3131().size() > 0) {
				Table table3131criteria3 = new Table(criteria3Record.getYearTable3131().size(), 2);

				table3131criteria3.setPadding(5);
				table3131criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3131().size(); i++) {
					Cell cell21=new Cell(new Paragraph((criteria3Record.getYearTable3131().get(i).getInput3131y()),font5));
					cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3131criteria3.addCell(cell21);

				}
				for (int i = 0; i < criteria3Record.getYearTable3131().size(); i++) {
					Cell cell212=new Cell(new Paragraph(criteria3Record.getYearTable3131().get(i).getInput3131v(),font5));
					cell212.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3131criteria3.addCell(cell212);

				}

				document.add(table3131criteria3);
			}
			
			
			
			
			
			
			PdfPTable table23criteria031 = new PdfPTable(1);
			table23criteria031.setWidthPercentage(100f);
			
			
			PdfPCell cell271criteria00031 = new PdfPCell(new Paragraph("Total number of full time teachers during the last five years"
					+ criteria3Record != null
					? criteria3Record.getCriteria31Ql().get(0).getInput3131t1()
					: ""
			,font4));
			cell271criteria00031.setExtraParagraphSpace(5f);
			table23criteria031.addCell(cell271criteria00031);
			
		//	document.add(table23criteria031);
			
			
			
			PdfPTable table3criteria3 = new PdfPTable(2);
			PdfPTable table33criteria31 = new PdfPTable(1);

			table3criteria3.setWidthPercentage(100f);
			table33criteria31.setWidthPercentage(100f);

			PdfPCell cell31criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell31criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell32criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell32criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell33criteria3 = new PdfPCell(
					new Paragraph("Any additional information\r\n   ",font5));
			cell33criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell34criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "",font5));
			cell34criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell34criteria3.setExtraParagraphSpace(5f);
			
			
			PdfPCell cell35criteria3 = new PdfPCell(new Paragraph("e-copies of the award letters of the teachers",font5));
			cell35criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell36criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : "",font5));
			cell36criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell36criteria3.setExtraParagraphSpace(5f);
			
			PdfPCell cell33criteria32= new PdfPCell(
					new Paragraph("List of teachers and their international fellowship details (Data Template)\r\n   ",font5));
			cell33criteria32.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell34criteria32 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "",font5));
			cell34criteria32.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell34criteria32.setExtraParagraphSpace(5f);
			
			
			
			table3criteria3.addCell(cell31criteria3);
			table3criteria3.addCell(cell32criteria3);
			table3criteria3.addCell(cell33criteria3);
			table3criteria3.addCell(cell34criteria3);
			table3criteria3.addCell(cell35criteria3);
			table3criteria3.addCell(cell36criteria3);
			table3criteria3.addCell(cell33criteria32);
			table3criteria3.addCell(cell34criteria32);
			
        //   table33criteria31.addCell(table3criteria3);
			
           table3criteria3.setSpacingBefore(20f);
			table3criteria3.setSpacingAfter(20f);
		//	document.add(table3criteria3);
			
			
		
			
			
			PdfPTable table314criteria3 = new PdfPTable(2);
		
			table314criteria3.setWidthPercentage(100f);
		

			PdfPCell cell314criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n",  font4));
			cell314criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell324criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell324criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell334criteria3 = new PdfPCell(
					new Paragraph("Institutional data in prescribed format\r\n\r\n",font5));
			cell334criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell344criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : "",font5));

			cell344criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell344criteria3.setExtraParagraphSpace(5f);
			PdfPCell cell354criteria3 = new PdfPCell(new Paragraph("Any additional information",font5));
			cell354criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell364criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(9).getCriteria3FilePath() : "",font5));
			cell364criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell364criteria3.setExtraParagraphSpace(5f);
			
			table314criteria3.addCell(cell314criteria3);
			table314criteria3.addCell(cell324criteria3);
			table314criteria3.addCell(cell334criteria3);
			table314criteria3.addCell(cell344criteria3);
			table314criteria3.addCell(cell354criteria3);
			table314criteria3.addCell(cell364criteria3);
			
			table314criteria3.setSpacingBefore(20f);
			table314criteria3.setSpacingAfter(20f);
	//		document.add(table314criteria3);
			
			
			
			PdfPTable table3314criteria31 = new PdfPTable(1);
			table3314criteria31.setWidthPercentage(100f);
		
			PdfPCell cell3134criteria3 = new PdfPCell(new Paragraph(
					"3.1.4 Percentage of JRFs, SRFs among the enrolled PhD scholars in the \r\n"
					+ "institution during the last five years.\r\n"
					+ "Response:"
							+ (criteria3Record != null
							? criteria3Record.getCriteria31Qn().get(0).getResponse314()
							: ""),
					font4));
			cell3134criteria3.setExtraParagraphSpace(5f);
			
			
			PdfPCell cell31314criteria3 = new PdfPCell(new Paragraph(
					"3.1.4.1 The Number of JRFs, SRFs, Post Doctoral Fellows, Research Associates and other research\r\n\r\n"
					+ "fellows enrolled in the institution year-wise during the last five years."
							+ "\r\n"
							+ (criteria3Record != null
							? criteria3Record.getCriteria31Qn().get(0).getInput314t1()
							: ""),
							font4));
			
			cell31314criteria3.setExtraParagraphSpace(5f);
			table3314criteria31.addCell(cell3134criteria3);
			
			
			table3314criteria31.addCell(cell31314criteria3);
			
			
			PdfPCell cell31314criteria31 = new PdfPCell(new Paragraph(
					"3.1.4.1 Number of PhD Scholars enrolled during last five years"
							+ "\r\n"
							+ (criteria3Record != null
							? criteria3Record.getCriteria31Qn().get(0).getInput314t1()
							: ""),
							font4));
			
			cell31314criteria31.setExtraParagraphSpace(5f);
			table3314criteria31.addCell(cell31314criteria31);
			
			
			
			
			
			
			//table3314criteria31.addCell(table314criteria3);
			// document.add(cell313criteria3);
			// document.add(cell3131criteria3);
			
			document.add(table3314criteria31);
			
			
			
			
			
			
			
			PdfPTable table101criteria31 = new PdfPTable(1);
			table101criteria31.setWidthPercentage(100f);
			
			PdfPCell cell341criteria3 = new PdfPCell(new Paragraph(
					" 3.4.1 The Institution ensures implementation of its stated Code of Ethics for research through the following: 1. Inclusion of research ethics in the research methodology course work 2. Presence ofEthics committee 3. Plagiarism check through software 4. Research Advisory Committee\r\n"
						 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Ql().get(0).getResponse341()
									: ""),
							font4));
			cell341criteria3.setExtraParagraphSpace(10f);
			
			table101criteria31.addCell(cell341criteria3);
		
		//    document.add(table101criteria31);
		    

			if (criteria3Record.getUniversityYearTable3141().size() >0 ) {
				Table table3141criteria3 = new Table(criteria3Record.getUniversityYearTable3141().size(), 2);

				table3141criteria3.setPadding(5);
				table3141criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getUniversityYearTable3141().size(); i++) {
					Cell cell2=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3141().get(i).getInput3141y(),font5));
					
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3141criteria3.addCell(cell2);

				}
				for (int i = 0; i < criteria3Record.getUniversityYearTable3141().size(); i++) {
					Cell cell112=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3141().get(i).getInput3141v(),font5));
					cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3141criteria3.addCell(cell112);
					

				}

		//		document.add(table3141criteria3);
			}
			
			
			
			PdfPTable table315criteria3 = new PdfPTable(2);
			PdfPTable table3151criteria31 = new PdfPTable(1);

			table315criteria3.setWidthPercentage(100f);
			table3151criteria31.setWidthPercentage(100f);

			PdfPCell cell315criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell315criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell325criteria3 = new PdfPCell(new Paragraph("Document\r\n\r", font4));
			cell325criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell335criteria3 = new PdfPCell(
					new Paragraph("Institutional data in prescribed format\r\n",font5));
			cell335criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell345criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(10).getCriteria3FilePath() : "",font5));
			cell345criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell345criteria3.setExtraParagraphSpace(5f);
			
			PdfPCell cell355criteria3 = new PdfPCell(new Paragraph("Any additional information",font5));
			cell355criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell365criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(11).getCriteria3FilePath() : "",font5));
			cell365criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell365criteria3.setExtraParagraphSpace(5f);
			
			table315criteria3.addCell(cell315criteria3);
			table315criteria3.addCell(cell325criteria3);
			table315criteria3.addCell(cell335criteria3);
			table315criteria3.addCell(cell345criteria3);
			table315criteria3.addCell(cell355criteria3);
			table315criteria3.addCell(cell365criteria3);
			
			table315criteria3.setSpacingBefore(20f);
			table315criteria3.setSpacingAfter(20f);
			
	//		document.add(table315criteria3);
			
			
			PdfPCell cell31345criteria3 = new PdfPCell(new Paragraph(
					"3.1.5 Institution has the following facilities to support research\r\n"
					+ "1.Central Instrumentation Centre \r\n"
					+ "2.Animal House/Green House \r\n"
					+ "3. Museum\r\n"
					+ "4.Media laboratory/Studios\r\n"
					+ "5.Business Lab\r\n"
					+ "6.Research/Statistical Databases\r\n"
					+ "7.Mootcourt\r\n"
					+ "8.Theatre\r\n"
					+ "9.Art Gallery\r\n"
					+ "10.Any other facility to support research\r\n"
					+ "Response:"
							+ (criteria3Record != null
							? criteria3Record.getCriteria31Qn().get(0).getInput315t1()
							: ""),
							font4));
			
			cell31345criteria3.setExtraParagraphSpace(5f);
			
			table3151criteria31.addCell(cell31345criteria3);
			
		//	document.add(table3151criteria31);
			
		
		
		
		
			
			
			PdfPTable table316criteria3 = new PdfPTable(2);
			PdfPTable table3161criteria31 = new PdfPTable(1);

			table316criteria3.setWidthPercentage(100f);
			table3161criteria31.setWidthPercentage(100f);

			PdfPCell cell3156criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell3156criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell3256criteria3 = new PdfPCell(new Paragraph("Document\r\n\r", font4));
			cell3256criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell3356criteria3 = new PdfPCell(
					new Paragraph("Institutional data in prescribed format\r\n",font5));
			cell3356criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell3456criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(12).getCriteria3FilePath() : "",font5));
			cell3456criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3456criteria3.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell3556criteria3 = new PdfPCell(new Paragraph("Any additional information",font5));
			cell3556criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell3656criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(13).getCriteria3FilePath() : "",font5));
			cell3656criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3656criteria3.setExtraParagraphSpace(5f);
			
			table316criteria3.addCell(cell3156criteria3);
			table316criteria3.addCell(cell3256criteria3);
			table316criteria3.addCell(cell3356criteria3);
			table316criteria3.addCell(cell3456criteria3);
			table316criteria3.addCell(cell3556criteria3);
			table316criteria3.addCell(cell3656criteria3);
			
			
			table316criteria3.setSpacingAfter(20f);
			table316criteria3.setSpacingBefore(20f);
//			document.add(table316criteria3);
			
			
			PdfPCell cell313456criteria3 = new PdfPCell(new Paragraph(
					"3.1.6 Percentage of departments with UGC-SAP, CAS, DST-FIST, DBT, ICSSR and other\r\n"
					+ "recognitions by national and international agencies (Data for the latest completed academic year)\r\n"
					+ "Response: "
							+ (criteria3Record != null
							? criteria3Record.getCriteria31Qn().get(0).getResponse316()
							: ""),
					font4));
			cell313456criteria3.setExtraParagraphSpace(5f);
			
			PdfPCell cell3134566criteria3 = new PdfPCell(new Paragraph(
					"3.1.6.1 The Number of departments with UGC-SAP, CAS, DST-FIST , DBT, ICSSR and other\r\n"
					+ "similar recognitions by national and international agencies.\r\n"
					+ "Response: "
							+ (criteria3Record != null
							? criteria3Record.getCriteria36Ql().get(0).getInput361t1()
							: ""),
					font4));
			cell3134566criteria3.setExtraParagraphSpace(5f);
			
			PdfPCell cell3134566criteria31 = new PdfPCell(new Paragraph(
					"3.1.6.1: Total number of departments offering academic programmes"
					+ "Response: "
							+ (criteria3Record != null
							? criteria3Record.getCriteria36Ql().get(0).getInput361t2()
							: ""),
					font4));
			
			cell3134566criteria31.setExtraParagraphSpace(5f);
			
			table3161criteria31.addCell(cell313456criteria3);
			table3161criteria31.addCell(cell3134566criteria3);
			table3161criteria31.addCell(cell3134566criteria31);
		
		///	table3161criteria31.addCell(table316criteria3);
		
			table3161criteria31.setSpacingBefore(20f);
			table3161criteria31.setSpacingAfter(20f);
	//		document.add(table3161criteria31);
			
			// 3.2 
			Paragraph paragraph3criteria3 = new Paragraph("3.2	Resource Mobilization for Research\r\n\r\n", font2);
			paragraph3criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph3criteria3);
			
			
			
			
			
			PdfPTable table003161criteria31 = new PdfPTable(1);
			table003161criteria31.setWidthPercentage(100f);
			
			

			/// create table 4//
			PdfPCell cell003134566criteria31 = new PdfPCell(new Paragraph("3.2.1:Research funding received by the institution and its faculties through \r\n"
					+ "Government and non-government sources such as industry, corporate \r\n"
					+ "houses, international bodies for research project, Endowment Research \r\n"
					+ "Chairs during the last five years (INR in Lakhs).\r\n",font4));
			
			cell003134566criteria31.setExtraParagraphSpace(5F);
			table003161criteria31.addCell(cell003134566criteria31);
			
			
			
			
			PdfPCell cell321criteria3 = new PdfPCell(new Paragraph(""
					+ "Response"
							+ (criteria3Record != null
									? criteria3Record.getCriteria32Ql().get(0).getResponse321()
									: ""),
							font4));
			cell321criteria3.setExtraParagraphSpace(5f);
			
			table003161criteria31.addCell(cell321criteria3);
			
			PdfPCell cell3211criteria3 = new PdfPCell(new Paragraph(
					"3.2.1.1 Total Grants from Government and non-governmental agencies for research projects , endowments, Chairs in the institution during the last five years (INR in Lakhs)"
							+ "\r\n"
							+ (criteria3Record != null
							? criteria3Record.getCriteria32Ql().get(0).getInput321t1()
							: ""),font4));
			table003161criteria31.addCell(cell3211criteria3);
			
			
			document.add(table003161criteria31);
			

			if (criteria3Record.getYearTable3221().size() >0 ) 
			{
				Table table3211criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);

				table3211criteria3.setPadding(5);
				table3211criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
					Cell cell2111=new Cell(new Paragraph((criteria3Record.getYearTable3221().get(i).getInput3221y()),font5));
					cell2111.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3211criteria3.addCell(cell2111);
					

				}
				for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
					Cell cell2111=new Cell(new Paragraph((criteria3Record.getYearTable3221().get(i).getInput3221v()),font5));
					cell2111.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3211criteria3.addCell(cell2111);

				}

				document.add(table3211criteria3);
			}
			PdfPTable table4criteria3 = new PdfPTable(2);
			PdfPTable table43criteria31 = new PdfPTable(1);

			table4criteria3.setWidthPercentage(100f);
			table43criteria31.setWidthPercentage(100f);
			
			PdfPCell cell41criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell41criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell42criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell42criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell43criteria3 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n",font5));
			cell43criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell44criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(14).getCriteria3FilePath() : "",font5));
			cell44criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell44criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell45criteria3 = new PdfPCell(new Paragraph(
					"e-copies of the grant award letters for research projects sponsored by government and non- government\r\n\r\n",font5));
			cell45criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell46criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : "",font5));
			cell46criteria3.setExtraParagraphSpace(10f);
			cell46criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell47criteria3 = new PdfPCell(new Paragraph("Provide the List of project and grant details (Data Template as of 3.1.6)\r\n",font5));
			
			cell47criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell48criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(9).getCriteria3FilePath() : "",font5));
			cell48criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell48criteria3.setExtraParagraphSpace(10F);
//			table43criteria31.addCell(cell321criteria3);
//			table43criteria31.addCell(cell3211criteria3);

			table4criteria3.addCell(cell41criteria3);
			table4criteria3.addCell(cell42criteria3);
			table4criteria3.addCell(cell43criteria3);
			table4criteria3.addCell(cell44criteria3);
			table4criteria3.addCell(cell45criteria3);
			table4criteria3.addCell(cell46criteria3);
			table4criteria3.addCell(cell47criteria3);
			table4criteria3.addCell(cell48criteria3);

		//	table43criteria31.addCell(table4criteria3);

			table4criteria3.setSpacingBefore(20f);
			table4criteria3.setSpacingAfter(20f);

	//		document.add(table43criteria31);
			
			document.add(table4criteria3);
			
			// create table 3211/////


			// create table 5 //////
			
			PdfPCell cell322criteria3 = new PdfPCell(
					new Paragraph("3.2.2 Number of research projects per teacher funded by government, nongovernment , industry, corporate houses, international bodies during \r\n"
							+ "the last five years"
							+ "Response\r\n"
							+ (criteria3Record != null
									? criteria3Record.getCriteria32Qn().get(0).getResponse322()
									: ""),
							font4));
			cell322criteria3.setExtraParagraphSpace(10F);
			
			document.add(cell322criteria3);
			PdfPCell cell3221criteria3 = new PdfPCell(new Paragraph(
					"3.2.2.1 Number of research projects funded by government and nongovernment agencies during the last five years\r\n"
							+ (criteria3Record != null
							? criteria3Record.getCriteria32Qn().get(0).getInput3221t11()
							: ""),font4));
			cell3221criteria3.setExtraParagraphSpace(10F);
			
			document.add(cell3221criteria3);
			
			// create table 3221 //////

//			if (criteria3Record.getYearTable3221().size() >0 ) {
//				Table table3221criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);
//
//				table3221criteria3.setPadding(5);
//				table3221criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
//					table3221criteria3.addCell(criteria3Record.getYearTable3221().get(i).getInput3221y());
//
//				}
//				for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
//					table3221criteria3.addCell(criteria3Record.getYearTable3221().get(i).getInput3221v());
//
//				}
//
//				document.add(table3221criteria3);
////			}
			
			
			
			
			

			if (criteria3Record.getYearTable3221().size() >0 ) 
			{
				Table table3221criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);

				table3221criteria3.setPadding(5);
				table3221criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
					Cell cell2111=new Cell(new Paragraph((criteria3Record.getYearTable3221().get(i).getInput3221y()),font5));
					cell2111.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3221criteria3.addCell(cell2111);
					

				}
				for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
					Cell cell2111=new Cell(new Paragraph((criteria3Record.getYearTable3221().get(i).getInput3221v()),font5));
					cell2111.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3221criteria3.addCell(cell2111);

				}

		//		document.add(table3221criteria3);
			}		
			
			
			
			
			
			
			PdfPTable table5criteria3 = new PdfPTable(2);
			PdfPTable table53criteria31 = new PdfPTable(1);

			table5criteria3.setWidthPercentage(100f);
			table53criteria31.setWidthPercentage(100f);

			PdfPCell cell51criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
			cell51criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell52criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell52criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell53criteria3 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n",font5));
			cell53criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell54criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(15).getCriteria3FilePath() : "",font5));
			cell54criteria3.setExtraParagraphSpace(10f);
			cell54criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell55criteria3 = new PdfPCell(new Paragraph("\r\ne-copies of the grant award letters for research\r\n"
					+ "projects sponsored by government\r\n"
					+ "\r\n\r\n",font5));
			cell55criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell56criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(16).getCriteria3FilePath() : "",font5));
			cell56criteria3.setExtraParagraphSpace(10f);
			cell56criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			//			table53criteria31.addCell(cell322criteria3);
//			table53criteria31.addCell(cell3221criteria3);
			table5criteria3.addCell(cell51criteria3);
			table5criteria3.addCell(cell52criteria3);
			table5criteria3.addCell(cell53criteria3);
			table5criteria3.addCell(cell54criteria3);
			table5criteria3.addCell(cell55criteria3);
			table5criteria3.addCell(cell56criteria3);
			

		//	table53criteria31.addCell(table5criteria3);
			// document.add(cell322criteria3);
			// document.add(cell3221criteria3);
			table5criteria3.setSpacingBefore(20f);
			table5criteria3.setSpacingAfter(20f);

			document.add(table5criteria3);

			// create table 6////
			///////////////////////////////////----------------------------------->
			
			
			PdfPTable table053criteria31 = new PdfPTable(1);
			table053criteria31.setWidthPercentage(100f);
			
			
			
			PdfPCell cell056criteria3 = new PdfPCell(new Paragraph("3.2.3 Number of research projects per teacher funded by government and non-government agencies\r\n"
							+ "during the last five years\r\n"
							+ "Response:\r\n"
							+ (criteria3Record != null
									? criteria3Record.getCriteria32Qn().get(0).getResponse323()
									: ""),
							font4));
			cell056criteria3.setExtraParagraphSpace(10f);
			table053criteria31.addCell(cell056criteria3);
		
			
			
			PdfPCell cell0056criteria3 = new PdfPCell(new Paragraph(
					new Paragraph("3.2.3.1 Number of research projects funded by government and non-government agencies during the last five years.\r\n"
						 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria32Qn().get(0).getInput3231t1()
									: ""),
							font4)));
			
			cell0056criteria3.setExtraParagraphSpace(10f);
			table053criteria31.addCell(cell0056criteria3);
			

			
			PdfPCell cell000056criteria3 = new PdfPCell( new Paragraph(
					new Paragraph("3.2.3.2 Number of full time teachers worked in the institution year-wise during the last five years..\r\n"
						
							  + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria32Qn().get(0).getInput3231t2()
									: ""),
							font4)));
			
			cell000056criteria3.setExtraParagraphSpace(10f);
			
			table053criteria31.addCell(cell000056criteria3);
			
	//		document.add(table053criteria31);
			
			//3231
			if (criteria3Record.getUniversityYearTable3231( ) .size() >0 ) {
				Table table3231criteria3 = new Table(criteria3Record.getUniversityYearTable3231().size(), 2);
	
				table3231criteria3.setPadding(5);
				table3231criteria3.setWidth(100f);
	
				for (int i = 0; i < criteria3Record.getUniversityYearTable3231().size(); i++) {
					Cell cell4=new Cell(new Paragraph((criteria3Record.getUniversityYearTable3231().get(i).getInput3231y()),font5));
					cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3231criteria3.addCell(cell4);
	
				}
				for (int i = 0; i < criteria3Record.getUniversityYearTable3231().size(); i++) {
					Cell cell41=new Cell(new Paragraph((criteria3Record.getUniversityYearTable3231().get(i).getInput3231v()),font5));
					cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3231criteria3.addCell(cell41);
	
				}
	
			//	document.add(table3231criteria3);
			}
			// 3231
			
			
			PdfPCell cell3232criteria311 = new PdfPCell(
					new Paragraph("3.2.3.2 Number of full time teachers worked in the institution year-wise during the last five years..\r\n"
						
						 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria32Qn().get(0).getInput3232t1()
									: ""),
							font4));
			cell3232criteria311.setExtraParagraphSpace(10f);
		//	document.add(cell3232criteria311);
			
			if (criteria3Record.getUniversityYearTable3232().size() >0 ) {
				Table table3232criteria3 = new Table(criteria3Record.getUniversityYearTable3232().size(), 2);
	
				table3232criteria3.setPadding(5);
				table3232criteria3.setWidth(100f);
	
				for (int i = 0; i < criteria3Record.getUniversityYearTable3232().size(); i++) {
					Cell cell4=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3232().get(i).getInput3232y(),font5));
					cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3232criteria3.addCell(cell4);
	
					
	
				}
				for (int i = 0; i < criteria3Record.getUniversityYearTable3231().size(); i++) {
					Cell cell1114=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3232().get(i).getInput3232v(),font5));
					cell1114.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3232criteria3.addCell(cell1114);
					
	
				}
	
		//		document.add(table3232criteria3);
			}
			
			PdfPTable table6criteria3 = new PdfPTable(2);
			PdfPTable table63criteria31 = new PdfPTable(1);

			table6criteria3.setWidthPercentage(100f);
			table63criteria31.setWidthPercentage(100f);
			
			PdfPCell cell61criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell61criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell62criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell61criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell63criteria3 = new PdfPCell(
					new Paragraph("\r\nProvide the List of research projects and funding details (Data Templateas of 3.1.6)\r\n"));
			cell63criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell64criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(16).getCriteria3FilePath() : ""));
			cell64criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell64criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell65criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
			cell65criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell66criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(17).getCriteria3FilePath() : ""));
			cell66criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell66criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell67criteria3 = new PdfPCell(new Paragraph("Supporting document from the Funding Agency\r\n"));
			cell67criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell68criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(18).getCriteria3FilePath() : ""));
			cell68criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell68criteria3.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell69criteria3 = new PdfPCell(new Paragraph("Supporting document from the Funding Agency\r\n"));
			cell69criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell70criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
			cell70criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell70criteria3.setExtraParagraphSpace(10f);
			
			table6criteria3.addCell(cell61criteria3);
			table6criteria3.addCell(cell62criteria3);
			table6criteria3.addCell(cell63criteria3);
			table6criteria3.addCell(cell64criteria3);
			table6criteria3.addCell(cell65criteria3);
			table6criteria3.addCell(cell66criteria3);
			table6criteria3.addCell(cell67criteria3);
			table6criteria3.addCell(cell68criteria3);
			table6criteria3.addCell(cell69criteria3);
			
			table6criteria3.addCell(cell70criteria3);
			
			table6criteria3.setSpacingAfter(20f);
			table6criteria3.setSpacingBefore(20F);
		//	document.add(table6criteria3);
			
			
			// 3.3 
			
			Paragraph paragraph4criteria3 = new Paragraph("3.3	Innovation Ecosystem\r\n\r\n", font2);
			paragraph4criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph4criteria3);
			// create table 8 ///
			PdfPTable table8criteria3 = new PdfPTable(2);
			PdfPTable table81criteria31 = new PdfPTable(1);

			table8criteria3.setWidthPercentage(100f);
			table81criteria31.setWidthPercentage(100f);
			
			PdfPCell cell81criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
			cell81criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell82criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
			cell82criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell83criteria3 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n"));
			cell83criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell84criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(18).getCriteria3FilePath() : ""));
			cell84criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell84criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell85criteria3 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n"));
			cell85criteria3.setExtraParagraphSpace(10f);
			
			cell85criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell86criteria3 = new PdfPCell(new Paragraph(""));
			cell86criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table8criteria3.addCell(cell81criteria3);
			table8criteria3.addCell(cell82criteria3);
			table8criteria3.addCell(cell83criteria3);
			table8criteria3.addCell(cell84criteria3);
			table8criteria3.addCell(cell85criteria3);
			table8criteria3.addCell(cell86criteria3);
			PdfPCell cell331criteria3 = new PdfPCell(new Paragraph(
					"3.3.1	nstitution has created an ecosystem for innovations, Indian \r\n"
					+ "Knowledge System (IKS) including awareness about IPR, \r\n"
					+ "establishment of IPR cell, Incubation centre and other initiatives for \r\n"
					+ "the creation and transfer of technology/knowledge and the outcomes \r\n"
					+ "of the same are evident.\r\n"
						 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria33Ql().get(0).getInput331t1()
									: ""),
					font4));
			
			cell331criteria3.setExtraParagraphSpace(10F);
			table81criteria31.addCell(cell331criteria3);
	//		table81criteria31.addCell(table8criteria3);

			// document.add(cell331criteria3);

			table8criteria3.setSpacingBefore(20f);
			table8criteria3.setSpacingAfter(20f);

			document.add(table81criteria31);
			
			document.add(table8criteria3);
			/// create table 9 ////
			
			
			PdfPTable table081criteria31 = new PdfPTable(1);		
			table081criteria31.setWidthPercentage(100f);
			
			
			PdfPCell cell0331criteria3 = new PdfPCell(new Paragraph(
					"3.3.2 Number of awards received for research/innovations by the \r\n"
					+ "institution/teachers/research scholars/students during the last five \r\n"
					+ "years\r\n"
				
					+ "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria33Qn().get(0).getResponse332()
									: ""),font4));
			cell0331criteria3.setExtraParagraphSpace(10F);
			
			table081criteria31.addCell(cell0331criteria3);
			
			
			PdfPCell cell00331criteria3 = new PdfPCell(new Paragraph(
					"3.3.2.1 Total number of awards received for research/innovations by \r\n"
					+ "institution/teachers/research scholars/students during the last five years.\r\n"
					+ (criteria3Record != null
					? criteria3Record.getCriteria33Qn().get(0).getInput3321t11()
					: "")		+ "\r\n",font4));
			table081criteria31.addCell(cell00331criteria3);
			
			document.add(table081criteria31);
			
//			
			// create a table 3321 //

			if (criteria3Record.getYearTable3321() .size() >0 ) {
				Table table3321criteria3 = new Table(criteria3Record.getYearTable3321().size(), 2);

				table3321criteria3.setPadding(5);
				table3321criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3321().size(); i++) {
					Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3321().get(i).getInput3321y(),font5));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3321criteria3.addCell(cell2);

				}
				for (int i = 0; i < criteria3Record.getYearTable3321().size(); i++) {
					Cell cell21=new Cell(new Paragraph(criteria3Record.getYearTable3321().get(i).getInput3321v(),font5));
					cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3321criteria3.addCell(cell21);

				}

	//			document.add(table3321criteria3);
			}
			
			PdfPTable table9criteria3 = new PdfPTable(2);


			table9criteria3.setWidthPercentage(100f);
		
			PdfPCell cell91criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
			cell91criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell92criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
			cell92criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell93criteria3 = new PdfPCell(new Paragraph("\r\nReport of the event\r\n",font5));
			cell93criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell94criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
			cell94criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell94criteria3.setExtraParagraphSpace(10);
			
			PdfPCell cell95criteria3 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n",font5));
			cell95criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell96criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
			cell96criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell96criteria3.setExtraParagraphSpace(10);
			
			PdfPCell cell951criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell951criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell961criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
			cell961criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell961criteria3.setExtraParagraphSpace(10);
			
			table9criteria3.addCell(cell91criteria3);
			table9criteria3.addCell(cell92criteria3);
			table9criteria3.addCell(cell93criteria3);
			table9criteria3.addCell(cell94criteria3);
			table9criteria3.addCell(cell95criteria3);
			table9criteria3.addCell(cell96criteria3);
			table9criteria3.addCell(cell951criteria3);
			table9criteria3.addCell(cell961criteria3);
//			table91criteria31.addCell(cell332criteria3);
//			table91criteria31.addCell(cell3321criteria3);
		
			
			table9criteria3.setSpacingBefore(20f);
			table9criteria3.setSpacingAfter(20f);

			document.add(table9criteria3);

			// document.add(cell332criteria3);
			// document.add(cell3321criteria3);

			
			
			
			PdfPTable table333criteria3 = new PdfPTable(2);
			PdfPTable table3331criteria31 = new PdfPTable(1);

			table333criteria3.setWidthPercentage(100f);
			table3331criteria31.setWidthPercentage(100f);
			PdfPCell cell911criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell911criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell922criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			
			cell922criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
//			PdfPCell cell933criteria3 = new PdfPCell(new Paragraph("Report of the event\r\n\r\n\r\n"));
//			PdfPCell cell944criteria3 = new PdfPCell(
//					new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(16).getCriteria3FilePath() : ""));
			PdfPCell cell955criteria3 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n",font5));
			cell955criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell966criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
			cell966criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell966criteria3.setExtraParagraphSpace(10);
			
			
			PdfPCell cell9511criteria3 = new PdfPCell(new Paragraph("\r\ne-copies of award letters\r\n\r\n",font5));
			cell9511criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell9611criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
			cell9611criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell9611criteria3.setExtraParagraphSpace(10);
			
			table333criteria3.addCell(cell911criteria3);
			table333criteria3.addCell(cell922criteria3);
//			table333criteria3.addCell(cell933criteria3);
//			table333criteria3.addCell(cell944criteria3);
			table333criteria3.addCell(cell955criteria3);
			table333criteria3.addCell(cell966criteria3);
			table333criteria3.addCell(cell9511criteria3);
			table333criteria3.addCell(cell9611criteria3);
			PdfPCell cell333criteria3 = new PdfPCell(new Paragraph(
					"3.3.3 Number of awards / recognitions received for research/innovations by the institution / teachers\r\n"
					+ "/ research scholars / students during the last five years.\r\n"
					+ "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria33Qn().get(0).getResponse333()
									: ""),
					font4));
			cell333criteria3.setExtraParagraphSpace(10);
			
			PdfPCell cell3331criteria3 = new PdfPCell(new Paragraph(
					"3.3.3.1 Total number of awards / recognitions received for research / innovations won by institution /\r\n"
					+ "teachers / research scholars / students year-wise during the last five years."
							+ "\r\n\r\n",
					font4));
			cell3331criteria3.setExtraParagraphSpace(10);
	//		table3331criteria31.addCell(cell333criteria3);
	//		table3331criteria31.addCell(cell3331criteria3);
	//		table3331criteria31.addCell(table333criteria3);

			// document.add(cell332criteria3);
			// document.add(cell3321criteria3);
			table333criteria3.setSpacingBefore(20f);
			table333criteria3.setSpacingAfter(20f);
			document.add(table3331criteria31);
			
	//		document.add(table333criteria3);
			
			
			// create a table 3321 //

			if (criteria3Record.getUniversityYearTable3331().size() >0 ) {
				Table table3331criteria3 = new Table(criteria3Record.getUniversityYearTable3331().size(), 2);

				table3331criteria3.setPadding(5);
				table3331criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getUniversityYearTable3331().size(); i++) {
					Cell cell2=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3331().get(i).getInput3331y(),font5));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3331criteria3.addCell(cell2);

				}
				for (int i = 0; i < criteria3Record.getUniversityYearTable3331().size(); i++) {
					Cell cell1112=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3331().get(i).getInput3331v(),font5));
					cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3331criteria3.addCell(cell1112);

				}

		//		document.add(table3331criteria3);
			}
			

         // 3.4 
			
			
			Paragraph paragraph5criteria3 = new Paragraph("3.4	Research Publications and Awards\r\n\r\n", font2);
			paragraph5criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph5criteria3);
			// create table 10 ///
			PdfPTable table10criteria3 = new PdfPTable(2);
			PdfPTable table11criteria31 = new PdfPTable(1);
			table10criteria3.setWidthPercentage(100f);
			table11criteria31.setWidthPercentage(100f);
			PdfPCell cell101criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n\r\n", font4));
			cell101criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell102criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell102criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell103criteria3 = new PdfPCell(new Paragraph("Code of ethics for Research document, Research\r\n"
					+ "Advisory committee and ethics committee\r\n"
					+ "constitution and list of members on these\r\n"
					+ "committees, software used for Plagiarism check,\r\n"
					+ "link to Website\r\n"
					,font5));
			cell103criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell103criteria3.setExtraParagraphSpace(10);
			
			
			PdfPCell cell104criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
			cell104criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell104criteria3.setExtraParagraphSpace(10);
			
			PdfPCell cell105criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell105criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell106criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
			cell106criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell106criteria3.setExtraParagraphSpace(10);
			
			table10criteria3.addCell(cell101criteria3);
			table10criteria3.addCell(cell102criteria3);
			table10criteria3.addCell(cell103criteria3);
			table10criteria3.addCell(cell104criteria3);
			table10criteria3.addCell(cell105criteria3);
			table10criteria3.addCell(cell106criteria3);
			
			
			PdfPCell cell3401criteria3 = new PdfPCell(new Paragraph(
					" 3.4.1 The institution ensures implementation of its stated Code of\r\n"
					+ "Ethics for research \r\n"
						 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Ql().get(0).getResponse341()
									: ""),
					font4));
			cell3401criteria3.setExtraParagraphSpace(10f);
			table11criteria31.addCell(cell3401criteria3);
			
			PdfPCell cell3401criteria3111 = new PdfPCell(new Paragraph(
					" 3.4.1.1The institution has a stated Code of Ethics for research and the \r\n"
					+ "implementation of which is ensured through the following: \r\n"
					+ "1. Inclusion of research ethics in the research methodology course work \r\n"
					+ "2. Presence of institutional Ethics committees (Animal, chemical,bio-ethics \r\n"
					+ "etc.,)\r\n"
					+ "3. Plagiarism check \r\n"
					+ "4. Research Advisory Committee"
					+ "A. All of the above\r\n"
					+ "B. Any 3 of the above\r\n"
					+ "C. Any 2 of the above\r\n"
					+ "D. Any 1 of the above\r\n"
					+ "E. None of the above(Opt any one)"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Ql().get(0).getInput341t1()
									: ""),
					font4));
			cell3401criteria3111.setExtraParagraphSpace(10f);
			table11criteria31.addCell(cell3401criteria3111);
			
	
			document.add(table11criteria31);
			
			
			

			// document.add(cell341criteria3);
		//	table10criteria3.setSpacingBefore(20f);
			table10criteria3.setSpacingAfter(20f);
			document.add(table10criteria3);
			

			/// create table 11 ////
			PdfPTable table11criteria3 = new PdfPTable(2);
			PdfPTable table111criteria31 = new PdfPTable(1);

			table11criteria3.setWidthPercentage(100f);
			table111criteria31.setWidthPercentage(100f);

			PdfPCell cell111criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell111criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell112criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell112criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell113criteria3 = new PdfPCell(new Paragraph(
					"List of PhD scholars and their details like name of the guide , title of thesis, year of award etc",font5));
			cell113criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell113criteria3.setExtraParagraphSpace(10);
			
			PdfPCell cell114criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "",font5));
			cell114criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell114criteria3.setExtraParagraphSpace(10);
			
			PdfPCell cell115criteria3 = new PdfPCell(new Paragraph("\r\nURL to the research page on HEI web site\r\n\r\n",font5));
			cell115criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell116criteria3 = new PdfPCell(new Paragraph("",font5));
			cell116criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table11criteria3.addCell(cell111criteria3);
			table11criteria3.addCell(cell112criteria3);
			table11criteria3.addCell(cell113criteria3);
			table11criteria3.addCell(cell114criteria3);
			table11criteria3.addCell(cell115criteria3);
			table11criteria3.addCell(cell116criteria3);
			
			
			PdfPCell cell342criteria3 = new PdfPCell(new Paragraph(
					"3.4.2 Number of Patents awarded during the last five years"
				
				 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getResponse342()
									: ""),
					font4));
			cell342criteria3.setExtraParagraphSpace(10);
			

			table111criteria31.addCell(cell342criteria3);
			
			
			
			PdfPCell cell342criteria223 = new PdfPCell(new Paragraph(
					"3.4.2.1 Total number of Patents awarded year-wise during the last five \r\n"
					+ "years"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getInput342t1()
									: ""),
					font4));
			cell342criteria223.setExtraParagraphSpace(10);
			

			table111criteria31.addCell(cell342criteria223);			
			
			
			
			
			
			
//			// document.add(cell342criteria3);
//			PdfPCell cell3421criteria3 = new PdfPCell(
//					new Paragraph("3.4.2.1 How many Ph.Ds are registered within last 5 years" + "\r\n\r\n\r\n", font2));
//			PdfPCell cell3422criteria3 = new PdfPCell(new Paragraph(
//					"3.4.2.2 Number of teachers recognized as guides during the last five years\r\n" + "\r\n\r\n\r\n" + "Response:"
//							+ (criteria3_FieldInfoQnList != null
//									? criteria3_FieldInfoQnList.get(0).getInput3422t1()
//									: ""),
//					font2));
//			table111criteria31.addCell(cell3421criteria3);
//			table111criteria31.addCell(cell3422criteria3);
		

			// document.add(cell3421criteria3);
			// document.add(cell3422criteria3);
	

			document.add(table111criteria31);
			
			table11criteria3.setSpacingAfter(20f);
			table11criteria3.setSpacingAfter(20f);
			document.add(table11criteria3);
			
			
			
			/// create table 12 /////
			PdfPTable table12criteria3 = new PdfPTable(2);
			PdfPTable table123criteria31 = new PdfPTable(1);

			table12criteria3.setWidthPercentage(100f);
			table123criteria31.setWidthPercentage(100f);
			
			PdfPCell cell121criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell121criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell122criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n\r\n", font4));
			cell122criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell123criteria3 = new PdfPCell(new Paragraph(
					"\r\nInstitutional data in prescribed format\r\n\r\n",
					font5));
			cell123criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell124criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "",font5));
			cell124criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell124criteria3.setExtraParagraphSpace(10);
			
			PdfPCell cell125criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell125criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell126criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "",font5));
			cell126criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell126criteria3.setExtraParagraphSpace(10);
		
			
			table12criteria3.addCell(cell121criteria3);
			table12criteria3.addCell(cell122criteria3);
			table12criteria3.addCell(cell123criteria3);
			table12criteria3.addCell(cell124criteria3);
			table12criteria3.addCell(cell125criteria3);
			table12criteria3.addCell(cell126criteria3);
			
			
			PdfPCell cell343criteria3 = new PdfPCell(new Paragraph(
					" 3.4.3 Number of Ph.Ds awarded per recognized guide during the last five \r\n"
					+ "years.\r\n"
							+ "\r\n" + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getResponse343()
									: ""),
					font4));
			cell343criteria3.setExtraParagraphSpace(10F);
			PdfPCell cell3431criteria3 = new PdfPCell(new Paragraph(
					"3.4.3.1 How many Ph.D s were awarded during last 5 years\r\n"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getInput343t1()
									: ""),
					font4));
			
			cell3431criteria3.setExtraParagraphSpace(10F);
			table123criteria31.addCell(cell343criteria3);
			table123criteria31.addCell(cell3431criteria3);
			
			PdfPCell cell3431criteria311 = new PdfPCell(new Paragraph(
					"3.4.3.2: Number of teachers recognized as guides during the last five \r\n"
					+ "years\r\n"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getInput343t1()
									: ""),
					font4));
			
			cell3431criteria311.setExtraParagraphSpace(10F);	
			
			
			table123criteria31.addCell(cell3431criteria311);
			
			
			
			
	

			// document.add(cell343criteria3);
			// document.add(cell3431criteria3);
	

			document.add(table123criteria31);
			
			table12criteria3.setSpacingBefore(20f);
			table12criteria3.setSpacingAfter(20f);
			document.add(table12criteria3);
			
			/// create table 3431 ////

			if (criteria3Record.getUniversityYearTable3431() .size() >0 ) {
				Table table3431criteria3 = new Table(criteria3Record.getUniversityYearTable3431().size(), 2);

				table3431criteria3.setPadding(5);
				table3431criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getUniversityYearTable3431().size(); i++) {
					Cell cell2111=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3431().get(i).getInput3431y(),font5));
					cell2111.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3431criteria3.addCell(cell2111);
					

				}
				for (int i = 0; i < criteria3Record.getUniversityYearTable3431().size(); i++) {
					Cell cell2111=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3431().get(i).getInput3431v(),font5));
					cell2111.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3431criteria3.addCell(cell2111);
				}

				document.add(table3431criteria3);
			}
			/// create table 13 //
			PdfPTable table13criteria3 = new PdfPTable(2);
			PdfPTable table131criteria31 = new PdfPTable(1);

			table13criteria3.setWidthPercentage(100f);
			table131criteria31.setWidthPercentage(100f);

			PdfPCell cell131criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell131criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell132criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell132criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell133criteria3 = new PdfPCell(
					new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n",font5));
			cell133criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell134criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "",font5));
			cell134criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell134criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell135criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n\r\n",font5));
			cell135criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell136criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "",font5));
			cell136criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell136criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell1351criteria3 = new PdfPCell(new Paragraph("\r\nURL to the research page on HEI web site\r\n\r\n",font5));
			cell1351criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1361criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : "",font5));
			cell1361criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1361criteria3.setExtraParagraphSpace(10f);
			
			
			table13criteria3.addCell(cell131criteria3);
			table13criteria3.addCell(cell132criteria3);
			table13criteria3.addCell(cell133criteria3);
			table13criteria3.addCell(cell134criteria3);
			table13criteria3.addCell(cell135criteria3);
			table13criteria3.addCell(cell136criteria3);
			table13criteria3.addCell(cell1351criteria3);
			table13criteria3.addCell(cell1361criteria3);
			
			table13criteria3.setSpacingBefore(20f);
			table13criteria3.setSpacingAfter(20f);

			document.add(table13criteria3);	
			
			
			PdfPCell cell3444criteria3 = new PdfPCell(new Paragraph(
					"3.4.4 Number of Ph.D’s awarded per teacher during the last five years."
						 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getResponse344()
									: ""),
					font4));
			cell3444criteria3.setExtraParagraphSpace(10F);
			
			
			
			
			PdfPCell cell3441criteria3 = new PdfPCell(new Paragraph(
					"3.4.4.1 Number of research papers published in the Journals as notified \r\n"
					+ "on UGC CARE list during the last five years \r\n"
//					+ "Response:"
//							+ (criteria3Record != null
//							? criteria3Record.getCriteria34Qn().get(0).getInput3441t1()
//							: "")
,
					font4));
//			PdfPCell cell3442criteria3 = new PdfPCell(new Paragraph(
//					"3.4.4.2 Number of teachers recognized as guides during the last five years\r\n"
//				+ "Response:"
//					+ (criteria3Record != null
//					? criteria3Record.getCriteria3FieldInfoQn().get(0).getInput3422t1()
//					: ""),
//					font3));
			table131criteria31.addCell(cell3444criteria3);
			table131criteria31.addCell(cell3441criteria3);
		//	table131criteria31.addCell(cell3442criteria3);

			// document.add(cell344criteria3);
			// document.add(cell3441criteria3);
//			table131criteria31.setSpacingBefore(20f);
//			table131criteria31.setSpacingAfter(20f);

			document.add(table131criteria31);
			
		
			
			
			// create table 3441 //
//
//			if (criteria3Record.getYearTable3441().size() >0 ) {
//				Table table3441criteria3 = new Table(criteria3Record.getYearTable3441().size(), 2);
//
//				table3441criteria3.setPadding(5);
//				table3441criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
//					Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3441().get(i).getInput3441y(),font5));
//					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table3441criteria3.addCell(cell2);
//				}
//				for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
//					Cell cell21=new Cell(new Paragraph(criteria3Record.getYearTable3441().get(i).getInput3441v(),font5));
//					cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table3441criteria3.addCell(cell21);
//				}
//				table3441criteria3.setSpacing(5f);
//				document.add(table3441criteria3);
//			}
//			
		///	
			
			if (criteria3Record.getYearTable3441().size() >0 ) {
				Table table3441criteria3 = new Table(criteria3Record.getYearTable3441().size(), 2);

				table3441criteria3.setPadding(5);
				table3441criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
					Cell cell1112=new Cell(new Paragraph((criteria3Record.getYearTable3441().get(i).getInput3441y()),font5));
					cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3441criteria3.addCell(cell1112);

				}
				for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
					Cell cell1112=new Cell(new Paragraph((criteria3Record.getYearTable3441().get(i).getInput3441v()),font5));
					cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3441criteria3.addCell(cell1112);
					

				}

				document.add(table3441criteria3);
			}
			
			
				
			
			
			
			
			
			
			
			
			
	///////////		
			if (criteria3Record.getUniversityYearTable3442().size()>0) {
				Table table3442criteria3 = new Table(criteria3Record .getUniversityYearTable3442().size(), 2);
	
				table3442criteria3.setPadding(5);
				table3442criteria3.setWidth(100f);
	
				for (int i = 0; i < criteria3Record.getUniversityYearTable3442().size(); i++) {
					Cell cell1112=new Cell(new Paragraph((criteria3Record.getUniversityYearTable3442().get(i).getInput3442y()),font5));
					cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3442criteria3.addCell(cell1112);
					
	
				}
				for (int i = 0; i < criteria3Record.getUniversityYearTable3442().size(); i++) {
					Cell cell002=new Cell(new Paragraph((criteria3Record.getUniversityYearTable3442().get(i).getInput3442v()),font5));
					cell002.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3442criteria3.addCell(cell002);
					
	
				}
			
			//	document.add(table3442criteria3);
			}
			
			
			
			

			// create table 14 //
			PdfPTable table14criteria3 = new PdfPTable(2);
	
			table14criteria3.setWidthPercentage(100f);
		

			PdfPCell cell141criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell141criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell142criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell142criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell143criteria3 = new PdfPCell(
					new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n",font5));
			cell143criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
			
			PdfPCell cell144criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : "",font5));
			cell144criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell144criteria3.setExtraParagraphSpace(10F);
			
			
			PdfPCell cell145criteria3 = new PdfPCell(
					new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell145criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell146criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : "",font5));
			cell146criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell146criteria3.setExtraParagraphSpace(10F);
			
			
			table14criteria3.addCell(cell141criteria3);
			table14criteria3.addCell(cell142criteria3);
			table14criteria3.addCell(cell143criteria3);
			table14criteria3.addCell(cell144criteria3);
			table14criteria3.addCell(cell145criteria3);
			table14criteria3.addCell(cell146criteria3);
			table14criteria3.setSpacingBefore(20f);
			table14criteria3.setSpacingAfter(20f);
			document.add(table14criteria3);
			
			PdfPTable table141criteria31 = new PdfPTable(1);
			table141criteria31.setWidthPercentage(100f);
			PdfPCell cell3451criteria3 = new PdfPCell(new Paragraph(
					"3.4.5 Number of books and chapters in edited volumes published per \r\n"
					+ "teacher during the last five years\r\n"
					+ "Response: "
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getResponse345()
									: ""),
					font4));
			
			cell3451criteria3.setExtraParagraphSpace(10F);
			
			
			PdfPCell cell34512criteria3 = new PdfPCell(new Paragraph("3.4.5.1 Total number of books and chapters in edited volumes / books \r\n"
					+ "published year- wise during the last five years ",font4));
							
			cell34512criteria3.setExtraParagraphSpace(10F);
			table141criteria31.addCell(cell3451criteria3);
			table141criteria31.addCell(cell34512criteria3);
//			
//			table141criteria31.addCell(table14criteria3);
		
			document.add(table141criteria31);
			
			

			
			
			
			if (criteria3Record.getUniversityYearTable3451().size() >0 ) {
				Table table3451criteria3 = new Table(criteria3Record.getUniversityYearTable3451().size(), 2);

				table3451criteria3.setPadding(5);
				table3451criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getUniversityYearTable3451().size(); i++) {
					Cell cell1112=new Cell(new Paragraph((criteria3Record.getUniversityYearTable3451().get(i).getInput3451y()),font5));
					cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3451criteria3.addCell(cell1112);

				}
				for (int i = 0; i < criteria3Record.getUniversityYearTable3451().size(); i++) {
					Cell cell1112=new Cell(new Paragraph((criteria3Record.getUniversityYearTable3451().get(i).getInput3451v()),font5));
					cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3451criteria3.addCell(cell1112);
					

				}

				document.add(table3451criteria3);
			}
			
			
			
			
			// create table 15 //
			
			PdfPCell cell346criteria3 = new PdfPCell(new Paragraph(
					"3.4.6 E-content is developed by teachers :"
					+ "1. For e-PG-Pathshala\r\n"
					+ "2. For CEC (Undergraduate) \r\n"
					+ "3. For SWAYAM\r\n"
					+ "4. For other MOOCs platforms\r\n"
					+ "5. Any other Government Initiatives\r\n"
					+ "6. For Institutional LMS\r\n"
					+ ""
					+ "A. Any 4 or more of the above\r\n"
					+ "B. Any 3 of the above\r\n"
					+ "C. Any 2 of the above\r\n"
					+ "D. Any 1 of the above\r\n"
					+ "E. None of the above\r\n"
				
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getResponse346()
									: ""),
					font2));
			
			cell346criteria3.setExtraParagraphSpace(10f);
			document.add(cell346criteria3);
			PdfPCell cell3461criteria3 = new PdfPCell(new Paragraph(
					"3.4.6.1 Total number of books and chapters in edited volumes/books published and papers in\r\n"
					+ "national/ international conference proceedings year-wise during last five years"
							+ "\r\n\r\n\r\n" + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getInput3461t1()
									: ""),
					font2));
			cell3461criteria3.setExtraParagraphSpace(10f);
			
		//	document.add(cell3461criteria3);
			
			PdfPTable table15criteria3 = new PdfPTable(2);
			PdfPTable table153criteria31 = new PdfPTable(1);

			table15criteria3.setWidthPercentage(100f);
			table153criteria31.setWidthPercentage(100f);

			PdfPCell cell151criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell151criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell152criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell152criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell153criteria3 = new PdfPCell(new Paragraph(
					"\r\nInstitutional data in prescribed format\r\n\r\n",font5));
			cell153criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell154criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(9).getCriteria3FilePath() : "",font5));
			cell154criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell154criteria3.setExtraParagraphSpace(10F);
			
			PdfPCell cell1531criteria3 = new PdfPCell(new Paragraph(
					"\r\nAny additional information\r\n\r\n",font5));
			cell1531criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1542criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(10).getCriteria3FilePath() : "",font5));
			cell1542criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1542criteria3.setExtraParagraphSpace(10f);
			table15criteria3.addCell(cell151criteria3);
			table15criteria3.addCell(cell152criteria3);
			table15criteria3.addCell(cell153criteria3);
			table15criteria3.addCell(cell154criteria3);
			table15criteria3.addCell(cell1531criteria3);
			table15criteria3.addCell(cell1542criteria3);
			


			// document.add(cell346criteria3);
			table15criteria3.setSpacingBefore(20f);
			table15criteria3.setSpacingAfter(20f);
		//	document.add(table15criteria3);
			
			
			if (criteria3Record.getUniversityYearTable3461().size() >0 ) {
				Table table3461criteria3 = new Table(criteria3Record.getUniversityYearTable3461().size(), 2);

				table3461criteria3.setPadding(5);
				table3461criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getUniversityYearTable3461().size(); i++) {
					Cell cell1=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3461().get(i).getInput3461y(),font5));
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3461criteria3.addCell(cell1);
					

				}
				for (int i = 0; i < criteria3Record.getUniversityYearTable3461().size(); i++) {
					Cell cell1=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3461().get(i).getInput3461v(),font5));
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3461criteria3.addCell(cell1);
				}

			//	document.add(table3461criteria3);
			}
			
			
			
			
			Paragraph paragraph01criteria311 = new Paragraph("3.4.6.1: Average number of full time teachers during the last five years",font4);
			document.add(paragraph01criteria311);
				
				if (criteria3Record.getUniversityYearTable34612().size() >0 ) {
					Table table34612criteria3 = new Table(criteria3Record.getUniversityYearTable34612().size(), 2);
	
					table34612criteria3.setPadding(5);
					table34612criteria3.setWidth(100f);
	
					for (int i = 0; i < criteria3Record.getUniversityYearTable34612().size(); i++) {
						Cell cell1=new Cell(new Paragraph(criteria3Record.getUniversityYearTable34612().get(i).getInput34612y(),font5));
						cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
						table34612criteria3.addCell(cell1);
	
					}
					for (int i = 0; i < criteria3Record.getUniversityYearTable34612().size(); i++) {
						Cell cell111=new Cell(new Paragraph(criteria3Record.getUniversityYearTable34612().get(i).getInput34612v(),font5));
						cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
						table34612criteria3.addCell(cell111);
					}
			
			//		document.add(table34612criteria3);
				}
			
			////////////////////////////////----------------------------------------------------->
			PdfPTable table347criteria3 = new PdfPTable(2);
			PdfPTable table3471criteria31 = new PdfPTable(1);

			table347criteria3.setWidthPercentage(100f);
			table3471criteria31.setWidthPercentage(100f);

			PdfPCell cell1517criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell1517criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1527criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell1527criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1537criteria3 = new PdfPCell(new Paragraph(
					"\r\nInstitutional data in prescribed format\r\n\r\n",font5));
			cell1537criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1547criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(11).getCriteria3FilePath() : "",font5));
			cell1547criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1547criteria3.setExtraParagraphSpace(10F);
			
			PdfPCell cell15317criteria3 = new PdfPCell(new Paragraph(
					"\r\nGive links or upload document of e-content\r\n"
					+ "developed\r\n\r\n",font5));
			cell15317criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell15427criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(12).getCriteria3FilePath() : "",font5));
			cell15427criteria3.setExtraParagraphSpace(10F);
			cell15427criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table347criteria3.addCell(cell1517criteria3);
			table347criteria3.addCell(cell1527criteria3);
			table347criteria3.addCell(cell1537criteria3);
			table347criteria3.addCell(cell1547criteria3);
			table347criteria3.addCell(cell15317criteria3);
			table347criteria3.addCell(cell15427criteria3);
			
			
			PdfPCell cell3467criteria3 = new PdfPCell(new Paragraph(
					"3.4.7 Bibliometrics of the publications during the last five years based on \r\n"
					+ "average Citation Index in Scopus/ Web of Science/PubMed :\r\n"
					+ "Response: "
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getResponse347()
									: ""),
					font4));
			
			cell3467criteria3.setExtraParagraphSpace(10f);		
			table3471criteria31.addCell(cell3467criteria3);
		
			table3471criteria31.setSpacingBefore(20f);
		

			// document.add(cell346criteria3);
		
			document.add(table3471criteria31);
			table347criteria3.setSpacingBefore(20f);
			table347criteria3.setSpacingAfter(20f);
			
			document.add(table347criteria3);
			
			PdfPTable table348criteria3 = new PdfPTable(1);
			

			table348criteria3.setWidthPercentage(100f);
		
			
			PdfPCell cell348criteria3 = new PdfPCell(new Paragraph(
					"3.4.8 Bibliometrics of the publications during the last five years based on average citation index in\r\n"
					+ "Scopus/ Web of Science or PubMed\r\n"
					+ "Response:  "
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getResponse348()
									: ""),
					font4));
			
			cell348criteria3.setExtraParagraphSpace(10f);
			table348criteria3.addCell(cell348criteria3);
		
			
		
			// document.add(cell346criteria3);
			table348criteria3.setSpacingBefore(20f);
			table348criteria3.setSpacingAfter(20f);
			document.add(table348criteria3);
			
			
			PdfPTable table0003407criteria311 = new PdfPTable(1);


			table0003407criteria311.setWidthPercentage(100f);
			
			
			
			PdfPCell cell00348criteria3 = new PdfPCell(new Paragraph(new Paragraph("3.4.8.1: Total Number of Citations in Scopus in 5 years\r\n",font4)));

		//	table0003407criteria311.addCell(cell00348criteria3);
			
			PdfPCell cell000348criteria3 = new PdfPCell( new Paragraph((criteria3Record != null
					? criteria3Record.getCriteria34Qn().get(0).getInput348t1()
					: ""),font4));
			
			cell000348criteria3.setExtraParagraphSpace(10f);
			
	//		table0003407criteria311.addCell(cell000348criteria3);
			

			PdfPCell cell010348criteria3 = new PdfPCell(new Paragraph("Total Number of Citations in Web of Science in 5 years\r\n",font4));
		//	table0003407criteria311.addCell(cell010348criteria3);
			
			
			PdfPCell cell010348criteria13 = new PdfPCell(new Paragraph((criteria3Record != null
						? criteria3Record.getCriteria34Qn().get(0).getInput348t2()
						: ""),font4));
			
			cell010348criteria13.setExtraParagraphSpace(10f);
			
	//		table0003407criteria311.addCell(cell010348criteria13);
					
					
					
			PdfPCell cell011348criteria13 = new PdfPCell(new Paragraph(("3.4.8.2: Total number of Publications in Scopus in 5 years\r\n"),font4));
	//		table0003407criteria311.addCell(cell011348criteria13);
		
			
			PdfPCell cell011348criteria113 = new PdfPCell(new Paragraph((criteria3Record != null
							? criteria3Record.getCriteria34Qn().get(0).getInput3482t1()
							: ""),font4));
			
			cell011348criteria113.setExtraParagraphSpace(10f);
	//		table0003407criteria311.addCell(cell011348criteria113);
			
			
			PdfPCell cell011348criteria013 = new PdfPCell(new Paragraph("Total number of Publications in Web of Science in 5 years\r\n",font4));
		//	table0003407criteria311.addCell(cell011348criteria013);
			
			
			PdfPCell cell0113408criteria013 = new PdfPCell(new Paragraph((criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getInput3482t2()
								: ""),font4));
			cell0113408criteria013.setExtraParagraphSpace(10f);
	//		table0003407criteria311.addCell(cell0113408criteria013);
//						
						document.add(table0003407criteria311)	;
							
							
							
							PdfPTable table3407criteria311 = new PdfPTable(2);


							table3407criteria311.setWidthPercentage(100f);


							PdfPCell cell1518criteria31 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
							cell1518criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
							
							
							PdfPCell cell1528criteria31 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
							cell1528criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
							
							PdfPCell cell1538criteria31 = new PdfPCell(new Paragraph(
									"\r\nBibiliometrics of publications based on Scopus/ Web of Science - h-index of the Institution\r\n\r\n",font5));
							cell1538criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
							
							
							PdfPCell cell1548criteria31 = new PdfPCell(
									new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
							cell1548criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
							cell1548criteria31.setExtraParagraphSpace(10f);
							
							PdfPCell cell15318criteria31 = new PdfPCell(new Paragraph(
									"\r\nAny additional information\r\n"
									+ "developed\r\n\r\n",font5));
							cell15318criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
							
							
							PdfPCell cell15428criteria31 = new PdfPCell(
									new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
							cell15428criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
							cell15428criteria31.setExtraParagraphSpace(10f);
							
							table3407criteria311.addCell(cell1518criteria31);
							
							
							table3407criteria311.addCell(cell1528criteria31);
							
							table3407criteria311.addCell(cell15318criteria31);
							table3407criteria311.addCell(cell15428criteria31);
							table3407criteria311.addCell(cell1538criteria31);
							table3407criteria311.addCell(cell1548criteria31);
							table3407criteria311.setSpacingBefore(20f);
							table3407criteria311.setSpacingAfter(20f);
							
			//				document.add(table3407criteria311);
						
							
							
							
							
							
					
					
					
		PdfPTable table349criteria3 = new PdfPTable(1);
			

		table349criteria3.setWidthPercentage(100f);
		
			
			PdfPCell cell349criteria3 = new PdfPCell(new Paragraph(
					"3.4.9 Bibliometrics of the publications during the last five years based on Scopus/ Web of Science - hindex of the Institution\r\n"
					+ "Response: "
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Ql().get(0).getResponse349(): ""),font4));
			cell349criteria3.setExtraParagraphSpace(10f);
			table349criteria3.addCell(cell349criteria3);
		
			
			
			PdfPCell cell349criteria321 = new PdfPCell(new Paragraph(
					"3.4.9.1: h-index of Scopus during the last five years\r\n"
					+ "Response: "
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Ql().get(0).getInput3491t1()
									: ""),font4));
			cell349criteria321.setExtraParagraphSpace(10f);
			table349criteria3.addCell(cell349criteria321);
	
			PdfPCell cell349criteria323 = new PdfPCell(new Paragraph(
					"h-index of Web of Science during the last five years\r\n"
					+ "Response: "
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Ql().get(0).getInput3491t2()
									: "")
							,font4));
			
			cell349criteria323.setExtraParagraphSpace(10f);
			table349criteria3.addCell(cell349criteria323);
		
	//		document.add(table349criteria3);
			
			
//		do
//			table349criteria3.addCell(cell349criteria323);
//			document.add(table349criteria3);
//		
			PdfPTable table3407criteria3 = new PdfPTable(2);


			table3407criteria3.setWidthPercentage(100f);


			PdfPCell cell1518criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell1518criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1528criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell1528criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1538criteria3 = new PdfPCell(new Paragraph(
					"\r\nBibiliometrics of publications based on Scopus/ Web of Science - h-index of the Institution\r\n\r\n",font5));
			cell1538criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1548criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(13).getCriteria3FilePath() : "",font5));
			cell1548criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1548criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell15318criteria3 = new PdfPCell(new Paragraph(
					"\r\nAny additional information\r\n"
					+ "developed\r\n\r\n",font5));
			cell15318criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell15428criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(14).getCriteria3FilePath() : "",font5));
			cell15428criteria3.setExtraParagraphSpace(10f);
			cell15428criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table3407criteria3.addCell(cell1518criteria3);
			table3407criteria3.addCell(cell1528criteria3);
			table3407criteria3.addCell(cell1538criteria3);
			table3407criteria3.addCell(cell1548criteria3);
			table3407criteria3.addCell(cell15318criteria3);
			table3407criteria3.addCell(cell15428criteria3);
			table3407criteria3.setSpacingAfter(20f);
			table3407criteria3.setSpacingBefore(20f);
			
			
		//	document.add(table3407criteria3);
			
			
	// 3.5 
			

			Paragraph paragraph6criteria3 = new Paragraph("3.5	Consultancy\r\n\r\n", font2);
			paragraph6criteria3.setSpacingAfter(2f);
			paragraph6criteria3.setSpacingBefore(2f);
			paragraph6criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph6criteria3);
			// create table 16 //
			PdfPTable table16criteria3 = new PdfPTable(2);
			PdfPTable table161criteria31 = new PdfPTable(1);

			table16criteria3.setWidthPercentage(100f);
			table161criteria31.setWidthPercentage(100f);

			PdfPCell cell161criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell161criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell162criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell162criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell163criteria3 = new PdfPCell(new Paragraph("Upload minutes of the Governing Council/ Syndicate/Board of Management related to the Consultancy policy\r\n", font5));
			cell163criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell164criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "", font5));
			cell164criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell164criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell165criteria3 = new PdfPCell(new Paragraph(
					"Upload minutes of the Governing Council/ Syndicate/Board of Management related to the Consultancy policy\r\n", font5));
			cell165criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell166criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "", font5));
			cell166criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell166criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell167criteria3 = new PdfPCell(new Paragraph("Upload any additional information", font5));
			cell167criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell168criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "", font5));
			cell168criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell168criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell167criteria31 = new PdfPCell(new Paragraph("Paste URL of the consultancy policy document \r\n\r\n", font5));
			cell167criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell168criteria31 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "", font5));
			cell168criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell168criteria31.setExtraParagraphSpace(10f);
			
			table16criteria3.addCell(cell161criteria3);
			table16criteria3.addCell(cell162criteria3);
			table16criteria3.addCell(cell163criteria3);
			table16criteria3.addCell(cell164criteria3);
			table16criteria3.addCell(cell165criteria3);
			table16criteria3.addCell(cell166criteria3);
			table16criteria3.addCell(cell167criteria3);
			table16criteria3.addCell(cell168criteria3);
			table16criteria3.addCell(cell167criteria31);
			table16criteria3.addCell(cell168criteria31);
			
			
			PdfPCell cell351criteria3 = new PdfPCell(new Paragraph(
					"3.5.1 Revenue generated from consultancy and corporate training during the \r\n"
					+ "last five years (INR in Lakhs) .\r\n"
							 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria35Qn().get(0).getResponse351()
									: ""),
					font4));
			cell351criteria3.setExtraParagraphSpace(10f);
			table161criteria31.addCell(cell351criteria3);
		
			
			PdfPCell cell351criteria1113 = new PdfPCell(new Paragraph(
					"3.5.1.1: Total amount generated from consultancy and corporate training \r\n"
					+ "year-wise during the last five years (INR in lakhs) \r\n"
//							 + "Response:"
//							+ (criteria3Record != null
//									? criteria3Record.getCriteria35Qn().get(0).getResponse351()
//									: "")
,
					font4));
			cell351criteria1113.setExtraParagraphSpace(10f);
			table161criteria31.addCell(cell351criteria1113);
			

			
		
			document.add(table161criteria31);
			
			
			
			
			
			
			table16criteria3.setSpacingBefore(20f);
			table16criteria3.setSpacingAfter(20f);
			document.add(table16criteria3);
			
			
			
			
			if (criteria3Record.getYearTable3511().size() >0 ) {
				Table table3521criteria3 = new Table(criteria3Record.getYearTable3511().size(), 2);

				table3521criteria3.setPadding(5);
				table3521criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3511().size(); i++) {
					Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3511().get(i).getInput3511y(),font5));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3521criteria3.addCell(cell2);

				}
				for (int i = 0; i < criteria3Record.getYearTable3511().size(); i++) {
					Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3511().get(i).getInput3511v(),font5));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3521criteria3.addCell(cell2);
					

				}

				document.add(table3521criteria3);
			}
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			PdfPTable table17criteria3 = new PdfPTable(2);
			

			table17criteria3.setWidthPercentage(100f);
			


			PdfPCell cell171criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			
			cell171criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell172criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell172criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell173criteria3 = new PdfPCell(
					new Paragraph("Audited statement/s of accounts indicating the revenue generated through consultancy\r\n",font5));
			cell173criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell174criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
			cell174criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell174criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell175criteria3 = new PdfPCell(
					new Paragraph("Audited statement/s of accounts indicating the revenue generated through consultancy\r\n",font5));
			cell175criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell176criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "",font5));
			cell176criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell176criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell179criteria3 = new PdfPCell(new Paragraph("Audited statement/s of accounts indicating the revenue generated through consultancy\r\n",font5));
			cell179criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell180criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "",font5));
			cell180criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell180criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell179criteria322= new PdfPCell(new Paragraph("List of facilities and staff available for undertaking consultancy\r\n",font5));
			
			cell179criteria322.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell180criteria322= new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "",font5));
			cell180criteria322.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell180criteria322.setExtraParagraphSpace(10f);
		//	cell180criteria322.setExtraParagraphSpace(10f);
			
			
			table17criteria3.addCell(cell171criteria3);
			table17criteria3.addCell(cell172criteria3);
			table17criteria3.addCell(cell173criteria3);
			table17criteria3.addCell(cell174criteria3);
			table17criteria3.addCell(cell175criteria3);
			table17criteria3.addCell(cell176criteria3);
		
			table17criteria3.addCell(cell179criteria3);
			table17criteria3.addCell(cell180criteria3);
			table17criteria3.addCell(cell179criteria322);
			table17criteria3.addCell(cell180criteria322);
			
			
			table17criteria3.setSpacingBefore(20f);
			table17criteria3.setSpacingAfter(20f);

		//	document.add(table17criteria3);
			
			PdfPTable table173criteria31 = new PdfPTable(1);
			table173criteria31.setWidthPercentage(100f);
			
			PdfPCell cell0179criteria322= new PdfPCell(new Paragraph(
					"3.5.2 Revenue generated from consultancy and corporate training during the last five years (INR in\r\n"
					+ "Lakhs).\r\n"
					+ "Response: "
							+ (criteria3Record != null
									? criteria3Record.getCriteria35Ql().get(0).getResponse352()
									: ""),font4));
			
			cell0179criteria322.setExtraParagraphSpace(10f);
		//	table173criteria31.addCell(cell0179criteria322);
			
			PdfPCell cell0179criteria0322= new PdfPCell(new Paragraph(
					"3.5.2.1 Total amount generated from consultancy and corporate training year-wise during the last\r\nfive years (INR in lakhs)\r\n",font4));
			cell0179criteria0322.setExtraParagraphSpace(10f);
			table173criteria31.addCell(cell0179criteria0322);
			
			
	//		document.add(table173criteria31);
			
			
			if (criteria3Record.getYearTable3521().size() >0 ) {
				Table table3521criteria3 = new Table(criteria3Record.getYearTable3521().size(), 2);

				table3521criteria3.setPadding(5);
				table3521criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3521().size(); i++) {
					Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3521().get(i).getInput3521y(),font5));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3521criteria3.addCell(cell2);

				}
				for (int i = 0; i < criteria3Record.getYearTable3521().size(); i++) {
					Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3521().get(i).getInput3521v(),font5));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3521criteria3.addCell(cell2);
					

				}

		//		document.add(table3521criteria3);
			}

			

			
			// 3.6 
			
			Paragraph paragraph7criteria3 = new Paragraph("3.6	Extension Activities\r\n\r\n", font2);
			paragraph7criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			paragraph7criteria3.setSpacingBefore(2f);
			paragraph7criteria3.setSpacingAfter(2f);
			document.add(paragraph7criteria3);
			
			
			// create table 18 //
			PdfPTable table18criteria3 = new PdfPTable(2);

			table18criteria3.setWidthPercentage(100f);
			
			


			PdfPCell cell181criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell181criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell182criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell182criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell183criteria3 = new PdfPCell(new Paragraph("Upload Any additional information\r\n\r\n\r\n",font5));
			cell183criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell184criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
			cell184criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell184criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell185criteria3 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n",font5));
		
			cell185criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell186criteria3 = new PdfPCell(new Paragraph("",font5));
			cell186criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table18criteria3.addCell(cell181criteria3);
			table18criteria3.addCell(cell182criteria3);
			table18criteria3.addCell(cell183criteria3);
			table18criteria3.addCell(cell184criteria3);
			table18criteria3.addCell(cell185criteria3);
			table18criteria3.addCell(cell186criteria3);
		
			
			table18criteria3.setSpacingAfter(20f);
			table18criteria3.setSpacingBefore(20f);
			
			document.add(table18criteria3);
			
			PdfPTable table183criteria3 = new PdfPTable(1);

			table183criteria3.setWidthPercentage(100f);
			
			
			PdfPCell cell185criteria03 = new PdfPCell(new Paragraph(	"3.6.1 Extension activities in the neighborhood community in terms of impact \r\n"
					+ "and sensitizing the students to social issues and holistic development and \r\n"
					+ "awards received if any\r\n"
					+"Response:",font4));
			
			table183criteria3.addCell(cell185criteria03);
			
			
			
			if( criteria3Record.getCriteria36Ql() !=null)
			{
			
				PdfPCell cell185criteria003 = new PdfPCell( new Paragraph (criteria3Record != null
									? criteria3Record.getCriteria36Ql().get(0).getInput361t1()
									: "",font4));
				cell185criteria003.setExtraParagraphSpace(10f);
				table183criteria3.addCell(cell185criteria003);
			
			}
			
	
		

			// create table 19 //
			
			PdfPCell cell185criteria00321 = new PdfPCell(new Paragraph (
					"3.6.2 Number of extension and outreach programs conducted through \r\n"
					+ "organized forums by the institution during the last five years\r\n"
						 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria36Qn().get(0).getResponse362()
									: ""),font4));
			cell185criteria00321.setExtraParagraphSpace(10f);
			table183criteria3.addCell(cell185criteria00321);
			
	
			
			PdfPCell cell185criteria001321 = new PdfPCell(new Paragraph (
					"3.6.2.1 Number of extension and outreach programs conducted by the \r\n"
					+ "institution through organized forums like NSS/NCC during the last five \r\n"
					+ "years.\r\n"
					+ "."
							,font4));
			cell185criteria001321.setExtraParagraphSpace(10f);
			table183criteria3.addCell(cell185criteria001321);
			
			document.add(table183criteria3);
			
	
			if (criteria3Record.getYearTable3621().size() >0 ) {
				Table table3621criteria3 = new Table(criteria3Record.getYearTable3621().size(), 2);

				table3621criteria3.setPadding(5);
				table3621criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3621().size(); i++) {
					Cell cell112=new Cell(new Paragraph(criteria3Record.getYearTable3621().get(i).getInput3621y(),font5));
					cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3621criteria3.addCell(cell112);

				}
				for (int i = 0; i < criteria3Record.getYearTable3621().size(); i++) {
					Cell cell112=new Cell(new Paragraph(criteria3Record.getYearTable3621().get(i).getInput3621v(),font5));
					cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3621criteria3.addCell(cell112);
					

				}

				document.add(table3621criteria3);
			}
			
			PdfPTable table19criteria3 = new PdfPTable(2);
			table19criteria3.setWidthPercentage(100f);
			
			
			
		

			PdfPCell cell191criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell191criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			
			PdfPCell cell192criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell192criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell193criteria3 = new PdfPCell(
					new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n", font5));
			cell193criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell194criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "", font5));
			cell194criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell194criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell195criteria3 = new PdfPCell(new Paragraph("\r\ne-copy of the award letters\r\n\r\n", font5));
			cell195criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell196criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "", font5));
			cell196criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell196criteria3.setExtraParagraphSpace(10f);
			
			PdfPCell cell197criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n", font5));
			cell197criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell198criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "", font5));
			cell198criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell198criteria3.setExtraParagraphSpace(10f);
			
			table19criteria3.addCell(cell191criteria3);
			table19criteria3.addCell(cell192criteria3);
			table19criteria3.addCell(cell193criteria3);
			table19criteria3.addCell(cell194criteria3);
			table19criteria3.addCell(cell195criteria3);
			table19criteria3.addCell(cell196criteria3);
			table19criteria3.addCell(cell197criteria3);
			table19criteria3.addCell(cell198criteria3);

	//		table191criteria3.addCell(table19criteria3);
			
			
			table19criteria3.setSpacingBefore(20f);
			table19criteria3.setSpacingAfter(20f);
			document.add(table19criteria3);

			
			
			
			PdfPTable table191criteria3 = new PdfPTable(1);

			
			table191criteria3.setWidthPercentage(100f);
			
			
			PdfPCell cell198criteria03 = new PdfPCell(new Paragraph (
					"3.6.3 Number of extension and outreach programs conducted by the institution through NSS/NCC,\r\n"
					+ "Government and Government recognised bodies during the last five years\r\n"
				 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria36Qn().get(0).getResponse363()
									: ""),font4));
			cell198criteria03.setExtraParagraphSpace(10f);
			
			
			table191criteria3.addCell(cell198criteria03);
	
			PdfPCell cell198criteria013 = new PdfPCell(new Paragraph (
					"3.6.3.1 Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years"
							+ "\r\n\r\n",font4));
			
			
			table191criteria3.addCell(cell198criteria013);
			
		//	document.add(table191criteria3);
			
			
					
					if (criteria3Record.getYearTable3631() .size() >0 ) {
						Table table3631criteria3 = new Table(criteria3Record.getYearTable3631().size(), 2);

						table3631criteria3.setPadding(5);
						table3631criteria3.setWidth(100f);

						for (int i = 0; i < criteria3Record.getYearTable3631().size(); i++) {
							Cell cell00000112=new Cell(new Paragraph((criteria3Record.getYearTable3631().get(i).getInput3631y()),font5));
							cell00000112.setHorizontalAlignment(Element.ALIGN_CENTER);
							table3631criteria3.addCell(cell00000112);

						}
						for (int i = 0; i < criteria3Record.getYearTable3631().size(); i++) {
							Cell cell00000112=new Cell(new Paragraph(criteria3Record.getYearTable3631().get(i).getInput3631v(),font5));
							cell00000112.setHorizontalAlignment(Element.ALIGN_CENTER);
							table3631criteria3.addCell(cell00000112);

						}

				//		document.add(table3631criteria3);
					}
					
					

			PdfPTable table21criteria3 = new PdfPTable(2);
		
			
			table21criteria3.setWidthPercentage(100f);
		

			PdfPCell cell211criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			
			cell211criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell212criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
	
			cell212criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell213criteria3 = new PdfPCell(new Paragraph("\r\nReports of the event\r\n\r\n",font5));
			cell213criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell214criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : "",font5));
			cell214criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell214criteria3.setExtraParagraphSpace(5f);
			
			PdfPCell cell215criteria3 = new PdfPCell(new Paragraph(
					"\r\nInstitutional data in prescribed format\r\n\r\n",font5));
			cell215criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell216criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : "",font5));
			cell216criteria3.setExtraParagraphSpace(5f);
			cell216criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell217criteria3 = new PdfPCell(new Paragraph(
					"\r\nAverage percentage of students participating in extension activities with Govt or NGO etc\r\n\r\n",font5));
			cell217criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell218criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(9).getCriteria3FilePath() : "",font5));
			cell218criteria3.setExtraParagraphSpace(5f);
			cell218criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table21criteria3.addCell(cell211criteria3);
			table21criteria3.addCell(cell212criteria3);
			table21criteria3.addCell(cell213criteria3);
			table21criteria3.addCell(cell214criteria3);
			table21criteria3.addCell(cell215criteria3);
			table21criteria3.addCell(cell216criteria3);
			table21criteria3.addCell(cell217criteria3);
			table21criteria3.addCell(cell218criteria3);
			
			table21criteria3.setSpacingBefore(20F);
			table21criteria3.setSpacingAfter(20F);
			
	//		document.add(table21criteria3);
			
			
			
			PdfPTable table211criteria3 = new PdfPTable(1);
			table211criteria3.setWidthPercentage(100f);
			
			
			PdfPCell cell0218criteria03 = new PdfPCell( new Paragraph (
					"3.6.4 Average percentage of students participating in extension activities listed at 3.6.3 above during the last five years\r\n"
						 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria36Qn().get(0).getResponse364()
									: ""),font4));
			
			cell0218criteria03.setExtraParagraphSpace(10f);
			
	//		table211criteria3.addCell(cell0218criteria03);
			

			PdfPCell cell10218criteria03 = new PdfPCell(new Paragraph (
					"3.6.4.1 Total number of students participating in extension activities listed at 3.6.3 above year-wise during the last five years."
							+ "\r\n\r\n",font4));
					
		//	table211criteria3.addCell(cell10218criteria03);			
			
			
			
	table211criteria3.setSpacingBefore(20f);
    table211criteria3.setSpacingAfter(20f);
//	document.add(table211criteria3);					
						
			if (criteria3Record.getYearTable3641().size() >0 ) {
				Table table3641criteria3 = new Table(criteria3Record.getYearTable3641().size(), 2);

				table3641criteria3.setPadding(5);
				table3641criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
					Cell cell0000012=new Cell(new Paragraph((criteria3Record.getYearTable3641().get(i).getInput3641y()),font5));
					cell0000012.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3641criteria3.addCell(cell0000012);

				}
				for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
					Cell cell0000012=new Cell(new Paragraph(criteria3Record.getYearTable3641().get(i).getInput3641v(),font5));
					cell0000012.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3641criteria3.addCell(cell0000012);
				}

	//			document.add(table3641criteria3);
			}
		//	table211criteria3.addCell(table21criteria3);
			
	
			
// 3.7 
			Paragraph paragraph8criteria3 = new Paragraph("3.7	Collaboration\r\n\r\n", font2);
			paragraph8criteria3.setSpacingBefore(2f);
			paragraph8criteria3.setSpacingAfter(2f);
			
			
			paragraph8criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph8criteria3);
			// create table 22 //
			
			
			
			PdfPTable table211criteria003 = new PdfPTable(1);
			table211criteria003.setWidthPercentage(100f);

			PdfPCell cell10218criteria0003 = new PdfPCell(new Paragraph(
					"3.7.1 Number of functional MoUs /linkage with institutions/ industries in \r\n"
					+ "India and abroad for internship, on-the-job training, project work, \r\n"
					+ "student / faculty exchange and collaborative research during the last \r\n"
					+ "five years\r\n"
					+ ""
							 + "Response: \r\n"
							+ (criteria3Record != null
									? criteria3Record.getCriteria37Qn().get(0).getResponse371()
									: ""),font4));
			
			cell10218criteria0003.setExtraParagraphSpace(5f);
			table211criteria003.addCell(cell10218criteria0003);
	
			PdfPCell cell10218criteria003 = new PdfPCell(new Paragraph(
					"3.7.1.1: Number of functional MoUs with institutions/ industries in India \r\n"
					+ "and abroad for internship, on-the-job training, project work, student / faculty \r\n"
					+ "exchange and collaborative research during the last five years",font4));
			
			cell10218criteria003.setExtraParagraphSpace(5f);
			
			table211criteria003.addCell(cell10218criteria003);
			
			
			document.add(table211criteria003);
			
			

			if (criteria3Record.getYearTable3711().size() >0 ) {
				Table table3711criteria3 = new Table(criteria3Record.getYearTable3711().size(), 2);

				table3711criteria3.setPadding(5);
				table3711criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3711().size(); i++) {
					Cell cell0000012=new Cell(new Paragraph((criteria3Record.getYearTable3711().get(i).getInput3711y()),font5));
					cell0000012.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3711criteria3.addCell(cell0000012);

				}
				for (int i = 0; i < criteria3Record.getYearTable3711().size(); i++) {
					Cell cell0000013=new Cell(new Paragraph((criteria3Record.getYearTable3711().get(i).getInput3711v()),font5));
					cell0000013.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3711criteria3.addCell(cell0000013);

				}

			//	document.add(table3711criteria3);
				
			}
			
			
			PdfPTable table22criteria3 = new PdfPTable(2);
	
			table22criteria3.setWidthPercentage(100f);
			
	

			PdfPCell cell221criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell221criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell222criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell222criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell223criteria3 = new PdfPCell(
					new Paragraph("Copies of collaboration\r\n", font5));
			
			cell223criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell223criteria3.setExtraParagraphSpace(5f);
			
			
			PdfPCell cell224criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "", font5));
			
			cell224criteria3.setExtraParagraphSpace(5f);
			
			cell224criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell225criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n", font5));
			cell225criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell226criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
			cell226criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell226criteria3.setExtraParagraphSpace(5f);
			
			
			PdfPCell cell225criteria31 = new PdfPCell(new Paragraph("Number of Collaborative activities for research, faculty etc\r\n\r\n", font5));
			cell225criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell225criteria31.setExtraParagraphSpace(5f);
			
			
			PdfPCell cell226criteria31 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ", font5"));
			cell226criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell226criteria31.setExtraParagraphSpace(5f);
			
			
			table22criteria3.addCell(cell221criteria3);
			table22criteria3.addCell(cell222criteria3);
			table22criteria3.addCell(cell223criteria3);
			table22criteria3.addCell(cell224criteria3);
			table22criteria3.addCell(cell225criteria3);
			table22criteria3.addCell(cell226criteria3);
			table22criteria3.addCell(cell225criteria31);
			table22criteria3.addCell(cell226criteria31);
		
			table22criteria3.setSpacingBefore(20f);
			table22criteria3.setSpacingAfter(20f);
			document.add(table22criteria3);
			
			
			
			
			PdfPTable table221criteria3 = new PdfPTable(1);
			table221criteria3.setWidthPercentage(100f);
	

			// create table 23 //
			
			PdfPCell cell225criteria3001 = new PdfPCell(new Paragraph(
					"3.7.2 Number of functional MoUs with institutions of national, international importance, other institutions, industries, corporate houses etc. during the last five years (only functional MoUs with ongoing activities to be considered)\r\n"
						 + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria37Qn().get(0).getResponse372()
									: ""),font4));
			cell225criteria3001.setExtraParagraphSpace(5f);
		//	table221criteria3.addCell(cell225criteria3001);
			
			
			PdfPCell cell225criteria301 = new PdfPCell(new Paragraph(
					"3.7.2.1 Number of functional MoUs with institutions of national, international importance, other Institutions, industries, corporate houses etc. year wise during last five years"
							+ "\r\n",font4));
			cell225criteria301.setExtraParagraphSpace(5f);


		//	table221criteria3.addCell(cell225criteria301);
			
			
			if (criteria3Record.getYearTable3721().size() >0 ) {
				Table table3721criteria3 = new Table(criteria3Record.getYearTable3721().size(), 2);

				table3721criteria3.setPadding(5);
				table3721criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3721().size(); i++) {
					Cell cell000001=new Cell(new Paragraph((criteria3Record.getYearTable3721().get(i).getInput3721y()),font5));
					cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3721criteria3.addCell(cell000001);
					

				}
				for (int i = 0; i < criteria3Record.getYearTable3721().size(); i++) {
					Cell cell000002=new Cell(new Paragraph((criteria3Record.getYearTable3721().get(i).getInput3721v()),font5));
					cell000002.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3721criteria3.addCell(cell000002);
				}

		//		document.add(table3721criteria3);
				
			}
			
			
			
			PdfPTable table23criteria3 = new PdfPTable(2);
		

			table23criteria3.setWidthPercentage(100f);
	

			PdfPCell cell231criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell231criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell232criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			
			cell232criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell233criteria3 = new PdfPCell(
					new Paragraph("\r\ne-copies of the MoUs with institution/ industry/ corporate house\r\n\r\n", font5));
			cell233criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell233criteria3.setExtraParagraphSpace(5f);
			
			
			PdfPCell cell234criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "", font5));
			cell234criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell234criteria3.setExtraParagraphSpace(5f);
			
			
			PdfPCell cell235criteria3 = new PdfPCell(new Paragraph(
					"Details of functional MoUs with institutions of national, international importance, other Institutions etc during the last five years\r\n\r\n", font5));
			cell235criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell235criteria3.setExtraParagraphSpace(5f);
			
			
			PdfPCell cell236criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "", font5));
			cell236criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell236criteria3.setExtraParagraphSpace(5f);
			
			
			
			PdfPCell cell237criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n", font5));
			cell237criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell237criteria3.setExtraParagraphSpace(5f);
			
			PdfPCell cell238criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "", font5));
			cell238criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell238criteria3.setExtraParagraphSpace(5f);
			
			
			table23criteria3.addCell(cell231criteria3);
			table23criteria3.addCell(cell232criteria3);
			table23criteria3.addCell(cell233criteria3);
			table23criteria3.addCell(cell234criteria3);
			table23criteria3.addCell(cell235criteria3);
			table23criteria3.addCell(cell236criteria3);
			table23criteria3.addCell(cell237criteria3);
			table23criteria3.addCell(cell238criteria3);
		
			table23criteria3.setSpacingBefore(20f);
			table23criteria3.setSpacingAfter(20f);
	//		document.add(table23criteria3);
		
		


			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
