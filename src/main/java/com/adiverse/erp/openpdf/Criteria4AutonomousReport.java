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
import org.springframework.stereotype.Component;

import com.adiverse.erp.model.Criteria4_FieldInfo;
import com.adiverse.erp.model.Criteria4_FileUpload;
import com.adiverse.erp.service.Criteria4Service;
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
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


@Component
public class Criteria4AutonomousReport {
	
	public Font font1 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font3 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	public Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
	public Font font5 = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	
	
	@Autowired
	Criteria4Service service4;
	
	
	
	
	
	@Value("${upload.files.path}")
	private String reportGeneratePath;
	
	

	List<Criteria4_FieldInfo> criteria4List = null;
	Criteria4_FieldInfo criteria4Record = null;
	List<Criteria4_FileUpload> criteria4file = null;
	

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
//			allParams.put("collegeId",criteria4Fieldinfo.getCriteriaId().getCollegeId() );
//			allParams.put("financialYear",criteria4Fieldinfo.getCriteriaId().getFinancialYear() );
//			allParams.put("typeofInstitution", criteria4Fieldinfo.getCriteriaId().getTypeofInstitution());
			
			
			criteria4List = service4.getAllCriteria4Data(allParams);
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("criteria4list"+mapper.writeValueAsString(criteria4List));
			if (CollectionUtils.isNotEmpty(criteria4List)) {
				criteria4Record = criteria4List.get(0);
				criteria4file = criteria4Record.getCriteria4FileUpload();
			} else {
				criteria4Record = new Criteria4_FieldInfo();
				//criteria4file = new ArrayList<>();
			}


			System.out.println("report generation path from property file ==>" + reportGeneratePath);
			if (root != null) {
				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
				String strDate = formatter.format(date);
				reportPath = "AuthonomousCriteria4Report-" + strDate + ".pdf";
				file = root.resolve(reportPath);
			}
			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
				
			
		
			Document document = new Document(PageSize.A4);
			// PdfWriter.getInstance(document, response.getOutputStream());
			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
			
			document.open();
			System.out.println("open the document==========>");
	
			
			
			

			Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources", font1);
			paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph1criteria4);

			Paragraph paragraph1linecriteria4 = new Paragraph("___________________________________________________________________________");
			paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph1linecriteria4);


		

			Paragraph paragraph2criteria4 = new Paragraph("4.1 Physical Facilities \r\n\r\n", font2);
			paragraph2criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph2criteria4);

		

	//		Paragraph paragraph4criteria4 = new Paragraph("Response:", font3);

			PdfPTable table411criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table411criteria4.setWidthPercentage(100);

			
	


			table411criteria4.setSpacingBefore(20f);
			table411criteria4.setSpacingAfter(20f);

		//	paragraph4criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);


			PdfPTable table2 = new PdfPTable(2);
			PdfPTable table21 = new PdfPTable(1);
			table2.setWidthPercentage(100);
			table21.setWidthPercentage(100);
			

			PdfPCell cell001criteria4 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
			cell001criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(cell001criteria4);
			PdfPCell cell002criteria4 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell002criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(cell002criteria4);
			PdfPCell cell003criteria4 = new PdfPCell(new Paragraph("Upload Any additional information\r\n\r\n ",font5));
			cell003criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table2.addCell(cell003criteria4);
			
			if(criteria4file.size() > 0)
			{
			PdfPCell cell004criteria4 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell004criteria4.setExtraParagraphSpace(20);
			cell004criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table2.addCell(cell004criteria4);
		}
			PdfPCell cell005criteria4 = new PdfPCell(new Paragraph("paste link for additional information\r\n\r\n",font5));
			cell005criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell006criteria4 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell006criteria4.setExtraParagraphSpace(20);
			cell006criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
			table2.addCell(cell005criteria4);
			table2.addCell(cell006criteria4);
			
			if( criteria4Record.getCriteria41Ql()!=null) {
				PdfPCell cell0011criteria4 = new PdfPCell(new Paragraph(
			  "4.1.1 The Institution has adequate infrastructure and other facilities \r\n"
			  + "for \r\n"
			  + "a. teaching – learning, viz., classrooms, laboratories, computing \r\n"
			  + "equipment etc\r\n"
			  + "b. ICT – enabled facilities such as smart class, LMS etc. \r\n"
			  + "c. Facilities for Cultural and sports activities, yoga centre, \r\n"
			  + "games (indoor and outdoor), Gymnasium, auditorium etc."
			  + "\r\n" + "Response: " + (criteria4Record != null ?
			  criteria4Record.getCriteria41Ql().get(0).getResponse411() : "")+"\r\n\r\n",font4));
				table21.addCell(cell0011criteria4);
			
			}
			
			

			table2.setSpacingBefore(20f);
			table2.setSpacingAfter(20f);

			document.add(table21);
			document.add(table2);
