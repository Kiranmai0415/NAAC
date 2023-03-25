package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class Criteria3AutonomousReport {
	

	
	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	
	@Autowired
	Criteria3Service service3;
	

//	List<Criteria3_FieldInfo> criteria3List = null;
//	Criteria3_FieldInfo criteria3Record = null;
//	List<Criteria3_FileUpload> criteria3file = null;
//	
	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	
	List<Criteria3_FieldInfo> criteria3FieldInfoList = null;

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

//			Map<String, String> allParams = new HashMap<String, String>();
//			allParams.put("collegeId",criteria3Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear", criteria3Fieldinfo.getCriteriaId().getFinancialYear());
//
//			allParams.put("typeofInstitution", criteria3Fieldinfo.getCriteriaId().getTypeofInstitution() );

			criteria3FieldInfoList = service3.getAllCriteria3Data(allParams);

			ObjectMapper mapper = new ObjectMapper();
			System.out.println("values===>" + mapper.writeValueAsString(criteria3FieldInfoList));

			if (CollectionUtils.isNotEmpty(criteria3FieldInfoList)) {

//				criteria2Record=criteria3FieldInfoList.get(0);

				criteria3Record = criteria3FieldInfoList.get(0);

//				criteria3_FieldInfoQnList = criteria3FieldInfoList.get(0).getCriteria3FieldInfoQn();
//				criteria3_FieldInfoQlList = criteria3FieldInfoList.get(0).getCriteria3FieldInfoQl();
				criteria3file = criteria3Record.getCriteria3FileUpload();
			} else {
//				criteria3_FieldInfoQnList = new ArrayList<>();
//				criteria3_FieldInfoQlList = new ArrayList<>();
//				criteria3file = new ArrayList<>();
			}
			System.out.println("sfasdfdasdfasfdasdfasdfasdfasdfasdf" + criteria3Record);
			System.out.println("999999999999999999999999999" + criteria3Record);
			System.out.println("criteria3file==>" + criteria3file);

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AuthonomousCriteria3Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

//			Font font0 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font0.setSize(16);
//
//			Font font1criteria3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font1criteria3.setSize(14);
//
//			Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			font2.setSize(12);

			Paragraph paragraph1criteria3 = new Paragraph(
					"Criterion 3 - Research, Innovations and Extension\r\n", font1);
			paragraph1criteria3.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph1criteria3);
			Paragraph paragraphlinecriteria3 = new Paragraph(
					"____________________________________________________________________________");
			paragraph1criteria3.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraphlinecriteria3);
			
			Paragraph paragraph2criteria3 = new Paragraph("3.1	Promotion of Research and Facilities\r\n\r\n",
					font2);
			paragraph1criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph2criteria3);
			// create table1
			PdfPTable table1criteria3 = new PdfPTable(2);
			PdfPTable table13criteria31 = new PdfPTable(1);

			table1criteria3.setWidthPercentage(100f);
			table13criteria31.setWidthPercentage(100f);

			PdfPCell cell1criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell1criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell2criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell2criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell3criteria3 = new PdfPCell(new Paragraph(
					"Minutes of the Governing Council/ Syndicate/Board of Management related to research promotion policy adoption\r\n\r\n",font5));
			cell3criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell4criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell4criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell5criteria3 = new PdfPCell(new Paragraph("Any additional information \r\n\r\n",font5));
			cell5criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell6criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell6criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell7criteria3 = new PdfPCell(
					new Paragraph("URL of Policy document on promotion of research uploaded on website\r\n\r\n",font5));
			cell7criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell8criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell8criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1criteria3.addCell(cell1criteria3);
			table1criteria3.addCell(cell2criteria3);
			table1criteria3.addCell(cell3criteria3);
			table1criteria3.addCell(cell4criteria3);
			table1criteria3.addCell(cell5criteria3);
			table1criteria3.addCell(cell6criteria3);
			table1criteria3.addCell(cell7criteria3);
			table1criteria3.addCell(cell8criteria3);

			PdfPCell cell311criteria3 = new PdfPCell(new Paragraph(
					"3.1.1	The institution’s Research facilities are frequently updated and there is \r\n"
					+ "a well defined policy for promotion of research which is uploaded on \r\n"
					+ "the institutional website and implemented\r\n\r\n"
							,font4));
			table13criteria31.addCell(cell311criteria3);
			PdfPCell cell3111criteria3 = new PdfPCell(new Paragraph("Response:"+
							 (criteria3Record != null ? criteria3Record.getCriteria31Ql().get(0).getResponse311()
									: "")+"\r\n\r\n",font5));
			table13criteria31.addCell(cell3111criteria3);
//     	table13criteria31.addCell(table1criteria3);

			table1criteria3.setSpacingBefore(20f);
			table1criteria3.setSpacingAfter(20f);
			document.add(table13criteria31);
			document.add(table1criteria3);

			// create table 2////
			PdfPTable table2criteria3 = new PdfPTable(2);
			PdfPTable table23criteria31 = new PdfPTable(1);
			table2criteria3.setWidthPercentage(100f);
			table23criteria31.setWidthPercentage(100f);
			PdfPCell cell21criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell21criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell22criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell22criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell23criteria3 = new PdfPCell(
					new Paragraph("Minutes of the relevant bodies of the Institution\r\n\r\n,",font5));
			cell23criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell24criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell24criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell25criteria3 = new PdfPCell(
					new Paragraph("List of teachers receiving grant and details of grant received\r\n\r\n",font5));
			cell25criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell26criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell26criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell27criteria3 = new PdfPCell(new Paragraph(
					"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n",font5));
			cell27criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell28criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell28criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2criteria3.addCell(cell21criteria3);
			table2criteria3.addCell(cell22criteria3);
			table2criteria3.addCell(cell23criteria3);
			table2criteria3.addCell(cell24criteria3);
			table2criteria3.addCell(cell25criteria3);
			table2criteria3.addCell(cell26criteria3);
			table2criteria3.addCell(cell27criteria3);
			table2criteria3.addCell(cell28criteria3);
			PdfPCell cell312criteria3 = new PdfPCell(new Paragraph(
					"3.1.2 The institution provides seed money to its teachers for research (average \r\n"
					+ "per year; INR in Lakhs)\r\n\r\n"
						 ,font4));
			PdfPCell cell31211criteria3 = new PdfPCell(new Paragraph("Response:"+
							 (criteria3Record != null ? criteria3Record.getCriteria31Qn().get(0).getResponse312()
									: "")+"\r\n\r\n",font5));
			
			PdfPCell cell3121criteria3 = new PdfPCell(new Paragraph(
					"3.1.2.1 The amount of seed money provided by institution to its faculty year-wise during the last five years (INR in lakhs)\r\n\r\n.",
					font4));

			table23criteria31.addCell(cell312criteria3);
			table23criteria31.addCell(cell31211criteria3);
			table23criteria31.addCell(cell3121criteria3);
			
			table23criteria31.setSpacingAfter(10f);
			table23criteria31.setSpacingAfter(10f);

			document.add(table23criteria31);
			document.add(table2criteria3);
			
			// create table 3121///

			if (criteria3Record.getYearTable3121() != null) {
				Table table3121criteria3 = new Table(criteria3Record.getYearTable3121().size());

				table3121criteria3.setPadding(5);
				table3121criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3121().size(); i++) {
					Cell cell31210criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3121().get(i).getInput3121y(),font5));
					cell31210criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3121criteria3.addCell(cell31210criteria3);
					
				}
				for (int i = 0; i < criteria3Record.getYearTable3121().size(); i++) {
					
					Cell cell31210criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3121().get(i).getInput3121v(),font5));
					cell31210criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3121criteria3.addCell(cell31210criteria3);
					
				}

				document.add(table3121criteria3);
				

			}

			// create table 3 //////
