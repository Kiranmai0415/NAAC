package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.EvaluativeFileUpload;
import com.adiverse.erp.model.ExecutiveSummary;
import com.adiverse.erp.model.Executive_FileUpload;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.service.ExecutiveService;
import com.adiverse.erp.service.SsrService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class AffiliatedSsrReport {
	@Value("${logoImgPath}")
	private String logoImgPath;

	@Value("${logoImgScale}")
	private Float[] logoImgScale;

	@Value("${upload.files.path}")
	
	
	private String reportGeneratePath;
	public Image headerImage;
	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
	@Autowired
	SsrService ssrService;
	
	@Autowired 
private 	ExecutiveService executiveService;
	
	
	List<ProfileoftheCollege> profileList = null;
	ProfileoftheCollege ProfileRecord = null;
	List<EvaluativeFileUpload> Profilefile = null;
	

	List<ExecutiveSummary>executiveSummary1 = null;
	ExecutiveSummary executiveSummary = null;
	
	List<Executive_FileUpload> executive_FileUpload1 = null;
	Executive_FileUpload executive_FileUpload = null;
	
	
	public String generateReport() throws DocumentException, IOException {
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
			
			profileList=ssrService.getAllSsrData();
			if (CollectionUtils.isNotEmpty(profileList)) {
				ProfileRecord = profileList.get(0);
			} else {
				ProfileRecord = new ProfileoftheCollege();
			}
			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "affiliatedReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
			addLogo(document);
///////////////////////////////////////////////////////
///////////////////// SSR SSR SSR SSR..................................
///////////////////////////////////////

//Creating font
//Setting font style and size
Font font6 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
font6.setSize(20);

Font font7 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
font7.setSize(18);

Paragraph paragraphssr = new Paragraph("SELF STUDY REPORT" + "" + "" + "", font6);

Paragraph paragraph1ssr = new Paragraph("FOR" + "" + "" + "", font1);

Paragraph paragraph2ssr = new Paragraph("2nd CYCLE OF ACCREDITATION" + "" + "" + "" + "" + "", font7);

Paragraph paragraph3ssr = new Paragraph("MOTHER TERESA INSTITUTE OF SCIENCE &", font7);
Paragraph paragraph4ssr = new Paragraph("TECHNOLOGY" + "", font7);

Paragraph paragraph5ssr = new Paragraph("SANKETIKA NAGAR, SATHUPALLY, KAHMMAM (DIST.) ", font4);
Paragraph paragraph6ssr = new Paragraph("507303", font4);

Paragraph paragraph7ssr = new Paragraph("	http://mistech.ac.in\r\n", font4);

Paragraph paragraph8ssr = new Paragraph("Submitted To ", font5);

Paragraph paragraph9ssr = new Paragraph("NATIONAL ASSESSMENT AND ACCREDITATION COUNCIL  " + "" + "" + "",
font3);

Paragraph paragraph10ssr = new Paragraph("BANGALORE\r\n " , font3);
Paragraph paragraph11ssr = new Paragraph("June 2022\r\n"+"\r\n",font3);

paragraphssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph1ssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph2ssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph3ssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph4ssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph5ssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph6ssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph7ssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph8ssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph9ssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph10ssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph11ssr.setAlignment(Paragraph.ALIGN_CENTER);

document.add(paragraphssr);
document.add(paragraph1ssr);
document.add(paragraph2ssr);
document.add(paragraph3ssr);
document.add(paragraph4ssr);
document.add(paragraph5ssr);
document.add(paragraph6ssr);
document.add(paragraph7ssr);
document.add(paragraph8ssr);
document.add(paragraph9ssr);
document.add(paragraph10ssr);
document.add(paragraph11ssr);



///////////////////////////////////////////////////////////////////////////////////////////////////////////
Paragraph paragraph20ssr1 = new Paragraph("1.EXECUTIVE SUMMARY", font1);
Paragraph paragraph21ssr1 = new Paragraph("1.1 INTRODUCTION", font2);
paragraph20ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
paragraph21ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph20ssr1);
document.add(paragraph21ssr1);

//Paragraph paragraph22ssr = new Paragraph(
//"Mother Teresa Institute of Science and Technology (MIST), Khammam -\r\n" + "\r\n", font5);
//Paragraph paragraph23ssr = new Paragraph(
//"was established in 2001. The college is an ISO 9001:2008 certified institute and is permanently affiliated to Jawaharlal Nehru Technological University, Hyderabad.\r\n"
//+ "\r\n" ,
//font5);
//Paragraph paragraph24ssr = new Paragraph(
//"Mother Teresa Institute of Science and Technology (MIST) was founded through MCM Educational Society in 2001 by eminent philanthropist,industrialists and schloars , MIST  aims at co-creating value-based technical excellence, which ultimately leads to the development of the rural area where the college is situated. From a modest intake of 180 students across 3 engineering programs in B.Tech, namely ECE, CSE, and IT, MIST, in less than 2 decades, it has grown into an institution of gigantic proportions with massive infrastructure, besides multitude of students, faculty & staff. At present, we offer 6 B.Tech programmes in CSE,  ECE, EEE, ME, CE, MNG., 5 M.Tech programmes such as CSE, Power Electronics and Drives ,ECE,Advance Manufacturing Systems,Structural Engg. in addition to M.B.A  programme as first shift and introduced 2nd shift diploma in A.Y:2009,with the Branches CE,EEE,ME,ECE and Mining. MIST has a vibrant campus spread over 30 acres of serene and natural surroundings with plenty of greenery in SATHUPALLY, Khammam  District, Telangana. It has world class infrastructure in all its academic departments, besides an asthetically-designed administrative block. The major facilities include  e-class rooms,  well-equipped laboratories,seminar halls ,well stocked library,WI-FI enabled campus,Backup power supply,Canteen etc. MIST was approved by All india Counsil for Technical Education AICTE New Delhi,  Affliated to Jawaharlal Nehru Technological University Hyderabad , JNTUH and State Board of Technical Education and Training SBTET Recognized by Govt.of Telangana, UGC under Section 2(f) and 12(B) and Accrediated by NAAC  with 'B' Grade. MIST has been recognized as a remote center of IIT BOMBAY and KARAGPUR for organizing FDP’S ,WORKSHOPS,QIP’S for students and faculty.We pride ourselves as an institution with a large pool of well-qualified and experienced faculty who not only enrich our teaching-learning sphere but also contribute to the R&D ecosystem. The promoters of the MIST started the college with a vision to empower students to become technologically vibrant, innovative and emotionally matured to face the dynamic challenges of a quality-conscious global economy. They are socially-conscious and respond proactively to the needs and requirements of this region on a continuous basis. The managing trust is involved in many charitable activities to help the needy and the poor of this region, thereby contribute towards social development of the region.\r\n\r\n",
//font5);

Paragraph paragraph22ssr = new Paragraph(executiveSummary != null ?executiveSummary.getInputes1():
"", font5);
//Paragraph paragraph23ssr = new Paragraph(
//"was established in 2001. The college is an ISO 9001:2008 certified institute and is permanently affiliated to Jawaharlal Nehru Technological University, Hyderabad.\r\n"
//+ "\r\n" ,
//font5);
//Paragraph paragraph24ssr = new Paragraph(
//"Mother Teresa Institute of Science and Technology (MIST) was founded through MCM Educational Society in 2001 by eminent philanthropist,industrialists and schloars , MIST  aims at co-creating value-based technical excellence, which ultimately leads to the development of the rural area where the college is situated. From a modest intake of 180 students across 3 engineering programs in B.Tech, namely ECE, CSE, and IT, MIST, in less than 2 decades, it has grown into an institution of gigantic proportions with massive infrastructure, besides multitude of students, faculty & staff. At present, we offer 6 B.Tech programmes in CSE,  ECE, EEE, ME, CE, MNG., 5 M.Tech programmes such as CSE, Power Electronics and Drives ,ECE,Advance Manufacturing Systems,Structural Engg. in addition to M.B.A  programme as first shift and introduced 2nd shift diploma in A.Y:2009,with the Branches CE,EEE,ME,ECE and Mining. MIST has a vibrant campus spread over 30 acres of serene and natural surroundings with plenty of greenery in SATHUPALLY, Khammam  District, Telangana. It has world class infrastructure in all its academic departments, besides an asthetically-designed administrative block. The major facilities include  e-class rooms,  well-equipped laboratories,seminar halls ,well stocked library,WI-FI enabled campus,Backup power supply,Canteen etc. MIST was approved by All india Counsil for Technical Education AICTE New Delhi,  Affliated to Jawaharlal Nehru Technological University Hyderabad , JNTUH and State Board of Technical Education and Training SBTET Recognized by Govt.of Telangana, UGC under Section 2(f) and 12(B) and Accrediated by NAAC  with 'B' Grade. MIST has been recognized as a remote center of IIT BOMBAY and KARAGPUR for organizing FDP’S ,WORKSHOPS,QIP’S for students and faculty.We pride ourselves as an institution with a large pool of well-qualified and experienced faculty who not only enrich our teaching-learning sphere but also contribute to the R&D ecosystem. The promoters of the MIST started the college with a vision to empower students to become technologically vibrant, innovative and emotionally matured to face the dynamic challenges of a quality-conscious global economy. They are socially-conscious and respond proactively to the needs and requirements of this region on a continuous basis. The managing trust is involved in many charitable activities to help the needy and the poor of this region, thereby contribute towards social development of the region.\r\n\r\n",
//font5);
//
paragraph22ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//	paragraph23ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph22ssr);
//	document.add(paragraph23ssr);

//paragraph24ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//document.add(paragraph24ssr);

Paragraph paragraph25ssr = new Paragraph("VISION", font3);
paragraph25ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph25ssr);



