package com.adiverse.erp.openpdf;

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
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.service.SsrService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@Component
public class UniversityAccademicInformation {
	
	@Autowired
	SsrService ssrService;

	@Value("${logoImgPath}")
	private String logoImgPath;

	@Value("${logoImgScale}")
	private Float[] logoImgScale;

      @Value("${upload.files.path}")
	  private String reportGeneratePath;

	public Image headerImage;

	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);


	List<ProfileoftheCollege> profileList = null;
	ProfileoftheCollege ssrData = null;
	List<EvaluativeFileUpload> Profilefile = null;

	
	public String generateReport(Map<String, String> allParams) throws DocumentException, IOException {

		System.out.println("report");
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

			
			
			profileList=ssrService.getAllAcademicData(allParams);
			if (CollectionUtils.isNotEmpty(profileList)) {
				ssrData = profileList.get(0);
			} else {
				ssrData = new ProfileoftheCollege();
			}
		   ObjectMapper mapper=new ObjectMapper();
		   System.out.println("data is===="+mapper.writeValueAsString(profileList));

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "UniversityAccademicInformation-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
		
//			addLogo(document);	
		


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
		PdfPCell cell = new PdfPCell();
		cell.setPhrase(new Phrase("College Type \r\n\r\n", font4)); 
		cell.setExtraParagraphSpace(10f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase("Number of colleges with permanent affiliation", font4)); 
		cell.setExtraParagraphSpace(10f);
	
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase("Number of colleges with permanent affiliation", font4));
		cell.setExtraParagraphSpace(10f);
		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase("Entry Qualification\r\n\r\n\r\n", font3));
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase("Medium of Instruction\r\n\r\n", font3));
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase("Sanctioned Strength\r\n\r\n", font3));
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase("No.of Students AdmittedSanctioned Strength\r\n\r\n\r\n", font3));
//		table13ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated().get(0).getInputa1t1():"",font5)); 
		cell.setExtraParagraphSpace(10f);
		
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated().get(0).getInputa1t2():"",font5));  
		cell.setExtraParagraphSpace(10f);
		table13ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated().get(0).getInputa1t3():"",font5));
		cell.setExtraParagraphSpace(10f);
		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad14():""));
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad15():""));
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad16():""));
//		table13ssr.addCell(cell);
//		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademicinformation().get(0).getInputad17():""));
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
		table013ssr.setSpacingAfter(10f);
		document.add(table013ssr);
		document.add(table13ssr);
		
		
		
		PdfPTable table131ssr = new PdfPTable(5);
		table131ssr.setWidthPercentage(100f);
		table131ssr.setWidths(new int[] {35,35,35,35,35});
		table131ssr.setSpacingBefore(20f);
		PdfPCell cell1 = new PdfPCell();
		cell1.setPhrase(new Phrase("Type of Colleges\r\n\r\n", font4)); 
		cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase("Permanent\r\n\r\n", font4)); 
		cell.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
