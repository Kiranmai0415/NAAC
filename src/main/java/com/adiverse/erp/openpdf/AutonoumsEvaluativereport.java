package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.adiverse.erp.model.EvaluativeFileUpload;
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
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class AutonoumsEvaluativereport {
	
	@Autowired
	SsrService ssrService;

	@Value("${logoImgPath}")
	private String logoImgPath;

	@Value("${logoImgScale}")
	private Float[] logoImgScale;

      @Value("${upload.files.path}")
	  private String reportGeneratePath;

	public Image headerImage;

	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);

	List<ProfileoftheCollege> profileList = null;
	ProfileoftheCollege ProfileRecord = null;
	List<EvaluativeFileUpload> Profilefile = null;

	
	public String generateReport() throws DocumentException, IOException {
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
			
			
			profileList=ssrService.getAllSsrData();
			if (CollectionUtils.isNotEmpty(profileList)) {
				ProfileRecord = profileList.get(0);
			} else {
				ProfileRecord = new ProfileoftheCollege();
			}

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "qualityAdivsorReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
		
			addLogo(document);	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Paragraph paragraph17ssr = new Paragraph("EVALUATIVE REPORT OF THE DEPARTMENTS\r\n\r\n", font2);
		paragraph17ssr.setAlignment(Paragraph.ALIGN_LEFT);

		document.add(paragraph17ssr);

		PdfPTable table14ssr = new PdfPTable(2);

		table14ssr.setWidthPercentage(100f);
		table14ssr.setWidths(new int[] { 3, 3 });
		table14ssr.setSpacingBefore(5);
		PdfPCell cell33ssr = new PdfPCell(new Paragraph("Department Name\r\n\r\n", font3));
		table14ssr.addCell(cell33ssr);

		PdfPCell cell34ssr = new PdfPCell(new Paragraph("Upload Report\r\n\r\n", font3));
		table14ssr.addCell(cell34ssr);

		PdfPCell cell35ssr = new PdfPCell(new Paragraph("Civil Engineering\r\n\r\n"));
		table14ssr.addCell(cell35ssr);

		PdfPCell cell36ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell36ssr);

		PdfPCell cell37ssr = new PdfPCell(new Paragraph("Computer Science And EngineeringFile Description\r\n\r\n"));
		table14ssr.addCell(cell37ssr);

		PdfPCell cell38ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell38ssr);

		PdfPCell cell39ssr = new PdfPCell(new Paragraph("Department Of Management Studies\r\n\r\n"));
		table14ssr.addCell(cell39ssr);

		PdfPCell cell40ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell40ssr);

		PdfPCell cell41ssr = new PdfPCell(new Paragraph("Electrical And Electronics Engineering\r\n\r\n"));
		table14ssr.addCell(cell41ssr);

		PdfPCell cell42ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell42ssr);

		PdfPCell cell43ssr = new PdfPCell(new Paragraph("Electronics And Communication Engineering\r\n\r\n"));
		table14ssr.addCell(cell43ssr);

		PdfPCell cell44ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell44ssr);

		PdfPCell cell45ssr = new PdfPCell(new Paragraph("Information Technology\r\n\r\n"));
		table14ssr.addCell(cell45ssr);

		PdfPCell cell46ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell46ssr);

		PdfPCell cell47ssr = new PdfPCell(new Paragraph("Mechanical Engineering\r\n\r\n"));
		table14ssr.addCell(cell47ssr);

		PdfPCell cell48ssr = new PdfPCell(new Paragraph());
		table14ssr.addCell(cell48ssr);

		document.add(table14ssr);
		table14ssr.setSpacingAfter(10f);

		Paragraph paragraph18ssr = new Paragraph("Institutional preparedness for NEP\r\n\r\n\r\n", font3);
		paragraph18ssr.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(paragraph18ssr);

		PdfPTable table15ssr = new PdfPTable(2);

		table15ssr.setWidthPercentage(100f);
		table15ssr.setWidths(new int[] { 70, 70 });
		table15ssr.setSpacingBefore(20f);
		table15ssr.setSpacingAfter(20f);

		PdfPCell cell49ssr = new PdfPCell(new Paragraph("1. Multidisciplinary/interdisciplinary:\r\n\r\n"));

		table15ssr.addCell(cell49ssr);

		PdfPCell cell50ssr = new PdfPCell(new Paragraph());
		table15ssr.addCell(cell50ssr);

		PdfPCell cell51ssr = new PdfPCell(new Paragraph("2. Academic bank of credits (ABC):\r\n\r\n"));
		table15ssr.addCell(cell51ssr);
		PdfPCell cell52ssr = new PdfPCell(new Paragraph());
		table15ssr.addCell(cell52ssr);

		PdfPCell cell53ssr = new PdfPCell(new Paragraph("3. Skill development:\r\n\r\n"));
		table15ssr.addCell(cell53ssr);

		PdfPCell cell54ssr = new PdfPCell(new Paragraph());
		table15ssr.addCell(cell54ssr);

		PdfPCell cell55ssr = new PdfPCell(new Paragraph(
				"4. Appropriate integration of Indian Knowledge system  (teaching in Indian Language, culture, using online course"));
		table15ssr.addCell(cell55ssr);

		PdfPCell cell56ssr = new PdfPCell(new Paragraph());
		table15ssr.addCell(cell56ssr);

		PdfPCell cell57ssr = new PdfPCell(new Paragraph("5. Focus on Outcome based education (OBE):\r\n\r\n\r\n"));
		table15ssr.addCell(cell57ssr);

		PdfPCell cell58ssr = new PdfPCell(new Paragraph());
		table15ssr.addCell(cell58ssr);

		PdfPCell cell59ssr = new PdfPCell(new Paragraph("6. Distance education/online education:\r\n\r\n"));
		table15ssr.addCell(cell59ssr);

		PdfPCell cell60ssr = new PdfPCell(new Paragraph());
		table15ssr.addCell(cell60ssr);
        
		document.add(table15ssr);
		

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
			img.scalePercent(logoImgScale[0], logoImgScale[1]);
			img.setAlignment(Element.ALIGN_CENTER);
			document.add(img);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	//		emailvalue=1;
		}
	}
	

}