//
//			Paragraph paragraph13criteria4 = new Paragraph(
//					"4.1.2 The institution has adequate facilities for cultural activities, yoga, games and sports (indoor & outdoor); (gymnasium, yoga centre, auditorium, etc.,)",
//					font3);
//			paragraph13criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//
//			Paragraph paragraph24criteria4 = new Paragraph("The open lawns facilitate the following:", font5);
//			paragraph24criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph241 = new Paragraph(" ", font5);
//			paragraph241.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet1criteria4 = new Chunk("\u2022", font5);
//			paragraph241.add(bullet1criteria4);
//
//			paragraph241.add(new Phrase("College day: VIBGYOR, VIBES\r\n" + "\r\n", font5));
//			paragraph241.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph242 = new Paragraph(" ", font5);
//			paragraph242.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet2criteria4 = new Chunk("\u2022", font5);
//			paragraph242.add(bullet2criteria4);
//
//			paragraph242.add(new Phrase("Yoga\r\n" + "\r\n", font5));
//
//			paragraph242.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph243 = new Paragraph(" ", font5);
//			paragraph243.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet3criteria4 = new Chunk("\u2022", font5);
//			paragraph243.add(bullet3criteria4);
//
//			paragraph243.add(new Phrase("Regional and National festivals of importance\r\n", font5));
//
//			paragraph243.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph244 = new Paragraph(" ", font5);
//			paragraph244.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet4criteria4 = new Chunk("\u2022", font5);
//			paragraph244.add(bullet4criteria4);
//
//			paragraph244.add(new Phrase(" Alumni association meet\r\n", font5));
//
//			paragraph244.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph245 = new Paragraph(" ", font5);
//			paragraph245.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet5criteria4 = new Chunk("\u2022", font5);
//			paragraph245.add(bullet5criteria4);
//
//			paragraph245.add(new Phrase("Mother Teresa family get together\r\n" + "\r\n", font5));
//
//			paragraph245.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			Paragraph paragraph246 = new Paragraph(" ", font5);
//			paragraph246.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Chunk bullet6criteria4 = new Chunk("\u2022", font5);
//			paragraph246.add(bullet6criteria4);
//
//			paragraph246.add(new Phrase("Football practice\r\n" + "\r\n", font5));
//
//			paragraph246.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph21 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph21.setSize(12);
//			 */
//
//			Paragraph paragraph25criteria4 = new Paragraph(
//					"Institution allocates one/two-hour time slots in Timetable encouraging students participation in sports thereby inculcating sporting spirit in them and they understand that winning & losing are part of life. Transportation is arranged for students participating in sports and games beyond working hours to reach their homes. It�s the institution�s conviction that holistic development of a student is only possible, when students participate in several cultural, literary and sports activities over and above their academics. Mother Teresates won several laurels in State Under-19 competitions in many sports events in the past few years. ",
//					font5);
//			paragraph25criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph22criteria4 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph22criteria4.setSize(12);
//			 */
//
//			Paragraph paragraph26criteria4 = new Paragraph("Details of the facility created/r/n ", font3);
//			paragraph26criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph13criteria4);
////			document.add(paragraph14criteria4);
////			document.add(paragraph15criteria4);
//			document.add(paragraph24criteria4);
//			document.add(paragraph241);
//			document.add(paragraph242);
//			document.add(paragraph243);
//			document.add(paragraph244);
//			document.add(paragraph245);
//			document.add(paragraph246);
//			document.add(paragraph25criteria4);
//			document.add(paragraph26criteria4);
//
//			// Creating a table of columns
//			PdfPTable table3criteria4 = new PdfPTable(4);
//
//			// Setting width of table, its columns and spacing
//			table3criteria4.setWidthPercentage(100);
//
//			PdfPCell cell101criteria4 = new PdfPCell(new Paragraph("Facility", font3));
//			PdfPCell cell102criteria4 = new PdfPCell(new Paragraph("Year of creation", font3));
//			PdfPCell cell103criteria4 = new PdfPCell(new Paragraph("Area in Sqm", font3));
//			PdfPCell cell104criteria4 = new PdfPCell(new Paragraph(" Year facility enhanced", font3));
//			PdfPCell cell105criteria4 = new PdfPCell(new Paragraph("Volleyball "));
//			PdfPCell cell106criteria4 = new PdfPCell(new Paragraph(" 2005"));
//			PdfPCell cell107criteria4 = new PdfPCell(new Paragraph("162	"));
//			PdfPCell cell108criteria4 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell109 = new PdfPCell(new Paragraph("Basketball"));
//			PdfPCell cell1010 = new PdfPCell(new Paragraph("2005"));
//			PdfPCell cell1011 = new PdfPCell(new Paragraph("436  "));
//			PdfPCell cell1012 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1013 = new PdfPCell(new Paragraph("Throwball "));
//			PdfPCell cell1014 = new PdfPCell(new Paragraph("	2005 "));
//			PdfPCell cell1015 = new PdfPCell(new Paragraph("	222	"));
//			PdfPCell cell1016 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1017 = new PdfPCell(new Paragraph("Cricket	"));
//			PdfPCell cell1018 = new PdfPCell(new Paragraph("2005 "));
//			PdfPCell cell1019 = new PdfPCell(new Paragraph("3600 "));
//			PdfPCell cell1020 = new PdfPCell(new Paragraph("2016  "));
//			PdfPCell cell1021 = new PdfPCell(new Paragraph("Kabaddi "));
//			PdfPCell cell1022 = new PdfPCell(new Paragraph("	2005"));
//			PdfPCell cell1023 = new PdfPCell(new Paragraph("130"));
//			PdfPCell cell1024 = new PdfPCell(new Paragraph("2020 "));
//			PdfPCell cell1025 = new PdfPCell(new Paragraph("Cricket-net practice"));
//			PdfPCell cell1026 = new PdfPCell(new Paragraph("2020 "));
//			PdfPCell cell1027 = new PdfPCell(new Paragraph("74 "));
//			PdfPCell cell1028 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1029 = new PdfPCell(new Paragraph("Indoor Sports (Carroms Table-Tennis, Chess etc.)"));
//			PdfPCell cell1030 = new PdfPCell(new Paragraph("2005 "));
//			PdfPCell cell1031 = new PdfPCell(new Paragraph("219"));
//			PdfPCell cell1032 = new PdfPCell(new Paragraph("2020"));
//			PdfPCell cell1033 = new PdfPCell(new Paragraph("Yoga center"));
//			PdfPCell cell1034 = new PdfPCell(new Paragraph("2016 "));
//			PdfPCell cell1035 = new PdfPCell(new Paragraph("89 "));
//			PdfPCell cell1036 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1037 = new PdfPCell(new Paragraph("Open-air Auditorium	"));
//			PdfPCell cell1038 = new PdfPCell(new Paragraph("2005 "));
//			PdfPCell cell1039 = new PdfPCell(new Paragraph("3310  "));
//			PdfPCell cell1040 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1041 = new PdfPCell(new Paragraph("Block -1 (II-floor) Air conditioned Seminar Hall)"));
//			PdfPCell cell1042 = new PdfPCell(new Paragraph("	2006 "));
//			PdfPCell cell1043 = new PdfPCell(new Paragraph("263	 "));
//			PdfPCell cell1044 = new PdfPCell(new Paragraph("	2019 (Modernized) "));
//			PdfPCell cell1045 = new PdfPCell(new Paragraph("Auditorium Air-conditioned"));
//			PdfPCell cell1046 = new PdfPCell(new Paragraph("2019 "));
//			PdfPCell cell1047 = new PdfPCell(new Paragraph("287 "));
//			PdfPCell cell1048 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1049 = new PdfPCell(new Paragraph("Block -3 Seminar Hall "));
//			PdfPCell cell1050 = new PdfPCell(new Paragraph("2018 "));
//			PdfPCell cell1051 = new PdfPCell(new Paragraph("	137"));
//			PdfPCell cell1052 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell1053 = new PdfPCell(new Paragraph("Foot Ball Ground"));
//			PdfPCell cell1054 = new PdfPCell(new Paragraph("2005 "));
//			PdfPCell cell1055 = new PdfPCell(new Paragraph("	4050 "));
//			PdfPCell cell1056 = new PdfPCell(new Paragraph("2020 "));
//
//			table3criteria4.addCell(cell101criteria4);
//			table3criteria4.addCell(cell102criteria4);
//			table3criteria4.addCell(cell103criteria4);
//			table3criteria4.addCell(cell104criteria4);
//			table3criteria4.addCell(cell105criteria4);
//			table3criteria4.addCell(cell106criteria4);
//			table3criteria4.addCell(cell107criteria4);
//			table3criteria4.addCell(cell108criteria4);
//			table3criteria4.addCell(cell109);
//			table3criteria4.addCell(cell1010);
//			table3criteria4.addCell(cell1011);
//			table3criteria4.addCell(cell1012);
//			table3criteria4.addCell(cell1013);
//			table3criteria4.addCell(cell1014);
//			table3criteria4.addCell(cell1015);
//			table3criteria4.addCell(cell1016);
//			table3criteria4.addCell(cell1017);
//			table3criteria4.addCell(cell1018);
//			table3criteria4.addCell(cell1019);
//			table3criteria4.addCell(cell1020);
//			table3criteria4.addCell(cell1021);
//			table3criteria4.addCell(cell1022);
//			table3criteria4.addCell(cell1023);
//			table3criteria4.addCell(cell1024);
//			table3criteria4.addCell(cell1025);
//			table3criteria4.addCell(cell1026);
//			table3criteria4.addCell(cell1027);
//			table3criteria4.addCell(cell1028);
//			table3criteria4.addCell(cell1029);
//			table3criteria4.addCell(cell1030);
//			table3criteria4.addCell(cell1031);
//			table3criteria4.addCell(cell1032);
//			table3criteria4.addCell(cell1033);
//			table3criteria4.addCell(cell1034);
//			table3criteria4.addCell(cell1035);
//			table3criteria4.addCell(cell1036);
//			table3criteria4.addCell(cell1037);
//			table3criteria4.addCell(cell1038);
//			table3criteria4.addCell(cell1039);
//			table3criteria4.addCell(cell1040);
//			table3criteria4.addCell(cell1041);
//			table3criteria4.addCell(cell1042);
//			table3criteria4.addCell(cell1043);
//			table3criteria4.addCell(cell1044);
//			table3criteria4.addCell(cell1045);
//			table3criteria4.addCell(cell1046);
//			table3criteria4.addCell(cell1047);
//			table3criteria4.addCell(cell1048);
//			table3criteria4.addCell(cell1049);
//			table3criteria4.addCell(cell1050);
//			table3criteria4.addCell(cell1051);
//			table3criteria4.addCell(cell1052);
//			table3criteria4.addCell(cell1053);
//			table3criteria4.addCell(cell1054);
//			table3criteria4.addCell(cell1055);
//			table3criteria4.addCell(cell1056);
//
//			table3criteria4.setSpacingBefore(20f);
//			table3criteria4.setSpacingAfter(20f);
//
////			document.add(table3criteria4);

			// Creating a table of 3 columns
			PdfPTable table4criteria4 = new PdfPTable(2);
			PdfPTable table412criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table4criteria4.setWidthPercentage(100);
			table412criteria4.setWidthPercentage(100);

			PdfPCell cell007 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
			cell007.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table4criteria4.addCell(cell007);
			
			PdfPCell cell008 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell008.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4criteria4.addCell(cell008);
			PdfPCell cell0009 = new PdfPCell(new Paragraph(" Upload Any additional information\r\n\r\n", font5));
			cell0009.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4criteria4.addCell(cell0009);
			if(criteria4file.size() >0)
			{
			PdfPCell cell0010 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : "", font5));
			cell0010.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4criteria4.addCell(cell0010);
			}
			PdfPCell cell0011 = new PdfPCell(new Paragraph("Geotagged pictures\r\n\r\n", font5));
			cell0011.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4criteria4.addCell(cell0011);
			if(criteria4file.size() >0)
			{
			PdfPCell cell0012 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(2).getCriteria4FilePath() : "", font5));
			cell0012.setHorizontalAlignment(Element.ALIGN_CENTER);
			table4criteria4.addCell(cell0012);
			}
			PdfPCell cell0013 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n", font5));
			cell0013.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0014 = new PdfPCell(new Paragraph(""));
			cell0014.setHorizontalAlignment(Element.ALIGN_CENTER);

			table4criteria4.addCell(cell0013);
			table4criteria4.addCell(cell0014);

			PdfPCell cell412criteria4 = new PdfPCell(new Paragraph(
					"4.1.2 Percentage of expenditure for infrastructure development and \r\n"
					+ "augmentation excluding salary during the last five years\r\n"
							+ "\r\n\r\n" + "Response:"
							+ (criteria4Record != null
									? criteria4Record.getCriteria41Ql().get(0).getResponse412()
									: "")+"\r\n\r\n",
					font4));
			PdfPCell cell4102criteria4 = new PdfPCell(new Paragraph(
					"4.1.2.1: Expenditure for infrastructure development and \r\n"
					+ "augmentation, excluding salary year wise during last five years (INR \r\n"
					+ "in lakhs)\r\n"
							+ "\r\n\r\n" ,
					font4));

			table412criteria4.addCell(cell412criteria4);
			table412criteria4.addCell(cell4102criteria4);
			
