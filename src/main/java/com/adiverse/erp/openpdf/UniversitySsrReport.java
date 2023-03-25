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
public class UniversitySsrReport {

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
				reportPath = "UniversityqualityAdivsorReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
			addLogo(document);
			
////////////////////////////////////////////////////////
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

Paragraph paragraph10ssr = new Paragraph("BANGALORE" , font3);
Paragraph paragraph11ssr = new Paragraph("June 2022\r\n\r\n",font3);

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

Paragraph paragraph20ssr = new Paragraph("1.EXECUTIVE SUMMARY", font1);
Paragraph paragraph21ssr = new Paragraph("1.1 INTRODUCTION", font2);
paragraph20ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
paragraph21ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph20ssr);
document.add(paragraph21ssr);

//Paragraph paragraph22ssr = new Paragraph(
//		"Mother Teresa Institute of Science and Technology (MIST), Khammam -\r\n" + "\r\n", font5);
//Paragraph paragraph23ssr = new Paragraph(
//		"was established in 2001. The college is an ISO 9001:2008 certified institute and is permanently affiliated to Jawaharlal Nehru Technological University, Hyderabad.\r\n"
//				+ "\r\n" ,
//		font5);
//Paragraph paragraph24ssr = new Paragraph(
//		"Mother Teresa Institute of Science and Technology (MIST) was founded through MCM Educational Society in 2001 by eminent philanthropist,industrialists and schloars , MIST  aims at co-creating value-based technical excellence, which ultimately leads to the development of the rural area where the college is situated. From a modest intake of 180 students across 3 engineering programs in B.Tech, namely ECE, CSE, and IT, MIST, in less than 2 decades, it has grown into an institution of gigantic proportions with massive infrastructure, besides multitude of students, faculty & staff. At present, we offer 6 B.Tech programmes in CSE,  ECE, EEE, ME, CE, MNG., 5 M.Tech programmes such as CSE, Power Electronics and Drives ,ECE,Advance Manufacturing Systems,Structural Engg. in addition to M.B.A  programme as first shift and introduced 2nd shift diploma in A.Y:2009,with the Branches CE,EEE,ME,ECE and Mining. MIST has a vibrant campus spread over 30 acres of serene and natural surroundings with plenty of greenery in SATHUPALLY, Khammam  District, Telangana. It has world class infrastructure in all its academic departments, besides an asthetically-designed administrative block. The major facilities include  e-class rooms,  well-equipped laboratories,seminar halls ,well stocked library,WI-FI enabled campus,Backup power supply,Canteen etc. MIST was approved by All india Counsil for Technical Education AICTE New Delhi,  Affliated to Jawaharlal Nehru Technological University Hyderabad , JNTUH and State Board of Technical Education and Training SBTET Recognized by Govt.of Telangana, UGC under Section 2(f) and 12(B) and Accrediated by NAAC  with 'B' Grade. MIST has been recognized as a remote center of IIT BOMBAY and KARAGPUR for organizing FDP’S ,WORKSHOPS,QIP’S for students and faculty.We pride ourselves as an institution with a large pool of well-qualified and experienced faculty who not only enrich our teaching-learning sphere but also contribute to the R&D ecosystem. The promoters of the MIST started the college with a vision to empower students to become technologically vibrant, innovative and emotionally matured to face the dynamic challenges of a quality-conscious global economy. They are socially-conscious and respond proactively to the needs and requirements of this region on a continuous basis. The managing trust is involved in many charitable activities to help the needy and the poor of this region, thereby contribute towards social development of the region.\r\n\r\n",
//		font5);

Paragraph paragraph22ssr = new Paragraph(executiveSummary != null ?executiveSummary.getInputes1():
		"", font5);
//Paragraph paragraph23ssr = new Paragraph(
//		"was established in 2001. The college is an ISO 9001:2008 certified institute and is permanently affiliated to Jawaharlal Nehru Technological University, Hyderabad.\r\n"
//				+ "\r\n" ,
//		font5);
//Paragraph paragraph24ssr = new Paragraph(
//		"Mother Teresa Institute of Science and Technology (MIST) was founded through MCM Educational Society in 2001 by eminent philanthropist,industrialists and schloars , MIST  aims at co-creating value-based technical excellence, which ultimately leads to the development of the rural area where the college is situated. From a modest intake of 180 students across 3 engineering programs in B.Tech, namely ECE, CSE, and IT, MIST, in less than 2 decades, it has grown into an institution of gigantic proportions with massive infrastructure, besides multitude of students, faculty & staff. At present, we offer 6 B.Tech programmes in CSE,  ECE, EEE, ME, CE, MNG., 5 M.Tech programmes such as CSE, Power Electronics and Drives ,ECE,Advance Manufacturing Systems,Structural Engg. in addition to M.B.A  programme as first shift and introduced 2nd shift diploma in A.Y:2009,with the Branches CE,EEE,ME,ECE and Mining. MIST has a vibrant campus spread over 30 acres of serene and natural surroundings with plenty of greenery in SATHUPALLY, Khammam  District, Telangana. It has world class infrastructure in all its academic departments, besides an asthetically-designed administrative block. The major facilities include  e-class rooms,  well-equipped laboratories,seminar halls ,well stocked library,WI-FI enabled campus,Backup power supply,Canteen etc. MIST was approved by All india Counsil for Technical Education AICTE New Delhi,  Affliated to Jawaharlal Nehru Technological University Hyderabad , JNTUH and State Board of Technical Education and Training SBTET Recognized by Govt.of Telangana, UGC under Section 2(f) and 12(B) and Accrediated by NAAC  with 'B' Grade. MIST has been recognized as a remote center of IIT BOMBAY and KARAGPUR for organizing FDP’S ,WORKSHOPS,QIP’S for students and faculty.We pride ourselves as an institution with a large pool of well-qualified and experienced faculty who not only enrich our teaching-learning sphere but also contribute to the R&D ecosystem. The promoters of the MIST started the college with a vision to empower students to become technologically vibrant, innovative and emotionally matured to face the dynamic challenges of a quality-conscious global economy. They are socially-conscious and respond proactively to the needs and requirements of this region on a continuous basis. The managing trust is involved in many charitable activities to help the needy and the poor of this region, thereby contribute towards social development of the region.\r\n\r\n",
//		font5);
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
//		"To provide the society with center of learning that motivates, supports and encourages the youth to involve into dynamic professional with a social commitmenty.\r\n"
//				+ "\r\n",
//	//	font5);

Paragraph paragraph26ssr = new Paragraph(executiveSummary != null ?executiveSummary.getInputes2():"");

paragraph26ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph26ssr);

Paragraph paragraph27ssr = new Paragraph("MISSION", font3);
paragraph27ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph27ssr);

//Paragraph paragraph28ssr = new Paragraph(
//		"We dedicate and commitment ourselves to achieve, sustain and    foster unmatched excellence in technical education.  To this end, we will pursue continuous development of infrastructure and enhance state of the art equipment to provide our students a technology up to date and intellectually inspiring environment of learning, research, creativity, innovation and professional activity, inculcate in them ethical and moral values. The institute is committed to build a better nation through quality education with team sprit. Our students are enable to excel values of life and become good citizens. We inspire the system, infrastructure and services to satisfy the students, parents, industry and society.\r\n"
//				+ "\r\n" + "\r\n" + "\r\n",
//		font5);
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
		


Paragraph paragraph13ssr = new Paragraph("2.PROFILE\r\n", font1);
Paragraph paragraph14ssr = new Paragraph("2.1 BASIC INFORMATION\r\n", font2);
paragraph13ssr.setAlignment(Paragraph.ALIGN_CENTER);
paragraph14ssr.setAlignment(Paragraph.ALIGN_CENTER);
document.add(paragraph13ssr);
document.add(paragraph14ssr);

PdfPTable table01ssr = new PdfPTable(1);
table01ssr.setWidthPercentage(100f);

PdfPCell cell01ssr = new PdfPCell(new Paragraph("\r\nName and Address of the University\r\n", font5));
table01ssr.addCell(cell01ssr);

PdfPTable table1ssr = new PdfPTable(2);
table1ssr.setWidthPercentage(100f);
table1ssr.setWidths(new int[] { 3, 3 });
table1ssr.setSpacingBefore(5);

PdfPCell cell1ssr = new PdfPCell(new Paragraph("\r\nName\r\n"));
table1ssr.addCell(cell1ssr);

PdfPCell cell2ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt1(): ""));
table1ssr.addCell(cell2ssr);

PdfPCell cell3ssr = new PdfPCell(new Paragraph("\r\nAddress\r\n", font5));
table1ssr.addCell(cell3ssr);

PdfPCell cell4ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt2(): ""));
table1ssr.addCell(cell4ssr);

PdfPCell cell5ssr = new PdfPCell(new Paragraph("\r\nCity\r\n"));
table1ssr.addCell(cell5ssr);

PdfPCell cell6ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt3(): ""));
table1ssr.addCell(cell6ssr);

PdfPCell cell7ssr = new PdfPCell(new Paragraph("\r\nState\r\n"));
table1ssr.addCell(cell7ssr);

PdfPCell cell8ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt4(): ""));
table1ssr.addCell(cell8ssr);

PdfPCell cell9ssr = new PdfPCell(new Paragraph("\r\nPin\r\n"));
table1ssr.addCell(cell9ssr);

PdfPCell cell10ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt5(): ""));
table1ssr.addCell(cell10ssr);

PdfPCell cell11ssr = new PdfPCell(new Paragraph("\r\nWebsite\r\n"));
table1ssr.addCell(cell11ssr);

PdfPCell cell12ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt6(): ""));
table1ssr.addCell(cell12ssr);

table01ssr.addCell(table1ssr);
table01ssr.setSpacingBefore(20f);

table01ssr.setSpacingAfter(20f);

document.add(table01ssr);

PdfPTable table02ssr = new PdfPTable(1);
table02ssr.setWidthPercentage(100f);

PdfPCell cell02ssr = new PdfPCell(new Paragraph("\r\nContacts for Communication\r\n", font3));
table02ssr.addCell(cell02ssr);

PdfPTable table2ssr = new PdfPTable(6);
table2ssr.setWidthPercentage(100f);
table2ssr.setWidths(new int[] { 70, 70, 70, 70, 70, 70 });
table2ssr.setSpacingBefore(20f);
table2ssr.setSpacingAfter(20f);

PdfPCell cell = new PdfPCell();


cell.setPhrase(new Phrase("\r\nDesignation\r\n", font3));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nName\r\n", font3));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nTelephone with STD Code\r\n", font3));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nMobile\r\n", font3));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nFax\r\n", font3));
table2ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nEmail\r\n", font3));
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
//cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtc7(): ""));
//table2ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtc1(): ""));
//table2ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtc1(): ""));
//table2ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtc1(): ""));
//table2ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtc1(): ""));
//table2ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtc1(): ""));
//table2ssr.addCell(cell);


cell.setPadding(5);

table02ssr.addCell(table2ssr);
table02ssr.setSpacingAfter(20f);
table02ssr.setSpacingBefore(20f);
document.add(table02ssr);

PdfPTable table03ssr = new PdfPTable(1);
table03ssr.setWidthPercentage(100f);

table03ssr.setSpacingBefore(20f);
table03ssr.setSpacingAfter(20f);



PdfPCell cell03ssr = new PdfPCell(new Paragraph("\r\nNature of University\r\n", font3));
table03ssr.addCell(cell03ssr);

PdfPTable table3ssr = new PdfPTable(2);
table3ssr.setWidthPercentage(100f);
table3ssr.setWidths(new int[] { 70, 70});
table3ssr.setSpacingBefore(20f);
table3ssr.setSpacingAfter(20f);

PdfPCell cell13ssr = new PdfPCell(new Paragraph("\r\nNature of University\r\n"));
table3ssr.addCell(cell13ssr);

PdfPCell cell14ssr = new PdfPCell(new Paragraph());
table3ssr.addCell(cell14ssr);

table03ssr.addCell(table3ssr);
document.add(table03ssr);
table03ssr.setSpacingAfter(20f);

PdfPTable table04ssr = new PdfPTable(1);
table04ssr.setWidthPercentage(100f);

PdfPCell cell04ssr = new PdfPCell(new Paragraph("\r\nType of University\r\n", font3));


table04ssr.addCell(cell04ssr);

PdfPTable table4ssr = new PdfPTable(2);
table4ssr.setWidthPercentage(100f);
table4ssr.setWidths(new int[] { 3, 3 });
table4ssr.setSpacingBefore(20f);
table4ssr.setSpacingAfter(20f);

PdfPCell cell15ssr = new PdfPCell(new Paragraph("\r\nType of University\r\n"));
table4ssr.addCell(cell15ssr);

