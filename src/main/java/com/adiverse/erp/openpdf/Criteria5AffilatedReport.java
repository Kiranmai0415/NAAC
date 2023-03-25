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
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class Criteria5AffilatedReport {

	@Value("${upload.files.path}")
	private String reportGeneratePath;

	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	@Autowired
	Criteria5Service service5;

	List<Criteria5_FieldInfo> criteria5List = null;
	Criteria5_FieldInfo criteria5Record = null;
	List<Criteria5_FileUpload> criteria5file = null;

	public String generateReport( Map<String, String> allParams) throws DocumentException, IOException {
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
//			allParams.put("collegeId",criteria5Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear",criteria5Fieldinfo.getCriteriaId().getFinancialYear() );
//			allParams.put("typeofInstitution", criteria5Fieldinfo.getCriteriaId().getTypeofInstitution());

			criteria5List = service5.getAllCriteria5Data(allParams);
			if (CollectionUtils.isNotEmpty(criteria5List)) {
				criteria5Record = criteria5List.get(0);
				criteria5file = criteria5Record.getCriteria5FileUpload();
			} else {
				criteria5Record = new Criteria5_FieldInfo();
				criteria5file = new ArrayList<Criteria5_FileUpload>();
			}

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "Criteria5AffilatedReport-" + strDate + ".pdf";
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
			//paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph);

			// 5.1
			Paragraph paragraph0 = new Paragraph("Criterion 5 - Student Support and Progression\r\n\r\n", font1);
			paragraph0.setAlignment(Paragraph.ALIGN_CENTER);
			
			
			Paragraph paragraphlinecriteria1 = new Paragraph(
					"____________________________________________________________________________\r\n");
			document.add(paragraphlinecriteria1);
			
			

			Paragraph paragraph02 = new Paragraph("5.1 Student Support\r\n", font2);
			paragraph02.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph0);
			document.add(paragraph02);

			PdfPTable table01criteria5 = new PdfPTable(2);
			PdfPTable table011 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table01criteria5.setWidthPercentage(100);
			table011.setWidthPercentage(100);

			PdfPCell cell1001 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell1001.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell1001.setExtraParagraphSpace(10);
			
			PdfPCell cell1002 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell1002.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell1002.setExtraParagraphSpace(10);
			
			PdfPCell cell1003 = new PdfPCell(new Paragraph(
					"\r\nUpload self attested letter with the list of students sanctioned scholarships\r\n\r\n",font5));
			cell1003.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell1003.setExtraParagraphSpace(10);
			
			PdfPCell cell1004 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell1004.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell1004.setExtraParagraphSpace(10);
			
			PdfPCell cell1005 = new PdfPCell(new Paragraph(
					"\r\nUpload any additional information Average percentage of students benefited by scholarships and freeships provided by the Government during the last five years (Data Template \r\n\r\n",font5));
			cell1005.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell1005.setExtraParagraphSpace(10);
			
			PdfPCell cell1006 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell1006.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell1006.setExtraParagraphSpace(10);
			

			table01criteria5.addCell(cell1001);
			table01criteria5.addCell(cell1002);
			table01criteria5.addCell(cell1003);
			table01criteria5.addCell(cell1004);
			table01criteria5.addCell(cell1005);
			table01criteria5.addCell(cell1006);

			PdfPCell cell0001 = new PdfPCell(new Paragraph(
					"5.1.1 Percentage of students benefited by scholarships and freeships provided by the Government and Non-Government agencies and philanthropists during last five years\r\n"
							+ "\r\n" + "Response: "
							+ (criteria5Record != null
									? criteria5Record.getCriteria51Qn().get(0).getResponse511()
									: "")+"\r\n\r\n",
					font4));
			table011.addCell(cell0001);

//			PdfPCell cell00010 = new PdfPCell(new Paragraph(
//					(criteria5Record != null ? criteria5Record.getCriteria51Q().get(0).getInput511t1() : ""),
//					font3));

//			PdfPTable table5111criteria5 = new PdfPTable(2);
//			table5111criteria5.setWidthPercentage(100);
			
			
			Paragraph paragraph5111criteria5 = new Paragraph (
					"5.1.1.1 Number of students benefited by scholarships and free ships provided by the institution, Government and non-government bodies, industries, individuals, philanthropists during the last five years (other than students receiving scholarships under the government schemes for reserved categories)\r\n\r\n",
					font4);
			paragraph5111criteria5.setAlignment(Element.ALIGN_JUSTIFIED);
//			table011.addCell(cell00010);
           
//	table5111criteria5.addCell(cell0002);

	//		table011.addCell(table01criteria5);

			table011.setSpacingBefore(20f);
			table011.setSpacingAfter(20f);
			table011.setSpacingAfter(20);
			table011.setSpacingBefore(20);
			document.add(table011);
			
			 document.add(paragraph5111criteria5);
			
//			table5111criteria5.setSpacingAfter(20);
//			table5111criteria5.setSpacingBefore(20);
//			document.add(table5111criteria5);
			
			
			

			// YEAR TABLE 5111
			if (criteria5Record.getYearTable5111() != null) {
				Table table5111 = new Table(criteria5Record.getYearTable5111().size(), 2);

				table5111.setPadding(5);
				table5111.setWidth(100f);

				for (int i = 0; i < criteria5Record.getYearTable5111().size(); i++) {
					Cell cell1criteria5111 = new Cell (criteria5Record.getYearTable5111().get(i).getInput5111y());
					cell1criteria5111.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5111.addCell(cell1criteria5111);

				}
				for (int i = 0; i < criteria5Record.getYearTable5111().size(); i++) {
					Cell cell2criteria5111 = new Cell (criteria5Record.getYearTable5111().get(i).getInput5111v());
					cell2criteria5111.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5111.addCell(cell2criteria5111);

				}

				document.add(table5111);
				
			}
			
			table01criteria5.setSpacingBefore(20);
			table01criteria5.setSpacingAfter(20);
			document.add(table01criteria5);
			
			
//			// Creating table
//			PdfPTable table02criteria5 = new PdfPTable(2);
			PdfPTable table021 =new PdfPTable(1);
			table021.setWidthPercentage(100);
			
			PdfPTable table022 =new PdfPTable(1);
			table022.setWidthPercentage(100);
//
//			// Setting width of table, its columns and spacing
//			table02criteria5.setWidthPercentage(100);
//			table021.setWidthPercentage(100);
//
//			PdfPCell cell00001 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
//			cell00001.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell00001.setExtraParagraphSpace(10);
//			
//			PdfPCell cell00002 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//			cell00002.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell00002.setExtraParagraphSpace(10);
//			
//			PdfPCell cell00003 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
//			cell00003.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell00003.setExtraParagraphSpace(10);
//			
//			PdfPCell cell00004 = new PdfPCell(
//					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
//			cell00004.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell00004.setExtraParagraphSpace(10);
//			
//			PdfPCell cell00005 = new PdfPCell(new Paragraph(
//					"\r\nNumber of students benefited by scholarships and freeships besides government schemes in last 5 years(Date Template)\r\n\r\n",font5));
//			cell00005.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell00005.setExtraParagraphSpace(10);
//			
//			PdfPCell cell00006 = new PdfPCell(
//					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
//			cell00006.setHorizontalAlignment(Element.ALIGN_CENTER);
//	//		cell00006.setExtraParagraphSpace(10);
//			
//
//			table02criteria5.addCell(cell00001);
//			table02criteria5.addCell(cell00002);
//			table02criteria5.addCell(cell00003);
//			table02criteria5.addCell(cell00004);
//			table02criteria5.addCell(cell00005);
//			table02criteria5.addCell(cell00006);
//			table02criteria5.setSpacingAfter(20);
//			table02criteria5.setSpacingBefore(20);
			//document.add(table02criteria5);

		//	PdfPTable table021 = new PdfPTable(1);
			
			PdfPCell cell0003 = new PdfPCell(new Paragraph(
					"5.1.2 Average percentage of students benefitted by scholarships, freeships etc. provided by the\r\n"
							+ "institution / non- government agencies during the last five year\r\n" 
							+"1.Soft skills \r\n"
							+ "2.Language and communication skills \r\n"
							+ "3.Life skills (Yoga, physical fitness, health and hygiene)\r\n"
							+ "4.ICT/computing skills" + "\r\n\r\n" 
							+ "Response: "
							+ (criteria5Record != null
									? criteria5Record.getCriteria51Qn().get(0).getResponse512()
									: "")+"\r\n\r\n",
					font4));

//			PdfPCell cell00030 = new PdfPCell(new Paragraph(
//					(criteria5Record != null ? criteria5Record.getCriteria51Qn().get(0).getInput512t1() : ""),
//					font3));

			PdfPCell cell0004 = new PdfPCell(new Paragraph(
					"5.1.2.1 Number of students benefited by scholarships and free ships provided by the institution,\r\n"
							+ "Government and non-government bodies, industries, individuals, philanthropists during the last five\r\n"
							+ "years (other than students receiving scholarships under the government schemes for reserved\r\n"
							+ "categories)",
					font4));

			table021.addCell(cell0003);
			//table022.addCell(cell0004);

		//	table021.addCell(table02criteria5);

			table021.setSpacingBefore(20f);
			table021.setSpacingAfter(20f);

			// year table 5121

			document.add(table021);
			document.add(table022);
			
//			if (criteria5Record.getYearTable5121().size()>0) {
//				Table table5121 = new Table(criteria5Record.getYearTable5121().size(), 2);
//
//				table5121.setPadding(5);
//				table5121.setWidth(100f);
//
//				for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
//					Cell cell1criteria5121 = new Cell (criteria5Record.getYearTable5121().get(i).getInput5121y());
//					cell1criteria5121.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table5121.addCell(cell1criteria5121);
//					
//					
//
//				}
//				for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
//					Cell cell2criteria5121 = new Cell (criteria5Record.getYearTable5121().get(i).getInput5121v());
//					cell2criteria5121.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table5121.addCell(cell2criteria5121);
//					
//
//				}
//
//				document.add(table5121);
//			}
//			
			
			
			PdfPTable table03criteria5 = new PdfPTable(2);
			PdfPTable table31criteria5 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table03criteria5.setWidthPercentage(100);
			table31criteria5.setWidthPercentage(100);

			PdfPCell cell00019 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell00019.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00019.setExtraParagraphSpace(10);
			
			PdfPCell cell00020 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell00020.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00020.setExtraParagraphSpace(10);
			
			PdfPCell cell00021 = new PdfPCell(new Paragraph(
					"\r\nDetails of capability building and skills enhancement initiatives (Data Template)\r\n\r\n",font5));
			cell00021.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00021.setExtraParagraphSpace(10);
			
			PdfPCell cell00022 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell00022.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00022.setExtraParagraphSpace(10);
			
			PdfPCell cell00023 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell00023.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00023.setExtraParagraphSpace(10);
			
			PdfPCell cell00024 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell00024.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00024.setExtraParagraphSpace(10);
			
			PdfPCell cell00025 = new PdfPCell(new Paragraph("\r\nLink to Institutional website\r\n\r\n",font5));
			cell00025.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00025.setExtraParagraphSpace(10);
			
			PdfPCell cell00026 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell00026.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00026.setExtraParagraphSpace(10);
			

			table03criteria5.addCell(cell00019);
			table03criteria5.addCell(cell00020);
			table03criteria5.addCell(cell00021);
			table03criteria5.addCell(cell00022);
			table03criteria5.addCell(cell00023);
			table03criteria5.addCell(cell00024);
			table03criteria5.addCell(cell00025);
			table03criteria5.addCell(cell00026);
			table03criteria5.setSpacingAfter(20);
			table03criteria5.setSpacingBefore(20);
			
			document.add(table03criteria5);

			PdfPCell cell0005 = new PdfPCell(new Paragraph(
					"5.1.3 Percentage of students benefitted by guidance for competitive examinations and career counseling offered by the Institution during the last five years\r\n"
							+ "\r\n" + "Response: "
							+ (criteria5Record != null
									? criteria5Record.getCriteria51Qn().get(0).getResponse513()
									: "")+"\r\n\r\n",
					font4));
			
			
			
			
			

			PdfPCell cell00005 = new PdfPCell(new Paragraph(
					"5.1.3.1. Number of students benefitted by guidance for competitive examinations and career counselling offered by the institution year wise during last five years\r\n"
							+ "\r\n",font4));
			
			
			
			
			
			
			
			
			

			table31criteria5.addCell(cell0005);
			table31criteria5.addCell(cell00005);
	//		table31criteria5.addCell(cell00050);
		//	table31criteria5.addCell(table03criteria5);

			table31criteria5.setSpacingBefore(20);
			table31criteria5.setSpacingAfter(20);

			document.add(table31criteria5);
			
			
			if (criteria5Record.getAffiliatedYearTable5131().size()>0) {
				Table table5131 = new Table(criteria5Record.getAffiliatedYearTable5131().size(), 2);

				table5131.setPadding(5);
				table5131.setWidth(100f);

				for (int i = 0; i < criteria5Record.getAffiliatedYearTable5131().size(); i++) {
					Cell cell1criteria5121 = new Cell (criteria5Record.getAffiliatedYearTable5131().get(i).getInput5131y());
					cell1criteria5121.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5131.addCell(cell1criteria5121);
					
					

				}
				for (int i = 0; i < criteria5Record.getAffiliatedYearTable5131().size(); i++) {
					Cell cell2criteria5121 = new Cell (criteria5Record.getAffiliatedYearTable5131().get(i).getInput5131v());
					cell2criteria5121.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5131.addCell(cell2criteria5121);
					

				}

				document.add(table5131);
			}


			PdfPTable table04criteria5 = new PdfPTable(2);
			PdfPTable table41criteria5 = new PdfPTable(1);
			PdfPTable table410criteria5 = new PdfPTable(1);
			

			// Setting width of table, its columns and spacing
			table04criteria5.setWidthPercentage(100);
			table41criteria5.setWidthPercentage(100);
			table410criteria5.setWidthPercentage(100);
			
			PdfPCell cell00027 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell00027.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell00027.setExtraParagraphSpace(10);
			
			PdfPCell cell00028 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell00028.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00028.setExtraParagraphSpace(10);
			
			PdfPCell cell00029 = new PdfPCell(new Paragraph(
					"\r\nNumber of students benefited by guidance for competitive examinations and career counselling during the last five years\r\n\r\n",font5));
			cell00029.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00029.setExtraParagraphSpace(10);
			
			PdfPCell cell000300 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell000300.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell000300.setExtraParagraphSpace(10);
			
			PdfPCell cell00031 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell00031.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00031.setExtraParagraphSpace(10);
			
			PdfPCell cell00032 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell00032.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00032.setExtraParagraphSpace(10);
			

			table04criteria5.addCell(cell00027);
			table04criteria5.addCell(cell00028);
			table04criteria5.addCell(cell00029);
			table04criteria5.addCell(cell000300);
			table04criteria5.addCell(cell00031);
			table04criteria5.addCell(cell00032);
			
			table04criteria5.setSpacingBefore(20f);
			table04criteria5.setSpacingAfter(20f);
			document.add(table04criteria5);
			
			//year table 5131
			
			
			
			
			
			
			

			PdfPCell cell0006 = new PdfPCell(new Paragraph(
					"5.1.4The Institution has a transparent mechanism for timely redressal of student grievances including sexual harassment and ragging cases\r\n"
					+ "1. Implementation of guidelines of statutory/regulatory bodies \r\n"
					+ "2. Organisation wide awareness and undertakings on policies with zero \r\n"
					+ "tolerance \r\n"
					+ "3. Mechanisms for submission of online/offline students’ grievances \r\n"
					+ "4. Timely redressal of the grievances through appropriate committees.\r\n"
							+ "\r\n" + "Response: "
							+ (criteria5Record != null
									? criteria5Record.getCriteria51Qn().get(0).getResponse514()
									: "")+"\r\n\r\n",
					font4));

			table41criteria5.addCell(cell0006);

			table41criteria5.setSpacingBefore(20f);
			table41criteria5.setSpacingAfter(20f);

			document.add(table41criteria5);
			table410criteria5.setSpacingAfter(20);
			table410criteria5.setSpacingBefore(20);
			document.add(table410criteria5);
			
			
			PdfPTable tablecriteria5 = new PdfPTable(2);
			tablecriteria5.setWidthPercentage(100);
			
			
			PdfPCell cell027 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell027.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			
			PdfPCell cell028 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell028.setHorizontalAlignment(Element.ALIGN_CENTER);

			
			PdfPCell cell029 = new PdfPCell(new Paragraph(
					"\r\nMinutes of the meetings of student redressal committee, prevention of sexual harassment committee and Anti Ragging committee\r\n\r\n",font5));
			cell029.setHorizontalAlignment(Element.ALIGN_CENTER);
	
			
			PdfPCell cell030 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell030.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell031 = new PdfPCell(new Paragraph(
					"\r\nUpload any additional information	\r\n\r\n",font5));
			cell031.setHorizontalAlignment(Element.ALIGN_CENTER);
	
			
			PdfPCell cell032 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell032.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell033 = new PdfPCell(new Paragraph(
					"\r\n   Details of student grievances including sexual harassment and ragging cases	\r\n\r\n",font5));
			cell033.setHorizontalAlignment(Element.ALIGN_CENTER);
	
			
			PdfPCell cell034 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell034.setHorizontalAlignment(Element.ALIGN_CENTER);
	
			tablecriteria5.addCell(cell027);
			tablecriteria5.addCell(cell028);
			tablecriteria5.addCell(cell029);
			tablecriteria5.addCell(cell030);
			tablecriteria5.addCell(cell031);
			tablecriteria5.addCell(cell032);
			tablecriteria5.addCell(cell033);
			tablecriteria5.addCell(cell034);
			
			document.add(tablecriteria5);
			
			
			
			
			
			
			



			// 5.2
			Paragraph paragraph03 = new Paragraph("5.2	Student Progression\r\n", font2);
			paragraph03.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph03);

			PdfPTable table52criteria5 = new PdfPTable(1);
			table52criteria5.setWidthPercentage(100f);


			PdfPCell cell52criteria5= new PdfPCell(new Paragraph(
					"5.2.1 Percentage of placement of outgoing students and students progressing to higher education during the last five years"
							+ "\r\n\r\n" + "Response: "
							+(criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getResponse521() :"")+"\r\n\r\n",font4));
			table52criteria5.addCell(cell52criteria5);
			table52criteria5.setSpacingAfter(20);
			table52criteria5.setSpacingBefore(20);
			
			document.add(table52criteria5);

