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

import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.Criteria3_FileUpload;
import com.adiverse.erp.service.Criteria3Service;
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
public class Criteria3AffilatedReport 
{
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	
	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	
	@Autowired
	Criteria3Service service3;
	
	List<Criteria3_FieldInfo> criteria3List = null;
	Criteria3_FieldInfo criteria3Record = null;
	List<Criteria3_FileUpload> criteria3file = null;
	
	
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
//			allParams.put("collegeId",criteria3Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear", criteria3Fieldinfo.getCriteriaId().getFinancialYear());
//
//			allParams.put("typeofInstitution", criteria3Fieldinfo.getCriteriaId().getTypeofInstitution() );

			criteria3List = service3.getAllCriteria3Data(allParams);
			if (CollectionUtils.isNotEmpty(criteria3List)) {
				criteria3Record = criteria3List.get(0);
				criteria3file = criteria3Record.getCriteria3FileUpload();
			} else {
				criteria3Record = new Criteria3_FieldInfo();
				criteria3file = new ArrayList<Criteria3_FileUpload>();
			}
			
			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AffilatedCriteria3Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
			
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
			
          //  3.1
			
			

			Paragraph paragraph1criteria3 = new Paragraph("Criterion 3 - Research, Innovations and Extension\r\n" + "\r\n",
					font1);
			paragraph1criteria3.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(paragraph1criteria3);
			
			Paragraph paragraph2criteria3 = new Paragraph("3.1 Resource Mobilization for Research\r\n", font2);
			paragraph1criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
			document.add(paragraph2criteria3);
			
			// create table1
			PdfPTable table1criteria3 = new PdfPTable(2);
			PdfPTable table13criteria31 = new PdfPTable(1);
			PdfPTable table311criteria31 = new PdfPTable(1);

			table1criteria3.setWidthPercentage(100f);
			table13criteria31.setWidthPercentage(100f);
			table311criteria31.setWidthPercentage(100);

			PdfPCell cell1criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell1criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell2criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell2criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell3criteria3 = new PdfPCell(new Paragraph(
					"\r\nList of endowments / projects with details of grants\r\n\r\n",font5));
			cell3criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell4criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell4criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell5criteria3 = new PdfPCell(new Paragraph("\r\nE-copies of the grant award letters for sponsoredresearch projects / endowments\r\n\r\n",font5));
			cell5criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell6criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell6criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell7criteria3 = new PdfPCell(
					new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell7criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell8criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() :"")+"\r\n\r\n",font5));
			cell8criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1criteria3.addCell(cell1criteria3);
			table1criteria3.addCell(cell2criteria3);
			table1criteria3.addCell(cell3criteria3);
			table1criteria3.addCell(cell4criteria3);
			table1criteria3.addCell(cell5criteria3);
			table1criteria3.addCell(cell6criteria3);
			table1criteria3.addCell(cell7criteria3);
			table1criteria3.addCell(cell8criteria3);
			table1criteria3.setSpacingAfter(20);
			table1criteria3.setSpacingBefore(20);
			
			

			PdfPCell paragraph21criteria3 = new PdfPCell(new Paragraph(
					"3.1.1: Grants received from Government and non-governmental agencies for research projects, endowments, Chairs in the institution during the last five years (INR in Lakhs)..\r\n\r\n"
							+ "Response: "
							+(criteria3Record != null
							? criteria3Record.getCriteria31Ql().get(0).getResponse311():"")+"\r\n\r\n",font4));
			
			table13criteria31.addCell(paragraph21criteria3);
			table13criteria31.setSpacingAfter(20);
			table13criteria31.setSpacingBefore(20);
			
			document.add(table13criteria31);
		//	document.add(table1criteria3);
//			PdfPCell paragraph22criteria3 = new PdfPCell(new Paragraph(criteria3Record != null
//							? criteria3Record.getCriteria31Ql().get(0).getResponse311()
//							: ""+"\r\n\r\n",font5));
//			table13criteria31.addCell(paragraph22criteria3);
					
			


			PdfPCell paragraph211criteria3 = new PdfPCell(new Paragraph (
					"3.1.1.1 Total Grants from Government and non-governmental agencies for research projects / endowments in the institution during the last five  years (INR in Lakhs)"+"\r\n\r\n",font4));
			table311criteria31.addCell(paragraph211criteria3);
			table311criteria31.setSpacingAfter(20);
			table311criteria31.setSpacingBefore(20);
			
			document.add(table311criteria31);
			
			

			//YEAR TABLE 3111
			
			
			if(criteria3Record.getAffiliatedYearTable3111().size()>0)
			{
			Table table3111criteria3 = new Table(criteria3Record.getAffiliatedYearTable3111().size());

			table3111criteria3.setPadding(5);
			table3111criteria3.setWidth(100f);

			for (int i = 0; i < criteria3Record.getAffiliatedYearTable3111().size(); i++) {
				Cell cell1criteria311 = new Cell (criteria3Record.getAffiliatedYearTable3111().get(i).getInput3111y());
				cell1criteria311.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3111criteria3.addCell(cell1criteria311);
				
			}
			for (int i = 0; i < criteria3Record.getAffiliatedYearTable3111().size(); i++) {
				Cell cell2criteria311 = new Cell (criteria3Record.getAffiliatedYearTable3111().get(i).getInput3111v());
				cell2criteria311.setHorizontalAlignment(Element.ALIGN_CENTER);
				table3111criteria3.addCell(cell2criteria311);
				
			}

			document.add(table3111criteria3);
		

			
			}
				// create table 2////
			PdfPTable table2criteria3 = new PdfPTable(2);
			PdfPTable table23criteria31 = new PdfPTable(1);
			table2criteria3.setWidthPercentage(100f);
			table23criteria31.setWidthPercentage(100f);
			
			PdfPCell cell21criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
			cell21criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell22criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
			cell22criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell23criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
			cell23criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell24criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell24criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell25criteria3 = new PdfPCell(
					new Paragraph("\r\nE-copies of the grant award letters for research projects sponsored by non-government\r\n\r\n",font5));
			cell25criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell26criteria3 = new PdfPCell(
					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
			cell26criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table2criteria3.addCell(cell21criteria3);
			table2criteria3.addCell(cell22criteria3);
			table2criteria3.addCell(cell23criteria3);
			table2criteria3.addCell(cell24criteria3);
			table2criteria3.addCell(cell25criteria3);
			table2criteria3.addCell(cell26criteria3);
			table2criteria3.setSpacingAfter(20);
			table2criteria3.setSpacingBefore(20);
		     document.add(table2criteria3);
		     
		     // 3.2
		     
		     
		     Paragraph paragraph31criteria3 = new Paragraph("3.2: Resource Mobilization for Research\r\n\r\n",font2);
		     paragraph31criteria3.setAlignment(Element.ALIGN_JUSTIFIED);
				document.add(paragraph31criteria3);
				
				PdfPCell paragraph32criteria3 = new PdfPCell(new Paragraph(
						"3.2.1Institution has created an ecosystem for innovations and has	initiatives for creation and transfer of knowledge (patents filed, published, incubation center facilities in the HEI to be considered)\r\n\r\n"
								 + "Response: "
						+(criteria3Record != null
						? criteria3Record.getCriteria32Ql().get(0).getResponse321(): "")+"\r\n\r\n",font4));
				table23criteria31.addCell(paragraph32criteria3);
				
//				PdfPCell paragraph33criteria3 = new PdfPCell(new Paragraph(criteria3Record != null
//										? criteria3Record.getCriteria32Ql().get(0).getResponse321()
//										: "",font5));
//				table23criteria31.addCell(paragraph33criteria3);
				table23criteria31.setSpacingAfter(20);
				table23criteria31.setSpacingBefore(20);
				
				document.add(table23criteria31);
				
				PdfPTable table5criteria3 = new PdfPTable(2);
				PdfPTable table53criteria31 = new PdfPTable(1);
				PdfPTable table3221criteria31 = new PdfPTable(1);
				
		      table5criteria3.setWidthPercentage(100f);
		      table53criteria31.setWidthPercentage(100f);
		      table3221criteria31.setWidthPercentage(100f);
		      
				PdfPCell cell51criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
				cell51criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell52criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
				cell52criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell53criteria3 = new PdfPCell(new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
				cell53criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell54criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(11).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell54criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell55criteria3 = new PdfPCell(
						new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
				cell55criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell56criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(12).getCriteria3FilePath() :"")+"\r\n\r\n",font5));
				cell56criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				table5criteria3.addCell(cell51criteria3);
				table5criteria3.addCell(cell52criteria3);
				table5criteria3.addCell(cell53criteria3);
				table5criteria3.addCell(cell54criteria3);
				table5criteria3.addCell(cell55criteria3);
				table5criteria3.addCell(cell56criteria3);
				table5criteria3.setSpacingAfter(20);
				table5criteria3.setSpacingBefore(20);
				
				//document.add(table5criteria3);
				
				PdfPCell paragraph34criteria3 = new PdfPCell(new Paragraph(
						"3.2.2 Number of workshops/seminars conducted on Research Methodology, Intellectual Property\r\n"
								+ "Rights (IPR) and entrepreneurship during the last five years\r\n"
								 + "Response: "
								+(criteria3Record != null
								? criteria3Record.getCriteria32Qn().get(0).getResponse322(): "")+"\r\n\r\n",font4));
				
				table53criteria31.addCell(paragraph34criteria3);
				
				
