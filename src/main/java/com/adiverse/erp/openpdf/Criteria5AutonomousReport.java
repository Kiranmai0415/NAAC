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
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import com.adiverse.erp.model.Criteria5_FieldInfo;
import com.adiverse.erp.model.Criteria5_FileUpload;
import com.adiverse.erp.service.Criteria5Service;
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
public class Criteria5AutonomousReport {


	

	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	
	
	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	
	
	
	@Autowired
	Criteria5Service service5;



		///////////////////////////////////////////////////////////////////////////////////////////
		// criteria 5 start here
		//////////////////////////////////////////////////////////////////////////////////////////

		//java.util.List<Criteria5_FieldInfo> criteria5List1 = service5.getAllCriteria5Data();

		// criteria5Record1 = criteria5List1.get(0);

		//java.util.List<Criteria5_FileUpload> criteria5file = criteria5Record1.getCriteria5FileUpload();

		/*
		 * Font font0 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font0.setSize(16);
		 * 
		 * Font font1criteria5 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font1criteria5.setSize(14);
		 * 
		 * Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font2.setSize(12);
		 * 
		 * // Font font3=FontFactory.getFont(FontFactory.HELVETICA); //
		 * font.setSize(16);
		 * 
		 * // Font font4=FontFactory.getFont(FontFactory.HELVETICA); //
		 * font1.setSize(14);
		 * 
		 * Font font5criteria5 = FontFactory.getFont(FontFactory.HELVETICA);
		 * font5criteria5.setSize(12);
		 */

		
		
		
		
		
		List<Criteria5_FieldInfo> criteria5List = null;
		Criteria5_FieldInfo criteria5Record = null;
		List<Criteria5_FileUpload> criterai5file = null;
		
		
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

//				Map<String, String> allParams = new HashMap<String, String>();
//				allParams.put("collegeId",criteria5Fieldinfo.getCriteriaId().getCollegeId() );
//				allParams.put("financialYear", criteria5Fieldinfo.getCriteriaId().getFinancialYear());
//				allParams.put("typeofInstitution", criteria5Fieldinfo.getCriteriaId().getTypeofInstitution() );
//				

				criteria5List = service5.getAllCriteria5Data(allParams);
				if (CollectionUtils.isNotEmpty(criteria5List)) {
					criteria5Record = criteria5List.get(0);
					criterai5file = criteria5Record.getCriteria5FileUpload();
				} else {
					criteria5Record = new Criteria5_FieldInfo();
					criterai5file = new ArrayList<>();
				}
				System.out.println("report generation path from property file ==>" + reportGeneratePath);
				if (root != null) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
					String strDate = formatter.format(date);
					reportPath = "AuthonomousCriteria5Report-" + strDate + ".pdf";
					file = root.resolve(reportPath);
				}
				System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

				Document document = new Document(PageSize.A4);
				// PdfWriter.getInstance(document, response.getOutputStream());
				PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

				document.open();
				System.out.println("open the document==========>");

				Paragraph paragraph0 = new Paragraph("Criterion 5 - Student Support and Progression\r\n", font1);
				paragraph0.setAlignment(Paragraph.ALIGN_JUSTIFIED);

				Paragraph paragraphline = new Paragraph(
						"______________________________________________________________________________");
				paragraph0.setAlignment(Paragraph.ALIGN_JUSTIFIED);

				Paragraph paragraph02 = new Paragraph(" 5.1  Student Support and Progression\r\n\r\n", font2);
				paragraph02.setAlignment(Paragraph.ALIGN_JUSTIFIED);

				document.add(paragraph0);
				document.add(paragraphline);

				document.add(paragraph02);

				PdfPTable table01criteria5 = new PdfPTable(2);
				PdfPTable table011 = new PdfPTable(1);

				// Setting width of table, its columns and spacing
				table01criteria5.setWidthPercentage(100);
				table011.setWidthPercentage(100);

				PdfPCell cell1001 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
				cell1001.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1002 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
				cell1002.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1003 = new PdfPCell(new Paragraph(
						"upload self attested letter with the list of students sanctioned scholarships\r\n\r\n",
						font5));
				cell1003.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1004 = new PdfPCell(new Paragraph(
						criterai5file.size() > 0 ? criterai5file.get(0).getCriteria5FilePath() : "", font5));   cell1004.setExtraParagraphSpace(10f);
				cell1004.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1005 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n", font5));
				cell1005.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1006 = new PdfPCell(new Paragraph(
						criterai5file.size() > 0 ? criterai5file.get(1).getCriteria5FilePath() : "", font5)); cell1005  .setExtraParagraphSpace(10f);
				cell1006.setExtraParagraphSpace(10f);
				cell1006.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1007 = new PdfPCell(
						new Paragraph("Institutional data in prescribed format\r\n\r\n", font5));
				cell1007.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1008 = new PdfPCell(new Paragraph(
						criterai5file.size() > 0 ? criterai5file.get(2).getCriteria5FilePath() : "", font5));  cell1008 .setExtraParagraphSpace(10f);
				cell1008.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1009 = new PdfPCell(new Paragraph(
						"Average percentage of students benefited by scholarships and freeships provided by the Government during the last five years\r\n\r\n",
						font5));
				cell1009.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell10010 = new PdfPCell(new Paragraph(
						criterai5file.size() > 0 ? criterai5file.get(3).getCriteria5FilePath() : "", font5));   cell10010.setExtraParagraphSpace(10f);
				cell10010.setHorizontalAlignment(Element.ALIGN_CENTER);

				table01criteria5.addCell(cell1001);
				table01criteria5.addCell(cell1002);
				table01criteria5.addCell(cell1003);
				table01criteria5.addCell(cell1004);
				table01criteria5.addCell(cell1005);
				table01criteria5.addCell(cell1006);
				table01criteria5.addCell(cell1007);
				table01criteria5.addCell(cell1008);
				table01criteria5.addCell(cell1009);
				table01criteria5.addCell(cell10010);

				PdfPCell cell100111 = new PdfPCell(new Paragraph(
						"5.1.1 Percentage of students benefited by scholarships and freeships  provided by the institution, government and non-government bodies, industries, individuals, philanthropists during the last five years\r\n"
								+ "\r\n\r\n" + "Response: "
								+ (criteria5Record != null ? criteria5Record.getCriteria51Qn().get(0).getResponse511()
										: "")+"\r\n\r\n",
						font4));

				PdfPCell cell100112 = new PdfPCell(new Paragraph(
						"5.1.1.1: Number of students benefited by scholarships and freeships	provided by the institution, Government and non-government bodies, industries, individuals, philanthropists during the last five years\r\n\r\n",
						font4));

				table011.addCell(cell100111);
				table011.addCell(cell100112);

