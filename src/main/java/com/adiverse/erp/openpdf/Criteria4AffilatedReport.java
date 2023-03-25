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
public class Criteria4AffilatedReport {

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
//			allParams.put("financialYear",criteria4Fieldinfo.getCriteriaId().getFinancialYear() );
//			allParams.put("typeofInstitution", criteria4Fieldinfo.getCriteriaId().getTypeofInstitution());

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
				reportPath = "Criteria4AffilatedReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

			// 4.1
			Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources\r\n\r\n",
					font1);
			paragraph1criteria4.setAlignment(Paragraph.ALIGN_CENTER);

			document.add(paragraph1criteria4);

			Paragraph paragraph2criteria4 = new Paragraph("4.1 Physical Facilities", font2);
			paragraph2criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph2criteria4);

			PdfPTable table01criteria4 = new PdfPTable(1);

			table01criteria4.setWidthPercentage(100);

			PdfPCell cell0criteria4 = new PdfPCell(new Paragraph(
					"4.1.1 Availability of adequate infrastructure and physical facilities viz., classrooms, laboratories, ICT infrastructure, facilities for cultur and sports activities, gymnasium, yoga centre etc. in the institution\r\n"
							+ "\r\n" + "Response: "
							+ (criteria4Record != null ? criteria4Record.getCriteria41Ql().get(0).getResponse411() : "")
							+ "\r\n\r\n",
					font4));
			table01criteria4.addCell(cell0criteria4);

			// table101criteria5.addCell(table010criteria5);

			table01criteria4.setSpacingBefore(20f);
			table01criteria4.setSpacingAfter(20f);

			document.add(table01criteria4);

			PdfPTable table2 = new PdfPTable(2);
			table2.setWidthPercentage(100);

			PdfPCell cell001criteria4 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell001criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell001criteria4.setExtraParagraphSpace(10);
			table2.addCell(cell001criteria4);

			PdfPCell cell002criteria4 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell002criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell002criteria4.setExtraParagraphSpace(10);
			table2.addCell(cell002criteria4);

			PdfPCell cell003criteria4 = new PdfPCell(
					new Paragraph("\r\nUpload Any additional information\r\n\r\n ", font5));
			cell003criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell003criteria4.setExtraParagraphSpace(10);
			table2.addCell(cell003criteria4);

			if (criteria4file.size() > 0) {
				PdfPCell cell004criteria4 = new PdfPCell(new Paragraph("\r\n"
						+ (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
						font5));
				table2.addCell(cell004criteria4);
			}
			PdfPCell cell005criteria4 = new PdfPCell(
					new Paragraph("\r\nPaste link for additional information\r\n\r\n", font5));
			cell005criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell005criteria4.setExtraParagraphSpace(10);

			PdfPCell cell006criteria4 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell006criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell006criteria4.setExtraParagraphSpace(10);

			table2.addCell(cell005criteria4);
			table2.addCell(cell006criteria4);

			table2.setSpacingBefore(20f);
			table2.setSpacingAfter(20f);

			document.add(table2);

//			Paragraph paragraph13criteria4 = new Paragraph(
//					"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)"+"\r\n",
//					font4);
//			paragraph13criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
//			Paragraph paragraph14criteria4 = new Paragraph("Response: "
//					+ (criteria4Record != null ? criteria4Record.getCriteria41Ql().get(0).getResponse412()
//							: "")+"\r\n\r\n",
//					font5);
//			paragraph14criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//
//			// Creating a table of 3 columns
//			PdfPTable table4criteria4 = new PdfPTable(2);
			PdfPTable table412criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table4criteria4.setWidthPercentage(100);
			table412criteria4.setWidthPercentage(100);
//
//			PdfPCell cell007 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
//			cell007.setHorizontalAlignment(Element.ALIGN_CENTER);
//		//	cell007.setExtraParagraphSpace(10);
//			
//			table4criteria4.addCell(cell007);
//			
//			PdfPCell cell008 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//			cell008.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell008.setExtraParagraphSpace(10);
//			table4criteria4.addCell(cell008);
//			
//			PdfPCell cell0009 = new PdfPCell(new Paragraph(" \r\nUpload Any additional information\r\n\r\n",font5));
//			cell0009.setHorizontalAlignment(Element.ALIGN_CENTER);
//		//	cell0009.setExtraParagraphSpace(10);
//			table4criteria4.addCell(cell0009);
//			
//			if(criteria4file.size() >0)
//			{
//			PdfPCell cell0010 = new PdfPCell(
//					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
//			cell0010.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell0010.setExtraParagraphSpace(10);
//			table4criteria4.addCell(cell0010);
//			}
//			
//			PdfPCell cell0011 = new PdfPCell(new Paragraph("\r\nGeotagged pictures\r\n\r\n",font5));
//			cell0011.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell0011.setExtraParagraphSpace(10);
//			table4criteria4.addCell(cell0011);
//			
//			if(criteria4file.size() >0)
//			{
//			PdfPCell cell0012 = new PdfPCell(
//					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
//			cell0012.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell0012.setExtraParagraphSpace(10);
//			table4criteria4.addCell(cell0012);
//			}
//			
//			PdfPCell cell0013 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n",font5));
//			cell0013.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell0013.setExtraParagraphSpace(10);
//			
//			PdfPCell cell0014 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
//			
//
//			
//			
//			table4criteria4.addCell(cell0013);
//			table4criteria4.addCell(cell0014);

			PdfPCell cell412criteria4 = new PdfPCell(new Paragraph(
					"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)\r\n"
							+ "\r\n\r\n" + "Response: "
							+ (criteria4Record != null ? criteria4Record.getCriteria41Ql().get(0).getResponse412() : "")
							+ "\r\n\r\n",
					font4));

			table412criteria4.addCell(cell412criteria4);
			// table412criteria4.addCell(table4criteria4);
			table412criteria4.setSpacingBefore(20f);
			table412criteria4.setSpacingAfter(20f);

			document.add(table412criteria4);
			
			Paragraph paragraph13criteria4 = new Paragraph(
					"4.1.2.1 Expenditure for infrastructure augmentation, excluding salary year wise during last five years (INR in lakhs))"+"\r\n",
					font4);
			paragraph13criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph13criteria4);
			
			
			
			if (criteria4Record.getAffiliatedYearTable4121().size() > 0) {

				Table table4121 = new Table(criteria4Record.getAffiliatedYearTable4121().size(), 2);

				table4121.setPadding(10);
				table4121.setWidth(100f);

				for (int i = 0; i < criteria4Record.getAffiliatedYearTable4121().size(); i++) {
					Cell cell1criteria4141 = new Cell(criteria4Record.getAffiliatedYearTable4121().get(i).getInput4121y());
					cell1criteria4141.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4121.addCell(cell1criteria4141);

				}
				for (int i = 0; i < criteria4Record.getAffiliatedYearTable4121().size(); i++) {
					Cell cell2criteria4141 = new Cell(criteria4Record.getAffiliatedYearTable4121().get(i).getInput4121v());
					cell2criteria4141.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4121.addCell(cell2criteria4141);

				}

				document.add(table4121);
			
			}
			
			
			Paragraph paragraph3001criteria4 = new Paragraph("\r\n");
			document.add(paragraph3001criteria4);
			

			// Creating a table of columns
			PdfPTable table5criteria4 = new PdfPTable(2);
			PdfPTable table413 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table5criteria4.setWidthPercentage(100);
			table413.setWidthPercentage(100);

			PdfPCell cell0015 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
			cell0015.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0015.setExtraParagraphSpace(10);
			table5criteria4.addCell(cell0015);

			PdfPCell cell0016 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell0016.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0016.setExtraParagraphSpace(10);
			table5criteria4.addCell(cell0016);

			PdfPCell cell0017 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n", font5));
			cell0017.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0017.setExtraParagraphSpace(10);
			table5criteria4.addCell(cell0017);

			if (criteria4file.size() > 0) {
				PdfPCell cell0018 = new PdfPCell(new Paragraph(
						criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "", font5));
				cell0018.setHorizontalAlignment(Element.ALIGN_CENTER);
				// cell0018.setExtraParagraphSpace(10);
				table5criteria4.addCell(cell0018);
			}

			document.add(table5criteria4);

			

			
			
			
			
			
			
			
			