//			PdfPTable table3criteria3 = new PdfPTable(2);
//			PdfPTable table33criteria31 = new PdfPTable(1);
//
//			table3criteria3.setWidthPercentage(100f);
//			table33criteria31.setWidthPercentage(100f);
//
//			PdfPCell cell31criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
//			cell31criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell32criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
//			cell32criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell33criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
//			cell33criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell34criteria3 = new PdfPCell(
//					new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
//			cell34criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//			PdfPCell cell35criteria3 = new PdfPCell(new Paragraph("Minutes of the relevant bodies of the Institution\r\n\r\n",font5));
//			cell35criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell36criteria3 = new PdfPCell(
//					new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
//			cell36criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell33criteria31 = new PdfPCell(new Paragraph(
//					"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n",font5));
//			cell33criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell34criteria31 = new PdfPCell(
//					new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
//			cell34criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//			PdfPCell cell35criteria31 = new PdfPCell(
//					new Paragraph("List of teachers receiving grant and details of grant received (Data Template)\r\n\r\n",font5));
//			cell35criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//			PdfPCell cell36criteria31 = new PdfPCell(
//					new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
//			cell36criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table3criteria3.addCell(cell31criteria3);
//			table3criteria3.addCell(cell32criteria3);
//			table3criteria3.addCell(cell33criteria3);
//			table3criteria3.addCell(cell34criteria3);
//			table3criteria3.addCell(cell35criteria3);
//			table3criteria3.addCell(cell36criteria3);
//			table3criteria3.addCell(cell33criteria31);
//			table3criteria3.addCell(cell34criteria31);
//			table3criteria3.addCell(cell35criteria31);
//			table3criteria3.addCell(cell36criteria31);
//
////			table33criteria31.addCell(cell313criteria3);
////			table33criteria31.addCell(cell3131criteria3);
//			table33criteria31.addCell(table3criteria3);
//			// document.add(cell313criteria3);
//			// document.add(cell3131criteria3);
//			table33criteria31.setSpacingBefore(20f);
//			table33criteria31.setSpacingAfter(20f);

			// create table 3131 ///
			
			PdfPTable table3criteria3 = new PdfPTable(2);
			PdfPTable table33criteria31 = new PdfPTable(1);

			table3criteria3.setWidthPercentage(100f);
			table33criteria31.setWidthPercentage(100f);
			table3criteria3.setSpacingAfter(20);
			table3criteria3.setSpacingBefore(20);
			
			table33criteria31.setSpacingAfter(20);
			table33criteria31.setSpacingBefore(20);


			PdfPCell cell31criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell31criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell32criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell32criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell33criteria3 = new PdfPCell(
					new Paragraph("List of teachers and their international fellowship details\r\n\r\n",font5));
			cell33criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell34criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell34criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell35criteria3 = new PdfPCell(new Paragraph("e-copies of the award letters of the teachers\r\n\r\n",font5));
			cell35criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell36criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell36criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria3.addCell(cell31criteria3);
			table3criteria3.addCell(cell32criteria3);
			table3criteria3.addCell(cell33criteria3);
			table3criteria3.addCell(cell34criteria3);
			table3criteria3.addCell(cell35criteria3);
			table3criteria3.addCell(cell36criteria3);
			
			PdfPCell cell313criteria3 = new PdfPCell(new Paragraph(
					"3.1.3 Percentage of teachers receiving national/ international \r\n"
					+ "fellowship/financial support by various agencies for advanced studies/ \r\n"
					+ "research during the last five years\r\n"
							+ "\r\n\r\n" + "Response"
							+ (criteria3Record != null
									? criteria3Record.getCriteria31Qn().get(0).getResponse313()
									: "")+"\r\n\r\n",
					font4));
			PdfPCell cell3131criteria3 = new PdfPCell(new Paragraph(
					"3.1.3.1 Number of teachers who received national/ international \r\n"
					+ "fellowship/financial support from various agencies, for advanced studies / \r\n"
					+ "research; year-wise during the last five years"
							+ "\r\n\r\n",
					font4));
			table33criteria31.addCell(cell313criteria3);
			table33criteria31.addCell(cell3131criteria3);
			document.add(table33criteria31);
			document.add(table3criteria3);
			
			
			if (criteria3Record.getYearTable3131() != null) {
				Table table3131criteria3 = new Table(criteria3Record.getYearTable3131().size(), 2);

				table3131criteria3.setPadding(5);
				table3131criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3131().size(); i++) {
					
					
					Cell cell312101criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3131().get(i).getInput3131y(),font5));
					cell312101criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3131criteria3.addCell(cell312101criteria3);
				}
				for (int i = 0; i < criteria3Record.getYearTable3131().size(); i++) {
					Cell cell3121011criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3131().get(i).getInput3131v(),font5));
					cell3121011criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3131criteria3.addCell(cell3121011criteria3);
				}

				document.add(table3131criteria3);
			}
		
			
			
			
			
//
//			Paragraph paragraph2criteria3112 = new Paragraph(
//					"3.1.4: Number of JRFs, SRFs, Post Doctoral Fellows, Research Associates and other research fellows enrolled in the institution during the last five years");
//
//			document.add(paragraph2criteria3112);
//
//			Paragraph paragraph2criteria3113 = new Paragraph(
//					criteria3Record != null ? criteria3Record.getCriteria31Qn().get(0).getResponse314() : "");
//			document.add(paragraph2criteria3113);
//			Paragraph paragraph2criteria3114 = new Paragraph(
//					"3.1.4.1: The Number of JRFs, SRFs, Post Doctoral Fellows, Research Associates and other research fellows enrolled in the institution year-wise during the last five years.");
//			document.add(paragraph2criteria3114);

//			if (criteria3Record.getYearTable3131() != null) {
//				Table table3131criteria3 = new Table(criteria3Record.getYearTable3131().size(), 2);
//
//				table3131criteria3.setPadding(10);
//				table3131criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Record.getYearTable3131().size(); i++) {
//					table3131criteria3.addCell(criteria3Record.getYearTable3131().get(i).getInput3131y());
//
//				}
//				for (int i = 0; i < criteria3Record.getYearTable3131().size(); i++) {
//					table3131criteria3.addCell(criteria3Record.getYearTable3131().get(i).getInput3131v());
//
//				}
//
//				document.add(table3131criteria3);
//			}

