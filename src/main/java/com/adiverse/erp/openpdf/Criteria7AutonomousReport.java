package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adiverse.erp.model.Criteria7_FieldInfo;
import com.adiverse.erp.model.Criteria7_FileUpload;
import com.adiverse.erp.service.Criteria7Service;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class Criteria7AutonomousReport {

	@Value("${upload.files.path}")
	private String reportGeneratePath;

	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);

	@Autowired
	Criteria7Service service7;

	List<Criteria7_FieldInfo> criteria7List = null;
	Criteria7_FieldInfo criteria7Record = null;
	List<Criteria7_FileUpload> criteria7file = null;

	public String generateReport(Map<String, String> allParams ) throws DocumentException, IOException {
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


//			
//			Map<String, String> allParams = new HashMap<String, String>();
//			allParams.put("collegeId",criteria7Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear", criteria7Fieldinfo.getCriteriaId().getFinancialYear());
//			allParams.put("typeofInstitution", criteria7Fieldinfo.getCriteriaId().getTypeofInstitution() );
//			
			
			
			
			criteria7List = service7.getAllCriteria7Data(allParams);
			if (CollectionUtils.isNotEmpty(criteria7List)) {
				criteria7Record = criteria7List.get(0);
				criteria7file = criteria7Record.getCriteria7FileUpload();
			} else {
				criteria7Record = new Criteria7_FieldInfo();
				criteria7file = new ArrayList<Criteria7_FileUpload>();
			}

			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "Criteria7AutonomousReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");
			
			
		// 7.1

			Paragraph paragraphcriteria7 = new Paragraph("Criterion 7 - Institutional Values and Best Practices\r\n",
					font1);
			paragraphcriteria7.setAlignment(Paragraph.ALIGN_CENTER);
		
			document.add(paragraphcriteria7);
			
			Paragraph paragraphlinecriteria7 = new Paragraph("_______________________________________________________________",
					font1);
			paragraphcriteria7.setAlignment(Paragraph.ALIGN_CENTER);
		
			document.add(paragraphlinecriteria7);
			
			Paragraph paragraph2criteria7 = new Paragraph("7.1 Institutional Values and Social Responsibilities\r\n\r\n", font2);
			paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			
			document.add(paragraph2criteria7);

			PdfPTable table711criteria7 = new PdfPTable(1);
			table711criteria7.setWidthPercentage(100f);

//
			PdfPCell cell711criteria7 = new PdfPCell(new Paragraph(
					"7.1.1	Institution has initiated the Gender Audit and measures for the \r\n"
					+ "promotion of gender equity during the last five years\r\n\r\n"
					 + "Response:"
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Ql().get(0).getResponse711()
									: "")+"\r\n\r\n",
					font4));

		table711criteria7.addCell(cell711criteria7);
			
			document.add(table711criteria7);

		
			PdfPCell cell8 = new PdfPCell();
			cell8.setPadding(8);
			document.add(cell8);
			// table
			PdfPTable tablecriteria7 = new PdfPTable(2);
			tablecriteria7.setWidthPercentage(100f);

			

			PdfPCell cell111criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell111criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell112criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell112criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1113criteria7 = new PdfPCell(new Paragraph("Annual gender sensitization action plan\r\n\r\n",font5));
			cell1113criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1114criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell1114criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell115criteria7 = new PdfPCell(new Paragraph("Specific facilities provided for women in terms\r\n"
					+ "of: a.Safety and security b.Counselling c.Common\r\n"
					+ "Rooms d. Day care center for young children e.\r\n" + "Any other relevant information/r/n/r/n",font5));
			cell115criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell116criteria7 = new PdfPCell(new Paragraph(""));
			cell116criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			tablecriteria7.addCell(cell111criteria7);
			tablecriteria7.addCell(cell112criteria7);
			tablecriteria7.addCell(cell1113criteria7);
			tablecriteria7.addCell(cell1114criteria7);
			tablecriteria7.addCell(cell115criteria7);
			tablecriteria7.addCell(cell116criteria7);
			tablecriteria7.setSpacingBefore(20f);
			tablecriteria7.setSpacingAfter(20f);

			document.add(tablecriteria7);
		
			

			// table1
			PdfPTable table1criteria7 = new PdfPTable(2);
			PdfPTable table1criteria71 = new PdfPTable(1);

			table1criteria7.setWidthPercentage(100f);
			table1criteria71.setWidthPercentage(100f);

			// com.lowagie.text.Font font1 =FontFactory.getFont(FontFactory.TIMES_ROMAN);
			// font1.setColor(CMYKColor.BLACK);

			PdfPCell cell113criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n", font4));
			cell113criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell114criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell114criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11104criteria7 = new PdfPCell(new Paragraph("Geotagged Photographs\r\n\r\n",font5));
			cell11104criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1117criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell1117criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1190criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
			cell1190criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1191criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell1191criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			table1criteria7.addCell(cell113criteria7);
			table1criteria7.addCell(cell114criteria7);
			// table1.addCell(cell1113);
			table1criteria7.addCell(cell11104criteria7);
			table1criteria7.addCell(cell1117criteria7);
			table1criteria7.addCell(cell1190criteria7);
			table1criteria7.addCell(cell1191criteria7);

			PdfPCell cell071 = new PdfPCell(new Paragraph(
					"7.1.2	The Institution has facilities for alternate sources of energy and energy conservation measures\r\n"
							+ "\r\n" + "1.	Solar energy\r\n" + "2.	Biogas plant\r\n" + "3.	Wheeling to the Grid\r\n"
							+ "4.	Sensor-based energy conservation\r\n"
							+ "5.	Use of LED bulbs/ power efficient equipment\r\n" + "\r\n" + "Response:"
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse712()
									: "")+"\r\n\r\n",
					font4));

			table1criteria71.addCell(cell071);