//			

//			PdfPCell cell413criteria4 = new PdfPCell(new Paragraph(
//					"4.1.3 Percentage of classrooms and seminar halls with ICT- enabled facilities such as smart class, LMS, etc. (Data for the latest completed academic year)\r\n"
//							+ "\r\n" + "Response: "
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria43Ql().get(0).getResponse431()
//									: "")+"\r\n\r\n",font4));
//			
//			table413.addCell(cell413criteria4);
			// document.add(table413);

//			PdfPCell cell4131criteria4 = new PdfPCell(new Paragraph("4.1.3.1 Number of classrooms and seminar halls with ICT facilities" + "\r\n\r\n"
//					+ (criteria4Record != null ? criteria4Record.getCriteria43Ql().get(0).getInput431t1() : "")+"\r\n\r\n",font4));
//			
//			PdfPCell cell41312criteria4 = new PdfPCell(new Paragraph("4.1.3.12: Number of classrooms and seminar halls in the Institution" + "\r\n\r\n"
//					+ (criteria4Record != null ? criteria4Record.getCriteria43Ql().get(0).getInput431t2() : "")+"\r\n\r\n",font4));

//			table51.addCell(cell4131criteria4);
//			table51.addCell(cell41312criteria4);
//		
			// table51.addCell(table5criteria4);

			// document.add(table51);

//		PdfPTable table414criteria4 = new PdfPTable(1);
//		PdfPTable table4141criteria4 = new PdfPTable(1);	
//		
//		
//		table414criteria4.setWidthPercentage(100);
//		table4141criteria4.setWidthPercentage(100);
//		
//
//		PdfPCell cell414criteria4 = new PdfPCell(new Paragraph(
//					"4.1.4 Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)\r\n"
//							+ "\r\n" + "Response: "
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria41Ql().get(0).getResponse414()
//									: "")+"\r\n\r\n",font4));
//
//		table414criteria4.addCell(cell414criteria4);
//
//		PdfPCell cell4141criteria4 = new PdfPCell(new Paragraph(
//					"4.1.4.1 Expenditure for infrastructure augmentation, excluding salary year-wise during last five years (INR in lakhs)\r\n\r\n",font4));
//
//			// table61.addCell(table6);
//		table4141criteria4.addCell(cell4141criteria4);
//		
//		table4141criteria4.setSpacingBefore(20f);
//		table4141criteria4.setSpacingAfter(20f);
//
//		document.add(table414criteria4);
//			document.add(table4141criteria4);
//
//			if (criteria4Record.getYearTable4141().size()>0) {
//
//				Table table4141 = new Table(criteria4Record.getYearTable4141().size(), 2);
//
//				table4141.setPadding(10);
//				table4141.setWidth(100f);
//
//				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
//					Cell cell1criteria4141 = new Cell (criteria4Record.getYearTable4141().get(i).getInput4141y());
//					cell1criteria4141.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table4141.addCell(cell1criteria4141);
//					
//
//				}
//				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
//					Cell cell2criteria4141 = new Cell (criteria4Record.getYearTable4141().get(i).getInput4141v());
//					cell2criteria4141.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table4141.addCell(cell2criteria4141);
//					
//
//				}
//
//				document.add(table4141);
//			}
//			
//			
//			
//
//			if (criteria4Record.getYearTable41412().size()>0) {
//
//				Table table41412 = new Table(criteria4Record.getYearTable41412().size(), 2);
//
//				table41412.setPadding(10);
//				table41412.setWidth(100f);
//
//				for (int i = 0; i < criteria4Record.getYearTable41412().size(); i++) {
//					Cell cell1criteria41412 = new Cell (criteria4Record.getYearTable41412().get(i).getInput41412y());
//					cell1criteria41412.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table41412.addCell(cell1criteria41412);
//					
//
//				}
//				for (int i = 0; i < criteria4Record.getYearTable41412().size(); i++) {
//					Cell cell2criteria41412 = new Cell (criteria4Record.getYearTable41412().get(i).getInput41412v());
//					cell2criteria41412.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table41412.addCell(cell2criteria41412);
//					
//
//				}
//
//				document.add(table41412);
//			}
//			
//			

