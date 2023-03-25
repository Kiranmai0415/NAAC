package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.QIAIndicator2;
import com.adiverse.erp.model.QIAIndicator3;
import com.adiverse.erp.model.QIAIndicatorMain;
import com.adiverse.erp.service.QiaService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service

	public class AffiliatedIiqaReport {
//		@Autowired
//		QiaService qiservice = new QiaService();
		
		@Autowired
		QiaService qiservice;	
		
		@Value("${logoImgPath}")
		private String logoImgPath;
	 	
	 	
		
		@Value("${logoImgScale}")
		private Float[] logoImgScale;
		
		@Value("${upload.files.path}")
		private String reportGeneratePath;
		
		
		public String generateReport(Map<String, String> allParams) throws DocumentException, IOException {
			String reportPath = "";
			Path root = Paths.get(reportGeneratePath);
			Path file = null;
			Date date = new Date();
			
			try {
				
				
//				Map<String, String> allParams = new HashMap<>();
//				allParams.put("collegeId", qiaData.getCriteriaId().getCollegeId(),font);
//				allParams.put("financialYear", qiaData.getCriteriaId().getFinancialYear(),font);
//				allParams.put("typeofInstitution", qiaData.getCriteriaId().getTypeofInstitution(),font);

				List<QIAIndicatorMain> qIAIndicator= qiservice.getAllQiaFiles(allParams);
				QIAIndicatorMain qiadata = qIAIndicator.get(0);
				List<QIAIndicator2> qIAIndicator1= qIAIndicator.get(0).getQiaIndicator2();
				
				List<QIAIndicator3> qIAIndicator3 = qIAIndicator.get(0).getQiaIndicator3();
				
				ObjectMapper mapper =new ObjectMapper();
				System.out.println("qIAIndicator===>"+mapper.writeValueAsString(qIAIndicator));
				
				if (root != null) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
					String strDate = formatter.format(date);
					reportPath = "iiqaReport-" + strDate + ".pdf";
					file = root.resolve(reportPath);
				}
				System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

				Document document=new Document(PageSize.A4);
			//		PdfWriter.getInstance(document,response.getOutputStream(),font);
				         //Font font = new Font(Font.FontFamily.TIMES_ROMAN, 26, Font.UNDERLINE, BaseColor.BLACK);
				PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
				
				       		document.open();
				       	//	addLogo(document);
					
					Font fontTitle=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
					fontTitle.setSize(16);
					//fontTitle.setColor(Color.RED);


			   Paragraph paragraph=new Paragraph("Institutional Information for Quality Assessment(IIQA)"
							,fontTitle);
					   paragraph.setAlignment(Paragraph.ALIGN_CENTER);
					   PdfPCell cell1= new PdfPCell();
					
					   document.add(cell1);
					   paragraph.setSpacingAfter(10f);
			   document.add(paragraph);
					
				Font fontParagraph4=FontFactory.getFont(FontFactory.COURIER_BOLD);
				fontParagraph4.setSize(12);
			         Paragraph paragraph5=new Paragraph(qIAIndicator1.get(0).getInputiiqa1t2()
							,fontParagraph4);
					paragraph5.setAlignment(Paragraph.ALIGN_LEFT);
					
					paragraph.setSpacingAfter(10f);
					document.add(paragraph5);
					
			  
			
					Font font=FontFactory.getFont(FontFactory.TIMES_ROMAN);
					font.setSize(11);
					//fontTitle1.setColor(Color.RED);
					  
			//creating table 4 cloums date of submission	
					
				PdfPTable table = new PdfPTable(4);
				table.setWidthPercentage(70);
				table.setWidths(new int[]{60,60,30,60});
				table.setHorizontalAlignment(table.ALIGN_LEFT );
				
				
				PdfPCell cell3 = new PdfPCell(new Paragraph("",font)); cell3.setExtraParagraphSpace(10f);
				PdfPCell cell4 = new PdfPCell(new Paragraph("Date of submission",font)); cell4.setExtraParagraphSpace(10f);
				cell4.setExtraParagraphSpace(10f);
				PdfPCell cell5 = new PdfPCell(new Paragraph(":",font)); cell5.setExtraParagraphSpace(10f);
				cell5.setExtraParagraphSpace(10f);
				PdfPCell cell6 = new PdfPCell(new Paragraph(qiadata.getInputIiqaDate(),font)); 
				cell6.setExtraParagraphSpace(10f);   
				cell6.setExtraParagraphSpace(10f);
				cell6	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell7 = new PdfPCell(new Paragraph("",font)); cell7.setExtraParagraphSpace(10f);
				
				
				PdfPCell cell8 = new PdfPCell(new Paragraph("AISHE ID",font)); cell8.setExtraParagraphSpace(10f);
				cell8.setExtraParagraphSpace(10f);
				PdfPCell cell9 = new PdfPCell(new Paragraph(":",font)); cell4.setExtraParagraphSpace(10f);
				PdfPCell cell10 = new PdfPCell(new Paragraph(qiadata.getInputIiqaAisheId(),font)); cell9.setExtraParagraphSpace(10f);    
				cell10.setExtraParagraphSpace(10f);
				cell10	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell14 = new PdfPCell(new Paragraph("",font)); cell14.setExtraParagraphSpace(10f);
				PdfPCell cell11 = new PdfPCell(new Paragraph("Institution Track ID",font)); cell11.setExtraParagraphSpace(10f);
				cell11.setExtraParagraphSpace(10f);
				
				PdfPCell cell12 = new PdfPCell(new Paragraph(":",font)); cell12.setExtraParagraphSpace(10f);
				PdfPCell cell13 = new PdfPCell(new Paragraph(qiadata.getInputIiqaTrackId(),font)); cell13.setExtraParagraphSpace(10f);     
				cell13.setExtraParagraphSpace(10f);
				cell13	.setHorizontalAlignment(Element.ALIGN_CENTER);
			  
				
				
				table.addCell(cell3);
				table.addCell(cell4);
				table.addCell(cell5);
				table.addCell(cell6);
				table.addCell(cell7);
				table.addCell(cell8);
				table.addCell(cell9);
				table.addCell(cell10);
				table.addCell(cell14);
				table.addCell(cell11);
				table.addCell(cell12);
				table.addCell(cell13);
				table.setSpacingBefore(10f);
				table.setSpacingAfter(10f);
				document.add(table);
				
		// application  table
				
				PdfPTable table1 = new PdfPTable(3);
				table1.setWidthPercentage(100);
				table1.setWidths(new int[]{10,90,90});
				table1.setHorizontalAlignment(table.ALIGN_LEFT );
			//\r\n\r\n
			
				PdfPCell cell15 = new PdfPCell(new Paragraph("   1",font)); cell15.setExtraParagraphSpace(10f); //nested column
				cell15.setRowspan(2);
				PdfPCell cell16 = new PdfPCell(new Paragraph("Application For",font)); cell16.setExtraParagraphSpace(10f);
				
				PdfPCell cell17 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa1t1(),font)); cell17.setExtraParagraphSpace(10f);   
				cell17.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell18 = new PdfPCell(new Paragraph("Cycle of Accreditation ",font)); cell18.setExtraParagraphSpace(10f); //nested
				
				PdfPCell cell19 = new PdfPCell(new Paragraph("",font)); cell4.setExtraParagraphSpace(10f);
				
		//creating another table 
		//table 1
				
				


		
					
					
				PdfPTable table4141 = new PdfPTable(4);
				PdfPCell cell201 = new PdfPCell(new Paragraph("Cycle",font)); cell201.setExtraParagraphSpace(10f);
				PdfPCell cell202 = new PdfPCell(new Paragraph("Date",font)); cell202.setExtraParagraphSpace(10f);
				PdfPCell cell203 = new PdfPCell(new Paragraph("Grade",font)); cell203.setExtraParagraphSpace(10f);
				PdfPCell cell204 = new PdfPCell(new Paragraph("Score",font)); cell204.setExtraParagraphSpace(10f);
				table4141.addCell(cell201);
				table4141.addCell(cell202);
				table4141.addCell(cell203);
				table4141.addCell(cell204);
				
				
				for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
					{
					
				PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator12().get(i).getInputiiqa1t3()),font)); cell000001.setExtraParagraphSpace(10f);
				cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4141.addCell(cell000001);
				
				PdfPCell cell0000011=new PdfPCell(new Paragraph((qiadata.getQiaIndicator12().get(i).getInputiiqa1t4()),font)); cell0000011.setExtraParagraphSpace(10f);
				cell0000011.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4141.addCell(cell0000011);
				
				PdfPCell cell000001111=new PdfPCell(new Paragraph((qiadata.getQiaIndicator12().get(i).getInputiiqa1t5()),font)); cell000001111.setExtraParagraphSpace(10f);
				cell000001111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4141.addCell(cell000001111);
				
				PdfPCell cell0000016111=new PdfPCell(new Paragraph((qiadata.getQiaIndicator12().get(i).getInputiiqa1t6()),font)); cell0000016111.setExtraParagraphSpace(10f);
				cell0000016111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4141.addCell(cell0000016111);
					}
				
					
