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
public class AffiliatedBasicInformationReport {
	
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
	ProfileoftheCollege ProfileRecord = null;
	List<EvaluativeFileUpload> Profilefile = null;

	
	public String generateReport(Map<String, String> allParams) throws DocumentException, IOException {
		String reportPath = "";
		Path root = Paths.get(reportGeneratePath);
		Path file = null;
		Date date = new Date();
		try {
			font1.setSize(16);
			font2.setSize(14);
			font4.setSize(14);
			font5.setSize(12);
			font5.setSize(12);
			
			profileList=ssrService.getAllAcademicData(allParams);
			if (CollectionUtils.isNotEmpty(profileList)) {
				ProfileRecord = profileList.get(0);
			} else {
				ProfileRecord = new ProfileoftheCollege();
			}
			
			
			

		   ObjectMapper mapper=new ObjectMapper();
		   System.out.println("ssrData====>"+mapper.writeValueAsString(ProfileRecord));
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
		
//			addLogo(document);	
		


//////		Paragraph paragraph13ssr = new Paragraph("2.PROFILE\r\n\r\n", font1);
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
		//PdfPCell cell0643200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(4).getInputatq98():"" +"\r\n\r\n", font5));
			//PdfPCell cell0653200ssr = new PdfPCell(new Paragraph(ProfileRecord != null ?ProfileRecord.getAcademicParttimeTeacheres().get(4).getInputatq99():"" +"\r\n\r\n", font5));

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
		//	table29ssr.addCell(cell0004320ssr);
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
