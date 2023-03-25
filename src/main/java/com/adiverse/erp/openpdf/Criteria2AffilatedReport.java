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

import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.Criteria2_FileUpload;
import com.adiverse.erp.service.Criteria2Service;
import com.lowagie.text.Cell;
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
public class Criteria2AffilatedReport {

	@Value("${upload.files.path}")
	private String reportGeneratePath;

	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);

	@Autowired
	Criteria2Service service2;

	List<Criteria2_FieldInfo> criteria2List = null;
	Criteria2_FieldInfo criteria2Record = null;
	List<Criteria2_FileUpload> criteria2file = null;

	public String generateReport(Map<String, String> allParams) throws DocumentException, IOException {
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
			
			
			

//			Map<String, String> allParams = new HashMap<String, String>();
//			allParams.put("collegeId",criteria2Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear",criteria2Fieldinfo.getCriteriaId().getFinancialYear() );
//
//			allParams.put("typeofInstitution", criteria2Fieldinfo.getCriteriaId().getTypeofInstitution());

			

			criteria2List = service2.getAllCriteria2Data(allParams);
			if (CollectionUtils.isNotEmpty(criteria2List)) {
				criteria2Record = criteria2List.get(0);
				criteria2file = criteria2Record.getCriteria2FileUpload();
			} else {
				criteria2Record = new Criteria2_FieldInfo();
				criteria2file = new ArrayList<Criteria2_FileUpload>();
			}
			
			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "Criteria2AffilatedReport-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
			
          //  2.1
			
			
			PdfPTable tablecriteria2 = new PdfPTable(1);
			tablecriteria2.setWidthPercentage(100);
			PdfPTable table1criteria2 = new PdfPTable(1);
			table1criteria2.setWidthPercentage(100);
			PdfPTable table6criteria2 = new PdfPTable(5);
			table6criteria2.setWidthPercentage(100);

			PdfPTable table7criteria2 = new PdfPTable(2);
			table7criteria2.setWidthPercentage(100);


			Paragraph paragraph2criteria2 = new Paragraph("Criterion 2 - Teaching-learning and Evaluation\r\n\r\n", font1);
			Paragraph paragraph3criteria2 = new Paragraph("2.1 Student Enrollment and Profile\r\n", font2);
		//	Paragraph paragraph300criteria2 = new Paragraph("211 Enrolment percentage\r\n\r\n", font4);

			paragraph2criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			paragraph2criteria2.setAlignment(Paragraph.ALIGN_CENTER);
			paragraph3criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph2criteria2);
			document.add(paragraph3criteria2);
		//	document.add(paragraph300criteria2);
			tablecriteria2.setWidthPercentage(100f);
			
			
			
			PdfPTable table211criteria2 = new PdfPTable(1);
			PdfPTable table2111criteria2 = new PdfPTable(1);
			
			table211criteria2.setWidthPercentage(100);
			table2111criteria2.setWidthPercentage(100);
			
			PdfPCell cell211criteria2 = new PdfPCell(new Paragraph("2.1.1 Enrolment percentage \r\n" + "\r\n"  
			+ "Response: "
							+ ( criteria2Record != null
							? criteria2Record.getCriteria21Qn().get(0).getResponse211()
									: "")+"\r\n\r\n",font4));
			table211criteria2.addCell(cell211criteria2);
	
			PdfPTable tablecriteria02 = new PdfPTable(1);
			tablecriteria02.setWidthPercentage(100);
			
			PdfPCell cell2111criteria2 = new PdfPCell(new Paragraph(
						"2.1.1.1  Number of students admitted year wise during last five years"+ "\r\n\r\n",font4));
			
			table2111criteria2.addCell(cell2111criteria2);
			
			table211criteria2.setSpacingAfter(20);
			table211criteria2.setSpacingBefore(20);
			
			table2111criteria2.setSpacingAfter(20);
			table2111criteria2.setSpacingBefore(20);
			
			document.add(table211criteria2);
            document.add(table2111criteria2);
					
			 
			
			
			document.add(tablecriteria02);
			
			//YEAR TABLE 2111
			if(criteria2Record.getYearTable2111() !=null)
			{

			Table table2111 = new Table(criteria2Record.getYearTable2111().size(), 2);

			table2111.setPadding(5);
			table2111.setWidth(100f);
		
			for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
				Cell cell1criteria2111 = new Cell (criteria2Record.getYearTable2111().get(i).getInput2111y());
				cell1criteria2111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2111.addCell(cell1criteria2111);
			}
		
				for (int i = 0; i < criteria2Record.getYearTable2111().size(); i++) {
					Cell cell2criteria2111 = new Cell (criteria2Record.getYearTable2111().get(i).getInput2111v());
					cell2criteria2111.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2111.addCell(cell2criteria2111);
			}

			document.add(table2111);

		}
			// YEAR TABLE 2112
			
			PdfPTable table2112criteria02 = new PdfPTable(1);
			table2112criteria02.setWidthPercentage(100);
			
			PdfPCell cell2112criteria2 = new PdfPCell(new Paragraph(
					"2.1.1.2  Number of sanctioned seats year wise during last five years\r\n\r\n",font4));
				
			table2112criteria02.addCell(cell2112criteria2);
			table2112criteria02.setSpacingAfter(20);
			table2112criteria02.setSpacingBefore(20);
			
			document.add(table2112criteria02);
				
				

			
			if(criteria2Record.getYearTable2112() !=null)
			{
			Table table2112 = new Table(criteria2Record.getYearTable2112().size());

			table2112.setPadding(5);
			table2112.setWidth(100f);
		
			for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
				Cell cell1criteria2112 = new Cell (criteria2Record.getYearTable2112().get(i).getInput2112y());
				cell1criteria2112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2112.addCell(cell1criteria2112);
				
			}
		
			for (int i = 0; i < criteria2Record.getYearTable2112().size(); i++) {
				Cell cell2criteria2112 = new Cell (criteria2Record.getYearTable2112().get(i).getInput2112v());
				cell2criteria2112.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2112.addCell(cell2criteria2112);
				
			}

			document.add(table2112);
		}
			PdfPTable table3criteria2 = new PdfPTable(2);
			table3criteria2.setWidthPercentage(100);
