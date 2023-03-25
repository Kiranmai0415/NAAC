package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria1_FileUpload;
import com.adiverse.erp.service.Criteria1Service;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class AuthonomousCriteria13Report2 {
	
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

	
public String generateReport(  Criteria1_FieldInfo criteria1Fieldinfo) throws DocumentException, IOException {
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
			System.out.println(criteria1List.get(0).getCriteria1FileUpload());
			System.out.println(criteria1List.get(0).getYearTable1131());
			
			
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


Paragraph paragraph54 = new Paragraph("1.3 Curriculum Enrichment\r\n\r\n", font3);
paragraph54.setAlignment(Paragraph.ALIGN_JUSTIFIED);
paragraph54.setAlignment(Paragraph.ALIGN_CENTER);

// create table6
document.add(paragraph54);
PdfPTable table6 = new PdfPTable(2);
table6.setWidthPercentage(100);
/*
* com.lowagie.text.Font font6 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
* font6.setColor(CMYKColor.BLACK);
*/

PdfPTable table61 = new PdfPTable(1);
table61.setWidthPercentage(100);
/*
* com.lowagie.text.Font font61 =
* FontFactory.getFont(FontFactory.HELVETICA_BOLD);
* font61.setColor(CMYKColor.BLACK);
*/


Paragraph paragraph55 = new Paragraph(
		"1.3.1: Institution integrates crosscutting issues relevant to Professional Ethics ,Gender, Human Values ,Environment and Sustainability into the Curriculum\r\n"+"Response\t"	);
	document.add(paragraph55);
	
//	Paragraph paragraph56 = new Paragraph(criteria1Fieldinfo != null
//						? criteria1Fieldinfo.getCriteria1FieldInfoQl().get(0).getResponse131()
//						: "");
//
//document.add(paragraph56);
Paragraph paragraph57 = new Paragraph("\r\n");
document.add(paragraph57);

PdfPCell cell611 = new PdfPCell(new Paragraph("FileDiscription\r\n", font3));
PdfPCell cell612 = new PdfPCell(new Paragraph("Document\r\n", font3));
PdfPCell cell613 = new PdfPCell(new Paragraph(
"Upload the list and description of the courses which address the Gender, Environment and Sustainability, Human Values and Professional Ethics into the Curriculum\r\n"));
PdfPCell cell614 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
PdfPCell cell615 = new PdfPCell(new Paragraph("Any additional information\r\n"));
PdfPCell cell616 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));

table6.addCell(cell611);
table6.addCell(cell612);
table6.addCell(cell615);
table6.addCell(cell616);
table6.addCell(cell613);
table6.addCell(cell614);

document.add(table6);

Paragraph paragraph58 = new Paragraph("\r\n");
document.add(paragraph58);



// create table7
PdfPTable table7 = new PdfPTable(5);
table7.setWidthPercentage(100);
/*
* com.lowagie.text.Font font7 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
* font61.setColor(CMYKColor.BLACK);
*/
//PdfPTable table71 = new PdfPTable(5);
//table71.setWidthPercentage(100);
//
//PdfPCell cell71 = new PdfPCell(new Paragraph("2020-21"));
//PdfPCell cell72 = new PdfPCell(new Paragraph("2019-20"));
//PdfPCell cell73 = new PdfPCell(new Paragraph("2018-19"));
//PdfPCell cell74 = new PdfPCell(new Paragraph("2017-18"));
//PdfPCell cell75 = new PdfPCell(new Paragraph("2016-17"));
//PdfPCell cell76 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell77 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell78 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell79 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell80 = new PdfPCell(new Paragraph("  "));
//
//
//table7.addCell(cell71);
//table7.addCell(cell72);
//table7.addCell(cell73);
//table7.addCell(cell74);
//table7.addCell(cell75);
//table7.addCell(cell76);
//table7.addCell(cell77);
//table7.addCell(cell78);
//table7.addCell(cell79);
//table7.addCell(cell80);
//
//document.add(table7);

// create 8

PdfPTable table81 = new PdfPTable(1);
table81.setWidthPercentage(100);

/*
* com.lowagie.text.Font font81 =
* FontFactory.getFont(FontFactory.HELVETICA_BOLD);
* font81.setColor(CMYKColor.BLACK);
*/
//
//PdfPTable table82 = new PdfPTable(5);
//table82.setWidthPercentage(100);
///*
//* com.lowagie.text.Font font82 =
//* FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//* font82.setColor(CMYKColor.BLACK);
//*/
//// create table82
//PdfPCell cell821 = new PdfPCell(new Paragraph("2020-21"));
//PdfPCell cell822 = new PdfPCell(new Paragraph("2019-20"));
//PdfPCell cell823 = new PdfPCell(new Paragraph("2018-19"));
//PdfPCell cell824 = new PdfPCell(new Paragraph("2017-18"));
//PdfPCell cell825 = new PdfPCell(new Paragraph("2016-17"));
//PdfPCell cell826 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell827 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell828 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell829 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell8230 = new PdfPCell(new Paragraph("  "));
//
//table82.addCell(cell821);
//table82.addCell(cell822);
//table82.addCell(cell823);
//table82.addCell(cell824);
//table82.addCell(cell825);
//table82.addCell(cell826);
//table82.addCell(cell827);
//table82.addCell(cell828);
//table82.addCell(cell829);
//table82.addCell(cell8230);
//document.add(table82);

