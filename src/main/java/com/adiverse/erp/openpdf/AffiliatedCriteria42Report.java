//package com.adiverse.erp.openpdf;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.apache.commons.collections4.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.adiverse.erp.model.Criteria2_FieldInfo;
//import com.adiverse.erp.model.Criteria2_FileUpload;
//import com.adiverse.erp.model.Criteria4_FieldInfo;
//import com.adiverse.erp.model.Criteria4_FileUpload;
//import com.adiverse.erp.service.Criteria2Service;
//import com.adiverse.erp.service.Criteria4Service;
//import com.lowagie.text.Chunk;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.Image;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.CMYKColor;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//@Service
//public class AffiliatedCriteria42Report {
//	
//	
//
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//
//	public Image headerImage;
//
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//
//	
//	@Autowired
//	Criteria4Service service4;
//	
//	List<Criteria4_FieldInfo> criteria4List = null;
//	Criteria4_FieldInfo criteria4Record = null;
//	List<Criteria4_FileUpload> criteria4file = null;
//	
//	
//	public String generateReport(Criteria4_FieldInfo criteria4Fieldinfo) throws DocumentException, IOException {
//		String reportPath = "";
//		Path root = Paths.get(reportGeneratePath);
//		Path file = null;
//		Date date = new Date();
//		try {
//			font1.setSize(16);
//			font2.setSize(14);
//			font3.setSize(12);
//			font4.setSize(14);
//			font5.setSize(12);
//			
//			criteria4List = service4.getAllCriteria4Data();
//			if (CollectionUtils.isNotEmpty(criteria4List)) {
//				criteria4Record = criteria4List.get(0);
//				criteria4file = criteria4Record.getCriteria4FileUpload();
//			} else {
//				criteria4Record = new Criteria4_FieldInfo();
//				criteria4file = new ArrayList<>();
//			}
//			  if (root != null) {
//					SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//					String strDate = formatter.format(date);
//					reportPath = "AffiliatedCriteria4Report-" + strDate + ".pdf";
//					file = root.resolve(reportPath);
//				}
//			
//			Document document = new Document(PageSize.A4);
//			// PdfWriter.getInstance(document, response.getOutputStream());
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>");
//			
////			Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources", font1);
////			paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			document.add(paragraph1criteria4);
//
//			
//	
//
//	///////////////////////////////		/////////////////////////////////////////////////////////
//			// 4.2
//			
//			Paragraph paragraph31criteria4 = new Paragraph("4.2 Library as a Learning Resource\r\n\r\n\r\n", font1);
//			document.add(paragraph31criteria4);
//			paragraph31criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			Paragraph paragraph31criteria41 = new Paragraph(
//					"4.2.1	Library is automated using Integrated Library Management System (ILMS)\r\n" + "Response");
//			
//			document.add(paragraph31criteria41);
//			if(criteria4Fieldinfo.getCriteria4FieldInfoQl() !=null)
//			{
//			Paragraph paragraph31criteria42 = new Paragraph((criteria4Fieldinfo != null
//					? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse421()
//					: ""));
//			document.add(paragraph31criteria42);
//			}
//			
//			
//			
//			PdfPTable table14criteria4 = new PdfPTable(2);
//			PdfPTable table15 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table14criteria4.setWidthPercentage(100);
//			table15.setWidthPercentage(100);
//
//			PdfPCell cell0075 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n",font3));
//			PdfPCell cell0076 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n",font3));
//			PdfPCell cell0077 = new PdfPCell(new Paragraph("Upload any additional information\r\n"));
//			PdfPCell cell0078 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			PdfPCell cell0079 = new PdfPCell(new Paragraph("Paste link for additional information\r\n"));
//			PdfPCell cell0080 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//
//			table14criteria4.addCell(cell0075);
//			table14criteria4.addCell(cell0076);
//			table14criteria4.addCell(cell0077);
//			table14criteria4.addCell(cell0078);
//			table14criteria4.addCell(cell0079);
//			table14criteria4.addCell(cell0080);
//			
//			
//			
//			
//			document.add(table14criteria4);
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
////			paragraph32criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			PdfPTable table421criteria4 = new PdfPTable(1);
////
////			// Setting width of table, its columns and spacing
////			table421criteria4.setWidthPercentage(100);
////
////			table421criteria4.addCell(
////					"4.2.1 Library is automated using Integrated Library Management System (ILMS)\r\n\r\n+ Response:"
////							+ (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse421()
////									: ""));
////			table421criteria4.addCell(
////					(criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQl().get(0).getInput421t1()
////									: ""));
////			
////			
////			
////			// table421criteria4.addCell(criteria4List.get(3).getResponseValue421());
////			document.add(table421criteria4);
////
////			table421criteria4.setSpacingBefore(20f);
////			table421criteria4.setSpacingAfter(20f);
////			document.add(table421criteria4);
////
////			/*
////			 * Font fontParagraph29 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			 * fontParagraph29.setSize(12);
////			 */
////
////			Paragraph paragraph33criteria4 = new Paragraph("4.2 Response:"
////					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse421()
////							: ""),
////					font3);
////			paragraph33criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			/*
////			 * Font fontParagraph30 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph30.setSize(12);
////			 */
////
////			Paragraph paragraph34criteria4 = new Paragraph(
////					"Mother Teresa has a spacious central library in an independent building with an area of 1064 Sqm. spread over two floors. Ground Floor is accommodating OPAC, periodicals, News Papers, digital library, thesis, reprography and special reference. First floor is accommodating circulation, references, periodical back volumes, computer centre etc. It is having a modern infrastructure with a seating capacity of 250 students. ",
////					font5);
////			paragraph34criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			/*
////			 * Font fontParagraph31 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph31.setSize(12);
////			 */
////
////			Paragraph paragraph35criteria4 = new Paragraph(
////					"Central Library is fully automated with Integrated Library Management Software, Ez School version\r\n"
////							+ "10.0.9.22 and On Edu software used for circulation, procurement, Online Public Access Catalogue (OPAC). All library documents are bar-coded and books are issued to users by scanning the barcode of the document\r\n"
////							+ " ",
////					font5);
////			paragraph35criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			/*
////			 * Font fontParagraph32 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph32.setSize(12);
////			 */
////
////			Paragraph paragraph36criteria4 = new Paragraph(
////					"Library & Information Centre provides uncompromising information and intellectual requirements to its students and faculty with user-friendly approach. It offers a fully integrated and dynamic environment for conducting academic study. Library is fully computerized with bar-coding system\r\n",
////					font5);
////			paragraph36criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			Paragraph paragraph361 = new Paragraph(" ", font5);
////			paragraph361.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			Chunk bullet7criteria4 = new Chunk("\u2022", font5);
////			paragraph361.add(bullet7criteria4);
////
////			paragraph361.add(new Phrase("Name of the ILMS software: Ez School Software and OnEdu Software\r\n", font5));
////
////			Paragraph paragraph362 = new Paragraph(" ", font5);
////			paragraph362.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			Chunk bullet8criteria4 = new Chunk("\u2022", font5);
////			paragraph362.add(bullet8criteria4);
////
////			paragraph362.add(new Phrase("Nature of automation (full or partial): Fully Automated/r/n", font5));
////
////			Paragraph paragraph363 = new Paragraph(" ", font5);
////			paragraph363.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			Chunk bullet9criteria4 = new Chunk("\u2022", font5);
////			paragraph363.add(bullet9criteria4);
////
////			paragraph363.add(new Phrase("Version: Ez School software 10.0.9.22 and OnEdu software/r/n", font5));
////
////			Paragraph paragraph364 = new Paragraph(" ", font5);
////			paragraph364.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////			Chunk bullet10criteria4 = new Chunk("\u2022", font5);
////			paragraph364.add(bullet10criteria4);
////
////			paragraph364.add(new Phrase("Year of automation :2009", font5));
////
////			/*
////			 * Font fontParagraph33 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph33.setSize(12);
////			 */
////
////			Paragraph paragraph37criteria4 = new Paragraph(
////					"The College has a Digital Library with 100 systems, connected to the college�s intranet, providing services, such as digitalized versions of question papers, syllabus, Articles of National and International standards, e-lectures of faculty of IITs, NPTEL, Textbooks, CD/DVDs, videos of Spoken English, video Films, Britannica Encyclopaedia, books for preparing towards GATE, GRE, TOFEL, CAT etc.\r\n"
////							+ "\r\n"
////							+ "Reference Section has various books including Personality Development Books and other books useful for student professional and career development.\r\n"
////							+ "\r\n"
////							+ "The Library has an Electronic Resource Centre (ERC) which provides access to vast stores of electronic information of IEEE, DELNET and unlimited number of digital, online open resource journals of Engineering, Applied Sciences, Management and other Internet-based service to its readers.\r\n"
////							+ "",
////					font5);
////			paragraph37criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			document.add(paragraph31criteria4);
////			document.add(paragraph32criteria4);
////			document.add(paragraph33criteria4);
////			document.add(paragraph34criteria4);
////			document.add(paragraph35criteria4);
////			document.add(paragraph36criteria4);
////			document.add(paragraph361);
////			document.add(paragraph362);
////			document.add(paragraph363);
////			document.add(paragraph364);
////			document.add(paragraph37criteria4);
////
////			// Creating a table of 3 columns
////			PdfPTable table8criteria4 = new PdfPTable(2);
////
////			// Setting width of table, its columns and spacing
////			table8criteria4.setWidthPercentage(100);
////
////			PdfPCell cell0041 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font1));
////			PdfPCell cell0042 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font5));
////			PdfPCell cell0043 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
////			PdfPCell cell0044 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(12).getCriteria4FilePath() : ""));
////			/*PdfPCell cell0045 = new PdfPCell(new Paragraph("Paste Link for additional information\r\n\r\n\r\n "));
////			PdfPCell cell0046 = new PdfPCell(new Paragraph(" "));*/
////
////			table8criteria4.addCell(cell0041);
////			table8criteria4.addCell(cell0042);
////			table8criteria4.addCell(cell0043);
////			table8criteria4.addCell(cell0044);
////			//table8criteria4.addCell(cell0045);
////			//table8criteria4.addCell(cell0046);
////
////			table8criteria4.setSpacingBefore(20f);
////			table8criteria4.setSpacingAfter(20f);
////			document.add(table8criteria4);
////
////			// Creating a table of 3 columns
////			PdfPTable table9criteria4 = new PdfPTable(2);
////			PdfPTable table10criteria4 = new PdfPTable(1);
////	        table9criteria4.setWidthPercentage(100);
////			table10criteria4.setWidthPercentage(100);
////
////			PdfPCell cell0047 = new PdfPCell(new Paragraph("FileDescription\r\n\r\n\r\n", font5));
////			PdfPCell cell0048 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font5));
////			PdfPCell cell0049 = new PdfPCell(new Paragraph("Details of subscriptions like e-journals, eShodhSindhu, Shodhganga Membership , Remote\r\n"
////					+ "access to library resources, Web interface etc (Data\r\n"
////					+ "Template)\r\n\r\n\r\n"));
////			PdfPCell cell0050 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(13).getCriteria4FilePath() : ""));
////			/*PdfPCell cell0051 = new PdfPCell(new Paragraph("Institutional data in prescribed format\r\n\r\n\r\n"));
////			PdfPCell cell0052 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(9).getCriteria4FilePath() : ""));
////			PdfPCell cell0053 = new PdfPCell(new Paragraph(
////					"Details of subscriptions like e-journals, e-books , e- ShodhSindhu, Shodhganga Membership etc\r\n\r\n\r\n"));
////			PdfPCell cell0054 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(10).getCriteria4FilePath() : ""));*/
////
////			table9criteria4.addCell(cell0047);
////			table9criteria4.addCell(cell0048);
////			table9criteria4.addCell(cell0049);
////			table9criteria4.addCell(cell0050);
////			/*table9criteria4.addCell(cell0051);
////			table9criteria4.addCell(cell0052);
////			table9criteria4.addCell(cell0053);
////			table9criteria4.addCell(cell0054);*/
////
////			table10criteria4.addCell(
////					"4.2.2  The institution has subscription for the following e-resources\r\n\r\n"+"1.e-journals \r\n"
////							+ "2.e-ShodhSindhu\r\n"
////							+ "3.Shodhganga Membership\r\n"
////							+ "4.e-books\r\n"
////							+ "5.Databases\r\n"
////							+ "6.Remote access to e-resources"
////							+ "\r\n\r\n\r\n" + "Response:"
////							+ (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse422()
////									: ""));
////			
////			table10criteria4.addCell(table9criteria4);
////
////			table10criteria4.setSpacingBefore(20f);
////			table10criteria4.setSpacingAfter(20f);
////
////			document.add(table10criteria4);
////
//////			// Creating a table of 3 columns
//////			PdfPTable table11criteria4 = new PdfPTable(5);
//////			PdfPTable table12criteria4 = new PdfPTable(1);
//////			table11criteria4.setWidthPercentage(100);
//////			table12criteria4.setWidthPercentage(100);
////	//
////	//
////	//
//////			table12criteria4.addCell(
//////					"4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n"
//////							+ "\r\n\r\n" + "Response: "
//////							+ (criteria4Record != null
//////									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse423()
//////									: ""));
//////			// table12criteria4.addCell(criteria4List.get(4).getResponseValue423());
////	//
//////			table12criteria4.addCell(
//////					"4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)"
//////							+ "\r\n\r\n\r\n");
////	//
//////			
//////			table12criteria4.setSpacingBefore(20f);
//////			table12criteria4.setSpacingAfter(20f);
//////	         document.add(table12criteria4);
//////	         
////			//Year table 4231
////
////			if (criteria4Record != null) {
////
////				Table table4231 = new Table(criteria4Record.getYearTable4231().size(), 2);
////
////				table4231.setPadding(10);
////				table4231.setWidth(100f);
////
////				for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
////					table4231.addCell(criteria4Record.getYearTable4231().get(i).getInput4231y());
////
////				}
////				for (int i = 0; i < criteria4Record.getYearTable4231().size(); i++) {
////					table4231.addCell(criteria4Record.getYearTable4231().get(i).getInput4231v());
////
////				}
////
////				document.add(table4231);
////			}
////
////			// Creating a table of 3 columns
////			Font font6criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
////			font6criteria4.setColor(CMYKColor.BLACK);
////			PdfPTable table13 = new PdfPTable(2);
////			PdfPTable table12criteria4 = new PdfPTable(1);
////
////			table13.setWidthPercentage(100);
////			table12criteria4.setWidthPercentage(100);
////
////			PdfPCell cell0065 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font6criteria4));
////			PdfPCell cell0066 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
////			PdfPCell cell0067 = new PdfPCell(new Paragraph(
////					"Details of annual expenditure for purchase of and subscription to journals/e-journals during the last five years\r\n\r\n\r\n"));
////			PdfPCell cell0068 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(14).getCriteria4FilePath() : ""));
////			PdfPCell cell0069 = new PdfPCell(new Paragraph("Audited statements of accounts\r\n\r\n\r\n"));
////			PdfPCell cell0070 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(15).getCriteria4FilePath() : ""));
////			table13.addCell(cell0065);
////			table13.addCell(cell0066);
////			table13.addCell(cell0067);
////			table13.addCell(cell0068);
////			table13.addCell(cell0069);
////			table13.addCell(cell0070);
////			table12criteria4.addCell("4.2.3 Average annual expenditure for purchase of books/ e-books and subscription to journals/e- journals during the last five years (INR in Lakhs)\r\n"
////					+ "Response:"+(criteria4Record != null
////				? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse423()
////				: ""));
////			
////			table12criteria4.addCell("4.2.3.1 Annual expenditure of purchase of books/e-books and subscription to journals/e- journals year wise during last five years (INR in Lakhs)");
////			table12criteria4.addCell(table13);
////			table12criteria4.setSpacingBefore(20f);
////			table12criteria4.setSpacingAfter(20f);
////	        document.add(table12criteria4);
////
////			
////			PdfPTable table14criteria4 = new PdfPTable(2);
////			PdfPTable table15 = new PdfPTable(1);
////
////			// Setting width of table, its columns and spacing
////			table14criteria4.setWidthPercentage(100);
////			table15.setWidthPercentage(100);
////
////			PdfPCell cell0075 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font6criteria4));
////			PdfPCell cell0076 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font6criteria4));
////			PdfPCell cell0077 = new PdfPCell(new Paragraph("Details of library usage by teachers and students\r\n\r\n\r\n"));
////			PdfPCell cell0078 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(16).getCriteria4FilePath() : ""));
////			PdfPCell cell0079 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
////			PdfPCell cell0080 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(17).getCriteria4FilePath() : ""));
////
////			table14criteria4.addCell(cell0075);
////			table14criteria4.addCell(cell0076);
////			table14criteria4.addCell(cell0077);
////			table14criteria4.addCell(cell0078);
////			table14criteria4.addCell(cell0079);
////			table14criteria4.addCell(cell0080);
////
////			table15.addCell(
////					"4.2.4  Percentage per day usage of library by teachers and students ( foot falls and login data for\r\n"
////					+ "online access) during the latest completed academic year\r\n"
////							+ "\r\n\r\n\r\n" + "Response: "
////							+ (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse424()
////									: ""));
////
////			// table15.addCell(criteria4List.get(0).getResponseValue424());
////
////			table15.addCell("4.2.4.1  Number of teachers and students using library per day over last one year\r\n" + "\r\n"
////					+ "Response: "
////					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getInput4241t1() : ""));
////
////			table15.addCell(table14criteria4);
////
////			table15.setSpacingBefore(20f);
////			table15.setSpacingAfter(20f);
////
////			document.add(table15);
////
////		
//
//			
//       document.close();
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//	}
//	
//
//
//}
