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

import com.adiverse.erp.model.Criteria4_FieldInfo;
import com.adiverse.erp.model.Criteria4_FileUpload;
import com.adiverse.erp.service.Criteria4Service;
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
public class Criteria4UniversityReport {

	@Value("${upload.files.path}")
	private String reportGeneratePath;

	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);


	@Autowired
	Criteria4Service service4;

	List<Criteria4_FieldInfo> criteria4List = null;
	Criteria4_FieldInfo criteria4Record = null;
	List<Criteria4_FileUpload> criteria4file = null;

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
//			allParams.put("collegeId",criteria4Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear", criteria4Fieldinfo.getCriteriaId().getFinancialYear());
//
//			allParams.put("typeofInstitution", criteria4Fieldinfo.getCriteriaId().getTypeofInstitution() );

			criteria4List = service4.getAllCriteria4Data(allParams);
			if (CollectionUtils.isNotEmpty(criteria4List)) {
				criteria4Record = criteria4List.get(0);
				criteria4file = criteria4Record.getCriteria4FileUpload();
			} else {
				criteria4Record = new Criteria4_FieldInfo();
				criteria4file = new ArrayList<Criteria4_FileUpload>();
			}

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "Criteria4UniversityReport-" + strDate + ".pdf";
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
			

			// 4.1
			
			Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources", font2);
			paragraph1criteria4.setSpacingBefore(2F);
			paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph1criteria4);
			
			Paragraph paragraph1criteria40000 = new Paragraph("__________________________________________________________________________");
			paragraph1criteria40000.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph1criteria40000);

			/*
			 * Font font1criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * font1criteria4.setSize(14);
			 */

			Paragraph paragraph2criteria4 = new Paragraph("4.1 Physical Facilities", font2);
			paragraph2criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph2criteria4);

			/*
			 * Font font2criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * font2criteria4.setSize(12);
			 */

			PdfPTable table01criteria4 = new PdfPTable(1);

			table01criteria4.setWidthPercentage(100);
			PdfPCell cell0criteria4 = new PdfPCell(new Paragraph(
					"4.1.1 The institution has adequate infrastructure facilities for \r\n"
					+ "a. teaching - learning. viz., classrooms, laboratories, \r\n"
					+ "b. ICT enabled facilities such as smart classes, LMS etc.\r\n"
					+ "c. Facilities for cultural and sports activities , yoga centre, games \r\n"
					+ "(indoor and outdoor) gymnasium, auditorium etc..\r\n"
					+ "Response:"
							+ (criteria4Record != null
									? criteria4Record.getCriteria41Ql().get(0).getResponse411()
									: ""),
					font4));
			
			cell0criteria4.setExtraParagraphSpace(10f);

			table01criteria4.addCell(cell0criteria4);

		

			table01criteria4.setSpacingBefore(20f);
			table01criteria4.setSpacingAfter(20f);

			document.add(table01criteria4);


			
			PdfPTable table2 = new PdfPTable(2);
			table2.setWidthPercentage(100);

			PdfPCell cell001criteria4 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font4));
			cell001criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table2.addCell(cell001criteria4);
			PdfPCell cell002criteria4 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell002criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table2.addCell(cell002criteria4);
			PdfPCell cell003criteria4 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n ",font5));
			cell003criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table2.addCell(cell003criteria4);
			PdfPCell cell004criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell004criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell004criteria4.setExtraParagraphSpace(10f);
			
			table2.addCell(cell004criteria4);
	
			PdfPCell cell005criteria4 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n",font5));
			cell005criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table2.addCell(cell005criteria4);
			PdfPCell cell006criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell006criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell006criteria4.setExtraParagraphSpace(10f);
			
			table2.addCell(cell006criteria4);
			

			table2.setSpacingBefore(20f);
			table2.setSpacingAfter(20f);

			document.add(table2);

	
			// Creating a table of 3 columns
			PdfPTable table4criteria4 = new PdfPTable(2);
			PdfPTable table412criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table4criteria4.setWidthPercentage(100);
			table412criteria4.setWidthPercentage(100);

			PdfPCell cell007 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
			cell007.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table4criteria4.addCell(cell007);
			PdfPCell cell008 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell008.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4criteria4.addCell(cell008);
			
			
			PdfPCell cell0009 = new PdfPCell(new Paragraph(" Upload Any additional information\r\n\r\n",font5));
			cell0009.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			table4criteria4.addCell(cell0009);

			PdfPCell cell0010 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell0010.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell0010.setExtraParagraphSpace(10f);
			table4criteria4.addCell(cell0010);
	
			PdfPCell cell0011 = new PdfPCell(new Paragraph("Geotagged pictures\r\n\r\n",font5));
			cell0011.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table4criteria4.addCell(cell0011);
			PdfPCell cell0012 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell0012.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell0012.setExtraParagraphSpace(10f);
			table4criteria4.addCell(cell0012);
		
			PdfPCell cell0013 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n",font5));
			cell0013.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table4criteria4.addCell(cell0013);
			PdfPCell cell0014 = new PdfPCell(new Paragraph("",font5));
			cell0014.setHorizontalAlignment(Element.ALIGN_CENTER);
	
			table4criteria4.addCell(cell0014);

			PdfPCell cell412criteria4 = new PdfPCell(new Paragraph(
					"4.1.2 Percentage of expenditure excluding salary, for infrastructure \r\n"
					+ "development and augmentation during the last five years (INR in \r\n"
					+ "Lakhs)\r\n"
					+ "\r\n"
						 + "Response:"
							+ (criteria4Record != null
							? criteria4Record.getCriteria41Ql().get(0).getResponse412()
									: ""),
					font4));
			
			cell412criteria4.setExtraParagraphSpace(10f);

			table412criteria4.addCell(cell412criteria4);
			
			
			
			PdfPCell cell412criteria0004 = new PdfPCell(new Paragraph(
					"4.1.2.1: Expenditure for infrastructure development and augmentation \r\n"
					+ "excluding salary, during the last five years (INR in lakhs)\r\n"
					+ "\r\n"
						 + "Response:"
							+ (criteria4Record != null
							? criteria4Record.getCriteria41Ql().get(0).getInput412t1()
									: ""),
					font4));
			
			cell412criteria0004.setExtraParagraphSpace(10f);

			table412criteria4.addCell(cell412criteria0004);	
			
			
			
			
			
			
			
			document.add(table412criteria4);
			
			
			
			
			table4criteria4.setSpacingBefore(20F);
			table4criteria4.setSpacingAfter(20F);
			
			document.add(table4criteria4);
			
			// Creating a table of columns
			
			
			PdfPTable table5criteria4 = new PdfPTable(2);
			PdfPTable table51 = new PdfPTable(1);
			table5criteria4.setWidthPercentage(100);
			table51.setWidthPercentage(100);
		
			PdfPCell cell0015 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
			cell0015.setHorizontalAlignment(Element.ALIGN_CENTER);		
			table5criteria4.addCell(cell0015);
			
			PdfPCell cell0016 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell0016.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table5criteria4.addCell(cell0016);
			
			PdfPCell cell0017 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
			cell0017.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table5criteria4.addCell(cell0017);
	
			PdfPCell cell0018 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell0018.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell0018.setExtraParagraphSpace(10f);
			
			table5criteria4.addCell(cell0018);
	
			PdfPCell cell0019 = new PdfPCell(new Paragraph("\r\nProvide the link for additional informationt\r\n\r\n\r\n",font5));
			cell0019.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table5criteria4.addCell(cell0019);
		
			PdfPCell cell0020 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell0020.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell0020.setExtraParagraphSpace(10f);
			table5criteria4.addCell(cell0020);
		
			PdfPCell cell0021 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
			cell0021.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			table5criteria4.addCell(cell0021);
			
			
			
			PdfPCell cell0022 = new PdfPCell(new Paragraph());
			table5criteria4.addCell(cell0022);
		
           
		
			PdfPCell cell4120criteria4 = new PdfPCell(new Paragraph(
					"4.1.3 Availability of general campus facilities and overall ambience\r\n"
					+ "Response:"
							+ (criteria4Record != null
							? criteria4Record.getCriteria41Ql().get(0).getResponse413()
									: ""),font4));
			
			cell4120criteria4.setExtraParagraphSpace(10f);
			
	//		table51.addCell(cell4120criteria4);



		
			PdfPCell cell41200criteria4 = new PdfPCell(new Paragraph("4.1.3.1 Number of classrooms and seminar halls with ICT facilities\r\n Response: "
					+ (criteria4Record != null ? criteria4Record.getCriteria41Ql().get(0).getInput413t1() : ""),font4));
			
			cell41200criteria4.setExtraParagraphSpace(10f);
			
		//	table51.addCell(cell41200criteria4);
			

	

			document.add(table51);
			
			table5criteria4.setSpacingBefore(20f);
			table5criteria4.setSpacingAfter(20f);
			
			document.add(table5criteria4);
			// Creating a table of 3 columns
			

			
			PdfPTable table6criteria4 = new PdfPTable(2);
			
			
			PdfPTable table61criteria4 = new PdfPTable(1);
			table61criteria4.setWidthPercentage(100);
			if(criteria4Record.getCriteria41Ql().size() >0) {
			PdfPCell cell41201criteria4 = new PdfPCell(new Paragraph(
					"4.1.4 Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)\r\n"
							+ "\r\n" + "Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria41Ql().get(0).getResponse414()
									: ""),font4));
			
			cell41201criteria4.setExtraParagraphSpace(10f);
			
		//	table61criteria4.addCell(cell41201criteria4);
			}
			
			PdfPCell cell41202criteria4 = new PdfPCell(new Paragraph(
					"4.1.4.1 Expenditure for infrastructure augmentation, excluding salary year-wise during last five years (INR in lakhs)\r\n\r\n",font4));

			
			
			table61criteria4.addCell(cell41202criteria4);
			
	//		table61criteria4.addCell(table6criteria4);

		

	//		document.add(table61criteria4);
			
			

			if (criteria4Record.getYearTable4141().size() >0) {

				Table table4141 = new Table(criteria4Record.getYearTable4141().size(), 2);

				table4141.setPadding(5);
				table4141.setWidth(100f);

				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
					Cell cell1=new Cell(new Paragraph(criteria4Record.getYearTable4141().get(i).getInput4141y(),font5));
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4141.addCell(cell1);
				}
				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
					Cell cell2=new Cell(new Paragraph(criteria4Record.getYearTable4141().get(i).getInput4141v(),font5));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4141.addCell(cell2);
				}

			//	document.add(table4141);
			}

			
			

			if (criteria4Record.getYearTable41412().size() >0) {

				Table table41412 = new Table(criteria4Record.getYearTable41412().size(), 2);

				table41412.setPadding(5);
				table41412.setWidth(100f);

				for (int i = 0; i < criteria4Record.getYearTable41412().size(); i++) {
					Cell cell2=new Cell(new Paragraph(criteria4Record.getYearTable41412().get(i).getInput41412y(),font5));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table41412.addCell(cell2);
				}
				for (int i = 0; i < criteria4Record.getYearTable41412().size(); i++) {
					Cell cell3=new Cell(new Paragraph(criteria4Record.getYearTable41412().get(i).getInput41412v(),font5));
					cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table41412.addCell(cell3);
					
					
				}

	//		document.add(table41412);
			}
			
	////------------------------------------------------------------------->	/	
			// Creating a table of 3 columns
			PdfPTable table7criteria4 = new PdfPTable(2);

			// Setting width of table, its columns and spacing
			table7criteria4.setWidthPercentage(100);

			PdfPCell cell0033 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
			cell0033.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table7criteria4.addCell(cell0033);
		
			PdfPCell cell0034 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell0034.setHorizontalAlignment(Element.ALIGN_CENTER);
			table7criteria4.addCell(cell0034);
			PdfPCell cell0035 = new PdfPCell(
					new Paragraph("Upload any additional information\r\n\r\n ",font5));
			cell0035.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table7criteria4.addCell(cell0035);
		
		
			PdfPCell cell0036 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(4).getCriteria4FilePath() : "",font5));
			cell0036.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table7criteria4.addCell(cell0036);

			PdfPCell cell0037 = new PdfPCell(new Paragraph("Upload audited utilization statements\r\n\r\n",font5));
			cell0037.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table7criteria4.addCell(cell0037);
	
			PdfPCell cell0038 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(5).getCriteria4FilePath() : "",font5));
			cell0038.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell0038.setExtraParagraphSpace(10f);
			
			table7criteria4.addCell(cell0038);
			
			PdfPCell cell0039 = new PdfPCell(new Paragraph("Upload Details of Expenditure, excluding salary during the last five years\r\n\r\n",font5));
		
			cell0039.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table7criteria4.addCell(cell0039);
	
			PdfPCell cell0040 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell0040.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell0040.setExtraParagraphSpace(10f);
			table7criteria4.addCell(cell0040);
	
			
			

			table7criteria4.setSpacingBefore(20f);
			table7criteria4.setSpacingAfter(20f);

	//		document.add(table7criteria4);
            
			// 4.2 
			Paragraph paragraph31criteria4 = new Paragraph("4.2 Library as a Learning Resource\r\n", font2);
			paragraph31criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			paragraph31criteria4.setSpacingAfter(6F);
			paragraph31criteria4.setSpacingBefore(10F);
			document.add(paragraph31criteria4);
			

			PdfPTable table421criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table421criteria4.setWidthPercentage(100);

			PdfPCell cell00400 = new PdfPCell(new Paragraph(
					"4.2.1 Library is automated with digital facilities using Integrated Library \r\n"
					+ "Management System (ILMS), adequate subscription to e-resources \r\n"
					+ "and journals are made. The library is optimally used by the faculty \r\n"
					+ "and students"
					+ "Response:"
					+(criteria4Record != null
									? criteria4Record.getCriteria42Ql().get(0).getResponse421()
									: ""),font4));
			cell00400.setExtraParagraphSpace(10f);
			
			table421criteria4.addCell(cell00400);
			
			
			// table421criteria4.addCell(criteria4List.get(3).getResponseValue421());
			
			document.add(table421criteria4);

			

			
			


		

			// Creating a table of 3 columns
			PdfPTable table8criteria4 = new PdfPTable(2);

			// Setting width of table, its columns and spacing
			table8criteria4.setWidthPercentage(100);
			
	

			PdfPCell cell0041 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n", font4));
			cell0041.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table8criteria4.addCell(cell0041);
			PdfPCell cell0042 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n\r\n", font4));
			cell0042.setHorizontalAlignment(Element.ALIGN_CENTER);
			table8criteria4.addCell(cell0042);
			PdfPCell cell0043 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n\r\n",font5));
			
			cell0043.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table8criteria4.addCell(cell0043);
			if(criteria4file.size() >0) {
			PdfPCell cell0044 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell0044.setExtraParagraphSpace(10f);
			
			cell0044.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table8criteria4.addCell(cell0044);
		}
			PdfPCell cell0045 = new PdfPCell(new Paragraph("\r\nPaste Link for additional information\r\n\r\n\r\n ",font5));
			cell0045.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell0046 = new PdfPCell(new Paragraph(" "));
			cell0046.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			
			table8criteria4.addCell(cell0045);
			table8criteria4.addCell(cell0046);

			table8criteria4.setSpacingBefore(20f);
			table8criteria4.setSpacingAfter(20f);
			document.add(table8criteria4);

			// Creating a table of 3 columns
			PdfPTable table9criteria4 = new PdfPTable(2);
			PdfPTable table10criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table9criteria4.setWidthPercentage(100);
			table10criteria4.setWidthPercentage(100);

			PdfPCell cell0047 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
			cell0047.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table9criteria4.addCell(cell0047);
			
			
			PdfPCell cell0048 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell0048.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table9criteria4.addCell(cell0048);
			PdfPCell cell0049 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n",font5));
			cell0049.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table9criteria4.addCell(cell0049);
			if(criteria4file.size() >0) {
			PdfPCell cell0050 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : "",font5));
			cell0050.setExtraParagraphSpace(10f);
			
			cell0050.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table9criteria4.addCell(cell0050);
			}
			PdfPCell cell0051 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n",font5));
			cell0051.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria4.addCell(cell0051);
			
			if(criteria4file.size()>0)
			{
			PdfPCell cell0052 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : "",font5));
			cell0052.setExtraParagraphSpace(10);
			cell0052.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell0052.setExtraParagraphSpace(10);
			table9criteria4.addCell(cell0052);
			}

			
			PdfPCell cell00510 = new PdfPCell(new Paragraph(
					"4.2.2 Percentage expenditure for purchase of books/ e-books and \r\n"
					+ "subscription to journals/e-journals during the last five years (INR in \r\n"
					+ "Lakhs)\r\n"
						 + "Response:"
							+ (criteria4Record != null
									? criteria4Record.getCriteria42Qn().get(0).getResponse422()
									: ""),font4));
			cell00510.setExtraParagraphSpace(10f);
			
			table10criteria4.addCell(cell00510);
			
			
			
			PdfPCell cell00511110 = new PdfPCell(new Paragraph(
					"4.2.2.1: Annual expenditure for purchase of books and journals yearwise during the last five years (INR in lakhs)",font4));
			cell00511110.setExtraParagraphSpace(10f);
			
			table10criteria4.addCell(cell00511110);
			
			
	//		table10criteria4.addCell(table9criteria4);
			
			
			table9criteria4.setSpacingBefore(20f);
			table9criteria4.setSpacingAfter(20f);
			
			document.add(table9criteria4);
		

			document.add(table10criteria4);
			
			
			
			
			if (criteria4Record != null) {

				Table table4231 = new Table(criteria4Record.getYearTable4231().size(), 2);

				table4231.setPadding(5);
				table4231.setWidth(100f);

				for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
					Cell cell4=new Cell(new Paragraph((criteria4Record.getYearTable4231().get(i).getInput4231y()),font5));
					cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4231.addCell(cell4);
				}
				for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
					Cell cell5=new Cell(new Paragraph((criteria4Record.getYearTable4231().get(i).getInput4231v()),font5));
					cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4231.addCell(cell5);
				}

				document.add(table4231);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

			// Creating a table of 3 columns
			PdfPTable table11criteria4 = new PdfPTable(2);
			PdfPTable table12criteria4 = new PdfPTable(1);

			table11criteria4.setWidthPercentage(100);
			table12criteria4.setWidthPercentage(100);
			PdfPCell cell0065 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			
			cell0065.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table11criteria4.addCell(cell0065);
			PdfPCell cell0066 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell0066.setHorizontalAlignment(Element.ALIGN_CENTER);
			table11criteria4.addCell(cell0066);
			PdfPCell cell0067 = new PdfPCell(new Paragraph(
					"Institutional data in prescribed format\r\n\r\n",font5));
			cell0067.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table11criteria4.addCell(cell0067);
			if(criteria4file.size() >0)
			{
			PdfPCell cell0068 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
			cell0068.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell0068.setExtraParagraphSpace(2f);
			table11criteria4.addCell(cell0068);
			}
			PdfPCell cell0069 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n",font5));
			cell0069.setHorizontalAlignment(Element.ALIGN_CENTER);
			
	
			
			table11criteria4.addCell(cell0069);
			if(criteria4file.size() >0)
			{
			PdfPCell cell0070 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
			
			
			cell0070.setExtraParagraphSpace(10f);
			cell0070.setHorizontalAlignment(Element.ALIGN_CENTER);
			table11criteria4.addCell(cell0070);
		
			
			}
			
		
