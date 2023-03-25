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

import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria1_FileUpload;
import com.adiverse.erp.service.Criteria1Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.Cell;
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

@Service
public class Criteria1AffilatedReport 
{
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	
	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	@Autowired
	Criteria1Service service1;
	
	List<Criteria1_FieldInfo> criteria1List = null;
	Criteria1_FieldInfo criteria1Record = null;
	List<Criteria1_FileUpload> criteria1file = null;
	
	
	public String generateReport(Map<String, String> allParams ) throws DocumentException, IOException {
		System.out.println("generateReport");
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
//			allParams.put("collegeId", criteria1Fieldinfo.getCriteriaId().getCollegeId());
//			allParams.put("financialYear",criteria1Fieldinfo.getCriteriaId().getFinancialYear());
//			allParams.put("typeofInstitution", criteria1Fieldinfo.getCriteriaId().getTypeofInstitution());
			
			
try {
			criteria1List = service1.getAllCriteria1Data(allParams);
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("criteria1List"+mapper.writeValueAsString(criteria1List));
}
catch (Exception e) {
	e.printStackTrace();
}
			
			
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
			
          //  1.1
			Paragraph paragraph = new Paragraph("4.Quality Indicator Framework(QIF)\r\n", font1);
			paragraph.setAlignment(Paragraph.ALIGN_CENTER);
			//paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph);

			Paragraph paragraph1 = new Paragraph("Criterion 1 - Curricular Aspects\r\n\r\n", font1);
			paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
			Paragraph paragraphlinecriteria1 = new Paragraph(
					"____________________________________________________________________________\r\n");
			document.add(paragraphlinecriteria1);
		//	paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph1);
			Paragraph paragraph2 = new Paragraph("1.1  Curricular Planning and Implementation\r\n", font2);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph2);
			PdfPTable table111criteria1 = new PdfPTable(1);

			table111criteria1.setWidthPercentage(100);
			PdfPCell cell111criteria1 = new PdfPCell(new Paragraph(
					"1.1.1: The Institution ensures effective curriculum planning and delivery through a well-planned and documented process including Academic calendar and conduct of continuous internal Assessment\r\n\r\n"
							+ "Response: " 
							+ (criteria1Record != null
									? criteria1Record.getCriteria11Ql().get(0).getResponse111()
									:" ")+"\r\n\r\n",font4));

			table111criteria1.addCell(cell111criteria1);

			table111criteria1.setSpacingBefore(20);
			table111criteria1.setSpacingAfter(20);
			document.add(table111criteria1);

			// 112
			PdfPTable table112 = new PdfPTable(2);
			table112.setWidthPercentage(100);
			PdfPTable table1120 = new PdfPTable(1);
			table1120.setWidthPercentage(100);
			PdfPCell cell1121 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell1121.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1122 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell1122.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1123 = new PdfPCell(new Paragraph("\r\nUpload additional information\r\n\r\n",font5));
			cell1123.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1124 = new PdfPCell(
					new Paragraph("\r\n"+(criteria1Record.getCriteria1FileUpload().get(0).getCriteria1FileName())+"\r\n\r\n",font5));
			cell1124.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1125 = new PdfPCell(new Paragraph("\r\nLink for Additional information\r\n\r\n",font5));
			cell1125.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell1126 = new PdfPCell(
					new Paragraph("\r\n"+(criteria1Record.getCriteria1FileUpload().get(0).getCriteria1FileName())+"\r\n\r\n",font5));
			cell1126.setHorizontalAlignment(Element.ALIGN_CENTER);
			table112.addCell(cell1121);
			table112.addCell(cell1122);
			table112.addCell(cell1123);
			table112.addCell(cell1124);
			table112.addCell(cell1125);
			table112.addCell(cell1126);
			table112.setSpacingAfter(20);
			table112.setSpacingBefore(20);
			
			document.add(table112);		
			
