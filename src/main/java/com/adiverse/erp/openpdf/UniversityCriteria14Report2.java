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
//import com.adiverse.erp.model.Criteria1_FieldInfo;
//import com.adiverse.erp.model.Criteria1_FileUpload;
//import com.adiverse.erp.service.Criteria1Service;
//import com.lowagie.text.Chunk;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.Element;
//import com.lowagie.text.Font;
//import com.lowagie.text.FontFactory;
//import com.lowagie.text.PageSize;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.Phrase;
//import com.lowagie.text.Table;
//import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfWriter;
//
//@Service
//public class UniversityCriteria14Report2 {
//
//	@Value("${upload.files.path}")
//	private String reportGeneratePath;
//
//	public Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//	public Font font4 = FontFactory.getFont(FontFactory.HELVETICA);
//	public Font font5 = FontFactory.getFont(FontFactory.HELVETICA);
//
//	@Autowired
//	Criteria1Service service1;
//
//	List<Criteria1_FieldInfo> criteria1List = null;
//
//	Criteria1_FieldInfo criteria1Record = null;
//
//	List<Criteria1_FileUpload> criteria1file = null;
//
//	public String generateReport(Criteria1_FieldInfo criteria1Fieldinfo) throws DocumentException, IOException {
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
//			criteria1List = service1.getAllCriteria1Data();
//			if (CollectionUtils.isNotEmpty(criteria1List)) {
//				System.out.println("is empty===>" + criteria1List.get(0));
//				// System.out.println("criteria1Record.getCriteria1FileUpload()======>"+criteria1Record.getCriteria1FileUpload().size());
//				criteria1Record = criteria1List.get(0);
//				criteria1file = criteria1Record.getCriteria1FileUpload();
//			} else {
//				criteria1Record = new Criteria1_FieldInfo();
//				criteria1file = new ArrayList<Criteria1_FileUpload>();
//			}
//
//			if (root != null) {
//				SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
//				String strDate = formatter.format(date);
//				reportPath = "UniversityCriteria1Report-" + strDate + ".pdf";
//				file = root.resolve(reportPath);
//			}
//			System.out.println("reportPath is ==>" + file.toAbsolutePath().toString());
//
//			Document document = new Document(PageSize.A4);
//
//			PdfWriter.getInstance(document, new FileOutputStream(file.toAbsolutePath().toString()));
//
//			document.open();
//			System.out.println("open the document==========>");
//
//			Paragraph paragraph67 = new Paragraph("\r\n 1.4  Feedback System\r\n", font3);
//			paragraph67.setAlignment(Paragraph.ALIGN_LEFT);
//			document.add(paragraph67);
//
//			PdfPTable table110 = new PdfPTable(1);
//			table110.setWidthPercentage(100);
//			table110.addCell(
//					"1.4.1 Structured feedback for design and review of syllabus � semester-wise / year-wise is received from 1) Students, 2) Teachers, 3) Employers, 4) Alumni\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse141()
//									: ""));
//
//			document.add(table110);
//
//			PdfPTable table111 = new PdfPTable(2);
//			table111.setWidthPercentage(100);
//
//			PdfPCell cell111 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell112 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell113 = new PdfPCell(new Paragraph("\r\nURL for stakeholder feedback report\r\n"));
//			PdfPCell cell114 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
//			PdfPCell cell115 = new PdfPCell(new Paragraph(
//					"Action taken report of the Institution on feedback report as minuted by the Governing Council,Syndicate, Board of Management"));
//			PdfPCell cell116 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
//			PdfPCell cell117 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"));
//			PdfPCell cell118 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
//
//			table111.addCell(cell111);
//			table111.addCell(cell112);
//			table111.addCell(cell113);
//			table111.addCell(cell114);
//			table111.addCell(cell115);
//			table111.addCell(cell116);
//			table111.addCell(cell117);
//			table111.addCell(cell118);
//			document.add(table111);
//			table111.setSpacingBefore(20);
//			table111.setSpacingAfter(20);
//
//			
//
//			// create table12
//
//			PdfPTable table11 = new PdfPTable(1);
//			table11.setWidthPercentage(100);
//
//			table11.addCell(
//					"1.4.2: The feedback system of the Institution comprises of the following :\r\n"
//					+ "A.Feedback collected, analysed and action taken and report made available on website\r\n"
//					+ "B. Feedback collected, analysed and action taken\r\n"
//					+ "C. Feedback collected and analysed\r\n"
//					+ "D. Feedback collected\r\n"
//					+ "E. Feedback not obtained\r\n"
//							+ "\r\n" + "Response:"
//							+ (criteria1Fieldinfo != null
//									? criteria1Fieldinfo.getCriteria1FieldInfoQn().get(0).getResponse142()
//									: ""));
//
//			document.add(table11);
//
//			PdfPTable table12 = new PdfPTable(2);
//			table12.setWidthPercentage(100);
//
//			PdfPCell cell121 = new PdfPCell(new Paragraph("\r\nFileDiscription\r\n", font3));
//			PdfPCell cell122 = new PdfPCell(new Paragraph("\r\nDocument\r\n", font3));
//			PdfPCell cell123 = new PdfPCell(new Paragraph("\r\nAny additional information\r\n"));
//			PdfPCell cell124 = new PdfPCell(
//					new Paragraph((criteria1file.size() > 0) ? criteria1file.get(1).getCriteria1FilePath() : ""));
//			PdfPCell cell125 = new PdfPCell(new Paragraph("\r\nURL for stakeholder feedback report\r\n"));
//			PdfPCell cell126 = new PdfPCell(new Paragraph((criteria1file.size() > 0 && criteria1file.contains(26))
//					? criteria1file.get(2).getCriteria1FilePath()
//					: ""));
//
//			table12.addCell(cell121);
//			table12.addCell(cell122);
//			table12.addCell(cell123);
//			table12.addCell(cell124);
//			table12.addCell(cell125);
//			table12.addCell(cell126);
//
//			table12.setSpacingAfter(20f);
//			table12.setSpacingAfter(20f);
//
//			document.add(table12);
//
//			document.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return file.toAbsolutePath().toString();
//	}
//
//}