//Paragraph paragraph26ssr = new Paragraph(
//"To provide the society with center of learning that motivates, supports and encourages the youth to involve into dynamic professional with a social commitmenty.\r\n"
//+ "\r\n",
////	font5);

Paragraph paragraph26ssr = new Paragraph(executiveSummary != null ?executiveSummary.getInputes2():"");

paragraph26ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph26ssr);

Paragraph paragraph27ssr = new Paragraph("MISSION", font3);
paragraph27ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph27ssr);

//Paragraph paragraph28ssr = new Paragraph(
//"We dedicate and commitment ourselves to achieve, sustain and    foster unmatched excellence in technical education.  To this end, we will pursue continuous development of infrastructure and enhance state of the art equipment to provide our students a technology up to date and intellectually inspiring environment of learning, research, creativity, innovation and professional activity, inculcate in them ethical and moral values. The institute is committed to build a better nation through quality education with team sprit. Our students are enable to excel values of life and become good citizens. We inspire the system, infrastructure and services to satisfy the students, parents, industry and society.\r\n"
//+ "\r\n" + "\r\n" + "\r\n",
//font5);
Paragraph paragraph28ssr = new Paragraph(executiveSummary != null ?executiveSummary.getInputes3(): "",font5);

paragraph28ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph28ssr);



Paragraph paragraph27ssr1 = new Paragraph("Location:", font3);
paragraph27ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph27ssr1);

Paragraph paragraph28ssr1 = new Paragraph(executiveSummary != null ?executiveSummary.getInputes4(): "",font5);

paragraph28ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph28ssr1);

Paragraph paragraph27ssr11 = new Paragraph("Type of the Institution:", font3);
paragraph27ssr11.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph27ssr11);

Paragraph paragraph28ssr11 = new Paragraph(executiveSummary != null ?executiveSummary.getInputes5(): "",font5);

paragraph28ssr11.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph28ssr11);

Paragraph paragraph27ssr111 = new Paragraph("File upload:", font3);
paragraph27ssr111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph27ssr111);

Paragraph paragraph28ssr111 = new Paragraph(executive_FileUpload != null ?executive_FileUpload.getExecutiveFilePath(): "",font5);

paragraph28ssr111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph28ssr111);

Paragraph paragraph27ssr1111 = new Paragraph("2.Criterion-wise Summary on the Institution:", font3);
paragraph27ssr1111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph27ssr1111);

Paragraph paragraph28ssr1111 = new Paragraph(executiveSummary != null ?executiveSummary.getInputes7(): "",font5);

paragraph28ssr1111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph28ssr1111);


Paragraph paragraph27ssr11111 = new Paragraph("3.Brief note on the Strength Weakness Opportunities and Challenges(SWOC) in respect of the Institution:", font3);
paragraph27ssr11111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph27ssr11111);

Paragraph paragraph28ssr11111 = new Paragraph(executiveSummary != null ?executiveSummary.getInputes8(): "",font5);

paragraph28ssr11111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph28ssr11111);


Paragraph paragraph27ssr111111 = new Paragraph("4.Any additional information about the Institution other than ones already stated.:", font3);
paragraph27ssr111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph27ssr111111);

Paragraph paragraph28ssr111111 = new Paragraph(executiveSummary != null ?executiveSummary.getInputes9(): "",font5);

paragraph28ssr111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph28ssr111111);

Paragraph paragraph27ssr1111111 = new Paragraph("5.Over all conclusive explication about the institution's functioning:", font3);
paragraph27ssr1111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph27ssr1111111);

Paragraph paragraph28ssr1111111 = new Paragraph(executiveSummary != null ?executiveSummary.getInputes9(): "",font5);

paragraph28ssr1111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph28ssr1111111);



//basic information

Paragraph paragraph13ssr = new Paragraph("2.PROFILE\r\n\r\n", font1);
Paragraph paragraph14ssr = new Paragraph("1 BASIC INFORMATION\r\n", font2);
paragraph13ssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph14ssr.setAlignment(Paragraph.ALIGN_CENTER);
document.add(paragraph13ssr);
document.add(paragraph14ssr);

PdfPTable table01ssr = new PdfPTable(1);
table01ssr.setWidthPercentage(100f);

PdfPCell cell01ssr = new PdfPCell(new Paragraph("Name and Address of the College", font5));
table01ssr.addCell(cell01ssr);

PdfPTable table1ssr = new PdfPTable(2);
table1ssr.setWidthPercentage(100f);
table1ssr.setWidths(new int[] { 3, 3 });
table1ssr.setSpacingBefore(5);

PdfPCell cell1ssr = new PdfPCell(new Paragraph("Name"));
table1ssr.addCell(cell1ssr);

PdfPCell cell2ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt1(): ""));
table1ssr.addCell(cell2ssr);

PdfPCell cell3ssr = new PdfPCell(new Paragraph("Address", font5));
table1ssr.addCell(cell3ssr);

PdfPCell cell4ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt2():""));
table1ssr.addCell(cell4ssr);

PdfPCell cell5ssr = new PdfPCell(new Paragraph("City"));
table1ssr.addCell(cell5ssr);

PdfPCell cell6ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt3():""));
table1ssr.addCell(cell6ssr);

PdfPCell cell7ssr = new PdfPCell(new Paragraph("State"));
table1ssr.addCell(cell7ssr);

PdfPCell cell8ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt4(): ""));
table1ssr.addCell(cell8ssr);

PdfPCell cell9ssr = new PdfPCell(new Paragraph("Pin"));
table1ssr.addCell(cell9ssr);

PdfPCell cell10ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt5(): ""));
table1ssr.addCell(cell10ssr);

PdfPCell cell11ssr = new PdfPCell(new Paragraph("Website"));
table1ssr.addCell(cell11ssr);

PdfPCell cell12ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt6(): ""));
table1ssr.addCell(cell12ssr);

table01ssr.addCell(table1ssr);
table01ssr.setSpacingBefore(20f);

table01ssr.setSpacingAfter(20f);
document.add(table01ssr);


// communication table

Paragraph paragraph207ssr = new Paragraph("2.For communication", font3);
paragraph207ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph207ssr);




PdfPTable table02ssr = new PdfPTable(1);
table02ssr.setWidthPercentage(100f);

PdfPCell cell02ssr = new PdfPCell(new Paragraph("Contacts for Communication", font3));
table02ssr.addCell(cell02ssr);

PdfPTable table2ssr = new PdfPTable(6);
table2ssr.setWidthPercentage(100f);
table2ssr.setWidths(new int[] { 70, 70, 70, 70, 70, 70 });
table2ssr.setSpacingBefore(20f);
table2ssr.setSpacingAfter(20f);

PdfPCell cell = new PdfPCell();

cell.setPhrase(new Phrase("Designation\r\n", font3));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase("Name\r\n\r\n", font3));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase("Telephone with STD Code\r\n\r\n", font3));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase("Mobile\r\n\r\n", font3));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase("Fax\r\n\r\n", font3));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase("Email\r\n\r\n", font3));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc1(): ""));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc2(): ""));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc3(): ""));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc4(): ""));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc5(): ""));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc6(): ""));
table2ssr.addCell(cell);
table02ssr.addCell(table2ssr);
table02ssr.setSpacingAfter(20f);
table02ssr.setSpacingBefore(20f);
document.add(table02ssr);

PdfPTable table03ssr = new PdfPTable(1);
table03ssr.setWidthPercentage(100f);

PdfPCell cell03ssr = new PdfPCell(new Paragraph("Status of the Institution\r\n\r\n", font3));
table03ssr.addCell(cell03ssr);

PdfPTable table3ssr = new PdfPTable(2);
table3ssr.setWidthPercentage(100f);
table3ssr.setWidths(new int[] { 70, 70});
table3ssr.setSpacingBefore(20f);
table3ssr.setSpacingAfter(20f);

PdfPCell cell13ssr = new PdfPCell(new Paragraph("Institution Status\r\n\r\n"));
table3ssr.addCell(cell13ssr);

PdfPCell cell14ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getNatureofInstitution().get(0).getInputbti1(): ""));
table3ssr.addCell(cell14ssr);

table03ssr.addCell(table3ssr);
document.add(table03ssr);
table03ssr.setSpacingAfter(20f);

PdfPTable table04ssr = new PdfPTable(1);
table04ssr.setWidthPercentage(100f);

PdfPCell cell04ssr = new PdfPCell(new Paragraph("Type of Institution\r\n\r\n", font3));


table04ssr.addCell(cell04ssr);

PdfPTable table4ssr = new PdfPTable(2);
table4ssr.setWidthPercentage(100f);
table4ssr.setWidths(new int[] { 3, 3 });
table4ssr.setSpacingBefore(20f);
table4ssr.setSpacingAfter(20f);

PdfPCell cell15ssr = new PdfPCell(new Paragraph("By Gender\r\n\r\n"));
table4ssr.addCell(cell15ssr);

PdfPCell cell16ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getNatureofInstitution().get(0).getInputbti2(): ""));
table4ssr.addCell(cell16ssr);

PdfPCell cell17ssr = new PdfPCell(new Paragraph("By Shift\r\n\r\n"));
table4ssr.addCell(cell17ssr);

PdfPCell cell18ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getNatureofInstitution().get(0).getInputbti3(): ""));


table4ssr.addCell(cell18ssr);


table04ssr.addCell(table4ssr);
document.add(table04ssr);
table04ssr.setSpacingAfter(20f);
table04ssr.setSpacingBefore(20f);

PdfPTable table05ssr = new PdfPTable(1);
table05ssr.setWidthPercentage(100f);

PdfPCell cell06ssr = new PdfPCell(new Paragraph("Recognized Minority institution\r\n\r\n", font3));
table05ssr.addCell(cell06ssr);

PdfPTable table5ssr = new PdfPTable(2);
table5ssr.setWidthPercentage(100f);
table5ssr.setWidths(new int[] { 70, 70 });