//
//			// Creating a table of 3 columns
//			PdfPTable table7criteria4 = new PdfPTable(2);
//
//			// Setting width of table, its columns and spacing
//			table7criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0033 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
//			cell0033.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell0033.setExtraParagraphSpace(10);
//			table7criteria4.addCell(cell0033);
//			
//			PdfPCell cell0034 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//			cell0034.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell0034.setExtraParagraphSpace(10);
//			table7criteria4.addCell(cell0034);
//			
//			PdfPCell cell0035 = new PdfPCell(
//					new Paragraph("\r\nUpload Details of Expenditure , excluding salary during the last five years\r\n\r\n ",font5));
//			cell0035.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell0035.setExtraParagraphSpace(10);
//			table7criteria4.addCell(cell0035);
//			
//            if(criteria4file.size() >0)
//            {
//			PdfPCell cell0036 = new PdfPCell(
//					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
//			cell0036.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell0036.setExtraParagraphSpace(10);
//			table7criteria4.addCell(cell0036);
//            }
//            
//			PdfPCell cell0037 = new PdfPCell(new Paragraph("\r\nUpload audited utilization statements\r\n\r\n",font5));
//			cell0037.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell0037.setExtraParagraphSpace(10);
//			table7criteria4.addCell(cell0037);
//			
//			 if(criteria4file.size() >0)
//	            {
//			PdfPCell cell0038 = new PdfPCell(
//					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
//			cell0038.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell0038.setExtraParagraphSpace(10);
//			table7criteria4.addCell(cell0038);
//	            }
//			 
//			PdfPCell cell0039 = new PdfPCell(new Paragraph(" \r\nLink for any additional information\r\n\r\n",font5));
//			cell0039.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell0039.setExtraParagraphSpace(10);
//			table7criteria4.addCell(cell0039);
//			
//			PdfPCell cell0040 = new PdfPCell(new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5 ));
//			cell0040.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell0040.setExtraParagraphSpace(10);
//			table7criteria4.addCell(cell0040);
//
//			table7criteria4.setSpacingBefore(20f);
//			table7criteria4.setSpacingAfter(20f);
//
//			document.add(table7criteria4);
			
			
			
			
			

			// 4.2

			Paragraph paragraph31criteria4 = new Paragraph("4.2 Library as a Learning Resource\r\n", font2);
			paragraph31criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph31criteria4);
//			Paragraph paragraph32criteria4 = new Paragraph(
//					"4.2.1	Library is automated using Integrated Library Management System (ILMS)\r\n" + "Response",
//					font2);
//			paragraph32criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph32criteria4);

			PdfPTable table421criteria4 = new PdfPTable(1);
			PdfPTable table4210criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table421criteria4.setWidthPercentage(100);
			table4210criteria4.setWidthPercentage(100);
//
			PdfPCell cell4210criteria4 = new PdfPCell(new Paragraph(
					"4.2.1 Library automation using Integrated Library Management System  (ILMS), subscription to e-resources including provision of links to OER repositories, amount spent on purchase of books, journals andusage of librar\r\n\r\n Response: "
							+ (criteria4Record != null ? criteria4Record.getCriteria42Ql().get(0).getResponse421() : "")
							+ "\r\n\r\n",
					font4));

			table4210criteria4.addCell(cell4210criteria4);
			// document.add(table421criteria4);

			table4210criteria4.setSpacingBefore(20f);
			table4210criteria4.setSpacingAfter(20f);
			document.add(table4210criteria4);

			// Creating a table of 3 columns
			PdfPTable table8criteria4 = new PdfPTable(2);
			Font font6criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font6criteria4.setColor(CMYKColor.BLACK);
			// Setting width of table, its columns and spacing
			table8criteria4.setWidthPercentage(100);

			PdfPCell cell0041 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n\r\n", font4));
			cell0041.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0041.setExtraParagraphSpace(10);

			PdfPCell cell0042 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n\r\n", font4));
			cell0042.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0042.setExtraParagraphSpace(10);

			PdfPCell cell0043 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n", font5));
			cell0043.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0043.setExtraParagraphSpace(10);

			PdfPCell cell0044 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell0044.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0044.setExtraParagraphSpace(10);

			PdfPCell cell0045 = new PdfPCell(
					new Paragraph("\r\nPaste Link for additional information\r\n\r\n ", font5));
			cell0045.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0045.setExtraParagraphSpace(10);

			PdfPCell cell0046 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell0046.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0046.setExtraParagraphSpace(10);

			table8criteria4.addCell(cell0041);
			table8criteria4.addCell(cell0042);
			table8criteria4.addCell(cell0043);
			table8criteria4.addCell(cell0044);
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

			PdfPCell cell0047 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell0047.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0047.setExtraParagraphSpace(10);

			PdfPCell cell0048 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell0048.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0048.setExtraParagraphSpace(10);

			PdfPCell cell0049 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n", font5));
			cell0049.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0049.setExtraParagraphSpace(10);

			PdfPCell cell0050 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell0050.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0050.setExtraParagraphSpace(10);

			PdfPCell cell0051 = new PdfPCell(
					new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n", font5));
			cell0051.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0051.setExtraParagraphSpace(10);

			PdfPCell cell0052 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell0052.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0052.setExtraParagraphSpace(10);

			PdfPCell cell0053 = new PdfPCell(new Paragraph(
					"\r\nDetails of subscriptions like e-journals, e-books , e- ShodhSindhu, Shodhganga Membership etc\r\n\r\n",
					font5));
			cell0053.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0053.setExtraParagraphSpace(10);

			PdfPCell cell0054 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell0054.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0054.setExtraParagraphSpace(10);

			table9criteria4.addCell(cell0047);
			table9criteria4.addCell(cell0048);
			table9criteria4.addCell(cell0049);
			table9criteria4.addCell(cell0050);
			table9criteria4.addCell(cell0051);
			table9criteria4.addCell(cell0052);
			table9criteria4.addCell(cell0053);
			table9criteria4.addCell(cell0054);

//			PdfPCell cell422criteria4 = new PdfPCell(new Paragraph(
//					"4.2.2 Institution has access to the following: 1. e-journals 2. e-ShodhSindhu 3. Shodhganga Membership 4. e-books 5. Databases 6. Remote access to e-resources\r\n"
//							+ "\r\n" + "Response: "
//							+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getResponse422() : "")
//							+ "\r\n\r\n",
//					font4));
//
//			// table10criteria4.addCell(table9criteria4);
//			table10criteria4.addCell(cell422criteria4);

			table10criteria4.setSpacingBefore(20f);
			table10criteria4.setSpacingAfter(20f);

			document.add(table10criteria4);

			PdfPTable table423criteria4 = new PdfPTable(1);
			PdfPTable table4231criteria4 = new PdfPTable(1);

			table423criteria4.setWidthPercentage(100);
			table4231criteria4.setWidthPercentage(100);

			PdfPCell cell423criteria4 = new PdfPCell(new Paragraph(
					"4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n"
							+ "\r\n\r\n" + "Response: "
							+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getResponse423() : "")
							+ "\r\n\r\n",
					font4));

			//table423criteria4.addCell(cell423criteria4);

			PdfPCell cell4231criteria4 = new PdfPCell(new Paragraph(
					"4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)"
							+ "\r\n\r\n",
					font4));

			// table12criteria4.addCell(table11criteria4);
			//table4231criteria4.addCell(cell4231criteria4);

			table423criteria4.setSpacingBefore(20f);
			table423criteria4.setSpacingAfter(20f);