//			Paragraph paragraph05 = new Paragraph(
//					criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getResponse521() : "",font5);
//			document.add(paragraph05);

			Paragraph paragraph14 = new Paragraph(
					"5.2.1.1 Number of outgoing students placed and / or progressed to higher education year wise during the last five years\r\n\r\n",font4);
			document.add(paragraph14);

			if (criteria5Record.getYearTable5211().size()>0) {
				Table table5211 = new Table(criteria5Record.getYearTable5211().size(), 2);

				table5211.setPadding(5);
				table5211.setWidth(100f);

				for (int i = 0; i < criteria5Record.getYearTable5211().size(); i++) {
					Cell cell1criteria5211 = new Cell (criteria5Record.getYearTable5211().get(i).getInput5211y());
					cell1criteria5211.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5211.addCell(cell1criteria5211);

					
				}
				for (int i = 0; i < criteria5Record.getYearTable5211().size(); i++) {
					Cell cell2criteria5211 = new Cell (criteria5Record.getYearTable5211().get(i).getInput5211v());
					cell2criteria5211.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5211.addCell(cell2criteria5211);
				

				}

				document.add(table5211);
			}
			
			
			Paragraph paragraph104 = new Paragraph(
					"5.2.1.2. Number of outgoing students year wise during the last five years\r\n\r\n",font4);
			document.add(paragraph104);

			Paragraph paragraph06 = new Paragraph("\r\n");
			document.add(paragraph06);

			if (criteria5Record.getAffiliatedYearTable5212().size()>0) {
				Table table5212 = new Table(criteria5Record.getAffiliatedYearTable5212().size(), 2);

				table5212.setPadding(5);
				table5212.setWidth(100f);

				for (int i = 0; i < criteria5Record.getAffiliatedYearTable5212().size(); i++) {
					Cell cell1criteria52110 = new Cell (criteria5Record.getAffiliatedYearTable5212().get(i).getInput5212y());
					cell1criteria52110.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5212.addCell(cell1criteria52110);
					

				}
				for (int i = 0; i < criteria5Record.getYearTable5211().size(); i++) {
					Cell cell2criteria52110 = new Cell (criteria5Record.getAffiliatedYearTable5212().get(i).getInput5212v());
					cell2criteria52110.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5212.addCell(cell2criteria52110);
					

				}

				document.add(table5212);
			}
			

			PdfPTable table06criteria5 = new PdfPTable(2);
			PdfPTable table061 = new PdfPTable(1);

			table06criteria5.setWidthPercentage(100);
			table061.setWidthPercentage(100);

			PdfPCell cell00043 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell00043.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00043.setExtraParagraphSpace(10);
			
			PdfPCell cell00044 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell00044.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00044.setExtraParagraphSpace(10);
			
			PdfPCell cell00045 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell00045.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00045.setExtraParagraphSpace(10);
			
			PdfPCell cell00046 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell00046.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00046.setExtraParagraphSpace(10);
			
			PdfPCell cell00047 = new PdfPCell(new Paragraph("\r\nSelf attested list of students placed\r\n\r\n",font5));
			cell00047.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00047.setExtraParagraphSpace(10);
			
			PdfPCell cell00048 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell00048.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00048.setExtraParagraphSpace(10);
			
			PdfPCell cell00049 = new PdfPCell(
					new Paragraph("\r\nDetails of student placement during the last five years\r\n\r\n",font5));
			cell00049.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00049.setExtraParagraphSpace(10);
			
			PdfPCell cell000500 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell000500.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell000500.setExtraParagraphSpace(10);
			

			table06criteria5.addCell(cell00043);
			table06criteria5.addCell(cell00044);

			table06criteria5.addCell(cell00047);
			table06criteria5.addCell(cell00048);

			table06criteria5.addCell(cell00045);
			table06criteria5.addCell(cell00046);
			table06criteria5.addCell(cell00049);
			table06criteria5.addCell(cell000500);
			table06criteria5.setSpacingAfter(20);
			table06criteria5.setSpacingBefore(20);
			
			document.add(table06criteria5);

			
			//  5.2
			
			PdfPTable table522criteria5 = new PdfPTable(1);
			table522criteria5.setWidthPercentage(100f);

			PdfPCell cell522criteria5 = new PdfPCell(new Paragraph(
					"5.2.2  Percentage of students qualifying in state/national/ international level	examinations during the last five years (eg: JAM/CLAT/GATE/ GMAT/ CAT GRE/ TOEFL/ Civil Services/State government examinations)\r\n"
							+ "\r\n" 
							+ "Response: "
							+(criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getResponse522() : "")+"\r\n\r\n",font4));
			table522criteria5.addCell(cell522criteria5);
			table522criteria5.setSpacingAfter(20);
			table522criteria5.setSpacingBefore(20);
			
			document.add(table522criteria5);
			
			
			

