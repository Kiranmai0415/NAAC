package com.adiverse.erp.openpdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class Criteria7UniversityReport {

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
				reportPath = "Criteria7UniversityReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

			// 7.1
			Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources", font1);
			paragraph1criteria4.setAlignment(Paragraph.ALIGN_CENTER);

			document.add(paragraph1criteria4);
			
			
			
			Paragraph paragraphcriteria7 = new Paragraph("Criterion 7 - Institutional Values and Best Practices\r\n",
					font2);
			paragraphcriteria7.setSpacingBefore(2f);
			paragraphcriteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			
			document.add(paragraphcriteria7);
			
			
			
			Paragraph paragraphcriteria00007 = new Paragraph("____________________________________________________________________________"
					);
			paragraphcriteria00007.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			
			
			document.add(paragraphcriteria00007);
			
			
			
			
			
			
	
	

	
			Paragraph paragraph2criteria7 = new Paragraph("7.1 Institutional Values and Social Responsibilities\r\n", font2);
			paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			
			document.add(paragraph2criteria7);
			
			
			
			PdfPTable tablecriteria7444 = new PdfPTable(1);
			tablecriteria7444.setWidthPercentage(100f);
			
			
			PdfPCell cell111criteria0007 = new PdfPCell(new Paragraph(
					"7.1.1nstitution has initiated Gender audit and measure for the promotion of gender equity .\r\n",
					font4));
			
			tablecriteria7444.addCell(cell111criteria0007);
			
		//	document.add(tablecriteria7444);
	

			PdfPTable table711criteria7 = new PdfPTable(1);
			table711criteria7.setWidthPercentage(100f);

			

			PdfPCell cell711criteria7 = new PdfPCell(new Paragraph(
					"7.1.1	Measures initiated by the Institution for the promotion of gender equity during the last five years.\r\n"
					 + "Response:"
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Ql().get(0).getResponse711()
									: ""),
					font4));
			cell711criteria7.setExtraParagraphSpace(10f);

			table711criteria7.addCell(cell711criteria7);
			table711criteria7.setSpacingBefore(20f);
			table711criteria7.setSpacingAfter(20f);

			document.add(table711criteria7);

			// paragaph3

			

			PdfPCell cell8 = new PdfPCell();
			cell8.setPadding(8);
			document.add(cell8);
			// table
			
			
			
			PdfPTable tablecriteria7 = new PdfPTable(2);
			tablecriteria7.setWidthPercentage(100f);

			
			PdfPCell cell111criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font4));
			cell111criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell112criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell111criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1113criteria7 = new PdfPCell(new Paragraph("Specific facilities provided for women in terms of: a.Safety and security b.Counselling c.Common Rooms d. Day care center for young children Any other relevant information"
					
					+ "	+  ",font5));
		
			cell1113criteria7.setExtraParagraphSpace(10f);
			cell1113criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1114criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			
			cell1114criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1114criteria7.setExtraParagraphSpace(10f);
			
			PdfPCell cell115criteria7 = new PdfPCell(new Paragraph("  Annual gender sensitization action plan",font5));
			cell115criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell116criteria7 = new PdfPCell(new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			cell116criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell116criteria7.setExtraParagraphSpace(10f);
			
			
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

			
			PdfPCell cell113criteria7 = new PdfPCell(new Paragraph("FileDiscription\r\n", font4));
			cell113criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell113criteria7.setExtraParagraphSpace(10f);
			PdfPCell cell114criteria7 = new PdfPCell(new Paragraph("Document\r\n", font4));
			cell114criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell11104criteria7 = new PdfPCell(new Paragraph("Geotagged Photographs\r\n",font5));
			cell11104criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1117criteria7 = new PdfPCell(
					new Paragraph((criteria7file != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell1117criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1117criteria7.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell1190criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n",font5));
			
			cell1190criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1191criteria7 = new PdfPCell(
					new Paragraph((criteria7file != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));

			cell1191criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1191criteria7.setExtraParagraphSpace(10f);
			
			
			table1criteria7.addCell(cell113criteria7);
			table1criteria7.addCell(cell114criteria7);
			// table1.addCell(cell1113);
			table1criteria7.addCell(cell11104criteria7);
			table1criteria7.addCell(cell1117criteria7);
			table1criteria7.addCell(cell1190criteria7);
			table1criteria7.addCell(cell1191criteria7);

			PdfPCell cell7101criteria7 = new PdfPCell(new Paragraph(
					"7.1.2: The Institution has facilities for alternate sources of energy and energy conservation measures\r\n"
					+ " 1. Solar energy\r\n"
					+ "2. Biogas plant\r\n"
					+ "3. Wheeling to the Grid \r\n"
					+ "4. Sensor-based energy conservation \r\n"
					+ "5. Use of LED bulbs/ power efficient equipment \r\n "
					+ "6. Wind will or any other clean green energy \r\n",font4));
			
			cell7101criteria7.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell0071 = new PdfPCell(new Paragraph( "Response:"
							+ (criteria7Record != null
							? criteria7Record.getCriteria71Qn().get(0).getInput712t1()
							: ""),
					font4));
			cell0071.setExtraParagraphSpace(10f);
		//	table1criteria71.addCell(cell0071);
//			
			
			
			table1criteria71.addCell(cell7101criteria7);
			



			table1criteria71.setSpacingBefore(20f);
			table1criteria71.setSpacingAfter(20f);

			document.add(table1criteria71);
			
			table1criteria7.setSpacingBefore(20f);
			
			table1criteria7.setSpacingAfter(20f);
			document.add(table1criteria7);

			PdfPCell cell6criteria7 = new PdfPCell();
			cell6criteria7.setPadding(5);
			document.add(cell6criteria7);

			// 7.1.3
			
			
			PdfPTable table1criteria7122 = new PdfPTable(1);

			table1criteria7122.setWidthPercentage(100f);
			
			Paragraph paragraph16criteria7 = new Paragraph(
					"7.1.3 Describe the facilities in the Institution for the management of the following types of\r\n"
							+ "degradable and non-degradable waste (within 500 words)\r\n",
					font4);
			cell0071.setExtraParagraphSpace(10f);
		//	document.add(paragraph16criteria7);

			PdfPCell cell10 = new PdfPCell();
			cell10.setPadding(10);
			
			

			PdfPTable table713criteria7 = new PdfPTable(1);
			table713criteria7.setWidthPercentage(100f);

			

			PdfPCell cell713criteria7 = new PdfPCell(new Paragraph(
					"7.1.3 Describe the facilities in the Institution for the management of the following types of degradable and non-degradable waste (within 500 words)\r\n"
					
							+ "Solid waste management\r\n"
							+"Liquid waste management\r\n"
							+" Biomedical waste management\r\n"
							+" E-waste management\r\n"
							+ "Waste recycling system\r\n" + "Hazardous chemicals and radioactive waste management\r\n"
							+ "Response:"
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse713()
									: ""),
					font4));
			cell713criteria7.setExtraParagraphSpace(10f);

			table713criteria7.addCell(cell713criteria7);
			table713criteria7.setSpacingBefore(20f);
			table713criteria7.setSpacingAfter(20f);



			PdfPCell cell713c8riteria7 = new PdfPCell(new Paragraph("Solid waste management\r\n" + "Liquid waste management\r\n"
					+ "Biomedical waste management\r\n" + "E-waste management\r\n" + "Waste recycling system\r\n"
					+ "Hazardous chemicals and radioactive waste management\r\n" + "Response: "
					
					+ (criteria7Record != null ? criteria7Record.getCriteria71Qn().get(0).getResponse713()
							: ""),
					font4));
			cell713c8riteria7.setExtraParagraphSpace(10f);
			table713criteria7.addCell(cell713c8riteria7);
	
			document.add(table713criteria7);
			
			
			
			// 7.1.4

			// creating table
			PdfPTable table2criteria7 = new PdfPTable(2);
			table2criteria7.setWidthPercentage(100);

			com.lowagie.text.Font font11 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font11.setColor(CMYKColor.BLACK);
			// Create table for header pdfcell cell= new pdf cell
			PdfPCell cell51criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
			cell51criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell52criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell52criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell0 = new PdfPCell();
			cell0.setPadding(5);
			PdfPCell cell53criteria7 = new PdfPCell(new Paragraph(
					"Relevant documents like agreements/MoUs with\r\n" + "Government and other approved agencies\r\n\r\n\r\n",font5));
			cell53criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell54criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell54criteria7.setExtraParagraphSpace(10f);
			cell54criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell55criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n\r\n ",font5));
			cell55criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell56criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell56criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell56criteria7.setExtraParagraphSpace(10f);
			
			PdfPCell cell57criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of the facilities\r\n\r\n\r\n",font5));
			cell57criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell58criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell58criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			cell58criteria7.setExtraParagraphSpace(10f);
			PdfPCell cell59criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n",font5));
			cell59criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell60criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell60criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			cell60criteria7.setExtraParagraphSpace(10f);
			table2criteria7.addCell(cell51criteria7);
			table2criteria7.addCell(cell52criteria7);
			table2criteria7.addCell(cell53criteria7);
			table2criteria7.addCell(cell54criteria7);
			table2criteria7.addCell(cell55criteria7);
			table2criteria7.addCell(cell56criteria7);
			table2criteria7.addCell(cell57criteria7);
			table2criteria7.addCell(cell58criteria7);
			table2criteria7.addCell(cell59criteria7);
			table2criteria7.addCell(cell60criteria7);
			table2criteria7.setSpacingBefore(20f);
			table2criteria7.setSpacingAfter(20f);

			document.add(table2criteria7);

			paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			

			PdfPTable table3criteria7 = new PdfPTable(2);
			PdfPTable table3criteria71 = new PdfPTable(1);
			table3criteria7.setWidthPercentage(100f);
			table3criteria71.setWidthPercentage(100f);

			
			PdfPCell cell61criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
			cell61criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell62criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell62criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell63criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n\r\n\r\n",font5));
			cell63criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell64criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell64criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell64criteria7.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell65criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n",font5));
			cell65criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			PdfPCell cell66criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell66criteria7.setExtraParagraphSpace(10f);
			cell66criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table3criteria7.addCell(cell61criteria7);
			table3criteria7.addCell(cell62criteria7);
			table3criteria7.addCell(cell63criteria7);
			table3criteria7.addCell(cell64criteria7);
			table3criteria7.addCell(cell65criteria7);
			table3criteria7.addCell(cell66criteria7);

			PdfPCell cell072 = new PdfPCell(
					new Paragraph("7.1.4	Water conservation facilities available in the Institution:\r\n" + "\r\n"
							+ "1.	Rain water harvesting\r\n" + "2.	Borewell /Open well recharge\r\n"
							+ "3.	Construction of tanks and bunds\r\n" + "4.	Waste water recycling\r\n"
							+ "5.	Maintenance of water bodies and distribution system in the campus\r\n" + "Response:"+
							 (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse714()
									: ""),
							font4));
			cell072.setExtraParagraphSpace(10f);
			table3criteria71.addCell(cell072);




			document.add(table3criteria71);
			
			table3criteria7.setSpacingBefore(20f);
			table3criteria7.setSpacingAfter(20f);

			
			document.add(table3criteria7);

			

			// 7.15 table
			PdfPTable table6criteria7 = new PdfPTable(2);
			PdfPTable table6criteria72 = new PdfPTable(1);

			table6criteria7.setWidthPercentage(100f);
			table6criteria72.setWidthPercentage(100f);

			
			PdfPCell cell67criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
			cell67criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell68criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell68criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell69criteria7 = new PdfPCell(
					new Paragraph("Various policy documents / decisions circulated for" + "implementation",font5));
			cell69criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell69criteria7.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell70criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell70criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell70criteria7.setExtraParagraphSpace(10f);
			
			PdfPCell cell71criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n",font5));
			cell71criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell72criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell72criteria7.setExtraParagraphSpace(10f);
			cell72criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			table6criteria7.addCell(cell67criteria7);
			table6criteria7.addCell(cell68criteria7);
			table6criteria7.addCell(cell69criteria7);
			table6criteria7.addCell(cell70criteria7);
			table6criteria7.addCell(cell71criteria7);
			table6criteria7.addCell(cell72criteria7);

			PdfPCell cell073 = new PdfPCell(new Paragraph("7.1.5	Green campus initiatives :\r\n"+
				"Describer the Green campus initiative of the institution including Restricted "+
"entry of automobiles, Use of Bicycles/ Battery powered vehicles , Pedestrian "+
"Friendly pathways , Ban on use of Plastic, landscaping with trees and plants"+
"etc in 500 word"+
					 (criteria7Record != null ? criteria7Record.getCriteria71Qn().get(0).getResponse715()
							: ""),
					font4));
			cell073.setExtraParagraphSpace(10f);

			table6criteria72.addCell(cell073);

		//	table6criteria72.addCell(table6criteria7);



			document.add(table6criteria72);
			
			table6criteria7.setSpacingBefore(20f);
			table6criteria7.setSpacingAfter(20f);	

			document.add(table6criteria7);
			

			PdfPTable table15criteria7 = new PdfPTable(2);
			PdfPTable table15criteria73 = new PdfPTable(1);

			table15criteria7.setWidthPercentage(100f);
			table15criteria73.setWidthPercentage(100f);

			com.lowagie.text.Font font131 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font131.setColor(CMYKColor.BLACK);
			
			PdfPCell cell75criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n",font4));
			cell75criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell76criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n",font4));
			cell76criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell77criteria7 = new PdfPCell(
					new Paragraph("Reports on environment and energy audits\r\n" + "submitted by the auditing agency\r\n\r\n\r\n",font5));
			cell77criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell78criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell78criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell78criteria7.setExtraParagraphSpace(10f);
			
			PdfPCell cell79criteria7 = new PdfPCell(new Paragraph("Certification by the auditing agency\r\n\r\n\r\n",font5));
			cell79criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell80criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(13).getCriteria7FilePath() : ""),font5));
			cell80criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell80criteria7.setExtraParagraphSpace(10f);
			
			
			PdfPCell cell81criteria7 = new PdfPCell(new Paragraph("Certificates of the awards received\r\n\r\n\r\n",font5));
			cell81criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell81criteria7.setExtraParagraphSpace(10f);
			
			PdfPCell cell82criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(14).getCriteria7FilePath() : ""),font5));
			cell82criteria7.setExtraParagraphSpace(10f);
			cell82criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table15criteria7.addCell(cell75criteria7);
			table15criteria7.addCell(cell76criteria7);
			table15criteria7.addCell(cell77criteria7);
			table15criteria7.addCell(cell78criteria7);
			table15criteria7.addCell(cell79criteria7);
			table15criteria7.addCell(cell80criteria7);
			table15criteria7.addCell(cell81criteria7);
			table15criteria7.addCell(cell82criteria7);

			PdfPCell cell074 = new PdfPCell(new Paragraph(
					"7.1.6	Quality audits on environment and energy are regularly undertaken by the \r\n"
					+ "institution \r\n"
							+"7.1.6.1.The institutional environment and energy initiatives are confirmed through the following\r\n"
						 + "1.	Green audit\r\n" + "2.	Energy audit\r\n" 
							+ "3.	Clean and green campus recognitions / awards\r\n"
							+ "4.	Beyond the campus environmental promotion activities"  + "Response:"+
							 (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse716()
									: ""),
					font4));
			cell074.setExtraParagraphSpace(10f);

			table15criteria73.addCell(cell074);

			
		

			document.add(table15criteria73);
			
			table15criteria7.setSpacingBefore(20f);
			table15criteria7.setSpacingAfter(20f);
			
			document.add(table15criteria7);
			

			
			// 7.1.7 table
			PdfPTable table17criteria7 = new PdfPTable(2);
			PdfPTable table17criteria73 = new PdfPTable(1);

			table17criteria7.setWidthPercentage(100f);
			table17criteria73.setWidthPercentage(100f);
			com.lowagie.text.Font font132 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font132.setColor(CMYKColor.BLACK);
			PdfPCell cell85criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n",font4));
			cell85criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell86criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n",font4));
			cell86criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell87criteria7 = new PdfPCell(
					new Paragraph("Policy documents and information brochures on the\r\n" + "support to be provided",font5));
			cell87criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell87criteria7.setExtraParagraphSpace(10f);
		
			PdfPCell cell88criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(15).getCriteria7FilePath() : "")));
			cell88criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell88criteria7.setExtraParagraphSpace(10f);
			
			PdfPCell cell89criteria7 = new PdfPCell(new Paragraph("Geotagged photographs / videos of the facilities\r\n"));
			cell89criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell89criteria7.setExtraParagraphSpace(10f);
			PdfPCell cell90criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(16).getCriteria7FilePath() : "")));
			cell90criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);

			cell90criteria7.setExtraParagraphSpace(10f);
			PdfPCell cell91criteria7 = new PdfPCell(
					new Paragraph("Details of the Software procured for providing the" + "assistance\r\n"));
			cell91criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell91criteria7.setExtraParagraphSpace(10f);
			PdfPCell cell92criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(17).getCriteria7FilePath() : "")));
			cell92criteria7.setExtraParagraphSpace(10f);
			cell92criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table17criteria7.addCell(cell85criteria7);
			table17criteria7.addCell(cell86criteria7);
			table17criteria7.addCell(cell87criteria7);
			table17criteria7.addCell(cell88criteria7);
			table17criteria7.addCell(cell89criteria7);
			table17criteria7.addCell(cell90criteria7);
			table17criteria7.addCell(cell91criteria7);
			table17criteria7.addCell(cell92criteria7);

			PdfPCell cell075 = new PdfPCell(
					new Paragraph("7.1.7	The Institution has friendly, barrier free environment\r\n"
							+"Write description covering the various components of barrier free \r\n"
							+ "environment in your institution within 500 words"
							+ "1.	Built environment with ramps/lifts for easy access to classrooms.\r\n"
							+ "2.	Divyangjan friendly washrooms\r\n"
							+ "3.	Signage including tactile path, lights, display boards and signposts\r\n"
							+ "4.	Assistive technology and facilities for Divyangjan accessible website, screen-reading software, mechanized equipment\r\n"
							+ "5.	Provision for enquiry and information : Human assistance, reader, scribe, soft copies of reading material, screen reading, font enlargement etc.,\r\n"
							+ "Response:"+
							 (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse717()
									: ""),
							font4));
			cell075.setExtraParagraphSpace(10f);

			table17criteria73.addCell(cell075);



			



			

			table17criteria7.setSpacingBefore(20f);
			table17criteria7.setSpacingAfter(20f);
			
			document.add(table17criteria7);

			// 7.1.8
			/*
			 * Font fontParagraph2142 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph2142.setSize(12);
			 * 
			 * 
			 */
			
			
			
			PdfPCell cell07511 = new PdfPCell( new Paragraph(
					"7.1.8 Describe the Institutional efforts/initiatives in providing an inclusive environment i.e., tolerance\r\n"
							+ "and harmony towards cultural, regional, linguistic, communal socioeconomic and other diversities"
							+ "(within 500 words)." + "Response: "+
							(criteria7Record != null
									? criteria7Record.getCriteria71Ql().get(0).getResponse718()
									: ""),
					font4));
			cell07511.setExtraParagraphSpace(10);
		//	table17criteria73.addCell(cell07511);
			
			
			
			document.add(table17criteria73);

			PdfPTable table718criteria7 = new PdfPTable(1);
			table718criteria7.setWidthPercentage(100f);

			/*
			 * com.lowagie.text.Font fontcriteria7 =
			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontcriteria7.setColor(CMYKColor.BLACK);
			 */

			PdfPCell cell718criteria7 = new PdfPCell(new Paragraph(
					"7.1.8 Describe the Institutional efforts/initiatives in providing an inclusive environment i.e., tolerance and harmony towards cultural, regional, linguistic, communal socioeconomic and other diversities (within 500 words)."
							+ "Response:"+
							 (criteria7Record != null
									? criteria7Record.getCriteria71Ql().get(0).getResponse718()
									: ""),
					font4));
			cell718criteria7.setExtraParagraphSpace(10);

			table718criteria7.addCell(cell718criteria7);
			table718criteria7.setSpacingBefore(20f);
			table718criteria7.setSpacingAfter(20f);

			document.add(table718criteria7);

			

			// 7.1.8 table

			PdfPTable table18criteria7 = new PdfPTable(2);
			table18criteria7.setWidthPercentage(100f);
			com.lowagie.text.Font font133 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font133.setColor(CMYKColor.BLACK);
			PdfPCell cell95criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell95criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell96criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell96criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell97criteria7 = new PdfPCell(
					new Paragraph("Policy documents and information brochures on the\r\n" + "support to be provided"));
			cell97criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell98criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(18).getCriteria7FilePath() : "")));
			cell98criteria7.setExtraParagraphSpace(10);
			cell98criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table18criteria7.addCell(cell95criteria7);
			table18criteria7.addCell(cell96criteria7);
			table18criteria7.addCell(cell97criteria7);
			table18criteria7.addCell(cell98criteria7);
			table18criteria7.setSpacingBefore(20f);
			table18criteria7.setSpacingAfter(20f);

			document.add(table18criteria7);

			PdfPTable table18criteria1117 = new PdfPTable(1);
			table18criteria1117.setWidthPercentage(100f);
			
			PdfPCell cell98criteri111a7 = new PdfPCell( new Paragraph(
					"7.1.9 Sensitization of students and employees of the Institution to the constitutional obligations:"
							+ "values, rights, duties and responsibilities of citizens (within 500 words)."
							+ "Response: "
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Ql().get(0).getResponse719()
									: ""),
					font4));
			
			cell98criteri111a7.setExtraParagraphSpace(10);
			
		//	table18criteria1117.addCell(cell98criteri111a7);
	//		document.add(table18criteria1117);
			

	

			PdfPTable table719criteria7 = new PdfPTable(1);
			table719criteria7.setWidthPercentage(100f);

			
			PdfPCell cell719criteria7 = new PdfPCell(new Paragraph(
					"7.1.9 Sensitization of students and employees of the Institution to the constitutional obligations: values, rights, duties and responsibilities of citizens (within 500 words).\r\n"
							+ "\r\n" + "Response:"
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Ql().get(0).getInput719t1()
									: ""),
					font4));
			
			cell719criteria7.setExtraParagraphSpace(10);

			table719criteria7.addCell(cell719criteria7);
			table719criteria7.setSpacingBefore(20f);
			table719criteria7.setSpacingAfter(20f);

			document.add(table719criteria7);

		
			
			
			// 7.1.1.9 table
			PdfPTable table19criteria7 = new PdfPTable(2);
			table19criteria7.setWidthPercentage(100f);
			com.lowagie.text.Font font134 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font134.setColor(CMYKColor.BLACK);
			PdfPCell cell105criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
			cell105criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell106criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell106criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell107criteria7 = new PdfPCell(new Paragraph(" Details of activities that inculcate values;\r\n"
					+ "necessary to render students in to responsible\r\n" + "citizens\r\n\r\n",font5));
			cell107criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell108criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(19).getCriteria7FilePath() : ""),font5));
			cell108criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell108criteria7.setExtraParagraphSpace(10);
			
			
			PdfPCell cell109criteria7 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n",font5));
			cell109criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell110criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(20).getCriteria7FilePath() : ""),font5));
			cell110criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell110criteria7.setExtraParagraphSpace(10);
			
			table19criteria7.addCell(cell105criteria7);
			table19criteria7.addCell(cell106criteria7);
			table19criteria7.addCell(cell107criteria7);
			table19criteria7.addCell(cell107criteria7);
			table19criteria7.addCell(cell108criteria7);
			table19criteria7.addCell(cell109criteria7);
			table19criteria7.addCell(cell110criteria7);
			table19criteria7.setSpacingBefore(20f);
			table19criteria7.setSpacingAfter(20f);
			document.add(table19criteria7);

			
			// 7.1.10 table

			PdfPTable table31criteria7 = new PdfPTable(2);
			PdfPTable table31criteria74 = new PdfPTable(1);

			table31criteria7.setWidthPercentage(100);
			table31criteria74.setWidthPercentage(100);

			com.lowagie.text.Font font112 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font112.setColor(CMYKColor.BLACK);
			PdfPCell cell1111 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n",font4));
			cell1111.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1112 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n",font4));
			cell1112.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell11113 = new PdfPCell(new Paragraph(
			
					" Details of the monitoring committee composition and minutes of the committee meeting, number of\r\n"

							+ "programmes organized, reports on the various\r\n"
							+ "programs etc., in support of the claims\r\n\r\n\r\n",font5));
			cell11113.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell11114 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(21).getCriteria7FilePath() : ""),font5));
			cell11114.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell11114.setExtraParagraphSpace(10f);
			
			PdfPCell cell1115 = new PdfPCell(new Paragraph("Code of ethics policy document\r\n\r\n\r\n",font5));
			cell1115.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1116 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(22).getCriteria7FilePath() : ""),font5));
			cell1116.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1116.setExtraParagraphSpace(10);
			cell1116.setExtraParagraphSpace(10f);
			
			PdfPCell cell11117 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n\r\n",font5));
			cell11117.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1118 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(23).getCriteria7FilePath() : ""),font5));
			cell1118.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1118.setExtraParagraphSpace(10f);
			cell1118.setExtraParagraphSpace(10);
			
			
			table31criteria7.addCell(cell1111);// 7.1.10 table
			table31criteria7.addCell(cell1112);
			table31criteria7.addCell(cell11113);
			table31criteria7.addCell(cell11114);
			table31criteria7.addCell(cell1115);
			table31criteria7.addCell(cell1116);
			table31criteria7.addCell(cell11117);
			table31criteria7.addCell(cell1118);

			PdfPCell cell076 = new PdfPCell(new Paragraph(
					"7.1.10 The Institution has a prescribed code of conduct for students, teachers, \r\n"
					+ "administrators and other staff and conducts periodic programmes in this \r\n"
					+ "regard.\r\n"
							+ "1. The institutional Code of Conduct principles are displayed on the website \r\n"
							+ "2.	There is a committee to monitor adherence to the Code of Conduct\r\n"
							+ "3.	Institution organizes professional ethics programmes for students, teachers, administrators and other staff\r\n"
							+ "4.	Annual awareness programmes on Code of Conduct are organized\r\n" 
							+ "Response:\r\n"+
						 (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse7110()
									: ""),
					font4));
			cell076.setExtraParagraphSpace(10f);

			table31criteria74.addCell(cell076);

	//		table31criteria74.addCell(table31criteria7);

	

			document.add(table31criteria74);
			
			
			table31criteria7.setSpacingBefore(20f);
			table31criteria7.setSpacingAfter(20f);
			
			document.add(table31criteria7);
			
			
			PdfPTable table31criteria0074 = new PdfPTable(1);

			table31criteria0074.setWidthPercentage(100);
			
			
			
			PdfPCell cell0716 = new PdfPCell(new Paragraph(
					"7.1.11 Institution celebrates / organizes national and international commemorative days, events and\r\n"
							+ "festivals (within 500 words)"  + "Response: "+
							(criteria7Record != null
									? criteria7Record.getCriteria71Ql().get(0).getResponse7111()
									: ""),
					font4));
			cell0716.setExtraParagraphSpace(10f);
			//
			table31criteria0074.addCell(cell0716);
			
		//	document.add(table31criteria0074);
			
			
			

			PdfPTable table7111criteria7 = new PdfPTable(1);
			table7111criteria7.setWidthPercentage(100f);

			PdfPCell cell7111criteria7 = new PdfPCell(new Paragraph(
					"7.1.11 Institution celebrates / organizes national and international commemorative days, events and festivals (within 500 words).\r\n"
							+ "\r\n" + "Response:"+
							 (criteria7Record != null
									? criteria7Record.getCriteria71Ql().get(0).getResponse7111()
									: ""),
					font4));
			cell7111criteria7.setExtraParagraphSpace(10);
			table7111criteria7.addCell(cell7111criteria7);
