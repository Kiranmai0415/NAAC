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
//import com.adiverse.erp.model.Criteria4_FieldInfo;
//import com.adiverse.erp.model.Criteria4_FileUpload;
//import com.adiverse.erp.service.Criteria4Service;
//import com.lowagie.text.Chunk;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.CMYKColor;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//@Service
//public class AutonomousCriteria43Report {
//	
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//	
//	@Autowired
//	Criteria4Service service4;
//	
//	
//	
//	
//	
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//	
//	
//
//	List<Criteria4_FieldInfo> criteria4List = null;
//	Criteria4_FieldInfo criteria4Record = null;
//	List<Criteria4_FileUpload> criteria4file = null;
//	
//
//public String generateReport(Criteria4_FieldInfo criteria4Fieldinfo) throws DocumentException, IOException {
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
//			
//
//			criteria4List = service4.getAllCriteria4Data();
//			if (CollectionUtils.isNotEmpty(criteria4List)) {
//				criteria4Record = criteria4List.get(0);
//				criteria4file = criteria4Record.getCriteria4FileUpload();
//			} else {
//				criteria4Record = new Criteria4_FieldInfo();
//				criteria4file = new ArrayList<>();
//			}
//
//
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AuthonomousCriteria4Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//				
//			
//		
//			Document document = new Document(PageSize.A4);
//			// PdfWriter.getInstance(document, response.getOutputStream());
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>");
//	
//			
//			
//			
//
//			Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources", font1);
//			paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph1criteria4);
//
//			/*
//			 * Font font1criteria4 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * font1criteria4.setSize(14);
//			 */
//
//		
//
//			Paragraph paragraph38criteria4 = new Paragraph("4.3 Infrastructure\r\n", font1);
//			paragraph38criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph35 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph35.setSize(12);
//			 */
//
////			Paragraph paragraph39criteria4 = new Paragraph(
////					"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n\r\n",font2);
////			paragraph39criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph36 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph36.setSize(12);
//			 */
//
//			
//			/*
//			 * Font fontParagraph37 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph37.setSize(12);
//			 */
//
////			Paragraph paragraph41 = new Paragraph(
////					"Mother Teresa considers that in the current information age no organization can survive without extensive use of IT. Towards this, the college has developed an IT policy encompassing all IT/IT enabled services used in the campus, ensuring smooth functioning with adequate security to all users connected to the campus network.\r\n"
////							+ "\r\n"
////							+ "Based on the laboratory and other requirements, every year college allocates budget for updating its IT facilities for procurement of computer systems and other IT related equipment including software.\r\n"
////							+ "\r\n"
////							+ "Every user in the campus is provided access to the campus network as well as internet.\r\n"
////							+ "\r\n"
////							+ "48 LCD projectors have been installed in class rooms and labs with wi-fi/internet connectivity.\r\n"
////							+ "\r\n"
////							+ "All students and faculty are given email accounts with college domain name through GSuite. The college has installed two firewalls in order to protect all its internal systems from cyber attacks.\r\n"
////							+ " \r\n"
////							+ "The college also installed CISCO switches for monitoring traffic in the campus network.\r\n"
////							+ "",
////					font5);
////			paragraph41.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph38 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph38.setSize(12);
//			 */
//
////			Paragraph paragraph42 = new Paragraph("The details of up-dation as follows:", font2);
////			paragraph42.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			/*
////			 * Font fontParagraph39 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph39.setSize(12);
////			 */
////
////			Paragraph paragraph43criteria4 = new Paragraph("AY 2020-21\r\n" + "\r\n"
////					+ "1.	Procured 320 Lenovo computers of core i5 of 16GB RAM, 1TB HDD.\r\n"
////					+ "2.	Provided ICT Facilities in 06 class rooms\r\n"
////					+ "3.	Internet facility was upgraded from 210 Mbps to 1000 Mbps with two distinct service providers.\r\n"
////					+ "4.	ACT (Atria Convergence Technologies Ltd) Fibre (500Mbps).\r\n"
////					+ "5.D-Vios Communications Pvt Ltd.(500Mbps).\r\n" + " ", font5);
////			paragraph43criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph40 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph40.setSize(12);
//			 */
////
////			Paragraph paragraph44 = new Paragraph("AY 2019-20\r\n" + "\r\n"
////					+ "1.	Provided ICT Facilities in 04 class rooms\r\n"
////					+ "2.	Established Robotics Learning and Development Centre Lab in collaboration with Smart Bridge Educational Services Pvt. Ltd.\r\n"
////					+ "3.	Procured 256 Acer computers of core i5 of 8GB RAM, 1TB HDD.\r\n"
////					+ "4.	Installed Firewall �Sophos XG Firewall� for exam branch.\r\n" + " ", font5);
////			paragraph44.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph41 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph41.setSize(12);
//			 */
////
////			Paragraph paragraph45 = new Paragraph("AY 2019-20\r\n" + "\r\n"
////					+ "1.	Provided ICT Facilities in 04 class rooms\r\n"
////					+ "2.	Established Robotics Learning and Development Centre Lab in collaboration with Smart Bridge Educational Services Pvt. Ltd.\r\n"
////					+ "3.	Procured 256 Acer computers of core i5 of 8GB RAM, 1TB HDD.\r\n"
////					+ "4.	Installed Firewall �Sophos XG Firewall� for exam branch.\r\n" + " ", font5);
////			paragraph45.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph42 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph42.setSize(12);
//			 */
//
////			Paragraph paragraph46 = new Paragraph("AY 2018-19\r\n" + "\r\n"
////					+ "1.	Installed Firewall \"Sonicwall NSA 3600� for securing campus network.\r\n"
////					+ "2.	Provided ICT Facilities in 09 class rooms\r\n"
////					+ "3.	Established one more Computing centre with 100 systems each.\r\n"
////					+ "4.	Increased number of computer systems in existing Computing centre from 48 to 100.\r\n"
////					+ "5.	Anti-virus: Quick Heal Seqrite EPS antivirus software (500 Users) has been installed for all the systems with Windows OS.\r\n"
////					+ "6.	Procured 216 Acer computers of core i3 with 4GB RAM, 1TB HDD and 60 Lenovo Computers of core i3 with 4GB RAM, 1TB HDD.\r\n"
////					+ "7.	Internet facility was upgraded from 132 Mbps to 210 Mbps with two distinct service providers.\r\n"
////					+ "\r\n"
////
////					+ " ", font5);
////			paragraph46.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph43 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph43.setSize(12);
//			 */
////
////			Paragraph paragraph47 = new Paragraph("AY 2017-18\r\n" + "\r\n"
////					+ "1.	Procured 72 Acer computers of core i5 with 4GB RAM and 1TB HDD, 151 Acer computers of core i3 with 4GB RAM, 1 TB HDD and 170 Assembled computers of Dual Core with 4GB RAM, 1 TB HDD.\r\n"
////					+ "2.	Internet facility was upgraded from 48 Mbps to 132 Mbps with two distinct service providers.\r\n"
////
////					+ ":", font5);
////			paragraph47.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph44 = FontFactory.getFont(FontFactory.HELVETICA);
//			 * fontParagraph44.setSize(12);
//			 */
//
////			Paragraph paragraph48 = new Paragraph("AY 2016-17\r\n" + "\r\n"
////					+ "1.	Intra-net connectivity is provided on the campus with 20 Gbps fibre-optic cable over and above the Reliance Jio campus wi-fi for daily usage of 1GB/User.\r\n"
////					+ "2.	Established IBM Software Lab for Emerging Technologies in collaboration with IBM.\r\n"
////					+ "3.	Procured 302 Assembled computers of Dual Core with 2GB RAM, 500GB HDD.\r\n" + "", font5);
////			paragraph48.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			/*
//			 * Font fontParagraph45 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph45.setSize(12);
//			 */
//
////			Paragraph paragraph49 = new Paragraph("Year wise Allocated Budget for IT facilities:" + "", font3);
////			paragraph49.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph38criteria4);
//			//document.add(paragraph39criteria4);
//			//document.add(paragraph40);
////			document.add(paragraph41);
////			document.add(paragraph42);
////			document.add(paragraph43criteria4);
////			document.add(paragraph44);
////			document.add(paragraph45);
////			document.add(paragraph46);
////			document.add(paragraph47);
////			document.add(paragraph48);
////			document.add(paragraph49);
//
//			// Creating a table of 3 columns
//
//			//PdfPTable table16criteria4 = new PdfPTable(5);
//			PdfPTable table17criteria4 = new PdfPTable(2);
//
//			// Setting width of table, its columns and spacing
//			//table16criteria4.setWidthPercentage(100);
//			table17criteria4.setWidthPercentage(100);
//
////			PdfPCell cell0081 = new PdfPCell(new Paragraph("Budget allocated for IT facilities"));
////			PdfPCell cell0082 = new PdfPCell(new Paragraph("2016-17"));
////			PdfPCell cell0083 = new PdfPCell(new Paragraph("2017-2018"));
////			PdfPCell cell0084 = new PdfPCell(new Paragraph("2018-2019"));
////			PdfPCell cell0085 = new PdfPCell(new Paragraph("2019-2020"));
////			PdfPCell cell0086 = new PdfPCell(new Paragraph(" "));
////			PdfPCell cell0087 = new PdfPCell(new Paragraph("50,45,018"));
////			PdfPCell cell0088 = new PdfPCell(new Paragraph("96,97,574 "));
////			PdfPCell cell0089 = new PdfPCell(new Paragraph("79,75,787"));
////			PdfPCell cell0090 = new PdfPCell(new Paragraph("89,95,799 "));
////
////			table16criteria4.addCell(cell0081);
////			table16criteria4.addCell(cell0082);
////			table16criteria4.addCell(cell0083);
////			table16criteria4.addCell(cell0084);
////			table16criteria4.addCell(cell0085);
////			table16criteria4.addCell(cell0086);
////			table16criteria4.addCell(cell0087);
////			table16criteria4.addCell(cell0088);
////			table16criteria4.addCell(cell0089);
////			table16criteria4.addCell(cell0090);
////
////			table16criteria4.setSpacingBefore(20f);
////			table16criteria4.setSpacingAfter(20f);
////
////			document.add(table16criteria4);
//
//			PdfPCell cell0091 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell0092 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell0093 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell0094 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			PdfPCell cell0095 = new PdfPCell(new Paragraph("Paste link for additional information\r\n\r\n\r\n"));
//			PdfPCell cell0096 = new PdfPCell(new Paragraph(" "));
//
//			table17criteria4.addCell(cell0091);
//			table17criteria4.addCell(cell0092);
//			table17criteria4.addCell(cell0093);
//			table17criteria4.addCell(cell0094);
//			table17criteria4.addCell(cell0095);
//			table17criteria4.addCell(cell0096);
//			
//			
//			
//			PdfPCell cell431criteria4 = new PdfPCell(new Paragraph(
//					"4.3.1	Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities\r\n"));
//							
//							
//
//			PdfPCell cell4301criteria4 = new PdfPCell(new Paragraph( (criteria4Fieldinfo != null
//									? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse431()
//									: "")));			
//			table17criteria4.addCell(cell431criteria4);
//			table17criteria4.addCell(cell4301criteria4);
//			
////			table17criteria4.addCell(table16criteria4);
////			table17criteria4.addCell(table16criteria4);
//			document.add(table17criteria4);
//
//			// Creating a table of 3 columns
//			PdfPTable table18criteria4 = new PdfPTable(2);
//			PdfPTable table19criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table18criteria4.setWidthPercentage(100);
//			table19criteria4.setWidthPercentage(100);
//
//			PdfPCell cell0097 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell0098 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell0099 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell00100 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			PdfPCell cell00101 = new PdfPCell(new Paragraph("Student - computer ratio\r\n\r\n\r\n"));
//			PdfPCell cell00102 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//
//			table18criteria4.addCell(cell0097);
//			table18criteria4.addCell(cell0098);
//			table18criteria4.addCell(cell0099);
//			table18criteria4.addCell(cell00100);
//			table18criteria4.addCell(cell00101);
//			table18criteria4.addCell(cell00102);
//
//			table19criteria4.addCell("4.3.2 Student - Computer ratio (Data for the latest completed academic year)\r\n"
//					+ "\r\n\r\n" + "Response:"
//					+ (criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse432()
//							: ""));
//			
//
//			table19criteria4.addCell(table18criteria4);
//
//			table19criteria4.setSpacingBefore(20f);
//			table19criteria4.setSpacingAfter(20f);
//
//			document.add(table19criteria4);
//
//			// Creating a table of 3 columns
//
//			PdfPTable table20criteria4 = new PdfPTable(2);
//			PdfPTable table21criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table20criteria4.setWidthPercentage(100);
//			table21criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00103 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell00104 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00105 = new PdfPCell(
//					new Paragraph("Details of available bandwidth of internet connection in the Institution\r\n\r\n\r\n"));
//			PdfPCell cell00106 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//
//			table20criteria4.addCell(cell00103);
//			table20criteria4.addCell(cell00104);
//			table20criteria4.addCell(cell00105);
//			table20criteria4.addCell(cell00106);
//
//			table21criteria4.addCell("4.3.3 Bandwidth of internet connection in the Institution.\r\n" + "\r\n" + "Response:"
//					+ (criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse433()
//							: ""));
//
//			
//
//			table21criteria4.addCell(table20criteria4);
//			document.add(table21criteria4);
//
//			// Creating a table of 3 columns
//
//			PdfPTable table22criteria4 = new PdfPTable(2);
//			PdfPTable table23criteria4 = new PdfPTable(1);
//
//			// Setting width of table, its columns and spacing
//			table22criteria4.setWidthPercentage(100);
//			table23criteria4.setWidthPercentage(100);
//
//			PdfPCell cell00107 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell00108 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00109 = new PdfPCell(new Paragraph("Upload Additional information\r\n\r\n\r\n"));
//			PdfPCell cell00110 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			PdfPCell cell00111 = new PdfPCell(new Paragraph(" Institutional data in prescribed format\r\n\r\n\r\n"));
//			PdfPCell cell00112 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//
//			table22criteria4.addCell(cell00107);
//			table22criteria4.addCell(cell00108);
//			table22criteria4.addCell(cell00109);
//			table22criteria4.addCell(cell00110);
//			table22criteria4.addCell(cell00111);
//			table22criteria4.addCell(cell00112);
//
//			table23criteria4.addCell("4.3.4	Institution has the following Facilities for e-content development\r\n" + "\r\n"
//					+ "1.	Media centre\r\n" + "2.	Audio visual centre\r\n" + "3.	Lecture Capturing System(LCS)\r\n"
//					+ "4.	Mixing equipments and softwares for editing\r\n" + "\r\n" + "\r\n" + "\r\n" + "Response: "
//					+ (criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQn().get(0).getResponse434()
//							: ""));
//
//		
//			table23criteria4.addCell(table22criteria4);
//
//			table23criteria4.setSpacingBefore(20f);
//			table23criteria4.setSpacingAfter(20f);
//
//			document.add(table23criteria4);
//
//			/*
//			 * Font fontParagraph46 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			 * fontParagraph46.setSize(12);
//			 */
//
//		
//
//			document.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//	}
//
//		
//
//}	
//
//
//