//	        table3criteria2.setWidths(new int[] { 3, 3 });
//			table3criteria2.setSpacingBefore(20);

			PdfPCell cell1criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell1criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell1criteria2);

			PdfPCell cell2criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell2criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell2criteria2);

			PdfPCell cell3criteria2 = new PdfPCell(new Paragraph("\r\nInstitutional data in prescribed format(Data Template)\r\n\r\n",font5));
			cell3criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell3criteria2);

			PdfPCell cell4criteria2 = new PdfPCell(
					new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell4criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell4criteria2);

			PdfPCell cell5criteria2 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell5criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell5criteria2);

			PdfPCell cell6criteria2 = new PdfPCell(
					new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(2).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell6criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table3criteria2.addCell(cell6criteria2);
			
			table3criteria2.setSpacingAfter(20);
			table3criteria2.setSpacingBefore(20);
	        document.add(table3criteria2);

		
	        PdfPTable table212criteria2 = new PdfPTable(2);
	        table212criteria2.setWidthPercentage(100);

	        PdfPCell cell212criteria2 = new PdfPCell(new Paragraph(
					"2.1.2 Average percentage of seats filled against reserved categories (SC, ST, OBC, Divyangjan, etc. as per applicable reservation policy ) during the last five years ( exclusive of supernumerary seats)\r\n"
							+ "\r\n" + "Response: "
							+(criteria2Record != null
							? criteria2Record.getCriteria21Qn().get(0).getResponse212()
							: "")+"\r\n\r\n",font4));
	        
	        table212criteria2.addCell(cell212criteria2);
	        document.add(table212criteria2);
	        
	        
//	        Paragraph paragraph2criteria212 = new Paragraph((criteria2Record != null
//									? criteria2Record.getCriteria21Qn().get(0).getResponse212()
//									: ""));
//	        document.add(paragraph2criteria212);
       
//       PdfPCell cell0001criteria2 = new PdfPCell(new Paragraph(
//					"2.1.2 Average percentage of seats filled against reserved categories (SC, ST, OBC, Divyangjan etc. as per applicable reservation policy ) during the last five years ( exclusive of supernumerar seats"+ "Response:"
//							+(criteria2Fieldinfo != null
//					? criteria2Fieldinfo.getCriteria2FieldInfoQn().get(0).getResponse212()
//					: ""),font3));
//	        table3criteria2.addCell(cell0001criteria2);
	    //    document.add(table3criteria2);
			
//			table1criteria2.addCell((criteria2Record != null
//								? criteria2Record.getCriteria21Qn().get(0).getInput2121t21()
//									: ""));
//			
			
	        PdfPTable table2121criteria2 = new PdfPTable(2);
	        table2121criteria2.setWidthPercentage(100);
			
	        PdfPCell cell2121criteria2 = new PdfPCell(new Paragraph(
					"2.1.2.1 Number of actual students admitted from the reserved categories year wise during last"
					+ "five years\r\n \r\n",font4));
	        table2121criteria2.addCell(cell2121criteria2);
	        table2121criteria2.setSpacingAfter(20);
	        table2121criteria2.setSpacingBefore(20);
	        
	        document.add(table2121criteria2);
	        
	        
	        if(criteria2Record.getYearTable2121() !=null)
	        {
	        			Table table2121 = new Table(criteria2Record.getYearTable2121().size());

	        			table2121.setPadding(5);
	        			table2121.setWidth(100f);
	        		
	        			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
	        				Cell cell1criteria2121 = new Cell (criteria2Record.getYearTable2121().get(i).getInput2121y());
	        				cell1criteria2121.setHorizontalAlignment(Element.ALIGN_CENTER);
	        				table2121.addCell(cell1criteria2121);
	        				
	        			}
	        		
	        			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
	        				Cell cell2criteria2121 = new Cell (criteria2Record.getYearTable2121().get(i).getInput2121v());
	        				cell2criteria2121.setHorizontalAlignment(Element.ALIGN_CENTER);
	        				table2121.addCell(cell2criteria2121);
	        				
	        			}

	        			document.add(table2121);
	        			
	        		}
	        
			
	        PdfPTable table2122criteria2 = new PdfPTable(2);
	        table2122criteria2.setWidthPercentage(100);
			
	        PdfPCell cell2122criteria2 = new PdfPCell(new Paragraph(
					"2.1.2.2 Number of seats earmarked for reserved category as per GOI State Govt rule year wise during the last five years \r\n"
							+ "\r\n",font4));
	        table2122criteria2.addCell(cell2122criteria2);
	        table2122criteria2.setSpacingAfter(20);
	        table2122criteria2.setSpacingBefore(20);
	        
	        document.add(table2122criteria2);
	        
	        
	        if( criteria2Record.getYearTable2121() !=null)
			{
			Table table2122 = new Table(criteria2Record.getYearTable21212().size());

			table2122.setPadding(5);
			table2122.setWidth(100f);
	//		table2122.addCell("year");
			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
				Cell cell1criteria2122 = new Cell (criteria2Record.getYearTable21212().get(i).getInput21212y());
				cell1criteria2122.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2122.addCell(cell1criteria2122);
				
				
			}
	//		table2122.addCell("Number of seats earmarked");
			for (int i = 0; i < criteria2Record.getYearTable2121().size(); i++) {
				Cell cell2criteria2122 = new Cell (criteria2Record.getYearTable21212().get(i).getInput21212v());
				cell2criteria2122.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2122.addCell(cell2criteria2122);
				
			}

			document.add(table2122);
			
		}
	        
		
			
			
			PdfPTable table07criteria2 = new PdfPTable(2);
			table07criteria2.setWidthPercentage(100);
	//		table07criteria2.setWidths(new int[] { 3, 3 });
			

			PdfPCell cell07criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell07criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table07criteria2.addCell(cell07criteria2);

			PdfPCell cell08criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell08criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table07criteria2.addCell(cell08criteria2);

			PdfPCell cell09criteria2 = new PdfPCell(new Paragraph("\r\nAverage percentage of seats vfilled against seats reserved\r\n\r\n",font5));
			cell09criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table07criteria2.addCell(cell09criteria2);

			PdfPCell cell10criteria2 = new PdfPCell(
					new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell10criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table07criteria2.addCell(cell10criteria2);

			PdfPCell cell11criteria2 = new PdfPCell(new Paragraph("\r\n Additional Information\r\n\r\n",font5));
			cell11criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table07criteria2.addCell(cell11criteria2);

			PdfPCell cell12criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell12criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table07criteria2.addCell(cell12criteria2);
			
			table07criteria2.setSpacingAfter(20);
			table07criteria2.setSpacingBefore(20);
			document.add(table07criteria2);
			
			//2.2
			
			
			Paragraph paragraph02criteria2 = new Paragraph("2.2: Catering to Student Diversity\r\n\r\n", font2);
			document.add(paragraph02criteria2);
		
			 PdfPTable table221criteria2 = new PdfPTable(2);
			 table221criteria2.setWidthPercentage(100);
				
		        
		       PdfPCell cell1criteria221 = new PdfPCell(new Paragraph("2.2.1  Student - Full time teacher ratio (Data for the latest completed academic year)\r\n" + "\r\n" + "Response:"
							+  (criteria2Record != null
							? criteria2Record.getCriteria22Qn().get(0).getResponse221()
									: "")+"\r\n\r\n",font4));
		       table221criteria2.addCell(cell1criteria221);
		       table221criteria2.setSpacingAfter(20);
		       table221criteria2.setSpacingBefore(20);
		       
		      
		       
		       
		       PdfPTable table2210criteria2 = new PdfPTable(2);
		       table2210criteria2.setWidthPercentage(100);
					
			        
			       PdfPCell cell1criteria2210 = new PdfPCell(new Paragraph("2.2.1 Average Enrolment percentage (Average of last five years)\r\n" + "\r\n" 
					+  (criteria2Record != null
					? criteria2Record.getCriteria22Qn().get(0).getInput221t1()
							: "")+"\r\n\r\n",font4));
			   //    table2210criteria2.addCell(cell1criteria2210); 
			       
               //     document.add(table2210criteria2);
			       
			       
          
          PdfPTable table9criteria2 = new PdfPTable(2);

			table9criteria2.setWidthPercentage(100f);
			table9criteria2.setWidths(new int[] { 3, 3 });
			table9criteria2.setSpacingBefore(5);

			PdfPCell cell17criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell17criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria2.addCell(cell17criteria2);

			PdfPCell cell18criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell18criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria2.addCell(cell18criteria2);

			PdfPCell cell19criteria2 = new PdfPCell(new Paragraph("\r\nUplaod any additional information\r\n\r\n",font5));
			cell19criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria2.addCell(cell19criteria2);

			PdfPCell cell20criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell20criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table9criteria2.addCell(cell20criteria2);
			table9criteria2.setSpacingAfter(20);
			table9criteria2.setSpacingBefore(20);
			
			 document.add(table221criteria2);
			document.add(table9criteria2);
			
			//2.3
			
			Paragraph paragraph5criteria2 = new Paragraph("2.3	Teaching- Learning Process\r\n\r\n", font2);
			document.add(paragraph5criteria2);

			PdfPTable table03 = new PdfPTable(1);
			table03.setWidthPercentage(100f);

			PdfPCell cell001 = new PdfPCell(new Paragraph(
					"2.3.1 Student centric methods, such as experiential learning, participativelearning and problem solving methodologies are used for enhancing learning experiences using ICT tools"
							+ "\r\n\r\n"+ "Response: "
							+ (criteria2Record != null
							? criteria2Record.getCriteria23Ql().get(0).getResponse231()
									: "")+ "\r\n\r\n",font4));

			table03.addCell(cell001);
			table03.setSpacingAfter(20);
			table03.setSpacingBefore(20);
			document.add(table03);

			
			PdfPTable table10criteria2 = new PdfPTable(2);

			table10criteria2.setWidthPercentage(100f);
			table10criteria2.setWidths(new int[] { 3, 3 });
			table10criteria2.setSpacingBefore(5);

			
			
			
			PdfPCell cell21criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell21criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10criteria2.addCell(cell21criteria2);

			PdfPCell cell22criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell22criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10criteria2.addCell(cell22criteria2);

			PdfPCell cell23criteria2 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell23criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10criteria2.addCell(cell23criteria2);

			PdfPCell cell24criteria2 = new PdfPCell(new Paragraph( "\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell24criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10criteria2.addCell(cell24criteria2);
			
			PdfPCell cell23xcriteria2 = new PdfPCell(new Paragraph("\r\nLink for additional information\r\n\r\n",font5));
			cell23xcriteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10criteria2.addCell(cell23xcriteria2);

			PdfPCell cell24xcriteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() :  "")+"\r\n\r\n",font5));
			cell24xcriteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table10criteria2.addCell(cell24xcriteria2);
			table10criteria2.setSpacingAfter(20);
			table10criteria2.setSpacingBefore(20);
			document.add(table10criteria2);

			//2.4
			
			Paragraph paragraph6criteria2 = new Paragraph(" 2.4 Teacher Profile and Quality\r\n\r\n", font2);

			paragraph6criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph6criteria2);

			PdfPTable table241criteria24 = new PdfPTable(1);
			table241criteria24.setWidthPercentage(100f);

			PdfPCell cell1criteria241 = new PdfPCell(new Paragraph(
					"2.4.1: Percentage of full-time teachers against sanctioned posts during the last five years"
							+ "\r\n\r\n" + "Response: "
							+(criteria2Record != null
							? criteria2Record.getCriteria24Qn().get(0).getResponse241()
							: "")+"\r\n\r\n",font4));
			
			table241criteria24.addCell(cell1criteria241);
			table241criteria24.setSpacingAfter(20);
			table241criteria24.setSpacingBefore(20);
			
			document.add(table241criteria24);
