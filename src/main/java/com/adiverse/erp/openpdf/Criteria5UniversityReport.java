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

@Service
public class Criteria5UniversityReport {

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
//			allParams.put("financialYear", criteria5Fieldinfo.getCriteriaId().getFinancialYear());
//
//			allParams.put("typeofInstitution", criteria5Fieldinfo.getCriteriaId().getTypeofInstitution() );

			criteria5List = service5.getAllCriteria5Data(allParams);
			if (CollectionUtils.isNotEmpty(criteria5List)) {
				criteria5Record = criteria5List.get(0);
				criteria5file = criteria5Record.getCriteria5FileUpload();
			} else {
				criteria5Record = new Criteria5_FieldInfo();
				criteria5file = new ArrayList<Criteria5_FileUpload>();
			}
ObjectMapper mapper=new ObjectMapper();
System.out.println("criteria5Record===========>>>"+mapper.writeValueAsString(criteria5Record));
			
			
			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "Criteria5UniversityReport-" + strDate + ".pdf";
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

			// 5.1

			Paragraph paragraph0 = new Paragraph("Criterion 5 - Student Support and Progression\r\n", font2);
			paragraph0.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			paragraph0.setSpacingBefore(3f);
			
			document.add(paragraph0);
			
			
			Paragraph paragraph005 = new Paragraph("_________________________________________________________________________");
			paragraph005.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph005);
			
			
			
//			Paragraph paragraph01 = new Paragraph("Criterion 5 - Student Support and Progression\r\n\r\n", font2);
//			paragraph01.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph01);
			
			
			
			
			

			Paragraph paragraph02 = new Paragraph("5.1 Student Support\r\n\r\n", font2);
			paragraph02.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			paragraph02.setSpacingBefore(4f);
			paragraph02.setSpacingAfter(4f);

		
			document.add(paragraph02);

			PdfPTable table01criteria5 = new PdfPTable(2);
			PdfPTable table011 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table01criteria5.setWidthPercentage(100);
			table011.setWidthPercentage(100);

			PdfPCell cell1001 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font4));
			cell1001.setHorizontalAlignment(Element.ALIGN_CENTER);;
			
			
			PdfPCell cell1002 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell1002.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1003 = new PdfPCell(new Paragraph(
					"upload self attested letter with the list of students sanctioned scholarships\r\n",font5));
			cell1003.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1004 = new PdfPCell(
					new Paragraph((criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : ""),font5));
			cell1004.setExtraParagraphSpace(10f);
			cell1004.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1007 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n",font5));
			cell1007.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1008 = new PdfPCell(
					new Paragraph((criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : ""),font5));
			cell1008.setExtraParagraphSpace(10f);
			cell1008.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1005 = new PdfPCell(new Paragraph("Link for additional information\r\n"));
			cell1005.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell1006 = new PdfPCell(
					new Paragraph((criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : ""),font5));
			cell1006.setExtraParagraphSpace(10f);
			cell1006.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table01criteria5.addCell(cell1001);
			table01criteria5.addCell(cell1002);
			table01criteria5.addCell(cell1003);
			table01criteria5.addCell(cell1004);
			table01criteria5.addCell(cell1005);
			table01criteria5.addCell(cell1006);
			table01criteria5.addCell(cell1007);
			table01criteria5.addCell(cell1008);

			if (criteria5Record.getCriteria51Qn() != null) {
				PdfPCell cell0001 = new PdfPCell(new Paragraph(
						"5.1.1 Percentage of students benefited by scholarships and freeships \r\n"
						+ "provided by the institution, Government and non-government \r\n"
						+ "bodies, industries, individuals, philanthropists during the last five \r\n"
						+ "year\r\n"
								+ "\r\n" + "Response: "
								+ (criteria5Record != null
										? criteria5Record.getCriteria51Qn().get(0).getResponse511()
										: ""),
						font4));
				cell0001.setExtraParagraphSpace(10f);	
				

				PdfPCell cell0002 = new PdfPCell(new Paragraph(
						"5.1.1.1 Number of students benefited by scholarships and free ships provided by the institution, Government and non-government bodies, industries, individuals, philanthropists during the last five years (other than students receiving scholarships under the government schemes for reserved categories)\r\n\r\n",
						font4));
				table011.addCell(cell0001);
				table011.addCell(cell0002);

		//		table011.addCell(table01criteria5);
//
//				table011.setSpacingBefore(20f);
//				table011.setSpacingAfter(20f);

				document.add(table011);
				
				table01criteria5.setSpacingBefore(20f);
				table01criteria5.setSpacingAfter(20f);

				document.add(table01criteria5);
				
				
			}
			if (criteria5Record.getYearTable5111().size() > 0) {

				Table table5111 = new Table(criteria5Record.getYearTable5111().size(), 2);

				table5111.setPadding(5);
				table5111.setWidth(100f);

				for (int i = 0; i < criteria5Record.getYearTable5111().size(); i++) {
					Cell cell1=new Cell(new Paragraph((criteria5Record.getYearTable5111().get(i).getInput5111y()),font5));
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5111.addCell(cell1);
				}
				for (int i = 0; i < criteria5Record.getYearTable5111().size(); i++) {
					Cell cell2=new Cell(new Paragraph(criteria5Record.getYearTable5111().get(i).getInput5111v(),font5));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5111.addCell(cell2);
				}

				document.add(table5111);
			}
			// Creating table                   
			PdfPTable table02criteria5 = new PdfPTable(2);
			PdfPTable table021 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table02criteria5.setWidthPercentage(100);
			table021.setWidthPercentage(100);

			PdfPCell cell00001 = new PdfPCell(new Paragraph("FileDescription\r\n", font4));
			cell00001.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell00002 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell00002.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell00003 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n", font5));
			cell00003.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell00004 = new PdfPCell(
					new Paragraph((criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : ""), font5));
			cell00004.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00004.setExtraParagraphSpace(10f);	
			
			
			PdfPCell cell00005 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n", font5));
			
			cell00005.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell00006 = new PdfPCell(
					new Paragraph((criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : ""), font5));
			cell00006.setExtraParagraphSpace(10f);	
			cell00006.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell00007 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n", font5));
			cell00007.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell00008 = new PdfPCell(
					new Paragraph((criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : ""), font5));
			cell00008.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00008.setExtraParagraphSpace(10f);
			
			
			cell00008.setExtraParagraphSpace(10f);	
			table02criteria5.addCell(cell00001);
			table02criteria5.addCell(cell00002);
			table02criteria5.addCell(cell00003);
			table02criteria5.addCell(cell00004);
			table02criteria5.addCell(cell00005);
			table02criteria5.addCell(cell00006);
			table02criteria5.addCell(cell00007);
			table02criteria5.addCell(cell00008);
			
			
			
			

			PdfPCell cell0003 = new PdfPCell(new Paragraph(
					"5.1.2 Efforts taken by the institution to provide career counseling \r\n"
					+ "including e-counseling and guidance for competitive examinations \r\n"
					+ "during the last five years\r\n"
					 + "Response:"
							+ (criteria5Record != null
									? criteria5Record.getCriteria51Qn().get(0).getResponse512()
									: ""),
					font4));
			
			cell0003.setExtraParagraphSpace(10f);	
			
			PdfPCell cell0004 = new PdfPCell(new Paragraph(
					"5.1.2.1 Number of students benefited by scholarships and free ships provided by the institution, Government and non-government bodies, industries, individuals, philanthropists during the last five years (other than students receiving scholarships under the government schemes for reserved categories)",
					font4));
			
			cell0004.setExtraParagraphSpace(10F);
			table021.addCell(cell0003);
		//	table021.addCell(cell0004);

	//		table021.addCell(table02criteria5);

			table021.setSpacingBefore(20f);

			document.add(table021);
			
			table02criteria5.setSpacingBefore(20f);
			table02criteria5.setSpacingAfter(20f);
			document.add(table02criteria5);
			
			
			if (criteria5Record.getYearTable5121().size() > 0) {
				Table table5121 = new Table(criteria5Record.getYearTable5121().size(), 2);

				table5121.setPadding(5);
				table5121.setWidth(100f);

				for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
					Cell cell5=new Cell(new Paragraph(criteria5Record.getYearTable5121().get(i).getInput5121y(),font5));
					cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5121.addCell(cell5);
				}
				for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
					Cell cell6=new Cell(new Paragraph(criteria5Record.getYearTable5121().get(i).getInput5121v()));
					cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5121.addCell(cell6);

				}

		//		document.add(table5121);
			}
			PdfPTable table03criteria5 = new PdfPTable(2);
			PdfPTable table31criteria5 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table03criteria5.setWidthPercentage(100);
			table31criteria5.setWidthPercentage(100);

			PdfPCell cell00019 = new PdfPCell(new Paragraph("FileDescription\r\n", font4));
			cell00019.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00020 = new PdfPCell(new Paragraph("Document\r\n", font4));
			cell00020.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell00021 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n",font5));
			cell00021.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell00022 = new PdfPCell(
					new Paragraph((criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : ""),font5));
			cell00022.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00022.setExtraParagraphSpace(10f);	
			