//			Paragraph paragraph08 = new Paragraph(
//					criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getResponse522() : "",font5);
//			document.add(paragraph08);

			
			
			
			PdfPTable table5221criteria5 = new PdfPTable(1);
			table5221criteria5.setWidthPercentage(100f);

			PdfPCell cell5221criteria5 = new PdfPCell(new Paragraph(
					"5.2.2.1 Number of outgoing student progressing to higher education.\r\n\r\n"
					+(criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getInput522t1() : "")+"\r\n\r\n",font4));

			table5221criteria5.addCell(cell5221criteria5);
			document.add(table5221criteria5);
		
			//year table 5221
			
			if (criteria5Record.getAffiliatedYearTable5221().size()>0) {
				Table table5221 = new Table(criteria5Record.getAffiliatedYearTable5221().size(), 2);

				table5221.setPadding(5);
				table5221.setWidth(100f);

				for (int i = 0; i < criteria5Record.getAffiliatedYearTable5221().size(); i++) {
					Cell cell1criteria52110 = new Cell (criteria5Record.getAffiliatedYearTable5221().get(i).getInput5221y());
					cell1criteria52110.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5221.addCell(cell1criteria52110);
					

				}
				for (int i = 0; i < criteria5Record.getAffiliatedYearTable5221().size(); i++) {
					Cell cell2criteria52110 = new Cell (criteria5Record.getAffiliatedYearTable5221().get(i).getInput5221v());
					cell2criteria52110.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5221.addCell(cell2criteria52110);
					

				}

				document.add(table5221);
			}
			
			

			