//			table412criteria4.addCell(table4criteria4);
			table412criteria4.setSpacingBefore(20f);
			table412criteria4.setSpacingAfter(20f);

			document.add(table412criteria4);
			document.add(table4criteria4);


			// Creating a table of columns
			PdfPTable table5criteria4 = new PdfPTable(2);
			PdfPTable table51 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table5criteria4.setWidthPercentage(100);
			table51.setWidthPercentage(100);

			PdfPCell cell0015 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n", font4));
			cell0015.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5criteria4.addCell(cell0015);
			PdfPCell cell0016 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell0016.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5criteria4.addCell(cell0016);
			PdfPCell cell0017 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
			cell0017.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5criteria4.addCell(cell0017);
			if(criteria4file.size() >0)
			{
			PdfPCell cell0018 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell0018.setExtraParagraphSpace(20);
			cell0018.setHorizontalAlignment(Element.ALIGN_CENTER);
			table5criteria4.addCell(cell0018);
			}
			
			
//			PdfPCell cell0019 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
//			table5criteria4.addCell(cell0019);
//			if(criteria4file.size() >0)
//			{
//			PdfPCell cell0020 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			table5criteria4.addCell(cell0020);
//			}
//			PdfPCell cell0021 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n"));
//			PdfPCell cell0022 = new PdfPCell(new Paragraph());
//
//			table5criteria4.addCell(cell0021);
//			table5criteria4.addCell(cell0022);

//			PdfPCell cell000318 = new PdfPCell(
//					new Paragraph(
//					"4.1.3 Percentage of classrooms and seminar halls with ICT- enabled facilities such as smart class, LMS, etc. (Data for the latest completed academic year)\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria41Ql().get(0).getResponse413()
//									: ""),font4));

//			PdfPCell cell00218 = new PdfPCell(
//					new Paragraph("4.1.3.1 Number of classrooms and seminar halls with ICT facilities\r\n" + "\r\n\r\n" + "Response: "
//					+ (criteria4Record != null ? criteria4Record.getCriteria41Ql().get(0).getInput413t1() : ""),font4));
//
//			// table51.addCell(criteria4List.get(0).getResponseValue413());
//			table51.addCell(cell000318);
//			table51.addCell(cell00218);
			
//			table51.addCell(table5criteria4);

			table51.setSpacingBefore(20f);
			table51.setSpacingAfter(20f);

			//document.add(table51);
			document.add(table5criteria4);

			// Creating a table of 3 columns
			PdfPTable table6criteria4 = new PdfPTable(5);
			PdfPTable table61criteria4 = new PdfPTable(1);

		
			table6criteria4.setWidthPercentage(100);
			table61criteria4.setWidthPercentage(100);


