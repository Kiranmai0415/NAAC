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
import com.adiverse.erp.model.EvaluativereportMain;
import com.adiverse.erp.model.ExecutiveSummary;
import com.adiverse.erp.model.Executive_FileUpload;
import com.adiverse.erp.model.ExtendedProfile;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.model.QIAIndicator2;
import com.adiverse.erp.model.QIAIndicatorMain;
import com.adiverse.erp.service.Criteria1Service;
import com.adiverse.erp.service.Criteria2Service;
import com.adiverse.erp.service.Criteria3Service;
import com.adiverse.erp.service.Criteria4Service;
import com.adiverse.erp.service.Criteria5Service;
import com.adiverse.erp.service.Criteria6Service;
import com.adiverse.erp.service.Criteria7Service;
import com.adiverse.erp.service.EvalutiveReportService;
import com.adiverse.erp.service.ExecutiveService;
import com.adiverse.erp.service.ExtendedService;
import com.adiverse.erp.service.QiaService;
import com.adiverse.erp.service.SsrService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.Cell;
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

@Component
public class AutonomousQualityAdivisorReport2 {

	@Value("${logoImgPath}")
	private String logoImgPath;

	@Value("${logoImgScale}")
	private Float[] logoImgScale;

	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	
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

	@Autowired
	QiaService qiservice;

	@Autowired
	ExecutiveService executiveService;

	@Autowired
	EvalutiveReportService evalutiveReportService;

	@Autowired
	AutonomousIiqaReport autonomousIiqaReport;
	
	

	List<QIAIndicatorMain> qIAIndicator = null;
	QIAIndicatorMain qiadata = null;
	List<QIAIndicator2> qIAIndicator1 = null;
	

	List<ExecutiveSummary> executiveSummary1 = null;
	ExecutiveSummary executiveSummary = null;

	List<Executive_FileUpload> executive_FileUpload1 = null;
	Executive_FileUpload executive_FileUpload = null;

	List<Criteria1_FieldInfo> criteria1List = null;
	Criteria1_FieldInfo criteria1Record = null;
	List<Criteria1_FileUpload> criteria1file = null;


	List<Criteria2_FieldInfo> criteria2List = null;
	Criteria2_FieldInfo criteria2Record = null;
	List<Criteria2_FileUpload> criteria2file = null;

	List<Criteria3_FieldInfo> criteria3FieldInfoList = null;
	Criteria3_FieldInfo criteria3Record = null;
	List<Criteria3_FileUpload> criteria3file = null;
	
//	List<Criteria3_FieldInfoQn> criteria3_FieldInfoQnList = null;
//	List<Criteria3_FieldInfoQl> criteria3_FieldInfoQlList = null;
//	List<Criteria3_FieldInfo> criteria3Fieldinfo = null;

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

	List<EvaluativereportMain> evaluativereportList = null;
	EvaluativereportMain evaluativereportofthedepartment = null;


	List<ProfileoftheCollege> profileList = null;
	ProfileoftheCollege ssrData = null;
	List<EvaluativeFileUpload> Profilefile = null;

	List<ExtendedProfile> epList = null;
	ExtendedProfile epRecord = null;
	

	@Value("${upload.files.path}")
	private String reportGeneratePath;

	public String generateReport(Map<String,String> allparams) throws DocumentException, IOException {
		ObjectMapper mapper=new ObjectMapper();
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
			
	        System.out.println("allparams======>"+allparams);

			Font font0 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font0.setSize(16);

			Font font1criteria3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font1criteria3.setSize(14);

			Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font2.setSize(12);

			profileList = ssrService.getAllAcademicData(allparams);
			if (CollectionUtils.isNotEmpty(profileList)) {
				ssrData = profileList.get(0);
			} else {
				ssrData = new ProfileoftheCollege();
			}

			executiveSummary1 = executiveService.getAllExecutiveData(allparams);
			if (CollectionUtils.isNotEmpty(executiveSummary1)) {
				executiveSummary = executiveSummary1.get(0);
			} else {
				executiveSummary = new ExecutiveSummary();
			}
			
			
			evaluativereportList = evalutiveReportService.getAllEvaluativeData(allparams);
			if (CollectionUtils.isNotEmpty(evaluativereportList)) {
				evaluativereportofthedepartment = evaluativereportList.get(0);
			} else {
				evaluativereportofthedepartment = new EvaluativereportMain();
			}
			
			

			epList = extendedService.getAllExtendedData(allparams);
			if (CollectionUtils.isNotEmpty(epList)) {
				epRecord = epList.get(0);
			} else {
				epRecord = new ExtendedProfile();
			}

			criteria1List = service1.getAllCriteria1Data(allparams);
			if (CollectionUtils.isNotEmpty(criteria1List)) {
				criteria1Record = criteria1List.get(0);
				criteria1file = criteria1Record.getCriteria1FileUpload();
			} else {
				criteria1Record = new Criteria1_FieldInfo();
				criteria1file = new ArrayList<Criteria1_FileUpload>();
			}


			criteria2List = service2.getAllCriteria2Data(allparams);
			if (CollectionUtils.isNotEmpty(criteria2List)) {
				criteria2Record = criteria2List.get(0);
				criteria2file = criteria2Record.getCriteria2FileUpload();
			} else {
				criteria2Record = new Criteria2_FieldInfo();
			}

			criteria3FieldInfoList = service3.getAllCriteria3Data(allparams);

			if (CollectionUtils.isNotEmpty(criteria3FieldInfoList)) {
				criteria3Record=criteria3FieldInfoList.get(0);
//				criteria3_FieldInfoQnList = criteria3FieldInfoList.get(0).getCriteria3FieldInfoQn();
//				criteria3_FieldInfoQlList = criteria3FieldInfoList.get(0).getCriteria3FieldInfoQl();
				criteria3file = criteria3FieldInfoList.get(0).getCriteria3FileUpload();
			} else {
				criteria3Record= new Criteria3_FieldInfo();
				criteria3file = new ArrayList<>();
			}

//			System.out.println("sfasdfdasdfasfdasdfasdfasdfasdfasdf" + criteria3_FieldInfoQnList);
//			System.out.println("999999999999999999999999999" + criteria3_FieldInfoQlList);
//			System.out.println("criteria3file==>" + criteria3file);

			criteria4List = service4.getAllCriteria4Data(allparams);
			if (CollectionUtils.isNotEmpty(criteria4List)) {
				criteria4Record = criteria4List.get(0);
				criteria4file = criteria4Record.getCriteria4FileUpload();
			} else {
				criteria4Record = new Criteria4_FieldInfo();
				criteria4file = new ArrayList<>();
			}

			criteria5List = service5.getAllCriteria5Data(allparams);
			if (CollectionUtils.isNotEmpty(criteria5List)) {
				criteria5Record = criteria5List.get(0);
				criterai5file = criteria5Record.getCriteria5FileUpload();
			} else {
				criteria5Record = new Criteria5_FieldInfo();
				criterai5file = new ArrayList<>();
			}

			criteria6List = service6.getAllCriteria6Data(allparams);
			if (CollectionUtils.isNotEmpty(criteria6List)) {
				criteria6Record = criteria6List.get(0);
				criteria6file = criteria6Record.getCriteria6FileUpload();
			} else {
				criteria6Record = new Criteria6_FieldInfo();
				criteria6file = new ArrayList<>();
			}

			criteria7List = service7.getAllCriteria7Data(allparams);
			if (CollectionUtils.isNotEmpty(criteria7List)) {
				criteria7Record = criteria7List.get(0);
				criteria7file = criteria7Record.getCriteria7FileUpload();
			} else {
				criteria7Record = new Criteria7_FieldInfo();
				criteria7file = new ArrayList<>();

			}

			// epList = extendedService.getAllExtendedData(allParams);
			if (CollectionUtils.isNotEmpty(epList)) {
				epRecord = epList.get(0);
			} else {
				epRecord = new ExtendedProfile();
			}
//			List<ProfileoftheCollege> profileList = null;
//			ProfileoftheCollege ProfileRecord = null;
//			List<EvaluativeFileUpload> Profilefile = null;

			profileList = ssrService.getAllAcademicData(allparams);
			
			if (CollectionUtils.isNotEmpty(profileList)) {
				ssrData = profileList.get(0);
			} else {
				ssrData = new ProfileoftheCollege();
			}
			
//			List<QIAIndicatorMain> qIAIndicator = null;
//			QIAIndicatorMain qiadata = null;
//			List<QIAIndicator2> qIAIndicator1 = null;
//			
			
			
			qIAIndicator = qiservice.getAllQiaFiles(allparams);
			System.out.println("qIAIndicator=======>"+mapper.writeValueAsString(qIAIndicator));
			if (CollectionUtils.isNotEmpty(qIAIndicator)) {
				qiadata = qIAIndicator.get(0);
				qIAIndicator1=qiadata.getQiaIndicator2();
			} else {
				qiadata = new QIAIndicatorMain();
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
			// addLogo(document);

	//	Executive(document, executiveSummary);
	    	Ssr(document, executiveSummary);
	    	  Iiqa(document);
	         	Criteria1(document);
		     Criteria2(document, criteria2Record);

			Criteria3(document, criteria3Record);
		    Criteria4(document, criteria4Record);
			Criteria5(document, criteria5Record);
	        Criteria6(document, criteria6Record);
         	Criteria7(document, criteria7Record);
	
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

//	public void Executive(Document document, ExecutiveSummary executiveData) {}

	public void Ssr(Document document, ExecutiveSummary executiveData) {

		Paragraph paragraph20ssr = new Paragraph("1.EXECUTIVE SUMMARY", font1);
		Paragraph paragraph21ssr = new Paragraph("1.Introductory Note on the Institution", font2);
		paragraph20ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		paragraph20ssr.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph20ssr);
		document.add(paragraph21ssr);

//		Paragraph paragraph22ssr = new Paragraph(
//				"Mother Teresa Institute of Science and Technology (MIST), Khammam -\r\n" + "\r\n", font5);
//		Paragraph paragraph23ssr = new Paragraph(
//				"was established in 2001. The college is an ISO 9001:2008 certified institute and is permanently affiliated to Jawaharlal Nehru Technological University, Hyderabad.\r\n"
//						+ "\r\n" ,
//				font5);
//		Paragraph paragraph24ssr = new Paragraph(
//				"Mother Teresa Institute of Science and Technology (MIST) was founded through MCM Educational Society in 2001 by eminent philanthropist,industrialists and schloars , MIST  aims at co-creating value-based technical excellence, which ultimately leads to the development of the rural area where the college is situated. From a modest intake of 180 students across 3 engineering programs in B.Tech, namely ECE, CSE, and IT, MIST, in less than 2 decades, it has grown into an institution of gigantic proportions with massive infrastructure, besides multitude of students, faculty & staff. At present, we offer 6 B.Tech programmes in CSE,  ECE, EEE, ME, CE, MNG., 5 M.Tech programmes such as CSE, Power Electronics and Drives ,ECE,Advance Manufacturing Systems,Structural Engg. in addition to M.B.A  programme as first shift and introduced 2nd shift diploma in A.Y:2009,with the Branches CE,EEE,ME,ECE and Mining. MIST has a vibrant campus spread over 30 acres of serene and natural surroundings with plenty of greenery in SATHUPALLY, Khammam  District, Telangana. It has world class infrastructure in all its academic departments, besides an asthetically-designed administrative block. The major facilities include  e-class rooms,  well-equipped laboratories,seminar halls ,well stocked library,WI-FI enabled campus,Backup power supply,Canteen etc. MIST was approved by All india Counsil for Technical Education AICTE New Delhi,  Affliated to Jawaharlal Nehru Technological University Hyderabad , JNTUH and State Board of Technical Education and Training SBTET Recognized by Govt.of Telangana, UGC under Section 2(f) and 12(B) and Accrediated by NAAC  with 'B' Grade. MIST has been recognized as a remote center of IIT BOMBAY and KARAGPUR for organizing FDP’S ,WORKSHOPS,QIP’S for students and faculty.We pride ourselves as an institution with a large pool of well-qualified and experienced faculty who not only enrich our teaching-learning sphere but also contribute to the R&D ecosystem. The promoters of the MIST started the college with a vision to empower students to become technologically vibrant, innovative and emotionally matured to face the dynamic challenges of a quality-conscious global economy. They are socially-conscious and respond proactively to the needs and requirements of this region on a continuous basis. The managing trust is involved in many charitable activities to help the needy and the poor of this region, thereby contribute towards social development of the region.\r\n\r\n",
//				font5);

		Paragraph paragraph22ssr = new Paragraph(executiveSummary != null ?executiveSummary.getInputes1():
				"", font5);
//		Paragraph paragraph23ssr = new Paragraph(
//				"was established in 2001. The college is an ISO 9001:2008 certified institute and is permanently affiliated to Jawaharlal Nehru Technological University, Hyderabad.\r\n"
//						+ "\r\n" ,
//				font5);
//		Paragraph paragraph24ssr = new Paragraph(
//				"Mother Teresa Institute of Science and Technology (MIST) was founded through MCM Educational Society in 2001 by eminent philanthropist,industrialists and schloars , MIST  aims at co-creating value-based technical excellence, which ultimately leads to the development of the rural area where the college is situated. From a modest intake of 180 students across 3 engineering programs in B.Tech, namely ECE, CSE, and IT, MIST, in less than 2 decades, it has grown into an institution of gigantic proportions with massive infrastructure, besides multitude of students, faculty & staff. At present, we offer 6 B.Tech programmes in CSE,  ECE, EEE, ME, CE, MNG., 5 M.Tech programmes such as CSE, Power Electronics and Drives ,ECE,Advance Manufacturing Systems,Structural Engg. in addition to M.B.A  programme as first shift and introduced 2nd shift diploma in A.Y:2009,with the Branches CE,EEE,ME,ECE and Mining. MIST has a vibrant campus spread over 30 acres of serene and natural surroundings with plenty of greenery in SATHUPALLY, Khammam  District, Telangana. It has world class infrastructure in all its academic departments, besides an asthetically-designed administrative block. The major facilities include  e-class rooms,  well-equipped laboratories,seminar halls ,well stocked library,WI-FI enabled campus,Backup power supply,Canteen etc. MIST was approved by All india Counsil for Technical Education AICTE New Delhi,  Affliated to Jawaharlal Nehru Technological University Hyderabad , JNTUH and State Board of Technical Education and Training SBTET Recognized by Govt.of Telangana, UGC under Section 2(f) and 12(B) and Accrediated by NAAC  with 'B' Grade. MIST has been recognized as a remote center of IIT BOMBAY and KARAGPUR for organizing FDP’S ,WORKSHOPS,QIP’S for students and faculty.We pride ourselves as an institution with a large pool of well-qualified and experienced faculty who not only enrich our teaching-learning sphere but also contribute to the R&D ecosystem. The promoters of the MIST started the college with a vision to empower students to become technologically vibrant, innovative and emotionally matured to face the dynamic challenges of a quality-conscious global economy. They are socially-conscious and respond proactively to the needs and requirements of this region on a continuous basis. The managing trust is involved in many charitable activities to help the needy and the poor of this region, thereby contribute towards social development of the region.\r\n\r\n",
//				font5);
//		
		paragraph22ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
	//	paragraph23ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph22ssr);
	//	document.add(paragraph23ssr);

//		paragraph24ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph24ssr);

		Paragraph paragraph25ssr = new Paragraph("VISION", font4);
		paragraph25ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph25ssr);
		
		

//		Paragraph paragraph26ssr = new Paragraph(
//				"To provide the society with center of learning that motivates, supports and encourages the youth to involve into dynamic professional with a social commitmenty.\r\n"
//						+ "\r\n",
//			//	font5);

		Paragraph paragraph26ssr = new Paragraph(executiveSummary != null ?executiveSummary.getInputes2():"",font5);
		
		paragraph26ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph26ssr);

		Paragraph paragraph27ssr = new Paragraph("MISSION", font4);
		paragraph27ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr);

//		Paragraph paragraph28ssr = new Paragraph(
//				"We dedicate and commitment ourselves to achieve, sustain and    foster unmatched excellence in technical education.  To this end, we will pursue continuous development of infrastructure and enhance state of the art equipment to provide our students a technology up to date and intellectually inspiring environment of learning, research, creativity, innovation and professional activity, inculcate in them ethical and moral values. The institute is committed to build a better nation through quality education with team sprit. Our students are enable to excel values of life and become good citizens. We inspire the system, infrastructure and services to satisfy the students, parents, industry and society.\r\n"
//						+ "\r\n" + "\r\n" + "\r\n",
//				font5);
		Paragraph paragraph28ssr = new Paragraph(executiveSummary != null ?executiveSummary.getInputes3(): "",font5);
		
		paragraph28ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr);
		
		
		
		Paragraph paragraph27ssr1 = new Paragraph("Location:", font4);
		paragraph27ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr1);

		Paragraph paragraph28ssr1 = new Paragraph(executiveSummary != null ?executiveSummary.getInputes4(): "",font5);
		
		paragraph28ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr1);
		
		Paragraph paragraph27ssr11 = new Paragraph("Type of the Institution:", font4);
		paragraph27ssr11.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr11);

		Paragraph paragraph28ssr11 = new Paragraph(executiveSummary != null ?executiveSummary.getInputes5(): "",font5);
		
		paragraph28ssr11.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr11);
		
		Paragraph paragraph27ssr111 = new Paragraph("File upload:", font4);
		paragraph27ssr111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr111);

		Paragraph paragraph28ssr111 = new Paragraph(executive_FileUpload != null ?executive_FileUpload.getExecutiveFilePath(): "",font5);
		
		paragraph28ssr111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr111);
				
		Paragraph paragraph27ssr1111 = new Paragraph("2.Criterion-wise Summary on the Institution:", font4);
		paragraph27ssr1111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr1111);

		Paragraph paragraph28ssr1111 = new Paragraph(executiveSummary != null ?executiveSummary.getInputes7(): "",font5);
		
		paragraph28ssr1111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr1111);
		
		
		Paragraph paragraph27ssr11111 = new Paragraph("3.Brief note on the Strength Weakness Opportunities and Challenges(SWOC) in respect of the Institution:", font4);
		paragraph27ssr11111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr11111);

		Paragraph paragraph28ssr11111 = new Paragraph(executiveSummary != null ?executiveSummary.getInputes8(): "",font5);
		
		paragraph28ssr11111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr11111);
		
		
		Paragraph paragraph27ssr111111 = new Paragraph("4.Any additional information about the Institution other than ones already stated.:", font4);
		paragraph27ssr111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr111111);

		Paragraph paragraph28ssr111111 = new Paragraph(executiveSummary != null ?executiveSummary.getInputes9(): "",font5);
		
		paragraph28ssr111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr111111);
			
		Paragraph paragraph27ssr1111111 = new Paragraph("5.Over all conclusive explication about the institution's functioning:", font4);
		paragraph27ssr1111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr1111111);

		Paragraph paragraph28ssr1111111 = new Paragraph(executiveSummary != null ?executiveSummary.getInputes9(): "",font5);
		
		paragraph28ssr1111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr1111111);
		
		
////////////////// ssr
		
		
		Paragraph paragraph13ssr = new Paragraph("2.PROFILE\r\n\r\n", font1);
		Paragraph paragraph14ssr = new Paragraph("2.1 BASIC INFORMATION\r\n", font2);
		paragraph13ssr.setAlignment(Paragraph.ALIGN_CENTER);
		paragraph14ssr.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph13ssr);
		document.add(paragraph14ssr);

		PdfPTable table01ssr = new PdfPTable(1);
		table01ssr.setWidthPercentage(100f);

		PdfPCell cell01ssr = new PdfPCell(new Paragraph("Name and Address of the College", font4));
		cell01ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table01ssr.addCell(cell01ssr);

		PdfPTable table1ssr = new PdfPTable(2);
		table1ssr.setWidthPercentage(100f);
		table1ssr.setWidths(new int[] { 3, 3 });
		table1ssr.setSpacingBefore(5);

		PdfPCell cell1ssr = new PdfPCell(new Paragraph("Name",font4));
		cell1ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell1ssr);


		PdfPCell cell2ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt1(): "",font5));
		cell2ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell2ssr);

		PdfPCell cell3ssr = new PdfPCell(new Paragraph("Address", font4));
		cell3ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell3ssr);

		PdfPCell cell4ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt2(): "",font5));
		cell4ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell4ssr);

		PdfPCell cell5ssr = new PdfPCell(new Paragraph("City",font4));
		cell5ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell5ssr);

	PdfPCell cell6ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt3(): "",font5));
	cell6ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell6ssr);

		PdfPCell cell7ssr = new PdfPCell(new Paragraph("State",font4));
		cell7ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell7ssr);

		PdfPCell cell8ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt4(): "",font5));
		cell8ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell8ssr);

		PdfPCell cell9ssr = new PdfPCell(new Paragraph("Pin",font4));
		cell9ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell9ssr);

		PdfPCell cell10ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt5(): "",font5));
		cell10ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell10ssr);

		PdfPCell cell11ssr = new PdfPCell(new Paragraph("Website",font4));
		cell11ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell11ssr);

		PdfPCell cell12ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt6(): "",font5));
		cell12ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell12ssr);

//		table01ssr.addCell(table1ssr);
		table01ssr.setSpacingBefore(20f);

		table01ssr.setSpacingAfter(20f);

		document.add(table01ssr);
		document.add(table1ssr);

		PdfPTable table02ssr = new PdfPTable(1);
		table02ssr.setWidthPercentage(100f);

		PdfPCell cell02ssr = new PdfPCell(new Paragraph("Contacts for Communication", font4));
		cell02ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table02ssr.addCell(cell02ssr);

		PdfPTable table2ssr = new PdfPTable(6);
		table2ssr.setWidthPercentage(100f);
		table2ssr.setWidths(new int[] { 70, 70, 70, 70, 70, 70 });
		table2ssr.setSpacingBefore(20f);
		table2ssr.setSpacingAfter(20f);

		PdfPCell cell = new PdfPCell();

		cell.setPhrase(new Phrase("Designation\r\n", font4));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Name\r\n\r\n", font4));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Telephone with STD Code\r\n\r\n", font4));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Mobile\r\n\r\n", font4));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Fax\r\n\r\n", font4));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Email\r\n\r\n", font4));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc1(): "",font5));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc2(): "",font5));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc3(): "",font5));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc4(): "",font5));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc5(): "",font5));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc6(): "",font5));
		table2ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbtc7(): ""));
//		table2ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbtc1(): ""));
//		table2ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbtc1(): ""));
//		table2ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbtc1(): ""));
//		table2ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbtc1(): ""));
//		table2ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbtc1(): ""));
//		table2ssr.addCell(cell);


		cell.setPadding(5);

//		table02ssr.addCell(table2ssr);
		table02ssr.setSpacingAfter(20f);
		table02ssr.setSpacingBefore(20f);
		document.add(table02ssr);
		document.add(table2ssr);

		PdfPTable table03ssr = new PdfPTable(1);
		table03ssr.setWidthPercentage(100f);

		PdfPCell cell03ssr = new PdfPCell(new Paragraph("Nature of Institution\r\n", font4));
		cell03ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table03ssr.addCell(cell03ssr);

		PdfPTable table3ssr = new PdfPTable(2);
		table3ssr.setWidthPercentage(100f);
		table3ssr.setWidths(new int[] { 70, 70});
		table3ssr.setSpacingBefore(20f);
		table3ssr.setSpacingAfter(20f);

		PdfPCell cell13ssr = new PdfPCell(new Paragraph("Institution Status\r\n\r\n",font4));
		cell13ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3ssr.addCell(cell13ssr);

		PdfPCell cell14ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti1(): "",font5));
		cell14ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3ssr.addCell(cell14ssr);

//		table03ssr.addCell(table3ssr);
		document.add(table03ssr);
		document.add(table3ssr);
		table03ssr.setSpacingAfter(20f);

		PdfPTable table04ssr = new PdfPTable(1);
		table04ssr.setWidthPercentage(100f);

		PdfPCell cell04ssr = new PdfPCell(new Paragraph("Type of Institution\r\n\r\n", font4));
		cell04ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		
		table04ssr.addCell(cell04ssr);
	
		PdfPTable table4ssr = new PdfPTable(2);
		table4ssr.setWidthPercentage(100f);
		table4ssr.setWidths(new int[] { 3, 3 });
		table04ssr.setSpacingBefore(20f);
		table04ssr.setSpacingAfter(20f);

		PdfPCell cell15ssr = new PdfPCell(new Paragraph("By Gender\r\n\r\n",font4));
		cell15ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr.addCell(cell15ssr);

		PdfPCell cell16ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti2(): "",font5));
		cell16ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr.addCell(cell16ssr);

		PdfPCell cell17ssr = new PdfPCell(new Paragraph("By Shift\r\n\r\n",font4));
		cell17ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr.addCell(cell17ssr);

		PdfPCell cell18ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti3(): "",font5));
		cell18ssr.setHorizontalAlignment(Element.ALIGN_CENTER);


		table4ssr.addCell(cell18ssr);
		

//		table04ssr.addCell(table4ssr);
		document.add(table04ssr);
		document.add(table4ssr);
		
		table04ssr.setSpacingAfter(20f);
		table04ssr.setSpacingBefore(20f);

		
		///////////////
		PdfPTable table04ssr1 = new PdfPTable(1);
		table04ssr1.setWidthPercentage(100f);

		PdfPCell cell04ssr1 = new PdfPCell(new Paragraph("Establishment Details\r\n", font4));
		cell04ssr1.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table04ssr1.addCell(cell04ssr1);
	
		PdfPTable table4ssr1 = new PdfPTable(2);
		table4ssr1.setWidthPercentage(100f);
		table4ssr1.setWidths(new int[] { 3, 3 });
		table4ssr1.setSpacingBefore(20f);
		table4ssr1.setSpacingAfter(20f);

		PdfPCell cell15ssr1 = new PdfPCell(new Paragraph("Date of establishment, prior to the grant of (Autonomy)\r\n",font4));
		cell15ssr1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table04ssr1.addCell(cell15ssr1);

		PdfPCell cell16ssr1 = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti4(): "",font5));
		cell16ssr1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table04ssr1.addCell(cell16ssr1);

		PdfPCell cell17ssr1 = new PdfPCell(new Paragraph("Date of grant of 'Autonomy' to the college by UGC\r\n",font4));
		cell17ssr1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table04ssr1.addCell(cell17ssr1);

		PdfPCell cell18ssr1 = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti5(): "",font5));
		cell18ssr1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table04ssr1.addCell(cell18ssr1);
		
		PdfPCell cell170ssr1 = new PdfPCell(new Paragraph("Establishment date\r\n",font4));
		cell170ssr1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table04ssr1.addCell(cell170ssr1);

		PdfPCell cell180ssr1 = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti6(): "",font5));
		cell180ssr1.setHorizontalAlignment(Element.ALIGN_CENTER);

		table04ssr1.addCell(cell180ssr1);
		

		table04ssr.addCell(table4ssr1);
//		document.add(table04ssr1);
		table04ssr.setSpacingAfter(20f);
		table04ssr.setSpacingBefore(20f);
		
		//Institution to which the college if affiliated
		
		Paragraph paragraph131ssr = new Paragraph("Institution to which the college if affiliated,font2");
		
		document.add(paragraph131ssr);
		PdfPTable table4ssr11 = new PdfPTable(2);
		table4ssr11.setWidthPercentage(100f);
//		table4ssr11.setWidths(new int[] { 2,2,2});
		table4ssr11.setSpacingBefore(20f);
		table4ssr11.setSpacingAfter(20f);
		PdfPCell cell15ssr111 = new PdfPCell(new Paragraph("State",font4));
		cell15ssr111.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr11.addCell(cell15ssr111);
		PdfPCell cell15ssr112 = new PdfPCell(new Paragraph("Institution Name",font4));
		cell15ssr112.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr11.addCell(cell15ssr112);
//		PdfPCell cell15ssr113 = new PdfPCell(new Paragraph("View Document"));
//		table4ssr11.addCell(cell15ssr113);
		
		
		PdfPCell cell15ssr114 = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti11(): "",font5));
		cell15ssr114.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr11.addCell(cell15ssr114);
		
		PdfPCell cell15ssr115 = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti12(): "",font5));
		cell15ssr115.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr11.addCell(cell15ssr115);
		
		document.add(table4ssr11);
		
		PdfPTable table05ssr = new PdfPTable(1);
		table05ssr.setWidthPercentage(100f);
		
		PdfPCell cell06ssr = new PdfPCell(new Paragraph("Recognized Minority institution\r\n\r\n", font4));
		cell06ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table05ssr.addCell(cell06ssr);

		PdfPTable table5ssr = new PdfPTable(2);
		table5ssr.setWidthPercentage(100f);
		table5ssr.setWidths(new int[] { 70, 70 });
		
		table5ssr.setSpacingBefore(20f);
		table5ssr.setSpacingAfter(20f);

		PdfPCell cell07ssr = new PdfPCell(new Paragraph("If it is a recognized minority institution\r\n\r\n",font4));
		cell07ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell07ssr);
		PdfPCell cell20ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizedMinority().get(0).getInputbtr1():"",font5));
		cell20ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell20ssr);
		PdfPCell cell071ssr = new PdfPCell(new Paragraph("If yes, Specify minority status\r\n",font4));
		cell071ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell071ssr);
		PdfPCell cell201ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizedMinority().get(0).getInputbtr2():"",font5));
		cell201ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell201ssr);

		
		PdfPCell cell0712ssr = new PdfPCell(new Paragraph("Religios\r\n",font4));
		cell0712ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell0712ssr);
		PdfPCell cell2012ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizedMinority().get(0).getInputbtr3():"",font5));
		cell2012ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell2012ssr);
		PdfPCell cell0713ssr = new PdfPCell(new Paragraph("Linguistic\r\n",font4));
		cell0713ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell0713ssr);
		PdfPCell cell2013ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizedMinority().get(0).getInputbtr4():"",font5));
		cell2013ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell2013ssr);
		PdfPCell cell0714ssr = new PdfPCell(new Paragraph("Any Other\r\n",font4));
		cell0714ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell0714ssr);
		PdfPCell cell2014ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizedMinority().get(0).getInputbtr4():"",font5));
		cell2014ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell2014ssr);
		
//		table05ssr.addCell(table5ssr);
		document.add(table05ssr);
		document.add(table5ssr);
		table05ssr.setSpacingAfter(20f);
		table05ssr.setSpacingBefore(20f);

		
		
		PdfPTable table051ssr = new PdfPTable(1);
		table051ssr.setWidthPercentage(100f);
		
		PdfPCell cell061ssr = new PdfPCell(new Paragraph("Recognition Details\r\n\r\n", font4));
		cell061ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table051ssr.addCell(cell061ssr);
		PdfPCell cell062ssr = new PdfPCell(new Paragraph("Date of Recognition by UGC or any Other National Agency",font4));
		cell062ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table051ssr.addCell(cell062ssr);
		
		PdfPTable table51ssr = new PdfPTable(2);
		table51ssr.setWidthPercentage(100f);
		table51ssr.setWidths(new int[] { 70, 70 });
		
		table51ssr.setSpacingBefore(20f);
		table51ssr.setSpacingAfter(20f);

		PdfPCell cell0751ssr = new PdfPCell(new Paragraph("Under Section\r\n\r\n",font4));
		cell0751ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51ssr.addCell(cell0751ssr);
		PdfPCell cell2051ssr = new PdfPCell(new Paragraph("Date",font4));
		cell2051ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51ssr.addCell(cell2051ssr);
		PdfPCell cell07151ssr = new PdfPCell(new Paragraph("2f of UGC\r\n",font4));
		cell07151ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51ssr.addCell(cell07151ssr);
		PdfPCell cell20151ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizationDetails().get(0).getInputbtr6():"",font5));
		cell20151ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51ssr.addCell(cell20151ssr);

		
		PdfPCell cell071251ssr = new PdfPCell(new Paragraph("12B of UGC\r\n",font4));
		cell071251ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51ssr.addCell(cell071251ssr);
		PdfPCell cell201251ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizationDetails().get(0).getInputbtr7():"",font5));
		cell201251ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51ssr.addCell(cell201251ssr);
		
		
//		table051ssr.addCell(table51ssr);
		document.add(table051ssr);
		document.add(table51ssr);
		table05ssr.setSpacingAfter(20f);
		table05ssr.setSpacingBefore(20f);

		
		Paragraph paragraph15ssr = new Paragraph("New programe intriduced diring the last five years \r\n", font4);
		
		document.add(paragraph15ssr);
		
		
		
		
		PdfPTable table510ssr = new PdfPTable(5);
		table510ssr.setWidthPercentage(100f);
//		table510ssr.setWidths(new int[] { 70, 70 });
		
		table510ssr.setSpacingBefore(20f);
		table510ssr.setSpacingAfter(20f);
		
		PdfPCell cell20510ssr = new PdfPCell(new Paragraph(" "));
		
		cell20510ssr.setRowspan(2);
		table510ssr.addCell(cell20510ssr);

		PdfPCell cell07510ssr = new PdfPCell(new Paragraph("No of New programmes introduced during the last five years and name \r\n\r\n",font4));
		cell07510ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell07510ssr.setColspan(2);
		table510ssr.addCell(cell07510ssr);
		
		PdfPCell cell205101ssr = new PdfPCell(new Paragraph("Programs not covered under the Autonomous status of UGC",font4));
		cell205101ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell205101ssr.setColspan(2);
		table510ssr.addCell(cell205101ssr);
		
		
		PdfPCell cell071510ssr = new PdfPCell(new Paragraph("No",font4));
		cell071510ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell071510ssr);
		PdfPCell cell201510ssr = new PdfPCell(new Paragraph("Name",font4));
		cell201510ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201510ssr);

		
		PdfPCell cell0712510ssr = new PdfPCell(new Paragraph("UG",font4));
		cell0712510ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0712510ssr);
		PdfPCell cell2012510ssr = new PdfPCell(new Paragraph("PG",font4));
		cell2012510ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell2012510ssr);
		
		 
		PdfPCell cell07151000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(0).getInputbtp11():"",font5));
		cell07151000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell07151000ssr);
		PdfPCell cell2015100ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(0).getInputbtp12():"",font5));
		cell2015100ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell2015100ssr);
        PdfPCell cell07125101ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(0).getInputbtp13():"",font5));
        cell07125101ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        table510ssr.addCell(cell07125101ssr);
		PdfPCell cell20125101ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(0).getInputbtp14():"",font5 ));
		cell20125101ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell20125101ssr);
		PdfPCell cell201251010ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(0).getInputbtp15():"",font5));
		cell201251010ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201251010ssr);
		
		PdfPCell cell071510001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(1).getInputbtp11():"",font5));
		cell071510001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell071510001ssr);
		PdfPCell cell20151002ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(1).getInputbtp12():"",font5));
		cell20151002ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell20151002ssr);
		PdfPCell cell071251013ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(1).getInputbtp13():"",font5));
		cell071251013ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell071251013ssr);
		PdfPCell cell201251014ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(1).getInputbtp14():"",font5 ));
		cell201251014ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201251014ssr);
		PdfPCell cell2012510105ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(1).getInputbtp15():"",font5));
		cell2012510105ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell2012510105ssr);
		
		PdfPCell cell0715100016ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(2).getInputbtp11():"",font5));
		cell0715100016ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0715100016ssr);
		PdfPCell cell201510027ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(2).getInputbtp12():"",font5));
		cell201510027ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201510027ssr);
		PdfPCell cell0712510138ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(2).getInputbtp13():"",font5));
		cell0712510138ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0712510138ssr);
		PdfPCell cell2012510149ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(2).getInputbtp14():"",font5 ));
		cell2012510149ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell2012510149ssr);
		PdfPCell cell20125101051ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(2).getInputbtp15():"",font5));
		cell20125101051ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell20125101051ssr);
		
		PdfPCell cell0715100012ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(3).getInputbtp11():"",font5));
		cell0715100012ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0715100012ssr);
		PdfPCell cell201510023ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(3).getInputbtp12():"",font5));
		cell201510023ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201510023ssr);
		PdfPCell cell0712510134ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(3).getInputbtp13():"",font5));
		cell0712510134ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0712510134ssr);
		PdfPCell cell2012510145ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(3).getInputbtp14():"",font5 ));
		cell2012510145ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell2012510145ssr);
	
		PdfPCell cell20125101056ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(3).getInputbtp15():"",font5));
		cell20125101056ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell20125101056ssr);
		
		PdfPCell cell0715100017ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(4).getInputbtp11():"",font5));
		cell0715100017ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0715100017ssr);
		PdfPCell cell201510028ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(4).getInputbtp12():"",font5));
		cell201510028ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201510028ssr);
		PdfPCell cell0712510139ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(4).getInputbtp13():"",font5));
		cell0712510139ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0712510139ssr);
		PdfPCell cell2012510140ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(4).getInputbtp14():"",font5 ));
		cell2012510140ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell2012510140ssr);
		PdfPCell cell201251010511ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(4).getInputbtp15():"",font5));
		cell201251010511ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201251010511ssr);
		
//		table051ssr.addCell(table510ssr);
		document.add(table510ssr);
//		table05ssr.setSpacingAfter(20f);
//		table05ssr.setSpacingBefore(20f);

		
		
		
		
		
		PdfPTable table51022ssr = new PdfPTable(3);
		table51022ssr.setWidthPercentage(100f);
//		table51022ssr.setWidths(new int[] { 70, 70 });
		
		table51022ssr.setSpacingBefore(20f);
		table51022ssr.setSpacingAfter(20f);
		
		PdfPCell cell2051011ssr = new PdfPCell(new Paragraph("Programmes offered ",font4));
		cell2051011ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2051011ssr);
		
		PdfPCell cell075104ssr = new PdfPCell(new Paragraph("Aided",font4));
		cell075104ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
	
		table51022ssr.addCell(cell075104ssr);
		
		PdfPCell cell2051012ssr = new PdfPCell(new Paragraph("Self-financed",font4));
		cell2051012ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2051012ssr);
		
		PdfPCell cell0715103ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(0).getInputpot1():"",font5));
		cell0715103ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell0715103ssr);
		PdfPCell cell2015104ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(0).getInputpot2():"",font5));
		cell2015104ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2015104ssr); 
		PdfPCell cell071251033ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(0).getInputpot3():"",font5));
		cell071251033ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell071251033ssr);
		PdfPCell cell201251033ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(1).getInputpot1():"",font5));
		cell201251033ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell201251033ssr);
		PdfPCell cell0715100022ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(1).getInputpot2():"",font5));
		cell0715100022ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell0715100022ssr);
		PdfPCell cell201510022ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(1).getInputpot3():"",font5));
		cell201510022ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell201510022ssr);
        PdfPCell cell071251011ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(2).getInputpot1():"",font5));
        cell071251011ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        table51022ssr.addCell(cell071251011ssr);
		PdfPCell cell201251012ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(2).getInputpot2():"",font5 ));
		cell201251012ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell201251012ssr);
		PdfPCell cell2012510101ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(2).getInputpot3():"",font5));
		cell2012510101ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2012510101ssr);
		
		PdfPCell cell20510110ssr = new PdfPCell(new Paragraph("Professional Programmes offered ",font4));
		cell20510110ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell20510110ssr);
		
		PdfPCell cell0751049ssr = new PdfPCell(new Paragraph(""));
		cell0751049ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell0751049ssr);
		
		PdfPCell cell20510128ssr = new PdfPCell(new Paragraph(""));
		cell20510128ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell20510128ssr);
		
		PdfPCell cell07151037ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(0).getInputpopt1():"",font5));
		cell07151037ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell07151037ssr);
		PdfPCell cell20151046ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(0).getInputpopt2():"",font5));
		cell20151046ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell20151046ssr); 
		PdfPCell cell0712510335ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(0).getInputpopt3():"",font5));
		cell0712510335ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell0712510335ssr);
		PdfPCell cell2012510334ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(1).getInputpopt1():"",font5));
		cell2012510334ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2012510334ssr);
		PdfPCell cell07151000223ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(1).getInputpopt2():"",font5));
		cell07151000223ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell07151000223ssr);
		PdfPCell cell2015100222ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(1).getInputpopt3():"",font5));
		cell2015100222ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2015100222ssr);
        PdfPCell cell0712510111ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(2).getInputpopt1():"",font5));
        cell0712510111ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        table51022ssr.addCell(cell0712510111ssr);
		PdfPCell cell2012510122ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(2).getInputpopt2():"" ,font5));
		cell2012510122ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2012510122ssr);
		PdfPCell cell20125101013ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(2).getInputpopt2():"",font5));
		cell20125101013ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell20125101013ssr);
		
		document.add(table51022ssr);
		
	
		
		PdfPTable table06ssr = new PdfPTable(1);
		table06ssr.setWidthPercentage(100f);

		PdfPCell cell08ssr = new PdfPCell(new Paragraph("Establishment Details\r\n\r\n", font4));
		cell08ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table06ssr.addCell(cell08ssr);
		table06ssr.setSpacingBefore(20f);
		table06ssr.setSpacingAfter(20f);
		

		PdfPTable table6ssr = new PdfPTable(2);
		table6ssr.setWidthPercentage(100f);
		table6ssr.setWidths(new int[] { 75, 75 });
		
		table6ssr.setSpacingBefore(20f);
		table6ssr.setSpacingAfter(20f);

		PdfPCell cell21ssr = new PdfPCell(
				new Paragraph("Date of Establishment, Prior to the Grant of 'Autonomy'\r\n\r\n",font4));
		cell21ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		table6ssr.addCell(cell21ssr);

		PdfPCell cell22ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti4(): "",font5));
		cell22ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6ssr.addCell(cell22ssr);

		PdfPCell cell23ssr = new PdfPCell(new Paragraph("Date of Grant of 'Autonomy' to the college by UGC \r\n\r\n",font4));
		cell23ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6ssr.addCell(cell23ssr);

		PdfPCell cell24ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti6(): "",font5));
		cell24ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6ssr.addCell(cell24ssr);

		table4ssr.addCell(cell21ssr);


//		table06ssr.addCell(table6ssr);
		document.add(table06ssr);
		document.add(table6ssr);
		table06ssr.setSpacingAfter(20f);
		table06ssr.setSpacingBefore(20f);

		PdfPTable table010ssr = new PdfPTable(1);
		table010ssr.setWidthPercentage(100f);
		PdfPTable table07ssr = new PdfPTable(1);
		table07ssr.setWidthPercentage(100f);

		PdfPCell cell09ssr = new PdfPCell(new Paragraph("University to which the college is affiliated\r\n\r\n\r", font4));
		cell09ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table07ssr.addCell(cell09ssr);

		PdfPTable table7ssr = new PdfPTable(3);
		table7ssr.setWidthPercentage(100f);

		table7ssr.setSpacingBefore(20f);
		table7ssr.setSpacingAfter(20f);

		cell.setPhrase(new Phrase("State\r\n\r\n", font4));
		table7ssr.addCell(cell);
		cell.setPhrase(new Phrase("University name\r\n\r\n", font4));
		table7ssr.addCell(cell);
		cell.setPhrase(new Phrase("Document\r\n\r\n", font4));
		table7ssr.addCell(cell);

		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti11(): "",font5));
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti12(): "",font5));
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti13(): "",font5));

		cell.setPadding(5);

		table07ssr.addCell(table7ssr);
//		document.add(table07ssr);
		table07ssr.setSpacingAfter(20f);
		table07ssr.setSpacingBefore(20f);

		PdfPTable table08ssr = new PdfPTable(1);
		table08ssr.setWidthPercentage(100f);

		PdfPCell cell121ssr = new PdfPCell(new Paragraph("Details of UGC recognition\r\n\r\n", font4));
		cell01ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table08ssr.addCell(cell121ssr);

		PdfPTable table8ssr = new PdfPTable(3);
		table8ssr.setWidthPercentage(100f);
		table8ssr.setWidths(new int[] { 60, 60, 60 });
		
		table8ssr.setSpacingBefore(20f);
		table8ssr.setSpacingAfter(20f);
		
		


		cell.setPhrase(new Phrase("Under Section", font4));
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase("Date", font4));
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase("View Document", font4));
		table8ssr.addCell(cell);
		//<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
		
		cell.setPhrase(new Phrase("2f of UGC",font4));
		table8ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognizationDetails().get(0).getInputbtr6(): "",font5));
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase());
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase("12B of UGC",font4));
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognizationDetails().get(0).getInputbtr6(): "",font5));
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase());
		table8ssr.addCell(cell);
		
		table8ssr.setSpacingAfter(20f);
		table8ssr.setSpacingBefore(20f);

//		table08ssr.addCell(table8ssr);
		document.add(table08ssr);
		document.add(table8ssr);
		
		
		
		
		
		
		///////////////
		


		PdfPTable table09ssr = new PdfPTable(1);
		table09ssr.setWidthPercentage(100f);
		PdfPCell cell122ssr = new PdfPCell(new Paragraph(
				"Details of recognition/approval by stationary/regulatory bodies like AICTE,NCTE,MCI,DCI,PCI,RCI etc(other than UGC)",
				font4));
		cell122ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table09ssr.addCell(cell122ssr);
		PdfPTable table9ssr = new PdfPTable(5);
		table9ssr.setWidthPercentage(100f);
		table9ssr.setWidths(new int[] { 70, 70, 70, 70, 70 });
		table9ssr.setSpacingBefore(20);
		table9ssr.setSpacingAfter(20);

		cell.setPhrase(new Phrase("Statutory Regulatory Authority\r\n\r\n", font4));
		table9ssr.addCell(cell);
		cell.setPhrase(new Phrase("Recognition/App roval details Inst itution/Departme nt programme\r\n\r\n", font4));
		table9ssr.addCell(cell);
		cell.setPhrase(new Phrase("Day,Month and year(dd-mm- yyyy)\r\n\r\n", font4));
		table9ssr.addCell(cell);
		cell.setPhrase(new Phrase("Validity in months\r\n\r\n", font4));
		table9ssr.addCell(cell);
		cell.setPhrase(new Phrase("Remarks\r\n\r\n", font4));
		table9ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd15():"",font5));
		table9ssr.addCell(cell);

		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd11():"",font5));
		table9ssr.addCell(cell);

		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd12():"",font5));
		table9ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd13():"",font5));
		table9ssr.addCell(cell);

		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd14():"",font5));
		
		table9ssr.addCell(cell);

//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd16():""));
//		table9ssr.addCell(cell);


		cell.setPadding(5);
//		table09ssr.addCell(table9ssr);
		document.add(table09ssr);
		document.add(table9ssr);
		table09ssr.setSpacingAfter(20f);
		table09ssr.setSpacingBefore(20f);

		table010ssr.addCell(table07ssr);
		table010ssr.addCell(table08ssr);
		table010ssr.addCell(table09ssr);
		table010ssr.setSpacingAfter(20f);
		table010ssr.setSpacingBefore(20f);

		PdfPTable table011ssr = new PdfPTable(1);
		table011ssr.setWidthPercentage(100f);
		PdfPCell cell011ssr = new PdfPCell(new Paragraph("Recognitions\r\n\r\n", font4));
		cell011ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table01ssr.addCell(cell011ssr);
		PdfPTable table11ssr = new PdfPTable(2);
		table11ssr.setWidthPercentage(100f);
		table11ssr.setWidths(new int[] { 3, 3 });
		
		table11ssr.setSpacingBefore(20f);
		table11ssr.setSpacingAfter(20f);
		
		
		
		PdfPCell cell300ssr = new PdfPCell(new Paragraph("Institution with Potential for Excellence",font4));
		cell300ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell300ssr);

		PdfPCell cell30ssr = new PdfPCell(new Paragraph(
				"Is the College recognized by UGC as a College with Potential for Excellence(CPE)?",font4));
		cell30ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell30ssr);

		PdfPCell cell31ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.basicprofile2.get(0).getInputbtip1():"",font5));
		cell31ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell31ssr);

		PdfPCell cell32ssr = new PdfPCell(new Paragraph(
				"Is the College recognized for its performance by any other governmental agency?\r\n\r\n" + "\r\n",font4));
		cell32ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell32ssr);

		PdfPCell cell28ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.basicprofile2.get(0).getInputbtip4():"",font5));
		cell28ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell28ssr);

		PdfPCell cell29ssr = new PdfPCell(new Paragraph("If yes, name of the agency\r\n\r\n",font4));
		cell29ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell29ssr);

		PdfPCell cell131ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.basicprofile2.get(0).getInputbtip5():"",font5));
		cell131ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell131ssr);

		PdfPCell cell132ssr = new PdfPCell(new Paragraph("Date of recognition\r\n\r\n",font4));
		cell132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell132ssr);

		PdfPCell cell133ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.basicprofile2.get(0).getInputbtip6():"",font5));
		cell133ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell133ssr);

//		table011ssr.addCell(table11ssr);
		document.add(table011ssr);
		document.add(table11ssr);
		table011ssr.setSpacingAfter(20f);

		PdfPTable table012ssr = new PdfPTable(1);
		table012ssr.setWidthPercentage(100f);

		PdfPCell cell012ssr = new PdfPCell(new Paragraph("Location and Area of Campus\r\n\r\n", font4));
		cell012ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table012ssr.addCell(cell012ssr);

		PdfPTable table12ssr = new PdfPTable(5);
		table12ssr.setWidthPercentage(100f);
		table12ssr.setWidths(new int[] { 60, 60, 60, 60, 60 });
		table12ssr.setSpacingAfter(20f);
		table12ssr.setSpacingBefore(20f);
//
		cell.setPhrase(new Phrase("Campus Type\r\n\r\n", font4));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase("Address\r\n\r\n", font4));
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase("Location\r\n\r\n", font4));
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase("Campus Area in Acres\r\n\r\n", font4));
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase("Built up Area in sq.mts.\r\n\r\n", font4));
		table12ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.campus.get(0).getInputbtl11():"",font5));
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.campus.get(0).getInputbtl12():"",font5));
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.campus.get(0).getInputbtl13():"",font5));
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.campus.get(0).getInputbtl14():"",font5));
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.campus.get(0).getInputbtl15():"",font5));
		table12ssr.addCell(cell);
	
		cell.setPadding(5);

//		table012ssr.addCell(table12ssr);
		document.add(table012ssr);
		document.add(table12ssr);
		table012ssr.setSpacingAfter(20f);

	
/////////////////////////////////////////

		Paragraph paragraph150ssr = new Paragraph(" ACADEMIC INFORMATION\r\n\r\n", font1);
		paragraph150ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph150ssr);
		PdfPTable table013ssr = new PdfPTable(1);
		table013ssr.setWidthPercentage(100f);
		table013ssr.setSpacingBefore(5);
		PdfPCell cell013ssr = new PdfPCell(new Paragraph(
				"Details of Programmes Offered by the College (Give Data for Current Academic year)", font4));
		table013ssr.addCell(cell013ssr);

		PdfPTable table13ssr = new PdfPTable(7);
		table13ssr.setWidthPercentage(100f);
		table13ssr.setWidths(new int[] {60, 60, 60, 60, 60 ,60,60 });
		table13ssr.setSpacingBefore(10f);
//		PdfPCell cell = new PdfPCell();
		cell.setPhrase(new Phrase("Programme Level\r\n\r\n", font4));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase("Name of Programme/C ourse\r\n\r\n", font4));
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase("Duration in Months\r\n\r\n", font4));
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase("Entry Qualification\r\n\r\n\r\n", font4));
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase("Medium of Instruction\r\n\r\n", font4));
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase("Sanctioned Strength\r\n\r\n", font4));
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase("No.of Students AdmittedSanctioned Strength\r\n\r\n\r\n", font4));
		table13ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad11():"",font5));
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad12():"",font5));
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad13():"",font5));
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad14():"",font5));
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad15():"",font5));
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad16():"",font5));
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad17():"",font5));
		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase());
//		
//	
		cell.setPadding(5);
//		table013ssr.addCell(table13ssr);
		table013ssr.setSpacingAfter(20f);
		
		document.add(table013ssr);
		document.add(table13ssr);


		Paragraph paragraph16ssr1 = new Paragraph("Position Details of Faculty & Staff in the College\r\n",
				font4);
		paragraph16ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph16ssr1);

		PdfPTable table17ssr = new PdfPTable(13);
		PdfPTable table18ssr = new PdfPTable(1);
		
		  float[] columnWidths = { 70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f }; // Second column will be // twice as first and third
		  table17ssr.setWidths(columnWidths);

      // Setting width of table, its columns and spacing
		table17ssr.setWidthPercentage(100);
		table18ssr.setWidthPercentage(100);

		PdfPCell cell014ssr = new PdfPCell(new Paragraph("",font4));
		cell014ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell015ssr = new PdfPCell(new Paragraph("Professor\r\n",font4));
		cell015ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell015ssr.setColspan(4);
		PdfPCell cell0191ssr = new PdfPCell(new Paragraph("Associate Professor\r\n",font4));
		cell0191ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0191ssr.setColspan(4);
		PdfPCell cell0237ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n",font4));
		cell0237ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0237ssr.setColspan(4);
		PdfPCell cell0181ssr = new PdfPCell(new Paragraph("",font4));
		cell0181ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		// document.add(cell0192ssr);

		PdfPCell cell0203ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell0203ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0214ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell0214ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0225ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell0225ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0236ssr = new PdfPCell(new Paragraph("Total\r\n",font4));
		cell0236ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0246ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell0246ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0258ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell0258ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0269ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell0269ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0271ssr = new PdfPCell(new Paragraph("Total\r\n",font4));
		cell0271ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0282ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell0282ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0293ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell0293ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0304ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell0304ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0315ssr = new PdfPCell(new Paragraph("Total\r\n",font4));
		cell0315ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0326ssr = new PdfPCell(new Paragraph("Sanctioned by the UGC/University State Government\r\n",font4));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
	
		
		PdfPCell cell0337sr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat11():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0371ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat12():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0382ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat13():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0333sr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat14():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0375ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat15():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0386ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat16():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03377sr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat17():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0378ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat18():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0389ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat19():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03890ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat10():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell cell03310sr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat111():"",font5));
        cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell cell0311ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat112():"",font5));
        cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell0394ssr = new PdfPCell(new Paragraph("Recruited",font4));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0405ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat11():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0416ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat12():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0427ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat13():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0438ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat14():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0449ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat15():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0451ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat16():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0452ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat17():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0453ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat18():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0454ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat19():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04540ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat10():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell0455ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat111():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0456ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat112():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell032612ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n\r\n",font4));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell033722ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat11():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell037212ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat12():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell038312ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat13():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell033721ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat14():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0372121ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat15():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0383122ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat16():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0337223ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat17():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0372124ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat18():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);PdfPCell cell0383125ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat19():"",font5));
		PdfPCell cell03831250ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat10():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0337226ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat111():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0372127ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat112():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        
		PdfPCell cell03261ssr = new PdfPCell(
				new Paragraph("Sanctioned by the Management/Society or Other Authorized Bodies\r\n\r\n",font4));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell03371ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat11():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03721ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat12():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03831ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat13():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03372ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat14():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03723ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat15():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03833ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat16():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03374ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat17():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03725ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat18():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03836ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat19():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell038360ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat10():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03377ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat111():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03728ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat112():"",font5));
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
	
		PdfPCell cell03941ssr = new PdfPCell(new Paragraph("Recruted\r\n",font4));
		cell03941ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04052ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat11():"",font5));
		cell04052ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04163ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat12():"",font5));
		cell04163ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04274ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat13():"",font5));
		cell04274ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04385ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat14():"",font5));
		cell04385ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04496ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat15():"",font5));
		cell04496ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04517ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat16():"",font5));
		cell04517ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04528ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat17():"",font5));
		cell04528ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04539ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat18():"",font5));
		cell04539ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04541ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat19():"",font5));
		cell04541ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04552ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat10():"",font5));
		cell04552ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04563ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat111():"",font5));
		cell04563ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04547ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat112():"",font5));
		cell04547ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell032611ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n",font4));
		cell032611ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell0337210ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat11():"",font5));
		cell0337210ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell037213ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat12():"",font5));
		cell037213ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell038314ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat13():"",font5));
		cell038314ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03372101ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat14():"",font5));
		cell03372101ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0372132ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat15():"",font5));
		cell0372132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0383143ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat16():"",font5));
		cell0383143ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03372104ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat17():"",font5));
		cell03372104ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0372135ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat18():"",font5));
		cell0372135ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0383146ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat19():"",font5));
		cell0383146ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03372107ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat10():"",font5));
		cell03372107ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0372138ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat111():"",font5));
		cell0372138ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0383149ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat112():"",font5));
		cell0383149ssr.setHorizontalAlignment(Element.ALIGN_CENTER);


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
		 table17ssr.addCell(cell0371ssr);
		 table17ssr.addCell(cell0382ssr);
		 table17ssr.addCell(cell0333sr);
		 table17ssr.addCell(cell0375ssr);
		 table17ssr.addCell(cell0386ssr);
		 table17ssr.addCell(cell03377sr);
		 table17ssr.addCell(cell0378ssr);
		 table17ssr.addCell(cell0389ssr);
		 table17ssr.addCell(cell03890ssr);
		 table17ssr.addCell(cell03310sr);
		 table17ssr.addCell(cell0311ssr);
			
//		 table17ssr.addCell(cell0348sr);
//		 table17ssr.addCell(cell0359ssr);
//		 table17ssr.addCell(cell0361ssr);
//		table17ssr.addCell(cell0372ssr);
//		table17ssr.addCell(cell0383ssr);
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
		table17ssr.addCell(cell04540ssr);

		table17ssr.addCell(cell0455ssr);
		table17ssr.addCell(cell0456ssr);
//		table17ssr.addCell(cell0457ssr);

		table17ssr.addCell(cell032612ssr);
		 table17ssr.addCell(cell033722ssr);
		 table17ssr.addCell(cell037212ssr);
		 table17ssr.addCell(cell038312ssr);
		 table17ssr.addCell(cell033721ssr);
		 table17ssr.addCell(cell0372121ssr);
		 table17ssr.addCell(cell0383122ssr);
		 table17ssr.addCell(cell0337223ssr);
		 table17ssr.addCell(cell0372124ssr);
		 table17ssr.addCell(cell0383125ssr);
		 table17ssr.addCell(cell03831250ssr);

		 table17ssr.addCell(cell0337226ssr);
		 table17ssr.addCell(cell0372127ssr);
//		table17ssr.addCell(cell033722ssr);
//		table17ssr.addCell(cell037212ssr);
//		table17ssr.addCell(cell038312ssr);

		table17ssr.addCell(cell03261ssr);
		table17ssr.addCell(cell03371ssr);
        table17ssr.addCell(cell03721ssr);
        table17ssr.addCell(cell03831ssr);
        table17ssr.addCell(cell03372ssr);
        table17ssr.addCell(cell03723ssr);
        table17ssr.addCell(cell03833ssr);
        table17ssr.addCell(cell03374ssr);
        table17ssr.addCell(cell03725ssr);
        table17ssr.addCell(cell03836ssr);
        table17ssr.addCell(cell038360ssr);

        table17ssr.addCell(cell03377ssr);
        table17ssr.addCell(cell03728ssr);
//		table17ssr.addCell(cell033722ssr);
//		table17ssr.addCell(cell03721ssr);
//		table17ssr.addCell(cell03831ssr);

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
		table17ssr.addCell(cell0337210ssr);
		table17ssr.addCell(cell037213ssr);
		table17ssr.addCell(cell038314ssr);
		table17ssr.addCell(cell03372101ssr);
		table17ssr.addCell(cell0372132ssr);
		table17ssr.addCell(cell0383143ssr);
		table17ssr.addCell(cell03372104ssr);
		table17ssr.addCell(cell0372135ssr);
		table17ssr.addCell(cell0383146ssr);
		table17ssr.addCell(cell03372107ssr);
		table17ssr.addCell(cell0372138ssr);
		table17ssr.addCell(cell0383149ssr);

//		table17ssr.addCell(cell033721ssr);
//		table17ssr.addCell(cell037213ssr);
//		table17ssr.addCell(cell038314ssr);

		
		PdfPCell cell0189ssr = new PdfPCell(new Paragraph("Teaching Faculty\r\n",font4));
		cell0189ssr.setHorizontalAlignment(Element.ALIGN_CENTER);


		table18ssr.addCell(cell0189ssr);


//		table18ssr.addCell(table17ssr);

		// cell015ssr.addElement(new Paragraph(""));
		// cell015ssr.addElement(new Paragraph(""));
		// cell015ssr.addElement(new Paragraph(""));
		// cell015ssr.addElement(new Paragraph(""));

		table18ssr.setSpacingBefore(20f);
		table18ssr.setSpacingAfter(20f);

		document.add(table18ssr);
		document.add(table17ssr);

		PdfPTable table19ssr = new PdfPTable(5);
		PdfPTable table20ssr = new PdfPTable(1);
		
		  float[] columnWidths1 = { 7f }; // Second column will be // twice as first and third
		  table20ssr.setWidths(columnWidths1);


// Setting width of table, its columns and spacing
		table19ssr.setWidthPercentage(100);
		table20ssr.setWidthPercentage(100);

		PdfPCell cell018ssr = new PdfPCell(new Paragraph(""));
		cell018ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell019ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell019ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell020ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell020ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell021ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell021ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell022ssr = new PdfPCell(new Paragraph("Total\r\n",font4));
		cell022ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0221ssr = new PdfPCell(new Paragraph("Sanctioned by the UGC /University State Government\r\n\r\n",font4));
		cell0221ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0222ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(0).getInputatnt11():"",font5));
		cell0222ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0223ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(0).getInputatnt12():"",font5));
		cell0223ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0224ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(0).getInputatnt13():"",font5));
		cell0224ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0226ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(0).getInputatnt14():"",font5));
		cell0226ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0227ssr = new PdfPCell(new Paragraph("Recruited\r\n",font4));
		cell0227ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0228ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(1).getInputatnt11():"",font5));
		cell0228ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0229ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(1).getInputatnt12():"",font5));
		cell0229ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0230ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(1).getInputatnt13():"",font5));
		cell0230ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0231ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(1).getInputatnt14():"",font5));
		cell0231ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0232ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n",font4));
		cell0232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0233ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(2).getInputatnt11():"",font5));
		cell0233ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0234ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(2).getInputatnt12():"",font5));
		cell0234ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0235ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(2).getInputatnt13():"",font5));
		cell0235ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0238ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(2).getInputatnt14():"",font5));
		cell0238ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0239ssr = new PdfPCell(
				new Paragraph("Sanctioned by the Management/Society or Other Authorized Bodies\r\n\r\n",font4));
		cell0239ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0240ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(3).getInputatnt11():"",font5));
		cell0240ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0241ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(3).getInputatnt12():"",font5));
		cell0241ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0242ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(3).getInputatnt13():"",font5));
		cell0242ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0243ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(3).getInputatnt14():"",font5));
		cell0243ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0244ssr = new PdfPCell(new Paragraph("Recruited\r\n",font4));
		cell0244ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0245ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(4).getInputatnt11():"",font5));
		cell0245ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0247ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(4).getInputatnt12():"",font5));
		cell0247ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0248ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(4).getInputatnt13():"",font5));
		cell0248ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0249ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(4).getInputatnt14():"",font5));
		cell0249ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0250ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n",font4));
		cell0250ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0251ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(5).getInputatnt11():"",font5));
		cell0251ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0252ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(5).getInputatnt12():"",font5));
		cell0252ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0253ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(5).getInputatnt13():"",font5));
		cell0253ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0254ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(5).getInputatnt14():"",font5));
		cell0254ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
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


		
        PdfPCell cell0188ssr = new PdfPCell(new Paragraph("Non-Teaching Staff\r\n",font4));
        cell0188ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
        table20ssr.addCell(cell0188ssr);

//		table20ssr.addCell(table19ssr);

		table20ssr.setSpacingBefore(20f);
		table20ssr.setSpacingAfter(20f);

		document.add(table20ssr);
		document.add(table19ssr);

		PdfPTable table21ssr = new PdfPTable(5);
		PdfPTable table22ssr = new PdfPTable(1);
		
		 float[] columnWidths2 = { 7f }; // Second column will be // twice as first and third
		 table22ssr.setWidths(columnWidths2);

// Setting width of table, its columns and spacing
		table21ssr.setWidthPercentage(100);
		table22ssr.setWidthPercentage(100);

		PdfPCell cell023ssr = new PdfPCell(new Paragraph(""));
		cell023ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell024ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell024ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell025ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell025ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell026ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell026ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell027ssr = new PdfPCell(new Paragraph("Total\r\n",font4));
		cell027ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0023ssr = new PdfPCell(new Paragraph("Sanctioned by the UGC /University State Government\r\n",font4));
		cell0023ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0123ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(0).getInputatt15():"",font5));
		cell0123ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0323ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(0).getInputatt16():"",font5));
		cell0323ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0423ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(0).getInputatt17():"",font5));
		cell0423ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0523ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(0).getInputatt18():"",font5));
		cell0523ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell0623ssr = new PdfPCell(new Paragraph("Recruited\r\n",font4));
		cell0623ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0723ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(1).getInputatt15():"",font5));
		cell0723ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0823ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(1).getInputatt16():"",font5));
		cell0823ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0923ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(1).getInputatt17():"",font5));
		cell0923ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01023ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(1).getInputatt18():"",font5));
		cell01023ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell01123ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n",font4));
		cell01123ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01223ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(2).getInputatt15():"",font5));
		cell01223ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01323ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(2).getInputatt16():"",font5));
		cell01323ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01423ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(2).getInputatt17():"",font5));
		cell01423ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01523ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(2).getInputatt18():"",font5));
		cell01523ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell01623ssr = new PdfPCell(
				new Paragraph("Sanctioned by the Management/Society or Other Authorized Bodies\r\n",font4));
		cell01623ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01723ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(3).getInputatt15():"",font5));
		cell01723ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01823ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(3).getInputatt16():"",font5));
		cell01823ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01923ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(3).getInputatt17():"",font5));
		cell01923ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02023ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(3).getInputatt18():"",font5));
		cell02023ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell02123ssr = new PdfPCell(new Paragraph("Recruited\r\n",font4));
		cell02123ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02223ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(4).getInputatt15():"",font5));
		cell02223ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02323ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(4).getInputatt16():"",font5));
		cell02323ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02423ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(4).getInputatt17():"",font5));
		cell02423ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02523ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(4).getInputatt18():"",font5));
		cell02523ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell02623ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n",font4));
		cell02623ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02723ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(5).getInputatt15():"",font5));
		cell02723ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02823ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(5).getInputatt16():"",font5));
		cell02823ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02923ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(5).getInputatt17():"",font5));
		cell02923ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03023ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(5).getInputatt18():"",font5));
		cell03023ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

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

	
		
	   PdfPCell cell0187ssr = new PdfPCell(new Paragraph("Technical Staff\r\n",font4));
	   cell0187ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
	   table22ssr.addCell(cell0187ssr);

//		table22ssr.addCell(table21ssr);

		table22ssr.setSpacingBefore(20f);
		table22ssr.setSpacingAfter(20f);

		document.add(table22ssr);
		document.add(table21ssr);

		Paragraph paragraph19ssr = new Paragraph("Qualification Details of the Teaching Staff\r\n",font4);
		paragraph19ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph19ssr);
		

		PdfPTable table23ssr = new PdfPTable(11);
		PdfPTable table24ssr = new PdfPTable(1);
		
		 float[] columnWidths3 = { 70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f }; // Second column will be // twice as first and third
		 table23ssr.setWidths(columnWidths3);
		 
// Setting width of table, its columns and spacing
		table23ssr.setWidthPercentage(100);
		table24ssr.setWidthPercentage(100);

		PdfPCell cell028ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n	",font4));
		cell028ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell029ssr = new PdfPCell(new Paragraph("Professor\r\n",font4));
		cell029ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell029ssr.setColspan(3);
		PdfPCell cell030ssr = new PdfPCell(new Paragraph("Associate Professor\r\n",font4));
		cell030ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell030ssr.setColspan(3);
		PdfPCell cell031ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n",font4));
		cell031ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell031ssr.setColspan(3);
		PdfPCell cell032ssr = new PdfPCell(new Paragraph(""));
		cell032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0324ssr = new PdfPCell(new Paragraph(""));
		cell0324ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	

		PdfPCell cell0132ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell0132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0332ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell0332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0432ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell0432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0532ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell0532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0632ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell0632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0732ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell0732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0832ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell0832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0932ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell0932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell01032ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell01032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell01132ssr = new PdfPCell(new Paragraph("total\r\n",font4));
		cell01132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	

		PdfPCell cell01232ssr = new PdfPCell(new Paragraph("D.sc/D.Litt/ LLD/DM/M CH\r\n",font4));
		cell01232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell01332ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(0).getInputatq11():"",font5));
		cell01332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell01432ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(0).getInputatq12():"",font5));
		cell01432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell01532ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(0).getInputatq13():"",font5));
		cell01532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell01632ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(0).getInputatq14():"",font5));
		cell01632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell01732ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(0).getInputatq15():"",font5));
		cell01732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell01832ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(0).getInputatq16():"",font5));
		cell01832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell01932ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(0).getInputatq17():"",font5));
		cell01932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell02032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(0).getInputatq18():"",font5));
		cell02032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell02132ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(0).getInputatq19():"",font5));
		cell02132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		PdfPCell cell02232ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(0).getInputatq110():"",font5));
		cell02232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		 PdfPCell cell02332ssr = new PdfPCell(new Paragraph("Ph.D.\r\n",font4));
		 cell02332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 PdfPCell cell02432ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(1).getInputatq11():"",font5));
		 cell02432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 PdfPCell cell02532ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(1).getInputatq12():"",font5));
		 cell02532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 PdfPCell cell02632ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(1).getInputatq13():"",font5));
		 cell02632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell02732ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(1).getInputatq14():"",font5));
		cell02732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell02832ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(1).getInputatq15():"",font5));
		cell02832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell02932ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(1).getInputatq16():"",font5));
		cell02932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell03032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(1).getInputatq17():"",font5));
		cell03032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell03132ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(1).getInputatq18():"",font5));
		cell03132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell03232ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(1).getInputatq19():"",font5));
		cell03232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell03332ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(1).getInputatq110():"",font5));
		cell03332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		PdfPCell cell034321ssr = new PdfPCell(new Paragraph("M.Phil.\r\n",font4));
		cell034321ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell03532ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(2).getInputatq11():"",font5));
		cell03532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell03632ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(2).getInputatq12():"",font5));
		cell03632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell03732ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(2).getInputatq13():"",font5));
		cell03732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell03832ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(2).getInputatq14():"",font5));
		cell03832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell03932ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(2).getInputatq15():"",font5));
		cell03932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell04032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(2).getInputatq16():"",font5));
		cell04032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		PdfPCell cell04132ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(2).getInputatq17():"",font5));
		cell04132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell04232ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(2).getInputatq18():"",font5));
		cell04232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell04332ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(2).getInputatq19():"",font5));
		cell04332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell04432ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(2).getInputatq110():"",font5));
		cell04432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 
		PdfPCell cell04532ssr = new PdfPCell(new Paragraph("PG\r\n",font4));
		cell04532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell04632ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(3).getInputatq11():"",font5));
		cell04632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell04732ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(3).getInputatq12():"",font5));
		cell04732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell04832ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(3).getInputatq13():"",font5));
		cell04832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell04932ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(3).getInputatq14():"",font5));
		cell04932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(3).getInputatq15():"",font5));
		cell05032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05132ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(3).getInputatq16():"",font5));
		cell05132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05232ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(3).getInputatq17():"",font5));
		cell05232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05332ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(3).getInputatq18():"",font5));
		cell05332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05432ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(3).getInputatq19():"",font5));
		cell05432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05532ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.academicPerminentTeachers.get(3).getInputatq110():"",font5));
		cell05532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05632ssr = new PdfPCell(new Paragraph("UG\r\n",font4));
		cell05632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05732ssr = new PdfPCell(new Paragraph());
		cell05732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05832ssr = new PdfPCell(new Paragraph());
		cell05832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05932ssr = new PdfPCell(new Paragraph());
		cell05932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		PdfPCell cell06032ssr = new PdfPCell(new Paragraph());
		cell06032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell06132ssr = new PdfPCell(new Paragraph());
		cell06132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell06232ssr = new PdfPCell(new Paragraph());
		cell06232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell06332ssr = new PdfPCell(new Paragraph());
		cell06332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell06432ssr = new PdfPCell(new Paragraph());
		cell06432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell06532ssr = new PdfPCell(new Paragraph());
		cell06532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell06632ssr = new PdfPCell(new Paragraph());
		cell06632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 
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


		 PdfPCell cell0186ssr = new PdfPCell(new Paragraph("Permanent Teachers\r\n",font4));
		 cell0186ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 table24ssr.addCell(cell0186ssr);

//
//		table24ssr.addCell(table23ssr);

		table24ssr.setSpacingBefore(20f);
		table24ssr.setSpacingAfter(20f);

		document.add(table24ssr);
		document.add(table23ssr);
		
		
		
		

		PdfPTable table27ssr = new PdfPTable(11);
		PdfPTable table28ssr = new PdfPTable(1);
		
		 float[] columnWidth4 = { 7f }; // Second column will be // twice as first and third
		 table28ssr.setWidths(columnWidth4);


// Setting width of table, its columns and spacing
		table27ssr.setWidthPercentage(100);
		table28ssr.setWidthPercentage(100);

		PdfPCell cell038ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n",font4));
		cell038ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell039ssr = new PdfPCell(new Paragraph("Professor\r\n",font4));
		cell039ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell039ssr.setColspan(3);
		PdfPCell cell040ssr = new PdfPCell(new Paragraph("Associate Professor\r\n",font4));
		cell040ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell040ssr.setColspan(3);
		PdfPCell cell041ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n",font4));
		cell041ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell041ssr.setColspan(3);
		PdfPCell cell042ssr = new PdfPCell(new Paragraph("",font4));
		cell042ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0138ssr = new PdfPCell(new Paragraph("",font4));
		cell0138ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	

		PdfPCell cell000132ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell000132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell000332ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell000332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell000432ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell000432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell000532ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell000532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell000632ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell000632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell000732ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell000732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell000832ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell000832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell000932ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell000932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0001032ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell0001032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0001132ssr = new PdfPCell(new Paragraph("total\r\n",font4));
		cell0001132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	

		PdfPCell cell001232ssr = new PdfPCell(new Paragraph("D.sc/D.Litt/ LLD/DM/M CH\r\n",font4));
		cell001232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell001332ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq51():"",font5));
		cell001332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell001432ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq52():"",font5));
		cell001432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell001532ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq53():"",font5));
		cell001532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 PdfPCell cell001632ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq54():"",font5));
		 cell001632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 PdfPCell cell001732ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq55():"",font5));
		 cell001732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 PdfPCell cell001832ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq56():"",font5));
		 cell001832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell001932ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq57():"",font5));
		cell001932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell002032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq58():"",font5));
		cell002032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell002132ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq59():"",font5));
		cell002132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		 PdfPCell cell002232ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq510():"",font5));
		 cell002232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 
		PdfPCell cell020332ssr = new PdfPCell(new Paragraph("Ph.D.\r\n",font4));
		cell020332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell020432ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq51():"",font5));
		cell020432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell020532ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq52():"",font5));
		cell020532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell020632ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq53():"",font5));
		cell020632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 
		PdfPCell cell020732ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq54():"",font5));
		cell020732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell020832ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq55():"",font5));
		cell020832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell020932ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq56():"",font5));
		cell020932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		 PdfPCell cell030032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq57():"",font5));
		 cell030032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 PdfPCell cell031032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq58():"",font5));
		 cell031032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 PdfPCell cell032032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq59():"",font5));
		 cell032032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 PdfPCell cell033032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq510():"",font5));
		 cell033032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 
		PdfPCell cell034320ssr = new PdfPCell(new Paragraph("M.Phil.\r\n",font4));
		cell034320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell035320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq51():"",font5));
		cell035320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell036320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq52():"",font5));
		cell036320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell037320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq53():"",font5));
		cell037320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 
		PdfPCell cell038320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq54():"",font5));
		cell038320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell039320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq55():"",font5));
		cell039320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell040320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq56():"",font5));
		cell040320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		PdfPCell cell041320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq57():"",font5));
		cell041320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell042320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq58():"",font5));
		cell042320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell043320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq59():"",font5));
		cell043320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell044320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq510():"",font5));
		cell044320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell045320ssr = new PdfPCell(new Paragraph("PG\r\n",font4));
		cell045320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell046320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq51():"",font5));
		cell046320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell047320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq52():"",font5));
		cell047320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell048320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq53():"",font5));
		cell048320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell049320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq54():"",font5));
		cell049320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell050320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq55():"",font5));
		cell050320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell051320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq56():"",font5));
		cell051320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 
		PdfPCell cell052320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq57():"",font5));
		cell052320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell053320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq58():"",font5));
		cell053320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell054320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq59():"",font5));
		cell054320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell055320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq510():"",font5));
		cell055320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
//		PdfPCell cell056320ssr = new PdfPCell(new Paragraph("UG\r\n"));
//		PdfPCell cell057320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(4).getInputatq51():""));
//		PdfPCell cell058320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(4).getInputatq52():""));
//		PdfPCell cell059320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(4).getInputatq53():""));
//
//		PdfPCell cell060320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(4).getInputatq54():""));
//		PdfPCell cell061320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(4).getInputatq55():""));
//		PdfPCell cell062320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(4).getInputatq56():""));
//
//		PdfPCell cell063320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(4).getInputatq57():""));
//		PdfPCell cell064320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(4).getInputatq58():""));
//		PdfPCell cell065320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(4).getInputatq59():""));
//
//		PdfPCell cell066320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(4).getInputatq510():""));

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

//		table27ssr.addCell(cell056320ssr);
//		table27ssr.addCell(cell057320ssr);
//		table27ssr.addCell(cell058320ssr);
//		table27ssr.addCell(cell059320ssr);
//		table27ssr.addCell(cell060320ssr);
//		table27ssr.addCell(cell061320ssr);
//		table27ssr.addCell(cell062320ssr);
//		table27ssr.addCell(cell063320ssr);
//		table27ssr.addCell(cell064320ssr);
//		table27ssr.addCell(cell065320ssr);
//		table27ssr.addCell(cell066320ssr);

		
		 PdfPCell cell0185ssr = new PdfPCell(new Paragraph("Temporary Teachers\r\n",font4));
		 cell0185ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 table28ssr.addCell(cell0185ssr);
	
//		 table28ssr.addCell(table27ssr);
			
		table28ssr.setSpacingBefore(20f);
		table28ssr.setSpacingAfter(20f);

		document.add(table28ssr);
		document.add(table27ssr);

		PdfPTable table29ssr = new PdfPTable(11);
		PdfPTable table30ssr = new PdfPTable(1);
		
		 float[] columnWidth5 = { 7f }; // Second column will be // twice as first and third
		 table30ssr.setWidths(columnWidth5);


// Setting width of table, its columns and spacing
		table29ssr.setWidthPercentage(100);
		table30ssr.setWidthPercentage(100);

		PdfPCell cell043ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n",font4));
		cell043ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell044ssr = new PdfPCell(new Paragraph("Professor\r\n"));
		cell044ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell044ssr.setColspan(3);
		PdfPCell cell045ssr = new PdfPCell(new Paragraph("Associate Professor\r\n",font4));
		cell045ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell045ssr.setColspan(3);
		PdfPCell cell046ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n",font4));
		cell046ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell046ssr.setColspan(3);
		PdfPCell cell048ssr = new PdfPCell(new Paragraph(""));
		cell048ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell04308ssr = new PdfPCell(new Paragraph(""));
		cell04308ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	

		PdfPCell cell0001320ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell0001320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0003320ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell0003320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0004320ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell0004320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0005320ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell0005320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0006320ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell0006320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0007320ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell0007320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0008320ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell0008320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0009320ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell0009320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell00010302ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell00010302ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell00011320ssr = new PdfPCell(new Paragraph("total\r\n",font4));
		cell00011320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	

		PdfPCell cell0012320ssr = new PdfPCell(new Paragraph("D.sc/D.Litt/ LLD/DM/M CH",font4));
		cell0012320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0013320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq91():"",font5));
		cell0013320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0014320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq92():"",font5));
		cell0014320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0015320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq93():"",font5));
		cell0015320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0016320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq94():"",font5));
		cell0016320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0017320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq95():"",font5));
		cell0017320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0018320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq96():"",font5));
		cell0018320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0019320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq97():"",font5));
		cell0019320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0020320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq98():"",font5));
		cell0020320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0021320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq99():"",font5));
		cell0021320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0022320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq910():"",font5));
		cell0022320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0203320ssr = new PdfPCell(new Paragraph("Ph.D.\r\n",font4));
		cell0203320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0204320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq91():"",font5));
		cell0204320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0205320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq92():"",font5));
		cell0205320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0206320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq93():"",font5));
		cell0206320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0207320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq94():"",font5));
		cell0207320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0208320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq95():"",font5));
		cell0208320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0209320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq96():"",font5));
		cell0209320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0300320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq97():"",font5));
		cell0300320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0310320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq98():"",font5));
		cell0310320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0320320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq99():"",font5));
		cell0320320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0330320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq910():"",font5));
		cell0330320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0343200ssr = new PdfPCell(new Paragraph("M.Phil.\r\n",font4));
		cell0343200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0353200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq91():"",font5));
		cell0353200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0363200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq92():"",font5));
		cell0363200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0373200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq93():"",font5));
		cell0373200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0383200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq94():"",font5));
		cell0383200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0393200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq95():"",font5));
		cell0393200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0403200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq96():"",font5));
		cell0403200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0413200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq97():"",font5));
		cell0413200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0423200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq98():"",font5));
		cell0423200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0433200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq99():"",font5));
		cell0433200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0443200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq910():"",font5));
		cell0443200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0453200ssr = new PdfPCell(new Paragraph("PG\r\n",font4));
		cell0453200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0463200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq91():"",font5));
		cell0463200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0473200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq92():"",font5));
		cell0473200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0483200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq93():"",font5));
		cell0483200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0493200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq94():"",font5));
		cell0493200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0503200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq95():"",font5));
		cell0503200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0513200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq96():"",font5));
		cell0513200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0523200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq97():"",font5));
		cell0523200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0533200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq98():"",font5));
		cell0533200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0543200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq99():"",font5));
		cell0543200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0553200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq910():"",font5));
		cell0553200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
//		PdfPCell cell0563200ssr = new PdfPCell(new Paragraph("UG\r\n"));
//		PdfPCell cell0573200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(4).getInputatq91():""));
//		PdfPCell cell0583200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(4).getInputatq92():""));
//		PdfPCell cell0593200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(4).getInputatq93():""));
//
//		PdfPCell cell0603200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(4).getInputatq94():""));
//		PdfPCell cell0613200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(4).getInputatq95():""));
//		PdfPCell cell0623200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(4).getInputatq96():""));
//
//		PdfPCell cell0633200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(4).getInputatq97():""));
//		PdfPCell cell0643200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(4).getInputatq98():""));
//		PdfPCell cell0653200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(4).getInputatq99():""));
//
//		PdfPCell cell0663200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(4).getInputatq910():""));

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
//
//		table29ssr.addCell(cell0563200ssr);
//		table29ssr.addCell(cell0573200ssr);
//		table29ssr.addCell(cell0583200ssr);
//		table29ssr.addCell(cell0593200ssr);
//		table29ssr.addCell(cell0603200ssr);
//		table29ssr.addCell(cell0613200ssr);
//		table29ssr.addCell(cell0623200ssr);
//		table29ssr.addCell(cell0633200ssr);
//		table29ssr.addCell(cell0643200ssr);
//		table29ssr.addCell(cell0653200ssr);
//		table29ssr.addCell(cell0663200ssr);
//
	
	
		 PdfPCell cell0184ssr = new PdfPCell(new Paragraph("Part Time Teachers\r\n",font4));
		 cell0184ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 table30ssr.addCell(cell0184ssr);
	

//		table30ssr.addCell(table29ssr);

		table30ssr.setSpacingBefore(20f);
		table30ssr.setSpacingAfter(20f);

		document.add(table30ssr);
		document.add(table29ssr);

		PdfPTable table33ssr = new PdfPTable(5);
		PdfPTable table34ssr = new PdfPTable(1);
		
	 float[] columnWidth6 = { 7f }; // Second column will be // twice as first and third
		 table34ssr.setWidths(columnWidth6);

     // Setting width of table, its columns and spacing
		table33ssr.setWidthPercentage(100);
		table34ssr.setWidthPercentage(100);

		PdfPCell cell054ssr = new PdfPCell(new Paragraph("Number of Visiting/Guest Faculty engaged with the college?\r\n",font4));
		
		cell054ssr.setRowspan(2);
		
		
     	PdfPCell cell055ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
     	cell055ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
     	PdfPCell cell056ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
   	 cell0184ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
     	PdfPCell cell057ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
     	cell057ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
     	PdfPCell cell058ssr = new PdfPCell(new Paragraph("Total\r\n",font4));
     	cell058ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0551ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getDetailsofVisitingFaculties().get(0).getInputatg11():"",font5));
		cell0551ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0561ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getDetailsofVisitingFaculties().get(0).getInputatg12():"",font5));
		cell0561ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0571ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getDetailsofVisitingFaculties().get(0).getInputatg13():"",font5));
		cell0571ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
    	
		PdfPCell cell0581ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getDetailsofVisitingFaculties().get(0).getInputatg14():"",font5));
		cell0581ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	

     	table33ssr.addCell(cell054ssr);
		table33ssr.addCell(cell055ssr);
		table33ssr.addCell(cell0551ssr);
		table33ssr.addCell(cell056ssr);
		table33ssr.addCell(cell0561ssr);
    	table33ssr.addCell(cell057ssr);
    	table33ssr.addCell(cell0571ssr);
		table33ssr.addCell(cell058ssr);
		table33ssr.addCell(cell0581ssr);


		PdfPCell cell05810ssr = new PdfPCell(new Paragraph("Details of Visting/Guest Faculties\r\n",font4));
		cell05810ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		table34ssr.addCell(cell05810ssr);
//		table34ssr.addCell(table33ssr);

		table34ssr.setSpacingBefore(20f);
		table34ssr.setSpacingAfter(20f);

		document.add(table34ssr);
		document.add(table33ssr);

		Paragraph paragraph29ssr = new Paragraph(
				"Provide the Following Details of Students Enrolled in the College During the Current Academic Year\r\n",
				font4);
		paragraph29ssr.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(paragraph29ssr);

		PdfPTable table35ssr = new PdfPTable(7);
		


// Setting width of table, its columns and spacing
		table35ssr.setWidthPercentage(100);

		PdfPCell cell059ssr = new PdfPCell(new Paragraph("Programme\r\n	",font4));
		cell059ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		cell059ssr.setColspan(2);

		PdfPCell cell0591ssr = new PdfPCell(new Paragraph("UG\r\n", font4));
		cell0591ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell0591ssr.setRowspan(3);

		PdfPCell cell0592ssr = new PdfPCell(new Paragraph("male\r\n",font4));
		cell0592ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0593ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(0).getInputas00():"",font5));
		cell0593ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0594ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(0).getInputas11():"",font5));
		cell0594ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0595ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(0).getInputas12():"",font5));
		cell0595ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0596ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(0).getInputas13():"",font5));
		cell0596ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0597ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(0).getInputas14():"",font5));
		cell0597ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		 PdfPCell cell0599ssr = new PdfPCell(new Paragraph("female\r\n",font4));
		 cell0599ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05910ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(1).getInputas00():"",font5));
		cell05910ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 
		PdfPCell cell05911ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(1).getInputas11():"",font5));
		cell05911ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05912ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(1).getInputas12():"",font5));
		cell05912ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05913ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(1).getInputas13():"",font5));
		cell05913ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05914ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(1).getInputas14():"",font5));
		cell05914ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05916ssr = new PdfPCell(new Paragraph("others\r\n",font4));
		cell05916ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05917ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(2).getInputas00():"",font5));
		cell05917ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05918ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(2).getInputas11():"",font5));
		cell05918ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05919ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(2).getInputas12():"",font5));
		cell05919ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05920ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(2).getInputas13():"",font5));
		cell05920ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05921ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(2).getInputas14():"",font5));
		cell05921ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05923ssr = new PdfPCell(new Paragraph("PG\r\n", font4));
		cell05923ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell05923ssr.setRowspan(3);
		
		PdfPCell cell05924ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell05924ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05925ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(3).getInputas00():"",font5));
		cell05925ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05926ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(3).getInputas11():"",font5));
		cell05926ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05927ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(3).getInputas12():"",font5));
		cell05927ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05928ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(3).getInputas13():"",font5));
		cell05928ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05929ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(3).getInputas14():"",font5));
		cell05929ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05930ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell05930ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05931ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(4).getInputas00():"",font5));
		cell05931ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell059321ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(4).getInputas11():"",font5));
		cell059321ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05933ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(4).getInputas12():"",font5));
		cell05933ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05934ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(4).getInputas13():"",font5));
		cell05934ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05935ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(4).getInputas14():"",font5));
		cell05935ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05936ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell05936ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05937ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(5).getInputas00():"",font5));
		cell05937ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05938ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(5).getInputas11():"",font5));
		cell05938ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05939ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(5).getInputas12():"",font5));
		cell05939ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05940ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(5).getInputas13():"",font5));
		cell05940ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05941ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(5).getInputas14():"",font5));
		cell05941ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
//		PdfPCell cell05942ssr = new PdfPCell(new Paragraph(""));
//		PdfPCell cell05943ssr = new PdfPCell(new Paragraph(""));

		
		PdfPCell cell060ssr = new PdfPCell(new Paragraph("From the State Where College is Located\r\n", font4));
		cell060ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0610ssr = new PdfPCell(new Paragraph("From Other States of India\r\n",font4));
		cell0610ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0621ssr = new PdfPCell(new Paragraph("NRI Students\r\n",font4));
		cell0621ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell063ssr = new PdfPCell(new Paragraph("Foreign Students\r\n",font4));
		cell063ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell064ssr = new PdfPCell(new Paragraph("Total\r\n",font4));
		cell064ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	

		table35ssr.addCell(cell059ssr);
		//table35ssr.addCell(cell0601ssr);
		table35ssr.addCell(cell060ssr);
		table35ssr.addCell(cell0610ssr);
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

		PdfPCell cell065ssr = new PdfPCell(new Paragraph("Programme\r\n", font4));
		cell065ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell065ssr.setColspan(2);
	
		PdfPCell cell059111ssr = new PdfPCell(new Paragraph("SC\r\n",font4));
		cell059111ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell059111ssr.setRowspan(3);

		PdfPCell cell059211ssr = new PdfPCell(new Paragraph("male\r\n",font4));
		cell059211ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell059312ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(0).getInputaa11():"",font5));
		cell059312ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell059413ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(0).getInputaa12():"",font5));
		cell059413ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell059514ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(0).getInputaa13():"",font5));
		cell059514ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell059615ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(0).getInputaa14():"",font5));
		cell059615ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		PdfPCell cell059916ssr = new PdfPCell(new Paragraph("female\r\n",font4));
		cell059916ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0591017ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(1).getInputaa11():"",font5));
		cell0591017ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0591118ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(1).getInputaa12():"",font5));
		cell0591118ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0591219ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(1).getInputaa13():"",font5));
		cell0591219ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0591320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(1).getInputaa14():"",font5));
		cell0591320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0591621ssr = new PdfPCell(new Paragraph("others\r\n",font4));
		cell0591621ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0591722ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(2).getInputaa11():"",font5));
		cell0591722ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05918232ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(2).getInputaa12():"",font5));
		cell05918232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0591924ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(2).getInputaa13():"",font5));
		cell0591924ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0592025ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(2).getInputaa11():"",font5));
		cell0592025ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		PdfPCell cell066ssr = new PdfPCell(new Paragraph("Year 1\r\n\r\n", font4));
		cell066ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell067ssr = new PdfPCell(new Paragraph("Year 2\r\n\r\n", font4));
		cell067ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell068ssr = new PdfPCell(new Paragraph("Year 3\r\n\r\n", font4));
		cell068ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell069ssr = new PdfPCell(new Paragraph("Year 4\r\n\r\n", font4));
		cell069ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	

		
		
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
		
		
		
		
	
		PdfPCell cell0592300ssr = new PdfPCell(new Paragraph("ST\r\n",font4));
		cell0592300ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		cell0592300ssr.setRowspan(3);
		
		PdfPCell cell0592400ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
		cell0592400ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0592500ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(3).getInputaa11():"",font5));
		cell0592500ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0592600ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(3).getInputaa12():"",font5));
		cell0592600ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0592700ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(3).getInputaa13():"",font5));
		cell0592700ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0592800ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(3).getInputaa14():"",font5));
		cell0592800ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0593000ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell0593000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0593100ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(4).getInputaa11():"",font5));
		cell0593100ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05932100ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(4).getInputaa12():"",font5));
		cell05932100ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0593300ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(4).getInputaa13():"",font5));
		cell0593300ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0593500ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(4).getInputaa14():"",font5));
		cell0593500ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0593600ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell0593600ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0593700ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(5).getInputaa11():"",font5));
		cell0593700ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0593800ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(5).getInputaa12():"",font5));
		cell0593800ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0593900ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(5).getInputaa13():"",font5));
		cell0593900ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell0594000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(5).getInputaa14():"",font5));
		cell0594000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
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
		
	
       PdfPCell cell05923000ssr = new PdfPCell(new Paragraph("OBC\r\n",font4));
       cell05923000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
       cell05923000ssr.setRowspan(3);
		
		PdfPCell cell05924000ssr = new PdfPCell(new Paragraph("Male\r\n"));
		cell05924000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05925000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(6).getInputaa11():"",font5));
		cell05925000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05926000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(6).getInputaa12():"",font5));
		cell05926000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05927000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(6).getInputaa13():"",font5));
		cell05927000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05928000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(6).getInputaa14():"",font5));
		cell05928000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05930000ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
		cell05930000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05931000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(7).getInputaa11():"",font5));
		cell05931000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell059321000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(7).getInputaa12():"",font5));
		cell059321000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05933000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(7).getInputaa13():"",font5));
		cell05933000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05935000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(7).getInputaa14():"",font5));
		cell05935000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05936000ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
		cell05936000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05937000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(8).getInputaa11():"",font5));
		cell05937000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05938000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(8).getInputaa12():"",font5));
		cell05938000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05939000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(8).getInputaa13():"",font5));
		cell05939000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		PdfPCell cell05940000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(8).getInputaa14():"",font5));
		cell05940000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
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
	
		 PdfPCell cell059230000ssr = new PdfPCell(new Paragraph("General\r\n",font4));
		 cell059230000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
		 cell059230000ssr.setRowspan(3);
			
			PdfPCell cell059240000ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
			cell059240000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell059250000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(9).getInputaa11():"",font5));
			cell059250000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell059260000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(9).getInputaa12():"",font5));
			cell059260000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell059270000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(9).getInputaa13():"",font5));
			cell059270000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell059280000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(9).getInputaa14():"",font5));
			cell059280000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
			PdfPCell cell059300000ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
			cell059300000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell059310000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(10).getInputaa11():"",font5));
			cell059310000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell0593210000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(10).getInputaa12():"",font5));
			cell0593210000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell059330000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(10).getInputaa13():"",font5));
			cell059330000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell059350000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(10).getInputaa14():"",font5));
			cell059350000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
			PdfPCell cell059360000ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
			cell059360000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell059370000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(11).getInputaa11():"",font5));
			cell059370000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell059380000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(11).getInputaa12():"",font5));
			cell059380000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell059390000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(11).getInputaa13():"",font5));
			cell059390000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell059400000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(11).getInputaa14():"",font5));
			cell059400000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			
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
		
			
			
		
			 PdfPCell cell059230001ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
			 cell059230001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
			 cell059230001ssr.setRowspan(3);
				
				PdfPCell cell059240001ssr = new PdfPCell(new Paragraph("Male\r\n",font4));
				cell059240001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059250001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(12).getInputaa11():"",font5));
				cell059250001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059260001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(12).getInputaa12():"",font5));
				cell059260001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059270001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(12).getInputaa13():"",font5));
				cell059270001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059280001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(12).getInputaa14():"",font5));
				cell059280001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059300001ssr = new PdfPCell(new Paragraph("Female\r\n",font4));
				cell059300001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059310002ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(13).getInputaa14():"",font5));
				cell059310002ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell0593210003ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(13).getInputaa14():"",font5));
				cell0593210003ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059330001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(13).getInputaa14():"",font5));
				cell059330001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059350001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(13).getInputaa14():"",font5));
				cell059350001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059360001ssr = new PdfPCell(new Paragraph("Others\r\n",font4));
				cell059360001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059370001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(14).getInputaa14():"",font5));
				cell059370001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059380001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(14).getInputaa14():"",font5));
				cell059380001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059390001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(14).getInputaa14():"",font5));
				cell059390001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059400001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(14).getInputaa14():"",font5));
				cell059400001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell0650ssr = new PdfPCell(new Paragraph("Total\r\n",font4));
				cell0650ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				cell0650ssr.setColspan(2);
			
				PdfPCell cell059370011ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(15).getInputaa14():"",font5));
				cell059370011ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059380011ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(15).getInputaa14():"",font5));
				cell059380011ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059390011ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(15).getInputaa14():"",font5));
				cell059390011ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				PdfPCell cell059400011ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(15).getInputaa14():"",font5));
				cell059400011ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				
				
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
						"Provide the Following Details of Students admitted to the College During the last four Academic Years\r\n",font4));
				cell0691ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
				table37ssr.addCell(cell0691ssr);
		
		
		
		
		
//		table37ssr.addCell(table36ssr);

		table37ssr.setSpacingBefore(20f);
		table37ssr.setSpacingAfter(20f);

		document.add(table37ssr);
		document.add(table36ssr);

		
		///////////////////////////////////////////////////////////////////
		///////////
		Paragraph paragraph15ssr1 = new Paragraph(" Evaluative report of the department\r\n\r\n", font1);
		paragraph15ssr1.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph15ssr1);

		PdfPTable table60 = new PdfPTable(2);
		table60.setWidthPercentage(100);
		// inside inside table6
		/*
		 * com.lowagie.text.Font font15 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		 * font15.setColor(CMYKColor.BLACK);
		 */
		if (ssrData.getEvaluativeReport() != null) {
			PdfPCell cell09criteria7 = new PdfPCell(new Paragraph(
					ssrData != null ? ssrData.getEvaluativeReport().get(0).getValuet1() : "",font5)); // dnam1
			cell09criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell010criteria7 = new PdfPCell(new Paragraph(
					ssrData != null ? ssrData.getEvaluativeFileupload().get(0).getEvaluative_filePath()
							: "",font5));// file
			cell010criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell011criteria7 = new PdfPCell(new Paragraph(new Paragraph(
					ssrData != null ? ssrData.getEvaluativeReport().get(0).getValuet1() : "",font5)));
			cell011criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell012criteria7 = new PdfPCell(new Paragraph(
					ssrData != null ? ssrData.getEvaluativeFileupload().get(1).getEvaluative_filePath()
							: ""));
			cell012criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell013criteria7 = new PdfPCell(new Paragraph(new Paragraph(
					ssrData != null ? ssrData.getEvaluativeReport().get(0).getValuet1() : "",font5)));
			cell013criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell09criteria17 = new PdfPCell(new Paragraph(
					ssrData != null ? ssrData.getEvaluativeFileupload().get(1).getEvaluative_filePath()
							: ""));
			cell09criteria17.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell010criteria17 = new PdfPCell(new Paragraph(new Paragraph(
					ssrData != null ? ssrData.getEvaluativeReport().get(0).getValuet1() : "",font5)));
			cell010criteria17.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell011criteria17 = new PdfPCell(new Paragraph(
					ssrData != null ? ssrData.getEvaluativeFileupload().get(1).getEvaluative_filePath()
							: "",font5));
			cell011criteria17.setHorizontalAlignment(Element.ALIGN_CENTER);

			table60.addCell(cell09criteria7);
			table60.addCell(cell010criteria7);
			table60.addCell(cell011criteria7);
			table60.addCell(cell012criteria7);
			table60.addCell(cell013criteria7);
			table60.addCell(cell09criteria17);
			table60.addCell(cell010criteria17);
			table60.addCell(cell011criteria17);

		///	table60.setSpacingBefore(20f);
			table60.setSpacingAfter(20f);

			document.add(table60);

////////////////////////////////////////////////////////////////////////////////////////////////////
			Paragraph paragraphep = new Paragraph("Extended Profile\r\n", font1);
			paragraphep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph1ep = new Paragraph("1 Program\r\n\r\n", font2);
			paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			Paragraph paragraph2ep = new Paragraph(
					"1.1\r\n" + "Number of programs offered year-wise for last five years\r\n\r\n", font4);
			paragraph2ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraphep);
			document.add(paragraph1ep);
			document.add(paragraph2ep);

//			PdfPTable table1ep = new PdfPTable(2);
//			table1ep.setWidthPercentage(100);
	//
//			PdfPCell cell1ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			
//			cell1ep.setBackgroundColor(RGBColor.green);
//			
//			PdfPCell cell2ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			cell2ep.setBackgroundColor(RGBColor.green);
//			
//			PdfPCell cell3ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			cell3ep.setBackgroundColor(RGBColor.blue);
//			
//			PdfPCell cell4ep = new PdfPCell(new Paragraph(" "));
//			cell4ep.setBackgroundColor(RGBColor.blue);
//			
//			table1ep.addCell(cell1ep);
//			table1ep.addCell(cell2ep);
//			table1ep.addCell(cell3ep);
//			table1ep.addCell(cell4ep);
	//
//			table1ep.setSpacingBefore(20f);
//			table1ep.setSpacingAfter(20f);
	//
//			document.add(table1ep);

			Table epprogramme = new Table(epRecord.getEpYeartable11().size(), 2);

			epprogramme.setPadding(5);
			epprogramme.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable11().size(); i++) {
				
				Cell cell21 = new Cell(new Paragraph(epRecord.getEpYeartable11().get(i).getInput11y(),font5));
				cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
				epprogramme.addCell(cell21);

			}
			for (int i = 0; i < epRecord.getEpYeartable11().size(); i++) {
				Cell cell2 = new Cell(new Paragraph(epRecord.getEpYeartable11().get(i).getInput11v(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				epprogramme.addCell(cell2);

			}

			document.add(epprogramme);
			Paragraph paragraph3ep = new Paragraph("\r\n 1.2\r\n" + "Number of departments offering academic programmes\r\n\r\n"
					+ "Response:" + (epRecord != null ? epRecord.geteTable12v() : ""), font4);
			paragraph3ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph3ep);

			Paragraph paragraph4ep = new Paragraph("2 \r\n Students", font2);
			paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph4ep);

			Paragraph paragraph5ep = new Paragraph(
					"2.1\r\n" + "Number of students year-wise during last five years\r\n" + "\r\n" + "", font4);
			paragraph5ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph5ep);

//			PdfPTable table2ep = new PdfPTable(2);
//			table2ep.setWidthPercentage(100);
	//
//			PdfPCell cell5ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell6ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell7ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell8ep = new PdfPCell(new Paragraph(" "));
	//
//			table2ep.addCell(cell5ep);
//			table2ep.addCell(cell6ep);
//			table2ep.addCell(cell7ep);
//			table2ep.addCell(cell8ep);
	//
//			table2ep.setSpacingBefore(20f);
//			table2ep.setSpacingAfter(20f);
	//
//			document.add(table2ep);

			Table epstudent21 = new Table(epRecord.getEpYeartable21().size(), 2);

			epstudent21.setPadding(5);
			epstudent21.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable21().size(); i++) {
				

			

				Cell cell3 = new Cell(new Paragraph(epRecord.getEpYeartable21().get(i).getInput21y(),font5));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent21.addCell(cell3);


			}
			for (int i = 0; i < epRecord.getEpYeartable21().size(); i++) {
				Cell cell4 = new Cell(new Paragraph(epRecord.getEpYeartable21().get(i).getInput21v(),font5));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent21.addCell(cell4);

			}

			document.add(epstudent21);

			Paragraph paragraph6ep = new Paragraph(
					"2.2\r\n" + "Number of outgoing / final year students year-wise during last five years\r\n" + "",
					font4);
			paragraph6ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph6ep);

//			PdfPTable table3ep = new PdfPTable(2);
//			table3ep.setWidthPercentage(100);
	//
//			PdfPCell cell9ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell10ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell11ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell12ep = new PdfPCell(new Paragraph(" "));
	//
//			table3ep.addCell(cell9ep);
//			table3ep.addCell(cell10ep);
//			table3ep.addCell(cell11ep);
//			table3ep.addCell(cell12ep);
	//
//			table3ep.setSpacingBefore(20f);
//			table3ep.setSpacingAfter(20f);
	//
//			document.add(table3ep);

			Table epstudent22 = new Table(epRecord.getEpYeartable22().size(), 2);

			epstudent22.setPadding(5);
			epstudent22.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable22().size(); i++) {
				
				
				
				Cell cell5 = new Cell(new Paragraph(epRecord.getEpYeartable22().get(i).getInput22y(),font5));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent22.addCell(cell5);

			}
			for (int i = 0; i < epRecord.getEpYeartable22().size(); i++) {
				
				
				Cell cell6 = new Cell(new Paragraph(epRecord.getEpYeartable22().get(i).getInput22v(),font5));
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent22.addCell(cell6);
				

			}

			document.add(epstudent22);

			Paragraph paragraph7ep = new Paragraph("2.3\r\n"
					+ "Number of students appeared in the examination conducted by the Institution, year-wise during the last five years\r\n"
					+ "", font4);
			paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph7ep);

//			PdfPTable table4ep = new PdfPTable(2);
//			table4ep.setWidthPercentage(100);
	//
//			PdfPCell cell13ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell14ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell15ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell16ep = new PdfPCell(new Paragraph(" "));
	//
//			table4ep.addCell(cell13ep);
//			table4ep.addCell(cell14ep);
//			table4ep.addCell(cell15ep);
//			table4ep.addCell(cell16ep);
	//
//			table4ep.setSpacingBefore(20f);
//			table4ep.setSpacingAfter(20f);
	//
//			document.add(table4ep);

			Table epstudent23 = new Table(epRecord.getEpYeartable23().size(), 2);

			epstudent23.setPadding(5);
			epstudent23.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable23().size(); i++) {
				
				
				Cell cell7 = new Cell(new Paragraph(epRecord.getEpYeartable23().get(i).getInput23y(),font5));
				cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent23.addCell(cell7);

			}
			for (int i = 0; i < epRecord.getEpYeartable23().size(); i++) {
				
				
				Cell cell8 = new Cell(new Paragraph(epRecord.getEpYeartable23().get(i).getInput23y(),font5));
				cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent23.addCell(cell8);
			}

			document.add(epstudent23);

			Paragraph paragraph8ep = new Paragraph(
					"2.4\r\n" + "\r\n" + "Number of revaluation applications year-wise during last five years\r\n" + "",
					font4);
			paragraph8ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph8ep);

//			PdfPTable table5ep = new PdfPTable(2);
//			table5ep.setWidthPercentage(100);
	//
//			PdfPCell cell17ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n\r\n", font3));
//			PdfPCell cell18ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell19ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell20ep = new PdfPCell(new Paragraph(" "));
	//
//			table5ep.addCell(cell17ep);
//			table5ep.addCell(cell18ep);
//			table5ep.addCell(cell19ep);
//			table5ep.addCell(cell20ep);
	//
//			table5ep.setSpacingBefore(20f);
//			table5ep.setSpacingAfter(20f);
	//
//			document.add(table5ep);

			Table epstudent24 = new Table(epRecord.getEpYeartable24().size(), 2);

			epstudent24.setPadding(5);
			epstudent24.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable24().size(); i++) {
				
				
				Cell cell9 = new Cell(new Paragraph(epRecord.getEpYeartable24().get(i).getInput24y(),font5));
				cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent24.addCell(cell9);

			}
			for (int i = 0; i < epRecord.getEpYeartable24().size(); i++) {
				
				
				Cell cell10 = new Cell(new Paragraph(epRecord.getEpYeartable24().get(i).getInput24y(),font5));
				cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent24.addCell(cell10);
			}

			document.add(epstudent24);

			Paragraph paragraph9ep = new Paragraph("3 Teachers\r\n", font2);
			paragraph9ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph9ep);

			Paragraph paragraph10ep = new Paragraph(
					"3.1\r\n" + "Number of courses in all programs year-wise during last five years\r\n" + "\r\n" + "",
					font4);
			paragraph10ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph10ep);

//			PdfPTable table6ep = new PdfPTable(2);
//			table6ep.setWidthPercentage(100);
	//
//			PdfPCell cell21ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell22ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell23ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell24ep = new PdfPCell(new Paragraph(" "));
	//
//			table6ep.addCell(cell21ep);
//			table6ep.addCell(cell22ep);
//			table6ep.addCell(cell23ep);
//			table6ep.addCell(cell24ep);
	//
//			table6ep.setSpacingBefore(20f);
//			table6ep.setSpacingAfter(20f);
	//
//			document.add(table6ep);

			Table epstudent31 = new Table(epRecord.getEpYeartable31().size(), 2);

			epstudent31.setPadding(5);
			epstudent31.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable31().size(); i++) {
				
				
				Cell cell11 = new Cell(new Paragraph(epRecord.getEpYeartable31().get(i).getInput31y(),font5));
				cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent31.addCell(cell11);
			}
			for (int i = 0; i < epRecord.getEpYeartable31().size(); i++) {
				
				
				Cell cell12 = new Cell(new Paragraph(epRecord.getEpYeartable31().get(i).getInput31v(),font5));
				cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent31.addCell(cell12);

			}

			document.add(epstudent31);

			Paragraph paragraph11ep = new Paragraph(
					"3.2\r\n" + "\r\n" + "Number of full time teachers year-wise during the last five years\r\n" + "",
					font4);
			paragraph11ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph11ep);

//			PdfPTable table7ep = new PdfPTable(2);
//			table7ep.setWidthPercentage(100);
	//
//			PdfPCell cell25ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell26ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell27ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell28ep = new PdfPCell(new Paragraph(" "));
	//
//			table7ep.addCell(cell25ep);
//			table7ep.addCell(cell26ep);
//			table7ep.addCell(cell27ep);
//			table7ep.addCell(cell28ep);
	//
//			table7ep.setSpacingBefore(20f);
//			table7ep.setSpacingAfter(20f);
	//
//			document.add(table7ep);

			Table epstudent32 = new Table(epRecord.getEpYeartable32().size(), 2);

			epstudent32.setPadding(5);
			epstudent32.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable32().size(); i++) {
				
				
				Cell cell13 = new Cell(new Paragraph(epRecord.getEpYeartable32().get(i).getInput32y(),font5));
				cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent32.addCell(cell13);

			}
			for (int i = 0; i < epRecord.getEpYeartable32().size(); i++) {
				Cell cell14 = new Cell(new Paragraph(epRecord.getEpYeartable32().get(i).getInput32y(),font5));
				cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent32.addCell(cell14);

			}

			document.add(epstudent32);

			Paragraph paragraph12ep = new Paragraph(
					"3.3\r\n" + "Number of sanctioned posts year-wise during last five years\r\n" + "\r\n" + "", font4);
			paragraph12ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph12ep);

//			PdfPTable table8ep = new PdfPTable(2);
//			table8ep.setWidthPercentage(100);
	//
//			PdfPCell cell29ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell30ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell31ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell32ep = new PdfPCell(new Paragraph(" "));
	//
//			table8ep.addCell(cell29ep);
//			table8ep.addCell(cell30ep);
//			table8ep.addCell(cell31ep);
//			table8ep.addCell(cell32ep);
	//
//			table8ep.setSpacingBefore(20f);
//			table8ep.setSpacingAfter(20f);
	//
//			document.add(table8ep);

			Table epstudent33 = new Table(epRecord.getEpYeartable33().size(), 2);

			epstudent33.setPadding(5);
			epstudent33.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable33().size(); i++) {
				
				
				
				Cell cell15 = new Cell(new Paragraph(epRecord.getEpYeartable33().get(i).getInput33y(),font5));
				cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent33.addCell(cell15);

			}
			for (int i = 0; i < epRecord.getEpYeartable33().size(); i++) {
				
				
				Cell cell16 = new Cell(new Paragraph(epRecord.getEpYeartable33().get(i).getInput33v(),font5));
				cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent33.addCell(cell16);

			}

			document.add(epstudent33);

			Paragraph paragraph13ep = new Paragraph("4 Institution\r\n", font2);
			paragraph13ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph13ep);

			Paragraph paragraph14ep = new Paragraph("4.1\r\n"
					+ "Number of eligible applications received for admissions to all the programs year-wise during last five years\r\n"
					+ "", font4);
			paragraph14ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph14ep);

//			PdfPTable table9ep = new PdfPTable(2);
//			table9ep.setWidthPercentage(100);
	//
//			PdfPCell cell33ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell34ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell35ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell36ep = new PdfPCell(new Paragraph(" "));
	//
//			table9ep.addCell(cell33ep);
//			table9ep.addCell(cell34ep);
//			table9ep.addCell(cell35ep);
//			table9ep.addCell(cell36ep);
	//
//			table9ep.setSpacingBefore(20f);
//			table9ep.setSpacingAfter(20f);
	//
//			document.add(table9ep);

			Table epstudent41 = new Table(epRecord.getEpYeartable41().size(), 2);

			epstudent41.setPadding(5);
			epstudent41.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable41().size(); i++) {
				
				
				Cell cell17 = new Cell(new Paragraph(epRecord.getEpYeartable41().get(i).getInput41y(),font5));
				
				cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent41.addCell(cell17);


			}
			for (int i = 0; i < epRecord.getEpYeartable41().size(); i++) {
				Cell cell18 = new Cell(new Paragraph(epRecord.getEpYeartable41().get(i).getInput41v(),font5));
				cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent41.addCell(cell18);


			}

			document.add(epstudent41);

			Paragraph paragraph15ep = new Paragraph("4.2\r\n"
					+ "Number of seats earmarked for reserved category as per GOI/State Govt rule year-wise during last five years\r\n\r\n"
					+ "", font4);
			paragraph15ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph15ep);

//			PdfPTable table10ep = new PdfPTable(2);
//			table10ep.setWidthPercentage(100);
	//
//			PdfPCell cell37ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell38ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell39ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell40ep = new PdfPCell(new Paragraph(" "));
	//
//			table10ep.addCell(cell37ep);
//			table10ep.addCell(cell38ep);
//			table10ep.addCell(cell39ep);
//			table10ep.addCell(cell40ep);
	//
//			table10ep.setSpacingBefore(20f);
//			table10ep.setSpacingAfter(20f);
	//
//			document.add(table10ep);

			Table epstudent42 = new Table(epRecord.getEpYeartable42().size(), 2);

			epstudent42.setPadding(5);
			epstudent42.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable42().size(); i++) {
				

				Cell cell19 = new Cell(new Paragraph(epRecord.getEpYeartable42().get(i).getInput42y(),font5));
				cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent42.addCell(cell19);


			}
			for (int i = 0; i < epRecord.getEpYeartable42().size(); i++) {
				Cell cell20 = new Cell(new Paragraph(epRecord.getEpYeartable42().get(i).getInput42v(),font5));
				cell20.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent42.addCell(cell20);
			}

			document.add(epstudent42);

			Paragraph paragraph16ep = new Paragraph(
					"4.3\r\n" + "Total number of classrooms and seminar halls Response: 73\r\n" + "", font4);
			paragraph16ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph16ep);

			Paragraph paragraph17ep = new Paragraph(
					"4.4\r\n" + "Total number of computers in the campus for academic purpose Response: 1818\r\n" + "",
					font4);
			paragraph17ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph17ep);

			Paragraph paragraph18ep = new Paragraph("4.5\r\n"
					+ "Total Expenditure excluding salary year-wise during last five years ( INR in Lakhs)\r\n" + "",
					font4);
			paragraph18ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph18ep);

//			PdfPTable table11ep = new PdfPTable(2);
//			table11ep.setWidthPercentage(100);
	//
//			PdfPCell cell41ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font3));
//			PdfPCell cell42ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell43ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell44ep = new PdfPCell(new Paragraph(" "));
	//
//			table11ep.addCell(cell41ep);
//			table11ep.addCell(cell42ep);
//			table11ep.addCell(cell43ep);
//			table11ep.addCell(cell44ep);
	//
//			table11ep.setSpacingBefore(20f);
//			table11ep.setSpacingAfter(20f);
	//
//			document.add(table11ep);

			Table epstudent45 = new Table(epRecord.getEpYeartable45().size(), 2);

			epstudent45.setPadding(5);
			epstudent45.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable45().size(); i++) {
				

				Cell cell21 = new Cell(new Paragraph(epRecord.getEpYeartable45().get(i).getInput45y(),font5));
				cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent45.addCell(cell21);

			}
			for (int i = 0; i < epRecord.getEpYeartable45().size(); i++) {
				
				
				Cell cell22 = new Cell(new Paragraph(epRecord.getEpYeartable45().get(i).getInput45v(),font5));
				cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent45.addCell(cell22);

			}

			document.add(epstudent45);
			

			//////////////////////// evalutionReport
			Paragraph paragraph1 = new Paragraph("EvaluationReport\r\n", font1);
			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            document.add(paragraph1);
            
            Paragraph paragraph2 = new Paragraph("Evaluative Report of the Departments \r\n\r\n", font2);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            document.add(paragraph2);
            
            
            Paragraph paragraph3 = new Paragraph("Name Of the Autonomous College", font4);
            paragraph3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph3);
           Paragraph paragraph4 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getNameofTheAutonomousCollege():"",font5);
    		paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph4);
    		
    		
    		
            Paragraph paragraph31 = new Paragraph("Name of the Department", font4);
            paragraph31.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph31);
    		
             Paragraph paragraph5 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getNameofTheDepartment():"",font5);
    	     paragraph5.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		 document.add(paragraph5);
    		
    		
    		  Paragraph paragraph51 = new Paragraph("Dist", font4);
    		  paragraph51.setAlignment(Paragraph.ALIGN_JUSTIFIED);
      		  document.add(paragraph51);
      		
    		 Paragraph paragraph6 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getDist():"",font5);
     		 paragraph6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	    		document.add(paragraph6);
    	    		
    	    		
    	    Paragraph paragraph61 = new Paragraph("State", font4);
    	    paragraph61.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	    document.add(paragraph61);		
    	   Paragraph paragraph7 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getState():"",font5);
    	   paragraph7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	   document.add(paragraph7);
    	    	    
    	   
    	   Paragraph paragraph71 = new Paragraph("Total Number of Departments in the institution", font4);
    	   paragraph71.setAlignment(Paragraph.ALIGN_JUSTIFIED);
   	       document.add(paragraph71);	
    	   Paragraph paragraph8 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getTotalNumberofDepartmentsIntheInstitution():""+"\r\n\r\n",font5);
    	   paragraph8.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	   document.add(paragraph8);
    	   
    	   
    	   
    	   PdfPTable table1 = new PdfPTable(5);
    	   table1.setWidthPercentage(100);
    	   

			PdfPCell cell1220 = new PdfPCell(new Paragraph("S No", font4));
			cell1220.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell2 = new PdfPCell(new Paragraph("Name of the Department.",font4));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell3 = new PdfPCell(new Paragraph("For Ex: English\r\n",font4));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell4 = new PdfPCell(new Paragraph("Zooology",font4));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell5 = new PdfPCell(new Paragraph("Bio-Technology\r\n",font4));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell6 = new PdfPCell(new Paragraph("1",font4));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell7 = new PdfPCell(new Paragraph("Year of Establishment",font4));
			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell8 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getEnglish():"",font5));
			cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell9 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getZoology():"",font5));
			cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell10 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getBioTechnology():"",font5));
			cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11 = new PdfPCell(new Paragraph("2",font4));
			cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell12 = new PdfPCell(new Paragraph("Is the Department part of a School/Faculty of the Autonomous College",font4));
			cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell13 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getEnglish():"",font5));
			cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell14 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getZoology():"",font5));
			cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell15 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getBioTechnology():"",font5));
			cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell16 = new PdfPCell(new Paragraph("3",font4));
			cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell17 = new PdfPCell(new Paragraph("Name of programmes offered",font4));
			cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell18= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getEnglish():"",font5));
			cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell19= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getZoology():"",font5));
			cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell20= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getBioTechnology():"",font5));
			cell20.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell21= new PdfPCell(new Paragraph("4",font4));
			cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell22= new PdfPCell(new Paragraph("Number of teaching posts Sanctioned/Filled",font4));
			cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell23 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getEnglish():"",font5));
			cell23.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell24= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getZoology():"",font5));
			cell24.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell25= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getBioTechnology():"",font5));
			cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell26 = new PdfPCell(new Paragraph("5",font4));
			cell26.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell27 = new PdfPCell(new Paragraph("Number of Research Projects:Total grants received",font4));
			cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell28= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getEnglish():"",font5));
			cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell29= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getZoology():"",font5));
			cell29.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell30= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getBioTechnology():"",font5));
			cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell31 = new PdfPCell(new Paragraph("6",font4));
			cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell31.setRowspan(3);
			
			PdfPCell cell32 = new PdfPCell(new Paragraph("Inter -institutional collaborative projects and Associated grants received",font4));
			cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell33 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getEnglish():"",font5));
			cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell34 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getZoology():"",font5));
			cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell35 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getBioTechnology():"",font5));
			cell35.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell36 = new PdfPCell(new Paragraph("National collaboration",font4));
			cell36.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell37 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getEnglish():"",font5));
			cell37.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell38 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getZoology():"",font5));
			cell38.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell39 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getBioTechnology():"",font5));
			cell39.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell40 = new PdfPCell(new Paragraph("International collaboration",font4));
			cell40.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell41= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getEnglish():"",font5));
			cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell42 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getZoology():"",font5));
			cell42.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell43 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getBioTechnology():"",font5));
			cell43.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell44 = new PdfPCell(new Paragraph("7",font4));
			cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell45 = new PdfPCell(new Paragraph("Departmental projects funded by DST_FIST,UGC-SAP?CAS,DPE,DBT,ICSSR,AICTE etc.,:Total grants received",font4));
			cell45.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell46 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getEnglish():"",font5));
			cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell47 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getZoology():"",font5));
			cell47.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell48= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getBioTechnology():"",font5));
			cell48.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell49= new PdfPCell(new Paragraph("8",font4));
			cell49.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell50= new PdfPCell(new Paragraph("Number of Research Projects:Total grants received",font4));
			cell50.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell51= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getEnglish():"",font5));
			cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell52= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getEnglish():"",font5));
			cell52.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell53= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getBioTechnology():"",font5));
			cell53.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell54= new PdfPCell(new Paragraph("9",font4));
			cell54.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell54.setRowspan(6);
			
			PdfPCell cell55= new PdfPCell(new Paragraph("Publications:",font4));
			cell55.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell56= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getEnglish():"",font5));
			cell56.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell57= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getZoology():"",font5));
			cell57.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell58= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getBioTechnology():"",font5));
			cell58.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell59= new PdfPCell(new Paragraph("Number of Papers published",font4));
			cell59.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell60= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getEnglish():"",font5));
			cell60.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell61= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getZoology():"",font5));
			cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell62= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getBioTechnology():"",font5));
			cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell63= new PdfPCell(new Paragraph("Number of Books with ISBN",font4));
			cell63.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell64= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getEnglish():"",font5));
			cell64.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell65= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getZoology():"",font5));
			cell65.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell66= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getBioTechnology():"",font5));
			cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell67= new PdfPCell(new Paragraph("Number of Citation Index -range/average",font4));
			cell67.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell68= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getEnglish():"",font5));
			cell68.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell69= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getZoology():"",font5));
			cell69.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell70= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getBioTechnology():"",font5));
			cell70.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell71= new PdfPCell(new Paragraph("Number of Citation Factor-range/average",font4));
			cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell72= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getEnglish():"",font5));
			cell72.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell73= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getZoology():"",font5));
			cell73.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell74= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getBioTechnology():"",font5));
			cell74.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell75= new PdfPCell(new Paragraph("Number of h-index",font4));
			cell75.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell76= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getEnglish():"",font5));
			cell76.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell77= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getZoology():"",font5));
			cell77.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell78= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getBioTechnology():"",font5));
			cell78.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell79= new PdfPCell(new Paragraph("10",font4));
			cell79.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell80= new PdfPCell(new Paragraph("Details of parents and income generated",font4));
			cell80.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell81= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getEnglish():"",font5));
			cell81.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell82= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getZoology():"",font5));
			cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell83= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getBioTechnology():"",font5));
			cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell84= new PdfPCell(new Paragraph("11",font4));
			cell84.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell85= new PdfPCell(new Paragraph("Details of parents and income generated",font4));
			cell85.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell86= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getEnglish():"",font5));
			cell86.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell87= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getZoology():"",font5));
			cell87.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell88= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getBioTechnology():"",font5));
			cell88.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell89= new PdfPCell(new Paragraph("12",font4));
			cell89.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell89.setRowspan(4);
			PdfPCell cell90= new PdfPCell(new Paragraph("Awards/Recognitions received at National and International level by:",font4));
			cell90.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell91= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getEnglish():"",font5));
			cell91.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell92= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getZoology():"",font5));
			cell92.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell93= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getBioTechnology():"",font5));
			cell93.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell94= new PdfPCell(new Paragraph("Faculty",font4));
			cell94.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell95= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getEnglish():"",font5));
			cell95.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell96= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getZoology():"",font5));
			cell96.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell97= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getBioTechnology():"",font5));
			cell97.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell98= new PdfPCell(new Paragraph("Doctoral/Post doctoral fellows"));
			cell98.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell99= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getEnglish():"",font5));
			cell99.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell100= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getZoology():"",font5));
			cell100.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell101= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getBioTechnology():"",font5));
			cell101.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell102= new PdfPCell(new Paragraph("Students",font4));
			cell102.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell103= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getEnglish():"",font5));
			cell103.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell104= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getZoology():"",font5));
			cell104.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell105= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getBioTechnology():"",font5));
			cell105.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell106= new PdfPCell(new Paragraph("13",font4));
			cell106.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell107= new PdfPCell(new Paragraph("How many students have cleared Civil Services and Defense Services examinations, NET,SET (SLET), GATE and other competitive examinations",font4));
			cell107.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell108= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getEnglish():"",font5));
			cell108.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell109= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getZoology():"",font5));
			cell109.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell110= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getBioTechnology():"",font5));
			cell110.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell111= new PdfPCell(new Paragraph("14",font4));
			cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell111.setRowspan(3);
			PdfPCell cell112= new PdfPCell(new Paragraph("List of dotoral students and research assoiates",font4));
			cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell113= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getEnglish():"",font5));
			cell113.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell114= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getZoology():"",font5));
			cell114.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell115= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getBioTechnology():"",font5));
			cell115.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell116= new PdfPCell(new Paragraph("Fro the host institution/uniersity",font4));
			cell116.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell117= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getEnglish():"",font5));
			cell117.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell118= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getZoology():"",font5));
			cell118.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell119= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getBioTechnology():"",font5));
			cell119.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell120= new PdfPCell(new Paragraph("Year of Establishment",font4));
			cell120.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell121= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getEnglish():"",font5));
			cell121.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell122= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getZoology():"",font5));
			cell122.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell123= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getBioTechnology():"",font5));
			cell123.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell124= new PdfPCell(new Paragraph("15",font4));
			cell124.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell125= new PdfPCell(new Paragraph("Number of Research Scholars/ Post Graduate students getting financial assistance from the University/State/Central",font4));
			cell125.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell126= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getEnglish():"",font5));
			cell126.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell127= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getZoology():"",font5));
			cell127.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell128= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getBioTechnology():"",font5));
			cell128.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table1.addCell(cell1220);
			table1.addCell(cell2);
			table1.addCell(cell3);
			table1.addCell(cell4);
			table1.addCell(cell5);
			table1.addCell(cell6);
			table1.addCell(cell7);
			table1.addCell(cell8);
			table1.addCell(cell9);
			table1.addCell(cell10);
			
			
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
			
			table1.addCell(cell21);
			table1.addCell(cell22);
			table1.addCell(cell23);
			table1.addCell(cell24);
			table1.addCell(cell25);
			table1.addCell(cell26);
			table1.addCell(cell27);
			table1.addCell(cell28);
			table1.addCell(cell29);
			table1.addCell(cell30);
			
			table1.addCell(cell31);
			table1.addCell(cell32);
			table1.addCell(cell33);
			table1.addCell(cell34);
			table1.addCell(cell35);
			table1.addCell(cell36);
			table1.addCell(cell37);
			table1.addCell(cell38);
			table1.addCell(cell39);
			table1.addCell(cell40);
			
			table1.addCell(cell41);
			table1.addCell(cell42);
			table1.addCell(cell43);
			table1.addCell(cell44);
			table1.addCell(cell45);
			table1.addCell(cell46);
			table1.addCell(cell47);
			table1.addCell(cell48);
			table1.addCell(cell49);
			table1.addCell(cell50);
			
			
			table1.addCell(cell51);
			table1.addCell(cell52);
			table1.addCell(cell53);
		    table1.addCell(cell54);
			table1.addCell(cell55);
			table1.addCell(cell56);
			table1.addCell(cell57);
			table1.addCell(cell58);
			table1.addCell(cell59);
			table1.addCell(cell60);
			
			
			table1.addCell(cell61);
			table1.addCell(cell62);
			table1.addCell(cell63);
			table1.addCell(cell64);
			table1.addCell(cell65);
			table1.addCell(cell66);
			table1.addCell(cell67);
			table1.addCell(cell68);
			table1.addCell(cell69);
			table1.addCell(cell70);
			
			table1.addCell(cell71);
			table1.addCell(cell72);
			table1.addCell(cell73);
			table1.addCell(cell74);
			table1.addCell(cell75);
			table1.addCell(cell76);
			table1.addCell(cell77);
			table1.addCell(cell78);
			table1.addCell(cell79);
			table1.addCell(cell80);
		
	
			table1.addCell(cell81);
			table1.addCell(cell82);
			table1.addCell(cell83);
			table1.addCell(cell84);
			table1.addCell(cell85);
			table1.addCell(cell86);
			table1.addCell(cell87);
			table1.addCell(cell88);
			table1.addCell(cell89);
			table1.addCell(cell90);
			
			table1.addCell(cell91);
			table1.addCell(cell92);
			table1.addCell(cell93);
			table1.addCell(cell94);
			table1.addCell(cell95);
			table1.addCell(cell96);
			table1.addCell(cell97);
			table1.addCell(cell98);
			table1.addCell(cell99);
			table1.addCell(cell100);
			
			table1.addCell(cell101);
			table1.addCell(cell102);
			table1.addCell(cell103);
			table1.addCell(cell104);
			table1.addCell(cell105);
			table1.addCell(cell106);
			table1.addCell(cell107);
			table1.addCell(cell108);
			table1.addCell(cell109);
			table1.addCell(cell110);
			
			table1.addCell(cell111);
			table1.addCell(cell112);
			table1.addCell(cell113);
			table1.addCell(cell114);
			table1.addCell(cell115);
			table1.addCell(cell116);
			table1.addCell(cell117);
			table1.addCell(cell118);
			table1.addCell(cell119);
			table1.addCell(cell120);
			
			table1.addCell(cell121);
			table1.addCell(cell122);
			table1.addCell(cell123);
			table1.addCell(cell124);
			table1.addCell(cell125);
			table1.addCell(cell126);
			table1.addCell(cell127);
			table1.addCell(cell128);
			
			document.add(table1);
			
		}

	}

	public void Iiqa(Document document) {

		Paragraph paragraph = new Paragraph("Institutional Information for Quality Assessment(IIQA)",font1);

		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		paragraph.setSpacingBefore(20f);
		paragraph.setSpacingAfter(8f);
		PdfPCell cell1 = new PdfPCell();

		document.add(cell1);
		paragraph.setSpacingAfter(10f);
		document.add(paragraph);

		Font fontParagraph4 = FontFactory.getFont(FontFactory.COURIER_BOLD);
		fontParagraph4.setSize(12);
		
		
		Paragraph paragraph5 = new Paragraph("ADITYA COLLEGE OF ENGINEERING & TECHNOLOGY,SURAMPALEM,ANDHRA PRADESH",fontParagraph4
				);
		paragraph5.setAlignment(Paragraph.ALIGN_CENTER);
		

		paragraph5.setSpacingAfter(4f);
		document.add(paragraph5);

		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setSize(11);
		// fontTitle1.setColor(Color.RED);

		// creating table 4 cloums date of submission

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(70);
		table.setWidths(new int[] { 60, 60, 30, 60 });
		table.setHorizontalAlignment(table.ALIGN_LEFT);

		PdfPCell cell3 = new PdfPCell(new Paragraph(""));
		PdfPCell cell4 = new PdfPCell(new Paragraph("Date of submission", font));
		PdfPCell cell5 = new PdfPCell(new Paragraph(":"));
		PdfPCell cell6 = new PdfPCell(new Paragraph(qiadata.getqIAIndicator().get(0).getInputIiqaDate(), font));
		PdfPCell cell7 = new PdfPCell(new Paragraph(""));
		PdfPCell cell8 = new PdfPCell(new Paragraph("AISHE ID", font));
		PdfPCell cell9 = new PdfPCell(new Paragraph(":"));
		PdfPCell cell10 = new PdfPCell(new Paragraph(qiadata.getqIAIndicator().get(0).getInputIiqaAisheId(), font));
		PdfPCell cell14 = new PdfPCell(new Paragraph(""));
		PdfPCell cell11 = new PdfPCell(new Paragraph("Institution Track ID", font));
		PdfPCell cell12 = new PdfPCell(new Paragraph(":"));
		PdfPCell cell13 = new PdfPCell(new Paragraph(qiadata.getqIAIndicator().get(0).getInputIiqaTrackId(), font));

		table.addCell(cell3);
		table.addCell(cell4);
		table.addCell(cell5);
		table.addCell(cell6);
		table.addCell(cell7);
		table.addCell(cell8);
		table.addCell(cell9);
		table.addCell(cell10);
		table.addCell(cell14);
		table.addCell(cell11);
		table.addCell(cell12);
		table.addCell(cell13);
		table.setSpacingBefore(10f);
		table.setSpacingAfter(10f);
		document.add(table);

		// application table

		PdfPTable table1 = new PdfPTable(3);
		table1.setWidthPercentage(100);
		table1.setWidths(new int[] { 10, 90, 90 });
		table1.setHorizontalAlignment(table.ALIGN_LEFT);

		PdfPCell cell15 = new PdfPCell(new Paragraph("1", font)); // nested column
		cell15.setRowspan(2);
		PdfPCell cell16 = new PdfPCell(new Paragraph("Application For", font));

		PdfPCell cell17 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa1t1(), font));
		PdfPCell cell18 = new PdfPCell(new Paragraph("Cycle of Accreditation ")); // nested

		PdfPCell cell19 = new PdfPCell(new Paragraph(""));

		// creating another table
		// table 1
		PdfPTable table4141 = new PdfPTable(4);
		table4141.setSpacingBefore(3f);
		
		PdfPCell cell201 = new PdfPCell(new Paragraph("Cycle", font));
		PdfPCell cell202 = new PdfPCell(new Paragraph("Date", font));
		PdfPCell cell203 = new PdfPCell(new Paragraph("Grade", font));
		PdfPCell cell204 = new PdfPCell(new Paragraph("Score", font));
		table4141.addCell(cell201);
		table4141.addCell(cell202);
		table4141.addCell(cell203);
		table4141.addCell(cell204);
		for (int i = 0; i < qiadata.getQiaIndicator12().size(); i++) {
			table4141.addCell(qiadata.getQiaIndicator12().get(i).getInputiiqa1t3());
			table4141.addCell(qiadata.getQiaIndicator12().get(i).getInputiiqa1t4());
			table4141.addCell(qiadata.getQiaIndicator12().get(i).getInputiiqa1t5());
			table4141.addCell(qiadata.getQiaIndicator12().get(i).getInputiiqa1t6());
		}

//						for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//						{
//						
//						
//					}
//						for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//						{
//						
//						
//						}
//						for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//						{
//						
//						
//						}
//					

//						PdfPCell cell19 = new PdfPCell();
		cell19.addElement(table4141);
		table4141.setSpacingBefore(20f);
		table4141.setSpacingAfter(20f);
		// cell19.addElement(cell19);

		PdfPCell cell20 = new PdfPCell(new Paragraph("2"));
		PdfPCell cell21 = new PdfPCell(new Paragraph("Name of the College "));
		PdfPCell cell22 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa1t2()));
		PdfPCell cell23 = new PdfPCell(new Paragraph("3"));
		PdfPCell cell24 = new PdfPCell(new Paragraph("Date of establishment of the Institution"));
		PdfPCell cell25 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa3t1()));
		PdfPCell cell26 = new PdfPCell(new Paragraph("4"));
		cell26.setRowspan(2);// nested column
		PdfPCell cell27 = new PdfPCell(new Paragraph("Name of the Head of the Institution"));
		PdfPCell cell28 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa4t1()));
		PdfPCell cell29 = new PdfPCell(new Paragraph("Designation"));
		PdfPCell cell30 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa4t2()));
		PdfPCell cell31 = new PdfPCell(new Paragraph("5"));
		PdfPCell cell32 = new PdfPCell(new Paragraph("Does the college function from Own Campus "));
		PdfPCell cell33 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa5t1()));
		PdfPCell cell34 = new PdfPCell(new Paragraph("6"));
		cell34.setRowspan(10);
		PdfPCell cell35 = new PdfPCell(new Paragraph("Address of the College"));
		PdfPCell cell36 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa5t1()));
		PdfPCell cell37 = new PdfPCell(new Paragraph("State/UT"));
		PdfPCell cell38 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t2()));
		PdfPCell cell39 = new PdfPCell(new Paragraph("District"));
		PdfPCell cell40 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t3()));
		PdfPCell cell41 = new PdfPCell(new Paragraph("City"));
		PdfPCell cell42 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t4()));
		PdfPCell cell43 = new PdfPCell(new Paragraph("Pin"));
		PdfPCell cell44 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t5()));
		PdfPCell cell45 = new PdfPCell(new Paragraph("Phone No"));
		PdfPCell cell46 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t6()));
		PdfPCell cell47 = new PdfPCell(new Paragraph("Fax No"));
		PdfPCell cell48 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t7()));
		PdfPCell cell49 = new PdfPCell(new Paragraph("Mobile No "));
		PdfPCell cell50 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t8()));
		PdfPCell cell51 = new PdfPCell(new Paragraph("Registered Email"));
		PdfPCell cell52 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t9()));
		PdfPCell cell53 = new PdfPCell(new Paragraph("Alternate Email "));
		PdfPCell cell54 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t10()));
		PdfPCell cell55 = new PdfPCell(new Paragraph("7"));
		cell55.setRowspan(11);
		PdfPCell cell56 = new PdfPCell(new Paragraph(" Alternate Faculty Contact Details "));// 1
		PdfPCell cell57 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t1()));
		PdfPCell cell58 = new PdfPCell(new Paragraph("Address"));// 2
		PdfPCell cell59 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t2()));
		PdfPCell cell60 = new PdfPCell(new Paragraph("State/UT"));// 3
		PdfPCell cell61 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t3()));
		PdfPCell cell62 = new PdfPCell(new Paragraph("District"));// 4
		PdfPCell cell63 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t4()));
		PdfPCell cell64 = new PdfPCell(new Paragraph("City"));// 5
		PdfPCell cell65 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t4()));
		PdfPCell cell66 = new PdfPCell(new Paragraph("Pin"));// 6
		PdfPCell cell67 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t5()));
		PdfPCell cell68 = new PdfPCell(new Paragraph("Phone No"));// 7
		PdfPCell cell69 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t6()));
		PdfPCell cell70 = new PdfPCell(new Paragraph("Fax No"));// 8
		PdfPCell cell71 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t7()));
		PdfPCell cell72 = new PdfPCell(new Paragraph("Mobile No ")); // 9;
		PdfPCell cell73 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t8()));
		PdfPCell cell74 = new PdfPCell(new Paragraph("Email "));// 10
		PdfPCell cell75 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t9()));
		PdfPCell cell76 = new PdfPCell(new Paragraph("Alternate Email ")); // 11
		PdfPCell cell77 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t10()));
		PdfPCell cell78 = new PdfPCell(new Paragraph("8"));
		PdfPCell cell79 = new PdfPCell(new Paragraph("Website"));
		PdfPCell cell80 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa8t1()));
		PdfPCell cell81 = new PdfPCell(new Paragraph("9"));
		PdfPCell cell82 = new PdfPCell(new Paragraph(
				"Has the Institution completed 6 years of existence/" + "Years of graduation of last two batches"));
		PdfPCell cell83 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa9t1()));
		PdfPCell cell84 = new PdfPCell(new Paragraph("10"));
		PdfPCell cell85 = new PdfPCell(new Paragraph("Nature of the college"));
		PdfPCell cell86 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa10t1()));
		PdfPCell cell87 = new PdfPCell(new Paragraph("11"));
		PdfPCell cell88 = new PdfPCell(new Paragraph("College Affiliation"));
		PdfPCell cell89 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa11t1()));
		PdfPCell cell90 = new PdfPCell(new Paragraph("12"));
		PdfPCell cell91 = new PdfPCell(new Paragraph(" Name of the affiliating University" // table in side table 12
				+ "(ies) and the state(s) in which the University" + "(ies) is located"));
		PdfPCell cell92 = new PdfPCell(new Paragraph(""));
//					cell92.setRowspan(3);
//					PdfPCell cell701 = new PdfPCell(new Paragraph("State"));
//					PdfPCell cell702 = new PdfPCell(new Paragraph(""));
//					PdfPCell cell703 = new PdfPCell(new Paragraph("Universite"));
//					PdfPCell cell704 = new PdfPCell(new Paragraph(""));
//					PdfPCell cell705 = new PdfPCell(new Paragraph("Documents"));
//					PdfPCell cell706 = new PdfPCell(new Paragraph(""));
//					
//					
//					

		PdfPCell cell93 = new PdfPCell(new Paragraph("13"));
		PdfPCell cell94 = new PdfPCell(
				new Paragraph("s the Institution recognized under section 2(f) of the\r\n" + "UGC Act?"));
		PdfPCell cell95 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa13t1()));
		PdfPCell cell96 = new PdfPCell(new Paragraph("14"));
		PdfPCell cell97 = new PdfPCell(new Paragraph("Is the Institution recognized under section 12B of the\r\n"
				+ "UGC Act?\r\n" + " If yes, date of recognition by UGC under section\r\n"
				+ "12B along with latest Plan General Development\r\n" + "Grant release letter"));
		PdfPCell cell98 = new PdfPCell(new Paragraph(new Paragraph(qIAIndicator1.get(0).getInputiiqa14t1())));
		PdfPCell cell99 = new PdfPCell(new Paragraph("15"));
		PdfPCell cell100 = new PdfPCell(
				new Paragraph("Is the institution recognised as an Autonomous\r\n" + "College by the UGC?\r\n" + ""));

		PdfPCell cell101 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa15t1()));

		PdfPCell cell102 = new PdfPCell(new Paragraph("16"));
		PdfPCell cell103 = new PdfPCell(new Paragraph("Is the institution recognised as a ‘College with\r\n"
				+ "Potential for Excellence (CPE)’ by the UGC?"));

		PdfPCell cell104 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa16t1()));

		PdfPCell cell105 = new PdfPCell(new Paragraph("17"));
		PdfPCell cell106 = new PdfPCell(
				new Paragraph(" Is the institution recognised as a ‘College of\r\n" + "Excellence’ by the UGC?"));
		PdfPCell cell107 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa17t1()));
		PdfPCell cell108 = new PdfPCell(new Paragraph("18"));
		cell108.setRowspan(2);
		PdfPCell cell109 = new PdfPCell(new Paragraph(" Is the College offering any programmes recognised\r\n"
				+ "by any Statutory Regulatory Authority (SRA)\r\n" + ""));
		PdfPCell cell110 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa18t1()));

		PdfPCell cell111 = new PdfPCell(new Paragraph("Statutory Regulatory Authorities"));
		PdfPCell cell112 = new PdfPCell(new Paragraph(""));
		// nested table

		int sizen2 = qiadata.getQiaIndicator4().size();
		PdfPTable table4152 = new PdfPTable(2);
		table4152.setSpacingBefore(10f);
		PdfPCell cell601 = new PdfPCell(new Paragraph("SRA program"));
		PdfPCell cell602 = new PdfPCell(new Paragraph("Document"));
//					PdfPCell cell603 = new PdfPCell(new Paragraph(qiadata.getQiaIndicator4().get(0).getIiqa18t2()));
//					PdfPCell cell604 = new PdfPCell(new Paragraph(qiadata.getQiaIndicator4().get(0).getIiqa18t2()));

		table4152.addCell(cell601);
		table4152.addCell(cell602);
		for (int i = 0; i < qiadata.getQiaIndicator4().size(); i++) {
			table4152.addCell(qiadata.getQiaIndicator4().get(i).getInputiiqa18t2());
			table4152.addCell(qiadata.getQiaIndicator4().get(i).getInputiiqa18t3());
		}

		cell112.addElement(table4152);

		table4152.setSpacingAfter(20f);

		PdfPCell cell113 = new PdfPCell(new Paragraph("19"));
		PdfPCell cell114 = new PdfPCell(new Paragraph("If the institution is not affiliated to a university and is\r\n"
				+ "offering programmes recognized by any Statutory\r\n"
				+ "Regulatory Authorities (SRA), are the programmes\r\n"
				+ "recognized by Association of Indian Universities(AIU)\r\n"
				+ "or other appropriate Government authorities as\r\n"
				+ "equivalent to UG / PG Programmes of a University"));
		PdfPCell cell115 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa19t1()));
		PdfPCell cell116 = new PdfPCell(new Paragraph("20"));
		PdfPCell cell117 = new PdfPCell(new Paragraph("Number of programmes offered"));

		// table20
		int sizen4 = qiadata.getQiaIndicator5().size();
		PdfPTable table5154 = new PdfPTable(2);
		table5154.setSpacingBefore(10f);
		PdfPCell cell701 = new PdfPCell(new Paragraph("Programmes"));
		PdfPCell cell702 = new PdfPCell(new Paragraph("Number"));
		table5154.addCell(cell701);
		table5154.addCell(cell702);
		for (int i = 0; i < qiadata.getQiaIndicator5().size(); i++) {
			table5154.addCell(qiadata.getQiaIndicator5().get(i).getInputiiqa20t1());
			table5154.addCell(qiadata.getQiaIndicator5().get(i).getInputiiqa20t2());
		}

		cell117.addElement(table5154);

		table5154.setSpacingAfter(20f);
		cell117.setColspan(2);

		// PdfPCell cell118 = new PdfPCell(new Paragraph(""));

		PdfPCell cell119 = new PdfPCell(new Paragraph("21"));
		PdfPCell cell120 = new PdfPCell(new Paragraph("Programme Details"));
		// table21
		// table21
		int sizen9 = qiadata.getQiaIndicator6().size();
		PdfPTable table6154 = new PdfPTable(5);
		table6154.setSpacingBefore(20f);
		PdfPCell cell903 = new PdfPCell(new Paragraph("Programmes"));
		PdfPCell cell904 = new PdfPCell(new Paragraph("Department"));
		PdfPCell cell905 = new PdfPCell(new Paragraph("University Affiliation"));
		PdfPCell cell906 = new PdfPCell(new Paragraph("SRA Recognition"));
		PdfPCell cell907 = new PdfPCell(new Paragraph("Affiliation Status"));
		table6154.addCell(cell903);
		table6154.addCell(cell904);
		table6154.addCell(cell905);
		table6154.addCell(cell906);
		table6154.addCell(cell907);
		for (int i = 0; i < qiadata.getQiaIndicator6().size(); i++) {
			table6154.addCell(qiadata.getQiaIndicator6().get(i).getInputiiqa21t1());
			table6154.addCell(qiadata.getQiaIndicator6().get(i).getInputiiqa21t2());
			table6154.addCell(qiadata.getQiaIndicator6().get(i).getInputiiqa21t3());
			table6154.addCell(qiadata.getQiaIndicator6().get(i).getInputiiqa21t4());
			table6154.addCell(qiadata.getQiaIndicator6().get(i).getInputiiqa21t5());
		}

		cell120.addElement(table6154);
		cell120.setColspan(2);

		// PdfPCell cell121 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell122 = new PdfPCell(new Paragraph("22 "));
		PdfPCell cell123 = new PdfPCell(
				new Paragraph(" Number of Teaching Staff by employment status (permanent / temporary) and by gender "));
		PdfPCell cell124 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell125 = new PdfPCell(new Paragraph("23 "));
		PdfPCell cell126 = new PdfPCell(new Paragraph(
				" Number of Non-Teaching Staff by employment status (permanent / temporary) and by gender "));
		// table23
		int sizen11 = qiadata.getQiaIndicator9().size();
		PdfPTable table7154 = new PdfPTable(4);
		table7154.setSpacingBefore(10f);
		PdfPCell cell1903 = new PdfPCell(new Paragraph("Male"));
		PdfPCell cell1904 = new PdfPCell(new Paragraph("Female"));
		PdfPCell cell1905 = new PdfPCell(new Paragraph("Transgender"));
		PdfPCell cell1906 = new PdfPCell(new Paragraph("Total"));

		table7154.addCell(cell1903);
		table7154.addCell(cell1904);
		table7154.addCell(cell1905);
		table7154.addCell(cell1906);

		for (int i = 0; i < qiadata.getQiaIndicator9().size(); i++) {
			table7154.addCell(qiadata.getQiaIndicator9().get(i).getInputiiqa23t1());
			table7154.addCell(qiadata.getQiaIndicator9().get(i).getInputiiqa23t2());
			table7154.addCell(qiadata.getQiaIndicator9().get(i).getInputiiqa23t3());
			table7154.addCell(qiadata.getQiaIndicator9().get(i).getInputiiqa23t4());

		}

		cell126.addElement(table7154);
		cell126.setColspan(2);

		// PdfPCell cell127 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell128 = new PdfPCell(new Paragraph("24 "));
		PdfPCell cell129 = new PdfPCell(new Paragraph("Number of Students on roll by gender "));

		// PdfPCell cell130 = new PdfPCell(new Paragraph(" "));
		// table 24
		int sizen12 = qiadata.getQiaIndicator10().size();
		PdfPTable table8154 = new PdfPTable(4);
		table8154.setSpacingBefore(10f);

		PdfPCell cell2903 = new PdfPCell(new Paragraph("Male"));
		PdfPCell cell2904 = new PdfPCell(new Paragraph("Female"));
		PdfPCell cell2905 = new PdfPCell(new Paragraph("Transgender"));
		PdfPCell cell2906 = new PdfPCell(new Paragraph("Total"));

		table8154.addCell(cell2903);
		table8154.addCell(cell2904);
		table8154.addCell(cell2905);
		table8154.addCell(cell2906);

		for (int i = 0; i < qiadata.getQiaIndicator10().size(); i++) {
			table8154.addCell(qiadata.getQiaIndicator10().get(i).getInputiiqa24t1());
			table8154.addCell(qiadata.getQiaIndicator10().get(i).getInputiiqa24t2());
			table8154.addCell(qiadata.getQiaIndicator10().get(i).getInputiiqa24t3());
			table8154.addCell(qiadata.getQiaIndicator10().get(i).getInputiiqa24t4());

		}

		cell129.addElement(table8154);
		cell129.setColspan(2);
		// Table table = new Table(1,1);

		PdfPCell cell131 = new PdfPCell(new Paragraph("25 "));
		PdfPCell cell132 = new PdfPCell(new Paragraph("Does the institution have statutory cells / committees"));
		PdfPCell cell133 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa25t1()));
		PdfPCell cell134 = new PdfPCell(new Paragraph("26 "));
		cell134.setRowspan(2);
		PdfPCell cell135 = new PdfPCell(new Paragraph("Date of establishment of IQAC"));
		PdfPCell cell136 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa26t1()));
		PdfPCell cell137 = new PdfPCell(new Paragraph("The minutes of IQAC meeting and Action Taken\r\n"
				+ "Report should be uploaded on the institutional\r\n" + "website. "));
		PdfPCell cell138 = new PdfPCell(new Paragraph(" "));
		// nested table
		int sizen14 = qiadata.getQiaIndicator8().size();
		PdfPTable table0154 = new PdfPTable(2);

		PdfPCell cell09 = new PdfPCell(new Paragraph("Date"));
		PdfPCell cell010 = new PdfPCell(new Paragraph("View Document"));
		table0154.addCell(cell09);
		table0154.addCell(cell010);
		for (int i = 0; i < qiadata.getQiaIndicator8().size(); i++) {
			table0154.addCell(qiadata.getQiaIndicator8().get(i).getInputiiqa27t1());
			table0154.addCell(qiadata.getQiaIndicator8().get(i).getIiqa27f1());

		}

		cell138.addElement(table0154);

		PdfPCell cell139 = new PdfPCell(new Paragraph("27"));
		PdfPCell cell140 = new PdfPCell(new Paragraph(" Date of submission of AQARs of last 4 years to\r\n" + "NAAC"));

		// anothertable 27
		PdfPCell cell141 = new PdfPCell(new Paragraph(""));
		int sizen3 = qiadata.getQiaIndicator7().size();
		PdfPTable table4154 = new PdfPTable(2);

		PdfPCell cell609 = new PdfPCell(new Paragraph("Date"));
		PdfPCell cell610 = new PdfPCell(new Paragraph("View Document"));
		table4154.addCell(cell609);
		table4154.addCell(cell610);
		for (int i = 0; i < qiadata.getQiaIndicator7().size(); i++) {
			table4154.addCell(qiadata.getQiaIndicator7().get(i).getInputiiqa26t2());
			table4154.addCell(qiadata.getQiaIndicator7().get(i).getIiqa26f1());
//						table4141.addCell(qiadata.getQiaIndicator7().get(i).getIiqa1t5());
//						table4141.addCell(qiadata.getQiaIndicator7().get(i).getIiqa1t6());
		}

		cell141.addElement(table4154);

		PdfPCell cell142 = new PdfPCell(new Paragraph("28"));
		PdfPCell cell143 = new PdfPCell(new Paragraph(" Has the institution made statutory declaration on the\r\n"
				+ "institution website under Section 4 (1) (b) of the RTI\r\n"
				+ "Act 2005 as issued and amended from time to time.\r\n" + ""));
		PdfPCell cell144 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa28t1()));
		PdfPCell cell145 = new PdfPCell(new Paragraph("29"));
		PdfPCell cell146 = new PdfPCell(
				new Paragraph(" Does the college have an academic MoU with any\r\n" + "foreign institution"));
		PdfPCell cell147 = new PdfPCell(new Paragraph(qiadata.getqIAIndicator().get(0).getInputIiqaAisheId()));
		PdfPCell cell148 = new PdfPCell(new Paragraph("30"));
		PdfPCell cell149 = new PdfPCell(new Paragraph(
				"Date of uploading data on MHRD website for All India\r\n" + "Survey on Higher Education (AISHE)."));
		PdfPCell cell150 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa30t1()));
		PdfPCell cell151 = new PdfPCell(new Paragraph("31"));
		PdfPCell cell152 = new PdfPCell(new Paragraph(" Attach Certification by the Head of the Institution for\r\n"
				+ "having complied with Rules & Regulations of Central\r\n"
				+ "Government, UGC and other Statutory Bodies, State\r\n"
				+ "Government and Affiliating University in the\r\n" + "prescribed format enclosed herewith.\r\n"
				+ ""));
		PdfPCell cell153 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa31t1()));
		PdfPCell cell154 = new PdfPCell(new Paragraph("32"));
		PdfPCell cell155 = new PdfPCell(new Paragraph("Registration Fee paid details."));
		PdfPCell cell156 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa32t1()));

		table1.addCell(cell15);
		table1.addCell(cell16);
		table1.addCell(cell17);
		table1.addCell(cell18);
		table1.addCell(cell19);
		table1.addCell(cell20);
		table1.addCell(cell21);
		table1.addCell(cell22);
		table1.addCell(cell23);
		table1.addCell(cell24);
		table1.addCell(cell25);
		table1.addCell(cell26);
		table1.addCell(cell27);
		table1.addCell(cell28);
		table1.addCell(cell29);
		table1.addCell(cell30);
		table1.addCell(cell31);
		table1.addCell(cell32);
		table1.addCell(cell33);
		table1.addCell(cell34);
		table1.addCell(cell35);
		table1.addCell(cell36);
		table1.addCell(cell37);
		table1.addCell(cell38);
		table1.addCell(cell39);
		table1.addCell(cell30);
		table1.addCell(cell41);
		table1.addCell(cell42);
		table1.addCell(cell43);
		table1.addCell(cell44);
		table1.addCell(cell45);
		table1.addCell(cell46);
		table1.addCell(cell47);
		table1.addCell(cell48);
		table1.addCell(cell49);
		table1.addCell(cell50);
		table1.addCell(cell51);
		table1.addCell(cell52);
		table1.addCell(cell53);
		table1.addCell(cell54);
		table1.addCell(cell55);
		table1.addCell(cell56);
		table1.addCell(cell57);
		table1.addCell(cell58);
		table1.addCell(cell59);
		table1.addCell(cell60);
		table1.addCell(cell61);
		table1.addCell(cell62);
		table1.addCell(cell63);
		table1.addCell(cell64);
		table1.addCell(cell65);
		table1.addCell(cell66);
		table1.addCell(cell67);
		table1.addCell(cell68);
		table1.addCell(cell69);
		table1.addCell(cell70);
		table1.addCell(cell71);
		table1.addCell(cell72);
		table1.addCell(cell73);
		table1.addCell(cell74);
		table1.addCell(cell75);
		table1.addCell(cell76);
		table1.addCell(cell77);
		table1.addCell(cell78);
		table1.addCell(cell79);
		table1.addCell(cell80);
		table1.addCell(cell81);
		table1.addCell(cell82);
		table1.addCell(cell83);
		table1.addCell(cell84);
		table1.addCell(cell85);
		table1.addCell(cell86);
		table1.addCell(cell87);
		table1.addCell(cell88);
		table1.addCell(cell89);
		table1.addCell(cell90);
		table1.addCell(cell91);
		table1.addCell(cell92);

		//// table12
//					
//					table1.addCell(cell703);
//					table1.addCell(cell704);
//					table1.addCell(cell705);
//					table1.addCell(cell706);
//					
		table1.addCell(cell93);
		table1.addCell(cell94);
		table1.addCell(cell95);
		table1.addCell(cell96);
		table1.addCell(cell97);
		table1.addCell(cell98);
		table1.addCell(cell99);
		table1.addCell(cell100);
		table1.addCell(cell101);
		table1.addCell(cell102);
		table1.addCell(cell103);
		table1.addCell(cell104);
		table1.addCell(cell105);
		table1.addCell(cell106);
		table1.addCell(cell107);
		table1.addCell(cell108);
		table1.addCell(cell109);
		table1.addCell(cell110);
		table1.addCell(cell111);
		table1.addCell(cell112);
		table1.addCell(cell113);
		table1.addCell(cell114);
		table1.addCell(cell115);
		table1.addCell(cell116);
		table1.addCell(cell117);
		// table1.addCell(cell118);
		table1.addCell(cell119);
		table1.addCell(cell120);

		// table1.addCell(cell121);
		table1.addCell(cell122);
		table1.addCell(cell123);
		table1.addCell(cell124);
		table1.addCell(cell125);
		table1.addCell(cell126);
		// table1.addCell(cell127);
		table1.addCell(cell128);
		table1.addCell(cell129);
		// table1.addCell(cell130);
		table1.addCell(cell131);
		table1.addCell(cell132);
		table1.addCell(cell133);
		table1.addCell(cell134);
		table1.addCell(cell135);
		table1.addCell(cell136);
		table1.addCell(cell137);
		table1.addCell(cell138);
		table1.addCell(cell139);

		table1.addCell(cell140);

		table1.addCell(cell141);
		table1.addCell(cell142);
		table1.addCell(cell143);
		table1.addCell(cell144);
		table1.addCell(cell145);
		table1.addCell(cell146);
		table1.addCell(cell147);
		table1.addCell(cell148);
		table1.addCell(cell149);
		table1.addCell(cell150);
		table1.addCell(cell151);
		table1.addCell(cell152);
		table1.addCell(cell153);
		table1.addCell(cell154);
		table1.addCell(cell155);
		table1.addCell(cell156);
		document.add(table1);

	}

	public void Criteria1(Document document) {
		Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font1);
		paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
		document.add(paragraph1);
		

		Paragraph paragraph1line = new Paragraph("______________________________________________________________________________");
		paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
		document.add(paragraph1line);
//cr1.1
		Paragraph paragraph2 = new Paragraph("1.1 Curriculum Design and Development\r\n", font2);
//		paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
		document.add(paragraph2);

		PdfPTable table111criteria1 = new PdfPTable(1);

		table111criteria1.setWidthPercentage(100);
		
		PdfPCell cell111criteria1 = new PdfPCell(
				new Paragraph("1.1.1 Curricula developed and implemented have relevance to the local, "
						+ "national, regional and global developmental needs which is reflected in Programme outcomes (POs), "
						+ "Programme Specific Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered by the Institution.\r\n\r\n"
				,font4));
		
		PdfPCell cell1110criteria1 = new PdfPCell(
				new Paragraph("Response:\r\n"
						+ (criteria1Record != null ? criteria1Record.getCriteria11Ql().get(0).getResponse111()
								: "")+"\r\n\r\n",font5));
		
		

		table111criteria1.addCell(cell111criteria1);
		table111criteria1.addCell(cell1110criteria1);
		
		cell111criteria1.setHorizontalAlignment(Element.ALIGN_LEFT);
		table111criteria1.setSpacingBefore(20f);
		table111criteria1.setSpacingAfter(20f);
		
		document.add(table111criteria1);

//
//if(criteria1Record.getCriteria1FieldInfoQl().get(0).getResponse111() !=null)
//{

//paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//document.add(paragraph4);
//}

		PdfPTable table6 = new PdfPTable(2);
		table6.setWidthPercentage(100);

//create table for header
		table6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell3 = new PdfPCell(new Paragraph("Any aditional information\r\n\r\n", font5));
		cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell4 = new PdfPCell(
				new Paragraph(criteria1Record != null ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
		cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell5 = new PdfPCell(new Paragraph("Link for Aditional information\r\n\r\n", font5));
		cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell6 = new PdfPCell(
				new Paragraph(criteria1Record != null ? criteria1file.get(0).getCriteria1FilePath() : " ",font5));
		cell6.setHorizontalAlignment(Element.ALIGN_CENTER);

		table6.addCell(cell1);
		table6.addCell(cell2);
		table6.addCell(cell3);
		table6.addCell(cell4);
		table6.addCell(cell5);
		table6.addCell(cell6);
		document.add(table6);

	

		

		PdfPTable table1 = new PdfPTable(2);
		PdfPTable table11 = new PdfPTable(1);
		
		
		table1.setWidthPercentage(100);
		table11.setWidthPercentage(100);

//PdfPCell cell58criteria5 = new PdfPCell(
//	new Paragraph(criteria5Record != null ? criterai5file.get(15).getCriteria5FilePath() : ""));
		table1.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell11 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell12 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell13 = new PdfPCell(new Paragraph("Minutes of relevant Academic Council/BOS meeting\r\n\r\n",font5));
		cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell14 = new PdfPCell(
				new Paragraph(criteria1Record != null ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
		cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell17 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		 cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell18 = new PdfPCell(
				new Paragraph(criteria1Record != null ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell15 = new PdfPCell(
				new Paragraph("Details of program syllabus revision in last 5 years(Data Template)\r\n\r\n",font5));
		cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell16 = new PdfPCell(
				new Paragraph(criteria1Record != null ? criteria1file.get(2).getCriteria1FilePath() : "",font5));
		cell16.setHorizontalAlignment(Element.ALIGN_CENTER);

		table1.addCell(cell11);
		table1.addCell(cell12);
		table1.addCell(cell13);
		table1.addCell(cell14);
		table1.addCell(cell17);
		table1.addCell(cell18);
		table1.addCell(cell15);
		table1.addCell(cell16);
		
		
		
		PdfPCell cell160 = new PdfPCell(
				new Paragraph(
				"1.1.2 The programmes offered by the institution focus on employability/ \r\n"
				+ "entrepreneurship/ skill development and their course syllabi are \r\n"
				+ "adequately revised to incorporate contemporary requirements"
				,font4));
		table11.addCell(cell160);
		
		if (criteria1Record.getCriteria11Qn().get(0).getResponse112() != null) {
			PdfPCell cell1601 = new PdfPCell(
					new Paragraph("Response:"
					+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getResponse112() : "")+"\r\n\r\n",
					font5));
			table11.addCell(cell1601);
		}

		PdfPCell cell164 = new PdfPCell(
				new Paragraph(
				"1.1.2.1 Number of all Programmes offered by the institution during the last five years.\r\n\r\n",
				font4));
//		table11.addCell(cell164);

		PdfPCell cell16411 = new PdfPCell(
				new Paragraph("Response:"
				+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1121t1() : "")+"\r\n\r\n",
				font5));
	//	table11.addCell(cell16411);

		PdfPCell cell16412 = new PdfPCell(
				new Paragraph(
				"1.1.2.2 How many Programmes were revised out of total number of Programmes offered during the last five years\r\n\r\n",
				font4));
//		table11.addCell(cell16412);

		if (criteria1Record.getCriteria11Qn() != null) {
			PdfPCell cell16413 = new PdfPCell(
					new Paragraph("Response:"
					+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1122t1() : "")+"\r\n\r\n",
					font5));
		//	table11.addCell(cell16413);

		}
		
		table11.setSpacingBefore(20f);
		table11.setSpacingAfter(20f);
		
		document.add(table11);
		document.add(table1);
	
		
		

		if (criteria1Record.getYearTable1131() != null) {
			Table table1131 = new Table(criteria1Record.getYearTable1131().size(), 2);
			System.out.println(criteria1Record.getYearTable1131());

			table1131.setPadding(5);
			table1131.setWidth(100f);

			for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
				
				
				Cell cell1000criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1131().get(i).getInput1131y(),font5));
				
				cell1000criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1131.addCell(cell1000criteria1);
			}
			for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
				Cell cell1000criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1131().get(i).getInput1131v(),font5));
				
				cell1000criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1131.addCell(cell1000criteria1);
			}
			
	//		document.add(table1131);
		
		}

		PdfPTable table3 = new PdfPTable(2);
		table3.setWidthPercentage(100);
		
		PdfPTable table31 = new PdfPTable(1);
		table31.setWidthPercentage(100);
		
		table3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table31.setSpacingAfter(20);
		table31.setSpacingBefore(20);
		
		PdfPCell cell31 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell32 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell33 = new PdfPCell(new Paragraph("Programme / Curriculum/ Syllabus of the courses\r\n\r\n",font5));
		cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell34 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : "",font5));
		cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell35 = new PdfPCell(
				new Paragraph("MoU's with relevant organizations for these courses, if any\r\n\r\n",font5));
		cell35.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell36 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : "",font5));
		cell36.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell37 = new PdfPCell(new Paragraph(
				"Minutes of the Boards of Studies/ Academic Council meetings with approvals for these coursesBudget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n",font5));
		cell37.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell38 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : "",font5));
		cell38.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell39 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell39.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell40 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(7).getCriteria1FilePath() : "",font5));
		cell40.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell41 = new PdfPCell(new Paragraph(
				"Average percentage of courses having focus on employability/ entrepreneurship(Data Template)\r\n\r\n",font5));
		cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell42 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(7).getCriteria1FilePath() : "",font5));
		cell42.setHorizontalAlignment(Element.ALIGN_CENTER);

		/*
		 * com.lowagie.text.Font fontTitle43 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle43.setSize(16)
		 */

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
		
	
		PdfPCell cell421 = new PdfPCell(
				new Paragraph(
				"1.1.3 Average percentage of courses having focus on employability/ entrepreneurship/ skill development offered by the institution during the last five years\r\n"
						+ "\r\n",font4));
		
		PdfPCell cell4210 = new PdfPCell(
				new Paragraph(
				 "Response:"
						+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getResponse113()
								: "")+"\r\n\r\n",font5));
		
		
		//table31.addCell(cell421);
//		table31.addCell(cell4210);
		PdfPCell cell4211 = new PdfPCell(
						new Paragraph(
				"1.1.3.1 Number of courses having focus on employability/ entrepreneurship/ skill development year- wise during the last five years\r\n\r\n",font4));

	//	table31.addCell(cell4211);

		table31.setSpacingBefore(20f);
		table31.setSpacingAfter(20f);

		document.add(table31);

	//	document.add(table3);
		
		if (criteria1Record.getYearTable1131().size()>0) {
			Table table1131 = new Table(criteria1Record.getYearTable1131().size(), 2);

			table1131.setPadding(5);
			table1131.setWidth(100f);

			for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
				Cell cell1002criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1131().get(i).getInput1131y(),font5));
				cell1002criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1131.addCell(cell1002criteria1);
			}
			for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
				Cell cell101criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1131().get(i).getInput1131v(),font5));
				cell101criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1131.addCell(cell101criteria1);
				
			}

	//		document.add(table1131);
		}


/////////cr1.2

		Paragraph paragraph43 = new Paragraph("\r\n1.2 Academic Flexibility\r\n", font2);
		paragraph43.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
		document.add(paragraph43);

//creating tabl4

//PdfPTable table4 = new PdfPTable(2);
//table4.setWidthPercentage(100);
//PdfPTable table41 = new PdfPTable(1);
//table41.setWidthPercentage(100);

		/*
		 * com.lowagie.text.Font font4 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		 * font4.setColor(CMYKColor.BLACK);
		 * 
		 */

	
		

		PdfPTable table4 = new PdfPTable(2);
		PdfPTable table41 = new PdfPTable(1);
		table41.setWidthPercentage(100);
		table4.setWidthPercentage(100);
		table41.setSpacingAfter(20f);
		table41.setSpacingBefore(20f);

		
		PdfPCell cell411 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell411.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell412 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell412.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell413 = new PdfPCell(new Paragraph("Minutes of relevant Academic Council/BOS meetings",font5));
		cell413.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell414 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell414.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell415 = new PdfPCell(new Paragraph("Institutional data in prescribed format",font5));
		cell415.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell416 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell416.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell417 = new PdfPCell(new Paragraph("Any additional information",font5));
		cell417.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell418 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell418.setHorizontalAlignment(Element.ALIGN_CENTER);

		table4.addCell(cell411);
		table4.addCell(cell412);
		table4.addCell(cell413);
		table4.addCell(cell414);
		table4.addCell(cell417);

		table4.addCell(cell416);
		table4.addCell(cell415);
		table4.addCell(cell418);
		
		PdfPCell cell4181 = new PdfPCell(
				new Paragraph(
				"1.2.1 Percentage of new courses introduced out of the total number of \r\n"
				+ "courses across all programmes offered during the last five years",font4));
	
		table41.addCell(cell4181);
		
		PdfPCell cell41810 = new PdfPCell(
						new Paragraph(
				"1.2.1.1: Number of new courses introduced during the last five years:.\r\n\r\n"
						,font4));
		
		
		PdfPCell cell4181011 = new PdfPCell(
						new Paragraph("Response"
						+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1121t1()
								: "")+"\r\n\r\n",font5));
		
		
		table41.addCell(cell41810);
		table41.addCell(cell4181011);
				
		
		PdfPCell cell418101 = new PdfPCell(
				new Paragraph(
				"1.2.1.2:  Number of courses offered by the institution across all \r\n"
				+ "Programmes during the last five years:.\r\n\r\n",font4));
		table41.addCell(cell418101);
		
	
		
		document.add(table41);
		document.add(table4);


	
		PdfPTable table5 = new PdfPTable(2);
		table5.setWidthPercentage(100);
		/*
		 * com.lowagie.text.Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		 * font5.setColor(CMYKColor.BLACK);
		 */

		PdfPTable table5a = new PdfPTable(1);
		table5a.setWidthPercentage(100);
		
		table5a.setSpacingAfter(20f);
		table5a.setSpacingBefore(20f);
		/*
		 * com.lowagie.text.Font font5a = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		 * font5a.setColor(CMYKColor.BLACK)
		 */

		

		
		PdfPCell cell511 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell512 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell512.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell513 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell513.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell514 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell514.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell515 = new PdfPCell(new Paragraph("Minutes of relevant Academic Council/BOS meetings\r\n\r\n",font5));
		cell515.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell516 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell516.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell517 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n",font5));
		cell517.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell518 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell518.setHorizontalAlignment(Element.ALIGN_CENTER);
//PdfPCell cell519 = new PdfPCell(new Paragraph("Link for Additional Information\r\n"));
//PdfPCell cell520 = new PdfPCell(new Paragraph(""));
//3.1

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
		
		
		PdfPCell cell5180 = new PdfPCell(
				new Paragraph(
				"1.2.2: Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year).\r\n"
						+ (criteria1Record != null ? criteria1Record.getCriteria12Qn().get(0).getResponse122()
								: "")+"\r\n\r\n",font4));
		
		
	//	table5a.addCell(cell5180);

		PdfPCell cell51801 = new PdfPCell(
				new Paragraph(
				"1.2.2.1: Number of Programmes in which CBCS / Elective course system implemented.\r\n\r\n"
						,font4));
		
		PdfPCell cell518010 = new PdfPCell(
				new Paragraph(
				"Response"
						+ (criteria1Record != null ? criteria1Record.getCriteria12Qn().get(0).getInput1221t1()
								: "")+"\r\n\r\n",font5));
		
		
	//	table5a.addCell(cell51801);
//		table5a.addCell(cell518010);

//		Paragraph paragraph437 = new Paragraph("1.2.2.1: Total number of Programmes offered\r\n");
//+ (criteria1Record != null
//		? criteria1Record.getCriteria1FieldInfoQn().get(0).getInput122t1()
//		: ""));

//		document.add(paragraph437);
		document.add(table5a);
	//	document.add(table5);

//////cr 3.1

		Paragraph paragraph54 = new Paragraph("1.3 Curriculum Enrichment\r\n", font2);
		paragraph54.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		

//create table6
		document.add(paragraph54);
//		PdfPTable table61 = new PdfPTable(2);
//		table61.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table61.setWidthPercentage(100);
//		/*
//		 * com.lowagie.text.Font font6 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
//		 * font6.setColor(CMYKColor.BLACK);
//		 */

		PdfPTable table611 = new PdfPTable(2);
		PdfPTable table6110 = new PdfPTable(1);
		
		table611.setWidthPercentage(100);
		
		table6110.setWidthPercentage(100);
		table6110.setSpacingAfter(20f);
		table6110.setSpacingBefore(20f);
		/*
		 * com.lowagie.text.Font font61 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font61.setColor(CMYKColor.BLACK);
		 */

		

		PdfPCell cell611 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell611.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell612 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell612.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell613 = new PdfPCell(new Paragraph(
				"Upload the list and description of the courses which address the Gender, Environment and Sustainability, Human Values and Professional Ethics into the Curriculum\r\n\r\n",font5));
		cell613.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell614 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell614.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell615 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell615.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell616 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell616.setHorizontalAlignment(Element.ALIGN_CENTER);

		table611.addCell(cell611);
		table611.addCell(cell612);
		table611.addCell(cell615);
		table611.addCell(cell616);
		table611.addCell(cell613);
		table611.addCell(cell614);
		
		PdfPCell cell61612 = new PdfPCell(
				new Paragraph(
				"1.3.1: Institution integrates cross-cutting issues relevant to Professional \r\n"
				+ "Ethics, Gender, Human Values, Environment and Sustainability \r\n"
				+ "and other value framework enshrined in Sustainable Development \r\n"
				+ "Goals and National Education Policy – 2020 into the Curriculum\r\n"
				+ "\r\n\r\n"
						,font4));
		table6110.addCell(cell61612);

		PdfPCell cell6161212 = new PdfPCell(
				new Paragraph("Response:"+
				criteria1Record != null ? criteria1Record.getCriteria13Ql().get(0).getResponse131() : ""+"\r\n\r\n",font4));

		table6110.addCell(cell6161212);
		table611.setSpacingAfter(20f);
		table611.setSpacingBefore(20f);

		document.add(table6110);
		document.add(table611);

		

//create table7
//		PdfPTable table7 = new PdfPTable(5);
//		table7.setWidthPercentage(100);
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

//create 8

////		PdfPTable table81 = new PdfPTable(1);
////		table81.setWidthPercentage(100);
////		table81.setHorizontalAlignment(Element.ALIGN_CENTER);
////		/*
//		 * com.lowagie.text.Font font81 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * font81.setColor(CMYKColor.BLACK);
//		 */
////
//PdfPTable table82 = new PdfPTable(5);
//table82.setWidthPercentage(100);
///*
//* com.lowagie.text.Font font82 =
//* FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//* font82.setColor(CMYKColor.BLACK);
//*/
////create table82
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

//create table8

		PdfPTable table8 = new PdfPTable(2);
		table8.setWidthPercentage(100);
		/*
		 * com.lowagie.text.Font font8 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font8.setColor(CMYKColor.BLACK);
		 */

		PdfPTable table33 = new PdfPTable(1);
		table33.setWidthPercentage(100);
		PdfPCell cell61612120 = new PdfPCell(
				new Paragraph(
				"1.3.2: Number of certificate/value added courses/Diploma Programmes \r\n"
				+ "offered by the institutions and online courses of MOOCs, \r\n"
				+ "SWAYAM/e-PG Pathshala/ NPTEL etc. where the students of the \r\n"
				+ "institution have enrolled and successfully completed during the last \r\n"
				+ "five years.\r\n\r\n"
						+ "\r\n"
						+ (criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getResponse133()
								: "")+"\r\n\r\n",font4));
		table33.addCell(cell61612120);
		
		PdfPCell cell6161212010 = new PdfPCell(
				new Paragraph("1.3.2.1: Number of certificate/value added courses/Diploma \r\n"
						+ "Programmes offered by the institutions and online courses of \r\n"
						+ "MOOCs, SWAYAM/e-PG Pathshala/ NPTEL etc. where the \r\n"
						+ "students of the institution have enrolled and successfully completed \r\n"
						+ "during the last five years\r\n\r\n"
										,font4));
		
		table33.addCell(cell6161212010);

		document.add(table33);

//if( criteria2Record.getYearTable2121() !=null)
//{
//Table table2122 = new Table(criteria2Record.getYearTable2121().size()+1, 2);

	

		PdfPCell cell81 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell81.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell82 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell83 = new PdfPCell(new Paragraph("List of value added courses (Data Template)\r\n\r\n",font5));
		cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell84 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell84.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell85 = new PdfPCell(
				new Paragraph("Brochure or any other document relating to value added courses\r\n\r\n",font5));
		cell85.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell86 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell86.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell87 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell87.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell88 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell88.setHorizontalAlignment(Element.ALIGN_CENTER);

		table8.addCell(cell81);
		table8.addCell(cell82);
		table8.addCell(cell83);
		table8.addCell(cell84);
		table8.addCell(cell85);
		table8.addCell(cell86);
		table8.addCell(cell87);
		table8.addCell(cell88);
		table8.setSpacingAfter(20f);
		table8.setSpacingBefore(20f);
		
		document.add(table8);
		
		if (criteria1Record.getYearTable1321() != null) {
			Table table1321 = new Table(criteria1Record.getYearTable1321().size() + 1, 2);

			table1321.setPadding(5);
			table1321.setWidth(100f);

			table1321.addCell("year");

			for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {
				Cell cell102criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1321().get(i).getInput1321y(),font5));
				cell102criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1321.addCell(cell102criteria1);
				
				
			}

			table1321.addCell("number");
			for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {

				Cell cell12criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1321().get(i).getInput1321v(),font5));
				cell12criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1321.addCell(cell12criteria1);
				
				
			}
	//		document.add(table1321);
			
		
		}

		
		
		
//create table9
//PdfPTable table9 = new PdfPTable(5);
//PdfPTable table91 = new PdfPTable(1);
////PdfPTable table92=new PdfPTable(2);

//table9.setWidthPercentage(100);
//table91.setWidthPercentage(100);
////table92.setWidthPercentage(100);
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


		PdfPTable table92 = new PdfPTable(2);
		PdfPTable table920 = new PdfPTable(1);
		
		
		table92.setWidthPercentage(100);
		table920.setWidthPercentage(100);
		table920.setSpacingAfter(20f);
		table920.setSpacingBefore(20f);

		PdfPCell cell921 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell921.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell922 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell922.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell923 = new PdfPCell(new Paragraph("List of students enrolled\r\n\r\n",font5));
		cell923.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell924 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell924.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell925 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell925.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell926 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell926.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell927 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n",font5));
		cell927.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell928 = new PdfPCell(new Paragraph("",font5));
		cell928.setHorizontalAlignment(Element.ALIGN_CENTER);

		table92.addCell(cell921);
		table92.addCell(cell922);
		table92.addCell(cell923);
		table92.addCell(cell924);
		table92.addCell(cell925);
		table92.addCell(cell926);
		table92.addCell(cell927);
		table92.addCell(cell928);
		
		PdfPCell cell106 = new PdfPCell(
				new Paragraph(
				"1.3.3: Percentage of programmes that have components of field projects  \r\n"
				+ "research projects / internships during the last five years\r\n\r\n"
						+ "Response",font4));
		
		
		
		table920.addCell(cell106);
		
		
		
		PdfPCell cell1060 = new PdfPCell(
				new Paragraph(
				"1.3.3.1: Number of programmes that have components of field \r\n"
				+ "projects / research projects / internships during the last five years:\r\n"
				+ "\r\n\r\n",font4));
		
		table920.addCell(cell1060);
	
		PdfPCell cell1063 = new PdfPCell(
				new Paragraph(  "Response:"+
				criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getResponse133() : ""+"\r\n\r\n",font5));
		table920.addCell(cell1063);
		
		PdfPCell cell10601 = new PdfPCell(
				new Paragraph(
				"1.3.3.2: Number of programmes offered by the institution during the \r\n"
				+ "last five years:"
				+ "\r\n\r\n",font4));
		
		table920.addCell(cell10601);
	
	
	
		document.add(table920);

		document.add(table92);


		if (criteria1Record.getYearTable1331() != null) {
			Table table1331 = new Table(criteria1Record.getYearTable1331().size(), 2);
			System.out.println(criteria1Record.getYearTable1331());

			table1331.setPadding(5);
			table1331.setWidth(100f);

			for (int i = 0; i < criteria1Record.getYearTable1331().size(); i++) {
				Cell cell1201criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1331().get(i).getInput1331y(),font5));
				cell1201criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1331.addCell(cell1201criteria1);
			}
			for (int i = 0; i < criteria1Record.getYearTable1331().size(); i++) {
				Cell cell1202criteria1 = new Cell(new Paragraph(criteria1Record.getYearTable1331().get(i).getInput1331v(),font5));
				cell1202criteria1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1331.addCell(cell1202criteria1);
			}

		//	document.add(table1331);
			
		}

	
		

//create table10
		PdfPTable table10 = new PdfPTable(2);
		table10.setHorizontalAlignment(Element.ALIGN_CENTER);
		table10.setWidthPercentage(100);

		PdfPTable table101 = new PdfPTable(1);
		table101.setWidthPercentage(100);

		PdfPCell cell101 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell101.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell102 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell102.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell103 = new PdfPCell(new Paragraph(
				"List of programs and number of students undertaking field projects / internships / student projects (Data Template)",font5));
		cell103.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell104 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell104.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell105 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell105.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1061 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell1061.setHorizontalAlignment(Element.ALIGN_CENTER);

		table10.addCell(cell101);
		table10.addCell(cell102);
		table10.addCell(cell103);
		table10.addCell(cell104);
		table10.addCell(cell105);
		table10.addCell(cell1061);
		
		PdfPCell cell10611 = new PdfPCell(
				new Paragraph(
				"1.3.4: Percentage of students undertaking field projects/ internships / student projects (Data for the latest completed academic year)"
						+ (criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getResponse134()
								: "")+"\r\n\r\n",font4));
//		table101.addCell(cell10611);

		PdfPCell cell1061100 = new PdfPCell(
				new Paragraph(
				"1.3.4.1: Number of students undertaking field projects / internships / student projects.\r\n"
						+ (criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getInput1341t1()
								: "")+"\r\n\r\n",font4));
		
		PdfPCell cell10611000 = new PdfPCell(
				new Paragraph(
				"Response"
						+ (criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getInput1341t1()
								: "")+"\r\n\r\n",font4));
		
	//	table101.addCell(cell1061100);
	//	table101.addCell(cell10611000);

//		PdfPCell cell10611001 = new PdfPCell(
//				new Paragraph("1.3.4.1: Total number of students\r\n"
//				+ (criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getInput1341t1() : ""),font5));
//		table101.addCell(cell10611001);
//		
		table101.setSpacingAfter(20f);
		table101.setSpacingBefore(20f);
//		document.add(table101);

		document.add(table10);

//////////////////cr 4.1

		Paragraph paragraph6741 = new Paragraph("1.4  Feedback System\r\n\r\n", font2);
		paragraph6741.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph6741);


		PdfPTable table111141 = new PdfPTable(2);
		table111141.setWidthPercentage(100);
		PdfPTable table1111410 = new PdfPTable(1);
		table1111410.setWidthPercentage(100);
		table1111410.setSpacingAfter(20f);
		table1111410.setSpacingBefore(20f);

		PdfPCell cell1111 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell1111.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1121 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell1121.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1131 = new PdfPCell(new Paragraph("URL for stakeholder feedback report\r\n\r\n",font5));
		cell1131.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1141 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
		cell1141.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1151 = new PdfPCell(new Paragraph(
				"Action taken report of the Institution on feedback report as minuted by the Governing Council,Syndicate, Board of Management\r\n\r\n",font5));
		cell1151.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1161 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
		cell1161.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1171 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
		cell1171.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1181 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
		cell1181.setHorizontalAlignment(Element.ALIGN_CENTER);

		table111141.addCell(cell1111);
		table111141.addCell(cell1121);
		table111141.addCell(cell1131);
		table111141.addCell(cell1141);
		table111141.addCell(cell1151);
		table111141.addCell(cell1161);
		table111141.addCell(cell1171);
		table111141.addCell(cell1181);
		
		
		PdfPCell cell11810 = new PdfPCell(
				new Paragraph(
				"1.4.1: Structured feedback for curriculum and its transaction is regularly \r\n"
				+ "obtained from stakeholders like Students, Teachers, Employers, \r\n"
				+ "Alumni, Academic peers etc., and Feedback processes of the \r\n"
				+ "institution may be classified as follows:\r\n"
				+ "A. Feedback collected, analysed, action taken& communicated to \r\n"
				+ "the relevant bodies and feedback hosted on the institutional \r\n"
				+ "website\r\n"
				+ "B. Feedback collected, analysed, action has been taken and \r\n"
				+ "communicated to the relevant bodies\r\n"
				+ "C. Feedback collected and analysed\r\n"
				+ "D. Feedback collected\r\n"
				+ "E. Feedback not collecte\r\n\r\n"
						,font4));
		table1111410.addCell(cell11810);
	
		if (criteria1Record.getCriteria11Ql() != null) {
			PdfPCell cell118101 = new PdfPCell(
					new Paragraph("Response\r\n"+
					criteria1Record != null ? criteria1Record.getCriteria14Qn().get(0).getResponse141() : ""+"\r\n\r\n",font5));
			table1111410.addCell(cell118101);
		
		}

		document.add(table1111410);
		document.add(table111141);

		

		PdfPTable table111241 = new PdfPTable(2);
		table111241.setWidthPercentage(100);
		
		PdfPTable table1112410 = new PdfPTable(1);
		table1112410.setWidthPercentage(100);
		
		table1112410.setSpacingAfter(20f);
		table1112410.setSpacingBefore(20f);

		PdfPCell cell1211 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell1211.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1221 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell1221.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1231 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell1231.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1241 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
		cell1241.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1251 = new PdfPCell(new Paragraph("URL for stakeholder feedback report\r\n\r\n",font5));
		cell1251.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1261 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
		cell1261.setHorizontalAlignment(Element.ALIGN_CENTER);

		table111241.addCell(cell1211);
		table111241.addCell(cell1221);
		table111241.addCell(cell1231);
		table111241.addCell(cell1241);
		table111241.addCell(cell1251);
		table111241.addCell(cell1261);
		
		
		PdfPCell cell126112 = new PdfPCell(
				new Paragraph(
				"1.4.2: The feedback system of the Institution comprises of the following :\r\n\r\n",font4));
	
//		table1112410.addCell(cell126112);
		
		PdfPCell cell126111 = new PdfPCell(
						new Paragraph("Response\r\n"+
				criteria1Record != null ? criteria1Record.getCriteria14Qn().get(0).getResponse142() : ""+"\r\n\r\n",font5));
		cell126111.setExtraParagraphSpace(10f);
//
	//	table1112410.addCell(cell126111);

		document.add(table1112410);
		
		
//		document.add(table111241);
		}

	//////////////////////////////////////////////////// 2.1
	public void Criteria2(Document document, Criteria2_FieldInfo criteria2Fieldinfo) {
		Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font1);
		paragraph2criteria2.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph2criteria2);

		Paragraph paragraph2linecriteria2 = new Paragraph("____________________________________________________________________________");
		paragraph2criteria2.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph2linecriteria2);

		Paragraph paragraph3criteria2 = new Paragraph("2.1 Student Enrollment and Profile\r\n\r\n", font2);

		paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		paragraph3criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		
		document.add(paragraph3criteria2);
		
		PdfPTable tablecriteria2 = new PdfPTable(1);
//		PdfPTable table1criteria2 = new PdfPTable(1);
		
		tablecriteria2.setWidthPercentage(100f);
		PdfPCell cell321criteria2 = new PdfPCell(new Paragraph("2.1.1 Enrolment percentage\r\n" + "\r\n" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria21Qn().get(0).getResponse211()
								: ""),font4));

		// Paragraph paragraph6 = new Paragraph("2.1.1.1 Number of students admitted
		// year-wise during last five years ", font3);
		PdfPCell cell3212criteria2 = new PdfPCell(new Paragraph("2.1.1.1 Number of seats filled year wise during last five years\r\n"
				+ "(Only first year admissions to be considered)\r\n\r\n ",font4));

		tablecriteria2.addCell(cell321criteria2);
		tablecriteria2.addCell(cell3212criteria2);
		
		
		document.add(tablecriteria2);
//		document.add(table1criteria2);
		

		Table table2111 = new Table(criteria2Record.getYearTable2111().size(), 2);

		table2111.setPadding(5);
		table2111.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
			
			Cell cell120criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2111().get(i).getInput2111y(),font5));
			
			cell120criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2111.addCell(cell120criteria2);
			
			
		}
		for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
			Cell cell120criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2111().get(i).getInput2111v(),font5));
			cell120criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2111.addCell(cell120criteria2);
			
		}

		document.add(table2111);
		
		PdfPTable tablecriteria2112 = new PdfPTable(1);
//		PdfPTable table1criteria2 = new PdfPTable(1);
		
		tablecriteria2112.setWidthPercentage(100f);
		tablecriteria2112.setSpacingAfter(20f);
		tablecriteria2112.setSpacingBefore(20f);

		PdfPCell cell32121criteria2 = new PdfPCell(new Paragraph(" 2.1.1.2 Number of sanctioned seats year wise during last five years\r\n\r\n",font4));
		tablecriteria2112.addCell(cell32121criteria2);
		
		document.add(tablecriteria2112);
		
		
		Table table2112 = new Table(criteria2Record.getYearTable2112().size(), 2);

		table2112.setPadding(5);
		table2112.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
			Cell cell12criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2112().get(i).getInput2112y(),font5));
			cell12criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2111.addCell(cell12criteria2);
			
		}
		for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
			Cell cell121criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2112().get(i).getInput2112v(),font5));
			cell121criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2111.addCell(cell121criteria2);
			
		}

		document.add(table2112);

		

		PdfPTable table3criteria2 = new PdfPTable(2);
		table3criteria2.setWidthPercentage(100f);
		table3criteria2.setWidths(new int[] { 3, 3 });
		
//		table3criteria2.setSpacingBefore(20f);
//		table3criteria2.setSpacingBefore(20f);


		
//		PdfPTable table7criteria2 = new PdfPTable(2);
		PdfPCell cell1criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell1criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell1criteria2);

		PdfPCell cell2criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell2criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell2criteria2);

		PdfPCell cell3criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell3criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell3criteria2);

		PdfPCell cell4criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell4criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell4criteria2);

		PdfPCell cell5criteria2 = new PdfPCell(new Paragraph(
				"Demand Ratio (Average of Last five years) based on Data Template upload the documentAny\r\n",font5));
		cell5criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell5criteria2);

		PdfPCell cell6criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "",font5));
		cell6criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell6criteria2);

		document.add(table3criteria2);

		
		
		PdfPTable table1criteria2 = new PdfPTable(2);
		PdfPTable table1criteria21 = new PdfPTable(1);

		table1criteria2.setWidthPercentage(100f);
		table1criteria21.setWidthPercentage(100f);
		
		table1criteria2.setSpacingAfter(20f);
		table1criteria2.setSpacingBefore(20f);
		
		table1criteria21.setSpacingAfter(20f);
		table1criteria21.setSpacingBefore(20f);
		
		
		
		PdfPCell cell07criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell07criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1criteria2.addCell(cell07criteria2);

		PdfPCell cell08criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell08criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1criteria2.addCell(cell08criteria2);

		PdfPCell cell09criteria2 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n",font5));
		cell09criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1criteria2.addCell(cell09criteria2);

		PdfPCell cell10criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(2).getCriteria2FilePath() : "",font5));
		cell10criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1criteria2.addCell(cell10criteria2);

		PdfPCell cell11criteria2 = new PdfPCell(
				new Paragraph("Average percentage of seats filled against seats reserved\r\n\r\n",font5));
		cell11criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1criteria2.addCell(cell11criteria2);

		PdfPCell cell12criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : "",font5));
		cell12criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table1criteria2.addCell(cell12criteria2);

		PdfPCell cell60criteria2 = new PdfPCell(
				new Paragraph(
				"2.1.2 Percentage of seats filled against reserved categories (SC, ST, OBC \r\n"
				+ "etc.) as per applicable reservation policy for the first year admission\r\n"
				+ "during the last five years\r\n"
				+ "Response: "
						+ (criteria2Record != null ? criteria2Record.getCriteria21Qn().get(0).getResponse212()
								: "")+"\r\n\r\n",font4));
		table1criteria21.addCell(cell60criteria2);

		PdfPCell cell600criteria2 = new PdfPCell(
				new Paragraph(
				"2.1.2.1 Number of actual students admitted from the reserved \r\n"
				+ "categories year wise during the last five years \r\n"
						+ "\r\n\r\n" ,font4));
		table1criteria21.addCell(cell600criteria2);
		
		PdfPCell cell6000criteria2 = new PdfPCell(
				new Paragraph(
				"2.1.2.1: Number of seats earmarked for reserved category as per GOI or state Government rule\r\n\r\n",font4));
		table1criteria21.addCell(cell6000criteria2);
		
		document.add(table1criteria21);
		document.add(table1criteria2);
		
		if (criteria2Record.getYearTable2121() != null) {

			Table table2121 = new Table(criteria2Record.getYearTable2121().size(), 2);

			table2121.setPadding(5);
			table2121.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
				
				
				Cell cell100criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2121().get(i).getInput2121y(),font5));
				cell100criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2121.addCell(cell100criteria2);
			}
			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
				Cell cell110criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2121().get(i).getInput2121v(),font5));
				cell110criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2121.addCell(cell110criteria2);
				
			}

			document.add(table2121);
		
		}

	

		if (criteria2Record.getYearTable21212().size() > 0) {

			Table table21212 = new Table(criteria2Record.getYearTable21212().size(), 2);

			table21212.setPadding(5);
			table21212.setWidth(100f);

			for (int i = 0; i < criteria2Record.getYearTable21212().size(); i++) {
				
				Cell cell110criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable21212().get(i).getInput21212y(),font5));
				cell110criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table21212.addCell(cell110criteria2);
				
			}
			for (int i = 0; i < criteria2Record.getYearTable21212().size(); i++) {
				Cell cell120criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable21212().get(i).getInput21212v(),font5));
				cell120criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table21212.addCell(cell120criteria2);
				
			}

			document.add(table21212);
		
		}

//		table7criteria2.setWidthPercentage(100f);
//		table7criteria2.setWidths(new int[] { 3, 3 });
//		table7criteria2.setSpacingBefore(15);
//		table7criteria2.setSpacingAfter(15);

	
		/////// cr2.2

		Paragraph paragraph4criteria2 = new Paragraph("2.2  Catering to Student Diversity\r\n\r\n", font2);
	
		document.add(paragraph4criteria2);

		PdfPTable table01 = new PdfPTable(1);
		table01.setWidthPercentage(100f);

		PdfPCell cell120criteria2 = new PdfPCell(
				new Paragraph(
				"2.2.1: The institution assesses the learning levels of the students and \r\n"
				+ "organises special Programmes to cater to differential learning \r\n"
				+ "needs of the student\r\n\r\n"
						+ "Response:" + criteria2Record.getCriteria22Qn().get(0).getResponse221()
				+"\r\n\r\n",font4));
		
		table01.addCell(cell120criteria2);
		document.add(table01);

		PdfPTable table9criteria0000000000002 = new PdfPTable(2);
		table9criteria0000000000002.setSpacingAfter(20);
		table9criteria0000000000002.setSpacingBefore(20);

		table9criteria0000000000002.setWidthPercentage(100f);
		table9criteria0000000000002.setWidths(new int[] { 3, 3 });
		table9criteria0000000000002.setSpacingBefore(5);

		PdfPCell cell17criteria2 = new PdfPCell(new Paragraph("File Description\r\n", font4));
		cell17criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria0000000000002.addCell(cell17criteria2);

		PdfPCell cell18criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell18criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria0000000000002.addCell(cell18criteria2);

		PdfPCell cell19criteria2 = new PdfPCell(new Paragraph("Uplaod any additional information\r\n\r\n",font5));
		cell19criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria0000000000002.addCell(cell19criteria2);

		PdfPCell cell20criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(5).getCriteria2FilePath() : "",font5));
		cell20criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria0000000000002.addCell(cell20criteria2);

		PdfPCell cell19criteria21 = new PdfPCell(new Paragraph("Uplaod any additional information\r\n\r\n",font5));
		cell19criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria0000000000002.addCell(cell19criteria21);

		PdfPCell cell20criteria21 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(5).getCriteria2FilePath() : "",font5));
		cell20criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table9criteria0000000000002.addCell(cell20criteria21);
		
		table9criteria0000000000002.setSpacingAfter(20f);

		table9criteria0000000000002.setSpacingBefore(20f);
		

		document.add(table9criteria0000000000002);

		////////////////////////

		
		PdfPTable table9criteria2 = new PdfPTable(2);
		PdfPTable table9criteria21 = new PdfPTable(1);
		

		table9criteria2.setWidthPercentage(100f);
		table9criteria21.setWidthPercentage(100f);
		
		table9criteria2.setWidths(new int[] { 3, 3 });
		table9criteria2.setSpacingBefore(5);
		table9criteria21.setSpacingAfter(20f);
		table9criteria21.setSpacingBefore(20f);

		PdfPCell cell17criteria21 = new PdfPCell(new Paragraph("File Description\r\n", font4));
		cell17criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria2.addCell(cell17criteria21);

		PdfPCell cell18criteria21 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell18criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria2.addCell(cell18criteria21);

		PdfPCell cell19criteria211 = new PdfPCell(new Paragraph("Uplaod any additional information\r\n\r\n",font5));
		cell19criteria211.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria2.addCell(cell19criteria211);

		PdfPCell cell20criteria211 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(5).getCriteria2FilePath() : "",font5));
		cell20criteria211.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria2.addCell(cell20criteria211);
		
		
		PdfPCell cell200criteria211 = new PdfPCell(
				new Paragraph(
				"2.2.2: Student - Full time teacher ratio (Data for the latest completed\r\n"
				+ "academic year)\r\n\r\n,)"
						,font4));
		table9criteria21.addCell(cell200criteria211);
		
	
		if (criteria2Record.getCriteria22Qn() != null) {
			PdfPCell cell2001criteria211 = new PdfPCell(
					new Paragraph("Response:"+
					criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getResponse221() : ""+"\r\n\r\n",font5));
					table9criteria21.addCell(cell2001criteria211);
		} else {
			Paragraph paragraph4criteria2244 = new Paragraph("");
			document.add(paragraph4criteria2244);
		}
		PdfPCell cell2001criteria211 = new PdfPCell(
				new Paragraph(
				"A.Total Number of students enrolled in the institution.\r\n\r\n" ,font4));
		table9criteria21.addCell(cell2001criteria211);

		if (criteria2Record.getCriteria22Qn() != null) {
			PdfPCell cell20012criteria211 = new PdfPCell(
					new Paragraph("Response:"+
					criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getResponse221() : ""+"\r\n\r\n",font4));
			table9criteria21.addCell(cell20012criteria211);
		} else {
			Paragraph paragraph4criteria2244 = new Paragraph("");
			document.add(paragraph4criteria2244);
		}
		PdfPCell cell200122criteria211 = new PdfPCell(
				new Paragraph(
				"B.Total number of full time teachers in the institution\r\n\r\n",font4));
				table9criteria21.addCell(cell200122criteria211);

		if (criteria2Record.getCriteria22Qn() != null) {
			PdfPCell cell2001221criteria211 = new PdfPCell(
					new Paragraph(  "Response:"+
					criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getResponse221() : ""+"\r\n\r\n",font4));
					table9criteria21.addCell(cell2001221criteria211);

		} else {
			Paragraph paragraph4criteria2244 = new Paragraph("");
			document.add(paragraph4criteria2244);
		}

		
		document.add(table9criteria21);

		document.add(table9criteria2);


		//////////////// cr2.3

		Paragraph paragraph5criteria2 = new Paragraph("2.3	Teaching- Learning Process\r\n\r\n", font2);
		document.add(paragraph5criteria2);

		PdfPTable table03 = new PdfPTable(1);
		table03.setWidthPercentage(100f);

		PdfPCell cell001 = new PdfPCell(new Paragraph(
				"2.3.1 Student centric methods, such as experiential learning, \r\n"
				+ "participative learning and problem solving methodologies are used \r\n"
				+ "for enhancing learning experience and teachers use ICT- enabled \r\n"
				+ "tools including online resources for effective teaching and learning process"
						+ "\r\n\r\n" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria23Ql().get(0).getResponse231()
								: "")
						+"\r\n\r\n",font4));

		table03.addCell(cell001);

		document.add(table03);

		PdfPTable table10criteria2 = new PdfPTable(2);

		table10criteria2.setWidthPercentage(100f);
		table10criteria2.setWidths(new int[] { 3, 3 });
		table10criteria2.setSpacingBefore(20f);
		table10criteria2.setSpacingAfter(20f);

		PdfPCell cell21criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell21criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table10criteria2.addCell(cell21criteria2);

		PdfPCell cell22criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell22criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table10criteria2.addCell(cell22criteria2);

		PdfPCell cell23criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n",font5));
		cell23criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table10criteria2.addCell(cell23criteria2);

		PdfPCell cell24criteria2 = new PdfPCell(new Paragraph(" ",font5));
		cell24criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table10criteria2.addCell(cell24criteria2);

		document.add(table10criteria2);

		PdfPTable table04 = new PdfPTable(1);
		table04.setWidthPercentage(100f);
		
		table04.setSpacingAfter(20f);
		table04.setSpacingBefore(20f);

		PdfPCell cell002 = new PdfPCell(new Paragraph(
				"2.3.2 The institution adopts effective Mentor-Mentee Schemes to address \r\n"
				+ "academics and student-psychological issues.\r\n\r\n"
						+ "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria23Ql().get(0).getResponse232()
								: ""),font4));

		table04.addCell(cell002);

		document.add(table04);

		PdfPTable table11criteria2 = new PdfPTable(2);

		table11criteria2.setWidthPercentage(100f);
		table11criteria2.setWidths(new int[] { 3, 3 });
		table11criteria2.setSpacingBefore(5);

		PdfPCell cell25criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell25criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11criteria2.addCell(cell25criteria2);

		PdfPCell cell26criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell26criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11criteria2.addCell(cell26criteria2);

		PdfPCell cell27criteria2 = new PdfPCell(new Paragraph(
				"Provide link for webpage describing ICT enabled tools including online resources for effective teaching and learning process",font5));
		cell27criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11criteria2.addCell(cell27criteria2);

		PdfPCell cell28criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(3).getCriteria2FilePath() : "",font5));
		cell28criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11criteria2.addCell(cell28criteria2);

		PdfPCell cell29criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n", font5));
		cell29criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11criteria2.addCell(cell29criteria2);

		PdfPCell cell30criteria2 = new PdfPCell(new Paragraph("",font5));
		cell30criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11criteria2.addCell(cell30criteria2);

		document.add(table11criteria2);

		PdfPTable table05 = new PdfPTable(1);
		table05.setWidthPercentage(100f);
		
		table05.setSpacingAfter(20f);
		table05.setSpacingBefore(20f);
		
		PdfPCell cell290criteria2 = new PdfPCell(new Paragraph(
				"2.3.3 Preparation and adherence of Academic Calendar and Teaching \r\n"
				+ "plans by the institution\r\n"
						+ "\r\n" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria23Qn().get(0).getResponse233()
								: "")+"\r\n\r\n",font4));

		table05.addCell(cell290criteria2);
		PdfPCell cell2900criteria2 = new PdfPCell(new Paragraph("2.3.3.1 Number of mentors \r\nResponse:"
				+ (criteria2Record != null ? criteria2Record.getCriteria23Qn().get(0).getInput2331t1() : "")+"\r\n\r\n",font5));
		
//		table05.addCell(cell2900criteria2);
		
		document.add(table05);

		PdfPTable table13criteria2 = new PdfPTable(2);

		table13criteria2.setWidthPercentage(100f);
		table13criteria2.setWidths(new int[] { 3, 3 });
		table13criteria2.setSpacingBefore(5);

		PdfPCell cell31criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell31criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table13criteria2.addCell(cell31criteria2);

		PdfPCell cell32criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell32criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table13criteria2.addCell(cell32criteria2);

		PdfPCell cell33criteria2 = new PdfPCell(
				new Paragraph("Upload year wise, number of students enrolled and full time teachers on roll\r\n\r\n",font5));
		cell33criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table13criteria2.addCell(cell33criteria2);

		PdfPCell cell34criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(4).getCriteria2FilePath() : "",font5));
		cell34criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table13criteria2.addCell(cell34criteria2);

		PdfPCell cell35criteria2 = new PdfPCell(new Paragraph("Circulars pertaining to assigning mentors to mentees\r\n\r\n",font5));
		cell35criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table13criteria2.addCell(cell35criteria2);

		PdfPCell cell36criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(5).getCriteria2FilePath() : "",font5));
		cell36criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table13criteria2.addCell(cell36criteria2);

		PdfPCell cell37criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n",font5));
		cell37criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table13criteria2.addCell(cell37criteria2);

		PdfPCell cell38criteria2 = new PdfPCell(new Paragraph("",font5));
		cell38criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table13criteria2.addCell(cell38criteria2);

		document.add(table13criteria2);

		PdfPTable table06 = new PdfPTable(1);
		table06.setWidthPercentage(100f);
		
		table06.setSpacingBefore(20f);
		table06.setSpacingAfter(20f);

		PdfPCell cell003 = new PdfPCell(new Paragraph(
				"2.3.4 Preparation and adherence of Academic Calendar and Teaching plans by the institution\r\n\r\n" + ""
						+ "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria23Ql().get(0).getResponse234()
								: ""),font4));

	//	table06.addCell(cell003);
		document.add(table06);

		PdfPTable table15criteria2 = new PdfPTable(2);

		table15criteria2.setWidthPercentage(100f);
		table15criteria2.setWidths(new int[] { 3, 3 });
		table15criteria2.setSpacingBefore(20f);
		table15criteria2.setSpacingAfter(20f);

		PdfPCell cell39criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell39criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table15criteria2.addCell(cell39criteria2);

		PdfPCell cell40criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell40criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table15criteria2.addCell(cell40criteria2);

		PdfPCell cell41criteria2 = new PdfPCell(
				new Paragraph("Upload Academic Calendar and Teaching plans for five years\r\n\r\n",font5));
		cell41criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table15criteria2.addCell(cell41criteria2);

		PdfPCell cell42criteria2 = new PdfPCell(new Paragraph(criteria2file.get(3).getCriteria2FilePath(),font5));
		cell42criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table15criteria2.addCell(cell42criteria2);

		document.add(table15criteria2);
		////////// cr24

		Paragraph paragraph6criteria2 = new Paragraph(" 2.4 Teacher Profile and Quality\r\n\r\n", font2);

		paragraph6criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph6criteria2);

		PdfPTable table07 = new PdfPTable(1);
		table07.setWidthPercentage(100f);

		PdfPCell cell3810criteria2 = new PdfPCell(
				new Paragraph(
				"2.4.1: Percentage of full-time teachers against sanctioned posts during the last five years\r\n\r\n"
						,font4));
				table07.addCell(cell3810criteria2);
				
		if (criteria2Record.getCriteria24Qn() != null) {
			PdfPCell cell38100criteria2 = new PdfPCell(
					new Paragraph("Response:"+
					(criteria2Record != null ? criteria2Record.getCriteria24Qn().get(0).getResponse241() : "")+"\r\n\r\n",font4));
			table07.addCell(cell38100criteria2);
		}

		Paragraph paragraph6criteria23 = new Paragraph(
				"2.4.1.1 Number of Sanctioned posts / required positions for teaching staff/ full time teachers year wise during the last five years:");

		document.add(paragraph6criteria23);

		if (criteria2Record.getCriteria24Qn() != null) {
			Paragraph paragraph6criteria24 = new Paragraph(
					criteria2Record != null ? criteria2Record.getCriteria24Qn().get(0).getResponse241() : "");
			document.add(paragraph6criteria24);
		}
		
		document.add(table07);

		if (criteria2Record.getYearTable2421() != null) {
			Table table2421 = new Table(criteria2Record.getYearTable2421().size(), 2);

			table2421.setPadding(5);
			table2421.setWidth(100f);
	
			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
		
				Cell cell1110criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421y(),font5));
				cell1110criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell1110criteria2);
				
			}
		
			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
				Cell cell110criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421v(),font5));
				
				cell110criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell110criteria2);
				
				
			}

			document.add(table2421);
			

		}

//		Paragraph paragraph6criteria25 = new Paragraph("B. Number of Sanctioned Posts");
//		document.add(paragraph6criteria25);

		if (criteria2Record.getYearTable2421() != null) {
			Table table2421 = new Table(criteria2Record.getYearTable2421().size(), 2);

			table2421.setPadding(5);
			table2421.setWidth(100f);
		
			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
				
				Cell cell110criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421y(),font5));
				
				cell110criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell110criteria2);
			}
		
			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
				Cell cell1100criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421v(),font5));
				cell1100criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell1100criteria2);
				
			}

			document.add(table2421);

		}

//		table07.addCell(cell004);
//		table07.addCell(cell0004);
//		document.add(table07);

		// YEAR TABLE1
//		Table table2411 = new Table(criteria2Record.getYearTable2411().size(), 2);
		//
//		table2411.setPadding(10);
//		table2411.setWidth(100f);
		//
//		for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
//			table2411.addCell(criteria2Record.getYearTable2411().get(i).getInput2411y());
//		}
//		for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
//			table2411.addCell(criteria2Record.getYearTable2411().get(i).getInput2411v());
//		}
//		document.add(table2411);

		PdfPTable table14 = new PdfPTable(2);

		table14.setWidthPercentage(100f);
		table14.setWidths(new int[] { 3, 3 });
		table14.setSpacingBefore(20f);
		table14.setSpacingAfter(20f);

		PdfPCell cell43 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell43.setHorizontalAlignment(Element.ALIGN_CENTER);
		table14.addCell(cell43);

		PdfPCell cell44 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
		table14.addCell(cell44);

		PdfPCell cell45 = new PdfPCell(new Paragraph(
				"Year wise full time teachers and sanctioned posts for 5 years(Data Template)\r\n\r\n",font5));
		cell45.setHorizontalAlignment(Element.ALIGN_CENTER);
		table14.addCell(cell45);

		PdfPCell cell46 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(13).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
		cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
		table14.addCell(cell46);
		
		document.add(table14);

		
		

//		PdfPCell cell47 = new PdfPCell(new Paragraph("List of the faculty members authenticated by the Head of HEI\r\n\r\n"));
//		table14.addCell(cell47);
//
//		PdfPCell cell48 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(14).getCriteria2FilePath() : ""));
//		table14.addCell(cell48);
//
//		PdfPCell cell49 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n"));
//		table14.addCell(cell49);
//
//		PdfPCell cell50 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(15).getCriteria2FilePath() : ""));
//		table14.addCell(cell50);

		// 242

		PdfPTable table08 = new PdfPTable(1);
		table08.setWidthPercentage(100f);

		PdfPCell cell460 = new PdfPCell(
				new Paragraph(
				"2.4.2  Percentage of full time teachers with Ph.D./D.Sc. / D.Litt./ L.L.D \r\n"
				+ "during the last five years\r\n\r\n"
						+ "\r\n" ,font4));
				table08.addCell(cell460);
		if (criteria2Record.getCriteria24Qn() != null) {

			PdfPCell cell4600 = new PdfPCell(
					new Paragraph( "Response:"+
					(criteria2Record != null ? criteria2Record.getCriteria24Qn().get(0).getResponse242() : ""+"\r\n\r\n"),font5));
					table08.addCell(cell4600);
		}

		PdfPCell cell4601 = new PdfPCell(
				new Paragraph(
				"2.4.2.1: Number of full time teachers with Ph.D./D.Sc. / D.Litt./ \r\n"
				+ "L.L.D year wise during last five years",font4));
	
//		table08.addCell(cell4601);
		
		PdfPCell cell460110 = new PdfPCell(
				new Paragraph(
				"2.4.3 Average teaching experience of full time teachers (Data to be \r\n"
				+ "provided only for the latest completed academic year, in number of \r\n"
				+ "years)",font4));
	
		table08.addCell(cell460110);
		

		PdfPCell cell4601101 = new PdfPCell(
				new Paragraph(
				"2.4.3.1 Total teaching experience of full-time teachers as of latest completed academic year",font4));
	
		table08.addCell(cell4601101);
		

//		PdfPCell cell46011 = new PdfPCell(
//				new Paragraph(
//				"A: Total number of full time teachers with such qualifications during last five years\r\n\r\n",font4));
//	   table08.addCell(cell46011);
	   
	  document.add(table08);

		if (criteria2Record.getYearTable2421() != null) {
			Table table2421 = new Table(criteria2Record.getYearTable2421().size(), 2);

			table2421.setPadding(5);
			table2421.setWidth(100f);
			
			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
			
				Cell cell01criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421y(),font5));
				cell01criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell01criteria2);
				
			}
			
			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
				Cell cell02criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421v(),font5));
				cell02criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell02criteria2);
				
			}

		//	document.add(table2421);
		
		}
//
//		Paragraph paragraph6criteria31 = new Paragraph(
//				"B: Total number of full time teachers year wise during last five years"+"\r\n\r\n",font4);
//		document.add(paragraph6criteria31);

		if (criteria2Record.getYearTable2421() != null)

		{
//			System.out.println(criteria2Record.getYearTable2421());
			Table table2421 = new Table(criteria2Record.getYearTable2421().size() , 2);

			table2421.setPadding(5);
			table2421.setWidth(100f);
			
			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
				
				Cell cell02criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421y(),font5));
				cell02criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell02criteria2);
				
				
//				table2421.addCell(criteria2Record.getYearTable2421().get(i).getInput2421y());
			}
		
			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
				Cell cell03criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421v(),font5));
				cell03criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell03criteria2);
				
				
			}

	//		document.add(table2421);

		}

		PdfPTable table21 = new PdfPTable(2);

		table21.setWidthPercentage(100f);
		table21.setWidths(new int[] { 3, 3 });
		table21.setSpacingBefore(15);
		table21.setSpacingAfter(15);

		PdfPCell cell61 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell61);

		PdfPCell cell62 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell62);

		PdfPCell cell63 = new PdfPCell(new Paragraph("List of Teachers including their PAN, designation,\r\n"
				+ "dept and experience details(Data Template)\r\n\r\n",font5));
		cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell63);

		PdfPCell cell64 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell64.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell64);

		PdfPCell cell65 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell65.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell65);

		PdfPCell cell66 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell66);

		document.add(table21);
		
		
		////////////
		

		PdfPTable table2221 = new PdfPTable(2);

		table2221.setWidthPercentage(100f);
		table2221.setWidths(new int[] { 3, 3 });
		table2221.setSpacingBefore(15);
		table2221.setSpacingAfter(15);
		
		PdfPCell cell46110110 = new PdfPCell(
				new Paragraph(
				"Average teaching experience of full time teachers in the same \r\n"
				+ "institution (Data to be provided only for the latest completed \r\n"
				+ "academic year, in number of years)"
				+ ""
				+ ""
				+ "",font4));
		
		table2221.addCell(cell46110110);
	
	
		

		PdfPCell cell460110001 = new PdfPCell(
				new Paragraph(
				"2.4.4.1: Total teaching experience of full time teachers in the same \r\n"
				+ "institution  "
				+ (criteria2Record != null
				? criteria2Record.getCriteria24Qn().get(0).getResponse241()
				: ""),font4));		
			
	
		table2221.addCell(cell460110001);

		
		//////////////
		
		
		
		
		
		
		
		
		
		
		
		
		

		///////////// cr2.5

		Paragraph paragraph7criteria2 = new Paragraph("2.5	Evaluation Process and Reforms\r\n\r\n", font2);

		paragraph7criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph7criteria2);

		PdfPTable table22 = new PdfPTable(1);
		table22.setWidthPercentage(100f);

		PdfPCell cell6611 = new PdfPCell(
				new Paragraph(
				"2.5.1 Number of days from the date of last semester-end/ year- end  examination till the last date of declaration of results year wise during \r\n"
				+ "the last five years \r\n"
				+ "last five years"
						+ "\r\n\r\n" ,font4));
		table22.addCell(cell6611);
		
		PdfPCell cell661101 = new PdfPCell(
				new Paragraph(
				"2.5.1.1 Average number of days from the date of last semester-end/ yearend examination till the last date of declaration of results during the \r\n"
				+ "last five years"
						+ "\r\n\r\n" ,font4));
		table22.addCell(cell661101);
		
		
		
		

		if (criteria2Record.getCriteria25Qn() != null) {
			PdfPCell cell66110 = new PdfPCell(
					new Paragraph( "Response:"+
					(criteria2Record != null ? criteria2Record.getCriteria25Qn().get(0).getResponse251() : ""),font5));
					table22.addCell(cell66110);
		}
		document.add(table22);

		PdfPTable table24 = new PdfPTable(2);

		table24.setWidthPercentage(100f);
		table24.setWidths(new int[] { 3, 3 });
		table24.setSpacingBefore(15);
		table24.setSpacingBefore(15);

		PdfPCell cell69criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell69criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table24.addCell(cell69criteria2);

		PdfPCell cell70criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell70criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table24.addCell(cell70criteria2);

		PdfPCell cell71criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell71criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table24.addCell(cell71criteria2);

		PdfPCell cell72criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell72criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table24.addCell(cell72criteria2);

		PdfPCell cell73criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n",font5));
		cell73criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table24.addCell(cell73criteria2);

		PdfPCell cell74criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell74criteria2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		table24.addCell(cell74criteria2);

		document.add(table24);
		
		
		///2.5.2
		PdfPTable table221 = new PdfPTable(1);
		table221.setWidthPercentage(100f);

		PdfPCell cell66111 = new PdfPCell(
				new Paragraph(
				"2.5.2 Percentage of student complaints/grievances about evaluation \r\n"
				+ "against total number appeared in the examinations during the last \r\n"
				+ "five years"
						+ "\r\n\r\n" ,font4));
		table221.addCell(cell66111);
		
		PdfPCell cell6611011 = new PdfPCell(
				new Paragraph(
				"2.5.2.1: Number of complaints/grievances about evaluation year wise \r\n"
				+ "during last five years"
						+ "\r\n\r\n" ,font4));
		table221.addCell(cell6611011);
		
		
		if (criteria2Record.getYearTable2521() != null)

		{
//			System.out.println(criteria2Record.getYearTable2421());
			Table table2421 = new Table(criteria2Record.getYearTable2521().size() , 2);

			table2421.setPadding(5);
			table2421.setWidth(100f);
			
			for (int i = 0; i < criteria2Record.getYearTable2521().size(); i++) {
				
				Cell cell02criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2521().get(i).getInput2521y(),font5));
				cell02criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell02criteria2);
				
				
//				table2421.addCell(criteria2Record.getYearTable2421().get(i).getInput2421y());
			}
		
			for (int i = 0; i < criteria2Record.getYearTable2521().size(); i++) {
				Cell cell03criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable2521().get(i).getInput2521v(),font5));
				cell03criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell03criteria2);
				
				
			}

	document.add(table2421);

		}
		
		
		PdfPCell cell66110111 = new PdfPCell(
				new Paragraph(
				"2.5.2.2: Number of students appeared in the examination conducted \r\n"
				+ "by the institution year wise during the last five years"
						+ "\r\n\r\n" ,font4));
		table221.addCell(cell66110111);
		
		document.add(table221);
		
		
		
		if (criteria2Record.getYearTable25212() != null)

		{
//			System.out.println(criteria2Record.getYearTable2421());
			Table table2421 = new Table(criteria2Record.getYearTable25212().size() , 2);

			table2421.setPadding(5);
			table2421.setWidth(100f);
			
			for (int i = 0; i < criteria2Record.getYearTable25212().size(); i++) {
				
				Cell cell02criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable25212().get(i).getInput25212y(),font5));
				cell02criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell02criteria2);
				
				
//				table2421.addCell(criteria2Record.getYearTable2421().get(i).getInput2421y());
			}
		
			for (int i = 0; i < criteria2Record.getYearTable25212().size(); i++) {
				Cell cell03criteria2 = new Cell(new Paragraph(criteria2Record.getYearTable25212().get(i).getInput25212v(),font5));
				cell03criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell03criteria2);
				
				
			}

	document.add(table2421);

		}
		
	//	2.5.3
		
		PdfPTable table2211 = new PdfPTable(1);
		table2211.setWidthPercentage(100f);

		PdfPCell cell661111 = new PdfPCell(
				new Paragraph(
				"\r\n"
				+ "IT integration and reforms in the examination procedures and \r\n"
				+ "processes including Continuous Internal Assessment \r\n"
				+ "(CIA)/Formative Assessment have brought in considerable \r\n"
				+ "improvement in Examination Management System (EMS) of the \r\n"
				+ "Institution"
				+ (criteria2Record != null
				? criteria2Record.getCriteria25Qn().get(0).getResponse251()
				: ""),font4));		
			
		table2211.addCell(cell661111);
		

		
		document.add(table2211);
		

		/////// cr2.6

		Paragraph paragraph8criteria2 = new Paragraph("2.6 Student Performance and Learning Outcome\r\r",
				font2);

		paragraph8criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph8criteria2);

		PdfPTable table27 = new PdfPTable(1);
		table27.setWidthPercentage(100f);

		PdfPCell cell740criteria2 = new PdfPCell(
				new Paragraph(
				"2.6.1 The institution has stated learning outcomes (programme and \r\n"
				+ "course outcome)/graduate attributes which are integrated into the \r\n"
				+ "assessment process and widely publicized through the website and \r\n"
				+ "other documents and the attainment of the same are evaluated by \r\n"
				+ "the institution"
						+ "\r\n\r\n"  ,font4));
		table27.addCell(cell740criteria2);
		
		
	
		if (criteria2Record.getCriteria26Ql() != null) {
			PdfPCell cell7400criteria2 = new PdfPCell(
					new Paragraph("Response:"+
					criteria2Record != null ? criteria2Record.getCriteria26Ql().get(0).getResponse261() : "",font5));

					table27.addCell(cell7400criteria2);
		}
		
		document.add(table27);


		PdfPTable table28 = new PdfPTable(2);
		table28.setWidthPercentage(100f);
		table28.setWidths(new int[] { 3, 3 });
		table28.setSpacingBefore(20f);
		table28.setSpacingAfter(20f);

		PdfPCell cell79criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell79criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell79criteria2);

		PdfPCell cell80criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell80criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell80criteria2);

		PdfPCell cell81criteria2 = new PdfPCell(
				new Paragraph("Upload COs for all courses (exemplars from Glossary)\r\n\r\n",font5));
		cell81criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell81criteria2);

		PdfPCell cell82criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell82criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell82criteria2);

		PdfPCell cell83criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n",font5));
		cell83criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell83criteria2);

		PdfPCell cell84criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell84criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell84criteria2);

		PdfPCell cell830criteria2 = new PdfPCell(
				new Paragraph("Upload COs for all courses (exemplars from Glossary)\r\n\r\n",font5));
		cell830criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell830criteria2);

		PdfPCell cell840criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		
		cell840criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell840criteria2);

		document.add(table28);

		PdfPTable table31criteria2 = new PdfPTable(1);
		table31criteria2.setWidthPercentage(100f);
		table31criteria2.setSpacingBefore(20);
		table31criteria2.setSpacingAfter(20);
		

		PdfPCell cell8405criteria2 = new PdfPCell(
				new Paragraph(
				"2.6.2 Pass percentage of students (excluding backlog students) (Data for \r\n"
				+ "the latest completed academic year)"
						,font4));

		table31criteria2.addCell(cell8405criteria2);

		if (criteria2Record.getCriteria26Ql() != null) {
			PdfPCell cell8404criteria2 = new PdfPCell(
					new Paragraph("Response:"+
					criteria2Record != null ? criteria2Record.getCriteria26Ql().get(0).getResponse262() : ""+"\r\n\r\n",font4));
			
			table31criteria2.addCell(cell8404criteria2);
		}

		PdfPCell cell8403criteria2 = new PdfPCell(
				new Paragraph(
				"2.6.2.1: Total number of final year students who passed the \r\n"
				+ "examination conducted by Institution during the latest completed \r\n"
				+ "academic year: \r\n\r\n",font4));
		table31criteria2.addCell(cell8403criteria2);
		
		if (criteria2Record.getCriteria26Ql() != null) {
			PdfPCell cell8402criteria2 = new PdfPCell(
					new Paragraph("Response"+
					criteria2Record != null ? criteria2Record.getCriteria26Ql().get(0).getInput262t1() : ""+"\r\n\r\n",font5));
			table31criteria2.addCell(cell8402criteria2);
		}

	
		PdfPCell cell8401criteria2 = new PdfPCell(
				new Paragraph("Response"+
				"2.6.2.2: Total number of final year students who appeared for the \r\n"
				+ "examination during the latest completed academic year:\r\n\r\n",font4));
		table31criteria2.addCell(cell8401criteria2);
		
		
		if (criteria2Record.getCriteria26Ql() != null) {
			PdfPCell cell8400criteria2 = new PdfPCell(
					new Paragraph(
					criteria2Record != null ? criteria2Record.getCriteria26Ql().get(0).getInput262t1() : "",font5));
			table31criteria2.addCell(cell8400criteria2);
		}

		document.add(table31criteria2);

		PdfPTable table32 = new PdfPTable(2);

		table32.setWidthPercentage(100f);
		table32.setWidths(new int[] { 3, 3 });
		table32.setSpacingBefore(5);

		PdfPCell cell89criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell89criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell89criteria2);

		PdfPCell cell90criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell90criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell90criteria2);

		PdfPCell cell91criteria2 = new PdfPCell(new Paragraph(
				"Upload List of Programmes and number of students passed and appeared in the final year examination(Data Template)\r\n\r\n",font5));
		cell91criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell91criteria2);

		PdfPCell cell92criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell92criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell92criteria2);

		PdfPCell cell93criteria2 = new PdfPCell(new Paragraph("Upload any  the annual report\r\n\r\n",font5));
		cell93criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell93criteria2);

		PdfPCell cell94criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell94criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell94criteria2);
		PdfPCell cell930criteria2 = new PdfPCell(new Paragraph("Paste link for annual report\r\n\r\n",font5));
		cell930criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell930criteria2);

		PdfPCell cell940criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell940criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell940criteria2);
		document.add(table32);

		///////////// cr2.7

		Paragraph paragraph9criteria2 = new Paragraph("2.7 Student Satisfaction Survey\r\n\r\n", font2);

		paragraph9criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph9criteria2);

	
		PdfPTable table34 = new PdfPTable(2);
		PdfPTable table341 = new PdfPTable(1);

		table34.setWidthPercentage(100f);
		table341.setWidthPercentage(100f);
		
		table34.setWidths(new int[] { 3, 3 });
		table341.setSpacingBefore(20f);
		table341.setSpacingAfter(20f);

		PdfPCell cell95criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell95criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell95criteria2);

		PdfPCell cell96criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell96criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell96criteria2);

		PdfPCell cell97criteria2 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
		cell97criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell97criteria2);

		PdfPCell cell98criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
		cell98criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell98criteria2);

		PdfPCell cell97criteria21 = new PdfPCell(
				new Paragraph("Upload database of all currently enrolled students\r\n\r\n",font5));
		cell97criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell97criteria21);

		PdfPCell cell98criteria21 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""+"\r\n\r\n",font5));
		cell98criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell98criteria21);
		
		
		PdfPCell cell980criteria21 = new PdfPCell(
				new Paragraph(
				"2.7.1: Online student satisfaction survey regarding the teaching learning \r\n"
				+ "process.\r\n"
				+ "(Online survey will be conducted)\r\n\r\n"
				+ (criteria2Record != null
				? criteria2Record.getCriteria27Ql().get(0).getResponse271()
				: ""),font4));		
			
		
	
		table341.addCell(cell980criteria21);

		document.add(table341);
		document.add(table34);
		}

	public void Criteria3(Document document, Criteria3_FieldInfo criteria3Fieldinfo) {
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
				new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
		cell4criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell5criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell5criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell6criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell6criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell7criteria3 = new PdfPCell(
				new Paragraph("URL of Policy document on promotion of research uploaded on website\r\n\r\n",font5));
		cell7criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell8criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
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
// 	table13criteria31.addCell(table1criteria3);

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
				new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "",font5));
		cell24criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell25criteria3 = new PdfPCell(
				new Paragraph("List of teachers receiving grant and details of grant received\r\n\r\n",font5));
		cell25criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell26criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "",font5));
		cell26criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell27criteria3 = new PdfPCell(new Paragraph(
				"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n",font5));
		cell27criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell28criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "",font5));
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
//		PdfPTable table3criteria3 = new PdfPTable(2);
//		PdfPTable table33criteria31 = new PdfPTable(1);
//
//		table3criteria3.setWidthPercentage(100f);
//		table33criteria31.setWidthPercentage(100f);
//
//		PdfPCell cell31criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
//		cell31criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell32criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
//		cell32criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell33criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
//		cell33criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell34criteria3 = new PdfPCell(
//				new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "",font5));
//		cell34criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//		PdfPCell cell35criteria3 = new PdfPCell(new Paragraph("Minutes of the relevant bodies of the Institution\r\n\r\n",font5));
//		cell35criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell36criteria3 = new PdfPCell(
//				new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "",font5));
//		cell36criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell33criteria31 = new PdfPCell(new Paragraph(
//				"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n",font5));
//		cell33criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell34criteria31 = new PdfPCell(
//				new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "",font5));
//		cell34criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//		PdfPCell cell35criteria31 = new PdfPCell(
//				new Paragraph("List of teachers receiving grant and details of grant received (Data Template)\r\n\r\n",font5));
//		cell35criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//		PdfPCell cell36criteria31 = new PdfPCell(
//				new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "",font5));
//		cell36criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table3criteria3.addCell(cell31criteria3);
//		table3criteria3.addCell(cell32criteria3);
//		table3criteria3.addCell(cell33criteria3);
//		table3criteria3.addCell(cell34criteria3);
//		table3criteria3.addCell(cell35criteria3);
//		table3criteria3.addCell(cell36criteria3);
//		table3criteria3.addCell(cell33criteria31);
//		table3criteria3.addCell(cell34criteria31);
//		table3criteria3.addCell(cell35criteria31);
//		table3criteria3.addCell(cell36criteria31);
//
////		table33criteria31.addCell(cell313criteria3);
////		table33criteria31.addCell(cell3131criteria3);
//		table33criteria31.addCell(table3criteria3);
//		// document.add(cell313criteria3);
//		// document.add(cell3131criteria3);
//		table33criteria31.setSpacingBefore(20f);
//		table33criteria31.setSpacingAfter(20f);

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
				new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "",font5));
		cell34criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell35criteria3 = new PdfPCell(new Paragraph("e-copies of the award letters of the teachers\r\n\r\n",font5));
		cell35criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell36criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "",font5));
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
//		Paragraph paragraph2criteria3112 = new Paragraph(
//				"3.1.4: Number of JRFs, SRFs, Post Doctoral Fellows, Research Associates and other research fellows enrolled in the institution during the last five years");
//
//		document.add(paragraph2criteria3112);
//
//		Paragraph paragraph2criteria3113 = new Paragraph(
//				criteria3Record != null ? criteria3Record.getCriteria31Qn().get(0).getResponse314() : "");
//		document.add(paragraph2criteria3113);
//		Paragraph paragraph2criteria3114 = new Paragraph(
//				"3.1.4.1: The Number of JRFs, SRFs, Post Doctoral Fellows, Research Associates and other research fellows enrolled in the institution year-wise during the last five years.");
//		document.add(paragraph2criteria3114);

//		if (criteria3Record.getYearTable3131() != null) {
//			Table table3131criteria3 = new Table(criteria3Record.getYearTable3131().size(), 2);
//
//			table3131criteria3.setPadding(10);
//			table3131criteria3.setWidth(100f);
//
//			for (int i = 0; i < criteria3Record.getYearTable3131().size(); i++) {
//				table3131criteria3.addCell(criteria3Record.getYearTable3131().get(i).getInput3131y());
//
//			}
//			for (int i = 0; i < criteria3Record.getYearTable3131().size(); i++) {
//				table3131criteria3.addCell(criteria3Record.getYearTable3131().get(i).getInput3131v());
//
//			}
//
//			document.add(table3131criteria3);
//		}

//		PdfPTable table3criteria311 = new PdfPTable(2);
//		PdfPTable table33criteria3111 = new PdfPTable(1);
//
//		table3criteria311.setWidthPercentage(100f);
//		table33criteria3111.setWidthPercentage(100f);
//
//		PdfPCell cell31criteria31 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//		cell31criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		PdfPCell cell31criteria311 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//		cell31criteria311.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell33criteria310 = new PdfPCell(new Paragraph("Any additional information\r\n"));
//		cell33criteria310.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell34criteria310 = new PdfPCell(
//				new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : ""));
//		cell34criteria310.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell35criteria310 = new PdfPCell(
//				new Paragraph("Provide a list of research fellows and their fellowship details (Data Template)"));
//		cell35criteria310.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell36criteria310 = new PdfPCell(
//				new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : ""));
//		cell36criteria310.setHorizontalAlignment(Element.ALIGN_CENTER);
//		table3criteria311.addCell(cell31criteria31);
//		table3criteria311.addCell(cell31criteria311);
//		table3criteria311.addCell(cell33criteria310);
//		table3criteria311.addCell(cell34criteria310);
//		table3criteria311.addCell(cell35criteria310);
//		table3criteria311.addCell(cell36criteria310);
//
////table33criteria31.addCell(cell313criteria3);
////table33criteria31.addCell(cell3131criteria3);
//		table33criteria3111.addCell(table3criteria311);
////document.add(cell313criteria3);
////document.add(cell3131criteria3);
//		table33criteria3111.setSpacingBefore(20f);
//		table33criteria3111.setSpacingAfter(20f);
//		document.add(table33criteria3111);
//
//		Paragraph paragraph2criteria31123 = new Paragraph(
//				"3.1.5: Institution has the following facilities to support research:\r\n"
//						+ "1. Central Instrumentation Centre\r\n" + "2. Animal House/Green House\r\n"
//						+ "3. Museum\r\n" + "5. Business Lab\r\n" + "6. Research/Statistical Databases\r\n"
//						+ "7. Mootcourt\r\n" + "8. Theatre\r\n" + "9. Art Gallery\r\n"
//						+ "10. Any other facility to support research.\r\n" + "\r\n");
//		document.add(paragraph2criteria31123);
//		Paragraph paragraph2criteria31124 = new Paragraph(
//				criteria3Record != null ? criteria3Record.getCriteria31Qn().get(0).getResponse315() : "");
//		document.add(paragraph2criteria31124);
//
//		PdfPTable table3criteria3110 = new PdfPTable(2);
//		PdfPTable table33criteria31110 = new PdfPTable(1);
//
//		table3criteria3110.setWidthPercentage(100f);
//		table33criteria31110.setWidthPercentage(100f);
//
//		PdfPCell cell31criteria310 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//		cell31criteria310.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell31criteria3110 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//		cell31criteria3110.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		PdfPCell cell33criteria3100 = new PdfPCell(
//				new Paragraph("Provide the link of videos and geo-tagged photographs\r\n"));
//		cell33criteria3100.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell34criteria3100 = new PdfPCell(
//				new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : ""));
//		cell34criteria3100.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell35criteria3100 = new PdfPCell(new Paragraph(
//				"Upload the list of facilities provided by the university and their year/s of establishment"));
//		cell35criteria3100.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell36criteria3100 = new PdfPCell(
//				new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : ""));
//		cell36criteria3100.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		PdfPCell cell35criteria31000 = new PdfPCell(new Paragraph("Upload any additional information"));
//		cell35criteria31000.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell36criteria31000 = new PdfPCell(
//				new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : ""));
//		cell36criteria31000.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//		table33criteria31110.addCell(cell31criteria310);
//		table33criteria31110.addCell(cell31criteria3110);
//		table33criteria31110.addCell(cell33criteria3100);
//		table33criteria31110.addCell(cell34criteria3100);
//		table33criteria31110.addCell(cell35criteria3100);
//		table33criteria31110.addCell(cell36criteria3100);
//		table33criteria31110.addCell(cell35criteria31000);
//		table33criteria31110.addCell(cell36criteria31000);
//
////table33criteria31.addCell(cell313criteria3);
////table33criteria31.addCell(cell3131criteria3);
//		table3criteria3110.addCell(table33criteria31110);
////document.add(cell313criteria3);
////document.add(cell3131criteria3);
//		table3criteria3110.setSpacingBefore(20f);
//		table3criteria3110.setSpacingAfter(20f);
//		document.add(table3criteria3110);
//
//		Paragraph paragraph2criteria3116 = new Paragraph(
//				"3.1.6: Percentage of departments with UGC-SAP, CAS, DST-FIST, DBT, ICSSR and other recognitions by national and international agencies (Data for the latest completed academic year)");
//		document.add(paragraph2criteria3116);
//		Paragraph paragraph2criteria31161 = new Paragraph(
//				criteria3Record != null ? criteria3Record.getCriteria31Qn().get(0).getResponse316() : "");
//		document.add(paragraph2criteria31161);
//		Paragraph paragraph2criteria31162 = new Paragraph(
//				"3.1.6.1: The Number of departments with UGC-SAP, CAS, DST-FIST , DBT, ICSSR and other similar recognitions by national and international agencies");
//		document.add(paragraph2criteria31162);
//
//		Paragraph paragraph2criteria31163 = new Paragraph(
//				criteria3Record != null ? criteria3Record.getCriteria31Qn().get(0).getInput3161t1() : "");
//		document.add(paragraph2criteria31163);
//		Paragraph paragraph2criteria31164 = new Paragraph(
//				"3.1.6.1: Total number of departments offering academic programmes");
//		document.add(paragraph2criteria31164);
//		Paragraph paragraph2criteria31165 = new Paragraph(
//				criteria3Record != null ? criteria3Record.getCriteria31Qn().get(0).getInput3162t1() : "");
//		document.add(paragraph2criteria31165);
//
//		PdfPTable table3criteria31106 = new PdfPTable(2);
//		PdfPTable table33criteria311106 = new PdfPTable(1);
//
//		table3criteria31106.setWidthPercentage(100f);
//		table33criteria311106.setWidthPercentage(100f);
//
//		PdfPCell cell31criteria3106 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font2));
//		cell31criteria3106.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell31criteria31106 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font2));
//		cell31criteria31106.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell33criteria31006 = new PdfPCell(new Paragraph("Upload any additional information\r\n"));
//		cell33criteria31006.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell34criteria31006 = new PdfPCell(
//				new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : ""));
//		cell34criteria31006.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//		table33criteria311106.addCell(cell31criteria3106);
//		table33criteria311106.addCell(cell31criteria31106);
//		table33criteria311106.addCell(cell33criteria31006);
//		table33criteria311106.addCell(cell34criteria31006);
//		table3criteria31106.addCell(table33criteria311106);
//		table3criteria31106.setSpacingBefore(20f);
//		table3criteria31106.setSpacingAfter(20f);
//		document.add(table3criteria31106);

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
				new Paragraph(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : "",font5));
		cell44criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell45criteria3 = new PdfPCell(new Paragraph(
				"e-copies of the grant award letters for research projects sponsored by government and non- government\r\n\r\n",font5));
		cell45criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell46criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : "",font5));
		cell46criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell47criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell47criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell48criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(9).getCriteria3FilePath() : "",font5));
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

//		table43criteria31.addCell(table4criteria3);

		table43criteria31.setSpacingBefore(20f);
		table43criteria31.setSpacingAfter(20f);

		document.add(table43criteria31);
		document.add(table4criteria3);
//create table 3211/////

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

//create table 5 //////
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
				new Paragraph(criteria3Record != null ? criteria3file.get(10).getCriteria3FilePath() : "",font5));
		cell54criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell55criteria3 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n",font5));
		cell55criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell56criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(10).getCriteria3FilePath() : "",font5));
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
//		table5criteria3.addCell(cell322criteria3);
		PdfPCell cell3221criteria3 = new PdfPCell(new Paragraph(
				"3.2.2.1: Number of teachers having research projects during the last \r\n"
				+ "five years\r\n\r\n"
				,font4));
		
		
//table53criteria31.addCell(cell322criteria3);

//table53criteria31.addCell(cell3221criteria3);

		table53criteria31.addCell(cell322criteria3);
		table53criteria31.addCell(cell3221criteria3);
		
//document.add(cell322criteria3);
//document.add(cell3221criteria3);
//table53criteria31.setSpacingBefore(20f);
//table53criteria31.setSpacingAfter(20f);

		document.add(table53criteria31);
		document.add(table5criteria3);
//create table 3221 //////

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

//create table 6////
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
				new Paragraph(criteria3Record != null ? criteria3file.get(11).getCriteria3FilePath() : "",font5));
		cell64criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell65criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell65criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell66criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(12).getCriteria3FilePath() : "",font5));
		cell66criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell67criteria3 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n",font5));
		cell67criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell68criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(12).getCriteria3FilePath() : "",font5));
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
//		table63criteria31.addCell(table6criteria3);

//document.add(cell323criteria3);
//document.add(cell3231criteria3);
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
				new Paragraph(criteria3Record != null ? criteria3file.get(13).getCriteria3FilePath() : "",font5));
		cell74criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell75criteria3 = new PdfPCell(
				new Paragraph("List of research projects and funding details\r\n\r\n",font5));
		cell75criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell76criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(14).getCriteria3FilePath() : "",font5));
		cell76criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell77criteria3 = new PdfPCell(new Paragraph("Paste link to funding agency website\r\n\r\n",font5));
		cell77criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell78criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(14).getCriteria3FilePath() : "",font5));
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

//		PdfPCell cell3242criteria3 = new PdfPCell(new Paragraph(
//				"3.2.4.1 Number of departments having Research projects funded by government and non- government agencies during the last five years\r\n"
//						+ "\r\n\r\n",
//				font5));

//table73criteria31.addCell(cell324criteria3);
	//	table73criteria31.addCell(cell3241criteria3);
//		table73criteria31.addCell(cell3242criteria3);

//		table73criteria31.addCell(table7criteria3);
		
		
//document.add(cell324criteria3);
//document.add(cell3241criteria3);
//document.add(cell3242criteria3);
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
//		table81criteria31.addCell(table8criteria3);

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
//		table91criteria31.addCell(table9criteria3);

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
//create table 10 ///
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
				new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
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
//		table101criteria31.addCell(table10criteria3);
//document.add(cell341criteria3);
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
				new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
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
//		table111criteria31.addCell(table11criteria3);

//document.add(cell3421criteria3);
//document.add(cell3422criteria3);
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
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
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
//		table123criteria31.addCell(table12criteria3);

//document.add(cell343criteria3);
//document.add(cell3431criteria3);
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
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell134criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell135criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell135criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell136criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
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

//		document.add(cell344criteria3);
//		document.add(cell3441criteria3);
		table131criteria31.setSpacingBefore(20f);
		table131criteria31.setSpacingAfter(20f);

		document.add(table131criteria31);
		document.add(table13criteria3);
//create table 3441 //

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

//create table 14 //
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
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
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
		
		
		
		
		
//		table141criteria31.addCell(table14criteria3);
		table141criteria31.setSpacingBefore(20f);
		table141criteria31.setSpacingAfter(20f);
		document.add(table141criteria31);
		document.add(table14criteria3);
		
		
		
//create table 15 //
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
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
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
//		table153criteria31.addCell(table15criteria3);

//document.add(cell346criteria3);
		table153criteria31.setSpacingBefore(20f);
		table153criteria31.setSpacingAfter(20f);
		document.add(table153criteria31);
		document.add(table15criteria3);

/////////////////////cr3.5

		Paragraph paragraph6criteria3 = new Paragraph("3.5	Consultancy\r\n\r\n", font2);
		paragraph6criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph6criteria3);
//create table 16 //
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
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell164criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell165criteria3 = new PdfPCell(new Paragraph(
				"Audited statements of accounts indicating the revenue generated through consultancy and corporate training\r\n\r\n",font5));
		cell165criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell166criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell166criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell167criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell167criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell168criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
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
//		table161criteria31.addCell(table16criteria3);

//document.add(cell351criteria3);
//document.add(cell3511criteria3);
		table16criteria3.setSpacingBefore(20f);
		table16criteria3.setSpacingAfter(20f);
		document.add(table161criteria31);
		document.add(table16criteria3);
//create table 3511 ///

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

//create table 17 ///

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
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell174criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell175criteria3 = new PdfPCell(
				new Paragraph("List of facilities and staff available for undertaking consultancy\r\n\r\n",font5));
		cell175criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell176criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell176criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell177criteria3 = new PdfPCell(new Paragraph(
				"Audited statements of accounts indicating the expenditure incurred on developing facilities and training teachers and staff for undertaking consultancy\r\r\n",font5));
		cell177criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell178criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell178criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell179criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell179criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell180criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
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
								: ""),
						font4));
		PdfPCell cell3521criteria3 = new PdfPCell(new Paragraph(
				"3.5.2.1 Total amount spent on developing facilities, training teachers and staff for undertaking consultancy during the last five years (INR in Lakhs)\r\n"
						+ "\r\n\r\n",
						font4));
	//	table173criteria31.addCell(cell352criteria3);
	//	table173criteria31.addCell(cell3521criteria3);
//		table173criteria31.addCell(table17criteria3);
//document.add(cell352criteria3);
//document.add(cell3521criteria3);
		table173criteria31.setSpacingBefore(20f);
		table173criteria31.setSpacingAfter(20f);

		document.add(table173criteria31);
		document.add(table17criteria3);
		
//create table 3521//

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
//create table 18 //
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
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
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
//		table183criteria3.addCell(table18criteria3);
//document.add(cell361criteria3);
//		table183criteria3.setSpacingBefore(20f);
		table183criteria3.setSpacingAfter(20f);
		document.add(table183criteria3);
		document.add(table18criteria3);

//create table 19 //
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
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell194criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell195criteria3 = new PdfPCell(new Paragraph("e-copy of the award letters\r\n\r\n",font5));
		cell195criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell196criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell196criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell197criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell197criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell198criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
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
								: ""),
						font4));
		PdfPCell cell3621criteria3 = new PdfPCell(new Paragraph(
				"3.6.2.1: Number of extension and outreach programs conducted by the \r\n"
				+ "institution through organized forums including NSS/NCC with \r\n"
				+ "involvement of community during the last five years..\r\n\r\n"
						,font4));

		table191criteria3.addCell(cell362criteria3);
		table191criteria3.addCell(cell3621criteria3);
//document.add(cell362criteria3);
//document.add(cell3621criteria3);
		table191criteria3.setSpacingBefore(20f);
		table191criteria3.setSpacingAfter(20f);
		document.add(table191criteria3);

//create table 3621 //

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

//create table 20 //
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
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell204criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell205criteria3 = new PdfPCell(new Paragraph(
				"Number of extension and outreach Programmes conducted with industry, community etc for the last five years\r\n\r\n",font5));
		cell205criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell206criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
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
//		table201criteria31.addCell(table20criteria3);
//document.add(cell363criteria3);
//document.add(cell3631criteria3);
		table201criteria31.setSpacingBefore(20f);
		table201criteria31.setSpacingAfter(20f);
		document.add(table201criteria31);
		document.add(table20criteria3);
//create table 3631 //

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

//create a table 21 //
	
		
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
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell214criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell215criteria3 = new PdfPCell(new Paragraph(
				"Average percentage of students participating in extension activities with Govt or NGO etc\r\n\r\n",font5));
		cell215criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell216criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell216criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21criteria3.addCell(cell211criteria3);
		table21criteria3.addCell(cell212criteria3);
		table21criteria3.addCell(cell213criteria3);
		table21criteria3.addCell(cell214criteria3);
		table21criteria3.addCell(cell215criteria3);
		table21criteria3.addCell(cell216criteria3);
//PdfPCell cell364criteria3 = new PdfPCell(new Paragraph(
//	"3.6.4 Average percentage of students participating in extension activities listed at 3.6.3 above during the last five years\r\n"
//			+ "\r\n\r\n\r\n" + "Response:"
//			+ (criteria3Fieldinfo != null
//					? criteria3Fieldinfo.getCriteria3FieldInfoQn().get(0).getResponse364()
//					: "")));
		PdfPCell cell3641criteria3 = new PdfPCell(new Paragraph(
				"3.6.4.1 Total number of students participating in extension activities listed at 3.6.3 above year-wise during the last five years.\r\n\r\n"
						,font4));
//table211criteria3.addCell(cell364criteria3);
//		table211criteria3.addCell(cell3641criteria3);
//		table211criteria3.addCell(table21criteria3);
//document.add(cell364criteria3);
//document.add(cell3641criteria3);
		table211criteria3.setSpacingBefore(20f);
		table211criteria3.setSpacingAfter(20f);
		document.add(table211criteria3);
		document.add(table21criteria3);
//create table 3641 //

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
						: ""),font4));
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
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell214criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell215criteria31 = new PdfPCell(new Paragraph(
				"List and Copies of documents indicating the functional \r\n"
				+ "MoUs/linkage/collaborations activity-wise and year-wise\r\n\r\n",font5));
		cell215criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell216criteria31 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell216criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell213criteria3001 = new PdfPCell(new Paragraph("Summary of the functional MoUs/linkage/collaboration indicating \r\n"
				+ "start date, end date, nature of collaboration etc.\r\n\r\n",font5));
		cell213criteria3001.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell214criteria3001 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell214criteria3001.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell215criteria3001 = new PdfPCell(new Paragraph(
				"List of year wise activities and exchange should be provided",font5));
		cell215criteria3001.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell216criteria3001 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell216criteria3001.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		
		table21criteria31.addCell(cell211criteria31);
		table21criteria31.addCell(cell212criteria31);
		table21criteria31.addCell(cell213criteria31);
		table21criteria31.addCell(cell214criteria31);
		table21criteria31.addCell(cell215criteria31);
		table21criteria31.addCell(cell216criteria31);
		
		
		
		document.add(table21criteria31);
		
		}

////////////////////////////////////////////////////////////////4.1/////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	//////////////////////////////////////// 4.1///////////

	public void Criteria4(Document document, Criteria4_FieldInfo criteria4Fieldinfo) {
		Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources", font1);
		paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph1criteria4);

		Paragraph paragraph1linecriteria4 = new Paragraph("___________________________________________________________________________");
		paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph1linecriteria4);


	

		Paragraph paragraph2criteria4 = new Paragraph("4.1 Physical Facilities \r\n\r\n", font2);
		paragraph2criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph2criteria4);

	

//		Paragraph paragraph4criteria4 = new Paragraph("Response:", font3);

		PdfPTable table411criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table411criteria4.setWidthPercentage(100);

		



		table411criteria4.setSpacingBefore(20f);
		table411criteria4.setSpacingAfter(20f);

	//	paragraph4criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);


		PdfPTable table2 = new PdfPTable(2);
		PdfPTable table21 = new PdfPTable(1);
		table2.setWidthPercentage(100);
		table21.setWidthPercentage(100);
		

		PdfPCell cell001criteria4 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
		cell001criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell001criteria4);
		PdfPCell cell002criteria4 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell002criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell002criteria4);
		PdfPCell cell003criteria4 = new PdfPCell(new Paragraph("Upload Any additional information\r\n\r\n ",font5));
		cell003criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table2.addCell(cell003criteria4);
		
		if(criteria4file.size() > 0)
		{
		PdfPCell cell004criteria4 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell004criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table2.addCell(cell004criteria4);
	}
		PdfPCell cell005criteria4 = new PdfPCell(new Paragraph("paste link for additional information\r\n\r\n",font5));
		cell005criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell006criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell006criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2.addCell(cell005criteria4);
		table2.addCell(cell006criteria4);
		
		if( criteria4Record.getCriteria41Ql()!=null) {
			PdfPCell cell0011criteria4 = new PdfPCell(new Paragraph(
		  "4.1.1 The Institution has adequate infrastructure and other facilities \r\n"
		  + "for \r\n"
		  + "a. teaching – learning, viz., classrooms, laboratories, computing \r\n"
		  + "equipment etc\r\n"
		  + "b. ICT – enabled facilities such as smart class, LMS etc. \r\n"
		  + "c. Facilities for Cultural and sports activities, yoga centre, \r\n"
		  + "games (indoor and outdoor), Gymnasium, auditorium etc."
		  + "\r\n" + "Response: " + (criteria4Record != null ?
		  criteria4Record.getCriteria41Ql().get(0).getResponse411() : "")+"\r\n\r\n",font4));
			table21.addCell(cell0011criteria4);
		
		}
		
		

		table2.setSpacingBefore(20f);
		table2.setSpacingAfter(20f);

		document.add(table21);
		document.add(table2);
//
//		Paragraph paragraph13criteria4 = new Paragraph(
//				"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)",
//				font3);
//		paragraph13criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//
//		Paragraph paragraph24criteria4 = new Paragraph("The open lawns facilitate the following:", font5);
//		paragraph24criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		Paragraph paragraph241 = new Paragraph(" ", font5);
//		paragraph241.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		Chunk bullet1criteria4 = new Chunk("\u2022", font5);
//		paragraph241.add(bullet1criteria4);
//
//		paragraph241.add(new Phrase("College day: VIBGYOR, VIBES\r\n" + "\r\n", font5));
//		paragraph241.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		Paragraph paragraph242 = new Paragraph(" ", font5);
//		paragraph242.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		Chunk bullet2criteria4 = new Chunk("\u2022", font5);
//		paragraph242.add(bullet2criteria4);
//
//		paragraph242.add(new Phrase("Yoga\r\n" + "\r\n", font5));
//
//		paragraph242.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		Paragraph paragraph243 = new Paragraph(" ", font5);
//		paragraph243.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		Chunk bullet3criteria4 = new Chunk("\u2022", font5);
//		paragraph243.add(bullet3criteria4);
//
//		paragraph243.add(new Phrase("Regional and National festivals of importance\r\n", font5));
//
//		paragraph243.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		Paragraph paragraph244 = new Paragraph(" ", font5);
//		paragraph244.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		Chunk bullet4criteria4 = new Chunk("\u2022", font5);
//		paragraph244.add(bullet4criteria4);
//
//		paragraph244.add(new Phrase(" Alumni association meet\r\n", font5));
//
//		paragraph244.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		Paragraph paragraph245 = new Paragraph(" ", font5);
//		paragraph245.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		Chunk bullet5criteria4 = new Chunk("\u2022", font5);
//		paragraph245.add(bullet5criteria4);
//
//		paragraph245.add(new Phrase("Mother Teresa family get together\r\n" + "\r\n", font5));
//
//		paragraph245.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		Paragraph paragraph246 = new Paragraph(" ", font5);
//		paragraph246.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		Chunk bullet6criteria4 = new Chunk("\u2022", font5);
//		paragraph246.add(bullet6criteria4);
//
//		paragraph246.add(new Phrase("Football practice\r\n" + "\r\n", font5));
//
//		paragraph246.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		/*
//		 * Font fontParagraph21 = FontFactory.getFont(FontFactory.HELVETICA);
//		 * fontParagraph21.setSize(12);
//		 */
//
//		Paragraph paragraph25criteria4 = new Paragraph(
//				"Institution allocates one/two-hour time slots in Timetable encouraging students participation in sports thereby inculcating sporting spirit in them and they understand that winning & losing are part of life. Transportation is arranged for students participating in sports and games beyond working hours to reach their homes. It�s the institution�s conviction that holistic development of a student is only possible, when students participate in several cultural, literary and sports activities over and above their academics. Mother Teresates won several laurels in State Under-19 competitions in many sports events in the past few years. ",
//				font5);
//		paragraph25criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		/*
//		 * Font fontParagraph22criteria4 =
//		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		 * fontParagraph22criteria4.setSize(12);
//		 */
//
//		Paragraph paragraph26criteria4 = new Paragraph("Details of the facility created/r/n ", font3);
//		paragraph26criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		document.add(paragraph13criteria4);
////		document.add(paragraph14criteria4);
////		document.add(paragraph15criteria4);
//		document.add(paragraph24criteria4);
//		document.add(paragraph241);
//		document.add(paragraph242);
//		document.add(paragraph243);
//		document.add(paragraph244);
//		document.add(paragraph245);
//		document.add(paragraph246);
//		document.add(paragraph25criteria4);
//		document.add(paragraph26criteria4);
//
//		// Creating a table of columns
//		PdfPTable table3criteria4 = new PdfPTable(4);
//
//		// Setting width of table, its columns and spacing
//		table3criteria4.setWidthPercentage(100);
//
//		PdfPCell cell101criteria4 = new PdfPCell(new Paragraph("Facility", font3));
//		PdfPCell cell102criteria4 = new PdfPCell(new Paragraph("Year of creation", font3));
//		PdfPCell cell103criteria4 = new PdfPCell(new Paragraph("Area in Sqm", font3));
//		PdfPCell cell104criteria4 = new PdfPCell(new Paragraph(" Year facility enhanced", font3));
//		PdfPCell cell105criteria4 = new PdfPCell(new Paragraph("Volleyball "));
//		PdfPCell cell106criteria4 = new PdfPCell(new Paragraph(" 2005"));
//		PdfPCell cell107criteria4 = new PdfPCell(new Paragraph("162	"));
//		PdfPCell cell108criteria4 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell109 = new PdfPCell(new Paragraph("Basketball"));
//		PdfPCell cell1010 = new PdfPCell(new Paragraph("2005"));
//		PdfPCell cell1011 = new PdfPCell(new Paragraph("436  "));
//		PdfPCell cell1012 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell1013 = new PdfPCell(new Paragraph("Throwball "));
//		PdfPCell cell1014 = new PdfPCell(new Paragraph("	2005 "));
//		PdfPCell cell1015 = new PdfPCell(new Paragraph("	222	"));
//		PdfPCell cell1016 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell1017 = new PdfPCell(new Paragraph("Cricket	"));
//		PdfPCell cell1018 = new PdfPCell(new Paragraph("2005 "));
//		PdfPCell cell1019 = new PdfPCell(new Paragraph("3600 "));
//		PdfPCell cell1020 = new PdfPCell(new Paragraph("2016  "));
//		PdfPCell cell1021 = new PdfPCell(new Paragraph("Kabaddi "));
//		PdfPCell cell1022 = new PdfPCell(new Paragraph("	2005"));
//		PdfPCell cell1023 = new PdfPCell(new Paragraph("130"));
//		PdfPCell cell1024 = new PdfPCell(new Paragraph("2020 "));
//		PdfPCell cell1025 = new PdfPCell(new Paragraph("Cricket-net practice"));
//		PdfPCell cell1026 = new PdfPCell(new Paragraph("2020 "));
//		PdfPCell cell1027 = new PdfPCell(new Paragraph("74 "));
//		PdfPCell cell1028 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell1029 = new PdfPCell(new Paragraph("Indoor Sports (Carroms Table-Tennis, Chess etc.)"));
//		PdfPCell cell1030 = new PdfPCell(new Paragraph("2005 "));
//		PdfPCell cell1031 = new PdfPCell(new Paragraph("219"));
//		PdfPCell cell1032 = new PdfPCell(new Paragraph("2020"));
//		PdfPCell cell1033 = new PdfPCell(new Paragraph("Yoga center"));
//		PdfPCell cell1034 = new PdfPCell(new Paragraph("2016 "));
//		PdfPCell cell1035 = new PdfPCell(new Paragraph("89 "));
//		PdfPCell cell1036 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell1037 = new PdfPCell(new Paragraph("Open-air Auditorium	"));
//		PdfPCell cell1038 = new PdfPCell(new Paragraph("2005 "));
//		PdfPCell cell1039 = new PdfPCell(new Paragraph("3310  "));
//		PdfPCell cell1040 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell1041 = new PdfPCell(new Paragraph("Block -1 (II-floor) Air conditioned Seminar Hall)"));
//		PdfPCell cell1042 = new PdfPCell(new Paragraph("	2006 "));
//		PdfPCell cell1043 = new PdfPCell(new Paragraph("263	 "));
//		PdfPCell cell1044 = new PdfPCell(new Paragraph("	2019 (Modernized) "));
//		PdfPCell cell1045 = new PdfPCell(new Paragraph("Auditorium Air-conditioned"));
//		PdfPCell cell1046 = new PdfPCell(new Paragraph("2019 "));
//		PdfPCell cell1047 = new PdfPCell(new Paragraph("287 "));
//		PdfPCell cell1048 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell1049 = new PdfPCell(new Paragraph("Block -3 Seminar Hall "));
//		PdfPCell cell1050 = new PdfPCell(new Paragraph("2018 "));
//		PdfPCell cell1051 = new PdfPCell(new Paragraph("	137"));
//		PdfPCell cell1052 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell1053 = new PdfPCell(new Paragraph("Foot Ball Ground"));
//		PdfPCell cell1054 = new PdfPCell(new Paragraph("2005 "));
//		PdfPCell cell1055 = new PdfPCell(new Paragraph("	4050 "));
//		PdfPCell cell1056 = new PdfPCell(new Paragraph("2020 "));
//
//		table3criteria4.addCell(cell101criteria4);
//		table3criteria4.addCell(cell102criteria4);
//		table3criteria4.addCell(cell103criteria4);
//		table3criteria4.addCell(cell104criteria4);
//		table3criteria4.addCell(cell105criteria4);
//		table3criteria4.addCell(cell106criteria4);
//		table3criteria4.addCell(cell107criteria4);
//		table3criteria4.addCell(cell108criteria4);
//		table3criteria4.addCell(cell109);
//		table3criteria4.addCell(cell1010);
//		table3criteria4.addCell(cell1011);
//		table3criteria4.addCell(cell1012);
//		table3criteria4.addCell(cell1013);
//		table3criteria4.addCell(cell1014);
//		table3criteria4.addCell(cell1015);
//		table3criteria4.addCell(cell1016);
//		table3criteria4.addCell(cell1017);
//		table3criteria4.addCell(cell1018);
//		table3criteria4.addCell(cell1019);
//		table3criteria4.addCell(cell1020);
//		table3criteria4.addCell(cell1021);
//		table3criteria4.addCell(cell1022);
//		table3criteria4.addCell(cell1023);
//		table3criteria4.addCell(cell1024);
//		table3criteria4.addCell(cell1025);
//		table3criteria4.addCell(cell1026);
//		table3criteria4.addCell(cell1027);
//		table3criteria4.addCell(cell1028);
//		table3criteria4.addCell(cell1029);
//		table3criteria4.addCell(cell1030);
//		table3criteria4.addCell(cell1031);
//		table3criteria4.addCell(cell1032);
//		table3criteria4.addCell(cell1033);
//		table3criteria4.addCell(cell1034);
//		table3criteria4.addCell(cell1035);
//		table3criteria4.addCell(cell1036);
//		table3criteria4.addCell(cell1037);
//		table3criteria4.addCell(cell1038);
//		table3criteria4.addCell(cell1039);
//		table3criteria4.addCell(cell1040);
//		table3criteria4.addCell(cell1041);
//		table3criteria4.addCell(cell1042);
//		table3criteria4.addCell(cell1043);
//		table3criteria4.addCell(cell1044);
//		table3criteria4.addCell(cell1045);
//		table3criteria4.addCell(cell1046);
//		table3criteria4.addCell(cell1047);
//		table3criteria4.addCell(cell1048);
//		table3criteria4.addCell(cell1049);
//		table3criteria4.addCell(cell1050);
//		table3criteria4.addCell(cell1051);
//		table3criteria4.addCell(cell1052);
//		table3criteria4.addCell(cell1053);
//		table3criteria4.addCell(cell1054);
//		table3criteria4.addCell(cell1055);
//		table3criteria4.addCell(cell1056);
//
//		table3criteria4.setSpacingBefore(20f);
//		table3criteria4.setSpacingAfter(20f);
//
////		document.add(table3criteria4);

		// Creating a table of 3 columns
		PdfPTable table4criteria4 = new PdfPTable(2);
		PdfPTable table412criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table4criteria4.setWidthPercentage(100);
		table412criteria4.setWidthPercentage(100);

		PdfPCell cell007 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
		cell007.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table4criteria4.addCell(cell007);
		
		PdfPCell cell008 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell008.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4criteria4.addCell(cell008);
		PdfPCell cell0009 = new PdfPCell(new Paragraph(" Upload Any additional information\r\n\r\n", font5));
		cell0009.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4criteria4.addCell(cell0009);
		if(criteria4file.size() >0)
		{
		PdfPCell cell0010 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "", font5));
		cell0010.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4criteria4.addCell(cell0010);
		}
		PdfPCell cell0011 = new PdfPCell(new Paragraph("Geotagged pictures\r\n\r\n", font5));
		cell0011.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4criteria4.addCell(cell0011);
		if(criteria4file.size() >0)
		{
		PdfPCell cell0012 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : "", font5));
		cell0012.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4criteria4.addCell(cell0012);
		}
		PdfPCell cell0013 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n", font5));
		cell0013.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0014 = new PdfPCell(new Paragraph(""));
		cell0014.setHorizontalAlignment(Element.ALIGN_CENTER);

		table4criteria4.addCell(cell0013);
		table4criteria4.addCell(cell0014);

		PdfPCell cell412criteria4 = new PdfPCell(new Paragraph(
				"4.1.2 Percentage of expenditure for infrastructure development and \r\n"
				+ "augmentation excluding salary during the last five years\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria41Ql().get(0).getResponse412()
								: "")+"\r\n\r\n",
				font4));
		PdfPCell cell4102criteria4 = new PdfPCell(new Paragraph(
				"4.1.2.1: Expenditure for infrastructure development and \r\n"
				+ "augmentation, excluding salary year wise during last five years (INR \r\n"
				+ "in lakhs)\r\n"
						+ "\r\n\r\n" ,
				font4));

		table412criteria4.addCell(cell412criteria4);
		table412criteria4.addCell(cell4102criteria4);
		
//		table412criteria4.addCell(table4criteria4);
		table412criteria4.setSpacingBefore(20f);
		table412criteria4.setSpacingAfter(20f);

		document.add(table412criteria4);
		document.add(table4criteria4);


		// Creating a table of columns
		PdfPTable table5criteria4 = new PdfPTable(2);
		PdfPTable table51 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table5criteria4.setWidthPercentage(100);
		table51.setWidthPercentage(100);

		PdfPCell cell0015 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
		cell0015.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5criteria4.addCell(cell0015);
		PdfPCell cell0016 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell0016.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5criteria4.addCell(cell0016);
		PdfPCell cell0017 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
		cell0017.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5criteria4.addCell(cell0017);
		if(criteria4file.size() >0)
		{
		PdfPCell cell0018 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0018.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5criteria4.addCell(cell0018);
		}
		
		
//		PdfPCell cell0019 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//		table5criteria4.addCell(cell0019);
//		if(criteria4file.size() >0)
//		{
//		PdfPCell cell0020 = new PdfPCell(
//				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//		table5criteria4.addCell(cell0020);
//		}
//		PdfPCell cell0021 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//		PdfPCell cell0022 = new PdfPCell(new Paragraph());
//
//		table5criteria4.addCell(cell0021);
//		table5criteria4.addCell(cell0022);

//		PdfPCell cell000318 = new PdfPCell(
//				new Paragraph(
//				"4.1.3 Percentage of classrooms and seminar halls with ICT- enabled facilities such as smart class, LMS, etc. (Data for the latest completed academic year)\r\n"
//						+ "\r\n" + "Response:"
//						+ (criteria4Record != null
//								? criteria4Record.getCriteria41Ql().get(0).getResponse413()
//								: ""),font4));

//		PdfPCell cell00218 = new PdfPCell(
//				new Paragraph("4.1.3.1 Number of classrooms and seminar halls with ICT facilities\r\n" + "\r\n\r\n" + "Response: "
//				+ (criteria4Record != null ? criteria4Record.getCriteria41Ql().get(0).getInput413t1() : ""),font4));
//
//		// table51.addCell(criteria4List.get(0).getResponseValue413());
//		table51.addCell(cell000318);
//		table51.addCell(cell00218);
		
//		table51.addCell(table5criteria4);

		table51.setSpacingBefore(20f);
		table51.setSpacingAfter(20f);

		//document.add(table51);
		document.add(table5criteria4);

		// Creating a table of 3 columns
		PdfPTable table6criteria4 = new PdfPTable(5);
		PdfPTable table61criteria4 = new PdfPTable(1);

	
		table6criteria4.setWidthPercentage(100);
		table61criteria4.setWidthPercentage(100);


//		PdfPCell cell000118 = new PdfPCell(
//				new Paragraph(
//				"4.1.4 Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)\r\n"
//						+ "\r\n\r\n" + "Response: "
//						+ (criteria4Record != null
//								? criteria4Record.getCriteria41Ql().get(0).getResponse414()
//								: ""),font4));
//
//		// table61criteria4.addCell(criteria4List.get(0).getResponseValue414());
//
//		PdfPCell cell001118 = new PdfPCell(
//						new Paragraph(
//				"4.1.4.1 Expenditure for infrastructure augmentation, excluding salary year-wise during last five years (INR in lakhs)\r\n\r\n",font4));
//
//		// table61.addCell(table6);
//		table61criteria4.addCell(cell000118);
//		table61criteria4.addCell(cell001118);
//		

		table61criteria4.setSpacingBefore(20f);
		table61criteria4.setSpacingAfter(20f);

		//document.add(table61criteria4);
		//document.add(table6criteria4);


//		if (criteria4Record.getYearTable4141() != null) {
//
//			Table table4141 = new Table(criteria4Record.getYearTable4141().size(), 2);
//
//			table4141.setPadding(5);
//			table4141.setWidth(100f);
//
//			for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
//				
//				Cell cell021criteria4 = new Cell(new Paragraph(criteria4Record.getYearTable4141().get(i).getInput4141y(),font5));
//				cell021criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table4141.addCell(cell021criteria4);
//
//			}
//			for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
//				Cell cell022criteria4 = new Cell(new Paragraph(criteria4Record.getYearTable4141().get(i).getInput4141v(),font5));
//				cell022criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table4141.addCell(cell022criteria4);
//
//			}
//
//			document.add(table4141);
//		}

		// Creating a table of 3 columns
		PdfPTable table7criteria4 = new PdfPTable(2);

		// Setting width of table, its columns and spacing
		table7criteria4.setWidthPercentage(100);

		PdfPCell cell0033 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n",font4));
		cell0033.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7criteria4.addCell(cell0033);
		
		PdfPCell cell0034 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
		cell0034.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7criteria4.addCell(cell0034);
		PdfPCell cell0035 = new PdfPCell(
				new Paragraph("Upload any additional information\r\n\r\n ",font5));
		cell0035.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table7criteria4.addCell(cell0035);
        if(criteria4file.size() >0)
        {
		PdfPCell cell0036 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0036.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7criteria4.addCell(cell0036);
        }
		PdfPCell cell0037 = new PdfPCell(new Paragraph("Upload audited utilization statements\r\n\r\n",font5));
		cell0037.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7criteria4.addCell(cell0037);
		 if(criteria4file.size() >0)
            {
		PdfPCell cell0038 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0038.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7criteria4.addCell(cell0038);
            }
		PdfPCell cell0039 = new PdfPCell(new Paragraph("Upload Details of Expenditure, excluding salary during the last five years\r\n\r\n",font5));
		cell0039.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7criteria4.addCell(cell0039);
		PdfPCell cell0040 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0040.setHorizontalAlignment(Element.ALIGN_CENTER);

		table7criteria4.addCell(cell0040);

		table7criteria4.setSpacingBefore(20f);
		table7criteria4.setSpacingAfter(20f);

		//document.add(table7criteria4);

		/*
		 * Font fontParagraph27 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph27.setSize(12);
		 */

		
		
		
		///////cr4.2
		

		Paragraph paragraph31criteria4 = new Paragraph("4.2 Library as a Learning Resource \r\n\r\n", font2);
		paragraph31criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
       document.add(paragraph31criteria4);
	

       
//       
//		Paragraph paragraph32criteria4 = new Paragraph(
//				"4.2.1	Library is automated using Integrated Library Management System (ILMS)\r\n" + "Response",
//				font2);
//		paragraph32criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		PdfPTable table421criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table421criteria4.setWidthPercentage(100);
//
		PdfPCell cell00400 = new PdfPCell(new Paragraph(
				"4.2.1 Library is automated with digital facilities using Integrated Library \r\n"
				+ "Management System (ILMS), adequate subscriptions to e-resources \r\n"
				+ "and journals are made. The library is optimally used by the faculty \r\n"
				+ "and students\r\n\r\n Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria42Ql().get(0).getResponse421()
								: "")+"\r\n\r\n",font4));
		// table421criteria4.addCell(criteria4List.get(3).getResponseValue421());
		table421criteria4.addCell(cell00400);
//		document.add(table421criteria4);

		table421criteria4.setSpacingBefore(20f);
		table421criteria4.setSpacingAfter(20f);
		document.add(table421criteria4);

	
		PdfPTable table8criteria4 = new PdfPTable(2);
//		font6criteria4.setColor(CMYKColor.BLACK);
		// Setting width of table, its columns and spacing
		table8criteria4.setWidthPercentage(100);

		PdfPCell cell0041 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n",font4));
		cell0041.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0042 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
		cell0042.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0043 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
		cell0043.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0044 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(7).getCriteria4FilePath() : "",font5));
		cell0044.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0045 = new PdfPCell(new Paragraph("Paste Link for additional information\r\n\r\n ",font5));
		cell0045.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0046 = new PdfPCell(new Paragraph(" ",font5));
		cell0046.setHorizontalAlignment(Element.ALIGN_CENTER);

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

		PdfPCell cell0047 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n",font4));
		cell0047.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0048 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4 ));
		cell0048.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0049 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
		cell0049.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0050 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0050.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0051 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n",font5));
		cell0051.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0052 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0052.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0053 = new PdfPCell(new Paragraph(
				"Details of subscriptions like e-journals, e-books , e- ShodhSindhu, Shodhganga Membership etc\r\n\r\n",font5));
		cell0053.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0054 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0054.setHorizontalAlignment(Element.ALIGN_CENTER);


		table9criteria4.addCell(cell0047);
		table9criteria4.addCell(cell0048);
		table9criteria4.addCell(cell0049);
		table9criteria4.addCell(cell0050);
		table9criteria4.addCell(cell0051);
		table9criteria4.addCell(cell0052);
		table9criteria4.addCell(cell0053);
		table9criteria4.addCell(cell0054);
		
		
        if(criteria4Record.getCriteria42Qn()!=null) {
        	PdfPCell cell00540 = new PdfPCell(
					new Paragraph(
				"4.2.2 Percentage of expenditure for purchase of books/ e-books and \r\n"
				+ "subscription to journals/e-journals during the last five years"
						 + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria42Qn().get(0).getResponse422()
								: "")+"\r\n\r\n",font4));
        	
        	PdfPCell cell005040 = new PdfPCell(
					new Paragraph(
				"4.2.2.1: Expenditure for purchase of books / e-books and subscription \r\n"
				+ "to journals/e-journals year wise during last five years (INR in lakhs)\r\n\r\n",font4));
        	
		table10criteria4.addCell(cell00540);
		table10criteria4.addCell(cell005040);

		table10criteria4.setSpacingBefore(20f);
		table10criteria4.setSpacingAfter(20f);

		document.add(table10criteria4);
		document.add(table9criteria4);
}
        
        
        if (criteria4Record.getAffiliatedYearTable4121() != null) {
        	
      					Table table4121 = new Table(criteria4Record.getAffiliatedYearTable4121().size(), 2);
      					table4121.setPadding(5);
      					table4121.setWidth(100f);
        
       					for (int i = 0; i < criteria4Record.getAffiliatedYearTable4121().size(); i++) {
      						
      					Cell cell1criteria4 = new Cell(new Paragraph(criteria4Record.getAffiliatedYearTable4121().get(i).getInput4121y(),font5));           						cell1criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
      					table4121.addCell(cell1criteria4);
                    					}
       					for (int i = 0; i < criteria4Record.getAffiliatedYearTable4121().size(); i++) {
       						Cell cell12criteria4 = new Cell(new Paragraph(criteria4Record.getAffiliatedYearTable4121().get(i).getInput4121v(),font5));
      						cell12criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
      						table4121.addCell(cell12criteria4);
        					}
        	
    					document.add(table4121);
       				}
        
        
        
        
        
		// Creating a table of 3 columns
//		PdfPTable table11criteria4 = new PdfPTable(5);
//		PdfPTable table12criteria4 = new PdfPTable(1);
//
//		// Setting width of table, its columns and spacing
//		table11criteria4.setWidthPercentage(100);
//		table12criteria4.setWidthPercentage(100);

//		PdfPCell cell0055 = new PdfPCell(new Paragraph("2020-21"));
//		PdfPCell cell0056 = new PdfPCell(new Paragraph("2019-20"));
//		PdfPCell cell0057 = new PdfPCell(new Paragraph("2018-19"));
//		PdfPCell cell0058 = new PdfPCell(new Paragraph("2017-18"));
//		PdfPCell cell0059 = new PdfPCell(new Paragraph("2016-17"));
//		PdfPCell cell0060 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell0061 = new PdfPCell(new Paragraph(""));
//		PdfPCell cell0062 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell0063 = new PdfPCell(new Paragraph(""));
//		PdfPCell cell0064 = new PdfPCell(new Paragraph(" "));
//
//		table11criteria4.addCell(cell0055);
//		table11criteria4.addCell(cell0056);
//		table11criteria4.addCell(cell0057);
//		table11criteria4.addCell(cell0058);
//		table11criteria4.addCell(cell0059);
//		table11criteria4.addCell(cell0060);
//		table11criteria4.addCell(cell0061);
//		table11criteria4.addCell(cell0062);
//		table11criteria4.addCell(cell0063);
//		table11criteria4.addCell(cell0064);

//		PdfPCell cell005401 = new PdfPCell(
//				new Paragraph(
//				"4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n\r\n"
//						 + "Response: "
//						+ (criteria4Record != null
//								? criteria4Record.getCriteria42Qn().get(0).getResponse423()
//								: "")+"\r\n\r\n",font4));
//
//				PdfPCell cell005402 = new PdfPCell(
//    					new Paragraph(
//				"4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)"
//						+ "\r\n\r\n",font4));
//				table12criteria4.addCell(cell005401);
//				table12criteria4.addCell(cell005402);
//		// table12.addCell(table11);
//
//		table12criteria4.setSpacingBefore(20f);
//		table12criteria4.setSpacingAfter(20f);
//
//		document.add(table12criteria4);
//		document.add(table11criteria4);
//
//		if (criteria4Record.getYearTable4231() != null) {
//
//			Table table4231 = new Table(criteria4Record.getYearTable4231().size(), 2);
//
//			table4231.setPadding(5);
//			table4231.setWidth(100f);
//
//			for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
//				
//				
//				Cell cell1criteria4 = new Cell(new Paragraph(criteria4Record.getYearTable4231().get(i).getInput4231y(),font5));
//				cell1criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table4231.addCell(cell1criteria4);
//
//			}
//			for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
//				Cell cell12criteria4 = new Cell(new Paragraph(criteria4Record.getYearTable4231().get(i).getInput4231v(),font5));
//				cell12criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table4231.addCell(cell12criteria4);
//			}
//
//			document.add(table4231);
//		}
//
//		// Creating a table of 3 columns
//
//		PdfPTable table13 = new PdfPTable(2);
//
//		// Setting width of table, its columns and spacing
//		table13.setWidthPercentage(100);
//
//		PdfPCell cell0065 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4 ));
//		cell0065.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0066 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
//		cell0066.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0067 = new PdfPCell(new Paragraph(
//				"Details of annual expenditure for purchase of and subscription to journals/e-journals during the last five years\r\n\r\n",font5));
//		cell0067.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0068 = new PdfPCell(
//				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
//		cell0068.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0069 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n",font5));
//		cell0069.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0070 = new PdfPCell(
//				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
//		cell0070.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0071 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
//		cell0071.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0072 = new PdfPCell(
//				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
//		cell0072.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//		table13.addCell(cell0065);
//		table13.addCell(cell0066);
//		table13.addCell(cell0067);
//		table13.addCell(cell0068);
//		table13.addCell(cell0069);
//		table13.addCell(cell0070);
//		table13.addCell(cell0071);
//		table13.addCell(cell0072);
//
//		table13.setSpacingBefore(20f);
//		table13.setSpacingAfter(20f);
//
//		document.add(table13);

		// Creating a table of 3 columns
//		PdfPTable table14criteria4 = new PdfPTable(2);
//		PdfPTable table15 = new PdfPTable(1);
//
//		// Setting width of table, its columns and spacing
//		table14criteria4.setWidthPercentage(100);
//		table15.setWidthPercentage(100);
//
//		PdfPCell cell0075 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
//		cell0075.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0076 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
//		cell0076.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0077 = new PdfPCell(new Paragraph("Details of library usage by teachers and students\r\n\r\n",font5));
//		cell0077.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0078 = new PdfPCell(
//				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
//		cell0078.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0079 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//		cell0079.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0080 = new PdfPCell(
//				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
//		cell0080.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//		table14criteria4.addCell(cell0075);
//		table14criteria4.addCell(cell0076);
//		table14criteria4.addCell(cell0077);
//		table14criteria4.addCell(cell0078);
//		table14criteria4.addCell(cell0079);
//		table14criteria4.addCell(cell0080);
//
//		PdfPCell cell00801 = new PdfPCell(
//				new Paragraph(
//				"4.2.4 Percentage per day usage of library by teachers and students ( foot falls and login data for online access) during the latest completed academic year\r\n"
//						+ "\r\n\r\n" + "Response: "
//						+ (criteria4Record != null
//								? criteria4Record.getCriteria42Qn().get(0).getResponse424()
//								: "")+"\r\n\r\n",font4));
//
//
//		PdfPCell cell008013 = new PdfPCell(
//				new Paragraph("4.2.4.1 Number of teachers and students using library per day over last one year\r\n" + "\r\n\r\n"
//				+ "Response: "
//				+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getInput4241t1() : "")+"\r\n\r\n",font4));
//
//		
//		
////				PdfPCell cell0080131 = new PdfPCell(
////						new Paragraph("4.2.4.1: Total number of teachers and students" + "\r\n"
////				+ "Response: "
////				+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getInput4241t1() : ""),font4));
//
//				table15.addCell(cell00801);
//				table15.addCell(cell008013);
////				table15.addCell(cell0080131);
//		
////		table15.addCell(table14criteria4);
//
//		table15.setSpacingBefore(20f);
//		table15.setSpacingAfter(20f);
//
//		document.add(table15);
//		document.add(table14criteria4);

		
		
		///////////////////cr4.3
		Paragraph paragraph501111111 = new Paragraph("4.3: IT Infrastructure (30)\r\n\r\n", font2);
		paragraph501111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph501111111);
		
	
			
		
		
		
		/////////////////////////////////////////////
		
		PdfPTable table17criteria4 = new PdfPTable(2);
		PdfPTable table171criteria4 = new PdfPTable(1);
		
		table17criteria4.setWidthPercentage(100);
		table171criteria4.setWidthPercentage(100);
		
		PdfPCell cell431criteria4 = new PdfPCell(new Paragraph(
				"4.3.1	Institution frequently updates its IT facilities and provides sufficient bandwidth for internet connection\r\n"
				+ "\r\n\r\n"
						+ "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria43Ql().get(0).getResponse431()
								: "")+"\r\n\r\n",font4));
		table171criteria4.addCell(cell431criteria4);
		
		
		PdfPCell cell0091 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell0091.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0092 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell0092.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0093 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
		cell0093.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0094 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0094.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0095 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n",font5));
		cell0095.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0096 = new PdfPCell(new Paragraph(" ",font5));
		cell0096.setHorizontalAlignment(Element.ALIGN_CENTER);

		table17criteria4.addCell(cell0091);
		table17criteria4.addCell(cell0092);
		table17criteria4.addCell(cell0093);
		table17criteria4.addCell(cell0094);
		table17criteria4.addCell(cell0095);
		table17criteria4.addCell(cell0096);


		document.add(table171criteria4);
		document.add(table17criteria4);

		// Creating a table of 3 columns
		PdfPTable table18criteria4 = new PdfPTable(2);
		PdfPTable table19criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table18criteria4.setWidthPercentage(100);
		table19criteria4.setWidthPercentage(100);

		table18criteria4.setSpacingAfter(20);
		table18criteria4.setSpacingAfter(20);
		
		PdfPCell cell0097 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell0097.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0098 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell0098.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell0099 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
		cell0099.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell00100 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell00100.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell00101 = new PdfPCell(new Paragraph("Student - computer ratio\r\n\r\n",font5));
		cell00101.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell00102 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell00102.setHorizontalAlignment(Element.ALIGN_CENTER);


		table18criteria4.addCell(cell0097);
		table18criteria4.addCell(cell0098);
		table18criteria4.addCell(cell0099);
		table18criteria4.addCell(cell00100);
		table18criteria4.addCell(cell00101);
		table18criteria4.addCell(cell00102);


		PdfPCell cell001021 = new PdfPCell(
				new Paragraph("4.3.2 Student - Computer ratio (Data for the latest completed academic year)\r\n\r\n"
				 + "Response:"
				+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse432()
						: "")+"\r\n\r\n",font4));
		PdfPCell cell0010201 = new PdfPCell(
				new Paragraph("4.3.2.1: Number of computers available for students’ usage during the latest completed academic year: \r\n\r\n",font4));
		
		
//		 table19criteria4.addCell(criteria4List.getCriteria4FieldInfoQn().get(0).getResponseValue432());
		table19criteria4.addCell(cell001021);
		table19criteria4.addCell(cell0010201);

//		table19criteria4.addCell(table18criteria4);

		table19criteria4.setSpacingBefore(20f);
		table19criteria4.setSpacingAfter(20f);

		document.add(table19criteria4);
		document.add(table18criteria4);

		// Creating a table of 3 columns

		PdfPTable table20criteria4 = new PdfPTable(2);
		PdfPTable table21criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table20criteria4.setWidthPercentage(100);
		table21criteria4.setWidthPercentage(100);
		table20criteria4.setSpacingAfter(20f);
		table20criteria4.setSpacingBefore(20f);

		PdfPCell cell00103 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell00103.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00104 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell00104.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00105 = new PdfPCell(
				new Paragraph("Upload any additional information\r\n",font5));
		cell00105.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00106 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell00106.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell001051 = new PdfPCell(
				new Paragraph("Upload any additional information\r\n",font5));
		cell001051.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell001061 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell001061.setHorizontalAlignment(Element.ALIGN_CENTER);
		

		table20criteria4.addCell(cell00103);
		table20criteria4.addCell(cell00104);
		table20criteria4.addCell(cell00105);
		table20criteria4.addCell(cell00106);
		table20criteria4.addCell(cell001051);
		table20criteria4.addCell(cell001061);

		PdfPCell cell0010611 = new PdfPCell(
				new Paragraph("4.3.3: Institution has dedicated audio visual centre, mixing equipment editing facility, media studio, lecture capturing system(LCS) andrelated hardware and software for e-content development\r\nResponse:\r\n"
				+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse433()
						: ""),font4));

		// table21criteria4.addCell(criteria4List.get(0).getResponseValue433());

		table21criteria4.addCell(cell0010611);
//		table21criteria4.addCell(table20criteria4);
		document.add(table21criteria4);
		document.add(table20criteria4);
		table21criteria4.setSpacingBefore(20f);
		table21criteria4.setSpacingAfter(20f);


		// Creating a table of 3 columns

		PdfPTable table22criteria4 = new PdfPTable(2);
		PdfPTable table23criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table22criteria4.setWidthPercentage(100);
		table23criteria4.setWidthPercentage(100);

		PdfPCell cell00107 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell00107.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00108 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell00108.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00109 = new PdfPCell(new Paragraph("Upload Additional information\r\n\r\n",font5));
		cell00109.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00110 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell00110.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00111 = new PdfPCell(new Paragraph(" Institutional data in prescribed format\r\n\r\n",font5));
		cell00111.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00112 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell00112.setHorizontalAlignment(Element.ALIGN_CENTER);

		table22criteria4.addCell(cell00107);
		table22criteria4.addCell(cell00108);
		table22criteria4.addCell(cell00109);
		table22criteria4.addCell(cell00110);
		table22criteria4.addCell(cell00111);
		table22criteria4.addCell(cell00112);

//		PdfPCell cell00106110 = new PdfPCell(
//				new Paragraph("4.3.4 Institution has the following Facilities for e-content development\r\n" + "\r\n"
//				+ "1.	Media centre\r\n" + "2.	Audio visual centre\r\n" + "3.	Lecture Capturing System(LCS)\r\n"
//				+ "4.	Mixing equipments and softwares for editing\r\n" + "Response: "
//				+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse434()
//						: "")+"\r\n\r\n",font4));
		

		// table23criteria4.addCell(criteria4List.get(0).getResponseValue434());
		//table23criteria4.addCell(cell00106110);
//		table23criteria4.addCell(table22criteria4);

		table23criteria4.setSpacingBefore(20f);
		table23criteria4.setSpacingAfter(20f);

		document.add(table23criteria4);
		document.add(table22criteria4);
		
		/////////////////cr4.4
		
		
		
		
		Paragraph paragraph50 = new Paragraph("4.4  Maintenance of Campus Infrastructure\r\n ", font2);
		paragraph50.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph50);

		// Creating a table of 3 columns

		PdfPTable table24criteria4 = new PdfPTable(5);
		PdfPTable table25criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table24criteria4.setWidthPercentage(100);
		table25criteria4.setWidthPercentage(100);

		table25criteria4.setSpacingBefore(20f);
		table25criteria4.setSpacingAfter(20f);
		
		PdfPCell cell00113 = new PdfPCell(new Paragraph("2020-21"));
		PdfPCell cell00114 = new PdfPCell(new Paragraph("2019-20"));
		PdfPCell cell00115 = new PdfPCell(new Paragraph("2018-19"));
		PdfPCell cell00116 = new PdfPCell(new Paragraph("2017-18"));
		PdfPCell cell00117 = new PdfPCell(new Paragraph("2016-17"));
		PdfPCell cell00118 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell00119 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell00120 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell00121 = new PdfPCell(new Paragraph(" "));
		PdfPCell cell00122 = new PdfPCell(new Paragraph(" "));

		table24criteria4.addCell(cell00113);
		table24criteria4.addCell(cell00114);
		table24criteria4.addCell(cell00115);
		table24criteria4.addCell(cell00116);
		table24criteria4.addCell(cell00117);
		table24criteria4.addCell(cell00118);
		table24criteria4.addCell(cell00119);
		table24criteria4.addCell(cell00120);
		table24criteria4.addCell(cell00121);
		table24criteria4.addCell(cell00122);

		PdfPCell cell001121 = new PdfPCell(
				new Paragraph(
				"4.4.1Percentage expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary , during the last five years\r\n\r\n"
						+ " Response: "
						+ (criteria4Record != null
								? criteria4Record.getCriteria44Ql().get(0).getResponse441()
								: "")+"\r\n\r\n",font4));

		// table25criteria4.addCell(criteria4List.get(0).getResponseValue441());

		PdfPCell cell0011211 = new PdfPCell(
				new Paragraph(
				"4.4.1.1: Expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component year wise during last five years (INR in lakhs)\r\n\r\n",font4));

		table25criteria4.addCell(cell001121);
		table25criteria4.addCell(cell0011211);

		table25criteria4.setSpacingBefore(20f);
		table25criteria4.setSpacingAfter(20f);

		document.add(table25criteria4);
//		document.add(table24criteria4);
		

		if (criteria4Record.getYearTable4411() != null) {

			Table table4411 = new Table(criteria4Record.getYearTable4411().size(), 2);

			table4411.setPadding(5);
			table4411.setWidth(100f);

			for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
				
				
				Cell cell12criteria4 = new Cell(new Paragraph(criteria4Record.getYearTable4411().get(i).getInput4411y(),font5));
				cell12criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4411.addCell(cell12criteria4);
			}
			for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
				Cell cell121criteria4 = new Cell(new Paragraph(criteria4Record.getYearTable4411().get(i).getInput4411v(),font5));
				cell121criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4411.addCell(cell121criteria4);
			}

			document.add(table4411);

		}

		PdfPTable table26criteria4 = new PdfPTable(2);
		table26criteria4.setWidthPercentage(100);
		table26criteria4.setSpacingAfter(20);
		table26criteria4.setSpacingBefore(20);
		
		PdfPCell cell00123 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell00123.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00124 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell00124.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00125 = new PdfPCell(new Paragraph(
				"Upload any additional information\r\n ",font5));
		cell00125.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00126 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell00126.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00127 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n ",font5));
		cell00127.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00128 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell00128.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell001271 = new PdfPCell(new Paragraph("Details about assigned budget and expenditure on physical facilities and academic facilities",font5));
		cell001271.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell001281 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell001281.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table26criteria4.addCell(cell00123);
		table26criteria4.addCell(cell00124);
		table26criteria4.addCell(cell00125);
		table26criteria4.addCell(cell00126);
		table26criteria4.addCell(cell00127);
		table26criteria4.addCell(cell00128);
		table26criteria4.addCell(cell001271);
		table26criteria4.addCell(cell001281);

		document.add(table26criteria4);

		/*
		 * Font fontParagraph47 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph47.setSize(12);
		 */
//
//		Paragraph paragraph51 = new Paragraph(
//				"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\r\n"
//						+ "\r\n" + "Response:"
//						+ (criteria4Record != null
//								? criteria4Record.getCriteria44Ql().get(0).getResponse442()
//								: ""),
//				font2);
//		document.add(paragraph51);
//		

		PdfPTable table442criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table442criteria4.setWidthPercentage(100);

		PdfPCell cell00128110 = new PdfPCell(
				new Paragraph(
				"4.4.2 There are established systems and procedures for maintaining and utilizing physical and academic support facilities – laboratory,library, sports complex, computers, classrooms etc.\r\n\r\n"
						 + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria44Ql().get(0).getResponse442()
								: "")+"\r\n\r\n",font4));
		// table442criteria4.addCell(criteria4List.get(0).getResponseValue442());
		table442criteria4.addCell(cell00128110);
		
		document.add(table442criteria4);

		table442criteria4.setSpacingBefore(20f);
		table442criteria4.setSpacingAfter(20f);

//		paragraph51.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph48 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph48.setSize(12);
		 */

//		Paragraph paragraph52 = new Paragraph(
//				" The Maintenance Cell of the college ensures proper functioning of all civil, electrical, water, sewage, environment, and other facilities through frequent inspections and need-based maintenance works. A central complaint register is maintained, and the maintenance cell attends to those complaints on a priority basis. A vast majority of minor and major repairs are carried out internally, while some major repairs are outsourced. The maintenance cell is headed by the Registrar/Dean-Administration. The other members of the cell include Administrative Maintenance in-charge, Head of EEE department, and two senior faculty members, one each from Civil Engineering and Mechanical Engineering departments. The members of the cell meet based on the need and review the requirements to chalk out further action to be taken. The cell also arranges to conduct energy audit. Staff belonging to the maintenance cell perform routine cleaning of the water tanks, water coolers, filters, etc. as per schedule. Preventive maintenance of the equipment is a regular practice in all laboratories apart from breakdown maintenance. Gardeners and janitors conduct regular cleaning of the campus premises and restrooms twice a day.\r\n"
//						+ "\r\n"
//						+ "The regular maintenance of all the seminar halls of the institution, Open air auditorium, Portico of Block-2, open air grounds, playground etc. are supervised by the Administrative Officer. The Faculty/students put a letter in the prescribed format (mentioning the date and time of requirement) seeking the allocation of the required physical facility for the respective events to be organized. After the allocation as per the availability, such information is entered in a register kept with the Administrative officer.\r\n"
//						+ "\r\n"
//						+ "All OHP/LCD projectors in the institution, furniture available in the classroom, faculty/staff rooms are regularly monitored on a fortnightly basis for maintenance.\r\n"
//						+ "\r\n"
//						+ "Each laboratory maintains a stock register for detailing the proper lab records. The lab stock register holds\r\n"
//						+ " \r\n"
//						+ "the complete details of lab equipment, new arrivals, replacements of old equipment, maintenance details, license details etc. Each lab is associated with a qualified Technical Staff for maintenance of all lab equipment. Any major repair of equipment beyond the scope of technical staff is outsourced. Obsolete and irreparable equipment is weeded out on regular basis. A register for �Lab equipment Repair/ Maintenance� is kept in each lab to track the breakdown time of equipment and the maintenance details. A minimum of 20% to 30% of unutilized lab slots per week are allotted for regular maintenance works of the laboratories.\r\n"
//						+ "\r\n"
//						+ "The college has a central computing facility located in the library building, which is also used for browsing and accessing electronic content of learning resources.\r\n"
//						+ "\r\n"
//						+ "The institution has established a separate maintenance cell, responsible for the maintenance works of computers, Hardware and software installations/up-gradations, wi-fi and internet maintenance. The cell is chaired by a senior faculty from Computer Science Engineering department who supervises the supporting staff required for this purpose.\r\n"
//						+ "",
//				font5);
//		paragraph52.setAlignment(Paragraph.ALIGN_JUSTIFIED);

//		document.add(paragraph51);
//		document.add(paragraph52);

		PdfPTable table27criteria4 = new PdfPTable(2);
		table27criteria4.setWidthPercentage(100);

		PdfPCell cell00129 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell00129.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00130 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell00130.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00093 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
		cell00093.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00094 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell00094.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00131 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n",font5));
		cell00131.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00132 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell00132.setHorizontalAlignment(Element.ALIGN_CENTER);
		table27criteria4.addCell(cell00129);
		table27criteria4.addCell(cell00130);
		table27criteria4.addCell(cell00093);
		table27criteria4.addCell(cell00094);
		table27criteria4.addCell(cell00131);
		table27criteria4.addCell(cell00132);

		table27criteria4.setSpacingBefore(20f);
		table27criteria4.setSpacingAfter(20f);

		document.add(table27criteria4);
		
		}
	
	////////////////// criteria 5

	public void Criteria5(Document document, Criteria5_FieldInfo criteria5Fieldinfo) {			Paragraph paragraph0 = new Paragraph("Criterion 5 - Student Support and Progression\r\n", font1);
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
			criterai5file.size() > 0 ? criterai5file.get(0).getCriteria5FilePath() : "", font5));
	cell1004.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell1005 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n", font5));
	cell1005.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell1006 = new PdfPCell(new Paragraph(
			criterai5file.size() > 0 ? criterai5file.get(1).getCriteria5FilePath() : "", font5));
	cell1006.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell1007 = new PdfPCell(
			new Paragraph("Institutional data in prescribed format\r\n\r\n", font5));
	cell1007.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell1008 = new PdfPCell(new Paragraph(
			criterai5file.size() > 0 ? criterai5file.get(2).getCriteria5FilePath() : "", font5));
	cell1008.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell1009 = new PdfPCell(new Paragraph(
			"Average percentage of students benefited by scholarships and freeships provided by the Government during the last five years\r\n\r\n",
			font5));
	cell1009.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell10010 = new PdfPCell(new Paragraph(
			criterai5file.size() > 0 ? criterai5file.get(3).getCriteria5FilePath() : "", font5));
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

//	table011.setSpacingBefore(20f);
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
			criterai5file.size() > 0 ? criterai5file.get(4).getCriteria5FilePath() : "", font5));
	cell00004.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell00005 = new PdfPCell(new Paragraph(
			"Number of students benefited by scholarships and freeships besides government schemes in last 5 years\r\n\r\n",
			font5));
	cell00005.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell00006 = new PdfPCell(new Paragraph(
			criterai5file.size() > 0 ? criterai5file.get(5).getCriteria5FilePath() : "", font5));
	cell00006.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell00007 = new PdfPCell(
			new Paragraph("Institutional data in prescribed format\r\n\r\n", font5));
	cell00007.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell00008 = new PdfPCell(new Paragraph(
			criterai5file.size() > 0 ? criterai5file.get(6).getCriteria5FilePath() : "", font5));
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

//table31criteria5.addCell(table03criteria5);

	table31criteria5.setSpacingBefore(20f);
	table31criteria5.setSpacingAfter(20f);

	document.add(table31criteria5);
	document.add(table03criteria5);

	if (criteria5Record.getYearTable5121() != null) {
		Table table5121 = new Table(criteria5Record.getYearTable5121().size(), 2);

		table5121.setPadding(5);
		table5121.setWidth(100f);

		for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
			Cell cell121criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5121().get(i).getInput5121y(),font5));
			cell121criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5121.addCell(cell121criteria5);

		}
		for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
			
			Cell cell1201criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5121().get(i).getInput5121v(),font5));
			cell1201criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5121.addCell(cell1201criteria5);

		}

//		document.add(table5121);
	}

	PdfPCell cell00044 = new PdfPCell(new Paragraph("B. Number of Sanctioned Posts\r\n\r\n"));
//		document.add(cell00044);

	if (criteria5Record.getYearTable5121() != null) {
		
		
		Table table5121 = new Table(criteria5Record.getYearTable5121().size(), 2);

		table5121.setPadding(5);
		table5121.setWidth(100f);

		for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
			
			
			Cell cell1211criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5121().get(i).getInput5121y(),font5));
			cell1211criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5121.addCell(cell1211criteria5);
			

		}
		for (int i = 0; i < criteria5Record.getYearTable5121().size(); i++) {
			
			
			Cell cell1210criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5121().get(i).getInput5121v(),font5));
			cell1210criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5121.addCell(cell1210criteria5);
			
		}

	//	document.add(table5121);
	}

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
			criterai5file.size() > 0 ? criterai5file.get(10).getCriteria5FilePath() : "", font5));
	cell00030.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell00031 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
	cell00031.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell00032 = new PdfPCell(new Paragraph(
			criterai5file.size() > 0 ? criterai5file.get(11).getCriteria5FilePath() : "", font5));
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

//table41criteria5.addCell(table04criteria5);

	table41criteria5.setSpacingBefore(20f);
	table41criteria5.setSpacingAfter(20f);

	document.add(table41criteria5);
	document.add(table04criteria5);

	if (criteria5Record.getYearTable5141() != null) {
		Table table5141 = new Table(criteria5Record.getYearTable5141().size(), 2);

		table5141.setPadding(5);
		table5141.setWidth(100f);

		for (int i = 0; i < criteria5Record.getYearTable5141().size(); i++) {
			
			Cell cell1211criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5141().get(i).getInput5141y(),font5));
			cell1211criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5141.addCell(cell1211criteria5);
		}
		for (int i = 0; i < criteria5Record.getYearTable5141().size(); i++) {
			
			
			Cell cell12110criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5141().get(i).getInput5141v(),font5));
			cell12110criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5141.addCell(cell12110criteria5);

		}

	//	document.add(table5141);
	}
	if (criteria5Record.getYearTable5141() != null) {
		Table table5141 = new Table(criteria5Record.getYearTable5141().size(), 2);

		table5141.setPadding(5);
		table5141.setWidth(100f);

		for (int i = 0; i < criteria5Record.getYearTable5141().size(); i++) {
		
			Cell cell1210criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5141().get(i).getInput5141y(),font5));
			cell1210criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5141.addCell(cell1210criteria5);
			

		}
		for (int i = 0; i < criteria5Record.getYearTable5141().size(); i++) {
			
			
			Cell cell1200criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5141().get(i).getInput5141v(),font5));
			cell1200criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5141.addCell(cell1200criteria5);
			

		}

//		document.add(table5141);
	}

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
			criterai5file.size() > 0 ? criterai5file.get(12).getCriteria5FilePath() : "", font5));
	cell00038.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell00039 = new PdfPCell(new Paragraph(
			"Minutes of the meetings of student redressal committee, prevention of sexual harassment committee and Anti Ragging committee\r\n\r\n",
			font5));
	cell00039.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell00040 = new PdfPCell(new Paragraph(
			criterai5file.size() > 0 ? criterai5file.get(1).getCriteria5FilePath() : "", font5));
	cell00040.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell00041 = new PdfPCell(new Paragraph(
			"Details of student grievances including sexual harassment and ragging cases", font5));
	cell00041.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell00042 = new PdfPCell(new Paragraph(
			criterai5file.size() > 0 ? criterai5file.get(1).getCriteria5FilePath() : "", font5));
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
							: ""),
			font4));

//	table051criteria5.addCell(cell0008);

//table051criteria5.addCell(table05criteria5);

	table051criteria5.setSpacingBefore(20f);
	table051criteria5.setSpacingAfter(20f);

	document.add(table051criteria5);
	document.add(table05criteria5);

	////////////////// cr5.2

	PdfPTable table06criteria5 = new PdfPTable(2);
	PdfPTable table061 = new PdfPTable(1);

//Setting width of table, its columns and spacing
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


//	table061.addCell(table06criteria5);

	table061.setSpacingBefore(20f);
	table061.setSpacingAfter(20f);
	document.add(table061);
	document.add(table06criteria5);

	
//
//	Paragraph paragraph0301 = new Paragraph(
//			"5.2.1 Average percentage of placement of outgoing students during the last five years\r\n"
//					+ "\r\n\r\n" + "Response: "
//					+ (criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getResponse521()
//							: ""));
//	document.add(paragraph0301);
//	Paragraph paragraph0310 = new Paragraph(
//			"5.2.1.1 Number of outgoing students placed year - wise during the last five years.", font3);
//	document.add(paragraph0310);
//table061.addCell(cell00009);
//table061.addCell(cell00010);
//
//table061.addCell(table06criteria5);
//
//table061.setSpacingBefore(20f);
//table061.setSpacingAfter(20f);
//
//document.add(table061);
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
	
//	PdfPTable table711criteria5 = new PdfPTable(1);
//	
//	table711criteria5.setWidthPercentage(100);
//
//	
//	table711criteria5.setSpacingBefore(20f);
//	table711criteria5.setSpacingAfter(20f);
//
//	PdfPCell cell0113 = new PdfPCell(new Paragraph(
//			"5.2.3 Average percentage of students qualifying in state/national/ international level examinations during the last five years (eg: IIT-JAM/CLAT/ NET/SLET/GATE/ GMAT/CAT/GRE/ TOEFL/ Civil Services/State government examinations, etc.)\r\n"
//					+ "\r\n\r\n" + "Response:"
//					+ (criteria5Record != null ? criteria5Record.getCriteria52Qn().get(0).getResponse523()
//							: "")+"\r\n\r\n",
//			font4));
//
//	PdfPCell cell0114 = new PdfPCell(new Paragraph(
//			"5.2.3.1 Number of students qualifying in state/ national/ international level examinations (eg: IIT/JAM/ NET/ SLET/ GATE/ GMAT/CAT/GRE/ TOEFL/ Civil Services/ State government examinations, etc.)) year-wise during last five years\r\n\r\n",
//			font4));
//	table711criteria5.addCell(cell0113);
//	table711criteria5.addCell(cell0114);
//	document.add(table711criteria5);
//	
//
//	if (criteria5Record.getYearTable5231() != null) {
//		Table table5231 = new Table(criteria5Record.getYearTable5231().size(), 2);
//
//		table5231.setPadding(5);
//		table5231.setWidth(100f);
//
//		for (int i = 0; i < criteria5Record.getYearTable5231().size(); i++) {
//			
//			
//			Cell cell1212criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5231().get(i).getInput5231y(),font5));
//			cell1212criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table5231.addCell(cell1212criteria5);
//
//		}
//		for (int i = 0; i < criteria5Record.getYearTable5231().size(); i++) {
//			
//			
//			Cell cell102criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5231().get(i).getInput5231v(),font5));
//			cell102criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table5231.addCell(cell102criteria5);
//		}
//
//		document.add(table5231);
//	}
//
//	
//	PdfPTable table08criteria5 = new PdfPTable(2);
//	PdfPTable table81criteria5 = new PdfPTable(1);
//
//	// Setting width of table, its columns and spacing
//	table08criteria5.setWidthPercentage(100);
//	table81criteria5.setWidthPercentage(100);
//
//	PdfPCell cell59criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
//	cell59criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//	PdfPCell cell60criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
//	cell60criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//	PdfPCell cell61criteria5 = new PdfPCell(
//			new Paragraph("Upload supporting data for student/alumni\r\n\r\n",font5));
//	cell61criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//	PdfPCell cell62criteria5 = new PdfPCell(
//			new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : "",font5));
//	cell62criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//	PdfPCell cell63criteria5 = new PdfPCell(new Paragraph(
//			"Number of students qualifying in state/ national/ international level examinations during the last five years\r\n\r\n",font5));
//	cell63criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//	PdfPCell cell64criteria5 = new PdfPCell(
//			new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : "",font5));
//	cell64criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//	PdfPCell cell65criteria5 = new PdfPCell(new Paragraph("Any additional information"));
//	cell65criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//	PdfPCell cell66criteria5 = new PdfPCell(
//			new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : "",font5));
//	cell66criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//	table08criteria5.addCell(cell59criteria5);
//	table08criteria5.addCell(cell60criteria5);
//	table08criteria5.addCell(cell61criteria5);
//	table08criteria5.addCell(cell62criteria5);
//	table08criteria5.addCell(cell63criteria5);
//	table08criteria5.addCell(cell64criteria5);
//	table08criteria5.addCell(cell65criteria5);
//	table08criteria5.addCell(cell66criteria5);
////table81criteria5.addCell(cell0113);
////table81criteria5.addCell(cell0114);
////table81criteria5.addCell(cell0115);
//
////	table81criteria5.addCell(table08criteria5);
//
//	table81criteria5.setSpacingBefore(20f);
//	table81criteria5.setSpacingAfter(20f);
//
//	document.add(table08criteria5);
//	document.add(table81criteria5);

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
	

	
	
	
//PdfPCell cell0120 = new PdfPCell(new Paragraph(
//	"Mother Teresa has a Student Council (SC) comprising nine members. In addition, various bodies constituted by the College also has student representatives. The SC under aegis of Dean, students affairs plans and organizes various co-curricular and extra-curricular activities of the college in association with the college academic committee. Towards this end, various designated committees, viz., Organizing committee, Reception committee, Hospitality committee, Technical Events committee, Campaigning/Public Relations committee, Discipline committee, Cultural programmes committee, Sports committee, Prize Distribution committee, Magazine committee and such others are involved in the organization of Orientation programmes, Fresher�s Day, Alphamatica, Bhaswara, Vaisheshika, Vibgyor and Vibes. In each committee, at least two student representatives/volunteers attend meetings as and when called for. In addition, Mother Teresa celebrates regional, national and international commemoration days and festivals wherein, SC members are involved in the smooth conduct of the events.\r\n"
//			+ "\r\n"
//			+ "SC also contributes to the enhancement of the learning experiences of students through various clubs, namely, Literary, Science, Coding, Mathematical, Fine arts, Photography, Solar, Robotics, Environment, and Srujanastra. Each club is managed by students with the help of a faculty advisor. Various events pertaining to the concerned club are organized after the college hours on regular working days, as well as on Saturdays. In addition, it also facilitates organization of various technical activities through professional bodies namely, Computer Society of India (CSI), Institute of Electrical and Electronic Engineers (IEEE), Institute of Electronics and Telecommunication Engineering (IETE), Indian Society for Technical Education (ISTE) and Society for Automotive Engineering (SAE).\r\n"
//			+ " \r\n"
//			+ "The SC assists in organizing NSS activities of the college, which include conducting various health camps, distribution of school uniforms, books etc for needy children of nearby villages, distribution of various items at old-age homes, facilitating training for development of vocational skills in the people in nearby places, etc.\r\n"
//			+ "\r\n"
//			+ "In addition to the above-mentioned activities, the SC provides necessary help by reaching out appropriate tutorials to the students studying in nearby schools. It also organizes awareness programmes on health, education and environment. In association with NGOs, the SC facilitates conduct of cataract surgeries, organizes blood donation, health/dental camps and distributes medicines. As part of environment campaign, Handmade paper bags were made and distributed, making them aware of the hazards of plastic usage and its consequent disastrous effects on environment. Towards the promotion of Green revolution, every year, SC organizes tree plantation programmes in the nearby villages.\r\n"
//			+ "\r\n"
//			+ "Student representatives are also nominated on the anti-ragging committee, grievance redressal cell and women protection cell. The Entrepreneurship development cell also has SC members with a faculty advisor, to organize various events under the National Entrepreneurship Network (NEN).\r\n"
//			+ "\r\n"
//			+ "IQAC has a representative each from students and alumni. BoS of each department consists of Alumni members.\r\n"
//			+ "Class Review Committees also have student representatives for obtaining feedback on the Teaching- Learning process.\r\n"
//			+ "\r\n"
//			+ "On the whole, the Students Council is a dynamic Body that contributes a great deal to the development of students and institution alike."
//			+ "",
//	font5));

//table101criteria5.addCell(cell0119);
//table101criteria5.addCell(cell0120);

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
	
//	PdfPCell cell8800criteria5 = new PdfPCell(
//					new Paragraph(
//			"5.3.3.1 Number of sports and cultural events / competitions organised by the institution year - wise during the last five years.",font4));
	

	table121criteria5.addCell(cell880criteria5);
	//table121criteria5.addCell(cell8800criteria5);
	
	table121criteria5.setSpacingBefore(20f);
	table121criteria5.setSpacingAfter(20f);

	document.add(table121criteria5);

	document.add(table012criteria5);


//table121criteria5.addCell(table012criteria5);

//	if (criteria5Record.getYearTable5331() != null) {
//
//		Table table5331 = new Table(criteria5Record.getYearTable5331().size(), 2);
//
//		table5331.setPadding(5);
//		table5331.setWidth(100f);
//
//		for (int i = 0; i < criteria5Record.getYearTable5331().size(); i++) {
//			
//			Cell cell121criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5331().get(i).getInput5331y(),font5));
//			cell121criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table5331.addCell(cell121criteria5);
//		}
//		for (int i = 0; i < criteria5Record.getYearTable5331().size(); i++) {
//			
//			
//			Cell cell1215criteria5 = new Cell(new Paragraph(criteria5Record.getYearTable5331().get(i).getInput5331v(),font5));
//			cell1215criteria5.setHorizontalAlignment(Element.ALIGN_CENTER);
//			table5331.addCell(cell1215criteria5);
//		}
//
//		document.add(table5331);
//	}
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
	
	

//PdfPCell cell0255 = new PdfPCell(new Paragraph(
//	"* Alumni members are made members of Boards of Studies of various departments. They contribute in the curriculum design. They examine the current curriculum and give suggestions vis-a-vis the industry-institution interface requirements.\r\n"
//			+ "* They also give advice on the establishment of laboratories, which involve experiments using modern tools for improved employability of students.\r\n"
//			+ "* Alumni members are invited to deliver technical talks and provide career guidance to the students. Alumni members help the students in establishing a network of support for their professional career progression, namely, higher education in India and abroad, internships and placements.\r\n"
//			+ "* Alumni working in various industries connect the placement cell of the college to their respective industries, thereby, facilitate the college with opportunities for internships and placements of students.\r\n"
//			+ "* In addition, they also connect the industry-institute interaction cell of the college, facilitating industrial visits, internships for students and resource persons for student development and faculty development programs.\r\n"
//			+ "* Alumni promote the college at various fora, thereby serving as brand ambassadors of the college, by making the audience aware about the salient features of the college as well as important developments that have been taking place in the college over the years.\r\n"
//			+ "* Alumni working in various R & D establishments connect the faculty of the college to their professional seniors, facilitating testing requirements of, as part of research carried out by faculty, and also in the preparation of research proposals being submitted by the college for various funding agencies.\r\n"
//			+ "* Alumni, who pursued higher education abroad, help the students in securing admissions in the universities, where they have studied, through preparation of statement of purpose, research projects and funds available with various professors in universities. This information is extremely useful for students, since, they can approach the professors by explicitly mentioning their research interests, which may perhaps improve their chances of securing scholarship with full or partial tuition fee waiver.\r\n"
//			+ "* Alumni of the college have donated certain resources/facilities to college for students use.\r\n"
//			+ "",
//	font5));
	table131.addCell(cell0244);
  // table131.addCell(cell0255);

//	table131.addCell(table013);

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
//	table1311.addCell(table0131);

	table1311.setSpacingBefore(20f);
	table1311.setSpacingAfter(20f);

	document.add(table1311);
	document.add(table0131);
	}

	//////////////////// 6.1///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////
	public void Criteria6(Document document, Criteria6_FieldInfo criteria6Fieldinfo) {
		Paragraph paragraph1criteria6 = new Paragraph("Criterion 6 - Governance, Leadership and Management\r\n",
				font1);
		paragraph1criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
		document.add(paragraph1criteria6);
		
		Paragraph paragraphlinecriteria6 = new Paragraph("___________________________________________________________________________");
		paragraphlinecriteria6.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraphlinecriteria6);

		// 6.1

		Paragraph paragraph2criteria6 = new Paragraph("6.1	Institutional Vision and Leadership\r\n", font2);
		paragraph2criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph2criteria6);

		// create a table 1
		PdfPTable table1criteria6 = new PdfPTable(2);
		table1criteria6.setWidthPercentage(100);
		PdfPTable table11 = new PdfPTable(1);
		table11.setWidthPercentage(100);
		PdfPCell cell1criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell1criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell2criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell1criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell3criteria6 = new PdfPCell(new Paragraph("Any aditional information", font5));
		cell1criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell4criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
		cell1criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1criteria6.addCell(cell1criteria6);
		table1criteria6.addCell(cell2criteria6);
		table1criteria6.addCell(cell3criteria6);
		table1criteria6.addCell(cell4criteria6);

		
		table1criteria6.setSpacingBefore(20f);
		table1criteria6.setSpacingAfter(20f);

		
		PdfPCell cell410criteria6 = new PdfPCell(new Paragraph(
				"6.1.1: The institutional governance and leadership are in accordance with \r\n"
				+ "the vision and mission of the Institution and it is visible in various \r\n"
				+ "institutional practices such as NEP implementation, sustained \r\n"
				+ "institutional growth, decentralization, participation in the \r\n"
				+ "institutional governance and in their short term and long term \r\n"
				+ "Institutional Perspective Plan. .\r\n\r\n",
				font4));

		PdfPCell cell4120criteria6 = new PdfPCell(new Paragraph("Response"+
				(criteria6Record != null ? criteria6Record.getCriteria61Ql().get(0).getResponse611() : "")+"\r\n\r\n", font5));

		table11.addCell(cell410criteria6);

		table11.addCell(cell4120criteria6);

		table11.setSpacingBefore(20f);
		table11.setSpacingAfter(20f);

		document.add(table11);
		document.add(table1criteria6);

//	
//		PdfPTable table1criteria611 = new PdfPTable(2);
//		table1criteria611.setWidthPercentage(100);
//		

		PdfPTable table2criteria6 = new PdfPTable(2);
		table2criteria6.setWidthPercentage(100);
		PdfPTable table21criteria6 = new PdfPTable(1);
		table21criteria6.setWidthPercentage(100);

		PdfPCell cell21criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell21criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell22criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell22criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell23criteria6 = new PdfPCell(new Paragraph("Any aditional information\r\n\r\n", font4));
		cell23criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell24criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""), font5));
		cell24criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell25criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n", font5));
		cell25criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell26criteria6 = new PdfPCell(new Paragraph());
		cell26criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell27criteria6 = new PdfPCell(
				new Paragraph("Link for strategic plan and deployment documents on the website\r\n\r\n", font5));
		cell27criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell28criteria6 = new PdfPCell(new Paragraph(""));
		cell28criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2criteria6.addCell(cell21criteria6);
		table2criteria6.addCell(cell22criteria6);
		table2criteria6.addCell(cell23criteria6);
		table2criteria6.addCell(cell24criteria6);
		table2criteria6.addCell(cell25criteria6);
		table2criteria6.addCell(cell26criteria6);
		table2criteria6.addCell(cell27criteria6);
		table2criteria6.addCell(cell28criteria6);

		PdfPCell cell2701criteria6 = new PdfPCell(new Paragraph(
				"6.1.2: The effective leadership is reflected in various institutional practices such as decentralization and participative management.\r\nResponse",
				font4));

		PdfPCell cell271criteria6 = new PdfPCell(new Paragraph(
				(criteria6Record != null ? criteria6Record.getCriteria61Ql().get(0).getResponse612() : ""), font5));

	//	table21criteria6.addCell(cell2701criteria6);
	//	table21criteria6.addCell(cell271criteria6);
		
		table21criteria6.setSpacingAfter(20f);
		table21criteria6.setSpacingBefore(20f);

		document.add(table21criteria6);
		document.add(table2criteria6);

		// 6.2

		Paragraph paragraph11criteria6 = new Paragraph("6.2 Strategy Development and Deployment\r\n\r\n", font2);
		paragraph11criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph11criteria6);
		// create a table 3
		PdfPTable table3criteria6 = new PdfPTable(2);
		table3criteria6.setWidthPercentage(100);
		PdfPTable table31criteria6 = new PdfPTable(1);
		table31criteria6.setWidthPercentage(100);

		PdfPCell cell31criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell31criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell32criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font5));
		cell32criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell33criteria6 = new PdfPCell(
				new Paragraph("Link for Strategic Plan and deployment documents on the website\r\n\r\n", font5));
		cell33criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell34criteria6 = new PdfPCell(new Paragraph(""));
		cell34criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell35criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n", font5));
		cell35criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell36criteria6 = new PdfPCell(new Paragraph(""));
		cell36criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria6.addCell(cell31criteria6);
		table3criteria6.addCell(cell32criteria6);
		table3criteria6.addCell(cell33criteria6);
		table31criteria6.addCell(cell34criteria6);
		table3criteria6.addCell(cell35criteria6);
		table3criteria6.addCell(cell36criteria6);

		PdfPCell cell312 = new PdfPCell(new Paragraph(
				"6.2.1	The institutional perspective plan is effectively deployed and \r\n"
				+ "functioning of the institutional bodies is effective and efficient as \r\n"
				+ "visible from policies, administrative setup, appointment, service \r\n"
				+ "rules, and procedures, etc\r\n\r\n" 
						+ "Response:"
						+ (criteria6Record != null ? criteria6Record.getCriteria62Ql().get(0).getResponse621()
								: ""),
				font4));
		table31criteria6.addCell(cell312);

//		table31criteria6.addCell(table3criteria6);
		table31criteria6.setSpacingAfter(20f);
		document.add(table31criteria6);
		document.add(table3criteria6);

		// create table 4
		PdfPTable table4criteria6 = new PdfPTable(2);
		table4criteria6.setWidthPercentage(100);
		PdfPTable table41criteria6 = new PdfPTable(1);
		table41criteria6.setWidthPercentage(100);

		PdfPCell cell41criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell41criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell42criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell42criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell43criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell43criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell44criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : ""),font5));
		cell44criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell45criteria6 = new PdfPCell(
				new Paragraph("Link to Organogram of the Institution webpage\r\n\r\n",font5));
		cell45criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell46criteria6 = new PdfPCell(new Paragraph(""));
		cell46criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell47criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n",font5));
		cell47criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell48criteria6 = new PdfPCell(new Paragraph(""));
		cell48criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4criteria6.addCell(cell41criteria6);
		table4criteria6.addCell(cell42criteria6);
		table4criteria6.addCell(cell43criteria6);
		table4criteria6.addCell(cell44criteria6);
		table4criteria6.addCell(cell45criteria6);
		table4criteria6.addCell(cell46criteria6);
		table4criteria6.addCell(cell47criteria6);
		table4criteria6.addCell(cell48criteria6);
		table4criteria6.setSpacingAfter(20f);
		table4criteria6.setSpacingBefore(20f);
		PdfPCell cell41x = new PdfPCell(new Paragraph(
				"6.2.2	Institution implements e-governance in its operations \r\n"
				+ "6.2.2.1 e-governance is implemented covering the following areas of \r\n"
				+ "operations:\r\n"
				+ "1. Administration including complaint management\r\n"
				+ "2. Finance and Accounts\r\n"
				+ "3. Student Admission and Support\r\n"
				+ "4. Examinations A. All of the above\r\n"
				+ "B. Any3 of the above\r\n"
				+ "C. Any2 of the above \r\n"
				+ "D. Any1 of the above\r\n"
				+ "E. None of the above "
				+ "Response:"
						+ (criteria6Record != null ? criteria6Record.getCriteria62Ql().get(0).getResponse622()
								: ""),
				font4));
		table41criteria6.addCell(cell41x);

//		table41criteria6.addCell(table4criteria6);
		table41criteria6.setSpacingAfter(20f);
		table41criteria6.setSpacingBefore(20f);

		document.add(table41criteria6);
		document.add(table4criteria6);

		// create table5
		PdfPTable table5criteria6 = new PdfPTable(2);
		table5criteria6.setWidthPercentage(100);
		PdfPTable table51criteria6 = new PdfPTable(1);
		table51criteria6.setWidthPercentage(100);

		PdfPCell cell51criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell51criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell52criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell52criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell53criteria6 = new PdfPCell(new Paragraph("Screen shots of user interfaces\r\n\r\n", font5));
		cell53criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell54criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(3).getCriteria6FilePath() : ""), font5));
		cell54criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		// cell54criteria6.setBackgroundColor(Align:);
		PdfPCell cell55criteria6 = new PdfPCell(
				new Paragraph("Institutional data in prescribed format\r\n\r\n", font5));
		cell55criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell56criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(4).getCriteria6FilePath() : ""), font5));
		cell56criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell57criteria6 = new PdfPCell(
				new Paragraph("ERP (Enterprise Resource Planning) Document\r\n\r\n", font5));
		cell57criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell58criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(5).getCriteria6FilePath() : ""), font5));
		cell58criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell59criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n", font5));
		cell59criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell60criteria6 = new PdfPCell(new Paragraph(""));
		cell60criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
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
								+ "3.	Student Admission and Support\r\n" + "4.Examination\r\n" + "\r\n" + "",
						font4));
		//table51criteria6.addCell(cell51x);
		//table51criteria6.addCell("Response: A. All of the above\r\n\r\n");
		
		table51criteria6.setSpacingAfter(20f);
		table51criteria6.setSpacingBefore(20f);
		
//		table51criteria6.addCell(table5criteria6);
		document.add(table51criteria6);
		document.add(table5criteria6);

		// 6.3

		Paragraph paragraph12criteria6 = new Paragraph("6.3  Faculty Empowerment Strategies\r\n", font2);
		paragraph12criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph12criteria6);
		
		PdfPTable table6criteria61 = new PdfPTable(2);
		table6criteria61.setWidthPercentage(100);
		PdfPTable table61criteria61 = new PdfPTable(1);
		table61criteria61.setWidthPercentage(100);

		PdfPCell cell61criteria61 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell61criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell62criteria61 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell62criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell63criteria61 = new PdfPCell(
				new Paragraph("Strategic Plan and deployment documents on the website\r\n\r\n", font5));
		cell63criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell64criteria61 = new PdfPCell(
				new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
		cell64criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell65criteria61 = new PdfPCell(
				new Paragraph("Paste link for additional Information\n\r\n", font5));
		cell65criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell66criteria61 = new PdfPCell(
				new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
		cell66criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell65criteria611 = new PdfPCell(new Paragraph("Upload any additional information\n\r\n"));
		cell65criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell66criteria611 = new PdfPCell(
				new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
		cell66criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6criteria61.addCell(cell61criteria61);
		table6criteria61.addCell(cell62criteria61);
		table6criteria61.addCell(cell63criteria61);
		table6criteria61.addCell(cell64criteria61);
		table6criteria61.addCell(cell65criteria61);
		table6criteria61.addCell(cell65criteria611);
		table6criteria61.addCell(cell66criteria611);

		table6criteria61.addCell(cell66criteria61);
//		table6criteria61.addCell(cell66criteria61);
		
		PdfPCell cell6611criteria611 = new PdfPCell(
				new Paragraph(
				"6.3.1: The institution has performance appraisal system, effective welfare \r\n"
				+ "measures for teaching and non-teaching staff and avenues for \r\n"
				+ "career development/progression \r\n\r\n",font4));
			
		table61criteria61.addCell(cell6611criteria611);
		
		table61criteria61.setSpacingAfter(20f);
		table61criteria61.setSpacingBefore(20f);
				
		document.add(table61criteria61);

		document.add(table6criteria61);

		// create table6
		PdfPTable table6criteria6 = new PdfPTable(2);
		table6criteria6.setWidthPercentage(100);
		PdfPTable table61criteria6 = new PdfPTable(1);
		table61criteria6.setWidthPercentage(100);

		PdfPCell cell61criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell61criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell62criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell62criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell63criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n", font5));
		cell63criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell64criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
		cell64criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell65criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n", font5));
		cell65criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell66criteria6 = new PdfPCell(
				new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "", font5));
		cell66criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6criteria6.addCell(cell61criteria6);
		table6criteria6.addCell(cell62criteria6);
		table6criteria6.addCell(cell63criteria6);
		table6criteria6.addCell(cell64criteria6);
		table6criteria6.addCell(cell65criteria6);
		table6criteria6.addCell(cell66criteria6);

		table61criteria6.setSpacingAfter(20f);
		table61criteria6.setSpacingBefore(20f);
		
		document.add(table61criteria6);

		// create a table7
		PdfPTable table7criteria6 = new PdfPTable(2);
		table7criteria6.setWidthPercentage(100);
		PdfPTable table71criteria6 = new PdfPTable(1);
		table71criteria6.setWidthPercentage(100);
		PdfPCell cell71criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		
		PdfPCell cell72criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		PdfPCell cell73criteria6 = new PdfPCell(
				new Paragraph("Institutional data in prescribed format\r\n\r\n", font5));
		PdfPCell cell74criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
		PdfPCell cell75criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n", font5));
		PdfPCell cell76criteria6 = new PdfPCell(new Paragraph(""));
		table7criteria6.addCell(cell71criteria6);
		table7criteria6.addCell(cell72criteria6);
		table7criteria6.addCell(cell73criteria6);
		table7criteria6.addCell(cell74criteria6);
		table7criteria6.addCell(cell75criteria6);
		table7criteria6.addCell(cell76criteria6);

		PdfPCell cell741criteria6 = new PdfPCell(
				new Paragraph(
				"Percentage of teachers provided financial support to attend \r\n"
				+ "conferences/workshops and towards membership fee of professional \r\n"
				+ "bodies during the last five years"
						+ (criteria6Record != null ? criteria6Record.getCriteria63Qn().get(0).getResponse632()
								: "")+"\r\n\r\n",font4));
		
		PdfPCell cell74111criteria6 = new PdfPCell(
				new Paragraph(
				"6.3.2.1 Number of teachers provided with financial support to attend \r\n"
				+ "conferences/workshops and towards membership fee of professional \r\n"
				+ "bodies year-wise during the last five years"
						+ "",font4));

		table71criteria6.addCell(cell741criteria6);
		table71criteria6.addCell(cell74111criteria6);
		
		document.add(table71criteria6);
		document.add(table7criteria6);
				
				
		if (criteria6Record.getYearTable6321() != null) {

			Table table6331criteria6 = new Table(criteria6Record.getYearTable6321().size(), 2);

			table6331criteria6.setPadding(5);
			table6331criteria6.setWidth(100f);

			for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
				
			Cell cell121criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6321().get(i).getInput6321y(),font5));
				
			cell121criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table6331criteria6.addCell(cell121criteria6);
			}
			for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
				
				
				Cell cell1210criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6321().get(i).getInput6321v(),font5));
				cell1210criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6331criteria6.addCell(cell1210criteria6);
			}

			document.add(table6331criteria6);
		}

		table71criteria6.setSpacingAfter(10f);

		// create table 8
		PdfPTable table8criteria6 = new PdfPTable(1);
		table8criteria6.setWidthPercentage(100);
		PdfPTable table81criteria6 = new PdfPTable(2);
		table81criteria6.setWidthPercentage(100);
		PdfPCell cell81criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell81criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell82criteria6 = new PdfPCell(new Paragraph("Document\r\n\r", font4));
		cell82criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell83criteria6 = new PdfPCell(
				new Paragraph("Institutional data in prescribed format\r\n\r\n", font5));
		cell83criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell84criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
		cell84criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell85criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n", font5));
		cell85criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell86criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
		cell86criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		table81criteria6.addCell(cell81criteria6);
		table81criteria6.addCell(cell82criteria6);
		table81criteria6.addCell(cell83criteria6);
		table81criteria6.addCell(cell84criteria6);
		table81criteria6.addCell(cell85criteria6);
		table81criteria6.addCell(cell86criteria6);
//
		PdfPCell cell8x = new PdfPCell(new Paragraph(
				"6.3.3 Percentage of teachers undergoing online/ face-to-face Faculty \r\n"
				+ "Development Programmes (FDPs)/ Management Development \r\n"
				+ "Programmes (MDPs) during the last five years\r\n"
						+ "\r\n\r\n" + ""
						+ (criteria6Record != null ? criteria6Record.getCriteria63Ql().get(0).getResponse633()
								: "")+"\r\n\r\n",
				font4));
//		PdfPCell cell21y = new PdfPCell(
//				new Paragraph("6.3.3: The institution provides seed money to its teachers for research."));
//		document.add(cell21y);
//		PdfPCell cell22y = new PdfPCell(new Paragraph((criteria6Record != null
//				? criteria6Record.getCriteria63Ql().get(0).getInput633t1()
//				: "")));
//		document.add(cell22y);

		PdfPCell cell8y = new PdfPCell(new Paragraph(
				"6.3.3.1: 6.3.3.1: Total number of teachers who have undergone online/ faceto-face Faculty Development Programmes (FDP)/ Management \r\n"
				+ "Development Programs (MDP) during the last five years"
						+ ""+"\r\n\r\n",
				font4));

		// table8criteria6.addCell(cell8x);
		table8criteria6.addCell(cell8x);
		table8criteria6.addCell(cell8y);
		
		table8criteria6.setSpacingAfter(20f);
		table8criteria6.setSpacingBefore(20f);
	
//		document.add(cell8y);
		document.add(table8criteria6);
		document.add(table81criteria6);
		
		// create year table 6331
		if (criteria6Record != null) {

			Table table6331criteria6 = new Table(criteria6Record.getYearTable6331().size(), 2);

			table6331criteria6.setPadding(5);
			table6331criteria6.setWidth(100f);

			for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
				
				
				Cell cell121criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6331().get(i).getInput6331y(),font5));
				cell121criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6331criteria6.addCell(cell121criteria6);
			}
			for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
				
				Cell cell021criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6331().get(i).getInput6331v(),font5));
				cell021criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6331criteria6.addCell(cell021criteria6);
				
			}

		//	document.add(table6331criteria6);
		}
		
		// cretae table 9
		PdfPTable table9criteria6 = new PdfPTable(1);
		table9criteria6.setWidthPercentage(100);
		PdfPTable table91criteria6 = new PdfPTable(2);
		table91criteria6.setWidthPercentage(100);
		PdfPCell cell91criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell91criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell92criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell92criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell93criteria6 = new PdfPCell(
				new Paragraph("Institutional data in prescribed format\r\n\r\n",font5));
		cell93criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell94criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell94criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell95criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell95criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell96criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell96criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell97criteria6 = new PdfPCell(
				new Paragraph("Minutes of the relevant bodies of the Institution\r\n\r\n",font5));
		cell97criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell98criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell98criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell97criteria61 = new PdfPCell(new Paragraph(
				"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n",font5));
		cell97criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell98criteria61 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell98criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell97criteria611 = new PdfPCell(new Paragraph(
				"List of teachers receiving grant and details of grant received (Data Template)\r\n",font5));
		cell97criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell98criteria611 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell98criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
		table91criteria6.addCell(cell91criteria6);
		table91criteria6.addCell(cell92criteria6);
		table91criteria6.addCell(cell93criteria6);
		table91criteria6.addCell(cell94criteria6);
		table91criteria6.addCell(cell95criteria6);
		table91criteria6.addCell(cell96criteria6);
		table91criteria6.addCell(cell97criteria6);
		table91criteria6.addCell(cell98criteria6);
		table91criteria6.addCell(cell97criteria61);
		table91criteria6.addCell(cell98criteria61);
		table91criteria6.addCell(cell97criteria611);
		table91criteria6.addCell(cell98criteria611);

		PdfPCell cell9x = new PdfPCell(new Paragraph(
				"6.3.4 Average percentage of teachers undergoing online/ face-to-face Faculty Development Programmes (FDP)during the last five years (Professional Development Programmes, Orientation / Induction Programmes, Refresher Course, Short Term Course ).\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria6Record != null ? criteria6Record.getCriteria63Qn().get(0).getResponse634()
								: "")+"\r\n\r\n",
				font4));
		
		PdfPCell cell9y = new PdfPCell(new Paragraph(
				"6.3.4.1 Total number of teachers attending professional development Programmes, viz., Orientation Programme, Refresher Course, Short Term Course, Faculty Development Programmes year wise during last five years"
						+ ""+"\r\n\r\n",
				font4));
	//	table9criteria6.addCell(cell9x);
//		table9criteria6.addCell(cell9y);

		table9criteria6.setSpacingAfter(20f);
		table9criteria6.setSpacingBefore(20f);
		
		
		
		document.add(table9criteria6);
		document.add(table91criteria6);

//		Paragraph paragraph1criteria613 = new Paragraph(
//				"6.3.4: The institution provides seed money to its teachers for research.\r\n");
//		document.add(paragraph1criteria613);
////		Paragraph paragraph1criteria614= new Paragraph((criteria6Record != null
////				? criteria6Record.getCriteria63Qn().get(0).getin()
////				: ""));
////		document.add(paragraph1criteria614);
//
//		Paragraph paragraph1criteria615 = new Paragraph(
//				"6.3.4.1: The amount of seed money provided by institution to its teachers for research year wise during last five years (INR in lakhs)"
//						+ "",
//				font3);
//		document.add(paragraph1criteria615);

		// create table 6341
		if (criteria6Record != null) {

			Table table6341criteria6 = new Table(criteria6Record.getYearTable6341().size(), 2);

			table6341criteria6.setPadding(5);
			table6341criteria6.setWidth(100f);

			for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
			
				Cell cell101criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6341().get(i).getInput6341y(),font5));
				cell101criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6341criteria6.addCell(cell101criteria6);
			}
			for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
				Cell cell1010criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6341().get(i).getInput6341v(),font5));
				cell1010criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6341criteria6.addCell(cell1010criteria6);
			}

//			document.add(table6341criteria6);
		}


		// 6.4

		Paragraph paragraph13criteria6 = new Paragraph(
				"6.4	Financial Management and Resource Mobilization\r\n\r\n", font2);
		paragraph13criteria6.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(paragraph13criteria6);
		// create table10
		PdfPTable table10criteria6 = new PdfPTable(2);
		table10criteria6.setWidthPercentage(100);
		PdfPTable table101criteria6 = new PdfPTable(1);
		table101criteria6.setWidthPercentage(100);

		PdfPCell cell101criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell101criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell102criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell102criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell103criteria6 = new PdfPCell(
				new Paragraph("Strategic Plan and deployment documents on the website",font5));
		cell103criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell104criteria6 = new PdfPCell(
				new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell104criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell103criteria61 = new PdfPCell(new Paragraph("Paste link for additional Information",font5));
		cell103criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell104criteria61 = new PdfPCell(
				new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell98criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell103criteria611 = new PdfPCell(new Paragraph("Upload any additional information",font5));
		cell103criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell104criteria611 = new PdfPCell(
				new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell104criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
		table10criteria6.addCell(cell101criteria6);
		table10criteria6.addCell(cell102criteria6);
		table10criteria6.addCell(cell103criteria6);
		table10criteria6.addCell(cell104criteria6);
		table10criteria6.addCell(cell103criteria61);
		table10criteria6.addCell(cell104criteria61);
		table10criteria6.addCell(cell103criteria611);
		table10criteria6.addCell(cell104criteria611);
//		table101criteria6.addCell(table10criteria6);
		
		
		PdfPCell cell10x = new PdfPCell(new Paragraph(
				"6.4.1	Institutional strategies for mobilisation of funds other than salary \r\n"
				+ "and fees and the optimal utilisation of resources" + "", font4));
		table101criteria6.addCell(cell10x);

		
		table101criteria6.setSpacingAfter(20f);
		table101criteria6.setSpacingBefore(20f);
		
		table10criteria6.setSpacingAfter(20f);
		table10criteria6.setSpacingBefore(20f);
		
		
		document.add(table101criteria6);
		document.add(table10criteria6);
		
		
		// create table 11

//		Paragraph paragraph13criteria624 = new Paragraph(
//				"6.4.2: Funds / Grants received from non-government bodies, individuals, philanthropists during the last five years (not covered in Criterion III and V) (INR in Lakhs)"
//						+ "\r\n");
//		document.add(paragraph13criteria624);
//		Paragraph paragraph13criteria625 = new Paragraph(
//				criteria6Record != null ? criteria6Record.getCriteria64Qn().get(0).getResponse642() : "");
//		document.add(paragraph13criteria625);

		PdfPTable table11criteria6 = new PdfPTable(1);
		table11criteria6.setWidthPercentage(100);
		PdfPCell cell11x = new PdfPCell(new Paragraph(
				"6.4.2 Funds / Grants received from government bodies, non-government \r\n"
				+ "bodies, and philanthropists during the last five years (not covered in \r\n"
				+ "Criterion III and V) " + ""
						+ (criteria6Record != null ? criteria6Record.getCriteria64Qn().get(0).getInput642t1() : ""),
				font4));
		PdfPCell cell11y = new PdfPCell(new Paragraph(
				"6.4.2.1 Total Grants received from non-government bodies, individuals, Philanthropers year-wise during the last five years (INR in Lakhs)"
						+ ""+"\r\n\r\n",
				font4));
		table11criteria6.addCell(cell11x);
		table11criteria6.addCell(cell11y);
		document.add(table11criteria6);
		// create table 6421

		if (criteria6Record.getYearTable6421() != null) {

			Table table6421 = new Table(criteria6Record.getYearTable6421().size(), 2);

			table6421.setPadding(5);
			table6421.setWidth(100f);

			for (int i = 0; i < criteria6Record.getYearTable6421().size(); i++) {
				
				Cell cell100criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6421().get(i).getInput6421y(),font5));
				
				cell100criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6421.addCell(cell100criteria6);
			}
			if (criteria6Record.getYearTable6341() != null) {
				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
					
					Cell cell12criteria6 = new Cell(new Paragraph(criteria6Record.getYearTable6421().get(i).getInput6421v(),font5));
					cell12criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6421.addCell(cell12criteria6);
					
				}
			} else {

				for (int i = 0; i < criteria6Record.getYearTable6421().size(); i++) {
					table6421.addCell("-");
				}
			}

			document.add(table6421);
		}

		PdfPTable table111criteria6 = new PdfPTable(2);
		table111criteria6.setWidthPercentage(100);
		PdfPCell cell111criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell111criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell112criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell112criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell113criteria6 = new PdfPCell(
				new Paragraph("Institutional data in prescribed format\r\n\r\n\r", font5));
		cell113criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell114criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
		cell114criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell115criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n", font5));
		cell115criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell116criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
		cell116criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell117criteria6 = new PdfPCell(new Paragraph("Annual statements of accounts\r\n\r\n", font5));
		cell117criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell118criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
		cell118criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell119criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n", font5));
		cell119criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell120criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""), font5));
		cell120criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
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
		
		table111criteria6.setSpacingAfter(20f);
		table111criteria6.setSpacingBefore(20f);
		
		document.add(table111criteria6);
		// CREATE TABLE12
		PdfPTable table12criteria6 = new PdfPTable(1);
		table12criteria6.setWidthPercentage(100);
		PdfPTable table121x = new PdfPTable(1);
		table121x.setWidthPercentage(100);

		PdfPCell cell12Y = new PdfPCell(new Paragraph(
				"6.4.3 Institution conducts internal and external financial audits regularly\r\n\r\n",
				font4));
		table12criteria6.addCell(cell12Y);
		document.add(table12criteria6);
//		table121x.addCell(table12criteria6);
//		document.add(table121x);


		// create table 121

//		Paragraph paragraph13criteria626 = new Paragraph(
//				"6.4.3: Institutional strategies for mobilisation of funds and the optimal utilisation of resources"
//						+ "\r\n" + "Response:");
//		document.add(paragraph13criteria626);
//		Paragraph paragraph13criteria627 = new Paragraph(
//				criteria6Record != null ? criteria6Record.getCriteria64Ql().get(0).getResponse643() : "");
//		document.add(paragraph13criteria627);

		PdfPTable table121criteria6 = new PdfPTable(2);
		table121criteria6.setWidthPercentage(100);
		PdfPCell cell121criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell121criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell122criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell122criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell123criteria6 = new PdfPCell(
				new Paragraph("Strategic Plan and deployment documents on the website\r\n",font5));
		cell123criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell124criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell124criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell123criteria61 = new PdfPCell(new Paragraph("Paste link for additional Information\r\n",font5));
		cell123criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell124criteria61 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell124criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell123criteria611 = new PdfPCell(new Paragraph("Upload any additional information\r\n",font5));
		cell123criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell124criteria611 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell124criteria611.setHorizontalAlignment(Element.ALIGN_CENTER);
		table121criteria6.addCell(cell121criteria6);
		table121criteria6.addCell(cell122criteria6);
		table121criteria6.addCell(cell123criteria6);
		table121criteria6.addCell(cell124criteria6);
		table121criteria6.addCell(cell123criteria61);
		table121criteria6.addCell(cell124criteria61);
		table121criteria6.addCell(cell123criteria611);
		table121criteria6.addCell(cell124criteria611);
		
		table121criteria6.setSpacingAfter(20f);
		table121criteria6.setSpacingBefore(20f);
		document.add(table121criteria6);

		// 6.5

		Paragraph paragraph14criteria6 = new Paragraph("6.5	Internal Quality Assurance System\r\n\r\n", font2);
		paragraph14criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph14criteria6);
		// cretae table 13
		PdfPTable table13criteria6 = new PdfPTable(1);
		table13criteria6.setWidthPercentage(100);
//
		PdfPCell cell13x = new PdfPCell(new Paragraph(
				"6.5.1 Internal Quality Assurance Cell (IQAC) has contributed significantly for institutionalizing the quality assurance strategies and processes visible in terms of � Incremental improvements made for the preceding five years with regard to quality (in case of first cycle) Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives (second and subsequent cycles)\r\n"
						+ "\r\n\r\n" + "Response"
						+ (criteria6Record != null ? criteria6Record.getCriteria65Qn().get(0).getResponse651()
								: "")+"\r\n\r\n",
				font4));
		table13criteria6.addCell(cell13x);
		document.add(table13criteria6);
		// create table 2reforms
		PdfPTable table131criteria6 = new PdfPTable(2);
		table131criteria6.setWidthPercentage(100);

		PdfPTable table130criteria6 = new PdfPTable(1);
		table130criteria6.setWidthPercentage(100);

		PdfPCell cell131criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell131criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell132criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell132criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell133criteria6 = new PdfPCell(new Paragraph("Any additional information",font5));
		cell133criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell134criteria6 = new PdfPCell(
				new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell134criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell133criteria61 = new PdfPCell(new Paragraph("Any additional information",font5));
//		cell133criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell134criteria61 = new PdfPCell(
//				new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
//		cell134criteria61.setHorizontalAlignment(Element.ALIGN_CENTER);
		table131criteria6.addCell(cell131criteria6);
		table131criteria6.addCell(cell132criteria6);
		table131criteria6.addCell(cell133criteria6);
		table131criteria6.addCell(cell134criteria6);
//		table131criteria6.addCell(cell133criteria61);
//		table131criteria6.addCell(cell134criteria61);
//		table130criteria6.addCell(table131criteria6);
		table130criteria6.setSpacingAfter(20f);
		table130criteria6.setSpacingBefore(20f);
		
		
		document.add(table130criteria6);
		
		
		
		PdfPTable table14criteria6 = new PdfPTable(1);
		table14criteria6.setWidthPercentage(100);
		PdfPCell cell14x = new PdfPCell(new Paragraph(
				"6.5.2 The institution reviews its teaching learning process, structures & methodologies of operations and learning outcomes at periodic intervals through IQAC set up as per norms and recorded the incremental improvement in various activities ( For first cycle - Incremental improvements made for the preceding five years with regard to quality For second and subsequent cycles - Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives )\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria6Record != null ? criteria6Record.getCriteria65Ql().get(0).getResponse652()
								: "")+"\r\n\r\n",
				font4));
		table14criteria6.addCell(cell14x);
		
		table14criteria6.setSpacingBefore(20f);
		table14criteria6.setSpacingAfter(20f);
		
		
		document.add(table14criteria6);
		// create a table 141
		PdfPTable table140criteria6 = new PdfPTable(1);
		table140criteria6.setWidthPercentage(100);

		document.add(table140criteria6);
		PdfPTable table141criteria6 = new PdfPTable(2);
		table141criteria6.setWidthPercentage(100);
		PdfPCell cell141criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell141criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell142criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell142criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell143criteria6 = new PdfPCell(
				new Paragraph("Strategic Plan and deployment documents on the website\r\n",font5));
		cell143criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell144criteria6 = new PdfPCell(
				new Paragraph((criteria6file != null ? criteria6file.get(17).getCriteria6FilePath() : ""),font5));
		cell144criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell143criteria622 = new PdfPCell(new Paragraph("Upload any additional information\r\n",font5));
		cell143criteria622.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell144criteria622 = new PdfPCell(
				new Paragraph((criteria6file != null ? criteria6file.get(17).getCriteria6FilePath() : ""),font5));
		cell144criteria622.setHorizontalAlignment(Element.ALIGN_CENTER);
		table141criteria6.addCell(cell141criteria6);
		table141criteria6.addCell(cell142criteria6);
		table141criteria6.addCell(cell143criteria6);
		table141criteria6.addCell(cell144criteria6);
		table141criteria6.addCell(cell143criteria622);
		table141criteria6.addCell(cell144criteria622);
		
		table141criteria6.setSpacingAfter(20f);
		table141criteria6.setSpacingBefore(20f);
		
		
		document.add(table141criteria6);

		// create table 15
		PdfPTable table15criterion6 = new PdfPTable(1);
		table15criterion6.setWidthPercentage(100);
		PdfPCell cell15x = new PdfPCell(
				new Paragraph("6.5.3	Quality assurance initiatives of the institution include: 1. Regular meeting of Internal Quality Assurance Cell (IQAC); \r\n"
						+ "quality improvement initiatives identified and implemented\r\n"
						+ "2. Academic and Administrative Audit (AAA) and follow-up \r\n"
						+ "action taken\r\n"
						+ "3. Collaborative quality initiatives with other institution(s)\r\n"
						+ "4. Participation in NIRF and other recognized rankings\r\n"
						+ "5. Any other quality audit recognized by state, national or \r\n"
						+ "international agencies  Options:\r\n"
						+ "A. Any 4 or more of the above\r\n"
						+ "B. Any 3 of the above\r\n"
						+ "C. Any 2 of the above"
						+ " D. Any 1 of the above\r\n"
						+ "E. None of the above\r\n" + "\r\n"
						
						+ (criteria6Record != null ? criteria6Record.getCriteria65Qn().get(0).getResponse653()
								: "")+"\r\n\r\n",
						font4));
		table15criterion6.addCell(cell15x);
		document.add(table15criterion6);
		// cretae653
		PdfPTable table151criterion6 = new PdfPTable(2);
		table151criterion6.setWidthPercentage(100);
		PdfPCell cell151 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell151.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell152 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell152.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell153 = new PdfPCell(new Paragraph("Paste web link of Annual reports of Institution\r\n",font5));
		cell153.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell154 = new PdfPCell(
				new Paragraph(criteria6file != null ? criteria6file.get(1).getCriteria6FilePath() : "",font5));
		cell154.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell155 = new PdfPCell(
				new Paragraph("Upload e-copies of the accreditations and certifications\r\n",font5));
		cell155.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell156 = new PdfPCell(
				new Paragraph(criteria6file != null ? criteria6file.get(1).getCriteria6FilePath() : "",font5));
		cell156.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell157 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n",font5));
		cell157.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell158 = new PdfPCell(
				new Paragraph(criteria6file != null ? criteria6file.get(1).getCriteria6FilePath() : "",font5));
		cell158.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell159 = new PdfPCell(
				new Paragraph("Upload details of quality assurance initiatives of the institution\r\n",font5));
		cell159.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell160 = new PdfPCell(
				new Paragraph(criteria6file != null ? criteria6file.get(1).getCriteria6FilePath() : "",font5));
		cell160.setHorizontalAlignment(Element.ALIGN_CENTER);

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
		table151criterion6.setSpacingBefore(10f);
		document.add(table151criterion6);
		}

	public void Criteria7(Document document, Criteria7_FieldInfo criteria7Fieldinfo) {	
		// 7.1

		Paragraph paragraphcriteria7 = new Paragraph("Criterion 7 - Institutional Values and Best Practices\r\n",
				font1);
		paragraphcriteria7.setAlignment(Paragraph.ALIGN_CENTER);
	
		document.add(paragraphcriteria7);
		
		Paragraph paragraphlinecriteria7 = new Paragraph("_______________________________________________________________",
				font1);
		paragraphcriteria7.setAlignment(Paragraph.ALIGN_CENTER);
	
		document.add(paragraphlinecriteria7);
		
		Paragraph paragraph2criteria7 = new Paragraph("7.1 Institutional Values and Social Responsibilities\r\n\r\n", font2);
		paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		
		document.add(paragraph2criteria7);

		PdfPTable table711criteria7 = new PdfPTable(1);
		table711criteria7.setWidthPercentage(100f);

//
		PdfPCell cell711criteria7 = new PdfPCell(new Paragraph(
				"7.1.1	Institution has initiated the Gender Audit and measures for the \r\n"
				+ "promotion of gender equity during the last five years\r\n\r\n"
				 + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse711()
								: "")+"\r\n\r\n",
				font4));

	table711criteria7.addCell(cell711criteria7);
		
		document.add(table711criteria7);

	
		PdfPCell cell8 = new PdfPCell();
		cell8.setPadding(8);
		document.add(cell8);
		// table
		PdfPTable tablecriteria7 = new PdfPTable(2);
		tablecriteria7.setWidthPercentage(100f);

		

		PdfPCell cell111criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell111criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell112criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell112criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1113criteria7 = new PdfPCell(new Paragraph("Annual gender sensitization action plan\r\n\r\n",font5));
		cell1113criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1114criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell1114criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell115criteria7 = new PdfPCell(new Paragraph("Specific facilities provided for women in terms\r\n"
				+ "of: a.Safety and security b.Counselling c.Common\r\n"
				+ "Rooms d. Day care center for young children e.\r\n" + "Any other relevant information/r/n/r/n",font5));
		cell115criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell116criteria7 = new PdfPCell(new Paragraph(""));
		cell116criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		tablecriteria7.addCell(cell111criteria7);
		tablecriteria7.addCell(cell112criteria7);
		tablecriteria7.addCell(cell1113criteria7);
		tablecriteria7.addCell(cell1114criteria7);
		tablecriteria7.addCell(cell115criteria7);
		tablecriteria7.addCell(cell116criteria7);
		tablecriteria7.setSpacingBefore(20f);
		tablecriteria7.setSpacingAfter(20f);

		document.add(tablecriteria7);
	
		

		// table1
		PdfPTable table1criteria7 = new PdfPTable(2);
		PdfPTable table1criteria71 = new PdfPTable(1);

		table1criteria7.setWidthPercentage(100f);
		table1criteria71.setWidthPercentage(100f);

		// com.lowagie.text.Font font1 =FontFactory.getFont(FontFactory.TIMES_ROMAN);
		// font1.setColor(CMYKColor.BLACK);

		PdfPCell cell113criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell113criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell114criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell114criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell11104criteria7 = new PdfPCell(new Paragraph("Geotagged Photographs\r\n\r\n",font5));
		cell11104criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1117criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell1117criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1190criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
		cell1190criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1191criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell1191criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

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
								: "")+"\r\n\r\n",
				font4));

		table1criteria71.addCell(cell071);

//		table1criteria71.addCell(table1criteria7);

		table1criteria71.setSpacingBefore(20f);
		table1criteria71.setSpacingAfter(20f);

		document.add(table1criteria71);
		document.add(table1criteria7);

//		PdfPCell cell6criteria7 = new PdfPCell();
//		cell6criteria7.setPadding(5);
//		document.add(cell6criteria7);

		
		PdfPTable table2criteria7 = new PdfPTable(2);
		PdfPTable table20criteria7 = new PdfPTable(1);
		
		table2criteria7.setWidthPercentage(100);
		table20criteria7.setWidthPercentage(100);

	
	
		PdfPCell cell51criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell51criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell52criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell52criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell53criteria7 = new PdfPCell(new Paragraph(
				"Relevant documents like agreements/MoUs with Government and other approved agencies\r\n\r\n", font5));
		cell53criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell54criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""), font5));
		cell54criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell55criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n ", font5));
		cell55criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell56criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""), font5));
		cell56criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell57criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n", font5));
		cell57criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell58criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""), font5));
		cell58criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table2criteria7.addCell(cell51criteria7);
		table2criteria7.addCell(cell52criteria7);
		table2criteria7.addCell(cell53criteria7);
		table2criteria7.addCell(cell54criteria7);
		table2criteria7.addCell(cell55criteria7);
		table2criteria7.addCell(cell56criteria7);
		table2criteria7.addCell(cell57criteria7);
		table2criteria7.addCell(cell58criteria7);
		
		
		
		PdfPCell cell0071 = new PdfPCell(new Paragraph(
				"7.1.3 Describe the facilities in the Institution for the management of the following types of\r\n\"\r\n"
				+ "degradable and non-degradable waste (within 500 words)"+ "Response:"+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse713()
								: "")+"\r\n\r\n ",
				font4));
		
		table20criteria7.addCell(cell0071);
//		table20criteria7.addCell(table2criteria7);
		table20criteria7.setSpacingBefore(20f);
		table20criteria7.setSpacingAfter(20f);

		document.add(table20criteria7);
		document.add(table2criteria7);

		

	

		PdfPTable table3criteria7 = new PdfPTable(2);
		PdfPTable table3criteria71 = new PdfPTable(1);
		table3criteria7.setWidthPercentage(100f);
		table3criteria71.setWidthPercentage(100f);

		
		

		PdfPCell cell61criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell61criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell62criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell62criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell63criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n",font5));
		cell63criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell64criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell64criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell65criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
		cell65criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell66criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell66criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		table3criteria7.addCell(cell61criteria7);
		table3criteria7.addCell(cell62criteria7);
		table3criteria7.addCell(cell63criteria7);
		table3criteria7.addCell(cell64criteria7);
		table3criteria7.addCell(cell65criteria7);
		table3criteria7.addCell(cell66criteria7);
		
		
		
		
		PdfPCell cell0073 = new PdfPCell(new Paragraph("7.1.4: Water conservation facilities available in the Institution:\r\n"
				+ "1. Rain water harvesting\r\n"
				+ "2. Borewell /Open well recharge\r\n"
				+ "3. Construction of tanks and bunds\r\n"
				+ "4. Waste water recycling\r\n"
				+ "5. Maintenance of water bodies and distribution system in the campus\r\n\r\n"+ "Response:"
				+ (criteria7Record != null ? criteria7Record.getCriteria71Qn().get(0).getResponse714()
						: "")+"\r\n\r\n",
				font4));
		table3criteria71.addCell(cell0073);
//		table3criteria71.addCell(table3criteria7);

		table3criteria71.setSpacingBefore(20f);
		table3criteria71.setSpacingAfter(20f);

		document.add(table3criteria71);
		document.add(table3criteria7);

		

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
		PdfPCell cell67criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell67criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell68criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell68criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell69criteria7 = new PdfPCell(
				new Paragraph("Geotagged photos / videos of the facilities\r\n\r\n",font5));
		cell69criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell70criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell70criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell71criteria7 = new PdfPCell(new Paragraph("Various policy documents / decisions circulated for implementation\r\n\r\n",font5));
		cell71criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell72criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell72criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell73criteria7 = new PdfPCell(new Paragraph("Any other relevant documents\r\n\r\n",font5));
		cell73criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell74criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell74criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		table6criteria7.addCell(cell67criteria7);
		table6criteria7.addCell(cell68criteria7);
		table6criteria7.addCell(cell69criteria7);
		table6criteria7.addCell(cell70criteria7);
		table6criteria7.addCell(cell71criteria7);
		table6criteria7.addCell(cell72criteria7);
		table6criteria7.addCell(cell73criteria7);
		table6criteria7.addCell(cell74criteria7);

		PdfPCell cell073 = new PdfPCell(new Paragraph("7.1.5	Green campus initiatives include " + "Response:"
				+ (criteria7Record != null ? criteria7Record.getCriteria71Qn().get(0).getResponse715()
						: "")+"\r\n\r\n",
				font4));

	table6criteria72.addCell(cell073);

//		table6criteria72.addCell(table6criteria7);

		table6criteria72.setSpacingBefore(20f);
		table6criteria72.setSpacingAfter(20f);

		document.add(table6criteria72);
		document.add(table6criteria7);

		

		PdfPTable table15criteria7 = new PdfPTable(2);
		PdfPTable table15criteria73 = new PdfPTable(1);

		table15criteria7.setWidthPercentage(100f);
		table15criteria73.setWidthPercentage(100f);

		PdfPCell cell75criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
		cell75criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell76criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
		cell76criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell77criteria7 = new PdfPCell(
				new Paragraph("Reports on environment and energy audits\r\n" + "submitted by the auditing agency\r\n\r\n",font5));
		cell77criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell78criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell78criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell79criteria7 = new PdfPCell(new Paragraph("Certification by the auditing agency\r\n\r\n",font5));
		cell79criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell80criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell80criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell81criteria7 = new PdfPCell(new Paragraph("Certificates of the awards received\r\n\r\n",font5));
		cell81criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell82criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell82criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell83criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
		cell83criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell84criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell84criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

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
				"7.1.6	Quality audits on environment and energy are regularly undertaken \r\n"
				+ "by the institution\r\n"
				+ "7.1.6.1.The institutional environment and energy initiatives are \r\n"
				+ "confirmed through the following \r\n"
				+ "1. Green audit / Environmental audit\r\n"
				+ "2. Energy audit \r\n"
				+ "3.Clean and green campus recognitions/awards \r\n"
				+ "4. Beyond the campus environmental promotion and sustainability \r\n"
				+ "activities \r\n"
				+ "Options:\r\n"
				+ "A. All of the above\r\n"
				+ "B. Any 3 of the above\r\n"
				+ "C. Any 2 of the above\r\n"
				+ "D. Any 1of the above\r\n"
				+ "E. None of the above"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse716()
								: "")+"\r\n\r\n",
				font4));

		table15criteria73.addCell(cell074);

//		table15criteria73.addCell(table15criteria7);

		table15criteria73.setSpacingBefore(20f);
		table15criteria73.setSpacingAfter(20f);

		document.add(table15criteria73);
		document.add(table15criteria7);
		

		// 7.1.7 table
		PdfPTable table17criteria7 = new PdfPTable(2);
		PdfPTable table17criteria73 = new PdfPTable(1);

		table17criteria7.setWidthPercentage(100f);
		table17criteria73.setWidthPercentage(100f);
		
		PdfPCell cell85criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
		cell85criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell86criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
		cell86criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell87criteria7 = new PdfPCell(
				new Paragraph("Geotagged photographs / videos of the facilities\r\n",font5));
		cell87criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell88criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell88criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell89criteria7 = new PdfPCell(new Paragraph("Policy documents and information brochures on the support to be provided\r\n\r\n",font5));
		cell89criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell90criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell90criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell91criteria7 = new PdfPCell(
				new Paragraph("Details of the Software procured for providing the assistance\r\n\r\n",font5));
		cell91criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell92criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell92criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell93criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
		cell93criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell94criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell94criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

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
				new Paragraph("7.1.7 The Institution has Differently-abled (Divyangjan) friendly, barrier \r\n"
						+ "free environment"
						+ "\r\n" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse717()
								: "")+"\r\n\r\n",
						font4));

		table17criteria73.addCell(cell075);

//		table17criteria73.addCell(table17criteria7);

		table17criteria73.setSpacingBefore(20f);
		table17criteria73.setSpacingAfter(20f);

		document.add(table17criteria73);
		document.add(table17criteria7);


		// 7.1.8 table
		
		


		PdfPTable table18criteria7 = new PdfPTable(2);
		PdfPTable table108criteria7 = new PdfPTable(1);
		
		table18criteria7.setWidthPercentage(100f);
		table108criteria7.setWidthPercentage(100f);
		
		PdfPCell cell95criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell95criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell96criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell96criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell97criteria7 = new PdfPCell(
				new Paragraph("Policy documents and information brochures on the\r\n support to be provided\r\n\r\n",font5));
		cell97criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell98criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell98criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell99criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n",font5));
		cell99criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell100criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell100criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell101criteria7 = new PdfPCell(
				new Paragraph("Details of the Software procured for providing the" + "assistance\r\n\r\n",font5));
		cell101criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell102criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell102criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell103criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
		cell103criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell104criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell104criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

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
		

		PdfPCell cell0075 = new PdfPCell(
				new Paragraph("7.1.8: Describe the Institutional efforts/initiatives in providing an inclusive \r\n"
						+ "environment i.e., tolerance and harmony towards cultural, regional, \r\n"
						+ "linguistic, communal socioeconomic and such other diversities "
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse718()
								: "")+"\r\n\r\n",
						font4));
		table108criteria7.addCell(cell0075);
//		table108criteria7.addCell(table18criteria7);
	
		table108criteria7.setSpacingBefore(20f);
		table108criteria7.setSpacingAfter(20f);

		document.add(table108criteria7);
		document.add(table18criteria7);

	
		
		/*
		 * Font fontParagraph2147 = FontFactory.getFont(FontFactory.HELVETICA);
		 * fontParagraph2147.setSize(12);
		 */
		
		
		// 7.1.1.9 table
		
		PdfPTable table19criteria7 = new PdfPTable(2);
		PdfPTable table109criteria7 = new PdfPTable(1);
		
		table19criteria7.setWidthPercentage(100f);
		table109criteria7.setWidthPercentage(100f);
		
		
		PdfPCell cell105criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell105criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell106criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell106criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell107criteria7 = new PdfPCell(new Paragraph("Details of activities that inculcate values; necessary to render students in to responsible citizens\r\n\r\n",font5));
		cell107criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell108criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell108criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell109criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
		cell109criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell110criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell110criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		table19criteria7.addCell(cell105criteria7);
		table19criteria7.addCell(cell106criteria7);
		table19criteria7.addCell(cell107criteria7);
		table19criteria7.addCell(cell107criteria7);
		table19criteria7.addCell(cell108criteria7);
		table19criteria7.addCell(cell109criteria7);
		table19criteria7.addCell(cell110criteria7);
		
		PdfPCell cell00075 = new PdfPCell(
				new Paragraph(" 7.1.9: Sensitization of students and employees of the Institution to the \r\n"
						+ "constitutional obligations: values, rights, duties and responsibilities \r\n"
						+ "of citizens\r\n"
						+ ""
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse719()
								: "")+"\r\n\r\n",
						font4));
		
		table109criteria7.addCell(cell00075);
//		table109criteria7.addCell(table19criteria7);
		
		table109criteria7.setSpacingBefore(20f);
		table109criteria7.setSpacingAfter(20f);
		document.add(table109criteria7);
		document.add(table19criteria7);

	
		// 7.1.10 table

		PdfPTable table31criteria7 = new PdfPTable(2);
		PdfPTable table31criteria74 = new PdfPTable(1);

		table31criteria7.setWidthPercentage(100);
		table31criteria74.setWidthPercentage(100);

		
		PdfPCell cell1111 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
		cell1111.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1112 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
		cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell11113 = new PdfPCell(new Paragraph(
				" Code of ethics policy document\r\n\r\n",font5));
		cell11113.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell11114 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell11114.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell1115 = new PdfPCell(new Paragraph("Details of the monitoring committee composition and minutes of the committee meeting, number of programmes organized, reports on the various programs etc., in support of the claims\r\n\r\n",font5));
		cell1115.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1116 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell1116.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell11117 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n",font5));
		cell11117.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1118 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell1118.setHorizontalAlignment(Element.ALIGN_CENTER);

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
								: "")+"\r\n\r\n",
				font4));

	table31criteria74.addCell(cell076);

//		table31criteria74.addCell(table31criteria7);

		table31criteria74.setSpacingBefore(20f);
		table31criteria74.setSpacingAfter(20f);

		document.add(table31criteria74);

		document.add(table31criteria7);

	
		PdfPTable table7111criteria7 = new PdfPTable(1);
		table7111criteria7.setWidthPercentage(100f);


		PdfPCell cell7111criteria7 = new PdfPCell(new Paragraph(
				"7.1.11 Institution celebrates / organizes national and international commemorative days, events and festivals (within 500 words).\r\n\r\n"
						+ "\r\n" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse7111()
								: "")+"\r\n\r\n",
				font4));
	//	table7111criteria7.addCell(cell7111criteria7);
		table7111criteria7.setSpacingBefore(20f);
		table7111criteria7.setSpacingAfter(20f);

		document.add(table7111criteria7);
		
		

		
	
	
	
		
		// table 4
		PdfPTable table4criteria7 = new PdfPTable(2);
		table4criteria7.setWidthPercentage(100);

		
		PdfPCell cell1119criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell1119criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1120criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell1120criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1121criteria7 = new PdfPCell(new Paragraph("Annual report of the celebrations and commemorative events for the last five years\r\n\r\n",font5));
		cell1121criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1122criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell1122criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell1123criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of some of the events\r\n\r\n",font5));
		cell1123criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1124criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell1124criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1125criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
		cell1125criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1126criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell1126criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		
		table4criteria7.addCell(cell1119criteria7);
		table4criteria7.addCell(cell1120criteria7);
		table4criteria7.addCell(cell1121criteria7);
		table4criteria7.addCell(cell1122criteria7);
		table4criteria7.addCell(cell1123criteria7);
		table4criteria7.addCell(cell1124criteria7);
		table4criteria7.addCell(cell1125criteria7);
		table4criteria7.addCell(cell1126criteria7);

		

	//	document.add(table4criteria7);
		
		
		// 7.2 
		
		PdfPTable table721criteria7 = new PdfPTable(1);
		table721criteria7.setWidthPercentage(100f);

		PdfPCell cell721criteria7 = new PdfPCell(new Paragraph(
				"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format provided in the Manual.\r\n"
						+ "\r\n\r\n"
						+ (criteria7Record != null
								? criteria7Record.getCriteria72Ql().get(0).getResponse721()
								: "")+"\r\n\r\n",
				font4));
		table721criteria7.addCell(cell721criteria7);
		table721criteria7.setSpacingBefore(20f);
		table721criteria7.setSpacingAfter(20f);

		document.add(table721criteria7);

		PdfPTable table5criteria7 = new PdfPTable(2);
		table5criteria7.setWidthPercentage(100);

		PdfPCell cell1110 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell1110.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1134 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell1134.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1135 = new PdfPCell(
				new Paragraph("Best practices in the Institutional web site\r\n\r\n ",font5));
		cell1135.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1136 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell1136.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1137 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n ",font5));
		cell1137.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1138 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell1138.setHorizontalAlignment(Element.ALIGN_CENTER);

		table5criteria7.addCell(cell1110);
		table5criteria7.addCell(cell1134);
		table5criteria7.addCell(cell1135);
		table5criteria7.addCell(cell1136);
		table5criteria7.addCell(cell1137);
		table5criteria7.addCell(cell1138);

	

		document.add(table5criteria7);
		
		
		// 7.3 
		Paragraph paragraph88 = new Paragraph("7.3 Institutional Distinctiveness\r\n", font2);
		document.add(paragraph88);


	

		PdfPTable table731criteria7 = new PdfPTable(1);
		table731criteria7.setWidthPercentage(100f);

		
		PdfPCell cell731criteria7 = new PdfPCell(new Paragraph(
				"7.3.1 Portray the performance of the Institution in one area distinctive to its priority and thrust within 1000 words\r\n"
						+ "\r\n\r\n" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria73Ql().get(0).getResponse731()
								: "")+"\r\n\r\n",
				font4));

		table731criteria7.addCell(cell731criteria7);
		table731criteria7.setSpacingBefore(20f);
		table731criteria7.setSpacingAfter(20f);

		document.add(table731criteria7);

		
		

		// table6
		

		

		PdfPTable table7criteria7 = new PdfPTable(2);

		table7criteria7.setWidthPercentage(100f);
		
		PdfPCell cell22criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
		cell22criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell23criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
		cell23criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell24criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
		cell24criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell25criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell25criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell26criteria7 = new PdfPCell(new Paragraph("Appropriate web in the Institutional websit\r\n\r\n",font5));
		cell26criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell27criteria7 = new PdfPCell(new Paragraph(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "",font5));
		cell27criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);


		table7criteria7.addCell(cell22criteria7);
		table7criteria7.addCell(cell23criteria7);
		table7criteria7.addCell(cell24criteria7);
		table7criteria7.addCell(cell25criteria7);
		table7criteria7.addCell(cell26criteria7);
		table7criteria7.addCell(cell27criteria7);

		
		document.add(table7criteria7);
}

}