// create table8

PdfPTable table8 = new PdfPTable(2);
table8.setWidthPercentage(100);
/*
* com.lowagie.text.Font font8 =
* FontFactory.getFont(FontFactory.HELVETICA_BOLD);
* font8.setColor(CMYKColor.BLACK);
*/



PdfPTable table33= new PdfPTable(1);
table33.setWidthPercentage(100);
table33.addCell(
		"1.3.2: Number of value-added courses for imparting transferable and life skills offered during last five years.\r\n"
		+"\r\n"
		
		+"1.3.2.1: How many new value-added courses are added within the last five years\r\n"
		+ ""
		);


document.add(table33);

if(criteria1Fieldinfo.getYearTable1321()!=null )
{
Table table1131 = new Table(criteria1Fieldinfo.getYearTable1321().size(), 2);

table1131.setPadding(10);
table1131.setWidth(100f);

if(criteria1Fieldinfo!=null) {

for (int i = 0; i < criteria1Fieldinfo.getYearTable1321().size(); i++) {
	table1131.addCell(criteria1Fieldinfo.getYearTable1321().get(i).getInput1321y());
}
for (int i = 0; i < criteria1Fieldinfo.getYearTable1321().size(); i++) {
	table1131.addCell(criteria1Fieldinfo.getYearTable1321().get(i).getInput1321v());
}
}
document.add(table1131);
}



Paragraph paragraph59 = new Paragraph("\r\n");
document.add(paragraph59);

PdfPCell cell81 = new PdfPCell(new Paragraph("FileDiscription\r\n", font3));
PdfPCell cell82 = new PdfPCell(new Paragraph("Document\r\n", font3));
PdfPCell cell83 = new PdfPCell(new Paragraph("List of value added courses (Data Template)\r\n"));
PdfPCell cell84 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
PdfPCell cell85 = new PdfPCell(new Paragraph("Brochure or any other document relating to value added courses\r\n"));
PdfPCell cell86 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
PdfPCell cell87 = new PdfPCell(new Paragraph("Any additional information\r\n"));
PdfPCell cell88 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));



table8.addCell(cell81);
table8.addCell(cell82);
table8.addCell(cell83);
table8.addCell(cell84);
table8.addCell(cell85);
table8.addCell(cell86);
table8.addCell(cell87);
table8.addCell(cell88);
document.add(table8);
// create table9
//PdfPTable table9 = new PdfPTable(5);
//PdfPTable table91 = new PdfPTable(1);
//// PdfPTable table92=new PdfPTable(2);

//table9.setWidthPercentage(100);
//table91.setWidthPercentage(100);
//// table92.setWidthPercentage(100);
//
///*
//* com.lowagie.text.Font font9 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//* font9.setColor(CMYKColor.BLACK);
//*/
//PdfPCell cell91 = new PdfPCell(new Paragraph("2020-21"));
//PdfPCell cell92 = new PdfPCell(new Paragraph("2019-20"));
//PdfPCell cell93 = new PdfPCell(new Paragraph("2018-19"));
//PdfPCell cell94 = new PdfPCell(new Paragraph("2017-18"));
//PdfPCell cell95 = new PdfPCell(new Paragraph("2016-17"));
//PdfPCell cell96 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell97 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell98 = new PdfPCell(new Paragraph("  "));
//PdfPCell cell99 = new PdfPCell(new Paragraph(" "));
//PdfPCell cell100 = new PdfPCell(new Paragraph("  "));
//
//table9.addCell(cell91);
//table9.addCell(cell92);
//table9.addCell(cell93);
//table9.addCell(cell94);
//table9.addCell(cell95);
//table9.addCell(cell96);
//table9.addCell(cell97);
//table9.addCell(cell98);
//table9.addCell(cell99);
//table9.addCell(cell100);
//document.add(table9);


Paragraph paragraph511 = new Paragraph(
		"1.3.3.1: Number of students enrolled in subject related Certificate or Add-on programs year wise during last five years\r\n"
		+"\r\n"
		+"Response");
document.add(paragraph511);


