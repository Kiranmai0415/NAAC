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
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class Criteria7AffilatedReport {

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
				reportPath = "Criteria7AffilatedReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());

			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));

			document.open();
			System.out.println("open the document==========>");

			// 7.1
			
			
			Paragraph paragraphcriteria7 = new Paragraph("Criterion 7 - Institutional Values and Best Practices\r\n\r\n",
					font1);
			paragraphcriteria7.setAlignment(Paragraph.ALIGN_CENTER);
			PdfPCell cell5criteria7 = new PdfPCell();
			cell5criteria7.setPadding(5);
			document.add(cell5criteria7);

		
			document.add(paragraphcriteria7);
			Paragraph paragraph2criteria7 = new Paragraph("7.1 Institutional Values and Social Responsibilities\r\n", font2);
			paragraph2criteria7.setAlignment(Paragraph.ALIGN_JUSTIFIED);
	       document.add(paragraph2criteria7);
			
			

			PdfPTable table711criteria7 = new PdfPTable(1);
			table711criteria7.setWidthPercentage(100f);


			PdfPCell cell711criteria7 = new PdfPCell(new Paragraph(
					"7.1.1	Measures initiated by the Institution for the promotion of gender equity and Institutional initiatives to celebrate / organize national and international commemorative days, events and festivals during the last five years (Within 500 words)\r\n\r\n"
					+ ""
						 + "Response: "
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Ql().get(0).getResponse711()
									: "")+"\r\n\r\n",
					font4));
			
			

//			PdfPCell cell7110criteria7 = new PdfPCell(new Paragraph(
//				(criteria7Record != null
//									? criteria7Record.getCriteria71Ql().get(0).getInput711t1()
//									: ""),
//					font5));
			
			
			
			

			table711criteria7.addCell(cell711criteria7);
	//		table711criteria7.addCell(cell7110criteria7);
			table711criteria7.setSpacingBefore(20f);
			table711criteria7.setSpacingAfter(20f);
	        document.add(table711criteria7);

			// paragaph3
			//document.add(paragraph3criteria7);
			

			

			

			
			PdfPTable tablecriteria7 = new PdfPTable(2);
			tablecriteria7.setWidthPercentage(100f);
			PdfPTable tablecriteria07 = new PdfPTable(1);
			tablecriteria07.setWidthPercentage(100f);

		

			PdfPCell cell111criteria7 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell111criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell112criteria7 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell112criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1113criteria7 = new PdfPCell(new Paragraph("\r\nLink for specific facilities provided for women interms of: a. Safety and security b. Counselling c.Common Rooms d. Day care center for youngchildren e. Any other relevant information\r\n\r\n",font5));
			cell1113criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1114criteria7 = new PdfPCell(
					new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
			cell1114criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell115criteria7 = new PdfPCell(new Paragraph("\r\nLink for annual gender sensitization action plan\r\n\r\n",font5));
			cell115criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell116criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(1).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
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

			

			PdfPCell cell4criteria7 = new PdfPCell();

			//cell1criteria7.setPadding(5);
			document.add(cell4criteria7);

			// table1
			PdfPTable table1criteria7 = new PdfPTable(2);
			PdfPTable table1criteria71 = new PdfPTable(1);

			table1criteria7.setWidthPercentage(100f);
			table1criteria71.setWidthPercentage(100f);

		

			PdfPCell cell113criteria7 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell113criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell114criteria7 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell114criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11104criteria7 = new PdfPCell(new Paragraph("\r\nGeotagged Photographs\r\n\r\n",font5));
			cell11104criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1117criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
			cell1117criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1190criteria7 = new PdfPCell(new Paragraph("\r\nAny other relevant information\r\n\r\n",font5));
			cell1190criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1191criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
			cell1191criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table1criteria7.addCell(cell113criteria7);
			table1criteria7.addCell(cell114criteria7);
			// table1.addCell(cell1113);
			table1criteria7.addCell(cell11104criteria7);
			table1criteria7.addCell(cell1117criteria7);
			table1criteria7.addCell(cell1190criteria7);
			table1criteria7.addCell(cell1191criteria7);
			table1criteria7.setSpacingAfter(20);
			table1criteria7.setSpacingBefore(20);
			
		

			PdfPCell cell071 = new PdfPCell(new Paragraph(
					"7.1.2	The Institution has facilities for alternate sources of energy and energy conservation measures\r\n"
							+ "\r\n"
							+ "1.	Alternate sources of energy and energy conservation measures \r\n"
							+"2.	Management of the various types of degradable and nondegradable waste\r\n"
							+"3.	Water conservation\r\n"
							+ "4.	Green campus initiatives\r\n"
							+ "5.	Disabled-friendly, barrier free environment\r\n" + "\r\n" + "Response: "
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse712()
									: "")+"\r\n\r\n",
					font4));