//			table1criteria71.addCell(table1criteria7);

			table1criteria71.setSpacingBefore(20f);
			table1criteria71.setSpacingAfter(20f);

			document.add(table1criteria71);
			document.add(table1criteria7);

//			PdfPCell cell6criteria7 = new PdfPCell();
//			cell6criteria7.setPadding(5);
//			document.add(cell6criteria7);

			
			PdfPTable table2criteria7 = new PdfPTable(2);
			PdfPTable table20criteria7 = new PdfPTable(1);
			
			table2criteria7.setWidthPercentage(100);
			table20criteria7.setWidthPercentage(100);

		
		
			PdfPCell cell51criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell51criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell52criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell52criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell53criteria7 = new PdfPCell(new Paragraph(
					"Relevant documents like agreements/MoUs with Government and other approved agencies\r\n\r\n", font5));
			cell53criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell54criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""), font5));
			cell54criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell55criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n ", font5));
			cell55criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell56criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""), font5));
			cell56criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell57criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n", font5));
			cell57criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell58criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""), font5));
			cell58criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table2criteria7.addCell(cell51criteria7);
			table2criteria7.addCell(cell52criteria7);
			table2criteria7.addCell(cell53criteria7);
			table2criteria7.addCell(cell54criteria7);
			table2criteria7.addCell(cell55criteria7);
			table2criteria7.addCell(cell56criteria7);
			table2criteria7.addCell(cell57criteria7);
			table2criteria7.addCell(cell58criteria7);
			
			
			
			PdfPCell cell0071 = new PdfPCell(new Paragraph(
					"7.1.3 Describe the facilities in the Institution for the management of the following types of\r\n\"\r\n"
					+ "degradable and non-degradable waste (within 500 words)"+ "Response:"+ (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse713()
									: "")+"\r\n\r\n ",
					font4));
			
			table20criteria7.addCell(cell0071);
//			table20criteria7.addCell(table2criteria7);
			table20criteria7.setSpacingBefore(20f);
			table20criteria7.setSpacingAfter(20f);

			document.add(table20criteria7);
			document.add(table2criteria7);

			

		

			PdfPTable table3criteria7 = new PdfPTable(2);
			PdfPTable table3criteria71 = new PdfPTable(1);
			table3criteria7.setWidthPercentage(100f);
			table3criteria71.setWidthPercentage(100f);

			
			

			PdfPCell cell61criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell61criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell62criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell62criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell63criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n",font5));
			cell63criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell64criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell64criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell65criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
			cell65criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell66criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell66criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			table3criteria7.addCell(cell61criteria7);
			table3criteria7.addCell(cell62criteria7);
			table3criteria7.addCell(cell63criteria7);
			table3criteria7.addCell(cell64criteria7);
			table3criteria7.addCell(cell65criteria7);
			table3criteria7.addCell(cell66criteria7);
			
			
			
			
			PdfPCell cell0073 = new PdfPCell(new Paragraph("7.1.4: Water conservation facilities available in the Institution:\r\n"
					+ "1. Rain water harvesting\r\n"
					+ "2. Borewell /Open well recharge\r\n"
					+ "3. Construction of tanks and bunds\r\n"
					+ "4. Waste water recycling\r\n"
					+ "5. Maintenance of water bodies and distribution system in the campus\r\n\r\n"+ "Response:"
					+ (criteria7Record != null ? criteria7Record.getCriteria71Qn().get(0).getResponse714()
							: "")+"\r\n\r\n",
					font4));
			table3criteria71.addCell(cell0073);