//					for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//					{
//					
//					
//				}
//					for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//					{
//					
//					
//					}
//					for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//					{
//					
//					
//					}
//				
				 table4141.setSpacingBefore(20f);
				 table4141.setSpacingAfter(20f);
//					PdfPCell cell19 = new PdfPCell();
				 cell19.addElement(table4141);
			
					//cell19.addElement(cell19);
				
				PdfPCell cell20 = new PdfPCell(new Paragraph("   2",font)); cell20.setExtraParagraphSpace(10f);
				PdfPCell cell21 = new PdfPCell(new Paragraph("Name of the College ",font)); cell21.setExtraParagraphSpace(10f);
				PdfPCell cell22 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa1t2(),font)); cell22.setExtraParagraphSpace(10f);    
				cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell23 = new PdfPCell(new Paragraph("   3",font)); cell23.setExtraParagraphSpace(10f);
				PdfPCell cell24 = new PdfPCell(new Paragraph("Date of establishment of the Institution",font)); cell24.setExtraParagraphSpace(10f);
				PdfPCell cell25 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa3t1(),font)); cell25.setExtraParagraphSpace(10f);     
				cell25	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell26 = new PdfPCell(new Paragraph("   4",font)); cell26.setExtraParagraphSpace(10f);
				cell26.setRowspan(2);//nested column
				PdfPCell cell27 = new PdfPCell(new Paragraph("Name of the Head of the Institution",font)); cell27.setExtraParagraphSpace(10f);
				PdfPCell cell28 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa4t1(),font)); cell28.setExtraParagraphSpace(10f);     
				cell28	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell29 = new PdfPCell(new Paragraph("Designation",font)); cell29.setExtraParagraphSpace(10f);
				PdfPCell cell30 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa4t2(),font)); cell30.setExtraParagraphSpace(10f);     
				cell30	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell31 = new PdfPCell(new Paragraph("   5",font)); cell31.setExtraParagraphSpace(10f);
				PdfPCell cell32 = new PdfPCell(new Paragraph("Does the college function from Own Campus ",font)); cell32.setExtraParagraphSpace(10f);
				PdfPCell cell33 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa5t1(),font)); cell33.setExtraParagraphSpace(10f);       
				cell33	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell34 = new PdfPCell(new Paragraph("   6",font)); cell34.setExtraParagraphSpace(10f);
				cell34.setRowspan(10);
				PdfPCell cell35 = new PdfPCell(new Paragraph("Address of the College",font)); cell35.setExtraParagraphSpace(10f);
				PdfPCell cell36 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa5t1(),font)); cell36.setExtraParagraphSpace(10f);   
				cell36.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell37 = new PdfPCell(new Paragraph("State/UT",font)); cell37.setExtraParagraphSpace(10f);
				PdfPCell cell38 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t2(),font)); cell38.setExtraParagraphSpace(10f);      
				cell38	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell39 = new PdfPCell(new Paragraph("District",font)); cell39.setExtraParagraphSpace(10f);
				PdfPCell cell40 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t3(),font)); cell40.setExtraParagraphSpace(10f);   
				cell40	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell41 = new PdfPCell(new Paragraph("City",font)); cell41.setExtraParagraphSpace(10f);
				PdfPCell cell42 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t4(),font)); cell42.setExtraParagraphSpace(10f);       
				cell42	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell43 = new PdfPCell(new Paragraph("Pin",font)); cell43.setExtraParagraphSpace(10f);
				PdfPCell cell44 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t5(),font)); cell44.setExtraParagraphSpace(10f);  
				cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell45 = new PdfPCell(new Paragraph("Phone No",font)); cell4.setExtraParagraphSpace(10f);
				PdfPCell cell46 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t6(),font)); cell46.setExtraParagraphSpace(10f);      
				cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell47 = new PdfPCell(new Paragraph("Fax No",font)); cell47.setExtraParagraphSpace(10f);
				PdfPCell cell48 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t7(),font)); cell48.setExtraParagraphSpace(10f); 
				cell48	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell49 = new PdfPCell(new Paragraph("Mobile No ",font)); cell49.setExtraParagraphSpace(10f);
				PdfPCell cell50 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t8(),font)); cell50.setExtraParagraphSpace(10f); 
				cell50.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell51 = new PdfPCell(new Paragraph("Registered Email",font)); cell51.setExtraParagraphSpace(10f);
				PdfPCell cell52 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t9(),font)); cell52.setExtraParagraphSpace(10f);       
				cell52.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell53 = new PdfPCell(new Paragraph("Alternate Email ",font)); cell53.setExtraParagraphSpace(10f);
				PdfPCell cell54 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t10(),font)); cell54.setExtraParagraphSpace(10f);    
				cell54.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell55 = new PdfPCell(new Paragraph("   7",font)); cell55.setExtraParagraphSpace(10f);
				cell55.setRowspan(11);
				PdfPCell cell56 = new PdfPCell(new Paragraph(" Alternate Faculty Contact Details ",font)); cell56.setExtraParagraphSpace(10f);//1
		        PdfPCell cell57 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t1(),font)); cell57.setExtraParagraphSpace(10f);     
		        cell57    .setHorizontalAlignment(Element.ALIGN_CENTER);
		        PdfPCell cell58 = new PdfPCell(new Paragraph("Address",font)); cell58.setExtraParagraphSpace(10f);//2
				PdfPCell cell59 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t2(),font)); cell59.setExtraParagraphSpace(10f);     
				cell59 .setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell60 = new PdfPCell(new Paragraph("State/UT",font)); cell60.setExtraParagraphSpace(10f);//3
				PdfPCell cell61 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t3(),font)); cell61.setExtraParagraphSpace(10f);   
				cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell62 = new PdfPCell(new Paragraph("District",font)); cell62.setExtraParagraphSpace(10f);//4
				PdfPCell cell63 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t4(),font)); cell63.setExtraParagraphSpace(10f);    
				cell63	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell64 = new PdfPCell(new Paragraph("City",font)); cell64.setExtraParagraphSpace(10f);//5
				PdfPCell cell65 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t4(),font)); cell65.setExtraParagraphSpace(10f);   
				cell65.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell66 = new PdfPCell(new Paragraph("Pin",font)); cell66.setExtraParagraphSpace(10f);//6
				PdfPCell cell67 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t5(),font)); cell67.setExtraParagraphSpace(10f);       
				cell67	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell68 = new PdfPCell(new Paragraph("Phone No",font)); cell68.setExtraParagraphSpace(10f);//7
				PdfPCell cell69 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t6(),font)); cell69.setExtraParagraphSpace(10f);  
				cell69.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell70 = new PdfPCell(new Paragraph("Fax No",font)); cell69.setExtraParagraphSpace(10f);//8
				PdfPCell cell71 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t7(),font)); cell71.setExtraParagraphSpace(10f);      
				cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell72 = new PdfPCell(new Paragraph("Mobile No ",font)); cell72.setExtraParagraphSpace(10f); //9;
				PdfPCell cell73 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t8(),font)); cell73.setExtraParagraphSpace(10f); 
				cell73.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell74 = new PdfPCell(new Paragraph("Email ",font)); cell74.setExtraParagraphSpace(10f);//10
				PdfPCell cell75 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t9(),font)); cell75.setExtraParagraphSpace(10f);     
				cell75		.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell76 = new PdfPCell(new Paragraph("Alternate Email ",font)); cell76.setExtraParagraphSpace(10f); //11
				PdfPCell cell77 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t10(),font)); cell77.setExtraParagraphSpace(10f);   
				cell77.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell78 = new PdfPCell(new Paragraph("   8",font)); cell78.setExtraParagraphSpace(10f);
				PdfPCell cell79 = new PdfPCell(new Paragraph("Website",font)); cell79.setExtraParagraphSpace(10f);
				PdfPCell cell80 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa8t1(),font)); cell80.setExtraParagraphSpace(10f);       
				cell80.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell81 = new PdfPCell(new Paragraph("   9",font)); cell81.setExtraParagraphSpace(10f);
				PdfPCell cell82 = new PdfPCell(new Paragraph("Has the Institution completed 6 years of existence/"
						+ "Years of graduation of last two batches",font)); cell82.setExtraParagraphSpace(10f);
				PdfPCell cell83 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa9t1(),font)); cell83.setExtraParagraphSpace(10f);      
				cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell84 = new PdfPCell(new Paragraph("    10",font)); cell84.setExtraParagraphSpace(10f);
				PdfPCell cell85 = new PdfPCell(new Paragraph("Nature of the college",font)); cell85.setExtraParagraphSpace(10f);
				PdfPCell cell86 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa10t1(),font)); cell86.setExtraParagraphSpace(10f);   
				cell86.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell87 = new PdfPCell(new Paragraph("   11",font)); cell87.setExtraParagraphSpace(10f);
				PdfPCell cell88 = new PdfPCell(new Paragraph("College Affiliation",font)); cell88.setExtraParagraphSpace(10f);
				PdfPCell cell89 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa11t1(),font)); cell89.setExtraParagraphSpace(10f);  
				cell89.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell90 = new PdfPCell(new Paragraph("   12",font)); cell90.setExtraParagraphSpace(10f);
				
				//College AffiliationName of the affiliating University(ies) and the state(s) in which the University(ies) is located
				
				
				PdfPCell cell91 = new PdfPCell(new Paragraph(" Name of the affiliating University" //table in side table 12
						+ "(ies) and the state(s) in which the University"
						
						+ "(ies) is located",font));
				cell91.setExtraParagraphSpace(10f);
				PdfPCell cell92 = new PdfPCell(new Paragraph("",font)); cell92.setExtraParagraphSpace(10f);
		//		cell92.setRowspan(3);
				
				
				PdfPTable table41411 = new PdfPTable(3);
				PdfPCell cell701 = new PdfPCell(new Paragraph("State",font)); cell701.setExtraParagraphSpace(10f);
				PdfPCell cell702 = new PdfPCell(new Paragraph(qIAIndicator3.get(0).getInputiiqa12t1(),font)); cell702.setExtraParagraphSpace(10f);
				PdfPCell cell703 = new PdfPCell(new Paragraph("Universite",font)); cell703.setExtraParagraphSpace(10f);
				PdfPCell cell704 = new PdfPCell(new Paragraph(qIAIndicator3.get(0).getInputiiqa12t2(),font)); cell704.setExtraParagraphSpace(10f);
				PdfPCell cell705 = new PdfPCell(new Paragraph("Documents",font)); cell705.setExtraParagraphSpace(10f);
				PdfPCell cell706 = new PdfPCell(new Paragraph(qIAIndicator3.get(0).getInputiiqa12t3(),font)); cell706.setExtraParagraphSpace(10f);
				
				
				
				table41411.addCell(cell701);
				table41411.addCell(cell702);
				table41411.addCell(cell703);
				table41411.addCell(cell704);
				table41411.addCell(cell705);
				table41411.addCell(cell706);
				
				
				 table41411.setSpacingBefore(20f);
				 table41411.setSpacingAfter(20f);
				cell92.addElement(table41411);
			
			
				
			//QIAIndicator3	
				
				
				
				
				PdfPCell cell93 = new PdfPCell(new Paragraph("   13",font)); cell93.setExtraParagraphSpace(10f);
				PdfPCell cell94 = new PdfPCell(new Paragraph("s the Institution recognized under section 2(f) of the\r\n"
						+ "UGC Act?",font)); cell94.setExtraParagraphSpace(10f);
				PdfPCell cell95 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa13t1(),font)); cell95.setExtraParagraphSpace(10f);    
				cell95.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell96 = new PdfPCell(new Paragraph("   14",font)); cell96.setExtraParagraphSpace(10f);
				PdfPCell cell97 = new PdfPCell(new Paragraph("Is the Institution recognized under section 12B of the\r\n"
						+ "UGC Act?\r\n"
						+ " If yes, date of recognition by UGC under section\r\n"
						+ "   12B along with latest Plan General Development\r\n"
						+ "Grant release letter",font)); cell97.setExtraParagraphSpace(10f);
				PdfPCell cell98 = new PdfPCell(new Paragraph(new Paragraph(qIAIndicator1.get(0).getInputiiqa14t1(),font)));
				cell98.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell99 = new PdfPCell(new Paragraph("   15",font)); cell99.setExtraParagraphSpace(10f);
				PdfPCell cell100 = new PdfPCell(new Paragraph("Is the institution recognised as an Autonomous\r\n"
						+ "College by the UGC?\r\n"
						+ "",font)); cell100.setExtraParagraphSpace(10f);
				
				PdfPCell cell101 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa15t1(),font)); cell101.setExtraParagraphSpace(10f);      
				cell101.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell102 = new PdfPCell(new Paragraph("   16",font)); cell102.setExtraParagraphSpace(10f);
				PdfPCell cell103 = new PdfPCell(new Paragraph("Is the institution recognised as a ‘College with\r\n"
						+ "Potential for Excellence (CPE)’ by the UGC?",font)); cell103.setExtraParagraphSpace(10f);
				
				PdfPCell cell104 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa16t1(),font)); cell104.setExtraParagraphSpace(10f);     
				cell104	.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell105 = new PdfPCell(new Paragraph("   17",font)); cell105.setExtraParagraphSpace(10f);
				PdfPCell cell106 = new PdfPCell(new Paragraph(" Is the institution recognised as a ‘College of\r\n"
						+ "Excellence’ by the UGC?",font)); cell106.setExtraParagraphSpace(10f);
				PdfPCell cell107 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa17t1(),font)); cell107.setExtraParagraphSpace(10f);     
				cell107	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell108 = new PdfPCell(new Paragraph("   18",font)); cell108.setExtraParagraphSpace(10f);
				cell108.setRowspan(2);
				PdfPCell cell109 = new PdfPCell(new Paragraph(" Is the College offering any programmes recognised\r\n"
						+ "by any Statutory Regulatory Authority (SRA)\r\n"
						+ "",font)); cell109.setExtraParagraphSpace(10f);
				PdfPCell cell110 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa18t1(),font)); cell110.setExtraParagraphSpace(10f);     
				cell110	.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell111 = new PdfPCell(new Paragraph("Statutory Regulatory Authorities",font)); cell111.setExtraParagraphSpace(10f);
				PdfPCell cell112 = new PdfPCell(new Paragraph("",font)); cell112.setExtraParagraphSpace(10f);
		//nested table
				
				int sizen2 = qiadata.getQiaIndicator4().size();
				PdfPTable table4152 = new PdfPTable(2);
				table4152.setSpacingBefore(20f);
				PdfPCell cell601 = new PdfPCell(new Paragraph("SRA program",font)); cell601.setExtraParagraphSpace(10f);
				PdfPCell cell602 = new PdfPCell(new Paragraph("Document",font)); cell602.setExtraParagraphSpace(10f);
