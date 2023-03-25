		package com.adiverse.erp.openpdf;
		
		import java.io.FileOutputStream;
		import java.io.IOException;
		import java.nio.file.Path;
		import java.nio.file.Paths;
		import java.text.SimpleDateFormat;
		import java.util.ArrayList;
		import java.util.Date;
		import java.util.List;
		
		import org.apache.commons.collections4.CollectionUtils;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.beans.factory.annotation.Value;
		import org.springframework.stereotype.Component;
		
		import com.adiverse.erp.model.Criteria1_FieldInfo;
		import com.adiverse.erp.model.Criteria1_FileUpload;
		import com.adiverse.erp.service.Criteria1Service;
		import com.lowagie.text.Chunk;
		import com.lowagie.text.Document;
		import com.lowagie.text.DocumentException;
		import com.lowagie.text.Element;
		import com.lowagie.text.Font;
		import com.lowagie.text.FontFactory;
		import com.lowagie.text.Image;
		import com.lowagie.text.PageSize;
		import com.lowagie.text.Paragraph;
		import com.lowagie.text.Phrase;
		import com.lowagie.text.Table;
		import com.lowagie.text.pdf.PdfPCell;
		import com.lowagie.text.pdf.PdfPTable;
		import com.lowagie.text.pdf.PdfWriter;
		
		@Component
		public class AuthonomousCriteria11Report2 {
			
			@Value("${upload.files.path}")
			private String reportGeneratePath;
		
			public Image headerImage;
		
			public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
			public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
			
			@Autowired
			Criteria1Service service1;
		
			List<Criteria1_FieldInfo> criteria1List = null;
			Criteria1_FieldInfo criteria1Record = null;
			List<Criteria1_FileUpload> criteria1file = null;
		
			
		public String generateReport(  Criteria1_FieldInfo criteria1Fieldinfo) throws DocumentException, IOException {
			//public String generateReport()throws DocumentException, IOException {
			
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
		
					criteria1List = service1.getAllCriteria1Data();
					if (CollectionUtils.isNotEmpty(criteria1List)) {
						criteria1Record = criteria1List.get(0);
						
						criteria1file = criteria1Record.getCriteria1FileUpload();
					} else {
						criteria1Record = new Criteria1_FieldInfo();
						criteria1file = new ArrayList<Criteria1_FileUpload>();
					}
//					System.out.println(criteria1List.get(0).getCriteria1FieldInfoQl());
//					System.out.println(criteria1List.get(0).getCriteria1FieldInfoQn());
//					System.out.println(criteria1List.get(0).getCriteria1FileUpload());
//					System.out.println(criteria1List.get(0).getYearTable1131());
//					
					
					System.out.println("report generation path from property file ==>" + reportGeneratePath);
					if (root != null) {
						SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
						String strDate = formatter.format(date);
						reportPath = "AuthonomousCriteria 1.1Report-" + strDate + ".pdf";
						file = root.resolve(reportPath);
					}
					System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
					
					Document document = new Document(PageSize.A4);
					// PdfWriter.getInstance(document, response.getOutputStream());
					PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
					
					document.open();
					
					
					System.out.println("open the document==========>");
					
		
		Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font2);
		paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph1);
		Paragraph paragraph2 = new Paragraph("1.1 Curriculum Design and Development\r\n", font3);
		paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph2);
		
		
		
		Paragraph paragraph3 = new Paragraph(
		"1.1.1 Curricula developed and implemented have relevance to the local, national, regional and global developmental needs which is reflected in Programme outcomes (POs), Programme Specific Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered by the Institution.\r\n",
		font3);
		paragraph3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
		document.add(paragraph3);
		
		
		PdfPTable table111criteria1 = new PdfPTable(1);
		
		table111criteria1.setWidthPercentage(100);
		PdfPCell cell111criteria1 = new PdfPCell(
		new Paragraph("1.1.1 Curricula developed and implemented have relevance to the local, "
		+ "national, regional and global developmental needs which is reflected in Programme outcomes (POs), "
		+ "Programme Specific Outcomes(PSOs) and Course Outcomes(COs) of the Programmes offered by the Institution.\r\n"
		+ "Response:"+"\r\n\r\n", font3));
		
		table111criteria1.addCell(cell111criteria1);
		
		table111criteria1.setSpacingBefore(20f);
		table111criteria1.setSpacingAfter(20f);
		document.add(table111criteria1);
		
	
	//	if(criteria1Fieldinfo.getCriteria1FieldInfoQl().get(0).getResponse111() !=null)
		{
		Paragraph paragraph4 = new Paragraph("Response:");
//		+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQl().get(0).getResponse111()
//		: ""),
//		font3);
		paragraph4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(paragraph4);
		}
		
		PdfPTable table6 = new PdfPTable(2);
		table6.setWidthPercentage(100);
		
		// create table for header
		PdfPCell cell1 = new PdfPCell(new Paragraph("FileDiscription", font3));
		PdfPCell cell2 = new PdfPCell(new Paragraph("Document", font3));
		PdfPCell cell3 = new PdfPCell(new Paragraph("Any aditional information", font5));
		PdfPCell cell4 = new PdfPCell(
		new Paragraph(criteria1Record !=null? criteria1file.get(0).getCriteria1FilePath() : ""));
		PdfPCell cell5 = new PdfPCell(new Paragraph("Link for Aditional information", font5));
		PdfPCell cell6 = new PdfPCell(new Paragraph(criteria1Record !=null? criteria1file.get(0).getCriteria1FilePath() : " "));
		
		table6.addCell(cell1);
		table6.addCell(cell2);
		table6.addCell(cell3);
		table6.addCell(cell4);
		table6.addCell(cell5);
		table6.addCell(cell6);
		document.add(table6);
		
		
		Paragraph paragraph34 = new Paragraph(
		"1.1.2 Percentage of Programmes where syllabus revision was carried out during the last five years.\r\n"
		+ "\r\n",
		font5);
		paragraph34.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