//			Paragraph paragraph11 = new Paragraph(
//					criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getInput522t1() : "",font5);
//			document.add(paragraph11);
			
			

			PdfPTable table07criteria5 = new PdfPTable(2);
			PdfPTable table71criteria5 = new PdfPTable(1);

// Setting width of table, its columns and spacing
			table07criteria5.setWidthPercentage(100);
			table71criteria5.setWidthPercentage(100);

			PdfPCell cell51criteria5 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell51criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell51criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell520criteria5 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell520criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell52criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell53criteria5 = new PdfPCell(
					new Paragraph("\r\nUpload supporting data for student/alumni\r\n\r\n",font5));
			cell53criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell53criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell54criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell54criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell54criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell55criteria5 = new PdfPCell(new Paragraph(
					"\r\nDetails of student progression to higher education\r\n" + "(Data Template)\r\n\r\n",font5));
			cell55criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell55criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell56criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell56criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell56criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell57criteria5 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell57criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell57criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell58criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell58criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell58criteria5.setExtraParagraphSpace(10);
			

			table07criteria5.addCell(cell51criteria5);
			table07criteria5.addCell(cell520criteria5);
			table07criteria5.addCell(cell53criteria5);
			table07criteria5.addCell(cell54criteria5);
			table07criteria5.addCell(cell57criteria5);
			table07criteria5.addCell(cell58criteria5);

			table07criteria5.addCell(cell55criteria5);
			table07criteria5.addCell(cell56criteria5);
			table07criteria5.setSpacingAfter(20);
			table07criteria5.setSpacingBefore(20);
			
			document.add(table07criteria5);
			
			