//			PdfPCell cell000118 = new PdfPCell(
//					new Paragraph(
//					"4.1.4 Average percentage of expenditure for infrastructure augmentation excluding salary during the last five years (INR in Lakhs)\r\n"
//							+ "\r\n\r\n" + "Response: "
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria41Ql().get(0).getResponse414()
//									: ""),font4));
//
//			// table61criteria4.addCell(criteria4List.get(0).getResponseValue414());
//
//			PdfPCell cell001118 = new PdfPCell(
//							new Paragraph(
//					"4.1.4.1 Expenditure for infrastructure augmentation, excluding salary year-wise during last five years (INR in lakhs)\r\n\r\n",font4));
//
//			// table61.addCell(table6);
//			table61criteria4.addCell(cell000118);
//			table61criteria4.addCell(cell001118);
//			

			table61criteria4.setSpacingBefore(20f);
			table61criteria4.setSpacingAfter(20f);

			//document.add(table61criteria4);
			//document.add(table6criteria4);


//			if (criteria4Record.getYearTable4141() != null) {
//
//				Table table4141 = new Table(criteria4Record.getYearTable4141().size(), 2);
//
//				table4141.setPadding(5);
//				table4141.setWidth(100f);
//
//				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
//					
//					Cell cell021criteria4 = new Cell(new Paragraph(criteria4Record.getYearTable4141().get(i).getInput4141y(),font5));
//					cell021criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table4141.addCell(cell021criteria4);
//
//				}
//				for (int i = 0; i < criteria4Record.getYearTable4141().size(); i++) {
//					Cell cell022criteria4 = new Cell(new Paragraph(criteria4Record.getYearTable4141().get(i).getInput4141v(),font5));
//					cell022criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table4141.addCell(cell022criteria4);
//
//				}
//
//				document.add(table4141);
//			}

			// Creating a table of 3 columns
			PdfPTable table7criteria4 = new PdfPTable(2);

			// Setting width of table, its columns and spacing
			table7criteria4.setWidthPercentage(100);

			PdfPCell cell0033 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n",font4));
			cell0033.setHorizontalAlignment(Element.ALIGN_CENTER);
			table7criteria4.addCell(cell0033);
			
			PdfPCell cell0034 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
			cell0034.setHorizontalAlignment(Element.ALIGN_CENTER);
			table7criteria4.addCell(cell0034);
			PdfPCell cell0035 = new PdfPCell(
					new Paragraph("Upload any additional information\r\n\r\n ",font5));
			cell0035.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			table7criteria4.addCell(cell0035);
            if(criteria4file.size() >0)
            {
			PdfPCell cell0036 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell0036.setExtraParagraphSpace(20);
			cell0036.setHorizontalAlignment(Element.ALIGN_CENTER);
			table7criteria4.addCell(cell0036);
            }
			PdfPCell cell0037 = new PdfPCell(new Paragraph("Upload audited utilization statements\r\n\r\n",font5));
			cell0037.setHorizontalAlignment(Element.ALIGN_CENTER);
			table7criteria4.addCell(cell0037);
			 if(criteria4file.size() >0)
	            {
			PdfPCell cell0038 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell0038.setExtraParagraphSpace(20);
			cell0038.setHorizontalAlignment(Element.ALIGN_CENTER);
			table7criteria4.addCell(cell0038);
	            }
			PdfPCell cell0039 = new PdfPCell(new Paragraph("Upload Details of Expenditure, excluding salary during the last five years\r\n\r\n",font5));
			cell0039.setHorizontalAlignment(Element.ALIGN_CENTER);
			table7criteria4.addCell(cell0039);
			PdfPCell cell0040 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell0040.setExtraParagraphSpace(20);
			cell0040.setHorizontalAlignment(Element.ALIGN_CENTER);

			table7criteria4.addCell(cell0040);

			table7criteria4.setSpacingBefore(20f);
			table7criteria4.setSpacingAfter(20f);

			//document.add(table7criteria4);

			/*
			 * Font fontParagraph27 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph27.setSize(12);
			 */

			
			
			
			///////cr4.2
			

			Paragraph paragraph31criteria4 = new Paragraph("4.2 Library as a Learning Resource \r\n\r\n", font2);
			paragraph31criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
           document.add(paragraph31criteria4);
		

           
//           
//			Paragraph paragraph32criteria4 = new Paragraph(
//					"4.2.1	Library is automated using Integrated Library Management System (ILMS)\r\n" + "Response",
//					font2);
//			paragraph32criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			PdfPTable table421criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table421criteria4.setWidthPercentage(100);
//
			PdfPCell cell00400 = new PdfPCell(new Paragraph(
					"4.2.1 Library is automated with digital facilities using Integrated Library \r\n"
					+ "Management System (ILMS), adequate subscriptions to e-resources \r\n"
					+ "and journals are made. The library is optimally used by the faculty \r\n"
					+ "and students\r\n\r\n Response:"
							+ (criteria4Record != null
									? criteria4Record.getCriteria42Ql().get(0).getResponse421()
									: "")+"\r\n\r\n",font4));
			// table421criteria4.addCell(criteria4List.get(3).getResponseValue421());
			table421criteria4.addCell(cell00400);
//			document.add(table421criteria4);

			table421criteria4.setSpacingBefore(20f);
			table421criteria4.setSpacingAfter(20f);
			document.add(table421criteria4);

		
			PdfPTable table8criteria4 = new PdfPTable(2);