table5ssr.setSpacingBefore(20f);
table5ssr.setSpacingAfter(20f);

PdfPCell cell07ssr = new PdfPCell(new Paragraph("If it is a recognized minority institution\r\n\r\n"));
table5ssr.addCell(cell07ssr);
PdfPCell cell20ssr = new PdfPCell(new Paragraph());
table5ssr.addCell(cell20ssr);

table05ssr.addCell(table5ssr);
document.add(table05ssr);
table05ssr.setSpacingAfter(20f);
table05ssr.setSpacingBefore(20f);

PdfPTable table06ssr = new PdfPTable(1);
table06ssr.setWidthPercentage(100f);

PdfPCell cell08ssr = new PdfPCell(new Paragraph("Establishment Details\r\n\r\n", font3));
table06ssr.addCell(cell08ssr);
table06ssr.setSpacingBefore(20f);
table06ssr.setSpacingAfter(20f);


PdfPTable table6ssr = new PdfPTable(2);
table6ssr.setWidthPercentage(100f);
table6ssr.setWidths(new int[] { 75, 75 });

table6ssr.setSpacingBefore(20f);
table6ssr.setSpacingAfter(20f);

PdfPCell cell21ssr = new PdfPCell(
new Paragraph("Date of Establishment, Prior to the Grant of 'Autonomy'\r\n\r\n"));

table6ssr.addCell(cell21ssr);

PdfPCell cell22ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getNatureofInstitution().get(0).getInputbti4(): ""));
table6ssr.addCell(cell22ssr);

PdfPCell cell23ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getNatureofInstitution().get(0).getInputbti5(): ""));
table6ssr.addCell(cell23ssr);

PdfPCell cell24ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getNatureofInstitution().get(0).getInputbti6(): ""));
table6ssr.addCell(cell24ssr);

table4ssr.addCell(cell21ssr);


table06ssr.addCell(table6ssr);
document.add(table06ssr);
table06ssr.setSpacingAfter(20f);
table06ssr.setSpacingBefore(20f);

PdfPTable table010ssr = new PdfPTable(1);
table010ssr.setWidthPercentage(100f);
PdfPTable table07ssr = new PdfPTable(1);
table07ssr.setWidthPercentage(100f);

PdfPCell cell09ssr = new PdfPCell(new Paragraph("University to which the college is affiliated\r\n\r\n\r", font3));
table07ssr.addCell(cell09ssr);




/*PdfPTable table7ssr = new PdfPTable(3);
table7ssr.setWidthPercentage(100f);

table7ssr.setSpacingBefore(20f);
table7ssr.setSpacingAfter(20f);

cell.setPhrase(new Phrase("State\r\n\r\n", font3));
table7ssr.addCell(cell);
cell.setPhrase(new Phrase("University name\r\n\r\n", font3));
table7ssr.addCell(cell);
cell.setPhrase(new Phrase("Document\r\n\r\n", font3));
table7ssr.addCell(cell);

cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbti11(): ""));
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbti11(): ""));
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbti11(): ""));

cell.setPadding(5);

table07ssr.addCell(table7ssr);
document.add(table07ssr);


table07ssr.setSpacingAfter(20f);
table07ssr.setSpacingBefore(20f);*/

//  c 

PdfPTable table08ssr = new PdfPTable(1);
table08ssr.setWidthPercentage(100f);

PdfPCell cell121ssr = new PdfPCell(new Paragraph("Details of UGC recognition\r\n\r\n", font3));
table08ssr.addCell(cell121ssr);

PdfPTable table8ssr = new PdfPTable(3);
table8ssr.setWidthPercentage(100f);
table8ssr.setWidths(new int[] { 60, 60, 60 });

table8ssr.setSpacingBefore(20f);
table08ssr.setSpacingAfter(20f);


cell.setPhrase(new Phrase("Under Section", font3));
table8ssr.addCell(cell);
cell.setPhrase(new Phrase("Date", font3));
table8ssr.addCell(cell);
cell.setPhrase(new Phrase("Remarks", font3));
table8ssr.addCell(cell);
//<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

cell.setPhrase(new Phrase("2f of UGC"));
table8ssr.addCell(cell);


//cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtr6(): ""));
//table8ssr.addCell(cell);
//cell.setPhrase(new Phrase());
//table8ssr.addCell(cell);
//cell.setPhrase(new Phrase("12B of UGC"));
//table8ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtr6(): ""));
//table8ssr.addCell(cell);
//cell.setPhrase(new Phrase());
//table8ssr.addCell(cell);

table08ssr.addCell(table8ssr);
document.add(table08ssr);
table08ssr.setSpacingAfter(20f);
table08ssr.setSpacingBefore(20f);


PdfPTable table09ssr = new PdfPTable(1);
table09ssr.setWidthPercentage(100f);
PdfPCell cell122ssr = new PdfPCell(new Paragraph(
"Details of recognition/approval by stationary/regulatory bodies like AICTE,NCTE,MCI,DCI,PCI,RCI etc(other than UGC)",
font3));
table09ssr.addCell(cell122ssr);

PdfPTable table9ssr = new PdfPTable(5);
table9ssr.setWidthPercentage(100f);
table9ssr.setWidths(new int[] { 70, 70, 70, 70, 70 });
table9ssr.setSpacingBefore(20);
table9ssr.setSpacingAfter(20);

cell.setPhrase(new Phrase("Statutory Regulatory Authority\r\n\r\n", font3));
table9ssr.addCell(cell);
cell.setPhrase(new Phrase("Recognition/App roval details Inst itution/Departme nt programme\r\n\r\n", font3));
table9ssr.addCell(cell);
cell.setPhrase(new Phrase("Day,Month and year(dd-mm- yyyy)\r\n\r\n", font3));
table9ssr.addCell(cell);
cell.setPhrase(new Phrase("Validity in months\r\n\r\n", font3));
table9ssr.addCell(cell);
cell.setPhrase(new Phrase("Remarks\r\n\r\n", font3));
table9ssr.addCell(cell);

cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd15():""));
table9ssr.addCell(cell);

cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd11():""));
table9ssr.addCell(cell);

cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd12():""));
table9ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd13():""));
table9ssr.addCell(cell);

cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd14():""));
table9ssr.addCell(cell);

//cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd16():""));
//table9ssr.addCell(cell);


cell.setPadding(5);
table09ssr.addCell(table9ssr);
document.add(table09ssr);
table09ssr.setSpacingAfter(20f);
table09ssr.setSpacingBefore(20f);

table010ssr.addCell(table07ssr);
table010ssr.addCell(table08ssr);
table010ssr.addCell(table09ssr);
table010ssr.setSpacingAfter(20f);
table010ssr.setSpacingBefore(20f);

PdfPTable table011ssr = new PdfPTable(1);
table011ssr.setWidthPercentage(100f);
PdfPCell cell011ssr = new PdfPCell(new Paragraph("Recognitions\r\n\r\n", font3));
table01ssr.addCell(cell011ssr);
PdfPTable table11ssr = new PdfPTable(2);
table11ssr.setWidthPercentage(100f);
table11ssr.setWidths(new int[] { 3, 3 });

table11ssr.setSpacingBefore(20f);
table11ssr.setSpacingAfter(20f);

PdfPCell cell30ssr = new PdfPCell(new Paragraph(
"Is the College recognized by UGC as a College with Potential for Excellence(CPE)?"));
table11ssr.addCell(cell30ssr);

PdfPCell cell31ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.basicprofile2.get(0).getInputbtip1():""));
table11ssr.addCell(cell31ssr);

PdfPCell cell32ssr = new PdfPCell(new Paragraph(
"Is the College recognized for its performance by any other governmental agency?\r\n\r\n" + "\r\n"));
table11ssr.addCell(cell32ssr);

PdfPCell cell28ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.basicprofile2.get(0).getInputbtip4():""));
table11ssr.addCell(cell28ssr);

PdfPCell cell29ssr = new PdfPCell(new Paragraph("If yes, name of the agency\r\n\r\n"));
table11ssr.addCell(cell29ssr);

PdfPCell cell131ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.basicprofile2.get(0).getInputbtip5():""));
table11ssr.addCell(cell131ssr);

PdfPCell cell132ssr = new PdfPCell(new Paragraph("Date of recognition\r\n\r\n"));
table11ssr.addCell(cell132ssr);

PdfPCell cell133ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.basicprofile2.get(0).getInputbtip6():""));
table11ssr.addCell(cell133ssr);

table011ssr.addCell(table11ssr);
document.add(table011ssr);
table011ssr.setSpacingAfter(20f);

//10

PdfPTable table012ssr = new PdfPTable(1);
table012ssr.setWidthPercentage(100f);

PdfPCell cell012ssr = new PdfPCell(new Paragraph("Location and Area of Campus\r\n\r\n", font3));
table012ssr.addCell(cell012ssr);

PdfPTable table12ssr = new PdfPTable(5);
table12ssr.setWidthPercentage(100f);
table12ssr.setWidths(new int[] { 60, 60, 60, 60, 60 });
table12ssr.setSpacingAfter(20f);
table12ssr.setSpacingBefore(20f);
//
cell.setPhrase(new Phrase("Campus Type\r\n\r\n", font3));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase("Address\r\n\r\n", font3));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase("Location\r\n\r\n", font3));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase("Campus Area in Acres\r\n\r\n", font3));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase("Built up Area in sq.mts.\r\n\r\n", font3));
table12ssr.addCell(cell);

cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.campus.get(0).getInputbtl11():""));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.campus.get(0).getInputbtl12():""));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.campus.get(0).getInputbtl13():""));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.campus.get(0).getInputbtl14():""));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.campus.get(0).getInputbtl15():""));
table12ssr.addCell(cell);

cell.setPadding(5);