//				Paragraph paragraph35criteria3 = new Paragraph(criteria3Record != null
//										? criteria3Record.getCriteria32Qn().get(0).getResponse322()
//										: "",font5);
//				table53criteria31.addCell(paragraph35criteria3);
				table53criteria31.setSpacingAfter(20);
				table53criteria31.setSpacingBefore(20);
				document.add(table53criteria31);
				
				
				
				
				PdfPCell paragraph3221criteria3 = new PdfPCell(new Paragraph(
						"3.2.2.1 Total number of workshops/seminars/conferences including  programs conducted on Research Methodology, Intellectual Property Rights (IPR) and entrepreneurship year wise during last five years" + "\r\n\r\n",font4));
				
		//		paragraph3221criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
				table3221criteria31.addCell(paragraph3221criteria3);
				
				document.add(table3221criteria31);
				
				
//				// year table 3221

				if (criteria3Record.getYearTable3221().size()>0) {
					Table table3221criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);

					table3221criteria3.setPadding(5);
					table3221criteria3.setWidth(100f);

					for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
						Cell cell1criteria3221 = new Cell (criteria3Record.getYearTable3221().get(i).getInput3221y());
						cell1criteria3221.setHorizontalAlignment(Element.ALIGN_CENTER);
						table3221criteria3.addCell(cell1criteria3221);
						

					}
					for (int i = 0; i < criteria3Record.getYearTable3221().size(); i++) {
						Cell cell2criteria3221 = new Cell (criteria3Record.getYearTable3221().get(i).getInput3221v());
						cell2criteria3221.setHorizontalAlignment(Element.ALIGN_CENTER);
						table3221criteria3.addCell(cell2criteria3221);
						

					}

					document.add(table3221criteria3);
				}

				// create table 6////
				PdfPTable table6criteria3 = new PdfPTable(2);
				PdfPTable table63criteria31 = new PdfPTable(1);
		       table6criteria3.setWidthPercentage(100f);
		       table63criteria31.setWidthPercentage(100f);
				PdfPCell cell61criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
				cell61criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell62criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
				cell62criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell63criteria3 = new PdfPCell(
						new Paragraph("\r\nReport of the event\r\n\r\n",font5));
				cell63criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell64criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell64criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell65criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
				cell65criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell66criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell66criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell67criteria3 = new PdfPCell(new Paragraph("\r\nLink for additional information\r\n\r\n",font5));
				cell67criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell68criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath():"")+"\r\n\r\n",font5));
				cell68criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				table6criteria3.addCell(cell61criteria3);
				table6criteria3.addCell(cell62criteria3);
				table6criteria3.addCell(cell63criteria3);
				table6criteria3.addCell(cell64criteria3);
				table6criteria3.addCell(cell65criteria3);
				table6criteria3.addCell(cell66criteria3);
				table6criteria3.addCell(cell67criteria3);
				table6criteria3.addCell(cell68criteria3);
				table6criteria3.setSpacingAfter(20);
				table6criteria3.setSpacingBefore(20);
				
				document.add(table6criteria3);
				
				
				//  3.3
				
				
				Paragraph paragraph4criteria3 = new Paragraph("3.3	Research Publications and Awards\r\n\r\n", font2);
				paragraph4criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
				document.add(paragraph4criteria3);
				
				
				
				PdfPCell cell1criteria331 = new PdfPCell(new Paragraph(
						"3.3.1: Number of research papers per teachers in the Journals notified on UGC website during the last five years\r\n\r\n"
				+ "Response: "
								+(criteria3Record != null
								? criteria3Record.getCriteria33Qn().get(0).getResponse331()
								: "")+"\r\n\r\n",font4));
				table63criteria31.addCell(cell1criteria331);
				
				
				PdfPCell cell1criteria3031 = new PdfPCell(new Paragraph(
						"3.3.1.1. Number of research papers in the Journals notified on UGC CARE year wise during the last five years",font4));
				table63criteria31.addCell(cell1criteria3031);
				
				
				
				
				
				
				table63criteria31.setSpacingAfter(20);
				table63criteria31.setSpacingBefore(20);
				
				document.add(table63criteria31);
				
//				Paragraph paragraph43criteria3 = new Paragraph("	Paragraph paragraph41criteria3 = new Paragraph(");
//				document.add(paragraph43criteria3);
				
				if (criteria3Record.getAffiliatedYearTable3311().size()>0) {
					Table table3321criteria3 = new Table(criteria3Record.getAffiliatedYearTable3311().size(), 2);

					table3321criteria3.setPadding(5);
					table3321criteria3.setWidth(100f);

					for (int i = 0; i < criteria3Record.getAffiliatedYearTable3311().size(); i++) {
						Cell cell1criteria3311 = new Cell (criteria3Record.getAffiliatedYearTable3311().get(i).getInput3311y());
						cell1criteria3311.setHorizontalAlignment(Element.ALIGN_CENTER);
						table3321criteria3.addCell(cell1criteria3311);
					//	table3321criteria3.addCell(criteria3Record.getAffiliatedYearTable3311().get(i).getInput3311y());

					}
					for (int i = 0; i < criteria3Record.getAffiliatedYearTable3311().size(); i++) {
						Cell cell2criteria3311 = new Cell (criteria3Record.getAffiliatedYearTable3311().get(i).getInput3311v());
						cell2criteria3311.setHorizontalAlignment(Element.ALIGN_CENTER);
						table3321criteria3.addCell(cell2criteria3311);
					//	table3321criteria3.addCell(criteria3Record.getAffiliatedYearTable3311().get(i).getInput3311v());

					}

					document.add(table3321criteria3);
				}
				
				

				PdfPTable table9criteria3 = new PdfPTable(2);
				PdfPTable table91criteria31 = new PdfPTable(1);
		        table9criteria3.setWidthPercentage(100f);
				table91criteria31.setWidthPercentage(100f);
				
				PdfPCell cell91criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
				cell91criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell92criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
				cell92criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell93criteria3 = new PdfPCell(new Paragraph("\r\nList of research papers by title, author, department,\r\n"
						+ "name and year of publicatio\r\n\r\n",font5));
				cell93criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell94criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell94criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell95criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
				cell95criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell96criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() :"")+"\r\n\r\n",font5));
				cell96criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				table9criteria3.addCell(cell91criteria3);
				table9criteria3.addCell(cell92criteria3);
				table9criteria3.addCell(cell93criteria3);
				table9criteria3.addCell(cell94criteria3);
				table9criteria3.addCell(cell95criteria3);
				table9criteria3.addCell(cell96criteria3);
				table9criteria3.setSpacingAfter(20);
				table9criteria3.setSpacingBefore(20);
				
				
				document.add(table9criteria3);
				
				
							/// create table 9 ////
				PdfPTable table332criteria33 = new PdfPTable(1);
				table332criteria33.setWidthPercentage(100);
				
				PdfPCell paragraph411criteria3 = new PdfPCell(new Paragraph(
						"3.3.2  Number of books and chapters in edited volumes/books published and papers published in national/ international conference proceedings per teacher during last five years \r\n\r\n"
				+ "Response: "
				+	(criteria3Record != null
				? criteria3Record.getCriteria33Qn().get(0).getResponse332(): "")+"\r\n\r\n",font4));
				table332criteria33.addCell(paragraph411criteria3);
				document.add(table332criteria33);
				
				