//			PdfPTable table3criteria311 = new PdfPTable(2);
//			PdfPTable table33criteria3111 = new PdfPTable(1);
//
//			table3criteria311.setWidthPercentage(100f);
//			table33criteria3111.setWidthPercentage(100f);
//
//			PdfPCell cell31criteria31 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			cell31criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell31criteria311 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			cell31criteria311.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell33criteria310 = new PdfPCell(new Paragraph("Any additional information\r\n"));
//			cell33criteria310.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell34criteria310 = new PdfPCell(
//					new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : ""));
//			cell34criteria310.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell35criteria310 = new PdfPCell(
//					new Paragraph("Provide a list of research fellows and their fellowship details (Data Template)"));
//			cell35criteria310.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell36criteria310 = new PdfPCell(
//					new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : ""));
//			cell36criteria310.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table3criteria311.addCell(cell31criteria31);
//			table3criteria311.addCell(cell31criteria311);
//			table3criteria311.addCell(cell33criteria310);
//			table3criteria311.addCell(cell34criteria310);
//			table3criteria311.addCell(cell35criteria310);
//			table3criteria311.addCell(cell36criteria310);
//
////table33criteria31.addCell(cell313criteria3);
////table33criteria31.addCell(cell3131criteria3);
//			table33criteria3111.addCell(table3criteria311);
//// document.add(cell313criteria3);
//// document.add(cell3131criteria3);
//			table33criteria3111.setSpacingBefore(20f);
//			table33criteria3111.setSpacingAfter(20f);
//			document.add(table33criteria3111);
//
//			Paragraph paragraph2criteria31123 = new Paragraph(
//					"3.1.5: Institution has the following facilities to support research:\r\n"
//							+ "1. Central Instrumentation Centre\r\n" + "2. Animal House/Green House\r\n"
//							+ "3. Museum\r\n" + "5. Business Lab\r\n" + "6. Research/Statistical Databases\r\n"
//							+ "7. Mootcourt\r\n" + "8. Theatre\r\n" + "9. Art Gallery\r\n"
//							+ "10. Any other facility to support research.\r\n" + "\r\n");
//			document.add(paragraph2criteria31123);
//			Paragraph paragraph2criteria31124 = new Paragraph(
//					criteria3Record != null ? criteria3Record.getCriteria31Qn().get(0).getResponse315() : "");
//			document.add(paragraph2criteria31124);
//
//			PdfPTable table3criteria3110 = new PdfPTable(2);
//			PdfPTable table33criteria31110 = new PdfPTable(1);
//
//			table3criteria3110.setWidthPercentage(100f);
//			table33criteria31110.setWidthPercentage(100f);
//
//			PdfPCell cell31criteria310 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			cell31criteria310.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell31criteria3110 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			cell31criteria3110.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell33criteria3100 = new PdfPCell(
//					new Paragraph("Provide the link of videos and geo-tagged photographs\r\n"));
//			cell33criteria3100.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell34criteria3100 = new PdfPCell(
//					new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : ""));
//			cell34criteria3100.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell35criteria3100 = new PdfPCell(new Paragraph(
//					"Upload the list of facilities provided by the university and their year/s of establishment"));
//			cell35criteria3100.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell36criteria3100 = new PdfPCell(
//					new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : ""));
//			cell36criteria3100.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell35criteria31000 = new PdfPCell(new Paragraph("Upload any additional information"));
//			cell35criteria31000.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell36criteria31000 = new PdfPCell(
//					new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : ""));
//			cell36criteria31000.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//			table33criteria31110.addCell(cell31criteria310);
//			table33criteria31110.addCell(cell31criteria3110);
//			table33criteria31110.addCell(cell33criteria3100);
//			table33criteria31110.addCell(cell34criteria3100);
//			table33criteria31110.addCell(cell35criteria3100);
//			table33criteria31110.addCell(cell36criteria3100);
//			table33criteria31110.addCell(cell35criteria31000);
//			table33criteria31110.addCell(cell36criteria31000);
//
////table33criteria31.addCell(cell313criteria3);
////table33criteria31.addCell(cell3131criteria3);
//			table3criteria3110.addCell(table33criteria31110);
//// document.add(cell313criteria3);
//// document.add(cell3131criteria3);
//			table3criteria3110.setSpacingBefore(20f);
//			table3criteria3110.setSpacingAfter(20f);
//			document.add(table3criteria3110);
//
//			Paragraph paragraph2criteria3116 = new Paragraph(
//					"3.1.6: Percentage of departments with UGC-SAP, CAS, DST-FIST, DBT, ICSSR and other recognitions by national and international agencies (Data for the latest completed academic year)");
//			document.add(paragraph2criteria3116);
//			Paragraph paragraph2criteria31161 = new Paragraph(
//					criteria3Record != null ? criteria3Record.getCriteria31Qn().get(0).getResponse316() : "");
//			document.add(paragraph2criteria31161);
//			Paragraph paragraph2criteria31162 = new Paragraph(
//					"3.1.6.1: The Number of departments with UGC-SAP, CAS, DST-FIST , DBT, ICSSR and other similar recognitions by national and international agencies");
//			document.add(paragraph2criteria31162);
//
//			Paragraph paragraph2criteria31163 = new Paragraph(
//					criteria3Record != null ? criteria3Record.getCriteria31Qn().get(0).getInput3161t1() : "");
//			document.add(paragraph2criteria31163);
//			Paragraph paragraph2criteria31164 = new Paragraph(
//					"3.1.6.1: Total number of departments offering academic programmes");
//			document.add(paragraph2criteria31164);
//			Paragraph paragraph2criteria31165 = new Paragraph(
//					criteria3Record != null ? criteria3Record.getCriteria31Qn().get(0).getInput3162t1() : "");
//			document.add(paragraph2criteria31165);
//
//			PdfPTable table3criteria31106 = new PdfPTable(2);
//			PdfPTable table33criteria311106 = new PdfPTable(1);
//
//			table3criteria31106.setWidthPercentage(100f);
//			table33criteria311106.setWidthPercentage(100f);
//
//			PdfPCell cell31criteria3106 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//			cell31criteria3106.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell31criteria31106 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//			cell31criteria31106.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell33criteria31006 = new PdfPCell(new Paragraph("Upload any additional information\r\n"));
//			cell33criteria31006.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell34criteria31006 = new PdfPCell(
//					new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : ""));
//			cell34criteria31006.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//			table33criteria311106.addCell(cell31criteria3106);
//			table33criteria311106.addCell(cell31criteria31106);
//			table33criteria311106.addCell(cell33criteria31006);
//			table33criteria311106.addCell(cell34criteria31006);
//			table3criteria31106.addCell(table33criteria311106);
//			table3criteria31106.setSpacingBefore(20f);
//			table3criteria31106.setSpacingAfter(20f);
//			document.add(table3criteria31106);

///////////cr3.2

			Paragraph paragraph3criteria3 = new Paragraph("3.2	Resource Mobilization for Research\r\n",
					font2);
			paragraph3criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph3criteria3);

/// create table 4//
			PdfPTable table4criteria3 = new PdfPTable(2);
			PdfPTable table43criteria31 = new PdfPTable(1);

			table4criteria3.setWidthPercentage(100f);
			table43criteria31.setWidthPercentage(100f);
			
			PdfPCell cell41criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell41criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell42criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell42criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell43criteria3 = new PdfPCell(new Paragraph("List of project and grant details\r\n\r\n",font5));
			cell43criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell44criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell44criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell45criteria3 = new PdfPCell(new Paragraph(
					"e-copies of the grant award letters for research projects sponsored by government and non- government\r\n\r\n",font5));
			cell45criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell46criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell46criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell47criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell47criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell48criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(9).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell48criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell32100criteria3 = new PdfPCell(new Paragraph(
					"3.2.1 Research funding received by the institution and its faculties \r\n"
					+ "through Government and non-government sources such as industry, \r\n"
					+ "corporate houses, international bodies for research project, \r\n"
					+ "endowment research chairs during the last five years \r\n"
							+ "\r\n\r\n" + "Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria32Ql().get(0).getResponse321()
									: "")+"\r\n\r\n",
					font4));
			PdfPCell cell3211criteria3 = new PdfPCell(new Paragraph(
					"3.2.1.1 Total Grants research funding received by the institution and \r\n"
					+ "its faculties through Government and non-government sources such as \r\n"
					+ "industry, corporate houses, international bodies for research project, \r\n"
					+ "endowment research chairs during the last five years (INR in Lakhs)\r\n"
					+ ""
							+ "\r\n\r\n",
					font4));
			table43criteria31.addCell(cell32100criteria3);
			table43criteria31.addCell(cell3211criteria3);

			table4criteria3.addCell(cell41criteria3);
			table4criteria3.addCell(cell42criteria3);
			table4criteria3.addCell(cell43criteria3);
			table4criteria3.addCell(cell44criteria3);
			table4criteria3.addCell(cell45criteria3);
			table4criteria3.addCell(cell46criteria3);
			table4criteria3.addCell(cell47criteria3);
			table4criteria3.addCell(cell48criteria3);

//			table43criteria31.addCell(table4criteria3);

			table43criteria31.setSpacingBefore(20f);
			table43criteria31.setSpacingAfter(20f);

			document.add(table43criteria31);
			document.add(table4criteria3);
// create table 3211/////

			if (criteria3Record.getYearTable3121() != null) {
				Table table3211criteria3 = new Table(criteria3Record.getYearTable3121().size(), 2);

				table3211criteria3.setPadding(5);
				table3211criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3211().size(); i++) {
					Cell cell31210110criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3211().get(i).getInput3211y(),font5));
					cell31210110criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3211criteria3.addCell(cell31210110criteria3);
				}
				for (int i = 0; i < criteria3Record.getYearTable3211().size(); i++) {
					Cell cell312101criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3211().get(i).getInput3211v(),font5));
					cell312101criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3211criteria3.addCell(cell312101criteria3);
				}

				document.add(table3211criteria3);
			}

// create table 5 //////
			PdfPTable table5criteria3 = new PdfPTable(2);
			PdfPTable table53criteria31 = new PdfPTable(1);

			table5criteria3.setWidthPercentage(100f);
			table53criteria31.setWidthPercentage(100f);
			
			table53criteria31.setSpacingAfter(20f);
			table53criteria31.setSpacingBefore(20f);
			
			PdfPCell cell51criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell51criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell52criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell52criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell53criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell53criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell54criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(10).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell54criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell55criteria3 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n",font5));
			cell55criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell56criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(10).getCriteria3FilePath() : ""+"\r\n\r\n\r\n\r\n\r\n\r\n",font5));
			cell56criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5criteria3.addCell(cell51criteria3);
			table5criteria3.addCell(cell52criteria3);
			table5criteria3.addCell(cell53criteria3);
			table5criteria3.addCell(cell54criteria3);
			table5criteria3.addCell(cell55criteria3);
			table5criteria3.addCell(cell56criteria3);
			PdfPCell cell322criteria3 = new PdfPCell(new Paragraph(
					"3.2.2 Percentage of teachers having research projects during the last five years (INR in Lakhs)\r\n"
							+ "\r\n\r\n" + "Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria32Qn().get(0).getResponse322()
									: "")+"\r\n\r\n",
					font4));
//			table5criteria3.addCell(cell322criteria3);
			PdfPCell cell3221criteria3 = new PdfPCell(new Paragraph(
					"3.2.2.1: Number of teachers having research projects during the last \r\n"
					+ "five years\r\n\r\n"
					,font4));
			
			
//table53criteria31.addCell(cell322criteria3);

//table53criteria31.addCell(cell3221criteria3);

			table53criteria31.addCell(cell322criteria3);
			table53criteria31.addCell(cell3221criteria3);
			