PdfPCell cell16ssr = new PdfPCell(new Paragraph());
table4ssr.addCell(cell16ssr);



table04ssr.addCell(table4ssr);
document.add(table04ssr);
table04ssr.setSpacingAfter(20f);
table04ssr.setSpacingBefore(20f);

//PdfPTable table05ssr = new PdfPTable(1);
//table05ssr.setWidthPercentage(100f);
//
//PdfPCell cell06ssr = new PdfPCell(new Paragraph("\r\n\r\nRecognized Minority institution\r\n\r\n", font3));
//table05ssr.addCell(cell06ssr);
//
//PdfPTable table5ssr = new PdfPTable(2);
//table5ssr.setWidthPercentage(100f);
//table5ssr.setWidths(new int[] { 70, 70 });
//
//table5ssr.setSpacingBefore(20f);
//table5ssr.setSpacingAfter(20f);
//
//PdfPCell cell07ssr = new PdfPCell(new Paragraph("\r\n\r\nIf it is a recognized minority institution\r\n\r\n"));
//table5ssr.addCell(cell07ssr);
//PdfPCell cell20ssr = new PdfPCell(new Paragraph());
//table5ssr.addCell(cell20ssr);
//
//table05ssr.addCell(table5ssr);
//document.add(table05ssr);
//table05ssr.setSpacingAfter(20f);
//table05ssr.setSpacingBefore(20f);

PdfPTable table06ssr = new PdfPTable(1);
table06ssr.setWidthPercentage(100f);

PdfPCell cell08ssr = new PdfPCell(new Paragraph("\r\nEstablishment Details\r\n", font3));
table06ssr.addCell(cell08ssr);
table06ssr.setSpacingBefore(20f);
table06ssr.setSpacingAfter(20f);


PdfPTable table6ssr = new PdfPTable(2);
table6ssr.setWidthPercentage(100f);
table6ssr.setWidths(new int[] { 75, 75 });

table6ssr.setSpacingBefore(20f);
table6ssr.setSpacingAfter(20f);

PdfPCell cell21ssr = new PdfPCell(
new Paragraph("\r\nDate of Establishment of the University\r\n"));

table6ssr.addCell(cell21ssr);

PdfPCell cell22ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getNatureofInstitution().get(0).getInputbti4(): ""));
table6ssr.addCell(cell22ssr);

PdfPCell cell23ssr = new PdfPCell(new Paragraph("\r\nStatus Prior to Establishment,If applicable\r\n"));
table6ssr.addCell(cell23ssr);

PdfPCell cell24ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getNatureofInstitution().get(0).getInputbti5(): ""));
table6ssr.addCell(cell24ssr);

PdfPCell cell231ssr = new PdfPCell(new Paragraph("\r\nEstablishment Date\r\n"));
table6ssr.addCell(cell231ssr);

PdfPCell cell241ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getNatureofInstitution().get(0).getInputbti6(): ""));
table6ssr.addCell(cell241ssr);


table4ssr.addCell(cell21ssr);


table06ssr.addCell(table6ssr);
document.add(table06ssr);
table06ssr.setSpacingAfter(20f);
table06ssr.setSpacingBefore(20f);

PdfPTable table010ssr = new PdfPTable(1);
table010ssr.setWidthPercentage(100f);
PdfPTable table07ssr = new PdfPTable(1);
table07ssr.setWidthPercentage(100f);

//PdfPCell cell09ssr = new PdfPCell(new Paragraph("University to which the college is affiliated\r\n\r\n\r", font3));
//table07ssr.addCell(cell09ssr);
//
//PdfPTable table7ssr = new PdfPTable(3);
//table7ssr.setWidthPercentage(100f);
//
//table7ssr.setSpacingBefore(20f);
//table7ssr.setSpacingAfter(20f);
//
//cell.setPhrase(new Phrase("State\r\n\r\n", font3));
//table7ssr.addCell(cell);
//cell.setPhrase(new Phrase("University name\r\n\r\n", font3));
//table7ssr.addCell(cell);
//cell.setPhrase(new Phrase("Document\r\n\r\n", font3));
//table7ssr.addCell(cell);
//
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(24).getEvaluative_filePath() : ""));
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(25).getEvaluative_filePath() : ""));
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(26).getEvaluative_filePath() : ""));
//
//cell.setPadding(5);
//
//table07ssr.addCell(table7ssr);
//document.add(table07ssr);
//table07ssr.setSpacingAfter(20f);
//table07ssr.setSpacingBefore(20f);

PdfPTable table08ssr = new PdfPTable(1);
table08ssr.setWidthPercentage(100f);

PdfPCell cell1211ssr = new PdfPCell(new Paragraph("\r\nRecognition Details"
+ "\r\n", font3));
table08ssr.addCell(cell1211ssr);

PdfPCell cell121ssr = new PdfPCell(new Paragraph("\r\nDate of Recognition as a University by UGC or Any Other National Agency :\r\n"
+ "\r\n", font3));
table08ssr.addCell(cell121ssr);

PdfPTable table8ssr = new PdfPTable(3);
table8ssr.setWidthPercentage(100f);
table8ssr.setWidths(new int[] { 60, 60, 60 });

table8ssr.setSpacingBefore(20f);
table8ssr.setSpacingAfter(20f);


cell.setPhrase(new Phrase("\r\nUnder Section\r\n", font3));
table8ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nDate\r\n", font3));
table8ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nView Document\r\n", font3));
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
//cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtr7(): ""));
//table8ssr.addCell(cell);
cell.setPhrase(new Phrase());
table8ssr.addCell(cell);

table08ssr.addCell(table8ssr);
document.add(table08ssr);
table08ssr.setSpacingAfter(20f);
table08ssr.setSpacingBefore(20f);


PdfPTable table09ssr = new PdfPTable(1);
table09ssr.setWidthPercentage(100f);
PdfPCell cell122ssr = new PdfPCell(new Paragraph(
" University with Potential for Excellence\r\n\r\n"
+ "",
font3));
table09ssr.addCell(cell122ssr);
PdfPTable table9ssr = new PdfPTable(5);
table9ssr.setWidthPercentage(100f);
table9ssr.setWidths(new int[] { 70, 70, 70, 70, 70 });
table9ssr.setSpacingBefore(20);
table09ssr.setSpacingAfter(20);

cell.setPhrase(new Phrase("Is the University Recognised as a University with\r\n"
+ "Potential for Excellence (UPE) by the UGC?\r\n"
+ "", font3));
table9ssr.addCell(cell);
//cell.setPhrase(new Phrase("Recognition/App roval details Inst itution/Departme nt programme\r\n\r\n", font3));
//table9ssr.addCell(cell);
//cell.setPhrase(new Phrase("Day,Month and year(dd-mm- yyyy)\r\n\r\n", font3));
//table9ssr.addCell(cell);
//cell.setPhrase(new Phrase("Validity in months\r\n\r\n", font3));
//table9ssr.addCell(cell);
//cell.setPhrase(new Phrase("Remarks\r\n\r\n", font3));
//table9ssr.addCell(cell);
//cell.setPhrase(new Phrase(""));
//table9ssr.addCell(cell);

cell.setPhrase(new Phrase());
table9ssr.addCell(cell);

//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(34).getEvaluative_filePath() : ""));
//table9ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(35).getEvaluative_filePath() : ""));
//table9ssr.addCell(cell);
//
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(36).getEvaluative_filePath() : ""));
//table9ssr.addCell(cell);
//
//cell.setPhrase(new Phrase(""));
table9ssr.addCell(cell);

//
//cell.setPadding(5);
//table09ssr.addCell(table9ssr);
//document.add(table09ssr);
//table09ssr.setSpacingAfter(20f);
//table09ssr.setSpacingBefore(20f);
//
//table010ssr.addCell(table07ssr);
//table010ssr.addCell(table08ssr);
//table010ssr.addCell(table09ssr);
//table010ssr.setSpacingAfter(20f);
//table010ssr.setSpacingBefore(20f);
//
//PdfPTable table011ssr = new PdfPTable(1);
//table011ssr.setWidthPercentage(100f);
//PdfPCell cell011ssr = new PdfPCell(new Paragraph("Recognitions\r\n\r\n", font3));
//table01ssr.addCell(cell011ssr);
//PdfPTable table11ssr = new PdfPTable(2);
//table11ssr.setWidthPercentage(100f);
//table11ssr.setWidths(new int[] { 3, 3 });
//
//table11ssr.setSpacingBefore(20f);
//table11ssr.setSpacingAfter(20f);
//
//PdfPCell cell30ssr = new PdfPCell(new Paragraph(
//"Is the College recognized by UGC as a College with Potential for Excellence(CPE)?"));
//table11ssr.addCell(cell30ssr);
//
//PdfPCell cell31ssr = new PdfPCell(new Paragraph(""));
//table11ssr.addCell(cell31ssr);
//
//PdfPCell cell32ssr = new PdfPCell(new Paragraph(
//"Is the College recognized for its performance by any other governmental agency?\r\n\r\n" + "\r\n"));
//table11ssr.addCell(cell32ssr);
//
//PdfPCell cell28ssr = new PdfPCell(new Paragraph(""));
//table11ssr.addCell(cell28ssr);
//
//PdfPCell cell29ssr = new PdfPCell(new Paragraph("If yes, name of the agency\r\n\r\n"));
//table11ssr.addCell(cell29ssr);
//
//PdfPCell cell131ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(37).getEvaluative_filePath() : ""));
//table11ssr.addCell(cell131ssr);
//
//PdfPCell cell132ssr = new PdfPCell(new Paragraph("Date of recognition\r\n\r\n"));
//table11ssr.addCell(cell132ssr);
//
//PdfPCell cell133ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(38).getEvaluative_filePath() : ""));
//table11ssr.addCell(cell133ssr);
//
//table011ssr.addCell(table11ssr);
//document.add(table011ssr);
//table011ssr.setSpacingAfter(20f);

PdfPTable table012ssr = new PdfPTable(1);
table012ssr.setWidthPercentage(100f);

PdfPCell cell012ssr = new PdfPCell(new Paragraph("\r\nLocation, Area and Activity of Campus\r\n\r\n", font3));
table012ssr.addCell(cell012ssr);

PdfPTable table12ssr = new PdfPTable(8);
table12ssr.setWidthPercentage(100f);

table012ssr.setSpacingAfter(20f);
table012ssr.setSpacingBefore(20f);

cell.setPhrase(new Phrase("\r\nCampus Type\r\n\r\n", font3));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nAddress\r\n\r\n", font3));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nLocation\r\n\r\n", font3));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nCampus Area in Acres\r\n\r\n", font3));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nBuilt up Area in sq.mts.\r\n\r\n", font3));
table12ssr.addCell(cell);

cell.setPhrase(new Phrase("\r\nProgrammes Offered\r\n", font3));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nDate of Establishment\r\n", font3));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nDate of\r\n"
+ "Recognition\r\n"
+ "by\r\n"
+ "UGC/MHRD ", font3));
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
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.campus.get(0).getInputbtl16():""));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.campus.get(0).getInputbtl17():""));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.campus.get(0).getInputbtl18():""));
table12ssr.addCell(cell);
cell.setPhrase(new Phrase());
table12ssr.addCell(cell);
cell.setPhrase(new Phrase());
table12ssr.addCell(cell);
cell.setPhrase(new Phrase());
table12ssr.addCell(cell);
cell.setPhrase(new Phrase());
table12ssr.addCell(cell);
cell.setPhrase(new Phrase());
table12ssr.addCell(cell);
cell.setPhrase(new Phrase());
table12ssr.addCell(cell);
cell.setPhrase(new Phrase());
table12ssr.addCell(cell);


cell.setPadding(5);

table012ssr.addCell(table12ssr);
document.add(table012ssr);


Paragraph paragraph15ssr = new Paragraph("\r\n2.2 ACADEMIC INFORMATION\r\n", font1);
paragraph15ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);


Paragraph paragraph151ssr = new Paragraph("\r\nInstitutions affiliated to the University (Not applicable for private and deemed to be \r\n"
+ "Universities)\r\n\r\n"
+ "", font3);
paragraph151ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph151ssr);

//PdfPCell cell013ssr = new PdfPCell(new Paragraph(
//"College Type \r\n\r\n", font3));
//table013ssr.addCell(cell013ssr);

PdfPTable table13ssr = new PdfPTable(3);
table13ssr.setWidthPercentage(100f);