table012ssr.addCell(table12ssr);
document.add(table012ssr);
table012ssr.setSpacingAfter(20f);



/*Paragraph paragraph15ssr = new Paragraph("2.2 ACADEMIC INFORMATION\r\n\r\n", font1);
paragraph15ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph15ssr);*/
PdfPTable table013ssr = new PdfPTable(1);
table013ssr.setWidthPercentage(100f);
table013ssr.setSpacingBefore(5);
PdfPCell cell013ssr = new PdfPCell(new Paragraph(
" 11.  Details of Programmes Offered by the College (Give Data for Current Academic year)", font3));
table013ssr.addCell(cell013ssr);

PdfPTable table13ssr = new PdfPTable(7);
table13ssr.setWidthPercentage(100f);
table13ssr.setWidths(new int[] {60, 60, 60, 60, 60 ,60,60 });
table13ssr.setSpacingBefore(20f);

cell.setPhrase(new Phrase("Programme Level\r\n\r\n", font3));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase("Name of Programme/C ourse\r\n\r\n", font3));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase("Duration in Months\r\n\r\n", font3));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase("Entry Qualification\r\n\r\n\r\n", font3));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase("Medium of Instruction\r\n\r\n", font3));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase("Sanctioned Strength\r\n\r\n", font3));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase("No.of Students AdmittedSanctioned Strength\r\n\r\n\r\n", font3));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.academicinformation.get(0).getInputad11():""));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.academicinformation.get(0).getInputad12():""));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.academicinformation.get(0).getInputad13():""));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.academicinformation.get(0).getInputad14():""));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.academicinformation.get(0).getInputad15():""));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.academicinformation.get(0).getInputad16():""));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.academicinformation.get(0).getInputad17():""));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());
table13ssr.addCell(cell);
cell.setPhrase(new Phrase());


cell.setPadding(5);
table013ssr.addCell(table13ssr);
table013ssr.setSpacingAfter(20f);
document.add(table013ssr);

//12

Paragraph paragraph15ssr = new Paragraph("12.please fill in the following details if applicable\r\n\r\n", font3);
paragraph15ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph15ssr);


PdfPTable table120ssr = new PdfPTable(2);
table120ssr.setWidthPercentage(100);
PdfPCell cell1210ssr = new PdfPCell(new Paragraph("self-financed programmes offerd"));
PdfPCell cell1211ssr = new PdfPCell(new Paragraph("new programmes interdoced during the last five years"));
//PdfPCell cell1212ssr = new PdfPCell(new Paragraph("self-financed programmes offerd"));
//PdfPCell cell1213ssr = new PdfPCell(new Paragraph("new programmes interdoced during the last five years"));
PdfPCell cell1212ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedProgrammes.get(0).getInputpt1():""));
PdfPCell cell1213ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedProgrammes.get(0).getInputpt2():""));


table120ssr.addCell(cell1210ssr);
table120ssr.addCell(cell1211ssr);
table120ssr.addCell(cell1212ssr);
table120ssr.addCell(cell1213ssr);
table120ssr.setSpacingAfter(20);
table120ssr.setSpacingBefore(20);
document.add(table120ssr);










// 13 departments

Paragraph paragraph105ssr = new Paragraph("13.  list the departments\r\n\r\n", font3);
paragraph105ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph105ssr);


PdfPTable table130ssr = new PdfPTable(5);
table130ssr.setWidthPercentage(100);

PdfPCell cell0014ssr = new PdfPCell(new Paragraph("Faculty"));
PdfPCell cell0015ssr = new PdfPCell(new Paragraph("Deparments"));
PdfPCell cell016ssr = new PdfPCell(new Paragraph("UG"));
PdfPCell cell017ssr = new PdfPCell(new Paragraph("PG"));
PdfPCell cell018ssr = new PdfPCell(new Paragraph("Research"));
PdfPCell cell019ssr = new PdfPCell(new Paragraph("science"));
PdfPCell cell020ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedDepartment.get(0).getInputdt2():""));
PdfPCell cell021ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedDepartment.get(0).getInputdt3():""));
PdfPCell cell022ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedDepartment.get(0).getInputdt4():""));	
PdfPCell cell023ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedDepartment.get(0).getInputdt5():""));
PdfPCell cell024ssr = new PdfPCell(new Paragraph("Arts"));
PdfPCell cell025ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell026ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell027ssr = new PdfPCell(new Paragraph(""));	
PdfPCell cell0028ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell0029ssr = new PdfPCell(new Paragraph("commerce"));
PdfPCell cell0030ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell0031ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell032ssr = new PdfPCell(new Paragraph(""));	
PdfPCell cell033ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell034ssr = new PdfPCell(new Paragraph("any other secify"));
PdfPCell cell035ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell036ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell037ssr = new PdfPCell(new Paragraph(""));	
PdfPCell cell038ssr = new PdfPCell(new Paragraph(""));
table130ssr.addCell(cell0014ssr);

table130ssr.addCell(cell0015ssr);

table130ssr.addCell(cell016ssr);

table130ssr.addCell(cell017ssr);

table130ssr.addCell(cell018ssr);

table130ssr.addCell(cell019ssr);

table130ssr.addCell(cell020ssr);

table130ssr.addCell(cell021ssr);

table130ssr.addCell(cell022ssr);

table130ssr.addCell(cell023ssr);

table130ssr.addCell(cell024ssr);

table130ssr.addCell(cell025ssr);

table130ssr.addCell(cell026ssr);

table130ssr.addCell(cell027ssr);

table130ssr.addCell(cell0028ssr);

table130ssr.addCell(cell0029ssr);

table130ssr.addCell(cell0030ssr);

table130ssr.addCell(cell0031ssr);

table130ssr.addCell(cell032ssr);

table130ssr.addCell(cell033ssr);

table130ssr.addCell(cell034ssr);

table130ssr.addCell(cell035ssr);

table130ssr.addCell(cell036ssr);

table130ssr.addCell(cell037ssr);
table130ssr.addCell(cell038ssr);
table130ssr.setSpacingAfter(20);
table130ssr.setSpacingBefore(20);		
document.add(table130ssr);






//14 teaching and non teaching 

Paragraph paragraph16ssr1 = new Paragraph("14.  Number of teaching and non teaching positions in the Institution\r\n\r\n" + "\r\n",
font3);
paragraph16ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph16ssr1);

PdfPTable table17ssr = new PdfPTable(9);
//PdfPTable table18ssr = new PdfPTable(1);


// Setting width of table, its columns and spacing
table17ssr.setWidthPercentage(100);
//table18ssr.setWidthPercentage(100);


PdfPCell cell014ssr = new PdfPCell(new Paragraph("Positions"));
cell014ssr.setRowspan(2);
PdfPCell cell015ssr = new PdfPCell(new Paragraph("Professor"));
cell015ssr.setColspan(2);
PdfPCell cell0191ssr = new PdfPCell(new Paragraph("Associate Professor"));
cell0191ssr.setColspan(2);
PdfPCell cell0237ssr = new PdfPCell(new Paragraph("Assistant Professor"));
cell0237ssr.setColspan(2);
PdfPCell cell0181ssr = new PdfPCell(new Paragraph("Nonteachingstaff"));
cell0181ssr.setColspan(1);
PdfPCell cell01810ssr = new PdfPCell(new Paragraph("Technicalstaff"));
cell01810ssr.setColspan(1);
// document.add(cell0192ssr);

PdfPCell cell0203ssr = new PdfPCell(new Paragraph("Male"));
PdfPCell cell0214ssr = new PdfPCell(new Paragraph("Female"));

PdfPCell cell0246ssr = new PdfPCell(new Paragraph("Male"));
PdfPCell cell0258ssr = new PdfPCell(new Paragraph("Female"));

PdfPCell cell0282ssr = new PdfPCell(new Paragraph("Male"));
PdfPCell cell0293ssr = new PdfPCell(new Paragraph("Female"));

PdfPCell cell02820ssr = new PdfPCell(new Paragraph("Male"));

PdfPCell cell02930ssr = new PdfPCell(new Paragraph("Female"));



PdfPCell cell0326ssr = new PdfPCell(new Paragraph("Sanctioned by the UGC/University State Government"));
PdfPCell cell0337sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat11():""));
PdfPCell cell0372ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat12():""));
PdfPCell cell0383ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat13():""));
PdfPCell cell03370sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat11():""));
PdfPCell cell03720ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat12():""));
PdfPCell cell03830ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat13():""));
PdfPCell cell03370ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat11():""));
PdfPCell cell037200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat12():""));



PdfPCell cell0394ssr = new PdfPCell(new Paragraph("Recruited"));
PdfPCell cell0405ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat14():""));
PdfPCell cell0416ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat15():""));
PdfPCell cell0427ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat16():""));
PdfPCell cell0438ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat17():""));
PdfPCell cell0449ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat18():""));
PdfPCell cell0451ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat19():""));
PdfPCell cell0452ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat10():""));
PdfPCell cell0453ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat111():""));
//PdfPCell cell0454ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat112():""));
//PdfPCell cell0455ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat11():""));
//PdfPCell cell0456ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat11():""));
//PdfPCell cell0457ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat11():""));

PdfPCell cell032612ssr = new PdfPCell(new Paragraph("Yet to Recruit"));

PdfPCell cell033722ssr = new PdfPCell(new Paragraph());
PdfPCell cell037212ssr = new PdfPCell(new Paragraph());
PdfPCell cell038312ssr = new PdfPCell(new Paragraph());
PdfPCell cell0337220ssr = new PdfPCell(new Paragraph());
PdfPCell cell0372120ssr = new PdfPCell(new Paragraph());
PdfPCell cell0383120ssr = new PdfPCell(new Paragraph());
PdfPCell cell03372200ssr = new PdfPCell(new Paragraph());
PdfPCell cell03721200ssr = new PdfPCell(new Paragraph());