//			font6criteria4.setColor(CMYKColor.BLACK);
			// Setting width of table, its columns and spacing
			table8criteria4.setWidthPercentage(100);

			PdfPCell cell0041 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n",font4));
			cell0041.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0042 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
			cell0042.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0043 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
			cell0043.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0044 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(7).getCriteria4FilePath() : "",font5));

			cell0044.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0045 = new PdfPCell(new Paragraph("Paste Link for additional information\r\n\r\n ",font5));
			cell0045.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0046 = new PdfPCell(new Paragraph(" ",font5));
			cell0046.setHorizontalAlignment(Element.ALIGN_CENTER);

			table8criteria4.addCell(cell0041);
			table8criteria4.addCell(cell0042);
			table8criteria4.addCell(cell0043);
			table8criteria4.addCell(cell0044);
			table8criteria4.addCell(cell0045);
			table8criteria4.addCell(cell0046);

			table8criteria4.setSpacingBefore(20f);
			table8criteria4.setSpacingAfter(20f);
			document.add(table8criteria4);

			// Creating a table of 3 columns
			PdfPTable table9criteria4 = new PdfPTable(2);
			PdfPTable table10criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table9criteria4.setWidthPercentage(100);
			table10criteria4.setWidthPercentage(100);

			PdfPCell cell0047 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n",font4));
			cell0047.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0048 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4 ));
			cell0048.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0049 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
			cell0049.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0050 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell0050.setExtraParagraphSpace(20);
			cell0050.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0051 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n",font5));
			cell0051.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0052 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell0052.setExtraParagraphSpace(20);
			cell0052.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0053 = new PdfPCell(new Paragraph(
					"Details of subscriptions like e-journals, e-books , e- ShodhSindhu, Shodhganga Membership etc\r\n\r\n",font5));
			cell0053.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0054 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell0054.setExtraParagraphSpace(20);
			cell0054.setHorizontalAlignment(Element.ALIGN_CENTER);


			table9criteria4.addCell(cell0047);
			table9criteria4.addCell(cell0048);
			table9criteria4.addCell(cell0049);
			table9criteria4.addCell(cell0050);
			table9criteria4.addCell(cell0051);
			table9criteria4.addCell(cell0052);
			table9criteria4.addCell(cell0053);
			table9criteria4.addCell(cell0054);
			
			
            if(criteria4Record.getCriteria42Qn()!=null) {
            	PdfPCell cell00540 = new PdfPCell(
    					new Paragraph(
					"4.2.2 Percentage of expenditure for purchase of books/ e-books and \r\n"
					+ "subscription to journals/e-journals during the last five years"
							 + "Response:"
							+ (criteria4Record != null
									? criteria4Record.getCriteria42Qn().get(0).getResponse422()
									: "")+"\r\n\r\n",font4));
            	
            	PdfPCell cell005040 = new PdfPCell(
    					new Paragraph(
					"4.2.2.1: Expenditure for purchase of books / e-books and subscription \r\n"
					+ "to journals/e-journals year wise during last five years (INR in lakhs)\r\n\r\n",font4));
            	
			table10criteria4.addCell(cell00540);
			table10criteria4.addCell(cell005040);

			table10criteria4.setSpacingBefore(20f);
			table10criteria4.setSpacingAfter(20f);

			document.add(table10criteria4);
			document.add(table9criteria4);
}
            
            
//            if (criteria4Record.getAffiliatedYearTable4121() != null) {
//            	
//          					Table table4121 = new Table(criteria4Record.getAffiliatedYearTable4121().size(), 2);
//          					table4121.setPadding(5);
//          					table4121.setWidth(100f);
//            
//           					for (int i = 0; i < criteria4Record.getAffiliatedYearTable4121().size(); i++) {
//          						
//          					Cell cell1criteria4 = new Cell(new Paragraph(criteria4Record.getAffiliatedYearTable4121().get(i).getInput4121y(),font5));           						cell1criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
//          					table4121.addCell(cell1criteria4);
//                        					}
//           					for (int i = 0; i < criteria4Record.getAffiliatedYearTable4121().size(); i++) {
//           						Cell cell12criteria4 = new Cell(new Paragraph(criteria4Record.getAffiliatedYearTable4121().get(i).getInput4121v(),font5));
//          						cell12criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
//          						table4121.addCell(cell12criteria4);
//            					}
//            	
//        				//	document.add(table4121);
//           				}
//            
            
            
            
            
			// Creating a table of 3 columns
//			PdfPTable table11criteria4 = new PdfPTable(5);
//			PdfPTable table12criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table11criteria4.setWidthPercentage(100);
//			table12criteria4.setWidthPercentage(100);

//			PdfPCell cell0055 = new PdfPCell(new Paragraph("2020-21"));
//			PdfPCell cell0056 = new PdfPCell(new Paragraph("2019-20"));
//			PdfPCell cell0057 = new PdfPCell(new Paragraph("2018-19"));
//			PdfPCell cell0058 = new PdfPCell(new Paragraph("2017-18"));
//			PdfPCell cell0059 = new PdfPCell(new Paragraph("2016-17"));
//			PdfPCell cell0060 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell0061 = new PdfPCell(new Paragraph(""));
//			PdfPCell cell0062 = new PdfPCell(new Paragraph(" "));
//			PdfPCell cell0063 = new PdfPCell(new Paragraph(""));
//			PdfPCell cell0064 = new PdfPCell(new Paragraph(" "));
//
//			table11criteria4.addCell(cell0055);
//			table11criteria4.addCell(cell0056);
//			table11criteria4.addCell(cell0057);
//			table11criteria4.addCell(cell0058);
//			table11criteria4.addCell(cell0059);
//			table11criteria4.addCell(cell0060);
//			table11criteria4.addCell(cell0061);
//			table11criteria4.addCell(cell0062);
//			table11criteria4.addCell(cell0063);
//			table11criteria4.addCell(cell0064);

//			PdfPCell cell005401 = new PdfPCell(
//					new Paragraph(
//					"4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n\r\n"
//							 + "Response: "
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria42Qn().get(0).getResponse423()
//									: "")+"\r\n\r\n",font4));
//
//					PdfPCell cell005402 = new PdfPCell(
//	    					new Paragraph(
//					"4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)"
//							+ "\r\n\r\n",font4));
//					table12criteria4.addCell(cell005401);
//					table12criteria4.addCell(cell005402);
//			// table12.addCell(table11);
//
//			table12criteria4.setSpacingBefore(20f);
//			table12criteria4.setSpacingAfter(20f);
//
//			document.add(table12criteria4);
//			document.add(table11criteria4);
//
//			if (criteria4Record.getYearTable4231() != null) {
//
//				Table table4231 = new Table(criteria4Record.getYearTable4231().size(), 2);
//
//				table4231.setPadding(5);
//				table4231.setWidth(100f);
//
//				for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
//					
//					
//					Cell cell1criteria4 = new Cell(new Paragraph(criteria4Record.getYearTable4231().get(i).getInput4231y(),font5));
//					cell1criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table4231.addCell(cell1criteria4);
//
//				}
//				for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
//					Cell cell12criteria4 = new Cell(new Paragraph(criteria4Record.getYearTable4231().get(i).getInput4231v(),font5));
//					cell12criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
//					table4231.addCell(cell12criteria4);
//				}
//
//				document.add(table4231);
//			}
//
//			// Creating a table of 3 columns
//
//			PdfPTable table13 = new PdfPTable(2);
//
//			// Setting width of table, its columns and spacing
//			table13.setWidthPercentage(100);
//
//			PdfPCell cell0065 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4 ));
//			cell0065.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell0066 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
//			cell0066.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell0067 = new PdfPCell(new Paragraph(
//					"Details of annual expenditure for purchase of and subscription to journals/e-journals during the last five years\r\n\r\n",font5));
//			cell0067.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell0068 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));.setExtraParagraphSpace(20);
//			cell0068.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell0069 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n",font5));
//			cell0069.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell0070 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));.setExtraParagraphSpace(20);
//			cell0070.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell0071 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n",font5));
//			cell0071.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell0072 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));.setExtraParagraphSpace(20);
//			cell0072.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//			table13.addCell(cell0065);
//			table13.addCell(cell0066);
//			table13.addCell(cell0067);
//			table13.addCell(cell0068);
//			table13.addCell(cell0069);
//			table13.addCell(cell0070);
//			table13.addCell(cell0071);
//			table13.addCell(cell0072);
//
//			table13.setSpacingBefore(20f);
//			table13.setSpacingAfter(20f);
//
//			document.add(table13);

			// Creating a table of 3 columns