//				table011.setSpacingBefore(20f);
				table011.setSpacingAfter(20f);

				document.add(table011);
				document.add(table01criteria5);

				if (criteria5Record.getYearTable5111() != null) {
					Table table5111 = new Table(criteria5Record.getYearTable5111().size(), 2);

					table5111.setPadding(5);
					table5111.setWidth(100f);

					for (int i = 0; i < criteria5Record.getYearTable5111().size(); i++) {
						
						
						Cell cell12criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5111().get(i).getInput5111y(),font5));
						cell12criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
						table5111.addCell(cell12criteria5);

					}
					for (int i = 0; i < criteria5Record.getYearTable5111().size(); i++) {
						
						
						Cell cell120criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5111().get(i).getInput5111v(),font5));
						cell120criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
						table5111.addCell(cell120criteria5);

					}

					document.add(table5111);
				}

				// Creating table
				PdfPTable table02criteria5 = new PdfPTable(2);
				PdfPTable table021 = new PdfPTable(1);

				// Setting width of table, its columns and spacing
				table02criteria5.setWidthPercentage(100);
				table021.setWidthPercentage(100);

				PdfPCell cell00001 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
				cell00001.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00002 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
				cell00002.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00003 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n"));
				cell00003.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00004 = new PdfPCell(new Paragraph(
						criterai5file.size() > 0 ? criterai5file.get(4).getCriteria5FilePath() : "", font5)); cell00004  .setExtraParagraphSpace(10f);
				cell00004.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00005 = new PdfPCell(new Paragraph(
						"Number of students benefited by scholarships and freeships besides government schemes in last 5 years\r\n\r\n",
						font5));
				cell00005.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00006 = new PdfPCell(new Paragraph(
						criterai5file.size() > 0 ? criterai5file.get(5).getCriteria5FilePath() : "", font5));  cell00006 .setExtraParagraphSpace(10f);
				cell00006.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00007 = new PdfPCell(
						new Paragraph("Institutional data in prescribed format\r\n\r\n", font5));
				cell00007.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00008 = new PdfPCell(new Paragraph(
						criterai5file.size() > 0 ? criterai5file.get(6).getCriteria5FilePath() : "", font5));  cell00008 .setExtraParagraphSpace(10f);
				cell00008.setHorizontalAlignment(Element.ALIGN_CENTER);

				table02criteria5.addCell(cell00001);
				table02criteria5.addCell(cell00002);
				table02criteria5.addCell(cell00003);
				table02criteria5.addCell(cell00004);
				table02criteria5.addCell(cell00005);
				table02criteria5.addCell(cell00006);
				table02criteria5.addCell(cell00007);
				table02criteria5.addCell(cell00008);

				PdfPCell cell000081 = new PdfPCell(new Paragraph(
						"5.1.2 Efforts taken by the institution to provide career counselling including e-counselling and guidance for competitive examinations 	during the last five years\r\n"
								+ "\r\n\r\n" + "Response:"
								+ (criteria5Record != null ? criteria5Record.getCriteria51Qn().get(0).getResponse512()
										: "")+"\r\n\r\n",
						font4));

				PdfPCell cell0000810 = new PdfPCell(new Paragraph(
						"5.1.2.1 Number of students benefited by scholarships and free ships provided by the institution, Government and non-government bodies, industries, individuals, philanthropists during the last five years (other than students receiving scholarships under the government schemes for reserved categories)\r\n\r\n",
						font4));

				table021.addCell(cell000081);
			//	table021.addCell(cell0000810);

				table021.setSpacingBefore(20f);
				table021.setSpacingAfter(20f);

				document.add(table021);
				document.add(table02criteria5);

				PdfPTable table03criteria5 = new PdfPTable(2);
				PdfPTable table31criteria5 = new PdfPTable(1);

				// Setting width of table, its columns and spacing
				table03criteria5.setWidthPercentage(100);
				table31criteria5.setWidthPercentage(100);

				PdfPCell cell00019 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
				cell00019.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00020 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
				cell00020.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00021 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
				cell00021.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00022 = new PdfPCell(
						new Paragraph(criterai5file.size() > 0 ? criterai5file.get(7).getCriteria5FilePath() : "",font5));
				cell00022.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00023 = new PdfPCell(new Paragraph(
						"Number of students benefited by scholarships and freeships besides government schemes in last 5 years\r\n\r\n",font5));
				cell00023.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00024 = new PdfPCell(
						new Paragraph(criterai5file.size() > 0 ? criterai5file.get(8).getCriteria5FilePath() : "",font5));
				cell00024.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00025 = new PdfPCell(new Paragraph("Institutional data in prescribed format",font5));
				cell00025.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00026 = new PdfPCell(
						new Paragraph(criterai5file.size() > 0 ? criterai5file.get(9).getCriteria5FilePath() : "",font5));
				cell00026.setHorizontalAlignment(Element.ALIGN_CENTER);

				table03criteria5.addCell(cell00019);
				table03criteria5.addCell(cell00020);
				table03criteria5.addCell(cell00021);
				table03criteria5.addCell(cell00022);
				table03criteria5.addCell(cell00023);
				table03criteria5.addCell(cell00024);
				table03criteria5.addCell(cell00025);
				table03criteria5.addCell(cell00026);

				PdfPCell cell0005 = new PdfPCell(new Paragraph(
						"5.1.3 Following Capacity development and skills enhancement activities are organised for improving students capability 1. Soft skills 2. Language and communication skills 3. Life skills (Yoga, physical fitness, health and hygiene) 4. Awareness of trends in technology\r\n"
								+ "\r\n\r\n" + " "
								+ (criteria5Record != null ? criteria5Record.getCriteria51Qn().get(0).getResponse513()
										: "")+"\r\n\r\n",
						font4));
				table31criteria5.addCell(cell0005);