// document.add(cell322criteria3);
// document.add(cell3221criteria3);
//table53criteria31.setSpacingBefore(20f);
//table53criteria31.setSpacingAfter(20f);

			document.add(table53criteria31);
			document.add(table5criteria3);
// create table 3221 //////

			if (criteria3Record.getYearTable3221() != null) {
				Table table3221criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);

				table3221criteria3.setPadding(5);
				table3221criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
					Cell cell31210110criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3221().get(i).getInput3221y(),font5));
					cell31210110criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3221criteria3.addCell(cell31210110criteria3);
					
				}
				for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
					Cell cell312110criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3221().get(i).getInput3221v(),font5));
					cell312110criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3221criteria3.addCell(cell312110criteria3);
				}

				document.add(table3221criteria3);
			}

// create table 6////
			PdfPTable table6criteria3 = new PdfPTable(2);
			PdfPTable table63criteria31 = new PdfPTable(1);

			table6criteria3.setWidthPercentage(100f);
			table63criteria31.setWidthPercentage(100f);
			
			
			PdfPCell cell61criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell61criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell62criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell62criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell63criteria3 = new PdfPCell(new Paragraph(
					"Upload copies of the letter of the university recognizing faculty as research guides\r\n\r\n",font5));
			cell63criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell64criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(11).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell64criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell65criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell65criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell66criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(12).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell66criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell67criteria3 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n",font5));
			cell67criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell68criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(12).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell68criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table6criteria3.addCell(cell61criteria3);
			table6criteria3.addCell(cell62criteria3);
			table6criteria3.addCell(cell63criteria3);
			table6criteria3.addCell(cell64criteria3);
			table6criteria3.addCell(cell65criteria3);
			table6criteria3.addCell(cell66criteria3);
			table6criteria3.addCell(cell67criteria3);
			table6criteria3.addCell(cell68criteria3);
			PdfPCell cell323criteria3 = new PdfPCell(new Paragraph(
					"3.2.3 Percentage of teachers recognised as research guides\r\n" + "\r\n\r\n" + "Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria32Qn().get(0).getResponse323()
									: "")+"\r\n\r\n",
					font4));
			table63criteria31.addCell(cell323criteria3);
			
			PdfPCell cell3231criteria3 = new PdfPCell(
					new Paragraph("3.2.3.1 Number of teachers recognized as research guides\r\n\r\n" + "Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria32Qn().get(0).getInput3231t1()
									: "")+"\r\n\r\n",
							font4));
//table6criteria3.addCell(cell323criteria3);
			table63criteria31.addCell(cell3231criteria3);
//			table63criteria31.addCell(table6criteria3);

// document.add(cell323criteria3);
// document.add(cell3231criteria3);
			table63criteria31.setSpacingBefore(20f);
			table63criteria31.setSpacingAfter(20f);

			document.add(table63criteria31);
			document.add(table6criteria3);
/// create table 7 ///
			PdfPTable table7criteria3 = new PdfPTable(2);
			PdfPTable table73criteria31 = new PdfPTable(1);

			table7criteria3.setWidthPercentage(100f);
			table73criteria31.setWidthPercentage(100f);

			PdfPCell cell71criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell71criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell72criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell72criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell73criteria3 = new PdfPCell(
					new Paragraph("Supporting document from Funding Agency\r\n\r\n",font5));
			cell73criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell74criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(13).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell74criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell75criteria3 = new PdfPCell(
					new Paragraph("List of research projects and funding details\r\n\r\n",font5));
			cell75criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell76criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(14).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell76criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell77criteria3 = new PdfPCell(new Paragraph("Paste link to funding agency website\r\n\r\n",font5));
			cell77criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell78criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(14).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell78criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table7criteria3.addCell(cell71criteria3);
			table7criteria3.addCell(cell72criteria3);
			table7criteria3.addCell(cell73criteria3);
			table7criteria3.addCell(cell74criteria3);
			table7criteria3.addCell(cell75criteria3);
			table7criteria3.addCell(cell76criteria3);
			table7criteria3.addCell(cell77criteria3);
			table7criteria3.addCell(cell78criteria3);
			PdfPCell cell324criteria3 = new PdfPCell(new Paragraph(
					"3.2.4 Average percentage of departments having Research projects funded by government and non- government agencies during the last five years\r\n"
							+ "\r\n\r\n" + "Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria32Qn().get(0).getResponse324()
									: "")+"\r\n\r\n",
					font4));
	//		table7criteria3.addCell(cell324criteria3);
			PdfPCell cell3241criteria3 = new PdfPCell(new Paragraph(
					"3.2.4.1 Number of departments having Research projects funded by government and non- government agencies during the last five years\r\n"
							+ "\r\n\r\n",
					font4));

//			PdfPCell cell3242criteria3 = new PdfPCell(new Paragraph(
//					"3.2.4.1 Number of departments having Research projects funded by government and non- government agencies during the last five years\r\n"
//							+ "\r\n\r\n",
//					font5));

//table73criteria31.addCell(cell324criteria3);
		//	table73criteria31.addCell(cell3241criteria3);
//			table73criteria31.addCell(cell3242criteria3);

//			table73criteria31.addCell(table7criteria3);
			
			
// document.add(cell324criteria3);
// document.add(cell3241criteria3);
// document.add(cell3242criteria3);
			table73criteria31.setSpacingBefore(20f);
			table73criteria31.setSpacingAfter(20f);

			document.add(table73criteria31);
			document.add(table7criteria3);
/// create table 3241 ///

			if (criteria3Record.getYearTable3241() != null) {
				Table table3241criteria3 = new Table(criteria3Record.getYearTable3241().size(), 2);

				table3241criteria3.setPadding(5);
				table3241criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3241().size(); i++) {
					Cell cell3120criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3241().get(i).getInput3241y(),font5));
					
					cell3120criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3241criteria3.addCell(cell3120criteria3);
					
				}
				for (int i = 0; i < criteria3Record.getYearTable3241().size(); i++) {
					Cell cell3120criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3241().get(i).getInput3241v(),font5));
					cell3120criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3241criteria3.addCell(cell3120criteria3);
					
				}

		//		document.add(table3241criteria3);
			}
			
			
			
			Paragraph paragraph4criteria3 = new Paragraph("3.3	Innovation Ecosystem\r\n",font2);
			paragraph4criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph4criteria3);
			// create table 8 ///
			PdfPTable table8criteria3 = new PdfPTable(2);
			PdfPTable table81criteria31 = new PdfPTable(1);

			table8criteria3.setWidthPercentage(100f);
			table81criteria31.setWidthPercentage(100f);
			PdfPCell cell81criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell81criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell82criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell82criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell83criteria3 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n", font5));
			cell83criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell84criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(15).getCriteria3FilePath() : "", font5));
			cell84criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell85criteria3 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n", font5));
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
					"3.3.1	Institution has created an eco system for innovations, creation and transfer of knowledge supported by dedicated centers for research, entrepreneurship, community orientation, Incubation etc.\r\n"
							+ "\r\n\r\n" + "Response:\r\n"
							+ (criteria3Record != null
									? criteria3Record.getCriteria33Qn().get(0).getResponse331()
									: "")+"\r\n\r\n",
					font4));
			table81criteria31.addCell(cell331criteria3);
//			table81criteria31.addCell(table8criteria3);

			// document.add(cell331criteria3);

			table81criteria31.setSpacingBefore(20f);
			table81criteria31.setSpacingAfter(20f);

			document.add(table81criteria31);
			document.add(table8criteria3);
			/// create table 9 ////
			PdfPTable table9criteria3 = new PdfPTable(2);
			PdfPTable table91criteria31 = new PdfPTable(1);

			table9criteria3.setWidthPercentage(100f);
			table91criteria31.setWidthPercentage(100f);
			PdfPCell cell91criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell91criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell92criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell92criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell93criteria3 = new PdfPCell(new Paragraph("Reports of the event\r\n\r\n", font5));
			cell93criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell94criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(16).getCriteria3FilePath() : "", font5));
			cell94criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell95criteria3 = new PdfPCell(new Paragraph("List of workshops/seminars during last 5 years\r\n\r\n", font5));
			cell95criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell96criteria3 = new PdfPCell(new Paragraph(""));
			cell96criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria3.addCell(cell91criteria3);
			table9criteria3.addCell(cell92criteria3);
			table9criteria3.addCell(cell93criteria3);
			table9criteria3.addCell(cell94criteria3);
			table9criteria3.addCell(cell95criteria3);
			table9criteria3.addCell(cell96criteria3);
			PdfPCell cell332criteria3 = new PdfPCell(new Paragraph(
					"3.3.2 Number of workshops/seminars conducted on Research methodology, Intellectual Property Rights (IPR),entrepreneurship, skill development during the last five years.\r\n"
							+ "\r\n\r\n" + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria33Qn().get(0).getResponse332()
									: "")+"\r\n\r\n",
					font4));
			PdfPCell cell3321criteria3 = new PdfPCell(new Paragraph(
					"3.3.2.1 Total number of workshops/seminars conducted on Research methodology, Intellectual Property Rights (IPR),entrepreneurship, skill development year-wise during the last five years.\r\n"
							+ "\r\n\r\n",
					font4));
	//		table91criteria31.addCell(cell332criteria3);
			table91criteria31.addCell(cell3321criteria3);