//			PdfPTable table14criteria4 = new PdfPTable(2);
//			PdfPTable table15 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table14criteria4.setWidthPercentage(100);
//			table15.setWidthPercentage(100);
//
//			PdfPCell cell0075 = new PdfPCell(new Paragraph("File Description\r\n\r\n",font4));
//			cell0075.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell0076 = new PdfPCell(new Paragraph("Document\r\n\r\n",font4));
//			cell0076.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell0077 = new PdfPCell(new Paragraph("Details of library usage by teachers and students\r\n\r\n",font5));
//			cell0077.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell0078 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));.setExtraParagraphSpace(20);
//			cell0078.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell0079 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n"));
//			cell0079.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cell0080 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));.setExtraParagraphSpace(20);
//			cell0080.setHorizontalAlignment(Element.ALIGN_CENTER);
//
//			table14criteria4.addCell(cell0075);
//			table14criteria4.addCell(cell0076);
//			table14criteria4.addCell(cell0077);
//			table14criteria4.addCell(cell0078);
//			table14criteria4.addCell(cell0079);
//			table14criteria4.addCell(cell0080);
//
//			PdfPCell cell00801 = new PdfPCell(
//					new Paragraph(
//					"4.2.4 Percentage per day usage of library by teachers and students ( foot falls and login data for online access) during the latest completed academic year\r\n"
//							+ "\r\n\r\n" + "Response: "
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria42Qn().get(0).getResponse424()
//									: "")+"\r\n\r\n",font4));
//
//
//			PdfPCell cell008013 = new PdfPCell(
//					new Paragraph("4.2.4.1 Number of teachers and students using library per day over last one year\r\n" + "\r\n\r\n"
//					+ "Response: "
//					+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getInput4241t1() : "")+"\r\n\r\n",font4));
//
//			
//			
////					PdfPCell cell0080131 = new PdfPCell(
////							new Paragraph("4.2.4.1: Total number of teachers and students" + "\r\n"
////					+ "Response: "
////					+ (criteria4Record != null ? criteria4Record.getCriteria42Qn().get(0).getInput4241t1() : ""),font4));
//
//					table15.addCell(cell00801);
//					table15.addCell(cell008013);
////					table15.addCell(cell0080131);
//			
////			table15.addCell(table14criteria4);
//
//			table15.setSpacingBefore(20f);
//			table15.setSpacingAfter(20f);
//
//			document.add(table15);
//			document.add(table14criteria4);

			
			
			///////////////////cr4.3
			Paragraph paragraph501111111 = new Paragraph("4.3: IT Infrastructure (30)\r\n\r\n", font2);
			paragraph501111111.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph501111111);
			
		
				
			
			
			
			/////////////////////////////////////////////
			
			PdfPTable table17criteria4 = new PdfPTable(2);
			PdfPTable table171criteria4 = new PdfPTable(1);
			
			table17criteria4.setWidthPercentage(100);
			table171criteria4.setWidthPercentage(100);
			
			PdfPCell cell431criteria4 = new PdfPCell(new Paragraph(
					"4.3.1	Institution frequently updates its IT facilities and provides sufficient bandwidth for internet connection\r\n"
					+ "\r\n\r\n"
							+ "Response:"
							+ (criteria4Record != null
									? criteria4Record.getCriteria43Ql().get(0).getResponse431()
									: "")+"\r\n\r\n",font4));
			table171criteria4.addCell(cell431criteria4);
			
			
			PdfPCell cell0091 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell0091.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0092 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell0092.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0093 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
			cell0093.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0094 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell0094.setExtraParagraphSpace(20);
			cell0094.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0095 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n",font5));
			cell0095.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0096 = new PdfPCell(new Paragraph(" ",font5));
			cell0096.setHorizontalAlignment(Element.ALIGN_CENTER);

			table17criteria4.addCell(cell0091);
			table17criteria4.addCell(cell0092);
			table17criteria4.addCell(cell0093);
			table17criteria4.addCell(cell0094);
			table17criteria4.addCell(cell0095);
			table17criteria4.addCell(cell0096);

	
			document.add(table171criteria4);
			document.add(table17criteria4);

			// Creating a table of 3 columns
			PdfPTable table18criteria4 = new PdfPTable(2);
			PdfPTable table19criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table18criteria4.setWidthPercentage(100);
			table19criteria4.setWidthPercentage(100);

			table18criteria4.setSpacingAfter(20);
			table18criteria4.setSpacingAfter(20);
			
			PdfPCell cell0097 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell0097.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell0098 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell0098.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell0099 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
			cell0099.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell00100 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell00100.setExtraParagraphSpace(20);
			cell00100.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell00101 = new PdfPCell(new Paragraph("Student - computer ratio\r\n\r\n",font5));
			cell00101.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell00102 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell00102.setExtraParagraphSpace(20);
			cell00102.setHorizontalAlignment(Element.ALIGN_CENTER);


			table18criteria4.addCell(cell0097);
			table18criteria4.addCell(cell0098);
			table18criteria4.addCell(cell0099);
			table18criteria4.addCell(cell00100);
			table18criteria4.addCell(cell00101);
			table18criteria4.addCell(cell00102);


			PdfPCell cell001021 = new PdfPCell(
					new Paragraph("4.3.2 Student - Computer ratio (Data for the latest completed academic year)\r\n\r\n"
					 + "Response:"
					+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse432()
							: "")+"\r\n\r\n",font4));
			PdfPCell cell0010201 = new PdfPCell(
					new Paragraph("4.3.2.1: Number of computers available for students’ usage during the latest completed academic year: \r\n\r\n",font4));
			
			
//			 table19criteria4.addCell(criteria4List.getCriteria4FieldInfoQn().get(0).getResponseValue432());
			table19criteria4.addCell(cell001021);
			table19criteria4.addCell(cell0010201);