if(criteria4Record.getCriteria42Qn().size() >0)
{
			PdfPCell cell005101 = new PdfPCell(new Paragraph(
					"4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n"
						 + "Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria42Qn().get(0).getResponse423()
									: ""),font4));
			cell005101.setExtraParagraphSpace(10f);
			
			table12criteria4.addCell(cell005101);
}
			
			PdfPCell cell0051011 = new PdfPCell(new Paragraph(
					"4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)"
							+ "\r\n"
							+ "\r\n"
							,font4));
			
			
			table12criteria4.addCell(cell0051011);
			
			
			
	//		table12criteria4.addCell(table11criteria4);
			
		
			

			table11criteria4.setSpacingBefore(20f);
			table11criteria4.setSpacingAfter(20f);
			
			
			document.add(table11criteria4);

	//		document.add(table12criteria4);
			
			
			

	

			// Creating a table of 3 columns

			PdfPTable table13 = new PdfPTable(2);

			// Setting width of table, its columns and spacing
			table13.setWidthPercentage(100);

		

			table13.setSpacingBefore(20f);
			table13.setSpacingAfter(20f);

		//	document.add(table13);

			// Creating a table of 3 columns
			PdfPTable table14criteria4 = new PdfPTable(2);
			PdfPTable table15 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table14criteria4.setWidthPercentage(100);
			table15.setWidthPercentage(100);

			PdfPCell cell0075 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell0075.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table14criteria4.addCell(cell0075);
			PdfPCell cell0076 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell0076.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table14criteria4.addCell(cell0076);
			PdfPCell cell0077 = new PdfPCell(new Paragraph("Details of library usage by teachers and students\r\n\r\n", font5));
			cell0077.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table14criteria4.addCell(cell0077);
			if(criteria4file .size()>0) {
			PdfPCell cell0078 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "", font5));
			cell0078.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell0078.setExtraParagraphSpace(10f);
			
			table14criteria4.addCell(cell0078);
			}
			PdfPCell cell0079 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n", font5));
			cell0079.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table14criteria4.addCell(cell0079);
			if(criteria4file.size()>0) {
			PdfPCell cell0080 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "", font5));
			cell0080.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell0080.setExtraParagraphSpace(10f);
			table14criteria4.addCell(cell0080);
			}
			PdfPCell cell00770 = new PdfPCell(new Paragraph(
					"4.2.4 Percentage per day usage of library by teachers and students ( foot falls and login data for online access) during the latest completed academic year\r\n"
					 + "Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria42Qn().get(0).getResponse424()
									: ""), font4));
			
			cell00770.setExtraParagraphSpace(10f);
			cell00770.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		//	table15.addCell(cell00770);


			PdfPCell cell007701 = new PdfPCell(new Paragraph(("4.2.4.1 Number of teachers and students using library per day over last one year\r\n" 
					+ "Response: "
					+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getInput4241t1() : "")),font4));
			cell007701.setExtraParagraphSpace(10f);
			table15.addCell(cell007701);
		//	table15.addCell(table14criteria4);
			
	

			table14criteria4.setSpacingBefore(20f);
			table14criteria4.setSpacingAfter(20f);
			
		//	document.add(table14criteria4);

	//		document.add(table15);
			
			
			// 4.3 
			
			Paragraph paragraph38criteria4 = new Paragraph("4.3 IT Infrastructure\r\n\r\n", font2);
			paragraph38criteria4.setSpacingAfter(2f);
			paragraph38criteria4.setSpacingBefore(2f);
			
			paragraph38criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph35 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph35.setSize(12);
			 */

			Paragraph paragraph39criteria4 = new Paragraph(
					"4.3.1	Institution frequently updates its IT facilities and provides sufficient \r\n"
					+ "bandwidth for internet connection"
					+ (criteria4Record != null
					? criteria4Record.getCriteria43Ql().get(0).getResponse431()
					: "")		,font4);
			paragraph39criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			


			document.add(paragraph38criteria4);
			document.add(paragraph39criteria4);
			
			// Creating a table of 3 columns

			
			PdfPTable table17criteria4 = new PdfPTable(2);
			PdfPTable table16criteria4 = new PdfPTable(1);
			table17criteria4.setWidthPercentage(100);
			table16criteria4.setWidthPercentage(100);
			// Setting width of table, its columns and spacing
			
		

			PdfPCell cell0091 = new PdfPCell(new Paragraph("File Description\r\n", font4));
			cell0091.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table17criteria4.addCell(cell0091);
			
			PdfPCell cell0092 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell0092.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table17criteria4.addCell(cell0092);
		
			
			PdfPCell cell0093 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n",font5));
			cell0093.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table17criteria4.addCell(cell0093);
		
			PdfPCell cell0094 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
			cell0094.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell0094.setExtraParagraphSpace(10f);
			
			
			table17criteria4.addCell(cell0094);
		
			PdfPCell cell0095 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n",font5));
			cell0095.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell0096 = new PdfPCell(new Paragraph(" ",font5));
			cell0096.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			
			table17criteria4.addCell(cell0095);
			table17criteria4.addCell(cell0096);
			
			
			table17criteria4.setSpacingAfter(20f);
			table17criteria4.setSpacingBefore(20f);
			
			
			document.add(table17criteria4);

			PdfPCell cell431criteria4 = new PdfPCell(new Paragraph(
					"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n"
						 + "Response:"
							+ (criteria4Record != null
									? criteria4Record.getCriteria43Ql().get(0).getResponse431()
									: ""),font4));
			cell431criteria4.setExtraParagraphSpace(10f);
			
			PdfPCell cell4311criteria4 = new PdfPCell(new Paragraph(
					"4.3.1.1 Number of classrooms and seminar halls with ICT facilities\r\n"
					+ "Response:"
							+ (criteria4Record != null
									? criteria4Record.getCriteria43Ql().get(0).getInput431t1()
									: ""),font4));
			cell4311criteria4.setExtraParagraphSpace(10f);
		//	table16criteria4.addCell(cell431criteria4);
		//	table16criteria4.addCell(cell4311criteria4);
			
			
		//	table16criteria4.addCell(table17criteria4);
			
	
			
			document.add(table16criteria4);
			
			
			

			// Creating a table of 3 columns
			PdfPTable table18criteria4 = new PdfPTable(2);
			PdfPTable table19criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table18criteria4.setWidthPercentage(100);
			table19criteria4.setWidthPercentage(100);

			PdfPCell cell0097 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell0097.setHorizontalAlignment(Element.ALIGN_CENTER);
			table18criteria4.addCell(cell0097);
			PdfPCell cell0098 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell0098.setHorizontalAlignment(Element.ALIGN_CENTER);
			table18criteria4.addCell(cell0098);
			PdfPCell cell0099 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n",font5));
			cell0099.setHorizontalAlignment(Element.ALIGN_CENTER);
			table18criteria4.addCell(cell0099);
		
			PdfPCell cell00100 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
			cell00100.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00100.setExtraParagraphSpace(10f);
			
			table18criteria4.addCell(cell00100);
			

			PdfPCell cell00991 = new PdfPCell(new Paragraph("4.3.2 Student - Computer ratio (Data to be provided only for the latest \r\n"
					+ "completed academic year)\r\n"+ "Response:"
					+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse432()
							: ""),font4));
			cell00991.setExtraParagraphSpace(10f);

			table19criteria4.addCell(cell00991);
			
			
			
			PdfPCell cell009911 = new PdfPCell(new Paragraph("4.3.2.1  Number of computers available for student use)\r\n"+ "Response:"
					+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getInput432t1()
							: ""),font4));
			cell009911.setExtraParagraphSpace(10f);

			table19criteria4.addCell(cell00991);		
			
			
			
			
			
			
			
			
			
			
			
		//	table19criteria4.addCell(table18criteria4);

			table18criteria4.setSpacingBefore(20f);
			table18criteria4.setSpacingAfter(20f);

			document.add(table18criteria4);
			
			document.add(table19criteria4);

			// Creating a table of 3 columns

			PdfPTable table20criteria4 = new PdfPTable(2);
			PdfPTable table21criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table20criteria4.setWidthPercentage(100);
			table21criteria4.setWidthPercentage(100);

			PdfPCell cell00103 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell00103.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table20criteria4.addCell(cell00103);
			PdfPCell cell00104 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell00104.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table20criteria4.addCell(cell00104);
			
			
			PdfPCell cell00105 = new PdfPCell(new Paragraph("Upload any additional information	",font5));
			cell00105.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table20criteria4.addCell(cell00105);
			
			PdfPCell cell00106 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
			cell00106.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00106.setExtraParagraphSpace(10f);
			
			table20criteria4.addCell(cell00106);
             
             PdfPCell cell0106 = new PdfPCell(new Paragraph("Student - computer ratio",font5));
             cell0106.setHorizontalAlignment(Element.ALIGN_CENTER);
             
             
             table20criteria4.addCell(cell0106);
             
             PdfPCell cell01106 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
             cell01106.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell01106.setExtraParagraphSpace(10f);
             
             table20criteria4.addCell(cell01106);
	

			PdfPCell cell001040 = new PdfPCell(new Paragraph("4.3.3Institution has the following Facilities for e-content and other \r\n"
					+ "resource development"
					+ "1. Audio visual center, mixing equipment, editing facilities and \r\n"
					+ "Media Studio\r\n"
					+ "2. Lecture Capturing System(LCS)\r\n"
					+ "3. Central Instrumentation Centre\r\n"
					+ "4. Animal House\r\n"
					+ "5. Museum\r\n"
					+ "6. Business Lab\r\n"
					+ "7. Research/statistical database\r\n"
					+ "8. Moot court\r\n"
					+ "9. Theatre\r\n"
					+ "10. Art Gallery\r\n"
					+ "11. Any other facility to support research\r\n"
					+ "Options:\r\n"
					+ "A. Any 7 or more of the above\r\n"
					+ "B. Any 6 of the above\r\n"
					+ "C. Any 5 of the above\r\n"
					+ "D. Any 3-4 of the above\r\n"
					+ "E. Any 2 or below\r\n" + "Response:"
					+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse433()
							: ""),font4));
			
			cell001040.setExtraParagraphSpace(10f);

			cell001040.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

			table21criteria4.addCell(cell001040);
			
		//	table21criteria4.addCell(table20criteria4);
			
			table20criteria4.setSpacingAfter(20f);
			table20criteria4.setSpacingBefore(20f);
			
			
			document.add(table20criteria4);
			
			
			document.add(table21criteria4);
			
			
			PdfPTable table434criteria4 = new PdfPTable(2);
			PdfPTable table4341criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table434criteria4.setWidthPercentage(100);
			table4341criteria4.setWidthPercentage(100);

			PdfPCell cell001031 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
			cell001031.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table434criteria4.addCell(cell001031);
			PdfPCell cell001042 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell001042.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table434criteria4.addCell(cell001042);
			PdfPCell cell001053 = new PdfPCell(
					new Paragraph("Upload any additional information\r\n\r\n\r\n",font5));
			cell001053.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table434criteria4.addCell(cell001053);
			
			PdfPCell cell001064 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
			cell001064.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell001064.setExtraParagraphSpace(10f);
			
			
			table434criteria4.addCell(cell001064);

			PdfPCell cell0010531 = new PdfPCell(
					new Paragraph("Details of available bandwidth of internet connection in the Institution\r\n\r\n\r\n",font5));
		
			cell0010531.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			table434criteria4.addCell(cell0010531);
			
			PdfPCell cell0010641 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));

			cell0010641.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell0010641.setExtraParagraphSpace(10f);
			
			
			table434criteria4.addCell(cell0010641);
		
			PdfPCell cell0010421 = new PdfPCell(new Paragraph("4.3.4 Available bandwidth of internet connection in the Institution (Leased line)\r\n"
		 + "Response:"
					+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse434()
							: ""),font4));
			cell0010421.setExtraParagraphSpace(10f);
			cell0010421.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			
			
			// table21criteria4.addCell(criteria4List.get(0).getResponseValue433());
			
	//		table4341criteria4.addCell(cell0010421);
		//	table4341criteria4.addCell(table434criteria4);
			
			
			document.add(table434criteria4);
			document.add(table4341criteria4);

			// Creating a table of 3 columns

			PdfPTable table22criteria4 = new PdfPTable(2);
			PdfPTable table23criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table22criteria4.setWidthPercentage(100);
			table23criteria4.setWidthPercentage(100);

			PdfPCell cell00107 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
			cell00107.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table22criteria4.addCell(cell00107);
			PdfPCell cell00108 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell00108.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table22criteria4.addCell(cell00108);
			
			
			PdfPCell cell00109 = new PdfPCell(new Paragraph("Upload any additional information	",font5));
			cell00109.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table22criteria4.addCell(cell00109);
		
			PdfPCell cell00110 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
			cell00110.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00110.setExtraParagraphSpace(10f);
			
			table22criteria4.addCell(cell00110);
	
			PdfPCell cell00111 = new PdfPCell(new Paragraph("Provide links to the photographs",font5));
			cell00111.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table22criteria4.addCell(cell00111);
		
			PdfPCell cell00112 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
			cell00112.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00112.setExtraParagraphSpace(10f);
			
			table22criteria4.addCell(cell00112);
		
			PdfPCell cell001111 = new PdfPCell(new Paragraph("Facilities for e-content development such as Media Centre, Recording facility, LCS etc (Data Templates as in 3.4.7)",font5));
			cell001111.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table22criteria4.addCell(cell001111);
			PdfPCell cell00013 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
			cell00013.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00013.setExtraParagraphSpace(10f);
			
			table22criteria4.addCell(cell00013);
			

			

			PdfPCell cell001110 = new PdfPCell(new Paragraph("4.3.5	Institution has the following Facilities for e-content development\r\n"
					+ "1.	Media centre\r\n" + "2.	Audio visual centre\r\n" + "3.	Lecture Capturing System(LCS)\r\n"
					+ "4.	Mixing equipments and softwares for editing\r\n" + "Response: "
					+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse434()
							: ""),font4));
			
			cell001110.setExtraParagraphSpace(10f);

			// table23criteria4.addCell(criteria4List.get(0).getResponseValue434());
			table23criteria4.addCell(cell001110);
		//	table23criteria4.addCell(table22criteria4);

			table22criteria4.setSpacingBefore(20f);
			table22criteria4.setSpacingAfter(20f);
		//	document.add(table22criteria4);
			
		//	document.add(table23criteria4);

        // 4.4 
			
			
			Paragraph paragraph50 = new Paragraph("4.4 Maintenance of Campus Infrastructure\r\n" + "", font2);
			paragraph50.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph50);

			// Creating a table of 3 columns

			
			PdfPTable table25criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			
			table25criteria4.setWidthPercentage(100);

			PdfPCell cell001091 = new PdfPCell(new Paragraph(
					"4.4.1 Percentage expenditure incurred on maintenance of physical \r\n"
					+ "facilities and academic support facilities excluding salary \r\n"
					+ "component during the last five years \r\n"
							+ " Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria44Ql().get(0).getResponse441()
									: ""),font4));
			
			cell001091.setExtraParagraphSpace(10f);