			// 1.2
			
		
			Paragraph paragraph02 = new Paragraph("1.2: Academic Flexibility \r\n", font2);
			paragraph2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph02);
			
			PdfPTable table1101criteria1 = new PdfPTable(1);
			table1101criteria1.setWidthPercentage(100);
			
			PdfPCell cell1101criteria1 = new PdfPCell(new Paragraph(
					"1.2.1: Number of Add on /Certificate/Value added programs offered and online MOOC programs like SWAYAM, NPTEL etc. where the students of the institution have benefitted during the last five years)\r\n\r\n"
							+ "Response: "
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getResponse121()
									:" ")+"\r\n\r\n",font4));
			
			
			PdfPCell cell11001criteria1 = new PdfPCell(new Paragraph(
					"1.2.1.1: How many new courses are introduced within the last five years\r\n\r\n"
							
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getInput1211t1()
									: " ")+"\r\n\r\n",font4));
			
			PdfPCell cell110001criteria1 = new PdfPCell(new Paragraph(
					"1.2.1.2: : Number of Add on /Certificate /Value added programs offered during the last five years\r\n\r\n"
						
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getInput1212t1()
									: " ")+"\r\n\r\n",font4));
			
			

			table1101criteria1.addCell(cell1101criteria1);
			table1101criteria1.addCell(cell11001criteria1);
			table1101criteria1.addCell(cell110001criteria1);

			table1101criteria1.setSpacingBefore(20);
			table1101criteria1.setSpacingAfter(20);
			document.add(table1101criteria1);

			// 122
			PdfPTable table1102 = new PdfPTable(2);
			table1102.setWidthPercentage(100);
			
			PdfPCell cell11201 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell11201.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11202 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell11202.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11203 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell11203.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11204 = new PdfPCell(new Paragraph("\r\n"+(criteria1Record.getCriteria1FileUpload().get(0).getCriteria1FileName())+"\r\n\r\n",font5));
			cell11204.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11205 = new PdfPCell(new Paragraph("\r\nLink for Additional information\r\n\r\n",font5));
			cell11205.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11206 = new PdfPCell(new Paragraph("\r\n"+(criteria1Record.getCriteria1FileUpload().get(0).getCriteria1FileName())+"\r\n\r\n",font5));
			cell11206.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1102.addCell(cell11201);
			table1102.addCell(cell11202);
			table1102.addCell(cell11203);
			table1102.addCell(cell11204);
			table1102.addCell(cell11205);
			table1102.addCell(cell11206);
			table1102.setSpacingAfter(20);
			table1102.setSpacingBefore(20);
			document.add(table1102);
			
			PdfPTable table12criteria1 = new PdfPTable(1);
			table12criteria1.setWidthPercentage(100);
			
			PdfPTable table1221criteria1 = new PdfPTable(1);
			table1221criteria1.setWidthPercentage(100);
			
			PdfPCell cell1criteria1 = new PdfPCell(new Paragraph(
					"1.2.2: Percentage of students enrolled in Certificate/ Add-on/Value added programs and also completed online MOOC programs like SWAYAM,	NPTEL etc.as against the total number of students during the last five years\r\n\r\n"
							+ "Response: "
							+ (criteria1Record != null
									? criteria1Record.getCriteria12Qn().get(0).getResponse122()
									: " ")+"\r\n\r\n",font4));
			
			table12criteria1.addCell(cell1criteria1);
			
			PdfPCell cell221criteria1 = new PdfPCell(new Paragraph(
					"1.2.2.1:Number of students enrolled in subject related CertificateAdd-on/Value added programs and also completed online 	MOOC programs like SWAYAM, NPTEL etc. year wise during last five years\r\n\r\n"
							,font4));
			
			
			table1221criteria1.addCell(cell221criteria1);
			table12criteria1.setSpacingAfter(20);
			table12criteria1.setSpacingBefore(20);