//			if(criteria2Record.getCriteria24Qn()!=null)
//			{
//			Paragraph paragraph6criteria22 = new Paragraph((criteria2Record != null
//									? criteria2Record.getCriteria24Qn().get(0).getResponse241()
//									: ""));
//			document.add(paragraph6criteria22);
//			}
			
			PdfPTable table2411criteria24 = new PdfPTable(1);
			table2411criteria24.setWidthPercentage(100f);

			PdfPCell cell1criteria2411 = new PdfPCell(new Paragraph("2.4.1.1 Number of Sanctioned posts / required positions for teaching staff/ "
					+ "full time teachers year wise during the last five years:\r\n\r\n",font4));
			
		//	document.add(paragraph6criteria23);
			table2411criteria24.addCell(cell1criteria2411);
			table2411criteria24.setSpacingAfter(20);
			table2411criteria24.setSpacingBefore(20);
			document.add(table2411criteria24);
			
//			if(criteria2Record.getCriteria24Qn()!=null)
//			{
//			Paragraph paragraph6criteria24 = new Paragraph(
//					criteria2Record != null
//									? criteria2Record.getCriteria24Qn().get(0).getResponse241()
//									: "");
//			document.add(paragraph6criteria24);
//			}
			
			
if(criteria2Record.getYearTable2411() !=null)
{
			Table table2411 = new Table(criteria2Record.getYearTable2411().size());

			table2411.setPadding(5);
			table2411.setWidth(100f);
	//		table2411.addCell("year");
			for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
				Cell cell1criteria24110= new Cell (criteria2Record.getYearTable2411().get(i).getInput2411y());
				cell1criteria24110.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2411.addCell(cell1criteria24110);
	//			table2411.addCell();
			}
	//		table2411.addCell("number");
			for (int i = 0; i < criteria2Record.getYearTable2411().size(); i++) {
				Cell cell2criteria24110= new Cell (criteria2Record.getYearTable2411().get(i).getInput2411v());
				cell2criteria24110.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2411.addCell(cell2criteria24110);
				
			}

			document.add(table2411);		
}





