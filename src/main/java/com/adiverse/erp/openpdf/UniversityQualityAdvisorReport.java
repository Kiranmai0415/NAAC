package com.adiverse.erp.openpdf;

import java.awt.Color;
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
import org.springframework.stereotype.Service;

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

@Service
public class UniversityQualityAdvisorReport {

	@Value("${logoImgPath}")
	private String logoImgPath;

	@Value("${logoImgScale}")
	private Float[] logoImgScale;

	public Image headerImage;

	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	Font font0 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

	Font font1criteria3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

	// Font font4=FontFactory.getFont(FontFactory.HELVETICA)
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
	SsrService ssrService;
	@Autowired
	ExtendedService extendedService;

	@Autowired
	ExecutiveService executiveService;

	@Autowired
	QiaService qiservice;
	@Autowired
	EvalutiveReportService evalutiveReportService;
	

	List<ExecutiveSummary> executiveSummary1 = null;
	ExecutiveSummary executiveSummary = null;

	List<Executive_FileUpload> executive_FileUpload1 = null;
	Executive_FileUpload executive_FileUpload = null;

	List<EvaluativereportMain> evaluativereportList = null;
	EvaluativereportMain evaluativereportofthedepartment = null;

	List<QIAIndicatorMain> qIAIndicator = null;
	QIAIndicatorMain qiadata = null;
	List<QIAIndicator2> qIAIndicator1 = null;

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
	List<Criteria3_FieldInfo> criteria3Fieldinfo = null;

	List<Criteria4_FieldInfo> criteria4List = null;
	Criteria4_FieldInfo criteria4Record = null;
	List<Criteria4_FileUpload> criteria4file = null;

	List<Criteria5_FieldInfo> criteria5List = null;
	Criteria5_FieldInfo criteria5Record = null;
	List<Criteria5_FileUpload> criterai5file = null;
	List<Criteria5_FileUpload> criteria5file = null;

	List<Criteria6_FieldInfo> criteria6List = null;
	Criteria6_FieldInfo criteria6Record = null;
	List<Criteria6_FileUpload> criteria6file = null;

	List<Criteria7_FieldInfo> criteria7List = null;
	Criteria7_FieldInfo criteria7Record = null;
	List<Criteria7_FileUpload> criteria7file = null;

	List<ProfileoftheCollege> profileList = null;
	ProfileoftheCollege ssrData = null;
	List<EvaluativeFileUpload> Profilefile = null;
	
//	List<ProfileoftheCollege>profileList = null;
//	ProfileoftheCollege ProfileRecord = null;
//	List<EvaluativeFileUpload> evaluativeFileUpload = null;
	

	List<ExtendedProfile> epList = null;
	ExtendedProfile extendedProfile = null;
	// List<Criteria7_FileUpload> criteria7file =
	// criteria7Record.getCriteria7FileUpload();

	@Value("${upload.files.path}")
	private String reportGeneratePath;

	public String generateReport(Map<String, String> allParams) throws DocumentException, IOException {

		System.out.println("data======>");

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

			Font font0 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font0.setSize(16);

			Font font1criteria3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font1criteria3.setSize(14);

			Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font2.setSize(12);

			System.out.println("start");


			profileList = ssrService.getAllAcademicData(allParams);
			if (CollectionUtils.isNotEmpty(profileList)) {
				ssrData = profileList.get(0);
			} else {
				ssrData = new ProfileoftheCollege();
			}
			
			
//			evaluativereportList = evalutiveReportService.getAllEvaluativeData(allParams);
//			if (CollectionUtils.isNotEmpty(profileList)) {
//				evaluativereportList = evaluativereportList.get(0);
//			} else {
//				evaluativereportList = new EvaluativereportMain();
//			}
//		

			executiveSummary1 = executiveService.getAllExecutiveData(allParams);
			System.out.println("executiveService");
			if (CollectionUtils.isNotEmpty(executiveSummary1)) {
				executiveSummary = executiveSummary1.get(0);
			} else {
				executiveSummary = new ExecutiveSummary();
			}

			epList = extendedService.getAllExtendedData(allParams);
			System.out.println("extendedService");
			if (CollectionUtils.isNotEmpty(epList)) {
				extendedProfile = epList.get(0);
			} else {
				extendedProfile = new ExtendedProfile();
			}
			
			
			
		
			
			qIAIndicator = qiservice.getAllQiaFiles(allParams);

			System.out.println("criteria1List");
			if (CollectionUtils.isNotEmpty(qIAIndicator)) {
				qiadata = qIAIndicator.get(0);
				qIAIndicator1 = qiadata.getQiaIndicator2();
			} else {
				criteria1Record = new Criteria1_FieldInfo();
				criteria1file = new ArrayList<Criteria1_FileUpload>();
			}

			

			criteria1List = service1.getAllCriteria1Data(allParams);

			System.out.println("criteria1List");
			if (CollectionUtils.isNotEmpty(criteria1List)) {
				criteria1Record = criteria1List.get(0);
				criteria1file = criteria1Record.getCriteria1FileUpload();
			} else {
				criteria1Record = new Criteria1_FieldInfo();
				criteria1file = new ArrayList<Criteria1_FileUpload>();
			}

			criteria2List = service2.getAllCriteria2Data(allParams);
			System.out.println("criteria2List");
			if (CollectionUtils.isNotEmpty(criteria2List)) {
				criteria2Record = criteria2List.get(0);
				criteria2file = criteria2Record.getCriteria2FileUpload();
			} else {
				criteria2Record = new Criteria2_FieldInfo();
				criteria2file = new ArrayList<>();
			}
			
			
			
			
			
			

			criteria3FieldInfoList = service3.getAllCriteria3Data(allParams);
			System.out.println("data is =====");
			System.out.println("criteria3List====>");
		
			if (CollectionUtils.isNotEmpty(criteria3FieldInfoList)) {

				criteria3Record=criteria3FieldInfoList.get(0);
				
//				criteria3_FieldInfoQnList = criteria3FieldInfoList.get(0).getCriteria3FieldInfoQn();
//				criteria3_FieldInfoQlList = criteria3FieldInfoList.get(0).getCriteria3FieldInfoQl();
				criteria3file = criteria3Record.getCriteria3FileUpload();
			} else {
				criteria3Record = new Criteria3_FieldInfo();
				criteria3file = new ArrayList<>();
			}

			criteria4List = service4.getAllCriteria4Data(allParams);
			System.out.println("criteria4List");
			if (CollectionUtils.isNotEmpty(criteria4List)) {
				criteria4Record = criteria4List.get(0);
				criteria4file = criteria4Record.getCriteria4FileUpload();
			} else {
				criteria4Record = new Criteria4_FieldInfo();
				criteria4file = new ArrayList<>();
			}

			criteria5List = service5.getAllCriteria5Data(allParams);
			System.out.println("criteria5List");
			if (CollectionUtils.isNotEmpty(criteria5List)) {
				criteria5Record = criteria5List.get(0);
				criterai5file = criteria5Record.getCriteria5FileUpload();
			} else {
				criteria5Record = new Criteria5_FieldInfo();
				criterai5file = new ArrayList<>();
			}

			criteria6List = service6.getAllCriteria6Data(allParams);
			System.out.println("criteria6List");
			if (CollectionUtils.isNotEmpty(criteria6List)) {
				criteria6Record = criteria6List.get(0);
				criteria6file = criteria6Record.getCriteria6FileUpload();
			} else {
				criteria6Record = new Criteria6_FieldInfo();
				criteria6file = new ArrayList<>();
			}

			criteria7List = service7.getAllCriteria7Data(allParams);
			System.out.println("criteria7List");
			if (CollectionUtils.isNotEmpty(criteria7List)) {
				criteria7Record = criteria7List.get(0);
				criteria7file = criteria7Record.getCriteria7FileUpload();
			} else {
				criteria7Record = new Criteria7_FieldInfo();
				criteria7file = new ArrayList<>();

			}

			epList = extendedService.getAllExtendedData(allParams);
			System.out.println("epList");
			if (CollectionUtils.isNotEmpty(epList)) {
				extendedProfile = epList.get(0);
			} else {
				extendedProfile = new ExtendedProfile();
			}

				
//				profileList=ssrService.getAllAcademicData(allParams);
//				System.out.println("profileList");
//				if (CollectionUtils.isNotEmpty(profileList)) {
//					ProfileRecord = profileList.get(0);
//				} else {
//					ProfileRecord = new ProfileoftheCollege();
//				}

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

			
		 Ssr(document, executiveSummary);
	
		 
		 
			 Iiqa(document);
		Criteria1(document, criteria1Record);
		Criteria2(document, criteria2Record);
	
	 Criteria3(document, criteria3Record);
		Criteria4(document, criteria4Record);
	 Criteria5(document, criteria5Record);
			 Criteria6(document, criteria6Record);
			 Criteria7 (document, criteria7Record);

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}



// executive summary	
		
	public void Ssr(Document document, ExecutiveSummary executiveData) {
		Paragraph paragraph20ssr = new Paragraph("1.EXECUTIVE SUMMARY\r\n", font1);
		Paragraph paragraph21ssr = new Paragraph("1.Introductory Note on the Institution\r\n", font2);
		paragraph20ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		paragraph20ssr.setAlignment(Paragraph.ALIGN_CENTER);
		paragraph21ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
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

		Paragraph paragraph22ssr = new Paragraph(executiveData != null ?executiveData.getInputes1():
				""+"\r\n", font5);
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

		Paragraph paragraph26ssr = new Paragraph(executiveData != null ?executiveData.getInputes2():""+"\r\n",font5);
		
		paragraph26ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph26ssr);

		Paragraph paragraph27ssr = new Paragraph("MISSION", font4);
		paragraph27ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr);

//		Paragraph paragraph28ssr = new Paragraph(
//				"We dedicate and commitment ourselves to achieve, sustain and    foster unmatched excellence in technical education.  To this end, we will pursue continuous development of infrastructure and enhance state of the art equipment to provide our students a technology up to date and intellectually inspiring environment of learning, research, creativity, innovation and professional activity, inculcate in them ethical and moral values. The institute is committed to build a better nation through quality education with team sprit. Our students are enable to excel values of life and become good citizens. We inspire the system, infrastructure and services to satisfy the students, parents, industry and society.\r\n"
//						+ "\r\n" + "\r\n" + "\r\n",
//				font5);
		Paragraph paragraph28ssr = new Paragraph(executiveData != null ?executiveData.getInputes3(): ""+"\r\n",font5);
		
		paragraph28ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr);
		
		
		
		Paragraph paragraph27ssr1 = new Paragraph("Location:", font4);
		paragraph27ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr1);

		Paragraph paragraph28ssr1 = new Paragraph(executiveData != null ?executiveData.getInputes4(): ""+"\r\n",font5);
		
		paragraph28ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr1);
		
		Paragraph paragraph27ssr11 = new Paragraph("Type of the Institution:", font4);
		paragraph27ssr11.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr11);

		Paragraph paragraph28ssr11 = new Paragraph(executiveData != null ?executiveData.getInputes5(): ""+"\r\n",font5);
		
		paragraph28ssr11.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr11);
		
		Paragraph paragraph27ssr111 = new Paragraph("File upload:", font4);
		paragraph27ssr111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr111);

		Paragraph paragraph28ssr111 = new Paragraph(executive_FileUpload != null ?executive_FileUpload.getExecutiveFilePath(): ""+"\r\n",font5);
		
		paragraph28ssr111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr111);
				
		Paragraph paragraph27ssr1111 = new Paragraph("2.Criterion-wise Summary on the Institution:", font4);
		paragraph27ssr1111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr1111);

		Paragraph paragraph28ssr1111 = new Paragraph(executiveData != null ?executiveData.getInputes7(): ""+"\r\n",font5);
		
		paragraph28ssr1111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr1111);
		
		
		Paragraph paragraph27ssr11111 = new Paragraph("3.Brief note on the Strength Weakness Opportunities and Challenges(SWOC) in respect of the Institution:", font4);
		paragraph27ssr11111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr11111);

		Paragraph paragraph28ssr11111 = new Paragraph(executiveData != null ?executiveData.getInputes8(): ""+"\r\n",font5);
		
		paragraph28ssr11111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr11111);
		
		
		Paragraph paragraph27ssr111111 = new Paragraph("4.Any additional information about the Institution other than ones already stated.:", font4);
		paragraph27ssr111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr111111);

		Paragraph paragraph28ssr111111 = new Paragraph(executiveData != null ?executiveData.getInputes9(): ""+"\r\n",font5);
		
		paragraph28ssr111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr111111);
			
		Paragraph paragraph27ssr1111111 = new Paragraph("5.Over all conclusive explication about the institution's functioning:", font4);
		paragraph27ssr1111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr1111111);

		Paragraph paragraph28ssr1111111 = new Paragraph(executiveData != null ?executiveData.getInputes9(): ""+"\r\n",font5);
		
		paragraph28ssr1111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph28ssr1111111);
				
		
////////////////////////////////////////////////Extended Profile------------------>
		

		Paragraph paragraphep = new Paragraph("\r\nExtended Profile of the university College\r\n", font1);
		paragraphep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph1ep = new Paragraph("\r\n1 Program\r\n", font2);
		paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph2ep = new Paragraph(
				"" + "1.1 Number of programs offered year-wise for last five years\r\n", font4);
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

		Table epprogramme = new Table(extendedProfile.getEpYeartable11().size(), 2);

		epprogramme.setPadding(5);
		epprogramme.setWidth(100f);


		for (int i = 0; i < extendedProfile.getEpYeartable11().size(); i++) {
			Cell cell2=new Cell(new Paragraph(extendedProfile.getEpYeartable11().get(i).getInput11y(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epprogramme.addCell(cell2);

		}
		for (int i = 0; i < extendedProfile.getEpYeartable11().size(); i++) {
			Cell cell2=new Cell(new Paragraph(extendedProfile.getEpYeartable11().get(i).getInput11v(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epprogramme.addCell(cell2);

		}

		document.add(epprogramme);
		
//		Paragraph paragraph3ep = new Paragraph("\r\n 1.2\r\n" + "Number of departments offering academic programmes\r\n"
//				+ "Response:" + (epRecord != null ? epRecord.geteTable12v() : ""), font3);
//		paragraph3ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//		document.add(paragraph3ep);

		Paragraph paragraph4ep = new Paragraph("2  Students", font2);
		paragraph4ep.setSpacingBefore(10f);
		paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph4ep);

		Paragraph paragraph5ep = new Paragraph(
				"\r\n" + "2.1 Number of students year-wise during last five years\r\n" , font4);
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

		Table epstudent21 = new Table(extendedProfile.getEpYeartable21().size(), 2);

		epstudent21.setPadding(5);
		epstudent21.setWidth(100f);

		for (int i = 0; i < extendedProfile.getEpYeartable21().size(); i++) {
			Cell cell2=new Cell(new Paragraph(extendedProfile.getEpYeartable21().get(i).getInput21y(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent21.addCell(cell2);
		}
		for (int i = 0; i < extendedProfile.getEpYeartable21().size(); i++) {
			Cell cell2=new Cell(new Paragraph(extendedProfile.getEpYeartable21().get(i).getInput21v(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent21.addCell(cell2);

		}

		document.add(epstudent21);

		Paragraph paragraph6ep = new Paragraph(
				"" + "2.2 Number of outgoing / final year students year-wise during last five years\r\n" + "",
				font4);
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

		Table epstudent22 = new Table(extendedProfile.getEpYeartable22().size(), 2);

		epstudent22.setPadding(5);
		epstudent22.setWidth(100f);

		for (int i = 0; i < extendedProfile.getEpYeartable22().size(); i++) {
			Cell cell2=new Cell(new Paragraph(extendedProfile.getEpYeartable22().get(i).getInput22y(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent22.addCell(cell2);
			

		}
		for (int i = 0; i < extendedProfile.getEpYeartable22().size(); i++) {
			Cell cell2=new Cell(new Paragraph(extendedProfile.getEpYeartable22().get(i).getInput22v(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent22.addCell(cell2);
		}

		document.add(epstudent22);

		Paragraph paragraph7ep = new Paragraph("\r\n"
				+ "2.3 Number of students appeared in the examination conducted by the Institution, year-wise during the last five years\r\n"
				+ "", font4);
		paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph7ep);

		PdfPTable table4ep = new PdfPTable(2);
		table4ep.setWidthPercentage(100);


		Table epstudent23 = new Table(extendedProfile.getEpYeartable23().size(), 2);

		epstudent23.setPadding(5);
		epstudent23.setWidth(100f);

		for (int i = 0; i < extendedProfile.getEpYeartable23().size(); i++) {
			Cell cell2=new Cell(new Paragraph(extendedProfile.getEpYeartable23().get(i).getInput23y(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent23.addCell(cell2);
			

		}
		for (int i = 0; i < extendedProfile.getEpYeartable23().size(); i++) {
			Cell cell2=new Cell(new Paragraph(extendedProfile.getEpYeartable23().get(i).getInput23y(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent23.addCell(cell2);
		}

		document.add(epstudent23);

		Paragraph paragraph8ep = new Paragraph(
				"\r\n" + "\r\n" + "2.4 Number of revaluation applications year-wise during last five years\r\n" + "",
				font4);
		paragraph8ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph8ep);



		Table epstudent24 = new Table(extendedProfile.getEpYeartable24().size(), 2);

		epstudent24.setPadding(5);
		epstudent24.setWidth(100f);

		for (int i = 0; i < extendedProfile.getEpYeartable24().size(); i++) {
			Cell cell2=new Cell(new Paragraph(extendedProfile.getEpYeartable24().get(i).getInput24y(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent24.addCell(cell2);

		}
		for (int i = 0; i < extendedProfile.getEpYeartable24().size(); i++) {
			Cell cell2=new Cell(new Paragraph(extendedProfile.getEpYeartable24().get(i).getInput24y(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent24.addCell(cell2);
		}

		document.add(epstudent24);

		Paragraph paragraph9ep = new Paragraph(" 3. Academic\r\n", font2);
		paragraph9ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph9ep);

		Paragraph paragraph10ep = new Paragraph(
				"\r\n" + "3.1 Number of courses in all programs year-wise during last five years\r\n" + "\r\n" + "",
				font4);
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

		Table epstudent31 = new Table(extendedProfile.getEpYeartable31().size(), 2);

		epstudent31.setPadding(5);
		epstudent31.setWidth(100f);

		for (int i = 0; i < extendedProfile.getEpYeartable31().size(); i++) {
			Cell cell2=new Cell(new Paragraph((extendedProfile.getEpYeartable31().get(i).getInput31y()),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent31.addCell(cell2);

		}
		for (int i = 0; i < extendedProfile.getEpYeartable31().size(); i++) {
			Cell cell2=new Cell(new Paragraph((extendedProfile.getEpYeartable31().get(i).getInput31v()),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent31.addCell(cell2);
			

		}

		document.add(epstudent31);

		Paragraph paragraph11ep = new Paragraph(
				"\r\n" + "\r\n" + "3.2 Number of full time teachers year-wise during the last five years\r\n" + "",
				font4);
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

		Table epstudent32 = new Table(extendedProfile.getEpYeartable32().size(), 2);

		epstudent32.setPadding(5);
		epstudent32.setWidth(100f);

		for (int i = 0; i < extendedProfile.getEpYeartable32().size(); i++) {
			Cell cell2=new Cell(new Paragraph((extendedProfile.getEpYeartable32().get(i).getInput32y()),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent32.addCell(cell2);

		}
		for (int i = 0; i < extendedProfile.getEpYeartable32().size(); i++) {
			Cell cell2=new Cell(new Paragraph((extendedProfile.getEpYeartable32().get(i).getInput32y()),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent32.addCell(cell2);
		}

		document.add(epstudent32);

		Paragraph paragraph12ep = new Paragraph(
				"\r\n" + "3.3 Number of sanctioned posts year-wise during last five years\r\n" + "\r\n" + "", font4);
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

		Table epstudent33 = new Table(extendedProfile.getEpYeartable33().size(), 2);

		epstudent33.setPadding(5);
		epstudent33.setWidth(100f);

		for (int i = 0; i < extendedProfile.getEpYeartable33().size(); i++) {
			Cell cell2=new Cell(new Paragraph((extendedProfile.getEpYeartable33().get(i).getInput33y()),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent33.addCell(cell2);
			
			

		}
		for (int i = 0; i < extendedProfile.getEpYeartable33().size(); i++) {
			Cell cell2=new Cell(new Paragraph((extendedProfile.getEpYeartable33().get(i).getInput33v()),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent33.addCell(cell2);

		}

		document.add(epstudent33);

		Paragraph paragraph13ep = new Paragraph("4 Institution\r\n", font2);
		paragraph13ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph13ep);

		Paragraph paragraph14ep = new Paragraph("\r\n"
				+ "4.1 Number of eligible applications received for admissions to all the programs year-wise during last five years\r\n"
				+ "", font4);
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

		Table epstudent41 = new Table(extendedProfile.getEpYeartable41().size(), 2);

		epstudent41.setPadding(5);
		epstudent41.setWidth(100f);

		for (int i = 0; i < extendedProfile.getEpYeartable41().size(); i++) {
			Cell cell2=new Cell(new Paragraph((extendedProfile.getEpYeartable41().get(i).getInput41y()),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent41.addCell(cell2);
			

		}
		for (int i = 0; i < extendedProfile.getEpYeartable41().size(); i++) {
			Cell cell2=new Cell(new Paragraph((extendedProfile.getEpYeartable41().get(i).getInput41v()),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent41.addCell(cell2);
		}

		document.add(epstudent41);

		Paragraph paragraph15ep = new Paragraph("\r\n"
				+ "4.2 Number of seats earmarked for reserved category as per GOI/State Govt rule year-wise during last five years\r\n\r\n"
				+ "", font4);
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

		Table epstudent42 = new Table(extendedProfile.getEpYeartable42().size(), 2);

		epstudent42.setPadding(5);
		epstudent42.setWidth(100f);

		for (int i = 0; i < extendedProfile.getEpYeartable42().size(); i++) {
			Cell cell2=new Cell(new Paragraph((extendedProfile.getEpYeartable42().get(i).getInput42y()),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent42.addCell(cell2);
		}
		for (int i = 0; i < extendedProfile.getEpYeartable42().size(); i++) {
			Cell cell2=new Cell(new Paragraph((extendedProfile.getEpYeartable42().get(i).getInput42v()),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent42.addCell(cell2);
		}

		document.add(epstudent42);

		Paragraph paragraph16ep = new Paragraph(
				"\r\n" + "4.3 Total number of classrooms and seminar halls Response: 73\r\n" + "", font4);
		
		
		paragraph16ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph16ep);
		Paragraph paragraph16 = new Paragraph(extendedProfile !=null? extendedProfile.geteTable43v():"", font4);
		
		document.add(paragraph16);

		Paragraph paragraph17ep = new Paragraph(
				"\r\n" + "4.4 Total number of computers in the campus for academic purpose Response: 1818\r\n" + "",
				font4);
		paragraph17ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph17ep);
		
		Paragraph paragraph161 = new Paragraph(extendedProfile !=null? extendedProfile.geteTable44v():"",font4);
		document.add(paragraph161);

		Paragraph paragraph18ep = new Paragraph("\r\n"
				+ "4.5 Total Expenditure excluding salary year-wise during last five years ( INR in Lakhs)\r\n" + "",
				font4);
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

		Table epstudent45 = new Table(extendedProfile.getEpYeartable45().size(), 2);

		epstudent45.setPadding(5);
		epstudent45.setWidth(100f);

		for (int i = 0; i < extendedProfile.getEpYeartable45().size(); i++) {
			Cell cell2=new Cell(new Paragraph((extendedProfile.getEpYeartable45().get(i).getInput45y()),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent45.addCell(cell2);
			

		}
		for (int i = 0; i < extendedProfile.getEpYeartable45().size(); i++) {
			Cell cell2=new Cell(new Paragraph((extendedProfile.getEpYeartable45().get(i).getInput45v()),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epstudent45.addCell(cell2);
		}

		//////////////////-----------------------------------------------
		////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////2.PROFILE\

		Paragraph paragraph13ssr = new Paragraph("2.PROFILE\r\n", font1);
		Paragraph paragraph14ssr = new Paragraph("2.1 BASIC INFORMATION\r\n", font2);
		paragraph13ssr.setAlignment(Paragraph.ALIGN_CENTER);
		paragraph14ssr.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph13ssr);
		paragraph14ssr.setSpacingBefore(20f);
		paragraph14ssr.setSpacingAfter(20F);
		
		document.add(paragraph14ssr);

		PdfPTable table01ssr = new PdfPTable(1);
		table01ssr.setWidthPercentage(100f);

		PdfPCell cell01ssr = new PdfPCell(new Paragraph("Name and Address of the College",font4));  	
		cell01ssr.setExtraParagraphSpace(10f);
		cell01ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table01ssr.addCell(cell01ssr);

		PdfPTable table1ssr = new PdfPTable(2);
		table1ssr.setWidthPercentage(100f);
		table1ssr.setWidths(new int[] { 3, 3 });
		table1ssr.setSpacingBefore(5);

		PdfPCell cell1ssr = new PdfPCell(new Paragraph("Name",font4));
		cell1ssr.setExtraParagraphSpace(10f);
		cell1ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell1ssr);


		PdfPCell cell2ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt1(): "",font5)); 	
		cell2ssr.setExtraParagraphSpace(10f);
		cell2ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell2ssr);

		PdfPCell cell3ssr = new PdfPCell(new Paragraph("Address",font4)); 
		cell3ssr.setExtraParagraphSpace(10f);
		cell3ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell3ssr);

		PdfPCell cell4ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt2(): "",font5)); 		
		cell4ssr.setExtraParagraphSpace(10f);
		cell4ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell4ssr);

		PdfPCell cell5ssr = new PdfPCell(new Paragraph("City",font4));
		cell5ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell5ssr);

	PdfPCell cell6ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt3(): "",font5)); 	
	cell6ssr.setExtraParagraphSpace(10f);
	cell6ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell6ssr);

		PdfPCell cell7ssr = new PdfPCell(new Paragraph("State",font4));
		cell7ssr.setExtraParagraphSpace(10f);
		cell7ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell7ssr);

		PdfPCell cell8ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt4(): "",font5)); 		
		cell8ssr.setExtraParagraphSpace(10f);
		cell8ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell8ssr);

		PdfPCell cell9ssr = new PdfPCell(new Paragraph("Pin",font4));
		cell9ssr.setExtraParagraphSpace(10f);
		cell9ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell9ssr);

		PdfPCell cell10ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt5(): "",font5)); 		
		cell10ssr.setExtraParagraphSpace(10f);
		cell10ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell10ssr);

		PdfPCell cell11ssr = new PdfPCell(new Paragraph("Website",font4));
		cell11ssr.setExtraParagraphSpace(10f);
		cell11ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell11ssr);

		PdfPCell cell12ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt6(): "",font5)); 		
		cell12ssr.setExtraParagraphSpace(10f);
		cell12ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell12ssr);

	//	table01ssr.addCell(table1ssr);
	//	table1ssr.setSpacingBefore(20f);

		table1ssr.setSpacingAfter(20f);

		document.add(table01ssr);
		
		document.add(table1ssr);

		PdfPTable table02ssr = new PdfPTable(1);
		table02ssr.setWidthPercentage(100f);

		PdfPCell cell02ssr = new PdfPCell(new Paragraph("Contacts for Communication",font4));  	
	//	cell02ssr.setExtraParagraphSpace(10f);
		cell02ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table02ssr.addCell(cell02ssr);

		PdfPTable table2ssr = new PdfPTable(6);
		table2ssr.setWidthPercentage(100f);
		table2ssr.setWidths(new int[] { 70, 70, 70, 70, 70, 70 });
		table2ssr.setSpacingBefore(20f);
		table2ssr.setSpacingAfter(20f);

		PdfPCell cell = new PdfPCell();

		cell.setPhrase(new Phrase("Designation\r\n",font4));  	cell.setExtraParagraphSpace(10f);
		cell.setExtraParagraphSpace(10f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Name\r\n",font4));  	cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Telephone with STD Code\r\n",font4));  	cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Mobile\r\n",font4));  	cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Fax\r\n",font4));  	cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Email\r\n",font4));  	cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc1(): "",font5)); 		cell.setExtraParagraphSpace(10f);
		cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc2(): "",font5)); 		cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc3(): "",font5)); 		cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc4(): "",font5)); 		cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc5(): "",font5)); 		cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc6(): "",font5)); 		cell.setExtraParagraphSpace(10f);
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

	//	table02ssr.addCell(table2ssr);
	//	table2ssr.setSpacingAfter(20f);
	//	table02ssr.setSpacingBefore(20f);
		document.add(table02ssr);
		
		document.add(table2ssr);

		PdfPTable table03ssr = new PdfPTable(1);
		table03ssr.setWidthPercentage(100f);

		PdfPCell cell03ssr = new PdfPCell(new Paragraph("Nature of University\r\n",font4));  
	//	cell03ssr.setExtraParagraphSpace(10f);
		cell03ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table03ssr.addCell(cell03ssr);

		PdfPTable table3ssr = new PdfPTable(2);
		table3ssr.setWidthPercentage(100f);
		table3ssr.setWidths(new int[] { 70, 70});
		table3ssr.setSpacingBefore(20f);
		table3ssr.setSpacingAfter(20f);

		PdfPCell cell13ssr = new PdfPCell(new Paragraph("Institution Status\r\n",font4));
	//	cell13ssr.setExtraParagraphSpace(10F);
		cell13ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3ssr.addCell(cell13ssr);

		PdfPCell cell14ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti1(): "",font5)); 		cell.setExtraParagraphSpace(10f);
		cell14ssr.setExtraParagraphSpace(10F);
		
		cell14ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3ssr.addCell(cell14ssr);

	//	table03ssr.addCell(table3ssr);
		
	//	table03ssr.setSpacingBefore(20F);
	//	table3ssr.setSpacingAfter(20f);
		document.add(table03ssr);
		document.add(table3ssr);
		
		

		PdfPTable table04ssr = new PdfPTable(1);
		table04ssr.setWidthPercentage(100f);

		PdfPCell cell04ssr = new PdfPCell(new Paragraph("Type of Institution\r\n",font4));  	//cell04ssr.setExtraParagraphSpace(10f);
		cell04ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table04ssr.addCell(cell04ssr);
	
		PdfPTable table4ssr = new PdfPTable(2);
		table4ssr.setWidthPercentage(100f);
		table4ssr.setWidths(new int[] { 3, 3 });
		table4ssr.setSpacingBefore(20f);
		table4ssr.setSpacingAfter(20f);

		PdfPCell cell15ssr = new PdfPCell(new Paragraph("Type of University\r\n",font4));
		
		cell15ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr.addCell(cell15ssr);

		PdfPCell cell16ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti2(): "",font5)); 		cell.setExtraParagraphSpace(10f);
		cell16ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell16ssr.setExtraParagraphSpace(10f);
		table4ssr.addCell(cell16ssr);

//		PdfPCell cell17ssr = new PdfPCell(new Paragraph("By Shift\r\n"));
//		table4ssr.addCell(cell17ssr);
//
//		PdfPCell cell18ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti3(): ""));
//
//
//		table4ssr.addCell(cell18ssr);
//		

	//	table04ssr.addCell(table4ssr);
		
	//	table4ssr.setSpacingAfter(20f);
	//	table04ssr.setSpacingBefore(20f);
		document.add(table04ssr);
		
		document.add(table4ssr);

		PdfPTable table05ssr = new PdfPTable(1);
		table05ssr.setWidthPercentage(100f);

		PdfPCell cell06ssr = new PdfPCell(new Paragraph("Establishment Details\r\n",font4));  
	//	cell06ssr.setExtraParagraphSpace(10f);
		cell06ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table05ssr.addCell(cell06ssr);

		PdfPTable table5ssr = new PdfPTable(2);
		table5ssr.setWidthPercentage(100f);
		table5ssr.setWidths(new int[] { 70, 70 });
		
		table5ssr.setSpacingBefore(20f);
		table5ssr.setSpacingAfter(20f);

		PdfPCell cell07ssr = new PdfPCell(new Paragraph("Date of establishment of the University\r\n",font4));
		cell07ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell07ssr);
		PdfPCell cell20ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti3(): "",font5)); 		
		cell20ssr.setExtraParagraphSpace(10f);
		cell20ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell20ssr);

		PdfPCell cell071ssr = new PdfPCell(new Paragraph("Status Prior to Establishment (if applicable)\r\n",font4));
		cell071ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell071ssr);
		PdfPCell cell201ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti4(): "",font5)); 	
		cell201ssr.setExtraParagraphSpace(10f);
		cell201ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell201ssr);
		
		PdfPCell cell072ssr = new PdfPCell(new Paragraph("Establishment date of the above status\r\n",font4));
		cell072ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell072ssr);
		PdfPCell cell202ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti5(): "",font5)); 		
		cell202ssr.setExtraParagraphSpace(10f);
		cell202ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell202ssr);
		
		
	//	table05ssr.addCell(table5ssr);
		
		
		document.add(table05ssr);
		
		document.add(table5ssr);
		
		
//		table05ssr.setSpacingAfter(20f);
//		table05ssr.setSpacingBefore(20f);

		PdfPTable table06ssr = new PdfPTable(1);
		table06ssr.setWidthPercentage(100f);

		PdfPCell cell08ssr = new PdfPCell(new Paragraph("Establishment Details\r\n",font4)); 
		cell08ssr.setExtraParagraphSpace(10f);
		cell08ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table06ssr.addCell(cell08ssr);
//		table06ssr.setSpacingBefore(20f);
//		table06ssr.setSpacingAfter(20f);
		

		PdfPTable table6ssr = new PdfPTable(2);
		table6ssr.setWidthPercentage(100f);
		table6ssr.setWidths(new int[] { 75, 75 });
		
//		table6ssr.setSpacingBefore(20f);
//		table6ssr.setSpacingAfter(20f);

		PdfPCell cell21ssr = new PdfPCell(
				new Paragraph("Date of Establishment, Prior to the Grant of 'Autonomy'\r\n",font4));
		cell21ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		table6ssr.addCell(cell21ssr);

		PdfPCell cell22ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti4(): "",font5)); 	
		cell22ssr.setExtraParagraphSpace(10f);
		cell22ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6ssr.addCell(cell22ssr);

		PdfPCell cell23ssr = new PdfPCell(new Paragraph("Date of Grant of 'Autonomy' to the college by UGC \r\n",font4));
		cell23ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6ssr.addCell(cell23ssr);

		PdfPCell cell24ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti6(): "",font5)); 	
		cell24ssr.setExtraParagraphSpace(10f);
		cell24ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6ssr.addCell(cell24ssr);

		table4ssr.addCell(cell21ssr);


		table06ssr.addCell(table6ssr);
//		document.add(table06ssr);
		table06ssr.setSpacingAfter(20f);
		table06ssr.setSpacingBefore(20f);

		PdfPTable table010ssr = new PdfPTable(1);
		table010ssr.setWidthPercentage(100f);
		PdfPTable table07ssr = new PdfPTable(1);
		table07ssr.setWidthPercentage(100f);
//
//		PdfPCell cell09ssr = new PdfPCell(new Paragraph("University to which the college is affiliated\r\n\r", font3));
//		table07ssr.addCell(cell09ssr);
//
//		PdfPTable table7ssr = new PdfPTable(3);
//		table7ssr.setWidthPercentage(100f);
//
//		table7ssr.setSpacingBefore(20f);
//		table7ssr.setSpacingAfter(20f);
//
//		cell.setPhrase(new Phrase("State\r\n", font3));
//		table7ssr.addCell(cell);
//		cell.setPhrase(new Phrase("University name\r\n", font3));
//		table7ssr.addCell(cell);
//		cell.setPhrase(new Phrase("Document\r\n", font3));
//		table7ssr.addCell(cell);
if(ssrData.getInstitutionCollegeAffiliated() !=null)
{
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti11(): "",font5)); 	
		cell.setExtraParagraphSpace(10f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti12(): "",font5)); 	
		cell.setExtraParagraphSpace(10f);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti13(): "",font5)); 		
		cell.setExtraParagraphSpace(10f);
}
		cell.setPadding(5);

//		table07ssr.addCell(table7ssr);
		document.add(table07ssr);
		table07ssr.setSpacingAfter(20f);
		table07ssr.setSpacingBefore(20f);

		PdfPTable table08ssr = new PdfPTable(1);
		table08ssr.setWidthPercentage(100f);

		PdfPCell cell121ssr = new PdfPCell(new Paragraph("Details of UGC recognition\r\n",font4));  
	//	cell121ssr.setExtraParagraphSpace(10f);
		cell121ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table08ssr.addCell(cell121ssr);

		PdfPTable table8ssr = new PdfPTable(3);
		table8ssr.setWidthPercentage(100f);
		table8ssr.setWidths(new int[] { 60, 60, 60 });
		
		table8ssr.setSpacingBefore(20f);
		table8ssr.setSpacingAfter(20f);


		cell.setPhrase(new Phrase("Under Section",font4));  	
		cell.setExtraParagraphSpace(10f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase("Date",font4));  	cell.setExtraParagraphSpace(10f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase("View Document",font4));  	cell.setExtraParagraphSpace(10f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table8ssr.addCell(cell);
		//<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
		
		cell.setPhrase(new Phrase("2f of UGC",font4));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table8ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognizationDetails().get(0).getInputbtr6(): "",font5)); 		cell.setExtraParagraphSpace(10f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase());
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase("12B of UGC",font4));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognizationDetails().get(0).getInputbtr6(): "",font5)); 		cell.setExtraParagraphSpace(10f);
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase());
		table8ssr.addCell(cell);

	//	table08ssr.addCell(table8ssr);
		document.add(table08ssr);
		
		document.add(table8ssr);
		table08ssr.setSpacingAfter(20f);
		table08ssr.setSpacingBefore(20f);


//		PdfPTable table09ssr = new PdfPTable(1);
//		table09ssr.setWidthPercentage(100f);
//		PdfPCell cell122ssr = new PdfPCell(new Paragraph(
//				"Details of recognition/approval by stationary/regulatory bodies like AICTE,NCTE,MCI,DCI,PCI,RCI etc(other than UGC)",
//				font3));
//		table09ssr.addCell(cell122ssr);
//		PdfPTable table9ssr = new PdfPTable(5);
//		table9ssr.setWidthPercentage(100f);
//		table9ssr.setWidths(new int[] { 70, 70, 70, 70, 70 });
//		table9ssr.setSpacingBefore(20);
//		table9ssr.setSpacingAfter(20);
//
//		cell.setPhrase(new Phrase("Statutory Regulatory Authority\r\n", font3));
//		table9ssr.addCell(cell);
//		cell.setPhrase(new Phrase("Recognition/App roval details Inst itution/Departme nt programme\r\n", font3));
//		table9ssr.addCell(cell);
//		cell.setPhrase(new Phrase("Day,Month and year(dd-mm- yyyy)\r\n", font3));
//		table9ssr.addCell(cell);
//		cell.setPhrase(new Phrase("Validity in months\r\n", font3));
//		table9ssr.addCell(cell);
//		cell.setPhrase(new Phrase("Remarks\r\n", font3));
//		table9ssr.addCell(cell);
		 
//		if(ssrData.getRecognition() !=null)
//		{
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd15():""));
//		table9ssr.addCell(cell);
//
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd11():""));
//		table9ssr.addCell(cell);
//
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd12():""));
//		table9ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd13():""));
//		table9ssr.addCell(cell);
//
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd14():""));
//		table9ssr.addCell(cell);
//		}
////		cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd16():""));
////		table9ssr.addCell(cell);
//
//
//		cell.setPadding(5);
//		table09ssr.addCell(table9ssr);
//		document.add(table09ssr);
//		table09ssr.setSpacingAfter(20f);
//		table09ssr.setSpacingBefore(20f);

		table010ssr.addCell(table07ssr);
		table010ssr.addCell(table08ssr);
//		table010ssr.addCell(table09ssr);
		table010ssr.setSpacingAfter(20f);
		table010ssr.setSpacingBefore(20f);

		PdfPTable table011ssr = new PdfPTable(1);
		table011ssr.setWidthPercentage(100f);
		PdfPCell cell011ssr = new PdfPCell(new Paragraph("Recognitions\r\n",font4));  
		cell011ssr.setExtraParagraphSpace(10f);
		cell011ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table01ssr.addCell(cell011ssr);
		PdfPTable table11ssr = new PdfPTable(2);
		table11ssr.setWidthPercentage(100f);
		table11ssr.setWidths(new int[] { 3, 3 });
		
		table11ssr.setSpacingBefore(20f);
		table11ssr.setSpacingAfter(20f);

		PdfPCell cell30ssr = new PdfPCell(new Paragraph(
				"Is the College recognized by UGC as a College with Potential for Excellence(CPE)?",font4));
		cell30ssr.setExtraParagraphSpace(10f);
		cell30ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell30ssr);

		PdfPCell cell31ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicprofile2().get(0).getInputbtip1():"",font5)); 		
		cell31ssr.setExtraParagraphSpace(10f);
		cell31ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell31ssr);

//		PdfPCell cell32ssr = new PdfPCell(new Paragraph(
//				"Is the College recognized for its performance by any other governmental agency?\r\n" + "\r\n"));
//		table11ssr.addCell(cell32ssr);
//
//		PdfPCell cell28ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicprofile2().get(0).getInputbtip4():""));
//		table11ssr.addCell(cell28ssr);

//		PdfPCell cell29ssr = new PdfPCell(new Paragraph("If yes, name of the agency\r\n"));
//		table11ssr.addCell(cell29ssr);

//		PdfPCell cell131ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicprofile2().get(0).getInputbtip5():""));
//		table11ssr.addCell(cell131ssr);

//		PdfPCell cell132ssr = new PdfPCell(new Paragraph("Date of recognition\r\n"));
//		table11ssr.addCell(cell132ssr);

//		PdfPCell cell133ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicprofile2().get(0).getInputbtip6():""));
//		table11ssr.addCell(cell133ssr);

	//	table011ssr.addCell(table11ssr);
		document.add(table011ssr);
		document.add(table11ssr);
		
		
		table011ssr.setSpacingAfter(20f);

		PdfPTable table012ssr = new PdfPTable(1);
		table012ssr.setWidthPercentage(100f);

		PdfPCell cell012ssr = new PdfPCell(new Paragraph("Location and Area of Campus\r\n",font4));  	
	//	cell012ssr.setExtraParagraphSpace(10f);
		cell012ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table012ssr.addCell(cell012ssr);

		PdfPTable table12ssr = new PdfPTable(5);
		table12ssr.setWidthPercentage(100f);
		table12ssr.setWidths(new int[] { 60, 60, 60, 60, 60 });
		table12ssr.setSpacingAfter(20f);
		table12ssr.setSpacingBefore(20f);
//
		cell.setPhrase(new Phrase("Campus Type\r\n",font4));  //	cell.setExtraParagraphSpace(10f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase("Address\r\n",font4));  //	cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase("Location\r\n",font4));  //	cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase("Campus Area in Acres\r\n",font4));  //	cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase("Built up Area in sq.mts.\r\n",font4));  	//cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getCampus().get(0).getInputbtl11():"",font5)); 		cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getCampus().get(0).getInputbtl12():"",font5)); 		cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getCampus().get(0).getInputbtl13():"",font5)); 		cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getCampus().get(0).getInputbtl14():"",font5)); 		cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getCampus().get(0).getInputbtl15():"",font5)); 		cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
	
		cell.setPadding(5);

	//	table012ssr.addCell(table12ssr);
		document.add(table012ssr);
		document.add(table12ssr);
		


		////////////////////// accademicInformation

		Paragraph paragraph15ssr = new Paragraph(" ACADEMIC INFORMATION\r\n\r\n", font1);
		paragraph15ssr.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph15ssr);
		PdfPTable table013ssr = new PdfPTable(1);
		table013ssr.setWidthPercentage(100f);
		table013ssr.setSpacingBefore(5);
		PdfPCell cell013ssr = new PdfPCell(new Paragraph(
				"Institutions affiliated to the University (Not applicable for private and deemed to be Universities)", font4));  
		cell013ssr.setExtraParagraphSpace(10f);
		
		cell013ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table013ssr.addCell(cell013ssr);

		PdfPTable table13ssr = new PdfPTable(3);
		table13ssr.setWidthPercentage(100f);
		table13ssr.setWidths(new int[] {60, 60, 60 });
		table13ssr.setSpacingBefore(20f);
		
		PdfPCell cell1 = new PdfPCell();
		cell1.setPhrase(new Phrase("College Type \r\n\r\n", font4)); 
		cell1.setExtraParagraphSpace(10f);
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table13ssr.addCell(cell1);
		cell1.setPhrase(new Phrase("Number of colleges with permanent affiliation", font4)); 
		cell1.setExtraParagraphSpace(10f);
	
		table13ssr.addCell(cell1);
		cell1.setPhrase(new Phrase("Number of colleges with permanent affiliation", font4));
		cell1.setExtraParagraphSpace(10f);
		table13ssr.addCell(cell1);
//		cell.setPhrase(new Phrase("Entry Qualification\r\n\r\n\r\n", font3));
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase("Medium of Instruction\r\n\r\n", font3));
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase("Sanctioned Strength\r\n\r\n", font3));
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase("No.of Students AdmittedSanctioned Strength\r\n\r\n\r\n", font3));
//		table13ssr.addCell(cell);
		
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated().get(0).getInputa1t1():"",font5)); 
		cell1.setExtraParagraphSpace(10f);
		
		table13ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated().get(0).getInputa1t2():"",font5));  
		cell1.setExtraParagraphSpace(10f);
		table13ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated().get(0).getInputa1t3():"",font5));
		cell1.setExtraParagraphSpace(10f);
		table13ssr.addCell(cell1);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad14():""));
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad15():""));
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad16():""));
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad17():""));
		table13ssr.addCell(cell1);
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
		cell1.setPadding(5);
//		table013ssr.addCell(table13ssr);
		table013ssr.setSpacingAfter(10f);
		document.add(table013ssr);
		document.add(table13ssr);
		
		
		
		PdfPTable table131ssr = new PdfPTable(5);
		table131ssr.setWidthPercentage(100f);
		table131ssr.setWidths(new int[] {35,35,35,35,35});
		table131ssr.setSpacingBefore(20f);
		PdfPCell cell11 = new PdfPCell();
		cell11.setPhrase(new Phrase("Type of Colleges\r\n\r\n", font4)); 
		cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase("Permanent\r\n\r\n", font4)); 
		cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
//		cell1.setPhrase(new Phrase("Type of Colleges\r\n\r\n", font3));
//		table131ssr.addCell(cell1);
		cell11.setPhrase(new Phrase("Temporary\r\n\r\n", font4)); 
		cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase("Total\r\n\r\n", font4)); 
		cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase());
		cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase("Education/Teachers Training\r\n\r\n", font4));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(0).getInputa2t1():"",font5));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(0).getInputa2t2():"",font5));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(0).getInputa2t3():"",font5));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(0).getInputa2t4():"",font5));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase("Business administration /Commerce /Management /Finance\r\n\r\n", font4));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(1).getInputa2t1():"",font5));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(1).getInputa2t2():"",font5));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(1).getInputa2t3():"",font5));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(1).getInputa2t4():"",font5));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase("Universal/ Common to all Disciplines\r\n\r\n", font4));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(2).getInputa2t1():"",font5));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(2).getInputa2t2():"",font5));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(2).getInputa2t3():"",font5));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		cell11.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(2).getInputa2t4():"",font5));  cell11.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell11);
		
		
		document.add(table131ssr);
		
		
		Paragraph paragraph151ssr = new Paragraph("Furnish the Details of Number of Colleges under the University",font4);
		
		document.add(paragraph151ssr);
		
		
		PdfPTable table132ssr = new PdfPTable(2);
		table132ssr.setWidthPercentage(100f);
		PdfPCell cell2 = new PdfPCell();
		cell2.setPhrase(new Phrase("Constituent Colleges\r\n\r\n", font4));  cell11.setExtraParagraphSpace(10f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t1():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("Constituent Colleges\r\n\r\n", font4));  cell11.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t2():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("College Under 2(f)\r\n\r\n", font4));  cell11.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t3():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("Collge Under 2(f) and 12B\r\n\r\n", font4));  cell11.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t4():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("NAAC Accredited Colleges\r\n\r\n", font4));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t5():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("Colleges with Potential for Excellence (UGC)\r\n\r\n", font4));  cell11.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t6():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("Autonomous Colleges\r\n\r\n", font4));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t7():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("College with Postgraduate Departments\r\n\r\n", font4));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t8():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("Colleges with Research Departments\r\n\r\n", font4));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t9():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("University Recognized Research Institutes/Centres\r\n\r\n", font4));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t10():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("Does the University Offer any Programmes Recognized by any other Statutory Regulatory authority (SRA)\r\n\r\n", font3));
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t11():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		
		

		Paragraph paragraph16ssr1 = new Paragraph("Details of the Number of Teaching & Non-Teaching Staff in the UniversityTeaching Faculty\r\n\r\n\r\n",
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

		PdfPCell cell014ssr = new PdfPCell(new Paragraph(""));
		cell014ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell015ssr = new PdfPCell(new Paragraph("Professor\r\n",font4));  cell015ssr.setExtraParagraphSpace(10f);
		cell015ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell015ssr.setColspan(4);
		PdfPCell cell0191ssr = new PdfPCell(new Paragraph("Associate Professor\r\n",font4));  cell0191ssr.setExtraParagraphSpace(10f);
		cell0191ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0191ssr.setColspan(4);
		PdfPCell cell0237ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n",font4));  cell0237ssr.setExtraParagraphSpace(10f);
		cell0237ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0237ssr.setColspan(4);
		PdfPCell cell0181ssr = new PdfPCell(new Paragraph(""));
		cell0181ssr.setHorizontalAlignment(Element.ALIGN_CENTER);


		// document.add(cell0192ssr);

		PdfPCell cell0203ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell0203ssr.setExtraParagraphSpace(10f);
		cell0203ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0214ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell0214ssr.setExtraParagraphSpace(10f);
		cell0214ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0225ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell0225ssr.setExtraParagraphSpace(10f);
		cell0225ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0236ssr = new PdfPCell(new Paragraph("Total\r\n",font4));  cell0236ssr.setExtraParagraphSpace(10f);
		cell0236ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0246ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell0246ssr.setExtraParagraphSpace(10f);
		cell0246ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0258ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell0258ssr.setExtraParagraphSpace(10f);
		cell0258ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0269ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell0269ssr.setExtraParagraphSpace(10f);
		cell0269ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0271ssr = new PdfPCell(new Paragraph("Total\r\n",font4));  cell0271ssr.setExtraParagraphSpace(10f);
		cell0271ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0282ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell0282ssr.setExtraParagraphSpace(10f);
		cell0282ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0293ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell0293ssr.setExtraParagraphSpace(10f);
		cell0293ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0304ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell0304ssr.setExtraParagraphSpace(10f);
		cell0304ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0315ssr = new PdfPCell(new Paragraph("Total\r\n",font4));  cell0315ssr.setExtraParagraphSpace(10f);
		cell0315ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0326ssr = new PdfPCell(new Paragraph("Sanctioned\r\n",font4));  cell0326ssr.setExtraParagraphSpace(10f);
		cell0326ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
	
		PdfPCell cell0337sr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat11():"",font5));  cell0337sr.setExtraParagraphSpace(10f);
		cell0337sr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0371ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat12():"",font5));  cell0371ssr.setExtraParagraphSpace(10f);
		cell0371ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0382ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat13():"",font5));  cell0382ssr.setExtraParagraphSpace(10f);
		cell0382ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell cell0333sr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat14():"",font5));  cell0333sr.setExtraParagraphSpace(10f);
        cell0333sr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0375ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat15():"",font5));  cell0375ssr.setExtraParagraphSpace(10f);
		cell0375ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0386ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat16():"",font5));  cell0386ssr.setExtraParagraphSpace(10f);
		cell0386ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell cell03377sr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat17():"",font5));  cell03377sr.setExtraParagraphSpace(10f);
        cell03377sr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0378ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat18():"",font5));  cell0378ssr.setExtraParagraphSpace(10f);
		cell0378ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0389ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat19():"",font5));  cell0389ssr.setExtraParagraphSpace(10f);
		cell0389ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03890ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat10():"",font5));  cell03890ssr.setExtraParagraphSpace(10f);
		cell03890ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
        PdfPCell cell03310sr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat111():"",font5));  cell03310sr.setExtraParagraphSpace(10f);
        cell03310sr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0311ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(0).getInputat112():"",font5));  cell0311ssr.setExtraParagraphSpace(10f);
		cell0311ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		
		PdfPCell cell0394ssr = new PdfPCell(new Paragraph("Recruited",font4));  cell11.setExtraParagraphSpace(10f);
		cell0394ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0405ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat11():"",font5));  cell0405ssr.setExtraParagraphSpace(10f);
		cell0405ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0416ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat12():"",font5));  cell0416ssr.setExtraParagraphSpace(10f);
		cell0416ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0427ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat13():"",font5));  cell0427ssr.setExtraParagraphSpace(10f);
		cell0427ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0438ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat14():"",font5));  cell0438ssr.setExtraParagraphSpace(10f);
		cell0438ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0449ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat15():"",font5));  cell0449ssr.setExtraParagraphSpace(10f);
		cell0449ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0451ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat16():"",font5));  cell0451ssr.setExtraParagraphSpace(10f);
		cell0451ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0452ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat17():"",font5));  cell0452ssr.setExtraParagraphSpace(10f);
		cell0452ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0453ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat18():"",font5));  cell0453ssr.setExtraParagraphSpace(10f);
		cell0453ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0454ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat19():"",font5));  cell0454ssr.setExtraParagraphSpace(10f);
		cell0454ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04540ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat10():"",font5));  cell04540ssr.setExtraParagraphSpace(10f);
		cell04540ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell0455ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat111():"",font5));  cell0455ssr.setExtraParagraphSpace(10f);
		cell0455ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0456ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(1).getInputat112():"",font5));  cell0456ssr.setExtraParagraphSpace(10f);
		cell0456ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell032612ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n\r\n",font4));  cell032612ssr.setExtraParagraphSpace(10f);
		cell032612ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell033722ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat11():"",font5));  cell033722ssr.setExtraParagraphSpace(10f);
		cell033722ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell037212ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat12():"",font5));  cell037212ssr.setExtraParagraphSpace(10f);
		cell037212ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell038312ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat13():"",font5));  cell038312ssr.setExtraParagraphSpace(10f);
		cell038312ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell033721ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat14():"",font5));  cell033721ssr.setExtraParagraphSpace(10f);
		cell033721ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0372121ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat15():"",font5));  cell0372121ssr.setExtraParagraphSpace(10f);
		cell0372121ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0383122ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat16():"",font5));  cell0383122ssr.setExtraParagraphSpace(10f);
		cell0383122ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0337223ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat17():"",font5));  cell0337223ssr.setExtraParagraphSpace(10f);
		cell0337223ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0372124ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat18():"",font5));  cell0372124ssr.setExtraParagraphSpace(10f);
		cell0372124ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0383125ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat19():"",font5));  cell0383125ssr.setExtraParagraphSpace(10f);
		cell0383125ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03831250ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat10():"",font5));  cell03831250ssr.setExtraParagraphSpace(10f);
		cell03831250ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0337226ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat111():"",font5));  cell0337226ssr.setExtraParagraphSpace(10f);
		cell0337226ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0372127ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(2).getInputat112():"",font5));  cell0372127ssr.setExtraParagraphSpace(10f);
		cell0372127ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        
		PdfPCell cell03261ssr = new PdfPCell(
				new Paragraph("Contractual\r\n\r\n",font4));  cell11.setExtraParagraphSpace(10f);
		cell03261ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03371ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat11():"",font5));  cell03371ssr.setExtraParagraphSpace(10f);
		cell03371ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03721ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat12():"",font5));  cell03721ssr.setExtraParagraphSpace(10f);
		cell03721ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03831ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat13():"",font5));  cell03831ssr.setExtraParagraphSpace(10f);
		cell03831ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03372ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat14():"",font5));  cell03372ssr.setExtraParagraphSpace(10f);
		cell03372ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03723ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat15():"",font5));  cell03723ssr.setExtraParagraphSpace(10f);
		cell03723ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03833ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat16():"",font5));  cell03833ssr.setExtraParagraphSpace(10f);
		cell03833ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03374ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat17():"",font5));  cell03374ssr.setExtraParagraphSpace(10f);
		cell03374ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03725ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat18():"",font5));  cell03725ssr.setExtraParagraphSpace(10f);
		cell03725ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03836ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat19():"",font5));  cell03836ssr.setExtraParagraphSpace(10f);
		cell03836ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell038360ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat10():"",font5));  cell038360ssr.setExtraParagraphSpace(10f);
		cell038360ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03377ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat111():"",font5));  cell03377ssr.setExtraParagraphSpace(10f);
		cell03377ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03728ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(3).getInputat112():"",font5));  cell03728ssr.setExtraParagraphSpace(10f);
		cell03728ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
//	
//		PdfPCell cell03941ssr = new PdfPCell(new Paragraph("Recruted\r\n"));
//		PdfPCell cell04052ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat11():""));
//		PdfPCell cell04163ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat12():""));
//		PdfPCell cell04274ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat13():""));
//		PdfPCell cell04385ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat14():""));
//		PdfPCell cell04496ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat15():""));
//		PdfPCell cell04517ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat16():""));
//		PdfPCell cell04528ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat17():""));
//		PdfPCell cell04539ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat18():""));
//		PdfPCell cell04541ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat19():""));
//		PdfPCell cell04552ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat10():""));
//		PdfPCell cell04563ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat111():""));
//		PdfPCell cell04547ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(4).getInputat112():""));
//
//		PdfPCell cell032611ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n"));
//
//		PdfPCell cell0337210ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat11():""));
//		PdfPCell cell037213ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat12():""));
//		PdfPCell cell038314ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat13():""));
//		PdfPCell cell03372101ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat14():""));
//		PdfPCell cell0372132ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat15():""));
//		PdfPCell cell0383143ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat16():""));
//		PdfPCell cell03372104ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat17():""));
//		PdfPCell cell0372135ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat18():""));
//		PdfPCell cell0383146ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat19():""));
//		PdfPCell cell03372107ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat10():""));
//		PdfPCell cell0372138ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat111():""));
//		PdfPCell cell0383149ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicinstitution().get(5).getInputat112():""));
//		

		cell014ssr.setExtraParagraphSpace(10);
		table17ssr.addCell(cell014ssr);
		cell015ssr.setExtraParagraphSpace(10);
		table17ssr.addCell(cell015ssr);
		cell0237ssr.setExtraParagraphSpace(10);
		table17ssr.addCell(cell0237ssr);
	//	table17ssr.addCell(cell0237ssr);
		cell0181ssr.setExtraParagraphSpace(10);
		table17ssr.addCell(cell0181ssr);
		// table17ssr.addCell(cell0192ssr);
		cell0203ssr.setExtraParagraphSpace(10);
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

//		table17ssr.addCell(cell03941ssr);
//		table17ssr.addCell(cell04052ssr);
//		table17ssr.addCell(cell04163ssr);
//		table17ssr.addCell(cell04274ssr);
//		table17ssr.addCell(cell04385ssr);
//		table17ssr.addCell(cell04496ssr);
//		table17ssr.addCell(cell04517ssr);
//		table17ssr.addCell(cell04528ssr);
//		table17ssr.addCell(cell04539ssr);
//		table17ssr.addCell(cell04541ssr);
//		table17ssr.addCell(cell04552ssr);
//		table17ssr.addCell(cell04563ssr);
//		table17ssr.addCell(cell04547ssr);
//
//		table17ssr.addCell(cell032611ssr);
//		table17ssr.addCell(cell0337210ssr);
//		table17ssr.addCell(cell037213ssr);
//		table17ssr.addCell(cell038314ssr);
//		table17ssr.addCell(cell03372101ssr);
//		table17ssr.addCell(cell0372132ssr);
//		table17ssr.addCell(cell0383143ssr);
//		table17ssr.addCell(cell03372104ssr);
//		table17ssr.addCell(cell0372135ssr);
//		table17ssr.addCell(cell0383146ssr);
//		table17ssr.addCell(cell03372107ssr);
//		table17ssr.addCell(cell0372138ssr);
//		table17ssr.addCell(cell0383149ssr);

//		table17ssr.addCell(cell033721ssr);
//		table17ssr.addCell(cell037213ssr);
//		table17ssr.addCell(cell038314ssr);

		
		PdfPCell cell0189ssr = new PdfPCell(new Paragraph("Teaching Staff\r\n",font4)); 
		cell0189ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0189ssr.setExtraParagraphSpace(10);
		table18ssr.addCell(cell0189ssr);


		//table18ssr.addCell(table17ssr);

		// cell015ssr.addElement(new Paragraph(""));
		// cell015ssr.addElement(new Paragraph(""));
		// cell015ssr.addElement(new Paragraph(""));
		// cell015ssr.addElement(new Paragraph(""));

		table17ssr.setSpacingBefore(20f);
		table17ssr.setSpacingAfter(20f);

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
		PdfPCell cell019ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell019ssr.setExtraParagraphSpace(10f);
		cell019ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell020ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell020ssr.setExtraParagraphSpace(10f);
		cell020ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell021ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell021ssr.setExtraParagraphSpace(10f);
		cell021ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell022ssr = new PdfPCell(new Paragraph("Total\r\n",font4));  cell022ssr.setExtraParagraphSpace(10f);
		cell022ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0221ssr = new PdfPCell(new Paragraph("Sanctioned\r\n\r\n",font4));  cell0221ssr.setExtraParagraphSpace(10f);
		cell0221ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0222ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(0).getInputatnt11():"",font5));  cell0222ssr.setExtraParagraphSpace(10f);
		cell0222ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0223ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(0).getInputatnt12():"",font5));  cell0223ssr.setExtraParagraphSpace(10f);
		cell0223ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0224ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(0).getInputatnt13():"",font5));  cell0224ssr.setExtraParagraphSpace(10f);
		cell0224ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0226ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(0).getInputatnt14():"",font5));  cell0226ssr.setExtraParagraphSpace(10f);
		cell0226ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0227ssr = new PdfPCell(new Paragraph("Recruited\r\n",font4)); 
		cell0227ssr.setExtraParagraphSpace(10f);
		cell0227ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0228ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(1).getInputatnt11():"",font5));  cell0228ssr.setExtraParagraphSpace(10f);
		cell0228ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0229ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(1).getInputatnt12():"",font5));  
		cell0229ssr.setExtraParagraphSpace(10f);
		cell0229ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0230ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(1).getInputatnt13():"",font5)); 
		cell0230ssr.setExtraParagraphSpace(10f);
		cell0230ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0231ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(1).getInputatnt14():"",font5)); 
		cell0231ssr.setExtraParagraphSpace(10f);
		cell0231ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0232ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n",font4));  
		cell0232ssr.setExtraParagraphSpace(10f);
		cell0232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0233ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(2).getInputatnt11():"",font5));
		cell0233ssr.setExtraParagraphSpace(10f);
		cell0233ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0234ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(2).getInputatnt12():"",font5)); 
		cell0234ssr.setExtraParagraphSpace(10f);
		cell0234ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0235ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(2).getInputatnt13():"",font5));  
		cell0235ssr.setExtraParagraphSpace(10f);
		cell0235ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0238ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(2).getInputatnt14():"",font5));  
		cell0238ssr.setExtraParagraphSpace(10f);
		cell0238ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0239ssr = new PdfPCell(
				new Paragraph("Contractual\r\n\r\n",font4));  cell11.setExtraParagraphSpace(10f);
		cell0239ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0240ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(3).getInputatnt11():"",font5));
		cell0240ssr.setExtraParagraphSpace(10f);
		cell0240ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0241ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(3).getInputatnt12():"",font5));  
		cell0241ssr.setExtraParagraphSpace(10f);
		cell0241ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0242ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(3).getInputatnt13():"",font5)); 
		cell0242ssr.setExtraParagraphSpace(10f);
		cell0242ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0243ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(3).getInputatnt14():"",font5));  
		cell0243ssr.setExtraParagraphSpace(10f);
		cell0243ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell0244ssr = new PdfPCell(new Paragraph("Recruited\r\n"));
//		PdfPCell cell0245ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(4).getInputatnt11():""));
//		PdfPCell cell0247ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(4).getInputatnt12():""));
//		PdfPCell cell0248ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(4).getInputatnt13():""));
//		PdfPCell cell0249ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(4).getInputatnt14():""));
//		PdfPCell cell0250ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n"));
//		PdfPCell cell0251ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(5).getInputatnt11():""));
//		PdfPCell cell0252ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(5).getInputatnt12():""));
//		PdfPCell cell0253ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(5).getInputatnt13():""));
//		PdfPCell cell0254ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNonTeachingStaff().get(5).getInputatnt14():""));

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
//		table19ssr.addCell(cell0244ssr);
//		table19ssr.addCell(cell0245ssr);
//		table19ssr.addCell(cell0247ssr);
//		table19ssr.addCell(cell0248ssr);
//		table19ssr.addCell(cell0249ssr);
//		table19ssr.addCell(cell0250ssr);
//		table19ssr.addCell(cell0251ssr);
//		table19ssr.addCell(cell0252ssr);
//		table19ssr.addCell(cell0253ssr);
//		table19ssr.addCell(cell0254ssr);


		
        PdfPCell cell0188ssr = new PdfPCell(new Paragraph("Non-Teaching Staff\r\n",font4));  cell11.setExtraParagraphSpace(10f);
        cell0188ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        table20ssr.addCell(cell0188ssr);

	//	table20ssr.addCell(table19ssr);

        table19ssr.setSpacingBefore(20f);
        table19ssr.setSpacingAfter(20f);

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
		PdfPCell cell024ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell024ssr.setExtraParagraphSpace(10f);
		cell024ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell025ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell025ssr.setExtraParagraphSpace(10f);
		cell025ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell026ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell026ssr.setExtraParagraphSpace(10f);
		cell026ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell027ssr = new PdfPCell(new Paragraph("Total\r\n",font4));  cell027ssr.setExtraParagraphSpace(10f);
		cell027ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell0023ssr = new PdfPCell(new Paragraph("Sanctioned\r\n",font4));  cell0023ssr.setExtraParagraphSpace(10f);
		cell0023ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0123ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(0).getInputatt15():"",font5));  cell0123ssr.setExtraParagraphSpace(10f);
		cell0123ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0323ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(0).getInputatt16():"",font5));  cell0323ssr.setExtraParagraphSpace(10f);
		cell0323ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0423ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(0).getInputatt17():"",font5));  cell0423ssr.setExtraParagraphSpace(10f);
		cell0423ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0523ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(0).getInputatt18():"",font5));  cell0523ssr.setExtraParagraphSpace(10f);
		cell0523ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell0623ssr = new PdfPCell(new Paragraph("Recruited\r\n",font4));  cell11.setExtraParagraphSpace(10f);
		cell0623ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0723ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(1).getInputatt15():"",font5));  cell0723ssr.setExtraParagraphSpace(10f);
		cell0723ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0823ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(1).getInputatt16():"",font5));  cell0823ssr.setExtraParagraphSpace(10f);
		cell0823ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0923ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(1).getInputatt17():"",font5));  cell0923ssr.setExtraParagraphSpace(10f);
		cell0923ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01023ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(1).getInputatt18():"",font5));  cell01023ssr.setExtraParagraphSpace(10f);
		cell01023ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell01123ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n",font4));  cell11.setExtraParagraphSpace(10f);
		cell01123ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01223ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(2).getInputatt15():"",font5));  cell01223ssr.setExtraParagraphSpace(10f);
		cell01223ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01323ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(2).getInputatt16():"",font5));  cell01323ssr.setExtraParagraphSpace(10f);
		cell01323ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01423ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(2).getInputatt17():"",font5));  cell01423ssr.setExtraParagraphSpace(10f);
		cell01423ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01523ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(2).getInputatt18():"",font5));  cell01523ssr.setExtraParagraphSpace(10f);
		cell01523ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell01623ssr = new PdfPCell(
				new Paragraph("Contractual\r\n",font4));  cell11.setExtraParagraphSpace(10f);
		cell01623ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01723ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(3).getInputatt15():"",font5));  cell01723ssr.setExtraParagraphSpace(10f);
		cell01723ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01823ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(3).getInputatt16():"",font5));  cell01823ssr.setExtraParagraphSpace(10f);
		cell01823ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01923ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(3).getInputatt17():"",font5));  cell01923ssr.setExtraParagraphSpace(10f);
		cell01923ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02023ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(3).getInputatt18():"",font5));  cell02023ssr.setExtraParagraphSpace(10f);
		cell02023ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

//		PdfPCell cell02123ssr = new PdfPCell(new Paragraph("Recruited\r\n"));
//		PdfPCell cell02223ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(4).getInputatt15():""));
//		PdfPCell cell02323ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(4).getInputatt16():""));
//		PdfPCell cell02423ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(4).getInputatt17():""));
//		PdfPCell cell02523ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(4).getInputatt18():""));
//
//		PdfPCell cell02623ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n"));
//		PdfPCell cell02723ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(5).getInputatt15():""));
//		PdfPCell cell02823ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(5).getInputatt16():""));
//		PdfPCell cell02923ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(5).getInputatt17():""));
//		PdfPCell cell03023ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(5).getInputatt18():""));

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
//		table21ssr.addCell(cell02123ssr);
//		table21ssr.addCell(cell02223ssr);
//		table21ssr.addCell(cell02323ssr);
//		table21ssr.addCell(cell02423ssr);
//		table21ssr.addCell(cell02523ssr);
//		table21ssr.addCell(cell02623ssr);
//		table21ssr.addCell(cell02723ssr);
//		table21ssr.addCell(cell02823ssr);
//		table21ssr.addCell(cell02923ssr);
//		table21ssr.addCell(cell03023ssr);

	
		
	   PdfPCell cell0187ssr = new PdfPCell(new Paragraph("Technical Staff\r\n",font4));  
	   cell0187ssr.setHorizontalAlignment(Element.ALIGN_CENTER);	
	   table22ssr.addCell(cell0187ssr);

	//	table22ssr.addCell(table21ssr);

		table22ssr.setSpacingBefore(20f);
		table22ssr.setSpacingAfter(20f);

		document.add(table22ssr);
		
		document.add(table21ssr);
		
		

		Paragraph paragraph19ssr = new Paragraph("Qualification Details of the Teaching Staff\r\n", font4);
		paragraph19ssr.setSpacingAfter(18f);
		cell02023ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		paragraph19ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph19ssr);

		PdfPTable table23ssr = new PdfPTable(11);
		PdfPTable table24ssr = new PdfPTable(1);
		
		 float[] columnWidths3 = { 70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f }; // Second column will be // twice as first and third
		 table23ssr.setWidths(columnWidths3);
		 
// Setting width of table, its columns and spacing
		table23ssr.setWidthPercentage(100);
		table24ssr.setWidthPercentage(100);

		PdfPCell cell028ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n	",font4));  cell028ssr.setExtraParagraphSpace(10f);
		cell028ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell029ssr = new PdfPCell(new Paragraph("Professor\r\n"));
		cell029ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell029ssr.setColspan(3);
		PdfPCell cell030ssr = new PdfPCell(new Paragraph("Associate Professor\r\n",font4));  cell030ssr.setExtraParagraphSpace(10f);
		cell030ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell030ssr.setColspan(3);
		PdfPCell cell031ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n",font4));  cell031ssr.setExtraParagraphSpace(10f);
		cell031ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell031ssr.setColspan(3);
		PdfPCell cell032ssr = new PdfPCell(new Paragraph(""));
		cell032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0324ssr = new PdfPCell(new Paragraph(""));
		cell0324ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell0132ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell0132ssr.setExtraParagraphSpace(10f);
		cell0132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0332ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell0332ssr.setExtraParagraphSpace(10f);
		cell0332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0432ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell0432ssr.setExtraParagraphSpace(10f);
		cell0432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0532ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell0532ssr.setExtraParagraphSpace(10f);
		cell0532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0632ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell0632ssr.setExtraParagraphSpace(10f);
		cell0632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0732ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell0732ssr.setExtraParagraphSpace(10f);
		cell0732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0832ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell0832ssr.setExtraParagraphSpace(10f);
		cell0832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0932ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell0932ssr.setExtraParagraphSpace(10f);
		cell0932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01032ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell01032ssr.setExtraParagraphSpace(10f);
		cell01032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01132ssr = new PdfPCell(new Paragraph("total\r\n",font4));  cell01132ssr.setExtraParagraphSpace(10f);
		cell01132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell01232ssr = new PdfPCell(new Paragraph("D.sc/D.Litt/ LLD/DM/M CH\r\n",font4));  cell01232ssr.setExtraParagraphSpace(10f);
		cell01232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01332ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(0).getInputatq11():"",font5));  cell01332ssr.setExtraParagraphSpace(10f);
		cell01332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01432ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(0).getInputatq12():"",font5));  cell01432ssr.setExtraParagraphSpace(10f);
		cell01432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01532ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(0).getInputatq13():"",font5));  cell01532ssr.setExtraParagraphSpace(10f);
		cell01532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell01632ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(0).getInputatq14():"",font5));  cell01632ssr.setExtraParagraphSpace(10f);
		cell01632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01732ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(0).getInputatq15():"",font5));  cell01732ssr.setExtraParagraphSpace(10f);
		cell01732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01832ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(0).getInputatq16():"",font5));  cell01832ssr.setExtraParagraphSpace(10f);
		cell01832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01932ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(0).getInputatq17():"",font5));  cell01932ssr.setExtraParagraphSpace(10f);
		cell01932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(0).getInputatq18():"",font5));  cell02032ssr.setExtraParagraphSpace(10f);
		cell02032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02132ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(0).getInputatq19():"",font5));  cell02132ssr.setExtraParagraphSpace(10f);
		cell02132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02232ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(0).getInputatq110():"",font5));  cell02232ssr.setExtraParagraphSpace(10f);
		cell02232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell02332ssr = new PdfPCell(new Paragraph("Ph.D.\r\n",font4));
		cell02332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell02332ssr.setExtraParagraphSpace(5);
		PdfPCell cell02432ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(1).getInputatq11():"",font5));  cell02432ssr.setExtraParagraphSpace(10f);
		cell02432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02532ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(1).getInputatq12():"",font5));  cell02532ssr.setExtraParagraphSpace(10f);
		cell02532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02632ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(1).getInputatq13():"",font5));  cell02632ssr.setExtraParagraphSpace(10f);
		cell02632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell02732ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(1).getInputatq14():"",font5));  cell02732ssr.setExtraParagraphSpace(10f);
		cell02732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02832ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(1).getInputatq15():"",font5));  cell02832ssr.setExtraParagraphSpace(10f);
		cell02832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell02932ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(1).getInputatq16():"",font5));  cell02932ssr.setExtraParagraphSpace(10f);
		cell02932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell03032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(1).getInputatq17():"",font5));  cell03032ssr.setExtraParagraphSpace(10f);
		cell03032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03132ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(1).getInputatq18():"",font5));  cell03132ssr.setExtraParagraphSpace(10f);
		cell03132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03232ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(1).getInputatq19():"",font5));  cell03232ssr.setExtraParagraphSpace(10f);
		cell03232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03332ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(1).getInputatq110():"",font5));  cell03332ssr.setExtraParagraphSpace(10f);
		cell03332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell034321ssr = new PdfPCell(new Paragraph("M.Phil.\r\n"));
		cell034321ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03532ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(2).getInputatq11():"",font5));  cell03532ssr.setExtraParagraphSpace(10f);
		cell03532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03632ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(2).getInputatq12():"",font5));  cell03632ssr.setExtraParagraphSpace(10f);
		cell03632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03732ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(2).getInputatq13():"",font5));  cell03732ssr.setExtraParagraphSpace(10f);
		cell03732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell03832ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(2).getInputatq14():"",font5));  cell03832ssr.setExtraParagraphSpace(10f);
		cell03832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell03932ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(2).getInputatq15():"",font5));  cell03932ssr.setExtraParagraphSpace(10f);
		cell03932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(2).getInputatq16():"",font5));  cell04032ssr.setExtraParagraphSpace(10f);
		cell04032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04132ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(2).getInputatq17():"",font5));  cell04132ssr.setExtraParagraphSpace(10f);
		cell04132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04232ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(2).getInputatq18():"",font5));  cell04232ssr.setExtraParagraphSpace(10f);
		cell04232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04332ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(2).getInputatq19():"",font5));  cell04332ssr.setExtraParagraphSpace(10f);
		cell04332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04432ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(2).getInputatq110():"",font5));  cell04432ssr.setExtraParagraphSpace(10f);
		cell04432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell04532ssr = new PdfPCell(new Paragraph("PG\r\n"));
		cell04532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04632ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(3).getInputatq11():"",font5));  cell04632ssr.setExtraParagraphSpace(10f);
		cell04632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04732ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(3).getInputatq12():"",font5));  cell04732ssr.setExtraParagraphSpace(10f);
		cell04732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04832ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(3).getInputatq13():"",font5));  cell04832ssr.setExtraParagraphSpace(10f);
		cell04832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell04932ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(3).getInputatq14():"",font5));  cell04932ssr.setExtraParagraphSpace(10f);
		cell04932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(3).getInputatq15():"",font5));  cell05032ssr.setExtraParagraphSpace(10f);
		cell05032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05132ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(3).getInputatq16():"",font5));  cell05132ssr.setExtraParagraphSpace(10f);
		cell05132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell05232ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(3).getInputatq17():"",font5));  cell05232ssr.setExtraParagraphSpace(10f);
		cell05232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05332ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(3).getInputatq18():"",font5));  cell05332ssr.setExtraParagraphSpace(10f);
		cell05332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05432ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(3).getInputatq19():"",font5));  cell05432ssr.setExtraParagraphSpace(10f);
		cell05432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05532ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicPerminentTeachers().get(3).getInputatq110():"",font5));  cell05532ssr.setExtraParagraphSpace(10f);
		cell05532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell05632ssr = new PdfPCell(new Paragraph("UG\r\n"));
//		PdfPCell cell05732ssr = new PdfPCell(new Paragraph());
//		PdfPCell cell05832ssr = new PdfPCell(new Paragraph());
//		PdfPCell cell05932ssr = new PdfPCell(new Paragraph());
//
//		PdfPCell cell06032ssr = new PdfPCell(new Paragraph());
//		PdfPCell cell06132ssr = new PdfPCell(new Paragraph());
//		PdfPCell cell06232ssr = new PdfPCell(new Paragraph());
//
//		PdfPCell cell06332ssr = new PdfPCell(new Paragraph());
//		PdfPCell cell06432ssr = new PdfPCell(new Paragraph());
//		PdfPCell cell06532ssr = new PdfPCell(new Paragraph());
//
//		PdfPCell cell06632ssr = new PdfPCell(new Paragraph());

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

//		table23ssr.addCell(cell05632ssr);
//		table23ssr.addCell(cell05732ssr);
//		table23ssr.addCell(cell05832ssr);
//		table23ssr.addCell(cell05932ssr);
//		table23ssr.addCell(cell06032ssr);
//		table23ssr.addCell(cell06132ssr);
//		table23ssr.addCell(cell06232ssr);
//		table23ssr.addCell(cell06332ssr);
//		table23ssr.addCell(cell06432ssr);
//		table23ssr.addCell(cell06532ssr);
//		table23ssr.addCell(cell06632ssr);

///////////////////////////////////////////////////-------------------------------------------->
		 PdfPCell cell0186ssr = new PdfPCell(new Paragraph("Permanent Teachers\r\n",font4));  cell0186ssr.setExtraParagraphSpace(10f);
		 cell0186ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 table24ssr.addCell(cell0186ssr);

//
	//	table24ssr.addCell(table23ssr);

		 table23ssr.setSpacingBefore(20f);
		 table23ssr.setSpacingAfter(20f);

		document.add(table24ssr);
		document.add(table23ssr);

		PdfPTable table27ssr = new PdfPTable(11);
		PdfPTable table28ssr = new PdfPTable(1);
		
		 float[] columnWidth4 = { 7f }; // Second column will be // twice as first and third
		 table28ssr.setWidths(columnWidth4);


// Setting width of table, its columns and spacing
		table27ssr.setWidthPercentage(100);
		table28ssr.setWidthPercentage(100);

		PdfPCell cell038ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n",font4));  cell038ssr.setExtraParagraphSpace(10f);
		cell038ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell039ssr = new PdfPCell(new Paragraph("Professor\r\n"));
		cell039ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell039ssr.setColspan(3);
		PdfPCell cell040ssr = new PdfPCell(new Paragraph("Associate Professor\r\n",font4));  cell040ssr.setExtraParagraphSpace(10f);
		cell040ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell040ssr.setColspan(3);
		PdfPCell cell041ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n",font4));  cell041ssr.setExtraParagraphSpace(10f);
		cell041ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell041ssr.setColspan(3);
		PdfPCell cell042ssr = new PdfPCell(new Paragraph(""));
		cell042ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0138ssr = new PdfPCell(new Paragraph(""));
		cell0138ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell000132ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell000132ssr.setExtraParagraphSpace(10f);
		cell000132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell000332ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell000332ssr.setExtraParagraphSpace(10f);
		cell000332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell000432ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell000432ssr.setExtraParagraphSpace(10f);
		cell000432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell000532ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell000532ssr.setExtraParagraphSpace(10f);
		cell000532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell000632ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell000632ssr.setExtraParagraphSpace(10f);
		cell000632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell000732ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell000732ssr.setExtraParagraphSpace(10f);
		cell000732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell000832ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell000832ssr.setExtraParagraphSpace(10f);
		cell000832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell000932ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell000932ssr.setExtraParagraphSpace(10f);
		cell000932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0001032ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell0001032ssr.setExtraParagraphSpace(10f);
		cell0001032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0001132ssr = new PdfPCell(new Paragraph("total\r\n",font4));  cell0001132ssr.setExtraParagraphSpace(10f);
		cell0001132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell001232ssr = new PdfPCell(new Paragraph("D.sc/D.Litt/ LLD/DM/M CH\r\n",font4));  cell001232ssr.setExtraParagraphSpace(10f);
		cell001232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell001332ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq51():"",font5));  cell001332ssr.setExtraParagraphSpace(10f);
		cell001332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell001432ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq52():"",font5));  cell001432ssr.setExtraParagraphSpace(10f);
		cell001432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell001532ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq53():"",font5));  cell001532ssr.setExtraParagraphSpace(10f);
		cell001532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell001632ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq54():"",font5));  cell001632ssr.setExtraParagraphSpace(10f);
		cell001632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell001732ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq55():"",font5));  cell001732ssr.setExtraParagraphSpace(10f);
		cell001732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell001832ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq56():"",font5));  cell001832ssr.setExtraParagraphSpace(10f);
		cell001832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell001932ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq57():"",font5));  cell001932ssr.setExtraParagraphSpace(10f);
		cell001932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell002032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq58():"",font5));  cell002032ssr.setExtraParagraphSpace(10f);
		cell002032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell002132ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq59():"",font5));  cell002132ssr.setExtraParagraphSpace(10f);
		cell002132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell002232ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(0).getInputatq510():"",font5));  cell002232ssr.setExtraParagraphSpace(10f);
		cell002232ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell020332ssr = new PdfPCell(new Paragraph("Ph.D.\r\n",font4));  cell020332ssr.setExtraParagraphSpace(10f);
		cell020332ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell020432ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq51():"",font5));  cell020432ssr.setExtraParagraphSpace(10f);
		cell020432ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell020532ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq52():"",font5));  cell020532ssr.setExtraParagraphSpace(10f);
		cell020532ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell020632ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq53():"",font5));  cell020632ssr.setExtraParagraphSpace(10f);
		cell020632ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell020732ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq54():"",font5));  cell020732ssr.setExtraParagraphSpace(10f);
		cell020732ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell020832ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq55():"",font5));  cell020832ssr.setExtraParagraphSpace(10f);
		cell020832ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell020932ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq56():"",font5));  cell020932ssr.setExtraParagraphSpace(10f);
		cell020932ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell030032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq57():"",font5));  cell030032ssr.setExtraParagraphSpace(10f);
		cell030032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell031032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq58():"",font5));  cell031032ssr.setExtraParagraphSpace(10f);
		cell031032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell032032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq59():"",font5));  cell032032ssr.setExtraParagraphSpace(10f);
		cell032032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell033032ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(1).getInputatq510():"",font5));  cell033032ssr.setExtraParagraphSpace(10f);
		cell033032ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 
		PdfPCell cell034320ssr = new PdfPCell(new Paragraph("M.Phil.\r\n",font4));  cell034320ssr.setExtraParagraphSpace(10f);
		cell034320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell035320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq51():"",font5));  cell035320ssr.setExtraParagraphSpace(10f);
		cell035320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell036320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq52():"",font5));  cell036320ssr.setExtraParagraphSpace(10f);
		cell036320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell037320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq53():"",font5));  cell035320ssr.setExtraParagraphSpace(10f);
		cell037320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
	
		 PdfPCell cell038320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq54():"",font5));  cell038320ssr.setExtraParagraphSpace(10f);
		 cell038320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 PdfPCell cell039320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq55():"",font5));  cell039320ssr.setExtraParagraphSpace(10f);
		 cell039320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 PdfPCell cell040320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq56():"",font5));  cell040320ssr.setExtraParagraphSpace(10f);
		 cell040320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 
		PdfPCell cell041320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq57():"",font5));  cell041320ssr.setExtraParagraphSpace(10f);
		cell041320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell042320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq58():"",font5));  cell042320ssr.setExtraParagraphSpace(10f);
		cell042320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell043320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq59():"",font5));  cell043320ssr.setExtraParagraphSpace(10f);
		cell043320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell044320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(2).getInputatq510():"",font5));  cell044320ssr.setExtraParagraphSpace(10f);
		cell044320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 
		PdfPCell cell045320ssr = new PdfPCell(new Paragraph("PG\r\n",font4));  cell045320ssr.setExtraParagraphSpace(10f);
		cell045320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell046320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq51():"",font5));  cell046320ssr.setExtraParagraphSpace(10f);
		cell046320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell047320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq52():"",font5));  cell047320ssr.setExtraParagraphSpace(10f);
		cell047320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell048320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq53():"",font5));  cell048320ssr.setExtraParagraphSpace(10f);
		cell048320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 
		PdfPCell cell049320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq54():"",font5));  cell049320ssr.setExtraParagraphSpace(10f);
		cell049320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell050320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq55():"",font5));  cell050320ssr.setExtraParagraphSpace(10f);
		cell050320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell051320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq56():"",font5));  cell051320ssr.setExtraParagraphSpace(10f);
		cell051320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 
		PdfPCell cell052320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq57():"",font5));  cell052320ssr.setExtraParagraphSpace(10f);
		cell052320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell053320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq58():"",font5));  cell053320ssr.setExtraParagraphSpace(10f);
		cell053320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell054320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq59():"",font5));  cell054320ssr.setExtraParagraphSpace(10f);
		cell054320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell055320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicTemporaryTeachers().get(3).getInputatq510():"",font5));  cell055320ssr.setExtraParagraphSpace(10f);
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

		
		 PdfPCell cell0185ssr = new PdfPCell(new Paragraph("Temporary Teachers\r\n",font4));  cell11.setExtraParagraphSpace(10f);
		 cell0185ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 table28ssr.addCell(cell0185ssr);
	
		// table28ssr.addCell(table27ssr);
			
		 table27ssr.setSpacingBefore(20f);
		 table27ssr.setSpacingAfter(20f);

		document.add(table28ssr);
		
		document.add(table27ssr);

		PdfPTable table29ssr = new PdfPTable(11);
		PdfPTable table30ssr = new PdfPTable(1);
		
		 float[] columnWidth5 = { 7f }; // Second column will be // twice as first and third
		 table30ssr.setWidths(columnWidth5);


// Setting width of table, its columns and spacing
		table29ssr.setWidthPercentage(100);
		table30ssr.setWidthPercentage(100);

		PdfPCell cell043ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n",font4));  cell043ssr.setExtraParagraphSpace(10f);
		cell043ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell044ssr = new PdfPCell(new Paragraph("Professor\r\n",font4));  cell044ssr.setExtraParagraphSpace(10f);
		cell044ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell044ssr.setColspan(3);
		PdfPCell cell045ssr = new PdfPCell(new Paragraph("Associate Professor\r\n",font4));  cell045ssr.setExtraParagraphSpace(10f);
		cell045ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell045ssr.setColspan(3);
		PdfPCell cell046ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n",font4));  cell046ssr.setExtraParagraphSpace(10f);
		cell046ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell046ssr.setColspan(3);
		PdfPCell cell048ssr = new PdfPCell(new Paragraph("",font4));  cell048ssr.setExtraParagraphSpace(10f);
		cell048ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell04308ssr = new PdfPCell(new Paragraph("",font4));  cell04308ssr.setExtraParagraphSpace(10f);
		cell04308ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell0001320ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell0001320ssr.setExtraParagraphSpace(10f);
		cell0001320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0003320ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell0003320ssr.setExtraParagraphSpace(10f);
		cell0003320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0004320ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell0004320ssr.setExtraParagraphSpace(10f);
		cell0004320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0005320ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell0005320ssr.setExtraParagraphSpace(10f);
		cell0005320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0006320ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell0006320ssr.setExtraParagraphSpace(10f);
		cell0006320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0007320ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell0007320ssr.setExtraParagraphSpace(10f);
		cell0007320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0008320ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell0008320ssr.setExtraParagraphSpace(10f);
		cell0008320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0009320ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell0009320ssr.setExtraParagraphSpace(10f);
		cell0009320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00010302ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell00010302ssr.setExtraParagraphSpace(10f);
		cell00010302ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell00011320ssr = new PdfPCell(new Paragraph("total\r\n",font4));  cell00011320ssr.setExtraParagraphSpace(10f);
		cell00011320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell0012320ssr = new PdfPCell(new Paragraph("D.sc/D.Litt/ LLD/DM/M CH",font4));  cell0012320ssr.setExtraParagraphSpace(10f);
		cell0012320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0013320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq91():"",font5));  cell0013320ssr.setExtraParagraphSpace(10f);
		cell0013320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0014320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq92():"",font5));  cell0014320ssr.setExtraParagraphSpace(10f);
		cell0014320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0015320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq93():"",font5));  cell0015320ssr.setExtraParagraphSpace(10f);
		cell0015320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		 PdfPCell cell0016320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq94():"",font5));  cell0016320ssr.setExtraParagraphSpace(10f);
		 cell0016320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 PdfPCell cell0017320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq95():"",font5));  cell0017320ssr.setExtraParagraphSpace(10f);
		 cell0017320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 PdfPCell cell0018320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq96():"",font5));  cell0018320ssr.setExtraParagraphSpace(10f);
		 cell0018320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 
		PdfPCell cell0019320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq97():"",font5));  cell0019320ssr.setExtraParagraphSpace(10f);
		cell0019320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0020320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq98():"",font5));  cell0020320ssr.setExtraParagraphSpace(10f);
		cell0020320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0021320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq99():"",font5));  cell0021320ssr.setExtraParagraphSpace(10f);
		cell0021320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0022320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(0).getInputatq910():"",font5));  cell0022320ssr.setExtraParagraphSpace(10f);
		cell0022320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		 PdfPCell cell0203320ssr = new PdfPCell(new Paragraph("Ph.D.\r\n",font4));  cell0203320ssr.setExtraParagraphSpace(10f);
		 cell0203320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 PdfPCell cell0204320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq91():"",font5));  cell0204320ssr.setExtraParagraphSpace(10f);
		 cell0204320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 PdfPCell cell0205320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq92():"",font5));  cell0205320ssr.setExtraParagraphSpace(10f);
		 cell0205320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 PdfPCell cell0206320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq93():"",font5));  cell0206320ssr.setExtraParagraphSpace(10f);
		 cell0206320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 PdfPCell cell0207320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq94():"",font5));  cell0207320ssr.setExtraParagraphSpace(10f);
		 cell0207320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 PdfPCell cell0208320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq95():"",font5));  cell0208320ssr.setExtraParagraphSpace(10f);
		 cell0208320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 PdfPCell cell0209320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq96():"",font5));  cell0209320ssr.setExtraParagraphSpace(10f);
		 cell0209320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 
		PdfPCell cell0300320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq97():"",font5));  cell0300320ssr.setExtraParagraphSpace(10f);
		cell0300320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0310320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq98():"",font5));  cell0310320ssr.setExtraParagraphSpace(10f);
		cell0310320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0320320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq99():"",font5));  cell0320320ssr.setExtraParagraphSpace(10f);
		cell0320320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0330320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(1).getInputatq910():"",font5));  cell0330320ssr.setExtraParagraphSpace(10f);
		cell0330320ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 
		PdfPCell cell0343200ssr = new PdfPCell(new Paragraph("M.Phil.\r\n",font4));  cell0343200ssr.setExtraParagraphSpace(10f);
		cell0343200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0353200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq91():"",font5));  cell0353200ssr.setExtraParagraphSpace(10f);
		cell0353200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0363200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq92():"",font5));  cell0363200ssr.setExtraParagraphSpace(10f);
		cell0363200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0373200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq93():"",font5));  cell0373200ssr.setExtraParagraphSpace(10f);
		cell0373200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 
		PdfPCell cell0383200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq94():"",font5));  cell0383200ssr.setExtraParagraphSpace(10f);
		cell0383200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0393200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq95():"",font5));  cell0393200ssr.setExtraParagraphSpace(10f);
		cell0393200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0403200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq96():"",font5));  cell0403200ssr.setExtraParagraphSpace(10f);
		cell0403200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		 
		PdfPCell cell0413200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq97():"",font5));  cell0413200ssr.setExtraParagraphSpace(10f);
		cell0413200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0423200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq98():"",font5));  cell0423200ssr.setExtraParagraphSpace(10f);
		cell0423200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0433200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq99():"",font5));  cell0433200ssr.setExtraParagraphSpace(10f);
		cell0433200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0443200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(2).getInputatq910():"",font5));  cell0443200ssr.setExtraParagraphSpace(10f);
		cell0443200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0453200ssr = new PdfPCell(new Paragraph("PG\r\n",font4));  cell0453200ssr.setExtraParagraphSpace(10f);
		cell0453200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0463200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq91():"",font5));  cell0463200ssr.setExtraParagraphSpace(10f);
		cell0463200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0473200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq92():"",font5));  cell0473200ssr.setExtraParagraphSpace(10f);
		cell0473200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0483200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq93():"",font5));  cell0483200ssr.setExtraParagraphSpace(10f);
		cell0483200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0493200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq94():"",font5));  cell0493200ssr.setExtraParagraphSpace(10f);
		cell0493200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0503200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq95():"",font5));  cell0503200ssr.setExtraParagraphSpace(10f);
		cell0503200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0513200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq96():"",font5));  cell0513200ssr.setExtraParagraphSpace(10f);
		cell0513200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0523200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq97():"",font5));  cell0523200ssr.setExtraParagraphSpace(10f);
		cell0523200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0533200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq98():"",font5));  cell0533200ssr.setExtraParagraphSpace(10f);
		cell0533200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0543200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq99():"",font5));  cell0543200ssr.setExtraParagraphSpace(10f);
		cell0543200ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0553200ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicParttimeTeacheres().get(3).getInputatq910():"",font5));  cell0553200ssr.setExtraParagraphSpace(10f);
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
	
	
		 PdfPCell cell0184ssr = new PdfPCell(new Paragraph("Part Time Teachers\r\n",font4));  cell0184ssr.setExtraParagraphSpace(10f);
		 cell0184ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
			
		 table30ssr.addCell(cell0184ssr);
	

	//	table30ssr.addCell(table29ssr);

//		table29ssr.setSpacingBefore(20f);
//		table29ssr.setSpacingAfter(20f);

		document.add(table30ssr);
		
		document.add(table29ssr);
		
		
		Paragraph paragraph1511ssr = new Paragraph("Distinguished Academicians Appointed",font4);
		
		paragraph1511ssr.setSpacingBefore(20f);
		document.add(paragraph1511ssr);
		
		
		
		
		PdfPTable table1311ssr = new PdfPTable(5);
		table1311ssr.setWidthPercentage(100f);
		table1311ssr.setWidths(new int[] {40,40,40,40,40 });
		table1311ssr.setSpacingBefore(20f);
		PdfPCell cell22 = new PdfPCell();
		cell22.setPhrase(new Phrase(""));
		cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase("Male",font4));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		
		cell22.setPhrase(new Phrase("Female",font4));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase("Others",font4));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase("Total",font4));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase("Emeritus Professor",font4));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(0).getInputaa1t1():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(0).getInputaa1t2():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(0).getInputaa1t3():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(0).getInputaa1t4():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase("Adjunct Professor",font4));  cell11.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(1).getInputaa1t1():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(1).getInputaa1t2():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(1).getInputaa1t3():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(1).getInputaa1t4():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase("Visiting Professor",font4));  cell11.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(2).getInputaa1t1():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(2).getInputaa1t2():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(2).getInputaa1t3():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(2).getInputaa1t4():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		
		document.add(table1311ssr);
		
		
		
		Paragraph paragraph1512ssr = new Paragraph("Chairs Instituted by the University",font4);
		document.add(paragraph1512ssr);
		
		PdfPTable table1313ssr = new PdfPTable(4);
		table1313ssr.setWidthPercentage(100f);
		
		PdfPCell cell223 = new PdfPCell();
		cell223.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell223.setPhrase(new Phrase("SI.No",font4));  cell11.setExtraParagraphSpace(10f);
		
		table1313ssr.addCell(cell223);
		cell223.setPhrase(new Phrase("Name of the Department",font4));  cell223.setExtraParagraphSpace(10f);
		table1313ssr.addCell(cell223);
		cell223.setPhrase(new Phrase("Name of the Chair",font4));  cell223.setExtraParagraphSpace(10f);
		table1313ssr.addCell(cell223);
		cell223.setPhrase(new Phrase("Name of the Sponsor Organisation/Agency",font4));  cell223.setExtraParagraphSpace(10f);
		table1313ssr.addCell(cell223);
		
		cell223.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutedUniversity().get(0).getInputiut1():"",font5));  cell223.setExtraParagraphSpace(10f);
		table1313ssr.addCell(cell22);
		cell223.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutedUniversity().get(0).getInputiut2():"",font5));  cell223.setExtraParagraphSpace(10f);
		table1313ssr.addCell(cell22);
		cell223.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutedUniversity().get(0).getInputiut3():"",font5));  cell223.setExtraParagraphSpace(10f);
		table1313ssr.addCell(cell22);
		cell223.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutedUniversity().get(0).getInputiut4():"",font5));  cell223.setExtraParagraphSpace(10f);
		table1313ssr.addCell(cell22);
		
		
		
		
		
		

//		PdfPTable table33ssr = new PdfPTable(5);
//		PdfPTable table34ssr = new PdfPTable(1);
//		
//	 float[] columnWidth6 = { 7f }; // Second column will be // twice as first and third
//		 table34ssr.setWidths(columnWidth6);
//
//     // Setting width of table, its columns and spacing
//		table33ssr.setWidthPercentage(100);
//		table34ssr.setWidthPercentage(100);
//
//		PdfPCell cell054ssr = new PdfPCell(new Paragraph("Number of Visiting/Guest Faculty engaged with the college?\r\n",font3));
//		
//		cell054ssr.setRowspan(2);
//		
//		
//     	PdfPCell cell055ssr = new PdfPCell(new Paragraph("Male\r\n"));
//     	PdfPCell cell056ssr = new PdfPCell(new Paragraph("Female\r\n"));
//     	PdfPCell cell057ssr = new PdfPCell(new Paragraph("Others\r\n"));
//     	PdfPCell cell058ssr = new PdfPCell(new Paragraph("Total\r\n"));
//		PdfPCell cell0551ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getDetailsofVisitingFaculties().get(0).getInputatg11():""));
//		
//		PdfPCell cell0561ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getDetailsofVisitingFaculties().get(0).getInputatg12():""));
//    	
//		PdfPCell cell0571ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getDetailsofVisitingFaculties().get(0).getInputatg13():""));
//		
//    	
//		PdfPCell cell0581ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getDetailsofVisitingFaculties().get(0).getInputatg14():""));
//		
//
//     	table33ssr.addCell(cell054ssr);
//		table33ssr.addCell(cell055ssr);
//		table33ssr.addCell(cell0551ssr);
//		table33ssr.addCell(cell056ssr);
//		table33ssr.addCell(cell0561ssr);
//    	table33ssr.addCell(cell057ssr);
//    	table33ssr.addCell(cell0571ssr);
//		table33ssr.addCell(cell058ssr);
//		table33ssr.addCell(cell0581ssr);
//
//
//		PdfPCell cell05810ssr = new PdfPCell(new Paragraph("Details of Visting/Guest Faculties\r\n",font3));
//		table34ssr.addCell(cell05810ssr);
//		table34ssr.addCell(table33ssr);
//
//		table34ssr.setSpacingBefore(20f);
//		table34ssr.setSpacingAfter(20f);
//
//		document.add(table34ssr);

		Paragraph paragraph29ssr = new Paragraph(
				"Provide the Following Details of Students Enrolled in the College During the Current Academic Year\r\n",
				font4);
		paragraph29ssr.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(paragraph29ssr);

		PdfPTable table35ssr = new PdfPTable(7);
		


// Setting width of table, its columns and spacing
		table35ssr.setWidthPercentage(100);

		PdfPCell cell059ssr = new PdfPCell(new Paragraph("Programme\r\n	",font4));  cell059ssr.setExtraParagraphSpace(10f);
		cell059ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell059ssr.setColspan(2);

		PdfPCell cell0591ssr = new PdfPCell(new Paragraph("UG\r\n", font4));  cell0591ssr.setExtraParagraphSpace(10f);
		cell0591ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0591ssr.setRowspan(3);

		PdfPCell cell0592ssr = new PdfPCell(new Paragraph("male\r\n",font4));  cell0592ssr.setExtraParagraphSpace(10f);
		cell0592ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0593ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(0).getInputas11():"",font5));  cell0593ssr.setExtraParagraphSpace(10f);
		cell0593ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0594ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(0).getInputas12():"",font5));  cell0594ssr.setExtraParagraphSpace(10f);
		cell0594ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0595ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(0).getInputas13():"",font5));  cell0595ssr.setExtraParagraphSpace(10f);
		cell0595ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0596ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(0).getInputas14():"",font5));  cell0596ssr.setExtraParagraphSpace(10f);
		cell0596ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0597ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(0).getInputas15():"",font5));  cell0597ssr.setExtraParagraphSpace(10f);
		cell0597ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell0599ssr = new PdfPCell(new Paragraph("female\r\n",font4));  cell0599ssr.setExtraParagraphSpace(10f);
		cell0599ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05910ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(1).getInputas11():"",font5));  cell05910ssr.setExtraParagraphSpace(10f);
		cell05910ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05911ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(1).getInputas12():"",font5));  cell05911ssr.setExtraParagraphSpace(10f);
		cell05911ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05912ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(1).getInputas13():"",font5));  cell05912ssr.setExtraParagraphSpace(10f);
		cell05912ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05913ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(1).getInputas14():"",font5));  cell05913ssr.setExtraParagraphSpace(10f);
		cell05913ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05914ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(1).getInputas15():"",font5));  cell05914ssr.setExtraParagraphSpace(10f);
		cell05914ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell05916ssr = new PdfPCell(new Paragraph("others\r\n",font4));  cell05916ssr.setExtraParagraphSpace(10f);
		cell05916ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05917ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(2).getInputas11():"",font5));  cell05917ssr.setExtraParagraphSpace(10f);
		cell05917ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05918ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(2).getInputas12():"",font5));  cell05918ssr.setExtraParagraphSpace(10f);
		cell05918ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05919ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(2).getInputas13():"",font5));  cell05919ssr.setExtraParagraphSpace(10f);
		cell05919ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05920ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(2).getInputas14():"",font5));  cell05920ssr.setExtraParagraphSpace(10f);
		cell05920ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05921ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(2).getInputas15():"",font5));  cell05921ssr.setExtraParagraphSpace(10f);
		cell05921ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05923ssr = new PdfPCell(new Paragraph("PG\r\n", font4));  cell05923ssr.setExtraParagraphSpace(10f);
		cell05923ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell05923ssr.setRowspan(3);
		
		PdfPCell cell05924ssr = new PdfPCell(new Paragraph("Male\r\n",font4));  cell05924ssr.setExtraParagraphSpace(10f);
		cell05924ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05925ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(3).getInputas11():"",font5));  cell05925ssr.setExtraParagraphSpace(10f);
		cell05925ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05926ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(3).getInputas12():"",font5));  cell05926ssr.setExtraParagraphSpace(10f);
		cell05926ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05927ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(3).getInputas13():"",font5));  cell05927ssr.setExtraParagraphSpace(10f);
		cell05927ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05928ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(3).getInputas14():"",font5));  cell05928ssr.setExtraParagraphSpace(10f);
		cell05928ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05929ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(3).getInputas15():"",font5));  cell05929ssr.setExtraParagraphSpace(10f);
		cell05929ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05930ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell05930ssr.setExtraParagraphSpace(10f);
		cell05930ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05931ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(4).getInputas11():"",font5));  cell05931ssr.setExtraParagraphSpace(10f);
		cell05931ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059321ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(4).getInputas12():"",font5));  cell059321ssr.setExtraParagraphSpace(10f);
		cell059321ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05933ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(4).getInputas13():"",font5));  cell05933ssr.setExtraParagraphSpace(10f);
		cell05933ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05934ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(4).getInputas14():"",font5));  cell05934ssr.setExtraParagraphSpace(10f);
		cell05934ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05935ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(4).getInputas15():"",font5));  cell05935ssr.setExtraParagraphSpace(10f);
		cell05935ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05936ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell05936ssr.setExtraParagraphSpace(10f);
		cell05936ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05937ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(5).getInputas11():"",font5));  cell05937ssr.setExtraParagraphSpace(10f);
		cell05937ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05938ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(5).getInputas12():"",font5));  cell05938ssr.setExtraParagraphSpace(10f);
		cell05938ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05939ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(5).getInputas13():"",font5));  cell05939ssr.setExtraParagraphSpace(10f);
		cell05939ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05940ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(5).getInputas14():"",font5));  cell05940ssr.setExtraParagraphSpace(10f);
		cell05940ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05941ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(5).getInputas15():"",font5));  cell05941ssr.setExtraParagraphSpace(10f);
		cell05941ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
PdfPCell cell059231ssr = new PdfPCell(new Paragraph("PG\r\n",font4));  cell059231ssr.setExtraParagraphSpace(10f);
cell059231ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
cell059231ssr.setRowspan(3);
		
		PdfPCell cell059241ssr = new PdfPCell(new Paragraph("Male\r\n"));
		cell059241ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell059241ssr.setExtraParagraphSpace(10f);
		PdfPCell cell059251ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(6).getInputas00():"",font5));  cell059251ssr.setExtraParagraphSpace(10f);
		cell059251ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059261ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(6).getInputas11():"",font5));  cell059261ssr.setExtraParagraphSpace(10f);
		cell059261ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059271ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(6).getInputas12():"",font5));  cell059271ssr.setExtraParagraphSpace(10f);
		cell059271ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059281ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(6).getInputas13():"",font5));  cell059281ssr.setExtraParagraphSpace(10f);
		cell059281ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059291ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(6).getInputas14():"",font5));  cell059291ssr.setExtraParagraphSpace(10f);
		cell059291ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059301ssr = new PdfPCell(new Paragraph("Female\r\n",font4));  cell059301ssr.setExtraParagraphSpace(10f);
		cell059301ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059311ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(7).getInputas00():"",font5));  cell059311ssr.setExtraParagraphSpace(10f);
		cell059311ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0593211ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(7).getInputas11():"",font5));  cell0593211ssr.setExtraParagraphSpace(10f);
		cell0593211ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059331ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(7).getInputas12():"",font5));  cell059331ssr.setExtraParagraphSpace(10f);
		cell059331ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059341ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(7).getInputas13():"",font5));  cell059341ssr.setExtraParagraphSpace(10f);
		cell059341ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059351ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(7).getInputas14():"",font5));  cell059351ssr.setExtraParagraphSpace(10f);
		cell059351ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059361ssr = new PdfPCell(new Paragraph("Others\r\n",font4));  cell059361ssr.setExtraParagraphSpace(10f);
		cell059361ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059371ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(8).getInputas00():"",font5));  cell059371ssr.setExtraParagraphSpace(10f);
		cell059371ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059381ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(8).getInputas11():"",font5));  cell059381ssr.setExtraParagraphSpace(10f);
		cell059381ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059391ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(8).getInputas12():"",font5));  cell059391ssr.setExtraParagraphSpace(10f);
		cell059391ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059401ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(8).getInputas13():"",font5));  cell059401ssr.setExtraParagraphSpace(10f);
		cell059401ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell059411ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsEnrolled().get(8).getInputas14():"",font5));  cell059411ssr.setExtraParagraphSpace(10f);
		cell059411ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell05942ssr = new PdfPCell(new Paragraph(""));
		cell05942ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell05943ssr = new PdfPCell(new Paragraph(""));
		cell05943ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell060ssr = new PdfPCell(new Paragraph("From the State Where College is Located\r\n", font4));  cell060ssr.setExtraParagraphSpace(10f);
		cell060ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell061ssr = new PdfPCell(new Paragraph("From Other States of India\r\n", font4));  cell061ssr.setExtraParagraphSpace(10f);
		cell061ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0621ssr = new PdfPCell(new Paragraph("NRI Students\r\n",font4));  cell0621ssr.setExtraParagraphSpace(10f);
		cell0621ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell063ssr = new PdfPCell(new Paragraph("Foreign Students\r\n", font4));  cell063ssr.setExtraParagraphSpace(10f);
		cell063ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell064ssr = new PdfPCell(new Paragraph("Total\r\n", font4));  cell064ssr.setExtraParagraphSpace(10f);
		cell064ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		table35ssr.addCell(cell059ssr);
//		table35ssr.addCell(cell0601ssr);
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


		table35ssr.addCell(cell059231ssr);
		
		table35ssr.addCell(cell059241ssr);
		table35ssr.addCell(cell059251ssr);
		table35ssr.addCell(cell059261ssr);
		table35ssr.addCell(cell059271ssr);
		table35ssr.addCell(cell059281ssr);
		table35ssr.addCell(cell059291ssr);
		table35ssr.addCell(cell059301ssr);
		table35ssr.addCell(cell059311ssr);
		table35ssr.addCell(cell0593211ssr);
		table35ssr.addCell(cell059331ssr);
		table35ssr.addCell(cell059341ssr);
		table35ssr.addCell(cell059351ssr);
		table35ssr.addCell(cell059361ssr);
		table35ssr.addCell(cell059371ssr);
		table35ssr.addCell(cell059381ssr);
		table35ssr.addCell(cell059391ssr);
		table35ssr.addCell(cell059401ssr);
		table35ssr.addCell(cell059411ssr);
		
		
		
		
		
		
		
		
		
		table35ssr.addCell(cell05942ssr);
		table35ssr.addCell(cell05943ssr);

		table35ssr.setSpacingBefore(20f);
		table35ssr.setSpacingAfter(20f);

		document.add(table35ssr);
		
		
		Paragraph paragraph152ssr = new Paragraph("Does the university offer any integrated programmes?\r\n"+"Response",font4);
		document.add(paragraph152ssr);
		
		Paragraph paragraph1521ssr = new Paragraph(ssrData != null ?ssrData.getIntegratedProgrammes().get(0).getInputult7():"",font5);
		
		document.add(paragraph1521ssr);
		
		Paragraph paragraph153ssr = new Paragraph("Total number of integrated programmes\r\n"+"Response",font4);
		document.add(paragraph153ssr);
		
		Paragraph paragraph1524ssr = new Paragraph(ssrData != null ?ssrData.getIntegratedProgrammes().get(0).getInputult7():"",font5);
		
		document.add(paragraph1524ssr);
		
		
		PdfPTable table1312ssr = new PdfPTable(6);
		table1312ssr.setWidthPercentage(100f);
		table1312ssr.setWidths(new int[] {40,40,40,40,40 ,40});
		table1312ssr.setSpacingBefore(20f);
		PdfPCell cell222 = new PdfPCell();
		cell222.setPhrase(new Phrase("Integrated Programmes",font4));  cell222.setExtraParagraphSpace(10f);
		cell222.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1312ssr.addCell(cell222);
		cell222.setPhrase(new Phrase("From the state where the university is located",font4));  cell222.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase("From other states of India",font4));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase("NRI Students",font4));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase("Foreign Students",font4));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase("Total",font4));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase("Male",font4));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(0).getInputult2():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(0).getInputult3():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(0).getInputult4():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(0).getInputult5():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(0).getInputult6():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		
		
		cell22.setPhrase(new Phrase("Female",font4));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(1).getInputult2():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(1).getInputult3():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(1).getInputult4():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(1).getInputult5():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(1).getInputult6():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		
		cell22.setPhrase(new Phrase("Others",font4));  cell11.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(2).getInputult2():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(2).getInputult3():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(2).getInputult4():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(2).getInputult5():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getIntegratedProgrammes().get(2).getInputult6():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1312ssr.addCell(cell222);
		
		
//		document.add(table1312ssr);
		
		
		
		
		
		Paragraph paragraph1525ssr = new Paragraph("Details of programmes under the UGC Human Resource Development Centre,If applicable",font4);
		paragraph1525ssr.setSpacingAfter(20f);
		document.add(paragraph1525ssr);
		
		PdfPTable table1314ssr = new PdfPTable(2);
		table1314ssr.setWidthPercentage(100);
		
		
		PdfPCell cell2233 = new PdfPCell();
		cell2233.setPhrase(new Phrase("Year of Establishment",font4));  cell2233.setExtraParagraphSpace(10f);
		
		cell2233.setPhrase(new Phrase("Integrated Programmes",font4));  cell2233.setExtraParagraphSpace(10f);
		cell2233.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1314ssr.addCell(cell2233);
		cell2233.setPhrase(new Phrase(ssrData != null ?ssrData.getHumanResourceDevelopment().get(0).getInputrdt1():"",font5));  cell2233.setExtraParagraphSpace(10f);
		cell2233.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1314ssr.addCell(cell2233);
		cell2233.setPhrase(new Phrase("Number of UGC Orientation Programmes",font4));  cell2233.setExtraParagraphSpace(10f);
		cell2233.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1314ssr.addCell(cell2233);
		cell2233.setPhrase(new Phrase(ssrData != null ?ssrData.getHumanResourceDevelopment().get(0).getInputrdt2():"",font5));  cell2233.setExtraParagraphSpace(10f);
		cell2233.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1314ssr.addCell(cell2233);
		cell2233.setPhrase(new Phrase("Number of UGC Refresher Course",font4));  cell2233.setExtraParagraphSpace(10f);
		cell2233.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1314ssr.addCell(cell2233);
		cell2233.setPhrase(new Phrase(ssrData != null ?ssrData.getHumanResourceDevelopment().get(0).getInputrdt3():"",font5));  cell2233.setExtraParagraphSpace(10f);
		cell2233.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table1314ssr.addCell(cell2233);
		cell2233.setPhrase(new Phrase("Number of University own Programmes",font4));  cell2233.setExtraParagraphSpace(10f);
		
		cell2233.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1314ssr.addCell(cell2233);
		cell2233.setPhrase(new Phrase(ssrData != null ?ssrData.getHumanResourceDevelopment().get(0).getInputrdt4():"",font5));  cell2233.setExtraParagraphSpace(10f);
		cell2233.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table1314ssr.addCell(cell2233);
		cell2233.setPhrase(new Phrase("Total Number of Programmes Conducted (during the last five years)",font4));  cell2233.setExtraParagraphSpace(10f);
		cell2233.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table1314ssr.addCell(cell2233);
		cell2233.setPhrase(new Phrase(ssrData != null ?ssrData.getHumanResourceDevelopment().get(0).getInputrdt5():"",font5));  cell2233.setExtraParagraphSpace(10f);
		cell2233.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table1314ssr.addCell(cell2233);
		
		
		
		
		document.add(table1314ssr);
		
		
		

		/////////////////////////////////////////////----------------------Evaluative report of the de

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
		PdfPCell cell09criteria7 = new PdfPCell(new Paragraph(ssrData!=null?ssrData.getEvaluativeReport().get(0).getValuet1():"",font5));  //dnam1
		cell09criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell09criteria7.setExtraParagraphSpace(10f);
		PdfPCell cell010criteria7 = new PdfPCell(new Paragraph(ssrData!=null?ssrData.getEvaluativeFileupload().get(0).getEvaluative_filePath():"",font5)); //file
		cell010criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell010criteria7.setExtraParagraphSpace(10f);
		PdfPCell cell011criteria7 = new PdfPCell(new Paragraph(ssrData!=null?ssrData.getEvaluativeReport().get(0).getValuet2():"",font5)); 
		cell011criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell011criteria7.setExtraParagraphSpace(10f);
		
		PdfPCell cell012criteria7 = new PdfPCell(new Paragraph(ssrData!=null?ssrData.getEvaluativeFileupload().get(0).getEvaluative_filePath():"",font5)); 
		cell012criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell012criteria7.setExtraParagraphSpace(10f);
		
		PdfPCell cell013criteria7 = new PdfPCell(new Paragraph(ssrData!=null?ssrData.getEvaluativeReport().get(0).getValuet3():"",font5)); 
		cell013criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell013criteria7.setExtraParagraphSpace(10f);
		PdfPCell cell09criteria17 = new PdfPCell(new Paragraph(ssrData!=null?ssrData.getEvaluativeFileupload().get(0).getEvaluative_filePath():"",font5)); 
		cell09criteria17.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell09criteria17.setExtraParagraphSpace(10f);
		
		PdfPCell cell010criteria17 = new PdfPCell(new Paragraph(ssrData!=null?ssrData.getEvaluativeReport().get(0).getValuet4():"",font5)); 
		cell010criteria17.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell010criteria17.setExtraParagraphSpace(10f);
		
		PdfPCell cell011criteria17 = new PdfPCell(new Paragraph(ssrData!=null?ssrData.getEvaluativeFileupload().get(0).getEvaluative_filePath():"",font5)); 
	
		cell011criteria17.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell011criteria17.setExtraParagraphSpace(10f);

		

		table60.addCell(cell09criteria7);
		table60.addCell(cell010criteria7);
		table60.addCell(cell011criteria7);
		table60.addCell(cell012criteria7);
		table60.addCell(cell013criteria7);
		table60.addCell(cell09criteria17);
		table60.addCell(cell010criteria17);
		table60.addCell(cell011criteria17);
		
		
		table60.setSpacingBefore(20f);
		table60.setSpacingAfter(20f);

		document.add(table60);
		
		
		/////////////////////////
		/////////////////////////////////////////////////////////////
		//// EvalutionReport

		
		
		
		
	
			System.out.println("open the document==========>");	
		
			Paragraph paragraph1 = new Paragraph("\r\n EvaluationReport \r\n", font1);
			paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph1);
            
            Paragraph paragraph2 = new Paragraph("\r\n Evaluative Report of the Departments \r\n", font1);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            document.add(paragraph2);
            
            
            Paragraph paragraph3 = new Paragraph("Name Of the Autonomous College", font2);
            paragraph3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph3);
           Paragraph paragraph4 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getNameofTheAutonomousCollege():"");
    		paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph4);
    		
    		
    		
            Paragraph paragraph31 = new Paragraph("Name of the Department", font2);
            paragraph31.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph31);
    		
             Paragraph paragraph5 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getNameofTheDepartment():"");
    	     paragraph5.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		 document.add(paragraph5);
    		
    		
    		  Paragraph paragraph51 = new Paragraph("Dist", font2);
    		  paragraph51.setAlignment(Paragraph.ALIGN_JUSTIFIED);
      		  document.add(paragraph51);
      		
    		 Paragraph paragraph6 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getDist():"");
     		 paragraph6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	    		document.add(paragraph6);
    	    		
    	    		
    	    Paragraph paragraph61 = new Paragraph("State", font2);
    	    paragraph61.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	    document.add(paragraph61);		
    	   Paragraph paragraph7 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getState():"");
    	   paragraph7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	   document.add(paragraph7);
    	    	    
    	   
    	   Paragraph paragraph71 = new Paragraph("Total Number of Departments in the institution", font2);
    	   paragraph71.setAlignment(Paragraph.ALIGN_JUSTIFIED);
   	       document.add(paragraph71);	
    	   Paragraph paragraph8 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getTotalNumberofDepartmentsIntheInstitution():"");
    	   paragraph8.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	   paragraph8.setSpacingAfter(20f);
    	   document.add(paragraph8);
    	   
    	   
    	   
    	   
    	   
    	   PdfPTable table1 = new PdfPTable(5);
    	   table1.setWidthPercentage(100);
    	   
    	   PdfPCell cell111 = new PdfPCell(new Paragraph("S No", font2));
    	   PdfPCell cell21 = new PdfPCell(new Paragraph("Name of the Department.",font2));
			PdfPCell cell3 = new PdfPCell(new Paragraph("For Ex: English\r\n",font2));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Zooology",font2));
			PdfPCell cell5 = new PdfPCell(new Paragraph("Bio-Technology\r\n",font2));
			
			PdfPCell cell6 = new PdfPCell(new Paragraph("1"));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell7 = new PdfPCell(new Paragraph("Year of Establishment"));
			PdfPCell cell8 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getEnglish():"",font5));
			PdfPCell cell9 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getZoology():"",font5));
			PdfPCell cell10 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getBioTechnology():"",font5));
			
			PdfPCell cell1111 = new PdfPCell(new Paragraph("2"));
			cell1111.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell12 = new PdfPCell(new Paragraph("Is the Department part of a School/Faculty of the Autonomous College"));
			PdfPCell cell13 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getEnglish():"",font5));
			PdfPCell cell14 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getZoology():"",font5));
			PdfPCell cell15 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getBioTechnology():"",font5));
			
			
			PdfPCell cell16 = new PdfPCell(new Paragraph("3"));
			cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell17 = new PdfPCell(new Paragraph("Name of programmes offered"));
			PdfPCell cell18= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getEnglish():"",font5));
			PdfPCell cell19= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getZoology():"",font5));
			PdfPCell cell20= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getBioTechnology():"",font5));
			
			PdfPCell cell211= new PdfPCell(new Paragraph("4"));
			cell211.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell221= new PdfPCell(new Paragraph("Number of teaching posts Sanctioned/Filled"));
			PdfPCell cell23 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getEnglish():"",font5));
			PdfPCell cell24= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getZoology():"",font5));
			PdfPCell cell25= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getBioTechnology():"",font5));
			
			PdfPCell cell26 = new PdfPCell(new Paragraph("5"));
			cell26.setHorizontalAlignment(Element.ALIGN_CENTER);
		    PdfPCell cell27 = new PdfPCell(new Paragraph("Number of Research Projects:Total grants received"));
			PdfPCell cell28= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getEnglish():"",font5));
			PdfPCell cell29= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getZoology():"",font5));
			PdfPCell cell30= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getBioTechnology():"",font5));
			
			PdfPCell cell31 = new PdfPCell(new Paragraph("6"));
			cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell31.setRowspan(3);
			
			PdfPCell cell32 = new PdfPCell(new Paragraph("Inter -institutional collaborative projects and Associated grants received"));
			PdfPCell cell33 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getEnglish():"",font5));
			PdfPCell cell34 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getZoology():"",font5));
			PdfPCell cell35 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getBioTechnology():"",font5));
			
			PdfPCell cell36 = new PdfPCell(new Paragraph("National collaboration"));
			
			PdfPCell cell37 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getEnglish():"",font5));
			PdfPCell cell38 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getZoology():"",font5));
			PdfPCell cell39 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getBioTechnology():"",font5));
			
			PdfPCell cell40 = new PdfPCell(new Paragraph("International collaboration"));
			PdfPCell cell41= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getEnglish():"",font5));
			PdfPCell cell42 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getZoology():"",font5));
			PdfPCell cell43 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getBioTechnology():"",font5));
			
			PdfPCell cell44 = new PdfPCell(new Paragraph("7"));
			cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell45 = new PdfPCell(new Paragraph("Departmental projects funded by DST_FIST,UGC-SAP?CAS,DPE,DBT,ICSSR,AICTE etc.,:Total grants received"));
			PdfPCell cell46 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getEnglish():"",font5));
			PdfPCell cell47 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getZoology():"",font5));
			PdfPCell cell48= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getBioTechnology():"",font5));
			
			PdfPCell cell49= new PdfPCell(new Paragraph("8"));
			cell49.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell50= new PdfPCell(new Paragraph("Number of Research Projects:Total grants received"));
			PdfPCell cell51= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getEnglish():"",font5));
			PdfPCell cell52= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getEnglish():"",font5));
			PdfPCell cell53= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getBioTechnology():"",font5));
			
			PdfPCell cell54= new PdfPCell(new Paragraph("9"));
			cell54.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell54.setRowspan(6);
			
			PdfPCell cell55= new PdfPCell(new Paragraph("Publications:"));
			PdfPCell cell56= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getEnglish():"",font5));
			PdfPCell cell57= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getZoology():"",font5));
			PdfPCell cell58= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getBioTechnology():"",font5));
			
			PdfPCell cell59= new PdfPCell(new Paragraph("Number of Papers published"));
			PdfPCell cell60= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getEnglish():"",font5));
			PdfPCell cell61= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getZoology():"",font5));
			PdfPCell cell62= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getBioTechnology():"",font5));
			
			PdfPCell cell63= new PdfPCell(new Paragraph("Number of Books with ISBN"));
			PdfPCell cell64= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getEnglish():"",font5));
			PdfPCell cell65= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getZoology():"",font5));
			PdfPCell cell66= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getBioTechnology():"",font5));
			
			PdfPCell cell67= new PdfPCell(new Paragraph("Number of Citation Index -range/average"));
			PdfPCell cell68= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getEnglish():"",font5));
			PdfPCell cell69= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getZoology():"",font5));
			PdfPCell cell70= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getBioTechnology():"",font5));
			
			
			PdfPCell cell71= new PdfPCell(new Paragraph("Number of Citation Factor-range/average"));
			PdfPCell cell72= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getEnglish():"",font5));
			PdfPCell cell73= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getZoology():"",font5));
			PdfPCell cell74= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getBioTechnology():"",font5));
			
			
			PdfPCell cell75= new PdfPCell(new Paragraph("Number of h-index"));
			PdfPCell cell76= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getEnglish():"",font5));
			PdfPCell cell77= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getZoology():"",font5));
			PdfPCell cell78= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getBioTechnology():"",font5));
			
			
			PdfPCell cell79= new PdfPCell(new Paragraph("10"));
			cell79.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell80= new PdfPCell(new Paragraph("Details of parents and income generated"));
			PdfPCell cell81= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getEnglish():"",font5));
			PdfPCell cell82= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getZoology():"",font5));
			PdfPCell cell83= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getBioTechnology():"",font5));
			
			PdfPCell cell84= new PdfPCell(new Paragraph("11"));
			cell84.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell85= new PdfPCell(new Paragraph("Details of parents and income generated"));
			PdfPCell cell86= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getEnglish():"",font5));
			PdfPCell cell87= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getZoology():"",font5));
			PdfPCell cell88= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getBioTechnology():"",font5));
			
			PdfPCell cell89= new PdfPCell(new Paragraph("12"));
			cell89.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell89.setRowspan(4);
			PdfPCell cell90= new PdfPCell(new Paragraph("Awards/Recognitions received at National and International level by:"));
			PdfPCell cell91= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getEnglish():"",font5));
			PdfPCell cell92= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getZoology():"",font5));
			PdfPCell cell93= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getBioTechnology():"",font5));
			
			PdfPCell cell94= new PdfPCell(new Paragraph("Faculty"));
			PdfPCell cell95= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getEnglish():"",font5));
			PdfPCell cell96= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getZoology():"",font5));
			PdfPCell cell97= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getBioTechnology():"",font5));
			
			PdfPCell cell98= new PdfPCell(new Paragraph("Doctoral/Post doctoral fellows"));
			PdfPCell cell99= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getEnglish():"",font5));
			PdfPCell cell100= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getZoology():"",font5));
			PdfPCell cell101= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getBioTechnology():"",font5));
			
			
			PdfPCell cell102= new PdfPCell(new Paragraph("Students"));
			PdfPCell cell103= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getEnglish():"",font5));
			PdfPCell cell104= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getZoology():"",font5));
			PdfPCell cell105= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getBioTechnology():"",font5));
			
			
			PdfPCell cell106= new PdfPCell(new Paragraph("13"));
			cell106.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell107= new PdfPCell(new Paragraph("How many students have cleared Civil Services and Defense Services examinations, NET,SET (SLET), GATE and other competitive examinations"));
			PdfPCell cell108= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getEnglish():"",font5));
			PdfPCell cell109= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getZoology():"",font5));
			PdfPCell cell110= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getBioTechnology():"",font5));
			
			
			PdfPCell cell11111= new PdfPCell(new Paragraph("14"));
			cell11111.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell11111.setRowspan(3);
			PdfPCell cell112= new PdfPCell(new Paragraph("List of dotoral students and research assoiates"));
			PdfPCell cell113= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getEnglish():"",font5));
			PdfPCell cell114= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getZoology():"",font5));
			PdfPCell cell115= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getBioTechnology():"",font5));
			
			
			PdfPCell cell116= new PdfPCell(new Paragraph("Fro the host institution/uniersity"));
			PdfPCell cell117= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getEnglish():"",font5));
			PdfPCell cell118= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getZoology():"",font5));
			PdfPCell cell119= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getBioTechnology():"",font5));
			
			PdfPCell cell120= new PdfPCell(new Paragraph("Year of Establishment"));
			PdfPCell cell121= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getEnglish():"",font5));
			PdfPCell cell122= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getZoology():"",font5));
			PdfPCell cell123= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getBioTechnology():"",font5));
			
			PdfPCell cell124= new PdfPCell(new Paragraph("15"));
			cell124.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell125= new PdfPCell(new Paragraph("Number of Research Scholars/ Post Graduate students getting financial assistance from the University/State/Central"));
			PdfPCell cell126= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getEnglish():"",font5));
			PdfPCell cell127= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getZoology():"",font5));
			PdfPCell cell128= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getBioTechnology():"",font5));
			
			
			cell11111.setExtraParagraphSpace(10f);
			cell11111.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell11111);
			cell211.setExtraParagraphSpace(10f);
			cell211.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell211);
			cell3.setExtraParagraphSpace(10f);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell3);
			cell4.setExtraParagraphSpace(10f);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell4);
			
			cell5.setExtraParagraphSpace(10f);
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell5);
			
			cell6.setExtraParagraphSpace(10f);
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell6);
			
			
			cell7.setExtraParagraphSpace(10f);
			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell7);
			
			cell8.setExtraParagraphSpace(10f);
			cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell8);
	
			
			cell9.setExtraParagraphSpace(10f);
			cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell9);
			
			
			cell10.setExtraParagraphSpace(10f);
			cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell10);
			
			cell11111.setExtraParagraphSpace(10f);
			cell11111.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell11111);
			
			
			cell12.setExtraParagraphSpace(10f);
			cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell12);
			
			cell13.setExtraParagraphSpace(10f);
			cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell13);
			
			cell14.setExtraParagraphSpace(10f);
			cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell14);
			
			cell15.setExtraParagraphSpace(10f);
			cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell15);
			
			
			cell16.setExtraParagraphSpace(10f);
			cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell16);
			
			
			cell17.setExtraParagraphSpace(10f);
			cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table1.addCell(cell17);
			
			cell18.setExtraParagraphSpace(10f);
			cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell18);
			
			
			cell19.setExtraParagraphSpace(10f);
			cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell19);
			
			
			cell20.setExtraParagraphSpace(10f);
			cell20.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell20);
			
			
			
			cell211.setExtraParagraphSpace(10f);
			cell211.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell211);
			
			
			cell221.setExtraParagraphSpace(10f);
			cell221.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell221);
			
			
			cell23.setExtraParagraphSpace(10f);
			cell23.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell23);
			
			
			cell24.setExtraParagraphSpace(10f);
			cell24.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell24);
			
			
			
			cell25.setExtraParagraphSpace(10f);
			cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell25);
			
			cell26.setExtraParagraphSpace(10f);
			cell26.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table1.addCell(cell26);
			
			
			
			cell27.setExtraParagraphSpace(10f);
			cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell27);
			
			
			cell28.setExtraParagraphSpace(10f);
			cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell28);
			
			cell29.setExtraParagraphSpace(10f);
			cell29.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell29);
			
			
			cell30.setExtraParagraphSpace(10f);
			cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell30);
			
			
			cell31.setExtraParagraphSpace(10f);
			cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell31);
			
			
			cell32.setExtraParagraphSpace(10f);
			cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell32);
			
			
			cell33.setExtraParagraphSpace(10f);
			cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell33);
			
			
			cell34.setExtraParagraphSpace(10f);
			cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell34);
			
			
			cell35.setExtraParagraphSpace(10f);
			cell35.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell35);
			
			cell36.setExtraParagraphSpace(10f);
			cell36.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table1.addCell(cell36);
			
			cell37.setExtraParagraphSpace(10f);
			cell37.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell37);
			
			cell38.setExtraParagraphSpace(10f);
			cell38.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell38);
			
			cell39.setExtraParagraphSpace(10f);
			cell39.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell39);
			
			cell40.setExtraParagraphSpace(10f);
			cell40.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell40);
			
			
			cell41.setExtraParagraphSpace(10f);
			cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell41);
			
			
			
			cell42.setExtraParagraphSpace(10f);
			cell42.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell42);
			
			
			
			cell43.setExtraParagraphSpace(10f);
			cell43.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell43);
			
			cell44.setExtraParagraphSpace(10f);
			cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table1.addCell(cell44);
			
			
			
			cell45.setExtraParagraphSpace(10f);
			cell45.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell45);
			
			cell46.setExtraParagraphSpace(10f);
			cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell46);
			
			
			cell47.setExtraParagraphSpace(10f);
			cell47.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell47);
			
			
			cell48.setExtraParagraphSpace(10f);
			cell48.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell48);
			
			cell49.setExtraParagraphSpace(10f);
			cell49.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell49);
			
			cell50.setExtraParagraphSpace(10f);
			cell50.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell50);
			
			cell51.setExtraParagraphSpace(10f);
			cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell51);
			
			
			cell52.setExtraParagraphSpace(10f);
			cell52.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell52);
			
			cell53.setExtraParagraphSpace(10f);
			cell53.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell53);
			
			cell54.setExtraParagraphSpace(10f);
			cell54.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table1.addCell(cell54);
		    
			
		    cell55.setExtraParagraphSpace(10f);
		    cell55.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell55);
			
			cell56.setExtraParagraphSpace(10f);
			cell56.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell56);
			
			cell57.setExtraParagraphSpace(10f);
			cell57.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell57);
			
			cell58.setExtraParagraphSpace(10f);
			cell58.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell58);
			
			cell59.setExtraParagraphSpace(10f);
			cell59.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell59);
			
			cell60.setExtraParagraphSpace(10f);
			cell60.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell60);
			
			cell61.setExtraParagraphSpace(10f);
			cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell61);
			
			cell62.setExtraParagraphSpace(10f);
			cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell62);
			
			cell63.setExtraParagraphSpace(10f);
			cell63.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell63);
			
			
			cell64.setExtraParagraphSpace(10f);
			cell64.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell64);
			
			cell65.setExtraParagraphSpace(10f);
			cell65.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell65);
			
			cell66.setExtraParagraphSpace(10f);
			cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell66);
			
			
			cell67.setExtraParagraphSpace(10f);
			cell67.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell67);
			
			
			cell68.setExtraParagraphSpace(10f);
			cell68.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell68);
			
			cell69.setExtraParagraphSpace(10f);
			cell69.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell69);
			
			
			cell70.setExtraParagraphSpace(10f);
			cell70.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell70);
			
			
			
			cell71.setExtraParagraphSpace(10f);
			cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell71);
			
			
			
			
			cell72.setExtraParagraphSpace(10f);
			cell72.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell72);
			
			cell73.setExtraParagraphSpace(10f);
			cell73.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell73);
			
			cell74.setExtraParagraphSpace(10f);
			cell74.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell74);
			
			
			cell75.setExtraParagraphSpace(10f);
			cell75.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell75);
			
			cell76.setExtraParagraphSpace(10f);
			cell76.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell76);
			
			
			cell77.setExtraParagraphSpace(10f);
			cell77.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell77);
			

			cell78.setExtraParagraphSpace(10f);
			cell78.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell78);
			

			cell79.setExtraParagraphSpace(10f);
			cell79.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell79);
			
			cell80.setExtraParagraphSpace(10f);
			cell80.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell80);
		
	
			
			cell81.setExtraParagraphSpace(10f);
			cell81.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell81);
			
			
			cell82.setExtraParagraphSpace(10f);
			cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell82);
			
			
			
			cell83.setExtraParagraphSpace(10f);
			cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell83);
			
			cell84.setExtraParagraphSpace(10f);
			cell84.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell84);
			
			cell85.setExtraParagraphSpace(10f);
			cell85.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell85);
			
			
			cell86.setExtraParagraphSpace(10f);
			cell86.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell86);
			
			
			cell87.setExtraParagraphSpace(10f);
			cell87.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell87);
			
			cell88.setExtraParagraphSpace(10f);
			cell88.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell88);
			
			cell89.setExtraParagraphSpace(10f);
			cell89.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell89);
			
			
			cell90.setExtraParagraphSpace(10f);
			cell90.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell90);
			
			
			cell91.setExtraParagraphSpace(10f);
			cell91.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell91);
			
			
			cell92.setExtraParagraphSpace(10f);
			cell92.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell92);
			
			
			cell93.setExtraParagraphSpace(10f);
			cell93.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell93);
			
			
			cell94.setExtraParagraphSpace(10f);
			cell94.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell94);
			
			
			cell95.setExtraParagraphSpace(10f);
			cell95.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell95);
			
			
			cell96.setExtraParagraphSpace(10f);
			cell96.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell96);
			
			
			cell97.setExtraParagraphSpace(10f);
			cell97.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell97);
			
			
			cell98.setExtraParagraphSpace(10f);
			cell98.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell98);
			
			
			cell99.setExtraParagraphSpace(10f);
			cell99.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell99);
			
			
			cell100.setExtraParagraphSpace(10f);
			cell100.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell100);
			
			
			cell101.setExtraParagraphSpace(10f);
			cell101.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell101);
			
			
			cell102.setExtraParagraphSpace(10f);
			cell102.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell102);
			
			
			cell103.setExtraParagraphSpace(10f);
			cell103.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell103);
			
			cell104.setExtraParagraphSpace(10f);
			cell104.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell104);
			
			cell105.setExtraParagraphSpace(10f);
			cell105.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell105);
			
			
			cell106.setExtraParagraphSpace(10f);
			cell106.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell106);
			
			cell107.setExtraParagraphSpace(10f);
			cell107.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell107);
			
			cell108.setExtraParagraphSpace(10f);
			cell108.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell108);
			
			cell109.setExtraParagraphSpace(10f);
			cell109.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell109);
			
			
			cell110.setExtraParagraphSpace(10f);
			cell110.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell110);
			
			
			cell11111.setExtraParagraphSpace(10f);
			cell11111.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell11111);
			
			
			cell112.setExtraParagraphSpace(10f);
			cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell112);
			
			cell113.setExtraParagraphSpace(10f);
			cell113.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell113);
			
			cell114.setExtraParagraphSpace(10f);
			cell114.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell114);
			
			
			cell115.setExtraParagraphSpace(10f);
			cell115.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell115);
			
			
			cell116.setExtraParagraphSpace(10f);
			cell116.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell116);
			
			
			cell117.setExtraParagraphSpace(10f);
			cell117.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell117);
			
			
			
			cell118.setExtraParagraphSpace(10f);
			cell118.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell118);
			
			cell119.setExtraParagraphSpace(10f);
			cell119.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell119);
			
			
			cell120.setExtraParagraphSpace(10f);
			cell120.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell120);
			
			
			cell121.setExtraParagraphSpace(10f);
			cell121.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell121);
			
			cell122.setExtraParagraphSpace(10f);
			cell122.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell122);
			
			cell123.setExtraParagraphSpace(10f);
			cell123.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell123);
			
			
			cell124.setExtraParagraphSpace(10f);
			cell124.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell124);
			
			cell125.setExtraParagraphSpace(10f);
			cell125.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell125);
			
			cell126.setExtraParagraphSpace(10f);
			cell126.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell126);
			
			cell127.setExtraParagraphSpace(10f);
			cell127.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell127);
			
			cell128.setExtraParagraphSpace(10f);
			cell128.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell128);
			
			document.add(table1);			
	}

	public void Iiqa(Document document) {

		Paragraph paragraph = new Paragraph("Institutional Information for Quality Assessment(IIQA)",font1);

		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		PdfPCell cell1 = new PdfPCell();

		document.add(cell1);
		paragraph.setSpacingAfter(10f);
		document.add(paragraph);

		Font fontParagraph4 = FontFactory.getFont(FontFactory.COURIER_BOLD);
		fontParagraph4.setSize(12);
		Paragraph paragraph5 = new Paragraph(qIAIndicator1.get(0).getInputiiqa1t2(),
				fontParagraph4);
		paragraph5.setAlignment(Paragraph.ALIGN_LEFT);

		paragraph.setSpacingAfter(10f);
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
		table.setSpacingBefore(20f);
		table.setSpacingAfter(20f);
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

//					for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//					{
//					
//					
//				}
//					for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//					{
//					
//					
//					}
//					for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//					{
//					
//					
//					}
//				

//					PdfPCell cell19 = new PdfPCell();
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
//				cell92.setRowspan(3);
//				PdfPCell cell701 = new PdfPCell(new Paragraph("State"));
//				PdfPCell cell702 = new PdfPCell(new Paragraph(""));
//				PdfPCell cell703 = new PdfPCell(new Paragraph("Universite"));
//				PdfPCell cell704 = new PdfPCell(new Paragraph(""));
//				PdfPCell cell705 = new PdfPCell(new Paragraph("Documents"));
//				PdfPCell cell706 = new PdfPCell(new Paragraph(""));
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
		table4152.setSpacingBefore(20f);
		PdfPCell cell601 = new PdfPCell(new Paragraph("SRA program"));
		PdfPCell cell602 = new PdfPCell(new Paragraph("Document"));
//				PdfPCell cell603 = new PdfPCell(new Paragraph(qiadata.getQiaIndicator4().get(0).getIiqa18t2()));
//				PdfPCell cell604 = new PdfPCell(new Paragraph(qiadata.getQiaIndicator4().get(0).getIiqa18t2()));

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
		table5154.setSpacingBefore(20f);
		PdfPCell cell701 = new PdfPCell(new Paragraph("Programmes"));
		PdfPCell cell702 = new PdfPCell(new Paragraph("Number"));
		table5154.addCell(cell701);
		table5154.addCell(cell702);
		for (int i = 0; i < qiadata.getQiaIndicator5().size(); i++) {
			table5154.addCell(qiadata.getQiaIndicator5().get(i).getInputiiqa20t1());
			table5154.addCell(qiadata.getQiaIndicator5().get(i).getInputiiqa20t2());
		}

		cell117.addElement(table5154);

		table5154.setSpacingBefore(20f);
		
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
		table6154.setSpacingAfter(20f);
		
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
//					table4141.addCell(qiadata.getQiaIndicator7().get(i).getIiqa1t5());
//					table4141.addCell(qiadata.getQiaIndicator7().get(i).getIiqa1t6());
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
//				table1.addCell(cell703);
//				table1.addCell(cell704);
//				table1.addCell(cell705);
//				table1.addCell(cell706);
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

	public void Criteria1(Document document, Criteria1_FieldInfo criteria1Fieldinfo) {
		Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font2);
		paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		paragraph1.setSpacingBefore(3f);
		document.add(paragraph1);
		
		Paragraph paragraph0001 = new Paragraph("__________________________________________________________________________");
		paragraph0001.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph0001);
		
		
	
		Paragraph paragraph2 = new Paragraph(""
				+ "1.1 Curriculum Design and Development", font2);
		paragraph2.setSpacingAfter(8f);
		paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph2);

			
		PdfPTable table11111= new PdfPTable(1);

		table11111.setWidthPercentage(100);

		
		PdfPCell cell1222222222222 = new PdfPCell( new Paragraph(

				new Paragraph(
					"	1.1.1  Curricula developed and implemented have relevance to the local,"
					+"	national, regional and global developmental needs, which is"
					+"	reflected in the Programme outcomes (POs), and Course"
					+	"Outcomes(COs) of the Programmes offered by the University"
						+ ""
						+ ""
						+ "\r\n"
					
						+ "Response:"+(criteria1Record != null
						? criteria1Record.getCriteria11Ql().get(0).getResponse111()
						: ""
						+ "\r\n"
					
								), font4)));
		cell1222222222222.setExtraParagraphSpace(5f);

		table11111.addCell(cell1222222222222);
		
    document.add(table11111);
		

		
		// creating table
					PdfPTable table = new PdfPTable(2);

					table.setWidthPercentage(100);

					// create table for header
					PdfPCell cell1 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell cell2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					PdfPCell cell3 = new PdfPCell(new Paragraph("\r\nAny Upload aditional information\r\n\r\n", font5));
					cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					PdfPCell cell4 = new PdfPCell(
							new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "", font5));
					
					cell4.setExtraParagraphSpace(10F);
					cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					PdfPCell cell5 = new PdfPCell(new Paragraph("\r\nLink for Aditional information\r\n\r\n", font5));
					cell5.setExtraParagraphSpace(5f);
					cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					PdfPCell cell6 = new PdfPCell(new Paragraph(" "));
					cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
					
					
					table.addCell(cell1);
					table.addCell(cell2);
					table.addCell(cell3);
					table.addCell(cell4);
					table.addCell(cell5);
					table.addCell(cell6);
					
					table.setSpacingBefore(20f);
					table.setSpacingAfter(20f);
					
					document.add(table);	
					
					
					
					
					PdfPTable table000 = new PdfPTable(1);

					table000.setWidthPercentage(100);		
					
					PdfPCell cell00005 = new PdfPCell(new Paragraph(
					""
					+ "1.1.2 The Programmes offered by the institution focus on employability/\r\n"
					+ "entrepreneurship/ skill development and their course syllabi are\r\n"
					+ "adequately revised to incorporate contemporary requirements.\r\n"
					+ ""
					+ ""
									+"Response:"
											+ (criteria1Record != null
											? criteria1Record.getCriteria11Qn().get(0).getResponse112()
													: ""
													+ "\r\n" ),
							font4));
					
					cell00005.setExtraParagraphSpace(10f);
					table000.addCell(cell00005);
					
			
//////////////////////////////////////////////////////////	  	
					PdfPCell cell000051 = new PdfPCell( new Paragraph(
				""
				+ "1.1.2.1 How many Programmes were revised out of total number of Programmes offered during the last five years.\r\n\r\n"
						+ ""
					+"\r\n",
				font4));
					
					
	
					table000.addCell(cell000051);
					
		
	

	
					PdfPCell cell0000510 = new PdfPCell(new Paragraph(""
							+ "Response:"
				+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1121t1() : ""
						+ "\r\n" ),
				font4));
					cell0000510.setExtraParagraphSpace(10f);
					table000.addCell(cell0000510);
	
		
	

					PdfPCell cell01000510 = new PdfPCell( new Paragraph(
				""
				+ "1.1.2.2 Number of all Programmes offered by the institution during the last five years"			+"\r\n\r\n",
				font4));

					table000.addCell(cell01000510);


					PdfPCell cell010005101 = new PdfPCell(new Paragraph(""
							+ "Response:"
				+ (criteria1Record != null ? criteria1Record.getCriteria11Qn().get(0).getInput1122t1() : ""	+"\r\n\r\n"),
				font4));
					cell010005101.setExtraParagraphSpace(10f);
					table000.addCell(cell010005101);

     document.add(table000);

PdfPTable table1 = new PdfPTable(2);
table1.setWidthPercentage(100);


PdfPCell cell11 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
cell11.setHorizontalAlignment(Element.ALIGN_CENTER);

PdfPCell cell12 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
cell12.setHorizontalAlignment(Element.ALIGN_CENTER);

PdfPCell cell13 = new PdfPCell(new Paragraph("\r\nMinutes of relevant Academic Council/BOS meeting\r\n\r\n", font5));
cell13.setHorizontalAlignment(Element.ALIGN_CENTER);

PdfPCell cell14 = new PdfPCell(
		new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "", font5));
cell14.setHorizontalAlignment(Element.ALIGN_CENTER);

cell14.setExtraParagraphSpace(10f);

PdfPCell cell19 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n", font5));
cell19.setHorizontalAlignment(Element.ALIGN_CENTER);

PdfPCell cell20 = new PdfPCell(new Paragraph("", font5));
cell20.setHorizontalAlignment(Element.ALIGN_CENTER);

PdfPCell cell17 = new PdfPCell(new Paragraph("\r\nDetails of program syllabus revision in last 5 years(Data Template)"
		+ ""
		+ "\r\n"
		
		, font5));
cell17.setExtraParagraphSpace(10F);

cell17.setHorizontalAlignment(Element.ALIGN_CENTER);


PdfPCell cell18 = new PdfPCell(
		new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : "", font5));
cell18.setExtraParagraphSpace(10f);

cell18.setHorizontalAlignment(Element.ALIGN_CENTER);


table1.addCell(cell11);
table1.addCell(cell12);
table1.addCell(cell13);
table1.addCell(cell14);
table1.addCell(cell19);
table1.addCell(cell20);
table1.addCell(cell17);
table1.addCell(cell18);

table1.setSpacingBefore(20f);
table1.setSpacingAfter(20);
document.add(table1);

PdfPTable table31 = new PdfPTable(1);
table31.setWidthPercentage(100);


PdfPCell cell00017 = new PdfPCell(new Paragraph(
		"1.1.3 Average percentage of courses having focus on employability/ entrepreneurship/ skill development offered by the institution during the last five years"
				+"\r\n\r\n"
				+ "\r\n" + "Response:"
				+ (criteria1Record != null
				? criteria1Record.getCriteria11Qn().get(0).getResponse113()
				: ""	+"\r\n\r\n"),font4));
cell00017.setExtraParagraphSpace(5f);
table31.addCell(cell00017);

PdfPCell cell00018 = new PdfPCell(new Paragraph(
		"1.1.3.1 Number of courses having focus on employability/ entrepreneurship/ skill development year- wise during the last five years"
		+ "\r\n\r\n",font4));

table31.addCell(cell00018);

// table31.addCell(table113_1);


document.add(table31);



if(criteria1Record.getYearTable1131().size() >0)
{
Table table1131 = new Table(criteria1Record.getYearTable1131().size(), 2);

table1131.setPadding(5f);
table1131.setWidth(100f);

for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
	Cell cell000001=new Cell(new Paragraph(criteria1Record.getYearTable1131().get(i).getInput1131y(),font5));
	cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
	table1131.addCell(cell000001);

}
for (int i = 0; i < criteria1Record.getYearTable1131().size(); i++) {
	Cell cell000003=new Cell(new Paragraph(criteria1Record.getYearTable1131().get(i).getInput1131v(),font5));
	cell000003.setHorizontalAlignment(Element.ALIGN_CENTER);
	table1131.addCell(cell000003);


}

document.add(table1131);
}

if(criteria1Record.getYearTable1131().size() >0)
{

Table table11312 = new Table(criteria1Record.getYearTable11312().size(), 2);

table11312.setPadding(5f);
table11312.setWidth(100f);

for (int i = 0; i < criteria1Record.getYearTable11312().size(); i++) {
	Cell cell000005=new Cell(new Paragraph(criteria1Record.getYearTable11312().get(i).getInput11312y(),font5));
	cell000005.setHorizontalAlignment(Element.ALIGN_CENTER);
	table11312.addCell(cell000005);
}
for (int i = 0; i < criteria1Record.getYearTable11312().size(); i++) {
	Cell cell0000025=new Cell(new Paragraph(criteria1Record.getYearTable11312().get(i).getInput11312v(),font5));
	cell0000025.setHorizontalAlignment(Element.ALIGN_CENTER);
	table11312.addCell(cell0000025);
	
}

document.add(table11312);
}


	

	

		PdfPTable table3 = new PdfPTable(2);
		table3.setWidthPercentage(100);

		PdfPCell cell31 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
		cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell32 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
		cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell33 = new PdfPCell(new Paragraph("\r\nProgramme / Curriculum/ Syllabus of the courses\r\n\r\n", font5));
		cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell34 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : "", font5));
		
		cell34.setExtraParagraphSpace(10f);
		
		cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell35 = new PdfPCell(new Paragraph("\r\nMoU's with relevant organizations for these courses, if any\r\n\r\n", font5));
		cell35.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell36 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : "", font5));
		cell36.setExtraParagraphSpace(10f);
		cell36.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell37 = new PdfPCell(new Paragraph(
				"\r\nMinutes of the Boards of Studies/ Academic Council meetings with approvals for these courses\r\n\r\n", font5));
		cell37.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell38 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : "",font5));
		cell38.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell38.setExtraParagraphSpace(10f);
		
		
		//cell31.setHorizontalAlignment(Element.ALIGN_CENTER); 
		PdfPCell cell39 = new PdfPCell(new Paragraph(
				"\r\nAverage percentage of courses having focus on employability/ entrepreneurship(Data Template)\r\n\r\n",font5));
		cell39.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell40 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
		cell40.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell40.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell41 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n",font5));
		cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell42 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
		cell42.setHorizontalAlignment(Element.ALIGN_CENTER); 
		cell42.setExtraParagraphSpace(10f);
		
		
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
		
		
		table3.setSpacingBefore(20f);
		table3.setSpacingAfter(20F);
		document.add(table3);
		
		// 1.2 
		Paragraph paragraph43 = new Paragraph("1.2 Academic Flexibility\r\n", font2);
		paragraph43.setSpacingAfter(5f);
		
		paragraph43.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph43);
		
		//+"\r\n\r\n"

		PdfPTable table301 = new PdfPTable(1);
		table301.setWidthPercentage(100);
		PdfPCell cell44444442 = new PdfPCell(new Paragraph(
				"1.2.1: Percentage of new courses introduced of the total number of courses across all programs offered during the last five years"
					
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria12Qn().get(0).getResponse121()
								: ""
								+"\r\n\r\n"),font4));
		cell44444442.setExtraParagraphSpace(10f);
		
		table301.addCell(cell44444442)	;				
								
								
		PdfPCell cell444444421 = new PdfPCell(new Paragraph(
				"1.2.1.1: How many new courses are introduced within the last five years.\r\n"
			
						+ (criteria1Record != null
								? criteria1Record.getCriteria12Qn().get(0).getInput1211t1()
								: ""
								+ "\r\n" ),font4));
		cell444444421.setExtraParagraphSpace(10f);
		table301.addCell(cell444444421)	;	
		
		PdfPCell cell44444421 = new PdfPCell(new Paragraph(
				"1.2.1.2: Consolidated number of courses offered by the institution\r\n"
				+ "across all Programmes (without repeat count) during the last five years"
						+"\r\n"
					 ,font4));
		
		
//						+ (criteria1Record != null
//								? criteria1Record.getCriteria1FieldInfoQn().get(0).getInput1212t2()
//								: ""));
		table301.addCell(cell44444421)	;	
		
		document.add(table301);
		
		
		

		// creating tabl4

		PdfPTable table4 = new PdfPTable(2);
		table4.setWidthPercentage(100);
		PdfPTable table41 = new PdfPTable(1);
		table41.setWidthPercentage(100);

		/*
		 * com.lowagie.text.Font font4 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		 * font4.setColor(CMYKColor.BLACK);
		 */
		PdfPCell cell411 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font4));
		cell411.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell411.setExtraParagraphSpace(10f);
		
		PdfPCell cell412 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
		cell412.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell412.setExtraParagraphSpace(10f);
		
		PdfPCell cell413 = new PdfPCell(new Paragraph("\r\nMinutes of relevant Academic Council/BOS meetings\r\n\r\n",font5));
		cell413.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell414 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell414.setExtraParagraphSpace(10f);
		
		cell414.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell415 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n",font5));
		
		
		cell415.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell416 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : "",font5));
		cell416.setExtraParagraphSpace(10f);
		
		cell416.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell417 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n",font5));

		
		cell417.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell418 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(3).getCriteria1FilePath() : "",font5));
		
		cell418.setExtraParagraphSpace(10f);
		cell418.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell419 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n",font5));
		cell419.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell420 = new PdfPCell(new Paragraph("",font5));
		
		cell420.setExtraParagraphSpace(10f);
		cell420.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
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
		table4.setSpacingAfter(20f);
		table4.setSpacingAfter(20f);
		
		document.add(table4);
		
		//+"\r\n\r\n"
		
		
		PdfPTable table22 = new PdfPTable(1);
		table22.setWidthPercentage(100);
		PdfPCell cell11420 = new PdfPCell(new Paragraph(
				"1.2.2: Percentage of Programmes in which Choice Based Credit System (CBCS) / elective course system has been implemented (Data for the latest completed academic year).\r\n"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria12Qn().get(0).getResponse122()
								: ""
								+ "\r\n" ),font4));
		
		cell11420.setExtraParagraphSpace(10f);
		table22.addCell(cell11420);
		
		PdfPCell cell11422220 = new PdfPCell(new Paragraph(
				"1.2.2.1: Number of Programmes in which CBCS / Elective course system implemented.\r\n"
			
						+ (criteria1Record != null
								? criteria1Record.getCriteria12Qn().get(0).getInput1221t1()
								: ""
								+ "\r\n" ),font4));
		cell11422220.setExtraParagraphSpace(10f);
		table22.addCell(cell11422220);
		
		PdfPCell cell1142220 = new PdfPCell(new Paragraph(
				"1.2.2.1: Total number of Programmes offered\r\n"
			
						+ (criteria1Record != null
								? criteria1Record.getCriteria12Qn().get(0).getInput1221t2()
								: ""
								+ "\r\n" ),font4));
		
		
		cell1142220.setExtraParagraphSpace(10f);
		table22.addCell(cell1142220);
		
		
		document.add(table22);
		
		
		
		
		

		PdfPTable table5 = new PdfPTable(2);
		table5.setWidthPercentage(100);
	    PdfPCell cell511 = new PdfPCell(new Paragraph("\r\n\r\nFileDiscription\r\n\r\n", font4));
	    cell511.setHorizontalAlignment(Element.ALIGN_CENTER);
	    
		PdfPCell cell512 = new PdfPCell(new Paragraph("\r\n\r\nDocument\r\n\r\n", font4));
		cell512.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell513 = new PdfPCell(new Paragraph("\r\n\r\nMinutes of relevant Academic Council/BOS meetings\r\n",font5));
		cell513.setExtraParagraphSpace(8f);
		cell513.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell514 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : "",font5));
		cell514.setExtraParagraphSpace(10f);
		
		cell514.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell515 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n",font5));
		cell515.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell516 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : "",font5));
		
		cell516.setExtraParagraphSpace(10f);
		cell516.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell517 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n",font5));
		cell517.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell518 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : "",font5));
		
		cell518.setExtraParagraphSpace(10f);
		cell518.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell519 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n",font5));
		cell519.setExtraParagraphSpace(10f);
		cell519.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell520 = new PdfPCell(new Paragraph("",font5));
		cell520.setHorizontalAlignment(Element.ALIGN_CENTER);
		

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
		table5.setSpacingAfter(20f);
		table5.setSpacingBefore(20f);
		
		document.add(table5);
		
		//+"\r\n\r\n"
		// ,1.3 
		Paragraph paragraph54 = new Paragraph("\r\n 1.3 Curriculum Enrichment\r\n", font2);
		paragraph54.setSpacingAfter(5f);
		
		paragraph54.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph54);
		
		PdfPTable table61 = new PdfPTable(1);
		table61.setWidthPercentage(100);
		
		
		PdfPCell cell000519 = new PdfPCell( new Paragraph(
				"1.3.1: Institution integrates cross-cutting issues relevant to Professional\r\n"
				+ "Ethics, Gender, Human Values, Environment & Sustainability and\r\n"
				+ "other value framework enshrined in Sustainable Development\r\n"
				+ "goals and National Education Policy – 2020 into the Curriculum\r\n"
				 + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria13Ql().get(0).getResponse131()
								: ""
								+ "\r\n" ),font4));
		
		cell000519.setExtraParagraphSpace(10f);
		table61.addCell(cell000519);
		
		document.add(table61);

		// create table6

		PdfPTable table6 = new PdfPTable(2);
		table6.setWidthPercentage(100);
		

		

		PdfPCell cell611 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font4));
		cell611.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell612 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n\r\n", font4));
		cell612.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell613 = new PdfPCell(new Paragraph(
				"\r\nUpload the list and description of the courses which address the Gender, Environment and Sustainability, Human Values and Professional Ethics into the Curriculum\r\n\r\n",font5));
		cell613.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell614 = new PdfPCell(
				new Paragraph((
						criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : ""
							+"\r\n",font5));
		cell614.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell614.setExtraParagraphSpace(10f);
		PdfPCell cell615 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n",font5));
		cell615.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell616 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell616.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell616.setExtraParagraphSpace(10f);
		
		
		table6.addCell(cell611);
		table6.addCell(cell612);
		
		table6.addCell(cell615);
		table6.addCell(cell616);
		table6.addCell(cell613);
		table6.addCell(cell614);
		table6.setSpacingBefore(20f);
		table6.setSpacingBefore(20f);
		
		document.add(table6);

		
		

		PdfPTable table81 = new PdfPTable(1);
		table81.setWidthPercentage(100);

		PdfPCell cell000613 = new PdfPCell(new Paragraph(
				"1.3.2: Number of certificate / value-added courses / Diploma Programme/\r\n"
				+ "online courses of MOOCS / SWAYAM / e_Pathshala/ NPTEL etc.\r\n"
				+ "where the students of the institution have enrolled and successfully\r\n"
				+ "completed"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria13Qn().get(0).getResponse133()
								: ""
								+ "\r\n" 
								+ "\r\n" ),font4));
		cell000613.setExtraParagraphSpace(10f);
		
		table81.addCell(cell000613);
		
		
		PdfPCell cell0006113 = new PdfPCell(new Paragraph(
				"1.3.2.1: How many certificate/value added courses/Diploma\r\n"
				+ "Programme/ online courses of MOOCS/SWAYAM/e Pathshala/\r\n"
				+ "NPTEL etc (without repeat count) where the students of the institution\r\n"
				+ "have enrolled and successfully completed."
						+ "\r\n",font4));
		
		cell0006113.setExtraParagraphSpace(10f);
		table81.addCell(cell0006113);
		
		document.add(table81);
	
		// year table 1321
		if(criteria1Record.getYearTable1321() !=null)
		{

		Table table1321 = new Table(criteria1Record.getYearTable1321().size(), 2);

		table1321.setPadding(5f);
		table1321.setWidth(100f);

		for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {
			Cell cell10000=new Cell(new Paragraph(criteria1Record.getYearTable1321().get(i).getInput1321y(),font5));
			cell10000.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1321.addCell(cell10000);
		
		}
		for (int i = 0; i < criteria1Record.getYearTable1321().size(); i++) {
			Cell cell100090=new Cell(new Paragraph(criteria1Record.getYearTable1321().get(i).getInput1321v(),font5));
			cell100090.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1321.addCell(cell100090);
		
		}

	 document.add(table1321);
		}
	 
	 

	

		PdfPTable table8 = new PdfPTable(2);
		table8.setWidthPercentage(100);
	
		PdfPCell cell81 = new PdfPCell(new Paragraph("\r\n\r\nFileDiscription\r\n", font4));
		cell81.setExtraParagraphSpace(5f);
		cell81.setHorizontalAlignment(Element.ALIGN_CENTER);
	//	cell81.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell82 = new PdfPCell(new Paragraph("\r\n\r\nDocument\r\n", font4));
		cell82.setExtraParagraphSpace(5f);
		cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell83 = new PdfPCell(new Paragraph("\r\nList of value added courses (Data Template)\r\n",font5));
		cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell84 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : "",font5));
		cell84.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell84.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell85 = new PdfPCell(new Paragraph("\r\nBrochure or any other document relating to value added courses\r\n\r\n",font5));
		cell85.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell86 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(2).getCriteria1FilePath() : "",font5));
		cell86.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell86.setExtraParagraphSpace(10f);
		
		PdfPCell cell87 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
		cell87.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell88 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(3).getCriteria1FilePath() : "",font5));
		cell88.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell88.setExtraParagraphSpace(10f);
		PdfPCell cell89 = new PdfPCell(new Paragraph("\r\n Link for Additional Information\r\n\r\n",font5));
		cell89.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell90 = new PdfPCell(new Paragraph("",font5));
		cell90.setHorizontalAlignment(Element.ALIGN_CENTER);
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
		
		table8.setSpacingAfter(20f);
		table8.setSpacingBefore(20f);
		document.add(table8);
		
		
		// create table9
	
		PdfPTable table91 = new PdfPTable(1);
		table91.setWidthPercentage(100);
		
		PdfPCell cell80008 = new PdfPCell(	new Paragraph(
				"1.3.3: Percentage of Programmes that have components of field projects /\r\n"
				+ "research projects / internships during last five years"
						+ "\r\n"
					 + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria13Qn().get(0).getResponse133()
								: ""
								+ "\r\n"	),font4));
		
		cell80008.setExtraParagraphSpace(10f);
		table91.addCell(cell80008);
		
		
		
		PdfPCell cell800081 = new PdfPCell(new Paragraph(
				"1.3.3.1: Number of programmes that have components of field\r\n"
				+ "projects/research projects/internships (without repeat count) during last five\r\n"
				+ "years"
				+ (criteria1Record != null
				? criteria1Record.getCriteria13Qn().get(1).getResponse133()
				: ""
				
						+ "\r\n"
						+ "\r\n"),font4 ));
		
		cell800081.setExtraParagraphSpace(10f);
		
    table91.addCell(cell800081);
    
    
    
	PdfPCell cell8000821 = new PdfPCell(new Paragraph(
			"1.3.3.2: Number of programmes offered (without repeat count) during last\r\n"
			+ "five years"
			+ (criteria1Record != null
			? criteria1Record.getCriteria13Qn().get(2).getResponse133()
			: ""
			
					+ "\r\n"
					+ "\r\n"),font4 ));
	
	cell8000821.setExtraParagraphSpace(10f);
	
table91.addCell(cell8000821);
    
    
		
		document.add(table91);
		
		
		if(criteria1Record.getYearTable1331()!=null)
		{
					Table table1331 = new Table(criteria1Record.getYearTable1331().size(), 2);

					table1331.setPadding(5);
					table1331.setWidth(100f);

					for (int i = 0; i < criteria1Record.getYearTable1331().size(); i++) {
						Cell cell100001=new Cell(new Paragraph((criteria1Record.getYearTable1331().get(i).getInput1331y()),font5));
						cell100001.setHorizontalAlignment(Element.ALIGN_CENTER);
						table1331.addCell(cell100001);
					
					}
					for (int i = 0; i < criteria1Record.getYearTable1331().size(); i++) {
						Cell cell100002=new Cell(new Paragraph(criteria1Record.getYearTable1331().get(i).getInput1331v(),font5));
						cell100002.setHorizontalAlignment(Element.ALIGN_CENTER);
						table1331.addCell(cell100002);
					
					}

				    document.add(table1331);
		}
		

		PdfPTable table900001 = new PdfPTable(1);
		table900001.setWidthPercentage(100);
		
		
		PdfPCell cell80008122 = new PdfPCell(new Paragraph(
				"1.3.3.1: Number of students enrolled in subject related Certificate or Add-on programs year wise during last five years"
						+ "\r\n"
						+ "\r\n",font4));
		
		cell80008122.setExtraParagraphSpace(10f);
        
		table900001.addCell(cell80008122);
		
		document.add(table900001);
		
		
		
		
if(criteria1Record.getYearTable13312() !=null)
{
	    Table table13312 = new Table(criteria1Record.getYearTable13312().size(), 2);

	    table13312.setPadding(5);
	    table13312.setWidth(100f);

		for (int i = 0; i < criteria1Record.getYearTable13312().size(); i++) {
			Cell cell1000011=new Cell(new Paragraph(criteria1Record.getYearTable13312().get(i).getInput13312y(),font5));
			cell1000011.setHorizontalAlignment(Element.ALIGN_CENTER);
			table13312.addCell(cell1000011);
			
		}
		for (int i = 0; i < criteria1Record.getYearTable13312().size(); i++) {
			Cell cell100011011=new Cell(new Paragraph(criteria1Record.getYearTable13312().get(i).getInput13312v(),font5));
			
			cell100011011.setHorizontalAlignment(Element.ALIGN_CENTER);
			table13312.addCell(cell100011011);
			
		}

	    document.add(table13312);
	 
}
	    
	    
	    ///////////////////
	    
	    

		PdfPTable table92 = new PdfPTable(2);

		table92.setWidthPercentage(100);

		PdfPCell cell921 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font4));
		cell921.setExtraParagraphSpace(5f);
		cell921.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell922 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
		cell922.setExtraParagraphSpace(5f);
		cell922.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell923 = new PdfPCell(new Paragraph("\r\n  Any additional information\r\n", font5));
		cell923.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell924 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : "", font5));
		cell924.setExtraParagraphSpace(10f);
		cell924.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell925 = new PdfPCell(new Paragraph("\r\nList of students enrolled(Data template)\r\n\r\n", font5));
		cell925.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell926 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : ""
				+ "\r\n" , font5));
		cell926.setExtraParagraphSpace(10f);
		cell926.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table92.addCell(cell921);
		table92.addCell(cell922);
		table92.addCell(cell923);
		table92.addCell(cell924);
		table92.addCell(cell925);
		table92.addCell(cell926);
		table92.setSpacingBefore(20F);
		table92.setSpacingAfter(20F);
		document.add(table92);
		
		
		
		PdfPTable table101 = new PdfPTable(1);
		table101.setWidthPercentage(100);

		PdfPCell cell92611 = new PdfPCell(new Paragraph(
				"1.3.4: Percentage of students undertaking field projects/ internships / student projects (Data for the latest completed academic year)."
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria13Qn().get(0).getResponse134()
								: ""
								+ "\r\n" 		),font4));
		
		cell92611.setExtraParagraphSpace(10f);
		table101.addCell(cell92611);
		
		
		
		PdfPCell cell926111 = new PdfPCell(new Paragraph(
				"1.3.4.1: Number of students undertaking field projects / internships / student projects"
						+ "\r\n" 
						+ (criteria1Record != null
								? criteria1Record.getCriteria13Qn().get(0).getInput1341t1()
								: ""
								+ "\r\n" ),font4));
		
		cell926111.setExtraParagraphSpace(10f);
		
		table101.addCell(cell926111);
		
		PdfPCell cell9261111 = new PdfPCell(new Paragraph(
				"1.3.4.1: Number of students undertaking field projects / internships / student projects"
						+ "\r\n" 
						+ (criteria1Record != null
								? criteria1Record.getCriteria13Qn().get(0).getInput1341t2()
								: ""
								+ "\r\n" ),font4));
		
		cell9261111.setExtraParagraphSpace(10f);
		table101.addCell(cell9261111);
		
		
		document.add(table101);
		
		
		// create table10
		PdfPTable table10 = new PdfPTable(2);
		table10.setWidthPercentage(100);

		

		PdfPCell cell101 = new PdfPCell(new Paragraph("\r\n\r\nFileDiscription\r\n", font4));
		cell101.setExtraParagraphSpace(5f);
		cell101.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell102 = new PdfPCell(new Paragraph("\r\n\r\nDocument\r\n\r\n", font4));
		cell102.setExtraParagraphSpace(5f);
		cell102.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell103 = new PdfPCell(new Paragraph(
				"\r\n\r\n Any additional information\r\n\r\n"));
		cell103.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell104 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : "",font5));
		cell104.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell104.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell105 = new PdfPCell(new Paragraph("\r\n\r\nList of programs and number of students undertaking field projects / internships / student projects (Data Template)\r\n",font5));
		cell105.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell106 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() : "",font5));
		cell106.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell106.setExtraParagraphSpace(10f);
		
		table10.addCell(cell101);
		table10.addCell(cell102);
		table10.addCell(cell103);
		table10.addCell(cell104);
		table10.addCell(cell105);
		table10.addCell(cell106);
		table10.setSpacingBefore(20f);
		table10.setSpacingAfter(20f);
        document.add(table10);

		// 1.4 
        
        
        
        Paragraph paragraph67 = new Paragraph("\r\n 1.4  Feedback System\r\n", font2);
        
        paragraph67.setSpacingAfter(5F);
		paragraph67.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(paragraph67);

		PdfPTable table110 = new PdfPTable(1);
		table110.setWidthPercentage(100);
		
		
		PdfPCell cell10511 = new PdfPCell(new Paragraph(
				"1.4.1 Structured feedback for design and review of syllabus � semester-wise / year-wise is received from 1) Students, 2) Teachers, 3) Employers, 4) Alumni\r\n"
					
						+ "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria14Qn().get(0).getResponse141()
								: ""
								+ "\r\n" ),font4));
		cell10511.setExtraParagraphSpace(10f);
		table110.addCell(cell10511);

		document.add(table110);

		PdfPTable table111 = new PdfPTable(2);
		table111.setWidthPercentage(100);

		PdfPCell cell111 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
		cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell112 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell113 = new PdfPCell(new Paragraph("\r\nURL for stakeholder feedback report\r\n",font5));
		cell113.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell114 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell114.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell114.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell115 = new PdfPCell(new Paragraph(
				"Action taken report of the Institution on feedback report as minuted by the Governing Council,Syndicate, Board of Management",font5));
		cell115.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell115.setExtraParagraphSpace(10f);
		
		PdfPCell cell116 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell116.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell116.setExtraParagraphSpace(10f);
		
		PdfPCell cell117 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n",font5));
		cell117.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell118 = new PdfPCell(
				new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""
						+ "\r\n" ,font5));
		cell118.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell118.setExtraParagraphSpace(10f);
		
		
		table111.addCell(cell111);
		table111.addCell(cell112);
		table111.addCell(cell113);
		table111.addCell(cell114);
		table111.addCell(cell115);
		table111.addCell(cell116);
		table111.addCell(cell117);
		table111.addCell(cell118);
		document.add(table111);
		table111.setSpacingBefore(20);
		table111.setSpacingAfter(20);

		

		// create table12

		PdfPTable table11 = new PdfPTable(1);
		table11.setWidthPercentage(100);

		PdfPCell cell0000121 = new PdfPCell(new Paragraph(
				"1.4.2: The feedback system of the Institution comprises of the following :\r\n"
				+ "A.Feedback collected, analysed and action taken and report made available on website\r\n"
				+ "B. Feedback collected, analysed and action taken\r\n"
				+ "C. Feedback collected and analysed\r\n"
				+ "D. Feedback collected\r\n"
				+ "E. Feedback not obtained\r\n"
						+ "\r\n" + "Response:"
						+ (criteria1Record != null
								? criteria1Record.getCriteria14Qn().get(0).getResponse142()
								: ""
								+ "\r\n" ),font4));
		
		cell0000121.setExtraParagraphSpace(10f);

		table11.addCell(cell0000121);
		
	//	document.add(table11);

		PdfPTable table12 = new PdfPTable(2);
		table12.setWidthPercentage(100);

		PdfPCell cell121 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
		cell121.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell122 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell122.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell123 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n",font5));
		cell123.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell124 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : "",font5));
		cell124.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell124.setExtraParagraphSpace(10f);

		
		PdfPCell cell125 = new PdfPCell(new Paragraph("\r\n URL for stakeholder feedback report\r\n"));
		cell125.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell126 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""
				+ "\r\n" ,font5));
		cell126.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell126.setExtraParagraphSpace(10f);
		
		table12.addCell(cell121);
		table12.addCell(cell122);
		table12.addCell(cell123);
		table12.addCell(cell124);
		table12.addCell(cell125);
		table12.addCell(cell126);

		table12.setSpacingAfter(20f);
		table12.setSpacingAfter(20f);

	//	document.add(table12);
		
		}

	//////////////////////////////////////////////////// 2.1
	
	
	public void Criteria2(Document document, Criteria2_FieldInfo criteria2Fieldinfo) {	
		// 2.1
		PdfPTable tablecriteria2 = new PdfPTable(1);
		PdfPTable table1criteria2 = new PdfPTable(1);

		

	
		

		Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation", font2);
	    paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
	    paragraph2criteria2.setSpacingBefore(3f);
		
		document.add(paragraph2criteria2);
		
		

		Paragraph paragraph2criteria11112 = new Paragraph("___________________________________________________________________________");
		paragraph2criteria11112.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
		
		document.add(paragraph2criteria11112);
		
		
		
		Paragraph paragraph3criteria2 = new Paragraph("2.1 Student Enrollment and Profile\r\n", font2);

		paragraph3criteria2.setSpacingAfter(9f);
		paragraph3criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);


		document.add(paragraph3criteria2);

		tablecriteria2.setWidthPercentage(100f);
		
		PdfPCell cell100criteria2 = new PdfPCell(new Paragraph("2.1.1 Enrollment Percentage\r\n"
					 + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria21Qn().get(0).getResponse211()
								: ""),font4));
		
		cell100criteria2.setExtraParagraphSpace(5f);
		
		tablecriteria2.addCell(cell100criteria2);
		
		PdfPCell cell100criteria2222222222 = new PdfPCell(new Paragraph("2.1.1.1:Number of Sanctioned seats year-wise during the last five years\r\n\r\n ",font4));
		tablecriteria2.addCell(cell100criteria2222222222);
		
		
		PdfPCell cell100criteria2000 = new PdfPCell(new Paragraph("2.1.1.2:  Number of seats filled year-wise during the last five years,\r\n\r\n ",font4));
		tablecriteria2.addCell(cell100criteria2000);
		
		
		document.add(tablecriteria2);

	
		Table table2111 = new Table(criteria2Record.getYearTable2111().size(), 2);

		table2111.setPadding(5f);
		table2111.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
			Cell cell1=new Cell(new Paragraph(criteria2Record.getYearTable2111().get(i).getInput2111y(),font5));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2111.addCell(cell1);
			
			
		
		
		}
		for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
			Cell cell2=new Cell(new Paragraph(criteria2Record.getYearTable2111().get(i).getInput2111v(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2111.addCell(cell2);
			
		}
		
		for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
			Cell cell2=new Cell(new Paragraph(criteria2Record.getYearTable2111().get(i).getInput2111v(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2111.addCell(cell2);
			
		}
		
		

	//	document.add(table2111);

	Table table2112 = new Table(criteria2Record.getYearTable2112().size(), 2);

		table2112.setPadding(5f);
		table2112.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
			Cell cell3=new Cell(new Paragraph(criteria2Record.getYearTable2112().get(i).getInput2112y(),font5));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2111.addCell(cell3);
		
		
		}
		for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
			Cell cell5=new Cell(new Paragraph(criteria2Record.getYearTable2112().get(i).getInput2112v()));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2111.addCell(cell5);
		}
		
		for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
			Cell cell5=new Cell(new Paragraph(criteria2Record.getYearTable2112().get(i).getInput2112n()));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2111.addCell(cell5);
		}
		

	document.add(table2112);
		
		

		PdfPTable table3criteria2 = new PdfPTable(2);
		table3criteria2.setWidthPercentage(100);
		

		PdfPCell cell1criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
		cell1criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell1criteria2);

		PdfPCell cell2criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
		cell2criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table3criteria2.addCell(cell2criteria2);

		PdfPCell cell3criteria2 = new PdfPCell(new Paragraph("\r\nDemand Ratio (Average of Last five years) based on Data Template upload the document\r\n",font5));
		cell3criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table3criteria2.addCell(cell3criteria2);

		PdfPCell cell4criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		
		cell4criteria2.setExtraParagraphSpace(5f);
		cell4criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table3criteria2.addCell(cell4criteria2);

		PdfPCell cell5criteria2 = new PdfPCell(new Paragraph("\r\nAny additional informatio\r\n",font5));
		cell5criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table3criteria2.addCell(cell5criteria2);

		PdfPCell cell6criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell6criteria2.setExtraParagraphSpace(5f);
		cell6criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table3criteria2.addCell(cell6criteria2);
		
		table3criteria2.setSpacingAfter(20f);
		table3criteria2.setSpacingBefore(20f);

		document.add(table3criteria2);
		
	
		
		table1criteria2.setWidthPercentage(100f);

		PdfPCell cell600criteria2 = new PdfPCell(
				new Paragraph(
				"2.1.2 Percentage of seats filled against reserved categories (SC, ST, OBC,\r\n"
				+ "etc.) as per applicable reservation policy for the first year admission\r\n"
				+ "year-wise during the last five years"
//				 +"Response: "
//						+ (criteria2Record != null
//								? criteria2Record.getCriteria21Qn().get(0).getResponse212()
//								: "")
						,font4));
		
		cell600criteria2.setExtraParagraphSpace(5f);
		PdfPCell cell601criteria2 = new PdfPCell(new Paragraph(("2.1.2.1  Number of actual students admitted against the reserved \r\n"
				+ "categories year-wise during the last five years\r\n\r\n" ),font4));
		PdfPCell cell602criteria2 = new PdfPCell(new Paragraph("2.1.2.2: Total number of seats earmarked for reserved category as per \r\n"
				+ "GOI or State Government rule year-wise during the last five years\r\n\r\n",font4));

		table1criteria2.addCell(cell600criteria2);
		table1criteria2.addCell(cell601criteria2);
		table1criteria2.addCell(cell602criteria2);
		document.add(table1criteria2);
		
		
		
		Table table2121 = new Table(criteria2Record.getYearTable2121().size(), 2);

		table2121.setPadding(5f);
		table2121.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
			Cell cell4=new Cell(new Paragraph((criteria2Record.getYearTable2121().get(i).getInput2121y()),font4));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2121.addCell(cell4);
			
		
		}
		for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
			Cell cell5=new Cell(new Paragraph((criteria2Record.getYearTable2121().get(i).getInput2121v()),font4));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2121.addCell(cell5);
			
		}
		
		

	//	document.add(table2121);

		
		Table table21212 = new Table(criteria2Record.getYearTable21212().size(), 2);

		table21212.setPadding(5f);
		table21212.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable21212().size(); i++) {
			Cell cell6=new Cell(new Paragraph((criteria2Record.getYearTable21212().get(i).getInput21212y())));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21212.addCell(cell6);
			
		}
		for (int i = 0; i < criteria2Record.getYearTable21212().size(); i++) {
			Cell cell7=new Cell(new Paragraph((criteria2Record.getYearTable21212().get(i).getInput21212v())));
			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21212.addCell(cell7);
			
			
		}
		

	for (int i = 0; i < criteria2Record.getYearTable21212().size(); i++) {
		Cell cell7=new Cell(new Paragraph((criteria2Record.getYearTable21212().get(i).getInput21212n())));
		cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21212.addCell(cell7);	
	}

	document.add(table21212);

		PdfPTable table07criteria2 = new PdfPTable(2);
        table07criteria2.setWidthPercentage(100);
		PdfPCell cell07criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
		cell07criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		table07criteria2.addCell(cell07criteria2);

		PdfPCell cell08criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
		
		cell08criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
	
		table07criteria2.addCell(cell08criteria2);

		PdfPCell cell09criteria2 = new PdfPCell(new Paragraph("\r\nAverage percentage of seats filled against seats\r\n"
				+ "reserved (Data Template)\r\n",font5));
		cell09criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table07criteria2.addCell(cell09criteria2);

		PdfPCell cell10criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell10criteria2.setExtraParagraphSpace(5f);
		
		cell10criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table07criteria2.addCell(cell10criteria2);

		PdfPCell cell11criteria2 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
		cell11criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table07criteria2.addCell(cell11criteria2);

		PdfPCell cell12criteria2 = new PdfPCell(new Paragraph("",font5));
		cell12criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table07criteria2.addCell(cell12criteria2);
		
		table07criteria2.setSpacingAfter(20f);
		
		table07criteria2.setSpacingBefore(20f);

		document.add(table07criteria2);

		
		// 2.2 
		
		Paragraph paragraph4criteria2 = new Paragraph("2.2 Catering to Student Diversity\r\n", font2);
		paragraph4criteria2.setSpacingAfter(5f);
		document.add(paragraph4criteria2);

		PdfPTable table01 = new PdfPTable(1);
		table01.setWidthPercentage(100f);
		PdfPCell cell120criteria2 = new PdfPCell(new Paragraph(
				"2.2.1	The institution assesses the learning levels of the students and \r\n"
				+ "organises special Programmes to cater to differential learning needs \r\n"
				+ "of the student"
					 + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria22Qn().get(0).getResponse221()
								: ""),font4));
		
		cell120criteria2.setExtraParagraphSpace(5f);
		
		table01.addCell(cell120criteria2);
		
		document.add(table01);

		PdfPTable table8criteria2 = new PdfPTable(2);

		table8criteria2.setWidthPercentage(100f);
		table8criteria2.setWidths(new int[] { 3, 3 });
		table8criteria2.setSpacingBefore(5);

		PdfPCell cell13criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
		cell13criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table8criteria2.addCell(cell13criteria2);

		PdfPCell cell14criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
		
		cell14criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
		table8criteria2.addCell(cell14criteria2);

		PdfPCell cell15criteria2 = new PdfPCell(new Paragraph("\r\nPaste link for Additional Information\r\n",font5));
		cell15criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		
		table8criteria2.addCell(cell15criteria2);

		PdfPCell cell16criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell16criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		cell16criteria2.setExtraParagraphSpace(5f);
		
		table8criteria2.addCell(cell16criteria2);
		
		PdfPCell cell17criteria2 = new PdfPCell(new Paragraph("Upload any Additional Information",font5));
		cell17criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		table8criteria2.addCell(cell17criteria2);
		
		
		PdfPCell cell18criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell18criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		cell18criteria2.setExtraParagraphSpace(5f);
		
		table8criteria2.addCell(cell18criteria2);
		
		table8criteria2.setSpacingAfter(20f);
		table8criteria2.setSpacingBefore(20f);

		document.add(table8criteria2);

		PdfPTable table02 = new PdfPTable(1);
		table02.setWidthPercentage(100f);
		PdfPCell cell150criteria2 = new PdfPCell(new Paragraph("2.2.2 Student - Full time teacher ratio (Data for the latest completed academic year)\r\n"
			 + "Response:"
				+ (criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getResponse222()
						: ""),font4));
		
		cell150criteria2.setExtraParagraphSpace(5f);
		
		cell150criteria2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		
		
		PdfPCell cell151criteria2 = new PdfPCell(new Paragraph("A.Total Number of students enrolled in the institution.\r\n"
		
				+ (criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getInput222t1()
						: ""),font4));
		
		cell151criteria2.setExtraParagraphSpace(5f);
		
		cell151criteria2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		PdfPCell cell152criteria2 = new PdfPCell(new Paragraph("B.Total number of full time teachers in the institution.\r\n"
				+ "\r\n" 
				+ (criteria2Record != null ? criteria2Record.getCriteria22Qn().get(0).getInput2221t2()
						: ""),font4));
		
		cell152criteria2.setExtraParagraphSpace(5f);
		
		cell152criteria2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		
		table02.addCell(cell150criteria2);
	//	table02.addCell(cell151criteria2);
	//	table02.addCell(cell152criteria2);
		document.add(table02);

		PdfPTable table9criteria2 = new PdfPTable(2);

		table9criteria2.setWidthPercentage(100f);
		table9criteria2.setWidths(new int[] { 3, 3 });
		table9criteria2.setSpacingBefore(5);

		PdfPCell cell107criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
		cell107criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table9criteria2.addCell(cell107criteria2);

		PdfPCell cell108criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell108criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table9criteria2.addCell(cell108criteria2);

		PdfPCell cell19criteria2 = new PdfPCell(new Paragraph("\r\n Additional Information\r\n\r\n",font5));
		cell19criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table9criteria2.addCell(cell19criteria2);

		PdfPCell cell20criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell20criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell20criteria2.setExtraParagraphSpace(5f);
		
		table9criteria2.addCell(cell20criteria2);
		table9criteria2.setSpacingAfter(20f);
		table9criteria2.setSpacingBefore(20f);

		document.add(table9criteria2);

		
		// 2.3 
		Paragraph paragraph5criteria2 = new Paragraph("2.3	Teaching- Learning Process", font2);
		paragraph5criteria2.setSpacingAfter(5f);
		document.add(paragraph5criteria2);

		PdfPTable table03 = new PdfPTable(1);
		table03.setWidthPercentage(100f);

		
		PdfPCell cell001 = new PdfPCell(new Paragraph(
				"2.3.1 Student centric methods, such as experiential learning, participative\r\n"
				+ "learning and problem solving methodologies are used for enhancing\r\n"
				+ "learning experience and teachers use ICT-enabled tools including\r\n"
				+ "online resources for effective teaching learning process"
						+ "\r\n" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria23Ql().get(0).getResponse231()
								: "")
						+

						 "",font4));
		
		
		
		
		cell001.setExtraParagraphSpace(5f);

		table03.addCell(cell001);

		document.add(table03);

		PdfPTable table10criteria2 = new PdfPTable(2);

		table10criteria2.setWidthPercentage(100f);
		table10criteria2.setWidths(new int[] { 3, 3 });
//		table10criteria2.setSpacingBefore(20);
//		table10criteria2.setSpacingAfter(20);

		PdfPCell cell21criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell21criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table10criteria2.addCell(cell21criteria2);

		PdfPCell cell22criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell22criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table10criteria2.addCell(cell22criteria2);

		PdfPCell cell23criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell23criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table10criteria2.addCell(cell23criteria2);

		PdfPCell cell24criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell24criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell24criteria2.setExtraParagraphSpace(5f);
		
		table10criteria2.addCell(cell24criteria2);
		
		
		PdfPCell cell25criteria2 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n",font5));
		cell25criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table10criteria2.addCell(cell25criteria2);
		PdfPCell cell26criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell26criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell26criteria2.setExtraParagraphSpace(5f);
		
		
		table10criteria2.addCell(cell26criteria2);
		
		
		table10criteria2.setSpacingAfter(20f);
		table10criteria2.setSpacingBefore(20f);


		document.add(table10criteria2);
		
		

		PdfPTable table04 = new PdfPTable(1);
		table04.setWidthPercentage(100f);

		PdfPCell cell002 = new PdfPCell(new Paragraph(
				"2.3.2 The institution adopts effective Mentor-Mentee Schemes to address\r\n"
				+ "academics and student-psychological issues."
				 + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria23Ql().get(0).getResponse232()
								: ""),font4 ));
		
		cell002.setExtraParagraphSpace(5f);

		table04.addCell(cell002);

		document.add(table04);

		PdfPTable table11criteria2 = new PdfPTable(2);

		table11criteria2.setWidthPercentage(100f);
		table11criteria2.setWidths(new int[] { 3, 3 });
		table11criteria2.setSpacingBefore(5);

		PdfPCell cell205criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell205criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table11criteria2.addCell(cell205criteria2);

		PdfPCell cell206criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell206criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table11criteria2.addCell(cell206criteria2);

		PdfPCell cell27criteria2 = new PdfPCell(new Paragraph(
				"Upload any additional information",font5));
		cell27criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table11criteria2.addCell(cell27criteria2);

		PdfPCell cell28criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell28criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell28criteria2.setExtraParagraphSpace(5f);
		
		table11criteria2.addCell(cell28criteria2);

		PdfPCell cell29criteria2 = new PdfPCell(new Paragraph("Provide link for webpage describing the \" LMS/\r\n"
				+ "Academic management system",font5));
		cell29criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table11criteria2.addCell(cell29criteria2);

		PdfPCell cell30criteria2 = new PdfPCell(new Paragraph("",font5));
		cell30criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table11criteria2.addCell(cell30criteria2);
		
		
		table11criteria2.setSpacingAfter(20F);
		table11criteria2.setSpacingBefore(20F);
		
		document.add(table11criteria2);
		
		

		PdfPTable table05 = new PdfPTable(1);
		table05.setWidthPercentage(100f);

		PdfPCell cell1500criteria2 = new PdfPCell(new Paragraph(
				"2.3.3 Ratio of students to mentor for academic and other related issues (Data for the latest completed academic year )\r\n"
						 + "\"Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria23Qn().get(0).getResponse233()
								: ""),font4));
		
		cell1500criteria2.setExtraParagraphSpace(5f);
		

		PdfPCell cell1501criteria2 = new PdfPCell(new Paragraph("2.3.3.1 Number of mentors \r\n" 
				+ (criteria2Record != null ? criteria2Record.getCriteria23Qn().get(0).getInput2331t1() : ""),font4));
		cell1501criteria2.setExtraParagraphSpace(5f);
		PdfPCell cell1502criteria2 = new PdfPCell(new Paragraph("2.3.3.1Number of students assigned to each Mentor"
				+ (criteria2Record != null ? criteria2Record.getCriteria23Qn().get(0).getInput2331t2() : ""),font4));
		cell1502criteria2.setExtraParagraphSpace(5f);
		
		table05.addCell(cell1500criteria2);
		table05.addCell(cell1501criteria2);
		table05.addCell(cell1502criteria2);
		
	//	document.add(table05);

		PdfPTable table13criteria2 = new PdfPTable(2);

		table13criteria2.setWidthPercentage(100f);
		table13criteria2.setWidths(new int[] { 3, 3 });
		
		table13criteria2.setSpacingBefore(20f);
		table13criteria2.setSpacingAfter(20f);

		PdfPCell cell31criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell31criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table13criteria2.addCell(cell31criteria2);

		PdfPCell cell32criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell31criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table13criteria2.addCell(cell32criteria2);

		PdfPCell cell33criteria2 = new PdfPCell(
				new Paragraph("Upload year wise, number of students enrolled and full time teachers on roll\r\n\r\n",font5));
		cell33criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table13criteria2.addCell(cell33criteria2);

		PdfPCell cell34criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell34criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell34criteria2.setExtraParagraphSpace(5f);
		
		
		table13criteria2.addCell(cell34criteria2);

		PdfPCell cell35criteria2 = new PdfPCell(new Paragraph("\r\nmentor/mentee ratio",font5));
		cell35criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table13criteria2.addCell(cell35criteria2);

		PdfPCell cell36criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell36criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell36criteria2.setExtraParagraphSpace(5f);
		
		
		table13criteria2.addCell(cell36criteria2);

		PdfPCell cell37criteria2 = new PdfPCell(new Paragraph("Circulars pertaining to assigning mentors to mentees\r\n\r\n",font5));
		cell37criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell37criteria2.setExtraParagraphSpace(5f);
		table13criteria2.addCell(cell37criteria2);

		PdfPCell cell38criteria2 = new PdfPCell(new Paragraph("",font5));
		cell38criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table13criteria2.addCell(cell38criteria2);
		
		table13criteria2.setSpacingAfter(20f);
		table13criteria2.setSpacingBefore(20f);

//		document.add(table13criteria2);

		
		 // 2.4 
		
		Paragraph paragraph6criteria2 = new Paragraph(" 2.4 Teacher Profile and Quality\r\n", font2);
		paragraph6criteria2.setSpacingAfter(4f);
		paragraph6criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph6criteria2);

		PdfPTable table07 = new PdfPTable(1);
		table07.setWidthPercentage(100f);

		PdfPCell cell37criteria2111 = new PdfPCell( new Paragraph(
				"2.4.1 Percentage of full time teachers appointed against the number of\r\n"
				+ "sanctioned posts during the last five years"
						+ "\r\n" + "" + "",font4));
		cell37criteria2111.setExtraParagraphSpace(5f);
		
		table07.addCell(cell37criteria2111);
		
		
		
		PdfPCell cell37criteria21101 = new PdfPCell( new Paragraph(
				"2.4.1.1: Total Number of Sanctioned posts during last five years\r\n"
			
					+ "",font4));
		cell37criteria21101.setExtraParagraphSpace(5f);
		
		table07.addCell(cell37criteria21101);
		
		
		
		
		if(criteria2Record.getCriteria24Qn() !=null)
		{
			PdfPCell cell371criteria2111 = new PdfPCell(new Paragraph(criteria2Record != null
								? criteria2Record.getCriteria24Qn().get(0).getResponse241()
								: "",font4));
			
			cell371criteria2111.setExtraParagraphSpace(5f);
			table07.addCell(cell371criteria2111);
		}
		
		document.add(table07);
		
		
		PdfPTable table14 = new PdfPTable(2);

		table14.setWidthPercentage(100f);
		

		PdfPCell cell43 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell43.setHorizontalAlignment(Element.ALIGN_CENTER);
		table14.addCell(cell43);

		PdfPCell cell44 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table14.addCell(cell44);

		PdfPCell cell45 = new PdfPCell(
				new Paragraph("Year wise full time teachers and sanctioned posts for 5 years(Data Template)\r\n\r\n",font5));
		cell45.setHorizontalAlignment(Element.ALIGN_CENTER);
		table14.addCell(cell45);

		PdfPCell cell46 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell46.setExtraParagraphSpace(5f);
		
		table14.addCell(cell46);

		PdfPCell cell47 = new PdfPCell(new Paragraph("List of the faculty members authenticated by the Head of HEI\r\n\r\n",font5));
		cell47.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell47.setExtraParagraphSpace(5f);
		
		table14.addCell(cell47);

		PdfPCell cell48 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell48.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell48.setExtraParagraphSpace(5f);
		table14.addCell(cell48);

		PdfPCell cell49 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n",font5));
		cell49.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table14.addCell(cell49);

		PdfPCell cell50 = new PdfPCell(new Paragraph("",font5));
		cell50.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table14.setSpacingAfter(20f);
		table14.setSpacingBefore(20f);
		table14.addCell(cell50);

	//	document.add(table14);
		
		
		if(criteria2Record.getYearTable2411().size() >0)
		{
		Table table2411 = new Table(criteria2Record.getYearTable2411().size(), 2);

		table2411.setPadding(5f);
		table2411.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
			Cell cell21=new Cell(new Paragraph(criteria2Record.getYearTable2411().get(i).getInput2411y(),font5));
			cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2411.addCell(cell21);
		
		}
		for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
			Cell cell22=new Cell(new Paragraph(criteria2Record.getYearTable2411().get(i).getInput2411v(),font5));
			cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2411.addCell(cell22);
		
		
		}

	//	document.add(table2411);
	}
		if(criteria2Record.getYearTable24112().size()>0)
		{
		
		Table table24112 = new Table(criteria2Record.getYearTable24112().size(), 2);

		table24112.setPadding(5f);
		table24112.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable24112().size(); i++) {
			Cell cell23=new Cell(new Paragraph(criteria2Record.getYearTable24112().get(i).getInput24112y(),font5));
			cell23.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24112.addCell(cell23);
		
		}
		for (int i = 0; i < criteria2Record.getYearTable24112().size(); i++) {
			Cell cell24=new Cell(new Paragraph(criteria2Record.getYearTable24112().get(i).getInput24112v(),font5));
			cell24.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24112.addCell(cell24);
		
		}
	//	table24112.setSpacingAfter(2f);
	//	document.add(table24112);
		
		
		}


		PdfPTable table08 = new PdfPTable(1);
		table08.setWidthPercentage(100f);

		PdfPCell cell005 = new PdfPCell(new Paragraph(
				"2.4.2 Percentage of full time teachers with Ph.D./D.M/M.Ch./D.N.B/\r\n"
				+ "Superspeciality/L.L.D/D.S.C/D.Litt. during the last five years"
						+ "\r\n" 
						,
				font4));
		
		table08.setSpacingBefore(5f);
		
		cell005.setExtraParagraphSpace(5f);
		
		table08.setSpacingBefore(5f);

		table08.addCell(cell005);

		PdfPCell cell15010criteria2 = new PdfPCell(new Paragraph(
				" 2.4.2.1 Number of full time teachers with Ph.D./D.M/M.Ch./D.N.B Superspeciality/D.Sc./D�Lit. year wise during the last five years\r\n"
						+ (criteria2Record != null
						? criteria2Record.getCriteria24Qn().get(0).getResponse242()
						: ""),font4));
		
		cell15010criteria2.setExtraParagraphSpace(5f);
		table08.addCell(cell15010criteria2);
		
		
		
		
		document.add(table08);
		
		Table table2421 = new Table(criteria2Record.getYearTable2421().size(), 2);

		table2421.setPadding(5f);
		table2421.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
			Cell cell25=new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421y(),font5));
			cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2421.addCell(cell25);
		
		}
		for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
			Cell cell26=new Cell(new Paragraph(criteria2Record.getYearTable2421().get(i).getInput2421v(),font5));
			cell26.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2421.addCell(cell26);
		
			
			
			
		}

		document.add(table2421);
		
		
		Table table24212 = new Table(criteria2Record.getYearTable24212().size(), 2);

		table24212.setPadding(5f);
		table24212.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable24212().size(); i++) {
			Cell cell27=new Cell(new Paragraph(criteria2Record.getYearTable24212().get(i).getInput24212y(),font5));
			cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2421.addCell(cell27);
		
		
		}
		for (int i = 0; i < criteria2Record.getYearTable24212().size(); i++) {
			Cell cell28=new Cell(new Paragraph(criteria2Record.getYearTable24212().get(i).getInput24212v()));
			cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2421.addCell(cell28);
			
			
		
		}

	//	document.add(table24212);


		PdfPTable table17 = new PdfPTable(2);

		table17.setWidthPercentage(100f);
		table17.setWidths(new int[] { 3, 3 });
		table17.setSpacingBefore(20f);
		table17.setSpacingAfter(20f);

		PdfPCell cell51 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
		table17.addCell(cell51);

		PdfPCell cell52 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell52.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table17.addCell(cell52);

		PdfPCell cell53 = new PdfPCell(new Paragraph("List of number of full time teachers with Ph D/D\r\n"
				+ "M/M Ch/D N B Superspeciality/DSc/D Lit and\r\n"
				+ "number of full time teachers for 5 years\r\n\r\n",font5));
		cell53.setExtraParagraphSpace(5f);
		
		cell53.setHorizontalAlignment(Element.ALIGN_CENTER);
		table17.addCell(cell53);

		PdfPCell cell54 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell54.setExtraParagraphSpace(5f);
		
		cell54.setHorizontalAlignment(Element.ALIGN_CENTER);
		table17.addCell(cell54);

		PdfPCell cell55 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n",font5));
		cell55.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table17.addCell(cell55);

		PdfPCell cell56 = new PdfPCell(new Paragraph("",font5));
		cell56.setHorizontalAlignment(Element.ALIGN_CENTER);
		table17.addCell(cell56);
		
		table17.setSpacingAfter(20f);
		table17.setSpacingBefore(20f);

//		document.add(table17);

		PdfPTable table20 = new PdfPTable(1);
		table20.setWidthPercentage(100f);

		PdfPCell cell009 = new PdfPCell(new Paragraph(
				"2.4.3 Average teaching experience of full time teachers in the same institution (Data for the latest completed academic year in number of years)"

						,
				font4));
		
		cell009.setExtraParagraphSpace(5f);

		table20.addCell(cell009);
		
		document.add(table20);
		if( criteria2Record.getCriteria24Qn() !=null)
		{

		PdfPCell cell0090 = new PdfPCell(new Paragraph(" 2.4.3.1: Total teaching experience of full-time teachers (for the latest\r\n"
				+ "completed academic year\r\n"  + "Response:"
				+ (criteria2Record != null ? criteria2Record.getCriteria24Qn().get(0).getInput2431t1() : ""),font4));
		cell0090.setExtraParagraphSpace(5f);
		table20.addCell(cell0090);
		
		document.add(table20);
		}
		
		

		PdfPTable table21 = new PdfPTable(2);

		table21.setWidthPercentage(100f);
		table21.setWidths(new int[] { 3, 3 });
		table21.setSpacingBefore(20f);
		table21.setSpacingAfter(20f);

		PdfPCell cell61 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table21.addCell(cell61);

		PdfPCell cell62 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell62);

		PdfPCell cell63 = new PdfPCell(new Paragraph("List of Teachers including their PAN, designation,\r\n"
				+ "dept and experience details\r\n"
				+ "\r\n\r\n",font5));
		
		cell63.setExtraParagraphSpace(5f);
		cell63.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table21.addCell(cell63);

		PdfPCell cell64 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell64.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell64.setExtraParagraphSpace(5f);
		
		table21.addCell(cell64);
		

		table21.setSpacingAfter(20f);
		table21.setSpacingBefore(20f);
		document.add(table21);
		
		PdfPTable table201 = new PdfPTable(1);
		table201.setWidthPercentage(100f);

		PdfPCell cell0091 = new PdfPCell(new Paragraph(
				" 2.4.4 Average percentage of full time teachers who received awards, recognition, fellowships at State,\r\n"
				+ "National, International level from Government/Govt. recognised bodies during the last five years\r\n"
				+ "Response: "
						+ (criteria2Record != null
								? criteria2Record.getCriteria24Qn().get(0).getResponse244()
								: ""),
				font4));
		
		cell0091.setExtraParagraphSpace(5f);
	//	table201.addCell(cell0091);
		
		
//		
//			Paragraph paragraph6criteria222 = new Paragraph(" 2.4.4 Average percentage of full time teachers who received awards, recognition, fellowships at State,\r\n"
//				+ "National, International level from Government/Govt. recognised bodies during the last five years\r\n"
//				+ "Response:" );
//			document.add(paragraph6criteria222);

			if( criteria2Record.getCriteria24Qn() !=null)
			{

				PdfPCell cell000091 = new PdfPCell( new Paragraph(criteria2Record != null ? criteria2Record.getCriteria24Qn().get(0).getResponse241() : "",font4));
				//table201.addCell(cell000091);

		
		}
			
			document.add(table201);
		
		if(criteria2Record.getUniversityYearTable2441() .size()>0)
		{
		Table table2441 = new Table(criteria2Record.getUniversityYearTable2441().size(), 2);

		table2441.setPadding(5f);
		table2441.setWidth(100f);

		for (int i = 0; i < criteria2Record.getUniversityYearTable2441().size(); i++) {
			Cell cell26667=new Cell(new Paragraph(criteria2Record.getUniversityYearTable2441().get(i).getInput2441y(),font5));
			cell26667.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2441.addCell(cell26667);
		
		}
		for (int i = 0; i < criteria2Record.getUniversityYearTable2441().size(); i++) {
			table2441.addCell(criteria2Record.getUniversityYearTable2441().get(i).getInput2441v());
		}

//		document.add(table2441);

		}
		
		
		
		// 2.5 
		
		Paragraph paragraph7criteria2 = new Paragraph("2.5	Evaluation Process and Reforms\r\n", font2);
		paragraph7criteria2.setSpacingAfter(4f);
		paragraph7criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph7criteria2);

		PdfPTable table22 = new PdfPTable(1);
		table22.setWidthPercentage(100f);

		PdfPCell cell010 = new PdfPCell(new Paragraph(
				"2.5.1  Average number of days from the date of last semester-end/ year- end\r\n"
				+ "examination till the last date of declaration of results year-wise during\r\n"
				+ "the last five years"
					,font4));

		
		cell010.setExtraParagraphSpace(5f);
		table22.addCell(cell010);
		
		PdfPCell cell01111110 = new PdfPCell(new Paragraph(
				"2.5.1.1 Number of days from the date of last semester-end/ year- end examination till the declaration of results year wise during the last five years\r\n"
						+ "\r\n" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria25Qn().get(0).getInput251t1(): "")+ " ",font4));
		cell01111110.setExtraParagraphSpace(5f);
		table22.addCell(cell01111110);
		
		document.add(table22);
		
//		Table table2511 = new Table(criteria2Record.getYearTable2511().size(), 2);
//
//		table2511.setPadding(5f);
//		table2511.setWidth(100f);
//
//		for (int i = 0; i < criteria2Record.getYearTable2511().size(); i++) {
//			table2511.addCell(criteria2Record.getYearTable2511().get(i).getInput2511y());
//		}
//		for (int i = 0; i < criteria2Record.getYearTable2511().size(); i++) {
//			table2511.addCell(criteria2Record.getYearTable2511().get(i).getInput2511v());
//		}
//
//		document.add(table2511);
		
		
		//////
		
		
		if(criteria2Record.getYearTable2511() .size()>0)
		{
		Table table2511 = new Table(criteria2Record.getYearTable2511().size(), 2);

		table2511.setPadding(5f);
		table2511.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2511().size(); i++) {
			Cell cell26667=new Cell(new Paragraph(criteria2Record.getYearTable2511().get(i).getInput2511y(),font5));
			cell26667.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2511.addCell(cell26667);
		
		}
		for (int i = 0; i < criteria2Record.getYearTable2511().size(); i++) {
			table2511.addCell(criteria2Record.getYearTable2511().get(i).getInput2511v());
		}

		document.add(table2511);

		}
		
		
		////
		

		

		PdfPTable table24 = new PdfPTable(2);

		table24.setWidthPercentage(100f);
		table24.setWidths(new int[] { 3, 3 });
		table24.setSpacingBefore(5);

		PdfPCell cell69criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell69criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		table24.addCell(cell69criteria2);

		PdfPCell cell70criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell69criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		
		table24.addCell(cell70criteria2);

		PdfPCell cell71criteria2 = new PdfPCell(
				new Paragraph("List of Programmes and date of last semester and\r\n"
						+ "date of declaration of results\r\n\r\n"));
		cell71criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		table24.addCell(cell71criteria2);
		
		
if(criteria2file.size()>0) {
		PdfPCell cell72criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
		cell72criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		cell72criteria2.setExtraParagraphSpace(5f);
		table24.addCell(cell72criteria2);
}
		PdfPCell cell73criteria2 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n"));
		cell73criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		table24.addCell(cell73criteria2);

		PdfPCell cell74criteria2 = new PdfPCell(new Paragraph("", font4));
		cell74criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);	
		
		
		table24.addCell(cell74criteria2);

		table24.setSpacingAfter(20f);
		table24.setSpacingBefore(20f);
		
		document.add(table24);

		PdfPTable table09 = new PdfPTable(1);
		table09.setWidthPercentage(100f);
		if(criteria2Record.getCriteria25Qn() !=null)
		{
		PdfPCell cell006 = new PdfPCell(new Paragraph(
				"2.5.2 Percentage of student complaints/grievances about evaluation against\r\n"
				+ "total number of students appeared in the examinations during the last\r\n"
				+ "five years"
						+ "\r\n" + ""
				+ "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria25Qn().get(0).getResponse252()
								: "")
,font4));
		cell006.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);	
		
		
		cell006.setExtraParagraphSpace(5f);

		table09.addCell(cell006);
		
		}

		PdfPCell cell005556 = new PdfPCell(new Paragraph(
				"2.5.2.1 Number of complaints/grievances about evaluation year wise during the last five years\r\n"
						+ "\r\n" + " ",font4));
		
		table09.addCell(cell005556);
		
		
		PdfPCell cell005511156 = new PdfPCell(new Paragraph(
				"2.5.2.2 Total number of students appeared in the examinations year-wise \r\n"
				+ "during the last five years\r\n"
						+ "\r\n" + " ",font4));
		
		table09.addCell(cell005511156);
		
		
		document.add(table09);
		
		
		if(criteria2Record.getYearTable2521().size() >0) {
		Table table2521 = new Table(criteria2Record.getYearTable2521().size(), 2);

		table2521.setPadding(5f);
		table2521.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable2521().size(); i++) {
			Cell cell2=new Cell(new Paragraph(criteria2Record.getYearTable2521().get(i).getInput2521y(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2521.addCell(cell2);
			
		}
		for (int i = 0; i < criteria2Record.getYearTable2521().size(); i++) {
			Cell cell11112=new Cell(new Paragraph(criteria2Record.getYearTable2521().get(i).getInput2521v(),font5));
			cell11112.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2521.addCell(cell11112);
			
		}
		for (int i = 0; i < criteria2Record.getYearTable25212().size(); i++) {
			Cell cell2=new Cell(new Paragraph(criteria2Record.getYearTable2521().get(i).getInput2521n(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2521.addCell(cell2);
			
		}
		
		

		document.add(table2521);
		
		}
		
		
		
		if(criteria2Record.getYearTable2521().size() >0) {
			
		
		Table table25212 = new Table(criteria2Record.getYearTable25212().size(), 2);

		table25212.setPadding(5f);
		table25212.setWidth(100f);

		for (int i = 0; i < criteria2Record.getYearTable25212().size(); i++) {
			Cell cell2=new Cell(new Paragraph(criteria2Record.getYearTable25212().get(i).getInput25212y(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table25212.addCell(cell2);
			
		}
		for (int i = 0; i < criteria2Record.getYearTable25212().size(); i++) {
			Cell cell21111=new Cell(new Paragraph(criteria2Record.getYearTable25212().get(i).getInput25212v(),font5));
			cell21111.setHorizontalAlignment(Element.ALIGN_CENTER);
			table25212.addCell(cell21111);
			
		}

	//	document.add(table25212);

	}

		PdfPTable table18 = new PdfPTable(2);

		table18.setWidthPercentage(100f);
		table18.setWidths(new int[] { 3, 3 });
		table18.setSpacingBefore(5);

		PdfPCell cell57 = new PdfPCell(new Paragraph("File Description", font4));
		cell57.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table18.addCell(cell57);

		PdfPCell cell58 = new PdfPCell(new Paragraph("Document", font4));
		cell58.setHorizontalAlignment(Element.ALIGN_CENTER);
		table18.addCell(cell58);

		PdfPCell cell59 = new PdfPCell(
				new Paragraph("Number of complaints and total number of students appeared year wise",font5));
		cell59.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table18.addCell(cell59);

		PdfPCell cell60 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell60.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell60.setExtraParagraphSpace(5f);
		table18.addCell(cell60);
		
		PdfPCell cell75criteria2 = new PdfPCell(new Paragraph("Any Additional Information\r\n\r\n",font5));
		cell75criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table18.addCell(cell75criteria2);

		PdfPCell cell76criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
		cell76criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell76criteria2.setExtraParagraphSpace(5f);
		table18.addCell(cell76criteria2);

		table18.setSpacingAfter(20f);
		table18.setSpacingBefore(20f);

		document.add(table18);

		PdfPTable table25 = new PdfPTable(1);
		table25.setWidthPercentage(100f);

		PdfPCell cell011 = new PdfPCell(new Paragraph(
				"2.5.3 IT integration and reforms in the examination procedures and processes including Continuous Internal Assessment (CIA) have brought in considerable improvement in Examination Management System (EMS) of the Institution"
						+ "\r\n" + "" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria25Ql().get(0).getResponse253()
								: ""), font4));
		cell011.setExtraParagraphSpace(5f);
	//	table25.addCell(cell011);



		document.add(table25);

		PdfPTable table26 = new PdfPTable(2);

		table26.setWidthPercentage(100f);
		table26.setWidths(new int[] { 3, 3 });
		table26.setSpacingBefore(5);

		PdfPCell cell751criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell751criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table26.addCell(cell751criteria2);

		PdfPCell cell761criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell761criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table26.addCell(cell761criteria2);

		PdfPCell cell77criteria2 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"));
		cell77criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table26.addCell(cell77criteria2);

		PdfPCell cell78criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
		cell78criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell78criteria2.setExtraParagraphSpace(5f);
		table26.addCell(cell78criteria2);
		
		PdfPCell cell79criteria2 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n"));
		cell79criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table26.addCell(cell79criteria2);

		PdfPCell cell7008criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
		cell7008criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7008criteria2.setExtraParagraphSpace(5f);
		
		table26.addCell(cell7008criteria2);

		
		table26.setSpacingAfter(20f);
		table26.setSpacingBefore(20f);
	//	document.add(table26);
		

		
		PdfPTable table2611 = new PdfPTable(1);
		table2611.setWidthPercentage(100f);
		PdfPCell cell708criteria2 = new PdfPCell(
				new Paragraph("2.5.3: Status of automation of Examination division along with approved Examination Manual\r\n"
						+ "A. 100% automation of entire division & implementation of Examination Management System (EMS)\r\n"
						+ "B. Only student registration, Hall ticket issue & Result Processing\r\n"
						+ "C. Only student registration and result processing\r\n"
						+ "D. Only result processing\r\n"
		
						+ "E. Only manual methodology\r\n"
						+ (criteria2Record != null
						? criteria2Record.getCriteria25Ql().get(0).getInput254t1()
						: ""), font4));
		cell708criteria2.setExtraParagraphSpace(5f);
		table2611.addCell(cell708criteria2);

		document.add(table2611);
		

		PdfPTable table261 = new PdfPTable(2);
		table261.setWidthPercentage(100f);
		
		PdfPCell cell7511criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell7511criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7511criteria2.setExtraParagraphSpace(5f);
		
		table261.addCell(cell7511criteria2);

		PdfPCell cell7611criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell7611criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7611criteria2.setExtraParagraphSpace(5f);
		table261.addCell(cell7611criteria2);

		PdfPCell cell771criteria2 = new PdfPCell(new Paragraph("Upload any additional information\r\n",font5));
		cell771criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell771criteria2.setExtraParagraphSpace(5f);
		table261.addCell(cell771criteria2);

		PdfPCell cell781criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell781criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell781criteria2.setExtraParagraphSpace(5f);
		table261.addCell(cell781criteria2);
		
		PdfPCell cell7711criteria2 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n",font5));
		cell7711criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7711criteria2.setExtraParagraphSpace(5f);
		table261.addCell(cell7711criteria2);

		PdfPCell cell7811criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell7811criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7811criteria2.setExtraParagraphSpace(5f);
		table261.addCell(cell7811criteria2);

		
		PdfPCell cell7721criteria2 = new PdfPCell(new Paragraph("Institutional data in prescribed format	\r\n",font5));
		cell7721criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7721criteria2.setExtraParagraphSpace(5f);
		table261.addCell(cell7721criteria2);

		PdfPCell cell7821criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell7821criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7821criteria2.setExtraParagraphSpace(5f);
		table261.addCell(cell7821criteria2);

		PdfPCell cell7731criteria2 = new PdfPCell(new Paragraph("Institutional data in prescribed format and\r\n",font5));
		
		cell7731criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7731criteria2.setExtraParagraphSpace(5f);
		table26.addCell(cell7731criteria2);

		PdfPCell cell7841criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell7841criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell7841criteria2.setExtraParagraphSpace(5f);
		
		table261.addCell(cell7841criteria2);
		table261.setSpacingAfter(20f);
		table261.setSpacingBefore(20f);
		document.add(table261);
		
		
		// 2.6 
		Paragraph paragraph8criteria2 = new Paragraph("2.6 Student Performance and Learning Outcomes", font2);
		paragraph8criteria2.setSpacingAfter(4f);
		paragraph8criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph8criteria2);

		PdfPTable table27 = new PdfPTable(1);
		table27.setWidthPercentage(100f);

		PdfPCell cell012 = new PdfPCell(new Paragraph(
				"2.6.1 he institution has stated learning outcomes (Program and Course \r\n"
				+ "outcomes)/graduate attributes which are integrated into the assessment \r\n"
				+ "process and widely publicized through the website and other documents\r\n"
				+ "and the attainment of the same are evaluated by the institution\r\n"
				+ ""
						+ "\r\n" + "" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria26Ql().get(0).getResponse261()
								: ""),font4));
		cell012.setExtraParagraphSpace(5f);

		table27.addCell(cell012);

	
		document.add(table27);

		PdfPTable table28 = new PdfPTable(2);

		table28.setWidthPercentage(100f);
		table28.setWidths(new int[] { 3, 3 });
		table28.setSpacingBefore(5);

		PdfPCell cell709criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell709criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell709criteria2);

		PdfPCell cell80criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell80criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table28.addCell(cell80criteria2);

		PdfPCell cell81criteria2 = new PdfPCell(new Paragraph("Upload COs for all courses (exemplars from Glossary)",font5));
		cell81criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table28.addCell(cell81criteria2);

		PdfPCell cell82criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell82criteria2.setExtraParagraphSpace(5f);
		cell82criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table28.addCell(cell82criteria2);
		
		PdfPCell cell83criteria2 = new PdfPCell(new Paragraph("Upload Any Additional Information",font5));
		
		cell83criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell83criteria2);

		PdfPCell cell84criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell84criteria2.setExtraParagraphSpace(5f);
	//	cell84criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell84criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table28.addCell(cell84criteria2);

		PdfPCell cell831criteria2 = new PdfPCell(new Paragraph("Paste for Additional Information",font5));
		cell831criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell831criteria2);

		PdfPCell cell841criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell841criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell841criteria2.setExtraParagraphSpace(5f);
		table28.addCell(cell841criteria2);

		table28.setSpacingAfter(20f);
		table28.setSpacingBefore(20f);
		document.add(table28);

		PdfPTable table29 = new PdfPTable(1);
		table29.setWidthPercentage(100f);

		PdfPCell cell013 = new PdfPCell(new Paragraph(
				"2.6.2 Pass percentage of students (excluding backlog students) (Data to be \r\n"
				+ "provided only for the latest completed academic year) ." + "\r\n"
						+ "" + "" + "Response:"
						+ (criteria2Record != null
								? criteria2Record.getCriteria26Ql().get(0).getResponse262()
								: ""),font4));
		cell013.setExtraParagraphSpace(5f);
		table29.addCell(cell013);
		
		
		PdfPCell cell01322 = new PdfPCell(new Paragraph(
				"2.6.2.1  Total number of final year students who passed the examination \r\n"
				+ "conducted by Institution ." + "\r\n"
						
						+ (criteria2Record != null
								? criteria2Record.getCriteria26Ql().get(0).getInput262t1()
								: ""),font4));
		cell01322.setExtraParagraphSpace(5f);
		table29.addCell(cell01322);
		
		
		
		document.add(table29);

		PdfPTable table30 = new PdfPTable(2);

		table30.setWidthPercentage(100f);
		table30.setWidths(new int[] { 3, 3 });
		table30.setSpacingBefore(5);

		PdfPCell cell85criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell85criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table30.addCell(cell85criteria2);

		PdfPCell cell86criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell86criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table30.addCell(cell86criteria2);

		PdfPCell cell87criteria2 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell87criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table30.addCell(cell87criteria2);

		PdfPCell cell88criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell88criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell88criteria2.setExtraParagraphSpace(5f);
		
		table30.addCell(cell88criteria2);
		
		PdfPCell cell871criteria2 = new PdfPCell(new Paragraph("Paste link Additional information\r\n\r\n",font5));
		cell871criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table30.addCell(cell871criteria2);

		PdfPCell cell881criteria2 = new PdfPCell(
				new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell881criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell881criteria2.setExtraParagraphSpace(5f);
		
		table30.addCell(cell881criteria2);


		table30.setSpacingAfter(20f);
		table30.setSpacingBefore(20f);
		document.add(table30);

		PdfPTable table31criteria2 = new PdfPTable(1);
		table31criteria2.setWidthPercentage(100f);
		
		PdfPCell cell881criteria111111112 = new PdfPCell(
				new Paragraph("2.6.3 Pass Percentage of students(Data for the latest completed academic year)\r\n"
						+ "\r\n" + "Response:"
						+ (criteria2Record != null ? criteria2Record.getCriteria26Qn().get(0).getResponse263(): ""),font5));
		cell881criteria111111112.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell881criteria111111112.setExtraParagraphSpace(5f);
		
	//	table31criteria2.addCell(cell881criteria111111112);
		
		

//	table31criteria2.setExtraParagraphSpace(5f);
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

		PdfPCell cell93criteria2 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
		cell93criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table32.addCell(cell93criteria2);

		PdfPCell cell94criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "",font5));
		cell94criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell94criteria2);

		
		PdfPCell cell931criteria2 = new PdfPCell(new Paragraph("Link for the annual report\r\n\r\n",font5));
		cell931criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table32.addCell(cell931criteria2);

		PdfPCell cell941criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : ""));
		cell941criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell941criteria2.setExtraParagraphSpace(5f);
		
		
		table32.addCell(cell941criteria2);
		
		PdfPCell cell932criteria2 = new PdfPCell(new Paragraph("Link fo any additional information\r\n\r\n"));
		cell932criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell932criteria2.setExtraParagraphSpace(5f);
		
		table32.addCell(cell932criteria2);

		PdfPCell cell943criteria2 = new PdfPCell(new Paragraph(""));
		cell943criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table32.addCell(cell943criteria2);

		table32.setSpacingAfter(20f);
		table32.setSpacingBefore(20f);

	//	document.add(table32);
		
		
		
		// 2.7 
		
		Paragraph paragraph9criteria2 = new Paragraph("2.7	Student Satisfaction Survey\r\n\r\n", font2);
		
		
		paragraph9criteria2.setSpacingAfter(4f);
		paragraph9criteria2.setAlignment(Paragraph.ALIGN_LEFT);

		document.add(paragraph9criteria2);
		PdfPTable table33 = new PdfPTable(1);
		table33.setWidthPercentage(100f);
		PdfPCell cell905criteria2 = new PdfPCell(new Paragraph("2.7.1 Online student satisfaction survey regarding teaching learning process\r\n" + "\r\n",font4));
//				+ "Response:"
//				+ ( criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse271() != null ? criteria2Record.getCriteria2FieldInfoQn().get(0).getResponse271()
//						: "")));

		table33.addCell(cell905criteria2);
		document.add(table33);
		PdfPTable table34 = new PdfPTable(2);

		table34.setWidthPercentage(100f);
		table34.setWidths(new int[] { 3, 3 });
		table34.setSpacingBefore(5);

		PdfPCell cell95criteria2 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		
		cell95criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell95criteria2);

		PdfPCell cell96criteria2 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell96criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table34.addCell(cell96criteria2);

		PdfPCell cell97criteria2 = new PdfPCell(new Paragraph("Upload any additional information	", font5));
		cell97criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table34.addCell(cell97criteria2);

		PdfPCell cell98criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "", font5));
		
		cell98criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell98criteria2.setExtraParagraphSpace(5f);
		table34.addCell(cell98criteria2);

		
		PdfPCell cell908criteria2 = new PdfPCell(new Paragraph("Upload database of all currently enrolled students(Data Template)	", font5));
		cell908criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table34.addCell(cell908criteria2);

		PdfPCell cell980criteria2 = new PdfPCell(new Paragraph(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "", font5));
		cell980criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell980criteria2.setExtraParagraphSpace(5f);
		
		
		table34.addCell(cell980criteria2);

		
		table34.setSpacingAfter(20f);
		table34.setSpacingBefore(20f);
		document.add(table34);
		

		}

	public void Criteria3(Document document, Criteria3_FieldInfo criteria3Fieldinfo) {		
		Paragraph paragraph1criteria3 = new Paragraph("Criterion 3 - Research, Innovations and Extension\r\n",
				font2);
		paragraph1criteria3.setSpacingBefore(3f);
		paragraph1criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph1criteria3);
		
		Paragraph paragraph0001 = new Paragraph("__________________________________________________________________________");

		paragraph0001.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph0001);
		
		Paragraph paragraph2criteria3 = new Paragraph("3.1	Promotion of Research and Facilities"
				+ "\r\n"	+ "\r\n", font2);
		paragraph2criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		paragraph2criteria3.setSpacingBefore(2F);
		document.add(paragraph2criteria3);
		

		
		// create table1
		PdfPTable table1criteria3 = new PdfPTable(2);
		PdfPTable table13criteria31 = new PdfPTable(1);

		table1criteria3.setWidthPercentage(100f);
		table13criteria31.setWidthPercentage(100f);
		
		table1criteria3.setSpacingAfter(20f);
		table1criteria3.setSpacingBefore(20f);

		PdfPCell cell1criteria3 = new PdfPCell(new Paragraph("File Description\r\n", font4));
		cell1criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell2criteria3 = new PdfPCell(new Paragraph("Document\r\n", font4));
		cell2criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell3criteria3 = new PdfPCell(new Paragraph(
				"Minutes of the Governing Council/ Syndicate/Board of Management related to research promotion policy adoption\r\n",font5));
		cell3criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell3criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell4criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
		cell4criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell4criteria3.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell5criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n",font5));
		cell5criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell6criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
		cell6criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell6criteria3.setExtraParagraphSpace(10f);
		PdfPCell cell7criteria3 = new PdfPCell(
				new Paragraph("URL of Policy document on promotion of research uploaded on website\r\n",font5));
		cell7criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell8criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell8criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell8criteria3.setExtraParagraphSpace(5f);
		
		table1criteria3.addCell(cell1criteria3);
		table1criteria3.addCell(cell2criteria3);
		table1criteria3.addCell(cell5criteria3);
		table1criteria3.addCell(cell6criteria3);
		table1criteria3.addCell(cell3criteria3);
		table1criteria3.addCell(cell4criteria3);
		
		table1criteria3.addCell(cell7criteria3);
		table1criteria3.addCell(cell8criteria3);

		PdfPCell cell311criteria3 = new PdfPCell(new Paragraph(
				"3.1.1	The institution's Research facilities are frequently updated and there is a well defined policy for promotion of research which is uploaded on the institutional website and implemented.\r\n"
						+ "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria31Ql().get(0).getResponse311()
								: ""),
				font4));
		
		cell311criteria3.setExtraParagraphSpace(5f);
		
		cell311criteria3.setExtraParagraphSpace(5f);
		table13criteria31.addCell(cell311criteria3);
		document.add(table13criteria31);
		
	//	table13criteria31.addCell(table1criteria3);


		document.add(table1criteria3);
		

		
		
		

		// create table 2////
		PdfPTable table1criteria003 = new PdfPTable(1);
		table1criteria003.setWidthPercentage(100f);
		
		
		PdfPCell cell311criteria03 = new PdfPCell(new Paragraph(
				"3.1.2 The institution provides seed money to its teachers for research (average per year, INR in Lakhs)\r\n"
						 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria31Qn().get(0).getResponse312()
								: ""),font4));
		
		cell311criteria03.setExtraParagraphSpace(5f);
		
		table1criteria003.addCell(cell311criteria03);
	
		PdfPCell cell311criteria003 = new PdfPCell(new Paragraph(
				"3.1.2.1 The amount of seed money provided by institution to its faculty year-wise during the last five years (INR in lakhs)",font4));

		cell311criteria003.setExtraParagraphSpace(10F);
		table1criteria003.addCell(cell311criteria003);
	
		document.add(table1criteria003);
		

		if (criteria3Record.getYearTable3121().size() >0) {
			Table table3121criteria3 = new Table(criteria3Record.getYearTable3121().size());

			table3121criteria3.setPadding(5);
			table3121criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3121().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3121().get(i).getInput3121y(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3121criteria3.addCell(cell2);
				

			}
			for (int i = 0; i < criteria3Record.getYearTable3121().size(); i++) {
				Cell cell21=new Cell(new Paragraph(criteria3Record.getYearTable3121().get(i).getInput3121v(),font5));
				cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3121criteria3.addCell(cell21);
				

			}

			document.add(table3121criteria3);
		}
	
		
		PdfPTable table2criteria3 = new PdfPTable(2);

		table2criteria3.setWidthPercentage(100f);

		PdfPCell cell21criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell21criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell22criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell22criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell23criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n",font5));
		cell23criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell24criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "",font5));
		cell24criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell24criteria3.setExtraParagraphSpace(10F);
//		
//		PdfPCell cell25criteria3 = new PdfPCell(
//				new Paragraph("Any additional information",font5));
//		cell25criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		PdfPCell cell26criteria3 = new PdfPCell(
//				new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "",font5));
//		cell26criteria3.setExtraParagraphSpace(10F);
//		cell26criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell27criteria3 = new PdfPCell(new Paragraph(
				"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n",font5));
		cell27criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell27criteria3.setExtraParagraphSpace(5f);
		PdfPCell cell28criteria3 = new PdfPCell(
				
				new Paragraph(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "",font5));
		
		cell28criteria3.setExtraParagraphSpace(5f);
		cell28criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell271criteria3 = new PdfPCell(new Paragraph(
				"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n",font5));
		cell271criteria3.setExtraParagraphSpace(5f);
		cell271criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell281criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "",font5));
		cell281criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell281criteria3.setExtraParagraphSpace(5f);
		
		
		table2criteria3.addCell(cell21criteria3);
		table2criteria3.addCell(cell22criteria3);
		table2criteria3.addCell(cell23criteria3);
		table2criteria3.addCell(cell24criteria3);
//		table2criteria3.addCell(cell25criteria3);
//		table2criteria3.addCell(cell26criteria3);
		table2criteria3.addCell(cell27criteria3);
		table2criteria3.addCell(cell28criteria3);
		table2criteria3.addCell(cell271criteria3);
		table2criteria3.addCell(cell281criteria3);
		
		
//		table23criteria31.setSpacingBefore(20f);
//		table23criteria31.setSpacingAfter(20f);
		
		
		table2criteria3.setSpacingBefore(20f);
		table2criteria3.setSpacingAfter(20f);

		document.add(table2criteria3);
		
		
		
		PdfPTable table23criteria31 = new PdfPTable(1);
		table23criteria31.setWidthPercentage(100f);
		

		PdfPCell cell271criteria003 = new PdfPCell(new Paragraph(
				"3.1.3 Percentage of teachers receiving national/ international \r\n"
				+ "fellowship/financial support by various agencies for advanced studies/ \r\n"
				+ "research during the last five years\r\n"
					 + "Response"
						+ (criteria3Record != null
						? criteria3Record.getCriteria31Qn().get(0).getResponse313()
						: ""),font4));
		cell271criteria003.setExtraParagraphSpace(5f);
		table23criteria31.addCell(cell271criteria003)	;
		

		
		PdfPCell cell271criteria0003 = new PdfPCell(new Paragraph(
				"3.1.3.1 Number of teachers who received national/ international \r\n"
				+ "fellowship/financial support from various agencies, for advanced studies / \r\n"
				+ "research; year-wise during the last five years "
						+ "\r\n\r\n",font4));
		
		cell271criteria0003.setExtraParagraphSpace(5f);
		
		table23criteria31.addCell(cell271criteria0003);
		
		
		document.add(table23criteria31);
		
		
		
        
		if (criteria3Record.getYearTable3131().size() > 0) {
			Table table3131criteria3 = new Table(criteria3Record.getYearTable3131().size(), 2);

			table3131criteria3.setPadding(5);
			table3131criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3131().size(); i++) {
				Cell cell21=new Cell(new Paragraph((criteria3Record.getYearTable3131().get(i).getInput3131y()),font5));
				cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3131criteria3.addCell(cell21);

			}
			for (int i = 0; i < criteria3Record.getYearTable3131().size(); i++) {
				Cell cell212=new Cell(new Paragraph(criteria3Record.getYearTable3131().get(i).getInput3131v(),font5));
				cell212.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3131criteria3.addCell(cell212);

			}

			document.add(table3131criteria3);
		}
		
		
		
		
		
		
		PdfPTable table23criteria031 = new PdfPTable(1);
		table23criteria031.setWidthPercentage(100f);
		
		
		PdfPCell cell271criteria00031 = new PdfPCell(new Paragraph("Total number of full time teachers during the last five years"
				+ criteria3Record != null
				? criteria3Record.getCriteria31Ql().get(0).getInput3131t1()
				: ""
		,font4));
		cell271criteria00031.setExtraParagraphSpace(5f);
		table23criteria031.addCell(cell271criteria00031);
		
	//	document.add(table23criteria031);
		
		
		
		PdfPTable table3criteria3 = new PdfPTable(2);
		PdfPTable table33criteria31 = new PdfPTable(1);

		table3criteria3.setWidthPercentage(100f);
		table33criteria31.setWidthPercentage(100f);

		PdfPCell cell31criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell31criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell32criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell32criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell33criteria3 = new PdfPCell(
				new Paragraph("Any additional information\r\n   ",font5));
		cell33criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell34criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "",font5));
		cell34criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell34criteria3.setExtraParagraphSpace(5f);
		
		
		PdfPCell cell35criteria3 = new PdfPCell(new Paragraph("e-copies of the award letters of the teachers",font5));
		cell35criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell36criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : "",font5));
		cell36criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell36criteria3.setExtraParagraphSpace(5f);
		
		PdfPCell cell33criteria32= new PdfPCell(
				new Paragraph("List of teachers and their international fellowship details (Data Template)\r\n   ",font5));
		cell33criteria32.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell34criteria32 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "",font5));
		cell34criteria32.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell34criteria32.setExtraParagraphSpace(5f);
		
		
		
		table3criteria3.addCell(cell31criteria3);
		table3criteria3.addCell(cell32criteria3);
		table3criteria3.addCell(cell33criteria3);
		table3criteria3.addCell(cell34criteria3);
		table3criteria3.addCell(cell35criteria3);
		table3criteria3.addCell(cell36criteria3);
		table3criteria3.addCell(cell33criteria32);
		table3criteria3.addCell(cell34criteria32);
		
    //   table33criteria31.addCell(table3criteria3);
		
       table3criteria3.setSpacingBefore(20f);
		table3criteria3.setSpacingAfter(20f);
	//	document.add(table3criteria3);
		
		
	
		
		
		PdfPTable table314criteria3 = new PdfPTable(2);
	
		table314criteria3.setWidthPercentage(100f);
	

		PdfPCell cell314criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n",  font4));
		cell314criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell324criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell324criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell334criteria3 = new PdfPCell(
				new Paragraph("Institutional data in prescribed format\r\n\r\n",font5));
		cell334criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell344criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : "",font5));

		cell344criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell344criteria3.setExtraParagraphSpace(5f);
		PdfPCell cell354criteria3 = new PdfPCell(new Paragraph("Any additional information",font5));
		cell354criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell364criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(9).getCriteria3FilePath() : "",font5));
		cell364criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell364criteria3.setExtraParagraphSpace(5f);
		
		table314criteria3.addCell(cell314criteria3);
		table314criteria3.addCell(cell324criteria3);
		table314criteria3.addCell(cell334criteria3);
		table314criteria3.addCell(cell344criteria3);
		table314criteria3.addCell(cell354criteria3);
		table314criteria3.addCell(cell364criteria3);
		
		table314criteria3.setSpacingBefore(20f);
		table314criteria3.setSpacingAfter(20f);
//		document.add(table314criteria3);
		
		
		
		PdfPTable table3314criteria31 = new PdfPTable(1);
		table3314criteria31.setWidthPercentage(100f);
	
		PdfPCell cell3134criteria3 = new PdfPCell(new Paragraph(
				"3.1.4 Percentage of JRFs, SRFs among the enrolled PhD scholars in the \r\n"
				+ "institution during the last five years.\r\n"
				+ "Response:"
						+ (criteria3Record != null
						? criteria3Record.getCriteria31Qn().get(0).getResponse314()
						: ""),
				font4));
		cell3134criteria3.setExtraParagraphSpace(5f);
		
		
		PdfPCell cell31314criteria3 = new PdfPCell(new Paragraph(
				"3.1.4.1 The Number of JRFs, SRFs, Post Doctoral Fellows, Research Associates and other research\r\n\r\n"
				+ "fellows enrolled in the institution year-wise during the last five years."
						+ "\r\n"
						+ (criteria3Record != null
						? criteria3Record.getCriteria31Qn().get(0).getInput314t1()
						: ""),
						font4));
		
		cell31314criteria3.setExtraParagraphSpace(5f);
		table3314criteria31.addCell(cell3134criteria3);
		
		
		table3314criteria31.addCell(cell31314criteria3);
		
		
		PdfPCell cell31314criteria31 = new PdfPCell(new Paragraph(
				"3.1.4.1 Number of PhD Scholars enrolled during last five years"
						+ "\r\n"
						+ (criteria3Record != null
						? criteria3Record.getCriteria31Qn().get(0).getInput314t2()
						: ""),
						font4));
		
		cell31314criteria31.setExtraParagraphSpace(5f);
		table3314criteria31.addCell(cell31314criteria31);
		
		
		
		
		
		
		//table3314criteria31.addCell(table314criteria3);
		// document.add(cell313criteria3);
		// document.add(cell3131criteria3);
		
		document.add(table3314criteria31);
		
		
		
		
		
		
		
		PdfPTable table101criteria31 = new PdfPTable(1);
		table101criteria31.setWidthPercentage(100f);
		
		PdfPCell cell341criteria3 = new PdfPCell(new Paragraph(
				" 3.4.1 The Institution ensures implementation of its stated Code of Ethics for research through the following: 1. Inclusion of research ethics in the research methodology course work 2. Presence ofEthics committee 3. Plagiarism check through software 4. Research Advisory Committee\r\n"
					 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Ql().get(0).getResponse341()
								: ""),
						font4));
		cell341criteria3.setExtraParagraphSpace(10f);
		
		table101criteria31.addCell(cell341criteria3);
	
	//    document.add(table101criteria31);
	    

		if (criteria3Record.getUniversityYearTable3141().size() >0 ) {
			Table table3141criteria3 = new Table(criteria3Record.getUniversityYearTable3141().size(), 2);

			table3141criteria3.setPadding(5);
			table3141criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getUniversityYearTable3141().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3141().get(i).getInput3141y(),font5));
				
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3141criteria3.addCell(cell2);

			}
			for (int i = 0; i < criteria3Record.getUniversityYearTable3141().size(); i++) {
				Cell cell112=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3141().get(i).getInput3141v(),font5));
				cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3141criteria3.addCell(cell112);
				

			}

	//		document.add(table3141criteria3);
		}
		
		
		
		PdfPTable table315criteria3 = new PdfPTable(2);
		PdfPTable table3151criteria31 = new PdfPTable(1);

		table315criteria3.setWidthPercentage(100f);
		table3151criteria31.setWidthPercentage(100f);

		PdfPCell cell315criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell315criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell325criteria3 = new PdfPCell(new Paragraph("Document\r\n\r", font4));
		cell325criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell335criteria3 = new PdfPCell(
				new Paragraph("Institutional data in prescribed format\r\n",font5));
		cell335criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell345criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(10).getCriteria3FilePath() : "",font5));
		cell345criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell345criteria3.setExtraParagraphSpace(5f);
		
		PdfPCell cell355criteria3 = new PdfPCell(new Paragraph("Any additional information",font5));
		cell355criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell365criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(11).getCriteria3FilePath() : "",font5));
		cell365criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell365criteria3.setExtraParagraphSpace(5f);
		
		table315criteria3.addCell(cell315criteria3);
		table315criteria3.addCell(cell325criteria3);
		table315criteria3.addCell(cell335criteria3);
		table315criteria3.addCell(cell345criteria3);
		table315criteria3.addCell(cell355criteria3);
		table315criteria3.addCell(cell365criteria3);
		
		table315criteria3.setSpacingBefore(20f);
		table315criteria3.setSpacingAfter(20f);
		
//		document.add(table315criteria3);
		
		
		PdfPCell cell31345criteria3 = new PdfPCell(new Paragraph(
				"3.1.5 Institution has the following facilities to support research\r\n"
				+ "1.Central Instrumentation Centre \r\n"
				+ "2.Animal House/Green House \r\n"
				+ "3. Museum\r\n"
				+ "4.Media laboratory/Studios\r\n"
				+ "5.Business Lab\r\n"
				+ "6.Research/Statistical Databases\r\n"
				+ "7.Mootcourt\r\n"
				+ "8.Theatre\r\n"
				+ "9.Art Gallery\r\n"
				+ "10.Any other facility to support research\r\n"
				+ "Response:"
						+ (criteria3Record != null
						? criteria3Record.getCriteria31Qn().get(0).getInput315t1()
						: ""),
						font4));
		
		cell31345criteria3.setExtraParagraphSpace(5f);
		
		table3151criteria31.addCell(cell31345criteria3);
		
	//	document.add(table3151criteria31);
		
	
	
	
	
		
		
		PdfPTable table316criteria3 = new PdfPTable(2);
		PdfPTable table3161criteria31 = new PdfPTable(1);

		table316criteria3.setWidthPercentage(100f);
		table3161criteria31.setWidthPercentage(100f);

		PdfPCell cell3156criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell3156criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell3256criteria3 = new PdfPCell(new Paragraph("Document\r\n\r", font4));
		cell3256criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell3356criteria3 = new PdfPCell(
				new Paragraph("Institutional data in prescribed format\r\n",font5));
		cell3356criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell3456criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(12).getCriteria3FilePath() : "",font5));
		cell3456criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell3456criteria3.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell3556criteria3 = new PdfPCell(new Paragraph("Any additional information",font5));
		cell3556criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell3656criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(13).getCriteria3FilePath() : "",font5));
		cell3656criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell3656criteria3.setExtraParagraphSpace(5f);
		
		table316criteria3.addCell(cell3156criteria3);
		table316criteria3.addCell(cell3256criteria3);
		table316criteria3.addCell(cell3356criteria3);
		table316criteria3.addCell(cell3456criteria3);
		table316criteria3.addCell(cell3556criteria3);
		table316criteria3.addCell(cell3656criteria3);
		
		
		table316criteria3.setSpacingAfter(20f);
		table316criteria3.setSpacingBefore(20f);
//		document.add(table316criteria3);
		
		
		PdfPCell cell313456criteria3 = new PdfPCell(new Paragraph(
				"3.1.6 Percentage of departments with UGC-SAP, CAS, DST-FIST, DBT, ICSSR and other\r\n"
				+ "recognitions by national and international agencies (Data for the latest completed academic year)\r\n"
				+ "Response: "
						+ (criteria3Record != null
						? criteria3Record.getCriteria31Qn().get(0).getResponse316()
						: ""),
				font4));
		cell313456criteria3.setExtraParagraphSpace(5f);
		
		PdfPCell cell3134566criteria3 = new PdfPCell(new Paragraph(
				"3.1.6.1 The Number of departments with UGC-SAP, CAS, DST-FIST , DBT, ICSSR and other\r\n"
				+ "similar recognitions by national and international agencies.\r\n"
				+ "Response: "
						+ (criteria3Record != null
						? criteria3Record.getCriteria36Ql().get(0).getInput361t1()
						: ""),
				font4));
		cell3134566criteria3.setExtraParagraphSpace(5f);
		
		PdfPCell cell3134566criteria31 = new PdfPCell(new Paragraph(
				"3.1.6.1: Total number of departments offering academic programmes"
				+ "Response: "
						+ (criteria3Record != null
						? criteria3Record.getCriteria36Ql().get(0).getInput361t2()
						: ""),
				font4));
		
		cell3134566criteria31.setExtraParagraphSpace(5f);
		
		table3161criteria31.addCell(cell313456criteria3);
		table3161criteria31.addCell(cell3134566criteria3);
		table3161criteria31.addCell(cell3134566criteria31);
	
	///	table3161criteria31.addCell(table316criteria3);
	
		table3161criteria31.setSpacingBefore(20f);
		table3161criteria31.setSpacingAfter(20f);
//		document.add(table3161criteria31);
		
		// 3.2 
		Paragraph paragraph3criteria3 = new Paragraph("3.2	Resource Mobilization for Research\r\n\r\n", font2);
		paragraph3criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph3criteria3);
		
		
		
		
		
		PdfPTable table003161criteria31 = new PdfPTable(1);
		table003161criteria31.setWidthPercentage(100f);
		
		

		/// create table 4//
		PdfPCell cell003134566criteria31 = new PdfPCell(new Paragraph("3.2.1:Research funding received by the institution and its faculties through \r\n"
				+ "Government and non-government sources such as industry, corporate \r\n"
				+ "houses, international bodies for research project, Endowment Research \r\n"
				+ "Chairs during the last five years (INR in Lakhs).\r\n",font4));
		
		cell003134566criteria31.setExtraParagraphSpace(5F);
		table003161criteria31.addCell(cell003134566criteria31);
		
		
		
		
		PdfPCell cell321criteria3 = new PdfPCell(new Paragraph(""
				+ "Response"
						+ (criteria3Record != null
								? criteria3Record.getCriteria32Ql().get(0).getResponse321()
								: ""),
						font4));
		cell321criteria3.setExtraParagraphSpace(5f);
		
		table003161criteria31.addCell(cell321criteria3);
		
		PdfPCell cell3211criteria3 = new PdfPCell(new Paragraph(
				"3.2.1.1 Total Grants from Government and non-governmental agencies for research projects , endowments, Chairs in the institution during the last five years (INR in Lakhs)"
						+ "\r\n"
						+ (criteria3Record != null
						? criteria3Record.getCriteria32Ql().get(0).getInput321t1()
						: ""),font4));
		table003161criteria31.addCell(cell3211criteria3);
		
		
		document.add(table003161criteria31);
		

		if (criteria3Record.getYearTable3221().size() >0 ) 
		{
			Table table3211criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);

			table3211criteria3.setPadding(5);
			table3211criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
				Cell cell2111=new Cell(new Paragraph((criteria3Record.getYearTable3221().get(i).getInput3221y()),font5));
				cell2111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3211criteria3.addCell(cell2111);
				

			}
			for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
				Cell cell2111=new Cell(new Paragraph((criteria3Record.getYearTable3221().get(i).getInput3221v()),font5));
				cell2111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3211criteria3.addCell(cell2111);

			}

			document.add(table3211criteria3);
		}
		PdfPTable table4criteria3 = new PdfPTable(2);
		PdfPTable table43criteria31 = new PdfPTable(1);

		table4criteria3.setWidthPercentage(100f);
		table43criteria31.setWidthPercentage(100f);
		
		PdfPCell cell41criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell41criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell42criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell42criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell43criteria3 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n",font5));
		cell43criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell44criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(14).getCriteria3FilePath() : "",font5));
		cell44criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell44criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell45criteria3 = new PdfPCell(new Paragraph(
				"e-copies of the grant award letters for research projects sponsored by government and non- government\r\n\r\n",font5));
		cell45criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell46criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : "",font5));
		cell46criteria3.setExtraParagraphSpace(10f);
		cell46criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell47criteria3 = new PdfPCell(new Paragraph("Provide the List of project and grant details (Data Template as of 3.1.6)\r\n",font5));
		
		cell47criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell48criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(9).getCriteria3FilePath() : "",font5));
		cell48criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell48criteria3.setExtraParagraphSpace(10F);
//		table43criteria31.addCell(cell321criteria3);
//		table43criteria31.addCell(cell3211criteria3);

		table4criteria3.addCell(cell41criteria3);
		table4criteria3.addCell(cell42criteria3);
		table4criteria3.addCell(cell43criteria3);
		table4criteria3.addCell(cell44criteria3);
		table4criteria3.addCell(cell45criteria3);
		table4criteria3.addCell(cell46criteria3);
		table4criteria3.addCell(cell47criteria3);
		table4criteria3.addCell(cell48criteria3);

	//	table43criteria31.addCell(table4criteria3);

		table4criteria3.setSpacingBefore(20f);
		table4criteria3.setSpacingAfter(20f);

//		document.add(table43criteria31);
		
		document.add(table4criteria3);
		
		// create table 3211/////


		// create table 5 //////
		
		PdfPCell cell322criteria3 = new PdfPCell(
				new Paragraph("3.2.2 Number of research projects per teacher funded by government, nongovernment , industry, corporate houses, international bodies during \r\n"
						+ "the last five years"
						+ "Response\r\n"
						+ (criteria3Record != null
								? criteria3Record.getCriteria32Qn().get(0).getResponse322()
								: ""),
						font4));
		cell322criteria3.setExtraParagraphSpace(10F);
		
		document.add(cell322criteria3);
		PdfPCell cell3221criteria3 = new PdfPCell(new Paragraph(
				"3.2.2.1 Number of research projects funded by government and nongovernment agencies during the last five years\r\n"
						+ (criteria3Record != null
						? criteria3Record.getCriteria32Qn().get(0).getInput3221t11()
						: ""),font4));
		cell3221criteria3.setExtraParagraphSpace(10F);
		
		document.add(cell3221criteria3);
		
		// create table 3221 //////

//		if (criteria3Record.getYearTable3221().size() >0 ) {
//			Table table3221criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);
//
//			table3221criteria3.setPadding(5);
//			table3221criteria3.setWidth(100f);
//
//			for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
//				table3221criteria3.addCell(criteria3Record.getYearTable3221().get(i).getInput3221y());
//
//			}
//			for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
//				table3221criteria3.addCell(criteria3Record.getYearTable3221().get(i).getInput3221v());
//
//			}
//
//			document.add(table3221criteria3);
////		}
		
		
		
		
		

		if (criteria3Record.getYearTable3221().size() >0 ) 
		{
			Table table3221criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);

			table3221criteria3.setPadding(5);
			table3221criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
				Cell cell2111=new Cell(new Paragraph((criteria3Record.getYearTable3221().get(i).getInput3221y()),font5));
				cell2111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3221criteria3.addCell(cell2111);
				

			}
			for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
				Cell cell2111=new Cell(new Paragraph((criteria3Record.getYearTable3221().get(i).getInput3221v()),font5));
				cell2111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3221criteria3.addCell(cell2111);

			}

	//		document.add(table3221criteria3);
		}		
		
		
		
		
		
		
		PdfPTable table5criteria3 = new PdfPTable(2);
		PdfPTable table53criteria31 = new PdfPTable(1);

		table5criteria3.setWidthPercentage(100f);
		table53criteria31.setWidthPercentage(100f);

		PdfPCell cell51criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
		cell51criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell52criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell52criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell53criteria3 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n",font5));
		cell53criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell54criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(15).getCriteria3FilePath() : "",font5));
		cell54criteria3.setExtraParagraphSpace(10f);
		cell54criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell55criteria3 = new PdfPCell(new Paragraph("\r\ne-copies of the grant award letters for research\r\n"
				+ "projects sponsored by government\r\n"
				+ "\r\n\r\n",font5));
		cell55criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell56criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(16).getCriteria3FilePath() : "",font5));
		cell56criteria3.setExtraParagraphSpace(10f);
		cell56criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		//			table53criteria31.addCell(cell322criteria3);
//		table53criteria31.addCell(cell3221criteria3);
		table5criteria3.addCell(cell51criteria3);
		table5criteria3.addCell(cell52criteria3);
		table5criteria3.addCell(cell53criteria3);
		table5criteria3.addCell(cell54criteria3);
		table5criteria3.addCell(cell55criteria3);
		table5criteria3.addCell(cell56criteria3);
		

	//	table53criteria31.addCell(table5criteria3);
		// document.add(cell322criteria3);
		// document.add(cell3221criteria3);
		table5criteria3.setSpacingBefore(20f);
		table5criteria3.setSpacingAfter(20f);

		document.add(table5criteria3);

		// create table 6////
		///////////////////////////////////----------------------------------->
		
		
		PdfPTable table053criteria31 = new PdfPTable(1);
		table053criteria31.setWidthPercentage(100f);
		
		
		
		PdfPCell cell056criteria3 = new PdfPCell(new Paragraph("3.2.3 Number of research projects per teacher funded by government and non-government agencies\r\n"
						+ "during the last five years\r\n"
						+ "Response:\r\n"
						+ (criteria3Record != null
								? criteria3Record.getCriteria32Qn().get(0).getResponse323()
								: ""),
						font4));
		cell056criteria3.setExtraParagraphSpace(10f);
		table053criteria31.addCell(cell056criteria3);
	
		
		
		PdfPCell cell0056criteria3 = new PdfPCell(new Paragraph(
				new Paragraph("3.2.3.1 Number of research projects funded by government and non-government agencies during the last five years.\r\n"
					 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria32Qn().get(0).getInput3231t1()
								: ""),
						font4)));
		
		cell0056criteria3.setExtraParagraphSpace(10f);
		table053criteria31.addCell(cell0056criteria3);
		

		
		PdfPCell cell000056criteria3 = new PdfPCell( new Paragraph(
				new Paragraph("3.2.3.2 Number of full time teachers worked in the institution year-wise during the last five years..\r\n"
					
						  + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria32Qn().get(0).getInput3231t2()
								: ""),
						font4)));
		
		cell000056criteria3.setExtraParagraphSpace(10f);
		
		table053criteria31.addCell(cell000056criteria3);
		
//		document.add(table053criteria31);
		
		//3231
		if (criteria3Record.getUniversityYearTable3231( ) .size() >0 ) {
			Table table3231criteria3 = new Table(criteria3Record.getUniversityYearTable3231().size(), 2);

			table3231criteria3.setPadding(5);
			table3231criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getUniversityYearTable3231().size(); i++) {
				Cell cell4=new Cell(new Paragraph((criteria3Record.getUniversityYearTable3231().get(i).getInput3231y()),font5));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3231criteria3.addCell(cell4);

			}
			for (int i = 0; i < criteria3Record.getUniversityYearTable3231().size(); i++) {
				Cell cell41=new Cell(new Paragraph((criteria3Record.getUniversityYearTable3231().get(i).getInput3231v()),font5));
				cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3231criteria3.addCell(cell41);

			}

		//	document.add(table3231criteria3);
		}
		// 3231
		
		
		PdfPCell cell3232criteria311 = new PdfPCell(
				new Paragraph("3.2.3.2 Number of full time teachers worked in the institution year-wise during the last five years..\r\n"
					
					 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria32Qn().get(0).getInput3232t1()
								: ""),
						font4));
		cell3232criteria311.setExtraParagraphSpace(10f);
	//	document.add(cell3232criteria311);
		
		if (criteria3Record.getUniversityYearTable3232().size() >0 ) {
			Table table3232criteria3 = new Table(criteria3Record.getUniversityYearTable3232().size(), 2);

			table3232criteria3.setPadding(5);
			table3232criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getUniversityYearTable3232().size(); i++) {
				Cell cell4=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3232().get(i).getInput3232y(),font5));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3232criteria3.addCell(cell4);

				

			}
			for (int i = 0; i < criteria3Record.getUniversityYearTable3231().size(); i++) {
				Cell cell1114=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3232().get(i).getInput3232v(),font5));
				cell1114.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3232criteria3.addCell(cell1114);
				

			}

	//		document.add(table3232criteria3);
		}
		
		PdfPTable table6criteria3 = new PdfPTable(2);
		PdfPTable table63criteria31 = new PdfPTable(1);

		table6criteria3.setWidthPercentage(100f);
		table63criteria31.setWidthPercentage(100f);
		
		PdfPCell cell61criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell61criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell62criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell61criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell63criteria3 = new PdfPCell(
				new Paragraph("\r\nProvide the List of research projects and funding details (Data Templateas of 3.1.6)\r\n"));
		cell63criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell64criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(16).getCriteria3FilePath() : ""));
		cell64criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell64criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell65criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
		cell65criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell66criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(17).getCriteria3FilePath() : ""));
		cell66criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell66criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell67criteria3 = new PdfPCell(new Paragraph("Supporting document from the Funding Agency\r\n"));
		cell67criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell68criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(18).getCriteria3FilePath() : ""));
		cell68criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell68criteria3.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell69criteria3 = new PdfPCell(new Paragraph("Supporting document from the Funding Agency\r\n"));
		cell69criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell70criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : ""));
		cell70criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell70criteria3.setExtraParagraphSpace(10f);
		
		table6criteria3.addCell(cell61criteria3);
		table6criteria3.addCell(cell62criteria3);
		table6criteria3.addCell(cell63criteria3);
		table6criteria3.addCell(cell64criteria3);
		table6criteria3.addCell(cell65criteria3);
		table6criteria3.addCell(cell66criteria3);
		table6criteria3.addCell(cell67criteria3);
		table6criteria3.addCell(cell68criteria3);
		table6criteria3.addCell(cell69criteria3);
		
		table6criteria3.addCell(cell70criteria3);
		
		table6criteria3.setSpacingAfter(20f);
		table6criteria3.setSpacingBefore(20F);
	//	document.add(table6criteria3);
		
		
		// 3.3 
		
		Paragraph paragraph4criteria3 = new Paragraph("3.3	Innovation Ecosystem\r\n\r\n", font2);
		paragraph4criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph4criteria3);
		// create table 8 ///
		PdfPTable table8criteria3 = new PdfPTable(2);
		PdfPTable table81criteria31 = new PdfPTable(1);

		table8criteria3.setWidthPercentage(100f);
		table81criteria31.setWidthPercentage(100f);
		
		PdfPCell cell81criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
		cell81criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell82criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
		cell82criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell83criteria3 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n"));
		cell83criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell84criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(18).getCriteria3FilePath() : ""));
		cell84criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell84criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell85criteria3 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n"));
		cell85criteria3.setExtraParagraphSpace(10f);
		
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
				"3.3.1	nstitution has created an ecosystem for innovations, Indian \r\n"
				+ "Knowledge System (IKS) including awareness about IPR, \r\n"
				+ "establishment of IPR cell, Incubation centre and other initiatives for \r\n"
				+ "the creation and transfer of technology/knowledge and the outcomes \r\n"
				+ "of the same are evident.\r\n"
					 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria33Ql().get(0).getInput331t1()
								: ""),
				font4));
		
		cell331criteria3.setExtraParagraphSpace(10F);
		table81criteria31.addCell(cell331criteria3);
//		table81criteria31.addCell(table8criteria3);

		// document.add(cell331criteria3);

		table8criteria3.setSpacingBefore(20f);
		table8criteria3.setSpacingAfter(20f);

		document.add(table81criteria31);
		
		document.add(table8criteria3);
		/// create table 9 ////
		
		
		PdfPTable table081criteria31 = new PdfPTable(1);		
		table081criteria31.setWidthPercentage(100f);
		
		
		PdfPCell cell0331criteria3 = new PdfPCell(new Paragraph(
				"3.3.2 Number of awards received for research/innovations by the \r\n"
				+ "institution/teachers/research scholars/students during the last five \r\n"
				+ "years\r\n"
			
				+ "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria33Qn().get(0).getResponse332()
								: ""),font4));
		cell0331criteria3.setExtraParagraphSpace(10F);
		
		table081criteria31.addCell(cell0331criteria3);
		
		
		PdfPCell cell00331criteria3 = new PdfPCell(new Paragraph(
				"3.3.2.1 Total number of awards received for research/innovations by \r\n"
				+ "institution/teachers/research scholars/students during the last five years.\r\n"
				+ (criteria3Record != null
				? criteria3Record.getCriteria33Qn().get(0).getInput3321t11()
				: "")		+ "\r\n",font4));
		table081criteria31.addCell(cell00331criteria3);
		
		document.add(table081criteria31);
		
//		
		// create a table 3321 //

		if (criteria3Record.getYearTable3321() .size() >0 ) {
			Table table3321criteria3 = new Table(criteria3Record.getYearTable3321().size(), 2);

			table3321criteria3.setPadding(5);
			table3321criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3321().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3321().get(i).getInput3321y(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3321criteria3.addCell(cell2);

			}
			for (int i = 0; i < criteria3Record.getYearTable3321().size(); i++) {
				Cell cell21=new Cell(new Paragraph(criteria3Record.getYearTable3321().get(i).getInput3321v(),font5));
				cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3321criteria3.addCell(cell21);

			}

//			document.add(table3321criteria3);
		}
		
		PdfPTable table9criteria3 = new PdfPTable(2);


		table9criteria3.setWidthPercentage(100f);
	
		PdfPCell cell91criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n", font4));
		cell91criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell92criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font4));
		cell92criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell93criteria3 = new PdfPCell(new Paragraph("\r\nReport of the event\r\n",font5));
		cell93criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell94criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell94criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell94criteria3.setExtraParagraphSpace(10);
		
		PdfPCell cell95criteria3 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n",font5));
		cell95criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell96criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell96criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell96criteria3.setExtraParagraphSpace(10);
		
		PdfPCell cell951criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
		cell951criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell961criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell961criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell961criteria3.setExtraParagraphSpace(10);
		
		table9criteria3.addCell(cell91criteria3);
		table9criteria3.addCell(cell92criteria3);
		table9criteria3.addCell(cell93criteria3);
		table9criteria3.addCell(cell94criteria3);
		table9criteria3.addCell(cell95criteria3);
		table9criteria3.addCell(cell96criteria3);
		table9criteria3.addCell(cell951criteria3);
		table9criteria3.addCell(cell961criteria3);
//		table91criteria31.addCell(cell332criteria3);
//		table91criteria31.addCell(cell3321criteria3);
	
		
		table9criteria3.setSpacingBefore(20f);
		table9criteria3.setSpacingAfter(20f);

		document.add(table9criteria3);

		// document.add(cell332criteria3);
		// document.add(cell3321criteria3);

		
		
		
		PdfPTable table333criteria3 = new PdfPTable(2);
		PdfPTable table3331criteria31 = new PdfPTable(1);

		table333criteria3.setWidthPercentage(100f);
		table3331criteria31.setWidthPercentage(100f);
		PdfPCell cell911criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell911criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell922criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		
		cell922criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
//		PdfPCell cell933criteria3 = new PdfPCell(new Paragraph("Report of the event\r\n\r\n\r\n"));
//		PdfPCell cell944criteria3 = new PdfPCell(
//				new Paragraph(criteria3_FieldInfoQnList != null ? criteria3file.get(16).getCriteria3FilePath() : ""));
		PdfPCell cell955criteria3 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n",font5));
		cell955criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell966criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
		cell966criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell966criteria3.setExtraParagraphSpace(10);
		
		
		PdfPCell cell9511criteria3 = new PdfPCell(new Paragraph("\r\ne-copies of award letters\r\n\r\n",font5));
		cell9511criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell9611criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
		cell9611criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell9611criteria3.setExtraParagraphSpace(10);
		
		table333criteria3.addCell(cell911criteria3);
		table333criteria3.addCell(cell922criteria3);
//		table333criteria3.addCell(cell933criteria3);
//		table333criteria3.addCell(cell944criteria3);
		table333criteria3.addCell(cell955criteria3);
		table333criteria3.addCell(cell966criteria3);
		table333criteria3.addCell(cell9511criteria3);
		table333criteria3.addCell(cell9611criteria3);
		PdfPCell cell333criteria3 = new PdfPCell(new Paragraph(
				"3.3.3 Number of awards / recognitions received for research/innovations by the institution / teachers\r\n"
				+ "/ research scholars / students during the last five years.\r\n"
				+ "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria33Qn().get(0).getResponse333()
								: ""),
				font4));
		cell333criteria3.setExtraParagraphSpace(10);
		
		PdfPCell cell3331criteria3 = new PdfPCell(new Paragraph(
				"3.3.3.1 Total number of awards / recognitions received for research / innovations won by institution /\r\n"
				+ "teachers / research scholars / students year-wise during the last five years."
						+ "\r\n\r\n",
				font4));
		cell3331criteria3.setExtraParagraphSpace(10);
//		table3331criteria31.addCell(cell333criteria3);
//		table3331criteria31.addCell(cell3331criteria3);
//		table3331criteria31.addCell(table333criteria3);

		// document.add(cell332criteria3);
		// document.add(cell3321criteria3);
		table333criteria3.setSpacingBefore(20f);
		table333criteria3.setSpacingAfter(20f);
		document.add(table3331criteria31);
		
//		document.add(table333criteria3);
		
		
		// create a table 3321 //

		if (criteria3Record.getUniversityYearTable3331().size() >0 ) {
			Table table3331criteria3 = new Table(criteria3Record.getUniversityYearTable3331().size(), 2);

			table3331criteria3.setPadding(5);
			table3331criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getUniversityYearTable3331().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3331().get(i).getInput3331y(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3331criteria3.addCell(cell2);

			}
			for (int i = 0; i < criteria3Record.getUniversityYearTable3331().size(); i++) {
				Cell cell1112=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3331().get(i).getInput3331v(),font5));
				cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3331criteria3.addCell(cell1112);

			}

	//		document.add(table3331criteria3);
		}
		

     // 3.4 
		
		
		Paragraph paragraph5criteria3 = new Paragraph("3.4	Research Publications and Awards\r\n\r\n", font2);
		paragraph5criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph5criteria3);
		// create table 10 ///
		PdfPTable table10criteria3 = new PdfPTable(2);
		PdfPTable table11criteria31 = new PdfPTable(1);
		table10criteria3.setWidthPercentage(100f);
		table11criteria31.setWidthPercentage(100f);
		PdfPCell cell101criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n\r\n", font4));
		cell101criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell102criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell102criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell103criteria3 = new PdfPCell(new Paragraph("Code of ethics for Research document, Research\r\n"
				+ "Advisory committee and ethics committee\r\n"
				+ "constitution and list of members on these\r\n"
				+ "committees, software used for Plagiarism check,\r\n"
				+ "link to Website\r\n"
				,font5));
		cell103criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell103criteria3.setExtraParagraphSpace(10);
		
		
		PdfPCell cell104criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
		cell104criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell104criteria3.setExtraParagraphSpace(10);
		
		PdfPCell cell105criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
		cell105criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell106criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell106criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell106criteria3.setExtraParagraphSpace(10);
		
		table10criteria3.addCell(cell101criteria3);
		table10criteria3.addCell(cell102criteria3);
		table10criteria3.addCell(cell103criteria3);
		table10criteria3.addCell(cell104criteria3);
		table10criteria3.addCell(cell105criteria3);
		table10criteria3.addCell(cell106criteria3);
		
		
		PdfPCell cell3401criteria3 = new PdfPCell(new Paragraph(
				" 3.4.1 The institution ensures implementation of its stated Code of\r\n"
				+ "Ethics for research \r\n"
					 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Ql().get(0).getResponse341()
								: ""),
				font4));
		cell3401criteria3.setExtraParagraphSpace(10f);
		table11criteria31.addCell(cell3401criteria3);
		
		PdfPCell cell3401criteria3111 = new PdfPCell(new Paragraph(
				" 3.4.1.1The institution has a stated Code of Ethics for research and the \r\n"
				+ "implementation of which is ensured through the following: \r\n"
				+ "1. Inclusion of research ethics in the research methodology course work \r\n"
				+ "2. Presence of institutional Ethics committees (Animal, chemical,bio-ethics \r\n"
				+ "etc.,)\r\n"
				+ "3. Plagiarism check \r\n"
				+ "4. Research Advisory Committee"
				+ "A. All of the above\r\n"
				+ "B. Any 3 of the above\r\n"
				+ "C. Any 2 of the above\r\n"
				+ "D. Any 1 of the above\r\n"
				+ "E. None of the above(Opt any one)"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Ql().get(0).getInput341t1()
								: ""),
				font4));
		cell3401criteria3111.setExtraParagraphSpace(10f);
		table11criteria31.addCell(cell3401criteria3111);
		

		document.add(table11criteria31);
		
		
		

		// document.add(cell341criteria3);
	//	table10criteria3.setSpacingBefore(20f);
		table10criteria3.setSpacingAfter(20f);
		document.add(table10criteria3);
		

		/// create table 11 ////
		PdfPTable table11criteria3 = new PdfPTable(2);
		PdfPTable table111criteria31 = new PdfPTable(1);

		table11criteria3.setWidthPercentage(100f);
		table111criteria31.setWidthPercentage(100f);

		PdfPCell cell111criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell111criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell112criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell112criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell113criteria3 = new PdfPCell(new Paragraph(
				"List of PhD scholars and their details like name of the guide , title of thesis, year of award etc",font5));
		cell113criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell113criteria3.setExtraParagraphSpace(10);
		
		PdfPCell cell114criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "",font5));
		cell114criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell114criteria3.setExtraParagraphSpace(10);
		
		PdfPCell cell115criteria3 = new PdfPCell(new Paragraph("\r\nURL to the research page on HEI web site\r\n\r\n",font5));
		cell115criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell116criteria3 = new PdfPCell(new Paragraph("",font5));
		cell116criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table11criteria3.addCell(cell111criteria3);
		table11criteria3.addCell(cell112criteria3);
		table11criteria3.addCell(cell113criteria3);
		table11criteria3.addCell(cell114criteria3);
		table11criteria3.addCell(cell115criteria3);
		table11criteria3.addCell(cell116criteria3);
		
		
		PdfPCell cell342criteria3 = new PdfPCell(new Paragraph(
				"3.4.2 Number of Patents awarded during the last five years"
			
			 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getResponse342()
								: ""),
				font4));
		cell342criteria3.setExtraParagraphSpace(10);
		

		table111criteria31.addCell(cell342criteria3);
		
		
		
		PdfPCell cell342criteria223 = new PdfPCell(new Paragraph(
				"3.4.2.1 Total number of Patents awarded year-wise during the last five \r\n"
				+ "years"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getInput342t1()
								: ""),
				font4));
		cell342criteria223.setExtraParagraphSpace(10);
		

		table111criteria31.addCell(cell342criteria223);			
		
		
		
		
		
		
//		// document.add(cell342criteria3);
//		PdfPCell cell3421criteria3 = new PdfPCell(
//				new Paragraph("3.4.2.1 How many Ph.Ds are registered within last 5 years" + "\r\n\r\n\r\n", font2));
//		PdfPCell cell3422criteria3 = new PdfPCell(new Paragraph(
//				"3.4.2.2 Number of teachers recognized as guides during the last five years\r\n" + "\r\n\r\n\r\n" + "Response:"
//						+ (criteria3_FieldInfoQnList != null
//								? criteria3_FieldInfoQnList.get(0).getInput3422t1()
//								: ""),
//				font2));
//		table111criteria31.addCell(cell3421criteria3);
//		table111criteria31.addCell(cell3422criteria3);
	

		// document.add(cell3421criteria3);
		// document.add(cell3422criteria3);


		document.add(table111criteria31);
		
		table11criteria3.setSpacingAfter(20f);
		table11criteria3.setSpacingAfter(20f);
		document.add(table11criteria3);
		
		
		
		/// create table 12 /////
		PdfPTable table12criteria3 = new PdfPTable(2);
		PdfPTable table123criteria31 = new PdfPTable(1);

		table12criteria3.setWidthPercentage(100f);
		table123criteria31.setWidthPercentage(100f);
		
		PdfPCell cell121criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell121criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell122criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n\r\n", font4));
		cell122criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell123criteria3 = new PdfPCell(new Paragraph(
				"\r\nInstitutional data in prescribed format\r\n\r\n",
				font5));
		cell123criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell124criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "",font5));
		cell124criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell124criteria3.setExtraParagraphSpace(10);
		
		PdfPCell cell125criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell125criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell126criteria3 = new PdfPCell(new Paragraph(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "",font5));
		cell126criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell126criteria3.setExtraParagraphSpace(10);
	
		
		table12criteria3.addCell(cell121criteria3);
		table12criteria3.addCell(cell122criteria3);
		table12criteria3.addCell(cell123criteria3);
		table12criteria3.addCell(cell124criteria3);
		table12criteria3.addCell(cell125criteria3);
		table12criteria3.addCell(cell126criteria3);
		
		
		PdfPCell cell343criteria3 = new PdfPCell(new Paragraph(
				" 3.4.3 Number of Ph.Ds awarded per recognized guide during the last five \r\n"
				+ "years.\r\n"
						+ "\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getResponse343()
								: ""),
				font4));
		cell343criteria3.setExtraParagraphSpace(10F);
		PdfPCell cell3431criteria3 = new PdfPCell(new Paragraph(
				"3.4.3.1 How many Ph.D s were awarded during last 5 years\r\n"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getInput343t1()
								: ""),
				font4));
		
		cell3431criteria3.setExtraParagraphSpace(10F);
		table123criteria31.addCell(cell343criteria3);
		table123criteria31.addCell(cell3431criteria3);
		
		PdfPCell cell3431criteria311 = new PdfPCell(new Paragraph(
				"3.4.3.2: Number of teachers recognized as guides during the last five \r\n"
				+ "years\r\n"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getInput343t1()
								: ""),
				font4));
		
		cell3431criteria311.setExtraParagraphSpace(10F);	
		
		
		table123criteria31.addCell(cell3431criteria311);
		
		
		
		


		// document.add(cell343criteria3);
		// document.add(cell3431criteria3);


		document.add(table123criteria31);
		
		table12criteria3.setSpacingBefore(20f);
		table12criteria3.setSpacingAfter(20f);
		document.add(table12criteria3);
		
		/// create table 3431 ////

		if (criteria3Record.getUniversityYearTable3431() .size() >0 ) {
			Table table3431criteria3 = new Table(criteria3Record.getUniversityYearTable3431().size(), 2);

			table3431criteria3.setPadding(5);
			table3431criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getUniversityYearTable3431().size(); i++) {
				Cell cell2111=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3431().get(i).getInput3431y(),font5));
				cell2111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3431criteria3.addCell(cell2111);
				

			}
			for (int i = 0; i < criteria3Record.getUniversityYearTable3431().size(); i++) {
				Cell cell2111=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3431().get(i).getInput3431v(),font5));
				cell2111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3431criteria3.addCell(cell2111);
			}

			document.add(table3431criteria3);
		}
		/// create table 13 //
		PdfPTable table13criteria3 = new PdfPTable(2);
		PdfPTable table131criteria31 = new PdfPTable(1);

		table13criteria3.setWidthPercentage(100f);
		table131criteria31.setWidthPercentage(100f);

		PdfPCell cell131criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell131criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell132criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell132criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell133criteria3 = new PdfPCell(
				new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n",font5));
		cell133criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell134criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "",font5));
		cell134criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell134criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell135criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n\r\n",font5));
		cell135criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell136criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "",font5));
		cell136criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell136criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell1351criteria3 = new PdfPCell(new Paragraph("\r\nURL to the research page on HEI web site\r\n\r\n",font5));
		cell1351criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell1361criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : "",font5));
		cell1361criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1361criteria3.setExtraParagraphSpace(10f);
		
		
		table13criteria3.addCell(cell131criteria3);
		table13criteria3.addCell(cell132criteria3);
		table13criteria3.addCell(cell133criteria3);
		table13criteria3.addCell(cell134criteria3);
		table13criteria3.addCell(cell135criteria3);
		table13criteria3.addCell(cell136criteria3);
		table13criteria3.addCell(cell1351criteria3);
		table13criteria3.addCell(cell1361criteria3);
		
		table13criteria3.setSpacingBefore(20f);
		table13criteria3.setSpacingAfter(20f);

		document.add(table13criteria3);	
		
		
		PdfPCell cell3444criteria3 = new PdfPCell(new Paragraph(
				"3.4.4 Number of Ph.D’s awarded per teacher during the last five years."
					 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getResponse344()
								: ""),
				font4));
		cell3444criteria3.setExtraParagraphSpace(10F);
		
		
		
		
		PdfPCell cell3441criteria3 = new PdfPCell(new Paragraph(
				"3.4.4.1 Number of research papers published in the Journals as notified \r\n"
				+ "on UGC CARE list during the last five years \r\n"
//				+ "Response:"
//						+ (criteria3Record != null
//						? criteria3Record.getCriteria34Qn().get(0).getInput3441t1()
//						: "")
,
				font4));
//		PdfPCell cell3442criteria3 = new PdfPCell(new Paragraph(
//				"3.4.4.2 Number of teachers recognized as guides during the last five years\r\n"
//			+ "Response:"
//				+ (criteria3Record != null
//				? criteria3Record.getCriteria3FieldInfoQn().get(0).getInput3422t1()
//				: ""),
//				font3));
		table131criteria31.addCell(cell3444criteria3);
		table131criteria31.addCell(cell3441criteria3);
	//	table131criteria31.addCell(cell3442criteria3);

		// document.add(cell344criteria3);
		// document.add(cell3441criteria3);
//		table131criteria31.setSpacingBefore(20f);
//		table131criteria31.setSpacingAfter(20f);

		document.add(table131criteria31);
		
	
		
		
		// create table 3441 //
//
//		if (criteria3Record.getYearTable3441().size() >0 ) {
//			Table table3441criteria3 = new Table(criteria3Record.getYearTable3441().size(), 2);
//
//			table3441criteria3.setPadding(5);
//			table3441criteria3.setWidth(100f);
//
//			for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
//				Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3441().get(i).getInput3441y(),font5));
//				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table3441criteria3.addCell(cell2);
//			}
//			for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
//				Cell cell21=new Cell(new Paragraph(criteria3Record.getYearTable3441().get(i).getInput3441v(),font5));
//				cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table3441criteria3.addCell(cell21);
//			}
//			table3441criteria3.setSpacing(5f);
//			document.add(table3441criteria3);
//		}
//		
	///	
		
		if (criteria3Record.getYearTable3441().size() >0 ) {
			Table table3441criteria3 = new Table(criteria3Record.getYearTable3441().size(), 2);

			table3441criteria3.setPadding(5);
			table3441criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
				Cell cell1112=new Cell(new Paragraph((criteria3Record.getYearTable3441().get(i).getInput3441y()),font5));
				cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3441criteria3.addCell(cell1112);

			}
			for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
				Cell cell1112=new Cell(new Paragraph((criteria3Record.getYearTable3441().get(i).getInput3441v()),font5));
				cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3441criteria3.addCell(cell1112);
				

			}

			document.add(table3441criteria3);
		}
		
		
			
		
		
		
		
		
		
		
		
		
///////////		
		if (criteria3Record.getUniversityYearTable3442().size()>0) {
			Table table3442criteria3 = new Table(criteria3Record .getUniversityYearTable3442().size(), 2);

			table3442criteria3.setPadding(5);
			table3442criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getUniversityYearTable3442().size(); i++) {
				Cell cell1112=new Cell(new Paragraph((criteria3Record.getUniversityYearTable3442().get(i).getInput3442y()),font5));
				cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3442criteria3.addCell(cell1112);
				

			}
			for (int i = 0; i < criteria3Record.getUniversityYearTable3442().size(); i++) {
				Cell cell002=new Cell(new Paragraph((criteria3Record.getUniversityYearTable3442().get(i).getInput3442v()),font5));
				cell002.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3442criteria3.addCell(cell002);
				

			}
		
		//	document.add(table3442criteria3);
		}
		
		
		
		

		// create table 14 //
		PdfPTable table14criteria3 = new PdfPTable(2);

		table14criteria3.setWidthPercentage(100f);
	

		PdfPCell cell141criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell141criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell142criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell142criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell143criteria3 = new PdfPCell(
				new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n",font5));
		cell143criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
		
		PdfPCell cell144criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : "",font5));
		cell144criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell144criteria3.setExtraParagraphSpace(10F);
		
		
		PdfPCell cell145criteria3 = new PdfPCell(
				new Paragraph("\r\nAny additional information\r\n\r\n",font5));
		cell145criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell146criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : "",font5));
		cell146criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell146criteria3.setExtraParagraphSpace(10F);
		
		
		table14criteria3.addCell(cell141criteria3);
		table14criteria3.addCell(cell142criteria3);
		table14criteria3.addCell(cell143criteria3);
		table14criteria3.addCell(cell144criteria3);
		table14criteria3.addCell(cell145criteria3);
		table14criteria3.addCell(cell146criteria3);
		table14criteria3.setSpacingBefore(20f);
		table14criteria3.setSpacingAfter(20f);
		document.add(table14criteria3);
		
		PdfPTable table141criteria31 = new PdfPTable(1);
		table141criteria31.setWidthPercentage(100f);
		PdfPCell cell3451criteria3 = new PdfPCell(new Paragraph(
				"3.4.5 Number of books and chapters in edited volumes published per \r\n"
				+ "teacher during the last five years\r\n"
				+ "Response: "
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getResponse345()
								: ""),
				font4));
		
		cell3451criteria3.setExtraParagraphSpace(10F);
		
		
		PdfPCell cell34512criteria3 = new PdfPCell(new Paragraph("3.4.5.1 Total number of books and chapters in edited volumes / books \r\n"
				+ "published year- wise during the last five years ",font4));
						
		cell34512criteria3.setExtraParagraphSpace(10F);
		table141criteria31.addCell(cell3451criteria3);
		table141criteria31.addCell(cell34512criteria3);
//		
//		table141criteria31.addCell(table14criteria3);
	
		document.add(table141criteria31);
		
		

		
		
		
		if (criteria3Record.getUniversityYearTable3451().size() >0 ) {
			Table table3451criteria3 = new Table(criteria3Record.getUniversityYearTable3451().size(), 2);

			table3451criteria3.setPadding(5);
			table3451criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getUniversityYearTable3451().size(); i++) {
				Cell cell1112=new Cell(new Paragraph((criteria3Record.getUniversityYearTable3451().get(i).getInput3451y()),font5));
				cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3451criteria3.addCell(cell1112);

			}
			for (int i = 0; i < criteria3Record.getUniversityYearTable3451().size(); i++) {
				Cell cell1112=new Cell(new Paragraph((criteria3Record.getUniversityYearTable3451().get(i).getInput3451v()),font5));
				cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3451criteria3.addCell(cell1112);
				

			}

			document.add(table3451criteria3);
		}
		
		
		
		
		// create table 15 //
		
		PdfPCell cell346criteria3 = new PdfPCell(new Paragraph(
				"3.4.6 E-content is developed by teachers :"
				+ "1. For e-PG-Pathshala\r\n"
				+ "2. For CEC (Undergraduate) \r\n"
				+ "3. For SWAYAM\r\n"
				+ "4. For other MOOCs platforms\r\n"
				+ "5. Any other Government Initiatives\r\n"
				+ "6. For Institutional LMS\r\n"
				+ ""
				+ "A. Any 4 or more of the above\r\n"
				+ "B. Any 3 of the above\r\n"
				+ "C. Any 2 of the above\r\n"
				+ "D. Any 1 of the above\r\n"
				+ "E. None of the above\r\n"
			
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getResponse346()
								: ""),
				font2));
		
		cell346criteria3.setExtraParagraphSpace(10f);
		document.add(cell346criteria3);
		PdfPCell cell3461criteria3 = new PdfPCell(new Paragraph(
				"3.4.6.1 Total number of books and chapters in edited volumes/books published and papers in\r\n"
				+ "national/ international conference proceedings year-wise during last five years"
						+ "\r\n\r\n\r\n" + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getInput3461t1()
								: ""),
				font2));
		cell3461criteria3.setExtraParagraphSpace(10f);
		
	//	document.add(cell3461criteria3);
		
		PdfPTable table15criteria3 = new PdfPTable(2);
		PdfPTable table153criteria31 = new PdfPTable(1);

		table15criteria3.setWidthPercentage(100f);
		table153criteria31.setWidthPercentage(100f);

		PdfPCell cell151criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell151criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell152criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell152criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell153criteria3 = new PdfPCell(new Paragraph(
				"\r\nInstitutional data in prescribed format\r\n\r\n",font5));
		cell153criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell154criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(9).getCriteria3FilePath() : "",font5));
		cell154criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell154criteria3.setExtraParagraphSpace(10F);
		
		PdfPCell cell1531criteria3 = new PdfPCell(new Paragraph(
				"\r\nAny additional information\r\n\r\n",font5));
		cell1531criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1542criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(10).getCriteria3FilePath() : "",font5));
		cell1542criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1542criteria3.setExtraParagraphSpace(10f);
		table15criteria3.addCell(cell151criteria3);
		table15criteria3.addCell(cell152criteria3);
		table15criteria3.addCell(cell153criteria3);
		table15criteria3.addCell(cell154criteria3);
		table15criteria3.addCell(cell1531criteria3);
		table15criteria3.addCell(cell1542criteria3);
		


		// document.add(cell346criteria3);
		table15criteria3.setSpacingBefore(20f);
		table15criteria3.setSpacingAfter(20f);
	//	document.add(table15criteria3);
		
		
		if (criteria3Record.getUniversityYearTable3461().size() >0 ) {
			Table table3461criteria3 = new Table(criteria3Record.getUniversityYearTable3461().size(), 2);

			table3461criteria3.setPadding(5);
			table3461criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getUniversityYearTable3461().size(); i++) {
				Cell cell1=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3461().get(i).getInput3461y(),font5));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3461criteria3.addCell(cell1);
				

			}
			for (int i = 0; i < criteria3Record.getUniversityYearTable3461().size(); i++) {
				Cell cell1=new Cell(new Paragraph(criteria3Record.getUniversityYearTable3461().get(i).getInput3461v(),font5));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3461criteria3.addCell(cell1);
			}

		//	document.add(table3461criteria3);
		}
		
		
		
		
		Paragraph paragraph01criteria311 = new Paragraph("3.4.6.1: Average number of full time teachers during the last five years",font4);
		document.add(paragraph01criteria311);
			
			if (criteria3Record.getUniversityYearTable34612().size() >0 ) {
				Table table34612criteria3 = new Table(criteria3Record.getUniversityYearTable34612().size(), 2);

				table34612criteria3.setPadding(5);
				table34612criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getUniversityYearTable34612().size(); i++) {
					Cell cell1=new Cell(new Paragraph(criteria3Record.getUniversityYearTable34612().get(i).getInput34612y(),font5));
					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					table34612criteria3.addCell(cell1);

				}
				for (int i = 0; i < criteria3Record.getUniversityYearTable34612().size(); i++) {
					Cell cell111=new Cell(new Paragraph(criteria3Record.getUniversityYearTable34612().get(i).getInput34612v(),font5));
					cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
					table34612criteria3.addCell(cell111);
				}
		
		//		document.add(table34612criteria3);
			}
		
		////////////////////////////////----------------------------------------------------->
		PdfPTable table347criteria3 = new PdfPTable(2);
		PdfPTable table3471criteria31 = new PdfPTable(1);

		table347criteria3.setWidthPercentage(100f);
		table3471criteria31.setWidthPercentage(100f);

		PdfPCell cell1517criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell1517criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1527criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell1527criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1537criteria3 = new PdfPCell(new Paragraph(
				"\r\nInstitutional data in prescribed format\r\n\r\n",font5));
		cell1537criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1547criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(11).getCriteria3FilePath() : "",font5));
		cell1547criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1547criteria3.setExtraParagraphSpace(10F);
		
		PdfPCell cell15317criteria3 = new PdfPCell(new Paragraph(
				"\r\nGive links or upload document of e-content\r\n"
				+ "developed\r\n\r\n",font5));
		cell15317criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell15427criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(12).getCriteria3FilePath() : "",font5));
		cell15427criteria3.setExtraParagraphSpace(10F);
		cell15427criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table347criteria3.addCell(cell1517criteria3);
		table347criteria3.addCell(cell1527criteria3);
		table347criteria3.addCell(cell1537criteria3);
		table347criteria3.addCell(cell1547criteria3);
		table347criteria3.addCell(cell15317criteria3);
		table347criteria3.addCell(cell15427criteria3);
		
		
		PdfPCell cell3467criteria3 = new PdfPCell(new Paragraph(
				"3.4.7 Bibliometrics of the publications during the last five years based on \r\n"
				+ "average Citation Index in Scopus/ Web of Science/PubMed :\r\n"
				+ "Response: "
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getResponse347()
								: ""),
				font4));
		
		cell3467criteria3.setExtraParagraphSpace(10f);		
		table3471criteria31.addCell(cell3467criteria3);
	
		table3471criteria31.setSpacingBefore(20f);
	

		// document.add(cell346criteria3);
	
		document.add(table3471criteria31);
		table347criteria3.setSpacingBefore(20f);
		table347criteria3.setSpacingAfter(20f);
		
		document.add(table347criteria3);
		
		PdfPTable table348criteria3 = new PdfPTable(1);
		

		table348criteria3.setWidthPercentage(100f);
	
		
		PdfPCell cell348criteria3 = new PdfPCell(new Paragraph(
				"3.4.8 Bibliometrics of the publications during the last five years based on average citation index in\r\n"
				+ "Scopus/ Web of Science or PubMed\r\n"
				+ "Response:  "
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Qn().get(0).getResponse348()
								: ""),
				font4));
		
		cell348criteria3.setExtraParagraphSpace(10f);
		table348criteria3.addCell(cell348criteria3);
	
		
	
		// document.add(cell346criteria3);
		table348criteria3.setSpacingBefore(20f);
		table348criteria3.setSpacingAfter(20f);
		document.add(table348criteria3);
		
		
		PdfPTable table0003407criteria311 = new PdfPTable(1);


		table0003407criteria311.setWidthPercentage(100f);
		
		
		
		PdfPCell cell00348criteria3 = new PdfPCell(new Paragraph(new Paragraph("3.4.8.1: Total Number of Citations in Scopus in 5 years\r\n",font4)));

	//	table0003407criteria311.addCell(cell00348criteria3);
		
		PdfPCell cell000348criteria3 = new PdfPCell( new Paragraph((criteria3Record != null
				? criteria3Record.getCriteria34Qn().get(0).getInput348t1()
				: ""),font4));
		
		cell000348criteria3.setExtraParagraphSpace(10f);
		
//		table0003407criteria311.addCell(cell000348criteria3);
		

		PdfPCell cell010348criteria3 = new PdfPCell(new Paragraph("Total Number of Citations in Web of Science in 5 years\r\n",font4));
	//	table0003407criteria311.addCell(cell010348criteria3);
		
		
		PdfPCell cell010348criteria13 = new PdfPCell(new Paragraph((criteria3Record != null
					? criteria3Record.getCriteria34Qn().get(0).getInput348t2()
					: ""),font4));
		
		cell010348criteria13.setExtraParagraphSpace(10f);
		
//		table0003407criteria311.addCell(cell010348criteria13);
				
				
				
		PdfPCell cell011348criteria13 = new PdfPCell(new Paragraph(("3.4.8.2: Total number of Publications in Scopus in 5 years\r\n"),font4));
//		table0003407criteria311.addCell(cell011348criteria13);
	
		
		PdfPCell cell011348criteria113 = new PdfPCell(new Paragraph((criteria3Record != null
						? criteria3Record.getCriteria34Qn().get(0).getInput3482t1()
						: ""),font4));
		
		cell011348criteria113.setExtraParagraphSpace(10f);
//		table0003407criteria311.addCell(cell011348criteria113);
		
		
		PdfPCell cell011348criteria013 = new PdfPCell(new Paragraph("Total number of Publications in Web of Science in 5 years\r\n",font4));
	//	table0003407criteria311.addCell(cell011348criteria013);
		
		
		PdfPCell cell0113408criteria013 = new PdfPCell(new Paragraph((criteria3Record != null
							? criteria3Record.getCriteria34Qn().get(0).getInput3482t2()
							: ""),font4));
		cell0113408criteria013.setExtraParagraphSpace(10f);
//		table0003407criteria311.addCell(cell0113408criteria013);
//					
					document.add(table0003407criteria311)	;
						
						
						
						PdfPTable table3407criteria311 = new PdfPTable(2);


						table3407criteria311.setWidthPercentage(100f);


						PdfPCell cell1518criteria31 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
						cell1518criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
						
						
						PdfPCell cell1528criteria31 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
						cell1528criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
						
						PdfPCell cell1538criteria31 = new PdfPCell(new Paragraph(
								"\r\nBibiliometrics of publications based on Scopus/ Web of Science - h-index of the Institution\r\n\r\n",font5));
						cell1538criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
						
						
						PdfPCell cell1548criteria31 = new PdfPCell(
								new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
						cell1548criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell1548criteria31.setExtraParagraphSpace(10f);
						
						PdfPCell cell15318criteria31 = new PdfPCell(new Paragraph(
								"\r\nAny additional information\r\n"
								+ "developed\r\n\r\n",font5));
						cell15318criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
						
						
						PdfPCell cell15428criteria31 = new PdfPCell(
								new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
						cell15428criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell15428criteria31.setExtraParagraphSpace(10f);
						
						table3407criteria311.addCell(cell1518criteria31);
						
						
						table3407criteria311.addCell(cell1528criteria31);
						
						table3407criteria311.addCell(cell15318criteria31);
						table3407criteria311.addCell(cell15428criteria31);
						table3407criteria311.addCell(cell1538criteria31);
						table3407criteria311.addCell(cell1548criteria31);
						table3407criteria311.setSpacingBefore(20f);
						table3407criteria311.setSpacingAfter(20f);
						
		//				document.add(table3407criteria311);
					
						
						
						
						
						
				
				
				
	PdfPTable table349criteria3 = new PdfPTable(1);
		

	table349criteria3.setWidthPercentage(100f);
	
		
		PdfPCell cell349criteria3 = new PdfPCell(new Paragraph(
				"3.4.9 Bibliometrics of the publications during the last five years based on Scopus/ Web of Science - hindex of the Institution\r\n"
				+ "Response: "
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Ql().get(0).getResponse349(): ""),font4));
		cell349criteria3.setExtraParagraphSpace(10f);
		table349criteria3.addCell(cell349criteria3);
	
		
		
		PdfPCell cell349criteria321 = new PdfPCell(new Paragraph(
				"3.4.9.1: h-index of Scopus during the last five years\r\n"
				+ "Response: "
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Ql().get(0).getInput3491t1()
								: ""),font4));
		cell349criteria321.setExtraParagraphSpace(10f);
		table349criteria3.addCell(cell349criteria321);

		PdfPCell cell349criteria323 = new PdfPCell(new Paragraph(
				"h-index of Web of Science during the last five years\r\n"
				+ "Response: "
						+ (criteria3Record != null
								? criteria3Record.getCriteria34Ql().get(0).getInput3491t2()
								: "")
						,font4));
		
		cell349criteria323.setExtraParagraphSpace(10f);
		table349criteria3.addCell(cell349criteria323);
	
//		document.add(table349criteria3);
		
		
//	do
//		table349criteria3.addCell(cell349criteria323);
//		document.add(table349criteria3);
//	
		PdfPTable table3407criteria3 = new PdfPTable(2);


		table3407criteria3.setWidthPercentage(100f);


		PdfPCell cell1518criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell1518criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1528criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell1528criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1538criteria3 = new PdfPCell(new Paragraph(
				"\r\nBibiliometrics of publications based on Scopus/ Web of Science - h-index of the Institution\r\n\r\n",font5));
		cell1538criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1548criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(13).getCriteria3FilePath() : "",font5));
		cell1548criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1548criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell15318criteria3 = new PdfPCell(new Paragraph(
				"\r\nAny additional information\r\n"
				+ "developed\r\n\r\n",font5));
		cell15318criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell15428criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(14).getCriteria3FilePath() : "",font5));
		cell15428criteria3.setExtraParagraphSpace(10f);
		cell15428criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table3407criteria3.addCell(cell1518criteria3);
		table3407criteria3.addCell(cell1528criteria3);
		table3407criteria3.addCell(cell1538criteria3);
		table3407criteria3.addCell(cell1548criteria3);
		table3407criteria3.addCell(cell15318criteria3);
		table3407criteria3.addCell(cell15428criteria3);
		table3407criteria3.setSpacingAfter(20f);
		table3407criteria3.setSpacingBefore(20f);
		
		
	//	document.add(table3407criteria3);
		
		
// 3.5 
		

		Paragraph paragraph6criteria3 = new Paragraph("3.5	Consultancy\r\n\r\n", font2);
		paragraph6criteria3.setSpacingAfter(2f);
		paragraph6criteria3.setSpacingBefore(2f);
		paragraph6criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph6criteria3);
		// create table 16 //
		PdfPTable table16criteria3 = new PdfPTable(2);
		PdfPTable table161criteria31 = new PdfPTable(1);

		table16criteria3.setWidthPercentage(100f);
		table161criteria31.setWidthPercentage(100f);

		PdfPCell cell161criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell161criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell162criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell162criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell163criteria3 = new PdfPCell(new Paragraph("Upload minutes of the Governing Council/ Syndicate/Board of Management related to the Consultancy policy\r\n", font5));
		cell163criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell164criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "", font5));
		cell164criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell164criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell165criteria3 = new PdfPCell(new Paragraph(
				"Upload minutes of the Governing Council/ Syndicate/Board of Management related to the Consultancy policy\r\n", font5));
		cell165criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell166criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "", font5));
		cell166criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell166criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell167criteria3 = new PdfPCell(new Paragraph("Upload any additional information", font5));
		cell167criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell168criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "", font5));
		cell168criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell168criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell167criteria31 = new PdfPCell(new Paragraph("Paste URL of the consultancy policy document \r\n\r\n", font5));
		cell167criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell168criteria31 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "", font5));
		cell168criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell168criteria31.setExtraParagraphSpace(10f);
		
		table16criteria3.addCell(cell161criteria3);
		table16criteria3.addCell(cell162criteria3);
		table16criteria3.addCell(cell163criteria3);
		table16criteria3.addCell(cell164criteria3);
		table16criteria3.addCell(cell165criteria3);
		table16criteria3.addCell(cell166criteria3);
		table16criteria3.addCell(cell167criteria3);
		table16criteria3.addCell(cell168criteria3);
		table16criteria3.addCell(cell167criteria31);
		table16criteria3.addCell(cell168criteria31);
		
		
		PdfPCell cell351criteria3 = new PdfPCell(new Paragraph(
				"3.5.1 Revenue generated from consultancy and corporate training during the \r\n"
				+ "last five years (INR in Lakhs) .\r\n"
						 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria35Qn().get(0).getResponse351()
								: ""),
				font4));
		cell351criteria3.setExtraParagraphSpace(10f);
		table161criteria31.addCell(cell351criteria3);
	
		
		PdfPCell cell351criteria1113 = new PdfPCell(new Paragraph(
				"3.5.1.1: Total amount generated from consultancy and corporate training \r\n"
				+ "year-wise during the last five years (INR in lakhs) \r\n"
//						 + "Response:"
//						+ (criteria3Record != null
//								? criteria3Record.getCriteria35Qn().get(0).getResponse351()
//								: "")
,
				font4));
		cell351criteria1113.setExtraParagraphSpace(10f);
		table161criteria31.addCell(cell351criteria1113);
		

		
	
		document.add(table161criteria31);
		
		
		
		
		
		
		table16criteria3.setSpacingBefore(20f);
		table16criteria3.setSpacingAfter(20f);
		document.add(table16criteria3);
		
		
		
		
		if (criteria3Record.getYearTable3511().size() >0 ) {
			Table table3521criteria3 = new Table(criteria3Record.getYearTable3511().size(), 2);

			table3521criteria3.setPadding(5);
			table3521criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3511().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3511().get(i).getInput3511y(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3521criteria3.addCell(cell2);

			}
			for (int i = 0; i < criteria3Record.getYearTable3511().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3511().get(i).getInput3511v(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3521criteria3.addCell(cell2);
				

			}

			document.add(table3521criteria3);
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		PdfPTable table17criteria3 = new PdfPTable(2);
		

		table17criteria3.setWidthPercentage(100f);
		


		PdfPCell cell171criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		
		cell171criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell172criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell172criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell173criteria3 = new PdfPCell(
				new Paragraph("Audited statement/s of accounts indicating the revenue generated through consultancy\r\n",font5));
		cell173criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell174criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "",font5));
		cell174criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell174criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell175criteria3 = new PdfPCell(
				new Paragraph("Audited statement/s of accounts indicating the revenue generated through consultancy\r\n",font5));
		cell175criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell176criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "",font5));
		cell176criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell176criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell179criteria3 = new PdfPCell(new Paragraph("Audited statement/s of accounts indicating the revenue generated through consultancy\r\n",font5));
		cell179criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell180criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "",font5));
		cell180criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell180criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell179criteria322= new PdfPCell(new Paragraph("List of facilities and staff available for undertaking consultancy\r\n",font5));
		
		cell179criteria322.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell180criteria322= new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "",font5));
		cell180criteria322.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell180criteria322.setExtraParagraphSpace(10f);
	//	cell180criteria322.setExtraParagraphSpace(10f);
		
		
		table17criteria3.addCell(cell171criteria3);
		table17criteria3.addCell(cell172criteria3);
		table17criteria3.addCell(cell173criteria3);
		table17criteria3.addCell(cell174criteria3);
		table17criteria3.addCell(cell175criteria3);
		table17criteria3.addCell(cell176criteria3);
	
		table17criteria3.addCell(cell179criteria3);
		table17criteria3.addCell(cell180criteria3);
		table17criteria3.addCell(cell179criteria322);
		table17criteria3.addCell(cell180criteria322);
		
		
		table17criteria3.setSpacingBefore(20f);
		table17criteria3.setSpacingAfter(20f);

	//	document.add(table17criteria3);
		
		PdfPTable table173criteria31 = new PdfPTable(1);
		table173criteria31.setWidthPercentage(100f);
		
		PdfPCell cell0179criteria322= new PdfPCell(new Paragraph(
				"3.5.2 Revenue generated from consultancy and corporate training during the last five years (INR in\r\n"
				+ "Lakhs).\r\n"
				+ "Response: "
						+ (criteria3Record != null
								? criteria3Record.getCriteria35Ql().get(0).getResponse352()
								: ""),font4));
		
		cell0179criteria322.setExtraParagraphSpace(10f);
	//	table173criteria31.addCell(cell0179criteria322);
		
		PdfPCell cell0179criteria0322= new PdfPCell(new Paragraph(
				"3.5.2.1 Total amount generated from consultancy and corporate training year-wise during the last\r\nfive years (INR in lakhs)\r\n",font4));
		cell0179criteria0322.setExtraParagraphSpace(10f);
		table173criteria31.addCell(cell0179criteria0322);
		
		
//		document.add(table173criteria31);
		
		
		if (criteria3Record.getYearTable3521().size() >0 ) {
			Table table3521criteria3 = new Table(criteria3Record.getYearTable3521().size(), 2);

			table3521criteria3.setPadding(5);
			table3521criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3521().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3521().get(i).getInput3521y(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3521criteria3.addCell(cell2);

			}
			for (int i = 0; i < criteria3Record.getYearTable3521().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria3Record.getYearTable3521().get(i).getInput3521v(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3521criteria3.addCell(cell2);
				

			}

	//		document.add(table3521criteria3);
		}

		

		
		// 3.6 
		
		Paragraph paragraph7criteria3 = new Paragraph("3.6	Extension Activities\r\n\r\n", font2);
		paragraph7criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		paragraph7criteria3.setSpacingBefore(2f);
		paragraph7criteria3.setSpacingAfter(2f);
		document.add(paragraph7criteria3);
		
		
		// create table 18 //
		PdfPTable table18criteria3 = new PdfPTable(2);

		table18criteria3.setWidthPercentage(100f);
		
		


		PdfPCell cell181criteria3 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell181criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell182criteria3 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell182criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell183criteria3 = new PdfPCell(new Paragraph("Upload Any additional information\r\n\r\n\r\n",font5));
		cell183criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell184criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "",font5));
		cell184criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell184criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell185criteria3 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n",font5));
	
		cell185criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell186criteria3 = new PdfPCell(new Paragraph("",font5));
		cell186criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table18criteria3.addCell(cell181criteria3);
		table18criteria3.addCell(cell182criteria3);
		table18criteria3.addCell(cell183criteria3);
		table18criteria3.addCell(cell184criteria3);
		table18criteria3.addCell(cell185criteria3);
		table18criteria3.addCell(cell186criteria3);
	
		
		table18criteria3.setSpacingAfter(20f);
		table18criteria3.setSpacingBefore(20f);
		
		document.add(table18criteria3);
		
		PdfPTable table183criteria3 = new PdfPTable(1);

		table183criteria3.setWidthPercentage(100f);
		
		
		PdfPCell cell185criteria03 = new PdfPCell(new Paragraph(	"3.6.1 Extension activities in the neighborhood community in terms of impact \r\n"
				+ "and sensitizing the students to social issues and holistic development and \r\n"
				+ "awards received if any\r\n"
				+"Response:",font4));
		
		table183criteria3.addCell(cell185criteria03);
		
		
		
		if( criteria3Record.getCriteria36Ql() !=null)
		{
		
			PdfPCell cell185criteria003 = new PdfPCell( new Paragraph (criteria3Record != null
								? criteria3Record.getCriteria36Ql().get(0).getInput361t1()
								: "",font4));
			cell185criteria003.setExtraParagraphSpace(10f);
			table183criteria3.addCell(cell185criteria003);
		
		}
		

	

		// create table 19 //
		
		PdfPCell cell185criteria00321 = new PdfPCell(new Paragraph (
				"3.6.2 Number of extension and outreach programs conducted through \r\n"
				+ "organized forums by the institution during the last five years\r\n"
					 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria36Qn().get(0).getResponse362()
								: ""),font4));
		cell185criteria00321.setExtraParagraphSpace(10f);
		table183criteria3.addCell(cell185criteria00321);
		

		
		PdfPCell cell185criteria001321 = new PdfPCell(new Paragraph (
				"3.6.2.1 Number of extension and outreach programs conducted by the \r\n"
				+ "institution through organized forums like NSS/NCC during the last five \r\n"
				+ "years.\r\n"
				+ "."
						,font4));
		cell185criteria001321.setExtraParagraphSpace(10f);
		table183criteria3.addCell(cell185criteria001321);
		
		document.add(table183criteria3);
		

		if (criteria3Record.getYearTable3621().size() >0 ) {
			Table table3621criteria3 = new Table(criteria3Record.getYearTable3621().size(), 2);

			table3621criteria3.setPadding(5);
			table3621criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3621().size(); i++) {
				Cell cell112=new Cell(new Paragraph(criteria3Record.getYearTable3621().get(i).getInput3621y(),font5));
				cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3621criteria3.addCell(cell112);

			}
			for (int i = 0; i < criteria3Record.getYearTable3621().size(); i++) {
				Cell cell112=new Cell(new Paragraph(criteria3Record.getYearTable3621().get(i).getInput3621v(),font5));
				cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3621criteria3.addCell(cell112);
				

			}

			document.add(table3621criteria3);
		}
		
		PdfPTable table19criteria3 = new PdfPTable(2);
		table19criteria3.setWidthPercentage(100f);
		
		
		
	

		PdfPCell cell191criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell191criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		
		PdfPCell cell192criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell192criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell193criteria3 = new PdfPCell(
				new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n", font5));
		cell193criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell194criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "", font5));
		cell194criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell194criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell195criteria3 = new PdfPCell(new Paragraph("\r\ne-copy of the award letters\r\n\r\n", font5));
		cell195criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell196criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "", font5));
		cell196criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell196criteria3.setExtraParagraphSpace(10f);
		
		PdfPCell cell197criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n", font5));
		cell197criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell198criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "", font5));
		cell198criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell198criteria3.setExtraParagraphSpace(10f);
		
		table19criteria3.addCell(cell191criteria3);
		table19criteria3.addCell(cell192criteria3);
		table19criteria3.addCell(cell193criteria3);
		table19criteria3.addCell(cell194criteria3);
		table19criteria3.addCell(cell195criteria3);
		table19criteria3.addCell(cell196criteria3);
		table19criteria3.addCell(cell197criteria3);
		table19criteria3.addCell(cell198criteria3);

//		table191criteria3.addCell(table19criteria3);
		
		
		table19criteria3.setSpacingBefore(20f);
		table19criteria3.setSpacingAfter(20f);
		document.add(table19criteria3);

		
		
		
		PdfPTable table191criteria3 = new PdfPTable(1);

		
		table191criteria3.setWidthPercentage(100f);
		
		
		PdfPCell cell198criteria03 = new PdfPCell(new Paragraph (
				"3.6.3 Number of extension and outreach programs conducted by the institution through NSS/NCC,\r\n"
				+ "Government and Government recognised bodies during the last five years\r\n"
			 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria36Qn().get(0).getResponse363()
								: ""),font4));
		cell198criteria03.setExtraParagraphSpace(10f);
		
		
		table191criteria3.addCell(cell198criteria03);

		PdfPCell cell198criteria013 = new PdfPCell(new Paragraph (
				"3.6.3.1 Number of extension and outreach programs conducted by the institution through NSS/NCC, Government and Government recognised bodies during the last five years"
						+ "\r\n\r\n",font4));
		
		
		table191criteria3.addCell(cell198criteria013);
		
	//	document.add(table191criteria3);
		
		
				
				if (criteria3Record.getYearTable3631() .size() >0 ) {
					Table table3631criteria3 = new Table(criteria3Record.getYearTable3631().size(), 2);

					table3631criteria3.setPadding(5);
					table3631criteria3.setWidth(100f);

					for (int i = 0; i < criteria3Record.getYearTable3631().size(); i++) {
						Cell cell00000112=new Cell(new Paragraph((criteria3Record.getYearTable3631().get(i).getInput3631y()),font5));
						cell00000112.setHorizontalAlignment(Element.ALIGN_CENTER);
						table3631criteria3.addCell(cell00000112);

					}
					for (int i = 0; i < criteria3Record.getYearTable3631().size(); i++) {
						Cell cell00000112=new Cell(new Paragraph(criteria3Record.getYearTable3631().get(i).getInput3631v(),font5));
						cell00000112.setHorizontalAlignment(Element.ALIGN_CENTER);
						table3631criteria3.addCell(cell00000112);

					}

			//		document.add(table3631criteria3);
				}
				
				

		PdfPTable table21criteria3 = new PdfPTable(2);
	
		
		table21criteria3.setWidthPercentage(100f);
	

		PdfPCell cell211criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		
		cell211criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell212criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));

		cell212criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell213criteria3 = new PdfPCell(new Paragraph("\r\nReports of the event\r\n\r\n",font5));
		cell213criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell214criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : "",font5));
		cell214criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell214criteria3.setExtraParagraphSpace(5f);
		
		PdfPCell cell215criteria3 = new PdfPCell(new Paragraph(
				"\r\nInstitutional data in prescribed format\r\n\r\n",font5));
		cell215criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell216criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : "",font5));
		cell216criteria3.setExtraParagraphSpace(5f);
		cell216criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell217criteria3 = new PdfPCell(new Paragraph(
				"\r\nAverage percentage of students participating in extension activities with Govt or NGO etc\r\n\r\n",font5));
		cell217criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell218criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(9).getCriteria3FilePath() : "",font5));
		cell218criteria3.setExtraParagraphSpace(5f);
		cell218criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table21criteria3.addCell(cell211criteria3);
		table21criteria3.addCell(cell212criteria3);
		table21criteria3.addCell(cell213criteria3);
		table21criteria3.addCell(cell214criteria3);
		table21criteria3.addCell(cell215criteria3);
		table21criteria3.addCell(cell216criteria3);
		table21criteria3.addCell(cell217criteria3);
		table21criteria3.addCell(cell218criteria3);
		
		table21criteria3.setSpacingBefore(20F);
		table21criteria3.setSpacingAfter(20F);
		
//		document.add(table21criteria3);
		
		
		
		PdfPTable table211criteria3 = new PdfPTable(1);
		table211criteria3.setWidthPercentage(100f);
		
		
		PdfPCell cell0218criteria03 = new PdfPCell( new Paragraph (
				"3.6.4 Average percentage of students participating in extension activities listed at 3.6.3 above during the last five years\r\n"
					 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria36Qn().get(0).getResponse364()
								: ""),font4));
		
		cell0218criteria03.setExtraParagraphSpace(10f);
		
//		table211criteria3.addCell(cell0218criteria03);
		

		PdfPCell cell10218criteria03 = new PdfPCell(new Paragraph (
				"3.6.4.1 Total number of students participating in extension activities listed at 3.6.3 above year-wise during the last five years."
						+ "\r\n\r\n",font4));
				
	//	table211criteria3.addCell(cell10218criteria03);			
		
		
		
table211criteria3.setSpacingBefore(20f);
table211criteria3.setSpacingAfter(20f);
//document.add(table211criteria3);					
					
		if (criteria3Record.getYearTable3641().size() >0 ) {
			Table table3641criteria3 = new Table(criteria3Record.getYearTable3641().size(), 2);

			table3641criteria3.setPadding(5);
			table3641criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
				Cell cell0000012=new Cell(new Paragraph((criteria3Record.getYearTable3641().get(i).getInput3641y()),font5));
				cell0000012.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3641criteria3.addCell(cell0000012);

			}
			for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
				Cell cell0000012=new Cell(new Paragraph(criteria3Record.getYearTable3641().get(i).getInput3641v(),font5));
				cell0000012.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3641criteria3.addCell(cell0000012);
			}

//			document.add(table3641criteria3);
		}
	//	table211criteria3.addCell(table21criteria3);
		

		
//3.7 
		Paragraph paragraph8criteria3 = new Paragraph("3.7	Collaboration\r\n\r\n", font2);
		paragraph8criteria3.setSpacingBefore(2f);
		paragraph8criteria3.setSpacingAfter(2f);
		
		
		paragraph8criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph8criteria3);
		// create table 22 //
		
		
		
		PdfPTable table211criteria003 = new PdfPTable(1);
		table211criteria003.setWidthPercentage(100f);

		PdfPCell cell10218criteria0003 = new PdfPCell(new Paragraph(
				"3.7.1 Number of functional MoUs /linkage with institutions/ industries in \r\n"
				+ "India and abroad for internship, on-the-job training, project work, \r\n"
				+ "student / faculty exchange and collaborative research during the last \r\n"
				+ "five years\r\n"
				+ ""
						 + "Response: \r\n"
						+ (criteria3Record != null
								? criteria3Record.getCriteria37Qn().get(0).getResponse371()
								: ""),font4));
		
		cell10218criteria0003.setExtraParagraphSpace(5f);
		table211criteria003.addCell(cell10218criteria0003);

		PdfPCell cell10218criteria003 = new PdfPCell(new Paragraph(
				"3.7.1.1: Number of functional MoUs with institutions/ industries in India \r\n"
				+ "and abroad for internship, on-the-job training, project work, student / faculty \r\n"
				+ "exchange and collaborative research during the last five years",font4));
		
		cell10218criteria003.setExtraParagraphSpace(5f);
		
		table211criteria003.addCell(cell10218criteria003);
		
		
		document.add(table211criteria003);
		
		

		if (criteria3Record.getYearTable3711().size() >0 ) {
			Table table3711criteria3 = new Table(criteria3Record.getYearTable3711().size(), 2);

			table3711criteria3.setPadding(5);
			table3711criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3711().size(); i++) {
				Cell cell0000012=new Cell(new Paragraph((criteria3Record.getYearTable3711().get(i).getInput3711y()),font5));
				cell0000012.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3711criteria3.addCell(cell0000012);

			}
			for (int i = 0; i < criteria3Record.getYearTable3711().size(); i++) {
				Cell cell0000013=new Cell(new Paragraph((criteria3Record.getYearTable3711().get(i).getInput3711v()),font5));
				cell0000013.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3711criteria3.addCell(cell0000013);

			}

		//	document.add(table3711criteria3);
			
		}
		
		
		PdfPTable table22criteria3 = new PdfPTable(2);

		table22criteria3.setWidthPercentage(100f);
		


		PdfPCell cell221criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell221criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell222criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell222criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell223criteria3 = new PdfPCell(
				new Paragraph("Copies of collaboration\r\n", font5));
		
		cell223criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell223criteria3.setExtraParagraphSpace(5f);
		
		
		PdfPCell cell224criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "", font5));
		
		cell224criteria3.setExtraParagraphSpace(5f);
		
		cell224criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell225criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n", font5));
		cell225criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell226criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ""));
		cell226criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell226criteria3.setExtraParagraphSpace(5f);
		
		
		PdfPCell cell225criteria31 = new PdfPCell(new Paragraph("Number of Collaborative activities for research, faculty etc\r\n\r\n", font5));
		cell225criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell225criteria31.setExtraParagraphSpace(5f);
		
		
		PdfPCell cell226criteria31 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : ", font5"));
		cell226criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell226criteria31.setExtraParagraphSpace(5f);
		
		
		table22criteria3.addCell(cell221criteria3);
		table22criteria3.addCell(cell222criteria3);
		table22criteria3.addCell(cell223criteria3);
		table22criteria3.addCell(cell224criteria3);
		table22criteria3.addCell(cell225criteria3);
		table22criteria3.addCell(cell226criteria3);
		table22criteria3.addCell(cell225criteria31);
		table22criteria3.addCell(cell226criteria31);
	
		table22criteria3.setSpacingBefore(20f);
		table22criteria3.setSpacingAfter(20f);
		document.add(table22criteria3);
		
		
		
		
		PdfPTable table221criteria3 = new PdfPTable(1);
		table221criteria3.setWidthPercentage(100f);


		// create table 23 //
		
		PdfPCell cell225criteria3001 = new PdfPCell(new Paragraph(
				"3.7.2 Number of functional MoUs with institutions of national, international importance, other institutions, industries, corporate houses etc. during the last five years (only functional MoUs with ongoing activities to be considered)\r\n"
					 + "Response:"
						+ (criteria3Record != null
								? criteria3Record.getCriteria37Qn().get(0).getResponse372()
								: ""),font4));
		cell225criteria3001.setExtraParagraphSpace(5f);
	//	table221criteria3.addCell(cell225criteria3001);
		
		
		PdfPCell cell225criteria301 = new PdfPCell(new Paragraph(
				"3.7.2.1 Number of functional MoUs with institutions of national, international importance, other Institutions, industries, corporate houses etc. year wise during last five years"
						+ "\r\n",font4));
		cell225criteria301.setExtraParagraphSpace(5f);


	//	table221criteria3.addCell(cell225criteria301);
		
		
		if (criteria3Record.getYearTable3721().size() >0 ) {
			Table table3721criteria3 = new Table(criteria3Record.getYearTable3721().size(), 2);

			table3721criteria3.setPadding(5);
			table3721criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getYearTable3721().size(); i++) {
				Cell cell000001=new Cell(new Paragraph((criteria3Record.getYearTable3721().get(i).getInput3721y()),font5));
				cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3721criteria3.addCell(cell000001);
				

			}
			for (int i = 0; i < criteria3Record.getYearTable3721().size(); i++) {
				Cell cell000002=new Cell(new Paragraph((criteria3Record.getYearTable3721().get(i).getInput3721v()),font5));
				cell000002.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3721criteria3.addCell(cell000002);
			}

	//		document.add(table3721criteria3);
			
		}
		
		
		
		PdfPTable table23criteria3 = new PdfPTable(2);
	

		table23criteria3.setWidthPercentage(100f);


		PdfPCell cell231criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell231criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell232criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		
		cell232criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell233criteria3 = new PdfPCell(
				new Paragraph("\r\ne-copies of the MoUs with institution/ industry/ corporate house\r\n\r\n", font5));
		cell233criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell233criteria3.setExtraParagraphSpace(5f);
		
		
		PdfPCell cell234criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "", font5));
		cell234criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell234criteria3.setExtraParagraphSpace(5f);
		
		
		PdfPCell cell235criteria3 = new PdfPCell(new Paragraph(
				"Details of functional MoUs with institutions of national, international importance, other Institutions etc during the last five years\r\n\r\n", font5));
		cell235criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell235criteria3.setExtraParagraphSpace(5f);
		
		
		PdfPCell cell236criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "", font5));
		cell236criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell236criteria3.setExtraParagraphSpace(5f);
		
		
		
		PdfPCell cell237criteria3 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n", font5));
		cell237criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell237criteria3.setExtraParagraphSpace(5f);
		
		PdfPCell cell238criteria3 = new PdfPCell(
				new Paragraph(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "", font5));
		cell238criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell238criteria3.setExtraParagraphSpace(5f);
		
		
		table23criteria3.addCell(cell231criteria3);
		table23criteria3.addCell(cell232criteria3);
		table23criteria3.addCell(cell233criteria3);
		table23criteria3.addCell(cell234criteria3);
		table23criteria3.addCell(cell235criteria3);
		table23criteria3.addCell(cell236criteria3);
		table23criteria3.addCell(cell237criteria3);
		table23criteria3.addCell(cell238criteria3);
	
		table23criteria3.setSpacingBefore(20f);
		table23criteria3.setSpacingAfter(20f);
//		document.add(table23criteria3);
	
	

}

////////////////////////////////////////////////////////////////4.1/////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	//////////////////////////////////////// 4.1///////////

	public void Criteria4(Document document, Criteria4_FieldInfo criteria4Fieldinfo) {
		// 4.1
		
		Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources", font2);
		paragraph1criteria4.setSpacingBefore(2F);
		paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph1criteria4);
		
		Paragraph paragraph1criteria40000 = new Paragraph("__________________________________________________________________________");
		paragraph1criteria40000.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph1criteria40000);

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
				"4.1.1 The institution has adequate infrastructure facilities for \r\n"
				+ "a. teaching - learning. viz., classrooms, laboratories, \r\n"
				+ "b. ICT enabled facilities such as smart classes, LMS etc.\r\n"
				+ "c. Facilities for cultural and sports activities , yoga centre, games \r\n"
				+ "(indoor and outdoor) gymnasium, auditorium etc..\r\n"
				+ "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria41Ql().get(0).getResponse411()
								: ""),
				font4));
		
		cell0criteria4.setExtraParagraphSpace(10f);

		table01criteria4.addCell(cell0criteria4);

	

		table01criteria4.setSpacingBefore(20f);
		table01criteria4.setSpacingAfter(20f);

		document.add(table01criteria4);


		
		PdfPTable table2 = new PdfPTable(2);
		table2.setWidthPercentage(100);

		PdfPCell cell001criteria4 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font4));
		cell001criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table2.addCell(cell001criteria4);
		PdfPCell cell002criteria4 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell002criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table2.addCell(cell002criteria4);
		PdfPCell cell003criteria4 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n ",font5));
		cell003criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table2.addCell(cell003criteria4);
		PdfPCell cell004criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell004criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell004criteria4.setExtraParagraphSpace(10f);
		
		table2.addCell(cell004criteria4);

		PdfPCell cell005criteria4 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n",font5));
		cell005criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table2.addCell(cell005criteria4);
		PdfPCell cell006criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell006criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell006criteria4.setExtraParagraphSpace(10f);
		
		table2.addCell(cell006criteria4);
		

		table2.setSpacingBefore(20f);
		table2.setSpacingAfter(20f);

		document.add(table2);


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
		
		
		PdfPCell cell0009 = new PdfPCell(new Paragraph(" Upload Any additional information\r\n\r\n",font5));
		cell0009.setHorizontalAlignment(Element.ALIGN_CENTER);
	
		table4criteria4.addCell(cell0009);

		PdfPCell cell0010 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0010.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0010.setExtraParagraphSpace(10f);
		table4criteria4.addCell(cell0010);

		PdfPCell cell0011 = new PdfPCell(new Paragraph("Geotagged pictures\r\n\r\n",font5));
		cell0011.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table4criteria4.addCell(cell0011);
		PdfPCell cell0012 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0012.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0012.setExtraParagraphSpace(10f);
		table4criteria4.addCell(cell0012);
	
		PdfPCell cell0013 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n",font5));
		cell0013.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table4criteria4.addCell(cell0013);
		PdfPCell cell0014 = new PdfPCell(new Paragraph("",font5));
		cell0014.setHorizontalAlignment(Element.ALIGN_CENTER);

		table4criteria4.addCell(cell0014);

		PdfPCell cell412criteria4 = new PdfPCell(new Paragraph(
				"4.1.2 Percentage of expenditure excluding salary, for infrastructure \r\n"
				+ "development and augmentation during the last five years (INR in \r\n"
				+ "Lakhs)\r\n"
				+ "\r\n"
					 + "Response:"
						+ (criteria4Record != null
						? criteria4Record.getCriteria41Ql().get(0).getResponse412()
								: ""),
				font4));
		
		cell412criteria4.setExtraParagraphSpace(10f);

		table412criteria4.addCell(cell412criteria4);
		
		
		
		PdfPCell cell412criteria0004 = new PdfPCell(new Paragraph(
				"4.1.2.1: Expenditure for infrastructure development and augmentation \r\n"
				+ "excluding salary, during the last five years (INR in lakhs)\r\n"
				+ "\r\n"
					 + "Response:"
						+ (criteria4Record != null
						? criteria4Record.getCriteria41Ql().get(0).getInput412t1()
								: ""),
				font4));
		
		cell412criteria0004.setExtraParagraphSpace(10f);

		table412criteria4.addCell(cell412criteria0004);	
		
		
		
		
		
		
		
		document.add(table412criteria4);
		
		
		
		
		table4criteria4.setSpacingBefore(20F);
		table4criteria4.setSpacingAfter(20F);
		
		document.add(table4criteria4);
		
		// Creating a table of columns
		
		
		PdfPTable table5criteria4 = new PdfPTable(2);
		PdfPTable table51 = new PdfPTable(1);
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

		PdfPCell cell0018 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0018.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0018.setExtraParagraphSpace(10f);
		
		table5criteria4.addCell(cell0018);

		PdfPCell cell0019 = new PdfPCell(new Paragraph("\r\nProvide the link for additional informationt\r\n\r\n\r\n",font5));
		cell0019.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table5criteria4.addCell(cell0019);
	
		PdfPCell cell0020 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0020.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0020.setExtraParagraphSpace(10f);
		table5criteria4.addCell(cell0020);
	
		PdfPCell cell0021 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
		cell0021.setHorizontalAlignment(Element.ALIGN_CENTER);
	
		table5criteria4.addCell(cell0021);
		
		
		
		PdfPCell cell0022 = new PdfPCell(new Paragraph());
		table5criteria4.addCell(cell0022);
	
       
	
		PdfPCell cell4120criteria4 = new PdfPCell(new Paragraph(
				"4.1.3 Availability of general campus facilities and overall ambience\r\n"
				+ "Response:"
						+ (criteria4Record != null
						? criteria4Record.getCriteria41Ql().get(0).getResponse413()
								: ""),font4));
		
		cell4120criteria4.setExtraParagraphSpace(10f);
		
//		table51.addCell(cell4120criteria4);



	
		PdfPCell cell41200criteria4 = new PdfPCell(new Paragraph("4.1.3.1 Number of classrooms and seminar halls with ICT facilities\r\n Response: "
				+ (criteria4Record != null ? criteria4Record.getCriteria41Ql().get(0).getInput413t1() : ""),font4));
		
		cell41200criteria4.setExtraParagraphSpace(10f);
		
	//	table51.addCell(cell41200criteria4);
		



		document.add(table51);
		
		table5criteria4.setSpacingBefore(20f);
		table5criteria4.setSpacingAfter(20f);
		
		document.add(table5criteria4);
		// Creating a table of 3 columns
		

		
		PdfPTable table6criteria4 = new PdfPTable(2);
		
		
		PdfPTable table61criteria4 = new PdfPTable(1);
		table61criteria4.setWidthPercentage(100);
		if(criteria4Record.getCriteria41Ql().size() >0) {
		PdfPCell cell41201criteria4 = new PdfPCell(new Paragraph(
				"4.1.4 Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)\r\n"
						+ "\r\n" + "Response: "
						+ (criteria4Record != null
								? criteria4Record.getCriteria41Ql().get(0).getResponse414()
								: ""),font4));
		
		cell41201criteria4.setExtraParagraphSpace(10f);
		
	//	table61criteria4.addCell(cell41201criteria4);
		}
		
		PdfPCell cell41202criteria4 = new PdfPCell(new Paragraph(
				"4.1.4.1 Expenditure for infrastructure augmentation, excluding salary year-wise during last five years (INR in lakhs)\r\n\r\n",font4));

		
		
		table61criteria4.addCell(cell41202criteria4);
		
//		table61criteria4.addCell(table6criteria4);

	

//		document.add(table61criteria4);
		
		

		if (criteria4Record.getYearTable4141().size() >0) {

			Table table4141 = new Table(criteria4Record.getYearTable4141().size(), 2);

			table4141.setPadding(5);
			table4141.setWidth(100f);

			for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
				Cell cell1=new Cell(new Paragraph(criteria4Record.getYearTable4141().get(i).getInput4141y(),font5));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4141.addCell(cell1);
			}
			for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria4Record.getYearTable4141().get(i).getInput4141v(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4141.addCell(cell2);
			}

		//	document.add(table4141);
		}

		
		

		if (criteria4Record.getYearTable41412().size() >0) {

			Table table41412 = new Table(criteria4Record.getYearTable41412().size(), 2);

			table41412.setPadding(5);
			table41412.setWidth(100f);

			for (int i = 0; i < criteria4Record.getYearTable41412().size(); i++) {
				Cell cell2=new Cell(new Paragraph(criteria4Record.getYearTable41412().get(i).getInput41412y(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table41412.addCell(cell2);
			}
			for (int i = 0; i < criteria4Record.getYearTable41412().size(); i++) {
				Cell cell3=new Cell(new Paragraph(criteria4Record.getYearTable41412().get(i).getInput41412v(),font5));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				table41412.addCell(cell3);
				
				
			}

//		document.add(table41412);
		}
		
////------------------------------------------------------------------->	/	
		// Creating a table of 3 columns
		PdfPTable table7criteria4 = new PdfPTable(2);

		// Setting width of table, its columns and spacing
		table7criteria4.setWidthPercentage(100);

		PdfPCell cell0033 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
		cell0033.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table7criteria4.addCell(cell0033);
	
		PdfPCell cell0034 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell0034.setHorizontalAlignment(Element.ALIGN_CENTER);
		table7criteria4.addCell(cell0034);
		PdfPCell cell0035 = new PdfPCell(
				new Paragraph("Upload any additional information\r\n\r\n ",font5));
		cell0035.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table7criteria4.addCell(cell0035);
	
	
		PdfPCell cell0036 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(4).getCriteria4FilePath() : "",font5));
		cell0036.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table7criteria4.addCell(cell0036);

		PdfPCell cell0037 = new PdfPCell(new Paragraph("Upload audited utilization statements\r\n\r\n",font5));
		cell0037.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table7criteria4.addCell(cell0037);

		PdfPCell cell0038 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(5).getCriteria4FilePath() : "",font5));
		cell0038.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0038.setExtraParagraphSpace(10f);
		
		table7criteria4.addCell(cell0038);
		
		PdfPCell cell0039 = new PdfPCell(new Paragraph("Upload Details of Expenditure, excluding salary during the last five years\r\n\r\n",font5));
	
		cell0039.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table7criteria4.addCell(cell0039);

		PdfPCell cell0040 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0040.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0040.setExtraParagraphSpace(10f);
		table7criteria4.addCell(cell0040);

		
		

		table7criteria4.setSpacingBefore(20f);
		table7criteria4.setSpacingAfter(20f);

//		document.add(table7criteria4);
        
		// 4.2 
		Paragraph paragraph31criteria4 = new Paragraph("4.2 Library as a Learning Resource\r\n", font2);
		paragraph31criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		paragraph31criteria4.setSpacingAfter(6F);
		paragraph31criteria4.setSpacingBefore(10F);
		document.add(paragraph31criteria4);
		

		PdfPTable table421criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table421criteria4.setWidthPercentage(100);

		PdfPCell cell00400 = new PdfPCell(new Paragraph(
				"4.2.1 Library is automated with digital facilities using Integrated Library \r\n"
				+ "Management System (ILMS), adequate subscription to e-resources \r\n"
				+ "and journals are made. The library is optimally used by the faculty \r\n"
				+ "and students"
				+ "Response:"
				+(criteria4Record != null
								? criteria4Record.getCriteria42Ql().get(0).getResponse421()
								: ""),font4));
		cell00400.setExtraParagraphSpace(10f);
		
		table421criteria4.addCell(cell00400);
		
		
		// table421criteria4.addCell(criteria4List.get(3).getResponseValue421());
		
		document.add(table421criteria4);

		

		
		


	

		// Creating a table of 3 columns
		PdfPTable table8criteria4 = new PdfPTable(2);

		// Setting width of table, its columns and spacing
		table8criteria4.setWidthPercentage(100);
		


		PdfPCell cell0041 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n", font4));
		cell0041.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table8criteria4.addCell(cell0041);
		PdfPCell cell0042 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n\r\n", font4));
		cell0042.setHorizontalAlignment(Element.ALIGN_CENTER);
		table8criteria4.addCell(cell0042);
		PdfPCell cell0043 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n\r\n",font5));
		
		cell0043.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table8criteria4.addCell(cell0043);
		if(criteria4file.size() >0) {
		PdfPCell cell0044 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell0044.setExtraParagraphSpace(10f);
		
		cell0044.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table8criteria4.addCell(cell0044);
	}
		PdfPCell cell0045 = new PdfPCell(new Paragraph("\r\nPaste Link for additional information\r\n\r\n\r\n ",font5));
		cell0045.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell0046 = new PdfPCell(new Paragraph(" "));
		cell0046.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		
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

		PdfPCell cell0047 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
		cell0047.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table9criteria4.addCell(cell0047);
		
		
		PdfPCell cell0048 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell0048.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table9criteria4.addCell(cell0048);
		PdfPCell cell0049 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n",font5));
		cell0049.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table9criteria4.addCell(cell0049);
		if(criteria4file.size() >0) {
		PdfPCell cell0050 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : "",font5));
		cell0050.setExtraParagraphSpace(10f);
		
		cell0050.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table9criteria4.addCell(cell0050);
		}
		PdfPCell cell0051 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n",font5));
		cell0051.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria4.addCell(cell0051);
		
		if(criteria4file.size()>0)
		{
		PdfPCell cell0052 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : "",font5));
		cell0052.setExtraParagraphSpace(10);
		cell0052.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0052.setExtraParagraphSpace(10);
		table9criteria4.addCell(cell0052);
		}

		
		PdfPCell cell00510 = new PdfPCell(new Paragraph(
				"4.2.2 Percentage expenditure for purchase of books/ e-books and \r\n"
				+ "subscription to journals/e-journals during the last five years (INR in \r\n"
				+ "Lakhs)\r\n"
					 + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria42Qn().get(0).getResponse422()
								: ""),font4));
		cell00510.setExtraParagraphSpace(10f);
		
		table10criteria4.addCell(cell00510);
		
		
		
		PdfPCell cell00511110 = new PdfPCell(new Paragraph(
				"4.2.2.1: Annual expenditure for purchase of books and journals yearwise during the last five years (INR in lakhs)",font4));
		cell00511110.setExtraParagraphSpace(10f);
		
		table10criteria4.addCell(cell00511110);
		
		
//		table10criteria4.addCell(table9criteria4);
		
		
		table9criteria4.setSpacingBefore(20f);
		table9criteria4.setSpacingAfter(20f);
		
		document.add(table9criteria4);
	

		document.add(table10criteria4);
		
		
		
		
		if (criteria4Record != null) {

			Table table4231 = new Table(criteria4Record.getYearTable4231().size(), 2);

			table4231.setPadding(5);
			table4231.setWidth(100f);

			for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
				Cell cell4=new Cell(new Paragraph((criteria4Record.getYearTable4231().get(i).getInput4231y()),font5));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4231.addCell(cell4);
			}
			for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
				Cell cell5=new Cell(new Paragraph((criteria4Record.getYearTable4231().get(i).getInput4231v()),font5));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4231.addCell(cell5);
			}

			document.add(table4231);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		// Creating a table of 3 columns
		PdfPTable table11criteria4 = new PdfPTable(2);
		PdfPTable table12criteria4 = new PdfPTable(1);

		table11criteria4.setWidthPercentage(100);
		table12criteria4.setWidthPercentage(100);
		PdfPCell cell0065 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		
		cell0065.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table11criteria4.addCell(cell0065);
		PdfPCell cell0066 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell0066.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11criteria4.addCell(cell0066);
		PdfPCell cell0067 = new PdfPCell(new Paragraph(
				"Institutional data in prescribed format\r\n\r\n",font5));
		cell0067.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table11criteria4.addCell(cell0067);
		if(criteria4file.size() >0)
		{
		PdfPCell cell0068 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
		cell0068.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0068.setExtraParagraphSpace(2f);
		table11criteria4.addCell(cell0068);
		}
		PdfPCell cell0069 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n",font5));
		cell0069.setHorizontalAlignment(Element.ALIGN_CENTER);
		

		
		table11criteria4.addCell(cell0069);
		if(criteria4file.size() >0)
		{
		PdfPCell cell0070 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
		
		
		cell0070.setExtraParagraphSpace(10f);
		cell0070.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11criteria4.addCell(cell0070);
	
		
		}
		
	
if(criteria4Record.getCriteria42Qn().size() >0)
{
		PdfPCell cell005101 = new PdfPCell(new Paragraph(
				"4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n"
					 + "Response: "
						+ (criteria4Record != null
								? criteria4Record.getCriteria42Qn().get(0).getResponse423()
								: ""),font4));
		cell005101.setExtraParagraphSpace(10f);
		
		table12criteria4.addCell(cell005101);
}
		
		PdfPCell cell0051011 = new PdfPCell(new Paragraph(
				"4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)"
						+ "\r\n"
						+ "\r\n"
						,font4));
		
		
		table12criteria4.addCell(cell0051011);
		
		
		
//		table12criteria4.addCell(table11criteria4);
		
	
		

		table11criteria4.setSpacingBefore(20f);
		table11criteria4.setSpacingAfter(20f);
		
		
		document.add(table11criteria4);

//		document.add(table12criteria4);
		
		
		



		// Creating a table of 3 columns

		PdfPTable table13 = new PdfPTable(2);

		// Setting width of table, its columns and spacing
		table13.setWidthPercentage(100);

	

		table13.setSpacingBefore(20f);
		table13.setSpacingAfter(20f);

	//	document.add(table13);

		// Creating a table of 3 columns
		PdfPTable table14criteria4 = new PdfPTable(2);
		PdfPTable table15 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table14criteria4.setWidthPercentage(100);
		table15.setWidthPercentage(100);

		PdfPCell cell0075 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell0075.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table14criteria4.addCell(cell0075);
		PdfPCell cell0076 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell0076.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table14criteria4.addCell(cell0076);
		PdfPCell cell0077 = new PdfPCell(new Paragraph("Details of library usage by teachers and students\r\n\r\n", font5));
		cell0077.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table14criteria4.addCell(cell0077);
		if(criteria4file .size()>0) {
		PdfPCell cell0078 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "", font5));
		cell0078.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0078.setExtraParagraphSpace(10f);
		
		table14criteria4.addCell(cell0078);
		}
		PdfPCell cell0079 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n", font5));
		cell0079.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table14criteria4.addCell(cell0079);
		if(criteria4file.size()>0) {
		PdfPCell cell0080 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "", font5));
		cell0080.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0080.setExtraParagraphSpace(10f);
		table14criteria4.addCell(cell0080);
		}
		PdfPCell cell00770 = new PdfPCell(new Paragraph(
				"4.2.4 Percentage per day usage of library by teachers and students ( foot falls and login data for online access) during the latest completed academic year\r\n"
				 + "Response: "
						+ (criteria4Record != null
								? criteria4Record.getCriteria42Qn().get(0).getResponse424()
								: ""), font4));
		
		cell00770.setExtraParagraphSpace(10f);
		cell00770.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	//	table15.addCell(cell00770);


		PdfPCell cell007701 = new PdfPCell(new Paragraph(("4.2.4.1 Number of teachers and students using library per day over last one year\r\n" 
				+ "Response: "
				+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getInput4241t1() : "")),font4));
		cell007701.setExtraParagraphSpace(10f);
		table15.addCell(cell007701);
	//	table15.addCell(table14criteria4);
		


		table14criteria4.setSpacingBefore(20f);
		table14criteria4.setSpacingAfter(20f);
		
	//	document.add(table14criteria4);

//		document.add(table15);
		
		
		// 4.3 
		
		Paragraph paragraph38criteria4 = new Paragraph("4.3 IT Infrastructure\r\n\r\n", font2);
		paragraph38criteria4.setSpacingAfter(2f);
		paragraph38criteria4.setSpacingBefore(2f);
		
		paragraph38criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		/*
		 * Font fontParagraph35 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph35.setSize(12);
		 */

		Paragraph paragraph39criteria4 = new Paragraph(
				"4.3.1	Institution frequently updates its IT facilities and provides sufficient \r\n"
				+ "bandwidth for internet connection"
				+ (criteria4Record != null
				? criteria4Record.getCriteria43Ql().get(0).getResponse431()
				: "")		,font4);
		paragraph39criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		


		document.add(paragraph38criteria4);
		document.add(paragraph39criteria4);
		
		// Creating a table of 3 columns

		
		PdfPTable table17criteria4 = new PdfPTable(2);
		PdfPTable table16criteria4 = new PdfPTable(1);
		table17criteria4.setWidthPercentage(100);
		table16criteria4.setWidthPercentage(100);
		// Setting width of table, its columns and spacing
		
	

		PdfPCell cell0091 = new PdfPCell(new Paragraph("File Description\r\n", font4));
		cell0091.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table17criteria4.addCell(cell0091);
		
		PdfPCell cell0092 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell0092.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table17criteria4.addCell(cell0092);
	
		
		PdfPCell cell0093 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n",font5));
		cell0093.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table17criteria4.addCell(cell0093);
	
		PdfPCell cell0094 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
		cell0094.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell0094.setExtraParagraphSpace(10f);
		
		
		table17criteria4.addCell(cell0094);
	
		PdfPCell cell0095 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n",font5));
		cell0095.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell0096 = new PdfPCell(new Paragraph(" ",font5));
		cell0096.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		
		table17criteria4.addCell(cell0095);
		table17criteria4.addCell(cell0096);
		
		
		table17criteria4.setSpacingAfter(20f);
		table17criteria4.setSpacingBefore(20f);
		
		
		document.add(table17criteria4);

		PdfPCell cell431criteria4 = new PdfPCell(new Paragraph(
				"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n"
					 + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria43Ql().get(0).getResponse431()
								: ""),font4));
		cell431criteria4.setExtraParagraphSpace(10f);
		
		PdfPCell cell4311criteria4 = new PdfPCell(new Paragraph(
				"4.3.1.1 Number of classrooms and seminar halls with ICT facilities\r\n"
				+ "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria43Ql().get(0).getInput431t1()
								: ""),font4));
		cell4311criteria4.setExtraParagraphSpace(10f);
	//	table16criteria4.addCell(cell431criteria4);
	//	table16criteria4.addCell(cell4311criteria4);
		
		
	//	table16criteria4.addCell(table17criteria4);
		

		
		document.add(table16criteria4);
		
		
		

		// Creating a table of 3 columns
		PdfPTable table18criteria4 = new PdfPTable(2);
		PdfPTable table19criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table18criteria4.setWidthPercentage(100);
		table19criteria4.setWidthPercentage(100);

		PdfPCell cell0097 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell0097.setHorizontalAlignment(Element.ALIGN_CENTER);
		table18criteria4.addCell(cell0097);
		PdfPCell cell0098 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell0098.setHorizontalAlignment(Element.ALIGN_CENTER);
		table18criteria4.addCell(cell0098);
		PdfPCell cell0099 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n",font5));
		cell0099.setHorizontalAlignment(Element.ALIGN_CENTER);
		table18criteria4.addCell(cell0099);
	
		PdfPCell cell00100 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
		cell00100.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell00100.setExtraParagraphSpace(10f);
		
		table18criteria4.addCell(cell00100);
		

		PdfPCell cell00991 = new PdfPCell(new Paragraph("4.3.2 Student - Computer ratio (Data to be provided only for the latest \r\n"
				+ "completed academic year)\r\n"+ "Response:"
				+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse432()
						: ""),font4));
		cell00991.setExtraParagraphSpace(10f);

		table19criteria4.addCell(cell00991);
		
		
		
		PdfPCell cell009911 = new PdfPCell(new Paragraph("4.3.2.1  Number of computers available for student use)\r\n"+ "Response:"
				+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getInput432t1()
						: ""),font4));
		cell009911.setExtraParagraphSpace(10f);

		table19criteria4.addCell(cell00991);		
		
		
		
		
		
		
		
		
		
		
		
	//	table19criteria4.addCell(table18criteria4);

		table18criteria4.setSpacingBefore(20f);
		table18criteria4.setSpacingAfter(20f);

		document.add(table18criteria4);
		
		document.add(table19criteria4);

		// Creating a table of 3 columns

		PdfPTable table20criteria4 = new PdfPTable(2);
		PdfPTable table21criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table20criteria4.setWidthPercentage(100);
		table21criteria4.setWidthPercentage(100);

		PdfPCell cell00103 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell00103.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table20criteria4.addCell(cell00103);
		PdfPCell cell00104 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell00104.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table20criteria4.addCell(cell00104);
		
		
		PdfPCell cell00105 = new PdfPCell(new Paragraph("Upload any additional information	",font5));
		cell00105.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table20criteria4.addCell(cell00105);
		
		PdfPCell cell00106 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
		cell00106.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell00106.setExtraParagraphSpace(10f);
		
		table20criteria4.addCell(cell00106);
         
         PdfPCell cell0106 = new PdfPCell(new Paragraph("Student - computer ratio",font5));
         cell0106.setHorizontalAlignment(Element.ALIGN_CENTER);
         
         
         table20criteria4.addCell(cell0106);
         
         PdfPCell cell01106 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
         cell01106.setHorizontalAlignment(Element.ALIGN_CENTER);
         cell01106.setExtraParagraphSpace(10f);
         
         table20criteria4.addCell(cell01106);


		PdfPCell cell001040 = new PdfPCell(new Paragraph("4.3.3Institution has the following Facilities for e-content and other \r\n"
				+ "resource development"
				+ "1. Audio visual center, mixing equipment, editing facilities and \r\n"
				+ "Media Studio\r\n"
				+ "2. Lecture Capturing System(LCS)\r\n"
				+ "3. Central Instrumentation Centre\r\n"
				+ "4. Animal House\r\n"
				+ "5. Museum\r\n"
				+ "6. Business Lab\r\n"
				+ "7. Research/statistical database\r\n"
				+ "8. Moot court\r\n"
				+ "9. Theatre\r\n"
				+ "10. Art Gallery\r\n"
				+ "11. Any other facility to support research\r\n"
				+ "Options:\r\n"
				+ "A. Any 7 or more of the above\r\n"
				+ "B. Any 6 of the above\r\n"
				+ "C. Any 5 of the above\r\n"
				+ "D. Any 3-4 of the above\r\n"
				+ "E. Any 2 or below\r\n" + "Response:"
				+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse433()
						: ""),font4));
		
		cell001040.setExtraParagraphSpace(10f);

		cell001040.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);

		table21criteria4.addCell(cell001040);
		
	//	table21criteria4.addCell(table20criteria4);
		
		table20criteria4.setSpacingAfter(20f);
		table20criteria4.setSpacingBefore(20f);
		
		
		document.add(table20criteria4);
		
		
		document.add(table21criteria4);
		
		
		PdfPTable table434criteria4 = new PdfPTable(2);
		PdfPTable table4341criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table434criteria4.setWidthPercentage(100);
		table4341criteria4.setWidthPercentage(100);

		PdfPCell cell001031 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
		cell001031.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table434criteria4.addCell(cell001031);
		PdfPCell cell001042 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell001042.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table434criteria4.addCell(cell001042);
		PdfPCell cell001053 = new PdfPCell(
				new Paragraph("Upload any additional information\r\n\r\n\r\n",font5));
		cell001053.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table434criteria4.addCell(cell001053);
		
		PdfPCell cell001064 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
		cell001064.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell001064.setExtraParagraphSpace(10f);
		
		
		table434criteria4.addCell(cell001064);

		PdfPCell cell0010531 = new PdfPCell(
				new Paragraph("Details of available bandwidth of internet connection in the Institution\r\n\r\n\r\n",font5));
	
		cell0010531.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		table434criteria4.addCell(cell0010531);
		
		PdfPCell cell0010641 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));

		cell0010641.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell0010641.setExtraParagraphSpace(10f);
		
		
		table434criteria4.addCell(cell0010641);
	
		PdfPCell cell0010421 = new PdfPCell(new Paragraph("4.3.4 Available bandwidth of internet connection in the Institution (Leased line)\r\n"
	 + "Response:"
				+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse434()
						: ""),font4));
		cell0010421.setExtraParagraphSpace(10f);
		cell0010421.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		
		
		// table21criteria4.addCell(criteria4List.get(0).getResponseValue433());
		
//		table4341criteria4.addCell(cell0010421);
	//	table4341criteria4.addCell(table434criteria4);
		
		
		document.add(table434criteria4);
		document.add(table4341criteria4);

		// Creating a table of 3 columns

		PdfPTable table22criteria4 = new PdfPTable(2);
		PdfPTable table23criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table22criteria4.setWidthPercentage(100);
		table23criteria4.setWidthPercentage(100);

		PdfPCell cell00107 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
		cell00107.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table22criteria4.addCell(cell00107);
		PdfPCell cell00108 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell00108.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table22criteria4.addCell(cell00108);
		
		
		PdfPCell cell00109 = new PdfPCell(new Paragraph("Upload any additional information	",font5));
		cell00109.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table22criteria4.addCell(cell00109);
	
		PdfPCell cell00110 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
		cell00110.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell00110.setExtraParagraphSpace(10f);
		
		table22criteria4.addCell(cell00110);

		PdfPCell cell00111 = new PdfPCell(new Paragraph("Provide links to the photographs",font5));
		cell00111.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table22criteria4.addCell(cell00111);
	
		PdfPCell cell00112 = new PdfPCell(
				new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
		cell00112.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell00112.setExtraParagraphSpace(10f);
		
		table22criteria4.addCell(cell00112);
	
		PdfPCell cell001111 = new PdfPCell(new Paragraph("Facilities for e-content development such as Media Centre, Recording facility, LCS etc (Data Templates as in 3.4.7)",font5));
		cell001111.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table22criteria4.addCell(cell001111);
		PdfPCell cell00013 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
		cell00013.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell00013.setExtraParagraphSpace(10f);
		
		table22criteria4.addCell(cell00013);
		

		

		PdfPCell cell001110 = new PdfPCell(new Paragraph("4.3.5	Institution has the following Facilities for e-content development\r\n"
				+ "1.	Media centre\r\n" + "2.	Audio visual centre\r\n" + "3.	Lecture Capturing System(LCS)\r\n"
				+ "4.	Mixing equipments and softwares for editing\r\n" + "Response: "
				+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse434()
						: ""),font4));
		
		cell001110.setExtraParagraphSpace(10f);

		// table23criteria4.addCell(criteria4List.get(0).getResponseValue434());
		table23criteria4.addCell(cell001110);
	//	table23criteria4.addCell(table22criteria4);

		table22criteria4.setSpacingBefore(20f);
		table22criteria4.setSpacingAfter(20f);
	//	document.add(table22criteria4);
		
	//	document.add(table23criteria4);

    // 4.4 
		
		
		Paragraph paragraph50 = new Paragraph("4.4 Maintenance of Campus Infrastructure\r\n" + "", font2);
		paragraph50.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph50);

		// Creating a table of 3 columns

		
		PdfPTable table25criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		
		table25criteria4.setWidthPercentage(100);

		PdfPCell cell001091 = new PdfPCell(new Paragraph(
				"4.4.1 Percentage expenditure incurred on maintenance of physical \r\n"
				+ "facilities and academic support facilities excluding salary \r\n"
				+ "component during the last five years \r\n"
						+ " Response: "
						+ (criteria4Record != null
								? criteria4Record.getCriteria44Ql().get(0).getResponse441()
								: ""),font4));
		
		cell001091.setExtraParagraphSpace(10f);
/////////////////////--------------------------------------------------------------------------------------------->
		// table25criteria4.addCell(criteria4List.get(0).getResponseValue441());

		PdfPCell cell0010911 = new PdfPCell(new Paragraph(
				"4.4.1.1 Expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component year wise during the last five years (INR in lakhs)\r\n\r\n",font4));

		table25criteria4.addCell(cell001091);
		table25criteria4.addCell(cell0010911);
		
		table25criteria4.setSpacingBefore(20f);
		table25criteria4.setSpacingAfter(20f);

		document.add(table25criteria4);

		if (criteria4Record != null) {

			Table table4411 = new Table(criteria4Record.getYearTable4411().size(), 2);

			table4411.setPadding(5);
			table4411.setWidth(100f);

			for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
				Cell cell6=new Cell(new Paragraph(criteria4Record.getYearTable4411().get(i).getInput4411y(),font5));
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4411.addCell(cell6);
			}
			for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
				Cell cell7=new Cell(new Paragraph(criteria4Record.getYearTable4411().get(i).getInput4411v(),font5));
				cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4411.addCell(cell7);
			}

			document.add(table4411);

		}
		

		if (criteria4Record != null) {

			Table table44112 = new Table(criteria4Record.getYearTable44112().size(), 2);

			table44112.setPadding(5);
			table44112.setWidth(100f);

			for (int i = 0; i < criteria4Record.getYearTable44112().size(); i++) {
				Cell cell8=new Cell(new Paragraph((criteria4Record.getYearTable44112().get(i).getInput44112y()),font5));
				cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
				table44112.addCell(cell8);
			}
			for (int i = 0; i < criteria4Record.getYearTable44112().size(); i++) {
				Cell cell9=new Cell(new Paragraph((criteria4Record.getYearTable44112().get(i).getInput44112v()),font5));
				cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
				table44112.addCell(cell9);
			}

			document.add(table44112);

		}

		PdfPTable table26criteria4 = new PdfPTable(2);
		table26criteria4.setWidthPercentage(100);

		PdfPCell cell00123 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
		cell00123.setHorizontalAlignment(Element.ALIGN_CENTER);
		table26criteria4.addCell(cell00123);
		PdfPCell cell00124 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell00124.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table26criteria4.addCell(cell00124);
		
		PdfPCell cell00125 = new PdfPCell(new Paragraph("Upload any additional information	",font5));
		cell00125.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		table26criteria4.addCell(cell00125);
		
		
	
		PdfPCell cell00126 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell00126.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell00126.setExtraParagraphSpace(10f);
		table26criteria4.addCell(cell00126);

		PdfPCell cell00127 = new PdfPCell(new Paragraph("Audited statements of accounts",font5));
		cell00127.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		table26criteria4.addCell(cell00127);
	
		PdfPCell cell00128 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell00128.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell00128.setExtraParagraphSpace(10f);
		
		table26criteria4.addCell(cell00128);
	
		PdfPCell cell000127 = new PdfPCell(new Paragraph("Details about assigned budget and expenditure on physical facilities and academic facilities",font5));
		cell000127.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		table26criteria4.addCell(cell000127);
	
		PdfPCell cell000128 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell000128.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell000128.setExtraParagraphSpace(10f);
		
		table26criteria4.addCell(cell000128);
	
		
		
		
		table26criteria4.setSpacingAfter(20f);
		
		table26criteria4.setSpacingBefore(20f);
		
		document.add(table26criteria4);

		/*
		 * Font fontParagraph47 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph47.setSize(12);
		 */
		
		
		
		PdfPTable table26criteria004 = new PdfPTable(1);
		table26criteria004.setWidthPercentage(100);
		

		PdfPCell cell000122228 = new PdfPCell(new Paragraph(
				"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\r\n"
			 + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria44Ql().get(0).getResponse442()
								: ""),
				font4));
		cell000122228.setExtraParagraphSpace(10f);

		table26criteria004.addCell(cell000122228);
		document.add(table26criteria004);
		
		PdfPTable table442criteria4 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table442criteria4.setWidthPercentage(100);

		PdfPCell cell001271 = new PdfPCell(new Paragraph(
				"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\\r\\n\"\r\n"
			 + "Response:"
						+ (criteria4Record != null
								? criteria4Record.getCriteria44Ql().get(0).getResponse442()
								: ""),font4));
		cell001271.setExtraParagraphSpace(10f);
		// table442criteria4.addCell(criteria4List.get(0).getResponseValue442());
		//table442criteria4.addCell(cell001271);

	//	document.add(table442criteria4);

	

		

		PdfPTable table27criteria4 = new PdfPTable(2);
		table27criteria4.setWidthPercentage(100);

		PdfPCell cell00129 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
		cell00129.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table27criteria4.addCell(cell00129);
		PdfPCell cell00130 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell00130.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell00130.setExtraParagraphSpace(10f);
		
		table27criteria4.addCell(cell00130);
		PdfPCell cell00131 = new PdfPCell(new Paragraph("Upload any additional information",font5));
		cell00131.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell00131.setExtraParagraphSpace(10f);
		
		table27criteria4.addCell(cell00131);
		if(criteria4file.size()>0) {
		PdfPCell cell00132 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
		cell00132.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell00132.setExtraParagraphSpace(10f);
		
		table27criteria4.addCell(cell00132);
		}
		PdfPCell cell00133 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n",font5));
		cell00133.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell00134 = new PdfPCell(new Paragraph(" ",font5));
		cell00134.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table27criteria4.addCell(cell00133);
		table27criteria4.addCell(cell00134);

		table27criteria4.setSpacingBefore(20f);
		table27criteria4.setSpacingAfter(20f);

		document.add(table27criteria4);
}
// criteria 5
	
	
	public void Criteria5(Document document, Criteria5_FieldInfo criteria5Fieldinfo) {// 5.1

		Paragraph paragraph0 = new Paragraph("Criterion 5 - Student Support and Progression\r\n", font2);
		paragraph0.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		paragraph0.setSpacingBefore(3f);
		
		document.add(paragraph0);
		
		
		Paragraph paragraph005 = new Paragraph("_________________________________________________________________________");
		paragraph005.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph005);
		
		
		
//		Paragraph paragraph01 = new Paragraph("Criterion 5 - Student Support and Progression\r\n\r\n", font2);
//		paragraph01.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		document.add(paragraph01);
		
		
		
		
		

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
//			table011.setSpacingBefore(20f);
//			table011.setSpacingAfter(20f);

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
		
//		PdfPCell cell00023 = new PdfPCell(new Paragraph(
//				"Number of students benefited by scholarships and freeships besides government schemes in last 5 years\r\n\r\n\r\n"));
//		PdfPCell cell00024 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(8).getCriteria5FilePath() : ""));
		PdfPCell cell00025 = new PdfPCell(new Paragraph("Link for additional information",font5));
		
		cell00025.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell00026 = new PdfPCell(
				new Paragraph((criteria5Record != null ? criteria5file.get(0).getCriteria5FilePath() : ""),font5));
		cell00026.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table03criteria5.addCell(cell00019);
		table03criteria5.addCell(cell00020);
		table03criteria5.addCell(cell00021);
		table03criteria5.addCell(cell00022);
//		table03criteria5.addCell(cell00023);
//		table03criteria5.addCell(cell00024);
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
		
//		Paragraph paragraph4 = new Paragraph(criteria5Fieldinfo != null ? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getInput5212t1()
//								: "");
//		document.add(paragraph4);

		
		
		
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

//		table061.addCell(cell0112);

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

//		table71criteria5.addCell(cell0111);
//		table71criteria5.addCell(cell01121);
//		
		table71criteria5.addCell(table07criteria5);

		table71criteria5.setSpacingBefore(20f);
		table71criteria5.setSpacingAfter(20f);

//		document.add(table71criteria5);

		PdfPTable table08criteria5 = new PdfPTable(2);
//		PdfPTable table81criteria5 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table08criteria5.setWidthPercentage(100);
//		table81criteria5.setWidthPercentage(100);

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
		
		
}

	//////////////////// 6.1///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////
	public void Criteria6(Document document, Criteria6_FieldInfo criteria6Fieldinfo) {
		Paragraph paragraph1criteria6 = new Paragraph("Criterion 6 - Governance, Leadership and Management\r\n",
				font2);
		paragraph1criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
		paragraph1criteria6.setSpacingBefore(2f);
		document.add(paragraph1criteria6);
		
		
		Paragraph paragraph1criteria00006 = new Paragraph("________________________________________________________________\r\n",
				font1);
		paragraph1criteria00006.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph1criteria00006);
		
		
		

		Paragraph paragraph2criteria6 = new Paragraph("6.1	Institutional Vision and Leadership\r\n\r\n", font2);
		paragraph2criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph2criteria6);
		
		
		PdfPTable table1criteria0000006 = new PdfPTable(1);
		table1criteria0000006.setWidthPercentage(100);	
		
		
		
		
		PdfPCell cell1criteria1111116 = new PdfPCell(new Paragraph(
				"6.1.1 The Institutional governance and leadership are in accordance with \r\n"
				+ "Vision and mission of the institution and it is visible in various \r\n"
				+ "institutional practices such as NEP implementation, sustained \r\n"
				+ "institutional growth, de-centralization, participation in the institutional \r\n"
				+ "governance and in their Short term/ Long term institutional perspective \r\n"
				+ "plan. "
						+ (criteria6Record != null
								? criteria6Record.getCriteria61Ql().get(0).getResponse611()
								: ""),
				font4));
		
		cell1criteria1111116.setExtraParagraphSpace(10f);
		
		table1criteria0000006.addCell(cell1criteria1111116);
		
		document.add(table1criteria0000006);


		com.lowagie.text.Font font0Title1 = FontFactory.getFont(FontFactory.HELVETICA);
		font0Title1.setSize(12);

	

		PdfPTable table1criteria6 = new PdfPTable(2);
		table1criteria6.setWidthPercentage(100);
		PdfPCell cell1criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
		cell1criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell2criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell2criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell3criteria6 = new PdfPCell(new Paragraph("Paste link for additional Information",font5));
		cell3criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell4criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell4criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell4criteria6.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell5criteria6 = new PdfPCell(new Paragraph("Upload any additional information",font5));
		cell5criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell6criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell6criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell6criteria6.setExtraParagraphSpace(10f);
		
		
		
		table1criteria6.addCell(cell1criteria6);
		table1criteria6.addCell(cell2criteria6);
		table1criteria6.addCell(cell3criteria6);
		table1criteria6.addCell(cell4criteria6);
		table1criteria6.addCell(cell5criteria6);
		table1criteria6.addCell(cell6criteria6);
		table1criteria6.setSpacingBefore(20f);
		table1criteria6.setSpacingAfter(20f);
		document.add(table1criteria6);
		

		
		PdfPTable table1criteria6000 = new PdfPTable(1);
		table1criteria6000.setWidthPercentage(100);
		
		
//		PdfPCell cell6criteria6111 = new PdfPCell(		new Paragraph(
//				"6.1.2: The effective leadership is reflected in various institutional practices such as decentralization and participative management.",font4));
//		cell6criteria6111.setExtraParagraphSpace(10F);
//		
//		table1criteria6000.addCell(cell6criteria6111);
//
//		if (criteria6Record.getCriteria61Ql() != null) {
//			PdfPCell cell6criteria611001 = new PdfPCell(		new Paragraph(
//					criteria6Record != null ? criteria6Record.getCriteria61Ql().get(0).getInput612t1()
//							: ""));
//			
//			cell6criteria611001.setExtraParagraphSpace(10f);
//			
//			table1criteria6000.addCell(cell6criteria611001);
//
//
//		}
//		
//		document.add(table1criteria6000);
//		
		

//		Paragraph paragraph3criteria613 = new Paragraph("\r\n");
//		document.add(paragraph3criteria613);
//		PdfPTable table11criteria6 = new PdfPTable(2);
//		table11criteria6.setWidthPercentage(100);
//		PdfPCell cell11criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
//		cell11criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell21criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
//		cell21criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell31criteria6 = new PdfPCell(new Paragraph("Paste link for additional Information",font5));
//		cell31criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell41criteria6 = new PdfPCell(
//				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
//		cell41criteria6.setExtraParagraphSpace(10f);
//		cell41criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell51criteria6 = new PdfPCell(new Paragraph("Upload any additional information"));
//		cell51criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		PdfPCell cell61criteria6 = new PdfPCell(
//				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
//		cell61criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell61criteria6.setExtraParagraphSpace(10f);
//		
//		table11criteria6.addCell(cell11criteria6);
//		table11criteria6.addCell(cell21criteria6);
//		table11criteria6.addCell(cell31criteria6);
//		table11criteria6.addCell(cell41criteria6);
//		table11criteria6.addCell(cell51criteria6);
//		table11criteria6.addCell(cell61criteria6);
//		document.add(table11criteria6);

		// 6.2

		Paragraph paragraph11criteria6 = new Paragraph("6.2 Strategy Development and Deployment(10)\r\n\r\n\r\n",
				font2);
		paragraph11criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph11criteria6);
		// create a table 3
		PdfPTable table3criteria6 = new PdfPTable(2);
		table3criteria6.setWidthPercentage(100);
		PdfPTable table31criteria6 = new PdfPTable(1);
		table31criteria6.setWidthPercentage(100);
//
//		PdfPCell cell301criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
//		cell301criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		
//		PdfPCell cell302criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
//		cell302criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		PdfPCell cell303criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
//		cell303criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		PdfPCell cell304criteria6 = new PdfPCell(new Paragraph("",font5));
//		cell304criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		
//		PdfPCell cell305criteria6 = new PdfPCell(
//				new Paragraph("Strategic Plan and deployment documents on the\r\n" + "website\r\n\r\n\r\n",font5));
//		cell305criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		
//		PdfPCell cell306criteria6 = new PdfPCell(new Paragraph("",font5));
//		cell306criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		
//		table3criteria6.addCell(cell301criteria6);
//		table3criteria6.addCell(cell302criteria6);
//		table3criteria6.addCell(cell303criteria6);
//		table3criteria6.addCell(cell304criteria6);
//
//		table3criteria6.addCell(cell305criteria6);
//		table3criteria6.addCell(cell306criteria6);

		PdfPCell cell312 = new PdfPCell(new Paragraph(
				"6.2.1	The institutional perspective plan is effectively deployed and function of \r\n"
				+ "the Institutional bodies are effective and efficient as visible from policies, \r\n"
				+ "administrative set-up, appointment, service rules, procedures etc.\r\n"
			 + ""
						+ "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria62Ql().get(0).getResponse621()
								: ""),
						
				font4));
		
		cell312.setExtraParagraphSpace(10f);
		table31criteria6.addCell(cell312);

	//	table31criteria6.addCell(table3criteria6);

		document.add(table31criteria6);
		
		table3criteria6.setSpacingBefore(20f);
		table3criteria6.setSpacingAfter(20f);
		document.add(table3criteria6);
		

		// create table 4
		PdfPTable table4criteria6 = new PdfPTable(2);
		table4criteria6.setWidthPercentage(100);
		PdfPTable table41criteria6 = new PdfPTable(1);
		table41criteria6.setWidthPercentage(100);

		PdfPCell cell401criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
		cell401criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell42criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell42criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell43criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n",font5));
		cell43criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell44criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : ""),font5));
		cell44criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell44criteria6.setExtraParagraphSpace(10f);
		
		PdfPCell cell45criteria6 = new PdfPCell(
				new Paragraph("Link to Organogram of the Institution webpage\r\n\r\n\r\n",font5));
		cell45criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell46criteria6 = new PdfPCell(new Paragraph("",font5));
		cell46criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell47criteria6 = new PdfPCell(new Paragraph("Link for additional information",font5));
		cell47criteria6.setExtraParagraphSpace(10);
		cell47criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell48criteria6 = new PdfPCell(new Paragraph("",font5));
		cell48criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table4criteria6.addCell(cell401criteria6);
		table4criteria6.addCell(cell42criteria6);
		table4criteria6.addCell(cell43criteria6);
		table4criteria6.addCell(cell44criteria6);
		table4criteria6.addCell(cell45criteria6);
		table4criteria6.addCell(cell46criteria6);
		table4criteria6.addCell(cell47criteria6);
		table4criteria6.addCell(cell48criteria6);
		PdfPCell cell41x = new PdfPCell(new Paragraph(
				"6.2.2	Institution Implements e-governance in its operations"
				+ "6.2.2.1 e-governance is implemented covering the following areas of \r\n"
				+ "operations:\r\n"
				+ "1. Administration including complaint management\r\n"
				+ "2. Finance and Accounts\r\n"
				+ "3. Student Admission and Support\r\n"
				+ "4. Examinations\r\n"
				+ "Options:\r\n"
				+ "A. All of the above\r\n"
				+ "B. Any3 of the above\r\n"
				+ "C. Any2 of the above \r\n"
				+ "D. Any1 of the above\r\n"
				+ "E. None of the above .\r\n"
				+ "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria62Ql().get(0).getInput622t1()
								: ""),
				font4));
		cell41x.setExtraParagraphSpace(10f);
		
		table41criteria6.addCell(cell41x);

	//	table41criteria6.addCell(table4criteria6);

		document.add(table41criteria6);
		table4criteria6.setSpacingBefore(20f);
		table4criteria6.setSpacingAfter(20f);
		document.add(table4criteria6);
		
		
		// create table5
		PdfPTable table5criteria6 = new PdfPTable(2);
		table5criteria6.setWidthPercentage(100);
		PdfPTable table51criteria6 = new PdfPTable(1);
		table51criteria6.setWidthPercentage(100);

		PdfPCell cell501criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
		
		cell501criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell52criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		
		cell52criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell53criteria6 = new PdfPCell(new Paragraph("Screen shots of user interfaces\r\n\r\n\r\n",font5));
	
		cell53criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell53criteria6.setExtraParagraphSpace(10f);
		
		PdfPCell cell54criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(3).getCriteria6FilePath() : ""),font5));
		cell54criteria6.setExtraParagraphSpace(10f);
		cell54criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		// cell54criteria6.setBackgroundColor(Align:);
		PdfPCell cell55criteria6 = new PdfPCell(
				new Paragraph("ERP (Enterprise Resource Planning) Document\r\n\r\n\r\n",font5));
		
		cell55criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell56criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(4).getCriteria6FilePath() : ""),font5));
		
		cell56criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell56criteria6.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell57criteria6 = new PdfPCell(
				new Paragraph("Details of implementation of e-governance in areas\r\n"
						+ "of operation, Administration etc (Data Template)\r\n" + "\r\n\r\n\r\n",font5));
		cell57criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell58criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(5).getCriteria6FilePath() : ""),font5));
		cell58criteria6.setExtraParagraphSpace(10f);
		cell58criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell59criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n",font5));
		
		cell59criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell59criteria6.setExtraParagraphSpace(10f);
		
		PdfPCell cell60criteria6 = new PdfPCell(new Paragraph("",font5));
		
		cell60criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table5criteria6.addCell(cell501criteria6);
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
						font4));
	//	table51criteria6.addCell(cell51x);
	//	table51criteria6.addCell("Response: A. All of the above");
	//	table51criteria6.addCell(table5criteria6);
		document.add(table51criteria6);
		
		
		table5criteria6.setSpacingAfter(20f);
		table5criteria6.setSpacingBefore(20f);
		document.add(table5criteria6);

		// 6.3

		Paragraph paragraph12criteria6 = new Paragraph("6.3  Faculty Empowerment Strategies\r\n", font2);
		paragraph12criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		paragraph12criteria6.setSpacingAfter(2f);
		document.add(paragraph12criteria6);
		// create table6
		PdfPTable table6criteria6 = new PdfPTable(2);
		table6criteria6.setWidthPercentage(100);


		PdfPCell cell601criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
		cell601criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell62criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell62criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
//		PdfPCell cell63criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//		PdfPCell cell64criteria6 = new PdfPCell(
//				new Paragraph((criteria6Record != null ? criteria6file.get(6).getCriteria6FilePath() : "")));
		PdfPCell cell65criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n",font5));
		cell65criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell66criteria6 = new PdfPCell(new Paragraph("",font5));
		cell66criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
//		table6criteria6.addCell(cell601criteria6);
//		table6criteria6.addCell(cell62criteria6);
////		table6criteria6.addCell(cell63criteria6);
////		table6criteria6.addCell(cell64criteria6);
//		table6criteria6.addCell(cell65criteria6);
//		table6criteria6.addCell(cell66criteria6);
//		
		
		PdfPTable table61criteria6 = new PdfPTable(1);
		table61criteria6.setWidthPercentage(100);

		PdfPCell cell66criteria0006 = new PdfPCell(new Paragraph(
				"6.3.1 The institution has a performance appraisal system, promotional \r\n"
				+ "avenues and effective welfare measures for teaching and non-teaching \r\n"
				+ "staff\r\n",font4));
		cell66criteria0006.setExtraParagraphSpace(10);
		table61criteria6.addCell(cell66criteria0006);
		
		
		if (criteria6Record.getCriteria63Ql() != null) {
			PdfPCell cell66criteria00106 = new PdfPCell(new Paragraph(
					criteria6Record != null ? criteria6Record.getCriteria63Ql().get(0).getResponse631()
							: "",font4));
			cell66criteria00106.setExtraParagraphSpace(10f);
			table61criteria6.addCell(cell66criteria00106);
		}
		
		document.add(table61criteria6);

		// create a table7

		Paragraph paragraph12criteria671 = new Paragraph("\r\n");
		document.add(paragraph12criteria671);

		PdfPTable table71criteria6 = new PdfPTable(2);
		table71criteria6.setWidthPercentage(100);
		
		
		PdfPCell cell71criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n", font4));
		cell71criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell72criteria6 = new PdfPCell(new Paragraph("Document\r\n", font4));
		cell72criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell73criteria6 = new PdfPCell(
				new Paragraph("Strategic Plan and deployment documents on the website\r\n",font5));
		cell73criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell74criteria6 = new PdfPCell(
				new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell74criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell74criteria6.setExtraParagraphSpace(10f);
		
		PdfPCell cell75criteria6 = new PdfPCell(new Paragraph("Paste link for additional Information\r\n",font5));
		
		cell75criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell76criteria6 = new PdfPCell(new Paragraph(
				new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5)));
		cell76criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell76criteria6.setExtraParagraphSpace(10f);
		
		PdfPCell cell77criteria6 = new PdfPCell(new Paragraph("Upload any additional information\r\n",font5));
		
		cell77criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell78criteria6 = new PdfPCell(new Paragraph(
				new Paragraph((criteria6file != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5)));

		cell78criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell78criteria6.setExtraParagraphSpace(10f);
		
		table71criteria6.addCell(cell71criteria6);
		table71criteria6.addCell(cell72criteria6);
		table71criteria6.addCell(cell73criteria6);
		table71criteria6.addCell(cell74criteria6);
		table71criteria6.addCell(cell75criteria6);
		table71criteria6.addCell(cell76criteria6);
		table71criteria6.addCell(cell77criteria6);
		table71criteria6.addCell(cell78criteria6);
		
		table71criteria6.setSpacingAfter(20f);
		table71criteria6.setSpacingBefore(20f);
		
		
		document.add(table71criteria6);
		
		

		PdfPTable table7criteria6 = new PdfPTable(1);
		table7criteria6.setWidthPercentage(100);
		
		
		PdfPCell cell00078criteria6 = new PdfPCell(new Paragraph(
				"6.3.2 Percentage of teachers provided with financial support to attend \r\n"
				+ "conferences/workshops and towards membership fee of professional \r\n"
				+ "bodies during the last five years.\r\n"
				 ,font4));
		
		cell00078criteria6.setExtraParagraphSpace(10f);
		
		table7criteria6.addCell(cell00078criteria6);
	
		
		

		if (criteria6Record.getCriteria63Qn() != null) {

			PdfPCell cell0001178criteria6 = new PdfPCell( new Paragraph(
					(criteria6Record != null ? criteria6Record.getCriteria63Qn().get(0).getResponse632()
							: ""),font4));
			cell0001178criteria6.setExtraParagraphSpace(10f);
			
			

			table7criteria6.addCell(cell0001178criteria6);
			
			

		}
		PdfPCell cell7y = new PdfPCell(new Paragraph(
				"6.3.2.1 Number of teachers provided with financial support to attend conferences/workshops and towards membership fee of professional bodies year wise during the last five years"
						+ "",
				font4));
		cell7y.setExtraParagraphSpace(10f);

		table7criteria6.addCell(cell7y);
		document.add(table7criteria6);

		if (criteria6Record.getYearTable6321().size()>0) {

			Table table6331criteria6 = new Table(criteria6Record.getYearTable6321().size() + 1, 2);

			table6331criteria6.setPadding(5);
			table6331criteria6.setWidth(100f);
			table6331criteria6.addCell("year");
			for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
				Cell cell1111=new Cell(new Paragraph(criteria6Record.getYearTable6331().get(i).getInput6331y(),font5));
				cell1111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6331criteria6.addCell(cell1111);
			
			
			}
			table6331criteria6.addCell("number");
			for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
				Cell cell11110=new Cell(new Paragraph(criteria6Record.getYearTable6331().get(i).getInput6331v(),font5));
				cell11110.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6331criteria6.addCell(cell11110);
			
			}

			document.add(table6331criteria6);
		}

		if (criteria6Record.getYearTable6321().size()>0) {

			Table table6331criteria6 = new Table(criteria6Record.getYearTable6321().size() + 1, 2);

			table6331criteria6.setPadding(5);
			table6331criteria6.setWidth(100f);
			table6331criteria6.addCell("year");
			for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
				Cell cell111101=new Cell(new Paragraph(criteria6Record.getYearTable6331().get(i).getInput6331y(),font5));
				cell111101.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6331criteria6.addCell(cell111101);
				
			}
			table6331criteria6.addCell("number");
			for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
				Cell cell111103=new Cell(new Paragraph(criteria6Record.getYearTable6331().get(i).getInput6331v(),font5));
				cell111103.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6331criteria6.addCell(cell111103);
			
			}

//			document.add(table6331criteria6);
		}

		table71criteria6.setSpacingAfter(10f);

		// create table 8

		PdfPTable table81criteria6 = new PdfPTable(2);
		table81criteria6.setWidthPercentage(100);
		PdfPCell cell81criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n", font4));
		cell81criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell81criteria6.setExtraParagraphSpace(10f);
		
		
		
		PdfPCell cell82criteria6 = new PdfPCell(new Paragraph("Document\r\n", font4));
		cell82criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell82criteria6.setExtraParagraphSpace(10f);
		
		PdfPCell cell83criteria6 = new PdfPCell(
				new Paragraph("Upload any additional information\r\n" + "centers\r\n",font5));
		cell83criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
	
		cell83criteria6.setExtraParagraphSpace(10f);
		
		PdfPCell cell84criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell84criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell84criteria6.setExtraParagraphSpace(10f);
		
		PdfPCell cell85criteria6 = new PdfPCell(new Paragraph(
				"Details of teachers provided with financial support to attend conferences, workshops etc. during the last five years\r\n",font5));
		cell85criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell86criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		table71criteria6.setSpacingAfter(10f);
		cell86criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell86criteria6.setExtraParagraphSpace(10f);
		
		//			PdfPCell cell851criteria6 = new PdfPCell(new Paragraph("Link for Additional Information\r\n\r\n\r\n"));
//		PdfPCell cell862criteria6 = new PdfPCell(
//				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")));

		table81criteria6.addCell(cell81criteria6);
		table81criteria6.addCell(cell82criteria6);
		table81criteria6.addCell(cell83criteria6);
		table81criteria6.addCell(cell84criteria6);
		table81criteria6.addCell(cell85criteria6);
		table81criteria6.addCell(cell86criteria6);
		
		
		table81criteria6.setSpacingAfter(20f);
		table81criteria6.setSpacingBefore(20f);
		document.add(table81criteria6);

//		table81criteria6.addCell(cell851criteria6);
//		table81criteria6.addCell(cell862criteria6);

		PdfPTable table8criteria6 = new PdfPTable(1);
		table8criteria6.setWidthPercentage(100);
		
		
		
		PdfPCell cell86criteria1116 = new PdfPCell(new Paragraph(
				"6.3.3: Percentage of teachers undergoing online/ face-to-face Faculty \r\n"
				+ "Development Programmes (FDP)/ Management Development \r\n"
				+ "Programs (MDP) during the last five years .\r\n" 
						+ "Response:"
						+ "\r\n",font4));
		cell86criteria1116.setExtraParagraphSpace(10);
		
		table8criteria6.addCell(cell86criteria1116);

		if (criteria6Record.getCriteria63Ql() != null) {

			PdfPCell cell86criteria1110006 = new PdfPCell( new Paragraph(
					criteria6Record != null ? criteria6Record.getCriteria63Ql().get(0).getResponse633()
							: ""));
			cell86criteria1110006.setExtraParagraphSpace(10f);
			table8criteria6.addCell(cell86criteria1110006);

		}
		PdfPCell cell8y = new PdfPCell(new Paragraph(
				"6.3.3.1 Total number of professional development /administrative training Programmes organized by the institution for teaching and non teaching staff year-wise during the last five years"
						+ "",
				font4));
		cell8y.setExtraParagraphSpace(10f);

		table8criteria6.addCell(cell8y);
		document.add(table8criteria6);
		// create year table 6331

		if (criteria6Record.getYearTable6331().size()>0) {

			Table table6331criteria6 = new Table(criteria6Record.getYearTable6331().size() + 1, 2);

			table6331criteria6.setPadding(5);
			table6331criteria6.setWidth(100f);
			table6331criteria6.addCell("year");
			for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
				Cell cell11111=new Cell(new Paragraph((criteria6Record.getYearTable6331().get(i).getInput6331y()),font4));
				cell11111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6331criteria6.addCell(cell11111);
			
			}
			table6331criteria6.addCell("number");
			for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
				Cell cell11112=new Cell(new Paragraph((criteria6Record.getYearTable6331().get(i).getInput6331v()),font4));
		
				cell11112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6331criteria6.addCell(cell11112);
			}

			document.add(table6331criteria6);
		}
		
		// cretae table 9


		PdfPTable table91criteria6 = new PdfPTable(2);
		table91criteria6.setWidthPercentage(100);
		
		PdfPCell cell91criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
		cell91criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell92criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell92criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell93criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell93criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell94criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
		cell94criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell94criteria6.setExtraParagraphSpace(10f);
		
		PdfPCell cell95criteria6 = new PdfPCell(
				new Paragraph("Minutes of the relevant bodies of the Institution\r\n",font5));
		cell95criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell96criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
		cell96criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell96criteria6.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell97criteria6 = new PdfPCell(new Paragraph(
				"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n",font5));
		cell97criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);	
		cell97criteria6.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell98criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
		cell98criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell98criteria6.setExtraParagraphSpace(10f);
		cell98criteria6.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell99criteria6 = new PdfPCell(new Paragraph(
				"List of teachers receiving grant and details of grant received (Data Template)\r\n",font5));
		cell99criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell10criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));

		cell10criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell10criteria6.setExtraParagraphSpace(10f);
		
		
		table91criteria6.addCell(cell91criteria6);
		table91criteria6.addCell(cell92criteria6);
		table91criteria6.addCell(cell93criteria6);
		table91criteria6.addCell(cell94criteria6);
		table91criteria6.addCell(cell95criteria6);
		table91criteria6.addCell(cell96criteria6);
		table91criteria6.addCell(cell97criteria6);
		table91criteria6.addCell(cell98criteria6);
		table91criteria6.addCell(cell99criteria6);
		table91criteria6.addCell(cell10criteria6);
		table91criteria6.setSpacingAfter(20f);
		table91criteria6.setSpacingBefore(20f);
		
		document.add(table91criteria6);
		
		
		
		PdfPTable table9criteria6 = new PdfPTable(1);
		table9criteria6.setWidthPercentage(100);
		
		PdfPCell cell10criteria1116 = new PdfPCell((new Paragraph(
				"6.3.4: The institution provides seed money to its teachers for research."  + "Response:"
						+ "\r\n",font4)));
		cell10criteria1116.setExtraParagraphSpace(10f);
	
		table9criteria6.addCell(cell10criteria1116);
		
		if (criteria6Record.getCriteria63Qn() != null) {

			PdfPCell cell10criteria11116 = new PdfPCell(new Paragraph(
					criteria6Record != null ? criteria6Record.getCriteria63Qn().get(0).getResponse634()
							: "",font4));
			cell10criteria11116.setExtraParagraphSpace(10f);
			
			table9criteria6.addCell(cell10criteria11116);

		}

		PdfPCell cell10criteria101116 = new PdfPCell( new Paragraph(
				"6.3.4.1: The amount of seed money provided by institution to its teachers for research year wise during last five years (INR in lakhs)"+ "\r\n",font4));
		cell10criteria101116.setExtraParagraphSpace(10f);
		table9criteria6.addCell(cell10criteria101116);
		
	//	document.add(table9criteria6);

		// create table 6341

		if (criteria6Record.getYearTable6341() != null) {

			Table table6341criteria6 = new Table(criteria6Record.getYearTable6341().size() + 1, 2);

			table6341criteria6.setPadding(5);
			table6341criteria6.setWidth(100f);
		//	table6341criteria6.addCell("year");
			for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
				Cell cell11=new Cell(new Paragraph((criteria6Record.getYearTable6341().get(i).getInput6341y()),font5));
				cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6341criteria6.addCell(cell11);
			
			}
		//	table6341criteria6.addCell("number");
			for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
				Cell cell21=new Cell(new Paragraph((criteria6Record.getYearTable6341().get(i).getInput6341v()),font5));
				cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6341criteria6.addCell(cell21);
			
			}

		//	document.add(table6341criteria6);
		}

		if (criteria6Record.getYearTable6341().size()>0) {

			Table table6341criteria6 = new Table(criteria6Record.getYearTable6341().size() + 1, 2);

			table6341criteria6.setPadding(5);
			table6341criteria6.setWidth(100f);
			table6341criteria6.addCell("year");
			for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
				Cell cell221=new Cell(new Paragraph((criteria6Record.getYearTable6341().get(i).getInput6341y()),font5));
				cell221.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6341criteria6.addCell(cell221);
			
			}
			table6341criteria6.addCell("number");
			for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
				Cell cell22221=new Cell(new Paragraph((criteria6Record.getYearTable6341().get(i).getInput6341v())));
				cell22221.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6341criteria6.addCell(cell22221);
			
			
			}

		//	document.add(table6341criteria6);
		}
		

		Paragraph paragraph12criteria67111 = new Paragraph("\r\n");
		document.add(paragraph12criteria67111);

		PdfPTable table911criteria6 = new PdfPTable(2);
		table911criteria6.setWidthPercentage(100);
		
		
		PdfPCell cell911criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
		cell911criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell921criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n",  font4));
		cell921criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell931criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
		cell931criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell941criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
		cell941criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell941criteria6.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell951criteria6 = new PdfPCell(
				new Paragraph("Minutes of the relevant bodies of the Institution\r\n",font5));
		cell951criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell961criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
		cell961criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell961criteria6.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell971criteria6 = new PdfPCell(new Paragraph(
				"Budget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n",font5));
		cell971criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell981criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
		cell981criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell981criteria6.setExtraParagraphSpace(10f);
		
		
		
		PdfPCell cell991criteria6 = new PdfPCell(new Paragraph(
				"List of teachers receiving grant and details of grant received (Data Template)\r\n",font5));
		cell991criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell101criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
		cell101criteria6.setExtraParagraphSpace(10f);
		cell101criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell101criteria6.setExtraParagraphSpace(10f);
		
		
		table911criteria6.addCell(cell911criteria6);
		table911criteria6.addCell(cell921criteria6);
		table911criteria6.addCell(cell931criteria6);
		table911criteria6.addCell(cell941criteria6);
		table911criteria6.addCell(cell951criteria6);
		table911criteria6.addCell(cell961criteria6);
		table911criteria6.addCell(cell971criteria6);
		table911criteria6.addCell(cell981criteria6);
		table911criteria6.addCell(cell991criteria6);
		table911criteria6.addCell(cell101criteria6);
		table911criteria6.setSpacingAfter(20f);
		table911criteria6.setSpacingBefore(20f);
//		document.add(table911criteria6);

		// 6.4

		Paragraph paragraph13criteria6 = new Paragraph(
				"6.4	Financial Management and Resource Mobilization\r\n", font2);
		paragraph13criteria6.setSpacingAfter(3F);
		paragraph13criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph13criteria6);
		
		
		
		
		// create table10
		PdfPTable table10criteria6 = new PdfPTable(2);
		table10criteria6.setWidthPercentage(100);

		com.lowagie.text.Font fontTitle5criteria6 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fontTitle5criteria6.setSize(10);

		PdfPTable table101criteria6 = new PdfPTable(1);
		table101criteria6.setWidthPercentage(100);

		PdfPCell cell10x = new PdfPCell(new Paragraph(
				"6.4.1Institutional strategies for mobilisation of funds other than salary and fees \r\n"
				+ "and the optimal utilisation of resources\r\n"
						+ "Response:"+ ""
						+ (criteria6Record != null
						? criteria6Record.getCriteria64Ql().get(0).getResponse641()
						: ""),
				font4));
		cell10x.setExtraParagraphSpace(10);
		
		
		
		table101criteria6.addCell(cell10x);

		PdfPCell cell1001criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
		cell1001criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell102criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell102criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell103criteria6 = new PdfPCell(
				new Paragraph("\r\n\r\nDetails of Funds / Grants received from government\r\n"
						+ "bodies during the last five years (Data Template)\r\n" + "", font5));
		cell103criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell104criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(13).getCriteria6FilePath() : ""), font5));
		cell104criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell104criteria6.setExtraParagraphSpace(10F);
		PdfPCell cell1031criteria6 = new PdfPCell(new Paragraph("Annual statements of accounts"));
		cell1031criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1042criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(14).getCriteria6FilePath() : ""), font5));
		cell1042criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1042criteria6.setExtraParagraphSpace(10F);
		
		table10criteria6.addCell(cell1001criteria6);
		table10criteria6.addCell(cell102criteria6);
		table10criteria6.addCell(cell103criteria6);
		table10criteria6.addCell(cell104criteria6);
		table10criteria6.addCell(cell1031criteria6);
		table10criteria6.addCell(cell1042criteria6);

		//table101criteria6.addCell(table10criteria6);
	
		document.add(table101criteria6);
		
		table10criteria6.setSpacingAfter(10f);
		table10criteria6.setSpacingBefore(10f);
		
		document.add(table10criteria6);
		
		// create table 11
		PdfPTable table1001criteria6 = new PdfPTable(1);
		table1001criteria6.setWidthPercentage(100);
		PdfPCell cell11x = new PdfPCell(new Paragraph(
				"6.4.2 Funds / Grants received from non-government bodies, individuals, philanthropists during the last five years (not covered in Criterion III and V) (INR in Lakhs)\r\n"
						 + "Response:"
						+ (criteria6Record != null
								? criteria6Record.getCriteria64Qn().get(0).getResponse642()
								: ""),
				font4));
		
		cell11x.setExtraParagraphSpace(10F);
		PdfPCell cell11y = new PdfPCell(new Paragraph(
				"6.4.2.1: Total Grants received from government and non-government bodies\r\n"
				+ "and philanthropists for development and maintenance of infrastructure (not \r\n"
				+ "covered under Criteria III and V) year-wise during the last five years (INR in \r\n"
				+ "Lakhs)"
						+ "",
				font4));
		cell11y.setExtraParagraphSpace(10);
		table1001criteria6.addCell(cell11x);
		table1001criteria6.addCell(cell11y);
		document.add(table1001criteria6);
		// create table 6421

		if (criteria6Record.getYearTable6421().size()>0) {

			Table table6421 = new Table(criteria6Record.getYearTable6421().size(), 2);

			table6421.setPadding(5);
			table6421.setWidth(100f);

			for (int i = 0; i < criteria6Record.getYearTable6421().size(); i++) {
				Cell cell100=new Cell(new Paragraph(criteria6Record.getYearTable6421().get(i).getInput6421y(),font5));
				cell100.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6421.addCell(cell100);
			
			}
			for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
				Cell cell1001=new Cell(new Paragraph(criteria6Record.getYearTable6421().get(i).getInput6421v(),font5));
				cell1001.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6421.addCell(cell1001);
				
				
			}

			document.add(table6421);
		}

		PdfPTable table111criteria6 = new PdfPTable(2);
		table111criteria6.setWidthPercentage(100);
		
		
		PdfPCell cell111criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n\r\n", font4));
		cell111criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell112criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n\r\n", font4));
		cell112criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell113criteria6 = new PdfPCell(
				new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n\r\n",font5));
		cell113criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell114criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(15).getCriteria6FilePath() : ""),font5));
		cell114criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell114criteria6.setExtraParagraphSpace(10);
		
		PdfPCell cell115criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n",font5));
		cell115criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell116criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(16).getCriteria6FilePath() : ""),font5));
		cell116criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell116criteria6.setExtraParagraphSpace(10);
		
		PdfPCell cell117criteria6 = new PdfPCell(new Paragraph("Annual statements of accounts\r\n\r\n\r\n",font5));
		cell117criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell118criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(17).getCriteria6FilePath() : ""),font5));
		cell118criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell118criteria6.setExtraParagraphSpace(10);
		
		//			PdfPCell cell119criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
//		PdfPCell cell120criteria6 = new PdfPCell(new Paragraph(""));
		table111criteria6.addCell(cell111criteria6);
		table111criteria6.addCell(cell112criteria6);
		table111criteria6.addCell(cell113criteria6);
		table111criteria6.addCell(cell114criteria6);
		table111criteria6.addCell(cell115criteria6);
		table111criteria6.addCell(cell116criteria6);
		table111criteria6.addCell(cell117criteria6);
		table111criteria6.addCell(cell118criteria6);
//		table111criteria6.addCell(cell119criteria6);
//		table111criteria6.addCell(cell120criteria6);
		table111criteria6.setSpacingAfter(20);
		table111criteria6.setSpacingBefore(20);
		document.add(table111criteria6);
		// CREATE TABLE12
		PdfPTable table12criteria6 = new PdfPTable(1);
		table12criteria6.setWidthPercentage(100);
		PdfPTable table121x = new PdfPTable(1);
		table121x.setWidthPercentage(100);

		PdfPCell cell12Y = new PdfPCell(new Paragraph(
				"6.4.3  Institution regularly conducts internal and external financial audits\r\n"
						,
				font4));
		cell12Y.setExtraParagraphSpace(10F);
		table12criteria6.addCell(cell12Y);
		document.add(table12criteria6);
		PdfPCell cell121Y = new PdfPCell(new Paragraph(
				"6.4.3.1 Total Grants received from non-government bodies, individuals, Philanthropers year wise during\r\n"
						+ "the last five years (INR in Lakhs)" + "\r\n" + "",font4));
		cell121Y.setExtraParagraphSpace(10);
	//	table12criteria6.addCell(cell121Y);
	//.addCell(table12criteria6);
		document.add(table12criteria6);

		// create table 121
		PdfPTable table121criteria6 = new PdfPTable(2);
		PdfPTable table1211criteria6 = new PdfPTable(2);

		table121criteria6.setWidthPercentage(100);
		PdfPCell cell121criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
		cell121criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell122criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell122criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell123criteria6 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n",font5));
		cell123criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell124criteria6 = new PdfPCell(new Paragraph("",font5));
		cell124criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table121criteria6.addCell(cell121criteria6);
		table121criteria6.addCell(cell122criteria6);
		table121criteria6.addCell(cell123criteria6);
		table121criteria6.addCell(cell124criteria6);
		
		table121criteria6.setSpacingBefore(20f);
		table121criteria6.setSpacingAfter(20f);
		
		document.add(table121criteria6);
		
		
		PdfPCell cell121 = new PdfPCell(new Paragraph(
				"6.4.4 Institution conducts internal and external financial audits regularly\r\n" + " ", font4));
		//table12criteria6.addCell(cell121);
	///	table12criteria6.addCell(table121criteria6);
	//	document.add(table1211criteria6);

		// 6.5
		
		
		
		Paragraph paragraph14criteria6 = new Paragraph("6.5	Internal Quality Assurance System\r\n", font2);
		paragraph14criteria6.setSpacingAfter(3f);
		paragraph14criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph14criteria6);

		PdfPTable table1211criteria6111 = new PdfPTable(1);

		table1211criteria6111.setWidthPercentage(100);
		
		
		
		PdfPCell cell121111 = new PdfPCell(new Paragraph(new Paragraph(
				"6.5.1 Internal Quality Assurance Cell (IQAC)/ Internal Quality Assurance System\r\n"
				+ "(IQAS) has contributed significantly for institutionalizing the quality \r\n"
				+ "assurance strategies and processes, by constantly reviewing the teachinglearning process, structures & methodologies of operations and learning \r\n"
				+ "outcomes, at periodic intervals\r\n"
						+ "Response",font4)));
		
		cell121111.setExtraParagraphSpace(10F);
		table1211criteria6111.addCell(cell121111);

		if (criteria6Record.getCriteria65Ql() != null) {

			PdfPCell cell12111111 = new PdfPCell( new Paragraph(
					criteria6Record != null ? criteria6Record.getCriteria65Ql().get(0).getInput651t1()
							: "",font4));
			cell12111111.setExtraParagraphSpace(10F);
			table1211criteria6111.addCell(cell12111111);

		}
		
		
		document.add(table1211criteria6111);
		
		
		Paragraph paragraph14criteria651 = new Paragraph("\r\n");
		document.add(paragraph14criteria651);
		// create table 

		
		PdfPTable table131criteria6 = new PdfPTable(2);
		table131criteria6.setWidthPercentage(100);


		PdfPCell cell131criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
		cell131criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell132criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell132criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell133criteria6 = new PdfPCell(
				new Paragraph("Upload e-copies of the accreditations and\r\n" + "certifications",font5));
		cell133criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell134criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell134criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell134criteria6.setExtraParagraphSpace(10F);
		
		PdfPCell cell1331criteria6 = new PdfPCell(new Paragraph(
				"Upload details of Quality assurance initiatives of the\r\n" + "institution (Data Template)",font5));
		cell1331criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell1341criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : ""),font5));
		cell1341criteria6.setExtraParagraphSpace(10F);
		cell1341criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table131criteria6.addCell(cell131criteria6);
		table131criteria6.addCell(cell132criteria6);
		table131criteria6.addCell(cell133criteria6);
		table131criteria6.addCell(cell134criteria6);
		table131criteria6.addCell(cell1331criteria6);
		table131criteria6.addCell(cell1341criteria6);
		
		table131criteria6.setSpacingAfter(20F);
		table131criteria6.setSpacingBefore(20F);
		
		
		document.add(table131criteria6);
		
		

		PdfPTable table130criteria6 = new PdfPTable(1);
		table130criteria6.setWidthPercentage(100);
		
		
		PdfPCell cell1341criteria611 = new PdfPCell(new Paragraph(
				"6.5.2: Institution has adopted the following for Quality assurance: \r\n"
				+ "1. Academic and Administrative Audit (AAA) and follow up action taken\r\n"
				+ "2.Conferences, Seminars, Workshops on quality conducted \r\n"
				+ "3. Collaborative quality initiatives with other institution(s)\r\n"
				+ "4.Orientation programme on quality issues for teachers and students\r\n"
				+ "5. Participation in NIRF and other recognized ranking like Shanghai \r\n"
				+ "Ranking, QS Ranking Times Ranking etc "
				+ "6.Any other quality audit recognized by state, national or international \r\n"
				+ "agencies \r\n"
				+ "Options:\r\n"
				+ "A. Any 5 or more of the above \r\n"
				+ "B. Any4 of the above\r\n"
				+ "C. Any3 of the above \r\n"
				+ "D. Any2 of the above\r\n"
				+ "E. Any1of the above )"
						+ "",font4));
		
		cell1341criteria611.setExtraParagraphSpace(10F);
		table130criteria6.addCell(cell1341criteria611);

		if (criteria6Record.getCriteria65Ql() != null) {
			PdfPCell cell1341criteria00611 = new PdfPCell(new Paragraph(
					criteria6Record != null ? criteria6Record.getCriteria65Ql().get(0).getResponse652()
							: "",font4));
			
			cell1341criteria00611.setExtraParagraphSpace(10F);
			table130criteria6.addCell(cell1341criteria00611);
		}
		
		document.add(table130criteria6);
		
		Paragraph paragraph14criteria64 = new Paragraph("\r\n");
		document.add(paragraph14criteria64);

		PdfPTable table141criteria6 = new PdfPTable(2);
		table141criteria6.setWidthPercentage(100);
		PdfPCell cell141criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
		cell141criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell141criteria6.setExtraParagraphSpace(10f);
		
		PdfPCell cell142criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell142criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell142criteria6.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell143criteria6 = new PdfPCell(
				new Paragraph("Strategic Plan and deployment documents on the website\r\n",font5));
		cell143criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell143criteria6.setExtraParagraphSpace(10f);
		
		PdfPCell cell144criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell144criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell144criteria6.setExtraParagraphSpace(10f);
		
		PdfPCell cell145criteria6 = new PdfPCell(new Paragraph("Upload any additional information\r\n",font5));
		cell145criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell146criteria6 = new PdfPCell(
				new Paragraph((criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""),font5));
		cell146criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell146criteria6.setExtraParagraphSpace(10f);
		
		table141criteria6.addCell(cell141criteria6);
		table141criteria6.addCell(cell142criteria6);
		table141criteria6.addCell(cell143criteria6);
		table141criteria6.addCell(cell144criteria6);
		table141criteria6.addCell(cell145criteria6);
		table141criteria6.addCell(cell146criteria6);
		
		
		table141criteria6.setSpacingAfter(20F);
		table141criteria6.setSpacingBefore(20F);
		
		document.add(table141criteria6);

		// create table 15

		PdfPTable table141criteria60000 = new PdfPTable(1);
		table141criteria60000.setWidthPercentage(100);
		
		
		PdfPCell cell146criteria006 = new PdfPCell(new Paragraph(
				"6.5.3	Incremental improvements made for the preceding five years with regard to \r\n"
				+ "quality (in case of first cycle NAAC A/A)",font4));
		cell146criteria006.setExtraParagraphSpace(10F);
		table141criteria60000.addCell(cell146criteria006);
		
		

		if (criteria6Record.getCriteria65Qn() != null) {
			PdfPCell cell146criteria0061 = new PdfPCell(new Paragraph(
					criteria6Record != null ? criteria6Record.getCriteria65Qn().get(0).getResponse653()
							: "",font4));
			cell146criteria006.setExtraParagraphSpace(10F);
			cell146criteria0061.setExtraParagraphSpace(10F);
			
			table141criteria60000.addCell(cell146criteria0061);

		}
		document.add(table141criteria60000);
		
		// cretae653
		PdfPTable table151criterion6 = new PdfPTable(2);
		table151criterion6.setWidthPercentage(100);
		PdfPCell cell151 = new PdfPCell(new Paragraph("FileDiscription\r\n", font4));
		cell151.setHorizontalAlignment(Element.ALIGN_CENTER);
	
		
		PdfPCell cell152 = new PdfPCell(new Paragraph("Document\r\n", font4));
		cell152.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell153 = new PdfPCell(new Paragraph("Paste web link of Annual reports of Institution\r\n",font5));
		
		cell153.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell154 = new PdfPCell(
				new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "",font5));
		cell154.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell154.setExtraParagraphSpace(10F);
		
		PdfPCell cell155 = new PdfPCell(
				new Paragraph("Upload e-copies of the accreditations and certifications\r\n",font5));
		
		cell155.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell156 = new PdfPCell(
				new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "",font5));
		cell156.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell156.setExtraParagraphSpace(10F);
		
		PdfPCell cell157 = new PdfPCell(new Paragraph("Any additional information\r\n"));
		
		cell157.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell158 = new PdfPCell(
				new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "",font5));
		cell158.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell158.setExtraParagraphSpace(10F);
		PdfPCell cell159 = new PdfPCell(
				new Paragraph("Upload details of quality assurance initiatives of the institution\r\n",font5));
		cell159.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell160 = new PdfPCell(
				new Paragraph(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : ""));
		cell160.setExtraParagraphSpace(10F);
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
		table151criterion6.setSpacingBefore(20f);
		table151criterion6.setSpacingAfter(20f);
		
		document.add(table151criterion6);
		}

	public void Criteria7(Document document, Criteria7_FieldInfo criteria7Fieldinfo) {	
		
		
		Paragraph paragraphcriteria7 = new Paragraph("Criterion 7 - Institutional Values and Best Practices\r\n",
				font2);
		paragraphcriteria7.setSpacingBefore(2f);
		paragraphcriteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
		
		document.add(paragraphcriteria7);
		
		
		
		Paragraph paragraphcriteria00007 = new Paragraph("____________________________________________________________________________"
				);
		paragraphcriteria00007.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
		
		document.add(paragraphcriteria00007);
		
		
		
		
		
		




		Paragraph paragraph2criteria7 = new Paragraph("7.1 Institutional Values and Social Responsibilities\r\n", font2);
		paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		
		document.add(paragraph2criteria7);
		
		
		
		PdfPTable tablecriteria7444 = new PdfPTable(1);
		tablecriteria7444.setWidthPercentage(100f);
		
		
		PdfPCell cell111criteria0007 = new PdfPCell(new Paragraph(
				"7.1.1nstitution has initiated Gender audit and measure for the promotion of gender equity .\r\n",
				font4));
		
		tablecriteria7444.addCell(cell111criteria0007);
		
	//	document.add(tablecriteria7444);


		PdfPTable table711criteria7 = new PdfPTable(1);
		table711criteria7.setWidthPercentage(100f);

		

		PdfPCell cell711criteria7 = new PdfPCell(new Paragraph(
				"7.1.1	Measures initiated by the Institution for the promotion of gender equity during the last five years.\r\n"
				 + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse711()
								: ""),
				font4));
		cell711criteria7.setExtraParagraphSpace(10f);

		table711criteria7.addCell(cell711criteria7);
		table711criteria7.setSpacingBefore(20f);
		table711criteria7.setSpacingAfter(20f);

		document.add(table711criteria7);

		// paragaph3

		

		PdfPCell cell8 = new PdfPCell();
		cell8.setPadding(8);
		document.add(cell8);
		// table
		
		
		
		PdfPTable tablecriteria7 = new PdfPTable(2);
		tablecriteria7.setWidthPercentage(100f);

		
		PdfPCell cell111criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
		cell111criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell112criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
		cell111criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1113criteria7 = new PdfPCell(new Paragraph("Specific facilities provided for women in terms of: a.Safety and security b.Counselling c.Common Rooms d. Day care center for young children Any other relevant information"
				
				+ "	+  ",font5));
	
		cell1113criteria7.setExtraParagraphSpace(10f);
		cell1113criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1114criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		
		cell1114criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1114criteria7.setExtraParagraphSpace(10f);
		
		PdfPCell cell115criteria7 = new PdfPCell(new Paragraph("  Annual gender sensitization action plan",font5));
		cell115criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell116criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		cell116criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell116criteria7.setExtraParagraphSpace(10f);
		
		
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

		
		PdfPCell cell113criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n", font4));
		cell113criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell113criteria7.setExtraParagraphSpace(10f);
		PdfPCell cell114criteria7 = new PdfPCell(new Paragraph("Document\r\n", font4));
		cell114criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell11104criteria7 = new PdfPCell(new Paragraph("Geotagged Photographs\r\n",font5));
		cell11104criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell1117criteria7 = new PdfPCell(
				new Paragraph((criteria7file != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell1117criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1117criteria7.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell1190criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n",font5));
		
		cell1190criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell1191criteria7 = new PdfPCell(
				new Paragraph((criteria7file != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));

		cell1191criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1191criteria7.setExtraParagraphSpace(10f);
		
		
		table1criteria7.addCell(cell113criteria7);
		table1criteria7.addCell(cell114criteria7);
		// table1.addCell(cell1113);
		table1criteria7.addCell(cell11104criteria7);
		table1criteria7.addCell(cell1117criteria7);
		table1criteria7.addCell(cell1190criteria7);
		table1criteria7.addCell(cell1191criteria7);

		PdfPCell cell7101criteria7 = new PdfPCell(new Paragraph(
				"7.1.2: The Institution has facilities for alternate sources of energy and energy conservation measures\r\n"
				+ " 1. Solar energy\r\n"
				+ "2. Biogas plant\r\n"
				+ "3. Wheeling to the Grid \r\n"
				+ "4. Sensor-based energy conservation \r\n"
				+ "5. Use of LED bulbs/ power efficient equipment \r\n "
				+ "6. Wind will or any other clean green energy \r\n",font4));
		
		cell7101criteria7.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell0071 = new PdfPCell(new Paragraph( "Response:"
						+ (criteria7Record != null
						? criteria7Record.getCriteria71Qn().get(0).getInput712t1()
						: ""),
				font4));
		cell0071.setExtraParagraphSpace(10f);
	//	table1criteria71.addCell(cell0071);
//		
		
		
		table1criteria71.addCell(cell7101criteria7);
		



		table1criteria71.setSpacingBefore(20f);
		table1criteria71.setSpacingAfter(20f);

		document.add(table1criteria71);
		
		table1criteria7.setSpacingBefore(20f);
		
		table1criteria7.setSpacingAfter(20f);
		document.add(table1criteria7);

		PdfPCell cell6criteria7 = new PdfPCell();
		cell6criteria7.setPadding(5);
		document.add(cell6criteria7);

		// 7.1.3
		
		
		PdfPTable table1criteria7122 = new PdfPTable(1);

		table1criteria7122.setWidthPercentage(100f);
		
		Paragraph paragraph16criteria7 = new Paragraph(
				"7.1.3 Describe the facilities in the Institution for the management of the following types of\r\n"
						+ "degradable and non-degradable waste (within 500 words)\r\n",
				font4);
		cell0071.setExtraParagraphSpace(10f);
	//	document.add(paragraph16criteria7);

		PdfPCell cell10 = new PdfPCell();
		cell10.setPadding(10);
		
		

		PdfPTable table713criteria7 = new PdfPTable(1);
		table713criteria7.setWidthPercentage(100f);

		

		PdfPCell cell713criteria7 = new PdfPCell(new Paragraph(
				"7.1.3 Describe the facilities in the Institution for the management of the following types of degradable and non-degradable waste (within 500 words)\r\n"
				
						+ "Solid waste management\r\n"
						+"Liquid waste management\r\n"
						+" Biomedical waste management\r\n"
						+" E-waste management\r\n"
						+ "Waste recycling system\r\n" + "Hazardous chemicals and radioactive waste management\r\n"
						+ "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse713()
								: ""),
				font4));
		cell713criteria7.setExtraParagraphSpace(10f);

		table713criteria7.addCell(cell713criteria7);
		table713criteria7.setSpacingBefore(20f);
		table713criteria7.setSpacingAfter(20f);



		PdfPCell cell713c8riteria7 = new PdfPCell(new Paragraph("Solid waste management\r\n" + "Liquid waste management\r\n"
				+ "Biomedical waste management\r\n" + "E-waste management\r\n" + "Waste recycling system\r\n"
				+ "Hazardous chemicals and radioactive waste management\r\n" + "Response: "
				
				+ (criteria7Record != null ? criteria7Record.getCriteria71Qn().get(0).getResponse713()
						: ""),
				font4));
		cell713c8riteria7.setExtraParagraphSpace(10f);
		table713criteria7.addCell(cell713c8riteria7);

		document.add(table713criteria7);
		
		
		
		// 7.1.4

		// creating table
		PdfPTable table2criteria7 = new PdfPTable(2);
		table2criteria7.setWidthPercentage(100);

		com.lowagie.text.Font font11 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font11.setColor(CMYKColor.BLACK);
		// Create table for header pdfcell cell= new pdf cell
		PdfPCell cell51criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
		cell51criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell52criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell52criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell0 = new PdfPCell();
		cell0.setPadding(5);
		PdfPCell cell53criteria7 = new PdfPCell(new Paragraph(
				"Relevant documents like agreements/MoUs with\r\n" + "Government and other approved agencies\r\n\r\n\r\n",font5));
		cell53criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell54criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell54criteria7.setExtraParagraphSpace(10f);
		cell54criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell55criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n\r\n ",font5));
		cell55criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell56criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell56criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell56criteria7.setExtraParagraphSpace(10f);
		
		PdfPCell cell57criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n\r\n",font5));
		cell57criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell58criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell58criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		cell58criteria7.setExtraParagraphSpace(10f);
		PdfPCell cell59criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n",font5));
		cell59criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell60criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell60criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		cell60criteria7.setExtraParagraphSpace(10f);
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

		

		PdfPTable table3criteria7 = new PdfPTable(2);
		PdfPTable table3criteria71 = new PdfPTable(1);
		table3criteria7.setWidthPercentage(100f);
		table3criteria71.setWidthPercentage(100f);

		
		PdfPCell cell61criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
		cell61criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell62criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell62criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell63criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n\r\n",font5));
		cell63criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell64criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell64criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell64criteria7.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell65criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n",font5));
		cell65criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		PdfPCell cell66criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell66criteria7.setExtraParagraphSpace(10f);
		cell66criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
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
						+ "5.	Maintenance of water bodies and distribution system in the campus\r\n" + "Response:"+
						 (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse714()
								: ""),
						font4));
		cell072.setExtraParagraphSpace(10f);
		table3criteria71.addCell(cell072);




		document.add(table3criteria71);
		
		table3criteria7.setSpacingBefore(20f);
		table3criteria7.setSpacingAfter(20f);

		
		document.add(table3criteria7);

		

		// 7.15 table
		PdfPTable table6criteria7 = new PdfPTable(2);
		PdfPTable table6criteria72 = new PdfPTable(1);

		table6criteria7.setWidthPercentage(100f);
		table6criteria72.setWidthPercentage(100f);

		
		PdfPCell cell67criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
		cell67criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell68criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell68criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell69criteria7 = new PdfPCell(
				new Paragraph("Various policy documents / decisions circulated for" + "implementation",font5));
		cell69criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell69criteria7.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell70criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell70criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell70criteria7.setExtraParagraphSpace(10f);
		
		PdfPCell cell71criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n",font5));
		cell71criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell72criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell72criteria7.setExtraParagraphSpace(10f);
		cell72criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6criteria7.addCell(cell67criteria7);
		table6criteria7.addCell(cell68criteria7);
		table6criteria7.addCell(cell69criteria7);
		table6criteria7.addCell(cell70criteria7);
		table6criteria7.addCell(cell71criteria7);
		table6criteria7.addCell(cell72criteria7);

		PdfPCell cell073 = new PdfPCell(new Paragraph("7.1.5	Green campus initiatives :\r\n"+
			"Describer the Green campus initiative of the institution including Restricted "+
"entry of automobiles, Use of Bicycles/ Battery powered vehicles , Pedestrian "+
"Friendly pathways , Ban on use of Plastic, landscaping with trees and plants"+
"etc in 500 word"+
				 (criteria7Record != null ? criteria7Record.getCriteria71Qn().get(0).getResponse715()
						: ""),
				font4));
		cell073.setExtraParagraphSpace(10f);

		table6criteria72.addCell(cell073);

	//	table6criteria72.addCell(table6criteria7);



		document.add(table6criteria72);
		
		table6criteria7.setSpacingBefore(20f);
		table6criteria7.setSpacingAfter(20f);	

		document.add(table6criteria7);
		

		PdfPTable table15criteria7 = new PdfPTable(2);
		PdfPTable table15criteria73 = new PdfPTable(1);

		table15criteria7.setWidthPercentage(100f);
		table15criteria73.setWidthPercentage(100f);

		com.lowagie.text.Font font131 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font131.setColor(CMYKColor.BLACK);
		
		PdfPCell cell75criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n",font4));
		cell75criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell76criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n",font4));
		cell76criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell77criteria7 = new PdfPCell(
				new Paragraph("Reports on environment and energy audits\r\n" + "submitted by the auditing agency\r\n\r\n\r\n",font5));
		cell77criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell78criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell78criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell78criteria7.setExtraParagraphSpace(10f);
		
		PdfPCell cell79criteria7 = new PdfPCell(new Paragraph("Certification by the auditing agency\r\n\r\n\r\n",font5));
		cell79criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell80criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(13).getCriteria7FilePath() : ""),font5));
		cell80criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell80criteria7.setExtraParagraphSpace(10f);
		
		
		PdfPCell cell81criteria7 = new PdfPCell(new Paragraph("Certificates of the awards received\r\n\r\n\r\n",font5));
		cell81criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell81criteria7.setExtraParagraphSpace(10f);
		
		PdfPCell cell82criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(14).getCriteria7FilePath() : ""),font5));
		cell82criteria7.setExtraParagraphSpace(10f);
		cell82criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table15criteria7.addCell(cell75criteria7);
		table15criteria7.addCell(cell76criteria7);
		table15criteria7.addCell(cell77criteria7);
		table15criteria7.addCell(cell78criteria7);
		table15criteria7.addCell(cell79criteria7);
		table15criteria7.addCell(cell80criteria7);
		table15criteria7.addCell(cell81criteria7);
		table15criteria7.addCell(cell82criteria7);

		PdfPCell cell074 = new PdfPCell(new Paragraph(
				"7.1.6	Quality audits on environment and energy are regularly undertaken by the \r\n"
				+ "institution \r\n"
						+"7.1.6.1.The institutional environment and energy initiatives are confirmed through the following\r\n"
					 + "1.	Green audit\r\n" + "2.	Energy audit\r\n" 
						+ "3.	Clean and green campus recognitions / awards\r\n"
						+ "4.	Beyond the campus environmental promotion activities"  + "Response:"+
						 (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse716()
								: ""),
				font4));
		cell074.setExtraParagraphSpace(10f);

		table15criteria73.addCell(cell074);

		
	

		document.add(table15criteria73);
		
		table15criteria7.setSpacingBefore(20f);
		table15criteria7.setSpacingAfter(20f);
		
		document.add(table15criteria7);
		

		
		// 7.1.7 table
		PdfPTable table17criteria7 = new PdfPTable(2);
		PdfPTable table17criteria73 = new PdfPTable(1);

		table17criteria7.setWidthPercentage(100f);
		table17criteria73.setWidthPercentage(100f);
		com.lowagie.text.Font font132 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font132.setColor(CMYKColor.BLACK);
		PdfPCell cell85criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n",font4));
		cell85criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell86criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n",font4));
		cell86criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell87criteria7 = new PdfPCell(
				new Paragraph("Policy documents and information brochures on the\r\n" + "support to be provided",font5));
		cell87criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell87criteria7.setExtraParagraphSpace(10f);
	
		PdfPCell cell88criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(15).getCriteria7FilePath() : "")));
		cell88criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell88criteria7.setExtraParagraphSpace(10f);
		
		PdfPCell cell89criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n"));
		cell89criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell89criteria7.setExtraParagraphSpace(10f);
		PdfPCell cell90criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(16).getCriteria7FilePath() : "")));
		cell90criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

		cell90criteria7.setExtraParagraphSpace(10f);
		PdfPCell cell91criteria7 = new PdfPCell(
				new Paragraph("Details of the Software procured for providing the" + "assistance\r\n"));
		cell91criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell91criteria7.setExtraParagraphSpace(10f);
		PdfPCell cell92criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(17).getCriteria7FilePath() : "")));
		cell92criteria7.setExtraParagraphSpace(10f);
		cell92criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table17criteria7.addCell(cell85criteria7);
		table17criteria7.addCell(cell86criteria7);
		table17criteria7.addCell(cell87criteria7);
		table17criteria7.addCell(cell88criteria7);
		table17criteria7.addCell(cell89criteria7);
		table17criteria7.addCell(cell90criteria7);
		table17criteria7.addCell(cell91criteria7);
		table17criteria7.addCell(cell92criteria7);

		PdfPCell cell075 = new PdfPCell(
				new Paragraph("7.1.7	The Institution has friendly, barrier free environment\r\n"
						+"Write description covering the various components of barrier free \r\n"
						+ "environment in your institution within 500 words"
						+ "1.	Built environment with ramps/lifts for easy access to classrooms.\r\n"
						+ "2.	Divyangjan friendly washrooms\r\n"
						+ "3.	Signage including tactile path, lights, display boards and signposts\r\n"
						+ "4.	Assistive technology and facilities for Divyangjan accessible website, screen-reading software, mechanized equipment\r\n"
						+ "5.	Provision for enquiry and information : Human assistance, reader, scribe, soft copies of reading material, screen reading, font enlargement etc.,\r\n"
						+ "Response:"+
						 (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse717()
								: ""),
						font4));
		cell075.setExtraParagraphSpace(10f);

		table17criteria73.addCell(cell075);



		



		

		table17criteria7.setSpacingBefore(20f);
		table17criteria7.setSpacingAfter(20f);
		
		document.add(table17criteria7);

		// 7.1.8
		/*
		 * Font fontParagraph2142 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontParagraph2142.setSize(12);
		 * 
		 * 
		 */
		
		
		
		PdfPCell cell07511 = new PdfPCell( new Paragraph(
				"7.1.8 Describe the Institutional efforts/initiatives in providing an inclusive environment i.e., tolerance\r\n"
						+ "and harmony towards cultural, regional, linguistic, communal socioeconomic and other diversities"
						+ "(within 500 words)." + "Response: "+
						(criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse718()
								: ""),
				font4));
		cell07511.setExtraParagraphSpace(10);
	//	table17criteria73.addCell(cell07511);
		
		
		
		document.add(table17criteria73);

		PdfPTable table718criteria7 = new PdfPTable(1);
		table718criteria7.setWidthPercentage(100f);

		/*
		 * com.lowagie.text.Font fontcriteria7 =
		 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * fontcriteria7.setColor(CMYKColor.BLACK);
		 */

		PdfPCell cell718criteria7 = new PdfPCell(new Paragraph(
				"7.1.8 Describe the Institutional efforts/initiatives in providing an inclusive environment i.e., tolerance and harmony towards cultural, regional, linguistic, communal socioeconomic and other diversities (within 500 words)."
						+ "Response:"+
						 (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse718()
								: ""),
				font4));
		cell718criteria7.setExtraParagraphSpace(10);

		table718criteria7.addCell(cell718criteria7);
		table718criteria7.setSpacingBefore(20f);
		table718criteria7.setSpacingAfter(20f);

		document.add(table718criteria7);

		

		// 7.1.8 table

		PdfPTable table18criteria7 = new PdfPTable(2);
		table18criteria7.setWidthPercentage(100f);
		com.lowagie.text.Font font133 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font133.setColor(CMYKColor.BLACK);
		PdfPCell cell95criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
		cell95criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell96criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell96criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell97criteria7 = new PdfPCell(
				new Paragraph("Policy documents and information brochures on the\r\n" + "support to be provided"));
		cell97criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell98criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(18).getCriteria7FilePath() : "")));
		cell98criteria7.setExtraParagraphSpace(10);
		cell98criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table18criteria7.addCell(cell95criteria7);
		table18criteria7.addCell(cell96criteria7);
		table18criteria7.addCell(cell97criteria7);
		table18criteria7.addCell(cell98criteria7);
		table18criteria7.setSpacingBefore(20f);
		table18criteria7.setSpacingAfter(20f);

		document.add(table18criteria7);

		PdfPTable table18criteria1117 = new PdfPTable(1);
		table18criteria1117.setWidthPercentage(100f);
		
		PdfPCell cell98criteri111a7 = new PdfPCell( new Paragraph(
				"7.1.9 Sensitization of students and employees of the Institution to the constitutional obligations:"
						+ "values, rights, duties and responsibilities of citizens (within 500 words)."
						+ "Response: "
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse719()
								: ""),
				font4));
		
		cell98criteri111a7.setExtraParagraphSpace(10);
		
	//	table18criteria1117.addCell(cell98criteri111a7);
//		document.add(table18criteria1117);
		



		PdfPTable table719criteria7 = new PdfPTable(1);
		table719criteria7.setWidthPercentage(100f);

		
		PdfPCell cell719criteria7 = new PdfPCell(new Paragraph(
				"7.1.9 Sensitization of students and employees of the Institution to the constitutional obligations: values, rights, duties and responsibilities of citizens (within 500 words).\r\n"
						+ "\r\n" + "Response:"
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getInput719t1()
								: ""),
				font4));
		
		cell719criteria7.setExtraParagraphSpace(10);

		table719criteria7.addCell(cell719criteria7);
		table719criteria7.setSpacingBefore(20f);
		table719criteria7.setSpacingAfter(20f);

		document.add(table719criteria7);

	
		
		
		// 7.1.1.9 table
		PdfPTable table19criteria7 = new PdfPTable(2);
		table19criteria7.setWidthPercentage(100f);
		com.lowagie.text.Font font134 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font134.setColor(CMYKColor.BLACK);
		PdfPCell cell105criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
		cell105criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell106criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell106criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell107criteria7 = new PdfPCell(new Paragraph(" Details of activities that inculcate values;\r\n"
				+ "necessary to render students in to responsible\r\n" + "citizens\r\n\r\n",font5));
		cell107criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell108criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(19).getCriteria7FilePath() : ""),font5));
		cell108criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell108criteria7.setExtraParagraphSpace(10);
		
		
		PdfPCell cell109criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n",font5));
		cell109criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell110criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(20).getCriteria7FilePath() : ""),font5));
		cell110criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell110criteria7.setExtraParagraphSpace(10);
		
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
		PdfPCell cell1111 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n",font4));
		cell1111.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1112 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n",font4));
		cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell11113 = new PdfPCell(new Paragraph(
		
				" Details of the monitoring committee composition and minutes of the committee meeting, number of\r\n"

						+ "programmes organized, reports on the various\r\n"
						+ "programs etc., in support of the claims\r\n\r\n\r\n",font5));
		cell11113.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell11114 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(21).getCriteria7FilePath() : ""),font5));
		cell11114.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell11114.setExtraParagraphSpace(10f);
		
		PdfPCell cell1115 = new PdfPCell(new Paragraph("Code of ethics policy document\r\n\r\n\r\n",font5));
		cell1115.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell1116 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(22).getCriteria7FilePath() : ""),font5));
		cell1116.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1116.setExtraParagraphSpace(10);
		cell1116.setExtraParagraphSpace(10f);
		
		PdfPCell cell11117 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n",font5));
		cell11117.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell1118 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(23).getCriteria7FilePath() : ""),font5));
		cell1118.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1118.setExtraParagraphSpace(10f);
		cell1118.setExtraParagraphSpace(10);
		
		
		table31criteria7.addCell(cell1111);// 7.1.10 table
		table31criteria7.addCell(cell1112);
		table31criteria7.addCell(cell11113);
		table31criteria7.addCell(cell11114);
		table31criteria7.addCell(cell1115);
		table31criteria7.addCell(cell1116);
		table31criteria7.addCell(cell11117);
		table31criteria7.addCell(cell1118);

		PdfPCell cell076 = new PdfPCell(new Paragraph(
				"7.1.10 The Institution has a prescribed code of conduct for students, teachers, \r\n"
				+ "administrators and other staff and conducts periodic programmes in this \r\n"
				+ "regard.\r\n"
						+ "1. The institutional Code of Conduct principles are displayed on the website \r\n"
						+ "2.	There is a committee to monitor adherence to the Code of Conduct\r\n"
						+ "3.	Institution organizes professional ethics programmes for students, teachers, administrators and other staff\r\n"
						+ "4.	Annual awareness programmes on Code of Conduct are organized\r\n" 
						+ "Response:\r\n"+
					 (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse7110()
								: ""),
				font4));
		cell076.setExtraParagraphSpace(10f);

		table31criteria74.addCell(cell076);

//		table31criteria74.addCell(table31criteria7);



		document.add(table31criteria74);
		
		
		table31criteria7.setSpacingBefore(20f);
		table31criteria7.setSpacingAfter(20f);
		
		document.add(table31criteria7);
		
		
		PdfPTable table31criteria0074 = new PdfPTable(1);

		table31criteria0074.setWidthPercentage(100);
		
		
		
		PdfPCell cell0716 = new PdfPCell(new Paragraph(
				"7.1.11 Institution celebrates / organizes national and international commemorative days, events and\r\n"
						+ "festivals (within 500 words)"  + "Response: "+
						(criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse7111()
								: ""),
				font4));
		cell0716.setExtraParagraphSpace(10f);
		//
		table31criteria0074.addCell(cell0716);
		
	//	document.add(table31criteria0074);
		
		
		

		PdfPTable table7111criteria7 = new PdfPTable(1);
		table7111criteria7.setWidthPercentage(100f);

		PdfPCell cell7111criteria7 = new PdfPCell(new Paragraph(
				"7.1.11 Institution celebrates / organizes national and international commemorative days, events and festivals (within 500 words).\r\n"
						+ "\r\n" + "Response:"+
						 (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse7111()
								: ""),
				font4));
		cell7111criteria7.setExtraParagraphSpace(10);
		table7111criteria7.addCell(cell7111criteria7);
//		table7111criteria7.setSpacingBefore(20f);
//		table7111criteria7.setSpacingAfter(20f);

		document.add(table7111criteria7);
		

	
		
		// table 4
		PdfPTable table4criteria7 = new PdfPTable(2);
		table4criteria7.setWidthPercentage(100);

		com.lowagie.text.Font font14 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font14.setColor(CMYKColor.BLACK);
		PdfPCell cell1119criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
		cell1119criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1120criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
		cell1120criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1121criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of some of the events\r\n", font5));
		cell1121criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell1122criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(24).getCriteria7FilePath() : ""), font5));
		cell1122criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1122criteria7.setExtraParagraphSpace(10);
		
		PdfPCell cell1123criteria7 = new PdfPCell(new Paragraph(
				"Annual report of the celebrations and\r\n" + "commemorative events for the last five years\r\n", font5));
		cell1123criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell1124criteria7 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(25).getCriteria7FilePath() : ""), font5));
		cell1124criteria7.setExtraParagraphSpace(10);
		cell1124criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		table4criteria7.addCell(cell1119criteria7);
		table4criteria7.addCell(cell1120criteria7);
		table4criteria7.addCell(cell1121criteria7);
		table4criteria7.addCell(cell1122criteria7);
		table4criteria7.addCell(cell1123criteria7);
		table4criteria7.addCell(cell1124criteria7);

		table4criteria7.setSpacingBefore(20f);
		table4criteria7.setSpacingAfter(20f);

		document.add(table4criteria7);
		
		// 7.2 
		Paragraph paragraph46criteria7 = new Paragraph("7.2 Best Practices\r\n", font2);
		paragraph46criteria7.setSpacingBefore(3f);
		paragraph46criteria7.setSpacingAfter(4f);
		document.add(paragraph46criteria7);
		
		
		
		

		PdfPTable table721criteria7 = new PdfPTable(1);
		table721criteria7.setWidthPercentage(100f);

		

		PdfPCell cell1123criteria71 = new PdfPCell(new Paragraph(
				"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format provided in the Manual.\r\n"
					 + "Response:",font4));
		
		cell1123criteria71.setExtraParagraphSpace(5F);
		table721criteria7.addCell(cell1123criteria71);
		
		
		
		
		if(criteria7Record.getCriteria72Ql() !=null)
		{
			PdfPCell cell1123criteria7199 = new PdfPCell( new Paragraph(criteria7Record != null
								? criteria7Record.getCriteria72Ql().get(0).getResponse721()
								: "",font4));
			
			cell1123criteria7199.setExtraParagraphSpace(10);
   
			table721criteria7.addCell(cell1123criteria7199);	
		}
		
		document.add(table721criteria7);
		

		PdfPTable table5criteria7 = new PdfPTable(2);
		table5criteria7.setWidthPercentage(100);

		PdfPCell cell1110 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
		cell1110.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1134 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
		cell1134.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		PdfPCell cell1135 = new PdfPCell(new Paragraph("Best practices in the Institutional web site\r\n\r\n ",font5));
		cell1135.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1136 = new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
		cell1136.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1137 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n ",font5));
		cell1137.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell1138= new PdfPCell(
				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
		
		cell1138.setExtraParagraphSpace(10);
		cell1138.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table5criteria7.addCell(cell1110);
		table5criteria7.addCell(cell1134);
		 table5criteria7.addCell(cell1135);
		 table5criteria7.addCell(cell1136);
		 table5criteria7.addCell(cell1137);
		 table5criteria7.addCell(cell1138);

		
		table5criteria7.setSpacingBefore(20f);
		table5criteria7.setSpacingAfter(20f);

		document.add(table5criteria7);
		
		// 7.3
//		Paragraph paragraph88 = new Paragraph("7.3 Institutional Distinctiveness\r\n", font2);
//		document.add(paragraph88);
//		
//
//		PdfPTable table5criteria117 = new PdfPTable(1);
//		table5criteria117.setWidthPercentage(100);
//		
//		PdfPCell cell113511 = new PdfPCell(new Paragraph(new Paragraph(
//				"7.3.1 Portray the performance of the Institution in one area distinctive to its priority and thrust\r\n"
//						+ "within 1000 words\r\n"  + "Response: " ,font4)));
//		cell113511.setExtraParagraphSpace(10);
//		
//		table5criteria117.addCell(cell113511);
//		
//		
//		
//		if(criteria7Record.getCriteria73Ql() !=null)
//		{
//			PdfPCell cell11351111 = new PdfPCell(new Paragraph( (criteria7Record != null
//								? criteria7Record.getCriteria73Ql().get(0).getResponse731()
//								: ""),font4));
//			cell11351111.setExtraParagraphSpace(10);	
//			
//			table5criteria117.addCell(cell11351111);
//		}
//
//document.add(table5criteria117);
//		
//		
//		
//		PdfPTable table05criteria7 = new PdfPTable(2);
//		table05criteria7.setWidthPercentage(100);
//
//		PdfPCell cell110 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
//		cell110.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		PdfPCell cell134 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
//		cell134.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		PdfPCell cell135 = new PdfPCell(new Paragraph("Appropriate web in the Institutional website\r\n\r\n ",font5));
//		cell135.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		PdfPCell cell136 = new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
//		cell136.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell136.setExtraParagraphSpace(10);	
//		
//		
//		PdfPCell cell137 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n ",font5));
//		cell137.setHorizontalAlignment(Element.ALIGN_CENTER);
//		
//		
//		PdfPCell cell138= new PdfPCell(
//				new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
//		cell138.setHorizontalAlignment(Element.ALIGN_CENTER);
//		cell138.setExtraParagraphSpace(10);	
//		
//		table05criteria7.addCell(cell110);
//		table05criteria7.addCell(cell134);
//		 table05criteria7.addCell(cell135);
//		 table05criteria7.addCell(cell136);
//		 table05criteria7.addCell(cell137);
//		 table05criteria7.addCell(cell138);
//
//		
//		table05criteria7.setSpacingBefore(20f);
//		table05criteria7.setSpacingAfter(20f);
//
//		document.add(table05criteria7);
//		
		
	 }

}