//			table7111criteria7.setSpacingBefore(20f);
//			table7111criteria7.setSpacingAfter(20f);

			document.add(table7111criteria7);
			

		
			
			// table 4
			PdfPTable table4criteria7 = new PdfPTable(2);
			table4criteria7.setWidthPercentage(100);

			com.lowagie.text.Font font14 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			font14.setColor(CMYKColor.BLACK);
			PdfPCell cell1119criteria7 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font4));
			cell1119criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1120criteria7 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font4));
			cell1120criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1121criteria7 = new PdfPCell(new Paragraph("Geotagged photographs of some of the events\r\n", font5));
			cell1121criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1122criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(24).getCriteria7FilePath() : ""), font5));
			cell1122criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1122criteria7.setExtraParagraphSpace(10);
			
			PdfPCell cell1123criteria7 = new PdfPCell(new Paragraph(
					"Annual report of the celebrations and\r\n" + "commemorative events for the last five years\r\n", font5));
			cell1123criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1124criteria7 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(25).getCriteria7FilePath() : ""), font5));
			cell1124criteria7.setExtraParagraphSpace(10);
			cell1124criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table4criteria7.addCell(cell1119criteria7);
			table4criteria7.addCell(cell1120criteria7);
			table4criteria7.addCell(cell1121criteria7);
			table4criteria7.addCell(cell1122criteria7);
			table4criteria7.addCell(cell1123criteria7);
			table4criteria7.addCell(cell1124criteria7);

			table4criteria7.setSpacingBefore(20f);
			table4criteria7.setSpacingAfter(20f);

			document.add(table4criteria7);
			
			// 7.2 
			Paragraph paragraph46criteria7 = new Paragraph("7.2 Best Practices\r\n", font2);
			paragraph46criteria7.setSpacingBefore(3f);
			paragraph46criteria7.setSpacingAfter(4f);
			document.add(paragraph46criteria7);
			
			
			
			

			PdfPTable table721criteria7 = new PdfPTable(1);
			table721criteria7.setWidthPercentage(100f);

			

			PdfPCell cell1123criteria71 = new PdfPCell(new Paragraph(
					"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format provided in the Manual.\r\n"
						 + "Response:",font4));
			
			cell1123criteria71.setExtraParagraphSpace(5F);
			table721criteria7.addCell(cell1123criteria71);
			
			
			
			
			if(criteria7Record.getCriteria72Ql() !=null)
			{
				PdfPCell cell1123criteria7199 = new PdfPCell( new Paragraph(criteria7Record != null
									? criteria7Record.getCriteria72Ql().get(0).getResponse721()
									: "",font4));
				
				cell1123criteria7199.setExtraParagraphSpace(10);
	   
				table721criteria7.addCell(cell1123criteria7199);	
			}
			
			document.add(table721criteria7);
			

			PdfPTable table5criteria7 = new PdfPTable(2);
			table5criteria7.setWidthPercentage(100);

			PdfPCell cell1110 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
			cell1110.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1134 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
			cell1134.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			PdfPCell cell1135 = new PdfPCell(new Paragraph("Best practices in the Institutional web site\r\n\r\n ",font5));
			cell1135.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1136 = new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
			cell1136.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1137 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n ",font5));
			cell1137.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell1138= new PdfPCell(
					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
			
			cell1138.setExtraParagraphSpace(10);
			cell1138.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table5criteria7.addCell(cell1110);
			table5criteria7.addCell(cell1134);
			 table5criteria7.addCell(cell1135);
			 table5criteria7.addCell(cell1136);
			 table5criteria7.addCell(cell1137);
			 table5criteria7.addCell(cell1138);

			
			table5criteria7.setSpacingBefore(20f);
			table5criteria7.setSpacingAfter(20f);

			document.add(table5criteria7);
			
			// 7.3
//			Paragraph paragraph88 = new Paragraph("7.3 Institutional Distinctiveness\r\n", font2);
//			document.add(paragraph88);
//			
//
//			PdfPTable table5criteria117 = new PdfPTable(1);
//			table5criteria117.setWidthPercentage(100);
//			
//			PdfPCell cell113511 = new PdfPCell(new Paragraph(new Paragraph(
//					"7.3.1 Portray the performance of the Institution in one area distinctive to its priority and thrust\r\n"
//							+ "within 1000 words\r\n"  + "Response: " ,font4)));
//			cell113511.setExtraParagraphSpace(10);
//			
//			table5criteria117.addCell(cell113511);
//			
//			
//			
//			if(criteria7Record.getCriteria73Ql() !=null)
//			{
//				PdfPCell cell11351111 = new PdfPCell(new Paragraph( (criteria7Record != null
//									? criteria7Record.getCriteria73Ql().get(0).getResponse731()
//									: ""),font4));
//				cell11351111.setExtraParagraphSpace(10);	
//				
//				table5criteria117.addCell(cell11351111);
//			}
//
//document.add(table5criteria117);
//			
//			
//			
//			PdfPTable table05criteria7 = new PdfPTable(2);
//			table05criteria7.setWidthPercentage(100);
//
//			PdfPCell cell110 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
//			cell110.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell134 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
//			cell134.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell135 = new PdfPCell(new Paragraph("Appropriate web in the Institutional website\r\n\r\n ",font5));
//			cell135.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			PdfPCell cell136 = new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : ""),font5));
//			cell136.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell136.setExtraParagraphSpace(10);	
//			
//			
//			PdfPCell cell137 = new PdfPCell(new Paragraph("Any other relevant information\r\n\r\n ",font5));
//			cell137.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			
//			PdfPCell cell138= new PdfPCell(
//					new Paragraph((criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : ""),font5));
//			cell138.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell138.setExtraParagraphSpace(10);	
//			
//			table05criteria7.addCell(cell110);
//			table05criteria7.addCell(cell134);
//			 table05criteria7.addCell(cell135);
//			 table05criteria7.addCell(cell136);
//			 table05criteria7.addCell(cell137);
//			 table05criteria7.addCell(cell138);
//
//			
//			table05criteria7.setSpacingBefore(20f);
//			table05criteria7.setSpacingAfter(20f);
//
//			document.add(table05criteria7);
//			
			
		 
			
			document.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