//			PdfPCell cell00023 = new PdfPCell(new Paragraph(
//					"Number of students benefited by scholarships and freeships besides government schemes in last 5 years\r\n\r\n\r\n"));
//			PdfPCell cell00024 = new PdfPCell(
//					new Paragraph(criteria5Record != null ? criterai5file.get(8).getCriteria5FilePath() : ""));
			PdfPCell cell00025 = new PdfPCell(new Paragraph("Link for additional information",font5));
			
			cell00025.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell00026 = new PdfPCell(
					new Paragraph((criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : ""),font5));
			cell00026.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table03criteria5.addCell(cell00019);
			table03criteria5.addCell(cell00020);
			table03criteria5.addCell(cell00021);
			table03criteria5.addCell(cell00022);
//			table03criteria5.addCell(cell00023);
//			table03criteria5.addCell(cell00024);
			table03criteria5.addCell(cell00025);
			table03criteria5.addCell(cell00026);

			PdfPCell cell0005 = new PdfPCell(new Paragraph(
					"5.1.3 Following Capacity development and skills enhancement activities are organised for improving students capability 1. Soft skills 2. Language and communication skills 3. Life skills (Yoga, physical fitness, health and hygiene) 4. Awareness of trends in technology\r\n"
							+ (criteria5Record != null
									? criteria5Record.getCriteria51Qn().get(0).getResponse513()
									: ""),
					font4));
			
			cell0005.setExtraParagraphSpace(10f);	
			table31criteria5.addCell(cell0005);



			table31criteria5.setSpacingBefore(20F);

			document.add(table31criteria5);
			table03criteria5.setSpacingBefore(20f);
			table03criteria5.setSpacingAfter(20f);
			
			document.add(table03criteria5);

			PdfPTable table04criteria5 = new PdfPTable(2);
			PdfPTable table41criteria5 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table04criteria5.setWidthPercentage(100);
			table41criteria5.setWidthPercentage(100);

			PdfPCell cell00027 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font4));
			cell00027.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell00028 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell00028.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell00029 = new PdfPCell(new Paragraph("Minutes of the meetings of student redressal\r\n"
					+ "committee, prevention of sexual harassment\r\n" + "committee and Anti Ragging committee",font5));
			
			cell00029.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell00030 = new PdfPCell(
					new Paragraph((criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : ""),font5));
			cell00030.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00030.setExtraParagraphSpace(10F);
			
			PdfPCell cell00031 = new PdfPCell(new Paragraph("Details of student grievances including sexual\r\n"
					+ "harassment and ragging cases\r\n" + "\r\n",font5));
			cell00031.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell00032 = new PdfPCell(
					new Paragraph((criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : ""),font5));
			
			cell00032.setExtraParagraphSpace(10f);	
			cell00032.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell000311 = new PdfPCell(new Paragraph(
					"Link for additional information\r\n" + "harassment and ragging cases\r\n" ,font5));
			
			cell000311.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell000321 = new PdfPCell(
					new Paragraph((criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : ""),font5));
			cell000321.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell000321.setExtraParagraphSpace(10f);	
			
			table04criteria5.addCell(cell00027);
			table04criteria5.addCell(cell00028);
			table04criteria5.addCell(cell00029);
			table04criteria5.addCell(cell00030);
			table04criteria5.addCell(cell00031);
			table04criteria5.addCell(cell00032);
			table04criteria5.addCell(cell000311);
			table04criteria5.addCell(cell000321);

			PdfPCell cell0006 = new PdfPCell(new Paragraph(
					"5.1.4 The institution adopts the following for redressal of student grievances including sexual\r\n"
							+ "harassment and ragging cases 1. Implementation of guidelines of statutory/regulatory bodies\r\n"
							+ "2. Organisation wide awareness and undertakings on policies with zero tolerance\r\n"
							+ "3. Mechanisms for submission of online/offline students’ grievances\r\n"
							+ "4. Timely redressal of the grievances through appropriate committees\r\n" + "Response:"
							+ (criteria5Record != null
									? criteria5Record.getCriteria51Qn().get(0).getResponse514()
									: ""),
					font4));
			cell0006.setExtraParagraphSpace(10f);	

			PdfPCell cell0007 = new PdfPCell(new Paragraph(
					"5.1.4.1 Number of students benefitted by guidance for competitive examinations and career counselling offered by the institution year wise during last five years",
					font4));
			
			cell0007.setExtraParagraphSpace(10f);	
			table41criteria5.addCell(cell0006);
		//	table41criteria5.addCell(cell0007);





			document.add(table41criteria5);
			
			
			table04criteria5.setSpacingBefore(20f);
			table04criteria5.setSpacingAfter(20f);
			
	//		document.add(table04criteria5);
		//	

			// 5.2

			Paragraph paragraph03 = new Paragraph("5.2	Student Progression\r\n", font2);
			paragraph03.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			paragraph03.setSpacingAfter(5f);
			document.add(paragraph03);

			PdfPTable table06criteria5 = new PdfPTable(2);
			PdfPTable table061 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table06criteria5.setWidthPercentage(100);
			table061.setWidthPercentage(100);

			PdfPCell cell00043 = new PdfPCell(new Paragraph("FileDescription\r\n", font4));
			cell00043.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00044 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell00044.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell00045 = new PdfPCell(new Paragraph("Upload any additional information\r\n",font5));
			cell00045.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell00046 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell00046.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00046.setExtraParagraphSpace(10f);	
			
			
			PdfPCell cell00047 = new PdfPCell(new Paragraph("Self attested list of students placed\r\n\r\n\r\n",font5));
			cell00047.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell00048 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell00048.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00048.setExtraParagraphSpace(10f);	
			PdfPCell cell00049 = new PdfPCell(
					new Paragraph("Details of student placement during the last five years\r\n\r\n\r\n",font5));
			cell00049.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell00050 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell00050.setExtraParagraphSpace(10f);	
			cell00050.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table06criteria5.addCell(cell00043);
			table06criteria5.addCell(cell00044);
			table06criteria5.addCell(cell00045);
			table06criteria5.addCell(cell00046);
			table06criteria5.addCell(cell00047);
			table06criteria5.addCell(cell00048);
			table06criteria5.addCell(cell00049);
			table06criteria5.addCell(cell00050);
			
    		
      		table06criteria5.setSpacingBefore(20f);
      		table06criteria5.setSpacingAfter(20f);
			
      		
    		document.add(table06criteria5);
    		
    		
			
			PdfPTable table0000061 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table0000061.setWidthPercentage(100);
			

			PdfPCell cell0004711 = new PdfPCell(new Paragraph(
					"5.2.1 Percentage of placement of outgoing students during the last five \r\n"
					+ "years\r\n" + "Response: ",font4));
			
			cell0004711.setExtraParagraphSpace(10);
			table0000061.addCell(cell0004711);
			
			

			if (criteria5Record.getCriteria51Qn() != null) {
				PdfPCell cell00014711 = new PdfPCell(new Paragraph(criteria5Record != null
						? criteria5Record.getCriteria52Qn().get(0).getResponse521()
						: "",font4));
				cell00014711.setExtraParagraphSpace(10f);	
				
				table0000061.addCell(cell00014711);
			}

			
			
			PdfPCell cell0001471111 = new PdfPCell( new Paragraph(
					"5.2.1.1  Number of outgoing students placed year wise during the last \r\n"
					+ "five years",
					font4));
			
			cell0001471111.setExtraParagraphSpace(10f);	
			table0000061.addCell(cell0001471111);
			
			document.add(table0000061);
			

			if (criteria5Record.getYearTable5211() != null) {
				Table table5211 = new Table(criteria5Record.getYearTable5211().size() + 1, 2);

				table5211.setPadding(5);
				table5211.setWidth(100f);
				table5211.addCell("year");
				for (int i = 0; i < criteria5Record.getYearTable5211().size(); i++) {
					Cell cell7=new Cell(new Paragraph((criteria5Record.getYearTable5211().get(i).getInput5211y()),font5));
					cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5211.addCell(cell7);
				}
				table5211.addCell("Number");
				for (int i = 0; i < criteria5Record.getYearTable5211().size(); i++) {
					Cell cell8=new Cell(new Paragraph((criteria5Record.getYearTable5211().get(i).getInput5211v()),font5));
					cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5211.addCell(cell8);
				}

				document.add(table5211);
			}
			
			
			PdfPTable table0000062 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table0000062.setWidthPercentage(100);
			
			

			PdfPCell cell00014711111 = new PdfPCell( new Paragraph(
					"5.2.1.2 Number of students appearing in state/ national/ international level examinations (eg:\r\n"
							+ "IIT/JAM/ NET / SLET/ GATE/ GMAT/CAT,GRE/ TOEFL/ Civil Services/ State government\r\n"
							+ "examinations) year-wise during last five years",font4));
			cell00014711111.setExtraParagraphSpace(10f);	
	//		table0000062.addCell(cell00014711111);
			table0000062.setSpacingBefore(20F);
			document.add(table0000062);
			