//		table31criteria5.addCell(table03criteria5);

				table31criteria5.setSpacingBefore(20f);
				table31criteria5.setSpacingAfter(20f);

				document.add(table31criteria5);
				document.add(table03criteria5);

//				if (criteria5Record.getYearTable5121() != null) {
//					Table table5121 = new Table(criteria5Record.getYearTable5121().size(), 2);
//
//					table5121.setPadding(5);
//					table5121.setWidth(100f);
//
//					for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
//						Cell cell121criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5121().get(i).getInput5121y(),font5));
//						cell121criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table5121.addCell(cell121criteria5);
//
//					}
//					for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
//						
//						Cell cell1201criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5121().get(i).getInput5121v(),font5));
//						cell1201criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table5121.addCell(cell1201criteria5);
//
//					}
//
//			//		document.add(table5121);
//				}

				PdfPCell cell00044 = new PdfPCell(new Paragraph("B. Number of Sanctioned Posts\r\n\r\n"));
		//		document.add(cell00044);
//
//				if (criteria5Record.getYearTable5121() != null) {
//					
//					
//					Table table5121 = new Table(criteria5Record.getYearTable5121().size(), 2);
//
//					table5121.setPadding(5);
//					table5121.setWidth(100f);
//
//					for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
//						
//						
//						Cell cell1211criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5121().get(i).getInput5121y(),font5));
//						cell1211criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table5121.addCell(cell1211criteria5);
//						
//
//					}
//					for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
//						
//						
//						Cell cell1210criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5121().get(i).getInput5121v(),font5));
//						cell1210criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table5121.addCell(cell1210criteria5);
//						
//					}
//
//				//	document.add(table5121);
//				}

				PdfPTable table04criteria5 = new PdfPTable(2);
				PdfPTable table41criteria5 = new PdfPTable(1);

				// Setting width of table, its columns and spacing
				table04criteria5.setWidthPercentage(100);
				table41criteria5.setWidthPercentage(100);

				PdfPCell cell00027 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
				cell00027.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00028 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
				cell00028.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00029 = new PdfPCell(new Paragraph(
						"Number of students benefited by guidance for competitive examinations and career counselling during the last five years\r\n\r\n",
						font5));
				cell00029.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00030 = new PdfPCell(new Paragraph(
						criterai5file.size() > 0 ? criterai5file.get(10).getCriteria5FilePath() : "", font5));   cell00030.setExtraParagraphSpace(10f);
				cell00030.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00031 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
				cell00031.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00032 = new PdfPCell(new Paragraph(
						criterai5file.size() > 0 ? criterai5file.get(11).getCriteria5FilePath() : "", font5));  cell00032 .setExtraParagraphSpace(10f);
				cell00032.setHorizontalAlignment(Element.ALIGN_CENTER);

				table04criteria5.addCell(cell00027);
				table04criteria5.addCell(cell00028);
				table04criteria5.addCell(cell00029);
				table04criteria5.addCell(cell00030);
				table04criteria5.addCell(cell00031);
				table04criteria5.addCell(cell00032);

				PdfPCell cell0006 = new PdfPCell(new Paragraph(
						"5.1.4 The institution adopts the following for redressal of student  grievances including sexual harassment and ragging cases\r\n"
						+ "1. Implementation of guidelines of statutory/regulatory bodies\r\n"
						+ "2. Organisation wide awareness and undertakings on policies \r\n"
						+ "with zero tolerance \r\n"
						+ "3. Mechanisms for submission of online/offline students’ \r\n"
						+ "grievances\r\n"
						+ "4. Timely redressal of the grievances through appropriate \r\n"
						+ "committees\r\n"
								+ "Response:\r\n "
								+ (criteria5Record != null ? criteria5Record.getCriteria51Qn().get(0).getResponse514()
										: "")+"\r\n\r\n",
						font4));

				PdfPCell cell0007 = new PdfPCell(new Paragraph(
						"5.1.4.1 Number of students benefitted by guidance for competitive examinations and career counselling offered by the institution year wise during last five years\r\n\r\n",
						font4));
				table41criteria5.addCell(cell0006);
		//		table41criteria5.addCell(cell0007);

//		table41criteria5.addCell(table04criteria5);

				table41criteria5.setSpacingBefore(20f);
				table41criteria5.setSpacingAfter(20f);

				document.add(table41criteria5);
				document.add(table04criteria5);