//				if( criteria3Record.getCriteria33Qn() !=null)
//				{
//				Paragraph paragraph421criteria3 = new Paragraph(criteria3Record != null
//										? criteria3Record.getCriteria33Qn().get(0).getResponse332()
//										: "");
//				document.add(paragraph421criteria3);
//				
//				}
				
				Paragraph paragraph431criteria3 = new Paragraph("	3.3.2.1. Total number of books and chapters in edited volumes/books published and papers in national/ international conference proceedings year wise during last five years",font4);
				document.add(paragraph431criteria3);
				
				if (criteria3Record.getYearTable3221().size()>0) {
					Table table3321criteria3 = new Table(criteria3Record.getYearTable3221().size(), 2);

					table3321criteria3.setPadding(5);
					table3321criteria3.setWidth(100f);

					for (int i = 0; i < criteria3Record.getYearTable3321().size(); i++) {
						Cell cell1criteria3321 = new Cell (criteria3Record.getYearTable3321().get(i).getInput3321y());
						cell1criteria3321.setHorizontalAlignment(Element.ALIGN_CENTER);
						table3321criteria3.addCell(cell1criteria3321);
					//	table3321criteria3.addCell(criteria3Record.getYearTable3321().get(i).getInput3321y());

					}
					for (int i = 0; i < criteria3Record.getYearTable3321().size(); i++) {
						Cell cell2criteria3321 = new Cell (criteria3Record.getYearTable3321().get(i).getInput3321v());
						cell2criteria3321.setHorizontalAlignment(Element.ALIGN_CENTER);
						table3321criteria3.addCell(cell2criteria3321);
					//	table3321criteria3.addCell(criteria3Record.getYearTable3321().get(i).getInput3321v());

					}

					document.add(table3321criteria3);
				}

				PdfPTable table91criteria3 = new PdfPTable(2);
				PdfPTable table911criteria31 = new PdfPTable(1);
		        table91criteria3.setWidthPercentage(100f);
				table911criteria31.setWidthPercentage(100f);
				
				PdfPCell cell911criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
				cell911criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell cell921criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
				cell921criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell931criteria3 = new PdfPCell(new Paragraph("\r\nList of research papers by title, author, department,\r\n"
						+ "name and year of publicatio\r\n\r\n",font5));
				cell931criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell941criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell941criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell951criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
				cell951criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell961criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() :"")+"\r\n\r\n",font5));
				cell961criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				table91criteria3.addCell(cell911criteria3);
				table91criteria3.addCell(cell921criteria3);
				table91criteria3.addCell(cell951criteria3);
				table91criteria3.addCell(cell961criteria3);
				table91criteria3.addCell(cell931criteria3);
				table91criteria3.addCell(cell941criteria3);
				table91criteria3.setSpacingAfter(20);
				table91criteria3.setSpacingBefore(20);
				
				document.add(table91criteria3);
				
				
				// 3.4
				

				Paragraph paragraph5criteria3 = new Paragraph("3.4 Extension Activitie\r\n\r\n", font2);
				paragraph5criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
				document.add(paragraph5criteria3);
				// create table 10 ///
				PdfPTable table10criteria3 = new PdfPTable(2);
				PdfPTable table101criteria31 = new PdfPTable(1);
				table10criteria3.setWidthPercentage(100f);
				table101criteria31.setWidthPercentage(100f);
				
				PdfPCell cell101criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
				cell101criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell102criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
				cell102criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell103criteria3 = new PdfPCell(new Paragraph("\r\nUpload any additional information \r\n\r\n",font5));
				cell103criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell104criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell104criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell105criteria3 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
				cell105criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell106criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell106criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				table10criteria3.addCell(cell101criteria3);
				table10criteria3.addCell(cell102criteria3);
				table10criteria3.addCell(cell103criteria3);
				table10criteria3.addCell(cell104criteria3);
				table10criteria3.addCell(cell105criteria3);
				table10criteria3.addCell(cell106criteria3);
				PdfPCell cell341criteria3 = new PdfPCell(new Paragraph(
						"3.4.1 Extension activities are carried out in the neighborhood community, sensitizing students to\r\n"
						+ "social issues, for their holistic development, and impact thereof during the last five years"
								+ "\r\n\r\n" + "Response:"
								+ (criteria3Record != null
										? criteria3Record.getCriteria34Ql().get(0).getResponse341()
										: "")+"\r\n\r\n",font4));
				
//				PdfPCell cell3401criteria3 = new PdfPCell(new Paragraph(
//						 (criteria3Record != null
//										? criteria3Record.getCriteria34Ql().get(0).getInput341t1()
//										: ""),
//						font2));
				
				
				table101criteria31.addCell(cell341criteria3);
			//	table101criteria31.addCell(cell3401criteria3);
			//	table101criteria31.addCell(table10criteria3);
				// document.add(cell341criteria3);
				table10criteria3.setSpacingBefore(20f);
				table10criteria3.setSpacingAfter(20f);
				document.add(table101criteria31);
				document.add(table10criteria3);
				
				

				/// create table 11 ////
				PdfPTable table11criteria3 = new PdfPTable(2);
				PdfPTable table111criteria31 = new PdfPTable(1);

				table11criteria3.setWidthPercentage(100f);
				table111criteria31.setWidthPercentage(100f);

				PdfPCell cell111criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
				cell111criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell112criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
				cell112criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell113criteria3 = new PdfPCell(new Paragraph(
						"\r\nNumber of awards for extension activities in last 5\r\n"
						+ "yea\r\n\r\n",font5));
				cell113criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell114criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(7).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell114criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell115criteria3 = new PdfPCell(new Paragraph("\r\nE-copy of the award letter\r\n\r\n",font5));
				cell115criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell116criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(8).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell116criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell117criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
				cell117criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell118criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(9).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell118criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				
				table11criteria3.addCell(cell111criteria3);
				table11criteria3.addCell(cell112criteria3);
				table11criteria3.addCell(cell113criteria3);
				table11criteria3.addCell(cell114criteria3);
				table11criteria3.addCell(cell115criteria3);
				table11criteria3.addCell(cell116criteria3);
				table11criteria3.addCell(cell117criteria3);
				table11criteria3.addCell(cell118criteria3);
				
				
				PdfPTable table342criteria31 = new PdfPTable(1);
				PdfPTable table3421criteria31 = new PdfPTable(1);
				PdfPTable table34222criteria31 = new PdfPTable(1);
				
				table342criteria31.setWidthPercentage(100);
				table3421criteria31.setWidthPercentage(100);
				table34222criteria31.setWidthPercentage(100);
				
				//342
				
				
				
				PdfPCell cell342criteria3 = new PdfPCell(new Paragraph(
						"3.4.2 Awards and recognitions received for extension activities from government / government recognised bodies"
								+ "\r\n\r\n" + "Response:"
								+ (criteria3Record != null
										? criteria3Record.getCriteria34Qn().get(0).getResponse342()
										: "")+"\r\n\r\n",font4));
				