//if(criteria2Record.getYearTable24112() !=null)
//{
//Table table24112 = new Table(criteria2Record.getYearTable24112().size());
//
//table24112.setPadding(5);
//table24112.setWidth(100f);
////table24112.addCell("year");
//for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
//	Cell cell1criteria2421= new Cell (criteria2Record.getYearTable2421().get(i).getInput2421y());
//	cell1criteria2421.setHorizontalAlignment(Element.ALIGN_CENTER);
//	table24112.addCell(cell1criteria2421);
//	//table24112.addCell(criteria2Record.getYearTable2421().get(i).getInput2421y());
//}
////table24112.addCell("number");
//for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
//	Cell cell2criteria2421= new Cell (criteria2Record.getYearTable2421().get(i).getInput2421v());
//	cell2criteria2421.setHorizontalAlignment(Element.ALIGN_CENTER);
//	table24112.addCell(cell2criteria2421);
//	//table24112.addCell();
//}
//
//document.add(table24112);
//
//
//}		
			
			
			
			
			
			

			PdfPTable table14 = new PdfPTable(2);

			table14.setWidthPercentage(100f);
//			table14.setWidths(new int[] { 3, 3 });
//			table14.setSpacingBefore(5);

			PdfPCell cell43 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell43.setHorizontalAlignment(Element.ALIGN_CENTER);
			table14.addCell(cell43);

			PdfPCell cell44 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell44.setHorizontalAlignment(Element.ALIGN_CENTER);
			table14.addCell(cell44);

			PdfPCell cell45 = new PdfPCell(
					new Paragraph("\r\nUpload supporting document\r\n\r\n",font5));
			cell45.setHorizontalAlignment(Element.ALIGN_CENTER);
			table14.addCell(cell45);

			PdfPCell cell46 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell46.setHorizontalAlignment(Element.ALIGN_CENTER);
			table14.addCell(cell46);

			table14.setSpacingAfter(20);
			table14.setSpacingBefore(20);
			

			document.add(table14);
			
			//242

			PdfPTable table242Cr24 = new PdfPTable(1);
			table242Cr24.setWidthPercentage(100f);

			PdfPCell cell1242Cr2 = new PdfPCell(new Paragraph(
					"2.4.2 Percentage of full time teachers with NET/SET/SLET/ Ph. D./D.Sc. D.Litt. during the last five years (consider only highest degree for count)"
							+ "\r\n\r\n"  + "Response: "
							+(criteria2Record != null
							? criteria2Record.getCriteria24Qn().get(0).getResponse242()
							: "")+"\r\n\r\n",font4));
			table242Cr24.addCell(cell1242Cr2);
			table242Cr24.setSpacingAfter(20);
			table242Cr24.setSpacingBefore(20);
			document.add(table242Cr24);
			
			
