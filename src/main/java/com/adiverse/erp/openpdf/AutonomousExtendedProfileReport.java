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

import com.adiverse.erp.model.ExtendedProfile;
import com.adiverse.erp.service.ExtendedService;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;


@Component
public class AutonomousExtendedProfileReport {
	@Value("${upload.files.path}")
	private String reportGeneratePath;

	
	@Autowired
	ExtendedService extendedService;
	
	List<ExtendedProfile> epList = null;
	ExtendedProfile epRecord = null;
	
	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	

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

			epList = extendedService.getAllExtendedData(allParams);
			if (CollectionUtils.isNotEmpty(epList)) {
				epRecord = epList.get(0);
			} else {
				epRecord = new ExtendedProfile();
			}
			
			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AuthonomousExtendedProfileReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			
			System.out.println("open the document==========>");

			
	


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

		Paragraph paragraph1ep = new Paragraph("1 Program\r\n\r\n", font2);
		paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		Paragraph paragraph2ep = new Paragraph(
				"1.1 Number of programs offered year-wise for last five years\r\n\r\n", font4);
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

		epprogramme.setPadding(5);
		epprogramme.setWidth(100f);

		for (int i = 0; i < epRecord.getEpYeartable11().size(); i++) {
			
			Cell cell1 = new Cell(new Paragraph(epRecord.getEpYeartable11().get(i).getInput11y(),font5));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			epprogramme.addCell(cell1);

		}
		for (int i = 0; i < epRecord.getEpYeartable11().size(); i++) {
			Cell cell2 = new Cell(new Paragraph(epRecord.getEpYeartable11().get(i).getInput11v(),font5));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			epprogramme.addCell(cell2);

		}

		document.add(epprogramme);
		Paragraph paragraph3ep = new Paragraph("\r\n 1.2 Number of departments offering academic programmes\r\n\r\n"
				+ "Response:" + (epRecord != null ? epRecord.geteTable12v() : ""), font4);
		paragraph3ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph3ep);

		Paragraph paragraph4ep = new Paragraph(" \r\n 2 Students", font2);
		paragraph1ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph4ep);

		Paragraph paragraph5ep = new Paragraph(
				"2.1  Number of students year-wise during last five years\r\n" + "\r\n" + "", font4);
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
				"2.2  Number of outgoing / final year students year-wise during last five years\r\n" + "",
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

		Paragraph paragraph7ep = new Paragraph(
				"2.3 Number of students appeared in the examination conducted by the Institution, year-wise during the last five years\r\n"
				+ "", font4);
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
				"2.4  Number of revaluation applications year-wise during last five years\r\n" + "",
				font4);
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
				"3.1 Number of courses in all programs year-wise during last five years\r\n" + "\r\n" + "",
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
				"3.2  Number of full time teachers year-wise during the last five years\r\n" + "",
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
				"3.3  Number of sanctioned posts year-wise during last five years\r\n" + "\r\n" + "", font4);
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

		Paragraph paragraph14ep = new Paragraph(
			" 4.1  Number of eligible applications received for admissions to all the programs year-wise during last five years\r\n"
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

		Paragraph paragraph15ep = new Paragraph(
				"4.2	Number of seats earmarked for reserved category as per GOI/State Govt rule year-wise during last five years\r\n\r\n"
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
				"4.3  Total number of classrooms and seminar halls Response: 73\r\n" + "", font4);
		paragraph16ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph16ep);

		Paragraph paragraph17ep = new Paragraph(
				"4.4 Total number of computers in the campus for academic purpose Response: 1818\r\n" + "",
				font4);
		paragraph17ep.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph17ep);

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
		


		document.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return file.toAbsolutePath().toString();
}
		
			

}