//			document.add(table423criteria4);
//			document.add(table4231criteria4);

//			if (criteria4Record.getYearTable4231().size() > 0) {
//
//				Table table4231 = new Table(criteria4Record.getYearTable4231().size(), 2);
//
//				table4231.setPadding(10);
//				table4231.setWidth(100f);
//
//				for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
//					Cell cell1criteria4231 = new Cell(criteria4Record.getYearTable4231().get(i).getInput4231y());
//					cell1criteria4231.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table4231.addCell(cell1criteria4231);
//
//				}
//				for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
//					Cell cell2criteria4231 = new Cell(criteria4Record.getYearTable4231().get(i).getInput4231v());
//					cell2criteria4231.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table4231.addCell(cell2criteria4231);
//
//				}
//
//				document.add(table4231);
//			}

			// Creating a table of 3 columns

			PdfPTable table13 = new PdfPTable(2);

			// Setting width of table, its columns and spacing
			table13.setWidthPercentage(100);

			PdfPCell cell0065 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell0065.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0065.setExtraParagraphSpace(10);

			PdfPCell cell0066 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell0066.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0066.setExtraParagraphSpace(10);

			PdfPCell cell0067 = new PdfPCell(new Paragraph(
					"\r\nDetails of annual expenditure for purchase of and subscription to journals/e-journals during the last five years\r\n\r\n",
					font5));
			cell0067.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0067.setExtraParagraphSpace(10);

			PdfPCell cell0068 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell0068.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0068.setExtraParagraphSpace(10);

			PdfPCell cell0069 = new PdfPCell(new Paragraph("\r\nAudited statements of accounts\r\n\r\n", font5));
			cell0069.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0069.setExtraParagraphSpace(10);

			PdfPCell cell0070 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell0070.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0070.setExtraParagraphSpace(10);

			PdfPCell cell0071 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n", font5));
			cell0071.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0071.setExtraParagraphSpace(10);

			PdfPCell cell0072 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell0072.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0072.setExtraParagraphSpace(10);

			table13.addCell(cell0065);
			table13.addCell(cell0066);
			table13.addCell(cell0067);
			table13.addCell(cell0068);
			table13.addCell(cell0069);
			table13.addCell(cell0070);
			table13.addCell(cell0071);
			table13.addCell(cell0072);

			table13.setSpacingBefore(20f);
			table13.setSpacingAfter(20f);

			//document.add(table13);

			// Creating a table of 3 columns
			PdfPTable table14criteria4 = new PdfPTable(2);
			PdfPTable table15 = new PdfPTable(1);
			PdfPTable table4241 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table14criteria4.setWidthPercentage(100);
			table15.setWidthPercentage(100);
			table4241.setWidthPercentage(100);

			PdfPCell cell0075 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell0075.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0075.setExtraParagraphSpace(10);

			PdfPCell cell0076 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell0076.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0076.setExtraParagraphSpace(10);

			PdfPCell cell0077 = new PdfPCell(
					new Paragraph("\r\nDetails of library usage by teachers and students\r\n\r\n", font5));
			cell0077.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0077.setExtraParagraphSpace(10);

			PdfPCell cell0078 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell0078.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0078.setExtraParagraphSpace(10);

			PdfPCell cell0079 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n", font5));
			cell0079.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0079.setExtraParagraphSpace(10);

			PdfPCell cell0080 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell0080.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0080.setExtraParagraphSpace(10);

			table14criteria4.addCell(cell0075);
			table14criteria4.addCell(cell0076);
			table14criteria4.addCell(cell0077);
			table14criteria4.addCell(cell0078);
			table14criteria4.addCell(cell0079);
			table14criteria4.addCell(cell0080);

			PdfPCell cell424criteria4 = new PdfPCell(new Paragraph(
					"4.2.4 Percentage per day usage of library by teachers and students ( foot falls and login data for online access) during the latest completed academic year"
							+ "\r\n\r\n\r\n" + "Response: "
							+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getResponse424() : "")
							+ "\r\n\r\n",
					font4));

			table15.addCell(cell424criteria4);

			PdfPCell cell4241criteria4 = new PdfPCell(new Paragraph(
					"4.2.4.1 Number of teachers and students using library per day over last one year\r\n" + "\r\n"

							+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getInput4241t1() : "")
							+ "\r\n\r\n",
					font4));

			PdfPCell cell42410criteria4 = new PdfPCell(
					new Paragraph("4.2.4.1: Total number of teachers and students\r\n" + "\r\n"

							+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getInput4241t2() : "")
							+ "\r\n\r\n", font4));

			table4241.addCell(cell4241criteria4);
			table4241.addCell(cell42410criteria4);
			// table15.addCell(table14criteria4);

			table15.setSpacingBefore(20f);
			table15.setSpacingAfter(20f);

			//document.add(table15);

			//document.add(table4241);

			// 4.3
			Paragraph paragraph38criteria4 = new Paragraph("4.3 Infrastructure\r\n\r\n", font1);
			paragraph38criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph35 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph35.setSize(12);
			 */

