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
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.EpInstitution41;
import com.adiverse.erp.model.ExtendedFileupload;
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
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class AffiliatedExtendedProfileReport {
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	
	   private static final float marginLeft = 11;

	      private static final  float marginBottom=9;


	      private static final float marginTop=18;
	      private static final float marginRight =19;
	      


	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);

	@Autowired
	ExtendedService extendedService;
	
	
	
	
	
	

	List<ExtendedProfile> epList = null;
	ExtendedProfile extendedProfile = null;
	
	List<ExtendedFileupload>eflIST = null;
	ExtendedFileupload eRecord = null;
			
    List<EpInstitution41> elList = null;
       EpInstitution41 eLrecord = null;


	
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
				extendedProfile = epList.get(0);
			} else {
				extendedProfile = new ExtendedProfile();
			}
			
			
			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				
				
			
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AffiliatedExtendedProfileReport-" + strDate + ".pdf";
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

	
			
			
			
			
			document.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}
}
	
			
			
		
		
			
			
		
