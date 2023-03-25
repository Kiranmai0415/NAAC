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
//import javax.print.Doc;
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
//public class AffiliatedCriteria43Report {
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
//			Paragraph paragraph1criteria4 = new Paragraph("Criterion 4 - Infrastructure and Learning Resources", font1);
//			paragraph1criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//			document.add(paragraph1criteria4);
//
//			
//		
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//			Paragraph paragraph38criteria4 = new Paragraph("4.3  IT Infrastructure", font1);
//			paragraph38criteria4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//
//	         document.add(paragraph38criteria4);
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
////
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
//
//////			
////			 * Font fontParagraph42 = FontFactory.getFont(FontFactory.HELVETICA);
////			Paragraph paragraph45 = new Paragraph("AY 2019-20\r\n" + "\r\n"
//////					+ "1.	Provided ICT Facilities in 04 class rooms\r\n"
////					+ "2.	Established Robotics Learning and Development Centre Lab in collaboration with Smart Bridge Educational Services Pvt. Ltd.\r\n"
////					+ "3.	Procured 256 Acer computers of core i5 of 8GB RAM, 1TB HDD.\r\n"
////					+ "4.	Installed Firewall �Sophos XG Firewall� for exam branch.\r\n" + " ", font5);
////			paragraph45.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
//////			/* * fontParagraph42.setSize(12);
////			 */
////
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
//
////			Paragraph paragraph47 = new Paragraph("AY 2017-18\r\n" + "\r\n"
////					+ "1.	Procured 72 Acer computers of core i5 with 4GB RAM and 1TB HDD, 151 Acer computers of core i3 with 4GB RAM, 1 TB HDD and 170 Assembled computers of Dual Core with 4GB RAM, 1 TB HDD.\r\n"
////					+ "2.	Internet facility was upgraded from 48 Mbps to 132 Mbps with two distinct service providers.\r\n"
////
////					+ ":", font5);
////			paragraph47.setAlignment(Paragraph.ALIGN_JUSTIFIED);
////
////			/*
////			 * Font fontParagraph44 = FontFactory.getFont(FontFactory.HELVETICA);
////			 * fontParagraph44.setSize(12);
////			 */
////
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
////
////			//document.add(paragraph38criteria4);
////			//document.add(paragraph39criteria4);
////			//document.add(paragraph40);
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
//
//			
//			
//			
//	Paragraph paragraph1criteria41 = new Paragraph("4.3.1: Institution has an IT policy covering wi-fi, cyber security, etc., and allocated budget for updating its IT facilities");
//			
//			document.add(paragraph1criteria41);
//			
//			Paragraph paragraph1criteria42 = new Paragraph((criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getResponse431():""));	
//			
//				document.add(paragraph1criteria42);
//				
//				PdfPTable table17criteria4 = new PdfPTable(2);
//				table17criteria4.setWidthPercentage(100);
//
//				PdfPCell cell0091 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//				PdfPCell cell0092 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//				PdfPCell cell0093 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//				PdfPCell cell0094 = new PdfPCell(
//						new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//				PdfPCell cell0095= new PdfPCell(new Paragraph("Paste link for additional information\r\n"));
//				PdfPCell cell0096 = new PdfPCell(
//						new Paragraph(criteria4Record != null ? criteria4file.get(1).getCriteria4FilePath() : ""));
//				
//				
//				
//				
//				table17criteria4.addCell(cell0091);
//				table17criteria4.addCell(cell0092);
//				table17criteria4.addCell(cell0093);
//				table17criteria4.addCell(cell0094);
//				table17criteria4.addCell(cell0095);
//				table17criteria4.addCell(cell0096);
//			    document.add(table17criteria4);
//			    
//			
//				Paragraph paragraph1criteria43 = new Paragraph("4.3.2: Student - Computer ratio (Data for the latest completed academic year)");
//			
//			document.add(paragraph1criteria43);
//			
//			Paragraph paragraph1criteria44 = new Paragraph("Number of students:");
//			document.add(paragraph1criteria44);
//			Paragraph paragraph1criteria45 = new Paragraph((criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getInput431t1():""));
//			document.add(paragraph1criteria45);
//			
//			Paragraph paragraph1criteria46 = new Paragraph("Number of computers:");
//			document.add(paragraph1criteria46);
//			Paragraph paragraph1criteria47 = new Paragraph((criteria4Fieldinfo != null ? criteria4Fieldinfo.getCriteria4FieldInfoQl().get(0).getInput431t1():""));
//			document.add(paragraph1criteria47);
//			
//			PdfPTable table17criteria41 = new PdfPTable(2);
//			table17criteria41.setWidthPercentage(100);
//			PdfPTable table15 = new PdfPTable(1);
//			table15.setWidthPercentage(100);
//			PdfPCell cell00911 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
//			PdfPCell cell00921 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell00931 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell00941 = new PdfPCell(
//					new Paragraph(criteria4Record != null ? criteria4file.get(0).getCriteria4FilePath() : ""));
//			
//			table17criteria41.addCell(cell00911);
//			table17criteria41.addCell(cell00921);
//			table17criteria41.addCell(cell00931);
//			table17criteria41.addCell(cell00941);
//			
//			document.add(table17criteria41);
//			
//			
//			
//			
////		
////			PdfPTable table17criteria4 = new PdfPTable(2);
////			PdfPCell cell0091 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
////			PdfPCell cell0092 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
////			PdfPCell cell0093 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
////			PdfPCell cell0094 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(18).getCriteria4FilePath() : ""));
////			
////			table17criteria4.addCell(cell0091);
////			table17criteria4.addCell(cell0092);
////			table17criteria4.addCell(cell0093);
////			table17criteria4.addCell(cell0094);
////			
////
////			PdfPCell cell431criteria4 = new PdfPCell(new Paragraph(
////					"4.3.1	 Institution frequently updates its IT facilities including Wi-Fi\r\n"
////							+ "\r\n\r\n" + "Response:"
////							+ (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQl().get(0).getResponse431()
////									: ""),font3));
////			PdfPCell cell4310criteria4 = new PdfPCell(new Paragraph(
////					 (criteria4Record != null
////									? criteria4Record.getCriteria4FieldInfoQl().get(0).getInput431t1()
////									: "")));
////			
////			table17criteria4.addCell(cell431criteria4);
////			table17criteria4.addCell(cell4310criteria4);
////			
////			document.add(table17criteria4);
////
////		
////			PdfPTable table18criteria4 = new PdfPTable(2);
////			PdfPTable table19criteria4 = new PdfPTable(1);
////
////			
////			table18criteria4.setWidthPercentage(100);
////			table19criteria4.setWidthPercentage(100);
////
////			PdfPCell cell0097 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
////			PdfPCell cell0098 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
////			PdfPCell cell0099 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
////			PdfPCell cell00100 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(19).getCriteria4FilePath() : ""));
////			PdfPCell cell00101 = new PdfPCell(new Paragraph("Student - computer ratio\r\n\r\n\r\n"));
////			PdfPCell cell00102 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(20).getCriteria4FilePath() : ""));
////
////			table18criteria4.addCell(cell0097);
////			table18criteria4.addCell(cell0098);
////			table18criteria4.addCell(cell0099);
////			table18criteria4.addCell(cell00100);
////			table18criteria4.addCell(cell00101);
////			table18criteria4.addCell(cell00102);
////
//////			table19criteria4.addCell("4.3.2 Student - Computer ratio (Data for the latest completed academic year)\r\n"
//////					+ "\r\n\r\n" + "Response:"
//////					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse432()
//////							: ""));
////			
////			
////			PdfPCell cell4301criteria4 = new PdfPCell(new Paragraph(
////					"4.3.2 Student - Computer ratio (Data for the latest completed academic year)\r\n"
////							+ "\r\n\r\n" + "Response:"
////							+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse432()
////								: ""),font3));
////			table18criteria4.addCell(cell4301criteria4);
////			table19criteria4.addCell( (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getInput432t2()
////							: ""));
////			
////
////			table19criteria4.addCell(table18criteria4);
////
////			table19criteria4.setSpacingBefore(20f);
////			table19criteria4.setSpacingAfter(20f);
////
////			document.add(table19criteria4);
////
////			// Creating a table of 3 columns
////
////			PdfPTable table20criteria4 = new PdfPTable(2);
////			PdfPTable table21criteria4 = new PdfPTable(1);
////
////			// Setting width of table, its columns and spacing
////			table20criteria4.setWidthPercentage(100);
////			table21criteria4.setWidthPercentage(100);
////
////			PdfPCell cell00103 = new PdfPCell(new Paragraph("File Description\r\n\r\n\r\n", font3));
////			PdfPCell cell00104 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
////			PdfPCell cell00105 = new PdfPCell(
////					new Paragraph("Upload any additional Information\r\n\r\n\r\n"));
////			PdfPCell cell00106 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(21).getCriteria4FilePath() : ""));
////			
////			
////			PdfPCell cell00107 = new PdfPCell(
////					new Paragraph("Details of available bandwidth of internet connection in the Institution\r\n\r\n\r\n"));
////			PdfPCell cell00108 = new PdfPCell(
////					new Paragraph(criteria4Record != null ? criteria4file.get(22).getCriteria4FilePath() : ""));
////
////			table20criteria4.addCell(cell00103);
////			table20criteria4.addCell(cell00104);
////			table20criteria4.addCell(cell00105);
////			table20criteria4.addCell(cell00106);
////			table20criteria4.addCell(cell00107);
////			table20criteria4.addCell(cell00108);
////			
////
////			table21criteria4.addCell("4.3.3 Bandwidth of internet connection in the Institution.\r\n" + "\r\n" + "Response:"
////					+ (criteria4Record != null ? criteria4Record.getCriteria4FieldInfoQn().get(0).getResponse433()
////							: ""));
////
////			// table21criteria4.addCell(criteria4List.get(0).getResponseValue433());
////
////			table21criteria4.addCell(table20criteria4);
////			document.add(table21criteria4);
////
////
////			
////	/////////////////////////////////////////////////////////////////////////////////////////	
//
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
