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
public class AutonoumsBasicInformationReport {
	
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
			
//			
			profileList=ssrService.getAllAcademicData(allParams);
			if (CollectionUtils.isNotEmpty(profileList)) {
				ssrData = profileList.get(0);
			} else {
				ssrData = new ProfileoftheCollege();
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
		
		//	addLogo(document);	
		


////////////////////////////////////////////////////////////////////profile of the program
		Paragraph paragraph13ssr = new Paragraph("2.PROFILE\r\n", font1);
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
		cell1ssr.setExtraParagraphSpace(10f);
		cell1ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell1ssr);


		PdfPCell cell2ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt1(): "",font5));     
		cell2ssr.setExtraParagraphSpace(10f);
		
		cell2ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell2ssr);

		PdfPCell cell3ssr = new PdfPCell(new Paragraph("Address", font4));
		cell3ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell3ssr);

		PdfPCell cell4ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getBasicProfile().get(0).getInputbt2(): "",font5));   
		cell4ssr.setExtraParagraphSpace(10f);
		cell4ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table1ssr.addCell(cell4ssr);

		PdfPCell cell5ssr = new PdfPCell(new Paragraph("City",font4));  
		cell5ssr.setExtraParagraphSpace(10f);
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

//		table01ssr.addCell(table1ssr);
		table01ssr.setSpacingBefore(20f);

//		table01ssr.setSpacingAfter(20f);

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
		cell.setPhrase(new Phrase("Name\r\n", font4));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Telephone with STD Code\r\n", font4));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Mobile\r\n", font4));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Fax\r\n", font4));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase("Email\r\n", font4));
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc1(): ""+"\r\n",font5));   
		cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc2(): ""+"\r\n",font5));  
		cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc3(): ""+"\r\n",font5)); 
		cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc4(): ""+"\r\n",font5));  
		cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc5(): ""+"\r\n",font5)); 
		cell.setExtraParagraphSpace(10f);
		table2ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getContactsforCommunication().get(0).getInputbtc6(): ""+"\r\n",font5));  
		cell.setExtraParagraphSpace(10f);
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
//		table02ssr.setSpacingAfter(20f);
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
//		table3ssr.setSpacingBefore(20f);
		table3ssr.setSpacingAfter(20f);

		PdfPCell cell13ssr = new PdfPCell(new Paragraph("Institution Status\r\n",font4)); 
		cell13ssr.setExtraParagraphSpace(10f);
		cell13ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3ssr.addCell(cell13ssr);

		PdfPCell cell14ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti1(): ""+"\r\n",font5));   
		cell14ssr.setExtraParagraphSpace(10f);
		cell14ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table3ssr.addCell(cell14ssr);

//		table03ssr.addCell(table3ssr);
		document.add(table03ssr);
		document.add(table3ssr);
//		table03ssr.setSpacingAfter(20f);

		PdfPTable table04ssr = new PdfPTable(1);
		table04ssr.setWidthPercentage(100f);

		PdfPCell cell04ssr = new PdfPCell(new Paragraph("Type of Institution\r\n", font4));
		cell04ssr.setExtraParagraphSpace(10f);
		cell04ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		
		table04ssr.addCell(cell04ssr);
	
		PdfPTable table4ssr = new PdfPTable(2);
		table4ssr.setWidthPercentage(100f);
		table4ssr.setWidths(new int[] { 3, 3 });
		table04ssr.setSpacingBefore(20f);