PdfPCell cell03261ssr = new PdfPCell(
new Paragraph("Sanctioned by the Management/Soci ety or Other Authorized Bodies"));

PdfPCell cell03371ssr = new PdfPCell(new Paragraph());
PdfPCell cell03721ssr = new PdfPCell(new Paragraph());
PdfPCell cell03831ssr = new PdfPCell(new Paragraph());
PdfPCell cell033710ssr = new PdfPCell(new Paragraph());
PdfPCell cell037210ssr = new PdfPCell(new Paragraph());
PdfPCell cell038310ssr = new PdfPCell(new Paragraph());
PdfPCell cell0337100ssr = new PdfPCell(new Paragraph());
PdfPCell cell0372100ssr = new PdfPCell(new Paragraph());



PdfPCell cell03941ssr = new PdfPCell(new Paragraph("Recruted"));
PdfPCell cell04052ssr = new PdfPCell(new Paragraph());
PdfPCell cell04163ssr = new PdfPCell(new Paragraph());
PdfPCell cell04274ssr = new PdfPCell(new Paragraph());
PdfPCell cell04385ssr = new PdfPCell(new Paragraph());
PdfPCell cell04496ssr = new PdfPCell(new Paragraph());
PdfPCell cell04517ssr = new PdfPCell(new Paragraph());
PdfPCell cell04528ssr = new PdfPCell(new Paragraph());
PdfPCell cell04539ssr = new PdfPCell(new Paragraph());

PdfPCell cell032611ssr = new PdfPCell(new Paragraph("Yet to Recruit"));

PdfPCell cell033721ssr = new PdfPCell(new Paragraph());
PdfPCell cell037213ssr = new PdfPCell(new Paragraph());
PdfPCell cell038314ssr = new PdfPCell(new Paragraph());
PdfPCell cell0337210ssr = new PdfPCell(new Paragraph());
PdfPCell cell0372130ssr = new PdfPCell(new Paragraph());
PdfPCell cell0383140ssr = new PdfPCell(new Paragraph());
PdfPCell cell03372100ssr = new PdfPCell(new Paragraph());
PdfPCell cell03721300ssr = new PdfPCell(new Paragraph());








table17ssr.addCell(cell014ssr);
table17ssr.addCell(cell015ssr);
table17ssr.addCell(cell0237ssr);
table17ssr.addCell(cell0237ssr);
table17ssr.addCell(cell0181ssr);
table17ssr.addCell(cell01810ssr);

// table17ssr.addCell(cell0192ssr);
table17ssr.addCell(cell0203ssr);
table17ssr.addCell(cell0214ssr);

table17ssr.addCell(cell0246ssr);
table17ssr.addCell(cell0258ssr);

table17ssr.addCell(cell0282ssr);
table17ssr.addCell(cell0293ssr);


table17ssr.addCell(cell02820ssr);
table17ssr.addCell(cell02930ssr);


table17ssr.addCell(cell0326ssr);
table17ssr.addCell(cell0337sr);
// table17ssr.addCell(cell0348sr);
// table17ssr.addCell(cell0359ssr);
// table17ssr.addCell(cell0361ssr);
table17ssr.addCell(cell0372ssr);
table17ssr.addCell(cell0383ssr);
table17ssr.addCell(cell03370sr);
table17ssr.addCell(cell03720ssr);
table17ssr.addCell(cell03830ssr);
table17ssr.addCell(cell03370ssr);
table17ssr.addCell(cell037200ssr);



table17ssr.addCell(cell0394ssr);
table17ssr.addCell(cell0405ssr);
table17ssr.addCell(cell0416ssr);
table17ssr.addCell(cell0427ssr);
table17ssr.addCell(cell0438ssr);
table17ssr.addCell(cell0449ssr);
table17ssr.addCell(cell0451ssr);
table17ssr.addCell(cell0452ssr);
table17ssr.addCell(cell0453ssr);
//table17ssr.addCell(cell0454ssr);
//table17ssr.addCell(cell0455ssr);
//table17ssr.addCell(cell0456ssr);
//table17ssr.addCell(cell0457ssr);

table17ssr.addCell(cell032612ssr);
table17ssr.addCell(cell033722ssr);
table17ssr.addCell(cell037212ssr);
table17ssr.addCell(cell038312ssr);
table17ssr.addCell(cell0337220ssr);
table17ssr.addCell(cell0372120ssr);
table17ssr.addCell(cell0383120ssr);
table17ssr.addCell(cell03372200ssr);
table17ssr.addCell(cell03721200ssr);





table17ssr.addCell(cell03261ssr);
table17ssr.addCell(cell03371ssr);

table17ssr.addCell(cell03721ssr);
table17ssr.addCell(cell03831ssr);
table17ssr.addCell(cell033710ssr);
table17ssr.addCell(cell037210ssr);
table17ssr.addCell(cell038310ssr);
table17ssr.addCell(cell0337100ssr);
table17ssr.addCell(cell0372100ssr);


table17ssr.addCell(cell03941ssr);
table17ssr.addCell(cell04052ssr);
table17ssr.addCell(cell04163ssr);
table17ssr.addCell(cell04274ssr);
table17ssr.addCell(cell04385ssr);
table17ssr.addCell(cell04496ssr);
table17ssr.addCell(cell04517ssr);
table17ssr.addCell(cell04528ssr);
table17ssr.addCell(cell04539ssr);


table17ssr.addCell(cell032611ssr);
table17ssr.addCell(cell033721ssr);
table17ssr.addCell(cell037213ssr);
table17ssr.addCell(cell038314ssr);
table17ssr.addCell(cell0337210ssr);
table17ssr.addCell(cell0372130ssr);

table17ssr.addCell(cell0383140ssr);
table17ssr.addCell(cell03372100ssr);
table17ssr.addCell(cell03721300ssr);


//PdfPCell cell0189ssr = new PdfPCell(new Paragraph("Teaching Faculty",font3));
//
//table18ssr.addCell(cell0189ssr);
//
//
//table18ssr.addCell(table17ssr);

// cell015ssr.addElement(new Paragraph(""));
// cell015ssr.addElement(new Paragraph(""));
// cell015ssr.addElement(new Paragraph(""));
// cell015ssr.addElement(new Paragraph(""));

table17ssr.setSpacingBefore(20f);
table17ssr.setSpacingAfter(20f);

document.add(table17ssr);



Paragraph paragraph19ssr = new Paragraph("15. Qualification Details of the Teaching Staff\r\n\r\n", font3);
paragraph19ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph19ssr);




PdfPTable table23ssr = new PdfPTable(8);
table23ssr.setWidthPercentage(100);


PdfPCell cell028ssr = new PdfPCell(new Paragraph("Highest Qualification	"));
cell028ssr.setRowspan(2);
PdfPCell cell029ssr = new PdfPCell(new Paragraph("Professor"));
cell029ssr.setColspan(2);
PdfPCell cell030ssr = new PdfPCell(new Paragraph("Associate Professor"));
cell030ssr.setColspan(2);
PdfPCell cell031ssr = new PdfPCell(new Paragraph("Assistant Professor"));
cell031ssr.setColspan(2);
PdfPCell cell011320ssr = new PdfPCell(new Paragraph("total"));
cell011320ssr.setRowspan(2);


PdfPCell cell0132ssr = new PdfPCell(new Paragraph("Male"));
PdfPCell cell0332ssr = new PdfPCell(new Paragraph("Female"));

PdfPCell cell0532ssr = new PdfPCell(new Paragraph("Male"));
PdfPCell cell0632ssr = new PdfPCell(new Paragraph("Female"));

PdfPCell cell0832ssr = new PdfPCell(new Paragraph("Male"));
PdfPCell cell0932ssr = new PdfPCell(new Paragraph("Female"));
PdfPCell cell09320ssr = new PdfPCell(new Paragraph("permanent teachers"));

PdfPCell cell024320ssr = new PdfPCell(new Paragraph());
PdfPCell cell025320ssr = new PdfPCell(new Paragraph());
PdfPCell cell026320ssr = new PdfPCell(new Paragraph());

PdfPCell cell027320ssr = new PdfPCell(new Paragraph());
PdfPCell cell028320ssr = new PdfPCell(new Paragraph());
PdfPCell cell029320ssr = new PdfPCell(new Paragraph());

PdfPCell cell030320ssr = new PdfPCell(new Paragraph());



PdfPCell cell01232ssr = new PdfPCell(new Paragraph("D.sc/D.Litt/ LLD/DM/M CH"));
PdfPCell cell01332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq11():""));
PdfPCell cell01432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq12():""));
PdfPCell cell01532ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq13():""));

PdfPCell cell01632ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq14():""));
PdfPCell cell01732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq15():""));
PdfPCell cell01832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq16():""));

PdfPCell cell01932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq17():""));

PdfPCell cell02332ssr = new PdfPCell(new Paragraph("Ph.D."));
PdfPCell cell02432ssr = new PdfPCell(new Paragraph());
PdfPCell cell02532ssr = new PdfPCell(new Paragraph());
PdfPCell cell02632ssr = new PdfPCell(new Paragraph());
PdfPCell cell02732ssr = new PdfPCell(new Paragraph());
PdfPCell cell02832ssr = new PdfPCell(new Paragraph());
PdfPCell cell02932ssr = new PdfPCell(new Paragraph());
PdfPCell cell03032ssr = new PdfPCell(new Paragraph());

PdfPCell cell034321ssr = new PdfPCell(new Paragraph("M.Phil."));
PdfPCell cell03532ssr = new PdfPCell(new Paragraph());
PdfPCell cell03632ssr = new PdfPCell(new Paragraph());
PdfPCell cell03732ssr = new PdfPCell(new Paragraph());

PdfPCell cell03832ssr = new PdfPCell(new Paragraph());
PdfPCell cell03932ssr = new PdfPCell(new Paragraph());
PdfPCell cell04032ssr = new PdfPCell(new Paragraph());