//				PdfPCell cell3420criteria3 = new PdfPCell(new Paragraph(
//						 (criteria3Record != null
//										? criteria3Record.getCriteria34Qn().get(0).getInput342t1()
//										: ""),
//						font2));

				table342criteria31.addCell(cell342criteria3);
		
				
				PdfPCell cell3422criteria3 = new PdfPCell(new Paragraph(
						"3.4.2.1 Number of teachers recognized as guides during the last five years" + "\r\n\r\n" + "Response:"
								+ (criteria3Record != null
										? criteria3Record.getCriteria34Qn().get(0).getInput3422t1()
										: "")+"\r\n\r\n",font4));
				
				table34222criteria31.addCell(cell3422criteria3);
		//		table111criteria31.addCell(table11criteria3);

				// document.add(cell3421criteria3);
				// document.add(cell3422criteria3);
				table111criteria31.setSpacingAfter(20f);
				table111criteria31.setSpacingAfter(20f);

				table342criteria31.setSpacingAfter(20);
				table342criteria31.setSpacingBefore(20);
				
				table3421criteria31.setSpacingAfter(20);
				table3421criteria31.setSpacingBefore(20);
				
				table34222criteria31.setSpacingAfter(20);
				table34222criteria31.setSpacingBefore(20);
				
				
				document.add(table342criteria31);
				document.add(table3421criteria31);
				document.add(table34222criteria31);
				document.add(table11criteria3);
				
				
				
				
				/// create table 12 /////
				PdfPTable table12criteria3 = new PdfPTable(2);
				PdfPTable table123criteria31 = new PdfPTable(1);
		        table12criteria3.setWidthPercentage(100f);
		        table123criteria31.setWidthPercentage(100f);
		        
		        
		        
				PdfPCell cell121criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
				cell121criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell122criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
				cell122criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell123criteria3 = new PdfPCell(new Paragraph(
						"\r\nReports of the event organized\r\n\r\n",
						font5));
				cell123criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell124criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell124criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell125criteria3 = new PdfPCell(new Paragraph("\r\nNumber of extension and outreach Programmes\r\n"
						+ "conducted with industry, community etc for the last\r\n"
						+ "five years\r\n\r\n", font5));
				cell125criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell126criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(1).getCriteria3FilePath() :"")+"\r\n\r\n",font5));
				cell126criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell127criteria3 = new PdfPCell(new Paragraph("\r\nNumber of extension and outreach Programmes\r\n"
						+ "conducted with industry, community etc for the last\r\n"
						+ "five years\r\n\r\n", font5));
				cell127criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell128criteria3 = new PdfPCell(new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(2).getCriteria3FilePath() :"")+"\r\n\r\n",font5));
				cell128criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
			
				
				table12criteria3.addCell(cell121criteria3);
				table12criteria3.addCell(cell122criteria3);
				table12criteria3.addCell(cell123criteria3);
				table12criteria3.addCell(cell124criteria3);
				table12criteria3.addCell(cell125criteria3);
				table12criteria3.addCell(cell126criteria3);
				table12criteria3.addCell(cell127criteria3);
				table12criteria3.addCell(cell128criteria3);
				
				PdfPCell cell343criteria3 = new PdfPCell(new Paragraph(
						"3.4.3 Number of extension and outreach programs conducted by the institution through NSS/NCC,\r\n"
						+ "Government and Government recognised bodies during the last five years\r\n"
								+ "\r\n" + "Response: "
								+ (criteria3Record != null
										? criteria3Record.getCriteria34Qn().get(0).getResponse343()
										: "")+"\r\n\r\n",font4));
				

//				PdfPCell cell3430criteria3 = new PdfPCell(new Paragraph(
//						(criteria3Record != null
//										? criteria3Record.getCriteria34Qn().get(0).getInput343t1()
//										: ""),
//						font2));
//				
				
				PdfPCell cell3431criteria3 = new PdfPCell(new Paragraph(
						"3.4.3.1 Number of extension and outreached Programmes conducted in collaboration with industry,\r\n"
						+ "community and Non- Government Organizations through NSS/ NCC/ Red Cross/ YRC etc., yearwise during the last\r\n\r\n"
								+ "",font4));
				table123criteria31.addCell(cell343criteria3);
		//		table123criteria31.addCell(cell3430criteria3);
				table123criteria31.addCell(cell3431criteria3);
			//	table123criteria31.addCell(table12criteria3);

				// document.add(cell343criteria3);
				// document.add(cell3431criteria3);
				table123criteria31.setSpacingBefore(20f);
				table123criteria31.setSpacingAfter(20f);

				document.add(table123criteria31);
				
				/// create table 3431 ////


				if (criteria3Record.getYearTable3431().size()>0) {
					Table table3431criteria3 = new Table(criteria3Record.getYearTable3431().size(), 2);

					table3431criteria3.setPadding(5);
					table3431criteria3.setWidth(100f);

					for (int i = 0; i < criteria3Record.getYearTable3431().size(); i++) {
						Cell cell1criteria3431 = new Cell (criteria3Record.getYearTable3431().get(i).getInput3431y());
						cell1criteria3431.setHorizontalAlignment(Element.ALIGN_CENTER);
						table3431criteria3.addCell(cell1criteria3431);

					}
					for (int i = 0; i < criteria3Record.getYearTable3431().size(); i++) {
						Cell cell2criteria3431 = new Cell (criteria3Record.getYearTable3431().get(i).getInput3431v());
						cell2criteria3431.setHorizontalAlignment(Element.ALIGN_CENTER);
						table3431criteria3.addCell(cell2criteria3431);
						

					}

					document.add(table3431criteria3);
				}
				
				table12criteria3.setSpacingAfter(20);
				table12criteria3.setSpacingBefore(20);
				document.add(table12criteria3);
				

				/// create table 13 //
				PdfPTable table13criteria3 = new PdfPTable(2);
				PdfPTable table131criteria31 = new PdfPTable(1);
				PdfPTable table3441criteria31 = new PdfPTable(1);
				

				table13criteria3.setWidthPercentage(100f);
				table131criteria31.setWidthPercentage(100f);
				table3441criteria31.setWidthPercentage(100);

				PdfPCell cell131criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
				cell131criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell132criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
				cell132criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell133criteria3 = new PdfPCell(
						new Paragraph("\r\nReport of the event\r\n\r\n",font5));
				cell133criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell134criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell134criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell135criteria3 = new PdfPCell(new Paragraph("\r\nAverage percentage of students participating in\r\n"
						+ "extension activities with Govt or NGO etc\r\n\r\n",font5));
				cell135criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell136criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell136criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell137criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"
						+ "extension activities with Govt or NGO etc\r\n\r\n",font5));
				cell137criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell138criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell138criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				
				table13criteria3.addCell(cell131criteria3);
				table13criteria3.addCell(cell132criteria3);
				table13criteria3.addCell(cell133criteria3);
				table13criteria3.addCell(cell134criteria3);
				table13criteria3.addCell(cell135criteria3);
				table13criteria3.addCell(cell136criteria3);
				table13criteria3.addCell(cell137criteria3);
				table13criteria3.addCell(cell138criteria3);
				
//				PdfPCell cell344criteria3 = new PdfPCell(new Paragraph(
//						"3.4.4 Average percentage of students participating in extension activities at 3.4.3. above during last\r\n"
//						+ "five year\r\n"
//								+ "\r\n" + "Response:"
//								+ (criteria3Record != null
//										? criteria3Record.getCriteria34Qn().get(0).getResponse344()
//										: "")+"\r\n\r\n",font4));
//				
//				table131criteria31.addCell(cell344criteria3);
//				
//				PdfPCell cell3441criteria3 = new PdfPCell(new Paragraph(
//						"3.4.4.1 Total number of Students participating in extension activities conducted in collaboration\r\n"
//						+ "with industry, community and Non- Government Organizations such as Swachh Bharat, AIDs\r\n"
//						+ "awareness, Gender issue etc. year-wise during last five year"
//								+ "\r\n\r\n\r\n",font4));
//				
//				table3441criteria31.addCell(cell3441criteria3);
				
				
			//	table131criteria31.addCell(cell3441criteria3);
			//	table131criteria31.addCell(table13criteria3);

				// document.add(cell344criteria3);
				// document.add(cell3441criteria3);
				table131criteria31.setSpacingBefore(20f);
				table131criteria31.setSpacingAfter(20f);
				
				table3441criteria31.setSpacingBefore(20f);
				table3441criteria31.setSpacingAfter(20f);

				document.add(table131criteria31);
				//document.add(table3441criteria31);
				//document.add(table13criteria3);
				// create table 3441 //

//				if (criteria3Record.getYearTable3441().size()>0) {
//					Table table3441criteria3 = new Table(criteria3Record.getYearTable3441().size(), 2);
//
//					table3441criteria3.setPadding(5);
//					table3441criteria3.setWidth(100f);
//
//					for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
//						Cell cell1criteria3441 = new Cell (criteria3Record.getYearTable3441().get(i).getInput3441y());
//						cell1criteria3441.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table3441criteria3.addCell(cell1criteria3441);
//						
//
//					}
//					for (int i = 0; i < criteria3Record.getYearTable3441().size(); i++) {
//						Cell cell2criteria3441 = new Cell (criteria3Record.getYearTable3441().get(i).getInput3441v());
//						cell2criteria3441.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table3441criteria3.addCell(cell2criteria3441);
//						
//
//					}
//
//					document.add(table3441criteria3);
//				}

				// create table 14 //
