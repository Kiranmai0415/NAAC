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
import org.springframework.stereotype.Component;

import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria1_FileUpload;
import com.adiverse.erp.service.Criteria1Service;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class AuthonomousCriteria12Report2 {
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;

	public Image headerImage;

	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
	
	@Autowired
	Criteria1Service service1;

	List<Criteria1_FieldInfo> criteria1List = null;
	Criteria1_FieldInfo criteria1Record = null;
	List<Criteria1_FileUpload> criteria1file = null;

	
public String generateReport(Criteria1_FieldInfo criteria1Fieldinfo) throws DocumentException, IOException {
	//public String generateReport()throws DocumentException, IOException {
	
	String reportPath = "";
		Path root = Paths.get(reportGeneratePath);
		Path file = null;
		Date date = new Date();
		try {
			font1.setSize(16);
			font2.setSize(14);
			font3.setSize(12);
			font4.setSize(14);
			font5.setSize(12);

			Map<String, String> allParams = new HashMap<String, String>();
			allParams.put("", reportPath);
			criteria1List = service1.getAllCriteria1Data();
			if (CollectionUtils.isNotEmpty(criteria1List)) {
				criteria1Record = criteria1List.get(0);
				
				criteria1file = criteria1Record.getCriteria1FileUpload();
			} else {
				criteria1Record = new Criteria1_FieldInfo();
				criteria1file = new ArrayList<Criteria1_FileUpload>();
			}
//			System.out.println(criteria1List.get(0).getCriteria1FieldInfoQl());
//			System.out.println(criteria1List.get(0).getCriteria1FieldInfoQn());
//			System.out.println(criteria1List.get(0).getCriteria1FileUpload());
//			System.out.println(criteria1List.get(0).getYearTable1131());
			
			
			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AuthonomousCriteria1Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
			
/////////////////////////////////////////////////////////////////////////////////
///////////////////// criteria 1 starts hear.....
////////////////////////////////////////////////////////////////////////////////

///
			
			
Paragraph paragraph43 = new Paragraph("1.2 Academic Flexibility\r\n", font2);
paragraph43.setAlignment(Paragraph.ALIGN_JUSTIFIED);
paragraph43.setAlignment(Paragraph.ALIGN_CENTER);

document.add(paragraph43);



Paragraph paragraph431 = new Paragraph("\r\n");
document.add(paragraph431);

Paragraph paragraph432 = new Paragraph(
		"1.2.1: Percentage of new courses introduced of the total number of courses across all programs offered during the last five years.\r\n");
document.add(paragraph432);


//Paragraph paragraph433 = new Paragraph("1.2.1.1: How many new courses are introduced within the last five years.\r\n"
//				+ (criteria1Fieldinfo != null
//						? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1121t1()
//						: ""));
//document.add(paragraph433);
				

//Paragraph paragraph434 = new Paragraph("1.2.1.2: Number of courses offered by the institution across all programmes during the last five years.\r\n"
//				+ (criteria1Fieldinfo != null
//						? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1122t1()
//						: ""));
//document.add(paragraph434);

PdfPTable table4 = new PdfPTable(2);
table4.setWidthPercentage(100);



Paragraph paragraph439= new Paragraph( "\r\n");
document.add(paragraph439);

PdfPCell cell411 = new PdfPCell(new Paragraph("FileDiscription\r\n", font3));
PdfPCell cell412 = new PdfPCell(new Paragraph("Document\r\n", font3));
PdfPCell cell413 = new PdfPCell(new Paragraph("Minutes of relevant Academic Council/BOS meetings\r\n"));
PdfPCell cell414 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
PdfPCell cell415 = new PdfPCell(new Paragraph("Institutional data in prescribed format"));
PdfPCell cell416 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
PdfPCell cell417 = new PdfPCell(new Paragraph("Any additional information"));
PdfPCell cell418 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));

table4.addCell(cell411);
table4.addCell(cell412);
table4.addCell(cell413);
table4.addCell(cell414);
table4.addCell(cell415);
table4.addCell(cell416);
table4.addCell(cell417);
table4.addCell(cell418);



document.add(table4);

Paragraph paragraph4391= new Paragraph( "\r\n");
document.add(paragraph4391);





PdfPTable table5 = new PdfPTable(2);
table5.setWidthPercentage(100);
/*
* com.lowagie.text.Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
* font5.setColor(CMYKColor.BLACK);
*/

PdfPTable table5a = new PdfPTable(1);
table5a.setWidthPercentage(100);
/*
* com.lowagie.text.Font font5a = FontFactory.getFont(FontFactory.TIMES_ROMAN);
* font5a.setColor(CMYKColor.BLACK)
*/




//Paragraph paragraph435 = new Paragraph(
//		"1.2.2: Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year).\r\n"
//				+(criteria1Fieldinfo != null
//				? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse122()
//				: ""));
//document.add(paragraph435);
//
//Paragraph paragraph436 = new Paragraph( "1.2.2.1: Number of Programmes in which CBCS / Elective course system implemented.\r\n"
//				+ (criteria1Fieldinfo != null
//						? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1221t1()
//						: ""));
//document.add(paragraph436);
//
//Paragraph paragraph437 = new Paragraph( "1.2.2.1: Total number of Programmes offered\r\n"
//				+ (criteria1Fieldinfo != null
//						? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput122t1()
//						: ""));
//
//document.add(paragraph437);

Paragraph paragraph438= new Paragraph( "\r\n");
document.add(paragraph438);

PdfPCell cell511 = new PdfPCell(new Paragraph("FileDiscription\r\n", font3));
PdfPCell cell512 = new PdfPCell(new Paragraph("Document\r\n", font3));
PdfPCell cell513 = new PdfPCell(new Paragraph("Minutes of relevant Academic Council/BOS meetings"));
PdfPCell cell514 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
PdfPCell cell515 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n"));
PdfPCell cell516 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
PdfPCell cell517 = new PdfPCell(new Paragraph("Any additional information\r\n"));
PdfPCell cell518 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
PdfPCell cell519 = new PdfPCell(new Paragraph("Link for Additional Information\r\n"));
PdfPCell cell520 = new PdfPCell(new Paragraph(""));
// 3.1

/*
* com.lowagie.text.Font fontTitle54 =
* FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle54.setSize(16);
*/



table5.addCell(cell511);
table5.addCell(cell512);
table5.addCell(cell513);
table5.addCell(cell514);
table5.addCell(cell515);
table5.addCell(cell516);
table5.addCell(cell517);
table5.addCell(cell518);
table5.addCell(cell519);
table5.addCell(cell520);

document.add(table5);
document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}


////////////////////////////////////////////////////
///////////////////criteria 1 end..............
/////////////////////////////////////////

}