//Paragraph paragraph512 = new Paragraph(criteria1Fieldinfo != null
//		               ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse133()
//			                                   	: "");
//document.add(paragraph512);
//		
Paragraph paragraph513= new Paragraph("1.3.3.1: Number of students enrolled in subject related Certificate or Add-on programs year wise during last five years\r\n"
		+ "\r\n"
		);


document.add(paragraph513);

Paragraph paragraph51= new Paragraph("\r\n");
document.add(paragraph51);

if(criteria1Fieldinfo.getYearTable1331()!=null )
{
Table table1131 = new Table(criteria1Fieldinfo.getYearTable1331().size(), 2);

table1131.setPadding(10);
table1131.setWidth(100f);

if(criteria1Fieldinfo!=null) {

for (int i = 0; i < criteria1Fieldinfo.getYearTable1331().size(); i++) {
	table1131.addCell(criteria1Fieldinfo.getYearTable1331().get(i).getInput1331y());
}
for (int i = 0; i < criteria1Fieldinfo.getYearTable1331().size(); i++) {
	table1131.addCell(criteria1Fieldinfo.getYearTable1331().get(i).getInput1331v());
}
}
document.add(table1131);
}

Paragraph paragraph522= new Paragraph(
		"1.3.3.1: Number of students enrolled in subject related Certificate or Add-on programs year wise during last five years.\r\n"
		+"\r\n"
	
		);



document.add(paragraph522);


if(criteria1Fieldinfo.getYearTable1331()!=null )
{
Table table1331 = new Table(criteria1Fieldinfo.getYearTable1331().size(), 2);

table1331.setPadding(10);
table1331.setWidth(100f);

if(criteria1Fieldinfo!=null) {

for (int i = 0; i < criteria1Fieldinfo.getYearTable1331().size(); i++) {
	table1331.addCell(criteria1Fieldinfo.getYearTable1331().get(i).getInput1331y());
}
for (int i = 0; i < criteria1Fieldinfo.getYearTable1331().size(); i++) {
	table1331.addCell(criteria1Fieldinfo.getYearTable1331().get(i).getInput1331v());
}
}
document.add(table1331);
}






Paragraph paragraph5221= new Paragraph("\r\n");
document.add(paragraph5221);




PdfPTable table92 = new PdfPTable(2);

table92.setWidthPercentage(100);

PdfPCell cell921 = new PdfPCell(new Paragraph("FileDiscription\r\n", font3));
PdfPCell cell922 = new PdfPCell(new Paragraph("Document\r\n", font3));
PdfPCell cell923 = new PdfPCell(new Paragraph("List of students enrolled\r\n"));
PdfPCell cell924 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
PdfPCell cell925 = new PdfPCell(new Paragraph("Any additional information\r\n"));
PdfPCell cell926 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
PdfPCell cell927 = new PdfPCell(new Paragraph("Link for Additional Information\r\n"));
PdfPCell cell928 = new PdfPCell(new Paragraph(""));

table92.addCell(cell921);
table92.addCell(cell922);
table92.addCell(cell923);
table92.addCell(cell924);
table92.addCell(cell925);
table92.addCell(cell926);
table92.addCell(cell927);
table92.addCell(cell928);



document.add(table92);



// create table10
PdfPTable table10 = new PdfPTable(2);
table10.setWidthPercentage(100);

//
//Paragraph paragraph52211= new Paragraph(
//		"1.3.4.1: Number of students undertaking field projects / internships / student projects.\r\n"
//		+"\r\n"
//				+ (criteria1Fieldinfo != null
//						? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse134(): ""));
//document.add(paragraph52211);
				

//Paragraph paragraph52212= new Paragraph( "1.3.4.1: Number of students undertaking field projects / internships / student projects.\r\n"
//				+ (criteria1Fieldinfo != null
//						? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1341t1()
//						: ""));
//document.add(paragraph52212);
//			
//Paragraph paragraph52213= new Paragraph("1.3.4.1: Total number of students\r\n"
//				+ (criteria1Fieldinfo != null
//						? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1341t1()
//						: ""));
//document.add(paragraph52213);

Paragraph paragraph52214= new Paragraph("\r\n");
document.add(paragraph52214);


PdfPTable table101 = new PdfPTable(1);
table101.setWidthPercentage(100);

PdfPCell cell101 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
PdfPCell cell102 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
PdfPCell cell103 = new PdfPCell(new Paragraph(
"List of programs and number of students undertaking field projects / internships / student projects (Data Template)"));
PdfPCell cell104 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
PdfPCell cell105 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
PdfPCell cell106 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));



table10.addCell(cell101);
table10.addCell(cell102);
table10.addCell(cell103);
table10.addCell(cell104);
table10.addCell(cell105);
table10.addCell(cell106);
document.add(table10);


/*
* com.lowagie.text.Font fontTitle67 =
* FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle67.setSize(16);
*/






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