/////////////////////--------------------------------------------------------------------------------------------->
			// table25criteria4.addCell(criteria4List.get(0).getResponseValue441());

			PdfPCell cell0010911 = new PdfPCell(new Paragraph(
					"4.4.1.1 Expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component year wise during the last five years (INR in lakhs)\r\n\r\n",font4));

			table25criteria4.addCell(cell001091);
			table25criteria4.addCell(cell0010911);
			
			table25criteria4.setSpacingBefore(20f);
			table25criteria4.setSpacingAfter(20f);

			document.add(table25criteria4);

			if (criteria4Record != null) {

				Table table4411 = new Table(criteria4Record.getYearTable4411().size(), 2);

				table4411.setPadding(5);
				table4411.setWidth(100f);

				for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
					Cell cell6=new Cell(new Paragraph(criteria4Record.getYearTable4411().get(i).getInput4411y(),font5));
					cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4411.addCell(cell6);
				}
				for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
					Cell cell7=new Cell(new Paragraph(criteria4Record.getYearTable4411().get(i).getInput4411v(),font5));
					cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4411.addCell(cell7);
				}

				document.add(table4411);

			}
			

			if (criteria4Record.getYearTable44112().size()>0 ) {

				Table table44112 = new Table(criteria4Record.getYearTable44112().size(), 2);

				table44112.setPadding(5);
				table44112.setWidth(100f);

				for (int i = 0; i < criteria4Record.getYearTable44112().size(); i++) {
					Cell cell8=new Cell(new Paragraph((criteria4Record.getYearTable44112().get(i).getInput44112y()),font5));
					cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
					table44112.addCell(cell8);
				}
				for (int i = 0; i < criteria4Record.getYearTable44112().size(); i++) {
					Cell cell9=new Cell(new Paragraph((criteria4Record.getYearTable44112().get(i).getInput44112v()),font5));
					cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
					table44112.addCell(cell9);
				}

				document.add(table44112);

			}

			PdfPTable table26criteria4 = new PdfPTable(2);
			table26criteria4.setWidthPercentage(100);

			PdfPCell cell00123 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
			cell00123.setHorizontalAlignment(Element.ALIGN_CENTER);
			table26criteria4.addCell(cell00123);
			PdfPCell cell00124 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell00124.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table26criteria4.addCell(cell00124);
			
			PdfPCell cell00125 = new PdfPCell(new Paragraph("Upload any additional information	",font5));
			cell00125.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			table26criteria4.addCell(cell00125);
			
			
		
			PdfPCell cell00126 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell00126.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00126.setExtraParagraphSpace(10f);
			table26criteria4.addCell(cell00126);
	
			PdfPCell cell00127 = new PdfPCell(new Paragraph("Audited statements of accounts",font5));
			cell00127.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			table26criteria4.addCell(cell00127);
		
			PdfPCell cell00128 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell00128.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00128.setExtraParagraphSpace(10f);
			
			table26criteria4.addCell(cell00128);
		
			PdfPCell cell000127 = new PdfPCell(new Paragraph("Details about assigned budget and expenditure on physical facilities and academic facilities",font5));
			cell000127.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			table26criteria4.addCell(cell000127);
		
			PdfPCell cell000128 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell000128.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell000128.setExtraParagraphSpace(10f);
			
			table26criteria4.addCell(cell000128);
		
			
			
			
			table26criteria4.setSpacingAfter(20f);
			
			table26criteria4.setSpacingBefore(20f);
			
			document.add(table26criteria4);

			/*
			 * Font fontParagraph47 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph47.setSize(12);
			 */
			
			
			
			PdfPTable table26criteria004 = new PdfPTable(1);
			table26criteria004.setWidthPercentage(100);
			

			PdfPCell cell000122228 = new PdfPCell(new Paragraph(
					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\r\n"
				 + "Response:"
							+ (criteria4Record != null
									? criteria4Record.getCriteria44Ql().get(0).getResponse442()
									: ""),
					font4));
			cell000122228.setExtraParagraphSpace(10f);
	
			table26criteria004.addCell(cell000122228);
			document.add(table26criteria004);
			
			PdfPTable table442criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table442criteria4.setWidthPercentage(100);

			PdfPCell cell001271 = new PdfPCell(new Paragraph(
					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\\r\\n\"\r\n"
				 + "Response:"
							+ (criteria4Record != null
									? criteria4Record.getCriteria44Ql().get(0).getResponse442()
									: ""),font4));
			cell001271.setExtraParagraphSpace(10f);
			// table442criteria4.addCell(criteria4List.get(0).getResponseValue442());
			//table442criteria4.addCell(cell001271);

		//	document.add(table442criteria4);

		

			

			PdfPTable table27criteria4 = new PdfPTable(2);
			table27criteria4.setWidthPercentage(100);

			PdfPCell cell00129 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
			cell00129.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table27criteria4.addCell(cell00129);
			PdfPCell cell00130 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell00130.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00130.setExtraParagraphSpace(10f);
			
			table27criteria4.addCell(cell00130);
			PdfPCell cell00131 = new PdfPCell(new Paragraph("Upload any additional information",font5));
			cell00131.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00131.setExtraParagraphSpace(10f);
			
			table27criteria4.addCell(cell00131);
			if(criteria4file.size()>0) {
			PdfPCell cell00132 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell00132.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00132.setExtraParagraphSpace(10f);
			
			table27criteria4.addCell(cell00132);
			}
			PdfPCell cell00133 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n",font5));
			cell00133.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell00134 = new PdfPCell(new Paragraph(" ",font5));
			cell00134.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table27criteria4.addCell(cell00133);
			table27criteria4.addCell(cell00134);

			table27criteria4.setSpacingBefore(20f);
			table27criteria4.setSpacingAfter(20f);

			document.add(table27criteria4);

	
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