//			table91criteria31.addCell(table9criteria3);

			// document.add(cell332criteria3);
			// document.add(cell3321criteria3);
			table91criteria31.setSpacingBefore(20f);
			table91criteria31.setSpacingAfter(20f);
			document.add(table91criteria31);
			document.add(table9criteria3);
			// create a table 3321 //

			if (criteria3Record != null) {
				Table table3321criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);

				table3321criteria3.setPadding(5);
				table3321criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3321().size(); i++) {
					Cell cell31200criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3321().get(i).getInput3321y(),font5));
					
					cell31200criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3321criteria3.addCell(cell31200criteria3);

				}
				for (int i = 0; i < criteria3Record.getYearTable3321().size(); i++) {
					Cell cell31200criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3321().get(i).getInput3321v(),font5));
					cell31200criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3321criteria3.addCell(cell31200criteria3);

				}

			//	document.add(table3321criteria3);
			}


/////////////////////cr3.4

			Paragraph paragraph5criteria3 = new Paragraph("3.4	Research Publications and Awards\r\n\r\n", font2);
			paragraph5criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph5criteria3);
// create table 10 ///
			PdfPTable table10criteria3 = new PdfPTable(2);
			PdfPTable table101criteria31 = new PdfPTable(1);
			
			table10criteria3.setWidthPercentage(100f);
			table101criteria31.setWidthPercentage(100f);
			
			PdfPCell cell101criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell101criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell102criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell102criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell103criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell103criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell104criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell104criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell105criteria3 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n",font5));
			cell105criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell106criteria3 = new PdfPCell(new Paragraph(""));
			cell106criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10criteria3.addCell(cell101criteria3);
			table10criteria3.addCell(cell102criteria3);
			table10criteria3.addCell(cell103criteria3);
			table10criteria3.addCell(cell104criteria3);
			table10criteria3.addCell(cell105criteria3);
			table10criteria3.addCell(cell106criteria3);
			PdfPCell cell341criteria3 = new PdfPCell(new Paragraph(
					" 3.4.1 The Institution ensures implementation of its stated Code of Ethics for research through the following: 1. Inclusion of research ethics in the research methodology course work 2. Presence ofEthics committee 3. Plagiarism check through software 4. Research Advisory Committee\r\n"
						 + "3.4.1.1The institution has a stated Code of Ethics for research and the \r\n"
						 + "implementation of which is ensured through the following: \r\n"
						 + "1. Inclusion of research ethics in the research methodology course \r\n"
						 + "work \r\n"
						 + "2. Presence of institutional Ethics committee (Animal, Chemical, \r\n"
						 + "Bio-ethics etc.)\r\n"
						 + "3. Plagiarism check through software\r\n"
						 + "4. Research Advisory Committee\r\n"
						 + "Options:\r\n"
						 + "A. All of the above\r\n"
						 + "B. Any 3 of the above\r\n"
						 + "C. Any 2 of the above\r\n"
						 + "D. Any 1 of the above\r\n"
						 + "E. None of the above:"
							+ (criteria3Record != null ? criteria3Record.getCriteria34Ql().get(0).getResponse341()
									: "")+"\r\n\r\n",
							font4));
			table101criteria31.addCell(cell341criteria3);
//			table101criteria31.addCell(table10criteria3);
// document.add(cell341criteria3);
			table10criteria3.setSpacingBefore(20f);
			table10criteria3.setSpacingAfter(20f);
			document.add(table101criteria31);
			document.add(table10criteria3);

/// create table 11 ////
			PdfPTable table11criteria3 = new PdfPTable(2);
			PdfPTable table111criteria31 = new PdfPTable(1);

			table11criteria3.setWidthPercentage(100f);
			table111criteria31.setWidthPercentage(100f);

			PdfPCell cell111criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			
			cell111criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell112criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell112criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell113criteria3 = new PdfPCell(new Paragraph(
					"List of PhD scholars and their details like name of the guide , title of thesis, year of award etc\r\n\r\n",font5));
			cell113criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell114criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell114criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell115criteria3 = new PdfPCell(
					new Paragraph("URL to the research page on HEI web site\r\n\r\n",font5));
			cell115criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell116criteria3 = new PdfPCell(new Paragraph(""));
			table11criteria3.addCell(cell111criteria3);
			table11criteria3.addCell(cell112criteria3);
			table11criteria3.addCell(cell113criteria3);
			table11criteria3.addCell(cell114criteria3);
			table11criteria3.addCell(cell115criteria3);
			table11criteria3.addCell(cell116criteria3);
			PdfPCell cell342criteria3 = new PdfPCell(new Paragraph(
					"3.4.2  Number of candidates registered for Ph.D per teacher (as per the \r\n"
					+ "data given w.r.t recognized Ph.D guides/ supervisors provided at \r\n"
					+ "3.2.3 metric) during the last five years"
							+ (criteria3Record != null ? criteria3Record.getCriteria34Qn().get(0).getResponse342()
									: "")+"\r\n\r\n",
					font4));

			table111criteria31.addCell(cell342criteria3);
			document.add(cell342criteria3);
			PdfPCell cell3421criteria3 = new PdfPCell(
					new Paragraph("3.4.2.1 Number of candidates registered for Ph.D during the\r\n"
							+ "last 5 years:" + "\r\n\r\n", font5));
			PdfPCell cell3422criteria3 = new PdfPCell(
					new Paragraph("3.4.2.2 Number of recognized guides during the last five years\r\n"
					
							+ (criteria3Record != null ? criteria3Record.getCriteria34Qn().get(0).getInput3422t1()
									: ""),
							font5));
			table111criteria31.addCell(cell3421criteria3);
			table111criteria31.addCell(cell3422criteria3);
//			table111criteria31.addCell(table11criteria3);

// document.add(cell3421criteria3);
// document.add(cell3422criteria3);
			table111criteria31.setSpacingAfter(20f);
			table111criteria31.setSpacingAfter(20f);

			document.add(table111criteria31);

			document.add(table11criteria3);
/// create table 12 /////
			PdfPTable table12criteria3 = new PdfPTable(2);
			PdfPTable table123criteria31 = new PdfPTable(1);

			table12criteria3.setWidthPercentage(100f);
			table123criteria31.setWidthPercentage(100f);
			
			PdfPCell cell121criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell121criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell122criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell122criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell123criteria3 = new PdfPCell(new Paragraph(
					"List of PhD scholars and their details like name of the guide , title of thesis, year of award etc\r\n\r\n",
					font5));
			cell123criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell124criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell124criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell125criteria3 = new PdfPCell(
					new Paragraph("URL to the research page on HEI web site\r\n\r\n", font5));
			cell125criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell126criteria3 = new PdfPCell(new Paragraph(""));
			cell126criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table12criteria3.addCell(cell121criteria3);
			table12criteria3.addCell(cell122criteria3);
			table12criteria3.addCell(cell123criteria3);
			table12criteria3.addCell(cell124criteria3);
			table12criteria3.addCell(cell125criteria3);
			table12criteria3.addCell(cell126criteria3);
			PdfPCell cell343criteria30 = new PdfPCell(new Paragraph(
					"3.4.3 Number of research papers per teachers in the Journals notified on UGC website during the last five years\r\n"
							+ "\r\n\r\n" + "Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria34Qn().get(0).getResponse343()
									: "")+"\r\n\r\n",
							font4));
			table12criteria3.addCell(cell343criteria30);
			PdfPCell cell3431criteria3 = new PdfPCell(new Paragraph(
					"3.4.3.1 Number of research papers in the Journals notified on UGC website during the last five years\r\n\r\n"
							+ "",
					font4));
//table123criteria31.addCell(cell343criteria3);
			table123criteria31.addCell(cell3431criteria3);