//				if (criteria5Record.getYearTable5141() != null) {
//					Table table5141 = new Table(criteria5Record.getYearTable5141().size(), 2);
//
//					table5141.setPadding(5);
//					table5141.setWidth(100f);
//
//					for (int i = 0; i < criteria5Record.getYearTable5141().size(); i++) {
//						
//						Cell cell1211criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5141().get(i).getInput5141y(),font5));
//						cell1211criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table5141.addCell(cell1211criteria5);
//					}
//					for (int i = 0; i < criteria5Record.getYearTable5141().size(); i++) {
//						
//						
//						Cell cell12110criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5141().get(i).getInput5141v(),font5));
//						cell12110criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table5141.addCell(cell12110criteria5);
//
//					}
//
//				//	document.add(table5141);
//				}
//				if (criteria5Record.getYearTable5141() != null) {
//					Table table5141 = new Table(criteria5Record.getYearTable5141().size(), 2);
//
//					table5141.setPadding(5);
//					table5141.setWidth(100f);
//
//					for (int i = 0; i < criteria5Record.getYearTable5141().size(); i++) {
//					
//						Cell cell1210criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5141().get(i).getInput5141y(),font5));
//						cell1210criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table5141.addCell(cell1210criteria5);
//						
//
//					}
//					for (int i = 0; i < criteria5Record.getYearTable5141().size(); i++) {
//						
//						
//						Cell cell1200criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5141().get(i).getInput5141v(),font5));
//						cell1200criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table5141.addCell(cell1200criteria5);
//						
//
//					}
//
//			//		document.add(table5141);
//				}

				PdfPTable table05criteria5 = new PdfPTable(2);
				PdfPTable table051criteria5 = new PdfPTable(1);

				// Setting width of table, its columns and spacing
				table05criteria5.setWidthPercentage(100);
				table051criteria5.setWidthPercentage(100);

				PdfPCell cell00035 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
				cell00035.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00036 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
				cell00036.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00037 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n", font5));
				cell00037.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00038 = new PdfPCell(new Paragraph(
						criterai5file.size() > 0 ? criterai5file.get(12).getCriteria5FilePath() : "", font5));   cell00038.setExtraParagraphSpace(10f);
				cell00038.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00039 = new PdfPCell(new Paragraph(
						"Minutes of the meetings of student redressal committee, prevention of sexual harassment committee and Anti Ragging committee\r\n\r\n",
						font5));
				cell00039.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00040 = new PdfPCell(new Paragraph(
						criterai5file.size() > 0 ? criterai5file.get(1).getCriteria5FilePath() : "", font5));  cell00040 .setExtraParagraphSpace(10f);
				cell00040.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00041 = new PdfPCell(new Paragraph(
						"Details of student grievances including sexual harassment and ragging cases", font5));
				cell00041.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00042 = new PdfPCell(new Paragraph(
						criterai5file.size() > 0 ? criterai5file.get(1).getCriteria5FilePath() : "", font5));  cell00042 .setExtraParagraphSpace(10f);
				cell00042.setHorizontalAlignment(Element.ALIGN_CENTER);

				table05criteria5.addCell(cell00035);
				table05criteria5.addCell(cell00036);
				table05criteria5.addCell(cell00037);
				table05criteria5.addCell(cell00038);
				table05criteria5.addCell(cell00039);
				table05criteria5.addCell(cell00040);
				table05criteria5.addCell(cell00041);
				table05criteria5.addCell(cell00042);

				PdfPCell cell0008 = new PdfPCell(new Paragraph(
						"5.1.5 The institution adopts the following for redressal of student grievances including sexual harassment and ragging cases 1. Implementation of guidelines of statutory/regulatory bodies 2.	Organisation wide awareness and undertakings on policies with zero tolerance\r\n"
								+ "3.	Mechanisms for submission of online/offline students� grievances\r\n"
								+ "4.	Timely redressal of the grievances through appropriate committees\r\n\r\n"
								+ "Response: "
								+ (criteria5Record != null ? criteria5Record.getCriteria51Qn().get(0).getResponse515()
										: "")+"\r\n\r\n",
						font4));

			//	table051criteria5.addCell(cell0008);

//		table051criteria5.addCell(table05criteria5);

				table051criteria5.setSpacingBefore(20f);
				table051criteria5.setSpacingAfter(20f);

				document.add(table051criteria5);
				document.add(table05criteria5);

				////////////////// cr5.2

				PdfPTable table06criteria5 = new PdfPTable(2);
				PdfPTable table061 = new PdfPTable(1);

// Setting width of table, its columns and spacing
				table06criteria5.setWidthPercentage(100);
				table061.setWidthPercentage(100);

				PdfPCell cell00043 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
				cell00043.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell000441 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
				cell000441.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00045 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
				cell00045.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00046 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : "",font5));
				cell00046.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00047 = new PdfPCell(new Paragraph("Self attested list of students placed\r\n\r\n",font5));
				cell00047.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00048 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(1).getCriteria5FilePath() : "",font5));
				cell00048.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00049 = new PdfPCell(
						new Paragraph("Details of student placement during the last five years\r\n\r\n",font5));
				cell00049.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell00050 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : "",font5));
				cell00050.setHorizontalAlignment(Element.ALIGN_CENTER);

				table06criteria5.addCell(cell00043);
				table06criteria5.addCell(cell000441);
				table06criteria5.addCell(cell00045);
				table06criteria5.addCell(cell00046);
				table06criteria5.addCell(cell00047);
				table06criteria5.addCell(cell00048);
				table06criteria5.addCell(cell00049);
				table06criteria5.addCell(cell00050);

//table061.addCell(cell00009);
//table061.addCell(cell00010);
				

				PdfPCell cell000501 = new PdfPCell(
						new Paragraph(
						"5.2.1 Percentage of placement of outgoing students and students progressing to higher education during the last five years\r\n"
								+ "\r\n\r\n" + "Response: "
								+ (criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getResponse521()
										: ""),font4));
			
				PdfPCell cell0005011 = new PdfPCell(
						new Paragraph(
						"5.2.1.1 Number of outgoing students placed and progressed to higher education during the last five years.\r\n\r\n", font4));
				PdfPCell cell00050011 = new PdfPCell(
						new Paragraph(
						"5.2.1.2 Number of outgoing students year wise during the last five years.\r\n\r\n", font4));
				
				table061.addCell(cell000501);
				table061.addCell(cell0005011);
				table061.addCell(cell00050011);


//				table061.addCell(table06criteria5);

				table061.setSpacingBefore(20f);
				table061.setSpacingAfter(20f);
				document.add(table061);
				document.add(table06criteria5);

				
//
//				Paragraph paragraph0301 = new Paragraph(
//						"5.2.1 Average percentage of placement of outgoing students during the last five years\r\n"
//								+ "\r\n\r\n" + "Response: "
//								+ (criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getResponse521()
//										: ""));
//				document.add(paragraph0301);
//				Paragraph paragraph0310 = new Paragraph(
//						"5.2.1.1 Number of outgoing students placed year - wise during the last five years.", font3);
//				document.add(paragraph0310);
//		table061.addCell(cell00009);
//		table061.addCell(cell00010);
//
//		table061.addCell(table06criteria5);
//
//		table061.setSpacingBefore(20f);
//		table061.setSpacingAfter(20f);
//
//		document.add(table061);
				if (criteria5Record.getYearTable5211() != null) {
					Table table5211 = new Table(criteria5Record.getYearTable5211().size(), 2);

					table5211.setPadding(5);
					table5211.setWidth(100f);

					for (int i = 0; i < criteria5Record.getYearTable5211().size(); i++) {
						
						Cell cell121criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5211().get(i).getInput5211y(),font5));
						cell121criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
						table5211.addCell(cell121criteria5);

					}
					for (int i = 0; i < criteria5Record.getYearTable5211().size(); i++) {
						
						
						Cell cell120criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5211().get(i).getInput5211v(),font5));
						cell120criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
						table5211.addCell(cell120criteria5);

					}

					document.add(table5211);
				}