//				PdfPCell cell603 = new PdfPCell(new Paragraph(qiadata.getQiaIndicator4().get(0).getIiqa18t2(),font)); cell4.setExtraParagraphSpace(10f);       .setHorizontalAlignment(Element.ALIGN_CENTER);
//				PdfPCell cell604 = new PdfPCell(new Paragraph(qiadata.getQiaIndicator4().get(0).getIiqa18t2(),font)); cell4.setExtraParagraphSpace(10f);       .setHorizontalAlignment(Element.ALIGN_CENTER);
				
				
				table4152.addCell(cell601 );
				table4152.addCell(cell602 );
				for(int i = 0; i<qiadata.getQiaIndicator4().size();i++)
				{
				PdfPCell cell000001111=new PdfPCell(new Paragraph((qiadata.getQiaIndicator4().get(i).getInputiiqa18t2()),font)); cell4.setExtraParagraphSpace(10f);
				cell000001111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4152.addCell(cell000001111);
				
				
				PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator4().get(i).getInputiiqa18t3()),font)); cell4.setExtraParagraphSpace(10f);
				cell000001111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table4152.addCell(cell000001111);
				
				
				}

				
				cell112.addElement(table4152);
			
				 table4152.setSpacingAfter(20f);


				PdfPCell cell113 = new PdfPCell(new Paragraph("   19",font)); cell113.setExtraParagraphSpace(10f);
				PdfPCell cell114 = new PdfPCell(new Paragraph("If the institution is not affiliated to a university and is\r\n"
						+ "offering programmes recognized by any Statutory\r\n"
						+ "Regulatory Authorities (SRA), are the programmes\r\n"
						+ "recognized by Association of Indian Universities(AIU)\r\n"
						+ "or other appropriate Government authorities as\r\n"
						+ "equivalent to UG / PG Programmes of a University",font)); cell114.setExtraParagraphSpace(10f);
				PdfPCell cell115 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa19t1(),font)); cell115.setExtraParagraphSpace(10f);     
				cell115.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell116 = new PdfPCell(new Paragraph("   20",font)); cell116.setExtraParagraphSpace(10f);
				PdfPCell cell117 = new PdfPCell(new Paragraph("Number of programmes offered",font)); cell117.setExtraParagraphSpace(10f);
				
				
		//table20
				int sizen4 = qiadata.getQiaIndicator5().size();
				PdfPTable table5154 = new PdfPTable(2);
				table5154.setSpacingBefore(20f);
				PdfPCell cell7011 = new PdfPCell(new Paragraph("Programmes",font)); cell7011.setExtraParagraphSpace(10f);
				PdfPCell cell7021 = new PdfPCell(new Paragraph("Number",font)); cell7021.setExtraParagraphSpace(10f);
				table5154.addCell(cell7011);
				table5154.addCell(cell7021);
				for(int i = 0; i<qiadata.getQiaIndicator5().size();i++)
				{
     PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator5().get(i).getInputiiqa20t1()),font)); cell000001.setExtraParagraphSpace(10f);
     cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
 	table5154.addCell(cell000001);
     
	       PdfPCell cell0000011=new PdfPCell(new Paragraph((qiadata.getQiaIndicator5().get(i).getInputiiqa20t2()),font)); cell0000011.setExtraParagraphSpace(10f);
	       cell0000011.setHorizontalAlignment(Element.ALIGN_CENTER);
 	       table5154.addCell(cell0000011);
				}

				
				cell117.addElement(table5154);
			
				 table5154.setSpacingAfter(20f);
				 cell117.setColspan(2);
				
				
				
				//PdfPCell cell118 = new PdfPCell(new Paragraph("",font)); cell4.setExtraParagraphSpace(10f);
				
				PdfPCell cell119= new PdfPCell(new Paragraph("   21",font)); cell119.setExtraParagraphSpace(10f);
				PdfPCell cell120 = new PdfPCell(new Paragraph("Programme Details",font)); cell120.setExtraParagraphSpace(10f);
		//table21
				//table21
						int sizen9 = qiadata.getQiaIndicator6().size();
						PdfPTable table6154 = new PdfPTable(5);
						table6154.setSpacingBefore(20f);
						PdfPCell cell903 = new PdfPCell(new Paragraph("Programmes",font)); cell903.setExtraParagraphSpace(10f);
						PdfPCell cell904 = new PdfPCell(new Paragraph("Department",font)); cell904.setExtraParagraphSpace(10f);
						PdfPCell cell905 = new PdfPCell(new Paragraph("University Affiliation",font)); cell905.setExtraParagraphSpace(10f);
						PdfPCell cell906 = new PdfPCell(new Paragraph("SRA Recognition",font)); cell906.setExtraParagraphSpace(10f);
						PdfPCell cell907 = new PdfPCell(new Paragraph("Affiliation Status",font)); cell907.setExtraParagraphSpace(10f);
						table6154.addCell(cell903);
						table6154.addCell(cell904);
						table6154.addCell(cell905);
						table6154.addCell(cell906);
						table6154.addCell(cell907);
						for(int i = 0; i<qiadata.getQiaIndicator6().size();i++)
						{
					PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator6().get(i).getInputiiqa21t1()),font)); cell000001.setExtraParagraphSpace(10f);
					cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
					table6154.addCell(cell000001);
						PdfPCell cell0000091=new PdfPCell(new Paragraph((qiadata.getQiaIndicator6().get(i).getInputiiqa21t2()),font)); cell0000091.setExtraParagraphSpace(10f);
						cell0000091.setHorizontalAlignment(Element.ALIGN_CENTER);
						table6154.addCell(cell0000091);
						
						
						PdfPCell cell00000991=new PdfPCell(new Paragraph((qiadata.getQiaIndicator6().get(i).getInputiiqa21t3()),font)); cell00000991.setExtraParagraphSpace(10f);
						cell00000991.setHorizontalAlignment(Element.ALIGN_CENTER);
						table6154.addCell(cell00000991);
						
				PdfPCell cell000009991=new PdfPCell(new Paragraph((qiadata.getQiaIndicator6().get(i).getInputiiqa21t4()),font)); cell000009991.setExtraParagraphSpace(10f);
				cell000009991.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6154.addCell(cell000009991);
				
						PdfPCell cell00000221=new PdfPCell(new Paragraph((qiadata.getQiaIndicator6().get(i).getInputiiqa21t5()),font)); cell00000221.setExtraParagraphSpace(10f);
						cell00000221.setHorizontalAlignment(Element.ALIGN_CENTER);
						table6154.addCell(cell00000221);
						
						}

						
						cell120.addElement(table6154);
						 cell120.setColspan(2);
						
						
				
			//	PdfPCell cell121 = new PdfPCell(new Paragraph(" ",font)); cell4.setExtraParagraphSpace(10f);
				PdfPCell cell122 = new PdfPCell(new Paragraph("   22 ",font)); cell122.setExtraParagraphSpace(10f);
				PdfPCell cell123 = new PdfPCell(new Paragraph(" Number of Teaching Staff by employment status (permanent / temporary) and by gender ",font)); cell123.setExtraParagraphSpace(10f);
				PdfPCell cell124 = new PdfPCell(new Paragraph(" ",font)); cell124.setExtraParagraphSpace(10f);
				PdfPCell cell125 = new PdfPCell(new Paragraph("   23 ",font)); cell125.setExtraParagraphSpace(10f);
				PdfPCell cell126 = new PdfPCell(new Paragraph(" Number of Non-Teaching Staff by employment status (permanent / temporary) and by gender ",font)); cell126.setExtraParagraphSpace(10f);
		//table23
				int sizen11 = qiadata.getQiaIndicator9().size();
				PdfPTable table7154 = new PdfPTable(4);
			
				PdfPCell cell1903 = new PdfPCell(new Paragraph("Male",font)); cell1903.setExtraParagraphSpace(10f);
				PdfPCell cell1904 = new PdfPCell(new Paragraph("Female",font)); cell1904.setExtraParagraphSpace(10f);
				PdfPCell cell1905 = new PdfPCell(new Paragraph("Transgender",font)); cell1905.setExtraParagraphSpace(10f);
				PdfPCell cell1906 = new PdfPCell(new Paragraph("Total",font)); cell1906.setExtraParagraphSpace(10f);
				
				table7154.addCell(cell1903);
				table7154.addCell(cell1904);
				table7154.addCell(cell1905);
				table7154.addCell(cell1906);

				for(int i = 0; i<qiadata.getQiaIndicator9().size();i++)
				{
				PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator9().get(i).getInputiiqa23t1()),font)); cell000001.setExtraParagraphSpace(10f);
				cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
				table7154.addCell(cell000001);
				
	PdfPCell cell0009001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator9().get(i).getInputiiqa23t2()),font)); cell0009001.setExtraParagraphSpace(10f);
	cell0009001.setHorizontalAlignment(Element.ALIGN_CENTER);
	table7154.addCell(cell0009001);
				PdfPCell cell0080001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator9().get(i).getInputiiqa23t3()),font)); cell0080001.setExtraParagraphSpace(10f);
				cell0080001.setHorizontalAlignment(Element.ALIGN_CENTER);
				table7154.addCell(cell0080001);
				
				
			PdfPCell cell06600001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator9().get(i).getInputiiqa23t4()),font)); cell06600001.setExtraParagraphSpace(10f);
			cell06600001.setHorizontalAlignment(Element.ALIGN_CENTER);
			table7154.addCell(cell06600001);
			
			
				
				}

				
				cell126.addElement(table7154);
				 cell126.setColspan(2);
			
				
				//PdfPCell cell127 = new PdfPCell(new Paragraph(" ",font)); cell4.setExtraParagraphSpace(10f);
				PdfPCell cell128 = new PdfPCell(new Paragraph("   24 ",font)); cell128.setExtraParagraphSpace(10f);
				PdfPCell cell129 = new PdfPCell(new Paragraph("Number of Students on roll by gender ",font)); cell129.setExtraParagraphSpace(10f);

			//	PdfPCell cell130 = new PdfPCell(new Paragraph(" ",font)); cell4.setExtraParagraphSpace(10f);
		//table	24
				int sizen12 = qiadata.getQiaIndicator10().size();
				PdfPTable table8154 = new PdfPTable(4);
			
				PdfPCell cell2903 = new PdfPCell(new Paragraph("Male",font)); cell2903.setExtraParagraphSpace(10f);
				PdfPCell cell2904 = new PdfPCell(new Paragraph("Female",font)); cell2904.setExtraParagraphSpace(10f);
				PdfPCell cell2905 = new PdfPCell(new Paragraph("Transgender",font)); cell2905.setExtraParagraphSpace(10f);
				PdfPCell cell2906 = new PdfPCell(new Paragraph("Total",font)); cell2906.setExtraParagraphSpace(10f);
				
				table8154.addCell(cell2903);
				table8154.addCell(cell2904);
				table8154.addCell(cell2905);
				table8154.addCell(cell2906);

				for(int i = 0; i<qiadata.getQiaIndicator10().size();i++)
				{
			PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator10().get(i).getInputiiqa24t1()),font)); cell2906.setExtraParagraphSpace(10f);
			cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
			table8154.addCell(cell000001);
			
				PdfPCell cell66000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator10().get(i).getInputiiqa24t2()),font)); cell66000001.setExtraParagraphSpace(10f);
				cell66000001.setHorizontalAlignment(Element.ALIGN_CENTER);
				table8154.addCell(cell66000001);
				
				
			PdfPCell cell0000012222=new PdfPCell(new Paragraph((qiadata.getQiaIndicator10().get(i).getInputiiqa24t3()),font)); cell0000012222.setExtraParagraphSpace(10f);
			cell0000012222.setHorizontalAlignment(Element.ALIGN_CENTER);
			table8154.addCell(cell0000012222);
			
			
			PdfPCell cell888000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator10().get(i).getInputiiqa24t4()),font)); cell888000001.setExtraParagraphSpace(10f);
			
			cell888000001.setHorizontalAlignment(Element.ALIGN_CENTER);
			table8154.addCell(cell888000001);
			
			
				
				}

				
				cell129.addElement(table8154);
				 cell129.setColspan(2);
			//	Table table = new Table(1,1);

				PdfPCell cell131 = new PdfPCell(new Paragraph("   25 ",font)); cell131.setExtraParagraphSpace(10f);
				PdfPCell cell132 = new PdfPCell(new Paragraph("Does the institution have statutory cells / committees",font)); cell132.setExtraParagraphSpace(10f);
				PdfPCell cell133 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa25t1(),font)); cell133.setExtraParagraphSpace(10f);     
				cell133	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell134 = new PdfPCell(new Paragraph("   26 ",font)); cell134.setExtraParagraphSpace(10f);
				cell134.setRowspan(2);
				PdfPCell cell135 = new PdfPCell(new Paragraph("Date of establishment of IQAC",font)); cell135.setExtraParagraphSpace(10f);
				PdfPCell cell136 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa26t1(),font)); cell136.setExtraParagraphSpace(10f);   
				cell136	.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell137 = new PdfPCell(new Paragraph("The minutes of IQAC meeting and Action Taken\r\n"
						+ "Report should be uploaded on the institutional\r\n"
						+ "website. ",font)); cell137.setExtraParagraphSpace(10f);
				PdfPCell cell138 = new PdfPCell(new Paragraph(" ",font)); cell138.setExtraParagraphSpace(10f);
		//nested table
				 int sizen14 = qiadata.getQiaIndicator8().size();
					PdfPTable table0154 = new PdfPTable(2);
					
					PdfPCell cell09 = new PdfPCell(new Paragraph("Date",font)); cell09.setExtraParagraphSpace(10f);
					PdfPCell cell010 = new PdfPCell(new Paragraph("View Document",font)); cell010.setExtraParagraphSpace(10f);
					table0154.addCell(cell09 );
					table0154.addCell(cell010 );
					for(int i = 0; i<qiadata.getQiaIndicator8().size();i++)
					{
					PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator8().get(i).getInputiiqa27t1()),font)); cell000001.setExtraParagraphSpace(10f);
					cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
					table0154.addCell(cell000001 );
					
					PdfPCell cell88000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator8().get(i).getIiqa27f1()),font)); cell88000001.setExtraParagraphSpace(10f);
					
					cell88000001.setHorizontalAlignment(Element.ALIGN_CENTER);
					table0154.addCell(cell88000001 );

					}
				
				 cell138.addElement(table0154);	
				
				

				PdfPCell cell139 = new PdfPCell(new Paragraph("   27",font)); cell139.setExtraParagraphSpace(10f);
				PdfPCell cell140 = new PdfPCell(new Paragraph(" Date of submission of AQARs of last 4 years to\r\n"
						+ "NAAC",font)); cell140.setExtraParagraphSpace(10f);
				
			//anothertable	27
				 PdfPCell cell141 = new PdfPCell(new Paragraph("",font)); cell141.setExtraParagraphSpace(10f);
				 int sizen3 = qiadata.getQiaIndicator7().size();
					PdfPTable table4154 = new PdfPTable(2);
					
					PdfPCell cell609 = new PdfPCell(new Paragraph("Date",font)); cell609.setExtraParagraphSpace(10f);
					PdfPCell cell610 = new PdfPCell(new Paragraph("View Document",font)); cell610.setExtraParagraphSpace(10f);
					table4154.addCell(cell609 );
					table4154.addCell(cell610 );
					for(int i = 0; i<qiadata.getQiaIndicator7().size();i++)
					{
					PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator7().get(i).getInputiiqa26t2()),font)); cell000001.setExtraParagraphSpace(10f);
					cell000001.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4154.addCell(cell000001 );
					
			PdfPCell cell00007701=new PdfPCell(new Paragraph((qiadata.getQiaIndicator7().get(i).getIiqa26f1()),font)); cell00007701.setExtraParagraphSpace(10f);
			cell00007701.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4154.addCell(cell00007701 );
			
			
			