//			if(criteria2Record.getCriteria24Qn() !=null)
//			{
//			
//			Paragraph paragraph6criteria27 = new Paragraph( (criteria2Record != null
//									? criteria2Record.getCriteria24Qn().get(0).getResponse242()
//									: ""));
//			document.add(paragraph6criteria27);
//			}
			
			
			PdfPTable table2421Cr24 = new PdfPTable(1);
			table2421Cr24.setWidthPercentage(100f);

			PdfPCell cell12421Cr2 = new PdfPCell(new Paragraph("2.4.2.1: Number of full time teachers with NET/SET/SLET/Ph. D. / D.M. / M.Ch. D.N.B Superspeciality / D.Sc. / D.Litt. year wise during the last five years\r\n\r\n",font4));
			table2421Cr24.addCell(cell12421Cr2);
			table2421Cr24.setSpacingAfter(20);
			table2421Cr24.setSpacingBefore(20);
			document.add(table2421Cr24);
			

			
			
			
			PdfPTable table24210Cr24 = new PdfPTable(1);
			table24210Cr24.setWidthPercentage(100f);

//			PdfPCell cell124210Cr2 = new PdfPCell(new Paragraph("B: Total number of full time teachers year wise during last five years\r\n\r\n",font4));
//			
//			table24210Cr24.addCell(cell124210Cr2);
			
			
			
			 Paragraph paragraph1=new Paragraph("\r\n\r\n");
			 document.add(paragraph1);
			 
			if(criteria2Record.getYearTable2421() !=null)
			{
			Table table2421 = new Table(criteria2Record.getYearTable2421().size());

			table2421.setPadding(5);
			table2421.setWidth(100f);
			
			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
				Cell cell1criteria2421 = new Cell (criteria2Record.getYearTable2421().get(i).getInput2421y());
				cell1criteria2421.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell1criteria2421);
				
			}
		
			for (int i = 0; i < criteria2Record.getYearTable2421().size(); i++) {
				Cell cell2criteria2421 = new Cell (criteria2Record.getYearTable2421().get(i).getInput2421v());
				cell2criteria2421.setHorizontalAlignment(Element.ALIGN_CENTER);
				table2421.addCell(cell2criteria2421);
				
			}

			document.add(table2421);
			
			}
			
			table24210Cr24.setSpacingAfter(20);
			table24210Cr24.setSpacingBefore(20);
			document.add(table24210Cr24);
			
			