table13ssr.setSpacingBefore(20f);
table13ssr.setSpacingAfter(20f);
cell.setPhrase(new Phrase("\r\nCollege Type\r\n", font3));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nNumber of colleges with permanent affiliation\r\n", font3));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nNumber of colleges with temporary affiliation\r\n", font3));
table13ssr.addCell(cell);
//cell.setPhrase(new Phrase("Duration in Months\r\n\r\n", font3));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase("Entry Qualification\r\n\r\n\r\n", font3));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase("Medium of Instruction\r\n\r\n", font3));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase("Sanctioned Strength\r\n\r\n", font3));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase("No.of Students AdmittedSanctioned Strength\r\n\r\n\r\n", font3));
//table13ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.auniversityAffiliated.get(0).getInputa1t1():""));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.auniversityAffiliated.get(0).getInputa1t2():""));
table13ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.auniversityAffiliated.get(0).getInputa1t3():""));
table13ssr.addCell(cell);


PdfPTable table013ssr = new PdfPTable(5);
table013ssr.setWidthPercentage(100f);
table013ssr.setSpacingBefore(20f);
table013ssr.setSpacingAfter(20f);

cell.setPhrase(new Phrase("\r\nType of Colleges\r\n\r\n ", font3));
table013ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nPermanent\r\n\r\n ", font3));
table013ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nTemporary \r\n\r\n", font3));
table013ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nTotal\r\n\r\n", font3));
table013ssr.addCell(cell);
cell.setPhrase(new Phrase(""));
table013ssr.addCell(cell);
cell.setPhrase(new Phrase("\r\nEducation/Teachers Training\r\n\r\n ", font3));
table013ssr.addCell(cell);

cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.auniversityAffiliated1.get(0).getInputa2t1():""));
table013ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.auniversityAffiliated1.get(0).getInputa2t2():""));
table013ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.auniversityAffiliated1.get(0).getInputa2t3():""));
table013ssr.addCell(cell);
cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.auniversityAffiliated1.get(0).getInputa2t4():""));
table013ssr.addCell(cell);

cell.setPhrase(new Phrase("Business administration/ \r\n"
+ "Commerce/Management/Finance\r\n\r\n ", font3));
table013ssr.addCell(cell);
cell.setPhrase(new Phrase());
table013ssr.addCell(cell);
cell.setPhrase(new Phrase());
table013ssr.addCell(cell);
cell.setPhrase(new Phrase());
table013ssr.addCell(cell);
cell.setPhrase(new Phrase());
table013ssr.addCell(cell);


cell.setPhrase(new Phrase("Universal/Common to all \r\n"
+ "Disciplines  \r\n\r\n", font3));
table013ssr.addCell(cell);

cell.setPhrase(new Phrase());
table013ssr.addCell(cell);
cell.setPhrase(new Phrase());
table013ssr.addCell(cell);
cell.setPhrase(new Phrase());
table013ssr.addCell(cell);
cell.setPhrase(new Phrase());
table013ssr.addCell(cell);

cell.setPadding(5);
//table013ssr.addCell(table13ssr);

document.add(table013ssr);


//cell.setPhrase(new Phrase("Total\r\n\r\n", font3));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(""));
//table13ssr.addCell(cell);
//
//
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(47).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(48).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(49).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(50).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(51).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(52).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(53).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(54).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(55).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(56).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(57).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(58).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(59).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(60).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(61).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(62).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(63).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(64).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(65).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(66).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(67).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(68).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(69).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(70).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(71).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(72).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(73).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(74).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(75).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(76).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(77).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(78).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(79).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(80).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(81).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(82).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(83).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(84).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(85).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(86).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(87).getEvaluative_filePath() : ""));
//table13ssr.addCell(cell);
//cell.setPhrase(new Phrase(ProfileRecord != null ? Profilefile.get(88).getEvaluative_filePath() : ""));
//
//


Paragraph paragraph16ssr1 = new Paragraph("Furnish the Details of Number of Colleges under the University\r\n",
font3);
paragraph16ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph16ssr1);

PdfPTable table171ssr = new PdfPTable(2);
table171ssr.setWidthPercentage(100);

table171ssr.setSpacingBefore(20f);
table171ssr.setSpacingAfter(20f);

PdfPCell cell0141ssr = new PdfPCell(new Paragraph("\r\nConstituent Colleges\r\n",font3));
table171ssr.addCell(cell0141ssr);

PdfPCell cell0142ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getUniversityColleges().get(0).getInputa3t1():""));
table171ssr.addCell(cell0142ssr);

PdfPCell cell0143ssr = new PdfPCell(new Paragraph("\r\nAffiliated Colleges\r\n"
,font3));
table171ssr.addCell(cell0143ssr);

PdfPCell cell0144ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getUniversityColleges().get(0).getInputa3t2():""));
table171ssr.addCell(cell0144ssr);

PdfPCell cell0145ssr = new PdfPCell(new Paragraph("\r\nColleges Under 2(f)\r\n\r\n",font3));
table171ssr.addCell(cell0145ssr);

PdfPCell cell0146ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getUniversityColleges().get(0).getInputa3t3():""));
table171ssr.addCell(cell0146ssr);

PdfPCell cell0147ssr = new PdfPCell(new Paragraph("\r\nColleges Under 2(f) and 12B\r\n\r\n",font3));
table171ssr.addCell(cell0147ssr);

PdfPCell cell0148ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getUniversityColleges().get(0).getInputa3t4():""));
table171ssr.addCell(cell0148ssr);

PdfPCell cell0149ssr = new PdfPCell(new Paragraph("\r\nNAAC Accredited Colleges\r\n"
,font3));
table171ssr.addCell(cell0149ssr);

PdfPCell cell0150ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getUniversityColleges().get(0).getInputa3t5():""));
table171ssr.addCell(cell0150ssr);

PdfPCell cell0151ssr = new PdfPCell(new Paragraph("Colleges with Potential for Excellence(UGC)\r\n\r\n",font3));
table171ssr.addCell(cell0151ssr);

PdfPCell cell0152ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getUniversityColleges().get(0).getInputa3t6():""));
table171ssr.addCell(cell0152ssr);

PdfPCell cell0153ssr = new PdfPCell(new Paragraph("Autonomous Colleges\r\n\r\n",font3));
table171ssr.addCell(cell0153ssr);

PdfPCell cell0154ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getUniversityColleges().get(0).getInputa3t7():""));
table171ssr.addCell(cell0154ssr);

PdfPCell cell0155ssr = new PdfPCell(new Paragraph("\r\nColleges with Postgraduate Departments\r\n\r\n",font3));
table171ssr.addCell(cell0155ssr);

PdfPCell cell0156ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getUniversityColleges().get(0).getInputa3t8():""));
table171ssr.addCell(cell0156ssr);

document.add(table171ssr);

PdfPTable table181ssr = new PdfPTable(2);


PdfPCell cell0157ssr = new PdfPCell(new Paragraph("\r\nColleges with Research Departments\r\n"
,font3));
table171ssr.addCell(cell0157ssr);

PdfPCell cell0158ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getUniversityColleges().get(0).getInputa3t9():""));
table171ssr.addCell(cell0158ssr);

PdfPCell cell0159ssr = new PdfPCell(new Paragraph("\r\nUniversity Recognized Research Institutes/Centers\r\n"
,font3));
table171ssr.addCell(cell0159ssr);

PdfPCell cell0160ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getUniversityColleges().get(0).getInputa3t10():""));
table171ssr.addCell(cell0160ssr);


document.add(table181ssr);

PdfPTable table182ssr = new PdfPTable(2);

PdfPCell cell0161ssr = new PdfPCell(new Paragraph("\r\nDoes the University offer any programmes recognized by any other statutory regulatory authority(SRA)\r\n\r\n",font3));
table171ssr.addCell(cell0161ssr);

PdfPCell cell0162ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getUniversityColleges().get(0).getInputa3t11():""));
table171ssr.addCell(cell0162ssr);

document.add(table182ssr);

//PdfPCell cell0164ssr = new PdfPCell(new Paragraph(""));
//table171ssr.addCell(cell0164ssr);
//document.add(table182ssr);
//

Paragraph paragraph18ssr1 = new Paragraph("\r\nDetails of the Number of Teaching & Non-Teaching Staff in the University\r\n",
font3);
paragraph18ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph18ssr1);

//Paragraph paragraph19ssr1 = new Paragraph("Teaching Faculty\r\n",
//font3);
//paragraph19ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//document.add(paragraph19ssr1);



PdfPTable table17ssr = new PdfPTable(13);
PdfPTable table18ssr = new PdfPTable(1);

float[] columnWidths = { 70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f }; // Second column will be // twice as first and third
table17ssr.setWidths(columnWidths);

// Setting width of table, its columns and spacing
table17ssr.setWidthPercentage(100);
table18ssr.setWidthPercentage(100);

PdfPCell cell014ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell015ssr = new PdfPCell(new Paragraph("\r\nProfessor\r\n"));
cell015ssr.setColspan(4);
PdfPCell cell0191ssr = new PdfPCell(new Paragraph("\r\nAssociate Professor\r\n"));
cell0191ssr.setColspan(4);
PdfPCell cell0237ssr = new PdfPCell(new Paragraph("\r\nAssistant Professor\r\n"));
cell0237ssr.setColspan(4);
PdfPCell cell0181ssr = new PdfPCell(new Paragraph(""));

// document.add(cell0192ssr);

PdfPCell cell0203ssr = new PdfPCell(new Paragraph("Male\r\n"));
PdfPCell cell0214ssr = new PdfPCell(new Paragraph("Female\r\n"));
PdfPCell cell0225ssr = new PdfPCell(new Paragraph("Others\r\n"));
PdfPCell cell0236ssr = new PdfPCell(new Paragraph("Total\r\n"));
PdfPCell cell0246ssr = new PdfPCell(new Paragraph("Male\r\n"));
PdfPCell cell0258ssr = new PdfPCell(new Paragraph("Female\r\n"));
PdfPCell cell0269ssr = new PdfPCell(new Paragraph("Others\r\n"));
PdfPCell cell0271ssr = new PdfPCell(new Paragraph("Total\r\n"));
PdfPCell cell0282ssr = new PdfPCell(new Paragraph("Male\r\n"));
PdfPCell cell0293ssr = new PdfPCell(new Paragraph("Female\r\n"));
PdfPCell cell0304ssr = new PdfPCell(new Paragraph("Others\r\n"));
PdfPCell cell0315ssr = new PdfPCell(new Paragraph("Total\r\n"));
PdfPCell cell0326ssr = new PdfPCell(new Paragraph("Sanctioned\r\n"));
PdfPCell cell0337sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat11():""));
cell0337sr.setColspan(4);

PdfPCell cell0372ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat12():""));
cell0372ssr.setColspan(4);

PdfPCell cell0383ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat13():""));
cell0383ssr.setColspan(4);
PdfPCell cell0394ssr = new PdfPCell(new Paragraph("Recruited\r\n"));
PdfPCell cell0405ssr = new PdfPCell(new Paragraph());
PdfPCell cell0416ssr = new PdfPCell(new Paragraph());
PdfPCell cell0427ssr = new PdfPCell(new Paragraph());
PdfPCell cell0438ssr = new PdfPCell(new Paragraph());
PdfPCell cell0449ssr = new PdfPCell(new Paragraph());
PdfPCell cell0451ssr = new PdfPCell(new Paragraph());
PdfPCell cell0452ssr = new PdfPCell(new Paragraph());
PdfPCell cell0453ssr = new PdfPCell(new Paragraph());
PdfPCell cell0454ssr = new PdfPCell(new Paragraph());
PdfPCell cell0455ssr = new PdfPCell(new Paragraph());
PdfPCell cell0456ssr = new PdfPCell(new Paragraph());
PdfPCell cell0457ssr = new PdfPCell(new Paragraph());

PdfPCell cell032612ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n"));

PdfPCell cell033722ssr = new PdfPCell(new Paragraph());

cell033722ssr.setColspan(4);

PdfPCell cell037212ssr = new PdfPCell(new Paragraph());

cell037212ssr.setColspan(4);

PdfPCell cell038312ssr = new PdfPCell(new Paragraph());

cell038312ssr.setColspan(4);

//PdfPCell cell03261ssr = new PdfPCell(
//new Paragraph("Sanctioned by the Management/Soci ety or Other Authorized Bodies"));
//
//PdfPCell cell03371ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(94).getEvaluative_filePath() : ""));
//
//cell03371ssr.setColspan(4);
//
//PdfPCell cell03721ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(95).getEvaluative_filePath() : ""));
//
//cell03721ssr.setColspan(4);
//
//PdfPCell cell03831ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(96).getEvaluative_filePath() : ""));