//					table4141.	PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator7().get(i).getIiqa1t5(),font);
//					table4141.	PdfPCell cell000001=new PdfPCell(new Paragraph((qiadata.getQiaIndicator7().get(i).getIiqa1t6(),font);
					}
				
				 cell141.addElement(table4154);
			
				 PdfPCell cell142 = new PdfPCell(new Paragraph("   28",font)); cell142.setExtraParagraphSpace(10f);
					PdfPCell cell143 = new PdfPCell(new Paragraph(" Has the institution made statutory declaration on the\r\n"
							+ "institution website under Section 4 (1) (b) of the RTI\r\n"
							+ "Act 2005 as issued and amended from time to time.\r\n"
							+ "",font)); cell143.setExtraParagraphSpace(10f);
					PdfPCell cell144 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa28t1(),font)); cell144.setExtraParagraphSpace(10f);   
					cell144	.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell cell145 = new PdfPCell(new Paragraph("   29",font)); cell145.setExtraParagraphSpace(10f);
					PdfPCell cell146 = new PdfPCell(new Paragraph(" Does the college have an academic MoU with any\r\n"
							+ "foreign institution",font)); cell146.setExtraParagraphSpace(10f);
					PdfPCell cell147 = new PdfPCell(new Paragraph(qiadata.getInputIiqaAisheId(),font)); cell147.setExtraParagraphSpace(10f);       
					cell147.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell cell148 = new PdfPCell(new Paragraph("   30",font)); cell148.setExtraParagraphSpace(10f);
					PdfPCell cell149 = new PdfPCell(new Paragraph("Date of uploading data on MHRD website for All India\r\n"
							+ "Survey on Higher Education (AISHE).",font)); cell149.setExtraParagraphSpace(10f);
					PdfPCell cell150 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa30t1(),font)); cell150.setExtraParagraphSpace(10f);       
					cell150	.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell cell151= new PdfPCell(new Paragraph("   31",font)); cell151.setExtraParagraphSpace(10f);
					PdfPCell cell152= new PdfPCell(new Paragraph(" Attach Certification by the Head of the Institution for\r\n"
							+ "having complied with Rules & Regulations of Central\r\n"
							+ "Government, UGC and other Statutory Bodies, State\r\n"
							+ "Government and Affiliating University in the\r\n"
							+ "prescribed format enclosed herewith.\r\n"
							+ "",font)); cell152.setExtraParagraphSpace(10f);
					PdfPCell cell153= new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa31t1(),font)); cell153.setExtraParagraphSpace(10f);       
					cell153	.setHorizontalAlignment(Element.ALIGN_CENTER);
					PdfPCell cell154= new PdfPCell(new Paragraph("   32",font)); cell154.setExtraParagraphSpace(10f);
					PdfPCell cell155= new PdfPCell(new Paragraph("Registration Fee paid details.",font)); cell155.setExtraParagraphSpace(10f);
					PdfPCell cell156= new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa32t1(),font)); cell156.setExtraParagraphSpace(10f);    
					cell156	.setHorizontalAlignment(Element.ALIGN_CENTER);
				 
			
				
				
				
				
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
				table1.addCell(cell30);
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
				
		////table12