//			table3criteria71.addCell(table3criteria7);

			table3criteria71.setSpacingBefore(20f);
			table3criteria71.setSpacingAfter(20f);

			document.add(table3criteria71);
			document.add(table3criteria7);

			

			// 7.15 table
			PdfPTable table6criteria7 = new PdfPTable(2);
			PdfPTable table6criteria72 = new PdfPTable(1);

			table6criteria7.setWidthPercentage(100f);
			table6criteria72.setWidthPercentage(100f);

			/*
			 * com.lowagie.text.Font font13 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * font13.setColor(CMYKColor.BLACK);
			 */
			PdfPCell cell67criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell67criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell68criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell68criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell69criteria7 = new PdfPCell(
					new Paragraph("Geotagged photos / videos of the facilities\r\n\r\n",font5));
			cell69criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell70criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell70criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell71criteria7 = new PdfPCell(new Paragraph("Various policy documents / decisions circulated for implementation\r\n\r\n",font5));
			cell71criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell72criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell72criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell73criteria7 = new PdfPCell(new Paragraph("Any other relevant documents\r\n\r\n",font5));
			cell73criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell74criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell74criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			table6criteria7.addCell(cell67criteria7);
			table6criteria7.addCell(cell68criteria7);
			table6criteria7.addCell(cell69criteria7);
			table6criteria7.addCell(cell70criteria7);
			table6criteria7.addCell(cell71criteria7);
			table6criteria7.addCell(cell72criteria7);
			table6criteria7.addCell(cell73criteria7);
			table6criteria7.addCell(cell74criteria7);

			PdfPCell cell073 = new PdfPCell(new Paragraph("7.1.5	Green campus initiatives include " + "Response:"
					+ (criteria7Record != null ? criteria7Record.getCriteria71Qn().get(0).getResponse715()
							: "")+"\r\n\r\n",
					font4));

		table6criteria72.addCell(cell073);

//			table6criteria72.addCell(table6criteria7);

			table6criteria72.setSpacingBefore(20f);
			table6criteria72.setSpacingAfter(20f);

			document.add(table6criteria72);
			document.add(table6criteria7);

			

			PdfPTable table15criteria7 = new PdfPTable(2);
			PdfPTable table15criteria73 = new PdfPTable(1);

			table15criteria7.setWidthPercentage(100f);
			table15criteria73.setWidthPercentage(100f);

			PdfPCell cell75criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
			cell75criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell76criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
			cell76criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell77criteria7 = new PdfPCell(
					new Paragraph("Reports on environment and energy audits\r\n" + "submitted by the auditing agency\r\n\r\n",font5));
			cell77criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell78criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell78criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell79criteria7 = new PdfPCell(new Paragraph("Certification by the auditing agency\r\n\r\n",font5));
			cell79criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell80criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell80criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell81criteria7 = new PdfPCell(new Paragraph("Certificates of the awards received\r\n\r\n",font5));
			cell81criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell82criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell82criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell83criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
			cell83criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell84criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell84criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			table15criteria7.addCell(cell75criteria7);
			table15criteria7.addCell(cell76criteria7);
			table15criteria7.addCell(cell77criteria7);
			table15criteria7.addCell(cell78criteria7);
			table15criteria7.addCell(cell79criteria7);
			table15criteria7.addCell(cell80criteria7);
			table15criteria7.addCell(cell81criteria7);
			table15criteria7.addCell(cell82criteria7);
			table15criteria7.addCell(cell83criteria7);
			table15criteria7.addCell(cell84criteria7);

			PdfPCell cell074 = new PdfPCell(new Paragraph(
					"7.1.6	Quality audits on environment and energy are regularly undertaken \r\n"
					+ "by the institution\r\n"
					+ "7.1.6.1.The institutional environment and energy initiatives are \r\n"
					+ "confirmed through the following \r\n"
					+ "1. Green audit / Environmental audit\r\n"
					+ "2. Energy audit \r\n"
					+ "3.Clean and green campus recognitions/awards \r\n"
					+ "4. Beyond the campus environmental promotion and sustainability \r\n"
					+ "activities \r\n"
					+ "Options:\r\n"
					+ "A. All of the above\r\n"
					+ "B. Any 3 of the above\r\n"
					+ "C. Any 2 of the above\r\n"
					+ "D. Any 1of the above\r\n"
					+ "E. None of the above"
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse716()
									: "")+"\r\n\r\n",
					font4));

			table15criteria73.addCell(cell074);