//				PdfPTable table14criteria3 = new PdfPTable(2);
//				PdfPTable table141criteria31 = new PdfPTable(1);
//
//				table14criteria3.setWidthPercentage(100f);
//				table141criteria31.setWidthPercentage(100f);
//
//				PdfPCell cell141criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
//				cell141criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				PdfPCell cell142criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//				cell142criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				PdfPCell cell143criteria3 = new PdfPCell(
//						new Paragraph("\r\nBibliometrics of the publications during the last five years\r\n\r\n",font5));
//				cell143criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				PdfPCell cell144criteria3 = new PdfPCell(
//						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(6).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//				cell144criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				table14criteria3.addCell(cell141criteria3);
//				table14criteria3.addCell(cell142criteria3);
//				table14criteria3.addCell(cell143criteria3);
//				table14criteria3.addCell(cell144criteria3);
//
//				PdfPCell cell345criteria3 = new PdfPCell(new Paragraph(
//						"3.4.5 Bibliometrics of the publications during the last five years based on average citation index in Scopus/ Web of Science or PubMed"
//								+ "\r\n\r\n" + "Response: "
//								+ (criteria3Record != null
//										? criteria3Record.getCriteria34Qn().get(0).getResponse345()
//										: "")+"\r\n\r\n",font4));
//				
//				table141criteria31.addCell(cell345criteria3);
//			//	table141criteria31.addCell(table14criteria3);
//				table141criteria31.setSpacingBefore(20f);
//				table141criteria31.setSpacingAfter(20f);
//				document.add(table141criteria31);
//				document.add(table14criteria3);
//				
//				
//				
//				
//				// create table 15 //
//				PdfPTable table15criteria3 = new PdfPTable(2);
//				PdfPTable table153criteria31 = new PdfPTable(1);
//
//				table15criteria3.setWidthPercentage(100f);
//				table153criteria31.setWidthPercentage(100f);
//
//				PdfPCell cell151criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
//				cell151criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				PdfPCell cell152criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//				cell152criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				PdfPCell cell153criteria3 = new PdfPCell(new Paragraph(
//						"\r\nBibiliometrics of publications based on Scopus/ Web of Science - h-index of the Institution\r\n\r\n",font5));
//				cell153criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				PdfPCell cell154criteria3 = new PdfPCell(
//						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//				cell154criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				table15criteria3.addCell(cell151criteria3);
//				table15criteria3.addCell(cell152criteria3);
//				table15criteria3.addCell(cell153criteria3);
//				table15criteria3.addCell(cell154criteria3);
//				PdfPCell cell346criteria3 = new PdfPCell(new Paragraph(
//						"3.4.6 Bibliometrics of the publications during the last five years based on Scopus/ Web of Science - h- index of the Institution\r\n"
//								+ "\r\n" + "Response: "
//								+ (criteria3Record != null
//										? criteria3Record.getCriteria34Qn().get(0).getResponse346()
//										: "")+"\r\n\r\n",font4));
//				
//				table153criteria31.addCell(cell346criteria3);
//			//	table153criteria31.addCell(table15criteria3);
//
//				// document.add(cell346criteria3);
//				table153criteria31.setSpacingBefore(20f);
//				table153criteria31.setSpacingAfter(20f);
//				
//				table15criteria3.setSpacingBefore(20f);
//				table15criteria3.setSpacingAfter(20f);
//				
//				document.add(table153criteria31);
//				document.add(table15criteria3);

				
		     //3.5
				

				Paragraph paragraph6criteria3 = new Paragraph("3.5	 Collaboration\r\n", font2);
				paragraph6criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
				document.add(paragraph6criteria3);

				PdfPTable table351criteria3 = new PdfPTable(1);
				PdfPTable table3511criteria31 = new PdfPTable(1);
				
				table351criteria3.setWidthPercentage(100f);
				table3511criteria31.setWidthPercentage(100f);
				
				
				PdfPCell cell351criteria3 = new PdfPCell(new Paragraph("3.5.1: The number of MoUs, collaborations/linkages for Faculty exchange, Student exchange, Internship, Field project, On-thejob training, research and other academic activities during the last five years \r\n\r\n "
						+"Response: "
						+(criteria3Record != null
						? criteria3Record.getCriteria35Qn().get(0).getResponse351():"")+"\r\n\r\n",font4));		
				table351criteria3.addCell(cell351criteria3);
				table351criteria3.setSpacingAfter(20);
				table351criteria3.setSpacingBefore(20);
				
				document.add(table351criteria3);
				
//				Paragraph paragraph613criteria3 = new Paragraph
//						(criteria3Record != null
//										? criteria3Record.getCriteria35Qn().get(0).getResponse351()
//										: "");
//				document.add(paragraph613criteria3);
				
				
								
				PdfPCell cell3511criteria3 = new PdfPCell(new Paragraph("3.5.1.1:Number of MoUs, collaborations/linkages for Faculty exchange, Student exchange, Internship, Field project, On-the- jobtraining, research and other academic activities during the last five "+"\r\n\r\n",font4));
				table3511criteria31.addCell(cell3511criteria3);
				table3511criteria31.setSpacingAfter(20);
				table3511criteria31.setSpacingBefore(20);
				document.add(table3511criteria31);
				
								
								
								
								
								
								
								
								

