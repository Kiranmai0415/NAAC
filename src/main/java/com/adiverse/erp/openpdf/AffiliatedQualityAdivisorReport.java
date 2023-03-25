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
import org.springframework.stereotype.Component;
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
import com.adiverse.erp.model.QIAIndicator3;
import com.adiverse.erp.model.QIAIndicatorMain;
import com.adiverse.erp.model.QIAIndicator_FileUpload;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.Cell;
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

@Service
public class AffiliatedQualityAdivisorReport {


		
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
	ExtendedService extendedService;
	@Autowired
	SsrService ssrService;
	
	@Autowired
	QiaService qiservice;	
	
	@Autowired
	ExecutiveService  executiveService;
	
	@Autowired
	EvalutiveReportService evalutiveReportService;
	
	
	@Autowired
   AffiliatedIiqaReport  affiliatedIiqaReport;
	
	
	
	List<ExecutiveSummary>executiveSummary1 = null;
	ExecutiveSummary executiveSummary = null;
	
	List<Executive_FileUpload> executive_FileUpload1 = null;
	Executive_FileUpload executive_FileUpload = null;
	

	

	List<Criteria1_FieldInfo> criteria1List = null;
	Criteria1_FieldInfo criteria1Record = null;
	List<Criteria1_FileUpload> criteria1file = null;

	List<Criteria2_FieldInfo> criteria2List = null;
	Criteria2_FieldInfo criteria2Record = null;
	List<Criteria2_FileUpload> criteria2file = null;


	List<QIAIndicatorMain> qIAIndicator= null;
	QIAIndicatorMain qiadata = null;
	List<QIAIndicator_FileUpload>qIAIndicatorfile= null;
	List<QIAIndicator2> qIAIndicator1= null;
	List<QIAIndicator3> qIAIndicator3 = null;
	
	

	
	List<Criteria3_FieldInfo> criteria3List = null;

	Criteria3_FieldInfo criteria3Record = null;
	List<Criteria3_FileUpload> criteria3file = null;
//	List<Criteria3_FieldInfoQn> criteria3Fieldinfo=null;
//	List<Criteria3_FieldInfoQl> criteria3_FieldInfoQlList=null;
//	List <Criteria3_FieldInfo> criteria3Fieldinfo =null;
	
	
	

	List<Criteria4_FieldInfo> criteria4List = null;
	Criteria4_FieldInfo criteria4Record = null;
	List<Criteria4_FileUpload> criteria4file = null;
	


	List<Criteria5_FieldInfo> criteria5List = null;
	Criteria5_FieldInfo criteria5Record = null;
	List<Criteria5_FileUpload> criteria5file = null;

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
	ExtendedProfile extendedProfile = null;
	// List<Criteria7_FileUpload> criteria7file =
	// criteria7Record.getCriteria7FileUpload();
	

	List<EvaluativereportMain> evaluativereportMain1 = null;
	EvaluativereportMain evaluativereportofthedepartment = null;

	
	
	
	
		@Value("${upload.files.path}")
		private String reportGeneratePath;

		
		
		public String generateReport( Map<String, String> allParams  ) throws DocumentException, IOException {
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
				
				
				ObjectMapper mapper=new ObjectMapper();
				
				
				Font font0 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
				font0.setSize(16);

				Font font1criteria3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
				font1criteria3.setSize(14);

				Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
				font2.setSize(12);
				

				profileList=ssrService.getAllAcademicData(allParams);
				if (CollectionUtils.isNotEmpty(profileList)) {
					ProfileRecord = profileList.get(0);
				} else {
					ProfileRecord = new ProfileoftheCollege();
				}
				
				executiveSummary1=	executiveService.getAllExecutiveData(allParams);
				if (CollectionUtils.isNotEmpty(executiveSummary1)) {
					executiveSummary = executiveSummary1.get(0);
				} else {
					executiveSummary = new ExecutiveSummary();
				}
				

				
				epList = extendedService.getAllExtendedData(allParams);
				if (CollectionUtils.isNotEmpty(epList)) {
					extendedProfile = epList.get(0);
				} else {
					extendedProfile = new ExtendedProfile();
				}

				criteria1List = service1.getAllCriteria1Data(allParams);
				if (CollectionUtils.isNotEmpty(criteria1List)) {
					criteria1Record = criteria1List.get(0);
					criteria1file = criteria1Record.getCriteria1FileUpload();
				} else {
					criteria1Record = new Criteria1_FieldInfo();
					criteria1file = new ArrayList<Criteria1_FileUpload>();
				}
				

				evaluativereportMain1=	evalutiveReportService.getAllEvaluativeData(allParams);
				if (CollectionUtils.isNotEmpty(evaluativereportMain1)) {
					evaluativereportofthedepartment = evaluativereportMain1.get(0);
				} else {
					evaluativereportofthedepartment = new EvaluativereportMain();
				}
				
				
				
//				List<QIAIndicatorMain> qIAIndicator= null;
//				QIAIndicatorMain qiadata = null;
//				List<QIAIndicator2> qIAIndicator1= null;
//				List<QIAIndicator_FileUpload> qIAIndicator1;
				qIAIndicator = qiservice.getAllQiaFiles(allParams);
				if (CollectionUtils.isNotEmpty(qIAIndicator)) {
					qiadata = qIAIndicator.get(0);
//					qIAIndicatorfile = qIAIndicator.getCriteria2FileUpload();
					qIAIndicator1	=	qiadata.getQiaIndicator2();
				} else {
					criteria2Record = new Criteria2_FieldInfo();
				}

				
				

				criteria2List = service2.getAllCriteria2Data(allParams);
				if (CollectionUtils.isNotEmpty(criteria2List)) {
					criteria2Record = criteria2List.get(0);
					criteria2file = criteria2Record.getCriteria2FileUpload();
				} else {
					criteria2Record = new Criteria2_FieldInfo();
				}


				criteria3List = service3.getAllCriteria3Data(allParams);
				if (CollectionUtils.isNotEmpty(criteria3List)) {
					criteria3Record = criteria3List.get(0);
					criteria3file = criteria3Record.getCriteria3FileUpload();
					
				} else {
				
					criteria3Record = new Criteria3_FieldInfo();
				}
				
//				System.out.println("sfasdfdasdfasfdasdfasdfasdfasdfasdf"+criteria3Fieldinfo);
//				System.out.println("999999999999999999999999999"+criteria3_FieldInfoQlList);
//				System.out.println("criteria3file==>"+criteria3file);

				

				criteria4List = service4.getAllCriteria4Data(allParams);
				if (CollectionUtils.isNotEmpty(criteria4List)) {
					criteria4Record = criteria4List.get(0);
					criteria4file = criteria4Record.getCriteria4FileUpload();
				} else {
					criteria4Record = new Criteria4_FieldInfo();
					criteria4file = new ArrayList<>();
				}
				
			
				
				criteria5List = service5.getAllCriteria5Data(allParams);
				if (CollectionUtils.isNotEmpty(criteria5List)) {
					criteria5Record = criteria5List.get(0);
					criteria5file = criteria5Record.getCriteria5FileUpload();
				} else {
					criteria5Record = new Criteria5_FieldInfo();
					criteria5file = new ArrayList<Criteria5_FileUpload>();
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
	

				System.out.println("report generation path from property file ==>" + reportGeneratePath);
				if (root != null) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
					String strDate = formatter.format(date);
					reportPath = "AffiliatedqualityAdivsorReport-" + strDate + ".pdf";
					file = root.resolve(reportPath);
				}
				System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
				
				Document document = new Document(PageSize.A4);
				// PdfWriter.getInstance(document, response.getOutputStream());
				PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
				
				document.open();
				System.out.println("open the document==========>");
			//	addLogo(document);
				
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
	//    Executive(document, executiveSummary);
		Ssr(document, executiveSummary);
	//	ProfileoftheCollege(document,ProfileRecord);
		EvalutionReport(document, evaluativereportofthedepartment);
		
		  Iiqa(document, qiadata);
     Criteria1(document, criteria1Record);
  Criteria2(document, criteria2Record);
 	  Criteria3(document, criteria3Record);
  Criteria4(document, criteria4Record);
	 Criteria5(document, criteria5Record);
   	Criteria6(document, criteria6Record);
	 Criteria7(document, criteria7Record);

				document.close();
	//////////////////////////////////////////////////////////////////////////////////////////////////			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return file.toAbsolutePath().toString();
		}

//		private void addLogo(Document document) {
//			Path root = Paths.get(reportGeneratePath);
//			Path file = null;
//			try {
//				file = root.resolve("naac.png");
//				Image img = Image.getInstance(file.toAbsolutePath().toString());
//				img.scalePercent(logoImgScale[0], logoImgScale[1]);
//				img.setAlignment(Element.ALIGN_CENTER);
//				document.add(img);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

//		public void Executive(Document document,ExecutiveSummary executiveData) {
//			
//			Paragraph paragraph20ssr = new Paragraph("1.EXECUTIVE SUMMARY", font1);
//			Paragraph paragraph21ssr = new Paragraph("1.Introductory Note on the Institution", font2);
//			paragraph20ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			paragraph20ssr.setAlignment(Paragraph.ALIGN_CENTER);
//			document.add(paragraph20ssr);
//			document.add(paragraph21ssr);
//
////			Paragraph paragraph22ssr = new Paragraph(
////					"Mother Teresa Institute of Science and Technology (MIST), Khammam -\r\n" + "\r\n", font5);
////			Paragraph paragraph23ssr = new Paragraph(
////					"was established in 2001. The college is an ISO 9001:2008 certified institute and is permanently affiliated to Jawaharlal Nehru Technological University, Hyderabad.\r\n"
////							+ "\r\n" ,
////					font5);
////			Paragraph paragraph24ssr = new Paragraph(
////					"Mother Teresa Institute of Science and Technology (MIST) was founded through MCM Educational Society in 2001 by eminent philanthropist,industrialists and schloars , MIST  aims at co-creating value-based technical excellence, which ultimately leads to the development of the rural area where the college is situated. From a modest intake of 180 students across 3 engineering programs in B.Tech, namely ECE, CSE, and IT, MIST, in less than 2 decades, it has grown into an institution of gigantic proportions with massive infrastructure, besides multitude of students, faculty & staff. At present, we offer 6 B.Tech programmes in CSE,  ECE, EEE, ME, CE, MNG., 5 M.Tech programmes such as CSE, Power Electronics and Drives ,ECE,Advance Manufacturing Systems,Structural Engg. in addition to M.B.A  programme as first shift and introduced 2nd shift diploma in A.Y:2009,with the Branches CE,EEE,ME,ECE and Mining. MIST has a vibrant campus spread over 30 acres of serene and natural surroundings with plenty of greenery in SATHUPALLY, Khammam  District, Telangana. It has world class infrastructure in all its academic departments, besides an asthetically-designed administrative block. The major facilities include  e-class rooms,  well-equipped laboratories,seminar halls ,well stocked library,WI-FI enabled campus,Backup power supply,Canteen etc. MIST was approved by All india Counsil for Technical Education AICTE New Delhi,  Affliated to Jawaharlal Nehru Technological University Hyderabad , JNTUH and State Board of Technical Education and Training SBTET Recognized by Govt.of Telangana, UGC under Section 2(f) and 12(B) and Accrediated by NAAC  with 'B' Grade. MIST has been recognized as a remote center of IIT BOMBAY and KARAGPUR for organizing FDP’S ,WORKSHOPS,QIP’S for students and faculty.We pride ourselves as an institution with a large pool of well-qualified and experienced faculty who not only enrich our teaching-learning sphere but also contribute to the R&D ecosystem. The promoters of the MIST started the college with a vision to empower students to become technologically vibrant, innovative and emotionally matured to face the dynamic challenges of a quality-conscious global economy. They are socially-conscious and respond proactively to the needs and requirements of this region on a continuous basis. The managing trust is involved in many charitable activities to help the needy and the poor of this region, thereby contribute towards social development of the region.\r\n\r\n",
////					font5);
//
//			Paragraph paragraph22ssr = new Paragraph(executiveData != null ?executiveData.getInputes1():
//					"", font5);
////			Paragraph paragraph23ssr = new Paragraph(
////					"was established in 2001. The college is an ISO 9001:2008 certified institute and is permanently affiliated to Jawaharlal Nehru Technological University, Hyderabad.\r\n"
////							+ "\r\n" ,
////					font5);
////			Paragraph paragraph24ssr = new Paragraph(
////					"Mother Teresa Institute of Science and Technology (MIST) was founded through MCM Educational Society in 2001 by eminent philanthropist,industrialists and schloars , MIST  aims at co-creating value-based technical excellence, which ultimately leads to the development of the rural area where the college is situated. From a modest intake of 180 students across 3 engineering programs in B.Tech, namely ECE, CSE, and IT, MIST, in less than 2 decades, it has grown into an institution of gigantic proportions with massive infrastructure, besides multitude of students, faculty & staff. At present, we offer 6 B.Tech programmes in CSE,  ECE, EEE, ME, CE, MNG., 5 M.Tech programmes such as CSE, Power Electronics and Drives ,ECE,Advance Manufacturing Systems,Structural Engg. in addition to M.B.A  programme as first shift and introduced 2nd shift diploma in A.Y:2009,with the Branches CE,EEE,ME,ECE and Mining. MIST has a vibrant campus spread over 30 acres of serene and natural surroundings with plenty of greenery in SATHUPALLY, Khammam  District, Telangana. It has world class infrastructure in all its academic departments, besides an asthetically-designed administrative block. The major facilities include  e-class rooms,  well-equipped laboratories,seminar halls ,well stocked library,WI-FI enabled campus,Backup power supply,Canteen etc. MIST was approved by All india Counsil for Technical Education AICTE New Delhi,  Affliated to Jawaharlal Nehru Technological University Hyderabad , JNTUH and State Board of Technical Education and Training SBTET Recognized by Govt.of Telangana, UGC under Section 2(f) and 12(B) and Accrediated by NAAC  with 'B' Grade. MIST has been recognized as a remote center of IIT BOMBAY and KARAGPUR for organizing FDP’S ,WORKSHOPS,QIP’S for students and faculty.We pride ourselves as an institution with a large pool of well-qualified and experienced faculty who not only enrich our teaching-learning sphere but also contribute to the R&D ecosystem. The promoters of the MIST started the college with a vision to empower students to become technologically vibrant, innovative and emotionally matured to face the dynamic challenges of a quality-conscious global economy. They are socially-conscious and respond proactively to the needs and requirements of this region on a continuous basis. The managing trust is involved in many charitable activities to help the needy and the poor of this region, thereby contribute towards social development of the region.\r\n\r\n",
////					font5);
////			
//			paragraph22ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//		//	paragraph23ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph22ssr);
//		//	document.add(paragraph23ssr);
//
////			paragraph24ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			document.add(paragraph24ssr);
//
//			Paragraph paragraph25ssr = new Paragraph("VISION", font3);
//			paragraph25ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph25ssr);
//			
//			
//
////			Paragraph paragraph26ssr = new Paragraph(
////					"To provide the society with center of learning that motivates, supports and encourages the youth to involve into dynamic professional with a social commitmenty.\r\n"
////							+ "\r\n",
////				//	font5);
//
//			Paragraph paragraph26ssr = new Paragraph(executiveData != null ?executiveData.getInputes2():"");
//			
//			paragraph26ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph26ssr);
//
//			Paragraph paragraph27ssr = new Paragraph("MISSION", font3);
//			paragraph27ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph27ssr);
//
////			Paragraph paragraph28ssr = new Paragraph(
////					"We dedicate and commitment ourselves to achieve, sustain and    foster unmatched excellence in technical education.  To this end, we will pursue continuous development of infrastructure and enhance state of the art equipment to provide our students a technology up to date and intellectually inspiring environment of learning, research, creativity, innovation and professional activity, inculcate in them ethical and moral values. The institute is committed to build a better nation through quality education with team sprit. Our students are enable to excel values of life and become good citizens. We inspire the system, infrastructure and services to satisfy the students, parents, industry and society.\r\n"
////							+ "\r\n" + "\r\n" + "\r\n",
////					font5);
//			Paragraph paragraph28ssr = new Paragraph(executiveData != null ?executiveData.getInputes3(): "",font5);
//			
//			paragraph28ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph28ssr);
//			
//			
//			
//			Paragraph paragraph27ssr1 = new Paragraph("Location:", font3);
//			paragraph27ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph27ssr1);
//
//			Paragraph paragraph28ssr1 = new Paragraph(executiveData != null ?executiveData.getInputes4(): "",font5);
//			
//			paragraph28ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph28ssr1);
//			
//			Paragraph paragraph27ssr11 = new Paragraph("Type of the Institution:", font3);
//			paragraph27ssr11.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph27ssr11);
//
//			Paragraph paragraph28ssr11 = new Paragraph(executiveData != null ?executiveData.getInputes5(): "",font5);
//			
//			paragraph28ssr11.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph28ssr11);
//			
//			Paragraph paragraph27ssr111 = new Paragraph("File upload:", font3);
//			paragraph27ssr111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph27ssr111);
//
//			Paragraph paragraph28ssr111 = new Paragraph(executive_FileUpload != null ?executive_FileUpload.getExecutiveFilePath(): "",font5);
//			
//			paragraph28ssr111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph28ssr111);
//					
//			Paragraph paragraph27ssr1111 = new Paragraph("2.Criterion-wise Summary on the Institution:", font3);
//			paragraph27ssr1111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph27ssr1111);
//
//			Paragraph paragraph28ssr1111 = new Paragraph(executiveData != null ?executiveData.getInputes7(): "",font5);
//			
//			paragraph28ssr1111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph28ssr1111);
//			
//			
//			Paragraph paragraph27ssr11111 = new Paragraph("3.Brief note on the Strength Weakness Opportunities and Challenges(SWOC) in respect of the Institution:", font3);
//			paragraph27ssr11111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph27ssr11111);
//
//			Paragraph paragraph28ssr11111 = new Paragraph(executiveData != null ?executiveData.getInputes8(): "",font5);
//			
//			paragraph28ssr11111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph28ssr11111);
//			
//			
//			Paragraph paragraph27ssr111111 = new Paragraph("4.Any additional information about the Institution other than ones already stated.:", font3);
//			paragraph27ssr111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph27ssr111111);
//
//			Paragraph paragraph28ssr111111 = new Paragraph(executiveData != null ?executiveData.getInputes9(): "",font5);
//			
//			paragraph28ssr111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph28ssr111111);
//				
//			Paragraph paragraph27ssr1111111 = new Paragraph("5.Over all conclusive explication about the institution's functioning:", font3);
//			paragraph27ssr1111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph27ssr1111111);
//
//			Paragraph paragraph28ssr1111111 = new Paragraph(executiveData != null ?executiveData.getInputes9(): "",font5);
//			
//			paragraph28ssr1111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph28ssr1111111);
//		}
			
			
	////////////////////////////////////////////////////////////////////profile of the program
			
	
	/*	public void ProfileoftheCollege(Document document,ProfileoftheCollege ProfileRecord) {
			
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
			cell02ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
			table02ssr.addCell(cell02ssr);
			
	//		table02ssr.setSpacingAfter(20f);
			table02ssr.setSpacingBefore(20f);
			document.add(table02ssr);
			
//
//			PdfPTable table2ssr = new PdfPTable(6);
//			table2ssr.setWidthPercentage(100f);
//			table2ssr.setWidths(new int[] { 70, 70, 70, 70, 70, 70 });
//		
//			table2ssr.setSpacingAfter(20f);
//
//			PdfPCell cell = new PdfPCell();
//
//			cell.setPhrase(new Phrase("Designation\r\n", font3));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase("Name\r\n\r\n", font3));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase("Telephone with STD Code\r\n\r\n", font3));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase("Mobile\r\n\r\n", font3));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase("Fax\r\n\r\n", font3));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase("Email\r\n\r\n", font3));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase("Principal\r\n", font3));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc2(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc3(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc4(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc5(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc6(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase("Vice Principal\r\n", font3));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(1).getInputbtc2(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(1).getInputbtc3(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(1).getInputbtc4(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(1).getInputbtc5(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(1).getInputbtc6(): ""));
//			table2ssr.addCell(cell);
//			
//			cell.setPhrase(new Phrase("IQAC Co-ordinator\r\n", font3));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(2).getInputbtc2(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(2).getInputbtc3(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(2).getInputbtc4(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(2).getInputbtc5(): ""));
//			table2ssr.addCell(cell);
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(2).getInputbtc6(): ""));
//			table2ssr.addCell(cell);
//			
//			table2ssr.setSpacingAfter(20f);
//			document.add(table2ssr);
			
			////////////////////////
			PdfPTable table2ssr = new PdfPTable(6);
			table2ssr.setWidthPercentage(100f);
			table2ssr.setWidths(new int[] { 70, 70, 70, 70, 70, 70 });
		//	table2ssr.setSpacingBefore(20f);
			table2ssr.setSpacingAfter(20f);

			PdfPCell cell = new PdfPCell();

			cell.setPhrase(new Phrase("Designationedfv cads vfcd bhgjnjngnf yujhjhgb\r\n", font3));
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
			cell.setPhrase(new Phrase("Principal\r\n", font3));
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
			cell.setPhrase(new Phrase("Vice Principal\r\n", font3));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(1).getInputbtc2(): ""));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(1).getInputbtc3(): ""));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(1).getInputbtc4(): ""));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(1).getInputbtc5(): ""));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(1).getInputbtc6(): ""));
			table2ssr.addCell(cell);
			
			cell.setPhrase(new Phrase("IQAC Co-ordinator\r\n", font3));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(2).getInputbtc2(): ""));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(2).getInputbtc3(): ""));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(2).getInputbtc4(): ""));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(2).getInputbtc5(): ""));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(2).getInputbtc6(): ""));
			table2ssr.addCell(cell);
			
			table2ssr.setSpacingAfter(20f);
			document.add(table2ssr);

//			cell.setPadding(5);
			document.add(table2ssr);

			//////////////////////////////////////
			

			PdfPTable table03ssr = new PdfPTable(1);
			table03ssr.setWidthPercentage(100f);

			PdfPCell cell03ssr = new PdfPCell(new Paragraph("3. Status of the Institution: Affiliated College constituent College Any other (specify)\r\n\r\n", font3));
			table03ssr.addCell(cell03ssr);
			PdfPCell cell0312ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst1(): ""));
		    table03ssr.addCell(cell0312ssr);
			PdfPTable table3ssr = new PdfPTable(2);
			table3ssr.setWidthPercentage(100f);
			table3ssr.setWidths(new int[] { 70, 70});
			table3ssr.setSpacingBefore(20f);
			table3ssr.setSpacingAfter(20f);

			PdfPCell cell13ssr = new PdfPCell(new Paragraph("4.Type of Institution:\r\n\r\n"));
			table3ssr.addCell(cell13ssr);

//			PdfPCell cell14ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).inputst2(): ""));
//			table3ssr.addCell(cell14ssr);

	//		table03ssr.addCell(table3ssr);
			document.add(table03ssr);
			table03ssr.setSpacingAfter(20f);
			document.add(table3ssr);

			PdfPTable table04ssr = new PdfPTable(1);
			table04ssr.setWidthPercentage(100f);

//			PdfPCell cell04ssr = new PdfPCell(new Paragraph("Type of Institution\r\n\r\n", font3));
	//
//			
//			table04ssr.addCell(cell04ssr);
		
			PdfPTable table4ssr = new PdfPTable(2);
			table4ssr.setWidthPercentage(100f);
			table4ssr.setWidths(new int[] { 3, 3 });
			table4ssr.setSpacingBefore(20f);
			table4ssr.setSpacingAfter(20f);

			PdfPCell cell15ssr = new PdfPCell(new Paragraph("By Gender\r\n\r\n"));
			table4ssr.addCell(cell15ssr);

			PdfPCell cell16ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst2(): ""));
			table4ssr.addCell(cell16ssr);

			PdfPCell cell17ssr = new PdfPCell(new Paragraph("By Shift\r\n\r\n"));
			table4ssr.addCell(cell17ssr);

			PdfPCell cell18ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst3(): ""));


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
			PdfPCell cell20ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst4(): ""));
			table5ssr.addCell(cell20ssr);
			
			
			
			PdfPCell cell0722ssr = new PdfPCell(new Paragraph("6. Source of funding: Government Grant-in-aid Self-finacing Any other\n\r\n"));
			table5ssr.addCell(cell0722ssr);
			PdfPCell cell2022ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst5(): ""));
			table5ssr.addCell(cell2022ssr);
			
			
			

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

			PdfPCell cell22ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst6(): ""));
			table6ssr.addCell(cell22ssr);

			PdfPCell cell23ssr = new PdfPCell(new Paragraph("b. University to which the college is affiliated / or which governs the college (If it is a constituent college)\r\n\r\n"));
			table6ssr.addCell(cell23ssr);

			PdfPCell cell24ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst7(): ""));
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

			PdfPCell cell09ssr = new PdfPCell(new Paragraph("c. Details of UGC recognition:\r\n\r", font3));
			table07ssr.addCell(cell09ssr);

			PdfPTable table7ssr = new PdfPTable(3);
			table7ssr.setWidthPercentage(100f);

			table7ssr.setSpacingBefore(20f);
			table7ssr.setSpacingAfter(20f);

			cell.setPhrase(new Phrase("Under Section\r\n", font3));
			table7ssr.addCell(cell);
			cell.setPhrase(new Phrase("Date, Month & Year (dd-mm-yyyy)\r\n", font3));
			table7ssr.addCell(cell);
			cell.setPhrase(new Phrase("Remarks(If any)\r\n", font3));
			table7ssr.addCell(cell);
			
			cell.setPhrase(new Phrase("i. 2(f)\r\n", font3));
			table7ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getDetailsofUgcRecognition().get(0).getInputst9(): ""));
			table7ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getDetailsofUgcRecognition().get(0).getInputst10(): ""));
			table7ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("i. 2(B)\r\n", font3));
			table7ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getDetailsofUgcRecognition().get(1).getInputst9(): ""));
			table7ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getDetailsofUgcRecognition().get(1).getInputst10(): ""));
			table7ssr.addCell(cell);
			
			
			document.add(table7ssr);
			
			
			




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

			
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(1).getInputbtd15():""));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(1).getInputbtd11():""));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(1).getInputbtd12():""));
			table9ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(1).getInputbtd13():""));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(1).getInputbtd14():""));
			table9ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(2).getInputbtd15():""));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(2).getInputbtd11():""));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(2).getInputbtd12():""));
			table9ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(2).getInputbtd13():""));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(2).getInputbtd14():""));
			table9ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(3).getInputbtd15():""));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(3).getInputbtd11():""));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(3).getInputbtd12():""));
			table9ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(3).getInputbtd13():""));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(3).getInputbtd14():""));
			table9ssr.addCell(cell);
			
			
			
			
			
			
			
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd16():""));
//			table9ssr.addCell(cell);


			cell.setPadding(5);
			table09ssr.addCell(table9ssr);
			document.add(table09ssr);
			table09ssr.setSpacingAfter(20f);
			table09ssr.setSpacingBefore(20f);

			table010ssr.addCell(table07ssr);
//			table010ssr.addCell(table08ssr);
			table010ssr.addCell(table09ssr);
			table010ssr.setSpacingAfter(20f);
			table010ssr.setSpacingBefore(20f);
			
			
			Paragraph paragraph1366ssr = new Paragraph("8. Does the affiliating university Act provide for conferment of autonomy (as recognized by the UGC), on its affiliated colleges?",font3);
			document.add(paragraph1366ssr);
			
			Paragraph paragraph13660ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst8():"");
			document.add(paragraph13660ssr);
			
			Paragraph paragraph1367ssr = new Paragraph("If yes, has the College applied for availing the autonomous status?",font3);
			document.add(paragraph1367ssr);
			Paragraph paragraph13671ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst11 ():"");
		    document.add(paragraph13671ssr);
			
					Paragraph paragraph1368ssr = new Paragraph("9. Is the college recognized"
							+"\r\n",font3);
					document.add(paragraph1368ssr);
					Paragraph paragraph13681ssr = new Paragraph("a. by UGC as a College with Potential for Excellence (CPE)?",font3);
					document.add(paragraph13681ssr);
					Paragraph paragraph13682ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst12():"");
							document.add(paragraph13682ssr);
			
				   Paragraph paragraph1369ssr = new Paragraph("If yes, date of recognition:....(dd/mm/yyyy)");
				   document.add(paragraph1369ssr);
				   Paragraph paragraph13691ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst13():""+"\r\n"+ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst14():"",font3);
					document.add(paragraph13691ssr);
				
			
			
			
					Paragraph paragraph13632ssr = new Paragraph("b. For its performance by any other governmental agency?",font3);
					document.add(paragraph13632ssr);
					
					Paragraph paragraph136321ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst15():"");
					document.add(paragraph136321ssr);
											
					Paragraph paragraph13633ssr = new Paragraph("If yes, Name of the agency.....",font3);
					document.add(paragraph13633ssr);
					Paragraph paragraph136332ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst16():"");
					document.add(paragraph136332ssr);						

					Paragraph paragraph13634ssr = new Paragraph("If yes, Name of the agency.....",font3);
					document.add(paragraph13634ssr);
					Paragraph paragraph13635ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst17():"");
					document.add(paragraph13635ssr);						
					
					
					
			
			
			

			PdfPTable table011ssr = new PdfPTable(1);
			table011ssr.setWidthPercentage(100f);
			PdfPCell cell011ssr = new PdfPCell(new Paragraph("10. Location of the campus and area in sq.mts:\r\n\r\n", font3));
			table01ssr.addCell(cell011ssr);
			PdfPTable table11ssr = new PdfPTable(2);
			table11ssr.setWidthPercentage(100f);
			table11ssr.setWidths(new int[] { 3, 3 });
			
			table11ssr.setSpacingBefore(20f);
			table11ssr.setSpacingAfter(20f);

			PdfPCell cell30ssr = new PdfPCell(new Paragraph(
					"Location"));
			table11ssr.addCell(cell30ssr);

			PdfPCell cell31ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedCampus().get(0).getInputst18():""));
			table11ssr.addCell(cell31ssr);

			PdfPCell cell32ssr = new PdfPCell(new Paragraph(
					"Campus area in sq.mts." + "\r\n"));
			table11ssr.addCell(cell32ssr);

			PdfPCell cell28ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedCampus().get(0).getInputst19():""));
			table11ssr.addCell(cell28ssr);

			PdfPCell cell29ssr = new PdfPCell(new Paragraph("Built up area in sq.mts.\r\n"));
			table11ssr.addCell(cell29ssr);

			PdfPCell cell131ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedCampus().get(0).getInputst20():""));
			table11ssr.addCell(cell131ssr);

//			PdfPCell cell132ssr = new PdfPCell(new Paragraph("Date of recognition\r\n\r\n"));
//			table11ssr.addCell(cell132ssr);
	//
//			PdfPCell cell133ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getBasicprofile2().get(0).getInputbtip6():""));
//			table11ssr.addCell(cell133ssr);

			table011ssr.addCell(table11ssr);
			document.add(table011ssr);
			table011ssr.setSpacingAfter(20f);

			PdfPTable table012ssr = new PdfPTable(1);
			table012ssr.setWidthPercentage(100f);

			PdfPCell cell012ssr = new PdfPCell(new Paragraph("11. Details of programmes offered by the college(Give data for current academic year)", font3));
			table012ssr.addCell(cell012ssr);

			PdfPTable table12ssr = new PdfPTable(8);
			table12ssr.setWidthPercentage(100f);
			table12ssr.setWidths(new int[] { 60, 60, 60, 60, 60,60,60,60 });
			table12ssr.setSpacingAfter(20f);
			table12ssr.setSpacingBefore(20f);

			cell.setPhrase(new Phrase("SI.No\r\n\r\n", font3));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("Programme Level\r\n\r\n", font3));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("Name of the Programme/ Course\r\n\r\n", font3));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("Duration\r\n\r\n", font3));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("Entry Qulaification\r\n\r\n", font3));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("Medium of instruction \r\n\r\n", font3));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("Sanctioned/ approved Student strength \r\n\r\n", font3));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("No. of students admitted \r\n\r\n", font3));
			table12ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad1():""));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad11():""));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad12():""));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad13():""));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad14():""));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad15():""));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad16():""));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad17():""));
			table12ssr.addCell(cell);
		
			cell.setPadding(5);

			table012ssr.addCell(table12ssr);
			document.add(table012ssr);
			table012ssr.setSpacingAfter(20f);
			
			
			

			PdfPTable table0122ssr = new PdfPTable(1);
			table0122ssr.setWidthPercentage(100f);

			PdfPCell cell0122ssr = new PdfPCell(new Paragraph("12. Please fill in the following details if applicable:\r\n"
					+ "\r\n"
					+ "", font3));
			table0122ssr.addCell(cell0122ssr);
			
			PdfPCell cell0123ssr = new PdfPCell(new Paragraph("Number of programs"
					+ "\r\n"
					+ "", font3));
			table0122ssr.addCell(cell0123ssr);


			PdfPTable table122ssr = new PdfPTable(2);
			table122ssr.setWidthPercentage(100f);
			
			PdfPCell cell0124ssr = new PdfPCell(new Paragraph("Self-financed programmes offered"));
			table122ssr.addCell(cell0124ssr);
			
			PdfPCell cell0125ssr = new PdfPCell(new Paragraph("New Programmes introduced during the last five years"));
			table122ssr.addCell(cell0125ssr);

			PdfPCell cell0126ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedProgrammes().get(0).getInputpt1():""));
			table122ssr.addCell(cell0126ssr);
			
			PdfPCell cell0127ssr = new PdfPCell(new Paragraph("New Programmes introduced during the last five years"));
			table122ssr.addCell(cell0127ssr);

			PdfPCell cell0128ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedProgrammes().get(0).getInputpt2():""));
			table122ssr.addCell(cell0128ssr);
			
			cell.setPadding(5);

			table0122ssr.addCell(table122ssr);
			document.add(table0122ssr);
			table0122ssr.setSpacingAfter(20f);
			
			//13
			PdfPTable table013ssr = new PdfPTable(1);
			table013ssr.setWidthPercentage(100f);

			PdfPCell cell013ssr = new PdfPCell(new Paragraph("13.List the Departments: (respond if applicable only and do not list facilities like Library, Physical Education as departments, unless they are also offering academic degree awarding programmes. similarly, do not list the departments offering common compulsory subjects for all the programmes. like english, regional languages etc..)\r\n"
					+ "\r\n"
					+ "", font3));
			table0122ssr.addCell(cell013ssr);
			
			PdfPTable table13ssr = new PdfPTable(5);
			table13ssr.setWidthPercentage(100f);
			
			PdfPCell cell0131ssr = new PdfPCell(new Paragraph("Faculty"));
			table13ssr.addCell(cell0131ssr);
			
			
			PdfPCell cell0133ssr = new PdfPCell(new Paragraph("Departments (eg Physics,Botany,History etc."));
			table13ssr.addCell(cell0133ssr);
			PdfPCell cell0134ssr = new PdfPCell(new Paragraph("UG"));
			table13ssr.addCell(cell0134ssr);
			PdfPCell cell0135ssr = new PdfPCell(new Paragraph("PG"));
			table13ssr.addCell(cell0135ssr);
			PdfPCell cell0136ssr = new PdfPCell(new Paragraph("Research"));
			table13ssr.addCell(cell0136ssr);
			
			PdfPCell cell0137ssr = new PdfPCell(new Paragraph("Science"));
			table13ssr.addCell(cell0137ssr);
			
			PdfPCell cell0138ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(0).getInputdt2():""));
			table13ssr.addCell(cell0138ssr);
			
			PdfPCell cell0139ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(0).getInputdt3():""));
			table13ssr.addCell(cell0139ssr);
			
			PdfPCell cell01310ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(0).getInputdt4():""));
			table13ssr.addCell(cell01310ssr);
			
			PdfPCell cell01311ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(0).getInputdt5():""));
			table13ssr.addCell(cell01311ssr);
			
			PdfPCell cell01312ssr = new PdfPCell(new Paragraph("Arts"));
			table13ssr.addCell(cell01312ssr);
			
			PdfPCell cell01313ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(1).getInputdt2():""));
			table13ssr.addCell(cell01313ssr);
			PdfPCell cell01314ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(1).getInputdt3():""));
			table13ssr.addCell(cell01314ssr);
			PdfPCell cell01315ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(1).getInputdt4():""));
			table13ssr.addCell(cell01315ssr);
			PdfPCell cell01316ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(1).getInputdt5():""));
			table13ssr.addCell(cell01316ssr);
			
			
			PdfPCell cell01317ssr = new PdfPCell(new Paragraph("Commerce"));
			table13ssr.addCell(cell01317ssr);
			
			PdfPCell cell01318ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(2).getInputdt2():""));
			table13ssr.addCell(cell01318ssr);
			PdfPCell cell01319ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(2).getInputdt3():""));
			table13ssr.addCell(cell01319ssr);
			PdfPCell cell01320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(2).getInputdt4():""));
			table13ssr.addCell(cell01320ssr);
			PdfPCell cell01321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(2).getInputdt5():""));
			table13ssr.addCell(cell01321ssr);
			
			
			
			PdfPCell cell01322ssr = new PdfPCell(new Paragraph("Any other (Specify) :"));
			table13ssr.addCell(cell01322ssr);
			
			PdfPCell cell01323ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(3).getInputdt2():""));
			table13ssr.addCell(cell01323ssr);
			PdfPCell cell01324ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(3).getInputdt3():""));
			table13ssr.addCell(cell01324ssr);
			PdfPCell cell01325ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(3).getInputdt4():""));
			table13ssr.addCell(cell01325ssr);
			PdfPCell cell01326ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(3).getInputdt5():""));
			table13ssr.addCell(cell01326ssr);
			
			
			
		
			
			table013ssr.addCell(table13ssr);
			
			document.add(table013ssr);
			
			////////////14
			
			PdfPTable table23ssr = new PdfPTable(9);
			PdfPTable table24ssr = new PdfPTable(1);
			
			 float[] columnWidths3 = { 70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f }; // Second column will be // twice as first and third
//			 table23ssr.setWidths(columnWidths3);
			 
	// Setting width of table, its columns and spacing
			table23ssr.setWidthPercentage(100);
			table24ssr.setWidthPercentage(100);

			PdfPCell cell028ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n	"));
			PdfPCell cell029ssr = new PdfPCell(new Paragraph("Professor\r\n"));
			cell029ssr.setColspan(2);
			PdfPCell cell030ssr = new PdfPCell(new Paragraph("Associate Professor\r\n"));
			cell030ssr.setColspan(2);
			PdfPCell cell031ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n"));
			cell031ssr.setColspan(2);
			PdfPCell cell032ssr = new PdfPCell(new Paragraph("Non-teaching staff"));
			PdfPCell cell0324ssr = new PdfPCell(new Paragraph("Teaching staff"));

			PdfPCell cell0132ssr = new PdfPCell(new Paragraph("Male\r\n"));
			PdfPCell cell0332ssr = new PdfPCell(new Paragraph("Female\r\n"));
//			PdfPCell cell0432ssr = new PdfPCell(new Paragraph("Others\r\n"));
			PdfPCell cell0532ssr = new PdfPCell(new Paragraph("Male\r\n"));
			PdfPCell cell0632ssr = new PdfPCell(new Paragraph("Female\r\n"));
//			PdfPCell cell0732ssr = new PdfPCell(new Paragraph("Others\r\n"));
			PdfPCell cell0832ssr = new PdfPCell(new Paragraph("Male\r\n"));
			PdfPCell cell0932ssr = new PdfPCell(new Paragraph("Female\r\n"));
//			PdfPCell cell01032ssr = new PdfPCell(new Paragraph("Others\r\n"));
//			PdfPCell cell01132ssr = new PdfPCell(new Paragraph("total\r\n"));

			PdfPCell cell01232ssr = new PdfPCell(new Paragraph("Sanctioned by the UGC/ University/ State Government"));
			PdfPCell cell01332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt1():""));
			PdfPCell cell01432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt2():""));
			PdfPCell cell01532ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt3():""));

			PdfPCell cell01632ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt4():""));
			PdfPCell cell01732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt5():""));
			PdfPCell cell01832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt6():""));

			PdfPCell cell01932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt7():""));
			PdfPCell cell02032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt8():""));
//			PdfPCell cell02132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq19():""));
	//
//			PdfPCell cell02232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq110():""));

			PdfPCell cell02332ssr = new PdfPCell(new Paragraph("Recruited"));
			PdfPCell cell02432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt1():""));
			PdfPCell cell02532ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt2():""));
			PdfPCell cell02632ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt3():""));

			PdfPCell cell02732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt4():""));
			PdfPCell cell02832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt5():""));
			PdfPCell cell02932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt6():""));

			PdfPCell cell03032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt7():""));
			PdfPCell cell03132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt8():""));
//			PdfPCell cell03232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(1).getInputatq19():""));
//			PdfPCell cell03332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(1).getInputatq110():""));

			PdfPCell cell034321ssr = new PdfPCell(new Paragraph("Yet to Recruit"));
			PdfPCell cell03532ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt1():""));
			PdfPCell cell03632ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt2():""));
			PdfPCell cell03732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt3():""));

			PdfPCell cell03832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt4():""));
			PdfPCell cell03932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt5():""));
			PdfPCell cell04032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt6():""));

			PdfPCell cell04132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt7():""));
			PdfPCell cell04232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt8():""));
//			PdfPCell cell04332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(2).getInputatq19():""));
//			PdfPCell cell04432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(2).getInputatq110():""));

			PdfPCell cell04532ssr = new PdfPCell(new Paragraph("Sanctioned by the Management/ Society/ or other Authorised Body"));
			PdfPCell cell04632ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt1():""));
			PdfPCell cell04732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt2():""));
			PdfPCell cell04832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt3():""));

			PdfPCell cell04932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt4():""));
			PdfPCell cell05032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt5():""));
			PdfPCell cell05132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt6():""));

			PdfPCell cell05232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt7():""));
			PdfPCell cell05332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt8():""));
//			PdfPCell cell05432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(3).getInputatq19():""));
//			PdfPCell cell05532ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(3).getInputatq110():""));

			PdfPCell cell05632ssr = new PdfPCell(new Paragraph("Recruited"));
			PdfPCell cell05732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt1():""));
			PdfPCell cell05832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt2():""));
			PdfPCell cell05932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt3():""));

			PdfPCell cell06032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt4():""));
			PdfPCell cell06132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt5():""));
			PdfPCell cell06232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt6():""));

			PdfPCell cell06332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt7():""));
			PdfPCell cell06432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt8():""));
			
			
			
			PdfPCell cell056321ssr = new PdfPCell(new Paragraph("Yet to Recruit"));
			PdfPCell cell057321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt1():""));
			PdfPCell cell058321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt2():""));
			PdfPCell cell059321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt3():""));
			PdfPCell cell060321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt4():""));
			PdfPCell cell061321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt5():""));
			PdfPCell cell062321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt6():""));

			PdfPCell cell063321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt7():""));
			PdfPCell cell064321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt8():""));

//			PdfPCell cell06632ssr = new PdfPCell(new Paragraph());

			table23ssr.addCell(cell028ssr);
			table23ssr.addCell(cell029ssr);
			table23ssr.addCell(cell030ssr);
			table23ssr.addCell(cell031ssr);
			table23ssr.addCell(cell032ssr);
			table23ssr.addCell(cell0324ssr);

			table23ssr.addCell(cell0132ssr);
			table23ssr.addCell(cell0332ssr);
//			table23ssr.addCell(cell0432ssr);
			table23ssr.addCell(cell0532ssr);
			table23ssr.addCell(cell0632ssr);
//			table23ssr.addCell(cell0732ssr);
			table23ssr.addCell(cell0832ssr);
			table23ssr.addCell(cell0932ssr);
//			table23ssr.addCell(cell01032ssr);
//			table23ssr.addCell(cell01132ssr);

			table23ssr.addCell(cell01232ssr);
			table23ssr.addCell(cell01332ssr);
			table23ssr.addCell(cell01432ssr);
			table23ssr.addCell(cell01532ssr);
			table23ssr.addCell(cell01632ssr);
			table23ssr.addCell(cell01732ssr);
			table23ssr.addCell(cell01832ssr);
			table23ssr.addCell(cell01932ssr);
			table23ssr.addCell(cell02032ssr);
//			table23ssr.addCell(cell02132ssr);
//			table23ssr.addCell(cell02232ssr);

			table23ssr.addCell(cell02332ssr);
			table23ssr.addCell(cell02432ssr);
			table23ssr.addCell(cell02532ssr);
			table23ssr.addCell(cell02632ssr);
			table23ssr.addCell(cell02732ssr);
			table23ssr.addCell(cell02832ssr);
			table23ssr.addCell(cell02932ssr);
			table23ssr.addCell(cell03032ssr);
			table23ssr.addCell(cell03132ssr);
//			table23ssr.addCell(cell03232ssr);
//			table23ssr.addCell(cell03332ssr);

			table23ssr.addCell(cell04532ssr);
			table23ssr.addCell(cell04632ssr);
			table23ssr.addCell(cell04732ssr);
			table23ssr.addCell(cell04832ssr);
			table23ssr.addCell(cell04932ssr);
			table23ssr.addCell(cell05032ssr);
			table23ssr.addCell(cell05132ssr);
			table23ssr.addCell(cell05232ssr);
			table23ssr.addCell(cell05332ssr);
//			table23ssr.addCell(cell05432ssr);
//			table23ssr.addCell(cell05532ssr);

			table23ssr.addCell(cell034321ssr);
			table23ssr.addCell(cell03532ssr);
			table23ssr.addCell(cell03632ssr);
			table23ssr.addCell(cell03732ssr);
			table23ssr.addCell(cell03832ssr);
			table23ssr.addCell(cell03932ssr);
			table23ssr.addCell(cell04032ssr);
			table23ssr.addCell(cell04132ssr);
			table23ssr.addCell(cell04232ssr);
//			table23ssr.addCell(cell04332ssr);
//			table23ssr.addCell(cell04432ssr);

			table23ssr.addCell(cell05632ssr);
			table23ssr.addCell(cell05732ssr);
			table23ssr.addCell(cell05832ssr);
			table23ssr.addCell(cell05932ssr);
			table23ssr.addCell(cell06032ssr);
			table23ssr.addCell(cell06132ssr);
			table23ssr.addCell(cell06232ssr);
			table23ssr.addCell(cell06332ssr);
			table23ssr.addCell(cell06432ssr);
//			table23ssr.addCell(cell06532ssr);
//			table23ssr.addCell(cell06632ssr);
			
			
			
			table23ssr.addCell(cell056321ssr);
			table23ssr.addCell(cell057321ssr);
			table23ssr.addCell(cell058321ssr);
			table23ssr.addCell(cell059321ssr);
			table23ssr.addCell(cell060321ssr);
			table23ssr.addCell(cell061321ssr);
			table23ssr.addCell(cell062321ssr);
			table23ssr.addCell(cell063321ssr);
			table23ssr.addCell(cell064321ssr);


			 PdfPCell cell0186ssr = new PdfPCell(new Paragraph("Permanent Teachers\r\n",font3));
				
			 table24ssr.addCell(cell0186ssr);

	//
			table24ssr.addCell(table23ssr);

			table24ssr.setSpacingBefore(20f);
			table24ssr.setSpacingAfter(20f);

			document.add(table24ssr);
			
			

			
			///////////////////////////
			
			
			PdfPTable table29ssr = new PdfPTable(11);
			PdfPTable table30ssr = new PdfPTable(1);
			
			 float[] columnWidth5 = { 7f }; // Second column will be // twice as first and third
			 table30ssr.setWidths(columnWidth5);


	// Setting width of table, its columns and spacing
			table29ssr.setWidthPercentage(100);
			table30ssr.setWidthPercentage(100);

			PdfPCell cell043ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n"));
			PdfPCell cell044ssr = new PdfPCell(new Paragraph("Professor\r\n"));
			cell044ssr.setColspan(2);
			PdfPCell cell045ssr = new PdfPCell(new Paragraph("Associate Professor\r\n"));
			cell045ssr.setColspan(2);
			PdfPCell cell046ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n"));
			cell046ssr.setColspan(2);
			PdfPCell cell048ssr = new PdfPCell(new Paragraph(""));
			PdfPCell cell04308ssr = new PdfPCell(new Paragraph(""));

			PdfPCell cell0001320ssr = new PdfPCell(new Paragraph("Male\r\n"));
			PdfPCell cell0003320ssr = new PdfPCell(new Paragraph("Female\r\n"));
//			PdfPCell cell0004320ssr = new PdfPCell(new Paragraph("Others\r\n"));
			PdfPCell cell0005320ssr = new PdfPCell(new Paragraph("Male\r\n"));
			PdfPCell cell0006320ssr = new PdfPCell(new Paragraph("Female\r\n"));
//			PdfPCell cell0007320ssr = new PdfPCell(new Paragraph("Others\r\n"));
			PdfPCell cell0008320ssr = new PdfPCell(new Paragraph("Male\r\n"));
			PdfPCell cell0009320ssr = new PdfPCell(new Paragraph("Female\r\n"));
//			PdfPCell cell00010302ssr = new PdfPCell(new Paragraph("Others\r\n"));
			PdfPCell cell00011320ssr = new PdfPCell(new Paragraph("total\r\n"));

			PdfPCell cell0012320ssr = new PdfPCell(new Paragraph("Permanent teachers"));
			PdfPCell cell0013320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats1():""));
			PdfPCell cell0014320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats2():""));
			PdfPCell cell0015320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats3():""));

			PdfPCell cell0016320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats4():""));
			PdfPCell cell0017320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats5():""));
			PdfPCell cell0018320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats6():""));

			PdfPCell cell0019320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats7():""));
//			PdfPCell cell0020320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(0).getInputatq98():""));
//			PdfPCell cell0021320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(0).getInputatq99():""));
	//
//			PdfPCell cell0022320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(0).getInputatq910():""));

			PdfPCell cell0203320ssr = new PdfPCell(new Paragraph("D.Sc./D.Litt."));
			PdfPCell cell0204320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats1():""));
			PdfPCell cell0205320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats2():""));
			PdfPCell cell0206320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats3():""));
			PdfPCell cell0207320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats4():""));
			PdfPCell cell0208320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats5():""));
			PdfPCell cell0209320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats6():""));
			PdfPCell cell0300320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats7():""));
//			PdfPCell cell0310320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(1).getInputatq98():""));
//			PdfPCell cell0320320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(1).getInputatq99():""));
//			PdfPCell cell0330320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(1).getInputatq910():""));

			PdfPCell cell0343200ssr = new PdfPCell(new Paragraph("Ph.D"));
			PdfPCell cell0353200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats1():""));
			PdfPCell cell0363200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats2():""));
			PdfPCell cell0373200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats3():""));

			PdfPCell cell0383200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats4():""));
			PdfPCell cell0393200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats5():""));
			PdfPCell cell0403200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats6():""));
			PdfPCell cell0413200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats7():""));
//			PdfPCell cell0423200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(2).getInputatq98():""));
//			PdfPCell cell0433200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(2).getInputatq99():""));
//			PdfPCell cell0443200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(2).getInputatq910():""));

			PdfPCell cell0453200ssr = new PdfPCell(new Paragraph("M.Phil\r\n"));
			PdfPCell cell0463200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats1():""));
			PdfPCell cell0473200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats2():""));
			PdfPCell cell0483200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats3():""));

			PdfPCell cell0493200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats4():""));
			PdfPCell cell0503200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats5():""));
			PdfPCell cell0513200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats6():""));
			PdfPCell cell0523200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats7():""));
//			PdfPCell cell0533200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(3).getInputatq98():""));
//			PdfPCell cell0543200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(3).getInputatq99():""));
//			PdfPCell cell0553200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(3).getInputatq910():""));

			PdfPCell cell0563200ssr = new PdfPCell(new Paragraph("PG\r\n"));
			PdfPCell cell0573200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats1():""));
			PdfPCell cell0583200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats2():""));
			PdfPCell cell0593200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats3():""));
			PdfPCell cell0603200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats4():""));
			PdfPCell cell0613200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats5():""));
			PdfPCell cell0623200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats6():""));

			PdfPCell cell0633200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats7():""));
//			PdfPCell cell0643200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(4).getInputatq98():""));
//			PdfPCell cell0653200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(4).getInputatq99():""));
	//
//			PdfPCell cell0663200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(4).getInputatq910():""));

			
			
			PdfPCell cell05632001ssr = new PdfPCell(new Paragraph("Part-time teachers\r\n"));
			PdfPCell cell05732001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats1():""));
			PdfPCell cell05832001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats2():""));
			PdfPCell cell05932001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats3():""));

			PdfPCell cell06032001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats4():""));
			PdfPCell cell06132001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats5():""));
			PdfPCell cell06232001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats6():""));

			PdfPCell cell06332001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats7():""));
			
			
			PdfPCell cell05632002ssr = new PdfPCell(new Paragraph("D.Sc./D.Litt.\r\n"));
			PdfPCell cell05732002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats1():""));
			PdfPCell cell05832002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats2():""));
			PdfPCell cell05932002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats3():""));
			PdfPCell cell06032002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats4():""));
			PdfPCell cell06132002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats5():""));
			PdfPCell cell06232002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats6():""));
			PdfPCell cell06332002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats7():""));
			
			PdfPCell cell05632003ssr = new PdfPCell(new Paragraph("D.Sc./D.Litt.\r\n"));
			PdfPCell cell05732003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats1():""));
			PdfPCell cell05832003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats2():""));
			PdfPCell cell05932003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats3():""));
			PdfPCell cell06032003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats4():""));
			PdfPCell cell06132003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats5():""));
			PdfPCell cell06232003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats6():""));
			PdfPCell cell06332003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats7():""));
			
			
			PdfPCell cell05632004ssr = new PdfPCell(new Paragraph("Ph.D\r\n"));
			PdfPCell cell05732004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats1():""));
			PdfPCell cell05832004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats2():""));
			PdfPCell cell05932004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats3():""));
			PdfPCell cell06032004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats4():""));
			PdfPCell cell06132004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats5():""));
			PdfPCell cell06232004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats6():""));
			PdfPCell cell06332004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats7():""));
			
			

			PdfPCell cell05632005ssr = new PdfPCell(new Paragraph("M.Phil\r\n"));
			PdfPCell cell05732005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats1():""));
			PdfPCell cell05832005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats2():""));
			PdfPCell cell05932005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats3():""));
			PdfPCell cell06032005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats4():""));
			PdfPCell cell06132005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats5():""));
			PdfPCell cell06232005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats6():""));
			PdfPCell cell06332005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats7():""));
			
			
			PdfPCell cell05632006ssr = new PdfPCell(new Paragraph("PG\r\n"));
			PdfPCell cell05732006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats1():""));
			PdfPCell cell05832006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats2():""));
			PdfPCell cell05932006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats3():""));
			PdfPCell cell06032006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats4():""));
			PdfPCell cell06132006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats5():""));
			PdfPCell cell06232006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats6():""));
			PdfPCell cell06332006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats7():""));
			
			
			
			
			
			table29ssr.addCell(cell043ssr);
			table29ssr.addCell(cell044ssr);
			table29ssr.addCell(cell045ssr);
			table29ssr.addCell(cell046ssr);
			table29ssr.addCell(cell048ssr);
			table29ssr.addCell(cell04308ssr);

			table29ssr.addCell(cell0001320ssr);
			table29ssr.addCell(cell0003320ssr);
//			table29ssr.addCell(cell0004320ssr);
			table29ssr.addCell(cell0005320ssr);
			table29ssr.addCell(cell0006320ssr);
//			table29ssr.addCell(cell0007320ssr);
			table29ssr.addCell(cell0008320ssr);
			table29ssr.addCell(cell0009320ssr);
//			table29ssr.addCell(cell00010302ssr);
			table29ssr.addCell(cell00011320ssr);

			table29ssr.addCell(cell0012320ssr);
			table29ssr.addCell(cell0013320ssr);
			table29ssr.addCell(cell0014320ssr);
			table29ssr.addCell(cell0015320ssr);
			table29ssr.addCell(cell0016320ssr);
			table29ssr.addCell(cell0017320ssr);
			table29ssr.addCell(cell0018320ssr);
			table29ssr.addCell(cell0019320ssr);
//			table29ssr.addCell(cell0020320ssr);
//			table29ssr.addCell(cell0021320ssr);
//			table29ssr.addCell(cell0022320ssr);

			table29ssr.addCell(cell0203320ssr);
			table29ssr.addCell(cell0204320ssr);
			table29ssr.addCell(cell0205320ssr);
			table29ssr.addCell(cell0206320ssr);
			table29ssr.addCell(cell0207320ssr);
			table29ssr.addCell(cell0208320ssr);
			table29ssr.addCell(cell0209320ssr);
			table29ssr.addCell(cell0300320ssr);
//			table29ssr.addCell(cell0310320ssr);
//			table29ssr.addCell(cell0320320ssr);
//			table29ssr.addCell(cell0330320ssr);

			table29ssr.addCell(cell0343200ssr);
			table29ssr.addCell(cell0353200ssr);
			table29ssr.addCell(cell0363200ssr);
			table29ssr.addCell(cell0373200ssr);
			table29ssr.addCell(cell0383200ssr);
			table29ssr.addCell(cell0393200ssr);
			table29ssr.addCell(cell0403200ssr);
			table29ssr.addCell(cell0413200ssr);
//			table29ssr.addCell(cell0423200ssr);
//			table29ssr.addCell(cell0433200ssr);
//			table29ssr.addCell(cell0443200ssr);

			table29ssr.addCell(cell0453200ssr);
			table29ssr.addCell(cell0463200ssr);
			table29ssr.addCell(cell0473200ssr);
			table29ssr.addCell(cell0483200ssr);
			table29ssr.addCell(cell0493200ssr);
			table29ssr.addCell(cell0503200ssr);
			table29ssr.addCell(cell0513200ssr);
			table29ssr.addCell(cell0523200ssr);
//			table29ssr.addCell(cell0533200ssr);
//			table29ssr.addCell(cell0543200ssr);
//			table29ssr.addCell(cell0553200ssr);
	//
			table29ssr.addCell(cell0563200ssr);
			table29ssr.addCell(cell0573200ssr);
			table29ssr.addCell(cell0583200ssr);
			table29ssr.addCell(cell0593200ssr);
			table29ssr.addCell(cell0603200ssr);
			table29ssr.addCell(cell0613200ssr);
			table29ssr.addCell(cell0623200ssr);
			table29ssr.addCell(cell0633200ssr);
//			table29ssr.addCell(cell0643200ssr);
//			table29ssr.addCell(cell0653200ssr);
//			table29ssr.addCell(cell0663200ssr);

			
			
			
			table29ssr.addCell(cell05632001ssr);
			table29ssr.addCell(cell05732001ssr);
			table29ssr.addCell(cell05832001ssr);
			table29ssr.addCell(cell05932001ssr);
			table29ssr.addCell(cell06032001ssr);
			table29ssr.addCell(cell06132001ssr);
			table29ssr.addCell(cell06232001ssr);
			table29ssr.addCell(cell06332001ssr);
			
			table29ssr.addCell(cell05632002ssr);
			table29ssr.addCell(cell05732002ssr);
			table29ssr.addCell(cell05832002ssr);
			table29ssr.addCell(cell05932002ssr);
			table29ssr.addCell(cell06032002ssr);
			table29ssr.addCell(cell06132002ssr);
			table29ssr.addCell(cell06232002ssr);
			table29ssr.addCell(cell06332002ssr);
			
			table29ssr.addCell(cell05632003ssr);
			table29ssr.addCell(cell05732003ssr);
			table29ssr.addCell(cell05832003ssr);
			table29ssr.addCell(cell05932003ssr);
			table29ssr.addCell(cell06032003ssr);
			table29ssr.addCell(cell06132003ssr);
			table29ssr.addCell(cell06232003ssr);
			table29ssr.addCell(cell06332003ssr);


			table29ssr.addCell(cell05632004ssr);
			table29ssr.addCell(cell05732004ssr);
			table29ssr.addCell(cell05832004ssr);
			table29ssr.addCell(cell05932004ssr);
			table29ssr.addCell(cell06032004ssr);
			table29ssr.addCell(cell06132004ssr);
			table29ssr.addCell(cell06232004ssr);
			table29ssr.addCell(cell06332004ssr);
			
			
			table29ssr.addCell(cell05632005ssr);
			table29ssr.addCell(cell05732005ssr);
			table29ssr.addCell(cell05832005ssr);
			table29ssr.addCell(cell05932005ssr);
			table29ssr.addCell(cell06032005ssr);
			table29ssr.addCell(cell06132005ssr);
			table29ssr.addCell(cell06232005ssr);
			table29ssr.addCell(cell06332005ssr);
			
			
			table29ssr.addCell(cell05632006ssr);
			table29ssr.addCell(cell05732006ssr);
			table29ssr.addCell(cell05832006ssr);
			table29ssr.addCell(cell05932006ssr);
			table29ssr.addCell(cell06032006ssr);
			table29ssr.addCell(cell06132006ssr);
			table29ssr.addCell(cell06232006ssr);
			table29ssr.addCell(cell06332006ssr);
		
		
			 PdfPCell cell0184ssr = new PdfPCell(new Paragraph("Part Time Teachers\r\n",font3));
				
			 table30ssr.addCell(cell0184ssr);
		

			table30ssr.addCell(table29ssr);

			table30ssr.setSpacingBefore(20f);
			table30ssr.setSpacingAfter(20f);

			document.add(table30ssr);

			
			
			
			Paragraph paragraph131ssr = new Paragraph("16.Number of Visiting Faculty/Guest Faculty engages with the College:");
			document.add(paragraph131ssr);
			Paragraph paragraph132ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(14).getInputats1():"");
			document.add(paragraph132ssr);
			
			
			Paragraph paragraph1322ssr = new Paragraph("17. Furnish the number of the students admitted to the college during the last four academic years.");
			document.add(paragraph1322ssr);
			
			PdfPTable table291ssr = new PdfPTable(9);
//			PdfPTable table30ssr = new PdfPTable(1);
			
//			 float[] columnWidth5 = { 7f }; // Second column will be // twice as first and third
			 table30ssr.setWidths(columnWidth5);


	//Setting width of table, its columns and spacing
			table29ssr.setWidthPercentage(100);
			table30ssr.setWidthPercentage(100);

			PdfPCell cell0431ssr = new PdfPCell(new Paragraph("Categories"));
			cell0431ssr.setRowspan(2);
			
			PdfPCell cell0442ssr = new PdfPCell(new Paragraph("year"));
			cell0442ssr.setColspan(2);
			PdfPCell cell0453ssr = new PdfPCell(new Paragraph("year2"));
			cell0453ssr.setColspan(2);
			PdfPCell cell0464ssr = new PdfPCell(new Paragraph("year3"));
			cell0464ssr.setColspan(2);
			PdfPCell cell0484ssr = new PdfPCell(new Paragraph("year4"));
			cell0484ssr.setRowspan(2);

			PdfPCell cell000132031ssr = new PdfPCell(new Paragraph("Male\r\n"));
			PdfPCell cell00033202ssr = new PdfPCell(new Paragraph("Female\r\n"));

			PdfPCell cell00053203ssr = new PdfPCell(new Paragraph("Male\r\n"));
			PdfPCell cell00063204ssr = new PdfPCell(new Paragraph("Female\r\n"));

			PdfPCell cell00083205ssr = new PdfPCell(new Paragraph("Male\r\n"));
			PdfPCell cell00093206ssr = new PdfPCell(new Paragraph("Female\r\n"));
			
			table291ssr.addCell(cell0431ssr);
			table291ssr.addCell(cell0442ssr);
			table291ssr.addCell(cell0453ssr);
			table291ssr.addCell(cell0464ssr);
			table291ssr.addCell(cell0484ssr);
			table291ssr.addCell(cell000132031ssr);
			table291ssr.addCell(cell00033202ssr);
			table291ssr.addCell(cell00053203ssr);
			table291ssr.addCell(cell00063204ssr);
			table291ssr.addCell(cell00083205ssr);
			table291ssr.addCell(cell00093206ssr);
			
			
			PdfPCell cell000113207ssr = new PdfPCell(new Paragraph("SC\r\n"));

			PdfPCell cell0001132081ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat1():""));
			PdfPCell cell0001132082ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat2():""));
			PdfPCell cell0001132083ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat3():""));
			PdfPCell cell0001132084sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat4():""));
			PdfPCell cell0001132085ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat5():""));
			PdfPCell cell0001132086ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat6():""));
			PdfPCell cell0001132087ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat7():""));
			PdfPCell cell0001132088ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat8():""));

			
			table291ssr.addCell(cell000113207ssr);
			table291ssr.addCell(cell0001132081ssr);
			table291ssr.addCell(cell0001132082ssr);
			table291ssr.addCell(cell0001132083ssr);
			table291ssr.addCell(cell0001132084sr);
			table291ssr.addCell(cell0001132085ssr);
			table291ssr.addCell(cell0001132086ssr);
			table291ssr.addCell(cell0001132087ssr);
			table291ssr.addCell(cell0001132088ssr);
			
			
			
			PdfPCell cell0001132071ssr = new PdfPCell(new Paragraph("ST\r\n"));

			PdfPCell cell00011320811ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat1():""));
			PdfPCell cell00011320821ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat2():""));
			PdfPCell cell00011320831ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat3():""));
			PdfPCell cell00011320841sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat4():""));
			PdfPCell cell00011320851ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat5():""));
			PdfPCell cell00011320861ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat6():""));
			PdfPCell cell00011320871ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat7():""));
			PdfPCell cell00011320881ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat8():""));

			
			table291ssr.addCell(cell0001132071ssr);
			table291ssr.addCell(cell00011320811ssr);
			table291ssr.addCell(cell00011320821ssr);
			table291ssr.addCell(cell00011320831ssr);
			table291ssr.addCell(cell00011320841sr);
			table291ssr.addCell(cell00011320851ssr);
			table291ssr.addCell(cell00011320861ssr);
			table291ssr.addCell(cell00011320871ssr);
			table291ssr.addCell(cell00011320881ssr);
			
			
			
			
			PdfPCell cell0001132072ssr = new PdfPCell(new Paragraph("OBC\r\n"));

			PdfPCell cell00011320812ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat1():""));
			PdfPCell cell00011320822ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat2():""));
			PdfPCell cell00011320832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat3():""));
			PdfPCell cell00011320842sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat4():""));
			PdfPCell cell00011320852ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat5():""));
			PdfPCell cell00011320862ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat6():""));
			PdfPCell cell00011320872ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat7():""));
			PdfPCell cell00011320882ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat8():""));

			
			
			
			
			
			table291ssr.addCell(cell0001132072ssr);
			table291ssr.addCell(cell00011320812ssr);
			table291ssr.addCell(cell00011320822ssr);
			table291ssr.addCell(cell00011320832ssr);
			table291ssr.addCell(cell00011320842sr);
			table291ssr.addCell(cell00011320852ssr);
			table291ssr.addCell(cell00011320862ssr);
			table291ssr.addCell(cell00011320872ssr);
			table291ssr.addCell(cell00011320882ssr);

			PdfPCell cell0001132073ssr = new PdfPCell(new Paragraph("General\r\n"));

			PdfPCell cell00011320813ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat1():""));
			PdfPCell cell00011320823ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat2():""));
			PdfPCell cell00011320833ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat3():""));
			PdfPCell cell00011320843sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat4():""));
			PdfPCell cell00011320853ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat5():""));
			PdfPCell cell00011320863ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat6():""));
			PdfPCell cell00011320873ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat7():""));
			PdfPCell cell00011320883ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat8():""));

			table291ssr.addCell(cell0001132073ssr);
			table291ssr.addCell(cell00011320813ssr);
			table291ssr.addCell(cell00011320823ssr);
			table291ssr.addCell(cell00011320833ssr);
			table291ssr.addCell(cell00011320843sr);
			table291ssr.addCell(cell00011320853ssr);
			table291ssr.addCell(cell00011320863ssr);
			table291ssr.addCell(cell00011320873ssr);
			table291ssr.addCell(cell00011320883ssr);

			
			
			
			
			
			
			
			
			PdfPCell cell0001132074ssr = new PdfPCell(new Paragraph("Other\r\n"));

			PdfPCell cell00011320814ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat1():""));
			PdfPCell cell00011320824ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat2():""));
			PdfPCell cell00011320834ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat3():""));
			PdfPCell cell00011320844sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat4():""));
			PdfPCell cell00011320854ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat5():""));
			PdfPCell cell00011320864ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat6():""));
			PdfPCell cell00011320874ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat7():""));
			PdfPCell cell00011320884ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat8():""));

			
			
			
			table291ssr.addCell(cell0001132074ssr);
			table291ssr.addCell(cell00011320814ssr);
			table291ssr.addCell(cell00011320824ssr);
			table291ssr.addCell(cell00011320834ssr);
			table291ssr.addCell(cell00011320844sr);
			table291ssr.addCell(cell00011320854ssr);
			table291ssr.addCell(cell00011320864ssr);
			table291ssr.addCell(cell00011320874ssr);
			table291ssr.addCell(cell00011320884ssr);

			
			
			
			
			document.add(table291ssr);
			
			
			Paragraph paragraph133ssr = new Paragraph("18. Details on students enrollment in the college during the current academic year.");
			document.add(paragraph133ssr);
			
			
			PdfPTable table2910ssr = new PdfPTable(6);
			table2910ssr.setWidthPercentage(100f);
			table2910ssr.setWidths(new int[] { 60, 40, 40, 40, 40,40});
			table2910ssr.setSpacingAfter(20f);
			table2910ssr.setSpacingBefore(20f);

			cell.setPhrase(new Phrase("Type of Students\r\n", font3));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("UG\r\n", font3));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("PG\r\n", font3));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("M.Phil.\r\n", font3));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("Ph.D.\r\n", font3));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("Ph.D.\r\n", font3));
			table2910ssr.addCell(cell);
			

			cell.setPhrase(new Phrase("Students from the same state where the collge is located\r\n", font3));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(0).getInputet1():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(0).getInputet2():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(0).getInputet3():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(0).getInputet4():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(0).getInputet5():""));
			table2910ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(0).getInputet6():""));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("Students from other states of India\r\n", font3));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(1).getInputet1():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(1).getInputet2():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(1).getInputet3():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(1).getInputet4():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(1).getInputet5():""));
			table2910ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(1).getInputet6():""));
			table2910ssr.addCell(cell);
			

			cell.setPhrase(new Phrase("NRI Students\r\n", font3));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(2).getInputet1():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(2).getInputet2():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(2).getInputet3():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(2).getInputet4():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(2).getInputet5():""));
			table2910ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(2).getInputet6():""));
			table2910ssr.addCell(cell);
			
			cell.setPhrase(new Phrase("Foreign Students\r\n", font3));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(3).getInputet1():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(3).getInputet2():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(3).getInputet3():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(3).getInputet4():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(3).getInputet5():""));
			table2910ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(3).getInputet6():""));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("Total\r\n", font3));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(4).getInputet1():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(4).getInputet2():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(4).getInputet3():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(4).getInputet4():""));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(4).getInputet5():""));
			table2910ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(4).getInputet6():""));
			table2910ssr.addCell(cell);
			
			document.add(table2910ssr);
			
			
			Paragraph paragraph134ssr = new Paragraph("19. Please fill in the following details if applicable:", font3);
			document.add(paragraph134ssr);
			
			PdfPTable table29101ssr = new PdfPTable(3);
			table29101ssr.setWidthPercentage(100f);
			
			
			PdfPCell cell00011320885ssr = new PdfPCell(new Paragraph("Unit Cost of Education"));
			table29101ssr.addCell(cell00011320885ssr);
			
			PdfPCell cell00011320886ssr = new PdfPCell(new Paragraph("Including Salary Component"));
			table29101ssr.addCell(cell00011320886ssr);
			
			PdfPCell cell00011320887ssr = new PdfPCell(new Paragraph("Excluding Salary Component"));
			table29101ssr.addCell(cell00011320887ssr);
			
			PdfPCell cell00011320888ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedEducation().get(0).getInputct1():""));
			table29101ssr.addCell(cell00011320888ssr);
			
			
			PdfPCell cell00011320889ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedEducation().get(0).getInputct2():""));
			table29101ssr.addCell(cell00011320889ssr);
			
			
			PdfPCell cell000113208810ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedEducation().get(0).getInputct3():""));
			table29101ssr.addCell(cell000113208810ssr);
			
			document.add(table29101ssr);
			
			
			
			Paragraph paragraph135ssr = new Paragraph("20. Date of accreditation * (applicable for Cycle 2, Cycle 3, Cycle 4 and re-assessment only)",font3);
			document.add(paragraph135ssr);
			
			
			Paragraph paragraph136ssr = new Paragraph("Cycle 1:");
			document.add(paragraph136ssr);
			Paragraph paragraph137ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat1():"");
			document.add(paragraph137ssr);
			Paragraph paragraph138ssr = new Paragraph(" Accreditation Outcome/Result:    ");
			document.add(paragraph138ssr);
			Paragraph paragraph1311ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat2():"");
			document.add(paragraph1311ssr);
			

			Paragraph paragraph1361ssr = new Paragraph("Cycle 1:");
			document.add(paragraph1361ssr);
			Paragraph paragraph1371ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat3():"");
			document.add(paragraph1371ssr);
			Paragraph paragraph1381ssr = new Paragraph(" Accreditation Outcome/Result:    ");
			document.add(paragraph1381ssr);
			Paragraph paragraph13111ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat4():"");
			document.add(paragraph13111ssr);
			
			

			Paragraph paragraph13611ssr = new Paragraph("Cycle 1:");
			document.add(paragraph13611ssr);
			Paragraph paragraph13711ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat5():"");
			document.add(paragraph13711ssr);
			Paragraph paragraph13811ssr = new Paragraph(" Accreditation Outcome/Result:    ");
			document.add(paragraph13811ssr);
			Paragraph paragraph131111ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat6():"");
			document.add(paragraph131111ssr);
			
			
			

			Paragraph paragraph13612ssr = new Paragraph("Cycle 1:");
			document.add(paragraph13612ssr);
			Paragraph paragraph13712ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat7():"");
			document.add(paragraph13712ssr);
			Paragraph paragraph13812ssr = new Paragraph(" Accreditation Outcome/Result:    ");
			document.add(paragraph13812ssr);
			Paragraph paragraph131112ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat8():"");
			document.add(paragraph131112ssr);
			
			
			Paragraph paragraph13613ssr = new Paragraph("21. Date of establishment of Internal Quality Assurance Reports (AQAR) to NAAC"+"\r\n"+"IQAC:    ");
			document.add(paragraph13613ssr);
			Paragraph paragraph13614ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAnnualQuality().get(0).getInputat9():"");
			document.add(paragraph13614ssr);
			
			Paragraph paragraph13615ssr = new Paragraph("\r\n"+"22. Details regarding submission of Annual Quality Assurance Reports to NAAC");
			document.add(paragraph13615ssr);
			Paragraph paragraph136167ssr = new Paragraph("AQAR (i) "+"\t\t");
			document.add(paragraph136167ssr);
			Paragraph paragraph13616ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAnnualQuality().get(0).getInputat10():"");
			document.add(paragraph13616ssr);
			Paragraph paragraph1361671ssr = new Paragraph("AQAR (ii) "+"\t\t");
			document.add(paragraph1361671ssr);
			Paragraph paragraph136160ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAnnualQuality().get(0).getInputat11():"");
			document.add(paragraph136160ssr);
			Paragraph paragraph1361672ssr = new Paragraph("AQAR (iii) "+"\t\t");
			document.add(paragraph1361672ssr);
			Paragraph paragraph136161ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAnnualQuality().get(0).getInputat12():"");
			document.add(paragraph136161ssr);
			Paragraph paragraph1361673ssr = new Paragraph("AQAR (iv) "+"\t\t");
			document.add(paragraph1361673ssr);
			Paragraph paragraph136122ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAnnualQuality().get(0).getInputat13():"");
			document.add(paragraph136122ssr);
			
			
				
			
			
		}
		*/
	
		
		public void Ssr(Document document,ExecutiveSummary executiveData) {
			
			Paragraph paragraph20ssr = new Paragraph("1.EXECUTIVE SUMMARY", font1);
			Paragraph paragraph21ssr = new Paragraph("1.Introductory Note on the Institution", font2);
			paragraph20ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			paragraph20ssr.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph20ssr);
			document.add(paragraph21ssr);

//			Paragraph paragraph22ssr = new Paragraph(
//					"Mother Teresa Institute of Science and Technology (MIST), Khammam -\r\n" + "\r\n", font5);
//			Paragraph paragraph23ssr = new Paragraph(
//					"was established in 2001. The college is an ISO 9001:2008 certified institute and is permanently affiliated to Jawaharlal Nehru Technological University, Hyderabad.\r\n"
//							+ "\r\n" ,
//					font5);
//			Paragraph paragraph24ssr = new Paragraph(
//					"Mother Teresa Institute of Science and Technology (MIST) was founded through MCM Educational Society in 2001 by eminent philanthropist,industrialists and schloars , MIST  aims at co-creating value-based technical excellence, which ultimately leads to the development of the rural area where the college is situated. From a modest intake of 180 students across 3 engineering programs in B.Tech, namely ECE, CSE, and IT, MIST, in less than 2 decades, it has grown into an institution of gigantic proportions with massive infrastructure, besides multitude of students, faculty & staff. At present, we offer 6 B.Tech programmes in CSE,  ECE, EEE, ME, CE, MNG., 5 M.Tech programmes such as CSE, Power Electronics and Drives ,ECE,Advance Manufacturing Systems,Structural Engg. in addition to M.B.A  programme as first shift and introduced 2nd shift diploma in A.Y:2009,with the Branches CE,EEE,ME,ECE and Mining. MIST has a vibrant campus spread over 30 acres of serene and natural surroundings with plenty of greenery in SATHUPALLY, Khammam  District, Telangana. It has world class infrastructure in all its academic departments, besides an asthetically-designed administrative block. The major facilities include  e-class rooms,  well-equipped laboratories,seminar halls ,well stocked library,WI-FI enabled campus,Backup power supply,Canteen etc. MIST was approved by All india Counsil for Technical Education AICTE New Delhi,  Affliated to Jawaharlal Nehru Technological University Hyderabad , JNTUH and State Board of Technical Education and Training SBTET Recognized by Govt.of Telangana, UGC under Section 2(f) and 12(B) and Accrediated by NAAC  with 'B' Grade. MIST has been recognized as a remote center of IIT BOMBAY and KARAGPUR for organizing FDP’S ,WORKSHOPS,QIP’S for students and faculty.We pride ourselves as an institution with a large pool of well-qualified and experienced faculty who not only enrich our teaching-learning sphere but also contribute to the R&D ecosystem. The promoters of the MIST started the college with a vision to empower students to become technologically vibrant, innovative and emotionally matured to face the dynamic challenges of a quality-conscious global economy. They are socially-conscious and respond proactively to the needs and requirements of this region on a continuous basis. The managing trust is involved in many charitable activities to help the needy and the poor of this region, thereby contribute towards social development of the region.\r\n\r\n",
//					font5);

			Paragraph paragraph22ssr = new Paragraph(executiveData != null ?executiveData.getInputes1():
					"", font5);
//			Paragraph paragraph23ssr = new Paragraph(
//					"was established in 2001. The college is an ISO 9001:2008 certified institute and is permanently affiliated to Jawaharlal Nehru Technological University, Hyderabad.\r\n"
//							+ "\r\n" ,
//					font5);
//			Paragraph paragraph24ssr = new Paragraph(
//					"Mother Teresa Institute of Science and Technology (MIST) was founded through MCM Educational Society in 2001 by eminent philanthropist,industrialists and schloars , MIST  aims at co-creating value-based technical excellence, which ultimately leads to the development of the rural area where the college is situated. From a modest intake of 180 students across 3 engineering programs in B.Tech, namely ECE, CSE, and IT, MIST, in less than 2 decades, it has grown into an institution of gigantic proportions with massive infrastructure, besides multitude of students, faculty & staff. At present, we offer 6 B.Tech programmes in CSE,  ECE, EEE, ME, CE, MNG., 5 M.Tech programmes such as CSE, Power Electronics and Drives ,ECE,Advance Manufacturing Systems,Structural Engg. in addition to M.B.A  programme as first shift and introduced 2nd shift diploma in A.Y:2009,with the Branches CE,EEE,ME,ECE and Mining. MIST has a vibrant campus spread over 30 acres of serene and natural surroundings with plenty of greenery in SATHUPALLY, Khammam  District, Telangana. It has world class infrastructure in all its academic departments, besides an asthetically-designed administrative block. The major facilities include  e-class rooms,  well-equipped laboratories,seminar halls ,well stocked library,WI-FI enabled campus,Backup power supply,Canteen etc. MIST was approved by All india Counsil for Technical Education AICTE New Delhi,  Affliated to Jawaharlal Nehru Technological University Hyderabad , JNTUH and State Board of Technical Education and Training SBTET Recognized by Govt.of Telangana, UGC under Section 2(f) and 12(B) and Accrediated by NAAC  with 'B' Grade. MIST has been recognized as a remote center of IIT BOMBAY and KARAGPUR for organizing FDP’S ,WORKSHOPS,QIP’S for students and faculty.We pride ourselves as an institution with a large pool of well-qualified and experienced faculty who not only enrich our teaching-learning sphere but also contribute to the R&D ecosystem. The promoters of the MIST started the college with a vision to empower students to become technologically vibrant, innovative and emotionally matured to face the dynamic challenges of a quality-conscious global economy. They are socially-conscious and respond proactively to the needs and requirements of this region on a continuous basis. The managing trust is involved in many charitable activities to help the needy and the poor of this region, thereby contribute towards social development of the region.\r\n\r\n",
//					font5);
//			
			paragraph22ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		//	paragraph23ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph22ssr);
		//	document.add(paragraph23ssr);

//			paragraph24ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph24ssr);

			Paragraph paragraph25ssr = new Paragraph("VISION", font3);
			paragraph25ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph25ssr);
			
			

//			Paragraph paragraph26ssr = new Paragraph(
//					"To provide the society with center of learning that motivates, supports and encourages the youth to involve into dynamic professional with a social commitmenty.\r\n"
//							+ "\r\n",
//				//	font5);

			Paragraph paragraph26ssr = new Paragraph(executiveData != null ?executiveData.getInputes2():"");
			
			paragraph26ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph26ssr);

			Paragraph paragraph27ssr = new Paragraph("MISSION", font3);
			paragraph27ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph27ssr);

//			Paragraph paragraph28ssr = new Paragraph(
//					"We dedicate and commitment ourselves to achieve, sustain and    foster unmatched excellence in technical education.  To this end, we will pursue continuous development of infrastructure and enhance state of the art equipment to provide our students a technology up to date and intellectually inspiring environment of learning, research, creativity, innovation and professional activity, inculcate in them ethical and moral values. The institute is committed to build a better nation through quality education with team sprit. Our students are enable to excel values of life and become good citizens. We inspire the system, infrastructure and services to satisfy the students, parents, industry and society.\r\n"
//							+ "\r\n" + "\r\n" + "\r\n",
//					font5);
			Paragraph paragraph28ssr = new Paragraph(executiveData != null ?executiveData.getInputes3(): "",font5);
			
			paragraph28ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph28ssr);
			
			
			
			Paragraph paragraph27ssr1 = new Paragraph("Location:", font3);
			paragraph27ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph27ssr1);

			Paragraph paragraph28ssr1 = new Paragraph(executiveData != null ?executiveData.getInputes4(): "",font5);
			
			paragraph28ssr1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph28ssr1);
			
			Paragraph paragraph27ssr11 = new Paragraph("Type of the Institution:", font3);
			paragraph27ssr11.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph27ssr11);

			Paragraph paragraph28ssr11 = new Paragraph(executiveData != null ?executiveData.getInputes5(): "",font5);
			
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

			Paragraph paragraph28ssr1111 = new Paragraph(executiveData != null ?executiveData.getInputes7(): "",font5);
			
			paragraph28ssr1111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph28ssr1111);
			
			
			Paragraph paragraph27ssr11111 = new Paragraph("3.Brief note on the Strength Weakness Opportunities and Challenges(SWOC) in respect of the Institution:", font3);
			paragraph27ssr11111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph27ssr11111);

			Paragraph paragraph28ssr11111 = new Paragraph(executiveData != null ?executiveData.getInputes8(): "",font5);
			
			paragraph28ssr11111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph28ssr11111);
			
			
			Paragraph paragraph27ssr111111 = new Paragraph("4.Any additional information about the Institution other than ones already stated.:", font3);
			paragraph27ssr111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph27ssr111111);

			Paragraph paragraph28ssr111111 = new Paragraph(executiveData != null ?executiveData.getInputes9(): "",font5);
			
			paragraph28ssr111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph28ssr111111);
				
			Paragraph paragraph27ssr1111111 = new Paragraph("5.Over all conclusive explication about the institution's functioning:", font3);
			paragraph27ssr1111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph27ssr1111111);

			Paragraph paragraph28ssr1111111 = new Paragraph(executiveData != null ?executiveData.getInputes9(): "",font5);
			
			paragraph28ssr1111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph28ssr1111111);
					
		////////////////////////
			//////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////
			Paragraph paragraph13ssr = new Paragraph("2.PROFILE\r\n\r\n", font1);
			Paragraph paragraph14ssr = new Paragraph("2.1 BASIC INFORMATION\r\n", font2);
			paragraph13ssr.setAlignment(Paragraph.ALIGN_CENTER);
			paragraph14ssr.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph13ssr);
			document.add(paragraph14ssr);

			PdfPTable table01ssr = new PdfPTable(1);
			table01ssr.setWidthPercentage(100f);

			PdfPCell cell01ssr = new PdfPCell(new Paragraph("Name and Address of the College" 
			+"\r\n\r\n", font4));
			cell01ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
			table01ssr.addCell(cell01ssr);
		
		   table01ssr.setSpacingBefore(20f);
			

		//	table01ssr.setSpacingAfter(20f);

			document.add(table01ssr);

			PdfPTable table1ssr = new PdfPTable(2);
			table1ssr.setWidthPercentage(100f);
			table1ssr.setWidths(new int[] { 3, 3 });
//			table1ssr.setSpacingBefore(5);

			PdfPCell cell1ssr = new PdfPCell(new Paragraph("Name" +"\r\n\r\n", font4));
			table1ssr.addCell(cell1ssr);

			PdfPCell cell2ssr = new PdfPCell(
					new Paragraph(ProfileRecord != null ? ProfileRecord.getBasicProfile().get(0).getInputbt1() : "" +"\r\n\r\n", font5));
			table1ssr.addCell(cell2ssr);

			PdfPCell cell3ssr = new PdfPCell(new Paragraph("Address"+"\r\n\r\n", font4));
			table1ssr.addCell(cell3ssr);

			PdfPCell cell4ssr = new PdfPCell(
					new Paragraph(ProfileRecord != null ? ProfileRecord.getBasicProfile().get(0).getInputbt2() : "" +"\r\n\r\n", font5));
			table1ssr.addCell(cell4ssr);

			PdfPCell cell5ssr = new PdfPCell(new Paragraph("City" +"\r\n\r\n", font4));
			table1ssr.addCell(cell5ssr);

			PdfPCell cell6ssr = new PdfPCell(
					new Paragraph(ProfileRecord != null ? ProfileRecord.getBasicProfile().get(0).getInputbt3() : "" +"\r\n\r\n", font5));
			table1ssr.addCell(cell6ssr);

			PdfPCell cell7ssr = new PdfPCell(new Paragraph("State" +"\r\n\r\n", font4));
			table1ssr.addCell(cell7ssr);

			PdfPCell cell8ssr = new PdfPCell(
					new Paragraph(ProfileRecord != null ? ProfileRecord.getBasicProfile().get(0).getInputbt4() : "" +"\r\n\r\n", font5));
			table1ssr.addCell(cell8ssr);

			PdfPCell cell9ssr = new PdfPCell(new Paragraph("Pin" +"\r\n\r\n", font4));
			table1ssr.addCell(cell9ssr);

			PdfPCell cell10ssr = new PdfPCell(
					new Paragraph(ProfileRecord != null ? ProfileRecord.getBasicProfile().get(0).getInputbt5() : "" +"\r\n\r\n", font5));
			table1ssr.addCell(cell10ssr);

			PdfPCell cell11ssr = new PdfPCell(new Paragraph("Website" +"\r\n\r\n", font4));
			table1ssr.addCell(cell11ssr);

			PdfPCell cell12ssr = new PdfPCell(
					new Paragraph(ProfileRecord != null ? ProfileRecord.getBasicProfile().get(0).getInputbt6() : "" +"\r\n\r\n", font5));
			table1ssr.addCell(cell12ssr);
		//	table1ssr.setSpacingAfter(20f);
	         document.add(table1ssr);

			PdfPTable table02ssr = new PdfPTable(1);
			table02ssr.setWidthPercentage(100f);

			PdfPCell cell02ssr = new PdfPCell(new Paragraph("Contacts for Communication", font4));
			cell02ssr.setHorizontalAlignment(Element.ALIGN_CENTER);		
			table02ssr.addCell(cell02ssr);

			PdfPTable table2ssr = new PdfPTable(6);
			table2ssr.setWidthPercentage(100f);
			table2ssr.setWidths(new int[] { 70, 70, 70, 70, 70, 70 });
		

			PdfPCell cell = new PdfPCell();

			cell.setPhrase(new Phrase("Designation\r\n", font4));
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
			cell.setPhrase(new Phrase("Principal\r\n", font4));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc2(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc3(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc4(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc5(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc6(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase("Vice Principal\r\n", font4));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc2(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc3(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc4(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc5(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc6(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			
			cell.setPhrase(new Phrase("IQAC Co-ordinator\r\n", font4));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc2(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc3(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc4(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc5(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getContactsforCommunication().get(0).getInputbtc6(): "" +"\r\n\r\n", font5));
			table2ssr.addCell(cell);


			cell.setPadding(5);

			//table02ssr.addCell(table2ssr);
		//	table02ssr.setSpacingAfter(20f);
		
			document.add(table02ssr);

			document.add(table2ssr);
			

			PdfPTable table03ssr = new PdfPTable(1);
			table03ssr.setWidthPercentage(100f);

			PdfPCell cell03ssr = new PdfPCell(new Paragraph("3. Status of the Institution: Affiliated College constituent College Any other (specify)\r\n\r\n",font4));
			table03ssr.addCell(cell03ssr);
			PdfPCell cell0312ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst1(): "" +"\r\n\r\n", font5));
		    table03ssr.addCell(cell0312ssr);
		    
			document.add(table03ssr);
			
			
		    
		    
			PdfPTable table3ssr = new PdfPTable(2);
			table3ssr.setWidthPercentage(100f);
			table3ssr.setWidths(new int[] { 70, 70});
		
		
//
//			PdfPCell cell13ssr = new PdfPCell(new Paragraph("4.Type of Institution:\r\n\r\n",font4));
//			cell13ssr.setHorizontalAlignment(Element.ALIGN_LEFT);
//			table3ssr.addCell(cell13ssr);
//
//		PdfPCell cell14ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst4():"" +"\r\n\r\n", font5));
//		table3ssr.addCell(cell14ssr);
//	table03ssr.addCell(table3ssr);
		
	
			
			
			document.add(table3ssr);
			

			PdfPTable table04ssr = new PdfPTable(1);
			table04ssr.setWidthPercentage(100f);

		PdfPCell cell041111111111ssr = new PdfPCell(new Paragraph("4.Type of Institution\r\n\r\n",font4));
		cell041111111111ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		
			table04ssr.addCell(cell041111111111ssr);
			
			
			document.add(table04ssr);
			
		
			PdfPTable table4ssr = new PdfPTable(2);
			table4ssr.setWidthPercentage(100f);
			table4ssr.setWidths(new int[] { 3, 3 });
		

			PdfPCell cell15ssr = new PdfPCell(new Paragraph("By Gender\r\n\r\n" +"\r\n\r\n", font5));
			table4ssr.addCell(cell15ssr);

			PdfPCell cell16ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst2(): "" +"\r\n\r\n", font5));
			table4ssr.addCell(cell16ssr);

			PdfPCell cell17ssr = new PdfPCell(new Paragraph("By Shift\r\n\r\n" +"\r\n\r\n", font5));
			table4ssr.addCell(cell17ssr);

			PdfPCell cell18ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst3(): "" +"\r\n\r\n", font5));


			table4ssr.addCell(cell18ssr);
			
		//	table04ssr.setSpacingAfter(20f);
	
			
		
		

			
			document.add(table4ssr);
		

			PdfPTable table05ssr = new PdfPTable(1);
			table05ssr.setWidthPercentage(100f);

			PdfPCell cell06ssr = new PdfPCell(new Paragraph("5.Recognized Minority institution\r\n\r\n", font4));
			cell06ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table05ssr.addCell(cell06ssr);
			
			document.add(table05ssr);

			PdfPTable table5ssr = new PdfPTable(2);
			table5ssr.setWidthPercentage(100f);
			table5ssr.setWidths(new int[] { 70, 70 });
			
	

			PdfPCell cell07ssr = new PdfPCell(new Paragraph("If it is a recognized minority institution\r\n\r\n" +"\r\n\r\n", font5));
			table5ssr.addCell(cell07ssr);
			PdfPCell cell20ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst4(): "" +"\r\n\r\n", font5));
			table5ssr.addCell(cell20ssr);
			
			document.add(table5ssr);
			
			PdfPTable table106ssr = new PdfPTable(1);
			table106ssr.setWidthPercentage(100f);
			
			PdfPCell cell0722ssr = new PdfPCell(new Paragraph("6. Source of funding: Government Grant-in-aid Self-finacing Any other\n\r\n",font4));
			
			cell0722ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
			table106ssr.addCell(cell0722ssr);
			PdfPCell cell2022ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst5(): "" +"\r\n\r\n", font5));
			table106ssr.addCell(cell2022ssr);
			
		
document.add(table106ssr);
			
		
			
		
		

			PdfPTable table06ssr = new PdfPTable(1);
			table06ssr.setWidthPercentage(100f);

			PdfPCell cell08ssr = new PdfPCell(new Paragraph("7.Establishment Details\r\n\r\n",font4));
			cell08ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
			table06ssr.addCell(cell08ssr);
		
			

			PdfPTable table6ssr = new PdfPTable(2);
			table6ssr.setWidthPercentage(100f);
			table6ssr.setWidths(new int[] { 75, 75 });
			
		

			PdfPCell cell21ssr = new PdfPCell(
					new Paragraph("a. Date of Establishment, Prior to the Grant of 'Autonomy'\r\n\r\n" +"\r\n\r\n", font5));

			table6ssr.addCell(cell21ssr);

			PdfPCell cell22ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst6(): "" +"\r\n\r\n", font5));
			table6ssr.addCell(cell22ssr);

			PdfPCell cell23ssr = new PdfPCell(new Paragraph("b. University to which the college is affiliated / or which governs the college (If it is a constituent college)\r\n\r\n" +"\r\n\r\n", font5));
			table6ssr.addCell(cell23ssr);

			PdfPCell cell24ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst7(): "" +"\r\n\r\n", font5));
			table6ssr.addCell(cell24ssr);

			table4ssr.addCell(cell21ssr);


		//	table06ssr.addCell(table6ssr);
		//	table06ssr.setSpacingAfter(20f);
		//	table06ssr.setSpacingBefore(20f);
			document.add(table06ssr);
			
			document.add(table6ssr);
	

			PdfPTable table010ssr = new PdfPTable(1);
			table010ssr.setWidthPercentage(100f);
			PdfPTable table07ssr = new PdfPTable(1);
			table07ssr.setWidthPercentage(100f);

			PdfPCell cell09ssr = new PdfPCell(new Paragraph("c. Details of UGC recognition:\r\n\r" +"\r\n\r\n", font5));
			table07ssr.addCell(cell09ssr);

			PdfPTable table7ssr = new PdfPTable(3);
			table7ssr.setWidthPercentage(100f);

		

			cell.setPhrase(new Phrase("Under Section\r\n", font4));
			table7ssr.addCell(cell);
			cell.setPhrase(new Phrase("Date, Month & Year (dd-mm-yyyy)\r\n", font4));
			table7ssr.addCell(cell);
			cell.setPhrase(new Phrase("Remarks(If any)\r\n", font4));
			table7ssr.addCell(cell);
			
			cell.setPhrase(new Phrase("i. 2(f)\r\n", font4));
			table7ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getDetailsofUgcRecognition().get(0).getInputst9(): "" +"\r\n\r\n", font5));
			table7ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getDetailsofUgcRecognition().get(0).getInputst10(): "" +"\r\n\r\n", font5));
			table7ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("i. 2(B)\r\n", font4));
			table7ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getDetailsofUgcRecognition().get(1).getInputst9(): "" +"\r\n\r\n", font5));
			table7ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getDetailsofUgcRecognition().get(1).getInputst10(): "" +"\r\n\r\n", font5));
			table7ssr.addCell(cell);
			
			
			document.add(table7ssr);
			
			
			


			PdfPTable table09ssr = new PdfPTable(1);
			table09ssr.setWidthPercentage(100f);
			PdfPCell cell122ssr = new PdfPCell(new Paragraph(
					"Details of recognition/approval by stationary/regulatory bodies like AICTE,NCTE,MCI,DCI,PCI,RCI etc(other than UGC)"
					));
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
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd15():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd11():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd12():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd13():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd14():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(1).getInputbtd15():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(1).getInputbtd11():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(1).getInputbtd12():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(1).getInputbtd13():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(1).getInputbtd14():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(2).getInputbtd15():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(2).getInputbtd11():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(2).getInputbtd12():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(2).getInputbtd13():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(2).getInputbtd14():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(3).getInputbtd15():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(3).getInputbtd11():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(3).getInputbtd12():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(3).getInputbtd13():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);

			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(3).getInputbtd14():"" +"\r\n\r\n", font5));
			table9ssr.addCell(cell);
			
			
			
			
			
			
			
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getRecognition().get(0).getInputbtd16():"" +"\r\n\r\n", font5));
//			table9ssr.addCell(cell);


			cell.setPadding(5);
		//	table09ssr.addCell(table9ssr);
		//	table09ssr.setSpacingBefore(20f);
			document.add(table09ssr);
			
			
			
		//	document.add(table9ssr);
		//	table09ssr.setSpacingAfter(20f);
	

			document.add(table07ssr);
	//	document.add(table08ssr);
	//		table010ssr.addCell(table09ssr);
		//	table010ssr.setSpacingAfter(20f);
		//	table010ssr.setSpacingBefore(20f);
			
			
			Paragraph paragraph1366ssr = new Paragraph("8. Does the affiliating university Act provide for conferment of autonomy (as recognized by the UGC), on its affiliated colleges?",font4);
			document.add(paragraph1366ssr);
			Paragraph paragraph13660ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst8():"" +"\r\n\r\n", font5);
			document.add(paragraph13660ssr);
			
			Paragraph paragraph1367ssr = new Paragraph("If yes, has the College applied for availing the autonomous status?",font4);
			document.add(paragraph1367ssr);
			Paragraph paragraph13671ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst11 ():"" +"\r\n\r\n", font5);
		    document.add(paragraph13671ssr);
			
					Paragraph paragraph1368ssr = new Paragraph("9. Is the college recognized"
							+"\r\n",font4);
					document.add(paragraph1368ssr);
					Paragraph paragraph13681ssr = new Paragraph("a. by UGC as a College with Potential for Excellence (CPE)?",font4);
					document.add(paragraph13681ssr);
					Paragraph paragraph13682ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst12():"" +"\r\n\r\n", font5);
							document.add(paragraph13682ssr);
			
				   Paragraph paragraph1369ssr = new Paragraph("If yes, date of recognition:....(dd/mm/yyyy)");
				   document.add(paragraph1369ssr);
				   Paragraph paragraph13691ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst13():""+"\r\n"+ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst14():"",font4);
					document.add(paragraph13691ssr);
				
			
			
			
					Paragraph paragraph13632ssr = new Paragraph("b. For its performance by any other governmental agency?",font4);
					document.add(paragraph13632ssr);
					
					Paragraph paragraph136321ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst15():"" +"\r\n\r\n", font5);
					document.add(paragraph136321ssr);
											
					Paragraph paragraph13633ssr = new Paragraph("If yes, Name of the agency.....",font4);
					document.add(paragraph13633ssr);
					Paragraph paragraph136332ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst16():"" +"\r\n\r\n", font5);
					document.add(paragraph136332ssr);						

					Paragraph paragraph13634ssr = new Paragraph("If yes, Name of the agency.....",font4);
					document.add(paragraph13634ssr);
					Paragraph paragraph13635ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedStatus().get(0).getInputst17():"" +"\r\n\r\n", font5);
					document.add(paragraph13635ssr);						
					
					
					
			
			
			

			PdfPTable table011ssr = new PdfPTable(1);
			table011ssr.setWidthPercentage(100f);
			PdfPCell cell011ssr = new PdfPCell(new Paragraph("10. Location of the campus and area in sq.mts:\r\n\r\n", font4));
			table011ssr.addCell(cell011ssr);
			document.add(table011ssr);
			
			PdfPTable table11ssr = new PdfPTable(2);
			table11ssr.setWidthPercentage(100f);
			table11ssr.setWidths(new int[] { 3, 3 });
			

			PdfPCell cell30ssr = new PdfPCell(new Paragraph(
					"Location" +"\r\n\r\n", font5));
			table11ssr.addCell(cell30ssr);

			PdfPCell cell31ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedCampus().get(0).getInputst18():"" +"\r\n\r\n", font5));
			table11ssr.addCell(cell31ssr);

			PdfPCell cell32ssr = new PdfPCell(new Paragraph(
					"Campus area in sq.mts." + "\r\n" +"\r\n\r\n", font5));
			table11ssr.addCell(cell32ssr);

			PdfPCell cell28ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedCampus().get(0).getInputst19():"" +"\r\n\r\n", font5));
			table11ssr.addCell(cell28ssr);

			PdfPCell cell29ssr = new PdfPCell(new Paragraph("Built up area in sq.mts.\r\n" +"\r\n\r\n", font5));
			table11ssr.addCell(cell29ssr);

			PdfPCell cell131ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedCampus().get(0).getInputst20():"" +"\r\n\r\n", font5));
			table11ssr.addCell(cell131ssr);
		
		
			
			document.add(table11ssr);
			
			

			PdfPTable table012ssr = new PdfPTable(1);
			table012ssr.setWidthPercentage(100f);

			PdfPCell cell012ssr = new PdfPCell(new Paragraph("11. Details of programmes offered by the college(Give data for current academic year)", font4));
		
			cell012ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
			table012ssr.addCell(cell012ssr);
			
			

			PdfPTable table12ssr = new PdfPTable(8);
			table12ssr.setWidthPercentage(100f);
			table12ssr.setWidths(new int[] { 60, 60, 60, 60, 60,60,60,60 });
	

			cell.setPhrase(new Phrase("SI.No\r\n\r\n", font4));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("Programme Level\r\n\r\n", font4));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("Name of the Programme/ Course\r\n\r\n", font4));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("Duration\r\n\r\n", font4));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("Entry Qulaification\r\n\r\n", font4));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("Medium of instruction \r\n\r\n", font4));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("Sanctioned/ approved Student strength \r\n\r\n", font4));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase("No. of students admitted \r\n\r\n", font4));
			table12ssr.addCell(cell);
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad1():"" +"\r\n\r\n", font5));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad11():"" +"\r\n\r\n", font5));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad12():"" +"\r\n\r\n", font5));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad13():"" +"\r\n\r\n", font5));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad14():"" +"\r\n\r\n", font5));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad15():"" +"\r\n\r\n", font5));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad16():"" +"\r\n\r\n", font5));
			table12ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAcademicinformation().get(0).getInputad17():"" +"\r\n\r\n", font5));
			table12ssr.addCell(cell);
		
			cell.setPadding(5);

			document.add(table012ssr);
		
			document.add(table12ssr);
			
			
			
			

			PdfPTable table0122ssr = new PdfPTable(1);
			table0122ssr.setWidthPercentage(100f);

			PdfPCell cell0122ssr = new PdfPCell(new Paragraph("12. Please fill in the following details if applicable:\r\n"
					+ "\r\n"
					+ "", font4));
			
			cell0122ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table0122ssr.addCell(cell0122ssr);
			
			
			
			PdfPCell cell0123ssr = new PdfPCell(new Paragraph("Number of programs"
					+ "\r\n"
					+ "", font4));
			
			cell0123ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
			table0122ssr.addCell(cell0123ssr);


			PdfPTable table122ssr = new PdfPTable(2);
			table122ssr.setWidthPercentage(100f);
			
			PdfPCell cell0124ssr = new PdfPCell(new Paragraph("Self-financed programmes offered" +"\r\n\r\n", font5));
			table122ssr.addCell(cell0124ssr);
			
			PdfPCell cell0125ssr = new PdfPCell(new Paragraph("New Programmes introduced during the last five years" +"\r\n\r\n", font5));
			table122ssr.addCell(cell0125ssr);

			PdfPCell cell0126ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedProgrammes().get(0).getInputpt1():"" +"\r\n\r\n", font5));
			table122ssr.addCell(cell0126ssr);
			
//			PdfPCell cell0127ssr = new PdfPCell(new Paragraph("New Programmes introduced during the last five years" +"\r\n\r\n", font5));
//			table122ssr.addCell(cell0127ssr);

			PdfPCell cell0128ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedProgrammes().get(0).getInputpt2():"" +"\r\n\r\n", font5));
			table122ssr.addCell(cell0128ssr);
			
			cell.setPadding(5);

			//table0122ssr.addCell(table122ssr);
			
		//	table0122ssr.setSpacingBefore(20f);
			document.add(table0122ssr);
		
			
			
			document.add(table122ssr);
			
			
			
			//13
			PdfPTable table013ssr = new PdfPTable(1);
			table013ssr.setWidthPercentage(100f);

			PdfPCell cell013ssr = new PdfPCell(new Paragraph("13.List the Departments: (respond if applicable only and do not list facilities like Library, Physical Education as departments, unless they are also offering academic degree awarding programmes. similarly, do not list the departments offering common compulsory subjects for all the programmes. like english, regional languages etc..)\r\n"
					+ "\r\n"
					+ "", font4));
			
			
			
			cell013ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
			table013ssr.addCell(cell013ssr);
			
			PdfPTable table13ssr = new PdfPTable(5);
			table13ssr.setWidthPercentage(100f);
			
			PdfPCell cell0131ssr = new PdfPCell(new Paragraph("Faculty" +"\r\n\r\n", font5));
			table13ssr.addCell(cell0131ssr);
			
			
			PdfPCell cell0133ssr = new PdfPCell(new Paragraph("Departments (eg Physics,Botany,History etc." +"\r\n\r\n", font5));
			table13ssr.addCell(cell0133ssr);
			PdfPCell cell0134ssr = new PdfPCell(new Paragraph("UG" +"\r\n\r\n", font5));
			table13ssr.addCell(cell0134ssr);
			PdfPCell cell0135ssr = new PdfPCell(new Paragraph("PG" +"\r\n\r\n", font5));
			table13ssr.addCell(cell0135ssr);
			PdfPCell cell0136ssr = new PdfPCell(new Paragraph("Research" +"\r\n\r\n", font5));
			table13ssr.addCell(cell0136ssr);
			
			PdfPCell cell0137ssr = new PdfPCell(new Paragraph("Science" +"\r\n\r\n", font5));
			table13ssr.addCell(cell0137ssr);
			
			PdfPCell cell0138ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(0).getInputdt2():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell0138ssr);
			
			PdfPCell cell0139ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(0).getInputdt3():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell0139ssr);
			
			PdfPCell cell01310ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(0).getInputdt4():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01310ssr);
			
			PdfPCell cell01311ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(0).getInputdt5():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01311ssr);
			
			PdfPCell cell01312ssr = new PdfPCell(new Paragraph("Arts" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01312ssr);
			
			PdfPCell cell01313ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(1).getInputdt2():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01313ssr);
			PdfPCell cell01314ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(1).getInputdt3():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01314ssr);
			PdfPCell cell01315ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(1).getInputdt4():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01315ssr);
			PdfPCell cell01316ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(1).getInputdt5():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01316ssr);
			
			
			PdfPCell cell01317ssr = new PdfPCell(new Paragraph("Commerce" +"\r\n\r\n", font5));
			
			
			table13ssr.addCell(cell01317ssr);
			
			PdfPCell cell01318ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(2).getInputdt2():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01318ssr);
			PdfPCell cell01319ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(2).getInputdt3():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01319ssr);
			PdfPCell cell01320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(2).getInputdt4():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01320ssr);
			PdfPCell cell01321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(2).getInputdt5():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01321ssr);
			
			
			
			PdfPCell cell01322ssr = new PdfPCell(new Paragraph("Any other (Specify) :" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01322ssr);
			
			PdfPCell cell01323ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(3).getInputdt2():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01323ssr);
			PdfPCell cell01324ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(3).getInputdt3():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01324ssr);
			PdfPCell cell01325ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(3).getInputdt4():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01325ssr);
			PdfPCell cell01326ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedDepartment().get(3).getInputdt5():"" +"\r\n\r\n", font5));
			table13ssr.addCell(cell01326ssr);
			
			
			
		
			
		//	table013ssr.addCell(table13ssr);
			
			document.add(table013ssr);
			
			document.add(table13ssr);
			
			////////////14
			
			PdfPTable table23ssr = new PdfPTable(9);
			PdfPTable table24ssr = new PdfPTable(1);
			
			 float[] columnWidths3 = { 70f,70f,70f,70f,70f,70f,70f,70f,70f,70f,70f }; // Second column will be // twice as first and third
//			 table23ssr.setWidths(columnWidths3);
			 
	// Setting width of table, its columns and spacing
			table23ssr.setWidthPercentage(100);
			table24ssr.setWidthPercentage(100);

			PdfPCell cell028ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n	" +"\r\n\r\n", font5));
			PdfPCell cell029ssr = new PdfPCell(new Paragraph("Professor\r\n" +"\r\n\r\n", font5));
			cell029ssr.setColspan(2);
			PdfPCell cell030ssr = new PdfPCell(new Paragraph("Associate Professor\r\n" +"\r\n\r\n", font5));
			cell030ssr.setColspan(2);
			PdfPCell cell031ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n" +"\r\n\r\n", font5));
			cell031ssr.setColspan(2);
			PdfPCell cell032ssr = new PdfPCell(new Paragraph("Non-teaching staff" +"\r\n\r\n", font5));
			PdfPCell cell0324ssr = new PdfPCell(new Paragraph("Teaching staff" +"\r\n\r\n", font5));

			PdfPCell cell0132ssr = new PdfPCell(new Paragraph("Male\r\n" +"\r\n\r\n", font5));
			PdfPCell cell0332ssr = new PdfPCell(new Paragraph("Female\r\n" +"\r\n\r\n", font5));
//			PdfPCell cell0432ssr = new PdfPCell(new Paragraph("Others\r\n" +"\r\n\r\n", font5));
			PdfPCell cell0532ssr = new PdfPCell(new Paragraph("Male\r\n" +"\r\n\r\n", font5));
			PdfPCell cell0632ssr = new PdfPCell(new Paragraph("Female\r\n" +"\r\n\r\n", font5));
//			PdfPCell cell0732ssr = new PdfPCell(new Paragraph("Others\r\n" +"\r\n\r\n", font5));
			PdfPCell cell0832ssr = new PdfPCell(new Paragraph("Male\r\n" +"\r\n\r\n", font5));
			PdfPCell cell0932ssr = new PdfPCell(new Paragraph("Female\r\n" +"\r\n\r\n", font5));
//			PdfPCell cell01032ssr = new PdfPCell(new Paragraph("Others\r\n" +"\r\n\r\n", font5));
//			PdfPCell cell01132ssr = new PdfPCell(new Paragraph("total\r\n" +"\r\n\r\n", font5));

			PdfPCell cell01232ssr = new PdfPCell(new Paragraph("Sanctioned by the UGC/ University/ State Government" +"\r\n\r\n", font5));
			PdfPCell cell01332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt1():"" +"\r\n\r\n", font5));
			PdfPCell cell01432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt2():"" +"\r\n\r\n", font5));
			PdfPCell cell01532ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt3():"" +"\r\n\r\n", font5));

			PdfPCell cell01632ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt4():"" +"\r\n\r\n", font5));
			PdfPCell cell01732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt5():"" +"\r\n\r\n", font5));
			PdfPCell cell01832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt6():"" +"\r\n\r\n", font5));

			PdfPCell cell01932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt7():"" +"\r\n\r\n", font5));
			PdfPCell cell02032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(0).getInputatt8():"" +"\r\n\r\n", font5));
//			PdfPCell cell02132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq19():"" +"\r\n\r\n", font5));
	//
//			PdfPCell cell02232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(0).getInputatq110():"" +"\r\n\r\n", font5));

			PdfPCell cell02332ssr = new PdfPCell(new Paragraph("Recruited" +"\r\n\r\n", font5));
			PdfPCell cell02432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt1():"" +"\r\n\r\n", font5));
			PdfPCell cell02532ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt2():"" +"\r\n\r\n", font5));
			PdfPCell cell02632ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt3():"" +"\r\n\r\n", font5));

			PdfPCell cell02732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt4():"" +"\r\n\r\n", font5));
			PdfPCell cell02832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt5():"" +"\r\n\r\n", font5));
			PdfPCell cell02932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt6():"" +"\r\n\r\n", font5));

			PdfPCell cell03032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt7():"" +"\r\n\r\n", font5));
			PdfPCell cell03132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(1).getInputatt8():"" +"\r\n\r\n", font5));
//			PdfPCell cell03232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(1).getInputatq19():"" +"\r\n\r\n", font5));
//			PdfPCell cell03332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(1).getInputatq110():"" +"\r\n\r\n", font5));

			PdfPCell cell034321ssr = new PdfPCell(new Paragraph("Yet to Recruit" +"\r\n\r\n", font5));
			PdfPCell cell03532ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt1():"" +"\r\n\r\n", font5));
			PdfPCell cell03632ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt2():"" +"\r\n\r\n", font5));
			PdfPCell cell03732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt3():"" +"\r\n\r\n", font5));

			PdfPCell cell03832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt4():"" +"\r\n\r\n", font5));
			PdfPCell cell03932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt5():"" +"\r\n\r\n", font5));
			PdfPCell cell04032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt6():"" +"\r\n\r\n", font5));

			PdfPCell cell04132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt7():"" +"\r\n\r\n", font5));
			PdfPCell cell04232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(2).getInputatt8():"" +"\r\n\r\n", font5));
//			PdfPCell cell04332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(2).getInputatq19():"" +"\r\n\r\n", font5));
//			PdfPCell cell04432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(2).getInputatq110():"" +"\r\n\r\n", font5));

			PdfPCell cell04532ssr = new PdfPCell(new Paragraph("Sanctioned by the Management/ Society/ or other Authorised Body" +"\r\n\r\n", font5));
			PdfPCell cell04632ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt1():"" +"\r\n\r\n", font5));
			PdfPCell cell04732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt2():"" +"\r\n\r\n", font5));
			PdfPCell cell04832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt3():"" +"\r\n\r\n", font5));

			PdfPCell cell04932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt4():"" +"\r\n\r\n", font5));
			PdfPCell cell05032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt5():"" +"\r\n\r\n", font5));
			PdfPCell cell05132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt6():"" +"\r\n\r\n", font5));

			PdfPCell cell05232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt7():"" +"\r\n\r\n", font5));
			PdfPCell cell05332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(3).getInputatt8():"" +"\r\n\r\n", font5));
//			PdfPCell cell05432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(3).getInputatq19():"" +"\r\n\r\n", font5));
//			PdfPCell cell05532ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.academicPerminentTeachers.get(3).getInputatq110():"" +"\r\n\r\n", font5));

			PdfPCell cell05632ssr = new PdfPCell(new Paragraph("Recruited" +"\r\n\r\n", font5));
			PdfPCell cell05732ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt1():"" +"\r\n\r\n", font5));
			PdfPCell cell05832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt2():"" +"\r\n\r\n", font5));
			PdfPCell cell05932ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt3():"" +"\r\n\r\n", font5));

			PdfPCell cell06032ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt4():"" +"\r\n\r\n", font5));
			PdfPCell cell06132ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt5():"" +"\r\n\r\n", font5));
			PdfPCell cell06232ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt6():"" +"\r\n\r\n", font5));

			PdfPCell cell06332ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt7():"" +"\r\n\r\n", font5));
			PdfPCell cell06432ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(4).getInputatt8():"" +"\r\n\r\n", font5));
			
			
			
			PdfPCell cell056321ssr = new PdfPCell(new Paragraph("Yet to Recruit" +"\r\n\r\n", font5));
			PdfPCell cell057321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt1():"" +"\r\n\r\n", font5));
			PdfPCell cell058321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt2():"" +"\r\n\r\n", font5));
			PdfPCell cell059321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt3():"" +"\r\n\r\n", font5));
			PdfPCell cell060321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt4():"" +"\r\n\r\n", font5));
			PdfPCell cell061321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt5():"" +"\r\n\r\n", font5));
			PdfPCell cell062321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt6():"" +"\r\n\r\n", font5));

			PdfPCell cell063321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt7():"" +"\r\n\r\n", font5));
			PdfPCell cell064321ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedInstitution().get(5).getInputatt8():"" +"\r\n\r\n", font5));

//			PdfPCell cell06632ssr = new PdfPCell(new Paragraph());

			table23ssr.addCell(cell028ssr);
			table23ssr.addCell(cell029ssr);
			table23ssr.addCell(cell030ssr);
			table23ssr.addCell(cell031ssr);
			table23ssr.addCell(cell032ssr);
			table23ssr.addCell(cell0324ssr);

			table23ssr.addCell(cell0132ssr);
			table23ssr.addCell(cell0332ssr);
//			table23ssr.addCell(cell0432ssr);
			table23ssr.addCell(cell0532ssr);
			table23ssr.addCell(cell0632ssr);
//			table23ssr.addCell(cell0732ssr);
			table23ssr.addCell(cell0832ssr);
			table23ssr.addCell(cell0932ssr);
//			table23ssr.addCell(cell01032ssr);
//			table23ssr.addCell(cell01132ssr);

			table23ssr.addCell(cell01232ssr);
			table23ssr.addCell(cell01332ssr);
			table23ssr.addCell(cell01432ssr);
			table23ssr.addCell(cell01532ssr);
			table23ssr.addCell(cell01632ssr);
			table23ssr.addCell(cell01732ssr);
			table23ssr.addCell(cell01832ssr);
			table23ssr.addCell(cell01932ssr);
			table23ssr.addCell(cell02032ssr);
//			table23ssr.addCell(cell02132ssr);
//			table23ssr.addCell(cell02232ssr);

			table23ssr.addCell(cell02332ssr);
			table23ssr.addCell(cell02432ssr);
			table23ssr.addCell(cell02532ssr);
			table23ssr.addCell(cell02632ssr);
			table23ssr.addCell(cell02732ssr);
			table23ssr.addCell(cell02832ssr);
			table23ssr.addCell(cell02932ssr);
			table23ssr.addCell(cell03032ssr);
			table23ssr.addCell(cell03132ssr);
//			table23ssr.addCell(cell03232ssr);
//			table23ssr.addCell(cell03332ssr);

			table23ssr.addCell(cell04532ssr);
			table23ssr.addCell(cell04632ssr);
			table23ssr.addCell(cell04732ssr);
			table23ssr.addCell(cell04832ssr);
			table23ssr.addCell(cell04932ssr);
			table23ssr.addCell(cell05032ssr);
			table23ssr.addCell(cell05132ssr);
			table23ssr.addCell(cell05232ssr);
			table23ssr.addCell(cell05332ssr);
//			table23ssr.addCell(cell05432ssr);
//			table23ssr.addCell(cell05532ssr);

			table23ssr.addCell(cell034321ssr);
			table23ssr.addCell(cell03532ssr);
			table23ssr.addCell(cell03632ssr);
			table23ssr.addCell(cell03732ssr);
			table23ssr.addCell(cell03832ssr);
			table23ssr.addCell(cell03932ssr);
			table23ssr.addCell(cell04032ssr);
			table23ssr.addCell(cell04132ssr);
			table23ssr.addCell(cell04232ssr);
//			table23ssr.addCell(cell04332ssr);
//			table23ssr.addCell(cell04432ssr);

			table23ssr.addCell(cell05632ssr);
			table23ssr.addCell(cell05732ssr);
			table23ssr.addCell(cell05832ssr);
			table23ssr.addCell(cell05932ssr);
			table23ssr.addCell(cell06032ssr);
			table23ssr.addCell(cell06132ssr);
			table23ssr.addCell(cell06232ssr);
			table23ssr.addCell(cell06332ssr);
			table23ssr.addCell(cell06432ssr);
//			table23ssr.addCell(cell06532ssr);
//			table23ssr.addCell(cell06632ssr);
			
			
			
			table23ssr.addCell(cell056321ssr);
			table23ssr.addCell(cell057321ssr);
			table23ssr.addCell(cell058321ssr);
			table23ssr.addCell(cell059321ssr);
			table23ssr.addCell(cell060321ssr);
			table23ssr.addCell(cell061321ssr);
			table23ssr.addCell(cell062321ssr);
			table23ssr.addCell(cell063321ssr);
			table23ssr.addCell(cell064321ssr);


			 PdfPCell cell0186ssr = new PdfPCell(new Paragraph("14.Number of teaching and non-teaching positions in the Institution",font4));
			 cell0186ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
			 
				
			 table24ssr.addCell(cell0186ssr);

	//
	



			
			
		//	table24ssr.setSpacingBefore(20f);
	//		table24ssr.setSpacingBefore(10f);
			
			document.add(table24ssr);
			
			document.add(table23ssr);
			
			
			
			
			

			
			///////////////////////////
			
			
			PdfPTable table29ssr = new PdfPTable(11);
			PdfPTable table30ssr = new PdfPTable(1);
			
			 float[] columnWidth5 = { 7f }; // Second column will be // twice as first and third
			 table30ssr.setWidths(columnWidth5);


	// Setting width of table, its columns and spacing
			table29ssr.setWidthPercentage(100);
			table30ssr.setWidthPercentage(100);

			PdfPCell cell043ssr = new PdfPCell(new Paragraph("Highest Qualification\r\n" +"\r\n\r\n", font5));
			PdfPCell cell044ssr = new PdfPCell(new Paragraph("Professor\r\n" +"\r\n\r\n", font5));
			cell044ssr.setColspan(2);
			PdfPCell cell045ssr = new PdfPCell(new Paragraph("Associate Professor\r\n" +"\r\n\r\n", font5));
			cell045ssr.setColspan(2);
			PdfPCell cell046ssr = new PdfPCell(new Paragraph("Assistant Professor\r\n" +"\r\n\r\n", font5));
			cell046ssr.setColspan(2);
			PdfPCell cell048ssr = new PdfPCell(new Paragraph("" +"\r\n\r\n", font5));
			PdfPCell cell04308ssr = new PdfPCell(new Paragraph("" +"\r\n\r\n", font5));

			PdfPCell cell0001320ssr = new PdfPCell(new Paragraph("Male\r\n" +"\r\n\r\n", font5));
			PdfPCell cell0003320ssr = new PdfPCell(new Paragraph("Female\r\n" +"\r\n\r\n", font5));
//			PdfPCell cell0004320ssr = new PdfPCell(new Paragraph("Others\r\n" +"\r\n\r\n", font5));
			PdfPCell cell0005320ssr = new PdfPCell(new Paragraph("Male\r\n" +"\r\n\r\n", font5));
			PdfPCell cell0006320ssr = new PdfPCell(new Paragraph("Female\r\n" +"\r\n\r\n", font5));
//			PdfPCell cell0007320ssr = new PdfPCell(new Paragraph("Others\r\n" +"\r\n\r\n", font5));
			PdfPCell cell0008320ssr = new PdfPCell(new Paragraph("Male\r\n" +"\r\n\r\n", font5));
			PdfPCell cell0009320ssr = new PdfPCell(new Paragraph("Female\r\n" +"\r\n\r\n", font5));
//			PdfPCell cell00010302ssr = new PdfPCell(new Paragraph("Others\r\n" +"\r\n\r\n", font5));
			PdfPCell cell00011320ssr = new PdfPCell(new Paragraph("total\r\n" +"\r\n\r\n", font5));

			PdfPCell cell0012320ssr = new PdfPCell(new Paragraph("Permanent teachers" +"\r\n\r\n", font5));
			PdfPCell cell0013320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats1():"" +"\r\n\r\n", font5));
			PdfPCell cell0014320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats2():"" +"\r\n\r\n", font5));
			PdfPCell cell0015320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats3():"" +"\r\n\r\n", font5));

			PdfPCell cell0016320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats4():"" +"\r\n\r\n", font5));
			PdfPCell cell0017320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats5():"" +"\r\n\r\n", font5));
			PdfPCell cell0018320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats6():"" +"\r\n\r\n", font5));

			PdfPCell cell0019320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(0).getInputats7():"" +"\r\n\r\n", font5));
//			PdfPCell cell0020320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(0).getInputatq98():"" +"\r\n\r\n", font5));
//			PdfPCell cell0021320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(0).getInputatq99():"" +"\r\n\r\n", font5));
	//
//			PdfPCell cell0022320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(0).getInputatq910():"" +"\r\n\r\n", font5));

			PdfPCell cell0203320ssr = new PdfPCell(new Paragraph("D.Sc./D.Litt." +"\r\n\r\n", font5));
			PdfPCell cell0204320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats1():"" +"\r\n\r\n", font5));
			PdfPCell cell0205320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats2():"" +"\r\n\r\n", font5));
			PdfPCell cell0206320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats3():"" +"\r\n\r\n", font5));
			PdfPCell cell0207320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats4():"" +"\r\n\r\n", font5));
			PdfPCell cell0208320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats5():"" +"\r\n\r\n", font5));
			PdfPCell cell0209320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats6():"" +"\r\n\r\n", font5));
			PdfPCell cell0300320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(1).getInputats7():"" +"\r\n\r\n", font5));
//			PdfPCell cell0310320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(1).getInputatq98():"" +"\r\n\r\n", font5));
//			PdfPCell cell0320320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(1).getInputatq99():"" +"\r\n\r\n", font5));
//			PdfPCell cell0330320ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(1).getInputatq910():"" +"\r\n\r\n", font5));

			PdfPCell cell0343200ssr = new PdfPCell(new Paragraph("Ph.D" +"\r\n\r\n", font5));
			PdfPCell cell0353200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats1():"" +"\r\n\r\n", font5));
			PdfPCell cell0363200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats2():"" +"\r\n\r\n", font5));
			PdfPCell cell0373200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats3():"" +"\r\n\r\n", font5));

			PdfPCell cell0383200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats4():"" +"\r\n\r\n", font5));
			PdfPCell cell0393200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats5():"" +"\r\n\r\n", font5));
			PdfPCell cell0403200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats6():"" +"\r\n\r\n", font5));
			PdfPCell cell0413200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(2).getInputats7():"" +"\r\n\r\n", font5));
//			PdfPCell cell0423200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(2).getInputatq98():"" +"\r\n\r\n", font5));
//			PdfPCell cell0433200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(2).getInputatq99():"" +"\r\n\r\n", font5));
//			PdfPCell cell0443200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(2).getInputatq910():"" +"\r\n\r\n", font5));

			PdfPCell cell0453200ssr = new PdfPCell(new Paragraph("M.Phil\r\n" +"\r\n\r\n", font5));
			PdfPCell cell0463200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats1():"" +"\r\n\r\n", font5));
			PdfPCell cell0473200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats2():"" +"\r\n\r\n", font5));
			PdfPCell cell0483200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats3():"" +"\r\n\r\n", font5));

			PdfPCell cell0493200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats4():"" +"\r\n\r\n", font5));
			PdfPCell cell0503200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats5():"" +"\r\n\r\n", font5));
			PdfPCell cell0513200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats6():"" +"\r\n\r\n", font5));
			PdfPCell cell0523200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(3).getInputats7():"" +"\r\n\r\n", font5));
//			PdfPCell cell0533200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(3).getInputatq98():"" +"\r\n\r\n", font5));
//			PdfPCell cell0543200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(3).getInputatq99():"" +"\r\n\r\n", font5));
//			PdfPCell cell0553200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(3).getInputatq910():"" +"\r\n\r\n", font5));

			PdfPCell cell0563200ssr = new PdfPCell(new Paragraph("PG\r\n" +"\r\n\r\n", font5));
			PdfPCell cell0573200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats1():"" +"\r\n\r\n", font5));
			PdfPCell cell0583200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats2():"" +"\r\n\r\n", font5));
			PdfPCell cell0593200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats3():"" +"\r\n\r\n", font5));
			PdfPCell cell0603200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats4():"" +"\r\n\r\n", font5));
			PdfPCell cell0613200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats5():"" +"\r\n\r\n", font5));
			PdfPCell cell0623200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats6():"" +"\r\n\r\n", font5));

			PdfPCell cell0633200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(4).getInputats7():"" +"\r\n\r\n", font5));
//	     	PdfPCell cell0643200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(4).getInputatq98():"" +"\r\n\r\n", font5));
//			PdfPCell cell0653200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(4).getInputatq99():"" +"\r\n\r\n", font5));

//			PdfPCell cell0663200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(4).getInputatq910():"" +"\r\n\r\n", font5));

			
			
			PdfPCell cell05632001ssr = new PdfPCell(new Paragraph("Part-time teachers\r\n" +"\r\n\r\n", font5));
			PdfPCell cell05732001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats1():"" +"\r\n\r\n", font5));
			PdfPCell cell05832001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats2():"" +"\r\n\r\n", font5));
			PdfPCell cell05932001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats3():"" +"\r\n\r\n", font5));

			PdfPCell cell06032001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats4():"" +"\r\n\r\n", font5));
			PdfPCell cell06132001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats5():"" +"\r\n\r\n", font5));
			PdfPCell cell06232001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats6():"" +"\r\n\r\n", font5));

			PdfPCell cell06332001ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(5).getInputats7():"" +"\r\n\r\n", font5));
			
			
			PdfPCell cell05632002ssr = new PdfPCell(new Paragraph("D.Sc./D.Litt.\r\n" +"\r\n\r\n", font5));
			PdfPCell cell05732002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats1():"" +"\r\n\r\n", font5));
			PdfPCell cell05832002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats2():"" +"\r\n\r\n", font5));
			PdfPCell cell05932002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats3():"" +"\r\n\r\n", font5));
			PdfPCell cell06032002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats4():"" +"\r\n\r\n", font5));
			PdfPCell cell06132002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats5():"" +"\r\n\r\n", font5));
			PdfPCell cell06232002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats6():"" +"\r\n\r\n", font5));
			PdfPCell cell06332002ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(6).getInputats7():"" +"\r\n\r\n", font5));
			
			PdfPCell cell05632003ssr = new PdfPCell(new Paragraph("D.Sc./D.Litt.\r\n" +"\r\n\r\n", font5));
			PdfPCell cell05732003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats1():"" +"\r\n\r\n", font5));
			PdfPCell cell05832003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats2():"" +"\r\n\r\n", font5));
			PdfPCell cell05932003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats3():"" +"\r\n\r\n", font5));
			PdfPCell cell06032003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats4():"" +"\r\n\r\n", font5));
			PdfPCell cell06132003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats5():"" +"\r\n\r\n", font5));
			PdfPCell cell06232003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats6():"" +"\r\n\r\n", font5));
			PdfPCell cell06332003ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(7).getInputats7():"" +"\r\n\r\n", font5));
			
			
			PdfPCell cell05632004ssr = new PdfPCell(new Paragraph("Ph.D\r\n" +"\r\n\r\n", font5));
			PdfPCell cell05732004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats1():"" +"\r\n\r\n", font5));
			PdfPCell cell05832004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats2():"" +"\r\n\r\n", font5));
			PdfPCell cell05932004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats3():"" +"\r\n\r\n", font5));
			PdfPCell cell06032004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats4():"" +"\r\n\r\n", font5));
			PdfPCell cell06132004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats5():"" +"\r\n\r\n", font5));
			PdfPCell cell06232004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats6():"" +"\r\n\r\n", font5));
			PdfPCell cell06332004ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(8).getInputats7():"" +"\r\n\r\n", font5));
			
			

			PdfPCell cell05632005ssr = new PdfPCell(new Paragraph("M.Phil\r\n" +"\r\n\r\n", font5));
			PdfPCell cell05732005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats1():"" +"\r\n\r\n", font5));
			PdfPCell cell05832005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats2():"" +"\r\n\r\n", font5));
			PdfPCell cell05932005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats3():"" +"\r\n\r\n", font5));
			PdfPCell cell06032005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats4():"" +"\r\n\r\n", font5));
			PdfPCell cell06132005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats5():"" +"\r\n\r\n", font5));
			PdfPCell cell06232005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats6():"" +"\r\n\r\n", font5));
			PdfPCell cell06332005ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(9).getInputats7():"" +"\r\n\r\n", font5));
			
			
			PdfPCell cell05632006ssr = new PdfPCell(new Paragraph("PG\r\n" +"\r\n\r\n", font5));
			PdfPCell cell05732006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats1():"" +"\r\n\r\n", font5));
			PdfPCell cell05832006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats2():"" +"\r\n\r\n", font5));
			PdfPCell cell05932006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats3():"" +"\r\n\r\n", font5));
			PdfPCell cell06032006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats4():"" +"\r\n\r\n", font5));
			PdfPCell cell06132006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats5():"" +"\r\n\r\n", font5));
			PdfPCell cell06232006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats6():"" +"\r\n\r\n", font5));
			PdfPCell cell06332006ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(10).getInputats7():"" +"\r\n\r\n", font5));
			
			
			
			
			
			table29ssr.addCell(cell043ssr);
			table29ssr.addCell(cell044ssr);
			table29ssr.addCell(cell045ssr);
			table29ssr.addCell(cell046ssr);
			table29ssr.addCell(cell048ssr);
			table29ssr.addCell(cell04308ssr);

			table29ssr.addCell(cell0001320ssr);
			table29ssr.addCell(cell0003320ssr);
//			table29ssr.addCell(cell0004320ssr);
			table29ssr.addCell(cell0005320ssr);
			table29ssr.addCell(cell0006320ssr);
//			table29ssr.addCell(cell0007320ssr);
			table29ssr.addCell(cell0008320ssr);
			table29ssr.addCell(cell0009320ssr);
//			table29ssr.addCell(cell00010302ssr);
			table29ssr.addCell(cell00011320ssr);

			table29ssr.addCell(cell0012320ssr);
			table29ssr.addCell(cell0013320ssr);
			table29ssr.addCell(cell0014320ssr);
			table29ssr.addCell(cell0015320ssr);
			table29ssr.addCell(cell0016320ssr);
			table29ssr.addCell(cell0017320ssr);
			table29ssr.addCell(cell0018320ssr);
			table29ssr.addCell(cell0019320ssr);
//			table29ssr.addCell(cell0020320ssr);
//			table29ssr.addCell(cell0021320ssr);
//			table29ssr.addCell(cell0022320ssr);

			table29ssr.addCell(cell0203320ssr);
			table29ssr.addCell(cell0204320ssr);
			table29ssr.addCell(cell0205320ssr);
			table29ssr.addCell(cell0206320ssr);
			table29ssr.addCell(cell0207320ssr);
			table29ssr.addCell(cell0208320ssr);
			table29ssr.addCell(cell0209320ssr);
			table29ssr.addCell(cell0300320ssr);
//			table29ssr.addCell(cell0310320ssr);
//			table29ssr.addCell(cell0320320ssr);
//			table29ssr.addCell(cell0330320ssr);

			table29ssr.addCell(cell0343200ssr);
			table29ssr.addCell(cell0353200ssr);
			table29ssr.addCell(cell0363200ssr);
			table29ssr.addCell(cell0373200ssr);
			table29ssr.addCell(cell0383200ssr);
			table29ssr.addCell(cell0393200ssr);
			table29ssr.addCell(cell0403200ssr);
			table29ssr.addCell(cell0413200ssr);
//			table29ssr.addCell(cell0423200ssr);
//			table29ssr.addCell(cell0433200ssr);
//			table29ssr.addCell(cell0443200ssr);

			table29ssr.addCell(cell0453200ssr);
			table29ssr.addCell(cell0463200ssr);
			table29ssr.addCell(cell0473200ssr);
			table29ssr.addCell(cell0483200ssr);
			table29ssr.addCell(cell0493200ssr);
			table29ssr.addCell(cell0503200ssr);
			table29ssr.addCell(cell0513200ssr);
			table29ssr.addCell(cell0523200ssr);
//			table29ssr.addCell(cell0533200ssr);
//			table29ssr.addCell(cell0543200ssr);
//			table29ssr.addCell(cell0553200ssr);
	//
			table29ssr.addCell(cell0563200ssr);
			table29ssr.addCell(cell0573200ssr);
			table29ssr.addCell(cell0583200ssr);
			table29ssr.addCell(cell0593200ssr);
			table29ssr.addCell(cell0603200ssr);
			table29ssr.addCell(cell0613200ssr);
			table29ssr.addCell(cell0623200ssr);
			table29ssr.addCell(cell0633200ssr);
//			table29ssr.addCell(cell0643200ssr);
//			table29ssr.addCell(cell0653200ssr);
//			table29ssr.addCell(cell0663200ssr);

			
			
			
			table29ssr.addCell(cell05632001ssr);
			table29ssr.addCell(cell05732001ssr);
			table29ssr.addCell(cell05832001ssr);
			table29ssr.addCell(cell05932001ssr);
			table29ssr.addCell(cell06032001ssr);
			table29ssr.addCell(cell06132001ssr);
			table29ssr.addCell(cell06232001ssr);
			table29ssr.addCell(cell06332001ssr);
			
			table29ssr.addCell(cell05632002ssr);
			table29ssr.addCell(cell05732002ssr);
			table29ssr.addCell(cell05832002ssr);
			table29ssr.addCell(cell05932002ssr);
			table29ssr.addCell(cell06032002ssr);
			table29ssr.addCell(cell06132002ssr);
			table29ssr.addCell(cell06232002ssr);
			table29ssr.addCell(cell06332002ssr);
			
			table29ssr.addCell(cell05632003ssr);
			table29ssr.addCell(cell05732003ssr);
			table29ssr.addCell(cell05832003ssr);
			table29ssr.addCell(cell05932003ssr);
			table29ssr.addCell(cell06032003ssr);
			table29ssr.addCell(cell06132003ssr);
			table29ssr.addCell(cell06232003ssr);
			table29ssr.addCell(cell06332003ssr);


			table29ssr.addCell(cell05632004ssr);
			table29ssr.addCell(cell05732004ssr);
			table29ssr.addCell(cell05832004ssr);
			table29ssr.addCell(cell05932004ssr);
			table29ssr.addCell(cell06032004ssr);
			table29ssr.addCell(cell06132004ssr);
			table29ssr.addCell(cell06232004ssr);
			table29ssr.addCell(cell06332004ssr);
			
			
			table29ssr.addCell(cell05632005ssr);
			table29ssr.addCell(cell05732005ssr);
			table29ssr.addCell(cell05832005ssr);
			table29ssr.addCell(cell05932005ssr);
			table29ssr.addCell(cell06032005ssr);
			table29ssr.addCell(cell06132005ssr);
			table29ssr.addCell(cell06232005ssr);
			table29ssr.addCell(cell06332005ssr);
			
			
			table29ssr.addCell(cell05632006ssr);
			table29ssr.addCell(cell05732006ssr);
			table29ssr.addCell(cell05832006ssr);
			table29ssr.addCell(cell05932006ssr);
			table29ssr.addCell(cell06032006ssr);
			table29ssr.addCell(cell06132006ssr);
			table29ssr.addCell(cell06232006ssr);
			table29ssr.addCell(cell06332006ssr);
		
		
			 PdfPCell cell0184ssr = new PdfPCell(new Paragraph("15. Qualification of the teaching staff:",font4));
			 cell0184ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
			 
			 
			 
				
			 table30ssr.addCell(cell0184ssr);
		

		//	table30ssr.addCell(table29ssr);
			 
			

	

			document.add(table30ssr);
			
			document.add(table29ssr);
			
			

			
			
			
			Paragraph paragraph131ssr = new Paragraph("16.Number of Visiting Faculty/Guest Faculty engages with the College:",font4);
			document.add(paragraph131ssr);
			Paragraph paragraph132ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedTeachingstaff().get(14).getInputats1():"" +"\r\n\r\n", font5);
			paragraph132ssr.setSpacingAfter(5f);
			
			document.add(paragraph132ssr);
			
			
		
			Paragraph paragraph1322ssr = new Paragraph("17. Furnish the number of the students admitted to the college during the last four academic years.",font4);
			paragraph1322ssr.setSpacingAfter(5f);			
			document.add(paragraph1322ssr);
			
			PdfPTable table291ssr = new PdfPTable(9);
			table291ssr.setWidthPercentage(100f);
//			PdfPTable table30ssr = new PdfPTable(1);
			
//			 float[] columnWidth5 = { 7f }; // Second column will be // twice as first and third
			 table30ssr.setWidths(columnWidth5);


	//Setting width of table, its columns and spacing
			table29ssr.setWidthPercentage(100f);
			table30ssr.setWidthPercentage(100f);

			PdfPCell cell0431ssr = new PdfPCell(new Paragraph("Categories" +"\r\n\r\n", font5));
			cell0431ssr.setRowspan(2);
			
			PdfPCell cell0442ssr = new PdfPCell(new Paragraph("year" +"\r\n\r\n", font5));
			cell0442ssr.setColspan(2);
			PdfPCell cell0453ssr = new PdfPCell(new Paragraph("year2" +"\r\n\r\n", font5));
			cell0453ssr.setColspan(2);
			PdfPCell cell0464ssr = new PdfPCell(new Paragraph("year3" +"\r\n\r\n", font5));
			cell0464ssr.setColspan(2);
			PdfPCell cell0484ssr = new PdfPCell(new Paragraph("year4" +"\r\n\r\n", font5));
			cell0484ssr.setRowspan(2);

			PdfPCell cell000132031ssr = new PdfPCell(new Paragraph("Male\r\n" +"\r\n\r\n", font5));
			PdfPCell cell00033202ssr = new PdfPCell(new Paragraph("Female\r\n" +"\r\n\r\n", font5));

			PdfPCell cell00053203ssr = new PdfPCell(new Paragraph("Male\r\n" +"\r\n\r\n", font5));
			PdfPCell cell00063204ssr = new PdfPCell(new Paragraph("Female\r\n" +"\r\n\r\n", font5));

			PdfPCell cell00083205ssr = new PdfPCell(new Paragraph("Male\r\n" +"\r\n\r\n", font5));
			PdfPCell cell00093206ssr = new PdfPCell(new Paragraph("Female\r\n" +"\r\n\r\n", font5));
			
			table291ssr.addCell(cell0431ssr);
			table291ssr.addCell(cell0442ssr);
			table291ssr.addCell(cell0453ssr);
			table291ssr.addCell(cell0464ssr);
			table291ssr.addCell(cell0484ssr);
			table291ssr.addCell(cell000132031ssr);
			table291ssr.addCell(cell00033202ssr);
			table291ssr.addCell(cell00053203ssr);
			table291ssr.addCell(cell00063204ssr);
			table291ssr.addCell(cell00083205ssr);
			table291ssr.addCell(cell00093206ssr);
			
			
			PdfPCell cell000113207ssr = new PdfPCell(new Paragraph("SC\r\n" +"\r\n\r\n", font5));

			PdfPCell cell0001132081ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat1():"" +"\r\n\r\n", font5));
			PdfPCell cell0001132082ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat2():"" +"\r\n\r\n", font5));
			PdfPCell cell0001132083ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat3():"" +"\r\n\r\n", font5));
			PdfPCell cell0001132084sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat4():"" +"\r\n\r\n", font5));
			PdfPCell cell0001132085ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat5():"" +"\r\n\r\n", font5));
			PdfPCell cell0001132086ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat6():"" +"\r\n\r\n", font5));
			PdfPCell cell0001132087ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat7():"" +"\r\n\r\n", font5));
			PdfPCell cell0001132088ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(0).getInputat8():"" +"\r\n\r\n", font5));

			
			table291ssr.addCell(cell000113207ssr);
			table291ssr.addCell(cell0001132081ssr);
			table291ssr.addCell(cell0001132082ssr);
			table291ssr.addCell(cell0001132083ssr);
			table291ssr.addCell(cell0001132084sr);
			table291ssr.addCell(cell0001132085ssr);
			table291ssr.addCell(cell0001132086ssr);
			table291ssr.addCell(cell0001132087ssr);
			table291ssr.addCell(cell0001132088ssr);
			
			
			
			PdfPCell cell0001132071ssr = new PdfPCell(new Paragraph("ST\r\n" +"\r\n\r\n", font5));

			PdfPCell cell00011320811ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat1():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320821ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat2():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320831ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat3():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320841sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat4():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320851ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat5():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320861ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat6():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320871ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat7():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320881ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(1).getInputat8():"" +"\r\n\r\n", font5));

			
			table291ssr.addCell(cell0001132071ssr);
			table291ssr.addCell(cell00011320811ssr);
			table291ssr.addCell(cell00011320821ssr);
			table291ssr.addCell(cell00011320831ssr);
			table291ssr.addCell(cell00011320841sr);
			table291ssr.addCell(cell00011320851ssr);
			table291ssr.addCell(cell00011320861ssr);
			table291ssr.addCell(cell00011320871ssr);
			table291ssr.addCell(cell00011320881ssr);
			
			
			
			
			PdfPCell cell0001132072ssr = new PdfPCell(new Paragraph("OBC\r\n" +"\r\n\r\n", font5));

			PdfPCell cell00011320812ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat1():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320822ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat2():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320832ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat3():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320842sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat4():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320852ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat5():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320862ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat6():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320872ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat7():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320882ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(2).getInputat8():"" +"\r\n\r\n", font5));

			
			
			
			
			
			table291ssr.addCell(cell0001132072ssr);
			table291ssr.addCell(cell00011320812ssr);
			table291ssr.addCell(cell00011320822ssr);
			table291ssr.addCell(cell00011320832ssr);
			table291ssr.addCell(cell00011320842sr);
			table291ssr.addCell(cell00011320852ssr);
			table291ssr.addCell(cell00011320862ssr);
			table291ssr.addCell(cell00011320872ssr);
			table291ssr.addCell(cell00011320882ssr);

			PdfPCell cell0001132073ssr = new PdfPCell(new Paragraph("General\r\n" +"\r\n\r\n", font5));

			PdfPCell cell00011320813ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat1():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320823ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat2():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320833ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat3():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320843sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat4():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320853ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat5():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320863ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat6():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320873ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat7():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320883ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(3).getInputat8():"" +"\r\n\r\n", font5));

			table291ssr.addCell(cell0001132073ssr);
			table291ssr.addCell(cell00011320813ssr);
			table291ssr.addCell(cell00011320823ssr);
			table291ssr.addCell(cell00011320833ssr);
			table291ssr.addCell(cell00011320843sr);
			table291ssr.addCell(cell00011320853ssr);
			table291ssr.addCell(cell00011320863ssr);
			table291ssr.addCell(cell00011320873ssr);
			table291ssr.addCell(cell00011320883ssr);

			
			
			
			
			
			
			
			
			PdfPCell cell0001132074ssr = new PdfPCell(new Paragraph("Other\r\n" +"\r\n\r\n", font5));

			PdfPCell cell00011320814ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat1():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320824ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat2():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320834ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat3():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320844sr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat4():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320854ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat5():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320864ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat6():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320874ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat7():"" +"\r\n\r\n", font5));
			PdfPCell cell00011320884ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAdmittstudents().get(4).getInputat8():"" +"\r\n\r\n", font5));

			
			
			
			table291ssr.addCell(cell0001132074ssr);
			table291ssr.addCell(cell00011320814ssr);
			table291ssr.addCell(cell00011320824ssr);
			table291ssr.addCell(cell00011320834ssr);
			table291ssr.addCell(cell00011320844sr);
			table291ssr.addCell(cell00011320854ssr);
			table291ssr.addCell(cell00011320864ssr);
			table291ssr.addCell(cell00011320874ssr);
			table291ssr.addCell(cell00011320884ssr);

			
			
			
			
			document.add(table291ssr);
			
			
			Paragraph paragraph133ssr = new Paragraph("18. Details on students enrollment in the college during the current academic year.",font4);
			paragraph133ssr.setAlignment(Element.ALIGN_CENTER);
			
			document.add(paragraph133ssr);
			
			
			PdfPTable table2910ssr = new PdfPTable(6);
			table2910ssr.setWidthPercentage(100f);
			table2910ssr.setWidths(new int[] { 60, 40, 40, 40, 40,40});
		table2910ssr.setSpacingAfter(20f);
		table2910ssr.setSpacingBefore(20f);

			cell.setPhrase(new Phrase("Type of Students\r\n", font4));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("UG\r\n", font4));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("PG\r\n", font4));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("M.Phil.\r\n", font4));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("Ph.D.\r\n", font4));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("Ph.D.\r\n", font4));
			table2910ssr.addCell(cell);
			

			cell.setPhrase(new Phrase("Students from the same state where the collge is located\r\n", font4));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(0).getInputet1():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(0).getInputet2():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(0).getInputet3():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(0).getInputet4():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(0).getInputet5():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(0).getInputet6():"" +"\r\n\r\n", font5));
			//table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("Students from other states of India\r\n", font4));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(1).getInputet1():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(1).getInputet2():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(1).getInputet3():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(1).getInputet4():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(1).getInputet5():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			
		//	cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(1).getInputet6():"" +"\r\n\r\n", font5));
	//		table2910ssr.addCell(cell);
			

			cell.setPhrase(new Phrase("NRI Students\r\n", font4));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(2).getInputet1():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(2).getInputet2():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(2).getInputet3():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(2).getInputet4():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(2).getInputet5():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(2).getInputet6():"" +"\r\n\r\n", font5));
//			table2910ssr.addCell(cell);
			
			cell.setPhrase(new Phrase("Foreign Students\r\n", font4));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(3).getInputet1():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(3).getInputet2():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(3).getInputet3():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(3).getInputet4():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(3).getInputet5():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(3).getInputet6():"" +"\r\n\r\n", font5));
//			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase("Total\r\n", font4));
			table2910ssr.addCell(cell);
			
			
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(4).getInputet1():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(4).getInputet2():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(4).getInputet3():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(4).getInputet4():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(4).getInputet5():"" +"\r\n\r\n", font5));
			table2910ssr.addCell(cell);
			
//			cell.setPhrase(new Phrase(ProfileRecord != null ?ProfileRecord.getAffiliatedEnrollment().get(4).getInputet6():"" +"\r\n\r\n", font5));
//			table2910ssr.addCell(cell);
			
			document.add(table2910ssr);
			
			
			Paragraph paragraph134ssr = new Paragraph("19. Please fill in the following details if applicable:", font4);
			paragraph134ssr.setAlignment(Element.ALIGN_CENTER);
			
			paragraph134ssr.setSpacingAfter(5f);
			
			document.add(paragraph134ssr);
			
			PdfPTable table29101ssr = new PdfPTable(3);
			table29101ssr.setWidthPercentage(100f);
			
			
			PdfPCell cell00011320885ssr = new PdfPCell(new Paragraph("Unit Cost of Education" +"\r\n\r\n", font5));
			table29101ssr.addCell(cell00011320885ssr);
			
			PdfPCell cell00011320886ssr = new PdfPCell(new Paragraph("Including Salary Component" +"\r\n\r\n", font5));
			table29101ssr.addCell(cell00011320886ssr);
			
			PdfPCell cell00011320887ssr = new PdfPCell(new Paragraph("Excluding Salary Component" +"\r\n\r\n", font5));
			table29101ssr.addCell(cell00011320887ssr);
			
			PdfPCell cell00011320888ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedEducation().get(0).getInputct1():"" +"\r\n\r\n", font5));
			table29101ssr.addCell(cell00011320888ssr);
			
			
			PdfPCell cell00011320889ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedEducation().get(0).getInputct2():"" +"\r\n\r\n", font5));
			table29101ssr.addCell(cell00011320889ssr);
			
			
			PdfPCell cell000113208810ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedEducation().get(0).getInputct3():"" +"\r\n\r\n", font5));
			table29101ssr.addCell(cell000113208810ssr);
			
			document.add(table29101ssr);
			
			
			
			Paragraph paragraph135ssr = new Paragraph("20. Date of accreditation * (applicable for Cycle 2, Cycle 3, Cycle 4 and re-assessment only)",font4);
			
			paragraph135ssr.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph135ssr);
			
			
			Paragraph paragraph136ssr = new Paragraph("Cycle 1:");
			document.add(paragraph136ssr);
			Paragraph paragraph137ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat1():"" +"\r\n\r\n", font5);
			document.add(paragraph137ssr);
			Paragraph paragraph138ssr = new Paragraph(" Accreditation Outcome/Result:    ");
			document.add(paragraph138ssr);
			Paragraph paragraph1311ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat2():"" +"\r\n\r\n", font5);
			document.add(paragraph1311ssr);
			

			Paragraph paragraph1361ssr = new Paragraph("Cycle 1:");
			document.add(paragraph1361ssr);
			Paragraph paragraph1371ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat3():"" +"\r\n\r\n", font5);
			document.add(paragraph1371ssr);
			Paragraph paragraph1381ssr = new Paragraph(" Accreditation Outcome/Result:    ");
			document.add(paragraph1381ssr);
			Paragraph paragraph13111ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat4():"" +"\r\n\r\n", font5);
			document.add(paragraph13111ssr);
			
			

			Paragraph paragraph13611ssr = new Paragraph("Cycle 1:");
			document.add(paragraph13611ssr);
			Paragraph paragraph13711ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat5():"" +"\r\n\r\n", font5);
			document.add(paragraph13711ssr);
			Paragraph paragraph13811ssr = new Paragraph(" Accreditation Outcome/Result:    ");
			document.add(paragraph13811ssr);
			Paragraph paragraph131111ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat6():"" +"\r\n\r\n", font5);
			document.add(paragraph131111ssr);
			
			
			

			Paragraph paragraph13612ssr = new Paragraph("Cycle 1:");
			document.add(paragraph13612ssr);
			Paragraph paragraph13712ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat7():"" +"\r\n\r\n", font5);
			document.add(paragraph13712ssr);
			Paragraph paragraph13812ssr = new Paragraph(" Accreditation Outcome/Result:    ");
			document.add(paragraph13812ssr);
			Paragraph paragraph131112ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAccrediation().get(0).getInputat8():"" +"\r\n\r\n", font5);
			document.add(paragraph131112ssr);
			
			
			Paragraph paragraph13613ssr = new Paragraph("21. Date of establishment of Internal Quality Assurance Reports (AQAR) to NAAC"+"\r\n"+"IQAC:  ",font4);
			
			
			paragraph13613ssr.setAlignment(Element.ALIGN_LEFT);
			
			
			document.add(paragraph13613ssr);
			Paragraph paragraph13614ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAnnualQuality().get(0).getInputat9():"" +"\r\n\r\n", font5);
			document.add(paragraph13614ssr);
			
			
			
			
			
			
			Paragraph paragraph13615ssr = new Paragraph("22. Details regarding submission of Annual Quality Assurance Reports to NAAC",font4);
			document.add(paragraph13615ssr);
			Paragraph paragraph136167ssr = new Paragraph("AQAR (i) "+"\t\t");
			document.add(paragraph136167ssr);
			Paragraph paragraph13616ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAnnualQuality().get(0).getInputat10():"" +"\r\n\r\n", font5);
			document.add(paragraph13616ssr);
			Paragraph paragraph1361671ssr = new Paragraph("AQAR (ii) "+"\t\t");
			document.add(paragraph1361671ssr);
			Paragraph paragraph136160ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAnnualQuality().get(0).getInputat11():"" +"\r\n\r\n", font5);
			document.add(paragraph136160ssr);
			Paragraph paragraph1361672ssr = new Paragraph("AQAR (iii) "+"\t\t");
			document.add(paragraph1361672ssr);
			Paragraph paragraph136161ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAnnualQuality().get(0).getInputat12():"" +"\r\n\r\n", font5);
			document.add(paragraph136161ssr);
			Paragraph paragraph1361673ssr = new Paragraph("AQAR (iv) "+"\t\t");
			document.add(paragraph1361673ssr);
			Paragraph paragraph136122ssr = new Paragraph(ProfileRecord != null ?ProfileRecord.getAffiliatedAnnualQuality().get(0).getInputat13():"" +"\r\n\r\n", font5);
			document.add(paragraph136122ssr);
		
			
			

		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			

			Paragraph paragraphep = new Paragraph("Extended Profile"
					
					+ ""
					+ ""
					+ "\r\n", font1);
			paragraphep.setAlignment(Paragraph.ALIGN_CENTER);

			Paragraph paragraph1ep = new Paragraph(""
					+ ""
					+ "1 Student\r\n\r\n", font2);
			paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraphep);
			document.add(paragraph1ep);
			
			Paragraph paragraph2ep = new Paragraph(
				 "1.1 Number of students year wise during the last five years\r\n\r\n", font4);
			paragraph2ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		
			document.add(paragraph2ep);
			
			
	         // year table 11
			
			if(extendedProfile.getEpYeartable11() !=null)
			{
			Table epprogramme = new Table(extendedProfile.getEpYeartable11().size(), 2);

			epprogramme.setPadding(5);
			epprogramme.setWidth(100f);

			for (int i = 0; i < extendedProfile.getEpYeartable11().size(); i++) {
				
				Cell cell1 = new Cell(new Paragraph(extendedProfile.getEpYeartable11().get(i).getInput11y(),font5));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				epprogramme.addCell(cell1);

			}
			for (int i = 0; i < extendedProfile.getEpYeartable11().size(); i++) {
				Cell cell2 = new Cell(new Paragraph(extendedProfile.getEpYeartable11().get(i).getInput11v(),font5));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				epprogramme.addCell(cell2);

			}

			document.add(epprogramme);
			}
			Paragraph paragraph4ep = new Paragraph("2  Teachers", font2);
			paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph4ep);

			Paragraph paragraph5ep = new Paragraph(
					"\r\n" + "2.1 Number of full time teachers during the last five years\r\n" + "\r\n" + (extendedProfile != null ? extendedProfile.geteTable43v() :"" ),font4  );
			paragraph5ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph5ep);
			

			PdfPTable table1ep = new PdfPTable(2);
			table1ep.setWidthPercentage(100);

		
			PdfPCell cell3ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n",font4));
		//	cell3ep.setBackgroundColor(RGBColor.blue);
			//CollectionUtils.isNotEmpty(qualin) ? qualin.get(2).getCriterionWiseWeighted() :
//------------>			PdfPCell cell4ep = new PdfPCell(new Paragraph ());
		//	cell4ep.setBackgroundColor(RGBColor.blue);
			
			
	     PdfPCell cell1ep = new PdfPCell(new Paragraph("Upload supporting document\r\n\r\n\r\n", font4));
			
//			cell1ep.setBackgroundColor(RGBColor.green);
			
//-------------------->			PdfPCell cell2ep = new PdfPCell(new Paragraph(CollectionUtils.isNotEmpty(eflIST)?eRecord != null ? epRecord.getExtendedFileupload():"", font3));
	//		cell2ep.setBackgroundColor(RGBColor.green);
			
			table1ep.addCell(cell1ep);
		//	table1ep.addCell(cell2ep);
			table1ep.addCell(cell3ep);
		//	table1ep.addCell(cell4ep);

			table1ep.setSpacingBefore(20f);
			table1ep.setSpacingAfter(20f);

			document.add(table1ep);

			//year table 21

			/*Table epstudent21 = new Table(epRecord.getEpYeartable21().size(), 2);

			epstudent21.setPadding(10);
			epstudent21.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable21().size(); i++) {
				epstudent21.addCell(epRecord.getEpYeartable21().get(i).getInput21y());

			}
			for (int i = 0; i < epRecord.getEpYeartable21().size(); i++) {
				epstudent21.addCell(epRecord.getEpYeartable21().get(i).getInput21v());

			}

			document.add(epstudent21);*/

			Paragraph paragraph6ep = new Paragraph(
					"\r\n" + "2.2 Number of full time teachetrs year wise during the last five years\r\n"
							+ "years\r\n"
							+ "\r\n" ,font4);
			
			paragraph6ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph6ep);
			
			
			//year table 22

			Table epstudent22 = new Table(extendedProfile.getEpYeartable22().size(), 2);

			epstudent22.setPadding(10);
			epstudent22.setWidth(100f);

			for (int i = 0; i < extendedProfile.getEpYeartable22().size(); i++) {
				
				

				Cell cell3 = new Cell(new Paragraph(extendedProfile.getEpYeartable22().get(i).getInput22y(),font5));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent22.addCell(cell3);

			}
			for (int i = 0; i < extendedProfile.getEpYeartable22().size(); i++) {
				
				Cell cell4 = new Cell(new Paragraph(extendedProfile.getEpYeartable22().get(i).getInput22v(),font5));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent22.addCell(cell4);

			}

			document.add(epstudent22);
			
			
			
			
			

//			Paragraph paragraph7ep = new Paragraph("2.3\r\n"
//					+ "Number of outgoing / final year students year-wise during last five years\r\n"
//					+ "\r\n"
//					+ "", font3);
//			paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph7ep);

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

			/*Table epstudent23 = new Table(epRecord.getEpYeartable23().size(), 2);

			epstudent23.setPadding(10);
			epstudent23.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable23().size(); i++) {
				epstudent23.addCell(epRecord.getEpYeartable23().get(i).getInput23y());

			}
			for (int i = 0; i < epRecord.getEpYeartable23().size(); i++) {
				epstudent23.addCell(epRecord.getEpYeartable23().get(i).getInput23y());

			}

			document.add(epstudent23);*/

			/*Paragraph paragraph8ep = new Paragraph(
					"2.4\r\n" + "\r\n" + "Number of revaluation applications year-wise during last five years\r\n" + "",
					font3);
			paragraph8ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph8ep);

			PdfPTable table5ep = new PdfPTable(2);
			table5ep.setWidthPercentage(100);

			PdfPCell cell17ep = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n\r\n", font3));
			PdfPCell cell18ep = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
			PdfPCell cell19ep = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
			PdfPCell cell20ep = new PdfPCell(new Paragraph(" "));

			table5ep.addCell(cell17ep);
			table5ep.addCell(cell18ep);
			table5ep.addCell(cell19ep);
			table5ep.addCell(cell20ep);

			table5ep.setSpacingBefore(20f);
			table5ep.setSpacingAfter(20f);

			document.add(table5ep);

			Table epstudent24 = new Table(epRecord.getEpYeartable24().size(), 2);

			epstudent24.setPadding(10);
			epstudent24.setWidth(100f);

			for (int i = 0; i < epRecord.getEpYeartable24().size(); i++) {
				epstudent24.addCell(epRecord.getEpYeartable24().get(i).getInput24y());

			}
			for (int i = 0; i < epRecord.getEpYeartable24().size(); i++) {
				epstudent24.addCell(epRecord.getEpYeartable24().get(i).getInput24y());

			}

			document.add(epstudent24);*/

			Paragraph paragraph9ep = new Paragraph("3 Expenditure \r\n", font2);
			paragraph9ep.setAlignment(Paragraph.ALIGN_CENTER);

			document.add(paragraph9ep);

			Paragraph paragraph10ep = new Paragraph(
					"\r\n" + "3.1 Expendicture excluding salary component year wise during the last five years\r\n" + "\r\n" + "",
					font4);
			paragraph10ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph10ep);


			
			//year table 31
			if(extendedProfile.getEpYeartable31()!=null)
			{

			Table epstudent31 = new Table(extendedProfile.getEpYeartable31().size(), 2);

			epstudent31.setPadding(10);
			epstudent31.setWidth(100f);

			for (int i = 0; i < extendedProfile.getEpYeartable31().size(); i++) {
				
				Cell cell5 = new Cell(new Paragraph(extendedProfile.getEpYeartable31().get(i).getInput31y(),font5));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent31.addCell(cell5);

			}
			for (int i = 0; i < extendedProfile.getEpYeartable31().size(); i++) {
				
				
				Cell cell6 = new Cell(new Paragraph(extendedProfile.getEpYeartable31().get(i).getInput31v(),font5));
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				epstudent31.addCell(cell6);

			}

			document.add(epstudent31);

			}
			
			
				
		}
		
		public void EvalutionReport(Document document ,EvaluativereportMain evaluativereportRecord) {
		

			Paragraph paragraph1 = new Paragraph("\r\n  EvaluationReport \r\n", font1);
			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            document.add(paragraph1);
            
            Paragraph paragraph2 = new Paragraph("\r\n  Evaluative Report of the Departments \r\n", font2);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            document.add(paragraph2);
            
            
            Paragraph paragraph3 = new Paragraph("\r\n \r\n Name Of the Autonomous College", font4);
            paragraph3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph3);
           Paragraph paragraph4 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getNameofTheAutonomousCollege():"",font5);
    		paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph4);
    		
    		
    		
            Paragraph paragraph31 = new Paragraph("\r\nName of the Department", font4);
            paragraph31.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph31);
    		
             Paragraph paragraph5 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getNameofTheDepartment():"",font5);
    	     paragraph5.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		 document.add(paragraph5);
    		
    		
    		  Paragraph paragraph51 = new Paragraph("\r\nDist", font4);
    		  paragraph51.setAlignment(Paragraph.ALIGN_JUSTIFIED);
      		  document.add(paragraph51);
      		
    		 Paragraph paragraph6 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getDist():"",font5);
     		 paragraph6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	    		document.add(paragraph6);
    	    		
    	    		
    	    Paragraph paragraph61 = new Paragraph("\r\nState", font4);
    	    paragraph61.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	    document.add(paragraph61);		
    	   Paragraph paragraph7 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getState():"",font5);
    	   paragraph7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	   document.add(paragraph7);
    	    	    
    	   
    	   Paragraph paragraph71 = new Paragraph("\r\nTotal Number of Departments in the institution", font4);
    	   paragraph71.setAlignment(Paragraph.ALIGN_JUSTIFIED);
   	       document.add(paragraph71);	
    	   Paragraph paragraph8 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getTotalNumberofDepartmentsIntheInstitution():"",font5);
    	   paragraph8.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	   document.add(paragraph8);
    	   
    	   
    	   
    	   PdfPTable table1 = new PdfPTable(5);
    	   table1.setWidthPercentage(100);
    	   
    	   table1.setSpacingBefore(20F);
			PdfPCell cell1 = new PdfPCell(new Paragraph("\r\nS No\r\n", font4));
		
			PdfPCell cell2 = new PdfPCell(new Paragraph("\r\nName of the Department.",font4));
			PdfPCell cell3 = new PdfPCell(new Paragraph("\r\nFor Ex: English\r\n",font4));
			PdfPCell cell4 = new PdfPCell(new Paragraph("\r\nZooology",font4));
			PdfPCell cell5 = new PdfPCell(new Paragraph("\r\nBio-Technology\r\n",font4));
			
			PdfPCell cell6 = new PdfPCell(new Paragraph("\r\n1\r\n",font4));
			PdfPCell cell7 = new PdfPCell(new Paragraph("\r\nYear of Establishment",font4));
			PdfPCell cell8 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getEnglish():"",font5));
			
			PdfPCell cell9 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getZoology():"",font5));
			PdfPCell cell10 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getBioTechnology():"",font5));
			
			PdfPCell cell11 = new PdfPCell(new Paragraph("\r\n2\r\n",font4));
			PdfPCell cell12 = new PdfPCell(new Paragraph("\r\nIs the Department part of a School/Faculty of the Autonomous College",font4));
			PdfPCell cell13 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getEnglish():"" ,font5));
			PdfPCell cell14 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getZoology():"",font5));
			PdfPCell cell15 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getBioTechnology():"",font5));
			
			
			PdfPCell cell16 = new PdfPCell(new Paragraph("\r\n3\r\n",font4));
			PdfPCell cell17 = new PdfPCell(new Paragraph("\r\nName of programmes offered",font4));
			PdfPCell cell18= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getEnglish():"",font5));
			PdfPCell cell19= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getZoology():"",font5));
			PdfPCell cell20= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getBioTechnology():"",font5));
			
			PdfPCell cell21= new PdfPCell(new Paragraph("\r\n4\r\n",font4));
			PdfPCell cell22= new PdfPCell(new Paragraph("\r\nNumber of teaching posts Sanctioned/Filled",font4));
			PdfPCell cell23 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getEnglish():"",font5));
			PdfPCell cell24= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getZoology():"",font5));
			PdfPCell cell25= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getBioTechnology():"",font5));
			
			PdfPCell cell26 = new PdfPCell(new Paragraph("\r\n5\r\n",font4));
		    PdfPCell cell27 = new PdfPCell(new Paragraph("\r\nNumber of Research Projects:Total grants received",font4));
			PdfPCell cell28= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getEnglish():"",font5));
			PdfPCell cell29= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getZoology():"",font5));
			PdfPCell cell30= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getBioTechnology():"",font5));
			
			PdfPCell cell31 = new PdfPCell(new Paragraph("\r\n6\r\n",font4));
			
			cell31.setRowspan(3);
			
			PdfPCell cell32 = new PdfPCell(new Paragraph("\r\nInter -institutional collaborative projects and Associated grants received"));
			PdfPCell cell33 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getEnglish():"",font5));
			PdfPCell cell34 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getZoology():"",font5));
			PdfPCell cell35 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getBioTechnology():"",font5));
			
			PdfPCell cell36 = new PdfPCell(new Paragraph("\r\nNational collaboration",font4));
			
			PdfPCell cell37 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getEnglish():"",font5));
			PdfPCell cell38 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getZoology():"",font5));
			PdfPCell cell39 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getBioTechnology():"",font5));
			
			PdfPCell cell40 = new PdfPCell(new Paragraph("\r\nInternational collaboration",font4));
			PdfPCell cell41= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getEnglish():"",font5));
			PdfPCell cell42 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getZoology():"",font5));
			PdfPCell cell43 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getBioTechnology():"",font5));
			
			PdfPCell cell44 = new PdfPCell(new Paragraph("\r\n7\r\n",font4));
			PdfPCell cell45 = new PdfPCell(new Paragraph("\r\nDepartmental projects funded by DST_FIST,UGC-SAP?CAS,DPE,DBT,ICSSR,AICTE etc.,:Total grants received",font4));
			PdfPCell cell46 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getEnglish():"",font5));
			PdfPCell cell47 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getZoology():"",font5));
			PdfPCell cell48= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getBioTechnology():"",font5));
			
			PdfPCell cell49= new PdfPCell(new Paragraph("\r\n8\r\n",font4));
			PdfPCell cell50= new PdfPCell(new Paragraph("\r\nNumber of Research Projects:Total grants received",font4));
			PdfPCell cell51= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getEnglish():"",font5));
			PdfPCell cell52= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getEnglish():"",font5));
			PdfPCell cell53= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getBioTechnology():"",font5));
			
			PdfPCell cell54= new PdfPCell(new Paragraph("\r\n9\r\n",font4));
			cell54.setRowspan(6);
			
			PdfPCell cell55= new PdfPCell(new Paragraph("\r\nPublications:",font4));
			PdfPCell cell56= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getEnglish():"",font5));
			PdfPCell cell57= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getZoology():"",font5));
			PdfPCell cell58= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getBioTechnology():"",font5));
			
			PdfPCell cell59= new PdfPCell(new Paragraph("\r\nNumber of Papers published",font4));
			PdfPCell cell60= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getEnglish():"",font5));
			PdfPCell cell61= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getZoology():"",font5));
			PdfPCell cell62= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getBioTechnology():"",font5));
			
			PdfPCell cell63= new PdfPCell(new Paragraph("\r\nNumber of Books with ISBN",font4));
			PdfPCell cell64= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getEnglish():"",font5));
			PdfPCell cell65= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getZoology():"",font5));
			PdfPCell cell66= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getBioTechnology():"",font5));
			
			PdfPCell cell67= new PdfPCell(new Paragraph("\r\nNumber of Citation Index -range/average",font4));
			PdfPCell cell68= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getEnglish():"",font5));
			PdfPCell cell69= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getZoology():"",font5));
			PdfPCell cell70= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getBioTechnology():"",font5));
			
			
			PdfPCell cell71= new PdfPCell(new Paragraph("\r\nNumber of Citation Factor-range/average",font4));
			PdfPCell cell72= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getEnglish():"",font5));
			PdfPCell cell73= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getZoology():"",font5));
			PdfPCell cell74= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getBioTechnology():"",font5));
			
			
			PdfPCell cell75= new PdfPCell(new Paragraph("\r\nNumber of h-index",font4));
			PdfPCell cell76= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getEnglish():"",font5));
			PdfPCell cell77= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getZoology():"",font5));
			PdfPCell cell78= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getBioTechnology():"",font5));
			
			
			PdfPCell cell79= new PdfPCell(new Paragraph("\r\n10\r\n",font4));
			PdfPCell cell80= new PdfPCell(new Paragraph("\r\nDetails of parents and income generated",font4));
			PdfPCell cell81= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getEnglish():"",font5));
			PdfPCell cell82= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getZoology():"",font5));
			PdfPCell cell83= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getBioTechnology():"",font5));
			
			PdfPCell cell84= new PdfPCell(new Paragraph("\r\n11\r\n",font4));
			PdfPCell cell85= new PdfPCell(new Paragraph("\r\nDetails of parents and income generated",font4));
			PdfPCell cell86= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getEnglish():"",font5));
			PdfPCell cell87= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getZoology():"",font5));
			PdfPCell cell88= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getBioTechnology():"",font5));
			
			PdfPCell cell89= new PdfPCell(new Paragraph("\r\n12\r\n",font4));
			cell89.setRowspan(4);
			PdfPCell cell90= new PdfPCell(new Paragraph("\r\nAwards/Recognitions received at National and International level by:"));
			PdfPCell cell91= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getEnglish():"",font5));
			PdfPCell cell92= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getZoology():"",font5));
			PdfPCell cell93= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getBioTechnology():"",font5));
			
			PdfPCell cell94= new PdfPCell(new Paragraph("\r\nFaculty",font4));
			PdfPCell cell95= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getEnglish():"",font5));
			PdfPCell cell96= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getZoology():"",font5));
			PdfPCell cell97= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getBioTechnology():"",font5));
			
			PdfPCell cell98= new PdfPCell(new Paragraph("\r\nDoctoral/Post doctoral fellows",font4));
			PdfPCell cell99= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getEnglish():"",font5));
			PdfPCell cell100= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getZoology():"",font5));
			PdfPCell cell101= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getBioTechnology():"",font5));
			
			
			PdfPCell cell102= new PdfPCell(new Paragraph("\r\nStudents",font4));
			PdfPCell cell103= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getEnglish():"",font5));
			PdfPCell cell104= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getZoology():"",font5));
			PdfPCell cell105= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getBioTechnology():"",font5));
			
			
			PdfPCell cell106= new PdfPCell(new Paragraph("\r\n13\r\n",font4));
			PdfPCell cell107= new PdfPCell(new Paragraph("\r\nHow many students have cleared Civil Services and Defense Services examinations, NET,SET (SLET), GATE and other competitive examinations",font4));
			PdfPCell cell108= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getEnglish():"",font5));
			PdfPCell cell109= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getZoology():"",font5));
			PdfPCell cell110= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getBioTechnology():"",font5));
			
			
			PdfPCell cell111= new PdfPCell(new Paragraph("\r\n14\r\n",font4));
			cell111.setRowspan(3);
			PdfPCell cell112= new PdfPCell(new Paragraph("\r\nList of dotoral students and research assoiates",font4));
			PdfPCell cell113= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getEnglish():"",font5));
			PdfPCell cell114= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getZoology():"",font5));
			PdfPCell cell115= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getBioTechnology():"",font5));
			
			
			PdfPCell cell116= new PdfPCell(new Paragraph("\r\nFro the host institution/uniersity",font4));
			PdfPCell cell117= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getEnglish():"",font5));
			PdfPCell cell118= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getZoology():"",font5));
			PdfPCell cell119= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getBioTechnology():"",font5));
			
			PdfPCell cell120= new PdfPCell(new Paragraph("\r\nYear of Establishment",font4));
			PdfPCell cell121= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getEnglish():""
			,font5));
			PdfPCell cell122= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getZoology():"",font5));
			PdfPCell cell123= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getBioTechnology():"",font5));
			
			PdfPCell cell124= new PdfPCell(new Paragraph("\r\n15\r\n",font4));
			PdfPCell cell125= new PdfPCell(new Paragraph("\r\nNumber of Research Scholars/ Post Graduate students getting financial assistance from the University/State/Central",font4));
			PdfPCell cell126= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getEnglish():"",font5));
			PdfPCell cell127= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getZoology():"",font5));
			PdfPCell cell128= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getBioTechnology():"",font5));
			
			
			cell1.setExtraParagraphSpace(10F);  cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			
		
			table1.addCell(cell1);
		
			
			cell2.setExtraParagraphSpace(10F); 
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell2);
	
			
			cell3.setExtraParagraphSpace(10F);  cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell3);
			cell4.setExtraParagraphSpace(10F);  cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell4);
			
			cell5.setExtraParagraphSpace(10F);  cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell5);
			
			cell6.setExtraParagraphSpace(10F);  cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell6);
			
			cell7.setExtraParagraphSpace(10F);  cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell7);
			
			
			cell8.setExtraParagraphSpace(10F);  cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell8);
			
			
			cell9.setExtraParagraphSpace(10F);  cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell9);
			
			cell10.setExtraParagraphSpace(10F);  cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell10);
			
			cell11.setExtraParagraphSpace(10F);  cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell11);
			
			
			cell12.setExtraParagraphSpace(10F);  cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell12);
			
			
			cell13.setExtraParagraphSpace(10F);  cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell13);
			
			
			cell14.setExtraParagraphSpace(10F);  cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell14);
			
			
			cell15.setExtraParagraphSpace(10F);  cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell15);
			
			cell16.setExtraParagraphSpace(10F);  cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell16);
			
			cell17.setExtraParagraphSpace(10F);  cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell17);
			
			cell18.setExtraParagraphSpace(10F);  cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell18);
			
			cell19.setExtraParagraphSpace(10F);  cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell19);
			
			cell20.setExtraParagraphSpace(10F);  cell20.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell20);
			
			
			cell21.setExtraParagraphSpace(10F);  cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell21);
			
			cell22.setExtraParagraphSpace(10F);  cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell22);
			
			cell23.setExtraParagraphSpace(10F);  cell23.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell23);
			
			cell24.setExtraParagraphSpace(10F);  cell24.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell24);
			
			cell25.setExtraParagraphSpace(10F);  cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell25);
			
			cell26.setExtraParagraphSpace(10F);  cell26.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell26);
			
			cell27.setExtraParagraphSpace(10F);  cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell27);
			
			cell28.setExtraParagraphSpace(10F);  cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell28);
			
			
			cell29.setExtraParagraphSpace(10F);  cell29.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell29);
			
			cell30.setExtraParagraphSpace(10F);  cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell30);
			
			
			cell31.setExtraParagraphSpace(10F);  cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell31);
			
			
			cell32.setExtraParagraphSpace(10F);  cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell32);
			
			cell33.setExtraParagraphSpace(10F);  cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell33);
			
			cell34.setExtraParagraphSpace(10F);  cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell34);
			
			cell35.setExtraParagraphSpace(10F);  cell35.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell35);
			
			cell36.setExtraParagraphSpace(10F);  cell36.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell36);
			
			
			cell37.setExtraParagraphSpace(10F);  cell37.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell37);
			
			cell38.setExtraParagraphSpace(10F);  cell38.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell38);
			
			
			cell39.setExtraParagraphSpace(10F);  cell39.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell39);
			
			cell40.setExtraParagraphSpace(10F);  cell40.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell40);
			
			
			cell41.setExtraParagraphSpace(10F);  cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell41);
			
			
			cell42.setExtraParagraphSpace(10F);  cell42.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell42);
			
			cell43.setExtraParagraphSpace(10F);  cell43.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell43);
			
			cell44.setExtraParagraphSpace(10F);  cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell44);
			
			cell45.setExtraParagraphSpace(10F);  cell45.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell45);
			
			cell46.setExtraParagraphSpace(10F);  cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell46);
			
			cell47.setExtraParagraphSpace(10F);  cell47.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell47);
			
			
			cell48.setExtraParagraphSpace(10F);  cell48.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell48);
			
			cell49.setExtraParagraphSpace(10F);  cell49.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell49);
			
			cell50.setExtraParagraphSpace(10F);  cell50.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell50);
			
			cell51.setExtraParagraphSpace(10F);  cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell51);
			
			cell52.setExtraParagraphSpace(10F);  cell52.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell52);
			
			cell53.setExtraParagraphSpace(10F);  cell53.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell53);
			
			cell54.setExtraParagraphSpace(10F);  cell54.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table1.addCell(cell54);
		    
		    cell55.setExtraParagraphSpace(10F);  cell55.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell55);
			
			cell56.setExtraParagraphSpace(10F);  cell56.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell56);
			
			cell57.setExtraParagraphSpace(10F);  cell57.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell57);
			
			cell58.setExtraParagraphSpace(10F);  cell58.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell58);
			
			cell59.setExtraParagraphSpace(10F);  cell59.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell59);
			
			cell60.setExtraParagraphSpace(10F);  cell60.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell60);
			
			cell61.setExtraParagraphSpace(10F);  cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell61);
			
			cell62.setExtraParagraphSpace(10F);  cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell62);
			
			cell63.setExtraParagraphSpace(10F);  cell63.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell63);
			
			cell64.setExtraParagraphSpace(10F);  cell64.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell64);
			
			
			cell65.setExtraParagraphSpace(10F);  cell65.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell65);
			
			cell66.setExtraParagraphSpace(10F);  cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell66);
			
			
			cell67.setExtraParagraphSpace(10F);  cell67.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell67);
			
			cell68.setExtraParagraphSpace(10F);  cell68.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell68);
			
			cell69.setExtraParagraphSpace(10F);  cell69.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell69);
			
			cell70.setExtraParagraphSpace(10F);  cell70.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell70);
			
			
			cell71.setExtraParagraphSpace(10F);  cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell71);
			
			cell72.setExtraParagraphSpace(10F);  cell72.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell72);
			
			cell73.setExtraParagraphSpace(10F);  cell73.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell73);
			
			cell74.setExtraParagraphSpace(10F); cell74.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell74);
			
			cell75.setExtraParagraphSpace(10F);  cell75.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell75);
			
			cell76.setExtraParagraphSpace(10F);  cell76.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell76);
			
			cell77.setExtraParagraphSpace(10F);  cell77.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell77);
			
			cell78.setExtraParagraphSpace(10F);  cell78.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell78);
			
			cell79.setExtraParagraphSpace(10F);  cell79.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell79);
			
			cell80.setExtraParagraphSpace(10F);  cell80.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell80);
		
			cell81.setExtraParagraphSpace(10F);  cell81.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell81);
			
			cell82.setExtraParagraphSpace(10F);  cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell82);
			
			cell83.setExtraParagraphSpace(10F);  cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell83);
			
			cell84.setExtraParagraphSpace(10F);  cell84.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell84);
			
			cell85.setExtraParagraphSpace(10F);  cell85.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell85);
			
			cell86.setExtraParagraphSpace(10F);  cell86.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell86);
			
			cell87.setExtraParagraphSpace(10F);  cell87.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell87);
			
			cell88.setExtraParagraphSpace(10F);  cell88.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell88);
			
			cell89.setExtraParagraphSpace(10F);  cell89.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell89);
			
			cell90.setExtraParagraphSpace(10F);  cell90.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell90);
			
			
			cell91.setExtraParagraphSpace(10F);  cell91.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell91);
			
			cell92.setExtraParagraphSpace(10F);  cell92.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell92);
			
			cell93.setExtraParagraphSpace(10F);  cell93.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell93);
			
			cell94.setExtraParagraphSpace(10F);  cell94.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell94);
			
			cell95.setExtraParagraphSpace(10F);  cell95.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell95);
			
			cell96.setExtraParagraphSpace(10F); cell96.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell96);
			
			
			cell97.setExtraParagraphSpace(10F);  cell97.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell97);
			
			cell98.setExtraParagraphSpace(10F);  cell98.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell98);
			
			cell99.setExtraParagraphSpace(10F);  cell99.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell99);
			
			cell100.setExtraParagraphSpace(10F);  cell100.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell100);
			
			
			cell101.setExtraParagraphSpace(10F);  cell101.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell101);
			
			cell102.setExtraParagraphSpace(10F);  cell102.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell102);
			
			cell103.setExtraParagraphSpace(10F);  cell103.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell103);
			
			cell104.setExtraParagraphSpace(10F);  cell104.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell104);
			
			cell105.setExtraParagraphSpace(10F);  cell105.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell105);
			
			cell106.setExtraParagraphSpace(10F);  cell106.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell106);
			cell107.setExtraParagraphSpace(10F);  cell107.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell107);
			
			cell108.setExtraParagraphSpace(10F);  cell108.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell108);
			
			cell109.setExtraParagraphSpace(10F);  cell109.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell109);
			
			cell110.setExtraParagraphSpace(10F);  cell110.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell110);
			
			
			cell111.setExtraParagraphSpace(10F);  cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell111);
			
			cell112.setExtraParagraphSpace(10F);  cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell112);
			
			cell113.setExtraParagraphSpace(10F);  cell113.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell113);
			
			cell114.setExtraParagraphSpace(10F);  cell114.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell114);
			
			cell115.setExtraParagraphSpace(10F);  cell115.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell115);
			
			cell116.setExtraParagraphSpace(10F);  cell116.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell116);
			
			cell117.setExtraParagraphSpace(10F);  cell117.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell117);
			
			cell118.setExtraParagraphSpace(10F);  cell118.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell118);
			
			cell119.setExtraParagraphSpace(10F);  cell119.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell119);
			
			cell120.setExtraParagraphSpace(10F);  cell120.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell120);
			
			
			cell121.setExtraParagraphSpace(10F);  cell121.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell121);
			
			cell122.setExtraParagraphSpace(10F);  cell122.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell122);
			
			cell123.setExtraParagraphSpace(10F);  cell123.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell123);
			
			cell124.setExtraParagraphSpace(10F);  cell124.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell124);
			
			cell125.setExtraParagraphSpace(10F);  cell125.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell125);
			
			cell126.setExtraParagraphSpace(10F);  cell126.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell126);
			
			cell127.setExtraParagraphSpace(10F);  cell127.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell127);
			
			cell128.setExtraParagraphSpace(10F);  cell128.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell128);
			
			document.add(table1);
			
			
		}
		public  void Iiqa(Document document,QIAIndicatorMain qiaData) {	Font fontTitle=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fontTitle.setSize(16);
		//fontTitle.setColor(Color.RED);


   Paragraph paragraph=new Paragraph("Institutional Information for Quality Assessment(IIQA)"
				,fontTitle);
		   paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		   PdfPCell cell1= new PdfPCell();
		
		   document.add(cell1);
		   paragraph.setSpacingAfter(10f);
   document.add(paragraph);
		
	Font fontParagraph4=FontFactory.getFont(FontFactory.COURIER_BOLD);
	fontParagraph4.setSize(12);
         Paragraph paragraph5=new Paragraph(qIAIndicator1.get(0).getInputiiqa1t2()
				,fontParagraph4);
		paragraph5.setAlignment(Paragraph.ALIGN_LEFT);
		
		paragraph.setSpacingAfter(10f);
		document.add(paragraph5);
		
  

		Font font=FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setSize(11);
		//fontTitle1.setColor(Color.RED);
		  
//creating table 4 cloums date of submission	
		
	PdfPTable table = new PdfPTable(4);
	table.setWidthPercentage(70);
	table.setWidths(new int[]{60,60,30,60});
	table.setHorizontalAlignment(table.ALIGN_LEFT );
	
	
	PdfPCell cell3 = new PdfPCell(new Paragraph("",font)); cell3.setExtraParagraphSpace(10f);
	PdfPCell cell4 = new PdfPCell(new Paragraph("Date of submission",font)); cell4.setExtraParagraphSpace(10f);
	cell4.setExtraParagraphSpace(10f);
	PdfPCell cell5 = new PdfPCell(new Paragraph(":",font)); cell5.setExtraParagraphSpace(10f);
	cell5.setExtraParagraphSpace(10f);
	PdfPCell cell6 = new PdfPCell(new Paragraph(qiadata.getInputIiqaDate(),font)); cell6.setExtraParagraphSpace(10f);   
	cell6.setExtraParagraphSpace(10f);
	cell6	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell7 = new PdfPCell(new Paragraph("",font)); cell7.setExtraParagraphSpace(10f);
	
	
	PdfPCell cell8 = new PdfPCell(new Paragraph("AISHE ID",font)); cell8.setExtraParagraphSpace(10f);
	cell8.setExtraParagraphSpace(10f);
	PdfPCell cell9 = new PdfPCell(new Paragraph(":",font)); cell4.setExtraParagraphSpace(10f);
	PdfPCell cell10 = new PdfPCell(new Paragraph(qiadata.getInputIiqaAisheId(),font)); cell9.setExtraParagraphSpace(10f);    
	cell10.setExtraParagraphSpace(10f);
	cell10	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell14 = new PdfPCell(new Paragraph("",font)); cell14.setExtraParagraphSpace(10f);
	PdfPCell cell11 = new PdfPCell(new Paragraph("Institution Track ID",font)); cell11.setExtraParagraphSpace(10f);
	cell11.setExtraParagraphSpace(10f);
	
	PdfPCell cell12 = new PdfPCell(new Paragraph(":",font)); cell12.setExtraParagraphSpace(10f);
	PdfPCell cell13 = new PdfPCell(new Paragraph(qiadata.getInputIiqaTrackId(),font)); cell13.setExtraParagraphSpace(10f);     
	cell13.setExtraParagraphSpace(10f);
	cell13	.setHorizontalAlignment(Element.ALIGN_CENTER);
  
	
	
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
	
// application  table
	
	PdfPTable table1 = new PdfPTable(3);
	table1.setWidthPercentage(100);
	table1.setWidths(new int[]{10,90,90});
	table1.setHorizontalAlignment(table.ALIGN_LEFT );
//\r\n\r\n

	PdfPCell cell15 = new PdfPCell(new Paragraph("   1",font)); cell15.setExtraParagraphSpace(10f); //nested column
	cell15.setRowspan(2);
	PdfPCell cell16 = new PdfPCell(new Paragraph("Application For",font)); cell16.setExtraParagraphSpace(10f);
	
	PdfPCell cell17 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa1t1(),font)); cell17.setExtraParagraphSpace(10f);   
	cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell18 = new PdfPCell(new Paragraph("Cycle of Accreditation ",font)); cell18.setExtraParagraphSpace(10f); //nested
	
	PdfPCell cell19 = new PdfPCell(new Paragraph("",font)); cell4.setExtraParagraphSpace(10f);
	
//creating another table 
//table 1
	
	



		
		
	PdfPTable table4141 = new PdfPTable(4);
	PdfPCell cell201 = new PdfPCell(new Paragraph("Cycle",font)); cell201.setExtraParagraphSpace(10f);
	PdfPCell cell202 = new PdfPCell(new Paragraph("Date",font)); cell202.setExtraParagraphSpace(10f);
	PdfPCell cell203 = new PdfPCell(new Paragraph("Grade",font)); cell203.setExtraParagraphSpace(10f);
	PdfPCell cell204 = new PdfPCell(new Paragraph("Score",font)); cell204.setExtraParagraphSpace(10f);
	table4141.addCell(cell201);
	table4141.addCell(cell202);
	table4141.addCell(cell203);
	table4141.addCell(cell204);
	
	
	for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
		{
		
	PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator12().get(i).getInputiiqa1t3()),font)); cell000001.setExtraParagraphSpace(10f);
	cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
	table4141.addCell(cell000001);
	
	PdfPCell cell0000011=new PdfPCell(new Paragraph((qiadata.getQiaIndicator12().get(i).getInputiiqa1t4()),font)); cell0000011.setExtraParagraphSpace(10f);
	cell0000011.setHorizontalAlignment(Element.ALIGN_CENTER);
	table4141.addCell(cell0000011);
	
	PdfPCell cell000001111=new PdfPCell(new Paragraph((qiadata.getQiaIndicator12().get(i).getInputiiqa1t5()),font)); cell000001111.setExtraParagraphSpace(10f);
	cell000001111.setHorizontalAlignment(Element.ALIGN_CENTER);
	table4141.addCell(cell000001111);
	
	PdfPCell cell0000016111=new PdfPCell(new Paragraph((qiadata.getQiaIndicator12().get(i).getInputiiqa1t6()),font)); cell0000016111.setExtraParagraphSpace(10f);
	cell0000016111.setHorizontalAlignment(Element.ALIGN_CENTER);
	table4141.addCell(cell0000016111);
		}
	
		
//		for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//		{
//		
//		
//	}
//		for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//		{
//		
//		
//		}
//		for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//		{
//		
//		
//		}
//	
	 table4141.setSpacingBefore(20f);
	 table4141.setSpacingAfter(20f);
//		PdfPCell cell19 = new PdfPCell();
	 cell19.addElement(table4141);

		//cell19.addElement(cell19);
	
	PdfPCell cell20 = new PdfPCell(new Paragraph("   2",font)); cell20.setExtraParagraphSpace(10f);
	PdfPCell cell21 = new PdfPCell(new Paragraph("Name of the College ",font)); cell21.setExtraParagraphSpace(10f);
	PdfPCell cell22 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa1t2(),font)); cell22.setExtraParagraphSpace(10f);    
	cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	PdfPCell cell23 = new PdfPCell(new Paragraph("   3",font)); cell23.setExtraParagraphSpace(10f);
	PdfPCell cell24 = new PdfPCell(new Paragraph("Date of establishment of the Institution",font)); cell24.setExtraParagraphSpace(10f);
	PdfPCell cell25 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa3t1(),font)); cell25.setExtraParagraphSpace(10f);     
	cell25	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell26 = new PdfPCell(new Paragraph("   4",font)); cell26.setExtraParagraphSpace(10f);
	cell26.setRowspan(2);//nested column
	PdfPCell cell27 = new PdfPCell(new Paragraph("Name of the Head of the Institution",font)); cell27.setExtraParagraphSpace(10f);
	PdfPCell cell28 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa4t1(),font)); cell28.setExtraParagraphSpace(10f);     
	cell28	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell29 = new PdfPCell(new Paragraph("Designation",font)); cell29.setExtraParagraphSpace(10f);
	PdfPCell cell30 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa4t2(),font)); cell30.setExtraParagraphSpace(10f);     
	cell30	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell31 = new PdfPCell(new Paragraph("   5",font)); cell31.setExtraParagraphSpace(10f);
	PdfPCell cell32 = new PdfPCell(new Paragraph("Does the college function from Own Campus ",font)); cell32.setExtraParagraphSpace(10f);
	PdfPCell cell33 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa5t1(),font)); cell33.setExtraParagraphSpace(10f);       
	cell33	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell34 = new PdfPCell(new Paragraph("   6",font)); cell34.setExtraParagraphSpace(10f);
	cell34.setRowspan(10);
	PdfPCell cell35 = new PdfPCell(new Paragraph("Address of the College",font)); cell35.setExtraParagraphSpace(10f);
	PdfPCell cell36 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa5t1(),font)); cell36.setExtraParagraphSpace(10f);   
	cell36.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell37 = new PdfPCell(new Paragraph("State/UT",font)); cell37.setExtraParagraphSpace(10f);
	PdfPCell cell38 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t2(),font)); cell38.setExtraParagraphSpace(10f);      
	cell38	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell39 = new PdfPCell(new Paragraph("District",font)); cell39.setExtraParagraphSpace(10f);
	PdfPCell cell40 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t3(),font)); cell40.setExtraParagraphSpace(10f);   
	cell40	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell41 = new PdfPCell(new Paragraph("City",font)); cell41.setExtraParagraphSpace(10f);
	PdfPCell cell42 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t4(),font)); cell42.setExtraParagraphSpace(10f);       
	cell42	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell43 = new PdfPCell(new Paragraph("Pin",font)); cell43.setExtraParagraphSpace(10f);
	PdfPCell cell44 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t5(),font)); cell44.setExtraParagraphSpace(10f);  
	cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell45 = new PdfPCell(new Paragraph("Phone No",font)); cell4.setExtraParagraphSpace(10f);
	PdfPCell cell46 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t6(),font)); cell46.setExtraParagraphSpace(10f);      
	cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell47 = new PdfPCell(new Paragraph("Fax No",font)); cell47.setExtraParagraphSpace(10f);
	PdfPCell cell48 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t7(),font)); cell48.setExtraParagraphSpace(10f); 
	cell48	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell49 = new PdfPCell(new Paragraph("Mobile No ",font)); cell49.setExtraParagraphSpace(10f);
	PdfPCell cell50 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t8(),font)); cell50.setExtraParagraphSpace(10f); 
	cell50.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell51 = new PdfPCell(new Paragraph("Registered Email",font)); cell51.setExtraParagraphSpace(10f);
	PdfPCell cell52 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t9(),font)); cell52.setExtraParagraphSpace(10f);       
	cell52.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell53 = new PdfPCell(new Paragraph("Alternate Email ",font)); cell53.setExtraParagraphSpace(10f);
	PdfPCell cell54 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t10(),font)); cell54.setExtraParagraphSpace(10f);    
	cell54.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell55 = new PdfPCell(new Paragraph("   7",font)); cell55.setExtraParagraphSpace(10f);
	cell55.setRowspan(11);
	PdfPCell cell56 = new PdfPCell(new Paragraph(" Alternate Faculty Contact Details ",font)); cell56.setExtraParagraphSpace(10f);//1
    PdfPCell cell57 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t1(),font)); cell57.setExtraParagraphSpace(10f);     
    cell57    .setHorizontalAlignment(Element.ALIGN_CENTER);
    PdfPCell cell58 = new PdfPCell(new Paragraph("Address",font)); cell58.setExtraParagraphSpace(10f);//2
	PdfPCell cell59 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t2(),font)); cell59.setExtraParagraphSpace(10f);     
	cell59 .setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell60 = new PdfPCell(new Paragraph("State/UT",font)); cell60.setExtraParagraphSpace(10f);//3
	PdfPCell cell61 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t3(),font)); cell61.setExtraParagraphSpace(10f);   
	cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell62 = new PdfPCell(new Paragraph("District",font)); cell62.setExtraParagraphSpace(10f);//4
	PdfPCell cell63 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t4(),font)); cell63.setExtraParagraphSpace(10f);    
	cell63	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell64 = new PdfPCell(new Paragraph("City",font)); cell64.setExtraParagraphSpace(10f);//5
	PdfPCell cell65 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t4(),font)); cell65.setExtraParagraphSpace(10f);   
	cell65.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell66 = new PdfPCell(new Paragraph("Pin",font)); cell66.setExtraParagraphSpace(10f);//6
	PdfPCell cell67 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t5(),font)); cell67.setExtraParagraphSpace(10f);       
	cell67	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell68 = new PdfPCell(new Paragraph("Phone No",font)); cell68.setExtraParagraphSpace(10f);//7
	PdfPCell cell69 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t6(),font)); cell69.setExtraParagraphSpace(10f);  
	cell69.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell70 = new PdfPCell(new Paragraph("Fax No",font)); cell69.setExtraParagraphSpace(10f);//8
	PdfPCell cell71 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t7(),font)); cell71.setExtraParagraphSpace(10f);      
	cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell72 = new PdfPCell(new Paragraph("Mobile No ",font)); cell72.setExtraParagraphSpace(10f); //9;
	PdfPCell cell73 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t8(),font)); cell73.setExtraParagraphSpace(10f); 
	cell73.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell74 = new PdfPCell(new Paragraph("Email ",font)); cell74.setExtraParagraphSpace(10f);//10
	PdfPCell cell75 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t9(),font)); cell75.setExtraParagraphSpace(10f);     
	cell75		.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell76 = new PdfPCell(new Paragraph("Alternate Email ",font)); cell76.setExtraParagraphSpace(10f); //11
	PdfPCell cell77 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t10(),font)); cell77.setExtraParagraphSpace(10f);   
	cell77.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell78 = new PdfPCell(new Paragraph("   8",font)); cell78.setExtraParagraphSpace(10f);
	PdfPCell cell79 = new PdfPCell(new Paragraph("Website",font)); cell79.setExtraParagraphSpace(10f);
	PdfPCell cell80 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa8t1(),font)); cell80.setExtraParagraphSpace(10f);       
	cell80.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell81 = new PdfPCell(new Paragraph("   9",font)); cell81.setExtraParagraphSpace(10f);
	PdfPCell cell82 = new PdfPCell(new Paragraph("Has the Institution completed 6 years of existence/"
			+ "Years of graduation of last two batches",font)); cell82.setExtraParagraphSpace(10f);
	PdfPCell cell83 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa9t1(),font)); cell83.setExtraParagraphSpace(10f);      
	cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell84 = new PdfPCell(new Paragraph("    10",font)); cell84.setExtraParagraphSpace(10f);
	PdfPCell cell85 = new PdfPCell(new Paragraph("Nature of the college",font)); cell85.setExtraParagraphSpace(10f);
	PdfPCell cell86 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa10t1(),font)); cell86.setExtraParagraphSpace(10f);   
	cell86.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell87 = new PdfPCell(new Paragraph("   11",font)); cell87.setExtraParagraphSpace(10f);
	PdfPCell cell88 = new PdfPCell(new Paragraph("College Affiliation",font)); cell88.setExtraParagraphSpace(10f);
	PdfPCell cell89 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa11t1(),font)); cell89.setExtraParagraphSpace(10f);  
	cell89.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell90 = new PdfPCell(new Paragraph("   12",font)); cell90.setExtraParagraphSpace(10f);
	
	//College AffiliationName of the affiliating University(ies) and the state(s) in which the University(ies) is located
	
	
	PdfPCell cell91 = new PdfPCell(new Paragraph(" Name of the affiliating University" //table in side table 12
			+ "(ies) and the state(s) in which the University"
			
			+ "(ies) is located",font));
	cell91.setExtraParagraphSpace(10f);
	PdfPCell cell92 = new PdfPCell(new Paragraph("",font)); cell92.setExtraParagraphSpace(10f);
//		cell92.setRowspan(3);
	
//	
//	PdfPTable table41411 = new PdfPTable(3);
//	PdfPCell cell701 = new PdfPCell(new Paragraph("State",font)); 
//	//cell701.setExtraParagraphSpace(10f);
//	//PdfPCell cell702 = new PdfPCell(new Paragraph(qIAIndicator3.get(1).getInputiiqa12t1(),font));
//	//cell702.setExtraParagraphSpace(10f);
//	PdfPCell cell703 = new PdfPCell(new Paragraph("Universite",font)); 
////	cell703.setExtraParagraphSpace(10f);
//	PdfPCell cell704 = new PdfPCell(new Paragraph(qIAIndicator3.get(1).getInputiiqa12t2(),font)); 
//	cell704.setExtraParagraphSpace(10f);
//	PdfPCell cell705 = new PdfPCell(new Paragraph("Documents",font)); 
//	//cell705.setExtraParagraphSpace(10f);
//	PdfPCell cell706 = new PdfPCell(new Paragraph(qIAIndicator3.get(1).getInputiiqa12t3(),font));
//	// cell706.setExtraParagraphSpace(10f);
//	
//	
//	
//	table41411.addCell(cell701);
//	table41411.addCell(cell702);
//	table41411.addCell(cell703);
//	table41411.addCell(cell704);
//	table41411.addCell(cell705);
//	table41411.addCell(cell706);
//	
//	
//	 table41411.setSpacingBefore(20f);
//	 table41411.setSpacingAfter(20f);
//	cell92.addElement(table41411);
//	document.add(table41411);


	
//QIAIndicator3	
	
	
	
	
	PdfPCell cell93 = new PdfPCell(new Paragraph("   13",font)); cell93.setExtraParagraphSpace(10f);
	PdfPCell cell94 = new PdfPCell(new Paragraph("s the Institution recognized under section 2(f) of the\r\n"
			+ "UGC Act?",font)); cell94.setExtraParagraphSpace(10f);
	PdfPCell cell95 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa13t1(),font)); cell95.setExtraParagraphSpace(10f);    
	cell95.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell96 = new PdfPCell(new Paragraph("   14",font)); cell96.setExtraParagraphSpace(10f);
	PdfPCell cell97 = new PdfPCell(new Paragraph("Is the Institution recognized under section 12B of the\r\n"
			+ "UGC Act?\r\n"
			+ " If yes, date of recognition by UGC under section\r\n"
			+ "   12B along with latest Plan General Development\r\n"
			+ "Grant release letter",font)); cell97.setExtraParagraphSpace(10f);
	PdfPCell cell98 = new PdfPCell(new Paragraph(new Paragraph(qIAIndicator1.get(0).getInputiiqa14t1(),font)));
	cell98.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	PdfPCell cell99 = new PdfPCell(new Paragraph("   15",font)); cell99.setExtraParagraphSpace(10f);
	PdfPCell cell100 = new PdfPCell(new Paragraph("Is the institution recognised as an Autonomous\r\n"
			+ "College by the UGC?\r\n"
			+ "",font)); cell100.setExtraParagraphSpace(10f);
	
	PdfPCell cell101 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa15t1(),font)); cell101.setExtraParagraphSpace(10f);      
	cell101.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	PdfPCell cell102 = new PdfPCell(new Paragraph("   16",font)); cell102.setExtraParagraphSpace(10f);
	PdfPCell cell103 = new PdfPCell(new Paragraph("Is the institution recognised as a ‘College with\r\n"
			+ "Potential for Excellence (CPE)’ by the UGC?",font)); cell103.setExtraParagraphSpace(10f);
	
	PdfPCell cell104 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa16t1(),font)); cell104.setExtraParagraphSpace(10f);     
	cell104	.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	PdfPCell cell105 = new PdfPCell(new Paragraph("   17",font)); cell105.setExtraParagraphSpace(10f);
	PdfPCell cell106 = new PdfPCell(new Paragraph(" Is the institution recognised as a ‘College of\r\n"
			+ "Excellence’ by the UGC?",font)); cell106.setExtraParagraphSpace(10f);
	PdfPCell cell107 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa17t1(),font)); cell107.setExtraParagraphSpace(10f);     
	cell107	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell108 = new PdfPCell(new Paragraph("   18",font)); cell108.setExtraParagraphSpace(10f);
	cell108.setRowspan(2);
	PdfPCell cell109 = new PdfPCell(new Paragraph(" Is the College offering any programmes recognised\r\n"
			+ "by any Statutory Regulatory Authority (SRA)\r\n"
			+ "",font)); cell109.setExtraParagraphSpace(10f);
	PdfPCell cell110 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa18t1(),font)); cell110.setExtraParagraphSpace(10f);     
	cell110	.setHorizontalAlignment(Element.ALIGN_CENTER);
	
	PdfPCell cell111 = new PdfPCell(new Paragraph("Statutory Regulatory Authorities",font)); cell111.setExtraParagraphSpace(10f);
	PdfPCell cell112 = new PdfPCell(new Paragraph("",font)); cell112.setExtraParagraphSpace(10f);
//nested table
	
	int sizen2 = qiadata.getQiaIndicator4().size();
	PdfPTable table4152 = new PdfPTable(2);
	table4152.setSpacingBefore(20f);
	PdfPCell cell601 = new PdfPCell(new Paragraph("SRA program",font)); cell601.setExtraParagraphSpace(10f);
	PdfPCell cell602 = new PdfPCell(new Paragraph("Document",font)); cell602.setExtraParagraphSpace(10f);
//	PdfPCell cell603 = new PdfPCell(new Paragraph(qiadata.getQiaIndicator4().get(0).getIiqa18t2(),font)); cell4.setExtraParagraphSpace(10f);       .setHorizontalAlignment(Element.ALIGN_CENTER);
//	PdfPCell cell604 = new PdfPCell(new Paragraph(qiadata.getQiaIndicator4().get(0).getIiqa18t2(),font)); cell4.setExtraParagraphSpace(10f);       .setHorizontalAlignment(Element.ALIGN_CENTER);
	
	
	table4152.addCell(cell601 );
	table4152.addCell(cell602 );
	for(int i = 0; i<qiadata.getQiaIndicator4().size();i++)
	{
	PdfPCell cell000001111=new PdfPCell(new Paragraph((qiadata.getQiaIndicator4().get(i).getInputiiqa18t2()),font)); cell4.setExtraParagraphSpace(10f);
	cell000001111.setHorizontalAlignment(Element.ALIGN_CENTER);
	table4152.addCell(cell000001111);
	
	
	PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator4().get(i).getInputiiqa18t3()),font)); cell4.setExtraParagraphSpace(10f);
	cell000001111.setHorizontalAlignment(Element.ALIGN_CENTER);
	table4152.addCell(cell000001111);
	
	
	}

	
	cell112.addElement(table4152);

	 table4152.setSpacingAfter(20f);


	PdfPCell cell113 = new PdfPCell(new Paragraph("   19",font)); cell113.setExtraParagraphSpace(10f);
	PdfPCell cell114 = new PdfPCell(new Paragraph("If the institution is not affiliated to a university and is\r\n"
			+ "offering programmes recognized by any Statutory\r\n"
			+ "Regulatory Authorities (SRA), are the programmes\r\n"
			+ "recognized by Association of Indian Universities(AIU)\r\n"
			+ "or other appropriate Government authorities as\r\n"
			+ "equivalent to UG / PG Programmes of a University",font)); cell114.setExtraParagraphSpace(10f);
	PdfPCell cell115 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa19t1(),font)); cell115.setExtraParagraphSpace(10f);     
	cell115.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell116 = new PdfPCell(new Paragraph("   20",font)); cell116.setExtraParagraphSpace(10f);
	PdfPCell cell117 = new PdfPCell(new Paragraph("Number of programmes offered",font)); cell117.setExtraParagraphSpace(10f);
	
	
//table20
	int sizen4 = qiadata.getQiaIndicator5().size();
	PdfPTable table5154 = new PdfPTable(2);
	table5154.setSpacingBefore(20f);
	PdfPCell cell7011 = new PdfPCell(new Paragraph("Programmes",font)); cell7011.setExtraParagraphSpace(10f);
	PdfPCell cell7021 = new PdfPCell(new Paragraph("Number",font)); cell7021.setExtraParagraphSpace(10f);
	table5154.addCell(cell7011);
	table5154.addCell(cell7021);
	for(int i = 0; i<qiadata.getQiaIndicator5().size();i++)
	{
PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator5().get(i).getInputiiqa20t1()),font)); cell000001.setExtraParagraphSpace(10f);
cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
table5154.addCell(cell000001);

PdfPCell cell0000011=new PdfPCell(new Paragraph((qiadata.getQiaIndicator5().get(i).getInputiiqa20t2()),font)); cell0000011.setExtraParagraphSpace(10f);
cell0000011.setHorizontalAlignment(Element.ALIGN_CENTER);
table5154.addCell(cell0000011);
	}

	
	cell117.addElement(table5154);

	 table5154.setSpacingAfter(20f);
	 cell117.setColspan(2);
	
	
	
	//PdfPCell cell118 = new PdfPCell(new Paragraph("",font)); cell4.setExtraParagraphSpace(10f);
	
	PdfPCell cell119= new PdfPCell(new Paragraph("   21",font)); cell119.setExtraParagraphSpace(10f);
	PdfPCell cell120 = new PdfPCell(new Paragraph("Programme Details",font)); cell120.setExtraParagraphSpace(10f);
//table21
	//table21
			int sizen9 = qiadata.getQiaIndicator6().size();
			PdfPTable table6154 = new PdfPTable(5);
			table6154.setSpacingBefore(20f);
			PdfPCell cell903 = new PdfPCell(new Paragraph("Programmes",font)); cell903.setExtraParagraphSpace(10f);
			PdfPCell cell904 = new PdfPCell(new Paragraph("Department",font)); cell904.setExtraParagraphSpace(10f);
			PdfPCell cell905 = new PdfPCell(new Paragraph("University Affiliation",font)); cell905.setExtraParagraphSpace(10f);
			PdfPCell cell906 = new PdfPCell(new Paragraph("SRA Recognition",font)); cell906.setExtraParagraphSpace(10f);
			PdfPCell cell907 = new PdfPCell(new Paragraph("Affiliation Status",font)); cell907.setExtraParagraphSpace(10f);
			table6154.addCell(cell903);
			table6154.addCell(cell904);
			table6154.addCell(cell905);
			table6154.addCell(cell906);
			table6154.addCell(cell907);
			for(int i = 0; i<qiadata.getQiaIndicator6().size();i++)
			{
		PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator6().get(i).getInputiiqa21t1()),font)); cell000001.setExtraParagraphSpace(10f);
		cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6154.addCell(cell000001);
			PdfPCell cell0000091=new PdfPCell(new Paragraph((qiadata.getQiaIndicator6().get(i).getInputiiqa21t2()),font)); cell0000091.setExtraParagraphSpace(10f);
			cell0000091.setHorizontalAlignment(Element.ALIGN_CENTER);
			table6154.addCell(cell0000091);
			
			
			PdfPCell cell00000991=new PdfPCell(new Paragraph((qiadata.getQiaIndicator6().get(i).getInputiiqa21t3()),font)); cell00000991.setExtraParagraphSpace(10f);
			cell00000991.setHorizontalAlignment(Element.ALIGN_CENTER);
			table6154.addCell(cell00000991);
			
	PdfPCell cell000009991=new PdfPCell(new Paragraph((qiadata.getQiaIndicator6().get(i).getInputiiqa21t4()),font)); cell000009991.setExtraParagraphSpace(10f);
	cell000009991.setHorizontalAlignment(Element.ALIGN_CENTER);
	table6154.addCell(cell000009991);
	
			PdfPCell cell00000221=new PdfPCell(new Paragraph((qiadata.getQiaIndicator6().get(i).getInputiiqa21t5()),font)); cell00000221.setExtraParagraphSpace(10f);
			cell00000221.setHorizontalAlignment(Element.ALIGN_CENTER);
			table6154.addCell(cell00000221);
			
			}

			
			cell120.addElement(table6154);
			 cell120.setColspan(2);
			
			
	
//	PdfPCell cell121 = new PdfPCell(new Paragraph(" ",font)); cell4.setExtraParagraphSpace(10f);
	PdfPCell cell122 = new PdfPCell(new Paragraph("   22 ",font)); cell122.setExtraParagraphSpace(10f);
	PdfPCell cell123 = new PdfPCell(new Paragraph(" Number of Teaching Staff by employment status (permanent / temporary) and by gender ",font)); cell123.setExtraParagraphSpace(10f);
	PdfPCell cell124 = new PdfPCell(new Paragraph(" ",font)); cell124.setExtraParagraphSpace(10f);
	PdfPCell cell125 = new PdfPCell(new Paragraph("   23 ",font)); cell125.setExtraParagraphSpace(10f);
	PdfPCell cell126 = new PdfPCell(new Paragraph(" Number of Non-Teaching Staff by employment status (permanent / temporary) and by gender ",font)); cell126.setExtraParagraphSpace(10f);
//table23
	int sizen11 = qiadata.getQiaIndicator9().size();
	PdfPTable table7154 = new PdfPTable(4);

	PdfPCell cell1903 = new PdfPCell(new Paragraph("Male",font)); cell1903.setExtraParagraphSpace(10f);
	PdfPCell cell1904 = new PdfPCell(new Paragraph("Female",font)); cell1904.setExtraParagraphSpace(10f);
	PdfPCell cell1905 = new PdfPCell(new Paragraph("Transgender",font)); cell1905.setExtraParagraphSpace(10f);
	PdfPCell cell1906 = new PdfPCell(new Paragraph("Total",font)); cell1906.setExtraParagraphSpace(10f);
	
	table7154.addCell(cell1903);
	table7154.addCell(cell1904);
	table7154.addCell(cell1905);
	table7154.addCell(cell1906);

	for(int i = 0; i<qiadata.getQiaIndicator9().size();i++)
	{
	PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator9().get(i).getInputiiqa23t1()),font)); cell000001.setExtraParagraphSpace(10f);
	cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
	table7154.addCell(cell000001);
	
PdfPCell cell0009001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator9().get(i).getInputiiqa23t2()),font)); cell0009001.setExtraParagraphSpace(10f);
cell0009001.setHorizontalAlignment(Element.ALIGN_CENTER);
table7154.addCell(cell0009001);
	PdfPCell cell0080001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator9().get(i).getInputiiqa23t3()),font)); cell0080001.setExtraParagraphSpace(10f);
	cell0080001.setHorizontalAlignment(Element.ALIGN_CENTER);
	table7154.addCell(cell0080001);
	
	
PdfPCell cell06600001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator9().get(i).getInputiiqa23t4()),font)); cell06600001.setExtraParagraphSpace(10f);
cell06600001.setHorizontalAlignment(Element.ALIGN_CENTER);
table7154.addCell(cell06600001);


	
	}

	
	cell126.addElement(table7154);
	 cell126.setColspan(2);

	
	//PdfPCell cell127 = new PdfPCell(new Paragraph(" ",font)); cell4.setExtraParagraphSpace(10f);
	PdfPCell cell128 = new PdfPCell(new Paragraph("   24 ",font)); cell128.setExtraParagraphSpace(10f);
	PdfPCell cell129 = new PdfPCell(new Paragraph("Number of Students on roll by gender ",font)); cell129.setExtraParagraphSpace(10f);

//	PdfPCell cell130 = new PdfPCell(new Paragraph(" ",font)); cell4.setExtraParagraphSpace(10f);
//table	24
	int sizen12 = qiadata.getQiaIndicator10().size();
	PdfPTable table8154 = new PdfPTable(4);

	PdfPCell cell2903 = new PdfPCell(new Paragraph("Male",font)); cell2903.setExtraParagraphSpace(10f);
	PdfPCell cell2904 = new PdfPCell(new Paragraph("Female",font)); cell2904.setExtraParagraphSpace(10f);
	PdfPCell cell2905 = new PdfPCell(new Paragraph("Transgender",font)); cell2905.setExtraParagraphSpace(10f);
	PdfPCell cell2906 = new PdfPCell(new Paragraph("Total",font)); cell2906.setExtraParagraphSpace(10f);
	
	table8154.addCell(cell2903);
	table8154.addCell(cell2904);
	table8154.addCell(cell2905);
	table8154.addCell(cell2906);

	for(int i = 0; i<qiadata.getQiaIndicator10().size();i++)
	{
PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator10().get(i).getInputiiqa24t1()),font)); cell2906.setExtraParagraphSpace(10f);
cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
table8154.addCell(cell000001);

	PdfPCell cell66000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator10().get(i).getInputiiqa24t2()),font)); cell66000001.setExtraParagraphSpace(10f);
	cell66000001.setHorizontalAlignment(Element.ALIGN_CENTER);
	table8154.addCell(cell66000001);
	
	
PdfPCell cell0000012222=new PdfPCell(new Paragraph((qiadata.getQiaIndicator10().get(i).getInputiiqa24t3()),font)); cell0000012222.setExtraParagraphSpace(10f);
cell0000012222.setHorizontalAlignment(Element.ALIGN_CENTER);
table8154.addCell(cell0000012222);


PdfPCell cell888000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator10().get(i).getInputiiqa24t4()),font)); cell888000001.setExtraParagraphSpace(10f);

cell888000001.setHorizontalAlignment(Element.ALIGN_CENTER);
table8154.addCell(cell888000001);


	
	}

	
	cell129.addElement(table8154);
	 cell129.setColspan(2);
//	Table table = new Table(1,1);

	PdfPCell cell131 = new PdfPCell(new Paragraph("   25 ",font)); cell131.setExtraParagraphSpace(10f);
	PdfPCell cell132 = new PdfPCell(new Paragraph("Does the institution have statutory cells / committees",font)); cell132.setExtraParagraphSpace(10f);
	PdfPCell cell133 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa25t1(),font)); cell133.setExtraParagraphSpace(10f);     
	cell133	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell134 = new PdfPCell(new Paragraph("   26 ",font)); cell134.setExtraParagraphSpace(10f);
	cell134.setRowspan(2);
	PdfPCell cell135 = new PdfPCell(new Paragraph("Date of establishment of IQAC",font)); cell135.setExtraParagraphSpace(10f);
	PdfPCell cell136 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa26t1(),font)); cell136.setExtraParagraphSpace(10f);   
	cell136	.setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell137 = new PdfPCell(new Paragraph("The minutes of IQAC meeting and Action Taken\r\n"
			+ "Report should be uploaded on the institutional\r\n"
			+ "website. ",font)); cell137.setExtraParagraphSpace(10f);
	PdfPCell cell138 = new PdfPCell(new Paragraph(" ",font)); cell138.setExtraParagraphSpace(10f);
//nested table
	 int sizen14 = qiadata.getQiaIndicator8().size();
		PdfPTable table0154 = new PdfPTable(2);
		
		PdfPCell cell09 = new PdfPCell(new Paragraph("Date",font)); cell09.setExtraParagraphSpace(10f);
		PdfPCell cell010 = new PdfPCell(new Paragraph("View Document",font)); cell010.setExtraParagraphSpace(10f);
		table0154.addCell(cell09 );
		table0154.addCell(cell010 );
		for(int i = 0; i<qiadata.getQiaIndicator8().size();i++)
		{
		PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator8().get(i).getInputiiqa27t1()),font)); cell000001.setExtraParagraphSpace(10f);
		cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
		table0154.addCell(cell000001 );
		
		PdfPCell cell88000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator8().get(i).getIiqa27f1()),font)); cell88000001.setExtraParagraphSpace(10f);
		
		cell88000001.setHorizontalAlignment(Element.ALIGN_CENTER);
		table0154.addCell(cell88000001 );

		}
	
	 cell138.addElement(table0154);	
	
	

	PdfPCell cell139 = new PdfPCell(new Paragraph("   27",font)); cell139.setExtraParagraphSpace(10f);
	PdfPCell cell140 = new PdfPCell(new Paragraph(" Date of submission of AQARs of last 4 years to\r\n"
			+ "NAAC",font)); cell140.setExtraParagraphSpace(10f);
	
//anothertable	27
	 PdfPCell cell141 = new PdfPCell(new Paragraph("",font)); cell141.setExtraParagraphSpace(10f);
	 int sizen3 = qiadata.getQiaIndicator7().size();
		PdfPTable table4154 = new PdfPTable(2);
		
		PdfPCell cell609 = new PdfPCell(new Paragraph("Date",font)); cell609.setExtraParagraphSpace(10f);
		PdfPCell cell610 = new PdfPCell(new Paragraph("View Document",font)); cell610.setExtraParagraphSpace(10f);
		table4154.addCell(cell609 );
		table4154.addCell(cell610 );
		for(int i = 0; i<qiadata.getQiaIndicator7().size();i++)
		{
		PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator7().get(i).getInputiiqa26t2()),font)); cell000001.setExtraParagraphSpace(10f);
		cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4154.addCell(cell000001 );
		
PdfPCell cell00007701=new PdfPCell(new Paragraph((qiadata.getQiaIndicator7().get(i).getIiqa26f1()),font)); cell00007701.setExtraParagraphSpace(10f);
cell00007701.setHorizontalAlignment(Element.ALIGN_CENTER);
table4154.addCell(cell00007701 );



//		table4141.	PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator7().get(i).getIiqa1t5(),font);
//		table4141.	PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator7().get(i).getIiqa1t6(),font);
		}
	
	 cell141.addElement(table4154);

	 PdfPCell cell142 = new PdfPCell(new Paragraph("   28",font)); cell142.setExtraParagraphSpace(10f);
		PdfPCell cell143 = new PdfPCell(new Paragraph(" Has the institution made statutory declaration on the\r\n"
				+ "institution website under Section 4 (1) (b) of the RTI\r\n"
				+ "Act 2005 as issued and amended from time to time.\r\n"
				+ "",font)); cell143.setExtraParagraphSpace(10f);
		PdfPCell cell144 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa28t1(),font)); cell144.setExtraParagraphSpace(10f);   
		cell144	.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell145 = new PdfPCell(new Paragraph("   29",font)); cell145.setExtraParagraphSpace(10f);
		PdfPCell cell146 = new PdfPCell(new Paragraph(" Does the college have an academic MoU with any\r\n"
				+ "foreign institution",font)); cell146.setExtraParagraphSpace(10f);
		PdfPCell cell147 = new PdfPCell(new Paragraph(qiadata.getInputIiqaAisheId(),font)); cell147.setExtraParagraphSpace(10f);       
		cell147.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell148 = new PdfPCell(new Paragraph("   30",font)); cell148.setExtraParagraphSpace(10f);
		PdfPCell cell149 = new PdfPCell(new Paragraph("Date of uploading data on MHRD website for All India\r\n"
				+ "Survey on Higher Education (AISHE).",font)); cell149.setExtraParagraphSpace(10f);
		PdfPCell cell150 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa30t1(),font)); cell150.setExtraParagraphSpace(10f);       
		cell150	.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell151= new PdfPCell(new Paragraph("   31",font)); cell151.setExtraParagraphSpace(10f);
		PdfPCell cell152= new PdfPCell(new Paragraph(" Attach Certification by the Head of the Institution for\r\n"
				+ "having complied with Rules & Regulations of Central\r\n"
				+ "Government, UGC and other Statutory Bodies, State\r\n"
				+ "Government and Affiliating University in the\r\n"
				+ "prescribed format enclosed herewith.\r\n"
				+ "",font)); cell152.setExtraParagraphSpace(10f);
		PdfPCell cell153= new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa31t1(),font)); cell153.setExtraParagraphSpace(10f);       
		cell153	.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell154= new PdfPCell(new Paragraph("   32",font)); cell154.setExtraParagraphSpace(10f);
		PdfPCell cell155= new PdfPCell(new Paragraph("Registration Fee paid details.",font)); cell155.setExtraParagraphSpace(10f);
		PdfPCell cell156= new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa32t1(),font)); cell156.setExtraParagraphSpace(10f);    
		cell156	.setHorizontalAlignment(Element.ALIGN_CENTER);
	 

	
	
	
	
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
	
////table12
//	table1.addCell(cell701);
//	table1.addCell(cell702);
//	table1.addCell(cell703);
//	table1.addCell(cell704);
//	table1.addCell(cell705);
//	table1.addCell(cell706);
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
//	table1.addCell(cell118);
	table1.addCell(cell119);
	table1.addCell(cell120);
	
	
	//table1.addCell(cell121);
	table1.addCell(cell122);
	table1.addCell(cell123);
	table1.addCell(cell124);
	table1.addCell(cell125);
	table1.addCell(cell126);
	//table1.addCell(cell127);
	table1.addCell(cell128);
	table1.addCell(cell129);
//	table1.addCell(cell130);
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
		
		
		
		public void Criteria1(Document document,Criteria1_FieldInfo criteria1Fieldinfo) {
			Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n\r\n", font1);
			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			Paragraph paragraphlinecriteria1 = new Paragraph(
					"____________________________________________________________________________\r\n");
			document.add(paragraphlinecriteria1);
		//	paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph1);
			Paragraph paragraph2 = new Paragraph("1.1  Curricular Planning and Implementation\r\n", font2);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph2);
			PdfPTable table111criteria1 = new PdfPTable(1);

			table111criteria1.setWidthPercentage(100);
			PdfPCell cell111criteria1 = new PdfPCell(new Paragraph(
					"1.1.1: The Institution ensures effective curriculum planning and delivery through a well-planned and documented process including Academic calendar and conduct of continuous internal Assessment\r\n\r\n"
							+ "Response: " 
							+ (criteria1Record != null
									? criteria1Record.getCriteria11Ql().get(0).getResponse111()
									:" ")+"\r\n\r\n",font4));

			table111criteria1.addCell(cell111criteria1);

			table111criteria1.setSpacingBefore(20);
			table111criteria1.setSpacingAfter(20);
			document.add(table111criteria1);

			// 112
			PdfPTable table112 = new PdfPTable(2);
			table112.setWidthPercentage(100);
			PdfPTable table1120 = new PdfPTable(1);
			table1120.setWidthPercentage(100);
			PdfPCell cell1121 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell1121.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1122 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell1122.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1123 = new PdfPCell(new Paragraph("\r\nUpload additional information\r\n\r\n",font5));
			cell1123.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1124 = new PdfPCell(
					new Paragraph("\r\n"+(criteria1Record.getCriteria1FileUpload().get(0).getCriteria1FileName())+"\r\n\r\n",font5));
			cell1124.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1125 = new PdfPCell(new Paragraph("\r\nLink for Additional information\r\n\r\n",font5));
			cell1125.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1126 = new PdfPCell(
					new Paragraph("\r\n"+(criteria1Record.getCriteria1FileUpload().get(0).getCriteria1FileName())+"\r\n\r\n",font5));
			cell1126.setHorizontalAlignment(Element.ALIGN_CENTER);
			table112.addCell(cell1121);
			table112.addCell(cell1122);
			table112.addCell(cell1123);
			table112.addCell(cell1124);
			table112.addCell(cell1125);
			table112.addCell(cell1126);
			table112.setSpacingAfter(20);
			table112.setSpacingBefore(20);
			
			document.add(table112);		
			
			// 1.2
			
		
			Paragraph paragraph02 = new Paragraph("1.2: Academic Flexibility \r\n", font2);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph02);
			
			PdfPTable table1101criteria1 = new PdfPTable(1);
			table1101criteria1.setWidthPercentage(100);
			
			PdfPCell cell1101criteria1 = new PdfPCell(new Paragraph(
					"1.2.1: Number of Add on /Certificate/Value added programs offered during the last five years\r\n\r\n"
							+ "Response: "
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getResponse121()
									:" ")+"\r\n\r\n",font4));
			
			
			PdfPCell cell11001criteria1 = new PdfPCell(new Paragraph(
					"1.2.1.1: How many new courses are introduced within the last five years\r\n\r\n"
							+ "Response: "
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getInput1211t1()
									: " ")+"\r\n\r\n",font4));
			
			PdfPCell cell110001criteria1 = new PdfPCell(new Paragraph(
					"1.2.1.2: : Number of Add on /Certificate /Value added programs offered during the last five years\r\n\r\n"
							+ "Response: "
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getInput1212t1()
									: " ")+"\r\n\r\n",font4));
			
			

			table1101criteria1.addCell(cell1101criteria1);
			table1101criteria1.addCell(cell11001criteria1);
			table1101criteria1.addCell(cell110001criteria1);

			table1101criteria1.setSpacingBefore(20);
			table1101criteria1.setSpacingAfter(20);
			document.add(table1101criteria1);

			// 122
			PdfPTable table1102 = new PdfPTable(2);
			table1102.setWidthPercentage(100);
			
			PdfPCell cell11201 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell11201.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11202 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell11202.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11203 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell11203.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11204 = new PdfPCell(new Paragraph("\r\n"+(criteria1Record.getCriteria1FileUpload().get(0).getCriteria1FileName())+"\r\n\r\n",font5));
			cell11204.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11205 = new PdfPCell(new Paragraph("\r\nLink for Additional information\r\n\r\n",font5));
			cell11205.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11206 = new PdfPCell(new Paragraph("\r\n"+(criteria1Record.getCriteria1FileUpload().get(0).getCriteria1FileName())+"\r\n\r\n",font5));
			cell11206.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1102.addCell(cell11201);
			table1102.addCell(cell11202);
			table1102.addCell(cell11203);
			table1102.addCell(cell11204);
			table1102.addCell(cell11205);
			table1102.addCell(cell11206);
			table1102.setSpacingAfter(20);
			table1102.setSpacingBefore(20);
			document.add(table1102);
			
			PdfPTable table12criteria1 = new PdfPTable(1);
			table12criteria1.setWidthPercentage(100);
			
			PdfPTable table1221criteria1 = new PdfPTable(1);
			table1221criteria1.setWidthPercentage(100);
			
			PdfPCell cell1criteria1 = new PdfPCell(new Paragraph(
					"1.2.2: Percentage of students enrolled in Certificate/ Add-on/Value added programs as against the total number of students during the last five years\r\n\r\n"
							+ "Response: "
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getResponse122()
									: " ")+"\r\n\r\n",font4));
			
			table12criteria1.addCell(cell1criteria1);
			
			PdfPCell cell221criteria1 = new PdfPCell(new Paragraph(
					"1.2.2.1: Number of students enrolled in subject related Certificate/ Add-on/Value added programs year wise during last five years\r\n\r\n"
							,font4));
			
			
			table1221criteria1.addCell(cell221criteria1);
			table12criteria1.setSpacingAfter(20);
			table12criteria1.setSpacingBefore(20);
//			table12criteria1.setSpacingAfter(20);
//			table12criteria1.setSpacingBefore(20);
			document.add(table12criteria1);
			document.add(table1221criteria1);
			
			
			if(criteria1Record.getAffiliatedYearTable1221().size()>0)
			{
			Table table1221criteria12 = new Table(criteria1Record.getAffiliatedYearTable1221().size());

			table1221criteria12.setPadding(5);
			table1221criteria12.setWidth(100f);

			for (int i = 0; i < criteria1Record.getAffiliatedYearTable1221().size(); i++) {
				Cell cell1criteria1221 = new Cell (criteria1Record.getAffiliatedYearTable1221().get(i).getInput1221y());
				cell1criteria1221.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1221criteria12.addCell(cell1criteria1221);
				
			}
			for (int i = 0; i < criteria1Record.getAffiliatedYearTable1221().size(); i++) {
				Cell cell2criteria1221 = new Cell (criteria1Record.getAffiliatedYearTable1221().get(i).getInput1221v());
				cell2criteria1221.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1221criteria12.addCell(cell2criteria1221);
				
			}

			document.add(table1221criteria12);
		

			
			}
			
			
			
			
			
			PdfPTable table2 = new PdfPTable(2);
			table2.setWidthPercentage(100);
			
			PdfPCell cell10 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell12 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n",font5));
			cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell13 = new PdfPCell(new Paragraph("\r\n"+(criteria1Record.getCriteria1FileUpload().get(0).getCriteria1FileName())+"\r\n\r\n",font5));
			cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell14 = new PdfPCell(new Paragraph("\r\nUpload supported document\r\n\r\n",font5));
			cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell15 = new PdfPCell(new Paragraph("\r\n"+(criteria1Record.getCriteria1FileUpload().get(0).getCriteria1FileName())+"\r\n\r\n",font5));
			cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(cell10);
			table2.addCell(cell11);
			table2.addCell(cell12);
			table2.addCell(cell13);
			table2.addCell(cell14);
			table2.addCell(cell15);
			table2.setSpacingAfter(20);
			table2.setSpacingBefore(20);
			document.add(table2);
			
			
			
			/// 1.3 
			
			
			  Paragraph paragraph1331 = new Paragraph("1.3  Curriculum Enrichment",font2);
			  paragraph1331.setAlignment(Element.ALIGN_JUSTIFIED);
				document.add(paragraph1331);
			
				
				Paragraph paragraph13 = new Paragraph("\r\n");
				document.add(paragraph13);
				
				PdfPTable table131 = new PdfPTable(2);
				table131.setWidthPercentage(100);
				 PdfPTable table1310 = new PdfPTable(1);
				 table1310.setWidthPercentage(100);
				
				PdfPCell cell131= new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n",font4));
				cell131.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell132 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n",font4));
				cell132.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell133 = new PdfPCell(new Paragraph("\r\nAny Additional Information\r\n\r\n",font5));
				cell133.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell134 = new PdfPCell(new Paragraph("\r\n"+((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath():"")+"\r\n\r\n",font5));
				cell134.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell135 = new PdfPCell(new Paragraph(" \r\nProvide Link for additional information\r\n\r\n",font5));
				cell135.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell136= new PdfPCell(new Paragraph("\r\n"+((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :"")+"\r\n\r\n",font5));
				cell136.setHorizontalAlignment(Element.ALIGN_CENTER);
				table131.addCell(cell131);
				table131.addCell(cell132);
				table131.addCell(cell133); 
				table131.addCell(cell134);
				table131.addCell(cell135);
				table131.addCell(cell136);
				table131.setSpacingAfter(20);
				table131.setSpacingBefore(20);
				//document.add(table1310);
				
				
				PdfPCell cell1361= new PdfPCell(new Paragraph(
						" 1.3.1 Institution integrates crosscutting issues relevant to Professional Ethics ,Gender, Human Values ,Environment and Sustainability into the Curriculum\r\n\r\n"
				+"Response: "
				+(criteria1Record != null ? criteria1Record.getCriteria13Ql().get(0).getResponse131():"")+"\r\n\r\n",font4));
			
				table1310.addCell(cell1361);
			
			//	PdfPCell cell136110= new PdfPCell(new Paragraph(criteria1Record != null ? criteria1Record.getCriteria13Ql().get(0).getResponse131():""+"\r\n\r\n",font5));

			//	table1310.addCell(cell136110);
				table1310.setSpacingAfter(20);
				table1310.setSpacingBefore(20);
				document.add(table1310);
				document.add(table131);
				
				

			
				

				PdfPTable table133 = new PdfPTable(2);
				table133.setWidthPercentage(100);
				PdfPTable table1330 = new PdfPTable(1);
				table1330.setWidthPercentage(100);
				PdfPCell cell1331= new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n",font4));
				cell1331.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1332 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n",font4));
				cell1332.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1333 = new PdfPCell(new Paragraph("\r\nInstitutional data in the prescribed format"
						+ "\r\n\r\n",font5));
				cell1333.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1334 = new PdfPCell(new Paragraph("\r\n"+((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :"")+"\r\n\r\n",font5));
				cell1334.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1335 = new PdfPCell(new Paragraph("\r\nUpload supporting document\r\n\r\n",font5));
				cell1335.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1336 = new PdfPCell(new Paragraph("\r\n"+((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :"")+"\r\n\r\n",font5));
				cell1336.setHorizontalAlignment(Element.ALIGN_CENTER);
				table133.addCell(cell1331);
				table133.addCell(cell1332);
				table133.addCell(cell1333);
				table133.addCell(cell1334);
				table133.addCell(cell1335);
				table133.addCell(cell1336);
				table133.setSpacingAfter(20);
				table133.setSpacingBefore(20);
			//	document.add(table1330);
			//	document.add(table133);
				
				
				PdfPCell cell133610 = new PdfPCell(new Paragraph("1.3.2.1: Number of students undertaking field projects / internships / student projects\r\n\r\nResponse: "
				+(criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getInput1321t11():"")+"\r\n\r\n",font4));
					table1330.addCell(cell133610);
				
				PdfPCell cell133611 = new PdfPCell(new Paragraph("1.3.2.1: Total number of students\r\n\r\n"
						+ "Response: "+(criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getInput1321t12():"")+"\r\n\r\n",font4));
//				PdfPCell cell13361 = new PdfPCell(new Paragraph("1.3.3: Percentage of students undertaking field projects/ internships / student projects (Data for the latest completed academic year).\r\n\r\n"
//						+ "Response: "+font4+(criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getResponse133():""),font5));
//				table1330.addCell(cell13361);

				table1330.addCell(cell133611);
				table1330.setSpacingAfter(20);
				table1330.setSpacingBefore(20);
				document.add(table1330);
				document.add(table133);
				
				
				
			
			//1.4
				
				
				Paragraph paragraph1441 = new Paragraph("1.4 Feedback System\r\n\r\n",font2);
				paragraph1441.setAlignment(Element.ALIGN_JUSTIFIED);
				document.add(paragraph1441);
				
				
				
				PdfPTable table141 = new PdfPTable(2);
				table141.setWidthPercentage(100);
				PdfPTable table1410 = new PdfPTable(1);
				table1410.setWidthPercentage(100);
				
				
				PdfPCell cell133612 = new PdfPCell(new Paragraph("1.4.1: Institution obtains feedback on the academic performance and ambience of the institution from various stakeholders, "
						+ "such as Students, Teachers, Employers, Alumni etc. and action taken report on the feedback is made available on institutional website (Yes or No)\r\n\r\n"
						+"Response: "
						+(criteria1Record != null	? criteria1Record.getCriteria14Qn().get(0).getResponse141():"")+"\r\n\r\n",font4));
				
				table1410.addCell(cell133612);
				
//				if(criteria1Record.getCriteria14Qn().size()>0)
//				{
//					PdfPCell cell1336120 = new PdfPCell(new Paragraph("\r\n"+criteria1Record != null	? criteria1Record.getCriteria14Qn().get(0).getResponse141():"\r\n\r\n",font5));
//					table1410.addCell(cell1336120);
//				}
//				table1410.setSpacingAfter(20);
//		//		table1410.setSpacingBefore(20);
				document.add(table1410);
			
				
				
				PdfPCell cell141 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n",font4));
				cell141.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell142= new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n",font4));
				cell142.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell143= new PdfPCell(new Paragraph("\r\nUpload Supporting Document\r\n\r\n",font5));
				cell143.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell144= new PdfPCell(new Paragraph("\r\n"+((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :"")+"\r\n\r\n",font5));
				cell144.setHorizontalAlignment(Element.ALIGN_CENTER);
				table141.addCell(cell141);
				table141.addCell(cell142);
				table141.addCell(cell143);
				table141.addCell(cell144);
				table141.setSpacingAfter(20);
				table141.setSpacingBefore(20);
				 document.add(table141);
				 
				}
	//////////////////////////////////////////////////// 2.1
  public void Criteria2(Document document,Criteria2_FieldInfo criteria2Fieldinfo) {	
		PdfPTable tablecriteria2 = new PdfPTable(1);
		tablecriteria2.setWidthPercentage(100);
		PdfPTable table1criteria2 = new PdfPTable(1);
		table1criteria2.setWidthPercentage(100);
		PdfPTable table6criteria2 = new PdfPTable(5);
		table6criteria2.setWidthPercentage(100);

		PdfPTable table7criteria2 = new PdfPTable(2);
		table7criteria2.setWidthPercentage(100);


		Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation\r\n\r\n", font1);
		Paragraph paragraph3criteria2 = new Paragraph("2.1 Student Enrollment and Profile\r\n", font2);
	//	Paragraph paragraph300criteria2 = new Paragraph("211 Enrolment percentage\r\n\r\n", font4);

		paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		paragraph2criteria2.setAlignment(Paragraph.ALIGN_CENTER);
		paragraph3criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph2criteria2);
		document.add(paragraph3criteria2);
	//	document.add(paragraph300criteria2);
		tablecriteria2.setWidthPercentage(100f);
		
		
		
		PdfPTable table211criteria2 = new PdfPTable(1);
		PdfPTable table2111criteria2 = new PdfPTable(1);
		
		table211criteria2.setWidthPercentage(100);
		table2111criteria2.setWidthPercentage(100);
		
		PdfPCell cell211criteria2 = new PdfPCell(new Paragraph("2.1.1 Average Enrolment percentage (Average of last five years)\r\n" + "\r\n"  
		+ "Response: "
						+ ( criteria2Record != null
						? criteria2Record.getCriteria21Qn().get(0).getResponse211()
								: "")+"\r\n\r\n",font4));
		table211criteria2.addCell(cell211criteria2);

		PdfPTable tablecriteria02 = new PdfPTable(1);
		tablecriteria02.setWidthPercentage(100);
		
		PdfPCell cell2111criteria2 = new PdfPCell(new Paragraph(
					"2.1.1.1 Number of students admitted year-wise during last five years"+ "\r\n\r\n",font4));
		
		table2111criteria2.addCell(cell2111criteria2);
		
		table211criteria2.setSpacingAfter(20);
		table211criteria2.setSpacingBefore(20);
		
		table2111criteria2.setSpacingAfter(20);
		table2111criteria2.setSpacingBefore(20);
		
		document.add(table211criteria2);
      document.add(table2111criteria2);
				
		 
		
		
		document.add(tablecriteria02);
		
		//YEAR TABLE 2111
		if(criteria2Record.getYearTable2111() !=null)
		{

		Table table2111 = new Table(criteria2Record.getYearTable2111().size(), 2);

		table2111.setPadding(5);
		table2111.setWidth(100f);
	
		for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
			Cell cell1criteria2111 = new Cell (criteria2Record.getYearTable2111().get(i).getInput2111y());
			cell1criteria2111.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2111.addCell(cell1criteria2111);
		}
	
			for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
				Cell cell2criteria2111 = new Cell (criteria2Record.getYearTable2111().get(i).getInput2111v());
				cell2criteria2111.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2111.addCell(cell2criteria2111);
		}

		document.add(table2111);

	}
		// YEAR TABLE 2112
		
		PdfPTable table2112criteria02 = new PdfPTable(1);
		table2112criteria02.setWidthPercentage(100);
		
		PdfPCell cell2112criteria2 = new PdfPCell(new Paragraph(
				"2.1.1.2 Number of students admitted year-wise during last five years\r\n\r\n",font4));
			
		table2112criteria02.addCell(cell2112criteria2);
		table2112criteria02.setSpacingAfter(20);
		table2112criteria02.setSpacingBefore(20);
		
		document.add(table2112criteria02);
			
			

		
		if(criteria2Record.getYearTable2112() !=null)
		{
		Table table2112 = new Table(criteria2Record.getYearTable2112().size());

		table2112.setPadding(5);
		table2112.setWidth(100f);
	
		for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
			Cell cell1criteria2112 = new Cell (criteria2Record.getYearTable2112().get(i).getInput2112y());
			cell1criteria2112.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2112.addCell(cell1criteria2112);
			
		}
	
		for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
			Cell cell2criteria2112 = new Cell (criteria2Record.getYearTable2112().get(i).getInput2112v());
			cell2criteria2112.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2112.addCell(cell2criteria2112);
			
		}

		document.add(table2112);
	}
		PdfPTable table3criteria2 = new PdfPTable(2);
		table3criteria2.setWidthPercentage(100);
//      table3criteria2.setWidths(new int[] { 3, 3 });
//		table3criteria2.setSpacingBefore(20);

		PdfPCell cell1criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell1criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell1criteria2);

		PdfPCell cell2criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell2criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell2criteria2);

		PdfPCell cell3criteria2 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format(Data Template)\r\n\r\n",font5));
		cell3criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell3criteria2);

		PdfPCell cell4criteria2 = new PdfPCell(
				new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell4criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell4criteria2);

		PdfPCell cell5criteria2 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
		cell5criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell5criteria2);

		PdfPCell cell6criteria2 = new PdfPCell(
				new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(2).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell6criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3criteria2.addCell(cell6criteria2);
		
		table3criteria2.setSpacingAfter(20);
		table3criteria2.setSpacingBefore(20);
      document.add(table3criteria2);

	
      PdfPTable table212criteria2 = new PdfPTable(2);
      table212criteria2.setWidthPercentage(100);

      PdfPCell cell212criteria2 = new PdfPCell(new Paragraph(
				"2.1.2 Average percentage of seats filled against reserved categories (SC, ST, OBC, Divyangjan, etc. as per applicable reservation policy ) during the last five years ( exclusive of supernumerary seats)\r\n"
						+ "\r\n" + "Response: "
						+(criteria2Record != null
						? criteria2Record.getCriteria21Qn().get(0).getResponse212()
						: "")+"\r\n\r\n",font4));
      
      table212criteria2.addCell(cell212criteria2);
      document.add(table212criteria2);
      
      
//      Paragraph paragraph2criteria212 = new Paragraph((criteria2Record != null
//								? criteria2Record.getCriteria21Qn().get(0).getResponse212()
//								: ""));
//      document.add(paragraph2criteria212);
 
// PdfPCell cell0001criteria2 = new PdfPCell(new Paragraph(
//				"2.1.2 Average percentage of seats filled against reserved categories (SC, ST, OBC, Divyangjan etc. as per applicable reservation policy ) during the last five years ( exclusive of supernumerar seats"+ "Response:"
//						+(criteria2Fieldinfo != null
//				? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse212()
//				: ""),font3));
//      table3criteria2.addCell(cell0001criteria2);
  //    document.add(table3criteria2);
		
//		table1criteria2.addCell((criteria2Record != null
//							? criteria2Record.getCriteria21Qn().get(0).getInput2121t21()
//								: ""));
//		
		
      PdfPTable table2121criteria2 = new PdfPTable(2);
      table2121criteria2.setWidthPercentage(100);
		
      PdfPCell cell2121criteria2 = new PdfPCell(new Paragraph(
				"2.1.2.1 Number of actual students admitted from the reserved categories year wise during last"
				+ "five years\r\n \r\n",font4));
      table2121criteria2.addCell(cell2121criteria2);
      table2121criteria2.setSpacingAfter(20);
      table2121criteria2.setSpacingBefore(20);
      
      document.add(table2121criteria2);
      
      
      if(criteria2Record.getYearTable2121() !=null)
      {
      			Table table2121 = new Table(criteria2Record.getYearTable2121().size());

      			table2121.setPadding(5);
      			table2121.setWidth(100f);
      		
      			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
      				Cell cell1criteria2121 = new Cell (criteria2Record.getYearTable2121().get(i).getInput2121y());
      				cell1criteria2121.setHorizontalAlignment(Element.ALIGN_CENTER);
      				table2121.addCell(cell1criteria2121);
      				
      			}
      		
      			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
      				Cell cell2criteria2121 = new Cell (criteria2Record.getYearTable2121().get(i).getInput2121v());
      				cell2criteria2121.setHorizontalAlignment(Element.ALIGN_CENTER);
      				table2121.addCell(cell2criteria2121);
      				
      			}

      			document.add(table2121);
      			
      		}
      
		
      PdfPTable table2122criteria2 = new PdfPTable(2);
      table2122criteria2.setWidthPercentage(100);
		
      PdfPCell cell2122criteria2 = new PdfPCell(new Paragraph(
				"2.1.2.2 Number of actual students admitted from the reserved categories year wise during last five \r\n"
						+ "\r\n",font4));
      table2122criteria2.addCell(cell2122criteria2);
      table2122criteria2.setSpacingAfter(20);
      table2122criteria2.setSpacingBefore(20);
      
      document.add(table2122criteria2);
      
      
      if( criteria2Record.getYearTable2121() !=null)
		{
		Table table2122 = new Table(criteria2Record.getYearTable21212().size());

		table2122.setPadding(5);
		table2122.setWidth(100f);
//		table2122.addCell("year");
		for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
			Cell cell1criteria2122 = new Cell (criteria2Record.getYearTable21212().get(i).getInput21212y());
			cell1criteria2122.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2122.addCell(cell1criteria2122);
			
			
		}
//		table2122.addCell("Number of seats earmarked");
		for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
			Cell cell2criteria2122 = new Cell (criteria2Record.getYearTable21212().get(i).getInput21212v());
			cell2criteria2122.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2122.addCell(cell2criteria2122);
			
		}

		document.add(table2122);
		
	}
      
	
		
		
		PdfPTable table07criteria2 = new PdfPTable(2);
		table07criteria2.setWidthPercentage(100);
//		table07criteria2.setWidths(new int[] { 3, 3 });
		

		PdfPCell cell07criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell07criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table07criteria2.addCell(cell07criteria2);

		PdfPCell cell08criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell08criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table07criteria2.addCell(cell08criteria2);

		PdfPCell cell09criteria2 = new PdfPCell(new Paragraph("\r\nAverage percentage of seats vfilled against seats reserved\r\n\r\n",font5));
		cell09criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table07criteria2.addCell(cell09criteria2);

		PdfPCell cell10criteria2 = new PdfPCell(
				new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell10criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table07criteria2.addCell(cell10criteria2);

		PdfPCell cell11criteria2 = new PdfPCell(new Paragraph("\r\n Additional Information\r\n\r\n",font5));
		cell11criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table07criteria2.addCell(cell11criteria2);

		PdfPCell cell12criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell12criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table07criteria2.addCell(cell12criteria2);
		
		table07criteria2.setSpacingAfter(20);
		table07criteria2.setSpacingBefore(20);
		document.add(table07criteria2);
		
		//2.2
		
		
		Paragraph paragraph02criteria2 = new Paragraph("2.2: Catering to Student Diversity\r\n\r\n", font2);
		document.add(paragraph02criteria2);
	
		 PdfPTable table221criteria2 = new PdfPTable(2);
		 table221criteria2.setWidthPercentage(100);
			
	        
	       PdfPCell cell1criteria221 = new PdfPCell(new Paragraph("2.2.1  Student - Full time teacher ratio (Data for the latest completed academic year)\r\n" + "\r\n" + "Response:"
						+  (criteria2Record != null
						? criteria2Record.getCriteria22Qn().get(0).getResponse221()
								: "")+"\r\n\r\n",font4));
	       table221criteria2.addCell(cell1criteria221);
	       table221criteria2.setSpacingAfter(20);
	       table221criteria2.setSpacingBefore(20);
	       
	      
	       
	       
	       PdfPTable table2210criteria2 = new PdfPTable(2);
	       table2210criteria2.setWidthPercentage(100);
				
		        
		       PdfPCell cell1criteria2210 = new PdfPCell(new Paragraph("2.2.1 Average Enrolment percentage (Average of last five years)\r\n" + "\r\n" 
				+  (criteria2Record != null
				? criteria2Record.getCriteria22Qn().get(0).getInput221t1()
						: "")+"\r\n\r\n",font4));
		   //    table2210criteria2.addCell(cell1criteria2210); 
		       
         //     document.add(table2210criteria2);
		       
		       
    
    PdfPTable table9criteria2 = new PdfPTable(2);

		table9criteria2.setWidthPercentage(100f);
		table9criteria2.setWidths(new int[] { 3, 3 });
		table9criteria2.setSpacingBefore(5);

		PdfPCell cell17criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell17criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria2.addCell(cell17criteria2);

		PdfPCell cell18criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell18criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria2.addCell(cell18criteria2);

		PdfPCell cell19criteria2 = new PdfPCell(new Paragraph("\r\nUplaod any additional information\r\n\r\n",font5));
		cell19criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria2.addCell(cell19criteria2);

		PdfPCell cell20criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell20criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table9criteria2.addCell(cell20criteria2);
		table9criteria2.setSpacingAfter(20);
		table9criteria2.setSpacingBefore(20);
		
		 document.add(table221criteria2);
		document.add(table9criteria2);
		
		//2.3
		
		Paragraph paragraph5criteria2 = new Paragraph("2.3	Teaching- Learning Process\r\n\r\n", font2);
		document.add(paragraph5criteria2);

		PdfPTable table03 = new PdfPTable(1);
		table03.setWidthPercentage(100f);

		PdfPCell cell001 = new PdfPCell(new Paragraph(
				"2.3.1 Student centric methods, such as experiential learning, participative learning and problem solving methodologies are used for enhancing learning experiences"
						+ "\r\n\r\n"+ "Response: "
						+ (criteria2Record != null
						? criteria2Record.getCriteria23Ql().get(0).getResponse231()
								: "")+ "\r\n\r\n",font4));

		table03.addCell(cell001);
		table03.setSpacingAfter(20);
		table03.setSpacingBefore(20);
		document.add(table03);

		
		PdfPTable table10criteria2 = new PdfPTable(2);

		table10criteria2.setWidthPercentage(100f);
		table10criteria2.setWidths(new int[] { 3, 3 });
		table10criteria2.setSpacingBefore(5);

		
		
		
		PdfPCell cell21criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell21criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table10criteria2.addCell(cell21criteria2);

		PdfPCell cell22criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell22criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table10criteria2.addCell(cell22criteria2);

		PdfPCell cell23criteria2 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
		cell23criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table10criteria2.addCell(cell23criteria2);

		PdfPCell cell24criteria2 = new PdfPCell(new Paragraph( "\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell24criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table10criteria2.addCell(cell24criteria2);
		
		PdfPCell cell23xcriteria2 = new PdfPCell(new Paragraph("\r\nLink for additional information\r\n\r\n",font5));
		cell23xcriteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table10criteria2.addCell(cell23xcriteria2);

		PdfPCell cell24xcriteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() :  "")+"\r\n\r\n",font5));
		cell24xcriteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table10criteria2.addCell(cell24xcriteria2);
		table10criteria2.setSpacingAfter(20);
		table10criteria2.setSpacingBefore(20);
		document.add(table10criteria2);

		//2.4
		
		Paragraph paragraph6criteria2 = new Paragraph(" 2.4 Teacher Profile and Quality\r\n\r\n", font2);

		paragraph6criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph6criteria2);

		PdfPTable table241criteria24 = new PdfPTable(1);
		table241criteria24.setWidthPercentage(100f);

		PdfPCell cell1criteria241 = new PdfPCell(new Paragraph(
				"2.4.1: Percentage of full-time teachers against sanctioned posts during the last five years"
						+ "\r\n\r\n" + "Response: "
						+(criteria2Record != null
						? criteria2Record.getCriteria24Qn().get(0).getResponse241()
						: "")+"\r\n\r\n",font4));
		
		table241criteria24.addCell(cell1criteria241);
		table241criteria24.setSpacingAfter(20);
		table241criteria24.setSpacingBefore(20);
		
		document.add(table241criteria24);
//		if(criteria2Record.getCriteria24Qn()!=null)
//		{
//		Paragraph paragraph6criteria22 = new Paragraph((criteria2Record != null
//								? criteria2Record.getCriteria24Qn().get(0).getResponse241()
//								: ""));
//		document.add(paragraph6criteria22);
//		}
		
		PdfPTable table2411criteria24 = new PdfPTable(1);
		table2411criteria24.setWidthPercentage(100f);

		PdfPCell cell1criteria2411 = new PdfPCell(new Paragraph("2.4.1.1 Number of Sanctioned posts / required positions for teaching staff/ "
				+ "full time teachers year wise during the last five years:\r\n\r\n",font4));
		
	//	document.add(paragraph6criteria23);
		table2411criteria24.addCell(cell1criteria2411);
		table2411criteria24.setSpacingAfter(20);
		table2411criteria24.setSpacingBefore(20);
		document.add(table2411criteria24);
		
//		if(criteria2Record.getCriteria24Qn()!=null)
//		{
//		Paragraph paragraph6criteria24 = new Paragraph(
//				criteria2Record != null
//								? criteria2Record.getCriteria24Qn().get(0).getResponse241()
//								: "", font5);
//		document.add(paragraph6criteria24);
//		}
		
		
if(criteria2Record.getYearTable2411() !=null)
{
		Table table2411 = new Table(criteria2Record.getYearTable2411().size());

		table2411.setPadding(5);
		table2411.setWidth(100f);
//		table2411.addCell("year");
		for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
			Cell cell1criteria24110= new Cell (criteria2Record.getYearTable2411().get(i).getInput2411y());
			cell1criteria24110.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2411.addCell(cell1criteria24110);
//			table2411.addCell();
		}
//		table2411.addCell("number");
		for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
			Cell cell2criteria24110= new Cell (criteria2Record.getYearTable2411().get(i).getInput2411v());
			cell2criteria24110.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2411.addCell(cell2criteria24110);
			
		}

		document.add(table2411);		
}





if(criteria2Record.getYearTable24112() !=null)
{
Table table24112 = new Table(criteria2Record.getYearTable24112().size());

table24112.setPadding(5);
table24112.setWidth(100f);
//table24112.addCell("year");
for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
Cell cell1criteria2421= new Cell (criteria2Record.getYearTable2421().get(i).getInput2421y());
cell1criteria2421.setHorizontalAlignment(Element.ALIGN_CENTER);
table24112.addCell(cell1criteria2421);
//table24112.addCell(criteria2Record.getYearTable2421().get(i).getInput2421y());
}
//table24112.addCell("number");
for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
Cell cell2criteria2421= new Cell (criteria2Record.getYearTable2421().get(i).getInput2421v());
cell2criteria2421.setHorizontalAlignment(Element.ALIGN_CENTER);
table24112.addCell(cell2criteria2421);
//table24112.addCell();
}

document.add(table24112);


}		
		
		
		
		
		
		

		PdfPTable table14 = new PdfPTable(2);

		table14.setWidthPercentage(100f);
//		table14.setWidths(new int[] { 3, 3 });
//		table14.setSpacingBefore(5);

		PdfPCell cell43 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell43.setHorizontalAlignment(Element.ALIGN_CENTER);
		table14.addCell(cell43);

		PdfPCell cell44 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
		table14.addCell(cell44);

		PdfPCell cell45 = new PdfPCell(
				new Paragraph("\r\nUpload supporting document\r\n\r\n",font5));
		cell45.setHorizontalAlignment(Element.ALIGN_CENTER);
		table14.addCell(cell45);

		PdfPCell cell46 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
		table14.addCell(cell46);

		table14.setSpacingAfter(20);
		table14.setSpacingBefore(20);
		

		document.add(table14);
		
		//242

		PdfPTable table242Cr24 = new PdfPTable(1);
		table242Cr24.setWidthPercentage(100f);

		PdfPCell cell1242Cr2 = new PdfPCell(new Paragraph(
				"2.4.2  percentage of full time teachers with Ph. D. / D.M. / M.Ch. / D.N.B Superspeciality / D.Sc. / D.Litt. during the last five years (consider only highest degree for count)"
						+ "\r\n\r\n"  + "Response: "
						+(criteria2Record != null
						? criteria2Record.getCriteria24Qn().get(0).getResponse242()
						: "")+"\r\n\r\n",font4));
		table242Cr24.addCell(cell1242Cr2);
		table242Cr24.setSpacingAfter(20);
		table242Cr24.setSpacingBefore(20);
		document.add(table242Cr24);
		
		
//		if(criteria2Record.getCriteria24Qn() !=null)
//		{
//		
//		Paragraph paragraph6criteria27 = new Paragraph( (criteria2Record != null
//								? criteria2Record.getCriteria24Qn().get(0).getResponse242()
//								: ""));
//		document.add(paragraph6criteria27);
//		}
		
		
		PdfPTable table2421Cr24 = new PdfPTable(1);
		table2421Cr24.setWidthPercentage(100f);

		PdfPCell cell12421Cr2 = new PdfPCell(new Paragraph("2.4.2.1: Number of full time teachers with NET/SET/SLET/Ph. D. / D.M. / M.Ch. /"
				+ " D.N.B Superspeciality / D.Sc. / D.Litt. year wise during the last five years\r\n\r\n",font4));
		table2421Cr24.addCell(cell12421Cr2);
		table2421Cr24.setSpacingAfter(20);
		table2421Cr24.setSpacingBefore(20);
		document.add(table2421Cr24);
		

		
		
		
		PdfPTable table24210Cr24 = new PdfPTable(1);
		table24210Cr24.setWidthPercentage(100f);

		PdfPCell cell124210Cr2 = new PdfPCell(new Paragraph("B: Total number of full time teachers year wise during last five years\r\n\r\n",font4));
		
		table24210Cr24.addCell(cell124210Cr2);
		
		
		
		 Paragraph paragraph1=new Paragraph("\r\n\r\n");
		 document.add(paragraph1);
		 
		if(criteria2Record.getYearTable2421() !=null)
		{
		Table table2421 = new Table(criteria2Record.getYearTable2421().size());

		table2421.setPadding(5);
		table2421.setWidth(100f);
		
		for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
			Cell cell1criteria2421 = new Cell (criteria2Record.getYearTable2421().get(i).getInput2421y());
			cell1criteria2421.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2421.addCell(cell1criteria2421);
			
		}
	
		for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
			Cell cell2criteria2421 = new Cell (criteria2Record.getYearTable2421().get(i).getInput2421v());
			cell2criteria2421.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2421.addCell(cell2criteria2421);
			
		}

		document.add(table2421);
		
		}
		
		table24210Cr24.setSpacingAfter(20);
		table24210Cr24.setSpacingBefore(20);
		document.add(table24210Cr24);
		
		
		if(criteria2Record.getYearTable24212() !=null)
		{
		Table table24212 = new Table(criteria2Record.getYearTable24212().size());

		table24212.setPadding(5);
		table24212.setWidth(100f);
		
		for (int i = 0; i < criteria2Record.getYearTable24212().size(); i++) {
			Cell cell1criteria24212 = new Cell (criteria2Record.getYearTable24212().get(i).getInput24212y());
			cell1criteria24212.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24212.addCell(cell1criteria24212);
			
		}
	
		for (int i = 0; i < criteria2Record.getYearTable24212().size(); i++) {
			Cell cell2criteria24212 = new Cell (criteria2Record.getYearTable24212().get(i).getInput24212v());
			cell2criteria24212.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24212.addCell(cell2criteria24212);
			
		}

		document.add(table24212);
		
		}
		
		
		
		

		

		PdfPTable table21 = new PdfPTable(2);

		table21.setWidthPercentage(100f);
		
//		table21.setWidths(new int[] { 3, 3 });
//		table21.setSpacingBefore(5);

		PdfPCell cell61 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell61);

		PdfPCell cell62 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell62);

		PdfPCell cell63 = new PdfPCell(new Paragraph("\r\nInstitutional data in the prescribed format (template merged with Extended profile 2.1)\r\n\r\n",font5));
		cell63.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell63);

		PdfPCell cell64 = new PdfPCell(
				new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell64.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell64);

		PdfPCell cell65 = new PdfPCell(new Paragraph("\r\nUpload supporting document\r\n\r\n",font5));
		cell65.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell65);

		PdfPCell cell66 = new PdfPCell(
				new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
		table21.addCell(cell66);


		table21.setSpacingAfter(20);
		table21.setSpacingBefore(20);
		
		document.add(table21);

//2.5
		
		
		
		Paragraph paragraph7criteria2 = new Paragraph("2.5	Evaluation Process and Reforms\r\n\r\n", font2);

		paragraph7criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph7criteria2);

		PdfPTable table22 = new PdfPTable(1);
		table22.setWidthPercentage(100f);

		PdfPCell cell25Cr25 = new PdfPCell(new Paragraph(
				"2.5.1  Mechanism of internal assessment is transparent and robust in terms of frequency and mode"
						+ "\r\n\r\n" + "Response: "
						+(criteria2Record != null
						? criteria2Record.getCriteria25Qn().get(0).getResponse251()
						: "")+"\r\n\r\n",font4));
		
		table22.setSpacingAfter(20);
		table22.setSpacingBefore(20);
		
		document.add(table22);
		
//		if(criteria2Record.getCriteria25Qn() !=null)
//		{
//		Paragraph paragraph7criteria22 = new Paragraph( (criteria2Record != null
//								? criteria2Record.getCriteria25Qn().get(0).getResponse251()
//								: ""));
//		document.add(paragraph7criteria22);
//		}



		PdfPTable table24 = new PdfPTable(2);

		table24.setWidthPercentage(100f);
	//	table24.setWidths(new int[] { 3, 3 });
	//	table24.setSpacingBefore(20);

		PdfPCell cell69criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n",font4));
		cell69criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table24.addCell(cell69criteria2);

		PdfPCell cell70criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n",font4));
		cell70criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table24.addCell(cell70criteria2);

		PdfPCell cell71criteria2 = new PdfPCell(
				new Paragraph("\r\nAny additional information\r\n\r\n",font5));
		cell71criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table24.addCell(cell71criteria2);

		PdfPCell cell72criteria2 = new PdfPCell(
				new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell72criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table24.addCell(cell72criteria2);

		PdfPCell cell73criteria2 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n",font5));
		cell73criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table24.addCell(cell73criteria2);

		PdfPCell cell74criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell74criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table24.addCell(cell74criteria2);

		table24.setSpacingAfter(20);
		table24.setSpacingBefore(20);
		
		document.add(table24);

	//2.6
		
		
		Paragraph paragraph8criteria2 = new Paragraph("2.6 Student Performance and Learning Outcome\r\r\n\n", font2);

		paragraph8criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph8criteria2);

		PdfPTable table27 = new PdfPTable(1);
		table27.setWidthPercentage(100f);

		PdfPCell cell1criteria261 = new PdfPCell(new Paragraph(
				"2.6.1 Programme and course outcomes for all Programmes offered by the institution are stated and displayed on website and "
				+ "communicated to teachers and students.Mothertherisa has adequate measures to communicate the COs, both to the teachers and students well in time ahead of the beginning of the Course work, in the following manner:"
						+ "\r\n\r\n"+ "Response: "+(criteria2Record != null
							? criteria2Record.getCriteria26Ql().get(0).getResponse261()
								: "")+"\r\n\r\n",font4));
		table27.addCell(cell1criteria261);
		table27.setSpacingAfter(20);
		table27.setSpacingBefore(20);
		document.add(table27);
//	


		PdfPTable table28 = new PdfPTable(2);
      table28.setWidthPercentage(100f);
	//	table28.setWidths(new int[] { 3, 3 });
		table28.setSpacingBefore(5);

		PdfPCell cell79criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell79criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell79criteria2);

		PdfPCell cell80criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell80criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell80criteria2);

		PdfPCell cell81criteria2 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
		cell81criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell81criteria2);

		PdfPCell cell82criteria2 = new PdfPCell(
				new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell82criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell82criteria2);

		PdfPCell cell83criteria2 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n",font5));
		cell83criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell83criteria2);

		PdfPCell cell84criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() :"")+"\r\n\r\n",font5));
		cell84criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell84criteria2);
		
		PdfPCell cell830criteria2 = new PdfPCell(new Paragraph("\r\nUpload COs for all courses (exemplars from Glossary)\r\n\r\n",font5));
		cell830criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell830criteria2);

		PdfPCell cell840criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() :"")+"\r\n\r\n",font5));
		cell840criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table28.addCell(cell840criteria2);
		table28.setSpacingAfter(20);
		table28.setSpacingBefore(20);

		document.add(table28);

		
		
		PdfPTable table29 = new PdfPTable(1);
		table29.setWidthPercentage(100f);

		PdfPCell cell013 = new PdfPCell(new Paragraph(
				"2.6.2 Attainment of programme outcomes and course outcomes are evaluated by the institution." + "\r\n\r\n"
					 + "Response: "
						+ (criteria2Record != null
							? criteria2Record.getCriteria26Ql().get(0).getResponse262()
								: "")+"\r\n\r\n",font4
					));
		
		table29.addCell(cell013);
	
	
//		PdfPCell cell0013 = new PdfPCell(new Paragraph(
//				"2.6.2 Attainment of programme outcomes and course outcomes are evaluated by the institution." + "\r\n"
//						+ "" + "" + "Response:"
//						+  (criteria2Record != null
//							? criteria2Record.getCriteria26Ql().get(0).getInput261t1()
//								: "")
//					));
//		
//		table29.addCell(cell0013);
//		PdfPCell cell00013 = new PdfPCell(new Paragraph(
//				"2.6.2 Attainment of programme outcomes and course outcomes are evaluated by the institution." + "\r\n"
//						+ "" + "" + "Response:"
//						+  (criteria2Record != null
//							? criteria2Record.getCriteria26Ql().get(0).getInput261t1()
//								: "")
//					));
//		table29.addCell(cell00013);
		table29.setSpacingAfter(20);
		table29.setSpacingBefore(20);
		
		document.add(table29);
	

	
		
		
		
		
	
		PdfPTable table32 = new PdfPTable(2);

		table32.setWidthPercentage(100f);
		table32.setWidths(new int[] { 3, 3 });
		table32.setSpacingBefore(5);

		PdfPCell cell89criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell89criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell89criteria2);

		PdfPCell cell90criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell90criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell90criteria2);

		PdfPCell cell91criteria2 = new PdfPCell(new Paragraph(
				"\r\nUpload List of Programmes and number of students passed and appeared in the final year examination(Data Template)\r\n\r\n",font5));
		cell91criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell91criteria2);

		PdfPCell cell92criteria2 = new PdfPCell(
				new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell92criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell92criteria2);

		PdfPCell cell93criteria2 = new PdfPCell(new Paragraph("\r\nUpload any  the annual report\r\n\r\n",font5));
		cell93criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell93criteria2);

		PdfPCell cell94criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell94criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell94criteria2);
		PdfPCell cell930criteria2 = new PdfPCell(new Paragraph("\r\nPaste link for annual report\r\n\r\n",font5));
		cell930criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell930criteria2);

		PdfPCell cell940criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell940criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table32.addCell(cell940criteria2);
		table32.setSpacingAfter(20);
		table32.setSpacingBefore(20);
		
		document.add(table32);
		
		//2.7
		
		

		Paragraph paragraph9criteria2 = new Paragraph("2.7	Student Satisfaction Survey \r\n\r\n", font2);

		paragraph9criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph9criteria2);
		
		
		PdfPTable table33 = new PdfPTable(1);
		table33.setWidthPercentage(100f);

		
		
		PdfPCell cell1criteria271 = new PdfPCell(new Paragraph("2.7.1: Online student satisfaction survey regarding to teaching learning process.\r\n\r\n",font4));
		table33.addCell(cell1criteria271);
		table33.setSpacingAfter(20);
		table33.setSpacingBefore(20);
		document.add(table33);
    
		
		
		PdfPTable table34 = new PdfPTable(2);

		table34.setWidthPercentage(100f);
//		table34.setWidths(new int[] { 3, 3 });
//		table34.setSpacingBefore(5);

		PdfPCell cell95criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell95criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell95criteria2);

		PdfPCell cell96criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell96criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell96criteria2);

		PdfPCell cell97criteria2 = new PdfPCell(new Paragraph("\r\nUpload any additional information",font5));
		cell97criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell97criteria2);

		PdfPCell cell98criteria2 = new PdfPCell(
				new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell98criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell98criteria2);
		
		
		
		PdfPCell cell97criteria21 = new PdfPCell(new Paragraph("\r\nUpload database of all currently enrolled students",font5));
		cell97criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell97criteria21);

		PdfPCell cell98criteria21 = new PdfPCell(
				new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
		cell98criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
		table34.addCell(cell98criteria21);
		
		table34.setSpacingAfter(20);
		table34.setSpacingBefore(20);
		document.add(table34);}
  
  
  ////////////////////////////
  ///////////////////////////////////////3///////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////
  
	public void Criteria3(Document document,Criteria3_FieldInfo criteria3Fieldinfo ) {
		Paragraph paragraph1criteria3 = new Paragraph("Criterion 3 - Research, Innovations and Extension\r\n" + "\r\n",
				font1);
		paragraph1criteria3.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph1criteria3);
		
		Paragraph paragraph2criteria3 = new Paragraph("3.1 Resource Mobilization for Research\r\n", font2);
		paragraph1criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph2criteria3);
		
		// create table1
		PdfPTable table1criteria3 = new PdfPTable(2);
		PdfPTable table13criteria31 = new PdfPTable(1);
		PdfPTable table311criteria31 = new PdfPTable(1);

		table1criteria3.setWidthPercentage(100f);
		table13criteria31.setWidthPercentage(100f);
		table311criteria31.setWidthPercentage(100);

		PdfPCell cell1criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell1criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell2criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell2criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell3criteria3 = new PdfPCell(new Paragraph(
				"\r\nList of endowments / projects with details of grants\r\n\r\n",font5));
		cell3criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell4criteria3 = new PdfPCell(
				new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
		cell4criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell5criteria3 = new PdfPCell(new Paragraph("\r\nE-copies of the grant award letters for sponsoredresearch projects / endowments\r\n\r\n",font5));
		cell5criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell6criteria3 = new PdfPCell(
				new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
		cell6criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell7criteria3 = new PdfPCell(
				new Paragraph("\r\nAny additional information\r\n\r\n",font5));
		cell7criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell8criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() :"")+"\r\n\r\n",font5));
		cell8criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1criteria3.addCell(cell1criteria3);
		table1criteria3.addCell(cell2criteria3);
		table1criteria3.addCell(cell3criteria3);
		table1criteria3.addCell(cell4criteria3);
		table1criteria3.addCell(cell5criteria3);
		table1criteria3.addCell(cell6criteria3);
		table1criteria3.addCell(cell7criteria3);
		table1criteria3.addCell(cell8criteria3);
		table1criteria3.setSpacingAfter(20);
		table1criteria3.setSpacingBefore(20);
		
		

		PdfPCell paragraph21criteria3 = new PdfPCell(new Paragraph(
				"3.1.1: Grants received from Government and non-governmental agencies for research projects, endowments, Chairs in the institution during the last five years (INR in Lakhs)..\r\n\r\n"
						+ "Response: "
						+(criteria3Record != null
						? criteria3Record.getCriteria31Ql().get(0).getResponse311():"")+"\r\n\r\n",font4));
		
		table13criteria31.addCell(paragraph21criteria3);
		table13criteria31.setSpacingAfter(20);
		table13criteria31.setSpacingBefore(20);
		
		document.add(table13criteria31);
		document.add(table1criteria3);
//		PdfPCell paragraph22criteria3 = new PdfPCell(new Paragraph(criteria3Record != null
//						? criteria3Record.getCriteria31Ql().get(0).getResponse311()
//						: ""+"\r\n\r\n",font5));
//		table13criteria31.addCell(paragraph22criteria3);
				
		


		PdfPCell paragraph211criteria3 = new PdfPCell(new Paragraph (
				"3.1.1.1 Total Grants from Government and non-governmental agencies for research projects ,"
				+ "endowments, Chairs in the institution during the last five years (INR in Lakhs)"+"\r\n\r\n",font4));
		table311criteria31.addCell(paragraph211criteria3);
		table311criteria31.setSpacingAfter(20);
		table311criteria31.setSpacingBefore(20);
		
		document.add(table311criteria31);
		
		

		
		
		
		
		

//		
		//YEAR TABLE 3111
		
		
		if(criteria3Record.getAffiliatedYearTable3111().size()>0)
		{
		Table table3111criteria3 = new Table(criteria3Record.getAffiliatedYearTable3111().size());

		table3111criteria3.setPadding(5);
		table3111criteria3.setWidth(100f);

		for (int i = 0; i < criteria3Record.getAffiliatedYearTable3111().size(); i++) {
			Cell cell1criteria311 = new Cell (criteria3Record.getAffiliatedYearTable3111().get(i).getInput3111y());
			cell1criteria311.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3111criteria3.addCell(cell1criteria311);
			
		}
		for (int i = 0; i < criteria3Record.getAffiliatedYearTable3111().size(); i++) {
			Cell cell2criteria311 = new Cell (criteria3Record.getAffiliatedYearTable3111().get(i).getInput3111v());
			cell2criteria311.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3111criteria3.addCell(cell2criteria311);
			
		}

		document.add(table3111criteria3);
	

		
		}
			// create table 2////
		PdfPTable table2criteria3 = new PdfPTable(2);
		PdfPTable table23criteria31 = new PdfPTable(1);
		table2criteria3.setWidthPercentage(100f);
		table23criteria31.setWidthPercentage(100f);
		
		PdfPCell cell21criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell21criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell22criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell22criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell23criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
		cell23criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell24criteria3 = new PdfPCell(
				new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
		cell24criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell25criteria3 = new PdfPCell(
				new Paragraph("\r\nE-copies of the grant award letters for research projects sponsored by non-government\r\n\r\n",font5));
		cell25criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell26criteria3 = new PdfPCell(
				new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
		cell26criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table2criteria3.addCell(cell21criteria3);
		table2criteria3.addCell(cell22criteria3);
		table2criteria3.addCell(cell23criteria3);
		table2criteria3.addCell(cell24criteria3);
		table2criteria3.addCell(cell25criteria3);
		table2criteria3.addCell(cell26criteria3);
		table2criteria3.setSpacingAfter(20);
		table2criteria3.setSpacingBefore(20);
	     document.add(table2criteria3);
	     
	     // 3.2
	     
	     
	     Paragraph paragraph31criteria3 = new Paragraph("3.2: Resource Mobilization for Research\r\n\r\n",font2);
	     paragraph31criteria3.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paragraph31criteria3);
			
			PdfPCell paragraph32criteria3 = new PdfPCell(new Paragraph(
					"3.2.1 Institution has created an ecosystem for innovations and has initiatives for creation and"
					+ "transfer of knowledg\r\n\r\n"
							 + "Response: "
					+(criteria3Record != null
					? criteria3Record.getCriteria32Ql().get(0).getResponse321(): "")+"\r\n\r\n",font4));
			table23criteria31.addCell(paragraph32criteria3);
			
//			PdfPCell paragraph33criteria3 = new PdfPCell(new Paragraph(criteria3Record != null
//									? criteria3Record.getCriteria32Ql().get(0).getResponse321()
//									: "",font5));
//			table23criteria31.addCell(paragraph33criteria3);
			table23criteria31.setSpacingAfter(20);
			table23criteria31.setSpacingBefore(20);
			
			document.add(table23criteria31);
			
			PdfPTable table5criteria3 = new PdfPTable(2);
			PdfPTable table53criteria31 = new PdfPTable(1);
			PdfPTable table3221criteria31 = new PdfPTable(1);
			
	      table5criteria3.setWidthPercentage(100f);
	      table53criteria31.setWidthPercentage(100f);
	      table3221criteria31.setWidthPercentage(100f);
	      
			PdfPCell cell51criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell51criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell52criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell52criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell53criteria3 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell53criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell54criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(11).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell54criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell55criteria3 = new PdfPCell(
					new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
			cell55criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell56criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(12).getCriteria3FilePath() :"")+"\r\n\r\n",font5));
			cell56criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5criteria3.addCell(cell51criteria3);
			table5criteria3.addCell(cell52criteria3);
			table5criteria3.addCell(cell53criteria3);
			table5criteria3.addCell(cell54criteria3);
			table5criteria3.addCell(cell55criteria3);
			table5criteria3.addCell(cell56criteria3);
			table5criteria3.setSpacingAfter(20);
			table5criteria3.setSpacingBefore(20);
			
			document.add(table5criteria3);
			
			PdfPCell paragraph34criteria3 = new PdfPCell(new Paragraph(
					"3.2.2 Number of workshops/seminars conducted on Research Methodology, Intellectual Property\r\n"
							+ "Rights (IPR) and entrepreneurship during the last five years\r\n"
							 + "Response: "
							+(criteria3Record != null
							? criteria3Record.getCriteria32Qn().get(0).getResponse322(): "")+"\r\n\r\n",font4));
			
			table53criteria31.addCell(paragraph34criteria3);
			
			
//			Paragraph paragraph35criteria3 = new Paragraph(criteria3Record != null
//									? criteria3Record.getCriteria32Qn().get(0).getResponse322()
//									: "",font5);
//			table53criteria31.addCell(paragraph35criteria3);
			table53criteria31.setSpacingAfter(20);
			table53criteria31.setSpacingBefore(20);
			document.add(table53criteria31);
			
			
			
			
			PdfPCell paragraph3221criteria3 = new PdfPCell(new Paragraph(
					"3.2.2.1 Total number of workshops/seminars conducted on Research Methodology, Intellectual "
					+ "Property Rights (IPR) and entrepreneurship year-wise during last five years." + "\r\n\r\n",font4));
			
	//		paragraph3221criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			table3221criteria31.addCell(paragraph3221criteria3);
			
			document.add(table3221criteria31);
			
			
//			// year table 3221

			if (criteria3Record.getYearTable3221().size()>0) {
				Table table3221criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);

				table3221criteria3.setPadding(5);
				table3221criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
					Cell cell1criteria3221 = new Cell (criteria3Record.getYearTable3221().get(i).getInput3221y());
					cell1criteria3221.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3221criteria3.addCell(cell1criteria3221);
					

				}
				for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
					Cell cell2criteria3221 = new Cell (criteria3Record.getYearTable3221().get(i).getInput3221v());
					cell2criteria3221.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3221criteria3.addCell(cell2criteria3221);
					

				}

				document.add(table3221criteria3);
			}

			// create table 6////
			PdfPTable table6criteria3 = new PdfPTable(2);
			PdfPTable table63criteria31 = new PdfPTable(1);
	       table6criteria3.setWidthPercentage(100f);
	       table63criteria31.setWidthPercentage(100f);
			PdfPCell cell61criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell61criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell62criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell62criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell63criteria3 = new PdfPCell(
					new Paragraph("\r\nReport of the event\r\n\r\n",font5));
			cell63criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell64criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell64criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell65criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell65criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell66criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell66criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell67criteria3 = new PdfPCell(new Paragraph("\r\nLink for additional information\r\n\r\n",font5));
			cell67criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell68criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath():"")+"\r\n\r\n",font5));
			cell68criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table6criteria3.addCell(cell61criteria3);
			table6criteria3.addCell(cell62criteria3);
			table6criteria3.addCell(cell63criteria3);
			table6criteria3.addCell(cell64criteria3);
			table6criteria3.addCell(cell65criteria3);
			table6criteria3.addCell(cell66criteria3);
			table6criteria3.addCell(cell67criteria3);
			table6criteria3.addCell(cell68criteria3);
			table6criteria3.setSpacingAfter(20);
			table6criteria3.setSpacingBefore(20);
			
			document.add(table6criteria3);
			
			
			//  3.3
			
			
			Paragraph paragraph4criteria3 = new Paragraph("3.3	Research Publications and Awards\r\n\r\n", font2);
			paragraph4criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph4criteria3);
			
			
			
			PdfPCell cell1criteria331 = new PdfPCell(new Paragraph(
					"3.3.1: Number of research papers per teachers in the Journals notified on UGC website during the last five years\r\n\r\n"
			+ "Response: "
							+(criteria3Record != null
							? criteria3Record.getCriteria33Qn().get(0).getResponse331()
							: "")+"\r\n\r\n",font4));
			table63criteria31.addCell(cell1criteria331);
			
			
//			if( criteria3Record.getCriteria33Ql() !=null)
//			{
//			Paragraph paragraph42criteria3 = new Paragraph(criteria3Record != null
//									? criteria3Record.getCriteria33Qn().get(0).getResponse331()
//									: "",font5);
//			table63criteria31.addCell(paragraph42criteria3);
//			}
			table63criteria31.setSpacingAfter(20);
			table63criteria31.setSpacingBefore(20);
			
			document.add(table63criteria31);
			
//			Paragraph paragraph43criteria3 = new Paragraph("	Paragraph paragraph41criteria3 = new Paragraph(");
//			document.add(paragraph43criteria3);
			
			if (criteria3Record.getAffiliatedYearTable3311().size()>0) {
				Table table3321criteria3 = new Table(criteria3Record.getAffiliatedYearTable3311().size(), 2);

				table3321criteria3.setPadding(5);
				table3321criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getAffiliatedYearTable3311().size(); i++) {
					Cell cell1criteria3311 = new Cell (criteria3Record.getAffiliatedYearTable3311().get(i).getInput3311y());
					cell1criteria3311.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3321criteria3.addCell(cell1criteria3311);
				//	table3321criteria3.addCell(criteria3Record.getAffiliatedYearTable3311().get(i).getInput3311y());

				}
				for (int i = 0; i < criteria3Record.getAffiliatedYearTable3311().size(); i++) {
					Cell cell2criteria3311 = new Cell (criteria3Record.getAffiliatedYearTable3311().get(i).getInput3311v());
					cell2criteria3311.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3321criteria3.addCell(cell2criteria3311);
				//	table3321criteria3.addCell(criteria3Record.getAffiliatedYearTable3311().get(i).getInput3311v());

				}

				document.add(table3321criteria3);
			}
			
			

			PdfPTable table9criteria3 = new PdfPTable(2);
			PdfPTable table91criteria31 = new PdfPTable(1);
	        table9criteria3.setWidthPercentage(100f);
			table91criteria31.setWidthPercentage(100f);
			
			PdfPCell cell91criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell91criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell92criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell92criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell93criteria3 = new PdfPCell(new Paragraph("\r\nList of research papers by title, author, department,\r\n"
					+ "name and year of publicatio\r\n\r\n",font5));
			cell93criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell94criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell94criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell95criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell95criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell96criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() :"")+"\r\n\r\n",font5));
			cell96criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria3.addCell(cell91criteria3);
			table9criteria3.addCell(cell92criteria3);
			table9criteria3.addCell(cell93criteria3);
			table9criteria3.addCell(cell94criteria3);
			table9criteria3.addCell(cell95criteria3);
			table9criteria3.addCell(cell96criteria3);
			table9criteria3.setSpacingAfter(20);
			table9criteria3.setSpacingBefore(20);
			
			
			document.add(table9criteria3);
			
			
						/// create table 9 ////
			PdfPTable table332criteria33 = new PdfPTable(1);
			table332criteria33.setWidthPercentage(100);
			
			PdfPCell paragraph411criteria3 = new PdfPCell(new Paragraph(
					"3.3.2  Number of research papers per teachers in the Journals notified on UGC website during the last five years \r\n\r\n"
			+ "Response: "
			+	(criteria3Record != null
			? criteria3Record.getCriteria33Qn().get(0).getResponse332(): "")+"\r\n\r\n",font4));
			table332criteria33.addCell(paragraph411criteria3);
			document.add(table332criteria33);
			
			
//			if( criteria3Record.getCriteria33Qn() !=null)
//			{
//			Paragraph paragraph421criteria3 = new Paragraph(criteria3Record != null
//									? criteria3Record.getCriteria33Qn().get(0).getResponse332()
//									: "", font5);
//			document.add(paragraph421criteria3);
//			
//			}
			
//			Paragraph paragraph431criteria3 = new Paragraph("	Paragraph paragraph41criteria3 = new Paragraph(");
//			document.add(paragraph431criteria3);
			
			if (criteria3Record.getYearTable3221().size()>0) {
				Table table3321criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);

				table3321criteria3.setPadding(5);
				table3321criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3321().size(); i++) {
					Cell cell1criteria3321 = new Cell (criteria3Record.getYearTable3321().get(i).getInput3321y());
					cell1criteria3321.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3321criteria3.addCell(cell1criteria3321);
				//	table3321criteria3.addCell(criteria3Record.getYearTable3321().get(i).getInput3321y());

				}
				for (int i = 0; i < criteria3Record.getYearTable3321().size(); i++) {
					Cell cell2criteria3321 = new Cell (criteria3Record.getYearTable3321().get(i).getInput3321v());
					cell2criteria3321.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3321criteria3.addCell(cell2criteria3321);
				//	table3321criteria3.addCell(criteria3Record.getYearTable3321().get(i).getInput3321v());

				}

				document.add(table3321criteria3);
			}

			PdfPTable table91criteria3 = new PdfPTable(2);
			PdfPTable table911criteria31 = new PdfPTable(1);
	        table91criteria3.setWidthPercentage(100f);
			table911criteria31.setWidthPercentage(100f);
			
			PdfPCell cell911criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell911criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell921criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell921criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell931criteria3 = new PdfPCell(new Paragraph("\r\nList of research papers by title, author, department,\r\n"
					+ "name and year of publicatio\r\n\r\n",font5));
			cell931criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell941criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell941criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell951criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell951criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell961criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() :"")+"\r\n\r\n",font5));
			cell961criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table91criteria3.addCell(cell911criteria3);
			table91criteria3.addCell(cell921criteria3);
			table91criteria3.addCell(cell951criteria3);
			table91criteria3.addCell(cell961criteria3);
			table91criteria3.addCell(cell931criteria3);
			table91criteria3.addCell(cell941criteria3);
			table91criteria3.setSpacingAfter(20);
			table91criteria3.setSpacingBefore(20);
			
			document.add(table91criteria3);
			
			
			// 3.4
			

			Paragraph paragraph5criteria3 = new Paragraph("3.4 Extension Activitie\r\n\r\n", font2);
			paragraph5criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph5criteria3);
			// create table 10 ///
			PdfPTable table10criteria3 = new PdfPTable(2);
			PdfPTable table101criteria31 = new PdfPTable(1);
			table10criteria3.setWidthPercentage(100f);
			table101criteria31.setWidthPercentage(100f);
			
			PdfPCell cell101criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell101criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell102criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell102criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell103criteria3 = new PdfPCell(new Paragraph("\r\nUpload any additional information \r\n\r\n",font5));
			cell103criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell104criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell104criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell105criteria3 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
			cell105criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell106criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell106criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table10criteria3.addCell(cell101criteria3);
			table10criteria3.addCell(cell102criteria3);
			table10criteria3.addCell(cell103criteria3);
			table10criteria3.addCell(cell104criteria3);
			table10criteria3.addCell(cell105criteria3);
			table10criteria3.addCell(cell106criteria3);
			PdfPCell cell341criteria3 = new PdfPCell(new Paragraph(
					"3.4.1 Extension activities are carried out in the neighborhood community, sensitizing students to\r\n"
					+ "social issues, for their holistic development, and impact thereof during the last five years"
							+ "\r\n\r\n" + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Ql().get(0).getResponse341()
									: "")+"\r\n\r\n",font4));
			
//			PdfPCell cell3401criteria3 = new PdfPCell(new Paragraph(
//					 (criteria3Record != null
//									? criteria3Record.getCriteria34Ql().get(0).getInput341t1()
//									: ""),
//					font2));
			
			
			table101criteria31.addCell(cell341criteria3);
		//	table101criteria31.addCell(cell3401criteria3);
		//	table101criteria31.addCell(table10criteria3);
			// document.add(cell341criteria3);
			table10criteria3.setSpacingBefore(20f);
			table10criteria3.setSpacingAfter(20f);
			document.add(table101criteria31);
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
					"\r\nNumber of awards for extension activities in last 5\r\n"
					+ "yea\r\n\r\n",font5));
			cell113criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell114criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell114criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell115criteria3 = new PdfPCell(new Paragraph("\r\nE-copy of the award letter\r\n\r\n",font5));
			cell115criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell116criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell116criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell117criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell117criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell118criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell118criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table11criteria3.addCell(cell111criteria3);
			table11criteria3.addCell(cell112criteria3);
			table11criteria3.addCell(cell113criteria3);
			table11criteria3.addCell(cell114criteria3);
			table11criteria3.addCell(cell115criteria3);
			table11criteria3.addCell(cell116criteria3);
			table11criteria3.addCell(cell117criteria3);
			table11criteria3.addCell(cell118criteria3);
			
			
			PdfPTable table342criteria31 = new PdfPTable(1);
			PdfPTable table3421criteria31 = new PdfPTable(1);
			PdfPTable table34222criteria31 = new PdfPTable(1);
			
			table342criteria31.setWidthPercentage(100);
			table3421criteria31.setWidthPercentage(100);
			table34222criteria31.setWidthPercentage(100);
			
			
			PdfPCell cell342criteria3 = new PdfPCell(new Paragraph(
					"3.4.2 Number of awards and recognitions received for extension activities from government/\r\n"
					+ "government recognised bodies during the last five years"
							+ "\r\n\r\n" + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getResponse342()
									: "")+"\r\n\r\n",font4));
			
//			PdfPCell cell3420criteria3 = new PdfPCell(new Paragraph(
//					 (criteria3Record != null
//									? criteria3Record.getCriteria34Qn().get(0).getInput342t1()
//									: ""),
//					font2));

			table342criteria31.addCell(cell342criteria3);
		//	table111criteria31.addCell(cell3420criteria3);
			// document.add(cell342criteria3);
			PdfPCell cell3421criteria3 = new PdfPCell(
					new Paragraph("3.4.2.1Total number of awards and recognition received for extension activities from Government/"
							+ "Government recognised bodies year-wise during the last five years" + "\r\n\r\n", font4));
			
			table3421criteria31.addCell(cell3421criteria3);
			
			PdfPCell cell3422criteria3 = new PdfPCell(new Paragraph(
					"3.4.2.2 Number of teachers recognized as guides during the last five years" + "\r\n\r\n" + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getInput3422t1()
									: "")+"\r\n\r\n",font4));
			
			table34222criteria31.addCell(cell3422criteria3);
	//		table111criteria31.addCell(table11criteria3);

			// document.add(cell3421criteria3);
			// document.add(cell3422criteria3);
			table111criteria31.setSpacingAfter(20f);
			table111criteria31.setSpacingAfter(20f);

			table342criteria31.setSpacingAfter(20);
			table342criteria31.setSpacingBefore(20);
			
			table3421criteria31.setSpacingAfter(20);
			table3421criteria31.setSpacingBefore(20);
			
			table34222criteria31.setSpacingAfter(20);
			table34222criteria31.setSpacingBefore(20);
			
			
			document.add(table342criteria31);
			document.add(table3421criteria31);
			document.add(table34222criteria31);
			document.add(table11criteria3);
			
			
			
			
			/// create table 12 /////
			PdfPTable table12criteria3 = new PdfPTable(2);
			PdfPTable table123criteria31 = new PdfPTable(1);
	        table12criteria3.setWidthPercentage(100f);
	        table123criteria31.setWidthPercentage(100f);
	        
	        
	        
			PdfPCell cell121criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell121criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell122criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell122criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell123criteria3 = new PdfPCell(new Paragraph(
					"\r\nReports of the event organized\r\n\r\n",
					font5));
			cell123criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell124criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell124criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell125criteria3 = new PdfPCell(new Paragraph("\r\nNumber of extension and outreach Programmes\r\n"
					+ "conducted with industry, community etc for the last\r\n"
					+ "five years\r\n\r\n", font5));
			cell125criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell126criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() :"")+"\r\n\r\n",font5));
			cell126criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell127criteria3 = new PdfPCell(new Paragraph("\r\nNumber of extension and outreach Programmes\r\n"
					+ "conducted with industry, community etc for the last\r\n"
					+ "five years\r\n\r\n", font5));
			cell127criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell128criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() :"")+"\r\n\r\n",font5));
			cell128criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
		
			
			table12criteria3.addCell(cell121criteria3);
			table12criteria3.addCell(cell122criteria3);
			table12criteria3.addCell(cell123criteria3);
			table12criteria3.addCell(cell124criteria3);
			table12criteria3.addCell(cell125criteria3);
			table12criteria3.addCell(cell126criteria3);
			table12criteria3.addCell(cell127criteria3);
			table12criteria3.addCell(cell128criteria3);
			
			PdfPCell cell343criteria3 = new PdfPCell(new Paragraph(
					"3.4.3 Number of extension and outreach programs conducted by the institution through NSS/NCC,\r\n"
					+ "Government and Government recognised bodies during the last five years\r\n"
							+ "\r\n" + "Response: "
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getResponse343()
									: "")+"\r\n\r\n",font4));
			

//			PdfPCell cell3430criteria3 = new PdfPCell(new Paragraph(
//					(criteria3Record != null
//									? criteria3Record.getCriteria34Qn().get(0).getInput343t1()
//									: ""),
//					font2));
//			
			
			PdfPCell cell3431criteria3 = new PdfPCell(new Paragraph(
					"3.4.3.1 Number of extension and outreached Programmes conducted in collaboration with industry,\r\n"
					+ "community and Non- Government Organizations through NSS/ NCC/ Red Cross/ YRC etc., yearwise during the last\r\n\r\n"
							+ "",font4));
			table123criteria31.addCell(cell343criteria3);
	//		table123criteria31.addCell(cell3430criteria3);
			table123criteria31.addCell(cell3431criteria3);
		//	table123criteria31.addCell(table12criteria3);

			// document.add(cell343criteria3);
			// document.add(cell3431criteria3);
			table123criteria31.setSpacingBefore(20f);
			table123criteria31.setSpacingAfter(20f);

			document.add(table123criteria31);
			
			/// create table 3431 ////


			if (criteria3Record.getYearTable3431().size()>0) {
				Table table3431criteria3 = new Table(criteria3Record.getYearTable3431().size(), 2);

				table3431criteria3.setPadding(5);
				table3431criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3431().size(); i++) {
					Cell cell1criteria3431 = new Cell (criteria3Record.getYearTable3431().get(i).getInput3431y());
					cell1criteria3431.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3431criteria3.addCell(cell1criteria3431);

				}
				for (int i = 0; i < criteria3Record.getYearTable3431().size(); i++) {
					Cell cell2criteria3431 = new Cell (criteria3Record.getYearTable3431().get(i).getInput3431v());
					cell2criteria3431.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3431criteria3.addCell(cell2criteria3431);
					

				}

				document.add(table3431criteria3);
			}
			
			table12criteria3.setSpacingAfter(20);
			table12criteria3.setSpacingBefore(20);
			document.add(table12criteria3);
			

			/// create table 13 //
			PdfPTable table13criteria3 = new PdfPTable(2);
			PdfPTable table131criteria31 = new PdfPTable(1);
			PdfPTable table3441criteria31 = new PdfPTable(1);
			

			table13criteria3.setWidthPercentage(100f);
			table131criteria31.setWidthPercentage(100f);
			table3441criteria31.setWidthPercentage(100);

			PdfPCell cell131criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell131criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell132criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell132criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell133criteria3 = new PdfPCell(
					new Paragraph("\r\nReport of the event\r\n\r\n",font5));
			cell133criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell134criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell134criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell135criteria3 = new PdfPCell(new Paragraph("\r\nAverage percentage of students participating in\r\n"
					+ "extension activities with Govt or NGO etc\r\n\r\n",font5));
			cell135criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell136criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell136criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell137criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"
					+ "extension activities with Govt or NGO etc\r\n\r\n",font5));
			cell137criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell138criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell138criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table13criteria3.addCell(cell131criteria3);
			table13criteria3.addCell(cell132criteria3);
			table13criteria3.addCell(cell133criteria3);
			table13criteria3.addCell(cell134criteria3);
			table13criteria3.addCell(cell135criteria3);
			table13criteria3.addCell(cell136criteria3);
			table13criteria3.addCell(cell137criteria3);
			table13criteria3.addCell(cell138criteria3);
			
			PdfPCell cell344criteria3 = new PdfPCell(new Paragraph(
					"3.4.4 Average percentage of students participating in extension activities at 3.4.3. above during last\r\n"
					+ "five year\r\n"
							+ "\r\n" + "Response:"
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getResponse344()
									: "")+"\r\n\r\n",font4));
			
			table131criteria31.addCell(cell344criteria3);
			
			PdfPCell cell3441criteria3 = new PdfPCell(new Paragraph(
					"3.4.4.1 Total number of Students participating in extension activities conducted in collaboration\r\n"
					+ "with industry, community and Non- Government Organizations such as Swachh Bharat, AIDs\r\n"
					+ "awareness, Gender issue etc. year-wise during last five year"
							+ "\r\n\r\n\r\n",font4));
			
			table3441criteria31.addCell(cell3441criteria3);
			
			
		//	table131criteria31.addCell(cell3441criteria3);
		//	table131criteria31.addCell(table13criteria3);

			// document.add(cell344criteria3);
			// document.add(cell3441criteria3);
			table131criteria31.setSpacingBefore(20f);
			table131criteria31.setSpacingAfter(20f);
			
			table3441criteria31.setSpacingBefore(20f);
			table3441criteria31.setSpacingAfter(20f);

			document.add(table131criteria31);
			document.add(table3441criteria31);
			document.add(table13criteria3);
			// create table 3441 //

			if (criteria3Record.getYearTable3441().size()>0) {
				Table table3441criteria3 = new Table(criteria3Record.getYearTable3441().size(), 2);

				table3441criteria3.setPadding(5);
				table3441criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
					Cell cell1criteria3441 = new Cell (criteria3Record.getYearTable3441().get(i).getInput3441y());
					cell1criteria3441.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3441criteria3.addCell(cell1criteria3441);
					

				}
				for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
					Cell cell2criteria3441 = new Cell (criteria3Record.getYearTable3441().get(i).getInput3441v());
					cell2criteria3441.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3441criteria3.addCell(cell2criteria3441);
					

				}

				document.add(table3441criteria3);
			}

			// create table 14 //
			PdfPTable table14criteria3 = new PdfPTable(2);
			PdfPTable table141criteria31 = new PdfPTable(1);

			table14criteria3.setWidthPercentage(100f);
			table141criteria31.setWidthPercentage(100f);

			PdfPCell cell141criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell141criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell142criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell142criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell143criteria3 = new PdfPCell(
					new Paragraph("\r\nBibliometrics of the publications during the last five years\r\n\r\n",font5));
			cell143criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell144criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell144criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table14criteria3.addCell(cell141criteria3);
			table14criteria3.addCell(cell142criteria3);
			table14criteria3.addCell(cell143criteria3);
			table14criteria3.addCell(cell144criteria3);

			PdfPCell cell345criteria3 = new PdfPCell(new Paragraph(
					"3.4.5 Bibliometrics of the publications during the last five years based on average citation index in Scopus/ Web of Science or PubMed"
							+ "\r\n\r\n" + "Response: "
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getResponse345()
									: "")+"\r\n\r\n",font4));
			
			table141criteria31.addCell(cell345criteria3);
		//	table141criteria31.addCell(table14criteria3);
			table141criteria31.setSpacingBefore(20f);
			table141criteria31.setSpacingAfter(20f);
			document.add(table141criteria31);
			document.add(table14criteria3);
			
			
			
			
			// create table 15 //
			PdfPTable table15criteria3 = new PdfPTable(2);
			PdfPTable table153criteria31 = new PdfPTable(1);

			table15criteria3.setWidthPercentage(100f);
			table153criteria31.setWidthPercentage(100f);

			PdfPCell cell151criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell151criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell152criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell152criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell153criteria3 = new PdfPCell(new Paragraph(
					"\r\nBibiliometrics of publications based on Scopus/ Web of Science - h-index of the Institution\r\n\r\n",font5));
			cell153criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell154criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell154criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table15criteria3.addCell(cell151criteria3);
			table15criteria3.addCell(cell152criteria3);
			table15criteria3.addCell(cell153criteria3);
			table15criteria3.addCell(cell154criteria3);
			PdfPCell cell346criteria3 = new PdfPCell(new Paragraph(
					"3.4.6 Bibliometrics of the publications during the last five years based on Scopus/ Web of Science - h- index of the Institution\r\n"
							+ "\r\n" + "Response: "
							+ (criteria3Record != null
									? criteria3Record.getCriteria34Qn().get(0).getResponse346()
									: "")+"\r\n\r\n",font4));
			
			table153criteria31.addCell(cell346criteria3);
		//	table153criteria31.addCell(table15criteria3);

			// document.add(cell346criteria3);
			table153criteria31.setSpacingBefore(20f);
			table153criteria31.setSpacingAfter(20f);
			
			table15criteria3.setSpacingBefore(20f);
			table15criteria3.setSpacingAfter(20f);
			
			document.add(table153criteria31);
			document.add(table15criteria3);

			
	     //3.5
			

			Paragraph paragraph6criteria3 = new Paragraph("3.5	 Collaboration\r\n", font2);
			paragraph6criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph6criteria3);

			PdfPTable table351criteria3 = new PdfPTable(1);
			PdfPTable table3511criteria31 = new PdfPTable(1);
			
			table351criteria3.setWidthPercentage(100f);
			table3511criteria31.setWidthPercentage(100f);
			
			
			PdfPCell cell351criteria3 = new PdfPCell(new Paragraph("3.5.1: Number of extension and outreach programs conducted by the institution through NSS/NCC,"
					+ " Government and Government recognised bodies during the last five years\r\n\r\n "
					+"Response: "
					+(criteria3Record != null
					? criteria3Record.getCriteria35Qn().get(0).getResponse351():"")+"\r\n\r\n",font4));		
			table351criteria3.addCell(cell351criteria3);
			table351criteria3.setSpacingAfter(20);
			table351criteria3.setSpacingBefore(20);
			
			document.add(table351criteria3);
			
//			Paragraph paragraph613criteria3 = new Paragraph
//					(criteria3Record != null
//									? criteria3Record.getCriteria35Qn().get(0).getResponse351()
//									: "", font5);
//			document.add(paragraph613criteria3);
			
			
							
			PdfPCell cell3511criteria3 = new PdfPCell(new Paragraph("3.5.1.1: Number of extension and outreach programs conducted by the institution through NSS/NCC, "
					+ "Government and Government recognised bodies during the last five years"+"\r\n\r\n",font4));
			table3511criteria31.addCell(cell3511criteria3);
			table3511criteria31.setSpacingAfter(20);
			table3511criteria31.setSpacingBefore(20);
			document.add(table3511criteria31);
			
							
							
							
							
							
							
							
							

			if (criteria3Record.getYearTable3521().size()>0) {
				Table table3521criteria3 = new Table(criteria3Record.getYearTable3521().size(), 2);

				table3521criteria3.setPadding(5);
				table3521criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3521().size(); i++) {
					Cell cell1criteria3521 = new Cell (criteria3Record.getYearTable3521().get(i).getInput3521y());
					cell1criteria3521.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3521criteria3.addCell(cell1criteria3521);
					

				}
				for (int i = 0; i < criteria3Record.getYearTable3521().size(); i++) {
					Cell cell2criteria3521 = new Cell (criteria3Record.getYearTable3521().get(i).getInput3521v());
					cell2criteria3521.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3521criteria3.addCell(cell2criteria3521);
					

				}
			

				document.add(table3521criteria3);
				
			}
			
			
			
			
			
			PdfPTable table17criteria3 = new PdfPTable(2);
			PdfPTable table173criteria31 = new PdfPTable(1);

			table17criteria3.setWidthPercentage(100f);
			table173criteria31.setWidthPercentage(100f);

			PdfPCell cell171criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell171criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell172criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell172criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell173criteria3 = new PdfPCell(
					new Paragraph("\r\nReports of the event organized\r\n\r\n",font5));
			cell173criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell174criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell174criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell175criteria3 = new PdfPCell(
					new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell175criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell176criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell176criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell177criteria3 = new PdfPCell(new Paragraph(
					"\r\nNumber of extension and outreach Programmes conducted with industry, community etc for the last five years\r\n\r\n",font5));
			cell177criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell178criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell178criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table17criteria3.addCell(cell171criteria3);
			table17criteria3.addCell(cell172criteria3);
			table17criteria3.addCell(cell173criteria3);
			table17criteria3.addCell(cell174criteria3);
			table17criteria3.addCell(cell175criteria3);
			table17criteria3.addCell(cell176criteria3);
			table17criteria3.addCell(cell177criteria3);
			table17criteria3.addCell(cell178criteria3);
			table17criteria3.setSpacingAfter(20);
			table17criteria3.setSpacingBefore(20);
			
             document.add(table17criteria3);
			
			
			//3.6
             Paragraph paragraph7criteria3 = new Paragraph("3.6	Extension Activities\r\n\r\n", font2);
 			paragraph7criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
 			document.add(paragraph7criteria3);
 			// create table 18 //

 			
 			PdfPTable table361criteria3 = new PdfPTable(1);	
 			table361criteria3.setWidthPercentage(100);
 			
 			PdfPCell cell361criteria3 = new PdfPCell(new Paragraph("3.6.1: Extension activities are carried out in the neighbourhood community, sensitising students to social issues, "
 					+ "for their holistic development, and impact thereof during the last five years"
 					+"Response: "
 					+(criteria3Record != null
 					? criteria3Record.getCriteria36Ql().get(0).getResponse361():"")+"\r\n\r\n",font4));
 			table361criteria3.addCell(cell361criteria3);
 			table361criteria3.setSpacingAfter(20);
 			table361criteria3.setSpacingBefore(20);
 			
 			document.add(table361criteria3);
 			
 			
// 			Paragraph paragraph71113criteria3 = new Paragraph((criteria3Record != null
// 					? criteria3Record.getCriteria36Ql().get(0).getResponse361():""));
// 			document.add(paragraph71113criteria3);
 			
 		//	Paragraph paragraph71142criteria3 = new Paragraph("\r\n");
 			
 		//	document.add(paragraph71142criteria3);

 			PdfPTable table19121criteria3 = new PdfPTable(2);
 			PdfPTable table1902criteria3 = new PdfPTable(1);

 			table19121criteria3.setWidthPercentage(100f);
 			table1902criteria3.setWidthPercentage(100f);

 			PdfPCell cell19112criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
 			cell19112criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19212criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
 			cell19212criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19312criteria3 = new PdfPCell(
 					new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
 			cell19312criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19412criteria3 = new PdfPCell(
 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
 			cell19412criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19512criteria3 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
 			cell19512criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19612criteria3 = new PdfPCell(
 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
 			cell19612criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			table19121criteria3.addCell(cell19112criteria3);
 			table19121criteria3.addCell(cell19212criteria3);
 			table19121criteria3.addCell(cell19312criteria3);
 			table19121criteria3.addCell(cell19412criteria3);
 			table19121criteria3.addCell(cell19512criteria3);
 			table19121criteria3.addCell(cell19612criteria3);
 			table19121criteria3.setSpacingAfter(20);
 			table19121criteria3.setSpacingBefore(20);
 			
 			document.add(table19121criteria3);
 			
 			
 			
 			
 			
 		
 			
 			PdfPTable table362criteria3 = new PdfPTable(1);	
 			table362criteria3.setWidthPercentage(100);
 			
 			PdfPCell cell362criteria3 = new PdfPCell(new Paragraph(
 					"3.6.2: Number of awards and recognition received by the Institution, its teachers and students for extension activities from "
 					+ "Government / Government recognised bodies during last five years\r\n\r\n" + "Response: "
 							+(criteria3Record != null
								? criteria3Record.getCriteria36Qn().get(0).getResponse362()
								: "")+"\r\n\r\n",font4));
 			table362criteria3.addCell(cell362criteria3);
 			table362criteria3.setSpacingAfter(20);
 			table362criteria3.setSpacingBefore(20);
 			
 			document.add(table362criteria3);
 			
// 			if(criteria3Record.getCriteria36Qn().size()>0)
// 			{
// 			Paragraph paragraph7212criteria3 = new Paragraph(criteria3Record != null
// 									? criteria3Record.getCriteria36Qn().get(0).getResponse362()
// 									: "", font5);
// 			document.add(paragraph7212criteria3);
// 			}
 			
 			
 			PdfPTable table3621criteria3 = new PdfPTable(1);	
 			table3621criteria3.setWidthPercentage(100);
 			
 			PdfPCell cell3621criteria3 = new PdfPCell(new Paragraph(
 					"3.6.2.1: Total number of awards and recognition received for extension activities from Government/ Government recognised bodies year-wise during the last five years"
 							+"\r\n\r\n",font4));
 			table3621criteria3.addCell(cell3621criteria3);
 			table3621criteria3.setSpacingAfter(20);
 			table3621criteria3.setSpacingBefore(20);
 			
 			document.add(table3621criteria3);
 		//	document.add(paragraph71142criteria3);

// 			table191criteria3.addCell(cell362criteria3);
// 			table191criteria3.addCell(cell3621criteria3);
// 			// document.add(cell362criteria3);
// 			// document.add(cell3621criteria3);
// 			table191criteria3.setSpacingBefore(20f);
// 			table191criteria3.setSpacingAfter(20f);
// 			document.add(table191criteria3);

 			
 			
 			
 			
 			
 			

 			if (criteria3Record.getYearTable3621().size()>0) {
 				Table table3721criteria3 = new Table(criteria3Record.getYearTable3621().size(), 2);

 				table3721criteria3.setPadding(5);
 				table3721criteria3.setWidth(100f);

 				for (int i = 0; i < criteria3Record.getYearTable3621().size(); i++) {
 					Cell cell1criteria3721= new Cell (criteria3Record.getYearTable3621().get(i).getInput3621y());
 					cell1criteria3721.setHorizontalAlignment(Element.ALIGN_CENTER);
 					table3721criteria3.addCell(cell1criteria3721);
 					

 				}
 				for (int i = 0; i < criteria3Record.getYearTable3621().size(); i++) {
 					Cell cell2criteria3721= new Cell (criteria3Record.getYearTable3621().get(i).getInput3621v());
 					cell2criteria3721.setHorizontalAlignment(Element.ALIGN_CENTER);
 					table3721criteria3.addCell(cell2criteria3721);
 					

 				}

 				document.add(table3721criteria3);
 			}
 			
// 			document.add(paragraph71142criteria3);
// 			document.add(paragraph71142criteria3);
 			
 			PdfPTable table1911criteria3 = new PdfPTable(2);
 			PdfPTable table190criteria3 = new PdfPTable(1);

 			table1911criteria3.setWidthPercentage(100f);
 			table190criteria3.setWidthPercentage(100f);

 			PdfPCell cell1911criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
 			cell1911criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell1921criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
 			cell1921criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell1931criteria3 = new PdfPCell(
 					new Paragraph("\r\nAny additional information\r\n\r\n",font5));
 			cell1931criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell1941criteria3 = new PdfPCell(
 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
 			cell1941criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell1951criteria3 = new PdfPCell(new Paragraph("\r\nNumber of awards for extension activities in last 5 year\r\n\r\n",font5));
 			cell1951criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell1961criteria3 = new PdfPCell(
 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
 			cell1961criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell1971criteria3 = new PdfPCell(new Paragraph("\r\nE-copy of the award letters\r\n\r\n",font5));
 			cell1971criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell1981criteria3 = new PdfPCell(
 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
 			cell1981criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			table1911criteria3.addCell(cell1911criteria3);
 			table1911criteria3.addCell(cell1921criteria3);
 			table1911criteria3.addCell(cell1931criteria3);
 			table1911criteria3.addCell(cell1941criteria3);
 			table1911criteria3.addCell(cell1951criteria3);
 			table1911criteria3.addCell(cell1961criteria3);
 			table1911criteria3.addCell(cell1971criteria3);
 			table1911criteria3.addCell(cell1981criteria3);
 			table1911criteria3.setSpacingAfter(20);
 			table1911criteria3.setSpacingBefore(20);
 			
 			document.add(table1911criteria3);
 			
 			
 			
 			
 			/////////////////////
 			
 			PdfPTable table363criteria3 = new PdfPTable(1);	
 			table363criteria3.setWidthPercentage(100);
 			
 			PdfPCell cell363criteria3 = new PdfPCell(new Paragraph(
 					"3.6.3: Number of extension and outreach programs conducted by the institution through NSS/NCC, "
 					+ "Government and Government recognised bodies during the last five years" + "Response:"
 							+(criteria3Record != null
								? criteria3Record.getCriteria36Qn().get(0).getResponse363()
								: "")+"\r\n\r\n",font4));
 			table363criteria3.addCell(cell363criteria3);
 			table363criteria3.setSpacingAfter(20);
 			table363criteria3.setSpacingBefore(20);
 			
 			document.add(table363criteria3);
 			
// 			if(criteria3Record.getCriteria36Qn() !=null)
// 			{
// 			Paragraph paragraph721criteria3 = new Paragraph(criteria3Record != null
// 									? criteria3Record.getCriteria36Qn().get(0).getResponse363()
// 									: "", font5);
// 			document.add(paragraph721criteria3);
// 			}
 	
 			PdfPTable table3631criteria3 = new PdfPTable(1);	
 			table3631criteria3.setWidthPercentage(100);
 			
 			PdfPCell cell3631criteria3 = new PdfPCell(new Paragraph(
 					"3.6.3.1: Number of extension and outreach programs conducted by the institution through NSS/NCC, "
 					+ "Government and Government recognised bodies during the last five years."
 							+"\r\n\r\n",font4));
 			table3631criteria3.addCell(cell3631criteria3);
 			table3631criteria3.setSpacingAfter(20);
 			table3631criteria3.setSpacingBefore(20);
 			document.add(table3631criteria3);

// 			table191criteria3.addCell(cell362criteria3);
// 			table191criteria3.addCell(cell3621criteria3);
// 			// document.add(cell362criteria3);
// 			// document.add(cell3621criteria3);
// 			table191criteria3.setSpacingBefore(20f);
// 			table191criteria3.setSpacingAfter(20f);
// 			document.add(table191criteria3);

 			
 			
 			
 		//	document.add(paragraph71142criteria3);
 			
 			

 			if (criteria3Record.getYearTable3641().size()>0) {
 				Table table3721criteria3 = new Table(criteria3Record.getYearTable3641().size(), 2);

 				table3721criteria3.setPadding(5);
 				table3721criteria3.setWidth(100f);

 				for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
 					Cell cell1criteria3641 = new Cell (criteria3Record.getYearTable3641().get(i).getInput3641y());
 					cell1criteria3641.setHorizontalAlignment(Element.ALIGN_CENTER);
 					table3721criteria3.addCell(cell1criteria3641);
 					

 				}
 				for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
 					Cell cell2criteria3641 = new Cell (criteria3Record.getYearTable3641().get(i).getInput3641v());
 					cell2criteria3641.setHorizontalAlignment(Element.ALIGN_CENTER);
 					table3721criteria3.addCell(cell2criteria3641);
 					

 				}

 				document.add(table3721criteria3);
 			}
 			
 			
 			
 			
 			PdfPTable table19111criteria3 = new PdfPTable(2);
 			PdfPTable table1901criteria3 = new PdfPTable(1);

 			table19111criteria3.setWidthPercentage(100f);
 			table190criteria3.setWidthPercentage(100f);

 			PdfPCell cell19111criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
 			cell19111criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19211criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
 			cell19211criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19311criteria3 = new PdfPCell(
 					new Paragraph("\r\nReports of the event organized\r\n\r\n",font5));
 			cell19311criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19411criteria3 = new PdfPCell(
 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
 			cell19411criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19511criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
 			cell19511criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19611criteria3 = new PdfPCell(
 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
 			cell19611criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19711criteria3 = new PdfPCell(new Paragraph("\r\nNumber of extension and outreach Programmes conducted with industry, community etc for the last five years\r\n\r\n",font5));
 			cell19711criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19811criteria3 = new PdfPCell(
 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
 			cell19811criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			table19111criteria3.addCell(cell19111criteria3);
 			table19111criteria3.addCell(cell19211criteria3);
 			table19111criteria3.addCell(cell19311criteria3);
 			table19111criteria3.addCell(cell19411criteria3);
 			table19111criteria3.addCell(cell19511criteria3);
 			table19111criteria3.addCell(cell19611criteria3);
 			table19111criteria3.addCell(cell19711criteria3);
 			table19111criteria3.addCell(cell19811criteria3);
 			table19111criteria3.setSpacingAfter(20);
 			table19111criteria3.setSpacingBefore(20);
 			
 			document.add(table19111criteria3);
 			
 			
 			
 			//////////////
 			PdfPTable table364criteria3 = new PdfPTable(1);	
 			table364criteria3.setWidthPercentage(100);
 			
 			PdfPCell cell364criteria3 = new PdfPCell(new Paragraph(
 					"3.6.4: Average percentage of students participating in extension activities listed at 3.6.3 above during the last five years\r\n\r\n" + "Response: "
 			+(criteria3Record != null
				? criteria3Record.getCriteria36Qn().get(0).getResponse364()
				: "")+"\r\n\r\n",font4));
 			
 			table364criteria3.addCell(cell364criteria3);
 			table364criteria3.setSpacingAfter(20);
 			table364criteria3.setSpacingBefore(20);
 			
 			document.add(table364criteria3);
 			
// 			if(criteria3Record.getCriteria36Qn() !=null)
// 			{
// 			Paragraph paragraph72criteria3 = new Paragraph(criteria3Record != null
// 									? criteria3Record.getCriteria36Qn().get(0).getResponse364()
// 									: "", font5);
// 			document.add(paragraph72criteria3);
// 			}
 	
// 			Paragraph paragraph73criteria3 = new Paragraph(
// 					"3.6.2.1 Total number of awards and recognition received for extension activities from Government/ Government recognised bodies year-wise during the last five years."
// 							);
// 			document.add(paragraph73criteria3);

// 			table191criteria3.addCell(cell362criteria3);
// 			table191criteria3.addCell(cell3621criteria3);
// 			// document.add(cell362criteria3);
// 			// document.add(cell3621criteria3);
// 			table191criteria3.setSpacingBefore(20f);
// 			table191criteria3.setSpacingAfter(20f);
// 			document.add(table191criteria3);

 			
 			
 			
 			
 			
 			

 			if (criteria3Record.getYearTable3641().size()>0) {
 				Table table3721criteria3 = new Table(criteria3Record.getYearTable3641().size(), 2);

 				table3721criteria3.setPadding(5);
 				table3721criteria3.setWidth(100f);

 				for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
 					Cell cell1criteria3641 = new Cell (criteria3Record.getYearTable3641().get(i).getInput3641y());
 					cell1criteria3641.setHorizontalAlignment(Element.ALIGN_CENTER);
 					table3721criteria3.addCell(cell1criteria3641);
 					

 				}
 				for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
 					Cell cell2criteria3641 = new Cell (criteria3Record.getYearTable3641().get(i).getInput3641v());
 					cell2criteria3641.setHorizontalAlignment(Element.ALIGN_CENTER);
 					table3721criteria3.addCell(cell2criteria3641);
 					

 				}

 				document.add(table3721criteria3);
 			}
 			
 		//	document.add(paragraph71142criteria3);
 			
 			
 			
 			PdfPTable table19113criteria3 = new PdfPTable(2);
 			PdfPTable table1903criteria3 = new PdfPTable(1);

 			table19113criteria3.setWidthPercentage(100f);
 			table1903criteria3.setWidthPercentage(100f);

 			PdfPCell cell19113criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
 			cell19113criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19213criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
 			cell19213criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19313criteria3 = new PdfPCell(
 					new Paragraph("\r\nNumber of awards for extension activities in last 5 year\r\n\r\n",font5));
 			cell19313criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19413criteria3 = new PdfPCell(
 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
 			cell19413criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19513criteria3 = new PdfPCell(new Paragraph("\r\nE-copy of the award letters\r\n\r\n",font5));
 			cell19513criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19613criteria3 = new PdfPCell(
 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
 			cell19613criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19713criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
 			cell19713criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			PdfPCell cell19813criteria3 = new PdfPCell(
 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
 			cell19813criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
 			
 			table19113criteria3.addCell(cell19113criteria3);
 			table19113criteria3.addCell(cell19213criteria3);
 			table19113criteria3.addCell(cell19313criteria3);
 			table19113criteria3.addCell(cell19413criteria3);
 			table19113criteria3.addCell(cell19513criteria3);
 			table19113criteria3.addCell(cell19613criteria3);
 			table19113criteria3.addCell(cell19713criteria3);
 			table19113criteria3.addCell(cell19813criteria3);
 			table19113criteria3.setSpacingAfter(20);
 			table19113criteria3.setSpacingBefore(20);
 			
 			document.add(table19113criteria3);
 			
			// 3.7
 			Paragraph paragraph8criteria3 = new Paragraph("3.7	Collaboration\r\n\r\n", font2);
			paragraph8criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph8criteria3);
			// create table 22 //
			PdfPTable table22criteria3 = new PdfPTable(2);
			PdfPTable table221criteria3 = new PdfPTable(1);
			table22criteria3.setWidthPercentage(100f);
			table221criteria3.setWidthPercentage(100f);

			
			PdfPTable table371criteria3 = new PdfPTable(1);	
			table371criteria3.setWidthPercentage(100);
 			
 			PdfPCell cell371criteria3 = new PdfPCell(new Paragraph(
					"3.7.1 Number of Collaborative activities per year for research/ faculty exchange/ student exchange/ internship/ on –the-job training/ project work\r\n"
							+ "\r\n" + "Response: "
							+(criteria3Record != null
							? criteria3Record.getCriteria37Qn().get(0).getResponse371()
							: "")+"\r\n\r\n",font4));
 			table371criteria3.addCell(cell371criteria3);
 			table371criteria3.setSpacingAfter(20);
 			table371criteria3.setSpacingBefore(20);
 			
			document.add(table371criteria3);
			
			
//			Paragraph paragraph8criteria32 = new Paragraph(criteria3Record != null
//									? criteria3Record.getCriteria37Qn().get(0).getResponse371()
//									: "", font5);
//			document.add(paragraph8criteria32);
			
			PdfPTable table3711criteria3 = new PdfPTable(1);	
			table3711criteria3.setWidthPercentage(100);
 			
 			PdfPCell cell3711criteria3 = new PdfPCell(new Paragraph("3.7.1.1: Total number of Collaborative activities per year for research/ faculty exchange/ student exchange/ "
 					+ "internship/ on -the-job training/ project work"+"\r\n\r\n",font4));
 			table3711criteria3.addCell(cell3711criteria3);
 			table3711criteria3.setSpacingAfter(20);
 			table3711criteria3.setSpacingBefore(20);
 			
			document.add(table3711criteria3);
			
			if (criteria3Record.getYearTable3711().size()>0) {
				Table table3721criteria3 = new Table(criteria3Record.getYearTable3711().size(), 2);

				table3721criteria3.setPadding(5);
				table3721criteria3.setWidth(100f);

				for (int i = 0; i < criteria3Record.getYearTable3711().size(); i++) {
					Cell cell1criteria3711 = new Cell (criteria3Record.getYearTable3711().get(i).getInput3711y());
					cell1criteria3711.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3721criteria3.addCell(cell1criteria3711);
					
				}
				for (int i = 0; i < criteria3Record.getYearTable3711().size(); i++) {
					Cell cell2criteria3711 = new Cell (criteria3Record.getYearTable3711().get(i).getInput3711v());
					cell2criteria3711.setHorizontalAlignment(Element.ALIGN_CENTER);
					table3721criteria3.addCell(cell2criteria3711);
					
				}

				document.add(table3721criteria3);
			}
			
			
			
			PdfPCell cell221criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell221criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell222criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell222criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell223criteria3 = new PdfPCell(
					new Paragraph("\r\nNumber of Collaborative activities for research, faculty etc \r\n\r\n",font5));
			cell223criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell224criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell224criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell225criteria3 = new PdfPCell(new Paragraph("\r\nCopies of collaboration\r\n\r\n",font5));
			cell225criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell226criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell226criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table22criteria3.addCell(cell221criteria3);
			table22criteria3.addCell(cell222criteria3);
			table22criteria3.addCell(cell223criteria3);
			table22criteria3.addCell(cell224criteria3);
			table22criteria3.addCell(cell225criteria3);
			table22criteria3.addCell(cell226criteria3);
			
		//	PdfPCell cell3711criteria3 = new PdfPCell(new Paragraph("" + "", font2));
//			table221criteria3.addCell(cell371criteria3);
		//	table221criteria3.addCell(cell3711criteria3);
	//		table221criteria3.addCell(table22criteria3);
			// document.add(cell371criteria3);
			// document.add(cell3711criteria3);
			table22criteria3.setSpacingBefore(20f);
			table22criteria3.setSpacingAfter(20f);
			document.add(table221criteria3);
			document.add(table22criteria3);
			// create tablle 3711 //

			
			
			
			
			
			
			
//			Paragraph paragraph8criteria312 = new Paragraph(
//					"3.7.1 Number of Collaborative activities per year for research/ faculty exchange/ student exchange/ internship/ on –the-job training/ project work\r\n"
//							+ "\r\n" + "Response: ",font4);
//			document.add(paragraph8criteria312);
//			
//			
//			Paragraph paragraph8criteria322 = new Paragraph(criteria3Record != null
//									? criteria3Record.getCriteria37Qn().get(0).getResponse371()
//									: "", font5);
//			document.add(paragraph8criteria322);
//			
//			Paragraph paragraph8criteria332 = new Paragraph("3.7.1.1: Total number of Collaborative activities per year for research/ faculty exchange/ student exchange/ internship/ on -the-job training/ project work");
//			
//			document.add(paragraph8criteria332);
//			
//			
//			
//			if (criteria3Record.getYearTable3721().size()>0) {
//				Table table3721criteria3 = new Table(criteria3Record.getYearTable3721().size(), 2);
//
//				table3721criteria3.setPadding(5);
//				table3721criteria3.setWidth(100f);
//
//				for (int i = 0; i < criteria3Record.getYearTable3721().size(); i++) {
//					Cell cell1criteria3721 = new Cell (criteria3Record.getYearTable3721().get(i).getInput3721y());
//					cell1criteria3721.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table3721criteria3.addCell(cell1criteria3721);
//					
//				}
//				for (int i = 0; i < criteria3Record.getYearTable3711().size(); i++) {
//					Cell cell2criteria3721 = new Cell (criteria3Record.getYearTable3721().get(i).getInput3721v());
//					cell2criteria3721.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table3721criteria3.addCell(cell2criteria3721);
//					
//
//				}
//
//				document.add(table3721criteria3);
//			}
//			
//			PdfPTable table22criteria31 = new PdfPTable(2);
//			PdfPTable table221criteria31 = new PdfPTable(1);
//			table22criteria31.setWidthPercentage(100f);
//			table221criteria31.setWidthPercentage(100f);
//			
//			PdfPCell cell221criteria31 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
//			cell221criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell222criteria31 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//			cell222criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell223criteria31 = new PdfPCell(
//					new Paragraph("\r\nNumber of Collaborative activities for research, faculty etc \r\n\r\n",font5));
//			cell223criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell224criteria31 = new PdfPCell(
//					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//			cell224criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell225criteria31 = new PdfPCell(new Paragraph("\r\nCopies of collaboration\r\n\r\n",font5));
//			cell225criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell226criteria31 = new PdfPCell(
//					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//			cell226criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			table22criteria31.addCell(cell221criteria31);
//			table22criteria31.addCell(cell222criteria31);
//			table22criteria31.addCell(cell223criteria31);
//			table22criteria31.addCell(cell224criteria31);
//			table22criteria31.addCell(cell225criteria31);
//			table22criteria31.addCell(cell226criteria31);
//			
//			table221criteria3.setSpacingBefore(20f);
//			table221criteria3.setSpacingAfter(20f);
//			document.add(table22criteria31);
//			
			}



////////////////////////////////////////////////////////////////4.1/////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////
			///////////////////////////////////////////////////////////////////////
	////////////////////////////////////////4.1///////////
			
		public void Criteria4(Document document,Criteria4_FieldInfo criteria4Fieldinfo)	{   //  4.1
			Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources\r\n\r\n", font1);
			paragraph1criteria4.setAlignment(Paragraph.ALIGN_CENTER);

			document.add(paragraph1criteria4);

			

			Paragraph paragraph2criteria4 = new Paragraph("4.1 Physical Facilities", font2);
			paragraph2criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph2criteria4);

		

			PdfPTable table01criteria4 = new PdfPTable(1);

			table01criteria4.setWidthPercentage(100);

			PdfPCell cell0criteria4 = new PdfPCell(new Paragraph(
					"4.1.1 The Institution has adequate infrastructure and physical facilities for teaching- learning. viz., classrooms, laboratories, computing equipment etc.\r\n"
							+ "\r\n" + "Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria41Ql().get(0).getResponse411()
									: "")+"\r\n\r\n",
					font4));
			table01criteria4.addCell(cell0criteria4);

			// table101criteria5.addCell(table010criteria5);

			table01criteria4.setSpacingBefore(20f);
			table01criteria4.setSpacingAfter(20f);

			document.add(table01criteria4);

			
			PdfPTable table2 = new PdfPTable(2);
			table2.setWidthPercentage(100);

			PdfPCell cell001criteria4 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell001criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell001criteria4.setExtraParagraphSpace(10);
			table2.addCell(cell001criteria4);
			
			PdfPCell cell002criteria4 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell002criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell002criteria4.setExtraParagraphSpace(10);
			table2.addCell(cell002criteria4);
			
			PdfPCell cell003criteria4 = new PdfPCell(new Paragraph("\r\nUpload Any additional information\r\n\r\n ",font5));
			cell003criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell003criteria4.setExtraParagraphSpace(10);
			table2.addCell(cell003criteria4);
			
			if(criteria4file.size() > 0)
			{
			PdfPCell cell004criteria4 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			table2.addCell(cell004criteria4);
		}
			PdfPCell cell005criteria4 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
			cell005criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell005criteria4.setExtraParagraphSpace(10);
			
			PdfPCell cell006criteria4 = new PdfPCell(new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell006criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell006criteria4.setExtraParagraphSpace(10);
			
			table2.addCell(cell005criteria4);
			table2.addCell(cell006criteria4);

			table2.setSpacingBefore(20f);
			table2.setSpacingAfter(20f);

			document.add(table2);
			
			
			

			Paragraph paragraph13criteria4 = new Paragraph(
					"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)"+"\r\n",
					font4);
			paragraph13criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
			Paragraph paragraph14criteria4 = new Paragraph("Response: "
					+ (criteria4Record != null ? criteria4Record.getCriteria41Ql().get(0).getResponse412()
							: "")+"\r\n\r\n",
					font5);
			paragraph14criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);


			// Creating a table of 3 columns
			PdfPTable table4criteria4 = new PdfPTable(2);
			PdfPTable table412criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table4criteria4.setWidthPercentage(100);
			table412criteria4.setWidthPercentage(100);

			PdfPCell cell007 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell007.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell007.setExtraParagraphSpace(10);
			
			table4criteria4.addCell(cell007);
			
			PdfPCell cell008 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell008.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell008.setExtraParagraphSpace(10);
			table4criteria4.addCell(cell008);
			
			PdfPCell cell0009 = new PdfPCell(new Paragraph(" \r\nUpload Any additional information\r\n\r\n",font5));
			cell0009.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell0009.setExtraParagraphSpace(10);
			table4criteria4.addCell(cell0009);
			
			if(criteria4file.size() >0)
			{
			PdfPCell cell0010 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0010.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0010.setExtraParagraphSpace(10);
			table4criteria4.addCell(cell0010);
			}
			
			PdfPCell cell0011 = new PdfPCell(new Paragraph("\r\nGeotagged pictures\r\n\r\n",font5));
			cell0011.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0011.setExtraParagraphSpace(10);
			table4criteria4.addCell(cell0011);
			
			if(criteria4file.size() >0)
			{
			PdfPCell cell0012 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0012.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0012.setExtraParagraphSpace(10);
			table4criteria4.addCell(cell0012);
			}
			
			PdfPCell cell0013 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n",font5));
			cell0013.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0013.setExtraParagraphSpace(10);
			
			PdfPCell cell0014 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "",font5));
			

			
			
			table4criteria4.addCell(cell0013);
			table4criteria4.addCell(cell0014);

			PdfPCell cell412criteria4 = new PdfPCell(new Paragraph(
					"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)\r\n"
							+ "\r\n\r\n" + "Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria41Ql().get(0).getResponse412()
									: "")+"\r\n\r\n",
					font4));

			table412criteria4.addCell(cell412criteria4);
		//	table412criteria4.addCell(table4criteria4);
			table412criteria4.setSpacingBefore(20f);
			table412criteria4.setSpacingAfter(20f);

			document.add(table412criteria4);

			// Creating a table of columns
			PdfPTable table5criteria4 = new PdfPTable(2);
			PdfPTable table413 = new PdfPTable(1);

			PdfPTable table51 = new PdfPTable(1);
			

			// Setting width of table, its columns and spacing
			table5criteria4.setWidthPercentage(100);
			table413.setWidthPercentage(100);
			table51.setWidthPercentage(100);

			PdfPCell cell0015 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
			cell0015.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell0015.setExtraParagraphSpace(10);
			table5criteria4.addCell(cell0015);
			
			PdfPCell cell0016 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell0016.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0016.setExtraParagraphSpace(10);
			table5criteria4.addCell(cell0016);
			
			PdfPCell cell0017 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
			cell0017.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0017.setExtraParagraphSpace(10);
			table5criteria4.addCell(cell0017);
			
			if(criteria4file.size() >0)
			{
			PdfPCell cell0018 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell0018.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0018.setExtraParagraphSpace(10);
			table5criteria4.addCell(cell0018);
			}
			
			PdfPCell cell413criteria4 = new PdfPCell(new Paragraph(
					"4.1.3 Percentage of classrooms and seminar halls with ICT- enabled facilities such as smart class, LMS, etc. (Data for the latest completed academic year)\r\n"
							+ "\r\n" + "Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria43Ql().get(0).getResponse431()
									: "")+"\r\n\r\n",font4));
			
			table413.addCell(cell413criteria4);
			document.add(table413);

			PdfPCell cell4131criteria4 = new PdfPCell(new Paragraph("4.1.3.1 Number of classrooms and seminar halls with ICT facilities" + "\r\n\r\n"
					+ (criteria4Record != null ? criteria4Record.getCriteria43Ql().get(0).getInput431t1() : "")+"\r\n\r\n",font4));
			
			PdfPCell cell41312criteria4 = new PdfPCell(new Paragraph("4.1.3.12: Number of classrooms and seminar halls in the Institution" + "\r\n\r\n"
					+ (criteria4Record != null ? criteria4Record.getCriteria43Ql().get(0).getInput431t2() : "")+"\r\n\r\n",font4));
			
			
			table51.addCell(cell4131criteria4);
			table51.addCell(cell41312criteria4);
		
		//	table51.addCell(table5criteria4);

			table51.setSpacingBefore(20f);
			table51.setSpacingAfter(20f);

			document.add(table51);

		PdfPTable table414criteria4 = new PdfPTable(1);
		PdfPTable table4141criteria4 = new PdfPTable(1);	
		
		
		table414criteria4.setWidthPercentage(100);
		table4141criteria4.setWidthPercentage(100);
		

		PdfPCell cell414criteria4 = new PdfPCell(new Paragraph(
					"4.1.4 Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)\r\n"
							+ "\r\n" + "Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria41Ql().get(0).getResponse414()
									: "")+"\r\n\r\n",font4));

		table414criteria4.addCell(cell414criteria4);

		PdfPCell cell4141criteria4 = new PdfPCell(new Paragraph(
					"4.1.4.1 Expenditure for infrastructure augmentation, excluding salary year-wise during last five years (INR in lakhs)\r\n\r\n",font4));

			// table61.addCell(table6);
		table4141criteria4.addCell(cell4141criteria4);
		
		table4141criteria4.setSpacingBefore(20f);
		table4141criteria4.setSpacingAfter(20f);

		document.add(table414criteria4);
			document.add(table4141criteria4);

			if (criteria4Record.getYearTable4141().size()>0) {

				Table table4141 = new Table(criteria4Record.getYearTable4141().size(), 2);

				table4141.setPadding(10);
				table4141.setWidth(100f);

				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
					Cell cell1criteria4141 = new Cell (criteria4Record.getYearTable4141().get(i).getInput4141y());
					cell1criteria4141.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4141.addCell(cell1criteria4141);
					

				}
				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
					Cell cell2criteria4141 = new Cell (criteria4Record.getYearTable4141().get(i).getInput4141v());
					cell2criteria4141.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4141.addCell(cell2criteria4141);
					

				}

				document.add(table4141);
			}
			
			
			

			if (criteria4Record.getYearTable41412().size()>0) {

				Table table41412 = new Table(criteria4Record.getYearTable41412().size(), 2);

				table41412.setPadding(10);
				table41412.setWidth(100f);

				for (int i = 0; i < criteria4Record.getYearTable41412().size(); i++) {
					Cell cell1criteria41412 = new Cell (criteria4Record.getYearTable41412().get(i).getInput41412y());
					cell1criteria41412.setHorizontalAlignment(Element.ALIGN_CENTER);
					table41412.addCell(cell1criteria41412);
					

				}
				for (int i = 0; i < criteria4Record.getYearTable41412().size(); i++) {
					Cell cell2criteria41412 = new Cell (criteria4Record.getYearTable41412().get(i).getInput41412v());
					cell2criteria41412.setHorizontalAlignment(Element.ALIGN_CENTER);
					table41412.addCell(cell2criteria41412);
					

				}

				document.add(table41412);
			}
			
			
			
			
			

			// Creating a table of 3 columns
			PdfPTable table7criteria4 = new PdfPTable(2);

			// Setting width of table, its columns and spacing
			table7criteria4.setWidthPercentage(100);

			PdfPCell cell0033 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell0033.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0033.setExtraParagraphSpace(10);
			table7criteria4.addCell(cell0033);
			
			PdfPCell cell0034 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell0034.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0034.setExtraParagraphSpace(10);
			table7criteria4.addCell(cell0034);
			
			PdfPCell cell0035 = new PdfPCell(
					new Paragraph("\r\nUpload Details of Expenditure , excluding salary during the last five years\r\n\r\n ",font5));
			cell0035.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0035.setExtraParagraphSpace(10);
			table7criteria4.addCell(cell0035);
			
            if(criteria4file.size() >0)
            {
			PdfPCell cell0036 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0036.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0036.setExtraParagraphSpace(10);
			table7criteria4.addCell(cell0036);
            }
            
			PdfPCell cell0037 = new PdfPCell(new Paragraph("\r\nUpload audited utilization statements\r\n\r\n",font5));
			cell0037.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0037.setExtraParagraphSpace(10);
			table7criteria4.addCell(cell0037);
			
			 if(criteria4file.size() >0)
	            {
			PdfPCell cell0038 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0038.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0038.setExtraParagraphSpace(10);
			table7criteria4.addCell(cell0038);
	            }
			 
			PdfPCell cell0039 = new PdfPCell(new Paragraph(" \r\nLink for any additional information\r\n\r\n",font5));
			cell0039.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0039.setExtraParagraphSpace(10);
			table7criteria4.addCell(cell0039);
			
			PdfPCell cell0040 = new PdfPCell(new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5 ));
			cell0040.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0040.setExtraParagraphSpace(10);
			table7criteria4.addCell(cell0040);

			table7criteria4.setSpacingBefore(20f);
			table7criteria4.setSpacingAfter(20f);

			document.add(table7criteria4);

			
			// 4.2
			

			Paragraph paragraph31criteria4 = new Paragraph("4.2 Library as a Learning Resource\r\n", font2);
			paragraph31criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph31criteria4);
//			Paragraph paragraph32criteria4 = new Paragraph(
//					"4.2.1	Library is automated using Integrated Library Management System (ILMS)\r\n" + "Response",
//					font2);
//			paragraph32criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph32criteria4);

			PdfPTable table421criteria4 = new PdfPTable(1);
			PdfPTable table4210criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table421criteria4.setWidthPercentage(100);
			table4210criteria4.setWidthPercentage(100);
//
			PdfPCell cell4210criteria4 = new PdfPCell(new Paragraph(
					"4.2.1 Library is automated using Integrated Library Management System (ILMS)\r\n\r\n Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria42Ql().get(0).getResponse421()
									: "")+"\r\n\r\n",font4));
			
			table4210criteria4.addCell(cell4210criteria4);
			//document.add(table421criteria4);

			table4210criteria4.setSpacingBefore(20f);
			table4210criteria4.setSpacingAfter(20f);
			document.add(table4210criteria4);

		
			// Creating a table of 3 columns
			PdfPTable table8criteria4 = new PdfPTable(2);
			Font font6criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font6criteria4.setColor(CMYKColor.BLACK);
			// Setting width of table, its columns and spacing
			table8criteria4.setWidthPercentage(100);

			PdfPCell cell0041 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n\r\n", font4));
			cell0041.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0041.setExtraParagraphSpace(10);
			
			PdfPCell cell0042 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n\r\n", font4));
			cell0042.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0042.setExtraParagraphSpace(10);
			
			PdfPCell cell0043 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell0043.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0043.setExtraParagraphSpace(10);
			
			PdfPCell cell0044 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0044.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0044.setExtraParagraphSpace(10);
			
			PdfPCell cell0045 = new PdfPCell(new Paragraph("\r\nPaste Link for additional information\r\n\r\n ",font5));
			cell0045.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0045.setExtraParagraphSpace(10);
			
			PdfPCell cell0046 = new PdfPCell(new Paragraph( "\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0046.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0046.setExtraParagraphSpace(10);
			

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

			PdfPCell cell0047 = new PdfPCell(new Paragraph("\r\nFileDescription\r\n\r\n", font4));
			cell0047.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0047.setExtraParagraphSpace(10);
			
			PdfPCell cell0048 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell0048.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0048.setExtraParagraphSpace(10);
			
			PdfPCell cell0049 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell0049.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0049.setExtraParagraphSpace(10);
			
			PdfPCell cell0050 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0050.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0050.setExtraParagraphSpace(10);
			
			PdfPCell cell0051 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n",font5));
			cell0051.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0051.setExtraParagraphSpace(10);
			
			PdfPCell cell0052 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0052.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0052.setExtraParagraphSpace(10);
			
			PdfPCell cell0053 = new PdfPCell(new Paragraph(
					"\r\nDetails of subscriptions like e-journals, e-books , e- ShodhSindhu, Shodhganga Membership etc\r\n\r\n",font5));
			cell0053.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0053.setExtraParagraphSpace(10);
			
			PdfPCell cell0054 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0054.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0054.setExtraParagraphSpace(10);
			

			table9criteria4.addCell(cell0047);
			table9criteria4.addCell(cell0048);
			table9criteria4.addCell(cell0049);
			table9criteria4.addCell(cell0050);
			table9criteria4.addCell(cell0051);
			table9criteria4.addCell(cell0052);
			table9criteria4.addCell(cell0053);
			table9criteria4.addCell(cell0054);

			
			
			PdfPCell cell422criteria4 = new PdfPCell(new Paragraph(
					"4.2.2 Institution has access to the following: 1. e-journals 2. e-ShodhSindhu 3. Shodhganga Membership 4. e-books 5. Databases 6. Remote access to e-resources\r\n"
							+ "\r\n" + "Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria42Qn().get(0).getResponse422()
									: "")+"\r\n\r\n",font4));
			
		//	table10criteria4.addCell(table9criteria4);
			table10criteria4.addCell(cell422criteria4);

			table10criteria4.setSpacingBefore(20f);
			table10criteria4.setSpacingAfter(20f);

			document.add(table10criteria4);
			
			PdfPTable table423criteria4 = new PdfPTable(1);
			PdfPTable table4231criteria4 = new PdfPTable(1);
			
			table423criteria4.setWidthPercentage(100);
			table4231criteria4.setWidthPercentage(100);

		
			PdfPCell cell423criteria4 = new PdfPCell(new Paragraph(
					"4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n"
							+ "\r\n\r\n" + "Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria42Qn().get(0).getResponse423()
									: "")+"\r\n\r\n",font4));
			
			table423criteria4.addCell(cell423criteria4);
			
			PdfPCell cell4231criteria4 = new PdfPCell(new Paragraph(
					"4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)"
							+ "\r\n\r\n",font4));

			//table12criteria4.addCell(table11criteria4);
			table4231criteria4.addCell(cell4231criteria4);
			
			table423criteria4.setSpacingBefore(20f);
			table423criteria4.setSpacingAfter(20f);

			document.add(table423criteria4);
			document.add(table4231criteria4);

			
			
			if (criteria4Record.getYearTable4231().size()>0) {

				Table table4231 = new Table(criteria4Record.getYearTable4231().size(), 2);

				table4231.setPadding(10);
				table4231.setWidth(100f);

				for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
					Cell cell1criteria4231 = new Cell (criteria4Record.getYearTable4231().get(i).getInput4231y());
					cell1criteria4231.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4231.addCell(cell1criteria4231);
					
				}
				for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
					Cell cell2criteria4231 = new Cell (criteria4Record.getYearTable4231().get(i).getInput4231v());
					cell2criteria4231.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4231.addCell(cell2criteria4231);
					

				}

				document.add(table4231);
			}

			// Creating a table of 3 columns

			PdfPTable table13 = new PdfPTable(2);

			// Setting width of table, its columns and spacing
			table13.setWidthPercentage(100);

			PdfPCell cell0065 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell0065.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0065.setExtraParagraphSpace(10);
			
			PdfPCell cell0066 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell0066.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0066.setExtraParagraphSpace(10);
			
			PdfPCell cell0067 = new PdfPCell(new Paragraph(
					"\r\nDetails of annual expenditure for purchase of and subscription to journals/e-journals during the last five years\r\n\r\n",font5));
			cell0067.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0067.setExtraParagraphSpace(10);
			
			PdfPCell cell0068 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0068.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0068.setExtraParagraphSpace(10);
			
			PdfPCell cell0069 = new PdfPCell(new Paragraph("\r\nAudited statements of accounts\r\n\r\n",font5));
			cell0069.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0069.setExtraParagraphSpace(10);
			
			PdfPCell cell0070 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0070.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0070.setExtraParagraphSpace(10);
			
			PdfPCell cell0071 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell0071.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0071.setExtraParagraphSpace(10);
			
			PdfPCell cell0072 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0072.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0072.setExtraParagraphSpace(10);
			

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
			PdfPTable table4241 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table14criteria4.setWidthPercentage(100);
			table15.setWidthPercentage(100);
			table4241.setWidthPercentage(100);
			
			PdfPCell cell0075 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell0075.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0075.setExtraParagraphSpace(10);
			
			PdfPCell cell0076 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell0076.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0076.setExtraParagraphSpace(10);
			
			PdfPCell cell0077 = new PdfPCell(new Paragraph("\r\nDetails of library usage by teachers and students\r\n\r\n",font5));
			cell0077.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0077.setExtraParagraphSpace(10);
			
			PdfPCell cell0078 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0078.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0078.setExtraParagraphSpace(10);
			
			PdfPCell cell0079 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell0079.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0079.setExtraParagraphSpace(10);
			
			PdfPCell cell0080 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0080.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0080.setExtraParagraphSpace(10);
			

			table14criteria4.addCell(cell0075);
			table14criteria4.addCell(cell0076);
			table14criteria4.addCell(cell0077);
			table14criteria4.addCell(cell0078);
			table14criteria4.addCell(cell0079);
			table14criteria4.addCell(cell0080);

			PdfPCell cell424criteria4 = new PdfPCell(new Paragraph(
					"4.2.4 Percentage per day usage of library by teachers and students ( foot falls and login data for online access) during the latest completed academic year"
							+ "\r\n\r\n\r\n" + "Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria42Qn().get(0).getResponse424()
									: "")+"\r\n\r\n",font4));

			table15.addCell(cell424criteria4);

			PdfPCell cell4241criteria4 = new PdfPCell(new Paragraph("4.2.4.1 Number of teachers and students using library per day over last one year\r\n" + "\r\n"
				
					+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getInput4241t1() : "")+"\r\n\r\n",font4));


			PdfPCell cell42410criteria4 = new PdfPCell(new Paragraph("4.2.4.1: Total number of teachers and students\r\n" + "\r\n"
				
					+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getInput4241t2() : "")+"\r\n\r\n",font4));

			table4241.addCell(cell4241criteria4);
			table4241.addCell(cell42410criteria4);
		//	table15.addCell(table14criteria4);

			table15.setSpacingBefore(20f);
			table15.setSpacingAfter(20f);

			document.add(table15);
			
			document.add(table4241);

			// 4.3 
			Paragraph paragraph38criteria4 = new Paragraph("4.3 Infrastructure\r\n\r\n", font1);
			paragraph38criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph35 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph35.setSize(12);
			 */

//			Paragraph paragraph39criteria4 = new Paragraph(
//					"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n\r\n",font2);
//			paragraph39criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph36 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph36.setSize(12);
			 */

			
			/*
			 * Font fontParagraph37 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph37.setSize(12);
			 */

//			Paragraph paragraph41 = new Paragraph(
//					"Mother Teresa considers that in the current information age no organization can survive without extensive use of IT. Towards this, the college has developed an IT policy encompassing all IT/IT enabled services used in the campus, ensuring smooth functioning with adequate security to all users connected to the campus network.\r\n"
//							+ "\r\n"
//							+ "Based on the laboratory and other requirements, every year college allocates budget for updating its IT facilities for procurement of computer systems and other IT related equipment including software.\r\n"
//							+ "\r\n"
//							+ "Every user in the campus is provided access to the campus network as well as internet.\r\n"
//							+ "\r\n"
//							+ "48 LCD projectors have been installed in class rooms and labs with wi-fi/internet connectivity.\r\n"
//							+ "\r\n"
//							+ "All students and faculty are given email accounts with college domain name through GSuite. The college has installed two firewalls in order to protect all its internal systems from cyber attacks.\r\n"
//							+ " \r\n"
//							+ "The college also installed CISCO switches for monitoring traffic in the campus network.\r\n"
//							+ "",
//					font5);
//			paragraph41.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph38 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph38.setSize(12);
			 */

//			Paragraph paragraph42 = new Paragraph("The details of up-dation as follows:", font2);
//			paragraph42.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph39 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph39.setSize(12);
//			 */
//
//			Paragraph paragraph43criteria4 = new Paragraph("AY 2020-21\r\n" + "\r\n"
//					+ "1.	Procured 320 Lenovo computers of core i5 of 16GB RAM, 1TB HDD.\r\n"
//					+ "2.	Provided ICT Facilities in 06 class rooms\r\n"
//					+ "3.	Internet facility was upgraded from 210 Mbps to 1000 Mbps with two distinct service providers.\r\n"
//					+ "4.	ACT (Atria Convergence Technologies Ltd) Fibre (500Mbps).\r\n"
//					+ "5.D-Vios Communications Pvt Ltd.(500Mbps).\r\n" + " ", font5);
//			paragraph43criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph40 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph40.setSize(12);
			 */
//
//			Paragraph paragraph44 = new Paragraph("AY 2019-20\r\n" + "\r\n"
//					+ "1.	Provided ICT Facilities in 04 class rooms\r\n"
//					+ "2.	Established Robotics Learning and Development Centre Lab in collaboration with Smart Bridge Educational Services Pvt. Ltd.\r\n"
//					+ "3.	Procured 256 Acer computers of core i5 of 8GB RAM, 1TB HDD.\r\n"
//					+ "4.	Installed Firewall �Sophos XG Firewall� for exam branch.\r\n" + " ", font5);
//			paragraph44.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph41 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph41.setSize(12);
			 */
//
//			Paragraph paragraph45 = new Paragraph("AY 2019-20\r\n" + "\r\n"
//					+ "1.	Provided ICT Facilities in 04 class rooms\r\n"
//					+ "2.	Established Robotics Learning and Development Centre Lab in collaboration with Smart Bridge Educational Services Pvt. Ltd.\r\n"
//					+ "3.	Procured 256 Acer computers of core i5 of 8GB RAM, 1TB HDD.\r\n"
//					+ "4.	Installed Firewall �Sophos XG Firewall� for exam branch.\r\n" + " ", font5);
//			paragraph45.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph42 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph42.setSize(12);
			 */

//			Paragraph paragraph46 = new Paragraph("AY 2018-19\r\n" + "\r\n"
//					+ "1.	Installed Firewall \"Sonicwall NSA 3600� for securing campus network.\r\n"
//					+ "2.	Provided ICT Facilities in 09 class rooms\r\n"
//					+ "3.	Established one more Computing centre with 100 systems each.\r\n"
//					+ "4.	Increased number of computer systems in existing Computing centre from 48 to 100.\r\n"
//					+ "5.	Anti-virus: Quick Heal Seqrite EPS antivirus software (500 Users) has been installed for all the systems with Windows OS.\r\n"
//					+ "6.	Procured 216 Acer computers of core i3 with 4GB RAM, 1TB HDD and 60 Lenovo Computers of core i3 with 4GB RAM, 1TB HDD.\r\n"
//					+ "7.	Internet facility was upgraded from 132 Mbps to 210 Mbps with two distinct service providers.\r\n"
//					+ "\r\n"
//
//					+ " ", font5);
//			paragraph46.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph43 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph43.setSize(12);
			 */
//
//			Paragraph paragraph47 = new Paragraph("AY 2017-18\r\n" + "\r\n"
//					+ "1.	Procured 72 Acer computers of core i5 with 4GB RAM and 1TB HDD, 151 Acer computers of core i3 with 4GB RAM, 1 TB HDD and 170 Assembled computers of Dual Core with 4GB RAM, 1 TB HDD.\r\n"
//					+ "2.	Internet facility was upgraded from 48 Mbps to 132 Mbps with two distinct service providers.\r\n"
//
//					+ ":", font5);
//			paragraph47.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph44 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph44.setSize(12);
			 */

//			Paragraph paragraph48 = new Paragraph("AY 2016-17\r\n" + "\r\n"
//					+ "1.	Intra-net connectivity is provided on the campus with 20 Gbps fibre-optic cable over and above the Reliance Jio campus wi-fi for daily usage of 1GB/User.\r\n"
//					+ "2.	Established IBM Software Lab for Emerging Technologies in collaboration with IBM.\r\n"
//					+ "3.	Procured 302 Assembled computers of Dual Core with 2GB RAM, 500GB HDD.\r\n" + "", font5);
//			paragraph48.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph45 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph45.setSize(12);
			 */

//			Paragraph paragraph49 = new Paragraph("Year wise Allocated Budget for IT facilities:" + "", font3);
//			paragraph49.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph38criteria4);
			//document.add(paragraph39criteria4);
			//document.add(paragraph40);
//			document.add(paragraph41);
//			document.add(paragraph42);
//			document.add(paragraph43criteria4);
//			document.add(paragraph44);
//			document.add(paragraph45);
//			document.add(paragraph46);
//			document.add(paragraph47);
//			document.add(paragraph48);
//			document.add(paragraph49);

			// Creating a table of 3 columns

			//PdfPTable table16criteria4 = new PdfPTable(5);
			
			// Setting width of table, its columns and spacing
			//table16criteria4.setWidthPercentage(100);
			

//			PdfPCell cell0081 = new PdfPCell(new Paragraph("Budget allocated for IT facilities"));
//			PdfPCell cell0082 = new PdfPCell(new Paragraph("2016-17"));
//			PdfPCell cell0083 = new PdfPCell(new Paragraph("2017-2018"));
//			PdfPCell cell0084 = new PdfPCell(new Paragraph("2018-2019"));
//			PdfPCell cell0085 = new PdfPCell(new Paragraph("2019-2020"));
//			PdfPCell cell0086 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell0087 = new PdfPCell(new Paragraph("50,45,018"));
//			PdfPCell cell0088 = new PdfPCell(new Paragraph("96,97,574 "));
//			PdfPCell cell0089 = new PdfPCell(new Paragraph("79,75,787"));
//			PdfPCell cell0090 = new PdfPCell(new Paragraph("89,95,799 "));
//
//			table16criteria4.addCell(cell0081);
//			table16criteria4.addCell(cell0082);
//			table16criteria4.addCell(cell0083);
//			table16criteria4.addCell(cell0084);
//			table16criteria4.addCell(cell0085);
//			table16criteria4.addCell(cell0086);
//			table16criteria4.addCell(cell0087);
//			table16criteria4.addCell(cell0088);
//			table16criteria4.addCell(cell0089);
//			table16criteria4.addCell(cell0090);
//
//			table16criteria4.setSpacingBefore(20f);
//			table16criteria4.setSpacingAfter(20f);
//
//			document.add(table16criteria4);
			
			PdfPTable table17criteria4 = new PdfPTable(2);
			PdfPTable table431criteria4 = new PdfPTable(1);
			
			table17criteria4.setWidthPercentage(100);
			table431criteria4.setWidthPercentage(100);
			


			PdfPCell cell0091 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell0091.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0091.setExtraParagraphSpace(10);
			
			PdfPCell cell0092 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell0092.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0092.setExtraParagraphSpace(10);
			
			PdfPCell cell0093 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell0093.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0093.setExtraParagraphSpace(10);
			
			PdfPCell cell0094 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0094.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0094.setExtraParagraphSpace(10);
			
			PdfPCell cell0095 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
			cell0095.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0095.setExtraParagraphSpace(10);
			
			PdfPCell cell0096 = new PdfPCell(new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell0096.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0096.setExtraParagraphSpace(10);
			

			table17criteria4.addCell(cell0091);
			table17criteria4.addCell(cell0092);
			table17criteria4.addCell(cell0093);
			table17criteria4.addCell(cell0094);
			table17criteria4.addCell(cell0095);
			table17criteria4.addCell(cell0096);
			
			
			
			PdfPCell cell431criteria4 = new PdfPCell(new Paragraph(
					"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n\r\n"
					+"Response: "
							+(criteria4Record != null
							? criteria4Record.getCriteria43Ql().get(0).getResponse431()
							: "")+"\r\n\r\n",font4));
							
			table431criteria4.addCell(cell431criteria4);

//			PdfPCell cell4301criteria4 = new PdfPCell(new Paragraph( (criteria4Record != null
//									? criteria4Record.getCriteria43Ql().get(0).getResponse431()
//									: "")));			
//			table17criteria4.addCell(cell431criteria4);
//			table17criteria4.addCell(cell4301criteria4);
			
//			table17criteria4.addCell(table16criteria4);
//			table17criteria4.addCell(table16criteria4);
			table17criteria4.setSpacingAfter(20);
			table17criteria4.setSpacingBefore(20);
			
			document.add(table431criteria4);
			document.add(table17criteria4);

			
			// Creating a table of 3 columns
			PdfPTable table18criteria4 = new PdfPTable(2);
			PdfPTable table432criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table18criteria4.setWidthPercentage(100);
			table432criteria4.setWidthPercentage(100);

			PdfPCell cell0097 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell0097.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0096.setExtraParagraphSpace(10);
			
			PdfPCell cell0098 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell0098.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0098.setExtraParagraphSpace(10);
			
			PdfPCell cell0099 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell0099.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell0099.setExtraParagraphSpace(10);
			
			PdfPCell cell00100 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell00100.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00100.setExtraParagraphSpace(10);
			
			PdfPCell cell00101 = new PdfPCell(new Paragraph("\r\nStudent - computer ratio\r\n\r\n",font5));
			cell00101.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00101.setExtraParagraphSpace(10);
			
			PdfPCell cell00102 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell00102.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00102.setExtraParagraphSpace(10);
			

			table18criteria4.addCell(cell0097);
			table18criteria4.addCell(cell0098);
			table18criteria4.addCell(cell0099);
			table18criteria4.addCell(cell00100);
			table18criteria4.addCell(cell00101);
			table18criteria4.addCell(cell00102);
			
			
		//	table19criteria4.addCell(table18criteria4);


			PdfPCell cell432criteria4 = new PdfPCell(new Paragraph("4.3.2 Student - Computer ratio (Data for the latest completed academic year)\r\n"
					+ "\r\n\r\n" + "Response:"
					+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse432()
							: "")+"\r\n\r\n",font4));
			
			table432criteria4.addCell(cell432criteria4);
			
			table432criteria4.setSpacingBefore(20f);
			table432criteria4.setSpacingAfter(20f);

			document.add(table432criteria4);
			document.add(table18criteria4);

			// Creating a table of 3 columns

			PdfPTable table20criteria4 = new PdfPTable(2);
			PdfPTable table433criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table20criteria4.setWidthPercentage(100);
			table433criteria4.setWidthPercentage(100);

			PdfPCell cell00103 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell00103.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00103.setExtraParagraphSpace(10);
			
			PdfPCell cell00104 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell00104.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00104.setExtraParagraphSpace(10);
			
			PdfPCell cell00105 = new PdfPCell(
					new Paragraph("\r\nDetails of available bandwidth of internet connection in the Institution\r\n\r\n",font5));
			cell00105.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00105.setExtraParagraphSpace(10);
			
			PdfPCell cell00106 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell00106.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00106.setExtraParagraphSpace(10);
			

			table20criteria4.addCell(cell00103);
			table20criteria4.addCell(cell00104);
			table20criteria4.addCell(cell00105);
			table20criteria4.addCell(cell00106);
			table20criteria4.setSpacingAfter(20);
			table20criteria4.setSpacingBefore(20);
			
			document.add(table20criteria4);
			
		//	table21criteria4.addCell(table20criteria4);
			

			PdfPCell cell433criteria4 = new PdfPCell(new Paragraph("4.3.3 Bandwidth of internet connection in the Institution.\r\n" + "\r\n" + "Response: "
					+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse433()
							: "")+"\r\n\r\n",font4));

			table433criteria4.addCell(cell433criteria4);
			table433criteria4.setSpacingAfter(20);
			table433criteria4.setSpacingBefore(20);
			
			
			document.add(table433criteria4);

			// Creating a table of 3 columns

			
			PdfPTable table22criteria4 = new PdfPTable(2);
			PdfPTable table434criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table22criteria4.setWidthPercentage(100);
			table434criteria4.setWidthPercentage(100);

			PdfPCell cell00107 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell00107.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00107.setExtraParagraphSpace(10);
			
			PdfPCell cell00108 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell00108.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00108.setExtraParagraphSpace(10);
			
			PdfPCell cell00109 = new PdfPCell(new Paragraph("\r\nUpload Additional information\r\n\r\n",font5));
			cell00109.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00109.setExtraParagraphSpace(10);
			
			PdfPCell cell00110 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell00110.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00110.setExtraParagraphSpace(10);
			
			PdfPCell cell00111 = new PdfPCell(new Paragraph("\r\n Institutional data in prescribed format\r\n\r\n",font5));
			cell00111.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00111.setExtraParagraphSpace(10);
			
			PdfPCell cell00112 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell00112.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00112.setExtraParagraphSpace(10);
			

			table22criteria4.addCell(cell00107);
			table22criteria4.addCell(cell00108);
			table22criteria4.addCell(cell00109);
			table22criteria4.addCell(cell00110);
			table22criteria4.addCell(cell00111);
			table22criteria4.addCell(cell00112);
			table22criteria4.setSpacingAfter(20);
			table22criteria4.setSpacingBefore(20);
			
			document.add(table22criteria4);
			
	//		table23criteria4.addCell(table22criteria4);


			PdfPCell cell434criteria4 = new PdfPCell(new Paragraph("4.3.4	Institution has the following Facilities for e-content development\r\n"
					+ "1.	Media centre\r\n" + "2.	Audio visual centre\r\n" + "3.	Lecture Capturing System(LCS)\r\n"
					+ "4.	Mixing equipments and softwares for editing\r\n" + "\r\n"  + "Response: "
					+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse434()
							: "")+"\r\n\r\n",font4));

			table434criteria4.addCell(cell434criteria4);
			
			table434criteria4.setSpacingBefore(20f);
			table434criteria4.setSpacingAfter(20f);

			document.add(table434criteria4);
       
			// 4.4
			Paragraph paragraph50 = new Paragraph("4.4 Maintenance of Campus Infrastructure\r\n\r\n", font2);
			paragraph50.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph50);

			// Creating a table of 3 columns


			PdfPTable table441criteria4 = new PdfPTable(1);
			PdfPTable table4411criteria4 = new PdfPTable(1);

			
			table441criteria4.setWidthPercentage(100);
			table4411criteria4.setWidthPercentage(100);


			PdfPCell cell441criteria4 = new PdfPCell(new Paragraph(
					"4.4.1 Average percentage expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component during the last five years\r\n\r\n"
							+ " Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria44Ql().get(0).getResponse441()
									: "")+"\r\n\r\n",font4));
			
			table441criteria4.addCell(cell441criteria4);
		
			PdfPCell cell4411criteria4 = new PdfPCell(new Paragraph(
					"4.4.1.1 Expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component year wise during the last five years (INR in lakhs)\r\n\r\n",font4));

			table4411criteria4.addCell(cell4411criteria4);
			

			table441criteria4.setSpacingBefore(20f);
			table441criteria4.setSpacingAfter(20f);

			document.add(table441criteria4);
			document.add(table4411criteria4);

			if (criteria4Record.getYearTable4411() != null) {

				Table table4411 = new Table(criteria4Record.getYearTable4411().size(), 2);

				table4411.setPadding(10);
				table4411.setWidth(100f);

				for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
					Cell cell1criteria4411 = new Cell (criteria4Record.getYearTable4411().get(i).getInput4411y());
					cell1criteria4411.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4411.addCell(cell1criteria4411);
					

				}
				for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
					Cell cell2criteria4411 = new Cell (criteria4Record.getYearTable4411().get(i).getInput4411v());
					cell2criteria4411.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4411.addCell(cell2criteria4411);
					
				}

				document.add(table4411);

			}
			
			
			if (criteria4Record.getYearTable44112() != null) {

				Table table44112 = new Table(criteria4Record.getYearTable44112().size(), 2);

				table44112.setPadding(10);
				table44112.setWidth(100f);

				for (int i = 0; i < criteria4Record.getYearTable44112().size(); i++) {
					Cell cell1criteria44112 = new Cell (criteria4Record.getYearTable44112().get(i).getInput44112y());
					cell1criteria44112.setHorizontalAlignment(Element.ALIGN_CENTER);
					table44112.addCell(cell1criteria44112);
					

				}
				for (int i = 0; i < criteria4Record.getYearTable44112().size(); i++) {
					Cell cell2criteria44112 = new Cell (criteria4Record.getYearTable44112().get(i).getInput44112v());
					cell2criteria44112.setHorizontalAlignment(Element.ALIGN_CENTER);
					table44112.addCell(cell2criteria44112);
					

				}

				document.add(table44112);

			}
			
			
			

			PdfPTable table26criteria4 = new PdfPTable(2);
			PdfPTable table422criteria4 = new PdfPTable(1);
			
			table422criteria4.setWidthPercentage(100);
			table26criteria4.setWidthPercentage(100);

			PdfPCell cell00123 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell00123.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell00123.setExtraParagraphSpace(10);
			
			PdfPCell cell00124 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell00124.setHorizontalAlignment(Element.ALIGN_CENTER);
		//	cell00124.setExtraParagraphSpace(10);
			
			PdfPCell cell00125 = new PdfPCell(new Paragraph(
					"\r\nUpload any additional information\r\n\r\n ",font5));
			cell00125.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00125.setExtraParagraphSpace(10);
			
			PdfPCell cell00126 = new PdfPCell(
					new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell00126.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00126.setExtraParagraphSpace(10);
			
			PdfPCell cell00127 = new PdfPCell(new Paragraph("\r\nAudited statements of accounts\r\n\r\n ",font5));
			cell00127.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00127.setExtraParagraphSpace(10);
			
			PdfPCell cell00128 = new PdfPCell(new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell00128.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00128.setExtraParagraphSpace(10);
			
			PdfPCell cell01 = new PdfPCell(new Paragraph("\r\nDetails about assigned budget and expenditure on physical facilities and academic facilities\r\n\r\n ",font5));
			cell01.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell01.setExtraParagraphSpace(10);
			
			PdfPCell cell02 = new PdfPCell(new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell02.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell02.setExtraParagraphSpace(10);
			
			table26criteria4.addCell(cell00123);
			table26criteria4.addCell(cell00124);
			table26criteria4.addCell(cell00125);
			table26criteria4.addCell(cell00126);
			table26criteria4.addCell(cell00127);
			table26criteria4.addCell(cell00128);
			table26criteria4.addCell(cell01);
			table26criteria4.addCell(cell02);
			table26criteria4.setSpacingAfter(20);
			table26criteria4.setSpacingBefore(20);

			document.add(table26criteria4);

			
			PdfPCell cell442criteria4 = new PdfPCell(new Paragraph(
					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\r\n\r\n"
							+ "\r\n" + "Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria44Ql().get(0).getResponse442()
									: "")+"\r\n\r\n",font4));
			
			table422criteria4.addCell(cell442criteria4);
	//		document.add(table422criteria4);
			

			PdfPTable table442criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table442criteria4.setWidthPercentage(100);

			PdfPCell cell4420criteria4 = new PdfPCell(new Paragraph(
					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\r\n\r\n"
							+ " Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria44Ql().get(0).getResponse442()
									: "")+"\r\n\r\n",font4));
			table442criteria4.addCell(cell4420criteria4);
		
			table442criteria4.setSpacingBefore(20f);
			table442criteria4.setSpacingAfter(20f);

		    document.add(table442criteria4);

			

			PdfPTable table27criteria4 = new PdfPTable(2);
			table27criteria4.setWidthPercentage(100);

			PdfPCell cell00129 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell00129.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00129.setExtraParagraphSpace(10);
			
			PdfPCell cell00130 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell00130.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00130.setExtraParagraphSpace(10);
			
			PdfPCell cell00131 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell00131.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00131.setExtraParagraphSpace(10);
			
			PdfPCell cell00132 = new PdfPCell(new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell00132.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00132.setExtraParagraphSpace(10);
			
			PdfPCell cell00133 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
			cell00133.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00133.setExtraParagraphSpace(10);
			
			PdfPCell cell00134 = new PdfPCell(new Paragraph("\r\n"+(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "")+"\r\n\r\n",font5));
			cell00134.setHorizontalAlignment(Element.ALIGN_CENTER);
	//		cell00134.setExtraParagraphSpace(10);
			

			table27criteria4.addCell(cell00129);
			table27criteria4.addCell(cell00130);
			table27criteria4.addCell(cell00131);
			table27criteria4.addCell(cell00132);
			table27criteria4.addCell(cell00133);
			table27criteria4.addCell(cell00134);

			table27criteria4.setSpacingBefore(20f);
			table27criteria4.setSpacingAfter(20f);

			document.add(table27criteria4);
			}
			
		public void Criteria5(Document document,Criteria5_FieldInfo criteria5Fieldinfo) {// 5.1
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
			
		}
				
		////////////////////6.1///////////////////////////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////
				public void Criteria6(Document document,Criteria6_FieldInfo criteria6Fieldinfo) {	// 6.1
					
					Paragraph paragraphcriteria06 = new Paragraph("Criterion 6 - Governance, Leadership and Management\r\n\r\n",
							font1);
					paragraphcriteria06.setAlignment(Paragraph.ALIGN_CENTER);
					document.add(paragraphcriteria06);
					
					
					Paragraph paragraph2criteria6 = new Paragraph("6.1	Institutional Vision and Leadership\r\n\r\n", font2);
					paragraph2criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
					document.add(paragraph2criteria6);

					PdfPTable table611criteria6 = new PdfPTable(1);
					table611criteria6.setWidthPercentage(100);
					PdfPCell cell01criteria6 = new PdfPCell(new Paragraph(
							"6.1.1: The governance of the institution is reflective of an effective leadership in tune with the vision and mission of the Institution.\r\n\r\n"
							+"Response: "
									+(criteria6Record != null ? criteria6Record.getCriteria61Ql().get(0).getResponse611()
											: "")+"\r\n\r\n",font4));
				//	cell1criteria6.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
					table611criteria6.addCell(cell01criteria6);
					document.add(table611criteria6);

//					Paragraph paragraph30criteria6 = new Paragraph(
//							(criteria6Record != null ? criteria6Record.getCriteria61Ql().get(0).getResponse611()
//									: "")+"\r\n\r\n",
//							font5);

				//	document.add(paragraph30criteria6);

					// create a table 1
					PdfPTable table1criteria6 = new PdfPTable(2);
					table1criteria6.setWidthPercentage(100);
					PdfPTable table110criteria6 = new PdfPTable(1);
					table110criteria6.setWidthPercentage(100);
					PdfPCell cell1criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell1criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell1criteria6.setExtraParagraphSpace(10);
					PdfPCell cell2criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell2criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell2criteria6.setExtraParagraphSpace(10);
					PdfPCell cell3criteria6 = new PdfPCell(new Paragraph("\r\nUpload Any aditional information\r\n\r\n",font5));
					cell3criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell3criteria6.setExtraParagraphSpace(10);
					PdfPCell cell4criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell4criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell4criteria6.setExtraParagraphSpace(10);
					PdfPCell cell5criteria6 = new PdfPCell(new Paragraph("\r\nPaste link for Any aditional information\r\n\r\n",font5));
					cell5criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell5criteria6.setExtraParagraphSpace(10);
					PdfPCell cell6criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell6criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell6criteria6.setExtraParagraphSpace(10);
					table1criteria6.addCell(cell1criteria6);
					table1criteria6.addCell(cell2criteria6);
					table1criteria6.addCell(cell5criteria6);
					table1criteria6.addCell(cell6criteria6);
					table1criteria6.addCell(cell3criteria6);
					table1criteria6.addCell(cell4criteria6);
					table1criteria6.setSpacingAfter(20);
					table1criteria6.setSpacingBefore(20);

					document.add(table1criteria6);
					
					// 6.2 
					
					
					Paragraph paragraph11criteria6 = new Paragraph("6.2  Strategy Development and Deployment\r\n\r\n",font2);
					paragraph11criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
					document.add(paragraph11criteria6);
			
					PdfPTable table3criteria6 = new PdfPTable(2);
					table3criteria6.setWidthPercentage(100);
					PdfPTable table31criteria6 = new PdfPTable(1);
					table31criteria6.setWidthPercentage(100);

					PdfPCell cell31criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell31criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell31criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell32criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell32criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell32criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell33criteria6 = new PdfPCell(
							new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
					cell33criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell33criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell34criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(5).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
					cell34criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell34criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell35criteria6 = new PdfPCell(new Paragraph("\r\nStrategic Plan and deployment documents on the website"
							+ "\r\n\r\n",font5));
					cell35criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell35criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell36criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(6).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
					cell36criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell36criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell37criteria6 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
					cell37criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell37criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell38criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(7).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
					cell38criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell38criteria6.setExtraParagraphSpace(10);
					
					
					table3criteria6.addCell(cell31criteria6);
					table3criteria6.addCell(cell32criteria6);
					table3criteria6.addCell(cell33criteria6);

					table3criteria6.addCell(cell34criteria6);
					table3criteria6.addCell(cell35criteria6);

					table3criteria6.addCell(cell36criteria6);
					table3criteria6.addCell(cell37criteria6);

					table3criteria6.addCell(cell38criteria6);

				//	table31criteria6.addCell(cell34criteria6);
					

				//	table3criteria6.addCell(cell35criteria6);
				//	table3criteria6.addCell(cell36criteria6);

					PdfPCell cell312 = new PdfPCell(
							new Paragraph("6.2.1	The institutional Strategic / Perspective plan is effectively deployed\r\n\r\n" + ""
									+ "" + "Response: "
									+ (criteria6Record != null
									? criteria6Record.getCriteria62Ql().get(0).getResponse621()
									: "")+"\r\n\r\n",
									font4));
					
//					PdfPCell cell3120 = new PdfPCell(
//							new Paragraph((criteria6Record != null
//											? criteria6Record.getCriteria62Ql().get(0).getInput621t1()
//											: ""),
//									font5));
					
					table31criteria6.addCell(cell312);
//					table31criteria6.addCell(cell3120);



				//	table31criteria6.addCell(table3criteria6);
				//	table31criteria6.setSpacingAfter(20f);
					
					document.add(table31criteria6);
					table3criteria6.setSpacingBefore(20);
					table3criteria6.setSpacingAfter(20);
					document.add(table3criteria6);
					

			//create table 4
					PdfPTable table4criteria6 = new PdfPTable(2);
					table4criteria6.setWidthPercentage(100);
					PdfPTable table41criteria6 = new PdfPTable(1);
					table41criteria6.setWidthPercentage(100);

					PdfPCell cell41criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell41criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell41criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell42criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell42criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell42criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell43criteria6 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
					cell43criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell43criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell44criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(8).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell44criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell44criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell45criteria6 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
					cell45criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell45criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell46criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(9).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
					cell46criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell46criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell47criteria6 = new PdfPCell(new Paragraph("\r\nLink to Organogram of the Institution webpage\r\n\r\n ",font5));
					cell47criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell47criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell48criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(10).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
					cell48criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell48criteria6.setExtraParagraphSpace(10);
					
					table4criteria6.addCell(cell41criteria6);
					table4criteria6.addCell(cell42criteria6);
					table4criteria6.addCell(cell43criteria6);
					table4criteria6.addCell(cell44criteria6);
					table4criteria6.addCell(cell45criteria6);
					table4criteria6.addCell(cell46criteria6);
					table4criteria6.addCell(cell47criteria6);
					table4criteria6.addCell(cell48criteria6);
					PdfPCell cell41x = new PdfPCell(new Paragraph(
							"6.2.2	The functioning of the institutional bodies is effective and efficient as visible from policies, administrative setup, appointment, service rules and procedures, etc."
									+ "\r\n" + "\r\n" + "Response:"
									+ (criteria6Record != null
											? criteria6Record.getCriteria62Ql().get(0).getInput622t1()
											: "")+"\r\n\r\n",
							font4));
//					PdfPCell cell410 = new PdfPCell(new Paragraph(
//							(criteria6Record != null
//											? criteria6Record.getCriteria62Ql().get(0).getInput622t1()
//											: ""),
//							font5));
					
					
					table41criteria6.addCell(cell41x);
//					table41criteria6.addCell(cell410);
					

				//	table41criteria6.addCell(table4criteria6);
				//	table41criteria6.setSpacingAfter(20f);
					document.add(table41criteria6);
					
					table4criteria6.setSpacingAfter(20);
					table4criteria6.setSpacingBefore(20);
					document.add(table4criteria6);
					
			//create table5
					PdfPTable table5criteria6 = new PdfPTable(2);
					table5criteria6.setWidthPercentage(100);
					PdfPTable table51criteria6 = new PdfPTable(1);
					table51criteria6.setWidthPercentage(100);

					PdfPCell cell51criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell51criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell51criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell52criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell52criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell52criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell53criteria6 = new PdfPCell(new Paragraph("\r\nScreen shots of user interfaces\r\n\r\n",font5));
					cell53criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell53criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell54criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(11).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell54criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell54criteria6.setExtraParagraphSpace(10);
					
					//cell54criteria6.setBackgroundColor(Align:);
					PdfPCell cell55criteria6 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n",font5));
					cell55criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell55criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell56criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(12).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell56criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell56criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell57criteria6 = new PdfPCell(new Paragraph("\r\nERP (Enterprise Resource Planning) Document\r\n\r\n",font5));
					cell57criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell57criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell58criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(13).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell58criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell58criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell59criteria6 = new PdfPCell(new Paragraph("\r\nLink for additional information\r\n\r\n",font5));
					cell59criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell59criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell60criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(14).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
					cell60criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell60criteria6.setExtraParagraphSpace(10);
					
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
					
					document.add(table51criteria6);
					table5criteria6.setSpacingAfter(20);
					table5criteria6.setSpacingBefore(20);
					
					document.add(table5criteria6);

					// 6.3 
					Paragraph paragraph12criteria6 = new Paragraph("6.3 Faculty Empowerment Strategies\r\n\r\n", font2);
					paragraph12criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);

					document.add(paragraph12criteria6);
					
					
					PdfPTable table631criteria6 = new PdfPTable(1);
					table631criteria6.setWidthPercentage(100f);

					PdfPCell cell631criteria6 = new PdfPCell(new Paragraph(
							"6.3.1 The institution has effective welfare measures for teaching and non-teaching staff\r\n"
							+ "\r\n"
							+ "Response: "
							+(criteria6Record != null
							? criteria6Record.getCriteria63Ql().get(0).getResponse631()
							:"")+"\r\n\r\n",font4));
					table631criteria6.addCell(cell631criteria6);
					document.add(table631criteria6);
					
					
//					Paragraph paragraph14criteria6=new Paragraph(criteria6Record != null
//											? criteria6Record.getCriteria63Ql().get(0).getResponse631()
//											:"",font5);
//					document.add(paragraph14criteria6);

					
					
			// create table6
					PdfPTable table6criteria6 = new PdfPTable(2);
					table6criteria6.setWidthPercentage(100);
					PdfPTable table61criteria6 = new PdfPTable(1);
					table61criteria6.setWidthPercentage(100);

					PdfPCell cell61criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell61criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell61criteria6.setExtraParagraphSpace(10);	
					
						
					PdfPCell cell62criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell62criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell62criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell63criteria6 = new PdfPCell(new Paragraph("\r\nStrategic Plan and deployment documents on the website\r\n\r\n",font5));
					cell63criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell63criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell64criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell64criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell64criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell65criteria6 = new PdfPCell(new Paragraph("\r\nPaste Link for additional information\r\n\r\n",font5));
					cell65criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell65criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell66criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell66criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell66criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell67criteria6 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
					cell67criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell67criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell68criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell68criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell68criteria6.setExtraParagraphSpace(10);
					
					table6criteria6.addCell(cell61criteria6);
					table6criteria6.addCell(cell62criteria6);
					table6criteria6.addCell(cell63criteria6);
					table6criteria6.addCell(cell64criteria6);
					table6criteria6.addCell(cell65criteria6);
					table6criteria6.addCell(cell66criteria6);
					table6criteria6.addCell(cell67criteria6);
					table6criteria6.addCell(cell68criteria6);
					table6criteria6.setSpacingAfter(20);
					table6criteria6.setSpacingBefore(20);
					document.add(table6criteria6);
					


					PdfPTable table632criteria6 = new PdfPTable(1);
					table632criteria6.setWidthPercentage(100f);

					PdfPCell cell632criteria6 = new PdfPCell(new Paragraph(
							"6.3.2 Average percentage of teachers provided with financial support to attend conferences / workshops and towards membership fee of professional bodies during the last five years.\r\n\r\n"
								 + "Response: "
									+(criteria6Record != null
									? criteria6Record.getCriteria63Qn().get(0).getResponse632()
									: "")+"\r\n\r\n",font4));
					
					table632criteria6.addCell(cell632criteria6);
					document.add(table632criteria6);
					
//					if(criteria6Record.getCriteria63Qn().size()>0)
//					{
//					Paragraph paragraph16criteria6=new Paragraph(criteria6Record != null
//											? criteria6Record.getCriteria63Qn().get(0).getResponse632()
//											: "", font5);
//					
//					document.add(paragraph16criteria6);
//					}
					if(criteria6Record.getCriteria63Qn().size()>0)
					{
					PdfPCell cell70 = new PdfPCell(new Paragraph(
							 (criteria6Record != null
											? criteria6Record.getCriteria63Qn().get(0).getInput632t1()
											: ""),
							font3));
					document.add(cell70);
				}
					
//					PdfPTable table6321criteria6 = new PdfPTable(1);
//					table6321criteria6.setWidthPercentage(100f);

					Paragraph paragraph6321Lcriteria6=new Paragraph(
							"6.3.2.1 Number of teachers provided with financial support to attend conferences/workshops and towards membership fee of professional bodies year wise during the last five years"
								+"\r\n\r\n",
							font4);
					
					document.add(paragraph6321Lcriteria6);
		//
//					table7criteria6.addCell(cell7x);
//			table7criteria6.addCell(cell70);
//					
//					table7criteria6.addCell(cell7y);
//					document.add(table7criteria6);
					// year table 6321
					
//					Paragraph paragraph46criteria6=new Paragraph("\r\n");
//					document.add(paragraph46criteria6);
//					document.add(paragraph46criteria6);

					if (criteria6Record.getYearTable6321().size()>0) {

						Table table6321criteria6 = new Table(criteria6Record.getYearTable6321().size(), 2);

						table6321criteria6.setPadding(5);
						table6321criteria6.setWidth(100f);
					//	table6321criteria6.addCell("year");
						for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
							Cell cell1criteria6321 = new Cell (criteria6Record.getYearTable6331().get(i).getInput6331y());
							cell1criteria6321.setHorizontalAlignment(Element.ALIGN_CENTER);
							table6321criteria6.addCell(cell1criteria6321);
							
						}
				//		table6321criteria6.addCell("Number");
						for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
							Cell cell2criteria6321 = new Cell (criteria6Record.getYearTable6331().get(i).getInput6331v());
							cell2criteria6321.setHorizontalAlignment(Element.ALIGN_CENTER);
							table6321criteria6.addCell(cell2criteria6321);
							
						}

						document.add(table6321criteria6);
					}
//					table71criteria6.setSpacingAfter(10f);
					
					
					
					Paragraph paragraph116criteria6=new Paragraph("\r\n");
					document.add(paragraph116criteria6);
					
					if (criteria6Record.getYearTable6321().size()>0) {

						Table table6321criteria6 = new Table(criteria6Record.getYearTable6321().size(), 2);

						table6321criteria6.setPadding(5);
						table6321criteria6.setWidth(100f);
					//	table6321criteria6.addCell("year");
						for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
							Cell cell1criteria63210 = new Cell (criteria6Record.getYearTable6331().get(i).getInput6331y());
							cell1criteria63210.setHorizontalAlignment(Element.ALIGN_CENTER);
							table6321criteria6.addCell(cell1criteria63210);
							
						}
				//		table6321criteria6.addCell("Number");
						for (int i = 0; i < criteria6Record.getYearTable6321().size(); i++) {
							Cell cell2criteria63210 = new Cell (criteria6Record.getYearTable6331().get(i).getInput6331v());
							cell2criteria63210.setHorizontalAlignment(Element.ALIGN_CENTER);
							table6321criteria6.addCell(cell2criteria63210);
							
						}

						document.add(table6321criteria6);
					}
					
					
					
					Paragraph paragraph26criteria6=new Paragraph("\r\n");
					document.add(paragraph26criteria6);
					
					
					
//					table61criteria6.addCell(table6criteria6);
//					document.add(table61criteria6);

			//create a table7
					PdfPTable table7criteria6 = new PdfPTable(1);
					table7criteria6.setWidthPercentage(100);
					PdfPTable table71criteria6 = new PdfPTable(2);
					table71criteria6.setWidthPercentage(100);
					
					PdfPCell cell71criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell71criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell71criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell72criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell72criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//					cell72criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell73criteria6 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
					cell73criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//					cell73criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell74criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell74criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
//					cell74criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell75criteria6 = new PdfPCell(new Paragraph("\r\nDetails of teachers provided with financial support to attend conference, workshops etc during the last five years\r\n\r\n",font5));
					cell75criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell75criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell76criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
					cell76criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell76criteria6.setExtraParagraphSpace(10);
					
					
					
					table71criteria6.addCell(cell71criteria6);
					table71criteria6.addCell(cell72criteria6);
					table71criteria6.addCell(cell73criteria6);
					table71criteria6.addCell(cell74criteria6);
					table71criteria6.addCell(cell75criteria6);
					table71criteria6.addCell(cell76criteria6);
					table71criteria6.setSpacingAfter(20);
					table71criteria6.setSpacingBefore(20);
					
					document.add(table71criteria6);
					
					
					
					PdfPTable table633criteria6 = new PdfPTable(1);
					table633criteria6.setWidthPercentage(100f);

					PdfPCell cell633criteria6 = new PdfPCell(new Paragraph(
							"6.3.3: The institution provides seed money to its teachers for research.\r\n\r\n"
					+ "Response: "
					+(criteria6Record != null
					? criteria6Record.getCriteria63Ql().get(0).getResponse633()
					: "")+"\r\n\r\n",font4));
					
					table633criteria6.addCell(cell633criteria6);
					table633criteria6.setSpacingAfter(20);
					table633criteria6.setSpacingBefore(20);
					document.add(table633criteria6);
					
					
//					if(criteria6Record.getCriteria63Ql().size()>0)
//					{
//					Paragraph paragraph136criteria6=new Paragraph((criteria6Record != null
//											? criteria6Record.getCriteria63Ql().get(0).getResponse633()
//											: ""),
//							font5); 
//					document.add(paragraph136criteria6);
//					
//					}

					Paragraph paragraph146criteria6=new Paragraph(
							"6.3.3.1 Total number of professional development /administrative training Programmes organized\r\n"
							+ "by the institution for teaching and non teaching staff year-wise during the last five years"
									+ ""+"\r\n",
							font4);
					document.add(paragraph146criteria6);
//					Paragraph paragraph156criteria6=new Paragraph("\r\n");
//					document.add(paragraph156criteria6);
					
					
					
					if (criteria6Record.getYearTable6331().size()>0) {

						Table table6331criteria6 = new Table(criteria6Record.getYearTable6331().size(), 2);

						table6331criteria6.setPadding(5);
						table6331criteria6.setWidth(100f);

						for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
							Cell cell1criteria63310 = new Cell (criteria6Record.getYearTable6331().get(i).getInput6331y());
							cell1criteria63310.setHorizontalAlignment(Element.ALIGN_CENTER);
							table6331criteria6.addCell(cell1criteria63310);
							
						}
						for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
							Cell cell2criteria63310 = new Cell (criteria6Record.getYearTable6331().get(i).getInput6331v());
							cell2criteria63310.setHorizontalAlignment(Element.ALIGN_CENTER);
							table6331criteria6.addCell(cell2criteria63310);
					
						}

						document.add(table6331criteria6);
					}
					
					
					if (criteria6Record.getYearTable6331().size()>0) {

						Table table6331tb2criteria6 = new Table(criteria6Record.getYearTable6331().size(), 2);

						table6331tb2criteria6.setPadding(5);
						table6331tb2criteria6.setWidth(100f);

						for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
							Cell cell1criteria633101 = new Cell (criteria6Record.getYearTable6331().get(i).getInput6331y());
							cell1criteria633101.setHorizontalAlignment(Element.ALIGN_CENTER);
							table6331tb2criteria6.addCell(cell1criteria633101);
							
						}
						for (int i = 0; i < criteria6Record.getYearTable6331().size(); i++) {
							Cell cell2criteria633101 = new Cell (criteria6Record.getYearTable6331().get(i).getInput6331v());
							cell2criteria633101.setHorizontalAlignment(Element.ALIGN_CENTER);
							table6331tb2criteria6.addCell(cell2criteria633101);
							
						}

						document.add(table6331tb2criteria6);
					}
					
					
					

			//create table 8
					PdfPTable table8criteria6 = new PdfPTable(1);
					table8criteria6.setWidthPercentage(100);
					
					PdfPTable table81criteria6 = new PdfPTable(2);
					table81criteria6.setWidthPercentage(100);
					PdfPCell cell81criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell81criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell81criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell82criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell82criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell82criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell83criteria6 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
					cell83criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell83criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell84criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell84criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell84criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell85criteria6 = new PdfPCell(new Paragraph("\r\nMinutes of the relevant bodies of the Institution\r\n\r\n",font5));
					cell85criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell85criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell86criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell86criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell86criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell87criteria6 = new PdfPCell(new Paragraph("\r\nBudget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized\r\n\r\n",font5));
					cell87criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell87criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell88criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell88criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell88criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell89criteria6 = new PdfPCell(new Paragraph("\r\nList of teachers receiving grant and details of grant received (Data Template)\r\n\r\n",font5));
					cell89criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell89criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell810criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell810criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell810criteria6.setExtraParagraphSpace(10);
					
					table81criteria6.addCell(cell81criteria6);
					table81criteria6.addCell(cell82criteria6);
					table81criteria6.addCell(cell83criteria6);
					table81criteria6.addCell(cell84criteria6);
					table81criteria6.addCell(cell85criteria6);
					table81criteria6.addCell(cell86criteria6);
					table81criteria6.addCell(cell87criteria6);
					table81criteria6.addCell(cell88criteria6);
					table81criteria6.addCell(cell89criteria6);
					table81criteria6.addCell(cell810criteria6);
					table81criteria6.setSpacingAfter(20);
					table81criteria6.setSpacingBefore(20);
					
					document.add(table81criteria6);
					
		           // 6.4
					
					Paragraph paragraph103criteria6 = new Paragraph("6.4 Financial Management and Resource Mobilization\r\n\r\n", font2);
					paragraph103criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
					document.add(paragraph103criteria6);
			//create table10
					

					com.lowagie.text.Font fontTitle5criteria6 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
					fontTitle5criteria6.setSize(10);

					PdfPTable table101criteria6 = new PdfPTable(1);
					table101criteria6.setWidthPercentage(100);

					PdfPCell cell10x = new PdfPCell(new Paragraph(
							"6.4.1	Institution conducts internal and external financial audits regularl:"+"\r\n\r\n"
					+"Response: "
					+ (criteria6Record != null
							? criteria6Record.getCriteria64Qn().get(0).getResponse642():"")+"\r\n\r\n", font4));
					table101criteria6.addCell(cell10x);
			//		document.add(table101criteria6);


//					PdfPCell cell100= new PdfPCell(new Paragraph(criteria6Record != null? criteria6Record.getCriteria64Qn().get(0).getInput641t1():"", font3));
//					table101criteria6.addCell(cell100);
					
					PdfPTable table10criteria6 = new PdfPTable(2);
					table10criteria6.setWidthPercentage(100);
					

					PdfPCell cell101criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell101criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell101criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell102criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell102criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell102criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell103criteria6 = new PdfPCell(new Paragraph(" \r\nUpload Any additional information\r\n\r\n",font5));
					cell103criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell103criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell104criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell104criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell104criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell105criteria6 = new PdfPCell(new Paragraph("\r\nPaste link for additional information/r/n/r/n",font5));
					cell105criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell105criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell106criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell106criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell106criteria6.setExtraParagraphSpace(10);
					
					
					table10criteria6.addCell(cell101criteria6);
					table10criteria6.addCell(cell102criteria6);
					table10criteria6.addCell(cell103criteria6);
					table10criteria6.addCell(cell104criteria6);
					table10criteria6.addCell(cell105criteria6);
					table10criteria6.addCell(cell106criteria6);
					
//					table101criteria6.addCell(
//							"A: Internal financial audit: The college constitutes an internal committee for conducting verification of assets/capital equipment as well as financial audit. The committee checks financial reporting compliance with policies as well as compliance with respect to legal aspects including applicability of the trust/society. The internal audit also verifies the achievement of operational goals and objectives, safe guarding of assets, effective and efficient use of resources.\r\n"
//									+ "\r\n"
//									+ "Audit of assets and capital equipment are conducted through stock verification by the committee and based on shortages reported, if any, action for write-off is taken with the approval of the competent authority and such items are removed from the asset registers. Similar action is taken in respect of books/journals/documents.\r\n"
//									+ "\r\n"
//									+ "The internal audit committee, besides inspecting the books of account and records maintained by the finance department, evaluates internal control system, particularly, in respect of purchases, scholarships etc. The audit report is submitted to Principal/Chairman and subsequently Principal directs departments to take follow up action for closing the deficiencies and making changes in systems and procedures as called for.\r\n"
//									+ "\r\n"
//									+ "B: External financial audit: Mother Teresa arranges to conduct external financial audit every year by an external auditing agency named Haribabu and Associates, a registered financial auditing company, located in Hyderabad. The same auditing agency has been conducting external audit since the inception of our college, i.e.,2005. The auditors verify the financial statements and books of accounts to certify the truth and fairness of the financial position and operating system prevalent. The auditors employ internal check by verifying arithmetical accuracy of books of accounts, authentication and validation of transaction and also checking the proper distinction between capital and revenue nature of transactions. Except for transactions involving petty amounts, all other payments are made by way of issuing account payee cheques, demand drafts and using the fund transfer facility of banks such as NEFT/RTGS, to maintain transparency and to minimize errors may likely to occur due to cash transactions. This makes the job of our auditor simple and more easy. The audit observations submitted to the management by the audit company are examined carefully and corrective actions taken, if any, wherever required. At the end of every financial year, IT returns are filed to income tax department. These include, income and expenditure statements audited by a chartered accountant.\r\n"
//									+ "\r\n"
//									+ "All the audit reports have been found to be in order. However, prior to external audit an internal audit is conducted through a Chartered Accountant (CA). In case of any errors. identified by CA, they will be rectified by the internal accounts staff as per the suggestion by the CA. These minor errors, if and when crept in, due to any oversight by accounting personnel, is verified and rectified, resulting in strengthening of the financial accounting and budgetary control systems.\r\n"
//									+ " \r\n" + "");
				//	table101criteria6.addCell(table10criteria6);
					table10criteria6.setSpacingAfter(20);
					table10criteria6.setSpacingBefore(20);
					document.add(table10criteria6);
					
					table101criteria6.setSpacingAfter(10f);
					table101criteria6.setSpacingAfter(20);
					table101criteria6.setSpacingBefore(20);
					document.add(table101criteria6);
					
			//create table 11
					PdfPTable table642criteria6 = new PdfPTable(1);
					table642criteria6.setWidthPercentage(100);
					PdfPCell cell11x = new PdfPCell(new Paragraph(
							"6.4.2 Funds / Grants received from non-government bodies, individuals, philanthropists during the last five years (not covered in Criterion III and V) (INR in Lakhs)\r\n"
									+ "\r\n" + "Response: "
									+ (criteria6Record != null
											? criteria6Record.getCriteria64Qn().get(0).getResponse642()
											: "")+"\r\n\r\n",
							font4));
					table642criteria6.addCell(cell11x);
					document.add(table642criteria6);
					
					
//					PdfPTable table6421criteria6 = new PdfPTable(1);
//					table6421criteria6.setWidthPercentage(100);
					
					Paragraph paragraph6421criteria6 = new Paragraph(
							"6.4.2.1 Total Grants received from non-government bodies, individuals, Philanthropers year-wise during the last five years (INR in Lakhs)"
									+"\r\n\r\n",
							font4);
					document.add(paragraph6421criteria6);
				//	table6421criteria6.addCell(paragraph6421criteria6);
			//		document.add(table6421criteria6);
			//create table 6421

					if (criteria6Record.getYearTable6421().size()>0) {

						Table table6421 = new Table(criteria6Record.getYearTable6421().size(), 2);

						table6421.setPadding(5);
						table6421.setWidth(100f);

						for (int i = 0; i < criteria6Record.getYearTable6421().size(); i++) {
							Cell cell1criteria64210 = new Cell (criteria6Record.getYearTable6421().get(i).getInput6421y());
							cell1criteria64210.setHorizontalAlignment(Element.ALIGN_CENTER);
							table6421.addCell(cell1criteria64210);
							
						}
						for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
							Cell cell2criteria64210 = new Cell (criteria6Record.getYearTable6421().get(i).getInput6421v());
							cell2criteria64210.setHorizontalAlignment(Element.ALIGN_CENTER);
							table6421.addCell(cell2criteria64210);
							
						}

						document.add(table6421);
					}

					PdfPTable table111criteria6 = new PdfPTable(2);
					table111criteria6.setWidthPercentage(100);
					
					PdfPCell cell111criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell111criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell111criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell112criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell112criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell112criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell113criteria6 = new PdfPCell(new Paragraph("\r\nDetails of Funds / Grants received from of the nongovernment bodies, individuals, Philanthropers during the last five years\r\n\r\n",font5));
					cell113criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell113criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell114criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell114criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell114criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell115criteria6 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
					cell115criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell115criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell116criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell116criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell116criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell117criteria6 = new PdfPCell(new Paragraph("\r\nAnnual statements of accounts\r\n\r\n",font5));
					cell117criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell117criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell118criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell118criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell118criteria6.setExtraParagraphSpace(10);
					
					table111criteria6.addCell(cell111criteria6);
					table111criteria6.addCell(cell112criteria6);
					table111criteria6.addCell(cell113criteria6);
					table111criteria6.addCell(cell114criteria6);
					table111criteria6.addCell(cell115criteria6);
					table111criteria6.addCell(cell116criteria6);
					table111criteria6.addCell(cell117criteria6);
					table111criteria6.addCell(cell118criteria6);
					table111criteria6.setSpacingAfter(20);
					table111criteria6.setSpacingBefore(20);
					
					document.add(table111criteria6);
					
					
					
			//CREATE TABLE12
					PdfPTable table12criteria6 = new PdfPTable(1);
					table12criteria6.setWidthPercentage(100);
					PdfPTable table121x = new PdfPTable(1);
					table121x.setWidthPercentage(100);

					PdfPCell cell12Y = new PdfPCell(new Paragraph(
							"6.4.3 Institutional strategies for mobilisation of funds and the optimal utilisation of resources."+"\r\n\r\n"+ "Response:\r\n"
									+ "Resource Mobilization Policy and Procedures\r\n" 
									+ "The policy of Mother Teresa with regard to mobilization of funds is as follows:\r\n" 
									+ "Internal: Tuition fee, NBA fee, Training fee, transport fee and other miscellaneous fees collected from students.\r\n"
								  + "External: "+"\r\n\r\n" ,
							font4));
					table12criteria6.addCell(cell12Y);
					table12criteria6.setSpacingAfter(20);
					table12criteria6.setSpacingBefore(20);
					document.add(table12criteria6);
					
//					table121x.addCell(
//							"Procedure: The accounts section of the college prepares, month-wise cash flow statements, at least two months in advance. The cash outflow statement is based on institutional budget estimates and additional inputs form departments for unanticipated major expenses, and contingency expenses. The cash inflow (income) statement is prepared based on the schedules for admissions, commencement of classes indicated in the Academic calendar, and examination time tables. The Accounts department notifies the fee payment schedules to students to align with cash requirements as per projected cash inflow statement. If there are indications of fee collection being short of estimates, vigorous efforts are made through academic department staff and fee counselor to increase the receipts. The gap between the actual income and the estimated expenses is bridged through loans from banks/non-bank financial institutions as per the policy guidelines.\r\n"
//									+ "\r\n"
//									+ "Periodically, a review of the adequacy of limits for term and operational loans sanctioned by banks is carried out by the college management and the Principal. If the sanctioned limits are found to be inadequate, the banks are approached for enhancement of the sanctioned limits, with proper justification.\r\n"
//									+ "");
				//	table121x.addCell(table12criteria6);
					document.add(table121x);

			//create table 121
					PdfPTable table121criteria6 = new PdfPTable(2);
					table121criteria6.setWidthPercentage(100);
					PdfPCell cell121criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell121criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell121criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell122criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell122criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell122criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell123criteria6 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
					cell123criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell123criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell124criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
					cell124criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell124criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell125criteria6 = new PdfPCell(new Paragraph("\r\nPaste link for additional information \r\n\r\n",font5));
					cell125criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell125criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell126criteria6 = new PdfPCell(new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(2).getCriteria6FilePath() :"")+"\r\n\r\n",font5));
					cell126criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell126criteria6.setExtraParagraphSpace(10);
					
					table121criteria6.addCell(cell121criteria6);
					table121criteria6.addCell(cell122criteria6);
					table121criteria6.addCell(cell123criteria6);
					table121criteria6.addCell(cell124criteria6);
					table121criteria6.addCell(cell125criteria6);
					table121criteria6.addCell(cell126criteria6);
					table121criteria6.setSpacingAfter(20);
					table121criteria6.setSpacingBefore(20);
					
					
					document.add(table121criteria6);

					
					// 6.5
					Paragraph paragraph104criteria6 = new Paragraph("6.5 Internal Quality Assurance System\r\n\r\n", font2);
					paragraph104criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
					document.add(paragraph104criteria6);
			//cretae table 13
					PdfPTable table13criteria6 = new PdfPTable(1);
					table13criteria6.setWidthPercentage(100);

					PdfPTable table651criteria6 = new PdfPTable(1);
					table651criteria6.setWidthPercentage(100f);


					PdfPCell cell651criteria6 = new PdfPCell(new Paragraph(
							"6.5.1 Internal Quality Assurance Cell (IQAC) has contributed significantly for institutionalizing the quality assurance strategies and processes visible in terms of � Incremental improvements made for the preceding five years with regard to quality (in case of first cycle) Incremental improvements made for the preceding five years with regard to quality and post accreditation quality initiatives (second and subsequent cycles)\r\n\r\n"
									 + "Response: "
									+(criteria6Record != null
									? criteria6Record.getCriteria65Qn().get(0).getResponse651():" " )+"\r\n\r\n",font4));
					
					table651criteria6.addCell(cell651criteria6);
					document.add(table651criteria6);
					
//					if(criteria6Record.getCriteria65Qn().get(0).getResponse651() !=null)
//					{
		//
//						Paragraph paragraph160criteria6 = new Paragraph(criteria6Record != null
//										? criteria6Record.getCriteria65Qn().get(0).getResponse651()
//										: "",font5);
//					document.add(paragraph160criteria6);
				
//			}
//					
//					PdfPCell cell130= new PdfPCell(new Paragraph(
//							(criteria6Record != null
//											? criteria6Record.getCriteria6FieldInfoQl().get(0).getInput651t1()
//											: ""),
//							font3));
					
					
//					table13criteria6.addCell(cell13x);
//			        table13criteria6.addCell(cell130);
//					document.add(table13criteria6);
					
			//create table 2reforms
					PdfPTable table131criteria6 = new PdfPTable(2);
					table131criteria6.setWidthPercentage(100);

					PdfPTable table130criteria6 = new PdfPTable(1);
					table130criteria6.setWidthPercentage(100);

					PdfPCell cell131criteria6 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell131criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell131criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell132criteria6 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell132criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell132criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell133criteria6 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
					cell133criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell133criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell134criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell134criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell134criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell135criteria6 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
					cell135criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell135criteria6.setExtraParagraphSpace(10);
					
					PdfPCell cell136criteria6 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(1).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell136criteria6.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell136criteria6.setExtraParagraphSpace(10);
					
					
					table131criteria6.addCell(cell131criteria6);
					table131criteria6.addCell(cell132criteria6);
					table131criteria6.addCell(cell133criteria6);
					table131criteria6.addCell(cell134criteria6);
					table131criteria6.addCell(cell135criteria6);
					table131criteria6.addCell(cell136criteria6);
					table131criteria6.setSpacingAfter(20);
					table131criteria6.setSpacingBefore(20);
					document.add(table131criteria6);

					
					PdfPTable table653criteria6 = new PdfPTable(1);
					table653criteria6.setWidthPercentage(100f);


					PdfPCell cell653criteria6 = new PdfPCell(new Paragraph(
							new Paragraph("6.5.3	Quality assurance initiatives of the institution include:\r\n"
									+ "1.	Regular meeting of Internal Quality Assurance Cell (IQAC); Feedback collected, analysed and used for improvements\r\n"
									+ "2.	Collaborative quality initiatives with other institution(s)\r\n"
									+ "3.	Participation in NIRF\r\n"
									+ "4.	Any other quality audit recognized by state, national or international agencies (ISO Certification\r\n\r\n"
									+ "Response: "
									+(criteria6Record != null
									? criteria6Record.getCriteria65Qn().get(0).getResponse653():"")+"\r\n\r\n",font4)));
					table653criteria6.addCell(cell653criteria6);
					table653criteria6.setSpacingAfter(20);
					table653criteria6.setSpacingBefore(20);
							document.add(table653criteria6);
							
							
//							Paragraph paragraph215criteria6 = new Paragraph(criteria6Record != null
//											? criteria6Record.getCriteria65Qn().get(0).getResponse653()
//											: "",font5);
							
//							document.add(paragraph215criteria6);
			// cretae653
					PdfPTable table151criterion6 = new PdfPTable(2);
					table151criterion6.setWidthPercentage(100);
					PdfPCell cell151 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
					cell151.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell151.setExtraParagraphSpace(10);
				
					PdfPCell cell152 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
					cell152.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell152.setExtraParagraphSpace(10);
					
					PdfPCell cell153 = new PdfPCell(new Paragraph("\r\nPaste web link of Annual reports of Institution\r\n\r\n",font5));
					cell153.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell153.setExtraParagraphSpace(10);
					
					PdfPCell cell154 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell154.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell154.setExtraParagraphSpace(10);
					
					PdfPCell cell155 = new PdfPCell(new Paragraph("\r\nUpload e-copies of the accreditations and certifications\r\n\r\n",font5));
					cell155.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell155.setExtraParagraphSpace(10);
					
					PdfPCell cell156 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell156.setHorizontalAlignment(Element.ALIGN_CENTER);
				//	cell156.setExtraParagraphSpace(10);
					
					PdfPCell cell157 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
					cell157.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell157.setExtraParagraphSpace(10);
				
					PdfPCell cell158 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell158.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell158.setExtraParagraphSpace(10);
					
					PdfPCell cell159 = new PdfPCell(new Paragraph("\r\nUpload details of quality assurance initiatives of the institution\r\n\r\n",font5));
					cell159.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell159.setExtraParagraphSpace(10);
					
					PdfPCell cell160 = new PdfPCell(
							new Paragraph("\r\n"+(criteria6Record != null ? criteria6file.get(0).getCriteria6FilePath() : "")+"\r\n\r\n",font5));
					cell160.setHorizontalAlignment(Element.ALIGN_CENTER);
			//		cell160.setExtraParagraphSpace(10);
					

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
				    table151criterion6.setSpacingAfter(10f);
					document.add(table151criterion6);
					}
								
	public void Criteria7(Document document ,Criteria7_FieldInfo criteria7Fieldinfo) {
		// 7.1
		
		
		Paragraph paragraphcriteria7 = new Paragraph("Criterion 7 - Institutional Values and Best Practices\r\n\r\n",
				font1);
		paragraphcriteria7.setAlignment(Paragraph.ALIGN_CENTER);
		PdfPCell cell5criteria7 = new PdfPCell();
		cell5criteria7.setPadding(5);
		document.add(cell5criteria7);

	
		document.add(paragraphcriteria7);
		Paragraph paragraph2criteria7 = new Paragraph("7.1 Institutional Values and Social Responsibilities\r\n", font2);
		paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
       document.add(paragraph2criteria7);
		
		

		PdfPTable table711criteria7 = new PdfPTable(1);
		table711criteria7.setWidthPercentage(100f);


		PdfPCell cell711criteria7 = new PdfPCell(new Paragraph(
				"7.1.1	Measures initiated by the Institution for the promotion of gender equity during the last five years.\r\n\r\n"
				+ ""
					 + "Response: "
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Ql().get(0).getResponse711()
								: "")+"\r\n\r\n",
				font4));
		
		

//		PdfPCell cell7110criteria7 = new PdfPCell(new Paragraph(
//			(criteria7Record != null
//								? criteria7Record.getCriteria71Ql().get(0).getInput711t1()
//								: ""),
//				font5));
		
		
		
		

		table711criteria7.addCell(cell711criteria7);
//		table711criteria7.addCell(cell7110criteria7);
		table711criteria7.setSpacingBefore(20f);
		table711criteria7.setSpacingAfter(20f);
        document.add(table711criteria7);

		// paragaph3
		//document.add(paragraph3criteria7);
		

		

		

		
		PdfPTable tablecriteria7 = new PdfPTable(2);
		tablecriteria7.setWidthPercentage(100f);
		PdfPTable tablecriteria07 = new PdfPTable(1);
		tablecriteria07.setWidthPercentage(100f);

	

		PdfPCell cell111criteria7 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
		cell111criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell112criteria7 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell112criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1113criteria7 = new PdfPCell(new Paragraph("\r\nLink for specific facilities provided for women interms of: a. Safety and security b. Counselling c.Common Rooms d. Day care center for youngchildren e. Any other relevant information\r\n\r\n",font5));
		cell1113criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1114criteria7 = new PdfPCell(
				new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
		cell1114criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell115criteria7 = new PdfPCell(new Paragraph("\r\nLink for annual gender sensitization action plan\r\n\r\n",font5));
		cell115criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell116criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
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

		

		PdfPCell cell4criteria7 = new PdfPCell();

		//cell1criteria7.setPadding(5);
		document.add(cell4criteria7);

		// table1
		PdfPTable table1criteria7 = new PdfPTable(2);
		PdfPTable table1criteria71 = new PdfPTable(1);

		table1criteria7.setWidthPercentage(100f);
		table1criteria71.setWidthPercentage(100f);

	

		PdfPCell cell113criteria7 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
		cell113criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell114criteria7 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell114criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell11104criteria7 = new PdfPCell(new Paragraph("\r\nGeotagged Photographs\r\n\r\n",font5));
		cell11104criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1117criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
		cell1117criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1190criteria7 = new PdfPCell(new Paragraph("\r\nAny other relevant information\r\n\r\n",font5));
		cell1190criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1191criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
		cell1191criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table1criteria7.addCell(cell113criteria7);
		table1criteria7.addCell(cell114criteria7);
		// table1.addCell(cell1113);
		table1criteria7.addCell(cell11104criteria7);
		table1criteria7.addCell(cell1117criteria7);
		table1criteria7.addCell(cell1190criteria7);
		table1criteria7.addCell(cell1191criteria7);
		table1criteria7.setSpacingAfter(20);
		table1criteria7.setSpacingBefore(20);
		
		document.add(table1criteria7);

		PdfPCell cell071 = new PdfPCell(new Paragraph(
				"7.1.2	The Institution has facilities for alternate sources of energy and energy conservation measures\r\n"
						+ "\r\n" + "1.	Solar energy\r\n" + "2.	Biogas plant\r\n" + "3.	Wheeling to the Grid\r\n"
						+ "4.	Sensor-based energy conservation\r\n"
						+ "5.	Use of LED bulbs/ power efficient equipment\r\n" + "\r\n" + "Response: "
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse712()
								: "")+"\r\n\r\n",
				font4));
//		PdfPCell cell0710 = new PdfPCell(new Paragraph(
//				 (criteria7Record != null
//								? criteria7Record.getCriteria71Qn().get(0).getInput712t1()
//								: ""),
//				font5));
		

		table1criteria71.addCell(cell071);
//		table1criteria71.addCell(cell0710);
//		table1criteria71.addCell(table1criteria7);

		table1criteria71.setSpacingBefore(20f);
		table1criteria71.setSpacingAfter(20f);

		document.add(table1criteria71);
		
		

		PdfPCell cell6criteria7 = new PdfPCell();
		cell6criteria7.setPadding(5);
		document.add(cell6criteria7);

		// 7.1.3
		
		PdfPTable table01criteria7 = new PdfPTable(2);
		table01criteria7.setWidthPercentage(100f);

		PdfPCell cell21criteria7 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
		cell21criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell22criteria7 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell22criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell23criteria7 = new PdfPCell(new Paragraph("\r\nReports on environment and energy audits submitted by the auditing agency\r\n\r\n",font5));
		cell23criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell24criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
		cell24criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell25criteria7 = new PdfPCell(new Paragraph("\r\nCertification by the auditing agency	\r\n\r\n",font5));
		cell25criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell26criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
		cell26criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell27criteria7 = new PdfPCell(new Paragraph("\r\nCertificates of the awards received	\r\n\r\n",font5));
		cell27criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell28criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
		cell28criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell cell29criteria7 = new PdfPCell(new Paragraph("\r\nAny other relevant information	\r\n\r\n",font5));
		cell29criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell30criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
		cell30criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		
		
		table01criteria7.addCell(cell21criteria7);
		table01criteria7.addCell(cell22criteria7);
		table01criteria7.addCell(cell23criteria7);
		table01criteria7.addCell(cell24criteria7);
		table01criteria7.addCell(cell25criteria7);
		table01criteria7.addCell(cell26criteria7);
		table01criteria7.addCell(cell27criteria7);
		table01criteria7.addCell(cell28criteria7);
		table01criteria7.addCell(cell29criteria7);
		table01criteria7.addCell(cell30criteria7);
		
		
//		Paragraph paragraph16criteria7 = new Paragraph(
//				"7.1.3 Describe the facilities in the Institution for the management of the following types of\r\n"
//						+ "degradable and non-degradable waste (within 500 words)\r\n",
//				font3);
//		document.add(paragraph16criteria7);

		PdfPCell cell10 = new PdfPCell();
		cell10.setPadding(10);

		PdfPTable table713criteria7 = new PdfPTable(1);
		table713criteria7.setWidthPercentage(100f);

		
		PdfPCell cell713criteria7 = new PdfPCell(new Paragraph(
				"7.1.3 Describe the facilities in the Institution for the management of the following types of degradable and non-degradable waste (within 500 words)\r\n"
						+ "\r\n"
						+ "Solid waste management"+" Liquid waste management"+" Biomedical waste management"+" E-waste management\r\n"
						+ "Waste recycling system\r\n" + "Hazardous chemicals and radioactive waste management\r\n\r\n"
						+ "Response: "
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse713()
								: "")+"\r\n\r\n",
				font4));

//		PdfPCell cell7130criteria7 = new PdfPCell(new Paragraph(
//				(criteria7Record != null
//								? criteria7Record.getCriteria71Qn().get(0).getInput713t1()
//								: ""),
//				font5));
		
		
		table713criteria7.addCell(cell713criteria7);
	//	table713criteria7.addCell(cell7130criteria7);
		table713criteria7.setSpacingBefore(20f);
		table713criteria7.setSpacingAfter(20f);

		document.add(table713criteria7);
		table01criteria7.setSpacingAfter(20);
		table01criteria7.setSpacingBefore(20);
		document.add(table01criteria7);

		///////////

		PdfPTable table3criteria7 = new PdfPTable(2);
		PdfPTable table3criteria71 = new PdfPTable(1);
		table3criteria7.setWidthPercentage(100f);
		table3criteria71.setWidthPercentage(100f);

		
		PdfPCell cell61criteria7 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
		cell61criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell62criteria7 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
		cell62criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell63criteria7 = new PdfPCell(new Paragraph("\r\nSupporting documents on the information provided (as reflected in the administrative and academic activities of the Institution)\r\n\r\n",font5));
		cell63criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell64criteria7 = new PdfPCell(
				new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
		cell64criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell65criteria7 = new PdfPCell(new Paragraph("\r\nAny other relevant information\r\n\r\n",font5));
		cell65criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell66criteria7 = new PdfPCell(
				new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
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
						+ "5.	Maintenance of water bodies and distribution system in the campus\r\n\r\n" + "Response: "
						+ (criteria7Record != null
								? criteria7Record.getCriteria71Qn().get(0).getResponse714()
								: "")+"\r\n\r\n",
						font4));

		table3criteria71.addCell(cell072);

	//	table3criteria71.addCell(table3criteria7);

		table3criteria71.setSpacingBefore(20f);
		table3criteria71.setSpacingAfter(20f);

		document.add(table3criteria71);
		table3criteria7.setSpacingAfter(20);
		table3criteria7.setSpacingBefore(20);
		
		document.add(table3criteria7);

		// 7.2
		
		Paragraph paragraph46criteria7 = new Paragraph("7.2 Best Practices\r\n",font2);
		paragraph46criteria7.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph46criteria7);

		PdfPTable table721criteria7 = new PdfPTable(1);
		table721criteria7.setWidthPercentage(100f);

		

		PdfPCell cell721criteria7 = new PdfPCell(new Paragraph(
				"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format provided in the Manual."
						+ "\r\n\r\n" + "Response: "
						+ (criteria7Record != null
								? criteria7Record.getCriteria72Ql().get(0).getResponse721()
								: "")+"\r\n\r\n",
				font4));
//		PdfPCell cell7210criteria7 = new PdfPCell(new Paragraph(
//				 (criteria7Record != null
//								? criteria7Record.getCriteria72Ql().get(0).getInput721t1()
//								: ""),
//				font5));
		
		

		table721criteria7.addCell(cell721criteria7);
//		table721criteria7.addCell(cell7210criteria7);
		
		table721criteria7.setSpacingBefore(20);
		table721criteria7.setSpacingAfter(20);
        document.add(table721criteria7);

		
		// table5
		PdfPTable table5criteria7 = new PdfPTable(2);
		table5criteria7.setWidthPercentage(100);

		PdfPCell cell1110 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n",font4));
		cell1110.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1134 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n",font4));
		cell1134.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1135 = new PdfPCell(new Paragraph("\r\nBest practices in the Institutional web site\r\n\r\n",font5));
		cell1135.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1136 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
		cell1136.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1137 = new PdfPCell(new Paragraph("\r\nAny other relevant information\r\n\r\n",font5));
		cell1137.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell1138 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
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
		Paragraph paragraph88 = new Paragraph("7.3 Institutional Distinctiveness \r\n", font2);
		paragraph88.setAlignment(Element.ALIGN_JUSTIFIED);
		document.add(paragraph88);

	

		PdfPTable table731criteria7 = new PdfPTable(1);
		table731criteria7.setWidthPercentage(100f);

		

		PdfPCell cell731criteria7 = new PdfPCell(new Paragraph(
				"7.3.1 Portray the performance of the Institution in one area distinctive to its priority and thrust within 1000 words\r\n"
						+ "\r\n" + "Response: "
						+ (criteria7Record != null
								? criteria7Record.getCriteria73Ql().get(0).getResponse731()
								: "")+"\r\n\r\n",
				font4));
		
		
//		PdfPCell cell7310criteria7 = new PdfPCell(new Paragraph(
//				 (criteria7Record != null
//								? criteria7Record.getCriteria73Ql().get(0).getInput731t1()
//								: ""),
//				font5));
		
		
		

		table731criteria7.addCell(cell731criteria7);
	//	table731criteria7.addCell(cell7310criteria7);
		table731criteria7.setSpacingBefore(20);
		table731criteria7.setSpacingAfter(20);
        document.add(table731criteria7);

	

		PdfPTable table7criteria7 = new PdfPTable(2);
		table7criteria7.setWidthPercentage(100);

		PdfPTable table70criteria7 = new PdfPTable(2);
		table70criteria7.setWidthPercentage(100);

		
		PdfPCell cell202criteria7 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n",font4));
		cell202criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell203criteria7 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n",font4));
		cell203criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell204criteria7 = new PdfPCell(new Paragraph("\r\nAppropriate web in the Institutional website\r\n\r\n",font5));
		cell204criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell205criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(3).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
		cell205criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell206criteria7 = new PdfPCell(new Paragraph("\r\nAny other relevant information\r\n\r\n",font5));
		cell206criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell207criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(2).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
		cell207criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table7criteria7.addCell(cell202criteria7);
		table7criteria7.addCell(cell203criteria7);
		table7criteria7.addCell(cell204criteria7);
		table7criteria7.addCell(cell205criteria7);
		table7criteria7.addCell(cell206criteria7);
		table7criteria7.addCell(cell207criteria7);
		table7criteria7.setSpacingAfter(20);
		table7criteria7.setSpacingBefore(20);
		
		
		document.add(table7criteria7);
		}
				
	
      

		}