//		table04ssr.setSpacingAfter(20f);

		PdfPCell cell15ssr = new PdfPCell(new Paragraph("By Gender\r\n",font4));  
		cell15ssr.setExtraParagraphSpace(10f);
		cell15ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr.addCell(cell15ssr);

		PdfPCell cell16ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti2(): "",font5));  
		cell16ssr.setExtraParagraphSpace(10f);
		cell16ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr.addCell(cell16ssr);

		PdfPCell cell17ssr = new PdfPCell(new Paragraph("By Shift\r\n",font4));  
		cell17ssr.setExtraParagraphSpace(10f);
		cell17ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr.addCell(cell17ssr);

		PdfPCell cell18ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti3(): "",font5));    
		cell18ssr	.setExtraParagraphSpace(10f);
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
		cell15ssr1.setExtraParagraphSpace(10f);
		cell15ssr1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table04ssr1.addCell(cell15ssr1);

		PdfPCell cell16ssr1 = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti4(): "",font5));  
		cell16ssr1.setExtraParagraphSpace(10f);
		cell16ssr1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table04ssr1.addCell(cell16ssr1);

		PdfPCell cell17ssr1 = new PdfPCell(new Paragraph("Date of grant of 'Autonomy' to the college by UGC\r\n",font4)); 
		cell17ssr1.setExtraParagraphSpace(10f);
		cell17ssr1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table04ssr1.addCell(cell17ssr1);

		PdfPCell cell18ssr1 = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti5(): "",font5));   
		cell18ssr1.setExtraParagraphSpace(10f);
		cell18ssr1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table04ssr1.addCell(cell18ssr1);
		
		PdfPCell cell170ssr1 = new PdfPCell(new Paragraph("Establishment date\r\n",font4));  
		cell170ssr1.setExtraParagraphSpace(10f);
		cell170ssr1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table04ssr1.addCell(cell170ssr1);

		PdfPCell cell180ssr1 = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti6(): "",font5));  
		cell180ssr1.setExtraParagraphSpace(10f);
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
		cell15ssr111.setExtraParagraphSpace(10f);
		cell15ssr111.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr11.addCell(cell15ssr111);
		PdfPCell cell15ssr112 = new PdfPCell(new Paragraph("Institution Name",font4));  
		cell15ssr112.setExtraParagraphSpace(10f);
		cell15ssr112.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr11.addCell(cell15ssr112);
//		PdfPCell cell15ssr113 = new PdfPCell(new Paragraph("View Document"));
//		table4ssr11.addCell(cell15ssr113);
		
		
		PdfPCell cell15ssr114 = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti11(): "",font5));  
		cell15ssr114.setExtraParagraphSpace(10f);
		cell15ssr114.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr11.addCell(cell15ssr114);
		
		PdfPCell cell15ssr115 = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti12(): "",font5));  
		cell15ssr115.setExtraParagraphSpace(10f);
		cell15ssr115.setHorizontalAlignment(Element.ALIGN_CENTER);
		table4ssr11.addCell(cell15ssr115);
		
		document.add(table4ssr11);
		
		PdfPTable table05ssr = new PdfPTable(1);
		table05ssr.setWidthPercentage(100f);
		
		PdfPCell cell06ssr = new PdfPCell(new Paragraph("Recognized Minority institution\r\n", font4));
		cell06ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table05ssr.addCell(cell06ssr);

		PdfPTable table5ssr = new PdfPTable(2);
		table5ssr.setWidthPercentage(100f);
		table5ssr.setWidths(new int[] { 70, 70 });
		
		table5ssr.setSpacingBefore(20f);
		table5ssr.setSpacingAfter(20f);

		PdfPCell cell07ssr = new PdfPCell(new Paragraph("If it is a recognized minority institution\r\n",font4));  
		cell07ssr.setExtraParagraphSpace(10f);
		cell07ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell07ssr);
		PdfPCell cell20ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizedMinority().get(0).getInputbtr1():"",font5)); 
		cell20ssr.setExtraParagraphSpace(10f);
		cell20ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell20ssr);
		PdfPCell cell071ssr = new PdfPCell(new Paragraph("If yes, Specify minority status\r\n",font4));  
		cell071ssr.setExtraParagraphSpace(10f);
		cell071ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell071ssr);
		PdfPCell cell201ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizedMinority().get(0).getInputbtr2():"",font5));  
		cell201ssr.setExtraParagraphSpace(10f);
		cell201ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell201ssr);

		
		PdfPCell cell0712ssr = new PdfPCell(new Paragraph("Religios\r\n",font4)); 
		cell0712ssr.setExtraParagraphSpace(10f);
		cell0712ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell0712ssr);
		PdfPCell cell2012ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizedMinority().get(0).getInputbtr3():"",font5));  
		cell2012ssr	.setExtraParagraphSpace(10f);
		cell2012ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell2012ssr);
		PdfPCell cell0713ssr = new PdfPCell(new Paragraph("Linguistic\r\n",font4));  
		cell0713ssr.setExtraParagraphSpace(10f);
		cell0713ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell0713ssr);
		PdfPCell cell2013ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizedMinority().get(0).getInputbtr4():"",font5));  
		cell2013ssr.setExtraParagraphSpace(10f);
		cell2013ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell2013ssr);
		PdfPCell cell0714ssr = new PdfPCell(new Paragraph("Any Other\r\n",font4));  
		cell0714ssr.setExtraParagraphSpace(10f);
		cell0714ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell0714ssr);
		PdfPCell cell2014ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizedMinority().get(0).getInputbtr4():"",font5));   
		cell2014ssr.setExtraParagraphSpace(10f);
		cell2014ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table5ssr.addCell(cell2014ssr);
		