//			Paragraph paragraph4 = new Paragraph(criteria5Fieldinfo != null ? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getInput5212t1()
//									: "");
//			document.add(paragraph4);

			
			
			
			if (criteria5Record.getYearTable52112() != null) {
				Table table5211 = new Table(criteria5Record.getYearTable52112().size() + 1, 2);

				table5211.setPadding(5);
				table5211.setWidth(100f);
				table5211.addCell("year");
				for (int i = 0; i < criteria5Record.getYearTable52112().size(); i++) {
					Cell cell9=new Cell(new Paragraph((criteria5Record.getYearTable52112().get(i).getInput52112y()),font5));
					cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5211.addCell(cell9);
				}
				table5211.addCell("Number");
				for (int i = 0; i < criteria5Record.getYearTable52112().size(); i++) {
					Cell cell10=new Cell(new Paragraph((criteria5Record.getYearTable52112().get(i).getInput52112v()),font5));
					cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5211.addCell(cell10);
				}

			//	document.add(table5211);
			}

			Paragraph paragraph511 = new Paragraph("\r\n");
			document.add(paragraph511);

//			table061.addCell(cell0112);

	//		table061.addCell(table06criteria5);

		
			
			

  
      		

			PdfPTable table07criteria5 = new PdfPTable(2);
		
			// Setting width of table, its columns and spacing
			table07criteria5.setWidthPercentage(100);


			PdfPCell cell51criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font4));
			cell51criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell52criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell52criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell53criteria5 = new PdfPCell(new Paragraph("Upload supporting data for student/alumni\r\n",font5));
			cell53criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell54criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell54criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell54criteria5.setExtraParagraphSpace(10f);	
			
			PdfPCell cell55criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n",font5));
			cell55criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell56criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell56criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell56criteria5.setExtraParagraphSpace(10f);	
			
			PdfPCell cell57criteria5 = new PdfPCell(new Paragraph(
					"Number of students qualifying in state/ national/ international level examinations during the last five years(Data Template)r\n",font5));
			cell57criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell58criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell58criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell58criteria5.setExtraParagraphSpace(10f);
			
			table07criteria5.addCell(cell51criteria5);
			table07criteria5.addCell(cell52criteria5);
			table07criteria5.addCell(cell53criteria5);
			table07criteria5.addCell(cell54criteria5);
			table07criteria5.addCell(cell55criteria5);
			table07criteria5.addCell(cell56criteria5);
			table07criteria5.addCell(cell57criteria5);
			table07criteria5.addCell(cell58criteria5);
			
			table07criteria5.setSpacingBefore(20f);
			table07criteria5.setSpacingAfter(20f);
			
	//		document.add(table07criteria5);

			
	/////////////////////////////------------------------------------------------------		
			
			PdfPTable table71criteria5 = new PdfPTable(1);
			table71criteria5.setWidthPercentage(100);
			
			
			PdfPCell cell57criteria511 = new PdfPCell (new Paragraph(
					"5.2.2 Percentage of graduated students who have progressed to higher \r\n"
					+ "education year-wise during last five years\r\n"
							+ "Response:",font4));

			table71criteria5.addCell(cell57criteria511);
			
			

			if (criteria5Record.getCriteria51Qn() != null) {
				PdfPCell cell57criteria5101 = new PdfPCell(new Paragraph(criteria5Record != null
						? criteria5Record.getCriteria52Qn().get(0).getResponse522()
						: "",font4));
				
				cell57criteria5101.setExtraParagraphSpace(5);
				table71criteria5.addCell(cell57criteria5101);

			}

			PdfPCell cell5711criteria5101 = new PdfPCell(new Paragraph(
					"5.2.2.1  Number of outgoing students progressing to higher education.",font4));
			
			cell5711criteria5101.setExtraParagraphSpace(10);
			table71criteria5.addCell(cell5711criteria5101);
			
			document.add(table71criteria5);
			

			Paragraph paragraph51 = new Paragraph("\r\n");
			document.add(paragraph51);

			if (criteria5Record.getUniversityYearTable5221().size()>0) {
				Table table5221 = new Table(criteria5Record.getUniversityYearTable5221().size(), 2);

				table5221.setPadding(5);
				table5221.setWidth(100f);

				for (int i = 0; i < criteria5Record.getUniversityYearTable5221().size(); i++) {
					Cell cell11=new Cell(new Paragraph(criteria5Record.getUniversityYearTable5221().get(i).getInput5221y(),font5));
					cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5221.addCell(cell11);
				}
				for (int i = 0; i < criteria5Record.getUniversityYearTable5221().size(); i++) {
					Cell cell12=new Cell(new Paragraph(criteria5Record.getUniversityYearTable5221().get(i).getInput5221v(),font5));
					cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5221.addCell(cell12);
				}

				document.add(table5221);
			}

			if (criteria5Record.getUniversityYearTable5221().size()>0) {
				Table table5221 = new Table(criteria5Record.getUniversityYearTable5221().size(), 2);

				table5221.setPadding(5);
				table5221.setWidth(100f);

				for (int i = 0; i < criteria5Record.getUniversityYearTable5221().size(); i++) {
					Cell cell13=new Cell(new Paragraph(criteria5Record.getUniversityYearTable5221().get(i).getInput5221y(),font5));
					cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5221.addCell(cell13);
				}
				for (int i = 0; i < criteria5Record.getUniversityYearTable5221().size(); i++) {
					Cell cell14=new Cell(new Paragraph(criteria5Record.getUniversityYearTable5221().get(i).getInput5221v(),font5));
					cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5221.addCell(cell14);
				}

			//	document.add(table5221);
			}