//
//			PdfPTable table523criteria5 = new PdfPTable(1);
//			table523criteria5.setWidthPercentage(100f);
//
//
//			PdfPCell cell523criteria5 = new PdfPCell(new Paragraph(
//					"5.2.3  Average percentage of students qualifying in state/national/ international level examinations\r\n"
//							+ "during the last five years (eg: IIT-JAM/CLAT/ NET/SLET/GATE/ GMAT/CAT/GRE/ TOEFL/\r\n"
//							+ "Civil Services/State government examinations, etc.)\r\n\r\n" + "Response: "
//							+(criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getResponse523() : "")+"\r\n\r\n",font4));
//			table523criteria5.addCell(cell523criteria5);
//			table523criteria5.setSpacingAfter(20);
//			table523criteria5.setSpacingBefore(20);
//			
//			document.add(table523criteria5);
			
			
//			Paragraph paragraph141 = new Paragraph(
//					criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getResponse523() : "",font5);
//			document.add(paragraph141);

			PdfPTable table5231criteria5 = new PdfPTable(1);
			table5231criteria5.setWidthPercentage(100f);

//
//			PdfPCell cell5231criteria5 = new PdfPCell(new Paragraph(
//					"5.2.3.1 Number of awards/medals for outstanding performance in sports cultural activities at University / state/ national / international level (award for a team event should be counted as one) during the last five	years"+"\r\n\r\n",
//					font4));
//			table5231criteria5.addCell(cell5231criteria5);
//			table5231criteria5.setSpacingAfter(20);
//			table5231criteria5.setSpacingBefore(20);
//			document.add(table5231criteria5);
//
//			if (criteria5Record.getYearTable5231().size()>0) {
//				Table table5231 = new Table(criteria5Record.getYearTable5231().size(), 2);
//
//				table5231.setPadding(5);
//				table5231.setWidth(100f);
//
//				for (int i = 0; i < criteria5Record.getYearTable5231().size(); i++) {
//					Cell cell1criteria5231 = new Cell (criteria5Record.getYearTable5231().get(i).getInput5231y());
//					cell1criteria5231.setHorizontalAlignment(Element.ALIGN_CENTER);
//					
//					table5231.addCell(cell1criteria5231);
//					
//
//				}
//				for (int i = 0; i < criteria5Record.getYearTable5231().size(); i++) {
//					Cell cell2criteria5231 = new Cell (criteria5Record.getYearTable5231().get(i).getInput5231v());
//					cell2criteria5231.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table5231.addCell(cell2criteria5231);
//					
//
//				}
//				
//				
//				document.add(table5231);
//			}