//		table05ssr.addCell(table5ssr);
		document.add(table05ssr);
		document.add(table5ssr);
		table05ssr.setSpacingAfter(20f);
		table05ssr.setSpacingBefore(20f);

		
		
		PdfPTable table051ssr = new PdfPTable(1);
		table051ssr.setWidthPercentage(100f);
		
		PdfPCell cell061ssr = new PdfPCell(new Paragraph("Recognition Details\r\n", font4));
		cell061ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table051ssr.addCell(cell061ssr);
		PdfPCell cell062ssr = new PdfPCell(new Paragraph("Date of Recognition by UGC or any Other National Agency",font4));  
		cell062ssr.setExtraParagraphSpace(10f);
		cell062ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table051ssr.addCell(cell062ssr);
		
		PdfPTable table51ssr = new PdfPTable(2);
		table51ssr.setWidthPercentage(100f);
		table51ssr.setWidths(new int[] { 70, 70 });
		
		table51ssr.setSpacingBefore(20f);
		table51ssr.setSpacingAfter(20f);

		PdfPCell cell0751ssr = new PdfPCell(new Paragraph("Under Section\r\n",font4)); 
		cell0751ssr.setExtraParagraphSpace(10f);
		cell0751ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51ssr.addCell(cell0751ssr);
		PdfPCell cell2051ssr = new PdfPCell(new Paragraph("Date",font4));  
		cell2051ssr.setExtraParagraphSpace(10f);
		cell2051ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51ssr.addCell(cell2051ssr);
		PdfPCell cell07151ssr = new PdfPCell(new Paragraph("2f of UGC\r\n",font4)); 
		cell07151ssr.setExtraParagraphSpace(10f);
		cell07151ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51ssr.addCell(cell07151ssr);
		PdfPCell cell20151ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizationDetails().get(0).getInputbtr6():"",font5)); 
		cell20151ssr.setExtraParagraphSpace(10f);
		cell20151ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51ssr.addCell(cell20151ssr);

		
		PdfPCell cell071251ssr = new PdfPCell(new Paragraph("12B of UGC\r\n",font4));  
		cell071251ssr.setExtraParagraphSpace(10f);
		cell071251ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51ssr.addCell(cell071251ssr);
		PdfPCell cell201251ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getRecognizationDetails().get(0).getInputbtr7():"",font5));  
		cell201251ssr.setExtraParagraphSpace(10f);
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

		PdfPCell cell07510ssr = new PdfPCell(new Paragraph("No of New programmes introduced during the last five years and name \r\n",font4));   
		cell07510ssr.setExtraParagraphSpace(10f);
		cell07510ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell07510ssr.setColspan(2);
		table510ssr.addCell(cell07510ssr);
		
		PdfPCell cell205101ssr = new PdfPCell(new Paragraph("Programs not covered under the Autonomous status of UGC",font4));  
		cell205101ssr.setExtraParagraphSpace(10f);
		cell205101ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell205101ssr.setColspan(2);
		table510ssr.addCell(cell205101ssr);
		
		
		PdfPCell cell071510ssr = new PdfPCell(new Paragraph("No",font4));
		cell071510ssr.setExtraParagraphSpace(10f);
		cell071510ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell071510ssr);
		PdfPCell cell201510ssr = new PdfPCell(new Paragraph("Name",font4));
		cell201510ssr.setExtraParagraphSpace(10f);
		cell201510ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201510ssr);

		
		PdfPCell cell0712510ssr = new PdfPCell(new Paragraph("UG",font4)); 
		cell0712510ssr.setExtraParagraphSpace(10f);
		cell0712510ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0712510ssr);
		PdfPCell cell2012510ssr = new PdfPCell(new Paragraph("PG",font4));  
		cell2012510ssr.setExtraParagraphSpace(10f);
		cell2012510ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell2012510ssr);
		
		 
		PdfPCell cell07151000ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(0).getInputbtp11():"",font5));  
		cell07151000ssr.setExtraParagraphSpace(10f);
		cell07151000ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell07151000ssr);
		PdfPCell cell2015100ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(0).getInputbtp12():"",font5));   
		cell2015100ssr.setExtraParagraphSpace(10f);
		cell2015100ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table510ssr.addCell(cell2015100ssr);
        PdfPCell cell07125101ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(0).getInputbtp13():"",font5));  
        cell07125101ssr .setExtraParagraphSpace(10f);
        cell07125101ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        table510ssr.addCell(cell07125101ssr);
		PdfPCell cell20125101ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(0).getInputbtp14():"",font5 ));
		cell20125101ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell20125101ssr);
		PdfPCell cell201251010ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(0).getInputbtp15():"",font5));   
		cell201251010ssr.setExtraParagraphSpace(10f);
		cell201251010ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201251010ssr);
		
		PdfPCell cell071510001ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(1).getInputbtp11():"",font5));  
		cell071510001ssr.setExtraParagraphSpace(10f);
		cell071510001ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell071510001ssr);
		PdfPCell cell20151002ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(1).getInputbtp12():"",font5));   
		cell20151002ssr.setExtraParagraphSpace(10f);
		cell20151002ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell20151002ssr);
		PdfPCell cell071251013ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(1).getInputbtp13():"",font5));   
		cell071251013ssr.setExtraParagraphSpace(10f);
		cell071251013ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table510ssr.addCell(cell071251013ssr);
		PdfPCell cell201251014ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(1).getInputbtp14():"",font5 ));
		cell201251014ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201251014ssr);
		PdfPCell cell2012510105ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(1).getInputbtp15():"",font5));   
		cell2012510105ssr.setExtraParagraphSpace(10f);
		cell2012510105ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell2012510105ssr);
		
		PdfPCell cell0715100016ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(2).getInputbtp11():"",font5));     
		cell0715100016ssr.setExtraParagraphSpace(10f);
		cell0715100016ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0715100016ssr);
		PdfPCell cell201510027ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(2).getInputbtp12():"",font5));    
		cell201510027ssr	.setExtraParagraphSpace(10f);
		cell201510027ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201510027ssr);
		PdfPCell cell0712510138ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(2).getInputbtp13():"",font5));   
		cell0712510138ssr	.setExtraParagraphSpace(10f);
		cell0712510138ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0712510138ssr);
		PdfPCell cell2012510149ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(2).getInputbtp14():"",font5 ));
		cell2012510149ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell2012510149ssr);
		PdfPCell cell20125101051ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(2).getInputbtp15():"",font5));   
		cell20125101051ssr	.setExtraParagraphSpace(10f);
		cell20125101051ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell20125101051ssr);
		
		PdfPCell cell0715100012ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(3).getInputbtp11():"",font5));    
		cell0715100012ssr.setExtraParagraphSpace(10f);
		cell0715100012ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0715100012ssr);
		PdfPCell cell201510023ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(3).getInputbtp12():"",font5));  
		cell201510023ssr.setExtraParagraphSpace(10f);
		cell201510023ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201510023ssr);
		PdfPCell cell0712510134ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(3).getInputbtp13():"",font5));  
		cell0712510134ssr.setExtraParagraphSpace(10f);
		cell0712510134ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0712510134ssr);
		PdfPCell cell2012510145ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(3).getInputbtp14():"",font5 ));
		cell2012510145ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell2012510145ssr);
	
		PdfPCell cell20125101056ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(3).getInputbtp15():"",font5));    
		cell20125101056ssr.setExtraParagraphSpace(10f);
		cell20125101056ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell20125101056ssr);
		
		PdfPCell cell0715100017ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(4).getInputbtp11():"",font5));  
		cell0715100017ssr.setExtraParagraphSpace(10f);
		cell0715100017ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0715100017ssr);
		PdfPCell cell201510028ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(4).getInputbtp12():"",font5));    
		cell201510028ssr.setExtraParagraphSpace(10f);
		cell201510028ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell201510028ssr);
		PdfPCell cell0712510139ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(4).getInputbtp13():"",font5));    
		cell0712510139ssr	.setExtraParagraphSpace(10f);
		cell0712510139ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell0712510139ssr);
		PdfPCell cell2012510140ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(4).getInputbtp14():"",font5 ));
		cell2012510140ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table510ssr.addCell(cell2012510140ssr);
		PdfPCell cell201251010511ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammeIntroduced().get(4).getInputbtp15():"",font5));    
		cell201251010511ssr	.setExtraParagraphSpace(10f);
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
		cell2051011ssr.	setExtraParagraphSpace(10f);
		cell2051011ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2051011ssr);
		
		PdfPCell cell075104ssr = new PdfPCell(new Paragraph("Aided",font4));  
		cell075104ssr.setExtraParagraphSpace(10f);
		cell075104ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
	
		table51022ssr.addCell(cell075104ssr);
		
		PdfPCell cell2051012ssr = new PdfPCell(new Paragraph("Self-financed",font4));  
		cell2051012ssr.setExtraParagraphSpace(10f);
		cell2051012ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2051012ssr);
		
		PdfPCell cell0715103ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(0).getInputpot1():"",font5));     
		cell0715103ssr	.setExtraParagraphSpace(10f);
		cell0715103ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell0715103ssr);
		PdfPCell cell2015104ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(0).getInputpot2():"",font5));    
		cell2015104ssr.setExtraParagraphSpace(10f);
		cell2015104ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2015104ssr); 
		PdfPCell cell071251033ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(0).getInputpot3():"",font5));  
		cell071251033ssr	.setExtraParagraphSpace(10f);
		cell071251033ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell071251033ssr);
		PdfPCell cell201251033ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(1).getInputpot1():"",font5));  
		cell201251033ssr	.setExtraParagraphSpace(10f);
		cell201251033ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell201251033ssr);
		PdfPCell cell0715100022ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(1).getInputpot2():"",font5));  
		cell0715100022ssr.setExtraParagraphSpace(10f);
		cell0715100022ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell0715100022ssr);
		PdfPCell cell201510022ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(1).getInputpot3():"",font5));  
		cell201510022ssr.setExtraParagraphSpace(10f);
		cell201510022ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell201510022ssr);
        PdfPCell cell071251011ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(2).getInputpot1():"",font5));  
        cell071251011ssr.setExtraParagraphSpace(10f);
        cell071251011ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        table51022ssr.addCell(cell071251011ssr);
		PdfPCell cell201251012ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(2).getInputpot2():"",font5 ));
		
		cell201251012ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell201251012ssr);
		PdfPCell cell2012510101ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProgrammesOffered().get(2).getInputpot3():"",font5));   
		cell2012510101ssr	.setExtraParagraphSpace(10f);
		cell2012510101ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2012510101ssr);
		
		PdfPCell cell20510110ssr = new PdfPCell(new Paragraph("Professional Programmes offered ",font4)); 
		cell20510110ssr.setExtraParagraphSpace(10f);
		cell20510110ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell20510110ssr);
		
		PdfPCell cell0751049ssr = new PdfPCell(new Paragraph(""));
		cell0751049ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell0751049ssr);
		
		PdfPCell cell20510128ssr = new PdfPCell(new Paragraph(""));
		cell20510128ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell20510128ssr);
		
		PdfPCell cell07151037ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(0).getInputpopt1():"",font5));   
		cell07151037ssr.setExtraParagraphSpace(10f);
		cell07151037ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell07151037ssr);
		PdfPCell cell20151046ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(0).getInputpopt2():"",font5));     
		cell20151046ssr.setExtraParagraphSpace(10f);
		cell20151046ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell20151046ssr); 
		PdfPCell cell0712510335ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(0).getInputpopt3():"",font5));   
		cell0712510335ssr.setExtraParagraphSpace(10f);
		cell0712510335ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell0712510335ssr);
		PdfPCell cell2012510334ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(1).getInputpopt1():"",font5));  
		cell2012510334ssr.setExtraParagraphSpace(10f);
		cell2012510334ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2012510334ssr);
		PdfPCell cell07151000223ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(1).getInputpopt2():"",font5));    
		cell07151000223ssr.setExtraParagraphSpace(10f);
		cell07151000223ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell07151000223ssr);
		PdfPCell cell2015100222ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(1).getInputpopt3():"",font5));   
		cell2015100222ssr.setExtraParagraphSpace(10f);
		cell2015100222ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2015100222ssr);
        PdfPCell cell0712510111ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(2).getInputpopt1():"",font5));   
        cell0712510111ssr.setExtraParagraphSpace(10f);
        cell0712510111ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
        table51022ssr.addCell(cell0712510111ssr);
		PdfPCell cell2012510122ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(2).getInputpopt2():"" ,font5));  
		cell2012510122ssr.setExtraParagraphSpace(10f);
		cell2012510122ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell2012510122ssr);
		PdfPCell cell20125101013ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getProffessionalprogrammes().get(2).getInputpopt2():"",font5));     
		cell20125101013ssr.setExtraParagraphSpace(10f);
		cell20125101013ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table51022ssr.addCell(cell20125101013ssr);
		
		document.add(table51022ssr);
		
	
		
		PdfPTable table06ssr = new PdfPTable(1);
		table06ssr.setWidthPercentage(100f);

		PdfPCell cell08ssr = new PdfPCell(new Paragraph("Establishment Details\r\n", font4));
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
				new Paragraph("Date of Establishment, Prior to the Grant of 'Autonomy'\r\n",font4)); 
		cell21ssr.setExtraParagraphSpace(10f);
		cell21ssr.setHorizontalAlignment(Element.ALIGN_CENTER);

		table6ssr.addCell(cell21ssr);

		PdfPCell cell22ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti4(): "",font5));     
		cell22ssr.setExtraParagraphSpace(10f);
		cell22ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6ssr.addCell(cell22ssr);

		PdfPCell cell23ssr = new PdfPCell(new Paragraph("Date of Grant of 'Autonomy' to the college by UGC \r\n",font4));  
		cell23ssr.setExtraParagraphSpace(10f);
		cell23ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table6ssr.addCell(cell23ssr);

		PdfPCell cell24ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.getNatureofInstitution().get(0).getInputbti6(): "",font5));     
		cell24ssr.setExtraParagraphSpace(10f);
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

		PdfPCell cell09ssr = new PdfPCell(new Paragraph("University to which the college is affiliated\r\n", font4));
		cell09ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table07ssr.addCell(cell09ssr);

		PdfPTable table7ssr = new PdfPTable(3);
		table7ssr.setWidthPercentage(100f);

		table7ssr.setSpacingBefore(20f);
		table7ssr.setSpacingAfter(20f);

		cell.setPhrase(new Phrase("State\r\n", font4));
		table7ssr.addCell(cell);
		cell.setPhrase(new Phrase("University name\r\n", font4));
		table7ssr.addCell(cell);
		cell.setPhrase(new Phrase("Document\r\n", font4));
		table7ssr.addCell(cell);

		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti11(): "",font5));    
		cell.setExtraParagraphSpace(10f);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti12(): "",font5));  
		cell.setExtraParagraphSpace(10f);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getInstitutionCollegeAffiliated().get(0).getInputbti13(): "",font5));  
		cell.setExtraParagraphSpace(10f);

		cell.setPadding(5);

		table07ssr.addCell(table7ssr);