//document.add(table061);
				PdfPCell cell0111 = new PdfPCell(new Paragraph(
						"5.2.2 Percentage of students qualifying in state/ national/ international level examinations out of the graduated students during the last five years.\r\n"
								+ "\r\n" + "Response:"
								+ (criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getResponse522()
										: ""),
						font4));
				document.add(cell0111);

				PdfPCell cell0112 = new PdfPCell(
						new Paragraph("5.2.2.1: Number of students qualifying in state/ national/ international level examinations (eg: IIT/JAM/NET/SLET/GATE/GMAT/CAT/ GRE/TOEFL/IELTS/Civil Services/State government examinations etc.) year wise during last five years\r\n" + 
								"Response: "
								+ (criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getInput522t1()
										: ""),
								font4));
				document.add(cell0112);
				PdfPCell cell01131 = new PdfPCell(new Paragraph(
						"5.2.2.2: Number of graduated students during the last five years.\r\n"
								+ "\r\n\r\n" + "Response: "
								+ (criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getInput522t1()
										: "")+"\r\n\r\n",
						font4));
				document.add(cell01131);

				PdfPTable table07criteria5 = new PdfPTable(2);
				PdfPTable table71criteria5 = new PdfPTable(1);

				// Setting width of table, its columns and spacing
				table07criteria5.setWidthPercentage(100);
				table71criteria5.setWidthPercentage(100);

				PdfPCell cell51criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
				cell51criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell52criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
				cell52criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell53criteria5 = new PdfPCell(
						new Paragraph("Upload supporting data for student/alumni\r\n\r\n",font5));
				cell53criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell54criteria5 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : "",font5));
				cell54criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell55criteria5 = new PdfPCell(
						new Paragraph("Details of student progression to higher education\r\n\r\n",font5));
				cell55criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell56criteria5 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(1).getCriteria5FilePath() : "",font5));
				cell56criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell57criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
				cell57criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell58criteria5 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(2).getCriteria5FilePath() : "",font5));
				cell58criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				table07criteria5.addCell(cell51criteria5);
				table07criteria5.addCell(cell52criteria5);
				table07criteria5.addCell(cell53criteria5);
				table07criteria5.addCell(cell54criteria5);
				table07criteria5.addCell(cell55criteria5);
				table07criteria5.addCell(cell56criteria5);
				table07criteria5.addCell(cell57criteria5);
				table07criteria5.addCell(cell58criteria5);

				table71criteria5.setSpacingBefore(20f);
				table71criteria5.setSpacingAfter(20f);

				document.add(table71criteria5);
				