//			PdfPTable table5232criteria5 = new PdfPTable(1);
//			table5232criteria5.setWidthPercentage(100f);
//
//
//			PdfPCell cell5232criteria5 = new PdfPCell(new Paragraph(
//					"5.2.3.2 Number of students appearing in state/ national/ international level examinations (eg:\r\n"
//							+ "JAM/CLAT/NET/ SLET/ GATE/ GMAT/CAT,GRE/ TOFEL/ Civil Services/ State government\r\n"
//							+ "examinations) year-wise during last five years" + "\r\n\r\n",
//					font4));
//			table5232criteria5.addCell(cell5232criteria5);
//			document.add(table5232criteria5);
//
////year table 5232
//			if (criteria5Record.getYearTable5232().size()>0) {
//				Table table5232 = new Table(criteria5Record.getYearTable5232().size(), 2);
//
//				table5232.setPadding(5);
//				table5232.setWidth(100f);
//
//				for (int i = 0; i < criteria5Record.getYearTable5232().size(); i++) {
//					Cell cell1criteria5232 = new Cell (criteria5Record.getYearTable5232().get(i).getInput5232y());
//					cell1criteria5232.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table5232.addCell(cell1criteria5232);
//					
//
//				}
//				for (int i = 0; i < criteria5Record.getYearTable5232().size(); i++) {
//					Cell cell2criteria5232 = new Cell (criteria5Record.getYearTable5232().get(i).getInput5232v());
//					cell2criteria5232.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table5232.addCell(cell2criteria5232);
//				
//				}
//
//				document.add(table5232);
//
//			}

			Paragraph paragraph161 = new Paragraph("\r\n");
			document.add(paragraph161);

			PdfPTable table08criteria5 = new PdfPTable(2);
			PdfPTable table81criteria5 = new PdfPTable(1);