//			Paragraph paragraph39criteria4 = new Paragraph(
//					"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n\r\n",font2);
//			paragraph39criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph36 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph36.setSize(12);
			 */

			/*
			 * Font fontParagraph37 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph37.setSize(12);
			 */

//			Paragraph paragraph41 = new Paragraph(
//					"Mother Teresa considers that in the current information age no organization can survive without extensive use of IT. Towards this, the college has developed an IT policy encompassing all IT/IT enabled services used in the campus, ensuring smooth functioning with adequate security to all users connected to the campus network.\r\n"
//							+ "\r\n"
//							+ "Based on the laboratory and other requirements, every year college allocates budget for updating its IT facilities for procurement of computer systems and other IT related equipment including software.\r\n"
//							+ "\r\n"
//							+ "Every user in the campus is provided access to the campus network as well as internet.\r\n"
//							+ "\r\n"
//							+ "48 LCD projectors have been installed in class rooms and labs with wi-fi/internet connectivity.\r\n"
//							+ "\r\n"
//							+ "All students and faculty are given email accounts with college domain name through GSuite. The college has installed two firewalls in order to protect all its internal systems from cyber attacks.\r\n"
//							+ " \r\n"
//							+ "The college also installed CISCO switches for monitoring traffic in the campus network.\r\n"
//							+ "",
//					font5);
//			paragraph41.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph38 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph38.setSize(12);
			 */

//			Paragraph paragraph42 = new Paragraph("The details of up-dation as follows:", font2);
//			paragraph42.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph39 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph39.setSize(12);
//			 */
//
//			Paragraph paragraph43criteria4 = new Paragraph("AY 2020-21\r\n" + "\r\n"
//					+ "1.	Procured 320 Lenovo computers of core i5 of 16GB RAM, 1TB HDD.\r\n"
//					+ "2.	Provided ICT Facilities in 06 class rooms\r\n"
//					+ "3.	Internet facility was upgraded from 210 Mbps to 1000 Mbps with two distinct service providers.\r\n"
//					+ "4.	ACT (Atria Convergence Technologies Ltd) Fibre (500Mbps).\r\n"
//					+ "5.D-Vios Communications Pvt Ltd.(500Mbps).\r\n" + " ", font5);
//			paragraph43criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph40 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph40.setSize(12);
			 */
//
//			Paragraph paragraph44 = new Paragraph("AY 2019-20\r\n" + "\r\n"
//					+ "1.	Provided ICT Facilities in 04 class rooms\r\n"
//					+ "2.	Established Robotics Learning and Development Centre Lab in collaboration with Smart Bridge Educational Services Pvt. Ltd.\r\n"
//					+ "3.	Procured 256 Acer computers of core i5 of 8GB RAM, 1TB HDD.\r\n"
//					+ "4.	Installed Firewall �Sophos XG Firewall� for exam branch.\r\n" + " ", font5);
//			paragraph44.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph41 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph41.setSize(12);
			 */
//
//			Paragraph paragraph45 = new Paragraph("AY 2019-20\r\n" + "\r\n"
//					+ "1.	Provided ICT Facilities in 04 class rooms\r\n"
//					+ "2.	Established Robotics Learning and Development Centre Lab in collaboration with Smart Bridge Educational Services Pvt. Ltd.\r\n"
//					+ "3.	Procured 256 Acer computers of core i5 of 8GB RAM, 1TB HDD.\r\n"
//					+ "4.	Installed Firewall �Sophos XG Firewall� for exam branch.\r\n" + " ", font5);
//			paragraph45.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph42 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph42.setSize(12);
			 */

//			Paragraph paragraph46 = new Paragraph("AY 2018-19\r\n" + "\r\n"
//					+ "1.	Installed Firewall \"Sonicwall NSA 3600� for securing campus network.\r\n"
//					+ "2.	Provided ICT Facilities in 09 class rooms\r\n"
//					+ "3.	Established one more Computing centre with 100 systems each.\r\n"
//					+ "4.	Increased number of computer systems in existing Computing centre from 48 to 100.\r\n"
//					+ "5.	Anti-virus: Quick Heal Seqrite EPS antivirus software (500 Users) has been installed for all the systems with Windows OS.\r\n"
//					+ "6.	Procured 216 Acer computers of core i3 with 4GB RAM, 1TB HDD and 60 Lenovo Computers of core i3 with 4GB RAM, 1TB HDD.\r\n"
//					+ "7.	Internet facility was upgraded from 132 Mbps to 210 Mbps with two distinct service providers.\r\n"
//					+ "\r\n"
//
//					+ " ", font5);
//			paragraph46.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph43 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph43.setSize(12);
			 */
