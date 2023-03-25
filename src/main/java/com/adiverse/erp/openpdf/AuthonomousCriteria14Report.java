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
public class AuthonomousCriteria14Report {
	
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

	
	public String generateReport( Criteria1_FieldInfo criteria1Fieldinfo) throws DocumentException, IOException {
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

/*
* Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
* fontTitle.setSize(16);
* 
* Font fontTitle1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
* fontTitle1.setSize(14);
* 
* Font fontTitle2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
* fontTitle2.setSize(12);
*/

Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
paragraph.setAlignment(Paragraph.ALIGN_CENTER);
document.add(paragraph);

Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font2);
paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
paragraph.setAlignment(Paragraph.ALIGN_CENTER);
document.add(paragraph1);


Paragraph paragraph67 = new Paragraph("1.4  Feedback System\r\n\r\n", font3);
paragraph67.setAlignment(Paragraph.ALIGN_LEFT);





	Paragraph paragraph11 = new Paragraph(
"1.4.1: Structured feedback for design and review of syllabus ( semester wise / year wise) is obtained from\r\n"+"Response\r\n");

	document.add(paragraph11);
	
//	if( criteria1Fieldinfo.getCriteria1FieldInfoQl()!=null)
//	{
//	Paragraph paragraph12 = new Paragraph(criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQl().get(0).getResponse141():"");
//
//document.add(paragraph12);
//}
	
	Paragraph paragraph16= new Paragraph("\r\n");
	document.add(paragraph16);

PdfPTable table1111 = new PdfPTable(2);
table1111.setWidthPercentage(100);

PdfPCell cell111 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
PdfPCell cell112 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
PdfPCell cell113 = new PdfPCell(new Paragraph("URL for stakeholder feedback report\r\n\r\n"));
PdfPCell cell114 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
PdfPCell cell115 = new PdfPCell(new Paragraph("Action taken report of the Institution on feedback report as minuted by the Governing Council,Syndicate, Board of Management\r\n\r\n"));
PdfPCell cell116 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
PdfPCell cell117 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
PdfPCell cell118 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));



table1111.addCell(cell111);
table1111.addCell(cell112);
table1111.addCell(cell113);
table1111.addCell(cell114);
table1111.addCell(cell115);
table1111.addCell(cell116);
table1111.addCell(cell117);
table1111.addCell(cell118);

document.add(table1111);



Paragraph paragraph13 = new Paragraph("1.4.2: The feedback system of the Institution comprises of the following :\r\n"+"Response\t");
document.add(paragraph13);
Paragraph paragraph14 = new Paragraph(criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria14Qn().get(0).getResponse142():"");

document.add(paragraph14);



Paragraph paragraph15 = new Paragraph("\r\n");
document.add(paragraph15);

PdfPTable table1112 = new PdfPTable(2);
table1112.setWidthPercentage(100);

PdfPCell cell121 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
PdfPCell cell122 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
PdfPCell cell123 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
PdfPCell cell124 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
PdfPCell cell125 = new PdfPCell(new Paragraph("URL for stakeholder feedback report\r\n\r\n"));
PdfPCell cell126 = new PdfPCell(
new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));


table1112.addCell(cell121);
table1112.addCell(cell122);
table1112.addCell(cell123);
table1112.addCell(cell124);
table1112.addCell(cell125);
table1112.addCell(cell126);


document.add(table1112);
document.close();