///if(criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse112() !=null)
{
	//	Paragraph paragraph35 = new Paragraph("Response\r\n"
	//	+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse112()
	//	: ""),
	//	font3);
//		paragraph35.setAlignment(Paragraph.ALIGN_JUSTIFIED);
				}
	
		Paragraph paragraph36 = new Paragraph(
		"1.1.2.1 Number of all Programmes offered by the institution during the last five years.\r\n" + "\r\n"
		+ "",
		font3);
		paragraph36.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
	
//		Paragraph paragraph37 = new Paragraph("Response:"
	//	+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1121t1() : ""),
	//	font5);
		
	//	paragraph37.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
	
		Paragraph paragraph38 = new Paragraph(
		"1.1.2.2 How many Programmes were revised out of total number of Programmes offered during the last five years",
		font5);
		paragraph38.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		
//if(criteria1Fieldinfo.getCriteria1FieldInfoQn() !=null) {
	//	Paragraph paragraph39 = new Paragraph("Response:"
//		+ (criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1122t1() : ""),
//		font5);
		
		
		
//		paragraph39.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//document.add(paragraph39);
//		
//}
		
		PdfPTable table1 = new PdfPTable(2);
		table1.setWidthPercentage(100);
		
//		PdfPCell cell58criteria5 = new PdfPCell(
//				new Paragraph(criteria5Record != null ? criterai5file.get(15).getCriteria5FilePath() : ""));
		
		PdfPCell cell11 = new PdfPCell(new Paragraph("FileDiscription", font3));
		PdfPCell cell12 = new PdfPCell(new Paragraph("Document", font3));
		PdfPCell cell13 = new PdfPCell(new Paragraph("Minutes of relevant Academic Council/BOS meeting", font3));
		PdfPCell cell14 = new PdfPCell(new Paragraph(criteria1Record !=null ? criteria1file.get(0).getCriteria1FilePath(): ""));
		PdfPCell cell17 = new PdfPCell(new Paragraph("Any additional information"));
		PdfPCell cell18 = new PdfPCell(new Paragraph(criteria1Record !=null ? criteria1file.get(1).getCriteria1FilePath() : ""));
		PdfPCell cell15 = new PdfPCell(	new Paragraph("Details of program syllabus revision in last 5 years(Data Template)"));
		
		PdfPCell cell16 = new PdfPCell(new Paragraph(criteria1Record !=null ? criteria1file.get(2).getCriteria1FilePath() : ""));
		
		table1.addCell(cell11);
		table1.addCell(cell12);
		table1.addCell(cell13);
		table1.addCell(cell14);
		table1.addCell(cell17);
		table1.addCell(cell18);
		table1.addCell(cell15);
		table1.addCell(cell16);
	
		document.add(table1);
		
		PdfPTable table31 = new PdfPTable(1);
		table31.setWidthPercentage(100);
		table31.addCell(
				"1.1.3 Average percentage of courses having focus on employability/ entrepreneurship/ skill development offered by the institution during the last five years\r\n"
						+ "\r\n" + "Response:");
			//			+ (criteria1Fieldinfo != null
						//		? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse113()
				//				: ""));
		
		table31.addCell(
				"1.1.3.1 Number of courses having focus on employability/ entrepreneurship/ skill development year- wise during the last five years\r\n+\r\n");

		// table31.addCell(table113_1);

		table31.setSpacingBefore(25);
		table31.setSpacingAfter(25);

		document.add(table31);
		