//			table15criteria73.addCell(table15criteria7);

			table15criteria73.setSpacingBefore(20f);
			table15criteria73.setSpacingAfter(20f);

			document.add(table15criteria73);
			document.add(table15criteria7);
			

			// 7.1.7 table
			PdfPTable table17criteria7 = new PdfPTable(2);
			PdfPTable table17criteria73 = new PdfPTable(1);

			table17criteria7.setWidthPercentage(100f);
			table17criteria73.setWidthPercentage(100f);
			
			PdfPCell cell85criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
			cell85criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell86criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
			cell86criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell87criteria7 = new PdfPCell(
					new Paragraph("Geotagged photographs / videos of the facilities\r\n",font5));
			cell87criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell88criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell88criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell89criteria7 = new PdfPCell(new Paragraph("Policy documents and information brochures on the support to be provided\r\n\r\n",font5));
			cell89criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell90criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell90criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell91criteria7 = new PdfPCell(
					new Paragraph("Details of the Software procured for providing the assistance\r\n\r\n",font5));
			cell91criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell92criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell92criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell93criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
			cell93criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell94criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell94criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			table17criteria7.addCell(cell85criteria7);
			table17criteria7.addCell(cell86criteria7);
			table17criteria7.addCell(cell87criteria7);
			table17criteria7.addCell(cell88criteria7);
			table17criteria7.addCell(cell89criteria7);
			table17criteria7.addCell(cell90criteria7);
			table17criteria7.addCell(cell91criteria7);
			table17criteria7.addCell(cell92criteria7);
			table17criteria7.addCell(cell93criteria7);
			table17criteria7.addCell(cell94criteria7);

			PdfPCell cell075 = new PdfPCell(
					new Paragraph("7.1.7 The Institution has Differently-abled (Divyangjan) friendly, barrier \r\n"
							+ "free environment"
							+ "\r\n" + "Response:"
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse717()
									: "")+"\r\n\r\n",
							font4));

			table17criteria73.addCell(cell075);

//			table17criteria73.addCell(table17criteria7);

			table17criteria73.setSpacingBefore(20f);
			table17criteria73.setSpacingAfter(20f);

			document.add(table17criteria73);
			document.add(table17criteria7);


			// 7.1.8 table
			
			


			PdfPTable table18criteria7 = new PdfPTable(2);
			PdfPTable table108criteria7 = new PdfPTable(1);
			
			table18criteria7.setWidthPercentage(100f);
			table108criteria7.setWidthPercentage(100f);
			
			PdfPCell cell95criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell95criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell96criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell96criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell97criteria7 = new PdfPCell(
					new Paragraph("Policy documents and information brochures on the\r\n support to be provided\r\n\r\n",font5));
			cell97criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell98criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell98criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell99criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n",font5));
			cell99criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell100criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell100criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell101criteria7 = new PdfPCell(
					new Paragraph("Details of the Software procured for providing the" + "assistance\r\n\r\n",font5));
			cell101criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell102criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell102criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell103criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
			cell103criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell104criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell104criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			table18criteria7.addCell(cell95criteria7);
			table18criteria7.addCell(cell96criteria7);
			table18criteria7.addCell(cell97criteria7);
			table18criteria7.addCell(cell98criteria7);
			table18criteria7.addCell(cell99criteria7);
			table18criteria7.addCell(cell100criteria7);
			table18criteria7.addCell(cell101criteria7);
			table18criteria7.addCell(cell102criteria7);
			table18criteria7.addCell(cell103criteria7);
			table18criteria7.addCell(cell104criteria7);
			

			PdfPCell cell0075 = new PdfPCell(
					new Paragraph("7.1.8: Describe the Institutional efforts/initiatives in providing an inclusive \r\n"
							+ "environment i.e., tolerance and harmony towards cultural, regional, \r\n"
							+ "linguistic, communal socioeconomic and such other diversities "
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Ql().get(0).getResponse718()
									: "")+"\r\n\r\n",
							font4));
			table108criteria7.addCell(cell0075);