//
//PdfPTable table111 = new PdfPTable(2);
//table111.setWidthPercentage(100);
//
//PdfPTable table110 = new PdfPTable(1);
//table110.setWidthPercentage(100);
//
//PdfPCell cell111 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
//PdfPCell cell112 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//PdfPCell cell113 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//PdfPCell cell114 = new PdfPCell(
//new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
//PdfPCell cell115 = new PdfPCell(new Paragraph(
//"Action taken report of the Institution on feedback report as minuted by the Governing Council, Syndicate, Board of Management\r\n\r\n"));
//PdfPCell cell116 = new PdfPCell(
//new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
//PdfPCell cell117 = new PdfPCell(new Paragraph("URL for stakeholder feedback report"));
//PdfPCell cell118 = new PdfPCell(new Paragraph((criteria1file.size() > 0 && criteria1file.get(2) != null)
//? criteria1file.get(23).getCriteria1FilePath()
//: ""));
//PdfPCell cell119 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
//PdfPCell cell1120 = new PdfPCell(new Paragraph(""));
//
//// create table12
//PdfPTable table12 = new PdfPTable(2);
//table12.setWidthPercentage(100);
//
//PdfPTable table121 = new PdfPTable(1);
//table121.setWidthPercentage(100);
//
//PdfPCell cell121 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
//PdfPCell cell122 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
//PdfPCell cell123 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//PdfPCell cell124 = new PdfPCell(
//new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
//PdfPCell cell125 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
//PdfPCell cell126 = new PdfPCell(new Paragraph(
//(criteria1file.size() > 0 ) ? criteria1file.get(0).getCriteria1FilePath()
//: ""));
//PdfPCell cell127 = new PdfPCell(new Paragraph("URL for stakeholder feedback report\r\n\r\n"));
//PdfPCell cell128 = new PdfPCell(new Paragraph(""));
//
//
//PdfPTable table11 = new PdfPTable(1);
//table11.setWidthPercentage(100);
//
//
//if(criteria1Fieldinfo.getCriteria1FieldInfoQn().size()>0) {
//table11.addCell(
//"1.1.2 Percentage of Programmes where syllabus revision was carried out during the last five years.\r\n"
//+ "\r\n" + "Response:"
//+ (criteria1Record != null
//? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse112()
//: ""));
//}
//table11.addCell("1.1.2.1 Number of all Programmes offered by the institution during the last five years.\r\n"
//+ "\r\n" + "Response:"
//+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1121t1() : ""));
//table11.addCell(
//"1.1.2.2 How many Programmes were revised out of total number of Programmes offered during the last five years\r\n"
//+ "\r\n" + "Response:"
//+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1122t1()
//: ""));
//
//
//table11.setSpacingAfter(25);
//
//
//document.add(table11);
//
//
//if(criteria1Fieldinfo.getYearTable1131() !=null) {
//Table table1131 = new Table(criteria1Fieldinfo.getYearTable1131().size(), 2);
//
//table1131.setPadding(10);
//table1131.setWidth(100f);
//
//for (int i = 0; i < criteria1Fieldinfo.getYearTable1131().size(); i++) {
//table1131.addCell(criteria1Fieldinfo.getYearTable1131().get(i).getInput1131y());
//}
//for (int i = 0; i < criteria1Fieldinfo.getYearTable1131().size(); i++) {
//table1131.addCell(criteria1Fieldinfo.getYearTable1131().get(i).getInput1131v());
//}
//
// document.add(table1131);
//}
//PdfPTable table31 = new PdfPTable(1);
//table31.setWidthPercentage(100);
//
//PdfPTable table113_1 = new PdfPTable(5);
//table113_1.setWidthPercentage(100);
//
///*
//* com.lowagie.text.Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//* headerFont.setColor(CMYKColor.BLACK);
//*/
//
////PdfPCell cell21 = new PdfPCell(new Paragraph("2020-21"));
////PdfPCell cell22 = new PdfPCell(new Paragraph("2019-20"));
////PdfPCell cell23 = new PdfPCell(new Paragraph("2018-19"));
////
////PdfPCell cell24 = new PdfPCell(new Paragraph("2017-18"));
////PdfPCell cell25 = new PdfPCell(new Paragraph("2016-17"));
////PdfPCell cell26 = new PdfPCell(new Paragraph("  "));
////PdfPCell cell27 = new PdfPCell(new Paragraph("  "));
////PdfPCell cell28 = new PdfPCell(new Paragraph("  "));
////PdfPCell cell29 = new PdfPCell(new Paragraph(" "));
////PdfPCell cell30 = new PdfPCell(new Paragraph("  "));
////
////table113_1.addCell(cell21);
////table113_1.addCell(cell22);
////table113_1.addCell(cell23);
////table113_1.addCell(cell24);
////table113_1.addCell(cell25);
////table113_1.addCell(cell26);
////table113_1.addCell(cell27);
////table113_1.addCell(cell28);
////table113_1.addCell(cell29);
////table113_1.addCell(cell30);
//table31.addCell(
//"1.1.3 Average percentage of courses having focus on employability/ entrepreneurship/ skill development offered by the institution during the last five years\r\n"
//+ "\r\n" + "Response:"
//+ (criteria1Fieldinfo != null
//? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse113()
//: ""));
//table31.addCell(
//"1.1.3.1 Number of courses having focus on employability/ entrepreneurship/ skill development year- wise during the last five years\r\n+\r\n");
//
//// table31.addCell(table113_1);
//
//table31.setSpacingBefore(25);
//table31.setSpacingAfter(25);
//
//document.add(table31);
////document.add(table1131);
//
//
//
//PdfPTable table41 = new PdfPTable(1);
//table41.setWidthPercentage(100);
//table41.addCell(
//"1.2.1 Percentage of new courses introduced of the total number of courses across all programs offered during the last five years.\r\n"
//+ "\r\n" + "Response:"
//+ (criteria1Fieldinfo != null
//? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse121()
//: ""));
//table41.addCell("1.2.1.1 How many new courses are introduced within the last five years\r\n" + "\r\n"
//+ "Response:"
//+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1211t1() : ""));
//table41.addCell(
//"1.2.1.2 Number of courses offered by the institution across all programmes during the last five years.\r\n"
//+ "\r\n" + "Response:"
//+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1212t1()
//: ""));
//
//
//
//table41.setSpacingBefore(25);
//table41.setSpacingAfter(25);
//
//document.add(table41);
//
//PdfPTable table5a = new PdfPTable(1);
//table5a.setWidthPercentage(100);
//
//table5a.addCell(
//"1.2.2 Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year).\r\n"
//+ "\r\n" + "Response:"
//+ (criteria1Record != null
//? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse122()
//: ""));
//table5a.addCell("1.2.2.1 Number of Programmes in which CBCS / Elective course system implemented.\r\n" + "\r\n"
//+ "Response:"
//+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1221t1() : ""));
//
//
//table5a.setSpacingAfter(25f);
//document.add(table5a);
//
//
//
//PdfPTable table61 = new PdfPTable(1);
//table61.setWidthPercentage(100);
//table61.addCell(
//"1.3.1	Institution integrates crosscutting issues relevant to Professional Ethics ,Gender, Human Values ,Environment and Sustainability into the Curriculum\r\n");
//table61.addCell("Response:"
//+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQl().get(0).getResponse131()
//: ""));
//
////table61.addCell("Human Values and Professional Ethics\r\n" + "");
//
//
////table61.addCell(
////"Mother Teresa believes that its graduates/post-graduates have a responsibility to their Profession and the Organization that they serve. Every employer expects a certain set of skills, knowledge, inputs and attitude in an employee. Attitude normally gets reinforced through the three Es�: Education, Environment, and Experience. Therefore, our Institution takes adequate care to infuse a positive attitude in our learners by giving relevant inputs, which touch human lives at large. Courses such as �Human Values and Professional Ethics�, �Business Ethics�, Construction Management, Estimation and Costing, Engineering Economics and Accountancy facilitate development of a holistic perspective among students towards life, profession, empathy and happiness, based on the right understanding of the purpose of human existence, inculcating self-actualization, the highest of the Maslow�s pyramid of hierarchy of needs. Such a holistic perspective forms the basis of value-based education and quality of college life provided at Mother Teresa.\r\n"
////+ "\r\n"
////+ "Students are sensitized to Professional Ethics, through various activities organized under the students� clubs so that as they graduate, they are able to discharge their professional responsibilities with integrity, dignity, fairness and courtesy. They are also sensitized to avoid activities which may lead to conflict with colleagues and/or organizations, not accept any financial/contractual obligation on behalf of his/her employer/client without due authority, treat colleagues and co-workers fairly and not misuse the advantage of their hierarchical position\r\n\r\n"
////+ "Gender equality and Sensitization:\r\n\r\n" + "\r\n"
////+ "For students to demonstrate sensitivity with regard to gender issues, particularly on biological changes with age, showing empathy and practicing healthy socialization is imminent for both the genders.A course on �Gender Sensitization� introduced in the curriculum is implemented through activity-based learning. Gender issues are also discussed in courses, namely, �Human Resource Management� and �Indian Constitution�. For promoting Gender Sensitization, several activities are organized in the institution which include, �Gender Equality - Its importance�, �Women in Nation Building�, �Training on self-defense techniques�, �Health and Hygiene� and �Impact of gender violence on society�. They are also sensitized to respect women and their contribution to the economy and development of the society and practice\r\n"
////+ "gender equality by sharing domestic duties and the like.\r\n" + "\r\n"
////+ "Environment and Sustainability:\r\n" + "\r\n"
////+ "To create awareness about the environmental impact on society due to urbanization and industrialization, courses on �Environmental Studies�, �Green Buildings�, �Global Warming and Climate Change�, �Renewable Energy Sources�, �Energy Conservation Management�, �Environmental Engineering�, �Air Pollution and Control� are included in the curriculum, which facilitates students to understand the ecosystem, its functions, and acquire knowledge about the different types of natural resources, namely, land, water, minerals, non-renewable energy, their excessive usage leads to detrimental effects on the environment is realized by understanding the different types of pollution, their impact on global environment and ways of controlling them. Campaigns on �Dust and Pollution Free Environment�, �Haritha Haram� (tree plantation), �Swachh Bharath�, are conducted with participation of students to promote ecological balance for sustainable development.\r\n\r\n"
////+ "");
////
////// PdfPTable cell700= new pdfpTable()
////
////table61.setSpacingAfter(25);
////document.add(table61);
//
//// document.add(paragraph64);
//// document.add(paragraph65);
//
//// document.add(paragraph66);
//
//PdfPTable table71 = new PdfPTable(5);
//table71.setWidthPercentage(100);
//
//table71.addCell(
//"1.3.2 Number of value-added courses for imparting transferable and life skills offered during last five years.\r\n"
//+ "\r\n" + "Response:"
//+ (criteria1Fieldinfo != null
//? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponseValue132()
//: ""));
//table71.addCell("1.3.2.1 How many new value-added courses are added within the last five years");
//
//table71.setSpacingBefore(25f);
//table71.setSpacingAfter(25f);
//
//if(criteria1Fieldinfo.getYearTable1321() !=null) {
//	
//Table table1321 = new Table(criteria1Fieldinfo.getYearTable1321().size(), 2);
//
//table1321.setPadding(10);
//table1321.setWidth(100f);
//for (int i = 0; i < criteria1Fieldinfo.getYearTable1321().size(); i++) {
//table1321.addCell(criteria1Fieldinfo.getYearTable1321().get(i).getInput1321y());
//}
//for (int i = 0; i < criteria1Fieldinfo.getYearTable1321().size(); i++) {
//table1321.addCell(criteria1Fieldinfo.getYearTable1321().get(i).getInput1321v());
//}
//
//document.add(table71);
//		}
//// document.add(table1321);
//PdfPTable table81 = new PdfPTable(1);
//table81.setWidthPercentage(100);
//
//
//table81.addCell(
//"1.3.2 Number of value-added courses for imparting transferable and life skills offered during last five years.\r\n"
//+ "\r\n" + "Response:"
//+ (criteria1Record != null
//? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponseValue132()
//: ""));
//
//table81.addCell("1.3.2.1 How many new value-added courses are added within the last five years\r\n");
//
//// table81.addCell(table82);
//
//document.add(table81);
//// document.add(table1321);
//
//PdfPTable table91 = new PdfPTable(1);
//
//table91.addCell("1.3.3 Average Percentage of students enrolled in the courses under 1.3.2 above.\r\n" + "\r\n"
//+ "Response:"
//+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse133()
//: ""));
//
//table91.addCell(
//"1.3.3.1 Number of students enrolled in subject related Certificate or Add-on programs year wise during last five years");
//// table91.addCell(table9);
//table91.setSpacingAfter(25f);
//
//
//if(criteria1Fieldinfo.getYearTable1331() !=null)
//{
//Table table1331 = new Table(criteria1Fieldinfo.getYearTable1331().size(), 2);
//
//table1331.setPadding(10);
//table1331.setWidth(100f);
//for (int i = 0; i < criteria1Fieldinfo.getYearTable1331().size(); i++) {
//table1331.addCell(criteria1Fieldinfo.getYearTable1331().get(i).getInput1331y());
//}
//for (int i = 0; i < criteria1Fieldinfo.getYearTable1331().size(); i++) {
//table1331.addCell(criteria1Fieldinfo.getYearTable1331().get(i).getInput1331v());
//}
// document.add(table1331);
//
//}
//
////document.add(table1331);
//// table92.addCell(table9);
//
//PdfPTable table101 = new PdfPTable(1);
//table101.setWidthPercentage(100);
//table101.addCell(
//"1.3.4 Percentage of students undertaking field projects/ internships / student projects (Data for the latest completed academic year)\r\n"
//+ "\r\n" + "Response:"
//+ (criteria1Fieldinfo != null
//? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse134()
//: ""));
//table101.addCell("1.3.4.1 Number of students undertaking field projects / internships / student projects\r\n"
//+ "\r\n" + "Response:"
//+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1341t1() : ""));
//
//document.add(paragraph67);
//
//table111.addCell(cell111);
//table111.addCell(cell112);
//table111.addCell(cell113);
//table111.addCell(cell114);
//table111.addCell(cell115);
//table111.addCell(cell116);
//table111.addCell(cell117);
//table111.addCell(cell118);
//table111.addCell(cell119);
//table111.addCell(cell1120);
//table110.addCell(
//"1.4.1 Structured feedback for design and review of syllabus � semester-wise / year-wise is received from 1) Students, 2) Teachers, 3) Employers, 4) Alumni\r\n"
//+ "\r\n" + "Response:"
//+ (criteria1Fieldinfo != null
//? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse141()
//: ""));
//
//table110.addCell(table111);
//document.add(table110);
//
//table12.addCell(cell121);
//table12.addCell(cell122);
//table12.addCell(cell123);
//table12.addCell(cell124);
//table12.addCell(cell125);
//table12.addCell(cell126);
//table12.addCell(cell127);
//table12.addCell(cell128);
//table121.addCell(
//"1.4.2 The feedback system of the Institution comprises of the following :\r\n" + "\r\n" + "Response:"
//+ (criteria1Fieldinfo != null
//? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse142()
//: ""));
//
//table121.addCell(table12);
//table121.setSpacingBefore(25f);
//table121.setSpacingAfter(25f);
//
//document.add(table121);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}


////////////////////////////////////////////////////
///////////////////criteria 1 end..............
/////////////////////////////////////////

}