if(criteria1Fieldinfo.getYearTable1131() !=null)
{
		Table table1131 = new Table(criteria1Fieldinfo.getYearTable1131().size(), 2);

		table1131.setPadding(10);
		table1131.setWidth(100f);

		for (int i = 0; i < criteria1Fieldinfo.getYearTable1131().size(); i++) {
			table1131.addCell(criteria1Fieldinfo.getYearTable1131().get(i).getInput1131y());
		}
		for (int i = 0; i < criteria1Fieldinfo.getYearTable1131().size(); i++) {
			table1131.addCell(criteria1Fieldinfo.getYearTable1131().get(i).getInput1131v());
		}

		document.add(table1131);
}

	
		
		PdfPTable table3 = new PdfPTable(2);
		table3.setWidthPercentage(100);
		
		PdfPCell cell31 = new PdfPCell(new Paragraph("FileDiscription\r\n", font3));
		PdfPCell cell32 = new PdfPCell(new Paragraph("Document\r\n", font3));
		PdfPCell cell33 = new PdfPCell(new Paragraph("Programme / Curriculum/ Syllabus of the courses\r\n\r\n"));
		PdfPCell cell34 = new PdfPCell(
		new Paragraph((criteria1file.size() > 0) ? criteria1file.get(4).getCriteria1FilePath() : ""));
		PdfPCell cell35 = new PdfPCell(new Paragraph("MoU's with relevant organizations for these courses, if any"));
		PdfPCell cell36 = new PdfPCell(
		new Paragraph((criteria1file.size() > 0) ? criteria1file.get(5).getCriteria1FilePath() : ""));
		
		PdfPCell cell37 = new PdfPCell(new Paragraph(
		"Minutes of the Boards of Studies/ Academic Council meetings with approvals for these coursesBudget and expenditure statements signed by the Finance Officer indicating seed money provided and utilized"));
		PdfPCell cell38 = new PdfPCell(
		new Paragraph((criteria1file.size() > 0) ? criteria1file.get(6).getCriteria1FilePath() : ""));
		PdfPCell cell39 = new PdfPCell(new Paragraph(
		"Any additional information"));
		PdfPCell cell40 = new PdfPCell(
		new Paragraph((criteria1file.size() > 0) ? criteria1file.get(7).getCriteria1FilePath() : ""));
		PdfPCell cell41 = new PdfPCell(new Paragraph("Average percentage of courses having focus on employability/ entrepreneurship(Data Template)\r\n\r\n"));
		PdfPCell cell42 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(7).getCriteria1FilePath() :""));
		
		/*
		* com.lowagie.text.Font fontTitle43 =
		* FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle43.setSize(16)
		*/
		
		
		
		table3.addCell(cell31);
		table3.addCell(cell32);
		table3.addCell(cell33);
		table3.addCell(cell34);
		table3.addCell(cell35);
		table3.addCell(cell36);
		table3.addCell(cell37);
		table3.addCell(cell38);
		table3.addCell(cell39);
		table3.addCell(cell40);
		table3.addCell(cell41);
		table3.addCell(cell42);
		document.add(table3);
		
	
		
	
		document.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return file.toAbsolutePath().toString();
			}
		
		
		////////////////////////////////////////////////////
		///////////////////criteria 1 end..............
		/////////////////////////////////////////
		
		}
		
		