//		cell1.setPhrase(new Phrase("Type of Colleges\r\n\r\n", font3));
//		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase("Temporary\r\n\r\n", font4)); 
		cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase("Total\r\n\r\n", font4)); 
		cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase());
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase("Education/Teachers Training\r\n\r\n", font4));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(0).getInputa2t1():"",font5));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(0).getInputa2t2():"",font5));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(0).getInputa2t3():"",font5));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(0).getInputa2t4():"",font5));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase("Business administration /Commerce /Management /Finance\r\n\r\n", font4));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(1).getInputa2t1():"",font5));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(1).getInputa2t2():"",font5));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(1).getInputa2t3():"",font5));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(1).getInputa2t4():"",font5));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase("Universal/ Common to all Disciplines\r\n\r\n", font4));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(2).getInputa2t1():"",font5));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(2).getInputa2t2():"",font5));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(2).getInputa2t3():"",font5));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		cell1.setPhrase(new Phrase(ssrData != null ?ssrData.getAuniversityAffiliated1().get(2).getInputa2t4():"",font5));  cell1.setExtraParagraphSpace(10f);
		table131ssr.addCell(cell1);
		
		
		document.add(table131ssr);
		
		
		Paragraph paragraph151ssr = new Paragraph("Furnish the Details of Number of Colleges under the University",font4);
		
		document.add(paragraph151ssr);
		
		
		PdfPTable table132ssr = new PdfPTable(2);
		table132ssr.setWidthPercentage(100f);
		PdfPCell cell2 = new PdfPCell();
		cell2.setPhrase(new Phrase("Constituent Colleges\r\n\r\n", font4));  cell.setExtraParagraphSpace(10f);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t1():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("Constituent Colleges\r\n\r\n", font4));  cell.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t2():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("College Under 2(f)\r\n\r\n", font4));  cell.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t3():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("Collge Under 2(f) and 12B\r\n\r\n", font4));  cell.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t4():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("NAAC Accredited Colleges\r\n\r\n", font4));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase(ssrData != null ?ssrData.getUniversityColleges().get(0).getInputa3t5():"",font5));  cell2.setExtraParagraphSpace(10f);
		table132ssr.addCell(cell2);
		cell2.setPhrase(new Phrase("Colleges with Potential for Excellence (UGC)\r\n\r\n", font4));  cell.setExtraParagraphSpace(10f);
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
		
		
		
		
		PdfPCell cell0394ssr = new PdfPCell(new Paragraph("Recruited",font4));  cell.setExtraParagraphSpace(10f);
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
				new Paragraph("Contractual\r\n\r\n",font4));  cell.setExtraParagraphSpace(10f);
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
				new Paragraph("Contractual\r\n\r\n",font4));  cell.setExtraParagraphSpace(10f);
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


		
        PdfPCell cell0188ssr = new PdfPCell(new Paragraph("Non-Teaching Staff\r\n",font4));  cell.setExtraParagraphSpace(10f);
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

		PdfPCell cell0623ssr = new PdfPCell(new Paragraph("Recruited\r\n",font4));  cell.setExtraParagraphSpace(10f);
		cell0623ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0723ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(1).getInputatt15():"",font5));  cell0723ssr.setExtraParagraphSpace(10f);
		cell0723ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0823ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(1).getInputatt16():"",font5));  cell0823ssr.setExtraParagraphSpace(10f);
		cell0823ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell0923ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(1).getInputatt17():"",font5));  cell0923ssr.setExtraParagraphSpace(10f);
		cell0923ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell01023ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getTechnicalStaff().get(1).getInputatt18():"",font5));  cell01023ssr.setExtraParagraphSpace(10f);
		cell01023ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell cell01123ssr = new PdfPCell(new Paragraph("Yet to Recruit\r\n",font4));  cell.setExtraParagraphSpace(10f);
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
				new Paragraph("Contractual\r\n",font4));  cell.setExtraParagraphSpace(10f);
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

		
		 PdfPCell cell0185ssr = new PdfPCell(new Paragraph("Temporary Teachers\r\n",font4));  cell.setExtraParagraphSpace(10f);
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
		cell22.setPhrase(new Phrase("Adjunct Professor",font4));  cell.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(1).getInputaa1t1():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(1).getInputaa1t2():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(1).getInputaa1t3():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase(ssrData != null ?ssrData.getAcademiciansAppointed().get(1).getInputaa1t4():"",font5));  cell22.setExtraParagraphSpace(10f);
		table1311ssr.addCell(cell22);
		cell22.setPhrase(new Phrase("Visiting Professor",font4));  cell.setExtraParagraphSpace(10f);
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
		cell223.setPhrase(new Phrase("SI.No",font4));  cell.setExtraParagraphSpace(10f);
		
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
		
		cell22.setPhrase(new Phrase("Others",font4));  cell.setExtraParagraphSpace(10f);
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
		
		
		
		
		
		
		
		
		