//				PdfPTable table711criteria5 = new PdfPTable(1);
//				
//				table711criteria5.setWidthPercentage(100);
//
//				
//				table711criteria5.setSpacingBefore(20f);
//				table711criteria5.setSpacingAfter(20f);
//
//				PdfPCell cell0113 = new PdfPCell(new Paragraph(
//						"5.2.3 Average percentage of students qualifying in state/national/ international level examinations during the last five years (eg: IIT-JAM/CLAT/ NET/SLET/GATE/ GMAT/CAT/GRE/ TOEFL/ Civil Services/State government examinations, etc.)\r\n"
//								+ "\r\n\r\n" + "Response:"
//								+ (criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getResponse523()
//										: "")+"\r\n\r\n",
//						font4));
//			
//				PdfPCell cell0114 = new PdfPCell(new Paragraph(
//						"5.2.3.1 Number of students qualifying in state/ national/ international level examinations (eg: IIT/JAM/ NET/ SLET/ GATE/ GMAT/CAT/GRE/ TOEFL/ Civil Services/ State government examinations, etc.)) year-wise during last five years\r\n\r\n",
//						font4));
//				table711criteria5.addCell(cell0113);
//				table711criteria5.addCell(cell0114);
//				document.add(table711criteria5);
//				
//
//				if (criteria5Record.getYearTable5231() != null) {
//					Table table5231 = new Table(criteria5Record.getYearTable5231().size(), 2);
//
//					table5231.setPadding(5);
//					table5231.setWidth(100f);
//
//					for (int i = 0; i < criteria5Record.getYearTable5231().size(); i++) {
//						
//						
//						Cell cell1212criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5231().get(i).getInput5231y(),font5));
//						cell1212criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table5231.addCell(cell1212criteria5);
//
//					}
//					for (int i = 0; i < criteria5Record.getYearTable5231().size(); i++) {
//						
//						
//						Cell cell102criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5231().get(i).getInput5231v(),font5));
//						cell102criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table5231.addCell(cell102criteria5);
//					}
//
//					document.add(table5231);
//				}
//
//				
//				PdfPTable table08criteria5 = new PdfPTable(2);
//				PdfPTable table81criteria5 = new PdfPTable(1);
//
//				// Setting width of table, its columns and spacing
//				table08criteria5.setWidthPercentage(100);
//				table81criteria5.setWidthPercentage(100);
//
//				PdfPCell cell59criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
//				cell59criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//				PdfPCell cell60criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
//				cell60criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//				PdfPCell cell61criteria5 = new PdfPCell(
//						new Paragraph("Upload supporting data for student/alumni\r\n\r\n",font5));
//				cell61criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//				PdfPCell cell62criteria5 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : "",font5));
//				cell62criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//				PdfPCell cell63criteria5 = new PdfPCell(new Paragraph(
//						"Number of students qualifying in state/ national/ international level examinations during the last five years\r\n\r\n",font5));
//				cell63criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//				PdfPCell cell64criteria5 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : "",font5));
//				cell64criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//				PdfPCell cell65criteria5 = new PdfPCell(new Paragraph("Any additional information"));
//				cell65criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//				PdfPCell cell66criteria5 = new PdfPCell(
//						new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : "",font5));
//				cell66criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//				table08criteria5.addCell(cell59criteria5);
//				table08criteria5.addCell(cell60criteria5);
//				table08criteria5.addCell(cell61criteria5);
//				table08criteria5.addCell(cell62criteria5);
//				table08criteria5.addCell(cell63criteria5);
//				table08criteria5.addCell(cell64criteria5);
//				table08criteria5.addCell(cell65criteria5);
//				table08criteria5.addCell(cell66criteria5);
////		table81criteria5.addCell(cell0113);
////		table81criteria5.addCell(cell0114);
////		table81criteria5.addCell(cell0115);
//
////				table81criteria5.addCell(table08criteria5);
//
//				table81criteria5.setSpacingBefore(20f);
//				table81criteria5.setSpacingAfter(20f);
//
//				document.add(table08criteria5);
//				document.add(table81criteria5);

				////////////////////// cr5.3

				Paragraph paragraph04 = new Paragraph("5.3 Student Participation and Activities\r\n\r\n", font2);
				paragraph04.setAlignment(Paragraph.ALIGN_LEFT);

				document.add(paragraph04);

				

				PdfPTable table09criteria5 = new PdfPTable(2);
				PdfPTable table91criteria5 = new PdfPTable(1);

				// Setting width of table, its columns and spacing
				table09criteria5.setWidthPercentage(100);
				table91criteria5.setWidthPercentage(100);

				PdfPCell cell67criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
				cell67criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell68criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
				cell68criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell69criteria5 = new PdfPCell(new Paragraph(
						"Number of awards/medals for outstanding performance in sports/ cultural activities at inter- university / state / national / international level during the last five years\r\n\r\n",font5));
				cell69criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell70criteria5 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : "",font5));
				cell70criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell71criteria5 = new PdfPCell(
					new Paragraph("e-copies of award letters and certificates\r\n\r\n",font5));
				cell71criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell72criteria5 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(1).getCriteria5FilePath() : "",font5));
				cell72criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell73criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
				cell73criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell74criteria5 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(2).getCriteria5FilePath() : "",font5));
				cell74criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				table09criteria5.addCell(cell67criteria5);
				table09criteria5.addCell(cell68criteria5);
				table09criteria5.addCell(cell69criteria5);
				table09criteria5.addCell(cell70criteria5);
				table09criteria5.addCell(cell71criteria5);
				table09criteria5.addCell(cell72criteria5);
				table09criteria5.addCell(cell73criteria5);
				table09criteria5.addCell(cell74criteria5);
				

				PdfPCell cell742criteria5 = new PdfPCell(
						new Paragraph(
						"5.3.1 Number of awards/medals for outstanding performance in sports/cultural activities at inter-collegiate / state /national / international events during the last five years.\r\n\r\n"
								+ "Response:"
								+ (criteria5Record != null ? criteria5Record.getCriteria53Qn().get(0).getResponse531()
										: "")+"\r\n\r\n",font4));
				
				PdfPCell cell7421criteria5 = new PdfPCell(
						new Paragraph(
						"5.3.1.1: Number of awards/medals for outstanding performance in sports/cultural activities at inter-collegiate / state / national / international level (award for a team event should be counted as one) year wise during last five years.\r\n\r\n",font4));

				table91criteria5.addCell(cell742criteria5);
				table91criteria5.addCell(cell7421criteria5);
				
				table09criteria5.setSpacingBefore(20f);
				table09criteria5.setSpacingAfter(20f);
				document.add(table91criteria5);
				document.add(table09criteria5);
			
				
				
				
				
				if (criteria5Record.getYearTable5311() != null) {

					Table table5311 = new Table(criteria5Record.getYearTable5311().size(), 2);

					table5311.setPadding(5);
					table5311.setWidth(100f);

					for (int i = 0; i < criteria5Record.getYearTable5311().size(); i++) {
						
						Cell cell120criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5311().get(i).getInput5311y()));
						cell120criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
						table5311.addCell(cell120criteria5);

					}
					for (int i = 0; i < criteria5Record.getYearTable5311().size(); i++) {
						Cell cell121criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5311().get(i).getInput5311v(),font5));
						cell121criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
						table5311.addCell(cell121criteria5);
					}

					document.add(table5311);
				}
				
			
				
				
				
//		PdfPCell cell0120 = new PdfPCell(new Paragraph(
//				"Mother Teresa has a Student Council (SC) comprising nine members. In addition, various bodies constituted by the College also has student representatives. The SC under aegis of Dean, students affairs plans and organizes various co-curricular and extra-curricular activities of the college in association with the college academic committee. Towards this end, various designated committees, viz., Organizing committee, Reception committee, Hospitality committee, Technical Events committee, Campaigning/Public Relations committee, Discipline committee, Cultural programmes committee, Sports committee, Prize Distribution committee, Magazine committee and such others are involved in the organization of Orientation programmes, Fresher�s Day, Alphamatica, Bhaswara, Vaisheshika, Vibgyor and Vibes. In each committee, at least two student representatives/volunteers attend meetings as and when called for. In addition, Mother Teresa celebrates regional, national and international commemoration days and festivals wherein, SC members are involved in the smooth conduct of the events.\r\n"
//						+ "\r\n"
//						+ "SC also contributes to the enhancement of the learning experiences of students through various clubs, namely, Literary, Science, Coding, Mathematical, Fine arts, Photography, Solar, Robotics, Environment, and Srujanastra. Each club is managed by students with the help of a faculty advisor. Various events pertaining to the concerned club are organized after the college hours on regular working days, as well as on Saturdays. In addition, it also facilitates organization of various technical activities through professional bodies namely, Computer Society of India (CSI), Institute of Electrical and Electronic Engineers (IEEE), Institute of Electronics and Telecommunication Engineering (IETE), Indian Society for Technical Education (ISTE) and Society for Automotive Engineering (SAE).\r\n"
//						+ " \r\n"
//						+ "The SC assists in organizing NSS activities of the college, which include conducting various health camps, distribution of school uniforms, books etc for needy children of nearby villages, distribution of various items at old-age homes, facilitating training for development of vocational skills in the people in nearby places, etc.\r\n"
//						+ "\r\n"
//						+ "In addition to the above-mentioned activities, the SC provides necessary help by reaching out appropriate tutorials to the students studying in nearby schools. It also organizes awareness programmes on health, education and environment. In association with NGOs, the SC facilitates conduct of cataract surgeries, organizes blood donation, health/dental camps and distributes medicines. As part of environment campaign, Handmade paper bags were made and distributed, making them aware of the hazards of plastic usage and its consequent disastrous effects on environment. Towards the promotion of Green revolution, every year, SC organizes tree plantation programmes in the nearby villages.\r\n"
//						+ "\r\n"
//						+ "Student representatives are also nominated on the anti-ragging committee, grievance redressal cell and women protection cell. The Entrepreneurship development cell also has SC members with a faculty advisor, to organize various events under the National Entrepreneurship Network (NEN).\r\n"
//						+ "\r\n"
//						+ "IQAC has a representative each from students and alumni. BoS of each department consists of Alumni members.\r\n"
//						+ "Class Review Committees also have student representatives for obtaining feedback on the Teaching- Learning process.\r\n"
//						+ "\r\n"
//						+ "On the whole, the Students Council is a dynamic Body that contributes a great deal to the development of students and institution alike."
//						+ "",
//				font5));