//	cell03831ssr.setColspan(4);
//PdfPCell cell03941ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(97).getEvaluative_filePath() : ""));
//PdfPCell cell04052ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(98).getEvaluative_filePath() : ""));
//PdfPCell cell04163ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(99).getEvaluative_filePath() : ""));
//PdfPCell cell04274ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(100).getEvaluative_filePath() : ""));
//PdfPCell cell04385ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(101).getEvaluative_filePath() : ""));
//PdfPCell cell04496ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(102).getEvaluative_filePath() : ""));
//PdfPCell cell04517ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(103).getEvaluative_filePath() : ""));
//PdfPCell cell04528ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(104).getEvaluative_filePath() : ""));
//PdfPCell cell04539ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(105).getEvaluative_filePath() : ""));
//PdfPCell cell04541ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(106).getEvaluative_filePath() : ""));
//PdfPCell cell04552ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(107).getEvaluative_filePath() : ""));
//PdfPCell cell04563ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(108).getEvaluative_filePath() : ""));
//PdfPCell cell04547ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(109).getEvaluative_filePath() : ""));

PdfPCell cell032611ssr = new PdfPCell(new Paragraph("Contractual\r\n"));

PdfPCell cell033721ssr = new PdfPCell(new Paragraph());

cell033721ssr.setColspan(4);

PdfPCell cell037213ssr = new PdfPCell(new Paragraph());

cell037213ssr.setColspan(4);

PdfPCell cell038314ssr = new PdfPCell(new Paragraph());

cell038314ssr.setColspan(4);

table17ssr.addCell(cell014ssr);
table17ssr.addCell(cell015ssr);
table17ssr.addCell(cell0191ssr);
table17ssr.addCell(cell0237ssr);
table17ssr.addCell(cell0181ssr);
// table17ssr.addCell(cell0192ssr);
table17ssr.addCell(cell0203ssr);
table17ssr.addCell(cell0214ssr);
table17ssr.addCell(cell0225ssr);
table17ssr.addCell(cell0236ssr);
table17ssr.addCell(cell0246ssr);
table17ssr.addCell(cell0258ssr);
table17ssr.addCell(cell0269ssr);
table17ssr.addCell(cell0271ssr);
table17ssr.addCell(cell0282ssr);
table17ssr.addCell(cell0293ssr);
table17ssr.addCell(cell0304ssr);
table17ssr.addCell(cell0315ssr);
table17ssr.addCell(cell0326ssr);
table17ssr.addCell(cell0337sr);
// table17ssr.addCell(cell0348sr);
// table17ssr.addCell(cell0359ssr);
// table17ssr.addCell(cell0361ssr);
table17ssr.addCell(cell0372ssr);
table17ssr.addCell(cell0383ssr);
table17ssr.addCell(cell0394ssr);
table17ssr.addCell(cell0405ssr);
table17ssr.addCell(cell0416ssr);
table17ssr.addCell(cell0427ssr);
table17ssr.addCell(cell0438ssr);
table17ssr.addCell(cell0449ssr);
table17ssr.addCell(cell0451ssr);
table17ssr.addCell(cell0452ssr);
table17ssr.addCell(cell0453ssr);
table17ssr.addCell(cell0454ssr);
table17ssr.addCell(cell0455ssr);
table17ssr.addCell(cell0456ssr);
table17ssr.addCell(cell0457ssr);

table17ssr.addCell(cell032612ssr);
table17ssr.addCell(cell033722ssr);
table17ssr.addCell(cell037212ssr);
table17ssr.addCell(cell038312ssr);

//table17ssr.addCell(cell03261ssr);
//table17ssr.addCell(cell033722ssr);
//table17ssr.addCell(cell03721ssr);
//table17ssr.addCell(cell03831ssr);
//
//table17ssr.addCell(cell03941ssr);
//table17ssr.addCell(cell04052ssr);
//table17ssr.addCell(cell04163ssr);
//table17ssr.addCell(cell04274ssr);
//table17ssr.addCell(cell04385ssr);
//table17ssr.addCell(cell04496ssr);
//table17ssr.addCell(cell04517ssr);
//table17ssr.addCell(cell04528ssr);
//table17ssr.addCell(cell04539ssr);
//table17ssr.addCell(cell04541ssr);
//table17ssr.addCell(cell04552ssr);
//table17ssr.addCell(cell04563ssr);
//table17ssr.addCell(cell04547ssr);

table17ssr.addCell(cell032611ssr);
table17ssr.addCell(cell033721ssr);
table17ssr.addCell(cell037213ssr);
table17ssr.addCell(cell038314ssr);


PdfPCell cell0189ssr = new PdfPCell(new Paragraph("\r\nTeaching Faculty\r\n",font3));

table18ssr.addCell(cell0189ssr);


table18ssr.addCell(table17ssr);

// cell015ssr.addElement(new Paragraph(""));
// cell015ssr.addElement(new Paragraph(""));
// cell015ssr.addElement(new Paragraph(""));
// cell015ssr.addElement(new Paragraph(""));

table18ssr.setSpacingBefore(20f);
table18ssr.setSpacingAfter(20f);

document.add(table18ssr);

PdfPTable table19ssr = new PdfPTable(5);
PdfPTable table20ssr = new PdfPTable(1);

float[] columnWidths1 = { 7f }; // Second column will be // twice as first and third
table20ssr.setWidths(columnWidths1);


//Setting width of table, its columns and spacing
table19ssr.setWidthPercentage(100);
table20ssr.setWidthPercentage(100);

PdfPCell cell018ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell019ssr = new PdfPCell(new Paragraph("Male\r\n"));
PdfPCell cell020ssr = new PdfPCell(new Paragraph("Female\r\n"));
PdfPCell cell021ssr = new PdfPCell(new Paragraph("Others\r\n"));
PdfPCell cell022ssr = new PdfPCell(new Paragraph("Total\r\n"));
PdfPCell cell0221ssr = new PdfPCell(new Paragraph("Sanctioned\r\n "));
//PdfPCell cell0222ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.nonTeachingStaff.get(0).getInputatnt11():""));
//PdfPCell cell0223ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.nonTeachingStaff.get(0).getInputatnt12():""));
//PdfPCell cell0224ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.nonTeachingStaff.get(0).getInputatnt13():""));
PdfPCell cell0227ssr = new PdfPCell(new Paragraph("Recruited\r\n"));
PdfPCell cell0228ssr = new PdfPCell(new Paragraph());
PdfPCell cell0229ssr = new PdfPCell(new Paragraph());
PdfPCell cell0230ssr = new PdfPCell(new Paragraph());
PdfPCell cell0231ssr = new PdfPCell(new Paragraph());
PdfPCell cell0232ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n"));
PdfPCell cell0233ssr = new PdfPCell(new Paragraph());
PdfPCell cell0234ssr = new PdfPCell(new Paragraph());
PdfPCell cell0235ssr = new PdfPCell(new Paragraph());
PdfPCell cell0238ssr = new PdfPCell(new Paragraph());
PdfPCell cell0239ssr = new PdfPCell(
new Paragraph("Contractual \r\n"));
PdfPCell cell0240ssr = new PdfPCell(new Paragraph());
PdfPCell cell0241ssr = new PdfPCell(new Paragraph());
PdfPCell cell0242ssr = new PdfPCell(new Paragraph());
PdfPCell cell0243ssr = new PdfPCell(new Paragraph());
//PdfPCell cell0244ssr = new PdfPCell(new Paragraph("Recruited"));
//PdfPCell cell0245ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(128).getEvaluative_filePath() : ""));
//PdfPCell cell0247ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(129).getEvaluative_filePath() : ""));
//PdfPCell cell0248ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(130).getEvaluative_filePath() : ""));
//PdfPCell cell0249ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(131).getEvaluative_filePath() : ""));
//PdfPCell cell0250ssr = new PdfPCell(new Paragraph("Yet to Recruit"));
//PdfPCell cell0251ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(132).getEvaluative_filePath() : ""));
//PdfPCell cell0252ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(133).getEvaluative_filePath() : ""));
//PdfPCell cell0253ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(134).getEvaluative_filePath() : ""));
//PdfPCell cell0254ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(135).getEvaluative_filePath() : ""));

table19ssr.addCell(cell018ssr);
table19ssr.addCell(cell019ssr);
table19ssr.addCell(cell020ssr);
table19ssr.addCell(cell021ssr);
table19ssr.addCell(cell022ssr);

table19ssr.addCell(cell0221ssr);
//table19ssr.addCell(cell0222ssr);
//table19ssr.addCell(cell0223ssr);
//table19ssr.addCell(cell0224ssr);


table19ssr.addCell(cell0227ssr);
table19ssr.addCell(cell0228ssr);
table19ssr.addCell(cell0229ssr);
table19ssr.addCell(cell0230ssr);
table19ssr.addCell(cell0231ssr);

table19ssr.addCell(cell0232ssr);
table19ssr.addCell(cell0233ssr);
table19ssr.addCell(cell0234ssr);
table19ssr.addCell(cell0235ssr);
table19ssr.addCell(cell0238ssr);
table19ssr.addCell(cell0239ssr);
table19ssr.addCell(cell0240ssr);
table19ssr.addCell(cell0241ssr);
table19ssr.addCell(cell0242ssr);
table19ssr.addCell(cell0243ssr);
//table19ssr.addCell(cell0244ssr);
//table19ssr.addCell(cell0245ssr);
//table19ssr.addCell(cell0247ssr);
//table19ssr.addCell(cell0248ssr);
//table19ssr.addCell(cell0249ssr);
//table19ssr.addCell(cell0250ssr);
//table19ssr.addCell(cell0251ssr);
//table19ssr.addCell(cell0252ssr);
//table19ssr.addCell(cell0253ssr);
//table19ssr.addCell(cell0254ssr);
//


PdfPCell cell0188ssr = new PdfPCell(new Paragraph("\r\nNon-Teaching Staff\r\n",font3));

table20ssr.addCell(cell0188ssr);

table20ssr.addCell(table19ssr);

table20ssr.setSpacingBefore(20f);
table20ssr.setSpacingAfter(20f);

document.add(table20ssr);

PdfPTable table21ssr = new PdfPTable(5);
PdfPTable table22ssr = new PdfPTable(1);

float[] columnWidths2 = { 7f }; // Second column will be // twice as first and third
table22ssr.setWidths(columnWidths2);

//Setting width of table, its columns and spacing
table21ssr.setWidthPercentage(100);
table22ssr.setWidthPercentage(100);

PdfPCell cell023ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell024ssr = new PdfPCell(new Paragraph("Male\r\n"));
PdfPCell cell025ssr = new PdfPCell(new Paragraph("Female\r\n"));
PdfPCell cell026ssr = new PdfPCell(new Paragraph("Others\r\n"));
PdfPCell cell027ssr = new PdfPCell(new Paragraph("Total\r\n"));

PdfPCell cell0023ssr = new PdfPCell(new Paragraph("Sanctioned\r\n "));
PdfPCell cell0123ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.technicalStaff.get(0).getInputatt15():""));
PdfPCell cell0323ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.technicalStaff.get(0).getInputatt16():""));
PdfPCell cell0423ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.technicalStaff.get(0).getInputatt17():""));
PdfPCell cell0523ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.technicalStaff.get(0).getInputatt18():""));


PdfPCell cell0623ssr = new PdfPCell(new Paragraph("Recruited\r\n"));
PdfPCell cell0723ssr = new PdfPCell(new Paragraph());
PdfPCell cell0823ssr = new PdfPCell(new Paragraph());
PdfPCell cell0923ssr = new PdfPCell(new Paragraph());
PdfPCell cell01023ssr = new PdfPCell(new Paragraph());

PdfPCell cell01123ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n"));
PdfPCell cell01223ssr = new PdfPCell(new Paragraph());
PdfPCell cell01323ssr = new PdfPCell(new Paragraph());
PdfPCell cell01423ssr = new PdfPCell(new Paragraph());
PdfPCell cell01523ssr = new PdfPCell(new Paragraph());

PdfPCell cell01623ssr = new PdfPCell(
new Paragraph("On Contract\r\n"));
PdfPCell cell01723ssr = new PdfPCell(new Paragraph());
PdfPCell cell01823ssr = new PdfPCell(new Paragraph());
PdfPCell cell01923ssr = new PdfPCell(new Paragraph());
PdfPCell cell02023ssr = new PdfPCell(new Paragraph());

//PdfPCell cell02123ssr = new PdfPCell(new Paragraph("Recruited"));
//PdfPCell cell02223ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(152).getEvaluative_filePath() : ""));
//PdfPCell cell02323ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(153).getEvaluative_filePath() : ""));
//PdfPCell cell02423ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(154).getEvaluative_filePath() : ""));
//PdfPCell cell02523ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(155).getEvaluative_filePath() : ""));
//
//PdfPCell cell02623ssr = new PdfPCell(new Paragraph("Yet to Recruit"));
//PdfPCell cell02723ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(156).getEvaluative_filePath() : ""));
//PdfPCell cell02823ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(157).getEvaluative_filePath() : ""));
//PdfPCell cell02923ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(158).getEvaluative_filePath() : ""));
//PdfPCell cell03023ssr = new PdfPCell(new Paragraph(ProfileRecord != null ? Profilefile.get(159).getEvaluative_filePath() : ""));