//			table108criteria7.addCell(table18criteria7);
		
			table108criteria7.setSpacingBefore(20f);
			table108criteria7.setSpacingAfter(20f);

			document.add(table108criteria7);
			document.add(table18criteria7);

		
			
			/*
			 * Font fontParagraph2147 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph2147.setSize(12);
			 */
			
			
			// 7.1.1.9 table
			
			PdfPTable table19criteria7 = new PdfPTable(2);
			PdfPTable table109criteria7 = new PdfPTable(1);
			
			table19criteria7.setWidthPercentage(100f);
			table109criteria7.setWidthPercentage(100f);
			
			
			PdfPCell cell105criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell105criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell106criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell106criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell107criteria7 = new PdfPCell(new Paragraph("Details of activities that inculcate values; necessary to render students in to responsible citizens\r\n\r\n",font5));
			cell107criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell108criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell108criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell109criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
			cell109criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell110criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell110criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			table19criteria7.addCell(cell105criteria7);
			table19criteria7.addCell(cell106criteria7);
			table19criteria7.addCell(cell107criteria7);
			table19criteria7.addCell(cell107criteria7);
			table19criteria7.addCell(cell108criteria7);
			table19criteria7.addCell(cell109criteria7);
			table19criteria7.addCell(cell110criteria7);
			
			PdfPCell cell00075 = new PdfPCell(
					new Paragraph(" 7.1.9: Sensitization of students and employees of the Institution to the \r\n"
							+ "constitutional obligations: values, rights, duties and responsibilities \r\n"
							+ "of citizens\r\n"
							+ ""
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Ql().get(0).getResponse719()
									: "")+"\r\n\r\n",
							font4));
			
			table109criteria7.addCell(cell00075);
//			table109criteria7.addCell(table19criteria7);
			
			table109criteria7.setSpacingBefore(20f);
			table109criteria7.setSpacingAfter(20f);
			document.add(table109criteria7);
			document.add(table19criteria7);

		
			// 7.1.10 table

			PdfPTable table31criteria7 = new PdfPTable(2);
			PdfPTable table31criteria74 = new PdfPTable(1);

			table31criteria7.setWidthPercentage(100);
			table31criteria74.setWidthPercentage(100);

			
			PdfPCell cell1111 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
			cell1111.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1112 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
			cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11113 = new PdfPCell(new Paragraph(
					" Code of ethics policy document\r\n\r\n",font5));
			cell11113.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11114 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell11114.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell1115 = new PdfPCell(new Paragraph("Details of the monitoring committee composition and minutes of the committee meeting, number of programmes organized, reports on the various programs etc., in support of the claims\r\n\r\n",font5));
			cell1115.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1116 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell1116.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell11117 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n",font5));
			cell11117.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1118 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell1118.setHorizontalAlignment(Element.ALIGN_CENTER);

			table31criteria7.addCell(cell1111);// 7.1.10 table
			table31criteria7.addCell(cell1112);
			table31criteria7.addCell(cell11113);
			table31criteria7.addCell(cell11114);
			table31criteria7.addCell(cell1115);
			table31criteria7.addCell(cell1116);
			table31criteria7.addCell(cell11117);
			table31criteria7.addCell(cell1118);

			PdfPCell cell076 = new PdfPCell(new Paragraph(
					"7.1.10 The Institution has a prescribed code of conduct for students, teachers, administrators and other staff and conducts periodic programmes in this regard.\r\n"
							+ "\r\n" + "1.	The Code of Conduct is displayed on the website\r\n"
							+ "2.	There is a committee to monitor adherence to the Code of Conduct\r\n"
							+ "3.	Institution organizes professional ethics programmes for students, teachers, administrators and other staff\r\n"
							+ "4.	Annual awareness programmes on Code of Conduct are organized\r\n" + "\r\n"
							+ "Response:\r\n"
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse7110()
									: "")+"\r\n\r\n",
					font4));

		table31criteria74.addCell(cell076);