//		PdfPTable table36ssr = new PdfPTable(6);
//		PdfPTable table37ssr = new PdfPTable(1);
//		
//		 float[] columnWidth8 = { 7f }; // Second column will be // twice as first and third
//		 table37ssr.setWidths(columnWidth8);
//
//// Setting width of table, its columns and spacing
//		table36ssr.setWidthPercentage(100);
//		table37ssr.setWidthPercentage(100);
//
//		PdfPCell cell065ssr = new PdfPCell(new Paragraph("Programme\r\n", font3));
//		
//		cell065ssr.setColspan(2);
//	
//		PdfPCell cell059111ssr = new PdfPCell(new Paragraph("SC\r\n"));
//		
//		cell059111ssr.setRowspan(3);
//
//		PdfPCell cell059211ssr = new PdfPCell(new Paragraph("male\r\n"));
//		PdfPCell cell059312ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(0).getInputaa11():""));
//		PdfPCell cell059413ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(0).getInputaa12():""));
//		PdfPCell cell059514ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(0).getInputaa13():""));
//		PdfPCell cell059615ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(0).getInputaa14():""));
//		
//		PdfPCell cell059916ssr = new PdfPCell(new Paragraph("female\r\n"));
//		PdfPCell cell0591017ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(1).getInputaa11():""));
//		PdfPCell cell0591118ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(1).getInputaa12():""));
//		PdfPCell cell0591219ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(1).getInputaa13():""));
//		PdfPCell cell0591320ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(1).getInputaa14():""));
//		
//		PdfPCell cell0591621ssr = new PdfPCell(new Paragraph("others\r\n"));
//		PdfPCell cell0591722ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(2).getInputaa11():""));
//		PdfPCell cell05918232ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(2).getInputaa12():""));
//		PdfPCell cell0591924ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(2).getInputaa13():""));
//		PdfPCell cell0592025ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(2).getInputaa11():""));
//		
//		
//		PdfPCell cell066ssr = new PdfPCell(new Paragraph("Year 1\r\n\r\n", font3));
//		PdfPCell cell067ssr = new PdfPCell(new Paragraph("Year 2\r\n\r\n", font3));
//		PdfPCell cell068ssr = new PdfPCell(new Paragraph("Year 3\r\n\r\n", font3));
//		PdfPCell cell069ssr = new PdfPCell(new Paragraph("Year 4\r\n\r\n", font3));
//
//		
//		
//		table36ssr.addCell(cell065ssr);
//		table36ssr.addCell(cell066ssr);
//		table36ssr.addCell(cell067ssr);
//		table36ssr.addCell(cell068ssr);
//		table36ssr.addCell(cell069ssr);
//
//		table36ssr.addCell(cell059111ssr);
//		table36ssr.addCell(cell059211ssr);
//		table36ssr.addCell(cell059312ssr);
//		table36ssr.addCell(cell059413ssr);
//		table36ssr.addCell(cell059514ssr);
//		table36ssr.addCell(cell059615ssr);
//		table36ssr.addCell(cell059916ssr);
//		table36ssr.addCell(cell0591017ssr);
//		table36ssr.addCell(cell0591118ssr);
//		table36ssr.addCell(cell0591219ssr);
//		table36ssr.addCell(cell0591320ssr);
//		table36ssr.addCell(cell0591621ssr);
//		table36ssr.addCell(cell0591722ssr);
//		table36ssr.addCell(cell05918232ssr);
//		table36ssr.addCell(cell0591924ssr);
//		table36ssr.addCell(cell0592025ssr);
//		
//		
//		
//		
//	
//		PdfPCell cell0592300ssr = new PdfPCell(new Paragraph("ST\r\n"));
//		
//		cell0592300ssr.setRowspan(3);
//		
//		PdfPCell cell0592400ssr = new PdfPCell(new Paragraph("Male\r\n"));
//		PdfPCell cell0592500ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(3).getInputaa11():""));
//		PdfPCell cell0592600ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(3).getInputaa12():""));
//		PdfPCell cell0592700ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(3).getInputaa13():""));
//		PdfPCell cell0592800ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(3).getInputaa14():""));
//		
//		PdfPCell cell0593000ssr = new PdfPCell(new Paragraph("Female\r\n"));
//		PdfPCell cell0593100ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(4).getInputaa11():""));
//		PdfPCell cell05932100ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(4).getInputaa12():""));
//		PdfPCell cell0593300ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(4).getInputaa13():""));
//		PdfPCell cell0593500ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(4).getInputaa14():""));
//		
//		PdfPCell cell0593600ssr = new PdfPCell(new Paragraph("Others\r\n"));
//		PdfPCell cell0593700ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(5).getInputaa11():""));
//		PdfPCell cell0593800ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(5).getInputaa12():""));
//		PdfPCell cell0593900ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(5).getInputaa13():""));
//		PdfPCell cell0594000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(5).getInputaa14():""));
//		
//		table36ssr.addCell(cell0592300ssr);
//		table36ssr.addCell(cell0592400ssr);
//		table36ssr.addCell(cell0592500ssr);
//		table36ssr.addCell(cell0592600ssr);
//		table36ssr.addCell(cell0592700ssr);
//		table36ssr.addCell(cell0592800ssr);
//		table36ssr.addCell(cell0593000ssr);
//		table36ssr.addCell(cell0593100ssr);
//		table36ssr.addCell(cell05932100ssr);
//		table36ssr.addCell(cell0593300ssr);
//		table36ssr.addCell(cell0593500ssr);
//		table36ssr.addCell(cell0593600ssr);
//		table36ssr.addCell(cell0593700ssr);
//		table36ssr.addCell(cell0593800ssr);
//		table36ssr.addCell(cell0593900ssr);
//		table36ssr.addCell(cell0594000ssr);
//		
//	
//       PdfPCell cell05923000ssr = new PdfPCell(new Paragraph("OBC\r\n"));
//		
//       cell05923000ssr.setRowspan(3);
//		
//		PdfPCell cell05924000ssr = new PdfPCell(new Paragraph("Male\r\n"));
//		PdfPCell cell05925000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(6).getInputaa11():""));
//		PdfPCell cell05926000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(6).getInputaa12():""));
//		PdfPCell cell05927000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(6).getInputaa13():""));
//		PdfPCell cell05928000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(6).getInputaa14():""));
//		
//		PdfPCell cell05930000ssr = new PdfPCell(new Paragraph("Female\r\n"));
//		PdfPCell cell05931000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(7).getInputaa11():""));
//		PdfPCell cell059321000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(7).getInputaa12():""));
//		PdfPCell cell05933000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(7).getInputaa13():""));
//		PdfPCell cell05935000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(7).getInputaa14():""));
//		
//		PdfPCell cell05936000ssr = new PdfPCell(new Paragraph("Others\r\n"));
//		PdfPCell cell05937000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(8).getInputaa11():""));
//		PdfPCell cell05938000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(8).getInputaa12():""));
//		PdfPCell cell05939000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(8).getInputaa13():""));
//		PdfPCell cell05940000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(8).getInputaa14():""));
//		
//		
//		table36ssr.addCell(cell05923000ssr);
//		table36ssr.addCell(cell05924000ssr);
//		table36ssr.addCell(cell05925000ssr);
//		table36ssr.addCell(cell05926000ssr);
//		table36ssr.addCell(cell05927000ssr);
//		table36ssr.addCell(cell05928000ssr);
//		
//		table36ssr.addCell(cell05930000ssr);
//		table36ssr.addCell(cell05931000ssr);
//		table36ssr.addCell(cell059321000ssr);
//		table36ssr.addCell(cell05933000ssr);
//		table36ssr.addCell(cell05935000ssr);
//		
//		table36ssr.addCell(cell05936000ssr);
//		table36ssr.addCell(cell05937000ssr);
//		table36ssr.addCell(cell05938000ssr);
//		table36ssr.addCell(cell05939000ssr);
//		table36ssr.addCell(cell05940000ssr);
//	
//		 PdfPCell cell059230000ssr = new PdfPCell(new Paragraph("General\r\n"));
//			
//		 cell059230000ssr.setRowspan(3);
//			
//			PdfPCell cell059240000ssr = new PdfPCell(new Paragraph("Male\r\n"));
//			PdfPCell cell059250000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(9).getInputaa11():""));
//			PdfPCell cell059260000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(9).getInputaa12():""));
//			PdfPCell cell059270000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(9).getInputaa13():""));
//			PdfPCell cell059280000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(9).getInputaa14():""));
//			
//			PdfPCell cell059300000ssr = new PdfPCell(new Paragraph("Female\r\n"));
//			PdfPCell cell059310000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(10).getInputaa11():""));
//			PdfPCell cell0593210000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(10).getInputaa12():""));
//			PdfPCell cell059330000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(10).getInputaa13():""));
//			PdfPCell cell059350000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(10).getInputaa14():""));
//			
//			PdfPCell cell059360000ssr = new PdfPCell(new Paragraph("Others\r\n"));
//			PdfPCell cell059370000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(11).getInputaa11():""));
//			PdfPCell cell059380000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(11).getInputaa12():""));
//			PdfPCell cell059390000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(11).getInputaa13():""));
//			PdfPCell cell059400000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(11).getInputaa14():""));
//			
//			
//			table36ssr.addCell(cell059230000ssr);
//			table36ssr.addCell(cell059240000ssr);
//			table36ssr.addCell(cell059250000ssr);
//			table36ssr.addCell(cell059260000ssr);
//			
//			table36ssr.addCell(cell059270000ssr);
//			table36ssr.addCell(cell059280000ssr);
//			table36ssr.addCell(cell059300000ssr);
//			table36ssr.addCell(cell059310000ssr);
//			
//			table36ssr.addCell(cell0593210000ssr);
//			table36ssr.addCell(cell059330000ssr);
//			table36ssr.addCell(cell059350000ssr);
//			table36ssr.addCell(cell059360000ssr);
//			
//			table36ssr.addCell(cell059370000ssr);
//			table36ssr.addCell(cell059380000ssr);
//			table36ssr.addCell(cell059390000ssr);
//			table36ssr.addCell(cell059400000ssr);
//		
//			
//			
//		
//			 PdfPCell cell059230001ssr = new PdfPCell(new Paragraph("Others\r\n"));
//				
//			 cell059230001ssr.setRowspan(3);
//				
//				PdfPCell cell059240001ssr = new PdfPCell(new Paragraph("Male\r\n"));
//				PdfPCell cell059250001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(12).getInputaa11():""));
//				PdfPCell cell059260001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(12).getInputaa12():""));
//				PdfPCell cell059270001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(12).getInputaa13():""));
//				PdfPCell cell059280001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(12).getInputaa14():""));
//				
//				PdfPCell cell059300001ssr = new PdfPCell(new Paragraph("Female\r\n"));
//				PdfPCell cell059310002ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(13).getInputaa14():""));
//				PdfPCell cell0593210003ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(13).getInputaa14():""));
//				PdfPCell cell059330001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(13).getInputaa14():""));
//				PdfPCell cell059350001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(13).getInputaa14():""));
//				
//				PdfPCell cell059360001ssr = new PdfPCell(new Paragraph("Others\r\n"));
//				PdfPCell cell059370001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(14).getInputaa14():""));
//				PdfPCell cell059380001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(14).getInputaa14():""));
//				PdfPCell cell059390001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(14).getInputaa14():""));
//				PdfPCell cell059400001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(14).getInputaa14():""));
//				
//				PdfPCell cell0650ssr = new PdfPCell(new Paragraph("Total\r\n"));
//				
//				cell0650ssr.setColspan(2);
//			
//				PdfPCell cell059370011ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(15).getInputaa14():""));
//				PdfPCell cell059380011ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(15).getInputaa14():""));
//				PdfPCell cell059390011ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(15).getInputaa14():""));
//				PdfPCell cell059400011ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getAcademicstudentsAdmitted().get(15).getInputaa14():""));
//				
//				
//				
//				table36ssr.addCell(cell059230001ssr);
//				table36ssr.addCell(cell059240001ssr);
//				table36ssr.addCell(cell059250001ssr);
//				table36ssr.addCell(cell059260001ssr);
//				table36ssr.addCell(cell059270001ssr);
//				table36ssr.addCell(cell059280001ssr);
//				
//				table36ssr.addCell(cell059300001ssr);
//				table36ssr.addCell(cell059310002ssr);
//				table36ssr.addCell(cell0593210003ssr);
//				table36ssr.addCell(cell059330001ssr);
//				table36ssr.addCell(cell059350001ssr);
//				
//				table36ssr.addCell(cell059360001ssr);
//				table36ssr.addCell(cell059370001ssr);
//				table36ssr.addCell(cell059380001ssr);
//				table36ssr.addCell(cell059390001ssr);
//				table36ssr.addCell(cell059400001ssr);
//			
//				table36ssr.addCell(cell0650ssr);
//				table36ssr.addCell(cell059370011ssr);
//				table36ssr.addCell(cell059380011ssr);
//				table36ssr.addCell(cell059390011ssr);
//				table36ssr.addCell(cell059400011ssr);
//			
//				
//		
//				PdfPCell cell0691ssr = new PdfPCell(new Paragraph(
//						"Provide the Following Details of Students admitted to the College During the last four Academic Years\r\n",font3));
//				
//				table37ssr.addCell(cell0691ssr);
//		
//		
//		
//		
//		
//		table37ssr.addCell(table36ssr);
//
//		table37ssr.setSpacingBefore(20f);
//		table37ssr.setSpacingAfter(20f);
//
//		document.add(table37ssr);
/////

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