//				table1.addCell(cell701);
//				table1.addCell(cell702);
//				table1.addCell(cell703);
//				table1.addCell(cell704);
//				table1.addCell(cell705);
//				table1.addCell(cell706);
//				
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
			//	table1.addCell(cell118);
				table1.addCell(cell119);
				table1.addCell(cell120);
				
				
				//table1.addCell(cell121);
				table1.addCell(cell122);
				table1.addCell(cell123);
				table1.addCell(cell124);
				table1.addCell(cell125);
				table1.addCell(cell126);
				//table1.addCell(cell127);
				table1.addCell(cell128);
				table1.addCell(cell129);
			//	table1.addCell(cell130);
				table1.addCell(cell131);
				table1.addCell(cell132);
				table1.addCell(cell133);
				table1.addCell(cell134);
				table1.addCell(cell135);
				table1.addCell(cell136);
				table1.addCell(cell137);
				table1.addCell(cell138);
		        table1.addCell(cell139);
				
				table1.addCell(cell140);
				
				table1.addCell(cell141);
				table1.addCell(cell142);
				table1.addCell(cell143);
				table1.addCell(cell144);
				table1.addCell(cell145);
				table1.addCell(cell146);
				table1.addCell(cell147);
				table1.addCell(cell148);
				table1.addCell(cell149);
				table1.addCell(cell150);
				table1.addCell(cell151);
				table1.addCell(cell152);
				table1.addCell(cell153);
				table1.addCell(cell154);
				table1.addCell(cell155);
				table1.addCell(cell156);
				document.add(table1);
				
				document.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return file.toAbsolutePath().toString();
		}
		
//		private void addLogo(Document document) {
//			try {	
//				
//				Image img = Image.getInstance(logoImgPath);
//				img.scalePercent(logoImgScale[0], logoImgScale[1]);
//				img.setAlignment(Element.ALIGN_CENTER);
//				document.add(img);
//			} catch (DocumentException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
			}


	

