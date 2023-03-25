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
public class UniversityBasicInformationReport {
	
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
				reportPath = "UniversityBasicInformationReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
		
//			addLogo(document);	
		


////////////////////////////////////////////////////////////////////profile of the program
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
		
	//	table012ssr.setSpacingAfter(20f);

		

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