//
//			Paragraph paragraph47 = new Paragraph("AY 2017-18\r\n" + "\r\n"
//					+ "1.	Procured 72 Acer computers of core i5 with 4GB RAM and 1TB HDD, 151 Acer computers of core i3 with 4GB RAM, 1 TB HDD and 170 Assembled computers of Dual Core with 4GB RAM, 1 TB HDD.\r\n"
//					+ "2.	Internet facility was upgraded from 48 Mbps to 132 Mbps with two distinct service providers.\r\n"
//
//					+ ":", font5);
//			paragraph47.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph44 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph44.setSize(12);
			 */

//			Paragraph paragraph48 = new Paragraph("AY 2016-17\r\n" + "\r\n"
//					+ "1.	Intra-net connectivity is provided on the campus with 20 Gbps fibre-optic cable over and above the Reliance Jio campus wi-fi for daily usage of 1GB/User.\r\n"
//					+ "2.	Established IBM Software Lab for Emerging Technologies in collaboration with IBM.\r\n"
//					+ "3.	Procured 302 Assembled computers of Dual Core with 2GB RAM, 500GB HDD.\r\n" + "", font5);
//			paragraph48.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph45 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph45.setSize(12);
			 */

//			Paragraph paragraph49 = new Paragraph("Year wise Allocated Budget for IT facilities:" + "", font3);
//			paragraph49.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph38criteria4);
			// document.add(paragraph39criteria4);
			// document.add(paragraph40);
//			document.add(paragraph41);
//			document.add(paragraph42);
//			document.add(paragraph43criteria4);
//			document.add(paragraph44);
//			document.add(paragraph45);
//			document.add(paragraph46);
//			document.add(paragraph47);
//			document.add(paragraph48);
//			document.add(paragraph49);

			// Creating a table of 3 columns

			// PdfPTable table16criteria4 = new PdfPTable(5);

			// Setting width of table, its columns and spacing
			// table16criteria4.setWidthPercentage(100);

//			PdfPCell cell0081 = new PdfPCell(new Paragraph("Budget allocated for IT facilities"));
//			PdfPCell cell0082 = new PdfPCell(new Paragraph("2016-17"));
//			PdfPCell cell0083 = new PdfPCell(new Paragraph("2017-2018"));
//			PdfPCell cell0084 = new PdfPCell(new Paragraph("2018-2019"));
//			PdfPCell cell0085 = new PdfPCell(new Paragraph("2019-2020"));
//			PdfPCell cell0086 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell0087 = new PdfPCell(new Paragraph("50,45,018"));
//			PdfPCell cell0088 = new PdfPCell(new Paragraph("96,97,574 "));
//			PdfPCell cell0089 = new PdfPCell(new Paragraph("79,75,787"));
//			PdfPCell cell0090 = new PdfPCell(new Paragraph("89,95,799 "));
//
//			table16criteria4.addCell(cell0081);
//			table16criteria4.addCell(cell0082);
//			table16criteria4.addCell(cell0083);
//			table16criteria4.addCell(cell0084);
//			table16criteria4.addCell(cell0085);
//			table16criteria4.addCell(cell0086);
//			table16criteria4.addCell(cell0087);
//			table16criteria4.addCell(cell0088);
//			table16criteria4.addCell(cell0089);
//			table16criteria4.addCell(cell0090);
//
//			table16criteria4.setSpacingBefore(20f);
//			table16criteria4.setSpacingAfter(20f);
//
//			document.add(table16criteria4);

			PdfPTable table17criteria4 = new PdfPTable(2);
			PdfPTable table431criteria4 = new PdfPTable(1);

			table17criteria4.setWidthPercentage(100);
			table431criteria4.setWidthPercentage(100);

			PdfPCell cell0091 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell0091.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0091.setExtraParagraphSpace(10);

			PdfPCell cell0092 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell0092.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0092.setExtraParagraphSpace(10);

			PdfPCell cell0093 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n", font5));
			cell0093.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0093.setExtraParagraphSpace(10);

			PdfPCell cell0094 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell0094.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0094.setExtraParagraphSpace(10);

			PdfPCell cell0095 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n", font5));
			cell0095.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0095.setExtraParagraphSpace(10);

			PdfPCell cell0096 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell0096.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0096.setExtraParagraphSpace(10);

			table17criteria4.addCell(cell0091);
			table17criteria4.addCell(cell0092);
			table17criteria4.addCell(cell0093);
			table17criteria4.addCell(cell0094);
			table17criteria4.addCell(cell0095);
			table17criteria4.addCell(cell0096);

			PdfPCell cell431criteria4 = new PdfPCell(new Paragraph(
					"4.3.1	Institution frequently updates its IT facilities and provides sufficient bandwidth for internet connection\r\n\r\n"
							+ "Response: "
							+ (criteria4Record != null ? criteria4Record.getCriteria43Ql().get(0).getResponse431() : "")
							+ "\r\n\r\n",
					font4));

			table431criteria4.addCell(cell431criteria4);

//			PdfPCell cell4301criteria4 = new PdfPCell(new Paragraph( (criteria4Record != null
//									? criteria4Record.getCriteria43Ql().get(0).getResponse431()
//									: "")));			
//			table17criteria4.addCell(cell431criteria4);
//			table17criteria4.addCell(cell4301criteria4);

