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
//import com.adiverse.erp.model.Criteria6_FieldInfo;
//import com.adiverse.erp.model.Criteria6_FileUpload;
//import com.adiverse.erp.service.Criteria2Service;
//import com.adiverse.erp.service.Criteria4Service;
//import com.adiverse.erp.service.Criteria6Service;
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
//public class AffiliatedCriteria64Report {
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
//	Criteria6Service service6;
//	
//	
//	List<Criteria6_FieldInfo> criteria6List = null;
//	Criteria6_FieldInfo criteria6Record = null;
//	List<Criteria6_FileUpload> criteria6file = null;
//	
//	
//	public String generateReport() throws DocumentException, IOException {
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
//			criteria6List = service6.getAllCriteria6Data();
//			if (CollectionUtils.isNotEmpty(criteria6List)) {
//				criteria6Record = criteria6List.get(0);
//				criteria6file = criteria6Record.getCriteria6FileUpload();
//			} else {
//				criteria6Record = new Criteria6_FieldInfo();
//				criteria6file = new ArrayList<>();
//			}
//
//			System.out.println("report generation path from property file ==>" + reportGeneratePath);
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "AffiliatedCriteria6Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//			
//			Document document = new Document(PageSize.A4);
//			// PdfWriter.getInstance(document, response.getOutputStream());
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//			
//			document.open();
//			System.out.println("open the document==========>");
//			
//			Paragraph paragraph1criteria6 = new Paragraph("Criterion 6 - Governance, Leadership and Management\r\n\r\n", font1);
//			paragraph1criteria6.setAlignment(Paragraph.ALIGN_JUSTIFIED);
//			document.add(paragraph1criteria6);
//
//			/*
//			 * com.lowagie.text.Font fontTitle0 =
//			 * FontFactory.getFont(FontFactory.HELVETICA_BOLD); fontTitle0.setSize(12);
//			 */
//
//
//	//create 6.4
//			Paragraph paragraph13criteria6 = new Paragraph("6.4	Financial Management and Resource Mobilization\r\n\r\n\r\n\r\n", font3);
//			paragraph13criteria6.setAlignment(Paragraph.ALIGN_LEFT);
//			document.add(paragraph13criteria6);
//	//create table10
//			PdfPTable table10criteria6 = new PdfPTable(2);
//			table10criteria6.setWidthPercentage(100);
//
//			com.lowagie.text.Font fontTitle5criteria6 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//			fontTitle5criteria6.setSize(10);
//
//			PdfPTable table101criteria6 = new PdfPTable(1);
//			table101criteria6.setWidthPercentage(100);
//
//			PdfPCell cell10x = new PdfPCell(new Paragraph(
//					"6.4.1	Institution conducts internal and external financial audits regularl:"+" Response:" + (criteria6Record != null
//					? criteria6Record.getCriteria6FieldInfoQn().get(0).getResponse642(): font3)));
//			table101criteria6.addCell(cell10x);
//			
//
//
//			PdfPCell cell100= new PdfPCell(new Paragraph(criteria6Record != null? criteria6Record.getCriteria6FieldInfoQl().get(0).getInput641t1():"", font3));
//			table101criteria6.addCell(cell100);
//			
//			
//			
//
//			PdfPCell cell101criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell102criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell103criteria6 = new PdfPCell(new Paragraph(" Upload Any additional information"));
//			PdfPCell cell104criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(26).getCriteria6FilePath() : "")));
//			PdfPCell cell105criteria6 = new PdfPCell(new Paragraph("Paste link for additional information"));
//			PdfPCell cell106criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(27).getCriteria6FilePath() : "")));
//			
//			table10criteria6.addCell(cell101criteria6);
//			table10criteria6.addCell(cell102criteria6);
//			table10criteria6.addCell(cell103criteria6);
//			table10criteria6.addCell(cell104criteria6);
//			table10criteria6.addCell(cell105criteria6);
//			table10criteria6.addCell(cell106criteria6);
//			
//			table101criteria6.addCell(
//					"A: Internal financial audit: The college constitutes an internal committee for conducting verification of assets/capital equipment as well as financial audit. The committee checks financial reporting compliance with policies as well as compliance with respect to legal aspects including applicability of the trust/society. The internal audit also verifies the achievement of operational goals and objectives, safe guarding of assets, effective and efficient use of resources.\r\n"
//							+ "\r\n"
//							+ "Audit of assets and capital equipment are conducted through stock verification by the committee and based on shortages reported, if any, action for write-off is taken with the approval of the competent authority and such items are removed from the asset registers. Similar action is taken in respect of books/journals/documents.\r\n"
//							+ "\r\n"
//							+ "The internal audit committee, besides inspecting the books of account and records maintained by the finance department, evaluates internal control system, particularly, in respect of purchases, scholarships etc. The audit report is submitted to Principal/Chairman and subsequently Principal directs departments to take follow up action for closing the deficiencies and making changes in systems and procedures as called for.\r\n"
//							+ "\r\n"
//							+ "B: External financial audit: Mother Teresa arranges to conduct external financial audit every year by an external auditing agency named Haribabu and Associates, a registered financial auditing company, located in Hyderabad. The same auditing agency has been conducting external audit since the inception of our college, i.e.,2005. The auditors verify the financial statements and books of accounts to certify the truth and fairness of the financial position and operating system prevalent. The auditors employ internal check by verifying arithmetical accuracy of books of accounts, authentication and validation of transaction and also checking the proper distinction between capital and revenue nature of transactions. Except for transactions involving petty amounts, all other payments are made by way of issuing account payee cheques, demand drafts and using the fund transfer facility of banks such as NEFT/RTGS, to maintain transparency and to minimize errors may likely to occur due to cash transactions. This makes the job of our auditor simple and more easy. The audit observations submitted to the management by the audit company are examined carefully and corrective actions taken, if any, wherever required. At the end of every financial year, IT returns are filed to income tax department. These include, income and expenditure statements audited by a chartered accountant.\r\n"
//							+ "\r\n"
//							+ "All the audit reports have been found to be in order. However, prior to external audit an internal audit is conducted through a Chartered Accountant (CA). In case of any errors. identified by CA, they will be rectified by the internal accounts staff as per the suggestion by the CA. These minor errors, if and when crept in, due to any oversight by accounting personnel, is verified and rectified, resulting in strengthening of the financial accounting and budgetary control systems.\r\n"
//							+ " \r\n" + "");
//			table101criteria6.addCell(table10criteria6);
//			table101criteria6.setSpacingAfter(10f);
//			document.add(table101criteria6);
//	//create table 11
//			PdfPTable table11criteria6 = new PdfPTable(1);
//			table11criteria6.setWidthPercentage(100);
//			PdfPCell cell11x = new PdfPCell(new Paragraph(
//					"6.4.2 Funds / Grants received from non-government bodies, individuals, philanthropists during the last five years (not covered in Criterion III and V) (INR in Lakhs)\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria6Record != null
//									? criteria6Record.getCriteria6FieldInfoQn().get(0).getResponse642()
//									: ""),
//					font3));
//			
//			
//			
//			PdfPCell cell11y = new PdfPCell(new Paragraph(
//					"6.4.2.1 Total Grants received from non-government bodies, individuals, Philanthropers year-wise during the last five years (INR in Lakhs)"
//							+ "",
//					font3));
//			table11criteria6.addCell(cell11x);
//			table11criteria6.addCell(cell11y);
//			document.add(table11criteria6);
//	//create table 6421
//
//			if (criteria6Record != null) {
//
//				Table table6421 = new Table(criteria6Record.getYearTable6421().size(), 2);
//
//				table6421.setPadding(10);
//				table6421.setWidth(100f);
//
//				for (int i = 0; i < criteria6Record.getYearTable6421().size(); i++) {
//					table6421.addCell(criteria6Record.getYearTable6421().get(i).getInput6421y());
//				}
//				for (int i = 0; i < criteria6Record.getYearTable6341().size(); i++) {
//					table6421.addCell(criteria6Record.getYearTable6421().get(i).getInput6421v());
//				}
//
//				document.add(table6421);
//			}
//
//			PdfPTable table111criteria6 = new PdfPTable(2);
//			table111criteria6.setWidthPercentage(100);
//			PdfPCell cell111criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n\r\n", font3));
//			PdfPCell cell112criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n\r\n", font3));
//			PdfPCell cell113criteria6 = new PdfPCell(new Paragraph("Details of Funds / Grants received from of the nongovernment bodies, individuals, Philanthropers during the last five years\r\n\r\n\r\n\r\n"));
//			PdfPCell cell114criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(28).getCriteria6FilePath() : "")));
//			PdfPCell cell115criteria6 = new PdfPCell(new Paragraph("Any additional information\r\n\r\n\r\n"));
//			PdfPCell cell116criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(29).getCriteria6FilePath() : "")));
//			PdfPCell cell117criteria6 = new PdfPCell(new Paragraph("Annual statements of accounts\r\n\r\n\r\n"));
//			PdfPCell cell118criteria6 = new PdfPCell(
//					new Paragraph((criteria6Record != null ? criteria6file.get(30).getCriteria6FilePath() : "")));
//			
//			table111criteria6.addCell(cell111criteria6);
//			table111criteria6.addCell(cell112criteria6);
//			table111criteria6.addCell(cell113criteria6);
//			table111criteria6.addCell(cell114criteria6);
//			table111criteria6.addCell(cell115criteria6);
//			table111criteria6.addCell(cell116criteria6);
//			table111criteria6.addCell(cell117criteria6);
//			table111criteria6.addCell(cell118criteria6);
//			
//			document.add(table111criteria6);
//	//CREATE TABLE12
//			PdfPTable table12criteria6 = new PdfPTable(1);
//			table12criteria6.setWidthPercentage(100);
//			PdfPTable table121x = new PdfPTable(1);
//			table121x.setWidthPercentage(100);
//
//			PdfPCell cell12Y = new PdfPCell(new Paragraph(
//					"6.4.3 Institutional strategies for mobilisation of funds and the optimal utilisation of resources Response:\r\n"
//							+ "Resource Mobilization Policy and Procedures\r\n" + "\r\n" + "\r\n"
//							+ "The policy of Mother Teresa with regard to mobilization of funds is as follows:\r\n" + "\r\n"
//							+ "\r\n"
//							+ "Internal: Tuition fee, NBA fee, Training fee, transport fee and other miscellaneous fees collected from students.\r\n"
//							+ "\r\n" + "\r\n" + "External:\r\n" + "",
//					font3));
//			table12criteria6.addCell(cell12Y);
//			document.add(table12criteria6);
//			table121x.addCell(
//					"Procedure: The accounts section of the college prepares, month-wise cash flow statements, at least two months in advance. The cash outflow statement is based on institutional budget estimates and additional inputs form departments for unanticipated major expenses, and contingency expenses. The cash inflow (income) statement is prepared based on the schedules for admissions, commencement of classes indicated in the Academic calendar, and examination time tables. The Accounts department notifies the fee payment schedules to students to align with cash requirements as per projected cash inflow statement. If there are indications of fee collection being short of estimates, vigorous efforts are made through academic department staff and fee counselor to increase the receipts. The gap between the actual income and the estimated expenses is bridged through loans from banks/non-bank financial institutions as per the policy guidelines.\r\n"
//							+ "\r\n"
//							+ "Periodically, a review of the adequacy of limits for term and operational loans sanctioned by banks is carried out by the college management and the Principal. If the sanctioned limits are found to be inadequate, the banks are approached for enhancement of the sanctioned limits, with proper justification.\r\n"
//							+ "");
//			table121x.addCell(table12criteria6);
//			document.add(table121x);
//
//	//create table 121
//			PdfPTable table121criteria6 = new PdfPTable(2);
//			table121criteria6.setWidthPercentage(100);
//			PdfPCell cell121criteria6 = new PdfPCell(new Paragraph("FileDiscription\r\n\r\n\r\n", font3));
//			PdfPCell cell122criteria6 = new PdfPCell(new Paragraph("Document\r\n\r\n\r\n", font3));
//			PdfPCell cell123criteria6 = new PdfPCell(new Paragraph("Upload any additional information\r\n\r\n\r\n"));
//			PdfPCell cell124criteria6 = new PdfPCell(new Paragraph(criteria6Record != null ? criteria6file.get(31).getCriteria6FilePath() :""));
//			PdfPCell cell125criteria6 = new PdfPCell(new Paragraph("Paste link for additional information \r\n\r\n\r\n"));
//			PdfPCell cell126criteria6 = new PdfPCell(new Paragraph(criteria6Record != null ? criteria6file.get(32).getCriteria6FilePath() :""));
//			table121criteria6.addCell(cell121criteria6);
//			table121criteria6.addCell(cell122criteria6);
//			table121criteria6.addCell(cell123criteria6);
//			table121criteria6.addCell(cell124criteria6);
//			table121criteria6.addCell(cell125criteria6);
//			table121criteria6.addCell(cell126criteria6);
//			
//			document.add(table121criteria6);
//
//	
//		
//			
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