//			table19criteria4.addCell(table18criteria4);

			table19criteria4.setSpacingBefore(20f);
			table19criteria4.setSpacingAfter(20f);

			document.add(table19criteria4);
			document.add(table18criteria4);

			// Creating a table of 3 columns

			PdfPTable table20criteria4 = new PdfPTable(2);
			PdfPTable table21criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table20criteria4.setWidthPercentage(100);
			table21criteria4.setWidthPercentage(100);
			table20criteria4.setSpacingAfter(20f);
			table20criteria4.setSpacingBefore(20f);

			PdfPCell cell00103 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell00103.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00104 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell00104.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00105 = new PdfPCell(
					new Paragraph("Upload any additional information\r\n",font5));
			cell00105.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00106 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell00106.setExtraParagraphSpace(20);
			cell00106.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell001051 = new PdfPCell(
					new Paragraph("Upload any additional information\r\n",font5));
			cell001051.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell001061 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell001061.setExtraParagraphSpace(20);
			cell001061.setHorizontalAlignment(Element.ALIGN_CENTER);
			

			table20criteria4.addCell(cell00103);
			table20criteria4.addCell(cell00104);
			table20criteria4.addCell(cell00105);
			table20criteria4.addCell(cell00106);
			table20criteria4.addCell(cell001051);
			table20criteria4.addCell(cell001061);

			PdfPCell cell0010611 = new PdfPCell(
					new Paragraph("4.3.3: Institution has dedicated audio visual centre, mixing equipment editing facility, media studio, lecture capturing system(LCS) andrelated hardware and software for e-content development\r\nResponse:\r\n"
					+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse433()
							: "")+"\r\n\r\n\r\n",font4));

			// table21criteria4.addCell(criteria4List.get(0).getResponseValue433());

			table21criteria4.addCell(cell0010611);
//			table21criteria4.addCell(table20criteria4);
			document.add(table21criteria4);
			document.add(table20criteria4);
			table21criteria4.setSpacingBefore(20f);
			table21criteria4.setSpacingAfter(20f);


			// Creating a table of 3 columns

			PdfPTable table22criteria4 = new PdfPTable(2);
			PdfPTable table23criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table22criteria4.setWidthPercentage(100);
			table23criteria4.setWidthPercentage(100);

			PdfPCell cell00107 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell00107.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00108 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell00108.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00109 = new PdfPCell(new Paragraph("Upload Additional information\r\n\r\n",font5));
			cell00109.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00110 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell00110.setExtraParagraphSpace(20);
			cell00110.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell00110.setExtraParagraphSpace(10);
			
			PdfPCell cell00111 = new PdfPCell(new Paragraph(" Institutional data in prescribed format\r\n\r\n",font5));
			cell00111.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00112 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell00112.setExtraParagraphSpace(20);
			cell00112.setHorizontalAlignment(Element.ALIGN_CENTER);

			table22criteria4.addCell(cell00107);
			table22criteria4.addCell(cell00108);
			table22criteria4.addCell(cell00109);
			table22criteria4.addCell(cell00110);
			table22criteria4.addCell(cell00111);
			table22criteria4.addCell(cell00112);

//			PdfPCell cell00106110 = new PdfPCell(
//					new Paragraph("4.3.4 Institution has the following Facilities for e-content development\r\n" + "\r\n"
//					+ "1.	Media centre\r\n" + "2.	Audio visual centre\r\n" + "3.	Lecture Capturing System(LCS)\r\n"
//					+ "4.	Mixing equipments and softwares for editing\r\n" + "Response: "
//					+ (criteria4Record != null ? criteria4Record.getCriteria43Qn().get(0).getResponse434()
//							: "")+"\r\n\r\n",font4));
			

			// table23criteria4.addCell(criteria4List.get(0).getResponseValue434());
			//table23criteria4.addCell(cell00106110);
//			table23criteria4.addCell(table22criteria4);

			table23criteria4.setSpacingBefore(20f);
			table23criteria4.setSpacingAfter(20f);

			document.add(table23criteria4);
			document.add(table22criteria4);
			
			/////////////////cr4.4
			
			
			
			
			Paragraph paragraph50 = new Paragraph("4.4  Maintenance of Campus Infrastructure\r\n ", font2);
			paragraph50.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			document.add(paragraph50);

			// Creating a table of 3 columns

			PdfPTable table24criteria4 = new PdfPTable(5);
			PdfPTable table25criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table24criteria4.setWidthPercentage(100);
			table25criteria4.setWidthPercentage(100);

			table25criteria4.setSpacingBefore(20f);
			table25criteria4.setSpacingAfter(20f);
			
			PdfPCell cell00113 = new PdfPCell(new Paragraph("2020-21"));
			PdfPCell cell00114 = new PdfPCell(new Paragraph("2019-20"));
			PdfPCell cell00115 = new PdfPCell(new Paragraph("2018-19"));
			PdfPCell cell00116 = new PdfPCell(new Paragraph("2017-18"));
			PdfPCell cell00117 = new PdfPCell(new Paragraph("2016-17"));
			PdfPCell cell00118 = new PdfPCell(new Paragraph(" "));
			PdfPCell cell00119 = new PdfPCell(new Paragraph(" "));
			PdfPCell cell00120 = new PdfPCell(new Paragraph(" "));
			PdfPCell cell00121 = new PdfPCell(new Paragraph(" "));
			PdfPCell cell00122 = new PdfPCell(new Paragraph(" "));

			table24criteria4.addCell(cell00113);
			table24criteria4.addCell(cell00114);
			table24criteria4.addCell(cell00115);
			table24criteria4.addCell(cell00116);
			table24criteria4.addCell(cell00117);
			table24criteria4.addCell(cell00118);
			table24criteria4.addCell(cell00119);
			table24criteria4.addCell(cell00120);
			table24criteria4.addCell(cell00121);
			table24criteria4.addCell(cell00122);

			PdfPCell cell001121 = new PdfPCell(
					new Paragraph(
					"4.4.1Percentage expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary , during the last five years\r\n\r\n"
							+ " Response: "
							+ (criteria4Record != null
									? criteria4Record.getCriteria44Ql().get(0).getResponse441()
									: "")+"\r\n\r\n",font4));

			// table25criteria4.addCell(criteria4List.get(0).getResponseValue441());

			PdfPCell cell0011211 = new PdfPCell(
					new Paragraph(
					"4.4.1.1: Expenditure incurred on maintenance of physical facilities and academic support facilities excluding salary component year wise during last five years (INR in lakhs)\r\n\r\n",font4));

			table25criteria4.addCell(cell001121);
			table25criteria4.addCell(cell0011211);

			table25criteria4.setSpacingBefore(20f);
			table25criteria4.setSpacingAfter(20f);

			document.add(table25criteria4);