PdfPCell cell04132ssr = new PdfPCell(new Paragraph());

PdfPCell cell04532ssr = new PdfPCell(new Paragraph("PG"));
PdfPCell cell04632ssr = new PdfPCell(new Paragraph());
PdfPCell cell04732ssr = new PdfPCell(new Paragraph());
PdfPCell cell04832ssr = new PdfPCell(new Paragraph());

PdfPCell cell04932ssr = new PdfPCell(new Paragraph());
PdfPCell cell05032ssr = new PdfPCell(new Paragraph());
PdfPCell cell05132ssr = new PdfPCell(new Paragraph());

PdfPCell cell05232ssr = new PdfPCell(new Paragraph());

PdfPCell cell05632ssr = new PdfPCell(new Paragraph("Temporary teachers"));
PdfPCell cell05732ssr = new PdfPCell(new Paragraph());
PdfPCell cell05832ssr = new PdfPCell(new Paragraph());
PdfPCell cell05932ssr = new PdfPCell(new Paragraph());

PdfPCell cell06032ssr = new PdfPCell(new Paragraph());
PdfPCell cell06132ssr = new PdfPCell(new Paragraph());
PdfPCell cell06232ssr = new PdfPCell(new Paragraph());
PdfPCell cell06332ssr = new PdfPCell(new Paragraph());


PdfPCell cell012320ssr = new PdfPCell(new Paragraph("D.sc/D.Litt/ LLD/DM/M CH"));
PdfPCell cell013320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq51():""));
PdfPCell cell014320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq52():""));
PdfPCell cell015320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq53():""));

PdfPCell cell016320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq53():""));
PdfPCell cell017320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq54():""));
PdfPCell cell018320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq55():""));

PdfPCell cell019320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq56():""));

PdfPCell cell023320ssr = new PdfPCell(new Paragraph("Ph.D."));
PdfPCell cell0243201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0253201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0263201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0273201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0283201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0293201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0303201ssr = new PdfPCell(new Paragraph());

PdfPCell cell03432101ssr = new PdfPCell(new Paragraph("M.Phil."));
PdfPCell cell0353201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0363201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0373201ssr = new PdfPCell(new Paragraph());

PdfPCell cell0383201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0393201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0403201ssr = new PdfPCell(new Paragraph());

PdfPCell cell0413201ssr = new PdfPCell(new Paragraph());

PdfPCell cell0453201ssr = new PdfPCell(new Paragraph("PG"));
PdfPCell cell0463201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0473201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0483201ssr = new PdfPCell(new Paragraph());

PdfPCell cell0493201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0503201ssr = new PdfPCell(new Paragraph());
PdfPCell cell0513201ssr = new PdfPCell(new Paragraph());

PdfPCell cell0523201ssr = new PdfPCell(new Paragraph());



PdfPCell cell056320ssr = new PdfPCell(new Paragraph("Part-time  teachers"));
PdfPCell cell057320ssr = new PdfPCell(new Paragraph());
PdfPCell cell058320ssr = new PdfPCell(new Paragraph());
PdfPCell cell059320ssr = new PdfPCell(new Paragraph());

PdfPCell cell060320ssr = new PdfPCell(new Paragraph());
PdfPCell cell061320ssr = new PdfPCell(new Paragraph());
PdfPCell cell062320ssr = new PdfPCell(new Paragraph());
PdfPCell cell063320ssr = new PdfPCell(new Paragraph());


PdfPCell cell0123200ssr = new PdfPCell(new Paragraph("D.sc/D.Litt/ LLD/DM/M CH"));
PdfPCell cell0133200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicParttimeTeacheres.get(0).getInputatq91():""));
PdfPCell cell0143200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicParttimeTeacheres.get(0).getInputatq92():""));
PdfPCell cell0153200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicParttimeTeacheres.get(0).getInputatq93():""));

PdfPCell cell0163200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicParttimeTeacheres.get(0).getInputatq94():""));
PdfPCell cell0173200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicParttimeTeacheres.get(0).getInputatq95():""));
PdfPCell cell0183200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicParttimeTeacheres.get(0).getInputatq96():""));

PdfPCell cell0193200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicParttimeTeacheres.get(0).getInputatq97():""));

PdfPCell cell0233200ssr = new PdfPCell(new Paragraph("Ph.D."));
PdfPCell cell02432010ssr = new PdfPCell(new Paragraph());
PdfPCell cell02532010ssr = new PdfPCell(new Paragraph());
PdfPCell cell02632010ssr = new PdfPCell(new Paragraph());
PdfPCell cell02732010ssr = new PdfPCell(new Paragraph());
PdfPCell cell02832010ssr = new PdfPCell(new Paragraph());
PdfPCell cell02932010ssr = new PdfPCell(new Paragraph());
PdfPCell cell03032010ssr = new PdfPCell(new Paragraph());

PdfPCell cell034321010ssr = new PdfPCell(new Paragraph("M.Phil."));

PdfPCell cell03532010ssr = new PdfPCell(new Paragraph());
PdfPCell cell03632001ssr = new PdfPCell(new Paragraph());
PdfPCell cell03732010ssr = new PdfPCell(new Paragraph());

PdfPCell cell03832010ssr = new PdfPCell(new Paragraph());
PdfPCell cell03932010ssr = new PdfPCell(new Paragraph());
PdfPCell cell04032010ssr = new PdfPCell(new Paragraph());

PdfPCell cell04132010ssr = new PdfPCell(new Paragraph());

PdfPCell cell04532010ssr = new PdfPCell(new Paragraph("PG"));
PdfPCell cell04632010ssr = new PdfPCell(new Paragraph());
PdfPCell cell04732010ssr = new PdfPCell(new Paragraph());
PdfPCell cell04832010ssr = new PdfPCell(new Paragraph());

PdfPCell cell04932010ssr = new PdfPCell(new Paragraph());
PdfPCell cell05032010ssr = new PdfPCell(new Paragraph());
PdfPCell cell05132010ssr = new PdfPCell(new Paragraph());

PdfPCell cell05232010ssr = new PdfPCell(new Paragraph());












table23ssr.addCell(cell028ssr);
table23ssr.addCell(cell029ssr);
table23ssr.addCell(cell030ssr);
table23ssr.addCell(cell031ssr);
table23ssr.addCell(cell011320ssr);


table23ssr.addCell(cell0132ssr);
table23ssr.addCell(cell0332ssr);

table23ssr.addCell(cell0532ssr);
table23ssr.addCell(cell0632ssr);

table23ssr.addCell(cell0832ssr);
table23ssr.addCell(cell0932ssr);
table23ssr.addCell(cell09320ssr);

//7
table23ssr.addCell(cell024320ssr);
table23ssr.addCell(cell025320ssr);
table23ssr.addCell(cell026320ssr);
table23ssr.addCell(cell027320ssr);
table23ssr.addCell(cell028320ssr);
table23ssr.addCell(cell029320ssr);
table23ssr.addCell(cell030320ssr);

table23ssr.addCell(cell01232ssr);
table23ssr.addCell(cell01332ssr);
table23ssr.addCell(cell01432ssr);
table23ssr.addCell(cell01532ssr);
table23ssr.addCell(cell01632ssr);
table23ssr.addCell(cell01732ssr);
table23ssr.addCell(cell01832ssr);
table23ssr.addCell(cell01932ssr);

table23ssr.addCell(cell02332ssr);
table23ssr.addCell(cell02432ssr);
table23ssr.addCell(cell02532ssr);
table23ssr.addCell(cell02632ssr);
table23ssr.addCell(cell02732ssr);
table23ssr.addCell(cell02832ssr);
table23ssr.addCell(cell02932ssr);
table23ssr.addCell(cell03032ssr);

table23ssr.addCell(cell04532ssr);
table23ssr.addCell(cell04632ssr);
table23ssr.addCell(cell04732ssr);
table23ssr.addCell(cell04832ssr);
table23ssr.addCell(cell04932ssr);
table23ssr.addCell(cell05032ssr);
table23ssr.addCell(cell05132ssr);
table23ssr.addCell(cell05232ssr);







table23ssr.addCell(cell034321ssr);
table23ssr.addCell(cell03532ssr);
table23ssr.addCell(cell03632ssr);
table23ssr.addCell(cell03732ssr);
table23ssr.addCell(cell03832ssr);
table23ssr.addCell(cell03932ssr);
table23ssr.addCell(cell04032ssr);
table23ssr.addCell(cell04132ssr);




///temp

table23ssr.addCell(cell05632ssr);
table23ssr.addCell(cell05732ssr);
table23ssr.addCell(cell05832ssr);
table23ssr.addCell(cell05932ssr);
table23ssr.addCell(cell06032ssr);
table23ssr.addCell(cell06132ssr);
table23ssr.addCell(cell06232ssr);
table23ssr.addCell(cell06332ssr);




table23ssr.addCell(cell012320ssr);
table23ssr.addCell(cell013320ssr);
table23ssr.addCell(cell014320ssr);
table23ssr.addCell(cell015320ssr);
table23ssr.addCell(cell016320ssr);
table23ssr.addCell(cell017320ssr);
table23ssr.addCell(cell018320ssr);
table23ssr.addCell(cell019320ssr);

table23ssr.addCell(cell023320ssr);
table23ssr.addCell(cell0243201ssr);
table23ssr.addCell(cell0253201ssr);
table23ssr.addCell(cell0263201ssr);
table23ssr.addCell(cell0273201ssr);
table23ssr.addCell(cell0283201ssr);
table23ssr.addCell(cell0293201ssr);
table23ssr.addCell(cell0303201ssr);