//				if (criteria3Record.getYearTable3521().size()>0) {
//					Table table3521criteria3 = new Table(criteria3Record.getYearTable3521().size(), 2);
//
//					table3521criteria3.setPadding(5);
//					table3521criteria3.setWidth(100f);
//
//					for (int i = 0; i < criteria3Record.getYearTable3521().size(); i++) {
//						Cell cell1criteria3521 = new Cell (criteria3Record.getYearTable3521().get(i).getInput3521y());
//						cell1criteria3521.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table3521criteria3.addCell(cell1criteria3521);
//						
//
//					}
//					for (int i = 0; i < criteria3Record.getYearTable3521().size(); i++) {
//						Cell cell2criteria3521 = new Cell (criteria3Record.getYearTable3521().get(i).getInput3521v());
//						cell2criteria3521.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table3521criteria3.addCell(cell2criteria3521);
//						
//
//					}
//				
//
//					document.add(table3521criteria3);
//					
//				}
//				
//				
//				
				
				
				PdfPTable table17criteria3 = new PdfPTable(2);
				PdfPTable table173criteria31 = new PdfPTable(1);

				table17criteria3.setWidthPercentage(100f);
				table173criteria31.setWidthPercentage(100f);

				PdfPCell cell171criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
				cell171criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell172criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
				cell172criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell173criteria3 = new PdfPCell(
						new Paragraph("\r\nReports of the event organized\r\n\r\n",font5));
				cell173criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell174criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell174criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell175criteria3 = new PdfPCell(
						new Paragraph("\r\nAny additional information\r\n\r\n",font5));
				cell175criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell176criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell176criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell177criteria3 = new PdfPCell(new Paragraph(
						"\r\nNumber of extension and outreach Programmes conducted with industry, community etc for the last five years\r\n\r\n",font5));
				cell177criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				PdfPCell cell178criteria3 = new PdfPCell(
						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
				cell178criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
				
				
				table17criteria3.addCell(cell171criteria3);
				table17criteria3.addCell(cell172criteria3);
				table17criteria3.addCell(cell173criteria3);
				table17criteria3.addCell(cell174criteria3);
				table17criteria3.addCell(cell175criteria3);
				table17criteria3.addCell(cell176criteria3);
				table17criteria3.addCell(cell177criteria3);
				table17criteria3.addCell(cell178criteria3);
				table17criteria3.setSpacingAfter(20);
				table17criteria3.setSpacingBefore(20);
				
	             document.add(table17criteria3);
				
//				
//				//3.6
//	             Paragraph paragraph7criteria3 = new Paragraph("3.6	Extension Activities\r\n\r\n", font2);
//	 			paragraph7criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//	 			document.add(paragraph7criteria3);
//	 			// create table 18 //
//
//	 			
//	 			PdfPTable table361criteria3 = new PdfPTable(1);	
//	 			table361criteria3.setWidthPercentage(100);
//	 			
//	 			PdfPCell cell361criteria3 = new PdfPCell(new Paragraph("3.6.1: Extension activities are carried out in the neighbourhood community, sensitising students to social issues, "
//	 					+ "for their holistic development, and impact thereof during the last five years"
//	 					+"Response: "
//	 					+(criteria3Record != null
//	 					? criteria3Record.getCriteria36Ql().get(0).getResponse361():"")+"\r\n\r\n",font4));
//	 			table361criteria3.addCell(cell361criteria3);
//	 			table361criteria3.setSpacingAfter(20);
//	 			table361criteria3.setSpacingBefore(20);
//	 			
//	 			document.add(table361criteria3);
//	 			
//	 			
////	 			Paragraph paragraph71113criteria3 = new Paragraph((criteria3Record != null
////	 					? criteria3Record.getCriteria36Ql().get(0).getResponse361():""));
////	 			document.add(paragraph71113criteria3);
//	 			
//	 		//	Paragraph paragraph71142criteria3 = new Paragraph("\r\n");
//	 			
//	 		//	document.add(paragraph71142criteria3);
//
//	 			PdfPTable table19121criteria3 = new PdfPTable(2);
//	 			PdfPTable table1902criteria3 = new PdfPTable(1);
//
//	 			table19121criteria3.setWidthPercentage(100f);
//	 			table1902criteria3.setWidthPercentage(100f);
//
//	 			PdfPCell cell19112criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
//	 			cell19112criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19212criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//	 			cell19212criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19312criteria3 = new PdfPCell(
//	 					new Paragraph("\r\nUpload any additional information\r\n\r\n",font5));
//	 			cell19312criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19412criteria3 = new PdfPCell(
//	 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//	 			cell19412criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19512criteria3 = new PdfPCell(new Paragraph("\r\nPaste link for additional information\r\n\r\n",font5));
//	 			cell19512criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19612criteria3 = new PdfPCell(
//	 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//	 			cell19612criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			table19121criteria3.addCell(cell19112criteria3);
//	 			table19121criteria3.addCell(cell19212criteria3);
//	 			table19121criteria3.addCell(cell19312criteria3);
//	 			table19121criteria3.addCell(cell19412criteria3);
//	 			table19121criteria3.addCell(cell19512criteria3);
//	 			table19121criteria3.addCell(cell19612criteria3);
//	 			table19121criteria3.setSpacingAfter(20);
//	 			table19121criteria3.setSpacingBefore(20);
//	 			
//	 			document.add(table19121criteria3);
//	 			
//	 			
//	 			
//	 			
//	 			
//	 		
//	 			
//	 			PdfPTable table362criteria3 = new PdfPTable(1);	
//	 			table362criteria3.setWidthPercentage(100);
//	 			
//	 			PdfPCell cell362criteria3 = new PdfPCell(new Paragraph(
//	 					"3.6.2: Number of awards and recognition received by the Institution, its teachers and students for extension activities from "
//	 					+ "Government / Government recognised bodies during last five years\r\n\r\n" + "Response: "
//	 							+(criteria3Record != null
//									? criteria3Record.getCriteria36Qn().get(0).getResponse362()
//									: "")+"\r\n\r\n",font4));
//	 			table362criteria3.addCell(cell362criteria3);
//	 			table362criteria3.setSpacingAfter(20);
//	 			table362criteria3.setSpacingBefore(20);
//	 			
//	 			document.add(table362criteria3);
//	 			
////	 			if(criteria3Record.getCriteria36Qn().size()>0)
////	 			{
////	 			Paragraph paragraph7212criteria3 = new Paragraph(criteria3Record != null
////	 									? criteria3Record.getCriteria36Qn().get(0).getResponse362()
////	 									: "");
////	 			document.add(paragraph7212criteria3);
////	 			}
//	 			
//	 			
//	 			PdfPTable table3621criteria3 = new PdfPTable(1);	
//	 			table3621criteria3.setWidthPercentage(100);
//	 			
//	 			PdfPCell cell3621criteria3 = new PdfPCell(new Paragraph(
//	 					"3.6.2.1: Total number of awards and recognition received for extension activities from Government/ Government recognised bodies year-wise during the last five years"
//	 							+"\r\n\r\n",font4));
//	 			table3621criteria3.addCell(cell3621criteria3);
//	 			table3621criteria3.setSpacingAfter(20);
//	 			table3621criteria3.setSpacingBefore(20);
//	 			
//	 			document.add(table3621criteria3);
//	 		//	document.add(paragraph71142criteria3);
//
////	 			table191criteria3.addCell(cell362criteria3);
////	 			table191criteria3.addCell(cell3621criteria3);
////	 			// document.add(cell362criteria3);
////	 			// document.add(cell3621criteria3);
////	 			table191criteria3.setSpacingBefore(20f);
////	 			table191criteria3.setSpacingAfter(20f);
////	 			document.add(table191criteria3);
//
//	 			
//	 			
//	 			
//	 			
//	 			
//	 			
//
//	 			if (criteria3Record.getYearTable3621().size()>0) {
//	 				Table table3721criteria3 = new Table(criteria3Record.getYearTable3621().size(), 2);
//
//	 				table3721criteria3.setPadding(5);
//	 				table3721criteria3.setWidth(100f);
//
//	 				for (int i = 0; i < criteria3Record.getYearTable3621().size(); i++) {
//	 					Cell cell1criteria3721= new Cell (criteria3Record.getYearTable3621().get(i).getInput3621y());
//	 					cell1criteria3721.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 					table3721criteria3.addCell(cell1criteria3721);
//	 					
//
//	 				}
//	 				for (int i = 0; i < criteria3Record.getYearTable3621().size(); i++) {
//	 					Cell cell2criteria3721= new Cell (criteria3Record.getYearTable3621().get(i).getInput3621v());
//	 					cell2criteria3721.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 					table3721criteria3.addCell(cell2criteria3721);
//	 					
//
//	 				}
//
//	 				document.add(table3721criteria3);
//	 			}
//	 			
////	 			document.add(paragraph71142criteria3);
////	 			document.add(paragraph71142criteria3);
//	 			
//	 			PdfPTable table1911criteria3 = new PdfPTable(2);
//	 			PdfPTable table190criteria3 = new PdfPTable(1);
//
//	 			table1911criteria3.setWidthPercentage(100f);
//	 			table190criteria3.setWidthPercentage(100f);
//
//	 			PdfPCell cell1911criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
//	 			cell1911criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell1921criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//	 			cell1921criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell1931criteria3 = new PdfPCell(
//	 					new Paragraph("\r\nAny additional information\r\n\r\n",font5));
//	 			cell1931criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell1941criteria3 = new PdfPCell(
//	 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//	 			cell1941criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell1951criteria3 = new PdfPCell(new Paragraph("\r\nNumber of awards for extension activities in last 5 year\r\n\r\n",font5));
//	 			cell1951criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell1961criteria3 = new PdfPCell(
//	 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//	 			cell1961criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell1971criteria3 = new PdfPCell(new Paragraph("\r\nE-copy of the award letters\r\n\r\n",font5));
//	 			cell1971criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell1981criteria3 = new PdfPCell(
//	 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//	 			cell1981criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			table1911criteria3.addCell(cell1911criteria3);
//	 			table1911criteria3.addCell(cell1921criteria3);
//	 			table1911criteria3.addCell(cell1931criteria3);
//	 			table1911criteria3.addCell(cell1941criteria3);
//	 			table1911criteria3.addCell(cell1951criteria3);
//	 			table1911criteria3.addCell(cell1961criteria3);
//	 			table1911criteria3.addCell(cell1971criteria3);
//	 			table1911criteria3.addCell(cell1981criteria3);
//	 			table1911criteria3.setSpacingAfter(20);
//	 			table1911criteria3.setSpacingBefore(20);
//	 			
//	 			document.add(table1911criteria3);
//	 			
	 			
	 			
	 			
	 			/////////////////////
	 			
//	 			PdfPTable table363criteria3 = new PdfPTable(1);	
//	 			table363criteria3.setWidthPercentage(100);
//	 			
//	 			PdfPCell cell363criteria3 = new PdfPCell(new Paragraph(
//	 					"3.6.3: Number of extension and outreach programs conducted by the institution through NSS/NCC, "
//	 					+ "Government and Government recognised bodies during the last five years" + "Response:"
//	 							+(criteria3Record != null
//									? criteria3Record.getCriteria36Qn().get(0).getResponse363()
//									: "")+"\r\n\r\n",font4));
//	 			table363criteria3.addCell(cell363criteria3);
//	 			table363criteria3.setSpacingAfter(20);
//	 			table363criteria3.setSpacingBefore(20);
//	 			
//	 			document.add(table363criteria3);
//	 			
////	 			if(criteria3Record.getCriteria36Qn() !=null)
////	 			{
////	 			Paragraph paragraph721criteria3 = new Paragraph(criteria3Record != null
////	 									? criteria3Record.getCriteria36Qn().get(0).getResponse363()
////	 									: "");
////	 			document.add(paragraph721criteria3);
////	 			}
//	 	
//	 			PdfPTable table3631criteria3 = new PdfPTable(1);	
//	 			table3631criteria3.setWidthPercentage(100);
//	 			
//	 			PdfPCell cell3631criteria3 = new PdfPCell(new Paragraph(
//	 					"3.6.3.1: Number of extension and outreach programs conducted by the institution through NSS/NCC, "
//	 					+ "Government and Government recognised bodies during the last five years."
//	 							+"\r\n\r\n",font4));
//	 			table3631criteria3.addCell(cell3631criteria3);
//	 			table3631criteria3.setSpacingAfter(20);
//	 			table3631criteria3.setSpacingBefore(20);
//	 			document.add(table3631criteria3);
//
////	 			table191criteria3.addCell(cell362criteria3);
////	 			table191criteria3.addCell(cell3621criteria3);
////	 			// document.add(cell362criteria3);
////	 			// document.add(cell3621criteria3);
////	 			table191criteria3.setSpacingBefore(20f);
////	 			table191criteria3.setSpacingAfter(20f);
////	 			document.add(table191criteria3);
//
//	 			
//	 			
//	 			
//	 		//	document.add(paragraph71142criteria3);
//	 			
//	 			
//
//	 			if (criteria3Record.getYearTable3641().size()>0) {
//	 				Table table3721criteria3 = new Table(criteria3Record.getYearTable3641().size(), 2);
//
//	 				table3721criteria3.setPadding(5);
//	 				table3721criteria3.setWidth(100f);
//
//	 				for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
//	 					Cell cell1criteria3641 = new Cell (criteria3Record.getYearTable3641().get(i).getInput3641y());
//	 					cell1criteria3641.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 					table3721criteria3.addCell(cell1criteria3641);
//	 					
//
//	 				}
//	 				for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
//	 					Cell cell2criteria3641 = new Cell (criteria3Record.getYearTable3641().get(i).getInput3641v());
//	 					cell2criteria3641.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 					table3721criteria3.addCell(cell2criteria3641);
//	 					
//
//	 				}
//
//	 				document.add(table3721criteria3);
//	 			}
//	 			
//	 			
//	 			
//	 			
//	 			PdfPTable table19111criteria3 = new PdfPTable(2);
//	 			PdfPTable table1901criteria3 = new PdfPTable(1);
//
//	 			table19111criteria3.setWidthPercentage(100f);
//	 			table190criteria3.setWidthPercentage(100f);
//
//	 			PdfPCell cell19111criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
//	 			cell19111criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19211criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//	 			cell19211criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19311criteria3 = new PdfPCell(
//	 					new Paragraph("\r\nReports of the event organized\r\n\r\n",font5));
//	 			cell19311criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19411criteria3 = new PdfPCell(
//	 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//	 			cell19411criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19511criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
//	 			cell19511criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19611criteria3 = new PdfPCell(
//	 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//	 			cell19611criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19711criteria3 = new PdfPCell(new Paragraph("\r\nNumber of extension and outreach Programmes conducted with industry, community etc for the last five years\r\n\r\n",font5));
//	 			cell19711criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19811criteria3 = new PdfPCell(
//	 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(0).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//	 			cell19811criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			table19111criteria3.addCell(cell19111criteria3);
//	 			table19111criteria3.addCell(cell19211criteria3);
//	 			table19111criteria3.addCell(cell19311criteria3);
//	 			table19111criteria3.addCell(cell19411criteria3);
//	 			table19111criteria3.addCell(cell19511criteria3);
//	 			table19111criteria3.addCell(cell19611criteria3);
//	 			table19111criteria3.addCell(cell19711criteria3);
//	 			table19111criteria3.addCell(cell19811criteria3);
//	 			table19111criteria3.setSpacingAfter(20);
//	 			table19111criteria3.setSpacingBefore(20);
//	 			
//	 			document.add(table19111criteria3);
//	 			
//	 			
//	 			
//	 			//////////////
//	 			PdfPTable table364criteria3 = new PdfPTable(1);	
//	 			table364criteria3.setWidthPercentage(100);
//	 			
//	 			PdfPCell cell364criteria3 = new PdfPCell(new Paragraph(
//	 					"3.6.4: Average percentage of students participating in extension activities listed at 3.6.3 above during the last five years\r\n\r\n" + "Response: "
//	 			+(criteria3Record != null
//					? criteria3Record.getCriteria36Qn().get(0).getResponse364()
//					: "")+"\r\n\r\n",font4));
//	 			
//	 			table364criteria3.addCell(cell364criteria3);
//	 			table364criteria3.setSpacingAfter(20);
//	 			table364criteria3.setSpacingBefore(20);
//	 			
//	 			document.add(table364criteria3);
//	 			
////	 			if(criteria3Record.getCriteria36Qn() !=null)
////	 			{
////	 			Paragraph paragraph72criteria3 = new Paragraph(criteria3Record != null
////	 									? criteria3Record.getCriteria36Qn().get(0).getResponse364()
////	 									: "");
////	 			document.add(paragraph72criteria3);
////	 			}
//	 	
////	 			Paragraph paragraph73criteria3 = new Paragraph(
////	 					"3.6.2.1 Total number of awards and recognition received for extension activities from Government/ Government recognised bodies year-wise during the last five years."
////	 							);
////	 			document.add(paragraph73criteria3);
//
////	 			table191criteria3.addCell(cell362criteria3);
////	 			table191criteria3.addCell(cell3621criteria3);
////	 			// document.add(cell362criteria3);
////	 			// document.add(cell3621criteria3);
////	 			table191criteria3.setSpacingBefore(20f);
////	 			table191criteria3.setSpacingAfter(20f);
////	 			document.add(table191criteria3);
//
//	 			
//	 			
//	 			
//	 			
//	 			
//	 			
//
//	 			if (criteria3Record.getYearTable3641().size()>0) {
//	 				Table table3721criteria3 = new Table(criteria3Record.getYearTable3641().size(), 2);
//
//	 				table3721criteria3.setPadding(5);
//	 				table3721criteria3.setWidth(100f);
//
//	 				for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
//	 					Cell cell1criteria3641 = new Cell (criteria3Record.getYearTable3641().get(i).getInput3641y());
//	 					cell1criteria3641.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 					table3721criteria3.addCell(cell1criteria3641);
//	 					
//
//	 				}
//	 				for (int i = 0; i < criteria3Record.getYearTable3641().size(); i++) {
//	 					Cell cell2criteria3641 = new Cell (criteria3Record.getYearTable3641().get(i).getInput3641v());
//	 					cell2criteria3641.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 					table3721criteria3.addCell(cell2criteria3641);
//	 					
//
//	 				}
//
//	 				document.add(table3721criteria3);
//	 			}
//	 			
//	 		//	document.add(paragraph71142criteria3);
//	 			
//	 			
//	 			
//	 			PdfPTable table19113criteria3 = new PdfPTable(2);
//	 			PdfPTable table1903criteria3 = new PdfPTable(1);
//
//	 			table19113criteria3.setWidthPercentage(100f);
//	 			table1903criteria3.setWidthPercentage(100f);
//
//	 			PdfPCell cell19113criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
//	 			cell19113criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19213criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//	 			cell19213criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19313criteria3 = new PdfPCell(
//	 					new Paragraph("\r\nNumber of awards for extension activities in last 5 year\r\n\r\n",font5));
//	 			cell19313criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19413criteria3 = new PdfPCell(
//	 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//	 			cell19413criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19513criteria3 = new PdfPCell(new Paragraph("\r\nE-copy of the award letters\r\n\r\n",font5));
//	 			cell19513criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19613criteria3 = new PdfPCell(
//	 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//	 			cell19613criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19713criteria3 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n\r\n",font5));
//	 			cell19713criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			PdfPCell cell19813criteria3 = new PdfPCell(
//	 					new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//	 			cell19813criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//	 			
//	 			table19113criteria3.addCell(cell19113criteria3);
//	 			table19113criteria3.addCell(cell19213criteria3);
//	 			table19113criteria3.addCell(cell19313criteria3);
//	 			table19113criteria3.addCell(cell19413criteria3);
//	 			table19113criteria3.addCell(cell19513criteria3);
//	 			table19113criteria3.addCell(cell19613criteria3);
//	 			table19113criteria3.addCell(cell19713criteria3);
//	 			table19113criteria3.addCell(cell19813criteria3);
//	 			table19113criteria3.setSpacingAfter(20);
//	 			table19113criteria3.setSpacingBefore(20);
//	 			
//	 			document.add(table19113criteria3);
//	 			
				// 3.7
//	 			Paragraph paragraph8criteria3 = new Paragraph("3.7	Collaboration\r\n\r\n", font2);
//				paragraph8criteria3.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//				document.add(paragraph8criteria3);
//				// create table 22 //
//				PdfPTable table22criteria3 = new PdfPTable(2);
//				PdfPTable table221criteria3 = new PdfPTable(1);
//				table22criteria3.setWidthPercentage(100f);
//				table221criteria3.setWidthPercentage(100f);
//
//				
//				PdfPTable table371criteria3 = new PdfPTable(1);	
//				table371criteria3.setWidthPercentage(100);
//	 			
//	 			PdfPCell cell371criteria3 = new PdfPCell(new Paragraph(
//						"3.7.1 Number of Collaborative activities per year for research/ faculty exchange/ student exchange/ internship/ on –the-job training/ project work\r\n"
//								+ "\r\n" + "Response: "
//								+(criteria3Record != null
//								? criteria3Record.getCriteria37Qn().get(0).getResponse371()
//								: "")+"\r\n\r\n",font4));
//	 			table371criteria3.addCell(cell371criteria3);
//	 			table371criteria3.setSpacingAfter(20);
//	 			table371criteria3.setSpacingBefore(20);
//	 			
//				document.add(table371criteria3);
//				
//				
////				Paragraph paragraph8criteria32 = new Paragraph(criteria3Record != null
////										? criteria3Record.getCriteria37Qn().get(0).getResponse371()
////										: "");
////				document.add(paragraph8criteria32);
//				
//				PdfPTable table3711criteria3 = new PdfPTable(1);	
//				table3711criteria3.setWidthPercentage(100);
//	 			
//	 			PdfPCell cell3711criteria3 = new PdfPCell(new Paragraph("3.7.1.1: Total number of Collaborative activities per year for research/ faculty exchange/ student exchange/ "
//	 					+ "internship/ on -the-job training/ project work"+"\r\n\r\n",font4));
//	 			table3711criteria3.addCell(cell3711criteria3);
//	 			table3711criteria3.setSpacingAfter(20);
//	 			table3711criteria3.setSpacingBefore(20);
//	 			
//				document.add(table3711criteria3);
//				
//				if (criteria3Record.getYearTable3711().size()>0) {
//					Table table3721criteria3 = new Table(criteria3Record.getYearTable3711().size(), 2);
//
//					table3721criteria3.setPadding(5);
//					table3721criteria3.setWidth(100f);
//
//					for (int i = 0; i < criteria3Record.getYearTable3711().size(); i++) {
//						Cell cell1criteria3711 = new Cell (criteria3Record.getYearTable3711().get(i).getInput3711y());
//						cell1criteria3711.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table3721criteria3.addCell(cell1criteria3711);
//						
//					}
//					for (int i = 0; i < criteria3Record.getYearTable3711().size(); i++) {
//						Cell cell2criteria3711 = new Cell (criteria3Record.getYearTable3711().get(i).getInput3711v());
//						cell2criteria3711.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table3721criteria3.addCell(cell2criteria3711);
//						
//					}
//
//					document.add(table3721criteria3);
//				}
//				
//				
//				
//				PdfPCell cell221criteria3 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
//				cell221criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				PdfPCell cell222criteria3 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
//				cell222criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				PdfPCell cell223criteria3 = new PdfPCell(
//						new Paragraph("\r\nNumber of Collaborative activities for research, faculty etc \r\n\r\n",font5));
//				cell223criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				PdfPCell cell224criteria3 = new PdfPCell(
//						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(5).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//				cell224criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				PdfPCell cell225criteria3 = new PdfPCell(new Paragraph("\r\nCopies of collaboration\r\n\r\n",font5));
//				cell225criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				PdfPCell cell226criteria3 = new PdfPCell(
//						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
//				cell226criteria3.setHorizontalAlignment(Element.ALIGN_CENTER);
//				
//				table22criteria3.addCell(cell221criteria3);
//				table22criteria3.addCell(cell222criteria3);
//				table22criteria3.addCell(cell223criteria3);
//				table22criteria3.addCell(cell224criteria3);
//				table22criteria3.addCell(cell225criteria3);
//				table22criteria3.addCell(cell226criteria3);
//				
//			//	PdfPCell cell3711criteria3 = new PdfPCell(new Paragraph("" + "", font2));
////				table221criteria3.addCell(cell371criteria3);
//			//	table221criteria3.addCell(cell3711criteria3);
//		//		table221criteria3.addCell(table22criteria3);
//				// document.add(cell371criteria3);
//				// document.add(cell3711criteria3);
//				table22criteria3.setSpacingBefore(20f);
//				table22criteria3.setSpacingAfter(20f);
//				document.add(table221criteria3);
//				document.add(table22criteria3);
//				// create tablle 3711 //
//
//				
//				
//				
//				
//				
//				
//				
////				Paragraph paragraph8criteria312 = new Paragraph(
////						"3.7.1 Number of Collaborative activities per year for research/ faculty exchange/ student exchange/ internship/ on –the-job training/ project work\r\n"
////								+ "\r\n" + "Response: ",font4);
////				document.add(paragraph8criteria312);
////				
////				
////				Paragraph paragraph8criteria322 = new Paragraph(criteria3Record != null
////										? criteria3Record.getCriteria37Qn().get(0).getResponse371()
////										: "");
////				document.add(paragraph8criteria322);
////				
////				Paragraph paragraph8criteria332 = new Paragraph("3.7.1.1: Total number of Collaborative activities per year for research/ faculty exchange/ student exchange/ internship/ on -the-job training/ project work");
////				
////				document.add(paragraph8criteria332);
////				
////				
////				
////				if (criteria3Record.getYearTable3721().size()>0) {
////					Table table3721criteria3 = new Table(criteria3Record.getYearTable3721().size(), 2);
////
////					table3721criteria3.setPadding(5);
////					table3721criteria3.setWidth(100f);
////
////					for (int i = 0; i < criteria3Record.getYearTable3721().size(); i++) {
////						Cell cell1criteria3721 = new Cell (criteria3Record.getYearTable3721().get(i).getInput3721y());
////						cell1criteria3721.setHorizontalAlignment(Element.ALIGN_CENTER);
////						table3721criteria3.addCell(cell1criteria3721);
////						
////					}
////					for (int i = 0; i < criteria3Record.getYearTable3711().size(); i++) {
////						Cell cell2criteria3721 = new Cell (criteria3Record.getYearTable3721().get(i).getInput3721v());
////						cell2criteria3721.setHorizontalAlignment(Element.ALIGN_CENTER);
////						table3721criteria3.addCell(cell2criteria3721);
////						
////
////					}
////
////					document.add(table3721criteria3);
////				}
////				
////				PdfPTable table22criteria31 = new PdfPTable(2);
////				PdfPTable table221criteria31 = new PdfPTable(1);
////				table22criteria31.setWidthPercentage(100f);
////				table221criteria31.setWidthPercentage(100f);
////				
////				PdfPCell cell221criteria31 = new PdfPCell(new Paragraph("\r\nFile Description\r\n\r\n", font4));
////				cell221criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
////				
////				PdfPCell cell222criteria31 = new PdfPCell(new Paragraph("\r\nDocument\r\n\r\n", font4));
////				cell222criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
////				
////				PdfPCell cell223criteria31 = new PdfPCell(
////						new Paragraph("\r\nNumber of Collaborative activities for research, faculty etc \r\n\r\n",font5));
////				cell223criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
////				
////				PdfPCell cell224criteria31 = new PdfPCell(
////						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(3).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
////				cell224criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
////				
////				PdfPCell cell225criteria31 = new PdfPCell(new Paragraph("\r\nCopies of collaboration\r\n\r\n",font5));
////				cell225criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
////				
////				PdfPCell cell226criteria31 = new PdfPCell(
////						new Paragraph("\r\n"+(criteria3Record != null ? criteria3file.get(4).getCriteria3FilePath() : "")+"\r\n\r\n",font5));
////				cell226criteria31.setHorizontalAlignment(Element.ALIGN_CENTER);
////				
////				table22criteria31.addCell(cell221criteria31);
////				table22criteria31.addCell(cell222criteria31);
////				table22criteria31.addCell(cell223criteria31);
////				table22criteria31.addCell(cell224criteria31);
////				table22criteria31.addCell(cell225criteria31);
////				table22criteria31.addCell(cell226criteria31);
////				
////				table221criteria3.setSpacingBefore(20f);
////				table221criteria3.setSpacingAfter(20f);
////				document.add(table22criteria31);
////				
				
				document.close();
			

			


		     
		     
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}
	
	
	

}