//			table12criteria1.setSpacingAfter(20);
//			table12criteria1.setSpacingBefore(20);
			document.add(table12criteria1);
			document.add(table1221criteria1);
			
			
			if(criteria1Record.getAffiliatedYearTable1221().size()>0)
			{
			Table table1221criteria12 = new Table(criteria1Record.getAffiliatedYearTable1221().size());

			table1221criteria12.setPadding(5);
			table1221criteria12.setWidth(100f);

			for (int i = 0; i < criteria1Record.getAffiliatedYearTable1221().size(); i++) {
				Cell cell1criteria1221 = new Cell (criteria1Record.getAffiliatedYearTable1221().get(i).getInput1221y());
				cell1criteria1221.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1221criteria12.addCell(cell1criteria1221);
				
			}
			for (int i = 0; i < criteria1Record.getAffiliatedYearTable1221().size(); i++) {
				Cell cell2criteria1221 = new Cell (criteria1Record.getAffiliatedYearTable1221().get(i).getInput1221v());
				cell2criteria1221.setHorizontalAlignment(Element.ALIGN_CENTER);
				table1221criteria12.addCell(cell2criteria1221);
				
			}

			document.add(table1221criteria12);
		

			
			}
			
			
			
			
			
			PdfPTable table2 = new PdfPTable(2);
			table2.setWidthPercentage(100);
			
			PdfPCell cell10 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell11 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell12 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format\r\n\r\n",font5));
			cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell13 = new PdfPCell(new Paragraph("\r\n"+(criteria1Record.getCriteria1FileUpload().get(0).getCriteria1FileName())+"\r\n\r\n",font5));
			cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell14 = new PdfPCell(new Paragraph("\r\nUpload supported document\r\n\r\n",font5));
			cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell15 = new PdfPCell(new Paragraph("\r\n"+(criteria1Record.getCriteria1FileUpload().get(0).getCriteria1FileName())+"\r\n\r\n",font5));
			cell15.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(cell10);
			table2.addCell(cell11);
			table2.addCell(cell12);
			table2.addCell(cell13);
			table2.addCell(cell14);
			table2.addCell(cell15);
			table2.setSpacingAfter(20);
			table2.setSpacingBefore(20);
			document.add(table2);
			
			
			
			/// 1.3 
			
			
			  Paragraph paragraph1331 = new Paragraph("1.3  Curriculum Enrichment",font2);
			  paragraph1331.setAlignment(Element.ALIGN_JUSTIFIED);
				document.add(paragraph1331);
			
				
				Paragraph paragraph13 = new Paragraph("\r\n");
				document.add(paragraph13);
				
				PdfPTable table131 = new PdfPTable(2);
				table131.setWidthPercentage(100);
				 PdfPTable table1310 = new PdfPTable(1);
				 table1310.setWidthPercentage(100);
				
				PdfPCell cell131= new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n",font4));
				cell131.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell132 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n",font4));
				cell132.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell133 = new PdfPCell(new Paragraph("\r\nAny Additional Information\r\n\r\n",font5));
				cell133.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell134 = new PdfPCell(new Paragraph("\r\n"+((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath():"")+"\r\n\r\n",font5));
				cell134.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell135 = new PdfPCell(new Paragraph(" \r\nProvide Link for additional information\r\n\r\n",font5));
				cell135.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell136= new PdfPCell(new Paragraph("\r\n"+((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :"")+"\r\n\r\n",font5));
				cell136.setHorizontalAlignment(Element.ALIGN_CENTER);
				table131.addCell(cell131);
				table131.addCell(cell132);
				table131.addCell(cell133); 
				table131.addCell(cell134);
				table131.addCell(cell135);
				table131.addCell(cell136);
				table131.setSpacingAfter(20);
				table131.setSpacingBefore(20);
				//document.add(table1310);
				
				
				PdfPCell cell1361= new PdfPCell(new Paragraph(
						" 1.3.1 Institution integrates crosscutting issues relevant to Professional Ethics ,Gender, Human Values ,Environment and Sustainability into the Curriculum\r\n\r\n"
				+"Response: "
				+(criteria1Record != null ? criteria1Record.getCriteria13Ql().get(0).getResponse131():"")+"\r\n\r\n",font4));
			
				table1310.addCell(cell1361);
			
			//	PdfPCell cell136110= new PdfPCell(new Paragraph(criteria1Record != null ? criteria1Record.getCriteria13Ql().get(0).getResponse131():""+"\r\n\r\n",font5));

			//	table1310.addCell(cell136110);
				table1310.setSpacingAfter(20);
				table1310.setSpacingBefore(20);
				document.add(table1310);
				document.add(table131);
				
				

			
				

				PdfPTable table133 = new PdfPTable(2);
				table133.setWidthPercentage(100);
				PdfPTable table1330 = new PdfPTable(1);
				table1330.setWidthPercentage(100);
				PdfPCell cell1331= new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n",font4));
				cell1331.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1332 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n",font4));
				cell1332.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1333 = new PdfPCell(new Paragraph("\r\nInstitutional data in the prescribed format"
						+ "\r\n\r\n",font5));
				cell1333.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1334 = new PdfPCell(new Paragraph("\r\n"+((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :"")+"\r\n\r\n",font5));
				cell1334.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1335 = new PdfPCell(new Paragraph("\r\nUpload supporting document\r\n\r\n",font5));
				cell1335.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell1336 = new PdfPCell(new Paragraph("\r\n"+((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :"")+"\r\n\r\n",font5));
				cell1336.setHorizontalAlignment(Element.ALIGN_CENTER);
				table133.addCell(cell1331);
				table133.addCell(cell1332);
				table133.addCell(cell1333);
				table133.addCell(cell1334);
				table133.addCell(cell1335);
				table133.addCell(cell1336);
				table133.setSpacingAfter(20);
				table133.setSpacingBefore(20);
			//	document.add(table1330);
			//	document.add(table133);
				
				PdfPCell cell1033610 = new PdfPCell(new Paragraph("1.3.2 Percentage of students undertaking project work/field work internships (Data for the latest completed academic year)s\r\n\r\n Response: "
						+(criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getResponseValue132():"")+"\r\n\r\n",font4));
							table1330.addCell(cell1033610);
				
				
				PdfPCell cell133610 = new PdfPCell(new Paragraph("1.3.2.1: Number of students undertaking field projects / internships / student projects\r\n\r\n "
				+(criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getInput1321t11():"")+"\r\n\r\n",font4));
					table1330.addCell(cell133610);
				
				PdfPCell cell133611 = new PdfPCell(new Paragraph("1.3.2.1: Total number of students\r\n\r\n"
						+ "Response: "+(criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getInput1321t12():"")+"\r\n\r\n",font4));
//				PdfPCell cell13361 = new PdfPCell(new Paragraph("1.3.3: Percentage of students undertaking field projects/ internships / student projects (Data for the latest completed academic year).\r\n\r\n"
//						+ "Response: "+font4+(criteria1Record != null ? criteria1Record.getCriteria13Qn().get(0).getResponse133():""),font5));
//				table1330.addCell(cell13361);

				table1330.addCell(cell133611);
				table1330.setSpacingAfter(20);
				table1330.setSpacingBefore(20);
				document.add(table1330);
				document.add(table133);
				
				
				
			
			//1.4
				
				
				Paragraph paragraph1441 = new Paragraph("1.4 Feedback System\r\n\r\n",font2);
				paragraph1441.setAlignment(Element.ALIGN_JUSTIFIED);
				document.add(paragraph1441);
				
				
				
				PdfPTable table141 = new PdfPTable(2);
				table141.setWidthPercentage(100);
				PdfPTable table1410 = new PdfPTable(1);
				table1410.setWidthPercentage(100);
				
				
				PdfPCell cell133612 = new PdfPCell(new Paragraph("1.4.1: Institution obtains feedback on the academic performance a ambience of the institution from various stakeholders, such as  Students, Teachers, Employers, Alumni etc. and action taken report on the feedback is made available on institutional website Feedback processes of the institution may be classified as follows:\r\n"
						+ "A. Feedback collected, analysed, action taken and feedback hosted on \r\n"
						+ "the institutional website\r\n"
						+ "B. Feedback collected, analysed and action has been taken \r\n"
						+ "C. Feedback collected and analysed \r\n"
						+ "D. Feedback collected (at least from any two stakeholders) \r\n"
						+ "E. Feedback not collected\r\n\r\n"
						+"Response: "
						+(criteria1Record != null	? criteria1Record.getCriteria14Qn().get(0).getResponse141():"")+"\r\n\r\n",font4));
				
				table1410.addCell(cell133612);
				
//				if(criteria1Record.getCriteria14Qn().size()>0)
//				{
//					PdfPCell cell1336120 = new PdfPCell(new Paragraph("\r\n"+criteria1Record != null	? criteria1Record.getCriteria14Qn().get(0).getResponse141():"\r\n\r\n",font5));
//					table1410.addCell(cell1336120);
//				}
//				table1410.setSpacingAfter(20);
//		//		table1410.setSpacingBefore(20);
				document.add(table1410);
			
				
				
				PdfPCell cell141 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n",font4));
				cell141.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell142= new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n",font4));
				cell142.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell143= new PdfPCell(new Paragraph("\r\nUpload Supporting Document\r\n\r\n",font5));
				cell143.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell144= new PdfPCell(new Paragraph("\r\n"+((criteria1file.size() > 0) ? criteria1file.get(0).getCriteria1FilePath() :"")+"\r\n\r\n",font5));
				cell144.setHorizontalAlignment(Element.ALIGN_CENTER);
				table141.addCell(cell141);
				table141.addCell(cell142);
				table141.addCell(cell143);
				table141.addCell(cell144);
				table141.setSpacingAfter(20);
				table141.setSpacingBefore(20);
				 document.add(table141);
				 
				
			
			
	            document.close();
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}
	
	
	

}
