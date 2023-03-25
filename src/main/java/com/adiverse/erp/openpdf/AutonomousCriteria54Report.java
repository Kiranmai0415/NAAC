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

import com.adiverse.erp.model.Criteria5_FieldInfo;
import com.adiverse.erp.model.Criteria5_FileUpload;
import com.adiverse.erp.service.Criteria5Service;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@Component
public class AutonomousCriteria54Report 
{
	

	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	
	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
	
	
	@Autowired
	Criteria5Service service5;



		///////////////////////////////////////////////////////////////////////////////////////////
		// criteria 5 start here
		//////////////////////////////////////////////////////////////////////////////////////////

		//java.util.List<Criteria5_FieldInfo> criteria5List1 = service5.getAllCriteria5Data();

		// criteria5Record1 = criteria5List1.get(0);

		//java.util.List<Criteria5_FileUpload> criteria5file = criteria5Record1.getCriteria5FileUpload();

		/*
		 * Font font0 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font0.setSize(16);
		 * 
		 * Font font1criteria5 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font1criteria5.setSize(14);
		 * 
		 * Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		 * font2.setSize(12);
		 * 
		 * // Font font3=FontFactory.getFont(FontFactory.HELVETICA); //
		 * font.setSize(16);
		 * 
		 * // Font font4=FontFactory.getFont(FontFactory.HELVETICA); //
		 * font1.setSize(14);
		 * 
		 * Font font5criteria5 = FontFactory.getFont(FontFactory.HELVETICA);
		 * font5criteria5.setSize(12);
		 */

		
		
		
		
		
		List<Criteria5_FieldInfo> criteria5List = null;
		Criteria5_FieldInfo criteria5Record = null;
		List<Criteria5_FileUpload> criterai5file = null;
		
		
		public String generateReport(Criteria5_FieldInfo criteria5Fieldinfo) throws DocumentException, IOException {
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
				criteria5List = service5.getAllCriteria5Data();
				if (CollectionUtils.isNotEmpty(criteria5List)) {
					criteria5Record = criteria5List.get(0);
					criterai5file = criteria5Record.getCriteria5FileUpload();
				} else {
					criteria5Record = new Criteria5_FieldInfo();
					criterai5file = new ArrayList<>();
				}
				System.out.println("report generation path from property file ==>" + reportGeneratePath);
				if (root != null) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
					String strDate = formatter.format(date);
					reportPath = "AuthonomousCriteria5Report-" + strDate + ".pdf";
					file = root.resolve(reportPath);
				}
				System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
				
				
				Document document = new Document(PageSize.A4);
				// PdfWriter.getInstance(document, response.getOutputStream());
				PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
				
				document.open();
				System.out.println("open the document==========>");
		
		
		Paragraph paragraph0 = new Paragraph("Criterion 5 - Student Support and Progression\r\n\r\n", font1);
		paragraph0.setAlignment(Paragraph.ALIGN_JUSTIFIED);

	

		Paragraph paragraph05 = new Paragraph("5.4 Alumni Engagement\r\n\r\n\r\n", font3);
		paragraph05.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(paragraph05);

		PdfPTable table013 = new PdfPTable(2);
		PdfPTable table131 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table013.setWidthPercentage(100);
		table131.setWidthPercentage(100);

		PdfPCell cell89criteria5 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font3));
		PdfPCell cell90criteria5 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
		PdfPCell cell91criteria5 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
		PdfPCell cell92criteria5 = new PdfPCell(
				new Paragraph(criteria5Record != null ? criterai5file.get(0).getCriteria5FilePath() : ""));
		PdfPCell cell93criteria5 = new PdfPCell(new Paragraph("Link for additional information\r\n\r\n\r\n"));
		PdfPCell cell94criteria5 = new PdfPCell(new Paragraph());

		table013.addCell(cell89criteria5);
		table013.addCell(cell90criteria5);
		table013.addCell(cell91criteria5);
		table013.addCell(cell92criteria5);
		table013.addCell(cell93criteria5);
		table013.addCell(cell94criteria5);

		// PdfPCell cell023 = new PdfPCell(new Paragraph(" ",font2));
		// cell023.setAlignment(PdfCell.ALIGN_LEFT);
//
//		PdfPCell cell0244 = new PdfPCell(new Paragraph(
//				"5.4.1 The Alumni Association / Chapters (registered and functional) contributes significantly to the development of the institution through financial and other support services.\r\n"
//						+ "\r\n\r\n" + "Response:"
//						+ (criteria5Fieldinfo != null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQl().get(0).getResponse541()
//								: ""),
//				font3));

		PdfPCell cell0255 = new PdfPCell(new Paragraph(
				"* Alumni members are made members of Boards of Studies of various departments. They contribute in the curriculum design. They examine the current curriculum and give suggestions vis-a-vis the industry-institution interface requirements.\r\n"
						+ "* They also give advice on the establishment of laboratories, which involve experiments using modern tools for improved employability of students.\r\n"
						+ "* Alumni members are invited to deliver technical talks and provide career guidance to the students. Alumni members help the students in establishing a network of support for their professional career progression, namely, higher education in India and abroad, internships and placements.\r\n"
						+ "* Alumni working in various industries connect the placement cell of the college to their respective industries, thereby, facilitate the college with opportunities for internships and placements of students.\r\n"
						+ "* In addition, they also connect the industry-institute interaction cell of the college, facilitating industrial visits, internships for students and resource persons for student development and faculty development programs.\r\n"
						+ "* Alumni promote the college at various fora, thereby serving as brand ambassadors of the college, by making the audience aware about the salient features of the college as well as important developments that have been taking place in the college over the years.\r\n"
						+ "* Alumni working in various R & D establishments connect the faculty of the college to their professional seniors, facilitating testing requirements of, as part of research carried out by faculty, and also in the preparation of research proposals being submitted by the college for various funding agencies.\r\n"
						+ "* Alumni, who pursued higher education abroad, help the students in securing admissions in the universities, where they have studied, through preparation of statement of purpose, research projects and funds available with various professors in universities. This information is extremely useful for students, since, they can approach the professors by explicitly mentioning their research interests, which may perhaps improve their chances of securing scholarship with full or partial tuition fee waiver.\r\n"
						+ "* Alumni of the college have donated certain resources/facilities to college for students use.\r\n"
						+ "",
				font5));

//		table131.addCell(cell0244);
		table131.addCell(cell0255);

		table131.addCell(table013);

		table131.setSpacingBefore(20f);
		table131.setSpacingAfter(20f);

		document.add(table131);

		PdfPTable table014 = new PdfPTable(1);

		// Setting width of table, its columns and spacing
		table014.setWidthPercentage(100);
//
//		PdfPCell cell0266 = new PdfPCell(new Paragraph(
//				"5.4.2 Alumni financial contribution during the last five years (in INR).\r\n" + "\r\n" + "Response:"
//						+ (criteria5Fieldinfo != null
//								? criteria5Fieldinfo.getCriteria5FieldInfoQn().get(0).getResponse542()
//								: ""),
//				font3));
//		table014.addCell(cell0266);

		table014.setSpacingBefore(20f);
		table014.setSpacingAfter(20f);

		document.add(table014);

		document.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return file.toAbsolutePath().toString();
		}

}