//Setting width of table, its columns and spacing
			table08criteria5.setWidthPercentage(100);
			table81criteria5.setWidthPercentage(100);

			PdfPCell cell59criteria5 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell59criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell59criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell60criteria5 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell60criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell60criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell61criteria5 = new PdfPCell(
					new Paragraph("\r\nUpload supporting data for student/alumni\r\n\r\n",font5));
			cell61criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell61criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell62criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell62criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell62criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell63criteria5 = new PdfPCell(new Paragraph(
					"\r\nNumber of students qualifying in state/ national/ international level examinations during the last five years\r\n\r\n",font5));
			cell63criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell63criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell64criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell64criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell64criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell65criteria5 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell65criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell65criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell66criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell66criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell66criteria5.setExtraParagraphSpace(10);
			

			table08criteria5.addCell(cell59criteria5);
			table08criteria5.addCell(cell60criteria5);
			table08criteria5.addCell(cell61criteria5);
			table08criteria5.addCell(cell62criteria5);
			table08criteria5.addCell(cell65criteria5);
			table08criteria5.addCell(cell66criteria5);
			table08criteria5.addCell(cell63criteria5);
			table08criteria5.addCell(cell64criteria5);
			table08criteria5.setSpacingAfter(20);
			table08criteria5.setSpacingBefore(20);
			
		//	document.add(table08criteria5);

			// 5.3
			Paragraph paragraph004 = new Paragraph("5.3 Student Participation and Activities\r\n", font2);
			paragraph004.setAlignment(Paragraph.ALIGN_LEFT);
			paragraph004.setSpacingAfter(15f);
			document.add(paragraph004);

			PdfPTable table09criteria5 = new PdfPTable(2);
			PdfPTable table91criteria5 = new PdfPTable(1);

			table09criteria5.setWidthPercentage(100);
			table91criteria5.setWidthPercentage(100);

			PdfPCell cell67criteria5 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell67criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell67criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell68criteria5 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell68criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell68criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell69criteria5 = new PdfPCell(new Paragraph(
					"\r\nNumber of awards/medals for outstanding performance in sports/ cultural activities at inter- university / state / national / international level during the last five years\r\n\r\n",font5));
			cell69criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell69criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell70criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell70criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell70criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell71criteria5 = new PdfPCell(
					new Paragraph("\r\nE-copies of award letters and certificates\r\n\r\n",font5));
			cell71criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell71criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell72criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell72criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell72criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell73criteria5 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell73criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell73criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell74criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell74criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell74criteria5.setExtraParagraphSpace(10);
			

			table09criteria5.addCell(cell67criteria5);
			table09criteria5.addCell(cell68criteria5);
			table09criteria5.addCell(cell69criteria5);
			table09criteria5.addCell(cell70criteria5);
			table09criteria5.addCell(cell71criteria5);
			table09criteria5.addCell(cell72criteria5);
			table09criteria5.addCell(cell73criteria5);
			table09criteria5.addCell(cell74criteria5);
			table09criteria5.setSpacingAfter(20);
			table09criteria5.setSpacingBefore(20);
			
			

			PdfPTable table531criteria5 = new PdfPTable(1);
			table531criteria5.setWidthPercentage(100f);


			PdfPCell cell531criteria5 = new PdfPCell(new Paragraph(
					"5.3.1 Number of awards/medals won by students for outstanding performance in sports/cultural\r\n"
							+ "activities at inter-university/state/national / international level (award for a team event should be\r\n"
							+ "counted as one) during the last five years.\r\n" + "Response: "
							+ (criteria5Record != null
									? criteria5Record.getCriteria53Qn().get(0).getResponse531()
									: "")+"\r\n\r\n",
					font4));
			table531criteria5.addCell(cell531criteria5);
			
			document.add(table531criteria5);

//			Paragraph paragraph0661 = new Paragraph(
//					(criteria5Record != null ? criteria5Record.getCriteria53Qn().get(0).getInput531t1() : ""),
//					font3);
//			document.add(paragraph0661);

			PdfPTable table5311criteria5 = new PdfPTable(1);
			table5311criteria5.setWidthPercentage(100f);


			PdfPCell cell5311criteria5 = new PdfPCell(new Paragraph(
					"5.3.1.1 Number of awards/medals for outstanding performance in sports/cultural activities at"
							+ "university/state/national / international level (award for a team event should be counted as one) yearwise during the last five yea"+"\r\n\r\n",
					font4));
			table5311criteria5.addCell(cell5311criteria5);
			table5311criteria5.setSpacingAfter(20);
			table5311criteria5.setSpacingBefore(20);
			document.add(table5311criteria5);

