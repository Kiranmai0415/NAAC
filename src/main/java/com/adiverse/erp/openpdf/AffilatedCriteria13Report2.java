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
public class AffilatedCriteria13Report2 
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
	
	        
	        //131
	        Paragraph paragraph1331 = new Paragraph("1.3  Curriculum Enrichment",font3);
			document.add(paragraph1331);
			
	        
	        
			
			
			 
			Paragraph paragraph11 = new Paragraph(
						" 1.3.1 Institution integrates crosscutting issues relevant to Professional Ethics ,Gender, Human Values ,Environment and Sustainability into the Curriculum\r\n"+ "Response:\r\n");
			
			document.add(paragraph11);
			
			Paragraph paragraph12 = new Paragraph(criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria13Ql().get(0).getResponse131():"");
			document.add(paragraph12);
			
			Paragraph paragraph13 = new Paragraph("\r\n");
			document.add(paragraph13);
			
			PdfPTable table131 = new PdfPTable(2);
			table131.setWidthPercentage(100);
			 PdfPTable table1310 = new PdfPTable(1);
			 table1310.setWidthPercentage(100);
			
			PdfPCell cell131= new PdfPCell(new Paragraph("File Description",font3));
			PdfPCell cell132 = new PdfPCell(new Paragraph("Document",font3));
			
			PdfPCell cell133 = new PdfPCell(new Paragraph("Upload the list and description of courses which address the Professional Ethics, Gender, Human Values, Environment and Sustainability into theCurriculum.\r\n"
					+ ""));
			PdfPCell cell134 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :""));
			PdfPCell cell135 = new PdfPCell(new Paragraph("Any additional information"));
			PdfPCell cell136= new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :""));
			table131.addCell(cell131);
			table131.addCell(cell132);
			table131.addCell(cell133); 
			table131.addCell(cell134);
			table131.addCell(cell135);
			table131.addCell(cell136);
			document.add(table131);

			
			
			
			
			
			
			
			
			
			

			document.add(paragraph13);

			PdfPTable table133 = new PdfPTable(2);
			table133.setWidthPercentage(100);
			PdfPTable table1330 = new PdfPTable(1);
			table1330.setWidthPercentage(100);
			PdfPCell cell1331= new PdfPCell(new Paragraph("File Description",font3));
			PdfPCell cell1332 = new PdfPCell(new Paragraph("Document",font3));
			
			PdfPCell cell1333 = new PdfPCell(new Paragraph("Institutional data in the prescribed format"
					+ "\r\n"));
			PdfPCell cell1334 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :""));
			
			PdfPCell cell1335 = new PdfPCell(new Paragraph("Upload supporting document\r\n"));
			PdfPCell cell1336 = new PdfPCell(new Paragraph((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :""));
			
			table133.addCell(cell1331);
			table133.addCell(cell1332);
			table133.addCell(cell1333);
			table133.addCell(cell1334);
			table133.addCell(cell1335);
			table133.addCell(cell1336);
			
			table1330.addCell("1.3.2: Percentage of students undertaking field projects/ internships / student projects (Data for the latest completed academic year).\r\n"
					+ "Response: "+(criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria13Qn().get(0).getResponse133():""));
			document.add(paragraph13);

			table1330.addCell("1.3.2.1: Number of students undertaking field projects / internships / student projects\r\n");
					//+ "Response:"+(criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1321t11():""));

			table1330.addCell("1.3.2.1: Total number of students\r\n");
			//		+ "Response:"+(criteria1Fieldinfo != null ? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getInput1321t11():""));

			table1330.addCell(table133);
			table1330.setSpacingAfter(20);
			document.add(table1330);
			
			document.close();
				

		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}
	
	
	

}
