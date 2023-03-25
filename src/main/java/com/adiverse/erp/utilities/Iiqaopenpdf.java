//package com.adiverse.erp.utilities;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.adiverse.erp.model.QIAIndicator2;
//import com.adiverse.erp.model.QIAIndicatorMain;
//import com.adiverse.erp.service.QiaService;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Element;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.Image;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//@Service
//
//public class Iiqaopenpdf {
//	@Autowired
//	QiaService qiservice = new QiaService();
//	@Value("${logoImgPath}")
//	private String logoImgPath;
// 	
// 	
//	
//	@Value("${logoImgScale}")
//	private Float[] logoImgScale;
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//	
//	
//	public String generateReport() throws DocumentException, IOException {
//		String reportPath = "";
//		Path root = Paths.get(reportGeneratePath);
//		Path file = null;
//		Date date = new Date();
//		
//		
//	
////	public void export(HttpServletResponse response) throws DocumentException, IOException {
//	
//		List<QIAIndicatorMain> qIAIndicator= qiservice.getAllQiaFiles();
//		QIAIndicatorMain qiadata = qIAIndicator.get(0);
//		List<QIAIndicator2> qIAIndicator1= qIAIndicator.get(0).getQiaIndicator2();
//		
//
//		System.out.println("report generation path from property file ==>" + reportGeneratePath);
//		if (root != null) {
//			SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//			String strDate = formatter.format(date);
//			reportPath = "AuthonomousCriteria7Report-" + strDate + ".pdf";
//			file = root.resolve(reportPath);
//		}
//		System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//
//		Document document=new Document(PageSize.A4);
//	//		PdfWriter.getInstance(document,response.getOutputStream());
//		         //Font font = new Font(Font.FontFamily.TIMES_ROMAN, 26, Font.UNDERLINE, BaseColor.BLACK);
//		PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//		
//		       		document.open();
//		       		addLogo(document);
//			
//			Font fontTitle=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			fontTitle.setSize(16);
//			//fontTitle.setColor(Color.RED);
//
//
//	   Paragraph paragraph=new Paragraph("Institutional Information for Quality Assessment(IIQA)"
//					,fontTitle);
//			   paragraph.setAlignment(Paragraph.ALIGN_CENTER);
//			   PdfPCell cell1= new PdfPCell();
//			
//			   document.add(cell1);
//			   paragraph.setSpacingAfter(10f);
//	   document.add(paragraph);
//			
//		Font fontParagraph4=FontFactory.getFont(FontFactory.COURIER_BOLD);
//		fontParagraph4.setSize(12);
//	         Paragraph paragraph5=new Paragraph("ADITYA COLLEGE OF ENGINEERING & TECHNOLOGY,SURAMPALEM,ANDHRA PRADESH"
//					,fontParagraph4);
//			paragraph5.setAlignment(Paragraph.ALIGN_LEFT);
//			
//			paragraph.setSpacingAfter(10f);
//			document.add(paragraph5);
//			
//	  
//	
//			Font font=FontFactory.getFont(FontFactory.TIMES_ROMAN);
//			font.setSize(11);
//			//fontTitle1.setColor(Color.RED);
//			  
//	//creating table 4 cloums date of submission	
//			
//		PdfPTable table = new PdfPTable(4);
//		table.setWidthPercentage(70);
//		table.setWidths(new int[]{60,60,30,60});
//		table.setHorizontalAlignment(table.ALIGN_LEFT );
//		
//		
//		PdfPCell cell3 = new PdfPCell(new Paragraph(""));
//		PdfPCell cell4 = new PdfPCell(new Paragraph("Date of submission",font));
//		PdfPCell cell5 = new PdfPCell(new Paragraph(":"));
//		PdfPCell cell6 = new PdfPCell(new Paragraph(qiadata.getqIAIndicator().get(0).getIiqaDate(),font));
//		PdfPCell cell7 = new PdfPCell(new Paragraph(""));
//		PdfPCell cell8 = new PdfPCell(new Paragraph("AISHE ID",font));
//		PdfPCell cell9 = new PdfPCell(new Paragraph(":"));
//		PdfPCell cell10 = new PdfPCell(new Paragraph(qiadata.getqIAIndicator().get(0).getIiqaAisheId(),font));
//		PdfPCell cell14 = new PdfPCell(new Paragraph(""));
//		PdfPCell cell11 = new PdfPCell(new Paragraph("Institution Track ID",font));
//		PdfPCell cell12 = new PdfPCell(new Paragraph(":"));
//		PdfPCell cell13 = new PdfPCell(new Paragraph(qiadata.getqIAIndicator().get(0).getIiqaTrackId(),font));
//	  
//		
//		
//		table.addCell(cell3);
//		table.addCell(cell4);
//		table.addCell(cell5);
//		table.addCell(cell6);
//		table.addCell(cell7);
//		table.addCell(cell8);
//		table.addCell(cell9);
//		table.addCell(cell10);
//		table.addCell(cell14);
//		table.addCell(cell11);
//		table.addCell(cell12);
//		table.addCell(cell13);
//		table.setSpacingBefore(10f);
//		table.setSpacingAfter(10f);
//		document.add(table);
//		
//// application  table
//		
//		PdfPTable table1 = new PdfPTable(3);
//		table1.setWidthPercentage(100);
//		table1.setWidths(new int[]{10,90,90});
//		table1.setHorizontalAlignment(table.ALIGN_LEFT );
//	
//	
//		PdfPCell cell15 = new PdfPCell(new Paragraph("1",font)); //nested column
//		cell15.setRowspan(2);
//		PdfPCell cell16 = new PdfPCell(new Paragraph("Application For",font));
//		
//		PdfPCell cell17 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa1t1(),font));
//		PdfPCell cell18 = new PdfPCell(new Paragraph("Cycle of Accreditation ")); //nested
//		
//		PdfPCell cell19 = new PdfPCell(new Paragraph(""));
//		
////creating another table 
////table 1
//		PdfPTable table4141 = new PdfPTable(4);
//		PdfPCell cell201 = new PdfPCell(new Paragraph("Cycle",font));
//		PdfPCell cell202 = new PdfPCell(new Paragraph("Date",font));
//		PdfPCell cell203 = new PdfPCell(new Paragraph("Grade",font));
//		PdfPCell cell204 = new PdfPCell(new Paragraph("Score",font));
//		table4141.addCell(cell201);
//		table4141.addCell(cell202);
//		table4141.addCell(cell203);
//		table4141.addCell(cell204);
//		for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
//			{
//			table4141.addCell(qiadata.getQiaIndicator12().get(i).getInputiiqa1t3());
//			table4141.addCell(qiadata.getQiaIndicator12().get(i).getInputiiqa1t4());
//			table4141.addCell(qiadata.getQiaIndicator12().get(i).getInputiiqa1t5());
//			table4141.addCell(qiadata.getQiaIndicator12().get(i).getInputiiqa1t6());
//			}
//		
//			
////			for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
////			{
////			
////			
////		}
////			for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
////			{
////			
////			
////			}
////			for(int i = 0; i<qiadata.getQiaIndicator12().size();i++)
////			{
////			
////			
////			}
////		
//		
////			PdfPCell cell19 = new PdfPCell();
//		 cell19.addElement(table4141);
//		 table4141.setSpacingBefore(20f);
//		 table4141.setSpacingAfter(20f);
//			//cell19.addElement(cell19);
//		
//		PdfPCell cell20 = new PdfPCell(new Paragraph("2"));
//		PdfPCell cell21 = new PdfPCell(new Paragraph("Name of the College "));
//		PdfPCell cell22 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa1t2()));
//		PdfPCell cell23 = new PdfPCell(new Paragraph("3"));
//		PdfPCell cell24 = new PdfPCell(new Paragraph("Date of establishment of the Institution"));
//		PdfPCell cell25 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa3t1()));
//		PdfPCell cell26 = new PdfPCell(new Paragraph("4"));
//		cell26.setRowspan(2);//nested column
//		PdfPCell cell27 = new PdfPCell(new Paragraph("Name of the Head of the Institution"));
//		PdfPCell cell28 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa4t1()));
//		PdfPCell cell29 = new PdfPCell(new Paragraph("Designation"));
//		PdfPCell cell30 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa4t2()));
//		PdfPCell cell31 = new PdfPCell(new Paragraph("5"));
//		PdfPCell cell32 = new PdfPCell(new Paragraph("Does the college function from Own Campus "));
//		PdfPCell cell33 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa5t1()));
//		PdfPCell cell34 = new PdfPCell(new Paragraph("6"));
//		cell34.setRowspan(10);
//		PdfPCell cell35 = new PdfPCell(new Paragraph("Address of the College"));
//		PdfPCell cell36 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa5t1()));
//		PdfPCell cell37 = new PdfPCell(new Paragraph("State/UT"));
//		PdfPCell cell38 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t2()));
//		PdfPCell cell39 = new PdfPCell(new Paragraph("District"));
//		PdfPCell cell40 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t3()));
//		PdfPCell cell41 = new PdfPCell(new Paragraph("City"));
//		PdfPCell cell42 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t4()));
//		PdfPCell cell43 = new PdfPCell(new Paragraph("Pin"));
//		PdfPCell cell44 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t5()));
//		PdfPCell cell45 = new PdfPCell(new Paragraph("Phone No"));
//		PdfPCell cell46 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t6()));
//		PdfPCell cell47 = new PdfPCell(new Paragraph("Fax No"));
//		PdfPCell cell48 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t7()));
//		PdfPCell cell49 = new PdfPCell(new Paragraph("Mobile No "));
//		PdfPCell cell50 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t8()));
//		PdfPCell cell51 = new PdfPCell(new Paragraph("Registered Email"));
//		PdfPCell cell52 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t9()));
//		PdfPCell cell53 = new PdfPCell(new Paragraph("Alternate Email "));
//		PdfPCell cell54 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa6t10()));
//		PdfPCell cell55 = new PdfPCell(new Paragraph("7"));
//		cell55.setRowspan(11);
//		PdfPCell cell56 = new PdfPCell(new Paragraph(" Alternate Faculty Contact Details "));//1
//        PdfPCell cell57 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t1()));
//        PdfPCell cell58 = new PdfPCell(new Paragraph("Address"));//2
//		PdfPCell cell59 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t2()));
//		PdfPCell cell60 = new PdfPCell(new Paragraph("State/UT"));//3
//		PdfPCell cell61 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t3()));
//		PdfPCell cell62 = new PdfPCell(new Paragraph("District"));//4
//		PdfPCell cell63 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t4()));
//		PdfPCell cell64 = new PdfPCell(new Paragraph("City"));//5
//		PdfPCell cell65 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t4()));
//		PdfPCell cell66 = new PdfPCell(new Paragraph("Pin"));//6
//		PdfPCell cell67 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t5()));
//		PdfPCell cell68 = new PdfPCell(new Paragraph("Phone No"));//7
//		PdfPCell cell69 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t6()));
//		PdfPCell cell70 = new PdfPCell(new Paragraph("Fax No"));//8
//		PdfPCell cell71 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t7()));
//		PdfPCell cell72 = new PdfPCell(new Paragraph("Mobile No ")); //9;
//		PdfPCell cell73 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t8()));
//		PdfPCell cell74 = new PdfPCell(new Paragraph("Email "));//10
//		PdfPCell cell75 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t9()));
//		PdfPCell cell76 = new PdfPCell(new Paragraph("Alternate Email ")); //11
//		PdfPCell cell77 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa7t10()));
//		PdfPCell cell78 = new PdfPCell(new Paragraph("8"));
//		PdfPCell cell79 = new PdfPCell(new Paragraph("Website"));
//		PdfPCell cell80 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa8t1()));
//		PdfPCell cell81 = new PdfPCell(new Paragraph("9"));
//		PdfPCell cell82 = new PdfPCell(new Paragraph("Has the Institution completed 6 years of existence/"
//				+ "Years of graduation of last two batches"));
//		PdfPCell cell83 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa9t1()));
//		PdfPCell cell84 = new PdfPCell(new Paragraph("10"));
//		PdfPCell cell85 = new PdfPCell(new Paragraph("Nature of the college"));
//		PdfPCell cell86 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa10t1()));
//		PdfPCell cell87 = new PdfPCell(new Paragraph("11"));
//		PdfPCell cell88 = new PdfPCell(new Paragraph("College Affiliation"));
//		PdfPCell cell89 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa11t1()));
//		PdfPCell cell90 = new PdfPCell(new Paragraph("12"));
//		PdfPCell cell91 = new PdfPCell(new Paragraph(" Name of the affiliating University" //table in side table 12
//				+ "(ies) and the state(s) in which the University"
//				+ "(ies) is located"));
//		PdfPCell cell92 = new PdfPCell(new Paragraph(""));
////		cell92.setRowspan(3);
////		PdfPCell cell701 = new PdfPCell(new Paragraph("State"));
////		PdfPCell cell702 = new PdfPCell(new Paragraph(""));
////		PdfPCell cell703 = new PdfPCell(new Paragraph("Universite"));
////		PdfPCell cell704 = new PdfPCell(new Paragraph(""));
////		PdfPCell cell705 = new PdfPCell(new Paragraph("Documents"));
////		PdfPCell cell706 = new PdfPCell(new Paragraph(""));
////		
////		
////		
//		
//		
//		PdfPCell cell93 = new PdfPCell(new Paragraph("13"));
//		PdfPCell cell94 = new PdfPCell(new Paragraph("s the Institution recognized under section 2(f) of the\r\n"
//				+ "UGC Act?"));
//		PdfPCell cell95 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa13t1()));
//		PdfPCell cell96 = new PdfPCell(new Paragraph("14"));
//		PdfPCell cell97 = new PdfPCell(new Paragraph("Is the Institution recognized under section 12B of the\r\n"
//				+ "UGC Act?\r\n"
//				+ " If yes, date of recognition by UGC under section\r\n"
//				+ "12B along with latest Plan General Development\r\n"
//				+ "Grant release letter"));
//		PdfPCell cell98 = new PdfPCell(new Paragraph(new Paragraph(qIAIndicator1.get(0).getInputiiqa14t1())));
//		PdfPCell cell99 = new PdfPCell(new Paragraph("15"));
//		PdfPCell cell100 = new PdfPCell(new Paragraph("Is the institution recognised as an Autonomous\r\n"
//				+ "College by the UGC?\r\n"
//				+ ""));
//		
//		PdfPCell cell101 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa15t1()));
//		
//		PdfPCell cell102 = new PdfPCell(new Paragraph("16"));
//		PdfPCell cell103 = new PdfPCell(new Paragraph("Is the institution recognised as a ‘College with\r\n"
//				+ "Potential for Excellence (CPE)’ by the UGC?"));
//		
//		PdfPCell cell104 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa16t1()));
//		
//		PdfPCell cell105 = new PdfPCell(new Paragraph("17"));
//		PdfPCell cell106 = new PdfPCell(new Paragraph(" Is the institution recognised as a ‘College of\r\n"
//				+ "Excellence’ by the UGC?"));
//		PdfPCell cell107 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa17t1()));
//		PdfPCell cell108 = new PdfPCell(new Paragraph("18"));
//		cell108.setRowspan(2);
//		PdfPCell cell109 = new PdfPCell(new Paragraph(" Is the College offering any programmes recognised\r\n"
//				+ "by any Statutory Regulatory Authority (SRA)\r\n"
//				+ ""));
//		PdfPCell cell110 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa18t1()));
//		
//		PdfPCell cell111 = new PdfPCell(new Paragraph("Statutory Regulatory Authorities"));
//		PdfPCell cell112 = new PdfPCell(new Paragraph(""));
////nested table
//		
//		int sizen2 = qiadata.getQiaIndicator4().size();
//		PdfPTable table4152 = new PdfPTable(2);
//		table4152.setSpacingBefore(20f);
//		PdfPCell cell601 = new PdfPCell(new Paragraph("SRA program"));
//		PdfPCell cell602 = new PdfPCell(new Paragraph("Document"));
////		PdfPCell cell603 = new PdfPCell(new Paragraph(qiadata.getQiaIndicator4().get(0).getIiqa18t2()));
////		PdfPCell cell604 = new PdfPCell(new Paragraph(qiadata.getQiaIndicator4().get(0).getIiqa18t2()));
//		
//		
//		table4152.addCell(cell601 );
//		table4152.addCell(cell602 );
//		for(int i = 0; i<qiadata.getQiaIndicator4().size();i++)
//		{
//		table4152.addCell(qiadata.getQiaIndicator4().get(i).getInputiiqa18t2());
//		table4152.addCell(qiadata.getQiaIndicator4().get(i).getInputiiqa18t3());
//		}
//
//		
//		cell112.addElement(table4152);
//	
//		 table4152.setSpacingAfter(20f);
//
//
//		PdfPCell cell113 = new PdfPCell(new Paragraph("19"));
//		PdfPCell cell114 = new PdfPCell(new Paragraph("If the institution is not affiliated to a university and is\r\n"
//				+ "offering programmes recognized by any Statutory\r\n"
//				+ "Regulatory Authorities (SRA), are the programmes\r\n"
//				+ "recognized by Association of Indian Universities(AIU)\r\n"
//				+ "or other appropriate Government authorities as\r\n"
//				+ "equivalent to UG / PG Programmes of a University"));
//		PdfPCell cell115 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa19t1()));
//		PdfPCell cell116 = new PdfPCell(new Paragraph("20"));
//		PdfPCell cell117 = new PdfPCell(new Paragraph("Number of programmes offered"));
//		
//		
////table20
//		int sizen4 = qiadata.getQiaIndicator5().size();
//		PdfPTable table5154 = new PdfPTable(2);
//		table5154.setSpacingBefore(20f);
//		PdfPCell cell701 = new PdfPCell(new Paragraph("Programmes"));
//		PdfPCell cell702 = new PdfPCell(new Paragraph("Number"));
//		table5154.addCell(cell701);
//		table5154.addCell(cell702);
//		for(int i = 0; i<qiadata.getQiaIndicator5().size();i++)
//		{
//		table5154.addCell(qiadata.getQiaIndicator5().get(i).getInputiiqa20t1());
//		table5154.addCell(qiadata.getQiaIndicator5().get(i).getInputiiqa20t2());
//		}
//
//		
//		cell117.addElement(table5154);
//	
//		 table5154.setSpacingAfter(20f);
//		 cell117.setColspan(2);
//		
//		
//		
//		//PdfPCell cell118 = new PdfPCell(new Paragraph(""));
//		
//		PdfPCell cell119= new PdfPCell(new Paragraph("21"));
//		PdfPCell cell120 = new PdfPCell(new Paragraph("Programme Details"));
////table21
//		//table21
//				int sizen9 = qiadata.getQiaIndicator6().size();
//				PdfPTable table6154 = new PdfPTable(5);
//				table6154.setSpacingBefore(20f);
//				PdfPCell cell903 = new PdfPCell(new Paragraph("Programmes"));
//				PdfPCell cell904 = new PdfPCell(new Paragraph("Department"));
//				PdfPCell cell905 = new PdfPCell(new Paragraph("University Affiliation"));
//				PdfPCell cell906 = new PdfPCell(new Paragraph("SRA Recognition"));
//				PdfPCell cell907 = new PdfPCell(new Paragraph("Affiliation Status"));
//				table6154.addCell(cell903);
//				table6154.addCell(cell904);
//				table6154.addCell(cell905);
//				table6154.addCell(cell906);
//				table6154.addCell(cell907);
//				for(int i = 0; i<qiadata.getQiaIndicator6().size();i++)
//				{
//				table6154.addCell(qiadata.getQiaIndicator6().get(i).getInputiiqa21t1());
//				table6154.addCell(qiadata.getQiaIndicator6().get(i).getInputiiqa21t2());
//				table6154.addCell(qiadata.getQiaIndicator6().get(i).getInputiiqa21t3());
//				table6154.addCell(qiadata.getQiaIndicator6().get(i).getInputiiqa21t4());
//				table6154.addCell(qiadata.getQiaIndicator6().get(i).getInputiiqa21t5());
//				}
//
//				
//				cell120.addElement(table6154);
//				 cell120.setColspan(2);
//				
//				
//		
//	//	PdfPCell cell121 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell122 = new PdfPCell(new Paragraph("22 "));
//		PdfPCell cell123 = new PdfPCell(new Paragraph(" Number of Teaching Staff by employment status (permanent / temporary) and by gender "));
//		PdfPCell cell124 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell125 = new PdfPCell(new Paragraph("23 "));
//		PdfPCell cell126 = new PdfPCell(new Paragraph(" Number of Non-Teaching Staff by employment status (permanent / temporary) and by gender "));
////table23
//		int sizen11 = qiadata.getQiaIndicator9().size();
//		PdfPTable table7154 = new PdfPTable(4);
//	
//		PdfPCell cell1903 = new PdfPCell(new Paragraph("Male"));
//		PdfPCell cell1904 = new PdfPCell(new Paragraph("Female"));
//		PdfPCell cell1905 = new PdfPCell(new Paragraph("Transgender"));
//		PdfPCell cell1906 = new PdfPCell(new Paragraph("Total"));
//		
//		table7154.addCell(cell1903);
//		table7154.addCell(cell1904);
//		table7154.addCell(cell1905);
//		table7154.addCell(cell1906);
//
//		for(int i = 0; i<qiadata.getQiaIndicator9().size();i++)
//		{
//		table7154.addCell(qiadata.getQiaIndicator9().get(i).getInputiiqa23t1());
//		table7154.addCell(qiadata.getQiaIndicator9().get(i).getInputiiqa23t2());
//		table7154.addCell(qiadata.getQiaIndicator9().get(i).getInputiiqa23t3());
//		table7154.addCell(qiadata.getQiaIndicator9().get(i).getInputiiqa23t4());
//		
//		}
//
//		
//		cell126.addElement(table7154);
//		 cell126.setColspan(2);
//	
//		
//		//PdfPCell cell127 = new PdfPCell(new Paragraph(" "));
//		PdfPCell cell128 = new PdfPCell(new Paragraph("24 "));
//		PdfPCell cell129 = new PdfPCell(new Paragraph("Number of Students on roll by gender "));
//
//	//	PdfPCell cell130 = new PdfPCell(new Paragraph(" "));
////table	24
//		int sizen12 = qiadata.getQiaIndicator10().size();
//		PdfPTable table8154 = new PdfPTable(4);
//	
//		PdfPCell cell2903 = new PdfPCell(new Paragraph("Male"));
//		PdfPCell cell2904 = new PdfPCell(new Paragraph("Female"));
//		PdfPCell cell2905 = new PdfPCell(new Paragraph("Transgender"));
//		PdfPCell cell2906 = new PdfPCell(new Paragraph("Total"));
//		
//		table8154.addCell(cell2903);
//		table8154.addCell(cell2904);
//		table8154.addCell(cell2905);
//		table8154.addCell(cell2906);
//
//		for(int i = 0; i<qiadata.getQiaIndicator10().size();i++)
//		{
//		table8154.addCell(qiadata.getQiaIndicator10().get(i).getInputiiqa24t1());
//		table8154.addCell(qiadata.getQiaIndicator10().get(i).getInputiiqa24t2());
//		table8154.addCell(qiadata.getQiaIndicator10().get(i).getInputiiqa24t3());
//		table8154.addCell(qiadata.getQiaIndicator10().get(i).getInputiiqa24t4());
//		
//		}
//
//		
//		cell129.addElement(table8154);
//		 cell129.setColspan(2);
//	//	Table table = new Table(1,1);
//
//		PdfPCell cell131 = new PdfPCell(new Paragraph("25 "));
//		PdfPCell cell132 = new PdfPCell(new Paragraph("Does the institution have statutory cells / committees"));
//		PdfPCell cell133 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa25t1()));
//		PdfPCell cell134 = new PdfPCell(new Paragraph("26 "));
//		cell134.setRowspan(2);
//		PdfPCell cell135 = new PdfPCell(new Paragraph("Date of establishment of IQAC"));
//		PdfPCell cell136 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa26t1()));
//		PdfPCell cell137 = new PdfPCell(new Paragraph("The minutes of IQAC meeting and Action Taken\r\n"
//				+ "Report should be uploaded on the institutional\r\n"
//				+ "website. "));
//		PdfPCell cell138 = new PdfPCell(new Paragraph(" "));
////nested table
//		 int sizen14 = qiadata.getQiaIndicator8().size();
//			PdfPTable table0154 = new PdfPTable(2);
//			
//			PdfPCell cell09 = new PdfPCell(new Paragraph("Date"));
//			PdfPCell cell010 = new PdfPCell(new Paragraph("View Document"));
//			table0154.addCell(cell09 );
//			table0154.addCell(cell010 );
//			for(int i = 0; i<qiadata.getQiaIndicator8().size();i++)
//			{
//			table0154.addCell(qiadata.getQiaIndicator8().get(i).getInputiiqa27t1());
//			table0154.addCell(qiadata.getQiaIndicator8().get(i).getIiqa27f1());
//
//			}
//		
//		 cell138.addElement(table0154);	
//		
//		
//
//		PdfPCell cell139 = new PdfPCell(new Paragraph("27"));
//		PdfPCell cell140 = new PdfPCell(new Paragraph(" Date of submission of AQARs of last 4 years to\r\n"
//				+ "NAAC"));
//		
//	//anothertable	27
//		 PdfPCell cell141 = new PdfPCell(new Paragraph(""));
//		 int sizen3 = qiadata.getQiaIndicator7().size();
//			PdfPTable table4154 = new PdfPTable(2);
//			
//			PdfPCell cell609 = new PdfPCell(new Paragraph("Date"));
//			PdfPCell cell610 = new PdfPCell(new Paragraph("View Document"));
//			table4154.addCell(cell609 );
//			table4154.addCell(cell610 );
//			for(int i = 0; i<qiadata.getQiaIndicator7().size();i++)
//			{
//			table4154.addCell(qiadata.getQiaIndicator7().get(i).getInputiiqa26t2());
//			table4154.addCell(qiadata.getQiaIndicator7().get(i).getIiqa26f1());
////			table4141.addCell(qiadata.getQiaIndicator7().get(i).getIiqa1t5());
////			table4141.addCell(qiadata.getQiaIndicator7().get(i).getIiqa1t6());
//			}
//		
//		 cell141.addElement(table4154);
//	
//		 PdfPCell cell142 = new PdfPCell(new Paragraph("28"));
//			PdfPCell cell143 = new PdfPCell(new Paragraph(" Has the institution made statutory declaration on the\r\n"
//					+ "institution website under Section 4 (1) (b) of the RTI\r\n"
//					+ "Act 2005 as issued and amended from time to time.\r\n"
//					+ ""));
//			PdfPCell cell144 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa28t1()));
//			PdfPCell cell145 = new PdfPCell(new Paragraph("29"));
//			PdfPCell cell146 = new PdfPCell(new Paragraph(" Does the college have an academic MoU with any\r\n"
//					+ "foreign institution"));
//			PdfPCell cell147 = new PdfPCell(new Paragraph(qiadata.getqIAIndicator().get(0).getIiqaAisheId()));
//			PdfPCell cell148 = new PdfPCell(new Paragraph("30"));
//			PdfPCell cell149 = new PdfPCell(new Paragraph("Date of uploading data on MHRD website for All India\r\n"
//					+ "Survey on Higher Education (AISHE)."));
//			PdfPCell cell150 = new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa30t1()));
//			PdfPCell cell151= new PdfPCell(new Paragraph("31"));
//			PdfPCell cell152= new PdfPCell(new Paragraph(" Attach Certification by the Head of the Institution for\r\n"
//					+ "having complied with Rules & Regulations of Central\r\n"
//					+ "Government, UGC and other Statutory Bodies, State\r\n"
//					+ "Government and Affiliating University in the\r\n"
//					+ "prescribed format enclosed herewith.\r\n"
//					+ ""));
//			PdfPCell cell153= new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa31t1()));
//			PdfPCell cell154= new PdfPCell(new Paragraph("32"));
//			PdfPCell cell155= new PdfPCell(new Paragraph("Registration Fee paid details."));
//			PdfPCell cell156= new PdfPCell(new Paragraph(qIAIndicator1.get(0).getInputiiqa32t1()));
//		 
//	
//		
//		
//		
//		
//		table1.addCell(cell15);
//		table1.addCell(cell16);
//		table1.addCell(cell17);
//		table1.addCell(cell18);
//		table1.addCell(cell19);
//		table1.addCell(cell20);
//		table1.addCell(cell21);
//		table1.addCell(cell22);
//		table1.addCell(cell23);
//		table1.addCell(cell24);
//		table1.addCell(cell25);
//		table1.addCell(cell26);
//		table1.addCell(cell27);
//		table1.addCell(cell28);
//		table1.addCell(cell29);
//		table1.addCell(cell30);
//		table1.addCell(cell31);
//		table1.addCell(cell32);
//		table1.addCell(cell33);
//		table1.addCell(cell34);
//		table1.addCell(cell35);
//		table1.addCell(cell36);
//		table1.addCell(cell37);
//		table1.addCell(cell38);
//		table1.addCell(cell39);
//		table1.addCell(cell30);
//		table1.addCell(cell41);
//		table1.addCell(cell42);
//		table1.addCell(cell43);
//		table1.addCell(cell44);
//		table1.addCell(cell45);
//		table1.addCell(cell46);
//		table1.addCell(cell47);
//		table1.addCell(cell48);
//		table1.addCell(cell49);
//		table1.addCell(cell50);
//		table1.addCell(cell51);
//		table1.addCell(cell52);
//		table1.addCell(cell53);
//		table1.addCell(cell54);
//		table1.addCell(cell55);
//		table1.addCell(cell56);
//		table1.addCell(cell57);
//		table1.addCell(cell58);
//		table1.addCell(cell59);
//		table1.addCell(cell60);
//		table1.addCell(cell61);
//		table1.addCell(cell62);
//		table1.addCell(cell63);
//		table1.addCell(cell64);
//		table1.addCell(cell65);
//		table1.addCell(cell66);
//		table1.addCell(cell67);
//		table1.addCell(cell68);
//		table1.addCell(cell69);
//		table1.addCell(cell70);
//		table1.addCell(cell71);
//		table1.addCell(cell72);
//		table1.addCell(cell73);
//		table1.addCell(cell74);
//		table1.addCell(cell75);
//		table1.addCell(cell76);
//		table1.addCell(cell77);
//		table1.addCell(cell78);
//		table1.addCell(cell79);
//		table1.addCell(cell80);
//		table1.addCell(cell81);
//		table1.addCell(cell82);
//		table1.addCell(cell83);
//		table1.addCell(cell84);
//		table1.addCell(cell85);
//		table1.addCell(cell86);
//		table1.addCell(cell87);
//		table1.addCell(cell88);
//		table1.addCell(cell89);
//		table1.addCell(cell90);
//		table1.addCell(cell91);
//		table1.addCell(cell92);
//		
//////table12
////		
////		table1.addCell(cell703);
////		table1.addCell(cell704);
////		table1.addCell(cell705);
////		table1.addCell(cell706);
////		
//		table1.addCell(cell93);
//		table1.addCell(cell94);
//		table1.addCell(cell95);
//		table1.addCell(cell96);
//		table1.addCell(cell97);
//		table1.addCell(cell98);
//		table1.addCell(cell99);
//		table1.addCell(cell100);
//		table1.addCell(cell101);
//		table1.addCell(cell102);
//		table1.addCell(cell103);
//		table1.addCell(cell104);
//		table1.addCell(cell105);
//		table1.addCell(cell106);
//		table1.addCell(cell107);
//		table1.addCell(cell108);
//		table1.addCell(cell109);
//		table1.addCell(cell110);
//		table1.addCell(cell111);
//		table1.addCell(cell112);
//		table1.addCell(cell113);
//		table1.addCell(cell114);
//		table1.addCell(cell115);
//		table1.addCell(cell116);
//		table1.addCell(cell117);
//	//	table1.addCell(cell118);
//		table1.addCell(cell119);
//		table1.addCell(cell120);
//		
//		
//		//table1.addCell(cell121);
//		table1.addCell(cell122);
//		table1.addCell(cell123);
//		table1.addCell(cell124);
//		table1.addCell(cell125);
//		table1.addCell(cell126);
//		//table1.addCell(cell127);
//		table1.addCell(cell128);
//		table1.addCell(cell129);
//	//	table1.addCell(cell130);
//		table1.addCell(cell131);
//		table1.addCell(cell132);
//		table1.addCell(cell133);
//		table1.addCell(cell134);
//		table1.addCell(cell135);
//		table1.addCell(cell136);
//		table1.addCell(cell137);
//		table1.addCell(cell138);
//        table1.addCell(cell139);
//		
//		table1.addCell(cell140);
//		
//		table1.addCell(cell141);
//		table1.addCell(cell142);
//		table1.addCell(cell143);
//		table1.addCell(cell144);
//		table1.addCell(cell145);
//		table1.addCell(cell146);
//		table1.addCell(cell147);
//		table1.addCell(cell148);
//		table1.addCell(cell149);
//		table1.addCell(cell150);
//		table1.addCell(cell151);
//		table1.addCell(cell152);
//		table1.addCell(cell153);
//		table1.addCell(cell154);
//		table1.addCell(cell155);
//		table1.addCell(cell156);
//		document.add(table1);
//		
//		
//		
//	   document.close();
//		return file.toAbsolutePath().toString();
//}
//	private void addLogo(Document document) {
//		try {	
//			
//			Image img = Image.getInstance(logoImgPath);
//			img.scalePercent(logoImgScale[0], logoImgScale[1]);
//			img.setAlignment(Element.ALIGN_CENTER);
//			document.add(img);
//		} catch (DocumentException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//
//}