table21ssr.addCell(cell023ssr);
table21ssr.addCell(cell024ssr);
table21ssr.addCell(cell025ssr);
table21ssr.addCell(cell026ssr);
table21ssr.addCell(cell027ssr);

table21ssr.addCell(cell0023ssr);
table21ssr.addCell(cell0123ssr);
table21ssr.addCell(cell0323ssr);
table21ssr.addCell(cell0423ssr);
table21ssr.addCell(cell0523ssr);
table21ssr.addCell(cell0623ssr);
table21ssr.addCell(cell0723ssr);
table21ssr.addCell(cell0823ssr);
table21ssr.addCell(cell0923ssr);
table21ssr.addCell(cell01023ssr);
table21ssr.addCell(cell01123ssr);
table21ssr.addCell(cell01223ssr);
table21ssr.addCell(cell01323ssr);
table21ssr.addCell(cell01423ssr);
table21ssr.addCell(cell01523ssr);
table21ssr.addCell(cell01623ssr);
table21ssr.addCell(cell01723ssr);
table21ssr.addCell(cell01823ssr);
table21ssr.addCell(cell01923ssr);
table21ssr.addCell(cell02023ssr);
//table21ssr.addCell(cell02123ssr);
//table21ssr.addCell(cell02223ssr);
//table21ssr.addCell(cell02323ssr);
//table21ssr.addCell(cell02423ssr);
//table21ssr.addCell(cell02523ssr);
//table21ssr.addCell(cell02623ssr);
//table21ssr.addCell(cell02723ssr);
//table21ssr.addCell(cell02823ssr);
//table21ssr.addCell(cell02923ssr);
//table21ssr.addCell(cell03023ssr);



PdfPCell cell0187ssr = new PdfPCell(new Paragraph("\r\nTechnical Staff\r\n",font3));

table22ssr.addCell(cell0187ssr);

table22ssr.addCell(table21ssr);

table22ssr.setSpacingBefore(20f);
table22ssr.setSpacingAfter(20f);

document.add(table22ssr);

Paragraph paragraph19ssr = new Paragraph("\r\nQualification Details of the Teaching Staff\r\n", font3);
paragraph19ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
document.add(paragraph19ssr);

PdfPTable table23ssr = new PdfPTable(11);
PdfPTable table24ssr = new PdfPTable(1);

float[] columnWidths3 = { 70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f }; // Second column will be // twice as first and third
table23ssr.setWidths(columnWidths3);

//Setting width of table, its columns and spacing
table23ssr.setWidthPercentage(100);
table24ssr.setWidthPercentage(100);

PdfPCell cell028ssr = new PdfPCell(new Paragraph("\r\nHighest Qualification\r\n	"));
PdfPCell cell029ssr = new PdfPCell(new Paragraph("\r\nProfessor\r\n"));
cell029ssr.setColspan(3);
PdfPCell cell030ssr = new PdfPCell(new Paragraph("\r\nAssociate Professor\r\n"));
cell030ssr.setColspan(3);
PdfPCell cell031ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n"));
cell031ssr.setColspan(3);
PdfPCell cell032ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell0324ssr = new PdfPCell(new Paragraph(""));

PdfPCell cell0132ssr = new PdfPCell(new Paragraph("\r\nMale\r\n"));
PdfPCell cell0332ssr = new PdfPCell(new Paragraph("\r\nFemale\r\n"));
PdfPCell cell0432ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell0532ssr = new PdfPCell(new Paragraph("\r\nMale\r\n"));
PdfPCell cell0632ssr = new PdfPCell(new Paragraph("\r\nFemale\r\n"));
PdfPCell cell0732ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell0832ssr = new PdfPCell(new Paragraph("\r\nMale\r\n"));
PdfPCell cell0932ssr = new PdfPCell(new Paragraph("\r\nFemale\r\n"));
PdfPCell cell01032ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell01132ssr = new PdfPCell(new Paragraph("\r\ntotal\r\n"));

PdfPCell cell01232ssr = new PdfPCell(new Paragraph("D.sc/D.Litt/ LLD/DM/M CH\r\n"));
PdfPCell cell01332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq11():""));
PdfPCell cell01432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq12():""));
PdfPCell cell01532ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq13():""));

PdfPCell cell01632ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq14():""));
PdfPCell cell01732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq15():""));
PdfPCell cell01832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq16():""));

PdfPCell cell01932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq17():""));
PdfPCell cell02032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq18():""));
PdfPCell cell02132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq19():""));

PdfPCell cell02232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq110():""));

PdfPCell cell02332ssr = new PdfPCell(new Paragraph("\r\nPh.D.\r\n"));
PdfPCell cell02432ssr = new PdfPCell(new Paragraph());
PdfPCell cell02532ssr = new PdfPCell(new Paragraph());
PdfPCell cell02632ssr = new PdfPCell(new Paragraph());

PdfPCell cell02732ssr = new PdfPCell(new Paragraph());
PdfPCell cell02832ssr = new PdfPCell(new Paragraph());
PdfPCell cell02932ssr = new PdfPCell(new Paragraph());

PdfPCell cell03032ssr = new PdfPCell(new Paragraph());
PdfPCell cell03132ssr = new PdfPCell(new Paragraph());
PdfPCell cell03232ssr = new PdfPCell(new Paragraph());
PdfPCell cell03332ssr = new PdfPCell(new Paragraph());

PdfPCell cell034321ssr = new PdfPCell(new Paragraph("\r\nM.Phil.\r\n"));
PdfPCell cell03532ssr = new PdfPCell(new Paragraph());
PdfPCell cell03632ssr = new PdfPCell(new Paragraph());
PdfPCell cell03732ssr = new PdfPCell(new Paragraph());

PdfPCell cell03832ssr = new PdfPCell(new Paragraph());
PdfPCell cell03932ssr = new PdfPCell(new Paragraph());
PdfPCell cell04032ssr = new PdfPCell(new Paragraph());

PdfPCell cell04132ssr = new PdfPCell(new Paragraph());
PdfPCell cell04232ssr = new PdfPCell(new Paragraph());
PdfPCell cell04332ssr = new PdfPCell(new Paragraph());
PdfPCell cell04432ssr = new PdfPCell(new Paragraph());

PdfPCell cell04532ssr = new PdfPCell(new Paragraph("\r\nPG\r\n"));
PdfPCell cell04632ssr = new PdfPCell(new Paragraph());
PdfPCell cell04732ssr = new PdfPCell(new Paragraph());
PdfPCell cell04832ssr = new PdfPCell(new Paragraph());

PdfPCell cell04932ssr = new PdfPCell(new Paragraph());
PdfPCell cell05032ssr = new PdfPCell(new Paragraph());
PdfPCell cell05132ssr = new PdfPCell(new Paragraph());

PdfPCell cell05232ssr = new PdfPCell(new Paragraph());
PdfPCell cell05332ssr = new PdfPCell(new Paragraph());
PdfPCell cell05432ssr = new PdfPCell(new Paragraph());
PdfPCell cell05532ssr = new PdfPCell(new Paragraph());

//PdfPCell cell05632ssr = new PdfPCell(new Paragraph("UG"));
//PdfPCell cell05732ssr = new PdfPCell(new Paragraph());
//PdfPCell cell05832ssr = new PdfPCell(new Paragraph());
//PdfPCell cell05932ssr = new PdfPCell(new Paragraph());
//
//PdfPCell cell06032ssr = new PdfPCell(new Paragraph());
//PdfPCell cell06132ssr = new PdfPCell(new Paragraph());
//PdfPCell cell06232ssr = new PdfPCell(new Paragraph());
//
//PdfPCell cell06332ssr = new PdfPCell(new Paragraph());
//PdfPCell cell06432ssr = new PdfPCell(new Paragraph());
//PdfPCell cell06532ssr = new PdfPCell(new Paragraph());
//
//PdfPCell cell06632ssr = new PdfPCell(new Paragraph(""));

table23ssr.addCell(cell028ssr);
table23ssr.addCell(cell029ssr);
table23ssr.addCell(cell030ssr);
table23ssr.addCell(cell031ssr);
table23ssr.addCell(cell032ssr);
table23ssr.addCell(cell0324ssr);

table23ssr.addCell(cell0132ssr);
table23ssr.addCell(cell0332ssr);
table23ssr.addCell(cell0432ssr);
table23ssr.addCell(cell0532ssr);
table23ssr.addCell(cell0632ssr);
table23ssr.addCell(cell0732ssr);
table23ssr.addCell(cell0832ssr);
table23ssr.addCell(cell0932ssr);
table23ssr.addCell(cell01032ssr);
table23ssr.addCell(cell01132ssr);

table23ssr.addCell(cell01232ssr);
table23ssr.addCell(cell01332ssr);
table23ssr.addCell(cell01432ssr);
table23ssr.addCell(cell01532ssr);
table23ssr.addCell(cell01632ssr);
table23ssr.addCell(cell01732ssr);
table23ssr.addCell(cell01832ssr);
table23ssr.addCell(cell01932ssr);
table23ssr.addCell(cell02032ssr);
table23ssr.addCell(cell02132ssr);
table23ssr.addCell(cell02232ssr);

table23ssr.addCell(cell02332ssr);
table23ssr.addCell(cell02432ssr);
table23ssr.addCell(cell02532ssr);
table23ssr.addCell(cell02632ssr);
table23ssr.addCell(cell02732ssr);
table23ssr.addCell(cell02832ssr);
table23ssr.addCell(cell02932ssr);
table23ssr.addCell(cell03032ssr);
table23ssr.addCell(cell03132ssr);
table23ssr.addCell(cell03232ssr);
table23ssr.addCell(cell03332ssr);

table23ssr.addCell(cell04532ssr);
table23ssr.addCell(cell04632ssr);
table23ssr.addCell(cell04732ssr);
table23ssr.addCell(cell04832ssr);
table23ssr.addCell(cell04932ssr);
table23ssr.addCell(cell05032ssr);
table23ssr.addCell(cell05132ssr);
table23ssr.addCell(cell05232ssr);
table23ssr.addCell(cell05332ssr);
table23ssr.addCell(cell05432ssr);
table23ssr.addCell(cell05532ssr);

table23ssr.addCell(cell034321ssr);
table23ssr.addCell(cell03532ssr);
table23ssr.addCell(cell03632ssr);
table23ssr.addCell(cell03732ssr);
table23ssr.addCell(cell03832ssr);
table23ssr.addCell(cell03932ssr);
table23ssr.addCell(cell04032ssr);
table23ssr.addCell(cell04132ssr);
table23ssr.addCell(cell04232ssr);
table23ssr.addCell(cell04332ssr);
table23ssr.addCell(cell04432ssr);

//table23ssr.addCell(cell05632ssr);
//table23ssr.addCell(cell05732ssr);
//table23ssr.addCell(cell05832ssr);
//table23ssr.addCell(cell05932ssr);
//table23ssr.addCell(cell06032ssr);
//table23ssr.addCell(cell06132ssr);
//table23ssr.addCell(cell06232ssr);
//table23ssr.addCell(cell06332ssr);
//table23ssr.addCell(cell06432ssr);
//table23ssr.addCell(cell06532ssr);
//table23ssr.addCell(cell06632ssr);


PdfPCell cell0186ssr = new PdfPCell(new Paragraph("\r\nPermanent Teachers\r\n",font3));

table24ssr.addCell(cell0186ssr);


table24ssr.addCell(table23ssr);

table24ssr.setSpacingBefore(20f);
table24ssr.setSpacingAfter(20f);

document.add(table24ssr);

PdfPTable table27ssr = new PdfPTable(11);
PdfPTable table28ssr = new PdfPTable(1);

float[] columnWidth4 = { 7f }; // Second column will be // twice as first and third
table28ssr.setWidths(columnWidth4);


//Setting width of table, its columns and spacing
table27ssr.setWidthPercentage(100);
table28ssr.setWidthPercentage(100);

PdfPCell cell038ssr = new PdfPCell(new Paragraph("\r\nHighest Qualification\r\n	"));
PdfPCell cell039ssr = new PdfPCell(new Paragraph("\r\nProfessor\r\n"));
cell039ssr.setColspan(3);
PdfPCell cell040ssr = new PdfPCell(new Paragraph("\r\nAssociate Professor\r\n"));
cell040ssr.setColspan(3);
PdfPCell cell041ssr = new PdfPCell(new Paragraph("\r\nAssistant Professor\r\n"));
cell041ssr.setColspan(3);
PdfPCell cell042ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell0138ssr = new PdfPCell(new Paragraph(""));