table23ssr.addCell(cell03432101ssr);
table23ssr.addCell(cell0353201ssr);
table23ssr.addCell(cell0363201ssr);
table23ssr.addCell(cell0373201ssr);
table23ssr.addCell(cell0383201ssr);
table23ssr.addCell(cell0393201ssr);
table23ssr.addCell(cell0403201ssr);
table23ssr.addCell(cell0413201ssr);


table23ssr.addCell(cell0453201ssr);
table23ssr.addCell(cell0463201ssr);
table23ssr.addCell(cell0473201ssr);
table23ssr.addCell(cell0483201ssr);
table23ssr.addCell(cell0493201ssr);
table23ssr.addCell(cell0503201ssr);
table23ssr.addCell(cell0513201ssr);
table23ssr.addCell(cell0523201ssr);

////part-time


table23ssr.addCell(cell056320ssr);
table23ssr.addCell(cell057320ssr);
table23ssr.addCell(cell058320ssr);
table23ssr.addCell(cell059320ssr);
table23ssr.addCell(cell060320ssr);
table23ssr.addCell(cell061320ssr);
table23ssr.addCell(cell062320ssr);
table23ssr.addCell(cell063320ssr);




table23ssr.addCell(cell0123200ssr);
table23ssr.addCell(cell0133200ssr);
table23ssr.addCell(cell0143200ssr);
table23ssr.addCell(cell0153200ssr);
table23ssr.addCell(cell0163200ssr);
table23ssr.addCell(cell0173200ssr);
table23ssr.addCell(cell0183200ssr);
table23ssr.addCell(cell0193200ssr);

table23ssr.addCell(cell0233200ssr);
table23ssr.addCell(cell02432010ssr);
table23ssr.addCell(cell02532010ssr);
table23ssr.addCell(cell02632010ssr);
table23ssr.addCell(cell02732010ssr);
table23ssr.addCell(cell02832010ssr);
table23ssr.addCell(cell02932010ssr);
table23ssr.addCell(cell03032010ssr);


///phd	

table23ssr.addCell(cell034321010ssr);
table23ssr.addCell(cell03532010ssr);
table23ssr.addCell(cell03632001ssr);
table23ssr.addCell(cell03732010ssr);
table23ssr.addCell(cell03832010ssr);
table23ssr.addCell(cell03932010ssr);
table23ssr.addCell(cell04032010ssr);
table23ssr.addCell(cell04132010ssr);




table23ssr.addCell(cell04532010ssr);
table23ssr.addCell(cell04632010ssr);
table23ssr.addCell(cell04732010ssr);
table23ssr.addCell(cell04832010ssr);
table23ssr.addCell(cell04932010ssr);
table23ssr.addCell(cell05032010ssr);
table23ssr.addCell(cell05132010ssr);
table23ssr.addCell(cell05232010ssr);
document.add(table23ssr);

//16
Paragraph paragraph109ssr = new Paragraph("16.Number of Visiting Faculty/Guest Faculty engaged with the College\r\n\r\n", font3);
paragraph109ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph109ssr);






// 17

Paragraph paragraph1009ssr = new Paragraph("17.Furnish the number of the Students admitted to the college during the last four academic years:\r\n\r\n", font3);
paragraph1009ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph1009ssr);



PdfPTable table217ssr = new PdfPTable(9);
table217ssr.setWidthPercentage(100);

PdfPCell cell220ssr = new PdfPCell(new Paragraph("Categories"));
cell220ssr.setRowspan(2);
PdfPCell cell221ssr = new PdfPCell(new Paragraph("Year 1"));
cell221ssr.setColspan(2);
PdfPCell cell222ssr = new PdfPCell(new Paragraph("Year 2 "));
cell222ssr.setColspan(2);
PdfPCell cell223ssr = new PdfPCell(new Paragraph("Year 3 "));
cell223ssr.setColspan(2);
PdfPCell cell224ssr = new PdfPCell(new Paragraph("Year 4"));
cell224ssr.setColspan(2);

PdfPCell cell225ssr = new PdfPCell(new Paragraph("Male"));
PdfPCell cell226ssr = new PdfPCell(new Paragraph("Female"));
PdfPCell cell227ssr = new PdfPCell(new Paragraph("Male"));
PdfPCell cell228ssr = new PdfPCell(new Paragraph("Female"));
PdfPCell cell229ssr = new PdfPCell(new Paragraph("Male"));
PdfPCell cell230ssr = new PdfPCell(new Paragraph("Female"));

PdfPCell cell2290ssr = new PdfPCell(new Paragraph("Male"));
PdfPCell cell2300ssr = new PdfPCell(new Paragraph("Female"));



PdfPCell cell231ssr = new PdfPCell(new Paragraph("SC"));
PdfPCell cell232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsAdmitted.get(0).getInputaa11():""));
PdfPCell cell233ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsAdmitted.get(0).getInputaa12():""));
PdfPCell cell234ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsAdmitted.get(0).getInputaa13():""));
PdfPCell cell235ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsAdmitted.get(0).getInputaa14():""));
PdfPCell cell236ssr = new PdfPCell(new Paragraph());
PdfPCell cell237ssr = new PdfPCell(new Paragraph());
PdfPCell cell238ssr = new PdfPCell(new Paragraph());
PdfPCell cell239ssr = new PdfPCell(new Paragraph());

PdfPCell cell240ssr = new PdfPCell(new Paragraph("ST"));
PdfPCell cell241ssr = new PdfPCell(new Paragraph());
PdfPCell cell242ssr = new PdfPCell(new Paragraph());
PdfPCell cell243ssr = new PdfPCell(new Paragraph());
PdfPCell cell244ssr = new PdfPCell(new Paragraph());
PdfPCell cell245ssr = new PdfPCell(new Paragraph());
PdfPCell cell246ssr = new PdfPCell(new Paragraph());
PdfPCell cell247ssr = new PdfPCell(new Paragraph());
PdfPCell cell248ssr = new PdfPCell(new Paragraph());


PdfPCell cell249ssr = new PdfPCell(new Paragraph("OBC"));
PdfPCell cell250ssr = new PdfPCell(new Paragraph());
PdfPCell cell251ssr = new PdfPCell(new Paragraph());
PdfPCell cell252ssr = new PdfPCell(new Paragraph());
PdfPCell cell253ssr = new PdfPCell(new Paragraph());
PdfPCell cell254ssr = new PdfPCell(new Paragraph());
PdfPCell cell255ssr = new PdfPCell(new Paragraph());
PdfPCell cell256ssr = new PdfPCell(new Paragraph());
PdfPCell cell257ssr = new PdfPCell(new Paragraph());


PdfPCell cell258ssr = new PdfPCell(new Paragraph("General"));
PdfPCell cell259ssr = new PdfPCell(new Paragraph());
PdfPCell cell260ssr = new PdfPCell(new Paragraph());
PdfPCell cell261ssr = new PdfPCell(new Paragraph());
PdfPCell cell262ssr = new PdfPCell(new Paragraph());
PdfPCell cell263ssr = new PdfPCell(new Paragraph());
PdfPCell cell264ssr = new PdfPCell(new Paragraph());
PdfPCell cell265ssr = new PdfPCell(new Paragraph());
PdfPCell cell266ssr = new PdfPCell(new Paragraph());



PdfPCell cell267ssr = new PdfPCell(new Paragraph("General"));
PdfPCell cell268ssr = new PdfPCell(new Paragraph());
PdfPCell cell269ssr = new PdfPCell(new Paragraph());
PdfPCell cell270ssr = new PdfPCell(new Paragraph());
PdfPCell cell271ssr = new PdfPCell(new Paragraph());
PdfPCell cell272ssr = new PdfPCell(new Paragraph());
PdfPCell cell273ssr = new PdfPCell(new Paragraph());
PdfPCell cell274ssr = new PdfPCell(new Paragraph());
PdfPCell cell275ssr = new PdfPCell(new Paragraph());

table217ssr.addCell(cell220ssr);
table217ssr.addCell(cell221ssr);
table217ssr.addCell(cell222ssr);
table217ssr.addCell(cell223ssr);
table217ssr.addCell(cell224ssr);
table217ssr.addCell(cell225ssr);
table217ssr.addCell(cell226ssr);
table217ssr.addCell(cell227ssr);
table217ssr.addCell(cell228ssr);
table217ssr.addCell(cell229ssr);
table217ssr.addCell(cell230ssr);
//MISSING
table217ssr.addCell(cell2290ssr);
table217ssr.addCell(cell2300ssr);



table217ssr.addCell(cell231ssr);
table217ssr.addCell(cell232ssr);
table217ssr.addCell(cell233ssr);

table217ssr.addCell(cell234ssr);
table217ssr.addCell(cell235ssr);
table217ssr.addCell(cell236ssr);
table217ssr.addCell(cell237ssr);
table217ssr.addCell(cell238ssr);
table217ssr.addCell(cell239ssr);
table217ssr.addCell(cell240ssr);
table217ssr.addCell(cell241ssr);
table217ssr.addCell(cell242ssr);
table217ssr.addCell(cell243ssr);
table217ssr.addCell(cell244ssr);
table217ssr.addCell(cell245ssr);
table217ssr.addCell(cell246ssr);
table217ssr.addCell(cell247ssr);
table217ssr.addCell(cell248ssr);
table217ssr.addCell(cell249ssr);
table217ssr.addCell(cell250ssr);
table217ssr.addCell(cell251ssr);
table217ssr.addCell(cell252ssr);
table217ssr.addCell(cell253ssr);
table217ssr.addCell(cell254ssr);
table217ssr.addCell(cell255ssr);
table217ssr.addCell(cell256ssr);
table217ssr.addCell(cell257ssr);
table217ssr.addCell(cell258ssr);
table217ssr.addCell(cell259ssr);
table217ssr.addCell(cell260ssr);
table217ssr.addCell(cell261ssr);
table217ssr.addCell(cell262ssr);
table217ssr.addCell(cell263ssr);
table217ssr.addCell(cell264ssr);
table217ssr.addCell(cell265ssr);
table217ssr.addCell(cell266ssr);
table217ssr.addCell(cell267ssr);
table217ssr.addCell(cell268ssr);
table217ssr.addCell(cell269ssr);
table217ssr.addCell(cell270ssr);
table217ssr.addCell(cell271ssr);
table217ssr.addCell(cell272ssr);
table217ssr.addCell(cell273ssr);
table217ssr.addCell(cell274ssr);
table217ssr.addCell(cell275ssr);