//			table17criteria4.addCell(table16criteria4);
//			table17criteria4.addCell(table16criteria4);
			table17criteria4.setSpacingAfter(20);
			table17criteria4.setSpacingBefore(20);

			document.add(table431criteria4);
			document.add(table17criteria4);

			// Creating a table of 3 columns
			PdfPTable table18criteria4 = new PdfPTable(2);
			PdfPTable table432criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table18criteria4.setWidthPercentage(100);
			table432criteria4.setWidthPercentage(100);

			PdfPCell cell0097 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell0097.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0096.setExtraParagraphSpace(10);

			PdfPCell cell0098 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell0098.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0098.setExtraParagraphSpace(10);

			PdfPCell cell0099 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n", font5));
			cell0099.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell0099.setExtraParagraphSpace(10);

			PdfPCell cell00100 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell00100.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00100.setExtraParagraphSpace(10);

			PdfPCell cell00101 = new PdfPCell(new Paragraph("\r\nStudent - computer ratio\r\n\r\n", font5));
			cell00101.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00101.setExtraParagraphSpace(10);

			PdfPCell cell00102 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell00102.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00102.setExtraParagraphSpace(10);

			table18criteria4.addCell(cell0097);
			table18criteria4.addCell(cell0098);
			table18criteria4.addCell(cell0099);
			table18criteria4.addCell(cell00100);
			table18criteria4.addCell(cell00101);
			table18criteria4.addCell(cell00102);

			// table19criteria4.addCell(table18criteria4);

			PdfPCell cell432criteria4 = new PdfPCell(
					new Paragraph("4.3.2 Student - Computer ratio (Data for the latest completed academic year)\r\n"
							+ "\r\n\r\n" + "Response:"
							+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse432() : "")
							+ "\r\n\r\n", font4));

			table432criteria4.addCell(cell432criteria4);

			table432criteria4.setSpacingBefore(20f);
			table432criteria4.setSpacingAfter(20f);

			document.add(table432criteria4);
			document.add(table18criteria4);

			// Creating a table of 3 columns

			PdfPTable table20criteria4 = new PdfPTable(2);
			PdfPTable table433criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table20criteria4.setWidthPercentage(100);
			table433criteria4.setWidthPercentage(100);

			PdfPCell cell00103 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell00103.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00103.setExtraParagraphSpace(10);

			PdfPCell cell00104 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell00104.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00104.setExtraParagraphSpace(10);

			PdfPCell cell00105 = new PdfPCell(new Paragraph(
					"\r\nDetails of available bandwidth of internet connection in the Institution\r\n\r\n", font5));
			cell00105.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00105.setExtraParagraphSpace(10);

			PdfPCell cell00106 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell00106.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00106.setExtraParagraphSpace(10);

			table20criteria4.addCell(cell00103);
			table20criteria4.addCell(cell00104);
			table20criteria4.addCell(cell00105);
			table20criteria4.addCell(cell00106);
			table20criteria4.setSpacingAfter(20);
			table20criteria4.setSpacingBefore(20);

			//document.add(table20criteria4);

			// table21criteria4.addCell(table20criteria4);

			PdfPCell cell433criteria4 = new PdfPCell(new Paragraph(
					"4.3.3 Bandwidth of internet connection in the Institution.\r\n" + "\r\n" + "Response: "
							+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse433() : "")
							+ "\r\n\r\n",
					font4));

			//table433criteria4.addCell(cell433criteria4);
			table433criteria4.setSpacingAfter(20);
			table433criteria4.setSpacingBefore(20);

		//	document.add(table433criteria4);

			// Creating a table of 3 columns

			PdfPTable table22criteria4 = new PdfPTable(2);
			PdfPTable table434criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table22criteria4.setWidthPercentage(100);
			table434criteria4.setWidthPercentage(100);

			PdfPCell cell00107 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell00107.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00107.setExtraParagraphSpace(10);

			PdfPCell cell00108 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell00108.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00108.setExtraParagraphSpace(10);

			PdfPCell cell00109 = new PdfPCell(new Paragraph("\r\nUpload Additional information\r\n\r\n", font5));
			cell00109.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00109.setExtraParagraphSpace(10);

			PdfPCell cell00110 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell00110.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00110.setExtraParagraphSpace(10);

			PdfPCell cell00111 = new PdfPCell(
					new Paragraph("\r\n Institutional data in prescribed format\r\n\r\n", font5));
			cell00111.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00111.setExtraParagraphSpace(10);

			PdfPCell cell00112 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell00112.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00112.setExtraParagraphSpace(10);

			table22criteria4.addCell(cell00107);
			table22criteria4.addCell(cell00108);
			table22criteria4.addCell(cell00109);
			table22criteria4.addCell(cell00110);
			table22criteria4.addCell(cell00111);
			table22criteria4.addCell(cell00112);
			table22criteria4.setSpacingAfter(20);
			table22criteria4.setSpacingBefore(20);

			//document.add(table22criteria4);

			// table23criteria4.addCell(table22criteria4);

			PdfPCell cell434criteria4 = new PdfPCell(
					new Paragraph("4.3.4	Institution has the following Facilities for e-content development\r\n"
							+ "1.	Media centre\r\n" + "2.	Audio visual centre\r\n"
							+ "3.	Lecture Capturing System(LCS)\r\n"
							+ "4.	Mixing equipments and softwares for editing\r\n" + "\r\n" + "Response: "
							+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse434() : "")
							+ "\r\n\r\n", font4));

			table434criteria4.addCell(cell434criteria4);

			table434criteria4.setSpacingBefore(20f);
			table434criteria4.setSpacingAfter(20f);

			//document.add(table434criteria4);

			// 4.4
			Paragraph paragraph50 = new Paragraph("4.4 Maintenance of Campus Infrastructure\r\n\r\n", font2);
			paragraph50.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph50);

			// Creating a table of 3 columns

			PdfPTable table441criteria4 = new PdfPTable(1);
			PdfPTable table4411criteria4 = new PdfPTable(1);

			table441criteria4.setWidthPercentage(100);
			table4411criteria4.setWidthPercentage(100);

			PdfPCell cell441criteria4 = new PdfPCell(new Paragraph(
					"4.4.1 Percentage of expenditure incurred on maintenance of infrastructure (physical and academic support facilities) excluding salary component during the last five years (INR in Lakhs)\r\n\r\n"
							+ " Response: "
							+ (criteria4Record != null ? criteria4Record.getCriteria44Ql().get(0).getResponse441() : "")
							+ "\r\n\r\n",
					font4));

			table441criteria4.addCell(cell441criteria4);

			PdfPCell cell4411criteria4 = new PdfPCell(new Paragraph(
					"4.4.1.1 Expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component year wise during the last five years (INR in lakhs)\r\n\r\n",
					font4));

			table4411criteria4.addCell(cell4411criteria4);

			table441criteria4.setSpacingBefore(20f);
			table441criteria4.setSpacingAfter(20f);

			document.add(table441criteria4);
			document.add(table4411criteria4);

			if (criteria4Record.getYearTable4411() != null) {

				Table table4411 = new Table(criteria4Record.getYearTable4411().size(), 2);

				table4411.setPadding(10);
				table4411.setWidth(100f);

				for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
					Cell cell1criteria4411 = new Cell(criteria4Record.getYearTable4411().get(i).getInput4411y());
					cell1criteria4411.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4411.addCell(cell1criteria4411);

				}
				for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
					Cell cell2criteria4411 = new Cell(criteria4Record.getYearTable4411().get(i).getInput4411v());
					cell2criteria4411.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4411.addCell(cell2criteria4411);

				}

				document.add(table4411);

			}