//		document.add(table07ssr);
		table07ssr.setSpacingAfter(20f);
		table07ssr.setSpacingBefore(20f);

		PdfPTable table08ssr = new PdfPTable(1);
		table08ssr.setWidthPercentage(100f);

		PdfPCell cell121ssr = new PdfPCell(new Paragraph("Details of UGC recognition\r\n", font4));
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
		cell.setExtraParagraphSpace(10f);
		table8ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognizationDetails().get(0).getInputbtr6(): "",font5));    
		cell.setExtraParagraphSpace(10f);
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase());
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase("12B of UGC",font4)); 
		cell.setExtraParagraphSpace(10f);
		table8ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognizationDetails().get(0).getInputbtr6(): "",font5));  
		cell.setExtraParagraphSpace(10f);
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

		cell.setPhrase(new Phrase("Statutory Regulatory Authority\r\n", font4));
		table9ssr.addCell(cell);
		cell.setPhrase(new Phrase("Recognition/App roval details Inst itution/Departme nt programme\r\n", font4));
		table9ssr.addCell(cell);
		cell.setPhrase(new Phrase("Day,Month and year(dd-mm- yyyy)\r\n", font4));
		table9ssr.addCell(cell);
		cell.setPhrase(new Phrase("Validity in months\r\n", font4));
		table9ssr.addCell(cell);
		cell.setPhrase(new Phrase("Remarks\r\n", font4));
		table9ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd15():"",font5));    
		cell.setExtraParagraphSpace(10f);
		table9ssr.addCell(cell);

		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd11():"",font5));  
		cell.setExtraParagraphSpace(10f);
		table9ssr.addCell(cell);

		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd12():"",font5));   
		cell.setExtraParagraphSpace(10f);
		table9ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd13():"",font5));   
		cell.setExtraParagraphSpace(10f);
		table9ssr.addCell(cell);

		cell.setPhrase(new Phrase(ssrData != null ?ssrData.getRecognition().get(0).getInputbtd14():"",font5));  
		cell.setExtraParagraphSpace(10f);
		
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
		PdfPCell cell011ssr = new PdfPCell(new Paragraph("Recognitions\r\n", font4));
		cell011ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table01ssr.addCell(cell011ssr);
		PdfPTable table11ssr = new PdfPTable(2);
		table11ssr.setWidthPercentage(100f);
		table11ssr.setWidths(new int[] { 3, 3 });
		
		table11ssr.setSpacingBefore(20f);
		table11ssr.setSpacingAfter(20f);
		
		
		
		PdfPCell cell300ssr = new PdfPCell(new Paragraph("Institution with Potential for Excellence",font4)); 
		cell300ssr.setExtraParagraphSpace(10f);
		cell300ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell300ssr);

		PdfPCell cell30ssr = new PdfPCell(new Paragraph(
				"Is the College recognized by UGC as a College with Potential for Excellence(CPE)?",font4)); 
		cell30ssr.setExtraParagraphSpace(10f);
		cell30ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell30ssr);

		PdfPCell cell31ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.basicprofile2.get(0).getInputbtip1():"",font5));   
		cell31ssr.setExtraParagraphSpace(10f);
		cell31ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell31ssr);

		PdfPCell cell32ssr = new PdfPCell(new Paragraph(
				"Is the College recognized for its performance by any other governmental agency?\r\n" ,font4));  
		cell32ssr.setExtraParagraphSpace(10f);
		cell32ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table11ssr.addCell(cell32ssr);

		PdfPCell cell28ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.basicprofile2.get(0).getInputbtip4():"",font5));    
		cell28ssr.setExtraParagraphSpace(10f);
		cell28ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell28ssr);

		PdfPCell cell29ssr = new PdfPCell(new Paragraph("If yes, name of the agency\r\n",font4)); 
		cell29ssr.setExtraParagraphSpace(10f);
		cell29ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell29ssr);

		PdfPCell cell131ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.basicprofile2.get(0).getInputbtip5():"",font5));  
		cell131ssr.setExtraParagraphSpace(10f);
		cell131ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell131ssr);

		PdfPCell cell132ssr = new PdfPCell(new Paragraph("Date of recognition\r\n",font4)); 
		cell132ssr.setExtraParagraphSpace(10f);
		cell132ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table11ssr.addCell(cell132ssr);

		PdfPCell cell133ssr = new PdfPCell(new Paragraph(ssrData != null ?ssrData.basicprofile2.get(0).getInputbtip6():"",font5));  
		cell133ssr.setExtraParagraphSpace(10f);
		cell133ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table11ssr.addCell(cell133ssr);

