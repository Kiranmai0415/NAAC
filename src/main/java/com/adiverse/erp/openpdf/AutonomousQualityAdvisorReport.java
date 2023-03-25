package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTML.Tag;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria1_FileUpload;
import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.Criteria2_FileUpload;
import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.Criteria3_FileUpload;
import com.adiverse.erp.model.Criteria4_FieldInfo;
import com.adiverse.erp.model.Criteria4_FileUpload;
import com.adiverse.erp.model.Criteria5_FieldInfo;
import com.adiverse.erp.model.Criteria5_FileUpload;
import com.adiverse.erp.model.Criteria6_FieldInfo;
import com.adiverse.erp.model.Criteria6_FileUpload;
import com.adiverse.erp.model.Criteria7_FieldInfo;
import com.adiverse.erp.model.Criteria7_FileUpload;
import com.adiverse.erp.model.EvaluativeFileUpload;
import com.adiverse.erp.model.ExtendedProfile;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.service.Criteria1Service;
import com.adiverse.erp.service.Criteria2Service;
import com.adiverse.erp.service.Criteria3Service;
import com.adiverse.erp.service.Criteria4Service;
import com.adiverse.erp.service.Criteria5Service;
import com.adiverse.erp.service.Criteria6Service;
import com.adiverse.erp.service.Criteria7Service;
import com.adiverse.erp.service.ExtendedService;
import com.adiverse.erp.service.SsrService;
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
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.RGBColor;

@Component
public class AutonomousQualityAdvisorReport {

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

	// Font font4=FontFactory.getFont(FontFactory.HELVETICA);
	// font.setSize(16);

	// Font font5=FontFactory.getFont(FontFactory.HELVETICA);
	// font1.setSize(14);

	@Autowired
	Criteria1Service service1;
	@Autowired
	Criteria2Service service2;
	@Autowired
	Criteria3Service service3;
	@Autowired
	Criteria4Service service4;
	@Autowired
	Criteria5Service service5;
	@Autowired
	Criteria6Service service6;
	@Autowired
	Criteria7Service service7;
	@Autowired
	ExtendedService extendedService;
	@Autowired
	SsrService ssrService;

	List<Criteria1_FieldInfo> criteria1List = null;
	Criteria1_FieldInfo criteria1Record = null;
	List<Criteria1_FileUpload> criteria1file = null;

	List<Criteria2_FieldInfo> criteria2List = null;
	Criteria2_FieldInfo criteria2Record = null;
	List<Criteria2_FileUpload> criteria2file = null;

	List<Criteria3_FieldInfo> criteria3List = null;
	// Criteria3_FieldInfo criteria3_FieldInfoQn = null;
	Criteria3_FieldInfo criteria3Record = null;
	List<Criteria3_FileUpload> criteria3file = null;
//	List<Criteria3_FieldInfoQn> criteria3_FieldInfoQnList=null;
//	List<Criteria3_FieldInfoQl> criteria3_FieldInfoQlList=null;

	List<Criteria4_FieldInfo> criteria4List = null;
	Criteria4_FieldInfo criteria4Record = null;
	List<Criteria4_FileUpload> criteria4file = null;

	List<Criteria5_FieldInfo> criteria5List = null;
	Criteria5_FieldInfo criteria5Record = null;
	List<Criteria5_FileUpload> criterai5file = null;

	List<Criteria6_FieldInfo> criteria6List = null;
	Criteria6_FieldInfo criteria6Record = null;
	List<Criteria6_FileUpload> criteria6file = null;

	List<Criteria7_FieldInfo> criteria7List = null;
	Criteria7_FieldInfo criteria7Record = null;
	List<Criteria7_FileUpload> criteria7file = null;
	
	List<ProfileoftheCollege> profileList = null;
	ProfileoftheCollege ProfileRecord = null;
	List<EvaluativeFileUpload> Profilefile = null;

	List<ExtendedProfile> epList = null;
	ExtendedProfile epRecord = null;
	// List<Criteria7_FileUpload> criteria7file =
	// criteria7Record.getCriteria7FileUpload();

	public String generateReport(Map<String, String> allParams   ) throws DocumentException, IOException {
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

			criteria2List = service2.getAllCriteria2Data();
			if (CollectionUtils.isNotEmpty(criteria2List)) {
				criteria2Record = criteria2List.get(0);
				criteria2file = criteria2Record.getCriteria2FileUpload();
			} else {
				criteria2Record = new Criteria2_FieldInfo();
			}
			
//			List<Criteria3_FieldInfo> criteria3Record = null;
//			// Criteria3_FieldInfo criteria3_FieldInfoQn = null;
//			Criteria3_FieldInfo criteria3_FieldInfoQl = null;
//			List<Criteria3_FileUpload> criteria3file = null;

			criteria3List = service3.getAllCriteria3Data();
			if (CollectionUtils.isNotEmpty(criteria3List)) {
				
				criteria3Record=criteria3List.get(0);
				criteria3file = criteria3Record.getCriteria3FileUpload();
			} else {
				criteria3file = new ArrayList<>();
			}

			
			criteria4List = service4.getAllCriteria4Data();
			if (CollectionUtils.isNotEmpty(criteria4List)) {
				criteria4Record = criteria4List.get(0);
				criteria4file = criteria4Record.getCriteria4FileUpload();
			} else {
				criteria4Record = new Criteria4_FieldInfo();
				criteria4file = new ArrayList<>();
			}

			criteria5List = service5.getAllCriteria5Data();
			if (CollectionUtils.isNotEmpty(criteria5List)) {
				criteria5Record = criteria5List.get(0);
				criterai5file = criteria5Record.getCriteria5FileUpload();
			} else {
				criteria5Record = new Criteria5_FieldInfo();
				criterai5file = new ArrayList<>();
			}

			criteria6List = service6.getAllCriteria6Data();
			if (CollectionUtils.isNotEmpty(criteria6List)) {
				criteria6Record = criteria6List.get(0);
				criteria6file = criteria6Record.getCriteria6FileUpload();
			} else {
				criteria6Record = new Criteria6_FieldInfo();
				criteria6file = new ArrayList<>();
			}

			criteria7List = service7.getAllCriteria7Data();
			if (CollectionUtils.isNotEmpty(criteria7List)) {
				criteria7Record = criteria7List.get(0);
				criteria7file = criteria7Record.getCriteria7FileUpload();
			} else {
				criteria7Record = new Criteria7_FieldInfo();
				criteria7file = new ArrayList<>();

			}

			epList = extendedService.getAllExtendedData( allParams   );
			if (CollectionUtils.isNotEmpty(epList)) {
				epRecord = epList.get(0);
			} else {
				epRecord = new ExtendedProfile();
			}
			
			
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
				reportPath = "qualityAdivsorReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
			addLogo(document);
			Ssr(document);
			Extendprofile(document);
			Criteria1(document);
			Criteria2(document);
			Criteria3(document);
			Criteria4(document);
			Criteria5(document);
			Criteria6(document);
			Criteria7(document);

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

	public void Ssr(Document document) {

/////////////////////////////////////////////////////////
///////////////////// SSR SSR SSR SSR..................................
///////////////////////////////////////

// Creating font
// Setting font style and size
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

		Paragraph paragraph10ssr = new Paragraph("BANGALORE " , font3);
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

		Paragraph paragraph22ssr = new Paragraph(
				"Mother Teresa Institute of Science and Technology (MIST), Khammam -\r\n" + "\r\n", font5);
		Paragraph paragraph23ssr = new Paragraph(
				"was established in 2001. The college is an ISO 9001:2008 certified institute and is permanently affiliated to Jawaharlal Nehru Technological University, Hyderabad.\r\n"
						+ "\r\n" ,
				font5);
		Paragraph paragraph24ssr = new Paragraph(
				"Mother Teresa Institute of Science and Technology (MIST) was founded through MCM Educational Society in 2001 by eminent philanthropist,industrialists and schloars , MIST  aims at co-creating value-based technical excellence, which ultimately leads to the development of the rural area where the college is situated. From a modest intake of 180 students across 3 engineering programs in B.Tech, namely ECE, CSE, and IT, MIST, in less than 2 decades, it has grown into an institution of gigantic proportions with massive infrastructure, besides multitude of students, faculty & staff. At present, we offer 6 B.Tech programmes in CSE,  ECE, EEE, ME, CE, MNG., 5 M.Tech programmes such as CSE, Power Electronics and Drives ,ECE,Advance Manufacturing Systems,Structural Engg. in addition to M.B.A  programme as first shift and introduced 2nd shift diploma in A.Y:2009,with the Branches CE,EEE,ME,ECE and Mining. MIST has a vibrant campus spread over 30 acres of serene and natural surroundings with plenty of greenery in SATHUPALLY, Khammam  District, Telangana. It has world class infrastructure in all its academic departments, besides an asthetically-designed administrative block. The major facilities include  e-class rooms,  well-equipped laboratories,seminar halls ,well stocked library,WI-FI enabled campus,Backup power supply,Canteen etc. MIST was approved by All india Counsil for Technical Education AICTE New Delhi,  Affliated to Jawaharlal Nehru Technological University Hyderabad , JNTUH and State Board of Technical Education and Training SBTET Recognized by Govt.of Telangana, UGC under Section 2(f) and 12(B) and Accrediated by NAAC  with 'B' Grade. MIST has been recognized as a remote center of IIT BOMBAY and KARAGPUR for organizing FDP’S ,WORKSHOPS,QIP’S for students and faculty.We pride ourselves as an institution with a large pool of well-qualified and experienced faculty who not only enrich our teaching-learning sphere but also contribute to the R&D ecosystem. The promoters of the MIST started the college with a vision to empower students to become technologically vibrant, innovative and emotionally matured to face the dynamic challenges of a quality-conscious global economy. They are socially-conscious and respond proactively to the needs and requirements of this region on a continuous basis. The managing trust is involved in many charitable activities to help the needy and the poor of this region, thereby contribute towards social development of the region.\r\n\r\n",
				font5);

		paragraph22ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		paragraph23ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph22ssr);
		document.add(paragraph23ssr);

		paragraph24ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph24ssr);

		Paragraph paragraph25ssr = new Paragraph("VISION", font3);
		paragraph25ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph25ssr);

		Paragraph paragraph26ssr = new Paragraph(
				"To provide the society with center of learning that motivates, supports and encourages the youth to involve into dynamic professional with a social commitmenty.\r\n"
						+ "\r\n",
				font5);
		paragraph26ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph26ssr);

		Paragraph paragraph27ssr = new Paragraph("MISSION", font3);
		paragraph27ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr);

		Paragraph paragraph28ssr = new Paragraph(
				"We dedicate and commitment ourselves to achieve, sustain and    foster unmatched excellence in technical education.  To this end, we will pursue continuous development of infrastructure and enhance state of the art equipment to provide our students a technology up to date and intellectually inspiring environment of learning, research, creativity, innovation and professional activity, inculcate in them ethical and moral values. The institute is committed to build a better nation through quality education with team sprit. Our students are enable to excel values of life and become good citizens. We inspire the system, infrastructure and services to satisfy the students, parents, industry and society.\r\n"
						+ "\r\n" + "\r\n" + "\r\n",
				font5);
		paragraph28ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr);

		Paragraph paragraph13ssr = new Paragraph("2.PROFILE\r\n\r\n", font1);
		Paragraph paragraph14ssr = new Paragraph("2.1 BASIC INFORMATION\r\n", font2);
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

		PdfPCell cell4ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt2(): ""));
		table1ssr.addCell(cell4ssr);

		PdfPCell cell5ssr = new PdfPCell(new Paragraph("City"));
		table1ssr.addCell(cell5ssr);

	PdfPCell cell6ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbt3(): ""));
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
//		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtc7(): ""));
//		table2ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtc1(): ""));
//		table2ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtc1(): ""));
//		table2ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtc1(): ""));
//		table2ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtc1(): ""));
//		table2ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getBasicProfile().get(0).getInputbtc1(): ""));
//		table2ssr.addCell(cell);


		cell.setPadding(5);

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

		PdfPCell cell14ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getInstitutionCollegeAffiliated().get(0).getInputbti11(): ""));
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

		PdfPCell cell16ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getInstitutionCollegeAffiliated().get(0).getInputbti12(): ""));
		table4ssr.addCell(cell16ssr);

		PdfPCell cell17ssr = new PdfPCell(new Paragraph("By Shift\r\n\r\n"));
		table4ssr.addCell(cell17ssr);

		PdfPCell cell18ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getInstitutionCollegeAffiliated().get(0).getInputbti13(): ""));


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

		PdfPCell cell23ssr = new PdfPCell(new Paragraph("Date of Grant of 'Autonomy' to the college by UGC \r\n\r\n"));
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

		PdfPTable table7ssr = new PdfPTable(3);
		table7ssr.setWidthPercentage(100f);

		table7ssr.setSpacingBefore(20f);
		table7ssr.setSpacingAfter(20f);

		cell.setPhrase(new Phrase("State\r\n\r\n", font3));
		table7ssr.addCell(cell);
		cell.setPhrase(new Phrase("University name\r\n\r\n", font3));
		table7ssr.addCell(cell);
		cell.setPhrase(new Phrase("Document\r\n\r\n", font3));
		table7ssr.addCell(cell);

		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getInstitutionCollegeAffiliated().get(0).getInputbti11(): ""));
		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getInstitutionCollegeAffiliated().get(0).getInputbti11(): ""));
		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getInstitutionCollegeAffiliated().get(0).getInputbti11(): ""));

		cell.setPadding(5);

		table07ssr.addCell(table7ssr);
		document.add(table07ssr);
		table07ssr.setSpacingAfter(20f);
		table07ssr.setSpacingBefore(20f);

		PdfPTable table08ssr = new PdfPTable(1);
		table08ssr.setWidthPercentage(100f);

		PdfPCell cell121ssr = new PdfPCell(new Paragraph("Details of UGC recognition\r\n\r\n", font3));
		table08ssr.addCell(cell121ssr);

		PdfPTable table8ssr = new PdfPTable(3);
		table8ssr.setWidthPercentage(100f);
		table8ssr.setWidths(new int[] { 60, 60, 60 });
		
		table8ssr.setSpacingBefore(20f);
		table8ssr.setSpacingAfter(20f);


		cell.setPhrase(new Phrase("Under Section", font3));
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase("Date", font3));
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase("View Document", font3));
		table8ssr.addCell(cell);
		//<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
		
		cell.setPhrase(new Phrase("2f of UGC"));
		table8ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognizationDetails().get(0).getInputbtr6(): ""));
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase());
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase("12B of UGC"));
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognizationDetails().get(0).getInputbtr6(): ""));
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase());
		table8ssr.addCell(cell);

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

//		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd16():""));
//		table9ssr.addCell(cell);


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

		Paragraph paragraph15ssr = new Paragraph("2.2 ACADEMIC INFORMATION\r\n\r\n", font1);
		paragraph15ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph15ssr);
		PdfPTable table013ssr = new PdfPTable(1);
		table013ssr.setWidthPercentage(100f);
		table013ssr.setSpacingBefore(5);
		PdfPCell cell013ssr = new PdfPCell(new Paragraph(
				"Details of Programmes Offered by the College (Give Data for Current Academic year)", font3));
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

		Paragraph paragraph16ssr1 = new Paragraph("Position Details of Faculty & Staff in the College\r\n\r\n\r\n",
				font3);
		paragraph16ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph16ssr1);

		PdfPTable table17ssr = new PdfPTable(13);
		PdfPTable table18ssr = new PdfPTable(1);
		
		  float[] columnWidths = { 70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f }; // Second column will be // twice as first and third
		  table17ssr.setWidths(columnWidths);

      // Setting width of table, its columns and spacing
		table17ssr.setWidthPercentage(100);
		table18ssr.setWidthPercentage(100);

		PdfPCell cell014ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell015ssr = new PdfPCell(new Paragraph("Professor\r\n"));
		cell015ssr.setColspan(4);
		PdfPCell cell0191ssr = new PdfPCell(new Paragraph("Associate Professor\r\n"));
		cell0191ssr.setColspan(4);
		PdfPCell cell0237ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n"));
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
		PdfPCell cell0326ssr = new PdfPCell(new Paragraph("Sanctioned by the UGC/University State Government\r\n"));
		PdfPCell cell0337sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat11():""));
		cell0337sr.setColspan(4);

		PdfPCell cell0372ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat12():""));
		cell0372ssr.setColspan(4);

		PdfPCell cell0383ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat13():""));
		cell0383ssr.setColspan(4);
		PdfPCell cell0394ssr = new PdfPCell(new Paragraph("Recruited"));
		PdfPCell cell0405ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat14():""));
		PdfPCell cell0416ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat15():""));
		PdfPCell cell0427ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat16():""));
		PdfPCell cell0438ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat17():""));
		PdfPCell cell0449ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat18():""));
		PdfPCell cell0451ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat19():""));
		PdfPCell cell0452ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat10():""));
		PdfPCell cell0453ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat111():""));
		PdfPCell cell0454ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat112():""));
		PdfPCell cell0455ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat11():""));
		PdfPCell cell0456ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat11():""));
		PdfPCell cell0457ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicinstitution.get(0).getInputat11():""));

		PdfPCell cell032612ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n\r\n"));

		PdfPCell cell033722ssr = new PdfPCell(new Paragraph());

		cell033722ssr.setColspan(4);

		PdfPCell cell037212ssr = new PdfPCell(new Paragraph());

		cell037212ssr.setColspan(4);

		PdfPCell cell038312ssr = new PdfPCell(new Paragraph());

		cell038312ssr.setColspan(4);

		PdfPCell cell03261ssr = new PdfPCell(
				new Paragraph("Sanctioned by the Management/Soci ety or Other Authorized Bodies\r\n\r\n"));

		PdfPCell cell03371ssr = new PdfPCell(new Paragraph());

		cell03371ssr.setColspan(4);

		PdfPCell cell03721ssr = new PdfPCell(new Paragraph());

		cell03721ssr.setColspan(4);

		PdfPCell cell03831ssr = new PdfPCell(new Paragraph());

		cell03831ssr.setColspan(4);
		PdfPCell cell03941ssr = new PdfPCell(new Paragraph("Recruted\r\n"));
		PdfPCell cell04052ssr = new PdfPCell(new Paragraph());
		PdfPCell cell04163ssr = new PdfPCell(new Paragraph());
		PdfPCell cell04274ssr = new PdfPCell(new Paragraph());
		PdfPCell cell04385ssr = new PdfPCell(new Paragraph());
		PdfPCell cell04496ssr = new PdfPCell(new Paragraph());
		PdfPCell cell04517ssr = new PdfPCell(new Paragraph());
		PdfPCell cell04528ssr = new PdfPCell(new Paragraph());
		PdfPCell cell04539ssr = new PdfPCell(new Paragraph());
		PdfPCell cell04541ssr = new PdfPCell(new Paragraph());
		PdfPCell cell04552ssr = new PdfPCell(new Paragraph());
		PdfPCell cell04563ssr = new PdfPCell(new Paragraph());
		PdfPCell cell04547ssr = new PdfPCell(new Paragraph());

		PdfPCell cell032611ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n"));

		PdfPCell cell033721ssr = new PdfPCell(new Paragraph());

		cell033721ssr.setColspan(4);

		PdfPCell cell037213ssr = new PdfPCell(new Paragraph());

		cell037213ssr.setColspan(4);

		PdfPCell cell038314ssr = new PdfPCell(new Paragraph());

		cell038314ssr.setColspan(4);

		table17ssr.addCell(cell014ssr);
		table17ssr.addCell(cell015ssr);
		table17ssr.addCell(cell0237ssr);
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
//		table17ssr.addCell(cell0454ssr);
		table17ssr.addCell(cell0455ssr);
		table17ssr.addCell(cell0456ssr);
		table17ssr.addCell(cell0457ssr);

		table17ssr.addCell(cell032612ssr);
		table17ssr.addCell(cell033722ssr);
		table17ssr.addCell(cell037212ssr);
		table17ssr.addCell(cell038312ssr);

		table17ssr.addCell(cell03261ssr);
		table17ssr.addCell(cell033722ssr);
		table17ssr.addCell(cell03721ssr);
		table17ssr.addCell(cell03831ssr);

		table17ssr.addCell(cell03941ssr);
		table17ssr.addCell(cell04052ssr);
		table17ssr.addCell(cell04163ssr);
		table17ssr.addCell(cell04274ssr);
		table17ssr.addCell(cell04385ssr);
		table17ssr.addCell(cell04496ssr);
		table17ssr.addCell(cell04517ssr);
		table17ssr.addCell(cell04528ssr);
		table17ssr.addCell(cell04539ssr);
		table17ssr.addCell(cell04541ssr);
		table17ssr.addCell(cell04552ssr);
		table17ssr.addCell(cell04563ssr);
		table17ssr.addCell(cell04547ssr);

		table17ssr.addCell(cell032611ssr);
		table17ssr.addCell(cell033721ssr);
		table17ssr.addCell(cell037213ssr);
		table17ssr.addCell(cell038314ssr);

		
		PdfPCell cell0189ssr = new PdfPCell(new Paragraph("Teaching Faculty\r\n",font3));
		
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


// Setting width of table, its columns and spacing
		table19ssr.setWidthPercentage(100);
		table20ssr.setWidthPercentage(100);

		PdfPCell cell018ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell019ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell020ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell021ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell022ssr = new PdfPCell(new Paragraph("Total\r\n"));
		PdfPCell cell0221ssr = new PdfPCell(new Paragraph("Sanctioned by the UGC /University State Government\r\n\r\n"));
		PdfPCell cell0222ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.nonTeachingStaff.get(0).getInputatnt11():""));
		PdfPCell cell0223ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.nonTeachingStaff.get(0).getInputatnt12():""));
		PdfPCell cell0224ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.nonTeachingStaff.get(0).getInputatnt13():""));
		PdfPCell cell0226ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.nonTeachingStaff.get(0).getInputatnt14():""));
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
				new Paragraph("Sanctioned by the Management/Society or Other Authorized Bodies\r\n\r\n"));
		PdfPCell cell0240ssr = new PdfPCell(new Paragraph());
		PdfPCell cell0241ssr = new PdfPCell(new Paragraph());
		PdfPCell cell0242ssr = new PdfPCell(new Paragraph());
		PdfPCell cell0243ssr = new PdfPCell(new Paragraph());
		PdfPCell cell0244ssr = new PdfPCell(new Paragraph("Recruited\r\n"));
		PdfPCell cell0245ssr = new PdfPCell(new Paragraph());
		PdfPCell cell0247ssr = new PdfPCell(new Paragraph());
		PdfPCell cell0248ssr = new PdfPCell(new Paragraph());
		PdfPCell cell0249ssr = new PdfPCell(new Paragraph());
		PdfPCell cell0250ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n"));
		PdfPCell cell0251ssr = new PdfPCell(new Paragraph());
		PdfPCell cell0252ssr = new PdfPCell(new Paragraph());
		PdfPCell cell0253ssr = new PdfPCell(new Paragraph());
		PdfPCell cell0254ssr = new PdfPCell(new Paragraph());

		table19ssr.addCell(cell018ssr);
		table19ssr.addCell(cell019ssr);
		table19ssr.addCell(cell020ssr);
		table19ssr.addCell(cell021ssr);
		table19ssr.addCell(cell022ssr);

		table19ssr.addCell(cell0221ssr);
		table19ssr.addCell(cell0222ssr);
		table19ssr.addCell(cell0223ssr);
		table19ssr.addCell(cell0224ssr);
		table19ssr.addCell(cell0226ssr);

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
		table19ssr.addCell(cell0244ssr);
		table19ssr.addCell(cell0245ssr);
		table19ssr.addCell(cell0247ssr);
		table19ssr.addCell(cell0248ssr);
		table19ssr.addCell(cell0249ssr);
		table19ssr.addCell(cell0250ssr);
		table19ssr.addCell(cell0251ssr);
		table19ssr.addCell(cell0252ssr);
		table19ssr.addCell(cell0253ssr);
		table19ssr.addCell(cell0254ssr);


		
        PdfPCell cell0188ssr = new PdfPCell(new Paragraph("Non-Teaching Staff\r\n",font3));
		
        table20ssr.addCell(cell0188ssr);

		table20ssr.addCell(table19ssr);

		table20ssr.setSpacingBefore(20f);
		table20ssr.setSpacingAfter(20f);

		document.add(table20ssr);

		PdfPTable table21ssr = new PdfPTable(5);
		PdfPTable table22ssr = new PdfPTable(1);
		
		 float[] columnWidths2 = { 7f }; // Second column will be // twice as first and third
		 table22ssr.setWidths(columnWidths2);

// Setting width of table, its columns and spacing
		table21ssr.setWidthPercentage(100);
		table22ssr.setWidthPercentage(100);

		PdfPCell cell023ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell024ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell025ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell026ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell027ssr = new PdfPCell(new Paragraph("Total\r\n"));

		PdfPCell cell0023ssr = new PdfPCell(new Paragraph("Sanctioned by the UGC /University State Government\r\n"));
		//PdfPCell cell0123ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.technicalStaff(0).getInputatt15():""));
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
				new Paragraph("Sanctioned by the Management/Society or Other Authorized Bodies\r\n"));
		PdfPCell cell01723ssr = new PdfPCell(new Paragraph());
		PdfPCell cell01823ssr = new PdfPCell(new Paragraph());
		PdfPCell cell01923ssr = new PdfPCell(new Paragraph());
		PdfPCell cell02023ssr = new PdfPCell(new Paragraph());

		PdfPCell cell02123ssr = new PdfPCell(new Paragraph("Recruited\r\n"));
		PdfPCell cell02223ssr = new PdfPCell(new Paragraph());
		PdfPCell cell02323ssr = new PdfPCell(new Paragraph());
		PdfPCell cell02423ssr = new PdfPCell(new Paragraph());
		PdfPCell cell02523ssr = new PdfPCell(new Paragraph());

		PdfPCell cell02623ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n"));
		PdfPCell cell02723ssr = new PdfPCell(new Paragraph());
		PdfPCell cell02823ssr = new PdfPCell(new Paragraph());
		PdfPCell cell02923ssr = new PdfPCell(new Paragraph());
		PdfPCell cell03023ssr = new PdfPCell(new Paragraph());

		table21ssr.addCell(cell023ssr);
		table21ssr.addCell(cell024ssr);
		table21ssr.addCell(cell025ssr);
		table21ssr.addCell(cell026ssr);
		table21ssr.addCell(cell027ssr);

		table21ssr.addCell(cell0023ssr);
		//table21ssr.addCell(cell0123ssr);
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
		table21ssr.addCell(cell02123ssr);
		table21ssr.addCell(cell02223ssr);
		table21ssr.addCell(cell02323ssr);
		table21ssr.addCell(cell02423ssr);
		table21ssr.addCell(cell02523ssr);
		table21ssr.addCell(cell02623ssr);
		table21ssr.addCell(cell02723ssr);
		table21ssr.addCell(cell02823ssr);
		table21ssr.addCell(cell02923ssr);
		table21ssr.addCell(cell03023ssr);

	
		
	   PdfPCell cell0187ssr = new PdfPCell(new Paragraph("Technical Staff\r\n",font3));
			
	   table22ssr.addCell(cell0187ssr);

		table22ssr.addCell(table21ssr);

		table22ssr.setSpacingBefore(20f);
		table22ssr.setSpacingAfter(20f);

		document.add(table22ssr);

		Paragraph paragraph19ssr = new Paragraph("Qualification Details of the Teaching Staff\r\n", font3);
		paragraph19ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph19ssr);

		PdfPTable table23ssr = new PdfPTable(11);
		PdfPTable table24ssr = new PdfPTable(1);
		
		 float[] columnWidths3 = { 70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f }; // Second column will be // twice as first and third
		 table23ssr.setWidths(columnWidths3);
		 
// Setting width of table, its columns and spacing
		table23ssr.setWidthPercentage(100);
		table24ssr.setWidthPercentage(100);

		PdfPCell cell028ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n	"));
		PdfPCell cell029ssr = new PdfPCell(new Paragraph("Professor\r\n"));
		cell029ssr.setColspan(3);
		PdfPCell cell030ssr = new PdfPCell(new Paragraph("Associate Professor\r\n"));
		cell030ssr.setColspan(3);
		PdfPCell cell031ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n"));
		cell031ssr.setColspan(3);
		PdfPCell cell032ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0324ssr = new PdfPCell(new Paragraph(""));

		PdfPCell cell0132ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell0332ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell0432ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell0532ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell0632ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell0732ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell0832ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell0932ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell01032ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell01132ssr = new PdfPCell(new Paragraph("total\r\n"));

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

		PdfPCell cell02332ssr = new PdfPCell(new Paragraph("Ph.D.\r\n"));
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

		PdfPCell cell034321ssr = new PdfPCell(new Paragraph("M.Phil.\r\n"));
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

		PdfPCell cell04532ssr = new PdfPCell(new Paragraph("PG\r\n"));
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

		PdfPCell cell05632ssr = new PdfPCell(new Paragraph("UG\r\n"));
		PdfPCell cell05732ssr = new PdfPCell(new Paragraph());
		PdfPCell cell05832ssr = new PdfPCell(new Paragraph());
		PdfPCell cell05932ssr = new PdfPCell(new Paragraph());

		PdfPCell cell06032ssr = new PdfPCell(new Paragraph());
		PdfPCell cell06132ssr = new PdfPCell(new Paragraph());
		PdfPCell cell06232ssr = new PdfPCell(new Paragraph());

		PdfPCell cell06332ssr = new PdfPCell(new Paragraph());
		PdfPCell cell06432ssr = new PdfPCell(new Paragraph());
		PdfPCell cell06532ssr = new PdfPCell(new Paragraph());

		PdfPCell cell06632ssr = new PdfPCell(new Paragraph());

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

		table23ssr.addCell(cell05632ssr);
		table23ssr.addCell(cell05732ssr);
		table23ssr.addCell(cell05832ssr);
		table23ssr.addCell(cell05932ssr);
		table23ssr.addCell(cell06032ssr);
		table23ssr.addCell(cell06132ssr);
		table23ssr.addCell(cell06232ssr);
		table23ssr.addCell(cell06332ssr);
		table23ssr.addCell(cell06432ssr);
		table23ssr.addCell(cell06532ssr);
		table23ssr.addCell(cell06632ssr);


		 PdfPCell cell0186ssr = new PdfPCell(new Paragraph("Permanent Teachers\r\n",font3));
			
		 table24ssr.addCell(cell0186ssr);

//
		table24ssr.addCell(table23ssr);

		table24ssr.setSpacingBefore(20f);
		table24ssr.setSpacingAfter(20f);

		document.add(table24ssr);

		PdfPTable table27ssr = new PdfPTable(11);
		PdfPTable table28ssr = new PdfPTable(1);
		
		 float[] columnWidth4 = { 7f }; // Second column will be // twice as first and third
		 table28ssr.setWidths(columnWidth4);


// Setting width of table, its columns and spacing
		table27ssr.setWidthPercentage(100);
		table28ssr.setWidthPercentage(100);

		PdfPCell cell038ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n"));
		PdfPCell cell039ssr = new PdfPCell(new Paragraph("Professor\r\n"));
		cell039ssr.setColspan(3);
		PdfPCell cell040ssr = new PdfPCell(new Paragraph("Associate Professor\r\n"));
		cell040ssr.setColspan(3);
		PdfPCell cell041ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n"));
		cell041ssr.setColspan(3);
		PdfPCell cell042ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0138ssr = new PdfPCell(new Paragraph(""));

		PdfPCell cell000132ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell000332ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell000432ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell000532ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell000632ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell000732ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell000832ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell000932ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell0001032ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell0001132ssr = new PdfPCell(new Paragraph("total\r\n"));

		PdfPCell cell001232ssr = new PdfPCell(new Paragraph("D.sc/D.Litt/ LLD/DM/M CH\r\n"));
		PdfPCell cell001332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq51():""));
		PdfPCell cell001432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq52():""));
		PdfPCell cell001532ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq53():""));

		PdfPCell cell001632ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq54():""));
		PdfPCell cell001732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq55():""));
		PdfPCell cell001832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq56():""));

		PdfPCell cell001932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq57():""));
		PdfPCell cell002032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq58():""));
		PdfPCell cell002132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq59():""));

		PdfPCell cell002232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicTemporaryTeachers.get(0).getInputatq510():""));

		PdfPCell cell020332ssr = new PdfPCell(new Paragraph("Ph.D.\r\n"));
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

		PdfPCell cell034320ssr = new PdfPCell(new Paragraph("M.Phil.\r\n"));
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

		PdfPCell cell045320ssr = new PdfPCell(new Paragraph("PG\r\n"));
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

		PdfPCell cell056320ssr = new PdfPCell(new Paragraph("UG\r\n"));
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

		
		 PdfPCell cell0185ssr = new PdfPCell(new Paragraph("Temporary Teachers\r\n",font3));
			
		 table28ssr.addCell(cell0185ssr);
	
		 table28ssr.addCell(table27ssr);
			
		table28ssr.setSpacingBefore(20f);
		table28ssr.setSpacingAfter(20f);

		document.add(table28ssr);

		PdfPTable table29ssr = new PdfPTable(11);
		PdfPTable table30ssr = new PdfPTable(1);
		
		 float[] columnWidth5 = { 7f }; // Second column will be // twice as first and third
		 table30ssr.setWidths(columnWidth5);


// Setting width of table, its columns and spacing
		table29ssr.setWidthPercentage(100);
		table30ssr.setWidthPercentage(100);

		PdfPCell cell043ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n"));
		PdfPCell cell044ssr = new PdfPCell(new Paragraph("Professor\r\n"));
		cell044ssr.setColspan(3);
		PdfPCell cell045ssr = new PdfPCell(new Paragraph("Associate Professor\r\n"));
		cell045ssr.setColspan(3);
		PdfPCell cell046ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n"));
		cell046ssr.setColspan(3);
		PdfPCell cell048ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell04308ssr = new PdfPCell(new Paragraph(""));

		PdfPCell cell0001320ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell0003320ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell0004320ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell0005320ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell0006320ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell0007320ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell0008320ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell0009320ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell00010302ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell00011320ssr = new PdfPCell(new Paragraph("total\r\n"));

		PdfPCell cell0012320ssr = new PdfPCell(new Paragraph("D.sc/D.Litt/ LLD/DM/M CH"));
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

		PdfPCell cell0203320ssr = new PdfPCell(new Paragraph("Ph.D.\r\n"));
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

		PdfPCell cell0343200ssr = new PdfPCell(new Paragraph("M.Phil.\r\n"));
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

		PdfPCell cell0453200ssr = new PdfPCell(new Paragraph("PG\r\n"));
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

		PdfPCell cell0563200ssr = new PdfPCell(new Paragraph("UG\r\n"));
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

	
	
		 PdfPCell cell0184ssr = new PdfPCell(new Paragraph("Part Time Teachers\r\n",font3));
			
		 table30ssr.addCell(cell0184ssr);
	

		table30ssr.addCell(table29ssr);

		table30ssr.setSpacingBefore(20f);
		table30ssr.setSpacingAfter(20f);

		document.add(table30ssr);

		PdfPTable table33ssr = new PdfPTable(5);
		PdfPTable table34ssr = new PdfPTable(1);
		
	 float[] columnWidth6 = { 7f }; // Second column will be // twice as first and third
		 table34ssr.setWidths(columnWidth6);

     // Setting width of table, its columns and spacing
		table33ssr.setWidthPercentage(100);
		table34ssr.setWidthPercentage(100);

		PdfPCell cell054ssr = new PdfPCell(new Paragraph("Number of Visiting/Guest Faculty engaged with the college?\r\n",font3));
		
		cell054ssr.setRowspan(2);
		
		
     	PdfPCell cell055ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell0551ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.detailsofVisitingFaculties.get(0).getInputatg11():""));
		PdfPCell cell056ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell0561ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.detailsofVisitingFaculties.get(0).getInputatg12():""));
    	PdfPCell cell057ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell0571ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.detailsofVisitingFaculties.get(0).getInputatg13():""));
		
    	PdfPCell cell058ssr = new PdfPCell(new Paragraph("Total\r\n"));
		PdfPCell cell0581ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.detailsofVisitingFaculties.get(0).getInputatg14():""));
		

     	table33ssr.addCell(cell054ssr);
		table33ssr.addCell(cell055ssr);
		table33ssr.addCell(cell0551ssr);
		table33ssr.addCell(cell056ssr);
		table33ssr.addCell(cell0561ssr);
    	table33ssr.addCell(cell057ssr);
    	table33ssr.addCell(cell0571ssr);
		table33ssr.addCell(cell058ssr);
		table33ssr.addCell(cell0581ssr);


		PdfPCell cell05810ssr = new PdfPCell(new Paragraph("Details of Visting/Guest Faculties\r\n",font3));
		table34ssr.addCell(cell05810ssr);
		table34ssr.addCell(table33ssr);

		table34ssr.setSpacingBefore(20f);
		table34ssr.setSpacingAfter(20f);

		document.add(table34ssr);

		Paragraph paragraph29ssr = new Paragraph(
				"Provide the Following Details of Students Enrolled in the College During the Current Academic Year\r\n",
				font3);
		paragraph29ssr.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(paragraph29ssr);

		PdfPTable table35ssr = new PdfPTable(7);
		


// Setting width of table, its columns and spacing
		table35ssr.setWidthPercentage(100);

		PdfPCell cell059ssr = new PdfPCell(new Paragraph("Programme\r\n	", font3));
		
		cell059ssr.setColspan(2);

		PdfPCell cell0591ssr = new PdfPCell(new Paragraph("UG\r\n", font3));
		
		cell0591ssr.setRowspan(3);

		PdfPCell cell0592ssr = new PdfPCell(new Paragraph("male\r\n"));
		PdfPCell cell0593ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsEnrolled.get(0).getInputas00():""));
		PdfPCell cell0594ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsEnrolled.get(0).getInputas11():""));
		PdfPCell cell0595ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsEnrolled.get(0).getInputas12():""));
		PdfPCell cell0596ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsEnrolled.get(0).getInputas13():""));
		PdfPCell cell0597ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsEnrolled.get(0).getInputas14():""));
		
		PdfPCell cell0599ssr = new PdfPCell(new Paragraph("female\r\n"));
		PdfPCell cell05910ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05911ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05912ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05913ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05914ssr = new PdfPCell(new Paragraph(""));
		
		PdfPCell cell05916ssr = new PdfPCell(new Paragraph("others\r\n"));
		PdfPCell cell05917ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05918ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05919ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05920ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05921ssr = new PdfPCell(new Paragraph(""));

		PdfPCell cell05923ssr = new PdfPCell(new Paragraph("PG\r\n", font3));
		
		cell05923ssr.setRowspan(3);
		
		PdfPCell cell05924ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell05925ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05926ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05927ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05928ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05929ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05930ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell05931ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell059321ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05933ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05934ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05935ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05936ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell05937ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05938ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05939ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05940ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05941ssr = new PdfPCell(new Paragraph(""));
//		PdfPCell cell05942ssr = new PdfPCell(new Paragraph(""));
//		PdfPCell cell05943ssr = new PdfPCell(new Paragraph(""));

		
		PdfPCell cell060ssr = new PdfPCell(new Paragraph("From the State Where College is Located\r\n", font3));
		PdfPCell cell061ssr = new PdfPCell(new Paragraph("From Other States of India\r\n", font3));
		PdfPCell cell0621ssr = new PdfPCell(new Paragraph("NRI Students\r\n", font3));
		PdfPCell cell063ssr = new PdfPCell(new Paragraph("Foreign Students\r\n", font3));
		PdfPCell cell064ssr = new PdfPCell(new Paragraph("Total\r\n", font3));

		table35ssr.addCell(cell059ssr);
		//table35ssr.addCell(cell0601ssr);
		table35ssr.addCell(cell060ssr);
		table35ssr.addCell(cell061ssr);
		table35ssr.addCell(cell0621ssr);
		table35ssr.addCell(cell063ssr);
		table35ssr.addCell(cell064ssr);
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
//		table35ssr.addCell(cell05942ssr);
//		table35ssr.addCell(cell05943ssr);

		table35ssr.setSpacingBefore(20f);
		table35ssr.setSpacingAfter(20f);

		document.add(table35ssr);

		PdfPTable table36ssr = new PdfPTable(6);
		PdfPTable table37ssr = new PdfPTable(1);
		
		 float[] columnWidth8 = { 7f }; // Second column will be // twice as first and third
		 table37ssr.setWidths(columnWidth8);

// Setting width of table, its columns and spacing
		table36ssr.setWidthPercentage(100);
		table37ssr.setWidthPercentage(100);

		PdfPCell cell065ssr = new PdfPCell(new Paragraph("Programme\r\n", font3));
		
		cell065ssr.setColspan(2);
	
		PdfPCell cell059111ssr = new PdfPCell(new Paragraph("SC\r\n"));
		
		cell059111ssr.setRowspan(3);

		PdfPCell cell059211ssr = new PdfPCell(new Paragraph("male\r\n"));
		PdfPCell cell059312ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsAdmitted.get(0).getInputaa11():""));
		PdfPCell cell059413ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsAdmitted.get(0).getInputaa12():""));
		PdfPCell cell059514ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsAdmitted.get(0).getInputaa13():""));
		PdfPCell cell059615ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicstudentsAdmitted.get(0).getInputaa14():""));
		
		PdfPCell cell059916ssr = new PdfPCell(new Paragraph("female\r\n"));
		PdfPCell cell0591017ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0591118ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0591219ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0591320ssr = new PdfPCell(new Paragraph(""));
		
		PdfPCell cell0591621ssr = new PdfPCell(new Paragraph("others\r\n"));
		PdfPCell cell0591722ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05918232ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0591924ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0592025ssr = new PdfPCell(new Paragraph(""));
		
		
		PdfPCell cell066ssr = new PdfPCell(new Paragraph("Year 1\r\n\r\n", font3));
		PdfPCell cell067ssr = new PdfPCell(new Paragraph("Year 2\r\n\r\n", font3));
		PdfPCell cell068ssr = new PdfPCell(new Paragraph("Year 3\r\n\r\n", font3));
		PdfPCell cell069ssr = new PdfPCell(new Paragraph("Year 4\r\n\r\n", font3));

		
		
		table36ssr.addCell(cell065ssr);
		table36ssr.addCell(cell066ssr);
		table36ssr.addCell(cell067ssr);
		table36ssr.addCell(cell068ssr);
		table36ssr.addCell(cell069ssr);

		table36ssr.addCell(cell059111ssr);
		table36ssr.addCell(cell059211ssr);
		table36ssr.addCell(cell059312ssr);
		table36ssr.addCell(cell059413ssr);
		table36ssr.addCell(cell059514ssr);
		table36ssr.addCell(cell059615ssr);
		table36ssr.addCell(cell059916ssr);
		table36ssr.addCell(cell0591017ssr);
		table36ssr.addCell(cell0591118ssr);
		table36ssr.addCell(cell0591219ssr);
		table36ssr.addCell(cell0591320ssr);
		table36ssr.addCell(cell0591621ssr);
		table36ssr.addCell(cell0591722ssr);
		table36ssr.addCell(cell05918232ssr);
		table36ssr.addCell(cell0591924ssr);
		table36ssr.addCell(cell0592025ssr);
		
		
		
		
	
		PdfPCell cell0592300ssr = new PdfPCell(new Paragraph("ST\r\n"));
		
		cell0592300ssr.setRowspan(3);
		
		PdfPCell cell0592400ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell0592500ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0592600ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0592700ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0592800ssr = new PdfPCell(new Paragraph(""));
		
		PdfPCell cell0593000ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell0593100ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05932100ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0593300ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0593500ssr = new PdfPCell(new Paragraph(""));
		
		PdfPCell cell0593600ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell0593700ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0593800ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0593900ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell0594000ssr = new PdfPCell(new Paragraph(""));
		
		table36ssr.addCell(cell0592300ssr);
		table36ssr.addCell(cell0592400ssr);
		table36ssr.addCell(cell0592500ssr);
		table36ssr.addCell(cell0592600ssr);
		table36ssr.addCell(cell0592700ssr);
		table36ssr.addCell(cell0592800ssr);
		table36ssr.addCell(cell0593000ssr);
		table36ssr.addCell(cell0593100ssr);
		table36ssr.addCell(cell05932100ssr);
		table36ssr.addCell(cell0593300ssr);
		table36ssr.addCell(cell0593500ssr);
		table36ssr.addCell(cell0593600ssr);
		table36ssr.addCell(cell0593700ssr);
		table36ssr.addCell(cell0593800ssr);
		table36ssr.addCell(cell0593900ssr);
		table36ssr.addCell(cell0594000ssr);
		
	
       PdfPCell cell05923000ssr = new PdfPCell(new Paragraph("OBC\r\n"));
		
       cell05923000ssr.setRowspan(3);
		
		PdfPCell cell05924000ssr = new PdfPCell(new Paragraph("Male\r\n"));
		PdfPCell cell05925000ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05926000ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05927000ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05928000ssr = new PdfPCell(new Paragraph(""));
		
		PdfPCell cell05930000ssr = new PdfPCell(new Paragraph("Female\r\n"));
		PdfPCell cell05931000ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell059321000ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05933000ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05935000ssr = new PdfPCell(new Paragraph(""));
		
		PdfPCell cell05936000ssr = new PdfPCell(new Paragraph("Others\r\n"));
		PdfPCell cell05937000ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05938000ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05939000ssr = new PdfPCell(new Paragraph(""));
		PdfPCell cell05940000ssr = new PdfPCell(new Paragraph(""));
		
		
		table36ssr.addCell(cell05923000ssr);
		table36ssr.addCell(cell05924000ssr);
		table36ssr.addCell(cell05925000ssr);
		table36ssr.addCell(cell05926000ssr);
		table36ssr.addCell(cell05927000ssr);
		table36ssr.addCell(cell05928000ssr);
		
		table36ssr.addCell(cell05930000ssr);
		table36ssr.addCell(cell05931000ssr);
		table36ssr.addCell(cell059321000ssr);
		table36ssr.addCell(cell05933000ssr);
		table36ssr.addCell(cell05935000ssr);
		
		table36ssr.addCell(cell05936000ssr);
		table36ssr.addCell(cell05937000ssr);
		table36ssr.addCell(cell05938000ssr);
		table36ssr.addCell(cell05939000ssr);
		table36ssr.addCell(cell05940000ssr);
	
		 PdfPCell cell059230000ssr = new PdfPCell(new Paragraph("General\r\n"));
			
		 cell059230000ssr.setRowspan(3);
			
			PdfPCell cell059240000ssr = new PdfPCell(new Paragraph("Male\r\n"));
			PdfPCell cell059250000ssr = new PdfPCell(new Paragraph(""));
			PdfPCell cell059260000ssr = new PdfPCell(new Paragraph(""));
			PdfPCell cell059270000ssr = new PdfPCell(new Paragraph(""));
			PdfPCell cell059280000ssr = new PdfPCell(new Paragraph(""));
			
			PdfPCell cell059300000ssr = new PdfPCell(new Paragraph("Female\r\n"));
			PdfPCell cell059310000ssr = new PdfPCell(new Paragraph(""));
			PdfPCell cell0593210000ssr = new PdfPCell(new Paragraph(""));
			PdfPCell cell059330000ssr = new PdfPCell(new Paragraph(""));
			PdfPCell cell059350000ssr = new PdfPCell(new Paragraph(""));
			
			PdfPCell cell059360000ssr = new PdfPCell(new Paragraph("Others\r\n"));
			PdfPCell cell059370000ssr = new PdfPCell(new Paragraph(""));
			PdfPCell cell059380000ssr = new PdfPCell(new Paragraph(""));
			PdfPCell cell059390000ssr = new PdfPCell(new Paragraph(""));
			PdfPCell cell059400000ssr = new PdfPCell(new Paragraph(""));
			
			
			table36ssr.addCell(cell059230000ssr);
			table36ssr.addCell(cell059240000ssr);
			table36ssr.addCell(cell059250000ssr);
			table36ssr.addCell(cell059260000ssr);
			
			table36ssr.addCell(cell059270000ssr);
			table36ssr.addCell(cell059280000ssr);
			table36ssr.addCell(cell059300000ssr);
			table36ssr.addCell(cell059310000ssr);
			
			table36ssr.addCell(cell0593210000ssr);
			table36ssr.addCell(cell059330000ssr);
			table36ssr.addCell(cell059350000ssr);
			table36ssr.addCell(cell059360000ssr);
			
			table36ssr.addCell(cell059370000ssr);
			table36ssr.addCell(cell059380000ssr);
			table36ssr.addCell(cell059390000ssr);
			table36ssr.addCell(cell059400000ssr);
		
			
			
		
			 PdfPCell cell059230001ssr = new PdfPCell(new Paragraph("Others\r\n"));
				
			 cell059230001ssr.setRowspan(3);
				
				PdfPCell cell059240001ssr = new PdfPCell(new Paragraph("Male\r\n"));
				PdfPCell cell059250001ssr = new PdfPCell(new Paragraph(""));
				PdfPCell cell059260001ssr = new PdfPCell(new Paragraph(""));
				PdfPCell cell059270001ssr = new PdfPCell(new Paragraph(""));
				PdfPCell cell059280001ssr = new PdfPCell(new Paragraph(""));
				
				PdfPCell cell059300001ssr = new PdfPCell(new Paragraph("Female\r\n"));
				PdfPCell cell059310002ssr = new PdfPCell(new Paragraph(""));
				PdfPCell cell0593210003ssr = new PdfPCell(new Paragraph(""));
				PdfPCell cell059330001ssr = new PdfPCell(new Paragraph(""));
				PdfPCell cell059350001ssr = new PdfPCell(new Paragraph(""));
				
				PdfPCell cell059360001ssr = new PdfPCell(new Paragraph("Others\r\n"));
				PdfPCell cell059370001ssr = new PdfPCell(new Paragraph(""));
				PdfPCell cell059380001ssr = new PdfPCell(new Paragraph(""));
				PdfPCell cell059390001ssr = new PdfPCell(new Paragraph(""));
				PdfPCell cell059400001ssr = new PdfPCell(new Paragraph(""));
				
				PdfPCell cell0650ssr = new PdfPCell(new Paragraph("Total\r\n"));
				
				cell0650ssr.setColspan(2);
			
				PdfPCell cell059370011ssr = new PdfPCell(new Paragraph(""));
				PdfPCell cell059380011ssr = new PdfPCell(new Paragraph(""));
				PdfPCell cell059390011ssr = new PdfPCell(new Paragraph(""));
				PdfPCell cell059400011ssr = new PdfPCell(new Paragraph(""));
				
				
				
				table36ssr.addCell(cell059230001ssr);
				table36ssr.addCell(cell059240001ssr);
				table36ssr.addCell(cell059250001ssr);
				table36ssr.addCell(cell059260001ssr);
				table36ssr.addCell(cell059270001ssr);
				table36ssr.addCell(cell059280001ssr);
				
				table36ssr.addCell(cell059300001ssr);
				table36ssr.addCell(cell059310002ssr);
				table36ssr.addCell(cell0593210003ssr);
				table36ssr.addCell(cell059330001ssr);
				table36ssr.addCell(cell059350001ssr);
				
				table36ssr.addCell(cell059360001ssr);
				table36ssr.addCell(cell059370001ssr);
				table36ssr.addCell(cell059380001ssr);
				table36ssr.addCell(cell059390001ssr);
				table36ssr.addCell(cell059400001ssr);
			
				table36ssr.addCell(cell0650ssr);
				table36ssr.addCell(cell059370011ssr);
				table36ssr.addCell(cell059380011ssr);
				table36ssr.addCell(cell059390011ssr);
				table36ssr.addCell(cell059400011ssr);
			
				
		
				PdfPCell cell0691ssr = new PdfPCell(new Paragraph(
						"Provide the Following Details of Students admitted to the College During the last four Academic Years\r\n",font3));
				
				table37ssr.addCell(cell0691ssr);
		
		
		
		
		
		table37ssr.addCell(table36ssr);

		table37ssr.setSpacingBefore(20f);
		table37ssr.setSpacingAfter(20f);

		document.add(table37ssr);

		Paragraph paragraph17ssr = new Paragraph("EVALUATIVE REPORT OF THE DEPARTMENTS\r\n\r\n", font2);
		paragraph17ssr.setAlignment(Paragraph.ALIGN_LEFT);

		document.add(paragraph17ssr);

		PdfPTable table14ssr = new PdfPTable(2);

		table14ssr.setWidthPercentage(100f);
		table14ssr.setWidths(new int[] { 3, 3 });
		table14ssr.setSpacingBefore(5);
		PdfPCell cell33ssr = new PdfPCell(new Paragraph("Department Name\r\n\r\n", font3));
		table14ssr.addCell(cell33ssr);

		PdfPCell cell34ssr = new PdfPCell(new Paragraph("Upload Report\r\n\r\n", font3));
		table14ssr.addCell(cell34ssr);

		PdfPCell cell35ssr = new PdfPCell(new Paragraph("Civil Engineering\r\n\r\n"));
		table14ssr.addCell(cell35ssr);

		PdfPCell cell36ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell36ssr);

		PdfPCell cell37ssr = new PdfPCell(new Paragraph("Computer Science And EngineeringFile Description\r\n\r\n"));
		table14ssr.addCell(cell37ssr);

		PdfPCell cell38ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell38ssr);

		PdfPCell cell39ssr = new PdfPCell(new Paragraph("Department Of Management Studies\r\n\r\n"));
		table14ssr.addCell(cell39ssr);

		PdfPCell cell40ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell40ssr);

		PdfPCell cell41ssr = new PdfPCell(new Paragraph("Electrical And Electronics Engineering\r\n\r\n"));
		table14ssr.addCell(cell41ssr);

		PdfPCell cell42ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell42ssr);

		PdfPCell cell43ssr = new PdfPCell(new Paragraph("Electronics And Communication Engineering\r\n\r\n"));
		table14ssr.addCell(cell43ssr);

		PdfPCell cell44ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell44ssr);

		PdfPCell cell45ssr = new PdfPCell(new Paragraph("Information Technology\r\n\r\n"));
		table14ssr.addCell(cell45ssr);

		PdfPCell cell46ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell46ssr);

		PdfPCell cell47ssr = new PdfPCell(new Paragraph("Mechanical Engineering\r\n\r\n"));
		table14ssr.addCell(cell47ssr);

		PdfPCell cell48ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell48ssr);

		document.add(table14ssr);
		table14ssr.setSpacingAfter(10f);

		Paragraph paragraph18ssr = new Paragraph("Institutional preparedness for NEP\r\n\r\n\r\n", font3);
		paragraph18ssr.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(paragraph18ssr);

		PdfPTable table15ssr = new PdfPTable(2);

		table15ssr.setWidthPercentage(100f);
		table15ssr.setWidths(new int[] { 70, 70 });
		table15ssr.setSpacingBefore(20f);
		table15ssr.setSpacingAfter(20f);

		PdfPCell cell49ssr = new PdfPCell(new Paragraph("1. Multidisciplinary/interdisciplinary:\r\n\r\n"));

		table15ssr.addCell(cell49ssr);

		PdfPCell cell50ssr = new PdfPCell(new Paragraph());
		table15ssr.addCell(cell50ssr);

		PdfPCell cell51ssr = new PdfPCell(new Paragraph("2. Academic bank of credits (ABC):\r\n\r\n"));
		table15ssr.addCell(cell51ssr);
		PdfPCell cell52ssr = new PdfPCell(new Paragraph());
		table15ssr.addCell(cell52ssr);

		PdfPCell cell53ssr = new PdfPCell(new Paragraph("3. Skill development:\r\n\r\n"));
		table15ssr.addCell(cell53ssr);

		PdfPCell cell54ssr = new PdfPCell(new Paragraph());
		table15ssr.addCell(cell54ssr);

		PdfPCell cell55ssr = new PdfPCell(new Paragraph(
				"4. Appropriate integration of Indian Knowledge system  (teaching in Indian Language, culture, using online course"));
		table15ssr.addCell(cell55ssr);

		PdfPCell cell56ssr = new PdfPCell(new Paragraph());
		table15ssr.addCell(cell56ssr);

		PdfPCell cell57ssr = new PdfPCell(new Paragraph("5. Focus on Outcome based education (OBE):\r\n\r\n\r\n"));
		table15ssr.addCell(cell57ssr);

		PdfPCell cell58ssr = new PdfPCell(new Paragraph());
		table15ssr.addCell(cell58ssr);

		PdfPCell cell59ssr = new PdfPCell(new Paragraph("6. Distance education/online education:\r\n\r\n"));
		table15ssr.addCell(cell59ssr);

		PdfPCell cell60ssr = new PdfPCell(new Paragraph());
		table15ssr.addCell(cell60ssr);
        
		document.add(table15ssr);

	}

	public void Extendprofile(Document document) {

		////////////////////////////////////////////////////////////////////////
		/////////////// Extend Profile starts hear.................................
		/////////////////////////////////////

		/*
		 * Font fontep = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontep.setSize(16);
		 * 
		 * Font font1ep = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font1ep.setSize(14);
		 * 
		 * Font font2ep = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font2ep.setSize(12);
		 * 
		 * // Font font3=FontFactory.getFont(FontFactory.HELVETICA); //
		 * font.setSize(16);
		 * 
		 * // Font font4=FontFactory.getFont(FontFactory.HELVETICA); //
		 * font1.setSize(14);
		 * 
		 * Font font5ep = FontFactory.getFont(FontFactory.HELVETICA);
		 * font5ep.setSize(12);
		 */

		Paragraph paragraphep = new Paragraph("Extended Profile\r\n", font1);
		paragraphep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph1ep = new Paragraph("1 Program\r\n\r\n", font1);
		paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph2ep = new Paragraph(
				"1.1\r\n" + "Number of programs offered year-wise for last five years\r\n\r\n", font2);
		paragraph2ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraphep);
		document.add(paragraph1ep);
		document.add(paragraph2ep);

//		PdfPTable table1ep = new PdfPTable(2);
//		table1ep.setWidthPercentage(100);
//
//		PdfPCell cell1ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		
//		cell1ep.setBackgroundColor(RGBColor.green);
//		
//		PdfPCell cell2ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		cell2ep.setBackgroundColor(RGBColor.green);
//		
//		PdfPCell cell3ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		cell3ep.setBackgroundColor(RGBColor.blue);
//		
//		PdfPCell cell4ep = new PdfPCell(new Paragraph(" "));
//		cell4ep.setBackgroundColor(RGBColor.blue);
//		
//		table1ep.addCell(cell1ep);
//		table1ep.addCell(cell2ep);
//		table1ep.addCell(cell3ep);
//		table1ep.addCell(cell4ep);
//
//		table1ep.setSpacingBefore(20f);
//		table1ep.setSpacingAfter(20f);
//
//		document.add(table1ep);

		Table epprogramme = new Table(epRecord.getEpYeartable11().size(), 2);

		epprogramme.setPadding(10);
		epprogramme.setWidth(100f);

		for (int i = 0; i < epRecord.getEpYeartable11().size(); i++) {
			epprogramme.addCell(epRecord.getEpYeartable11().get(i).getInput11y());

		}
		for (int i = 0; i < epRecord.getEpYeartable11().size(); i++) {
			epprogramme.addCell(epRecord.getEpYeartable11().get(i).getInput11v());

		}

		document.add(epprogramme);
		Paragraph paragraph3ep = new Paragraph("\r\n 1.2\r\n" + "Number of departments offering academic programmes\r\n"
				+ "Response:" + (epRecord != null ? epRecord.geteTable12v() : ""), font3);
		paragraph3ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph3ep);

		Paragraph paragraph4ep = new Paragraph("2 \r\n Students", font2);
		paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph4ep);

		Paragraph paragraph5ep = new Paragraph(
				"2.1\r\n" + "Number of students year-wise during last five years\r\n" + "\r\n" + "", font3);
		paragraph5ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph5ep);

//		PdfPTable table2ep = new PdfPTable(2);
//		table2ep.setWidthPercentage(100);
//
//		PdfPCell cell5ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell6ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell7ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		PdfPCell cell8ep = new PdfPCell(new Paragraph(" "));
//
//		table2ep.addCell(cell5ep);
//		table2ep.addCell(cell6ep);
//		table2ep.addCell(cell7ep);
//		table2ep.addCell(cell8ep);
//
//		table2ep.setSpacingBefore(20f);
//		table2ep.setSpacingAfter(20f);
//
//		document.add(table2ep);

		Table epstudent21 = new Table(epRecord.getEpYeartable21().size(), 2);

		epstudent21.setPadding(10);
		epstudent21.setWidth(100f);

		for (int i = 0; i < epRecord.getEpYeartable21().size(); i++) {
			epstudent21.addCell(epRecord.getEpYeartable21().get(i).getInput21y());

		}
		for (int i = 0; i < epRecord.getEpYeartable21().size(); i++) {
			epstudent21.addCell(epRecord.getEpYeartable21().get(i).getInput21v());

		}

		document.add(epstudent21);

		Paragraph paragraph6ep = new Paragraph(
				"2.2\r\n" + "Number of outgoing / final year students year-wise during last five years\r\n" + "",
				font3);
		paragraph6ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph6ep);

//		PdfPTable table3ep = new PdfPTable(2);
//		table3ep.setWidthPercentage(100);
//
//		PdfPCell cell9ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell10ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell11ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		PdfPCell cell12ep = new PdfPCell(new Paragraph(" "));
//
//		table3ep.addCell(cell9ep);
//		table3ep.addCell(cell10ep);
//		table3ep.addCell(cell11ep);
//		table3ep.addCell(cell12ep);
//
//		table3ep.setSpacingBefore(20f);
//		table3ep.setSpacingAfter(20f);
//
//		document.add(table3ep);

		Table epstudent22 = new Table(epRecord.getEpYeartable22().size(), 2);

		epstudent22.setPadding(10);
		epstudent22.setWidth(100f);

		for (int i = 0; i < epRecord.getEpYeartable22().size(); i++) {
			epstudent22.addCell(epRecord.getEpYeartable22().get(i).getInput22y());

		}
		for (int i = 0; i < epRecord.getEpYeartable22().size(); i++) {
			epstudent22.addCell(epRecord.getEpYeartable22().get(i).getInput22v());

		}

		document.add(epstudent22);

		Paragraph paragraph7ep = new Paragraph("2.3\r\n"
				+ "Number of students appeared in the examination conducted by the Institution, year-wise during the last five years\r\n"
				+ "", font3);
		paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph7ep);

//		PdfPTable table4ep = new PdfPTable(2);
//		table4ep.setWidthPercentage(100);
//
//		PdfPCell cell13ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell14ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell15ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		PdfPCell cell16ep = new PdfPCell(new Paragraph(" "));
//
//		table4ep.addCell(cell13ep);
//		table4ep.addCell(cell14ep);
//		table4ep.addCell(cell15ep);
//		table4ep.addCell(cell16ep);
//
//		table4ep.setSpacingBefore(20f);
//		table4ep.setSpacingAfter(20f);
//
//		document.add(table4ep);

		Table epstudent23 = new Table(epRecord.getEpYeartable23().size(), 2);

		epstudent23.setPadding(10);
		epstudent23.setWidth(100f);

		for (int i = 0; i < epRecord.getEpYeartable23().size(); i++) {
			epstudent23.addCell(epRecord.getEpYeartable23().get(i).getInput23y());

		}
		for (int i = 0; i < epRecord.getEpYeartable23().size(); i++) {
			epstudent23.addCell(epRecord.getEpYeartable23().get(i).getInput23y());

		}

		document.add(epstudent23);

		Paragraph paragraph8ep = new Paragraph(
				"2.4\r\n" + "\r\n" + "Number of revaluation applications year-wise during last five years\r\n" + "",
				font3);
		paragraph8ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph8ep);

//		PdfPTable table5ep = new PdfPTable(2);
//		table5ep.setWidthPercentage(100);
//
//		PdfPCell cell17ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n\r\n", font3));
//		PdfPCell cell18ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell19ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		PdfPCell cell20ep = new PdfPCell(new Paragraph(" "));
//
//		table5ep.addCell(cell17ep);
//		table5ep.addCell(cell18ep);
//		table5ep.addCell(cell19ep);
//		table5ep.addCell(cell20ep);
//
//		table5ep.setSpacingBefore(20f);
//		table5ep.setSpacingAfter(20f);
//
//		document.add(table5ep);

		Table epstudent24 = new Table(epRecord.getEpYeartable24().size(), 2);

		epstudent24.setPadding(10);
		epstudent24.setWidth(100f);

		for (int i = 0; i < epRecord.getEpYeartable24().size(); i++) {
			epstudent24.addCell(epRecord.getEpYeartable24().get(i).getInput24y());

		}
		for (int i = 0; i < epRecord.getEpYeartable24().size(); i++) {
			epstudent24.addCell(epRecord.getEpYeartable24().get(i).getInput24y());

		}

		document.add(epstudent24);

		Paragraph paragraph9ep = new Paragraph("3 Teachers\r\n", font2);
		paragraph9ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph9ep);

		Paragraph paragraph10ep = new Paragraph(
				"3.1\r\n" + "Number of courses in all programs year-wise during last five years\r\n" + "\r\n" + "",
				font3);
		paragraph10ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph10ep);

//		PdfPTable table6ep = new PdfPTable(2);
//		table6ep.setWidthPercentage(100);
//
//		PdfPCell cell21ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell22ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell23ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		PdfPCell cell24ep = new PdfPCell(new Paragraph(" "));
//
//		table6ep.addCell(cell21ep);
//		table6ep.addCell(cell22ep);
//		table6ep.addCell(cell23ep);
//		table6ep.addCell(cell24ep);
//
//		table6ep.setSpacingBefore(20f);
//		table6ep.setSpacingAfter(20f);
//
//		document.add(table6ep);

		Table epstudent31 = new Table(epRecord.getEpYeartable31().size(), 2);

		epstudent31.setPadding(10);
		epstudent31.setWidth(100f);

		for (int i = 0; i < epRecord.getEpYeartable31().size(); i++) {
			epstudent31.addCell(epRecord.getEpYeartable31().get(i).getInput31y());

		}
		for (int i = 0; i < epRecord.getEpYeartable31().size(); i++) {
			epstudent31.addCell(epRecord.getEpYeartable31().get(i).getInput31v());

		}

		document.add(epstudent31);

		Paragraph paragraph11ep = new Paragraph(
				"3.2\r\n" + "\r\n" + "Number of full time teachers year-wise during the last five years\r\n" + "",
				font3);
		paragraph11ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph11ep);

//		PdfPTable table7ep = new PdfPTable(2);
//		table7ep.setWidthPercentage(100);
//
//		PdfPCell cell25ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell26ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell27ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		PdfPCell cell28ep = new PdfPCell(new Paragraph(" "));
//
//		table7ep.addCell(cell25ep);
//		table7ep.addCell(cell26ep);
//		table7ep.addCell(cell27ep);
//		table7ep.addCell(cell28ep);
//
//		table7ep.setSpacingBefore(20f);
//		table7ep.setSpacingAfter(20f);
//
//		document.add(table7ep);

		Table epstudent32 = new Table(epRecord.getEpYeartable32().size(), 2);

		epstudent32.setPadding(10);
		epstudent32.setWidth(100f);

		for (int i = 0; i < epRecord.getEpYeartable32().size(); i++) {
			epstudent32.addCell(epRecord.getEpYeartable32().get(i).getInput32y());

		}
		for (int i = 0; i < epRecord.getEpYeartable32().size(); i++) {
			epstudent32.addCell(epRecord.getEpYeartable32().get(i).getInput32y());

		}

		document.add(epstudent32);

		Paragraph paragraph12ep = new Paragraph(
				"3.3\r\n" + "Number of sanctioned posts year-wise during last five years\r\n" + "\r\n" + "", font3);
		paragraph12ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph12ep);

//		PdfPTable table8ep = new PdfPTable(2);
//		table8ep.setWidthPercentage(100);
//
//		PdfPCell cell29ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell30ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell31ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		PdfPCell cell32ep = new PdfPCell(new Paragraph(" "));
//
//		table8ep.addCell(cell29ep);
//		table8ep.addCell(cell30ep);
//		table8ep.addCell(cell31ep);
//		table8ep.addCell(cell32ep);
//
//		table8ep.setSpacingBefore(20f);
//		table8ep.setSpacingAfter(20f);
//
//		document.add(table8ep);

		Table epstudent33 = new Table(epRecord.getEpYeartable33().size(), 2);

		epstudent33.setPadding(10);
		epstudent33.setWidth(100f);

		for (int i = 0; i < epRecord.getEpYeartable33().size(); i++) {
			epstudent33.addCell(epRecord.getEpYeartable33().get(i).getInput33y());

		}
		for (int i = 0; i < epRecord.getEpYeartable33().size(); i++) {
			epstudent33.addCell(epRecord.getEpYeartable33().get(i).getInput33v());

		}

		document.add(epstudent33);

		Paragraph paragraph13ep = new Paragraph("4 Institution\r\n", font2);
		paragraph13ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph13ep);

		Paragraph paragraph14ep = new Paragraph("4.1\r\n"
				+ "Number of eligible applications received for admissions to all the programs year-wise during last five years\r\n"
				+ "", font3);
		paragraph14ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph14ep);

//		PdfPTable table9ep = new PdfPTable(2);
//		table9ep.setWidthPercentage(100);
//
//		PdfPCell cell33ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell34ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell35ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		PdfPCell cell36ep = new PdfPCell(new Paragraph(" "));
//
//		table9ep.addCell(cell33ep);
//		table9ep.addCell(cell34ep);
//		table9ep.addCell(cell35ep);
//		table9ep.addCell(cell36ep);
//
//		table9ep.setSpacingBefore(20f);
//		table9ep.setSpacingAfter(20f);
//
//		document.add(table9ep);

		Table epstudent41 = new Table(epRecord.getEpYeartable41().size(), 2);

		epstudent41.setPadding(10);
		epstudent41.setWidth(100f);

		for (int i = 0; i < epRecord.getEpYeartable41().size(); i++) {
			epstudent41.addCell(epRecord.getEpYeartable41().get(i).getInput41y());

		}
		for (int i = 0; i < epRecord.getEpYeartable41().size(); i++) {
			epstudent41.addCell(epRecord.getEpYeartable41().get(i).getInput41v());

		}

		document.add(epstudent41);

		Paragraph paragraph15ep = new Paragraph("4.2\r\n"
				+ "Number of seats earmarked for reserved category as per GOI/State Govt rule year-wise during last five years\r\n\r\n"
				+ "", font3);
		paragraph15ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph15ep);

//		PdfPTable table10ep = new PdfPTable(2);
//		table10ep.setWidthPercentage(100);
//
//		PdfPCell cell37ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell38ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell39ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		PdfPCell cell40ep = new PdfPCell(new Paragraph(" "));
//
//		table10ep.addCell(cell37ep);
//		table10ep.addCell(cell38ep);
//		table10ep.addCell(cell39ep);
//		table10ep.addCell(cell40ep);
//
//		table10ep.setSpacingBefore(20f);
//		table10ep.setSpacingAfter(20f);
//
//		document.add(table10ep);

		Table epstudent42 = new Table(epRecord.getEpYeartable42().size(), 2);

		epstudent42.setPadding(10);
		epstudent42.setWidth(100f);

		for (int i = 0; i < epRecord.getEpYeartable42().size(); i++) {
			epstudent42.addCell(epRecord.getEpYeartable42().get(i).getInput42y());

		}
		for (int i = 0; i < epRecord.getEpYeartable42().size(); i++) {
			epstudent42.addCell(epRecord.getEpYeartable42().get(i).getInput42v());

		}

		document.add(epstudent42);

		Paragraph paragraph16ep = new Paragraph(
				"4.3\r\n" + "Total number of classrooms and seminar halls Response: 73\r\n" + "", font3);
		paragraph16ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph16ep);

		Paragraph paragraph17ep = new Paragraph(
				"4.4\r\n" + "Total number of computers in the campus for academic purpose Response: 1818\r\n" + "",
				font3);
		paragraph17ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph17ep);

		Paragraph paragraph18ep = new Paragraph("4.5\r\n"
				+ "Total Expenditure excluding salary year-wise during last five years ( INR in Lakhs)\r\n" + "",
				font3);
		paragraph18ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph18ep);

//		PdfPTable table11ep = new PdfPTable(2);
//		table11ep.setWidthPercentage(100);
//
//		PdfPCell cell41ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//		PdfPCell cell42ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//		PdfPCell cell43ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		PdfPCell cell44ep = new PdfPCell(new Paragraph(" "));
//
//		table11ep.addCell(cell41ep);
//		table11ep.addCell(cell42ep);
//		table11ep.addCell(cell43ep);
//		table11ep.addCell(cell44ep);
//
//		table11ep.setSpacingBefore(20f);
//		table11ep.setSpacingAfter(20f);
//
//		document.add(table11ep);

		Table epstudent45 = new Table(epRecord.getEpYeartable45().size(), 2);

		epstudent45.setPadding(10);
		epstudent45.setWidth(100f);

		for (int i = 0; i < epRecord.getEpYeartable45().size(); i++) {
			epstudent45.addCell(epRecord.getEpYeartable45().get(i).getInput45y());

		}
		for (int i = 0; i < epRecord.getEpYeartable45().size(); i++) {
			epstudent45.addCell(epRecord.getEpYeartable45().get(i).getInput45v());

		}

		document.add(epstudent45);

	}

	public void Criteria1(Document document) {

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
		document.add(paragraph);

		Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font2);
		paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph1);
		Paragraph paragraph2 = new Paragraph("1.1 Curriculum Design and Development\r\n", font3);
		paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph2);

		/*
		 * com.lowagie.text.Font fontTitle3 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle3.setSize(12);
		 */

		Paragraph paragraph3 = new Paragraph(
				"1.1.1 Curricula developed and implemented have relevance to the local, national, regional and global developmental needs which is reflected in Programme outcomes (POs), Programme Specific Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered by the Institution.\r\n",
				font3);
		paragraph3.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		PdfPTable table111criteria1 = new PdfPTable(1);

		table111criteria1.setWidthPercentage(100);
		PdfPCell cell111criteria1 = new PdfPCell(
				new Paragraph("1.1.1 Curricula developed and implemented have relevance to the local, "
						+ "national, regional and global developmental needs which is reflected in Programme outcomes (POs), "
						+ "Programme Specific Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered by the Institution.\r\n"
						+ "Response:"+"\r\n+\r\n", font3));

		table111criteria1.addCell(cell111criteria1);

		table111criteria1.setSpacingBefore(20f);
		table111criteria1.setSpacingAfter(20f);
		document.add(table111criteria1);

		/*
		 * com.lowagie.text.Font fontTitle4 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle4.setSize(12);
		 */

		Paragraph paragraph4 = new Paragraph("Response:"
				+ (criteria1Record != null ? criteria1Record.getCriteria11Ql().get(0).getResponse111()
						: ""),
				font3);
		paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle5 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle5.setSize(12);
		 */

		Paragraph paragraph5 = new Paragraph(
				"Mother Teresa being an autonomous HEI, has ensured a systematic procedure for the design, development, implementation and revision of its curricula as aligned to the institution�s vision and mission. All departments with their respective vision and mission have established their corresponding Program Educational Objectives (PEOs), defined Program Specific Outcomes (PSOs) and using the Program Outcomes (POs) of NBA, prepared PO-PEO matrix to ensure that POs facilitate realization of PEOs. Selected the number of credits for the program based on AICTE and UGC norms and decided distribution of credits. Identified the courses and defined respective course outcomes (COs), in line with Bloom�s Taxonomy levels, in particular, the Higher Order Thinking Skills (HOTS), meeting the stated POs and PSOs and prepared PO/PSO-CO matrix:",
				font5);
		paragraph5.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle6 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle6.setSize(12);
		 */

		Paragraph paragraph6 = new Paragraph(
				"While preparing the curriculum and subsequent revisions (once in two years), each BoS gathers extensive inputs from all stakeholders, namely, industry, R&D establishments, members of professional bodies, alumni, faculty, government and community. Each BoS also considers impetus given to infrastructure sector, GDP earned from various sectors along with the manpower requirements, and Government�s directives towards \"Make in India\" as also �Aatma Nirbhar Bharath�.\r\n"
						+ "\r\n" + "\r\n",
				font5);
		paragraph6.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle7 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle7.setSize(12);
		 */
		Paragraph paragraph7 = new Paragraph(
				"Curricula are approved by the Academic Council, with due deliberations on their relevance, for further revision, if any, so that Institution's vision and mission are reflected in each program offered by the institution.",
				font5);
		paragraph7.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle8 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle8.setSize(12);
		 */
		Paragraph paragraph8 = new Paragraph("Courses are broadly classified into:\r\n" + "\r\n", font5);
		paragraph8.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle9 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle9.setSize(12);
		 */
		Paragraph paragraph9 = new Paragraph("", font5);
		paragraph9.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet1 = new Chunk("\u2022", font5);
		paragraph9.add(bullet1);
		paragraph9
				.add(new Phrase("Core: Basic/Engineering Sciences, Humanities, Social Sciences and Engineering.\r\n"));

		/*
		 * com.lowagie.text.Font fontTitle10 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle10.setSize(12);
		 */
		Paragraph paragraph10 = new Paragraph(" ", font5);
		paragraph10.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet2 = new Chunk("\u2022", font5);
		paragraph10.add(bullet2);
		paragraph10.add(new Phrase(
				"Electives: Professional Electives which enrich students with technological advancements, and Open Electives which promote philosophy of liberal education."));

		/*
		 * com.lowagie.text.Font fontTitle11 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle11.setSize(12);
		 */
		Paragraph paragraph11 = new Paragraph(" ", font5);
		Chunk bullet3 = new Chunk("\u2022", font5);
		paragraph11.add(bullet3);
		paragraph11.add(new Phrase(
				"Value added courses: to enhance employability, creativity, innovation, team-work, communication, problem solving ability, Logical reasoning, environmental aspects for sustainability, professional ethics and integrity, Project management and finance, Design Thinking, Internship, projects/ seminars, entrepreneurship insights, value education, citizenship roles, catering to the local, regional and global needs.\r\n\r\n"));
		paragraph11.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle12 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle12.setSize(12);
		 */
		Paragraph paragraph12 = new Paragraph(
				"All the above provide the students with liberal and holistic education with experimental and experiential learning through simulation and hands-on operations, to be globally competitive:\r\n"
						+ "\r\n",
				font5);
		paragraph12.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle13 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle13.setSize(12);
		 */
		Paragraph paragraph13 = new Paragraph(
				"As per NEP 2020, multi-disciplinary choices are available for learners, through a plethora of courses across departments, under the Choice Based Credit system (CBCS) and value added courses on usage of\r\n"
						+ " \r\n"
						+ "modern tools as adopted by industry, promoting analytical thinking, creativity and innovation, and building a culture of innovative spirit, thereby transforming the learners to be industry-ready, relevant and build an attitude of serving the society towards sustainable development:\r\n"
						+ "\r\n",
				font5);
		paragraph13.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle14 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle14.setSize(12);
		 */
		Paragraph paragraph14 = new Paragraph(
				"The following are some notable courses introduced in the corresponding revisions:\r\n" + "\r\n",
				font5);
		paragraph14.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle15 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle15.setSize(12);
		 */
		Paragraph paragraph15 = new Paragraph("2016-18:\r\n", font3);
		paragraph15.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle16 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle16.setSize(12);
		 */
		Paragraph paragraph16 = new Paragraph("", font5);
		paragraph16.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet4 = new Chunk("\u2022", font5);
		paragraph16.add(bullet4);
		paragraph16.add(new Phrase("Computational Mathematics with lab\r\n"));

		/*
		 * com.lowagie.text.Font fontTitle17 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle17.setSize(12);
		 */
		Paragraph paragraph17 = new Paragraph("", font5);
		paragraph17.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet5 = new Chunk("\u2022", font5);
		paragraph17.add(bullet5);
		paragraph17.add(new Phrase("Actuarial Statistics\r\n"));

		/*
		 * com.lowagie.text.Font fontTitle18 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle18.setSize(12);
		 */
		Paragraph paragraph18 = new Paragraph("", font5);
		paragraph18.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Chunk bullet6 = new Chunk("\u2022", font5);
		paragraph18.add(bullet6);
		paragraph18.add(new Phrase("Banking and Insurance\r\n"));

		/*
		 * com.lowagie.text.Font fontTitle19 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle19.setSize(12);
		 */
		Paragraph paragraph19 = new Paragraph("", font5);
		paragraph19.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet7 = new Chunk("\u2022", font5);
		paragraph19.add(bullet7);
		paragraph19.add(new Phrase("Foreign Language\r\n"));

		/*
		 * com.lowagie.text.Font fontTitle20 =
		 * FontFactory.getFont(FontFactory.HELVETICA); font3.setSize(12);
		 */
		Paragraph paragraph20 = new Paragraph("", font5);
		paragraph20.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet8 = new Chunk("\u2022", font5);
		paragraph20.add(bullet8);
		paragraph20.add(new Phrase("Hybrid Electric Vehicles\r\n"));

		/*
		 * com.lowagie.text.Font fontTitle21 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle21.setSize(12);
		 */
		Paragraph paragraph21 = new Paragraph("", font5);
		paragraph21.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet9 = new Chunk("\u2022", font5);
		paragraph21.add(bullet9);
		paragraph21.add(new Phrase("Nano-materials and Technology\r\n"));

		/*
		 * com.lowagie.text.Font fontTitle22 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle22.setSize(12);
		 */
		Paragraph paragraph22 = new Paragraph("", font5);
		paragraph22.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet10 = new Chunk("\u2022", font5);
		paragraph22.add(bullet10);
		paragraph22.add(new Phrase("Pavement analysis and design with lab\r\n"));

		/*
		 * com.lowagie.text.Font fontTitle23 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle23.setSize(12)
		 */
		Paragraph paragraph23 = new Paragraph("", font5);
		paragraph23.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet11 = new Chunk("\u2022", font5);
		paragraph23.add(bullet11);
		paragraph23.add(new Phrase("Earth Retaining Structures\r\n\r\n"));

		/*
		 * com.lowagie.text.Font fontTitle24 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle24.setSize(12);
		 */
		Paragraph paragraph24 = new Paragraph("2018-20\r\n", font3);
		paragraph24.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle25 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle25.setSize(12);
		 */
		Paragraph paragraph25 = new Paragraph(" ", font5);
		paragraph25.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet12 = new Chunk("\u2022", font5);
		paragraph25.add(bullet12);
		paragraph25.add(new Phrase("Deep learning\r\n"));

		/*
		 * com.lowagie.text.Font fontTitle26 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle26.setSize(12);
		 */
		Paragraph paragraph26 = new Paragraph(" ", font5);
		paragraph26.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet13 = new Chunk("\u2022", font5);
		paragraph26.add(bullet13);
		paragraph26.add(new Phrase("Electronic Sensors\r\n"));

		/*
		 * com.lowagie.text.Font fontTitle27 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle27.setSize(12);
		 */
		Paragraph paragraph27 = new Paragraph(" ", font5);
		Chunk bullet14 = new Chunk("\u2022", font5);
		paragraph27.add(bullet14);
		paragraph27.add(new Phrase("IoT\r\n"));

		paragraph27.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle28 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle28.setSize(12);
		 */
		Paragraph paragraph28 = new Paragraph("Courses with hands on lab exercises:\r\n ", font3);
		paragraph28.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle29 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle29.setSize(12);
		 */

		Paragraph paragraph29 = new Paragraph("", font5);
		Chunk bullet15 = new Chunk("\u2022", font5);
		paragraph29.add(bullet15);
		paragraph29.add(new Phrase("Artificial Intelligence\r\n", font5));

		Paragraph paragraph291 = new Paragraph("", font5);
		Chunk bullet16 = new Chunk("\u2022", font5);
		paragraph291.add(bullet16);
		paragraph291.add(new Phrase("Machine Learning\r\n"));

		Paragraph paragraph292 = new Paragraph("", font5);
		Chunk bullet17 = new Chunk("\u2022", font5);
		paragraph292.add(bullet17);
		paragraph292.add(new Phrase("Operations Research\r\n", font5));
		paragraph292.setAlignment(Element.ALIGN_JUSTIFIED);

		Paragraph paragraph293 = new Paragraph("", font5);
		Chunk bullet18 = new Chunk("\u2022", font5);
		paragraph293.add(bullet18);
		paragraph293.add(new Phrase("Blockchain Technologies\r\n", font5));
		paragraph293.setAlignment(Element.ALIGN_JUSTIFIED);

		Paragraph paragraph294 = new Paragraph("", font5);
		Chunk bullet19 = new Chunk("\u2022", font5);
		paragraph294.add(bullet19);
		paragraph294.add(new Phrase("Data Analytic\r\n", font5));
		paragraph294.setAlignment(Element.ALIGN_JUSTIFIED);

		Paragraph paragraph295 = new Paragraph("", font5);
		Chunk bullet20 = new Chunk("\u2022", font5);
		paragraph295.setAlignment(Element.ALIGN_JUSTIFIED);
		paragraph295.add(bullet20);
		paragraph295.add(new Phrase("Project-orientation\r\n", font5));

		Paragraph paragraph296 = new Paragraph("", font5);
		Chunk bullet21 = new Chunk("\u2022", font5);
		paragraph296.add(bullet21);
		paragraph296.add(new Phrase("IT workshop including Sci-lab\r\n\r\n", font5));
		paragraph296.setAlignment(Element.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle30 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle30.setSize(12);
		 */
		Paragraph paragraph30 = new Paragraph("2020-21\r\n ", font3);
		paragraph30.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle31 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle31.setSize(12);
		 */
		Paragraph paragraph31 = new Paragraph(" ", font5);
		Chunk bullet22 = new Chunk("\u2022", font5);
		paragraph31.add(bullet22);
		paragraph31.add(new Phrase("5G mobile communications\r\n\r\n", font5));
		paragraph31.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph311 = new Paragraph(" ", font5);
		Chunk bullet23 = new Chunk("\u2022", font5);
		paragraph311.add(bullet23);
		paragraph311.add(new Phrase("Six English courses (Three new)\r\n\r\n", font5));
		paragraph311.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph312 = new Paragraph(" ", font5);
		Chunk bullet24 = new Chunk("\u2022", font5);
		paragraph312.add(bullet24);
		paragraph312.add(new Phrase("IoT analytics\r\n+\r\n", font5));
		paragraph312.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph313 = new Paragraph(" ", font5);
		Chunk bullet25 = new Chunk("\u2022", font5);
		paragraph313.add(bullet25);
		paragraph313.add(new Phrase("Six English courses (Three new) \r\n\r\n", font5));
		paragraph313.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph314 = new Paragraph(" ", font5);
		Chunk bullet26 = new Chunk("\u2022", font5);
		paragraph314.add(bullet26);
		paragraph314.add(new Phrase("Computational Intelligence\r\n\r\n", font5));
		paragraph314.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph315 = new Paragraph(" ", font5);
		Chunk bullet27 = new Chunk("\u2022", font5);
		paragraph315.add(bullet27);
		paragraph315.add(new Phrase("Quantum Computing and Cryptography\r\n\r\n", font5));
		paragraph315.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle32 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle32.setSize(12);
		 */
		Paragraph paragraph32 = new Paragraph("Courses with hands on lab exercises:\r\n\r\n", font3);
		paragraph32.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle33 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle33.setSize(12);
		 */
		Paragraph paragraph33 = new Paragraph("", font5);
		Chunk bullet28 = new Chunk("\u2022", font5);
		paragraph33.add(bullet28);
		paragraph33.add(new Phrase("Statistics for Machine Learning \r\n\r\n", font5));
		paragraph33.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph331 = new Paragraph("", font5);
		Chunk bullet29 = new Chunk("\u2022", font5);
		paragraph33.add(bullet29);
		paragraph33.add(new Phrase("Digital Forensics \r\n\r\n", font5));
		paragraph33.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph332 = new Paragraph("", font5);
		Chunk bullet30 = new Chunk("\u2022", font5);
		paragraph332.add(bullet30);
		paragraph332.add(new Phrase("Wireless sensor networks \r\n\r\n", font5));
		paragraph332.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph333 = new Paragraph("", font5);
		Chunk bullet31 = new Chunk("\u2022", font5);
		paragraph333.add(bullet31);
		paragraph333.add(new Phrase("Smart Sensors and Instrumentation\r\n\r\n", font5));
		paragraph333.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph334 = new Paragraph("", font5);
		Chunk bullet32 = new Chunk("\u2022", font5);
		paragraph334.add(bullet32);
		paragraph334.add(new Phrase("Design Thinking \r\n\r\n", font5));
		paragraph334.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph3);
		document.add(paragraph4);
		document.add(paragraph5);
		document.add(paragraph6);
		document.add(paragraph7);
		document.add(paragraph8);
		document.add(paragraph9);
		document.add(paragraph10);
		document.add(paragraph11);
		document.add(paragraph12);
		document.add(paragraph13);
		document.add(paragraph14);
		document.add(paragraph15);
		document.add(paragraph16);
		document.add(paragraph17);
		document.add(paragraph18);
		document.add(paragraph19);
		document.add(paragraph20);
		document.add(paragraph21);
		document.add(paragraph22);
		document.add(paragraph23);
		document.add(paragraph24);
		document.add(paragraph25);
		document.add(paragraph26);
		document.add(paragraph27);
		document.add(paragraph28);
		document.add(paragraph29);

		document.add(paragraph291);
		document.add(paragraph292);
		document.add(paragraph293);
		document.add(paragraph294);
		document.add(paragraph295);
		document.add(paragraph296);
		// document.add(paragraph297);

		document.add(paragraph30);
		document.add(paragraph31);
		document.add(paragraph311);
		document.add(paragraph312);
		document.add(paragraph313);
		document.add(paragraph314);
		document.add(paragraph315);

		document.add(paragraph32);
		document.add(paragraph33);
		document.add(paragraph331);
		document.add(paragraph332);
		document.add(paragraph333);
		document.add(paragraph334);

		// creating table
		PdfPTable table = new PdfPTable(2);

		table.setWidthPercentage(100);

		/*
		 * com.lowagie.text.Font headerFont =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * headerFont.setColor(CMYKColor.BLACK);
		 */

		// create table for header
		PdfPCell cell1 = new PdfPCell(new Paragraph("FileDiscription", font3));
		PdfPCell cell2 = new PdfPCell(new Paragraph("Document", font3));
		PdfPCell cell3 = new PdfPCell(new Paragraph("Any aditional information", font5));
		PdfPCell cell4 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
		PdfPCell cell5 = new PdfPCell(new Paragraph("Link for Aditional information", font5));
		PdfPCell cell6 = new PdfPCell(new Paragraph(" "));

		/*
		 * com.lowagie.text.Font fontTitle34 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle34.setSize(12);
		 */
		Paragraph paragraph34 = new Paragraph(
				"1.1.2 Percentage of Programmes where syllabus revision was carried out during the last five years.\r\n"
						+ "\r\n",
				font5);
		paragraph34.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle35 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle35.setSize(12);
		 */
		Paragraph paragraph35 = new Paragraph("Response\r\n"
				+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getResponse112()
						: ""),
				font3);
		paragraph35.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle36 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle36.setSize(12);
		 */
		Paragraph paragraph36 = new Paragraph(
				"1.1.2.1 Number of all Programmes offered by the institution during the last five years.\r\n" + "\r\n"
						+ "",
				font3);
		paragraph36.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle37 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle37.setSize(12);
		 */
		Paragraph paragraph37 = new Paragraph("Response:"
				+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1121t1() : ""),
				font5);
		paragraph37.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle38 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle38.setSize(12);
		 */
		Paragraph paragraph38 = new Paragraph(
				"1.1.2.2 How many Programmes were revised out of total number of Programmes offered during the last five years",
				font5);
		paragraph38.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * com.lowagie.text.Font fontTitle39 =
		 * FontFactory.getFont(FontFactory.HELVETICA); fontTitle39.setSize(12);
		 */
		Paragraph paragraph39 = new Paragraph("Response:"
				+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1122t1() : ""),
				font5);
		paragraph39.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		PdfPTable table1 = new PdfPTable(2);
		table1.setWidthPercentage(100);

		PdfPTable table11 = new PdfPTable(1);
		table11.setWidthPercentage(100);

		/*
		 * com.lowagie.text.Font font1 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		 * font1.setColor(CMYKColor.BLACK);
		 */
		PdfPCell cell11 = new PdfPCell(new Paragraph("FileDiscription", font3));
		PdfPCell cell12 = new PdfPCell(new Paragraph("Document", font3));
		PdfPCell cell13 = new PdfPCell(new Paragraph("Minutes of relevant Academic Council/BOS meeting", font3));
		PdfPCell cell14 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""));
		PdfPCell cell15 = new PdfPCell(
				new Paragraph("Details of program syllabus revision in last 5 years(Data Template)"));
		PdfPCell cell16 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
		PdfPCell cell17 = new PdfPCell(new Paragraph("Any additional information"));
		PdfPCell cell18 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : ""));
		PdfPCell cell19 = new PdfPCell(new Paragraph("Link for Additional Information"));
		PdfPCell cell20 = new PdfPCell(new Paragraph(""));

		PdfPTable table3 = new PdfPTable(2);
		table3.setWidthPercentage(100);

		PdfPCell cell31 = new PdfPCell(new Paragraph("FileDiscription\r\n", font3));
		PdfPCell cell32 = new PdfPCell(new Paragraph("Document\r\n", font3));
		PdfPCell cell33 = new PdfPCell(new Paragraph("Programme / Curriculum/ Syllabus of the courses\r\n+\r\n"));
		PdfPCell cell34 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(3).getCriteria1FilePath() : ""));
		PdfPCell cell35 = new PdfPCell(new Paragraph("MoU's with relevant organizations for these courses, if any"));
		PdfPCell cell36 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : ""));

		PdfPCell cell37 = new PdfPCell(new Paragraph(
				"Minutes of the Boards of Studies/ Academic Council meetings with approvals for these courses"));
		PdfPCell cell38 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : ""));
		PdfPCell cell39 = new PdfPCell(new Paragraph(
				"Average percentage of courses having focus on employability/ entrepreneurship(Data Template)"));
		PdfPCell cell40 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : ""));
		PdfPCell cell41 = new PdfPCell(new Paragraph("Link for Additional Information\r\n+\r\n"));
		PdfPCell cell42 = new PdfPCell(new Paragraph(""));

		/*
		 * com.lowagie.text.Font fontTitle43 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle43.setSize(16)
		 */

		Paragraph paragraph43 = new Paragraph("1.2 Academic Flexibility\r\n", font2);
		paragraph43.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		// creating tabl4

		PdfPTable table4 = new PdfPTable(2);
		table4.setWidthPercentage(100);
		PdfPTable table41 = new PdfPTable(1);
		table41.setWidthPercentage(100);

		/*
		 * com.lowagie.text.Font font4 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		 * font4.setColor(CMYKColor.BLACK);
		 */
		PdfPCell cell411 = new PdfPCell(new Paragraph("FileDiscription\r\n", font3));
		PdfPCell cell412 = new PdfPCell(new Paragraph("Document\r\n", font3));
		PdfPCell cell413 = new PdfPCell(new Paragraph("Minutes of relevant Academic Council/BOS meetings\r\n"));
		PdfPCell cell414 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(7).getCriteria1FilePath() : ""));
		PdfPCell cell415 = new PdfPCell(new Paragraph("Institutional data in prescribed format"));
		PdfPCell cell416 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(8).getCriteria1FilePath() : ""));
		PdfPCell cell417 = new PdfPCell(new Paragraph("Any additional information"));
		PdfPCell cell418 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(9).getCriteria1FilePath() : ""));
		PdfPCell cell419 = new PdfPCell(new Paragraph("Link for Additional Information\r\n"));
		PdfPCell cell420 = new PdfPCell(new Paragraph(""));

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

		PdfPCell cell511 = new PdfPCell(new Paragraph("FileDiscription\r\n", font3));
		PdfPCell cell512 = new PdfPCell(new Paragraph("Document\r\n", font3));
		PdfPCell cell513 = new PdfPCell(new Paragraph("Minutes of relevant Academic Council/BOS meetings"));
		PdfPCell cell514 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(10).getCriteria1FilePath() : ""));
		PdfPCell cell515 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n"));
		PdfPCell cell516 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(11).getCriteria1FilePath() : ""));
		PdfPCell cell517 = new PdfPCell(new Paragraph("Any additional information\r\n"));
		PdfPCell cell518 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(12).getCriteria1FilePath() : ""));
		PdfPCell cell519 = new PdfPCell(new Paragraph("Link for Additional Information\r\n"));
		PdfPCell cell520 = new PdfPCell(new Paragraph(""));
		// 3.1

		/*
		 * com.lowagie.text.Font fontTitle54 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle54.setSize(16);
		 */

		Paragraph paragraph54 = new Paragraph("1.3 Curriculum Enrichment\r\n+\r\n", font3);
		paragraph54.setAlignment(Paragraph.ALIGN_CENTER);

		// create table6

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

		PdfPCell cell611 = new PdfPCell(new Paragraph("FileDiscription\r\n", font3));
		PdfPCell cell612 = new PdfPCell(new Paragraph("Document\r\n", font3));
		PdfPCell cell613 = new PdfPCell(new Paragraph(
				"Upload the list and description of the courses which address the Gender, Environment and Sustainability, Human Values and Professional Ethics into the Curriculum"));
		PdfPCell cell614 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(13).getCriteria1FilePath() : ""));
		PdfPCell cell615 = new PdfPCell(new Paragraph("Any additional information\r\n"));
		PdfPCell cell616 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(14).getCriteria1FilePath() : ""));
		PdfPCell cell617 = new PdfPCell(new Paragraph("Link for Additional Information\r\n"));
		PdfPCell cell618 = new PdfPCell(new Paragraph(""));

		
		// create 8

		PdfPTable table81 = new PdfPTable(1);
		table81.setWidthPercentage(100);

		/*
		 * com.lowagie.text.Font font81 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font81.setColor(CMYKColor.BLACK);
		 */

		

		// create table8

		PdfPTable table8 = new PdfPTable(2);
		table8.setWidthPercentage(100);
		/*
		 * com.lowagie.text.Font font8 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font8.setColor(CMYKColor.BLACK);
		 */
		PdfPCell cell81 = new PdfPCell(new Paragraph("FileDiscription\r\n", font3));
		PdfPCell cell82 = new PdfPCell(new Paragraph("Document\r\n", font3));
		PdfPCell cell83 = new PdfPCell(new Paragraph("List of value added courses (Data Template)\r\n"));
		PdfPCell cell84 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(15).getCriteria1FilePath() : ""));
		PdfPCell cell85 = new PdfPCell(new Paragraph("Brochure or any other document relating to value added courses\r\n"));
		PdfPCell cell86 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(16).getCriteria1FilePath() : ""));
		PdfPCell cell87 = new PdfPCell(new Paragraph("Any additional information\r\n"));
		PdfPCell cell88 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(17).getCriteria1FilePath() : ""));
		PdfPCell cell89 = new PdfPCell(new Paragraph("Link for Additional Information\r\n"));
		PdfPCell cell90 = new PdfPCell(new Paragraph(""));

		// create table9
		PdfPTable table9 = new PdfPTable(5);
		PdfPTable table91 = new PdfPTable(1);
		// PdfPTable table92=new PdfPTable(2);

		table9.setWidthPercentage(100);
		table91.setWidthPercentage(100);
		// table92.setWidthPercentage(100);

		/*
		 * com.lowagie.text.Font font9 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		 * font9.setColor(CMYKColor.BLACK);
		 */
		
		PdfPTable table92 = new PdfPTable(2);

		table92.setWidthPercentage(100);

		PdfPCell cell921 = new PdfPCell(new Paragraph("FileDiscription\r\n", font3));
		PdfPCell cell922 = new PdfPCell(new Paragraph("Document\r\n", font3));
		PdfPCell cell923 = new PdfPCell(new Paragraph("List of students enrolled\r\n"));
		PdfPCell cell924 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(18).getCriteria1FilePath() : ""));
		PdfPCell cell925 = new PdfPCell(new Paragraph("Any additional information\r\n"));
		PdfPCell cell926 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(19).getCriteria1FilePath() : ""));
		PdfPCell cell927 = new PdfPCell(new Paragraph("Link for Additional Information\r\n"));
		PdfPCell cell928 = new PdfPCell(new Paragraph(""));

		// create table10
		PdfPTable table10 = new PdfPTable(2);
		table10.setWidthPercentage(100);

		PdfPTable table101 = new PdfPTable(1);
		table101.setWidthPercentage(100);

		PdfPCell cell101 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
		PdfPCell cell102 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		PdfPCell cell103 = new PdfPCell(new Paragraph(
				"List of programs and number of students undertaking field projects / internships / student projects (Data Template)"));
		PdfPCell cell104 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(20).getCriteria1FilePath() : ""));
		PdfPCell cell105 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
		PdfPCell cell106 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(21).getCriteria1FilePath() : ""));
		PdfPCell cell107 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
		PdfPCell cell108 = new PdfPCell(new Paragraph(""));

		/*
		 * com.lowagie.text.Font fontTitle67 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle67.setSize(16);
		 */

		Paragraph paragraph67 = new Paragraph("1.4  Feedback System\r\n\r\n", font3);
		paragraph67.setAlignment(Paragraph.ALIGN_CENTER);

		PdfPTable table111 = new PdfPTable(2);
		table111.setWidthPercentage(100);

		PdfPTable table110 = new PdfPTable(1);
		table110.setWidthPercentage(100);

		PdfPCell cell111 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
		PdfPCell cell112 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		PdfPCell cell113 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
		PdfPCell cell114 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(22).getCriteria1FilePath() : ""));
		PdfPCell cell115 = new PdfPCell(new Paragraph(
				"Action taken report of the Institution on feedback report as minuted by the Governing Council, Syndicate, Board of Management\r\n\r\n"));
		PdfPCell cell116 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(23).getCriteria1FilePath() : ""));
		PdfPCell cell117 = new PdfPCell(new Paragraph("URL for stakeholder feedback report"));
		PdfPCell cell118 = new PdfPCell(new Paragraph((criteria1file.size() > 0 && criteria1file.get(24) != null)
				? criteria1file.get(23).getCriteria1FilePath()
				: ""));
		PdfPCell cell119 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
		PdfPCell cell1120 = new PdfPCell(new Paragraph(""));

		// create table12
		PdfPTable table12 = new PdfPTable(2);
		table12.setWidthPercentage(100);

		PdfPTable table121 = new PdfPTable(1);
		table121.setWidthPercentage(100);

		PdfPCell cell121 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
		PdfPCell cell122 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		PdfPCell cell123 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
		PdfPCell cell124 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(25).getCriteria1FilePath() : ""));
		PdfPCell cell125 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
		PdfPCell cell126 = new PdfPCell(new Paragraph(
				(criteria1file.size() > 0 && criteria1file.contains(26)) ? criteria1file.get(26).getCriteria1FilePath()
						: ""));
		PdfPCell cell127 = new PdfPCell(new Paragraph("URL for stakeholder feedback report\r\n\r\n"));
		PdfPCell cell128 = new PdfPCell(new Paragraph(""));

		table.addCell(cell1);
		table.addCell(cell2);
		table.addCell(cell3);
		table.addCell(cell4);
		table.addCell(cell5);
		table.addCell(cell6);
		
		table.setSpacingAfter(20f);
		table.setSpacingAfter(20f);
		
		document.add(table);

		table1.addCell(cell11);
		table1.addCell(cell12);
		table1.addCell(cell13);
		table1.addCell(cell14);
		table1.addCell(cell15);
		table1.addCell(cell16);
		table1.addCell(cell17);
		table1.addCell(cell18);
		table1.addCell(cell19);
		table1.addCell(cell20);

		table11.addCell(
				"1.1.2 Percentage of Programmes where syllabus revision was carried out during the last five years.\r\n"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria11Qn().get(0).getResponse112()
								: ""));

		table11.addCell("1.1.2.1 Number of all Programmes offered by the institution during the last five years.\r\n"
				+ "\r\n" + "Response:"
				+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1121t1() : ""));
		table11.addCell(
				"1.1.2.2 How many Programmes were revised out of total number of Programmes offered during the last five years\r\n"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1122t1()
								: ""));

		table11.addCell(table1);
		table11.setSpacingAfter(25);
		document.add(table11);

		Table table1131 = new Table(criteria1Record.getYearTable1131().size(), 2);

		table1131.setPadding(10);
		table1131.setWidth(100f);

		for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
			table1131.addCell(criteria1Record.getYearTable1131().get(i).getInput1131y());
		}
		for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
			table1131.addCell(criteria1Record.getYearTable1131().get(i).getInput1131v());
		}

		document.add(table1131);

		PdfPTable table31 = new PdfPTable(1);
		table31.setWidthPercentage(100);

		PdfPTable table113_1 = new PdfPTable(5);
		table113_1.setWidthPercentage(100);

		


		table31.addCell(
				"1.1.3 Average percentage of courses having focus on employability/ entrepreneurship/ skill development offered by the institution during the last five years\r\n"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria11Qn().get(0).getResponse113()
								: ""));
		table31.addCell(
				"1.1.3.1 Number of courses having focus on employability/ entrepreneurship/ skill development year- wise during the last five years\r\n+\r\n");

		// table31.addCell(table113_1);

		table31.setSpacingBefore(25);
		table31.setSpacingAfter(25);

		document.add(table31);
		document.add(table1131);

		table3.addCell(cell31);
		table3.addCell(cell32);
		table3.addCell(cell33);
		table3.addCell(cell34);
		table3.addCell(cell35);
		table3.addCell(cell36);
		table3.addCell(cell37);
		table3.addCell(cell38);
		table3.addCell(cell39);
		table3.addCell(cell40);
		table3.addCell(cell41);
		table3.addCell(cell42);

		document.add(table3);
		document.add(paragraph43);

		table4.addCell(cell411);
		table4.addCell(cell412);
		table4.addCell(cell413);
		table4.addCell(cell414);
		table4.addCell(cell415);
		table4.addCell(cell416);
		table4.addCell(cell417);
		table4.addCell(cell418);
		table4.addCell(cell419);
		table4.addCell(cell420);
		table41.addCell(
				"1.2.1 Percentage of new courses introduced of the total number of courses across all programs offered during the last five years.\r\n"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria12Qn().get(0).getResponse121()
								: ""));
		table41.addCell("1.2.1.1 How many new courses are introduced within the last five years\r\n" + "\r\n"
				+ "Response:"
				+ (criteria1Record != null ? criteria1Record.getCriteria12Qn().get(0).getInput1211t1() : ""));
		table41.addCell(
				"1.2.1.2 Number of courses offered by the institution across all programmes during the last five years.\r\n"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null ? criteria1Record.getCriteria12Qn().get(0).getInput1212t1()
								: ""));

		table41.addCell(table4);

		table41.setSpacingBefore(25);
		table41.setSpacingAfter(25);

		document.add(table41);

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

		table5a.addCell(
				"1.2.2 Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year).\r\n"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria12Qn().get(0).getResponse122()
								: ""));
		table5a.addCell("1.2.2.1 Number of Programmes in which CBCS / Elective course system implemented.\r\n" + "\r\n"
				+ "Response:"
				+ (criteria1Record != null ? criteria1Record.getCriteria12Qn().get(0).getInput1221t1() : ""));

		table5a.addCell(table5);
		table5a.setSpacingAfter(25f);
		document.add(table5a);

		document.add(paragraph54);

		table6.addCell(cell611);
		table6.addCell(cell612);
		table6.addCell(cell613);
		table6.addCell(cell614);
		table6.addCell(cell615);
		table6.addCell(cell616);
		table6.addCell(cell617);
		table6.addCell(cell618);
		table61.addCell(
				"1.3.1	Institution integrates crosscutting issues relevant to Professional Ethics ,Gender, Human Values ,Environment and Sustainability into the Curriculum\r\n");
		table61.addCell("Response:"
				+ (criteria1Record != null ? criteria1Record.getCriteria13Ql().get(0).getResponse131()
						: ""));
		
		table61.addCell("Human Values and Professional Ethics\r\n" + "");
		
		
		table61.addCell(
				"Mother Teresa believes that its graduates/post-graduates have a responsibility to their Profession and the Organization that they serve. Every employer expects a certain set of skills, knowledge, inputs and attitude in an employee. Attitude normally gets reinforced through the three Es�: Education, Environment, and Experience. Therefore, our Institution takes adequate care to infuse a positive attitude in our learners by giving relevant inputs, which touch human lives at large. Courses such as �Human Values and Professional Ethics�, �Business Ethics�, Construction Management, Estimation and Costing, Engineering Economics and Accountancy facilitate development of a holistic perspective among students towards life, profession, empathy and happiness, based on the right understanding of the purpose of human existence, inculcating self-actualization, the highest of the Maslow�s pyramid of hierarchy of needs. Such a holistic perspective forms the basis of value-based education and quality of college life provided at Mother Teresa.\r\n"
						+ "\r\n"
						+ "Students are sensitized to Professional Ethics, through various activities organized under the students� clubs so that as they graduate, they are able to discharge their professional responsibilities with integrity, dignity, fairness and courtesy. They are also sensitized to avoid activities which may lead to conflict with colleagues and/or organizations, not accept any financial/contractual obligation on behalf of his/her employer/client without due authority, treat colleagues and co-workers fairly and not misuse the advantage of their hierarchical position\r\n\r\n"
						+ "Gender equality and Sensitization:\r\n\r\n" + "\r\n"
						+ "For students to demonstrate sensitivity with regard to gender issues, particularly on biological changes with age, showing empathy and practicing healthy socialization is imminent for both the genders.A course on �Gender Sensitization� introduced in the curriculum is implemented through activity-based learning. Gender issues are also discussed in courses, namely, �Human Resource Management� and �Indian Constitution�. For promoting Gender Sensitization, several activities are organized in the institution which include, �Gender Equality - Its importance�, �Women in Nation Building�, �Training on self-defense techniques�, �Health and Hygiene� and �Impact of gender violence on society�. They are also sensitized to respect women and their contribution to the economy and development of the society and practice\r\n"
						+ "gender equality by sharing domestic duties and the like.\r\n" + "\r\n"
						+ "Environment and Sustainability:\r\n" + "\r\n"
						+ "To create awareness about the environmental impact on society due to urbanization and industrialization, courses on �Environmental Studies�, �Green Buildings�, �Global Warming and Climate Change�, �Renewable Energy Sources�, �Energy Conservation Management�, �Environmental Engineering�, �Air Pollution and Control� are included in the curriculum, which facilitates students to understand the ecosystem, its functions, and acquire knowledge about the different types of natural resources, namely, land, water, minerals, non-renewable energy, their excessive usage leads to detrimental effects on the environment is realized by understanding the different types of pollution, their impact on global environment and ways of controlling them. Campaigns on �Dust and Pollution Free Environment�, �Haritha Haram� (tree plantation), �Swachh Bharath�, are conducted with participation of students to promote ecological balance for sustainable development.\r\n\r\n"
						+ "");

		
		table61.addCell(table6);
		table.setSpacingAfter(25);
		document.add(table61);

		PdfPTable table71 = new PdfPTable(1);
		table71.setWidthPercentage(100);
		
		table71.addCell(
				"1.3.2 Number of value-added courses for imparting transferable and life skills offered during last five years.\r\n"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria13Qn().get(0).getResponseValue132()
								: ""));
		table71.addCell("1.3.2.1 How many new value-added courses are added within the last five years");

		table71.setSpacingBefore(25f);
		table71.setSpacingAfter(25f);
		
		document.add(table71);

		Table table1321 = new Table(criteria1Record.getYearTable1321().size(), 2);

		table1321.setPadding(10);
		table1321.setWidth(100f);
		for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {
			table1321.addCell(criteria1Record.getYearTable1321().get(i).getInput1321y());
		}
		for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {
			table1321.addCell(criteria1Record.getYearTable1321().get(i).getInput1321v());
		}

		document.add(table71);
		// document.add(table1321);


		
		table81.addCell(
				"1.3.2 Number of value-added courses for imparting transferable and life skills offered during last five years.\r\n"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria13Qn().get(0).getResponseValue132()
								: ""));

		table81.addCell("1.3.2.1 How many new value-added courses are added within the last five years\r\n");

		// table81.addCell(table82);

		document.add(table81);
		// document.add(table1321);

		table8.addCell(cell81);
		table8.addCell(cell82);
		table8.addCell(cell83);
		table8.addCell(cell84);
		table8.addCell(cell85);
		table8.addCell(cell86);
		table8.addCell(cell87);
		table8.addCell(cell88);
		table8.addCell(cell89);
		table8.addCell(cell90);

		table8.setSpacingAfter(25f);
		document.add(table1321);
		document.add(table8);

		
		table91.addCell("1.3.3 Average Percentage of students enrolled in the courses under 1.3.2 above.\r\n" + "\r\n"
				+ "Response:"
				+ (criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getResponse133()
						: ""));

		table91.addCell(
				"1.3.3.1 Number of students enrolled in subject related Certificate or Add-on programs year wise during last five years");
		// table91.addCell(table9);
		table9.setSpacingAfter(25f);

		Table table1331 = new Table(criteria1Record.getYearTable1331().size(), 2);

		table1331.setPadding(10);
		table1331.setWidth(100f);
		for (int i = 0; i < criteria1Record.getYearTable1331().size(); i++) {
			table1331.addCell(criteria1Record.getYearTable1331().get(i).getInput1331y());
		}
		for (int i = 0; i < criteria1Record.getYearTable1331().size(); i++) {
			table1331.addCell(criteria1Record.getYearTable1331().get(i).getInput1331v());
		}
		// document.add(table1331);

		document.add(table91);

		table92.addCell(cell921);
		table92.addCell(cell922);
		table92.addCell(cell923);
		table92.addCell(cell924);
		table92.addCell(cell925);
		table92.addCell(cell926);
		table92.addCell(cell927);
		table92.addCell(cell928);

		document.add(table1331);
		// table92.addCell(table9);
		document.add(table92);

		table10.addCell(cell101);
		table10.addCell(cell102);
		table10.addCell(cell103);
		table10.addCell(cell104);
		table10.addCell(cell105);
		table10.addCell(cell106);
		table10.addCell(cell107);
		table10.addCell(cell108);

		table101.addCell(
				"1.3.4 Percentage of students undertaking field projects/ internships / student projects (Data for the latest completed academic year)\r\n"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria13Qn().get(0).getResponse134()
								: ""));
		table101.addCell("1.3.4.1 Number of students undertaking field projects / internships / student projects\r\n"
				+ "\r\n" + "Response:"
				+ (criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getInput1341t1() : ""));
		table101.addCell(table10);

		table101.setSpacingBefore(25f);
		table101.setSpacingAfter(25f);
		document.add(table101);
		document.add(paragraph67);

		table111.addCell(cell111);
		table111.addCell(cell112);
		table111.addCell(cell113);
		table111.addCell(cell114);
		table111.addCell(cell115);
		table111.addCell(cell116);
		table111.addCell(cell117);
		table111.addCell(cell118);
		table111.addCell(cell119);
		table111.addCell(cell1120);
		table110.addCell(
				"1.4.1 Structured feedback for design and review of syllabus � semester-wise / year-wise is received from 1) Students, 2) Teachers, 3) Employers, 4) Alumni\r\n"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria14Qn().get(0).getResponse141()
								: ""));

		table110.addCell(table111);
		document.add(table110);

		table12.addCell(cell121);
		table12.addCell(cell122);
		table12.addCell(cell123);
		table12.addCell(cell124);
		table12.addCell(cell125);
		table12.addCell(cell126);
		table12.addCell(cell127);
		table12.addCell(cell128);
		table121.addCell(
				"1.4.2 The feedback system of the Institution comprises of the following :\r\n" + "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria14Qn().get(0).getResponse142()
								: ""));

		table121.addCell(table12);
		table121.setSpacingBefore(25f);
		table121.setSpacingAfter(25f);

		document.add(table121);

////////////////////////////////////////////////////
///////////////////criteria 1 end..............
/////////////////////////////////////////

	}

	public void Criteria2(Document document) {

//////////////////////////////////////////////////////////
/////////////////////////Criteria 2  starts.....................
/////////////////////////////////

// Creating font
// Setting font style and size
		/*
		 * Font fontTiltle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontTiltle.setSize(16);
		 * 
		 * Font font1criteria2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font1criteria2.setColor(CMYKColor.BLACK); font1criteria2.setSize(14);
		 * 
		 * Font font2criteria2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font2criteria2.setSize(12);
		 */

		PdfPTable tablecriteria2 = new PdfPTable(1);
		PdfPTable table1criteria2 = new PdfPTable(1);
// PdfPTable table4criteria2 = new PdfPTable(5);

// PdfPTable table5criteria2= new PdfPTable(5);

		PdfPTable table3criteria2 = new PdfPTable(2);

		PdfPTable table6criteria2 = new PdfPTable(5);
		PdfPTable table7criteria2 = new PdfPTable(2);

		Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
		Paragraph paragraph3criteria2 = new Paragraph("2.1 Student Enrollment and Profile\r\n+\r\n", font2);

		paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		paragraph3criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph2criteria2);
		document.add(paragraph3criteria2);

		tablecriteria2.setWidthPercentage(100f);
		tablecriteria2
				.addCell("2.1.1 Average Enrolment percentage (Average of last five years)\r\n" + "\r\n" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria21Qn().get(0).getResponse211()
								: ""));

		// Paragraph paragraph6 = new Paragraph("2.1.1.1 Number of students admitted
		// year-wise during last five years ", font3);
		tablecriteria2.addCell("2.1.1.1 Number of students admitted year-wise during last five years\r\n+\r\n ");

		document.add(tablecriteria2);

		Table table2111 = new Table(criteria2Record.getYearTable2111().size(), 2);

		table2111.setPadding(10);
		table2111.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
			table2111.addCell(criteria2Record.getYearTable2111().get(i).getInput2111y());
		}
		for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
			table2111.addCell(criteria2Record.getYearTable2111().get(i).getInput2111v());
		}

		document.add(table2111);

		tablecriteria2
				.addCell(" 2.1.1.2 Number of sanctioned seats year wise during last five years\r\n" + "\r\n" + " ");

		Table table2112 = new Table(criteria2Record.getYearTable2112().size(), 2);

		table2112.setPadding(10);
		table2112.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
			table2112.addCell(criteria2Record.getYearTable2112().get(i).getInput2112y());
		}
		for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
			table2112.addCell(criteria2Record.getYearTable2112().get(i).getInput2112v());
		}

		document.add(table2112);

		

		table3criteria2.setWidthPercentage(100f);
		table3criteria2.setWidths(new int[] { 3, 3 });
		table3criteria2.setSpacingBefore(5);

		PdfPCell cell1criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table3criteria2.addCell(cell1criteria2);

		PdfPCell cell2criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table3criteria2.addCell(cell2criteria2);

		PdfPCell cell3criteria2 = new PdfPCell(new Paragraph("Institutional data in prescribed format(Data Template)\r\n\r\n"));
		table3criteria2.addCell(cell3criteria2);

		PdfPCell cell4criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(10).getCriteria2FilePath() : ""));
		table3criteria2.addCell(cell4criteria2);

		PdfPCell cell5criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
		table3criteria2.addCell(cell5criteria2);

		PdfPCell cell6criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : ""));
		table3criteria2.addCell(cell6criteria2);

		PdfPCell cell7criteria2 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n"));
		table3criteria2.addCell(cell7criteria2);

		PdfPCell cell8criteria2 = new PdfPCell(new Paragraph(""));
		table3criteria2.addCell(cell8criteria2);

		document.add(table3criteria2);

		table1criteria2.setWidthPercentage(100f);

		table1criteria2.addCell(
				"2.1.2 Average percentage of seats filled against reserved categories (SC, ST, OBC, Divyangjan, etc. as per applicable reservation policy ) during the last five years ( exclusive of supernumerary seats)\r\n"
						+ "\r\nResponse: "
						+ (criteria2Record != null
								? criteria2Record.getCriteria21Qn().get(0).getResponse212()
								: ""));
		table1criteria2.addCell(
				"2.1.2.1 Number of actual students admitted from the reserved categories year wise during last five \r\n"
						+ "\r\n" + "");

		Table table2121 = new Table(criteria2Record.getYearTable2121().size(), 2);

		table2121.setPadding(10);
		table2121.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
			table2121.addCell(criteria2Record.getYearTable2121().get(i).getInput2121y());
		}
		for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
			table2121.addCell(criteria2Record.getYearTable2121().get(i).getInput2121v());
		}

		document.add(table2121);

		
		table1criteria2.addCell(table6criteria2);
		document.add(table1criteria2);

		table7criteria2.setWidthPercentage(100f);
		table7criteria2.setWidths(new int[] { 3, 3 });
		table7criteria2.setSpacingBefore(5);

		PdfPCell cell07criteria2 = new PdfPCell(new Paragraph("File Description\r\n+\r\n", font3));
		table7criteria2.addCell(cell07criteria2);

		PdfPCell cell08criteria2 = new PdfPCell(new Paragraph("Document\r\n+\r\n", font3));
		table7criteria2.addCell(cell08criteria2);

		PdfPCell cell09criteria2 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n+\r\n"));
		table7criteria2.addCell(cell09criteria2);

		PdfPCell cell10criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(2).getCriteria2FilePath() : ""));
		table7criteria2.addCell(cell10criteria2);

		PdfPCell cell11criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n+\r\n"));
		table7criteria2.addCell(cell11criteria2);

		PdfPCell cell12criteria2 = new PdfPCell(new Paragraph(""));
		table7criteria2.addCell(cell12criteria2);

		document.add(table7criteria2);

		Paragraph paragraph4criteria2 = new Paragraph("2.2 Catering to Student Diversity\r\n\r\n", font3);
		document.add(paragraph4criteria2);

		PdfPTable table01 = new PdfPTable(1);
		table01.setWidthPercentage(100f);
		table01.addCell(
				"2.2.1	The institution assesses the learning levels of the students and organises special Programmes for advanced learners and slow learners),\r\n"
						+ "\r\n" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria22Qn().get(0).getResponse221()
								: "")
						+ "Mother Teresa understands that most obvious characteristic of a slow learner, a limited attention span compared to other learners. To keep these slow learners actively engaged in the learning process, requires more than the usual variation in presentation methods (direct, indirect), classroom climate (co-operative, competitive), and instructional materials (videos, workbooks, co-operative activities, simulations, etc). Other immediately noticeable characteristics of slow learners are their deficiencies in basic skills (reading, writing, and mathematics), difficulty in comprehending abstract ideas, and most disconcerting is, unsystematic and less careful work habits.\r\n"
						+ "\r\n"
						+ "Keeping these in view, our faculty monitor students� performance during regular class activities, lab work, tutorials, assignments, mentoring, midterm and results of semester end examinations.\r\n"
						+ "\r\n"
						+ "In addition, of late, we have been administering psychometric tests. Students secured <50% of marks in midterm examinations, not able to participate enthusiastically in tutorials, unable to submit assignments in time, showing lack of interest with irregular attendance, not coping up with laboratory exercises are identified as slow learners. This exercise is carried out course-wise.\r\n"
						+ "\r\n"
						+ "Remedial Teaching: In addition to the regular classroom teaching, remedial teaching is conducted for slow learners through the use of activities, techniques and practices to eliminate weaknesses or deficiencies that the slow learner is known to have. For example, deficiencies in basic mathematical skills are reduced or eliminated by re-teaching the content that was not learned earlier. Sub-divide topics by reordering them so that students get multiple exposure of the topics facilitating better learning. Conventional instructional techniques such as drill and practice are also employed.\r\n"
						+ "\r\n"
						+ "Slow Learners are given separate learning materials through reinforcement of small segments of learning and are associated with a peer who is an advanced learner. Further, emphasizing on frequent assessment of the student progress, mentoring with close monitoring is conducted, parents are informed, is found to be reasonably effective.\r\n"
						+ "\r\n"
						+ "Additionally, based on the content of courses, faculty provide compensatory teaching, use ICT methodologies (pictures/animations/videos) and supplements it with additional learning resources and activities (through laboratory exercises and simulations, group discussions and co-operative learning, mini and major projects by forming a group of students, one each of advanced learner and slow learner).\r\n"
						+ "\r\n"
						+ "Advanced learners are encouraged to take up more challenging tasks. They are given additional training on value added courses ranging from advanced to highly advanced programming skills, Business English\r\n"
						+ " \r\n"
						+ "Certificate, additional training to participate in Hackathons, project exhibitions, facilitating them to build prototypes, participate in coding competitions, etc.\r\n"
						+ "\r\n"
						+ "All learners are given training on �Logical Reasoning, improving Vocabulary, Verbal Reasoning, and Quantitative aptitude, situational writing etc.� to get through preliminary test conducted by various companies for placements as well as preparation towards CAT/GRE/IELTS/TOEFL and other Public Sector Undertakings.\r\n"
						+ "\r\n"
						+ "In addition, 14 student professional bodies and 07 student clubs conducted several co-curricular activities wherein, all learners participated, which is a regular exercise.\r\n"
						+ "\r\n"
						+ "All learners are given career guidance, creating awareness on plethora of opportunities in terms of medium to highly paid jobs, pursue post-graduation etc.\r\n"
						+ "\r\n" + "\r\n" + "");

		document.add(table01);

		PdfPTable table8criteria2 = new PdfPTable(2);

		table8criteria2.setWidthPercentage(100f);
		table8criteria2.setWidths(new int[] { 3, 3 });
		table8criteria2.setSpacingBefore(5);

		PdfPCell cell13criteria2 = new PdfPCell(new Paragraph("File Description\r\n+\r\n", font3));
		table8criteria2.addCell(cell13criteria2);

		PdfPCell cell14criteria2 = new PdfPCell(new Paragraph("Document\r\n+\r\n", font3));
		table8criteria2.addCell(cell14criteria2);

		PdfPCell cell15criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n+\r\n"));
		table8criteria2.addCell(cell15criteria2);

		PdfPCell cell16criteria2 = new PdfPCell(new Paragraph(""));
		table8criteria2.addCell(cell16criteria2);

		document.add(table8criteria2);

		PdfPTable table02 = new PdfPTable(1);
		table02.setWidthPercentage(100f);
		table02.addCell("2.2.2 Student - Full time teacher ratio (Data for the latest completed academic year)\r\n"
				+ "\r\n" + "Response:"
				+ (criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getResponse222()
						: ""));
		document.add(table02);

		PdfPTable table9criteria2 = new PdfPTable(2);

		table9criteria2.setWidthPercentage(100f);
		table9criteria2.setWidths(new int[] { 3, 3 });
		table9criteria2.setSpacingBefore(5);

		PdfPCell cell17criteria2 = new PdfPCell(new Paragraph("File Description\r\n", font3));
		table9criteria2.addCell(cell17criteria2);

		PdfPCell cell18criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table9criteria2.addCell(cell18criteria2);

		PdfPCell cell19criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
		table9criteria2.addCell(cell19criteria2);

		PdfPCell cell20criteria2 = new PdfPCell(new Paragraph(""));
		table9criteria2.addCell(cell20criteria2);

		document.add(table9criteria2);

		Paragraph paragraph5criteria2 = new Paragraph("2.3	Teaching- Learning Process\r\n\r\n", font3);
		document.add(paragraph5criteria2);

		PdfPTable table03 = new PdfPTable(1);
		table03.setWidthPercentage(100f);

		PdfPCell cell001 = new PdfPCell(new Paragraph(
				"2.3.1 Student centric methods, such as experiential learning, participative learning and problem solving methodologies are used for enhancing learning experiences"
						+ "\r\n" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria23Ql().get(0).getResponse231()
								: "")
						+

						"Mother Teresa is committed to enhance the learning experience of its students, and follows a rigorous system of student-centric learning methods to inculcate and augment various skills among the students. Curricula of all programs include 30% of practicals, hands-on and activity-oriented courses.\r\n"
						+ "\r\n"
						+ "Experiential Learning: The college practices the Learn as you do method of learning through laboratory exercises, mini and major projects, design thinking, activity-oriented courses/internships/industry visits and Hackathons which facilitate the development of Problem-Solving Skills, through Project-Based Learning, in which various abilities such as creative designing of a system, applying an abstract concept or idea to a real-world problem, visualization of product design and realizing it, preparing an appropriate technical report and presenting it to a technical audience are achieved.\r\n"
						+ "\r\n"
						+ "In a few cases (02), emanating from such experiential learning, prototypes were developed by students and submitted for patenting or published as a patent. In few other cases (20), the ideations and applications\r\n"
						+ "were presented at Hackathons, which have won them laurels and awards/prizes (17). Every year, projects are exhibited at Exhibitions organized by the college and elsewhere, wherein, invited industry experts assess and identify some as suitable for product development, and reward them (03).\r\n"
						+ "\r\n"
						+ "Collaborative and Cooperative Learning is facilitated through peers wherein students discuss ideas with classmates, engage in subject-specific discussions and get feedback from classmates thereby augmenting mutual teaching-learning, assimilating multiple views to deepen the knowledge, promoting critical thinking and mitigating learner isolation. This has also led to inculcating effective teamwork and communication (including interpersonal and cross-cultural awareness), skills fostering individual accountability within the team, resulting in developing independent learning strategies.\r\n"
						+ "\r\n"
						+ "Group and participative learning towards development of Professional Competencies:\r\n"
						+ "\r\n"
						+ "Students take up course-based group projects, discuss ideas and develop ways to solve identified problems for specific applications, develop prototypes for further recognition and incentivization.\r\n"
						+ "\r\n"
						+ "Students discuss topics on emerging trends, innovative business ideas, prepare technical articles, business reports, present them at seminars/symposia. This promotes students� sensitivity towards the feelings of other team members in the group, help to develop listening skills, to be open to others� ideas, and look for opportunities to work collaboratively thus adding value to their profession and person, both, academically and socially.\r\n"
						+ "\r\n"
						+ "Learning through value added courses: Students develop hands on skills on advanced/emerging tools gaining adequate exposure to modern tool usage. During the last five years 43 value added courses have been offered and 5437 students have been the beneficiaries.\r\n"
						+ "\r\n"
						+ "Interactions with various external experts: Students are exposed to elite Guest Lectures, Industrial Visits, and Field trips, making them familiar with occupational environment, develop an ability to understand: what engineers do, the language and process of engineering design, and its economical aspects. They also understand the non-technical yet essential other side of engineering: its importance and impact on societal development and environmental issues for sustainability.\r\n"
						+ "\r\n"
						+ "Aside of the above, during the last five years, our students have taken up several Massive Open Online Courses (MOOCS) and such others (776).\r\n"
						+ "\r\n" + "\r\n" + ""));

		table03.addCell(cell001);

		document.add(table03);

		PdfPTable table10criteria2 = new PdfPTable(2);

		table10criteria2.setWidthPercentage(100f);
		table10criteria2.setWidths(new int[] { 3, 3 });
		table10criteria2.setSpacingBefore(5);

		PdfPCell cell21criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table10criteria2.addCell(cell21criteria2);

		PdfPCell cell22criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table10criteria2.addCell(cell22criteria2);

		PdfPCell cell23criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
		table10criteria2.addCell(cell23criteria2);

		PdfPCell cell24criteria2 = new PdfPCell(new Paragraph(" "));
		table10criteria2.addCell(cell24criteria2);

		document.add(table10criteria2);

		PdfPTable table04 = new PdfPTable(1);
		table04.setWidthPercentage(100f);

		PdfPCell cell002 = new PdfPCell(new Paragraph(
				"2.3.2 Teachers use ICT enabled tools including online resources for effective teaching and learning process."
						+ "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria23Ql().get(0).getResponse232()
								: "")
						+ "Faculty at Mother Teresa use appropriate ICT-enabled tools for effective teaching-learning and evaluation processes in the following ways: "
						+ "ICT-enabled tools used for Teaching-Learning:\r\n" + "\r\n"
						+ "Our faculty is quite savvy with the use of ICT-enabled tools for Classroom teaching-learning practices. Using Digital writing pads, preparing relevant power point presentations and videos, augment student learning experiences. Real time simulation exercises and virtual lab exercises adopted by teachers help in student-friendly demonstrations of complex concepts so that students comprehend/demystify them with ease and are able to understand the nuances of the exercises better. Such efforts have borne fruit in terms of not only better understanding by the Learners but also enhanced their long-term knowledge retention abilities. Students and Faculty have unlimited access to the institutional Wi-Fi network and digital library, for protracted ICT-enabled teaching-learning.\r\n"
						+ "\r\n"
						+ "Apart from the above-mentioned classroom and laboratory practices, our teachers are proficient in engaging the students through virtual modes using several platforms such as Google Suite, GoToMeeting, Microsoft Teams, Zoom and Cisco Webex. Need-based online teaching-learning practices which was mandated during the recent pandemics has now become a dual mode of teaching-learning apart from regular classroom practices. Guest lectures, Remedial classes, value added courses, orientation/induction programs, and a few virtual industry visits (held only during the pandemic), has widened the academic horizon of both the faculty and the students.\r\n"
						+ "\r\n"
						+ "WhatsApp/Telegram groups, Gmail groups, and email groups with Mother Teresa�s domain name have been shared amongst the faculty and students, to ensure interactive and collaborative work as also exchange of content between teachers and students. Such interactive sessions are closely monitored by the respective mentors, for surety of academic exchanges and discussions.\r\n"
						+ "\r\n"
						+ "Learners have been able to get an opportunity to work on live projects with other learners in and beyond/outside the college, interact with experts from other Institutions/organizations, resulting in not only a qualitative improvement of the Teaching�Learning Process but also ushering an awareness and abilities for collaborative working and mitigating learner isolation.\r\n"
						+ "\r\n" + "Use of ICT in Remedial Teaching\r\n" + "\r\n"
						+ "Remedial Teaching using ICT through video lectures (144) prepared by teachers, facilitates flexibility to learners to learn at their own pace and seek help from the teacher as and when required. URLs of animated videos and faculty lectures captured are uploaded onto YouTube (144).\r\n"
						+ "\r\n"
						+ "Use of ICT in Evaluation has facilitated quicker assessment and feedback within a short duration of administering the tests/examinations.\r\n"
						+ "\r\n"
						+ "Virtual Laboratories available on MHRD website, extensively used both by teachers and students provides better insight, experience and real time value addition to the academics, especially while studying the influence of a variable or a component on the performance of a system.\r\n"
						+ "\r\n"
						+ "Use of ICT for enhancing soft skills among students through video lectures, remote live sessions on programming skills, value added courses, aptitude skills (Quantitative, logical, reading comprehension, vocabulary, situational writing etc.) has enhanced their Thinking and Reasoning, improved comprehension capabilities, speed of reading and vocabulary, thus helping in their career progression and employability.\r\n"
						+ "\r\n"));

		table04.addCell(cell002);

		document.add(table04);

		PdfPTable table11criteria2 = new PdfPTable(2);

		table11criteria2.setWidthPercentage(100f);
		table11criteria2.setWidths(new int[] { 3, 3 });
		table11criteria2.setSpacingBefore(5);

		PdfPCell cell25criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table11criteria2.addCell(cell25criteria2);

		PdfPCell cell26criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table11criteria2.addCell(cell26criteria2);

		PdfPCell cell27criteria2 = new PdfPCell(new Paragraph(
				"Provide link for webpage describing ICT enabled tools including online resources for effective teaching and learning process"));
		table11criteria2.addCell(cell27criteria2);

		PdfPCell cell28criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : ""));
		table11criteria2.addCell(cell28criteria2);

		PdfPCell cell29criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n", font3));
		table11criteria2.addCell(cell29criteria2);

		PdfPCell cell30criteria2 = new PdfPCell(new Paragraph(""));
		table11criteria2.addCell(cell30criteria2);

		document.add(table11criteria2);

		PdfPTable table05 = new PdfPTable(1);
		table05.setWidthPercentage(100f);

		table05.addCell(
				"2.3.3 Ratio of students to mentor for academic and other related issues (Data for the latest completed academic year )\r\n"
						+ "\r\n" + "\"Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria23Qn().get(0).getResponse233()
								: ""));

		table05.addCell("2.3.3.1 Number of mentors \r\n" + "\r\n" + "Response:"
				+ (criteria2Record != null ? criteria2Record.getCriteria23Qn().get(0).getInput2331t1() : ""));

		document.add(table05);

		PdfPTable table13criteria2 = new PdfPTable(2);

		table13criteria2.setWidthPercentage(100f);
		table13criteria2.setWidths(new int[] { 3, 3 });
		table13criteria2.setSpacingBefore(5);

		PdfPCell cell31criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table13criteria2.addCell(cell31criteria2);

		PdfPCell cell32criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table13criteria2.addCell(cell32criteria2);

		PdfPCell cell33criteria2 = new PdfPCell(
				new Paragraph("Upload year wise, number of students enrolled and full time teachers on roll\r\n\r\n"));
		table13criteria2.addCell(cell33criteria2);

		PdfPCell cell34criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(4).getCriteria2FilePath() : ""));
		table13criteria2.addCell(cell34criteria2);

		PdfPCell cell35criteria2 = new PdfPCell(new Paragraph("Circulars pertaining to assigning mentors to mentees\r\n\r\n"));
		table13criteria2.addCell(cell35criteria2);

		PdfPCell cell36criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(5).getCriteria2FilePath() : ""));
		table13criteria2.addCell(cell36criteria2);

		PdfPCell cell37criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
		table13criteria2.addCell(cell37criteria2);

		PdfPCell cell38criteria2 = new PdfPCell(new Paragraph(""));
		table13criteria2.addCell(cell38criteria2);

		document.add(table13criteria2);

		PdfPTable table06 = new PdfPTable(1);
		table06.setWidthPercentage(100f);

		PdfPCell cell003 = new PdfPCell(new Paragraph(
				"2.3.4 Preparation and adherence of Academic Calendar and Teaching plans by the institution" + ""
						+ "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria23Ql().get(0).getResponse234()
								: "")
						+

						"Mother Teresa meticulously plans and executes all academic, co-curricular and extra-curricular activities through a well-conceived and executed academic calendar.\r\n"
						+ "\r\n"
						+ "The Academic calendar for each program is prepared by the Dean, Academics in consultation with HoDs, Controller of Examinations and Principal. Based on this each HoD in consultation with in- charges/coordinators enumerates various academic, co-curricular and extra-curricular activities in each semester/year. These are collated into a detailed academic calendar, reviewed by the College Academic Committee, and presented to the Academic Council, which approves with or without modifications. This is then circulated to all concerned well in advance and hosted on the website.\r\n"
						+ "\r\n"
						+ "Six to Eight weeks prior to the commencement of each semester, HoDs elicit course options from the faculty members which they would like to teach in the ensuing semester. The course options are given in such a way that each faculty member has at least one course with an associated laboratory component. Courses are allocated to the faculty based on their experience and expertise. When the number of sections is more, the senior most among the faculty teaching the particular course is designated as the course coordinator, who in association with others teaching the same course prepares the lesson plans for the course, specifying the array of activities, for the particular semester. They also prepare a course file by specifying the objectives of the course along with expected Learning Outcomes (LOs) and methods for assessing the Course Outcomes (COs).\r\n"
						+ " \r\n"
						+ "The course objectives specify the role it plays within each Program, its uniqueness within the Program and its relationship with other courses, as also the essential knowledge or skills likely to be gained from pursuing it, prerequisites for this course and its outcomes.\r\n"
						+ "\r\n"
						+ "Laboratory instructions are planned such that students acquire a thorough understanding of scientific methods/inquiries through problem solving, which include identifying and defining a problem, formulating the hypotheses, designing relevant experiments, collecting data through observations and experimentation, interpreting data and drawing conclusions. Subsequently, a report on the outcomes and their implications is prepared.\r\n"
						+ "\r\n"
						+ "Tutorial sessions are conducted by both teachers handling the course, through involved discussions and interactions with Learners and achieving solutions to problems.\r\n"
						+ "\r\n"
						+ "Teaching diary is maintained by each teacher detailing the topics discussed during each session, along with the record of students� attendance.\r\n"
						+ "\r\n"
						+ "Weekly report is maintained by each department for each section with track of the number of sessions engaged for each course along with the topics discussed and this is monitored by the Head of the Department and Dean, Academics.\r\n"
						+ "\r\n"
						+ "Course Coordinator monitors the progress of the course from time to time during each semester and communicates the same to the programme coordinator who advises other teachers teaching the same course appropriately.\r\n"
						+ "\r\n"
						+ "Programme Assessment Committee (PAC) reviews the progress of various courses and suggests appropriate revisionary measures.\r\n"
						+ "\r\n"
						+ "Various committees (both statutory and non-statutory) constituted for periodical reviews monitor the progress of curricular, co-curricular and extra-curricular activities. Academic committee, Academic council and Governing Body meet at stipulated intervals and review the activities at the institutional level.\r\n"
						+ "\r\n"));

		table06.addCell(cell003);
		document.add(table06);

		PdfPTable table15criteria2 = new PdfPTable(2);

		table15criteria2.setWidthPercentage(100f);
		table15criteria2.setWidths(new int[] { 3, 3 });
		table15criteria2.setSpacingBefore(5);

		PdfPCell cell39criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table15criteria2.addCell(cell39criteria2);

		PdfPCell cell40criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table15criteria2.addCell(cell40criteria2);

		PdfPCell cell41criteria2 = new PdfPCell(
				new Paragraph("Upload Academic Calendar and Teaching plans for five years\r\n\r\n"));
		table15criteria2.addCell(cell41criteria2);

		PdfPCell cell42criteria2 = new PdfPCell(new Paragraph(criteria2file.get(3).getCriteria2FilePath()));
		table15criteria2.addCell(cell42criteria2);

		document.add(table15criteria2);

		Paragraph paragraph6criteria2 = new Paragraph(" 2.4 Teacher Profile and Quality\r\n\r\n", font2);

		paragraph6criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph6criteria2);

		PdfPTable table07 = new PdfPTable(1);
		table07.setWidthPercentage(100f);

		PdfPCell cell004 = new PdfPCell(new Paragraph(
				"2.4.1 Average percentage of full time teachers against sanctioned posts during the last five years"
						+ "\r\n" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria24Qn().get(0).getResponse241()
								: ""),
				font3));
		table07.addCell(cell004);
		document.add(table07);

		PdfPTable table14 = new PdfPTable(2);

		table14.setWidthPercentage(100f);
		table14.setWidths(new int[] { 3, 3 });
		table14.setSpacingBefore(5);

		PdfPCell cell43 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table14.addCell(cell43);

		PdfPCell cell44 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table14.addCell(cell44);

		PdfPCell cell45 = new PdfPCell(
				new Paragraph("Year wise full time teachers and sanctioned posts for 5 years(Data Template)\r\n\r\n"));
		table14.addCell(cell45);

		PdfPCell cell46 = new PdfPCell(new Paragraph(criteria2file.get(4).getCriteria2FilePath()));
		table14.addCell(cell46);

		PdfPCell cell47 = new PdfPCell(new Paragraph("List of the faculty members authenticated by the Head of HEI\r\n\r\n"));
		table14.addCell(cell47);

		PdfPCell cell48 = new PdfPCell(new Paragraph(criteria2file.get(4).getCriteria2FilePath()));
		table14.addCell(cell48);

		PdfPCell cell49 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
		table14.addCell(cell49);

		PdfPCell cell50 = new PdfPCell(new Paragraph(""));
		table14.addCell(cell50);

		document.add(table14);

		PdfPTable table08 = new PdfPTable(1);
		table08.setWidthPercentage(100f);

		PdfPCell cell005 = new PdfPCell(new Paragraph(
				"2.4.2 Average percentage of full time teachers with Ph. D. / D.M. / M.Ch. / D.N.B Superspeciality / D.Sc. / D.Litt. during the last five years (consider only highest degree for count)"
						+ "\r\n" + "" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria24Qn().get(0).getResponse242()
								: ""),
				font3));

		table08.addCell(cell005);

		table08.addCell(
				" 2.4.2.1 Number of full time teachers with Ph.D./D.M/M.Ch./D.N.B Superspeciality/D.Sc./D�Lit. year wise during the last five years\r\n"
						+ "\r\n" + " ");

		Table table2421 = new Table(criteria2Record.getYearTable2421().size(), 2);

		table2421.setPadding(10);
		table2421.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
			table2421.addCell(criteria2Record.getYearTable2421().get(i).getInput2421y());
		}
		for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
			table2421.addCell(criteria2Record.getYearTable2421().get(i).getInput2421v());
		}

		document.add(table2421);

		

		PdfPTable table17 = new PdfPTable(2);

		table17.setWidthPercentage(100f);
		table17.setWidths(new int[] { 3, 3 });
		table17.setSpacingBefore(5);

		PdfPCell cell51 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table17.addCell(cell51);

		PdfPCell cell52 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table17.addCell(cell52);

		PdfPCell cell53 = new PdfPCell(new Paragraph("Institutional data in prescribed format (Data Template)\r\n\r\n"));
		table17.addCell(cell53);

		PdfPCell cell54 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(6).getCriteria2FilePath() : ""));
		table17.addCell(cell54);

		PdfPCell cell55 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
		table17.addCell(cell55);

		PdfPCell cell56 = new PdfPCell(new Paragraph(""));
		table17.addCell(cell56);

		document.add(table17);

		PdfPTable table20 = new PdfPTable(1);
		table20.setWidthPercentage(100f);

		PdfPCell cell009 = new PdfPCell(new Paragraph(
				"2.4.3 Average teaching experience of full time teachers in the same institution (Data for the latest completed academic year in number of years)"
						+ "\r\n" + "" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria24Qn().get(0).getResponse243()
								: ""),
				font3));

		table20.addCell(cell009);

		table20.addCell(" 2.4.3.1 Total experience of full-time teachers\r\n" + "\r\n" + " " + "Response:"
				+ (criteria2Record != null ? criteria2Record.getCriteria24Qn().get(0).getInput2431t1() : ""));

		document.add(table20);

		PdfPTable table21 = new PdfPTable(2);

		table21.setWidthPercentage(100f);
		table21.setWidths(new int[] { 3, 3 });
		table21.setSpacingBefore(5);

		PdfPCell cell61 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table21.addCell(cell61);

		PdfPCell cell62 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table21.addCell(cell62);

		PdfPCell cell63 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n"));
		table21.addCell(cell63);

		PdfPCell cell64 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(7).getCriteria2FilePath() : ""));
		table21.addCell(cell64);

		PdfPCell cell65 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
		table21.addCell(cell65);

		PdfPCell cell66 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(8).getCriteria2FilePath() : ""));
		table21.addCell(cell66);

		PdfPCell cell67 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
		table21.addCell(cell67);

		PdfPCell cell68 = new PdfPCell(new Paragraph());
		table21.addCell(cell68);

		document.add(table21);

		Paragraph paragraph7criteria2 = new Paragraph("2.5	Evaluation Process and Reforms\r\n\r\n", font3);

		paragraph7criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph7criteria2);

		PdfPTable table22 = new PdfPTable(1);
		table22.setWidthPercentage(100f);

		PdfPCell cell010 = new PdfPCell(new Paragraph(
				"2.5.1 Average number of days from the date of last semester-end/ year- end examination till the declaration of results year-wise during the last five years"
						+ "\r\n" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria25Qn().get(0).getResponse251()
								: ""),
				font3));

		table22.addCell(cell010);

		table22.addCell(
				"2.5.1.1 Number of days from the date of last semester-end/ year- end examination till the declaration of results year wise during the last five years\r\n"
						+ "\r\n" + " ");

		Table table2511 = new Table(criteria2Record.getYearTable2511().size(), 2);

		table2511.setPadding(10);
		table2511.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2511().size(); i++) {
			table2511.addCell(criteria2Record.getYearTable2511().get(i).getInput2511y());
		}
		for (int i = 0; i < criteria2Record.getYearTable2511().size(); i++) {
			table2511.addCell(criteria2Record.getYearTable2511().get(i).getInput2511v());
		}

		document.add(table2511);

		

		PdfPTable table24 = new PdfPTable(2);

		table24.setWidthPercentage(100f);
		table24.setWidths(new int[] { 3, 3 });
		table24.setSpacingBefore(5);

		PdfPCell cell69criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table24.addCell(cell69criteria2);

		PdfPCell cell70criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table24.addCell(cell70criteria2);

		PdfPCell cell71criteria2 = new PdfPCell(
				new Paragraph("Institutional data in prescribed format (Data Template)\r\n\r\n"));
		table24.addCell(cell71criteria2);

		PdfPCell cell72criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(9).getCriteria2FilePath() : ""));
		table24.addCell(cell72criteria2);

		PdfPCell cell73criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
		table24.addCell(cell73criteria2);

		PdfPCell cell74criteria2 = new PdfPCell(new Paragraph("", font3));
		table24.addCell(cell74criteria2);

		document.add(table24);

		PdfPTable table09 = new PdfPTable(1);
		table09.setWidthPercentage(100f);

		PdfPCell cell006 = new PdfPCell(new Paragraph(
				"2.5.2 Average percentage of student complaints/grievances about evaluation against total number appeared in the examinations during the last five years"
						+ "\r\n" + "" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria25Qn().get(0).getResponse252()
								: ""),
				font3));

		table09.addCell(cell006);

		table09.addCell(
				"2.5.2.1 Number of complaints/grievances about evaluation year wise during the last five years\r\n"
						+ "\r\n" + " ");

		Table table2521 = new Table(criteria2Record.getYearTable2521().size(), 2);

		table2521.setPadding(10);
		table2521.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2521().size(); i++) {
			table2521.addCell(criteria2Record.getYearTable2521().get(i).getInput2521y());
		}
		for (int i = 0; i < criteria2Record.getYearTable2521().size(); i++) {
			table2521.addCell(criteria2Record.getYearTable2521().get(i).getInput2521v());
		}

		document.add(table2521);

		

		PdfPTable table18 = new PdfPTable(2);

		table18.setWidthPercentage(100f);
		table18.setWidths(new int[] { 3, 3 });
		table18.setSpacingBefore(5);

		PdfPCell cell57 = new PdfPCell(new Paragraph("File Description", font3));
		table18.addCell(cell57);

		PdfPCell cell58 = new PdfPCell(new Paragraph("Document", font3));
		table18.addCell(cell58);

		PdfPCell cell59 = new PdfPCell(
				new Paragraph("Number of complaints and total number of students appeared year wise"));
		table18.addCell(cell59);

		PdfPCell cell60 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(10).getCriteria2FilePath() : ""));
		table18.addCell(cell60);

		document.add(table18);

		PdfPTable table25 = new PdfPTable(1);
		table25.setWidthPercentage(100f);

		PdfPCell cell011 = new PdfPCell(new Paragraph(
				"2.5.3 IT integration and reforms in the examination procedures and processes including Continuous Internal Assessment (CIA) have brought in considerable improvement in Examination Management System (EMS) of the Institution"
						+ "\r\n" + "" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria25Ql().get(0).getResponse253()
								: "")
						+ "\r\n" + ""
						+ "Mother Teresa has adopted a comprehensive EMS facilitated through IT integration and backed by a state-of-the-art hardware and software systems. This has tremendously reformed the examination procedures and processes including the CIA."

				, font3));

		table25.addCell(cell011);

		table25.addCell(
				"As per the academic calendar exam branch issues notifications related to Midterm examinations, Semester end examinations through college portal, WhatsApp groups and group mail.\r\n"
						+ "\r\n" + "The following operations pertaining to conduct of examinations are automated\r\n"
						+ "\r\n" + "Comprehensive student profile database\r\n"
						+ "Sending appointment orders to external examiners\r\n"
						+ "Student registrations for semester end (Regular & Supplementary) examinations Generation of hall tickets\r\n"
						+ "Student seating plan generation\r\n"
						+ "Barcoded answer booklet generation and printing with student photo and signature for end semester exams\r\n"
						+ "Attendance sheet generation\r\n" + "Scanning, coding and decoding of answer booklets\r\n"
						+ "Digital evaluation facilitating remote evaluation for both CIE and SEE\r\n"
						+ "Result processing (with built-in Grafting and Moderation as per affiliating university guidelines) Publication of results\r\n"
						+ "Generation of\r\n"
						+ "Memorandum of marks with SGPA and intermittent CGPA up to the end of corresponding semester\r\n"
						+ "Consolidated memorandum of marks with SGPA and CGPA Provisional Certificate with student photo\r\n"
						+ "Transcripts\r\n" + "Result analysis, branch wise, year wise, course wise and overall\r\n"
						+ "\r\n" + "Examination Procedure\r\n" + "\r\n"
						+ "Midterm examinations: Two midterm examinations and one make-up test are conducted For each theory course there is an internal evaluation for 30 marks.\r\n"
						+ "Reforms in midterm examination:\r\n" + "\r\n"
						+ "1.Two sets of question papers, are set by a team of internal examiners, headed by the course coordinator. The question paper is then evaluated by a department question paper evaluation committee comprising senior faculty members of the department and a member from other department to verify whether\r\n"
						+ "The question paper tests student�s higher order thinking skills, wherever feasible Balanced question paper covering all outcomes is given\r\n"
						+ "Question paper is adhering to various levels of Bloom�s taxonomy, with more questions pertaining to higher levels for third and final year courses, and lesser number of questions for second and first year courses.\r\n"
						+ "\r\n"
						+ "Proforma for evaluating quality of the question paper in midterm examination is enclosed as additional document.\r\n"
						+ "\r\n"
						+ "Semester End Examination: Panel of examiners for preparation of question papers and evaluation of the answer scripts, chosen from various autonomous colleges and universities of repute, duly approved by the\r\n"
						+ " \r\n" + "Board of studies of the concerned department.\r\n" + "\r\n"
						+ "Guidelines are given to examiners with regard to the levels of Bloom�s taxonomy that shall be used in the preparation of question papers.\r\n"
						+ "\r\n"
						+ "Examiners are also provided the syllabus copy along with the structure of the question paper. Multiple question papers are elicited and the best question paper in terms of adherence to quality, higher order thinking levels and highly balanced one is selected for the examination purpose through scrutiny of the Question paper which shall be carried out by the Chairperson of Board of Studies, along with a senior faculty member/chief examiner (subject expert/course coordinator).\r\n"
						+ "\r\n" + "Evaluation:\r\n" + "\r\n"
						+ "1.	For the purpose of evaluation of semester end examination answer books, evaluators who have taught the course for a minimum of 5 times are invited and chief examiner conducts a meeting with them, explains scheme of evaluation.\r\n"
						+ "2.	The chief examiner randomly verifies at least ten percent of the evaluated answer books for consistency and correctness of evaluation, choosing a third each from the ten percent of the highest, moderately and least scored respectively. If the chief examiner is not satisfied with the evaluation methodology adopted by the evaluator, another 10% of the scripts are again evaluated by the chief examiner in manner similar described above. If the chief examiner is still not satisfied with the evaluation, the matter is escalated to the controller of examinations for further action. The controller of examinations shall then arrange re-evaluation of the scripts either by the same evaluator or a different evaluator.\r\n"
						+ "3.	No evaluator shall be given more than a bundle (60 answer booklets) in a day.\r\n"
						+ "\r\n"
						+ "All the above reforms have resulted in improving quality of the examination system, ensuring confidentiality in evaluation and bringing transparency in the process.\r\n"
						+ "");

		document.add(table25);

		PdfPTable table26 = new PdfPTable(2);

		table26.setWidthPercentage(100f);
		table26.setWidths(new int[] { 3, 3 });
		table26.setSpacingBefore(5);

		PdfPCell cell75criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table26.addCell(cell75criteria2);

		PdfPCell cell76criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table26.addCell(cell76criteria2);

		PdfPCell cell77criteria2 = new PdfPCell(
				new Paragraph("Number of complaints and total number of students appeared year wise\r\n\r\n"));
		table26.addCell(cell77criteria2);

		PdfPCell cell78criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(11).getCriteria2FilePath() : ""));
		table26.addCell(cell78criteria2);

		document.add(table26);

		Paragraph paragraph8criteria2 = new Paragraph("2.6 Student Performance and Learning Outcomes\r\r\n\n", font2);

		paragraph8criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph8criteria2);

		PdfPTable table27 = new PdfPTable(1);
		table27.setWidthPercentage(100f);

		PdfPCell cell012 = new PdfPCell(new Paragraph(
				"2.6.1 Programme and course outcomes for all Programmes offered by the institution are stated and displayed on website and communicated to teachers and students."
						+ "\r\n" + "" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria26Ql().get(0).getResponse261()
								: "")
						+ "Mothertherisa has adequate measures to communicate the COs, both to the teachers and students well in time ahead of the beginning of the Course work, in the following manner:",
				font3));

		table27.addCell(cell012);

		table27.addCell("Following are sample Course Outcomes of UG program of each department:\r\n" + "\r\n"
				+ "1.	B. Tech Civil Engineering and B. Tech Mechanical Engineering:\r\n" + "\r\n"
				+ "Course: Engineering Mechanics-I\r\n" + "\r\n"
				+ "1.	Describe position, forces, and moments in terms of vector notation in two and three dimensions.\r\n"
				+ "2.	Draw free body diagrams accurately and write appropriate equilibrium equations from the free body diagram, including support reactions.\r\n"
				+ "3.	Apply concepts of equilibrium to analyse systems that include frictional forces.\r\n"
				+ "4.	Calculate centroids and centres of mass for discrete particles.\r\n"
				+ "5.	Calculate moments of Inertia for standard sections and composite sections.\r\n" + "\r\n"
				+ "2.	B. Tech Electrical and Electronics Engineering and B. Tech Electronics and Communication Engineering\r\n"
				+ "\r\n" + "Course: Digital Design\r\n" + "\r\n"
				+ "CO1. Perform conversions from one number system to another.\r\n" + "\r\n" + "\r\n"
				+ "CO2. Simplify switching functions using Boolean minimization theorems, map method and tabulation method.\r\n"
				+ "\r\n" + "/r/n"
				+ "CO3. Analyze and design combinational logic circuits and the effect of Static Hazards on these circuits.+\r\n"
				+ "CO4. Synthesize symmetric functions using relay contact networks.\r\n" + "\r\n"
				+ "CO5. Design switching circuits using threshold elements.+\r\n" + "\r\n"
				+ " CO6. Analyze and Design Sequential logic Circuits\r\n" + "\r\n"
				+ "B.Tech Computer Science and Engineering, B.Tech Computer Science and Engineering (Emerging Areas of Specializations) and B. Tech Information Technology\r\n"
				+ "\r\n" + "\r\n" + "Course: Data Structures\r\n" + "\r\n"
				+ "CO1. Explain the basic concepts of Abstract Data Types, Linear and Non-Linear Data structures.+\r\n"
				+ "\r\n" + "CO2. Calculate the performance of the different algorithms in terms of time and space.\r\n"
				+ "CO3. Write programs in C for different data structures like stacks, queues, linked lists (singly and doubly).\r\n"
				+ " \r\n" + "CO4. Select appropriate data structure for a given problem.\r\n" + "\r\n"
				+ "CO5. Write C programs for various searching algorithms, sorting algorithms and nonlinear data structures such as trees and graphs.\r\n"
				+ "\r\n" + "3.	M. Tech Computer Science and Engineering\r\n" + "\r\n" + "Course: Machine Learning\r\n"
				+ "\r\n" + "CO1: Understand the concepts of computational intelligence like machine learning\r\n"
				+ "\r\n"
				+ "CO2: Ability to get the skill to apply machine learning techniques to address the real time problems in different areas\r\n"
				+ "\r\n" + "CO3: Understand the Neural Networks and its usage in machine learning application.\r\n"
				+ "\r\n"
				+ "CO4: Student should be able to understand the basic concepts such decision tree and neural networks. CO5: Ability to formulate machine learning techniques to respective problems.\r\n"
				+ "4.	MBA\r\n" + "\r\n" + "Course: Marketing Management\r\n" + "\r\n"
				+ "CO1: Understanding the concepts of Marketing Management. CO2: Analyze markets.\r\n" + "\r\n"
				+ "CO3: Design customer driven strategies.\r\n" + "\r\n"
				+ "CO4: Communicate the decisions towards business development with superior customer value. CO5: Know the concepts of pricing decisions and concepts of personal communication.\r\n"
				+ "");
		document.add(table27);

		PdfPTable table28 = new PdfPTable(2);

		table28.setWidthPercentage(100f);
		table28.setWidths(new int[] { 3, 3 });
		table28.setSpacingBefore(5);

		PdfPCell cell79criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table28.addCell(cell79criteria2);

		PdfPCell cell80criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table28.addCell(cell80criteria2);

		PdfPCell cell81criteria2 = new PdfPCell(new Paragraph("Upload COs for all courses (exemplars from Glossary)\r\n\r\n"));
		table28.addCell(cell81criteria2);

		PdfPCell cell82criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(12).getCriteria2FilePath() : ""));
		table28.addCell(cell82criteria2);

		PdfPCell cell83criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n"));
		table28.addCell(cell83criteria2);

		PdfPCell cell84criteria2 = new PdfPCell(new Paragraph(""));
		table28.addCell(cell84criteria2);

		document.add(table28);

		PdfPTable table29 = new PdfPTable(1);
		table29.setWidthPercentage(100f);

		PdfPCell cell013 = new PdfPCell(new Paragraph(
				"2.6.2 Attainment of programme outcomes and course outcomes are evaluated by the institution." + "\r\n"
						+ "" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria26Ql().get(0).getResponse262()
								: "")
						+ "\r\n" + "" + " \r\n"
						+ "Mother Teresa follows all the norms of the Statutory Regulatory Authorities in evaluating/measuring the"
						+ "attainment of both Program Outcomes (POs) and Course Outcomes (COs):\r\n" + "\r\n"
						+ "Procedure for measuring attainment of COs:\r\n" + "\r\n"
						+ "1.	CO attainments are calculated by considering marks obtained in each question of all the students who attend mid-term (CIE) and semester end examinations (SEE).\r\n"
						+ "2.	For Objective Paper of mid-term examinations, Assignments and Tutorials, overall CO attainment is calculated, which is made applicable to all COs.\r\n"
						+ "3.	For measuring the attainments of COs of a theory course, the targets fixed are:\r\n"
						+ "\r\n"
						+ "Mid-Term Subjective: 60% of maximum marks related to each CO Assignments and Tutorials (if any): 60% of maximum marks\r\n"
						+ "Mid-Term Objective: 60% of maximum marks\r\n"
						+ "Semester End Examination: 60% of maximum marks related to each CO\r\n" + "\r\n"
						+ "1.Attainment levels are calculated as follows:\r\n" + "\r\n"
						+ "Semester End Examination (SEE)\r\n" + "Levels for CO attainment measurement\r\n"
						+ "Level 1	> or = 40% and <50% of Students attain the target Marks\r\n"
						+ "Level 2	> or = 50% and <60% of Students attain the target Marks\r\n"
						+ "Level 3	> or = 60% of Students attain the target Marks\r\n" + "\r\n" + "\r\n" + "\r\n"
						+ "Mid-term Exams � Subjective, Objective, Assignments and Tutorials (CIE)\r\n"
						+ "Levels for CO attainment measurement\r\n" + "\r\n"
						+ "Level 1	> or = 60% and <70% of students attain the target\r\n"
						+ "Level 2	> or = 70% to <80% of students attain the target\r\n"
						+ "Level 3	> or = 80% of students attain the target\r\n" + "\r\n" + "\r\n" + "\r\n"
						+ "Indirect attainment � Course End Survey, CRC and TLP feedback\r\n" + "\r\n"
						+ "Levels for CO attainment measurement\r\n"
						+ "Level 1	> or = 60% and <70% of feedback score\r\n"
						+ "Level 2	> or = 70% and <80% of feedback score\r\n"
						+ "Level 3	> or = 80% of feedback score\r\n"
						+ "1.	In the case of �Either-or� question, maximum marks scored by student is considered for CO attainment.\r\n"
						+ "2.	Direct and indirect measurements for CO attainment:\r\n"
						+ "2.1	Weightage for Direct measurement: 60% for SEE , 40% for CIE\r\n"
						+ "2.2	Direct Attainment of CO = 0.2* Mid-term Subjective + 0.1* Mid-term Objective + 0.05*\r\n"
						+ "Assignment + 0.05* Tutorial + 0.6* SEE.\r\n" + " \r\n"
						+ "2.3	Indirect Attainment of COs through feedback = 0.4* TLP+ 0.4* CRC + 0.2* CES\r\n"
						+ "2.4	Overall CO Attainment = 0.75* Direct Attainment Level + 0.25* Indirect Attainment Level\r\n"
						+ "3.	For practical examinations (CIE and SEE), 60% of maximum marks are kept as target for attainment. Distribution of marks: SEE-70, CIE-30(Mid-Term-15, Day to day-15)\r\n"
						+ "3.1	CO attainment levels:\r\n" + "80% for Level3, 70% for Level2 and 60% for Level1"
						+ "3.2	Overall CO Attainment = 0.75* Direct Attainment Level + 0.25* Indirect Attainment"
						+ "3.3	Similar procedure is adopted for Projects, Seminars, Mini Projects, and Internships."

						+ "Procedure for measuring the attainments of POs and PSOs:"

						+ "75% of weightage is given for the Direct attainment of that PO/PSO obtained in terms of Levels 1,2 and 3, which is the weighted average of all the COs related to that PO/PSO and"
						+ "25% of weightage for Indirect measurement includes:"

						+ "Exit feedback on POs/ PSOs (10%) Alumni Survey on POs/ PSOs (10%) and"
						+ "Co-curricular and Extra-curricular activities (5%)."));

		table29.addCell(cell013);
		document.add(table29);

		PdfPTable table30 = new PdfPTable(2);

		table30.setWidthPercentage(100f);
		table30.setWidths(new int[] { 3, 3 });
		table30.setSpacingBefore(5);

		PdfPCell cell85criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table30.addCell(cell85criteria2);

		PdfPCell cell86criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table30.addCell(cell86criteria2);

		PdfPCell cell87criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
		table30.addCell(cell87criteria2);

		PdfPCell cell88criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(13).getCriteria2FilePath() : ""));
		table30.addCell(cell88criteria2);

		document.add(table30);

		PdfPTable table31criteria2 = new PdfPTable(1);
		table31criteria2.setWidthPercentage(100f);

		table31criteria2.addCell("2.6.3 Pass Percentage of students(Data for the latest completed academic year)\r\n"
				+ "\r\n" + "\"Response:"
				+ (criteria2Record != null ? criteria2Record.getCriteria26Qn().get(0).getResponse263()
						: ""));
	

		document.add(table31criteria2);

		PdfPTable table32 = new PdfPTable(2);

		table32.setWidthPercentage(100f);
		table32.setWidths(new int[] { 3, 3 });
		table32.setSpacingBefore(5);

		PdfPCell cell89criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table32.addCell(cell89criteria2);

		PdfPCell cell90criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table32.addCell(cell90criteria2);

		PdfPCell cell91criteria2 = new PdfPCell(new Paragraph(
				"Upload List of Programmes and number of students passed and appeared in the final year examination(Data Template)\r\n\r\n"));
		table32.addCell(cell91criteria2);

		PdfPCell cell92criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(14).getCriteria2FilePath() : ""));
		table32.addCell(cell92criteria2);

		PdfPCell cell93criteria2 = new PdfPCell(new Paragraph("Link for the annual report\r\n\r\n"));
		table32.addCell(cell93criteria2);

		PdfPCell cell94criteria2 = new PdfPCell(new Paragraph(""));
		table32.addCell(cell94criteria2);

		document.add(table32);

		Paragraph paragraph9criteria2 = new Paragraph("2.7	Student Satisfaction Survey\r\n\r\n", font2);

		paragraph9criteria2.setAlignment(Paragraph.ALIGN_LEFT);

		document.add(paragraph9criteria2);
		PdfPTable table33 = new PdfPTable(1);
		table33.setWidthPercentage(100f);

		table33.addCell("2.7.1 Online student satisfaction survey regarding teaching learning process\r\n" + "\r\n"
				+ "Response:"
				+ (criteria2Record != null ? criteria2Record.getCriteria27Ql().get(0).getResponse271()
						: ""));

		document.add(table33);

		PdfPTable table34 = new PdfPTable(2);

		table34.setWidthPercentage(100f);
		table34.setWidths(new int[] { 3, 3 });
		table34.setSpacingBefore(5);

		PdfPCell cell95criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		table34.addCell(cell95criteria2);

		PdfPCell cell96criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		table34.addCell(cell96criteria2);

		PdfPCell cell97criteria2 = new PdfPCell(new Paragraph("Upload database of all currently enrolled students"));
		table34.addCell(cell97criteria2);

		PdfPCell cell98criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(15).getCriteria2FilePath() : ""));
		table34.addCell(cell98criteria2);

		document.add(table34);

//////////////////////////////////////////////////////////
//////////////////////  criteria 2 end..........
		//////////////////////////////

	}

	public void Criteria3(Document document) {

		//////////////////////////////////
		/////////////////// Criteria 3 Starts.................................
		//////////////////////////////

		
		
		try
		{
		Font font0 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font0.setSize(16);

		Font font1criteria3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font1criteria3.setSize(14);

		Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font2.setSize(12);

		Paragraph paragraph1criteria3 = new Paragraph("Criterion 3 - Research, Innovations and Extension\r\n" + "\r\n",
				font0);
		paragraph1criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph1criteria3);
		Paragraph paragraph2criteria3 = new Paragraph("3.1	Promotion of Research and Facilities\r\n", font1criteria3);
		paragraph1criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph2criteria3);
		// create table1
		PdfPTable table1criteria3 = new PdfPTable(2);
		PdfPTable table13criteria31 = new PdfPTable(1);

		table1criteria3.setWidthPercentage(100f);
		table13criteria31.setWidthPercentage(100f);

		PdfPCell cell1criteria3 = new PdfPCell(new Paragraph("File Description", font2));
		PdfPCell cell2criteria3 = new PdfPCell(new Paragraph("Document", font2));
		PdfPCell cell3criteria3 = new PdfPCell(new Paragraph(
				"Minutes of the Governing Council/ Syndicate/Board of Management related to research promotion policy adoption"));
		PdfPCell cell4criteria3 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
		PdfPCell cell5criteria3 = new PdfPCell(new Paragraph("Any additional information"));
		PdfPCell cell6criteria3 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
		PdfPCell cell7criteria3 = new PdfPCell(
				new Paragraph("URL of Policy document on promotion of research uploaded on website"));
		PdfPCell cell8criteria3 = new PdfPCell(new Paragraph(""));
		table1criteria3.addCell(cell1criteria3);
		table1criteria3.addCell(cell2criteria3);
		table1criteria3.addCell(cell3criteria3);
		table1criteria3.addCell(cell4criteria3);
		table1criteria3.addCell(cell5criteria3);
		table1criteria3.addCell(cell6criteria3);
		table1criteria3.addCell(cell7criteria3);
		table1criteria3.addCell(cell8criteria3);

		PdfPCell cell311criteria3 = new PdfPCell(new Paragraph(
				"3.1.1	The institution's Research facilities are frequently updated and there is a well defined policy for promotion of research which is uploaded on the institutional website and implemented.\r\n"
						+ "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria31Ql().get(0).getResponse311()
								: ""),
				font2));
		table13criteria31.addCell(cell311criteria3);
		table13criteria31.addCell(table1criteria3);

		table1criteria3.setSpacingBefore(20f);
		table1criteria3.setSpacingAfter(20f);
		document.add(table13criteria31);

		// create table 2////
		PdfPTable table2criteria3 = new PdfPTable(2);
		PdfPTable table23criteria31 = new PdfPTable(1);
		table2criteria3.setWidthPercentage(100f);
		table23criteria31.setWidthPercentage(100f);
		PdfPCell cell21criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell22criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell23criteria3 = new PdfPCell(new Paragraph("Minutes of the relevant bodies of the Institution\r\n\r\n\r\n"));
		PdfPCell cell24criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : ""));
		PdfPCell cell25criteria3 = new PdfPCell(
				new Paragraph("List of teachers receiving grant and details of grant received\r\n\r\n\r\n"));
		PdfPCell cell26criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : ""));
		PdfPCell cell27criteria3 = new PdfPCell(new Paragraph(
				"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n\r\n"));
		PdfPCell cell28criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : ""));
		table2criteria3.addCell(cell21criteria3);
		table2criteria3.addCell(cell22criteria3);
		table2criteria3.addCell(cell23criteria3);
		table2criteria3.addCell(cell24criteria3);
		table2criteria3.addCell(cell25criteria3);
		table2criteria3.addCell(cell26criteria3);
		table2criteria3.addCell(cell27criteria3);
		table2criteria3.addCell(cell28criteria3);
		PdfPCell cell312criteria3 = new PdfPCell(new Paragraph(
				"3.1.2 The institution provides seed money to its teachers for research (average per year, INR in Lakhs)\r\n\r\n"
						+ "\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria31Qn().get(0).getResponse312()
								: ""),
				font2));
		PdfPCell cell3121criteria3 = new PdfPCell(new Paragraph(
				"3.1.2.1 The amount of seed money provided by institution to its faculty year-wise during the last five years (INR in lakhs).",
				font2));

		table23criteria31.addCell(cell312criteria3);
		table23criteria31.addCell(cell3121criteria3);
		table23criteria31.setSpacingAfter(10f);
		table23criteria31.setSpacingAfter(10f);

		document.add(table23criteria31);
		// create table 3121///
		System.out.println("criteria3FieldInfoQnList.get(0) == >" + criteria3Record);

		if (criteria3Record != null) {
			Table table3121criteria3 = new Table(criteria3Record.getYearTable3121().size());

			table3121criteria3.setPadding(10);
			table3121criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3121().size(); i++) {
				table3121criteria3.addCell(criteria3Record.getYearTable3121().get(i).getInput3121y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3121().size(); i++) {
				table3121criteria3.addCell(criteria3Record.getYearTable3121().get(i).getInput3121v());

			}

			document.add(table3121criteria3);
		}

		// create table 3 //////
		PdfPTable table3criteria3 = new PdfPTable(2);
		PdfPTable table33criteria31 = new PdfPTable(1);

		table3criteria3.setWidthPercentage(100f);
		table33criteria31.setWidthPercentage(100f);

		PdfPCell cell31criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell32criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell33criteria3 = new PdfPCell(
				new Paragraph("List of teachers and their international fellowship details\r\n\r\n\r\n"));
		PdfPCell cell34criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : ""));
		PdfPCell cell35criteria3 = new PdfPCell(new Paragraph("e-copies of the award letters of the teachers"));
		PdfPCell cell36criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : ""));
		table3criteria3.addCell(cell31criteria3);
		table3criteria3.addCell(cell32criteria3);
		table3criteria3.addCell(cell33criteria3);
		table3criteria3.addCell(cell34criteria3);
		table3criteria3.addCell(cell35criteria3);
		table3criteria3.addCell(cell36criteria3);
		PdfPCell cell313criteria3 = new PdfPCell(new Paragraph(
				"3.1.3 Percentage of teachers awarded national / international fellowship for advanced studies/research during the last five years\r\n"
						+ "\r\n" + "Response"
						+ (criteria3Record != null
								? criteria3Record.getCriteria31Qn().get(0).getResponse313()
								: ""),
				font2));
		PdfPCell cell3131criteria3 = new PdfPCell(new Paragraph(
				"3.1.3.1 The number of teachers awarded national / international fellowship for advanced studies / research year wise during last five years"
						+ "\r\n\r\n",
				font2));
		table33criteria31.addCell(cell313criteria3);
		table33criteria31.addCell(cell3131criteria3);
		table33criteria31.addCell(table3criteria3);
		// document.add(cell313criteria3);
		// document.add(cell3131criteria3);
		table33criteria31.setSpacingBefore(20f);
		table33criteria31.setSpacingAfter(20f);
		document.add(table33criteria31);
		// create table 3131 ///

		if (criteria3Record != null) {
			Table table3131criteria3 = new Table(criteria3Record.getYearTable3131().size(), 2);

			table3131criteria3.setPadding(10);
			table3131criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3131().size(); i++) {
				table3131criteria3.addCell(criteria3Record.getYearTable3131().get(i).getInput3131y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3131().size(); i++) {
				table3131criteria3.addCell(criteria3Record.getYearTable3131().get(i).getInput3131v());

			}

			document.add(table3131criteria3);
		}

		Paragraph paragraph3criteria3 = new Paragraph("3.2	Resource Mobilization for Research\r\n\r\n", font1criteria3);
		paragraph3criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph3criteria3);

		/// create table 4//
		PdfPTable table4criteria3 = new PdfPTable(2);
		PdfPTable table43criteria31 = new PdfPTable(1);

		table4criteria3.setWidthPercentage(100f);
		PdfPCell cell41criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell42criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell43criteria3 = new PdfPCell(new Paragraph("List of project and grant details\r\n\r\n\r\n"));
		PdfPCell cell44criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : ""));
		PdfPCell cell45criteria3 = new PdfPCell(new Paragraph(
				"e-copies of the grant award letters for research projects sponsored by government and non- government\r\n\r\n"));
		PdfPCell cell46criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : ""));
		PdfPCell cell47criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
		PdfPCell cell48criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(9).getCriteria3FilePath() : ""));
		PdfPCell cell321criteria3 = new PdfPCell(new Paragraph(
				"3.2.1 Grants received from Government and non-governmental agencies for research projects, endowments, Chairs in the institution during the last five years (INR in Lakhs)\r\n"
						+ "\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria32Ql().get(0).getResponse321()
								: ""),
				font2));
		PdfPCell cell3211criteria3 = new PdfPCell(new Paragraph(
				"3.2.1.1 Total Grants from Government and non-governmental agencies for research projects , endowments, Chairs in the institution during the last five years (INR in Lakhs)"
						+ "\r\n\r\n",
				font2));
		table43criteria31.addCell(cell321criteria3);
		table43criteria31.addCell(cell3211criteria3);

		table4criteria3.addCell(cell41criteria3);
		table4criteria3.addCell(cell42criteria3);
		table4criteria3.addCell(cell43criteria3);
		table4criteria3.addCell(cell44criteria3);
		table4criteria3.addCell(cell45criteria3);
		table4criteria3.addCell(cell46criteria3);
		table4criteria3.addCell(cell47criteria3);
		table4criteria3.addCell(cell48criteria3);

		table43criteria31.addCell(table4criteria3);

		table43criteria31.setSpacingBefore(20f);
		table43criteria31.setSpacingAfter(20f);

		document.add(table43criteria31);
		// create table 3211/////

		if (criteria3Record != null) {
			Table table3211criteria3 = new Table(criteria3Record.getYearTable3121().size(), 2);

			table3211criteria3.setPadding(10);
			table3211criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3211().size(); i++) {
				table3211criteria3.addCell(criteria3Record.getYearTable3211().get(i).getInput3211y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3211().size(); i++) {
				table3211criteria3.addCell(criteria3Record.getYearTable3211().get(i).getInput3211v());

			}

			document.add(table3211criteria3);
		}

		// create table 5 //////
		PdfPTable table5criteria3 = new PdfPTable(2);
		PdfPTable table53criteria31 = new PdfPTable(1);

		table5criteria3.setWidthPercentage(100f);
		PdfPCell cell51criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell52criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\\r\n", font2));
		PdfPCell cell53criteria3 = new PdfPCell(new Paragraph("Names of teachers having research projects"));
		PdfPCell cell54criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(10).getCriteria3FilePath() : ""));
		PdfPCell cell55criteria3 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell56criteria3 = new PdfPCell(new Paragraph(""));
		table5criteria3.addCell(cell51criteria3);
		table5criteria3.addCell(cell52criteria3);
		table5criteria3.addCell(cell53criteria3);
		table5criteria3.addCell(cell54criteria3);
		table5criteria3.addCell(cell55criteria3);
		table5criteria3.addCell(cell56criteria3);
		PdfPCell cell322criteria3 = new PdfPCell(
				new Paragraph("3.2.2 Percentage of teachers having research projects during the last five years\r\n"
						+ "\r\n\r\n" + "Response: \r\n\r\n"
						+ (criteria3Record != null
								? criteria3Record.getCriteria32Qn().get(0).getResponse322()
								: ""),
						font1criteria3));
		PdfPCell cell3221criteria3 = new PdfPCell(new Paragraph(
				"3.2.2.1 Number of teachers having research projects during the last five years" + "\r\n\r\n", font1criteria3));
		table53criteria31.addCell(cell322criteria3);
		table53criteria31.addCell(cell3221criteria3);

		table5criteria3.addCell(table53criteria31);
		// document.add(cell322criteria3);
		// document.add(cell3221criteria3);
		table53criteria31.setSpacingBefore(20f);
		table53criteria31.setSpacingAfter(20f);

		document.add(table53criteria31);
		// create table 3221 //////

		if (criteria3Record != null) {
			Table table3221criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);

			table3221criteria3.setPadding(10);
			table3221criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
				table3221criteria3.addCell(criteria3Record.getYearTable3221().get(i).getInput3221y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
				table3221criteria3.addCell(criteria3Record.getYearTable3221().get(i).getInput3221v());

			}

			document.add(table3221criteria3);
		}

		// create table 6////
		PdfPTable table6criteria3 = new PdfPTable(2);
		PdfPTable table63criteria31 = new PdfPTable(1);

		table6criteria3.setWidthPercentage(100f);
		PdfPCell cell61criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell62criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell63criteria3 = new PdfPCell(
				new Paragraph("Upload copies of the letter of the university recognizing faculty as research guides\r\n\r\n\r\n"));
		PdfPCell cell64criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(11).getCriteria3FilePath() : ""));
		PdfPCell cell65criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
		PdfPCell cell66criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(12).getCriteria3FilePath() : ""));
		PdfPCell cell67criteria3 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell68criteria3 = new PdfPCell(new Paragraph(""));
		table6criteria3.addCell(cell61criteria3);
		table6criteria3.addCell(cell62criteria3);
		table6criteria3.addCell(cell63criteria3);
		table6criteria3.addCell(cell64criteria3);
		table6criteria3.addCell(cell65criteria3);
		table6criteria3.addCell(cell66criteria3);
		table6criteria3.addCell(cell67criteria3);
		table6criteria3.addCell(cell68criteria3);
		PdfPCell cell323criteria3 = new PdfPCell(
				new Paragraph("3.2.3 Percentage of teachers recognised as research guides\r\n" + "\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria32Qn().get(0).getResponse323()
								: ""),
						font2));
		PdfPCell cell3231criteria3 = new PdfPCell(
				new Paragraph("3.2.3.1 Number of teachers recognized as research guides\r\n" + "\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria32Qn().get(0).getInput3231t1()
								: ""),
						font2));
		table6criteria3.addCell(cell323criteria3);
		table6criteria3.addCell(cell3231criteria3);
		table63criteria31.addCell(table6criteria3);

		// document.add(cell323criteria3);
		// document.add(cell3231criteria3);
		table63criteria31.setSpacingBefore(10f);
		table63criteria31.setSpacingAfter(10f);

		document.add(table63criteria31);
		/// create table 7 ///
		PdfPTable table7criteria3 = new PdfPTable(2);
		PdfPTable table73criteria31 = new PdfPTable(1);

		table7criteria3.setWidthPercentage(100f);
		table73criteria31.setWidthPercentage(100f);

		PdfPCell cell71criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell72criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
		PdfPCell cell73criteria3 = new PdfPCell(new Paragraph("Supporting document from Funding Agency\r\n\r\n\r\n"));
		PdfPCell cell74criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(13).getCriteria3FilePath() : ""));
		PdfPCell cell75criteria3 = new PdfPCell(new Paragraph("List of research projects and funding details\r\n\r\n\r\n"));
		PdfPCell cell76criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(14).getCriteria3FilePath() : ""));
		PdfPCell cell77criteria3 = new PdfPCell(new Paragraph("Paste link to funding agency website\r\n\r\n\r\n"));
		PdfPCell cell78criteria3 = new PdfPCell(new Paragraph(""));
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
						+ "\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria32Qn().get(0).getResponse324()
								: ""),
				font2));
		PdfPCell cell3241criteria3 = new PdfPCell(new Paragraph(
				"3.2.4.1 Number of departments having Research projects funded by government and non- government agencies during the last five years\r\n"
						+ "\r\n\r\n",
				font2));

		PdfPCell cell3242criteria3 = new PdfPCell(new Paragraph(
				"3.2.4.1 Number of departments having Research projects funded by government and non- government agencies during the last five years\r\n"
						+ "\r\n\r\n",
				font2));

		table73criteria31.addCell(cell324criteria3);
		table73criteria31.addCell(cell3241criteria3);
		table73criteria31.addCell(cell3242criteria3);

		table73criteria31.addCell(table7criteria3);
		// document.add(cell324criteria3);
		// document.add(cell3241criteria3);
		// document.add(cell3242criteria3);
		table73criteria31.setSpacingBefore(20f);
		table73criteria31.setSpacingAfter(20f);

		document.add(table73criteria31);
		/// create table 3241 ///

		if (criteria3Record != null) {
			Table table3241criteria3 = new Table(criteria3Record.getYearTable3241().size(), 2);

			table3241criteria3.setPadding(10);
			table3241criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3241().size(); i++) {
				table3241criteria3.addCell(criteria3Record.getYearTable3241().get(i).getInput3241y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3241().size(); i++) {
				table3241criteria3.addCell(criteria3Record.getYearTable3241().get(i).getInput3241v());

			}

			document.add(table3241criteria3);
		}

		
		////// 3.3//
		Paragraph paragraph4criteria3 = new Paragraph("3.3	Innovation Ecosystem\r\n\r\n\r\n", font1criteria3);
		paragraph4criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph4criteria3);
		// create table 8 ///
		PdfPTable table8criteria3 = new PdfPTable(2);
		PdfPTable table81criteria31 = new PdfPTable(1);

		table8criteria3.setWidthPercentage(100f);
		table81criteria31.setWidthPercentage(100f);
		PdfPCell cell81criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font2));
		PdfPCell cell82criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
		PdfPCell cell83criteria3 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n"));
		PdfPCell cell84criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(15).getCriteria3FilePath() : ""));
		PdfPCell cell85criteria3 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
		PdfPCell cell86criteria3 = new PdfPCell(new Paragraph(""));
		table8criteria3.addCell(cell81criteria3);
		table8criteria3.addCell(cell82criteria3);
		table8criteria3.addCell(cell83criteria3);
		table8criteria3.addCell(cell84criteria3);
		table8criteria3.addCell(cell85criteria3);
		table8criteria3.addCell(cell86criteria3);
//		PdfPCell cell331criteria3 = new PdfPCell(new Paragraph(
//				"3.3.1	Institution has created an eco system for innovations, creation and transfer of knowledge supported by dedicated centers for research, entrepreneurship, community orientation, Incubation etc.\r\n"
//						+ "\r\n\r\n" + "Response:"
//						+ (criteria3Record != null
//								? criteria3Record.getCriteria33Ql().get(0).getResponse331()
//								: ""),
//				font2));
//		table81criteria31.addCell(cell331criteria3);
		table81criteria31.addCell(table8criteria3);

		// document.add(cell331criteria3);

		table81criteria31.setSpacingBefore(20f);
		table81criteria31.setSpacingAfter(20f);

		document.add(table81criteria31);
		/// create table 9 ////
		PdfPTable table9criteria3 = new PdfPTable(2);
		PdfPTable table91criteria31 = new PdfPTable(1);

		table9criteria3.setWidthPercentage(100f);
		table91criteria31.setWidthPercentage(100f);
		PdfPCell cell91criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell92criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell93criteria3 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
		PdfPCell cell94criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(16).getCriteria3FilePath() : ""));
		PdfPCell cell95criteria3 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
		PdfPCell cell96criteria3 = new PdfPCell(new Paragraph(""));
		table9criteria3.addCell(cell91criteria3);
		table9criteria3.addCell(cell92criteria3);
		table9criteria3.addCell(cell93criteria3);
		table9criteria3.addCell(cell94criteria3);
		table9criteria3.addCell(cell95criteria3);
		table9criteria3.addCell(cell96criteria3);
		PdfPCell cell332criteria3 = new PdfPCell(new Paragraph(
				"3.3.2 Number of workshops/seminars conducted on Research methodology, Intellectual Property Rights (IPR),entrepreneurship, skill development during the last five years.\r\n"
						+ "\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria33Qn().get(0).getResponse332()
								: ""),
				font2));
		PdfPCell cell3321criteria3 = new PdfPCell(new Paragraph(
				"3.3.2.1 Total number of workshops/seminars conducted on Research methodology, Intellectual Property Rights (IPR),entrepreneurship, skill development year-wise during the last five years.\r\n"
						+ "\r\n\r\n",
				font2));
		table91criteria31.addCell(cell332criteria3);
		table91criteria31.addCell(cell3321criteria3);
		table91criteria31.addCell(table9criteria3);

		// document.add(cell332criteria3);
		// document.add(cell3321criteria3);
		table91criteria31.setSpacingBefore(20f);
		table91criteria31.setSpacingAfter(20f);
		document.add(table91criteria31);
		// create a table 3321 //

		if (criteria3Record != null) {
			Table table3321criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);

			table3321criteria3.setPadding(10);
			table3321criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3321().size(); i++) {
				table3321criteria3.addCell(criteria3Record.getYearTable3321().get(i).getInput3321y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3321().size(); i++) {
				table3321criteria3.addCell(criteria3Record.getYearTable3321().get(i).getInput3321v());

			}

			document.add(table3321criteria3);
		}

		// 3.4 ///

		Paragraph paragraph5criteria3 = new Paragraph("3.4	Research Publications and Awards\r\n\r\n", font2);
		paragraph5criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph5criteria3);
		// create table 10 ///
		PdfPTable table10criteria3 = new PdfPTable(2);
		PdfPTable table101criteria31 = new PdfPTable(1);
		table10criteria3.setWidthPercentage(100f);
		table101criteria31.setWidthPercentage(100f);
		PdfPCell cell101criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell102criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
		PdfPCell cell103criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell104criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(17).getCriteria3FilePath() : ""));
		PdfPCell cell105criteria3 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n"));
		PdfPCell cell106criteria3 = new PdfPCell(new Paragraph(""));
		table10criteria3.addCell(cell101criteria3);
		table10criteria3.addCell(cell102criteria3);
		table10criteria3.addCell(cell103criteria3);
		table10criteria3.addCell(cell104criteria3);
		table10criteria3.addCell(cell105criteria3);
		table10criteria3.addCell(cell106criteria3);
		PdfPCell cell341criteria3 = new PdfPCell(new Paragraph(
				" 3.4.1 The Institution ensures implementation of its stated Code of Ethics for research through the following: 1. Inclusion of research ethics in the research methodology course work 2. Presence ofEthics committee 3. Plagiarism check through software 4. Research Advisory Committee\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Ql().get(0).getResponse341()
								: ""),
				font2));
		table101criteria31.addCell(cell341criteria3);
		table101criteria31.addCell(table10criteria3);
		// document.add(cell341criteria3);
		table10criteria3.setSpacingBefore(20f);
		table10criteria3.setSpacingAfter(20f);
		document.add(table101criteria31);

		/// create table 11 ////
		PdfPTable table11criteria3 = new PdfPTable(2);
		PdfPTable table111criteria31 = new PdfPTable(1);

		table11criteria3.setWidthPercentage(100f);
		table111criteria31.setWidthPercentage(100f);

		PdfPCell cell111criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell112criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell113criteria3 = new PdfPCell(new Paragraph(
				"List of PhD scholars and their details like name of the guide , title of thesis, year of award etc\r\n\r\n\r\n"));
		PdfPCell cell114criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(18).getCriteria3FilePath() : ""));
		PdfPCell cell115criteria3 = new PdfPCell(new Paragraph("URL to the research page on HEI web site\r\n\r\n\r\n"));
		PdfPCell cell116criteria3 = new PdfPCell(new Paragraph(""));
		table11criteria3.addCell(cell111criteria3);
		table11criteria3.addCell(cell112criteria3);
		table11criteria3.addCell(cell113criteria3);
		table11criteria3.addCell(cell114criteria3);
		table11criteria3.addCell(cell115criteria3);
		table11criteria3.addCell(cell116criteria3);
		PdfPCell cell342criteria3 = new PdfPCell(new Paragraph(
				"3.4.2 Number of Ph.D’s registered per teacher (as per the data given w.r.t recognized Ph.D guides/ supervisors provided at 3.2.3 metric) during the last five years\r\n"
						+ "\r\n\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getResponse342()
								: ""),
				font2));

		table111criteria31.addCell(cell342criteria3);
		// document.add(cell342criteria3);
		PdfPCell cell3421criteria3 = new PdfPCell(
				new Paragraph("3.4.2.1 How many Ph.Ds are registered within last 5 years" + "\r\n\r\n\r\n", font2));
		PdfPCell cell3422criteria3 = new PdfPCell(new Paragraph(
				"3.4.2.2 Number of teachers recognized as guides during the last five years\r\n" + "\r\n\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getInput3422t1()
								: ""),
				font2));
		table111criteria31.addCell(cell3421criteria3);
		table111criteria31.addCell(cell3422criteria3);
		table111criteria31.addCell(table11criteria3);

		// document.add(cell3421criteria3);
		// document.add(cell3422criteria3);
		table111criteria31.setSpacingAfter(20f);
		table111criteria31.setSpacingAfter(20f);

		document.add(table111criteria31);
		/// create table 12 /////
		PdfPTable table12criteria3 = new PdfPTable(2);
		PdfPTable table123criteria31 = new PdfPTable(1);

		table12criteria3.setWidthPercentage(100f);
		PdfPCell cell121criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell122criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell123criteria3 = new PdfPCell(new Paragraph(
				"List of PhD scholars and their details like name of the guide , title of thesis, year of award etc\r\n\r\n\\r\n",
				font2));
		PdfPCell cell124criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(19).getCriteria3FilePath() : ""));
		PdfPCell cell125criteria3 = new PdfPCell(new Paragraph("URL to the research page on HEI web site\r\n\r\n\r\n", font2));
		PdfPCell cell126criteria3 = new PdfPCell(new Paragraph(""));
		table12criteria3.addCell(cell121criteria3);
		table12criteria3.addCell(cell122criteria3);
		table12criteria3.addCell(cell123criteria3);
		table12criteria3.addCell(cell124criteria3);
		table12criteria3.addCell(cell125criteria3);
		table12criteria3.addCell(cell126criteria3);
		PdfPCell cell343criteria3 = new PdfPCell(new Paragraph(
				"3.4.3 Number of research papers per teachers in the Journals notified on UGC website during the last five years\r\n"
						+ "\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getResponse343()
								: ""),
				font2));
		PdfPCell cell3431criteria3 = new PdfPCell(new Paragraph(
				"3.4.3.1 Number of research papers in the Journals notified on UGC website during the last five years\r\n\r\n"
						+ "",
				font2));
		table123criteria31.addCell(cell343criteria3);
		table123criteria31.addCell(cell3431criteria3);
		table123criteria31.addCell(table12criteria3);

		// document.add(cell343criteria3);
		// document.add(cell3431criteria3);
		table123criteria31.setSpacingBefore(20f);
		table123criteria31.setSpacingAfter(20f);

		document.add(table123criteria31);
		/// create table 3431 ////

		if (criteria3Record != null) {
			Table table3431criteria3 = new Table(criteria3Record.getYearTable3431().size(), 2);

			table3431criteria3.setPadding(10);
			table3431criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3431().size(); i++) {
				table3431criteria3.addCell(criteria3Record.getYearTable3431().get(i).getInput3431y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3431().size(); i++) {
				table3431criteria3.addCell(criteria3Record.getYearTable3431().get(i).getInput3431v());

			}

			document.add(table3431criteria3);
		}
		/// create table 13 //
		PdfPTable table13criteria3 = new PdfPTable(2);
		PdfPTable table131criteria31 = new PdfPTable(1);

		table13criteria3.setWidthPercentage(100f);
		table131criteria31.setWidthPercentage(100f);

		PdfPCell cell131criteria3 = new PdfPCell(new Paragraph("\r\n\r\n\r\n", font2));
		PdfPCell cell132criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell133criteria3 = new PdfPCell(
				new Paragraph("List books and chapters in edited volumes / books published\r\n\r\n\r\n"));
		PdfPCell cell134criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(20).getCriteria3FilePath() : ""));
		PdfPCell cell135criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell136criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(21).getCriteria3FilePath() : ""));
		table13criteria3.addCell(cell131criteria3);
		table13criteria3.addCell(cell132criteria3);
		table13criteria3.addCell(cell133criteria3);
		table13criteria3.addCell(cell134criteria3);
		table13criteria3.addCell(cell135criteria3);
		table13criteria3.addCell(cell136criteria3);
		PdfPCell cell344criteria3 = new PdfPCell(new Paragraph(
				"3.4.4 Number of books and chapters in edited volumes / books published per teacher during the last five years\r\n"
						+ " \r\n" + "\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getResponse344()
								: ""),
				font2));
		PdfPCell cell3441criteria3 = new PdfPCell(new Paragraph(
				"3.4.4.1 Total number of books and chapters in edited volumes/books published and papers in national/ international conference proceedings year-wise during last five years"
						+ "\r\n\r\n\r\n",
				font2));
		table131criteria31.addCell(cell344criteria3);
		table131criteria31.addCell(cell3441criteria3);
		table131criteria31.addCell(table13criteria3);

		// document.add(cell344criteria3);
		// document.add(cell3441criteria3);
		table131criteria31.setSpacingBefore(20f);
		table131criteria31.setSpacingAfter(20f);

		document.add(table131criteria31);
		// create table 3441 //

		if (criteria3Record != null) {
			Table table3441criteria3 = new Table(criteria3Record.getYearTable3441().size(), 2);

			table3441criteria3.setPadding(10);
			table3441criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
				table3441criteria3.addCell(criteria3Record.getYearTable3441().get(i).getInput3441y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
				table3441criteria3.addCell(criteria3Record.getYearTable3441().get(i).getInput3441v());

			}

			document.add(table3441criteria3);
		}

		// create table 14 //
		PdfPTable table14criteria3 = new PdfPTable(2);
		PdfPTable table141criteria31 = new PdfPTable(1);

		table14criteria3.setWidthPercentage(100f);
		table141criteria31.setWidthPercentage(100f);

		PdfPCell cell141criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell142criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell143criteria3 = new PdfPCell(
				new Paragraph("Bibliometrics of the publications during the last five years\r\n\r\n\r\n"));
		PdfPCell cell144criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(22).getCriteria3FilePath() : ""));
		table14criteria3.addCell(cell141criteria3);
		table14criteria3.addCell(cell142criteria3);
		table14criteria3.addCell(cell143criteria3);
		table14criteria3.addCell(cell144criteria3);

		PdfPCell cell345criteria3 = new PdfPCell(new Paragraph(
				"3.4.5 Bibliometrics of the publications during the last five years based on average citation index in Scopus/ Web of Science or PubMed\r\n"
						+ "\r\n\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getResponse345()
								: ""),
				font2));
		table141criteria31.addCell(cell345criteria3);
		table141criteria31.addCell(table14criteria3);
		table141criteria31.setSpacingBefore(20f);
		table141criteria31.setSpacingAfter(20f);
		document.add(table141criteria31);
		// create table 15 //
		PdfPTable table15criteria3 = new PdfPTable(2);
		PdfPTable table153criteria31 = new PdfPTable(1);

		table15criteria3.setWidthPercentage(100f);
		table153criteria31.setWidthPercentage(100f);

		PdfPCell cell151criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell152criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell153criteria3 = new PdfPCell(new Paragraph(
				"Bibiliometrics of publications based on Scopus/ Web of Science - h-index of the Institution\r\n\r\n\r\n"));
		PdfPCell cell154criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(23).getCriteria3FilePath() : ""));
		table15criteria3.addCell(cell151criteria3);
		table15criteria3.addCell(cell152criteria3);
		table15criteria3.addCell(cell153criteria3);
		table15criteria3.addCell(cell154criteria3);
		PdfPCell cell346criteria3 = new PdfPCell(new Paragraph(
				"3.4.6 Bibliometrics of the publications during the last five years based on Scopus/ Web of Science - h- index of the Institution\r\n"
						+ "\r\n\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getResponse346()
								: ""),
				font2));
		table153criteria31.addCell(cell346criteria3);
		table153criteria31.addCell(table15criteria3);

		// document.add(cell346criteria3);
		table153criteria31.setSpacingBefore(20f);
		table153criteria31.setSpacingAfter(20f);
		document.add(table153criteria31);
		// 3.5 //
		Paragraph paragraph6criteria3 = new Paragraph("3.5	Consultancy\r\n\r\n\r\n", font2);
		paragraph6criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph6criteria3);
		// create table 16 //
		PdfPTable table16criteria3 = new PdfPTable(2);
		PdfPTable table161criteria31 = new PdfPTable(1);

		table16criteria3.setWidthPercentage(100f);
		table16criteria3.setWidthPercentage(100f);

		PdfPCell cell161criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell162criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
		PdfPCell cell163criteria3 = new PdfPCell(new Paragraph("List of consultants and revenue generated by them\r\n\r\n\r\n"));
		PdfPCell cell164criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(24).getCriteria3FilePath() : ""));
		PdfPCell cell165criteria3 = new PdfPCell(new Paragraph(
				"Audited statements of accounts indicating the revenue generated through consultancy and corporate training\r\n\r\n\r\n"));
		PdfPCell cell166criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(25).getCriteria3FilePath() : ""));
		PdfPCell cell167criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell168criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(26).getCriteria3FilePath() : ""));
		table16criteria3.addCell(cell161criteria3);
		table16criteria3.addCell(cell162criteria3);
		table16criteria3.addCell(cell163criteria3);
		table16criteria3.addCell(cell164criteria3);
		table16criteria3.addCell(cell165criteria3);
		table16criteria3.addCell(cell166criteria3);
		table16criteria3.addCell(cell167criteria3);
		table16criteria3.addCell(cell168criteria3);
		PdfPCell cell351criteria3 = new PdfPCell(new Paragraph(
				"3.5.1 Revenue generated from consultancy and corporate training during the last five years (INR in Lakhs).\r\n"
						+ "\r\n\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria35Qn().get(0).getResponse351()
								: ""),
				font2));
		PdfPCell cell3511criteria3 = new PdfPCell(new Paragraph(
				"3.5.1.1 Total amount generated from consultancy and corporate training year-wise during the last five years (INR in lakhs).\r\n"
						+ "\r\n\r\n",
				font2));

		table161criteria31.addCell(cell351criteria3);
		table161criteria31.addCell(cell3511criteria3);
		table161criteria31.addCell(table16criteria3);

		// document.add(cell351criteria3);
		// document.add(cell3511criteria3);
		table16criteria3.setSpacingBefore(20f);
		table16criteria3.setSpacingAfter(20f);
		document.add(table161criteria31);
		// create table 3511 ///

		if (criteria3Record != null) {
			Table table3511criteria3 = new Table(criteria3Record.getYearTable3511().size(), 2);

			table3511criteria3.setPadding(10);
			table3511criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3511().size(); i++) {
				table3511criteria3.addCell(criteria3Record.getYearTable3511().get(i).getInput3511y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3511().size(); i++) {
				table3511criteria3.addCell(criteria3Record.getYearTable3511().get(i).getInput3511v());

			}

			document.add(table3511criteria3);
		}

		// create table 17 ///

		PdfPTable table17criteria3 = new PdfPTable(2);
		PdfPTable table173criteria31 = new PdfPTable(1);

		table17criteria3.setWidthPercentage(100f);
		table173criteria31.setWidthPercentage(100f);

		PdfPCell cell171criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell172criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell173criteria3 = new PdfPCell(
				new Paragraph("List of training programmes, teachers and staff trained for undertaking consultancy\r\n\r\n\r\n"));
		PdfPCell cell174criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(27).getCriteria3FilePath() : ""));
		PdfPCell cell175criteria3 = new PdfPCell(
				new Paragraph("List of facilities and staff available for undertaking consultancy\rn\r\n\r\n"));
		PdfPCell cell176criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(28).getCriteria3FilePath() : ""));
		PdfPCell cell177criteria3 = new PdfPCell(new Paragraph(
				"Audited statements of accounts indicating the expenditure incurred on developing facilities and training teachers and staff for undertaking consultancy"));
		PdfPCell cell178criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(29).getCriteria3FilePath() : ""));
		PdfPCell cell179criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\r\n"));
		PdfPCell cell180criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(30).getCriteria3FilePath() : ""));
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
				"3.5.2 Total amount spent on developing facilities, training teachers and staff for undertaking consultancy during the last five years (INR in Lakhs).\r\n"
						+ "\r\n\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria35Ql().get(0).getResponse352()
								: ""),
				font2));
		PdfPCell cell3521criteria3 = new PdfPCell(new Paragraph(
				"3.5.2.1 Total amount spent on developing facilities, training teachers and staff for undertaking consultancy during the last five years (INR in Lakhs)\r\n"
						+ "\r\n\r\n",
				font2));
		table173criteria31.addCell(cell352criteria3);
		table173criteria31.addCell(cell3521criteria3);
		table173criteria31.addCell(table17criteria3);
		// document.add(cell352criteria3);
		// document.add(cell3521criteria3);
		table173criteria31.setSpacingBefore(20f);
		table173criteria31.setSpacingAfter(20f);

		document.add(table173criteria31);
		// create table 3521//

		if (criteria3Record != null) {
			Table table3521criteria3 = new Table(criteria3Record.getYearTable3521().size(), 2);

			table3521criteria3.setPadding(10);
			table3521criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3521().size(); i++) {
				table3521criteria3.addCell(criteria3Record.getYearTable3521().get(i).getInput3521y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3521().size(); i++) {
				table3521criteria3.addCell(criteria3Record.getYearTable3521().get(i).getInput3521v());

			}

			document.add(table3521criteria3);
		}
		// 3.6 //
		Paragraph paragraph7criteria3 = new Paragraph("3.6	Extension Activities\r\n\r\n\r\n", font2);
		paragraph7criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph7criteria3);
		// create table 18 //
		PdfPTable table18criteria3 = new PdfPTable(2);
		PdfPTable table183criteria3 = new PdfPTable(1);

		table18criteria3.setWidthPercentage(100f);
		table183criteria3.setWidthPercentage(100f);

		PdfPCell cell181criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font2));
		PdfPCell cell182criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell183criteria3 = new PdfPCell(new Paragraph("Upload Any additional information\r\n\r\n\r\n"));
		PdfPCell cell184criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(31).getCriteria3FilePath() : ""));
		PdfPCell cell185criteria3 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
		PdfPCell cell186criteria3 = new PdfPCell(new Paragraph(""));
		table18criteria3.addCell(cell181criteria3);
		table18criteria3.addCell(cell182criteria3);
		table18criteria3.addCell(cell183criteria3);
		table18criteria3.addCell(cell184criteria3);
		table18criteria3.addCell(cell185criteria3);
		table18criteria3.addCell(cell186criteria3);
		PdfPCell cell361criteria3 = new PdfPCell(new Paragraph(
				"3.6.1 Extension activities are carried out in the neighbourhood community, sensitising students to social issues, for their holistic development, and impact thereof during the last five years\r\n"
						+ "\r\n\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria36Ql().get(0).getResponse361()
								: ""),
				font2));
		table183criteria3.addCell(cell361criteria3);
		table183criteria3.addCell(table18criteria3);
		// document.add(cell361criteria3);
		table183criteria3.setSpacingBefore(20f);
		table18criteria3.setSpacingAfter(20f);
		document.add(table183criteria3);

		// create table 19 //
		PdfPTable table19criteria3 = new PdfPTable(2);
		PdfPTable table191criteria3 = new PdfPTable(1);

		table19criteria3.setWidthPercentage(100f);
		table191criteria3.setWidthPercentage(100f);

		PdfPCell cell191criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell192criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell193criteria3 = new PdfPCell(
				new Paragraph("Number of awards for extension activities in last 5 year\r\n\r\n\r\n"));
		PdfPCell cell194criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(32).getCriteria3FilePath() : ""));
		PdfPCell cell195criteria3 = new PdfPCell(new Paragraph("e-copy of the award letters\r\n\r\n\r\n"));
		PdfPCell cell196criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(33).getCriteria3FilePath() : ""));
		PdfPCell cell197criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell198criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(34).getCriteria3FilePath() : ""));
		table19criteria3.addCell(cell191criteria3);
		table19criteria3.addCell(cell192criteria3);
		table19criteria3.addCell(cell193criteria3);
		table19criteria3.addCell(cell194criteria3);
		table19criteria3.addCell(cell195criteria3);
		table19criteria3.addCell(cell196criteria3);
		table19criteria3.addCell(cell197criteria3);
		table19criteria3.addCell(cell198criteria3);
		PdfPCell cell362criteria3 = new PdfPCell(new Paragraph(
				"3.6.2 Number of awards and recognition received by the Institution, its teachers and students for extension activities from Government / Government recognised bodies during last five years\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria36Qn().get(0).getResponse362()
								: ""),
				font2));
		PdfPCell cell3621criteria3 = new PdfPCell(new Paragraph(
				"3.6.2.1 Total number of awards and recognition received for extension activities from Government/ Government recognised bodies year-wise during the last five years."
						+ "\r\n\r\n",
				font2));

		table191criteria3.addCell(cell362criteria3);
		table191criteria3.addCell(cell3621criteria3);
		// document.add(cell362criteria3);
		// document.add(cell3621criteria3);
		table191criteria3.setSpacingBefore(20f);
		table191criteria3.setSpacingAfter(20f);
		document.add(table191criteria3);

		// create table 3621 //

		if (criteria3Record != null) {
			Table table3621criteria3 = new Table(criteria3Record.getYearTable3621().size(), 2);

			table3621criteria3.setPadding(10);
			table3621criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3621().size(); i++) {
				table3621criteria3.addCell(criteria3Record.getYearTable3621().get(i).getInput3621y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3621().size(); i++) {
				table3621criteria3.addCell(criteria3Record.getYearTable3621().get(i).getInput3621v());

			}

			document.add(table3621criteria3);
		}

		// create table 20 //
		PdfPTable table20criteria3 = new PdfPTable(2);
		PdfPTable table201criteria31 = new PdfPTable(1);

		table20criteria3.setWidthPercentage(100f);
		table201criteria31.setWidthPercentage(100f);

		PdfPCell cell201criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font2));
		PdfPCell cell202criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font2));
		PdfPCell cell203criteria3 = new PdfPCell(new Paragraph("Reports of the event organized\r\n\r\n"));
		PdfPCell cell204criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(35).getCriteria3FilePath() : ""));
		PdfPCell cell205criteria3 = new PdfPCell(new Paragraph(
				"Number of extension and outreach Programmes conducted with industry, community etc for the last five years\r\n\r\n"));
		PdfPCell cell206criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(36).getCriteria3FilePath() : ""));
		table20criteria3.addCell(cell201criteria3);
		table20criteria3.addCell(cell202criteria3);
		table20criteria3.addCell(cell203criteria3);
		table20criteria3.addCell(cell204criteria3);
		table20criteria3.addCell(cell205criteria3);
		table20criteria3.addCell(cell206criteria3);
		PdfPCell cell363criteria3 = new PdfPCell(new Paragraph(
				"3.6.3 Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years\r\n"
						+ "\r\n\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria36Qn().get(0).getResponse363()
								: ""),
				font2));
		PdfPCell cell3631criteria3 = new PdfPCell(new Paragraph(
				"3.6.3.1 Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years"
						+ "\r\n\r\n",
				font2));
		table201criteria31.addCell(cell363criteria3);
		table201criteria31.addCell(cell3631criteria3);
		table201criteria31.addCell(table20criteria3);
		// document.add(cell363criteria3);
		// document.add(cell3631criteria3);
		table201criteria31.setSpacingBefore(20f);
		table201criteria31.setSpacingAfter(20f);
		document.add(table201criteria31);
		// create table 3631 //

		if (criteria3Record != null) {
			Table table3631criteria3 = new Table(criteria3Record.getYearTable3631().size(), 2);

			table3631criteria3.setPadding(10);
			table3631criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3631().size(); i++) {
				table3631criteria3.addCell(criteria3Record.getYearTable3631().get(i).getInput3631y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3631().size(); i++) {
				table3631criteria3.addCell(criteria3Record.getYearTable3631().get(i).getInput3631v());

			}

			document.add(table3631criteria3);
		}

		// create a table 21 //
		PdfPTable table21criteria3 = new PdfPTable(2);
		PdfPTable table211criteria3 = new PdfPTable(1);
		table21criteria3.setWidthPercentage(100f);
		table211criteria3.setWidthPercentage(100f);

		PdfPCell cell211criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell212criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell213criteria3 = new PdfPCell(new Paragraph("Reports of the event\r\n\r\n\r\n"));
		PdfPCell cell214criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(37).getCriteria3FilePath() : ""));
		PdfPCell cell215criteria3 = new PdfPCell(new Paragraph(
				"Average percentage of students participating in extension activities with Govt or NGO etc\r\n\r\n\r\n"));
		PdfPCell cell216criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(38).getCriteria3FilePath() : ""));
		table21criteria3.addCell(cell211criteria3);
		table21criteria3.addCell(cell212criteria3);
		table21criteria3.addCell(cell213criteria3);
		table21criteria3.addCell(cell214criteria3);
		table21criteria3.addCell(cell215criteria3);
		table21criteria3.addCell(cell216criteria3);
		PdfPCell cell364criteria3 = new PdfPCell(new Paragraph(
				"3.6.4 Average percentage of students participating in extension activities listed at 3.6.3 above during the last five years\r\n"
						+ "\r\n\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria36Qn().get(0).getResponse364()
								: "")));
		PdfPCell cell3641criteria3 = new PdfPCell(new Paragraph(
				"3.6.4.1 Total number of students participating in extension activities listed at 3.6.3 above year-wise during the last five years."
						+ "\r\n\r\n",
				font2));
		table211criteria3.addCell(cell364criteria3);
		table211criteria3.addCell(cell3641criteria3);
		table211criteria3.addCell(table21criteria3);
		// document.add(cell364criteria3);
		// document.add(cell3641criteria3);
		table211criteria3.setSpacingBefore(20f);
		table211criteria3.setSpacingAfter(20f);
		document.add(table211criteria3);
		// create table 3641 //

		if (criteria3Record != null) {
			Table table3641criteria3 = new Table(criteria3Record.getYearTable3641().size(), 2);

			table3641criteria3.setPadding(10);
			table3641criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
				table3641criteria3.addCell(criteria3Record.getYearTable3641().get(i).getInput3641y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
				table3641criteria3.addCell(criteria3Record.getYearTable3641().get(i).getInput3641v());

			}

			document.add(table3641criteria3);
		}
		// 3.7//
		Paragraph paragraph8criteria3 = new Paragraph("3.7	Collaboration\r\n\r\n", font2);
		paragraph8criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph8criteria3);
		// create table 22 //
		PdfPTable table22criteria3 = new PdfPTable(2);
		PdfPTable table221criteria3 = new PdfPTable(1);
		table22criteria3.setWidthPercentage(100f);
		table221criteria3.setWidthPercentage(100f);

		PdfPCell cell221criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell222criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell223criteria3 = new PdfPCell(
				new Paragraph("Number of Collaborative activities for research, faculty etc \r\n\r\n\r\n"));
		PdfPCell cell224criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(39).getCriteria3FilePath() : ""));
		PdfPCell cell225criteria3 = new PdfPCell(new Paragraph("Copies of collaboration\r\n\r\n\r\n"));
		PdfPCell cell226criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(40).getCriteria3FilePath() : ""));
		table22criteria3.addCell(cell221criteria3);
		table22criteria3.addCell(cell222criteria3);
		table22criteria3.addCell(cell223criteria3);
		table22criteria3.addCell(cell224criteria3);
		table22criteria3.addCell(cell225criteria3);
		table22criteria3.addCell(cell226criteria3);
		PdfPCell cell371criteria3 = new PdfPCell(new Paragraph(
				"3.7.1 Number of Collaborative activities per year for research/ faculty exchange/ student exchange/ internship/ on –the-job training/ project work\r\n"
						+ "\r\n\r\n\r\n" + "Response: \r\n"
						+ (criteria3Record != null
								? criteria3Record.getCriteria37Qn().get(0).getResponse371()
								: ""),
				font2));
		PdfPCell cell3711criteria3 = new PdfPCell(new Paragraph("" + "", font2));
		table221criteria3.addCell(cell371criteria3);
		table221criteria3.addCell(cell3711criteria3);
		table221criteria3.addCell(table22criteria3);
		// document.add(cell371criteria3);
		// document.add(cell3711criteria3);
		table221criteria3.setSpacingBefore(20f);
		table221criteria3.setSpacingAfter(20f);
		document.add(table221criteria3);
		

	
		// create table 23 //
		PdfPTable table23criteria3 = new PdfPTable(2);
		PdfPTable table231criteria3 = new PdfPTable(1);

		table23criteria3.setWidthPercentage(100f);
		table231criteria3.setWidthPercentage(100f);

		PdfPCell cell231criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
		PdfPCell cell232criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
		PdfPCell cell233criteria3 = new PdfPCell(
				new Paragraph("e-copies of the MoUs with institution/ industry/ corporate house\r\n\r\n\r\n"));
		PdfPCell cell234criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(41).getCriteria3FilePath() : ""));
		PdfPCell cell235criteria3 = new PdfPCell(new Paragraph(
				"Details of functional MoUs with institutions of national, international importance, other Institutions etc during the last five years\r\n\r\n"));
		PdfPCell cell236criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(42).getCriteria3FilePath() : ""));
		PdfPCell cell237criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
		PdfPCell cell238criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(43).getCriteria3FilePath() : ""));
		table23criteria3.addCell(cell231criteria3);
		table23criteria3.addCell(cell232criteria3);
		table23criteria3.addCell(cell233criteria3);
		table23criteria3.addCell(cell234criteria3);
		table23criteria3.addCell(cell235criteria3);
		table23criteria3.addCell(cell236criteria3);
		table23criteria3.addCell(cell237criteria3);
		table23criteria3.addCell(cell238criteria3);
		PdfPCell cell372criteria3 = new PdfPCell(new Paragraph(
				"3.7.2 Number of functional MoUs with institutions of national, international importance, other institutions, industries, corporate houses etc. during the last five years (only functional MoUs with ongoing activities to be considered)\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria37Qn().get(0).getResponse372()
								: ""),
				font2));
		PdfPCell cell3721criteria3 = new PdfPCell(new Paragraph(
				"3.7.2.1 Number of functional MoUs with institutions of national, international importance, other Institutions, industries, corporate houses etc. year wise during last five years"
						+ "\r\n\r\n",
				font2));
		table231criteria3.addCell(cell372criteria3);
		table231criteria3.addCell(cell3721criteria3);
		table231criteria3.addCell(table23criteria3);
		// document.add(cell372criteria3);
		// document.add(cell3721criteria3);
		table231criteria3.setSpacingBefore(20f);
		table231criteria3.setSpacingAfter(20f);
		document.add(table231criteria3);
		// create table 3721 //

		if (criteria3Record != null) {
			Table table3721criteria3 = new Table(criteria3Record.getYearTable3721().size(), 2);

			table3721criteria3.setPadding(10);
			table3721criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3721().size(); i++) {
				table3721criteria3.addCell(criteria3Record.getYearTable3721().get(i).getInput3721y());

			}
			for (int i = 0; i < criteria3Record.getYearTable3721().size(); i++) {
				table3721criteria3.addCell(criteria3Record.getYearTable3721().get(i).getInput3721v());

			}

			document.add(table3721criteria3);
		}
		}
		catch(Exception e) {
      e.printStackTrace();
		}
		}
		
		
		
		

		////////////////////////////////////////////////////////////////////////////////////////
		///////////////// criteria 3 end ////////////////////////////

	

	public void Criteria4(Document document) {

		///////////////////////////////////////////////////////////////////////////////////////
		// Criteria 4 starts here...
		/////////////////////////////////////////////////////////////////////////////////////

		/*
		 * Font fontcriteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontcriteria4.setSize(16);
		 */

		Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources", font1);
		paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph1criteria4);

		/*
		 * Font font1criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font1criteria4.setSize(14);
		 */

		Paragraph paragraph2criteria4 = new Paragraph("4.1 Physical Facilities", font2);
		paragraph2criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph2criteria4);

		/*
		 * Font font2criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font2criteria4.setSize(12);
		 */

		PdfPTable table01criteria4 = new PdfPTable(1);

		table01criteria4.setWidthPercentage(100);

		PdfPCell cell0criteria4 = new PdfPCell(new Paragraph(
				"4.1.1 The Institution has adequate infrastructure and physical facilities for teaching- learning. viz., classrooms, laboratories, computing equipment etc.\r\n"
						+ "\r\n" + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria41Ql().get(0).getResponse411()
								: ""),
				font3));

		table01criteria4.addCell(cell0criteria4);

		// table101criteria5.addCell(table010criteria5);

		table01criteria4.setSpacingBefore(20f);
		table01criteria4.setSpacingAfter(20f);

		document.add(table01criteria4);

		/*
		 * Paragraph paragraph3criteria4 = new Paragraph(
		 * "4.1.1 The Institution has adequate infrastructure and physical facilities for teaching- learning. viz., classrooms, laboratories, computing equipment etc."
		 * , font3); paragraph3criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		 * 
		 * document.add(paragraph3criteria4);
		 */

		/*
		 * Font font3criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font3criteria4.setSize(12);
		 */

		Paragraph paragraph4criteria4 = new Paragraph("Response:", font3);

		PdfPTable table411criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table411criteria4.setWidthPercentage(100);

		/*
		 * able411criteria4.addCell(
		 * "4.1.1 The Institution has adequate infrastructure and physical facilities for teaching- learning. viz., classrooms, laboratories, computing equipment etc."
		 * + "\r\n" + "Response: " + (criteria4Record != null ?
		 * criteria4Record.getResponseValue411() : ""));
		 */
		// table411criteria4.addCell(criteria4List.get(0).getResponseValue411());
		document.add(table411criteria4);

		table411criteria4.setSpacingBefore(20f);
		table411criteria4.setSpacingAfter(20f);

		paragraph4criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph4criteria4);

		/*
		 * Font font4criteria4 = FontFactory.getFont(FontFactory.HELVETICA);
		 * font4criteria4.setSize(12);
		 */

		Paragraph paragraph5criteria4 = new Paragraph(
				"Mother Teresa has a lush green campus of 13.5 acres, with aesthetically designed buildings, which has been providing notable academic ambience, conducive for Quality Teaching-Learning. The college has adequate infrastructure facilities for Instructional delivery and services as denoted below",
				font5);
		paragraph5criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph5criteria4);

		/*
		 * Font font5criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font5criteria4.setSize(12);
		 */

		Paragraph paragraph6criteria4 = new Paragraph("Infrastructure facilities available for Teaching-Learning",
				font3);
		paragraph6criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph6criteria4);

		// creating table
		PdfPTable tablecriteria4 = new PdfPTable(4);

		tablecriteria4.setWidthPercentage(100);

		Font font6criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font6criteria4.setColor(CMYKColor.BLACK);

		PdfPCell cell1criteria4 = new PdfPCell(new Paragraph("Physical Facilities", font3));
		PdfPCell cell2criteria4 = new PdfPCell(new Paragraph("Total Number Area", font3));
		PdfPCell cell3criteria4 = new PdfPCell(new Paragraph("Area (in Sqm.)", font3));
		PdfPCell cell4criteria4 = new PdfPCell(new Paragraph("No. added during the ensuing A/A period", font3));
		PdfPCell cell5criteria4 = new PdfPCell(new Paragraph("Classrooms"));
		PdfPCell cell6criteria4 = new PdfPCell(new Paragraph("70"));
		PdfPCell cell7criteria4 = new PdfPCell(new Paragraph("5098"));
		PdfPCell cell8criteria4 = new PdfPCell(new Paragraph("12"));
		PdfPCell cell9criteria4 = new PdfPCell(new Paragraph("Laboratories"));
		PdfPCell cell10criteria4 = new PdfPCell(new Paragraph("87"));
		PdfPCell cell11criteria4 = new PdfPCell(new Paragraph("7019"));
		PdfPCell cell12criteria4 = new PdfPCell(new Paragraph("19"));
		PdfPCell cell13criteria4 = new PdfPCell(new Paragraph("Workshops"));
		PdfPCell cell14criteria4 = new PdfPCell(new Paragraph("06"));
		PdfPCell cell15criteria4 = new PdfPCell(new Paragraph("1469"));
		PdfPCell cell16criteria4 = new PdfPCell(new Paragraph("01"));
		PdfPCell cell17criteria4 = new PdfPCell(new Paragraph("Computer Centres"));
		PdfPCell cell18criteria4 = new PdfPCell(new Paragraph("02"));
		PdfPCell cell19criteria4 = new PdfPCell(new Paragraph("326"));
		PdfPCell cell20criteria4 = new PdfPCell(new Paragraph("01"));
		PdfPCell cell21criteria4 = new PdfPCell(new Paragraph("Drawing Hall"));
		PdfPCell cell22criteria4 = new PdfPCell(new Paragraph("02"));
		PdfPCell cell23criteria4 = new PdfPCell(new Paragraph("343"));
		PdfPCell cell24criteria4 = new PdfPCell(new Paragraph("-"));
		PdfPCell cell25criteria4 = new PdfPCell(new Paragraph("Seminar Rooms"));
		PdfPCell cell26criteria4 = new PdfPCell(new Paragraph("03"));
		PdfPCell cell27criteria4 = new PdfPCell(new Paragraph("687"));
		PdfPCell cell28criteria4 = new PdfPCell(new Paragraph("-"));
		PdfPCell cell29criteria4 = new PdfPCell(new Paragraph("Library"));
		PdfPCell cell30criteria4 = new PdfPCell(new Paragraph("01"));
		PdfPCell cell31criteria4 = new PdfPCell(new Paragraph("1064"));
		PdfPCell cell32criteria4 = new PdfPCell(new Paragraph("-"));
		PdfPCell cell33criteria4 = new PdfPCell(new Paragraph("Language Laboratories"));
		PdfPCell cell34criteria4 = new PdfPCell(new Paragraph("02"));
		PdfPCell cell35criteria4 = new PdfPCell(new Paragraph("137"));
		PdfPCell cell36criteria4 = new PdfPCell(new Paragraph("-"));
		PdfPCell cell37criteria4 = new PdfPCell(new Paragraph("Research Laboratories"));
		PdfPCell cell38criteria4 = new PdfPCell(new Paragraph("03"));
		PdfPCell cell39criteria4 = new PdfPCell(new Paragraph("323"));
		PdfPCell cell40criteria4 = new PdfPCell(new Paragraph("01"));
		PdfPCell cell41criteria4 = new PdfPCell(new Paragraph("Examination Center"));
		PdfPCell cell42criteria4 = new PdfPCell(new Paragraph("01"));
		PdfPCell cell43criteria4 = new PdfPCell(new Paragraph("280"));
		PdfPCell cell44criteria4 = new PdfPCell(new Paragraph("-"));

		tablecriteria4.addCell(cell1criteria4);
		tablecriteria4.addCell(cell2criteria4);
		tablecriteria4.addCell(cell3criteria4);
		tablecriteria4.addCell(cell4criteria4);
		tablecriteria4.addCell(cell5criteria4);
		tablecriteria4.addCell(cell6criteria4);
		tablecriteria4.addCell(cell7criteria4);
		tablecriteria4.addCell(cell8criteria4);
		tablecriteria4.addCell(cell9criteria4);
		tablecriteria4.addCell(cell10criteria4);
		tablecriteria4.addCell(cell11criteria4);
		tablecriteria4.addCell(cell12criteria4);
		tablecriteria4.addCell(cell13criteria4);
		tablecriteria4.addCell(cell14criteria4);
		tablecriteria4.addCell(cell15criteria4);
		tablecriteria4.addCell(cell16criteria4);
		tablecriteria4.addCell(cell17criteria4);
		tablecriteria4.addCell(cell18criteria4);
		tablecriteria4.addCell(cell19criteria4);
		tablecriteria4.addCell(cell20criteria4);
		tablecriteria4.addCell(cell21criteria4);
		tablecriteria4.addCell(cell22criteria4);
		tablecriteria4.addCell(cell23criteria4);
		tablecriteria4.addCell(cell24criteria4);
		tablecriteria4.addCell(cell25criteria4);
		tablecriteria4.addCell(cell26criteria4);
		tablecriteria4.addCell(cell27criteria4);
		tablecriteria4.addCell(cell28criteria4);
		tablecriteria4.addCell(cell29criteria4);
		tablecriteria4.addCell(cell30criteria4);
		tablecriteria4.addCell(cell31criteria4);
		tablecriteria4.addCell(cell32criteria4);
		tablecriteria4.addCell(cell33criteria4);
		tablecriteria4.addCell(cell34criteria4);
		tablecriteria4.addCell(cell35criteria4);
		tablecriteria4.addCell(cell36criteria4);
		tablecriteria4.addCell(cell37criteria4);
		tablecriteria4.addCell(cell38criteria4);
		tablecriteria4.addCell(cell39criteria4);
		tablecriteria4.addCell(cell40criteria4);
		tablecriteria4.addCell(cell41criteria4);
		tablecriteria4.addCell(cell42criteria4);
		tablecriteria4.addCell(cell43criteria4);
		tablecriteria4.addCell(cell44criteria4);

		tablecriteria4.setSpacingBefore(20f);
		tablecriteria4.setSpacingAfter(20f);

		document.add(tablecriteria4);

		Paragraph paragraph7criteria4 = new Paragraph("* Expanded Examination center", font5);
		paragraph7criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph8criteria4 = new Paragraph(
				"All the classrooms are equipped with LCD Projectors, and have Wi-Fi connectivity. In addition, air- conditioned seminar halls have public address systems for optimum acoustics. College provides special facilities for differently-abled persons, viz., Lifts, Ramp/ Rails, and wheel chairs. College has adequate power backup and UPS facilities. Electrical load of the college supported through two transformers of 200kVA and 125kVA with contract load of 160kVA and 100kVA respectively. Backup is provided through two Kirloskar diesel generators of 200kVA and 380kVA, to ensure un-interrupted power, for academic activities. Personal cabins for Deans, HoDs, Professors and Associate Professors with computer and printer facilities are available. Additional Discussion rooms and Meeting rooms are available for anytime interactions with the students.",
				font5);
		paragraph8criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph9criteria4 = new Paragraph(
				"Laboratories are adequately equipped and many have been established with industrial collaborations, viz., IBM, Redpine signals, Smartbridge and CDAC at a cost of Rs 53.98 lakhs. Centre of Excellence with Virtusa is established in specialized areas to provide domain-specific training to students. All the laboratories are supported through UPS with a total capacity of 680kVA. College also has installed a Solar power plant with a capacity of 250kw which is connected to the grid. Fire extinguishers are placed in each floor of every high-rise building for the safety of students and faculty. All laboratories are provided with required operating manuals for their smooth functioning. Laboratories are also kept open beyond working hours as per the requirement.",
				font5);
		paragraph9criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph10criteria4 = new Paragraph(
				"In addition to the central Library which has a rich knowledge resource, of the institution, each department has a separate library with good collection of textbooks. Digital Library resources are accessible on LAN (Intranet) to all students and faculty. Library server has a large collection of learning material.",
				font5);
		paragraph10criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph11criteria4 = new Paragraph("Computing Equipment\r\n" + " ", font3);
		paragraph11criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph7criteria4);
		document.add(paragraph8criteria4);
		document.add(paragraph9criteria4);
		document.add(paragraph10criteria4);
		document.add(paragraph11criteria4);

		// Creating a table of columns
		PdfPTable table1criteria4 = new PdfPTable(3);

		// Setting width of table, its columns and spacing
		table1criteria4.setWidthPercentage(100);

		PdfPCell cell01criteria4 = new PdfPCell(new Paragraph("Description", font3));
		PdfPCell cell02criteria4 = new PdfPCell(new Paragraph("Available Number", font3));
		PdfPCell cell03criteria4 = new PdfPCell(
				new Paragraph("Till 2020-21	Added during the ensuing A/A du	ratio", font3));
		PdfPCell cell04criteria4 = new PdfPCell(new Paragraph(" Desktop Computers"));
		PdfPCell cell05criteria4 = new PdfPCell(new Paragraph("1818 "));
		PdfPCell cell06criteria4 = new PdfPCell(new Paragraph("1547*"));
		PdfPCell cell07criteria4 = new PdfPCell(new Paragraph(" Servers"));
		PdfPCell cell08criteria4 = new PdfPCell(new Paragraph("05 "));
		PdfPCell cell09criteria4 = new PdfPCell(new Paragraph(" 01"));
		PdfPCell cell010criteria4 = new PdfPCell(new Paragraph("Laptops"));
		PdfPCell cell011criteria4 = new PdfPCell(new Paragraph("14"));
		PdfPCell cell012criteria4 = new PdfPCell(new Paragraph("02"));
		PdfPCell cell013criteria4 = new PdfPCell(new Paragraph("Printers"));
		PdfPCell cell014criteria4 = new PdfPCell(new Paragraph("84"));
		PdfPCell cell015criteria4 = new PdfPCell(new Paragraph("26"));
		PdfPCell cell016criteria4 = new PdfPCell(new Paragraph(" LCD Projector"));
		PdfPCell cell017criteria4 = new PdfPCell(new Paragraph("48"));
		PdfPCell cell018criteria4 = new PdfPCell(new Paragraph("27"));
		PdfPCell cell019criteria4 = new PdfPCell(new Paragraph("Exclusive Scanners "));
		PdfPCell cell020criteria4 = new PdfPCell(new Paragraph("	02 "));
		PdfPCell cell021criteria4 = new PdfPCell(new Paragraph("--"));
		PdfPCell cell022criteria4 = new PdfPCell(new Paragraph("Internet"));
		PdfPCell cell023criteria4 = new PdfPCell(new Paragraph("1000 Mbps "));
		PdfPCell cell024criteria4 = new PdfPCell(new Paragraph("952 Mbps"));
		PdfPCell cell025criteria4 = new PdfPCell(new Paragraph(" WiFi"));
		PdfPCell cell026criteria4 = new PdfPCell(new Paragraph(" Reliance Jio and Stand-alone Devices"));
		PdfPCell cell027criteria4 = new PdfPCell(new Paragraph("Reliance Jio and Stand-alone Dev	ices "));
		PdfPCell cell028criteria4 = new PdfPCell(new Paragraph("Firewall"));
		PdfPCell cell029criteria4 = new PdfPCell(new Paragraph("02"));
		PdfPCell cell030criteria4 = new PdfPCell(new Paragraph("--"));
		PdfPCell cell031criteria4 = new PdfPCell(new Paragraph("Writing Pads for Online classes"));
		PdfPCell cell032criteria4 = new PdfPCell(new Paragraph("46"));
		PdfPCell cell033criteria4 = new PdfPCell(new Paragraph("46 "));

		table1criteria4.addCell(cell01criteria4);
		table1criteria4.addCell(cell02criteria4);
		table1criteria4.addCell(cell03criteria4);
		table1criteria4.addCell(cell04criteria4);
		table1criteria4.addCell(cell05criteria4);
		table1criteria4.addCell(cell06criteria4);
		table1criteria4.addCell(cell07criteria4);
		table1criteria4.addCell(cell08criteria4);
		table1criteria4.addCell(cell09criteria4);
		table1criteria4.addCell(cell010criteria4);
		table1criteria4.addCell(cell011criteria4);
		table1criteria4.addCell(cell012criteria4);
		table1criteria4.addCell(cell013criteria4);
		table1criteria4.addCell(cell014criteria4);
		table1criteria4.addCell(cell015criteria4);
		table1criteria4.addCell(cell016criteria4);
		table1criteria4.addCell(cell017criteria4);
		table1criteria4.addCell(cell018criteria4);
		table1criteria4.addCell(cell019criteria4);
		table1criteria4.addCell(cell020criteria4);
		table1criteria4.addCell(cell021criteria4);
		table1criteria4.addCell(cell022criteria4);
		table1criteria4.addCell(cell023criteria4);
		table1criteria4.addCell(cell024criteria4);
		table1criteria4.addCell(cell025criteria4);
		table1criteria4.addCell(cell026criteria4);
		table1criteria4.addCell(cell027criteria4);
		table1criteria4.addCell(cell028criteria4);
		table1criteria4.addCell(cell029criteria4);
		table1criteria4.addCell(cell030criteria4);
		table1criteria4.addCell(cell031criteria4);
		table1criteria4.addCell(cell032criteria4);
		table1criteria4.addCell(cell033criteria4);

		table1criteria4.setSpacingBefore(10f);
		table1criteria4.setSpacingAfter(20f);

		document.add(table1criteria4);

		Paragraph paragraph12criteria4 = new Paragraph("* 1276 old desktop computers were written off", font5);
		paragraph12criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph12criteria4);

		PdfPTable table2 = new PdfPTable(2);
		table2.setWidthPercentage(100);

		PdfPCell cell001criteria4 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
		PdfPCell cell002criteria4 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		PdfPCell cell003criteria4 = new PdfPCell(new Paragraph("Upload Any additional information\r\n\r\n "));
		PdfPCell cell004criteria4 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
		PdfPCell cell005criteria4 = new PdfPCell(new Paragraph("paste link for additional information\r\n\r\n"));
		PdfPCell cell006criteria4 = new PdfPCell(new Paragraph(""));

		table2.addCell(cell001criteria4);
		table2.addCell(cell002criteria4);
		table2.addCell(cell003criteria4);
		table2.addCell(cell004criteria4);
		table2.addCell(cell005criteria4);
		table2.addCell(cell006criteria4);

		table2.setSpacingBefore(20f);
		table2.setSpacingAfter(20f);

		document.add(table2);

		Paragraph paragraph13criteria4 = new Paragraph(
				"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)",
				font3);
		paragraph13criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph14criteria4 = new Paragraph("Response:"
				+ (criteria4Record != null ? criteria4Record.getCriteria41Ql().get(0).getResponse412()
						: ""),
				font3);
		paragraph14criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph15criteria4 = new Paragraph(
				"Mother Teresa�s conviction is, the college years are crucial in students� cognitive, emotional, moral, and social development. Their involvement with peers in various co-curricular and extra-curricular, sports and cultural activities, influence development of their cognitive skills, identity, self-concept, self-esteem, values and attitudes, behavior patterns, and personality. They come across people who see the world differently than themselves and hear a lot of ideas/perceptions, contrary to their own, which they may not agree with. This experience enables them to keep an open mind, respect others� views and try to understand, even if one does not agree with them.\r\n"
						+ "\r\n"
						+ "Towards the above, college with its sprawling, lush green open-air Auditorium having 3000 seating capacity provides abundant space, facilitates a number of events. Notable among them are: Graduation Day, Traditional Day, Orientation Day for First Year students, Bathukamma, a flower festival, Earth Day, College Day celebrations, Music, Singing, Dance, Rangoli, Skits, and Photo Exhibitions. Active participation of students in various events, facilitate development of Creativity, Innovative thinking, Leadership, and Emotional Quotient in them.\r\n"
						+ "\r\n"
						+ "The college has six blocks for instructional purposes and associated co-curricular, extra-curricular and cultural activities.\r\n"
						+ "\r\n"
						+ "Block-I has a 250-seater, Air-conditioned Seminar Hall, used for practicing singing, skits, dancing etc.\r\n"
						+ "\r\n"
						+ "The portico of Block II, overlooking an aesthetically laid out garden is the stage for smaller events, namely, Fashion Shows, Dance Competitions, Painting Exhibitions etc.\r\n"
						+ "\r\n"
						+ "In Block III, the 100-seat Seminar Hall facilitates conduct of cultural events with limited gathering. The grounds in front of Block-III houses Basketball Court.\r\n"
						+ "\r\n"
						+ "Block-IV is furnished with a 400-seat Air-conditioned Seminar Hall, used for performing dance, musical programs, etc.,\r\n"
						+ "\r\n"
						+ "Table-tennis, carroms and chess games are facilitated in the games room of Block V. To the right of Block V, houses Cricket net practice sessions.\r\n"
						+ "\r\n"
						+ "Yoga sessions are conducted on the lawns of the Open Auditorium and Seminar Halls. \r\n"
						+ " ",
				font5);
		paragraph15criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph24criteria4 = new Paragraph("The open lawns facilitate the following:", font5);
		paragraph24criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph241 = new Paragraph(" ", font5);
		paragraph241.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet1criteria4 = new Chunk("\u2022", font5);
		paragraph241.add(bullet1criteria4);

		paragraph241.add(new Phrase("College day: VIBGYOR, VIBES\r\n" + "\r\n", font5));
		paragraph241.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph242 = new Paragraph(" ", font5);
		paragraph242.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet2criteria4 = new Chunk("\u2022", font5);
		paragraph242.add(bullet2criteria4);

		paragraph242.add(new Phrase("Yoga\r\n" + "\r\n", font5));

		paragraph242.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph243 = new Paragraph(" ", font5);
		paragraph243.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet3criteria4 = new Chunk("\u2022", font5);
		paragraph243.add(bullet3criteria4);

		paragraph243.add(new Phrase("Regional and National festivals of importance\r\n", font5));

		paragraph243.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph244 = new Paragraph(" ", font5);
		paragraph244.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet4criteria4 = new Chunk("\u2022", font5);
		paragraph244.add(bullet4criteria4);

		paragraph244.add(new Phrase(" Alumni association meet\r\n", font5));

		paragraph244.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph245 = new Paragraph(" ", font5);
		paragraph245.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet5criteria4 = new Chunk("\u2022", font5);
		paragraph245.add(bullet5criteria4);

		paragraph245.add(new Phrase("Mother Teresa family get together\r\n" + "\r\n", font5));

		paragraph245.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph246 = new Paragraph(" ", font5);
		paragraph246.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet6criteria4 = new Chunk("\u2022", font5);
		paragraph246.add(bullet6criteria4);

		paragraph246.add(new Phrase("Football practice\r\n" + "\r\n", font5));

		paragraph246.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph21 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph21.setSize(12);
		 */

		Paragraph paragraph25criteria4 = new Paragraph(
				"Institution allocates one/two-hour time slots in Timetable encouraging students participation in sports thereby inculcating sporting spirit in them and they understand that winning & losing are part of life. Transportation is arranged for students participating in sports and games beyond working hours to reach their homes. It�s the institution�s conviction that holistic development of a student is only possible, when students participate in several cultural, literary and sports activities over and above their academics. Mother Teresates won several laurels in State Under-19 competitions in many sports events in the past few years. ",
				font5);
		paragraph25criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph22criteria4 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph22criteria4.setSize(12);
		 */

		Paragraph paragraph26criteria4 = new Paragraph("Details of the facility created/r/n ", font3);
		paragraph26criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph13criteria4);
		document.add(paragraph14criteria4);
		document.add(paragraph15criteria4);
		document.add(paragraph24criteria4);
		document.add(paragraph241);
		document.add(paragraph242);
		document.add(paragraph243);
		document.add(paragraph244);
		document.add(paragraph245);
		document.add(paragraph246);
		document.add(paragraph25criteria4);
		document.add(paragraph26criteria4);

		// Creating a table of columns
		PdfPTable table3criteria4 = new PdfPTable(4);

		// Setting width of table, its columns and spacing
		table3criteria4.setWidthPercentage(100);

		PdfPCell cell101criteria4 = new PdfPCell(new Paragraph("Facility", font3));
		PdfPCell cell102criteria4 = new PdfPCell(new Paragraph("Year of creation", font3));
		PdfPCell cell103criteria4 = new PdfPCell(new Paragraph("Area in Sqm", font3));
		PdfPCell cell104criteria4 = new PdfPCell(new Paragraph(" Year facility enhanced", font3));
		PdfPCell cell105criteria4 = new PdfPCell(new Paragraph("Volleyball "));
		PdfPCell cell106criteria4 = new PdfPCell(new Paragraph(" 2005"));
		PdfPCell cell107criteria4 = new PdfPCell(new Paragraph("162	"));
		PdfPCell cell108criteria4 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell109 = new PdfPCell(new Paragraph("Basketball"));
		PdfPCell cell1010 = new PdfPCell(new Paragraph("2005"));
		PdfPCell cell1011 = new PdfPCell(new Paragraph("436  "));
		PdfPCell cell1012 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell1013 = new PdfPCell(new Paragraph("Throwball "));
		PdfPCell cell1014 = new PdfPCell(new Paragraph("	2005 "));
		PdfPCell cell1015 = new PdfPCell(new Paragraph("	222	"));
		PdfPCell cell1016 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell1017 = new PdfPCell(new Paragraph("Cricket	"));
		PdfPCell cell1018 = new PdfPCell(new Paragraph("2005 "));
		PdfPCell cell1019 = new PdfPCell(new Paragraph("3600 "));
		PdfPCell cell1020 = new PdfPCell(new Paragraph("2016  "));
		PdfPCell cell1021 = new PdfPCell(new Paragraph("Kabaddi "));
		PdfPCell cell1022 = new PdfPCell(new Paragraph("	2005"));
		PdfPCell cell1023 = new PdfPCell(new Paragraph("130"));
		PdfPCell cell1024 = new PdfPCell(new Paragraph("2020 "));
		PdfPCell cell1025 = new PdfPCell(new Paragraph("Cricket-net practice"));
		PdfPCell cell1026 = new PdfPCell(new Paragraph("2020 "));
		PdfPCell cell1027 = new PdfPCell(new Paragraph("74 "));
		PdfPCell cell1028 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell1029 = new PdfPCell(new Paragraph("Indoor Sports (Carroms Table-Tennis, Chess etc.)"));
		PdfPCell cell1030 = new PdfPCell(new Paragraph("2005 "));
		PdfPCell cell1031 = new PdfPCell(new Paragraph("219"));
		PdfPCell cell1032 = new PdfPCell(new Paragraph("2020"));
		PdfPCell cell1033 = new PdfPCell(new Paragraph("Yoga center"));
		PdfPCell cell1034 = new PdfPCell(new Paragraph("2016 "));
		PdfPCell cell1035 = new PdfPCell(new Paragraph("89 "));
		PdfPCell cell1036 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell1037 = new PdfPCell(new Paragraph("Open-air Auditorium	"));
		PdfPCell cell1038 = new PdfPCell(new Paragraph("2005 "));
		PdfPCell cell1039 = new PdfPCell(new Paragraph("3310  "));
		PdfPCell cell1040 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell1041 = new PdfPCell(new Paragraph("Block -1 (II-floor) Air conditioned Seminar Hall)"));
		PdfPCell cell1042 = new PdfPCell(new Paragraph("	2006 "));
		PdfPCell cell1043 = new PdfPCell(new Paragraph("263	 "));
		PdfPCell cell1044 = new PdfPCell(new Paragraph("	2019 (Modernized) "));
		PdfPCell cell1045 = new PdfPCell(new Paragraph("Auditorium Air-conditioned"));
		PdfPCell cell1046 = new PdfPCell(new Paragraph("2019 "));
		PdfPCell cell1047 = new PdfPCell(new Paragraph("287 "));
		PdfPCell cell1048 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell1049 = new PdfPCell(new Paragraph("Block -3 Seminar Hall "));
		PdfPCell cell1050 = new PdfPCell(new Paragraph("2018 "));
		PdfPCell cell1051 = new PdfPCell(new Paragraph("	137"));
		PdfPCell cell1052 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell1053 = new PdfPCell(new Paragraph("Foot Ball Ground"));
		PdfPCell cell1054 = new PdfPCell(new Paragraph("2005 "));
		PdfPCell cell1055 = new PdfPCell(new Paragraph("	4050 "));
		PdfPCell cell1056 = new PdfPCell(new Paragraph("2020 "));

		table3criteria4.addCell(cell101criteria4);
		table3criteria4.addCell(cell102criteria4);
		table3criteria4.addCell(cell103criteria4);
		table3criteria4.addCell(cell104criteria4);
		table3criteria4.addCell(cell105criteria4);
		table3criteria4.addCell(cell106criteria4);
		table3criteria4.addCell(cell107criteria4);
		table3criteria4.addCell(cell108criteria4);
		table3criteria4.addCell(cell109);
		table3criteria4.addCell(cell1010);
		table3criteria4.addCell(cell1011);
		table3criteria4.addCell(cell1012);
		table3criteria4.addCell(cell1013);
		table3criteria4.addCell(cell1014);
		table3criteria4.addCell(cell1015);
		table3criteria4.addCell(cell1016);
		table3criteria4.addCell(cell1017);
		table3criteria4.addCell(cell1018);
		table3criteria4.addCell(cell1019);
		table3criteria4.addCell(cell1020);
		table3criteria4.addCell(cell1021);
		table3criteria4.addCell(cell1022);
		table3criteria4.addCell(cell1023);
		table3criteria4.addCell(cell1024);
		table3criteria4.addCell(cell1025);
		table3criteria4.addCell(cell1026);
		table3criteria4.addCell(cell1027);
		table3criteria4.addCell(cell1028);
		table3criteria4.addCell(cell1029);
		table3criteria4.addCell(cell1030);
		table3criteria4.addCell(cell1031);
		table3criteria4.addCell(cell1032);
		table3criteria4.addCell(cell1033);
		table3criteria4.addCell(cell1034);
		table3criteria4.addCell(cell1035);
		table3criteria4.addCell(cell1036);
		table3criteria4.addCell(cell1037);
		table3criteria4.addCell(cell1038);
		table3criteria4.addCell(cell1039);
		table3criteria4.addCell(cell1040);
		table3criteria4.addCell(cell1041);
		table3criteria4.addCell(cell1042);
		table3criteria4.addCell(cell1043);
		table3criteria4.addCell(cell1044);
		table3criteria4.addCell(cell1045);
		table3criteria4.addCell(cell1046);
		table3criteria4.addCell(cell1047);
		table3criteria4.addCell(cell1048);
		table3criteria4.addCell(cell1049);
		table3criteria4.addCell(cell1050);
		table3criteria4.addCell(cell1051);
		table3criteria4.addCell(cell1052);
		table3criteria4.addCell(cell1053);
		table3criteria4.addCell(cell1054);
		table3criteria4.addCell(cell1055);
		table3criteria4.addCell(cell1056);

		table3criteria4.setSpacingBefore(20f);
		table3criteria4.setSpacingAfter(20f);

		document.add(table3criteria4);

		// Creating a table of 3 columns
		PdfPTable table4criteria4 = new PdfPTable(2);
		PdfPTable table412criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table4criteria4.setWidthPercentage(100);
		table412criteria4.setWidthPercentage(100);

		PdfPCell cell007 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
		PdfPCell cell008 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		PdfPCell cell0009 = new PdfPCell(new Paragraph(" Upload Any additional information\r\n\r\n"));
		PdfPCell cell0010 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
		PdfPCell cell0011 = new PdfPCell(new Paragraph("Geotagged pictures\r\n\r\n"));
		PdfPCell cell0012 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : ""));
		PdfPCell cell0013 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
		PdfPCell cell0014 = new PdfPCell(new Paragraph(""));

		table4criteria4.addCell(cell007);
		table4criteria4.addCell(cell008);
		table4criteria4.addCell(cell0009);
		table4criteria4.addCell(cell0010);
		table4criteria4.addCell(cell0011);
		table4criteria4.addCell(cell0012);
		table4criteria4.addCell(cell0013);
		table4criteria4.addCell(cell0014);

		PdfPCell cell412criteria4 = new PdfPCell(new Paragraph(
				"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria41Ql().get(0).getResponse412()
								: ""),
				font3));

		table412criteria4.addCell(cell412criteria4);
		table412criteria4.addCell(table4criteria4);
		table412criteria4.setSpacingBefore(20f);
		table412criteria4.setSpacingAfter(20f);

		document.add(table412criteria4);

		// Creating a table of columns
		PdfPTable table5criteria4 = new PdfPTable(2);
		PdfPTable table51 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table5criteria4.setWidthPercentage(100);
		table51.setWidthPercentage(100);

		PdfPCell cell0015 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
		PdfPCell cell0016 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		PdfPCell cell0017 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n"));
		PdfPCell cell0018 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(3).getCriteria4FilePath() : ""));
		PdfPCell cell0019 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
		PdfPCell cell0020 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(4).getCriteria4FilePath() : ""));
		PdfPCell cell0021 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
		PdfPCell cell0022 = new PdfPCell(new Paragraph());

		table5criteria4.addCell(cell0015);
		table5criteria4.addCell(cell0016);
		table5criteria4.addCell(cell0017);
		table5criteria4.addCell(cell0018);
		table5criteria4.addCell(cell0019);
		table5criteria4.addCell(cell0020);
		table5criteria4.addCell(cell0021);
		table5criteria4.addCell(cell0022);

		table51.addCell(
				"4.1.3 Percentage of classrooms and seminar halls with ICT- enabled facilities such as smart class, LMS, etc. (Data for the latest completed academic year)\r\n"
						+ "\r\n" + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria41Qn().get(0).getResponse413()
								: ""));

		table51.addCell("4.1.3.1 Number of classrooms and seminar halls with ICT facilities\r\n" + "\r\n\r\n" + "Response: "
				+ (criteria4Record != null ? criteria4Record.getCriteria41Qn().get(0).getInput4131t1() : ""));

		// table51.addCell(criteria4List.get(0).getResponseValue413());

		table51.addCell(table5criteria4);

		table51.setSpacingBefore(20f);
		table51.setSpacingAfter(20f);

		document.add(table51);

		// Creating a table of 3 columns
		PdfPTable table6criteria4 = new PdfPTable(5);
		PdfPTable table61criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
	
		table61criteria4.addCell(
				"4.1.4 Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)\r\n"
						+ "\r\n" + "Response: "
						+ (criteria4Record != null
								? criteria4Record.getCriteria41Ql().get(0).getResponse414()
								: ""));

		// table61criteria4.addCell(criteria4List.get(0).getResponseValue414());

		table61criteria4.addCell(
				"4.1.4.1 Expenditure for infrastructure augmentation, excluding salary year-wise during last five years (INR in lakhs)\r\n\r\n");

		// table61.addCell(table6);

		table61criteria4.setSpacingBefore(20f);
		table61criteria4.setSpacingAfter(20f);

		document.add(table61criteria4);

		if (criteria4Record != null) {

			Table table4141 = new Table(criteria4Record.getYearTable4141().size(), 2);

			table4141.setPadding(10);
			table4141.setWidth(100f);

			for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
				table4141.addCell(criteria4Record.getYearTable4141().get(i).getInput4141y());

			}
			for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
				table4141.addCell(criteria4Record.getYearTable4141().get(i).getInput4141v());

			}

			document.add(table4141);
		}

		// Creating a table of 3 columns
		PdfPTable table7criteria4 = new PdfPTable(2);

		// Setting width of table, its columns and spacing
		table7criteria4.setWidthPercentage(100);

		PdfPCell cell0033 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font6criteria4));
		PdfPCell cell0034 = new PdfPCell(new Paragraph("Document\r\n\r\n", font6criteria4));
		PdfPCell cell0035 = new PdfPCell(
				new Paragraph("Upload Details of Expenditure , excluding salary during the last five years\r\n\r\n "));
		PdfPCell cell0036 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(5).getCriteria4FilePath() : ""));
		PdfPCell cell0037 = new PdfPCell(new Paragraph("Upload audited utilization statements\r\n\r\n"));
		PdfPCell cell0038 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(6).getCriteria4FilePath() : ""));
		PdfPCell cell0039 = new PdfPCell(new Paragraph(" Link for any additional information\r\n\r\n"));
		PdfPCell cell0040 = new PdfPCell(new Paragraph(" "));

		table7criteria4.addCell(cell0033);
		table7criteria4.addCell(cell0034);
		table7criteria4.addCell(cell0035);
		table7criteria4.addCell(cell0036);
		table7criteria4.addCell(cell0037);
		table7criteria4.addCell(cell0038);
		table7criteria4.addCell(cell0039);
		table7criteria4.addCell(cell0040);

		table7criteria4.setSpacingBefore(20f);
		table7criteria4.setSpacingAfter(20f);

		document.add(table7criteria4);

		/*
		 * Font fontParagraph27 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph27.setSize(12);
		 */

		Paragraph paragraph31criteria4 = new Paragraph("4.2 Library as a Learning Resource\r\n\r\n\r\n", font1);
		paragraph31criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph28 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph28.setSize(12);
		 */

		Paragraph paragraph32criteria4 = new Paragraph(
				"4.2.1	Library is automated using Integrated Library Management System (ILMS)\r\n" + "Response",
				font2);
		paragraph32criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		PdfPTable table421criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table421criteria4.setWidthPercentage(100);

		table421criteria4.addCell(
				"4.2.1 Library is automated using Integrated Library Management System (ILMS)\r\n\r\n+ Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria42Ql().get(0).getResponse421()
								: ""));
		// table421criteria4.addCell(criteria4List.get(3).getResponseValue421());
		document.add(table421criteria4);

		table421criteria4.setSpacingBefore(20f);
		table421criteria4.setSpacingAfter(20f);
		document.add(table421criteria4);

		/*
		 * Font fontParagraph29 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph29.setSize(12);
		 */

		Paragraph paragraph33criteria4 = new Paragraph("4.2 Response:"
				+ (criteria4Record != null ? criteria4Record.getCriteria42Ql().get(0).getResponse421()
						: ""),
				font3);
		paragraph33criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph30 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph30.setSize(12);
		 */

		Paragraph paragraph34criteria4 = new Paragraph(
				"Mother Teresa has a spacious central library in an independent building with an area of 1064 Sqm. spread over two floors. Ground Floor is accommodating OPAC, periodicals, News Papers, digital library, thesis, reprography and special reference. First floor is accommodating circulation, references, periodical back volumes, computer centre etc. It is having a modern infrastructure with a seating capacity of 250 students. ",
				font5);
		paragraph34criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph31 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph31.setSize(12);
		 */

		Paragraph paragraph35criteria4 = new Paragraph(
				"Central Library is fully automated with Integrated Library Management Software, Ez School version\r\n"
						+ "10.0.9.22 and On Edu software used for circulation, procurement, Online Public Access Catalogue (OPAC). All library documents are bar-coded and books are issued to users by scanning the barcode of the document\r\n"
						+ " ",
				font5);
		paragraph35criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph32 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph32.setSize(12);
		 */

		Paragraph paragraph36criteria4 = new Paragraph(
				"Library & Information Centre provides uncompromising information and intellectual requirements to its students and faculty with user-friendly approach. It offers a fully integrated and dynamic environment for conducting academic study. Library is fully computerized with bar-coding system\r\n",
				font5);
		paragraph36criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph361 = new Paragraph(" ", font5);
		paragraph361.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet7criteria4 = new Chunk("\u2022", font5);
		paragraph361.add(bullet7criteria4);

		paragraph361.add(new Phrase("Name of the ILMS software: Ez School Software and OnEdu Software\r\n", font5));

		Paragraph paragraph362 = new Paragraph(" ", font5);
		paragraph362.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet8criteria4 = new Chunk("\u2022", font5);
		paragraph362.add(bullet8criteria4);

		paragraph362.add(new Phrase("Nature of automation (full or partial): Fully Automated/r/n", font5));

		Paragraph paragraph363 = new Paragraph(" ", font5);
		paragraph363.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet9criteria4 = new Chunk("\u2022", font5);
		paragraph363.add(bullet9criteria4);

		paragraph363.add(new Phrase("Version: Ez School software 10.0.9.22 and OnEdu software/r/n", font5));

		Paragraph paragraph364 = new Paragraph(" ", font5);
		paragraph364.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		Chunk bullet10criteria4 = new Chunk("\u2022", font5);
		paragraph364.add(bullet10criteria4);

		paragraph364.add(new Phrase("Year of automation :2009", font5));

		/*
		 * Font fontParagraph33 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph33.setSize(12);
		 */

		Paragraph paragraph37criteria4 = new Paragraph(
				"The College has a Digital Library with 100 systems, connected to the college�s intranet, providing services, such as digitalized versions of question papers, syllabus, Articles of National and International standards, e-lectures of faculty of IITs, NPTEL, Textbooks, CD/DVDs, videos of Spoken English, video Films, Britannica Encyclopaedia, books for preparing towards GATE, GRE, TOFEL, CAT etc.\r\n"
						+ "\r\n"
						+ "Reference Section has various books including Personality Development Books and other books useful for student professional and career development.\r\n"
						+ "\r\n"
						+ "The Library has an Electronic Resource Centre (ERC) which provides access to vast stores of electronic information of IEEE, DELNET and unlimited number of digital, online open resource journals of Engineering, Applied Sciences, Management and other Internet-based service to its readers.\r\n"
						+ "",
				font5);
		paragraph37criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph31criteria4);
		document.add(paragraph32criteria4);
		document.add(paragraph33criteria4);
		document.add(paragraph34criteria4);
		document.add(paragraph35criteria4);
		document.add(paragraph36criteria4);
		document.add(paragraph361);
		document.add(paragraph362);
		document.add(paragraph363);
		document.add(paragraph364);
		document.add(paragraph37criteria4);

		// Creating a table of 3 columns
		PdfPTable table8criteria4 = new PdfPTable(2);

		// Setting width of table, its columns and spacing
		table8criteria4.setWidthPercentage(100);

		PdfPCell cell0041 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font6criteria4));
		PdfPCell cell0042 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
		PdfPCell cell0043 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
		PdfPCell cell0044 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(7).getCriteria4FilePath() : ""));
		PdfPCell cell0045 = new PdfPCell(new Paragraph("Paste Link for additional information\r\n\r\n\r\n "));
		PdfPCell cell0046 = new PdfPCell(new Paragraph(" "));

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

		PdfPCell cell0047 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font6criteria4));
		PdfPCell cell0048 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
		PdfPCell cell0049 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
		PdfPCell cell0050 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(8).getCriteria4FilePath() : ""));
		PdfPCell cell0051 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
		PdfPCell cell0052 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(9).getCriteria4FilePath() : ""));
		PdfPCell cell0053 = new PdfPCell(new Paragraph(
				"Details of subscriptions like e-journals, e-books , e- ShodhSindhu, Shodhganga Membership etc\r\n\r\n\r\n"));
		PdfPCell cell0054 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(10).getCriteria4FilePath() : ""));

		table9criteria4.addCell(cell0047);
		table9criteria4.addCell(cell0048);
		table9criteria4.addCell(cell0049);
		table9criteria4.addCell(cell0050);
		table9criteria4.addCell(cell0051);
		table9criteria4.addCell(cell0052);
		table9criteria4.addCell(cell0053);
		table9criteria4.addCell(cell0054);

		table10criteria4.addCell(
				"4.2.2 Institution has access to the following: 1. e-journals 2. e-ShodhSindhu 3. Shodhganga Membership 4. e-books 5. Databases 6. Remote access to e-resources\r\n"
						+ "\r\n\r\n\r\n" + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria42Qn().get(0).getResponse422()
								: ""));
		// table10criteria4.addCell(criteria4List.get(0).getResponseValue422());
		table10criteria4.addCell(table9criteria4);

		table10criteria4.setSpacingBefore(20f);
		table10criteria4.setSpacingAfter(20f);

		document.add(table10criteria4);

		// Creating a table of 3 columns
		PdfPTable table11criteria4 = new PdfPTable(5);
		PdfPTable table12criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table11criteria4.setWidthPercentage(100);
		table12criteria4.setWidthPercentage(100);

		PdfPCell cell0055 = new PdfPCell(new Paragraph("2020-21"));
		PdfPCell cell0056 = new PdfPCell(new Paragraph("2019-20"));
		PdfPCell cell0057 = new PdfPCell(new Paragraph("2018-19"));
		PdfPCell cell0058 = new PdfPCell(new Paragraph("2017-18"));
		PdfPCell cell0059 = new PdfPCell(new Paragraph("2016-17"));
		PdfPCell cell0060 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell0061 = new PdfPCell(new Paragraph(""));
		PdfPCell cell0062 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell0063 = new PdfPCell(new Paragraph(""));
		PdfPCell cell0064 = new PdfPCell(new Paragraph(" "));

		table11criteria4.addCell(cell0055);
		table11criteria4.addCell(cell0056);
		table11criteria4.addCell(cell0057);
		table11criteria4.addCell(cell0058);
		table11criteria4.addCell(cell0059);
		table11criteria4.addCell(cell0060);
		table11criteria4.addCell(cell0061);
		table11criteria4.addCell(cell0062);
		table11criteria4.addCell(cell0063);
		table11criteria4.addCell(cell0064);

		table12criteria4.addCell(
				"4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n"
						+ "\r\n\r\n" + "Response: "
						+ (criteria4Record != null
								? criteria4Record.getCriteria42Qn().get(0).getResponse423()
								: ""));
		// table12criteria4.addCell(criteria4List.get(4).getResponseValue423());

		table12criteria4.addCell(
				"4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)"
						+ "\r\n\r\n\r\n");

		// table12.addCell(table11);

		table12criteria4.setSpacingBefore(20f);
		table12criteria4.setSpacingAfter(20f);

		document.add(table12criteria4);

		if (criteria4Record != null) {

			Table table4231 = new Table(criteria4Record.getYearTable4231().size(), 2);

			table4231.setPadding(10);
			table4231.setWidth(100f);

			for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
				table4231.addCell(criteria4Record.getYearTable4231().get(i).getInput4231y());

			}
			for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
				table4231.addCell(criteria4Record.getYearTable4231().get(i).getInput4231v());

			}

			document.add(table4231);
		}

		// Creating a table of 3 columns

		PdfPTable table13 = new PdfPTable(2);

		// Setting width of table, its columns and spacing
		table13.setWidthPercentage(100);

		PdfPCell cell0065 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font6criteria4));
		PdfPCell cell0066 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
		PdfPCell cell0067 = new PdfPCell(new Paragraph(
				"Details of annual expenditure for purchase of and subscription to journals/e-journals during the last five years\r\n\r\n\r\n"));
		PdfPCell cell0068 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(11).getCriteria4FilePath() : ""));
		PdfPCell cell0069 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n\r\n"));
		PdfPCell cell0070 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(12).getCriteria4FilePath() : ""));
		PdfPCell cell0071 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell0072 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(13).getCriteria4FilePath() : ""));

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

		document.add(table13);

		// Creating a table of 3 columns
		PdfPTable table14criteria4 = new PdfPTable(2);
		PdfPTable table15 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table14criteria4.setWidthPercentage(100);
		table15.setWidthPercentage(100);

		PdfPCell cell0075 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font6criteria4));
		PdfPCell cell0076 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
		PdfPCell cell0077 = new PdfPCell(new Paragraph("Details of library usage by teachers and students\r\n\r\n\r\n"));
		PdfPCell cell0078 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(14).getCriteria4FilePath() : ""));
		PdfPCell cell0079 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell0080 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(15).getCriteria4FilePath() : ""));

		table14criteria4.addCell(cell0075);
		table14criteria4.addCell(cell0076);
		table14criteria4.addCell(cell0077);
		table14criteria4.addCell(cell0078);
		table14criteria4.addCell(cell0079);
		table14criteria4.addCell(cell0080);

		table15.addCell(
				"4.2.4 Percentage per day usage of library by teachers and students ( foot falls and login data for online access) during the latest completed academic year\r\n"
						+ "\r\n\r\n\r\n" + "Response: "
						+ (criteria4Record != null
								? criteria4Record.getCriteria42Qn().get(0).getResponse424()
								: ""));

		// table15.addCell(criteria4List.get(0).getResponseValue424());

		table15.addCell("4.2.4.1 Number of teachers and students using library per day over last one year\r\n" + "\r\n"
				+ "Response: "
				+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getInput4241t1() : ""));

		table15.addCell(table14criteria4);

		table15.setSpacingBefore(20f);
		table15.setSpacingAfter(20f);

		document.add(table15);

		/*
		 * Font fontParagraph34 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph34.setSize(12);
		 */

		Paragraph paragraph38criteria4 = new Paragraph("4.3 Infrastructure\r\n\rn", font1);
		paragraph38criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph35 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph35.setSize(12);
		 */

		Paragraph paragraph39criteria4 = new Paragraph(
				"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n\r\n",font2);
		paragraph39criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph36 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph36.setSize(12);
		 */

		Paragraph paragraph40 = new Paragraph("Response:\r\n\r\n", font3);
		paragraph40.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph37 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph37.setSize(12);
		 */

		Paragraph paragraph41 = new Paragraph(
				"Mother Teresa considers that in the current information age no organization can survive without extensive use of IT. Towards this, the college has developed an IT policy encompassing all IT/IT enabled services used in the campus, ensuring smooth functioning with adequate security to all users connected to the campus network.\r\n"
						+ "\r\n"
						+ "Based on the laboratory and other requirements, every year college allocates budget for updating its IT facilities for procurement of computer systems and other IT related equipment including software.\r\n"
						+ "\r\n"
						+ "Every user in the campus is provided access to the campus network as well as internet.\r\n"
						+ "\r\n"
						+ "48 LCD projectors have been installed in class rooms and labs with wi-fi/internet connectivity.\r\n"
						+ "\r\n"
						+ "All students and faculty are given email accounts with college domain name through GSuite. The college has installed two firewalls in order to protect all its internal systems from cyber attacks.\r\n"
						+ " \r\n"
						+ "The college also installed CISCO switches for monitoring traffic in the campus network.\r\n"
						+ "",
				font5);
		paragraph41.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph38 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph38.setSize(12);
		 */

		Paragraph paragraph42 = new Paragraph("The details of up-dation as follows:", font2);
		paragraph42.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph39 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph39.setSize(12);
		 */

		Paragraph paragraph43criteria4 = new Paragraph("AY 2020-21\r\n" + "\r\n"
				+ "1.	Procured 320 Lenovo computers of core i5 of 16GB RAM, 1TB HDD.\r\n"
				+ "2.	Provided ICT Facilities in 06 class rooms\r\n"
				+ "3.	Internet facility was upgraded from 210 Mbps to 1000 Mbps with two distinct service providers.\r\n"
				+ "4.	ACT (Atria Convergence Technologies Ltd) Fibre (500Mbps).\r\n"
				+ "5.D-Vios Communications Pvt Ltd.(500Mbps).\r\n" + " ", font5);
		paragraph43criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph40 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph40.setSize(12);
		 */

		Paragraph paragraph44 = new Paragraph("AY 2019-20\r\n" + "\r\n"
				+ "1.	Provided ICT Facilities in 04 class rooms\r\n"
				+ "2.	Established Robotics Learning and Development Centre Lab in collaboration with Smart Bridge Educational Services Pvt. Ltd.\r\n"
				+ "3.	Procured 256 Acer computers of core i5 of 8GB RAM, 1TB HDD.\r\n"
				+ "4.	Installed Firewall �Sophos XG Firewall� for exam branch.\r\n" + " ", font5);
		paragraph44.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph41 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph41.setSize(12);
		 */

		Paragraph paragraph45 = new Paragraph("AY 2019-20\r\n" + "\r\n"
				+ "1.	Provided ICT Facilities in 04 class rooms\r\n"
				+ "2.	Established Robotics Learning and Development Centre Lab in collaboration with Smart Bridge Educational Services Pvt. Ltd.\r\n"
				+ "3.	Procured 256 Acer computers of core i5 of 8GB RAM, 1TB HDD.\r\n"
				+ "4.	Installed Firewall �Sophos XG Firewall� for exam branch.\r\n" + " ", font5);
		paragraph45.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph42 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph42.setSize(12);
		 */

		Paragraph paragraph46 = new Paragraph("AY 2018-19\r\n" + "\r\n"
				+ "1.	Installed Firewall \"Sonicwall NSA 3600� for securing campus network.\r\n"
				+ "2.	Provided ICT Facilities in 09 class rooms\r\n"
				+ "3.	Established one more Computing centre with 100 systems each.\r\n"
				+ "4.	Increased number of computer systems in existing Computing centre from 48 to 100.\r\n"
				+ "5.	Anti-virus: Quick Heal Seqrite EPS antivirus software (500 Users) has been installed for all the systems with Windows OS.\r\n"
				+ "6.	Procured 216 Acer computers of core i3 with 4GB RAM, 1TB HDD and 60 Lenovo Computers of core i3 with 4GB RAM, 1TB HDD.\r\n"
				+ "7.	Internet facility was upgraded from 132 Mbps to 210 Mbps with two distinct service providers.\r\n"
				+ "\r\n"

				+ " ", font5);
		paragraph46.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph43 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph43.setSize(12);
		 */

		Paragraph paragraph47 = new Paragraph("AY 2017-18\r\n" + "\r\n"
				+ "1.	Procured 72 Acer computers of core i5 with 4GB RAM and 1TB HDD, 151 Acer computers of core i3 with 4GB RAM, 1 TB HDD and 170 Assembled computers of Dual Core with 4GB RAM, 1 TB HDD.\r\n"
				+ "2.	Internet facility was upgraded from 48 Mbps to 132 Mbps with two distinct service providers.\r\n"

				+ ":", font5);
		paragraph47.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph44 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph44.setSize(12);
		 */

		Paragraph paragraph48 = new Paragraph("AY 2016-17\r\n" + "\r\n"
				+ "1.	Intra-net connectivity is provided on the campus with 20 Gbps fibre-optic cable over and above the Reliance Jio campus wi-fi for daily usage of 1GB/User.\r\n"
				+ "2.	Established IBM Software Lab for Emerging Technologies in collaboration with IBM.\r\n"
				+ "3.	Procured 302 Assembled computers of Dual Core with 2GB RAM, 500GB HDD.\r\n" + "", font5);
		paragraph48.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph45 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph45.setSize(12);
		 */

		Paragraph paragraph49 = new Paragraph("Year wise Allocated Budget for IT facilities:" + "", font3);
		paragraph49.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph38criteria4);
		document.add(paragraph39criteria4);
		document.add(paragraph40);
		document.add(paragraph41);
		document.add(paragraph42);
		document.add(paragraph43criteria4);
		document.add(paragraph44);
		document.add(paragraph45);
		document.add(paragraph46);
		document.add(paragraph47);
		document.add(paragraph48);
		document.add(paragraph49);

		// Creating a table of 3 columns

		PdfPTable table16criteria4 = new PdfPTable(5);
		PdfPTable table17criteria4 = new PdfPTable(2);

		// Setting width of table, its columns and spacing
		table16criteria4.setWidthPercentage(100);
		table17criteria4.setWidthPercentage(100);

		PdfPCell cell0081 = new PdfPCell(new Paragraph("Budget allocated for IT facilities"));
		PdfPCell cell0082 = new PdfPCell(new Paragraph("2016-17"));
		PdfPCell cell0083 = new PdfPCell(new Paragraph("2017-2018"));
		PdfPCell cell0084 = new PdfPCell(new Paragraph("2018-2019"));
		PdfPCell cell0085 = new PdfPCell(new Paragraph("2019-2020"));
		PdfPCell cell0086 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell0087 = new PdfPCell(new Paragraph("50,45,018"));
		PdfPCell cell0088 = new PdfPCell(new Paragraph("96,97,574 "));
		PdfPCell cell0089 = new PdfPCell(new Paragraph("79,75,787"));
		PdfPCell cell0090 = new PdfPCell(new Paragraph("89,95,799 "));

		table16criteria4.addCell(cell0081);
		table16criteria4.addCell(cell0082);
		table16criteria4.addCell(cell0083);
		table16criteria4.addCell(cell0084);
		table16criteria4.addCell(cell0085);
		table16criteria4.addCell(cell0086);
		table16criteria4.addCell(cell0087);
		table16criteria4.addCell(cell0088);
		table16criteria4.addCell(cell0089);
		table16criteria4.addCell(cell0090);

		table16criteria4.setSpacingBefore(20f);
		table16criteria4.setSpacingAfter(20f);

		document.add(table16criteria4);

		PdfPCell cell0091 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
		PdfPCell cell0092 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell0093 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
		PdfPCell cell0094 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(16).getCriteria4FilePath() : ""));
		PdfPCell cell0095 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
		PdfPCell cell0096 = new PdfPCell(new Paragraph(" "));

		table17criteria4.addCell(cell0091);
		table17criteria4.addCell(cell0092);
		table17criteria4.addCell(cell0093);
		table17criteria4.addCell(cell0094);
		table17criteria4.addCell(cell0095);
		table17criteria4.addCell(cell0096);

		PdfPCell cell431criteria4 = new PdfPCell(new Paragraph(
				"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria43Ql().get(0).getResponse431()
								: "")));
		table17criteria4.addCell(cell431criteria4);
		table17criteria4.addCell(table16criteria4);
		table17criteria4.addCell(table16criteria4);
		document.add(table17criteria4);

		// Creating a table of 3 columns
		PdfPTable table18criteria4 = new PdfPTable(2);
		PdfPTable table19criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table18criteria4.setWidthPercentage(100);
		table19criteria4.setWidthPercentage(100);

		PdfPCell cell0097 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
		PdfPCell cell0098 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell0099 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
		PdfPCell cell00100 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(17).getCriteria4FilePath() : ""));
		PdfPCell cell00101 = new PdfPCell(new Paragraph("Student - computer ratio\r\n\r\n\r\n"));
		PdfPCell cell00102 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(18).getCriteria4FilePath() : ""));

		table18criteria4.addCell(cell0097);
		table18criteria4.addCell(cell0098);
		table18criteria4.addCell(cell0099);
		table18criteria4.addCell(cell00100);
		table18criteria4.addCell(cell00101);
		table18criteria4.addCell(cell00102);

		table19criteria4.addCell("4.3.2 Student - Computer ratio (Data for the latest completed academic year)\r\n"
				+ "\r\n\r\n" + "Response:"
				+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse432()
						: ""));
		// table19criteria4.addCell(criteria4List.get(0).getResponseValue432());

		table19criteria4.addCell(table18criteria4);

		table19criteria4.setSpacingBefore(20f);
		table19criteria4.setSpacingAfter(20f);

		document.add(table19criteria4);

		// Creating a table of 3 columns

		PdfPTable table20criteria4 = new PdfPTable(2);
		PdfPTable table21criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table20criteria4.setWidthPercentage(100);
		table21criteria4.setWidthPercentage(100);

		PdfPCell cell00103 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
		PdfPCell cell00104 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell00105 = new PdfPCell(
				new Paragraph("Details of available bandwidth of internet connection in the Institution\r\n\r\n\r\n"));
		PdfPCell cell00106 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(19).getCriteria4FilePath() : ""));

		table20criteria4.addCell(cell00103);
		table20criteria4.addCell(cell00104);
		table20criteria4.addCell(cell00105);
		table20criteria4.addCell(cell00106);

		table21criteria4.addCell("4.3.3 Bandwidth of internet connection in the Institution.\r\n" + "\r\n" + "Response:"
				+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse433()
						: ""));

		// table21criteria4.addCell(criteria4List.get(0).getResponseValue433());

		table21criteria4.addCell(table20criteria4);
		document.add(table21criteria4);

		// Creating a table of 3 columns

		PdfPTable table22criteria4 = new PdfPTable(2);
		PdfPTable table23criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table22criteria4.setWidthPercentage(100);
		table23criteria4.setWidthPercentage(100);

		PdfPCell cell00107 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
		PdfPCell cell00108 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell00109 = new PdfPCell(new Paragraph("Upload Additional information\r\n\r\n\r\n"));
		PdfPCell cell00110 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(20).getCriteria4FilePath() : ""));
		PdfPCell cell00111 = new PdfPCell(new Paragraph(" Institutional data in prescribed format\r\n\r\n\r\n"));
		PdfPCell cell00112 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(21).getCriteria4FilePath() : ""));

		table22criteria4.addCell(cell00107);
		table22criteria4.addCell(cell00108);
		table22criteria4.addCell(cell00109);
		table22criteria4.addCell(cell00110);
		table22criteria4.addCell(cell00111);
		table22criteria4.addCell(cell00112);

		table23criteria4.addCell("4.3.4	Institution has the following Facilities for e-content development\r\n" + "\r\n"
				+ "1.	Media centre\r\n" + "2.	Audio visual centre\r\n" + "3.	Lecture Capturing System(LCS)\r\n"
				+ "4.	Mixing equipments and softwares for editing\r\n" + "\r\n" + "\r\n" + "\r\n" + "Response: "
				+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse434()
						: ""));

		// table23criteria4.addCell(criteria4List.get(0).getResponseValue434());
		table23criteria4.addCell(table22criteria4);

		table23criteria4.setSpacingBefore(20f);
		table23criteria4.setSpacingAfter(20f);

		document.add(table23criteria4);

		/*
		 * Font fontParagraph46 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph46.setSize(12);
		 */

		Paragraph paragraph50 = new Paragraph("4.4 Maintenance of Campus Infrastructure\r\n\r\n\r\n" + "", font2);
		paragraph50.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph50);

		// Creating a table of 3 columns

		PdfPTable table24criteria4 = new PdfPTable(5);
		PdfPTable table25criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
	

		table25criteria4.addCell(
				"4.4.1 Average percentage expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component during the last five years\r\n\r\n"
						+ " Response: "
						+ (criteria4Record != null
								? criteria4Record.getCriteria44Ql().get(0).getResponse441()
								: ""));

		// table25criteria4.addCell(criteria4List.get(0).getResponseValue441());

		table25criteria4.addCell(
				"4.4.1.1 Expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component year wise during the last five years (INR in lakhs)\r\n\r\n");

		// table25.addCell(table24);

		table25criteria4.setSpacingBefore(20f);
		table25criteria4.setSpacingAfter(20f);

		document.add(table25criteria4);

		if (criteria4Record != null) {

			Table table4411 = new Table(criteria4Record.getYearTable4411().size(), 2);

			table4411.setPadding(10);
			table4411.setWidth(100f);

			for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
				table4411.addCell(criteria4Record.getYearTable4411().get(i).getInput4411y());

			}
			for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
				table4411.addCell(criteria4Record.getYearTable4411().get(i).getInput4411v());

			}

			document.add(table4411);

		}

		PdfPTable table26criteria4 = new PdfPTable(2);
		table26criteria4.setWidthPercentage(100);

		PdfPCell cell00123 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
		PdfPCell cell00124 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell00125 = new PdfPCell(new Paragraph(
				"Details about assigned budget and expenditure on physical facilities and academic facilities\r\n\r\n\r\n "));
		PdfPCell cell00126 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(22).getCriteria4FilePath() : ""));
		PdfPCell cell00127 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n\r\n "));
		PdfPCell cell00128 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(23).getCriteria4FilePath() : ""));

		table26criteria4.addCell(cell00123);
		table26criteria4.addCell(cell00124);
		table26criteria4.addCell(cell00125);
		table26criteria4.addCell(cell00126);
		table26criteria4.addCell(cell00127);
		table26criteria4.addCell(cell00128);

		document.add(table26criteria4);

		/*
		 * Font fontParagraph47 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph47.setSize(12);
		 */

		Paragraph paragraph51 = new Paragraph(
				"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\r\n"
						+ "\r\n" + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria44Ql().get(0).getResponse442()
								: ""),
				font2);

		PdfPTable table442criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table442criteria4.setWidthPercentage(100);

		table442criteria4.addCell(
				"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\\r\\n\"\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria44Ql().get(0).getResponse442()
								: ""));
		// table442criteria4.addCell(criteria4List.get(0).getResponseValue442());
		document.add(table442criteria4);

		table442criteria4.setSpacingBefore(20f);
		table442criteria4.setSpacingAfter(20f);

		paragraph51.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph48 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph48.setSize(12);
		 */

		Paragraph paragraph52 = new Paragraph(
				" The Maintenance Cell of the college ensures proper functioning of all civil, electrical, water, sewage, environment, and other facilities through frequent inspections and need-based maintenance works. A central complaint register is maintained, and the maintenance cell attends to those complaints on a priority basis. A vast majority of minor and major repairs are carried out internally, while some major repairs are outsourced. The maintenance cell is headed by the Registrar/Dean-Administration. The other members of the cell include Administrative Maintenance in-charge, Head of EEE department, and two senior faculty members, one each from Civil Engineering and Mechanical Engineering departments. The members of the cell meet based on the need and review the requirements to chalk out further action to be taken. The cell also arranges to conduct energy audit. Staff belonging to the maintenance cell perform routine cleaning of the water tanks, water coolers, filters, etc. as per schedule. Preventive maintenance of the equipment is a regular practice in all laboratories apart from breakdown maintenance. Gardeners and janitors conduct regular cleaning of the campus premises and restrooms twice a day.\r\n"
						+ "\r\n"
						+ "The regular maintenance of all the seminar halls of the institution, Open air auditorium, Portico of Block-2, open air grounds, playground etc. are supervised by the Administrative Officer. The Faculty/students put a letter in the prescribed format (mentioning the date and time of requirement) seeking the allocation of the required physical facility for the respective events to be organized. After the allocation as per the availability, such information is entered in a register kept with the Administrative officer.\r\n"
						+ "\r\n"
						+ "All OHP/LCD projectors in the institution, furniture available in the classroom, faculty/staff rooms are regularly monitored on a fortnightly basis for maintenance.\r\n"
						+ "\r\n"
						+ "Each laboratory maintains a stock register for detailing the proper lab records. The lab stock register holds\r\n"
						+ " \r\n"
						+ "the complete details of lab equipment, new arrivals, replacements of old equipment, maintenance details, license details etc. Each lab is associated with a qualified Technical Staff for maintenance of all lab equipment. Any major repair of equipment beyond the scope of technical staff is outsourced. Obsolete and irreparable equipment is weeded out on regular basis. A register for �Lab equipment Repair/ Maintenance� is kept in each lab to track the breakdown time of equipment and the maintenance details. A minimum of 20% to 30% of unutilized lab slots per week are allotted for regular maintenance works of the laboratories.\r\n"
						+ "\r\n"
						+ "The college has a central computing facility located in the library building, which is also used for browsing and accessing electronic content of learning resources.\r\n"
						+ "\r\n"
						+ "The institution has established a separate maintenance cell, responsible for the maintenance works of computers, Hardware and software installations/up-gradations, wi-fi and internet maintenance. The cell is chaired by a senior faculty from Computer Science Engineering department who supervises the supporting staff required for this purpose.\r\n"
						+ "",
				font5);
		paragraph52.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph51);
		document.add(paragraph52);

		PdfPTable table27criteria4 = new PdfPTable(2);
		table27criteria4.setWidthPercentage(100);

		PdfPCell cell00129 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
		PdfPCell cell00130 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell00131 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
		PdfPCell cell00132 = new PdfPCell(new Paragraph(" "));

		table27criteria4.addCell(cell00129);
		table27criteria4.addCell(cell00130);
		table27criteria4.addCell(cell00131);
		table27criteria4.addCell(cell00132);

		table27criteria4.setSpacingBefore(20f);
		table27criteria4.setSpacingAfter(20f);

		document.add(table27criteria4);

		///////////////////////////////////////////////////////////////////////////////////////
		// Criteria 4 ends here....
		/////////////////////////////////////////////////////////////////////////////////////

	}

	public void Criteria5(Document document) {

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

		Paragraph paragraph0 = new Paragraph("Criterion 5 - Student Support and Progression\r\n\r\n", font1);
		paragraph0.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph02 = new Paragraph("5.1 Student Support\r\n\r\n", font1);
		paragraph02.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph0);
		document.add(paragraph02);

		PdfPTable table01criteria5 = new PdfPTable(2);
		PdfPTable table011 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table01criteria5.setWidthPercentage(100);
		table011.setWidthPercentage(100);

		PdfPCell cell1001 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
		PdfPCell cell1002 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell1003 = new PdfPCell(
				new Paragraph("upload self attested letter with the list of students sanctioned scholarships\r\n\r\n\r\n"));
		PdfPCell cell1004 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : ""));
		PdfPCell cell1005 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
		PdfPCell cell1006 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(1).getCriteria5FilePath() : ""));
		PdfPCell cell1007 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
		PdfPCell cell1008 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(2).getCriteria5FilePath() : ""));
		PdfPCell cell1009 = new PdfPCell(new Paragraph(
				"Average percentage of students benefited by scholarships and freeships provided by the Government during the last five years\r\n\r\n\r\n"));
		PdfPCell cell10010 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(3).getCriteria5FilePath() : ""));

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

		PdfPCell cell0001 = new PdfPCell(new Paragraph(
				"5.1.1 Average percentage of students benefited by scholarships and freeships provided by the Government during last five years\r\n"
						+ "\r\n\r\n" + "Response: "
						+ (criteria5Record != null
								? criteria5Record.getCriteria51Qn().get(0).getResponse511()
								: ""),
				font3));
		PdfPCell cell0002 = new PdfPCell(new Paragraph(
				"5.1.1.1 Number of students benefited by scholarships and free ships provided by the institution, Government and non-government bodies, industries, individuals, philanthropists during the last five years (other than students receiving scholarships under the government schemes for reserved categories)\r\n\r\n",
				font3));
		table011.addCell(cell0001);
		table011.addCell(cell0002);

		table011.addCell(table01criteria5);

		table011.setSpacingBefore(20f);
		table011.setSpacingAfter(20f);

		document.add(table011);

		Table table5111 = new Table(criteria5Record.getYearTable5111().size(), 2);

		table5111.setPadding(10);
		table5111.setWidth(100f);

		for (int i = 0; i < criteria5Record.getYearTable5111().size(); i++) {
			table5111.addCell(criteria5Record.getYearTable5111().get(i).getInput5111y());

		}
		for (int i = 0; i < criteria5Record.getYearTable5111().size(); i++) {
			table5111.addCell(criteria5Record.getYearTable5111().get(i).getInput5111v());

		}

		document.add(table5111);

		// Creating table
		PdfPTable table02criteria5 = new PdfPTable(2);
		PdfPTable table021 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table02criteria5.setWidthPercentage(100);
		table021.setWidthPercentage(100);

		PdfPCell cell00001 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
		PdfPCell cell00002 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell00003 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
		PdfPCell cell00004 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(4).getCriteria5FilePath() : ""));
		PdfPCell cell00005 = new PdfPCell(new Paragraph(
				"Number of students benefited by scholarships and freeships besides government schemes in last 5 years\r\n\r\n\r\n"));
		PdfPCell cell00006 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(5).getCriteria5FilePath() : ""));
		PdfPCell cell00007 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
		PdfPCell cell00008 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(6).getCriteria5FilePath() : ""));

		table02criteria5.addCell(cell00001);
		table02criteria5.addCell(cell00002);
		table02criteria5.addCell(cell00003);
		table02criteria5.addCell(cell00004);
		table02criteria5.addCell(cell00005);
		table02criteria5.addCell(cell00006);
		table02criteria5.addCell(cell00007);
		table02criteria5.addCell(cell00008);

		PdfPCell cell0003 = new PdfPCell(new Paragraph(
				"5.1.2 Average percentage of students benefited by scholarships, freeships, etc. provided by the institution and non-government agencies during the last five years\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria5Record != null
								? criteria5Record.getCriteria51Qn().get(0).getResponse512()
								: ""),
				font3));
		PdfPCell cell0004 = new PdfPCell(new Paragraph(
				"5.1.2.1 Number of students benefited by scholarships and free ships provided by the institution, Government and non-government bodies, industries, individuals, philanthropists during the last five years (other than students receiving scholarships under the government schemes for reserved categories)",
				font3));

		table021.addCell(cell0003);
		table021.addCell(cell0004);

		table021.addCell(table02criteria5);

		table021.setSpacingBefore(20f);
		table021.setSpacingAfter(20f);

		document.add(table021);

		Table table5121 = new Table(criteria5Record.getYearTable5121().size(), 2);

		table5121.setPadding(10);
		table5121.setWidth(100f);

		for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
			table5121.addCell(criteria5Record.getYearTable5121().get(i).getInput5121y());

		}
		for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
			table5121.addCell(criteria5Record.getYearTable5121().get(i).getInput5121v());

		}

		document.add(table5121);

		PdfPTable table03criteria5 = new PdfPTable(2);
		PdfPTable table31criteria5 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table03criteria5.setWidthPercentage(100);
		table31criteria5.setWidthPercentage(100);

		PdfPCell cell00019 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
		PdfPCell cell00020 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell00021 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
		PdfPCell cell00022 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(7).getCriteria5FilePath() : ""));
		PdfPCell cell00023 = new PdfPCell(new Paragraph(
				"Number of students benefited by scholarships and freeships besides government schemes in last 5 years\r\n\r\n\r\n"));
		PdfPCell cell00024 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(8).getCriteria5FilePath() : ""));
		PdfPCell cell00025 = new PdfPCell(new Paragraph("Institutional data in prescribed format"));
		PdfPCell cell00026 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(9).getCriteria5FilePath() : ""));

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
						+ "\r\n\r\n" + "Response: "
						+ (criteria5Record != null
								? criteria5Record.getCriteria51Qn().get(0).getResponse513()
								: ""),
				font3));
		table31criteria5.addCell(cell0005);

		table31criteria5.addCell(table03criteria5);

		table31criteria5.setSpacingBefore(20f);
		table31criteria5.setSpacingAfter(20f);

		document.add(table31criteria5);

		PdfPTable table04criteria5 = new PdfPTable(2);
		PdfPTable table41criteria5 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table04criteria5.setWidthPercentage(100);
		table41criteria5.setWidthPercentage(100);

		PdfPCell cell00027 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
		PdfPCell cell00028 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell00029 = new PdfPCell(new Paragraph(
				"Number of students benefited by guidance for competitive examinations and career counselling during the last five years\r\n\r\n\r\n"));
		PdfPCell cell00030 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(10).getCriteria5FilePath() : ""));
		PdfPCell cell00031 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell00032 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(11).getCriteria5FilePath() : ""));

		table04criteria5.addCell(cell00027);
		table04criteria5.addCell(cell00028);
		table04criteria5.addCell(cell00029);
		table04criteria5.addCell(cell00030);
		table04criteria5.addCell(cell00031);
		table04criteria5.addCell(cell00032);

		PdfPCell cell0006 = new PdfPCell(new Paragraph(
				"5.1.4 Average percentage of students benefited by career counseling and guidance for competitive examinations as offered by the Institution during the last five years.\r\n"
						+ "\r\n\r\n" + "Response: "
						+ (criteria5Record != null
								? criteria5Record.getCriteria51Qn().get(0).getResponse514()
								: ""),
				font3));

		PdfPCell cell0007 = new PdfPCell(new Paragraph(
				"5.1.4.1 Number of students benefitted by guidance for competitive examinations and career counselling offered by the institution year wise during last five years",
				font3));

		table41criteria5.addCell(cell0006);
		table41criteria5.addCell(cell0007);

		table41criteria5.addCell(table04criteria5);

		table41criteria5.setSpacingBefore(20f);
		table41criteria5.setSpacingAfter(20f);

		document.add(table41criteria5);

		Table table5141 = new Table(criteria5Record.getYearTable5141().size(), 2);

		table5141.setPadding(10);
		table5141.setWidth(100f);

		for (int i = 0; i < criteria5Record.getYearTable5141().size(); i++) {
			table5141.addCell(criteria5Record.getYearTable5141().get(i).getInput5141y());

		}
		for (int i = 0; i < criteria5Record.getYearTable5141().size(); i++) {
			table5141.addCell(criteria5Record.getYearTable5141().get(i).getInput5141v());

		}

		document.add(table5141);

		PdfPTable table05criteria5 = new PdfPTable(2);
		PdfPTable table051criteria5 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table05criteria5.setWidthPercentage(100);
		table051criteria5.setWidthPercentage(100);

		PdfPCell cell00035 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
		PdfPCell cell00036 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell00037 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
		PdfPCell cell00038 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(12).getCriteria5FilePath() : ""));
		PdfPCell cell00039 = new PdfPCell(new Paragraph(
				"Minutes of the meetings of student redressal committee, prevention of sexual harassment committee and Anti Ragging committee\r\n\r\n\r\n"));
		PdfPCell cell00040 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(13).getCriteria5FilePath() : ""));
		PdfPCell cell00041 = new PdfPCell(
				new Paragraph("Details of student grievances including sexual harassment and ragging cases"));
		PdfPCell cell00042 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(14).getCriteria5FilePath() : ""));

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
						+ "4.	Timely redressal of the grievances through appropriate committees\r\n" + "\r\n"
						+ "Response: "
						+ (criteria5Record != null
								? criteria5Record.getCriteria51Qn().get(0).getResponse515()
								: ""),
				font3));

		table051criteria5.addCell(cell0008);

		table051criteria5.addCell(table05criteria5);

		table051criteria5.setSpacingBefore(20f);
		table051criteria5.setSpacingAfter(20f);

		document.add(table051criteria5);

		Paragraph paragraph03 = new Paragraph("5.2	Student Progression\r\n\r\n\r\n", font2);
		paragraph03.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph03);

		PdfPTable table06criteria5 = new PdfPTable(2);
		PdfPTable table061 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table06criteria5.setWidthPercentage(100);
		table061.setWidthPercentage(100);

		PdfPCell cell00043 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
		PdfPCell cell00044 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell00045 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
		PdfPCell cell00046 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(15).getCriteria5FilePath() : ""));
		PdfPCell cell00047 = new PdfPCell(new Paragraph("Self attested list of students placed\r\n\r\n\r\n"));
		PdfPCell cell00048 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(16).getCriteria5FilePath() : ""));
		PdfPCell cell00049 = new PdfPCell(new Paragraph("Details of student placement during the last five years\r\n\r\n\r\n"));
		PdfPCell cell00050 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(17).getCriteria5FilePath() : ""));

		table06criteria5.addCell(cell00043);
		table06criteria5.addCell(cell00044);
		table06criteria5.addCell(cell00045);
		table06criteria5.addCell(cell00046);
		table06criteria5.addCell(cell00047);
		table06criteria5.addCell(cell00048);
		table06criteria5.addCell(cell00049);
		table06criteria5.addCell(cell00050);

		PdfPCell cell00009 = new PdfPCell(new Paragraph(
				"5.2.1 Average percentage of placement of outgoing students during the last five years\r\n" + "\r\n\r\n"
						+ "Response: "
						+ (criteria5Record != null
								? criteria5Record.getCriteria52Qn().get(0).getResponse521()
								: ""),
				font3));
		PdfPCell cell00010 = new PdfPCell(new Paragraph(
				"5.2.1.1 Number of outgoing students placed year - wise during the last five years.", font3));

		table061.addCell(cell00009);
		table061.addCell(cell00010);

		table061.addCell(table06criteria5);

		table061.setSpacingBefore(20f);
		table061.setSpacingAfter(20f);

		document.add(table061);

		Table table5211 = new Table(criteria5Record.getYearTable5211().size(), 2);

		table5211.setPadding(10);
		table5211.setWidth(100f);

		for (int i = 0; i < criteria5Record.getYearTable5211().size(); i++) {
			table5211.addCell(criteria5Record.getYearTable5211().get(i).getInput5211y());

		}
		for (int i = 0; i < criteria5Record.getYearTable5211().size(); i++) {
			table5211.addCell(criteria5Record.getYearTable5211().get(i).getInput5211v());

		}

		document.add(table5211);

		PdfPTable table07criteria5 = new PdfPTable(2);
		PdfPTable table71criteria5 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table07criteria5.setWidthPercentage(100);
		table71criteria5.setWidthPercentage(100);

		PdfPCell cell51criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
		PdfPCell cell52criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell53criteria5 = new PdfPCell(new Paragraph("Upload supporting data for student/alumni\r\n\r\n\r\n"));
		PdfPCell cell54criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(18).getCriteria5FilePath() : ""));
		PdfPCell cell55criteria5 = new PdfPCell(new Paragraph("Details of student progression to higher education\r\n\r\n\r\n"));
		PdfPCell cell56criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(19).getCriteria5FilePath() : ""));
		PdfPCell cell57criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell58criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(20).getCriteria5FilePath() : ""));

		table07criteria5.addCell(cell51criteria5);
		table07criteria5.addCell(cell52criteria5);
		table07criteria5.addCell(cell53criteria5);
		table07criteria5.addCell(cell54criteria5);
		table07criteria5.addCell(cell55criteria5);
		table07criteria5.addCell(cell56criteria5);
		table07criteria5.addCell(cell57criteria5);
		table07criteria5.addCell(cell58criteria5);

		PdfPCell cell0111 = new PdfPCell(new Paragraph(
				"5.2.2 Percentage of student progression to higher education (previous graduating batch).\r\n" + "\r\n"
						+ "Response:"
						+ (criteria5Record != null
								? criteria5Record.getCriteria52Qn().get(0).getResponse522()
								: ""),
				font3));

		PdfPCell cell0112 = new PdfPCell(new Paragraph(
				"5.2.2.1 Number of outgoing student progressing to higher education.\r\n" + "\r\n" + "Response: "
						+ (criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getInput522t1()
								: ""),
				font3));

		table71criteria5.addCell(cell0111);
		table71criteria5.addCell(cell0112);

		table71criteria5.addCell(table07criteria5);

		table71criteria5.setSpacingBefore(20f);
		table71criteria5.setSpacingAfter(20f);

		document.add(table71criteria5);

		PdfPTable table08criteria5 = new PdfPTable(2);
		PdfPTable table81criteria5 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table08criteria5.setWidthPercentage(100);
		table81criteria5.setWidthPercentage(100);

		PdfPCell cell59criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
		PdfPCell cell60criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell61criteria5 = new PdfPCell(new Paragraph("Upload supporting data for student/alumni\r\n\r\n\r\n"));
		PdfPCell cell62criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(21).getCriteria5FilePath() : ""));
		PdfPCell cell63criteria5 = new PdfPCell(new Paragraph(
				"Number of students qualifying in state/ national/ international level examinations during the last five years\r\n\r\n\r\n"));
		PdfPCell cell64criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(22).getCriteria5FilePath() : ""));
		PdfPCell cell65criteria5 = new PdfPCell(new Paragraph("Any additional information"));
		PdfPCell cell66criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(23).getCriteria5FilePath() : ""));

		table08criteria5.addCell(cell59criteria5);
		table08criteria5.addCell(cell60criteria5);
		table08criteria5.addCell(cell61criteria5);
		table08criteria5.addCell(cell62criteria5);
		table08criteria5.addCell(cell63criteria5);
		table08criteria5.addCell(cell64criteria5);
		table08criteria5.addCell(cell65criteria5);
		table08criteria5.addCell(cell66criteria5);

		PdfPCell cell0113 = new PdfPCell(new Paragraph(
				"5.2.3 Average percentage of students qualifying in state/national/ international level examinations during the last five years (eg: IIT-JAM/CLAT/ NET/SLET/GATE/ GMAT/CAT/GRE/ TOEFL/ Civil Services/State government examinations, etc.)\r\n"
						+ "\r\n" + "Response:"
						+ (criteria5Record != null
								? criteria5Record.getCriteria52Qn().get(0).getResponse523()
								: ""),
				font3));
		PdfPCell cell0114 = new PdfPCell(new Paragraph(
				"5.2.3.1 Number of students qualifying in state/ national/ international level examinations (eg: IIT/JAM/ NET/ SLET/ GATE/ GMAT/CAT/GRE/ TOEFL/ Civil Services/ State government examinations, etc.)) year-wise during last five years",
				font3));

		PdfPCell cell0115 = new PdfPCell(new Paragraph(
				"5.2.3.2 Number of students appearing in state/ national/ international level examinations (eg: IIT/JAM/ NET / SLET/ GATE/ GMAT/CAT,GRE/ TOEFL/ Civil Services/ State government examinations) year-wise during last five years"
						+ "",
				font3));

		table81criteria5.addCell(cell0113);
		table81criteria5.addCell(cell0114);
		table81criteria5.addCell(cell0115);

		table81criteria5.addCell(table08criteria5);

		table81criteria5.setSpacingBefore(20f);
		table81criteria5.setSpacingAfter(20f);

		document.add(table81criteria5);

		Table table5231 = new Table(criteria5Record.getYearTable5231().size(), 2);

		table5231.setPadding(10);
		table5231.setWidth(100f);

		for (int i = 0; i < criteria5Record.getYearTable5231().size(); i++) {
			table5231.addCell(criteria5Record.getYearTable5231().get(i).getInput5231y());

		}
		for (int i = 0; i < criteria5Record.getYearTable5231().size(); i++) {
			table5231.addCell(criteria5Record.getYearTable5231().get(i).getInput5231v());

		}

		document.add(table5231);

		Table table5232 = new Table(criteria5Record.getYearTable5232().size(), 2);

		table5232.setPadding(10);
		table5232.setWidth(100f);

		for (int i = 0; i < criteria5Record.getYearTable5232().size(); i++) {
			table5232.addCell(criteria5Record.getYearTable5232().get(i).getInput5232y());

		}
		for (int i = 0; i < criteria5Record.getYearTable5232().size(); i++) {
			table5232.addCell(criteria5Record.getYearTable5232().get(i).getInput5232v());

		}

		document.add(table5232);

		Paragraph paragraph04 = new Paragraph("5.3 Student Participation and Activities", font2);
		paragraph04.setAlignment(Paragraph.ALIGN_LEFT);

		document.add(paragraph04);

		PdfPTable table09criteria5 = new PdfPTable(2);
		PdfPTable table91criteria5 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table09criteria5.setWidthPercentage(100);
		table91criteria5.setWidthPercentage(100);

		PdfPCell cell67criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
		PdfPCell cell68criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell69criteria5 = new PdfPCell(new Paragraph(
				"Number of awards/medals for outstanding performance in sports/ cultural activities at inter- university / state / national / international level during the last five years\r\n\r\n\r\n"));
		PdfPCell cell70criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(24).getCriteria5FilePath() : ""));
		PdfPCell cell71criteria5 = new PdfPCell(new Paragraph("e-copies of award letters and certificates\r\n\r\n\r\n"));
		PdfPCell cell72criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(25).getCriteria5FilePath() : ""));
		PdfPCell cell73criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell74criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(26).getCriteria5FilePath() : ""));

		table09criteria5.addCell(cell67criteria5);
		table09criteria5.addCell(cell68criteria5);
		table09criteria5.addCell(cell69criteria5);
		table09criteria5.addCell(cell70criteria5);
		table09criteria5.addCell(cell71criteria5);
		table09criteria5.addCell(cell72criteria5);
		table09criteria5.addCell(cell73criteria5);
		table09criteria5.addCell(cell74criteria5);

		PdfPCell cell0116 = new PdfPCell(new Paragraph(
				"5.3.1 Number of awards/medals won by students for outstanding performance in sports/cultural activities at inter-university/state/national / international level (award for a team event should be counted as one) during the last five years.\r\n"
						+ "Response:"
						+ (criteria5Record != null
								? criteria5Record.getCriteria53Qn().get(0).getResponse531()
								: ""),
				font3));
		PdfPCell cell0117 = new PdfPCell(new Paragraph(
				"5.3.1.1 Number of awards/medals won by students for outstanding performance in sports / cultural activities at inter-university / state / national / international events (award for a team event should be counted as one) year - wise during the last five years.",
				font3));

		table91criteria5.addCell(cell0116);
		table91criteria5.addCell(cell0117);

		table91criteria5.addCell(table09criteria5);

		table91criteria5.setSpacingBefore(20f);
		table91criteria5.setSpacingAfter(20f);

		document.add(table91criteria5);

		Table table5311 = new Table(criteria5Record.getYearTable5311().size(), 2);

		table5311.setPadding(10);
		table5311.setWidth(100f);

		for (int i = 0; i < criteria5Record.getYearTable5311().size(); i++) {
			table5311.addCell(criteria5Record.getYearTable5311().get(i).getInput5311y());

		}
		for (int i = 0; i < criteria5Record.getYearTable5311().size(); i++) {
			table5311.addCell(criteria5Record.getYearTable5311().get(i).getInput5311v());

		}

		document.add(table5311);

		PdfPTable table010criteria5 = new PdfPTable(2);
		PdfPTable table101criteria5 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table010criteria5.setWidthPercentage(100);
		table101criteria5.setWidthPercentage(100);

		PdfPCell cell75criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
		PdfPCell cell76criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell77criteria5 = new PdfPCell(new Paragraph("Upload any additional information"));
		PdfPCell cell78criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(27).getCriteria5FilePath() : ""));
		PdfPCell cell79criteria5 = new PdfPCell(new Paragraph("Paste link for Additional Information\r\n\r\n\r\n"));
		PdfPCell cell80criteria5 = new PdfPCell(new Paragraph());

		table010criteria5.addCell(cell75criteria5);
		table010criteria5.addCell(cell76criteria5);
		table010criteria5.addCell(cell77criteria5);
		table010criteria5.addCell(cell78criteria5);
		table010criteria5.addCell(cell79criteria5);
		table010criteria5.addCell(cell80criteria5);

		PdfPCell cell0119 = new PdfPCell(new Paragraph(
				"5.3.2 Presence of an active Student Council & representation of students on academic & administrative bodies/committees of the institution\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria5Record != null
								? criteria5Record.getCriteria53Qn().get(0).getResponse532()
								: ""),
				font3));
		PdfPCell cell0120 = new PdfPCell(new Paragraph(
				"Mother Teresa has a Student Council (SC) comprising nine members. In addition, various bodies constituted by the College also has student representatives. The SC under aegis of Dean, students affairs plans and organizes various co-curricular and extra-curricular activities of the college in association with the college academic committee. Towards this end, various designated committees, viz., Organizing committee, Reception committee, Hospitality committee, Technical Events committee, Campaigning/Public Relations committee, Discipline committee, Cultural programmes committee, Sports committee, Prize Distribution committee, Magazine committee and such others are involved in the organization of Orientation programmes, Fresher�s Day, Alphamatica, Bhaswara, Vaisheshika, Vibgyor and Vibes. In each committee, at least two student representatives/volunteers attend meetings as and when called for. In addition, Mother Teresa celebrates regional, national and international commemoration days and festivals wherein, SC members are involved in the smooth conduct of the events.\r\n"
						+ "\r\n"
						+ "SC also contributes to the enhancement of the learning experiences of students through various clubs, namely, Literary, Science, Coding, Mathematical, Fine arts, Photography, Solar, Robotics, Environment, and Srujanastra. Each club is managed by students with the help of a faculty advisor. Various events pertaining to the concerned club are organized after the college hours on regular working days, as well as on Saturdays. In addition, it also facilitates organization of various technical activities through professional bodies namely, Computer Society of India (CSI), Institute of Electrical and Electronic Engineers (IEEE), Institute of Electronics and Telecommunication Engineering (IETE), Indian Society for Technical Education (ISTE) and Society for Automotive Engineering (SAE).\r\n"
						+ " \r\n"
						+ "The SC assists in organizing NSS activities of the college, which include conducting various health camps, distribution of school uniforms, books etc for needy children of nearby villages, distribution of various items at old-age homes, facilitating training for development of vocational skills in the people in nearby places, etc.\r\n"
						+ "\r\n"
						+ "In addition to the above-mentioned activities, the SC provides necessary help by reaching out appropriate tutorials to the students studying in nearby schools. It also organizes awareness programmes on health, education and environment. In association with NGOs, the SC facilitates conduct of cataract surgeries, organizes blood donation, health/dental camps and distributes medicines. As part of environment campaign, Handmade paper bags were made and distributed, making them aware of the hazards of plastic usage and its consequent disastrous effects on environment. Towards the promotion of Green revolution, every year, SC organizes tree plantation programmes in the nearby villages.\r\n"
						+ "\r\n"
						+ "Student representatives are also nominated on the anti-ragging committee, grievance redressal cell and women protection cell. The Entrepreneurship development cell also has SC members with a faculty advisor, to organize various events under the National Entrepreneurship Network (NEN).\r\n"
						+ "\r\n"
						+ "IQAC has a representative each from students and alumni. BoS of each department consists of Alumni members.\r\n"
						+ "Class Review Committees also have student representatives for obtaining feedback on the Teaching- Learning process.\r\n"
						+ "\r\n"
						+ "On the whole, the Students Council is a dynamic Body that contributes a great deal to the development of students and institution alike."
						+ "",
				font5));

		table101criteria5.addCell(cell0119);
		table101criteria5.addCell(cell0120);

		table101criteria5.addCell(table010criteria5);

		table101criteria5.setSpacingBefore(20f);
		table101criteria5.setSpacingAfter(20f);

		document.add(table101criteria5);

		PdfPTable table012criteria5 = new PdfPTable(2);
		PdfPTable table121criteria5 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table012criteria5.setWidthPercentage(100);
		table121criteria5.setWidthPercentage(100);

		PdfPCell cell81criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
		PdfPCell cell82criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell83criteria5 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
		PdfPCell cell84criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(28).getCriteria5FilePath() : ""));
		PdfPCell cell85criteria5 = new PdfPCell(new Paragraph("Report of the event\r\n\r\n\r\n"));
		PdfPCell cell86criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(29).getCriteria5FilePath() : ""));
		PdfPCell cell87criteria5 = new PdfPCell(
				new Paragraph("Number of sports and cultural events / competitions organised per year\r\n\r\n\r\n"));
		PdfPCell cell88criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(30).getCriteria5FilePath() : ""));

		table012criteria5.addCell(cell81criteria5);
		table012criteria5.addCell(cell82criteria5);
		table012criteria5.addCell(cell83criteria5);
		table012criteria5.addCell(cell84criteria5);
		table012criteria5.addCell(cell85criteria5);
		table012criteria5.addCell(cell86criteria5);
		table012criteria5.addCell(cell87criteria5);
		table012criteria5.addCell(cell88criteria5);

		PdfPCell cell0121 = new PdfPCell(new Paragraph(
				"5.3.3 Average number of sports and cultural events / competitions organised by the institution per year\r\n"
						+ "\r\n\r\n" + "Response: "
						+ (criteria5Record != null
								? criteria5Record.getCriteria53Qn().get(0).getResponse533()
								: ""),
				font3));
		PdfPCell cell0122 = new PdfPCell(new Paragraph(
				"5.3.3.1 Number of sports and cultural events / competitions organised by the institution year - wise during the last five years.",
				font3));

		table121criteria5.addCell(cell0121);
		table121criteria5.addCell(cell0122);

		table121criteria5.addCell(table012criteria5);

		table121criteria5.setSpacingBefore(20f);
		table121criteria5.setSpacingAfter(20f);

		document.add(table121criteria5);

		Table table5331 = new Table(criteria5Record.getYearTable5331().size(), 2);

		table5331.setPadding(10);
		table5331.setWidth(100f);

		for (int i = 0; i < criteria5Record.getYearTable5331().size(); i++) {
			table5311.addCell(criteria5Record.getYearTable5331().get(i).getInput5331y());

		}
		for (int i = 0; i < criteria5Record.getYearTable5331().size(); i++) {
			table5231.addCell(criteria5Record.getYearTable5331().get(i).getInput5331v());

		}

		document.add(table5331);

		Paragraph paragraph05 = new Paragraph("5.4 Alumni Engagement\r\n\r\n\r\n", font3);
		paragraph05.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph05);

		PdfPTable table013 = new PdfPTable(2);
		PdfPTable table131 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table013.setWidthPercentage(100);
		table131.setWidthPercentage(100);

		PdfPCell cell89criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
		PdfPCell cell90criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell91criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell92criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(31).getCriteria5FilePath() : ""));
		PdfPCell cell93criteria5 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell94criteria5 = new PdfPCell(new Paragraph());

		table013.addCell(cell89criteria5);
		table013.addCell(cell90criteria5);
		table013.addCell(cell91criteria5);
		table013.addCell(cell92criteria5);
		table013.addCell(cell93criteria5);
		table013.addCell(cell94criteria5);

		// PdfPCell cell023 = new PdfPCell(new Paragraph(" ",font2));
		// cell023.setAlignment(PdfCell.ALIGN_LEFT);

		PdfPCell cell0244 = new PdfPCell(new Paragraph(
				"5.4.1 The Alumni Association / Chapters (registered and functional) contributes significantly to the development of the institution through financial and other support services.\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria5Record != null
								? criteria5Record.getCriteria54Ql().get(0).getResponse541()
								: ""),
				font3));

		PdfPCell cell0255 = new PdfPCell(new Paragraph(
				"* Alumni members are made members of Boards of Studies of various departments. They contribute in the curriculum design. They examine the current curriculum and give suggestions vis-a-vis the industry-institution interface requirements.\r\n"
						+ "* They also give advice on the establishment of laboratories, which involve experiments using modern tools for improved employability of students.\r\n"
						+ "* Alumni members are invited to deliver technical talks and provide career guidance to the students. Alumni members help the students in establishing a network of support for their professional career progression, namely, higher education in India and abroad, internships and placements.\r\n"
						+ "* Alumni working in various industries connect the placement cell of the college to their respective industries, thereby, facilitate the college with opportunities for internships and placements of students.\r\n"
						+ "* In addition, they also connect the industry-institute interaction cell of the college, facilitating industrial visits, internships for students and resource persons for student development and faculty development programs.\r\n"
						+ "* Alumni promote the college at various fora, thereby serving as brand ambassadors of the college, by making the audience aware about the salient features of the college as well as important developments that have been taking place in the college over the years.\r\n"
						+ "* Alumni working in various R & D establishments connect the faculty of the college to their professional seniors, facilitating testing requirements of, as part of research carried out by faculty, and also in the preparation of research proposals being submitted by the college for various funding agencies.\r\n"
						+ "* Alumni, who pursued higher education abroad, help the students in securing admissions in the universities, where they have studied, through preparation of statement of purpose, research projects and funds available with various professors in universities. This information is extremely useful for students, since, they can approach the professors by explicitly mentioning their research interests, which may perhaps improve their chances of securing scholarship with full or partial tuition fee waiver.\r\n"
						+ "* Alumni of the college have donated certain resources/facilities to college for students use.\r\n"
						+ "",
				font5));

		table131.addCell(cell0244);
		table131.addCell(cell0255);

		table131.addCell(table013);

		table131.setSpacingBefore(20f);
		table131.setSpacingAfter(20f);

		document.add(table131);

		PdfPTable table014 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table014.setWidthPercentage(100);

		PdfPCell cell0266 = new PdfPCell(new Paragraph(
				"5.4.2 Alumni financial contribution during the last five years (in INR).\r\n" + "\r\n" + "Response:"
						+ (criteria5Record != null
								? criteria5Record.getCriteria54Ql().get(0).getResponse542()
								: ""),
				font3));
		table014.addCell(cell0266);

		table014.setSpacingBefore(20f);
		table014.setSpacingAfter(20f);

		document.add(table014);

		////////////////////////////////////////////////////////////////////////////////////
		// criteria 5 ends here
		/////////////////////////////////////////////////////////////////////////////

	}

//////////////////////////////////////////////
///////////////////// criteria 6 starts.....................
////////////////////////////////////////////////

	public void Criteria6(Document document) {

		/*
		 * com.lowagie.text.Font font0Title =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); font0Title.setSize(14);
		 */

		Paragraph paragraph1criteria6 = new Paragraph("Criterion 6 - Governance, Leadership and Management\r\n\r\n", font1);
		paragraph1criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph1criteria6);

		/*
		 * com.lowagie.text.Font fontTitle0 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle0.setSize(12);
		 */

		Paragraph paragraph2criteria6 = new Paragraph("6.1	Institutional Vision and Leadership\r\n\r\n", font2);
		paragraph2criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph2criteria6);
		Paragraph paragraph3criteria6 = new Paragraph(
				"6.1.1	The governance of the institution is reflective of an effective leadership in tune with the vision and mission of the Institution\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria61Ql().get(0).getResponse611()
								: ""),
				font3);
		paragraph3criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		com.lowagie.text.Font font0Title1 = FontFactory.getFont(FontFactory.HELVETICA);
		font0Title1.setSize(12);

		document.add(paragraph3criteria6);
		Paragraph paragraph4criteria6 = new Paragraph(
				"Mother Teresa has an Organizational Structure ensuring good governance, reflective of both, an Effective Leadership as also in tune with the Institutional Vision and Mission.\r\n"
						+ "\r\n" + "",
				font3);
		paragraph4criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph4criteria6);

		/*
		 * com.lowagie.text.Font font0Title2 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); font0Title2.setSize(12);
		 */
		Paragraph paragraph5criteria6 = new Paragraph("Vision:", font3);
		paragraph5criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph5criteria6);

		/*
		 * com.lowagie.text.Font font0Title3 =
		 * FontFactory.getFont(FontFactory.HELVETICA); font0Title3.setSize(12);
		 */
		Paragraph paragraph6criteria6 = new Paragraph(
				"Mother Teresa visualizes dissemination of knowledge and skills to students, who would eventually contribute to the wellbeing of the people of the nation and global community.\r\n"
						+ "\r\n"

						+ "",
				font3);
		paragraph6criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph6criteria6);

		/*
		 * com.lowagie.text.Font font0Title4 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); font0Title4.setSize(12);
		 */
		Paragraph paragraph7criteria6 = new Paragraph("Mission:" + "", font3);
		paragraph7criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph7criteria6);

		Paragraph paragraph8criteria6 = new Paragraph(
				"To impart adequate fundamental knowledge in all basic sciences and engineering, technical and inter-personal skills to students.\r\n"
						+ "To bring out creativity in students that would promote innovation, research and entrepreneurship"
						+ "\r\n"
						+ " To preserve and promote cultural heritage, humanistic and spiritual values promoting peace and harmony in society.\r\n"
						+ "\r\n" + "" + "",
				font5);
		paragraph8criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph8criteria6);

		Paragraph paragraph9criteria6 = new Paragraph(
				"College�s vision envisages that its graduating students contribute to national development and to the well- being of the global community.\r\n"
						+ "\r\n" + "\r\n"
						+ "The mission is to produce graduates possessing sound knowledge in basic sciences and technical skills, human values, a strong zeal to serve community, leading to realization of the institution�s vision, which calls for good governance, requiring establishment of structures and processes, designed to ensure accountability, transparency, responsiveness, equity, empowerment, and participation. In line with these, and as per UGC guidelines for autonomous colleges, following statutory committees, namely, Governing Body, Academic Council, Boards of Studies, Finance Committee, and Women Protection Cell (now renamed as Internal Compliance Committee), are constituted, ensuring participation of teachers in decision making, proper management of academic, financial, and administrative matters of the college.\r\n"
						+ "\r\n" + "" + "",
				font5);
		paragraph9criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph9criteria6);
		Paragraph paragraph10criteria6 = new Paragraph(
				"Further, several non-statutory committees comprising faculty, staff and students are also operative, assisting in the overall governance of the college. College promotes a culture of decentralized and participative management, extending down to Assistant Professor.\r\n"
						+ "\r\n" + "\r\n"
						+ "The Principal, as head of the institution is vested with overall responsibility to plan, organize, and control all activities, empowering Deans, Heads of Departments (HoDs), committees and in-charges of sections, carrying out institution�s day to day functions by delegating authority. Duties and responsibilities of Principal and other personnel are well laid and spelt out clearly in �Roles and Responsibilities� handbook of the institution.\r\n"
						+ "\r\n"
						+ "College organized its structure into departments/sections, and groups/divisions within departments. To\r\n"
						+ " \r\n"
						+ "assist Principal, Deans and HoDs, in the performance of their functions, many committees, namely, Planning and Monitoring Board, Grievance Redressal Committee, Admissions Committee, Examinations Committee, Student Welfare Committee, Anti-ragging committee, Library Committee, Extra-curricular activities Committee, Academic Audit Committee etc. are formed at institutional and department level, comprising faculty/staff at all levels. Committees are empowered to deliberate independently, investigate, and recommend actions on various issues, referred to them.\r\n"
						+ "\r\n" + "\r\n"
						+ "Institution�s perspective (Strategic) plan is developed by the Planning and Monitoring Board, in consultation with the Governing Body. Strategic plan is aimed at achieving short, medium and long-term goals of the college, aligning with its Vision and Mission. The strategic plan is translated into operational goals and plans for departments, facilitating achievement of targets giving a detail of time schedules along with resources required over the plan period.\r\n"
						+ "\r\n" + "\r\n"
						+ "All the above clearly ensure participative management at every level of the institution facilitating development of potential leaders in the college, a clear reflection and demonstration of effective leadership of college.\r\n"
						+ "" + "",
				font5);
		paragraph10criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph10criteria6);
//create a table 1
		PdfPTable table1criteria6 = new PdfPTable(2);
		table1criteria6.setWidthPercentage(100);
//PdfPTable table11=new PdfPTable(2);
//table11.setWidthPercentage(100);
		PdfPCell cell1criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
		PdfPCell cell2criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		PdfPCell cell3criteria6 = new PdfPCell(new Paragraph("Any aditional information"));
		PdfPCell cell4criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));
		table1criteria6.addCell(cell1criteria6);
		table1criteria6.addCell(cell2criteria6);
		table1criteria6.addCell(cell3criteria6);
		table1criteria6.addCell(cell4criteria6);
		table1criteria6.setSpacingBefore(20f);
		table1criteria6.setSpacingAfter(20f);
		document.add(table1criteria6);

//create table 2
		PdfPTable table2criteria6 = new PdfPTable(2);
		table2criteria6.setWidthPercentage(100);
		PdfPTable table21criteria6 = new PdfPTable(1);
		table21criteria6.setWidthPercentage(100);

		PdfPCell cell21criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
		PdfPCell cell22criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell23criteria6 = new PdfPCell(new Paragraph("Any aditional information\r\n\r\n\r\n"));
		PdfPCell cell24criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")));
		PdfPCell cell25criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell26criteria6 = new PdfPCell(new Paragraph());
		PdfPCell cell27criteria6 = new PdfPCell(
				new Paragraph("Link for strategic plan and deployment documents on the website\r\n\r\n\r\n"));
		PdfPCell cell28criteria6 = new PdfPCell(new Paragraph(""));
		table2criteria6.addCell(cell21criteria6);
		table2criteria6.addCell(cell22criteria6);
		table2criteria6.addCell(cell23criteria6);
		table2criteria6.addCell(cell24criteria6);
		table2criteria6.addCell(cell25criteria6);
		table2criteria6.addCell(cell26criteria6);
		table2criteria6.addCell(cell27criteria6);
		table2criteria6.addCell(cell28criteria6);
		table21criteria6.addCell(
				"6.1.2	The effective leadership is reflected in various institutional practices such as decentralization and participative management.\r\n"
						+ "\r\n" + "Response:\r\n" + "\r\n"
						+ "Mother Teresa College of Engineering and Technology has a well laid practice of decentralization and participative management. Different committees, councils and cells are constituted viz., College Academic Council, Board of studies, Program Assessment Committee, College Academic committee, Research Committee and IQAC Cell etc. The roles and responsibilities of each committee/cell bearers and authorities and the structure of such organisational units are defined at the time of formation. A case study showcasing the practice of decentralization and participative management in the development of Course Outcomes, Course delivery methodology, Course attainments and Program Assessment is discussed below:\r\n"
						+ "\r\n"
						+ "The objectives are accomplished with the participation and coordinated functioning of the faculty at different levels, their roles being as follows:\r\n"
						+ "\r\n" + "1.	Program Assessment Committee (PAC)\r\n" + "\r\n"
						+ "PAC consists of Head of the Department (Program Coordinator unless the department offers more than one program) as the chairperson and Senior faculty members. The committee meets at least once in each semester to review the progress of the program.\r\n"
						+ " \r\n"
						+ "The committee monitors attainment of Course Outcomes (COs), Program Outcomes (POs) and Program Specific Outcomes (PSOs) with the major focus being the cumulative learning of the students undergoing the program.\r\n"
						+ "\r\n"
						+ "1.	Program Coordinator- In association with senior faculty, oversees all the courses offered by the department;\r\n"
						+ "   *  Appoints Course Coordinators for each course offered and administered by the department;  Reviews the performance of students undertaking courses offered by the department;  o Ensures Institution's quality assurance processes for assessment in courses along with Academic Regulations, are implemented;\r\n"
						+ "2.	Course coordinators - Discusses the course and its relationship to other courses within the program with the Program Coordinator\r\n"
						+ "   *   Develops course outcomes for the course\r\n"
						+ "   *   Schedules and conducts an orientation to the course for faculty, particularly who are new to the course.\r\n"
						+ "   *   Develops a meaningful and well-connected topic sequence and schedules the same in consultation with other course instructors involved in the course and ensures adhering to the same.\r\n"
						+ "   *   Develops valid and reliable methods to evaluate student learning outcomes\r\n\r\n"
						+ "3.	Class Advisers (Section Advisor) - Discusses all potentially significant issues and establishes good communication with the students thereby making them fully aware of their responsibility to meet performance standards.\r\n"
						+ "   *    Conducts weekly reviews with Counsellors, monitors student progress and documents reviews to establish a record of trends in overall class performance.\r\n\rn"
						+ "4.	Question Paper Evaluation Committee � It consists of HoD, a few senior Professors Department IQAC representative and an invitee from other department. Chaired by the HoD, the committee examines the following:\r\n"
						+ "   *    Mapping of course outcomes to Program outcomes vis-�-vis the questions Bloom�s Taxonomy level\r\n\r\n"
						+ "   *    Discriminating power to distinguish bright and average student\r\n"
						+ "   *  Specific and precise nature of questions as well as uniform coverage of the content.\r\n"
						+ "\r\n" + "\r\n" + "\r\n"
						+ "All the above clearly indicate decentralization at the department, wherein, faculty members participate not only in administering, monitoring the Teaching-Learning process, but also, in the evaluation and assessment of COs, POs and PSOs.\r\n"
						+ "");

		table2criteria6.setSpacingBefore(20f);
		table2criteria6.setSpacingAfter(20f);
		table21criteria6.addCell(table2criteria6);
		document.add(table21criteria6);

		Paragraph paragraph11criteria6 = new Paragraph("6.2 Strategy Development and Deployment\r\n\r\n\r\n", font2);
		paragraph11criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph11criteria6);
//create a table 3
		PdfPTable table3criteria6 = new PdfPTable(2);
		table3criteria6.setWidthPercentage(100);
		PdfPTable table31criteria6 = new PdfPTable(1);
		table31criteria6.setWidthPercentage(100);

		PdfPCell cell31criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
		PdfPCell cell32criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		PdfPCell cell33criteria6 = new PdfPCell(
				new Paragraph("Link for Strategic Plan and deployment documents on the website\r\n\r\n"));
		PdfPCell cell34criteria6 = new PdfPCell(new Paragraph(""));
		PdfPCell cell35criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell36criteria6 = new PdfPCell(new Paragraph(""));
		table3criteria6.addCell(cell31criteria6);
		table3criteria6.addCell(cell32criteria6);
		table3criteria6.addCell(cell33criteria6);
		table31criteria6.addCell(cell34criteria6);

		table3criteria6.addCell(cell35criteria6);
		table3criteria6.addCell(cell36criteria6);

		PdfPCell cell312 = new PdfPCell(
				new Paragraph("6.2.1	The institutional Strategic / Perspective plan is effectively deployed\r\n\r\n" + ""
						+ "" + "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria62Ql().get(0).getResponse621()
								: ""),
						font3));
		table31criteria6.addCell(cell312);

//table31.addCell("6.2.1	The institutional Strategic / Perspective plan is effectively deployed\r\n\r\n"+" Response:\r\n\r\n");
		table31criteria6.addCell(
				"A progressive institution is always one that has its Perspective Strategic Plan effectively designed, and deployed. Mother Teresa has put in place a feasible Institutional Perspective Strategic Plan and out of which one academic activity -Problem/Project Based Learning (PBL) is presented below as an example:\r\n"
						+ "\r\n" + "\r\n"
						+ "Mother Teresa strongly believes in what Benjamin Franklin has said, �Tell me, I forget; teach me I may remember; involve me, I learn�. Our conviction is that perceivable learning happens only by doing, which is etched for eternity. Since personal experiences are far more interesting, enjoyable and involved, they are long-lasting and of utmost satisfaction. Mother Teresa visualized that Project-Based-Learning is a significant feature of Education 4.0, to make the students get deeply involved in their learning. This significant �learning while doing� is invaluable in providing economically-feasible solutions to imminent societal problems leading to and thereby ensuring environmentally-sustainable development.\r\n"
						+ "\r\n" + "\r\n"
						+ "Keeping this in view, Mother Teresa deputed 16 teachers from various departments to KLE Technological University, Hubli for a period of three days in November 2019 facilitating them towards PBL. Thereafter, Mother Teresa entered into an MoU with the Viswanekathan Group of Institutions, Khalapur, Maharashtra, for training faculty at Mother Teresa on �PBL�.\r\n"
						+ "\r\n" + "\r\n"
						+ "Step I: Introductory workshop on PBL was conducted during January 04-05, 2020. Fifty-five faculty drawn from different departments attended were trained to get sensitized in the identification of problems for a given course. Faculty prepared a problem canvas categorizing different aspects of the identified problem and presented their work.\r\n"
						+ "\r\n"
						+ "Step II: Course level PBL orientation Workshop, was conducted for same faculty during January 24-26, 2020. Aspects of implementation of PBL for a particular course were introduced; faculty of each department identified two courses for PBL implementation, learnt the concept of storyboard for a course. Course-level PBL canvas helped faculty to identify and create a clothes-line model for a particular problem.\r\n"
						+ "\r\n" + "\r\n"
						+ "Subsequently, resource persons interacted with students of first/second/third year, oriented them to adapt PBL into their learning and enabled them to be future ready.\r\n"
						+ "\r\n" + "");
		PdfPCell cell31x = new PdfPCell(
				new Paragraph("Step III: Course Level PBL (CLPBL) implementation" + "" + "", font5));
		table31criteria6.addCell(cell31x);
		table31criteria6.addCell(
				"In continuation to the first two PBL workshops, all departments identified the courses and the respective faculty for implementation of PBL. During March 04-05, 2020, resource persons from Vishwaniketan interacted with our faculty, CLPBL presentations were reviewed, feedbacks were received and incorporated into action plans for implementing the same. Resource persons also reviewed final year projects for business viability through bootcamp, had another interaction with students to orient them towards PBL.");

		PdfPCell cell31y = new PdfPCell(
				new Paragraph("OUTCOME: Tutorial on IEEE HYDCON on PBL and Course level PBL" + "" + "", font5));
		table31criteria6.addCell(cell31y);
		table31criteria6.addCell(
				"The IEEE Hyderabad section organized a conference �Industry 4.0��, with emphasis on PBL as the\r\n"
						+ " \r\n"
						+ "educational approach for students to be industry-ready, conducted tutorial session on PBL for the participants, and our faculty demonstrated our strategically developed CLPBL as a feasible example for implementation, and this was highly appreciated.\r\n"
						+ "\r\n"
						+ "This experience and strategic action plan have rendered Mother Teresa to successfully implement PBL, in eighteen courses across various departments culminating in the development of critical thinking and interpersonal skills in students.\r\n"
						+ "");

		table31criteria6.addCell(table3criteria6);
		table31criteria6.setSpacingAfter(20f);
		document.add(table31criteria6);

//create table 4
		PdfPTable table4criteria6 = new PdfPTable(2);
		table4criteria6.setWidthPercentage(100);
		PdfPTable table41criteria6 = new PdfPTable(1);
		table41criteria6.setWidthPercentage(100);

		PdfPCell cell41criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
		PdfPCell cell42criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		PdfPCell cell43criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell44criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : "")));
		PdfPCell cell45criteria6 = new PdfPCell(new Paragraph("Link to Organogram of the Institution webpage\r\n\r\n\r\n"));
		PdfPCell cell46criteria6 = new PdfPCell(new Paragraph(""));
		PdfPCell cell47criteria6 = new PdfPCell(new Paragraph("Link for additional information"));
		PdfPCell cell48criteria6 = new PdfPCell(new Paragraph(""));
		table4criteria6.addCell(cell41criteria6);
		table4criteria6.addCell(cell42criteria6);
		table4criteria6.addCell(cell43criteria6);
		table4criteria6.addCell(cell44criteria6);
		table4criteria6.addCell(cell45criteria6);
		table4criteria6.addCell(cell46criteria6);
		table4criteria6.addCell(cell47criteria6);
		table4criteria6.addCell(cell48criteria6);
		PdfPCell cell41x = new PdfPCell(new Paragraph(
				"6.2.2	The functioning of the institutional bodies is effective and efficient as visible from policies, administrative setup, appointment, service rules and procedures, etc.\r\n"
						+ "\r\n" + "\r\n" + "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria62Ql().get(0).getResponse622()
								: ""),
				font3));
		table41criteria6.addCell(cell41x);
		table41criteria6.addCell("Mother Teresa�s organogram depicts its organizational structure");
		table41criteria6.addCell(
				"Governing Body, the apex statutory body, monitors the reflection of the institution�s Vision, Mission and quality policy in all activities of the HEI, gives direction to various constituents and monitors its performance.\r\n"
						+ "\r\n" + "\r\n"
						+ "The institution is organized into Academic, Examinations and Administrative units with Principal as Head of the Institution. Other statutory bodies of the college include, Academic Council (AC), Boards of Studies (BoS), and Finance committee, while, non-statutory committees, Planning & Monitoring Board, Library,\r\n"
						+ " \r\n" + "\r\n"
						+ "Examinations, Grievance Redressal, IQAC, Internal compliance committee (Women Protection Cell), Anti- Ragging, and Canteen, constituted as per the norms of the Autonomous status of the college.\r\n\r\n"
						+ "");
		table41criteria6.addCell(
				"Dean, Academic, Prepares Academic Calendar detailing various activities, monitors progress of class work, student counseling/mentoring, directing and supervising student activity programs.\r\n"
						+ "\r\n" + "\r\n"
						+ "The Registrar, along with Dean, Academic and college academic committee assists Principal in administering and leading the college within the policy framework developed by AC.\r\n"
						+ "\r\n" + "\r\n"
						+ "Controller of Examinations coordinates with external examiners, affiliating university officials and with all concerned in the college, ensures smooth conduct of all examinations evaluation and timely declaration of results.\r\n"
						+ "\r\n" + "\r\n"
						+ "Dean, RD&C formulates research and consultancy policies of the institution, processes research and patent proposals submitted by faculty, recommends internal seed money and other assistance for projects, if any, and identifies areas/institutions for collaborative purposes and rendering consultancy services.\r\n"
						+ "\r\n" + "\r\n"
						+ "Dean, Students Affairs facilitates/coordinates student council formation, maintains discipline, supervises anti-ragging committee and arranges to conduct extracurricular activities.\r\n"
						+ "\r\n" + "\r\n"
						+ "Coordinator, Industry Institute Interaction, develops industry linkage, facilitates MoUs.\r\n"
						+ "\r\n" + "\r\n"
						+ "Coordinator, computing services, oversees and facilitates IT infrastructure requirements, arranges for smooth conduct of IT activities of the institution.\r\n"
						+ "\r\n" + "\r\n"
						+ "Coordinator, IQAC, initiates and administers quality initiatives of the college. Arranges conduct of internal/external academic and administrative audit.\r\n"
						+ "\r\n"
						+ "Dean, TPCP, oversees/administers career guidance and development programs facilitating students acquire employability and career progression skills.\r\n"
						+ "\r\n" + "\r\n"
						+ "Coordinator, EDC, conducts entrepreneurial development programs., promoting entrepreneurship.\r\n"
						+ "\r\n" + "\r\n"
						+ "Coordinator, IC, nurtures seed of creativity and innovation, fostering a culture of product development through prototypes, resulting in entrepreneurship through a start-up, inviting and involving venture capitalists.\r\n"
						+ "\r\n" + "\r\n"
						+ "Dean, School of Computer Science and Informatics, oversees smooth functioning of CSE/IT/ CSE (Emerging Areas) departments ensuring optimal utilization of their resources.\r\n"
						+ "Dean, School of Electrical and Communication Engineering, oversees smooth functioning of ECE and EEE departments, ensuring development of quality initiative measures for improving employability of students in core sectors.\r\n"
						+ "\r\n" + "\r\n"
						+ "HoD, administers smooth conduct of academic and administrative activities of the department. In association with senior faculty members promotes scholarly activities of faculty and students.\r\n"
						+ "\r\n" + "\r\n"
						+ "AO, assists Registrar in all administrative activities including operations, maintenance of facilities, safety\r\n"
						+ "and security of all. Also maintains AICTE/UGC/Government correspondence.\r\n" + "\r\n"
						+ "\r\n" + "\r\n"
						+ "Accounts Officer, in association with Registrar, assists Principal in the preparation of budget and maintaining records of all accounts, and facilitating audit of the same.\r\n"
						+ "\r\n" + "\r\n"
						+ "Establishment section, maintains personal files of all employees of the college updates their leave status from time to time\r\n"
						+ "");
		table41criteria6.addCell(table4criteria6);
		table41criteria6.setSpacingAfter(20f);
		document.add(table41criteria6);
//create table5
		PdfPTable table5criteria6 = new PdfPTable(2);
		table5criteria6.setWidthPercentage(100);
		PdfPTable table51criteria6 = new PdfPTable(1);
		table51criteria6.setWidthPercentage(100);

		PdfPCell cell51criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
		
		PdfPCell cell52criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		
		PdfPCell cell53criteria6 = new PdfPCell(new Paragraph("Screen shots of user interfaces\r\n\r\n\r\n"));
		PdfPCell cell54criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(3).getCriteria6FilePath() : "")));
		//cell54criteria6.setBackgroundColor(Align:);
		PdfPCell cell55criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
		PdfPCell cell56criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(4).getCriteria6FilePath() : "")));
		PdfPCell cell57criteria6 = new PdfPCell(new Paragraph("ERP (Enterprise Resource Planning) Document\r\n\r\n\r\n"));
		PdfPCell cell58criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(5).getCriteria6FilePath() : "")));
		PdfPCell cell59criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell60criteria6 = new PdfPCell(new Paragraph(""));
		table5criteria6.addCell(cell51criteria6);
		table5criteria6.addCell(cell52criteria6);
		table5criteria6.addCell(cell53criteria6);
		table5criteria6.addCell(cell54criteria6);
		table5criteria6.addCell(cell55criteria6);
		table5criteria6.addCell(cell56criteria6);
		table5criteria6.addCell(cell57criteria6);
		table5criteria6.addCell(cell58criteria6);
		table5criteria6.addCell(cell59criteria6);
		table5criteria6.addCell(cell60criteria6);
		PdfPCell cell51x = new PdfPCell(
				new Paragraph(
						"6.2.3	Implementation of e-governance in areas of operation\r\n" + "\r\n"
								+ "1.	Administration\r\n" + "2.	Finance and Accounts\r\n"
								+ "3.	Student Admission and Support\r\n" + "4.	Examination\r\n" + "\r\n" + "",
						font3));
		table51criteria6.addCell(cell51x);
		table51criteria6.addCell("Response: A. All of the above");
		table51criteria6.addCell(table5criteria6);
		document.add(table51criteria6);

//paragraph 6.3
		Paragraph paragraph12criteria6 = new Paragraph("6.3  Faculty Empowerment Strategies\r\n\r\n\r\n", font3);
		paragraph12criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph12criteria6);
// create table6
		PdfPTable table6criteria6 = new PdfPTable(2);
		table6criteria6.setWidthPercentage(100);
		PdfPTable table61criteria6 = new PdfPTable(1);
		table61criteria6.setWidthPercentage(100);

		PdfPCell cell61criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
		PdfPCell cell62criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell63criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell64criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(6).getCriteria6FilePath() : "")));
		PdfPCell cell65criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell66criteria6 = new PdfPCell(new Paragraph(""));
		table6criteria6.addCell(cell61criteria6);
		table6criteria6.addCell(cell62criteria6);
		table6criteria6.addCell(cell63criteria6);
		table6criteria6.addCell(cell64criteria6);
		table6criteria6.addCell(cell65criteria6);
		table6criteria6.addCell(cell66criteria6);
		PdfPCell cell61x = new PdfPCell(new Paragraph(
				"6.3.1 The institution has effective welfare measures for teaching and non-teaching staff and avenues for career development/ progression\r\n"
						+ "\r\n" + "\r\n" + "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria63Ql().get(0).getResponse631()
								: ""),
				font3));
		table61criteria6.addCell(cell61x);
		table61criteria6.addCell(
				"Mother Teresa is more than sensitive to reaching out welfare measures to both, our Faculty and the administrative/support Staff. The following welfare schemes/benefits are offered by the institution:\r\n"
						+ "\r\n" + "");
		table61criteria6.addCell(
				" *  Financial incentives are given for faculty for research publications and Books/Book chapters :\r\n"
						+ "\r\n" + " *  Full financial support for filing patents\r\n"
						+ " *  Free Medical facility at the institution\r\n"
						+ " *  Free transport to administrative staff.\r\n"
						+ " *  Vehicles, and bus passes to Messengers.\r\n"
						+ " *  Public transport bus passes to all drivers.\r\n"
						+ " *  Need Based financial assistance to staff.\r\n"
						+ " *  Cell-Phones and Laptops to HoDs for better connectivity and networking.\r\n"
						+ " *  CLs, HPLs, CCL, Medical Leave and Examination Leaves as per their eligibility.\r\n"
						+ " *  Paid Maternity Leave for female employees.\r\n"
						+ " *  Special leave to staff on the occasion of their marriage.\r\n"
						+ " *  Health Awareness camps within campus and Free Medical Check-ups.\r\n"
						+ " *  Uniforms, washing allowance for Attendants, Ayahs and Drivers.\r\n"
						+ " *  Paid leave @ one day/Week as incentive to faculty pursuing part-time Ph.D and conducting consultancy\r\n"
						+ " *  Study/sabbatical leave for faculty pursuing full-time Ph.D.\r\n"
						+ " *  Paid leave for faculty attending MOOCs certification examination and reimbursement of examination fee.\r\n"
						+ " *  Paid leave with registration fee to attend FDPs/Conferences.\r\n"
						+ " *  Supporting faculty pursuing research through Creation of required facilities as per their request.\r\n"
						+ " *  ESI benefit to attenders, Ayahs, drivers, gardeners, and admin assistants.\r\n"
						+ " *  Salary advances for faculty and staff in times of need." + "");

		table61criteria6.addCell(table6criteria6);
		document.add(table61criteria6);

//create a table7
		PdfPTable table7criteria6 = new PdfPTable(1);
		table7criteria6.setWidthPercentage(100);
		PdfPTable table71criteria6 = new PdfPTable(2);
		table71criteria6.setWidthPercentage(100);
		PdfPCell cell71criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
		PdfPCell cell72criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell73criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
		PdfPCell cell74criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(7).getCriteria6FilePath() : "")));
		PdfPCell cell75criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell76criteria6 = new PdfPCell(new Paragraph(""));
		table71criteria6.addCell(cell71criteria6);
		table71criteria6.addCell(cell72criteria6);
		table71criteria6.addCell(cell73criteria6);
		table71criteria6.addCell(cell74criteria6);
		table71criteria6.addCell(cell75criteria6);
		table71criteria6.addCell(cell76criteria6);

		PdfPCell cell7x = new PdfPCell(new Paragraph(
				"6.3.2 Average percentage of teachers provided with financial support to attend conferences / workshops and towards membership fee of professional bodies during the last five years.\r\n"
						+ "\r\n" + "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria63Qn().get(0).getResponse632()
								: ""),
				font3));
		PdfPCell cell7y = new PdfPCell(new Paragraph(
				"6.3.2.1 Number of teachers provided with financial support to attend conferences/workshops and towards membership fee of professional bodies year wise during the last five years"
						+ "",
				font3));

		table7criteria6.addCell(cell7x);
		table7criteria6.addCell(cell7y);
		document.add(table7criteria6);

//cretae table 6321

		/*
		 * Table table6321criteria6 = new
		 * Table(criteria6Record.getYearTable6321().size(), 2);
		 * 
		 * table6321criteria6.setPadding(10); table6321criteria6.setWidth(100f);
		 * 
		 * for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
		 * table6321criteria6.addCell(criteria6Record.getYearTable6321().get(i).
		 * getInput6321y()); } for (int i = 0; i <
		 * criteria6Record.getYearTable6331().size(); i++) {
		 * table6321criteria6.addCell(criteria6Record.getYearTable6321().get(i).
		 * getInput6321v()); }
		 * 
		 * document.add(table6321criteria6);
		 */
		table71criteria6.setSpacingAfter(10f);

//create table 8
		PdfPTable table8criteria6 = new PdfPTable(1);
		table8criteria6.setWidthPercentage(100);
		PdfPTable table81criteria6 = new PdfPTable(2);
		table81criteria6.setWidthPercentage(100);
		PdfPCell cell81criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n\r\n", font3));
		PdfPCell cell82criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell83criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
		PdfPCell cell84criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(8).getCriteria6FilePath() : "")));
		PdfPCell cell85criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell86criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(9).getCriteria6FilePath() : "")));
		table81criteria6.addCell(cell81criteria6);
		table81criteria6.addCell(cell82criteria6);
		table81criteria6.addCell(cell83criteria6);
		table81criteria6.addCell(cell84criteria6);
		table81criteria6.addCell(cell85criteria6);
		table81criteria6.addCell(cell86criteria6);

		PdfPCell cell8x = new PdfPCell(new Paragraph(
				"6.3.3 Average number of professional development / administrative training Programmes organized by the institution for teaching and non-teaching staff during the last five years.\r\n"
						+ "\r\n" + "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria63Ql().get(0).getResponse633()
								: ""),
				font3));

		PdfPCell cell8y = new PdfPCell(new Paragraph(
				"6.3.3.1 Total number of professional development /administrative training Programmes organized by the institution for teaching and non teaching staff year-wise during the last five years"
						+ "",
				font3));

		table8criteria6.addCell(cell8x);
		table8criteria6.addCell(cell8y);
		document.add(table8criteria6);
//create year table 6331
		if (criteria6Record != null) {

			Table table6331criteria6 = new Table(criteria6Record.getYearTable6331().size(), 2);

			table6331criteria6.setPadding(10);
			table6331criteria6.setWidth(100f);

			for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
				table6331criteria6.addCell(criteria6Record.getYearTable6331().get(i).getInput6331y());
			}
			for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
				table6331criteria6.addCell(criteria6Record.getYearTable6331().get(i).getInput6331v());
			}

			document.add(table6331criteria6);
		}
		table81criteria6.setSpacingAfter(10f);
		document.add(table81criteria6);
//cretae table 9
		PdfPTable table9criteria6 = new PdfPTable(1);
		table9criteria6.setWidthPercentage(100);
		PdfPTable table91criteria6 = new PdfPTable(2);
		table91criteria6.setWidthPercentage(100);
		PdfPCell cell91criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
		PdfPCell cell92criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell93criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
		PdfPCell cell94criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(10).getCriteria6FilePath() : "")));
		PdfPCell cell95criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell96criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(11).getCriteria6FilePath() : "")));
		PdfPCell cell97criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell98criteria6 = new PdfPCell(new Paragraph(""));
		table91criteria6.addCell(cell91criteria6);
		table91criteria6.addCell(cell92criteria6);
		table91criteria6.addCell(cell93criteria6);
		table91criteria6.addCell(cell94criteria6);
		table91criteria6.addCell(cell95criteria6);
		table91criteria6.addCell(cell96criteria6);
		table91criteria6.addCell(cell97criteria6);
		table91criteria6.addCell(cell98criteria6);

		PdfPCell cell9x = new PdfPCell(new Paragraph(
				"6.3.4 Average percentage of teachers undergoing online/ face-to-face Faculty Development Programmes (FDP)during the last five years (Professional Development Programmes, Orientation / Induction Programmes, Refresher Course, Short Term Course ).\r\n"
						+ "\r\n" + "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria63Qn().get(0).getResponse634()
								: ""),
				font3));
		PdfPCell cell9y = new PdfPCell(new Paragraph(
				"6.3.4.1 Total number of teachers attending professional development Programmes, viz., Orientation Programme, Refresher Course, Short Term Course, Faculty Development Programmes year wise during last five years"
						+ "",
				font3));
		table9criteria6.addCell(cell9x);
		table9criteria6.addCell(cell9y);
		document.add(table9criteria6);
//create table 6341
		if (criteria6Record != null) {

			Table table6341criteria6 = new Table(criteria6Record.getYearTable6341().size(), 2);

			table6341criteria6.setPadding(10);
			table6341criteria6.setWidth(100f);

			for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
				table6341criteria6.addCell(criteria6Record.getYearTable6341().get(i).getInput6341y());
			}
			for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
				table6341criteria6.addCell(criteria6Record.getYearTable6341().get(i).getInput6341v());
			}

			document.add(table6341criteria6);
		}
		table91criteria6.setSpacingAfter(10f);
		document.add(table91criteria6);

//create 6.4
		Paragraph paragraph13criteria6 = new Paragraph("6.4	Financial Management and Resource Mobilization\r\n\r\n\r\n\r\n", font3);
		paragraph13criteria6.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(paragraph13criteria6);
//create table10
		PdfPTable table10criteria6 = new PdfPTable(2);
		table10criteria6.setWidthPercentage(100);

		com.lowagie.text.Font fontTitle5criteria6 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fontTitle5criteria6.setSize(10);

		PdfPTable table101criteria6 = new PdfPTable(1);
		table101criteria6.setWidthPercentage(100);

		PdfPCell cell10x = new PdfPCell(new Paragraph(
				"6.4.1	Institution conducts internal and external financial audits regularly\r\n\r\n Response:" + "", font3));
		table101criteria6.addCell(cell10x);

		PdfPCell cell101criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
		PdfPCell cell102criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell103criteria6 = new PdfPCell(new Paragraph("Any additional information"));
		PdfPCell cell104criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(12).getCriteria6FilePath() : "")));
		table10criteria6.addCell(cell101criteria6);
		table10criteria6.addCell(cell102criteria6);
		table10criteria6.addCell(cell103criteria6);
		table10criteria6.addCell(cell104criteria6);
		table101criteria6.addCell(
				"A: Internal financial audit: The college constitutes an internal committee for conducting verification of assets/capital equipment as well as financial audit. The committee checks financial reporting compliance with policies as well as compliance with respect to legal aspects including applicability of the trust/society. The internal audit also verifies the achievement of operational goals and objectives, safe guarding of assets, effective and efficient use of resources.\r\n"
						+ "\r\n"
						+ "Audit of assets and capital equipment are conducted through stock verification by the committee and based on shortages reported, if any, action for write-off is taken with the approval of the competent authority and such items are removed from the asset registers. Similar action is taken in respect of books/journals/documents.\r\n"
						+ "\r\n"
						+ "The internal audit committee, besides inspecting the books of account and records maintained by the finance department, evaluates internal control system, particularly, in respect of purchases, scholarships etc. The audit report is submitted to Principal/Chairman and subsequently Principal directs departments to take follow up action for closing the deficiencies and making changes in systems and procedures as called for.\r\n"
						+ "\r\n"
						+ "B: External financial audit: Mother Teresa arranges to conduct external financial audit every year by an external auditing agency named Haribabu and Associates, a registered financial auditing company, located in Hyderabad. The same auditing agency has been conducting external audit since the inception of our college, i.e.,2005. The auditors verify the financial statements and books of accounts to certify the truth and fairness of the financial position and operating system prevalent. The auditors employ internal check by verifying arithmetical accuracy of books of accounts, authentication and validation of transaction and also checking the proper distinction between capital and revenue nature of transactions. Except for transactions involving petty amounts, all other payments are made by way of issuing account payee cheques, demand drafts and using the fund transfer facility of banks such as NEFT/RTGS, to maintain transparency and to minimize errors may likely to occur due to cash transactions. This makes the job of our auditor simple and more easy. The audit observations submitted to the management by the audit company are examined carefully and corrective actions taken, if any, wherever required. At the end of every financial year, IT returns are filed to income tax department. These include, income and expenditure statements audited by a chartered accountant.\r\n"
						+ "\r\n"
						+ "All the audit reports have been found to be in order. However, prior to external audit an internal audit is conducted through a Chartered Accountant (CA). In case of any errors. identified by CA, they will be rectified by the internal accounts staff as per the suggestion by the CA. These minor errors, if and when crept in, due to any oversight by accounting personnel, is verified and rectified, resulting in strengthening of the financial accounting and budgetary control systems.\r\n"
						+ " \r\n" + "");
		table101criteria6.addCell(table10criteria6);
		table101criteria6.setSpacingAfter(10f);
		document.add(table101criteria6);
//create table 11
		PdfPTable table11criteria6 = new PdfPTable(1);
		table11criteria6.setWidthPercentage(100);
		PdfPCell cell11x = new PdfPCell(new Paragraph(
				"6.4.2 Funds / Grants received from non-government bodies, individuals, philanthropists during the last five years (not covered in Criterion III and V) (INR in Lakhs)\r\n"
						+ "\r\n" + "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria64Qn().get(0).getResponse642()
								: ""),
				font3));
		PdfPCell cell11y = new PdfPCell(new Paragraph(
				"6.4.2.1 Total Grants received from non-government bodies, individuals, Philanthropers year-wise during the last five years (INR in Lakhs)"
						+ "",
				font3));
		table11criteria6.addCell(cell11x);
		table11criteria6.addCell(cell11y);
		document.add(table11criteria6);
//create table 6421

		if (criteria6Record != null) {

			Table table6421 = new Table(criteria6Record.getYearTable6421().size(), 2);

			table6421.setPadding(10);
			table6421.setWidth(100f);

			for (int i = 0; i < criteria6Record.getYearTable6421().size(); i++) {
				table6421.addCell(criteria6Record.getYearTable6421().get(i).getInput6421y());
			}
			for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
				table6421.addCell(criteria6Record.getYearTable6421().get(i).getInput6421v());
			}

			document.add(table6421);
		}

		PdfPTable table111criteria6 = new PdfPTable(2);
		table111criteria6.setWidthPercentage(100);
		PdfPCell cell111criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n\r\n", font3));
		PdfPCell cell112criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n\r\n", font3));
		PdfPCell cell113criteria6 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n\r\n"));
		PdfPCell cell114criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(13).getCriteria6FilePath() : "")));
		PdfPCell cell115criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell116criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(14).getCriteria6FilePath() : "")));
		PdfPCell cell117criteria6 = new PdfPCell(new Paragraph("Annual statements of accounts\r\n\r\n\r\n"));
		PdfPCell cell118criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(15).getCriteria6FilePath() : "")));
		PdfPCell cell119criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell120criteria6 = new PdfPCell(new Paragraph(""));
		table111criteria6.addCell(cell111criteria6);
		table111criteria6.addCell(cell112criteria6);
		table111criteria6.addCell(cell113criteria6);
		table111criteria6.addCell(cell114criteria6);
		table111criteria6.addCell(cell115criteria6);
		table111criteria6.addCell(cell116criteria6);
		table111criteria6.addCell(cell117criteria6);
		table111criteria6.addCell(cell118criteria6);
		table111criteria6.addCell(cell119criteria6);
		table111criteria6.addCell(cell120criteria6);
		document.add(table111criteria6);
//CREATE TABLE12
		PdfPTable table12criteria6 = new PdfPTable(1);
		table12criteria6.setWidthPercentage(100);
		PdfPTable table121x = new PdfPTable(1);
		table121x.setWidthPercentage(100);

		PdfPCell cell12Y = new PdfPCell(new Paragraph(
				"6.4.3 Institutional strategies for mobilisation of funds and the optimal utilisation of resources Response:\r\n"
						+ "Resource Mobilization Policy and Procedures\r\n" + "\r\n" + "\r\n"
						+ "The policy of Mother Teresa with regard to mobilization of funds is as follows:\r\n" + "\r\n"
						+ "\r\n"
						+ "Internal: Tuition fee, NBA fee, Training fee, transport fee and other miscellaneous fees collected from students.\r\n"
						+ "\r\n" + "\r\n" + "External:\r\n" + "",
				font3));
		table12criteria6.addCell(cell12Y);
		document.add(table12criteria6);
		table121x.addCell(
				"Procedure: The accounts section of the college prepares, month-wise cash flow statements, at least two months in advance. The cash outflow statement is based on institutional budget estimates and additional inputs form departments for unanticipated major expenses, and contingency expenses. The cash inflow (income) statement is prepared based on the schedules for admissions, commencement of classes indicated in the Academic calendar, and examination time tables. The Accounts department notifies the fee payment schedules to students to align with cash requirements as per projected cash inflow statement. If there are indications of fee collection being short of estimates, vigorous efforts are made through academic department staff and fee counselor to increase the receipts. The gap between the actual income and the estimated expenses is bridged through loans from banks/non-bank financial institutions as per the policy guidelines.\r\n"
						+ "\r\n"
						+ "Periodically, a review of the adequacy of limits for term and operational loans sanctioned by banks is carried out by the college management and the Principal. If the sanctioned limits are found to be inadequate, the banks are approached for enhancement of the sanctioned limits, with proper justification.\r\n"
						+ "");
		table121x.addCell(table12criteria6);
		document.add(table121x);

//create table 121
		PdfPTable table121criteria6 = new PdfPTable(2);
		table121criteria6.setWidthPercentage(100);
		PdfPCell cell121criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
		PdfPCell cell122criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell123criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell124criteria6 = new PdfPCell(new Paragraph(""));
		table121criteria6.addCell(cell121criteria6);
		table121criteria6.addCell(cell122criteria6);
		table121criteria6.addCell(cell123criteria6);
		table121criteria6.addCell(cell124criteria6);
		document.add(table121criteria6);

//create a 6.5
		Paragraph paragraph14criteria6 = new Paragraph("6.5	Internal Quality Assurance System\r\n\r\n\r\n", font2);
		paragraph14criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph14criteria6);
//cretae table 13
		PdfPTable table13criteria6 = new PdfPTable(1);
		table13criteria6.setWidthPercentage(100);

		PdfPCell cell13x = new PdfPCell(new Paragraph(
				"6.5.1 Internal Quality Assurance Cell (IQAC) has contributed significantly for institutionalizing the quality assurance strategies and processes visible in terms of � Incremental improvements made for the preceding five years with regard to quality (in case of first cycle) Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives (second and subsequent cycles)\r\n"
						+ "\r\n\r\n" + "Response"
						+ (criteria6Record != null
								? criteria6Record.getCriteria65Qn().get(0).getResponse651()
								: ""),
				font3));
		table13criteria6.addCell(cell13x);
		document.add(table13criteria6);
//create table 2reforms
		PdfPTable table131criteria6 = new PdfPTable(2);
		table131criteria6.setWidthPercentage(100);

		PdfPTable table130criteria6 = new PdfPTable(1);
		table130criteria6.setWidthPercentage(100);

		PdfPCell cell131criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font3));
		PdfPCell cell132criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		PdfPCell cell133criteria6 = new PdfPCell(new Paragraph("Any additional information"));
		PdfPCell cell134criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(16).getCriteria6FilePath() : "")));
		table131criteria6.addCell(cell131criteria6);
		table131criteria6.addCell(cell132criteria6);
		table131criteria6.addCell(cell133criteria6);
		table131criteria6.addCell(cell134criteria6);
		table130criteria6.addCell(
				"Internal Quality Assurance Cell (IQAC) of Mother Teresa has been in operation since 2012, initiating and conducting several activities to improve quality of both academic and administrative functions, in order to provide quality educational and service and experience for students, faculty and staff. During the last 5 years it has had 20 meetings and 80 resolutions. Among the practices initiated by IQAC, the following two have contributed to the quality enhancement.\r\n"
						+ "\r\n" + "\r\n"
						+ "Practice No. 1: Promoting research culture among faculty leading to increase in number and quality of publications/Patents:\r\n"
						+ "\r\n" + "\r\n"
						+ "IQAC in association with the R&D Cell, has been organizing FDPs/Seminars/Webinars/workshops on research methodology, IPR, creativity and innovation (during the last five years, 12 events were held), as well as encouraging faculty to attend such events conducted elsewhere (all put together 129 faculty participated). College also has been giving one day off per week for faculty to work on their PhD, based on the progress of their work.\r\n"
						+ "\r\n" + "\r\n"
						+ "Senior and experienced faculty with doctorate degree discuss with junior faculty, on the importance of obtaining doctorate for their career development, AICTE and UGC mandates for PhD degree, and subject- related research ideas and methodologies.\r\n"
						+ "\r\n" + "\r\n"
						+ "As a result of these initiatives of IQAC, during the last five years, 71 faculty members have registered for part time PhD. In addition, 8 more have registered for full time PhD. Faculty pursuing PhD as well as others about to register for PhD, have been working actively, on identified areas of research and this has paved way for an increase in the number of publications from 321 to 734 and Patents published from zero to 55. Eight teachers have obtained Ph.D degrees while working in the college.\r\n"
						+ "\r\n" + "\r\n"
						+ "Practice No. 2: Reforms in the Midterm examination question papers and assessment as per the Blooms Taxonomy levels:\r\n"
						+ "\r\n" + "\r\n"
						+ "Towards this, IQAC has initiated a process to assess the quality of midterm examination question papers and made significant improvements in the assessment of students aligning with the teaching-learning process and outcomes. Each department constituted a committee comprising the HoD/Program Coordinator, three senior faculty, course coordinator and one senior faculty from outside the department to look at various parameters in order to ensure that balanced question papers were prepared facilitating appropriate measurement of outcomes. IQAC designed a structured questionnaire in the form of a checklist (attached as additional document), and oriented faculty on the preparation of question paper and assess students� performance in fitment to the levels of Bloom�s Taxonomy. Guidelines were also given in regard to these levels for each of the four years of the BTech program as well as the PG programs. This has improved the quality of question papers and faculty are well acquainted on the appropriate implementation of OBE with usage of appropriate verbs vis-�-vis Bloom�s Taxonomy levels. This entire process has enabled better assessment of course outcomes, resulting in improvement of program outcomes, which is perceivable in the performance of graduates pursuing higher education and securing placements with higher pay packages.\r\n"
						+ "");
		table130criteria6.addCell(table131criteria6);
		document.add(table130criteria6);
		PdfPTable table14criteria6 = new PdfPTable(1);
		table14criteria6.setWidthPercentage(100);
		PdfPCell cell14x = new PdfPCell(new Paragraph(
				"6.5.2 The institution reviews its teaching learning process, structures & methodologies of operations and learning outcomes at periodic intervals through IQAC set up as per norms and recorded the incremental improvement in various activities ( For first cycle - Incremental improvements made for the preceding five years with regard to quality For second and subsequent cycles - Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives )\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria65Ql().get(0).getResponse652()
								: ""),
				font3));
		table14criteria6.addCell(cell14x);
		document.add(table14criteria6);
//create a table 141
		PdfPTable table140criteria6 = new PdfPTable(1);
		table140criteria6.setWidthPercentage(100);
		table140criteria6.addCell(
				"A detailed academic calendar that includes all academic activities is prepared much before commencement of each semester. Course allocation is done based on the expertise of the faculty. Timetables are prepared with dedicated time slots for regular class work/tutorials/remedial classes/seminars/mentoring/Training and Placement activities, and such others.\r\n"
						+ "\r\n"
						+ "Faculty prepare Teaching plan indicating topics with correlation to Course Outcomes (COs), Program Outcomes (POs) and Program Specific Outcomes (PSOs).\r\n"
						+ "\r\n"
						+ "All faculty submit Course files detailing various aspects including Lesson and Laboratory plan for conduct of theory and laboratory sessions in a well-defined format as specified by IQAC.\r\n"
						+ "\r\n" + "I.	Implementation of Teaching-Learning reforms as initiated by the IQAC\r\n"
						+ "\r\n"
						+ "Mother Teresa�s conviction is that the course purpose induces students to deeply involve in their learning, which would lead to quality educational experiences, that would pave way in their professional career development. Towards this, IQAC prepared a detailed questionnaire for improving the quality of course file, giving utmost importance about the purpose of the course.\r\n"
						+ "\r\n" + "Accordingly, IQAC has ensured that the following are described in course files:\r\n"
						+ "\r\n"
						+ " *  The role course plays within the Program, its uniqueness vis-�-vis other courses.\r\n"
						+ " *  Essential knowledge/skills student gains from the course that would help to perform well in future classes/Higher Education progression/Jobs.\r\n"
						+ " *  Prerequisite(s) for the course and specific knowledge/skills students need to know for their future career progression.\r\n"
						+ " *  Unique contributions of the course to students� learning experience there by enriching the quality of the program, in particular, how student�s attitudes and higher-order thinking skills are developed.\r\n"
						+ "\r\n"
						+ "In the laboratory course, scientific enquiry and problem-solving skills are developed, which include:\r\n"
						+ "\r\n" + " *  Defining a problem Formulating hypotheses\r\n"
						+ " *  Designing, conducting experiments Collecting, interpreting data Testing hypotheses, if any,\r\n"
						+ " *  Drawing inferences from conclusions\r\n"
						+ " *  Communicating processes, outcomes and their implications\r\n" + " \r\n" + "");
		table140criteria6.addCell(
				"Prepared lesson plans are discussed with other faculty teaching the same course during Course Coordinator�s meetings. Curriculum is enriched with guest lectures, industrial visits and Internships. Students attendance and performance, continuously monitored by class adviser, mentor and faculty teaching various courses and students are apprised of the same during lectures, lab sessions, mentored and cautioned, whenever necessary.\r\n"
						+ "\r\n" + "IQAC verifies the above through minutes of meetings of:\r\n" + "\r\n"
						+ " *  CRC, Course Coordinator with faculty, Mentor-Mentee.\r\n"
						+ " *  Quality of Guest Lectures etc.\r\n" + "\r\n"
						+ "A continuous internal examination and evaluation system is in place.\r\n" + "\r\n"
						+ "In tune with the outcome-based education approach, the question papers for the internal class tests prepared are evaluated by a question paper evaluation committee, following Bloom�s taxonomy, uniform distribution of questions vis-a-vis syllabus, enabling assessment of the attainment of Course Outcomes for each course.\r\n"
						+ "\r\n"
						+ "Parents are informed about their ward�s attendance on a daily basis and performance in examinations.\r\n"
						+ "\r\n"
						+ "Student feedback on TLP is taken twice a Semester, one immediately after three weeks of commencement of semester, final, just before conclusion of semester by IQAC through a structured questionnaire. It is reviewed by HoD, Dean, Academics and Principal, communicated to faculty. Faculty member with <70% feedback is counseled for improvement. On an average, 35-40 faculty have been mentored in each semester.\r\n"
						+ "\r\n"
						+ "II.	Institutional review - Internal and External Academic and Administrative Audit\r\n"
						+ "\r\n"
						+ "Mother Teresa strongly believes that peer review of our programs through feedback and audit (internal and external) help in strengthening our programs. Hence, feedback on several aspects is collected, analyzed and appropriate measures taken. Institution also conduct audit of our programs at the end of each academic year to sustain quality.\r\n"
						+ "\r\n"
						+ "Towards this, our IQAC has designed a meticulously planned framework detailing various processes starting from course allocation, preparing course file, teaching diary that contains record of classes conducted, topics discussed, student attendance record, mentoring book, weekly reports, class review meetings, and course coordinator�s meetings with faculty teaching same course to various other sections, guidelines for designing experiments, conduct of laboratory sessions, allocation of student projects and preparing question paper, minutes of Question Paper Evaluation Committee, Program Assessment Committee, etc.\r\n"
						+ "\r\n"
						+ "College Academic Committee periodically evaluates the effectiveness of TLP, pedagogical practices and processes outlined by IQAC. Students� learning in the form of knowledge absorption and content assimilation is regularly monitored by IQAC through an internal audit process:\r\n"
						+ "\r\n" + "A. Internal Academic Audit\r\n" + "\r\n"
						+ "All faculty members maintain academic record book (attendance register of students) and record daily\r\n"
						+ " \r\n"
						+ "lectures delivered, tutorial sessions, if any, practical/laboratory sessions conducted and other such activities performed. The academic record is periodically monitored by Course Coordinator/Group Head/HoDs by checking topics covered by faculty member. On the basis of this report, if syllabus coverage is not progressing satisfactorily as per schedule, the concerned faculty is advised to take extra classes to cover syllabus in time, which is ensured. The Head of the Department reviews various academic activities during department meetings, guides faculty members accordingly.\r\n"
						+ "\r\n"
						+ "IQAC has prepared a format to conduct internal academic audit across various departments after the conclusion of each academic year. The internal audit is conducted through senior faculty drawn from cross/ inter-departmental to evaluate efficacy of institution�s TLP and associated administrative aspects and reports on the findings of the committee are submitted, which are forwarded to the departments for taking necessary action. Departments subsequently submit Action Taken Report (ATR) to IQAC, which verifies against the findings submitted earlier, and if found satisfactory, files it, or else, departments are informed to take appropriate corrective measures.\r\n"
						+ "\r\n" + "\r\n" + "B. External Academic Audit\r\n" + "\r\n" + "\r\n"
						+ "The college�s IQAC has started administering external audit since the academic year 2018-19 by inviting senior academicians, with one for each department from other autonomous reputed colleges. Over and above, a former Principal/Dean of a reputed college is invited as the chairperson of the external audit team. External expert team visits all departments conducts audit for one complete day on the performance of the college�s TLP and associated administrative aspects as per the given format, shared at least a few weeks prior to the visit of the team. The team submits its report and departments take appropriate action on the findings of the report by submitting compliance.\r\n"
						+ "" + "");
		table140criteria6.addCell(table14criteria6);
		document.add(table140criteria6);
		PdfPTable table141criteria6 = new PdfPTable(2);
		table141criteria6.setWidthPercentage(100);
		PdfPCell cell141criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
		PdfPCell cell142criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell143criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell144criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(17).getCriteria6FilePath() : "")));
		table141criteria6.addCell(cell141criteria6);
		table141criteria6.addCell(cell142criteria6);
		table141criteria6.addCell(cell143criteria6);
		table141criteria6.addCell(cell144criteria6);
		document.add(table141criteria6);

		// create table 15
		PdfPTable table15criterion6 = new PdfPTable(1);
		table15criterion6.setWidthPercentage(100);
		PdfPCell cell15x = new PdfPCell(
				new Paragraph("6.5.3	Quality assurance initiatives of the institution include:\r\n" + "\r\n"
						+ "1.	Regular meeting of Internal Quality Assurance Cell (IQAC); Feedback collected, analysed and used for improvements\r\n"
						+ "2.	Collaborative quality initiatives with other institution(s)\r\n"
						+ "3.	Participation in NIRF\r\n"
						+ "4.	Any other quality audit recognized by state, national or international agencies (ISO Certification\r\n"
						+ "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria65Qn().get(0).getResponse653()
								: ""),
						font3));
		table15criterion6.addCell(cell15x);
		document.add(table15criterion6);
		// cretae653
		PdfPTable table151criterion6 = new PdfPTable(2);
		table151criterion6.setWidthPercentage(100);
		PdfPCell cell151 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
	
		PdfPCell cell152 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell153 = new PdfPCell(new Paragraph("Upload e-copies of the accreditations and certifications\r\n\r\n\r\n\r\n"));
		PdfPCell cell154 = new PdfPCell(
				new Paragraph(criteria6Record != null ? criteria6file.get(18).getCriteria6FilePath() : ""));
		PdfPCell cell155 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
		PdfPCell cell156 = new PdfPCell(
				new Paragraph(criteria6Record != null ? criteria6file.get(19).getCriteria6FilePath() : ""));
		PdfPCell cell157 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell158 = new PdfPCell(
				new Paragraph(criteria6Record != null ? criteria6file.get(20).getCriteria6FilePath() : ""));
		PdfPCell cell159 = new PdfPCell(new Paragraph("Paste web link of Annual reports of Institution\r\n\r\n\r\n"));
		PdfPCell cell160 = new PdfPCell(new Paragraph(""));
		PdfPCell cell161 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell162 = new PdfPCell(new Paragraph(""));

		table151criterion6.addCell(cell151);
		table151criterion6.addCell(cell152);
		table151criterion6.addCell(cell153);
		table151criterion6.addCell(cell154);
		table151criterion6.addCell(cell155);
		table151criterion6.addCell(cell156);
		table151criterion6.addCell(cell157);
		table151criterion6.addCell(cell158);
		table151criterion6.addCell(cell159);
		table151criterion6.addCell(cell160);
		table151criterion6.addCell(cell161);
		table151criterion6.addCell(cell162);
		table151criterion6.setSpacingBefore(10f);
		document.add(table151criterion6);

	}

//////////////////////////////////////////////
///////////////////// criteria 6 ends.....................
////////////////////////////////////////////////

	public void Criteria7(Document document) {

///////////////////////////////////////////////
///////////////////////criteria 7 starts.......................
////////////////////////////////////////

		/*
		 * Font fontTitlecriteria7 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontTitlecriteria7.setSize(16);
		 */

		Paragraph paragraphcriteria7 = new Paragraph("Criterion 7 - Institutional Values and Best Practices\r\n\r\n",
				font1);
		paragraphcriteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		PdfPCell cell5criteria7 = new PdfPCell();
		cell5criteria7.setPadding(5);
		document.add(cell5criteria7);

		/*
		 * Font fontTitle1criteria7 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontTitle1criteria7.setSize(14);
		 */
		// document
		document.add(paragraphcriteria7);
		Paragraph paragraph2criteria7 = new Paragraph("7.1 Institutional Values and Social Responsibilities\r\n\r\n", font2);
		paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontTitle2criteria7 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontTitle2criteria7.setSize(12);
		 */
		// document2
		document.add(paragraph2criteria7);
		Paragraph paragraph3criteria7 = new Paragraph(
				"7.1.1 Measures initiated by the Institution for the promotion of gender equity during the last five years.\r\n",
				font3);
		paragraph3criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		PdfPTable table711criteria7 = new PdfPTable(1);
		table711criteria7.setWidthPercentage(100f);

		/*
		 * com.lowagie.text.Font fontcriteria7 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontcriteria7.setColor(CMYKColor.BLACK);
		 */

		PdfPCell cell711criteria7 = new PdfPCell(new Paragraph(
				"7.1.1	Measures initiated by the Institution for the promotion of gender equity during the last five years.\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse711()
								: ""),
				font3));

		table711criteria7.addCell(cell711criteria7);
		table711criteria7.setSpacingBefore(20f);
		table711criteria7.setSpacingAfter(20f);

		document.add(table711criteria7);

		// paragaph3
		document.add(paragraph3criteria7);
		/*
		 * Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph.setSize(12);
		 */

	//	Paragraph paragraph4criteria7 = new Paragraph("Response:"
//				+ (criteria7Record != null ? criteria7Record.getCriteria7Fi().get(0).getResponse711()
//						: ""),
//				font3);
//		paragraph4criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		PdfPCell cellcriteria7 = new PdfPCell();
		cellcriteria7.setPadding(5);
		//document.add(paragraph4criteria7);
		// paragraph 4

		Font fontParagraph1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fontParagraph1.setSize(12);

		/*
		 * Font fontParagraph4criteria7 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph4criteria7.setSize(12);
		 */
		Paragraph paragraph5criteria7 = new Paragraph(
				"Mother Teresa has zero tolerance to any kind of discrimination and follows an inclusive policy in all its endeavors, without any bias to gender, caste, religion, language and any such others.\r\n",
				font5);
		paragraph5criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		PdfPCell cell1criteria7 = new PdfPCell();
		document.add(paragraph5criteria7);
		cell1criteria7.setPadding(5);
		// paragraph5
		/*
		 * Font fontParagraph2criteria7 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2criteria7.setSize(12);
		 */
		Paragraph paragraph6criteria7 = new Paragraph(
				"A. Activities to promote Gender Equity and gender sensitization:\r\n", font3);
		PdfPCell cell11criteria7 = new PdfPCell();
		cell11criteria7.setPadding(5);
		paragraph6criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph6criteria7);
		// paragraph6

		Font fontParagraph3criteria7 = FontFactory.getFont(FontFactory.HELVETICA);
		fontParagraph3criteria7.setSize(12);
		Paragraph paragraph7criteria7 = new Paragraph(
				"The Institution has defined procedures for promoting gender equity and sensitization both, in curricular, cocurricular and extra-curricular activities. Towards this, annually, several programs/activities are conducted:\r\n",
				fontParagraph3criteria7);
		paragraph7criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph7criteria7);
		// paragraph7
		/*
		 * Font fontParagraph21criteria7 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph21criteria7.setSize(12);
		 */
		Paragraph paragraph8criteria7 = new Paragraph("1. Curricular and Co-curricular activities: \r\n", font3);
		paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph8criteria7);
		// paragraph8

		/*
		 * Font fontParagraph31criteria7 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph31criteria7.setSize(12);
		 */
		Paragraph paragraph9criteria7 = new Paragraph(
				"a. During their entire programme, students are sensitized to the behavioral nuances of working with the opposite gender. Girl students are empowered by taking up additional responsibilities as class representatives as well as executive members in the Student Council. About 4000 students including girls and boys have been sensitized on gender issues through these activities and are advised to maintain a healthy relationship so that women are not embarrassed at any point of time. Further, students are also counseled not to discuss topics that may have gender bias leading to any untoward/unpleasant situations\r\n"
						+ "b. 'Gender Sensitization' has been introduced as a mandatory audit course to all undergraduate students and is a part of our curriculum. Interactive sessions of this course spreading over an entire semester, amply emphasize the theme and promote the goal. As part of our academic requirement and practice, being a coeducational institution, students of both the genders participate in various curricular, namely, laboratory work, internships, mini and major projects, technical and project seminar, wherein, they cooperatively and collaboratively work together. The institution treats their participation with due consideration for gender equity and equality.\r\n",
				font5);

		paragraph9criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph9criteria7);
		// p9
		/*
		 * Font fontParagraph211 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph211.setSize(12);
		 */
		Paragraph paragraph10criteria7 = new Paragraph("2. Extra-curricular activities:\r\n", font3);
		document.add(paragraph10criteria7);
		// p10

		/*
		 * Font fontParagraph311 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph311.setSize(12);
		 */
		Paragraph paragraph11criteria7 = new Paragraph(
				"Students participate in various extracurricular activities such as 36-hour Hackathons, IEEE’s 24-hour programming contest, project exhibitions, paper and poster presentations etc. In all these activities,students form groups involving both genders, which facilitates them in understanding the sensitivities of working together and without any bias to the opposite gender",
				font5);

		paragraph11criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph11criteria7);
		// p11
		/*
		 * Font fontParagraph2111 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2111.setSize(12);
		 */
		Paragraph paragraph12criteria7 = new Paragraph("3. Activities under other gender-specific bodies:", font3);
		// p12
		document.add(paragraph12criteria7);

		/*
		 * Font fontParagraph3111 = FontFactory.getFont(FontFactory.HELVETICA);
		 * 
		 * fontParagraph3111.setSize(12);
		 */
		Paragraph paragraph13criteria7 = new Paragraph(
				"a. IEEE Women in Engineering (WiE), an affinity group established in the college in 2016. Through\r\n"
						+ "WiE, college is promoting Gender equity and sensitization, and has organized twelve (12) awareness programs since 2016-17.\r\n"

						+ "b. Women Protection Cell (WPC): WPC, a UGC mandate, has been in existence since 2015.WPC comprises twelve faculty members with a Presiding Officer, one external member and ten members, with\r\n"
						+ "representation from all departments of college and is reconstituted every two years.WPC periodically\r\n"
						+ "meets and reviews the complaints received from Lady faculty and students (if any), in particular, cases\r\n"
						+ "involving harassment of women and addresses such cases, if any, as per statutory norms. WPC also\r\n"
						+ "conducts awareness workshops on preventive measures and has conducted sixteen (16) programs including\r\n"
						+ "eight (08) on preventive measures since 2016-17.c. Safety and Security of women: Women security personnel are recruited to support women faculty, staff\r\n"

						+ "and students. All prominent locations of the campus are under CCTV surveillance. Women have been provided with separate waiting rooms/sick rooms and telephone numbers of SHE-TEAMS of Hyderabad\r\n"
						+ "police, supporting them to instant/necessary help as and when needed." + " ",
				font5);
		// p13
		paragraph13criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph13criteria7);

		PdfPCell cell8 = new PdfPCell();
		cell8.setPadding(8);
		document.add(cell8);
		// table
		PdfPTable tablecriteria7 = new PdfPTable(2);
		tablecriteria7.setWidthPercentage(100f);

		/*
		 * com.lowagie.text.Font fontcriteria7 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontcriteria7.setColor(CMYKColor.BLACK);
		 */

		PdfPCell cell111criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
		PdfPCell cell112criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font3));
		PdfPCell cell1113criteria7 = new PdfPCell(new Paragraph("Annual gender sensitization action plan\r\n\r\n\r\n"));
		PdfPCell cell1114criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")));
		PdfPCell cell115criteria7 = new PdfPCell(new Paragraph("Specific facilities provided for women in terms\r\n"
				+ "of: a.Safety and security b.Counselling c.Common\r\n"
				+ "Rooms d. Day care center for young children e.\r\n" + "Any other relevant information/r/n/r/n"));
		PdfPCell cell116criteria7 = new PdfPCell(new Paragraph(""));

		tablecriteria7.addCell(cell111criteria7);
		tablecriteria7.addCell(cell112criteria7);
		tablecriteria7.addCell(cell1113criteria7);
		tablecriteria7.addCell(cell1114criteria7);
		tablecriteria7.addCell(cell115criteria7);
		tablecriteria7.addCell(cell116criteria7);
		tablecriteria7.setSpacingBefore(20f);
		tablecriteria7.setSpacingAfter(20f);

		document.add(tablecriteria7);


		PdfPCell cell4criteria7 = new PdfPCell();

		cell1criteria7.setPadding(5);
		document.add(cell4criteria7);

		// table1
		PdfPTable table1criteria7 = new PdfPTable(2);
		PdfPTable table1criteria71 = new PdfPTable(1);

		table1criteria7.setWidthPercentage(100f);
		table1criteria71.setWidthPercentage(100f);

		// com.lowagie.text.Font font1 =FontFactory.getFont(FontFactory.TIMES_ROMAN);
		// font1.setColor(CMYKColor.BLACK);

		PdfPCell cell113criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
		PdfPCell cell114criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell11104criteria7 = new PdfPCell(new Paragraph("Geotagged Photographs\r\n\r\n\r\n"));
		PdfPCell cell1117criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")));
		PdfPCell cell1190criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
		PdfPCell cell1191criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(2).getCriteria7FilePath() : "")));

		table1criteria7.addCell(cell113criteria7);
		table1criteria7.addCell(cell114criteria7);
		// table1.addCell(cell1113);
		table1criteria7.addCell(cell11104criteria7);
		table1criteria7.addCell(cell1117criteria7);
		table1criteria7.addCell(cell1190criteria7);
		table1criteria7.addCell(cell1191criteria7);

		PdfPCell cell071 = new PdfPCell(new Paragraph(
				"7.1.2	The Institution has facilities for alternate sources of energy and energy conservation measures\r\n"
						+ "\r\n" + "1.	Solar energy\r\n" + "2.	Biogas plant\r\n" + "3.	Wheeling to the Grid\r\n"
						+ "4.	Sensor-based energy conservation\r\n"
						+ "5.	Use of LED bulbs/ power efficient equipment\r\n" + "\r\n" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse712()
								: ""),
				font3));

		table1criteria71.addCell(cell071);

		table1criteria71.addCell(table1criteria7);

		table1criteria71.setSpacingBefore(20f);
		table1criteria71.setSpacingAfter(20f);

		document.add(table1criteria71);

		PdfPCell cell6criteria7 = new PdfPCell();
		cell6criteria7.setPadding(5);
		document.add(cell6criteria7);

		// 7.1.3
		/*
		 * Font fontParagraph2114 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2114.setSize(12);
		 */
		Paragraph paragraph16criteria7 = new Paragraph(
				"7.1.3 Describe the facilities in the Institution for the management of the following types of\r\n"
						+ "degradable and non-degradable waste (within 500 words)\r\n",
				font3);
		document.add(paragraph16criteria7);

		PdfPCell cell10 = new PdfPCell();
		cell10.setPadding(10);

		PdfPTable table713criteria7 = new PdfPTable(1);
		table713criteria7.setWidthPercentage(100f);

		/*
		 * com.lowagie.text.Font fontcriteria7 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontcriteria7.setColor(CMYKColor.BLACK);
		 */

		PdfPCell cell713criteria7 = new PdfPCell(new Paragraph(
				"7.1.3 Describe the facilities in the Institution for the management of the following types of degradable and non-degradable waste (within 500 words)\r\n"
						+ "\r\n"
						+ "Solid waste management Liquid waste management Biomedical waste management E-waste management\r\n"
						+ "Waste recycling system\r\n" + "Hazardous chemicals and radioactive waste management\r\n"
						+ "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse713()
								: ""),
				font3));

		table713criteria7.addCell(cell713criteria7);
		table713criteria7.setSpacingBefore(20f);
		table713criteria7.setSpacingAfter(20f);

		document.add(table713criteria7);

		/*
		 * Font fontParagraph2115 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2115.setSize(12);
		 */
		Paragraph paragraph17criteria7 = new Paragraph("Solid waste management\r\n" + "Liquid waste management\r\n"
				+ "Biomedical waste management\r\n" + "E-waste management\r\n" + "Waste recycling system\r\n"
				+ "Hazardous chemicals and radioactive waste management\r\n" + "\r\n" + "Response: ",
			
				font3);
		document.add(paragraph17criteria7);

		/*
		 * Font fontParagraph2116 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2116.setSize(12);
		 */
		Paragraph paragraph18criteria7 = new Paragraph(
				"Mother Teresa college of Engineering & Technology (GCET) believes in “Let’s go green and keep our\r\n"
						+ "campus clean”. GCET’s essential operations are highly sustainable and its efficient waste management\r\n"
						+ "processes ensure that generation of waste is kept to a minimum. Environment consciousness is embodied\r\n"
						+ "in the heart of the College by activities such as tree plantations from NSS/ NCC/Environmental Club\r\n"
						+ "volunteers every year. It not only maintains the aesthetics of the college but also promotes the vital motive\r\n"
						+ "of the management to provide a friendly atmosphere for the academic and non-academic activity.\r\n"
						+ "GCET is aware of and sensitive to segregating waste and proper disposal as per the mandated norms.\r\n"
						+ "The institute’s operations result in the generation of waste which can be broadly classified as:"
						+ "",
				font5);

		paragraph18criteria7.setAlignment(Paragraph.ALIGN_LEFT);
		PdfPCell cell13criteria7 = new PdfPCell();
		cell13criteria7.setPadding(5);
		document.add(paragraph18criteria7);
		/*
		 * Font fontParagraph2117 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2117.setSize(12);
		 */
		Paragraph paragraph19criteria7 = new Paragraph("1.Solid Waste\r\n" + "2.Liquid Waste \r\n" + "3.E-Waste",
				font3);
		document.add(paragraph19criteria7);
		/*
		 * Font fontParagraph2119 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2119.setSize(12);
		 */
		Paragraph paragraph20criteria7 = new Paragraph(
				"There is no generation of Hazardous chemicals and radioactive waste.\r\n"
						+ "Sanitary Incinerators are installed inside the campus to promote hygiene. \r\n"
						+ "The institution’s practices with regard to storage and disposal of waste are described below:"
						+ "\r\n",
				font5);
		paragraph20criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph20criteria7);

		// solid waste management
		/*
		 * Font fontParagraph2127 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2127.setSize(12);
		 */
		Paragraph paragraph21criteria7 = new Paragraph("Solid Waste Management:", font3);
		document.add(paragraph21criteria7);
		/*
		 * Font fontParagraph2129 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2129.setSize(12);
		 */
		Paragraph paragraph22criteria7 = new Paragraph(
				"The solid waste generated in the institution includes rubber tyres, metal scrap, paper, old newspapers, used\r\n"
						+ "papers and journal files: These are segregated, stored separately and given away to scrap\r\n"
						+ "dealers/vendors/recyclers. Apart from dry solid waste, food waste from canteens is collected by authorized\r\n"
						+ "agents for use as cattle feed. All the waste is disposed off in a safe and eco-friendly manner.Color coded\r\n"
						+ "waste collection Bins are placed on the college premises to collect solid waste." + "\r\n",
				font5);
		paragraph22criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph22criteria7);
		// liquidManagement
		/*
		 * Font fontParagraph2128 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2128.setSize(12);
		 */
		Paragraph paragraph23criteria7 = new Paragraph("Liquid Waste Management:", font3);
		document.add(paragraph23criteria7);
		/*
		 * Font fontParagraph2130 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2130.setSize(12);
		 */
		Paragraph paragraph24criteria7 = new Paragraph(
				"The liquid waste generated in the institution includes laboratory, and canteen effluent wastes. These are\r\n"
						+ "drained to a pit in distant open land. The laboratory waste water does not contain any hazardous chemicals.\r\n"
						+ "E-Waste Management: Electronic waste as created when an electronic product is discarded after the end\r\n"
						+ "of its useful life, which includes obsolete electronic devices, such as computer systems, servers, monitors,\r\n"
						+ "compact discs (CDs), printers, scanners, copiers, calculators, fax machines, battery cells etc.is handed over\r\n"
						+ "to an agency. The institution has adopted the following with the objective of creating an eco-friendly\r\n"
						+ "environment in the campus:\r\n"
						+ "1.Major E-waste such as written off computers, CRTs, printers are to be collected for safe disposal.\r\n"
						+ "2.All the miscellaneous e-waste such as CDs, batteries, PCBs, mice, key boards, printer cartridges are\r\n"
						+ "also collected for safe disposal.\r\n"
						+ "3.Re-filling of printer cartridges is carried out in a safe manner.\r\n"
						+ "4.UPS batteries are periodically inspected and recharged or repaired as necessary. Once they are\r\n"
						+ "dead, they are collected for safe disposal.",
				font5);
		paragraph24criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph24criteria7);

		// waste
		/*
		 * Font fontParagraph2131 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2131.setSize(12);
		 */
		Paragraph paragraph25criteria7 = new Paragraph("Waste Recycling", font3);
		document.add(paragraph25criteria7);
		paragraph25criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph2132 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2132.setSize(12);
		 */
		Paragraph paragraph26criteria7 = new Paragraph(
				"Old newspapers, used papers, journal files are collected by an agency which in turn recycles the waste\r\n"
						+ "paper for further use.",
				font5);
		document.add(paragraph26criteria7);
		// 7.1.4

		// creating table
		PdfPTable table2criteria7 = new PdfPTable(2);
		table2criteria7.setWidthPercentage(100);

		com.lowagie.text.Font font11 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font11.setColor(CMYKColor.BLACK);
		// Create table for header pdfcell cell= new pdf cell
		PdfPCell cell51criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
		PdfPCell cell52criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell0 = new PdfPCell();
		cell0.setPadding(5);
		PdfPCell cell53criteria7 = new PdfPCell(new Paragraph(
				"Relevant documents like agreements/MoUs with\r\n" + "Government and other approved agencies\r\n\r\n\r\n"));
		PdfPCell cell54criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(3).getCriteria7FilePath() : "")));
		PdfPCell cell55criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n\r\n "));
		PdfPCell cell56criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(4).getCriteria7FilePath() : "")));
		PdfPCell cell57criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n\r\n"));
		PdfPCell cell58criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(5).getCriteria7FilePath() : "")));
		PdfPCell cell59criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
		PdfPCell cell60criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(6).getCriteria7FilePath() : "")));

		table2criteria7.addCell(cell51criteria7);
		table2criteria7.addCell(cell52criteria7);
		table2criteria7.addCell(cell53criteria7);
		table2criteria7.addCell(cell54criteria7);
		table2criteria7.addCell(cell55criteria7);
		table2criteria7.addCell(cell56criteria7);
		table2criteria7.addCell(cell57criteria7);
		table2criteria7.addCell(cell58criteria7);
		table2criteria7.addCell(cell59criteria7);
		table2criteria7.addCell(cell60criteria7);
		table2criteria7.setSpacingBefore(20f);
		table2criteria7.setSpacingAfter(20f);

		document.add(table2criteria7);

		paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		// 7.14
		/*
		 * Font fontParagraph2138 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2138.setSize(12);
		 */
		/*
		 * Paragraph paragraph27criteria7 = new Paragraph(
		 * "7.1.4 Water conservation facilities available in the Institution: \r\n" +
		 * "1.Rain water harvesting\r\n" + "2.Borewell /Open well recharge\r\n" +
		 * "3.Construction of tanks and bunds\r\n" + "4.Waste water recycling\r\n" +
		 * "5.Maintenance of water bodies and distribution system in the campus" +
		 * "Reesponse:" + (criteria7Record != null ?
		 * criteria7Record.getResponseValue714() : ""), font3);
		 * document.add(paragraph27criteria7);
		 */

		PdfPTable table3criteria7 = new PdfPTable(2);
		PdfPTable table3criteria71 = new PdfPTable(1);
		table3criteria7.setWidthPercentage(100f);
		table3criteria71.setWidthPercentage(100f);

		/*
		 * com.lowagie.text.Font font12 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font12.setColor(CMYKColor.BLACK);
		 */

		PdfPCell cell61criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
		PdfPCell cell62criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));

		PdfPCell cell63criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n\r\n"));
		PdfPCell cell64criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(7).getCriteria7FilePath() : "")));

		PdfPCell cell65criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
		PdfPCell cell66criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(8).getCriteria7FilePath() : "")));

		table3criteria7.addCell(cell61criteria7);
		table3criteria7.addCell(cell62criteria7);
		table3criteria7.addCell(cell63criteria7);
		table3criteria7.addCell(cell64criteria7);
		table3criteria7.addCell(cell65criteria7);
		table3criteria7.addCell(cell66criteria7);

		PdfPCell cell072 = new PdfPCell(
				new Paragraph("7.1.4	Water conservation facilities available in the Institution:\r\n" + "\r\n"
						+ "1.	Rain water harvesting\r\n" + "2.	Borewell /Open well recharge\r\n"
						+ "3.	Construction of tanks and bunds\r\n" + "4.	Waste water recycling\r\n"
						+ "5.	Maintenance of water bodies and distribution system in the campus\r\n" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse714()
								: ""),
						font3));

		table3criteria71.addCell(cell072);

		table3criteria71.addCell(table3criteria7);

		table3criteria71.setSpacingBefore(20f);
		table3criteria71.setSpacingAfter(20f);

		document.add(table3criteria71);

		// 7.15
		/*
		 * Font fontParagraph2139 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2139.setSize(12);
		 */
		/*
		 * Paragraph paragraph28criteria7 = new
		 * Paragraph("7.1.5 Green campus initiatives include: \r\n" +
		 * "1.Restricted entry of automobiles \r\n" +
		 * "2.Use of Bicycles/ Battery powered vehicles\r\n" +
		 * "3.Pedestrian Friendly pathways\r\n" + "4.Ban on use of Plastic\r\n" +
		 * "5.landscaping with trees and plants\r\n" + "Response: " + (criteria7Record
		 * != null ? criteria7Record.getResponseValue715() : ""), font3);
		 * 
		 * document.add(paragraph28criteria7);
		 */

		// 7.15 table
		PdfPTable table6criteria7 = new PdfPTable(2);
		PdfPTable table6criteria72 = new PdfPTable(1);

		table6criteria7.setWidthPercentage(100f);
		table6criteria72.setWidthPercentage(100f);

		/*
		 * com.lowagie.text.Font font13 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font13.setColor(CMYKColor.BLACK);
		 */
		PdfPCell cell67criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
		PdfPCell cell68criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell69criteria7 = new PdfPCell(
				new Paragraph("Various policy documents / decisions circulated for\r\n\r\n\r\n" + "implementation"));
		PdfPCell cell70criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(9).getCriteria7FilePath() : "")));
		PdfPCell cell71criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n"));
		PdfPCell cell72criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(10).getCriteria7FilePath() : "")));

		PdfPCell cell73criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n"));
		PdfPCell cell74criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(11).getCriteria7FilePath() : "")));

		table6criteria7.addCell(cell67criteria7);
		table6criteria7.addCell(cell68criteria7);
		table6criteria7.addCell(cell69criteria7);
		table6criteria7.addCell(cell70criteria7);
		table6criteria7.addCell(cell71criteria7);
		table6criteria7.addCell(cell72criteria7);
		table6criteria7.addCell(cell73criteria7);
		table6criteria7.addCell(cell74criteria7);

		PdfPCell cell073 = new PdfPCell(new Paragraph("7.1.5	Green campus initiatives include:\r\n" + "\r\n"
				+ "1.	Restricted entry of automobiles\r\n" + "2.	Use of Bicycles/ Battery powered vehicles\r\n"
				+ "3.	Pedestrian Friendly pathways\r\n" + "4.	Ban on use of Plastic\r\n"
				+ "5.	landscaping with trees and plants\r\n" + "\r\n" + "Response:"
				+ (criteria7Record != null ? criteria7Record.getCriteria71Qn().get(0).getResponse715()
						: ""),
				font3));

		table6criteria72.addCell(cell073);

		table6criteria72.addCell(table6criteria7);

		table6criteria72.setSpacingBefore(20f);
		table6criteria72.setSpacingAfter(20f);

		document.add(table6criteria72);

		// 7.16
		// 7.16 table
		/*
		 * Font fontParagraph2140 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2140.setSize(12);
		 */
		/*
		 * Paragraph paragraph29criteria7 = new Paragraph(
		 * "7.1.6 Quality audits on environment and energy are regularly undertaken by the Institution and any\r\n"
		 * + "awards received for such green campus initiatives:\r\n" +
		 * "1.Green audit\r\n" + "2.Energy audit\r\n" + "3.Environment audit\r\n" +
		 * "4.Clean and green campus recognitions / awards\r\n" +
		 * "5.Beyond the campus environmental promotion activities \r\n" + "Response: "
		 * + (criteria7Record != null ? criteria7Record.getResponseValue716() : ""),
		 * font3); document.add(paragraph29criteria7);
		 */

		PdfPTable table15criteria7 = new PdfPTable(2);
		PdfPTable table15criteria73 = new PdfPTable(1);

		table15criteria7.setWidthPercentage(100f);
		table15criteria73.setWidthPercentage(100f);

		com.lowagie.text.Font font131 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font131.setColor(CMYKColor.BLACK);
		PdfPCell cell75criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n"));
		PdfPCell cell76criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n"));
		PdfPCell cell77criteria7 = new PdfPCell(
				new Paragraph("Reports on environment and energy audits\r\n" + "submitted by the auditing agency\r\n\r\n\r\n"));
		PdfPCell cell78criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(12).getCriteria7FilePath() : "")));
		PdfPCell cell79criteria7 = new PdfPCell(new Paragraph("Certification by the auditing agency\r\n\r\n\r\n"));
		PdfPCell cell80criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(13).getCriteria7FilePath() : "")));
		PdfPCell cell81criteria7 = new PdfPCell(new Paragraph("Certificates of the awards received\r\n\r\n\r\n"));
		PdfPCell cell82criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(14).getCriteria7FilePath() : "")));
		PdfPCell cell83criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
		PdfPCell cell84criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(15).getCriteria7FilePath() : "")));

		table15criteria7.addCell(cell75criteria7);
		table15criteria7.addCell(cell76criteria7);
		table15criteria7.addCell(cell77criteria7);
		table15criteria7.addCell(cell78criteria7);
		table15criteria7.addCell(cell79criteria7);
		table15criteria7.addCell(cell80criteria7);
		table15criteria7.addCell(cell81criteria7);
		table15criteria7.addCell(cell82criteria7);
		table15criteria7.addCell(cell83criteria7);
		table15criteria7.addCell(cell84criteria7);

		PdfPCell cell074 = new PdfPCell(new Paragraph(
				"7.1.6	Quality audits on environment and energy are regularly undertaken by the Institution and any awards received for such green campus initiatives:\r\n"
						+ "\r\n" + "1.	Green audit\r\n" + "2.	Energy audit\r\n" + "3.	Environment audit\r\n"
						+ "4.	Clean and green campus recognitions / awards\r\n"
						+ "5.	Beyond the campus environmental promotion activities\r\n" + "\r\n" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse716()
								: ""),
				font3));

		table15criteria73.addCell(cell074);

		table15criteria73.addCell(table15criteria7);

		table15criteria73.setSpacingBefore(20f);
		table15criteria73.setSpacingAfter(20f);

		document.add(table15criteria73);

		// 7.1.7
		/*
		 * Font fontParagraph2141 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2141.setSize(12);
		 */
		/*
		 * Paragraph paragraph30criteria7 = new Paragraph(
		 * "7.1.7 The Institution has disabled-friendly, barrier free environment \r\n"
		 * + "1.Built environment with ramps/lifts for easy access to classrooms.\r\n" +
		 * "2.Divyangjan friendly washrooms\r\n" +
		 * "3.Signage including tactile path, lights, display boards and signposts\r\n"
		 * +
		 * "4.Assistive technology and facilities for Divyangjan accessible website, screen-reading software,\r\n"
		 * + "mechanized equipment\r\n" +
		 * "5.Provision for enquiry and information : Human assistance, reader, scribe, soft copies of\r\n"
		 * + "reading material, screen reading\r\n" + "Response:" + (criteria7Record !=
		 * null ? criteria7Record.getResponseValue717() : ""), font3);
		 * document.add(paragraph30criteria7);
		 */
		// 7.1.7 table
		PdfPTable table17criteria7 = new PdfPTable(2);
		PdfPTable table17criteria73 = new PdfPTable(1);

		table17criteria7.setWidthPercentage(100f);
		table17criteria73.setWidthPercentage(100f);
		com.lowagie.text.Font font132 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font132.setColor(CMYKColor.BLACK);
		PdfPCell cell85criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n"));
		PdfPCell cell86criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n"));
		PdfPCell cell87criteria7 = new PdfPCell(
				new Paragraph("Policy documents and information brochures on the\r\n" + "support to be provided"));
		PdfPCell cell88criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(16).getCriteria7FilePath() : "")));
		PdfPCell cell89criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n\r\n"));
		PdfPCell cell90criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(17).getCriteria7FilePath() : "")));
		PdfPCell cell91criteria7 = new PdfPCell(
				new Paragraph("Details of the Software procured for providing the\r\n" + "assistance\r\n\r\n\r\n"));
		PdfPCell cell92criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(18).getCriteria7FilePath() : "")));
		PdfPCell cell93criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
		PdfPCell cell94criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(19).getCriteria7FilePath() : "")));

		table17criteria7.addCell(cell85criteria7);
		table17criteria7.addCell(cell86criteria7);
		table17criteria7.addCell(cell87criteria7);
		table17criteria7.addCell(cell88criteria7);
		table17criteria7.addCell(cell89criteria7);
		table17criteria7.addCell(cell90criteria7);
		table17criteria7.addCell(cell91criteria7);
		table17criteria7.addCell(cell92criteria7);
		table17criteria7.addCell(cell93criteria7);
		table17criteria7.addCell(cell94criteria7);

		PdfPCell cell075 = new PdfPCell(
				new Paragraph("7.1.7	The Institution has disabled-friendly, barrier free environment\r\n" + "\r\n"
						+ "1.	Built environment with ramps/lifts for easy access to classrooms.\r\n"
						+ "2.	Divyangjan friendly washrooms\r\n"
						+ "3.	Signage including tactile path, lights, display boards and signposts\r\n"
						+ "4.	Assistive technology and facilities for Divyangjan accessible website, screen-reading software, mechanized equipment\r\n"
						+ "5.	Provision for enquiry and information : Human assistance, reader, scribe, soft copies of reading material, screen reading\r\n"
						+ "\r\n" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse717()
								: ""),
						font3));

		table17criteria73.addCell(cell075);

		table17criteria73.addCell(table17criteria7);

		table17criteria73.setSpacingBefore(20f);
		table17criteria73.setSpacingAfter(20f);

		document.add(table17criteria73);

		// 7.1.8
		/*
		 * Font fontParagraph2142 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2142.setSize(12);
		 */
		Paragraph paragraph31criteria7 = new Paragraph(
				"7.1.8 Describe the Institutional efforts/initiatives in providing an inclusive environment i.e., tolerance\r\n"
						+ "and harmony towards cultural, regional, linguistic, communal socioeconomic and other diversities\r\n"
						+ "(within 500 words)." + "Response: "
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse718()
								: ""),
				font3);
		document.add(paragraph31criteria7);

		PdfPTable table718criteria7 = new PdfPTable(1);
		table718criteria7.setWidthPercentage(100f);

		/*
		 * com.lowagie.text.Font fontcriteria7 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontcriteria7.setColor(CMYKColor.BLACK);
		 */

		PdfPCell cell718criteria7 = new PdfPCell(new Paragraph(
				"7.1.8 Describe the Institutional efforts/initiatives in providing an inclusive environment i.e., tolerance and harmony towards cultural, regional, linguistic, communal socioeconomic and other diversities (within 500 words)."
						+ "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse718()
								: ""),
				font3));

		table718criteria7.addCell(cell718criteria7);
		table718criteria7.setSpacingBefore(20f);
		table718criteria7.setSpacingAfter(20f);

		document.add(table718criteria7);

		/*
		 * Font fontParagraph2143 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2143.setSize(12);
		 */
		Paragraph paragraph32criteria7 = new Paragraph(
				"It is our conviction that curricular, co-curricular and extra-curricular (Games, sports, and cultural) activities\r\n"
						+ "play an important role in the emotional, cognitive and social development of the student community.\r\n"
						+ "Towards this end, Mother Teresa organizes several such events to promote various skills among students,\r\n"
						+ "awareness and importance of empathy-oriented compassion, cultural, regional, religious, linguistic and\r\n"
						+ "communal tolerance needed for practicing in a highly pluralistic society which ultimately has widespread\r\n"
						+ "socio-economic ramifications. Despite the individual characteristics and reservations that students may\r\n"
						+ "have, such events organized by the institution, strengthen unity among students and help in developing a\r\n"
						+ "spirit of consensus and cooperation through dialogue and team-activities.\r\n"
						+ "Mother Teresa has established several student clubs which have been promoting various activities to sensitize\r\n"
						+ "and play a vital role in promoting and building an inclusive environment in the institution.\r\n"
						+ "Fine arts club of Mother Teresa conducts Music competitions (both vocal and instrumental) for students.\r\n"
						+ "Music lovers among students with proficiency in Western, Classical (Carnatic and Hindustani) participate\r\n"
						+ "in these events, which facilitate harmony among students, respecting each other, also curates their\r\n"
						+ "associated culture. Students play skits and enact dramas with various themes such as mythological,\r\n"
						+ "historical and social. These activities conducted in different languages, and themes have been facilitating\r\n"
						+ "students to be aware of Indian, Western and other mythologies, history and socio-economic aspects,\r\n"
						+ "thereby developing a sense of tolerance towards various cultures across the globe.\r\n"
						+ "Students of Photography club of Mother Teresa exhibit their skills and talent displaying photos they have\r\n"
						+ "shot, depicting not only nature, but also the socio-economic divide between rural and urban India, as well\r\n"
						+ "as the huge chasm among people living in under-developed and developed countries. Such photographs\r\n"
						+ "and interactions facilitate students to enhance their emotional quotient and compassion leading to selfactualization. \r\n"
						+ "Mandatory courses in the curriculum, namely, Environmental science, Human Values and Professional\r\n"
						+ "Ethics (HVPE) help students in understanding the importance of environmental awareness, a deep rooted\r\n"
						+ "commiseration towards underprivileged sections of society leading to strong empathy facilitating\r\n"
						+ "sustainable development.\r\n"
						+ "Environmental club of the institution has been acting as a catalyst in furthering and promoting protection\r\n"
						+ "of environment, leading to peace, harmony and prosperity in the immediate society.\r\n"
						+ "Traditional days are observed in celebration of India’s diverse culture, wherein, faculty, staff and students\r\n"
						+ "wear traditional attire, symbolizing their home state, promote awareness of various cultures prevalent in\r\n"
						+ "Indian society and thus promote tolerance, inclusivity and cooperative living.\r\n"
						+ "Through its NSS unit, Mother Teresa celebrates National Festivals, Independence Day, Republic Day and\r\n"
						+ "commemoration days of eminent personalities by conducting Blood Donation camps, Orientation\r\n"
						+ "Programs, explaining the importance and benefits of community service involving faculty, staff and\r\n"
						+ "students. College also conducts several games, sports, debates, essay writing competitions on important\r\n"
						+ "National days, signifying their importance, wherein students participate in large numbers.\r\n"
						+ "Through all these activities, students are nurtured to exhibit tolerance and harmony towards various\r\n"

						+ "cultural, regional, linguistic, and communal diversities, and develop esprit de corps with compassion on\r\n"
						+ "socio-economic factors for a harmonious, peaceful and prosperous society, paving way for sustainable\r\n"
						+ "development",
				font5);
		paragraph32criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph32criteria7);

		// 7.1.8 table

		PdfPTable table18criteria7 = new PdfPTable(2);
		table18criteria7.setWidthPercentage(100f);
		com.lowagie.text.Font font133 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font133.setColor(CMYKColor.BLACK);
		PdfPCell cell95criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font3));
		PdfPCell cell96criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell97criteria7 = new PdfPCell(
				new Paragraph("Policy documents and information brochures on the\r\n" + "support to be provided"));
		PdfPCell cell98criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(20).getCriteria7FilePath() : "")));
		PdfPCell cell99criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities"));
		PdfPCell cell100criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(21).getCriteria7FilePath() : "")));
		PdfPCell cell101criteria7 = new PdfPCell(
				new Paragraph("Details of the Software procured for providing the" + "assistance\r\n\r\n\r\n"));
		PdfPCell cell102criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(22).getCriteria7FilePath() : "")));
		PdfPCell cell103criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
		PdfPCell cell104criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(23).getCriteria7FilePath() : "")));

		table18criteria7.addCell(cell95criteria7);
		table18criteria7.addCell(cell96criteria7);
		table18criteria7.addCell(cell97criteria7);
		table18criteria7.addCell(cell98criteria7);
		table18criteria7.addCell(cell99criteria7);
		table18criteria7.addCell(cell100criteria7);
		table18criteria7.addCell(cell101criteria7);
		table18criteria7.addCell(cell102criteria7);
		table18criteria7.addCell(cell103criteria7);
		table18criteria7.addCell(cell104criteria7);
		table18criteria7.setSpacingBefore(20f);
		table18criteria7.setSpacingAfter(20f);

		document.add(table18criteria7);

		/*
		 * // 7.1.9 Font fontParagraph2144 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2144.setSize(12);
		 */
		Paragraph paragraph33criteria7 = new Paragraph(
				"7.1.9 Sensitization of students and employees of the Institution to the constitutional obligations:\r\n"
						+ "values, rights, duties and responsibilities of citizens (within 500 words).\r\n"

						+ "Response: "
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse719()
								: ""),
				font3);
		document.add(paragraph33criteria7);

		PdfPTable table719criteria7 = new PdfPTable(1);
		table719criteria7.setWidthPercentage(100f);

		/*
		 * com.lowagie.text.Font fontcriteria7 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontcriteria7.setColor(CMYKColor.BLACK);
		 */

		PdfPCell cell719criteria7 = new PdfPCell(new Paragraph(
				"7.1.9 Sensitization of students and employees of the Institution to the constitutional obligations: values, rights, duties and responsibilities of citizens (within 500 words).\r\n"
						+ "\r\n" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse719()
								: ""),
				font3));

		table719criteria7.addCell(cell719criteria7);
		table719criteria7.setSpacingBefore(20f);
		table719criteria7.setSpacingAfter(20f);

		document.add(table719criteria7);

		/*
		 * Font fontParagraph2145 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2145.setSize(12);
		 */
		Paragraph paragraph34criteria7 = new Paragraph(
				"Mother Teresa strongly believes in Maslow’s theory of motivation, which at its highest level of pyramid\r\n"
						+ "specifies “Self-Actualization”, that the purpose of human existence is to serve mankind. Towards this, we\r\n"
						+ "consider education in general, higher education in particular, should facilitate realization of human\r\n"
						+ "potential by making students, teachers, and higher educational administrators, conscious of human values\r\n"
						+ "and societal development, so as to transform them into future ready global citizens.\r\n"
						+ "Mother Teresa involves students in activities pertaining to strengthening core values, making them aware of\r\n"
						+ "their rights, duties and responsibilities and help them in becoming responsible citizens.\r\n"
						+ "/r/n",
				font5);
		document.add(paragraph34criteria7);
		/*
		 * Font fontParagraph2146 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2146.setSize(12);
		 */
		Paragraph paragraph35criteria7 = new Paragraph("Values: " + "/r/n", font3);
		document.add(paragraph35criteria7);
		/*
		 * Font fontParagraph2147 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2147.setSize(12);
		 */
		Paragraph paragraph36criteria7 = new Paragraph(
				"Towards this, Mother Teresa has been organizing blood donation (611units of Blood), free vaccination and\r\n"
						+ "medical camps through student volunteers, giving infrastructural support for the physically challenged\r\n"
						+ "(through ramps, lifts, large washrooms, wheel chair facility etc).\r\n"
						+ "We believe that human values may be innate as well as acquired. When we have love, compassion and a\r\n"
						+ "willingness to sacrifice our interests for others, it becomes a service. Values are to be learnt through\r\n"
						+ "practices. Hence, Mother Teresates are made to remind that they are being watched and observed by peers and\r\n"
						+ "conduct themselves as role models for others. Inculcation of Human Values is demonstrated first by\r\n"
						+ "teacher, later imbibed by students. Faculty participate in Universal Human Values programs sponsored by\r\n"
						+ "AICTE.\r\n"
						+ "Courses on “Human Values and Professional Ethics” and “Indian Ethos” delivered through YouTube\r\n"
						+ "videos, real life examples, case studies and anecdotes are presented giving rise to various perspectives on\r\n"
						+ "situations in life, creating an everlasting impression on student’s mind, touching student’s heart, bringing\r\n"
						+ "a paradigm shift in their thought process towards life. They are largely instrumental in bringing integrity,\r\n"
						+ "competence and building a stronger character",
				font5);
		document.add(paragraph36criteria7);
		/*
		 * Font fontParagraph2148 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2148.setSize(12);
		 */
		Paragraph paragraph37criteria7 = new Paragraph(
				"Rights, Duties and responsibilities of citizens:\r\n" + " " + "/r/n", font5);
		document.add(paragraph37criteria7);
		Font fontParagraph2149 = FontFactory.getFont(FontFactory.HELVETICA);
		fontParagraph2149.setSize(12);
		Paragraph paragraph38criteria7 = new Paragraph(
				"The college offers a mandatory audit course on Indian Constitution which deals with fundamental rights\r\n"
						+ " and responsibilities of citizens. College organizes programs which drives home the point that rights are\r\n"
						+ "always associated with responsibilities and are mutually linked to one another.\r\n"
						+ "Formal and informal, co-curricular and extra-curricular activities facilitate students to assume higher\r\n"
						+ "responsibility, thereby rising to the occasion with goals oriented towards societal development. Students\r\n"
						+ "develop an attitude to look at every challenge as an opportunity to improve or innovate for societal\r\n"
						+ "benefits. \r\n"
						+ "Student mentoring is a well-designed and planned activity wherein the student is continuously supported\r\n"
						+ "and guided focusing on building student’s character, with an objective of making student behave as a\r\n"
						+ "responsible citizen. \r\n"
						+ "The college has been facilitating holistic development of students towards a more balanced life, profession\r\n"
						+ "and happiness, by encouraging them to interact with a galaxy of personalities from various walks of life.\r\n"
						+ "We have been organizing technical symposia, project exhibitions, activities through student clubs,\r\n"
						+ "celebrations of national and international commemorative days, events and festivals promoting holistic\r\n"
						+ "development of students thereby making them become not only technically sound professionals\r\n"
						+ "contributing to technological advancements, and growth of the economy, but also become “Good Global\r\n"
						+ "Citizens” promoting peace and harmony in the Society for sustainable development of mankind"
						+ " " + "/r/n",
				font5);
		paragraph38criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph38criteria7);
		// 7.1.1.9 table
		PdfPTable table19criteria7 = new PdfPTable(2);
		table19criteria7.setWidthPercentage(100f);
		com.lowagie.text.Font font134 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font134.setColor(CMYKColor.BLACK);
		PdfPCell cell105criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
		PdfPCell cell106criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell107criteria7 = new PdfPCell(new Paragraph(" Details of activities that inculcate values;\r\n"
				+ "necessary to render students in to responsible\r\n" + "citizens\r\n\r\n"));
		PdfPCell cell108criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(24).getCriteria7FilePath() : "")));

		PdfPCell cell109criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
		PdfPCell cell110criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(25).getCriteria7FilePath() : "")));

		table19criteria7.addCell(cell105criteria7);
		table19criteria7.addCell(cell106criteria7);
		table19criteria7.addCell(cell107criteria7);
		table19criteria7.addCell(cell107criteria7);
		table19criteria7.addCell(cell108criteria7);
		table19criteria7.addCell(cell109criteria7);
		table19criteria7.addCell(cell110criteria7);
		table19criteria7.setSpacingBefore(20f);
		table19criteria7.setSpacingAfter(20f);
		document.add(table19criteria7);

		
		// 7.1.10 table

		PdfPTable table31criteria7 = new PdfPTable(2);
		PdfPTable table31criteria74 = new PdfPTable(1);

		table31criteria7.setWidthPercentage(100);
		table31criteria74.setWidthPercentage(100);

		com.lowagie.text.Font font112 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font112.setColor(CMYKColor.BLACK);
		PdfPCell cell1111 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n"));
		PdfPCell cell1112 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n"));
		PdfPCell cell11113 = new PdfPCell(new Paragraph(
				" Details of the monitoring committee composition and minutes of the committee meeting, number of\r\n"

						+ "programmes organized, reports on the various\r\n"
						+ "programs etc., in support of the claims\r\n\r\n\r\n"));
		PdfPCell cell11114 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(26).getCriteria7FilePath() : "")));

		PdfPCell cell1115 = new PdfPCell(new Paragraph("Code of ethics policy document\r\n\r\n\r\n"));
		PdfPCell cell1116 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(27).getCriteria7FilePath() : "")));

		PdfPCell cell11117 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
		PdfPCell cell1118 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(28).getCriteria7FilePath() : "")));

		table31criteria7.addCell(cell1111);// 7.1.10 table
		table31criteria7.addCell(cell1112);
		table31criteria7.addCell(cell11113);
		table31criteria7.addCell(cell11114);
		table31criteria7.addCell(cell1115);
		table31criteria7.addCell(cell1116);
		table31criteria7.addCell(cell11117);
		table31criteria7.addCell(cell1118);

		PdfPCell cell076 = new PdfPCell(new Paragraph(
				"7.1.10 The Institution has a prescribed code of conduct for students, teachers, administrators and other staff and conducts periodic programmes in this regard.\r\n"
						+ "\r\n" + "1.	The Code of Conduct is displayed on the website\r\n"
						+ "2.	There is a committee to monitor adherence to the Code of Conduct\r\n"
						+ "3.	Institution organizes professional ethics programmes for students, teachers, administrators and other staff\r\n"
						+ "4.	Annual awareness programmes on Code of Conduct are organized\r\n" + "\r\n"
						+ "Response:\r\n"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse7110()
								: ""),
				font3));

		table31criteria74.addCell(cell076);

		table31criteria74.addCell(table31criteria7);

		table31criteria74.setSpacingBefore(20f);
		table31criteria74.setSpacingAfter(20f);

		document.add(table31criteria74);

		// paragraph //7.1.11
		/*
		 * Font fontParagraph2151 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2151.setSize(12);
		 */
		Paragraph paragraph40criteria7 = new Paragraph(
				"7.1.11 Institution celebrates / organizes national and international commemorative days, events and\r\n"
						+ "festivals (within 500 words).\r\n" + "" + "Response: "
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse7111()
								: ""),
				font3);
		//
		document.add(paragraph40criteria7);

		PdfPTable table7111criteria7 = new PdfPTable(1);
		table7111criteria7.setWidthPercentage(100f);

		/*
		 * com.lowagie.text.Font fontcriteria7 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontcriteria7.setColor(CMYKColor.BLACK);
		 */

//		PdfPCell cell7111criteria7 = new PdfPCell(new Paragraph(
//				"7.1.11 Institution celebrates / organizes national and international commemorative days, events and festivals (within 500 words).\r\n"
//						+ "\r\n" + "Response:"
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria71Qn().get(0).getResponse7111()
//								: ""),
//				font3));

	//	table7111criteria7.addCell(cell7111criteria7);
		table7111criteria7.setSpacingBefore(20f);
		table7111criteria7.setSpacingAfter(20f);

		document.add(table7111criteria7);

		// paragraph //
		/*
		 * Font fontParagraph2152 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2152.setSize(12);
		 */
		Paragraph paragraph41criteria7 = new Paragraph(
				"The vibrant student clubs, and other units of the college celebrate several National and International\r\n"
						+ "commemorative days, events and festivals. The gaiety of all Festivals, both National and International are\r\n"
						+ "celebrated enthusiastically keeping in mind the traditions of the Indian Diaspora and Environmental\r\n"
						+ "Protection. The jubilations encourage in sensitizing the young minds to foster a spirit of Multiculturalism.\r\n"
						+ "Snippets of a few events celebrated are given hereunder:",
				font5);
		document.add(paragraph41criteria7);
		// a.int
		/*
		 * Font fontParagraph2153 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2153.setSize(12);
		 */
		Paragraph paragraph42criteria7 = new Paragraph("A: International-level commemorative days celebrated:\r\n",
				font3);
		document.add(paragraph42criteria7);
		// paragraph
		/*
		 * Font fontParagraph2154 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2154.setSize(12);
		 */
		Paragraph paragraph43criteria7 = new Paragraph(
				"World Environmental Day(June 5). The Environmental Club of the college systematically hosts\r\n"
						+ "programs to enlighten the students about restoration and protection of Nature for environmental\r\n"
						+ "sustainability through Tree Plantations and “Save Energy” campaign. Special drives, namely, Haritha\r\n"
						+ "Haram, making Eco-friendly Vinayaks, Earth Day etc. are organized. Young engineers share their thoughts\r\n"
						+ "in Debates, Essay Writing, Group Discussions, Poster Presentation and Slogan Writing Competitions held\r\n"
						+ "during these celebrations.\r\n"
						+ "International Women’s Day(March 8). The tremendous Women Power is honored on International\r\n"
						+ "Women’s Day in tune with the global celebrations. Students are sensitized to “Gender equality” through\r\n"
						+ "some short video presentations. Successful women from all fields are invited to inspire the young minds.\r\n"
						+ "International Yoga Day(June 21). Students are motivated to live up to the legacy of our culture. Eminent\r\n"
						+ "Yoga instructors are invited to guide the participants to practice the asanas and lead healthy and joyful life.\r\n"
						+ "Yoga competitions are conducted for faculty and students. \r\n"
						+ "World Photography Day(August 19). The Photography Club of the college plays an active role in\r\n"
						+ "organizing this day annually. The budding engineers share their best photographic shots and celebrate this\r\n"
						+ "day by exhibiting the same.",
				font5);
		document.add(paragraph43criteria7);
		// B: National-level commemorative days celebrated:
		/*
		 * Font fontParagraph2155 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2155.setSize(12);
		 */
		Paragraph paragraph44criteria7 = new Paragraph("B: National-level commemorative days celebrated:\r\n" + "\r\n",
				font5);
		document.add(paragraph44criteria7);
		// paragraph
		/*
		 * Font fontParagraph2156 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2156.setSize(12);
		 */
		Paragraph paragraph45criteria7 = new Paragraph(
				"Independence Day(August 15) and Republic Day(January 26). The campus echoes with music\r\n"
						+ "professing the sacrifices made by our freedom fighters to instill and ignite a spirit of patriotism in the\r\n"
						+ "young minds. Tributes are paid to people behind the framing of our Constitution and its ethos are shared\r\n"
						+ "Page 112/129 13-08-2022 02:30:33\r\n"
						+ "through some inspiring speeches and celebrations. We conduct events commemorating sacrifices of great\r\n"
						+ "personalities.\r\n"
						+ "National Science Day (February 28). Vaisheshika - Science Day is celebrated to pay homage of our\r\n"
						+ "country’s first Nobel laureate in Science, Sir CV Raman, to inculcate the scientific temper in young minds.\r\n"
						+ "To this end, an exhibition is conducted, wherein, students participate in large numbers and demonstrate\r\n"
						+ "Working/Demo Models, Poster Presentations, etc.\r\n"
						+ "National Mathematics Day (December 22). Commemorating the birth anniversary of mathematical\r\n"
						+ "legend Sri Srinivasa Ramanujan to promote analytical and logical reasoning skills, quizzes, Advanced\r\n"
						+ "Sudoku, Rubik’s Cube competitions are conducted.\r\n"
						+ "Teacher’s Day (September 5). The Birth Anniversary of Dr. S. Radhakrishnan, is celebrated as Teacher’s\r\n"
						+ "Day, with great enthusiasm. Students express their deep sense of gratitude on Teachers’ contribution for\r\n"
						+ "the cause of education through anecdotes.\r\n"
						+ "Engineer’s Day (September 15). The Birth Anniversary of Sir Mokshagundam Vishveswaraya is\r\n"
						+ "celebrated as Engineer’s Day. Various competitions are held for students offering an opportunity to\r\n"
						+ "showcase their Engineering Skills through the Projects they have executed. The philosophy is to motivate\r\n"
						+ "young budding Engineers to emulate Sir Vishveswaraya, lauding his service to our city-Hyderabad"
						+ "/r/n",
				font5);
		document.add(paragraph45criteria7);

		// table 4
		PdfPTable table4criteria7 = new PdfPTable(2);
		table4criteria7.setWidthPercentage(100);

		com.lowagie.text.Font font14 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font14.setColor(CMYKColor.BLACK);
		PdfPCell cell1119criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
		PdfPCell cell1120criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell1121criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of some of the events\r\n\r\n\r\n"));
		PdfPCell cell1122criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(29).getCriteria7FilePath() : "")));

		PdfPCell cell1123criteria7 = new PdfPCell(new Paragraph(
				"Annual report of the celebrations and\r\n" + "commemorative events for the last five years\r\n\r\n\r\n"));
		PdfPCell cell1124criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(30).getCriteria7FilePath() : "")));

		table4criteria7.addCell(cell1119criteria7);
		table4criteria7.addCell(cell1120criteria7);
		table4criteria7.addCell(cell1121criteria7);
		table4criteria7.addCell(cell1122criteria7);
		table4criteria7.addCell(cell1123criteria7);
		table4criteria7.addCell(cell1124criteria7);

		table4criteria7.setSpacingBefore(20f);
		table4criteria7.setSpacingAfter(20f);

		document.add(table4criteria7);

		// 7.2 Best Practices
		/*
		 * Font fontParagraph2157 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2157.setSize(13);
		 */
		Paragraph paragraph46criteria7 = new Paragraph("7.2 Best Practices\r\n"

				, font3);
		document.add(paragraph46criteria7);

		PdfPTable table721criteria7 = new PdfPTable(1);
		table721criteria7.setWidthPercentage(100f);

		/*
		 * com.lowagie.text.Font fontcriteria7 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontcriteria7.setColor(CMYKColor.BLACK);
		 */

		PdfPCell cell721criteria7 = new PdfPCell(new Paragraph(
				"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format provided in the Manual.\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria72Ql().get(0).getResponse721()
								: ""),
				font3));

		table721criteria7.addCell(cell721criteria7);
		table721criteria7.setSpacingBefore(20f);
		table721criteria7.setSpacingAfter(20f);

		document.add(table721criteria7);

		// 7.2.1
		/*
		 * Font fontParagraph2159 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2159.setSize(12);
		 */
		Paragraph paragraph48criteria7 = new Paragraph(
				"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format\r\n"
						+ "provided in the Manual.\r\n" + "\r\n" + "Response: \r\n" + "\r\n"
						+ "Best Practice No. I:\r\n" + "\r\n" + "Title of the practice:\r\n" + "\r\n"
						+ "“Reduced class strength for improved student learning and employability”\r\n" + "\r\n"
						+ "Objectives of the Practice" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria72Ql().get(0).getInput721t1()
								: ""),
				font3);
		document.add(paragraph48criteria7);
		/*
		 * Font fontParagraph2160 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2160.setSize(12);
		 */
		Paragraph paragraph49criteria7 = new Paragraph("Enhance student-teacher interactions in labs/classes\r\n"
				+ "Quicker feedback as faculty devote more time assessing students’ assignments, laboratory/project\r\n"
				+ "work/tutorials for improved performance.\r\n"

				+ "Enhanced learning experience through increased one to one participation among students and with\r\n"
				+ "faculty, especially in labs/tutorial sessions\r\n"
				+ "More opportunities to learn from peers, augmenting collaborative and cooperative learning\r\n"
				+ "More discipline and control over the class leading to increased student engagement\r\n"
				+ "With increased interaction among classmates, students gain quality learning experience."

				, font5);
		document.add(paragraph49criteria7);
//						
		/*
		 * Font fontParagraph2165 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2165.setSize(12);
		 */

		Paragraph paragraph51criteria7 = new Paragraph("Facilitate:", font3);
		document.add(paragraph51criteria7);

		/*
		 * Font fontParagraph2167 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2167.setSize(12);
		 */

		Paragraph paragraph52criteria7 = new Paragraph(
				"Comfortable seating arrangements\r\n" + "Improved Elbow-room to better manoeuvrability\r\n"
						+ "Improved personal space\r\n" + "Better Student to Faculty ratio\r\n"
						+ "enabling higher levels of student focus, eventually leading to improved performance.",
				font5);
		document.add(paragraph52criteria7);

		/*
		 * Font fontParagraph2166 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2166.setSize(12);
		 */

		Paragraph paragraph53criteria7 = new Paragraph("The Context" + "/r/n", font3);
		document.add(paragraph53criteria7);

		/*
		 * Font fontParagraph2168 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2168.setSize(12);
		 */

		Paragraph paragraph54criteria7 = new Paragraph(
				"“When classes are small enough to allow individual student-teacher interaction, a minor miracle\r\n"
						+ "occurs: Teachers teach and students learn”",
				font3);
		document.add(paragraph54criteria7);

		/*
		 * Font fontParagraph2169 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2169.setSize(12);
		 */

		Paragraph paragraph55 = new Paragraph("– Lou Anne Johnson, teacher whose life inspired the movie,\r\n"
				+ "“Dangerous Minds”\r\n"
				+ "Of late, it has been observed that students’ focus and attention span is waning due to various factors:\r\n"
				+ "digital media/technology, nuclear families leading to majority of students needing personal attention and\r\n"
				+ "many such others.\r\n"
				+ "Further, adolescence, acting as a catalyst, has necessitated need for ebhanced individual attention.\r\n"
				+ "In this context, faculty need to understand student psychology, enable learning through close monitoring,\r\n"
				+ "actively engaging, promoting originality/creativity, innovation, inculcating high-level analytical/logical\r\n"
				+ "thinking skills, leading a path to exploration and providing quicker feedback on learning. This also\r\n"
				+ "facilitates learner-centric approach, can be better put into practice, with smaller class sizes than larger ones.\r\n"
				+ "Incidentally, effective mentoring of student can be conducted making student realize his/her true potential\r\n"
				+ "leading to higher levels of performance." + "r/n", font5);

		document.add(paragraph55);

		/*
		 * Font fontParagraph2170 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2170.setSize(12);
		 */

		Paragraph paragraph56 = new Paragraph("The Practice" + "/r/n", font3);
		document.add(paragraph56);
		/*
		 * Font fontParagraph2171 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2171.setSize(12);
		 */

		Paragraph paragraph57 = new Paragraph(
				"A few of our faculty who have studied and worked in universities abroad, have experienced that\r\n"
						+ "coursework in a class with smaller number of students is congenial for reaching out to the needs of\r\n"
						+ "students, ensuring greater individualization of instruction, better classroom control and, thus, better\r\n"
						+ "learning ambience. Instructors have individual interactions with students, consulting with parents, giving\r\n"
						+ "greater attention to students’ work. Class size is an important determinant of student outcomes.\r\n"
						+ "Keeping this in view, in CSE and ECE classes, each section having 240 students, we have reduced the\r\n"
						+ "class strength to 45-48 students per section instead of the normal 60 -66 students.\r\n"
						+ "Towards this, departments have identified the requirement of additional faculty and infrastructure facilities.\r\n"
						+ "Accordingly, the institution has recruited more faculty, and increased infrastructure facilities. This practice\r\n"
						+ "has been adopted starting with the admitted batch of 2016-17 academic year soon after the college was\r\n"

						+ "granted autonomous status.\r\n"
						+ "Our classes have three-seater benches with six rows and four columns, capable of accommodating 72\r\n"
						+ "students. However, we have ensured that the middle seat in each bench is kept vacant ensuring that\r\n"
						+ "students have a more comfortable seating comfort needed since students spend nearly 6/7 hours a day. This\r\n"
						+ "also ensures adequate social distancing, especially required during the pandemic and beyond. It also\r\n"
						+ "reduces cross-talk, thereby noise in the classroom, thereby ensuring better class-room\r\n"
						+ "management. Reduced class size also benefits slow learners and disadvantaged students hailing from rural\r\n"
						+ "background" + "/r/n",
				font5);
		document.add(paragraph57);

		/*
		 * Font fontParagraph2172 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2172.setSize(12);
		 */

		Paragraph paragraph58 = new Paragraph("Consequences:" + "/r/n", font3);
		document.add(paragraph58);

		/*
		 * Font fontParagraph2173 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2173.setSize(12);
		 */

		Paragraph paragraph59 = new Paragraph(
				"Nearly 25% of faculty have been increased in CSE and ECE departments and the expenditure on salaries\r\n"
						+ "also have increased by 1.5 crore rupees/year. Over and above, operational expenditure on labs, in terms of\r\n"
						+ "consumables, equipment maintenance and repair, and electricity charges has increased.Expenditure on\r\n"
						+ "civil infrastructure and class room furniture also increased, for which budgetary provisions have been made\r\n"
						+ "and approved by the college." + "\r\n",
				font5);
		document.add(paragraph59);

		/*
		 * Font fontParagraph2175 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2175.setSize(12);
		 */

		Paragraph paragraph60 = new Paragraph("Evidence of Success \r\n"
				+ "Ever since the academic year 2016-17, class size kept as 45-48, our graduate outcomes have\r\n"
				+ "improved. More students have been participating in co-curricular activities, namely,\r\n"
				+ "Project/Problem-based learning, paper/poster presentations, creative/innovative activities,\r\n"
				+ "Hackathons, programming contests and student club activities leading to increased campus\r\n"
				+ "placements with higher pay package. \r\n"
				+ "Students have designed and built several prototypes, developing", font5);
		document.add(paragraph60);

		/*
		 * Font fontParagraph2176 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2176.setSize(12);
		 */

		Paragraph paragraph61 = new Paragraph("collaborative/cooperative learning in\r\n"
				+ "groups, discussing ideas, exchanging views/thoughts and listening to ideas of others with open mind\r\n"
				+ "resulted in Mother Teresa securing a rank of 4 STAR in MHRD-IIC, EXCELLENT band in ARIIA and few\r\n"
				+ "start-ups.", font5);
		document.add(paragraph61);

		/*
		 * Font fontParagraph2177 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2177.setSize(12);
		 */

		Paragraph paragraph62 = new Paragraph(
				"Reduction in class size also facilitated reduced workload on teachers as they need to mentor, assess\r\n"
						+ "lesser number of students’ work, resulting in teacher spending quality time ensuring better and\r\n"
						+ "improved learning experience for students leading to enhanced graduate outcomes and\r\n"
						+ "employability. \r\n" + "\r\n" + "Problems Encountered and Resources Required",
				font5);
		document.add(paragraph62);

		/*
		 * Font fontParagraph2178 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2178.setSize(12);
		 */

		Paragraph paragraph63 = new Paragraph(
				"Implemented smaller class sizes in CE, EEE and ME, also for one academic year. Unfortunately,\r\n"
						+ "admissions in these are low in first year. However, lateral entry students join in second year, filling vacant\r\n"
						+ "seats of first year. While reducing class size, increasing sections in second year, distribution of students in\r\n"
						+ "order of merit/skills into another section needed students grouped earlier to be divided further. Parents and\r\n"
						+ "students complained as students by then have developed rapport/friendship with some and were reluctant\r\n"
						+ "to move. Hence, discontinued this in these disciplines.\r\n"
						+ "Identifying and recruiting senior teachers, especially, domain experts in emerging areas of CSE, as several\r\n"
						+ "colleges simultaneously started the same. Requires extensive training of existing faculty as well\r\n"
						+ "as recruiting faculty available. \r\n" + "Page 115/129 13-08-2022 02:30:33\r\n"
						+ "More Infrastructure, more faculty required, especially, senior teachers for second- and third-year classes\r\n"
						+ "requiring more financial resources. Unfortunately, additional faculty salary is not considered while fixing\r\n"
						+ "tuition fee by Government." + "/r/n",
				font5);
		document.add(paragraph63);

		/*
		 * Font fontParagraph2179 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2179.setSize(12);
		 */

		Paragraph paragraph64 = new Paragraph("Notes (Optional)\r\n" + "", font3);
		document.add(paragraph64);

		/*
		 * Font fontParagraph2180 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2180.setSize(12);
		 */

		Paragraph paragraph65 = new Paragraph(
				"It is suggested that other colleges may choose to adopt this practice in a stepwise manner, initially in the\r\n"
						+ "departments in which strong faculty are available, carving a niche for the department, and then extend it to\r\n"
						+ "other departments as this practice not only enhances overall skill set of students but also promotes a culture\r\n"
						+ "of innovative spirit which in the long run may result in the establishment of many start-ups for promoting\r\n"
						+ "Atmanirbhar/Make in India movement for sustainable development." + "/r/n" + "/r/n",
				font5);
		document.add(paragraph65);

		/*
		 * Font fontParagraph2181 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2181.setSize(12);
		 */

		Paragraph paragraph66 = new Paragraph("Best practice No. II:\r\n" + "Title of the practice\r\n"
				+ "Decentralized departmental administration for improved scholarly academic/research\r\n"
				+ "Objectives of the Practice" + "/r/n", font5);
		document.add(paragraph66);

		/*
		 * Font fontParagraph2185 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2185.setSize(12);
		 */

		Paragraph paragraph67criteria7 = new Paragraph(
				"Mother Teresa passionately believes that faculty is at the heart of all its Teaching-learning operations.\r\n"
						+ "Attitudes of the teachers lie at the epicenter of significant innovation in education. The beliefs,\r\n"
						+ "assumptions, and feelings of our teachers are the crux of our learning environment, thereby determining the\r\n"
						+ "quality of life for students:"
						// bullet
						+ "Faculty development through a healthy mentor-mentee relationship\r\n"
						+ "More learning opportunities for faculty, facilitating career progression\r\n"
						+ "Ease of administration and functioning of department through decentralization\r\n"
						+ "Establishment of second rung leadership in various specializations\r\n"
						+ "Quality learning experience for students and faculty with satisfaction\r\n"
						+ "Better resource managemen\r\n",
				font5);
		document.add(paragraph67criteria7);

		/*
		 * Font fontParagraph2186 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2186.setSize(12);
		 */

		Paragraph paragraph68 = new Paragraph("The Context\r\n");
		document.add(paragraph68);

		/*
		 * Font fontParagraph2187 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2187.setSize(12);
		 */

		Paragraph paragraph69 = new Paragraph(
				"Higher pay packages in industry luring the cream of young talent resulting mostly in less talented\r\n"
						+ "professionals opting for teaching. Further, enormous increase in number of institutions, increased\r\n"
						+ "divergency in many fields, resulting in more super specializations due to fast changing technological\r\n"
						+ "advancements, lead to requirement for creation of good talent among professionals opting for teaching, by\r\n"
						+ "nurturing them on nuances of teaching, being creative, innovative and updating themselves through\r\n"
						+ "research. Meeting these challenges, Mother Teresa has structured each department into four/five\r\n"
						+ "specializations with one senior faculty, a few more middle level faculty as mentors and four/five junior\r\n"
						+ "faculty as mentees. In doing so, addressed a few teething problems.\r\n"
						+ "Time constraint: Each faculty member has fixed workload. Fruitful discussions between mentormentee, call for allotted common free time during/after working hours making this an onerous task.\r\n"
						+ "Apprehensions of faculty regarding exposure of their weaknesses, if any:");
		document.add(paragraph69);

		/*
		 * Font fontParagraph2188 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2188.setSize(12);
		 */

		Paragraph paragraph70 = new Paragraph("The Practice", font3);
		document.add(paragraph70);

		/*
		 * Font fontParagraph2189 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2188.setSize(12);
		 */

		Paragraph paragraph71 = new Paragraph(
				"Each department is structured into four/five groups as per specializations.\r\n"
						+ "Each group is led by a professor (Group Head) in the corresponding specialization, with 2/3 well\r\n"
						+ "experienced faculty identified as lead faculty.\r\n"
						+ "Group Head along with lead faculty act as Mentors for other faculty of the group, interacting closely,\r\n"
						+ "guiding them in their academic and research pursuits.\r\n",
				font5);
		document.add(paragraph71);

		/*
		 * Font fontParagraph2190 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2190.setSize(12);
		 */

		Paragraph paragraph72 = new Paragraph("Facilitating quality teaching/r/n", font3);
		document.add(paragraph72);

		/*
		 * Font fontParagraph2191 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2191.setSize(12);
		 */

		Paragraph paragraph73 = new Paragraph(
				"Group head along with lead faculty meets mentee faculty at least twice a week and discusses with them on\r\n"
						+ "preparation of a good lesson plan, establishing creative and innovative experiments, projects, giving handson exposure to students, conduct of student mentoring and use of modern tools, to name a few. Group head\r\n"
						+ "also suggests faculty to attend FDPs/FIPs/workshops, Lectures of eminent teachers within/outside the\r\n"
						+ "college in order to understand and practice various pedagogies.\r\n" + "",
				font5);
		document.add(paragraph73);

		/*
		 * Font fontParagraph2192 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2192.setSize(12);
		 */

		Paragraph paragraph74 = new Paragraph("Curricular development", font3);
		document.add(paragraph74);

		/*
		 * Font fontParagraph2193 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2193.setSize(12);
		 */

		Paragraph paragraph75 = new Paragraph(
				"Group head and lead faculty during their close interaction, identify overlapping components in the curriculum pertaining to their group and recommend for merger of courses, if any, as well as introduction\r\n"

						+ "of new courses including electives in emerging areas to the Board of Studies. Identify emerging trends in industry, propose value-added courses for students to improve their skills."
						+ "",
				font5);
		document.add(paragraph75);

		/*
		 * Font fontParagraph2194 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2194.setSize(12);
		 */

		Paragraph paragraph76 = new Paragraph("Inculcating an improved research culture" + "\r\n", font3);
		document.add(paragraph76);

		/*
		 * Font fontParagraph2195 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2195.setSize(12);
		 */

		Paragraph paragraph77 = new Paragraph(
				"Group head motivates junior faculty to pursue research, connects them to a network of researchers encourages to present seminars on research topics pertaining to the group by updating themselves, thereby,\r\n"

						+ "facilitating in the identification of research guides, platforms for publication of research and establishment of research culture within the group\r\n"

						+ "Group head helps faculty in implementing group’s long range plan in the development of \"Courses with diversity/multidisciplinary competence.\r\n"
						+ "Global awareness and predicting technological advances, if any.Also suggests mentees to conform to international standards of all course offerings pertaining to the\r\n"

						+ "division. Helps them in the identification of high-end equipment, hardware/software for procurement.\r\n"
						+ "",
				font5);
		document.add(paragraph77);

		/*
		 * Font fontParagraph2196 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2196.setSize(12);
		 */

		Paragraph paragraph78 = new Paragraph("Identifying talent and development of leadership qualities");
		document.add(paragraph78);

		/*
		 * Font fontParagraph2197 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2197.setSize(12);
		 */

		Paragraph paragraph79 = new Paragraph(
				"It has also been facilitating in the creation of a fairly good talent pool and establishment of a second rung\r\n"
						+ "leadership in various specializations of the department providing value added teaching learning process\r\n"
						+ "and inculcating research culture, also enabling smooth administration/functioning of the department.\r\n"
						+ "Junior faculty have also been able to associate themselves with all departmental/college’s cultural, and\r\n"
						+ "other activities promoting a healthy collegial spirit among themselves, thereby facilitating the\r\n"

						+ "administration in the development of potential leaders and identification of talent\r\n");
		document.add(paragraph79);

		/*
		 * Font fontParagraph2199 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2199.setSize(12);
		 */

		Paragraph paragraph80 = new Paragraph("Evidence of Success\r\n" + "");
		document.add(paragraph80);

		/*
		 * Font fontParagraph2100 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2100.setSize(12);
		 */

		Paragraph paragraph81 = new Paragraph(
				"The above structure, kept in place since January 2017, has been bringing incremental improvements in the\r\n"
						+ "teaching-learning process of theory courses, laboratory instruction, project/problem-based learning, student\r\n"
						+ "participation in coding competitions, Hackathons and project exhibitions leading to development of prototypes. Faculty research publications and patents filed also improved.\r\n"

						+ "This structure has been promoting a healthy mentor-mentee relationship among faculty, providing more learning opportunities for junior faculty\r\n"

						+ "/r/n",
				font5);
		document.add(paragraph81);
		PdfPTable table33criteria7 = new PdfPTable(6);
		table33criteria7.setWidthPercentage(100);

		com.lowagie.text.Font font41 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font41.setColor(CMYKColor.BLACK);
		PdfPCell cell191 = new PdfPCell(new Paragraph("S.No."));
		PdfPCell cell201 = new PdfPCell(new Paragraph("Item/AY"));
		PdfPCell cell211 = new PdfPCell(new Paragraph("2016-17"));

		PdfPCell cell221 = new PdfPCell(new Paragraph("2017-18 "));

		PdfPCell cell231 = new PdfPCell(new Paragraph("2018-19"));
		PdfPCell cell124criteria7 = new PdfPCell(new Paragraph("2019-20"));

		table33criteria7.addCell(cell191);
		table33criteria7.addCell(cell201);
		table33criteria7.addCell(cell211);
		table33criteria7.addCell(cell221);
		table33criteria7.addCell(cell231);
		table33criteria7.addCell(cell124criteria7);

		document.add(table33criteria7);

		/*
		 * Font fontParagraph2101 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2101.setSize(12);
		 */
		// table118
		Paragraph paragraph82 = new Paragraph("Problems Encountered and Resources Required" + "/r/n");
		document.add(paragraph82);

		/*
		 * Font fontParagraph2102 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2101.setSize(12);
		 */

		Paragraph paragraph83 = new Paragraph(
				"No takers for certain specializations and few specializations have high demand.Attaching mentees to mentors based on research interests/specializations is increasingly becoming a tough\r\n"

						+ "task, making some faculty members feeling jittery.Also sometimes resulting in unavailability of mentors in some specific areas/specializations, although more\r\n"

						+ "junior faculty showing keen interest to pursue their research/offering courses in those specializations. It’s\r\n"
						+ "because research areas of some mentors are not in emerging areas. Also, many group heads/senior faculty are bogged down with administrative responsibilities.\r\n",
				font5);
		document.add(paragraph83);
		/*
		 * Font fontParagraph2103 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2103.setSize(12);
		 */

		Paragraph paragraph84 = new Paragraph("Resources required" + "\r\n", font3);
		document.add(paragraph84);

		/*
		 * Font fontParagraph2104 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2104.setSize(12);
		 */

		Paragraph paragraph85 = new Paragraph("Competent faculty working in emerging areas\r\n"
				+ "Adequate discussion rooms for each department\r\n"
				+ "Seminar halls and research labs for each specialization/department\r\n"
				+ "Adequate transportation facilities for faculty working late hours.\r\n"
				+ "Recruitment of faculty and staff with administrative experience involving accreditations/affiliations\r\n"
				+ "to reduce administrative load on group heads for increased mentor-mentee interaction for further\r\n"
				+ "improvement of publications, patents and quality learning experience for all" + "\r\n", font5);
		document.add(paragraph85);
		document.add(paragraph85);

		// document

		/*
		 * Font fontParagraph2105 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2105.setSize(12);
		 */

		Paragraph paragraph86 = new Paragraph("Notes (Optional)" + "\r\n", font5);
		document.add(paragraph86);

		/*
		 * Font fontParagraph98 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph98.setSize(12);
		 */
		Paragraph paragraph87 = new Paragraph(
				"This practice adopted by Mother Teresa can be replicated in other institutions as well. \r\n"
						+ "Whenever parent institution finds itself relatively weak in some areas,may choose networking with other institutions where strong mentors with proven credentials are available.\r\n"

						+ "This facilitates organization of FDPs/FIPs, collaborative research proposals, doctoral research guidance,creative and innovative projects by students and sharing of resources for a mutually beneficial outcome.\r\n"

						+ "When this sort of networking takes place between institutions it can also facilitate several other activities,adoption of procedures and other institution’s best practices making both the institutions flourish. A group\r\n"

						+ "of institutions may also come forward by networking together forming a consortium of institutions for enhancing faculty competences\r\n",
				font5);
		document.add(paragraph87);
		// table5
		PdfPTable table5criteria7 = new PdfPTable(2);
		table5criteria7.setWidthPercentage(100);

		PdfPCell cell1110 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n"));
		PdfPCell cell1134 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n"));
		PdfPCell cell1135 = new PdfPCell(new Paragraph("Best practices in the Institutional web site\r\n\r\n\r\n "));
		PdfPCell cell1136 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(31).getCriteria7FilePath() : "")));

		table5criteria7.addCell(cell1110);
		table5criteria7.addCell(cell1134);
		table5criteria7.addCell(cell1135);
		table5criteria7.addCell(cell1136);
		table5criteria7.setSpacingBefore(20f);
		table5criteria7.setSpacingAfter(20f);

		document.add(table5criteria7);
		// 7.3
		/*
		 * Font fontParagraph2106 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2106.setSize(12);
		 */

		Paragraph paragraph88 = new Paragraph("7.3 Institutional Distinctiveness" + "\r\n", font3);
		document.add(paragraph88);

		// 7.3.1
		/*
		 * Font fontParagraph2107 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2107.setSize(11);
		 */
//
//		Paragraph paragraph89 = new Paragraph(
//				"7.3.1 Portray the performance of the Institution in one area distinctive to its priority and thrust\r\n"
//						+ "within 1000 words\r\n" + "\r\n" + "Response: \r\n" + "\r\n"
//						+ (criteria7Record != null
//								? criteria7Record.getCriteria71Ql().get(0).getResponse731()
//								: "")
//						+ "Facilitating training for improved Placements:",
//				font3);
//		document.add(paragraph89);

		PdfPTable table731criteria7 = new PdfPTable(1);
		table731criteria7.setWidthPercentage(100f);

		/*
		 * com.lowagie.text.Font fontcriteria7 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontcriteria7.setColor(CMYKColor.BLACK);
		 */

		PdfPCell cell731criteria7 = new PdfPCell(new Paragraph(
				"7.3.1 Portray the performance of the Institution in one area distinctive to its priority and thrust within 1000 words\r\n"
						+ "\r\n" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria73Ql().get(0).getResponse731()
								: ""),
				font3));

		table731criteria7.addCell(cell731criteria7);
		table731criteria7.setSpacingBefore(20f);
		table731criteria7.setSpacingAfter(20f);

		document.add(table731criteria7);

		// paragraph

		/*
		 * Font fontParagraph324 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph324.setSize(12);
		 */

		Paragraph paragraph90 = new Paragraph(
				"The first PEO of all programs of Mother Teresa is gainful employment or pursuit of higher education.Gainful employment is essentially facilitating students in securing a good job while studying in college, which we\r\n"

						+ "are coining it as ‘Campus Placements’. This is an area of utmost priority for any professional college and so is the priority for Mother Teresa. In this context, Mother Teresa has been doing exceedingly well in terms of\r\n"

						+ "getting the students placed in many IT and IT-enabled service (ITES) companies, namely, TCS, Wipro,Cognizant, Accenture, and others.\r\n"
						+ ""
						+ "Any parent and his/her ward always look for quality education coupled with a good placement. Mother Teresahas, therefore, designed its curricula, adopted teaching learning process, has been executing a meticulouslyplanned and structured training program, with a sharp focus on improving not only the number ofplacements but also quality of placements, particularly in terms of the salary package and reputation of thecompany, which is, Mother Teresa’s thirst and thrust.\r\n"
						+ "Keeping this in view, skills namely, problem-solving, critical-thinking, logical-reasoning, programming,creativity, innovation communication and interpersonal skills, which employers look for in freshengineering graduates. College has undertaken several initiatives to impart these skills to students. Apartfrom strengthening the core teaching-learning process, which is the backbone of any college, Mother Teresahas been continuously striving in facilitating and supporting in the honing of the following skills among\r\n"
						+ "students:\r\n" + "Basic programming skills\r\n" + "Advanced programming skills\r\n"
						+ "Quantitative aptitude development\r\n" + "Critical thinking and logical reasoning\r\n"
						+ "Verbal ability, creative and situational writing\r\n" + "Soft skills\r\n"
						+ "Even though students of all engineering branches study Programing and Problem-solving using C language during their first year of engineering, non-CSE (ECE, EEE, ME, CE) students tend to lose touch with programming as they progress in their respective branch of engineering since they do not apply and use programming to solve problems pertaining to their engineering courses. As programming is now considered not only a necessary skill to be employable, but also a life skill, Mother Teresa has been encouraging faculty and students of all engineering branches to integrate programming into their regularlaboratory work and assignments in various courses, wherever possible.Mother Teresa has associated with professional third-party vendors to facilitate students with the necessary programming skills, mainly planned for targeted improvement of their employability opportunities.\r\n"
						+ "Students from all branches of engineering, eligible for placements, are given training to refresh and enhance their programming skills. This usually takes place during the sixth (6th) semester and following summer vacation, just before the placement season begins in the first semester of their final year.It is observed that focused training in programming, sometimes designing and scheduling a mock placement drive for a specific company, has immensely helped students to get placed in higher numbers.\r\n"
						+ "It is heartening to note that Mother Teresa has consistently done well in terms of placements in IT and ITES companies, with pay packages varying between 3.6 LPA and 4.5 LPA. However, the number of placements with product-based companies, wherein the pay packages are 5LPA – 10LPA and above is viewed as the hallmark of any good college. Keeping this in view, and with the strong placement record in IT and ITES companies, the next logical step is to aim at helping the students to develop the necessary skills to get selected in such companies that offer much higher pay packages. Most product-based companies, in addition to testing the students in their aptitude, also examine their higher order programming and problem-solving skills. Consequent to this thought process, we roped in\r\n"
						+ "another third party premier training organization with proven track record, to impart necessary skills to get a job in product-based companies such as Amazon, Microsoft, DE Shaw etc., to train around 150 students, selected out of nearly 800, and started enhancing their advanced data structures, algorithms and problem solving skills since the academic 2020-21. The impact of this advanced training program is clearly visible in the increased number of placements for the 2021 and outgoing batches in product-based companies. For the 2023 outgoing batch of students, the training has commenced in their Third year second semester in order to provide ample time to hone their skills and also practice a large number of problems long before the placements season begins in July, 2022.\r\n"
						+ "Some companies like Cognizant and Virtusa for example, have started hiring fresh engineering graduates in specialized roles such as Data Scientist, IoT Engineer, full Stack Developer and UI developer, Cloud Engineer etc. The students are expected to demonstrate significant skills in those areas at the time of recruitment.\r\n"
						+ "Even though the current curriculum of CSE and IT branches provide for these areas, it is felt that PBL as a co-curricular activity would also help the students in enhancing their skills in emerging areas such as AI &\r\n"
						+ "ML, Data Science, Cloud Computing, IoT and Cyber Security. We have entered into an association withSmartBridge and Cantilever labs, who offer externship programs designed to provide skills matching the needs of IT companies to our students at the end of their second year itself",
				font5);
		document.add(paragraph90);

		// table6
		PdfPTable table60 = new PdfPTable(5);
		table60.setWidthPercentage(100);
		// inside inside table6
		/*
		 * com.lowagie.text.Font font15 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		 * font15.setColor(CMYKColor.BLACK);
		 */
		PdfPCell cell09criteria7 = new PdfPCell(new Paragraph("Batch"));
		PdfPCell cell010criteria7 = new PdfPCell(new Paragraph("2018-22"));
		PdfPCell cell011criteria7 = new PdfPCell(new Paragraph("2017-21 "));
		PdfPCell cell012criteria7 = new PdfPCell(new Paragraph("2016-20"));
		PdfPCell cell013criteria7 = new PdfPCell(new Paragraph("2015-19"));

		table60.addCell(cell09criteria7);
		table60.addCell(cell010criteria7);
		table60.addCell(cell011criteria7);
		table60.addCell(cell012criteria7);
		table60.addCell(cell013criteria7);
		table60.setSpacingBefore(20f);
		table60.setSpacingAfter(20f);

		document.add(table60);

		/*
		 * Font fontParagraph09 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph09.setSize(12);
		 */

		Paragraph paragraph190 = new Paragraph(
				"As can be seen from the table, the total number of offers has increased from 547 to 1400, in the last threeyears (2018-19 to 2021-22). This significant growth, has resulted in a quantum jump in the number ofoffers in the Rs.4-5 LPA range as well as Rs.6 LPA and above. In the context of this perceptibly large improvement in the total number of offers over the years, this can be construed and even attributed to the training program imparted, which in our perception is not only highly desirable but also a distinctive practice of this growing institution.",
				font3);
		document.add(paragraph190);

		PdfPTable table7criteria7 = new PdfPTable(2);
		table4criteria7.setWidthPercentage(100);

		/*
		 * com.lowagie.text.Font font17 = FontFactory.getFont(FontFactory.TIMES_BOLD);
		 * font17.setColor(CMYKColor.BLACK);
		 */
		PdfPCell cell22criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n"));
		PdfPCell cell23criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n"));
		PdfPCell cell24criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n"));
		PdfPCell cell25criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(32).getCriteria7FilePath() : "")));
		PdfPCell cell26criteria7 = new PdfPCell(new Paragraph("Appropriate web in the Institutional websit\r\n\r\n\r\n"));

		table7criteria7.addCell(cell22criteria7);
		table7criteria7.addCell(cell23criteria7);
		table7criteria7.addCell(cell24criteria7);
		table7criteria7.addCell(cell25criteria7);
		table7criteria7.addCell(cell26criteria7);
		table7criteria7.setSpacingBefore(20f);
		table7criteria7.setSpacingAfter(20f);

		document.add(table7criteria7);

		/*
		 * Font fontParagraph008 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph008.setSize(12);
		 */

		Paragraph paragraph1901 = new Paragraph("5. CONCLUSION\r\n\r\n", font3);
		document.add(paragraph1901);

		/*
		 * Font fontParagraph009 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph009.setSize(12);
		 */

		Paragraph paragraph1902 = new Paragraph("Additional Information\r\n\r\n :", font3);
		document.add(paragraph1902);

		/*
		 * Font fontParagraph0010 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph0010.setSize(12);
		 */

		Paragraph paragraph1903 = new Paragraph(
				"Mother Teresa, started administering UG programs in CSE with specializations in emerging areas (EA), namely,AIML, CS, DS, and IoT from the academic year 2020-21, in addition to the UG programs in CSE, ECE, EEE,IT, ME and CE. Currently, student intake in CSE, CSE(EA) and IT stands at 660 and for 2022-23 it is likely to go up to 780. Keeping this in view, and more than 90% of the recruitment happening in IT/ITES companies,Mother Teresa feels the necessity to have an increased tie-up with IT industry. To this end, in the academic year2021-22, institution has reconstituted its Governing body, Academic Council and Board of Studies of variousdepartments by inviting experts working at senior positions from IT industries, to guide the institution in-termsof curricular design, strengthening the training of students, in particular, with skill set requirements of IT/ITES companies, emphasizing in EA. \r\n"
						+ "Further, Institution has organized faculty development programs in CSE(EA), to improve faculty competencies and about 60 faculty of CSE/IT/CSE(EA) have attended the same. Institution has also entered into MoUs for student and faculty training and student internships. About 10 senior faculty with specialization in CSE(EA) have joined the institution on invitation.\r\n"
						+ "Non-CSE/IT discipline students are also given training on Programming skills to enhance their employability.\r\n"
						+ "Further, students solve assignments in core engineering and mathematics courses using C-programming. \r\n"
						+ "Emphasizing on multidisciplinary education and research, institution’s incubation centre tied-up with R&D organizations, and MSMEs, resulting in 20 prototype:",
				font5);
		document.add(paragraph1903);

		/*
		 * Font fontParagraph0011 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph0011.setSize(12);
		 */

		Paragraph paragraph1900 = new Paragraph(
				"Institution has been invited to present a talk on “Best Practices in Technical Education-Financial Sustainability in Universities” at the All-India Conference of Vice-Chancellors of Universities offering Engineering and Technology programs held at the Jawaharlal Nehru Technological University Hyderabad, during April 8-9, 2022.\r\n"
						+ "Institution has conducted two webinars on NEP-20.\r\n"
						+ "With all the above additional efforts, to further improve the quality of professional education and to enhance its core capabilities, Mother Teresa is determined to not only reach out to the imminent employability and skill needs of our Learners, but has already been administering the same, to render our learners, a cut above the rest, facilitating them to perform much better",
				font5);
		document.add(paragraph1900);

		/*
		 * Font fontParagraph0012 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph0012.setSize(13);
		 */

		Paragraph paragraph19011 = new Paragraph("Concluding Remarks\r\n\r\n :", font3);
		document.add(paragraph19011);

		/*
		 * Font fontParagraph0017 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph0017.setSize(12);
		 */

		Paragraph paragraph19018 = new Paragraph(
				"Consequent to this, the institution has been getting its eligible UG programs duly accredited by NBA regularly since July 2012, and the institution itself is accredited by NAAC with “A” grade in June 2017. Currently, all its  2011, 4-star by IIC, ARIIA ranking in Excellent Band, MHRD and NIRF rank in 251-300 Band in 2021. eligible UG programs are accredited by NBA. Institution has also been recognized as SIRO, by DSIR, since Institution’s faculty have been publishing research papers and patents. Executed sponsored projects worth about Rs.1.15 crores Student placements have been continuously increasing, as also the highest pay package and median salary.  Although institutional effectiveness can be measured in many ways, one of the most fundamental measures is the success it has achieved in contributing to the achievement of its students’ goals, which is, ensuring students’ placements and/or facilitating them to pursue higher education, which is the first of the PEOs of all our UG Programs. As a matter of fact, it is also our institutional distinctiveness, giving priority and thrust. To this end, institution feels that it has been doing quite well, although it believes that there is much more that can be achieved in the years to come",
				font5);
		document.add(paragraph19018);

	}
}