//			PdfPCell cell0710 = new PdfPCell(new Paragraph(
//					 (criteria7Record != null
//									? criteria7Record.getCriteria71Qn().get(0).getInput712t1()
//									: ""),
//					font5));
			

			table1criteria71.addCell(cell071);
	//		table1criteria71.addCell(cell0710);
	//		table1criteria71.addCell(table1criteria7);

			table1criteria71.setSpacingBefore(20f);
			table1criteria71.setSpacingAfter(20f);

			document.add(table1criteria71);
			document.add(table1criteria7);
			

			PdfPCell cell6criteria7 = new PdfPCell();
			cell6criteria7.setPadding(5);
			document.add(cell6criteria7);

			// 7.1.3
			
			PdfPTable table01criteria7 = new PdfPTable(2);
			table01criteria7.setWidthPercentage(100f);

			PdfPCell cell21criteria7 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n\r\n", font4));
			cell21criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell22criteria7 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell22criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell23criteria7 = new PdfPCell(new Paragraph("\r\nReports on environment and energy audits submitted by the auditing agency\r\n\r\n",font5));
			cell23criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell24criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
			cell24criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell25criteria7 = new PdfPCell(new Paragraph("\r\nCertification by the auditing agency	\r\n\r\n",font5));
			cell25criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell26criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
			cell26criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell27criteria7 = new PdfPCell(new Paragraph("\r\nCertificates of the awards received	\r\n\r\n",font5));
			cell27criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell28criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
			cell28criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell cell29criteria7 = new PdfPCell(new Paragraph("\r\nAny other relevant information	\r\n\r\n",font5));
			cell29criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell30criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
			cell30criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			
			table01criteria7.addCell(cell21criteria7);
			table01criteria7.addCell(cell22criteria7);
			table01criteria7.addCell(cell23criteria7);
			table01criteria7.addCell(cell24criteria7);
			table01criteria7.addCell(cell25criteria7);
			table01criteria7.addCell(cell26criteria7);
			table01criteria7.addCell(cell27criteria7);
			table01criteria7.addCell(cell28criteria7);
			table01criteria7.addCell(cell29criteria7);
			table01criteria7.addCell(cell30criteria7);
			
			
//			Paragraph paragraph16criteria7 = new Paragraph(
//					"7.1.3 Describe the facilities in the Institution for the management of the following types of\r\n"
//							+ "degradable and non-degradable waste (within 500 words)\r\n",
//					font3);
//			document.add(paragraph16criteria7);

			PdfPCell cell10 = new PdfPCell();
			cell10.setPadding(10);

			PdfPTable table713criteria7 = new PdfPTable(1);
			table713criteria7.setWidthPercentage(100f);

			
			PdfPCell cell713criteria7 = new PdfPCell(new Paragraph(
					"7.1.3Quality audits on environment and energy regularly undertaken by the Institution.The institutional environment and energy initiatives are confirmed\r\n"
							+ "\r\n"
							+ "1. Green audit / Environment audit"
							+" 2. Energy audit"
							+" 3. Clean and green campus initiatives"
							+" 4. Beyond the campus environmental promotion and sustainability activities\r\n"
							
							+ "Response: "
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse713()
									: "")+"\r\n\r\n",
					font4));

