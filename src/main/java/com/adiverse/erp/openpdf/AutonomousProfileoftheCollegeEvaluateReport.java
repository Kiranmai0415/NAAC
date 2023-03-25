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
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.EvaluativeFileUpload;
import com.adiverse.erp.model.EvaluativeReport;
import com.adiverse.erp.model.EvaluativereportMain;
import com.adiverse.erp.model.ProfileoftheCollege;
import com.adiverse.erp.service.SsrService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class AutonomousProfileoftheCollegeEvaluateReport {
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;
	public Image headerImage;
	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);


	@Autowired
	private SsrService ssrService;
	
	
	List<ProfileoftheCollege>profileList = null;
	ProfileoftheCollege ProfileRecord = null;
	List<EvaluativeFileUpload> evaluativeFileUpload = null;
	
	
	public String generateReport(	Map<String, String> allParams ) throws DocumentException, IOException {
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
			
			
			
			profileList=ssrService.getAllAcademicData( allParams );
			if (CollectionUtils.isNotEmpty(profileList)) {
				ProfileRecord = profileList.get(0);
			} else {
				ProfileRecord = new ProfileoftheCollege();
			}
				
				System.out.println("report generation path from property file ==>" + reportGeneratePath);
				if (root != null) {
					SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
					String strDate = formatter.format(date);
					reportPath = "AutonomousProfileoftheCollegeEvaluateReport-" + strDate + ".pdf";
					file = root.resolve(reportPath);
				}
				System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
				
				Document document = new Document(PageSize.A4);
				// PdfWriter.getInstance(document, response.getOutputStream());
				PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
				
				document.open();
				System.out.println("open the document==========>");
			
				Paragraph paragraph15ssr = new Paragraph(" Evaluative report of the department\r\n\r\n", font1);
				paragraph15ssr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
				document.add(paragraph15ssr);	
				
				
				
				PdfPTable table60 = new PdfPTable(2);
				table60.setWidthPercentage(100);
				// inside inside table6
				/*
				 * com.lowagie.text.Font font15 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				 * font15.setColor(CMYKColor.BLACK);
				 */
				if(ProfileRecord.getEvaluativeReport()!=null) {
				PdfPCell cell09criteria7 = new PdfPCell(new Paragraph(ProfileRecord!=null?ProfileRecord.getEvaluativeReport().get(0).getValuet1():"",font5)); //dnam1
				PdfPCell cell010criteria7 = new PdfPCell(new Paragraph(ProfileRecord!=null?ProfileRecord.getEvaluativeFileupload().get(0).getEvaluative_filePath():"",font5));//file
				PdfPCell cell011criteria7 = new PdfPCell(new Paragraph(new Paragraph(ProfileRecord!=null?ProfileRecord.getEvaluativeReport().get(0).getValuet1():"",font5)));
				PdfPCell cell012criteria7 = new PdfPCell(new Paragraph(ProfileRecord!=null?ProfileRecord.getEvaluativeFileupload().get(0).getEvaluative_filePath():"",font5));
				PdfPCell cell013criteria7 = new PdfPCell(new Paragraph(new Paragraph(ProfileRecord!=null?ProfileRecord.getEvaluativeReport().get(0).getValuet1():"",font5)));
				PdfPCell cell09criteria17 = new PdfPCell(new Paragraph(ProfileRecord!=null?ProfileRecord.getEvaluativeFileupload().get(0).getEvaluative_filePath():"",font5));
				PdfPCell cell010criteria17 = new PdfPCell(new Paragraph(new Paragraph(ProfileRecord!=null?ProfileRecord.getEvaluativeReport().get(0).getValuet1():"",font5)));
				PdfPCell cell011criteria17 = new PdfPCell(new Paragraph(ProfileRecord!=null?ProfileRecord.getEvaluativeFileupload().get(0).getEvaluative_filePath():"",font5));
			
			

				

				table60.addCell(cell09criteria7);
				table60.addCell(cell010criteria7);
				table60.addCell(cell011criteria7);
				table60.addCell(cell012criteria7);
				table60.addCell(cell013criteria7);
				table60.addCell(cell09criteria17);
				table60.addCell(cell010criteria17);
				table60.addCell(cell011criteria17);
				
				
				table60.setSpacingBefore(20f);
				table60.setSpacingAfter(20f);

				document.add(table60);
				
				}

				document.close();
			
				} catch (Exception e) {
					e.printStackTrace();
				}
				return file.toAbsolutePath().toString();
			
						
				
			}
			
			
	
		
			private void addLogo(Document document) {
				Path root = Paths.get(reportGeneratePath);
				Path file = null;
			//	int emailvalue=0;
				try {
					file = root.resolve("naac.png");
					Image img = Image.getInstance(file.toAbsolutePath().toString());
				//	img.scalePercent(logoImgScale[0], logoImgScale[1]);
					img.setAlignment(Element.ALIGN_CENTER);
					document.add(img);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			//		emailvalue=1;
				}
			}
			
}