//			if(criteria2Record.getYearTable24212() !=null)
//			{
//			Table table24212 = new Table(criteria2Record.getYearTable24212().size());
//
//			table24212.setPadding(5);
//			table24212.setWidth(100f);
//			
//			for (int i = 0; i < criteria2Record.getYearTable24212().size(); i++) {
//				Cell cell1criteria24212 = new Cell (criteria2Record.getYearTable24212().get(i).getInput24212y());
//				cell1criteria24212.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table24212.addCell(cell1criteria24212);
//				
//			}
//		
//			for (int i = 0; i < criteria2Record.getYearTable24212().size(); i++) {
//				Cell cell2criteria24212 = new Cell (criteria2Record.getYearTable24212().get(i).getInput24212v());
//				cell2criteria24212.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table24212.addCell(cell2criteria24212);
//				
//			}
//
//			document.add(table24212);
//			
//			}
			
			
			
			
	
			

			PdfPTable table21 = new PdfPTable(2);

			table21.setWidthPercentage(100f);
			
//			table21.setWidths(new int[] { 3, 3 });
//			table21.setSpacingBefore(5);

			PdfPCell cell61 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell61.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell61);

			PdfPCell cell62 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell62);

			PdfPCell cell63 = new PdfPCell(new Paragraph("\r\nInstitutional data in the prescribed format (template merged with Extended profile 2.1)\r\n\r\n",font5));
			cell63.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell63);

			PdfPCell cell64 = new PdfPCell(
					new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell64.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell64);

			PdfPCell cell65 = new PdfPCell(new Paragraph("\r\nUpload supporting document\r\n\r\n",font5));
			cell65.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell65);

			PdfPCell cell66 = new PdfPCell(
					new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(1).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell66.setHorizontalAlignment(Element.ALIGN_CENTER);
			table21.addCell(cell66);


			table21.setSpacingAfter(20);
			table21.setSpacingBefore(20);
			
			document.add(table21);

	//2.5
			
			
			
			Paragraph paragraph7criteria2 = new Paragraph("2.5	Evaluation Process and Reforms\r\n\r\n", font2);

			paragraph7criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph7criteria2);

			PdfPTable table22 = new PdfPTable(1);
			table22.setWidthPercentage(100f);

			PdfPCell cell25Cr25 = new PdfPCell(new Paragraph(
					"2.5.1  Mechanism of internal/ external assessment is transparent and the grievance redressal system is time- bound and efficient"
							+ "\r\n\r\n" + "Response: "
							+(criteria2Record != null
							? criteria2Record.getCriteria25Qn().get(0).getResponse251()
							: "")+"\r\n\r\n",font4));
			
			table22.addCell(cell25Cr25);
			
			table22.setSpacingAfter(20);
			table22.setSpacingBefore(20);
			
			document.add(table22);
			
//			if(criteria2Record.getCriteria25Qn() !=null)
//			{
//			Paragraph paragraph7criteria22 = new Paragraph( (criteria2Record != null
//									? criteria2Record.getCriteria25Qn().get(0).getResponse251()
//									: ""));
//			document.add(paragraph7criteria22);
//			}



			PdfPTable table24 = new PdfPTable(2);

			table24.setWidthPercentage(100f);
		//	table24.setWidths(new int[] { 3, 3 });
		//	table24.setSpacingBefore(20);

			PdfPCell cell69criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n",font4));
			cell69criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24.addCell(cell69criteria2);

			PdfPCell cell70criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n",font4));
			cell70criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24.addCell(cell70criteria2);

			PdfPCell cell71criteria2 = new PdfPCell(
					new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell71criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24.addCell(cell71criteria2);

			PdfPCell cell72criteria2 = new PdfPCell(
					new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell72criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24.addCell(cell72criteria2);

			PdfPCell cell73criteria2 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n",font5));
			cell73criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24.addCell(cell73criteria2);

			PdfPCell cell74criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell74criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table24.addCell(cell74criteria2);

			table24.setSpacingAfter(20);
			table24.setSpacingBefore(20);
			
			document.add(table24);

		//2.6
			
			
			Paragraph paragraph8criteria2 = new Paragraph("2.6 Student Performance and Learning Outcome\r\r\n\n", font2);

			paragraph8criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph8criteria2);

			PdfPTable table27 = new PdfPTable(1);
			table27.setWidthPercentage(100f);

			PdfPCell cell1criteria261 = new PdfPCell(new Paragraph(
					"2.6.1 Programme Outcomes (POs) and Course Outcomes (COs) for all  Programmes offered by the institution are stated and displayed on website and attainment of POs and COs are evaluated"
							+ "\r\n\r\n"+ "Response: "+(criteria2Record != null
								? criteria2Record.getCriteria26Ql().get(0).getResponse261()
									: "")+"\r\n\r\n",font4));
			table27.addCell(cell1criteria261);
			table27.setSpacingAfter(20);
			table27.setSpacingBefore(20);
			document.add(table27);
//		


			PdfPTable table28 = new PdfPTable(2);
	        table28.setWidthPercentage(100f);
		//	table28.setWidths(new int[] { 3, 3 });
			table28.setSpacingBefore(5);

			PdfPCell cell79criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell79criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell79criteria2);

			PdfPCell cell80criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell80criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell80criteria2);

			PdfPCell cell81criteria2 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
			cell81criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell81criteria2);

			PdfPCell cell82criteria2 = new PdfPCell(
					new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell82criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell82criteria2);

			PdfPCell cell83criteria2 = new PdfPCell(new Paragraph("\r\nLink for Additional Information\r\n\r\n",font5));
			cell83criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell83criteria2);

			PdfPCell cell84criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() :"")+"\r\n\r\n",font5));
			cell84criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell84criteria2);
			
			PdfPCell cell830criteria2 = new PdfPCell(new Paragraph("\r\nUpload COs for all courses (exemplars from Glossary)\r\n\r\n",font5));
			cell830criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell830criteria2);

			PdfPCell cell840criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() :"")+"\r\n\r\n",font5));
			cell840criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table28.addCell(cell840criteria2);
			table28.setSpacingAfter(20);
			table28.setSpacingBefore(20);

			document.add(table28);

			
			
			PdfPTable table29 = new PdfPTable(1);
			table29.setWidthPercentage(100f);
	
			PdfPCell cell013 = new PdfPCell(new Paragraph(
					"2.6.2  Attainment of POs and COs are evaluated. ." + "\r\n\r\n"
						 + "Response: "
							+ (criteria2Record != null
								? criteria2Record.getCriteria26Ql().get(0).getResponse262()
									: "")+"\r\n\r\n",font4
						));
			
			table29.addCell(cell013);
		
		