//			PdfPCell cell7130criteria7 = new PdfPCell(new Paragraph(
//					(criteria7Record != null
//									? criteria7Record.getCriteria71Qn().get(0).getInput713t1()
//									: ""),
//					font5));
			
			
			table713criteria7.addCell(cell713criteria7);
		//	table713criteria7.addCell(cell7130criteria7);
			table713criteria7.setSpacingBefore(20f);
			table713criteria7.setSpacingAfter(20f);

			document.add(table713criteria7);
			table01criteria7.setSpacingAfter(20);
			table01criteria7.setSpacingBefore(20);
			document.add(table01criteria7);

			///////////

			PdfPTable table3criteria7 = new PdfPTable(2);
			PdfPTable table3criteria71 = new PdfPTable(1);
			table3criteria7.setWidthPercentage(100f);
			table3criteria71.setWidthPercentage(100f);

			
			PdfPCell cell61criteria7 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell61criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell62criteria7 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell62criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell63criteria7 = new PdfPCell(new Paragraph("\r\nSupporting documents on the information provided (as reflected in the administrative and academic activities of the Institution)\r\n\r\n",font5));
			cell63criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell64criteria7 = new PdfPCell(
					new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
			cell64criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell65criteria7 = new PdfPCell(new Paragraph("\r\nAny other relevant information\r\n\r\n",font5));
			cell65criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell66criteria7 = new PdfPCell(
					new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
			cell66criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table3criteria7.addCell(cell61criteria7);
			table3criteria7.addCell(cell62criteria7);
			table3criteria7.addCell(cell63criteria7);
			table3criteria7.addCell(cell64criteria7);
			table3criteria7.addCell(cell65criteria7);
			table3criteria7.addCell(cell66criteria7);
			
			

			PdfPCell cell072 = new PdfPCell(
					new Paragraph("7.1.4	Describe the Institutional efforts/initiatives in providing an inclusive environment i.e., tolerance and harmony towards cultural, regional, linguistic, communal socioeconomic diversity and Sensitization of students and employees to the constitutionalobligations: values, rights, duties and responsibilities of citizens(Within 500 words)\r\n\r\n" + "Response: "
							+ (criteria7Record != null
									? criteria7Record.getCriteria71Qn().get(0).getResponse714()
									: "")+"\r\n\r\n",
							font4));

			table3criteria71.addCell(cell072);

		//	table3criteria71.addCell(table3criteria7);

			table3criteria71.setSpacingBefore(20f);
			table3criteria71.setSpacingAfter(20f);

			document.add(table3criteria71);
			table3criteria7.setSpacingAfter(20);
			table3criteria7.setSpacingBefore(20);
			
			document.add(table3criteria7);

			// 7.2
			
			Paragraph paragraph46criteria7 = new Paragraph("7.2 Best Practices\r\n",font2);
			paragraph46criteria7.setAlignment(Element.ALIGN_JUSTIFIED);
			document.add(paragraph46criteria7);

			PdfPTable table721criteria7 = new PdfPTable(1);
			table721criteria7.setWidthPercentage(100f);

			

			PdfPCell cell721criteria7 = new PdfPCell(new Paragraph(
					"7.2.1 Describe two best practices successfully implemented by the Institution as per NAAC format provided in the Manual."
							+ "\r\n\r\n" + "Response: "
							+ (criteria7Record != null
									? criteria7Record.getCriteria72Ql().get(0).getResponse721()
									: "")+"\r\n\r\n",
					font4));
//			PdfPCell cell7210criteria7 = new PdfPCell(new Paragraph(
//					 (criteria7Record != null
//									? criteria7Record.getCriteria72Ql().get(0).getInput721t1()
//									: ""),
//					font5));
			
			

			table721criteria7.addCell(cell721criteria7);
	//		table721criteria7.addCell(cell7210criteria7);
			
			table721criteria7.setSpacingBefore(20);
			table721criteria7.setSpacingAfter(20);
	        document.add(table721criteria7);

			
			// table5
			PdfPTable table5criteria7 = new PdfPTable(2);
			table5criteria7.setWidthPercentage(100);

			PdfPCell cell1110 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n",font4));
			cell1110.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1134 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n",font4));
			cell1134.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1135 = new PdfPCell(new Paragraph("\r\nBest practices in the Institutional web site\r\n\r\n",font5));
			cell1135.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1136 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
			cell1136.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1137 = new PdfPCell(new Paragraph("\r\nAny other relevant information\r\n\r\n",font5));
			cell1137.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1138 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(0).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
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
			
//			// 7.3 
//			Paragraph paragraph88 = new Paragraph("7.3 Institutional Distinctiveness \r\n", font2);
//			paragraph88.setAlignment(Element.ALIGN_JUSTIFIED);
//			document.add(paragraph88);
//
//		
//
//			PdfPTable table731criteria7 = new PdfPTable(1);
//			table731criteria7.setWidthPercentage(100f);
//
//			
//
//			PdfPCell cell731criteria7 = new PdfPCell(new Paragraph(
//					"7.3.1 Portray the performance of the Institution in one area distinctive to its priority and thrust within 1000 words\r\n"
//							+ "\r\n" + "Response: "
//							+ (criteria7Record != null
//									? criteria7Record.getCriteria73Ql().get(0).getResponse731()
//									: "")+"\r\n\r\n",
//					font4));
//			
//			
////			PdfPCell cell7310criteria7 = new PdfPCell(new Paragraph(
////					 (criteria7Record != null
////									? criteria7Record.getCriteria73Ql().get(0).getInput731t1()
////									: ""),
////					font5));
//			
//			
//			
//
//			table731criteria7.addCell(cell731criteria7);
//		//	table731criteria7.addCell(cell7310criteria7);
//			table731criteria7.setSpacingBefore(20);
//			table731criteria7.setSpacingAfter(20);
//	        document.add(table731criteria7);
//
//		
//
//			PdfPTable table7criteria7 = new PdfPTable(2);
//			table7criteria7.setWidthPercentage(100);
//
//			PdfPTable table70criteria7 = new PdfPTable(2);
//			table70criteria7.setWidthPercentage(100);
//
//			
//			PdfPCell cell202criteria7 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n",font4));
//			cell202criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell203criteria7 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n",font4));
//			cell203criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell204criteria7 = new PdfPCell(new Paragraph("\r\nAppropriate web in the Institutional website\r\n\r\n",font5));
//			cell204criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell205criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(3).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
//			cell205criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell206criteria7 = new PdfPCell(new Paragraph("\r\nAny other relevant information\r\n\r\n",font5));
//			cell206criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell207criteria7 = new PdfPCell(new Paragraph("\r\n"+(criteria7Record != null ? criteria7file.get(2).getCriteria7FilePath() : "")+"\r\n\r\n",font5));
//			cell207criteria7.setHorizontalAlignment(Element.ALIGN_CENTER);
//			
//			table7criteria7.addCell(cell202criteria7);
//			table7criteria7.addCell(cell203criteria7);
//			table7criteria7.addCell(cell204criteria7);
//			table7criteria7.addCell(cell205criteria7);
//			table7criteria7.addCell(cell206criteria7);
//			table7criteria7.addCell(cell207criteria7);
//			table7criteria7.setSpacingAfter(20);
//			table7criteria7.setSpacingBefore(20);
//			
//			
//			document.add(table7criteria7);
			
			
			document.close();
			
			
		 
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

}