//			table123criteria31.addCell(table12criteria3);

// document.add(cell343criteria3);
// document.add(cell3431criteria3);
			table123criteria31.setSpacingBefore(20f);
			table123criteria31.setSpacingAfter(20f);

			document.add(table123criteria31);
			document.add(table12criteria3);
/// create table 3431 ////

			if (criteria3Record.getYearTable3431() != null) {
				Table table3431criteria3 = new Table(criteria3Record.getYearTable3431().size(), 2);

				table3431criteria3.setPadding(5);
				table3431criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3431().size(); i++) {
					Cell cell31200criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3431().get(i).getInput3431y(),font5));
					cell31200criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3431criteria3.addCell(cell31200criteria3);
				}
				for (int i = 0; i < criteria3Record.getYearTable3431().size(); i++) {
					Cell cell312110criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3431().get(i).getInput3431v(),font5));
					cell312110criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3431criteria3.addCell(cell312110criteria3);
				}

				document.add(table3431criteria3);
			}
/// create table 13 //
			PdfPTable table13criteria3 = new PdfPTable(2);
			PdfPTable table131criteria31 = new PdfPTable(1);
			table131criteria31.setWidthPercentage(100f);
			
			
			
			table13criteria3.setWidthPercentage(100f);
		

			PdfPCell cell131criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell131criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell132criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell132criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell133criteria3 = new PdfPCell(
					new Paragraph("List books and chapters in edited volumes / books published\r\n\r\n",font5));
			cell133criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell134criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell134criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell135criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell135criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell136criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell136criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table13criteria3.addCell(cell131criteria3);
			table13criteria3.addCell(cell132criteria3);
			table13criteria3.addCell(cell133criteria3);
			table13criteria3.addCell(cell134criteria3);
			table13criteria3.addCell(cell135criteria3);
			table13criteria3.addCell(cell136criteria3);
			PdfPCell cell344criteria3 = new PdfPCell(new Paragraph(
					"3.4.4 Number of books and chapters in edited volumes / books published per teacher during the last five years\r\n"
							+ " \r\n\r\n"  + "Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria34Qn().get(0).getResponse344()
									: ""),
							font4));
			PdfPCell cell3441criteria3 = new PdfPCell(new Paragraph(
					"3.4.4.1 Number of books and chapters in edited volumes published \r\n"
					+ "year wise during the last five years"
							+ "\r\n\r\n",
					font4));
//table131criteria31.addCell(cell344criteria3);
			table131criteria31.addCell(cell344criteria3);
			table131criteria31.addCell(cell3441criteria3);

//			document.add(cell344criteria3);
//			document.add(cell3441criteria3);
			table131criteria31.setSpacingBefore(20f);
			table131criteria31.setSpacingAfter(20f);

			document.add(table131criteria31);
			document.add(table13criteria3);
// create table 3441 //

			if (criteria3Record.getYearTable3441().size() > 0) {
				Table table3441criteria3 = new Table(criteria3Record.getYearTable3441().size(), 2);

				table3441criteria3.setPadding(5);
				table3441criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
					Cell cell01criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3441().get(i).getInput3441y(),font5));
					cell01criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3441criteria3.addCell(cell01criteria3);
				}
				for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
					Cell cell011criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3441().get(i).getInput3441v(),font5));
					cell011criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3441criteria3.addCell(cell011criteria3);
				}

				document.add(table3441criteria3);
			}

// create table 14 //
			PdfPTable table14criteria3 = new PdfPTable(2);
			PdfPTable table141criteria31 = new PdfPTable(1);

			table14criteria3.setWidthPercentage(100f);
			table141criteria31.setWidthPercentage(100f);

			PdfPCell cell141criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell141criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell142criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell142criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell143criteria3 = new PdfPCell(
					new Paragraph("Bibliometrics of the publications during the last five years\r\n\r\n",font5));
			cell143criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell144criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell144criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table14criteria3.addCell(cell141criteria3);
			table14criteria3.addCell(cell142criteria3);
			table14criteria3.addCell(cell143criteria3);
			table14criteria3.addCell(cell144criteria3);

			PdfPCell cell345criteria3 = new PdfPCell(new Paragraph(
					"3.4.5 Bibliometrics of the publications during the last five years based on average citation index in Scopus/ Web of Science or PubMed\r\n"
							
							
						,	font4));
			table141criteria31.addCell(cell345criteria3);
			

			PdfPCell cell345criteria31 = new PdfPCell(new Paragraph(
					"3.4.5.1: Total number of Citations in Scopus in 5 years \r\n"
					+ "Total number of Citations in Web of Science in 5 years\r\n"
							,
							font4));
			cell345criteria31.setExtraParagraphSpace(5);
			table141criteria31.addCell(cell345criteria31);
			
			
			PdfPCell cell345criteria311 = new PdfPCell(new Paragraph(
					"3.4.5.1: Total number of Publications in Scopus in 5 years \r\n"
					+ "Total number of Publications in Web of Science in 5 years "
					+ (criteria3Record != null ? criteria3Record.getCriteria34Qn().get(0).getResponse345()
							: ""),		
							font4));
			cell345criteria311.setExtraParagraphSpace(5);
			table141criteria31.addCell(cell345criteria311);
			
			
			
			
			
//			table141criteria31.addCell(table14criteria3);
			table141criteria31.setSpacingBefore(20f);
			table141criteria31.setSpacingAfter(20f);
			document.add(table141criteria31);
			document.add(table14criteria3);
			
			
			
// create table 15 //
			PdfPTable table15criteria3 = new PdfPTable(2);
			PdfPTable table153criteria31 = new PdfPTable(1);

			table15criteria3.setWidthPercentage(100f);
			table153criteria31.setWidthPercentage(100f);

			PdfPCell cell151criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell151criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell152criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell152criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell153criteria3 = new PdfPCell(new Paragraph(
					"Bibiliometrics of publications based on Scopus/ Web of Science - h-index of the Institution\r\n\r\n",font4));
			cell153criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell154criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell154criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table15criteria3.addCell(cell151criteria3);
			table15criteria3.addCell(cell152criteria3);
			table15criteria3.addCell(cell153criteria3);
			table15criteria3.addCell(cell154criteria3);
			PdfPCell cell346criteria3 = new PdfPCell(new Paragraph(
					"3.4.6 Bibliometrics of the publications during the last five years based on Scopus/ Web of Science - h- index of the Institution\r\n\r\n"
							+"3.4.6.1: h-index of the institution based on publications made in \r\n"
							+ "journals of Scopus during the last five years\r\n"
							+ "h-index of the institution based on publications made in journals of \r\n"
							+ "Web of Science during the last five years"
							+""
							
							+
							"Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria34Qn().get(0).getResponse346()
									: "")+"\r\n\r\n",
							font4));
			table153criteria31.addCell(cell346criteria3);
//			table153criteria31.addCell(table15criteria3);

// document.add(cell346criteria3);
			table153criteria31.setSpacingBefore(20f);
			table153criteria31.setSpacingAfter(20f);
			document.add(table153criteria31);
			document.add(table15criteria3);

/////////////////////cr3.5

			Paragraph paragraph6criteria3 = new Paragraph("3.5	Consultancy\r\n\r\n", font2);
			paragraph6criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph6criteria3);
// create table 16 //
			PdfPTable table16criteria3 = new PdfPTable(2);
			PdfPTable table161criteria31 = new PdfPTable(1);

			table16criteria3.setWidthPercentage(100f);
			table161criteria31.setWidthPercentage(100f);

			PdfPCell cell161criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell161criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell162criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell162criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell163criteria3 = new PdfPCell(
					new Paragraph("List of consultants and revenue generated by them\r\n\r\n",font5));
			cell163criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell164criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell164criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell165criteria3 = new PdfPCell(new Paragraph(
					"Audited statements of accounts indicating the revenue generated through consultancy and corporate training\r\n\r\n",font5));
			cell165criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell166criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell166criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell167criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell167criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell168criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell168criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table16criteria3.addCell(cell161criteria3);
			table16criteria3.addCell(cell162criteria3);
			table16criteria3.addCell(cell163criteria3);
			table16criteria3.addCell(cell164criteria3);
			table16criteria3.addCell(cell165criteria3);
			table16criteria3.addCell(cell166criteria3);
			table16criteria3.addCell(cell167criteria3);
			table16criteria3.addCell(cell168criteria3);
			PdfPCell cell351criteria3 = new PdfPCell(new Paragraph(
					"3.5.1 Revenue generated from consultancy and corporate training during the last five years (INR in Lakhs).\r\n\r\n"
							 + "Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria35Qn().get(0).getResponse351()
									: "")+"\r\n\r\n",font4));
			PdfPCell cell3511criteria3 = new PdfPCell(new Paragraph(
					"3.5.1.1 amount generated from consultancy and corporate training year-wise during the last five years (INR in lakhs).\r\n"
							+ "\r\n\r\n",
					font4));

			table161criteria31.addCell(cell351criteria3);
			table161criteria31.addCell(cell3511criteria3);