//			PdfPCell cell0013 = new PdfPCell(new Paragraph(
//					"2.6.2 Attainment of programme outcomes and course outcomes are evaluated by the institution." + "\r\n"
//							+ "" + "" + "Response:"
//							+  (criteria2Record != null
//								? criteria2Record.getCriteria26Ql().get(0).getInput261t1()
//									: "")
//						));
//			
//			table29.addCell(cell0013);
//			PdfPCell cell00013 = new PdfPCell(new Paragraph(
//					"2.6.2 Attainment of programme outcomes and course outcomes are evaluated by the institution." + "\r\n"
//							+ "" + "" + "Response:"
//							+  (criteria2Record != null
//								? criteria2Record.getCriteria26Ql().get(0).getInput261t1()
//									: "")
//						));
//			table29.addCell(cell00013);
			table29.setSpacingAfter(20);
			table29.setSpacingBefore(20);
			
			document.add(table29);
		

		
			
			
			
			
		
			PdfPTable table32 = new PdfPTable(2);
            table32.setWidthPercentage(100f);
          
			table32.setWidths(new int[] { 3, 3 });
			table32.setSpacingBefore(5);

			PdfPCell cell89criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell89criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell89criteria2);

			PdfPCell cell90criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell90criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell90criteria2);

			PdfPCell cell91criteria2 = new PdfPCell(new Paragraph(
					"\r\nUpload List of Programmes and number of students passed and appeared in the final year examination(Data Template)\r\n\r\n",font5));
			cell91criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell91criteria2);

			PdfPCell cell92criteria2 = new PdfPCell(
					new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell92criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell92criteria2);

			PdfPCell cell93criteria2 = new PdfPCell(new Paragraph("\r\nUpload any  the annual report\r\n\r\n",font5));
			cell93criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell93criteria2);

			PdfPCell cell94criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell94criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell94criteria2);
			PdfPCell cell930criteria2 = new PdfPCell(new Paragraph("\r\nPaste link for annual report\r\n\r\n",font5));
			cell930criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell930criteria2);

			PdfPCell cell940criteria2 = new PdfPCell(new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell940criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table32.addCell(cell940criteria2);
			table32.setSpacingAfter(20);
			table32.setSpacingBefore(20);
			
			document.add(table32);
			
			
			//2.6.3
			
			
			Paragraph paragraphcriteria2 = new Paragraph("Pass percentage of Students during last five years\r\r\n\n", font2);
            paragraphcriteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            document.add(paragraphcriteria2);
			
            Paragraph paragrap1hcriteria2 = new Paragraph("2.6.3.1. Number of final year students who passed the university \r\n"
            		+ "examination year wise during the last five years\r\n"
            		+ "\r\r\n\n", font4);
            
            document.add(paragrap1hcriteria2);
			
			
			
			
			
			
			if(criteria2Record.getAffiliatedyearTable2631() !=null)
			{
				Table table2631 = new Table(criteria2Record.getAffiliatedyearTable2631().size());
	
				table2631.setPadding(5);
				table2631.setWidth(100f);
				
				for (int i = 0; i < criteria2Record.getAffiliatedyearTable2631().size(); i++) {
					Cell cell1criteria24212 = new Cell (criteria2Record.getAffiliatedyearTable2631().get(i).getInput2631y());
					cell1criteria24212.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2631.addCell(cell1criteria24212);
					
				}
			
				for (int i = 0; i < criteria2Record.getAffiliatedyearTable2631().size(); i++) {
					Cell cell2criteria24212 = new Cell (criteria2Record.getAffiliatedyearTable2631().get(i).getInput2631v());
					cell2criteria24212.setHorizontalAlignment(Element.ALIGN_CENTER);
					table2631.addCell(cell2criteria24212);
					
				}
	
				document.add(table2631);
				
				}
			
			
			  Paragraph paragrap2hcriteria2 = new Paragraph("2.6.3.2. Number of final year students who appeared for the university examination year wise during the last five years"
	            		+ "\r\r\n\n", font4);
	            
	            document.add(paragrap2hcriteria2);
	            
	            
	            if(criteria2Record.getAffiliatedyearTable2632() !=null)
				{
					Table table2632 = new Table(criteria2Record.getAffiliatedyearTable2632().size());
		
					table2632.setPadding(5);
					table2632.setWidth(100f);
					
					for (int i = 0; i < criteria2Record.getAffiliatedyearTable2632().size(); i++) {
						Cell cell1criteria24212 = new Cell (criteria2Record.getAffiliatedyearTable2632().get(i).getInput2632y());
						cell1criteria24212.setHorizontalAlignment(Element.ALIGN_CENTER);
						table2632.addCell(cell1criteria24212);
						
					}
				
					for (int i = 0; i < criteria2Record.getAffiliatedyearTable2632().size(); i++) {
						Cell cell2criteria24212 = new Cell (criteria2Record.getAffiliatedyearTable2632().get(i).getInput2632v());
						cell2criteria24212.setHorizontalAlignment(Element.ALIGN_CENTER);
						table2632.addCell(cell2criteria24212);
						
					}
		
					document.add(table2632);
					
					}
	            
	            PdfPTable table263 = new PdfPTable(2);
	            table263.setWidthPercentage(100f);
	            
	        	PdfPCell cell01criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
	        	cell01criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
	        	table263.addCell(cell01criteria2);

				PdfPCell cell02criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
				cell02criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table263.addCell(cell02criteria2);
				
				PdfPCell cell03criteria2 = new PdfPCell(new Paragraph("\r\n Institutional data in the prescribed format\r\n\r\n", font5));
				cell03criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table263.addCell(cell03criteria2);
				
				PdfPCell cell04criteria2 = new PdfPCell(new Paragraph("\r\n Upload supporting document\r\n\r\n", font5));
				cell04criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
				table263.addCell(cell04criteria2);
	            
	            
				table263.setSpacingAfter(20);
				table263.setSpacingBefore(20);
				document.add(table263);
			
			
			
			
			
			
			//2.7
			
			

			Paragraph paragraph9criteria2 = new Paragraph("2.7	Student Satisfaction Survey \r\n\r\n", font2);

			paragraph9criteria2.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph9criteria2);
			
			
			PdfPTable table33 = new PdfPTable(1);
			table33.setWidthPercentage(100f);

			
			
			PdfPCell cell1criteria271 = new PdfPCell(new Paragraph("2.7.1: Online student satisfaction survey regarding to teaching learning process.\r\n"
					+ "\r\n\r\n",font4));
			table33.addCell(cell1criteria271);
			table33.setSpacingAfter(20);
			table33.setSpacingBefore(20);
			document.add(table33);
          
			
			
			PdfPTable table34 = new PdfPTable(2);

			table34.setWidthPercentage(100f);