//		table101criteria5.addCell(cell0119);
//		table101criteria5.addCell(cell0120);

				PdfPTable table010criteria5 = new PdfPTable(2);
				PdfPTable table101criteria5 = new PdfPTable(1);

				// Setting width of table, its columns and spacing
				table010criteria5.setWidthPercentage(100);
				table101criteria5.setWidthPercentage(100);

				PdfPCell cell75criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
				cell75criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell76criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
				cell76criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell77criteria5 = new PdfPCell(new Paragraph("Upload any additional information",font5));
				cell77criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell78criteria5 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(3).getCriteria5FilePath() : "",font5));
				cell78criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell79criteria5 = new PdfPCell(
						new Paragraph("Paste link for Additional Information\r\n\r\n",font5));
				cell79criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell80criteria5 = new PdfPCell(new Paragraph());

				table010criteria5.addCell(cell75criteria5);
				table010criteria5.addCell(cell76criteria5);
				table010criteria5.addCell(cell77criteria5);
				table010criteria5.addCell(cell78criteria5);
				table010criteria5.addCell(cell79criteria5);
				table010criteria5.addCell(cell80criteria5);
				
				PdfPCell cell7411criteria5 = new PdfPCell(
						new Paragraph(
						"5.3.2 Presence of an active Student Council & representation of students on academic & administrative bodies/committees of the institution\r\n"
								+ "\r\n\r\n" + "Response:"
								+ (criteria5Record != null ? criteria5Record.getCriteria53Qn().get(0).getResponse532()
										: "")+"\r\n\r\n",font4));
				
				table101criteria5.addCell(cell7411criteria5);

				table101criteria5.setSpacingBefore(20f);
				table101criteria5.setSpacingAfter(20f);

				document.add(table101criteria5);
				document.add(table010criteria5);
			
				PdfPTable table012criteria5 = new PdfPTable(2);
				PdfPTable table121criteria5 = new PdfPTable(1);

				// Setting width of table, its columns and spacing
				table012criteria5.setWidthPercentage(100);
				table121criteria5.setWidthPercentage(100);

				PdfPCell cell81criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
				cell81criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell82criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
				cell82criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell83criteria5 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
				cell83criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell84criteria5 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(4).getCriteria5FilePath() : "",font5));
				cell84criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell85criteria5 = new PdfPCell(new Paragraph("Report of the event\r\n\r\n",font5));
				cell85criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell86criteria5 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(5).getCriteria5FilePath() : "",font5));
				cell86criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell87criteria5 = new PdfPCell(new Paragraph(
						"Number of sports and cultural events / competitions organised per year\r\n\r\n",font5));
				cell87criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell88criteria5 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(6).getCriteria5FilePath() : "",font5));
				cell88criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);

				table012criteria5.addCell(cell81criteria5);
				table012criteria5.addCell(cell82criteria5);
				table012criteria5.addCell(cell83criteria5);
				table012criteria5.addCell(cell84criteria5);
				table012criteria5.addCell(cell85criteria5);
				table012criteria5.addCell(cell86criteria5);
				table012criteria5.addCell(cell87criteria5);
				table012criteria5.addCell(cell88criteria5);
				
				
				PdfPCell cell880criteria5 = new PdfPCell(
						new Paragraph(
						"5.3.3 The institution conducts / organizes following activities:\r\n"
						+ "1. Sports competitions/events\r\n"
						+ "2. Cultural competitions/events\r\n"
						+ "3. Technical fest/Academic fest\r\n"
						+ "4. Any other events through Active clubs and forum\r\n\r\n"
							 + "Response:\r\n\r\n "
								+ (criteria5Record != null ? criteria5Record.getCriteria53Qn().get(0).getResponse533()
										: "")+"\r\n\r\n",font4));
				
//				PdfPCell cell8800criteria5 = new PdfPCell(
//								new Paragraph(
//						"5.3.3.1 Number of sports and cultural events / competitions organised by the institution year - wise during the last five years.",font4));
				

				table121criteria5.addCell(cell880criteria5);
				//table121criteria5.addCell(cell8800criteria5);
				
				table121criteria5.setSpacingBefore(20f);
				table121criteria5.setSpacingAfter(20f);

				document.add(table121criteria5);

				document.add(table012criteria5);


//		table121criteria5.addCell(table012criteria5);