//			table31criteria74.addCell(table31criteria7);

			table31criteria74.setSpacingBefore(20f);
			table31criteria74.setSpacingAfter(20f);

			document.add(table31criteria74);

			document.add(table31criteria7);

		
			PdfPTable table7111criteria7 = new PdfPTable(1);
			table7111criteria7.setWidthPercentage(100f);


			PdfPCell cell7111criteria7 = new PdfPCell(new Paragraph(
					"7.1.11 Institution celebrates / organizes national and international commemorative days, events and festivals (within 500 words).\r\n\r\n"
							+ "\r\n" + "Response:"
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Ql().get(0).getResponse7111()
									: "")+"\r\n\r\n",
					font4));
		//	table7111criteria7.addCell(cell7111criteria7);
			table7111criteria7.setSpacingBefore(20f);
			table7111criteria7.setSpacingAfter(20f);

			document.add(table7111criteria7);
			
			

			
		
		
		
			
			// table 4
			PdfPTable table4criteria7 = new PdfPTable(2);
			table4criteria7.setWidthPercentage(100);

			
			PdfPCell cell1119criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell1119criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1120criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell1120criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1121criteria7 = new PdfPCell(new Paragraph("Annual report of the celebrations and commemorative events for the last five years\r\n\r\n",font5));
			cell1121criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1122criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell1122criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell1123criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of some of the events\r\n\r\n",font5));
			cell1123criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1124criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell1124criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1125criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
			cell1125criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1126criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell1126criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			
			table4criteria7.addCell(cell1119criteria7);
			table4criteria7.addCell(cell1120criteria7);
			table4criteria7.addCell(cell1121criteria7);
			table4criteria7.addCell(cell1122criteria7);
			table4criteria7.addCell(cell1123criteria7);
			table4criteria7.addCell(cell1124criteria7);
			table4criteria7.addCell(cell1125criteria7);
			table4criteria7.addCell(cell1126criteria7);

			

		//	document.add(table4criteria7);
			
			
			// 7.2 
			
			PdfPTable table721criteria7 = new PdfPTable(1);
			table721criteria7.setWidthPercentage(100f);

			PdfPCell cell721criteria7 = new PdfPCell(new Paragraph(
					"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format provided in the Manual.\r\n"
							+ "\r\n\r\n"
							+ (criteria7Record != null
									? criteria7Record.getCriteria72Ql().get(0).getResponse721()
									: "")+"\r\n\r\n",
					font4));
			table721criteria7.addCell(cell721criteria7);
			table721criteria7.setSpacingBefore(20f);
			table721criteria7.setSpacingAfter(20f);

			document.add(table721criteria7);

			PdfPTable table5criteria7 = new PdfPTable(2);
			table5criteria7.setWidthPercentage(100);

			PdfPCell cell1110 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell1110.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1134 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell1134.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1135 = new PdfPCell(
					new Paragraph("Best practices in the Institutional web site\r\n\r\n ",font5));
			cell1135.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1136 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell1136.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1137 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n ",font5));
			cell1137.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1138 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell1138.setHorizontalAlignment(Element.ALIGN_CENTER);

			table5criteria7.addCell(cell1110);
			table5criteria7.addCell(cell1134);
			table5criteria7.addCell(cell1135);
			table5criteria7.addCell(cell1136);
			table5criteria7.addCell(cell1137);
			table5criteria7.addCell(cell1138);

		

			document.add(table5criteria7);
			
			
			// 7.3 
			Paragraph paragraph88 = new Paragraph("7.3 Institutional Distinctiveness\r\n", font2);
			document.add(paragraph88);


		

			PdfPTable table731criteria7 = new PdfPTable(1);
			table731criteria7.setWidthPercentage(100f);

			
			PdfPCell cell731criteria7 = new PdfPCell(new Paragraph(
					"7.3.1 Portray the performance of the Institution in one area distinctive to its priority and thrust within 1000 words\r\n"
							+ "\r\n\r\n" + "Response:"
							+ (criteria7Record != null
									? criteria7Record.getCriteria73Ql().get(0).getResponse731()
									: "")+"\r\n\r\n",
					font4));

			table731criteria7.addCell(cell731criteria7);
			table731criteria7.setSpacingBefore(20f);
			table731criteria7.setSpacingAfter(20f);

			document.add(table731criteria7);

			
			

			// table6
			

			

			PdfPTable table7criteria7 = new PdfPTable(2);

			table7criteria7.setWidthPercentage(100f);
			
			PdfPCell cell22criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
			cell22criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell23criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
			cell23criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell24criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n",font5));
			cell24criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell25criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell25criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell26criteria7 = new PdfPCell(new Paragraph("Appropriate web in the Institutional websit\r\n\r\n",font5));
			cell26criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell27criteria7 = new PdfPCell(new Paragraph(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "",font5));
			cell27criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);


			table7criteria7.addCell(cell22criteria7);
			table7criteria7.addCell(cell23criteria7);
			table7criteria7.addCell(cell24criteria7);
			table7criteria7.addCell(cell25criteria7);
			table7criteria7.addCell(cell26criteria7);
			table7criteria7.addCell(cell27criteria7);

			
			document.add(table7criteria7);

			document.close();
			

			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