PdfPCell cell000132ssr = new PdfPCell(new Paragraph("\r\nMale\r\n"));
PdfPCell cell000332ssr = new PdfPCell(new Paragraph("\r\nFemale\r\n"));
PdfPCell cell000432ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell000532ssr = new PdfPCell(new Paragraph("\r\nMale\r\n"));
PdfPCell cell000632ssr = new PdfPCell(new Paragraph("\r\nFemale\r\n"));
PdfPCell cell000732ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell000832ssr = new PdfPCell(new Paragraph("\r\nMale\r\n"));
PdfPCell cell000932ssr = new PdfPCell(new Paragraph("\r\nFemale\r\n"));
PdfPCell cell0001032ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell0001132ssr = new PdfPCell(new Paragraph("\r\ntotal\r\n"));

PdfPCell cell001232ssr = new PdfPCell(new Paragraph("\r\nD.sc/D.Litt/ LLD/DM/M CH\r\n"));

PdfPCell cell001332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq11():""));
PdfPCell cell001432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq12():""));
PdfPCell cell001532ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq13():""));

PdfPCell cell001632ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq14():""));
PdfPCell cell001732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq15():""));
PdfPCell cell001832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq16():""));

PdfPCell cell001932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq17():""));
PdfPCell cell002032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq18():""));
PdfPCell cell002132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq19():""));

PdfPCell cell002232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq110():""));


PdfPCell cell020332ssr = new PdfPCell(new Paragraph("\r\nPh.D.\r\n"));
PdfPCell cell020432ssr = new PdfPCell(new Paragraph());
PdfPCell cell020532ssr = new PdfPCell(new Paragraph());
PdfPCell cell020632ssr = new PdfPCell(new Paragraph());

PdfPCell cell020732ssr = new PdfPCell(new Paragraph());
PdfPCell cell020832ssr = new PdfPCell(new Paragraph());
PdfPCell cell020932ssr = new PdfPCell(new Paragraph());

PdfPCell cell030032ssr = new PdfPCell(new Paragraph());
PdfPCell cell031032ssr = new PdfPCell(new Paragraph());
PdfPCell cell032032ssr = new PdfPCell(new Paragraph());
PdfPCell cell033032ssr = new PdfPCell(new Paragraph());

PdfPCell cell034320ssr = new PdfPCell(new Paragraph("\r\nM.Phil.\r\n"));
PdfPCell cell035320ssr = new PdfPCell(new Paragraph());
PdfPCell cell036320ssr = new PdfPCell(new Paragraph());
PdfPCell cell037320ssr = new PdfPCell(new Paragraph());

PdfPCell cell038320ssr = new PdfPCell(new Paragraph());
PdfPCell cell039320ssr = new PdfPCell(new Paragraph());
PdfPCell cell040320ssr = new PdfPCell(new Paragraph());

PdfPCell cell041320ssr = new PdfPCell(new Paragraph());
PdfPCell cell042320ssr = new PdfPCell(new Paragraph());
PdfPCell cell043320ssr = new PdfPCell(new Paragraph());
PdfPCell cell044320ssr = new PdfPCell(new Paragraph());

PdfPCell cell045320ssr = new PdfPCell(new Paragraph("\r\nPG\r\n"));
PdfPCell cell046320ssr = new PdfPCell(new Paragraph());
PdfPCell cell047320ssr = new PdfPCell(new Paragraph());
PdfPCell cell048320ssr = new PdfPCell(new Paragraph());

PdfPCell cell049320ssr = new PdfPCell(new Paragraph());
PdfPCell cell050320ssr = new PdfPCell(new Paragraph());
PdfPCell cell051320ssr = new PdfPCell(new Paragraph());

PdfPCell cell052320ssr = new PdfPCell(new Paragraph());
PdfPCell cell053320ssr = new PdfPCell(new Paragraph());
PdfPCell cell054320ssr = new PdfPCell(new Paragraph());
PdfPCell cell055320ssr = new PdfPCell(new Paragraph());

PdfPCell cell056320ssr = new PdfPCell(new Paragraph("\r\nUG\r\n"));
PdfPCell cell057320ssr = new PdfPCell(new Paragraph());
PdfPCell cell058320ssr = new PdfPCell(new Paragraph());
PdfPCell cell059320ssr = new PdfPCell(new Paragraph());

PdfPCell cell060320ssr = new PdfPCell(new Paragraph());
PdfPCell cell061320ssr = new PdfPCell(new Paragraph());
PdfPCell cell062320ssr = new PdfPCell(new Paragraph());

PdfPCell cell063320ssr = new PdfPCell(new Paragraph());
PdfPCell cell064320ssr = new PdfPCell(new Paragraph());
PdfPCell cell065320ssr = new PdfPCell(new Paragraph());

PdfPCell cell066320ssr = new PdfPCell(new Paragraph());

table27ssr.addCell(cell038ssr);
table27ssr.addCell(cell039ssr);
table27ssr.addCell(cell040ssr);
table27ssr.addCell(cell041ssr);
table27ssr.addCell(cell042ssr);

table27ssr.addCell(cell0138ssr);

table27ssr.addCell(cell000132ssr);
table27ssr.addCell(cell000332ssr);
table27ssr.addCell(cell000432ssr);
table27ssr.addCell(cell000532ssr);
table27ssr.addCell(cell000632ssr);
table27ssr.addCell(cell000732ssr);
table27ssr.addCell(cell000832ssr);
table27ssr.addCell(cell000932ssr);
table27ssr.addCell(cell0001032ssr);
table27ssr.addCell(cell0001132ssr);

table27ssr.addCell(cell001232ssr);
table27ssr.addCell(cell001332ssr);
table27ssr.addCell(cell001432ssr);
table27ssr.addCell(cell001532ssr);
table27ssr.addCell(cell001632ssr);
table27ssr.addCell(cell001732ssr);
table27ssr.addCell(cell001832ssr);
table27ssr.addCell(cell001932ssr);
table27ssr.addCell(cell002032ssr);
table27ssr.addCell(cell002132ssr);
table27ssr.addCell(cell002232ssr);

table27ssr.addCell(cell020332ssr);
table27ssr.addCell(cell020432ssr);
table27ssr.addCell(cell020532ssr);
table27ssr.addCell(cell020632ssr);
table27ssr.addCell(cell020732ssr);
table27ssr.addCell(cell020832ssr);
table27ssr.addCell(cell020932ssr);
table27ssr.addCell(cell030032ssr);
table27ssr.addCell(cell031032ssr);
table27ssr.addCell(cell032032ssr);
table27ssr.addCell(cell033032ssr);

table27ssr.addCell(cell034320ssr);
table27ssr.addCell(cell035320ssr);
table27ssr.addCell(cell036320ssr);
table27ssr.addCell(cell037320ssr);
table27ssr.addCell(cell038320ssr);
table27ssr.addCell(cell039320ssr);
table27ssr.addCell(cell040320ssr);
table27ssr.addCell(cell041320ssr);
table27ssr.addCell(cell042320ssr);
table27ssr.addCell(cell043320ssr);
table27ssr.addCell(cell044320ssr);

table27ssr.addCell(cell045320ssr);
table27ssr.addCell(cell046320ssr);
table27ssr.addCell(cell047320ssr);
table27ssr.addCell(cell048320ssr);
table27ssr.addCell(cell049320ssr);
table27ssr.addCell(cell050320ssr);
table27ssr.addCell(cell051320ssr);
table27ssr.addCell(cell052320ssr);
table27ssr.addCell(cell053320ssr);
table27ssr.addCell(cell054320ssr);
table27ssr.addCell(cell055320ssr);

table27ssr.addCell(cell056320ssr);
table27ssr.addCell(cell057320ssr);
table27ssr.addCell(cell058320ssr);
table27ssr.addCell(cell059320ssr);
table27ssr.addCell(cell060320ssr);
table27ssr.addCell(cell061320ssr);
table27ssr.addCell(cell062320ssr);
table27ssr.addCell(cell063320ssr);
table27ssr.addCell(cell064320ssr);
table27ssr.addCell(cell065320ssr);
table27ssr.addCell(cell066320ssr);


PdfPCell cell0185ssr = new PdfPCell(new Paragraph("\r\nTemporary Teachers\r\n",font3));

table28ssr.addCell(cell0185ssr);
table28ssr.addCell(table27ssr);



table28ssr.setSpacingBefore(20f);
table28ssr.setSpacingAfter(20f);

document.add(table28ssr);

PdfPTable table29ssr = new PdfPTable(11);
PdfPTable table30ssr = new PdfPTable(1);

float[] columnWidth5 = { 7f }; // Second column will be // twice as first and third
table30ssr.setWidths(columnWidth5);


//Setting width of table, its columns and spacing
table29ssr.setWidthPercentage(100);
table30ssr.setWidthPercentage(100);

PdfPCell cell043ssr = new PdfPCell(new Paragraph("\r\nHighest Qualification	\r\n"));
PdfPCell cell044ssr = new PdfPCell(new Paragraph("\r\nProfessor\r\n"));
cell044ssr.setColspan(3);
PdfPCell cell045ssr = new PdfPCell(new Paragraph("\r\nAssociate Professor\r\n"));
cell045ssr.setColspan(3);
PdfPCell cell046ssr = new PdfPCell(new Paragraph("\r\nAssistant Professor\r\n"));
cell046ssr.setColspan(3);
PdfPCell cell048ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell04308ssr = new PdfPCell(new Paragraph(""));

PdfPCell cell0001320ssr = new PdfPCell(new Paragraph("\r\nMale\r\n"));
PdfPCell cell0003320ssr = new PdfPCell(new Paragraph("\r\nFemale\r\n"));
PdfPCell cell0004320ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell0005320ssr = new PdfPCell(new Paragraph("\r\nMale\r\n"));
PdfPCell cell0006320ssr = new PdfPCell(new Paragraph("\r\nFemale\r\n"));
PdfPCell cell0007320ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell0008320ssr = new PdfPCell(new Paragraph("\r\nMale\r\n"));
PdfPCell cell0009320ssr = new PdfPCell(new Paragraph("\r\nFemale\r\n"));
PdfPCell cell00010302ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell00011320ssr = new PdfPCell(new Paragraph("\r\ntotal\r\n"));

PdfPCell cell0012320ssr = new PdfPCell(new Paragraph("\r\nD.sc/D.Litt/ LLD/DM/M CH\r\n"));
PdfPCell cell0013320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq51():""));
PdfPCell cell0014320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq52():""));
PdfPCell cell0015320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq53():""));

PdfPCell cell0016320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq54():""));
PdfPCell cell0017320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq55():""));
PdfPCell cell0018320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq56():""));

PdfPCell cell0019320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq57():""));
PdfPCell cell0020320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq58():""));
PdfPCell cell0021320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq59():""));

PdfPCell cell0022320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq510():""));

PdfPCell cell0203320ssr = new PdfPCell(new Paragraph("\r\nPh.D.\r\n"));
PdfPCell cell0204320ssr = new PdfPCell(new Paragraph());
PdfPCell cell0205320ssr = new PdfPCell(new Paragraph());
PdfPCell cell0206320ssr = new PdfPCell(new Paragraph());
PdfPCell cell0207320ssr = new PdfPCell(new Paragraph());
PdfPCell cell0208320ssr = new PdfPCell(new Paragraph());
PdfPCell cell0209320ssr = new PdfPCell(new Paragraph());

PdfPCell cell0300320ssr = new PdfPCell(new Paragraph());
PdfPCell cell0310320ssr = new PdfPCell(new Paragraph());
PdfPCell cell0320320ssr = new PdfPCell(new Paragraph());
PdfPCell cell0330320ssr = new PdfPCell(new Paragraph());

PdfPCell cell0343200ssr = new PdfPCell(new Paragraph("\r\nM.Phil.\r\n"));
PdfPCell cell0353200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0363200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0373200ssr = new PdfPCell(new Paragraph());

PdfPCell cell0383200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0393200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0403200ssr = new PdfPCell(new Paragraph());

PdfPCell cell0413200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0423200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0433200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0443200ssr = new PdfPCell(new Paragraph());

PdfPCell cell0453200ssr = new PdfPCell(new Paragraph("\r\nPG\r\n"));
PdfPCell cell0463200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0473200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0483200ssr = new PdfPCell(new Paragraph());

PdfPCell cell0493200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0503200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0513200ssr = new PdfPCell(new Paragraph());

PdfPCell cell0523200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0533200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0543200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0553200ssr = new PdfPCell(new Paragraph());

PdfPCell cell0563200ssr = new PdfPCell(new Paragraph("\r\nUG\r\n"));
PdfPCell cell0573200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0583200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0593200ssr = new PdfPCell(new Paragraph());

PdfPCell cell0603200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0613200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0623200ssr = new PdfPCell(new Paragraph());

PdfPCell cell0633200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0643200ssr = new PdfPCell(new Paragraph());
PdfPCell cell0653200ssr = new PdfPCell(new Paragraph());

