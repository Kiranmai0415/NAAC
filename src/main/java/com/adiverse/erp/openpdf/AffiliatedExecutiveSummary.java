package com.adiverse.erp.openpdf;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adiverse.erp.model.EvaluativeFileUpload;
import com.adiverse.erp.model.ExecutiveSummary;
import com.adiverse.erp.model.Executive_FileUpload;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.service.ExecutiveService;
import com.adiverse.erp.service.SsrService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class AffiliatedExecutiveSummary {
	
	@Autowired
	SsrService ssrService;
	
	
	@Autowired
	ExecutiveService  executiveService;

	@Value("${logoImgPath}")
	private String logoImgPath;

	@Value("${logoImgScale}")
	private Float[] logoImgScale;

      @Value("${upload.files.path}")
	  private String reportGeneratePath;
      
      private static final float marginLeft = 11;

      private static final  float marginBottom=9;


      private static final float marginTop=18;
      private static final float marginRight =19;
      
      
      

	public Image headerImage;

	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);

	List<ProfileoftheCollege> profileList = null;
	ProfileoftheCollege ProfileRecord = null;
	List<EvaluativeFileUpload> Profilefile = null;

	List<ExecutiveSummary>executiveSummary1 = null;
	ExecutiveSummary executiveData = null;
	
	List<Executive_FileUpload> executive_FileUpload1 = null;
	Executive_FileUpload executive_FileUpload = null;
	
	
	
	public String generateReport(Map<String, String> allParams) throws DocumentException, IOException {
		String reportPath = "";
		Path root = Paths.get(reportGeneratePath);
		Path file = null;
		Date date = new Date();
		try {
			font1.setSize(16);
			font2.setSize(14);
			font3.setSize(13);
			font4.setSize(12);
			font5.setSize(12);
			
			
			profileList=ssrService.getAllSsrData();
			if (CollectionUtils.isNotEmpty(profileList)) {
				ProfileRecord = profileList.get(0);
			} else {
				ProfileRecord = new ProfileoftheCollege();
			}
			
			executiveSummary1=	executiveService.getAllExecutiveData(allParams);
			if (CollectionUtils.isNotEmpty(executiveSummary1)) {
				executiveData = executiveSummary1.get(0);
			} else {
				executiveData = new ExecutiveSummary();
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
                PdfWriter writer =  PdfWriter.getInstance(document,  new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
	
		
	

            Rectangle pageDimensions = writer.getPageSize( );
				PdfContentByte canvas = writer.getDirectContent();
				Rectangle rect= new Rectangle(36,108);
					
					
					canvas.saveState();
					canvas.rectangle(
					        pageDimensions.getLeft(marginLeft),
					        pageDimensions.getBottom(marginBottom),
					        pageDimensions.getRight(marginRight),
					        pageDimensions.getTop(marginTop));
					canvas.setColorStroke(Color.black);
					canvas.stroke();
					canvas.restoreState();

			
			


/////////////////////////////////////////////////////////
///////////////////// SSR SSR SSR SSR..................................
///////////////////////////////////////

// Creating font
// Setting font style and size

///////////////////////////////////////////////////////////////////////////////////////////////////////////
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

		Paragraph paragraph22ssr = new Paragraph(executiveData != null ?executiveData.getInputes1():
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

		Paragraph paragraph25ssr = new Paragraph("VISION", font3);
		paragraph25ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph25ssr);
		
		

//		Paragraph paragraph26ssr = new Paragraph(
//				"To provide the society with center of learning that motivates, supports and encourages the youth to involve into dynamic professional with a social commitmenty.\r\n"
//						+ "\r\n",
//			//	font5);

		Paragraph paragraph26ssr = new Paragraph(executiveData != null ?executiveData.getInputes2():"");
		
		paragraph26ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph26ssr);

		Paragraph paragraph27ssr = new Paragraph("MISSION", font3);
		paragraph27ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph27ssr);

//		Paragraph paragraph28ssr = new Paragraph(
//				"We dedicate and commitment ourselves to achieve, sustain and    foster unmatched excellence in technical education.  To this end, we will pursue continuous development of infrastructure and enhance state of the art equipment to provide our students a technology up to date and intellectually inspiring environment of learning, research, creativity, innovation and professional activity, inculcate in them ethical and moral values. The institute is committed to build a better nation through quality education with team sprit. Our students are enable to excel values of life and become good citizens. We inspire the system, infrastructure and services to satisfy the students, parents, industry and society.\r\n"
//						+ "\r\n" + "\r\n" + "\r\n",
//				font5);
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
				
		
		
////////////////////////////////////////////////////////////////////profile of the program
		

		document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}
			

	
//	private void addLogo(Document document) {
//		Path root = Paths.get(reportGeneratePath);
//		Path file = null;
//	//	int emailvalue=0;
//		try {
//			file = root.resolve("naac.png");
//			Image img = Image.getInstance(file.toAbsolutePath().toString());
//			img.scalePercent(logoImgScale[0], logoImgScale[1]);
//			img.setAlignment(Element.ALIGN_CENTER);
//			document.add(img);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	//		emailvalue=1;
//		}
//	}
	

}