//			if (criteria4Record.getYearTable44112() != null) {
//
//				Table table44112 = new Table(criteria4Record.getYearTable44112().size(), 2);
//
//				table44112.setPadding(10);
//				table44112.setWidth(100f);
//
//				for (int i = 0; i < criteria4Record.getYearTable44112().size(); i++) {
//					Cell cell1criteria44112 = new Cell(criteria4Record.getYearTable44112().get(i).getInput44112y());
//					cell1criteria44112.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table44112.addCell(cell1criteria44112);
//
//				}
//				for (int i = 0; i < criteria4Record.getYearTable44112().size(); i++) {
//					Cell cell2criteria44112 = new Cell(criteria4Record.getYearTable44112().get(i).getInput44112v());
//					cell2criteria44112.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table44112.addCell(cell2criteria44112);
//
//				}
//
//				document.add(table44112);
//
//			}

			PdfPTable table26criteria4 = new PdfPTable(2);
			PdfPTable table422criteria4 = new PdfPTable(1);

			table422criteria4.setWidthPercentage(100);
			table26criteria4.setWidthPercentage(100);

			PdfPCell cell00123 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell00123.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00123.setExtraParagraphSpace(10);

			PdfPCell cell00124 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell00124.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00124.setExtraParagraphSpace(10);

			PdfPCell cell00125 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n ", font5));
			cell00125.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00125.setExtraParagraphSpace(10);

			PdfPCell cell00126 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell00126.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00126.setExtraParagraphSpace(10);

			PdfPCell cell00127 = new PdfPCell(new Paragraph("\r\nAudited statements of accounts\r\n\r\n ", font5));
			cell00127.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00127.setExtraParagraphSpace(10);

			PdfPCell cell00128 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell00128.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00128.setExtraParagraphSpace(10);

			PdfPCell cell01 = new PdfPCell(new Paragraph(
					"\r\nDetails about assigned budget and expenditure on physical facilities and academic facilities\r\n\r\n ",
					font5));
			cell01.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell01.setExtraParagraphSpace(10);

			PdfPCell cell02 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell02.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell02.setExtraParagraphSpace(10);

			table26criteria4.addCell(cell00123);
			table26criteria4.addCell(cell00124);
			table26criteria4.addCell(cell00125);
			table26criteria4.addCell(cell00126);
			table26criteria4.addCell(cell00127);
			table26criteria4.addCell(cell00128);
			table26criteria4.addCell(cell01);
			table26criteria4.addCell(cell02);
			table26criteria4.setSpacingAfter(20);
			table26criteria4.setSpacingBefore(20);

			document.add(table26criteria4);

			PdfPCell cell442criteria4 = new PdfPCell(new Paragraph(
					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\r\n\r\n"
							+ "\r\n" + "Response: "
							+ (criteria4Record != null ? criteria4Record.getCriteria44Ql().get(0).getResponse442() : "")
							+ "\r\n\r\n",
					font4));

			table422criteria4.addCell(cell442criteria4);
			// document.add(table422criteria4);

			PdfPTable table442criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table442criteria4.setWidthPercentage(100);

//			PdfPCell cell4420criteria4 = new PdfPCell(new Paragraph(
//					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\r\n\r\n"
//							+ " Response: "
//							+ (criteria4Record != null ? criteria4Record.getCriteria44Ql().get(0).getResponse442() : "")
//							+ "\r\n\r\n",
//					font4));
//			table442criteria4.addCell(cell4420criteria4);

			table442criteria4.setSpacingBefore(20f);
			table442criteria4.setSpacingAfter(20f);

			document.add(table442criteria4);

			PdfPTable table27criteria4 = new PdfPTable(2);
			table27criteria4.setWidthPercentage(100);

			PdfPCell cell00129 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell00129.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00129.setExtraParagraphSpace(10);

			PdfPCell cell00130 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell00130.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00130.setExtraParagraphSpace(10);

			PdfPCell cell00131 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n", font5));
			cell00131.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00131.setExtraParagraphSpace(10);

			PdfPCell cell00132 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell00132.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00132.setExtraParagraphSpace(10);

			PdfPCell cell00133 = new PdfPCell(
					new Paragraph("\r\nPaste link for additional information\r\n\r\n", font5));
			cell00133.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00133.setExtraParagraphSpace(10);

			PdfPCell cell00134 = new PdfPCell(new Paragraph(
					"\r\n" + (criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "") + "\r\n\r\n",
					font5));
			cell00134.setHorizontalAlignment(Element.ALIGN_CENTER);
			// cell00134.setExtraParagraphSpace(10);

			table27criteria4.addCell(cell00129);
			table27criteria4.addCell(cell00130);
			table27criteria4.addCell(cell00131);
			table27criteria4.addCell(cell00132);
			table27criteria4.addCell(cell00133);
			table27criteria4.addCell(cell00134);

			table27criteria4.setSpacingBefore(20f);
			table27criteria4.setSpacingAfter(20f);

			//document.add(table27criteria4);

			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