//			table161criteria31.addCell(table16criteria3);

// document.add(cell351criteria3);
// document.add(cell3511criteria3);
			table16criteria3.setSpacingBefore(20f);
			table16criteria3.setSpacingAfter(20f);
			document.add(table161criteria31);
			document.add(table16criteria3);
// create table 3511 ///

			if (criteria3Record.getYearTable3511() != null) {
				Table table3511criteria3 = new Table(criteria3Record.getYearTable3511().size(), 2);

				table3511criteria3.setPadding(5);
				table3511criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3511().size(); i++) {
					Cell cell012criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3511().get(i).getInput3511y(),font5));
					cell012criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3511criteria3.addCell(cell012criteria3);

				}
				for (int i = 0; i < criteria3Record.getYearTable3511().size(); i++) {
					Cell cell0121criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3511().get(i).getInput3511v(),font5));
					cell0121criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3511criteria3.addCell(cell0121criteria3);
				}

				document.add(table3511criteria3);
			}

// create table 17 ///

			PdfPTable table17criteria3 = new PdfPTable(2);
			PdfPTable table173criteria31 = new PdfPTable(1);

			table17criteria3.setWidthPercentage(100f);
			table173criteria31.setWidthPercentage(100f);

			PdfPCell cell171criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell171criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell172criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell172criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell173criteria3 = new PdfPCell(new Paragraph(
					"List of training programmes, teachers and staff trained for undertaking consultancy\r\n\r\n",font5));
			cell173criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell174criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell174criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell175criteria3 = new PdfPCell(
					new Paragraph("List of facilities and staff available for undertaking consultancy\r\n\r\n",font5));
			cell175criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell176criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell176criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell177criteria3 = new PdfPCell(new Paragraph(
					"Audited statements of accounts indicating the expenditure incurred on developing facilities and training teachers and staff for undertaking consultancy\r\r\n",font5));
			cell177criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell178criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell178criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell179criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell179criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell180criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell180criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table17criteria3.addCell(cell171criteria3);
			table17criteria3.addCell(cell172criteria3);
			table17criteria3.addCell(cell173criteria3);
			table17criteria3.addCell(cell174criteria3);
			table17criteria3.addCell(cell175criteria3);
			table17criteria3.addCell(cell176criteria3);
			table17criteria3.addCell(cell177criteria3);
			table17criteria3.addCell(cell178criteria3);
			table17criteria3.addCell(cell179criteria3);
			table17criteria3.addCell(cell180criteria3);
			PdfPCell cell352criteria3 = new PdfPCell(new Paragraph(
					"3.5.2 Total amount spent on developing facilities, training teachers and staff for undertaking consultancy during the last five years (INR in Lakhs).\r\n\r\n"
						 + "Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria35Ql().get(0).getResponse352()
								: "")+"\r\n\r\n",font4));
			PdfPCell cell3521criteria3 = new PdfPCell(new Paragraph(
					"3.5.2.1 Total amount spent on developing facilities, training teachers and staff for undertaking consultancy during the last five years (INR in Lakhs)\r\n"
							+ "\r\n\r\n",
							font4));
		//	table173criteria31.addCell(cell352criteria3);
		//	table173criteria31.addCell(cell3521criteria3);
//			table173criteria31.addCell(table17criteria3);
// document.add(cell352criteria3);
// document.add(cell3521criteria3);
			table173criteria31.setSpacingBefore(20f);
			table173criteria31.setSpacingAfter(20f);

			document.add(table173criteria31);
			document.add(table17criteria3);
			
// create table 3521//

			if (criteria3Record.getYearTable3521() != null) {
				Table table3521criteria3 = new Table(criteria3Record.getYearTable3521().size(), 2);

				table3521criteria3.setPadding(5);
				table3521criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3521().size(); i++) {
					Cell cell0012criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3521().get(i).getInput3521y(),font5));
					cell0012criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3521criteria3.addCell(cell0012criteria3);

				}
				for (int i = 0; i < criteria3Record.getYearTable3521().size(); i++) {
					Cell cell12criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3521().get(i).getInput3521v(),font5));
					cell12criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3521criteria3.addCell(cell12criteria3);
				}

				document.add(table3521criteria3);
			}
/////////////////////cr3.6

			Paragraph paragraph7criteria3 = new Paragraph("3.6	Extension Activities\r\n\r\n", font2);
			paragraph7criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph7criteria3);
// create table 18 //
			PdfPTable table18criteria3 = new PdfPTable(2);
			PdfPTable table183criteria3 = new PdfPTable(1);

			table18criteria3.setWidthPercentage(100f);
			table183criteria3.setWidthPercentage(100f);

			PdfPCell cell181criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell181criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell182criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell182criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell183criteria3 = new PdfPCell(new Paragraph("Upload Any additional information\r\n\r\n",font5));
			cell183criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell184criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell184criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell185criteria3 = new PdfPCell(
					new Paragraph("Paste link for additional information\r\n\r\n",font5));
			cell185criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell186criteria3 = new PdfPCell(new Paragraph(""));
			cell186criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table18criteria3.addCell(cell181criteria3);
			table18criteria3.addCell(cell182criteria3);
			table18criteria3.addCell(cell183criteria3);
			table18criteria3.addCell(cell184criteria3);
			table18criteria3.addCell(cell185criteria3);
			table18criteria3.addCell(cell186criteria3);
			PdfPCell cell361criteria3 = new PdfPCell(new Paragraph(
					"3.6.1 Outcomes of extension activities in the neighbourhood community in \r\n"
					+ "terms of impact and sensitizing the students to social issues and holistic \r\n"
					+ "development, and awards received if any during the last five years\r\n"
							+ "\r\n\r\n" + "Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria36Ql().get(0).getResponse361()
									: "")+"\r\n\r\n",
					font4));
			
			table183criteria3.addCell(cell361criteria3);
//table183criteria3.addCell(cell361criteria3);
//			table183criteria3.addCell(table18criteria3);
// document.add(cell361criteria3);
//			table183criteria3.setSpacingBefore(20f);
			table183criteria3.setSpacingAfter(20f);
			document.add(table183criteria3);
			document.add(table18criteria3);

// create table 19 //
			PdfPTable table19criteria3 = new PdfPTable(2);
			PdfPTable table191criteria3 = new PdfPTable(1);

			table19criteria3.setWidthPercentage(100f);
			table191criteria3.setWidthPercentage(100f);

			PdfPCell cell191criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell191criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell192criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell192criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell193criteria3 = new PdfPCell(
					new Paragraph("Number of awards for extension activities in last 5 year\r\n\r\n",font5));
			cell193criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell194criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell194criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell195criteria3 = new PdfPCell(new Paragraph("e-copy of the award letters\r\n\r\n",font5));
			cell195criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell196criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell196criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell197criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
			cell197criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell198criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell198criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table19criteria3.addCell(cell191criteria3);
			table19criteria3.addCell(cell192criteria3);
			table19criteria3.addCell(cell193criteria3);
			table19criteria3.addCell(cell194criteria3);
			table19criteria3.addCell(cell195criteria3);
			table19criteria3.addCell(cell196criteria3);
			table19criteria3.addCell(cell197criteria3);
			table19criteria3.addCell(cell198criteria3);
			PdfPCell cell362criteria3 = new PdfPCell(new Paragraph(
					"3.6.2 Number of extension and outreach programs conducted by the \r\n"
					+ "institution through organized forums including NSS/NCC with \r\n"
					+ "involvement of community during the last five years\r\n\r\n"
					 + "Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria36Qn().get(0).getResponse362()
									: "")+"\r\n\r\n",
							font4));
			PdfPCell cell3621criteria3 = new PdfPCell(new Paragraph(
					"3.6.2.1: Number of extension and outreach programs conducted by the \r\n"
					+ "institution through organized forums including NSS/NCC with \r\n"
					+ "involvement of community during the last five years..\r\n\r\n"
							,font4));

			table191criteria3.addCell(cell362criteria3);
			table191criteria3.addCell(cell3621criteria3);
