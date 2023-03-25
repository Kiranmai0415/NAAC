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
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria1_FileUpload;
import com.adiverse.erp.service.Criteria1Service;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class AffilatedCriteria14Report2 
{
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	
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
	
	
	public String generateReport(Criteria1_FieldInfo criteria1Fieldinfo) throws DocumentException, IOException {
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
			
			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AffilatedCriteria1Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
			

			Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
			paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph);

			Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n", font2);
			paragraph1.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph1);
	
			//141
			Paragraph paragraph1441 = new Paragraph("1.4 Feedback System",font3);
			document.add(paragraph1441);
			
			
		
			Paragraph paragraph1442 = new Paragraph("1.4.1: Institution obtains feedback on the academic performance and ambience of the institution from various stakeholders, such as Students, Teachers, Employers, Alumni etc. and action taken report on the feedback is made available on institutional website (Yes or No)\r\n");
			document.add(paragraph1442);
			if(criteria1Fieldinfo.getCriteria14Qn() !=null)
			{
			Paragraph paragraph1443 = new Paragraph(criteria1Fieldinfo != null	? criteria1Fieldinfo.getCriteria14Qn().get(0).getResponse141():"");
			document.add(paragraph1443);
			}
			
			Paragraph paragraph1443= new Paragraph("\r\n");
			document.add(paragraph1443);
			
			
			
			
			
			
			
			PdfPTable table141 = new PdfPTable(2);
			table141.setWidthPercentage(100);
			PdfPTable table1410 = new PdfPTable(1);
			table1410.setWidthPercentage(100);
			
			PdfPCell cell141 = new PdfPCell(new Paragraph("File Description",font3));
			PdfPCell cell142= new PdfPCell(new Paragraph("Document",font3));
			PdfPCell cell143= new PdfPCell(new Paragraph("criteria1Fieldinfo"));
			PdfPCell cell144= new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :""));
			table141.addCell(cell141);
			table141.addCell(cell142);
			table141.addCell(cell143);
			table141.addCell(cell144);
           document.add(table141);			
//			table1410.addCell("1.4.1 Institution obtains feedback on the syllabus and its transaction at the institution from thfollowing stakeholders 1) Students 2)Teachers 3)Employers 4)Alumni\r\n"+"Response :" 
//			+(criteria1Fieldinfo != null	? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse141():""));
//			
			
//			 PdfPCell cell7criteria1 = new PdfPCell(new Paragraph(
//						"1.4.1 Institution obtains feedback on the syllabus and its transaction at the institution from thfollowing stakeholders 1) Students 2)Teachers 3)Employers 4)Alumni"+ "Response:"
//								+(criteria1Record != null	? criteria1Record.getCriteria1FieldInfoQn().get(0).getResponse141():""),font3));
//			 table141.addCell(cell7criteria1);
//			document.add(table141);
//			
//			
//			
//			
//			table1410.addCell(table141);
//			document.add(table1410);
//			
//			PdfPTable table142 = new PdfPTable(2);
//			table142.setWidthPercentage(100);
//			
//			PdfPCell cell1421 = new PdfPCell(new Paragraph("File Description",font3));
//			PdfPCell cell1422= new PdfPCell(new Paragraph("Document",font3));
//			PdfPCell cell1423= new PdfPCell(new Paragraph("Upload any additional information"));
//			PdfPCell cell1424= new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(29).getCriteria1FilePath() :""));
//			PdfPCell cell1425= new PdfPCell(new Paragraph("URL for feedback report"));
//			PdfPCell cell1426= new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(30).getCriteria1FilePath() :""));
//			table142.addCell(cell1421);
//			table142.addCell(cell1422);
//			table142.addCell(cell1423);
//			table142.addCell(cell1424);
//			table142.addCell(cell1425);
//			table142.addCell(cell1426);
//			PdfPTable table14100 = new PdfPTable(1);
//			table14100.setWidthPercentage(100);
//			
//			table14100.addCell("1.4.2 Feedback process of the Institution may be classified as follows: Options:\r\n"
//					+ "1.Feedback collected, analysed and action taken and feedback available on website\r\n"
//					+ "2.Feedback collected, analysed and action has been taken\r\n"
//					+ "3.Feedback collected and analysed\r\n"
//					+ "4.Feedback collected\r\n"
//					+ "5. Feedback not collecte");
//			
//			table14100.addCell(table142);
//			document.add(table14100);
//			
			
			document.close();

			
		

		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}
	
	
	

}
