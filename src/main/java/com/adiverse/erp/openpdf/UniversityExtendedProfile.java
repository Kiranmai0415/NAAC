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
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.ExtendedProfile;
import com.adiverse.erp.service.ExtendedService;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class UniversityExtendedProfile {
	
	

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


	
@Autowired
ExtendedService extendedService;


List<ExtendedProfile> epList = null;
ExtendedProfile extendedProfile = null;

public String generateReport(Map<String, String> allParams) throws DocumentException, IOException {
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
		
		
		epList = extendedService.getAllExtendedData(allParams);
		if (CollectionUtils.isNotEmpty(epList)) {
			extendedProfile = epList.get(0);
		} else {
			extendedProfile = new ExtendedProfile();
		}
		



		System.out.println("report generation path from property file ==>" + reportGeneratePath);
		if (root != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
			String strDate = formatter.format(date);
			reportPath = "UniversityExtendedProfile-" + strDate + ".pdf";
			file = root.resolve(reportPath);
		}
		System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
		
		Document document = new Document(PageSize.A4);
		// PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
		
		document.open();
		System.out.println("open the document==========>");
	//	addLogo(document);
		
		

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

		document.add(epstudent45);


		document.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return file.toAbsolutePath().toString();
}

	
		
		
	
			
//	private void addLogo(Document document) {
//		Path root = Paths.get(reportGeneratePath);
//		Path file = null;
//		try {
//			file = root.resolve("naac.png");
//			Image img = Image.getInstance(file.toAbsolutePath().toString());
//	//		img.scalePercent(logoImgScale[0], logoImgScale[1]);
//			img.setAlignment(Element.ALIGN_CENTER);
//			document.add(img);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}	

}