// document.add(cell362criteria3);
// document.add(cell3621criteria3);
			table191criteria3.setSpacingBefore(20f);
			table191criteria3.setSpacingAfter(20f);
			document.add(table191criteria3);

// create table 3621 //

			if (criteria3Record.getYearTable3621() != null) {
				Table table3621criteria3 = new Table(criteria3Record.getYearTable3621().size(), 2);

				table3621criteria3.setPadding(5);
				table3621criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3621().size(); i++) {
					Cell cell1212criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3621().get(i).getInput3621y(),font5));
					cell1212criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3621criteria3.addCell(cell1212criteria3);
				}
				for (int i = 0; i < criteria3Record.getYearTable3621().size(); i++) {
					Cell cell120criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3621().get(i).getInput3621v(),font5));
					cell120criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3621criteria3.addCell(cell120criteria3);
				}

				document.add(table3621criteria3);
			}

// create table 20 //
			PdfPTable table20criteria3 = new PdfPTable(2);
			PdfPTable table201criteria31 = new PdfPTable(1);

			table20criteria3.setWidthPercentage(100f);
			table201criteria31.setWidthPercentage(100f);

			PdfPCell cell201criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell201criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell202criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell202criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell203criteria3 = new PdfPCell(new Paragraph("Reports of the event organized\r\n\r\n",font5));
			cell203criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell204criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell204criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell205criteria3 = new PdfPCell(new Paragraph(
					"Number of extension and outreach Programmes conducted with industry, community etc for the last five years\r\n\r\n",font5));
			cell205criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell206criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell206criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table20criteria3.addCell(cell201criteria3);
			table20criteria3.addCell(cell202criteria3);
			table20criteria3.addCell(cell203criteria3);
			table20criteria3.addCell(cell204criteria3);
			table20criteria3.addCell(cell205criteria3);
			table20criteria3.addCell(cell206criteria3);
			PdfPCell cell363criteria3 = new PdfPCell(new Paragraph(
					"3.6.3 Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years\r\n"
							+ "Response:"
							+ (criteria3Record != null ? criteria3Record.getCriteria36Qn().get(0).getResponse363()
									: "")+"\r\n\r\n",
							font4));
			PdfPCell cell3631criteria3 = new PdfPCell(new Paragraph(
					"3.6.3.1 Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years"
							+ "\r\n\r\n",
							font4));
			//table201criteria31.addCell(cell363criteria3);
		//	table201criteria31.addCell(cell3631criteria3);
//			table201criteria31.addCell(table20criteria3);
// document.add(cell363criteria3);
// document.add(cell3631criteria3);
			table201criteria31.setSpacingBefore(20f);
			table201criteria31.setSpacingAfter(20f);
			document.add(table201criteria31);
			document.add(table20criteria3);
// create table 3631 //

			if (criteria3Record.getYearTable3631() != null) {
				Table table3631criteria3 = new Table(criteria3Record.getYearTable3631().size(), 2);

				table3631criteria3.setPadding(5);
				table3631criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3631().size(); i++) {
					Cell cell1212criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3631().get(i).getInput3631y(),font5));
					cell1212criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3631criteria3.addCell(cell1212criteria3);
				}
				for (int i = 0; i < criteria3Record.getYearTable3631().size(); i++) {
					Cell cell12criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3631().get(i).getInput3631v(),font5));

					cell12criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3631criteria3.addCell(cell12criteria3);
					
				}

				document.add(table3631criteria3);
			}

// create a table 21 //
		
			
			PdfPTable table211criteria3 = new PdfPTable(1);
		
			table211criteria3.setWidthPercentage(100f);
			
			
			PdfPTable table21criteria3 = new PdfPTable(2);
			table21criteria3.setWidthPercentage(100f);
			PdfPCell cell211criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell211criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell212criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell212criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell213criteria3 = new PdfPCell(new Paragraph("Reports of the event\r\n\r\n",font5));
			cell213criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell214criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell214criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell215criteria3 = new PdfPCell(new Paragraph(
					"Average percentage of students participating in extension activities with Govt or NGO etc\r\n\r\n",font5));
			cell215criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell216criteria3 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell216criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21criteria3.addCell(cell211criteria3);
			table21criteria3.addCell(cell212criteria3);
			table21criteria3.addCell(cell213criteria3);
			table21criteria3.addCell(cell214criteria3);
			table21criteria3.addCell(cell215criteria3);
			table21criteria3.addCell(cell216criteria3);
//PdfPCell cell364criteria3 = new PdfPCell(new Paragraph(
//		"3.6.4 Average percentage of students participating in extension activities listed at 3.6.3 above during the last five years\r\n"
//				+ "\r\n\r\n\r\n" + "Response:"
//				+ (criteria3Fieldinfo != null
//						? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse364()
//						: "")));
			PdfPCell cell3641criteria3 = new PdfPCell(new Paragraph(
					"3.6.4.1 Total number of students participating in extension activities listed at 3.6.3 above year-wise during the last five years.\r\n\r\n"
							,font4));
//table211criteria3.addCell(cell364criteria3);
	//		table211criteria3.addCell(cell3641criteria3);
//			table211criteria3.addCell(table21criteria3);
// document.add(cell364criteria3);
// document.add(cell3641criteria3);
			table211criteria3.setSpacingBefore(20f);
			table211criteria3.setSpacingAfter(20f);
			document.add(table211criteria3);
			document.add(table21criteria3);
// create table 3641 //

			if (criteria3Record.getYearTable3641() != null) {
				Table table3641criteria3 = new Table(criteria3Record.getYearTable3641().size(), 2);

				table3641criteria3.setPadding(5);
				table3641criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
					Cell cell1002criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3641().get(i).getInput3641y(),font5));
					cell1002criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3641criteria3.addCell(cell1002criteria3);
				}
				for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
					Cell cell1012criteria3 = new Cell(new Paragraph(criteria3Record.getYearTable3641().get(i).getInput3641v(),font5));
					cell1012criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3641criteria3.addCell(cell1012criteria3);
				}

			//	document.add(table3641criteria3);
			}
			
			
			PdfPTable table131criteria311 = new PdfPTable(1);
			table131criteria311.setWidthPercentage(100f);
			
			
			PdfPCell cell3641criteria0003 = new PdfPCell(new Paragraph(
					"Number of functional MoUs/linkages with institutions/ industries in \r\n"
					+ "India and abroad for internship, on-the-job training, project work, \r\n"
					+ "student / faculty exchange and collaborative research during the \r\n"
					+ "last five year.\r\n\r\n"
					+""		
					+"3.7.1.1: Number of functional MoUs / linkages with institutions/ \r\n"
					+ "					industries in India and abroad for internship, on-the-job training, \r\n"
					+ "					project work, student / faculty exchange and collaborative research \r\n"
					+ "					during the last five years:"
					+""
					+ (criteria3Record != null ? criteria3Record.getCriteria37Qn().get(0).getResponse371()
							: "")+"\r\n\r\n",font4));
			table131criteria311.addCell(cell3641criteria0003);
			
			document.add(table131criteria311);
			
			
			PdfPTable table21criteria31 = new PdfPTable(2);
			table21criteria31.setWidthPercentage(100f);
			PdfPCell cell211criteria31 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell211criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell212criteria31 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell212criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell213criteria31 = new PdfPCell(new Paragraph("Institutional data in the prescribed format\r\n\r\n",font5));
			cell213criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell214criteria31 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell214criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell215criteria31 = new PdfPCell(new Paragraph(
					"List and Copies of documents indicating the functional \r\n"
					+ "MoUs/linkage/collaborations activity-wise and year-wise\r\n\r\n",font5));
			cell215criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell216criteria31 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell216criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell213criteria3001 = new PdfPCell(new Paragraph("Summary of the functional MoUs/linkage/collaboration indicating \r\n"
					+ "start date, end date, nature of collaboration etc.\r\n\r\n",font5));
			cell213criteria3001.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell214criteria3001 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell214criteria3001.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell215criteria3001 = new PdfPCell(new Paragraph(
					"List of year wise activities and exchange should be provided",font5));
			cell215criteria3001.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell216criteria3001 = new PdfPCell(
					new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""+"\r\n\r\n",font5));
			cell216criteria3001.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			
			table21criteria31.addCell(cell211criteria31);
			table21criteria31.addCell(cell212criteria31);
			table21criteria31.addCell(cell213criteria31);
			table21criteria31.addCell(cell214criteria31);
			table21criteria31.addCell(cell215criteria31);
			table21criteria31.addCell(cell216criteria31);
			
			
			
			document.add(table21criteria31);
			
			

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

	
}
