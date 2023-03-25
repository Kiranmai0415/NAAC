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
public class UniversityEvaluationReport {

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
				reportPath = "UniversityEvaluationReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");	
		

			Paragraph paragraph1 = new Paragraph("\r\n EvaluationReport \r\n", font1);
			paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph1);
            
            Paragraph paragraph2 = new Paragraph("\r\n Evaluative Report of the Departments \r\n", font1);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            document.add(paragraph2);
            
            
            Paragraph paragraph3 = new Paragraph("Name Of the Autonomous College", font2);
            paragraph3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph3);
           Paragraph paragraph4 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getNameofTheAutonomousCollege():"");
    		paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph4);
    		
    		
    		
            Paragraph paragraph31 = new Paragraph("Name of the Department", font2);
            paragraph31.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		document.add(paragraph31);
    		
             Paragraph paragraph5 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getNameofTheDepartment():"");
    	     paragraph5.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    		 document.add(paragraph5);
    		
    		
    		  Paragraph paragraph51 = new Paragraph("Dist", font2);
    		  paragraph51.setAlignment(Paragraph.ALIGN_JUSTIFIED);
      		  document.add(paragraph51);
      		
    		 Paragraph paragraph6 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getDist():"");
     		 paragraph6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	    		document.add(paragraph6);
    	    		
    	    		
    	    Paragraph paragraph61 = new Paragraph("State", font2);
    	    paragraph61.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	    document.add(paragraph61);		
    	   Paragraph paragraph7 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getState():"");
    	   paragraph7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	   document.add(paragraph7);
    	    	    
    	   
    	   Paragraph paragraph71 = new Paragraph("Total Number of Departments in the institution", font2);
    	   paragraph71.setAlignment(Paragraph.ALIGN_JUSTIFIED);
   	       document.add(paragraph71);	
    	   Paragraph paragraph8 = new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getTotalNumberofDepartmentsIntheInstitution():"");
    	   paragraph8.setAlignment(Paragraph.ALIGN_JUSTIFIED);
    	   paragraph8.setSpacingAfter(20f);
    	   document.add(paragraph8);
    	   
    	   
    	   
    	   
    	   
    	   PdfPTable table1 = new PdfPTable(5);
    	   table1.setWidthPercentage(100);
    	   
    	   PdfPCell cell1 = new PdfPCell(new Paragraph("S No", font2));
    	   PdfPCell cell2 = new PdfPCell(new Paragraph("Name of the Department.",font2));
			PdfPCell cell3 = new PdfPCell(new Paragraph("For Ex: English\r\n",font2));
			PdfPCell cell4 = new PdfPCell(new Paragraph("Zooology",font2));
			PdfPCell cell5 = new PdfPCell(new Paragraph("Bio-Technology\r\n",font2));
			
			PdfPCell cell6 = new PdfPCell(new Paragraph("1"));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell7 = new PdfPCell(new Paragraph("Year of Establishment"));
			PdfPCell cell8 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getEnglish():"",font5));
			PdfPCell cell9 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getZoology():"",font5));
			PdfPCell cell10 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(0).getBioTechnology():"",font5));
			
			PdfPCell cell11 = new PdfPCell(new Paragraph("2"));
			cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell12 = new PdfPCell(new Paragraph("Is the Department part of a School/Faculty of the Autonomous College"));
			PdfPCell cell13 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getEnglish():"",font5));
			PdfPCell cell14 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getZoology():"",font5));
			PdfPCell cell15 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(1).getBioTechnology():"",font5));
			
			
			PdfPCell cell16 = new PdfPCell(new Paragraph("3"));
			cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell17 = new PdfPCell(new Paragraph("Name of programmes offered"));
			PdfPCell cell18= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getEnglish():"",font5));
			PdfPCell cell19= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getZoology():"",font5));
			PdfPCell cell20= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(2).getBioTechnology():"",font5));
			
			PdfPCell cell21= new PdfPCell(new Paragraph("4"));
			cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell22= new PdfPCell(new Paragraph("Number of teaching posts Sanctioned/Filled"));
			PdfPCell cell23 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getEnglish():"",font5));
			PdfPCell cell24= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getZoology():"",font5));
			PdfPCell cell25= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(3).getBioTechnology():"",font5));
			
			PdfPCell cell26 = new PdfPCell(new Paragraph("5"));
			cell26.setHorizontalAlignment(Element.ALIGN_CENTER);
		    PdfPCell cell27 = new PdfPCell(new Paragraph("Number of Research Projects:Total grants received"));
			PdfPCell cell28= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getEnglish():"",font5));
			PdfPCell cell29= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getZoology():"",font5));
			PdfPCell cell30= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(4).getBioTechnology():"",font5));
			
			PdfPCell cell31 = new PdfPCell(new Paragraph("6"));
			cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell31.setRowspan(3);
			
			PdfPCell cell32 = new PdfPCell(new Paragraph("Inter -institutional collaborative projects and Associated grants received"));
			PdfPCell cell33 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getEnglish():"",font5));
			PdfPCell cell34 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getZoology():"",font5));
			PdfPCell cell35 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(5).getBioTechnology():"",font5));
			
			PdfPCell cell36 = new PdfPCell(new Paragraph("National collaboration"));
			
			PdfPCell cell37 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getEnglish():"",font5));
			PdfPCell cell38 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getZoology():"",font5));
			PdfPCell cell39 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(6).getBioTechnology():"",font5));
			
			PdfPCell cell40 = new PdfPCell(new Paragraph("International collaboration"));
			PdfPCell cell41= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getEnglish():"",font5));
			PdfPCell cell42 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getZoology():"",font5));
			PdfPCell cell43 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(7).getBioTechnology():"",font5));
			
			PdfPCell cell44 = new PdfPCell(new Paragraph("7"));
			cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell45 = new PdfPCell(new Paragraph("Departmental projects funded by DST_FIST,UGC-SAP?CAS,DPE,DBT,ICSSR,AICTE etc.,:Total grants received"));
			PdfPCell cell46 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getEnglish():"",font5));
			PdfPCell cell47 = new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getZoology():"",font5));
			PdfPCell cell48= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(8).getBioTechnology():"",font5));
			
			PdfPCell cell49= new PdfPCell(new Paragraph("8"));
			cell49.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell50= new PdfPCell(new Paragraph("Number of Research Projects:Total grants received"));
			PdfPCell cell51= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getEnglish():"",font5));
			PdfPCell cell52= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getEnglish():"",font5));
			PdfPCell cell53= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(9).getBioTechnology():"",font5));
			
			PdfPCell cell54= new PdfPCell(new Paragraph("9"));
			cell54.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell54.setRowspan(6);
			
			PdfPCell cell55= new PdfPCell(new Paragraph("Publications:"));
			PdfPCell cell56= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getEnglish():"",font5));
			PdfPCell cell57= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getZoology():"",font5));
			PdfPCell cell58= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(10).getBioTechnology():"",font5));
			
			PdfPCell cell59= new PdfPCell(new Paragraph("Number of Papers published"));
			PdfPCell cell60= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getEnglish():"",font5));
			PdfPCell cell61= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getZoology():"",font5));
			PdfPCell cell62= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(11).getBioTechnology():"",font5));
			
			PdfPCell cell63= new PdfPCell(new Paragraph("Number of Books with ISBN"));
			PdfPCell cell64= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getEnglish():"",font5));
			PdfPCell cell65= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getZoology():"",font5));
			PdfPCell cell66= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(12).getBioTechnology():"",font5));
			
			PdfPCell cell67= new PdfPCell(new Paragraph("Number of Citation Index -range/average"));
			PdfPCell cell68= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getEnglish():"",font5));
			PdfPCell cell69= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getZoology():"",font5));
			PdfPCell cell70= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(13).getBioTechnology():"",font5));
			
			
			PdfPCell cell71= new PdfPCell(new Paragraph("Number of Citation Factor-range/average"));
			PdfPCell cell72= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getEnglish():"",font5));
			PdfPCell cell73= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getZoology():"",font5));
			PdfPCell cell74= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(14).getBioTechnology():"",font5));
			
			
			PdfPCell cell75= new PdfPCell(new Paragraph("Number of h-index"));
			PdfPCell cell76= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getEnglish():"",font5));
			PdfPCell cell77= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getZoology():"",font5));
			PdfPCell cell78= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(15).getBioTechnology():"",font5));
			
			
			PdfPCell cell79= new PdfPCell(new Paragraph("10"));
			cell79.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell80= new PdfPCell(new Paragraph("Details of parents and income generated"));
			PdfPCell cell81= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getEnglish():"",font5));
			PdfPCell cell82= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getZoology():"",font5));
			PdfPCell cell83= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(16).getBioTechnology():"",font5));
			
			PdfPCell cell84= new PdfPCell(new Paragraph("11"));
			cell84.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell85= new PdfPCell(new Paragraph("Details of parents and income generated"));
			PdfPCell cell86= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getEnglish():"",font5));
			PdfPCell cell87= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getZoology():"",font5));
			PdfPCell cell88= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(17).getBioTechnology():"",font5));
			
			PdfPCell cell89= new PdfPCell(new Paragraph("12"));
			cell89.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell89.setRowspan(4);
			PdfPCell cell90= new PdfPCell(new Paragraph("Awards/Recognitions received at National and International level by:"));
			PdfPCell cell91= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getEnglish():"",font5));
			PdfPCell cell92= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getZoology():"",font5));
			PdfPCell cell93= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(18).getBioTechnology():"",font5));
			
			PdfPCell cell94= new PdfPCell(new Paragraph("Faculty"));
			PdfPCell cell95= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getEnglish():"",font5));
			PdfPCell cell96= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getZoology():"",font5));
			PdfPCell cell97= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(19).getBioTechnology():"",font5));
			
			PdfPCell cell98= new PdfPCell(new Paragraph("Doctoral/Post doctoral fellows"));
			PdfPCell cell99= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getEnglish():"",font5));
			PdfPCell cell100= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getZoology():"",font5));
			PdfPCell cell101= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(20).getBioTechnology():"",font5));
			
			
			PdfPCell cell102= new PdfPCell(new Paragraph("Students"));
			PdfPCell cell103= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getEnglish():"",font5));
			PdfPCell cell104= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getZoology():"",font5));
			PdfPCell cell105= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(21).getBioTechnology():"",font5));
			
			
			PdfPCell cell106= new PdfPCell(new Paragraph("13"));
			cell106.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell107= new PdfPCell(new Paragraph("How many students have cleared Civil Services and Defense Services examinations, NET,SET (SLET), GATE and other competitive examinations"));
			PdfPCell cell108= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getEnglish():"",font5));
			PdfPCell cell109= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getZoology():"",font5));
			PdfPCell cell110= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(22).getBioTechnology():"",font5));
			
			
			PdfPCell cell111= new PdfPCell(new Paragraph("14"));
			cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell111.setRowspan(3);
			PdfPCell cell112= new PdfPCell(new Paragraph("List of dotoral students and research assoiates"));
			PdfPCell cell113= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getEnglish():"",font5));
			PdfPCell cell114= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getZoology():"",font5));
			PdfPCell cell115= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(23).getBioTechnology():"",font5));
			
			
			PdfPCell cell116= new PdfPCell(new Paragraph("Fro the host institution/uniersity"));
			PdfPCell cell117= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getEnglish():"",font5));
			PdfPCell cell118= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getZoology():"",font5));
			PdfPCell cell119= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(24).getBioTechnology():"",font5));
			
			PdfPCell cell120= new PdfPCell(new Paragraph("Year of Establishment"));
			PdfPCell cell121= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getEnglish():"",font5));
			PdfPCell cell122= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getZoology():"",font5));
			PdfPCell cell123= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(25).getBioTechnology():"",font5));
			
			PdfPCell cell124= new PdfPCell(new Paragraph("15"));
			cell124.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell125= new PdfPCell(new Paragraph("Number of Research Scholars/ Post Graduate students getting financial assistance from the University/State/Central"));
			PdfPCell cell126= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getEnglish():"",font5));
			PdfPCell cell127= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getZoology():"",font5));
			PdfPCell cell128= new PdfPCell(new Paragraph(evaluativereportofthedepartment != null ?evaluativereportofthedepartment.getEvaluativereportofthedepartment11().get(26).getBioTechnology():"",font5));
			
			
			cell1.setExtraParagraphSpace(10f);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell1);
			cell2.setExtraParagraphSpace(10f);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell2);
			cell3.setExtraParagraphSpace(10f);
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell3);
			cell4.setExtraParagraphSpace(10f);
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell4);
			
			cell5.setExtraParagraphSpace(10f);
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell5);
			
			cell6.setExtraParagraphSpace(10f);
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell6);
			
			
			cell7.setExtraParagraphSpace(10f);
			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell7);
			
			cell8.setExtraParagraphSpace(10f);
			cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell8);
	
			
			cell9.setExtraParagraphSpace(10f);
			cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell9);
			
			
			cell10.setExtraParagraphSpace(10f);
			cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell10);
			
			cell11.setExtraParagraphSpace(10f);
			cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell11);
			
			
			cell12.setExtraParagraphSpace(10f);
			cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell12);
			
			cell13.setExtraParagraphSpace(10f);
			cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell13);
			
			cell14.setExtraParagraphSpace(10f);
			cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell14);
			
			cell15.setExtraParagraphSpace(10f);
			cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell15);
			
			
			cell16.setExtraParagraphSpace(10f);
			cell16.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell16);
			
			
			cell17.setExtraParagraphSpace(10f);
			cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table1.addCell(cell17);
			
			cell18.setExtraParagraphSpace(10f);
			cell18.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell18);
			
			
			cell19.setExtraParagraphSpace(10f);
			cell19.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell19);
			
			
			cell20.setExtraParagraphSpace(10f);
			cell20.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell20);
			
			
			
			cell21.setExtraParagraphSpace(10f);
			cell21.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell21);
			
			
			cell22.setExtraParagraphSpace(10f);
			cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell22);
			
			
			cell23.setExtraParagraphSpace(10f);
			cell23.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell23);
			
			
			cell24.setExtraParagraphSpace(10f);
			cell24.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell24);
			
			
			
			cell25.setExtraParagraphSpace(10f);
			cell25.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell25);
			
			cell26.setExtraParagraphSpace(10f);
			cell26.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table1.addCell(cell26);
			
			
			
			cell27.setExtraParagraphSpace(10f);
			cell27.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell27);
			
			
			cell28.setExtraParagraphSpace(10f);
			cell28.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell28);
			
			cell29.setExtraParagraphSpace(10f);
			cell29.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell29);
			
			
			cell30.setExtraParagraphSpace(10f);
			cell30.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell30);
			
			
			cell31.setExtraParagraphSpace(10f);
			cell31.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell31);
			
			
			cell32.setExtraParagraphSpace(10f);
			cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell32);
			
			
			cell33.setExtraParagraphSpace(10f);
			cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell33);
			
			
			cell34.setExtraParagraphSpace(10f);
			cell34.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell34);
			
			
			cell35.setExtraParagraphSpace(10f);
			cell35.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell35);
			
			cell36.setExtraParagraphSpace(10f);
			cell36.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table1.addCell(cell36);
			
			cell37.setExtraParagraphSpace(10f);
			cell37.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell37);
			
			cell38.setExtraParagraphSpace(10f);
			cell38.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell38);
			
			cell39.setExtraParagraphSpace(10f);
			cell39.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell39);
			
			cell40.setExtraParagraphSpace(10f);
			cell40.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell40);
			
			
			cell41.setExtraParagraphSpace(10f);
			cell41.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell41);
			
			
			
			cell42.setExtraParagraphSpace(10f);
			cell42.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell42);
			
			
			
			cell43.setExtraParagraphSpace(10f);
			cell43.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell43);
			
			cell44.setExtraParagraphSpace(10f);
			cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table1.addCell(cell44);
			
			
			
			cell45.setExtraParagraphSpace(10f);
			cell45.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell45);
			
			cell46.setExtraParagraphSpace(10f);
			cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell46);
			
			
			cell47.setExtraParagraphSpace(10f);
			cell47.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell47);
			
			
			cell48.setExtraParagraphSpace(10f);
			cell48.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell48);
			
			cell49.setExtraParagraphSpace(10f);
			cell49.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell49);
			
			cell50.setExtraParagraphSpace(10f);
			cell50.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell50);
			
			cell51.setExtraParagraphSpace(10f);
			cell51.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell51);
			
			
			cell52.setExtraParagraphSpace(10f);
			cell52.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell52);
			
			cell53.setExtraParagraphSpace(10f);
			cell53.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell53);
			
			cell54.setExtraParagraphSpace(10f);
			cell54.setHorizontalAlignment(Element.ALIGN_CENTER);
		    table1.addCell(cell54);
		    
			
		    cell55.setExtraParagraphSpace(10f);
		    cell55.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell55);
			
			cell56.setExtraParagraphSpace(10f);
			cell56.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell56);
			
			cell57.setExtraParagraphSpace(10f);
			cell57.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell57);
			
			cell58.setExtraParagraphSpace(10f);
			cell58.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell58);
			
			cell59.setExtraParagraphSpace(10f);
			cell59.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell59);
			
			cell60.setExtraParagraphSpace(10f);
			cell60.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell60);
			
			cell61.setExtraParagraphSpace(10f);
			cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell61);
			
			cell62.setExtraParagraphSpace(10f);
			cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell62);
			
			cell63.setExtraParagraphSpace(10f);
			cell63.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell63);
			
			
			cell64.setExtraParagraphSpace(10f);
			cell64.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell64);
			
			cell65.setExtraParagraphSpace(10f);
			cell65.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell65);
			
			cell66.setExtraParagraphSpace(10f);
			cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell66);
			
			
			cell67.setExtraParagraphSpace(10f);
			cell67.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell67);
			
			
			cell68.setExtraParagraphSpace(10f);
			cell68.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell68);
			
			cell69.setExtraParagraphSpace(10f);
			cell69.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell69);
			
			
			cell70.setExtraParagraphSpace(10f);
			cell70.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell70);
			
			
			
			cell71.setExtraParagraphSpace(10f);
			cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell71);
			
			
			
			
			cell72.setExtraParagraphSpace(10f);
			cell72.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell72);
			
			cell73.setExtraParagraphSpace(10f);
			cell73.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell73);
			
			cell74.setExtraParagraphSpace(10f);
			cell74.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell74);
			
			
			cell75.setExtraParagraphSpace(10f);
			cell75.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell75);
			
			cell76.setExtraParagraphSpace(10f);
			cell76.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell76);
			
			
			cell77.setExtraParagraphSpace(10f);
			cell77.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell77);
			

			cell78.setExtraParagraphSpace(10f);
			cell78.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell78);
			

			cell79.setExtraParagraphSpace(10f);
			cell79.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell79);
			
			cell80.setExtraParagraphSpace(10f);
			cell80.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell80);
		
	
			
			cell81.setExtraParagraphSpace(10f);
			cell81.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell81);
			
			
			cell82.setExtraParagraphSpace(10f);
			cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell82);
			
			
			
			cell83.setExtraParagraphSpace(10f);
			cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell83);
			
			cell84.setExtraParagraphSpace(10f);
			cell84.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell84);
			
			cell85.setExtraParagraphSpace(10f);
			cell85.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell85);
			
			
			cell86.setExtraParagraphSpace(10f);
			cell86.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell86);
			
			
			cell87.setExtraParagraphSpace(10f);
			cell87.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell87);
			
			cell88.setExtraParagraphSpace(10f);
			cell88.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell88);
			
			cell89.setExtraParagraphSpace(10f);
			cell89.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell89);
			
			
			cell90.setExtraParagraphSpace(10f);
			cell90.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell90);
			
			
			cell91.setExtraParagraphSpace(10f);
			cell91.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell91);
			
			
			cell92.setExtraParagraphSpace(10f);
			cell92.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell92);
			
			
			cell93.setExtraParagraphSpace(10f);
			cell93.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell93);
			
			
			cell94.setExtraParagraphSpace(10f);
			cell94.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell94);
			
			
			cell95.setExtraParagraphSpace(10f);
			cell95.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell95);
			
			
			cell96.setExtraParagraphSpace(10f);
			cell96.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell96);
			
			
			cell97.setExtraParagraphSpace(10f);
			cell97.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell97);
			
			
			cell98.setExtraParagraphSpace(10f);
			cell98.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell98);
			
			
			cell99.setExtraParagraphSpace(10f);
			cell99.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell99);
			
			
			cell100.setExtraParagraphSpace(10f);
			cell100.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell100);
			
			
			cell101.setExtraParagraphSpace(10f);
			cell101.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell101);
			
			
			cell102.setExtraParagraphSpace(10f);
			cell102.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell102);
			
			
			cell103.setExtraParagraphSpace(10f);
			cell103.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell103);
			
			cell104.setExtraParagraphSpace(10f);
			cell104.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell104);
			
			cell105.setExtraParagraphSpace(10f);
			cell105.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell105);
			
			
			cell106.setExtraParagraphSpace(10f);
			cell106.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell106);
			
			cell107.setExtraParagraphSpace(10f);
			cell107.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell107);
			
			cell108.setExtraParagraphSpace(10f);
			cell108.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell108);
			
			cell109.setExtraParagraphSpace(10f);
			cell109.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell109);
			
			
			cell110.setExtraParagraphSpace(10f);
			cell110.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell110);
			
			
			cell111.setExtraParagraphSpace(10f);
			cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell111);
			
			
			cell112.setExtraParagraphSpace(10f);
			cell112.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell112);
			
			cell113.setExtraParagraphSpace(10f);
			cell113.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell113);
			
			cell114.setExtraParagraphSpace(10f);
			cell114.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell114);
			
			
			cell115.setExtraParagraphSpace(10f);
			cell115.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell115);
			
			
			cell116.setExtraParagraphSpace(10f);
			cell116.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell116);
			
			
			cell117.setExtraParagraphSpace(10f);
			cell117.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell117);
			
			
			
			cell118.setExtraParagraphSpace(10f);
			cell118.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell118);
			
			cell119.setExtraParagraphSpace(10f);
			cell119.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell119);
			
			
			cell120.setExtraParagraphSpace(10f);
			cell120.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell120);
			
			
			cell121.setExtraParagraphSpace(10f);
			cell121.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell121);
			
			cell122.setExtraParagraphSpace(10f);
			cell122.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell122);
			
			cell123.setExtraParagraphSpace(10f);
			cell123.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell123);
			
			
			cell124.setExtraParagraphSpace(10f);
			cell124.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell124);
			
			cell125.setExtraParagraphSpace(10f);
			cell125.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell125);
			
			cell126.setExtraParagraphSpace(10f);
			cell126.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell126);
			
			cell127.setExtraParagraphSpace(10f);
			cell127.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell127);
			
			cell128.setExtraParagraphSpace(10f);
			cell128.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(cell128);
			
			document.add(table1);			
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}
		
			
			
			
			
			
			
	
}
    	   
    	   
    	    	    		
    	    	    		
    	    		
    		
            
	

