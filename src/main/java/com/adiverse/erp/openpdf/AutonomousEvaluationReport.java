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

import com.adiverse.erp.model.EvaluativereportMain;
import com.adiverse.erp.service.EvalutiveReportService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class AutonomousEvaluationReport {

	@Autowired
	EvalutiveReportService evalutiveReportService;

	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);


	List<EvaluativereportMain> evaluativereportMain1 = null;
	EvaluativereportMain evaluativereportofthedepartment = null;

	@Value("${upload.files.path}")
	private String reportGeneratePath;

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
			
	
			evaluativereportMain1=	evalutiveReportService.getAllEvaluativeData(allParams);
			if (CollectionUtils.isNotEmpty(evaluativereportMain1)) {
				evaluativereportofthedepartment = evaluativereportMain1.get(0);
			} else {
				evaluativereportofthedepartment = new EvaluativereportMain();
			}
			
			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				
				
			
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AutonomousEvaluationReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");	
		

			Paragraph paragraph1 = new Paragraph("EvaluationReport\r\n", font1);
			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            document.add(paragraph1);
            
            Paragraph paragraph2 = new Paragraph("Evaluative Report of the Departments \r\n\r\n", font2);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            document.add(paragraph2);
            
            
            Paragraph paragraph3 = new Paragraph("Name Of the Autonomous College", font4);
            paragraph3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph3);
           Paragraph paragraph4 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getNameofTheAutonomousCollege():"",font5);
    		paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph4);
    		
    		
    		
            Paragraph paragraph31 = new Paragraph("Name of the Department", font4);
            paragraph31.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph31);
    		
             Paragraph paragraph5 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getNameofTheDepartment():"",font5);
    	     paragraph5.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		 document.add(paragraph5);
    		
    		
    		  Paragraph paragraph51 = new Paragraph("Dist", font4);
    		  paragraph51.setAlignment(Paragraph.ALIGN_JUSTIFIED);
      		  document.add(paragraph51);
      		
    		 Paragraph paragraph6 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getDist():"",font5);
     		 paragraph6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	    		document.add(paragraph6);
    	    		
    	    		
    	    Paragraph paragraph61 = new Paragraph("State", font4);
    	    paragraph61.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	    document.add(paragraph61);		
    	   Paragraph paragraph7 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getState():"",font5);
    	   paragraph7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	   document.add(paragraph7);
    	    	    
    	   
    	   Paragraph paragraph71 = new Paragraph("Total Number of Departments in the institution", font4);
    	   paragraph71.setAlignment(Paragraph.ALIGN_JUSTIFIED);
   	       document.add(paragraph71);	
    	   Paragraph paragraph8 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getTotalNumberofDepartmentsIntheInstitution():""+"\r\n\r\n",font5);
    	   paragraph8.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	   document.add(paragraph8);
    	   
    	   
    	   
    	   PdfPTable table1 = new PdfPTable(5);
    	   table1.setWidthPercentage(100);
    	   

			PdfPCell cell1 = new PdfPCell(new Paragraph("S No", font4));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell2 = new PdfPCell(new Paragraph("Name of the Department.",font4));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell3 = new PdfPCell(new Paragraph("For Ex: English\r\n",font4));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell4 = new PdfPCell(new Paragraph("Zooology",font4));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell5 = new PdfPCell(new Paragraph("Bio-Technology\r\n",font4));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell6 = new PdfPCell(new Paragraph("1",font4));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell7 = new PdfPCell(new Paragraph("Year of Establishment",font4));
			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell8 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getEnglish():"",font5));
			cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell9 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getZoology():"",font5));
			cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell10 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getBioTechnology():"",font5));
			cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11 = new PdfPCell(new Paragraph("2",font4));
			cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell12 = new PdfPCell(new Paragraph("Is the Department part of a School/Faculty of the Autonomous College",font4));
			cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell13 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getEnglish():"",font5));
			cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell14 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getZoology():"",font5));
			cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell15 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getBioTechnology():"",font5));
			cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell16 = new PdfPCell(new Paragraph("3",font4));
			cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell17 = new PdfPCell(new Paragraph("Name of programmes offered",font4));
			cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell18= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getEnglish():"",font5));
			cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell19= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getZoology():"",font5));
			cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell20= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getBioTechnology():"",font5));
			cell20.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell21= new PdfPCell(new Paragraph("4",font4));
			cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell22= new PdfPCell(new Paragraph("Number of teaching posts Sanctioned/Filled",font4));
			cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell23 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getEnglish():"",font5));
			cell23.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell24= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getZoology():"",font5));
			cell24.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell25= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getBioTechnology():"",font5));
			cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell26 = new PdfPCell(new Paragraph("5",font4));
			cell26.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell27 = new PdfPCell(new Paragraph("Number of Research Projects:Total grants received",font4));
			cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell28= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getEnglish():"",font5));
			cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell29= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getZoology():"",font5));
			cell29.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell30= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getBioTechnology():"",font5));
			cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell31 = new PdfPCell(new Paragraph("6",font4));
			cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell31.setRowspan(3);
			
			PdfPCell cell32 = new PdfPCell(new Paragraph("Inter -institutional collaborative projects and Associated grants received",font4));
			cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell33 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getEnglish():"",font5));
			cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell34 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getZoology():"",font5));
			cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell35 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getBioTechnology():"",font5));
			cell35.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell36 = new PdfPCell(new Paragraph("National collaboration",font4));
			cell36.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell37 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getEnglish():"",font5));
			cell37.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell38 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getZoology():"",font5));
			cell38.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell39 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getBioTechnology():"",font5));
			cell39.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell40 = new PdfPCell(new Paragraph("International collaboration",font4));
			cell40.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell41= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getEnglish():"",font5));
			cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell42 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getZoology():"",font5));
			cell42.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell43 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getBioTechnology():"",font5));
			cell43.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell44 = new PdfPCell(new Paragraph("7",font4));
			cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell45 = new PdfPCell(new Paragraph("Departmental projects funded by DST_FIST,UGC-SAP?CAS,DPE,DBT,ICSSR,AICTE etc.,:Total grants received",font4));
			cell45.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell46 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getEnglish():"",font5));
			cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell47 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getZoology():"",font5));
			cell47.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell48= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getBioTechnology():"",font5));
			cell48.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell49= new PdfPCell(new Paragraph("8",font4));
			cell49.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell50= new PdfPCell(new Paragraph("Number of Research Projects:Total grants received",font4));
			cell50.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell51= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getEnglish():"",font5));
			cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell52= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getEnglish():"",font5));
			cell52.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell53= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getBioTechnology():"",font5));
			cell53.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell54= new PdfPCell(new Paragraph("9",font4));
			cell54.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell54.setRowspan(6);
			
			PdfPCell cell55= new PdfPCell(new Paragraph("Publications:",font4));
			cell55.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell56= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getEnglish():"",font5));
			cell56.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell57= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getZoology():"",font5));
			cell57.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell58= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getBioTechnology():"",font5));
			cell58.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell59= new PdfPCell(new Paragraph("Number of Papers published",font4));
			cell59.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell60= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getEnglish():"",font5));
			cell60.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell61= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getZoology():"",font5));
			cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell62= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getBioTechnology():"",font5));
			cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell63= new PdfPCell(new Paragraph("Number of Books with ISBN",font4));
			cell63.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell64= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getEnglish():"",font5));
			cell64.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell65= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getZoology():"",font5));
			cell65.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell66= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getBioTechnology():"",font5));
			cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell67= new PdfPCell(new Paragraph("Number of Citation Index -range/average",font4));
			cell67.setHorizontalAlignment(Element.ALIGN_CENTER);	
			PdfPCell cell68= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getEnglish():"",font5));
			cell68.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell69= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getZoology():"",font5));
			cell69.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell70= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getBioTechnology():"",font5));
			cell70.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell71= new PdfPCell(new Paragraph("Number of Citation Factor-range/average",font4));
			cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell72= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getEnglish():"",font5));
			cell72.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell73= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getZoology():"",font5));
			cell73.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell74= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getBioTechnology():"",font5));
			cell74.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell75= new PdfPCell(new Paragraph("Number of h-index",font4));
			cell75.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell76= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getEnglish():"",font5));
			cell76.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell77= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getZoology():"",font5));
			cell77.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell78= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getBioTechnology():"",font5));
			cell78.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell79= new PdfPCell(new Paragraph("10",font4));
			cell79.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell80= new PdfPCell(new Paragraph("Details of parents and income generated",font4));
			cell80.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell81= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getEnglish():"",font5));
			cell81.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell82= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getZoology():"",font5));
			cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell83= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getBioTechnology():"",font5));
			cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell84= new PdfPCell(new Paragraph("11",font4));
			cell84.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell85= new PdfPCell(new Paragraph("Details of parents and income generated",font4));
			cell85.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell86= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getEnglish():"",font5));
			cell86.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell87= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getZoology():"",font5));
			cell87.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell88= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getBioTechnology():"",font5));
			cell88.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell89= new PdfPCell(new Paragraph("12",font4));
			cell89.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell89.setRowspan(4);
			PdfPCell cell90= new PdfPCell(new Paragraph("Awards/Recognitions received at National and International level by:",font4));
			cell90.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell91= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getEnglish():"",font5));
			cell91.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell92= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getZoology():"",font5));
			cell92.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell93= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getBioTechnology():"",font5));
			cell93.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell94= new PdfPCell(new Paragraph("Faculty",font4));
			cell94.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell95= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getEnglish():"",font5));
			cell95.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell96= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getZoology():"",font5));
			cell96.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell97= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getBioTechnology():"",font5));
			cell97.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell98= new PdfPCell(new Paragraph("Doctoral/Post doctoral fellows"));
			cell98.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell99= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getEnglish():"",font5));
			cell99.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell100= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getZoology():"",font5));
			cell100.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell101= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getBioTechnology():"",font5));
			cell101.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell102= new PdfPCell(new Paragraph("Students",font4));
			cell102.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell103= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getEnglish():"",font5));
			cell103.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell104= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getZoology():"",font5));
			cell104.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell105= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getBioTechnology():"",font5));
			cell105.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell106= new PdfPCell(new Paragraph("13",font4));
			cell106.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell107= new PdfPCell(new Paragraph("How many students have cleared Civil Services and Defense Services examinations, NET,SET (SLET), GATE and other competitive examinations",font4));
			cell107.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell108= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getEnglish():"",font5));
			cell108.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell109= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getZoology():"",font5));
			cell109.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell110= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getBioTechnology():"",font5));
			cell110.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell111= new PdfPCell(new Paragraph("14",font4));
			cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell111.setRowspan(3);
			PdfPCell cell112= new PdfPCell(new Paragraph("List of dotoral students and research assoiates",font4));
			cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell113= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getEnglish():"",font5));
			cell113.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell114= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getZoology():"",font5));
			cell114.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell115= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getBioTechnology():"",font5));
			cell115.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell116= new PdfPCell(new Paragraph("Fro the host institution/uniersity",font4));
			cell116.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell117= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getEnglish():"",font5));
			cell117.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell118= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getZoology():"",font5));
			cell118.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell119= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getBioTechnology():"",font5));
			cell119.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell120= new PdfPCell(new Paragraph("Year of Establishment",font4));
			cell120.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell121= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getEnglish():"",font5));
			cell121.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell122= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getZoology():"",font5));
			cell122.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell123= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getBioTechnology():"",font5));
			cell123.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell124= new PdfPCell(new Paragraph("15",font4));
			cell124.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell125= new PdfPCell(new Paragraph("Number of Research Scholars/ Post Graduate students getting financial assistance from the University/State/Central",font4));
			cell125.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell126= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getEnglish():"",font5));
			cell126.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell127= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getZoology():"",font5));
			cell127.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell128= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getBioTechnology():"",font5));
			cell128.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table1.addCell(cell1);
			table1.addCell(cell2);
			table1.addCell(cell3);
			table1.addCell(cell4);
			table1.addCell(cell5);
			table1.addCell(cell6);
			table1.addCell(cell7);
			table1.addCell(cell8);
			table1.addCell(cell9);
			table1.addCell(cell10);
			
			
			table1.addCell(cell11);
			table1.addCell(cell12);
			table1.addCell(cell13);
			table1.addCell(cell14);
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
			table1.addCell(cell40);
			
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
			table1.addCell(cell118);
			table1.addCell(cell119);
			table1.addCell(cell120);
			
			table1.addCell(cell121);
			table1.addCell(cell122);
			table1.addCell(cell123);
			table1.addCell(cell124);
			table1.addCell(cell125);
			table1.addCell(cell126);
			table1.addCell(cell127);
			table1.addCell(cell128);
			
			document.add(table1);
			
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}
		
			
			
			
			
			
			
	
}
    	   
    	   
    	    	    		
    	    	    		
    	    		
    		
            
	