//			table91criteria5.addCell(cell0116);
//			table91criteria5.addCell(cell01160);
//			table91criteria5.addCell(cell0117);
			if (criteria5Record.getYearTable5311().size()>0) {
				Table table5311 = new Table(criteria5Record.getYearTable5311().size(), 2);

				table5311.setPadding(5);
				table5311.setWidth(100f);

				for (int i = 0; i < criteria5Record.getYearTable5311().size(); i++) {
					Cell cell1criteria5311 = new Cell (criteria5Record.getYearTable5311().get(i).getInput5311y());
					cell1criteria5311.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5311.addCell(cell1criteria5311);
					

				}
				for (int i = 0; i < criteria5Record.getYearTable5311().size(); i++) {
					Cell cell2criteria5311 = new Cell (criteria5Record.getYearTable5311().get(i).getInput5311v());
					cell2criteria5311.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5311.addCell(cell2criteria5311);
					

				}

				document.add(table5311);
			}

		//	table91criteria5.addCell(table09criteria5);

			table91criteria5.setSpacingBefore(20f);
			table91criteria5.setSpacingAfter(20f);

			document.add(table91criteria5);
			document.add(table09criteria5);
			// year table 5311

			PdfPTable table012criteria5 = new PdfPTable(2);
			PdfPTable table121criteria5 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table012criteria5.setWidthPercentage(100);
			table121criteria5.setWidthPercentage(100);

			PdfPCell cell81criteria5 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell81criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell81criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell82criteria5 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell82criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell82criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell83criteria5 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell83criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell83criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell84criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell84criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell84criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell85criteria5 = new PdfPCell(new Paragraph("\r\nReport of the event\r\n\r\n",font5));
			cell85criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell85criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell86criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell86criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell86criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell87criteria5 = new PdfPCell(
					new Paragraph("\r\nNumber of sports and cultural events/competitions\r\n"
							+ "in which students of the Institution participated\r\n"
							+ "during last five years (organised by the\r\n"
							+ "institution/other institutions (Data Template)\r\n\r\n",font5));
			cell87criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell87criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell88criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell88criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell88criteria5.setExtraParagraphSpace(10);
			

			table012criteria5.addCell(cell81criteria5);
			table012criteria5.addCell(cell82criteria5);
			table012criteria5.addCell(cell83criteria5);
			table012criteria5.addCell(cell84criteria5);
			table012criteria5.addCell(cell85criteria5);
			table012criteria5.addCell(cell86criteria5);
			table012criteria5.addCell(cell87criteria5);
			table012criteria5.addCell(cell88criteria5);
			table012criteria5.setSpacingAfter(20);
			table012criteria5.setSpacingBefore(20);
			
			
			
			
			
			
			

			PdfPCell cell0121 = new PdfPCell(new Paragraph(
					"5.3.2  Average number of sports and cultural events/competitions in which students of the Institution\r\n"
							+ "participated during last five years (organised by the institution/other institutions)\r\n"
							+ "\r\n"  + "Response: "
							+ (criteria5Record != null
									? criteria5Record.getCriteria53Qn().get(0).getResponse532()
									: "")+"\r\n\r\n",
					font4));
			PdfPCell cell0122 = new PdfPCell(new Paragraph(
					"5.3.2.1  Number of sports and cultural events/competitions in which students of the Institution\r\n"
							+ "participated year-wise during last five years"+"\r\n\r\n",
					font4));

			table121criteria5.addCell(cell0121);
			table121criteria5.addCell(cell0122);

	//		table121criteria5.addCell(table012criteria5);

			table121criteria5.setSpacingBefore(20f);
			table121criteria5.setSpacingAfter(20f);
			document.add(table121criteria5);

			// year table 5331
			if (criteria5Record.getAffiliatedYearTable5321().size()>0) {
				Table table5321 = new Table(criteria5Record.getAffiliatedYearTable5321().size(), 2);

				table5321.setPadding(5);
				table5321.setWidth(100f);

				for (int i = 0; i < criteria5Record.getAffiliatedYearTable5321().size(); i++) {
					Cell cell1criteria5331 = new Cell (criteria5Record.getAffiliatedYearTable5321().get(i).getInput5321y());
					cell1criteria5331.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5321.addCell(cell1criteria5331);
					

				}
				for (int i = 0; i < criteria5Record.getAffiliatedYearTable5321().size(); i++) {
					Cell cell2criteria5331 = new Cell (criteria5Record.getAffiliatedYearTable5321().get(i).getInput5321v());
					cell2criteria5331.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5321.addCell(cell2criteria5331);
					
				}

				document.add(table5321);

			}
			
			document.add(table012criteria5);

			// 5.4

			Paragraph paragraph005 = new Paragraph("5.4 Alumni Engagement\r\n", font2);
			paragraph005.setAlignment(Paragraph.ALIGN_JUSTIFIED);
	//		paragraph005.setAlignment(Paragraph.ALIGN_CENTER);

			document.add(paragraph005);

			PdfPTable table013 = new PdfPTable(2);
			PdfPTable table131 = new PdfPTable(1);

// Setting width of table, its columns and spacing
			table013.setWidthPercentage(100);
			table131.setWidthPercentage(100);

			PdfPCell cell89criteria5 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell89criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell88criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell90criteria5 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell90criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell88criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell91criteria5 = new PdfPCell(new Paragraph(" \r\nUpload Any additional information\r\n\r\n",font5));
			cell91criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell88criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell92criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell92criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//    cell88criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell93criteria5 = new PdfPCell(new Paragraph("\r\nPaste Link for additional information\r\n\r\n",font5));
			cell93criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell88criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell94criteria5 = new PdfPCell(
					new Paragraph("\r\n"+(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "")+"\r\n\r\n",font5));
			cell94criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell88criteria5.setExtraParagraphSpace(10);
			

			table013.addCell(cell89criteria5);
			table013.addCell(cell90criteria5);
			table013.addCell(cell91criteria5);
			table013.addCell(cell92criteria5);
			table013.addCell(cell93criteria5);
			table013.addCell(cell94criteria5);
			table013.setSpacingAfter(20);
			table013.setSpacingBefore(20);

			PdfPCell cell0244 = new PdfPCell(new Paragraph(
					"5.4.1 There is a registered Alumni Association that contributes significantly to the development of the institution through financial and/or other support services.\r\n\r\n"
							 + "Response: "
							+ (criteria5Record != null
									? criteria5Record.getCriteria54Ql().get(0).getResponse541()
									: "")+"\r\n\r\n",
					font4));

			table131.addCell(cell0244);



			table131.setSpacingBefore(20f);
			table131.setSpacingAfter(20f);

			document.add(table131);
			document.add(table013);
			
			document.close();


		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