//		table011ssr.addCell(table11ssr);
		document.add(table011ssr);
		document.add(table11ssr);
		table011ssr.setSpacingAfter(20f);

		PdfPTable table012ssr = new PdfPTable(1);
		table012ssr.setWidthPercentage(100f);

		PdfPCell cell012ssr = new PdfPCell(new Paragraph("Location and Area of Campus\r\n", font4));
		cell012ssr.setHorizontalAlignment(Element.ALIGN_CENTER);
		table012ssr.addCell(cell012ssr);

		PdfPTable table12ssr = new PdfPTable(5);
		table12ssr.setWidthPercentage(100f);
		table12ssr.setWidths(new int[] { 60, 60, 60, 60, 60 });
		table12ssr.setSpacingAfter(20f);
		table12ssr.setSpacingBefore(20f);
//
		cell.setPhrase(new Phrase("Campus Type\r\n", font4));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase("Address\r\n", font4));
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase("Location\r\n", font4));
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase("Campus Area in Acres\r\n", font4));
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase("Built up Area in sq.mts.\r\n", font4));
		table12ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.campus.get(0).getInputbtl11():"",font5));    
		cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.campus.get(0).getInputbtl12():"",font5));   
		cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
		
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.campus.get(0).getInputbtl13():"",font5));   
		cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.campus.get(0).getInputbtl14():"",font5));  
		cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
		cell.setPhrase(new Phrase(ssrData != null ?ssrData.campus.get(0).getInputbtl15():"",font5));  
		cell.setExtraParagraphSpace(10f);
		table12ssr.addCell(cell);
	
		cell.setPadding(5);

//		table012ssr.addCell(table12ssr);
		document.add(table012ssr);
		document.add(table12ssr);
		table012ssr.setSpacingAfter(20f);

		

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
//	

}