//			table34.setWidths(new int[] { 3, 3 });
//			table34.setSpacingBefore(5);

			PdfPCell cell95criteria2 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell95criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell95criteria2);

			PdfPCell cell96criteria2 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell96criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell96criteria2);

			PdfPCell cell97criteria2 = new PdfPCell(new Paragraph("\r\nUpload any additional information",font5));
			cell97criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell97criteria2);

			PdfPCell cell98criteria2 = new PdfPCell(
					new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell98criteria2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell98criteria2);
			
			
			
			PdfPCell cell97criteria21 = new PdfPCell(new Paragraph("\r\nUpload database of all currently enrolled students",font5));
			cell97criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell97criteria21);

			PdfPCell cell98criteria21 = new PdfPCell(
					new Paragraph("\r\n"+(criteria2Record != null ? criteria2file.get(0).getCriteria2FilePath() : "")+"\r\n\r\n",font5));
			cell98criteria21.setHorizontalAlignment(Element.ALIGN_CENTER);
			table34.addCell(cell98criteria21);
			
			table34.setSpacingAfter(20);
			table34.setSpacingBefore(20);
			document.add(table34);
			
			
			
			
			
			
			
			
			
			
			
			
			
			document.close();
			
			
			
		}catch(

	Exception e)
	{
			e.printStackTrace();
		}return file.toAbsolutePath().toString();
}

}