//			document.add(table24criteria4);
			

			if (criteria4Record.getYearTable4411() != null) {

				Table table4411 = new Table(criteria4Record.getYearTable4411().size(), 2);

				table4411.setPadding(5);
				table4411.setWidth(100f);

				for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
					
					
					Cell cell12criteria4 = new Cell(new Paragraph(criteria4Record.getYearTable4411().get(i).getInput4411y(),font5));
					cell12criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4411.addCell(cell12criteria4);
				}
				for (int i = 0; i < criteria4Record.getYearTable4411().size(); i++) {
					Cell cell121criteria4 = new Cell(new Paragraph(criteria4Record.getYearTable4411().get(i).getInput4411v(),font5));
					cell121criteria4.setHorizontalAlignment(Element.ALIGN_CENTER);
					table4411.addCell(cell121criteria4);
				}

				document.add(table4411);

			}

			PdfPTable table26criteria4 = new PdfPTable(2);
			table26criteria4.setWidthPercentage(100);
			table26criteria4.setSpacingAfter(20);
			table26criteria4.setSpacingBefore(20);
			
			PdfPCell cell00123 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell00123.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00124 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell00124.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00125 = new PdfPCell(new Paragraph(
					"Upload any additional information\r\n ",font5));
			cell00125.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00126 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));cell00126.setExtraParagraphSpace(20);
			cell00126.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00127 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n ",font5));
			cell00127.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00128 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			
			cell00128.setExtraParagraphSpace(20);
			cell00128.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPCell cell001271 = new PdfPCell(new Paragraph("Details about assigned budget and expenditure on physical facilities and academic facilities",font5));
			cell001271.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell001281 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell001281.setExtraParagraphSpace(20);
			cell001281.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table26criteria4.addCell(cell00123);
			table26criteria4.addCell(cell00124);
			table26criteria4.addCell(cell00125);
			table26criteria4.addCell(cell00126);
			table26criteria4.addCell(cell00127);
			table26criteria4.addCell(cell00128);
			table26criteria4.addCell(cell001271);
			table26criteria4.addCell(cell001281);

			document.add(table26criteria4);

			/*
			 * Font fontParagraph47 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			 * fontParagraph47.setSize(12);
			 */
//
//			Paragraph paragraph51 = new Paragraph(
//					"4.4.2 There are established systems and procedures for maintaining and utilizing physical, academic and support facilities - laboratory, library, sports complex, computers, classrooms etc.\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria4Record != null
//									? criteria4Record.getCriteria44Ql().get(0).getResponse442()
//									: ""),
//					font2);
//			document.add(paragraph51);
//			

			PdfPTable table442criteria4 = new PdfPTable(1);

			// Setting width of table, its columns and spacing
			table442criteria4.setWidthPercentage(100);

			PdfPCell cell00128110 = new PdfPCell(
					new Paragraph(
					"4.4.2 There are established systems and procedures for maintaining and utilizing physical and academic support facilities – laboratory,library, sports complex, computers, classrooms etc.\r\n\r\n"
							 + "Response:"
							+ (criteria4Record != null
									? criteria4Record.getCriteria44Ql().get(0).getResponse442()
									: "")+"\r\n\r\n",font4));
			// table442criteria4.addCell(criteria4List.get(0).getResponseValue442());
			table442criteria4.addCell(cell00128110);
			
			document.add(table442criteria4);

			table442criteria4.setSpacingBefore(20f);
			table442criteria4.setSpacingAfter(20f);

//			paragraph51.setAlignment(Paragraph.ALIGN_JUSTIFIED);

			/*
			 * Font fontParagraph48 = FontFactory.getFont(FontFactory.HELVETICA);
			 * fontParagraph48.setSize(12);
			 */

//			Paragraph paragraph52 = new Paragraph(
//					" The Maintenance Cell of the college ensures proper functioning of all civil, electrical, water, sewage, environment, and other facilities through frequent inspections and need-based maintenance works. A central complaint register is maintained, and the maintenance cell attends to those complaints on a priority basis. A vast majority of minor and major repairs are carried out internally, while some major repairs are outsourced. The maintenance cell is headed by the Registrar/Dean-Administration. The other members of the cell include Administrative Maintenance in-charge, Head of EEE department, and two senior faculty members, one each from Civil Engineering and Mechanical Engineering departments. The members of the cell meet based on the need and review the requirements to chalk out further action to be taken. The cell also arranges to conduct energy audit. Staff belonging to the maintenance cell perform routine cleaning of the water tanks, water coolers, filters, etc. as per schedule. Preventive maintenance of the equipment is a regular practice in all laboratories apart from breakdown maintenance. Gardeners and janitors conduct regular cleaning of the campus premises and restrooms twice a day.\r\n"
//							+ "\r\n"
//							+ "The regular maintenance of all the seminar halls of the institution, Open air auditorium, Portico of Block-2, open air grounds, playground etc. are supervised by the Administrative Officer. The Faculty/students put a letter in the prescribed format (mentioning the date and time of requirement) seeking the allocation of the required physical facility for the respective events to be organized. After the allocation as per the availability, such information is entered in a register kept with the Administrative officer.\r\n"
//							+ "\r\n"
//							+ "All OHP/LCD projectors in the institution, furniture available in the classroom, faculty/staff rooms are regularly monitored on a fortnightly basis for maintenance.\r\n"
//							+ "\r\n"
//							+ "Each laboratory maintains a stock register for detailing the proper lab records. The lab stock register holds\r\n"
//							+ " \r\n"
//							+ "the complete details of lab equipment, new arrivals, replacements of old equipment, maintenance details, license details etc. Each lab is associated with a qualified Technical Staff for maintenance of all lab equipment. Any major repair of equipment beyond the scope of technical staff is outsourced. Obsolete and irreparable equipment is weeded out on regular basis. A register for �Lab equipment Repair/ Maintenance� is kept in each lab to track the breakdown time of equipment and the maintenance details. A minimum of 20% to 30% of unutilized lab slots per week are allotted for regular maintenance works of the laboratories.\r\n"
//							+ "\r\n"
//							+ "The college has a central computing facility located in the library building, which is also used for browsing and accessing electronic content of learning resources.\r\n"
//							+ "\r\n"
//							+ "The institution has established a separate maintenance cell, responsible for the maintenance works of computers, Hardware and software installations/up-gradations, wi-fi and internet maintenance. The cell is chaired by a senior faculty from Computer Science Engineering department who supervises the supporting staff required for this purpose.\r\n"
//							+ "",
//					font5);
//			paragraph52.setAlignment(Paragraph.ALIGN_JUSTIFIED);

//			document.add(paragraph51);
//			document.add(paragraph52);

			PdfPTable table27criteria4 = new PdfPTable(2);
			table27criteria4.setWidthPercentage(100);

			PdfPCell cell00129 = new PdfPCell(new Paragraph("File Description\r\n\r\n", font4));
			cell00129.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00130 = new PdfPCell(new Paragraph("Document\r\n\r\n", font4));
			cell00130.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00093 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n",font5));
			cell00093.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00094 = new PdfPCell(
					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell00094.setExtraParagraphSpace(20);
			cell00094.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00131 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n",font5));
			cell00131.setHorizontalAlignment(Element.ALIGN_CENTER);
			PdfPCell cell00132 = new PdfPCell(new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : "",font5));
			cell00132.setExtraParagraphSpace(20);
			cell00132.setHorizontalAlignment(Element.ALIGN_CENTER);
			table27criteria4.addCell(cell00129);
			table27criteria4.addCell(cell00130);
			table27criteria4.addCell(cell00093);
			table27criteria4.addCell(cell00094);
			table27criteria4.addCell(cell00131);
			table27criteria4.addCell(cell00132);

			table27criteria4.setSpacingBefore(20f);
			table27criteria4.setSpacingAfter(20f);

			document.add(table27criteria4);
			
			
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file.toAbsolutePath().toString();
	}

	

}