//				if (criteria5Record.getYearTable5331() != null) {
//
//					Table table5331 = new Table(criteria5Record.getYearTable5331().size(), 2);
//
//					table5331.setPadding(5);
//					table5331.setWidth(100f);
//
//					for (int i = 0; i < criteria5Record.getYearTable5331().size(); i++) {
//						
//						Cell cell121criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5331().get(i).getInput5331y(),font5));
//						cell121criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table5331.addCell(cell121criteria5);
//					}
//					for (int i = 0; i < criteria5Record.getYearTable5331().size(); i++) {
//						
//						
//						Cell cell1215criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5331().get(i).getInput5331v(),font5));
//						cell1215criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table5331.addCell(cell1215criteria5);
//					}
//
//					document.add(table5331);
//				}
//				
//				
				
				
				
				///////////////////////// cr5.4

				Paragraph paragraph05 = new Paragraph("5.4 Alumni Engagement\r\n", font2);
				paragraph05.setAlignment(Paragraph.ALIGN_JUSTIFIED);

				document.add(paragraph05);

				PdfPTable table013 = new PdfPTable(2);
				PdfPTable table131 = new PdfPTable(1);

				// Setting width of table, its columns and spacing
				table013.setWidthPercentage(100);
				table131.setWidthPercentage(100);

				PdfPCell cell89criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
				cell89criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell90criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
				cell90criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell91criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
				cell91criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell92criteria5 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : "",font5));
				cell92criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell93criteria5 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n",font5));
				cell93criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell94criteria5 = new PdfPCell(new Paragraph());
				cell94criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);

				table013.addCell(cell89criteria5);
				table013.addCell(cell90criteria5);
				table013.addCell(cell91criteria5);
				table013.addCell(cell92criteria5);
				table013.addCell(cell93criteria5);
				table013.addCell(cell94criteria5);

				// PdfPCell cell023 = new PdfPCell(new Paragraph(" ",font2));
				// cell023.setAlignment(PdfCell.ALIGN_LEFT);
//
				PdfPCell cell0244 = new PdfPCell(new Paragraph(
						"5.4.1 Alumni contribution during the last five years to the institution through registered Alumni association.\r\n"
								+ "\r\n\r\n" + "Response:"
								+ (criteria5Record != null ? criteria5Record.getCriteria54Ql().get(0).getResponse541()
										: "")+"\r\n\r\n",
						font4));
				PdfPCell cell0255 = new PdfPCell(new Paragraph(
						"5.4.1.1. Amount of alumni contribution during the last five year	(INR in lakhs) to the institution through registered Alumni association:\r\n",
						
						font4));
				
				

//		PdfPCell cell0255 = new PdfPCell(new Paragraph(
//				"* Alumni members are made members of Boards of Studies of various departments. They contribute in the curriculum design. They examine the current curriculum and give suggestions vis-a-vis the industry-institution interface requirements.\r\n"
//						+ "* They also give advice on the establishment of laboratories, which involve experiments using modern tools for improved employability of students.\r\n"
//						+ "* Alumni members are invited to deliver technical talks and provide career guidance to the students. Alumni members help the students in establishing a network of support for their professional career progression, namely, higher education in India and abroad, internships and placements.\r\n"
//						+ "* Alumni working in various industries connect the placement cell of the college to their respective industries, thereby, facilitate the college with opportunities for internships and placements of students.\r\n"
//						+ "* In addition, they also connect the industry-institute interaction cell of the college, facilitating industrial visits, internships for students and resource persons for student development and faculty development programs.\r\n"
//						+ "* Alumni promote the college at various fora, thereby serving as brand ambassadors of the college, by making the audience aware about the salient features of the college as well as important developments that have been taking place in the college over the years.\r\n"
//						+ "* Alumni working in various R & D establishments connect the faculty of the college to their professional seniors, facilitating testing requirements of, as part of research carried out by faculty, and also in the preparation of research proposals being submitted by the college for various funding agencies.\r\n"
//						+ "* Alumni, who pursued higher education abroad, help the students in securing admissions in the universities, where they have studied, through preparation of statement of purpose, research projects and funds available with various professors in universities. This information is extremely useful for students, since, they can approach the professors by explicitly mentioning their research interests, which may perhaps improve their chances of securing scholarship with full or partial tuition fee waiver.\r\n"
//						+ "* Alumni of the college have donated certain resources/facilities to college for students use.\r\n"
//						+ "",
//				font5));
				table131.addCell(cell0244);
		      // table131.addCell(cell0255);

//				table131.addCell(table013);

				table131.setSpacingBefore(20f);
				table131.setSpacingAfter(20f);

				document.add(table131);
				document.add(table013);
				

				PdfPTable table014 = new PdfPTable(1);

				// Setting width of table, its columns and spacing
				table014.setWidthPercentage(100);

				PdfPCell cell0266 = new PdfPCell(
						new Paragraph("5.4.2 Alumni contributes and engages significantly to the development of institution through academic and other support system.\r\n\r\n"
							+ "Response:"
								+ (criteria5Record != null ? criteria5Record.getCriteria54Ql().get(0).getResponse542()
										: "")+"\r\n\r\n",
								font4));
				table014.addCell(cell0266);

				table014.setSpacingBefore(20f);
				table014.setSpacingAfter(20f);

				document.add(table014);
				

				PdfPTable table0131 = new PdfPTable(2);
				PdfPTable table1311 = new PdfPTable(1);

				// Setting width of table, its columns and spacing
				table0131.setWidthPercentage(100);
				table1311.setWidthPercentage(100);

				PdfPCell cell89criteria51 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
				cell89criteria51.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell90criteria51 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
				cell90criteria51.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell91criteria51 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
				cell91criteria51.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell92criteria51 = new PdfPCell(
						new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : "",font5));
				cell92criteria51.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell93criteria51 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n",font5));
				cell93criteria51.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell94criteria51 = new PdfPCell(new Paragraph());
				cell94criteria51.setHorizontalAlignment(Element.ALIGN_CENTER);

				table0131.addCell(cell89criteria51);
				table0131.addCell(cell90criteria51);
				table0131.addCell(cell91criteria51);
				table0131.addCell(cell92criteria51);
				table0131.addCell(cell93criteria51);
				table0131.addCell(cell94criteria51);
//				table1311.addCell(table0131);

				table1311.setSpacingBefore(20f);
				table1311.setSpacingAfter(20f);

				document.add(table1311);
				document.add(table0131);

				document.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return file.toAbsolutePath().toString();
		}


}