PdfPCell cell0663200ssr = new PdfPCell(new Paragraph());

table29ssr.addCell(cell043ssr);
table29ssr.addCell(cell044ssr);
table29ssr.addCell(cell045ssr);
table29ssr.addCell(cell046ssr);
table29ssr.addCell(cell048ssr);
table29ssr.addCell(cell04308ssr);

table29ssr.addCell(cell0001320ssr);
table29ssr.addCell(cell0003320ssr);
table29ssr.addCell(cell0004320ssr);
table29ssr.addCell(cell0005320ssr);
table29ssr.addCell(cell0006320ssr);
table29ssr.addCell(cell0007320ssr);
table29ssr.addCell(cell0008320ssr);
table29ssr.addCell(cell0009320ssr);
table29ssr.addCell(cell00010302ssr);
table29ssr.addCell(cell00011320ssr);

table29ssr.addCell(cell0012320ssr);
table29ssr.addCell(cell0013320ssr);
table29ssr.addCell(cell0014320ssr);
table29ssr.addCell(cell0015320ssr);
table29ssr.addCell(cell0016320ssr);
table29ssr.addCell(cell0017320ssr);
table29ssr.addCell(cell0018320ssr);
table29ssr.addCell(cell0019320ssr);
table29ssr.addCell(cell0020320ssr);
table29ssr.addCell(cell0021320ssr);
table29ssr.addCell(cell0022320ssr);

table29ssr.addCell(cell0203320ssr);
table29ssr.addCell(cell0204320ssr);
table29ssr.addCell(cell0205320ssr);
table29ssr.addCell(cell0206320ssr);
table29ssr.addCell(cell0207320ssr);
table29ssr.addCell(cell0208320ssr);
table29ssr.addCell(cell0209320ssr);
table29ssr.addCell(cell0300320ssr);
table29ssr.addCell(cell0310320ssr);
table29ssr.addCell(cell0320320ssr);
table29ssr.addCell(cell0330320ssr);

table29ssr.addCell(cell0343200ssr);
table29ssr.addCell(cell0353200ssr);
table29ssr.addCell(cell0363200ssr);
table29ssr.addCell(cell0373200ssr);
table29ssr.addCell(cell0383200ssr);
table29ssr.addCell(cell0393200ssr);
table29ssr.addCell(cell0403200ssr);
table29ssr.addCell(cell0413200ssr);
table29ssr.addCell(cell0423200ssr);
table29ssr.addCell(cell0433200ssr);
table29ssr.addCell(cell0443200ssr);

table29ssr.addCell(cell0453200ssr);
table29ssr.addCell(cell0463200ssr);
table29ssr.addCell(cell0473200ssr);
table29ssr.addCell(cell0483200ssr);
table29ssr.addCell(cell0493200ssr);
table29ssr.addCell(cell0503200ssr);
table29ssr.addCell(cell0513200ssr);
table29ssr.addCell(cell0523200ssr);
table29ssr.addCell(cell0533200ssr);
table29ssr.addCell(cell0543200ssr);
table29ssr.addCell(cell0553200ssr);

table29ssr.addCell(cell0563200ssr);
table29ssr.addCell(cell0573200ssr);
table29ssr.addCell(cell0583200ssr);
table29ssr.addCell(cell0593200ssr);
table29ssr.addCell(cell0603200ssr);
table29ssr.addCell(cell0613200ssr);
table29ssr.addCell(cell0623200ssr);
table29ssr.addCell(cell0633200ssr);
table29ssr.addCell(cell0643200ssr);
table29ssr.addCell(cell0653200ssr);
table29ssr.addCell(cell0663200ssr);



PdfPCell cell0184ssr = new PdfPCell(new Paragraph("\r\nPart Time Teachers\r\n",font3));

table30ssr.addCell(cell0184ssr);


table30ssr.addCell(table29ssr);

table30ssr.setSpacingBefore(20f);
table30ssr.setSpacingAfter(20f);

document.add(table30ssr);

Paragraph paragraph29110ssr = new Paragraph(
"Distinguished Academicians Appointed\r\n\r\n",
font3);
paragraph29110ssr.setAlignment(Paragraph.ALIGN_LEFT);
document.add(paragraph29110ssr);

PdfPTable table33ssr = new PdfPTable(5);

float[] columnWidth6 = { 7f }; // Second column will be // twice as first and third
// table34ssr.setWidths(columnWidth6);

//Setting width of table, its columns and spacing
table33ssr.setWidthPercentage(100);

PdfPCell cell054ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell055ssr = new PdfPCell(new Paragraph("\r\nMale\r\n"));
PdfPCell cell056ssr = new PdfPCell(new Paragraph("\r\nFemale\r\n"));
PdfPCell cell057ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell058ssr = new PdfPCell(new Paragraph("\r\nTotal\r\n"));
PdfPCell cell059ssr = new PdfPCell(new Paragraph("\r\nEmeritus Professor\r\n"));
PdfPCell cell060ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell061ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell062ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell063ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell064ssr = new PdfPCell(new Paragraph("\r\nAdjunct Professor\r\n"));
PdfPCell cell065ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell066ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell067ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell068ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell069ssr = new PdfPCell(new Paragraph("\r\nVisiting Professor\r\n"));
PdfPCell cell070ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell071ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell072ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell073ssr = new PdfPCell(new Paragraph(""));


table33ssr.addCell(cell054ssr);
table33ssr.addCell(cell055ssr);
table33ssr.addCell(cell056ssr);
table33ssr.addCell(cell057ssr);
table33ssr.addCell(cell058ssr);
table33ssr.addCell(cell059ssr);
table33ssr.addCell(cell060ssr);
table33ssr.addCell(cell061ssr);
table33ssr.addCell(cell062ssr);
table33ssr.addCell(cell063ssr);
table33ssr.addCell(cell064ssr);
table33ssr.addCell(cell065ssr);
table33ssr.addCell(cell066ssr);
table33ssr.addCell(cell067ssr);
table33ssr.addCell(cell068ssr);
table33ssr.addCell(cell069ssr);
table33ssr.addCell(cell070ssr);
table33ssr.addCell(cell071ssr);
table33ssr.addCell(cell072ssr);
table33ssr.addCell(cell073ssr);

table33ssr.setSpacingBefore(20f);
table33ssr.setSpacingAfter(20f);

document.add(table33ssr);

Paragraph paragraph2911ssr = new Paragraph(
"Chairs Instituted by the University\r\n\r\n",
font3);
paragraph2911ssr.setAlignment(Paragraph.ALIGN_LEFT);
document.add(paragraph2911ssr);

PdfPTable table34ssr = new PdfPTable(4);
table34ssr.setWidthPercentage(100);

PdfPCell cell074ssr = new PdfPCell(new Paragraph("\r\nSl.No",
font3));
PdfPCell cell075ssr = new PdfPCell(new Paragraph("\r\nName of the\r\n"
+ "Department",
font3));
PdfPCell cell076ssr = new PdfPCell(new Paragraph("\r\nName of the Chair",
font3));
PdfPCell cell077ssr = new PdfPCell(new Paragraph("\r\nName of the Sponsor\r\n"
+ "Organisation/Agency",
font3));		
PdfPCell cell078ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getInstitutedUniversity().get(0).getInputiut1():""));
PdfPCell cell079ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getInstitutedUniversity().get(0).getInputiut2():""));
PdfPCell cell080ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getInstitutedUniversity().get(0).getInputiut3():""));
PdfPCell cell081ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getInstitutedUniversity().get(0).getInputiut4():""));	

table34ssr.addCell(cell074ssr);
table34ssr.addCell(cell075ssr);
table34ssr.addCell(cell076ssr);
table34ssr.addCell(cell077ssr);
table34ssr.addCell(cell078ssr);
table34ssr.addCell(cell079ssr);
table34ssr.addCell(cell080ssr);
table34ssr.addCell(cell081ssr);

document.add(table34ssr);



//table34ssr.addCell("Details of Visting/Guest Faculties");

//table34ssr.addCell(table33ssr);

//table34ssr.setSpacingBefore(20f);
//table34ssr.setSpacingAfter(20f);


Paragraph paragraph291ssr = new Paragraph(
"Provide the Following Details of Students Enrolled in the University During the Current Academic Year",
font3);
paragraph291ssr.setAlignment(Paragraph.ALIGN_LEFT);
document.add(paragraph291ssr);


PdfPTable table35ssr = new PdfPTable(7);
table35ssr.setSpacingBefore(20f);
table35ssr.setSpacingAfter(20f);


// Setting width of table, its columns and spacing
table35ssr.setWidthPercentage(100);

PdfPCell cell0590ssr = new PdfPCell(new Paragraph("\r\nProgramme\r\n", font3));

cell0590ssr.setColspan(2);

PdfPCell cell0591ssr = new PdfPCell(new Paragraph("\r\nUG\r\n", font3));

cell0591ssr.setRowspan(3);

PdfPCell cell0592ssr = new PdfPCell(new Paragraph("\r\nmale\r\n"));
PdfPCell cell0593ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsEnrolled.get(0).getInputas00():""));
PdfPCell cell0594ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsEnrolled.get(0).getInputas11():""));
PdfPCell cell0595ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsEnrolled.get(0).getInputas12():""));
PdfPCell cell0596ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsEnrolled.get(0).getInputas13():""));
PdfPCell cell0597ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsEnrolled.get(0).getInputas14():""));

PdfPCell cell0599ssr = new PdfPCell(new Paragraph("\r\nfemale\r\n"));
PdfPCell cell05910ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05911ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05912ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05913ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05914ssr = new PdfPCell(new Paragraph(""));

PdfPCell cell05916ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell05917ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05918ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05919ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05920ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05921ssr = new PdfPCell(new Paragraph(""));

PdfPCell cell05923ssr = new PdfPCell(new Paragraph("\r\nPG\r\n", font3));

cell05923ssr.setRowspan(3);

PdfPCell cell05924ssr = new PdfPCell(new Paragraph("\r\nMale\r\n"));
PdfPCell cell05925ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05926ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05927ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05928ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05929ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05930ssr = new PdfPCell(new Paragraph("\r\nFemale\r\n"));
PdfPCell cell05931ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell059321ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05933ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05934ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05935ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05936ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell05937ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05938ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05939ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05940ssr = new PdfPCell(new Paragraph(""));
PdfPCell cell05941ssr = new PdfPCell(new Paragraph(""));
//PdfPCell cell05942ssr = new PdfPCell(new Paragraph(""));
//PdfPCell cell05943ssr = new PdfPCell(new Paragraph(""));


PdfPCell cell0601ssr = new PdfPCell(new Paragraph("\r\nFrom the State Where College is Located\r\n", font3));
PdfPCell cell0611ssr = new PdfPCell(new Paragraph("\r\nFrom Other States of India\r\n", font3));
PdfPCell cell0621ssr = new PdfPCell(new Paragraph("\r\nNRI Students\r\n", font3));
PdfPCell cell0631ssr = new PdfPCell(new Paragraph("\r\nForeign Students\r\n", font3));
PdfPCell cell0641ssr = new PdfPCell(new Paragraph("\r\nTotal\r\n", font3));


//table35ssr.addCell(cell0601ssr);
table35ssr.addCell(cell0601ssr);
table35ssr.addCell(cell0611ssr);
table35ssr.addCell(cell0621ssr);
table35ssr.addCell(cell0631ssr);
table35ssr.addCell(cell0641ssr);

table35ssr.addCell(cell0590ssr);
table35ssr.addCell(cell0591ssr);
table35ssr.addCell(cell0592ssr);
table35ssr.addCell(cell0593ssr);
table35ssr.addCell(cell0594ssr);
table35ssr.addCell(cell0595ssr);
table35ssr.addCell(cell0596ssr);
table35ssr.addCell(cell0597ssr);
//table35ssr.addCell(cell0598ssr);
table35ssr.addCell(cell0599ssr);
table35ssr.addCell(cell05910ssr);
table35ssr.addCell(cell05911ssr);
table35ssr.addCell(cell05912ssr);
table35ssr.addCell(cell05913ssr);
table35ssr.addCell(cell05914ssr);
//table35ssr.addCell(cell05915ssr);
table35ssr.addCell(cell05916ssr);
table35ssr.addCell(cell05917ssr);
table35ssr.addCell(cell05918ssr);
table35ssr.addCell(cell05919ssr);
table35ssr.addCell(cell05920ssr);
table35ssr.addCell(cell05921ssr);
// table35ssr.addCell(cell05922ssr);
table35ssr.addCell(cell05923ssr);
table35ssr.addCell(cell05924ssr);
table35ssr.addCell(cell05925ssr);
table35ssr.addCell(cell05926ssr);
table35ssr.addCell(cell05927ssr);
table35ssr.addCell(cell05928ssr);
table35ssr.addCell(cell05929ssr);
table35ssr.addCell(cell05930ssr);
table35ssr.addCell(cell05931ssr);
table35ssr.addCell(cell059321ssr);
table35ssr.addCell(cell05933ssr);
table35ssr.addCell(cell05934ssr);
table35ssr.addCell(cell05935ssr);
table35ssr.addCell(cell05936ssr);
table35ssr.addCell(cell05937ssr);
table35ssr.addCell(cell05938ssr);
table35ssr.addCell(cell05939ssr);
table35ssr.addCell(cell05940ssr);
table35ssr.addCell(cell05941ssr);
//table35ssr.addCell(cell05942ssr);
//table35ssr.addCell(cell05943ssr);