table217ssr.setSpacingAfter(20);
table217ssr.setSpacingBefore(20);
document.add(table217ssr);

//18  students enrollment

Paragraph paragraph10090ssr = new Paragraph("18. Details on the students enrollment in the college during the current academic year:\r\n\r\n", font3);
paragraph10090ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph10090ssr);




PdfPTable table181ssr = new PdfPTable(6);

table181ssr.setWidthPercentage(100);
PdfPCell cell181ssr = new PdfPCell(new Paragraph("Type of students"));
PdfPCell cell182ssr = new PdfPCell(new Paragraph("UG"));
PdfPCell cell183ssr = new PdfPCell(new Paragraph("PG"));
PdfPCell cell184ssr = new PdfPCell(new Paragraph("M.Phil"));
PdfPCell cell185ssr = new PdfPCell(new Paragraph("Ph.D"));
PdfPCell cell186ssr = new PdfPCell(new Paragraph("Total"));

PdfPCell cell187ssr = new PdfPCell(new Paragraph("Students from the same state where the college is located "));
PdfPCell cell189ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedEnrollment.get(0).getInputet2():""));
PdfPCell cell190ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedEnrollment.get(0).getInputet3():""));
PdfPCell cell191ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedEnrollment.get(0).getInputet4():""));
PdfPCell cell192ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedEnrollment.get(0).getInputet5():""));
PdfPCell cell193ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedEnrollment.get(0).getInputet6():""));

PdfPCell cell194ssr = new PdfPCell(new Paragraph("Students from other in india "));
PdfPCell cell195ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell196ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell197ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell198ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell199ssr = new PdfPCell(new Paragraph(""));

PdfPCell cell200ssr = new PdfPCell(new Paragraph("NRI students "));
PdfPCell cell201ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell202ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell203ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell204ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell205ssr = new PdfPCell(new Paragraph(""));

PdfPCell cell206ssr = new PdfPCell(new Paragraph("foreign students  "));
PdfPCell cell207ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell208ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell209ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell210ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell211ssr = new PdfPCell(new Paragraph(""));

PdfPCell cell212ssr = new PdfPCell(new Paragraph("total"));
PdfPCell cell213ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell214ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell215ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell216ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell217ssr = new PdfPCell(new Paragraph(""));

table181ssr.addCell(cell181ssr);
table181ssr.addCell(cell182ssr);
table181ssr.addCell(cell183ssr);
table181ssr.addCell(cell184ssr);
table181ssr.addCell(cell185ssr);
table181ssr.addCell(cell186ssr);
table181ssr.addCell(cell187ssr);
table181ssr.addCell(cell189ssr);
table181ssr.addCell(cell190ssr);
table181ssr.addCell(cell191ssr);
table181ssr.addCell(cell192ssr);
table181ssr.addCell(cell193ssr);
table181ssr.addCell(cell194ssr);
table181ssr.addCell(cell195ssr);
table181ssr.addCell(cell196ssr);
table181ssr.addCell(cell197ssr);
table181ssr.addCell(cell198ssr);
table181ssr.addCell(cell199ssr);
table181ssr.addCell(cell200ssr);
table181ssr.addCell(cell201ssr);
table181ssr.addCell(cell202ssr);
table181ssr.addCell(cell203ssr);
table181ssr.addCell(cell204ssr);
table181ssr.addCell(cell205ssr);
table181ssr.addCell(cell206ssr);
table181ssr.addCell(cell207ssr);
table181ssr.addCell(cell208ssr);
table181ssr.addCell(cell209ssr);
table181ssr.addCell(cell210ssr);
table181ssr.addCell(cell211ssr);
table181ssr.addCell(cell212ssr);
table181ssr.addCell(cell213ssr);
table181ssr.addCell(cell214ssr);
table181ssr.addCell(cell215ssr);
table181ssr.addCell(cell216ssr);
table181ssr.addCell(cell217ssr);
document.add(table181ssr);


//19 
Paragraph paragraph10009ssr = new Paragraph("19.please fill in the following details if applicable:\r\n\r\n", font3);
paragraph10009ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph10009ssr);





PdfPTable table191ssr = new PdfPTable(6);
table191ssr.setWidthPercentage(100);
PdfPCell cell1901ssr = new PdfPCell(new Paragraph("Unit cost of education"));
PdfPCell cell1902ssr = new PdfPCell(new Paragraph("including salary component"));
PdfPCell cell1903ssr = new PdfPCell(new Paragraph("excludiung salary component"));
PdfPCell cell1904ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedEducation.get(0).getInputct1():""));
PdfPCell cell1905ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedEducation.get(0).getInputct2():""));
PdfPCell cell1906ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedEducation.get(0).getInputct3():""));

table191ssr.addCell(cell1901ssr);

table191ssr.addCell(cell1902ssr);
table191ssr.addCell(cell1903ssr);
table191ssr.addCell(cell1904ssr);
table191ssr.addCell(cell1905ssr);
table191ssr.addCell(cell1906ssr);
table191ssr.setSpacingAfter(20);
table191ssr.setSpacingBefore(20);
document.add(table191ssr);

//20 CYCLE




Paragraph paragraph100009ssr = new Paragraph("20.Date of accrediation(applicable for Cycle 2,Cycle 3,Cycle 4 and re-assessment only):\r\n\r\n", font3);
paragraph100009ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph100009ssr);






PdfPTable table200ssr = new PdfPTable(4);
table200ssr.setWidthPercentage(100);
PdfPCell cell2001ssr = new PdfPCell(new Paragraph("cycle1"));
PdfPCell cell2002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedAccrediation.get(0).getInputat1():""));
PdfPCell cell2003ssr = new PdfPCell(new Paragraph("result 1"));
PdfPCell cell2004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedAccrediation.get(0).getInputat5():""));
PdfPCell cell2005ssr = new PdfPCell(new Paragraph("Cycle 2"));
PdfPCell cell2006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedAccrediation.get(0).getInputat2():""));
PdfPCell cell2007ssr = new PdfPCell(new Paragraph("result 2"));
PdfPCell cell2008ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedAccrediation.get(0).getInputat6():""));
PdfPCell cell2009ssr = new PdfPCell(new Paragraph("Cycle 3"));
PdfPCell cell20010ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedAccrediation.get(0).getInputat3():""));
PdfPCell cell20011ssr = new PdfPCell(new Paragraph("result 3"));
PdfPCell cell20012ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedAccrediation.get(0).getInputat7():""));
PdfPCell cell20013ssr = new PdfPCell(new Paragraph("Cycle 4"));
PdfPCell cell20014ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedAccrediation.get(0).getInputat4():""));
PdfPCell cell20015ssr = new PdfPCell(new Paragraph("result 4"));
PdfPCell cell20016ssr = new PdfPCell(new Paragraph("IQAC"));
PdfPCell cell20017ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedAnnualQuality.get(0).getInputat9():""));
PdfPCell cell20018ssr = new PdfPCell(new Paragraph("AQAR 1"));
PdfPCell cell20019ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedAnnualQuality.get(0).getInputat10():""));
PdfPCell cell20020ssr = new PdfPCell(new Paragraph("AQAR 2"));
PdfPCell cell120021ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedAnnualQuality.get(0).getInputat11():""));
PdfPCell cell120022ssr = new PdfPCell(new Paragraph("AQAR 3"));
PdfPCell cell120023ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedAnnualQuality.get(0).getInputat12():""));
PdfPCell cell120024ssr = new PdfPCell(new Paragraph("AQAR 4"));
PdfPCell cell120025ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.affiliatedAnnualQuality.get(0).getInputat13():""));

table200ssr.addCell(cell2001ssr);
table200ssr.addCell(cell2002ssr);
table200ssr.addCell(cell2003ssr);
table200ssr.addCell(cell2004ssr);
table200ssr.addCell(cell2005ssr);
table200ssr.addCell(cell2006ssr);
table200ssr.addCell(cell2007ssr);
table200ssr.addCell(cell2008ssr);
table200ssr.addCell(cell2009ssr);
table200ssr.addCell(cell20010ssr);
table200ssr.addCell(cell20011ssr);
table200ssr.addCell(cell20012ssr);
table200ssr.addCell(cell20013ssr);
table200ssr.addCell(cell20014ssr);
table200ssr.addCell(cell20015ssr);
table200ssr.addCell(cell20016ssr);
table200ssr.addCell(cell20017ssr);
table200ssr.addCell(cell20018ssr);
table200ssr.addCell(cell20019ssr);
table200ssr.addCell(cell20020ssr);
table200ssr.addCell(cell120021ssr);
table200ssr.addCell(cell120022ssr);
table200ssr.addCell(cell120023ssr);
table200ssr.addCell(cell120024ssr);
table200ssr.addCell(cell120025ssr);
table200ssr.setSpacingAfter(20);
table200ssr.setSpacingBefore(20);
document.add(table200ssr);

document.close();
} catch (Exception e) {
e.printStackTrace();
}
return file.toAbsolutePath().toString();
}

		
			private void addLogo(Document document) {
				Path root = Paths.get(reportGeneratePath);
				Path file = null;
				try {
					file = root.resolve("naac.png");
					Image img = Image.getInstance(file.toAbsolutePath().toString());
					img.scalePercent(logoImgScale[0], logoImgScale[1]);
					img.setAlignment(Element.ALIGN_CENTER);
					document.add(img);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

}