//			table71criteria5.addCell(cell0111);
//			table71criteria5.addCell(cell01121);
//			
			table71criteria5.addCell(table07criteria5);

			table71criteria5.setSpacingBefore(20f);
			table71criteria5.setSpacingAfter(20f);

//			document.add(table71criteria5);

			PdfPTable table08criteria5 = new PdfPTable(2);
//			PdfPTable table81criteria5 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table08criteria5.setWidthPercentage(100);
//			table81criteria5.setWidthPercentage(100);

			PdfPCell cell59criteria5 = new PdfPCell(new Paragraph("FileDescription", font4));
			cell59criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell60criteria5 = new PdfPCell(new Paragraph("Document", font4));
			cell60criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell61criteria5 = new PdfPCell(new Paragraph("Self attested list of students placed\r\n", font5));
			cell61criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell62criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "", font5));
			cell62criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell62criteria5.setExtraParagraphSpace(10);
			PdfPCell cell63criteria5 = new PdfPCell(new Paragraph("Upload any additional information\r\n", font5));
			cell63criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell64criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "", font5));
			cell64criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell64criteria5.setExtraParagraphSpace(10);
			
			
			PdfPCell cell65criteria5 = new PdfPCell(
					new Paragraph("Details of student placement during the last five years(Data Template)   ", font5));
			cell65criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell66criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "", font5));
			cell66criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell66criteria5.setExtraParagraphSpace(10);
			
			cell66criteria5.setExtraParagraphSpace(10F);
			
			table08criteria5.addCell(cell59criteria5);
			table08criteria5.addCell(cell60criteria5);
			table08criteria5.addCell(cell61criteria5);
			table08criteria5.addCell(cell62criteria5);
			table08criteria5.addCell(cell63criteria5);
			table08criteria5.addCell(cell64criteria5);
			table08criteria5.addCell(cell65criteria5);
			table08criteria5.addCell(cell66criteria5);
			
			table08criteria5.setSpacingBefore(20f);
			table08criteria5.setSpacingAfter(20f);
			document.add(table08criteria5);

			
			PdfPTable table071criteria5 = new PdfPTable(1);
			table071criteria5.setWidthPercentage(100);
			
			
			PdfPCell cell5009criteria5 = new PdfPCell(new Paragraph(
					"5.2.3Percentage of students qualifying in state/National/International level \r\n"
					+ "Examination during last five years (eg. SLET, NET, UPSC etc)\r\n"
							+ "Response:" ,font4));
			
			cell5009criteria5.setExtraParagraphSpace(10);
			table071criteria5.addCell(cell5009criteria5);
			
			

			if (criteria5Record.getCriteria51Qn() != null) {
				PdfPCell cell5009criteria05 = new PdfPCell(new Paragraph(criteria5Record != null
						? criteria5Record.getCriteria52Qn().get(0).getResponse523()
						: "",font4));
				
				cell5009criteria05.setExtraParagraphSpace(10F);
				table071criteria5.addCell(cell5009criteria05);
			}

			PdfPCell cell5009criteria015 = new PdfPCell(new Paragraph(
					"5.2.3.1 Number of students qualifying in state/National/International \r\n"
					+ "level Examination during last five years (eg. SLET, NET, UPSC etc)"
					+ " (criteria5Record != null\r\n"
					+ "	? criteria5Record.getCriteria53Qn().get(0).getResponse531()\r\n"
					+ ": \"\"),\r\n"
				
					 ,font4));
			cell5009criteria015.setExtraParagraphSpace(10);
			
			table071criteria5.addCell(cell5009criteria015);
			
			document.add(table071criteria5);
			

			if (criteria5Record.getYearTable5231().size()>0) {
				Table table5221 = new Table(criteria5Record.getYearTable5231().size() + 1, 2);

				table5221.setPadding(5);
				table5221.setWidth(100f);
				table5221.addCell("year");
				for (int i = 0; i < criteria5Record.getYearTable5231().size(); i++) {
					Cell cell13=new Cell(new Paragraph(criteria5Record.getYearTable5231().get(i).getInput5231y(),font5));
					cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5221.addCell(cell13);

				}
				table5221.addCell("Number");
				for (int i = 0; i < criteria5Record.getYearTable5231().size(); i++) {
					Cell cell14=new Cell(new Paragraph(criteria5Record.getYearTable5231().get(i).getInput5231v(),font5));
					cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
					table5221.addCell(cell14);
				}

		//		document.add(table5221);
			}

			Paragraph paragraph512 = new Paragraph("\r\n");
			document.add(paragraph512);

			PdfPTable table081criteria5 = new PdfPTable(2);
			table081criteria5.setWidthPercentage(100);

			PdfPCell cell591criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font4));
			cell591criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell601criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell601criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell611criteria5 = new PdfPCell(new Paragraph("Self attested list of students placed\r\n",font5));
			cell611criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell621criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell621criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell621criteria5.setExtraParagraphSpace(10);
			
			
			PdfPCell cell631criteria5 = new PdfPCell(new Paragraph("Upload any additional information\r\n",font5));
			cell631criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell641criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell641criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell641criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell651criteria5 = new PdfPCell(
					new Paragraph("Details of student placement during the last five years(Data Template)   ",font5));
			cell651criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell661criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
	
			
			cell661criteria5.setExtraParagraphSpace(10F);

			cell661criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table081criteria5.addCell(cell591criteria5);
			table081criteria5.addCell(cell601criteria5);
			table081criteria5.addCell(cell611criteria5);
			table081criteria5.addCell(cell621criteria5);
			table081criteria5.addCell(cell631criteria5);
			table081criteria5.addCell(cell641criteria5);
			table081criteria5.addCell(cell651criteria5);
			table081criteria5.addCell(cell661criteria5);
			
			table081criteria5.setSpacingAfter(20f);
			table081criteria5.setSpacingAfter(20f);
			
		//	document.add(table081criteria5);
			
			// 5.3 
			Paragraph paragraph04 = new Paragraph("5.3 Student Participation and Activities\r\n", font2);
			paragraph04.setAlignment(Paragraph.ALIGN_LEFT);

			document.add(paragraph04);
			
			
			PdfPTable table91criteria5 = new PdfPTable(1);	
			table91criteria5.setWidthPercentage(100);
			
			
			PdfPCell cell0116 = new PdfPCell(new Paragraph(
					"5.3.1Number of awards/medals won by students for outstanding performance \r\n"
					+ "in sports/cultural activities at inter-university/state/national/international \r\n"
					+ "events (award for a team event should be counted as one) during the last \r\n"
					+ "five years.\r\n"
							+ "Response:"
							+ (criteria5Record != null
									? criteria5Record.getCriteria53Qn().get(0).getResponse531()
									: ""),
					font4));
			cell0116.setExtraParagraphSpace(10f);
			
			PdfPCell cell0117 = new PdfPCell(new Paragraph(
					"5.3.1.1 Number of awards/medals won by students for outstanding \r\n"
					+ "performance in sports/cultural activities at inter-university/state/ \r\n"
					+ "national/international level (award for a team event should be counted as \r\n"
					+ "one) year-wise during the last five years.",
					font4));
			
			cell0117.setExtraParagraphSpace(10f);

			table91criteria5.addCell(cell0116);
			
			
			table91criteria5.addCell(cell0117);
			table91criteria5.setSpacingBefore(20f);
			table91criteria5.setSpacingAfter(20f);

			document.add(table91criteria5);
			
			
			
			if(criteria5Record.getYearTable5311().size()>0)
			{
						Table table5311 = new Table(criteria5Record.getYearTable5311().size(), 2);
			
						table5311.setPadding(5);
						table5311.setWidth(100f);
			
						for (int i = 0; i < criteria5Record.getYearTable5311().size(); i++) {
							Cell cell113=new Cell(new Paragraph(criteria5Record.getYearTable5311().get(i).getInput5311y(),font5));
							cell113.setHorizontalAlignment(Element.ALIGN_CENTER);
							table5311.addCell(cell113);
			
						}
						for (int i = 0; i < criteria5Record.getYearTable5311().size(); i++) {
							Cell cell114=new Cell(new Paragraph(criteria5Record.getYearTable5311().get(i).getInput5311v(),font5));
							cell114.setHorizontalAlignment(Element.ALIGN_CENTER);
							table5311.addCell(cell114);
							
			
						}
			
						document.add(table5311);
						
					}	
			
			

			PdfPTable table09criteria5 = new PdfPTable(2);
			table09criteria5.setWidthPercentage(100);
		

			PdfPCell cell67criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font4)); cell67criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell68criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell68criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell69criteria5 = new PdfPCell(new Paragraph(
					                                                "e-copies of award letters and certificates",font5));
			
			cell69criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell70criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell70criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell70criteria5.setExtraParagraphSpace(10F);
			
			PdfPCell cell71criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n",font5));
			
			cell71criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell72criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell72criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell72criteria5.setExtraParagraphSpace(10F);
			
			PdfPCell cell73criteria5 = new PdfPCell(new Paragraph("Number of awards/medals for outstanding performance in sports/ cultural activities at inter-university / state / national / international level during the last five years(Data Template)",font5));
			cell73criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);

			
			PdfPCell cell74criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			
			cell74criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell74criteria5.setExtraParagraphSpace(10F);
		
			
			table09criteria5.addCell(cell67criteria5);
			table09criteria5.addCell(cell68criteria5);
			table09criteria5.addCell(cell69criteria5);
			table09criteria5.addCell(cell70criteria5);
			table09criteria5.addCell(cell71criteria5);
			table09criteria5.addCell(cell72criteria5);
			table09criteria5.addCell(cell73criteria5);
			table09criteria5.addCell(cell74criteria5);
			
			table09criteria5.setSpacingAfter(20f);
		
			table09criteria5.setSpacingBefore(20f);

			document.add(table09criteria5)	;	
			
			
			
			
			
			PdfPTable table101criteria5 = new PdfPTable(1);
			
			table101criteria5.setWidthPercentage(100);
			
			
			if(criteria5Record.getCriteria53Qn() !=null)
			{
				
			PdfPCell cell0119 = new PdfPCell(new Paragraph(
					
					"5.3.2 Presence of Student Council and its activities for institutional \r\n"
					+ "development and student welfare. \r\n"
						+ "Response:"
							+ (criteria5Record != null
									? criteria5Record.getCriteria53Qn().get(0).getResponse532()
									: ""),
					font4));
			cell0119.setExtraParagraphSpace(10F);
			
			
			table101criteria5.addCell(cell0119);
			}
			
		
			document.add(table101criteria5);
			
			PdfPTable table010criteria5 = new PdfPTable(2);
			
			table010criteria5.setWidthPercentage(100);
			

			PdfPCell cell75criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font4));
			cell75criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell76criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell76criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell77criteria5 = new PdfPCell(new Paragraph("Paste link for Additional Information",font5));
			cell77criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell78criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell78criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell78criteria5.setExtraParagraphSpace(10F);
		
			
			PdfPCell cell77criteria51 = new PdfPCell(new Paragraph("Upload any Additional Information",font5));
			cell77criteria51.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell78criteria51 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell78criteria51.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell78criteria51.setExtraParagraphSpace(10F);

			table010criteria5.addCell(cell75criteria5);
			table010criteria5.addCell(cell76criteria5);
			table010criteria5.addCell(cell77criteria5);
			table010criteria5.addCell(cell78criteria5);	
			table010criteria5.addCell(cell77criteria51);
			table010criteria5.addCell(cell78criteria51);	
			
			table010criteria5.setSpacingAfter(20f);
			
			table010criteria5.setSpacingBefore(20f);
			
			document.add(table010criteria5);
			
			
			
			PdfPTable table121criteria5 = new PdfPTable(1);		
			
			table121criteria5.setWidthPercentage(100);
			
			PdfPCell cell0121 = new PdfPCell(new Paragraph(
					"5.3.3 The institution conducts /organizes following activities\r\n"
					+ "1. Sports competitions/events\r\n"
					+ "2.Cultural competitions/events\r\n"
					+ "3. Technical fest/academic fests\r\n"
					+ "4. Any other events through active clubs and forums\r\n"
					+ "Options:\r\n"
					+ "A. All four of the above\r\n"
					+ "B. Any three of the above\r\n"
					+ "C. Any two of the above\r\n"
					+ "D. Any one of the above\r\n"
					+ "E. None of the above\r\n"
							+ "\r\n" + "Response: "
							+ (criteria5Record != null
									? criteria5Record.getCriteria53Qn().get(0).getResponse533()
									: ""),
					font4));
			
			cell0121.setExtraParagraphSpace(10F);
			PdfPCell cell0122 = new PdfPCell(new Paragraph(
					"5.3.3.1 Number of sports and cultural events / competitions organised by the institution year - wise during the last five years.",
					font4));
			
			
			cell0122.setExtraParagraphSpace(10f);
			table121criteria5.addCell(cell0121);
		//	table121criteria5.addCell(cell0122);

			document.add(table121criteria5);	
			
			
			if(criteria5Record.getYearTable5331().size()>0)
			{
			Table table5331 = new Table(criteria5Record.getYearTable5331().size(), 2);

			table5331.setPadding(5);
			table5331.setWidth(100f);

			for (int i = 0; i < criteria5Record.getYearTable5331().size(); i++) {
				Cell cell15=new Cell(new Paragraph(criteria5Record.getYearTable5331().get(i).getInput5331y(),font5));
				cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
				table5331.addCell(cell15);
				
				
			}
			for (int i = 0; i < criteria5Record.getYearTable5331().size(); i++) {
				Cell cell17=new Cell(new Paragraph(criteria5Record.getYearTable5331().get(i).getInput5331v(),font5));

				cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
				table5331.addCell(cell17);
				
			}

		//	document.add(table5331);
			
			}
			
			PdfPTable table012criteria5 = new PdfPTable(2);
		

			// Setting width of table, its columns and spacing
			table012criteria5.setWidthPercentage(100);
		

			PdfPCell cell81criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
			cell81criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell82criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell82criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell85criteria5 = new PdfPCell(new Paragraph("Report of the event",font5));
			cell85criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell86criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			
			cell86criteria5.setExtraParagraphSpace(10F);
			cell86criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell87criteria5 = new PdfPCell(
					new Paragraph("Upload any additional information\r\n\r\n\r\n",font5));
			cell87criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell88criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell88criteria5.setExtraParagraphSpace(10F);
			cell88criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell871criteria5 = new PdfPCell(
					new Paragraph("Number of sports and cultural events / competitions organised per year (Data Template",font5));
			cell871criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell881criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell881criteria5.setExtraParagraphSpace(10F);
			cell881criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table012criteria5.addCell(cell81criteria5);
			table012criteria5.addCell(cell82criteria5);
		
			table012criteria5.addCell(cell85criteria5);
			table012criteria5.addCell(cell86criteria5);
			table012criteria5.addCell(cell87criteria5);
			table012criteria5.addCell(cell88criteria5);
			table012criteria5.addCell(cell871criteria5);
			table012criteria5.addCell(cell881criteria5);
			table012criteria5.setSpacingAfter(20f);
			table012criteria5.setSpacingBefore(20f);
	         document.add(table012criteria5);
	       
	       // 5.4 
	       Paragraph paragraph05 = new Paragraph("5.4 Alumni Engagement\r\n\r\n\r\n", font2);
	       paragraph05.setSpacingAfter(5f);
			paragraph05.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph05);
			

			PdfPTable table131 = new PdfPTable(1);
			table131.setWidthPercentage(100);
			if( criteria5Record.getCriteria54Ql() !=null)
			{
			
			PdfPCell cell0244 = new PdfPCell(new Paragraph(
					"5.4.1 The Alumni Association / Chapters (registered and functional) contributes significantly to the development of the institution through financial and other support services.\r\n"
			+ "Response:"
							+ (criteria5Record != null
									? criteria5Record.getCriteria54Ql().get(0).getResponse541()
									: ""),
					font4));
			cell0244.setExtraParagraphSpace(10F);
			
			table131.addCell(cell0244);
	
			document.add(table131);
			}
	

			PdfPTable table013 = new PdfPTable(2);
			table013.setWidthPercentage(100);
		

			PdfPCell cell89criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
			cell89criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell90criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell90criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell91criteria5 = new PdfPCell(new Paragraph("Paste link for Additional Information",font5));
			cell91criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell92criteria5 = new PdfPCell(new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell92criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell92criteria5.setExtraParagraphSpace(10);
			
			PdfPCell cell93criteria5 = new PdfPCell(new Paragraph("Upload any Additional Informatio",font5));
			cell93criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell94criteria5 = new PdfPCell(new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell94criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell94criteria5.setExtraParagraphSpace(10);
			
			
			
			table013.addCell(cell89criteria5);
			table013.addCell(cell90criteria5);
			table013.addCell(cell91criteria5);
			table013.addCell(cell92criteria5);
			table013.addCell(cell93criteria5);
			table013.addCell(cell94criteria5);
			table013.setSpacingAfter(20f);
			table013.setSpacingBefore(20f);

			document.add(table013);
			
	

			
			PdfPTable table0141 = new PdfPTable(1);
			table0141.setWidthPercentage(100);
			if(criteria5Record.getCriteria51Qn() !=null)
			{
			PdfPCell cell0266 = new PdfPCell(new Paragraph(
					"5.4.2 Alumni contributes and engages significantly to the development of \r\n"
					+ "University through academic and other support system\r\n"
					+ "Response:"
							+ (criteria5Record != null
									? criteria5Record.getCriteria54Ql().get(0).getResponse542()
									: ""),
					font4));
			
			cell0266.setExtraParagraphSpace(10);
			
			table0141.addCell(cell0266);
			


			document.add(table0141);
			}
			
			
			PdfPTable table014 = new PdfPTable(2);
			table014.setWidthPercentage(100);
		

			
			
			PdfPCell cell891criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n", font4));
			cell891criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell902criteria5 = new PdfPCell(new Paragraph("Document\r\n", font4));
			cell902criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell913criteria5 = new PdfPCell(new Paragraph("Upload any Additional Information\r\n",font5));
			cell913criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell924criteria5 = new PdfPCell(
					new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell924criteria5.setExtraParagraphSpace(10F);
			
			cell924criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell935criteria5 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n",font5));
			cell935criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell946criteria5 = new PdfPCell(new Paragraph(criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : "",font5));
			cell946criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell946criteria5.setExtraParagraphSpace(10F);
			
			
			table014.addCell(cell891criteria5);
			table014.addCell(cell902criteria5);
			table014.addCell(cell913criteria5);
			table014.addCell(cell924criteria5);
			
			table014.addCell(cell935criteria5);
			table014.addCell(cell946criteria5);
			
			table014.setSpacingAfter(20f);
			table014.setSpacingBefore(20f);
			
		    document.add(table014);
			
			

			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