table35ssr.setSpacingBefore(20f);
table35ssr.setSpacingAfter(20f);

document.add(table35ssr);


PdfPCell cell0691ssr = new PdfPCell(new Paragraph(
"\r\nDoes the University offer any Integrated Programmes?\r\n\r\n"));
document.add(cell0691ssr);

PdfPTable table36ssr = new PdfPTable(2);
table36ssr.setWidthPercentage(100);
table36ssr.setSpacingBefore(20f);
table36ssr.setSpacingAfter(20f);

PdfPCell cell0651ssr = new PdfPCell(new Paragraph("\r\nTotal no of Integrated Programmes\r\n", font3));
PdfPCell cell0661ssr = new PdfPCell(new Paragraph());

table36ssr.addCell(cell0651ssr);
table36ssr.addCell(cell0661ssr);
//
//table37ssr.addCell(cell0691ssr);
//
//table37ssr.addCell(table36ssr);
//
//table37ssr.setSpacingBefore(20f);
//table37ssr.setSpacingAfter(20f);

document.add(table36ssr);

PdfPTable table37ssr = new PdfPTable(6);
table37ssr.setWidthPercentage(100);

table37ssr.setSpacingBefore(20f);
table37ssr.setSpacingAfter(20f);

PdfPCell cell06620ssr = new PdfPCell(new Paragraph("\r\nIntegrated Programmes\r\n"));
PdfPCell cell06621ssr = new PdfPCell(new Paragraph("\r\nFrom the state where the university is located\r\n"));
PdfPCell cell06622ssr = new PdfPCell(new Paragraph("\r\nFrom other states of india\r\n"));
PdfPCell cell06623ssr = new PdfPCell(new Paragraph("\r\nNRI Students\r\n"));
PdfPCell cell06624ssr = new PdfPCell(new Paragraph("\r\nForeign Students\r\n"));
PdfPCell cell06625ssr = new PdfPCell(new Paragraph("\r\nTotal\r\n"));
PdfPCell cell06626ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getIntegratedProgrammes().get(0).getInputult1():""));
PdfPCell cell06627ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getIntegratedProgrammes().get(0).getInputult2():""));
PdfPCell cell06628ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getIntegratedProgrammes().get(0).getInputult3():""));
PdfPCell cell06629ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getIntegratedProgrammes().get(0).getInputult4():""));
PdfPCell cell066210ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getIntegratedProgrammes().get(0).getInputult5():""));
PdfPCell cell066211ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getIntegratedProgrammes().get(0).getInputult6():""));
PdfPCell cell066212ssr = new PdfPCell(new Paragraph("\r\nFemale\r\n"));
PdfPCell cell066213ssr = new PdfPCell(new Paragraph());
PdfPCell cell066214ssr = new PdfPCell(new Paragraph());
PdfPCell cell066215ssr = new PdfPCell(new Paragraph());
PdfPCell cell066216ssr = new PdfPCell(new Paragraph());
PdfPCell cell066217ssr = new PdfPCell(new Paragraph());
PdfPCell cell066218ssr = new PdfPCell(new Paragraph("\r\nOthers\r\n"));
PdfPCell cell066219ssr = new PdfPCell(new Paragraph());
PdfPCell cell0662110ssr = new PdfPCell(new Paragraph());
PdfPCell cell0662111ssr = new PdfPCell(new Paragraph());
PdfPCell cell0662112ssr = new PdfPCell(new Paragraph());
PdfPCell cell0662113ssr = new PdfPCell(new Paragraph());

table37ssr.addCell(cell06620ssr);
table37ssr.addCell(cell06621ssr);
table37ssr.addCell(cell06622ssr);
table37ssr.addCell(cell06623ssr);
table37ssr.addCell(cell06624ssr);
table37ssr.addCell(cell06625ssr);
table37ssr.addCell(cell06626ssr);
table37ssr.addCell(cell06627ssr);
table37ssr.addCell(cell06628ssr);
table37ssr.addCell(cell06629ssr);

table37ssr.addCell(cell066210ssr);
table37ssr.addCell(cell066211ssr);
table37ssr.addCell(cell066212ssr);
table37ssr.addCell(cell066213ssr);
table37ssr.addCell(cell066214ssr);
table37ssr.addCell(cell066215ssr);
table37ssr.addCell(cell066216ssr);
table37ssr.addCell(cell066217ssr);
table37ssr.addCell(cell066218ssr);
table37ssr.addCell(cell066219ssr);
table37ssr.addCell(cell0662110ssr);
table37ssr.addCell(cell0662111ssr);
table37ssr.addCell(cell0662112ssr);
table37ssr.addCell(cell0662113ssr);

document.add(table37ssr);

Paragraph paragraph18ssr = new Paragraph("\r\nDetails of UGC Human Resource Development Centre, If applicable\r\n\r\n", font3);
paragraph18ssr.setAlignment(Paragraph.ALIGN_LEFT);

document.add(paragraph18ssr);

PdfPTable table141ssr = new PdfPTable(2);

table141ssr.setSpacingBefore(20f);
table141ssr.setSpacingAfter(20f);

table141ssr.setWidthPercentage(100f);
PdfPCell cell331ssr = new PdfPCell(new Paragraph("\r\nYear of Establishment\r\n"));
table141ssr.addCell(cell331ssr);
PdfPCell cell332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getHumanResourceDevelopment().get(0).getInputrdt1():""));
table141ssr.addCell(cell332ssr);
PdfPCell cell333ssr = new PdfPCell(new Paragraph("\r\nNumber of UGC Orientation Programmes\r\n"));
table141ssr.addCell(cell333ssr);
PdfPCell cell334ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getHumanResourceDevelopment().get(0).getInputrdt2():""));
table141ssr.addCell(cell334ssr);
PdfPCell cell335ssr = new PdfPCell(new Paragraph("\r\nNumber of UGC Refresher Course\r\n"));
table141ssr.addCell(cell335ssr);
PdfPCell cell336ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getHumanResourceDevelopment().get(0).getInputrdt3():""));
table141ssr.addCell(cell336ssr);
PdfPCell cell337ssr = new PdfPCell(new Paragraph("\r\nNumber of University's own Programmes\r\n"));
table141ssr.addCell(cell337ssr);
PdfPCell cell338ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getHumanResourceDevelopment().get(0).getInputrdt4():""));
table141ssr.addCell(cell338ssr);
PdfPCell cell339ssr = new PdfPCell(new Paragraph("\r\nTotal Number of Programmes Conducted (last five\r\n"
+ "years)\r\n"
));
table141ssr.addCell(cell339ssr);
PdfPCell cell3310ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getHumanResourceDevelopment().get(0).getInputrdt5():""));
table141ssr.addCell(cell3310ssr);

document.add(table141ssr);

Paragraph paragraph17ssr = new Paragraph("\r\nEVALUATIVE REPORT OF THE DEPARTMENTS\r\n\r\n", font3);
paragraph17ssr.setAlignment(Paragraph.ALIGN_LEFT);

document.add(paragraph17ssr);

PdfPTable table14ssr = new PdfPTable(2);


table14ssr.setSpacingBefore(20f);
table14ssr.setSpacingAfter(20f);

table14ssr.setWidthPercentage(100f);
table14ssr.setWidths(new int[] { 3, 3 });

PdfPCell cell33ssr = new PdfPCell(new Paragraph("\r\nDepartment Name\r\n", font3));
table14ssr.addCell(cell33ssr);

PdfPCell cell34ssr = new PdfPCell(new Paragraph("\r\nUpload Report\r\n", font3));
table14ssr.addCell(cell34ssr);

PdfPCell cell35ssr = new PdfPCell(new Paragraph("\r\nCivil Engineering\r\n"));
table14ssr.addCell(cell35ssr);

PdfPCell cell36ssr = new PdfPCell(new Paragraph());
table14ssr.addCell(cell36ssr);

PdfPCell cell37ssr = new PdfPCell(new Paragraph("\r\nComputer Science And EngineeringFile Description\r\n"));
table14ssr.addCell(cell37ssr);

PdfPCell cell38ssr = new PdfPCell(new Paragraph());
table14ssr.addCell(cell38ssr);

PdfPCell cell39ssr = new PdfPCell(new Paragraph("\r\nDepartment Of Management Studies\r\n"));
table14ssr.addCell(cell39ssr);

PdfPCell cell40ssr = new PdfPCell(new Paragraph());
table14ssr.addCell(cell40ssr);

PdfPCell cell41ssr = new PdfPCell(new Paragraph("\r\nElectrical And Electronics Engineering\r\n"));
table14ssr.addCell(cell41ssr);

PdfPCell cell42ssr = new PdfPCell(new Paragraph());
table14ssr.addCell(cell42ssr);

PdfPCell cell43ssr = new PdfPCell(new Paragraph("\r\nElectronics And Communication Engineering\r\n"));
table14ssr.addCell(cell43ssr);

PdfPCell cell44ssr = new PdfPCell(new Paragraph());
table14ssr.addCell(cell44ssr);

PdfPCell cell45ssr = new PdfPCell(new Paragraph("\r\nInformation Technology\r\n"));
table14ssr.addCell(cell45ssr);

PdfPCell cell46ssr = new PdfPCell(new Paragraph());
table14ssr.addCell(cell46ssr);

PdfPCell cell47ssr = new PdfPCell(new Paragraph("\r\nMechanical Engineering\r\n\r\n"));
table14ssr.addCell(cell47ssr);

PdfPCell cell48ssr = new PdfPCell(new Paragraph());
table14ssr.addCell(cell48ssr);

document.add(table14ssr);
table14ssr.setSpacingAfter(10f);

//Paragraph paragraph181ssr = new Paragraph("Institutional preparedness for NEP\r\n\r\n\r\n", font3);
//paragraph181ssr.setAlignment(Paragraph.ALIGN_LEFT);
//document.add(paragraph181ssr);
//
//PdfPTable table15ssr = new PdfPTable(2);
//
//table15ssr.setWidthPercentage(100f);
//table15ssr.setWidths(new int[] { 70, 70 });
//table15ssr.setSpacingBefore(20f);
//table15ssr.setSpacingAfter(20f);
//
//PdfPCell cell49ssr = new PdfPCell(new Paragraph("1. Multidisciplinary/interdisciplinary:\r\n\r\n"));
//
//table15ssr.addCell(cell49ssr);
//
//PdfPCell cell50ssr = new PdfPCell(new Paragraph(""));
//table15ssr.addCell(cell50ssr);
//
//PdfPCell cell51ssr = new PdfPCell(new Paragraph("2. Academic bank of credits (ABC):\r\n\r\n"));
//table15ssr.addCell(cell51ssr);
//PdfPCell cell52ssr = new PdfPCell(new Paragraph(""));
//table15ssr.addCell(cell52ssr);
//
//PdfPCell cell53ssr = new PdfPCell(new Paragraph("3. Skill development:\r\n\r\n"));
//table15ssr.addCell(cell53ssr);
//
//PdfPCell cell54ssr = new PdfPCell(new Paragraph(""));
//table15ssr.addCell(cell54ssr);
//
//PdfPCell cell55ssr = new PdfPCell(new Paragraph(
//"4. Appropriate integration of Indian Knowledge system  (teaching in Indian Language, culture, using online course",
//font3));
//table15ssr.addCell(cell55ssr);
//
//PdfPCell cell56ssr = new PdfPCell(new Paragraph(""));
//table15ssr.addCell(cell56ssr);
//
//PdfPCell cell57ssr = new PdfPCell(new Paragraph("5. Focus on Outcome based education (OBE):\r\n\r\n\r\n"));
//table15ssr.addCell(cell57ssr);
//
//PdfPCell cell58ssr = new PdfPCell(new Paragraph(""));
//table15ssr.addCell(cell58ssr);
//
//PdfPCell cell59ssr = new PdfPCell(new Paragraph("6. Distance education/online education:\r\n\r\n"));
//table15ssr.addCell(cell59ssr);
//
//PdfPCell cell60ssr = new PdfPCell(new Paragraph(""));
//table15ssr.addCell(cell60ssr);
//
//document.add(table15ssr);
//


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
